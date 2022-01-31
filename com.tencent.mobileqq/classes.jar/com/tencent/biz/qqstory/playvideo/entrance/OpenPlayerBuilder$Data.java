package com.tencent.biz.qqstory.playvideo.entrance;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class OpenPlayerBuilder$Data
  implements Serializable
{
  public transient Bundle mBundle = new Bundle();
  public Serializable mInfo;
  public OpenPlayerBuilder.ReportData mReportData = new OpenPlayerBuilder.ReportData();
  public OpenPlayerBuilder.UIStyle mUIStyle = new OpenPlayerBuilder.UIStyle();
  
  public OpenPlayerBuilder$Data(int paramInt)
  {
    this.mReportData.from = paramInt;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    int i = paramObjectInputStream.readInt();
    byte[] arrayOfByte = new byte[i];
    paramObjectInputStream.readFully(arrayOfByte);
    paramObjectInputStream = Parcel.obtain();
    paramObjectInputStream.unmarshall(arrayOfByte, 0, i);
    paramObjectInputStream.setDataPosition(0);
    this.mBundle = ((Bundle)Bundle.CREATOR.createFromParcel(paramObjectInputStream));
    paramObjectInputStream.recycle();
  }
  
  /* Error */
  private void writeObject(java.io.ObjectOutputStream paramObjectOutputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 89	java/io/ObjectOutputStream:defaultWriteObject	()V
    //   4: invokestatic 60	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 34	com/tencent/biz/qqstory/playvideo/entrance/OpenPlayerBuilder$Data:mBundle	Landroid/os/Bundle;
    //   12: aload_2
    //   13: iconst_0
    //   14: invokevirtual 93	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   17: aload_2
    //   18: invokevirtual 97	android/os/Parcel:marshall	()[B
    //   21: astore_3
    //   22: aload_1
    //   23: aload_3
    //   24: arraylength
    //   25: invokevirtual 100	java/io/ObjectOutputStream:writeInt	(I)V
    //   28: aload_1
    //   29: aload_3
    //   30: invokevirtual 103	java/io/ObjectOutputStream:write	([B)V
    //   33: aload_2
    //   34: invokevirtual 80	android/os/Parcel:recycle	()V
    //   37: return
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 80	android/os/Parcel:recycle	()V
    //   43: return
    //   44: astore_1
    //   45: aload_2
    //   46: invokevirtual 80	android/os/Parcel:recycle	()V
    //   49: aload_1
    //   50: athrow
    //   51: astore_1
    //   52: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	Data
    //   0	53	1	paramObjectOutputStream	java.io.ObjectOutputStream
    //   7	39	2	localParcel	Parcel
    //   21	9	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   22	33	38	java/io/IOException
    //   22	33	44	finally
    //   0	4	51	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data
 * JD-Core Version:    0.7.0.1
 */