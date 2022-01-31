package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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
import oou;
import pau;
import pqp;
import pqy;
import puy;
import pya;

public class ComponentLastRead
  extends LinearLayout
  implements pqp
{
  private Container a;
  public puy a;
  
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
  
  private void a(pau parampau)
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
              i = parampau.e();
            } while ((i != 0) && (!oou.c(i)));
            parampau = parampau.a();
          } while (parampau == null);
          localObject = parampau.getTemplateFactory();
        } while ((localObject == null) || (!((BaseTemplateFactory)localObject).hasTemplate("ReadInjoy_last_read_cell")));
        localObject = ((BaseTemplateFactory)localObject).getTemplate("ReadInjoy_last_read_cell");
      } while (localObject == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = parampau.getViewFactory().inflate(parampau, (TemplateBean)localObject);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null);
    removeAllViews();
    parampau = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().getComLayoutParams();
    parampau = new RelativeLayout.LayoutParams(parampau.mLayoutWidth, parampau.mLayoutHeight);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, parampau);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Puy = new puy();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131559879, this, true);
    setBackgroundResource(2131166743);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pau))
    {
      this.jdField_a_of_type_Puy.a((pau)paramObject);
      b();
      a((pau)paramObject);
      if (this.jdField_a_of_type_Puy.a.g())
      {
        setVisibility(0);
        setOnClickListener(new pya(this));
        ThreadManager.executeOnSubThread(new ComponentLastRead.2(this));
      }
    }
    else
    {
      return;
    }
    setVisibility(8);
  }
  
  public void a(pqy parampqy)
  {
    this.jdField_a_of_type_Puy.a(parampqy);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead
 * JD-Core Version:    0.7.0.1
 */