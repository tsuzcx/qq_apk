import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class auie
{
  public static boolean a;
  
  @TargetApi(17)
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, Context paramContext)
  {
    paramContext = RenderScript.create(paramContext);
    Allocation localAllocation1 = Allocation.createFromBitmap(paramContext, paramBitmap);
    Allocation localAllocation2 = Allocation.createTyped(paramContext, localAllocation1.getType());
    ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create(paramContext, Element.U8_4(paramContext));
    localScriptIntrinsicBlur.setRadius(paramFloat);
    localScriptIntrinsicBlur.setInput(localAllocation1);
    localScriptIntrinsicBlur.forEach(localAllocation2);
    localAllocation2.copyTo(paramBitmap);
    localAllocation1.destroy();
    localAllocation2.destroy();
    localScriptIntrinsicBlur.destroy();
    paramContext.destroy();
    return paramBitmap;
  }
  
  private static String a()
  {
    String str = AppConstants.SDCARD_PATH + "HotPicVideo" + File.separator;
    File localFile = new File(str);
    if (!localFile.exists())
    {
      localFile.mkdirs();
      QLog.d("TAG", 2, "mkdirs here");
    }
    return str;
  }
  
  public static String a(long paramLong)
  {
    return new SimpleDateFormat("mm:ss").format(Long.valueOf(paramLong));
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = MD5Utils.toMD5(paramString);
      paramString = a() + paramString;
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("TAG", 2, "getStorageDir, Exception");
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static List<File> a(File paramFile)
  {
    LinkedList localLinkedList = new LinkedList();
    File[] arrayOfFile = paramFile.listFiles();
    paramFile = localLinkedList;
    if (arrayOfFile != null)
    {
      paramFile = Arrays.asList(arrayOfFile);
      Collections.sort(paramFile, new auig(null));
    }
    return paramFile;
  }
  
  public static boolean a()
  {
    if (!a)
    {
      TVK_SDKMgr.initSdk(BaseApplicationImpl.getApplication(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      a = true;
      QLog.d("HotVideoUtils", 2, " init sdk here");
    }
    return true;
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    paramString = new File(a(paramString));
    if (!paramString.exists()) {}
    while (paramString.length() != paramLong) {
      return false;
    }
    return true;
  }
  
  public static boolean b()
  {
    return TVK_SDKMgr.isInstalled(BaseApplicationImpl.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auie
 * JD-Core Version:    0.7.0.1
 */