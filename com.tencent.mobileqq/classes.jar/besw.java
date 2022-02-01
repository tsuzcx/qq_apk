import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;
import org.apache.http.Header;

public class besw
  extends beqz
{
  static File jdField_a_of_type_JavaIoFile;
  static File b;
  public final int a;
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  public final int b;
  
  public besw(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_Int = 89500;
    this.jdField_b_of_type_Int = 89501;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    jdField_b_of_type_JavaIoFile = paramBaseApplicationImpl.getDir("", 0);
  }
  
  /* Error */
  protected File a(DownloadParams paramDownloadParams, asef paramasef)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_1
    //   7: getfield 42	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   10: invokevirtual 48	java/net/URL:getHost	()Ljava/lang/String;
    //   13: astore 9
    //   15: new 50	java/io/File
    //   18: dup
    //   19: new 52	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   26: getstatic 55	besw:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   29: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: ldc 61
    //   34: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload 9
    //   39: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore 7
    //   50: aload 7
    //   52: invokevirtual 74	java/io/File:exists	()Z
    //   55: ifeq +13 -> 68
    //   58: aload 7
    //   60: invokevirtual 78	java/io/File:length	()J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifne +349 -> 414
    //   68: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +54 -> 125
    //   74: ldc 85
    //   76: iconst_2
    //   77: new 52	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   84: ldc 87
    //   86: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: getfield 91	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   93: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 93
    //   98: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 9
    //   103: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 95
    //   108: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 7
    //   113: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   116: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: getstatic 108	begd:c	[Ljava/lang/String;
    //   128: astore 8
    //   130: aload 8
    //   132: arraylength
    //   133: istore 4
    //   135: iconst_0
    //   136: istore_3
    //   137: iload_3
    //   138: iload 4
    //   140: if_icmpge +325 -> 465
    //   143: aload 8
    //   145: iload_3
    //   146: aaload
    //   147: aload 9
    //   149: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   152: ifeq +172 -> 324
    //   155: iconst_1
    //   156: istore_3
    //   157: iload_3
    //   158: ifeq +218 -> 376
    //   161: new 50	java/io/File
    //   164: dup
    //   165: new 52	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   172: getstatic 55	besw:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   175: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   178: ldc 61
    //   180: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 9
    //   185: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: ldc 116
    //   190: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   199: astore 8
    //   201: aload 8
    //   203: invokevirtual 74	java/io/File:exists	()Z
    //   206: ifeq +9 -> 215
    //   209: aload 8
    //   211: invokevirtual 119	java/io/File:delete	()Z
    //   214: pop
    //   215: aload_0
    //   216: getfield 22	besw:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   219: invokevirtual 123	com/tencent/common/app/BaseApplicationImpl:getAssets	()Landroid/content/res/AssetManager;
    //   222: new 52	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   229: ldc 125
    //   231: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload 9
    //   236: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc 127
    //   241: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokevirtual 133	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   250: astore_1
    //   251: sipush 4096
    //   254: newarray byte
    //   256: astore 9
    //   258: new 135	java/io/FileOutputStream
    //   261: dup
    //   262: aload 8
    //   264: invokespecial 138	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   267: astore_2
    //   268: aload_1
    //   269: aload 9
    //   271: invokevirtual 144	java/io/InputStream:read	([B)I
    //   274: iconst_m1
    //   275: if_icmpeq +56 -> 331
    //   278: aload_2
    //   279: aload 9
    //   281: invokevirtual 148	java/io/FileOutputStream:write	([B)V
    //   284: aload_2
    //   285: invokevirtual 151	java/io/FileOutputStream:flush	()V
    //   288: goto -20 -> 268
    //   291: astore 5
    //   293: aload 5
    //   295: athrow
    //   296: astore 6
    //   298: aload_2
    //   299: astore 5
    //   301: aload 6
    //   303: astore_2
    //   304: aload_1
    //   305: ifnull +7 -> 312
    //   308: aload_1
    //   309: invokevirtual 154	java/io/InputStream:close	()V
    //   312: aload 5
    //   314: ifnull +8 -> 322
    //   317: aload 5
    //   319: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   322: aload_2
    //   323: athrow
    //   324: iload_3
    //   325: iconst_1
    //   326: iadd
    //   327: istore_3
    //   328: goto -191 -> 137
    //   331: aload_1
    //   332: ifnull +7 -> 339
    //   335: aload_1
    //   336: invokevirtual 154	java/io/InputStream:close	()V
    //   339: aload_2
    //   340: ifnull +7 -> 347
    //   343: aload_2
    //   344: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   347: aload 8
    //   349: aload 7
    //   351: invokevirtual 159	java/io/File:renameTo	(Ljava/io/File;)Z
    //   354: pop
    //   355: invokestatic 165	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   358: invokestatic 170	bdmc:a	(Landroid/content/Context;)Lbdmc;
    //   361: aconst_null
    //   362: ldc 172
    //   364: iconst_1
    //   365: lconst_0
    //   366: lconst_0
    //   367: aconst_null
    //   368: ldc 24
    //   370: invokevirtual 175	bdmc:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   373: aload 7
    //   375: areturn
    //   376: aload_2
    //   377: ifnull -4 -> 373
    //   380: aload_1
    //   381: ldc 177
    //   383: invokevirtual 181	com/tencent/image/DownloadParams:getHeader	(Ljava/lang/String;)Lorg/apache/http/Header;
    //   386: astore_1
    //   387: aload_1
    //   388: ifnull +13 -> 401
    //   391: aload_2
    //   392: aload_1
    //   393: invokeinterface 186 1 0
    //   398: invokevirtual 190	asef:b	(Ljava/lang/String;)V
    //   401: aload_2
    //   402: iconst_0
    //   403: invokevirtual 193	asef:c	(Z)V
    //   406: aload_2
    //   407: iconst_0
    //   408: invokevirtual 196	asef:d	(Z)V
    //   411: aload 7
    //   413: areturn
    //   414: aload_2
    //   415: ifnull -42 -> 373
    //   418: aload_2
    //   419: iconst_1
    //   420: invokevirtual 196	asef:d	(Z)V
    //   423: aload 7
    //   425: areturn
    //   426: astore_2
    //   427: aconst_null
    //   428: astore_1
    //   429: goto -125 -> 304
    //   432: astore_2
    //   433: goto -129 -> 304
    //   436: astore 6
    //   438: aload_2
    //   439: astore 5
    //   441: aload 6
    //   443: astore_2
    //   444: goto -140 -> 304
    //   447: astore 5
    //   449: aconst_null
    //   450: astore_1
    //   451: aload 6
    //   453: astore_2
    //   454: goto -161 -> 293
    //   457: astore 5
    //   459: aload 6
    //   461: astore_2
    //   462: goto -169 -> 293
    //   465: iconst_0
    //   466: istore_3
    //   467: goto -310 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	besw
    //   0	470	1	paramDownloadParams	DownloadParams
    //   0	470	2	paramasef	asef
    //   136	331	3	i	int
    //   133	8	4	j	int
    //   1	1	5	localObject1	Object
    //   291	3	5	localException1	Exception
    //   299	141	5	localasef	asef
    //   447	1	5	localException2	Exception
    //   457	1	5	localException3	Exception
    //   4	1	6	localObject2	Object
    //   296	6	6	localObject3	Object
    //   436	24	6	localObject4	Object
    //   48	376	7	localFile	File
    //   128	220	8	localObject5	Object
    //   13	267	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   268	288	291	java/lang/Exception
    //   293	296	296	finally
    //   215	251	426	finally
    //   251	268	432	finally
    //   268	288	436	finally
    //   215	251	447	java/lang/Exception
    //   251	268	457	java/lang/Exception
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    for (;;)
    {
      try
      {
        if ((jdField_a_of_type_JavaIoFile == null) || (!jdField_a_of_type_JavaIoFile.exists()))
        {
          jdField_a_of_type_JavaIoFile = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getDir("systemface", 0);
          paramOutputStream = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getDir("sysface", 0);
          if (paramOutputStream.exists()) {
            paramOutputStream.delete();
          }
          if (!jdField_a_of_type_JavaIoFile.exists()) {
            jdField_a_of_type_JavaIoFile.mkdirs();
          }
        }
        try
        {
          paramOutputStream = asde.a();
          paramOutputStream = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(paramOutputStream);
          if (paramOutputStream == null) {
            break label278;
          }
          paramOutputStream = (asde)paramOutputStream.getManager(77);
          if (paramOutputStream == null) {
            break label278;
          }
          paramOutputStream = (asef)paramOutputStream.a("qq.android.system.face.gifv14");
          paramOutputStream = a(paramDownloadParams, paramOutputStream);
          if (!paramOutputStream.exists()) {
            continue;
          }
          return paramOutputStream;
        }
        catch (Exception paramOutputStream)
        {
          if (!QLog.isColorLevel()) {
            break label283;
          }
        }
        QLog.d("EmotionDownloader", 2, "getting QQApp throws a Exception:" + paramOutputStream.getMessage());
      }
      catch (Exception paramOutputStream)
      {
        paramDownloadParams = new HashMap();
        paramDownloadParams.put("param_FailCode", Integer.toString(89500));
        paramDownloadParams.put("param_FailMsg", bera.a(paramOutputStream));
        bdmc.a(BaseApplication.getContext()).a(null, "system_face_decode_copyfile", false, 0L, 0L, paramDownloadParams, "");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EmotionDownloader", 2, "downloadImage", paramOutputStream);
        return jdField_b_of_type_JavaIoFile;
      }
      paramOutputStream = new HashMap();
      paramOutputStream.put("param_FailCode", Integer.toString(89501));
      bdmc.a(BaseApplication.getContext()).a(null, "system_face_decode_copyfile", false, 0L, 0L, paramOutputStream, "");
      paramOutputStream = jdField_b_of_type_JavaIoFile;
      return paramOutputStream;
      label278:
      paramOutputStream = null;
      continue;
      label283:
      paramOutputStream = null;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    try
    {
      if (paramFile.equals(jdField_b_of_type_JavaIoFile))
      {
        paramFile = paramDownloadParams.getHeader("KEY_STATIC_DRAWABLE_ID");
        if (paramFile != null)
        {
          paramFile = paramFile.getValue();
          if (paramFile != null)
          {
            int i = Integer.valueOf(paramFile).intValue();
            return BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), i);
          }
        }
      }
      else
      {
        if (GifDrawable.isGifFile(paramFile)) {
          return NativeGifFactory.getNativeGifObject(paramFile, false);
        }
        paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
        return paramFile;
      }
    }
    catch (Exception paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmotionDownloader", 2, "decode file", paramFile);
      }
      return null;
    }
    catch (OutOfMemoryError paramFile)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EmotionDownloader", 2, "decode file", paramFile);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besw
 * JD-Core Version:    0.7.0.1
 */