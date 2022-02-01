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
  private static File jdField_a_of_type_JavaIoFile;
  private static String jdField_a_of_type_JavaLangString;
  private Context jdField_a_of_type_AndroidContentContext;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  QIMInformationPasterManager.InformationPasterResDownloader jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterQIMInformationPasterManager$InformationPasterResDownloader = null;
  private WeakReference<RelativeLayout> jdField_a_of_type_JavaLangRefWeakReference = null;
  private ConcurrentLinkedQueue<InformationFacePackage.Item> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private boolean d(InformationFacePackage.Item paramItem)
  {
    Object localObject = jdField_a_of_type_JavaIoFile;
    if (localObject != null)
    {
      if (!((File)localObject).exists())
      {
        jdField_a_of_type_JavaIoFile.mkdirs();
      }
      else if (!jdField_a_of_type_JavaIoFile.isDirectory())
      {
        jdField_a_of_type_JavaIoFile.delete();
        jdField_a_of_type_JavaIoFile.mkdirs();
      }
      localObject = jdField_a_of_type_JavaIoFile.list();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        boolean bool2;
        for (boolean bool1 = false; i < j; bool1 = bool2)
        {
          String str = localObject[i];
          bool2 = bool1;
          if (str.startsWith(paramItem.g))
          {
            StringBuilder localStringBuilder;
            if (str.endsWith(".zip"))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(jdField_a_of_type_JavaIoFile);
              localStringBuilder.append(str);
              FileUtils.delete(localStringBuilder.toString(), false);
              bool2 = bool1;
            }
            else if (str.endsWith(paramItem.f))
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
                  localStringBuilder.append(jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
    jdField_a_of_type_JavaIoFile = InfoStickerSaveUtils.a();
    jdField_a_of_type_JavaLangString = InfoStickerSaveUtils.a();
  }
  
  public void a(InformationFacePackage.Item paramItem, QIMInformationPasterManager.IInformationPasterResDownloaderCallback paramIInformationPasterResDownloaderCallback)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
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
      if ((localItem.b == 1) && (!a(localItem))) {
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
    if (TextUtils.isEmpty(paramItem.e)) {
      return paramItem.a != 7;
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
  
  public void b() {}
  
  public boolean b(InformationFacePackage.Item paramItem)
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterQIMInformationPasterManager$InformationPasterResDownloader.a(paramItem.e);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        localObject = (RelativeLayout)((WeakReference)localObject).get();
        if (localObject != null)
        {
          ((RelativeLayout)localObject).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
          this.jdField_a_of_type_JavaLangRefWeakReference = null;
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
        }
      }
    }
  }
  
  public boolean c(InformationFacePackage.Item paramItem)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(paramItem.g);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramItem.f);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager
 * JD-Core Version:    0.7.0.1
 */