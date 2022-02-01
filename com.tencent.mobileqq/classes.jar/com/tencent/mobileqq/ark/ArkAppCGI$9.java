package com.tencent.mobileqq.ark;

import android.os.Bundle;
import aoul;
import aous;
import aoux;
import bgoe;
import bgog;
import bgoj;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.lang.ref.WeakReference;

public class ArkAppCGI$9
  implements Runnable
{
  public ArkAppCGI$9(aoul paramaoul, aoux paramaoux) {}
  
  public void run()
  {
    try
    {
      Object localObject = (QQAppInterface)aoul.a(this.this$0).get();
      if (localObject == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
      localObject = ((bgog)((QQAppInterface)localObject).getManager(47)).a(1);
      File localFile = new File(aoul.a());
      this.a.jdField_a_of_type_JavaIoFile = localFile;
      bgoe localbgoe = new bgoe(this.a.jdField_a_of_type_JavaLangString, localFile);
      localbgoe.n = true;
      localbgoe.p = true;
      if (this.a.b != null) {
        localbgoe.a("Cookie", this.a.b);
      }
      if (this.a.c != null) {
        localbgoe.a("Referer", this.a.c);
      }
      Bundle localBundle = new Bundle();
      ((bgoj)localObject).a(localbgoe, new aous(this, localFile), localBundle);
      return;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.a.jdField_a_of_type_JavaLangString, localException.getMessage() }));
      aoul.a(this.this$0, this.a, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.9
 * JD-Core Version:    0.7.0.1
 */