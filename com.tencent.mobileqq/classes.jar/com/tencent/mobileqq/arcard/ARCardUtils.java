package com.tencent.mobileqq.arcard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.av.ui.funchat.record.FileSwapHelper;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public final class ARCardUtils
{
  public static final String a;
  public static boolean a;
  public static String[] a;
  public static final String b;
  public static String c = "1";
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/ARRelationShip/video/";
    b = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/ARRelationShip/picture/";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "empty" };
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static Bitmap a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    BitmapManager.a(paramString, localOptions, localBitmapDecodeResult);
    return ImageUtil.c(localBitmapDecodeResult.a, 50, 50);
  }
  
  public static Bitmap a(String paramString, int paramInt)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    long l = paramInt * 1000;
    try
    {
      paramString = localMediaMetadataRetriever.getFrameAtTime(l, 0);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return null;
  }
  
  /* Error */
  public static android.graphics.Point a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 109	android/media/MediaMetadataRetriever
    //   5: dup
    //   6: invokespecial 110	android/media/MediaMetadataRetriever:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: aload_0
    //   14: invokevirtual 114	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   17: aload 4
    //   19: bipush 18
    //   21: invokevirtual 125	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   24: invokestatic 131	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   27: invokevirtual 135	java/lang/Integer:intValue	()I
    //   30: istore_1
    //   31: aload 4
    //   33: bipush 19
    //   35: invokevirtual 125	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   38: invokestatic 131	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   41: invokevirtual 135	java/lang/Integer:intValue	()I
    //   44: istore_3
    //   45: iload_3
    //   46: istore_2
    //   47: aload 4
    //   49: invokevirtual 138	android/media/MediaMetadataRetriever:release	()V
    //   52: new 140	android/graphics/Point
    //   55: dup
    //   56: iload_1
    //   57: iload_2
    //   58: invokespecial 143	android/graphics/Point:<init>	(II)V
    //   61: areturn
    //   62: astore_0
    //   63: iconst_0
    //   64: istore_1
    //   65: aload_0
    //   66: invokevirtual 146	java/lang/Exception:printStackTrace	()V
    //   69: aload 4
    //   71: invokevirtual 138	android/media/MediaMetadataRetriever:release	()V
    //   74: goto -22 -> 52
    //   77: astore_0
    //   78: aload 4
    //   80: invokevirtual 138	android/media/MediaMetadataRetriever:release	()V
    //   83: aload_0
    //   84: athrow
    //   85: astore_0
    //   86: goto -21 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramString	String
    //   30	35	1	i	int
    //   1	57	2	j	int
    //   44	2	3	k	int
    //   9	70	4	localMediaMetadataRetriever	MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   11	31	62	java/lang/Exception
    //   11	31	77	finally
    //   31	45	77	finally
    //   65	69	77	finally
    //   31	45	85	java/lang/Exception
  }
  
  public static String a(Bitmap paramBitmap, View paramView, boolean paramBoolean)
  {
    File localFile = new File(b(""));
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
    }
    catch (IOException paramBitmap)
    {
      try
      {
        localFileOutputStream = new FileOutputStream(localFile);
      }
      catch (FileNotFoundException paramBitmap)
      {
        try
        {
          for (;;)
          {
            FileOutputStream localFileOutputStream;
            label38:
            paramBitmap.compress(Bitmap.CompressFormat.JPEG, 90, localFileOutputStream);
            try
            {
              label49:
              localFileOutputStream.flush();
            }
            catch (IOException paramBitmap)
            {
              try
              {
                for (;;)
                {
                  localFileOutputStream.close();
                  label57:
                  if ((paramBoolean) && (paramView != null))
                  {
                    paramView.destroyDrawingCache();
                    paramView.setDrawingCacheEnabled(false);
                  }
                  return localFile.getAbsolutePath();
                  localIOException = localIOException;
                  localIOException.printStackTrace();
                  break;
                  localFileNotFoundException = localFileNotFoundException;
                  Object localObject = null;
                  break label38;
                  paramBitmap = paramBitmap;
                }
              }
              catch (IOException paramBitmap)
              {
                break label57;
              }
            }
          }
        }
        catch (Exception paramBitmap)
        {
          break label49;
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    paramString = paramString + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis()));
    paramString = paramString + FileSwapHelper.jdField_a_of_type_JavaLangString;
    File localFile = new File(paramString).getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramString;
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, ArCardSelectMemberActivity.class);
    localIntent.addFlags(65536);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", paramActivity.getString(2131438235));
    localIntent.putExtra("param_max", 20);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131432400));
    localIntent.putExtra("param_exit_animation", 1);
    if (paramInt2 == 1)
    {
      localIntent.putExtra("param_arcardtype", 2);
      localIntent.putExtra("video_send_path", paramString1);
      localIntent.putExtra("pic_send_path", paramString2);
    }
    for (;;)
    {
      localIntent.putExtra("aio_msg_title", paramString3);
      localIntent.putExtra("aio_msg_summary", paramString4);
      localIntent.putExtra("aio_msg_imageurl", paramString5);
      localIntent.putExtra("aio_msg_url", paramString6);
      localIntent.putExtra("send_msg_success_url", paramString7);
      localIntent.putExtra("taskId", paramString8);
      localIntent.putExtra("H5Source", paramString9);
      paramActivity.startActivity(localIntent);
      paramActivity.setResult(paramInt1);
      paramActivity.overridePendingTransition(0, 0);
      return;
      localIntent.putExtra("param_arcardtype", 3);
      localIntent.putExtra("pic_send_path", paramString1);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, 0);
    if (paramString1 != null) {
      BitmapUtils.a(paramString1, Bitmap.CompressFormat.JPEG, 80, paramString2);
    }
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].contains(str)) {
          bool1 = true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARCardUtils", 2, "isPhoneInBlackList ： phone = " + str + ", result=" + bool1);
        }
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(Bitmap paramBitmap, File paramFile, boolean paramBoolean)
  {
    try
    {
      ImageUtil.a(paramBitmap, paramFile);
      if (paramBoolean) {
        ImageUtil.a(BaseApplicationImpl.getContext(), paramFile.getAbsolutePath());
      }
      return true;
    }
    catch (IOException paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return false;
  }
  
  public static float[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt3 / paramInt4;
    float f2 = paramInt1 / paramInt2;
    if (f1 < f2)
    {
      f2 = paramInt4 * f2 / paramInt3;
      f1 = 1.0F;
    }
    for (;;)
    {
      float[] arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
      Matrix.scaleM(arrayOfFloat, 0, f2, f1, 1.0F);
      return arrayOfFloat;
      if (f1 > f2)
      {
        f1 = paramInt3 / (f2 * paramInt4);
        f2 = 1.0F;
      }
      else
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
    }
  }
  
  public static int b(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static String b(String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = b;
    }
    paramString = (String)localObject + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis()));
    paramString = paramString + ".jpg";
    localObject = new File(paramString).getParentFile();
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramString;
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    boolean bool3 = a();
    if (Build.VERSION.SDK_INT <= 18) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARCardUtils", 2, "checkNeedSoftDecode isPhoneInBlackList ： = " + bool3 + ", isSDKEnable=" + bool1);
      }
      if ((bool3) || (bool1)) {
        bool2 = true;
      }
      return bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARCardUtils
 * JD-Core Version:    0.7.0.1
 */