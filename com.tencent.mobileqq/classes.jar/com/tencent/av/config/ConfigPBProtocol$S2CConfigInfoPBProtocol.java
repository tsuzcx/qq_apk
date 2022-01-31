package com.tencent.av.config;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import jjl;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.AndroidCameraInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.AudioSwitchPointInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.CmdToClientConfigInfoRspBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.MobileQQPttInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.PutinfoHead;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.RspBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.SharpTraeInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.TransBuffer;

public class ConfigPBProtocol$S2CConfigInfoPBProtocol
{
  private ConfigPBProtocol.ConfigSysInfoNew jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew = new ConfigPBProtocol.ConfigSysInfoNew(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol);
  private hd_video_putinfo.RspBody jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody = new hd_video_putinfo.RspBody();
  
  public ConfigPBProtocol$S2CConfigInfoPBProtocol(ConfigPBProtocol paramConfigPBProtocol) {}
  
  private int a()
  {
    int k = 0;
    int i;
    if (!this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_to_client_config_info_rsq_body.has()) {
      i = -1;
    }
    Object localObject1;
    boolean bool;
    int j;
    label1260:
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            localObject1 = (hd_video_putinfo.CmdToClientConfigInfoRspBody)this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_to_client_config_info_rsq_body.get();
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint32_log_flag.has())
            {
              i = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint32_log_flag.get();
              localObject2 = this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew;
              if (i != 0) {
                break;
              }
              bool = false;
              ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_Boolean = bool;
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).bytes_log_report_time.has()) {
              ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).bytes_log_report_time.get().toStringUtf8();
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_android_camera_set.has())
            {
              localObject2 = (hd_video_putinfo.AndroidCameraInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_android_camera_set.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjg.a = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param1.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjg.b = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param2.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjg.c = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param3.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjg.d = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param4.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjg.e = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param5.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjg.f = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param6.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjg.g = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param7.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjg.h = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param8.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjg.i = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param9.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjg.j = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param10.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjg.k = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param11.get());
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjg.l = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param12.get());
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_sharp_trae_info_set.has())
            {
              localObject2 = (hd_video_putinfo.SharpTraeInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_sharp_trae_info_set.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjj.jdField_a_of_type_Int = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_source.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjj.jdField_b_of_type_Int = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_interface.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjj.c = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_stream_type.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjj.d = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_volume.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjj.e = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_mode.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjj.f = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_arm_flag.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjj.g = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_cpu_hertz.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjj.h = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_audio_set.get();
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint64_switch.has())
            {
              long l = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint64_switch.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjk.a = ((byte)(int)(l & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjk.b = ((byte)(int)(l >> 1 & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjk.c = ((byte)(int)(l >> 2 & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjk.d = ((byte)(int)(l >> 3 & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjk.e = ((byte)(int)(l >> 4 & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjk.f = ((byte)(int)(l >> 5 & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjk.g = ((byte)(int)(l >> 6 & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjk.h = ((byte)(int)(l >> 7 & 1L));
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjk.i = ((byte)(int)(l >> 13 & 1L));
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_qq_ptt_info_set.has())
            {
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.jdField_a_of_type_Boolean = true;
              localObject2 = (hd_video_putinfo.MobileQQPttInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_qq_ptt_info_set.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.jdField_a_of_type_Int = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param1.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.jdField_b_of_type_Int = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param2.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.c = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param3.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.d = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param4.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.e = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param5.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.f = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param6.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.g = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param7.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.h = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param8.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.i = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param9.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.j = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param10.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.k = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param11.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.l = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param12.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.m = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param13.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.n = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param14.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jji.o = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param15.get();
            }
            if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_audio_quality_set.has())
            {
              localObject2 = (hd_video_putinfo.AudioSwitchPointInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_audio_quality_set.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjh.jdField_a_of_type_Int = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_shake.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjh.jdField_b_of_type_Int = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_time_delay.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjh.c = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_pack_loss.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjh.d = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_pack_loss_rate.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjh.jdField_a_of_type_JavaLangString = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).bytes_wifi_words.get().toStringUtf8();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjh.e = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_shake.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjh.f = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_time_delay.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjh.g = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_pack_loss.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjh.h = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_pack_loss_rate.get();
              this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_Jjh.jdField_b_of_type_JavaLangString = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).bytes_nowifi_words.get().toStringUtf8();
            }
            i = k;
          } while (!((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).rpt_msg_trans_buffer_list.has());
          localObject1 = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).rpt_msg_trans_buffer_list.get();
          i = k;
        } while (localObject1 == null);
        i = k;
      } while (((List)localObject1).size() <= 0);
      j = 0;
      i = k;
    } while (j >= ((List)localObject1).size());
    Object localObject2 = this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew;
    localObject2.getClass();
    localObject2 = new jjl((ConfigPBProtocol.ConfigSysInfoNew)localObject2);
    ((jjl)localObject2).jdField_a_of_type_Int = ((hd_video_putinfo.TransBuffer)((List)localObject1).get(j)).uint32_type.get();
    ((jjl)localObject2).jdField_a_of_type_JavaLangString = ((hd_video_putinfo.TransBuffer)((List)localObject1).get(j)).bytes_content.get().toStringUtf8();
    this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_JavaUtilList.add(localObject2);
    if (((jjl)localObject2).jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_a_of_type_JavaLangString = ((jjl)localObject2).jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      j += 1;
      break label1260;
      bool = true;
      break;
      if (((jjl)localObject2).jdField_a_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew.jdField_b_of_type_JavaLangString = ((jjl)localObject2).jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    try
    {
      this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.mergeFrom(paramArrayOfByte);
      if (!this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_putinfo_head.has()) {
        return -1;
      }
      paramArrayOfByte = (hd_video_putinfo.PutinfoHead)this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$RspBody.msg_putinfo_head.get();
      if ((paramArrayOfByte != null) && (paramArrayOfByte.uint32_error_no.has()) && (paramArrayOfByte.uint32_error_no.get() == 0) && (paramArrayOfByte.enum_body_type.has()) && (paramArrayOfByte.enum_body_type.get() == 2))
      {
        if (paramArrayOfByte.bytes_config_ver.has()) {
          ConfigPBProtocol.jdField_a_of_type_JavaLangString = paramArrayOfByte.bytes_config_ver.get().toStringUtf8();
        }
        int i = a();
        return i;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -1;
  }
  
  public ConfigPBProtocol.ConfigSysInfoNew a()
  {
    return this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.config.ConfigPBProtocol.S2CConfigInfoPBProtocol
 * JD-Core Version:    0.7.0.1
 */