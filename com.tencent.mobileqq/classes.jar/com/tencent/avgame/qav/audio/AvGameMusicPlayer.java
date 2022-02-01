package com.tencent.avgame.qav.audio;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.AVRes;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.qav.IAVGameBusinessCtrl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AvGameMusicPlayer
  extends AVGameUIEventCallback
  implements IGameEffectPlayer
{
  private static AvGameMusicPlayer jdField_a_of_type_ComTencentAvgameQavAudioAvGameMusicPlayer;
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  private AvGameMusicPlayer()
  {
    e();
  }
  
  static float a(String paramString)
  {
    paramString = AvGameConfigUtil.a().a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return 0.5F;
    }
    return Float.parseFloat(paramString);
  }
  
  static int a(String paramString)
  {
    if ("succeed".equals(paramString)) {
      return 0;
    }
    if ("failed".equals(paramString)) {
      return 1;
    }
    return -1;
  }
  
  public static AvGameMusicPlayer a()
  {
    if (jdField_a_of_type_ComTencentAvgameQavAudioAvGameMusicPlayer == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvgameQavAudioAvGameMusicPlayer == null) {
          jdField_a_of_type_ComTencentAvgameQavAudioAvGameMusicPlayer = new AvGameMusicPlayer();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvgameQavAudioAvGameMusicPlayer;
  }
  
  static String a(int paramInt)
  {
    List localList = AvGameConfigUtil.a().a(paramInt);
    if ((localList != null) && (localList.size() > 0)) {
      return (String)localList.get(0);
    }
    return "";
  }
  
  static String a(ITopic paramITopic, String paramString)
  {
    if ((!"over".equals(paramString)) && (paramITopic != null) && (paramITopic.b() == 3))
    {
      int i = a(paramString);
      if (-1 == i)
      {
        QLog.d("AvGameMusicPlayer", 1, String.format("isVideoEffectValid() index is invalid [index] %d ", new Object[] { Integer.valueOf(i) }));
        return null;
      }
      paramITopic = ((TopicBase)paramITopic).a(i);
      if (paramITopic == null)
      {
        QLog.d("AvGameMusicPlayer", 1, "isVideoEffectValid() res is null ");
        return null;
      }
      paramITopic = AvGameResDownloadUtil.a(paramITopic.b(), ".mp3");
      if (!FileUtils.fileExists(paramITopic))
      {
        QLog.d("AvGameMusicPlayer", 1, String.format("isVideoEffectValid() effectFile is not exist [effectFile] %s ", new Object[] { paramITopic }));
        return null;
      }
      return paramITopic;
    }
    QLog.d("AvGameMusicPlayer", 1, "isVideoEffectValid() is game over or iTopic is empty ");
    return null;
  }
  
  private boolean a(int paramInt1, String paramString, int paramInt2, float paramFloat)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    try
    {
      localStringBuilder = new StringBuilder();
      bool1 = bool3;
      localStringBuilder.append("playInner() mixSrcType = ");
      bool1 = bool3;
      localStringBuilder.append(paramInt1);
      bool1 = bool3;
      localStringBuilder.append(" fileName = ");
      bool1 = bool3;
      localStringBuilder.append(paramString);
      bool1 = bool3;
      localStringBuilder.append(" times = ");
      bool1 = bool3;
      localStringBuilder.append(paramInt2);
      bool1 = bool3;
      localStringBuilder.append(" volumeScale =");
      bool1 = bool3;
      localStringBuilder.append(paramFloat);
      bool1 = bool3;
      QLog.d("AvGameMusicPlayer", 1, localStringBuilder.toString());
      bool1 = bool3;
      if (Build.VERSION.SDK_INT >= 16)
      {
        bool1 = bool3;
        bool3 = AudioProcess.a().startPlay(paramInt1);
        bool1 = bool3;
        AudioProcess.a().addFile(paramString, 1, paramFloat, paramInt2);
        bool1 = bool3;
        bool2 = bool3;
        if (!this.jdField_a_of_type_JavaUtilList.contains(paramString))
        {
          bool1 = bool3;
          this.jdField_a_of_type_JavaUtilList.add(paramString);
          return bool3;
        }
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playBgMusic() e = ");
      localStringBuilder.append(paramString);
      QLog.d("AvGameMusicPlayer", 1, localStringBuilder.toString());
      bool2 = bool1;
    }
    return bool2;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_ComTencentAvgameQavAudioAvGameMusicPlayer != null) {
      a().d();
    }
  }
  
  private void e()
  {
    IAVGameBusinessCtrl localIAVGameBusinessCtrl = IAVGameBusinessCtrl.a();
    if (localIAVGameBusinessCtrl != null) {
      localIAVGameBusinessCtrl.a(this);
    }
    this.jdField_a_of_type_JavaLangString = AvGameResDownloadUtil.b();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameMusicPlayer", 2, String.format("playBgMusic() resPath null", new Object[0]));
      }
      return;
    }
    String str = "cj_bg";
    float f;
    if (((paramInt == 2) || (paramInt == 5)) && (paramBoolean))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("cj_bg");
      localStringBuilder.append(".mp3");
      if (!new File(localStringBuilder.toString()).exists()) {
        return;
      }
      f = AvGameConfigUtil.a().b();
    }
    else
    {
      str = a(paramInt);
      f = a(str);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvGameMusicPlayer", 2, String.format("playBgMusic() [gameType, gameBgName] %d , %s", new Object[] { Integer.valueOf(paramInt), str }));
    }
    a(str, true, f);
  }
  
  public void a(ITopic paramITopic, String paramString)
  {
    String str = a(paramITopic, paramString);
    paramITopic = str;
    if (TextUtils.isEmpty(str))
    {
      paramITopic = new StringBuilder();
      paramITopic.append(this.jdField_a_of_type_JavaLangString);
      paramITopic.append(paramString);
      paramITopic.append(".mp3");
      paramITopic = paramITopic.toString();
    }
    b(paramITopic, false, 0.5F);
  }
  
  public void a(String paramString, boolean paramBoolean, float paramFloat)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".mp3");
      paramString = ((StringBuilder)localObject).toString();
      int i;
      if (paramBoolean) {
        i = 2147483647;
      } else {
        i = 1;
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.jdField_a_of_type_Int = 1;
        paramBoolean = a(3, paramString, i, paramFloat);
        if (paramBoolean) {
          paramString = "0X800B053";
        } else {
          paramString = "0X800B054";
        }
        if (paramBoolean) {
          localObject = "0X800B053";
        } else {
          localObject = "0X800B054";
        }
        ReportController.b(null, "dc00898", "", "", paramString, (String)localObject, IGameEngine.a().a().d(), 0, "", "", "", "");
      }
      return;
    }
    QLog.d("AvGameMusicPlayer", 1, String.format("playBgMusic() filePath or fileName is empty just return [bgMusicFileName,resPath,volumeScale] %s , %s , %f", new Object[] { paramString, this.jdField_a_of_type_JavaLangString, Float.valueOf(paramFloat) }));
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSystemCallStateChanged() isCalling =");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" playingBgStatus =");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.d("AvGameMusicPlayer", 1, localStringBuilder.toString());
    if ((Build.VERSION.SDK_INT >= 16) && (this.jdField_a_of_type_Int == 1))
    {
      if (paramBoolean)
      {
        AudioProcess.a().pausePlay();
        this.jdField_a_of_type_Int = 2;
        return;
      }
      AudioProcess.a().resumePlay();
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public void b(String paramString, boolean paramBoolean, float paramFloat)
  {
    int i;
    if (paramBoolean) {
      i = 2147483647;
    } else {
      i = 1;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramBoolean = a(3, paramString, i, paramFloat);
      if (paramBoolean) {
        paramString = "0X800B055";
      } else {
        paramString = "0X800B056";
      }
      String str;
      if (paramBoolean) {
        str = "0X800B055";
      } else {
        str = "0X800B056";
      }
      ReportController.b(null, "dc00898", "", "", paramString, str, IGameEngine.a().a().d(), 0, "", "", "", "");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameMusicPlayer", 2, "stopPlay() ");
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.jdField_a_of_type_Int = 3;
      AudioProcess.a().stopPlay();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        AudioProcess.a().removeFile(str);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 0;
    Object localObject = IAVGameBusinessCtrl.a();
    if (localObject != null) {
      ((IAVGameBusinessCtrl)localObject).b(this);
    }
    jdField_a_of_type_ComTencentAvgameQavAudioAvGameMusicPlayer = null;
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          AudioProcess.a().removeFile(str);
        }
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList = null;
      }
      QLog.d("AvGameMusicPlayer", 1, "destroy() ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.audio.AvGameMusicPlayer
 * JD-Core Version:    0.7.0.1
 */