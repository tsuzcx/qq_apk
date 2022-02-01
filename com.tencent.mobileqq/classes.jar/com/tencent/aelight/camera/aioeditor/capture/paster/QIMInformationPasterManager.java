package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.capture.IQIMManager;
import com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerSaveUtils;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFaceConstant;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(16)
public class QIMInformationPasterManager
  extends IQIMManager
{
  private static File c;
  private static String d;
  QIMInformationPasterManager.InformationPasterResDownloader a = null;
  private Context b;
  private ConcurrentLinkedQueue<InformationFacePackage.Item> e = new ConcurrentLinkedQueue();
  private RelativeLayout f = null;
  private WeakReference<RelativeLayout> g = null;
  
  private boolean d(InformationFacePackage.Item paramItem)
  {
    Object localObject = c;
    if (localObject != null)
    {
      if (!((File)localObject).exists())
      {
        c.mkdirs();
      }
      else if (!c.isDirectory())
      {
        c.delete();
        c.mkdirs();
      }
      localObject = c.list();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        boolean bool2;
        for (boolean bool1 = false; i < j; bool1 = bool2)
        {
          String str = localObject[i];
          bool2 = bool1;
          if (str.startsWith(paramItem.i))
          {
            StringBuilder localStringBuilder;
            if (str.endsWith(".zip"))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(c);
              localStringBuilder.append(str);
              FileUtils.delete(localStringBuilder.toString(), false);
              bool2 = bool1;
            }
            else if (str.endsWith(paramItem.h))
            {
              bool2 = true;
            }
            else
            {
              bool2 = bool1;
              if (!str.endsWith("png"))
              {
                bool2 = bool1;
                if (!str.endsWith("tmp"))
                {
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(d);
                  localStringBuilder.append(str);
                  FileUtils.delete(localStringBuilder.toString(), false);
                  bool2 = bool1;
                }
              }
            }
          }
          i += 1;
        }
        return bool1;
      }
    }
    return false;
  }
  
  public void a()
  {
    if (this.f != null)
    {
      Object localObject = this.g;
      if (localObject != null)
      {
        localObject = (RelativeLayout)((WeakReference)localObject).get();
        if (localObject != null)
        {
          ((RelativeLayout)localObject).removeView(this.f);
          this.g = null;
          this.f = null;
        }
      }
    }
  }
  
  public void a(InformationFacePackage.Item paramItem, QIMInformationPasterManager.IInformationPasterResDownloaderCallback paramIInformationPasterResDownloaderCallback)
  {
    if (!NetworkUtil.isNetworkAvailable(this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
      return;
    }
    ThreadManager.postImmediately(new QIMInformationPasterManager.1(this, paramItem, paramIInformationPasterResDownloaderCallback), null, true);
  }
  
  public void a(DoodleEmojiItem paramDoodleEmojiItem)
  {
    paramDoodleEmojiItem = paramDoodleEmojiItem.mInfoItemList.iterator();
    while (paramDoodleEmojiItem.hasNext())
    {
      InformationFacePackage.Item localItem = (InformationFacePackage.Item)paramDoodleEmojiItem.next();
      if ((localItem.f == 1) && (!a(localItem))) {
        a(localItem, new QIMInformationPasterManager.3(this));
      }
    }
  }
  
  public void a(List<InformationFacePackage.Item> paramList)
  {
    ThreadManager.postImmediately(new QIMInformationPasterManager.2(this, paramList), null, true);
  }
  
  public boolean a(InformationFacePackage.Item paramItem)
  {
    if (TextUtils.isEmpty(paramItem.g)) {
      return paramItem.c != 7;
    }
    if (!d(paramItem)) {
      return false;
    }
    Object localObject = InfoStickerSaveUtils.b(paramItem);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkDir:");
      localStringBuilder.append((String)localObject);
      QLog.d("QIMInformationPasterManager", 2, localStringBuilder.toString());
    }
    localObject = new File((String)localObject);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).list();
      if ((localObject != null) && (localObject.length == InformationFaceConstant.a(paramItem))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b(InformationFacePackage.Item paramItem)
  {
    return this.a.a(paramItem.g);
  }
  
  public void c()
  {
    this.b = BaseApplication.getContext();
    c = InfoStickerSaveUtils.a();
    d = InfoStickerSaveUtils.b();
  }
  
  public boolean c(InformationFacePackage.Item paramItem)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(d);
      ((StringBuilder)localObject).append(paramItem.i);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramItem.h);
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("unzipDir:");
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        QLog.d("QIMInformationPasterManager", 2, localStringBuilder.toString());
      }
      paramItem = new File(InfoStickerSaveUtils.a(paramItem));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      localStringBuilder.append(File.separator);
      ZipUtils.unZipFile(paramItem, localStringBuilder.toString());
      return true;
    }
    catch (Exception paramItem)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, paramItem, new Object[0]);
      }
    }
    return false;
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager
 * JD-Core Version:    0.7.0.1
 */