package com.tencent.mobileqq.ark;

import aldh;
import aldj;
import aldl;
import axxj;
import java.lang.ref.WeakReference;

public class ArkAiDictUpdateMgr$8$1$1
  implements Runnable
{
  public ArkAiDictUpdateMgr$8$1$1(aldh paramaldh, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aldh.a.jdField_a_of_type_Aldl.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, weakPreDownloadCtrl is null, return");
      return;
    }
    axxj localaxxj = (axxj)this.jdField_a_of_type_Aldh.a.jdField_a_of_type_Aldl.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localaxxj == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, preDownloadController is null, return");
      return;
    }
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    long l;
    if (this.jdField_a_of_type_Aldh.a.jdField_a_of_type_Aldl.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Boolean)
      {
        String str = this.jdField_a_of_type_Aldh.a.jdField_a_of_type_JavaLangString;
        if (arrayOfByte == null)
        {
          l = 0L;
          localaxxj.a(str, l);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aldh.a.jdField_a_of_type_Aldj.a(arrayOfByte);
      return;
      l = arrayOfByte.length;
      break;
      localaxxj.a(this.jdField_a_of_type_Aldh.a.jdField_a_of_type_JavaLangString, -1L);
      arrayOfByte = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8.1.1
 * JD-Core Version:    0.7.0.1
 */