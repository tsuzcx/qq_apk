package com.tencent.component.network.downloader.strategy;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.module.base.QDLog;
import pos;

public class DownloadGlobalStrategy$StrategyInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new pos();
  public int a;
  private long jdField_a_of_type_Long;
  public DownloadResult a;
  private IPInfo jdField_a_of_type_ComTencentComponentNetworkDownloaderCommonIPInfo;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d = false;
  
  public DownloadGlobalStrategy$StrategyInfo(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(paramInt, paramBoolean1, paramBoolean2, paramBoolean3, false);
  }
  
  public DownloadGlobalStrategy$StrategyInfo(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    b();
    a();
  }
  
  public DownloadGlobalStrategy$StrategyInfo(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label115;
      }
      bool1 = true;
      label49:
      this.b = bool1;
      if (paramParcel.readInt() != 1) {
        break label120;
      }
      bool1 = true;
      label64:
      this.c = bool1;
      if (paramParcel.readInt() != 1) {
        break label125;
      }
    }
    label115:
    label120:
    label125:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.d = bool1;
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderCommonIPInfo = ((IPInfo)paramParcel.readParcelable(DownloadGlobalStrategy.a().getClassLoader()));
      this.jdField_a_of_type_Long = paramParcel.readLong();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label49;
      bool1 = false;
      break label64;
    }
  }
  
  public DownloadGlobalStrategy$StrategyInfo(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(0, paramBoolean1, paramBoolean2, paramBoolean3, false);
  }
  
  public static int a(StrategyInfo paramStrategyInfo1, StrategyInfo paramStrategyInfo2)
  {
    float f4 = 0.0F;
    float f3 = 0.0F;
    float f1;
    if ((paramStrategyInfo1 != null) && (paramStrategyInfo1.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult != null) && (paramStrategyInfo1.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult.getProcess().c > 0L)) {
      if (paramStrategyInfo1.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult.getContent().size > 0L) {
        f1 = (float)paramStrategyInfo1.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult.getContent().size;
      }
    }
    for (f1 /= (float)paramStrategyInfo1.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult.getProcess().c;; f1 = 0.0F)
    {
      float f2 = f4;
      if (paramStrategyInfo2 != null)
      {
        f2 = f4;
        if (paramStrategyInfo2.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult != null)
        {
          f2 = f4;
          if (paramStrategyInfo2.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult.getProcess().c > 0L)
          {
            f2 = f3;
            if (paramStrategyInfo2.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult.getContent().size > 0L) {
              f2 = (float)paramStrategyInfo2.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult.getContent().size;
            }
            f2 /= (float)paramStrategyInfo2.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult.getProcess().c;
          }
        }
      }
      QDLog.c("DownloadGlobalStrategy", "speed1:" + f1 + " speed2:" + f2);
      return (int)(f1 - f2);
      f1 = 0.0F;
      break;
    }
  }
  
  private void a()
  {
    if (a(DownloadGlobalStrategy.a)) {
      this.jdField_a_of_type_Int = DownloadGlobalStrategy.a.jdField_a_of_type_Int;
    }
    do
    {
      return;
      if (a(DownloadGlobalStrategy.c))
      {
        this.jdField_a_of_type_Int = DownloadGlobalStrategy.c.jdField_a_of_type_Int;
        return;
      }
      if (a(DownloadGlobalStrategy.b))
      {
        this.jdField_a_of_type_Int = DownloadGlobalStrategy.b.jdField_a_of_type_Int;
        return;
      }
      if (a(DownloadGlobalStrategy.d))
      {
        this.jdField_a_of_type_Int = DownloadGlobalStrategy.d.jdField_a_of_type_Int;
        return;
      }
    } while (!a(DownloadGlobalStrategy.e));
    this.jdField_a_of_type_Int = DownloadGlobalStrategy.e.jdField_a_of_type_Int;
  }
  
  private void b()
  {
    if (this.c) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.b = false;
    }
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Int == DownloadGlobalStrategy.e.jdField_a_of_type_Int) {
      return 1800000L;
    }
    return 3600000L;
  }
  
  public IPInfo a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderCommonIPInfo;
  }
  
  public StrategyInfo a()
  {
    StrategyInfo localStrategyInfo = new StrategyInfo(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.b, this.c);
    if (this.jdField_a_of_type_Int > 0) {
      localStrategyInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    }
    return localStrategyInfo;
  }
  
  public void a(IPInfo paramIPInfo)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderCommonIPInfo = paramIPInfo;
  }
  
  public boolean a()
  {
    long l1 = a();
    long l2 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    return (l2 >= 0L) && (l2 <= l1);
  }
  
  public boolean a(IPInfo paramIPInfo1, IPInfo paramIPInfo2)
  {
    if (paramIPInfo1 != null) {
      return paramIPInfo1.equals(paramIPInfo2);
    }
    return paramIPInfo2 == null;
  }
  
  public boolean a(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof StrategyInfo))) {
        break;
      }
      paramObject = (StrategyInfo)paramObject;
    } while ((paramObject.d == this.d) && (paramObject.jdField_a_of_type_Boolean == this.jdField_a_of_type_Boolean) && (paramObject.c == this.c) && (paramObject.b == this.b) && (a(paramObject.jdField_a_of_type_ComTencentComponentNetworkDownloaderCommonIPInfo, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderCommonIPInfo)));
    return false;
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof StrategyInfo))) {
        break;
      }
      paramObject = (StrategyInfo)paramObject;
    } while ((paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (paramObject.jdField_a_of_type_Boolean == this.jdField_a_of_type_Boolean) && (paramObject.c == this.c) && (paramObject.b == this.b) && (a(paramObject.jdField_a_of_type_ComTencentComponentNetworkDownloaderCommonIPInfo, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderCommonIPInfo)));
    return false;
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("(id:").append(this.jdField_a_of_type_Int).append(";").append(this.jdField_a_of_type_Boolean).append(";").append(this.b).append(";").append(this.c).append(";");
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderCommonIPInfo != null) {}
    for (String str = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderCommonIPInfo.toString();; str = "N/A") {
      return new String(str + ")");
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.b) {
        break label94;
      }
      paramInt = 1;
      label38:
      paramParcel.writeInt(paramInt);
      if (!this.c) {
        break label99;
      }
      paramInt = 1;
      label52:
      paramParcel.writeInt(paramInt);
      if (!this.d) {
        break label104;
      }
    }
    label94:
    label99:
    label104:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderCommonIPInfo, 0);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label38;
      paramInt = 0;
      break label52;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo
 * JD-Core Version:    0.7.0.1
 */