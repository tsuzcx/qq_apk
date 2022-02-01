package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.handlers.BaseHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.HandlerTask;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.util.FluencyOptUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.TraceUtils;

class ReadInJoyBaseAdapter$1
  extends HandlerTask
{
  ReadInJoyBaseAdapter$1(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, String paramString, int paramInt1, BaseArticleInfo paramBaseArticleInfo, int paramInt2, View paramView, ViewGroup paramViewGroup)
  {
    super(paramString);
  }
  
  public void a(BaseHandler paramBaseHandler)
  {
    TraceUtils.traceBegin("ReadInJoyBaseAdapter.Viewtype " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(this.jdField_a_of_type_Int)) {
      if ((ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.c != 56))
      {
        if ((paramBaseHandler instanceof FrameworkHandler)) {}
      }
      else {
        while ((paramBaseHandler instanceof FrameworkHandler)) {
          return;
        }
      }
    }
    if (paramBaseHandler.a(this.jdField_a_of_type_Int))
    {
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_JavaLangObject = paramBaseHandler.a(this.b, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewViewGroup);
      long l2 = System.currentTimeMillis();
      if (FluencyOptUtils.a.a()) {
        ThreadManager.excute(new ReadInJoyBaseAdapter.1.1(this, l2 - l1, paramBaseHandler), 128, null, true);
      }
    }
    TraceUtils.traceEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.1
 * JD-Core Version:    0.7.0.1
 */