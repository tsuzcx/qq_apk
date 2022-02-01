package com.tencent.av.app;

import androidx.annotation.RequiresApi;
import com.tencent.av.VideoController;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.mediacodec.AndroidCodecUtil;
import com.tencent.avcore.util.GlStringParser;
import com.tencent.qphone.base.util.QLog;

public class DeviceCapability
{
  @RequiresApi(api=16)
  public static void a(long paramLong, VideoController paramVideoController, DeviceCapability.CodecPlayerCallback.CodecTestInfo paramCodecTestInfo, DeviceCapability.CodecPlayerCallback paramCodecPlayerCallback)
  {
    long l1 = System.currentTimeMillis();
    String str = paramCodecTestInfo.a();
    paramVideoController = paramVideoController.a(paramLong, paramCodecTestInfo.a(), str.getBytes());
    long l2 = System.currentTimeMillis();
    if (paramVideoController == null) {}
    for (paramVideoController = "";; paramVideoController = new String(paramVideoController))
    {
      QLog.w("DeviceCapability", 1, "doCodecTest, codec[" + paramCodecTestInfo.jdField_a_of_type_Int + "], sampleMD5[" + paramCodecTestInfo.jdField_a_of_type_JavaLangString + "], cmdParams[" + str + "], result[" + paramVideoController + "], cost[" + (l2 - l1) + "], seq[" + paramLong + "]");
      AndroidCodecUtil.a();
      QLog.w("DeviceCapability", 1, "doCodecTest get_info_test numCores: " + VcSystemInfo.getNumCores() + ", cpu frep: " + VcSystemInfo.getMaxCpuFreq() + ", memory: " + VcSystemInfo.getMemoryTotal() + ", output format: " + AndroidCodec.getHwDetectOutputFormatForReport() + ", H264EncBaseLineLevel: " + AndroidCodecUtil.jdField_a_of_type_Int + ", H264DecBaseLineLevel: " + AndroidCodecUtil.b + ", H264EncHighProfileLevel: " + AndroidCodecUtil.c + ", H264DecHighProfileLevel: " + AndroidCodecUtil.d + ", H265EncLevel: " + AndroidCodecUtil.e + ", H265DecLevel: " + AndroidCodecUtil.f);
      paramCodecTestInfo = new GlStringParser('=', ';');
      paramCodecTestInfo.unflatten(paramVideoController);
      paramCodecPlayerCallback.a(paramCodecTestInfo.getInt("i_resultCode", -99), "", 0, paramCodecTestInfo.getInt("i_delay", -99), null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapability
 * JD-Core Version:    0.7.0.1
 */