package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import olz;
import opw;
import org.json.JSONException;
import org.json.JSONObject;
import owb;
import owc;
import ozt;
import paj;
import pbb;
import pbz;
import qpi;

public class ProteusItemView
  extends RelativeLayout
  implements olz
{
  public final int a;
  private ComponentLastRead jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private ViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  private List<owc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final pbb jdField_a_of_type_Pbb = new pbb(this);
  
  public ProteusItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 1;
  }
  
  private void a(opw paramopw, View paramView)
  {
    if (paramView == null) {
      QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, view is null.");
    }
    for (;;)
    {
      return;
      if ((paramopw != null) && (paramopw.a() != null))
      {
        paramopw = paramopw.a();
        if (TextUtils.isEmpty(paramopw.proteusItemsData)) {
          continue;
        }
        try
        {
          paramopw = new JSONObject(paramopw.proteusItemsData);
          Iterator localIterator = paramopw.keys();
          String str;
          Object localObject;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str = (String)localIterator.next();
            localObject = paramopw.opt(str);
          } while (!"guide_card_type".equals(str));
          if ("1".equals(String.valueOf(localObject)))
          {
            QLog.d("ProteusItemView", 1, "one class flow guide card, show separator.");
            paramView.setVisibility(0);
            return;
          }
        }
        catch (JSONException paramopw)
        {
          QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator JSONException, e = ", paramopw);
          return;
          QLog.d("ProteusItemView", 1, "flow guide card, hide separator.");
          paramView.setVisibility(8);
          return;
        }
        catch (Exception paramopw)
        {
          QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, e = ", paramopw);
          return;
        }
      }
    }
    QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, model of articleInfo is null.");
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_Pbb != null) && (this.jdField_a_of_type_Pbb.a() != null))
    {
      QLog.d("gifvideo.ProteusItemView", 2, " proteusitemhelper celltype: " + this.jdField_a_of_type_Pbb.a().a());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null)
      {
        QLog.d("ProteusItemView", 1, "type pgc gif");
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().findViewBaseByName("id_middle_body_content");
        if ((localObject1 == null) || (!(localObject1 instanceof ozt))) {
          break label284;
        }
        QLog.d("ProteusItemView", 2, "ReadInJoyMiddleBodyView");
        localObject1 = ((ViewBase)localObject1).getNativeView();
        if (!(localObject1 instanceof NativeMiddleBodyView)) {
          break label266;
        }
        QLog.d("ProteusItemView", 2, "NativeMiddleBodyView");
        localObject1 = ((NativeMiddleBodyView)localObject1).a();
        if (!(localObject1 instanceof ComponentPGCShortContentBig)) {
          break label248;
        }
        QLog.d("ProteusItemView", 2, "ComponentPGCShortContentBig");
        switch (paramInt)
        {
        default: 
          break;
          break;
          break;
        }
      }
    }
    for (;;)
    {
      label184:
      return false;
      QLog.d("gifvideo.ProteusItemView", 2, "proteusitemhelper celltype: null");
      break;
      QLog.d("gifvideo.ProteusItemView", 2, "shortcontent to play");
      ((ComponentPGCShortContentBig)localObject1).c();
      return true;
      ((ComponentPGCShortContentBig)localObject1).d();
      continue;
      ((ComponentPGCShortContentBig)localObject1).e();
      continue;
      ((ComponentPGCShortContentBig)localObject1).f();
      continue;
      label248:
      QLog.d("gifvideo.ProteusItemView", 2, new Object[] { localObject1 });
      continue;
      label266:
      QLog.d("gifvideo.ProteusItemView", 2, new Object[] { localObject1 });
    }
    label284:
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getViewIdMapping().entrySet().iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if ((((Map.Entry)localObject2).getValue() instanceof paj))
        {
          localObject2 = (paj)((Map.Entry)localObject2).getValue();
          if (!(((paj)localObject2).getNativeView() instanceof NativeVideoView)) {
            continue;
          }
          switch (paramInt)
          {
          default: 
            break;
          case 1: 
            ((NativeVideoView)((paj)localObject2).getNativeView()).a();
            return true;
          case 2: 
            ((NativeVideoView)((paj)localObject2).getNativeView()).F_();
            break;
          case 3: 
            ((NativeVideoView)((paj)localObject2).getNativeView()).G_();
            break;
          case 4: 
            ((NativeVideoView)((paj)localObject2).getNativeView()).f();
            break;
          }
        }
      }
      else
      {
        break label184;
      }
      if (!(((Map.Entry)localObject2).getValue() instanceof pbz)) {
        break;
      }
      Object localObject2 = (pbz)((Map.Entry)localObject2).getValue();
      if (!(((pbz)localObject2).getNativeView() instanceof RelativeLayout)) {
        break;
      }
      localObject2 = (RelativeLayout)((pbz)localObject2).getNativeView();
      if ((((RelativeLayout)localObject2).getChildCount() <= 0) || (!(((RelativeLayout)localObject2).getChildAt(0) instanceof ProteusRecycleView))) {
        break;
      }
      localObject2 = (ProteusRecycleView)((RelativeLayout)localObject2).getChildAt(0);
      int j = ((ProteusRecycleView)localObject2).getChildCount();
      int i = 0;
      while (i < j)
      {
        if ((((ProteusRecycleView)localObject2).getChildAt(i) instanceof Container))
        {
          Iterator localIterator = ((Container)((ProteusRecycleView)localObject2).getChildAt(i)).getViewIdMapping().entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject3 = (Map.Entry)localIterator.next();
            if ((((Map.Entry)localObject3).getValue() instanceof paj))
            {
              localObject3 = (paj)((Map.Entry)localObject3).getValue();
              if ((((paj)localObject3).getNativeView() instanceof NativeVideoView)) {
                switch (paramInt)
                {
                default: 
                  break;
                case 1: 
                  ((NativeVideoView)((paj)localObject3).getNativeView()).a();
                  return true;
                case 2: 
                  ((NativeVideoView)((paj)localObject3).getNativeView()).F_();
                  break;
                case 3: 
                  ((NativeVideoView)((paj)localObject3).getNativeView()).G_();
                  break;
                case 4: 
                  ((NativeVideoView)((paj)localObject3).getNativeView()).f();
                  break;
                }
              }
            }
            else if ((((Map.Entry)localObject3).getValue() instanceof ozt))
            {
              localObject3 = ((ViewBase)((Map.Entry)localObject3).getValue()).getNativeView();
              if ((localObject3 instanceof NativeMiddleBodyView))
              {
                localObject3 = ((NativeMiddleBodyView)localObject3).a();
                if ((localObject3 instanceof ComponentPGCShortContentBig)) {
                  switch (paramInt)
                  {
                  default: 
                    break;
                  case 1: 
                    ((ComponentPGCShortContentBig)localObject3).c();
                    return true;
                  case 2: 
                    ((ComponentPGCShortContentBig)localObject3).d();
                    break;
                  case 3: 
                    ((ComponentPGCShortContentBig)localObject3).e();
                    break;
                  case 4: 
                    ((ComponentPGCShortContentBig)localObject3).f();
                  }
                }
              }
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public TemplateBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null) {
      return (TemplateBean)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getTag(2131309081);
    }
    return null;
  }
  
  public Container a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  }
  
  public pbb a()
  {
    return this.jdField_a_of_type_Pbb;
  }
  
  public void a()
  {
    a(2);
  }
  
  public void a(Container paramContainer)
  {
    Object localObject = paramContainer.getVirtualView().getComLayoutParams();
    localObject = new RelativeLayout.LayoutParams(((Layout.Params)localObject).mLayoutWidth, ((Layout.Params)localObject).mLayoutHeight);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = paramContainer;
    paramContainer.setId(1);
    setBackgroundColor(getResources().getColor(2131101491));
    addView(paramContainer, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(owc paramowc)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramowc);
  }
  
  public boolean a()
  {
    return a(1);
  }
  
  public void b()
  {
    a(3);
  }
  
  public void c()
  {
    a(4);
  }
  
  public void d()
  {
    removeAllViews();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = null;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      paramCanvas = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramCanvas.hasNext()) {
        ((owc)paramCanvas.next()).a();
      }
    }
  }
  
  public void setModel(opw paramopw, qpi paramqpi)
  {
    this.jdField_a_of_type_Pbb.a(paramopw);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead = new ComponentLastRead(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 1);
      addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead, localLayoutParams);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().findViewBaseByName("id_separator");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView() != null))
    {
      if (!paramopw.g()) {
        break label144;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(paramopw);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(new owb(this, paramqpi));
      return;
      label144:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().setVisibility(0);
      a(paramopw, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView());
    }
  }
  
  public void setTemplateBean(TemplateBean paramTemplateBean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.setTag(2131309081, paramTemplateBean);
      return;
    }
    QLog.d("TemplateFactory", 2, "setTemplateBean : " + paramTemplateBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView
 * JD-Core Version:    0.7.0.1
 */