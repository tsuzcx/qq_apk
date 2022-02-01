package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Parcel;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;

final class ReportUtil$1
  implements Runnable
{
  ReportUtil$1(byte[] paramArrayOfByte, long paramLong) {}
  
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
        localObject = new VideoInfo(localParcel);
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localParcel.recycle();
          if (localObject != null) {
            break;
          }
          return;
        }
        catch (Exception localException2)
        {
          Object localObject;
          long l1;
          long l2;
          break label53;
        }
        localException1 = localException1;
        localObject = null;
      }
    }
    l1 = NetConnInfoCenter.getServerTime();
    l2 = this.jdField_a_of_type_Long;
    localObject = new VideoR5.Builder((VideoInfo)localObject).i(((VideoInfo)localObject).g).n(3).o(((VideoInfo)localObject).q).i(l1 - l2).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A732", "0X800A732", 0, 0, "", "", "", (String)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.1
 * JD-Core Version:    0.7.0.1
 */