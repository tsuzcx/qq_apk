package com.tencent.mobileqq.ark;

import anmm;
import anmv;
import anmx;
import anmz;
import annc;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class ArkAiDictUpdateMgr$8
  implements Runnable
{
  public ArkAiDictUpdateMgr$8(anmm paramanmm, String paramString, anmz paramanmz, anmx paramanmx) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)anmm.a(this.this$0).get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, qq app interface is null, return from task");
      return;
    }
    ((ArkAppCenter)localQQAppInterface.getManager(121)).a().a(this.jdField_a_of_type_JavaLangString, 0L, new anmv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8
 * JD-Core Version:    0.7.0.1
 */