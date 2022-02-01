package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.handlers.BaseHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.HandlerTask;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.widget.TraceUtils;

class ReadInJoyProteusFamilyAdapter$2
  extends HandlerTask
{
  ReadInJoyProteusFamilyAdapter$2(ReadInJoyProteusFamilyAdapter paramReadInJoyProteusFamilyAdapter, String paramString, int paramInt1, BaseArticleInfo paramBaseArticleInfo, int paramInt2, ViewGroup paramViewGroup)
  {
    super(paramString);
  }
  
  public void a(BaseHandler paramBaseHandler)
  {
    TraceUtils.traceBegin("ReadInJoyBaseAdapter.Viewtype " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter.a(this.jdField_a_of_type_Int)) {
      if ((ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyProteusFamilyAdapter.c != 56))
      {
        if ((paramBaseHandler instanceof FrameworkHandler)) {}
      }
      else {
        while ((paramBaseHandler instanceof FrameworkHandler)) {
          return;
        }
      }
    }
    if (paramBaseHandler.a(this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_JavaLangObject = paramBaseHandler.a(this.b, null, this.jdField_a_of_type_AndroidViewViewGroup);
    }
    TraceUtils.traceEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyAdapter.2
 * JD-Core Version:    0.7.0.1
 */