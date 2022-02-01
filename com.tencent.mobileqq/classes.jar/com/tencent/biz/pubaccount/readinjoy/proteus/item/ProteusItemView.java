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
import pnv;
import qch;
import qfw;
import qqb;
import qqc;
import qud;
import qut;
import qvp;
import qwn;

public class ProteusItemView
  extends RelativeLayout
  implements qch
{
  private ComponentLastRead jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private ViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  private List<qqc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final qvp jdField_a_of_type_Qvp = new qvp(this);
  
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
  
  private void a(qfw paramqfw, View paramView)
  {
    if (paramView == null) {
      QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, view is null.");
    }
    for (;;)
    {
      return;
      if ((paramqfw != null) && (paramqfw.a() != null))
      {
        paramqfw = paramqfw.a();
        if (TextUtils.isEmpty(paramqfw.proteusItemsData)) {
          continue;
        }
        try
        {
          paramqfw = new JSONObject(paramqfw.proteusItemsData);
          Iterator localIterator = paramqfw.keys();
          String str;
          Object localObject;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str = (String)localIterator.next();
            localObject = paramqfw.opt(str);
          } while (!"guide_card_type".equals(str));
          if ("1".equals(String.valueOf(localObject)))
          {
            QLog.d("ProteusItemView", 1, "one class flow guide card, show separator.");
            paramView.setVisibility(0);
            return;
          }
        }
        catch (JSONException paramqfw)
        {
          QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator JSONException, e = ", paramqfw);
          return;
          QLog.d("ProteusItemView", 1, "flow guide card, hide separator.");
          paramView.setVisibility(8);
          return;
        }
        catch (Exception paramqfw)
        {
          QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, e = ", paramqfw);
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
    if ((this.jdField_a_of_type_Qvp != null) && (this.jdField_a_of_type_Qvp.a() != null)) {
      QLog.d("gifvideo.ProteusItemView", 2, " proteusitemhelper celltype: " + this.jdField_a_of_type_Qvp.a().a());
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null)
    {
      QLog.d("ProteusItemView", 1, "type pgc gif");
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().findViewBaseByName("id_middle_body_content");
      if ((localObject instanceof qud))
      {
        QLog.d("ProteusItemView", 2, "ReadInJoyMiddleBodyView");
        localObject = ((ViewBase)localObject).getNativeView();
        if ((localObject instanceof NativeMiddleBodyView))
        {
          QLog.d("ProteusItemView", 2, "NativeMiddleBodyView");
          localObject = ((NativeMiddleBodyView)localObject).a();
          if ((localObject instanceof ComponentPGCShortContentBig))
          {
            return a((ComponentPGCShortContentBig)localObject, paramInt);
            QLog.d("gifvideo.ProteusItemView", 2, "proteusitemhelper celltype: null");
            continue;
          }
          QLog.d("gifvideo.ProteusItemView", 2, localObject + " is not ComponentPGCShortContentBig");
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getViewIdMapping().entrySet().iterator();
      }
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          if ((localEntry.getValue() instanceof qut))
          {
            return a(localEntry, paramInt);
            QLog.d("gifvideo.ProteusItemView", 2, localObject + " is not NativeMiddleBodyView");
            break;
          }
          if ((localEntry.getValue() instanceof qwn)) {
            return c(localEntry, paramInt);
          }
        }
      }
    }
    return false;
  }
  
  private boolean a(ComponentPGCShortContentBig paramComponentPGCShortContentBig, int paramInt)
  {
    QLog.d("ProteusItemView", 2, "ComponentPGCShortContentBig");
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      QLog.d("gifvideo.ProteusItemView", 2, "shortcontent to play");
      return paramComponentPGCShortContentBig.a();
    case 2: 
      paramComponentPGCShortContentBig.c();
      return false;
    case 3: 
      paramComponentPGCShortContentBig.d();
      return false;
    }
    paramComponentPGCShortContentBig.e();
    return false;
  }
  
  private boolean a(Map.Entry<String, ViewBase> paramEntry, int paramInt)
  {
    paramEntry = (qut)paramEntry.getValue();
    if (paramEntry.a() != null) {}
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      if ((this.jdField_a_of_type_Qvp != null) && (this.jdField_a_of_type_Qvp.a() != null)) {
        a(paramEntry.a(), this.jdField_a_of_type_Qvp.a().a());
      }
      return paramEntry.a().startPlay();
    case 2: 
      paramEntry.a().stop();
      return false;
    case 3: 
      paramEntry.a().pause();
      return false;
    }
    paramEntry.a().destroy();
    return false;
  }
  
  private boolean b(Map.Entry<String, ViewBase> paramEntry, int paramInt)
  {
    paramEntry = ((ViewBase)paramEntry.getValue()).getNativeView();
    if ((paramEntry instanceof NativeMiddleBodyView))
    {
      paramEntry = ((NativeMiddleBodyView)paramEntry).a();
      if ((paramEntry instanceof ComponentPGCShortContentBig)) {
        return a((ComponentPGCShortContentBig)paramEntry, paramInt);
      }
    }
    return false;
  }
  
  private boolean c(Map.Entry<String, ViewBase> paramEntry, int paramInt)
  {
    paramEntry = (qwn)paramEntry.getValue();
    if ((paramEntry.getNativeView() instanceof RelativeLayout))
    {
      paramEntry = (RelativeLayout)paramEntry.getNativeView();
      if ((paramEntry.getChildCount() > 0) && ((paramEntry.getChildAt(0) instanceof ProteusRecycleView)))
      {
        paramEntry = (ProteusRecycleView)paramEntry.getChildAt(0);
        int j = paramEntry.getChildCount();
        int i = 0;
        while (i < j)
        {
          if ((paramEntry.getChildAt(i) instanceof Container))
          {
            Iterator localIterator = ((Container)paramEntry.getChildAt(i)).getViewIdMapping().entrySet().iterator();
            while (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              if ((localEntry.getValue() instanceof qut)) {
                return a(localEntry, paramInt);
              }
              if ((localEntry.getValue() instanceof qud)) {
                return b(localEntry, paramInt);
              }
            }
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  public TemplateBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null) {
      return (TemplateBean)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getTag(2131376215);
    }
    return null;
  }
  
  public Container a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  }
  
  public qvp a()
  {
    return this.jdField_a_of_type_Qvp;
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
      paramVideoView.setDtPgid("14");
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
    setBackgroundColor(getResources().getColor(2131167296));
    addView(paramContainer, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(qqc paramqqc)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramqqc);
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
        ((qqc)paramCanvas.next()).a();
      }
    }
  }
  
  public void setModel(qfw paramqfw, pnv parampnv)
  {
    this.jdField_a_of_type_Qvp.a(paramqfw);
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
      if (!paramqfw.g()) {
        break label144;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(paramqfw);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(new qqb(this, parampnv));
      return;
      label144:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().setVisibility(0);
      a(paramqfw, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView());
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.setTag(2131376215, paramTemplateBean);
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