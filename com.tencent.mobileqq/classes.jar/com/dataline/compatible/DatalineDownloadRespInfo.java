package com.dataline.compatible;

import com.tencent.litetransfersdk.ApplyDownloadRsp;
import com.tencent.litetransfersdk.DownloadInfo;
import com.tencent.litetransfersdk.MsgSCBody;
import com.tencent.litetransfersdk.MsgSCBody0x346;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.Arrays;
import java.util.List;

public class DatalineDownloadRespInfo
{
  public int a;
  public long a;
  public ByteStringMicro a;
  public String a;
  public List<String> a;
  public short a;
  public String b;
  public List<String> b;
  public String c;
  public String d = null;
  public String e = null;
  public String f = null;
  public String g = null;
  public String h = null;
  public String i = null;
  public String j = null;
  
  public DatalineDownloadRespInfo()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Short = 0;
    this.jdField_b_of_type_JavaUtilList = null;
  }
  
  public void a(MsgSCBody paramMsgSCBody)
  {
    this.jdField_a_of_type_Long = paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.int32_ret_code;
    this.jdField_a_of_type_JavaLangString = paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.str_ret_msg;
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = ByteStringMicro.copyFrom(paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.bytes_download_key);
    this.jdField_b_of_type_JavaLangString = paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_ip;
    this.c = paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_domain;
    this.jdField_a_of_type_Int = paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.uint32_port;
    this.d = paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_url;
    this.jdField_a_of_type_JavaUtilList = Arrays.asList(paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.rpt_str_downloadip_list);
    this.e = paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_cookie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.compatible.DatalineDownloadRespInfo
 * JD-Core Version:    0.7.0.1
 */