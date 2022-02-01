package com.tencent.liteav.audio;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.d;
import com.tencent.liteav.basic.util.h;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TXCSoundEffectPlayer
  implements TXAudioEffectManager.TXMusicPlayObserver
{
  private static final String TAG = "AudioCenter:TXCSoundEffectPlayer";
  private static WeakReference<c> mWeakSoundEffectListener;
  private List<Integer> mShortEffectorIDList = new ArrayList();
  
  static
  {
    h.f();
  }
  
  private String checkIfAssetsFile(String paramString)
  {
    String str2 = paramString;
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (TXCCommonUtil.getAppContext() == null) {
        return paramString;
      }
      if (!paramString.startsWith("/assets/")) {
        return paramString;
      }
      String str3 = paramString.substring(8);
      long l;
      String str1;
      try
      {
        l = TXCCommonUtil.getAppContext().getAssets().openFd(str3).getLength();
      }
      catch (Exception localException)
      {
        str1 = paramString;
      }
      try
      {
        Object localObject2 = new StringBuilder();
        str1 = paramString;
        ((StringBuilder)localObject2).append("playAudioEffect openFd error ");
        str1 = paramString;
        ((StringBuilder)localObject2).append(localException.toString());
        str1 = paramString;
        TXCLog.e("AudioCenter:TXCSoundEffectPlayer", ((StringBuilder)localObject2).toString());
        l = 0L;
        str1 = paramString;
        localObject1 = getEffectCachePath();
        str1 = paramString;
        localObject2 = new File((String)localObject1);
        str1 = paramString;
        if (!((File)localObject2).exists())
        {
          str1 = paramString;
          ((File)localObject2).mkdirs();
        }
        else
        {
          str1 = paramString;
          if (((File)localObject2).isFile())
          {
            str1 = paramString;
            ((File)localObject2).delete();
            str1 = paramString;
            ((File)localObject2).mkdirs();
          }
        }
        str1 = paramString;
        int i = str3.lastIndexOf(File.separatorChar);
        if (i != -1)
        {
          str1 = paramString;
          localObject2 = new StringBuilder();
          str1 = paramString;
          ((StringBuilder)localObject2).append((String)localObject1);
          str1 = paramString;
          ((StringBuilder)localObject2).append(File.separator);
          str1 = paramString;
          ((StringBuilder)localObject2).append(l);
          str1 = paramString;
          ((StringBuilder)localObject2).append("_");
          str1 = paramString;
          ((StringBuilder)localObject2).append(str3.substring(i + 1));
          str1 = paramString;
          paramString = ((StringBuilder)localObject2).toString();
        }
        else
        {
          str1 = paramString;
          localObject2 = new StringBuilder();
          str1 = paramString;
          ((StringBuilder)localObject2).append((String)localObject1);
          str1 = paramString;
          ((StringBuilder)localObject2).append(File.separator);
          str1 = paramString;
          ((StringBuilder)localObject2).append(l);
          str1 = paramString;
          ((StringBuilder)localObject2).append("_");
          str1 = paramString;
          ((StringBuilder)localObject2).append(str3);
          str1 = paramString;
          paramString = ((StringBuilder)localObject2).toString();
        }
        str1 = paramString;
        localObject1 = paramString;
        if (!d.a(paramString))
        {
          str1 = paramString;
          d.a(TXCCommonUtil.getAppContext(), str3, paramString);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("playAudioEffect error ");
        ((StringBuilder)localObject1).append(paramString.toString());
        TXCLog.e("AudioCenter:TXCSoundEffectPlayer", ((StringBuilder)localObject1).toString());
        localObject1 = str1;
      }
    }
    return localObject1;
  }
  
  private String getEffectCachePath()
  {
    if (TXCCommonUtil.getAppContext() == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TXCCommonUtil.getAppContext().getCacheDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("liteav_effect");
    return localStringBuilder.toString();
  }
  
  public static TXCSoundEffectPlayer getInstance()
  {
    return TXCSoundEffectPlayer.a.a();
  }
  
  public void clearCache()
  {
    if (TXCCommonUtil.getAppContext() == null) {
      return;
    }
    try
    {
      Object localObject = new File(getEffectCachePath());
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()) && (d.a((File)localObject) > 52428800))
      {
        localObject = ((File)localObject).listFiles();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localObject[i].delete();
          i += 1;
        }
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearCache error ");
      localStringBuilder.append(localException.toString());
      TXCLog.w("AudioCenter:TXCSoundEffectPlayer", localStringBuilder.toString());
    }
  }
  
  public void onComplete(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onMusicPlayFinish -> effect id = ");
    ((StringBuilder)localObject).append(paramInt1);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", ((StringBuilder)localObject).toString());
    localObject = mWeakSoundEffectListener;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      ((c)mWeakSoundEffectListener.get()).onEffectPlayFinish(paramInt1);
    }
  }
  
  public void onPlayProgress(int paramInt, long paramLong1, long paramLong2) {}
  
  public void onStart(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onStart -> effect id = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", errCode = ");
    ((StringBuilder)localObject).append(paramInt2);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", ((StringBuilder)localObject).toString());
    localObject = mWeakSoundEffectListener;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      ((c)mWeakSoundEffectListener.get()).onEffectPlayStart(paramInt1, paramInt2);
    }
  }
  
  public void pauseEffectWithId(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pauseEffectWithId -> effect id = ");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", localStringBuilder.toString());
    TXAudioEffectManagerImpl.getCacheInstance().pausePlayMusic(paramInt);
  }
  
  public boolean playEffectWithId(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playEffectWithId -> effect id = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", path = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", loop = ");
    localStringBuilder.append(paramInt2);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", localStringBuilder.toString());
    paramString = new TXAudioEffectManager.AudioMusicParam(paramInt1, checkIfAssetsFile(paramString));
    paramString.publish = paramBoolean;
    paramString.loopCount = paramInt2;
    paramString.isShortFile = true;
    paramBoolean = TXAudioEffectManagerImpl.getCacheInstance().startPlayMusic(paramString);
    TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(paramInt1, this);
    this.mShortEffectorIDList.add(Integer.valueOf(paramInt1));
    paramString = new StringBuilder();
    paramString.append("playEffectWithId ->effect id = ");
    paramString.append(paramInt1);
    paramString.append(", startPlayMusic result = ");
    paramString.append(paramBoolean);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", paramString.toString());
    return paramBoolean;
  }
  
  public void resumeEffectWithId(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumeEffectWithId -> effect id = ");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", localStringBuilder.toString());
    TXAudioEffectManagerImpl.getCacheInstance().resumePlayMusic(paramInt);
  }
  
  public void setEffectsVolume(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setEffectsVolume -> volume = ");
    ((StringBuilder)localObject).append(paramFloat);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", ((StringBuilder)localObject).toString());
    localObject = this.mShortEffectorIDList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      int i = ((Integer)((Iterator)localObject).next()).intValue();
      TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(i, (int)(100.0F * paramFloat));
    }
  }
  
  public void setSoundEffectListener(c paramc)
  {
    if (paramc == null)
    {
      mWeakSoundEffectListener = null;
      return;
    }
    mWeakSoundEffectListener = new WeakReference(paramc);
  }
  
  public void setVolumeOfEffect(int paramInt, float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVolumeOfEffect -> effect id = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", volume = ");
    localStringBuilder.append(paramFloat);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", localStringBuilder.toString());
    TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(paramInt, (int)(paramFloat * 100.0F));
  }
  
  public void stopAllEffect()
  {
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "stopAllEffect -> start");
    Iterator localIterator = this.mShortEffectorIDList.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      TXAudioEffectManagerImpl.getCacheInstance().stopPlayMusic(i);
    }
    this.mShortEffectorIDList.clear();
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "stopAllEffect -> finish");
  }
  
  public void stopEffectWithId(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopEffectWithId -> effect id = ");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", localStringBuilder.toString());
    TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(paramInt, null);
    TXAudioEffectManagerImpl.getCacheInstance().stopPlayMusic(paramInt);
    paramInt = this.mShortEffectorIDList.indexOf(Integer.valueOf(paramInt));
    if (paramInt >= 0) {
      this.mShortEffectorIDList.remove(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCSoundEffectPlayer
 * JD-Core Version:    0.7.0.1
 */