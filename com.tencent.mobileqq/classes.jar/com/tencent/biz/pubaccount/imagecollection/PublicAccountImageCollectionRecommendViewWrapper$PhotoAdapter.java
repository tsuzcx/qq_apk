package com.tencent.biz.pubaccount.imagecollection;

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
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils.RecommendItemInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PublicAccountImageCollectionRecommendViewWrapper$PhotoAdapter
  extends BaseAdapter
{
  public PublicAccountImageCollectionRecommendViewWrapper$PhotoAdapter(PublicAccountImageCollectionRecommendViewWrapper paramPublicAccountImageCollectionRecommendViewWrapper) {}
  
  public IPublicAccountImageCollectionUtils.RecommendItemInfo a(int paramInt)
  {
    if (PublicAccountImageCollectionRecommendViewWrapper.a != null) {
      return (IPublicAccountImageCollectionUtils.RecommendItemInfo)PublicAccountImageCollectionRecommendViewWrapper.a.get(paramInt);
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
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(PublicAccountImageCollectionRecommendViewWrapper.a()).inflate(2131559584, paramViewGroup, false);
      paramViewGroup = new PublicAccountImageCollectionRecommendViewWrapper.PhotoAdapter.ViewHolder(this);
      localObject1 = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((PublicAccountImageCollectionRecommendViewWrapper.b() - AIOUtils.b(110.0F, PublicAccountImageCollectionRecommendViewWrapper.a().getResources())) / 3);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("height of item is");
        ((StringBuilder)localObject2).append(((ViewGroup.LayoutParams)localObject1).height);
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, ((StringBuilder)localObject2).toString());
      }
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131376241));
      localObject2 = paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = ((PublicAccountImageCollectionRecommendViewWrapper.c() - AIOUtils.b(2.0F, PublicAccountImageCollectionRecommendViewWrapper.a().getResources())) / 2);
      ((ViewGroup.LayoutParams)localObject2).height = (((ViewGroup.LayoutParams)localObject2).width * 9 / 16);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("height of image is");
        ((StringBuilder)localObject3).append(((ViewGroup.LayoutParams)localObject2).height);
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, ((StringBuilder)localObject3).toString());
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376257));
      int i;
      if (((ViewGroup.LayoutParams)localObject1).height - ((ViewGroup.LayoutParams)localObject2).height - AIOUtils.b(40.0F, PublicAccountImageCollectionRecommendViewWrapper.a().getResources()) > AIOUtils.b(16.0F, PublicAccountImageCollectionRecommendViewWrapper.a().getResources())) {
        i = 2;
      } else {
        i = 1;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" number is");
        ((StringBuilder)localObject1).append(i);
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, ((StringBuilder)localObject1).toString());
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
    else
    {
      paramViewGroup = (PublicAccountImageCollectionRecommendViewWrapper.PhotoAdapter.ViewHolder)paramView.getTag();
    }
    Object localObject1 = a(paramInt);
    if (localObject1 != null)
    {
      localObject2 = ((IPublicAccountImageCollectionUtils.RecommendItemInfo)localObject1).a;
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#000000"));
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = localColorDrawable;
      localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
      if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 2)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((IPublicAccountImageCollectionUtils.RecommendItemInfo)localObject1).b);
      if (QLog.isColorLevel())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("recommendInfo position = ");
        paramViewGroup.append(paramInt);
        paramViewGroup.append("; url =");
        paramViewGroup.append(localObject2);
        paramViewGroup.append("; title = ");
        paramViewGroup.append(((IPublicAccountImageCollectionUtils.RecommendItemInfo)localObject1).b);
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, paramViewGroup.toString());
      }
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionRecommendViewWrapper.PhotoAdapter
 * JD-Core Version:    0.7.0.1
 */