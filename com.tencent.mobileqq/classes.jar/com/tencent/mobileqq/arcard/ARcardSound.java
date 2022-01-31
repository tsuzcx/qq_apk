package com.tencent.mobileqq.arcard;

import aagk;
import aagl;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ARcardSound
  implements SoundPool.OnLoadCompleteListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  private SoundPool jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap(10);
  private boolean jdField_a_of_type_Boolean;
  
  public ARcardSound()
  {
    this.jdField_a_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(BaseApplicationImpl.getContext(), null);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(true);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
    }
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(BaseApplicationImpl.getContext(), paramString, 0L, 0L);
    }
  }
  
  public void OnDownloadCallback(String paramString) {}
  
  public void a()
  {
    ThreadManager.post(new aagk(this), 8, null, true);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("Sound", 2, "playBackgroundMusic resPath is empty!");
      }
    }
    do
    {
      return;
      if (new File(paramString).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Sound", 2, "playBackgroundMusic file not exist");
    return;
    b(paramString);
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d("Sound", 2, "TVK_IMediaPlayer.onCompletion");
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    QLog.d("Sound", 2, String.format("TVK_IMediaPlayer.onError model=%s what=%s position=%s detailInfo=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString }));
    return false;
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Sound", 2, "onLoadComplete sampleId:" + paramInt1 + ", status:" + paramInt2);
    }
    if (paramInt2 == 0) {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localaagl = (aagl)((Map.Entry)localIterator.next()).getValue();
            if ((localaagl != null) && (localaagl.b == paramInt1))
            {
              if (localaagl.a())
              {
                localaagl.c = 2;
                return;
              }
              if (localaagl.b()) {
                if (!this.jdField_a_of_type_Boolean)
                {
                  localaagl.a = paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, -1, 1.0F);
                  return;
                }
              }
            }
          }
        }
      }
      catch (Exception paramSoundPool)
      {
        aagl localaagl;
        paramSoundPool.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.e("Sound", 2, "onLoadComplete exception", paramSoundPool);
          return;
          localaagl.c = 4;
        }
      }
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d("Sound", 2, "TVK_IMediaPlayer.onVideoPrepared");
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.updatePlayerVideoView(null);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      return;
    }
    catch (Exception paramTVK_IMediaPlayer)
    {
      QLog.d("Sound", 1, "TVK_IMediaPlayer.onVideoPrepared fail.", paramTVK_IMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARcardSound
 * JD-Core Version:    0.7.0.1
 */