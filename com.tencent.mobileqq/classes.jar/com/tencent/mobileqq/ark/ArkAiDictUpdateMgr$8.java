package com.tencent.mobileqq.ark;

import apwz;
import apxi;
import apxk;
import apxm;
import apxp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.lang.ref.WeakReference;

public class ArkAiDictUpdateMgr$8
  implements Runnable
{
  public ArkAiDictUpdateMgr$8(apwz paramapwz, String paramString, apxm paramapxm, apxk paramapxk) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)apwz.a(this.this$0).get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, qq app interface is null, return from task");
      return;
    }
    ((ArkAppCenter)localQQAppInterface.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER)).a().a(this.jdField_a_of_type_JavaLangString, 0L, new apxi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8
 * JD-Core Version:    0.7.0.1
 */