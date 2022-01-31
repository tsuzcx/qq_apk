package com.tencent.biz.publicAccountImageCollection;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import nda;

public class PublicAccountImageCollectionRecommendViewWrapper$PhotoAdapter
  extends BaseAdapter
{
  public PublicAccountImageCollectionRecommendViewWrapper$PhotoAdapter(PublicAccountImageCollectionRecommendViewWrapper paramPublicAccountImageCollectionRecommendViewWrapper) {}
  
  public PublicAccountImageCollectionUtils.RecommendItemInfo a(int paramInt)
  {
    if (PublicAccountImageCollectionRecommendViewWrapper.a != null) {
      return (PublicAccountImageCollectionUtils.RecommendItemInfo)PublicAccountImageCollectionRecommendViewWrapper.a.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (PublicAccountImageCollectionRecommendViewWrapper.a != null) {
      return PublicAccountImageCollectionRecommendViewWrapper.a.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(PublicAccountImageCollectionRecommendViewWrapper.a()).inflate(2130969195, paramViewGroup, false);
      paramViewGroup = new nda(this);
      localObject1 = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((PublicAccountImageCollectionRecommendViewWrapper.b() - AIOUtils.a(110.0F, PublicAccountImageCollectionRecommendViewWrapper.a().getResources())) / 3);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "height of item is" + ((ViewGroup.LayoutParams)localObject1).height);
      }
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131365569));
      localObject2 = paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = ((PublicAccountImageCollectionRecommendViewWrapper.c() - AIOUtils.a(2.0F, PublicAccountImageCollectionRecommendViewWrapper.a().getResources())) / 2);
      ((ViewGroup.LayoutParams)localObject2).height = (((ViewGroup.LayoutParams)localObject2).width * 9 / 16);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "height of image is" + ((ViewGroup.LayoutParams)localObject2).height);
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365570));
      if (((ViewGroup.LayoutParams)localObject1).height - ((ViewGroup.LayoutParams)localObject2).height - AIOUtils.a(40.0F, PublicAccountImageCollectionRecommendViewWrapper.a().getResources()) > AIOUtils.a(16.0F, PublicAccountImageCollectionRecommendViewWrapper.a().getResources()))
      {
        i = 2;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, " number is" + i);
        }
        if ((Build.MANUFACTURER.toLowerCase().contains("meizu")) && (Build.VERSION.SDK_INT <= 16))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "this is meizu");
          }
          localObject1 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject1).setMargins(12, 0, 12, 1);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 10.0F);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(i);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      localObject1 = a(paramInt);
      if (localObject1 != null)
      {
        localObject2 = ((PublicAccountImageCollectionUtils.RecommendItemInfo)localObject1).a;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
        localURLDrawableOptions.mFailedDrawable = localColorDrawable;
        localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 2)) {
          ((URLDrawable)localObject2).restartDownload();
        }
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PublicAccountImageCollectionUtils.RecommendItemInfo)localObject1).b);
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "recommendInfo position = " + paramInt + "; url =" + localObject2 + "; title = " + ((PublicAccountImageCollectionUtils.RecommendItemInfo)localObject1).b);
        }
      }
      return paramView;
      i = 1;
      break;
      paramViewGroup = (nda)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionRecommendViewWrapper.PhotoAdapter
 * JD-Core Version:    0.7.0.1
 */