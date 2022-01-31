import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class auet
  extends aueo
{
  public static String b = aljq.aX + "ptt" + File.separator;
  private static final String c = bayb.a(aufb.jdField_a_of_type_JavaLangString + "ptt" + File.separator);
  private String d = (String)this.jdField_a_of_type_JavaUtilMap.get("md5");
  private String e = (String)this.jdField_a_of_type_JavaUtilMap.get("uuid");
  private String f = (String)this.jdField_a_of_type_JavaUtilMap.get("selfuin");
  
  public auet(MsgBackupResEntity paramMsgBackupResEntity)
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
    return bayb.a(b + paramString2 + File.separator + paramString1);
  }
  
  public aucn a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity;
    String str = a();
    boolean bool = a(str);
    if (QLog.isColorLevel()) {
      a("getResDownloadObject,entity:" + ((MsgBackupResEntity)localObject).toLogString() + " tempPath:" + str + " exist:" + bool);
    }
    localObject = new aucn();
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      ((aucn)localObject).jdField_a_of_type_Boolean = bool;
      ((aucn)localObject).jdField_a_of_type_JavaLangString = str;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auet
 * JD-Core Version:    0.7.0.1
 */