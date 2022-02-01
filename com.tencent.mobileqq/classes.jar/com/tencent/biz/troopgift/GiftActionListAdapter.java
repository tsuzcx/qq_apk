package com.tencent.biz.troopgift;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRelativeLayout;
import java.util.ArrayList;

public class GiftActionListAdapter
  extends BaseAdapter
{
  protected ArrayList<GiftConfigManager.ImgEntryItem> a;
  protected Context b;
  protected ColorDrawable c;
  protected int d;
  protected int e;
  
  protected void a(ImageView paramImageView, String paramString)
  {
    if (this.c == null) {
      this.c = new ColorDrawable(Color.parseColor("#f4f4f4"));
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loadImage, url=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("GiftActionListAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.e;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.d;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.c;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.c;
        localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
      }
      else
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("GiftActionListAdapter", 2, "loadImage empty url");
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("loadImage exp: url=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.w("GiftActionListAdapter", 2, ((StringBuilder)localObject1).toString(), localException);
        localObject1 = localObject2;
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = this.c;
    }
    paramImageView.setBackgroundDrawable(paramString);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.b).inflate(2131626699, paramViewGroup, false);
      ((RoundRelativeLayout)localView.findViewById(2131445175)).setRoundLayoutRadius(ScreenUtil.dip2px(3.0F));
      localObject = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = this.d;
      ((ViewGroup.LayoutParams)localObject).height = this.e;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else
    {
      localView = paramView;
    }
    Object localObject = (GiftConfigManager.ImgEntryItem)getItem(paramInt);
    a((ImageView)localView.findViewById(2131435503), ((GiftConfigManager.ImgEntryItem)localObject).a);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.GiftActionListAdapter
 * JD-Core Version:    0.7.0.1
 */