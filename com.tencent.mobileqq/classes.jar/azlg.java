import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class azlg
{
  private static final String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getString(2131691013);
  private static List<String> jdField_a_of_type_JavaUtilList;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 1: 
    default: 
      return 0;
    }
    return 2;
  }
  
  private static azli a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo != null) {}
    switch (paramCompressInfo.jdField_f_of_type_Int)
    {
    default: 
      return null;
    case 0: 
      if (paramCompressInfo.jdField_a_of_type_Int == 1035) {
        return new azln(paramCompressInfo);
      }
      if (paramCompressInfo.jdField_a_of_type_Int == 1036) {
        return new azlk(paramCompressInfo);
      }
      return new azlm(paramCompressInfo);
    case 1: 
      return new azll(paramCompressInfo);
    }
    return new azlj(paramCompressInfo);
  }
  
  private static void a(CompressInfo paramCompressInfo, boolean paramBoolean)
  {
    if ((paramCompressInfo == null) || (TextUtils.isEmpty(paramCompressInfo.c)) || (TextUtils.isEmpty(paramCompressInfo.jdField_e_of_type_JavaLangString))) {
      azjq.b("CompressOperator", " checkAndLog()", "info == null || TextUtils.isEmpty(info.srcPath) || TextUtils.isEmpty(info.destPath)");
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        azjq.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", paramCompressInfo.toString());
        if (!paramCompressInfo.jdField_a_of_type_Boolean) {
          break;
        }
      } while (paramBoolean);
      l1 = azlo.a(paramCompressInfo.c);
      l2 = azlo.a(paramCompressInfo.jdField_e_of_type_JavaLangString);
      azjq.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", "src File size:" + l1);
      azjq.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", "dest File size:" + l2);
    } while ((l1 <= 0L) || (l2 <= l1));
    if (akpu.c(paramCompressInfo.c))
    {
      azjq.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", "src is incompatible ,keep compress file");
      return;
    }
    if (l1 > 1024L)
    {
      FileUtils.estimateFileType(paramCompressInfo.c);
      azjq.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", jdField_a_of_type_JavaLangString);
      paramCompressInfo.jdField_f_of_type_JavaLangString = ("CompressOperator" + paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()" + jdField_a_of_type_JavaLangString);
      FileUtils.deleteFile(paramCompressInfo.jdField_e_of_type_JavaLangString);
      if (jdField_a_of_type_JavaUtilList == null) {
        jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      if (!jdField_a_of_type_JavaUtilList.contains(paramBoolean + paramCompressInfo.c)) {
        jdField_a_of_type_JavaUtilList.add(paramBoolean + paramCompressInfo.c);
      }
      paramCompressInfo.jdField_e_of_type_JavaLangString = paramCompressInfo.c;
      azjq.b("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", " destSize > srcSize, info.destPath = info.srcPath");
      return;
    }
    azjq.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", "src length is too small");
    paramBoolean = "MI 6".equals(Build.MODEL);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "SendPicSrcProblem", paramBoolean, 0L, l1, null, "");
    return;
    paramCompressInfo.jdField_e_of_type_JavaLangString = paramCompressInfo.c;
    azjq.b("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", "info.isSuccess = false, info.destPath = info.srcPath");
  }
  
  public static boolean a(CompressInfo paramCompressInfo)
  {
    boolean bool1;
    if (paramCompressInfo == null) {
      bool1 = false;
    }
    long l1;
    boolean bool2;
    do
    {
      return bool1;
      azjq.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " CompressOperator.start()", "processName = " + BaseApplicationImpl.sApplication.getQQProcessName() + ",srcPath = " + paramCompressInfo.c);
      l1 = System.currentTimeMillis();
      int i = aczy.a().a(0, 1, 1, Process.myTid(), 2000, 203, 128L, Process.myTid(), "sendPic", true);
      bool2 = a(paramCompressInfo, false);
      long l2 = System.currentTimeMillis();
      paramCompressInfo = null;
      if (aczy.a().a())
      {
        paramCompressInfo = new HashMap();
        paramCompressInfo.put("hcState", String.valueOf(aczy.a().a()));
        paramCompressInfo.put("model", Build.MODEL);
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "AIOPicCompress", bool2, l2 - l1, 0L, paramCompressInfo, "");
      if (i != 0) {
        aczy.a().a(i);
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("CompressOperator", 2, "pic compress cost=" + (System.currentTimeMillis() - l1));
    return bool2;
  }
  
  private static boolean a(CompressInfo paramCompressInfo, boolean paramBoolean)
  {
    if ((paramCompressInfo == null) || (!FileUtils.fileExistsAndNotEmpty(paramCompressInfo.c)))
    {
      azjq.b("CompressOperator", " startImpl()", "info == null || TextUtils.isEmpty(info.srcPath)");
      return false;
    }
    Object localObject;
    if ((jdField_a_of_type_JavaUtilList != null) && (jdField_a_of_type_JavaUtilList.contains(paramBoolean + paramCompressInfo.c)))
    {
      azjq.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " startImpl()", jdField_a_of_type_JavaLangString);
      paramCompressInfo.jdField_f_of_type_JavaLangString = ("CompressOperator" + paramCompressInfo.jdField_a_of_type_JavaLangString + " startImpl()" + jdField_a_of_type_JavaLangString);
      paramCompressInfo.jdField_e_of_type_JavaLangString = paramCompressInfo.c;
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramCompressInfo.jdField_e_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      paramCompressInfo.d = ((BitmapFactory.Options)localObject).outWidth;
      paramCompressInfo.jdField_e_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      return true;
    }
    paramCompressInfo.h = NetworkUtil.getNetworkType(BaseApplication.getContext());
    if (azlo.a(paramCompressInfo.c))
    {
      paramCompressInfo.jdField_f_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        azjq.a("CompressOperator", " startImpl()", "info:" + paramCompressInfo);
      }
      localObject = a(paramCompressInfo);
      if (!paramBoolean) {
        break label341;
      }
    }
    label341:
    for (boolean bool = ((azli)localObject).b();; bool = ((azli)localObject).a())
    {
      paramCompressInfo.jdField_a_of_type_Boolean = bool;
      a(paramCompressInfo, paramBoolean);
      if (paramCompressInfo.jdField_e_of_type_JavaLangString != null)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      }
      try
      {
        bheg.a(paramCompressInfo.jdField_e_of_type_JavaLangString, (BitmapFactory.Options)localObject);
        paramCompressInfo.d = ((BitmapFactory.Options)localObject).outWidth;
        paramCompressInfo.jdField_e_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
        return paramCompressInfo.jdField_a_of_type_Boolean;
      }
      catch (OutOfMemoryError paramCompressInfo) {}
      if (PhotoUtils.isLargeFile(paramCompressInfo.c))
      {
        paramCompressInfo.jdField_f_of_type_Int = 1;
        break;
      }
      paramCompressInfo.jdField_f_of_type_Int = 0;
      break;
    }
    return false;
  }
  
  public static boolean b(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo == null) {
      return false;
    }
    azjq.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", "");
    return a(paramCompressInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlg
 * JD-Core Version:    0.7.0.1
 */