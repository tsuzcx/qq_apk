package com.tencent.litetransfersdk;

import ajuo;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import aptv;
import apue;
import apvk;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346.DeleteFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.DeleteFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.FileInfo;
import tencent.im.cs.cmd0x346.cmd0x346.FileQueryReq;
import tencent.im.cs.cmd0x346.cmd0x346.FileQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccRsp;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.ActionInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FTNNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FileControl;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MpFileNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.NFCNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.RNFCNotify;
import yak;

public class ProtocolHelper
{
  static final int DEVICETYPE_IPAD = 3;
  static final int DEVICETYPE_NONE = 0;
  static final int DEVICETYPE_PC = 1;
  static final int DEVICETYPE_PHONE = 2;
  static final int DEVICETYPE_UNK4 = 4;
  static final int DEVICETYPE_UNK5 = 5;
  public static final int TYPE_TINYID = 1;
  public static final int TYPE_UIN = 0;
  public static int mDstAppId = 1;
  public static int mDstInstId = 1;
  public static int mDstType = 1;
  public static final String sTagName = "dataline.ProtocolHelper";
  protected AppInterface mApp;
  protected int mUinType = 0;
  
  public ProtocolHelper(AppInterface paramAppInterface, int paramInt)
  {
    this.mApp = paramAppInterface;
    this.mUinType = paramInt;
  }
  
  public static String FixImageFileExtName(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    String str = paramString1;
    if (paramInt == 1)
    {
      str = paramString1;
      if (apue.a(paramString1) != 0)
      {
        str = paramString1;
        if (!paramBoolean) {
          if (!GifDrawable.isGifFile(new File(paramString2))) {
            break label65;
          }
        }
      }
    }
    label65:
    for (paramString2 = ".gif";; paramString2 = ".jpg")
    {
      str = paramString1 + paramString2;
      return str;
    }
  }
  
  public static void GetTypeInfo(int paramInt)
  {
    if (paramInt == 1)
    {
      mDstAppId = 1001;
      mDstType = 3;
      mDstInstId = 0;
      return;
    }
    mDstAppId = 1;
    mDstType = 1;
    mDstInstId = 1;
  }
  
  private FileInfo createFileInfo(cmd0x346.FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return null;
    }
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.uint64_uin = paramFileInfo.uint64_uin.get();
    localFileInfo.uint32_danger_evel = paramFileInfo.uint32_danger_evel.get();
    localFileInfo.uint64_file_size = paramFileInfo.uint64_file_size.get();
    localFileInfo.uint32_life_time = paramFileInfo.uint32_life_time.get();
    localFileInfo.uint32_upload_time = paramFileInfo.uint32_upload_time.get();
    localFileInfo.bytes_uuid = paramFileInfo.bytes_uuid.get().toByteArray();
    localFileInfo.str_file_name = paramFileInfo.str_file_name.get();
    localFileInfo.uint32_abs_file_type = paramFileInfo.uint32_abs_file_type.get();
    localFileInfo.bytes_10m_md5 = paramFileInfo.bytes_10m_md5.get().toByteArray();
    localFileInfo.uint32_client_type = paramFileInfo.uint32_client_type.get();
    localFileInfo.uint64_owner_uin = paramFileInfo.uint64_owner_uin.get();
    localFileInfo.uint64_peer_uin = paramFileInfo.uint64_peer_uin.get();
    localFileInfo.uint32_expire_time = paramFileInfo.uint32_expire_time.get();
    return localFileInfo;
  }
  
  public static void fillMsgHeader(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, long paramLong1, long paramLong2)
  {
    fillMsgHeader(paramMsgHeader, paramLong1, paramLong2, 0);
  }
  
  public static void fillMsgHeader(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, long paramLong1, long paramLong2, int paramInt)
  {
    int i = AppSetting.a();
    paramMsgHeader.uint32_src_app_id.set(1001);
    paramMsgHeader.uint32_src_inst_id.set(i);
    paramMsgHeader.uint64_dst_uin.set(paramLong1);
    paramMsgHeader.uint64_src_uin.set(paramLong2);
    GetTypeInfo(paramInt);
    paramMsgHeader.uint32_dst_ter_type.set(mDstType);
    paramMsgHeader.uint32_dst_app_id.set(mDstAppId);
    paramMsgHeader.uint32_dst_inst_id.set(mDstInstId);
    paramMsgHeader.uint32_src_ter_type.set(2);
    paramMsgHeader.setHasFlag(true);
  }
  
  public boolean CheckActionInfo(SubMsgType0x7.MsgBody.FTNNotify paramFTNNotify, String paramString)
  {
    if (paramFTNNotify.msg_ActionInfo.has()) {
      return isMyNotify((SubMsgType0x7.MsgBody.ActionInfo)paramFTNNotify.msg_ActionInfo.get(), paramString);
    }
    return false;
  }
  
  public boolean CheckActionInfo(SubMsgType0x7.MsgBody.NFCNotify paramNFCNotify, String paramString)
  {
    if (paramNFCNotify.msg_ActionInfo.has()) {
      return isMyNotify((SubMsgType0x7.MsgBody.ActionInfo)paramNFCNotify.msg_ActionInfo.get(), paramString);
    }
    return false;
  }
  
  public void FillMsgSCBody(MsgSCBody paramMsgSCBody, cmd0x346.RspBody paramRspBody, int paramInt)
  {
    paramMsgSCBody.msgBody0x346 = new MsgSCBody0x346();
    paramMsgSCBody.msgBody0x346.uMsgSubType = paramInt;
    List localList;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("dataline.ProtocolHelper", 2, "PBToMsgSCBody : msgtype is not cmd0x346");
      }
    case 1610: 
    case 1710: 
      do
      {
        do
        {
          return;
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp = new ApplyUploadRsp();
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.int32_ret_code = paramRspBody.msg_apply_upload_rsp_v2.int32_ret_code.get();
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_ret_msg = paramRspBody.msg_apply_upload_rsp_v2.str_ret_msg.get();
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_total_space = paramRspBody.msg_apply_upload_rsp_v2.uint64_total_space.get();
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_used_space = paramRspBody.msg_apply_upload_rsp_v2.uint64_used_space.get();
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_uploaded_size = paramRspBody.msg_apply_upload_rsp_v2.uint64_uploaded_size.get();
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_ip = paramRspBody.msg_apply_upload_rsp_v2.str_upload_ip.get();
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_domain = paramRspBody.msg_apply_upload_rsp_v2.str_upload_domain.get();
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_upload_port = paramRspBody.msg_apply_upload_rsp_v2.uint32_upload_port.get();
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_uuid = paramRspBody.msg_apply_upload_rsp_v2.bytes_uuid.get().toStringUtf8();
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_upload_key = paramRspBody.msg_apply_upload_rsp_v2.bytes_upload_key.get().toByteArray();
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bool_file_exist = paramRspBody.msg_apply_upload_rsp_v2.bool_file_exist.get();
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_pack_size = paramRspBody.msg_apply_upload_rsp_v2.uint32_pack_size.get();
          localList = paramRspBody.msg_apply_upload_rsp_v2.rpt_str_uploadip_list.get();
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.rpt_str_uploadip_list = ((String[])localList.toArray(new String[localList.size()]));
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_httpsvr_api_ver = paramRspBody.msg_apply_upload_rsp_v2.uint32_httpsvr_api_ver.get();
          paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_sha = paramRspBody.msg_apply_upload_rsp_v2.bytes_sha.get().toByteArray();
        } while ((this.mApp == null) || (!(this.mApp instanceof QQAppInterface)) || (!apvk.b((QQAppInterface)this.mApp)));
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_dns = paramRspBody.msg_apply_upload_rsp_v2.str_upload_dns.get();
        return;
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp = new ApplyUploadRsp();
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.int32_ret_code = paramRspBody.msg_apply_upload_rsp_v3.int32_ret_code.get();
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_ret_msg = paramRspBody.msg_apply_upload_rsp_v3.str_ret_msg.get();
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_total_space = paramRspBody.msg_apply_upload_rsp_v3.uint64_total_space.get();
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_used_space = paramRspBody.msg_apply_upload_rsp_v3.uint64_used_space.get();
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint64_uploaded_size = paramRspBody.msg_apply_upload_rsp_v3.uint64_uploaded_size.get();
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_ip = paramRspBody.msg_apply_upload_rsp_v3.str_upload_ip.get();
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_domain = paramRspBody.msg_apply_upload_rsp_v3.str_upload_domain.get();
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_upload_port = paramRspBody.msg_apply_upload_rsp_v3.uint32_upload_port.get();
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_uuid = paramRspBody.msg_apply_upload_rsp_v3.bytes_uuid.get().toStringUtf8();
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bytes_upload_key = paramRspBody.msg_apply_upload_rsp_v3.bytes_upload_key.get().toByteArray();
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.bool_file_exist = paramRspBody.msg_apply_upload_rsp_v3.bool_file_exist.get();
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.uint32_pack_size = paramRspBody.msg_apply_upload_rsp_v3.uint32_pack_size.get();
        localList = paramRspBody.msg_apply_upload_rsp_v3.rpt_str_uploadip_list.get();
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.rpt_str_uploadip_list = ((String[])localList.toArray(new String[localList.size()]));
      } while ((this.mApp == null) || (!(this.mApp instanceof QQAppInterface)) || (!apvk.b((QQAppInterface)this.mApp)));
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_uploadRsp.str_upload_dns = paramRspBody.msg_apply_upload_rsp_v3.str_upload_dns.get();
      return;
    case 1810: 
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810 = new ApplyUploadHitRsp();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.int32_ret_code = paramRspBody.msg_apply_upload_hit_rsp_v2.int32_ret_code.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.str_ret_msg = paramRspBody.msg_apply_upload_hit_rsp_v2.str_ret_msg.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.str_upload_ip = paramRspBody.msg_apply_upload_hit_rsp_v2.str_upload_ip.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.str_upload_domain = paramRspBody.msg_apply_upload_hit_rsp_v2.str_upload_domain.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.bytes_uuid = paramRspBody.msg_apply_upload_hit_rsp_v2.bytes_uuid.get().toByteArray();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.bytes_upload_key = paramRspBody.msg_apply_upload_hit_rsp_v2.bytes_upload_key.get().toByteArray();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.uint64_total_space = paramRspBody.msg_apply_upload_hit_rsp_v2.uint64_total_space.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1810.uint64_used_space = paramRspBody.msg_apply_upload_hit_rsp_v2.uint64_used_space.get();
      return;
    case 1210: 
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210 = new ApplyDownloadRsp();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.int32_ret_code = paramRspBody.msg_apply_download_rsp.int32_ret_code.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.str_ret_msg = paramRspBody.msg_apply_download_rsp.str_ret_msg.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info = new DownloadInfo();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.bytes_download_key = paramRspBody.msg_apply_download_rsp.msg_download_info.bytes_download_key.get().toByteArray();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_ip = paramRspBody.msg_apply_download_rsp.msg_download_info.str_download_ip.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_domain = paramRspBody.msg_apply_download_rsp.msg_download_info.str_download_domain.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.uint32_port = paramRspBody.msg_apply_download_rsp.msg_download_info.uint32_port.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_url = paramRspBody.msg_apply_download_rsp.msg_download_info.str_download_url.get();
      localList = paramRspBody.msg_apply_download_rsp.msg_download_info.rpt_str_downloadip_list.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.rpt_str_downloadip_list = ((String[])localList.toArray(new String[localList.size()]));
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_cookie = paramRspBody.msg_apply_download_rsp.msg_download_info.str_cookie.get();
      if ((this.mApp != null) && ((this.mApp instanceof QQAppInterface)) && (apvk.b((QQAppInterface)this.mApp))) {
        paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_download_info.str_download_dns = paramRspBody.msg_apply_download_rsp.msg_download_info.str_download_dns.get();
      }
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_1210.msg_file_info = createFileInfo(paramRspBody.msg_apply_download_rsp.msg_file_info);
      return;
    case 810: 
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_810 = new UploadSuccRsp();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_810.int32_ret_code = paramRspBody.msg_upload_succ_rsp.int32_ret_code.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_810.str_ret_msg = paramRspBody.msg_upload_succ_rsp.str_ret_msg.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_810.msg_file_info = createFileInfo(paramRspBody.msg_upload_succ_rsp.msg_file_info);
      return;
    case 910: 
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_910 = new DeleteFileRsp();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_910.int32_ret_code = paramRspBody.msg_delete_file_rsp.int32_ret_code.get();
      paramMsgSCBody.msgBody0x346.pMsgBody0x346_910.str_ret_msg = paramRspBody.msg_delete_file_rsp.str_ret_msg.get();
      return;
    case 1410: 
      paramMsgSCBody.msgBody0x346.fileQueryRsp = new FileQueryRsp();
      paramMsgSCBody.msgBody0x346.fileQueryRsp.int32_ret_code = paramRspBody.msg_file_query_rsp.int32_ret_code.get();
      paramMsgSCBody.msgBody0x346.fileQueryRsp.str_ret_msg = paramRspBody.msg_file_query_rsp.str_ret_msg.get();
      paramMsgSCBody.msgBody0x346.fileQueryRsp.msg_file_info = createFileInfo(paramRspBody.msg_file_query_rsp.msg_file_info);
      return;
    }
    paramMsgSCBody.msgBody0x346.applyCopyToRsp = new ApplyCopyToRsp();
    paramMsgSCBody.msgBody0x346.applyCopyToRsp.int32_ret_code = paramRspBody.msg_apply_copy_to_rsp.int32_ret_code.get();
    paramMsgSCBody.msgBody0x346.applyCopyToRsp.str_ret_msg = paramRspBody.msg_apply_copy_to_rsp.str_ret_msg.get();
    paramMsgSCBody.msgBody0x346.applyCopyToRsp.str_file_key = paramRspBody.msg_apply_copy_to_rsp.str_file_key.get();
  }
  
  public boolean FillReqBody(MsgCSBody0x346 paramMsgCSBody0x346, cmd0x346.ReqBody paramReqBody)
  {
    Object localObject;
    switch (paramMsgCSBody0x346.uMsgSubType)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("dataline.ProtocolHelper", 2, "send0x346Req, unknwon nCmdType:" + paramMsgCSBody0x346.uMsgSubType);
      }
    case 1600: 
      do
      {
        return false;
        localObject = new cmd0x346.ApplyUploadReqV2();
        paramMsgCSBody0x346 = paramMsgCSBody0x346.pMsgBody0x346_uploadReq;
      } while (paramMsgCSBody0x346 == null);
      ((cmd0x346.ApplyUploadReqV2)localObject).uint64_sender_uin.set(paramMsgCSBody0x346.uint64_sender_uin);
      ((cmd0x346.ApplyUploadReqV2)localObject).uint64_recver_uin.set(paramMsgCSBody0x346.uint64_recver_uin);
      ((cmd0x346.ApplyUploadReqV2)localObject).uint64_file_size.set(paramMsgCSBody0x346.uint64_file_size);
      ((cmd0x346.ApplyUploadReqV2)localObject).str_file_name.set(paramMsgCSBody0x346.str_file_name);
      ((cmd0x346.ApplyUploadReqV2)localObject).bytes_10m_md5.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_10m_md5));
      ((cmd0x346.ApplyUploadReqV2)localObject).bytes_3sha.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_sha));
      ((cmd0x346.ApplyUploadReqV2)localObject).str_local_filepath.set(paramMsgCSBody0x346.str_local_filepath);
      ((cmd0x346.ApplyUploadReqV2)localObject).uint32_danger_level.set(paramMsgCSBody0x346.uint32_danger_level);
      ((cmd0x346.ApplyUploadReqV2)localObject).uint64_total_space.set(paramMsgCSBody0x346.uint64_total_space);
      paramReqBody.msg_apply_upload_req_v2.set((MessageMicro)localObject);
    }
    for (;;)
    {
      return true;
      localObject = new cmd0x346.ApplyUploadReqV3();
      paramMsgCSBody0x346 = paramMsgCSBody0x346.pMsgBody0x346_uploadReq;
      if (paramMsgCSBody0x346 == null) {
        break;
      }
      ((cmd0x346.ApplyUploadReqV3)localObject).uint64_sender_uin.set(paramMsgCSBody0x346.uint64_sender_uin);
      ((cmd0x346.ApplyUploadReqV3)localObject).uint64_recver_uin.set(paramMsgCSBody0x346.uint64_recver_uin);
      ((cmd0x346.ApplyUploadReqV3)localObject).uint64_file_size.set(paramMsgCSBody0x346.uint64_file_size);
      ((cmd0x346.ApplyUploadReqV3)localObject).str_file_name.set(paramMsgCSBody0x346.str_file_name);
      ((cmd0x346.ApplyUploadReqV3)localObject).bytes_10m_md5.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_10m_md5));
      ((cmd0x346.ApplyUploadReqV3)localObject).bytes_sha.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_sha));
      ((cmd0x346.ApplyUploadReqV3)localObject).str_local_filepath.set(paramMsgCSBody0x346.str_local_filepath);
      ((cmd0x346.ApplyUploadReqV3)localObject).uint32_danger_level.set(paramMsgCSBody0x346.uint32_danger_level);
      ((cmd0x346.ApplyUploadReqV3)localObject).uint64_total_space.set(paramMsgCSBody0x346.uint64_total_space);
      paramReqBody.msg_apply_upload_req_v3.set((MessageMicro)localObject);
      continue;
      localObject = new cmd0x346.ApplyUploadHitReqV2();
      paramMsgCSBody0x346 = paramMsgCSBody0x346.pMsgBody0x346_1800;
      if (paramMsgCSBody0x346 == null) {
        break;
      }
      ((cmd0x346.ApplyUploadHitReqV2)localObject).uint64_sender_uin.set(paramMsgCSBody0x346.uint64_sender_uin);
      ((cmd0x346.ApplyUploadHitReqV2)localObject).uint64_recver_uin.set(paramMsgCSBody0x346.uint64_recver_uin);
      ((cmd0x346.ApplyUploadHitReqV2)localObject).uint64_file_size.set(paramMsgCSBody0x346.uint64_file_size);
      ((cmd0x346.ApplyUploadHitReqV2)localObject).str_file_name.set(paramMsgCSBody0x346.str_file_name);
      ((cmd0x346.ApplyUploadHitReqV2)localObject).bytes_10m_md5.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_10m_md5));
      ((cmd0x346.ApplyUploadHitReqV2)localObject).bytes_3sha.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_3sha));
      ((cmd0x346.ApplyUploadHitReqV2)localObject).bytes_sha.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_sha));
      ((cmd0x346.ApplyUploadHitReqV2)localObject).str_local_filepath.set(paramMsgCSBody0x346.str_local_filepath);
      ((cmd0x346.ApplyUploadHitReqV2)localObject).uint32_danger_level.set(paramMsgCSBody0x346.uint32_danger_level);
      ((cmd0x346.ApplyUploadHitReqV2)localObject).uint64_total_space.set(paramMsgCSBody0x346.uint64_total_space);
      paramReqBody.msg_apply_upload_hit_req_v2.set((MessageMicro)localObject);
      continue;
      localObject = new cmd0x346.ApplyDownloadReq();
      paramMsgCSBody0x346 = paramMsgCSBody0x346.pMsgBody0x346_1200;
      if (paramMsgCSBody0x346 == null) {
        break;
      }
      ((cmd0x346.ApplyDownloadReq)localObject).uint64_uin.set(paramMsgCSBody0x346.uint64_uin);
      ((cmd0x346.ApplyDownloadReq)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.bytes_uuid));
      if (paramMsgCSBody0x346.uint32_ext_uintype != 0) {
        ((cmd0x346.ApplyDownloadReq)localObject).uint32_ext_uintype.set(paramMsgCSBody0x346.uint32_ext_uintype);
      }
      if (paramMsgCSBody0x346.uint32_ext_uintype == 1) {
        ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type.set(1);
      }
      for (;;)
      {
        paramReqBody.msg_apply_download_req.set((MessageMicro)localObject);
        break;
        ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type.set(2);
      }
      paramReqBody.msg_upload_succ_req.setHasFlag(true);
      paramReqBody.msg_upload_succ_req.uint64_sender_uin.set(paramMsgCSBody0x346.pMsgBody0x346_800.uint64_sender_uin);
      paramReqBody.msg_upload_succ_req.uint64_recver_uin.set(paramMsgCSBody0x346.pMsgBody0x346_800.uint64_recver_uin);
      if (paramMsgCSBody0x346.pMsgBody0x346_800.bytes_uuid != null)
      {
        paramReqBody.msg_upload_succ_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.pMsgBody0x346_800.bytes_uuid.getBytes()));
        continue;
        paramReqBody.msg_delete_file_req.setHasFlag(true);
        paramReqBody.msg_delete_file_req.uint64_uin.set(paramMsgCSBody0x346.pMsgBody0x346_900.uint64_uin);
        paramReqBody.msg_delete_file_req.uint64_peer_uin.set(paramMsgCSBody0x346.pMsgBody0x346_900.uint64_peer_uin);
        paramReqBody.msg_delete_file_req.uint32_delete_type.set(paramMsgCSBody0x346.pMsgBody0x346_900.uint32_delete_type);
        if (paramMsgCSBody0x346.pMsgBody0x346_900.bytes_uuid != null)
        {
          paramReqBody.msg_delete_file_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.pMsgBody0x346_900.bytes_uuid.getBytes()));
          continue;
          paramReqBody.msg_file_query_req.setHasFlag(true);
          paramReqBody.msg_file_query_req.uint64_uin.set(paramMsgCSBody0x346.fileQueryReq.uint64_uin);
          if (paramMsgCSBody0x346.fileQueryReq.bytes_uuid != null)
          {
            paramReqBody.msg_file_query_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.fileQueryReq.bytes_uuid));
            continue;
            paramReqBody.msg_apply_copy_to_req.setHasFlag(true);
            paramReqBody.msg_apply_copy_to_req.uint64_dst_id.set(paramMsgCSBody0x346.applyCopyToReq.uint64_dst_id);
            paramReqBody.msg_apply_copy_to_req.uint64_dst_uin.set(paramMsgCSBody0x346.applyCopyToReq.uint64_dst_uin);
            paramReqBody.msg_apply_copy_to_req.uint32_dst_svcid.set(paramMsgCSBody0x346.applyCopyToReq.uint32_dst_svcid);
            paramReqBody.msg_apply_copy_to_req.uint64_src_uin.set(paramMsgCSBody0x346.applyCopyToReq.uint64_src_uin);
            paramReqBody.msg_apply_copy_to_req.uint64_file_size.set(paramMsgCSBody0x346.applyCopyToReq.uint64_file_size);
            paramReqBody.msg_apply_copy_to_req.str_file_name.set(paramMsgCSBody0x346.applyCopyToReq.str_file_name);
            paramReqBody.msg_apply_copy_to_req.str_local_filepath.set(paramMsgCSBody0x346.applyCopyToReq.str_local_filepath);
            paramReqBody.msg_apply_copy_to_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramMsgCSBody0x346.applyCopyToReq.bytes_uuid));
          }
        }
      }
    }
  }
  
  public long GenSessionIdFromDev(long paramLong, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return paramLong;
    }
    return paramLong | 0x0;
  }
  
  public long GetSelfUin()
  {
    if (this.mUinType == 0) {
      return Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
    }
    if (this.mUinType == 1) {
      return ((yak)((QQAppInterface)this.mApp).a(51)).a();
    }
    return 0L;
  }
  
  public SubMsgType0x7.MsgBody MsgBodyFromFTNNotify(FTNNotify paramFTNNotify, long paramLong, String paramString, int paramInt)
  {
    Object localObject = FixImageFileExtName(paramFTNNotify.str_file_name, paramFTNNotify.str_file_name, paramFTNNotify.uint32_originfiletype, false);
    paramString = new SubMsgType0x7.MsgBody();
    paramString.uint32_sub_cmd.set(paramInt);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramFTNNotify.uint64_sessionid);
    fillMsgHeader(paramString.msg_header, paramLong, i);
    SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = new SubMsgType0x7.MsgBody.FTNNotify();
    localFTNNotify.uint64_sessionid.set(paramFTNNotify.uint64_sessionid);
    localFTNNotify.str_file_name.set((String)localObject);
    localFTNNotify.str_file_index.set(paramFTNNotify.str_file_index);
    if (paramFTNNotify.bytes_file_md5 != null) {
      localFTNNotify.bytes_file_md5.set(ByteStringMicro.copyFrom(paramFTNNotify.bytes_file_md5));
    }
    localFTNNotify.uint64_file_len.set(paramFTNNotify.uint64_file_len);
    if (paramFTNNotify.bytes_originfile_md5 != null) {
      localFTNNotify.bytes_originfile_md5.set(ByteStringMicro.copyFrom(paramFTNNotify.bytes_originfile_md5));
    }
    localFTNNotify.uint32_originfiletype.set(paramFTNNotify.uint32_originfiletype);
    localFTNNotify.uint32_batchID.set(paramFTNNotify.uint32_batchID);
    if (paramFTNNotify.uint32_group_size > 1)
    {
      localFTNNotify.uint32_group_id.set(paramFTNNotify.uint32_group_id);
      localFTNNotify.uint32_group_size.set(paramFTNNotify.uint32_group_size);
      localFTNNotify.uint32_group_curindex.set(paramFTNNotify.uint32_group_curindex);
      localFTNNotify.uint32_groupflag.set(paramFTNNotify.uint32_groupflag);
    }
    localObject = new SubMsgType0x7.MsgBody.ActionInfo();
    ((SubMsgType0x7.MsgBody.ActionInfo)localObject).str_service_name.set(paramFTNNotify.msg_ActionInfo.strServiceName);
    if (paramFTNNotify.msg_ActionInfo.vServiceInfo != null) {
      ((SubMsgType0x7.MsgBody.ActionInfo)localObject).bytes_buf.set(ByteStringMicro.copyFrom(paramFTNNotify.msg_ActionInfo.vServiceInfo));
    }
    ((SubMsgType0x7.MsgBody.ActionInfo)localObject).setHasFlag(true);
    localFTNNotify.msg_ActionInfo.set((MessageMicro)localObject);
    localFTNNotify.setHasFlag(true);
    if (1 == paramInt) {
      paramString.rpt_msg_subcmd_0x1_ftn_notify.add(localFTNNotify);
    }
    for (;;)
    {
      paramString.setHasFlag(true);
      return paramString;
      paramString.rpt_msg_subcmd_0x9_ftn_thumb_notify.add(localFTNNotify);
    }
  }
  
  public SubMsgType0x7.MsgBody MsgBodyFromFileControl(FileControl paramFileControl, long paramLong, String paramString, int paramInt)
  {
    paramString = new SubMsgType0x7.MsgBody();
    paramString.uint32_sub_cmd.set(paramInt);
    paramInt = DataLineMsgRecord.getDevTypeBySeId(paramFileControl.uint64_sessionid);
    fillMsgHeader(paramString.msg_header, paramLong, paramInt);
    SubMsgType0x7.MsgBody.FileControl localFileControl = new SubMsgType0x7.MsgBody.FileControl();
    localFileControl.uint64_sessionid.set(paramFileControl.uint64_sessionid);
    localFileControl.uint32_operate.set(paramFileControl.uint32_operate);
    localFileControl.uint32_seq.set(paramFileControl.uint32_seq);
    localFileControl.uint32_group_id.set(paramFileControl.uint32_group_id);
    localFileControl.uint32_batchID.set(paramFileControl.uint32_batchID);
    if ((paramFileControl.str_msg != null) && (paramFileControl.str_msg.length() != 0)) {
      localFileControl.str_msg.set(paramFileControl.str_msg);
    }
    localFileControl.setHasFlag(true);
    paramString.rpt_msg_subcmd_0x3_filecontrol.add(localFileControl);
    paramString.setHasFlag(true);
    return paramString;
  }
  
  public SubMsgType0x7.MsgBody MsgBodyFromMpFileNotify(long paramLong1, long paramLong2, int paramInt)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(11);
    fillMsgHeader(localMsgBody.msg_header, paramLong1);
    SubMsgType0x7.MsgBody.MpFileNotify localMpFileNotify = new SubMsgType0x7.MsgBody.MpFileNotify();
    localMpFileNotify.uint64_sessionid.set(paramLong2);
    localMpFileNotify.uint32_operate.set(paramInt);
    localMpFileNotify.uint32_type.set(1);
    localMpFileNotify.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0xb_mpfile_notify.add(localMpFileNotify);
    localMsgBody.setHasFlag(true);
    return localMsgBody;
  }
  
  public SubMsgType0x7.MsgBody MsgBodyFromMpFileNotify(long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(11);
    fillMsgHeader(localMsgBody.msg_header, paramLong1);
    SubMsgType0x7.MsgBody.MpFileNotify localMpFileNotify = new SubMsgType0x7.MsgBody.MpFileNotify();
    localMpFileNotify.uint64_sessionid.set(paramLong2);
    localMpFileNotify.uint32_operate.set(paramInt);
    localMpFileNotify.uint32_type.set(1);
    localMpFileNotify.uint32_power.set(3);
    localMpFileNotify.uint32_operate.set(paramInt);
    JSONObject localJSONObject = new JSONObject();
    if ((paramInt == 2) || (paramInt == 4)) {}
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("nonce", paramString);
      }
      localJSONObject.put("apn", AppNetConnInfo.getCurrentAPN());
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    paramString = localJSONObject.toString();
    if (paramString != null) {
      localMpFileNotify.bytes_json.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    }
    localMpFileNotify.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0xb_mpfile_notify.add(localMpFileNotify);
    localMsgBody.setHasFlag(true);
    return localMsgBody;
  }
  
  public SubMsgType0x7.MsgBody MsgBodyFromNFCNotify(NFCNotify paramNFCNotify, long paramLong, String paramString, int paramInt)
  {
    paramString = paramNFCNotify.str_file_name;
    Object localObject1 = paramNFCNotify.str_file_name;
    int i = paramNFCNotify.uint32_originfiletype;
    boolean bool;
    if (paramNFCNotify.bytes_originfile_md5 == null)
    {
      bool = true;
      Object localObject2 = FixImageFileExtName(paramString, (String)localObject1, i, bool);
      paramString = new SubMsgType0x7.MsgBody();
      i = DataLineMsgRecord.getDevTypeBySeId(paramNFCNotify.uint64_sessionid);
      paramString.uint32_sub_cmd.set(paramInt);
      fillMsgHeader(paramString.msg_header, paramLong, i);
      localObject1 = new SubMsgType0x7.MsgBody.NFCNotify();
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).uint64_sessionid.set(paramNFCNotify.uint64_sessionid);
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).str_file_name.set((String)localObject2);
      if (paramNFCNotify.bytes_file_md5 != null) {
        ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(paramNFCNotify.bytes_file_md5));
      }
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).fixed32_ip.set(paramNFCNotify.fixed32_ip);
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).uint32_port.set(paramNFCNotify.uint32_port);
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).bytes_url_notify.set(ByteStringMicro.copyFrom(paramNFCNotify.bytes_url_notify));
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).bytes_tokenkey.set(ByteStringMicro.copyFrom("1234567890123456".getBytes()));
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).uint64_file_len.set(paramNFCNotify.uint64_file_len);
      if (paramNFCNotify.bytes_originfile_md5 != null) {
        ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).bytes_originfile_md5.set(ByteStringMicro.copyFrom(paramNFCNotify.bytes_originfile_md5));
      }
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).uint32_originfiletype.set(paramNFCNotify.uint32_originfiletype);
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).uint32_batchID.set(paramNFCNotify.uint32_batchID);
      if (paramNFCNotify.uint32_group_size > 1)
      {
        ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).uint32_group_id.set(paramNFCNotify.uint32_group_id);
        ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).uint32_group_size.set(paramNFCNotify.uint32_group_size);
        ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).uint32_group_curindex.set(paramNFCNotify.uint32_group_curindex);
        ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).uint32_groupflag.set(paramNFCNotify.uint32_groupflag);
      }
      localObject2 = new SubMsgType0x7.MsgBody.ActionInfo();
      ((SubMsgType0x7.MsgBody.ActionInfo)localObject2).str_service_name.set(paramNFCNotify.msg_ActionInfo.strServiceName);
      if (paramNFCNotify.msg_ActionInfo.vServiceInfo != null) {
        ((SubMsgType0x7.MsgBody.ActionInfo)localObject2).bytes_buf.set(ByteStringMicro.copyFrom(paramNFCNotify.msg_ActionInfo.vServiceInfo));
      }
      ((SubMsgType0x7.MsgBody.ActionInfo)localObject2).setHasFlag(true);
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).msg_ActionInfo.set((MessageMicro)localObject2);
      ((SubMsgType0x7.MsgBody.NFCNotify)localObject1).setHasFlag(true);
      if (2 != paramInt) {
        break label409;
      }
      paramString.rpt_msg_subcmd_0x2_nfc_notify.add((MessageMicro)localObject1);
    }
    for (;;)
    {
      paramString.setHasFlag(true);
      return paramString;
      bool = false;
      break;
      label409:
      paramString.rpt_msg_subcmd_0xa_nfc_thumb_notify.add((MessageMicro)localObject1);
    }
  }
  
  public MsgCSBody MsgCSBodyFromFTNNotify(int paramInt, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.FTNNotify> paramList, boolean paramBoolean)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgTime = paramInt;
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramMsgHeader.uint32_src_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramMsgHeader.uint32_src_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = paramMsgHeader.uint32_dst_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = paramMsgHeader.uint32_dst_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramMsgHeader.uint64_dst_uin.get();
    Object localObject = localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader;
    long l;
    label280:
    SubMsgType0x7.MsgBody.FTNNotify localFTNNotify;
    label328:
    FTNNotify localFTNNotify1;
    if (paramMsgHeader.uint64_src_uin.has())
    {
      l = paramMsgHeader.uint64_src_uin.get();
      ((MsgHeader)localObject).uint64_src_uin = l;
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_ter_type = paramMsgHeader.uint32_dst_ter_type.get();
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type = paramMsgHeader.uint32_src_ter_type.get();
      localObject = new ArrayList();
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localFTNNotify = (SubMsgType0x7.MsgBody.FTNNotify)paramList.next();
      } while (!localFTNNotify.uint64_sessionid.has());
      paramMsgHeader = localMsgCSBody.msgBody0x211.msgBody0x211_0x7;
      if (!paramBoolean) {
        break label702;
      }
      paramInt = 9;
      paramMsgHeader.uMsgSubCmd = paramInt;
      localFTNNotify1 = new FTNNotify();
      localFTNNotify1.uint64_sessionid = GenSessionIdFromDev(localFTNNotify.uint64_sessionid.get(), localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type);
      localFTNNotify1.str_file_name = localFTNNotify.str_file_name.get();
      localFTNNotify1.str_file_index = localFTNNotify.str_file_index.get();
      localFTNNotify1.bytes_file_md5 = localFTNNotify.bytes_file_md5.get().toByteArray();
      localFTNNotify1.uint64_file_len = localFTNNotify.uint64_file_len.get();
      if (!paramBoolean) {
        break label707;
      }
      paramMsgHeader = null;
      label435:
      localFTNNotify1.bytes_originfile_md5 = paramMsgHeader;
      localFTNNotify1.uint32_originfiletype = localFTNNotify.uint32_originfiletype.get();
      if (!localFTNNotify.uint32_group_id.has()) {
        break label722;
      }
      paramInt = localFTNNotify.uint32_group_id.get();
      label474:
      localFTNNotify1.uint32_group_id = paramInt;
      if (!localFTNNotify.uint32_group_size.has()) {
        break label727;
      }
      paramInt = localFTNNotify.uint32_group_size.get();
      label500:
      localFTNNotify1.uint32_group_size = paramInt;
      if (!localFTNNotify.uint32_group_curindex.has()) {
        break label732;
      }
      paramInt = localFTNNotify.uint32_group_curindex.get();
      label526:
      localFTNNotify1.uint32_group_curindex = paramInt;
      localFTNNotify1.msg_ActionInfo = new ActionInfo();
      ActionInfo localActionInfo = localFTNNotify1.msg_ActionInfo;
      if (!localFTNNotify.msg_ActionInfo.has()) {
        break label737;
      }
      paramMsgHeader = ((SubMsgType0x7.MsgBody.ActionInfo)localFTNNotify.msg_ActionInfo.get()).str_service_name.get();
      label580:
      localActionInfo.strServiceName = paramMsgHeader;
      localActionInfo = localFTNNotify1.msg_ActionInfo;
      if (!localFTNNotify.msg_ActionInfo.has()) {
        break label742;
      }
      paramMsgHeader = ((SubMsgType0x7.MsgBody.ActionInfo)localFTNNotify.msg_ActionInfo.get()).bytes_buf.get().toByteArray();
      label625:
      localActionInfo.vServiceInfo = paramMsgHeader;
      if (!localFTNNotify.uint32_batchID.has()) {
        break label747;
      }
      paramInt = localFTNNotify.uint32_batchID.get();
      label651:
      localFTNNotify1.uint32_batchID = paramInt;
      if (!localFTNNotify.uint32_groupflag.has()) {
        break label752;
      }
    }
    label702:
    label707:
    label722:
    label727:
    label732:
    label737:
    label742:
    label747:
    label752:
    for (paramInt = localFTNNotify.uint32_groupflag.get();; paramInt = 0)
    {
      localFTNNotify1.uint32_groupflag = paramInt;
      ((List)localObject).add(localFTNNotify1);
      break label280;
      l = 0L;
      break;
      paramInt = 1;
      break label328;
      paramMsgHeader = localFTNNotify.bytes_originfile_md5.get().toByteArray();
      break label435;
      paramInt = 0;
      break label474;
      paramInt = 0;
      break label500;
      paramInt = 0;
      break label526;
      paramMsgHeader = null;
      break label580;
      paramMsgHeader = null;
      break label625;
      paramInt = 0;
      break label651;
    }
    if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd == 9) {
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb = ((FTNNotify[])((List)localObject).toArray(new FTNNotify[((List)localObject).size()]));
    }
    while (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd != 1) {
      return localMsgCSBody;
    }
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc = ((FTNNotify[])((List)localObject).toArray(new FTNNotify[((List)localObject).size()]));
    return localMsgCSBody;
  }
  
  public MsgCSBody MsgCSBodyFromFTNNotify_0x210(long paramLong1, long paramLong2, long paramLong3, String paramString1, long paramLong4, byte[] paramArrayOfByte1, String paramString2, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong5, long paramLong6, long paramLong7, boolean paramBoolean)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = msgHeader(GetSelfUin());
    ArrayList localArrayList = new ArrayList();
    Object localObject = localMsgCSBody.msgBody0x211.msgBody0x211_0x7;
    int i;
    if (paramArrayOfByte2 == null)
    {
      i = 9;
      ((MsgCSBody0x211_0x7)localObject).uMsgSubCmd = i;
      localObject = new FTNNotify();
      ((FTNNotify)localObject).uint64_sessionid = paramLong1;
      ((FTNNotify)localObject).str_file_name = paramString1;
      ((FTNNotify)localObject).str_file_index = paramString2;
      ((FTNNotify)localObject).bytes_file_md5 = paramArrayOfByte1;
      ((FTNNotify)localObject).uint64_file_len = paramLong4;
      ((FTNNotify)localObject).bytes_originfile_md5 = paramArrayOfByte2;
      ((FTNNotify)localObject).uint32_originfiletype = ((int)paramLong2);
      ((FTNNotify)localObject).uint32_group_id = paramInt1;
      ((FTNNotify)localObject).uint32_group_size = paramInt2;
      ((FTNNotify)localObject).uint32_group_curindex = paramInt3;
      ((FTNNotify)localObject).uint32_batchID = paramInt4;
      ((FTNNotify)localObject).msg_ActionInfo = new ActionInfo();
      localArrayList.add(localObject);
      if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd != 9) {
        break label274;
      }
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb = ((FTNNotify[])localArrayList.toArray(new FTNNotify[localArrayList.size()]));
    }
    label274:
    while (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd != 1)
    {
      return localMsgCSBody;
      i = 1;
      break;
    }
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc = ((FTNNotify[])localArrayList.toArray(new FTNNotify[localArrayList.size()]));
    return localMsgCSBody;
  }
  
  public MsgCSBody MsgCSBodyFromFileControl(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.FileControl> paramList)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = 3;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramMsgHeader.uint32_src_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramMsgHeader.uint32_src_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = paramMsgHeader.uint32_dst_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = paramMsgHeader.uint32_dst_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramMsgHeader.uint64_dst_uin.get();
    Object localObject = localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader;
    long l;
    label286:
    SubMsgType0x7.MsgBody.FileControl localFileControl;
    FileControl localFileControl1;
    if (paramMsgHeader.uint64_src_uin.has())
    {
      l = paramMsgHeader.uint64_src_uin.get();
      ((MsgHeader)localObject).uint64_src_uin = l;
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_ter_type = paramMsgHeader.uint32_dst_ter_type.get();
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type = paramMsgHeader.uint32_src_ter_type.get();
      localObject = new ArrayList();
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localFileControl = (SubMsgType0x7.MsgBody.FileControl)paramList.next();
      } while ((!localFileControl.uint64_sessionid.has()) || (!localFileControl.uint32_operate.has()));
      localFileControl1 = new FileControl();
      localFileControl1.uint64_sessionid = GenSessionIdFromDev(localFileControl.uint64_sessionid.get(), localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type);
      localFileControl1.uint32_operate = localFileControl.uint32_operate.get();
      if (!localFileControl.uint32_seq.has()) {
        break label654;
      }
      i = localFileControl.uint32_seq.get();
      label401:
      localFileControl1.uint32_seq = i;
      if (!localFileControl.uint32_code.has()) {
        break label659;
      }
      i = localFileControl.uint32_code.get();
      label427:
      localFileControl1.uint32_code = i;
      if (!localFileControl.str_msg.has()) {
        break label664;
      }
      paramMsgHeader = localFileControl.str_msg.get();
      label453:
      localFileControl1.str_msg = paramMsgHeader;
      if (!localFileControl.uint32_group_id.has()) {
        break label669;
      }
      i = localFileControl.uint32_group_id.get();
      label479:
      localFileControl1.uint32_group_id = i;
      if (!localFileControl.uint32_group_curindex.has()) {
        break label674;
      }
      i = localFileControl.uint32_group_curindex.get();
      label505:
      localFileControl1.uint32_group_curindex = i;
      if (!localFileControl.uint32_batchID.has()) {
        break label679;
      }
    }
    label654:
    label659:
    label664:
    label669:
    label674:
    label679:
    for (int i = localFileControl.uint32_batchID.get();; i = 0)
    {
      localFileControl1.uint32_batchID = i;
      ((List)localObject).add(localFileControl1);
      if (!QLog.isColorLevel()) {
        break label286;
      }
      QLog.d("dataline.ProtocolHelper", 2, "onFileOperate0x211, 控制信令, sessionid[" + localFileControl1.uint64_sessionid + "]; curindex[" + localFileControl1.uint32_group_curindex + "]; group_id[" + localFileControl1.uint32_group_id + "]; batchID[" + localFileControl1.uint32_batchID + "]; operate[" + localFileControl1.uint32_operate + "];");
      break label286;
      l = 0L;
      break;
      i = 0;
      break label401;
      i = 0;
      break label427;
      paramMsgHeader = null;
      break label453;
      i = 0;
      break label479;
      i = 0;
      break label505;
    }
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl = ((FileControl[])((List)localObject).toArray(new FileControl[((List)localObject).size()]));
    return localMsgCSBody;
  }
  
  public MsgCSBody MsgCSBodyFromFileControl_0x210(long paramLong1, long paramLong2, int paramInt1, int paramInt2, short paramShort)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.ProtocolHelper", 2, "uSessionID[" + paramLong1 + "]onFileOpdrate: 210  operate = " + paramLong2);
    }
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = msgHeader(GetSelfUin());
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = 3;
    ArrayList localArrayList = new ArrayList();
    FileControl localFileControl = new FileControl();
    localFileControl.uint64_sessionid = paramLong1;
    localFileControl.uint32_operate = ((int)paramLong2);
    localFileControl.uint32_seq = paramShort;
    localFileControl.uint32_code = 0;
    localFileControl.str_msg = null;
    localFileControl.uint32_group_id = paramInt2;
    localFileControl.uint32_group_curindex = 0;
    localFileControl.uint32_batchID = 0;
    localArrayList.add(localFileControl);
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl = ((FileControl[])localArrayList.toArray(new FileControl[localArrayList.size()]));
    return localMsgCSBody;
  }
  
  public MsgCSBody MsgCSBodyFromNFCNotify(int paramInt, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.NFCNotify> paramList, boolean paramBoolean)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgTime = paramInt;
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramMsgHeader.uint32_src_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramMsgHeader.uint32_src_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = paramMsgHeader.uint32_dst_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = paramMsgHeader.uint32_dst_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramMsgHeader.uint64_dst_uin.get();
    Object localObject = localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader;
    long l;
    label295:
    SubMsgType0x7.MsgBody.NFCNotify localNFCNotify;
    label371:
    NFCNotify localNFCNotify1;
    if (paramMsgHeader.uint64_src_uin.has())
    {
      l = paramMsgHeader.uint64_src_uin.get();
      ((MsgHeader)localObject).uint64_src_uin = l;
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_uin_type = 0;
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_ter_type = paramMsgHeader.uint32_dst_ter_type.get();
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type = paramMsgHeader.uint32_src_ter_type.get();
      localObject = new ArrayList();
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localNFCNotify = (SubMsgType0x7.MsgBody.NFCNotify)paramList.next();
      } while (!localNFCNotify.uint64_sessionid.has());
      l = GenSessionIdFromDev(localNFCNotify.uint64_sessionid.get(), localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type);
      paramMsgHeader = localMsgCSBody.msgBody0x211.msgBody0x211_0x7;
      if (!paramBoolean) {
        break label917;
      }
      paramInt = 10;
      paramMsgHeader.uMsgSubCmd = paramInt;
      localNFCNotify1 = new NFCNotify();
      localNFCNotify1.uint64_sessionid = l;
      localNFCNotify1.str_file_name = localNFCNotify.str_file_name.get();
      localNFCNotify1.bytes_file_md5 = localNFCNotify.bytes_file_md5.get().toByteArray();
      localNFCNotify1.fixed32_ip = localNFCNotify.fixed32_ip.get();
      localNFCNotify1.uint32_port = localNFCNotify.uint32_port.get();
      localNFCNotify1.bytes_url_notify = localNFCNotify.bytes_url_notify.get().toByteArray();
      localNFCNotify1.bytes_tokenkey = localNFCNotify.bytes_tokenkey.get().toByteArray();
      localNFCNotify1.uint64_file_len = localNFCNotify.uint64_file_len.get();
      if (!paramBoolean) {
        break label922;
      }
      paramMsgHeader = null;
      label499:
      localNFCNotify1.bytes_originfile_md5 = paramMsgHeader;
      localNFCNotify1.uint32_originfiletype = localNFCNotify.uint32_originfiletype.get();
      if (!localNFCNotify.uint32_group_id.has()) {
        break label937;
      }
      paramInt = localNFCNotify.uint32_group_id.get();
      label538:
      localNFCNotify1.uint32_group_id = paramInt;
      if (!localNFCNotify.uint32_group_size.has()) {
        break label942;
      }
      paramInt = localNFCNotify.uint32_group_size.get();
      label564:
      localNFCNotify1.uint32_group_size = paramInt;
      if (!localNFCNotify.uint32_group_curindex.has()) {
        break label947;
      }
      paramInt = localNFCNotify.uint32_group_curindex.get();
      label590:
      localNFCNotify1.uint32_group_curindex = paramInt;
      localNFCNotify1.msg_ActionInfo = new ActionInfo();
      ActionInfo localActionInfo = localNFCNotify1.msg_ActionInfo;
      if (!localNFCNotify.msg_ActionInfo.has()) {
        break label952;
      }
      paramMsgHeader = ((SubMsgType0x7.MsgBody.ActionInfo)localNFCNotify.msg_ActionInfo.get()).str_service_name.get();
      label644:
      localActionInfo.strServiceName = paramMsgHeader;
      localActionInfo = localNFCNotify1.msg_ActionInfo;
      if (!localNFCNotify.msg_ActionInfo.has()) {
        break label957;
      }
      paramMsgHeader = ((SubMsgType0x7.MsgBody.ActionInfo)localNFCNotify.msg_ActionInfo.get()).bytes_buf.get().toByteArray();
      label689:
      localActionInfo.vServiceInfo = paramMsgHeader;
      if (!localNFCNotify.uint32_batchID.has()) {
        break label962;
      }
      paramInt = localNFCNotify.uint32_batchID.get();
      label715:
      localNFCNotify1.uint32_batchID = paramInt;
      if (!localNFCNotify.uint32_groupflag.has()) {
        break label967;
      }
    }
    label917:
    label922:
    label937:
    label942:
    label947:
    label952:
    label957:
    label962:
    label967:
    for (paramInt = localNFCNotify.uint32_groupflag.get();; paramInt = 0)
    {
      localNFCNotify1.uint32_groupflag = paramInt;
      ((List)localObject).add(localNFCNotify1);
      if (!QLog.isColorLevel()) {
        break label295;
      }
      QLog.d("dataline.ProtocolHelper", 2, "onFileComing0x211_0xa_0x2, 近场信令[" + paramBoolean + "]; sessionid[" + localNFCNotify1.uint64_sessionid + "]; curindex[" + localNFCNotify1.uint32_group_curindex + "]; group_id[" + localNFCNotify1.uint32_group_id + "]; group_size[" + localNFCNotify1.uint32_group_size + "]; batchID[" + localNFCNotify1.uint32_batchID + "]; groupflag[" + localNFCNotify1.uint32_groupflag + "]; file_name[" + localNFCNotify1.str_file_name + "]; file_len[" + localNFCNotify1.uint64_file_len + "];");
      break label295;
      l = 0L;
      break;
      paramInt = 2;
      break label371;
      paramMsgHeader = localNFCNotify.bytes_originfile_md5.get().toByteArray();
      break label499;
      paramInt = 0;
      break label538;
      paramInt = 0;
      break label564;
      paramInt = 0;
      break label590;
      paramMsgHeader = null;
      break label644;
      paramMsgHeader = null;
      break label689;
      paramInt = 0;
      break label715;
    }
    if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd == 10) {
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb = ((NFCNotify[])((List)localObject).toArray(new NFCNotify[((List)localObject).size()]));
    }
    while (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd != 2) {
      return localMsgCSBody;
    }
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc = ((NFCNotify[])((List)localObject).toArray(new NFCNotify[((List)localObject).size()]));
    return localMsgCSBody;
  }
  
  public MsgCSBody MsgCSBodyFromNFCNotify_0x210(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, byte[] paramArrayOfByte1, long paramLong5, long paramLong6, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong7, long paramLong8, long paramLong9, boolean paramBoolean)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = msgHeader(GetSelfUin());
    ArrayList localArrayList = new ArrayList();
    Object localObject = localMsgCSBody.msgBody0x211.msgBody0x211_0x7;
    int i;
    if (paramArrayOfByte4 == null)
    {
      i = 10;
      ((MsgCSBody0x211_0x7)localObject).uMsgSubCmd = i;
      localObject = new NFCNotify();
      ((NFCNotify)localObject).uint64_sessionid = paramLong1;
      ((NFCNotify)localObject).str_file_name = paramString;
      ((NFCNotify)localObject).bytes_file_md5 = paramArrayOfByte1;
      ((NFCNotify)localObject).fixed32_ip = ((int)paramLong5);
      ((NFCNotify)localObject).uint32_port = ((int)paramLong6);
      ((NFCNotify)localObject).bytes_url_notify = paramArrayOfByte2;
      ((NFCNotify)localObject).bytes_tokenkey = paramArrayOfByte3;
      ((NFCNotify)localObject).uint64_file_len = paramLong4;
      ((NFCNotify)localObject).bytes_originfile_md5 = paramArrayOfByte4;
      ((NFCNotify)localObject).uint32_originfiletype = ((int)paramLong2);
      ((NFCNotify)localObject).uint32_group_id = paramInt1;
      ((NFCNotify)localObject).uint32_group_size = paramInt2;
      ((NFCNotify)localObject).uint32_group_curindex = paramInt3;
      ((NFCNotify)localObject).uint32_batchID = paramInt4;
      ((NFCNotify)localObject).msg_ActionInfo = new ActionInfo();
      localArrayList.add(localObject);
      if (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd != 10) {
        break label315;
      }
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb = ((NFCNotify[])localArrayList.toArray(new NFCNotify[localArrayList.size()]));
    }
    label315:
    while (localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd != 2)
    {
      return localMsgCSBody;
      i = 2;
      break;
    }
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc = ((NFCNotify[])localArrayList.toArray(new NFCNotify[localArrayList.size()]));
    return localMsgCSBody;
  }
  
  public MsgCSBody MsgCSBodyFromRFCInfoNotify(int paramInt, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.RNFCNotify> paramList)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    localMsgCSBody.uMsgTime = paramInt;
    localMsgCSBody.uMsgType = 529;
    localMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
    localMsgCSBody.msgBody0x211.uMsgSubType = 7;
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramMsgHeader.uint32_src_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramMsgHeader.uint32_src_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_app_id = paramMsgHeader.uint32_dst_app_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_inst_id = paramMsgHeader.uint32_dst_inst_id.get();
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramMsgHeader.uint64_dst_uin.get();
    Object localObject = localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader;
    if (paramMsgHeader.uint64_src_uin.has()) {}
    for (long l = paramMsgHeader.uint64_src_uin.get();; l = 0L)
    {
      ((MsgHeader)localObject).uint64_src_uin = l;
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_uin_type = 0;
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = 8;
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_ter_type = paramMsgHeader.uint32_dst_ter_type.get();
      localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type = paramMsgHeader.uint32_src_ter_type.get();
      paramMsgHeader = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (SubMsgType0x7.MsgBody.RNFCNotify)paramList.next();
        l = GenSessionIdFromDev(((SubMsgType0x7.MsgBody.RNFCNotify)localObject).uint64_sessionid.get(), localMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_ter_type);
        RFCInfoNotify localRFCInfoNotify = new RFCInfoNotify();
        localRFCInfoNotify.uSessionId = l;
        localRFCInfoNotify.uServerIp = ((SubMsgType0x7.MsgBody.RNFCNotify)localObject).fixed32_ip.get();
        localRFCInfoNotify.uSvrPort = ((SubMsgType0x7.MsgBody.RNFCNotify)localObject).uint32_port.get();
        localRFCInfoNotify.vTokenKey = ((SubMsgType0x7.MsgBody.RNFCNotify)localObject).bytes_token.get().toByteArray();
        localRFCInfoNotify.uSvrTaskId = ((SubMsgType0x7.MsgBody.RNFCNotify)localObject).uint64_svrTaskId.get();
        paramMsgHeader.add(localRFCInfoNotify);
      }
    }
    localMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x8_RFCInfoNotiy = ((RFCInfoNotify[])paramMsgHeader.toArray(new RFCInfoNotify[paramMsgHeader.size()]));
    return localMsgCSBody;
  }
  
  public void fillMsgHeader(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, long paramLong)
  {
    fillMsgHeader(paramMsgHeader, paramLong, GetSelfUin());
  }
  
  public void fillMsgHeader(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, long paramLong, int paramInt)
  {
    fillMsgHeader(paramMsgHeader, paramLong, GetSelfUin(), paramInt);
  }
  
  public void fillService(Session paramSession, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramSession != null) && (paramString != null) && (paramString.length() > 0))
    {
      paramSession.actionInfo = new ActionInfo();
      paramSession.actionInfo.strServiceName = paramString;
      paramSession.actionInfo.vServiceInfo = paramArrayOfByte;
    }
  }
  
  public Session genSession(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6)
  {
    return genSession(paramInt1, paramString1, paramString2, null, paramInt2, paramInt3, paramLong, paramInt4, paramInt5, paramInt6);
  }
  
  public Session genSession(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.ProtocolHelper", 2, "--->>sendFile sPath[" + paramString1 + "], sPathThumb[" + paramString2 + "], type[" + paramInt2 + "], fileFrom[" + paramInt1);
    }
    if ((paramInt1 == 0) && (paramString1 != null) && (!paramString1.equals("")))
    {
      localObject = new File(paramString1);
      if (!((File)localObject).exists())
      {
        showFileNotExistDialog(((File)localObject).getName());
        return null;
      }
      if (((File)localObject).length() == 0L)
      {
        showFileIsEmptyDialog(((File)localObject).getName());
        return null;
      }
      if (((File)localObject).length() > 2147483648L)
      {
        showFileTooLargeDialog(((File)localObject).getName());
        return null;
      }
    }
    Object localObject = new Session();
    ((Session)localObject).uSessionID = paramLong;
    ((Session)localObject).emFileFrom = paramInt1;
    ((Session)localObject).bSend = true;
    ((Session)localObject).emFileType = paramInt2;
    ((Session)localObject).uChannelType = paramInt3;
    ((Session)localObject).dwGroupID = paramInt4;
    ((Session)localObject).dwGroupSize = paramInt5;
    ((Session)localObject).dwGroupIndex = paramInt6;
    ((Session)localObject).pFileBuffer = null;
    ((Session)localObject).strFilePathSrc = paramString1;
    ((Session)localObject).strFilePathThumb = paramString2;
    ((Session)localObject).strFileNameSrc = paramString3;
    return localObject;
  }
  
  public Session genSession(DataLineMsgRecord paramDataLineMsgRecord)
  {
    Session localSession = genSession(paramDataLineMsgRecord.fileFrom, paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, paramDataLineMsgRecord.filename, ajuo.b(paramDataLineMsgRecord.msgtype), 0, paramDataLineMsgRecord.sessionid, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex);
    if (localSession != null)
    {
      localSession.uFileSizeSrc = paramDataLineMsgRecord.filesize;
      if (paramDataLineMsgRecord.fileUuid != null) {
        localSession.vOfflineFileUUID = paramDataLineMsgRecord.fileUuid.getBytes();
      }
      if (paramDataLineMsgRecord.md5 != null) {
        localSession.vFileMD5Src = paramDataLineMsgRecord.md5;
      }
      localSession.uOwnerUin = paramDataLineMsgRecord.uOwnerUin;
    }
    return localSession;
  }
  
  boolean isMyNotify(SubMsgType0x7.MsgBody.ActionInfo paramActionInfo, String paramString)
  {
    if (paramActionInfo.str_service_name.has())
    {
      paramActionInfo = paramActionInfo.str_service_name.get();
      if ((paramActionInfo.length() > 0) && (paramActionInfo.compareToIgnoreCase(paramString) == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public SubMsgType0x7.MsgBody msgBodyFromRFCInfoNotify(RFCInfoNotify paramRFCInfoNotify, long paramLong, String paramString, int paramInt)
  {
    paramString = new SubMsgType0x7.MsgBody();
    int i = DataLineMsgRecord.getDevTypeBySeId(paramRFCInfoNotify.uSessionId);
    fillMsgHeader(paramString.msg_header, paramLong, i);
    paramString.uint32_sub_cmd.set(paramInt);
    SubMsgType0x7.MsgBody.RNFCNotify localRNFCNotify = new SubMsgType0x7.MsgBody.RNFCNotify();
    localRNFCNotify.uint64_sessionid.set(paramRFCInfoNotify.uSessionId);
    localRNFCNotify.bytes_token.set(ByteStringMicro.copyFrom(paramRFCInfoNotify.vTokenKey));
    localRNFCNotify.fixed32_ip.set(paramRFCInfoNotify.uServerIp);
    localRNFCNotify.uint32_port.set(paramRFCInfoNotify.uSvrPort);
    localRNFCNotify.uint64_svrTaskId.set(paramRFCInfoNotify.uSvrTaskId);
    paramString.rpt_msg_subcmd_0x8_rnfc_notify.add(localRNFCNotify);
    return paramString;
  }
  
  public MsgHeader msgHeader(long paramLong)
  {
    return msgHeader(paramLong, 0);
  }
  
  public MsgHeader msgHeader(long paramLong, int paramInt)
  {
    int i = AppSetting.a();
    MsgHeader localMsgHeader = new MsgHeader();
    localMsgHeader.uint32_src_app_id = 1001;
    localMsgHeader.uint32_src_inst_id = i;
    localMsgHeader.uint64_dst_uin = paramLong;
    localMsgHeader.uint64_src_uin = GetSelfUin();
    GetTypeInfo(paramInt);
    localMsgHeader.uint32_dst_ter_type = mDstType;
    localMsgHeader.uint32_dst_app_id = mDstAppId;
    localMsgHeader.uint32_dst_inst_id = mDstInstId;
    localMsgHeader.uint32_src_ter_type = 2;
    return localMsgHeader;
  }
  
  public void showFileIsEmptyDialog(String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      aptv.a("'" + paramString + "'" + BaseApplication.getContext().getResources().getString(2131693903));
      return;
    }
    new Handler(localLooper).post(new ProtocolHelper.1(this, paramString));
  }
  
  public void showFileNotExistDialog(String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      aptv.a("'" + paramString + "'" + BaseApplication.getContext().getResources().getString(2131693907));
      return;
    }
    new Handler(localLooper).post(new ProtocolHelper.3(this, paramString));
  }
  
  public void showFileTooLargeDialog(String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      aptv.a("'" + paramString + "'" + BaseApplication.getContext().getResources().getString(2131693905));
      return;
    }
    new Handler(localLooper).post(new ProtocolHelper.2(this, paramString));
  }
  
  public void showNoNetworkDialog()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      aptv.a(2131693944);
      return;
    }
    new Handler(localLooper).post(new ProtocolHelper.5(this));
  }
  
  public void showQQIsOfflineDialog()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      aptv.a(2131693943);
      return;
    }
    new Handler(localLooper).post(new ProtocolHelper.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.litetransfersdk.ProtocolHelper
 * JD-Core Version:    0.7.0.1
 */