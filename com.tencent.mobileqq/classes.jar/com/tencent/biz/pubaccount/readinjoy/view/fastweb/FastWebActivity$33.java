package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebActivityStackUtil.PopPageListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebActivityStackUtil.SaveState;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$33
  implements FastWebActivityStackUtil.PopPageListener
{
  FastWebActivity$33(FastWebActivity paramFastWebActivity) {}
  
  public void a(FastWebActivityStackUtil.SaveState paramSaveState)
  {
    ArticleInfo localArticleInfo = paramSaveState.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i = FastWebActivity.f(this.a);
    if (QLog.isColorLevel()) {
      QLog.i("FastWebActivity", 2, "articleInfo" + localArticleInfo);
    }
    ReportUtil.a(localArticleInfo, FastWebActivity.g(this.a), i, paramSaveState.jdField_a_of_type_Boolean, this.a.b, FastWebActivity.h(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33
 * JD-Core Version:    0.7.0.1
 */