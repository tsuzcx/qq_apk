import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class auwp
{
  public static String a(Context paramContext)
  {
    return bbac.c(paramContext) + "wzryTemplate/";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    paramQQAppInterface = (VasQuickUpdateManager)paramQQAppInterface.getManager(184);
    paramQQAppInterface.addCallBacker(paramCallBacker);
    paramQQAppInterface.downloadItem(15L, "cardWZ.zip", "ProfileCard");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 0) {
      if ("cardWZ.zip".equals(paramString1))
      {
        paramQQAppInterface = a(paramQQAppInterface.getApp()) + "xydata.json";
        auwm.a(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("VipWZRYTemplateHelper", 2, "onDownloadComplete, parseConfig " + paramQQAppInterface);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("VipWZRYTemplateHelper", 2, "onDownloadComplete failed, errorCode = " + paramInt);
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong == auvf.i) || (paramLong == auvf.j);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ("cardWZ.zip".equals(paramString))
    {
      String str = a(paramContext);
      paramContext = new File(str, "xydata.json");
      if (auwm.jdField_a_of_type_Auwm == null) {
        auwm.a(paramContext.getAbsolutePath());
      }
      if (auwm.jdField_a_of_type_Auwm != null)
      {
        paramContext = new File(str, "logo.png");
        paramString = new File(str, "bgImage.jpg");
        Object localObject = new File(str, "shimmer_mask.png");
        File localFile1 = new File(str, "logo_bg.png");
        File localFile2 = new File(str, "font_chs.tff");
        File localFile3 = new File(str, "font_num.tff");
        File localFile4 = new File(str, "addIcon.png");
        int i;
        if ((paramContext.exists()) && (paramString.exists()) && (((File)localObject).exists()) && (localFile1.exists()) && (localFile2.exists()) && (localFile3.exists()) && (localFile4.exists()))
        {
          bool1 = true;
          localObject = auwm.jdField_a_of_type_Auwm;
          if (((auwm)localObject).jdField_a_of_type_AndroidUtilSparseArray == null) {
            break label338;
          }
          i = 0;
          label207:
          bool2 = bool1;
          if (i >= ((auwm)localObject).jdField_a_of_type_AndroidUtilSparseArray.size()) {
            break label341;
          }
          paramContext = (auwn)((auwm)localObject).jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
          bool2 = bool1;
          if (paramContext.a != null)
          {
            bool2 = bool1;
            if (!TextUtils.isEmpty(paramContext.a.a))
            {
              paramString = paramContext.a.a;
              paramContext = paramString;
              if (paramString.contains("/")) {
                paramContext = paramString.substring(paramString.lastIndexOf("/"));
              }
              paramContext = new File(str, paramContext);
              if ((!bool1) || (!paramContext.exists())) {
                break label333;
              }
            }
          }
        }
        label333:
        for (boolean bool1 = true;; bool1 = false)
        {
          bool2 = bool1;
          i += 1;
          bool1 = bool2;
          break label207;
          bool1 = false;
          break;
        }
      }
    }
    label338:
    boolean bool2 = false;
    label341:
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwp
 * JD-Core Version:    0.7.0.1
 */