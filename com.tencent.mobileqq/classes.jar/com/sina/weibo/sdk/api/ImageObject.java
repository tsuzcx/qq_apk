package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.sina.weibo.sdk.c.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

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
      if (!paramString.exists()) {
        return 0;
      }
      return (int)paramString.length();
    }
    return 0;
  }
  
  public boolean checkArgs()
  {
    Object localObject = this.imageData;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = this.imagePath;
      if ((localObject == null) || (((String)localObject).length() == 0)) {}
    }
    else
    {
      localObject = this.imageData;
      if ((localObject != null) && (localObject.length > 1048576))
      {
        c.b("ImageObject", "checkArgs fail, content is too large");
        return false;
      }
      localObject = this.imagePath;
      if ((localObject != null) && (((String)localObject).length() > 512))
      {
        c.b("ImageObject", "checkArgs fail, path is invalid");
        return false;
      }
      localObject = this.imagePath;
      if ((localObject != null) && (getFileSize((String)localObject) > 1048576))
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
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject);
      this.imageData = ((ByteArrayOutputStream)localObject).toByteArray();
      ((ByteArrayOutputStream)localObject).close();
      return;
    }
    catch (Exception paramBitmap)
    {
      Object localObject = new StringBuilder("ImageObject :");
      ((StringBuilder)localObject).append(paramBitmap.getMessage());
      c.b("ImageObject", ((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.api.ImageObject
 * JD-Core Version:    0.7.0.1
 */