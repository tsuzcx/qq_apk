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
    if (paramVideoController == null) {
      paramVideoController = "";
    } else {
      paramVideoController = new String(paramVideoController);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doCodecTest, codec[");
    localStringBuilder.append(paramCodecTestInfo.jdField_a_of_type_Int);
    localStringBuilder.append("], sampleMD5[");
    localStringBuilder.append(paramCodecTestInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("], cmdParams[");
    localStringBuilder.append(str);
    localStringBuilder.append("], result[");
    localStringBuilder.append(paramVideoController);
    localStringBuilder.append("], cost[");
    localStringBuilder.append(l2 - l1);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("DeviceCapability", 1, localStringBuilder.toString());
    AndroidCodecUtil.a();
    paramCodecTestInfo = new StringBuilder();
    paramCodecTestInfo.append("doCodecTest get_info_test numCores: ");
    paramCodecTestInfo.append(VcSystemInfo.getNumCores());
    paramCodecTestInfo.append(", cpu frep: ");
    paramCodecTestInfo.append(VcSystemInfo.getMaxCpuFreq());
    paramCodecTestInfo.append(", memory: ");
    paramCodecTestInfo.append(VcSystemInfo.getMemoryTotal());
    paramCodecTestInfo.append(", output format: ");
    paramCodecTestInfo.append(AndroidCodec.getHwDetectOutputFormatForReport());
    paramCodecTestInfo.append(", H264EncBaseLineLevel: ");
    paramCodecTestInfo.append(AndroidCodecUtil.jdField_a_of_type_Int);
    paramCodecTestInfo.append(", H264DecBaseLineLevel: ");
    paramCodecTestInfo.append(AndroidCodecUtil.b);
    paramCodecTestInfo.append(", H264EncHighProfileLevel: ");
    paramCodecTestInfo.append(AndroidCodecUtil.c);
    paramCodecTestInfo.append(", H264DecHighProfileLevel: ");
    paramCodecTestInfo.append(AndroidCodecUtil.d);
    paramCodecTestInfo.append(", H265EncLevel: ");
    paramCodecTestInfo.append(AndroidCodecUtil.e);
    paramCodecTestInfo.append(", H265DecLevel: ");
    paramCodecTestInfo.append(AndroidCodecUtil.f);
    QLog.w("DeviceCapability", 1, paramCodecTestInfo.toString());
    paramCodecTestInfo = new GlStringParser('=', ';');
    paramCodecTestInfo.unflatten(paramVideoController);
    paramCodecPlayerCallback.a(paramCodecTestInfo.getInt("i_resultCode", -99), "", 0, paramCodecTestInfo.getInt("i_delay", -99), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapability
 * JD-Core Version:    0.7.0.1
 */