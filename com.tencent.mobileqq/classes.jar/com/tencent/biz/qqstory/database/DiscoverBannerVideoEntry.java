package com.tencent.biz.qqstory.database;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.List;

public class DiscoverBannerVideoEntry
  extends Entity
{
  public static final String TAG = "Q.qqstory.discover.DiscoverBannerVideoEntry";
  @unique
  public String bannerId;
  @notColumn
  public List<DiscoverBannerVideoEntry.BannerInfo> bannerInfoList;
  public byte[] bannerInfoListByte;
  public String nextCookie;
  public int totalCount;
  
  /* Error */
  public List<DiscoverBannerVideoEntry.BannerInfo> convertBytesToList(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: new 36	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 37	java/util/ArrayList:<init>	()V
    //   18: astore_2
    //   19: aload 4
    //   21: aload_1
    //   22: iconst_0
    //   23: aload_1
    //   24: arraylength
    //   25: invokevirtual 41	android/os/Parcel:unmarshall	([BII)V
    //   28: aload 4
    //   30: iconst_0
    //   31: invokevirtual 45	android/os/Parcel:setDataPosition	(I)V
    //   34: aload 4
    //   36: aload_2
    //   37: getstatic 51	com/tencent/biz/qqstory/database/DiscoverBannerVideoEntry$BannerInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   40: invokevirtual 55	android/os/Parcel:readTypedList	(Ljava/util/List;Landroid/os/Parcelable$Creator;)V
    //   43: aload_2
    //   44: astore_3
    //   45: goto +62 -> 107
    //   48: astore_3
    //   49: aload_2
    //   50: astore_1
    //   51: aload_3
    //   52: astore_2
    //   53: goto +10 -> 63
    //   56: astore_1
    //   57: goto +57 -> 114
    //   60: astore_2
    //   61: aconst_null
    //   62: astore_1
    //   63: aload_1
    //   64: astore_3
    //   65: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +39 -> 107
    //   71: new 63	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   78: astore_3
    //   79: aload_3
    //   80: ldc 66
    //   82: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_3
    //   87: aload_2
    //   88: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   91: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: ldc 8
    //   97: iconst_2
    //   98: aload_3
    //   99: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_1
    //   106: astore_3
    //   107: aload 4
    //   109: invokevirtual 84	android/os/Parcel:recycle	()V
    //   112: aload_3
    //   113: areturn
    //   114: aload 4
    //   116: invokevirtual 84	android/os/Parcel:recycle	()V
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	DiscoverBannerVideoEntry
    //   0	121	1	paramArrayOfByte	byte[]
    //   18	35	2	localObject1	Object
    //   60	28	2	localException1	java.lang.Exception
    //   44	1	3	localObject2	Object
    //   48	4	3	localException2	java.lang.Exception
    //   64	49	3	localObject3	Object
    //   9	106	4	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   19	43	48	java/lang/Exception
    //   11	19	56	finally
    //   19	43	56	finally
    //   65	105	56	finally
    //   11	19	60	java/lang/Exception
  }
  
  /* Error */
  public byte[] convertListToBytes()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	com/tencent/biz/qqstory/database/DiscoverBannerVideoEntry:bannerInfoList	Ljava/util/List;
    //   4: astore_1
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_1
    //   8: ifnonnull +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   16: astore_3
    //   17: aload_3
    //   18: aload_0
    //   19: getfield 90	com/tencent/biz/qqstory/database/DiscoverBannerVideoEntry:bannerInfoList	Ljava/util/List;
    //   22: invokevirtual 94	android/os/Parcel:writeTypedList	(Ljava/util/List;)V
    //   25: aload_3
    //   26: invokevirtual 97	android/os/Parcel:marshall	()[B
    //   29: astore_1
    //   30: aload_3
    //   31: invokevirtual 84	android/os/Parcel:recycle	()V
    //   34: aload_1
    //   35: areturn
    //   36: astore_1
    //   37: goto +53 -> 90
    //   40: astore 4
    //   42: aload_2
    //   43: astore_1
    //   44: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq -17 -> 30
    //   50: new 63	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   57: astore_1
    //   58: aload_1
    //   59: ldc 99
    //   61: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_1
    //   66: aload 4
    //   68: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   71: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: ldc 8
    //   77: iconst_2
    //   78: aload_1
    //   79: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload_2
    //   86: astore_1
    //   87: goto -57 -> 30
    //   90: aload_3
    //   91: invokevirtual 84	android/os/Parcel:recycle	()V
    //   94: goto +5 -> 99
    //   97: aload_1
    //   98: athrow
    //   99: goto -2 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	DiscoverBannerVideoEntry
    //   4	31	1	localObject1	Object
    //   36	1	1	localObject2	Object
    //   43	55	1	localObject3	Object
    //   6	80	2	localObject4	Object
    //   16	75	3	localParcel	android.os.Parcel
    //   40	27	4	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   17	30	36	finally
    //   44	85	36	finally
    //   17	30	40	java/lang/Exception
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (DiscoverBannerVideoEntry)paramObject;
    return TextUtils.equals(this.bannerId, paramObject.bannerId);
  }
  
  protected void postRead()
  {
    this.bannerInfoList = convertBytesToList(this.bannerInfoListByte);
  }
  
  protected void prewrite()
  {
    this.bannerInfoListByte = convertListToBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry
 * JD-Core Version:    0.7.0.1
 */