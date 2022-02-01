package com.tencent.mobileqq.apollo.game.process.audio;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameNativeMethodHandler;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameNativeMethodHandler.NativeObject;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class CmGameAudioPlayer
  implements CmGameNativeMethodHandler.NativeObject
{
  public static List<CmGameAudioPlayer> a;
  private int jdField_a_of_type_Int;
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new CmGameAudioPlayer.6(this);
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private CmGameSoudPoolPlayer jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 0;
  
  static
  {
    jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  }
  
  public CmGameAudioPlayer(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    CmGameLauncher localCmGameLauncher = CmGameUtil.a(paramInt2);
    if (localCmGameLauncher != null) {
      localCmGameLauncher.b(0);
    }
    if ("effect".equals(paramString))
    {
      if (localCmGameLauncher != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer = new CmGameSoudPoolPlayer(paramInt2);
      } else {
        QLog.e("[cmshow]CmGameAudioPlayer", 1, "can not create pool");
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      a(1);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(new CmGameAudioPlayer.1(this));
    }
    paramString = jdField_a_of_type_JavaUtilList;
    if (paramString != null) {
      try
      {
        jdField_a_of_type_JavaUtilList.add(this);
      }
      finally {}
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
  }
  
  private void a(CmGameNativeMethodHandler paramCmGameNativeMethodHandler, JSONObject paramJSONObject)
  {
    if (paramCmGameNativeMethodHandler != null) {
      paramCmGameNativeMethodHandler.a(paramJSONObject);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    AudioManager localAudioManager = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localAudioManager == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = localAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
    } else {
      i = localAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmGameAudioPlayer", 2, new Object[] { "[execAudioFocus], requestFocus:", Boolean.valueOf(paramBoolean), ",ret:", Integer.valueOf(i) });
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(paramInt);
  }
  
  public String a()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
      if (localMediaPlayer != null) {
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
          this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        }
        catch (Throwable localThrowable1)
        {
          QLog.e("[cmshow]CmGameAudioPlayer", 1, localThrowable1, new Object[0]);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer.c();
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer = null;
        return null;
      }
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("[cmshow]CmGameAudioPlayer", 1, "audio destroy falied", localThrowable2);
    }
    return null;
  }
  
  public JSONObject a(float paramFloat1, float paramFloat2, JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (a() != 9)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setVolume(paramFloat1, paramFloat2);
        return paramJSONObject;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" volume in  state ");
      localStringBuilder.append(a());
      QLog.e("[cmshow]CmGameAudioPlayer", 1, localStringBuilder.toString());
    }
    return paramJSONObject;
  }
  
  public JSONObject a(int paramInt, JSONObject paramJSONObject, CmGameNativeMethodHandler paramCmGameNativeMethodHandler)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      int i = a();
      if ((i != 3) && (i != 5) && (i != 7) && (i != 10))
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(" seek in  state ");
        paramJSONObject.append(i);
        QLog.e("[cmshow]CmGameAudioPlayer", 1, paramJSONObject.toString());
      }
      else
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnSeekCompleteListener(new CmGameAudioPlayer.2(this, paramJSONObject, paramCmGameNativeMethodHandler));
        this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(paramInt);
      }
    }
    return null;
  }
  
  public JSONObject a(CmGameNativeMethodHandler arg1, JSONObject paramJSONObject)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer.c();
      }
      a(8);
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer = null;
      if (??? != null) {
        ???.b(this);
      }
      if (jdField_a_of_type_JavaUtilList != null) {
        synchronized (jdField_a_of_type_JavaUtilList)
        {
          jdField_a_of_type_JavaUtilList.remove(this);
          return paramJSONObject;
        }
      }
      return paramJSONObject;
    }
    catch (Throwable ???)
    {
      QLog.e("[cmshow]CmGameAudioPlayer", 1, "destroy failed", ???);
    }
  }
  
  public JSONObject a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          if (paramJSONObject.has("duration")) {
            paramJSONObject.put("duration", this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration());
          }
          if (paramJSONObject.has("currentTime")) {
            paramJSONObject.put("currentTime", this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition());
          }
          if (paramJSONObject.has("paused"))
          {
            if (a() != 7) {
              break label104;
            }
            bool = true;
            paramJSONObject.put("paused", bool);
            return paramJSONObject;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[cmshow]CmGameAudioPlayer", 1, localThrowable, new Object[0]);
      }
      return paramJSONObject;
      label104:
      boolean bool = false;
    }
  }
  
  public JSONObject a(JSONObject paramJSONObject, CmGameNativeMethodHandler paramCmGameNativeMethodHandler)
  {
    try
    {
      if (paramJSONObject.has("loop")) {
        a(paramJSONObject.optBoolean("loop"), paramJSONObject);
      }
      if (paramJSONObject.has("autoPlay")) {
        b(paramJSONObject.optBoolean("autoPlay"), paramJSONObject);
      }
      if (paramJSONObject.has("volume")) {
        a((float)paramJSONObject.optDouble("volume"), (float)paramJSONObject.optDouble("volume"), paramJSONObject);
      }
      if (paramJSONObject.has("muted")) {
        a(paramJSONObject.optBoolean("muted"), (float)paramJSONObject.optDouble("volume"), (float)paramJSONObject.optDouble("volume"), paramJSONObject);
      }
      if (paramJSONObject.has("currentTime"))
      {
        d(paramJSONObject, paramCmGameNativeMethodHandler);
        return paramJSONObject;
      }
    }
    catch (Throwable paramCmGameNativeMethodHandler)
    {
      QLog.e("[cmshow]CmGameAudioPlayer", 1, paramCmGameNativeMethodHandler, new Object[0]);
    }
    return paramJSONObject;
  }
  
  public JSONObject a(boolean paramBoolean, float paramFloat1, float paramFloat2, JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (paramBoolean) {
        return a(0.0F, 0.0F, paramJSONObject);
      }
      return a(paramFloat1, paramFloat2, paramJSONObject);
    }
    CmGameSoudPoolPlayer localCmGameSoudPoolPlayer = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer;
    if (localCmGameSoudPoolPlayer != null)
    {
      int i;
      if ((!paramBoolean) && ((Float.compare(paramFloat1, 0.0F) != 0) || (Float.compare(paramFloat2, 0.0F) != 0))) {
        i = 1;
      } else {
        i = 0;
      }
      localCmGameSoudPoolPlayer.a(i, BaseActivity.sTopActivity.getAppInterface());
    }
    return paramJSONObject;
  }
  
  public JSONObject a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      int i = a();
      if ((i != 1) && (i != 2) && (i != 6) && (i != 3) && (i != 5) && (i != 7) && (i != 10))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" loop in  state ");
        localStringBuilder.append(i);
        QLog.e("[cmshow]CmGameAudioPlayer", 1, localStringBuilder.toString());
        return paramJSONObject;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
    return paramJSONObject;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public JSONObject b(CmGameNativeMethodHandler paramCmGameNativeMethodHandler, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if (paramJSONObject.optInt("N_R_OBJ") == this.jdField_a_of_type_Int)
        {
          String str = paramJSONObject.optString("N_R_CMD");
          if ("cs.audio_play.local".equals(str)) {
            return b(paramJSONObject, paramCmGameNativeMethodHandler);
          }
          if ("cs.audio_autoplay.local".equals(str)) {
            return b(paramJSONObject.optBoolean("autoplay"), paramJSONObject);
          }
          if ("cs.audio_load.local".equals(str)) {
            return c(paramJSONObject, paramCmGameNativeMethodHandler);
          }
          if ("cs.audio_loop.local".equals(str)) {
            return a(paramJSONObject.optBoolean("loop"), paramJSONObject);
          }
          boolean bool = "cs.audio_muted.local".equals(str);
          if (bool) {
            return a(paramJSONObject.optBoolean("muted"), (float)paramJSONObject.optDouble("leftVolume"), (float)paramJSONObject.optDouble("rightVolume"), paramJSONObject);
          }
          if ("cs.audio_pause.local".equals(str)) {
            return b(paramJSONObject);
          }
          if ("cs.audio_seek.local".equals(str)) {
            return a(paramJSONObject.optInt("seek"), paramJSONObject, paramCmGameNativeMethodHandler);
          }
          if ("cs.audio_preload.local".equals(str)) {
            return c(paramJSONObject.optBoolean("preloaded"), paramJSONObject);
          }
          if ("cs.audio_volume.local".equals(str)) {
            return a((float)paramJSONObject.optDouble("leftVolume"), (float)paramJSONObject.optDouble("rightVolume"), paramJSONObject);
          }
          if ("cs.audio_destroy.local".equals(str)) {
            return a(paramCmGameNativeMethodHandler, paramJSONObject);
          }
          if ("cs.audio_onend.local".equals(str)) {
            return e(paramJSONObject, paramCmGameNativeMethodHandler);
          }
          if ("cs.audio_ontimeupdate.local".equals(str)) {
            return d(paramJSONObject);
          }
          if ("cs.audio_duration.local".equals(str)) {
            return c(paramJSONObject);
          }
          if ("cs.audio_effect_resume.local".equals(str)) {
            return f(paramJSONObject);
          }
          if ("cs.audio_stop.local".equals(str)) {
            return e(paramJSONObject);
          }
          if ("cs.audio_attribute_get.local".equals(str)) {
            return a(paramJSONObject);
          }
          if ("cs.audio_attribute_set.local".equals(str))
          {
            paramCmGameNativeMethodHandler = a(paramJSONObject, paramCmGameNativeMethodHandler);
            return paramCmGameNativeMethodHandler;
          }
        }
      }
      catch (Throwable paramCmGameNativeMethodHandler)
      {
        QLog.e("[cmshow]CmGameAudioPlayer", 1, "audio failed", paramCmGameNativeMethodHandler);
      }
    }
    return null;
  }
  
  public JSONObject b(JSONObject paramJSONObject)
  {
    try
    {
      int i;
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        i = a();
        if ((i != 5) && (i != 7) && (i != 10))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" pause in  state ");
            localStringBuilder.append(a());
            QLog.e("[cmshow]CmGameAudioPlayer", 1, localStringBuilder.toString());
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
          a(7);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer != null)
      {
        i = paramJSONObject.optInt("id");
        if (paramJSONObject.optBoolean("auto", true)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer.a();
        } else {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer.a(i, null);
        }
      }
      a(false);
      return paramJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]CmGameAudioPlayer", 1, "pause failed", localThrowable);
    }
    return paramJSONObject;
  }
  
  public JSONObject b(JSONObject paramJSONObject, CmGameNativeMethodHandler paramCmGameNativeMethodHandler)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      int i = a();
      if ((i != 3) && (i != 5) && (i != 7) && (i != 10))
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(" play in  state ");
        paramJSONObject.append(i);
        QLog.e("[cmshow]CmGameAudioPlayer", 1, paramJSONObject.toString());
      }
      else
      {
        a(true);
        paramJSONObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
        if (paramJSONObject != null) {
          try
          {
            paramJSONObject.start();
            a(5);
            if (this.c != 0) {
              this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.c);
            }
            this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new CmGameAudioPlayer.3(this));
          }
          catch (Throwable paramJSONObject)
          {
            QLog.e("[cmshow]CmGameAudioPlayer", 1, "audio play failed", paramJSONObject);
          }
        }
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer != null)
    {
      a(true);
      return this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer.a(paramCmGameNativeMethodHandler, paramJSONObject);
    }
    return null;
  }
  
  public JSONObject b(boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return paramJSONObject;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public JSONObject c(JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if ((a() == 1) && (a() == 2) && (a() == 9))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" duration in  state ");
        localStringBuilder.append(a());
        QLog.e("[cmshow]CmGameAudioPlayer", 1, localStringBuilder.toString());
        return paramJSONObject;
      }
      int i = this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
      if (paramJSONObject != null) {
        try
        {
          paramJSONObject.put("duration", i);
          return paramJSONObject;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("[cmshow]CmGameAudioPlayer", 1, localThrowable, new Object[0]);
        }
      }
    }
    return paramJSONObject;
  }
  
  public JSONObject c(JSONObject paramJSONObject, CmGameNativeMethodHandler paramCmGameNativeMethodHandler)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      return null;
    }
    if ((a() == 2) || (a() == 6))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new CmGameAudioPlayer.4(this, paramJSONObject, paramCmGameNativeMethodHandler));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
    }
    return null;
  }
  
  public JSONObject c(boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return paramJSONObject;
  }
  
  public JSONObject d(JSONObject paramJSONObject)
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null)
    {
      int i = localMediaPlayer.getCurrentPosition();
      try
      {
        paramJSONObject.put("currentTime", i);
        return paramJSONObject;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[cmshow]CmGameAudioPlayer", 1, localThrowable, new Object[0]);
      }
    }
    return paramJSONObject;
  }
  
  public JSONObject d(JSONObject paramJSONObject, CmGameNativeMethodHandler paramCmGameNativeMethodHandler)
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (a() != 9))
    {
      int i = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      if (paramJSONObject != null)
      {
        if (paramJSONObject.has("currentTime")) {
          this.c = paramJSONObject.optInt("currentTime");
        }
        try
        {
          paramJSONObject.put("currentTime", i);
          return paramJSONObject;
        }
        catch (Throwable paramCmGameNativeMethodHandler)
        {
          QLog.e("[cmshow]CmGameAudioPlayer", 1, paramCmGameNativeMethodHandler, new Object[0]);
        }
      }
    }
    return paramJSONObject;
  }
  
  public JSONObject e(JSONObject paramJSONObject)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer;
    if (localObject != null)
    {
      ((CmGameSoudPoolPlayer)localObject).c(paramJSONObject.optInt("id"), null);
      this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer.a(paramJSONObject);
    }
    localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localObject != null)
    {
      ((MediaPlayer)localObject).stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
    return paramJSONObject;
  }
  
  public JSONObject e(JSONObject paramJSONObject, CmGameNativeMethodHandler paramCmGameNativeMethodHandler)
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.setOnCompletionListener(new CmGameAudioPlayer.5(this, paramCmGameNativeMethodHandler, paramJSONObject));
    }
    return null;
  }
  
  public JSONObject f(JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer != null)
    {
      if (paramJSONObject.optBoolean("audo", true))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer.b();
        return paramJSONObject;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioCmGameSoudPoolPlayer.b(paramJSONObject.optInt("id"), null);
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmGameAudioPlayer
 * JD-Core Version:    0.7.0.1
 */