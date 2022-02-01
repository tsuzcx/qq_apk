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
  public long a = 0L;
  public String b = null;
  public ByteStringMicro c = null;
  public String d = null;
  public int e = 0;
  public String f;
  public String g = null;
  public String h = null;
  public String i = null;
  public List<String> j = null;
  public String k = null;
  public String l = null;
  public String m = null;
  public String n = null;
  public short o = 0;
  public List<String> p = null;
  
  public void a(MsgSCBody paramMsgSCBody)
  {
    this.a = paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.int32_ret_code;
    this.b = paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.str_ret_msg;
    this.c = ByteStringMicro.copyFrom(paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.bytes_download_key);
    this.d = paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_ip;
    this.f = paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_domain;
    this.e = paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.uint32_port;
    this.g = paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_url;
    this.j = Arrays.asList(paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.rpt_str_downloadip_list);
    this.h = paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_cookie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.compatible.DatalineDownloadRespInfo
 * JD-Core Version:    0.7.0.1
 */