package com.tencent.mobileqq.ark;

import aldo;
import aldu;
import aldz;
import android.os.Bundle;
import batm;
import bato;
import batr;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.lang.ref.WeakReference;

public class ArkAppCGI$9
  implements Runnable
{
  public ArkAppCGI$9(aldo paramaldo, aldz paramaldz) {}
  
  public void run()
  {
    try
    {
      Object localObject = (QQAppInterface)aldo.a(this.this$0).get();
      if (localObject == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
      localObject = ((bato)((QQAppInterface)localObject).getManager(47)).a(1);
      File localFile = new File(aldo.a());
      this.a.jdField_a_of_type_JavaIoFile = localFile;
      batm localbatm = new batm(this.a.jdField_a_of_type_JavaLangString, localFile);
      localbatm.n = true;
      localbatm.p = true;
      if (this.a.b != null) {
        localbatm.a("Cookie", this.a.b);
      }
      if (this.a.c != null) {
        localbatm.a("Referer", this.a.c);
      }
      Bundle localBundle = new Bundle();
      ((batr)localObject).a(localbatm, new aldu(this, localFile), localBundle);
      return;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.a.jdField_a_of_type_JavaLangString, localException.getMessage() }));
      aldo.a(this.this$0, this.a, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.9
 * JD-Core Version:    0.7.0.1
 */