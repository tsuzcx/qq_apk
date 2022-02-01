package com.tencent.mobileqq.activity.emogroupstore;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368660));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131364614));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368695));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368661));
    this.jdField_b_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131364615));
    this.d = ((ImageView)paramView.findViewById(2131368696));
    this.e = ((ImageView)paramView.findViewById(2131368662));
    this.jdField_c_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131364616));
    this.f = ((ImageView)paramView.findViewById(2131368697));
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("v.getId: ");
      ((StringBuilder)localObject).append(paramView.getId());
      ((StringBuilder)localObject).append(" itemView.getTag: ");
      ((StringBuilder)localObject).append(this.itemView.getTag());
      QLog.i("picOnClick.1", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter$OnImgClickListener;
    if (localObject != null) {
      ((PicSelectAdapter.OnImgClickListener)localObject).a(((Integer)this.itemView.getTag()).intValue(), paramView.getId());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.PicSelectAdapter.PicItemViewHolder
 * JD-Core Version:    0.7.0.1
 */