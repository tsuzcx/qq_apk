package com.immersion.stickersampleapp;

import amm;
import amn;
import amo;
import amp;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import com.immersion.touchsensesdk.HapticMediaPlayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class HapticManager
{
  private static HapticManager jdField_a_of_type_ComImmersionStickersampleappHapticManager = new HapticManager(BaseApplicationImpl.sApplication);
  private static final String jdField_a_of_type_JavaLangString = PokeItemHelper.a() + "poke/immersion_source/libTouchSenseSDK.so";
  private amm jdField_a_of_type_Amm = new amm(this);
  private amn jdField_a_of_type_Amn = new amn(this);
  private amp jdField_a_of_type_Amp;
  private Context jdField_a_of_type_AndroidContentContext;
  private ImmerIConnectionProxy jdField_a_of_type_ComImmersionStickersampleappImmerIConnectionProxy;
  private HapticMediaPlayer jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  private boolean c;
  
  private HapticManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComImmersionStickersampleappImmerIConnectionProxy = new ImmerIConnectionProxy();
    this.jdField_a_of_type_Amp = new amp(this);
  }
  
  private amo a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      amo localamo = (amo)localIterator.next();
      if (amo.a(localamo).equals(paramString)) {
        return localamo;
      }
    }
    return null;
  }
  
  public static HapticManager a()
  {
    try
    {
      HapticManager localHapticManager = jdField_a_of_type_ComImmersionStickersampleappHapticManager;
      return localHapticManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private String a(int paramInt, String paramString)
  {
    Object localObject = null;
    byte[] arrayOfByte = new byte[1024];
    localInputStream = this.jdField_a_of_type_AndroidContentContext.getResources().openRawResource(paramInt);
    try
    {
      FileOutputStream localFileOutputStream = this.jdField_a_of_type_AndroidContentContext.openFileOutput(paramString + ".hapt", 0);
      localObject = localFileOutputStream;
      for (paramInt = localInputStream.available(); paramInt > 0; paramInt = localInputStream.available())
      {
        localObject = localFileOutputStream;
        localFileOutputStream.write(arrayOfByte, 0, localInputStream.read(arrayOfByte));
        localObject = localFileOutputStream;
      }
      localObject = localFileOutputStream;
      localFileOutputStream.close();
      localObject = localFileOutputStream;
      localInputStream.close();
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        try
        {
          localInputStream.close();
        }
        catch (Exception localException1) {}
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          localException1.close();
          localInputStream.close();
        }
        catch (Exception localException2) {}
      }
    }
    localObject = this.jdField_a_of_type_AndroidContentContext.getFilesDir();
    return ((File)localObject).getAbsolutePath() + File.separator + paramString + ".hapt";
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HapticManager", 4, "HapticManager doRequest so zip");
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Object localObject = (EarlyDownloadManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(76);
      if (localObject != null)
      {
        localObject = (PokeResHandler)((EarlyDownloadManager)localObject).a("qq.android.poke.res_1228");
        if (localObject != null)
        {
          if (paramBoolean)
          {
            XmlData localXmlData = ((PokeResHandler)localObject).a();
            localXmlData.loadState = 0;
            EarlyDataFactory.a(localXmlData, new String[0]);
          }
          ((PokeResHandler)localObject).a(false);
        }
      }
    }
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HapticManager", 2, "HapticMediaPlayer start check so");
    }
    this.b = false;
    Object localObject1 = new File(jdField_a_of_type_JavaLangString);
    Object localObject2 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HapticManager", 2, "getFilesDir is null");
      }
      return false;
    }
    localObject2 = ((File)localObject2).getParent() + "/immer";
    Object localObject3 = new File((String)localObject2);
    if (!((File)localObject3).exists()) {
      ((File)localObject3).mkdir();
    }
    localObject2 = new File((String)localObject2 + File.separator + "libTouchSenseSDK.so");
    if ((((File)localObject2).exists()) || ((((File)localObject1).exists()) && (a((File)localObject1, (File)localObject2)))) {}
    try
    {
      localObject1 = com.tencent.qphone.base.util.BaseApplication.getContext().getSharedPreferences("early_qq.android.poke.res_1228", 0);
      localObject3 = ((SharedPreferences)localObject1).getString("SoMD5", "");
      l = ((SharedPreferences)localObject1).getLong("SoLength", 0L);
      if (QLog.isColorLevel()) {
        QLog.e("HapticManager", 2, "somd5 : " + (String)localObject3 + "\nsolength :" + l);
      }
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (l == 0L))
      {
        a(false);
        return false;
      }
    }
    catch (IOException localIOException)
    {
      long l;
      if (QLog.isColorLevel()) {
        QLog.e("HapticManager", 2, "HapticMediaPlayer so load fail");
      }
      this.b = false;
      localIOException.printStackTrace();
      a(true);
      return false;
      if ((!((String)localObject3).equals(MD5FileUtil.a((File)localObject2))) || (((File)localObject2).length() != l))
      {
        a(true);
        ((File)localObject2).delete();
        return false;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HapticManager", 2, "HapticMediaPlayer so load fail");
        }
        localUnsatisfiedLinkError.printStackTrace();
        this.b = false;
      }
      System.load(((File)localObject2).getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.e("HapticManager", 2, "HapticMediaPlayer so load success");
      }
      this.b = true;
    }
    return true;
  }
  
  private boolean b(int paramInt)
  {
    if (!a()) {}
    while (paramInt < 0) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 340	com/immersion/stickersampleapp/HapticManager:g	()V
    //   6: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +12 -> 21
    //   12: ldc 180
    //   14: iconst_2
    //   15: ldc_w 342
    //   18: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 70	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   26: ldc_w 344
    //   29: ldc_w 346
    //   32: ldc_w 348
    //   35: aload_0
    //   36: getfield 80	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_ComImmersionStickersampleappImmerIConnectionProxy	Lcom/immersion/stickersampleapp/ImmerIConnectionProxy;
    //   39: invokestatic 354	com/immersion/touchsensesdk/HapticMediaPlayer:create	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/immersion/touchsensesdk/AsyncConnectionProxy;)Lcom/immersion/touchsensesdk/HapticMediaPlayer;
    //   42: putfield 356	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer	Lcom/immersion/touchsensesdk/HapticMediaPlayer;
    //   45: aload_0
    //   46: getfield 356	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer	Lcom/immersion/touchsensesdk/HapticMediaPlayer;
    //   49: ifnull +84 -> 133
    //   52: aload_0
    //   53: getfield 356	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer	Lcom/immersion/touchsensesdk/HapticMediaPlayer;
    //   56: bipush 40
    //   58: invokevirtual 360	com/immersion/touchsensesdk/HapticMediaPlayer:getPlayerInfo	(I)I
    //   61: istore_1
    //   62: iload_1
    //   63: ifeq +70 -> 133
    //   66: new 122	java/lang/Exception
    //   69: dup
    //   70: new 22	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 362
    //   80: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_0
    //   84: getfield 364	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   87: iload_1
    //   88: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: invokevirtual 376	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   94: checkcast 110	java/lang/String
    //   97: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokespecial 377	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   106: athrow
    //   107: astore_2
    //   108: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +12 -> 123
    //   114: ldc 180
    //   116: iconst_2
    //   117: ldc_w 379
    //   120: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: ldc 180
    //   125: aload_2
    //   126: invokevirtual 382	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   129: invokestatic 387	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   132: pop
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: astore_2
    //   137: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +12 -> 152
    //   143: ldc 180
    //   145: iconst_2
    //   146: ldc_w 389
    //   149: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_0
    //   153: iconst_0
    //   154: putfield 243	com/immersion/stickersampleapp/HapticManager:b	Z
    //   157: ldc 180
    //   159: aload_2
    //   160: invokevirtual 390	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   163: invokestatic 387	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   166: pop
    //   167: goto -34 -> 133
    //   170: astore_2
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_2
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	HapticManager
    //   61	27	1	i	int
    //   107	19	2	localException	Exception
    //   136	24	2	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   170	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	21	107	java/lang/Exception
    //   21	62	107	java/lang/Exception
    //   66	107	107	java/lang/Exception
    //   6	21	136	java/lang/UnsatisfiedLinkError
    //   21	62	136	java/lang/UnsatisfiedLinkError
    //   66	107	136	java/lang/UnsatisfiedLinkError
    //   2	6	170	finally
    //   6	21	170	finally
    //   21	62	170	finally
    //   66	107	170	finally
    //   108	123	170	finally
    //   123	133	170	finally
    //   137	152	170	finally
    //   152	167	170	finally
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer != null) {
      this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.dispose();
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      b();
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void f()
  {
    int i = 0;
    int[] arrayOfInt = new int[9];
    int[] tmp8_7 = arrayOfInt;
    tmp8_7[0] = 2131230723;
    int[] tmp14_8 = tmp8_7;
    tmp14_8[1] = 2131230722;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131230724;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131230725;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131230726;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131230727;
    int[] tmp44_38 = tmp38_32;
    tmp44_38[6] = 2131230728;
    int[] tmp51_44 = tmp44_38;
    tmp51_44[7] = 2131230729;
    int[] tmp58_51 = tmp51_44;
    tmp58_51[8] = 2131230730;
    tmp58_51;
    String[] arrayOfString = new String[9];
    arrayOfString[0] = "chat_item_for_qq666";
    arrayOfString[1] = "chat_item_for_likeplus";
    arrayOfString[2] = "chat_item_for_qqbixin_light";
    arrayOfString[3] = "chat_item_for_qqbixin_strong";
    arrayOfString[4] = "chat_item_for_qqheartbroken";
    arrayOfString[5] = "chat_item_for_qqlikenew";
    arrayOfString[6] = "chat_item_for_qqpokenew";
    arrayOfString[7] = "chat_item_for_qqultnew";
    arrayOfString[8] = "chat_item_for_sticker40";
    while (i < arrayOfInt.length)
    {
      String str = a(arrayOfInt[i], arrayOfString[i]);
      int j = this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.addResource(str, 1);
      this.jdField_a_of_type_JavaUtilList.add(new amo(this, arrayOfString[i], j));
      i += 1;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), "SUCCESS");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), "MISSING_PERMISSIONS");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), "INVALID_PARAMETER");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-1), "INVALID_PARAMETER");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-2), "INVALID_URI");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-3), "INVALID_EFFECT");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-5), "OUT_OF_MEMORY");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-7), "IO_ERROR");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-9), "HAPT_NOT_READY");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-10), "TOO_MANY_EFFECTS");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-11), "PLAYER_NOT_INITIALIZED");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), "INVALID_CREDENTIALS");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-12), "TOO_MANY_CONCURRENT_EFFECTS");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-13), "INVALID_STATE");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-14), "LIB_VERSION_NOT_FOUND");
  }
  
  public int a(String paramString, int paramInt)
  {
    boolean bool = false;
    paramInt = a(paramString, paramInt, false);
    if (paramInt > 0) {
      bool = true;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("effectName", paramString);
    StatisticCollector.a(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).a(null, "pokeEffectSucessRate", bool, 0L, 0L, localHashMap, "");
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_Amm);
    ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_Amm, 60000L);
    return paramInt;
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TouchEffect", 2, "playEffect: " + paramString);
    }
    if (!a()) {
      return -1;
    }
    a();
    amo localamo = a(paramString);
    if (localamo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HapticManager", 2, "No effect added with name " + paramString);
      }
      return -1;
    }
    b();
    int i = amo.a(localamo);
    if (i < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TouchEffect", 2, "Invalid resource id for effect with name " + paramString + "! Error code returned = " + (String)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
      }
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TouchEffect", 2, "resource id:" + i);
    }
    paramInt = this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.play(i, paramInt);
    if (paramInt < 0) {
      if (QLog.isColorLevel()) {
        QLog.d("HapticManager", 2, "Error while playing haptic effect with name " + paramString + "! Error returned = " + (String)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
      }
    }
    for (;;)
    {
      return paramInt;
      amo.a(localamo, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("TouchEffect", 2, "effect id:" + amo.b(localamo));
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (a())
      {
        f();
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    if (!b(paramInt)) {}
    while (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.pause(paramInt) == 0) {
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!b(paramInt1)) {}
    while ((!a(paramInt1)) || (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.update(paramInt1, paramInt2) == 0)) {
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HapticManager", 2, "add effect from sd card, effectName: " + paramString1 + ".");
    }
    if (!new File(paramString2).exists())
    {
      QLog.i("HapticManager", 1, "vas poke shock file " + paramString1 + " not exists.");
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (amo.a((amo)localIterator.next()).equals(paramString1)) {
        return;
      }
    }
    if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer != null)
    {
      int i = this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.addResource(paramString2, 1);
      this.jdField_a_of_type_JavaUtilList.add(new amo(this, paramString1, i));
      QLog.i("HapticManager", 1, "vas poke shock file " + paramString1 + " load success.");
      return;
    }
    QLog.i("HapticManager", 1, "vas poke shock file " + paramString1 + " load failure, because mHapticMediaPlayer is null.");
  }
  
  public boolean a()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer == null)
        {
          if (this.b) {
            break label81;
          }
          if (!this.c)
          {
            this.c = true;
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
              continue;
            }
            ThreadManager.post(this.jdField_a_of_type_Amp, 10, null, false);
          }
        }
        HapticMediaPlayer localHapticMediaPlayer = this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer;
        if (localHapticMediaPlayer == null) {
          break label88;
        }
        return bool;
        this.jdField_a_of_type_Amp.run();
        continue;
        d();
      }
      finally {}
      label81:
      continue;
      label88:
      bool = false;
    }
  }
  
  public boolean a(int paramInt)
  {
    return (a()) && (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.getEffectInfo(paramInt, 51) == 21);
  }
  
  /* Error */
  public boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_2
    //   10: invokevirtual 610	java/io/File:createNewFile	()Z
    //   13: pop
    //   14: new 612	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 615	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 6
    //   24: new 152	java/io/FileOutputStream
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 616	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   32: astore_1
    //   33: sipush 1024
    //   36: newarray byte
    //   38: astore_2
    //   39: aload 6
    //   41: aload_2
    //   42: invokevirtual 617	java/io/FileInputStream:read	([B)I
    //   45: istore_3
    //   46: iload_3
    //   47: ifle +54 -> 101
    //   50: aload_1
    //   51: aload_2
    //   52: iconst_0
    //   53: iload_3
    //   54: invokevirtual 156	java/io/FileOutputStream:write	([BII)V
    //   57: goto -18 -> 39
    //   60: astore 7
    //   62: aload 6
    //   64: astore_2
    //   65: aload 7
    //   67: astore 6
    //   69: aload 6
    //   71: invokevirtual 314	java/io/IOException:printStackTrace	()V
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 618	java/io/FileInputStream:close	()V
    //   82: iload 5
    //   84: istore 4
    //   86: aload_1
    //   87: ifnull +11 -> 98
    //   90: aload_1
    //   91: invokevirtual 159	java/io/FileOutputStream:close	()V
    //   94: iload 5
    //   96: istore 4
    //   98: iload 4
    //   100: ireturn
    //   101: iconst_1
    //   102: istore 4
    //   104: aload 6
    //   106: ifnull +8 -> 114
    //   109: aload 6
    //   111: invokevirtual 618	java/io/FileInputStream:close	()V
    //   114: aload_1
    //   115: ifnull -17 -> 98
    //   118: aload_1
    //   119: invokevirtual 159	java/io/FileOutputStream:close	()V
    //   122: iconst_1
    //   123: ireturn
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 314	java/io/IOException:printStackTrace	()V
    //   129: iconst_1
    //   130: ireturn
    //   131: astore_2
    //   132: aload_2
    //   133: invokevirtual 314	java/io/IOException:printStackTrace	()V
    //   136: goto -22 -> 114
    //   139: astore_2
    //   140: aload_2
    //   141: invokevirtual 314	java/io/IOException:printStackTrace	()V
    //   144: goto -62 -> 82
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 314	java/io/IOException:printStackTrace	()V
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_1
    //   155: aconst_null
    //   156: astore 6
    //   158: aload 7
    //   160: astore_2
    //   161: aload 6
    //   163: ifnull +8 -> 171
    //   166: aload 6
    //   168: invokevirtual 618	java/io/FileInputStream:close	()V
    //   171: aload_2
    //   172: ifnull +7 -> 179
    //   175: aload_2
    //   176: invokevirtual 159	java/io/FileOutputStream:close	()V
    //   179: aload_1
    //   180: athrow
    //   181: astore 6
    //   183: aload 6
    //   185: invokevirtual 314	java/io/IOException:printStackTrace	()V
    //   188: goto -17 -> 171
    //   191: astore_2
    //   192: aload_2
    //   193: invokevirtual 314	java/io/IOException:printStackTrace	()V
    //   196: goto -17 -> 179
    //   199: astore_1
    //   200: aload 7
    //   202: astore_2
    //   203: goto -42 -> 161
    //   206: astore 7
    //   208: aload_1
    //   209: astore_2
    //   210: aload 7
    //   212: astore_1
    //   213: goto -52 -> 161
    //   216: astore 7
    //   218: aload_2
    //   219: astore 6
    //   221: aload_1
    //   222: astore_2
    //   223: aload 7
    //   225: astore_1
    //   226: goto -65 -> 161
    //   229: astore 6
    //   231: aconst_null
    //   232: astore_1
    //   233: aload 8
    //   235: astore_2
    //   236: goto -167 -> 69
    //   239: astore 7
    //   241: aconst_null
    //   242: astore_1
    //   243: aload 6
    //   245: astore_2
    //   246: aload 7
    //   248: astore 6
    //   250: goto -181 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	HapticManager
    //   0	253	1	paramFile1	File
    //   0	253	2	paramFile2	File
    //   45	9	3	i	int
    //   84	19	4	bool1	boolean
    //   7	88	5	bool2	boolean
    //   22	145	6	localObject1	Object
    //   181	3	6	localIOException1	IOException
    //   219	1	6	localFile	File
    //   229	15	6	localIOException2	IOException
    //   248	1	6	localIOException3	IOException
    //   1	1	7	localObject2	Object
    //   60	141	7	localIOException4	IOException
    //   206	5	7	localObject3	Object
    //   216	8	7	localObject4	Object
    //   239	8	7	localIOException5	IOException
    //   4	230	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   33	39	60	java/io/IOException
    //   39	46	60	java/io/IOException
    //   50	57	60	java/io/IOException
    //   118	122	124	java/io/IOException
    //   109	114	131	java/io/IOException
    //   78	82	139	java/io/IOException
    //   90	94	147	java/io/IOException
    //   9	24	154	finally
    //   166	171	181	java/io/IOException
    //   175	179	191	java/io/IOException
    //   24	33	199	finally
    //   33	39	206	finally
    //   39	46	206	finally
    //   50	57	206	finally
    //   69	74	216	finally
    //   9	24	229	java/io/IOException
    //   24	33	239	java/io/IOException
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TouchEffect", 2, "stopAll");
    }
    if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        int i = amo.b((amo)localIterator.next());
        if ((i > 0) && (a(i))) {
          c(i);
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (!b(paramInt)) {}
    while (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.resume(paramInt) == 0) {
      return;
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_ComImmersionStickersampleappImmerIConnectionProxy.setConnection(null);
      e();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TouchEffect", 2, "stopEffect: " + paramInt);
    }
    if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer == null) {}
    while ((!b(paramInt)) || (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.stop(paramInt) == 0)) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.immersion.stickersampleapp.HapticManager
 * JD-Core Version:    0.7.0.1
 */