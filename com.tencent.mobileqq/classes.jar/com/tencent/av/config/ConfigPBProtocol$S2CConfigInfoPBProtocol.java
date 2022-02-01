package com.tencent.av.config;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
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
  private ConfigPBProtocol.ConfigSysInfoNew b = new ConfigPBProtocol.ConfigSysInfoNew(this.a);
  private hd_video_putinfo.RspBody c = new hd_video_putinfo.RspBody();
  
  public ConfigPBProtocol$S2CConfigInfoPBProtocol(ConfigPBProtocol paramConfigPBProtocol) {}
  
  private int b()
  {
    if (!this.c.msg_to_client_config_info_rsq_body.has()) {
      return -1;
    }
    Object localObject1 = (hd_video_putinfo.CmdToClientConfigInfoRspBody)this.c.msg_to_client_config_info_rsq_body.get();
    int i;
    Object localObject2;
    if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint32_log_flag.has())
    {
      i = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint32_log_flag.get();
      localObject2 = this.b;
      boolean bool;
      if (i == 0) {
        bool = false;
      } else {
        bool = true;
      }
      ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).a = bool;
    }
    if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).bytes_log_report_time.has()) {
      ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).bytes_log_report_time.get().toStringUtf8();
    }
    if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_android_camera_set.has())
    {
      localObject2 = (hd_video_putinfo.AndroidCameraInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_android_camera_set.get();
      this.b.d.a = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param1.get());
      this.b.d.b = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param2.get());
      this.b.d.c = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param3.get());
      this.b.d.d = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param4.get());
      this.b.d.e = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param5.get());
      this.b.d.f = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param6.get());
      this.b.d.g = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param7.get());
      this.b.d.h = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param8.get());
      this.b.d.i = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param9.get());
      this.b.d.j = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param10.get());
      this.b.d.k = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param11.get());
      this.b.d.l = ((byte)((hd_video_putinfo.AndroidCameraInfo)localObject2).uint32_param12.get());
    }
    if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_sharp_trae_info_set.has())
    {
      localObject2 = (hd_video_putinfo.SharpTraeInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_sharp_trae_info_set.get();
      this.b.e.a = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_source.get();
      this.b.e.b = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_interface.get();
      this.b.e.c = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_stream_type.get();
      this.b.e.d = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_volume.get();
      this.b.e.e = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_trae_mode.get();
      this.b.e.f = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_arm_flag.get();
      this.b.e.g = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_cpu_hertz.get();
      this.b.e.h = ((hd_video_putinfo.SharpTraeInfo)localObject2).uint32_audio_set.get();
    }
    if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint64_switch.has())
    {
      long l = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).uint64_switch.get();
      this.b.f.a = ((byte)(int)(l & 1L));
      this.b.f.b = ((byte)(int)(l >> 1 & 1L));
      this.b.f.c = ((byte)(int)(l >> 2 & 1L));
      this.b.f.d = ((byte)(int)(l >> 3 & 1L));
      this.b.f.e = ((byte)(int)(l >> 4 & 1L));
      this.b.f.f = ((byte)(int)(l >> 5 & 1L));
      this.b.f.g = ((byte)(int)(l >> 6 & 1L));
      this.b.f.h = ((byte)(int)(l >> 7 & 1L));
      this.b.f.i = ((byte)(int)(l >> 13 & 1L));
    }
    if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_qq_ptt_info_set.has())
    {
      this.b.g.a = true;
      localObject2 = (hd_video_putinfo.MobileQQPttInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_qq_ptt_info_set.get();
      this.b.g.b = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param1.get();
      this.b.g.c = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param2.get();
      this.b.g.d = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param3.get();
      this.b.g.e = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param4.get();
      this.b.g.f = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param5.get();
      this.b.g.g = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param6.get();
      this.b.g.h = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param7.get();
      this.b.g.i = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param8.get();
      this.b.g.j = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param9.get();
      this.b.g.k = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param10.get();
      this.b.g.l = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param11.get();
      this.b.g.m = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param12.get();
      this.b.g.n = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param13.get();
      this.b.g.o = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param14.get();
      this.b.g.p = ((hd_video_putinfo.MobileQQPttInfo)localObject2).uint32_param15.get();
    }
    if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_audio_quality_set.has())
    {
      localObject2 = (hd_video_putinfo.AudioSwitchPointInfo)((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).msg_audio_quality_set.get();
      this.b.h.a = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_shake.get();
      this.b.h.b = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_time_delay.get();
      this.b.h.c = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_pack_loss.get();
      this.b.h.d = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_wifi_pack_loss_rate.get();
      this.b.h.e = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).bytes_wifi_words.get().toStringUtf8();
      this.b.h.f = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_shake.get();
      this.b.h.g = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_time_delay.get();
      this.b.h.h = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_pack_loss.get();
      this.b.h.i = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).uint32_nowifi_pack_loss_rate.get();
      this.b.h.j = ((hd_video_putinfo.AudioSwitchPointInfo)localObject2).bytes_nowifi_words.get().toStringUtf8();
    }
    if (((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).rpt_msg_trans_buffer_list.has())
    {
      localObject1 = ((hd_video_putinfo.CmdToClientConfigInfoRspBody)localObject1).rpt_msg_trans_buffer_list.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = this.b;
          localObject2.getClass();
          localObject2 = new ConfigPBProtocol.ConfigSysInfoNew.TransBuffer((ConfigPBProtocol.ConfigSysInfoNew)localObject2);
          ((ConfigPBProtocol.ConfigSysInfoNew.TransBuffer)localObject2).a = ((hd_video_putinfo.TransBuffer)((List)localObject1).get(i)).uint32_type.get();
          ((ConfigPBProtocol.ConfigSysInfoNew.TransBuffer)localObject2).b = ((hd_video_putinfo.TransBuffer)((List)localObject1).get(i)).bytes_content.get().toStringUtf8();
          this.b.i.add(localObject2);
          if (((ConfigPBProtocol.ConfigSysInfoNew.TransBuffer)localObject2).a == 1) {
            this.b.b = ((ConfigPBProtocol.ConfigSysInfoNew.TransBuffer)localObject2).b;
          } else if (((ConfigPBProtocol.ConfigSysInfoNew.TransBuffer)localObject2).a == 2) {
            this.b.c = ((ConfigPBProtocol.ConfigSysInfoNew.TransBuffer)localObject2).b;
          }
          i += 1;
        }
      }
    }
    return 0;
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    try
    {
      this.c.mergeFrom(paramArrayOfByte);
      if (!this.c.msg_putinfo_head.has()) {
        return -1;
      }
      paramArrayOfByte = (hd_video_putinfo.PutinfoHead)this.c.msg_putinfo_head.get();
      if ((paramArrayOfByte != null) && (paramArrayOfByte.uint32_error_no.has()) && (paramArrayOfByte.uint32_error_no.get() == 0) && (paramArrayOfByte.enum_body_type.has()) && (paramArrayOfByte.enum_body_type.get() == 2))
      {
        if (paramArrayOfByte.bytes_config_ver.has()) {
          ConfigPBProtocol.a = paramArrayOfByte.bytes_config_ver.get().toStringUtf8();
        }
        int i = b();
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
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.ConfigPBProtocol.S2CConfigInfoPBProtocol
 * JD-Core Version:    0.7.0.1
 */