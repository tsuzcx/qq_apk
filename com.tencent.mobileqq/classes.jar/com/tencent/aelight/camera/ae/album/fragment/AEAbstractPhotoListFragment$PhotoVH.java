package com.tencent.aelight.camera.ae.album.fragment;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.NumberCheckBox;

public class AEAbstractPhotoListFragment$PhotoVH
  extends RecyclerView.ViewHolder
{
  public View a;
  public ImageView a;
  public TextView a;
  public AEAbstractPhotoListFragment.PhotoItemClickListener a;
  public URLDrawable a;
  public NumberCheckBox a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public ImageView d;
  
  public AEAbstractPhotoListFragment$PhotoVH(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment, View paramView)
  {
    super(paramView);
    this.b = ((ImageView)paramView.findViewById(2064122494));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122485));
    this.c = ((ImageView)paramView.findViewById(2064122272));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2064122495);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2064122496));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122498));
    this.d = ((ImageView)paramView.findViewById(2064122482));
    paramAEAbstractPhotoListFragment = this.d;
    if (paramAEAbstractPhotoListFragment != null) {
      paramAEAbstractPhotoListFragment.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null) {
      ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox, false);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.jdField_a_of_type_AndroidWidgetTextView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoVH
 * JD-Core Version:    0.7.0.1
 */