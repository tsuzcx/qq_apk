package com.tencent.biz.pubaccount.readinjoy.webarticle;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class DataPreloadModule$requestArticleDetailByCgi$runnable$1
  implements Runnable
{
  DataPreloadModule$requestArticleDetailByCgi$runnable$1(DataPreloadModule paramDataPreloadModule, String paramString) {}
  
  public final void run()
  {
    if (((CharSequence)this.a).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      QLog.i("DataPreloadModule", 1, "[requestArticleDetailByCgi] rowKey is empty, do not request.");
      return;
    }
    QLog.i("DataPreloadModule", 1, "[requestArticleDetailByCgi] rowKey = " + this.a);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("rowkey", this.a);
    ((Bundle)localObject1).putInt("PostBodyType", 1);
    Bundle localBundle = new Bundle();
    HttpUtil.addCookie(localBundle);
    try
    {
      DataPreloadModule.a(this.this$0).add(this.a);
      localObject1 = HttpUtil.openUrl((Context)BaseApplicationImpl.getContext(), DataPreloadModule.a(this.this$0, "https://cgi.kandian.qq.com/trpc.tkdqq.kd_web_article_detail.KDWebArticleDetail/GetDetail"), "POST", (Bundle)localObject1, localBundle);
      DataPreloadModule.a(this.this$0, (String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("DataPreloadModule", 1, "[requestArticleDetailByCgi] error, e = " + localException);
      return;
    }
    catch (Error localError)
    {
      QLog.e("DataPreloadModule", 1, "[requestArticleDetailByCgi] error, e = " + localError);
      return;
    }
    finally
    {
      DataPreloadModule.a(this.this$0).remove(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.DataPreloadModule.requestArticleDetailByCgi.runnable.1
 * JD-Core Version:    0.7.0.1
 */