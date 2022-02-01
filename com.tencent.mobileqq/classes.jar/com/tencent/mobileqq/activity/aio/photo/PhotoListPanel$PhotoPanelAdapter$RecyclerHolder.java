package com.tencent.mobileqq.activity.aio.photo;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hiboom.SquareRelativeLayout;
import com.tencent.mobileqq.widget.NumberCheckBox;
import mqq.util.WeakReference;

class PhotoListPanel$PhotoPanelAdapter$RecyclerHolder
  extends RecyclerView.ViewHolder
{
  public View a;
  public FrameLayout a;
  public ImageView a;
  public TextView a;
  public URLDrawable a;
  public URLImageView a;
  PhotoListPanel.CheckBoxClickedListener jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$CheckBoxClickedListener;
  public SquareRelativeLayout a;
  public NumberCheckBox a;
  public ImageView b;
  
  public PhotoListPanel$PhotoPanelAdapter$RecyclerHolder(PhotoListPanel.PhotoPanelAdapter paramPhotoPanelAdapter, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqHiboomSquareRelativeLayout = ((SquareRelativeLayout)paramView.findViewById(2131367249));
    if (PhotoListPanel.f() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqHiboomSquareRelativeLayout.setCloseSquare(true);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131369353));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$CheckBoxClickedListener = ((PhotoListPanel)paramPhotoPanelAdapter.a.get()).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131369278));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373013);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131369279));
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$CheckBoxClickedListener);
    }
    if ((((PhotoListPanel)paramPhotoPanelAdapter.a.get()).m) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369443));
    this.b = ((ImageView)paramView.findViewById(2131369354));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369442));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter.RecyclerHolder
 * JD-Core Version:    0.7.0.1
 */