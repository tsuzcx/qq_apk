package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class MutiMemberThumbList
  extends FrameLayout
{
  private final int[] a = { 2131441188, 2131441189, 2131441190, 2131441191, 2131441192, 2131441193, 2131441194 };
  private final ArrayList<VideoController.GAudioFriends> b = new ArrayList();
  private String c = "";
  private final String d = "%d+";
  private long e = 0L;
  private int f = 0;
  private int g = -1;
  private VideoController h = null;
  private volatile boolean i = false;
  private GradientDrawable j;
  private View k;
  private boolean l = false;
  private long m = -1L;
  
  public MutiMemberThumbList(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MutiMemberThumbList(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MutiMemberThumbList(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
    this.c = getContext().getString(2131893381);
  }
  
  private void a(int paramInt, ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doDisplay ");
    localStringBuilder.append(paramInt);
    QLog.d("MutiMemberThumbList", 1, localStringBuilder.toString());
    ThreadManager.getSubThreadHandler().post(new MutiMemberThumbList.1(this, paramInt, paramArrayList));
  }
  
  private void b()
  {
    addView(LayoutInflater.from(getContext()).inflate(2131625768, null));
    this.i = false;
  }
  
  public void a()
  {
    this.i = true;
  }
  
  public void onDetachedFromWindow()
  {
    QLog.d("MutiMemberThumbList", 1, "onDetachedFromWindow ");
    super.onDetachedFromWindow();
    this.i = true;
  }
  
  public void setBitMapFetcher(VideoController paramVideoController)
  {
    this.h = paramVideoController;
  }
  
  public void setDisPlayList(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDisPlayList cost");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - this.m);
      QLog.d("MutiMemberThumbList", 1, ((StringBuilder)localObject).toString());
      this.b.clear();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (VideoController.GAudioFriends)paramArrayList.next();
        this.b.add(localObject);
      }
      a(this.b.size(), (ArrayList)this.b.clone());
      return;
    }
    setVisibility(4);
    this.m = System.currentTimeMillis();
    paramArrayList = new StringBuilder();
    paramArrayList.append("setDisPlayList ");
    paramArrayList.append(this.m);
    QLog.d("MutiMemberThumbList", 1, paramArrayList.toString());
  }
  
  public void setHeadImgMask(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setMoreInfoDrawableColor(String paramString)
  {
    int n = AIOUtils.b(32.0F, getResources());
    this.j = new GradientDrawable();
    this.j.setShape(1);
    this.j.setColor(Color.parseColor(paramString));
    this.j.setSize(n, n);
  }
  
  public void setRelatedView(View paramView)
  {
    this.k = paramView;
    this.k.setVisibility(4);
  }
  
  public void setRelationShipInfo(long paramLong, int paramInt)
  {
    this.e = paramLong;
    this.f = paramInt;
  }
  
  public void setTextColor(String paramString)
  {
    this.g = Color.parseColor(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MutiMemberThumbList
 * JD-Core Version:    0.7.0.1
 */