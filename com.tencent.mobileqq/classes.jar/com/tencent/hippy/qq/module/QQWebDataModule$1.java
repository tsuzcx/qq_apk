package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.hippy.VasHippyUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import java.io.File;

class QQWebDataModule$1
  implements Runnable
{
  QQWebDataModule$1(QQWebDataModule paramQQWebDataModule, String paramString1, String paramString2, String paramString3, Promise paramPromise, HippyMap paramHippyMap, String paramString4) {}
  
  public void run()
  {
    String str = QQWebDataModule.access$000(this.this$0, 0, this.val$finalHost, this.val$path, this.val$key, null, false);
    if (TextUtils.isEmpty(str)) {
      this.val$promise.resolve(VasHippyUtils.a(-11, "", this.val$responseMap));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(QQWebDataModule.PUBACCOUNT_DATA_PATH);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(HexUtil.string2HexString(this.val$uin));
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(this.val$finalHost);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(HexUtil.string2HexString(this.val$path));
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(HexUtil.string2HexString(this.val$key));
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists())
    {
      this.val$promise.resolve(VasHippyUtils.a(-11, "", this.val$responseMap));
      return;
    }
    QQWebDataModule.access$100(this.this$0, this.val$promise, this.val$responseMap, str, (File)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQWebDataModule.1
 * JD-Core Version:    0.7.0.1
 */