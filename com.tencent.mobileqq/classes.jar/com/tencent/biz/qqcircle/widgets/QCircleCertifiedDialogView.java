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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import vye;

public class QCircleCertifiedDialogView
  extends RelativeLayout
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private vye jdField_a_of_type_Vye;
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
    LayoutInflater.from(getContext()).inflate(2131560687, this);
    setBackgroundDrawable(getResources().getDrawable(2130843920));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131381054));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131381055));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369157));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369158));
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Vye != null)
      {
        this.jdField_a_of_type_Vye.a();
        continue;
        if (this.jdField_a_of_type_Vye != null) {
          this.jdField_a_of_type_Vye.b();
        }
      }
    }
  }
  
  public void setCertifiedListener(vye paramvye)
  {
    this.jdField_a_of_type_Vye = paramvye;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCertifiedDialogView
 * JD-Core Version:    0.7.0.1
 */