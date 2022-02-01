package com.tencent.mobileqq.ark;

import android.os.Bundle;
import apxp;
import apxw;
import apyb;
import bhyo;
import bhyq;
import bhyt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.io.File;
import java.lang.ref.WeakReference;

public class ArkAppCGI$9
  implements Runnable
{
  public ArkAppCGI$9(apxp paramapxp, apyb paramapyb) {}
  
  public void run()
  {
    try
    {
      Object localObject = (QQAppInterface)apxp.a(this.this$0).get();
      if (localObject == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
      localObject = ((bhyq)((QQAppInterface)localObject).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
      File localFile = new File(apxp.a());
      this.a.jdField_a_of_type_JavaIoFile = localFile;
      bhyo localbhyo = new bhyo(this.a.jdField_a_of_type_JavaLangString, localFile);
      localbhyo.n = true;
      localbhyo.p = true;
      if (this.a.b != null) {
        localbhyo.a("Cookie", this.a.b);
      }
      if (this.a.c != null) {
        localbhyo.a("Referer", this.a.c);
      }
      Bundle localBundle = new Bundle();
      ((bhyt)localObject).a(localbhyo, new apxw(this, localFile), localBundle);
      return;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.a.jdField_a_of_type_JavaLangString, localException.getMessage() }));
      apxp.a(this.this$0, this.a, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.9
 * JD-Core Version:    0.7.0.1
 */