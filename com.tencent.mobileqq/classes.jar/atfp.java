import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.FileInfo;

public class atfp
{
  public long a;
  public ByteStringMicro a;
  public String a;
  public List<String> a;
  public short a;
  public String b;
  public List<String> b;
  public short b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public static void a(atfp paramatfp, cmd0x346.ApplyDownloadRsp paramApplyDownloadRsp, boolean paramBoolean, String paramString)
  {
    if (paramatfp == null) {
      break label4;
    }
    label4:
    while (paramApplyDownloadRsp == null) {
      return;
    }
    if (paramApplyDownloadRsp.int32_ret_code.has()) {
      paramatfp.jdField_a_of_type_Long = paramApplyDownloadRsp.int32_ret_code.get();
    }
    if (paramApplyDownloadRsp.str_ret_msg.has()) {
      paramatfp.jdField_a_of_type_JavaLangString = paramApplyDownloadRsp.str_ret_msg.get();
    }
    cmd0x346.DownloadInfo localDownloadInfo;
    if (paramApplyDownloadRsp.msg_download_info.has())
    {
      localDownloadInfo = (cmd0x346.DownloadInfo)paramApplyDownloadRsp.msg_download_info.get();
      if (localDownloadInfo.bytes_download_key.has()) {
        paramatfp.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = localDownloadInfo.bytes_download_key.get();
      }
      if (!localDownloadInfo.str_download_ip.has()) {
        break label534;
      }
      paramatfp.jdField_b_of_type_JavaLangString = localDownloadInfo.str_download_ip.get();
      label120:
      if (localDownloadInfo.uint32_port.has()) {
        paramatfp.jdField_a_of_type_Short = ((short)localDownloadInfo.uint32_port.get());
      }
      if (!paramBoolean) {
        break label571;
      }
      if (localDownloadInfo.bytes_media_platform_download_key.has())
      {
        paramatfp.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = localDownloadInfo.bytes_media_platform_download_key.get();
        paramatfp.c = String.format("/asn.com/qqdownloadftnv5?ver=0&filetype=4001&openid=%s&rkey=%s", new Object[] { paramString, HexUtil.bytes2HexStr(paramatfp.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro.toByteArray()) });
      }
    }
    for (;;)
    {
      if (localDownloadInfo.str_cookie.has()) {
        paramatfp.d = ("FTN5K=" + localDownloadInfo.str_cookie.get());
      }
      if ((localDownloadInfo.rpt_str_downloadip_list.has()) && (localDownloadInfo.rpt_str_downloadip_list.get().size() > 0)) {
        paramatfp.jdField_a_of_type_JavaUtilList = localDownloadInfo.rpt_str_downloadip_list.get();
      }
      if (localDownloadInfo.str_https_download_domain.has()) {
        paramatfp.h = localDownloadInfo.str_https_download_domain.get();
      }
      if (localDownloadInfo.uint32_https_port.has()) {
        paramatfp.jdField_b_of_type_Short = ((short)localDownloadInfo.uint32_https_port.get());
      }
      if (localDownloadInfo.str_download_dns.has()) {
        paramatfp.i = localDownloadInfo.str_download_dns.get();
      }
      if ((localDownloadInfo.str_downloadipv6_list.has()) && (localDownloadInfo.str_downloadipv6_list.get().size() > 0)) {
        paramatfp.jdField_b_of_type_JavaUtilList = localDownloadInfo.str_downloadipv6_list.get();
      }
      if (!paramApplyDownloadRsp.msg_file_info.has()) {
        break;
      }
      paramApplyDownloadRsp = (cmd0x346.FileInfo)paramApplyDownloadRsp.msg_file_info.get();
      if (paramApplyDownloadRsp.str_file_name.has())
      {
        paramatfp.e = paramApplyDownloadRsp.str_file_name.get();
        paramatfp.e = auea.a(paramatfp.e);
      }
      paramatfp.f = atrr.a(paramApplyDownloadRsp.bytes_10m_md5.get().toByteArray());
      QLog.i("DownloadRespInfo", 1, "file md5:" + paramatfp.f);
      paramatfp.g = atrr.a(paramApplyDownloadRsp.bytes_sha.get().toByteArray());
      QLog.i("DownloadRespInfo", 1, "file sha:" + paramatfp.g);
      return;
      label534:
      if (localDownloadInfo.str_download_domain.has())
      {
        paramatfp.jdField_b_of_type_JavaLangString = localDownloadInfo.str_download_domain.get();
        break label120;
      }
      QLog.i("DownloadRespInfo", 1, "handleDownloadResp: has neither ip nor domain");
      break label120;
      label571:
      if (localDownloadInfo.str_download_url.has()) {
        paramatfp.c = localDownloadInfo.str_download_url.get();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfp
 * JD-Core Version:    0.7.0.1
 */