package com.tencent.mobileqq.ark;

import android.os.Bundle;
import apni;
import apnp;
import apnu;
import bhhf;
import bhhh;
import bhhk;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.lang.ref.WeakReference;

public class ArkAppCGI$9
  implements Runnable
{
  public ArkAppCGI$9(apni paramapni, apnu paramapnu) {}
  
  public void run()
  {
    try
    {
      Object localObject = (QQAppInterface)apni.a(this.this$0).get();
      if (localObject == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
      localObject = ((bhhh)((QQAppInterface)localObject).getManager(47)).a(1);
      File localFile = new File(apni.a());
      this.a.jdField_a_of_type_JavaIoFile = localFile;
      bhhf localbhhf = new bhhf(this.a.jdField_a_of_type_JavaLangString, localFile);
      localbhhf.n = true;
      localbhhf.p = true;
      if (this.a.b != null) {
        localbhhf.a("Cookie", this.a.b);
      }
      if (this.a.c != null) {
        localbhhf.a("Referer", this.a.c);
      }
      Bundle localBundle = new Bundle();
      ((bhhk)localObject).a(localbhhf, new apnp(this, localFile), localBundle);
      return;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.a.jdField_a_of_type_JavaLangString, localException.getMessage() }));
      apni.a(this.this$0, this.a, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.9
 * JD-Core Version:    0.7.0.1
 */