package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.List;
import mqq.os.MqqHandler;
import nxz;
import nzi;
import odg;

public class ReadinjoyNativeArticleAdDownloadView$1
  implements Runnable
{
  public ReadinjoyNativeArticleAdDownloadView$1(odg paramodg) {}
  
  public void run()
  {
    if ((odg.a(this.this$0).a != null) && (!TextUtils.isEmpty(odg.a(this.this$0).a.b)) && (odg.a(this.this$0).a.a != null))
    {
      Pair localPair = nzi.a(odg.a(this.this$0).a.b);
      if (((this.this$0.a instanceof Activity)) && (localPair.first != null) && (((List)localPair.first).size() > 0))
      {
        Activity localActivity = (Activity)this.this$0.a;
        localActivity.runOnUiThread(new ReadinjoyNativeArticleAdDownloadView.1.1(this, localActivity, localPair));
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new ReadinjoyNativeArticleAdDownloadView.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadinjoyNativeArticleAdDownloadView.1
 * JD-Core Version:    0.7.0.1
 */