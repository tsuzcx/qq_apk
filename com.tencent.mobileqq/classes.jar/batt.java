import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.Map;

public class batt
{
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, JceStruct> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private String b;
  
  public batt(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString1;
    if (!ajfu.a().containsKey(paramString2)) {
      ajfu.a(paramString2, new int[] { 13 });
    }
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, UniPacket paramUniPacket)
  {
    avze.b(this);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramUniPacket.getFuncName()))
    {
      paramToServiceMsg = (JceStruct)this.jdField_a_of_type_JavaUtilHashMap.get(paramUniPacket.getFuncName());
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramUniPacket.getFuncName());
      return paramUniPacket.getByClass("rsp", paramToServiceMsg);
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket, int paramInt)
  {
    paramUniPacket.setServantName(this.b);
    paramUniPacket.setFuncName(paramToServiceMsg.extraData.getString("funcName"));
    paramUniPacket.setRequestId(paramInt);
    paramUniPacket.put("req", paramToServiceMsg.extraData.get("req"));
  }
  
  public void a(String paramString, JceStruct paramJceStruct1, JceStruct paramJceStruct2, ajfe paramajfe, boolean paramBoolean)
  {
    avze.a(this);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramJceStruct2);
    paramJceStruct2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramajfe = ((ajrm)paramJceStruct2.a(13)).createToServiceMsg(this.jdField_a_of_type_JavaLangString, paramajfe, paramBoolean);
    paramajfe.extraData.putSerializable("req", paramJceStruct1);
    paramajfe.extraData.putString("funcName", paramString);
    paramJceStruct2.sendToService(paramajfe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     batt
 * JD-Core Version:    0.7.0.1
 */