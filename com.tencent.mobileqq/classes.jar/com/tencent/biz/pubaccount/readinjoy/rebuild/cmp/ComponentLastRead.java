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
import odm;
import opw;
import pey;
import pfh;
import pjg;
import pmi;

public class ComponentLastRead
  extends LinearLayout
  implements pey
{
  private Container a;
  public pjg a;
  
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
  
  private void a(opw paramopw)
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
              i = paramopw.e();
            } while ((i != 0) && (!odm.c(i)));
            paramopw = paramopw.a();
          } while (paramopw == null);
          localObject = paramopw.getTemplateFactory();
        } while (localObject == null);
        localObject = ((BaseTemplateFactory)localObject).getTemplate("ReadInjoy_last_read_cell");
      } while (localObject == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = paramopw.getViewFactory().inflate(paramopw, (TemplateBean)localObject);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null);
    removeAllViews();
    paramopw = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().getComLayoutParams();
    paramopw = new RelativeLayout.LayoutParams(paramopw.mLayoutWidth, paramopw.mLayoutHeight);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, paramopw);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Pjg = new pjg();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131494308, this, true);
    setBackgroundResource(2131101149);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof opw))
    {
      this.jdField_a_of_type_Pjg.a((opw)paramObject);
      b();
      a((opw)paramObject);
      if (this.jdField_a_of_type_Pjg.a.g())
      {
        setVisibility(0);
        setOnClickListener(new pmi(this));
        ThreadManager.executeOnSubThread(new ComponentLastRead.2(this));
      }
    }
    else
    {
      return;
    }
    setVisibility(8);
  }
  
  public void a(pfh parampfh)
  {
    this.jdField_a_of_type_Pjg.a(parampfh);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead
 * JD-Core Version:    0.7.0.1
 */