import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.cmd0xd79.Oidb_0xd79.ReqBody;
import tencent.im.oidb.cmd0xd79.Oidb_0xd79.RspBody;
import tencent.im.oidb.cmd0xd79.Oidb_0xd79.content;

public class bdoo
  extends anii
{
  private AtomicInteger a = new AtomicInteger();
  
  public bdoo(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = null;
    try
    {
      Oidb_0xd79.RspBody localRspBody = new Oidb_0xd79.RspBody();
      parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      int i = localRspBody.uint32_ret.get();
      localRspBody.uint64_seq.get();
      localRspBody.uint64_uin.get();
      paramFromServiceMsg = str;
      if (localRspBody.uint32_compress_flag.get() == 0)
      {
        paramObject = new Oidb_0xd79.content();
        paramObject.mergeFrom(localRspBody.bytes_raw_content.get().toByteArray());
        paramFromServiceMsg = str;
        if (paramObject.bytes_slice_content.has()) {
          paramFromServiceMsg = paramObject.bytes_slice_content.get();
        }
      }
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
      {
        paramObject = new ArrayList(paramFromServiceMsg.size());
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          str = a(((ByteStringMicro)paramFromServiceMsg.next()).toStringUtf8());
          if (!TextUtils.isEmpty(str)) {
            paramObject.add(str);
          }
        }
        if (i != 0) {
          break label224;
        }
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      QLog.d("ParticipleHandler", 1, paramFromServiceMsg, new Object[0]);
      return;
    }
    label224:
    for (boolean bool = true;; bool = false)
    {
      notifyUI(1, bool, paramObject);
      return;
      notifyUI(1, false, null);
      return;
    }
  }
  
  public String a(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int k = paramString.length() - 1;
    int i = 0;
    while ((i <= k) && (arrayOfChar[i] <= ' ') && (arrayOfChar[i] != '\024')) {
      i += 1;
    }
    for (;;)
    {
      int j;
      if ((j >= i) && (arrayOfChar[j] <= ' ') && ((j == 0) || (arrayOfChar[(j - 1)] != '\024')))
      {
        j -= 1;
      }
      else
      {
        if ((i == 0) && (j == k)) {
          return paramString;
        }
        return paramString.substring(i, j + 1);
        j = k;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, paramString, "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    try
    {
      Oidb_0xd79.ReqBody localReqBody = new Oidb_0xd79.ReqBody();
      localReqBody.uint64_seq.set(this.a.incrementAndGet());
      paramQQAppInterface = paramQQAppInterface.c();
      localReqBody.uint64_uin.set(Long.parseLong(paramQQAppInterface));
      localReqBody.uint32_compress_flag.set(0);
      localReqBody.bytes_content.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
      if (!TextUtils.isEmpty(paramString2)) {
        localReqBody.uint64_sender_uin.set(Long.parseLong(paramString2));
      }
      localReqBody.bytes_qua.set(ByteStringMicro.copyFrom(("and_" + AppSetting.a() + "_" + "8.4.1").getBytes()));
      sendPbReq(makeOIDBPkg("OidbSvc.0xd79", 3449, 1, localReqBody.toByteArray()));
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.d("ParticipleHandler", 1, paramQQAppInterface, new Object[0]);
    }
  }
  
  protected Class<? extends anil> observerClass()
  {
    return bdop.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (TextUtils.equals(paramFromServiceMsg.getServiceCmd(), "OidbSvc.0xd79"))) {
      a(paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdoo
 * JD-Core Version:    0.7.0.1
 */