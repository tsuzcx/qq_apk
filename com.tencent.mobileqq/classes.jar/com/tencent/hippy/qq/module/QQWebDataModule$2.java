package com.tencent.hippy.qq.module;

import com.tencent.mobileqq.vas.hippy.VasHippyUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.util.ThreeDes;
import java.io.File;

class QQWebDataModule$2
  implements Runnable
{
  QQWebDataModule$2(QQWebDataModule paramQQWebDataModule, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Promise paramPromise, HippyMap paramHippyMap) {}
  
  public void run()
  {
    QQWebDataModule.access$000(this.this$0, 1, this.val$finalHost, this.val$path, this.val$key, this.val$hash, false);
    File localFile = QQWebDataModule.access$200(this.this$0, this.val$finalHost, this.val$path, this.val$uin);
    String str = ThreeDes.a(this.val$data, this.val$hash);
    int i = QQWebDataModule.access$300(this.this$0, this.val$key, localFile, str);
    this.val$promise.resolve(VasHippyUtils.a(i, "", this.val$responseMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQWebDataModule.2
 * JD-Core Version:    0.7.0.1
 */