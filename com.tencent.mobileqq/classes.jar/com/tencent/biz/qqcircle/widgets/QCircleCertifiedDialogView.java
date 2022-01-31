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
import uco;

public class QCircleCertifiedDialogView
  extends RelativeLayout
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private uco jdField_a_of_type_Uco;
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
    LayoutInflater.from(getContext()).inflate(2131560519, this);
    setBackgroundDrawable(getResources().getDrawable(2130843549));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131379918));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131379919));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368730));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368731));
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
      } while (this.jdField_a_of_type_Uco == null);
      this.jdField_a_of_type_Uco.a();
      return;
    } while (this.jdField_a_of_type_Uco == null);
    this.jdField_a_of_type_Uco.b();
  }
  
  public void setCertifiedListener(uco paramuco)
  {
    this.jdField_a_of_type_Uco = paramuco;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCertifiedDialogView
 * JD-Core Version:    0.7.0.1
 */