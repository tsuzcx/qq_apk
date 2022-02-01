package com.tencent.biz.pubaccount.ecshopassit.view;

import android.os.Bundle;
import bhrb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import ofe;

public class EcshopWebviewPool$1
  implements Runnable
{
  public void run()
  {
    if (!this.this$0.a(this.a))
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("_accelerator_mode_", 3);
      bhrb.a().a((Bundle)localObject);
      localObject = EcshopWebview.a(BaseApplicationImpl.sApplication);
      ofe.a(this.this$0).put(this.a, localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopWebviewPool", 2, "【init】webViewLinkedList.size: " + ofe.a(this.this$0).size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopWebviewPool.1
 * JD-Core Version:    0.7.0.1
 */