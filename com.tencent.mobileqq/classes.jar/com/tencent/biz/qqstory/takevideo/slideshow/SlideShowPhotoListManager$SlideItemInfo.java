package com.tencent.biz.qqstory.takevideo.slideshow;

import android.text.TextUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class SlideShowPhotoListManager$SlideItemInfo
{
  public String a;
  public URL a;
  
  public SlideShowPhotoListManager$SlideItemInfo(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaNetURL = new File(this.jdField_a_of_type_JavaLangString).toURI().toURL();
      return;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof SlideItemInfo))
    {
      paramObject = (SlideItemInfo)paramObject;
      return TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager.SlideItemInfo
 * JD-Core Version:    0.7.0.1
 */