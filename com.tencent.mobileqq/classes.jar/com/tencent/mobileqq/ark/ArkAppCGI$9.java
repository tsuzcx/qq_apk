package com.tencent.mobileqq.ark;

import android.os.Bundle;
import aqay;
import aqbf;
import aqbk;
import bihu;
import bihw;
import bihz;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.lang.ref.WeakReference;

public class ArkAppCGI$9
  implements Runnable
{
  public ArkAppCGI$9(aqay paramaqay, aqbk paramaqbk) {}
  
  public void run()
  {
    try
    {
      Object localObject = (QQAppInterface)aqay.a(this.this$0).get();
      if (localObject == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
      localObject = ((bihw)((QQAppInterface)localObject).getManager(47)).a(1);
      File localFile = new File(aqay.a());
      this.a.jdField_a_of_type_JavaIoFile = localFile;
      bihu localbihu = new bihu(this.a.jdField_a_of_type_JavaLangString, localFile);
      localbihu.n = true;
      localbihu.p = true;
      if (this.a.b != null) {
        localbihu.a("Cookie", this.a.b);
      }
      if (this.a.c != null) {
        localbihu.a("Referer", this.a.c);
      }
      Bundle localBundle = new Bundle();
      ((bihz)localObject).a(localbihu, new aqbf(this, localFile), localBundle);
      return;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.a.jdField_a_of_type_JavaLangString, localException.getMessage() }));
      aqay.a(this.this$0, this.a, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.9
 * JD-Core Version:    0.7.0.1
 */