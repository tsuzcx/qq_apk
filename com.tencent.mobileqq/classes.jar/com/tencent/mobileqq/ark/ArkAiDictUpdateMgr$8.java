package com.tencent.mobileqq.ark;

import alcy;
import aldh;
import aldj;
import aldl;
import aldo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class ArkAiDictUpdateMgr$8
  implements Runnable
{
  public ArkAiDictUpdateMgr$8(alcy paramalcy, String paramString, aldl paramaldl, aldj paramaldj) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)alcy.a(this.this$0).get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, qq app interface is null, return from task");
      return;
    }
    ((ArkAppCenter)localQQAppInterface.getManager(121)).a().a(this.jdField_a_of_type_JavaLangString, 0L, new aldh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8
 * JD-Core Version:    0.7.0.1
 */