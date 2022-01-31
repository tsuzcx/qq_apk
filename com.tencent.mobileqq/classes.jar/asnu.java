import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class asnu
  extends asnp
{
  public static String b = ajsd.aW + "ptt" + File.separator;
  private static final String c = azac.a(asoc.jdField_a_of_type_JavaLangString + "ptt" + File.separator);
  private String d = (String)this.jdField_a_of_type_JavaUtilMap.get("md5");
  private String e = (String)this.jdField_a_of_type_JavaUtilMap.get("uuid");
  private String f = (String)this.jdField_a_of_type_JavaUtilMap.get("selfuin");
  
  public asnu(MsgBackupResEntity paramMsgBackupResEntity)
  {
    super(paramMsgBackupResEntity);
    if (this.d == null) {
      this.d = "";
    }
    if (this.e == null) {
      this.e = "";
    }
    if (this.f == null) {
      this.f = "";
    }
    if ((TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.f))) {
      a("md5:" + this.d + " mUUID:" + this.e + " mSelfuin:" + this.f);
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return azac.a(b + paramString2 + File.separator + paramString1);
  }
  
  public aslo a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity;
    String str = a();
    boolean bool = a(str);
    if (QLog.isColorLevel()) {
      a("getResDownloadObject,entity:" + ((MsgBackupResEntity)localObject).toLogString() + " tempPath:" + str + " exist:" + bool);
    }
    localObject = new aslo();
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      ((aslo)localObject).jdField_a_of_type_Boolean = bool;
      ((aslo)localObject).jdField_a_of_type_JavaLangString = str;
      return localObject;
    }
  }
  
  public String a()
  {
    return c + this.d + this.e + this.f;
  }
  
  public String b()
  {
    return a(this.d, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asnu
 * JD-Core Version:    0.7.0.1
 */