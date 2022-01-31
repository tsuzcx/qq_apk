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
import otf;
import pgd;
import pxk;
import pxt;
import qbs;
import qeu;

public class ComponentLastRead
  extends LinearLayout
  implements pxk
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  public qbs a;
  
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
  
  private void a(pgd parampgd)
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
              i = parampgd.e();
            } while ((i != 0) && (!otf.c(i)));
            parampgd = parampgd.a();
          } while (parampgd == null);
          localObject = parampgd.getTemplateFactory();
        } while ((localObject == null) || (!((BaseTemplateFactory)localObject).hasTemplate("ReadInjoy_last_read_cell")));
        localObject = ((BaseTemplateFactory)localObject).getTemplate("ReadInjoy_last_read_cell");
      } while (localObject == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = parampgd.getViewFactory().inflate(parampgd, (TemplateBean)localObject);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null);
    removeAllViews();
    parampgd = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().getComLayoutParams();
    parampgd = new RelativeLayout.LayoutParams(parampgd.mLayoutWidth, parampgd.mLayoutHeight);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, parampgd);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Qbs = new qbs();
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
    if ((paramObject instanceof pgd))
    {
      this.jdField_a_of_type_Qbs.a((pgd)paramObject);
      b();
      if (this.jdField_a_of_type_Qbs.a.g())
      {
        a((pgd)paramObject);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidViewView == null))
        {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559973, null, false);
          setBackgroundResource(2131166792);
          addView(this.jdField_a_of_type_AndroidViewView);
        }
        setVisibility(0);
        setOnClickListener(new qeu(this));
        ThreadManager.executeOnSubThread(new ComponentLastRead.2(this));
      }
    }
    else
    {
      return;
    }
    setVisibility(8);
  }
  
  public void a(pxt parampxt)
  {
    this.jdField_a_of_type_Qbs.a(parampxt);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead
 * JD-Core Version:    0.7.0.1
 */