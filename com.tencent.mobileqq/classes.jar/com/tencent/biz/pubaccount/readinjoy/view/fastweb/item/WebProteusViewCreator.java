package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusAnimationItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import cooperation.qzone.util.NetworkState;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class WebProteusViewCreator
  implements ItemCreator, OnStateChangeListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private final Map<String, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public WebProteusViewCreator(VafContext paramVafContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
    f();
  }
  
  private void a(Container paramContainer)
  {
    int i = 8;
    int j = 0;
    ViewBase localViewBase;
    if (paramContainer != null)
    {
      localViewBase = paramContainer.getVirtualView();
      if (localViewBase != null)
      {
        paramContainer = localViewBase.findViewBaseByName("id_large_video_icon");
        localViewBase = localViewBase.findViewBaseByName("id_video_bg");
        if (!NetworkState.isWifiConn()) {
          break label64;
        }
      }
    }
    for (;;)
    {
      if (paramContainer != null) {
        paramContainer.setVisibility(j);
      }
      if (localViewBase != null) {
        localViewBase.setVisibility(i);
      }
      return;
      label64:
      j = 8;
      i = 0;
    }
  }
  
  public int a(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof ProteusItemData))
    {
      paramBaseData = (ProteusItemData)paramBaseData;
      if (paramBaseData.a != null)
      {
        paramBaseData = paramBaseData.a.getStyleName();
        Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramBaseData);
        if (localInteger != null) {
          return localInteger.intValue();
        }
        QLog.d("WebProteusViewCreator", 1, "getViewType error,styleName:" + paramBaseData);
      }
    }
    return -1;
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
    }
    ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
    Object localObject = null;
    paramViewGroup = (ViewGroup)localObject;
    try
    {
      if (localProteusItemData.a == null)
      {
        paramViewGroup = (ViewGroup)localObject;
        localProteusItemData.b(localProteusItemData.c);
        paramViewGroup = (ViewGroup)localObject;
        localProteusItemData.c();
      }
      paramViewGroup = (ViewGroup)localObject;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localProteusItemData.a);
      paramViewGroup = (ViewGroup)localObject;
      ProteusSupportUtil.a(((Container)localObject).getVirtualView(), localProteusItemData.a.getViewBean());
      paramViewGroup = (ViewGroup)localObject;
      str = localProteusItemData.c.toString();
      paramViewGroup = (ViewGroup)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        String str = "error!! msg=" + localException.toString();
      }
    }
    bool = false;
    localObject = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject = new View(paramContext);
      bool = true;
    }
    QLog.d("WebProteusViewCreator", 1, "createViewHolder viewIsNull=" + bool + "  proteusData=" + str);
    if ((paramBaseData instanceof ProteusAnimationItemData)) {
      ((ProteusAnimationItemData)paramBaseData).a((View)localObject);
    }
    return new WebProteusViewCreator.ProteusItemViewHolder(this, (View)localObject, localProteusItemData);
  }
  
  public void a() {}
  
  public void a(BaseAdapter paramBaseAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    switch (paramBaseData.s)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    for (;;)
    {
      try
      {
        ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
        Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getTemplateFactory().getNameTemplateMap().keySet();
        BaseItemViewHolder.a = 32;
        int i = BaseItemViewHolder.a + 1;
        localObject = ((Set)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str))
          {
            this.jdField_a_of_type_JavaUtilMap.put(str, Integer.valueOf(i));
            i += 1;
          }
        }
        else
        {
          QLog.d("WebProteusViewCreator", 1, "VIEW_TYPE_COUNT=" + BaseItemViewHolder.a + ",NAME_VIEWTYPE_MAP size=" + this.jdField_a_of_type_JavaUtilMap.size() + "type=" + i);
          BaseItemViewHolder.a += this.jdField_a_of_type_JavaUtilMap.size() + 1;
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("WebProteusViewCreator", 1, "initProteusTypeCount error,msg:" + localException.toString());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebProteusViewCreator
 * JD-Core Version:    0.7.0.1
 */