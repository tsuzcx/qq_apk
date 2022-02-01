import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.entity.BusinessItemInfo;
import java.io.File;

public class bibf
  extends BaseUpdateBusiness
{
  public static final bibf a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "52.1";
    jdField_a_of_type_Bibf = new bibf();
  }
  
  public static bibf a()
  {
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.QQ_VAS_UPDATE_MANAGER);
    return jdField_a_of_type_Bibf;
  }
  
  public String a()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    String str = null;
    if (localBaseApplication != null) {
      str = localBaseApplication.getFilesDir() + "";
    }
    return str + File.separator + "qqvalue_dir" + File.separator + jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    return BaseApplicationImpl.getContext().getFilesDir() + File.separator + "qqvalue_dir" + File.separator + paramString;
  }
  
  public void a(long paramLong)
  {
    bibe localbibe = biba.a().a(paramLong + "");
    if ((localbibe != null) && (!TextUtils.isEmpty(localbibe.jdField_a_of_type_JavaLangString)))
    {
      jdField_a_of_type_JavaLangString = localbibe.jdField_a_of_type_JavaLangString;
      startDownload(jdField_a_of_type_JavaLangString);
    }
  }
  
  public long getBid()
  {
    return 52L;
  }
  
  public BusinessItemInfo getBusinessItemInfo(long paramLong, String paramString)
  {
    paramString = new BusinessItemInfo();
    paramString.mSaveInDir = true;
    paramString.mSavePath = a();
    return paramString;
  }
  
  public String getFrom()
  {
    return "QQValueViewBusiness";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bibf
 * JD-Core Version:    0.7.0.1
 */