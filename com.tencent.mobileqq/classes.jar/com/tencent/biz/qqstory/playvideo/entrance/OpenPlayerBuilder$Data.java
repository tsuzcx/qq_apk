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
    //   33: goto +10 -> 43
    //   36: astore_1
    //   37: aload_2
    //   38: invokevirtual 80	android/os/Parcel:recycle	()V
    //   41: aload_1
    //   42: athrow
    //   43: aload_2
    //   44: invokevirtual 80	android/os/Parcel:recycle	()V
    //   47: return
    //   48: astore_1
    //   49: return
    //   50: astore_1
    //   51: goto -8 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	Data
    //   0	54	1	paramObjectOutputStream	java.io.ObjectOutputStream
    //   7	37	2	localParcel	Parcel
    //   21	9	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   22	33	36	finally
    //   0	4	48	java/io/IOException
    //   22	33	50	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data
 * JD-Core Version:    0.7.0.1
 */