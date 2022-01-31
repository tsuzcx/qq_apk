package com.tencent.mobileqq.ark;

import alrm;
import alrv;
import alrx;
import alrz;
import alsc;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class ArkAiDictUpdateMgr$8
  implements Runnable
{
  public ArkAiDictUpdateMgr$8(alrm paramalrm, String paramString, alrz paramalrz, alrx paramalrx) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)alrm.a(this.this$0).get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, qq app interface is null, return from task");
      return;
    }
    ((ArkAppCenter)localQQAppInterface.getManager(121)).a().a(this.jdField_a_of_type_JavaLangString, 0L, new alrv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8
 * JD-Core Version:    0.7.0.1
 */