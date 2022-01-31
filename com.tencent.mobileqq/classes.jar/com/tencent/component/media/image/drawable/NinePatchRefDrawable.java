package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.component.media.image.BitmapReference;

public class NinePatchRefDrawable
  extends NinePatchDrawable
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private BitmapReference jdField_a_of_type_ComTencentComponentMediaImageBitmapReference;
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public NinePatchRefDrawable(Resources paramResources, BitmapReference paramBitmapReference, byte[] paramArrayOfByte, Rect paramRect, String paramString) {}
  
  public BitmapReference getBitmapRef()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference;
  }
  
  public boolean isMulible()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference != null) {
      return this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.isMutable();
    }
    return false;
  }
  
  public Drawable newInstance()
  {
    try
    {
      NinePatchRefDrawable localNinePatchRefDrawable = new NinePatchRefDrawable(this.jdField_a_of_type_AndroidContentResResources, this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_JavaLangString);
      return localNinePatchRefDrawable;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.NinePatchRefDrawable
 * JD-Core Version:    0.7.0.1
 */