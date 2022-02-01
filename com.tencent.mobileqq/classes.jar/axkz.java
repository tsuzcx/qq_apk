import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpAROcrInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpAROcrResult;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpCardV2;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpClientRequestBodyV2;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpDeviceV2;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpServerResponseBodyV2;
import tencent.im.cs.cmd0x6ff.subcmd0x533.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x533.RspBody;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.msg.im_msg_head.LoginSig;
import tencent.im.oidb.cmd0x990.oidb_0x990.BatchTranslateReq;
import tencent.im.oidb.cmd0x990.oidb_0x990.BatchTranslateRsp;
import tencent.im.oidb.cmd0x990.oidb_0x990.ReqBody;
import tencent.im.oidb.cmd0x990.oidb_0x990.RspBody;
import tencent.im.oidb.cmd0x990.oidb_0x990.TranslateRsp;

public class axkz
  extends BusinessHandler
{
  private static int a;
  public static boolean a;
  
  public axkz(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static int a()
  {
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    return i;
  }
  
  private void a(int paramInt, Intent paramIntent, byte[] paramArrayOfByte)
  {
    String str;
    long l;
    if (paramIntent != null)
    {
      str = paramIntent.getStringExtra("param_sougou_sessionid");
      l = paramIntent.getLongExtra("param_starttime", 0L);
    }
    for (;;)
    {
      OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = null;
      if (paramInt == 0) {}
      int i;
      int j;
      try
      {
        paramIntent = new subcmd0x533.RspBody();
        paramIntent.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (subcmd0x533.HttpServerResponseBodyV2)((subcmd0x533.HttpAROcrResult)paramIntent.msg_ocr_result.get()).msg_sougou_rsp.get();
        if (paramArrayOfByte.has()) {
          i = paramArrayOfByte.int32_tencent_errorcode.get();
        }
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          label94:
          label239:
          boolean bool;
          i = 0;
          j = 0;
          paramArrayOfByte = localException;
        }
      }
      try
      {
        if (paramArrayOfByte.has())
        {
          j = paramArrayOfByte.int32_sougou_errorcode.get();
          if ((i != 0) || (j != 0)) {
            break label492;
          }
        }
      }
      catch (Exception paramIntent)
      {
        k = 0;
        j = i;
        i = k;
        paramArrayOfByte = localException;
        break label239;
      }
      try
      {
        paramIntent = new ArrayList();
        try
        {
          paramArrayOfByte = paramArrayOfByte.rpt_msg_cards.get().iterator();
          while (paramArrayOfByte.hasNext())
          {
            localSougouSearchInfo = OCRTextSearchInfo.a(((subcmd0x533.HttpCardV2)paramArrayOfByte.next()).rpt_msg_card_properties.get());
            if ((!TextUtils.isEmpty(localSougouSearchInfo.title)) || (!TextUtils.isEmpty(localSougouSearchInfo.abstractStr)))
            {
              paramIntent.add(localSougouSearchInfo);
              if (QLog.isColorLevel()) {
                QLog.d("Q.ocr.OCRHandler", 2, "handleSougouReqBigDataRsp info, " + localSougouSearchInfo);
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break label254;
          }
        }
        catch (Exception localException)
        {
          paramArrayOfByte = paramIntent;
          paramIntent = localException;
          k = j;
          j = i;
          i = k;
        }
      }
      catch (Exception paramIntent)
      {
        k = i;
        i = j;
        j = k;
        paramArrayOfByte = localException;
        break label239;
        j = 0;
        i = 0;
        break label292;
      }
      QLog.e("Q.ocr.OCRHandler", 2, "handleSougouReqBigDataRsp error", paramIntent);
      label254:
      int k = 0;
      paramIntent = paramArrayOfByte;
      bool = false;
      label262:
      notifyUI(1, bool, new Object[] { str, paramIntent });
      if (paramInt != 0)
      {
        i = 1;
        j = paramInt;
        label292:
        paramArrayOfByte = new HashMap();
        l = SystemClock.elapsedRealtime() - l;
        paramArrayOfByte.put("interval_time", String.valueOf(l));
        if (j != 0) {
          break label624;
        }
      }
      label492:
      label624:
      for (paramIntent = Integer.toString(j);; paramIntent = i + "_" + j)
      {
        paramArrayOfByte.put("param_FailCode", paramIntent);
        paramArrayOfByte.put("failReason", Integer.toString(j));
        paramArrayOfByte.put("errCodeType", Integer.toString(i));
        StatisticCollector.getInstance(this.mApp.getApplication()).collectPerformance(this.app.getCurrentAccountUin(), "ocrTextSearch", bool, l, 0L, paramArrayOfByte, "");
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.OCRHandler", 2, "handleSougouReqBigDataRsp,errCode:" + paramInt + ", isSucc:" + bool + ", failCodeStr:" + paramIntent + ", size=" + k);
        }
        return;
        i = -1;
        break;
        j = -1;
        break label94;
        k = paramIntent.size();
        bool = true;
        for (;;)
        {
          m = i;
          i = j;
          j = m;
          break;
          bool = false;
          if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.OCRHandler", 2, "handleSougouReqBigDataRsp error, tencentCode=" + i + ",sougouErrCode=" + j + ",tencentDes=" + paramArrayOfByte.string_tencent_errormsg.get() + ",sougouErrDes=" + paramArrayOfByte.string_sougou_errormsg.get());
          }
          k = 0;
          paramIntent = null;
        }
        k = 0;
        j = 0;
        paramIntent = null;
        bool = false;
        i = 0;
        break label262;
        if (j != 0)
        {
          i = 2;
          break label292;
        }
        if (i == 0) {
          break label704;
        }
        int m = 3;
        j = i;
        i = m;
        break label292;
      }
      label704:
      l = 0L;
      str = null;
    }
  }
  
  private void a(int paramInt, Intent paramIntent, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject2 = null;
    long l = paramIntent.getLongExtra("param_subtype", 0L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.ocr.OCRHandler", 2, "handleReqBigDataRsp, errorCode=" + paramInt);
    }
    Object localObject1 = localObject2;
    int i = paramInt;
    int j;
    if (paramInt == 0)
    {
      try
      {
        int k = paramArrayOfByte1.length;
        if ((paramArrayOfByte1[0] != 40) || (paramArrayOfByte1[(k - 1)] != 41))
        {
          localObject1 = "unexpected body data, len=" + k + ", data=";
          paramArrayOfByte2 = paramArrayOfByte1.toString();
          localObject1 = new StringBuilder().append((String)localObject1);
          paramArrayOfByte1 = paramArrayOfByte2;
          if (paramArrayOfByte2.length() > 20) {
            paramArrayOfByte1 = paramArrayOfByte2.substring(0, 20);
          }
          paramArrayOfByte1 = paramArrayOfByte1;
          a(-2, paramIntent, null, null);
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.e("Q.ocr.OCRHandler", 2, "handleReqBigDataRsp error, errorMsg=" + paramArrayOfByte1);
          return;
        }
        paramArrayOfByte1 = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte1));
        paramArrayOfByte1.readByte();
        i = paramArrayOfByte1.readInt();
        j = paramArrayOfByte1.readInt();
        if ((i <= k) && (j <= k)) {
          break label356;
        }
        a(-2, paramIntent, null, null);
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("Q.ocr.OCRHandler", 2, "handleReqBigDataRsp error, unexpected length, headLen=" + i + ", bodyLen=" + j);
        return;
      }
      catch (Exception paramArrayOfByte1)
      {
        paramInt = -10;
        localObject1 = localObject2;
        i = paramInt;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.ocr.OCRHandler", 2, "handleReqBigDataRsp error", paramArrayOfByte1);
          i = paramInt;
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      if (l != 2L) {
        return;
      }
      a(i, paramIntent, (byte[])localObject1);
      return;
    }
    label356:
    if (QLog.isColorLevel()) {
      QLog.i("Q.ocr.OCRHandler", 2, "handleReqBigDataRsp | headLen=" + i + " | bodyLen=" + j);
    }
    if (i > 0)
    {
      localObject1 = new byte[i];
      paramArrayOfByte1.read((byte[])localObject1);
      Object localObject3 = new im_msg_head.Head();
      ((im_msg_head.Head)localObject3).mergeFrom((byte[])localObject1);
      localObject1 = (im_msg_head.HttpConnHead)((im_msg_head.Head)localObject3).msg_httpconn_head.get();
      i = ((im_msg_head.HttpConnHead)localObject1).uint32_error_code.get();
      paramInt = i;
      if (QLog.isDevelopLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("uint64_uin=").append(((im_msg_head.HttpConnHead)localObject1).uint64_uin.get()).append(", uint32_command=").append(((im_msg_head.HttpConnHead)localObject1).uint32_command.get()).append(", uint32_sub_command=").append(((im_msg_head.HttpConnHead)localObject1).uint32_sub_command.get()).append(", uint32_seq=").append(((im_msg_head.HttpConnHead)localObject1).uint32_seq.get()).append(", uint32_version=").append(((im_msg_head.HttpConnHead)localObject1).uint32_version.get()).append(", uint32_retry_times=").append(((im_msg_head.HttpConnHead)localObject1).uint32_retry_times.get()).append(", uint32_client_type=").append(((im_msg_head.HttpConnHead)localObject1).uint32_client_type.get()).append(", uint32_pub_no=").append(((im_msg_head.HttpConnHead)localObject1).uint32_pub_no.get()).append(", uint32_local_id=").append(((im_msg_head.HttpConnHead)localObject1).uint32_local_id.get()).append(", uint32_time_zone=").append(((im_msg_head.HttpConnHead)localObject1).uint32_time_zone.get()).append(", uint32_client_ip=").append(((im_msg_head.HttpConnHead)localObject1).uint32_client_ip.get()).append(", uint32_client_port=").append(((im_msg_head.HttpConnHead)localObject1).uint32_client_port.get()).append(", uint32_qzhttp_ip=").append(((im_msg_head.HttpConnHead)localObject1).uint32_qzhttp_ip.get()).append(", uint32_qzhttp_port=").append(((im_msg_head.HttpConnHead)localObject1).uint32_qzhttp_port.get()).append(", uint32_spp_ip=").append(((im_msg_head.HttpConnHead)localObject1).uint32_spp_ip.get()).append(", uint32_spp_port=").append(((im_msg_head.HttpConnHead)localObject1).uint32_spp_port.get()).append(", uint32_flag=").append(((im_msg_head.HttpConnHead)localObject1).uint32_flag.get()).append(", bytes_key=").append(((im_msg_head.HttpConnHead)localObject1).bytes_key.get()).append(", uint32_compress_type=").append(((im_msg_head.HttpConnHead)localObject1).uint32_compress_type.get()).append(", uint32_origin_size=").append(((im_msg_head.HttpConnHead)localObject1).uint32_origin_size.get()).append(", uint32_error_code=").append(((im_msg_head.HttpConnHead)localObject1).uint32_error_code.get()).append(", uint32_command_id=").append(((im_msg_head.HttpConnHead)localObject1).uint32_command_id.get()).append(", uint32_service_cmdid=").append(((im_msg_head.HttpConnHead)localObject1).uint32_service_cmdid.get());
        QLog.i("Q.ocr.OCRHandler", 4, "handleReqBigData,  RspHttpConnHead=" + ((StringBuilder)localObject3).toString());
        paramInt = i;
      }
    }
    if ((j > 0) && (paramInt == 0))
    {
      localObject1 = new byte[j];
      paramArrayOfByte1.read((byte[])localObject1);
    }
    for (paramArrayOfByte1 = new Cryptor().decrypt((byte[])localObject1, paramArrayOfByte2);; paramArrayOfByte1 = null)
    {
      localObject1 = paramArrayOfByte1;
      i = paramInt;
      break;
    }
  }
  
  private void a(Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("param_uin", 0L);
    Object localObject6 = paramIntent.getByteArrayExtra("param_reqbody");
    long l2 = paramIntent.getLongExtra("param_subtype", 0L);
    if ((l1 == 0L) || (localObject6 == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.ocr.OCRHandler", 2, "reqSouggouSearchBigData, uin or reqBody is null");
      }
    }
    for (;;)
    {
      return;
      Object localObject2 = "";
      Object localObject3 = ConfigManager.getInstance(this.app.getApp().getBaseContext(), this.app.getHwEngine());
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((ConfigManager)localObject3).getOtherTypeIp(this.app.getApp().getBaseContext(), 21, false);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((List)localObject3).size() > 0)
          {
            localObject1 = (EndPoint)((List)localObject3).get(0);
            localObject1 = "https://" + ((EndPoint)localObject1).host + ":" + ((EndPoint)localObject1).port + "/";
          }
        }
      }
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = "https://sslv6.htdata.qq.com/";
      }
      Object localObject4 = FMTSrvAddrProvider.getInstance().getBigDataSrvKey(l1);
      Object localObject5 = FMTSrvAddrProvider.getInstance().getBigDataSrvSign(l1);
      if (localObject4 != null)
      {
        localObject1 = localObject5;
        localObject2 = localObject4;
        if (localObject5 != null) {}
      }
      else
      {
        localObject1 = localObject5;
      }
      for (;;)
      {
        try
        {
          int i;
          if (SessionInfo.getInstance(this.app.getCurrentUin()).getHttpconn_sig_session() != null)
          {
            i = SessionInfo.getInstance(this.app.getCurrentUin()).getHttpconn_sig_session().length;
            localObject1 = new byte[i];
            System.arraycopy(SessionInfo.getInstance(this.app.getCurrentUin()).getHttpconn_sig_session(), 0, localObject1, 0, i);
          }
          localObject2 = localObject4;
          if (SessionInfo.getInstance(this.app.getCurrentUin()).getSessionKey() != null)
          {
            i = SessionInfo.getInstance(this.app.getCurrentUin()).getSessionKey().length;
            localObject2 = new byte[i];
            System.arraycopy(SessionInfo.getInstance(this.app.getCurrentUin()).getSessionKey(), 0, localObject2, 0, i);
          }
          if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (localObject1 != null)) {
            break;
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder().append("reqSouggouSearchBigData, host=").append((String)localObject3).append(",bkeyIsNull=");
            if (localObject2 == null)
            {
              bool = true;
              localObject2 = ((StringBuilder)localObject3).append(bool).append(",bSignIsNull=");
              if (localObject1 != null) {
                break label494;
              }
              bool = true;
              QLog.i("Q.ocr.OCRHandler", 2, bool);
            }
          }
          else
          {
            a(-1, paramIntent, null, null);
            return;
          }
        }
        finally {}
        boolean bool = false;
        continue;
        label494:
        bool = false;
      }
      localObject4 = new Cryptor().encrypt((byte[])localObject6, (byte[])localObject2);
      localObject5 = new im_msg_head.Head();
      ((im_msg_head.Head)localObject5).uint32_head_type.set(4);
      localObject6 = new im_msg_head.LoginSig();
      ((im_msg_head.LoginSig)localObject6).uint32_type.set(22);
      ((im_msg_head.LoginSig)localObject6).bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject1));
      ((im_msg_head.Head)localObject5).msg_login_sig.set((MessageMicro)localObject6);
      localObject1 = new im_msg_head.HttpConnHead();
      ((im_msg_head.HttpConnHead)localObject1).uint64_uin.set(l1);
      ((im_msg_head.HttpConnHead)localObject1).uint32_command.set(1791);
      ((im_msg_head.HttpConnHead)localObject1).uint32_sub_command.set(1331);
      ((im_msg_head.HttpConnHead)localObject1).uint32_seq.set(a());
      ((im_msg_head.HttpConnHead)localObject1).uint32_version.set(4643);
      ((im_msg_head.HttpConnHead)localObject1).uint32_flag.set(1);
      ((im_msg_head.HttpConnHead)localObject1).uint32_compress_type.set(0);
      ((im_msg_head.HttpConnHead)localObject1).uint32_error_code.set(0);
      ((im_msg_head.Head)localObject5).msg_httpconn_head.set((MessageMicro)localObject1);
      localObject5 = ((im_msg_head.Head)localObject5).toByteArray();
      localObject1 = new ByteArrayOutputStream();
      try
      {
        localObject6 = new DataOutputStream((OutputStream)localObject1);
        ((DataOutputStream)localObject6).write(40);
        ((DataOutputStream)localObject6).writeInt(localObject5.length);
        ((DataOutputStream)localObject6).writeInt(localObject4.length);
        ((DataOutputStream)localObject6).write((byte[])localObject5);
        ((DataOutputStream)localObject6).write((byte[])localObject4);
        ((DataOutputStream)localObject6).write(41);
        ((DataOutputStream)localObject6).flush();
        localObject4 = (String)localObject3 + "cgi-bin/httpconn";
        localObject5 = ((ByteArrayOutputStream)localObject1).toByteArray();
        localObject1 = new HttpNetReq();
        ((HttpNetReq)localObject1).mSendData = ((byte[])localObject5);
        ((HttpNetReq)localObject1).mCallback = new axla(this, paramIntent, (byte[])localObject2, (String)localObject3);
        ((HttpNetReq)localObject1).mReqUrl = ((String)localObject4);
        ((HttpNetReq)localObject1).mHttpMethod = 1;
        ((HttpNetReq)localObject1).mFileType = 57;
        ((HttpNetReq)localObject1).mReqProperties.put("Accept-Encoding", "identity");
        ((HttpNetReq)localObject1).mContinuErrorLimit = 2;
        ((HttpNetReq)localObject1).mExcuteTimeLimit = 15000L;
        ((HttpNetReq)localObject1).mIsHttps = true;
        ((HttpNetReq)localObject1).mIsHostIP = true;
        ((HttpNetReq)localObject1).mHostForHttpsVerify = "sslv6.htdata.qq.com";
        paramIntent = BaseApplicationImpl.sApplication.getRuntime();
        if ((paramIntent instanceof AppInterface))
        {
          ((AppInterface)paramIntent).getNetEngine(0).sendReq((NetReq)localObject1);
          if (QLog.isColorLevel()) {
            QLog.i("Q.ocr.OCRHandler", 2, "reqSouggouSearchBigData send");
          }
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.ocr.OCRHandler", 2, "reqSouggouSearchBigData start, uin=" + l1 + ",subType=" + l2 + ",url=" + (String)localObject4 + ",testserver=" + jdField_a_of_type_Boolean);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.ocr.OCRHandler", 2, "reqSouggouSearchBigData", localException);
          }
          a(-10, paramIntent, null, null);
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0x990.RspBody();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    int i;
    if ((j == 0) && (((oidb_0x990.RspBody)localObject).msg_translate_rsp.has()))
    {
      paramFromServiceMsg = (oidb_0x990.TranslateRsp)((oidb_0x990.RspBody)localObject).msg_translate_rsp.get();
      i = paramFromServiceMsg.int32_ret_code.get();
      if (i == 0)
      {
        if (!paramFromServiceMsg.bytes_trans_result.has()) {
          break label228;
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_trans_result.get().toStringUtf8();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.OCRHandler", 2, String.format("handleTranslateResp, result: %s, errCode: %s, translateResult: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), paramFromServiceMsg }));
      }
      paramObject = new Object[2];
      paramObject[0] = Integer.valueOf(0);
      if ((j != 0) || (i != 0)) {
        break;
      }
      localObject = new TranslateResult(0);
      ((TranslateResult)localObject).a(paramToServiceMsg.extraData.getString("param_translate_src_lang"), paramToServiceMsg.extraData.getString("param_translate_dst_lang"), paramToServiceMsg.extraData.getString("param_translate_src_text"), paramFromServiceMsg);
      paramObject[1] = localObject;
      notifyUI(2, true, paramObject);
      return;
      QLog.d("Q.ocr.OCRHandler", 1, String.format("handleTranslateResp, errCode: %s", new Object[] { Integer.valueOf(i) }));
      label228:
      paramFromServiceMsg = "";
      continue;
      QLog.d("Q.ocr.OCRHandler", 1, String.format("handleBatchTranslateResp parse error, result: %s", new Object[] { Integer.valueOf(j) }));
      i = -1;
      paramFromServiceMsg = "";
    }
    notifyUI(2, false, paramObject);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject3 = new oidb_0x990.RspBody();
    int m = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject3);
    Object localObject2 = null;
    TranslateResult localTranslateResult = null;
    paramObject = null;
    Object localObject1 = "";
    int i;
    if ((m == 0) && (((oidb_0x990.RspBody)localObject3).msg_batch_translate_rsp.has()))
    {
      localObject3 = (oidb_0x990.BatchTranslateRsp)((oidb_0x990.RspBody)localObject3).msg_batch_translate_rsp.get();
      if (localObject3 == null) {
        break label497;
      }
      i = ((oidb_0x990.BatchTranslateRsp)localObject3).int32_error_code.get();
      if (i == 0)
      {
        paramFromServiceMsg = localTranslateResult;
        if (((oidb_0x990.BatchTranslateRsp)localObject3).rpt_src_bytes_text_list.has())
        {
          localObject2 = ((oidb_0x990.BatchTranslateRsp)localObject3).rpt_src_bytes_text_list.get();
          paramFromServiceMsg = localTranslateResult;
          if (localObject2 != null)
          {
            paramFromServiceMsg = localTranslateResult;
            if (((List)localObject2).size() > 0)
            {
              paramFromServiceMsg = new ArrayList();
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                paramFromServiceMsg.add(((ByteStringMicro)((Iterator)localObject2).next()).toStringUtf8());
              }
            }
          }
        }
        if (!((oidb_0x990.BatchTranslateRsp)localObject3).rpt_dst_bytes_text_list.has()) {
          break label548;
        }
        localObject2 = ((oidb_0x990.BatchTranslateRsp)localObject3).rpt_dst_bytes_text_list.get();
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break label543;
        }
        paramObject = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramObject.add(((ByteStringMicro)((Iterator)localObject2).next()).toStringUtf8());
        }
      }
    }
    label273:
    label280:
    label537:
    label543:
    label548:
    for (;;)
    {
      int j;
      int k;
      if (QLog.isColorLevel())
      {
        if (paramFromServiceMsg == null)
        {
          j = 0;
          if (paramObject != null) {
            break label517;
          }
          k = 0;
          QLog.d("Q.ocr.OCRHandler", 2, String.format("handleBatchTranslateResp, result: %s, errCode: %s, errMsg: %s, scrTextSize: %s, dstTextSize: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), localObject1, Integer.valueOf(j), Integer.valueOf(k) }));
        }
      }
      else
      {
        localObject1 = new Object[2];
        localObject1[0] = Integer.valueOf(1);
        if ((paramFromServiceMsg == null) || (paramObject == null)) {
          break label528;
        }
        localObject2 = paramToServiceMsg.extraData.getString("param_translate_src_lang");
        paramToServiceMsg = paramToServiceMsg.extraData.getString("param_translate_dst_lang");
        localTranslateResult = new TranslateResult(1);
        localTranslateResult.a((String)localObject2, paramToServiceMsg, paramFromServiceMsg, paramObject);
        localObject1[1] = localTranslateResult;
        notifyUI(2, true, localObject1);
        return;
        if (!((oidb_0x990.BatchTranslateRsp)localObject3).bytes_error_msg.has()) {
          break label537;
        }
      }
      for (paramFromServiceMsg = ((oidb_0x990.BatchTranslateRsp)localObject3).bytes_error_msg.get().toStringUtf8();; paramFromServiceMsg = "")
      {
        QLog.d("Q.ocr.OCRHandler", 1, new Object[] { "handleBatchTranslateResp translate error, errCode: %s, errMsg: %s", Integer.valueOf(i), paramFromServiceMsg });
        localObject1 = paramFromServiceMsg;
        paramFromServiceMsg = (FromServiceMsg)localObject2;
        break;
        QLog.d("Q.ocr.OCRHandler", 1, String.format("handleBatchTranslateResp parse error, result: %s", new Object[] { Integer.valueOf(m) }));
        label497:
        i = 0;
        paramFromServiceMsg = (FromServiceMsg)localObject2;
        break;
        j = paramFromServiceMsg.size();
        break label273;
        k = paramObject.size();
        break label280;
        notifyUI(2, false, localObject1);
        return;
      }
      paramObject = null;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.OCRHandler", 2, "doSougouSearch start, sessionId=" + paramString1);
    }
    Object localObject1 = new subcmd0x533.HttpClientRequestBodyV2();
    Object localObject2 = new subcmd0x533.HttpDeviceV2();
    ((subcmd0x533.HttpDeviceV2)localObject2).platform.set(1);
    ((subcmd0x533.HttpClientRequestBodyV2)localObject1).msg_device.set((MessageMicro)localObject2);
    localObject2 = new ArrayList(1);
    ((List)localObject2).add(paramString2);
    ((subcmd0x533.HttpClientRequestBodyV2)localObject1).rpt_string_sentences.set((List)localObject2);
    ((subcmd0x533.HttpClientRequestBodyV2)localObject1).uint32_timeout_ms.set(3000);
    paramString2 = new subcmd0x533.HttpAROcrInfo();
    paramString2.uint64_ocr_recog_type.set(2L);
    paramString2.msg_sougou_req.set((MessageMicro)localObject1);
    localObject1 = new subcmd0x533.ReqBody();
    ((subcmd0x533.ReqBody)localObject1).string_session_id.set(paramString1);
    ((subcmd0x533.ReqBody)localObject1).uint64_req_recog_type.set(16L);
    ((subcmd0x533.ReqBody)localObject1).uint32_business_type.set(0);
    ((subcmd0x533.ReqBody)localObject1).string_clt_version.set(String.valueOf(AppSetting.a()));
    ((subcmd0x533.ReqBody)localObject1).msg_ocr_info.set(paramString2);
    paramString2 = new Intent();
    paramString2.putExtra("param_uin", Long.parseLong(this.mApp.getCurrentAccountUin()));
    paramString2.putExtra("param_reqbody", ((subcmd0x533.ReqBody)localObject1).toByteArray());
    paramString2.putExtra("param_subtype", 2L);
    paramString2.putExtra("param_sougou_sessionid", paramString1);
    paramString2.putExtra("param_starttime", paramLong);
    a(paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("Q.ocr.OCRHandler", 1, "batchTranslate, texts is empty!");
      return;
    }
    paramString1 = paramString1.split("\n");
    ArrayList localArrayList = new ArrayList();
    if ((paramString1 != null) && (paramString1.length > 0))
    {
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString1[i];
        if (!TextUtils.isEmpty(localObject.trim().replace("\n", ""))) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    if (localArrayList.size() > 0)
    {
      a(localArrayList, paramString2, paramString3);
      return;
    }
    QLog.d("Q.ocr.OCRHandler", 1, "batchTranslate, srcTextList is empty!");
  }
  
  public void a(List<String> paramList, String paramString1, String paramString2)
  {
    oidb_0x990.ReqBody localReqBody = new oidb_0x990.ReqBody();
    oidb_0x990.BatchTranslateReq localBatchTranslateReq = new oidb_0x990.BatchTranslateReq();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        localBatchTranslateReq.rpt_src_bytes_text_list.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localBatchTranslateReq.str_src_language.set(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localBatchTranslateReq.str_dst_language.set(paramString2);
    }
    localReqBody.msg_batch_translate_req.set(localBatchTranslateReq);
    paramList = makeOIDBPkg("OidbSvc.0x990", 2448, 2, localReqBody.toByteArray());
    paramList.extraData.putInt("param_translate_type", 2);
    paramList.extraData.putString("param_translate_src_lang", paramString1);
    paramList.extraData.putString("param_translate_dst_lang", paramString2);
    sendPbReq(paramList);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.OCRHandler", 2, String.format("batchTranslate, srcLang: %s, dstLang: %s", new Object[] { paramString1, paramString2 }));
    }
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x990");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return axld.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str2 = paramToServiceMsg.extraData.getString("friendUin");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramFromServiceMsg.getUin();
    }
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      return;
      new Bundle().putString("uin", str1);
    } while (!"OidbSvc.0x990".equals(paramFromServiceMsg.getServiceCmd()));
    int i = paramToServiceMsg.extraData.getInt("param_translate_type");
    if (i == 1)
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (i == 2)
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    QLog.e("Q.ocr.OCRHandler", 1, String.format("onReceive, cmd = OidbSvc.0x990, serviceType error: %s", new Object[] { Integer.valueOf(i) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkz
 * JD-Core Version:    0.7.0.1
 */