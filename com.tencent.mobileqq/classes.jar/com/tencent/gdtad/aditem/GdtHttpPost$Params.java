package com.tencent.gdtad.aditem;

import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import java.net.MalformedURLException;
import java.net.URL;

public class GdtHttpPost$Params
{
  public int a;
  public String a;
  URL a;
  public byte[] a;
  public byte[] b;
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaNetURL = new URL(paramString);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      GdtLog.d("GdtHttpPost", "setUrl " + paramString);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaNetURL != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ArrayOfByte != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHttpPost.Params
 * JD-Core Version:    0.7.0.1
 */