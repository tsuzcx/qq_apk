package com.tencent.avgame.gamelogic.gameres;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.AVRes;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.util.AvGameConfBean;
import com.tencent.mobileqq.config.business.AvGameConfProcessor;
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
  private static AvGameMusicPlayer jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameMusicPlayer;
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  private AvGameMusicPlayer()
  {
    e();
  }
  
  static float a(String paramString)
  {
    paramString = AvGameConfProcessor.a().a(paramString);
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
    if (jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameMusicPlayer == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameMusicPlayer == null) {
        jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameMusicPlayer = new AvGameMusicPlayer();
      }
      return jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameMusicPlayer;
    }
    finally {}
  }
  
  static String a(int paramInt)
  {
    List localList = AvGameConfProcessor.a().a(paramInt);
    if ((localList == null) || (localList.size() <= 0)) {
      return "";
    }
    return (String)localList.get(0);
  }
  
  static String a(ITopic paramITopic, String paramString)
  {
    if (("over".equals(paramString)) || (paramITopic == null) || (paramITopic.b() != 3))
    {
      QLog.d("AvGameMusicPlayer", 1, "isVideoEffectValid() is game over or iTopic is empty ");
      return null;
    }
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
    paramITopic = AvGameResHandler.a(paramITopic.b(), ".mp3");
    if (!FileUtils.a(paramITopic))
    {
      QLog.d("AvGameMusicPlayer", 1, String.format("isVideoEffectValid() effectFile is not exist [effectFile] %s ", new Object[] { paramITopic }));
      return null;
    }
    return paramITopic;
  }
  
  private boolean a(int paramInt1, String paramString, int paramInt2, float paramFloat)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    try
    {
      QLog.d("AvGameMusicPlayer", 1, "playInner() mixSrcType = " + paramInt1 + " fileName = " + paramString + " times = " + paramInt2 + " volumeScale =" + paramFloat);
      bool1 = bool3;
      if (Build.VERSION.SDK_INT >= 16)
      {
        bool1 = bool3;
        bool3 = AudioProcess.a().a(paramInt1);
        bool1 = bool3;
        AudioProcess.a().a(paramString, 1, paramFloat, paramInt2);
        bool2 = bool3;
        bool1 = bool3;
        if (!this.jdField_a_of_type_JavaUtilList.contains(paramString))
        {
          bool1 = bool3;
          this.jdField_a_of_type_JavaUtilList.add(paramString);
          bool2 = bool3;
        }
      }
      return bool2;
    }
    catch (Exception paramString)
    {
      QLog.d("AvGameMusicPlayer", 1, "playBgMusic() e = " + paramString);
    }
    return bool1;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameMusicPlayer != null) {
      a().d();
    }
  }
  
  private void e()
  {
    AVGameBusinessCtrl.b().a(this);
    this.jdField_a_of_type_JavaLangString = AvGameResDownloadManager.b();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameMusicPlayer", 2, String.format("playBgMusic() resPath null", new Object[0]));
      }
    }
    do
    {
      return;
      if (((paramInt != 2) && (paramInt != 5)) || (!paramBoolean)) {
        break;
      }
      localObject = new File(this.jdField_a_of_type_JavaLangString + "cj_bg" + ".mp3");
    } while ((localObject == null) || (!((File)localObject).exists()));
    Object localObject = "cj_bg";
    for (float f = AvGameConfProcessor.a().b();; f = a((String)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameMusicPlayer", 2, String.format("playBgMusic() [gameType, gameBgName] %d , %s", new Object[] { Integer.valueOf(paramInt), localObject }));
      }
      a((String)localObject, true, f);
      return;
      localObject = a(paramInt);
    }
  }
  
  public void a(ITopic paramITopic, String paramString)
  {
    String str = a(paramITopic, paramString);
    paramITopic = str;
    if (TextUtils.isEmpty(str)) {
      paramITopic = this.jdField_a_of_type_JavaLangString + paramString + ".mp3";
    }
    b(paramITopic, false, 0.5F);
  }
  
  public void a(String paramString, boolean paramBoolean, float paramFloat)
  {
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("AvGameMusicPlayer", 1, String.format("playBgMusic() filePath or fileName is empty just return [bgMusicFileName,resPath,volumeScale] %s , %s , %f", new Object[] { paramString, this.jdField_a_of_type_JavaLangString, Float.valueOf(paramFloat) }));
      return;
    }
    paramString = this.jdField_a_of_type_JavaLangString + paramString + ".mp3";
    int i;
    if (paramBoolean)
    {
      i = 2147483647;
      label86:
      if (Build.VERSION.SDK_INT < 16) {
        break label163;
      }
      this.jdField_a_of_type_Int = 1;
      paramBoolean = a(3, paramString, i, paramFloat);
      if (!paramBoolean) {
        break label165;
      }
      paramString = "0X800B053";
      label117:
      if (!paramBoolean) {
        break label172;
      }
    }
    label163:
    label165:
    label172:
    for (String str = "0X800B053";; str = "0X800B054")
    {
      ReportController.b(null, "dc00898", "", "", paramString, str, GameEngine.a().a().d(), 0, "", "", "", "");
      return;
      i = 1;
      break label86;
      break;
      paramString = "0X800B054";
      break label117;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("AvGameMusicPlayer", 1, "onSystemCallStateChanged() isCalling =" + paramBoolean + " playingBgStatus =" + this.jdField_a_of_type_Int);
    if ((Build.VERSION.SDK_INT >= 16) && (this.jdField_a_of_type_Int == 1))
    {
      if (paramBoolean)
      {
        AudioProcess.a().d();
        this.jdField_a_of_type_Int = 2;
      }
    }
    else {
      return;
    }
    AudioProcess.a().e();
    this.jdField_a_of_type_Int = 1;
  }
  
  public void b(String paramString, boolean paramBoolean, float paramFloat)
  {
    int i;
    if (paramBoolean)
    {
      i = 2147483647;
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramBoolean = a(3, paramString, i, paramFloat);
        if (!paramBoolean) {
          break label82;
        }
        paramString = "0X800B055";
        label34:
        if (!paramBoolean) {
          break label89;
        }
      }
    }
    label82:
    label89:
    for (String str = "0X800B055";; str = "0X800B056")
    {
      ReportController.b(null, "dc00898", "", "", paramString, str, GameEngine.a().a().d(), 0, "", "", "", "");
      return;
      i = 1;
      break;
      paramString = "0X800B056";
      break label34;
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
      AudioProcess.a().c();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        AudioProcess.a().b(str);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 0;
    AVGameBusinessCtrl.b().b(this);
    jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameMusicPlayer = null;
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          AudioProcess.a().b(str);
        }
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList = null;
      }
      QLog.d("AvGameMusicPlayer", 1, "destroy() ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.AvGameMusicPlayer
 * JD-Core Version:    0.7.0.1
 */