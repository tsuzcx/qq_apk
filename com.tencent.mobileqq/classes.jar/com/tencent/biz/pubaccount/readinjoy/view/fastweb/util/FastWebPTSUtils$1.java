package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import com.tencent.biz.pubaccount.readinjoy.common.RIJJsonUtils;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONObject;

final class FastWebPTSUtils$1
  implements UserOperationModule.Ox978RespCallBack
{
  FastWebPTSUtils$1(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    paramString = FastWebPTSUtils.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
    if (paramBoolean)
    {
      paramInt = 1;
      RIJJsonUtils.a(paramString, "is_done", Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_Boolean) {
        break label82;
      }
    }
    label82:
    for (paramInt = i;; paramInt = 0)
    {
      RIJJsonUtils.a(paramString, "is_intensify", Integer.valueOf(paramInt));
      ReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898B", paramString.toString());
      return;
      paramInt = 2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSUtils.1
 * JD-Core Version:    0.7.0.1
 */