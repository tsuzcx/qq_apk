import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public abstract class auix
  extends auiw
{
  protected MsgBackupResEntity a;
  protected Map<String, String> a;
  
  public auix(MsgBackupResEntity paramMsgBackupResEntity)
  {
    this.jdField_a_of_type_JavaUtilMap = a(paramMsgBackupResEntity.extraDataStr);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity = paramMsgBackupResEntity;
  }
  
  protected static int a()
  {
    return alof.aX.length();
  }
  
  public static HashMap<String, String> a(String paramString)
  {
    localHashMap = new HashMap();
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        localHashMap.put(str, paramString.get(str).toString());
      }
      return localHashMap;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public abstract augw a();
  
  public abstract String a();
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity;
    a("import resEntity:" + ((MsgBackupResEntity)localObject).toLogString());
    localObject = b();
    String str = a();
    try
    {
      a(str, (String)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      a("importFile null error ");
    }
    int i;
    do
    {
      return;
      i = bdhb.a(paramString1, paramString2);
    } while (!QLog.isColorLevel());
    File localFile = new File(paramString2);
    paramString2 = new StringBuilder().append("restore,quickMove: ").append(paramString1).append(" to ").append(paramString2).append(" status:").append(i).append(" size:");
    if ((localFile != null) && (localFile.exists())) {}
    for (paramString1 = Long.valueOf(localFile.length());; paramString1 = "-1")
    {
      a(paramString1);
      return;
    }
  }
  
  public abstract String b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auix
 * JD-Core Version:    0.7.0.1
 */