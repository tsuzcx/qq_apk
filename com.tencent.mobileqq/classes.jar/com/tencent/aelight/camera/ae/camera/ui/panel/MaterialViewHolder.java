package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class MaterialViewHolder
  extends RecyclerView.ViewHolder
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  public ImageView a;
  public RelativeLayout a;
  public AEDownLoadingView a;
  public URLImageView a;
  public ImageView b;
  public ImageView c;
  
  public MaterialViewHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2064122705));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122606));
    this.b = ((ImageView)paramView.findViewById(2064122119));
    this.c = ((ImageView)paramView.findViewById(2064122722));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2064122512));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2064122846));
  }
  
  private static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return 8;
  }
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    c(paramAEMaterialMetaData);
    e(paramAEMaterialMetaData);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(paramAEMaterialMetaData.a));
  }
  
  private void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.a())
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (paramAEMaterialMetaData.e)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (paramAEMaterialMetaData.jdField_f_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgress(paramAEMaterialMetaData.jdField_f_of_type_Int);
      return;
    }
    this.b.setVisibility(0);
    this.b.setImageResource(2064056681);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setVisibility(8);
  }
  
  private void d(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844642);
    c(paramAEMaterialMetaData);
    e(paramAEMaterialMetaData);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(paramAEMaterialMetaData.a));
  }
  
  private void e(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.a())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(2130846136);
      return;
    }
    if (paramAEMaterialMetaData.b())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(paramAEMaterialMetaData.a());
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void f(AEMaterialMetaData paramAEMaterialMetaData)
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          a(paramAEMaterialMetaData);
          return;
        }
        d(paramAEMaterialMetaData);
        g(paramAEMaterialMetaData);
        return;
      }
      b(paramAEMaterialMetaData);
      g(paramAEMaterialMetaData);
      return;
    }
    a(paramAEMaterialMetaData);
  }
  
  private void g(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (TextUtils.isEmpty(paramAEMaterialMetaData.m)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = AIOUtils.b(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2064056680);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mRetryCount = 3;
    paramAEMaterialMetaData = URLDrawable.getDrawable(paramAEMaterialMetaData.m, localURLDrawableOptions);
    if (paramAEMaterialMetaData.getStatus() == 2) {
      paramAEMaterialMetaData.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramAEMaterialMetaData);
  }
  
  public void a(int paramInt, AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_Int = paramInt;
    f(paramAEMaterialMetaData);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int i = AIOUtils.b(6.0F, paramContext.getResources());
    int j = AIOUtils.b(2.0F, paramContext.getResources());
    int k = AIOUtils.b(16.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setBgCorner(k / 2);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setMinimumHeight(k);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setMinimumWidth(k);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgressSizeAndMode(i, j, false);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setBgColor(-1);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgressColor(-16725252);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.MaterialViewHolder
 * JD-Core Version:    0.7.0.1
 */