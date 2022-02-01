package com.tencent.av.config;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Random;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.CmdReportClientInfoReqBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.MobileHardWareValue;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.PutinfoHead;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.ReqBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo.VideoHardWareInfo;

public class ConfigPBProtocol$C2SConfigInfoPBProtocol
{
  private long b = 0L;
  private ConfigPBProtocol.TerminalInfo c = null;
  private hd_video_putinfo.ReqBody d = new hd_video_putinfo.ReqBody();
  
  public ConfigPBProtocol$C2SConfigInfoPBProtocol(ConfigPBProtocol paramConfigPBProtocol) {}
  
  private void b()
  {
    hd_video_putinfo.PutinfoHead localPutinfoHead = (hd_video_putinfo.PutinfoHead)this.d.msg_putinfo_head.get();
    localPutinfoHead.enum_body_type.set(1);
    localPutinfoHead.uint64_uin.set(this.b);
    localPutinfoHead.bytes_appid.set(ByteStringMicro.copyFrom(this.c.n.getBytes()));
    localPutinfoHead.uint64_seq.set(new Random().nextLong());
    localPutinfoHead.bytes_config_ver.set(ByteStringMicro.copyFrom(ConfigPBProtocol.a.getBytes()));
    this.d.msg_putinfo_head.set(localPutinfoHead);
  }
  
  private void c()
  {
    hd_video_putinfo.CmdReportClientInfoReqBody localCmdReportClientInfoReqBody = (hd_video_putinfo.CmdReportClientInfoReqBody)this.d.msg_report_client_info_req_body.get();
    localCmdReportClientInfoReqBody.uint32_mobile_type.set(this.c.a);
    localCmdReportClientInfoReqBody.uint32_mobile_os_info.set(this.c.b);
    localCmdReportClientInfoReqBody.uint32_instid.set(11001);
    localCmdReportClientInfoReqBody.bytes_client_system_info.set(ByteStringMicro.copyFrom(this.c.o.getBytes()));
    localCmdReportClientInfoReqBody.bytes_device_info.set(ByteStringMicro.copyFrom(this.c.p.getBytes()));
    Object localObject = (hd_video_putinfo.MobileHardWareValue)localCmdReportClientInfoReqBody.msg_device_info.get();
    ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_cpu_struct.set(this.c.c);
    ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_cpu_number.set(this.c.d);
    ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_cpu_hertz.set(this.c.e);
    ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_camera_turn.set(this.c.f);
    localCmdReportClientInfoReqBody.msg_device_info.set((MessageMicro)localObject);
    localObject = (hd_video_putinfo.VideoHardWareInfo)localCmdReportClientInfoReqBody.msg_video_info.get();
    ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_max_encodeframe.set(this.c.g);
    ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_max_decodeframe.set(this.c.h);
    ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_width.set(this.c.i);
    ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_height.set(this.c.j);
    localCmdReportClientInfoReqBody.msg_video_info.set((MessageMicro)localObject);
    localCmdReportClientInfoReqBody.bytes_mobile_rom_info.set(ByteStringMicro.copyFrom(this.c.q.getBytes()));
    localCmdReportClientInfoReqBody.uint32_sharp_sdk_ver.set(this.c.m);
    localCmdReportClientInfoReqBody.uint32_open_general_info.set(this.c.l);
    localCmdReportClientInfoReqBody.bytes_app_version.set(ByteStringMicro.copyFrom(this.c.r.getBytes()));
    this.d.msg_report_client_info_req_body.set(localCmdReportClientInfoReqBody);
  }
  
  public void a(long paramLong, ConfigPBProtocol.TerminalInfo paramTerminalInfo)
  {
    this.b = paramLong;
    this.c = paramTerminalInfo;
  }
  
  public byte[] a()
  {
    b();
    c();
    return this.d.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.ConfigPBProtocol.C2SConfigInfoPBProtocol
 * JD-Core Version:    0.7.0.1
 */