package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.NetworkUtil;

public class AEMaterialWaterMarkViewHolder
  extends RecyclerView.ViewHolder
{
  private Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  AEDownLoadingView jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public View b;
  ImageView b;
  ImageView c;
  ImageView d;
  ImageView e;
  
  public AEMaterialWaterMarkViewHolder(View paramView, Context paramContext)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2064122705));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122118));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122117));
    this.c = ((ImageView)paramView.findViewById(2064122372));
    this.d = ((ImageView)paramView.findViewById(2064122373));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2064122512));
    this.e = ((ImageView)paramView.findViewById(2064122607));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2064122846);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2064122847);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int i = AIOUtils.b(6.0F, this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.getResources());
    int j = AIOUtils.b(2.0F, this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.getResources());
    int k = AIOUtils.b(16.0F, this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.getResources());
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setBgCorner(k / 2);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setMinimumHeight(k);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setMinimumWidth(k);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgressSizeAndMode(i, j, false);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setBgColor(0);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgressColor(-1);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.a(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (TextUtils.isEmpty(paramAEMaterialMetaData.m)) {
      return;
    }
    UIUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramAEMaterialMetaData.m, UIUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView.getContext(), 67.0F), UIUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView.getContext(), 67.0F), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2064056356), null);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setVisibility(paramInt);
    this.c.setVisibility(paramInt);
    this.d.setVisibility(paramInt);
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.a())
    {
      a(8);
      b(8);
      return;
    }
    if (paramAEMaterialMetaData.e)
    {
      a(8);
      b(8);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      AEQLog.d("AEMaterialWaterMarkViewHolder", "net work not available");
      a(0);
      b(8);
      return;
    }
    if (paramAEMaterialMetaData.jdField_f_of_type_Boolean)
    {
      a(8);
      b(0);
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgress(paramAEMaterialMetaData.jdField_f_of_type_Int);
      return;
    }
    a(0);
    b(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialWaterMarkViewHolder
 * JD-Core Version:    0.7.0.1
 */