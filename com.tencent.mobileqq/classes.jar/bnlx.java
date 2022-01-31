import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bnlx
{
  public static int a;
  public static long a;
  public static Context a;
  public static String a;
  public static final int[] a;
  public static int b;
  private static String b;
  public static final int[] b;
  public static int c;
  private static String c;
  public static final int[] c;
  public static int d;
  private static String d;
  public static final int[] d;
  private static String e;
  public static final int[] e;
  private static String f;
  public static final int[] f;
  public static final int[] g = { 1280, 800 };
  public static final int[] h = { 720, 480 };
  
  static
  {
    jdField_a_of_type_AndroidContentContext = VideoEnvironment.a();
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 640;
    jdField_d_of_type_Int = 480;
    jdField_a_of_type_ArrayOfInt = new int[] { 960, 640 };
    jdField_b_of_type_ArrayOfInt = new int[] { 720, 480 };
    jdField_c_of_type_ArrayOfInt = new int[] { 720, 540, 640, 480, 480, 360, 320, 240 };
    jdField_d_of_type_ArrayOfInt = new int[] { 1, 1, 0 };
    jdField_e_of_type_ArrayOfInt = new int[] { 1, 0, 0 };
    jdField_f_of_type_ArrayOfInt = new int[] { 1, 1, 0 };
  }
  
  public static String a()
  {
    return jdField_c_of_type_JavaLangString;
  }
  
  public static void a()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)VideoEnvironment.a().getSystemService("audio");
      int j = localAudioManager.requestAudioFocus(null, 3, 2);
      int i = j;
      if (j == 0) {
        i = localAudioManager.requestAudioFocus(null, 3, 1);
      }
      if (i == 0) {
        localAudioManager.requestAudioFocus(null, 3, 3);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean a(long paramLong, Context paramContext)
  {
    if (paramLong <= 0L) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            bool1 = bdcs.a();
            if (!bool1)
            {
              if (QLog.isColorLevel()) {
                QLog.e("initDirs", 2, "hasSDCardAndWritable = false");
              }
              return bool1;
            }
            paramContext = bnol.a().jdField_b_of_type_JavaLangString;
            if (!TextUtils.isEmpty(paramContext)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("initDirs", 2, "sdcardDirPath = empty");
          return false;
          if (QLog.isColorLevel()) {
            QLog.e("initDirs", 2, "sdcardDirPath:storeVideoPath=" + paramContext);
          }
          localFile = new File(paramContext);
          if ((localFile.exists()) && (localFile.isDirectory()) && (localFile.canWrite())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("initDirs", 2, "exists OR isDirectory OR canWrite = false");
        return false;
        jdField_a_of_type_JavaLangString = paramContext + File.separator + "trimvideo";
        File localFile = new File(jdField_a_of_type_JavaLangString);
        bool1 = localFile.mkdirs();
        bool2 = localFile.isDirectory();
        if (QLog.isColorLevel()) {
          QLog.e("initDirs", 2, "trimVideoFilesDirPath:mkd=" + bool1 + " isdir=" + bool2);
        }
      } while ((!bool1) && (!bool2));
      jdField_e_of_type_JavaLangString = paramContext + "/Product";
      jdField_d_of_type_JavaLangString = paramContext + "/Material";
      jdField_f_of_type_JavaLangString = jdField_d_of_type_JavaLangString + "/ProcessedMaterial";
      jdField_b_of_type_JavaLangString = paramContext + "/log.txt";
      jdField_c_of_type_JavaLangString = paramContext + File.separator + "Source";
      paramContext = new File(jdField_c_of_type_JavaLangString);
      bool1 = paramContext.mkdirs();
      bool2 = paramContext.isDirectory();
      if (QLog.isColorLevel()) {
        QLog.e("initDirs", 2, "avSourceFilesDirPath:mkd=" + bool1 + " isdir=" + bool2);
      }
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  public static void b()
  {
    try
    {
      ((AudioManager)VideoEnvironment.a().getSystemService("audio")).abandonAudioFocus(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void c()
  {
    GlobalInit.nativeSyncProcessMsg(new MessageStruct(7), null, null);
    jdField_a_of_type_Long = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlx
 * JD-Core Version:    0.7.0.1
 */