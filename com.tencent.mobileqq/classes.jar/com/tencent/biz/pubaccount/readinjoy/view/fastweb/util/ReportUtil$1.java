package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Parcel;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import olh;
import sut;
import suu;

public final class ReportUtil$1
  implements Runnable
{
  public ReportUtil$1(byte[] paramArrayOfByte, long paramLong) {}
  
  public void run()
  {
    label53:
    for (;;)
    {
      try
      {
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
        localParcel.setDataPosition(0);
        localVideoInfo = new VideoInfo(localParcel);
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localParcel.recycle();
          if (localVideoInfo != null) {
            break;
          }
          return;
        }
        catch (Exception localException2)
        {
          VideoInfo localVideoInfo;
          long l1;
          long l2;
          break label53;
        }
        localException1 = localException1;
        localVideoInfo = null;
      }
    }
    l1 = NetConnInfoCenter.getServerTime();
    l2 = this.jdField_a_of_type_Long;
    olh.a(null, null, "0X800A732", "0X800A732", 0, 0, "", "", "", new suu(localVideoInfo).i(localVideoInfo.g).n(3).i(l1 - l2).a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.1
 * JD-Core Version:    0.7.0.1
 */