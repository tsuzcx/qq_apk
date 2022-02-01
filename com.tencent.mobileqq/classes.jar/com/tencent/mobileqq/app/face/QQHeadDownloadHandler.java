package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import arai;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Setting;
import java.io.File;
import mqq.os.MqqHandler;

public class QQHeadDownloadHandler
  extends FaceDownloader
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130840502, 2130850698, 2130850699, 2130850700 };
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler b = new MqqHandler(ThreadManager.getSubThreadLooper());
  
  public QQHeadDownloadHandler(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = paramFriendListHandler;
  }
  
  private String a(QQHeadInfo paramQQHeadInfo, String paramString)
  {
    String str;
    if (paramQQHeadInfo.dstUsrType == 4) {
      str = "troop_" + paramString;
    }
    do
    {
      return str;
      if (paramQQHeadInfo.dstUsrType == 32) {
        return "stranger_" + Integer.toString(paramQQHeadInfo.idType) + "_" + paramString;
      }
      str = paramString;
    } while (paramQQHeadInfo.dstUsrType != 16);
    return "qcall_" + Integer.toString(paramQQHeadInfo.idType) + "_" + paramString;
  }
  
  /* Error */
  private void a(int paramInt, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: iload_1
    //   7: iflt +13 -> 20
    //   10: iload_1
    //   11: istore_3
    //   12: iload_1
    //   13: getstatic 19	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ArrayOfInt	[I
    //   16: arraylength
    //   17: if_icmplt +5 -> 22
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: getfield 46	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   29: invokevirtual 100	mqq/app/MobileQQ:getResources	()Landroid/content/res/Resources;
    //   32: getstatic 19	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ArrayOfInt	[I
    //   35: iload_3
    //   36: iaload
    //   37: invokevirtual 106	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   40: astore 6
    //   42: aload 6
    //   44: astore 4
    //   46: sipush 512
    //   49: newarray byte
    //   51: astore 6
    //   53: new 108	java/io/FileOutputStream
    //   56: dup
    //   57: aload_2
    //   58: invokespecial 111	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: astore_2
    //   62: aload 4
    //   64: aload 6
    //   66: invokevirtual 117	java/io/InputStream:read	([B)I
    //   69: istore_1
    //   70: iload_1
    //   71: ifle +51 -> 122
    //   74: aload_2
    //   75: aload 6
    //   77: iconst_0
    //   78: iload_1
    //   79: invokevirtual 121	java/io/FileOutputStream:write	([BII)V
    //   82: goto -20 -> 62
    //   85: astore 5
    //   87: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +13 -> 103
    //   93: ldc 129
    //   95: iconst_2
    //   96: ldc 131
    //   98: aload 5
    //   100: invokestatic 135	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   111: aload 4
    //   113: ifnull +8 -> 121
    //   116: aload 4
    //   118: invokevirtual 139	java/io/InputStream:close	()V
    //   121: return
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   130: aload 4
    //   132: ifnull -11 -> 121
    //   135: aload 4
    //   137: invokevirtual 139	java/io/InputStream:close	()V
    //   140: return
    //   141: astore_2
    //   142: aconst_null
    //   143: astore 4
    //   145: aload 5
    //   147: ifnull +8 -> 155
    //   150: aload 5
    //   152: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   155: aload 4
    //   157: ifnull +8 -> 165
    //   160: aload 4
    //   162: invokevirtual 139	java/io/InputStream:close	()V
    //   165: aload_2
    //   166: athrow
    //   167: astore_2
    //   168: goto -23 -> 145
    //   171: astore 6
    //   173: aload_2
    //   174: astore 5
    //   176: aload 6
    //   178: astore_2
    //   179: goto -34 -> 145
    //   182: astore 6
    //   184: aload_2
    //   185: astore 5
    //   187: aload 6
    //   189: astore_2
    //   190: goto -45 -> 145
    //   193: astore 5
    //   195: aconst_null
    //   196: astore_2
    //   197: goto -110 -> 87
    //   200: astore 5
    //   202: aconst_null
    //   203: astore_2
    //   204: goto -117 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	QQHeadDownloadHandler
    //   0	207	1	paramInt	int
    //   0	207	2	paramFile	File
    //   11	25	3	i	int
    //   4	157	4	localObject1	Object
    //   1	1	5	localObject2	Object
    //   85	66	5	localException1	java.lang.Exception
    //   174	12	5	localFile	File
    //   193	1	5	localException2	java.lang.Exception
    //   200	1	5	localException3	java.lang.Exception
    //   40	36	6	localObject3	Object
    //   171	6	6	localObject4	Object
    //   182	6	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   62	70	85	java/lang/Exception
    //   74	82	85	java/lang/Exception
    //   22	42	141	finally
    //   46	62	167	finally
    //   62	70	171	finally
    //   74	82	171	finally
    //   87	103	182	finally
    //   22	42	193	java/lang/Exception
    //   46	62	200	java/lang/Exception
  }
  
  private void a(QQHeadInfo paramQQHeadInfo, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    if ((paramBoolean2) || (!paramBoolean1))
    {
      if (paramQQHeadInfo.dstUsrType == 11) {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.notifyUI(39, true, new Object[] { paramString1 });
      }
    }
    else {
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.notifyUI(30, true, new Object[] { paramString1 });
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4, paramString1, 0, paramString2);
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 32)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.notifyUI(5, true, new Object[] { paramString1, Integer.valueOf(paramQQHeadInfo.idType), Boolean.valueOf(true) });
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.notifyUI(104, true, new Object[] { paramString1, Integer.valueOf(paramQQHeadInfo.idType), paramString3 });
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 16)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.notifyUI(6, true, new Object[] { paramString1, Integer.valueOf(paramQQHeadInfo.idType), Boolean.valueOf(true) });
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, paramString1, 0, paramString2);
    if (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(1, paramString1, 0, paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.notifyUI(4, true, new Object[] { paramString1 });
  }
  
  private void a(QQHeadInfo paramQQHeadInfo, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramQQHeadInfo.dstUsrType == 4) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4, paramString, paramQQHeadInfo.idType);
      }
    }
    else {
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 32)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(32, paramString, paramQQHeadInfo.idType);
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 16)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(16, paramString, paramQQHeadInfo.idType);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, paramString, paramQQHeadInfo.idType);
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 9207;
    case 1: 
      return 9206;
    case 4: 
      return 9202;
    case 33: 
      return 9208;
    }
    return 9204;
  }
  
  public static void b() {}
  
  public String a()
  {
    return arai.a(0);
  }
  
  /* Error */
  protected void a(FaceInfo paramFaceInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 186	com/tencent/mobileqq/app/face/FaceInfo:a	LAvatarInfo/QQHeadInfo;
    //   4: astore 35
    //   6: aload_0
    //   7: getfield 48	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   10: aload 35
    //   12: getfield 190	AvatarInfo/QQHeadInfo:uin	J
    //   15: aload 35
    //   17: getfield 194	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   20: invokevirtual 197	com/tencent/mobileqq/app/FriendListHandler:a	(JLjava/lang/String;)Ljava/lang/String;
    //   23: astore 36
    //   25: aload_0
    //   26: getfield 48	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   29: iconst_0
    //   30: aload 36
    //   32: aload 35
    //   34: getfield 57	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   37: iconst_3
    //   38: invokevirtual 200	com/tencent/mobileqq/app/FriendListHandler:a	(ILjava/lang/String;II)V
    //   41: aload_1
    //   42: getstatic 203	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   45: invokevirtual 206	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   48: iconst_0
    //   49: istore 28
    //   51: iconst_0
    //   52: istore 29
    //   54: iconst_0
    //   55: istore 30
    //   57: iconst_0
    //   58: istore 27
    //   60: iconst_0
    //   61: istore 8
    //   63: iconst_0
    //   64: istore 5
    //   66: iconst_0
    //   67: istore 17
    //   69: iconst_0
    //   70: istore 18
    //   72: iconst_0
    //   73: istore 13
    //   75: iconst_0
    //   76: istore 6
    //   78: aload 35
    //   80: getfield 209	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   83: astore 33
    //   85: iconst_0
    //   86: istore 15
    //   88: iconst_0
    //   89: istore 12
    //   91: iconst_0
    //   92: istore 16
    //   94: iconst_0
    //   95: istore 9
    //   97: iconst_0
    //   98: istore 19
    //   100: iconst_0
    //   101: istore 4
    //   103: iconst_0
    //   104: istore 14
    //   106: iconst_0
    //   107: istore 21
    //   109: iconst_0
    //   110: istore 22
    //   112: iconst_0
    //   113: istore 20
    //   115: iconst_0
    //   116: istore_2
    //   117: iload 15
    //   119: istore 10
    //   121: iload 18
    //   123: istore 7
    //   125: aload 33
    //   127: astore 32
    //   129: iload 22
    //   131: istore_3
    //   132: iload 29
    //   134: istore 25
    //   136: aload 35
    //   138: getfield 209	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   141: invokestatic 215	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +2429 -> 2573
    //   147: iload 15
    //   149: istore 10
    //   151: iload 18
    //   153: istore 7
    //   155: aload 33
    //   157: astore 32
    //   159: iload 22
    //   161: istore_3
    //   162: iload 29
    //   164: istore 25
    //   166: aload_0
    //   167: aload 35
    //   169: aload 36
    //   171: aload_0
    //   172: aload 35
    //   174: aload 36
    //   176: invokespecial 217	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;)Ljava/lang/String;
    //   179: iconst_0
    //   180: invokevirtual 220	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Ljava/lang/String;Z)[Ljava/lang/Object;
    //   183: astore 31
    //   185: iload 15
    //   187: istore 10
    //   189: iload 18
    //   191: istore 7
    //   193: aload 33
    //   195: astore 32
    //   197: iload 22
    //   199: istore_3
    //   200: iload 29
    //   202: istore 25
    //   204: aload 31
    //   206: iconst_0
    //   207: aaload
    //   208: checkcast 155	java/lang/Boolean
    //   211: invokevirtual 223	java/lang/Boolean:booleanValue	()Z
    //   214: istore 24
    //   216: iload 15
    //   218: istore 10
    //   220: iload 18
    //   222: istore 7
    //   224: aload 33
    //   226: astore 32
    //   228: iload 22
    //   230: istore_3
    //   231: iload 29
    //   233: istore 25
    //   235: aload 31
    //   237: iconst_1
    //   238: aaload
    //   239: checkcast 225	com/tencent/mobileqq/data/Setting
    //   242: astore 37
    //   244: iload 15
    //   246: istore 10
    //   248: iload 18
    //   250: istore 7
    //   252: aload 33
    //   254: astore 32
    //   256: iload 22
    //   258: istore_3
    //   259: iload 29
    //   261: istore 25
    //   263: aload_0
    //   264: getfield 46	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   267: invokevirtual 229	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   270: invokevirtual 235	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   273: invokestatic 240	bhlf:a	(Landroid/content/Context;)Z
    //   276: ifeq +127 -> 403
    //   279: iload 15
    //   281: istore 10
    //   283: iload 18
    //   285: istore 7
    //   287: aload 33
    //   289: astore 32
    //   291: iload 22
    //   293: istore_3
    //   294: iload 29
    //   296: istore 25
    //   298: invokestatic 244	bhjr:a	()Z
    //   301: ifeq +102 -> 403
    //   304: iload 15
    //   306: istore 10
    //   308: iload 18
    //   310: istore 7
    //   312: aload 33
    //   314: astore 32
    //   316: iload 22
    //   318: istore_3
    //   319: iload 29
    //   321: istore 25
    //   323: getstatic 26	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   326: astore 31
    //   328: iload 15
    //   330: istore 10
    //   332: iload 18
    //   334: istore 7
    //   336: aload 33
    //   338: astore 32
    //   340: iload 22
    //   342: istore_3
    //   343: iload 29
    //   345: istore 25
    //   347: aload 31
    //   349: monitorenter
    //   350: aload_0
    //   351: getfield 46	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   354: invokevirtual 229	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   357: invokevirtual 235	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   360: invokestatic 240	bhlf:a	(Landroid/content/Context;)Z
    //   363: ifeq +23 -> 386
    //   366: invokestatic 244	bhjr:a	()Z
    //   369: istore 23
    //   371: iload 23
    //   373: ifeq +13 -> 386
    //   376: ldc 246
    //   378: getstatic 251	antf:bL	Ljava/lang/String;
    //   381: iconst_1
    //   382: invokestatic 256	bhmi:a	(Ljava/lang/String;Ljava/lang/String;Z)I
    //   385: pop
    //   386: aload_0
    //   387: getfield 46	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   390: invokevirtual 229	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   393: invokevirtual 235	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   396: iconst_0
    //   397: invokestatic 259	bhlf:a	(Landroid/content/Context;Z)V
    //   400: aload 31
    //   402: monitorexit
    //   403: iload 15
    //   405: istore 10
    //   407: iload 18
    //   409: istore 7
    //   411: aload 33
    //   413: astore 32
    //   415: iload 22
    //   417: istore_3
    //   418: iload 29
    //   420: istore 25
    //   422: aload_0
    //   423: getfield 46	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   426: aload 37
    //   428: aload 35
    //   430: getfield 76	AvatarInfo/QQHeadInfo:idType	I
    //   433: invokevirtual 262	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;I)Ljava/lang/String;
    //   436: astore 31
    //   438: iload 15
    //   440: istore 10
    //   442: iload 18
    //   444: istore 7
    //   446: aload 33
    //   448: astore 32
    //   450: iload 22
    //   452: istore_3
    //   453: iload 29
    //   455: istore 25
    //   457: new 264	java/io/File
    //   460: dup
    //   461: aload 31
    //   463: iconst_0
    //   464: aload 31
    //   466: ldc_w 266
    //   469: invokevirtual 270	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   472: invokevirtual 274	java/lang/String:substring	(II)Ljava/lang/String;
    //   475: invokespecial 277	java/io/File:<init>	(Ljava/lang/String;)V
    //   478: astore 34
    //   480: aload 34
    //   482: ifnull +55 -> 537
    //   485: iload 15
    //   487: istore 10
    //   489: iload 18
    //   491: istore 7
    //   493: aload 33
    //   495: astore 32
    //   497: iload 22
    //   499: istore_3
    //   500: iload 29
    //   502: istore 25
    //   504: aload 34
    //   506: invokevirtual 280	java/io/File:exists	()Z
    //   509: ifne +28 -> 537
    //   512: iload 15
    //   514: istore 10
    //   516: iload 18
    //   518: istore 7
    //   520: aload 33
    //   522: astore 32
    //   524: iload 22
    //   526: istore_3
    //   527: iload 29
    //   529: istore 25
    //   531: aload 34
    //   533: invokevirtual 283	java/io/File:mkdirs	()Z
    //   536: pop
    //   537: iload 15
    //   539: istore 10
    //   541: iload 18
    //   543: istore 7
    //   545: aload 33
    //   547: astore 32
    //   549: iload 22
    //   551: istore_3
    //   552: iload 29
    //   554: istore 25
    //   556: new 264	java/io/File
    //   559: dup
    //   560: aload 31
    //   562: invokespecial 277	java/io/File:<init>	(Ljava/lang/String;)V
    //   565: astore 38
    //   567: iload 24
    //   569: istore 23
    //   571: iload 24
    //   573: ifne +37 -> 610
    //   576: iload 15
    //   578: istore 10
    //   580: iload 18
    //   582: istore 7
    //   584: aload 33
    //   586: astore 32
    //   588: iload 22
    //   590: istore_3
    //   591: iload 29
    //   593: istore 25
    //   595: aload 38
    //   597: invokevirtual 280	java/io/File:exists	()Z
    //   600: istore 23
    //   602: iload 23
    //   604: ifne +933 -> 1537
    //   607: iconst_1
    //   608: istore 23
    //   610: iload 23
    //   612: ifeq +1454 -> 2066
    //   615: iload 16
    //   617: istore 11
    //   619: iload 17
    //   621: istore 8
    //   623: aload 33
    //   625: astore 34
    //   627: iload 21
    //   629: istore 4
    //   631: iload 28
    //   633: istore 26
    //   635: iload 15
    //   637: istore 10
    //   639: iload 18
    //   641: istore 7
    //   643: aload 33
    //   645: astore 32
    //   647: iload 22
    //   649: istore_3
    //   650: iload 29
    //   652: istore 25
    //   654: aload_0
    //   655: aload 35
    //   657: getfield 209	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   660: aload 35
    //   662: getfield 286	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   665: aload 35
    //   667: getfield 57	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   670: aload 35
    //   672: getfield 289	AvatarInfo/QQHeadInfo:originUsrType	I
    //   675: invokevirtual 292	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(Ljava/lang/String;BBI)Ljava/lang/String;
    //   678: astore 33
    //   680: iload 16
    //   682: istore 11
    //   684: iload 17
    //   686: istore 8
    //   688: aload 33
    //   690: astore 34
    //   692: iload 21
    //   694: istore 4
    //   696: iload 28
    //   698: istore 26
    //   700: iload 15
    //   702: istore 10
    //   704: iload 18
    //   706: istore 7
    //   708: aload 33
    //   710: astore 32
    //   712: iload 22
    //   714: istore_3
    //   715: iload 29
    //   717: istore 25
    //   719: ldc_w 294
    //   722: aload 33
    //   724: invokestatic 300	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   727: astore 33
    //   729: iload 16
    //   731: istore 11
    //   733: iload 17
    //   735: istore 8
    //   737: aload 33
    //   739: astore 34
    //   741: iload 21
    //   743: istore 4
    //   745: iload 28
    //   747: istore 26
    //   749: iload 15
    //   751: istore 10
    //   753: iload 18
    //   755: istore 7
    //   757: aload 33
    //   759: astore 32
    //   761: iload 22
    //   763: istore_3
    //   764: iload 29
    //   766: istore 25
    //   768: new 59	java/lang/StringBuilder
    //   771: dup
    //   772: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   775: aload 33
    //   777: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: ldc_w 302
    //   783: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: invokestatic 308	java/lang/System:currentTimeMillis	()J
    //   789: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   792: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: astore 33
    //   797: aload 35
    //   799: getfield 314	AvatarInfo/QQHeadInfo:cHeadType	B
    //   802: ifne +829 -> 1631
    //   805: aload 35
    //   807: getfield 57	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   810: istore_3
    //   811: iload_3
    //   812: iconst_4
    //   813: if_icmpne +818 -> 1631
    //   816: aload 38
    //   818: invokevirtual 280	java/io/File:exists	()Z
    //   821: ifne +14 -> 835
    //   824: aload_0
    //   825: aload 35
    //   827: getfield 318	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   830: aload 38
    //   832: invokespecial 320	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(ILjava/io/File;)V
    //   835: iconst_1
    //   836: istore 24
    //   838: iload 12
    //   840: istore 5
    //   842: iload 9
    //   844: istore 11
    //   846: iload 6
    //   848: istore 8
    //   850: aload 33
    //   852: astore 34
    //   854: iload_2
    //   855: istore 4
    //   857: iload 24
    //   859: istore 26
    //   861: iload 5
    //   863: istore 10
    //   865: iload 6
    //   867: istore 7
    //   869: aload 33
    //   871: astore 32
    //   873: iload_2
    //   874: istore_3
    //   875: iload 24
    //   877: istore 25
    //   879: aload_0
    //   880: aload 35
    //   882: aload 36
    //   884: iload 24
    //   886: invokespecial 322	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Z)V
    //   889: iload 6
    //   891: istore 4
    //   893: aload 33
    //   895: astore_1
    //   896: iload_2
    //   897: istore_3
    //   898: iload 5
    //   900: istore_2
    //   901: iload 9
    //   903: istore 5
    //   905: aload_0
    //   906: aload 35
    //   908: aload 36
    //   910: aload 31
    //   912: iload 23
    //   914: iload 24
    //   916: aload_1
    //   917: invokespecial 324	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V
    //   920: iload 24
    //   922: istore 25
    //   924: aload_1
    //   925: astore 33
    //   927: iload 4
    //   929: istore 6
    //   931: aload 31
    //   933: astore_1
    //   934: iload 23
    //   936: istore 24
    //   938: iload 25
    //   940: istore 23
    //   942: iload 5
    //   944: istore 4
    //   946: iload_3
    //   947: istore 5
    //   949: iload 6
    //   951: istore_3
    //   952: new 326	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   955: dup
    //   956: aload_0
    //   957: iload_2
    //   958: aload 36
    //   960: aload 35
    //   962: getfield 76	AvatarInfo/QQHeadInfo:idType	I
    //   965: aload 35
    //   967: getfield 57	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   970: iconst_4
    //   971: iload_3
    //   972: aload 33
    //   974: iload 5
    //   976: invokestatic 308	java/lang/System:currentTimeMillis	()J
    //   979: invokespecial 329	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIILjava/lang/String;IJ)V
    //   982: aconst_null
    //   983: iconst_0
    //   984: invokestatic 333	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   987: aload_0
    //   988: getfield 46	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   991: sipush 199
    //   994: invokevirtual 337	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   997: checkcast 339	apdc
    //   1000: astore 31
    //   1002: iload_2
    //   1003: istore_3
    //   1004: aload 33
    //   1006: astore 32
    //   1008: iload 4
    //   1010: istore 5
    //   1012: iload 23
    //   1014: istore 25
    //   1016: iload 24
    //   1018: istore 26
    //   1020: aload_1
    //   1021: astore 34
    //   1023: iload 23
    //   1025: ifne +92 -> 1117
    //   1028: iload_2
    //   1029: istore_3
    //   1030: aload 33
    //   1032: astore 32
    //   1034: iload 4
    //   1036: istore 5
    //   1038: iload 23
    //   1040: istore 25
    //   1042: iload 24
    //   1044: istore 26
    //   1046: aload_1
    //   1047: astore 34
    //   1049: aload 31
    //   1051: ifnull +66 -> 1117
    //   1054: iload_2
    //   1055: istore_3
    //   1056: aload 33
    //   1058: astore 32
    //   1060: iload 4
    //   1062: istore 5
    //   1064: iload 23
    //   1066: istore 25
    //   1068: iload 24
    //   1070: istore 26
    //   1072: aload_1
    //   1073: astore 34
    //   1075: aload 31
    //   1077: invokevirtual 340	apdc:a	()Z
    //   1080: ifeq +37 -> 1117
    //   1083: aload 31
    //   1085: aload 35
    //   1087: getfield 190	AvatarInfo/QQHeadInfo:uin	J
    //   1090: invokestatic 343	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1093: invokevirtual 345	apdc:a	(Ljava/lang/String;)V
    //   1096: aload_1
    //   1097: astore 34
    //   1099: iload 24
    //   1101: istore 26
    //   1103: iload 23
    //   1105: istore 25
    //   1107: iload 4
    //   1109: istore 5
    //   1111: aload 33
    //   1113: astore 32
    //   1115: iload_2
    //   1116: istore_3
    //   1117: ldc 129
    //   1119: iconst_2
    //   1120: new 59	java/lang/StringBuilder
    //   1123: dup
    //   1124: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1127: ldc_w 347
    //   1130: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: iload 25
    //   1135: invokevirtual 350	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1138: ldc_w 352
    //   1141: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: iload_3
    //   1145: invokevirtual 355	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1148: ldc_w 357
    //   1151: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload 35
    //   1156: getfield 190	AvatarInfo/QQHeadInfo:uin	J
    //   1159: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1162: ldc_w 359
    //   1165: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: iload 26
    //   1170: invokevirtual 350	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1173: ldc_w 361
    //   1176: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1179: aload 35
    //   1181: getfield 194	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   1184: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: ldc_w 363
    //   1190: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: aload 35
    //   1195: getfield 314	AvatarInfo/QQHeadInfo:cHeadType	B
    //   1198: invokevirtual 355	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1201: ldc_w 365
    //   1204: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: aload 35
    //   1209: getfield 57	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1212: invokevirtual 355	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1215: ldc_w 367
    //   1218: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: aload 35
    //   1223: getfield 318	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   1226: invokevirtual 355	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1229: ldc_w 369
    //   1232: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: iload 5
    //   1237: invokevirtual 355	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1240: ldc_w 371
    //   1243: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: aload 35
    //   1248: getfield 374	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   1251: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1254: ldc_w 376
    //   1257: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: aload 34
    //   1262: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: ldc_w 378
    //   1268: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: aload 32
    //   1273: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: ldc_w 380
    //   1279: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: aload 35
    //   1284: getfield 209	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   1287: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: ldc_w 382
    //   1293: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: aload 35
    //   1298: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1301: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1304: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1307: return
    //   1308: astore 32
    //   1310: aload 32
    //   1312: invokevirtual 392	java/lang/Exception:printStackTrace	()V
    //   1315: goto -929 -> 386
    //   1318: astore_1
    //   1319: aload 31
    //   1321: monitorexit
    //   1322: iload 15
    //   1324: istore 10
    //   1326: iload 18
    //   1328: istore 7
    //   1330: aload 33
    //   1332: astore 32
    //   1334: iload 22
    //   1336: istore_3
    //   1337: iload 29
    //   1339: istore 25
    //   1341: aload_1
    //   1342: athrow
    //   1343: astore_1
    //   1344: iconst_0
    //   1345: istore_2
    //   1346: iconst_0
    //   1347: istore 23
    //   1349: aconst_null
    //   1350: astore_1
    //   1351: iload 14
    //   1353: istore_3
    //   1354: aload 33
    //   1356: astore 31
    //   1358: iload 5
    //   1360: istore 8
    //   1362: sipush 9204
    //   1365: istore 4
    //   1367: new 326	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   1370: dup
    //   1371: aload_0
    //   1372: sipush 9204
    //   1375: aload 36
    //   1377: aload 35
    //   1379: getfield 76	AvatarInfo/QQHeadInfo:idType	I
    //   1382: aload 35
    //   1384: getfield 57	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1387: iconst_4
    //   1388: iload 8
    //   1390: aload 31
    //   1392: iload_3
    //   1393: invokestatic 308	java/lang/System:currentTimeMillis	()J
    //   1396: invokespecial 329	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIILjava/lang/String;IJ)V
    //   1399: aconst_null
    //   1400: iconst_0
    //   1401: invokestatic 333	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1404: aload_0
    //   1405: getfield 46	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1408: sipush 199
    //   1411: invokevirtual 337	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1414: checkcast 339	apdc
    //   1417: astore 33
    //   1419: iload 4
    //   1421: istore_3
    //   1422: aload 31
    //   1424: astore 32
    //   1426: iload_2
    //   1427: istore 5
    //   1429: iload 23
    //   1431: istore 25
    //   1433: iload 24
    //   1435: istore 26
    //   1437: aload_1
    //   1438: astore 34
    //   1440: iload 23
    //   1442: ifne -325 -> 1117
    //   1445: iload 4
    //   1447: istore_3
    //   1448: aload 31
    //   1450: astore 32
    //   1452: iload_2
    //   1453: istore 5
    //   1455: iload 23
    //   1457: istore 25
    //   1459: iload 24
    //   1461: istore 26
    //   1463: aload_1
    //   1464: astore 34
    //   1466: aload 33
    //   1468: ifnull -351 -> 1117
    //   1471: iload 4
    //   1473: istore_3
    //   1474: aload 31
    //   1476: astore 32
    //   1478: iload_2
    //   1479: istore 5
    //   1481: iload 23
    //   1483: istore 25
    //   1485: iload 24
    //   1487: istore 26
    //   1489: aload_1
    //   1490: astore 34
    //   1492: aload 33
    //   1494: invokevirtual 340	apdc:a	()Z
    //   1497: ifeq -380 -> 1117
    //   1500: aload 33
    //   1502: aload 35
    //   1504: getfield 190	AvatarInfo/QQHeadInfo:uin	J
    //   1507: invokestatic 343	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1510: invokevirtual 345	apdc:a	(Ljava/lang/String;)V
    //   1513: iload 4
    //   1515: istore_3
    //   1516: aload 31
    //   1518: astore 32
    //   1520: iload_2
    //   1521: istore 5
    //   1523: iload 23
    //   1525: istore 25
    //   1527: iload 24
    //   1529: istore 26
    //   1531: aload_1
    //   1532: astore 34
    //   1534: goto -417 -> 1117
    //   1537: iconst_0
    //   1538: istore 23
    //   1540: goto -930 -> 610
    //   1543: astore_1
    //   1544: new 326	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   1547: dup
    //   1548: aload_0
    //   1549: sipush 9202
    //   1552: aload 36
    //   1554: aload 35
    //   1556: getfield 76	AvatarInfo/QQHeadInfo:idType	I
    //   1559: aload 35
    //   1561: getfield 57	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1564: iconst_4
    //   1565: iconst_0
    //   1566: aload 33
    //   1568: iconst_0
    //   1569: invokestatic 308	java/lang/System:currentTimeMillis	()J
    //   1572: invokespecial 329	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIILjava/lang/String;IJ)V
    //   1575: aconst_null
    //   1576: iconst_0
    //   1577: invokestatic 333	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1580: aload_0
    //   1581: getfield 46	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1584: sipush 199
    //   1587: invokevirtual 337	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1590: checkcast 339	apdc
    //   1593: astore_1
    //   1594: aload_1
    //   1595: ifnull -288 -> 1307
    //   1598: aload_1
    //   1599: invokevirtual 340	apdc:a	()Z
    //   1602: ifeq -295 -> 1307
    //   1605: aload_1
    //   1606: aload 35
    //   1608: getfield 190	AvatarInfo/QQHeadInfo:uin	J
    //   1611: invokestatic 343	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1614: invokevirtual 345	apdc:a	(Ljava/lang/String;)V
    //   1617: return
    //   1618: astore_1
    //   1619: sipush 9202
    //   1622: istore 5
    //   1624: iload 27
    //   1626: istore 24
    //   1628: goto -786 -> 842
    //   1631: aload_0
    //   1632: aload 33
    //   1634: aload 38
    //   1636: aload_1
    //   1637: iconst_0
    //   1638: invokevirtual 395	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/app/face/FaceInfo;Z)I
    //   1641: istore_2
    //   1642: iload_2
    //   1643: ifeq +927 -> 2570
    //   1646: iconst_1
    //   1647: invokestatic 401	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   1650: iconst_3
    //   1651: if_icmpne +919 -> 2570
    //   1654: aload_0
    //   1655: aload 35
    //   1657: getfield 209	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   1660: aload 35
    //   1662: getfield 286	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   1665: aload 35
    //   1667: getfield 57	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1670: aload 35
    //   1672: getfield 289	AvatarInfo/QQHeadInfo:originUsrType	I
    //   1675: iconst_1
    //   1676: invokevirtual 404	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(Ljava/lang/String;BBIZ)Ljava/lang/String;
    //   1679: astore 32
    //   1681: aload 32
    //   1683: astore 33
    //   1685: aload 33
    //   1687: astore 32
    //   1689: aload 33
    //   1691: astore 34
    //   1693: ldc_w 294
    //   1696: aload 33
    //   1698: invokestatic 300	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1701: astore 33
    //   1703: aload 33
    //   1705: astore 32
    //   1707: aload 33
    //   1709: astore 34
    //   1711: new 59	java/lang/StringBuilder
    //   1714: dup
    //   1715: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1718: aload 33
    //   1720: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1723: ldc_w 302
    //   1726: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: invokestatic 308	java/lang/System:currentTimeMillis	()J
    //   1732: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1735: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1738: astore 33
    //   1740: aload 33
    //   1742: astore 32
    //   1744: aload 33
    //   1746: astore 34
    //   1748: aload_0
    //   1749: aload 33
    //   1751: aload 38
    //   1753: aload_1
    //   1754: iconst_0
    //   1755: invokevirtual 395	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:a	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/app/face/FaceInfo;Z)I
    //   1758: istore_3
    //   1759: iload_3
    //   1760: istore_2
    //   1761: iload 16
    //   1763: istore 11
    //   1765: iload 17
    //   1767: istore 8
    //   1769: aload 33
    //   1771: astore 34
    //   1773: iload_2
    //   1774: istore 4
    //   1776: iload 28
    //   1778: istore 26
    //   1780: iload 15
    //   1782: istore 10
    //   1784: iload 18
    //   1786: istore 7
    //   1788: aload 33
    //   1790: astore 32
    //   1792: iload_2
    //   1793: istore_3
    //   1794: iload 29
    //   1796: istore 25
    //   1798: ldc 129
    //   1800: iconst_1
    //   1801: new 59	java/lang/StringBuilder
    //   1804: dup
    //   1805: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1808: ldc_w 406
    //   1811: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: aload 33
    //   1816: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1819: ldc_w 408
    //   1822: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1825: iload_2
    //   1826: invokevirtual 355	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1829: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1832: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1835: iload_2
    //   1836: ifne +191 -> 2027
    //   1839: iload 16
    //   1841: istore 11
    //   1843: iload 17
    //   1845: istore 8
    //   1847: aload 33
    //   1849: astore 34
    //   1851: iload_2
    //   1852: istore 4
    //   1854: iload 28
    //   1856: istore 26
    //   1858: iload 15
    //   1860: istore 10
    //   1862: iload 18
    //   1864: istore 7
    //   1866: aload 33
    //   1868: astore 32
    //   1870: iload_2
    //   1871: istore_3
    //   1872: iload 29
    //   1874: istore 25
    //   1876: aload 38
    //   1878: invokevirtual 411	java/io/File:length	()J
    //   1881: l2i
    //   1882: istore 6
    //   1884: iconst_1
    //   1885: istore 27
    //   1887: iconst_1
    //   1888: istore 28
    //   1890: iconst_1
    //   1891: istore 24
    //   1893: iload 16
    //   1895: istore 11
    //   1897: iload 6
    //   1899: istore 8
    //   1901: aload 33
    //   1903: astore 34
    //   1905: iload_2
    //   1906: istore 4
    //   1908: iload 27
    //   1910: istore 26
    //   1912: iload 15
    //   1914: istore 10
    //   1916: iload 6
    //   1918: istore 7
    //   1920: aload 33
    //   1922: astore 32
    //   1924: iload_2
    //   1925: istore_3
    //   1926: iload 28
    //   1928: istore 25
    //   1930: aload_0
    //   1931: getfield 46	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1934: aload 37
    //   1936: invokevirtual 414	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;)V
    //   1939: iload 16
    //   1941: istore 11
    //   1943: iload 6
    //   1945: istore 8
    //   1947: aload 33
    //   1949: astore 34
    //   1951: iload_2
    //   1952: istore 4
    //   1954: iload 27
    //   1956: istore 26
    //   1958: iload 15
    //   1960: istore 10
    //   1962: iload 6
    //   1964: istore 7
    //   1966: aload 33
    //   1968: astore 32
    //   1970: iload_2
    //   1971: istore_3
    //   1972: iload 28
    //   1974: istore 25
    //   1976: aload_0
    //   1977: getfield 44	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:b	Lmqq/os/MqqHandler;
    //   1980: new 416	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable
    //   1983: dup
    //   1984: aload_0
    //   1985: aload 37
    //   1987: aload_1
    //   1988: invokespecial 419	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   1991: invokevirtual 423	mqq/os/MqqHandler:postAtFrontOfQueue	(Ljava/lang/Runnable;)Z
    //   1994: pop
    //   1995: iload 12
    //   1997: istore 5
    //   1999: goto -1157 -> 842
    //   2002: astore_1
    //   2003: iload 11
    //   2005: istore_2
    //   2006: aload 31
    //   2008: astore_1
    //   2009: iload 23
    //   2011: istore 24
    //   2013: aload 34
    //   2015: astore 31
    //   2017: iload 4
    //   2019: istore_3
    //   2020: iload 26
    //   2022: istore 23
    //   2024: goto -662 -> 1362
    //   2027: iload 15
    //   2029: istore 10
    //   2031: iload 18
    //   2033: istore 7
    //   2035: aload 33
    //   2037: astore 32
    //   2039: iload_2
    //   2040: istore_3
    //   2041: iload 29
    //   2043: istore 25
    //   2045: aload_0
    //   2046: iload_2
    //   2047: invokespecial 425	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:b	(I)I
    //   2050: istore 4
    //   2052: iload 4
    //   2054: istore 5
    //   2056: iload_2
    //   2057: istore 9
    //   2059: iload 27
    //   2061: istore 24
    //   2063: goto -1221 -> 842
    //   2066: iload 16
    //   2068: istore 11
    //   2070: iload 17
    //   2072: istore 8
    //   2074: aload 33
    //   2076: astore 34
    //   2078: iload 21
    //   2080: istore 4
    //   2082: iload 28
    //   2084: istore 26
    //   2086: iload 15
    //   2088: istore 10
    //   2090: iload 18
    //   2092: istore 7
    //   2094: aload 33
    //   2096: astore 32
    //   2098: iload 22
    //   2100: istore_3
    //   2101: iload 29
    //   2103: istore 25
    //   2105: aload_0
    //   2106: getfield 46	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2109: aload 37
    //   2111: invokevirtual 414	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;)V
    //   2114: iload 16
    //   2116: istore 11
    //   2118: iload 17
    //   2120: istore 8
    //   2122: aload 33
    //   2124: astore 34
    //   2126: iload 21
    //   2128: istore 4
    //   2130: iload 28
    //   2132: istore 26
    //   2134: iload 15
    //   2136: istore 10
    //   2138: iload 18
    //   2140: istore 7
    //   2142: aload 33
    //   2144: astore 32
    //   2146: iload 22
    //   2148: istore_3
    //   2149: iload 29
    //   2151: istore 25
    //   2153: aload_0
    //   2154: getfield 44	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:b	Lmqq/os/MqqHandler;
    //   2157: new 416	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable
    //   2160: dup
    //   2161: aload_0
    //   2162: aload 37
    //   2164: aload_1
    //   2165: invokespecial 419	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   2168: invokevirtual 423	mqq/os/MqqHandler:postAtFrontOfQueue	(Ljava/lang/Runnable;)Z
    //   2171: pop
    //   2172: iconst_0
    //   2173: istore 5
    //   2175: iconst_0
    //   2176: istore 4
    //   2178: aload 33
    //   2180: astore_1
    //   2181: iconst_0
    //   2182: istore_2
    //   2183: iconst_0
    //   2184: istore 24
    //   2186: iload 19
    //   2188: istore_3
    //   2189: goto -1284 -> 905
    //   2192: astore_1
    //   2193: iload 10
    //   2195: istore_2
    //   2196: new 326	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   2199: dup
    //   2200: aload_0
    //   2201: iload_2
    //   2202: aload 36
    //   2204: aload 35
    //   2206: getfield 76	AvatarInfo/QQHeadInfo:idType	I
    //   2209: aload 35
    //   2211: getfield 57	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2214: iconst_4
    //   2215: iload 7
    //   2217: aload 32
    //   2219: iload_3
    //   2220: invokestatic 308	java/lang/System:currentTimeMillis	()J
    //   2223: invokespecial 329	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIILjava/lang/String;IJ)V
    //   2226: aconst_null
    //   2227: iconst_0
    //   2228: invokestatic 333	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2231: aload_0
    //   2232: getfield 46	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2235: sipush 199
    //   2238: invokevirtual 337	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2241: checkcast 339	apdc
    //   2244: astore 31
    //   2246: iload 25
    //   2248: ifne +29 -> 2277
    //   2251: aload 31
    //   2253: ifnull +24 -> 2277
    //   2256: aload 31
    //   2258: invokevirtual 340	apdc:a	()Z
    //   2261: ifeq +16 -> 2277
    //   2264: aload 31
    //   2266: aload 35
    //   2268: getfield 190	AvatarInfo/QQHeadInfo:uin	J
    //   2271: invokestatic 343	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2274: invokevirtual 345	apdc:a	(Ljava/lang/String;)V
    //   2277: aload_1
    //   2278: athrow
    //   2279: astore_1
    //   2280: iconst_0
    //   2281: istore_2
    //   2282: aload 33
    //   2284: astore 32
    //   2286: iload 13
    //   2288: istore 7
    //   2290: iload 20
    //   2292: istore_3
    //   2293: iload 30
    //   2295: istore 25
    //   2297: goto -101 -> 2196
    //   2300: astore_1
    //   2301: iload_2
    //   2302: istore_3
    //   2303: iconst_0
    //   2304: istore_2
    //   2305: aload 33
    //   2307: astore 32
    //   2309: iload 13
    //   2311: istore 7
    //   2313: iload 30
    //   2315: istore 25
    //   2317: goto -121 -> 2196
    //   2320: astore_1
    //   2321: iload_2
    //   2322: istore_3
    //   2323: iconst_0
    //   2324: istore_2
    //   2325: iload 13
    //   2327: istore 7
    //   2329: iload 30
    //   2331: istore 25
    //   2333: goto -137 -> 2196
    //   2336: astore 31
    //   2338: iload 4
    //   2340: istore 7
    //   2342: aload_1
    //   2343: astore 32
    //   2345: aload 31
    //   2347: astore_1
    //   2348: iload 24
    //   2350: istore 25
    //   2352: goto -156 -> 2196
    //   2355: astore_1
    //   2356: iconst_0
    //   2357: istore_2
    //   2358: iconst_0
    //   2359: istore 23
    //   2361: aconst_null
    //   2362: astore_1
    //   2363: iconst_0
    //   2364: istore 24
    //   2366: iload 5
    //   2368: istore 8
    //   2370: aload 33
    //   2372: astore 31
    //   2374: iload 14
    //   2376: istore_3
    //   2377: goto -1015 -> 1362
    //   2380: astore_1
    //   2381: iconst_0
    //   2382: istore_2
    //   2383: iconst_0
    //   2384: istore 23
    //   2386: aload 31
    //   2388: astore_1
    //   2389: iload 5
    //   2391: istore 8
    //   2393: aload 33
    //   2395: astore 31
    //   2397: iload 14
    //   2399: istore_3
    //   2400: goto -1038 -> 1362
    //   2403: astore_1
    //   2404: iconst_0
    //   2405: istore_2
    //   2406: iconst_0
    //   2407: istore 25
    //   2409: iload 23
    //   2411: istore 24
    //   2413: aload 31
    //   2415: astore_1
    //   2416: iload 5
    //   2418: istore 8
    //   2420: aload 33
    //   2422: astore 31
    //   2424: iload 14
    //   2426: istore_3
    //   2427: iload 25
    //   2429: istore 23
    //   2431: goto -1069 -> 1362
    //   2434: astore_1
    //   2435: iconst_0
    //   2436: istore 4
    //   2438: iconst_0
    //   2439: istore 25
    //   2441: iload 23
    //   2443: istore 24
    //   2445: aload 31
    //   2447: astore_1
    //   2448: iload 5
    //   2450: istore 8
    //   2452: aload 33
    //   2454: astore 31
    //   2456: iload_2
    //   2457: istore_3
    //   2458: iload 4
    //   2460: istore_2
    //   2461: iload 25
    //   2463: istore 23
    //   2465: goto -1103 -> 1362
    //   2468: astore_1
    //   2469: iconst_0
    //   2470: istore 4
    //   2472: iconst_0
    //   2473: istore 25
    //   2475: aload 31
    //   2477: astore_1
    //   2478: iload 23
    //   2480: istore 24
    //   2482: iload 5
    //   2484: istore 8
    //   2486: aload 34
    //   2488: astore 31
    //   2490: iload_2
    //   2491: istore_3
    //   2492: iload 4
    //   2494: istore_2
    //   2495: iload 25
    //   2497: istore 23
    //   2499: goto -1137 -> 1362
    //   2502: astore_1
    //   2503: iload_2
    //   2504: istore 4
    //   2506: iconst_0
    //   2507: istore 25
    //   2509: aload 31
    //   2511: astore_1
    //   2512: iload 23
    //   2514: istore 24
    //   2516: iload 5
    //   2518: istore 8
    //   2520: aload 33
    //   2522: astore 31
    //   2524: iload_2
    //   2525: istore_3
    //   2526: iload 4
    //   2528: istore_2
    //   2529: iload 25
    //   2531: istore 23
    //   2533: goto -1171 -> 1362
    //   2536: astore 32
    //   2538: iload 5
    //   2540: istore_2
    //   2541: iload 23
    //   2543: istore 25
    //   2545: aload 31
    //   2547: astore 32
    //   2549: iload 4
    //   2551: istore 8
    //   2553: aload_1
    //   2554: astore 31
    //   2556: iload 24
    //   2558: istore 23
    //   2560: iload 25
    //   2562: istore 24
    //   2564: aload 32
    //   2566: astore_1
    //   2567: goto -1205 -> 1362
    //   2570: goto -735 -> 1835
    //   2573: iconst_0
    //   2574: istore 6
    //   2576: iconst_0
    //   2577: istore 23
    //   2579: aconst_null
    //   2580: astore_1
    //   2581: iconst_0
    //   2582: istore 24
    //   2584: iconst_0
    //   2585: istore_2
    //   2586: iload 8
    //   2588: istore_3
    //   2589: iload 4
    //   2591: istore 5
    //   2593: iload 6
    //   2595: istore 4
    //   2597: goto -1645 -> 952
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2600	0	this	QQHeadDownloadHandler
    //   0	2600	1	paramFaceInfo	FaceInfo
    //   116	2470	2	i	int
    //   131	2458	3	j	int
    //   101	2495	4	k	int
    //   64	2528	5	m	int
    //   76	2518	6	n	int
    //   123	2218	7	i1	int
    //   61	2526	8	i2	int
    //   95	1963	9	i3	int
    //   119	2075	10	i4	int
    //   617	1500	11	i5	int
    //   89	1907	12	i6	int
    //   73	2253	13	i7	int
    //   104	2321	14	i8	int
    //   86	2049	15	i9	int
    //   92	2023	16	i10	int
    //   67	2052	17	i11	int
    //   70	2069	18	i12	int
    //   98	2089	19	i13	int
    //   113	2178	20	i14	int
    //   107	2020	21	i15	int
    //   110	2037	22	i16	int
    //   369	2209	23	bool1	boolean
    //   214	2369	24	bool2	boolean
    //   134	2427	25	bool3	boolean
    //   633	1500	26	bool4	boolean
    //   58	2002	27	bool5	boolean
    //   49	2082	28	bool6	boolean
    //   52	2098	29	bool7	boolean
    //   55	2275	30	bool8	boolean
    //   183	2082	31	localObject1	Object
    //   2336	10	31	localObject2	Object
    //   2372	183	31	localObject3	Object
    //   127	1145	32	localObject4	Object
    //   1308	3	32	localException	java.lang.Exception
    //   1332	1012	32	localObject5	Object
    //   2536	1	32	localThrowable	java.lang.Throwable
    //   2547	18	32	localObject6	Object
    //   83	2438	33	localObject7	Object
    //   478	2009	34	localObject8	Object
    //   4	2263	35	localQQHeadInfo	QQHeadInfo
    //   23	2180	36	str	String
    //   242	1921	37	localSetting	Setting
    //   565	1312	38	localFile	File
    // Exception table:
    //   from	to	target	type
    //   376	386	1308	java/lang/Exception
    //   350	371	1318	finally
    //   376	386	1318	finally
    //   386	403	1318	finally
    //   1310	1315	1318	finally
    //   1319	1322	1318	finally
    //   235	244	1343	java/lang/Throwable
    //   263	279	1343	java/lang/Throwable
    //   298	304	1343	java/lang/Throwable
    //   323	328	1343	java/lang/Throwable
    //   347	350	1343	java/lang/Throwable
    //   422	438	1343	java/lang/Throwable
    //   1341	1343	1343	java/lang/Throwable
    //   422	438	1543	java/lang/Exception
    //   457	480	1543	java/lang/Exception
    //   504	512	1543	java/lang/Exception
    //   531	537	1543	java/lang/Exception
    //   556	567	1543	java/lang/Exception
    //   595	602	1543	java/lang/Exception
    //   816	835	1618	java/lang/Exception
    //   654	680	2002	java/lang/Throwable
    //   719	729	2002	java/lang/Throwable
    //   768	797	2002	java/lang/Throwable
    //   879	889	2002	java/lang/Throwable
    //   1798	1835	2002	java/lang/Throwable
    //   1876	1884	2002	java/lang/Throwable
    //   1930	1939	2002	java/lang/Throwable
    //   1976	1995	2002	java/lang/Throwable
    //   2105	2114	2002	java/lang/Throwable
    //   2153	2172	2002	java/lang/Throwable
    //   136	147	2192	finally
    //   166	185	2192	finally
    //   204	216	2192	finally
    //   235	244	2192	finally
    //   263	279	2192	finally
    //   298	304	2192	finally
    //   323	328	2192	finally
    //   347	350	2192	finally
    //   422	438	2192	finally
    //   457	480	2192	finally
    //   504	512	2192	finally
    //   531	537	2192	finally
    //   556	567	2192	finally
    //   595	602	2192	finally
    //   654	680	2192	finally
    //   719	729	2192	finally
    //   768	797	2192	finally
    //   879	889	2192	finally
    //   1341	1343	2192	finally
    //   1798	1835	2192	finally
    //   1876	1884	2192	finally
    //   1930	1939	2192	finally
    //   1976	1995	2192	finally
    //   2045	2052	2192	finally
    //   2105	2114	2192	finally
    //   2153	2172	2192	finally
    //   797	811	2279	finally
    //   816	835	2279	finally
    //   1631	1642	2279	finally
    //   1646	1681	2300	finally
    //   1693	1703	2320	finally
    //   1711	1740	2320	finally
    //   1748	1759	2320	finally
    //   905	920	2336	finally
    //   136	147	2355	java/lang/Throwable
    //   166	185	2355	java/lang/Throwable
    //   204	216	2355	java/lang/Throwable
    //   457	480	2380	java/lang/Throwable
    //   504	512	2380	java/lang/Throwable
    //   531	537	2380	java/lang/Throwable
    //   556	567	2380	java/lang/Throwable
    //   595	602	2380	java/lang/Throwable
    //   797	811	2403	java/lang/Throwable
    //   816	835	2403	java/lang/Throwable
    //   1631	1642	2403	java/lang/Throwable
    //   1646	1681	2434	java/lang/Throwable
    //   1693	1703	2468	java/lang/Throwable
    //   1711	1740	2468	java/lang/Throwable
    //   1748	1759	2468	java/lang/Throwable
    //   2045	2052	2502	java/lang/Throwable
    //   905	920	2536	java/lang/Throwable
  }
  
  public Object[] a(QQHeadInfo paramQQHeadInfo, String paramString1, String paramString2, boolean paramBoolean)
  {
    Setting localSetting2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(paramString2);
    Setting localSetting1 = localSetting2;
    if (localSetting2 == null)
    {
      localSetting1 = new Setting();
      localSetting1.uin = paramString2;
      paramBoolean = true;
    }
    localSetting1.bFaceFlags = paramQQHeadInfo.dwFaceFlgas;
    localSetting1.bUsrType = paramQQHeadInfo.dstUsrType;
    localSetting1.url = paramQQHeadInfo.downLoadUrl;
    localSetting1.updateTimestamp = System.currentTimeMillis();
    byte b1;
    if (paramQQHeadInfo.cHeadType == 0)
    {
      b1 = 0;
      localSetting1.bSourceType = b1;
      if (paramBoolean) {
        break label318;
      }
      if (localSetting1.bHeadType == paramQQHeadInfo.cHeadType) {
        break label262;
      }
      paramBoolean = true;
      label109:
      bool = paramBoolean;
      if (paramQQHeadInfo.dstUsrType != 32)
      {
        bool = paramBoolean;
        if (paramBoolean)
        {
          bool = paramBoolean;
          if (localSetting1.bHeadType == 1)
          {
            bool = paramBoolean;
            if (paramQQHeadInfo.cHeadType == 0)
            {
              paramString1 = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localSetting1.bUsrType, paramString1, paramQQHeadInfo.idType));
              bool = paramBoolean;
              if (paramString1 != null)
              {
                bool = paramBoolean;
                if (paramString1.exists()) {
                  paramString1.delete();
                }
              }
            }
          }
        }
      }
    }
    label262:
    label318:
    for (boolean bool = paramBoolean;; bool = paramBoolean)
    {
      localSetting1.bHeadType = paramQQHeadInfo.cHeadType;
      localSetting1.systemHeadID = paramQQHeadInfo.systemHeadID;
      localSetting1.headImgTimestamp = paramQQHeadInfo.dwTimestamp;
      return new Object[] { Boolean.valueOf(bool), localSetting1 };
      b1 = paramQQHeadInfo.headLevel;
      break;
      if (paramQQHeadInfo.cHeadType == 0)
      {
        if (localSetting1.systemHeadID != paramQQHeadInfo.systemHeadID)
        {
          paramBoolean = true;
          break label109;
        }
        paramBoolean = false;
        break label109;
      }
      if (localSetting1.headImgTimestamp != paramQQHeadInfo.dwTimestamp)
      {
        paramBoolean = true;
        break label109;
      }
      paramBoolean = false;
      break label109;
    }
  }
  
  public String b()
  {
    return arai.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.QQHeadDownloadHandler
 * JD-Core Version:    0.7.0.1
 */