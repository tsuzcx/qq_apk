package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.FastWebArticleRichReqCallback;
import com.tencent.biz.pubaccount.readinjoy.proteus.wrap.ReadInjoyContext;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusBookData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.widget.AbsListView;

public class WebFastProteusViewCreator
  implements ItemCreator, OnStateChangeListener
{
  private static boolean jdField_a_of_type_Boolean;
  private FastWebModule.FastWebArticleRichReqCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule$FastWebArticleRichReqCallback = new WebFastProteusViewCreator.1(this);
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  
  public int a(BaseData paramBaseData)
  {
    return 16;
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramBaseData.b;
    }
    paramViewGroup = (ProteusBookData)paramBaseData;
    Container localContainer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramViewGroup.a);
    paramViewGroup = localContainer;
    if (localContainer == null) {
      paramViewGroup = new View(paramContext);
    }
    return new WebFastProteusViewCreator.TextViewHolder(paramViewGroup, paramBaseData);
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.s == 18;
  }
  
  public void b()
  {
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
      if (localFastWebModule != null) {
        localFastWebModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule$FastWebArticleRichReqCallback, false);
      }
    }
  }
  
  public void c() {}
  
  public void d()
  {
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
    if (localFastWebModule != null) {
      localFastWebModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule$FastWebArticleRichReqCallback);
    }
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastProteusViewCreator
 * JD-Core Version:    0.7.0.1
 */