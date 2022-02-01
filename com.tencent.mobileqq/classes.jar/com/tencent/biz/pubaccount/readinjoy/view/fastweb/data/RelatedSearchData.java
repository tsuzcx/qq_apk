package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import java.util.ArrayList;
import java.util.List;
import soy;

public class RelatedSearchData
  extends BaseData
{
  public String a;
  public List<soy> a;
  
  public RelatedSearchData(FastWebArticleInfo paramFastWebArticleInfo)
  {
    super(20);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramFastWebArticleInfo;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData
 * JD-Core Version:    0.7.0.1
 */