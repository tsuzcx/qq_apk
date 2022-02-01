package com.tencent.mobileqq.activity.aio.intimate.view;

import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class IntimateContentItemGiftView$FriendGiftAdapter
  extends BaseAdapter
{
  private List<String> b;
  private int c = 0;
  
  private IntimateContentItemGiftView$FriendGiftAdapter(IntimateContentItemGiftView paramIntimateContentItemGiftView) {}
  
  public void a(List<String> paramList)
  {
    this.b = paramList;
    if (this.c == 0)
    {
      this.c = ((ViewUtils.getScreenWidth() - ViewUtils.dip2px(40.0F) - 80) / ViewUtils.dip2px(60.0F));
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("gif mark max count: ");
        paramList.append(this.c);
        QLog.d("intimate_relationship", 2, paramList.toString());
      }
      if (this.c <= 0) {
        this.c = 5;
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    int i = localList.size();
    int j = this.c;
    if (i > j) {
      return j;
    }
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @RequiresApi(api=16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2131625190, null);
    }
    ImageView localImageView = (ImageView)localView.findViewById(2131433795);
    paramView = (String)this.b.get(paramInt);
    if (!TextUtils.isEmpty(paramView)) {
      try
      {
        localObject = URLDrawable.getDrawable(paramView, null);
        ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.y);
        localImageView.setImageDrawable((Drawable)localObject);
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Url for friend gift:");
        ((StringBuilder)localObject).append(paramView);
        QLog.e("intimate_relationship", 1, String.format(((StringBuilder)localObject).toString(), new Object[] { localException }));
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemGiftView.FriendGiftAdapter
 * JD-Core Version:    0.7.0.1
 */