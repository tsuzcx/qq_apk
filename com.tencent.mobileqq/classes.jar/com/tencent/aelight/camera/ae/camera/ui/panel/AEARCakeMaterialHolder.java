package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.NetworkUtil;

public class AEARCakeMaterialHolder
  extends RecyclerView.ViewHolder
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  AEDownLoadingView jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public AEARCakeMaterialHolder(Context paramContext, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2064122705));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122117));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2064122512));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2064122609);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122239));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122238));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.c = ((TextView)paramView.findViewById(2064122010));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2064122541);
    int i = AIOUtils.b(6.0F, this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.getResources());
    int j = AIOUtils.b(2.0F, this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.getResources());
    int k = AIOUtils.b(16.0F, this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.getResources());
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setBgCorner(k / 2);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setMinimumHeight(k);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setMinimumWidth(k);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgressSizeAndMode(i, j, false);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setBgColor(0);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgressColor(-1);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setBgColor(-1);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgressColor(-16725252);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.a(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
  }
  
  public void a(AEARCakeMaterial paramAEARCakeMaterial)
  {
    UIUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramAEARCakeMaterial.m, UIUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView.getContext(), 67.0F), UIUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView.getContext(), 67.0F), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2064056680), null);
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.e)
    {
      a(8);
      b(8);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      AEQLog.d("AEARCakeMaterialHolder", "net work not available");
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
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2064515288);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2064515286);
      return;
    }
    if (paramString.length() <= 4)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2064515286);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      return;
    }
    paramString = paramString.substring(0, 4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2064515287);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setVisibility(paramInt);
  }
  
  public void b(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialHolder
 * JD-Core Version:    0.7.0.1
 */