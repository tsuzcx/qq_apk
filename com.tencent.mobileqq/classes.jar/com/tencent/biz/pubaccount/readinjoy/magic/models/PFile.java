package com.tencent.biz.pubaccount.readinjoy.magic.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.File;
import oof;

public class PFile
  extends File
  implements Parcelable
{
  public static final Parcelable.Creator<PFile> CREATOR = new oof();
  public final String content;
  
  public PFile(Parcel paramParcel)
  {
    super(paramParcel.readString());
    this.content = paramParcel.readString();
  }
  
  protected PFile(String paramString)
  {
    super(paramString);
    this.content = readFile(paramString);
  }
  
  /* Error */
  static String readFile(String paramString)
  {
    // Byte code:
    //   0: new 41	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: new 44	java/io/BufferedReader
    //   11: dup
    //   12: new 46	java/io/FileReader
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 47	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   20: invokespecial 50	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_2
    //   24: aload_2
    //   25: invokevirtual 53	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_1
    //   29: ldc 55
    //   31: astore_0
    //   32: aload_1
    //   33: ifnull +24 -> 57
    //   36: aload_3
    //   37: aload_0
    //   38: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: ldc 61
    //   48: astore_0
    //   49: aload_2
    //   50: invokevirtual 53	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore_1
    //   54: goto -22 -> 32
    //   57: aload_3
    //   58: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore_0
    //   62: aload_2
    //   63: ifnull +7 -> 70
    //   66: aload_2
    //   67: invokevirtual 67	java/io/BufferedReader:close	()V
    //   70: aload_0
    //   71: areturn
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +7 -> 83
    //   79: aload_1
    //   80: invokevirtual 67	java/io/BufferedReader:close	()V
    //   83: aload_0
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: areturn
    //   88: astore_1
    //   89: goto -6 -> 83
    //   92: astore_0
    //   93: aload_2
    //   94: astore_1
    //   95: goto -20 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramString	String
    //   28	52	1	str	String
    //   85	1	1	localIOException1	java.io.IOException
    //   88	1	1	localIOException2	java.io.IOException
    //   94	1	1	localBufferedReader1	java.io.BufferedReader
    //   23	71	2	localBufferedReader2	java.io.BufferedReader
    //   7	51	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	24	72	finally
    //   66	70	85	java/io/IOException
    //   79	83	88	java/io/IOException
    //   24	29	92	finally
    //   36	46	92	finally
    //   49	54	92	finally
    //   57	62	92	finally
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long length()
  {
    return this.content.length();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(getAbsolutePath());
    paramParcel.writeString(this.content);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.magic.models.PFile
 * JD-Core Version:    0.7.0.1
 */