package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.hippy.VasHippyUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import java.io.File;

class QQWebDataModule$3
  implements Runnable
{
  QQWebDataModule$3(QQWebDataModule paramQQWebDataModule, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, Promise paramPromise, HippyMap paramHippyMap) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    String str1 = this.val$finalHost;
    String str2 = this.val$path;
    String str3 = this.val$key;
    boolean bool;
    if (this.val$delAllHostData == 1) {
      bool = true;
    } else {
      bool = false;
    }
    QQWebDataModule.access$000((QQWebDataModule)localObject, 2, str1, str2, str3, null, bool);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(QQWebDataModule.PUBACCOUNT_DATA_PATH);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(HexUtil.string2HexString(this.val$uin));
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(this.val$finalHost);
    str1 = ((StringBuilder)localObject).toString();
    localObject = str1;
    if (this.val$delAllHostData != 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(HexUtil.string2HexString(this.val$path));
      str1 = ((StringBuilder)localObject).toString();
      localObject = str1;
      if (!TextUtils.isEmpty(this.val$key))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(HexUtil.string2HexString(this.val$key));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    FileUtil.a(new File((String)localObject));
    this.val$promise.resolve(VasHippyUtils.a(0, "", this.val$responseMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQWebDataModule.3
 * JD-Core Version:    0.7.0.1
 */