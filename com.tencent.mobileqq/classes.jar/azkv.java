import android.content.Context;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;

public class azkv
{
  public static int a;
  public static int[] a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_Int = -4;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libgnustl_shared.so", "libSNPE.so", "libQMCF_snpe.so" };
    jdField_a_of_type_ArrayOfInt = new int[] { -4, -4, -4 };
  }
  
  public static boolean a()
  {
    return FeatureManager.isBasicFeaturesFunctionReady();
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = azkt.c(paramContext);
    if (paramContext == null)
    {
      VideoEnvironment.a("PtvFilterSoLoad", "isFilterSoExist:getSVFilterSoPath soRootPath=null", null);
      return false;
    }
    if (!new File(paramContext).exists())
    {
      VideoEnvironment.a("PtvFilterSoLoad", "isFilterSoExist:getSVFilterSoPath soRootPath=" + paramContext + ",exists=false", null);
      return false;
    }
    return a(paramContext);
  }
  
  public static boolean a(String paramString)
  {
    return FeatureManager.isBasicFeaturesReadyInDir(paramString);
  }
  
  public static boolean b(Context arg0)
  {
    String str = azkt.d(???);
    synchronized (azkt.a())
    {
      boolean bool1 = bdhb.a(str + "libQMCF.so");
      boolean bool2 = bdhb.a(str + jdField_a_of_type_ArrayOfJavaLangString[2]);
      if (QLog.isColorLevel()) {
        QLog.i("SVAF_SoLoad", 2, String.format("isArtFilterSoExist, qmcfso[%s], snpeso[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkv
 * JD-Core Version:    0.7.0.1
 */