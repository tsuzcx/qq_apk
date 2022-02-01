package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import plx;
import ppu;
import pyf;
import pyg;
import qcb;
import qcr;
import qdm;
import qek;
import sge;

public class ProteusItemView
  extends RelativeLayout
  implements plx
{
  private ComponentLastRead jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private ViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  private List<pyg> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final qdm jdField_a_of_type_Qdm = new qdm(this);
  
  public ProteusItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    while (!(paramView instanceof ImageView)) {
      return;
    }
    paramView = (ImageView)paramView;
    if (paramBoolean)
    {
      paramView.setColorFilter(Color.parseColor("#e5e6e7"));
      return;
    }
    paramView.clearColorFilter();
  }
  
  private void a(ppu paramppu, View paramView)
  {
    if (paramView == null) {
      QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, view is null.");
    }
    for (;;)
    {
      return;
      if ((paramppu != null) && (paramppu.a() != null))
      {
        paramppu = paramppu.a();
        if (TextUtils.isEmpty(paramppu.proteusItemsData)) {
          continue;
        }
        try
        {
          paramppu = new JSONObject(paramppu.proteusItemsData);
          Iterator localIterator = paramppu.keys();
          String str;
          Object localObject;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str = (String)localIterator.next();
            localObject = paramppu.opt(str);
          } while (!"guide_card_type".equals(str));
          if ("1".equals(String.valueOf(localObject)))
          {
            QLog.d("ProteusItemView", 1, "one class flow guide card, show separator.");
            paramView.setVisibility(0);
            return;
          }
        }
        catch (JSONException paramppu)
        {
          QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator JSONException, e = ", paramppu);
          return;
          QLog.d("ProteusItemView", 1, "flow guide card, hide separator.");
          paramView.setVisibility(8);
          return;
        }
        catch (Exception paramppu)
        {
          QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, e = ", paramppu);
          return;
        }
      }
    }
    QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, model of articleInfo is null.");
  }
  
  private void a(boolean paramBoolean, ViewBase paramViewBase)
  {
    if (paramViewBase == null) {}
    String str;
    do
    {
      for (;;)
      {
        return;
        if (!(paramViewBase instanceof Layout)) {
          break;
        }
        paramViewBase = ((Layout)paramViewBase).getSubViews();
        if ((paramViewBase != null) && (!paramViewBase.isEmpty()))
        {
          paramViewBase = paramViewBase.iterator();
          while (paramViewBase.hasNext()) {
            a(paramBoolean, (ViewBase)paramViewBase.next());
          }
        }
      }
      str = paramViewBase.getViewId();
    } while ((str == null) || ((!str.startsWith("id_top_left_mask")) && (!str.startsWith("id_bottom_left_mask")) && (!str.startsWith("id_top_right_mask")) && (!str.startsWith("id_bottom_right_mask"))));
    a(paramViewBase.getNativeView(), paramBoolean);
  }
  
  private boolean a(int paramInt)
  {
    Object localObject1;
    if ((this.jdField_a_of_type_Qdm != null) && (this.jdField_a_of_type_Qdm.a() != null))
    {
      QLog.d("gifvideo.ProteusItemView", 2, " proteusitemhelper celltype: " + this.jdField_a_of_type_Qdm.a().a());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null) {
        break label913;
      }
      QLog.d("ProteusItemView", 1, "type pgc gif");
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().findViewBaseByName("id_middle_body_content");
      if ((localObject1 != null) && ((localObject1 instanceof qcb)))
      {
        QLog.d("ProteusItemView", 2, "ReadInJoyMiddleBodyView");
        localObject1 = ((ViewBase)localObject1).getNativeView();
        if (!(localObject1 instanceof NativeMiddleBodyView)) {
          break label428;
        }
        QLog.d("ProteusItemView", 2, "NativeMiddleBodyView");
        localObject1 = ((NativeMiddleBodyView)localObject1).a();
        if (!(localObject1 instanceof ComponentPGCShortContentBig)) {
          break label398;
        }
        QLog.d("ProteusItemView", 2, "ComponentPGCShortContentBig");
      }
      switch (paramInt)
      {
      default: 
        label184:
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getViewIdMapping().entrySet().iterator();
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label913;
      }
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if ((((Map.Entry)localObject2).getValue() instanceof qcr))
      {
        localObject2 = (qcr)((Map.Entry)localObject2).getValue();
        if (((qcr)localObject2).a() == null) {
          continue;
        }
        switch (paramInt)
        {
        default: 
          break;
        case 1: 
          if ((this.jdField_a_of_type_Qdm != null) && (this.jdField_a_of_type_Qdm.a() != null)) {
            a(((qcr)localObject2).a(), this.jdField_a_of_type_Qdm.a().a());
          }
          return ((qcr)localObject2).a().startPlay();
          QLog.d("gifvideo.ProteusItemView", 2, "proteusitemhelper celltype: null");
          break;
          QLog.d("gifvideo.ProteusItemView", 2, "shortcontent to play");
          return ((ComponentPGCShortContentBig)localObject1).a();
          ((ComponentPGCShortContentBig)localObject1).c();
          return false;
          ((ComponentPGCShortContentBig)localObject1).d();
          return false;
          ((ComponentPGCShortContentBig)localObject1).e();
          return false;
          QLog.d("gifvideo.ProteusItemView", 2, localObject1 + " is not ComponentPGCShortContentBig");
          break label184;
          QLog.d("gifvideo.ProteusItemView", 2, localObject1 + " is not NativeMiddleBodyView");
          break;
        case 2: 
          ((qcr)localObject2).a().stop();
          return false;
        case 3: 
          ((qcr)localObject2).a().pause();
          return false;
        case 4: 
          label398:
          label428:
          ((qcr)localObject2).a().destroy();
          return false;
        }
      }
      if ((((Map.Entry)localObject2).getValue() instanceof qek))
      {
        localObject2 = (qek)((Map.Entry)localObject2).getValue();
        if ((((qek)localObject2).getNativeView() instanceof RelativeLayout))
        {
          localObject2 = (RelativeLayout)((qek)localObject2).getNativeView();
          if ((((RelativeLayout)localObject2).getChildCount() > 0) && ((((RelativeLayout)localObject2).getChildAt(0) instanceof ProteusRecycleView)))
          {
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
                  if ((((Map.Entry)localObject3).getValue() instanceof qcr))
                  {
                    localObject3 = (qcr)((Map.Entry)localObject3).getValue();
                    if (((qcr)localObject3).a() != null) {
                      switch (paramInt)
                      {
                      default: 
                        break;
                      case 1: 
                        if ((this.jdField_a_of_type_Qdm != null) && (this.jdField_a_of_type_Qdm.a() != null)) {
                          a(((qcr)localObject3).a(), this.jdField_a_of_type_Qdm.a().a());
                        }
                        return ((qcr)localObject3).a().startPlay();
                      case 2: 
                        ((qcr)localObject3).a().stop();
                        return false;
                      case 3: 
                        ((qcr)localObject3).a().pause();
                        return false;
                      case 4: 
                        ((qcr)localObject3).a().destroy();
                        return false;
                      }
                    }
                  }
                  else if ((((Map.Entry)localObject3).getValue() instanceof qcb))
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
                          return ((ComponentPGCShortContentBig)localObject3).a();
                        case 2: 
                          ((ComponentPGCShortContentBig)localObject3).c();
                          return false;
                        case 3: 
                          ((ComponentPGCShortContentBig)localObject3).d();
                          return false;
                        case 4: 
                          ((ComponentPGCShortContentBig)localObject3).e();
                          return false;
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
      }
    }
    label913:
    return false;
  }
  
  public TemplateBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null) {
      return (TemplateBean)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getTag(2131376204);
    }
    return null;
  }
  
  public Container a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  }
  
  public qdm a()
  {
    return this.jdField_a_of_type_Qdm;
  }
  
  public void a()
  {
    a(2);
  }
  
  public void a(VideoView paramVideoView, ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null)
    {
      paramVideoView.setChannelId(paramArticleInfo.mChannelID);
      paramVideoView.setDtPgid("8014");
      paramVideoView.setPuin(paramArticleInfo.getSubscribeUin());
      paramVideoView.setRowKey(paramArticleInfo.innerUniqueID);
    }
  }
  
  public void a(Container paramContainer)
  {
    Object localObject = paramContainer.getVirtualView().getComLayoutParams();
    localObject = new RelativeLayout.LayoutParams(((Layout.Params)localObject).mLayoutWidth, ((Layout.Params)localObject).mLayoutHeight);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = paramContainer;
    paramContainer.setId(1);
    setBackgroundColor(getResources().getColor(2131167247));
    addView(paramContainer, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(pyg parampyg)
  {
    this.jdField_a_of_type_JavaUtilList.add(parampyg);
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
        ((pyg)paramCanvas.next()).a();
      }
    }
  }
  
  public void setModel(ppu paramppu, sge paramsge)
  {
    this.jdField_a_of_type_Qdm.a(paramppu);
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
      if (!paramppu.g()) {
        break label144;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(paramppu);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(new pyf(this, paramsge));
      return;
      label144:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().setVisibility(0);
      a(paramppu, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView());
    }
  }
  
  public void setPressed(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null) {
      return;
    }
    a(paramBoolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView());
    super.setPressed(paramBoolean);
  }
  
  public void setTemplateBean(TemplateBean paramTemplateBean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.setTag(2131376204, paramTemplateBean);
      setPressed(false);
      return;
    }
    QLog.d("TemplateFactory", 2, "setTemplateBean : " + paramTemplateBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView
 * JD-Core Version:    0.7.0.1
 */