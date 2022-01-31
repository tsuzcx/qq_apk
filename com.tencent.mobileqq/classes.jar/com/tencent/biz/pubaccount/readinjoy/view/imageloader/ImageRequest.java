package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.graphics.Bitmap.Config;
import java.net.URL;

public class ImageRequest
{
  public int a;
  Bitmap.Config a;
  public URL a;
  public volatile boolean a;
  public int b;
  
  public ImageRequest()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof ImageRequest))) {
        return false;
      }
      paramObject = (ImageRequest)paramObject;
      if ((this.jdField_a_of_type_JavaNetURL != null) && (this.jdField_a_of_type_JavaNetURL.equals(paramObject.jdField_a_of_type_JavaNetURL))) {}
      for (int i = 1; i == 0; i = 0) {
        return false;
      }
    } while ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.b == paramObject.b) && (this.jdField_a_of_type_AndroidGraphicsBitmap$Config == paramObject.jdField_a_of_type_AndroidGraphicsBitmap$Config));
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaNetURL == null) {
      return 0;
    }
    return (this.jdField_a_of_type_JavaNetURL.getPath() + this.jdField_a_of_type_Int + this.b + this.jdField_a_of_type_AndroidGraphicsBitmap$Config).hashCode();
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaNetURL.getPath() + " " + this.jdField_a_of_type_Int + "x" + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest
 * JD-Core Version:    0.7.0.1
 */