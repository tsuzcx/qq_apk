package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.viola.core.ViolaSDKManager;
import pha;
import pus;

public class ViolaHandler$1
  implements Runnable
{
  public ViolaHandler$1(pus parampus, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void run()
  {
    Object localObject2 = pha.a(this.a);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = pha.b(this.a);
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = pha.c(this.a);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ViolaSDKManager.getInstance().postOnUiThread(new ViolaHandler.1.1(this, (String)localObject2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.ViolaHandler.1
 * JD-Core Version:    0.7.0.1
 */