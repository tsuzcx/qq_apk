package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.FastWebArticleRichReqCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class FastWebActivity$ArticleRichInfoCallback
  extends FastWebModule.FastWebArticleRichReqCallback
{
  private FastWebActivity$ArticleRichInfoCallback(FastWebActivity paramFastWebActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.a.a == null) || (!paramString.equals(this.a.a.innerUniqueID)) || (FastWebActivity.a(this.a) == null))
    {
      QLog.d("FastWebActivity", 2, "handleLikeCntInfoResp fail, msg not match !");
      return;
    }
    ThreadManager.getUIHandler().post(new FastWebActivity.ArticleRichInfoCallback.4(this, paramInt));
  }
  
  public void a(long paramLong, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.a.a == null) || (!paramString.equals(this.a.a.innerUniqueID)) || (FastWebActivity.a(this.a) == null))
    {
      QLog.d("FastWebActivity", 2, "handleBiuCntInfoResp fail, msg not match !");
      return;
    }
    ThreadManager.getUIHandler().post(new FastWebActivity.ArticleRichInfoCallback.3(this, paramLong));
  }
  
  public void a(FastWebArticleInfo paramFastWebArticleInfo, int paramInt, String paramString)
  {
    this.a.runOnUiThread(new FastWebActivity.ArticleRichInfoCallback.8(this, paramInt, paramFastWebArticleInfo, paramString));
  }
  
  public void a(FastWebArticleInfo paramFastWebArticleInfo, String paramString)
  {
    this.a.runOnUiThread(new FastWebActivity.ArticleRichInfoCallback.9(this, paramString, paramFastWebArticleInfo));
  }
  
  public void a(String paramString)
  {
    this.a.runOnUiThread(new FastWebActivity.ArticleRichInfoCallback.6(this, paramString));
  }
  
  public void a(boolean paramBoolean, int paramInt, FastWebShareInfo paramFastWebShareInfo)
  {
    super.a(paramBoolean, paramInt, paramFastWebShareInfo);
    String str;
    if (this.a.a != null)
    {
      str = this.a.a.mArticleContentUrl;
      if ((!paramBoolean) || (paramFastWebShareInfo == null) || (TextUtils.isEmpty(paramFastWebShareInfo.a(paramInt))) || (TextUtils.isEmpty(str))) {
        break label86;
      }
    }
    label86:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ThreadManager.getUIHandler().post(new FastWebActivity.ArticleRichInfoCallback.1(this, paramBoolean, paramFastWebShareInfo, paramInt, str));
      return;
      str = "";
      break;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.a.a == null) || (!paramString.equals(this.a.a.innerUniqueID)) || (FastWebActivity.a(this.a) == null))
    {
      QLog.d("FastWebActivity", 2, "handleLikeStateResp fail, msg not match !");
      return;
    }
    ThreadManager.getUIHandler().post(new FastWebActivity.ArticleRichInfoCallback.5(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.ArticleRichInfoCallback
 * JD-Core Version:    0.7.0.1
 */