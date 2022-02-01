package com.tencent.avgame.localvoicerecog;

import android.text.TextUtils;
import com.tencent.av.so.ResInfo;
import com.tencent.av.so.ResMgr;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.gameres.AvGameResPreloadManager;
import com.tencent.avgame.gamelogic.gameres.AvGameResPreloadManager.ConfInfo;
import com.tencent.avgame.gamelogic.gameres.AvGameResPreloadManager.PathInfo;
import com.tencent.avgame.localvoicerecog.engine.IVoiceRecogEngine;
import com.tencent.avgame.localvoicerecog.engine.VoiceRecogEngineFactory;
import com.tencent.avgame.localvoicerecog.engine.VoiceRecogEngineFactory.VoiceRecogEngineType;
import com.tencent.avgame.util.AvGameConfBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AVGameVoiceRecog
{
  private static volatile AVGameVoiceRecog jdField_a_of_type_ComTencentAvgameLocalvoicerecogAVGameVoiceRecog;
  private int jdField_a_of_type_Int = -1;
  private boolean jdField_a_of_type_Boolean = true;
  
  public static AVGameVoiceRecog a()
  {
    if (jdField_a_of_type_ComTencentAvgameLocalvoicerecogAVGameVoiceRecog == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvgameLocalvoicerecogAVGameVoiceRecog == null) {
        jdField_a_of_type_ComTencentAvgameLocalvoicerecogAVGameVoiceRecog = new AVGameVoiceRecog();
      }
      return jdField_a_of_type_ComTencentAvgameLocalvoicerecogAVGameVoiceRecog;
    }
    finally {}
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("[,，。、 ]", "");
  }
  
  private boolean a(VoiceRecogEngineFactory.VoiceRecogEngineType paramVoiceRecogEngineType)
  {
    Object localObject = AvGameResPreloadManager.a();
    AvGameResPreloadManager.ConfInfo localConfInfo = AvGameResPreloadManager.b();
    QLog.d("AVGameVoiceRecog", 1, "isLocalVoiceModelPreloadReady getinfo fro sp. pathinfo:" + localObject + "confinfo:" + localConfInfo);
    String str4;
    String str3;
    String str2;
    String str1;
    if (paramVoiceRecogEngineType == VoiceRecogEngineFactory.VoiceRecogEngineType.WX_ENGINE_TYPE)
    {
      QLog.d("AVGameVoiceRecog", 1, "isLocalVoiceModelPreloadReady use wx type");
      str4 = ((AvGameResPreloadManager.PathInfo)localObject).b;
      str3 = localConfInfo.d;
      str2 = localConfInfo.e;
      str1 = ((AvGameResPreloadManager.PathInfo)localObject).c;
      localObject = localConfInfo.g;
      paramVoiceRecogEngineType = localConfInfo.h;
    }
    while ((TextUtils.isEmpty(str4)) || (!FileUtils.a(str4)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1)) || (!FileUtils.a(str1)) || (TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramVoiceRecogEngineType)))
    {
      QLog.w("AVGameVoiceRecog", 1, "isLocalVoiceModelPreloadReady fails by path not ready. soFullFileName = " + str4 + ", modelFullFileName = " + str1);
      return false;
      if (paramVoiceRecogEngineType == VoiceRecogEngineFactory.VoiceRecogEngineType.AILAB_ENGINE_TYPE)
      {
        QLog.d("AVGameVoiceRecog", 1, "isLocalVoiceModelPreloadReady use ailab type");
        str4 = ((AvGameResPreloadManager.PathInfo)localObject).d;
        str3 = localConfInfo.j;
        str2 = localConfInfo.k;
        str1 = ((AvGameResPreloadManager.PathInfo)localObject).e;
        localObject = localConfInfo.m;
        paramVoiceRecogEngineType = localConfInfo.n;
      }
      else
      {
        QLog.w("AVGameVoiceRecog", 1, "isLocalVoiceModelPreloadReady use remote type");
        return false;
      }
    }
    return true;
  }
  
  private boolean b(VoiceRecogEngineFactory.VoiceRecogEngineType paramVoiceRecogEngineType)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4);
    Object localObject2 = AvGameResPreloadManager.a();
    Object localObject1 = AvGameResPreloadManager.b();
    QLog.d("AVGameVoiceRecog", 1, "loadLocalVoiceModelResByPreload getinfo fro sp. pathinfo:" + localObject2 + "confinfo:" + localObject1);
    String str1;
    String str3;
    if (paramVoiceRecogEngineType == VoiceRecogEngineFactory.VoiceRecogEngineType.WX_ENGINE_TYPE)
    {
      QLog.d("AVGameVoiceRecog", 1, "loadLocalVoiceModelResByPreload use wx type");
      str1 = ((AvGameResPreloadManager.PathInfo)localObject2).b;
      str3 = ((AvGameResPreloadManager.ConfInfo)localObject1).d;
      str2 = ((AvGameResPreloadManager.ConfInfo)localObject1).e;
      paramVoiceRecogEngineType = ((AvGameResPreloadManager.PathInfo)localObject2).c;
      localObject2 = ((AvGameResPreloadManager.ConfInfo)localObject1).g;
      localObject1 = ((AvGameResPreloadManager.ConfInfo)localObject1).h;
    }
    while ((TextUtils.isEmpty(str1)) || (!FileUtils.a(str1)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(paramVoiceRecogEngineType)) || (!FileUtils.a(paramVoiceRecogEngineType)) || (TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      QLog.w("AVGameVoiceRecog", 1, "loadLocalVoiceModelResByPreload fails by path not ready. soFullFileName = " + str1 + ", modelFullFileName = " + paramVoiceRecogEngineType);
      return false;
      if (paramVoiceRecogEngineType == VoiceRecogEngineFactory.VoiceRecogEngineType.AILAB_ENGINE_TYPE)
      {
        QLog.d("AVGameVoiceRecog", 1, "loadLocalVoiceModelResByPreload use ailab type");
        str1 = ((AvGameResPreloadManager.PathInfo)localObject2).d;
        str3 = ((AvGameResPreloadManager.ConfInfo)localObject1).j;
        str2 = ((AvGameResPreloadManager.ConfInfo)localObject1).k;
        paramVoiceRecogEngineType = ((AvGameResPreloadManager.PathInfo)localObject2).e;
        localObject2 = ((AvGameResPreloadManager.ConfInfo)localObject1).m;
        localObject1 = ((AvGameResPreloadManager.ConfInfo)localObject1).n;
      }
      else
      {
        QLog.w("AVGameVoiceRecog", 1, "loadLocalVoiceModelResByPreload use remote type");
        return false;
      }
    }
    QLog.d("AVGameVoiceRecog", 1, "loadLocalVoiceModelResByPreload. soFullFileName = " + str1 + ", modelFullFileName = " + paramVoiceRecogEngineType);
    String str4 = AVSoUtils.b() + "avgameRes" + File.separator;
    String str2 = AvGameResPreloadManager.a(str1, str3, str2, str4);
    if (TextUtils.isEmpty(str2))
    {
      QLog.e("AVGameVoiceRecog", 1, "loadLocalVoiceModelResByPreload fails to copy preload. preloadSoResPath = " + str1);
      return false;
    }
    localObject1 = AvGameResPreloadManager.a(paramVoiceRecogEngineType, (String)localObject2, (String)localObject1, str4);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.e("AVGameVoiceRecog", 1, "loadLocalVoiceModelResByPreload fails to copy preload. preloadModelResPath = " + paramVoiceRecogEngineType);
      return false;
    }
    try
    {
      System.load(str2);
      paramVoiceRecogEngineType = new File((String)localObject1);
      int i = VoiceRecogEngineFactory.a().a(paramVoiceRecogEngineType.getParent(), paramVoiceRecogEngineType.getName());
      if (i < 0)
      {
        QLog.e("AVGameVoiceRecog", 1, "loadLocalVoiceModelResByPreload failed, ret=" + i);
        return false;
      }
      QLog.d("AVGameVoiceRecog", 1, "loadLocalVoiceModelResByPreload success. soFullFileName = " + str2 + ", modelFullFileName = " + (String)localObject1);
      return true;
    }
    catch (UnsatisfiedLinkError paramVoiceRecogEngineType)
    {
      QLog.e("AVGameVoiceRecog", 1, "loadLocalVoiceModelResByPreload failed. load so failed." + paramVoiceRecogEngineType);
      return false;
    }
    catch (Throwable paramVoiceRecogEngineType)
    {
      QLog.e("AVGameVoiceRecog", 1, "loadLocalVoiceModelResByPreload failed. load so failed." + paramVoiceRecogEngineType);
    }
    return false;
  }
  
  private boolean c(VoiceRecogEngineFactory.VoiceRecogEngineType paramVoiceRecogEngineType)
  {
    String str1;
    if (paramVoiceRecogEngineType == VoiceRecogEngineFactory.VoiceRecogEngineType.WX_ENGINE_TYPE)
    {
      str1 = "AVGameVoiceRecogSo";
      if (paramVoiceRecogEngineType != VoiceRecogEngineFactory.VoiceRecogEngineType.WX_ENGINE_TYPE) {
        break label129;
      }
    }
    String str2;
    String str3;
    label129:
    for (paramVoiceRecogEngineType = "AVGameVoiceRecogModel";; paramVoiceRecogEngineType = "AVGameVoiceRecogAILabModel")
    {
      str2 = ResMgr.a().a(str1);
      str3 = ResMgr.a().a(paramVoiceRecogEngineType);
      QLog.i("AVGameVoiceRecog", 1, "init. soFullFileName = " + str2 + ", modelFullFileName = " + str3 + "Txlib:" + AVSoUtils.b());
      ResInfo localResInfo1 = ResMgr.a().a(str1);
      ResInfo localResInfo2 = ResMgr.a().a(paramVoiceRecogEngineType);
      if ((localResInfo1 != null) && (localResInfo2 != null)) {
        break label135;
      }
      QLog.e("AVGameVoiceRecog", 1, "init failed. soResInfo == null || modelResInfo == null.");
      return false;
      str1 = "AVGameVoiceRecogAILabSo";
      break;
    }
    label135:
    if (!ResMgr.a().b(str1))
    {
      ResMgr.a().a(str1);
      QLog.e("AVGameVoiceRecog", 1, "init failed. so file no exist.");
      return false;
    }
    if (!ResMgr.a().b(paramVoiceRecogEngineType))
    {
      ResMgr.a().a(paramVoiceRecogEngineType);
      QLog.e("AVGameVoiceRecog", 1, "init failed. model file no exist.");
      return false;
    }
    try
    {
      System.load(str2);
      paramVoiceRecogEngineType = new File(str3);
      int i = VoiceRecogEngineFactory.a().a(paramVoiceRecogEngineType.getParent(), paramVoiceRecogEngineType.getName());
      if (i < 0)
      {
        QLog.e("AVGameVoiceRecog", 1, "init failed, ret=" + i);
        return false;
      }
      return true;
    }
    catch (UnsatisfiedLinkError paramVoiceRecogEngineType)
    {
      QLog.e("AVGameVoiceRecog", 1, "init failed. load so failed." + paramVoiceRecogEngineType);
      return false;
    }
    catch (Throwable paramVoiceRecogEngineType)
    {
      QLog.e("AVGameVoiceRecog", 1, "init failed. load so failed." + paramVoiceRecogEngineType);
    }
    return false;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_Boolean) {
        break label21;
      }
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        label21:
        paramInt = VoiceRecogEngineFactory.a().a(paramArrayOfByte, paramInt);
        i = paramInt;
        if (paramInt < 0) {
          return -1;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return -1;
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        AvGameConfBean localAvGameConfBean = (AvGameConfBean)QConfigManager.a().a(642);
        if (localAvGameConfBean != null)
        {
          Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject2 != null) && ((localObject2 instanceof AVGameAppInterface)))
          {
            long l = Long.valueOf(((AVGameAppInterface)localObject2).getCurrentAccountUin()).longValue();
            bool = localAvGameConfBean.a(l);
            VoiceRecogEngineFactory.a(localAvGameConfBean.a(l));
            VoiceRecogEngineFactory.a(localAvGameConfBean.b(l));
            if (!bool)
            {
              QLog.e("AVGameVoiceRecog", 1, "init failed. isUseLocalVoiceRecog = false.");
              bool = false;
              return bool;
            }
            localObject2 = VoiceRecogEngineFactory.a();
            QLog.i("AVGameVoiceRecog", 1, "load " + ((VoiceRecogEngineFactory.VoiceRecogEngineType)localObject2).name());
            if ((!b((VoiceRecogEngineFactory.VoiceRecogEngineType)localObject2)) && (!c((VoiceRecogEngineFactory.VoiceRecogEngineType)localObject2)))
            {
              VoiceRecogEngineFactory.a(VoiceRecogEngineFactory.VoiceRecogEngineType.REMOTE_ENGINE_TYPE);
              QLog.i("AVGameVoiceRecog", 1, "load " + ((VoiceRecogEngineFactory.VoiceRecogEngineType)localObject2).name() + " failed.");
              bool = false;
              continue;
            }
            if (localAvGameConfBean.a() > 0.0F)
            {
              QLog.i("AVGameVoiceRecog", 1, "setSceneWordsThredhold " + localAvGameConfBean.a());
              VoiceRecogEngineFactory.a().a(localAvGameConfBean.a());
            }
            this.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_Boolean = true;
            QLog.i("AVGameVoiceRecog", 1, "init successfully.");
            bool = true;
            continue;
          }
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  public boolean a(String paramString)
  {
    try
    {
      paramString = a(paramString);
      if (VoiceRecogEngineFactory.a().a(paramString) == 0)
      {
        this.jdField_a_of_type_Boolean = true;
        return true;
      }
      QLog.e("AVGameVoiceRecog", 1, "update word failed, word=" + paramString);
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      this.jdField_a_of_type_Boolean = false;
    }
    return false;
  }
  
  public boolean b()
  {
    Object localObject1 = (AvGameConfBean)QConfigManager.a().a(642);
    Object localObject2 = VoiceRecogEngineFactory.VoiceRecogEngineType.REMOTE_ENGINE_TYPE;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject3 != null) && ((localObject3 instanceof AVGameAppInterface))) {
        localObject2 = ((AvGameConfBean)localObject1).a(Long.valueOf(((AVGameAppInterface)localObject3).getCurrentAccountUin()).longValue());
      }
    }
    for (;;)
    {
      if (localObject2 == VoiceRecogEngineFactory.VoiceRecogEngineType.REMOTE_ENGINE_TYPE)
      {
        QLog.e("AVGameVoiceRecog", 1, "isLocalVoiceModelReady remote was config.");
        return false;
      }
      if (a((VoiceRecogEngineFactory.VoiceRecogEngineType)localObject2))
      {
        QLog.d("AVGameVoiceRecog", 1, "isLocalVoiceModelReady isLocalVoiceModelPreloadReady returns true.");
        return true;
      }
      if (localObject2 == VoiceRecogEngineFactory.VoiceRecogEngineType.WX_ENGINE_TYPE)
      {
        localObject1 = "AVGameVoiceRecogSo";
        if (localObject2 != VoiceRecogEngineFactory.VoiceRecogEngineType.WX_ENGINE_TYPE) {
          break label210;
        }
      }
      label210:
      for (localObject2 = "AVGameVoiceRecogModel";; localObject2 = "AVGameVoiceRecogAILabModel")
      {
        localObject3 = ResMgr.a().a((String)localObject1);
        Object localObject4 = ResMgr.a().a((String)localObject2);
        QLog.i("AVGameVoiceRecog", 1, "isLocalVoiceModelReady. soFullFileName = " + (String)localObject3 + ", modelFullFileName = " + (String)localObject4);
        localObject3 = ResMgr.a().a((String)localObject1);
        localObject4 = ResMgr.a().a((String)localObject2);
        if ((localObject3 != null) && (localObject4 != null)) {
          break label216;
        }
        QLog.e("AVGameVoiceRecog", 1, "isLocalVoiceModelReady failed. soResInfo == null || modelResInfo == null.");
        return false;
        localObject1 = "AVGameVoiceRecogAILabSo";
        break;
      }
      label216:
      if (!ResMgr.a().b((String)localObject1))
      {
        QLog.e("AVGameVoiceRecog", 1, "isLocalVoiceModelReady failed. so file no exist.");
        return false;
      }
      if (!ResMgr.a().b((String)localObject2))
      {
        QLog.e("AVGameVoiceRecog", 1, "isLocalVoiceModelReady failed. model file no exist.");
        return false;
      }
      return true;
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = 1;
      try
      {
        int i = VoiceRecogEngineFactory.a().a();
        if (i < 0) {
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Int = 0;
      try
      {
        int i = VoiceRecogEngineFactory.a().b();
        if (i < 0) {
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public boolean e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 367	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +32 -> 37
    //   8: ldc 50
    //   10: iconst_2
    //   11: new 52	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 369
    //   21: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 14	com/tencent/avgame/localvoicerecog/AVGameVoiceRecog:jdField_a_of_type_Int	I
    //   28: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_0
    //   38: getfield 14	com/tencent/avgame/localvoicerecog/AVGameVoiceRecog:jdField_a_of_type_Int	I
    //   41: istore_1
    //   42: iload_1
    //   43: iconst_m1
    //   44: if_icmpeq +30 -> 74
    //   47: invokestatic 197	com/tencent/avgame/localvoicerecog/engine/VoiceRecogEngineFactory:a	()Lcom/tencent/avgame/localvoicerecog/engine/IVoiceRecogEngine;
    //   50: invokeinterface 371 1 0
    //   55: ifne +19 -> 74
    //   58: aload_0
    //   59: iconst_m1
    //   60: putfield 14	com/tencent/avgame/localvoicerecog/AVGameVoiceRecog:jdField_a_of_type_Int	I
    //   63: iconst_1
    //   64: istore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: iload_2
    //   68: ireturn
    //   69: astore_3
    //   70: aload_3
    //   71: invokevirtual 372	java/lang/Exception:printStackTrace	()V
    //   74: iconst_0
    //   75: istore_2
    //   76: goto -11 -> 65
    //   79: astore_3
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_3
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	AVGameVoiceRecog
    //   41	4	1	i	int
    //   64	12	2	bool	boolean
    //   69	2	3	localException	java.lang.Exception
    //   79	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   47	63	69	java/lang/Exception
    //   2	37	79	finally
    //   37	42	79	finally
    //   47	63	79	finally
    //   70	74	79	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.localvoicerecog.AVGameVoiceRecog
 * JD-Core Version:    0.7.0.1
 */