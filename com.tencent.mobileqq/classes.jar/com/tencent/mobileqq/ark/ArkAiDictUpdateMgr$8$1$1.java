package com.tencent.mobileqq.ark;

import anim;
import anio;
import aniq;
import bavr;
import java.lang.ref.WeakReference;

public class ArkAiDictUpdateMgr$8$1$1
  implements Runnable
{
  public ArkAiDictUpdateMgr$8$1$1(anim paramanim, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Anim.a.jdField_a_of_type_Aniq.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, weakPreDownloadCtrl is null, return");
      return;
    }
    bavr localbavr = (bavr)this.jdField_a_of_type_Anim.a.jdField_a_of_type_Aniq.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbavr == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, preDownloadController is null, return");
      return;
    }
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    long l;
    if (this.jdField_a_of_type_Anim.a.jdField_a_of_type_Aniq.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Boolean)
      {
        String str = this.jdField_a_of_type_Anim.a.jdField_a_of_type_JavaLangString;
        if (arrayOfByte == null)
        {
          l = 0L;
          localbavr.a(str, l);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Anim.a.jdField_a_of_type_Anio.a(arrayOfByte);
      return;
      l = arrayOfByte.length;
      break;
      localbavr.a(this.jdField_a_of_type_Anim.a.jdField_a_of_type_JavaLangString, -1L);
      arrayOfByte = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8.1.1
 * JD-Core Version:    0.7.0.1
 */