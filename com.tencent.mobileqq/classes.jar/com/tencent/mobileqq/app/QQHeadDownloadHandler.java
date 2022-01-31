package com.tencent.mobileqq.app;

import AvatarInfo.QQHeadInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.config.PicIPManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ContactConfig;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import mqq.os.MqqHandler;
import zsr;
import zss;

public class QQHeadDownloadHandler
  extends FaceDownloader
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130839298, 2130846364, 2130846365, 2130846366 };
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler b = new MqqHandler(ThreadManager.getSubThreadLooper());
  
  public QQHeadDownloadHandler(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = paramFriendListHandler;
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
    //   13: getstatic 19	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ArrayOfInt	[I
    //   16: arraylength
    //   17: if_icmplt +5 -> 22
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: getfield 46	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: invokevirtual 59	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   29: invokevirtual 65	mqq/app/MobileQQ:getResources	()Landroid/content/res/Resources;
    //   32: getstatic 19	com/tencent/mobileqq/app/QQHeadDownloadHandler:jdField_a_of_type_ArrayOfInt	[I
    //   35: iload_3
    //   36: iaload
    //   37: invokevirtual 71	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   40: astore 6
    //   42: aload 6
    //   44: astore 4
    //   46: sipush 512
    //   49: newarray byte
    //   51: astore 6
    //   53: new 73	java/io/FileOutputStream
    //   56: dup
    //   57: aload_2
    //   58: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: astore_2
    //   62: aload 4
    //   64: aload 6
    //   66: invokevirtual 82	java/io/InputStream:read	([B)I
    //   69: istore_1
    //   70: iload_1
    //   71: ifle +51 -> 122
    //   74: aload_2
    //   75: aload 6
    //   77: iconst_0
    //   78: iload_1
    //   79: invokevirtual 86	java/io/FileOutputStream:write	([BII)V
    //   82: goto -20 -> 62
    //   85: astore 5
    //   87: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +13 -> 103
    //   93: ldc 94
    //   95: iconst_2
    //   96: ldc 96
    //   98: aload 5
    //   100: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   111: aload 4
    //   113: ifnull +8 -> 121
    //   116: aload 4
    //   118: invokevirtual 104	java/io/InputStream:close	()V
    //   121: return
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   130: aload 4
    //   132: ifnull -11 -> 121
    //   135: aload 4
    //   137: invokevirtual 104	java/io/InputStream:close	()V
    //   140: return
    //   141: astore_2
    //   142: aconst_null
    //   143: astore 4
    //   145: aload 5
    //   147: ifnull +8 -> 155
    //   150: aload 5
    //   152: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   155: aload 4
    //   157: ifnull +8 -> 165
    //   160: aload 4
    //   162: invokevirtual 104	java/io/InputStream:close	()V
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
    //   85	66	5	localException1	Exception
    //   174	12	5	localFile	File
    //   193	1	5	localException2	Exception
    //   200	1	5	localException3	Exception
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
  
  public static void b() {}
  
  public String a()
  {
    return PicIPManager.a(0);
  }
  
  public String b()
  {
    return PicIPManager.a(1);
  }
  
  protected void b(FaceInfo paramFaceInfo)
  {
    QQHeadInfo localQQHeadInfo = paramFaceInfo.a;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(localQQHeadInfo.uin, localQQHeadInfo.phoneNum);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(0, str, localQQHeadInfo.dstUsrType, 3);
    paramFaceInfo.a(FaceInfo.n);
    bool2 = false;
    bool1 = false;
    int i19 = 0;
    boolean bool8 = false;
    boolean bool7 = false;
    bool6 = false;
    i8 = 0;
    int i1 = 0;
    int i12 = 0;
    int k = 0;
    int i13 = 0;
    int i3 = 0;
    Object localObject4 = localQQHeadInfo.downLoadUrl;
    int i17 = 0;
    int i10 = 0;
    int i7 = 0;
    i = 0;
    j = 0;
    int i11 = 0;
    i2 = 0;
    int m = 0;
    int i16 = 0;
    int i14 = 0;
    int n = 0;
    int i15 = 0;
    i4 = 0;
    bool3 = bool2;
    int i9 = i10;
    int i18 = i19;
    int i5 = i12;
    Object localObject5 = localObject4;
    int i6 = i14;
    try
    {
      if (TextUtils.isEmpty(localQQHeadInfo.downLoadUrl)) {
        break label4722;
      }
      bool3 = bool2;
      i9 = i10;
      i18 = i19;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      if (localQQHeadInfo.dstUsrType != 4) {
        break label2582;
      }
      bool3 = bool2;
      i9 = i10;
      i18 = i19;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localObject1 = "troop_" + str;
    }
    catch (Throwable paramFaceInfo) {}finally
    {
      ThreadManager.postImmediately(new zsr(this, i9, str, localQQHeadInfo.idType, localQQHeadInfo.dstUsrType, 4, i5, (String)localObject5, i6, System.currentTimeMillis()), null, false);
      if (i18 != 0) {
        break label3298;
      }
      localObject1 = (ClassicHeadActivityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(198);
      if ((localObject1 == null) || (!((ClassicHeadActivityManager)localObject1).a())) {
        break label3298;
      }
      ((ClassicHeadActivityManager)localObject1).a(String.valueOf(localQQHeadInfo.uin));
    }
    bool3 = bool2;
    i9 = i10;
    i18 = i19;
    i5 = i12;
    localObject5 = localObject4;
    i6 = i14;
    Setting localSetting = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c((String)localObject1);
    if (localSetting == null)
    {
      bool3 = bool2;
      i9 = i10;
      i18 = i19;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting = new Setting();
      bool3 = bool2;
      i9 = i10;
      i18 = i19;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.uin = ((String)localObject1);
      bool1 = true;
      label349:
      bool3 = bool1;
      i9 = i10;
      i18 = i19;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.bFaceFlags = localQQHeadInfo.dwFaceFlgas;
      bool3 = bool1;
      i9 = i10;
      i18 = i19;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.bUsrType = localQQHeadInfo.dstUsrType;
      bool3 = bool1;
      i9 = i10;
      i18 = i19;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.url = localQQHeadInfo.downLoadUrl;
      bool3 = bool1;
      i9 = i10;
      i18 = i19;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.updateTimestamp = System.currentTimeMillis();
      bool3 = bool1;
      i9 = i10;
      i18 = i19;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      if (localQQHeadInfo.cHeadType == 0)
      {
        bool3 = bool1;
        i9 = i10;
        i18 = i19;
        i5 = i12;
        localObject5 = localObject4;
        i6 = i14;
        localSetting.bSourceType = 0;
        bool2 = bool1;
        if (!bool1)
        {
          bool3 = bool1;
          i9 = i10;
          i18 = i19;
          i5 = i12;
          localObject5 = localObject4;
          i6 = i14;
          if (localSetting.bHeadType == localQQHeadInfo.cHeadType) {
            break label3017;
          }
        }
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      bool3 = bool1;
      i9 = i10;
      i18 = i19;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      if (localQQHeadInfo.dstUsrType != 32)
      {
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          bool3 = bool1;
          i9 = i10;
          i18 = i19;
          i5 = i12;
          localObject5 = localObject4;
          i6 = i14;
          if (localSetting.bHeadType == 1)
          {
            bool2 = bool1;
            bool3 = bool1;
            i9 = i10;
            i18 = i19;
            i5 = i12;
            localObject5 = localObject4;
            i6 = i14;
            if (localQQHeadInfo.cHeadType == 0)
            {
              bool3 = bool1;
              i9 = i10;
              i18 = i19;
              i5 = i12;
              localObject5 = localObject4;
              i6 = i14;
              localObject1 = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localSetting.bUsrType, str, localQQHeadInfo.idType));
              bool2 = bool1;
              if (localObject1 != null)
              {
                bool2 = bool1;
                bool3 = bool1;
                i9 = i10;
                i18 = i19;
                i5 = i12;
                localObject5 = localObject4;
                i6 = i14;
                if (((File)localObject1).exists())
                {
                  bool3 = bool1;
                  i9 = i10;
                  i18 = i19;
                  i5 = i12;
                  localObject5 = localObject4;
                  i6 = i14;
                  ((File)localObject1).delete();
                  bool2 = bool1;
                }
              }
            }
          }
        }
      }
      bool3 = bool2;
      i9 = i10;
      i18 = i19;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.bHeadType = localQQHeadInfo.cHeadType;
      bool3 = bool2;
      i9 = i10;
      i18 = i19;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.systemHeadID = localQQHeadInfo.systemHeadID;
      bool3 = bool2;
      i9 = i10;
      i18 = i19;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      localSetting.headImgTimestamp = localQQHeadInfo.dwTimestamp;
      bool3 = bool2;
      i9 = i10;
      i18 = i19;
      i5 = i12;
      localObject5 = localObject4;
      i6 = i14;
      if (ContactConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext()))
      {
        bool3 = bool2;
        i9 = i10;
        i18 = i19;
        i5 = i12;
        localObject5 = localObject4;
        i6 = i14;
        if (SystemUtil.a())
        {
          bool3 = bool2;
          i9 = i10;
          i18 = i19;
          i5 = i12;
          localObject5 = localObject4;
          i6 = i14;
          localObject1 = jdField_a_of_type_JavaLangObject;
          bool3 = bool2;
          i9 = i10;
          i18 = i19;
          i5 = i12;
          localObject5 = localObject4;
          i6 = i14;
        }
      }
      label4747:
      for (;;)
      {
        Object localObject2;
        Object localObject6;
        File localFile;
        label2072:
        label2208:
        label3017:
        long l1;
        label2582:
        long l2;
        label3298:
        bool1 = false;
        continue;
        i9 = i10;
        i18 = i19;
        i5 = i12;
        localObject5 = localObject4;
        i6 = i14;
        bool5 = bool1;
        i8 = i11;
        bool4 = bool7;
        i1 = i13;
        Object localObject3 = localObject4;
        m = i15;
        j = a((String)localObject4, localFile, paramFaceInfo, false);
        if (j != 0) {
          break label4784;
        }
        i9 = i10;
        i18 = i19;
        i5 = i12;
        localObject5 = localObject4;
        i6 = j;
        bool5 = bool1;
        i8 = i11;
        bool4 = bool7;
        i1 = i13;
        localObject3 = localObject4;
        m = j;
        i3 = (int)localFile.length();
        bool2 = true;
        bool6 = true;
        bool3 = true;
        i9 = i10;
        i18 = bool2;
        i5 = i3;
        localObject5 = localObject4;
        i6 = j;
        bool5 = bool1;
        i8 = i11;
        bool4 = bool6;
        i1 = i3;
        localObject3 = localObject4;
        m = j;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localSetting);
        i9 = i10;
        i18 = bool2;
        i5 = i3;
        localObject5 = localObject4;
        i6 = j;
        bool5 = bool1;
        i8 = i11;
        bool4 = bool6;
        i1 = i3;
        localObject3 = localObject4;
        m = j;
        this.b.postAtFrontOfQueue(new zss(this, localSetting, paramFaceInfo));
        i4 = j;
        continue;
        i9 = i;
        i18 = bool3;
        i5 = i3;
        localObject5 = localObject4;
        i6 = i4;
        bool5 = bool1;
        i8 = i2;
        bool4 = bool3;
        i1 = i3;
        localObject3 = localObject4;
        m = i4;
        if (localQQHeadInfo.dstUsrType == 32)
        {
          i9 = i;
          i18 = bool3;
          i5 = i3;
          localObject5 = localObject4;
          i6 = i4;
          bool5 = bool1;
          i8 = i2;
          bool4 = bool3;
          i1 = i3;
          localObject3 = localObject4;
          m = i4;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(32, str, localQQHeadInfo.idType);
          j = i2;
          i7 = i;
          bool2 = bool3;
          k = i3;
          localObject6 = localObject4;
          n = i4;
        }
        else
        {
          i9 = i;
          i18 = bool3;
          i5 = i3;
          localObject5 = localObject4;
          i6 = i4;
          bool5 = bool1;
          i8 = i2;
          bool4 = bool3;
          i1 = i3;
          localObject3 = localObject4;
          m = i4;
          if (localQQHeadInfo.dstUsrType == 16)
          {
            i9 = i;
            i18 = bool3;
            i5 = i3;
            localObject5 = localObject4;
            i6 = i4;
            bool5 = bool1;
            i8 = i2;
            bool4 = bool3;
            i1 = i3;
            localObject3 = localObject4;
            m = i4;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(16, str, localQQHeadInfo.idType);
            j = i2;
            i7 = i;
            bool2 = bool3;
            k = i3;
            localObject6 = localObject4;
            n = i4;
          }
          else
          {
            i9 = i;
            i18 = bool3;
            i5 = i3;
            localObject5 = localObject4;
            i6 = i4;
            bool5 = bool1;
            i8 = i2;
            bool4 = bool3;
            i1 = i3;
            localObject3 = localObject4;
            m = i4;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, str, localQQHeadInfo.idType);
            j = i2;
            i7 = i;
            bool2 = bool3;
            k = i3;
            localObject6 = localObject4;
            n = i4;
            break label4747;
            i9 = i7;
            i18 = bool2;
            i5 = k;
            localObject5 = localObject6;
            i6 = n;
            bool5 = bool1;
            i8 = j;
            bool4 = bool2;
            i1 = k;
            localObject3 = localObject6;
            m = n;
            if (localQQHeadInfo.dstUsrType == 4)
            {
              i9 = i7;
              i18 = bool2;
              i5 = k;
              localObject5 = localObject6;
              i6 = n;
              bool5 = bool1;
              i8 = j;
              bool4 = bool2;
              i1 = k;
              localObject3 = localObject6;
              m = n;
              this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(30, true, new Object[] { str });
              i9 = i7;
              i18 = bool2;
              i5 = k;
              localObject5 = localObject6;
              i6 = n;
              bool5 = bool1;
              i8 = j;
              bool4 = bool2;
              i1 = k;
              localObject3 = localObject6;
              m = n;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4, str, 0, (String)localObject1);
              i = j;
              bool3 = bool1;
              paramFaceInfo = (FaceInfo)localObject1;
              localObject4 = localObject6;
              bool1 = bool2;
              bool2 = bool3;
              continue;
            }
            i9 = i7;
            i18 = bool2;
            i5 = k;
            localObject5 = localObject6;
            i6 = n;
            bool5 = bool1;
            i8 = j;
            bool4 = bool2;
            i1 = k;
            localObject3 = localObject6;
            m = n;
            if (localQQHeadInfo.dstUsrType == 32)
            {
              i9 = i7;
              i18 = bool2;
              i5 = k;
              localObject5 = localObject6;
              i6 = n;
              bool5 = bool1;
              i8 = j;
              bool4 = bool2;
              i1 = k;
              localObject3 = localObject6;
              m = n;
              this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(5, true, new Object[] { str, Integer.valueOf(localQQHeadInfo.idType), Boolean.valueOf(true) });
              i9 = i7;
              i18 = bool2;
              i5 = k;
              localObject5 = localObject6;
              i6 = n;
              bool5 = bool1;
              i8 = j;
              bool4 = bool2;
              i1 = k;
              localObject3 = localObject6;
              m = n;
              this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(104, true, new Object[] { str, Integer.valueOf(localQQHeadInfo.idType), localObject6 });
              i = j;
              bool3 = bool1;
              paramFaceInfo = (FaceInfo)localObject1;
              localObject4 = localObject6;
              bool1 = bool2;
              bool2 = bool3;
              continue;
            }
            i9 = i7;
            i18 = bool2;
            i5 = k;
            localObject5 = localObject6;
            i6 = n;
            bool5 = bool1;
            i8 = j;
            bool4 = bool2;
            i1 = k;
            localObject3 = localObject6;
            m = n;
            if (localQQHeadInfo.dstUsrType == 16)
            {
              i9 = i7;
              i18 = bool2;
              i5 = k;
              localObject5 = localObject6;
              i6 = n;
              bool5 = bool1;
              i8 = j;
              bool4 = bool2;
              i1 = k;
              localObject3 = localObject6;
              m = n;
              this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(6, true, new Object[] { str, Integer.valueOf(localQQHeadInfo.idType), Boolean.valueOf(true) });
              i = j;
              bool3 = bool1;
              paramFaceInfo = (FaceInfo)localObject1;
              localObject4 = localObject6;
              bool1 = bool2;
              bool2 = bool3;
              continue;
            }
            i9 = i7;
            i18 = bool2;
            i5 = k;
            localObject5 = localObject6;
            i6 = n;
            bool5 = bool1;
            i8 = j;
            bool4 = bool2;
            i1 = k;
            localObject3 = localObject6;
            m = n;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, str, 0, (String)localObject1);
            i9 = i7;
            i18 = bool2;
            i5 = k;
            localObject5 = localObject6;
            i6 = n;
            bool5 = bool1;
            i8 = j;
            bool4 = bool2;
            i1 = k;
            localObject3 = localObject6;
            m = n;
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(4, true, new Object[] { str });
          }
        }
        label4722:
        do
        {
          i = j;
          bool3 = bool1;
          paramFaceInfo = (FaceInfo)localObject1;
          localObject4 = localObject6;
          bool1 = bool2;
          bool2 = bool3;
          break label2208;
          break label349;
          localObject1 = str;
          break;
          i = 0;
          bool1 = false;
          bool2 = false;
          paramFaceInfo = null;
          i7 = i17;
          k = i8;
          n = m;
          break label2208;
          if (bool2) {
            break label2072;
          }
        } while (bool1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQHeadDownloadHandler
 * JD-Core Version:    0.7.0.1
 */