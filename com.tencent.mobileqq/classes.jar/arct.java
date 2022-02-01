import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

public class arct
  implements Manager
{
  private QQAppInterface a;
  
  public arct(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a()
  {
    try
    {
      Object localObject = new File(this.a.getApp().getFilesDir().getAbsolutePath() + "/" + "NearbyBannerPic");
      int i;
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = Arrays.asList(((File)localObject).listFiles());
        if (((List)localObject).size() > 10)
        {
          Collections.sort((List)localObject, new arcu(this));
          i = 10;
        }
      }
      else
      {
        while (i < ((List)localObject).size())
        {
          a((File)((List)localObject).get(i));
          i += 1;
          continue;
          if (((File)localObject).isFile()) {
            a((File)localObject);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(File paramFile)
  {
    try
    {
      if (paramFile.exists())
      {
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        if (paramFile.isDirectory())
        {
          paramFile = paramFile.listFiles();
          if (paramFile != null)
          {
            int i = 0;
            while (i < paramFile.length)
            {
              a(paramFile[i]);
              i += 1;
            }
          }
        }
      }
      return;
    }
    catch (Exception paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyBannerManager", 2, "", paramFile);
      }
    }
  }
  
  public int a()
  {
    return ((Integer)axdz.a(this.a.getCurrentAccountUin(), "key_config_ver", Integer.valueOf(0))).intValue();
  }
  
  public Set<String> a()
  {
    return new HashSet(Arrays.asList(((String)axdz.a(this.a.getCurrentAccountUin(), "key_expired_banner", "")).split("\\|")));
  }
  
  public void a(int paramInt)
  {
    axdz.a(this.a.getCurrentAccountUin(), "key_config_ver", Integer.valueOf(paramInt));
  }
  
  /* Error */
  public void a(arcv paramarcv, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: iconst_1
    //   7: istore_3
    //   8: iconst_1
    //   9: istore 4
    //   11: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +11 -> 25
    //   17: ldc 107
    //   19: iconst_2
    //   20: ldc 157
    //   22: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: new 22	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   32: aload_0
    //   33: getfield 15	arct:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   36: invokevirtual 29	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   39: invokevirtual 35	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   42: invokevirtual 39	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   45: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 45
    //   50: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_0
    //   54: getfield 15	arct:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokevirtual 116	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   60: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore 6
    //   68: new 20	java/io/File
    //   71: dup
    //   72: new 22	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   79: aload 6
    //   81: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 45
    //   86: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 162
    //   91: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: astore 9
    //   102: aload_0
    //   103: aload 9
    //   105: invokespecial 94	arct:a	(Ljava/io/File;)V
    //   108: aload_0
    //   109: invokespecial 164	arct:a	()V
    //   112: new 20	java/io/File
    //   115: dup
    //   116: aload 6
    //   118: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: astore 6
    //   123: aload 6
    //   125: invokevirtual 57	java/io/File:exists	()Z
    //   128: ifne +9 -> 137
    //   131: aload 6
    //   133: invokevirtual 167	java/io/File:mkdirs	()Z
    //   136: pop
    //   137: aload 9
    //   139: invokevirtual 170	java/io/File:createNewFile	()Z
    //   142: pop
    //   143: aload 9
    //   145: ifnull +271 -> 416
    //   148: aload 9
    //   150: invokevirtual 57	java/io/File:exists	()Z
    //   153: ifeq +263 -> 416
    //   156: new 172	java/io/BufferedOutputStream
    //   159: dup
    //   160: new 174	java/io/FileOutputStream
    //   163: dup
    //   164: aload 9
    //   166: invokespecial 176	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   169: invokespecial 179	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   172: astore 6
    //   174: new 181	java/io/DataOutputStream
    //   177: dup
    //   178: aload 6
    //   180: invokespecial 182	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   183: astore 5
    //   185: aload_1
    //   186: aload 5
    //   188: invokevirtual 187	arcv:a	(Ljava/io/DataOutputStream;)V
    //   191: aload 6
    //   193: ifnull +8 -> 201
    //   196: aload 6
    //   198: invokevirtual 190	java/io/BufferedOutputStream:close	()V
    //   201: aload 5
    //   203: ifnull +8 -> 211
    //   206: aload 5
    //   208: invokevirtual 191	java/io/DataOutputStream:close	()V
    //   211: aload_1
    //   212: invokevirtual 193	arcv:d	()V
    //   215: aload_0
    //   216: iload_2
    //   217: invokevirtual 195	arct:a	(I)V
    //   220: invokestatic 200	axdm:c	()V
    //   223: iconst_0
    //   224: istore_2
    //   225: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq +35 -> 263
    //   231: new 22	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   238: ldc 202
    //   240: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: astore_1
    //   244: iload_2
    //   245: ifne +165 -> 410
    //   248: ldc 107
    //   250: iconst_2
    //   251: aload_1
    //   252: iload 4
    //   254: invokevirtual 205	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   257: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: return
    //   264: astore 6
    //   266: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq -126 -> 143
    //   272: ldc 107
    //   274: iconst_2
    //   275: ldc 109
    //   277: aload 6
    //   279: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: goto -139 -> 143
    //   285: astore 7
    //   287: aconst_null
    //   288: astore 8
    //   290: aload 5
    //   292: astore 6
    //   294: aload 8
    //   296: astore 5
    //   298: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +13 -> 314
    //   304: ldc 107
    //   306: iconst_2
    //   307: ldc 207
    //   309: aload 7
    //   311: invokestatic 113	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   314: aload 6
    //   316: ifnull +8 -> 324
    //   319: aload 6
    //   321: invokevirtual 190	java/io/BufferedOutputStream:close	()V
    //   324: aload 5
    //   326: ifnull +8 -> 334
    //   329: aload 5
    //   331: invokevirtual 191	java/io/DataOutputStream:close	()V
    //   334: aload_0
    //   335: aload 9
    //   337: invokespecial 94	arct:a	(Ljava/io/File;)V
    //   340: aload_0
    //   341: iconst_0
    //   342: invokevirtual 195	arct:a	(I)V
    //   345: iconst_1
    //   346: istore_2
    //   347: goto -122 -> 225
    //   350: astore 5
    //   352: iconst_0
    //   353: istore_3
    //   354: aconst_null
    //   355: astore 6
    //   357: aload 6
    //   359: ifnull +8 -> 367
    //   362: aload 6
    //   364: invokevirtual 190	java/io/BufferedOutputStream:close	()V
    //   367: aload 7
    //   369: ifnull +8 -> 377
    //   372: aload 7
    //   374: invokevirtual 191	java/io/DataOutputStream:close	()V
    //   377: iload_3
    //   378: ifeq +17 -> 395
    //   381: aload_0
    //   382: aload 9
    //   384: invokespecial 94	arct:a	(Ljava/io/File;)V
    //   387: aload_0
    //   388: iconst_0
    //   389: invokevirtual 195	arct:a	(I)V
    //   392: aload 5
    //   394: athrow
    //   395: aload_1
    //   396: invokevirtual 193	arcv:d	()V
    //   399: aload_0
    //   400: iload_2
    //   401: invokevirtual 195	arct:a	(I)V
    //   404: invokestatic 200	axdm:c	()V
    //   407: goto -15 -> 392
    //   410: iconst_0
    //   411: istore 4
    //   413: goto -165 -> 248
    //   416: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq -156 -> 263
    //   422: ldc 107
    //   424: iconst_2
    //   425: ldc 209
    //   427: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: return
    //   431: astore 6
    //   433: goto -232 -> 201
    //   436: astore 5
    //   438: goto -227 -> 211
    //   441: astore_1
    //   442: goto -118 -> 324
    //   445: astore_1
    //   446: goto -112 -> 334
    //   449: astore 6
    //   451: goto -84 -> 367
    //   454: astore 6
    //   456: goto -79 -> 377
    //   459: astore 5
    //   461: iconst_0
    //   462: istore_3
    //   463: goto -106 -> 357
    //   466: astore 8
    //   468: iconst_0
    //   469: istore_3
    //   470: aload 5
    //   472: astore 7
    //   474: aload 8
    //   476: astore 5
    //   478: goto -121 -> 357
    //   481: astore 8
    //   483: aload 5
    //   485: astore 7
    //   487: aload 8
    //   489: astore 5
    //   491: goto -134 -> 357
    //   494: astore 7
    //   496: aconst_null
    //   497: astore 5
    //   499: goto -201 -> 298
    //   502: astore 7
    //   504: goto -206 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	this	arct
    //   0	507	1	paramarcv	arcv
    //   0	507	2	paramInt	int
    //   7	463	3	i	int
    //   9	403	4	bool	boolean
    //   4	326	5	localObject1	Object
    //   350	43	5	localObject2	Object
    //   436	1	5	localException1	Exception
    //   459	12	5	localObject3	Object
    //   476	22	5	localObject4	Object
    //   66	131	6	localObject5	Object
    //   264	14	6	localException2	Exception
    //   292	71	6	localObject6	Object
    //   431	1	6	localException3	Exception
    //   449	1	6	localException4	Exception
    //   454	1	6	localException5	Exception
    //   1	1	7	localObject7	Object
    //   285	88	7	localException6	Exception
    //   472	14	7	localObject8	Object
    //   494	1	7	localException7	Exception
    //   502	1	7	localException8	Exception
    //   288	7	8	localObject9	Object
    //   466	9	8	localObject10	Object
    //   481	7	8	localObject11	Object
    //   100	283	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   123	137	264	java/lang/Exception
    //   137	143	264	java/lang/Exception
    //   156	174	285	java/lang/Exception
    //   156	174	350	finally
    //   196	201	431	java/lang/Exception
    //   206	211	436	java/lang/Exception
    //   319	324	441	java/lang/Exception
    //   329	334	445	java/lang/Exception
    //   362	367	449	java/lang/Exception
    //   372	377	454	java/lang/Exception
    //   174	185	459	finally
    //   185	191	466	finally
    //   298	314	481	finally
    //   174	185	494	java/lang/Exception
    //   185	191	502	java/lang/Exception
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arct
 * JD-Core Version:    0.7.0.1
 */