import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import protocol.KQQConfig.GetResourceRespInfoV2;

public class amox
  implements bbmi
{
  private static int jdField_a_of_type_Int = 1;
  public static final byte[] a;
  public amoy a;
  private File jdField_a_of_type_JavaIoFile;
  String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String b;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[] { -16, 68, 31, 95, -12, 45, -91, -113, -36, -9, -108, -102, -70, 98, -44, 17 };
  }
  
  public amox(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Amoy = new amoy(this);
    String str = paramContext.getFilesDir().getAbsolutePath() + "/" + paramString;
    File localFile = new File(str);
    if (localFile != null) {}
    try
    {
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
    catch (Exception localException)
    {
      label82:
      break label82;
    }
    this.jdField_a_of_type_JavaLangString = (paramContext.getFilesDir().getAbsolutePath() + "/" + paramString + "/" + "qq_config.dat");
    if (QLog.isDevelopLevel()) {
      QLog.i("SPLASH_ConfigServlet", 4, "savePointFilePath == " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_JavaIoFile = new File(str, "qq_config.dat");
    try
    {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {
        this.jdField_a_of_type_JavaIoFile.createNewFile();
      }
      this.jdField_a_of_type_JavaUtilTimer = ThreadManager.getTimer();
      this.b = paramString;
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static final int a()
  {
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    return i;
  }
  
  public static ResourcePluginInfo a(aukn paramaukn, boolean paramBoolean, GetResourceRespInfoV2 paramGetResourceRespInfoV2)
  {
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = paramGetResourceRespInfoV2.strPkgName;
    localResourcePluginInfo.strResName = paramGetResourceRespInfoV2.strResName;
    Object localObject;
    String str;
    if (paramBoolean)
    {
      localObject = paramGetResourceRespInfoV2.strResURL_big;
      localResourcePluginInfo.strResURL = ((String)localObject);
      localResourcePluginInfo.uiCurVer = paramGetResourceRespInfoV2.uiNewVer;
      localResourcePluginInfo.sLanType = paramGetResourceRespInfoV2.sLanType;
      localResourcePluginInfo.sResSubType = paramGetResourceRespInfoV2.sResSubType;
      if (QLog.isColorLevel()) {
        QLog.i("ConfigManager", 2, "plugin config xml:" + paramGetResourceRespInfoV2.strResConf);
      }
      localObject = amoz.a(paramGetResourceRespInfoV2.strResConf);
      if (localObject == null) {
        break label413;
      }
      localResourcePluginInfo.strGotoUrl = ((String)((HashMap)localObject).get("pluginEntranceUrl"));
      str = (String)((HashMap)localObject).get("newswitch");
      if (str == null) {}
    }
    for (;;)
    {
      try
      {
        if ((byte)Integer.parseInt(str) == 0)
        {
          localResourcePluginInfo.isNew = 1;
          str = (String)((HashMap)localObject).get("pluginType");
        }
      }
      catch (Exception localException2)
      {
        try
        {
          localResourcePluginInfo.lebaSearchResultType = Integer.parseInt(str);
          localResourcePluginInfo.pluginSetTips = ((String)((HashMap)localObject).get("pluginSetTips"));
          localResourcePluginInfo.pluginBg = ((String)((HashMap)localObject).get("bgcolor"));
          localObject = (String)((HashMap)localObject).get("fullConfig");
          if (TextUtils.isEmpty((CharSequence)localObject)) {}
        }
        catch (Exception localException2)
        {
          try
          {
            if (Integer.parseInt((String)localObject) == 1)
            {
              localResourcePluginInfo.enableFlag(1);
              if (QLog.isColorLevel()) {
                QLog.i("WholePeopleLebaEntryChecker", 2, "fullConfig " + (String)localObject);
              }
              localResourcePluginInfo.strNewPluginDesc = paramGetResourceRespInfoV2.strNewPluginDesc;
              localResourcePluginInfo.strNewPluginURL = paramGetResourceRespInfoV2.strNewPluginURL;
              localResourcePluginInfo.sPriority = paramGetResourceRespInfoV2.sPriority;
              localResourcePluginInfo.strResDesc = paramGetResourceRespInfoV2.strResDesc;
              localResourcePluginInfo.cCanChangeState = paramGetResourceRespInfoV2.cCanChangeState;
              localResourcePluginInfo.cDefaultState = paramGetResourceRespInfoV2.cDefaultState;
              localResourcePluginInfo.uiResId = paramGetResourceRespInfoV2.uiResId;
              if (localResourcePluginInfo.cDefaultState != 0) {
                break label450;
              }
              localResourcePluginInfo.cLocalState = 1;
              localResourcePluginInfo.iPluginType = paramGetResourceRespInfoV2.iPluginType;
              ResourcePluginInfo.persistOrReplace(paramaukn, localResourcePluginInfo);
              return localResourcePluginInfo;
              localObject = paramGetResourceRespInfoV2.strResURL_small;
              break;
              localResourcePluginInfo.isNew = 0;
              continue;
              localException1 = localException1;
              continue;
              localException2 = localException2;
              localResourcePluginInfo.lebaSearchResultType = -1;
              continue;
            }
            localResourcePluginInfo.disableFlag(1);
            continue;
          }
          catch (Exception localException3)
          {
            continue;
          }
        }
      }
      label413:
      localResourcePluginInfo.strGotoUrl = "";
      localResourcePluginInfo.isNew = 0;
      localResourcePluginInfo.lebaSearchResultType = -1;
      localResourcePluginInfo.pluginSetTips = "";
      localResourcePluginInfo.pluginBg = null;
      continue;
      label450:
      if (localResourcePluginInfo.cDefaultState == 1) {
        localResourcePluginInfo.cLocalState = 0;
      }
    }
  }
  
  static String a(String paramString, int paramInt)
  {
    if ((paramInt <= 0) || (paramString.indexOf("g_q=") != -1)) {
      return paramString;
    }
    if (paramString.indexOf('?') > 0)
    {
      if (paramString.endsWith("g_q=")) {
        return paramString + paramInt;
      }
      return paramString + "&g_q=" + paramInt;
    }
    return paramString + "?g_q=" + paramInt;
  }
  
  private void a(andv paramandv, DataInputStream paramDataInputStream)
  {
    paramandv.a(paramDataInputStream);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore_2
    //   8: aload_0
    //   9: getfield 110	amox:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   12: ifnull +392 -> 404
    //   15: aload_0
    //   16: getfield 110	amox:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   19: invokevirtual 85	java/io/File:exists	()Z
    //   22: ifeq +382 -> 404
    //   25: aload_0
    //   26: getfield 110	amox:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   29: invokevirtual 310	java/io/File:canRead	()Z
    //   32: ifeq +372 -> 404
    //   35: aload_0
    //   36: getfield 110	amox:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   39: invokevirtual 314	java/io/File:length	()J
    //   42: lconst_0
    //   43: lcmp
    //   44: ifle +360 -> 404
    //   47: new 316	java/io/FileInputStream
    //   50: dup
    //   51: aload_0
    //   52: getfield 110	amox:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   55: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: astore_3
    //   59: new 321	java/io/BufferedInputStream
    //   62: dup
    //   63: aload_3
    //   64: invokespecial 324	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: astore 5
    //   69: aload_3
    //   70: astore 4
    //   72: aload 5
    //   74: astore_3
    //   75: aload 6
    //   77: astore 5
    //   79: aload_3
    //   80: ifnull +105 -> 185
    //   83: aload 6
    //   85: astore 5
    //   87: aload_3
    //   88: invokevirtual 327	java/io/BufferedInputStream:available	()I
    //   91: ifle +94 -> 185
    //   94: new 329	java/io/DataInputStream
    //   97: dup
    //   98: aload_3
    //   99: invokespecial 330	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   102: astore 6
    //   104: iconst_0
    //   105: istore_1
    //   106: iload_1
    //   107: getstatic 335	amov:a	[Landv;
    //   110: arraylength
    //   111: if_icmpge +70 -> 181
    //   114: getstatic 335	amov:a	[Landv;
    //   117: iload_1
    //   118: aaload
    //   119: astore 5
    //   121: aload_0
    //   122: aload 5
    //   124: aload 6
    //   126: invokespecial 337	amox:a	(Landv;Ljava/io/DataInputStream;)V
    //   129: aload 5
    //   131: getfield 339	andv:a	B
    //   134: iconst_1
    //   135: if_icmpeq +11 -> 146
    //   138: aload 5
    //   140: getfield 339	andv:a	B
    //   143: ifne +16 -> 159
    //   146: aload 5
    //   148: invokevirtual 341	andv:a	()Z
    //   151: ifeq +8 -> 159
    //   154: aload 5
    //   156: invokevirtual 343	andv:a	()V
    //   159: iload_1
    //   160: iconst_1
    //   161: iadd
    //   162: istore_1
    //   163: goto -57 -> 106
    //   166: astore_3
    //   167: aconst_null
    //   168: astore_3
    //   169: aconst_null
    //   170: astore 5
    //   172: aload_3
    //   173: astore 4
    //   175: aload 5
    //   177: astore_3
    //   178: goto -103 -> 75
    //   181: aload 6
    //   183: astore 5
    //   185: aload 4
    //   187: ifnull +8 -> 195
    //   190: aload 4
    //   192: invokevirtual 346	java/io/FileInputStream:close	()V
    //   195: aload_3
    //   196: ifnull +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 347	java/io/BufferedInputStream:close	()V
    //   203: aload 5
    //   205: ifnull +8 -> 213
    //   208: aload 5
    //   210: invokevirtual 348	java/io/DataInputStream:close	()V
    //   213: iconst_0
    //   214: istore_1
    //   215: iload_1
    //   216: ifeq +151 -> 367
    //   219: iload_2
    //   220: istore_1
    //   221: iload_1
    //   222: getstatic 335	amov:a	[Landv;
    //   225: arraylength
    //   226: if_icmpge +141 -> 367
    //   229: getstatic 335	amov:a	[Landv;
    //   232: iload_1
    //   233: aaload
    //   234: invokevirtual 343	andv:a	()V
    //   237: iload_1
    //   238: iconst_1
    //   239: iadd
    //   240: istore_1
    //   241: goto -20 -> 221
    //   244: astore_3
    //   245: iconst_0
    //   246: istore_1
    //   247: goto -32 -> 215
    //   250: astore 6
    //   252: aload 7
    //   254: astore 5
    //   256: aload 6
    //   258: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   261: aload 4
    //   263: ifnull +8 -> 271
    //   266: aload 4
    //   268: invokevirtual 346	java/io/FileInputStream:close	()V
    //   271: aload_3
    //   272: ifnull +7 -> 279
    //   275: aload_3
    //   276: invokevirtual 347	java/io/BufferedInputStream:close	()V
    //   279: aload 5
    //   281: ifnull +8 -> 289
    //   284: aload 5
    //   286: invokevirtual 348	java/io/DataInputStream:close	()V
    //   289: iconst_1
    //   290: istore_1
    //   291: goto -76 -> 215
    //   294: astore_3
    //   295: iconst_1
    //   296: istore_1
    //   297: goto -82 -> 215
    //   300: astore 5
    //   302: aconst_null
    //   303: astore 6
    //   305: aload 4
    //   307: ifnull +8 -> 315
    //   310: aload 4
    //   312: invokevirtual 346	java/io/FileInputStream:close	()V
    //   315: aload_3
    //   316: ifnull +7 -> 323
    //   319: aload_3
    //   320: invokevirtual 347	java/io/BufferedInputStream:close	()V
    //   323: aload 6
    //   325: ifnull +8 -> 333
    //   328: aload 6
    //   330: invokevirtual 348	java/io/DataInputStream:close	()V
    //   333: aload 5
    //   335: athrow
    //   336: astore 4
    //   338: goto -143 -> 195
    //   341: astore_3
    //   342: goto -139 -> 203
    //   345: astore 4
    //   347: goto -76 -> 271
    //   350: astore_3
    //   351: goto -72 -> 279
    //   354: astore 4
    //   356: goto -41 -> 315
    //   359: astore_3
    //   360: goto -37 -> 323
    //   363: astore_3
    //   364: goto -31 -> 333
    //   367: return
    //   368: astore 5
    //   370: goto -65 -> 305
    //   373: astore 7
    //   375: aload 5
    //   377: astore 6
    //   379: aload 7
    //   381: astore 5
    //   383: goto -78 -> 305
    //   386: astore 7
    //   388: aload 6
    //   390: astore 5
    //   392: aload 7
    //   394: astore 6
    //   396: goto -140 -> 256
    //   399: astore 4
    //   401: goto -232 -> 169
    //   404: aconst_null
    //   405: astore_3
    //   406: aconst_null
    //   407: astore 4
    //   409: goto -334 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	this	amox
    //   105	192	1	i	int
    //   7	213	2	j	int
    //   58	41	3	localObject1	Object
    //   166	1	3	localException1	Exception
    //   168	32	3	localObject2	Object
    //   244	32	3	localException2	Exception
    //   294	26	3	localException3	Exception
    //   341	1	3	localException4	Exception
    //   350	1	3	localException5	Exception
    //   359	1	3	localException6	Exception
    //   363	1	3	localException7	Exception
    //   405	1	3	localObject3	Object
    //   70	241	4	localObject4	Object
    //   336	1	4	localException8	Exception
    //   345	1	4	localException9	Exception
    //   354	1	4	localException10	Exception
    //   399	1	4	localException11	Exception
    //   407	1	4	localObject5	Object
    //   67	218	5	localObject6	Object
    //   300	34	5	localObject7	Object
    //   368	8	5	localObject8	Object
    //   381	10	5	localObject9	Object
    //   4	178	6	localDataInputStream	DataInputStream
    //   250	7	6	localException12	Exception
    //   303	92	6	localObject10	Object
    //   1	252	7	localObject11	Object
    //   373	7	7	localObject12	Object
    //   386	7	7	localException13	Exception
    // Exception table:
    //   from	to	target	type
    //   47	59	166	java/lang/Exception
    //   208	213	244	java/lang/Exception
    //   87	104	250	java/lang/Exception
    //   284	289	294	java/lang/Exception
    //   87	104	300	finally
    //   190	195	336	java/lang/Exception
    //   199	203	341	java/lang/Exception
    //   266	271	345	java/lang/Exception
    //   275	279	350	java/lang/Exception
    //   310	315	354	java/lang/Exception
    //   319	323	359	java/lang/Exception
    //   328	333	363	java/lang/Exception
    //   106	146	368	finally
    //   146	159	368	finally
    //   256	261	373	finally
    //   106	146	386	java/lang/Exception
    //   146	159	386	java/lang/Exception
    //   59	69	399	java/lang/Exception
  }
  
  public void a(andv paramandv, DataOutputStream paramDataOutputStream)
  {
    paramandv.a(paramDataOutputStream);
  }
  
  public void a(bbmg arg1, bbmg parambbmg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShanPing", 2, "config-huibao--decode------------");
    }
    parambbmg2 = parambbmg2.a();
    try
    {
      synchronized (this.jdField_a_of_type_ArrayOfInt)
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        amoz.a(parambbmg2, new ampa(), this.b);
        a();
        d();
        return;
      }
      return;
    }
    catch (RuntimeException ???) {}
  }
  
  public void a(String paramString) {}
  
  public boolean a()
  {
    boolean bool = true;
    switch (this.jdField_a_of_type_Amoy.a)
    {
    default: 
      bool = false;
    }
    return bool;
  }
  
  public boolean a(bbmg parambbmg1, bbmg parambbmg2, int paramInt)
  {
    return true;
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists()))
      {
        this.jdField_a_of_type_JavaIoFile.delete();
        this.jdField_a_of_type_JavaIoFile = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(bbmg parambbmg1, bbmg parambbmg2)
  {
    d();
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: new 65	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: getfield 92	amox:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: putfield 110	amox:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   20: aload_0
    //   21: getfield 110	amox:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   24: invokevirtual 85	java/io/File:exists	()Z
    //   27: ifne +11 -> 38
    //   30: aload_0
    //   31: getfield 110	amox:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   34: invokevirtual 113	java/io/File:createNewFile	()Z
    //   37: pop
    //   38: aload_0
    //   39: getfield 110	amox:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   42: ifnull +92 -> 134
    //   45: aload_0
    //   46: getfield 110	amox:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   49: invokevirtual 85	java/io/File:exists	()Z
    //   52: ifeq +82 -> 134
    //   55: new 386	java/io/BufferedOutputStream
    //   58: dup
    //   59: new 388	java/io/FileOutputStream
    //   62: dup
    //   63: aload_0
    //   64: getfield 110	amox:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   67: invokespecial 389	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   70: invokespecial 392	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   73: astore_2
    //   74: new 394	java/io/DataOutputStream
    //   77: dup
    //   78: aload_2
    //   79: invokespecial 395	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   82: astore_3
    //   83: iconst_0
    //   84: istore_1
    //   85: iload_1
    //   86: getstatic 335	amov:a	[Landv;
    //   89: arraylength
    //   90: if_icmpge +28 -> 118
    //   93: aload_0
    //   94: getstatic 335	amov:a	[Landv;
    //   97: iload_1
    //   98: aaload
    //   99: aload_3
    //   100: invokevirtual 397	amox:a	(Landv;Ljava/io/DataOutputStream;)V
    //   103: iload_1
    //   104: iconst_1
    //   105: iadd
    //   106: istore_1
    //   107: goto -22 -> 85
    //   110: astore_2
    //   111: aload_2
    //   112: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   115: goto -77 -> 38
    //   118: aload_2
    //   119: ifnull +7 -> 126
    //   122: aload_2
    //   123: invokevirtual 398	java/io/BufferedOutputStream:close	()V
    //   126: aload_3
    //   127: ifnull +7 -> 134
    //   130: aload_3
    //   131: invokevirtual 399	java/io/DataOutputStream:close	()V
    //   134: return
    //   135: astore_2
    //   136: aconst_null
    //   137: astore_2
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 398	java/io/BufferedOutputStream:close	()V
    //   146: aload_2
    //   147: ifnull +7 -> 154
    //   150: aload_2
    //   151: invokevirtual 399	java/io/DataOutputStream:close	()V
    //   154: aload_0
    //   155: getfield 110	amox:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   158: invokevirtual 383	java/io/File:delete	()Z
    //   161: pop
    //   162: return
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_2
    //   166: aload_2
    //   167: ifnull +7 -> 174
    //   170: aload_2
    //   171: invokevirtual 398	java/io/BufferedOutputStream:close	()V
    //   174: aload 4
    //   176: ifnull +8 -> 184
    //   179: aload 4
    //   181: invokevirtual 399	java/io/DataOutputStream:close	()V
    //   184: aload_3
    //   185: athrow
    //   186: astore_2
    //   187: goto -61 -> 126
    //   190: astore_2
    //   191: return
    //   192: astore_3
    //   193: goto -47 -> 146
    //   196: astore_2
    //   197: goto -43 -> 154
    //   200: astore_2
    //   201: goto -27 -> 174
    //   204: astore_2
    //   205: goto -21 -> 184
    //   208: astore_3
    //   209: goto -43 -> 166
    //   212: astore 5
    //   214: aload_3
    //   215: astore 4
    //   217: aload 5
    //   219: astore_3
    //   220: goto -54 -> 166
    //   223: astore_3
    //   224: aconst_null
    //   225: astore 4
    //   227: aload_2
    //   228: astore_3
    //   229: aload 4
    //   231: astore_2
    //   232: goto -94 -> 138
    //   235: astore 4
    //   237: aload_2
    //   238: astore 4
    //   240: aload_3
    //   241: astore_2
    //   242: aload 4
    //   244: astore_3
    //   245: goto -107 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	amox
    //   84	23	1	i	int
    //   73	6	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   110	13	2	localException1	Exception
    //   135	1	2	localException2	Exception
    //   137	34	2	localObject1	Object
    //   186	1	2	localException3	Exception
    //   190	1	2	localException4	Exception
    //   196	1	2	localException5	Exception
    //   200	1	2	localException6	Exception
    //   204	24	2	localException7	Exception
    //   231	11	2	localObject2	Object
    //   4	139	3	localDataOutputStream	DataOutputStream
    //   163	22	3	localObject3	Object
    //   192	1	3	localException8	Exception
    //   208	7	3	localObject4	Object
    //   219	1	3	localObject5	Object
    //   223	1	3	localException9	Exception
    //   228	17	3	localObject6	Object
    //   1	229	4	localObject7	Object
    //   235	1	4	localException10	Exception
    //   238	5	4	localObject8	Object
    //   212	6	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   20	38	110	java/lang/Exception
    //   55	74	135	java/lang/Exception
    //   55	74	163	finally
    //   122	126	186	java/lang/Exception
    //   130	134	190	java/lang/Exception
    //   142	146	192	java/lang/Exception
    //   150	154	196	java/lang/Exception
    //   170	174	200	java/lang/Exception
    //   179	184	204	java/lang/Exception
    //   74	83	208	finally
    //   85	103	212	finally
    //   74	83	223	java/lang/Exception
    //   85	103	235	java/lang/Exception
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    Object localObject = amov.a();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((amow)((Iterator)localObject).next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amox
 * JD-Core Version:    0.7.0.1
 */