package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;
import uab;

public class QCircleCertifiedDialogView
  extends RelativeLayout
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private uab jdField_a_of_type_Uab;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  
  public QCircleCertifiedDialogView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleCertifiedDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleCertifiedDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131560518, this);
    setBackgroundDrawable(getResources().getDrawable(2130843534));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131379860));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131379861));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368716));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368717));
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundURL("https://qzonestyle.gtimg.cn/aoi/sola/20200303153157_RUD3Zf0Pyz.png");
    this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundURL("https://qzonestyle.gtimg.cn/aoi/sola/20200303153157_OASs9ECpAn.png");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Uab == null);
      this.jdField_a_of_type_Uab.a();
      return;
    } while (this.jdField_a_of_type_Uab == null);
    this.jdField_a_of_type_Uab.b();
  }
  
  public void setCertifiedListener(uab paramuab)
  {
    this.jdField_a_of_type_Uab = paramuab;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCertifiedDialogView
 * JD-Core Version:    0.7.0.1
 */