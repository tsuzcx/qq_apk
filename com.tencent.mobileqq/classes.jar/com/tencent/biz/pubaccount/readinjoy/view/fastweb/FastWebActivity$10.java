package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSDataConverter;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$10
  implements ReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  FastWebActivity$10(FastWebActivity paramFastWebActivity) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.e("FastWebActivity", 1, "onLoadUserInfoFailed " + paramString1 + " " + paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("FastWebActivity", 1, "onLoadUserInfoSucceed " + paramReadInJoyUserInfo);
    if ((paramReadInJoyUserInfo != null) && (FastWebActivity.a(this.a) != null) && (FastWebActivity.a(this.a) != null))
    {
      FastWebPTSDataConverter.a(this.a.a, FastWebActivity.a(this.a).c, paramReadInJoyUserInfo);
      FastWebActivity.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.10
 * JD-Core Version:    0.7.0.1
 */