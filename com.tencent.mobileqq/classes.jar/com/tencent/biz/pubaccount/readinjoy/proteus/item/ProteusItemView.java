package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnLastReadRefreshListener;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.IPlayableView;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyVideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.ProteusItemHelper;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
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

public class ProteusItemView
  extends RelativeLayout
  implements IPlayableView
{
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new ProteusItemView.3(this);
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ProteusItemView.2(this);
  private final ProteusItemHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewHelperProteusItemHelper = new ProteusItemHelper(this);
  private ComponentLastRead jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private ViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  private List<ProteusItemView.OnItemDrawFinishedListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ProteusItemView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public static ReadInJoyVideoView a(Container paramContainer)
  {
    if (paramContainer != null)
    {
      paramContainer = paramContainer.getViewIdMapping().entrySet().iterator();
      while (paramContainer.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContainer.next();
        if (((localEntry.getValue() instanceof ReadInJoyVideoView)) && (((ViewBase)localEntry.getValue()).isVisible())) {
          return (ReadInJoyVideoView)localEntry.getValue();
        }
      }
    }
    return null;
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
  
  private void a(IReadInJoyModel paramIReadInJoyModel, View paramView)
  {
    if (paramView == null) {
      QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, view is null.");
    }
    for (;;)
    {
      return;
      if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.a() != null))
      {
        paramIReadInJoyModel = paramIReadInJoyModel.a();
        if (TextUtils.isEmpty(paramIReadInJoyModel.proteusItemsData)) {
          continue;
        }
        try
        {
          paramIReadInJoyModel = new JSONObject(paramIReadInJoyModel.proteusItemsData);
          Iterator localIterator = paramIReadInJoyModel.keys();
          String str;
          Object localObject;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str = (String)localIterator.next();
            localObject = paramIReadInJoyModel.opt(str);
          } while (!"guide_card_type".equals(str));
          if ("1".equals(String.valueOf(localObject)))
          {
            QLog.d("ProteusItemView", 1, "one class flow guide card, show separator.");
            paramView.setVisibility(0);
            return;
          }
        }
        catch (JSONException paramIReadInJoyModel)
        {
          QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator JSONException, e = ", paramIReadInJoyModel);
          return;
          QLog.d("ProteusItemView", 1, "flow guide card, hide separator.");
          paramView.setVisibility(8);
          return;
        }
        catch (Exception paramIReadInJoyModel)
        {
          QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, e = ", paramIReadInJoyModel);
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
  
  private boolean a(VideoView paramVideoView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVideoView != null)
    {
      int i = paramVideoView.getCurrentState();
      bool1 = bool2;
      if (i != 9)
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(ComponentPGCShortContentBig paramComponentPGCShortContentBig, int paramInt)
  {
    QLog.d("ProteusItemView", 2, "ComponentPGCShortContentBig");
    switch (paramInt)
    {
    case 4: 
    default: 
      return false;
    case 3: 
      QLog.d("gifvideo.ProteusItemView", 2, "shortcontent to play");
      return paramComponentPGCShortContentBig.a();
    case 6: 
      paramComponentPGCShortContentBig.c();
      return false;
    case 5: 
      paramComponentPGCShortContentBig.d();
      return false;
    }
    paramComponentPGCShortContentBig.e();
    return false;
  }
  
  private boolean a(Map.Entry<String, ViewBase> paramEntry, int paramInt)
  {
    paramEntry = (ReadInJoyVideoView)paramEntry.getValue();
    if (paramEntry.a() != null) {}
    switch (paramInt)
    {
    case 4: 
    default: 
      return false;
    case 3: 
    case 8: 
      return paramEntry.a().startPlay(paramInt);
    case 6: 
      paramEntry.a().stop();
      return false;
    case 5: 
      paramEntry.a().pause();
      return false;
    }
    paramEntry.a().destroy();
    return false;
  }
  
  private boolean b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewHelperProteusItemHelper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewHelperProteusItemHelper.a() != null)) {
      QLog.d("gifvideo.ProteusItemView", 2, " proteusitemhelper celltype: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewHelperProteusItemHelper.a().a());
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null)
    {
      QLog.d("ProteusItemView", 1, "type pgc gif");
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().findViewBaseByName("id_middle_body_content");
      if ((localObject instanceof ReadInJoyMiddleBodyView))
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
          if ((localEntry.getValue() instanceof ReadInJoyVideoView))
          {
            return a(localEntry, paramInt);
            QLog.d("gifvideo.ProteusItemView", 2, localObject + " is not NativeMiddleBodyView");
            break;
          }
          if ((localEntry.getValue() instanceof RvPolymericContainer)) {
            return c(localEntry, paramInt);
          }
        }
      }
    }
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
    paramEntry = (RvPolymericContainer)paramEntry.getValue();
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
              if ((localEntry.getValue() instanceof ReadInJoyVideoView)) {
                return a(localEntry, paramInt);
              }
              if ((localEntry.getValue() instanceof ReadInJoyMiddleBodyView)) {
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
  
  private void e()
  {
    QLog.d("ProteusItemView", 2, "addDestroyObserver");
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  private void f()
  {
    QLog.d("ProteusItemView", 2, "removeDestroyObserver");
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  private void g()
  {
    if (getViewTreeObserver() != null) {
      getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  private void h()
  {
    if ((Build.VERSION.SDK_INT >= 16) && (getViewTreeObserver() != null)) {
      getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public ProteusItemHelper a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewHelperProteusItemHelper;
  }
  
  public BaseArticleInfo a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewHelperProteusItemHelper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewHelperProteusItemHelper.a() != null)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewHelperProteusItemHelper.a().a();
    }
    return null;
  }
  
  public TemplateBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null) {
      return (TemplateBean)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getTag(2131376604);
    }
    return null;
  }
  
  public Container a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  }
  
  public void a()
  {
    b(6);
  }
  
  public void a(ProteusItemView.OnItemDrawFinishedListener paramOnItemDrawFinishedListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramOnItemDrawFinishedListener);
  }
  
  public void a(Container paramContainer)
  {
    Object localObject = paramContainer.getVirtualView().getComLayoutParams();
    localObject = new RelativeLayout.LayoutParams(((Layout.Params)localObject).mLayoutWidth, ((Layout.Params)localObject).mLayoutHeight);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = paramContainer;
    paramContainer.setId(1);
    setBackgroundColor(getResources().getColor(2131167305));
    addView(paramContainer, (ViewGroup.LayoutParams)localObject);
  }
  
  public boolean a()
  {
    return a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer) != null;
  }
  
  public boolean a(int paramInt)
  {
    return b(paramInt);
  }
  
  public void b()
  {
    b(5);
  }
  
  public void c()
  {
    removeAllViews();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = null;
  }
  
  public void d()
  {
    b(7);
    f();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      paramCanvas = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramCanvas.hasNext()) {
        ((ProteusItemView.OnItemDrawFinishedListener)paramCanvas.next()).a();
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    g();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    h();
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel, OnLastReadRefreshListener paramOnLastReadRefreshListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewHelperProteusItemHelper.a(paramIReadInJoyModel);
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
      if (!paramIReadInJoyModel.g()) {
        break label144;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(paramIReadInJoyModel);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(new ProteusItemView.1(this, paramOnLastReadRefreshListener));
      return;
      label144:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().setVisibility(0);
      a(paramIReadInJoyModel, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView());
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.setTag(2131376604, paramTemplateBean);
      setPressed(false);
      return;
    }
    QLog.d("TemplateFactory", 2, "setTemplateBean : " + paramTemplateBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView
 * JD-Core Version:    0.7.0.1
 */