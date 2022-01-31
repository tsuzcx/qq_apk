package com.tencent.mobileqq.activity.emogroupstore;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;

public class PicSelectAdapter$PicItemViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public ImageView a;
  private PicSelectAdapter.OnImgClickListener a;
  public NumberCheckBox a;
  public ImageView[] a;
  public NumberCheckBox[] a;
  public ImageView b;
  public NumberCheckBox b;
  public ImageView[] b;
  public ImageView c;
  public NumberCheckBox c;
  public ImageView d;
  public ImageView e;
  public ImageView f;
  
  public PicSelectAdapter$PicItemViewHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372327));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131372328));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372329));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372330));
    this.jdField_b_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131372331));
    this.d = ((ImageView)paramView.findViewById(2131372332));
    this.e = ((ImageView)paramView.findViewById(2131372333));
    this.jdField_c_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131372334));
    this.f = ((ImageView)paramView.findViewById(2131372335));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[] { this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, this.e };
    paramView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView;
    int j = paramView.length;
    int i = 0;
    while (i < j)
    {
      paramView[i].setOnClickListener(this);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox = new NumberCheckBox[] { this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox, this.jdField_b_of_type_ComTencentMobileqqWidgetNumberCheckBox, this.jdField_c_of_type_ComTencentMobileqqWidgetNumberCheckBox };
    this.jdField_b_of_type_ArrayOfAndroidWidgetImageView = new ImageView[] { this.jdField_b_of_type_AndroidWidgetImageView, this.d, this.f };
  }
  
  void a(PicSelectAdapter.OnImgClickListener paramOnImgClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter$OnImgClickListener = paramOnImgClickListener;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("picOnClick.1", 2, "v.getId: " + paramView.getId() + " itemView.getTag: " + this.itemView.getTag());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter$OnImgClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter$OnImgClickListener.a(((Integer)this.itemView.getTag()).intValue(), paramView.getId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.PicSelectAdapter.PicItemViewHolder
 * JD-Core Version:    0.7.0.1
 */