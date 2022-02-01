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
    if (PublicAccountImageCollectionRecommendViewWrapper.b != null) {
      return (IPublicAccountImageCollectionUtils.RecommendItemInfo)PublicAccountImageCollectionRecommendViewWrapper.b.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (PublicAccountImageCollectionRecommendViewWrapper.b != null) {
      return PublicAccountImageCollectionRecommendViewWrapper.b.size();
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
      paramView = LayoutInflater.from(PublicAccountImageCollectionRecommendViewWrapper.b()).inflate(2131625613, paramViewGroup, false);
      paramViewGroup = new PublicAccountImageCollectionRecommendViewWrapper.PhotoAdapter.ViewHolder(this);
      localObject1 = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((PublicAccountImageCollectionRecommendViewWrapper.c() - AIOUtils.b(110.0F, PublicAccountImageCollectionRecommendViewWrapper.b().getResources())) / 3);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("height of item is");
        ((StringBuilder)localObject2).append(((ViewGroup.LayoutParams)localObject1).height);
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, ((StringBuilder)localObject2).toString());
      }
      paramViewGroup.a = ((URLImageView)paramView.findViewById(2131444449));
      localObject2 = paramViewGroup.a.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = ((PublicAccountImageCollectionRecommendViewWrapper.d() - AIOUtils.b(2.0F, PublicAccountImageCollectionRecommendViewWrapper.b().getResources())) / 2);
      ((ViewGroup.LayoutParams)localObject2).height = (((ViewGroup.LayoutParams)localObject2).width * 9 / 16);
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("height of image is");
        ((StringBuilder)localObject3).append(((ViewGroup.LayoutParams)localObject2).height);
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, ((StringBuilder)localObject3).toString());
      }
      paramViewGroup.b = ((TextView)paramView.findViewById(2131444465));
      int i;
      if (((ViewGroup.LayoutParams)localObject1).height - ((ViewGroup.LayoutParams)localObject2).height - AIOUtils.b(40.0F, PublicAccountImageCollectionRecommendViewWrapper.b().getResources()) > AIOUtils.b(16.0F, PublicAccountImageCollectionRecommendViewWrapper.b().getResources())) {
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
        paramViewGroup.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramViewGroup.b.setTextSize(1, 10.0F);
      }
      paramViewGroup.b.setMaxLines(i);
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
      paramViewGroup.a.setImageDrawable((Drawable)localObject2);
      paramViewGroup.b.setText(((IPublicAccountImageCollectionUtils.RecommendItemInfo)localObject1).b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionRecommendViewWrapper.PhotoAdapter
 * JD-Core Version:    0.7.0.1
 */