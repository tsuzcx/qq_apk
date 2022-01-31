import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;
import tencent.im.qim.trans.QIMVideoUpload.QIMVideoUpload.ErrorInfo;
import tencent.im.qim.trans.QIMVideoUpload.QIMVideoUpload.RspBody;

class axtl
  implements ITransactionCallback
{
  axtl(axtk paramaxtk) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    String str5 = (String)paramHashMap.get("param_conf_connNum");
    String str6 = (String)paramHashMap.get("param_fin_lost");
    if (QLog.isColorLevel()) {
      QLog.d("QIMWebVideoUploader", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - axtk.a(this.a)) + "ms");
    }
    axtk.a(this.a).put("serverip", paramHashMap.get("ip"));
    axtk.a(this.a).put("param_bdhSrv", paramHashMap.get("ip"));
    axtk.a(this.a).put("param_bdhPort", paramHashMap.get("port"));
    axtk.a(this.a).put("X-piccachetime", paramArrayOfByte);
    axtk.a(this.a).put("param_BdhTrans", str1);
    axtk.a(this.a).put("param_segspercnt", str2);
    axtk.a(this.a).put("param_conf_segSize", str3);
    axtk.a(this.a).put("param_conf_segNum", str4);
    axtk.a(this.a).put("param_conf_connNum", str5);
    axtk.a(this.a).put("param_fin_lost", str6);
    axtk.a(this.a).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    axtk.a(this.a).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    axtk.a(this.a).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    axtk.a(this.a).put("param_retry_code", paramHashMap.get("param_retry_code"));
    axtk.a(this.a).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    axtk.a(this.a).put("param_ip_index", paramHashMap.get("param_ip_index"));
    axtk.a(this.a).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    if (TextUtils.equals((CharSequence)paramHashMap.get("param_BDH_Cache_Diff"), String.valueOf(true))) {
      axtk.a(this.a, true);
    }
    axtk.a(this.a, paramInt);
    axtk.c(this.a, "sessionKey or sigSession is null");
    axtk.a(this.a).a(paramInt, axtk.b(this.a));
    axtk.a(this.a, false);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l3 = SystemClock.uptimeMillis();
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    int i = paramArrayOfByte.get();
    if (QLog.isColorLevel()) {
      QLog.d("QIMWebVideoUploader", 2, "Callback.onSuccess,ret=" + i);
    }
    int j;
    Object localObject;
    if (i == 0)
    {
      j = 0x0 | paramArrayOfByte.get() | (paramArrayOfByte.get() & 0xFF) << 8 | (paramArrayOfByte.get() & 0xFF) << 16 | (paramArrayOfByte.get() & 0xFF) << 24;
      localObject = new byte[j];
      paramArrayOfByte.get((byte[])localObject);
      if (QLog.isColorLevel()) {
        QLog.d("QIMWebVideoUploader", 2, "TransactionCallback|data= " + HexUtil.bytes2HexStr((byte[])localObject) + ",len=" + j);
      }
    }
    for (;;)
    {
      try
      {
        localObject = (QIMVideoUpload.RspBody)new QIMVideoUpload.RspBody().mergeFrom((byte[])localObject);
        if (!((QIMVideoUpload.RspBody)localObject).uint64_uin.has()) {
          continue;
        }
        l1 = ((QIMVideoUpload.RspBody)localObject).uint64_uin.get();
        if (!((QIMVideoUpload.RspBody)localObject).uint64_service_type.has()) {
          continue;
        }
        l2 = ((QIMVideoUpload.RspBody)localObject).uint64_service_type.get();
        if (!((QIMVideoUpload.RspBody)localObject).str_uuid.has()) {
          continue;
        }
        paramArrayOfByte = ((QIMVideoUpload.RspBody)localObject).str_uuid.get();
        if (QLog.isColorLevel()) {
          QLog.d("QIMWebVideoUploader", 2, "TransactionCallback|uin=" + l1 + ",type=" + l2 + ",uuid= " + paramArrayOfByte);
        }
        localObject = (QIMVideoUpload.ErrorInfo)((QIMVideoUpload.RspBody)localObject).msg_err.get();
        if (localObject != null)
        {
          l1 = ((QIMVideoUpload.ErrorInfo)localObject).uint64_err_code.get();
          localObject = ((QIMVideoUpload.ErrorInfo)localObject).bytes_err_info.get().toStringUtf8();
          if (QLog.isColorLevel()) {
            QLog.d("QIMWebVideoUploader", 2, "TransactionCallback|errorCode= " + l1 + ",errorInfo=" + (String)localObject);
          }
        }
        if (TextUtils.isEmpty(paramArrayOfByte)) {
          continue;
        }
        axtk.a(this.a, paramArrayOfByte);
        axtk.a(this.a).a(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("QIMWebVideoUploader", 2, "set uuid from BDH ");
        }
      }
      catch (Exception paramArrayOfByte)
      {
        long l1;
        long l2;
        String str1;
        String str2;
        String str3;
        axtk.a(this.a).a(i, "mergeFrom respData Exception");
        paramArrayOfByte.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QIMWebVideoUploader", 2, "get uuid from BDH Exception", paramArrayOfByte);
        continue;
      }
      axtk.b(this.a, (String)paramHashMap.get("rep_bdhTrans"));
      paramArrayOfByte = (String)paramHashMap.get("segspercnt");
      localObject = (String)paramHashMap.get("param_conf_segSize");
      str1 = (String)paramHashMap.get("param_conf_segNum");
      str2 = (String)paramHashMap.get("param_conf_connNum");
      str3 = (String)paramHashMap.get("param_fin_lost");
      if (QLog.isColorLevel()) {
        QLog.d("QIMWebVideoUploader", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l3 - axtk.a(this.a)) + "ms transInfo:" + axtk.a(this.a));
      }
      axtk.a(this.a).put("serverip", paramHashMap.get("ip"));
      axtk.a(this.a).put("param_bdhSrv", paramHashMap.get("ip"));
      axtk.a(this.a).put("param_bdhPort", paramHashMap.get("port"));
      axtk.a(this.a).put("X-piccachetime", String.valueOf(axtk.a(this.a).mTransReport.timeCost_Cache));
      axtk.a(this.a).put("param_BdhTrans", axtk.a(this.a));
      axtk.a(this.a).put("param_segspercnt", paramArrayOfByte);
      axtk.a(this.a).put("param_conf_segSize", localObject);
      axtk.a(this.a).put("param_conf_segNum", str1);
      axtk.a(this.a).put("param_conf_connNum", str2);
      axtk.a(this.a).put("param_fin_lost", str3);
      axtk.a(this.a).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
      axtk.a(this.a).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
      axtk.a(this.a).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
      axtk.a(this.a).put("param_retry_code", paramHashMap.get("param_retry_code"));
      axtk.a(this.a).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
      axtk.a(this.a).put("param_ip_index", paramHashMap.get("param_ip_index"));
      axtk.a(this.a).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        axtk.a(this.a, true);
      }
      axtk.a(this.a, true);
      return;
      l1 = 0L;
      continue;
      l2 = 0L;
      continue;
      paramArrayOfByte = null;
      continue;
      axtk.a(this.a).a(i, "uuid is null");
      continue;
      i = 0x0 | paramArrayOfByte.get() | (paramArrayOfByte.get() & 0xFF) << 8 | (paramArrayOfByte.get() & 0xFF) << 16 | (paramArrayOfByte.get() & 0xFF) << 24;
      j = paramArrayOfByte.getShort();
      localObject = new byte[j];
      paramArrayOfByte.get((byte[])localObject);
      paramArrayOfByte = new String((byte[])localObject);
      if (QLog.isColorLevel()) {
        QLog.d("QIMWebVideoUploader", 2, "dwErrNo= " + i + ",len=" + j + ",errMsg=" + paramArrayOfByte);
      }
      axtk.a(this.a).a(i, paramArrayOfByte);
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMWebVideoUploader", 2, "<BDH_LOG> onTransStart()");
    }
  }
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axtl
 * JD-Core Version:    0.7.0.1
 */