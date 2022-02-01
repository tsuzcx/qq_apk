package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.sina.weibo.sdk.c.c;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class ImageObject
  extends MediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 1048576;
  public static final Parcelable.Creator<ImageObject> CREATOR = new ImageObject.1();
  private static final int PATH_LENGTH_LIMIT = 512;
  private static final String TAG = "ImageObject";
  private static final long serialVersionUID = 8760548583231081050L;
  public byte[] imageData;
  public String imagePath;
  
  public ImageObject() {}
  
  protected ImageObject(Parcel paramParcel)
  {
    this.imageData = paramParcel.createByteArray();
    this.imagePath = paramParcel.readString();
  }
  
  private int getFileSize(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {}
    }
    else
    {
      return 0;
    }
    return (int)paramString.length();
  }
  
  public boolean checkArgs()
  {
    if (((this.imageData != null) && (this.imageData.length != 0)) || ((this.imagePath != null) && (this.imagePath.length() != 0)))
    {
      if ((this.imageData != null) && (this.imageData.length > 1048576))
      {
        c.b("ImageObject", "checkArgs fail, content is too large");
        return false;
      }
      if ((this.imagePath != null) && (this.imagePath.length() > 512))
      {
        c.b("ImageObject", "checkArgs fail, path is invalid");
        return false;
      }
      if ((this.imagePath != null) && (getFileSize(this.imagePath) > 1048576))
      {
        c.b("ImageObject", "checkArgs fail, image content is too large");
        return false;
      }
      return true;
    }
    c.b("ImageObject", "checkArgs fail, all arguments are null");
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void setImageData(Bitmap paramBitmap)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
      this.imageData = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return;
    }
    catch (Exception paramBitmap)
    {
      c.b("ImageObject", "ImageObject :" + paramBitmap.getMessage());
    }
  }
  
  public void setImagePath(String paramString)
  {
    this.imagePath = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.imageData);
    paramParcel.writeString(this.imagePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.api.ImageObject
 * JD-Core Version:    0.7.0.1
 */