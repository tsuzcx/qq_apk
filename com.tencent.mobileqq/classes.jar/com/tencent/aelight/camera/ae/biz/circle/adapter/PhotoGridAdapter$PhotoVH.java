package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.NumberCheckBox;

public class PhotoGridAdapter$PhotoVH
  extends RecyclerView.ViewHolder
{
  public View a;
  public ImageView a;
  public TextView a;
  public PhotoGridAdapter.PhotoItemClickListener a;
  public URLDrawable a;
  public NumberCheckBox a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  
  public PhotoGridAdapter$PhotoVH(PhotoGridAdapter paramPhotoGridAdapter, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122494));
    this.b = ((ImageView)paramView.findViewById(2064122272));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2064122495);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2064122496));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122498));
    this.c = ((ImageView)paramView.findViewById(2064122482));
    paramPhotoGridAdapter = this.c;
    if (paramPhotoGridAdapter != null) {
      paramPhotoGridAdapter.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null) {
      ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoGridAdapter.PhotoVH
 * JD-Core Version:    0.7.0.1
 */