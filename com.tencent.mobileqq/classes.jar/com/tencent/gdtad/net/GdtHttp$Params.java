package com.tencent.gdtad.net;

import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import java.net.MalformedURLException;
import java.net.URL;

public class GdtHttp$Params
{
  public int a;
  public String a;
  private URL a;
  public byte[] a;
  public int b;
  public String b;
  public byte[] b;
  public int c;
  public String c;
  
  public GdtHttp$Params()
  {
    this.jdField_a_of_type_Int = 10000;
    this.jdField_b_of_type_Int = 10000;
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaNetURL = new URL(paramString);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      GdtLog.d("GdtHttp", "setUrl " + paramString);
    }
  }
  
  public boolean a()
  {
    boolean bool;
    if ((this.jdField_a_of_type_JavaNetURL != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      bool = true;
    }
    while (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "POST")) {
      if ((bool) && (this.jdField_a_of_type_ArrayOfByte != null))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public boolean b()
  {
    return (a()) && (this.c == 200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.net.GdtHttp.Params
 * JD-Core Version:    0.7.0.1
 */