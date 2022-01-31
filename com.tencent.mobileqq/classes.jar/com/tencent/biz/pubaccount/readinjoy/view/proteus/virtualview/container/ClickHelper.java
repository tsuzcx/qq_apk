package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import mun;

public class ClickHelper
{
  protected int a;
  protected IContainer a;
  protected mun a;
  public boolean a;
  protected int b;
  public boolean b;
  public int c;
  public int d;
  
  public ClickHelper(IContainer paramIContainer)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreIContainer = paramIContainer;
    this.jdField_a_of_type_Mun = new mun(this);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreIContainer.a();
    ViewBase localViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreIContainer.a();
    Object localObject;
    boolean bool2;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      do
      {
        return false;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
        this.c = ((int)paramMotionEvent.getX());
        this.d = ((int)paramMotionEvent.getY());
        this.jdField_a_of_type_Int = this.c;
        this.jdField_b_of_type_Int = this.d;
      } while (!localViewBase.a(this.c, this.d));
      localObject = localView.getHandler();
      ((Handler)localObject).removeCallbacks(this.jdField_a_of_type_Mun);
      this.jdField_a_of_type_Mun.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreIContainer.a());
      this.jdField_a_of_type_Mun.a(localView);
      ((Handler)localObject).postDelayed(this.jdField_a_of_type_Mun, 500L);
      localViewBase.a(paramMotionEvent);
      return true;
    case 1: 
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreIContainer.a();
      if ((localObject != null) && (!this.jdField_b_of_type_Boolean))
      {
        bool2 = ((ViewBase)localObject).a(this.c, this.d, false);
        bool1 = bool2;
        if (bool2) {
          localView.playSoundEffect(0);
        }
      }
      break;
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localViewBase.a(paramMotionEvent);
      this.jdField_a_of_type_Boolean = true;
      return bool1;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if (Math.sqrt(Math.pow(i - this.jdField_a_of_type_Int, 2.0D) + Math.pow(j - this.jdField_b_of_type_Int, 2.0D)) > 5.0D) {
        localView.removeCallbacks(this.jdField_a_of_type_Mun);
      }
      this.jdField_a_of_type_Int = i;
      this.jdField_b_of_type_Int = j;
      localViewBase.a(paramMotionEvent);
      return false;
      localViewBase.a(paramMotionEvent);
      this.jdField_a_of_type_Boolean = true;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.ClickHelper
 * JD-Core Version:    0.7.0.1
 */