import QC.LoginInfo;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.TicketManager;

public class beal
{
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, JceStruct> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private String b;
  private String c = "req";
  private String d = "rsp";
  
  public beal(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString1;
    if (!alpw.a().containsKey(paramString2)) {
      alpw.a(paramString2, new int[] { 13 });
    }
  }
  
  public beal(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString1;
    if (!alpw.a().containsKey(paramString2)) {
      alpw.a(paramString2, new int[] { 13 });
    }
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public static LoginInfo a()
  {
    try
    {
      Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localObject == null) {
        return null;
      }
      String str = ((AppInterface)localObject).getCurrentAccountUin();
      localObject = ((TicketManager)((AppInterface)localObject).getManager(2)).getSkey(str);
      LoginInfo localLoginInfo = new LoginInfo();
      localLoginInfo.lUin = Long.parseLong(str);
      localLoginInfo.iKeyType = 1;
      localLoginInfo.sSKey = ((String)localObject);
      localLoginInfo.iOpplat = 2;
      localLoginInfo.sClientVer = bdgk.c();
      return localLoginInfo;
    }
    catch (Exception localException)
    {
      QLog.e("JceProtocol", 1, localException, new Object[0]);
    }
    return null;
  }
  
  public static String a(ToServiceMsg paramToServiceMsg)
  {
    return paramToServiceMsg.getServiceCmd() + "_" + paramToServiceMsg.extraData.get(aloy.SEQ_KEY);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = a(paramToServiceMsg);
    ayym.a(paramToServiceMsg);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramToServiceMsg))
    {
      paramFromServiceMsg = (JceStruct)this.jdField_a_of_type_JavaUtilHashMap.get(paramToServiceMsg);
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramToServiceMsg);
      return paramUniPacket.getByClass(this.d, paramFromServiceMsg);
    }
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket, int paramInt)
  {
    paramUniPacket.setServantName(this.b);
    paramUniPacket.setFuncName(paramToServiceMsg.extraData.getString("funcName"));
    paramUniPacket.setRequestId(paramInt);
    paramUniPacket.put(this.c, paramToServiceMsg.extraData.get("req"));
  }
  
  public void a(String paramString, JceStruct paramJceStruct1, JceStruct paramJceStruct2, alpg paramalpg, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramalpg = ((amca)localQQAppInterface.a(13)).createToServiceMsg(this.jdField_a_of_type_JavaLangString, paramalpg, paramBoolean);
    String str = a(paramalpg);
    this.jdField_a_of_type_JavaUtilHashMap.put(str, paramJceStruct2);
    ayym.a(this, str);
    paramalpg.extraData.putSerializable("req", paramJceStruct1);
    paramalpg.extraData.putString("funcName", paramString);
    localQQAppInterface.sendToService(paramalpg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beal
 * JD-Core Version:    0.7.0.1
 */