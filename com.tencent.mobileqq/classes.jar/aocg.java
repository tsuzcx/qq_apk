import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x935.oidb_0x935.GPS;

class aocg
  extends SosoInterface.OnLocationListener
{
  aocg(aoce paramaoce, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopManagerImp", 2, "onLocationFinish errCode: " + paramInt + ", info: " + paramSosoLbsInfo);
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      return;
    }
    if (paramInt != 0)
    {
      this.a.a(2L, null, 22);
      return;
    }
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      double d3 = paramSosoLbsInfo.mLocation.mLon02;
      double d4 = paramSosoLbsInfo.mLocation.mLat02;
      double d1 = paramSosoLbsInfo.mLocation.altitude;
      int j = (int)paramSosoLbsInfo.mLocation.accuracy;
      String str1 = paramSosoLbsInfo.mLocation.mProviderSource;
      String str2 = paramSosoLbsInfo.mLocation.mVerifyKey;
      int k = paramSosoLbsInfo.mLocation.fakeReason;
      double d2 = paramSosoLbsInfo.mLocation.locationTime;
      float f = paramSosoLbsInfo.mLocation.speed;
      String str3 = paramSosoLbsInfo.mLocation.cityCode;
      paramInt = 0;
      try
      {
        int i = Integer.parseInt(str3);
        paramInt = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("RecommendTroopManagerImp", 1, "parse cityCode error");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendTroopManagerImp", 2, "onLocationFinish longitude=" + d3 + ", latitude=" + d4 + ", accuracy=" + j + ", verifyKey=" + str2 + ", source=" + str1 + ", fakeReason=" + k + ", speed=" + f + ", locationTime=" + d2);
      }
      d3 = Double.valueOf(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D).intValue();
      d4 = Double.valueOf(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D).intValue();
      paramSosoLbsInfo = new oidb_0x935.GPS();
      paramSosoLbsInfo.uint32_latitude.set((int)d3);
      paramSosoLbsInfo.uint32_longitude.set((int)d4);
      paramSosoLbsInfo.uint32_altitude.set((int)d1);
      paramSosoLbsInfo.uint32_accuracy.set(j);
      paramSosoLbsInfo.uint32_time.set((int)d2);
      paramSosoLbsInfo.uint32_cityid.set(paramInt);
      paramSosoLbsInfo.bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.4.10"));
      paramSosoLbsInfo.uint32_client.set(2);
      this.a.a(2L, paramSosoLbsInfo, 22);
      return;
    }
    this.a.a(2L, null, 22);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aocg
 * JD-Core Version:    0.7.0.1
 */