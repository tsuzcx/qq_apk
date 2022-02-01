package com.tencent.biz.pubaccount.weishi_new.drama.holder.controller;

import UserGrowth.stDrama;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

public class WSDramaItemTopAreaController
  extends AbsWSDramaUIGroup
{
  private KandianUrlImageView a;
  
  public WSDramaItemTopAreaController(Context paramContext)
  {
    super(paramContext);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_UserGrowthStDrama != null) && (this.jdField_a_of_type_UserGrowthStDrama.tagIcon != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
      WSPicLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.jdField_a_of_type_UserGrowthStDrama.tagIcon);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
  }
  
  protected int b()
  {
    return 2131560004;
  }
  
  protected void b()
  {
    f();
  }
  
  protected void c() {}
  
  public void c(int paramInt) {}
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)a(2131365896));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.holder.controller.WSDramaItemTopAreaController
 * JD-Core Version:    0.7.0.1
 */