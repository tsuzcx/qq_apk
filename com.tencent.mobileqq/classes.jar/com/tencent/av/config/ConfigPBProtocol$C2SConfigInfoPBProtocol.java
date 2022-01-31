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
  private long jdField_a_of_type_Long;
  private ConfigPBProtocol.TerminalInfo jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo;
  private hd_video_putinfo.ReqBody jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$ReqBody = new hd_video_putinfo.ReqBody();
  
  public ConfigPBProtocol$C2SConfigInfoPBProtocol(ConfigPBProtocol paramConfigPBProtocol) {}
  
  private void a()
  {
    hd_video_putinfo.PutinfoHead localPutinfoHead = (hd_video_putinfo.PutinfoHead)this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$ReqBody.msg_putinfo_head.get();
    localPutinfoHead.enum_body_type.set(1);
    localPutinfoHead.uint64_uin.set(this.jdField_a_of_type_Long);
    localPutinfoHead.bytes_appid.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.jdField_a_of_type_JavaLangString.getBytes()));
    localPutinfoHead.uint64_seq.set(new Random().nextLong());
    localPutinfoHead.bytes_config_ver.set(ByteStringMicro.copyFrom(ConfigPBProtocol.jdField_a_of_type_JavaLangString.getBytes()));
    this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$ReqBody.msg_putinfo_head.set(localPutinfoHead);
  }
  
  private void b()
  {
    hd_video_putinfo.CmdReportClientInfoReqBody localCmdReportClientInfoReqBody = (hd_video_putinfo.CmdReportClientInfoReqBody)this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$ReqBody.msg_report_client_info_req_body.get();
    localCmdReportClientInfoReqBody.uint32_mobile_type.set(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.jdField_a_of_type_Int);
    localCmdReportClientInfoReqBody.uint32_mobile_os_info.set(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.jdField_b_of_type_Int);
    localCmdReportClientInfoReqBody.uint32_instid.set(11001);
    localCmdReportClientInfoReqBody.bytes_client_system_info.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.jdField_b_of_type_JavaLangString.getBytes()));
    localCmdReportClientInfoReqBody.bytes_device_info.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.jdField_c_of_type_JavaLangString.getBytes()));
    Object localObject = (hd_video_putinfo.MobileHardWareValue)localCmdReportClientInfoReqBody.msg_device_info.get();
    ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_cpu_struct.set(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.jdField_c_of_type_Int);
    ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_cpu_number.set(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.jdField_d_of_type_Int);
    ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_cpu_hertz.set(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.jdField_e_of_type_Int);
    ((hd_video_putinfo.MobileHardWareValue)localObject).uint32_mobile_camera_turn.set(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.f);
    localCmdReportClientInfoReqBody.msg_device_info.set((MessageMicro)localObject);
    localObject = (hd_video_putinfo.VideoHardWareInfo)localCmdReportClientInfoReqBody.msg_video_info.get();
    ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_max_encodeframe.set(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.g);
    ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_max_decodeframe.set(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.h);
    ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_width.set(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.i);
    ((hd_video_putinfo.VideoHardWareInfo)localObject).uint32_mobile_height.set(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.j);
    localCmdReportClientInfoReqBody.msg_video_info.set((MessageMicro)localObject);
    localCmdReportClientInfoReqBody.bytes_mobile_rom_info.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.jdField_d_of_type_JavaLangString.getBytes()));
    localCmdReportClientInfoReqBody.uint32_sharp_sdk_ver.set(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.m);
    localCmdReportClientInfoReqBody.uint32_open_general_info.set(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.l);
    localCmdReportClientInfoReqBody.bytes_app_version.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo.jdField_e_of_type_JavaLangString.getBytes()));
    this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$ReqBody.msg_report_client_info_req_body.set(localCmdReportClientInfoReqBody);
  }
  
  public void a(long paramLong, ConfigPBProtocol.TerminalInfo paramTerminalInfo)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$TerminalInfo = paramTerminalInfo;
  }
  
  public byte[] a()
  {
    a();
    b();
    return this.jdField_a_of_type_TencentImCsLongconnPutinfoHd_video_putinfo$ReqBody.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.config.ConfigPBProtocol.C2SConfigInfoPBProtocol
 * JD-Core Version:    0.7.0.1
 */