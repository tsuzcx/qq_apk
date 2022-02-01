package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Parcel;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import odq;
import sid;
import sie;

public final class ReportUtil$1
  implements Runnable
{
  public ReportUtil$1(byte[] paramArrayOfByte, long paramLong) {}
  
  public void run()
  {
    try
    {
      Object localObject = Parcel.obtain();
      ((Parcel)localObject).unmarshall(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
      ((Parcel)localObject).setDataPosition(0);
      localObject = new VideoInfo((Parcel)localObject);
      if (localObject == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      VideoInfo localVideoInfo;
      for (;;)
      {
        localException.printStackTrace();
        localVideoInfo = null;
      }
      long l1 = NetConnInfoCenter.getServerTime();
      long l2 = this.jdField_a_of_type_Long;
      odq.a(null, null, "0X800A732", "0X800A732", 0, 0, "", "", "", new sie(localVideoInfo).i(localVideoInfo.g).n(3).i(l1 - l2).a().a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.1
 * JD-Core Version:    0.7.0.1
 */