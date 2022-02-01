package com.tencent.biz.pubaccount.readinjoy.webarticle;

import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tencent.im.oidb.cmd0xf24.oidb_cmd0xf24.ReqBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class DataPreloadModule$requestArticleDetailInWebProcess$runnable$1
  implements Runnable
{
  DataPreloadModule$requestArticleDetailInWebProcess$runnable$1(DataPreloadModule paramDataPreloadModule, String paramString) {}
  
  public final void run()
  {
    if (((CharSequence)this.a).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      QLog.i("DataPreloadModule", 1, "[requestArticleDetail] rowKey is empty, do not request.");
      return;
    }
    if (!DataPreloadModule.a(this.this$0, this.a))
    {
      QLog.i("DataPreloadModule", 1, "[requestArticleDetail] is in request or cache list, do not request, rowKey = " + this.a);
      return;
    }
    Object localObject = new oidb_cmd0xf24.ReqBody();
    ((oidb_cmd0xf24.ReqBody)localObject).rowkey.set(this.a);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xf24", 3876, 0, ((oidb_cmd0xf24.ReqBody)localObject).toByteArray());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "request");
    ((ToServiceMsg)localObject).setTimeout(5000L);
    HashMap localHashMap = ((ToServiceMsg)localObject).getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(localHashMap, "request.attributes");
    ((Map)localHashMap).put("attribute_key_rowKey", this.a);
    this.this$0.a((ToServiceMsg)localObject);
    DataPreloadModule.a(this.this$0).add(this.a);
    QLog.i("DataPreloadModule", 1, "[requestArticleDetail], rowKey = " + this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.DataPreloadModule.requestArticleDetailInWebProcess.runnable.1
 * JD-Core Version:    0.7.0.1
 */