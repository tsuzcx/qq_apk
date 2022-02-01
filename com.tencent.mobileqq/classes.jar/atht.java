import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.10;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.11;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.12;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.3;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.4;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.6;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.7;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.8;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.9;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor.A9Message;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x1ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x2ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x3ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x5ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x6ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x7ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0xaReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x1RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x2RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x3RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x5RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x6RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x7RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0xaRspBody;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadAbsReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadAbsRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346.DeleteFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.DeleteFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.FileInfo;
import tencent.im.cs.cmd0x346.cmd0x346.RecallFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.RecallFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.RecvListQueryReq;
import tencent.im.cs.cmd0x346.cmd0x346.RecvListQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.SendListQueryReq;
import tencent.im.cs.cmd0x346.cmd0x346.SendListQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccRsp;
import tencent.im.cs.face2face_file.face2face_file.msg;
import tencent.im.msg.im_msg_body.GroupFile;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.msg.resv21.hummer_resv_21.FileApkInfo;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x5.SubMsgType0x5.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;

public class atht
{
  private static int jdField_a_of_type_Int;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static final String jdField_a_of_type_JavaLangString = atib.class.getName();
  public static final byte[] a;
  private long jdField_a_of_type_Long;
  private bcro jdField_a_of_type_Bcro = new bcro();
  private bcrs jdField_a_of_type_Bcrs = new bcrs();
  bedr jdField_a_of_type_Bedr = null;
  public final QQAppInterface a;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
  private Map<Long, atib> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new athu(Looper.getMainLooper());
    jdField_a_of_type_ArrayOfByte = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 101 };
  }
  
  public atht(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private int a(long paramLong, im_msg_body.NotOnlineFile paramNotOnlineFile, int paramInt)
  {
    if (paramNotOnlineFile.uint32_reserved.has())
    {
      int i = paramNotOnlineFile.uint32_reserved.get();
      paramInt = i;
      if (i == paramLong) {
        paramInt = 0;
      }
    }
    return paramInt;
  }
  
  private athy a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    int i = paramArrayOfByte.length;
    athy localathy = new athy(null);
    int j;
    byte[] arrayOfByte;
    if (i >= 16)
    {
      j = PkgTools.getShortData(paramArrayOfByte, 0);
      arrayOfByte = new byte[j];
      if (i < j + 2) {
        break label179;
      }
      PkgTools.getBytesData(paramArrayOfByte, 2, arrayOfByte, j);
      j += 2;
    }
    try
    {
      localathy.jdField_a_of_type_JavaLangString = new String(arrayOfByte, "UTF-16LE");
      if (i >= j + 4)
      {
        long l = PkgTools.getLongData(paramArrayOfByte, j);
        int k = j + 4;
        if (i < k + 2) {
          break label238;
        }
        j = PkgTools.getShortData(paramArrayOfByte, k);
        k += 2;
        arrayOfByte = new byte[j];
        if (i < k + j) {
          break label248;
        }
        PkgTools.getBytesData(paramArrayOfByte, k, arrayOfByte, j);
        j = k + j;
        if (i < j + 4) {
          break label258;
        }
        localathy.jdField_a_of_type_Long = ((PkgTools.getLongData(paramArrayOfByte, j) << 32) + l);
        return localathy;
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filenamelen");
        return null;
        label179:
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filenamebuf");
        return null;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo: Exception is " + localUnsupportedEncodingException.toString());
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filelenlo");
      return null;
    }
    label238:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- otherlen");
    return null;
    label248:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- bufotherinfo");
    return null;
    label258:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeOnlineFileInfo failed- filelenhi");
    return null;
  }
  
  private FileManagerEntity a(MessageHandler paramMessageHandler, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
  {
    long l = paramInt2;
    boolean bool1 = false;
    boolean bool2 = false;
    paramLong3 = 0L;
    if (0L != l)
    {
      paramMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString1, l);
      if (paramMessageHandler != null)
      {
        paramLong3 = paramMessageHandler.nSessionId;
        bool1 = true;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString1, l))
        {
          paramMessageHandler.Uuid = paramString3;
          if (!paramString4.isEmpty())
          {
            paramMessageHandler.fileIdCrc = paramString4;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "Recv a online changto offline file. fileIdCrc: " + paramString4);
          }
          auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageHandler);
          auea.a(paramMessageHandler, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
          if ((paramBoolean2) && (paramBoolean1))
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "Recv a online changto offline file. name: " + paramString5 + ". is  roma and readed, think okt!!");
            a(paramString1, l, paramInt1, paramString3, paramLong1);
          }
          for (;;)
          {
            paramMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(paramString1, 0, paramMessageHandler.uniseq);
            if (paramMessageHandler != null)
            {
              if ((paramMessageHandler instanceof MessageForFile))
              {
                paramString2 = (MessageForFile)paramMessageHandler;
                paramString2.originalmsgShseq = paramMessageHandler.shmsgseq;
                paramString2.originalMsgUid = paramMessageHandler.msgUid;
                paramString2.originalTime = paramMessageHandler.time;
              }
              paramMessageHandler.shmsgseq = paramShort;
              paramMessageHandler.time = paramLong1;
              paramMessageHandler.msgUid = paramLong4;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getBaseMessageManager(paramInt1).a(paramString1, paramInt1, paramMessageHandler, 3);
            }
            return null;
            a(paramString1, l, paramInt1, paramString3, paramLong1);
          }
        }
        bool2 = true;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().d(paramLong3);
        QLog.i("FileTransferHandler<FileAssistant>", 1, "Recv a online changto offline file. name: " + paramString5 + ". user had delete about onlinefile record!!! ");
      }
      paramLong1 = paramLong3;
    }
    for (paramBoolean1 = bool1;; paramBoolean1 = false)
    {
      TransfileUtile.makeTransFileProtocolData(BuddyTransfileProcessor.getTransferFilePath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString5, 0, null), paramLong2, 0, false, null);
      paramLong2 = bcsa.a(-2005).uniseq;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (0L == l) {
        break label585;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().d(paramLong1);
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "Recv a offline file name: " + paramString5 + ". and it is : online changto offline. OLfilesession=" + l + "isPullRoam =" + paramBoolean2);
      }
      if (paramBoolean2) {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "Recv a online changto offline file. name: " + paramString5 + ". isPullRoam hadHasOlSessionRecord=" + paramBoolean1 + " isDelOlSessionRecord=" + bool2);
      }
      if ((0L == paramLong1) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong1))) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong1, paramLong2, paramString1, 0);
      paramLong1 = 0L;
      bool2 = true;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(paramLong2, paramString1, 0);
    label585:
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(paramLong2, paramString1, 0);
  }
  
  private ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString);
  }
  
  public static Pair<String, String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = paramString.getBytes();
    } while (paramString.length <= 36);
    byte[] arrayOfByte1 = new byte[32];
    byte[] arrayOfByte2 = new byte[paramString.length - 32];
    int i = 0;
    if (i < paramString.length)
    {
      if (i < 32) {
        arrayOfByte1[i] = paramString[i];
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfByte2[(i - 32)] = paramString[i];
      }
    }
    return new Pair(new String(arrayOfByte1), new String(arrayOfByte2));
  }
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFromServiceMsg.isSuccess()) {}
    try
    {
      localObject1 = this.jdField_a_of_type_Bcro.a(paramToServiceMsg, paramFromServiceMsg);
      return localObject1;
    }
    catch (Exception paramToServiceMsg)
    {
      do
      {
        paramToServiceMsg.printStackTrace();
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.d("FileTransferHandler<FileAssistant>", 2, this.jdField_a_of_type_Bcro.getClass().getSimpleName() + " decode error," + paramToServiceMsg.toString());
    }
    return null;
  }
  
  private String a(String paramString, bcse parambcse)
  {
    if ((parambcse.jdField_a_of_type_Int == 1000) || (parambcse.jdField_a_of_type_Int == 1020) || (parambcse.jdField_a_of_type_Int == 1004)) {
      paramString = String.valueOf(parambcse.jdField_b_of_type_Long);
    }
    return paramString;
  }
  
  private List<String> a(athx paramathx, List<String> paramList, cmd0x346.ApplyUploadRspV2 paramApplyUploadRspV2)
  {
    if (paramApplyUploadRspV2.int32_ret_code.has()) {
      paramathx.jdField_a_of_type_Int = paramApplyUploadRspV2.int32_ret_code.get();
    }
    if (paramApplyUploadRspV2.str_ret_msg.has()) {
      paramathx.jdField_a_of_type_JavaLangString = paramApplyUploadRspV2.str_ret_msg.get();
    }
    if (paramApplyUploadRspV2.uint64_total_space.has()) {
      paramathx.jdField_a_of_type_Long = paramApplyUploadRspV2.uint64_total_space.get();
    }
    if (paramApplyUploadRspV2.uint64_used_space.has()) {
      paramathx.jdField_b_of_type_Long = paramApplyUploadRspV2.uint64_used_space.get();
    }
    if (paramApplyUploadRspV2.uint64_uploaded_size.has()) {
      paramathx.jdField_c_of_type_Long = paramApplyUploadRspV2.uint64_uploaded_size.get();
    }
    if (paramApplyUploadRspV2.str_upload_ip.has()) {
      paramathx.jdField_b_of_type_JavaLangString = paramApplyUploadRspV2.str_upload_ip.get();
    }
    for (;;)
    {
      if (paramApplyUploadRspV2.uint32_upload_port.has()) {
        paramathx.jdField_a_of_type_Short = ((short)paramApplyUploadRspV2.uint32_upload_port.get());
      }
      if (paramApplyUploadRspV2.bytes_uuid.has()) {
        paramathx.jdField_a_of_type_ArrayOfByte = paramApplyUploadRspV2.bytes_uuid.get().toByteArray();
      }
      if (paramApplyUploadRspV2.bytes_upload_key.has()) {
        paramathx.jdField_b_of_type_ArrayOfByte = paramApplyUploadRspV2.bytes_upload_key.get().toByteArray();
      }
      if (paramApplyUploadRspV2.bool_file_exist.has()) {
        paramathx.jdField_a_of_type_Boolean = paramApplyUploadRspV2.bool_file_exist.get();
      }
      if (paramApplyUploadRspV2.uint32_upload_port.has()) {
        paramathx.jdField_b_of_type_Int = paramApplyUploadRspV2.uint32_pack_size.get();
      }
      if (paramApplyUploadRspV2.uint32_httpsvr_api_ver.has()) {
        paramathx.jdField_d_of_type_Int = paramApplyUploadRspV2.uint32_httpsvr_api_ver.get();
      }
      if (paramApplyUploadRspV2.bytes_sha.has()) {
        paramathx.jdField_c_of_type_ArrayOfByte = paramApplyUploadRspV2.bytes_sha.get().toByteArray();
      }
      Object localObject = paramList;
      if (paramApplyUploadRspV2.rpt_str_uploadip_list.has())
      {
        localObject = paramList;
        if (paramApplyUploadRspV2.rpt_str_uploadip_list.get().size() > 0) {
          localObject = paramApplyUploadRspV2.rpt_str_uploadip_list.get();
        }
      }
      if (paramApplyUploadRspV2.str_upload_https_domain.has()) {
        paramathx.jdField_c_of_type_JavaLangString = paramApplyUploadRspV2.str_upload_https_domain.get();
      }
      if (paramApplyUploadRspV2.uint32_upload_https_port.has()) {
        paramathx.jdField_b_of_type_Short = ((short)paramApplyUploadRspV2.uint32_upload_https_port.get());
      }
      if (paramApplyUploadRspV2.str_upload_dns.has()) {
        paramathx.jdField_d_of_type_JavaLangString = paramApplyUploadRspV2.str_upload_dns.get();
      }
      if (paramApplyUploadRspV2.str_upload_lanip.has()) {
        paramathx.jdField_e_of_type_JavaLangString = paramApplyUploadRspV2.str_upload_lanip.get();
      }
      return localObject;
      if (paramApplyUploadRspV2.str_upload_domain.has()) {
        paramathx.jdField_b_of_type_JavaLangString = paramApplyUploadRspV2.str_upload_domain.get();
      } else {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse has neither ip nor domain");
      }
    }
  }
  
  private List<String> a(athx paramathx, List<String> paramList, cmd0x346.ApplyUploadRspV3 paramApplyUploadRspV3)
  {
    if (paramApplyUploadRspV3.int32_ret_code.has()) {
      paramathx.jdField_a_of_type_Int = paramApplyUploadRspV3.int32_ret_code.get();
    }
    if (paramApplyUploadRspV3.str_ret_msg.has()) {
      paramathx.jdField_a_of_type_JavaLangString = paramApplyUploadRspV3.str_ret_msg.get();
    }
    if (paramApplyUploadRspV3.uint64_total_space.has()) {
      paramathx.jdField_a_of_type_Long = paramApplyUploadRspV3.uint64_total_space.get();
    }
    if (paramApplyUploadRspV3.uint64_used_space.has()) {
      paramathx.jdField_b_of_type_Long = paramApplyUploadRspV3.uint64_used_space.get();
    }
    if (paramApplyUploadRspV3.uint64_uploaded_size.has()) {
      paramathx.jdField_c_of_type_Long = paramApplyUploadRspV3.uint64_uploaded_size.get();
    }
    if (paramApplyUploadRspV3.str_upload_ip.has())
    {
      paramathx.jdField_b_of_type_JavaLangString = paramApplyUploadRspV3.str_upload_ip.get();
      if (paramApplyUploadRspV3.uint32_upload_port.has()) {
        paramathx.jdField_a_of_type_Short = ((short)paramApplyUploadRspV3.uint32_upload_port.get());
      }
      if (paramApplyUploadRspV3.bytes_uuid.has()) {
        paramathx.jdField_a_of_type_ArrayOfByte = paramApplyUploadRspV3.bytes_uuid.get().toByteArray();
      }
      if (paramApplyUploadRspV3.bytes_upload_key.has()) {
        paramathx.jdField_b_of_type_ArrayOfByte = paramApplyUploadRspV3.bytes_upload_key.get().toByteArray();
      }
      if (paramApplyUploadRspV3.bool_file_exist.has()) {
        paramathx.jdField_a_of_type_Boolean = paramApplyUploadRspV3.bool_file_exist.get();
      }
      if (paramathx.jdField_b_of_type_Boolean)
      {
        if (!paramathx.jdField_a_of_type_Boolean) {
          break label437;
        }
        if (paramApplyUploadRspV3.str_fileidcrc.has()) {
          paramathx.f = paramApplyUploadRspV3.str_fileidcrc.get();
        }
      }
    }
    for (;;)
    {
      if (paramApplyUploadRspV3.uint32_upload_port.has()) {
        paramathx.jdField_b_of_type_Int = paramApplyUploadRspV3.uint32_pack_size.get();
      }
      Object localObject = paramList;
      if (paramApplyUploadRspV3.rpt_str_uploadip_list.has())
      {
        localObject = paramList;
        if (paramApplyUploadRspV3.rpt_str_uploadip_list.get().size() > 0) {
          localObject = paramApplyUploadRspV3.rpt_str_uploadip_list.get();
        }
      }
      if (paramApplyUploadRspV3.str_upload_https_domain.has()) {
        paramathx.jdField_c_of_type_JavaLangString = paramApplyUploadRspV3.str_upload_https_domain.get();
      }
      if (paramApplyUploadRspV3.uint32_upload_https_port.has()) {
        paramathx.jdField_b_of_type_Short = ((short)paramApplyUploadRspV3.uint32_upload_https_port.get());
      }
      if (paramApplyUploadRspV3.str_upload_dns.has()) {
        paramathx.jdField_d_of_type_JavaLangString = paramApplyUploadRspV3.str_upload_dns.get();
      }
      if (paramApplyUploadRspV3.str_upload_lanip.has()) {
        paramathx.jdField_e_of_type_JavaLangString = paramApplyUploadRspV3.str_upload_lanip.get();
      }
      return localObject;
      if (paramApplyUploadRspV3.str_upload_domain.has())
      {
        paramathx.jdField_b_of_type_JavaLangString = paramApplyUploadRspV3.str_upload_domain.get();
        break;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse has neither ip nor domain");
      break;
      label437:
      if (paramApplyUploadRspV3.bytes_media_plateform_upload_key.has()) {
        paramathx.jdField_e_of_type_ArrayOfByte = paramApplyUploadRspV3.bytes_media_plateform_upload_key.get().toByteArray();
      } else {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponseV3: bUseMediaPlatform but has not bytes_media_plateform_upload_key");
      }
    }
  }
  
  private List<String> a(athx paramathx, List<String> paramList, cmd0x346.RspBody paramRspBody)
  {
    cmd0x346.ApplyUploadRsp localApplyUploadRsp = (cmd0x346.ApplyUploadRsp)paramRspBody.msg_apply_upload_rsp.get();
    if (localApplyUploadRsp.int32_ret_code.has()) {
      paramathx.jdField_a_of_type_Int = localApplyUploadRsp.int32_ret_code.get();
    }
    if (localApplyUploadRsp.str_ret_msg.has()) {
      paramathx.jdField_a_of_type_JavaLangString = localApplyUploadRsp.str_ret_msg.get();
    }
    if (localApplyUploadRsp.uint64_total_space.has()) {
      paramathx.jdField_a_of_type_Long = localApplyUploadRsp.uint64_total_space.get();
    }
    if (localApplyUploadRsp.uint64_used_space.has()) {
      paramathx.jdField_b_of_type_Long = localApplyUploadRsp.uint64_used_space.get();
    }
    if (localApplyUploadRsp.uint64_uploaded_size.has()) {
      paramathx.jdField_c_of_type_Long = localApplyUploadRsp.uint64_uploaded_size.get();
    }
    if (localApplyUploadRsp.str_upload_ip.has()) {
      paramathx.jdField_b_of_type_JavaLangString = localApplyUploadRsp.str_upload_ip.get();
    }
    for (;;)
    {
      if (localApplyUploadRsp.uint32_upload_port.has()) {
        paramathx.jdField_a_of_type_Short = ((short)localApplyUploadRsp.uint32_upload_port.get());
      }
      if (localApplyUploadRsp.bytes_uuid.has()) {
        paramathx.jdField_a_of_type_ArrayOfByte = localApplyUploadRsp.bytes_uuid.get().toByteArray();
      }
      if (localApplyUploadRsp.bytes_upload_key.has()) {
        paramathx.jdField_b_of_type_ArrayOfByte = localApplyUploadRsp.bytes_upload_key.get().toByteArray();
      }
      if (localApplyUploadRsp.bool_file_exist.has()) {
        paramathx.jdField_a_of_type_Boolean = localApplyUploadRsp.bool_file_exist.get();
      }
      if (localApplyUploadRsp.uint32_upload_port.has()) {
        paramathx.jdField_b_of_type_Int = localApplyUploadRsp.uint32_pack_size.get();
      }
      paramRspBody = paramList;
      if (localApplyUploadRsp.rpt_str_uploadip_list.has())
      {
        paramRspBody = paramList;
        if (localApplyUploadRsp.rpt_str_uploadip_list.get().size() > 0) {
          paramRspBody = localApplyUploadRsp.rpt_str_uploadip_list.get();
        }
      }
      if (localApplyUploadRsp.str_upload_dns.has()) {
        paramathx.jdField_d_of_type_JavaLangString = localApplyUploadRsp.str_upload_dns.get();
      }
      return paramRspBody;
      if (localApplyUploadRsp.str_upload_domain.has()) {
        paramathx.jdField_b_of_type_JavaLangString = localApplyUploadRsp.str_upload_domain.get();
      } else {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse has neither ip nor domain");
      }
    }
  }
  
  private void a(long paramLong, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramLong != -5L) && (paramLong != -6L)) {}
    MessageHandler localMessageHandler;
    do
    {
      return;
      localMessageHandler = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER);
    } while (localMessageHandler == null);
    localMessageHandler.a(3008, false, new Object[] { paramFileManagerEntity.peerUin, Integer.valueOf(3000), Integer.valueOf(103) });
  }
  
  private void a(long paramLong, boolean paramBoolean, int paramInt, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    switch (paramFileManagerEntity.nOpType)
    {
    default: 
      return;
    case 7: 
    case 28: 
      c(paramLong, paramBoolean, paramInt, paramString1, paramString2, paramFileManagerEntity);
      return;
    case 4: 
      b(paramLong, paramBoolean, paramInt, paramString1, paramString2, paramFileManagerEntity);
      return;
    case 26: 
    case 27: 
    case 32: 
      try
      {
        ((auez)paramFileManagerEntity.mContext).a(paramBoolean, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, paramInt, paramString1, String.valueOf(paramFileManagerEntity.peerUin), paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: Exception is " + paramString1.toString());
        return;
      }
    }
    try
    {
      ((auez)paramFileManagerEntity.mContext).a(paramBoolean, paramFileManagerEntity.datalineEntitySessionId, paramInt, paramString1, null, null, paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: Exception is " + paramString1.toString());
    }
  }
  
  private void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2, long paramLong3, long paramLong4, String paramString6, bcse parambcse, int paramInt3, hummer_resv_21.FileImgInfo paramFileImgInfo, byte[] paramArrayOfByte, String paramString7, hummer_resv_21.FileApkInfo paramFileApkInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "internalHandleOffLineFileMsg friendUin[" + String.valueOf(paramString1) + "],senderuin[" + String.valueOf(paramString2) + "],time[" + String.valueOf(paramLong1) + "],seq[" + String.valueOf(paramShort) + "],isRead[" + String.valueOf(paramBoolean1) + "],isPullRoam[" + String.valueOf(paramBoolean2) + "],type[" + String.valueOf(paramInt1) + "],uuid[" + String.valueOf(paramString3) + "],fileIdCrc[" + paramString4 + "],type[" + String.valueOf(paramInt1) + "],strFileName[" + String.valueOf(paramString5) + "],dwFileSize[" + String.valueOf(paramLong2) + "],reserve[" + String.valueOf(paramInt2) + "],vipBubbleID[" + String.valueOf(paramLong3) + "],vipBubbleDiyTextID[" + String.valueOf(paramInt3) + "]");
    }
    FileManagerEntity localFileManagerEntity = a(paramMessageHandler, paramString1, paramString2, paramLong1, paramShort, paramBoolean1, paramBoolean2, paramInt1, paramString3, paramString4, paramString5, paramLong2, paramInt2, paramLong3, paramLong4);
    if (localFileManagerEntity == null) {
      QLog.w("FileTransferHandler<FileAssistant>", 1, "entry is null,may be is onlinefile!");
    }
    do
    {
      return;
      if (TextUtils.isEmpty(paramString5))
      {
        QLog.w("FileTransferHandler<FileAssistant>", 1, "internalHandleOffLineFileMsg.  no file name . return!!!!");
        return;
      }
    } while (a(paramList, paramString1, paramString2, paramShort, paramBoolean1, paramBoolean2, paramString3, paramString5, paramInt2, paramLong4));
    String str = TransfileUtile.makeTransFileProtocolData(BuddyTransfileProcessor.getTransferFilePath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString5, 0, null), paramLong2, 0, false, null);
    int i;
    if (parambcse != null)
    {
      i = 1;
      if (parambcse.jdField_a_of_type_Int == -1)
      {
        i = 0;
        paramMessageHandler = paramString2;
        if (i == 0) {
          break label1205;
        }
        i = parambcse.jdField_a_of_type_Int;
      }
    }
    for (;;)
    {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.fileName = paramString5;
      localFileManagerEntity.fileSize = paramLong2;
      localFileManagerEntity.peerNick = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, null, 0);
      localFileManagerEntity.peerType = i;
      localFileManagerEntity.peerUin = paramString1;
      localFileManagerEntity.srvTime = (1000L * paramLong1);
      localFileManagerEntity.status = -1;
      localFileManagerEntity.Uuid = paramString3;
      localFileManagerEntity.fileIdCrc = paramString4;
      localFileManagerEntity.isReaded = paramBoolean1;
      localFileManagerEntity.bSend = false;
      localFileManagerEntity.msgSeq = paramShort;
      localFileManagerEntity.msgUid = paramLong4;
      localFileManagerEntity.strFileMd5 = paramString6;
      localFileManagerEntity.nFileType = auea.a(paramString5);
      a(paramString1, paramMessageHandler, paramString3, parambcse, paramArrayOfByte, paramString7, localFileManagerEntity);
      if (paramFileImgInfo != null)
      {
        localFileManagerEntity.imgWidth = paramFileImgInfo.uint32_file_width.get();
        localFileManagerEntity.imgHeight = paramFileImgInfo.uint32_file_height.get();
      }
      a(paramFileApkInfo, localFileManagerEntity);
      QLog.i("FileTransferHandler<FileAssistant>", 1, "=_=k recv OfflineFile Id[" + localFileManagerEntity.nSessionId + "],File[" + localFileManagerEntity.fileName + "], Md5[" + localFileManagerEntity.strFileMd5 + "]");
      auea.a(paramString5);
      if (TextUtils.isEmpty(localFileManagerEntity.Uuid))
      {
        localFileManagerEntity.nWeiYunSrcType = -2;
        paramString4 = "friendUin:" + String.valueOf(paramString1) + "senderuin:" + String.valueOf(paramMessageHandler) + "time:" + String.valueOf(paramLong1) + "seq:" + String.valueOf(paramShort) + "isRead:" + String.valueOf(paramBoolean1) + "isPullRoam:" + String.valueOf(paramBoolean2) + "type:" + String.valueOf(paramInt1) + "uuid:" + String.valueOf(paramString3) + "strFileName:" + String.valueOf(paramString5) + "dwFileSize:" + String.valueOf(paramLong2) + "reserve:" + String.valueOf(paramInt2) + "vipBubbleID:" + String.valueOf(paramLong3) + "vipBubbleDiyTextID:" + String.valueOf(paramInt3);
        auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.nSessionId, "actFileDownDetail", 0L, "", localFileManagerEntity.selfUin, localFileManagerEntity.Uuid, localFileManagerEntity.strFileMd5, 9081L, paramString4, 0L, 0L, paramLong2, "", "", 0, "uuid null", null);
      }
      auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
      auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageHandler, "", localFileManagerEntity);
      if (paramString2.equals(paramMessageHandler))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramString1, 0, localFileManagerEntity.uniseq);
        localFileManagerEntity.nOpType = 0;
        localFileManagerEntity.status = 1;
        localFileManagerEntity.bSend = true;
        localFileManagerEntity.isReaded = true;
        localFileManagerEntity.bDelInFM = false;
        localFileManagerEntity.bOnceSuccess = true;
      }
      localFileManagerEntity.bDelInFM = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      auea.a(localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
      if (QLog.isDevelopLevel()) {
        QLog.w("FileTransferHandler<FileAssistant>", 2, "offline file come:fileName[" + paramString5 + "],uuid[" + paramString3 + "] insert To AIO");
      }
      a(paramList, paramString1, paramMessageHandler, paramString5, paramLong2, paramBoolean1, i, str, paramShort, paramShort, paramString3, paramInt1, localFileManagerEntity.uniseq, paramLong4, paramLong3, paramLong1, -2005, paramInt3, paramFileImgInfo);
      if (QLog.isColorLevel()) {
        QLog.i("FileTransferHandler<FileAssistant>", 2, "File Coming:" + auea.a(localFileManagerEntity));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, paramString1, i, 17, null, 0, null);
      return;
      paramMessageHandler = a(paramString2, parambcse);
      break;
      label1205:
      i = 0;
      continue;
      i = 0;
      paramMessageHandler = paramString2;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    localUniPacket.setRequestId(i);
    this.jdField_a_of_type_Bcrs.a(paramToServiceMsg, localUniPacket);
    paramToServiceMsg.putWupBuffer(localUniPacket.encode());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, bcrp parambcrp)
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "check handleGetOffLineFileResp is not used!");
  }
  
  private void a(String paramString1, String paramString2, String paramString3, bcse parambcse, byte[] paramArrayOfByte, String paramString4, FileManagerEntity paramFileManagerEntity)
  {
    if (atpk.a(paramString3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "tencentdoc use new type");
      }
      paramFileManagerEntity.nFileType = 13;
      paramFileManagerEntity.bombData = paramArrayOfByte;
      paramFileManagerEntity.strThumbPath = paramString4;
      paramFileManagerEntity.nOpType = 0;
      if (paramString2.equals(paramString1)) {
        paramFileManagerEntity.nOpType = 1;
      }
      if (parambcse != null)
      {
        if (parambcse.jdField_a_of_type_Int != -1) {
          paramFileManagerEntity.peerType = 1;
        }
        paramFileManagerEntity.TroopUin = parambcse.jdField_b_of_type_Long;
      }
      paramFileManagerEntity.bDelInFM = false;
    }
  }
  
  private void a(List<MessageRecord> paramList, String paramString1, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, int paramInt1, hummer_resv_21.FileImgInfo paramFileImgInfo, long paramLong2, long paramLong3, short paramShort, String paramString2, int paramInt2, long paramLong4, String paramString3, String paramString4)
  {
    if ((paramBoolean1) || (paramString3.equalsIgnoreCase(paramString4)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "Recv a file receipt file name: " + paramString2 + "don't need to handle because isPullRoam[" + paramBoolean2 + "],senderuin[" + paramString3 + "]");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "Recv a file receipt file name: " + paramString2 + "type[" + paramInt2 + "]. insert tips into aio");
    }
    paramString4 = TransfileUtile.makeTransFileProtocolData(BuddyTransfileProcessor.getTransferFilePath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString2, 0, null), paramLong4, 0, false, null);
    long l = bcsa.a(-2005).uniseq;
    a(paramList, paramString1, paramString3, paramString2, paramLong4, paramBoolean1, 0, paramString4, paramShort, paramShort, "", paramInt2, l, paramLong2, paramLong1, paramLong3, -3008, paramInt1, paramFileImgInfo);
  }
  
  private void a(hummer_resv_21.FileApkInfo paramFileApkInfo, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileApkInfo != null) && (paramFileApkInfo.str_package_name.has()))
    {
      paramFileManagerEntity.yybApkPackageName = paramFileApkInfo.str_package_name.get();
      paramFileManagerEntity.yybApkName = paramFileApkInfo.str_app_name.get();
      paramFileManagerEntity.yybApkIconUrl = paramFileApkInfo.str_icon_url.get();
    }
  }
  
  private void a(boolean paramBoolean, FileManagerEntity paramFileManagerEntity, String paramString1, int paramInt, String paramString2, long paramLong)
  {
    if (paramBoolean)
    {
      paramFileManagerEntity.status = 1;
      switch (paramFileManagerEntity.nOpType)
      {
      default: 
        if (QLog.isDevelopLevel()) {
          throw new NullPointerException(anvx.a(2131704049));
        }
        break;
      case 21: 
        paramFileManagerEntity.Uuid = paramString1;
        paramFileManagerEntity.peerType = 0;
        paramFileManagerEntity.setCloudType(1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(paramBoolean, 19, new Object[] { Integer.valueOf(paramInt), paramString2, Long.valueOf(0L), Long.valueOf(0L), paramString1, Long.valueOf(paramLong) });
        a(paramFileManagerEntity.peerUin, paramFileManagerEntity, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(paramFileManagerEntity, 6, null);
      }
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          localObject = a(paramString1);
          if (localObject != null) {
            paramFileManagerEntity.WeiYunDirKey = ((String)((Pair)localObject).first);
          }
          for (paramFileManagerEntity.WeiYunFileId = ((String)((Pair)localObject).second);; paramFileManagerEntity.WeiYunFileId = paramString1)
          {
            paramFileManagerEntity.setCloudType(2);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(paramBoolean, 34, new Object[] { Integer.valueOf(paramInt), paramString2, paramString1, Long.valueOf(paramLong) });
            return;
          }
        } while (!(paramFileManagerEntity.mContext instanceof auez));
        agfe.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.uniseq);
        ((auez)paramFileManagerEntity.mContext).a(paramBoolean, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, paramInt, paramString2, String.valueOf(paramFileManagerEntity.peerUin), paramString1);
        return;
        switch (paramFileManagerEntity.nOpType)
        {
        }
      } while (!QLog.isDevelopLevel());
      throw new NullPointerException(anvx.a(2131704050));
      if ((paramInt == -6101) || (paramInt == -7003))
      {
        paramFileManagerEntity.status = 16;
        if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
        {
          localObject = (FileManagerEntity)paramFileManagerEntity.mContext;
          ((FileManagerEntity)localObject).status = 16;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c((FileManagerEntity)localObject);
          paramFileManagerEntity.mContext = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramFileManagerEntity);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(paramBoolean, 19, new Object[] { Integer.valueOf(paramInt), paramString2, Long.valueOf(0L), Long.valueOf(0L), paramString1, Long.valueOf(paramLong) });
      return;
      if ((paramInt == -6101) || (paramInt == -7003))
      {
        paramFileManagerEntity.status = 16;
        if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
        {
          localObject = (FileManagerEntity)paramFileManagerEntity.mContext;
          ((FileManagerEntity)localObject).status = 16;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c((FileManagerEntity)localObject);
          paramFileManagerEntity.mContext = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramFileManagerEntity);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(paramBoolean, 34, new Object[] { Integer.valueOf(paramInt), paramString2, paramString1, Long.valueOf(paramLong) });
      return;
      if ((paramInt == -6101) || (paramInt == -7003))
      {
        paramFileManagerEntity.status = 16;
        if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
        {
          localObject = (FileManagerEntity)paramFileManagerEntity.mContext;
          ((FileManagerEntity)localObject).status = 16;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c((FileManagerEntity)localObject);
          paramFileManagerEntity.mContext = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramFileManagerEntity);
      }
    } while (!(paramFileManagerEntity.mContext instanceof auez));
    ((auez)paramFileManagerEntity.mContext).a(paramBoolean, paramFileManagerEntity.strTroopFileUuid, paramFileManagerEntity.nSessionId, paramInt, paramString2, String.valueOf(paramFileManagerEntity.peerUin), paramString1);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 1002) || (paramInt == 1013);
  }
  
  private boolean a(int paramInt, msg_comm.Msg paramMsg)
  {
    if (!paramMsg.msg_head.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMessagePackage: msgList[" + paramInt + "] : msg doesn't has msgHead.");
      }
      return true;
    }
    return false;
  }
  
  private boolean a(long paramLong, boolean paramBoolean, List<MessageRecord> paramList, int paramInt, msg_comm.Msg paramMsg, msg_comm.MsgHead paramMsgHead)
  {
    if (a(paramInt, paramMsg)) {
      return true;
    }
    paramInt = (short)paramMsgHead.msg_seq.get();
    long l1 = paramMsgHead.from_uin.get();
    long l2 = paramMsgHead.msg_time.get();
    long l3 = paramMsgHead.msg_uid.get();
    int i = paramMsgHead.msg_type.get();
    int j = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
    if (((!bcsc.c(i)) || (!paramMsgHead.c2c_cmd.has()) || (j != 169)) && ((i != 529) || (j != 4))) {
      return false;
    }
    paramMsg = new athz(this, paramMsg, paramMsgHead, i, j).a();
    if (paramMsg.a()) {
      return true;
    }
    paramMsg = paramMsg.a();
    if (a(paramMsg)) {
      return true;
    }
    i = paramMsg.uint32_file_type.get();
    paramMsg.uint64_file_size.get();
    paramMsg.uint32_subcmd.get();
    if (a(paramBoolean, i)) {
      return true;
    }
    paramMsgHead = a(0, String.valueOf(paramLong), String.valueOf(l1), l2, paramInt, l3);
    if (paramMsgHead != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
      }
      paramList.add(paramMsgHead);
      return true;
    }
    i = a(l1, paramMsg, 0);
    return a(String.valueOf(paramLong), paramMsg.bytes_file_uuid.get().toStringUtf8(), i, paramInt, l3, paramList, String.valueOf(l1));
  }
  
  private boolean a(MessageHandler paramMessageHandler, boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if ((paramMessageHandler.a().a(paramString2)) && (!paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "isPullRoam[false] and local already recv.  fileName[" + paramString1 + "] uuid[" + paramString3 + "] fileType[" + paramInt1 + "] subCmd[" + paramInt2 + "]");
      }
      if (QLog.isDevelopLevel()) {
        QLog.w("FileTransferHandler<FileAssistant>", 2, "offline file come:fileName[" + paramString1 + "] Filtered");
      }
      return true;
    }
    return false;
  }
  
  private boolean a(ProtoReqManager.ProtoResp paramProtoResp)
  {
    return (paramProtoResp.resp.getResultCode() == 1002) || (paramProtoResp.resp.getResultCode() == 1013);
  }
  
  private boolean a(ProtoReqManager.ProtoResp paramProtoResp, athx paramathx)
  {
    if (a(paramProtoResp))
    {
      paramathx.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      return true;
    }
    if (paramProtoResp.resp.getResultCode() != 1000)
    {
      paramathx.jdField_a_of_type_Int = -100002;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().b().iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.replace("/offline", "").equalsIgnoreCase(paramString.replace("/offline", ""))))
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "uuid is compare memory!");
        return true;
      }
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, List<MessageRecord> paramList, String paramString3)
  {
    if (paramLong1 != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(String.valueOf(paramString1), paramLong1);
      if (localObject != null)
      {
        if (!((FileManagerEntity)localObject).bDelInAio)
        {
          paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(String.valueOf(paramString1), ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).uniseq);
          if (paramString1 != null) {
            paramList.add(paramString1);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "ol2offline duplicate msg, entity info" + auea.a((FileManagerEntity)localObject));
        }
        return true;
      }
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "msgFilterByFMDB,friendUin[" + auea.e(paramString1) + "],uuid[" + paramString2 + "],olSessionId[" + paramLong1 + "],msgSeq[" + paramLong2 + "],msgUid[" + paramLong3 + "],senderuin[" + auea.e(paramString3) + "]");
    Object localObject = paramString2.replace("/offline", "");
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().c();
    int i = 0;
    if (i < localList.size())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localList.get(i);
      paramString2 = "";
      String str = ((String)localObject).replace("/offline", "");
      if (localFileManagerEntity.Uuid != null) {
        paramString2 = localFileManagerEntity.Uuid.replace("/offline", "");
      }
      switch (localFileManagerEntity.nOpType)
      {
      }
      label628:
      do
      {
        do
        {
          do
          {
            if (QLog.isColorLevel()) {
              QLog.w("FileTransferHandler<FileAssistant>", 1, "Entity [" + auea.a(localFileManagerEntity) + "]");
            }
            i += 1;
            break;
            if ((paramLong2 != localFileManagerEntity.msgSeq) || (paramLong3 != localFileManagerEntity.msgUid)) {
              break label628;
            }
            paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(paramString1, localFileManagerEntity.peerType, localFileManagerEntity.uniseq);
            if (paramString2 != null)
            {
              paramList.add(paramString2);
              if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "msgSeq and msguid are all equal, duplicate msg, entity info" + auea.a(localFileManagerEntity));
              }
              return true;
            }
            paramString2 = new ArrayList();
            a(paramString2, paramString1, paramString3, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.isReaded, 0, null, paramLong2, paramLong2, (String)localObject, 0, localFileManagerEntity.uniseq, paramLong3, -1L, localFileManagerEntity.srvTime / 1000L, -2005, 0, null);
          } while (paramString2.size() <= 0);
          paramList.add((MessageRecord)paramString2.get(0));
          if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "msgSeq and msguid are all equal, duplicate msg, entity info" + auea.a(localFileManagerEntity));
          }
          return true;
        } while (!paramString2.equalsIgnoreCase(str));
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(paramString1, localFileManagerEntity.peerType, localFileManagerEntity.uniseq);
        if (paramString2 != null)
        {
          paramList.add(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("FileTransferHandler<FileAssistant>", 2, "duplicate msg, entity info" + auea.a(localFileManagerEntity));
          }
          return true;
        }
        paramString2 = new ArrayList();
        a(paramString2, paramString1, paramString3, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.isReaded, 0, null, paramLong2, paramLong2, (String)localObject, 0, localFileManagerEntity.uniseq, paramLong3, -1L, localFileManagerEntity.srvTime / 1000L, -2005, 0, null);
      } while (paramString2.size() <= 0);
      paramList.add((MessageRecord)paramString2.get(0));
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "Uuid are all equal, duplicate msg, entity info" + auea.a(localFileManagerEntity));
      }
      return true;
    }
    return false;
  }
  
  private boolean a(List<MessageRecord> paramList, String paramString1, String paramString2, short paramShort, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, int paramInt, long paramLong)
  {
    if ((paramBoolean2) || (paramBoolean1))
    {
      ArrayList localArrayList = new ArrayList();
      if (a(paramString1, paramString3, paramInt, paramShort, paramLong, localArrayList, paramString2))
      {
        if (localArrayList.size() > 0)
        {
          paramString3 = (MessageRecord)localArrayList.get(0);
          paramList.add(localArrayList.get(0));
          auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, paramString3.istroop);
          if (this.jdField_a_of_type_Bedr == null) {
            this.jdField_a_of_type_Bedr = ((bedr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER));
          }
          if ((paramString3 instanceof MessageForFile))
          {
            ((MessageForFile)paramString3).fileName = paramString4;
            this.jdField_a_of_type_Bedr.a((MessageForFile)paramString3);
          }
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean a(List<MessageRecord> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, long paramLong3, short paramShort)
  {
    if ((paramBoolean2) && (paramBoolean1))
    {
      paramString = a(0, paramString, String.valueOf(paramLong3), paramLong2, paramShort, paramLong1);
      if (paramString != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
        }
        MessageRecord localMessageRecord = bcsa.a(-2005);
        localMessageRecord.msgtype = -2005;
        localMessageRecord.msg = paramString.msg;
        ((MessageForFile)localMessageRecord).parse();
        localMessageRecord.uniseq = paramString.uniseq;
        paramList.add(localMessageRecord);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(im_msg_body.NotOnlineFile paramNotOnlineFile)
  {
    if (!paramNotOnlineFile.bytes_file_name.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_MsgType0x211 : NotOnlineFIle has not fileName");
      }
      return true;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean, int paramInt)
  {
    return (paramBoolean) && (paramInt == 1);
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    return ((paramBoolean4) && (paramBoolean2)) || (((paramBoolean3) || (paramBoolean1)) && (paramInt < 3));
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, im_msg_body.GroupFile paramGroupFile, int paramInt1, int paramInt2)
  {
    if (paramGroupFile == null)
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "disc file is coming but file info is null!");
      return -1L;
    }
    Object localObject1 = null;
    String str1 = String.valueOf(paramLong2);
    String str2 = String.valueOf(paramLong3);
    if (paramGroupFile.bytes_filename.has()) {}
    for (;;)
    {
      long l;
      try
      {
        localObject2 = new String(paramGroupFile.bytes_filename.get().toByteArray(), "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        Object localObject2;
        localUnsupportedEncodingException1.printStackTrace();
        QLog.e("FileTransferHandler<FileAssistant>", 1, "internalDiscOfflineFile: Exception is " + localUnsupportedEncodingException1.toString());
        continue;
        paramGroupFile = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(paramLong1, str1, 3000);
        localFileManagerEntity.setCloudType(1);
        localFileManagerEntity.fileName = ((String)localObject1);
        localFileManagerEntity.fileSize = l;
        localFileManagerEntity.nOpType = 1;
        localFileManagerEntity.peerNick = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, str2, 3000);
        localFileManagerEntity.peerType = 3000;
        localFileManagerEntity.peerUin = str1;
        localFileManagerEntity.selfUin = str2;
        localFileManagerEntity.srvTime = (1000L * paramLong6);
        localFileManagerEntity.status = -1;
        if (localUnsupportedEncodingException1 != null) {
          localFileManagerEntity.Uuid = new String(localUnsupportedEncodingException1);
        }
        localFileManagerEntity.isReaded = false;
        localFileManagerEntity.bSend = false;
        localFileManagerEntity.msgSeq = paramLong4;
        localFileManagerEntity.msgUid = 0L;
        localFileManagerEntity.imgHeight = paramInt2;
        localFileManagerEntity.imgWidth = paramInt1;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "=_=k recv DiscFile Id[" + localFileManagerEntity.nSessionId + "],File[" + (String)localObject1 + "]");
        auea.a((String)localObject1);
        if ((localFileManagerEntity.Uuid == null) || (localFileManagerEntity.Uuid.length() == 0)) {
          localFileManagerEntity.nWeiYunSrcType = -2;
        }
        auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
        if (paramGroupFile.equals(String.valueOf(paramLong3)))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(str2, 3000, paramLong1);
          localFileManagerEntity.nOpType = 7;
          localFileManagerEntity.peerNick = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131692456);
          localFileManagerEntity.bSend = true;
          localFileManagerEntity.isReaded = true;
          localFileManagerEntity.bOnceSuccess = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
        auea.a(localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
        if (QLog.isColorLevel()) {
          QLog.i("FileTransferHandler<FileAssistant>", 2, "File Coming:" + auea.a(localFileManagerEntity));
        }
        auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), str1, 3000);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(paramLong1, localFileManagerEntity.nSessionId, str1, 3000, 17, null, 0, null);
        return paramLong1;
      }
      try
      {
        localObject1 = auea.a((String)localObject2);
        if (!paramGroupFile.uint64_file_size.has()) {
          break label728;
        }
        l = paramGroupFile.uint64_file_size.get();
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        localObject1 = localUnsupportedEncodingException1;
        Object localObject3 = localUnsupportedEncodingException2;
        continue;
        localObject3 = null;
        continue;
        label728:
        l = 0L;
        continue;
      }
      if (paramGroupFile.bytes_file_id.has())
      {
        localObject2 = paramGroupFile.bytes_file_id.get().toByteArray();
        if (paramGroupFile.bytes_batch_id.has()) {
          paramGroupFile.bytes_batch_id.get().toByteArray();
        }
        if (paramGroupFile.bytes_mark.has()) {
          paramGroupFile.bytes_mark.get().toByteArray();
        }
        paramLong5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(3000, paramLong4, paramLong6, paramLong2, paramLong5);
        if (paramLong5 > 0L)
        {
          paramGroupFile = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong5, String.valueOf(paramLong2), 3000);
          if (paramGroupFile != null)
          {
            paramGroupFile.status = 1;
            paramGroupFile.fProgress = 1.0F;
          }
          return paramLong5;
        }
      }
      localObject1 = null;
    }
  }
  
  private aucr b(aucv paramaucv)
  {
    aucr localaucr = new aucr();
    localaucr.jdField_a_of_type_Auco = new auco();
    paramaucv.jdField_a_of_type_JavaLangString = paramaucv.jdField_a_of_type_JavaLangString.replace("+", "");
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localaucr.jdField_a_of_type_Auco.jdField_a_of_type_Long = l;
    localaucr.jdField_a_of_type_Auco.jdField_b_of_type_Long = Long.parseLong(paramaucv.jdField_a_of_type_JavaLangString);
    localaucr.jdField_a_of_type_Auco.jdField_c_of_type_Long = paramaucv.jdField_a_of_type_Long;
    localaucr.jdField_a_of_type_Auco.jdField_a_of_type_JavaLangString = new String(paramaucv.jdField_b_of_type_ArrayOfByte);
    localaucr.jdField_a_of_type_Auco.jdField_b_of_type_JavaLangString = new String(paramaucv.jdField_a_of_type_ArrayOfByte);
    localaucr.jdField_a_of_type_Auco.jdField_a_of_type_ArrayOfByte = paramaucv.jdField_c_of_type_ArrayOfByte;
    localaucr.jdField_a_of_type_Auco.jdField_c_of_type_ArrayOfByte = paramaucv.jdField_e_of_type_ArrayOfByte;
    localaucr.jdField_a_of_type_Auco.jdField_b_of_type_ArrayOfByte = paramaucv.f;
    return localaucr;
  }
  
  private void b(long paramLong, boolean paramBoolean, int paramInt, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    if (((paramString2 == null) || (paramString2.length() < 1)) && (QLog.isColorLevel())) {
      QLog.w("FileTransferHandler<FileAssistant>", 2, "forward offline to weiyun ,but weiyun fileid is null! retCode[" + String.valueOf(paramInt) + "retMsg[" + String.valueOf(paramString1) + "]");
    }
    Object localObject;
    if (paramBoolean)
    {
      paramFileManagerEntity.status = 1;
      paramFileManagerEntity.setCloudType(2);
      if ((paramInt == -6101) || (paramInt == -7003))
      {
        paramFileManagerEntity.status = 16;
        if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
        {
          localObject = (FileManagerEntity)paramFileManagerEntity.mContext;
          ((FileManagerEntity)localObject).status = 16;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c((FileManagerEntity)localObject);
          paramFileManagerEntity.mContext = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramFileManagerEntity);
      }
      localObject = a(paramString2);
      if (localObject == null) {
        break label277;
      }
      paramFileManagerEntity.WeiYunDirKey = ((String)((Pair)localObject).first);
    }
    label277:
    for (paramFileManagerEntity.WeiYunFileId = ((String)((Pair)localObject).second);; paramFileManagerEntity.WeiYunFileId = paramString2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(paramBoolean, 34, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Long.valueOf(paramLong) });
      return;
      paramFileManagerEntity.status = 0;
      break;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg)
  {
    a(paramToServiceMsg);
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), atic.class);
    localNewIntent.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    long l = System.currentTimeMillis();
    paramToServiceMsg.extraData.putLong("sendtimekey", l);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleReqOffFilePackError, count: " + i);
    }
    if (i < 3)
    {
      paramToServiceMsg.extraData.putInt("retryIndex", i + 1);
      b(paramToServiceMsg);
      return;
    }
    anza localanza = new anza();
    localanza.jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
    localanza.jdField_c_of_type_Int = i;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      localanza.jdField_b_of_type_Int = 2900;
      localanza.jdField_a_of_type_Long = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 2139062142L);
    }
    localanza.jdField_a_of_type_JavaLangString = MessageHandler.a(paramFromServiceMsg);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
    switch (paramToServiceMsg.extraData.getInt("offfile_type"))
    {
    case 0: 
    default: 
      return;
    case 1: 
      a(paramToServiceMsg, 5003, false, new Object[] { paramFromServiceMsg, localanza });
      return;
    case 2: 
      a(paramToServiceMsg, 5005, false, new Object[] { paramFromServiceMsg, localanza });
      return;
    }
    a(paramToServiceMsg, 5004, false, new Object[] { paramFromServiceMsg, localanza });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, bcrp parambcrp)
  {
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    anza localanza = new anza();
    localanza.jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
    localanza.jdField_c_of_type_Int = i;
    a(paramToServiceMsg, 5003, true, new Object[] { parambcrp.jdField_a_of_type_ArrayOfByte, localanza });
  }
  
  private void c(long paramLong, boolean paramBoolean, int paramInt, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    if ((TextUtils.isEmpty(paramString2)) && (QLog.isColorLevel())) {
      QLog.w("FileTransferHandler<FileAssistant>", 2, "forward offline to weiyun ,but weiyun fileid is null! retCode[" + String.valueOf(paramInt) + "retMsg[" + String.valueOf(paramString1) + "]");
    }
    if (paramBoolean) {}
    for (paramFileManagerEntity.status = 1;; paramFileManagerEntity.status = 0)
    {
      if (paramBoolean)
      {
        paramFileManagerEntity.Uuid = paramString2;
        paramFileManagerEntity.setCloudType(1);
        paramFileManagerEntity.peerType = 3000;
        a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramString2, paramFileManagerEntity.uniseq, paramFileManagerEntity.msgUid, null);
      }
      if ((paramInt == -6101) || (paramInt == -7003))
      {
        paramFileManagerEntity.status = 16;
        if ((paramFileManagerEntity.mContext != null) && ((paramFileManagerEntity.mContext instanceof FileManagerEntity)))
        {
          FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramFileManagerEntity.mContext;
          localFileManagerEntity.status = 16;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
          paramFileManagerEntity.mContext = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramFileManagerEntity);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(paramBoolean, 19, new Object[] { Integer.valueOf(paramInt), paramString1, Long.valueOf(0L), Long.valueOf(0L), paramString2, Long.valueOf(paramLong) });
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, bcrp parambcrp)
  {
    if ((parambcrp == null) || (parambcrp.jdField_a_of_type_Long != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSendOfflineFileResp-->handleError");
      }
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSendOfflineFileResp-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    anza localanza = new anza();
    localanza.jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
    localanza.jdField_c_of_type_Int = i;
    localanza.jdField_a_of_type_Int = paramFromServiceMsg.getAppSeq();
    a(paramToServiceMsg, 5004, true, new Object[] { parambcrp, localanza });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, bcrp parambcrp)
  {
    if ((parambcrp == null) || (parambcrp.jdField_a_of_type_Long != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSetOfflineFileState-->handleError");
      }
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "handleSetOfflineFileState-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
    }
    int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    anza localanza = new anza();
    localanza.jdField_b_of_type_Int = paramFromServiceMsg.getResultCode();
    localanza.jdField_c_of_type_Int = i;
    a(paramToServiceMsg, 5005, true, new Object[] { parambcrp, localanza });
  }
  
  private void h(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    ArrayList localArrayList = new ArrayList();
    if (a(paramProtoResp)) {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
    }
    Object localObject;
    for (;;)
    {
      a(((atia)paramProtoReq.busiData).a(), 5021, bool2, new Object[] { Boolean.valueOf(bool1), localArrayList });
      return;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject).mergeFrom(paramProtoResp);
          if (((cmd0x346.RspBody)localObject).msg_recv_list_query_rsp.has()) {
            break label207;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: rspBody has not msg_recv_list_query_rsp");
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
        }
        continue;
        label207:
        paramProtoResp = (cmd0x346.RecvListQueryRsp)((cmd0x346.RspBody)localObject).msg_recv_list_query_rsp.get();
        if (!paramProtoResp.int32_ret_code.has()) {
          break;
        }
        int i = paramProtoResp.int32_ret_code.get();
        if (i == 0) {
          break;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: failed retCode[" + i + "]");
      }
    }
    if (((cmd0x346.RspBody)localObject).uint32_flag_use_media_platform.has()) {
      if (((cmd0x346.RspBody)localObject).uint32_flag_use_media_platform.get() == 1)
      {
        bool1 = true;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: bUseMediaPlatform " + bool1);
      }
    }
    for (;;)
    {
      localObject = paramProtoResp.rpt_msg_file_list.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        cmd0x346.FileInfo localFileInfo = (cmd0x346.FileInfo)((Iterator)localObject).next();
        OfflineFileInfo localOfflineFileInfo = new OfflineFileInfo();
        localOfflineFileInfo.jdField_a_of_type_Boolean = false;
        localOfflineFileInfo.jdField_a_of_type_Int = localFileInfo.uint32_danger_evel.get();
        localOfflineFileInfo.jdField_b_of_type_Long = localFileInfo.uint64_file_size.get();
        localOfflineFileInfo.jdField_c_of_type_Long = (bcrg.a() * 1000L + localFileInfo.uint32_life_time.get() * 1000L);
        localOfflineFileInfo.jdField_d_of_type_Long = (localFileInfo.uint32_upload_time.get() * 1000L);
        localOfflineFileInfo.jdField_c_of_type_JavaLangString = localFileInfo.str_file_name.get();
        localOfflineFileInfo.jdField_a_of_type_JavaLangString = new String(localFileInfo.bytes_uuid.get().toByteArray());
        if (bool1) {
          localOfflineFileInfo.jdField_b_of_type_JavaLangString = localFileInfo.str_fileidcrc.get();
        }
        localOfflineFileInfo.jdField_a_of_type_Long = localFileInfo.uint64_uin.get();
        localOfflineFileInfo.jdField_d_of_type_JavaLangString = HexUtil.bytes2HexStr(localFileInfo.bytes_md5.get().toByteArray());
        localArrayList.add(localOfflineFileInfo);
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "handleQueryRecvListResponse OfflineFileInfo[" + localOfflineFileInfo.toString() + "]");
        }
      }
      bool1 = false;
      break;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQueryRecvListResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
      bool1 = false;
    }
    if (paramProtoResp.uint32_is_end.get() > 0) {}
    for (bool1 = true;; bool1 = false)
    {
      bool2 = true;
      break;
    }
  }
  
  private void i(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    ArrayList localArrayList = new ArrayList();
    if (a(paramProtoResp)) {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
    }
    Object localObject;
    for (;;)
    {
      a(((atia)paramProtoReq.busiData).a(), 5022, bool2, new Object[] { Boolean.valueOf(bool1), localArrayList });
      return;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject).mergeFrom(paramProtoResp);
          if (((cmd0x346.RspBody)localObject).msg_send_list_query_rsp.has()) {
            break label207;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: rspBody has not msg_send_list_query_rsp");
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
        }
        continue;
        label207:
        paramProtoResp = (cmd0x346.SendListQueryRsp)((cmd0x346.RspBody)localObject).msg_send_list_query_rsp.get();
        if (!paramProtoResp.int32_ret_code.has()) {
          break;
        }
        int i = paramProtoResp.int32_ret_code.get();
        if (i == 0) {
          break;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: failed retCode[" + i + "]");
      }
    }
    if (((cmd0x346.RspBody)localObject).uint32_flag_use_media_platform.has()) {
      if (((cmd0x346.RspBody)localObject).uint32_flag_use_media_platform.get() == 1)
      {
        bool1 = true;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: bUseMediaPlatform " + bool1);
      }
    }
    for (;;)
    {
      localObject = paramProtoResp.rpt_msg_file_list.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        cmd0x346.FileInfo localFileInfo = (cmd0x346.FileInfo)((Iterator)localObject).next();
        OfflineFileInfo localOfflineFileInfo = new OfflineFileInfo();
        localOfflineFileInfo.jdField_a_of_type_Boolean = true;
        localOfflineFileInfo.jdField_a_of_type_Int = localFileInfo.uint32_danger_evel.get();
        localOfflineFileInfo.jdField_b_of_type_Long = localFileInfo.uint64_file_size.get();
        localOfflineFileInfo.jdField_c_of_type_Long = (bcrg.a() * 1000L + localFileInfo.uint32_life_time.get() * 1000L);
        localOfflineFileInfo.jdField_d_of_type_Long = (localFileInfo.uint32_upload_time.get() * 1000L);
        localOfflineFileInfo.jdField_c_of_type_JavaLangString = localFileInfo.str_file_name.get();
        localOfflineFileInfo.jdField_a_of_type_JavaLangString = new String(localFileInfo.bytes_uuid.get().toByteArray());
        if (bool1) {
          localOfflineFileInfo.jdField_b_of_type_JavaLangString = localFileInfo.str_fileidcrc.get();
        }
        localOfflineFileInfo.jdField_a_of_type_Long = localFileInfo.uint64_uin.get();
        localOfflineFileInfo.jdField_d_of_type_JavaLangString = HexUtil.bytes2HexStr(localFileInfo.bytes_md5.get().toByteArray());
        localArrayList.add(localOfflineFileInfo);
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "handleQuerySendListResponse OfflineFileInfo[" + localOfflineFileInfo.toString() + "]");
        }
      }
      bool1 = false;
      break;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleQuerySendListResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
      bool1 = false;
    }
    if (paramProtoResp.uint32_is_end.get() > 0) {}
    for (bool1 = true;; bool1 = false)
    {
      bool2 = true;
      break;
    }
  }
  
  private void j(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    athx localathx = new athx(this);
    byte[] arrayOfByte;
    boolean bool1;
    label55:
    boolean bool3;
    label77:
    boolean bool4;
    if (a(paramProtoResp, localathx))
    {
      arrayOfByte = null;
      bool1 = false;
      if ((localathx.jdField_a_of_type_Int != 0) || ((localathx.jdField_b_of_type_JavaLangString != null) && (localathx.jdField_b_of_type_JavaLangString.length() != 0))) {
        break label279;
      }
      bool2 = true;
      if ((localathx.jdField_b_of_type_JavaLangString == null) || (localathx.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label285;
      }
      bool3 = true;
      if ((localathx.jdField_a_of_type_Int != -91245) && (localathx.jdField_a_of_type_Int != -7010)) {
        break label291;
      }
      bool4 = true;
      label102:
      if ((localathx.jdField_a_of_type_ArrayOfByte != null) && (localathx.jdField_a_of_type_ArrayOfByte.length != 0)) {
        break label297;
      }
    }
    Object localObject;
    List localList;
    label263:
    label279:
    label285:
    label291:
    label297:
    for (boolean bool5 = true;; bool5 = false)
    {
      for (;;)
      {
        localObject = (atia)paramProtoReq.busiData;
        if (!a(bool2, bool3, bool4, bool5, ((atia)localObject).b())) {
          break label303;
        }
        ((atia)localObject).a();
        a(paramProtoReq.ssoCmd, paramProtoReq.reqBody, (atia)localObject);
        return;
        arrayOfByte = paramProtoResp.resp.getWupBuffer();
        localathx.jdField_d_of_type_ArrayOfByte = arrayOfByte;
        localObject = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject).mergeFrom(arrayOfByte);
          if (((cmd0x346.RspBody)localObject).msg_apply_upload_rsp.has()) {
            break label263;
          }
          localathx.jdField_a_of_type_Int = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
          arrayOfByte = null;
          bool1 = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localathx.jdField_a_of_type_Int = -100003;
          localList = null;
          bool1 = false;
        }
      }
      break;
      localList = a(localathx, null, (cmd0x346.RspBody)localObject);
      bool1 = true;
      break;
      bool2 = false;
      break label55;
      bool3 = false;
      break label77;
      bool4 = false;
      break label102;
    }
    label303:
    paramProtoReq = new anza();
    paramProtoReq.jdField_b_of_type_Int = localathx.jdField_a_of_type_Int;
    paramProtoReq.jdField_c_of_type_Int = paramProtoResp.freeRunnalbleIndex;
    boolean bool2 = bool1;
    if (bool5)
    {
      bool2 = bool1;
      if (bool3)
      {
        localathx.jdField_a_of_type_JavaLangString = ("uuid_null[" + localathx.toString() + "]");
        bool2 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool2 + ", retCode=" + localathx.jdField_a_of_type_Int + ", retMsg=" + localathx.jdField_a_of_type_JavaLangString + ", totalSpace=" + localathx.jdField_a_of_type_Long + ", usedSpace=" + localathx.jdField_b_of_type_Long + ", ip=" + localathx.jdField_b_of_type_JavaLangString + ", port=" + localathx.jdField_a_of_type_Short);
    }
    a(((atia)localObject).a(), 5004, bool2, new Object[] { localathx, paramProtoReq, localList });
  }
  
  private void k(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    athx localathx = new athx(this);
    boolean bool;
    if (a(paramProtoResp))
    {
      localathx.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      bool = false;
      if (localathx.jdField_a_of_type_Int == 0) {
        break label406;
      }
      bool = false;
    }
    label406:
    for (;;)
    {
      cmd0x346.RspBody localRspBody;
      for (;;)
      {
        Object localObject = new anza();
        ((anza)localObject).jdField_b_of_type_Int = localathx.jdField_a_of_type_Int;
        ((anza)localObject).jdField_c_of_type_Int = paramProtoResp.freeRunnalbleIndex;
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "handleUploadSuccResponse: return " + bool + ", retCode=" + localathx.jdField_a_of_type_Int + ", retMsg=" + localathx.jdField_a_of_type_JavaLangString);
        }
        a(((atia)paramProtoReq.busiData).a(), 5005, bool, new Object[] { localathx, localObject });
        return;
        if (paramProtoResp.resp.getResultCode() != 1000)
        {
          localathx.jdField_a_of_type_Int = -100002;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
          bool = false;
          break;
        }
        localObject = paramProtoResp.resp.getWupBuffer();
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
          if (localRspBody.msg_upload_succ_rsp.has()) {
            break label340;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
          localathx.jdField_a_of_type_Int = -100003;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localathx.jdField_a_of_type_Int = -100003;
          bool = false;
        }
      }
      break;
      label340:
      cmd0x346.UploadSuccRsp localUploadSuccRsp = (cmd0x346.UploadSuccRsp)localRspBody.msg_upload_succ_rsp.get();
      if (localUploadSuccRsp.int32_ret_code.has()) {
        localathx.jdField_a_of_type_Int = localUploadSuccRsp.int32_ret_code.get();
      }
      if (localUploadSuccRsp.str_ret_msg.has()) {
        localathx.jdField_a_of_type_JavaLangString = localUploadSuccRsp.str_ret_msg.get();
      }
      bool = true;
      break;
    }
  }
  
  private void l(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    long l1 = 0L;
    paramProtoReq = new face2face_file.msg();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("QlinkResistTerrorist", 0);
    long l2;
    if (a(paramProtoResp))
    {
      l1 = -100001L;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleResistTerrorist: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      if (l1 != 0L) {}
      paramProtoResp = localSharedPreferences.edit();
      if ((paramProtoReq.has()) && (paramProtoReq.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "handleResistTerrorist: return resMessage.result:" + paramProtoReq.result.get());
        }
        paramProtoResp.putInt("QlinkResistTerrorist_res", paramProtoReq.result.get());
        paramProtoResp.putLong("SettingQlinkResistTerroristLastTime", bcrg.a());
        paramProtoResp.putString("SettingQlinkResistTerroristLastAccount", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      paramProtoResp.commit();
      if (l1 != -100001L) {
        break label346;
      }
      l2 = 9043L;
    }
    for (;;)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "handleResistTerrorist: return " + paramProtoReq.result + " ,retCode:" + l2);
        }
        return;
        if (paramProtoResp.resp.getResultCode() != 1000)
        {
          l1 = -100002L;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleResistTerrorist: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
          break;
        }
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        try
        {
          paramProtoReq.mergeFrom(paramProtoResp);
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          l1 = -100003L;
        }
      }
      break;
      label346:
      l2 = l1;
      if (l1 == -100003L) {
        l2 = 9045L;
      }
    }
  }
  
  private void m(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    WeiYunFileInfo localWeiYunFileInfo = null;
    boolean bool;
    if (a(paramProtoResp))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      i = -100001;
      bool = false;
      paramProtoResp = localWeiYunFileInfo;
    }
    while (i != 0)
    {
      bool = false;
      label66:
      paramProtoReq = ((atia)paramProtoReq.busiData).a();
      localWeiYunFileInfo = atpm.a(paramProtoReq);
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse, bSuccess[" + String.valueOf(bool) + "]");
      if (localWeiYunFileInfo != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(bool, 20, new Object[] { Integer.valueOf(i), paramProtoResp, paramProtoReq, localWeiYunFileInfo.jdField_c_of_type_JavaLangString, Boolean.valueOf(true) });
      }
      return;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
        i = -100002;
        bool = false;
        paramProtoResp = localWeiYunFileInfo;
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(paramProtoResp);
          if (localRspBody.msg_delete_file_rsp.has()) {
            break label312;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse rspBody has not hasMsgApplyDownloadAbsRsp");
          i = -100003;
          bool = false;
          paramProtoResp = localWeiYunFileInfo;
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          i = -100003;
          bool = false;
          paramProtoResp = localWeiYunFileInfo;
        }
        continue;
        label312:
        paramProtoResp = (cmd0x346.DeleteFileRsp)localRspBody.msg_delete_file_rsp.get();
        if (!paramProtoResp.int32_ret_code.has()) {
          break label374;
        }
      }
    }
    label374:
    for (int i = paramProtoResp.int32_ret_code.get();; i = 0)
    {
      if (paramProtoResp.str_ret_msg.has()) {}
      for (paramProtoResp = paramProtoResp.str_ret_msg.get();; paramProtoResp = null)
      {
        bool = true;
        break;
        break label66;
      }
    }
  }
  
  private void n(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    atia localatia = (atia)paramProtoReq.busiData;
    switch (localatia.a())
    {
    case 9: 
    default: 
      QLog.e("FileTransferHandler<FileAssistant>", 1, "handleDiscGetFileInfo: subcmd[" + localatia.a() + "] is not implemented");
    case 4: 
    case 5: 
      return;
    case 1: 
      s(paramProtoReq, paramProtoResp);
      return;
    case 2: 
      t(paramProtoReq, paramProtoResp);
      return;
    case 3: 
      r(paramProtoReq, paramProtoResp);
      return;
    case 6: 
      o(paramProtoReq, paramProtoResp);
      return;
    case 7: 
      q(paramProtoReq, paramProtoResp);
      return;
    case 8: 
      p(paramProtoReq, paramProtoResp);
      return;
    }
    w(paramProtoReq, paramProtoResp);
  }
  
  private void o(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    String str = "";
    int i;
    boolean bool;
    if (a(paramProtoResp))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      str = null;
      i = -100001;
      bool = false;
    }
    label80:
    long l;
    for (paramProtoResp = "";; paramProtoResp = "")
    {
      if (i != 0) {
        bool = false;
      }
      if (str != null) {
        break label687;
      }
      bool = false;
      l = ((atia)paramProtoReq.busiData).a();
      paramProtoReq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l);
      if (paramProtoReq != null) {
        break label353;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "forward disc file, but entity is null!!!");
      return;
      if (paramProtoResp.resp.getResultCode() == 1000) {
        break;
      }
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
      str = null;
      i = -100002;
      bool = false;
    }
    paramProtoResp = paramProtoResp.resp.getWupBuffer();
    Object localObject = new cmd0x345.RspBody();
    for (;;)
    {
      try
      {
        ((cmd0x345.RspBody)localObject).mergeFrom(paramProtoResp);
        if (!((cmd0x345.RspBody)localObject).uint32_return_code.has()) {
          break label696;
        }
        i = ((cmd0x345.RspBody)localObject).uint32_return_code.get();
        if (((cmd0x345.RspBody)localObject).msg_subcmd_0x5_rsp_body.has()) {
          break label290;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: rspBody has not hasMsgApplyDownloadRsp");
        str = null;
        i = -100003;
        bool = false;
        paramProtoResp = "";
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
        str = null;
        i = -100003;
        bool = false;
        paramProtoResp = "";
      }
      break;
      label290:
      localObject = (cmd0x345.RspBody.SubCmd0x5RspBody)((cmd0x345.RspBody)localObject).msg_subcmd_0x5_rsp_body.get();
      paramProtoResp = str;
      if (((cmd0x345.RspBody.SubCmd0x5RspBody)localObject).str_ret_msg.has()) {
        paramProtoResp = ((cmd0x345.RspBody.SubCmd0x5RspBody)localObject).str_ret_msg.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x5RspBody)localObject).str_file_id.has()) {}
      for (str = ((cmd0x345.RspBody.SubCmd0x5RspBody)localObject).str_file_id.get();; str = null)
      {
        bool = true;
        break;
        label353:
        if (bool)
        {
          paramProtoReq.Uuid = str;
          paramProtoReq.setCloudType(1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(bool, 19, new Object[] { Integer.valueOf(i), paramProtoResp, Long.valueOf(0L), Long.valueOf(0L), str, Long.valueOf(l) });
          a(l, paramProtoReq.peerUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramProtoReq.fileName, paramProtoReq.fileSize, str, paramProtoReq.uniseq, paramProtoReq.msgUid, null);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(paramProtoReq, 6, null);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramProtoReq);
          return;
          paramProtoReq.status = 0;
          QLog.e("FileTransferHandler<FileAssistant>", 1, "nId[" + l + "],forward disc2disc faild, retCode[" + i + "], retMsg[" + paramProtoResp + "]");
          if ((i == -6101) || (i == -7003))
          {
            paramProtoReq.status = 16;
            if ((paramProtoReq.mContext != null) && ((paramProtoReq.mContext instanceof FileManagerEntity)))
            {
              localObject = (FileManagerEntity)paramProtoReq.mContext;
              ((FileManagerEntity)localObject).status = 16;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c((FileManagerEntity)localObject);
              paramProtoReq.mContext = null;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramProtoReq);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(bool, 19, new Object[] { Integer.valueOf(i), paramProtoResp, Long.valueOf(0L), Long.valueOf(0L), str, Long.valueOf(l) });
        }
        label687:
        break label80;
      }
      label696:
      i = 0;
    }
  }
  
  private void p(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    String str5 = "";
    String str4 = "";
    String str3 = "";
    String str2 = "";
    String str1 = "";
    int j = 0;
    Object localObject2 = null;
    Bundle localBundle = null;
    short s2 = 0;
    short s1 = 0;
    Object localObject1 = "";
    boolean bool;
    int i;
    if (a(paramProtoResp))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      bool = false;
      i = -100001;
      paramProtoResp = localBundle;
    }
    label109:
    cmd0x345.RspBody localRspBody;
    for (;;)
    {
      if (i != 0)
      {
        bool = false;
        localBundle = new Bundle();
        if (paramProtoResp != null) {
          localBundle.putString("strHttpsDomain", paramProtoResp);
        }
        localBundle.putShort("httpsPort", s1);
        localBundle.putString("IPv6Dns", (String)localObject1);
        paramProtoReq = (atia)paramProtoReq.busiData;
        if (paramProtoReq.a())
        {
          long l = paramProtoReq.a();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(bool, 192, new Object[] { Integer.valueOf(i), str5, str1, str4, str3, str2, Integer.valueOf(j), null, Long.valueOf(l), localBundle });
          return;
          if (paramProtoResp.resp.getResultCode() != 1000)
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
            bool = false;
            i = -100002;
            paramProtoResp = localBundle;
            continue;
          }
          paramProtoResp = paramProtoResp.resp.getWupBuffer();
          localRspBody = new cmd0x345.RspBody();
        }
      }
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramProtoResp);
        if (!localRspBody.uint32_return_code.has()) {
          break label665;
        }
        i = localRspBody.uint32_return_code.get();
        if (localRspBody.msg_subcmd_0x7_rsp_body.has()) {
          break label417;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalPreviewDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        bool = false;
        i = -100003;
        paramProtoResp = localBundle;
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
        bool = false;
        i = -100003;
        paramProtoResp = localBundle;
      }
      break;
      label417:
      localObject1 = (cmd0x345.RspBody.SubCmd0x7RspBody)localRspBody.msg_subcmd_0x7_rsp_body.get();
      str3 = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_server_ip.get();
      str2 = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_dns.get();
      j = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).uint32_server_port.get();
      str4 = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_url.get();
      str5 = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_ret_msg.get();
      str1 = "FTN5K=" + ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).bytes_cookie.get().toStringUtf8();
      paramProtoResp = localObject2;
      if (((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_https_domain.has()) {
        paramProtoResp = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_https_domain.get();
      }
      s1 = s2;
      if (((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).uint32_https_port.has()) {
        s1 = (short)((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).uint32_https_port.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_dns.has()) {}
      for (localObject1 = ((cmd0x345.RspBody.SubCmd0x7RspBody)localObject1).str_dns.get();; localObject1 = "")
      {
        bool = true;
        break;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(bool, 21, new Object[] { Integer.valueOf(i), str5, str1, str4, str3, str2, Integer.valueOf(j), localBundle });
        return;
        break label109;
      }
      label665:
      i = 0;
    }
  }
  
  private void q(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    int j = -100003;
    String str = "";
    Object localObject = null;
    int i;
    if (a(paramProtoResp))
    {
      i = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      paramProtoResp = "";
    }
    long l;
    for (boolean bool = false;; bool = false)
    {
      if (i != 0) {
        bool = false;
      }
      if (localObject == null) {
        bool = false;
      }
      l = ((atia)paramProtoReq.busiData).a();
      paramProtoReq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l);
      if (paramProtoReq != null) {
        break label347;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "forward disc file, but entity is null!!!");
      return;
      if (paramProtoResp.resp.getResultCode() == 1000) {
        break;
      }
      i = -100002;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
      paramProtoResp = "";
    }
    paramProtoResp = paramProtoResp.resp.getWupBuffer();
    cmd0x345.RspBody localRspBody = new cmd0x345.RspBody();
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramProtoResp);
        if (!localRspBody.uint32_return_code.has()) {
          break label383;
        }
        i = localRspBody.uint32_return_code.get();
        if (localRspBody.msg_subcmd_0x6_rsp_body.has()) {
          break label284;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        paramProtoResp = "";
        bool = false;
        i = j;
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
        paramProtoResp = "";
        bool = false;
        i = j;
      }
      break;
      label284:
      localObject = (cmd0x345.RspBody.SubCmd0x6RspBody)localRspBody.msg_subcmd_0x6_rsp_body.get();
      paramProtoResp = str;
      if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_ret_msg.has()) {
        paramProtoResp = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_ret_msg.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_file_id.has()) {}
      for (localObject = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject).str_file_id.get();; localObject = null)
      {
        bool = true;
        break;
        label347:
        paramProtoReq.status = 0;
        a(bool, paramProtoReq, (String)localObject, i, paramProtoResp, l);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramProtoReq);
        return;
      }
      label383:
      i = 0;
    }
  }
  
  private void r(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    long l1 = 0L;
    String str2 = "";
    String str3 = "";
    String str4 = "";
    short s = 0;
    Object localObject3 = "";
    Bundle localBundle = new Bundle();
    Object localObject1;
    Object localObject2;
    int i;
    atia localatia;
    long l2;
    label135:
    boolean bool;
    label151:
    StringBuilder localStringBuilder;
    if (a(paramProtoResp.resp.getResultCode()))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      localObject1 = "";
      localObject2 = "";
      i = 80;
      l1 = -100001L;
      if (l1 != 0L) {}
      localatia = (atia)paramProtoReq.busiData;
      if (l1 != -100001L) {
        break label669;
      }
      l2 = 9043L;
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break label753;
      }
      bool = true;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("internalDownloadDiscFile: return ").append(bool).append(", retCode=").append(l2).append(", strHost=").append((String)localObject2).append(", strCheckSum=");
        if (localObject1 == null) {
          break label759;
        }
      }
    }
    label555:
    label753:
    label759:
    for (paramProtoReq = (ProtoReqManager.ProtoReq)localObject1;; paramProtoReq = "")
    {
      for (;;)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, paramProtoReq + ", strCookie=" + str2 + ", port=" + i);
        localBundle.putShort("httpsPort", s);
        localBundle.putString("IPv6Dns", (String)localObject3);
        a(localatia.a(), 5013, bool, new Object[] { Long.valueOf(l2), str3, str4, localObject2, Integer.valueOf(i), localObject1, str2, Integer.valueOf(paramProtoResp.resp.getAppSeq()), Long.valueOf(localatia.a()), localBundle });
        return;
        if (paramProtoResp.resp.getResultCode() != 1000)
        {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
          localObject1 = "";
          localObject2 = "";
          i = 80;
          l1 = -100002L;
          break;
        }
        localObject1 = paramProtoResp.resp.getWupBuffer();
        localObject2 = new cmd0x345.RspBody();
        try
        {
          ((cmd0x345.RspBody)localObject2).mergeFrom((byte[])localObject1);
          if (((cmd0x345.RspBody)localObject2).uint32_return_code.has()) {
            l1 = ((cmd0x345.RspBody)localObject2).uint32_return_code.get();
          }
          if (((cmd0x345.RspBody)localObject2).msg_subcmd_0x3_rsp_body.has()) {
            break label555;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "internalDownloadDiscFile: rspBody has not hasMsgApplyDownloadRsp");
          localObject1 = "";
          localObject2 = "";
          i = 80;
          l1 = -100003L;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          str1 = "";
          localObject2 = "";
          i = 80;
          l1 = -100003L;
        }
      }
      break;
      localObject3 = new athw(this, l1, "", 80, "", "", "", "", (short)0, "", localBundle, (cmd0x345.RspBody.SubCmd0x3RspBody)((cmd0x345.RspBody)localObject2).msg_subcmd_0x3_rsp_body.get()).a();
      l1 = ((athw)localObject3).a();
      localObject2 = ((athw)localObject3).a();
      i = ((athw)localObject3).a();
      String str1 = ((athw)localObject3).b();
      str2 = ((athw)localObject3).c();
      str3 = ((athw)localObject3).d();
      str4 = ((athw)localObject3).e();
      s = ((athw)localObject3).a();
      localObject3 = ((athw)localObject3).f();
      break;
      if (l1 == -100003L)
      {
        l2 = 9045L;
        break label135;
      }
      if ((l1 == 0L) && (localObject2 == null)) {}
      for (int j = 1;; j = 0)
      {
        int k = localatia.b();
        l2 = l1;
        if (j == 0) {
          break;
        }
        l2 = l1;
        if (k >= 3) {
          break;
        }
        localatia.a();
        a(paramProtoReq.ssoCmd, paramProtoReq.reqBody, localatia);
        return;
      }
      bool = false;
      break label151;
    }
  }
  
  private void s(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    Object localObject2 = "";
    Object localObject3 = "";
    int i = 0;
    String str1 = "";
    String str2 = "";
    String str3 = null;
    short s = 0;
    Object localObject4 = "";
    Object localObject1;
    boolean bool;
    long l;
    if (a(paramProtoResp))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      localObject1 = "";
      bool = false;
      paramProtoResp = "";
      l = -100001L;
    }
    label106:
    Object localObject5;
    for (;;)
    {
      if (l != 0L)
      {
        bool = false;
        localObject5 = (atia)paramProtoReq.busiData;
        if (l == -100001L)
        {
          l = 9043L;
          label129:
          paramProtoReq = new Bundle();
          if (str3 != null) {
            paramProtoReq.putString("strHttpsDomain", str3);
          }
          paramProtoReq.putShort("httpsPort", s);
          paramProtoReq.putString("IPv6Dns", (String)localObject4);
          a(((atia)localObject5).a(), 5015, bool, new Object[] { Long.valueOf(l), localObject1, paramProtoResp, localObject2, localObject3, Integer.valueOf(i), str1, str2, paramProtoReq });
          return;
          if (paramProtoResp.resp.getResultCode() != 1000)
          {
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
            localObject1 = "";
            bool = false;
            paramProtoResp = "";
            l = -100002L;
            continue;
          }
          paramProtoResp = paramProtoResp.resp.getWupBuffer();
          localObject1 = new cmd0x345.RspBody();
        }
      }
    }
    for (;;)
    {
      try
      {
        ((cmd0x345.RspBody)localObject1).mergeFrom(paramProtoResp);
        if (!((cmd0x345.RspBody)localObject1).uint32_return_code.has()) {
          break label819;
        }
        l = ((cmd0x345.RspBody)localObject1).uint32_return_code.get();
        if (((cmd0x345.RspBody)localObject1).msg_subcmd_0x1_rsp_body.has()) {
          break label422;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalSendDiscFileRequest: rspBody has not hasMsgApplyDownloadRsp");
        localObject1 = "";
        bool = false;
        paramProtoResp = "";
        l = -100003L;
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
        localObject1 = "";
        bool = false;
        paramProtoResp = "";
        l = -100003L;
      }
      break;
      label422:
      localObject4 = (cmd0x345.RspBody.SubCmd0x1RspBody)((cmd0x345.RspBody)localObject1).msg_subcmd_0x1_rsp_body.get();
      if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_file_id.has()) {}
      for (localObject1 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_file_id.get();; localObject1 = "")
      {
        if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_file_key.has()) {}
        for (localObject3 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_file_key.get();; localObject3 = "")
        {
          if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_check_sum.has()) {}
          for (paramProtoResp = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_check_sum.get();; paramProtoResp = "")
          {
            if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_host.has()) {}
            for (localObject2 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_host.get();; localObject2 = "")
            {
              if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).uint32_port.has()) {}
              for (i = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).uint32_port.get();; i = 0)
              {
                if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_file_name.has()) {}
                for (str1 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_file_name.get();; str1 = "")
                {
                  if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_warn.has()) {}
                  for (str2 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_warn.get();; str2 = "")
                  {
                    if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_https_domain.has()) {}
                    for (str3 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_https_domain.get();; str3 = null)
                    {
                      if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).uint32_https_port.has()) {}
                      for (s = (short)((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).uint32_https_port.get();; s = 0)
                      {
                        if (((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_dns.has()) {}
                        for (localObject4 = ((cmd0x345.RspBody.SubCmd0x1RspBody)localObject4).str_dns.get();; localObject4 = "")
                        {
                          localObject5 = localObject3;
                          bool = true;
                          localObject3 = localObject2;
                          localObject2 = paramProtoResp;
                          paramProtoResp = (ProtoReqManager.ProtoResp)localObject5;
                          break;
                          if (l == -100003L)
                          {
                            l = 9045L;
                            break label129;
                          }
                          if ((localObject3 == null) || (((String)localObject3).length() == 0)) {}
                          for (int j = 1;; j = 0)
                          {
                            int k = ((atia)localObject5).b();
                            if ((j == 0) || (k >= 3)) {
                              break;
                            }
                            ((atia)localObject5).a();
                            a(paramProtoReq.ssoCmd, paramProtoReq.reqBody, (atia)localObject5);
                            return;
                          }
                          break label129;
                          break label106;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label819:
      l = 0L;
    }
  }
  
  private void t(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    paramProtoReq = (atia)paramProtoReq.busiData;
    long l2 = paramProtoReq.a();
    QLog.i("FileTransferHandler<FileAssistant>", 2, "=_= ^ [Feed Replay] Id[" + l2 + "]sendDiscFeed Replay");
    boolean bool = false;
    long l1 = 0L;
    if (a(paramProtoResp))
    {
      l1 = -100001L;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay] Id[" + l2 + "]internalSendDiscFileRequest: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      if (l1 != 0L) {
        bool = false;
      }
      if (l2 != 0L) {
        break label367;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay]why sessoinId is 0?!");
    }
    label361:
    label367:
    do
    {
      for (;;)
      {
        if ((bool) && (l2 > 0L)) {
          auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2);
        }
        a(paramProtoReq.a(), 5016, bool, new Object[] { Long.valueOf(l1) });
        return;
        if (paramProtoResp.resp.getResultCode() != 1000)
        {
          l1 = -100002L;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay] Id[" + l2 + "]internalSendDiscFileRequest: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
          break;
        }
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        cmd0x345.RspBody localRspBody = new cmd0x345.RspBody();
        try
        {
          localRspBody.mergeFrom(paramProtoResp);
          if (localRspBody.uint32_return_code.has()) {
            l1 = localRspBody.uint32_return_code.get();
          }
          if (localRspBody.msg_subcmd_0x2_rsp_body.has()) {
            break label361;
          }
          l1 = -100003L;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay] Id[" + l2 + "]internalSendDiscFileRequest: rspBody has not hasMsgApplyDownloadRsp");
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          l1 = -100003L;
        }
      }
      break;
      bool = true;
      break;
      paramProtoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l2);
    } while (paramProtoResp == null);
    if (bool)
    {
      paramProtoResp.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(paramProtoResp, 6, "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramProtoResp);
      break;
      QLog.e("FileTransferHandler<FileAssistant>", 1, "=_= ^! [Feed Replay]nSessionId[" + l2 + "] sendDiscFeed faild,retCode[" + l1 + "]");
      paramProtoResp.status = 0;
      a(l1, paramProtoResp);
    }
  }
  
  private void u(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^> [CS Replay] response FileHit");
    athx localathx = new athx(this);
    boolean bool;
    int i;
    label97:
    int j;
    label117:
    Object localObject;
    if (a(paramProtoResp))
    {
      localathx.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      bool = false;
      if ((localathx.jdField_b_of_type_JavaLangString == null) || (localathx.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label823;
      }
      i = 1;
      if ((localathx.jdField_a_of_type_ArrayOfByte != null) && (localathx.jdField_a_of_type_ArrayOfByte.length != 0)) {
        break label828;
      }
      j = 1;
      localObject = new anza();
      ((anza)localObject).jdField_b_of_type_Int = localathx.jdField_a_of_type_Int;
      ((anza)localObject).jdField_c_of_type_Int = paramProtoResp.freeRunnalbleIndex;
      if ((j == 0) || (i == 0)) {
        break label834;
      }
      localathx.jdField_a_of_type_JavaLangString = ("uuid_null[" + localathx.toString() + "]");
      bool = false;
    }
    label823:
    label828:
    label834:
    for (;;)
    {
      cmd0x346.RspBody localRspBody;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool + ", retCode=" + localathx.jdField_a_of_type_Int + ", retMsg=" + localathx.jdField_a_of_type_JavaLangString + ", totalSpace=" + localathx.jdField_a_of_type_Long + ", usedSpace=" + localathx.jdField_b_of_type_Long + ", ip=" + localathx.jdField_b_of_type_JavaLangString + ", port=" + localathx.jdField_a_of_type_Short);
        }
        a(((atia)paramProtoReq.busiData).a(), 5020, bool, new Object[] { localathx, localObject, null });
        return;
        if (paramProtoResp.resp.getResultCode() != 1000)
        {
          localathx.jdField_a_of_type_Int = -100002;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
          bool = false;
          break;
        }
        localObject = paramProtoResp.resp.getWupBuffer();
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
          if (localRspBody.msg_apply_upload_hit_rsp_v2.has()) {
            break label493;
          }
          localathx.jdField_a_of_type_Int = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localathx.jdField_a_of_type_Int = -100003;
          bool = false;
        }
      }
      break;
      label493:
      cmd0x346.ApplyUploadHitRspV2 localApplyUploadHitRspV2 = (cmd0x346.ApplyUploadHitRspV2)localRspBody.msg_apply_upload_hit_rsp_v2.get();
      if (localApplyUploadHitRspV2.int32_ret_code.has()) {
        localathx.jdField_a_of_type_Int = localApplyUploadHitRspV2.int32_ret_code.get();
      }
      if (localApplyUploadHitRspV2.str_ret_msg.has()) {
        localathx.jdField_a_of_type_JavaLangString = localApplyUploadHitRspV2.str_ret_msg.get();
      }
      if (localApplyUploadHitRspV2.uint64_total_space.has()) {
        localathx.jdField_a_of_type_Long = localApplyUploadHitRspV2.uint64_total_space.get();
      }
      if (localApplyUploadHitRspV2.uint64_used_space.has()) {
        localathx.jdField_b_of_type_Long = localApplyUploadHitRspV2.uint64_used_space.get();
      }
      if (localApplyUploadHitRspV2.str_upload_ip.has()) {
        localathx.jdField_b_of_type_JavaLangString = localApplyUploadHitRspV2.str_upload_ip.get();
      }
      for (;;)
      {
        if (localApplyUploadHitRspV2.uint32_upload_port.has()) {
          localathx.jdField_a_of_type_Short = ((short)localApplyUploadHitRspV2.uint32_upload_port.get());
        }
        if (localApplyUploadHitRspV2.bytes_uuid.has()) {
          localathx.jdField_a_of_type_ArrayOfByte = localApplyUploadHitRspV2.bytes_uuid.get().toByteArray();
        }
        if (localApplyUploadHitRspV2.bytes_upload_key.has()) {
          localathx.jdField_b_of_type_ArrayOfByte = localApplyUploadHitRspV2.bytes_upload_key.get().toByteArray();
        }
        if (localApplyUploadHitRspV2.str_upload_https_domain.has()) {
          localathx.jdField_c_of_type_JavaLangString = localApplyUploadHitRspV2.str_upload_https_domain.get();
        }
        if (localApplyUploadHitRspV2.uint32_upload_https_port.has()) {
          localathx.jdField_b_of_type_Short = ((short)localApplyUploadHitRspV2.uint32_upload_https_port.get());
        }
        if (localApplyUploadHitRspV2.str_upload_dns.has()) {
          localathx.jdField_d_of_type_JavaLangString = localApplyUploadHitRspV2.str_upload_dns.get();
        }
        bool = true;
        break;
        if (localApplyUploadHitRspV2.str_upload_domain.has()) {
          localathx.jdField_b_of_type_JavaLangString = localApplyUploadHitRspV2.str_upload_domain.get();
        } else {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse has neither ip nor domain");
        }
      }
      i = 0;
      break label97;
      j = 0;
      break label117;
    }
  }
  
  private void v(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    int i = -100003;
    boolean bool2 = false;
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.i("FileTransferHandler<FileAssistant>", 2, "handleRecallResponse ");
    }
    boolean bool1;
    if (a(paramProtoResp))
    {
      i = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      bool1 = false;
      paramProtoResp = localObject;
    }
    for (;;)
    {
      if (i != 0)
      {
        bool1 = bool2;
        label89:
        paramProtoReq = (atpl)((atia)paramProtoReq.busiData).a();
        if (QLog.isColorLevel()) {
          QLog.i("FileTransferHandler<FileAssistant>", 2, "handleRecallResponse [" + bool1 + "],retCode[" + i + "], retMsg[" + paramProtoResp + "]");
        }
        if (bool1)
        {
          paramProtoReq.onSuccess();
          return;
          if (paramProtoResp.resp.getResultCode() != 1000)
          {
            i = -100002;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
            bool1 = false;
            paramProtoResp = localObject;
            continue;
          }
          paramProtoResp = paramProtoResp.resp.getWupBuffer();
          cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
          try
          {
            localRspBody.mergeFrom(paramProtoResp);
            if (localRspBody.msg_recall_file_rsp.has()) {
              break label305;
            }
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handleRemoveResponse rspBody has not hasMsgApplyDownloadAbsRsp");
            bool1 = false;
            paramProtoResp = localObject;
          }
          catch (InvalidProtocolBufferMicroException paramProtoResp)
          {
            paramProtoResp.printStackTrace();
            bool1 = false;
            paramProtoResp = localObject;
          }
          continue;
          label305:
          paramProtoResp = (cmd0x346.RecallFileRsp)localRspBody.msg_recall_file_rsp.get();
          if (!paramProtoResp.int32_ret_code.has()) {
            break label376;
          }
        }
      }
    }
    label376:
    for (i = paramProtoResp.int32_ret_code.get();; i = 0)
    {
      if (paramProtoResp.str_ret_msg.has()) {}
      for (paramProtoResp = paramProtoResp.str_ret_msg.get();; paramProtoResp = null)
      {
        bool1 = true;
        break;
        paramProtoReq.onError(i, paramProtoResp);
        return;
        break label89;
      }
    }
  }
  
  private void w(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    boolean bool2 = false;
    String str = "";
    int i;
    boolean bool1;
    if (a(paramProtoResp))
    {
      i = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      bool1 = false;
      paramProtoResp = str;
    }
    label72:
    cmd0x345.RspBody localRspBody;
    for (;;)
    {
      if (i != 0)
      {
        bool1 = bool2;
        paramProtoReq = (atpl)((atia)paramProtoReq.busiData).a();
        if (QLog.isColorLevel()) {
          QLog.i("FileTransferHandler<FileAssistant>", 2, "internalDeleteDiscFile [" + bool1 + "],retCode[" + i + "], retMsg[" + paramProtoResp + "]");
        }
        if (paramProtoReq == null)
        {
          QLog.e("FileTransferHandler<FileAssistant>", 1, "del disc file, but callback is null!!!,check here!!!");
          return;
          if (paramProtoResp.resp.getResultCode() != 1000)
          {
            i = -100002;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
            bool1 = false;
            paramProtoResp = str;
            continue;
          }
          paramProtoResp = paramProtoResp.resp.getWupBuffer();
          localRspBody = new cmd0x345.RspBody();
        }
      }
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramProtoResp);
        if (!localRspBody.uint32_return_code.has()) {
          break label385;
        }
        i = localRspBody.uint32_return_code.get();
        if (localRspBody.msg_subcmd_0xa_rsp_body.has()) {
          break label318;
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "internalForwardDisc2Disc: rspBody has not hasMsgApplyDownloadRsp");
        i = -100003;
        bool1 = false;
        paramProtoResp = str;
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
        i = -100003;
        bool1 = false;
        paramProtoResp = str;
      }
      break;
      label318:
      paramProtoResp = (cmd0x345.RspBody.SubCmd0xaRspBody)localRspBody.msg_subcmd_0xa_rsp_body.get();
      if (paramProtoResp.str_ret_msg.has()) {}
      for (paramProtoResp = paramProtoResp.str_ret_msg.get();; paramProtoResp = "")
      {
        bool1 = true;
        break;
        if (bool1)
        {
          paramProtoReq.onSuccess();
          return;
        }
        paramProtoReq.onError(i, paramProtoResp);
        return;
        break label72;
      }
      label385:
      i = 0;
    }
  }
  
  public long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, im_msg_body.GroupFile paramGroupFile, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 1, "handleDiscFileCome,uinseq[" + String.valueOf(paramLong1) + "],discUin[" + String.valueOf(paramLong2) + "],sendUin[" + String.valueOf(paramLong3) + "],seq[" + String.valueOf(paramLong4) + "],msgTime[" + String.valueOf(paramLong6) + "],fileInfo[" + String.valueOf(paramGroupFile) + "],oriImgWidth[" + String.valueOf(paramInt1) + "],oriImgHeight[" + String.valueOf(paramInt2) + "]");
    }
    return b(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramGroupFile, paramInt1, paramInt2);
  }
  
  public long a(List<MessageRecord> paramList, String paramString1, String paramString2, String paramString3, long paramLong1, boolean paramBoolean, int paramInt1, String paramString4, long paramLong2, long paramLong3, String paramString5, int paramInt2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt3, int paramInt4, hummer_resv_21.FileImgInfo paramFileImgInfo)
  {
    paramString5 = bcsa.a(paramInt3);
    paramString5.uniseq = paramLong4;
    paramString5.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramString5.frienduin = paramString1;
    paramString5.senderuin = paramString2;
    if ((paramString4 == null) || (paramString4.length() < 1)) {
      paramString4 = TransfileUtile.makeTransFileProtocolData(paramString3, paramLong1, 0, paramBoolean);
    }
    for (;;)
    {
      if (paramInt3 == -3008)
      {
        paramString5.msg = paramString3;
        paramString5.msgtype = paramInt3;
        paramString5.isread = paramBoolean;
        if (!paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
          break label585;
        }
        paramInt2 = 1;
        label110:
        paramString5.issend = paramInt2;
        paramString5.istroop = paramInt1;
        paramString5.msgseq = paramLong2;
        paramString5.shmsgseq = bcsc.a(paramLong2, paramInt1);
        paramString5.msgUid = paramLong5;
        paramString5.time = paramLong7;
        if (!paramString5.isSend()) {
          break label591;
        }
        ((aocy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramString5);
      }
      for (;;)
      {
        paramString5.vipBubbleDiyTextId = paramInt4;
        if (paramFileImgInfo != null)
        {
          paramString5.saveExtInfoToExtStr("file_pic_width", String.valueOf(paramFileImgInfo.uint32_file_width.get()));
          paramString5.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(paramFileImgInfo.uint32_file_height.get()));
          QLog.i("FileTransferHandler<FileAssistant>", 1, "Insert ThumbSize toMsg height[" + paramFileImgInfo.uint32_file_width.get() + "], width[" + paramFileImgInfo.uint32_file_height.get() + "]");
        }
        if (paramInt3 == -2005) {
          ((MessageForFile)paramString5).parse();
        }
        paramList.add(paramString5);
        auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, paramInt1);
        if (this.jdField_a_of_type_Bedr == null) {
          this.jdField_a_of_type_Bedr = ((bedr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER));
        }
        if ((paramString5 instanceof MessageForFile)) {
          this.jdField_a_of_type_Bedr.a((MessageForFile)paramString5);
        }
        QLog.i("FileTransferHandler<FileAssistant>", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(paramString5.uniseq) + "], selfuin[" + auea.e(paramString5.selfuin) + "], frienduin[" + auea.e(paramString5.frienduin) + "], senderuin[" + auea.e(paramString5.senderuin) + "], issend[" + String.valueOf(paramString5.issend) + "], istroop[" + String.valueOf(paramString5.istroop) + "], shmsgseq[" + String.valueOf(paramString5.shmsgseq) + "], msgUid[" + String.valueOf(paramString5.msgUid) + "], time[" + String.valueOf(paramString5.time) + "], vipBubbleID[" + String.valueOf(paramLong6) + "], bubbleDiyTextId[" + String.valueOf(paramInt4) + "]");
        return paramString5.uniseq;
        paramString3 = paramString4;
        break;
        label585:
        paramInt2 = 0;
        break label110;
        label591:
        if (paramLong6 != -1L) {
          paramString5.vipBubbleID = paramLong6;
        } else {
          paramString5.vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastC2CBubleID(paramString1);
        }
      }
    }
  }
  
  public atqa a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed context=null");
      return null;
    }
    int i = paramArrayOfByte.length;
    atqa localatqa = new atqa();
    int j;
    if (i >= 16)
    {
      PkgTools.getBytesData(paramArrayOfByte, 0, localatqa.jdField_a_of_type_ArrayOfByte, 16);
      if (i >= 28)
      {
        localatqa.jdField_b_of_type_Long = PkgTools.getLongData(paramArrayOfByte, 24);
        if (i < 51) {
          break label116;
        }
        j = PkgTools.getShortData(paramArrayOfByte, 49);
        if (j >= 4) {
          break label127;
        }
        localatqa.jdField_a_of_type_Boolean = false;
        return localatqa;
      }
    }
    else
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - bufAppGuid");
      return null;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - dwSessionId");
    return null;
    label116:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - bufOther");
    return null;
    label127:
    byte[] arrayOfByte = new byte[j];
    label151:
    int k;
    int m;
    if (i >= j + 51)
    {
      PkgTools.getBytesData(paramArrayOfByte, 51, arrayOfByte, j);
      i = 0;
      if (i < j)
      {
        k = arrayOfByte[i];
        m = i + 1;
        if (j < m + 2) {
          break label214;
        }
        i = PkgTools.getShortData(arrayOfByte, m);
        m += 2;
        if (k != 1) {
          break label226;
        }
      }
    }
    label214:
    label226:
    do
    {
      for (;;)
      {
        i = m + i;
        break label151;
        break;
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept failed - ismulitendpoint");
        return null;
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - L");
        break;
        if ((k != 2) && (k != 3))
        {
          if (k == 4)
          {
            paramArrayOfByte = new byte[i];
            if (j >= m + i)
            {
              PkgTools.getBytesData(arrayOfByte, m, paramArrayOfByte, i);
              paramArrayOfByte = a(paramArrayOfByte);
              if (paramArrayOfByte != null)
              {
                localatqa.jdField_a_of_type_JavaLangString = paramArrayOfByte.jdField_a_of_type_JavaLangString;
                localatqa.jdField_a_of_type_Long = paramArrayOfByte.jdField_a_of_type_Long;
              }
            }
            else
            {
              QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - V");
              break;
            }
            QLog.e("FileTransferHandler<FileAssistant>", 1, "decode file info error for request or accept");
            return null;
          }
          if (k != 12) {
            if (k == 15)
            {
              if (i < 1)
              {
                localatqa.jdField_a_of_type_Boolean = false;
              }
              else if (j >= m + i)
              {
                paramArrayOfByte = new byte[i];
                PkgTools.getBytesData(arrayOfByte, m, paramArrayOfByte, i);
                if (paramArrayOfByte[0] == 1) {}
                for (bool = true;; bool = false)
                {
                  localatqa.jdField_a_of_type_Boolean = bool;
                  break;
                }
              }
            }
            else if (k == 17)
            {
              if (i >= 1) {
                break label415;
              }
              localatqa.jdField_b_of_type_Boolean = false;
            }
          }
        }
      }
    } while (j < m + i);
    label415:
    paramArrayOfByte = new byte[i];
    PkgTools.getBytesData(arrayOfByte, m, paramArrayOfByte, i);
    if (paramArrayOfByte[0] == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localatqa.jdField_b_of_type_Boolean = bool;
      break;
    }
  }
  
  public aucr a(aucv paramaucv)
  {
    aucr localaucr = new aucr();
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (paramaucv.jdField_a_of_type_Int == 1700)
    {
      localaucr.jdField_a_of_type_Aucq = new aucq();
      paramaucv.jdField_a_of_type_JavaLangString = paramaucv.jdField_a_of_type_JavaLangString.replace("+", "");
      localaucr.jdField_a_of_type_Aucq.jdField_a_of_type_Long = l;
      localaucr.jdField_a_of_type_Aucq.jdField_b_of_type_Long = Long.parseLong(paramaucv.jdField_a_of_type_JavaLangString);
      localaucr.jdField_a_of_type_Aucq.jdField_c_of_type_Long = paramaucv.jdField_a_of_type_Long;
      localaucr.jdField_a_of_type_Aucq.jdField_a_of_type_JavaLangString = new String(paramaucv.jdField_b_of_type_ArrayOfByte);
      localaucr.jdField_a_of_type_Aucq.jdField_b_of_type_JavaLangString = new String(paramaucv.jdField_a_of_type_ArrayOfByte);
      localaucr.jdField_a_of_type_Aucq.jdField_a_of_type_ArrayOfByte = paramaucv.jdField_c_of_type_ArrayOfByte;
      localaucr.jdField_a_of_type_Aucq.jdField_c_of_type_ArrayOfByte = paramaucv.jdField_e_of_type_ArrayOfByte;
      localaucr.jdField_a_of_type_Aucq.jdField_b_of_type_ArrayOfByte = paramaucv.jdField_d_of_type_ArrayOfByte;
      localaucr.jdField_a_of_type_Aucq.jdField_d_of_type_ArrayOfByte = paramaucv.f;
    }
    while (paramaucv.jdField_a_of_type_Int != 1600) {
      return localaucr;
    }
    localaucr.jdField_a_of_type_Aucp = new aucp();
    paramaucv.jdField_a_of_type_JavaLangString = paramaucv.jdField_a_of_type_JavaLangString.replace("+", "");
    localaucr.jdField_a_of_type_Aucp.jdField_a_of_type_Long = l;
    localaucr.jdField_a_of_type_Aucp.jdField_b_of_type_Long = Long.parseLong(paramaucv.jdField_a_of_type_JavaLangString);
    localaucr.jdField_a_of_type_Aucp.jdField_c_of_type_Long = paramaucv.jdField_a_of_type_Long;
    localaucr.jdField_a_of_type_Aucp.jdField_a_of_type_JavaLangString = new String(paramaucv.jdField_b_of_type_ArrayOfByte);
    localaucr.jdField_a_of_type_Aucp.jdField_b_of_type_JavaLangString = new String(paramaucv.jdField_a_of_type_ArrayOfByte);
    localaucr.jdField_a_of_type_Aucp.jdField_a_of_type_ArrayOfByte = paramaucv.jdField_c_of_type_ArrayOfByte;
    localaucr.jdField_a_of_type_Aucp.jdField_b_of_type_ArrayOfByte = paramaucv.f;
    return localaucr;
  }
  
  public MessageRecord a(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(paramString1, paramInt);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("------->msgFilter :msgIsTroop:").append(paramInt).append(",peerUin:").append(paramString1).append(",list size:");
      if (localObject == null)
      {
        paramInt = 0;
        QLog.d("FileTransferHandler<FileAssistant>", 2, paramInt);
      }
    }
    else
    {
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label257;
      }
      paramString1 = ((List)localObject).iterator();
      label98:
      do
      {
        if (!paramString1.hasNext()) {
          break label257;
        }
        localObject = (MessageRecord)paramString1.next();
        if ((((MessageRecord)localObject).msgUid == 0L) || (paramLong3 == 0L)) {
          break;
        }
      } while ((((MessageRecord)localObject).msgUid != paramLong3) || (((MessageRecord)localObject).shmsgseq != paramLong2) || (!((MessageRecord)localObject).senderuin.equals(paramString2)));
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
      }
    }
    do
    {
      return localObject;
      paramInt = ((List)localObject).size();
      break;
      if ((Math.abs(((MessageRecord)localObject).time - paramLong1) >= 30L) || (((MessageRecord)localObject).shmsgseq != paramLong2) || (!((MessageRecord)localObject).senderuin.equals(paramString2))) {
        break label98;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FileTransferHandler<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
    return localObject;
    label257:
    return null;
  }
  
  public List<MessageRecord> a(MessageHandler paramMessageHandler, List<msg_comm.Msg> paramList, long paramLong, boolean paramBoolean)
  {
    paramMessageHandler = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramList);
    int i = 0;
    while (i < localArrayList.size())
    {
      msg_comm.Msg localMsg = (msg_comm.Msg)localArrayList.get(i);
      if (a(paramLong, paramBoolean, paramMessageHandler, i, localMsg, (msg_comm.MsgHead)localMsg.msg_head.get())) {
        paramList.remove(localMsg);
      }
      i += 1;
    }
    return paramMessageHandler;
  }
  
  public cmd0x346.ApplyUploadHitReqV2 a(aucr paramaucr)
  {
    cmd0x346.ApplyUploadHitReqV2 localApplyUploadHitReqV2 = new cmd0x346.ApplyUploadHitReqV2();
    paramaucr = paramaucr.jdField_a_of_type_Auco;
    localApplyUploadHitReqV2.uint64_sender_uin.set(paramaucr.jdField_a_of_type_Long);
    localApplyUploadHitReqV2.uint64_recver_uin.set(paramaucr.jdField_b_of_type_Long);
    localApplyUploadHitReqV2.uint64_file_size.set(paramaucr.jdField_c_of_type_Long);
    localApplyUploadHitReqV2.str_file_name.set(paramaucr.jdField_a_of_type_JavaLangString);
    localApplyUploadHitReqV2.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramaucr.jdField_a_of_type_ArrayOfByte));
    localApplyUploadHitReqV2.bytes_3sha.set(ByteStringMicro.copyFrom(paramaucr.jdField_b_of_type_ArrayOfByte));
    localApplyUploadHitReqV2.bytes_sha.set(ByteStringMicro.copyFrom(paramaucr.jdField_c_of_type_ArrayOfByte));
    localApplyUploadHitReqV2.str_local_filepath.set(paramaucr.jdField_b_of_type_JavaLangString);
    localApplyUploadHitReqV2.uint32_danger_level.set(paramaucr.jdField_a_of_type_Int);
    localApplyUploadHitReqV2.uint64_total_space.set(paramaucr.jdField_d_of_type_Long);
    return localApplyUploadHitReqV2;
  }
  
  public cmd0x346.ApplyUploadReqV2 a(aucr paramaucr)
  {
    cmd0x346.ApplyUploadReqV2 localApplyUploadReqV2 = new cmd0x346.ApplyUploadReqV2();
    paramaucr = paramaucr.jdField_a_of_type_Aucp;
    localApplyUploadReqV2.uint64_sender_uin.set(paramaucr.jdField_a_of_type_Long);
    localApplyUploadReqV2.uint64_recver_uin.set(paramaucr.jdField_b_of_type_Long);
    localApplyUploadReqV2.uint64_file_size.set(paramaucr.jdField_c_of_type_Long);
    localApplyUploadReqV2.str_file_name.set(paramaucr.jdField_a_of_type_JavaLangString);
    localApplyUploadReqV2.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramaucr.jdField_a_of_type_ArrayOfByte));
    localApplyUploadReqV2.bytes_3sha.set(ByteStringMicro.copyFrom(paramaucr.jdField_b_of_type_ArrayOfByte));
    localApplyUploadReqV2.str_local_filepath.set(paramaucr.jdField_b_of_type_JavaLangString);
    localApplyUploadReqV2.uint32_danger_level.set(paramaucr.jdField_a_of_type_Int);
    localApplyUploadReqV2.uint64_total_space.set(paramaucr.jdField_d_of_type_Long);
    return localApplyUploadReqV2;
  }
  
  public cmd0x346.ApplyUploadReqV3 a(aucr paramaucr)
  {
    cmd0x346.ApplyUploadReqV3 localApplyUploadReqV3 = new cmd0x346.ApplyUploadReqV3();
    paramaucr = paramaucr.jdField_a_of_type_Aucq;
    localApplyUploadReqV3.uint64_sender_uin.set(paramaucr.jdField_a_of_type_Long);
    localApplyUploadReqV3.uint64_recver_uin.set(paramaucr.jdField_b_of_type_Long);
    localApplyUploadReqV3.uint64_file_size.set(paramaucr.jdField_c_of_type_Long);
    localApplyUploadReqV3.str_file_name.set(paramaucr.jdField_a_of_type_JavaLangString);
    localApplyUploadReqV3.bytes_10m_md5.set(ByteStringMicro.copyFrom(paramaucr.jdField_a_of_type_ArrayOfByte));
    if (paramaucr.jdField_b_of_type_ArrayOfByte != null) {
      localApplyUploadReqV3.bytes_md5.set(ByteStringMicro.copyFrom(paramaucr.jdField_b_of_type_ArrayOfByte));
    }
    localApplyUploadReqV3.bytes_sha.set(ByteStringMicro.copyFrom(paramaucr.jdField_c_of_type_ArrayOfByte));
    if (paramaucr.jdField_d_of_type_ArrayOfByte != null) {
      localApplyUploadReqV3.bytes_3sha.set(ByteStringMicro.copyFrom(paramaucr.jdField_d_of_type_ArrayOfByte));
    }
    localApplyUploadReqV3.uint32_contenttype.set(0);
    localApplyUploadReqV3.str_local_filepath.set(paramaucr.jdField_b_of_type_JavaLangString);
    localApplyUploadReqV3.uint32_danger_level.set(paramaucr.jdField_a_of_type_Int);
    localApplyUploadReqV3.uint64_total_space.set(paramaucr.jdField_d_of_type_Long);
    return localApplyUploadReqV3;
  }
  
  public void a()
  {
    face2face_file.msg localmsg = new face2face_file.msg();
    localmsg.version.set(1);
    localmsg.result.set(0);
    a("SafeCenterSvr.CMD_FACE2FACE_FLAG_REQ", localmsg.toByteArray(), null);
  }
  
  public void a(int paramInt1, int paramInt2, atib paramatib)
  {
    a(paramInt1, paramInt2, paramatib, 0);
  }
  
  public void a(int paramInt1, int paramInt2, atib paramatib, int paramInt3)
  {
    Object localObject = new cmd0x346.RecvListQueryReq();
    ((cmd0x346.RecvListQueryReq)localObject).uint64_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    ((cmd0x346.RecvListQueryReq)localObject).uint32_begin_index.set(paramInt1);
    ((cmd0x346.RecvListQueryReq)localObject).uint32_req_count.set(paramInt2);
    ((cmd0x346.RecvListQueryReq)localObject).uint32_filter_filetype.set(paramInt3);
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.msg_recv_list_query_req.set((MessageMicro)localObject);
    localReqBody.uint32_cmd.set(100);
    localObject = localReqBody.uint32_seq;
    paramInt1 = jdField_a_of_type_Int;
    jdField_a_of_type_Int = paramInt1 + 1;
    ((PBUInt32Field)localObject).set(paramInt1);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    if (a())
    {
      localReqBody.uint32_flag_support_mediaplatform.set(1);
      QLog.d("FileTransferHandler<FileAssistant>", 1, "queryRecvFileList: UseMediaPlatform enabled");
    }
    for (;;)
    {
      paramatib = new atia(this, paramatib);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECV_LIST-100", localReqBody.toByteArray(), paramatib, 10000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "queryRecvFileList: UseMediaPlatform not enabled");
    }
  }
  
  public void a(int paramInt1, int paramInt2, FileManagerEntity paramFileManagerEntity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardIntrlnal : uDstId[" + String.valueOf(paramFileManagerEntity.peerUin) + "], uDstUin[" + String.valueOf(paramFileManagerEntity.selfUin) + " nDstSvcId[" + String.valueOf(paramInt1) + " uFileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + " strFileName[" + String.valueOf(paramFileManagerEntity.fileName) + " strUuid[" + String.valueOf(paramFileManagerEntity.Uuid) + "]");
    }
    if ((paramFileManagerEntity.Uuid == null) || (paramFileManagerEntity.Uuid.length() < 1) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "uuid or selfUin is null!!!");
      }
      return;
    }
    Object localObject2 = new cmd0x346.ApplyCopyToReq();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().replace("+", "");
    ((cmd0x346.ApplyCopyToReq)localObject2).uint64_dst_id.set(Long.parseLong((String)localObject1));
    if ((paramInt1 == 106) || (paramInt1 == 102) || (paramInt1 == 104)) {
      ((cmd0x346.ApplyCopyToReq)localObject2).uint64_dst_id.set(Long.parseLong(paramFileManagerEntity.peerUin));
    }
    ((cmd0x346.ApplyCopyToReq)localObject2).uint32_dst_svcid.set(paramInt1);
    ((cmd0x346.ApplyCopyToReq)localObject2).uint64_src_uin.set(Long.parseLong((String)localObject1));
    ((cmd0x346.ApplyCopyToReq)localObject2).uint64_file_size.set(paramFileManagerEntity.fileSize);
    ((cmd0x346.ApplyCopyToReq)localObject2).str_file_name.set(paramFileManagerEntity.fileName);
    ((cmd0x346.ApplyCopyToReq)localObject2).bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    localObject1 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject1).msg_apply_copy_to_req.set((MessageMicro)localObject2);
    ((cmd0x346.ReqBody)localObject1).uint32_cmd.set(60100);
    localObject2 = ((cmd0x346.ReqBody)localObject1).uint32_seq;
    paramInt1 = jdField_a_of_type_Int;
    jdField_a_of_type_Int = paramInt1 + 1;
    ((PBUInt32Field)localObject2).set(paramInt1);
    ((cmd0x346.ReqBody)localObject1).uint32_business_id.set(paramInt2);
    ((cmd0x346.ReqBody)localObject1).uint32_client_type.set(104);
    paramFileManagerEntity = new atia(this, false, paramFileManagerEntity.nSessionId);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", ((cmd0x346.ReqBody)localObject1).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
  }
  
  public void a(int paramInt, FileManagerEntity paramFileManagerEntity)
  {
    a(paramInt, 3, paramFileManagerEntity);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt2, String paramString3, atqa paramatqa, long paramLong2, int paramInt3)
  {
    if (!a(paramatqa)) {
      return;
    }
    switch (paramInt1)
    {
    case 130: 
    case 132: 
    default: 
      QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramatqa.jdField_b_of_type_Long + "] handleOnLineFilePushMsg. error cmd:" + paramInt1);
      return;
    case 129: 
      QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramatqa.jdField_b_of_type_Long + "] handle cmd 0x81. request");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramatqa, paramLong2, paramInt3);
      return;
    case 131: 
      QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramatqa.jdField_b_of_type_Long + "] handle cmd 0x83. accept");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramString1, paramatqa.jdField_b_of_type_Long, 1);
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramatqa.jdField_b_of_type_Long + "] handle cmd 0x85. cancel.type:" + paramatqa.jdField_a_of_type_Short + " reason:" + paramatqa.jdField_b_of_type_Short);
    if (2 == paramatqa.jdField_a_of_type_Short)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramString1, paramatqa.jdField_b_of_type_Long, 2);
      return;
    }
    if (1 == paramatqa.jdField_a_of_type_Short)
    {
      if (57 == paramatqa.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramString1, paramatqa.jdField_b_of_type_Long, 5);
        return;
      }
      if (70 == paramatqa.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().b(paramString1, paramatqa.jdField_b_of_type_Long);
        return;
      }
      if (71 == paramatqa.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramString1, paramatqa.jdField_b_of_type_Long, 4);
        return;
      }
      if (5 == paramatqa.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramString1, paramatqa.jdField_b_of_type_Long, 2);
        return;
      }
      if (paramatqa.jdField_b_of_type_Short == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramString1, paramatqa.jdField_b_of_type_Long, 3);
        return;
      }
      if (58 == paramatqa.jdField_b_of_type_Short)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().b(paramString1, paramatqa.jdField_b_of_type_Long);
        return;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramatqa.jdField_b_of_type_Long + "] canceltype:1.unkonw reason:" + paramatqa.jdField_b_of_type_Short);
      return;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramatqa.jdField_b_of_type_Long + "] unknow canceltype:" + paramatqa.jdField_a_of_type_Short);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean, aucr paramaucr, atib paramatib, FileManagerEntity paramFileManagerEntity)
  {
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(paramInt);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    Object localObject = localReqBody.uint32_seq;
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    ((PBUInt32Field)localObject).set(i);
    QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^> [CS Step], SessionId[" + paramFileManagerEntity.nSessionId + "], send pb uMsgSubType[" + paramInt + "]");
    switch (paramInt)
    {
    default: 
      QLog.e("FileTransferHandler<FileAssistant>", 2, "=_= ^! SessionId[" + paramFileManagerEntity.nSessionId + "]send0x346Req, unknwon nCmdType:" + paramInt);
      return;
    case 1600: 
      localObject = a(paramaucr);
      localReqBody.msg_apply_upload_req_v2.set((MessageMicro)localObject);
      paramatib = new atia(this, paramaucr.jdField_a_of_type_Aucp.jdField_a_of_type_ArrayOfByte, null, paramaucr.jdField_a_of_type_Aucp.jdField_b_of_type_ArrayOfByte, paramatib);
      paramaucr = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600";
    }
    for (;;)
    {
      if (paramFileManagerEntity.tmpSessionType > 0L)
      {
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
        ((cmd0x346.ExtensionReq)localObject).uint64_type.set(paramFileManagerEntity.tmpSessionType);
        if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
          ((cmd0x346.ExtensionReq)localObject).bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
        }
        if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
          ((cmd0x346.ExtensionReq)localObject).str_dst_phonenum.set(paramFileManagerEntity.tmpSessionToPhone);
        }
        QLog.e("FileTransferHandler<FileAssistant>", 2, "=_= ^> SessionId[" + paramFileManagerEntity.nSessionId + "]send0x346Req, add TempInfo:" + paramFileManagerEntity.tmpSessionType);
        localReqBody.msg_extension_req.set((MessageMicro)localObject);
      }
      if (paramBoolean) {
        localReqBody.uint32_flag_support_mediaplatform.set(1);
      }
      a(paramaucr, localReqBody.toByteArray(), paramatib);
      return;
      localObject = a(paramaucr);
      localReqBody.msg_apply_upload_req_v3.set((MessageMicro)localObject);
      paramatib = new atia(this, paramaucr.jdField_a_of_type_Aucq.jdField_a_of_type_ArrayOfByte, paramaucr.jdField_a_of_type_Aucq.jdField_c_of_type_ArrayOfByte, null, paramatib);
      paramaucr = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700";
      continue;
      localObject = a(paramaucr);
      localReqBody.msg_apply_upload_hit_req_v2.set((MessageMicro)localObject);
      paramatib = new atia(this, paramaucr.jdField_a_of_type_Auco.jdField_a_of_type_ArrayOfByte, paramaucr.jdField_a_of_type_Auco.jdField_c_of_type_ArrayOfByte, null, paramatib);
      paramaucr = "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800";
    }
  }
  
  public void a(long paramLong1, String paramString1, long paramLong2, String paramString2, atib paramatib)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "getDiscFile : String[" + paramString2 + "], nDiscId[" + paramLong2 + "]");
    }
    paramString1 = new cmd0x345.ReqBody.SubCmd0x3ReqBody();
    paramString1.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    paramString1.str_file_id.set(paramString2);
    paramString1.uint64_disscus_uin.set(paramLong2);
    paramString1.uint32_costom_id.set(0);
    paramString2 = new cmd0x345.ReqBody();
    paramString2.msg_subcmd_0x3_req_body.set(paramString1);
    paramString2.uint32_sub_cmd.set(3);
    paramString1 = new atia(this, false, paramLong1, paramatib, 3);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString2.toByteArray(), paramString1);
  }
  
  public void a(long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    cmd0x345.ReqBody.SubCmd0x5ReqBody localSubCmd0x5ReqBody = new cmd0x345.ReqBody.SubCmd0x5ReqBody();
    localSubCmd0x5ReqBody.uint32_src_bus_id.set(106);
    localSubCmd0x5ReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom("/".getBytes()));
    localSubCmd0x5ReqBody.bytes_src_file_path.set(ByteStringMicro.copyFrom(paramString4.getBytes()));
    localSubCmd0x5ReqBody.uint32_dst_uin.set(Integer.parseInt(paramString1));
    localSubCmd0x5ReqBody.uint64_file_size.set(paramLong2);
    localSubCmd0x5ReqBody.uint32_from_uin.set(Integer.parseInt(paramString2));
    localSubCmd0x5ReqBody.str_file_name.set(paramString3);
    if ((paramString5 != null) && (paramString5.length() > 0)) {
      localSubCmd0x5ReqBody.bytes_md5.set(ByteStringMicro.copyFrom(paramString5.getBytes()));
    }
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x5_req_body.set(localSubCmd0x5ReqBody);
    paramString1.uint32_sub_cmd.set(6);
    paramString2 = new atia(this, false, paramLong1, null, 6);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, String paramString4, long paramLong3, long paramLong4, atib paramatib)
  {
    cmd0x345.ReqBody.SubCmd0x2ReqBody localSubCmd0x2ReqBody = new cmd0x345.ReqBody.SubCmd0x2ReqBody();
    int i = (int)Long.parseLong(paramString1);
    localSubCmd0x2ReqBody.uint32_disscus_uin.set(i);
    i = (int)Long.parseLong(paramString2);
    localSubCmd0x2ReqBody.uint32_sender_uin.set(i);
    localSubCmd0x2ReqBody.str_file_name.set(paramString3);
    localSubCmd0x2ReqBody.uint64_file_size.set(paramLong2);
    localSubCmd0x2ReqBody.str_file_id.set(paramString4);
    paramString1 = UUID.randomUUID().toString().replaceAll("-", "");
    localSubCmd0x2ReqBody.str_batch_id.set(paramString1);
    paramString1 = UUID.randomUUID().toString().replaceAll("-", "");
    localSubCmd0x2ReqBody.str_batch_item_id.set(paramString1);
    localSubCmd0x2ReqBody.uint64_time.set(bcrg.a());
    localSubCmd0x2ReqBody.uint32_busid.set(106);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong1);
    int j;
    if (paramString1 != null)
    {
      j = 0;
      paramString2 = new hummer_resv_21.ResvAttr();
      i = j;
      if (auea.a(paramString1.fileName) == 5)
      {
        i = j;
        if (!TextUtils.isEmpty(paramString1.strApkPackageName))
        {
          paramString3 = new hummer_resv_21.FileApkInfo();
          paramString3.str_package_name.set(paramString1.strApkPackageName);
          paramString3.str_version.set("");
          paramString2.file_apk_info.set(paramString3);
          i = 1;
        }
      }
      if (paramString1.nFileType != 0)
      {
        j = i;
        if (paramString1.nFileType != 2) {}
      }
      else
      {
        auea.d(paramString1);
        if ((paramString1.imgHeight <= 0) || (paramString1.imgWidth <= 0)) {
          break label420;
        }
        paramString3 = new hummer_resv_21.FileImgInfo();
        paramString3.uint32_file_height.set(paramString1.imgHeight);
        paramString3.uint32_file_width.set(paramString1.imgWidth);
        paramString2.file_image_info.set(paramString3);
        j = 1;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "send Disc Feeds setThumbSize height[" + paramString1.imgHeight + "], width[" + paramString1.imgWidth + "]");
      }
    }
    for (;;)
    {
      if (j != 0) {
        localSubCmd0x2ReqBody.bytes_pb_bytes_reserve.set(ByteStringMicro.copyFrom(paramString2.toByteArray()));
      }
      if ((paramLong4 != 0L) || (!QLog.isDevelopLevel())) {
        break;
      }
      throw new NullPointerException();
      label420:
      j = i;
      if (!paramString1.hasNoThumb()) {
        if (paramString1.nFileType != 0)
        {
          j = i;
          if (paramString1.nFileType != 2) {}
        }
        else
        {
          new Handler(Looper.getMainLooper()).postDelayed(new FileTransferHandler.12(this, paramString1), 1000L);
          j = i;
        }
      }
    }
    i = bcsc.a(paramLong4);
    localSubCmd0x2ReqBody.uint32_random.set(i);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x2_req_body.set(localSubCmd0x2ReqBody);
    paramString1.uint32_sub_cmd.set(2);
    QLog.i("FileTransferHandler<FileAssistant>", 2, "=_= ^ [Disc Feed]send Disc Feed[" + paramLong1 + "]");
    paramString2 = new atia(this, false, paramLong1, paramatib, 2);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(long paramLong, String paramString1, String paramString2, boolean paramBoolean, atib paramatib)
  {
    cmd0x346.ApplyDownloadReq localApplyDownloadReq = new cmd0x346.ApplyDownloadReq();
    localApplyDownloadReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localApplyDownloadReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    int i;
    if (paramBoolean)
    {
      i = 1;
      localApplyDownloadReq.uint32_owner_type.set(i);
      paramString1 = new cmd0x346.ReqBody();
      paramString1.msg_apply_download_req.set(localApplyDownloadReq);
      paramString1.uint32_cmd.set(1200);
      Object localObject = paramString1.uint32_seq;
      i = jdField_a_of_type_Int;
      jdField_a_of_type_Int = i + 1;
      ((PBUInt32Field)localObject).set(i);
      paramString1.uint32_business_id.set(3);
      paramString1.uint32_client_type.set(104);
      localObject = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject).uint32_download_url_type.set(1);
      paramString1.msg_extension_req.set((MessageMicro)localObject);
      if (!a()) {
        break label248;
      }
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        break label236;
      }
      localApplyDownloadReq.str_fileidcrc.set(paramString2);
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getC2CThumbDownloadInfo: UseMediaPlatform endabled");
    }
    for (;;)
    {
      paramString2 = new atia(this, paramLong, paramatib);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", paramString1.toByteArray(), paramString2);
      return;
      i = 2;
      break;
      label236:
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getC2CThumbDownloadInfo: UseMediaPlatform endabled but FileIdCrc is null");
      continue;
      label248:
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getC2CThumbDownloadInfo: UseMediaPlatform not enabled");
    }
  }
  
  public void a(atib paramatib, int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramatib != null)
    {
      Message localMessage = jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = paramInt;
      localMessage.obj = new Object[] { paramatib, Boolean.valueOf(paramBoolean), paramObject };
      localMessage.sendToTarget();
      QLog.i("FileTransferHandler<FileAssistant>", 1, "notifyUI. sendToTarget[" + paramBoolean + "] .type=" + paramInt);
      return;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find observer .type=" + paramInt);
  }
  
  public void a(aucv paramaucv, atib paramatib, FileManagerEntity paramFileManagerEntity)
  {
    aucr localaucr = a(paramaucv);
    paramFileManagerEntity.strFileSha3 = atrr.a(paramaucv.f);
    a(1L, paramaucv.jdField_a_of_type_Int, paramaucv.jdField_a_of_type_Boolean, localaucr, paramatib, paramFileManagerEntity);
  }
  
  public void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, im_msg_body.NotOnlineFile paramNotOnlineFile, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt, hummer_resv_21.FileImgInfo paramFileImgInfo)
  {
    a(paramMessageHandler, paramList, paramMsg, paramNotOnlineFile, paramString, paramBoolean1, paramBoolean2, paramLong, paramInt, paramFileImgInfo, null);
  }
  
  public void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, im_msg_body.NotOnlineFile paramNotOnlineFile, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt, hummer_resv_21.FileImgInfo paramFileImgInfo, hummer_resv_21.ResvAttr paramResvAttr)
  {
    bcse localbcse = null;
    if (paramMsg.msg_head.c2c_tmp_msg_head.has()) {
      localbcse = bcsu.a(paramMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    if (!paramNotOnlineFile.bytes_file_name.has()) {
      if (QLog.isColorLevel()) {
        QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_MsgType0x211 : NotOnlineFIle has not fileName");
      }
    }
    do
    {
      String str2;
      int i;
      long l4;
      int j;
      String str3;
      String str4;
      do
      {
        do
        {
          do
          {
            return;
            str2 = auea.a(paramNotOnlineFile.bytes_file_name.get().toStringUtf8());
            i = paramNotOnlineFile.uint32_file_type.get();
            l4 = paramNotOnlineFile.uint64_file_size.get();
            j = paramNotOnlineFile.uint32_subcmd.get();
            str3 = atrr.a(paramNotOnlineFile.bytes_file_md5.get().toByteArray());
            str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            if (paramNotOnlineFile.bytes_file_uuid.has())
            {
              localObject1 = paramNotOnlineFile.bytes_file_uuid.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("FileTransferHandler<FileAssistant>", 2, "offline file come, msgTime[" + l2 + "] msgSeq[" + s + "] msgUid[" + l1 + "]  fileName[" + str2 + "] uuid[" + (String)localObject1 + "] fileType[" + i + "] subCmd[" + j + "] strMd5[" + str3 + "]");
              }
            }
            if (i == 1)
            {
              a(paramList, paramString, paramBoolean1, paramBoolean2, paramLong, paramInt, paramFileImgInfo, l1, l2, s, str2, i, l4, String.valueOf(l3), str1);
              return;
            }
            if (paramNotOnlineFile.bytes_file_uuid.has()) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("FileTransferHandler<FileAssistant>", 2, "<---decodeC2CMsgPkg_MsgType0x211 : NotOnlineFIle has not uuid");
          return;
          str1 = new String(paramNotOnlineFile.bytes_file_uuid.get().toStringUtf8() + l2);
          if (QLog.isDevelopLevel()) {
            QLog.i("FileTransferHandler<FileAssistant>", 2, "offline file come:fileName[" + str2 + "]");
          }
          str4 = paramNotOnlineFile.bytes_file_uuid.get().toStringUtf8();
        } while (a(paramMessageHandler, paramBoolean2, str2, i, j, str1, str4));
        j = a(l3, paramNotOnlineFile, 0);
        if (j != 0) {
          ThreadManager.executeOnSubThread(new FileTransferHandler.3(this, paramString, j, s, l1, l2));
        }
      } while ((a(paramList, paramString, paramBoolean1, paramBoolean2, l1, l2, l3, s)) || (a(str4)));
      if (l4 == 0L) {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "<---decodeC2CMsgPkg_MsgType0x211:fileType[" + i + "], UUID[" + str4 + "], filename[" + str2 + "], fileSize[" + l4 + "]");
      }
      String str1 = null;
      if (paramNotOnlineFile.str_fileidcrc_media.has())
      {
        str1 = paramNotOnlineFile.str_fileidcrc_media.get();
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleOffLineFileMsg UUID[" + str4 + "], FileIdCrc[" + str1 + "], filename[" + str2 + "], fileSize[" + l4 + "]");
      }
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramResvAttr != null)
      {
        localObject1 = localObject2;
        if (paramResvAttr.file_apk_info.has()) {
          localObject1 = (hummer_resv_21.FileApkInfo)paramResvAttr.file_apk_info.get();
        }
      }
      a(paramMessageHandler, paramList, paramString, String.valueOf(l3), l2, s, paramBoolean1, paramBoolean2, i, str4, str1, str2, l4, j, paramLong, l1, str3, localbcse, paramInt, paramFileImgInfo, paramNotOnlineFile.bytes_pb_reserve.get().toByteArray(), paramNotOnlineFile.bytes_note.get().toStringUtf8(), (hummer_resv_21.FileApkInfo)localObject1);
    } while (((localbcse == null) || (localbcse.jdField_a_of_type_Int != 1024)) && (!nut.a(BaseApplicationImpl.getContext(), String.valueOf(l3))));
    bjyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, paramNotOnlineFile, paramMsg, localbcse);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardOfflineFile : PeerUin[" + auea.e(paramFileManagerEntity.peerUin) + "], FileUUID[" + paramFileManagerEntity.Uuid + "]");
    }
    if ((paramFileManagerEntity == null) || (TextUtils.isEmpty(paramFileManagerEntity.Uuid)))
    {
      QLog.e("FileTransferHandler<FileAssistant>", 2, "entity info error:" + auea.a(paramFileManagerEntity));
      return;
    }
    cmd0x346.ApplyForwardFileReq localApplyForwardFileReq = new cmd0x346.ApplyForwardFileReq();
    localApplyForwardFileReq.uint64_sender_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    Object localObject1 = paramFileManagerEntity.peerUin.replace("+", "");
    localApplyForwardFileReq.uint64_recver_uin.set(Long.parseLong((String)localObject1));
    localApplyForwardFileReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    localObject1 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject1).msg_apply_forward_file_req.set(localApplyForwardFileReq);
    ((cmd0x346.ReqBody)localObject1).uint32_cmd.set(700);
    Object localObject2 = ((cmd0x346.ReqBody)localObject1).uint32_seq;
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    ((PBUInt32Field)localObject2).set(i);
    ((cmd0x346.ReqBody)localObject1).uint32_business_id.set(3);
    ((cmd0x346.ReqBody)localObject1).uint32_client_type.set(104);
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
      localObject2 = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject2).uint64_id.set(3L);
      ((cmd0x346.ExtensionReq)localObject2).uint64_type.set(paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
        ((cmd0x346.ExtensionReq)localObject2).bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
      }
      if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
        ((cmd0x346.ExtensionReq)localObject2).str_dst_phonenum.set(paramFileManagerEntity.tmpSessionToPhone);
      }
      ((cmd0x346.ReqBody)localObject1).msg_extension_req.set((MessageMicro)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardOfflineFile : addtempinfo SessionType[" + paramFileManagerEntity.tmpSessionType + "], sessionId[" + paramFileManagerEntity.nSessionId + "]");
      }
    }
    if (a())
    {
      ((cmd0x346.ReqBody)localObject1).uint32_flag_support_mediaplatform.set(1);
      if ((paramFileManagerEntity.fileIdCrc != null) && (paramFileManagerEntity.fileIdCrc.length() > 0))
      {
        localApplyForwardFileReq.str_fileidcrc.set(paramFileManagerEntity.fileIdCrc);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "ForwardOfflineFile: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      paramFileManagerEntity = new atia(this, false, paramFileManagerEntity.nSessionId);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700", ((cmd0x346.ReqBody)localObject1).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "ForwardOfflineFile: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "ForwardOfflineFile: UseMediaPlatform not enabled");
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    cmd0x345.ReqBody.SubCmd0x6ReqBody localSubCmd0x6ReqBody = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
    localSubCmd0x6ReqBody.uint32_dst_bus_id.set(paramInt);
    localSubCmd0x6ReqBody.uint64_file_size.set(paramFileManagerEntity.fileSize);
    localSubCmd0x6ReqBody.bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    if ((paramFileManagerEntity.strFileMd5 != null) && (paramFileManagerEntity.strFileMd5.length() > 0)) {
      localSubCmd0x6ReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(paramFileManagerEntity.strFileMd5.getBytes()));
    }
    localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramFileManagerEntity.selfUin));
    Object localObject = paramFileManagerEntity.peerUin.replace("+", "");
    localSubCmd0x6ReqBody.uint64_dst_uin.set(Long.parseLong((String)localObject));
    localSubCmd0x6ReqBody.str_file_name.set(paramFileManagerEntity.fileName);
    localSubCmd0x6ReqBody.str_src_file_path.set(paramFileManagerEntity.Uuid);
    localSubCmd0x6ReqBody.str_src_parent_folder.set("/");
    localSubCmd0x6ReqBody.uint32_client_type.set(104);
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
      localSubCmd0x6ReqBody.uint64_app_id.set(3L);
      localSubCmd0x6ReqBody.uint64_talk_type.set(paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
        localSubCmd0x6ReqBody.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
      }
      if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
        localSubCmd0x6ReqBody.str_dst_phone_number.set(paramFileManagerEntity.tmpSessionToPhone);
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "ForwardDiscFile : addtempinfo SessionType[" + paramFileManagerEntity.tmpSessionType + "], sessionId[" + paramFileManagerEntity.nSessionId + "]");
      }
    }
    localObject = new cmd0x345.ReqBody();
    ((cmd0x345.ReqBody)localObject).msg_subcmd_0x6_req_body.set(localSubCmd0x6ReqBody);
    ((cmd0x345.ReqBody)localObject).uint32_sub_cmd.set(7);
    paramFileManagerEntity = new atia(this, false, paramFileManagerEntity.nSessionId, null, 7);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", ((cmd0x345.ReqBody)localObject).toByteArray(), paramFileManagerEntity, 30000, 3, 1);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, atpl paramatpl)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileTransferHandler<FileAssistant>", 2, "revertC2CFile ");
    }
    cmd0x346.RecallFileReq localRecallFileReq = new cmd0x346.RecallFileReq();
    localRecallFileReq.uint64_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    localRecallFileReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.msg_recall_file_req.set(localRecallFileReq);
    localReqBody.uint32_cmd.set(400);
    PBUInt32Field localPBUInt32Field = localReqBody.uint32_seq;
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    localPBUInt32Field.set(i);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    if (a())
    {
      localReqBody.uint32_flag_support_mediaplatform.set(1);
      if ((paramFileManagerEntity.fileIdCrc != null) && (paramFileManagerEntity.fileIdCrc.length() > 0))
      {
        localRecallFileReq.str_fileidcrc.set(paramFileManagerEntity.fileIdCrc);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "revertC2CFile: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      paramFileManagerEntity = new atia(this);
      atia.a(paramFileManagerEntity, paramatpl);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECALL-400", localReqBody.toByteArray(), paramFileManagerEntity, 10000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "revertC2CFile: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "revertC2CFile: UseMediaPlatform not enabled");
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, String paramString3, atib paramatib)
  {
    a(paramFileManagerEntity, paramString1, paramString2, paramString3, false, null, paramatib);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, atib paramatib)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "setUploadSuccState : selfUin[" + auea.e(paramString1) + "], toUin[" + auea.e(paramString2) + "], filePath[" + paramString3 + "]");
    }
    cmd0x346.UploadSuccReq localUploadSuccReq = new cmd0x346.UploadSuccReq();
    localUploadSuccReq.uint64_sender_uin.set(Long.parseLong(paramString1));
    paramString1 = paramString2.replace("+", "");
    localUploadSuccReq.uint64_recver_uin.set(Long.parseLong(paramString1));
    localUploadSuccReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    if (paramBoolean)
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString4 != null) && (paramString4.length() > 0))
      {
        localUploadSuccReq.str_fileidcrc.set(paramString4);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "setUploadSuccStateEx: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      paramString1.msg_upload_succ_req.set(localUploadSuccReq);
      paramString1.uint32_cmd.set(800);
      paramString2 = paramString1.uint32_seq;
      int i = jdField_a_of_type_Int;
      jdField_a_of_type_Int = i + 1;
      paramString2.set(i);
      paramString1.uint32_business_id.set(3);
      paramString1.uint32_client_type.set(104);
      if (paramFileManagerEntity.tmpSessionType > 0L)
      {
        paramString2 = new cmd0x346.ExtensionReq();
        paramString2.uint64_id.set(3L);
        paramString2.uint64_type.set(paramFileManagerEntity.tmpSessionType);
        if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
          paramString2.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
        }
        if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
          paramString2.str_dst_phonenum.set(paramFileManagerEntity.tmpSessionToPhone);
        }
        paramString1.msg_extension_req.set(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "setUploadSuccState : addtempinfo SessionType[" + paramFileManagerEntity.tmpSessionType + "], sessionId[" + paramFileManagerEntity.nSessionId + "]");
        }
      }
      paramFileManagerEntity = new atia(this, paramatib);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", paramString1.toByteArray(), paramFileManagerEntity, 30000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "setUploadSuccStateEx: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "setUploadSuccStateEx: UseMediaPlatform not enabled");
    }
  }
  
  public void a(ProtoReqManager.ProtoReq paramProtoReq)
  {
    paramProtoReq.callback = new athv(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().sendProtoReq(paramProtoReq);
  }
  
  public void a(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    atfp localatfp = new atfp();
    long l;
    boolean bool2;
    boolean bool1;
    int i;
    if (a(paramProtoResp))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      l = -100001L;
      bool2 = false;
      bool1 = false;
      if ((l != 0L) || (localatfp.jdField_c_of_type_JavaLangString != null) || (localatfp.jdField_b_of_type_JavaLangString != null)) {
        break label421;
      }
      i = 1;
      label91:
      if ((l != -91245L) && (l != -7010L)) {
        break label426;
      }
    }
    Object localObject2;
    label421:
    label426:
    for (int j = 1;; j = 0)
    {
      for (;;)
      {
        Object localObject1 = (atia)paramProtoReq.busiData;
        int k = ((atia)localObject1).b();
        if (((j == 0) && (i == 0)) || (k >= 3)) {
          break label432;
        }
        ((atia)localObject1).a();
        a(paramProtoReq.ssoCmd, paramProtoReq.reqBody, (atia)localObject1);
        return;
        if (paramProtoResp.resp.getResultCode() != 1000)
        {
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
          l = -100002L;
          bool2 = false;
          bool1 = false;
          break;
        }
        localObject1 = paramProtoResp.resp.getWupBuffer();
        localObject2 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject2).mergeFrom((byte[])localObject1);
          if (((cmd0x346.RspBody)localObject2).msg_apply_download_rsp.has()) {
            break label309;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: rspBody has not hasMsgApplyDownloadRsp");
          l = -100003L;
          bool2 = false;
          bool1 = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          l = -100003L;
          bool2 = false;
          bool1 = false;
        }
      }
      break;
      label309:
      if (((cmd0x346.RspBody)localObject2).uint32_flag_use_media_platform.has()) {
        if (((cmd0x346.RspBody)localObject2).uint32_flag_use_media_platform.get() == 1)
        {
          bool1 = true;
          label335:
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: bUseMediaPlatform " + bool1);
        }
      }
      for (;;)
      {
        atfp.a(localatfp, (cmd0x346.ApplyDownloadRsp)((cmd0x346.RspBody)localObject2).msg_apply_download_rsp.get(), bool1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        l = localatfp.jdField_a_of_type_Long;
        bool2 = true;
        break;
        bool1 = false;
        break label335;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadResp: bUseMediaPlatform false uint32_flag_use_media_platform not set");
        bool1 = false;
      }
      i = 0;
      break label91;
    }
    label432:
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("handleDownloadResp: return ").append(bool2).append(", retCode=").append(l).append(", retMsg=").append(localatfp.jdField_a_of_type_JavaLangString).append(", key=");
      if (localatfp.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro == null) {
        break label857;
      }
    }
    label857:
    for (paramProtoReq = localatfp.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro.toStringUtf8();; paramProtoReq = "")
    {
      QLog.d("FileTransferHandler<FileAssistant>", 2, paramProtoReq + ", strIP=" + localatfp.jdField_b_of_type_JavaLangString + ", port=" + localatfp.jdField_a_of_type_Short + ", strUrl=" + localatfp.jdField_c_of_type_JavaLangString + ", strHttpsDomain=" + localatfp.h + ", httpsPort=" + localatfp.jdField_b_of_type_Short);
      paramProtoReq = new Bundle();
      if (localatfp.h != null) {
        paramProtoReq.putString("strHttpsDomain", localatfp.h);
      }
      if (localatfp.i != null) {
        paramProtoReq.putString("IPv6Dns", localatfp.i);
      }
      paramProtoReq.putShort("httpsPort", localatfp.jdField_b_of_type_Short);
      if ((localatfp.jdField_b_of_type_JavaUtilList != null) && (localatfp.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll(localatfp.jdField_b_of_type_JavaUtilList);
        paramProtoReq.putStringArrayList("ipv6list", (ArrayList)localObject2);
      }
      a(localInvalidProtocolBufferMicroException.a(), 5006, bool2, new Object[] { Long.valueOf(l), localatfp.jdField_a_of_type_JavaLangString, localatfp.jdField_d_of_type_JavaLangString, localatfp.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, Boolean.valueOf(bool1), localatfp.jdField_b_of_type_JavaLangString, Short.valueOf(localatfp.jdField_a_of_type_Short), localatfp.jdField_c_of_type_JavaLangString, localatfp.jdField_a_of_type_JavaUtilList, Integer.valueOf(paramProtoResp.resp.getAppSeq()), localatfp.jdField_e_of_type_JavaLangString, localatfp.f, localatfp.g, Long.valueOf(localInvalidProtocolBufferMicroException.a()), paramProtoReq });
      return;
    }
  }
  
  public final void a(ToServiceMsg arg1, int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (???.extraData.containsKey(jdField_a_of_type_JavaLangString))
    {
      long l = ???.extraData.getLong(jdField_a_of_type_JavaLangString);
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        atib localatib = (atib)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(l));
        if (localatib != null)
        {
          ??? = jdField_a_of_type_AndroidOsHandler.obtainMessage();
          ???.what = paramInt;
          ???.obj = new Object[] { localatib, Boolean.valueOf(paramBoolean), paramObject };
          ???.sendToTarget();
          QLog.i("FileTransferHandler<FileAssistant>", 1, "notifyUI. sendToTarget. seq=" + l + ".type=" + paramInt);
          return;
        }
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find observer. seq=" + l + ".type=" + paramInt);
      return;
    }
    QLog.e("FileTransferHandler<FileAssistant>", 1, "notifyUI. not find seq_key. type=" + paramInt);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileTransferHandler<FileAssistant>", 2, "handleResponse : req is null");
      }
      return;
    }
    if (paramFromServiceMsg.isSuccess())
    {
      float f = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " during " + this.jdField_a_of_type_JavaTextDecimalFormat.format(f) + "sec.");
      }
    }
    if (paramToServiceMsg.getServiceCmd().equals("TransService.ReqOffFilePack"))
    {
      a(paramToServiceMsg, paramFromServiceMsg, (bcrp)a(paramToServiceMsg, paramFromServiceMsg));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "handleResponse : cmd " + paramToServiceMsg.getServiceCmd().hashCode() + "unknow");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, long paramLong)
  {
    boolean bool = true;
    long l2 = paramFromServiceMsg.getResultCode();
    long l1;
    if ((l2 == 1002L) || (l2 == 1013L))
    {
      l1 = -100001L;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleOffLineFileSendCCSuccess: resp is timeout[" + paramFromServiceMsg + "]");
      if (l1 != -100001L) {
        break label172;
      }
    }
    label172:
    for (int i = 1;; i = 0)
    {
      int j = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if ((i == 0) || (j >= 3)) {
        break label178;
      }
      paramToServiceMsg.extraData.putInt("retryIndex", j + 1);
      return;
      l1 = l2;
      if (l2 == 1000L) {
        break;
      }
      l1 = -100002L;
      bool = false;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleOffLineFileSendCCSuccess: resp is failed[" + paramFromServiceMsg + "]");
      break;
    }
    label178:
    l2 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
    if ((l2 != 0L) && (l2 != 241L))
    {
      bool = false;
      l1 = l2;
    }
    for (;;)
    {
      if ((bool) && (paramLong > 0L))
      {
        auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(paramLong);
        if (localObject != null)
        {
          l2 = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((FileManagerEntity)localObject).fileName);
          if (((FileManagerEntity)localObject).fileSize > l2) {
            break label406;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(((FileManagerEntity)localObject).peerType).a(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).uniseq);
          ((bedr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a((MessageRecord)localObject);
        }
      }
      for (;;)
      {
        l2 = paramToServiceMsg.extraData.getLong("uniseq");
        a(paramToServiceMsg, 5014, bool, new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Integer.valueOf(paramFromServiceMsg.getAppSeq()), Long.valueOf(paramLong), Long.valueOf(l2) });
        agfe.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2);
        return;
        label406:
        if (QLog.isColorLevel()) {
          QLog.e("AIOMessageSpreadManager", 1, "can't find File Msg sID:" + paramLong);
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramObject = (bcrp)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "onReceive, MessageConstants.CMD_TRANSSERVICE_REQOFFFILEPACK: " + paramObject.b);
    }
    switch (paramObject.b)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 1: 
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 2: 
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 3: 
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      long l = paramInt1;
      new Handler(localLooper).post(new FileTransferHandler.10(this, l, paramInt3, paramInt2, paramString));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramInt1 + "] Handle upload progress notify. speed=" + paramInt3 + " progress =" + paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramString, paramInt1, paramInt3, paramInt2);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      long l = paramInt1;
      new Handler(localLooper).post(new FileTransferHandler.9(this, l, paramInt2, paramString2, paramString1));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramInt1 + "] Handle upload failed notify. retCode =" + paramInt2 + "(1:cancel upload) reason=" + paramString2);
    if (1 == paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramString1, paramInt1);
      return;
    }
    if (2 == paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramString1, paramInt1);
      return;
    }
    if (3 == paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().c(paramString1, paramInt1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramString1, paramInt1);
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, String paramString2, long paramLong2)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FileTransferHandler.11(this, paramLong1, paramString1, paramInt, paramString2, paramLong2));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramLong1 + "] upload competed:");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramString1, paramLong1, paramInt, paramString2, paramLong2);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FileTransferHandler.6(this, paramLong, paramBoolean, paramString));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  handle recv onlinefile resp. sucess =" + paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramString, paramLong, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "PreviewOfflineFile : FileUUID[" + paramString1 + "]");
    }
    cmd0x346.ApplyDownloadAbsReq localApplyDownloadAbsReq = new cmd0x346.ApplyDownloadAbsReq();
    localApplyDownloadAbsReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localApplyDownloadAbsReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_apply_download_abs_req.set(localApplyDownloadAbsReq);
    paramString1.uint32_cmd.set(1100);
    PBUInt32Field localPBUInt32Field = paramString1.uint32_seq;
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    localPBUInt32Field.set(i);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    if (a())
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        localApplyDownloadAbsReq.str_fileidcrc.set(paramString2);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "PreviewOfflineFile: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      paramString2 = new atia(this);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100", paramString1.toByteArray(), paramString2, 30000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "PreviewOfflineFile: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "PreviewOfflineFile: UseMediaPlatform not enabled");
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "getOfflineVideoThumbInfo : FileUUID[" + paramString1 + "]");
    }
    cmd0x346.ApplyDownloadAbsReq localApplyDownloadAbsReq = new cmd0x346.ApplyDownloadAbsReq();
    localApplyDownloadAbsReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localApplyDownloadAbsReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_apply_download_abs_req.set(localApplyDownloadAbsReq);
    paramString1.uint32_cmd.set(1100);
    PBUInt32Field localPBUInt32Field = paramString1.uint32_seq;
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    localPBUInt32Field.set(i);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    if (a())
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        localApplyDownloadAbsReq.str_fileidcrc.set(paramString2);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "getOfflineVideoThumbInfo: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      paramString2 = new atia(this, true, paramLong);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100", paramString1.toByteArray(), paramString2, 30000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getOfflineVideoThumbInfo: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getOfflineVideoThumbInfo: UseMediaPlatform not enabled");
    }
  }
  
  public void a(String paramString1, String paramString2, BuddyTransfileProcessor.A9Message paramA9Message, long paramLong1, short paramShort, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "--->>getOffLineFile--toUin: " + paramString2 + " filePath: " + paramA9Message.serverPath + " delUin: " + paramLong2);
    }
    ToServiceMsg localToServiceMsg = a("TransService.ReqOffFilePack");
    localToServiceMsg.extraData.putString("selfuin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localToServiceMsg.extraData.putString("uin", paramString2);
    localToServiceMsg.extraData.putByteArray("filepath", paramA9Message.serverPath.getBytes());
    localToServiceMsg.extraData.putInt("offfile_type", 0);
    localToServiceMsg.extraData.putLong("msgTime", paramLong1);
    localToServiceMsg.extraData.putShort("msgSeq", paramShort);
    localToServiceMsg.extraData.putLong("delUin", paramLong2);
    localToServiceMsg.extraData.putByte("type", paramA9Message.type);
    localToServiceMsg.extraData.putInt("retryIndex", 0);
    localToServiceMsg.extraData.putString("friendUin", paramString1);
    localToServiceMsg.extraData.putBoolean("isRead", paramBoolean);
    b(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, atib paramatib)
  {
    cmd0x345.ReqBody.SubCmd0x1ReqBody localSubCmd0x1ReqBody = new cmd0x345.ReqBody.SubCmd0x1ReqBody();
    localSubCmd0x1ReqBody.str_md5.set(paramString1);
    localSubCmd0x1ReqBody.str_sha.set(paramString2);
    localSubCmd0x1ReqBody.str_file_name.set(paramString3);
    localSubCmd0x1ReqBody.uint64_file_size.set(paramLong);
    localSubCmd0x1ReqBody.uint32_upload_type.set(1);
    paramLong = Long.parseLong(paramString4);
    localSubCmd0x1ReqBody.uint32_disscus_uin.set((int)paramLong);
    paramLong = Long.parseLong(paramString5);
    localSubCmd0x1ReqBody.uint32_sender_uin.set((int)paramLong);
    localSubCmd0x1ReqBody.uint32_costom_id.set(0);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x1_req_body.set(localSubCmd0x1ReqBody);
    paramString1.uint32_sub_cmd.set(1);
    paramString2 = new atia(this, false, 0L, paramatib, 1);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, atpl paramatpl)
  {
    cmd0x345.ReqBody.SubCmd0xaReqBody localSubCmd0xaReqBody = new cmd0x345.ReqBody.SubCmd0xaReqBody();
    try
    {
      localSubCmd0xaReqBody.uint64_disscus_uin.set(Long.parseLong(paramString1));
      localSubCmd0xaReqBody.uint64_uin.set(Long.parseLong(paramString2));
      localSubCmd0xaReqBody.str_file_id.set(paramString3);
      paramString1 = new cmd0x345.ReqBody();
      paramString1.msg_subcmd_0xa_req_body.set(localSubCmd0xaReqBody);
      paramString1.uint32_sub_cmd.set(10);
      paramString2 = new atia(this);
      atia.a(paramString2, 10);
      atia.a(paramString2, paramatpl);
      a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      paramatpl.onError(-1, paramString1.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "RemoveOfflineFile : PeerUin[" + auea.e(paramString1) + "], FileUUID[" + paramString2 + "], bSend[" + paramBoolean + "]");
    }
    if (paramBoolean) {
      i = 1;
    }
    paramString4 = new cmd0x346.DeleteFileReq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      long l2 = Long.parseLong(paramString1);
      paramString4.uint64_uin.set(l1);
      paramString4.uint64_peer_uin.set(l2);
      paramString4.uint32_delete_type.set(i);
      paramString4.bytes_uuid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
      paramString1 = new cmd0x346.ReqBody();
      paramString1.msg_delete_file_req.set(paramString4);
      paramString1.uint32_cmd.set(900);
      PBUInt32Field localPBUInt32Field = paramString1.uint32_seq;
      i = jdField_a_of_type_Int;
      jdField_a_of_type_Int = i + 1;
      localPBUInt32Field.set(i);
      paramString1.uint32_business_id.set(3);
      paramString1.uint32_client_type.set(104);
      if (a())
      {
        paramString1.uint32_flag_support_mediaplatform.set(1);
        if ((paramString3 != null) && (paramString3.length() > 0))
        {
          paramString4.str_fileidcrc.set(paramString3);
          QLog.d("FileTransferHandler<FileAssistant>", 1, "RemoveOfflineFile: UseMediaPlatform enabled");
        }
      }
      for (;;)
      {
        paramString2 = new atia(this, paramString2);
        a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900", paramString1.toByteArray(), paramString2, 30000, 3, 1);
        return;
        QLog.d("FileTransferHandler<FileAssistant>", 1, "RemoveOfflineFile: UseMediaPlatform enabled but FileIdCrc is null");
        continue;
        QLog.d("FileTransferHandler<FileAssistant>", 1, "RemoveOfflineFile: UseMediaPlatform not enabled");
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, atib paramatib)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "setDownloadSuccState : selfUin[" + auea.e(paramString1) + "], filePath[" + paramString2 + "]");
    }
    cmd0x346.DownloadSuccReq localDownloadSuccReq = new cmd0x346.DownloadSuccReq();
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(paramString1));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_download_succ_req.set(localDownloadSuccReq);
    paramString1.uint32_cmd.set(1000);
    paramString2 = paramString1.uint32_seq;
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    paramString2.set(i);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    if (paramBoolean)
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString3 != null) && (paramString3.length() > 0))
      {
        localDownloadSuccReq.str_fileidcrc.set(paramString3);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "setDownloadSuccState: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      paramString2 = new atia(this, paramatib);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000", paramString1.toByteArray(), paramString2, 30000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "setDownloadSuccState: UseMediaPlatform enabled, but FileIdCrc is null");
      continue;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "setDownloadSuccState: UseMediaPlatform not enabled");
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, atib paramatib)
  {
    cmd0x346.ApplyDownloadReq localApplyDownloadReq = new cmd0x346.ApplyDownloadReq();
    localApplyDownloadReq.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localApplyDownloadReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    int i;
    if (paramBoolean1)
    {
      i = 1;
      localApplyDownloadReq.uint32_owner_type.set(i);
      if (paramBoolean2) {
        localApplyDownloadReq.uint32_need_https_url.set(1);
      }
      paramString1 = new cmd0x346.ReqBody();
      if (!a()) {
        break label250;
      }
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        break label238;
      }
      localApplyDownloadReq.str_fileidcrc.set(paramString2);
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getDownloadInfo: UseMediaPlatform enabled");
    }
    for (;;)
    {
      paramString1.msg_apply_download_req.set(localApplyDownloadReq);
      paramString1.uint32_cmd.set(1200);
      paramString2 = paramString1.uint32_seq;
      i = jdField_a_of_type_Int;
      jdField_a_of_type_Int = i + 1;
      paramString2.set(i);
      paramString1.uint32_business_id.set(3);
      paramString1.uint32_client_type.set(104);
      paramString2 = new cmd0x346.ExtensionReq();
      paramString2.uint32_download_url_type.set(1);
      paramString1.msg_extension_req.set(paramString2);
      paramString2 = new atia(this, paramatib);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", paramString1.toByteArray(), paramString2);
      return;
      i = 2;
      break;
      label238:
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getDownloadInfo: UseMediaPlatform enabled, but FileIdCrc is null");
      continue;
      label250:
      QLog.d("FileTransferHandler<FileAssistant>", 1, "getDownloadInfo: UseMediaPlatform not enabled");
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, atia paramatia)
  {
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.ssoCmd = paramString;
    localProtoReq.reqBody = paramArrayOfByte;
    localProtoReq.busiData = paramatia;
    a(localProtoReq);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, atia paramatia, int paramInt1, int paramInt2, int paramInt3)
  {
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.ssoCmd = paramString;
    localProtoReq.reqBody = paramArrayOfByte;
    localProtoReq.busiData = paramatia;
    localProtoReq.tryTime = paramInt1;
    localProtoReq.tryCount = paramInt2;
    localProtoReq.fixScheduleCount = paramInt3;
    a(localProtoReq);
  }
  
  protected boolean a()
  {
    return ((atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER)).h();
  }
  
  public boolean a(atqa paramatqa)
  {
    if (paramatqa != null)
    {
      if ((jdField_a_of_type_ArrayOfByte.equals(paramatqa.jdField_a_of_type_ArrayOfByte)) || (!paramatqa.jdField_a_of_type_Boolean)) {
        QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramatqa.jdField_b_of_type_Long + "]  is not surpport mulitendpoint");
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, FMTransC2CMsgInfo paramFMTransC2CMsgInfo)
  {
    paramFMTransC2CMsgInfo.subCmd = paramInt2;
    if (paramFMTransC2CMsgInfo.fileTransferObserver != null) {}
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramFMTransC2CMsgInfo.observerSeq = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_a_of_type_Long), paramFMTransC2CMsgInfo.fileTransferObserver);
      this.jdField_a_of_type_Long += 1L;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "send0x211c2cMsg transC2CMsgInfo:" + paramFMTransC2CMsgInfo.toString());
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(paramString, paramInt1, paramArrayOfByte, paramFMTransC2CMsgInfo);
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    atqa localatqa = new atqa();
    localatqa.jdField_a_of_type_ArrayOfByte = ((byte[])jdField_a_of_type_ArrayOfByte.clone());
    localatqa.jdField_a_of_type_Short = 4;
    localatqa.jdField_b_of_type_Long = paramLong;
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(localatqa);
    if (arrayOfByte == null)
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + localatqa.jdField_b_of_type_Long + "]. recvOnLineFile failed:");
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(paramString, paramLong, 133, arrayOfByte);
  }
  
  public boolean a(String paramString, FileManagerEntity paramFileManagerEntity, atib paramatib)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(paramString, 0, paramFileManagerEntity.uniseq);
    if (localObject1 != null)
    {
      paramFileManagerEntity.msgSeq = ((MessageRecord)localObject1).msgseq;
      paramFileManagerEntity.msgUid = ((MessageRecord)localObject1).msgUid;
    }
    localObject1 = new SubMsgType0x4.MsgBody();
    Object localObject2 = new im_msg_body.NotOnlineFile();
    ((im_msg_body.NotOnlineFile)localObject2).uint32_file_type.set(0);
    ((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    ((im_msg_body.NotOnlineFile)localObject2).uint64_file_size.set(paramFileManagerEntity.fileSize);
    ((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.set(ByteStringMicro.copyFrom(paramFileManagerEntity.fileName.getBytes()));
    if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
      ((im_msg_body.NotOnlineFile)localObject2).bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(paramFileManagerEntity.strFileMd5)));
    }
    ((im_msg_body.NotOnlineFile)localObject2).uint32_subcmd.set(1);
    if (paramFileManagerEntity.bUseMediaPlatform) {
      if ((paramFileManagerEntity.fileIdCrc != null) && (paramFileManagerEntity.fileIdCrc.length() > 0))
      {
        ((im_msg_body.NotOnlineFile)localObject2).str_fileidcrc_media.set(paramFileManagerEntity.fileIdCrc);
        QLog.d("FileTransferHandler<FileAssistant>", 1, "sendC2COfflineFileMsg: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      ((SubMsgType0x4.MsgBody)localObject1).msg_not_online_file.set((MessageMicro)localObject2);
      if (!TextUtils.isEmpty(paramFileManagerEntity.yybApkPackageName))
      {
        localObject2 = new hummer_resv_21.ResvAttr();
        hummer_resv_21.FileApkInfo localFileApkInfo = new hummer_resv_21.FileApkInfo();
        if (!TextUtils.isEmpty(paramFileManagerEntity.yybApkPackageName)) {
          localFileApkInfo.str_package_name.set(paramFileManagerEntity.yybApkPackageName);
        }
        if (!TextUtils.isEmpty(paramFileManagerEntity.yybApkName)) {
          localFileApkInfo.str_app_name.set(paramFileManagerEntity.yybApkName);
        }
        if (!TextUtils.isEmpty(paramFileManagerEntity.yybApkIconUrl)) {
          localFileApkInfo.str_icon_url.set(paramFileManagerEntity.yybApkIconUrl);
        }
        ((hummer_resv_21.ResvAttr)localObject2).file_apk_info.set(localFileApkInfo);
        ((SubMsgType0x4.MsgBody)localObject1).resv_attr.set((MessageMicro)localObject2);
      }
      ThreadManager.executeOnSubThread(new FileTransferHandler.7(this, paramFileManagerEntity, new hummer_resv_21.FileImgInfo(), (SubMsgType0x4.MsgBody)localObject1, paramatib, new Handler(Looper.getMainLooper()), paramString));
      return true;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "sendC2COfflineFileMsg: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "sendC2COfflineFileMsg: UseMediaPlatform not enabled");
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    Object localObject = new SubMsgType0x4.MsgBody();
    im_msg_body.NotOnlineFile localNotOnlineFile = new im_msg_body.NotOnlineFile();
    localNotOnlineFile.uint32_file_type.set(1);
    localNotOnlineFile.bytes_file_uuid.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    localNotOnlineFile.uint64_file_size.set(paramLong1);
    localNotOnlineFile.bytes_file_name.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    localNotOnlineFile.uint32_subcmd.set(2);
    ((SubMsgType0x4.MsgBody)localObject).msg_not_online_file.set(localNotOnlineFile);
    paramString2 = ((SubMsgType0x4.MsgBody)localObject).toByteArray();
    localObject = new FMTransC2CMsgInfo();
    ((FMTransC2CMsgInfo)localObject).busiType = 1029;
    ((FMTransC2CMsgInfo)localObject).uuid = paramString3;
    ((FMTransC2CMsgInfo)localObject).msgSeq = auea.a();
    ((FMTransC2CMsgInfo)localObject).msgUid = auea.b();
    return a(paramString1, 529, 4, paramString2, (FMTransC2CMsgInfo)localObject);
  }
  
  public byte[] a(atqa paramatqa)
  {
    if (paramatqa == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[1024];
    PkgTools.copyData(arrayOfByte, 0, paramatqa.jdField_a_of_type_ArrayOfByte, 16);
    PkgTools.DWord2Byte(arrayOfByte, 22, paramatqa.jdField_b_of_type_Long);
    PkgTools.Word2Byte(arrayOfByte, 28, paramatqa.jdField_a_of_type_Short);
    PkgTools.Word2Byte(arrayOfByte, 30, (short)1);
    arrayOfByte[32] = 1;
    PkgTools.Word2Byte(arrayOfByte, 35, (short)11);
    arrayOfByte[37] = 15;
    PkgTools.Word2Byte(arrayOfByte, 38, (short)1);
    arrayOfByte[40] = 1;
    arrayOfByte[41] = 16;
    PkgTools.Word2Byte(arrayOfByte, 42, (short)4);
    PkgTools.DWord2Byte(arrayOfByte, 44, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
    paramatqa = new byte[48];
    PkgTools.copyData(paramatqa, 0, arrayOfByte, 48);
    return paramatqa;
  }
  
  public atqa b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed context=null");
      return null;
    }
    int i = paramArrayOfByte.length;
    atqa localatqa = new atqa();
    int j;
    int k;
    if (i >= 16)
    {
      PkgTools.getBytesData(paramArrayOfByte, 0, localatqa.jdField_a_of_type_ArrayOfByte, 16);
      if (i < 26) {
        break label167;
      }
      localatqa.jdField_b_of_type_Long = PkgTools.getLongData(paramArrayOfByte, 22);
      if (i < 30) {
        break label178;
      }
      localatqa.jdField_a_of_type_Short = PkgTools.getShortData(paramArrayOfByte, 28);
      if (i < 32) {
        break label189;
      }
      j = PkgTools.getShortData(paramArrayOfByte, 30);
      if (j >= 2)
      {
        if (i < 34) {
          break label200;
        }
        localatqa.jdField_b_of_type_Short = PkgTools.getShortData(paramArrayOfByte, 32);
      }
      k = j + 32 + 2;
      if (i < k + 2) {
        break label211;
      }
      j = PkgTools.getShortData(paramArrayOfByte, k);
      if (j >= 4) {
        break label222;
      }
      localatqa.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      return localatqa;
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - bufAppGUID");
      return null;
      label167:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - dwSessionId");
      return null;
      label178:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wCancelType");
      return null;
      label189:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wReasonLen");
      return null;
      label200:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - bufReason");
      return null;
      label211:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decodeCancel failed - wContextDataLen");
      return null;
      label222:
      byte[] arrayOfByte = new byte[j];
      PkgTools.getBytesData(paramArrayOfByte, k + 2, arrayOfByte, j);
      i = 0;
      label240:
      int m;
      if (i < j)
      {
        k = arrayOfByte[i];
        m = i + 1;
        if (j <= m + 2) {
          break label304;
        }
        i = PkgTools.getShortData(arrayOfByte, m);
        m += 2;
        if (k != 15) {
          break label363;
        }
        if (i == 1) {
          break label316;
        }
        localatqa.jdField_a_of_type_Boolean = false;
      }
      for (;;)
      {
        i = m + i;
        break label240;
        break;
        label304:
        QLog.e("FileTransferHandler<FileAssistant>", 1, "decode Cancel or accept tlv error - L");
        break;
        label316:
        if (j >= m + i)
        {
          paramArrayOfByte = new byte[i];
          PkgTools.getBytesData(arrayOfByte, m, paramArrayOfByte, i);
          if (paramArrayOfByte[0] == 1) {}
          for (boolean bool = true;; bool = false)
          {
            localatqa.jdField_a_of_type_Boolean = bool;
            break;
          }
          label363:
          if (k == 4)
          {
            paramArrayOfByte = new byte[i];
            if (j < m + i) {
              break label421;
            }
            PkgTools.getBytesData(arrayOfByte, m, paramArrayOfByte, i);
            paramArrayOfByte = a(paramArrayOfByte);
            if (paramArrayOfByte == null) {
              break label433;
            }
            localatqa.jdField_a_of_type_JavaLangString = paramArrayOfByte.jdField_a_of_type_JavaLangString;
            localatqa.jdField_a_of_type_Long = paramArrayOfByte.jdField_a_of_type_Long;
          }
        }
      }
      label421:
      QLog.e("FileTransferHandler<FileAssistant>", 1, "decode request or accept tlv error - V");
    }
    label433:
    QLog.e("FileTransferHandler<FileAssistant>", 1, "decode fileinfo error for request or accept");
    return null;
  }
  
  public void b()
  {
    Object localObject1;
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("wifiphoto_smart_reminder", 0);
      l1 = ((SharedPreferences)localObject1).getLong("wifiphoto_smart_reminder_last_time", 0L);
      l2 = bcrg.a();
      if (l2 - l1 > 86400L)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putLong("wifiphoto_smart_reminder_last_time", l2);
        ((SharedPreferences.Editor)localObject1).commit();
        boolean bool = SystemUtil.isExistSDCard();
        l1 = SystemUtil.getSDCardAvailableSize();
        l2 = SystemUtil.getSystemAvailableSize();
        if ((!bool) || (l1 == 0L)) {
          break label716;
        }
        l1 = Math.min(l1, l2) * 1024L;
      }
    }
    for (;;)
    {
      l2 = auds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      if ((l1 <= 1073741824L) && (l2 >= 50L)) {
        localObject1 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("freeSize", l1);
        ((JSONObject)localObject1).put("deviceType", 2);
        ((JSONObject)localObject1).put("subtype", "8");
        ((JSONObject)localObject1).put("photoCount", l2);
        Object localObject2 = new SubMsgType0x7.MsgBody.GenericSubCmd();
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint64_sessionid.set(1L);
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_size.set(1);
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_index.set(0);
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_type.set(5);
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).bytes_buf.set(ByteStringMicro.copyFrom(((JSONObject)localObject1).toString().getBytes()));
        ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).setHasFlag(true);
        localObject1 = new SubMsgType0x7.MsgBody();
        ((SubMsgType0x7.MsgBody)localObject1).uint32_sub_cmd.set(4);
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_src_app_id.set(1001);
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_src_inst_id.set(AppSetting.a());
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_dst_app_id.set(1);
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint32_dst_inst_id.set(1);
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint64_dst_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.uint64_src_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
        ((SubMsgType0x7.MsgBody)localObject1).msg_header.setHasFlag(true);
        ((SubMsgType0x7.MsgBody)localObject1).msg_subcmd_0x4_generic.set((MessageMicro)localObject2);
        ((SubMsgType0x7.MsgBody)localObject1).setHasFlag(true);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        Object localObject3 = ((SubMsgType0x7.MsgBody)localObject1).toByteArray();
        localObject1 = a("MessageSvc.PbSendMsg");
        ((ToServiceMsg)localObject1).extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
        ((ToServiceMsg)localObject1).extraData.putInt("ROUNTING_TYPE", 13);
        ((ToServiceMsg)localObject1).extraData.putBoolean("ISFROM_DATALINE", true);
        ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_CMD", 1002);
        ((ToServiceMsg)localObject1).addAttribute("cookie", Integer.valueOf(1));
        ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_TRYINDEX", 0);
        l1 = auea.b();
        l2 = auea.a();
        bcsf localbcsf = new bcsf();
        localbcsf.jdField_a_of_type_Int = 7;
        localbcsf.jdField_a_of_type_ArrayOfByte = ((byte[])localObject3);
        localObject2 = bcrx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 13, (String)localObject2, localbcsf, l2, bcsc.b(l1));
        localObject3 = new im_msg_head.InstInfo();
        ((im_msg_head.InstInfo)localObject3).uint32_apppid.set(1);
        ((im_msg_head.InstInfo)localObject3).uint32_instid.set(1);
        ((im_msg_head.InstInfo)localObject3).setHasFlag(true);
        ((msg_svc.PbSendMsgReq)localObject2).routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add((MessageMicro)localObject3);
        localObject3 = new im_msg_head.InstInfo();
        ((im_msg_head.InstInfo)localObject3).uint32_apppid.set(1001);
        ((im_msg_head.InstInfo)localObject3).uint32_instid.set(AppSetting.a());
        ((im_msg_head.InstInfo)localObject3).setHasFlag(true);
        ((msg_svc.PbSendMsgReq)localObject2).routing_head.trans_0x211.inst_ctrl.msg_from_inst = ((im_msg_head.InstInfo)localObject3);
        ((msg_svc.PbSendMsgReq)localObject2).routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
        ((ToServiceMsg)localObject1).putWupBuffer(((msg_svc.PbSendMsgReq)localObject2).toByteArray());
        if (localObject1 != null)
        {
          ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService((ToServiceMsg)localObject1);
        }
        return;
        label716:
        l1 = 1024L * l2;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2, atib paramatib)
  {
    b(paramInt1, paramInt2, paramatib, 0);
  }
  
  public void b(int paramInt1, int paramInt2, atib paramatib, int paramInt3)
  {
    Object localObject = new cmd0x346.SendListQueryReq();
    ((cmd0x346.SendListQueryReq)localObject).uint64_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    ((cmd0x346.SendListQueryReq)localObject).uint32_begin_index.set(paramInt1);
    ((cmd0x346.SendListQueryReq)localObject).uint32_req_count.set(paramInt2);
    ((cmd0x346.SendListQueryReq)localObject).uint32_filter_filetype.set(paramInt3);
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.msg_send_list_query_req.set((MessageMicro)localObject);
    localReqBody.uint32_cmd.set(200);
    localObject = localReqBody.uint32_seq;
    paramInt1 = jdField_a_of_type_Int;
    jdField_a_of_type_Int = paramInt1 + 1;
    ((PBUInt32Field)localObject).set(paramInt1);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    if (a())
    {
      localReqBody.uint32_flag_support_mediaplatform.set(1);
      QLog.d("FileTransferHandler<FileAssistant>", 1, "querySendFileList: UseMediaPlatform enabled");
    }
    for (;;)
    {
      paramatib = new atia(this, paramatib);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_SEND_LIST-200", localReqBody.toByteArray(), paramatib, 10000, 3, 1);
      return;
      QLog.d("FileTransferHandler<FileAssistant>", 1, "querySendFileList: UseMediaPlatform not enabled");
    }
  }
  
  public void b(int paramInt1, String paramString1, String paramString2, long paramLong1, short paramShort, boolean paramBoolean, int paramInt2, String paramString3, atqa paramatqa, long paramLong2, int paramInt3)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FileTransferHandler.4(this, paramInt1, paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramatqa, paramLong2, paramInt3));
      return;
    }
    a(paramInt1, paramString1, paramString2, paramLong1, paramShort, paramBoolean, paramInt2, paramString3, paramatqa, paramLong2, paramInt3);
  }
  
  public void b(aucv paramaucv, atib paramatib, FileManagerEntity paramFileManagerEntity)
  {
    paramaucv = b(paramaucv);
    QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]SendOfflineFileHit");
    a(1L, 1800, false, paramaucv, paramatib, paramFileManagerEntity);
  }
  
  protected void b(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    athx localathx = new athx(this);
    boolean bool;
    if (a(paramProtoResp))
    {
      localathx.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      bool = false;
    }
    for (;;)
    {
      Object localObject = new anza();
      ((anza)localObject).jdField_b_of_type_Int = localathx.jdField_a_of_type_Int;
      ((anza)localObject).jdField_c_of_type_Int = paramProtoResp.freeRunnalbleIndex;
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleDownloadSuccResponse: return " + bool + ", retCode=" + localathx.jdField_a_of_type_Int + ", retMsg=" + localathx.jdField_a_of_type_JavaLangString + ", retStat" + localathx.jdField_c_of_type_Int);
      }
      a(((atia)paramProtoReq.busiData).a(), 5007, bool, new Object[] { localathx, localObject });
      return;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        localathx.jdField_a_of_type_Int = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
        bool = false;
      }
      else
      {
        localObject = paramProtoResp.resp.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
          if (localRspBody.msg_download_succ_rsp.has()) {
            break label344;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleDownloadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
          localathx.jdField_a_of_type_Int = -100003;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localathx.jdField_a_of_type_Int = -100003;
          bool = false;
        }
        continue;
        label344:
        cmd0x346.DownloadSuccRsp localDownloadSuccRsp = (cmd0x346.DownloadSuccRsp)localRspBody.msg_download_succ_rsp.get();
        if (localDownloadSuccRsp.int32_ret_code.has()) {
          localathx.jdField_a_of_type_Int = localDownloadSuccRsp.int32_ret_code.get();
        }
        if (localDownloadSuccRsp.str_ret_msg.has()) {
          localathx.jdField_a_of_type_JavaLangString = localDownloadSuccRsp.str_ret_msg.get();
        }
        if (localDownloadSuccRsp.int32_down_stat.has()) {
          localathx.jdField_c_of_type_Int = localDownloadSuccRsp.int32_down_stat.get();
        }
        bool = true;
      }
    }
  }
  
  public void b(String paramString, long paramLong, boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FileTransferHandler.8(this, paramLong, paramBoolean, paramString));
      return;
    }
    QLog.i("FileTransferHandler<FileAssistant>", 1, "OLfilesession[" + paramLong + "]  handle query onlinefile upload progress resp. sucess =" + paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().b(paramString, paramLong, paramBoolean);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "PreviewOfflineFile : FileUUID[" + paramString2 + "]");
    }
    cmd0x345.ReqBody.SubCmd0x7ReqBody localSubCmd0x7ReqBody = new cmd0x345.ReqBody.SubCmd0x7ReqBody();
    localSubCmd0x7ReqBody.uint64_disscus_uin.set(Long.parseLong(paramString1));
    localSubCmd0x7ReqBody.str_file_path.set(paramString2);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x7_req_body.set(localSubCmd0x7ReqBody);
    paramString1.uint32_sub_cmd.set(8);
    paramString2 = new atia(this, false, 0L, null, 8);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void b(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferHandler<FileAssistant>", 2, "getDiscVideoThumbInfo : FileUUID[" + paramString2 + "]");
    }
    cmd0x345.ReqBody.SubCmd0x7ReqBody localSubCmd0x7ReqBody = new cmd0x345.ReqBody.SubCmd0x7ReqBody();
    localSubCmd0x7ReqBody.uint64_disscus_uin.set(Long.parseLong(paramString1));
    localSubCmd0x7ReqBody.str_file_path.set(paramString2);
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x7_req_body.set(localSubCmd0x7ReqBody);
    paramString1.uint32_sub_cmd.set(8);
    paramString2 = new atia(this, true, paramLong, null, 8);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public boolean b(String paramString, long paramLong)
  {
    Object localObject = new SubMsgType0x5.MsgBody();
    ((SubMsgType0x5.MsgBody)localObject).uint32_sessionid.set((int)paramLong);
    localObject = ((SubMsgType0x5.MsgBody)localObject).toByteArray();
    FMTransC2CMsgInfo localFMTransC2CMsgInfo = new FMTransC2CMsgInfo();
    localFMTransC2CMsgInfo.sessionId = paramLong;
    localFMTransC2CMsgInfo.busiType = 1025;
    localFMTransC2CMsgInfo.msgSeq = auea.a();
    localFMTransC2CMsgInfo.msgUid = auea.b();
    localFMTransC2CMsgInfo.entity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong);
    return a(paramString, 529, 5, (byte[])localObject, localFMTransC2CMsgInfo);
  }
  
  protected void c(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    int i = 0;
    Object localObject1 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    short s = 0;
    Object localObject7 = "";
    int j;
    Object localObject2;
    Object localObject4;
    boolean bool;
    if (a(paramProtoResp))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      i = -100001;
      j = 0;
      paramProtoResp = null;
      localObject1 = null;
      localObject2 = null;
      localObject3 = null;
      localObject4 = null;
      bool = false;
    }
    label234:
    Object localObject8;
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handlePreviewResponse: return " + bool + ", retCode=" + i + ", retMsg=" + (String)localObject4 + ", Key=" + (String)localObject3 + ", IP=" + (String)localObject2 + ", Domain=" + (String)localObject1 + ", port=" + j + ", strHttpsDomain=" + (String)localObject6 + ", httpsPort=" + s + "ipv6Domain=" + (String)localObject7);
      }
      if (i != -100001) {
        break label996;
      }
      i = 9043;
      if (i != 0) {
        bool = false;
      }
      paramProtoReq = (atia)paramProtoReq.busiData;
      localObject8 = new Bundle();
      if (localObject6 != null) {
        ((Bundle)localObject8).putString("strHttpsDomain", (String)localObject6);
      }
      ((Bundle)localObject8).putShort("httpsPort", s);
      if (!TextUtils.isEmpty((CharSequence)localObject7)) {
        ((Bundle)localObject8).putString("IPv6Dns", (String)localObject7);
      }
      if (!paramProtoReq.a()) {
        break label1012;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(bool, 191, new Object[] { Integer.valueOf(i), localObject4, localObject5, localObject3, localObject2, localObject1, Integer.valueOf(j), paramProtoResp, Long.valueOf(paramProtoReq.a()), localObject8 });
      return;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
        i = -100002;
        j = 0;
        paramProtoResp = null;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        bool = false;
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject2 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject2).mergeFrom(paramProtoResp);
          if (((cmd0x346.RspBody)localObject2).msg_apply_download_abs_rsp.has()) {
            break;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: rspBody has not hasMsgApplyDownloadAbsRsp");
          i = -100003;
          j = 0;
          paramProtoResp = null;
          localObject1 = null;
          localObject2 = null;
          localObject3 = null;
          localObject4 = null;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          i = -100003;
          j = 0;
          paramProtoResp = null;
          localObject1 = null;
          localObject2 = null;
          localObject3 = null;
          localObject4 = null;
          bool = false;
        }
      }
    }
    Object localObject3 = (cmd0x346.ApplyDownloadAbsRsp)((cmd0x346.RspBody)localObject2).msg_apply_download_abs_rsp.get();
    if (((cmd0x346.ApplyDownloadAbsRsp)localObject3).int32_ret_code.has()) {
      i = ((cmd0x346.ApplyDownloadAbsRsp)localObject3).int32_ret_code.get();
    }
    if (((cmd0x346.ApplyDownloadAbsRsp)localObject3).str_ret_msg.has()) {}
    for (paramProtoResp = ((cmd0x346.ApplyDownloadAbsRsp)localObject3).str_ret_msg.get();; paramProtoResp = null)
    {
      if ((i == 0) && (!((cmd0x346.ApplyDownloadAbsRsp)localObject3).msg_download_info.has()))
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: rspBody has not MsgDownloadSuccRsp");
        i = -100003;
        bool = false;
        j = 0;
        localObject8 = null;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = paramProtoResp;
        paramProtoResp = (ProtoReqManager.ProtoResp)localObject8;
        break;
      }
      localObject3 = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadAbsRsp)localObject3).msg_download_info.get();
      localObject5 = ((cmd0x346.DownloadInfo)localObject3).str_download_ip.get();
      localObject4 = ((cmd0x346.DownloadInfo)localObject3).str_download_domain.get();
      j = ((cmd0x346.DownloadInfo)localObject3).uint32_port.get();
      String str = ((cmd0x346.DownloadInfo)localObject3).str_download_url.get();
      if (((cmd0x346.DownloadInfo)localObject3).str_cookie.has()) {
        localObject1 = "FTN5K=" + ((cmd0x346.DownloadInfo)localObject3).str_cookie.get();
      }
      bool = false;
      if (((cmd0x346.RspBody)localObject2).uint32_flag_use_media_platform.has()) {
        if (((cmd0x346.RspBody)localObject2).uint32_flag_use_media_platform.get() == 1)
        {
          bool = true;
          label810:
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: bUseMediaPlatform " + bool);
          label837:
          if (!bool) {
            break label983;
          }
          localObject2 = ((cmd0x346.DownloadInfo)localObject3).bytes_media_platform_download_key.get();
          label852:
          localObject6 = HexUtil.bytes2HexStr(((ByteStringMicro)localObject2).toByteArray());
          if (!((cmd0x346.DownloadInfo)localObject3).str_https_download_domain.has()) {
            break label1096;
          }
        }
      }
      label1096:
      for (localObject2 = ((cmd0x346.DownloadInfo)localObject3).str_https_download_domain.get();; localObject2 = null)
      {
        if (((cmd0x346.DownloadInfo)localObject3).uint32_https_port.has()) {}
        for (s = (short)((cmd0x346.DownloadInfo)localObject3).uint32_https_port.get();; s = 0)
        {
          if (((cmd0x346.DownloadInfo)localObject3).str_download_dns.has()) {}
          for (localObject3 = ((cmd0x346.DownloadInfo)localObject3).str_download_dns.get();; localObject3 = "")
          {
            localObject7 = localObject3;
            localObject3 = localObject6;
            bool = true;
            localObject6 = localObject2;
            localObject2 = localObject5;
            localObject8 = paramProtoResp;
            localObject5 = localObject1;
            paramProtoResp = str;
            localObject1 = localObject4;
            localObject4 = localObject8;
            break;
            bool = false;
            break label810;
            QLog.i("FileTransferHandler<FileAssistant>", 1, "handlePreviewResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
            break label837;
            label983:
            localObject2 = ((cmd0x346.DownloadInfo)localObject3).bytes_download_key.get();
            break label852;
            label996:
            if (i == -100003)
            {
              i = 9045;
              break label234;
              label1012:
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(bool, 18, new Object[] { Integer.valueOf(i), localObject4, localObject5, localObject3, localObject2, localObject1, Integer.valueOf(j), localObject8 });
              return;
            }
            break label234;
          }
        }
      }
    }
  }
  
  protected void d(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    int i = 0;
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    long l1 = 0L;
    long l2 = 0L;
    boolean bool2;
    boolean bool1;
    if (a(paramProtoResp))
    {
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      l1 = 0L;
      l2 = 0L;
      localObject1 = null;
      bool2 = false;
      paramProtoResp = null;
      i = -100001;
      bool1 = false;
    }
    long l3;
    for (;;)
    {
      if (i != 0) {
        bool1 = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleForwardResponse: return " + bool1 + ", retCode=" + i + ", retMsg=" + paramProtoResp + ", totalSpace=" + l2 + ", usedSpace=" + l1);
      }
      l3 = ((atia)paramProtoReq.busiData).a();
      if (bool1)
      {
        paramProtoReq = new audz();
        paramProtoReq.jdField_b_of_type_JavaLangString = "send_file_suc";
        paramProtoReq.jdField_a_of_type_Int = 1;
        audy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramProtoReq);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(bool1, i, paramProtoResp, (String)localObject2, bool2, (String)localObject1, l3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(bool1, 19, new Object[] { Integer.valueOf(i), paramProtoResp, Long.valueOf(l2), Long.valueOf(l1), localObject2, Long.valueOf(l3) });
      paramProtoReq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l3);
      if (paramProtoReq != null)
      {
        auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramProtoReq);
        if ((paramProtoReq.nOpType != 26) && (paramProtoReq.nOpType != 27)) {}
      }
      try
      {
        ((auez)paramProtoReq.mContext).a(bool1, paramProtoReq.strTroopFileUuid, paramProtoReq.nSessionId, i, paramProtoResp, String.valueOf(paramProtoReq.peerUin), (String)localObject2);
        return;
      }
      catch (Exception paramProtoReq)
      {
        Object localObject5;
        paramProtoReq.printStackTrace();
        QLog.e("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: Exception is " + paramProtoReq.toString());
      }
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
        l1 = 0L;
        l2 = 0L;
        localObject1 = null;
        bool2 = false;
        paramProtoResp = null;
        i = -100002;
        bool1 = false;
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject5 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject5).mergeFrom(paramProtoResp);
          if (((cmd0x346.RspBody)localObject5).msg_apply_forward_file_rsp.has()) {
            break;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse rspBody has not hasMsgApplyForwardFileRsp");
          l1 = 0L;
          l2 = 0L;
          localObject1 = null;
          bool2 = false;
          paramProtoResp = null;
          i = -100003;
          bool1 = false;
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          l1 = 0L;
          l2 = 0L;
          localObject1 = null;
          bool2 = false;
          paramProtoResp = null;
          i = -100003;
          bool1 = false;
        }
      }
    }
    if (((cmd0x346.RspBody)localObject5).uint32_flag_use_media_platform.has()) {
      if (((cmd0x346.RspBody)localObject5).uint32_flag_use_media_platform.get() == 1)
      {
        bool1 = true;
        label573:
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: bUseMediaPlatform " + bool1);
      }
    }
    for (;;)
    {
      localObject5 = (cmd0x346.ApplyForwardFileRsp)((cmd0x346.RspBody)localObject5).msg_apply_forward_file_rsp.get();
      if (((cmd0x346.ApplyForwardFileRsp)localObject5).int32_ret_code.has()) {
        i = ((cmd0x346.ApplyForwardFileRsp)localObject5).int32_ret_code.get();
      }
      paramProtoResp = localObject4;
      if (((cmd0x346.ApplyForwardFileRsp)localObject5).str_ret_msg.has()) {
        paramProtoResp = ((cmd0x346.ApplyForwardFileRsp)localObject5).str_ret_msg.get();
      }
      if (((cmd0x346.ApplyForwardFileRsp)localObject5).bytes_uuid.has()) {
        localObject1 = new String(((cmd0x346.ApplyForwardFileRsp)localObject5).bytes_uuid.get().toByteArray());
      }
      localObject2 = localObject3;
      if (bool1)
      {
        localObject2 = localObject3;
        if (((cmd0x346.ApplyForwardFileRsp)localObject5).str_fileidcrc.has()) {
          localObject2 = ((cmd0x346.ApplyForwardFileRsp)localObject5).str_fileidcrc.get();
        }
      }
      if (((cmd0x346.ApplyForwardFileRsp)localObject5).uint64_total_space.has()) {
        l1 = ((cmd0x346.ApplyForwardFileRsp)localObject5).uint64_total_space.get();
      }
      if (((cmd0x346.ApplyForwardFileRsp)localObject5).uint64_used_space.has()) {
        l2 = ((cmd0x346.ApplyForwardFileRsp)localObject5).uint64_used_space.get();
      }
      l3 = l1;
      localObject3 = localObject2;
      bool2 = bool1;
      bool1 = true;
      localObject2 = localObject1;
      localObject1 = localObject3;
      l1 = l2;
      l2 = l3;
      break;
      bool1 = false;
      break label573;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
      bool1 = false;
    }
  }
  
  protected void e(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    int i = -100003;
    boolean bool;
    if (a(paramProtoResp))
    {
      i = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      localObject1 = null;
      paramProtoResp = null;
      bool = false;
    }
    long l;
    for (;;)
    {
      if (i != 0) {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferHandler<FileAssistant>", 2, "handleForwardFromOfflineResponse: return " + bool + ", retCode=" + i + ", retMsg=" + paramProtoResp);
      }
      l = ((atia)paramProtoReq.busiData).a();
      paramProtoReq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l);
      if (paramProtoReq != null) {
        break label378;
      }
      QLog.e("FileTransferHandler<FileAssistant>", 1, "forward offline file, but entity is null!!!");
      return;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        i = -100002;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
        localObject1 = null;
        paramProtoResp = null;
        bool = false;
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject1 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject1).mergeFrom(paramProtoResp);
          if (((cmd0x346.RspBody)localObject1).msg_apply_copy_to_rsp.has()) {
            break;
          }
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleForwardFromOfflineResponse rspBody has not hasMsgApplyDownloadAbsRsp");
          localObject1 = null;
          paramProtoResp = null;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          localObject1 = null;
          paramProtoResp = null;
          bool = false;
        }
      }
    }
    Object localObject1 = (cmd0x346.ApplyCopyToRsp)((cmd0x346.RspBody)localObject1).msg_apply_copy_to_rsp.get();
    if (((cmd0x346.ApplyCopyToRsp)localObject1).int32_ret_code.has()) {}
    for (i = ((cmd0x346.ApplyCopyToRsp)localObject1).int32_ret_code.get();; i = 0)
    {
      if (((cmd0x346.ApplyCopyToRsp)localObject1).str_ret_msg.has()) {}
      for (paramProtoResp = ((cmd0x346.ApplyCopyToRsp)localObject1).str_ret_msg.get();; paramProtoResp = null)
      {
        if (((cmd0x346.ApplyCopyToRsp)localObject1).str_file_key.has()) {}
        for (localObject1 = ((cmd0x346.ApplyCopyToRsp)localObject1).str_file_key.get();; localObject1 = null)
        {
          bool = true;
          break;
          label378:
          Object localObject2;
          if (bool)
          {
            localObject2 = new audz();
            ((audz)localObject2).jdField_b_of_type_JavaLangString = "send_file_suc";
            ((audz)localObject2).jdField_a_of_type_Int = 1;
            audy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (audz)localObject2);
          }
          if ((i == -6101) || (i == -7003))
          {
            paramProtoReq.status = 16;
            if ((paramProtoReq.mContext != null) && ((paramProtoReq.mContext instanceof FileManagerEntity)))
            {
              localObject2 = (FileManagerEntity)paramProtoReq.mContext;
              ((FileManagerEntity)localObject2).status = 16;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c((FileManagerEntity)localObject2);
              paramProtoReq.mContext = null;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramProtoReq);
          }
          a(l, bool, i, paramProtoResp, (String)localObject1, paramProtoReq);
          return;
        }
      }
    }
  }
  
  public void f(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^> [CS Replay]reponse V3");
    athx localathx = new athx(this);
    List localList = null;
    boolean bool;
    int i;
    label106:
    int j;
    label126:
    Object localObject;
    if (a(paramProtoResp))
    {
      localathx.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      bool = false;
      localathx.jdField_d_of_type_Int = 2;
      if ((localathx.jdField_b_of_type_JavaLangString == null) || (localathx.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label631;
      }
      i = 1;
      if ((localathx.jdField_a_of_type_ArrayOfByte != null) && (localathx.jdField_a_of_type_ArrayOfByte.length != 0)) {
        break label636;
      }
      j = 1;
      localObject = new anza();
      ((anza)localObject).jdField_b_of_type_Int = localathx.jdField_a_of_type_Int;
      ((anza)localObject).jdField_c_of_type_Int = paramProtoResp.freeRunnalbleIndex;
      if ((j == 0) || (i == 0)) {
        break label642;
      }
      localathx.jdField_a_of_type_JavaLangString = ("uuid_null[" + localathx.toString() + "]");
      bool = false;
    }
    label642:
    for (;;)
    {
      cmd0x346.RspBody localRspBody;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool + ", retCode=" + localathx.jdField_a_of_type_Int + ", retMsg=" + localathx.jdField_a_of_type_JavaLangString + ", totalSpace=" + localathx.jdField_a_of_type_Long + ", usedSpace=" + localathx.jdField_b_of_type_Long + ", ip=" + localathx.jdField_b_of_type_JavaLangString + ", port=" + localathx.jdField_a_of_type_Short);
        }
        a(((atia)paramProtoReq.busiData).a(), 5004, bool, new Object[] { localathx, localObject, localList });
        return;
        if (paramProtoResp.resp.getResultCode() != 1000)
        {
          localathx.jdField_a_of_type_Int = -100002;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
          bool = false;
          break;
        }
        localObject = paramProtoResp.resp.getWupBuffer();
        localathx.jdField_d_of_type_ArrayOfByte = ((byte[])localObject);
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
          if (localRspBody.msg_apply_upload_rsp_v3.has()) {
            break label510;
          }
          localathx.jdField_a_of_type_Int = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localathx.jdField_a_of_type_Int = -100003;
          bool = false;
        }
      }
      break;
      label510:
      if (localRspBody.uint32_flag_use_media_platform.has()) {
        if (localRspBody.uint32_flag_use_media_platform.get() == 1)
        {
          bool = true;
          localathx.jdField_b_of_type_Boolean = bool;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponseV3: bUseMediaPlatform " + localathx.jdField_b_of_type_Boolean);
        }
      }
      for (;;)
      {
        label536:
        localList = a(localathx, null, (cmd0x346.ApplyUploadRspV3)localRspBody.msg_apply_upload_rsp_v3.get());
        if (localathx.jdField_a_of_type_Int != 0) {
          break label625;
        }
        bool = true;
        break;
        bool = false;
        break label536;
        QLog.i("FileTransferHandler<FileAssistant>", 1, "handleUploadResponseV3: bUseMediaPlatform false uint32_flag_use_media_platform not set");
      }
      label625:
      bool = false;
      break;
      label631:
      i = 0;
      break label106;
      label636:
      j = 0;
      break label126;
    }
  }
  
  public void g(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    QLog.e("FileTransferHandler<FileAssistant>", 2, "=_= ^> [CS Replay]response V2");
    athx localathx = new athx(this);
    List localList = null;
    boolean bool;
    int i;
    label100:
    int j;
    label120:
    Object localObject;
    if (a(paramProtoResp))
    {
      localathx.jdField_a_of_type_Int = -100001;
      QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      bool = false;
      if ((localathx.jdField_b_of_type_JavaLangString == null) || (localathx.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label530;
      }
      i = 1;
      if ((localathx.jdField_a_of_type_ArrayOfByte != null) && (localathx.jdField_a_of_type_ArrayOfByte.length != 0)) {
        break label535;
      }
      j = 1;
      localObject = new anza();
      ((anza)localObject).jdField_b_of_type_Int = localathx.jdField_a_of_type_Int;
      ((anza)localObject).jdField_c_of_type_Int = paramProtoResp.freeRunnalbleIndex;
      if ((j == 0) || (i == 0)) {
        break label541;
      }
      localathx.jdField_a_of_type_JavaLangString = ("uuid_null[" + localathx.toString() + "]");
      bool = false;
    }
    label530:
    label535:
    label541:
    for (;;)
    {
      cmd0x346.RspBody localRspBody;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileTransferHandler<FileAssistant>", 2, "decodeOffFilePBResponse:return " + bool + ", retCode=" + localathx.jdField_a_of_type_Int + ", retMsg=" + localathx.jdField_a_of_type_JavaLangString + ", totalSpace=" + localathx.jdField_a_of_type_Long + ", usedSpace=" + localathx.jdField_b_of_type_Long + ", ip=" + localathx.jdField_b_of_type_JavaLangString + ", port=" + localathx.jdField_a_of_type_Short);
        }
        a(((atia)paramProtoReq.busiData).a(), 5004, bool, new Object[] { localathx, localObject, localList });
        return;
        if (paramProtoResp.resp.getResultCode() != 1000)
        {
          localathx.jdField_a_of_type_Int = -100002;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
          bool = false;
          break;
        }
        localObject = paramProtoResp.resp.getWupBuffer();
        localathx.jdField_d_of_type_ArrayOfByte = ((byte[])localObject);
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom((byte[])localObject);
          if (localRspBody.msg_apply_upload_rsp_v2.has()) {
            break label504;
          }
          localathx.jdField_a_of_type_Int = -100003;
          QLog.i("FileTransferHandler<FileAssistant>", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          localathx.jdField_a_of_type_Int = -100003;
          bool = false;
        }
      }
      break;
      label504:
      localList = a(localathx, null, (cmd0x346.ApplyUploadRspV2)localRspBody.msg_apply_upload_rsp_v2.get());
      bool = true;
      break;
      i = 0;
      break label100;
      j = 0;
      break label120;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atht
 * JD-Core Version:    0.7.0.1
 */