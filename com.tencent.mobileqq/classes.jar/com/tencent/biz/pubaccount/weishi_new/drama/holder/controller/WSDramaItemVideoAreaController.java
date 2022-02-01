package com.tencent.biz.pubaccount.weishi_new.drama.holder.controller;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

public class WSDramaItemVideoAreaController
  extends AbsWSDramaUIGroup
  implements View.OnClickListener
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private View b;
  
  public WSDramaItemVideoAreaController(Context paramContext)
  {
    super(paramContext);
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_UserGrowthStDrama != null) && (this.jdField_a_of_type_UserGrowthStDrama.dramaInfo != null)) {
      return this.jdField_a_of_type_UserGrowthStDrama.dramaInfo.coverImg;
    }
    return "";
  }
  
  private boolean a()
  {
    return false;
  }
  
  private void g()
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
    Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130841770);
    WSPicLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, a(), localDrawable);
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  }
  
  protected void a()
  {
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    KandianUrlImageView localKandianUrlImageView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
    if (localKandianUrlImageView == null) {
      return;
    }
    if (paramInt1 == localKandianUrlImageView.getVisibility()) {
      return;
    }
    WeishiUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  protected int b()
  {
    return 2131560005;
  }
  
  protected void b()
  {
    g();
    f();
  }
  
  protected void c() {}
  
  public void c(int paramInt) {}
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((FrameLayout)a(2131380462));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)a(2131380463));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380465));
    this.b = a(2131380464);
    this.b.setOnClickListener(this);
  }
  
  public void f()
  {
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131380464) {
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.holder.controller.WSDramaItemVideoAreaController
 * JD-Core Version:    0.7.0.1
 */