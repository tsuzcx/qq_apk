package com.tencent.av.ui.chatroom;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewCompat;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ChatRoomAdapter
  extends BaseAdapter
{
  private final LayoutInflater a;
  private final Context b;
  private int c;
  private int d;
  private List<VideoChatMessage> e = new ArrayList();
  
  public ChatRoomAdapter(Context paramContext)
  {
    this.b = paramContext;
    this.a = LayoutInflater.from(paramContext);
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.d = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    this.c = AIOUtils.b(14.0F, this.b.getResources());
  }
  
  private BitmapDrawable a(String paramString)
  {
    Object localObject = VideoController.f().k();
    int k = ((SessionInfo)localObject).g;
    int j = 1;
    int i = j;
    if (k != 1) {
      if (((SessionInfo)localObject).g == 2) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (i != 0)
    {
      localObject = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      return new BitmapDrawable(this.b.getResources(), ((VideoAppInterface)localObject).a(0, paramString, null, true, true));
    }
    paramString = VideoController.f().a(String.valueOf(paramString), String.valueOf(((SessionInfo)localObject).aN), ((SessionInfo)localObject).aQ, true, true);
    return new BitmapDrawable(this.b.getResources(), paramString);
  }
  
  private View a(LayoutInflater paramLayoutInflater, int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = paramLayoutInflater.inflate(paramInt2, paramViewGroup, false);
    }
    paramLayoutInflater = a(paramInt1);
    paramView = localView.findViewById(2131434878);
    paramViewGroup = (TextView)localView.findViewById(2131447062);
    paramView.setVisibility(0);
    paramView.setBackgroundDrawable(a(paramLayoutInflater.b()));
    paramViewGroup.setPadding(AIOUtils.b(10.0F, this.b.getResources()), AIOUtils.b(8.0F, this.b.getResources()), AIOUtils.b(10.0F, this.b.getResources()), AIOUtils.b(8.0F, this.b.getResources()));
    paramViewGroup.setText(paramLayoutInflater.a());
    paramViewGroup.setTextColor(-1);
    paramViewGroup.setSpannableFactory(QQText.SPANNABLE_FACTORY);
    ViewCompat.setAccessibilityDelegate(localView, new ChatRoomAdapter.1(this, paramLayoutInflater));
    return localView;
  }
  
  public VideoChatMessage a(int paramInt)
  {
    return (VideoChatMessage)this.e.get(paramInt);
  }
  
  public void a(VideoChatMessage paramVideoChatMessage)
  {
    this.e.add(paramVideoChatMessage);
    notifyDataSetChanged();
  }
  
  public void a(List<VideoChatMessage> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      VideoChatMessage.a(this.e);
    }
    this.e.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.e.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = a(this.a, paramInt, paramView, paramViewGroup, 2131625804);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.ChatRoomAdapter
 * JD-Core Version:    0.7.0.1
 */