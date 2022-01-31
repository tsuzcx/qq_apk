package com.tencent.mobileqq.ar.ARRecord.worldcup;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARRecord.ARWorldCupRecordDpc;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.worldcup.ARWorldCupConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@TargetApi(18)
public class VideoProcessor
{
  public static boolean a;
  public static boolean b = true;
  private FFmpegVideoProcessor jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupFFmpegVideoProcessor = new FFmpegVideoProcessor();
  private HWVideoProcessor jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupHWVideoProcessor = new HWVideoProcessor();
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public static long a(String paramString)
  {
    long l1 = 0L;
    long l2;
    if (!FileUtil.a(paramString))
    {
      QLog.e("Q.worldcup.record", 1, String.format("getVideoDuration, path: %s, file is not exist", new Object[] { paramString }));
      l2 = l1;
    }
    do
    {
      return l2;
      File localFile = new File(paramString);
      localMediaPlayer = new MediaPlayer();
      try
      {
        localMediaPlayer.setDataSource(localFile.getPath());
        localMediaPlayer.prepare();
        int i = localMediaPlayer.getDuration();
        l1 = i;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
          localMediaPlayer.stop();
          localMediaPlayer.release();
        }
      }
      finally
      {
        localMediaPlayer.stop();
        localMediaPlayer.release();
      }
      l2 = l1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.worldcup.record", 2, String.format("getVideoDuration path: %s, duration: %s", new Object[] { paramString, Long.valueOf(l1) }));
    return l1;
  }
  
  public static String a(int paramInt)
  {
    Object localObject3 = null;
    String str = "worldcup_video_" + paramInt + ".mp4";
    Object localObject1 = b(1);
    Object localObject2;
    if (FileUtil.a((String)localObject1))
    {
      localObject1 = new File((String)localObject1, "record_game");
      if (((File)localObject1).exists())
      {
        localObject1 = ((File)localObject1).getAbsolutePath() + File.separator + str;
        localObject2 = localObject1;
        if (!FileUtil.a((String)localObject1))
        {
          localObject2 = b(3);
          if (!FileUtil.a((String)localObject2)) {
            break label274;
          }
          localObject2 = new File((String)localObject2, "record_game");
          if (!((File)localObject2).exists()) {
            break label247;
          }
          localObject2 = ((File)localObject2).getAbsolutePath() + File.separator + str;
        }
        label155:
        if (FileUtil.a((String)localObject2)) {
          break label298;
        }
      }
    }
    label274:
    label298:
    for (localObject1 = localObject3;; localObject1 = localObject2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.worldcup.record", 2, String.format("selectGameVideo, videoIndex: %s, path: %s", new Object[] { Integer.valueOf(paramInt), localObject1 }));
      }
      return localObject1;
      QLog.d("Q.worldcup.record", 2, String.format("selectGameVideo, res1 coverdir: %s is not exits", new Object[] { ((File)localObject1).getAbsoluteFile() }));
      for (;;)
      {
        localObject1 = null;
        break;
        QLog.d("Q.worldcup.record", 2, String.format("selectGameVideo, res1Path: %s is not exits", new Object[] { localObject1 }));
      }
      label247:
      QLog.d("Q.worldcup.record", 2, String.format("selectGameVideo, res2 coverdir: %s is not exits", new Object[] { ((File)localObject2).getAbsoluteFile() }));
      localObject2 = localObject1;
      break label155;
      QLog.d("Q.worldcup.record", 2, String.format("selectGameVideo, res2Path: %s is not exits", new Object[] { localObject2 }));
      localObject2 = localObject1;
      break label155;
    }
  }
  
  public static String a(String paramString)
  {
    paramString = paramString + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis())) + ".mp4";
    return new File(ARWorldCupConstant.c, paramString).getAbsolutePath();
  }
  
  private boolean a()
  {
    boolean bool = BaseApplicationImpl.getContext().getSharedPreferences("world_cup_record", 0).getBoolean("KEY_ENABLE_HW_MERGE_AUDIO", true);
    int i = ARWorldCupRecordDpc.a().b;
    if (QLog.isColorLevel()) {
      QLog.d("Q.worldcup.record", 2, String.format("isSupportHWMergeAudio, isHWMergeAudio: %s, mergeAudioMode: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) }));
    }
    return (bool) && (i == 0);
  }
  
  private static String b()
  {
    String str = new File(b(1), "record_music").getAbsolutePath();
    if (QLog.isColorLevel()) {
      QLog.d("Q.worldcup.record", 2, String.format("getBgMusicPath: %s", new Object[] { str }));
    }
    return str;
  }
  
  private static String b(int paramInt)
  {
    WorldCupConfigInfo localWorldCupConfigInfo = WorldCupMgr.a;
    if (localWorldCupConfigInfo == null) {
      return null;
    }
    return localWorldCupConfigInfo.a(paramInt);
  }
  
  private String b(String paramString)
  {
    if (!FileUtil.a(paramString))
    {
      QLog.e("Q.worldcup.record", 1, String.format("selectCoverVideo| coverPicPath: %s is not exist", new Object[] { paramString }));
      paramString = null;
    }
    Object localObject;
    long l;
    do
    {
      return paramString;
      localObject = new File(ARWorldCupConstant.b);
      File localFile = new File(paramString);
      localObject = (((File)localObject).getAbsolutePath() + File.separator + localFile.getName()).replace(".jpg", ".mp4");
      l = System.currentTimeMillis();
      if (!FileUtil.a((String)localObject))
      {
        a(paramString, (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.worldcup.record", 2, "selectCoverVideo| coverVideoPath is not exist, make cover video");
        }
      }
      paramString = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("Q.worldcup.record", 2, String.format("selectCoverVideo| path: %s, cost: %s", new Object[] { localObject, Long.valueOf(System.currentTimeMillis() - l) }));
    return localObject;
  }
  
  public String a()
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = null;
    Object localObject1 = b(0);
    Object localObject2;
    String[] arrayOfString;
    int j;
    int i;
    if (FileUtil.a((String)localObject1))
    {
      localObject2 = new File((String)localObject1, "record_cover");
      if (((File)localObject2).exists())
      {
        arrayOfString = ((File)localObject2).list();
        j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          String str2 = arrayOfString[i];
          if (str2.endsWith(".jpg")) {
            localArrayList.add(((File)localObject2).getAbsolutePath() + File.separator + str2);
          }
          i += 1;
        }
      }
      QLog.d("Q.worldcup.record", 2, String.format("selectCoverPath, res0 coverdir: %s is not exits", new Object[] { ((File)localObject2).getAbsoluteFile() }));
    }
    for (;;)
    {
      localObject2 = b(3);
      if (!FileUtil.a((String)localObject2)) {
        break label371;
      }
      localObject1 = new File((String)localObject2, "record_cover");
      if (!((File)localObject1).exists()) {
        break;
      }
      localObject2 = ((File)localObject1).list();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        arrayOfString = localObject2[i];
        if (arrayOfString.endsWith(".jpg")) {
          localArrayList.add(((File)localObject1).getAbsolutePath() + File.separator + arrayOfString);
        }
        i += 1;
      }
      QLog.d("Q.worldcup.record", 2, String.format("selectCoverPath, res0Path: %s is not exits", new Object[] { localObject1 }));
    }
    QLog.d("Q.worldcup.record", 2, String.format("selectCoverPath, res2 coverdir: %s is not exits", new Object[] { ((File)localObject1).getAbsoluteFile() }));
    for (;;)
    {
      if (localArrayList.size() > 0) {
        str1 = (String)localArrayList.get((int)(Math.random() * localArrayList.size()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.worldcup.record", 2, String.format("selectCoverVideo, path: %s", new Object[] { str1 }));
      }
      return str1;
      label371:
      QLog.d("Q.worldcup.record", 2, String.format("selectCoverPath, res2Path: %s is not exits", new Object[] { localObject1 }));
    }
  }
  
  public String a(ArrayList paramArrayList, String paramString1, String paramString2)
  {
    String str = a("merge_");
    long l1;
    int n;
    int i;
    boolean bool;
    long l4;
    Object localObject;
    int k;
    label81:
    int m;
    label97:
    long l2;
    int i2;
    label127:
    long l3;
    label248:
    long l5;
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      QLog.e("Q.worldcup.record", 1, "merge video record video is empty!");
      paramArrayList = new ArrayList();
      l1 = 0L;
      n = 0;
      i = 0;
      bool = a();
      l4 = System.currentTimeMillis();
      localObject = b(paramString1);
      if (!FileUtil.a((String)localObject)) {
        break label583;
      }
      paramArrayList.add(0, localObject);
      k = 1;
      if (!FileUtil.a(paramString2)) {
        break label610;
      }
      paramArrayList.add(paramString2);
      m = 1;
      l2 = System.currentTimeMillis();
      i2 = ARWorldCupRecordDpc.a().a;
      if (i2 != 1) {
        break label636;
      }
      this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupFFmpegVideoProcessor.a(paramArrayList, str);
      l3 = System.currentTimeMillis();
      if (!FileUtil.a(str)) {
        break label707;
      }
      localObject = b();
      paramArrayList = a("result_");
      if (!FileUtil.a((String)localObject)) {
        break label671;
      }
      l1 = System.currentTimeMillis();
      if (!bool) {
        break label650;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupHWVideoProcessor.a(str, (String)localObject, paramArrayList, a(str)))
      {
        i = 1;
        this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupFFmpegVideoProcessor.a(str, (String)localObject, paramArrayList, a(str));
        QLog.e("Q.worldcup.record", 1, "hw mergeAudio fail, use ffmpeg merge");
        BaseApplicationImpl.getContext().getSharedPreferences("world_cup_record", 0).edit().putBoolean("KEY_ENABLE_HW_MERGE_AUDIO", false).commit();
      }
      l5 = System.currentTimeMillis();
      if (!FileUtil.a(paramArrayList)) {
        break label804;
      }
      new File(str).delete();
    }
    for (int j = 1;; j = 0)
    {
      l1 = l5 - l1;
      label283:
      int i1 = 1;
      n = j;
      j = i1;
      for (;;)
      {
        label294:
        l4 = System.currentTimeMillis() - l4;
        localObject = new HashMap();
        ((HashMap)localObject).put("totalCost", String.valueOf(l4));
        ((HashMap)localObject).put("mergeCost", String.valueOf(l3 - l2));
        ((HashMap)localObject).put("addAudioCost", String.valueOf(l1));
        if (j != 0)
        {
          str = "1";
          label366:
          ((HashMap)localObject).put("isMergeSuc", str);
          if (n == 0) {
            break label753;
          }
          str = "1";
          label387:
          ((HashMap)localObject).put("isAddAudioSuc", str);
          if (k == 0) {
            break label761;
          }
          str = "1";
          label408:
          ((HashMap)localObject).put("isCoverExist", str);
          if (m == 0) {
            break label769;
          }
          str = "1";
          label429:
          ((HashMap)localObject).put("isGameVideoExist", str);
          ((HashMap)localObject).put("mergeModel", String.valueOf(i2));
          if (!bool) {
            break label777;
          }
          str = "0";
          label464:
          ((HashMap)localObject).put("mergeAudioMode", str);
          if (i == 0) {
            break label785;
          }
        }
        label650:
        label785:
        for (str = "1";; str = "0")
        {
          ((HashMap)localObject).put("isHWMergeAudioFail", str);
          StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "worldcup_record_merge_cost", true, 0L, 0L, (HashMap)localObject, "");
          if (QLog.isColorLevel()) {
            QLog.d("Q.worldcup.record", 2, String.format("makeRecordVideo| cost: %sms, path: %s, coverPicPath: %s, gameVideoPath:%s, mergeModel: %s", new Object[] { Long.valueOf(l4), paramArrayList, paramString1, paramString2, Integer.valueOf(i2) }));
          }
          return paramArrayList;
          paramArrayList = new ArrayList(paramArrayList);
          break;
          label583:
          QLog.e("Q.worldcup.record", 1, String.format("makeRecordVideo| coverVideoPath: %s is not exist", new Object[] { localObject }));
          k = 0;
          break label81;
          label610:
          QLog.e("Q.worldcup.record", 1, String.format("makeRecordVideo| gameVideoPath: %s is not exist", new Object[] { paramString2 }));
          m = 0;
          break label97;
          label636:
          this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupFFmpegVideoProcessor.b(paramArrayList, str);
          break label127;
          this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupFFmpegVideoProcessor.a(str, (String)localObject, paramArrayList, a(str));
          break label248;
          label671:
          QLog.e("Q.worldcup.record", 1, String.format("makeRecordVideo| audioPath: %s is not exits", new Object[] { localObject }));
          i = 0;
          l1 = 0L;
          paramArrayList = str;
          j = 0;
          break label283;
          label707:
          if (!FileUtil.a(paramString2)) {
            break label793;
          }
          QLog.e("Q.worldcup.record", 1, String.format("merge fail use gameVideoPath: %s", new Object[] { paramString2 }));
          i = 0;
          j = 0;
          paramArrayList = paramString2;
          break label294;
          str = "0";
          break label366;
          label753:
          str = "0";
          break label387;
          label761:
          str = "0";
          break label408;
          str = "0";
          break label429;
          str = "1";
          break label464;
        }
        label769:
        label777:
        label793:
        i = 0;
        j = 0;
        paramArrayList = null;
      }
      label804:
      paramArrayList = str;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("world_cup_record", 0);
    boolean bool1 = localSharedPreferences.getBoolean("enable_hw_encode_cover_video", true);
    long l = System.currentTimeMillis();
    boolean bool2;
    if (bool1)
    {
      bool2 = this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupHWVideoProcessor.a(paramString1, paramString2);
      if (bool2) {
        break label253;
      }
      QLog.e("Q.worldcup.record", 1, "hw encode fail! use soft encode");
      bool2 = this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupFFmpegVideoProcessor.a(paramString1, paramString2);
      localSharedPreferences.edit().putBoolean("enable_hw_encode_cover_video", false).commit();
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.worldcup.record", 2, String.format("makeCoverVideo, encode: %s, isSuc: %s, isSoftEncode: %s, cost: %s", new Object[] { paramString1, Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(System.currentTimeMillis() - l) }));
      }
      if (jdField_a_of_type_Boolean)
      {
        jdField_a_of_type_Boolean = false;
        paramString2 = new HashMap();
        if (!bool2) {
          break label239;
        }
        paramString1 = "1";
        label172:
        paramString2.put("isSuc", paramString1);
        if (!bool1) {
          break label246;
        }
      }
      label239:
      label246:
      for (paramString1 = "1";; paramString1 = "0")
      {
        paramString2.put("isSoftEncode", paramString1);
        StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "worldcup_cover_video", true, 0L, 1L, paramString2, "");
        return bool2;
        bool2 = this.jdField_a_of_type_ComTencentMobileqqArARRecordWorldcupFFmpegVideoProcessor.a(paramString1, paramString2);
        bool1 = true;
        break;
        paramString1 = "0";
        break label172;
      }
      label253:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.worldcup.VideoProcessor
 * JD-Core Version:    0.7.0.1
 */