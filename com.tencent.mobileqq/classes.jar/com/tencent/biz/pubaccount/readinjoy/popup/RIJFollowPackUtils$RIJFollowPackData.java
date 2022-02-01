package com.tencent.biz.pubaccount.readinjoy.popup;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/popup/RIJFollowPackUtils$RIJFollowPackData;", "", "templateBean", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)V", "getArticleInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "getContainer", "()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "getTemplateBean", "()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFollowPackUtils$RIJFollowPackData
{
  @NotNull
  private final ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  @NotNull
  private final TemplateBean jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean;
  @NotNull
  private final ViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  
  public RIJFollowPackUtils$RIJFollowPackData(@NotNull TemplateBean paramTemplateBean, @NotNull ViewBase paramViewBase, @NotNull ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = paramTemplateBean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase = paramViewBase;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  @NotNull
  public final ArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  }
  
  @NotNull
  public final TemplateBean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean;
  }
  
  @NotNull
  public final ViewBase a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof RIJFollowPackData))
      {
        paramObject = (RIJFollowPackData)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean)) || (!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase, paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase)) || (!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int k = 0;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
      if (localObject == null) {
        break label70;
      }
    }
    label70:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "RIJFollowPackData(templateBean=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean + ", container=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase + ", articleInfo=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.popup.RIJFollowPackUtils.RIJFollowPackData
 * JD-Core Version:    0.7.0.1
 */