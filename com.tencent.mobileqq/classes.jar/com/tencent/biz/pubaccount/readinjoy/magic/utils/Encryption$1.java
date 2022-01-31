package com.tencent.biz.pubaccount.readinjoy.magic.utils;

import ooi;
import ook;

public class Encryption$1
  implements Runnable
{
  public void run()
  {
    try
    {
      String str = this.this$0.a(this.jdField_a_of_type_JavaLangString);
      if (str == null) {
        this.jdField_a_of_type_Ook.a(new Exception("Encrypt return null, it normally occurs when you send a null data"));
      }
      this.jdField_a_of_type_Ook.a(str);
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_Ook.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.magic.utils.Encryption.1
 * JD-Core Version:    0.7.0.1
 */