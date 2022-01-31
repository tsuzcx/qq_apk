import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class bfij
  extends bfik
{
  public bfij(String paramString)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return null;
    }
    try
    {
      Object localObject = BaseApplication.getContext().getPackageManager().getPackageInfo(this.jdField_c_of_type_JavaLangString, 192);
      if (localObject != null)
      {
        if ((((PackageInfo)localObject).signatures != null) && (((PackageInfo)localObject).signatures.length > 0)) {
          this.e = SecUtil.getSignatureHash(localObject.signatures[0].toByteArray());
        }
        if (((PackageInfo)localObject).applicationInfo != null)
        {
          this.jdField_a_of_type_JavaLangString = ((PackageInfo)localObject).applicationInfo.sourceDir;
          this.jdField_c_of_type_Int = ((int)new File(this.jdField_a_of_type_JavaLangString).length());
          this.d = ((PackageInfo)localObject).applicationInfo.loadLabel(BaseApplication.getContext().getPackageManager()).toString();
          localObject = new byte[16];
          bfjv.a(this.jdField_a_of_type_JavaLangString, "META-INF/MANIFEST.MF", (byte[])localObject);
          this.jdField_b_of_type_JavaLangString = SecUtil.toHexString((byte[])localObject);
        }
      }
      localObject = this.jdField_b_of_type_JavaLangString;
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfij
 * JD-Core Version:    0.7.0.1
 */