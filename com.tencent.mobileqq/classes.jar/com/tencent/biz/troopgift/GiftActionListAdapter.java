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
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class GiftActionListAdapter
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  protected ColorDrawable a;
  protected ArrayList<GiftConfigManager.ImgEntryItem> a;
  protected int b;
  
  protected void a(ImageView paramImageView, String paramString)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#f4f4f4"));
    }
    if (QLog.isColorLevel()) {
      QLog.d("GiftActionListAdapter", 2, "loadImage, url=" + paramString);
    }
    Object localObject2 = null;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.b;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
      }
      for (;;)
      {
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        }
        paramImageView.setBackgroundDrawable(paramString);
        return;
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
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("GiftActionListAdapter", 2, "loadImage exp: url=" + paramString, localException);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560766, paramViewGroup, false);
      ((RoundRelativeLayout)localView.findViewById(2131377393)).setRoundLayoutRadius(ScreenUtil.dip2px(3.0F));
      localObject = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
      ((ViewGroup.LayoutParams)localObject).height = this.b;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      localObject = (GiftConfigManager.ImgEntryItem)getItem(paramInt);
      a((ImageView)localView.findViewById(2131368865), ((GiftConfigManager.ImgEntryItem)localObject).a);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.GiftActionListAdapter
 * JD-Core Version:    0.7.0.1
 */