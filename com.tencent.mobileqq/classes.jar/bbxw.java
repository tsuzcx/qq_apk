import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForScribble.FileExistInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils.1;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bbxw
{
  public static int a;
  public static int b = 1;
  public static int c = 2;
  public static int d = 1;
  public static int e = 2;
  public static int f = 3;
  public static int g = 4;
  public static int h = 5;
  public static int i = 6;
  public static int j = 7;
  
  public static int a(MessageForScribble paramMessageForScribble)
  {
    boolean bool1 = paramMessageForScribble.mExistInfo.mDataFileExist;
    if (!paramMessageForScribble.mExistInfo.mInit) {
      bool1 = FileUtil.isFileExists(b(paramMessageForScribble));
    }
    boolean bool2 = paramMessageForScribble.mExistInfo.mCombineFileExist;
    if (!paramMessageForScribble.mExistInfo.mInit) {
      bool2 = FileUtil.isFileExists(a(paramMessageForScribble));
    }
    if ((bool1) && (bool2)) {
      return c;
    }
    if ((!bool1) && (bool2)) {
      return b;
    }
    return a;
  }
  
  public static String a()
  {
    return AppConstants.SCRIBBLE_FILE_DIR + "ScribbleCache/";
  }
  
  public static String a(MessageForScribble paramMessageForScribble)
  {
    if ((paramMessageForScribble != null) && (!TextUtils.isEmpty(paramMessageForScribble.combineFileMd5))) {
      return c(paramMessageForScribble.combineFileMd5);
    }
    return "";
  }
  
  private static void a()
  {
    File localFile = new File(a());
    if (((localFile.exists()) && (!localFile.isDirectory())) || (!localFile.exists())) {
      localFile.mkdirs();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, bbxx parambbxx)
  {
    a();
    new bbxy(paramQQAppInterface, paramString, paramInt1, paramBitmap, paramInt2, parambbxx).execute(new Void[0]);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble == null) {}
    bbxs localbbxs;
    MessageForScribble localMessageForScribble;
    do
    {
      return false;
      if (paramMessageForScribble.isSendFromLocal()) {
        paramQQAppInterface.getTransFileController().removeProcessor(paramQQAppInterface.getTransFileController().makeKey(paramMessageForScribble.frienduin, paramMessageForScribble.uniseq));
      }
      localbbxs = new bbxs(paramQQAppInterface);
      localMessageForScribble = localbbxs.a(paramMessageForScribble);
    } while (localMessageForScribble == null);
    ThreadManager.post(new ScribbleMsgUtils.1(paramQQAppInterface, paramMessageForScribble), 5, null, false);
    localbbxs.a(localMessageForScribble);
    return true;
  }
  
  public static int b(MessageForScribble paramMessageForScribble)
  {
    if ((paramMessageForScribble == null) || (paramMessageForScribble.combineFileMd5 == null)) {
      return j;
    }
    String str1 = a(paramMessageForScribble);
    if (!FileUtil.isFileExists(str1)) {
      return i;
    }
    long l = FileUtil.getFileSize(str1);
    if ((paramMessageForScribble.offSet <= 0) || (paramMessageForScribble.offSet >= (int)l))
    {
      QLog.e("ScribbleMsgUtils", 2, " offSet = " + paramMessageForScribble.offSet + " FileSize : " + l);
      return j;
    }
    String str2 = b(paramMessageForScribble);
    if (FileUtil.isFileExists(str2)) {
      FileUtil.deleteFile(str2);
    }
    if (bbyf.a(str1, paramMessageForScribble.offSet, str2)) {
      return d;
    }
    return e;
  }
  
  public static String b(MessageForScribble paramMessageForScribble)
  {
    if ((paramMessageForScribble != null) && (!TextUtils.isEmpty(paramMessageForScribble.combineFileMd5))) {
      return d(paramMessageForScribble.combineFileMd5);
    }
    return "";
  }
  
  private static String c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return a() + paramString;
    }
    return "";
  }
  
  private static String d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return a() + paramString + "_data";
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxw
 * JD-Core Version:    0.7.0.1
 */