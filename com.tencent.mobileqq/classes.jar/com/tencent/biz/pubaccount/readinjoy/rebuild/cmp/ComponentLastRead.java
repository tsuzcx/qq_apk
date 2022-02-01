package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.app.ThreadManager;
import plm;
import qfw;
import rbo;
import rbx;
import rfw;
import riy;

public class ComponentLastRead
  extends LinearLayout
  implements rbo
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  public rfw a;
  
  public ComponentLastRead(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentLastRead(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentLastRead(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void a(qfw paramqfw)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            int i;
            do
            {
              return;
              i = paramqfw.e();
            } while ((i != 0) && (!plm.c(i)));
            paramqfw = paramqfw.a();
          } while (paramqfw == null);
          localObject = paramqfw.getTemplateFactory();
        } while ((localObject == null) || (!((BaseTemplateFactory)localObject).hasTemplate("ReadInjoy_last_read_cell")));
        localObject = ((BaseTemplateFactory)localObject).getTemplate("ReadInjoy_last_read_cell");
      } while (localObject == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = paramqfw.getViewFactory().inflate(paramqfw, (TemplateBean)localObject);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null);
    removeAllViews();
    paramqfw = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().getComLayoutParams();
    paramqfw = new RelativeLayout.LayoutParams(paramqfw.mLayoutWidth, paramqfw.mLayoutHeight);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, paramqfw);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Rfw = new rfw();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof qfw))
    {
      this.jdField_a_of_type_Rfw.a((qfw)paramObject);
      b();
      if (this.jdField_a_of_type_Rfw.a.g())
      {
        a((qfw)paramObject);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidViewView == null))
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560186, null, false);
          setBackgroundResource(2131166909);
          addView(this.jdField_a_of_type_AndroidViewView);
        }
        setVisibility(0);
        setOnClickListener(new riy(this));
        ThreadManager.executeOnSubThread(new ComponentLastRead.2(this));
      }
    }
    else
    {
      return;
    }
    setVisibility(8);
  }
  
  public void a(rbx paramrbx)
  {
    this.jdField_a_of_type_Rfw.a(paramrbx);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead
 * JD-Core Version:    0.7.0.1
 */