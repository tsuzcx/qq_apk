import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class arro
  extends arrj
{
  private static final String b = arrw.b + "ptt" + File.separator;
  private String c = (String)this.jdField_a_of_type_JavaUtilMap.get("md5");
  private String d = (String)this.jdField_a_of_type_JavaUtilMap.get("uuid");
  private String e = (String)this.jdField_a_of_type_JavaUtilMap.get("selfuin");
  
  public arro(MsgBackupResEntity paramMsgBackupResEntity)
  {
    super(paramMsgBackupResEntity);
    if (this.c == null) {
      this.c = "";
    }
    if (this.d == null) {
      this.d = "";
    }
    if (this.e == null) {
      this.e = "";
    }
    if ((TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.e))) {
      a("md5:" + this.c + " mUUID:" + this.d + " mSelfuin:" + this.e);
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return ajed.aU + "ptt" + File.separator + paramString2 + File.separator + paramString1;
  }
  
  public arpi a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupResEntity;
    String str = a();
    boolean bool = a(str);
    if (QLog.isColorLevel()) {
      a("getResDownloadObject,entity:" + ((MsgBackupResEntity)localObject).toLogString() + " tempPath:" + str + " exist:" + bool);
    }
    localObject = new arpi();
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      ((arpi)localObject).jdField_a_of_type_Boolean = bool;
      ((arpi)localObject).jdField_a_of_type_JavaLangString = str;
      return localObject;
    }
  }
  
  public String a()
  {
    return b + this.c + this.d + this.e;
  }
  
  public String b()
  {
    return a(this.c, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arro
 * JD-Core Version:    0.7.0.1
 */