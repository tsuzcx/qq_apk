package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.IQIMManager;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMFileUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class QIMPasterConfigManager
  extends IQIMManager
{
  public static final File a = new File(QIMFileUtils.a(), "dov_doodle_sticker");
  private ArrayList<DoodleEmojiItem> b;
  
  private ArrayList<DoodleEmojiItem> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList(4);
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("category");
      localArrayList.ensureCapacity(paramString.length());
      int i = 0;
      while (i < paramString.length())
      {
        DoodleEmojiItem localDoodleEmojiItem = DoodleEmojiItem.getDoodleEmojiItemFromJsonObj(paramString.getJSONObject(i));
        if (localDoodleEmojiItem != null) {
          localArrayList.add(localDoodleEmojiItem);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QIMPasterConfigManager", 2, QLog.getStackTraceString(paramString));
      }
    }
    return localArrayList;
  }
  
  public static boolean b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("doodle_sticker_config.cfg");
    boolean bool = new File(localStringBuilder.toString()).exists();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QIMPasterConfigManager isStickerConfigFileExist=");
      localStringBuilder.append(bool);
      QLog.i("QIMPasterConfigManager", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public ArrayList<DoodleEmojiItem> a()
  {
    if (this.b == null) {}
    for (;;)
    {
      try
      {
        if (this.b == null)
        {
          Object localObject1 = QIMFileUtils.a(a, "doodle_sticker_config.cfg");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            this.b = b((String)localObject1);
          }
          bool1 = QLog.isColorLevel();
          boolean bool2 = true;
          if (bool1)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("initStickerConfigFromCache result:");
            if (this.b == null) {
              break label188;
            }
            bool1 = true;
            ((StringBuilder)localObject1).append(bool1);
            QLog.i("QIMPasterConfigManager", 2, ((StringBuilder)localObject1).toString());
          }
          if ((this.b == null) || (this.b.size() == 0))
          {
            this.b = b(QIMFileUtils.a("doodle_sticker.cfg"));
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("initStickerConfigFromAssets result:");
              if (this.b == null) {
                break label193;
              }
              bool1 = bool2;
              ((StringBuilder)localObject1).append(bool1);
              QLog.i("QIMPasterConfigManager", 2, ((StringBuilder)localObject1).toString());
            }
          }
        }
      }
      finally {}
      return this.b;
      label188:
      boolean bool1 = false;
      continue;
      label193:
      bool1 = false;
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = b(paramString);
    boolean bool = true;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      this.b = ((ArrayList)localObject);
      localObject = (PasterDataManager)QIMManager.a().d(4);
      if (((PasterDataManager)localObject).g != null) {
        ((PasterDataManager)localObject).g.clear();
      }
      ((DoodleEmojiManager)QIMManager.a(14)).a(this.b);
      g().notifyObservers(CaptureConfigUpdateObserver.class, 4, true, null);
      if (QLog.isColorLevel()) {
        QLog.i("QIMPasterConfigManager", 2, "paster config send notify");
      }
      QIMFileUtils.a(a, "doodle_sticker_config.cfg", paramString);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("paster config handleConfig");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" result:");
      if (this.b == null) {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.i("QIMPasterConfigManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c()
  {
    a();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.QIMPasterConfigManager
 * JD-Core Version:    0.7.0.1
 */