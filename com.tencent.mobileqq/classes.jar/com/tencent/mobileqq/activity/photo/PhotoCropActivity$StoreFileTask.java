package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class PhotoCropActivity$StoreFileTask
  extends AsyncTask<Void, Void, String>
{
  private PhotoCropActivity$StoreFileTask(PhotoCropActivity paramPhotoCropActivity) {}
  
  /* Error */
  private String a(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: new 23	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: getfield 11	com/tencent/mobileqq/activity/photo/PhotoCropActivity$StoreFileTask:a	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
    //   16: getfield 29	com/tencent/mobileqq/activity/photo/PhotoCropActivity:f	Ljava/lang/String;
    //   19: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_3
    //   23: aload_3
    //   24: invokevirtual 36	java/io/File:exists	()Z
    //   27: ifne +14 -> 41
    //   30: aload_0
    //   31: getfield 11	com/tencent/mobileqq/activity/photo/PhotoCropActivity$StoreFileTask:a	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
    //   34: getfield 29	com/tencent/mobileqq/activity/photo/PhotoCropActivity:f	Ljava/lang/String;
    //   37: invokestatic 41	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Ljava/io/File;
    //   40: pop
    //   41: new 43	java/io/BufferedOutputStream
    //   44: dup
    //   45: new 45	java/io/FileOutputStream
    //   48: dup
    //   49: aload_3
    //   50: invokespecial 48	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 51	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   56: astore_3
    //   57: aload_3
    //   58: astore_2
    //   59: aload_1
    //   60: getstatic 57	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   63: aload_0
    //   64: getfield 11	com/tencent/mobileqq/activity/photo/PhotoCropActivity$StoreFileTask:a	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
    //   67: getfield 61	com/tencent/mobileqq/activity/photo/PhotoCropActivity:k	I
    //   70: aload_3
    //   71: invokevirtual 67	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   74: pop
    //   75: aload_3
    //   76: astore_2
    //   77: aload_0
    //   78: getfield 11	com/tencent/mobileqq/activity/photo/PhotoCropActivity$StoreFileTask:a	Lcom/tencent/mobileqq/activity/photo/PhotoCropActivity;
    //   81: getfield 29	com/tencent/mobileqq/activity/photo/PhotoCropActivity:f	Ljava/lang/String;
    //   84: astore_1
    //   85: aload_3
    //   86: invokevirtual 70	java/io/BufferedOutputStream:close	()V
    //   89: aload_1
    //   90: areturn
    //   91: astore_2
    //   92: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +12 -> 107
    //   98: ldc 77
    //   100: iconst_2
    //   101: ldc 79
    //   103: aload_2
    //   104: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_1
    //   108: areturn
    //   109: astore_2
    //   110: aload_3
    //   111: astore_1
    //   112: aload_2
    //   113: astore_3
    //   114: goto +10 -> 124
    //   117: astore_1
    //   118: goto +54 -> 172
    //   121: astore_3
    //   122: aconst_null
    //   123: astore_1
    //   124: aload_1
    //   125: astore_2
    //   126: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +14 -> 143
    //   132: aload_1
    //   133: astore_2
    //   134: ldc 77
    //   136: iconst_2
    //   137: ldc 79
    //   139: aload_3
    //   140: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload_1
    //   144: ifnull +25 -> 169
    //   147: aload_1
    //   148: invokevirtual 70	java/io/BufferedOutputStream:close	()V
    //   151: aconst_null
    //   152: areturn
    //   153: astore_1
    //   154: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq +12 -> 169
    //   160: ldc 77
    //   162: iconst_2
    //   163: ldc 79
    //   165: aload_1
    //   166: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_1
    //   172: aload_2
    //   173: ifnull +26 -> 199
    //   176: aload_2
    //   177: invokevirtual 70	java/io/BufferedOutputStream:close	()V
    //   180: goto +19 -> 199
    //   183: astore_2
    //   184: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +12 -> 199
    //   190: ldc 77
    //   192: iconst_2
    //   193: ldc 79
    //   195: aload_2
    //   196: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   199: aload_1
    //   200: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	StoreFileTask
    //   0	201	1	paramBitmap	android.graphics.Bitmap
    //   1	76	2	localObject1	Object
    //   91	13	2	localIOException1	java.io.IOException
    //   109	4	2	localIOException2	java.io.IOException
    //   125	52	2	localBitmap	android.graphics.Bitmap
    //   183	13	2	localIOException3	java.io.IOException
    //   22	92	3	localObject2	Object
    //   121	19	3	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   85	89	91	java/io/IOException
    //   59	75	109	java/io/IOException
    //   77	85	109	java/io/IOException
    //   23	41	117	finally
    //   41	57	117	finally
    //   23	41	121	java/io/IOException
    //   41	57	121	java/io/IOException
    //   147	151	153	java/io/IOException
    //   59	75	171	finally
    //   77	85	171	finally
    //   126	132	171	finally
    //   134	143	171	finally
    //   176	180	183	java/io/IOException
  }
  
  protected String a(Void... paramVarArgs)
  {
    if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() <= 1) {
      return "sdcardfull";
    }
    try
    {
      if (this.a.x) {
        paramVarArgs = this.a.d.getDisplayBmp();
      } else {
        paramVarArgs = this.a.d.getBitmap();
      }
      paramVarArgs = a(paramVarArgs);
      if (QLog.isColorLevel()) {
        QLog.i("PhotoCropActivity", 2, String.format("store to %s", new Object[] { paramVarArgs }));
      }
      if (this.a.x)
      {
        Object localObject = this.a.d.getClipInfo();
        localObject = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getClipStr(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom);
        this.a.getIntent().putExtra("key_clip_info", (String)localObject);
      }
      return paramVarArgs;
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoCropActivity", 2, paramVarArgs.getMessage());
      }
    }
    return "oom";
  }
  
  protected void a(String paramString)
  {
    if ((!"oom".equals(paramString)) && (paramString != null))
    {
      if ("sdcardfull".equals(paramString))
      {
        QQToast.makeText(this.a, 2131892545, 0).show();
        return;
      }
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(paramString);
      if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.a.i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoCropActivity", 2, "StoreFileTask");
        }
        localObject = this.a.getIntent();
        if (ProfileCardUtil.a(this.a.app, paramString, (Intent)localObject))
        {
          this.a.D.sendMessage(Message.obtain(this.a.D, 1002));
          return;
        }
        ((Intent)localObject).putExtra("key_from_sdk_set_avatar_result", false);
        this.a.setResult(-1, (Intent)localObject);
        this.a.finish();
        return;
      }
      if ("FROM_EXTEND_FRIEND_AVATAR".equals(this.a.i))
      {
        paramString = this.a.getIntent();
        if (((ArrayList)localObject).size() > 0) {
          paramString.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)((ArrayList)localObject).get(0));
        }
        this.a.setResult(-1, paramString);
        this.a.finish();
        return;
      }
      if (100 == this.a.j)
      {
        this.a.getIntent().putExtra("PhotoConst.SYNCQZONE", this.a.A);
        this.a.getIntent().putExtra("PhotoConst.SYNCQZONE_CHECKSTATE", this.a.B);
      }
      paramString = this.a;
      PhotoUtils.sendPhoto(paramString, paramString.getIntent(), (ArrayList)localObject, 0, false);
      return;
    }
    QQToast.makeText(this.a, 2131892544, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropActivity.StoreFileTask
 * JD-Core Version:    0.7.0.1
 */