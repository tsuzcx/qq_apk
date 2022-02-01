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
  public static List<CmGameAudioPlayer> a = Collections.synchronizedList(new ArrayList());
  private int b;
  private int c;
  private MediaPlayer d;
  private CmGameSoudPoolPlayer e;
  private int f = 0;
  private boolean g = false;
  private boolean h = false;
  private AtomicInteger i = new AtomicInteger(0);
  private AudioManager j;
  private AudioManager.OnAudioFocusChangeListener k = new CmGameAudioPlayer.6(this);
  
  public CmGameAudioPlayer(int paramInt1, int paramInt2, String paramString)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    CmGameLauncher localCmGameLauncher = CmGameUtil.a(paramInt2);
    if (localCmGameLauncher != null) {
      localCmGameLauncher.b(0);
    }
    if ("effect".equals(paramString))
    {
      if (localCmGameLauncher != null) {
        this.e = new CmGameSoudPoolPlayer(paramInt2);
      } else {
        QLog.e("[cmshow]CmGameAudioPlayer", 1, "can not create pool");
      }
    }
    else
    {
      this.d = new MediaPlayer();
      a(1);
      this.d.setOnErrorListener(new CmGameAudioPlayer.1(this));
    }
    paramString = a;
    if (paramString != null) {
      try
      {
        a.add(this);
      }
      finally {}
    }
    this.j = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
  }
  
  private void a(boolean paramBoolean)
  {
    AudioManager localAudioManager = this.j;
    if (localAudioManager == null) {
      return;
    }
    int m;
    if (paramBoolean) {
      m = localAudioManager.requestAudioFocus(this.k, 3, 2);
    } else {
      m = localAudioManager.abandonAudioFocus(this.k);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmGameAudioPlayer", 2, new Object[] { "[execAudioFocus], requestFocus:", Boolean.valueOf(paramBoolean), ",ret:", Integer.valueOf(m) });
    }
  }
  
  private void c(CmGameNativeMethodHandler paramCmGameNativeMethodHandler, JSONObject paramJSONObject)
  {
    if (paramCmGameNativeMethodHandler != null) {
      paramCmGameNativeMethodHandler.a(paramJSONObject);
    }
  }
  
  public int a()
  {
    return this.i.get();
  }
  
  public int a(int paramInt)
  {
    return this.i.getAndSet(paramInt);
  }
  
  public JSONObject a(float paramFloat1, float paramFloat2, JSONObject paramJSONObject)
  {
    if (this.d != null)
    {
      if (a() != 9)
      {
        this.d.setVolume(paramFloat1, paramFloat2);
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
    if (this.d != null)
    {
      int m = a();
      if ((m != 3) && (m != 5) && (m != 7) && (m != 10))
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(" seek in  state ");
        paramJSONObject.append(m);
        QLog.e("[cmshow]CmGameAudioPlayer", 1, paramJSONObject.toString());
      }
      else
      {
        this.d.setOnSeekCompleteListener(new CmGameAudioPlayer.2(this, paramJSONObject, paramCmGameNativeMethodHandler));
        this.d.seekTo(paramInt);
      }
    }
    return null;
  }
  
  public JSONObject a(CmGameNativeMethodHandler arg1, JSONObject paramJSONObject)
  {
    try
    {
      if (this.d != null) {
        this.d.release();
      }
      if (this.e != null) {
        this.e.c();
      }
      a(8);
      this.d = null;
      this.e = null;
      if (??? != null) {
        ???.b(this);
      }
      if (a != null) {
        synchronized (a)
        {
          a.remove(this);
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
        if (this.d != null)
        {
          if (paramJSONObject.has("duration")) {
            paramJSONObject.put("duration", this.d.getDuration());
          }
          if (paramJSONObject.has("currentTime")) {
            paramJSONObject.put("currentTime", this.d.getCurrentPosition());
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
    if (this.d != null)
    {
      if (paramBoolean) {
        return a(0.0F, 0.0F, paramJSONObject);
      }
      return a(paramFloat1, paramFloat2, paramJSONObject);
    }
    CmGameSoudPoolPlayer localCmGameSoudPoolPlayer = this.e;
    if (localCmGameSoudPoolPlayer != null)
    {
      int m;
      if ((!paramBoolean) && ((Float.compare(paramFloat1, 0.0F) != 0) || (Float.compare(paramFloat2, 0.0F) != 0))) {
        m = 1;
      } else {
        m = 0;
      }
      localCmGameSoudPoolPlayer.a(m, BaseActivity.sTopActivity.getAppInterface());
    }
    return paramJSONObject;
  }
  
  public JSONObject a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (this.d != null)
    {
      int m = a();
      if ((m != 1) && (m != 2) && (m != 6) && (m != 3) && (m != 5) && (m != 7) && (m != 10))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" loop in  state ");
        localStringBuilder.append(m);
        QLog.e("[cmshow]CmGameAudioPlayer", 1, localStringBuilder.toString());
        return paramJSONObject;
      }
      this.d.setLooping(paramBoolean);
    }
    return paramJSONObject;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public JSONObject b(CmGameNativeMethodHandler paramCmGameNativeMethodHandler, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if (paramJSONObject.optInt("N_R_OBJ") == this.b)
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
      int m;
      if (this.d != null)
      {
        m = a();
        if ((m != 5) && (m != 7) && (m != 10))
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
          this.d.pause();
          a(7);
        }
      }
      else if (this.e != null)
      {
        m = paramJSONObject.optInt("id");
        if (paramJSONObject.optBoolean("auto", true)) {
          this.e.a();
        } else {
          this.e.a(m, null);
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
    if (this.d != null)
    {
      int m = a();
      if ((m != 3) && (m != 5) && (m != 7) && (m != 10))
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(" play in  state ");
        paramJSONObject.append(m);
        QLog.e("[cmshow]CmGameAudioPlayer", 1, paramJSONObject.toString());
      }
      else
      {
        a(true);
        paramJSONObject = this.d;
        if (paramJSONObject != null) {
          try
          {
            paramJSONObject.start();
            a(5);
            if (this.f != 0) {
              this.d.seekTo(this.f);
            }
            this.d.setOnCompletionListener(new CmGameAudioPlayer.3(this));
          }
          catch (Throwable paramJSONObject)
          {
            QLog.e("[cmshow]CmGameAudioPlayer", 1, "audio play failed", paramJSONObject);
          }
        }
      }
    }
    else if (this.e != null)
    {
      a(true);
      return this.e.a(paramCmGameNativeMethodHandler, paramJSONObject);
    }
    return null;
  }
  
  public JSONObject b(boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.g = paramBoolean;
    return paramJSONObject;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public JSONObject c(JSONObject paramJSONObject)
  {
    if (this.d != null)
    {
      if ((a() == 1) && (a() == 2) && (a() == 9))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" duration in  state ");
        localStringBuilder.append(a());
        QLog.e("[cmshow]CmGameAudioPlayer", 1, localStringBuilder.toString());
        return paramJSONObject;
      }
      int m = this.d.getDuration();
      if (paramJSONObject != null) {
        try
        {
          paramJSONObject.put("duration", m);
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
    if (this.d == null) {
      return null;
    }
    if ((a() == 2) || (a() == 6))
    {
      this.d.setOnPreparedListener(new CmGameAudioPlayer.4(this, paramJSONObject, paramCmGameNativeMethodHandler));
      this.d.prepareAsync();
    }
    return null;
  }
  
  public JSONObject c(boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.h = paramBoolean;
    return paramJSONObject;
  }
  
  public String d()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.d;
      if (localMediaPlayer != null) {
        try
        {
          this.d.release();
          this.d = null;
        }
        catch (Throwable localThrowable1)
        {
          QLog.e("[cmshow]CmGameAudioPlayer", 1, localThrowable1, new Object[0]);
        }
      }
      if (this.e != null)
      {
        this.e.c();
        this.e = null;
        return null;
      }
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("[cmshow]CmGameAudioPlayer", 1, "audio destroy falied", localThrowable2);
    }
    return null;
  }
  
  public JSONObject d(JSONObject paramJSONObject)
  {
    MediaPlayer localMediaPlayer = this.d;
    if (localMediaPlayer != null)
    {
      int m = localMediaPlayer.getCurrentPosition();
      try
      {
        paramJSONObject.put("currentTime", m);
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
    if ((this.d != null) && (a() != 9))
    {
      int m = this.d.getCurrentPosition();
      if (paramJSONObject != null)
      {
        if (paramJSONObject.has("currentTime")) {
          this.f = paramJSONObject.optInt("currentTime");
        }
        try
        {
          paramJSONObject.put("currentTime", m);
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
    Object localObject = this.e;
    if (localObject != null)
    {
      ((CmGameSoudPoolPlayer)localObject).c(paramJSONObject.optInt("id"), null);
      this.e.a(paramJSONObject);
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((MediaPlayer)localObject).stop();
      this.d.reset();
    }
    return paramJSONObject;
  }
  
  public JSONObject e(JSONObject paramJSONObject, CmGameNativeMethodHandler paramCmGameNativeMethodHandler)
  {
    MediaPlayer localMediaPlayer = this.d;
    if (localMediaPlayer != null) {
      localMediaPlayer.setOnCompletionListener(new CmGameAudioPlayer.5(this, paramCmGameNativeMethodHandler, paramJSONObject));
    }
    return null;
  }
  
  public JSONObject f(JSONObject paramJSONObject)
  {
    if (this.e != null)
    {
      if (paramJSONObject.optBoolean("audo", true))
      {
        this.e.b();
        return paramJSONObject;
      }
      this.e.b(paramJSONObject.optInt("id"), null);
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmGameAudioPlayer
 * JD-Core Version:    0.7.0.1
 */