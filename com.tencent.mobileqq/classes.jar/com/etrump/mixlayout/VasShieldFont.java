package com.etrump.mixlayout;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class VasShieldFont
{
  public static int a;
  public static Typeface a;
  public static final String a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static boolean jdField_a_of_type_Boolean;
  public static int b;
  private static Typeface jdField_b_of_type_AndroidGraphicsTypeface;
  public static String b;
  private static AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public static int c;
  private static String jdField_c_of_type_JavaLangString;
  private static AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static int d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("default_font");
    localStringBuilder.append(File.separator);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_JavaLangString = "";
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = -1;
    d = -1;
    jdField_a_of_type_Boolean = true;
  }
  
  public static int a()
  {
    if (d < 0) {
      d = BaseApplicationImpl.getApplication().getRuntime().getPreferences().getInt("keySysFontSetting", 0);
    }
    return d;
  }
  
  public static Typeface a()
  {
    if ((jdField_c_of_type_Int == 0) && (d <= 0) && (jdField_b_of_type_Int >= 1)) {
      return jdField_b_of_type_AndroidGraphicsTypeface;
    }
    return jdField_a_of_type_AndroidGraphicsTypeface;
  }
  
  public static Typeface a(MessageRecord paramMessageRecord)
  {
    if ((jdField_b_of_type_Int >= 1) && (paramMessageRecord != null))
    {
      if ((paramMessageRecord.isSend()) && (d > 0)) {
        return jdField_a_of_type_AndroidGraphicsTypeface;
      }
      if (TextHook.getInstance().isDefault()) {
        return jdField_b_of_type_AndroidGraphicsTypeface;
      }
      return Typeface.DEFAULT;
    }
    return Typeface.DEFAULT;
  }
  
  public static Typeface a(String paramString)
  {
    if (jdField_b_of_type_Int < 1) {
      return null;
    }
    if (TextHook.getInstance().isDefault()) {
      return jdField_b_of_type_AndroidGraphicsTypeface;
    }
    return Typeface.DEFAULT;
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(jdField_c_of_type_JavaLangString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(VasSoUtils.a());
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("default.ttf");
      jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    }
    return jdField_c_of_type_JavaLangString;
  }
  
  public static void a()
  {
    jdField_b_of_type_AndroidGraphicsTypeface = null;
    jdField_b_of_type_JavaLangString = "";
    jdField_a_of_type_Int = -1;
    d = -1;
    jdField_c_of_type_Int = -1;
    int i = a();
    jdField_a_of_type_Boolean = BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("keySysFontGrayTip", true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetData: sysFontSetting=");
      localStringBuilder.append(i);
      localStringBuilder.append(" showGrayTip=");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      QLog.d("VasShieldFont", 2, localStringBuilder.toString());
    }
  }
  
  public static void a(TextView paramTextView)
  {
    int m;
    if (jdField_b_of_type_Int < 0) {
      m = 1;
    }
    for (;;)
    {
      int j;
      try
      {
        paramTextView.setDrawingCacheEnabled(true);
        localObject = paramTextView.getDrawingCache();
        jdField_a_of_type_AndroidGraphicsTypeface = paramTextView.getTypeface();
        int n = paramTextView.getCurrentTextColor();
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label240;
        }
        i = ((Bitmap)localObject).getWidth();
        j = ((Bitmap)localObject).getHeight();
        int[] arrayOfInt = new int[i * j];
        ((Bitmap)localObject).getPixels(arrayOfInt, 0, i, 0, 0, i, j);
        j = 0;
        i = 0;
        k = i;
        if (j >= arrayOfInt.length) {
          break label242;
        }
        int i1 = arrayOfInt[j] & 0xFFFFFF;
        k = i;
        if (i1 == 0) {
          break label231;
        }
        k = i;
        if (i1 == (n & 0xFFFFFF)) {
          break label231;
        }
        k = 1;
      }
      catch (Exception paramTextView)
      {
        Object localObject;
        QLog.e("VasShieldFont", 2, "checkSysColorFont: ", paramTextView);
        return;
      }
      jdField_b_of_type_Int = i;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkColorFont: sSysColorFont=");
        ((StringBuilder)localObject).append(jdField_b_of_type_Int);
        QLog.d("VasShieldFont", 2, ((StringBuilder)localObject).toString());
      }
      paramTextView.setDrawingCacheEnabled(false);
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class).sendEmptyMessage(1060);
        return;
        paramTextView.setVisibility(8);
      }
      return;
      label231:
      j += 1;
      int i = k;
      continue;
      label240:
      int k = 0;
      label242:
      if (k != 0) {
        i = m;
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FontManagerConstants.FONT_DOWN_LOAD_PATH);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("default.zip");
      localObject = ((StringBuilder)localObject).toString();
      if (FileUtil.b((String)localObject)) {
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(VasSoUtils.a());
          localStringBuilder.append(jdField_a_of_type_JavaLangString);
          FileUtils.uncompressZip((String)localObject, localStringBuilder.toString(), false);
        }
        catch (IOException localIOException)
        {
          QLog.e("VasShieldFont", 2, "uncompress zip failed", localIOException);
        }
      }
      a(paramQQAppInterface);
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MqqHandler paramMqqHandler, SessionInfo paramSessionInfo)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (jdField_b_of_type_Int < 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasShieldFont", 2, "loadDefaultFont: user not uses color font.");
      }
      return;
    }
    if (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      ThreadManager.excute(new VasShieldFont.1(paramQQAppInterface, paramMqqHandler), 64, null, true);
    }
    if ((paramMqqHandler != null) && (paramSessionInfo != null) && (jdField_a_of_type_Boolean) && (jdField_b_of_type_Int > 0) && (jdField_a_of_type_Int > 1) && (jdField_c_of_type_Int == 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadDefaultFont: ShowGrayTip: sSysColorFont=");
        localStringBuilder.append(jdField_b_of_type_Int);
        localStringBuilder.append(" sDefaultFontType=");
        localStringBuilder.append(jdField_a_of_type_Int);
        QLog.d("VasShieldFont", 2, localStringBuilder.toString());
      }
      paramMqqHandler.removeMessages(87);
      paramMqqHandler.sendEmptyMessage(87);
      ThreadManager.getTimer().schedule(new VasShieldFont.2(paramQQAppInterface, paramSessionInfo), 2000L);
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt > -1)
    {
      d = paramInt;
      b();
      return BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("keySysFontSetting", paramInt).commit();
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return false;
    }
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (!ETEngine.getInstance().isEngineInited.get())
    {
      paramQQAppInterface = (IFontManagerService)paramQQAppInterface.getRuntimeService(IFontManagerService.class, "");
      if (paramQQAppInterface != null)
      {
        QLog.d("VasShieldFont", 2, "initHYEngine: ");
        paramQQAppInterface.tryInitHYEngine();
      }
    }
    if (ETEngine.getInstance().isEngineReady.get()) {
      ETEngine.getInstance().native_loadFont(a(), 9999, true);
    }
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    return true;
  }
  
  public static int b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasSysColorFont: defaultFontType=");
      localStringBuilder.append(jdField_a_of_type_Int);
      localStringBuilder.append(" sysColorFont=");
      localStringBuilder.append(jdField_b_of_type_Int);
      localStringBuilder.append(" sUserFontId=");
      localStringBuilder.append(jdField_c_of_type_Int);
      QLog.d("VasShieldFont", 2, localStringBuilder.toString());
    }
    if ((jdField_a_of_type_Int > 1) && (jdField_c_of_type_Int == 0)) {
      return jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public static void b()
  {
    Object localObject;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      VasUtils.a((AppInterface)localObject);
      localObject = ((QQAppInterface)localObject).getHandler(ChatActivity.class);
      if (localObject != null)
      {
        ((MqqHandler)localObject).removeMessages(87);
        ((MqqHandler)localObject).sendEmptyMessage(87);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshAIO: ");
      ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getRuntime());
      QLog.d("VasShieldFont", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = HardCodeUtil.a(2131715802);
    int i = ((String)localObject).length();
    paramString = new UniteGrayTipParam(paramString, jdField_b_of_type_JavaLangString, (String)localObject, paramInt, -5020, 1179653, MessageCache.a());
    paramString.b = new int[] { 1179653 };
    localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 1);
    ((Bundle)localObject).putString("key_action_DATA", IndividuationUrlHelper.a("myFont"));
    paramString.a(i - 7, i - 3, (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramString);
    UniteGrayTipMsgUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (QLog.isColorLevel()) {
      QLog.d("VasShieldFont", 2, "downloadDefaultFont");
    }
    ((IVasQuickUpdateService)paramQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "defaultFont_775", "defaultFont");
  }
  
  /* Error */
  private static boolean c()
  {
    // Byte code:
    //   0: new 17	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: invokestatic 128	com/tencent/mobileqq/vas/util/VasSoUtils:a	()Ljava/lang/String;
    //   12: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_1
    //   17: getstatic 37	com/etrump/mixlayout/VasShieldFont:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_1
    //   25: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 8
    //   30: aconst_null
    //   31: astore 7
    //   33: aconst_null
    //   34: astore 6
    //   36: aconst_null
    //   37: astore 5
    //   39: new 17	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   46: astore_1
    //   47: aload_1
    //   48: aload 8
    //   50: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_1
    //   55: ldc_w 443
    //   58: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: new 28	java/io/File
    //   65: dup
    //   66: aload_1
    //   67: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokespecial 446	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore 10
    //   75: new 28	java/io/File
    //   78: dup
    //   79: invokestatic 339	com/etrump/mixlayout/VasShieldFont:a	()Ljava/lang/String;
    //   82: invokespecial 446	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: astore 9
    //   87: ldc 41
    //   89: astore 4
    //   91: aload 10
    //   93: invokevirtual 449	java/io/File:exists	()Z
    //   96: ifeq +103 -> 199
    //   99: aload 10
    //   101: invokevirtual 452	java/io/File:isFile	()Z
    //   104: ifeq +95 -> 199
    //   107: new 454	java/io/InputStreamReader
    //   110: dup
    //   111: new 456	java/io/FileInputStream
    //   114: dup
    //   115: aload 10
    //   117: invokespecial 459	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   120: ldc_w 461
    //   123: invokespecial 464	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   126: astore_1
    //   127: new 466	java/io/BufferedReader
    //   130: dup
    //   131: aload_1
    //   132: invokespecial 469	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   135: astore_2
    //   136: aload_2
    //   137: invokevirtual 472	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   140: astore 4
    //   142: aload_2
    //   143: astore_3
    //   144: aload_1
    //   145: astore_2
    //   146: goto +57 -> 203
    //   149: astore 4
    //   151: aload_2
    //   152: astore_3
    //   153: aload 4
    //   155: astore_2
    //   156: goto +19 -> 175
    //   159: astore 4
    //   161: aconst_null
    //   162: astore 5
    //   164: aload_2
    //   165: astore_3
    //   166: aload 5
    //   168: astore_2
    //   169: goto +430 -> 599
    //   172: astore_2
    //   173: aconst_null
    //   174: astore_3
    //   175: aload_1
    //   176: astore 5
    //   178: aload_2
    //   179: astore_1
    //   180: aload 6
    //   182: astore 4
    //   184: aload 5
    //   186: astore_2
    //   187: goto +476 -> 663
    //   190: astore 4
    //   192: aconst_null
    //   193: astore_2
    //   194: aload_2
    //   195: astore_3
    //   196: goto +403 -> 599
    //   199: aconst_null
    //   200: astore_2
    //   201: aload_2
    //   202: astore_3
    //   203: aload 4
    //   205: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   208: istore_0
    //   209: iload_0
    //   210: ifeq +89 -> 299
    //   213: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +57 -> 273
    //   219: new 17	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   226: astore_1
    //   227: aload_1
    //   228: ldc_w 474
    //   231: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_1
    //   236: aload 10
    //   238: invokevirtual 449	java/io/File:exists	()Z
    //   241: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload_1
    //   246: ldc_w 476
    //   249: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_1
    //   254: aload 10
    //   256: invokevirtual 452	java/io/File:isFile	()Z
    //   259: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: ldc 156
    //   265: iconst_2
    //   266: aload_1
    //   267: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: aload 8
    //   275: invokestatic 479	com/tencent/mobileqq/utils/FileUtils:deleteDirectory	(Ljava/lang/String;)V
    //   278: aload_3
    //   279: ifnull +10 -> 289
    //   282: aload_3
    //   283: invokevirtual 482	java/io/BufferedReader:close	()V
    //   286: goto +3 -> 289
    //   289: aload_2
    //   290: ifnull +7 -> 297
    //   293: aload_2
    //   294: invokevirtual 483	java/io/InputStreamReader:close	()V
    //   297: iconst_0
    //   298: ireturn
    //   299: aload 9
    //   301: invokevirtual 449	java/io/File:exists	()Z
    //   304: ifeq +154 -> 458
    //   307: aload 9
    //   309: invokevirtual 452	java/io/File:isFile	()Z
    //   312: ifeq +146 -> 458
    //   315: new 456	java/io/FileInputStream
    //   318: dup
    //   319: aload 9
    //   321: invokespecial 459	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   324: astore_1
    //   325: aload_1
    //   326: aload 9
    //   328: invokevirtual 485	java/io/File:length	()J
    //   331: invokestatic 491	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   334: invokestatic 497	com/tencent/mobileqq/transfile/StructLongMessageDownloadProcessor:bytesToHexString	([B)Ljava/lang/String;
    //   337: astore 5
    //   339: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq +57 -> 399
    //   345: new 17	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   352: astore 6
    //   354: aload 6
    //   356: ldc_w 499
    //   359: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 6
    //   365: aload 5
    //   367: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 6
    //   373: ldc_w 501
    //   376: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload 6
    //   382: aload 4
    //   384: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: ldc 156
    //   390: iconst_2
    //   391: aload 6
    //   393: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: aload 5
    //   401: aload 4
    //   403: invokevirtual 505	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   406: istore_0
    //   407: iload_0
    //   408: ifeq +28 -> 436
    //   411: aload_3
    //   412: ifnull +10 -> 422
    //   415: aload_3
    //   416: invokevirtual 482	java/io/BufferedReader:close	()V
    //   419: goto +3 -> 422
    //   422: aload_2
    //   423: ifnull +7 -> 430
    //   426: aload_2
    //   427: invokevirtual 483	java/io/InputStreamReader:close	()V
    //   430: aload_1
    //   431: invokevirtual 506	java/io/FileInputStream:close	()V
    //   434: iconst_1
    //   435: ireturn
    //   436: goto +88 -> 524
    //   439: astore 5
    //   441: aload_1
    //   442: astore 4
    //   444: aload 5
    //   446: astore_1
    //   447: goto +216 -> 663
    //   450: astore 4
    //   452: aload_1
    //   453: astore 5
    //   455: goto +115 -> 570
    //   458: aload 5
    //   460: astore_1
    //   461: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   464: ifeq +60 -> 524
    //   467: new 17	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   474: astore_1
    //   475: aload_1
    //   476: ldc_w 508
    //   479: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload_1
    //   484: aload 9
    //   486: invokevirtual 449	java/io/File:exists	()Z
    //   489: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload_1
    //   494: ldc_w 476
    //   497: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_1
    //   502: aload 9
    //   504: invokevirtual 452	java/io/File:isFile	()Z
    //   507: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: ldc 156
    //   513: iconst_2
    //   514: aload_1
    //   515: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: aload 5
    //   523: astore_1
    //   524: aload_3
    //   525: ifnull +10 -> 535
    //   528: aload_3
    //   529: invokevirtual 482	java/io/BufferedReader:close	()V
    //   532: goto +3 -> 535
    //   535: aload_2
    //   536: ifnull +10 -> 546
    //   539: aload_2
    //   540: invokevirtual 483	java/io/InputStreamReader:close	()V
    //   543: goto +3 -> 546
    //   546: aload_1
    //   547: ifnull +99 -> 646
    //   550: aload_1
    //   551: invokevirtual 506	java/io/FileInputStream:close	()V
    //   554: goto +92 -> 646
    //   557: astore_1
    //   558: aload 6
    //   560: astore 4
    //   562: goto +101 -> 663
    //   565: astore 4
    //   567: aconst_null
    //   568: astore 5
    //   570: aload_2
    //   571: astore_1
    //   572: aload 5
    //   574: astore_2
    //   575: goto +24 -> 599
    //   578: astore_1
    //   579: aconst_null
    //   580: astore_2
    //   581: aload_2
    //   582: astore_3
    //   583: aload 6
    //   585: astore 4
    //   587: goto +76 -> 663
    //   590: astore 4
    //   592: aconst_null
    //   593: astore_2
    //   594: aload_2
    //   595: astore_3
    //   596: aload 7
    //   598: astore_1
    //   599: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   602: ifeq +14 -> 616
    //   605: ldc 156
    //   607: iconst_2
    //   608: ldc_w 510
    //   611: aload 4
    //   613: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   616: aload_3
    //   617: ifnull +10 -> 627
    //   620: aload_3
    //   621: invokevirtual 482	java/io/BufferedReader:close	()V
    //   624: goto +3 -> 627
    //   627: aload_1
    //   628: ifnull +10 -> 638
    //   631: aload_1
    //   632: invokevirtual 483	java/io/InputStreamReader:close	()V
    //   635: goto +3 -> 638
    //   638: aload_2
    //   639: ifnull +7 -> 646
    //   642: aload_2
    //   643: invokevirtual 506	java/io/FileInputStream:close	()V
    //   646: aload 8
    //   648: invokestatic 479	com/tencent/mobileqq/utils/FileUtils:deleteDirectory	(Ljava/lang/String;)V
    //   651: iconst_0
    //   652: ireturn
    //   653: astore 5
    //   655: aload_2
    //   656: astore 4
    //   658: aload_1
    //   659: astore_2
    //   660: aload 5
    //   662: astore_1
    //   663: aload_3
    //   664: ifnull +10 -> 674
    //   667: aload_3
    //   668: invokevirtual 482	java/io/BufferedReader:close	()V
    //   671: goto +3 -> 674
    //   674: aload_2
    //   675: ifnull +10 -> 685
    //   678: aload_2
    //   679: invokevirtual 483	java/io/InputStreamReader:close	()V
    //   682: goto +3 -> 685
    //   685: aload 4
    //   687: ifnull +8 -> 695
    //   690: aload 4
    //   692: invokevirtual 506	java/io/FileInputStream:close	()V
    //   695: aload_1
    //   696: athrow
    //   697: astore_1
    //   698: goto -409 -> 289
    //   701: astore_1
    //   702: iconst_0
    //   703: ireturn
    //   704: astore_3
    //   705: goto -283 -> 422
    //   708: astore_2
    //   709: goto -279 -> 430
    //   712: astore_1
    //   713: iconst_1
    //   714: ireturn
    //   715: astore_3
    //   716: goto -181 -> 535
    //   719: astore_2
    //   720: goto -174 -> 546
    //   723: astore_1
    //   724: goto -78 -> 646
    //   727: astore_3
    //   728: goto -101 -> 627
    //   731: astore_1
    //   732: goto -94 -> 638
    //   735: astore_3
    //   736: goto -62 -> 674
    //   739: astore_2
    //   740: goto -55 -> 685
    //   743: astore_2
    //   744: goto -49 -> 695
    // Local variable table:
    //   start	length	slot	name	signature
    //   208	200	0	bool	boolean
    //   7	544	1	localObject1	Object
    //   557	1	1	localObject2	Object
    //   571	1	1	localObject3	Object
    //   578	1	1	localObject4	Object
    //   598	98	1	localObject5	Object
    //   697	1	1	localException1	Exception
    //   701	1	1	localException2	Exception
    //   712	1	1	localException3	Exception
    //   723	1	1	localException4	Exception
    //   731	1	1	localException5	Exception
    //   135	34	2	localObject6	Object
    //   172	7	2	localObject7	Object
    //   186	493	2	localObject8	Object
    //   708	1	2	localException6	Exception
    //   719	1	2	localException7	Exception
    //   739	1	2	localException8	Exception
    //   743	1	2	localException9	Exception
    //   143	525	3	localObject9	Object
    //   704	1	3	localException10	Exception
    //   715	1	3	localException11	Exception
    //   727	1	3	localException12	Exception
    //   735	1	3	localException13	Exception
    //   89	52	4	str1	String
    //   149	5	4	localObject10	Object
    //   159	1	4	localException14	Exception
    //   182	1	4	localStringBuilder1	StringBuilder
    //   190	212	4	localException15	Exception
    //   442	1	4	localObject11	Object
    //   450	1	4	localException16	Exception
    //   560	1	4	localStringBuilder2	StringBuilder
    //   565	1	4	localException17	Exception
    //   585	1	4	localStringBuilder3	StringBuilder
    //   590	22	4	localException18	Exception
    //   656	35	4	localObject12	Object
    //   37	363	5	localObject13	Object
    //   439	6	5	localObject14	Object
    //   453	120	5	localObject15	Object
    //   653	8	5	localObject16	Object
    //   34	550	6	localStringBuilder4	StringBuilder
    //   31	566	7	localObject17	Object
    //   28	619	8	str2	String
    //   85	418	9	localFile1	File
    //   73	182	10	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   136	142	149	finally
    //   136	142	159	java/lang/Exception
    //   127	136	172	finally
    //   127	136	190	java/lang/Exception
    //   325	399	439	finally
    //   399	407	439	finally
    //   325	399	450	java/lang/Exception
    //   399	407	450	java/lang/Exception
    //   203	209	557	finally
    //   213	273	557	finally
    //   273	278	557	finally
    //   299	325	557	finally
    //   461	521	557	finally
    //   203	209	565	java/lang/Exception
    //   213	273	565	java/lang/Exception
    //   273	278	565	java/lang/Exception
    //   299	325	565	java/lang/Exception
    //   461	521	565	java/lang/Exception
    //   39	87	578	finally
    //   91	127	578	finally
    //   39	87	590	java/lang/Exception
    //   91	127	590	java/lang/Exception
    //   599	616	653	finally
    //   282	286	697	java/lang/Exception
    //   293	297	701	java/lang/Exception
    //   415	419	704	java/lang/Exception
    //   426	430	708	java/lang/Exception
    //   430	434	712	java/lang/Exception
    //   528	532	715	java/lang/Exception
    //   539	543	719	java/lang/Exception
    //   550	554	723	java/lang/Exception
    //   642	646	723	java/lang/Exception
    //   620	624	727	java/lang/Exception
    //   631	635	731	java/lang/Exception
    //   667	671	735	java/lang/Exception
    //   678	682	739	java/lang/Exception
    //   690	695	743	java/lang/Exception
  }
  
  private static void d()
  {
    if (FileUtil.b(a()))
    {
      int i = jdField_a_of_type_Int;
      if ((i != 3) && (i != 5) && (i != 6)) {
        return;
      }
      try
      {
        jdField_b_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(a());
        return;
      }
      catch (Exception localException)
      {
        QLog.e("VasShieldFont", 2, "createFromFile:", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.VasShieldFont
 * JD-Core Version:    0.7.0.1
 */