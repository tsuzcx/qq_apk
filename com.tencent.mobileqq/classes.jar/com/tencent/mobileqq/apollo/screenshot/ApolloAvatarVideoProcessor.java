package com.tencent.mobileqq.apollo.screenshot;

import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloAvatarFileManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

@RequiresApi(api=21)
public class ApolloAvatarVideoProcessor
{
  private int jdField_a_of_type_Int;
  private ApolloAvatarVideoProcessor.OnProcessFinishListener jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloAvatarVideoProcessor$OnProcessFinishListener;
  private ApolloAvatarVideoProcessor.VideoUploadProcessorHandler jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloAvatarVideoProcessor$VideoUploadProcessorHandler;
  ApolloVideoEncoder.OnEncodeFinishListener jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloVideoEncoder$OnEncodeFinishListener = new ApolloAvatarVideoProcessor.4(this);
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<String> jdField_a_of_type_JavaUtilList;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private final int[] jdField_a_of_type_ArrayOfInt = { 640, 200, 100 };
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private final int[] jdField_b_of_type_ArrayOfInt = { 640, 200, 176 };
  private String c;
  private String d;
  private String e;
  
  public ApolloAvatarVideoProcessor(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    ThreadManager.getSubThreadHandler().post(new ApolloAvatarVideoProcessor.1(this, paramAppInterface));
  }
  
  private int a(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return this.jdField_b_of_type_ArrayOfInt[paramInt];
    }
    return this.jdField_a_of_type_ArrayOfInt[paramInt];
  }
  
  private String a(int paramInt)
  {
    Object localObject = ApolloAvatarFileManager.a().b(paramInt);
    if (localObject == null)
    {
      QLog.e("ApolloAvatarVideoProcessor", 1, "getVideoFilePath is null");
      return null;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return ((File)localObject).getAbsolutePath();
  }
  
  /* Error */
  private String a(List<String> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: aconst_null
    //   8: astore 6
    //   10: aconst_null
    //   11: astore 5
    //   13: aload_1
    //   14: ifnull +12 -> 26
    //   17: aload_1
    //   18: invokeinterface 136 1 0
    //   23: ifeq +7 -> 30
    //   26: aconst_null
    //   27: astore_2
    //   28: aload_2
    //   29: areturn
    //   30: ldc 95
    //   32: iconst_2
    //   33: ldc 138
    //   35: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: new 104	java/io/File
    //   41: dup
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 75	com/tencent/mobileqq/apollo/screenshot/ApolloAvatarVideoProcessor:jdField_b_of_type_Int	I
    //   47: invokespecial 124	com/tencent/mobileqq/apollo/screenshot/ApolloAvatarVideoProcessor:a	(I)Ljava/lang/String;
    //   50: ldc 142
    //   52: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: astore 8
    //   57: new 147	android/graphics/BitmapFactory$Options
    //   60: dup
    //   61: invokespecial 148	android/graphics/BitmapFactory$Options:<init>	()V
    //   64: astore 7
    //   66: aload 7
    //   68: getstatic 154	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   71: putfield 157	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   74: aload_1
    //   75: iconst_0
    //   76: invokeinterface 161 2 0
    //   81: checkcast 163	java/lang/String
    //   84: aload 7
    //   86: invokestatic 169	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   89: astore 7
    //   91: aload 7
    //   93: astore_3
    //   94: aload_3
    //   95: ifnull +174 -> 269
    //   98: aload 4
    //   100: astore_2
    //   101: aload_3
    //   102: astore 4
    //   104: aload_3
    //   105: sipush 480
    //   108: sipush 480
    //   111: iconst_1
    //   112: invokestatic 175	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   115: astore 5
    //   117: aload 5
    //   119: ifnull +136 -> 255
    //   122: aload 5
    //   124: astore_2
    //   125: aload_3
    //   126: astore 4
    //   128: aload 5
    //   130: astore 6
    //   132: aload 5
    //   134: bipush 100
    //   136: aload 8
    //   138: invokestatic 180	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   141: pop
    //   142: aload 5
    //   144: astore_2
    //   145: aload_3
    //   146: astore 4
    //   148: aload 5
    //   150: astore 6
    //   152: aload 8
    //   154: invokevirtual 111	java/io/File:exists	()Z
    //   157: ifeq +83 -> 240
    //   160: aload 5
    //   162: astore_2
    //   163: aload_3
    //   164: astore 4
    //   166: aload 5
    //   168: astore 6
    //   170: aload 8
    //   172: invokevirtual 184	java/io/File:length	()J
    //   175: lconst_0
    //   176: lcmp
    //   177: ifle +63 -> 240
    //   180: aload 5
    //   182: astore_2
    //   183: aload_3
    //   184: astore 4
    //   186: aload 5
    //   188: astore 6
    //   190: ldc 95
    //   192: iconst_2
    //   193: ldc 186
    //   195: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload 5
    //   200: astore_2
    //   201: aload_3
    //   202: astore 4
    //   204: aload 5
    //   206: astore 6
    //   208: aload 8
    //   210: invokevirtual 118	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   213: astore 7
    //   215: aload 7
    //   217: astore_1
    //   218: aload_3
    //   219: ifnull +7 -> 226
    //   222: aload_3
    //   223: invokevirtual 189	android/graphics/Bitmap:recycle	()V
    //   226: aload_1
    //   227: astore_2
    //   228: aload 5
    //   230: ifnull -202 -> 28
    //   233: aload 5
    //   235: invokevirtual 189	android/graphics/Bitmap:recycle	()V
    //   238: aload_1
    //   239: areturn
    //   240: aload 5
    //   242: astore_2
    //   243: aload_3
    //   244: astore 4
    //   246: aload 5
    //   248: astore 6
    //   250: aload 5
    //   252: invokevirtual 189	android/graphics/Bitmap:recycle	()V
    //   255: aload 5
    //   257: astore_2
    //   258: aload_3
    //   259: astore 4
    //   261: aload 5
    //   263: astore 6
    //   265: aload_3
    //   266: invokevirtual 189	android/graphics/Bitmap:recycle	()V
    //   269: aload_3
    //   270: ifnull +7 -> 277
    //   273: aload_3
    //   274: invokevirtual 189	android/graphics/Bitmap:recycle	()V
    //   277: aload 5
    //   279: ifnull +8 -> 287
    //   282: aload 5
    //   284: invokevirtual 189	android/graphics/Bitmap:recycle	()V
    //   287: aload_1
    //   288: iconst_0
    //   289: invokeinterface 161 2 0
    //   294: checkcast 163	java/lang/String
    //   297: areturn
    //   298: astore 5
    //   300: aconst_null
    //   301: astore_3
    //   302: aload_2
    //   303: astore 6
    //   305: aload 6
    //   307: astore_2
    //   308: aload_3
    //   309: astore 4
    //   311: aload 5
    //   313: invokevirtual 192	java/lang/Throwable:printStackTrace	()V
    //   316: aload 6
    //   318: astore_2
    //   319: aload_3
    //   320: astore 4
    //   322: invokestatic 197	java/lang/System:gc	()V
    //   325: aload_3
    //   326: ifnull +7 -> 333
    //   329: aload_3
    //   330: invokevirtual 189	android/graphics/Bitmap:recycle	()V
    //   333: aload 6
    //   335: ifnull -48 -> 287
    //   338: aload 6
    //   340: invokevirtual 189	android/graphics/Bitmap:recycle	()V
    //   343: goto -56 -> 287
    //   346: astore_1
    //   347: aconst_null
    //   348: astore 4
    //   350: aload_3
    //   351: astore_2
    //   352: aload 4
    //   354: ifnull +8 -> 362
    //   357: aload 4
    //   359: invokevirtual 189	android/graphics/Bitmap:recycle	()V
    //   362: aload_2
    //   363: ifnull +7 -> 370
    //   366: aload_2
    //   367: invokevirtual 189	android/graphics/Bitmap:recycle	()V
    //   370: aload_1
    //   371: athrow
    //   372: astore_1
    //   373: goto -21 -> 352
    //   376: astore 5
    //   378: goto -73 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	ApolloAvatarVideoProcessor
    //   0	381	1	paramList	List<String>
    //   1	366	2	localObject1	Object
    //   3	348	3	localObject2	Object
    //   5	353	4	localObject3	Object
    //   11	272	5	localBitmap	android.graphics.Bitmap
    //   298	14	5	localThrowable1	java.lang.Throwable
    //   376	1	5	localThrowable2	java.lang.Throwable
    //   8	331	6	localObject4	Object
    //   64	152	7	localObject5	Object
    //   55	154	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   57	91	298	java/lang/Throwable
    //   57	91	346	finally
    //   104	117	372	finally
    //   132	142	372	finally
    //   152	160	372	finally
    //   170	180	372	finally
    //   190	198	372	finally
    //   208	215	372	finally
    //   250	255	372	finally
    //   265	269	372	finally
    //   311	316	372	finally
    //   322	325	372	finally
    //   104	117	376	java/lang/Throwable
    //   132	142	376	java/lang/Throwable
    //   152	160	376	java/lang/Throwable
    //   170	180	376	java/lang/Throwable
    //   190	198	376	java/lang/Throwable
    //   208	215	376	java/lang/Throwable
    //   250	255	376	java/lang/Throwable
    //   265	269	376	java/lang/Throwable
  }
  
  private void a()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.d = null;
    this.c = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21) {}
    while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()) || (TextUtils.isEmpty(this.e))) {
      return;
    }
    Object localObject = this.e + File.separator + paramInt + ".mp4";
    localObject = new ApolloVideoEncoder(this.jdField_a_of_type_JavaUtilList, (String)localObject, paramInt, paramInt);
    ((ApolloVideoEncoder)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloVideoEncoder$OnEncodeFinishListener);
    ((ApolloVideoEncoder)localObject).a();
  }
  
  private void a(FileMsg paramFileMsg)
  {
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAppInterface == null) {
      return;
    }
    paramFileMsg = ((NearbyPeoplePhotoUploadProcessor)paramFileMsg.processor).mPhotoUrl;
    QLog.i("ApolloAvatarVideoProcessor", 1, "onFinalUploadProcess. photoId = " + paramFileMsg);
    paramFileMsg = (CardHandler)localAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (paramFileMsg != null) {
      paramFileMsg.a(true, localAppInterface.getCurrentAccountUin(), 0);
    }
    FaceUtil.a(null);
    if (((Integer)NearbySPUtil.a(localAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
      NearbySPUtil.a(localAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloAvatarVideoProcessor$OnProcessFinishListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloAvatarVideoProcessor$OnProcessFinishListener.a(true, this.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b()
  {
    QLog.i("ApolloAvatarVideoProcessor", 1, "startUpload");
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    a();
    this.jdField_b_of_type_Int = paramInt1;
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAppInterface == null)
    {
      QLog.i("ApolloAvatarVideoProcessor", 1, "process exits due to app null");
      return;
    }
    QLog.i("ApolloAvatarVideoProcessor", 1, "process " + paramInt1);
    ApolloAvatarFileManager.a().a(paramInt1, paramInt2, localAppInterface.getCurrentUin(), a(0), a(0), new ApolloAvatarVideoProcessor.3(this));
  }
  
  private void c()
  {
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAppInterface == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
      File localFile = new File(this.c);
      if ((localFile.exists()) && (localFile.length() > 0L))
      {
        ApolloVideoUtils.a(localAppInterface, this.c, 36, this.jdField_a_of_type_Int, 640);
        FaceUtil.a(this.c);
        QLog.i("ApolloAvatarVideoProcessor", 1, "uploadVideoBig " + localFile.length());
        return;
      }
      QLog.e("ApolloAvatarVideoProcessor", 1, "uploadVideoBig file empty: " + this.c);
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloAvatarVideoProcessor$OnProcessFinishListener == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloAvatarVideoProcessor$OnProcessFinishListener.a(false, this.jdField_b_of_type_Int);
  }
  
  private void d()
  {
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAppInterface == null) {}
    File localFile;
    do
    {
      return;
      localFile = new File(this.jdField_b_of_type_JavaLangString);
    } while ((!localFile.exists()) || (localFile.length() <= 0L));
    ApolloVideoUtils.a(localAppInterface, this.jdField_b_of_type_JavaLangString, 37, this.jdField_a_of_type_Int, 200);
    FaceUtil.a(this.jdField_b_of_type_JavaLangString);
    QLog.i("ApolloAvatarVideoProcessor", 1, "uploadVideoMedium " + localFile.length());
  }
  
  private void e()
  {
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAppInterface == null) {}
    File localFile;
    do
    {
      return;
      localFile = new File(this.jdField_a_of_type_JavaLangString);
    } while ((!localFile.exists()) || (localFile.length() <= 0L));
    ApolloVideoUtils.a(localAppInterface, this.jdField_a_of_type_JavaLangString, 38, this.jdField_a_of_type_Int, 100);
    FaceUtil.a(this.jdField_a_of_type_JavaLangString);
    QLog.i("ApolloAvatarVideoProcessor", 1, "uploadVideoSmall " + localFile.length());
  }
  
  private void f()
  {
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAppInterface == null) {}
    File localFile;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(this.d));
      localFile = new File(this.d);
    } while ((!localFile.exists()) || (localFile.length() <= 0L));
    ApolloVideoUtils.a(localAppInterface, this.d);
    FaceUtil.a(this.d);
    QLog.i("ApolloAvatarVideoProcessor", 1, "uploadVideoCover " + localFile.length());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ThreadManager.getSubThreadHandler().post(new ApolloAvatarVideoProcessor.2(this, paramInt1, paramInt2));
  }
  
  public void a(ApolloAvatarVideoProcessor.OnProcessFinishListener paramOnProcessFinishListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloAvatarVideoProcessor$OnProcessFinishListener = paramOnProcessFinishListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloAvatarVideoProcessor
 * JD-Core Version:    0.7.0.1
 */