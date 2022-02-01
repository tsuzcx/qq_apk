package com.tencent.mobileqq.apollo.game.process.audio;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.SoundPool;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.ApolloGameTool;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameNativeMethodHandler;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderRunner;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

public class CmGameSoudPoolPlayer
  implements ICmGameAudioPlayer
{
  private SoundPool a;
  private Map<String, Integer> b = Collections.synchronizedMap(new LRULinkedHashMap(20));
  private int c = 1;
  private SharedPreferences d;
  private AppInterface e;
  private int f;
  
  public CmGameSoudPoolPlayer(int paramInt)
  {
    QLog.i("cmgame_process.CmGameSoudPoolPlayer", 1, "[CmGameSoudPoolPlayer]");
    this.a = new SoundPool(20, 3, 0);
    this.f = paramInt;
    this.e = CmGameUtil.b();
    this.d = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    d();
  }
  
  private void a(IRenderRunner paramIRenderRunner, int paramInt, long paramLong)
  {
    ApolloCmdChannel.getInstance().playMusicInner(paramIRenderRunner, paramInt, paramLong);
  }
  
  private void d()
  {
    if (this.e == null) {
      return;
    }
    SharedPreferences localSharedPreferences = this.d;
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_game_music_switch");
      localStringBuilder.append(this.e.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(this.f);
      this.c = localSharedPreferences.getInt(localStringBuilder.toString(), 1);
    }
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public int a(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameSoudPoolPlayer", 2, new Object[] { "[getMusicSwitch], gameId:", Integer.valueOf(this.f) });
    }
    d();
    return this.c;
  }
  
  public int a(IRenderRunner paramIRenderRunner, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3, float paramFloat)
  {
    if ((this.f > 0) && ((this.c == 0) || (this.e == null) || (!CmGameUtil.g()) || (paramIRenderRunner == null)))
    {
      paramIRenderRunner = new StringBuilder();
      paramIRenderRunner.append("[playMusic], DO NOT play. switch:");
      paramIRenderRunner.append(this.c);
      QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, paramIRenderRunner.toString());
      return -1;
    }
    for (;;)
    {
      try
      {
        boolean bool = paramIRenderRunner instanceof ApolloSurfaceView;
        SoundPool localSoundPool = null;
        if (bool)
        {
          localObject = ((ApolloSurfaceView)paramIRenderRunner).getRender();
        }
        else
        {
          if (!(paramIRenderRunner instanceof ApolloTextureView)) {
            break label354;
          }
          localObject = ((ApolloTextureView)paramIRenderRunner).getRender();
        }
        if (localObject != null) {
          localObject = ((ApolloRender)localObject).getRscPath(paramString, "mp3");
        } else {
          localObject = localSoundPool;
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "audioPath is null.");
          return -1;
        }
        localSoundPool = this.a;
        if ((localSoundPool != null) && (this.b != null))
        {
          localSoundPool.setOnLoadCompleteListener(new CmGameSoudPoolPlayer.2(this, paramFloat, paramInt2, paramString, paramIRenderRunner, paramLong));
          paramString = (Integer)this.b.get(localObject);
          if (paramString != null)
          {
            if (-1.0F == paramFloat) {
              paramFloat = 1.0F;
            }
            paramInt1 = this.a.play(paramString.intValue(), paramFloat, paramFloat, 0, paramInt2, 1.0F);
            if (paramInt1 != 0)
            {
              a(paramIRenderRunner, paramInt1, paramLong);
              return 0;
            }
          }
          else
          {
            paramInt1 = this.a.load((String)localObject, 1);
            this.b.put(localObject, Integer.valueOf(paramInt1));
            return 0;
          }
        }
        else
        {
          paramIRenderRunner = new StringBuilder();
          paramIRenderRunner.append("pool or cache is null ");
          if (this.a == null) {
            bool = true;
          } else {
            bool = false;
          }
          paramIRenderRunner.append(bool);
          QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, paramIRenderRunner.toString());
        }
        return 0;
      }
      catch (Throwable paramIRenderRunner)
      {
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, paramIRenderRunner, new Object[0]);
        return -1;
      }
      label354:
      Object localObject = null;
    }
  }
  
  public JSONObject a(CmGameNativeMethodHandler paramCmGameNativeMethodHandler, JSONObject paramJSONObject)
  {
    if ((this.f > 0) && ((this.c == 0) || (this.e == null) || (!CmGameUtil.g())))
    {
      paramCmGameNativeMethodHandler = new StringBuilder();
      paramCmGameNativeMethodHandler.append("[playMusic], DO NOT play. switch:");
      paramCmGameNativeMethodHandler.append(this.c);
      QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, paramCmGameNativeMethodHandler.toString());
      return paramJSONObject;
    }
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramJSONObject.toString());
        paramJSONObject.optInt("type");
        int i = paramJSONObject.optInt("loop");
        String str2 = paramJSONObject.optString("src");
        float f1 = (float)paramJSONObject.optDouble("volume");
        String str1 = ApolloGameTool.a(str2, this.f, "", false);
        if (TextUtils.isEmpty(str1))
        {
          QLog.w("cmgame_process.CmGameSoudPoolPlayer", 1, "audioPath is null.");
          return paramJSONObject;
        }
        if ((this.a != null) && (this.b != null))
        {
          this.a.setOnLoadCompleteListener(new CmGameSoudPoolPlayer.1(this, f1, i, str2, paramCmGameNativeMethodHandler, localJSONObject));
          paramJSONObject = (Integer)this.b.get(str1);
          if (paramJSONObject != null)
          {
            if (-1.0F != f1) {
              break label368;
            }
            f1 = 1.0F;
            i = this.a.play(paramJSONObject.intValue(), f1, f1, 0, i, 1.0F);
            if ((i != 0) && (paramCmGameNativeMethodHandler != null)) {
              try
              {
                localJSONObject.put("id", i);
                paramCmGameNativeMethodHandler.a(localJSONObject);
              }
              catch (Throwable paramCmGameNativeMethodHandler)
              {
                QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, paramCmGameNativeMethodHandler, new Object[0]);
              }
            }
          }
          else
          {
            i = this.a.load(str1, 1);
            this.b.put(str1, Integer.valueOf(i));
          }
        }
        else
        {
          paramCmGameNativeMethodHandler = new StringBuilder();
          paramCmGameNativeMethodHandler.append("pool or cache is null ");
          if (this.a != null) {
            break label371;
          }
          bool = true;
          paramCmGameNativeMethodHandler.append(bool);
          QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, paramCmGameNativeMethodHandler.toString());
        }
      }
      catch (Throwable paramCmGameNativeMethodHandler)
      {
        QLog.e("cmgame_process.CmGameSoudPoolPlayer", 1, paramCmGameNativeMethodHandler, new Object[0]);
      }
      return null;
      label368:
      continue;
      label371:
      boolean bool = false;
    }
  }
  
  public JSONObject a(JSONObject paramJSONObject)
  {
    if ((this.a != null) && (paramJSONObject != null) && (paramJSONObject.has("id"))) {
      this.a.unload(paramJSONObject.optInt("id"));
    }
    return paramJSONObject;
  }
  
  public void a()
  {
    SoundPool localSoundPool = this.a;
    if (localSoundPool != null) {
      localSoundPool.autoPause();
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, AppInterface paramAppInterface)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (paramAppInterface == null) {
        return;
      }
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_game_music_switch");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(this.f);
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt).commit();
      if (paramInt == 0) {
        a();
      }
      this.c = paramInt;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.a;
    if (paramString != null) {
      paramString.pause(paramInt);
    }
  }
  
  public int b(int paramInt)
  {
    return 0;
  }
  
  public void b()
  {
    SoundPool localSoundPool = this.a;
    if (localSoundPool != null) {
      localSoundPool.autoResume();
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    paramString = this.a;
    if (paramString != null) {
      paramString.resume(paramInt);
    }
  }
  
  public void c()
  {
    QLog.i("cmgame_process.CmGameSoudPoolPlayer", 1, "[onDestroy]");
    SoundPool localSoundPool = this.a;
    if (localSoundPool != null)
    {
      localSoundPool.release();
      this.a = null;
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    paramString = this.a;
    if (paramString != null) {
      paramString.stop(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmGameSoudPoolPlayer
 * JD-Core Version:    0.7.0.1
 */