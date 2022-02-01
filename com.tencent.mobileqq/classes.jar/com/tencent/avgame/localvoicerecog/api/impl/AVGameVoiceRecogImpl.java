package com.tencent.avgame.localvoicerecog.api.impl;

import android.text.TextUtils;
import com.tencent.av.so.ResInfo;
import com.tencent.av.so.ResMgr;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.avgame.gamelogic.gameres.IAvGameResPreloadManager.ConfInfo;
import com.tencent.avgame.gamelogic.gameres.IAvGameResPreloadManager.PathInfo;
import com.tencent.avgame.gameres.AvGameResPreloadManager;
import com.tencent.avgame.localvoicerecog.api.IAVGameVoiceRecog;
import com.tencent.avgame.localvoicerecog.engine.IVoiceRecogEngine;
import com.tencent.avgame.localvoicerecog.engine.VoiceRecogEngineFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AVGameVoiceRecogImpl
  implements IAVGameVoiceRecog
{
  public static final String TAG = "AVGameVoiceRecogImpl";
  private static volatile AVGameVoiceRecogImpl sInstance;
  private int mGrammarState = -1;
  private boolean mUpdateWordSuc = true;
  
  public static AVGameVoiceRecogImpl getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new AVGameVoiceRecogImpl();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private static String getSimplifiedPwd(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("[,，。、 ]", "");
  }
  
  private boolean isLocalVoiceModelPreloadReady(int paramInt)
  {
    Object localObject1 = AvGameResPreloadManager.a();
    Object localObject3 = AvGameResPreloadManager.b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("isLocalVoiceModelPreloadReady getinfo fro sp. pathinfo:");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append("confinfo:");
    ((StringBuilder)localObject2).append(localObject3);
    QLog.d("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject2).toString());
    String str1;
    String str2;
    String str3;
    if (paramInt == 2)
    {
      QLog.d("AVGameVoiceRecogImpl", 1, "isLocalVoiceModelPreloadReady use wx type");
      localObject2 = ((IAvGameResPreloadManager.PathInfo)localObject1).b;
      str1 = ((IAvGameResPreloadManager.ConfInfo)localObject3).d;
      str2 = ((IAvGameResPreloadManager.ConfInfo)localObject3).e;
      localObject1 = ((IAvGameResPreloadManager.PathInfo)localObject1).c;
      str3 = ((IAvGameResPreloadManager.ConfInfo)localObject3).g;
      localObject3 = ((IAvGameResPreloadManager.ConfInfo)localObject3).h;
    }
    else
    {
      if (paramInt != 3) {
        break label276;
      }
      QLog.d("AVGameVoiceRecogImpl", 1, "isLocalVoiceModelPreloadReady use ailab type");
      localObject2 = ((IAvGameResPreloadManager.PathInfo)localObject1).d;
      str1 = ((IAvGameResPreloadManager.ConfInfo)localObject3).j;
      str2 = ((IAvGameResPreloadManager.ConfInfo)localObject3).k;
      localObject1 = ((IAvGameResPreloadManager.PathInfo)localObject1).e;
      str3 = ((IAvGameResPreloadManager.ConfInfo)localObject3).m;
      localObject3 = ((IAvGameResPreloadManager.ConfInfo)localObject3).n;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (FileUtils.fileExists((String)localObject2)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (FileUtils.fileExists((String)localObject1)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
      return true;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("isLocalVoiceModelPreloadReady fails by path not ready. soFullFileName = ");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(", modelFullFileName = ");
    ((StringBuilder)localObject3).append((String)localObject1);
    QLog.w("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject3).toString());
    return false;
    label276:
    QLog.w("AVGameVoiceRecogImpl", 1, "isLocalVoiceModelPreloadReady use remote type");
    return false;
  }
  
  private boolean loadLocalVoiceModelRes(int paramInt)
  {
    Object localObject1;
    if (paramInt == 2) {
      localObject1 = "AVGameVoiceRecogSo";
    } else {
      localObject1 = "AVGameVoiceRecogAILabSo";
    }
    Object localObject2;
    if (paramInt == 2) {
      localObject2 = "AVGameVoiceRecogModel";
    } else {
      localObject2 = "AVGameVoiceRecogAILabModel";
    }
    String str1 = ResMgr.a().c((String)localObject1);
    String str2 = ResMgr.a().c((String)localObject2);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("init. soFullFileName = ");
    ((StringBuilder)localObject3).append(str1);
    ((StringBuilder)localObject3).append(", modelFullFileName = ");
    ((StringBuilder)localObject3).append(str2);
    ((StringBuilder)localObject3).append("Txlib:");
    ((StringBuilder)localObject3).append(AVSoUtils.b());
    QLog.i("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject3).toString());
    localObject3 = ResMgr.a().f((String)localObject1);
    ResInfo localResInfo = ResMgr.a().f((String)localObject2);
    if ((localObject3 != null) && (localResInfo != null))
    {
      if (!ResMgr.a().g((String)localObject1))
      {
        ResMgr.a().a((String)localObject1);
        QLog.e("AVGameVoiceRecogImpl", 1, "init failed. so file no exist.");
        return false;
      }
      if (!ResMgr.a().g((String)localObject2))
      {
        ResMgr.a().a((String)localObject2);
        QLog.e("AVGameVoiceRecogImpl", 1, "init failed. model file no exist.");
        return false;
      }
      try
      {
        System.load(str1);
        localObject1 = new File(str2);
        paramInt = VoiceRecogEngineFactory.b().a(((File)localObject1).getParent(), ((File)localObject1).getName());
        if (paramInt < 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("init failed, ret=");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.e("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject1).toString());
          return false;
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("init failed. load so failed.");
        ((StringBuilder)localObject2).append(localThrowable);
        QLog.e("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject2).toString());
        return false;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("init failed. load so failed.");
        ((StringBuilder)localObject2).append(localUnsatisfiedLinkError);
        QLog.e("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject2).toString());
        return false;
      }
    }
    QLog.e("AVGameVoiceRecogImpl", 1, "init failed. soResInfo == null || modelResInfo == null.");
    return false;
  }
  
  private boolean loadLocalVoiceModelResByPreload(int paramInt)
  {
    MobileQQ.sMobileQQ.getSharedPreferences("av_game_sp", 4);
    Object localObject1 = AvGameResPreloadManager.a();
    Object localObject3 = AvGameResPreloadManager.b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("loadLocalVoiceModelResByPreload getinfo fro sp. pathinfo:");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append("confinfo:");
    ((StringBuilder)localObject2).append(localObject3);
    QLog.d("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject2).toString());
    String str2;
    String str3;
    String str1;
    if (paramInt == 2)
    {
      QLog.d("AVGameVoiceRecogImpl", 1, "loadLocalVoiceModelResByPreload use wx type");
      localObject2 = ((IAvGameResPreloadManager.PathInfo)localObject1).b;
      str2 = ((IAvGameResPreloadManager.ConfInfo)localObject3).d;
      str3 = ((IAvGameResPreloadManager.ConfInfo)localObject3).e;
      localObject1 = ((IAvGameResPreloadManager.PathInfo)localObject1).c;
      str1 = ((IAvGameResPreloadManager.ConfInfo)localObject3).g;
      localObject3 = ((IAvGameResPreloadManager.ConfInfo)localObject3).h;
    }
    else
    {
      if (paramInt != 3) {
        break label666;
      }
      QLog.d("AVGameVoiceRecogImpl", 1, "loadLocalVoiceModelResByPreload use ailab type");
      localObject2 = ((IAvGameResPreloadManager.PathInfo)localObject1).d;
      str2 = ((IAvGameResPreloadManager.ConfInfo)localObject3).j;
      str3 = ((IAvGameResPreloadManager.ConfInfo)localObject3).k;
      localObject1 = ((IAvGameResPreloadManager.PathInfo)localObject1).e;
      str1 = ((IAvGameResPreloadManager.ConfInfo)localObject3).m;
      localObject3 = ((IAvGameResPreloadManager.ConfInfo)localObject3).n;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (FileUtils.fileExists((String)localObject2)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (FileUtils.fileExists((String)localObject1)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
    {
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("loadLocalVoiceModelResByPreload. soFullFileName = ");
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(", modelFullFileName = ");
      ((StringBuilder)localObject4).append((String)localObject1);
      QLog.d("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject4).toString());
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(AVSoUtils.b());
      ((StringBuilder)localObject4).append("avgameRes");
      ((StringBuilder)localObject4).append(File.separator);
      localObject4 = ((StringBuilder)localObject4).toString();
      str2 = AvGameResPreloadManager.a((String)localObject2, str2, str3, (String)localObject4);
      if (TextUtils.isEmpty(str2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("loadLocalVoiceModelResByPreload fails to copy preload. preloadSoResPath = ");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.e("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject1).toString());
        return false;
      }
      localObject2 = AvGameResPreloadManager.a((String)localObject1, str1, (String)localObject3, (String)localObject4);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadLocalVoiceModelResByPreload fails to copy preload. preloadModelResPath = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.e("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject2).toString());
        return false;
      }
      try
      {
        System.load(str2);
        localObject1 = new File((String)localObject2);
        paramInt = VoiceRecogEngineFactory.b().a(((File)localObject1).getParent(), ((File)localObject1).getName());
        if (paramInt < 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("loadLocalVoiceModelResByPreload failed, ret=");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.e("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject1).toString());
          return false;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("loadLocalVoiceModelResByPreload success. soFullFileName = ");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append(", modelFullFileName = ");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject1).toString());
        return true;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadLocalVoiceModelResByPreload failed. load so failed.");
        ((StringBuilder)localObject2).append(localThrowable);
        QLog.e("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject2).toString());
        return false;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadLocalVoiceModelResByPreload failed. load so failed.");
        ((StringBuilder)localObject2).append(localUnsatisfiedLinkError);
        QLog.e("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject2).toString());
        return false;
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("loadLocalVoiceModelResByPreload fails by path not ready. soFullFileName = ");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(", modelFullFileName = ");
    ((StringBuilder)localObject3).append(localUnsatisfiedLinkError);
    QLog.w("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject3).toString());
    return false;
    label666:
    QLog.w("AVGameVoiceRecogImpl", 1, "loadLocalVoiceModelResByPreload use remote type");
    return false;
  }
  
  public boolean begin()
  {
    if (this.mGrammarState == 0)
    {
      this.mGrammarState = 1;
      try
      {
        int i = VoiceRecogEngineFactory.b().b();
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
  
  public boolean destroy()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("destroy. mGrammarState = ");
        localStringBuilder.append(this.mGrammarState);
        QLog.d("AVGameVoiceRecogImpl", 2, localStringBuilder.toString());
      }
      int i = this.mGrammarState;
      if (i != -1) {
        try
        {
          if (VoiceRecogEngineFactory.b().e() == 0)
          {
            this.mGrammarState = -1;
            return true;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      return false;
    }
    finally {}
  }
  
  public boolean end()
  {
    if (this.mGrammarState == 1)
    {
      this.mGrammarState = 0;
      try
      {
        int i = VoiceRecogEngineFactory.b().c();
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
  
  public float getResultCfd()
  {
    return 1.0F;
  }
  
  public boolean init()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = AvGameConfigUtil.a();
        Object localObject3 = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((localObject3 != null) && (MobileQQ.sMobileQQ.getQQProcessName().endsWith("avgame")))
        {
          long l = Long.valueOf(((AppRuntime)localObject3).getCurrentAccountUin()).longValue();
          bool = ((AvGameConfBean)localObject1).a(l);
          VoiceRecogEngineFactory.a(((AvGameConfBean)localObject1).b(l));
          VoiceRecogEngineFactory.a(((AvGameConfBean)localObject1).c(l));
          if (!bool)
          {
            QLog.e("AVGameVoiceRecogImpl", 1, "init failed. isUseLocalVoiceRecog = false.");
            return false;
          }
          int i = VoiceRecogEngineFactory.a();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("load ");
          ((StringBuilder)localObject3).append(i);
          QLog.i("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject3).toString());
          if ((!loadLocalVoiceModelResByPreload(i)) && (!loadLocalVoiceModelRes(i)))
          {
            VoiceRecogEngineFactory.a(1);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("load ");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append(" failed.");
            QLog.i("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject1).toString());
            return false;
          }
          if (((AvGameConfBean)localObject1).l() > 0.0F)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("setSceneWordsThredhold ");
            ((StringBuilder)localObject3).append(((AvGameConfBean)localObject1).l());
            QLog.i("AVGameVoiceRecogImpl", 1, ((StringBuilder)localObject3).toString());
            VoiceRecogEngineFactory.b().a(((AvGameConfBean)localObject1).l());
          }
          this.mGrammarState = 0;
          this.mUpdateWordSuc = true;
          QLog.i("AVGameVoiceRecogImpl", 1, "init successfully.");
          return true;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public boolean isLocalVoiceModelReady()
  {
    Object localObject1 = AvGameConfigUtil.a();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = MobileQQ.sMobileQQ.peekAppRuntime();
      if ((localObject2 != null) && (MobileQQ.sMobileQQ.getQQProcessName().equals("avgame")))
      {
        i = ((AvGameConfBean)localObject1).b(Long.valueOf(((AppRuntime)localObject2).getCurrentAccountUin()).longValue());
        break label54;
      }
    }
    int i = 1;
    label54:
    if (i == 1)
    {
      QLog.e("AVGameVoiceRecogImpl", 1, "isLocalVoiceModelReady remote was config.");
      return false;
    }
    if (isLocalVoiceModelPreloadReady(i))
    {
      QLog.d("AVGameVoiceRecogImpl", 1, "isLocalVoiceModelReady isLocalVoiceModelPreloadReady returns true.");
      return true;
    }
    if (i == 2) {
      localObject1 = "AVGameVoiceRecogSo";
    } else {
      localObject1 = "AVGameVoiceRecogAILabSo";
    }
    if (i == 2) {
      localObject2 = "AVGameVoiceRecogModel";
    } else {
      localObject2 = "AVGameVoiceRecogAILabModel";
    }
    Object localObject3 = ResMgr.a().c((String)localObject1);
    Object localObject4 = ResMgr.a().c((String)localObject2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isLocalVoiceModelReady. soFullFileName = ");
    localStringBuilder.append((String)localObject3);
    localStringBuilder.append(", modelFullFileName = ");
    localStringBuilder.append((String)localObject4);
    QLog.i("AVGameVoiceRecogImpl", 1, localStringBuilder.toString());
    localObject3 = ResMgr.a().f((String)localObject1);
    localObject4 = ResMgr.a().f((String)localObject2);
    if ((localObject3 != null) && (localObject4 != null))
    {
      if (!ResMgr.a().g((String)localObject1))
      {
        QLog.e("AVGameVoiceRecogImpl", 1, "isLocalVoiceModelReady failed. so file no exist.");
        return false;
      }
      if (!ResMgr.a().g((String)localObject2))
      {
        QLog.e("AVGameVoiceRecogImpl", 1, "isLocalVoiceModelReady failed. model file no exist.");
        return false;
      }
      return true;
    }
    QLog.e("AVGameVoiceRecogImpl", 1, "isLocalVoiceModelReady failed. soResInfo == null || modelResInfo == null.");
    return false;
  }
  
  public int recognize(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.mGrammarState == 1)
    {
      if (!this.mUpdateWordSuc) {
        return -1;
      }
      try
      {
        int i = VoiceRecogEngineFactory.b().a(paramArrayOfByte, paramInt);
        paramInt = i;
        if (i >= 0) {
          return paramInt;
        }
        return -1;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return -1;
      }
    }
    else
    {
      paramInt = 0;
    }
    return paramInt;
  }
  
  public boolean update(String paramString)
  {
    try
    {
      paramString = getSimplifiedPwd(paramString);
      if (VoiceRecogEngineFactory.b().a(paramString) == 0)
      {
        this.mUpdateWordSuc = true;
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update word failed, word=");
      localStringBuilder.append(paramString);
      QLog.e("AVGameVoiceRecogImpl", 1, localStringBuilder.toString());
      this.mUpdateWordSuc = false;
      return false;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      this.mUpdateWordSuc = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.localvoicerecog.api.impl.AVGameVoiceRecogImpl
 * JD-Core Version:    0.7.0.1
 */