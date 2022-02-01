package com.tencent.aelight.camera.ae.gif.video;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import org.light.device.LightDeviceUtils;

public class PngsCreateWorkingQueue
{
  private static String jdField_a_of_type_JavaLangString = "PngsCreateWorkingQueue";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PngCreateResult jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngCreateResult = new PngCreateResult();
  private PngsCreateWorkingQueue.Callback jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreateWorkingQueue$Callback;
  private PngsCreator jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreator;
  private String b;
  
  public PngsCreateWorkingQueue(String paramString1, List<PTFaceAttr> paramList, String paramString2, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreator = new PngsCreator(paramString1, paramList);
    paramString1 = new HandlerThread("PngsCreateWorkingQueue");
    paramString1.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramString1.getLooper());
    this.b = paramString2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngCreateResult.a.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clear frame files, dir = ");
      localStringBuilder.append(str1);
      QLog.d(str2, 4, localStringBuilder.toString());
      FileUtils.deleteDirectory(str1);
    }
  }
  
  private void b(MaterialWrapper paramMaterialWrapper)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "";
    Semaphore localSemaphore = new Semaphore(0);
    AEGIFTextColorConfig.SmartTextColor localSmartTextColor = (AEGIFTextColorConfig.SmartTextColor)AEGIFTextColorConfig.jdField_a_of_type_JavaUtilList.get(AEGIFTextColorConfig.jdField_a_of_type_ArrayOfInt[(paramMaterialWrapper.jdField_a_of_type_Int % AEGIFTextColorConfig.jdField_a_of_type_ArrayOfInt.length)]);
    float f1;
    float f2;
    if (paramMaterialWrapper.b.contains("\n"))
    {
      f1 = 0.67F;
      f2 = 0.3F;
    }
    else
    {
      f1 = 0.81F;
      f2 = 0.16F;
    }
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    int j;
    if (localContext != null) {
      j = (int)(LightDeviceUtils.getScreenWidth(localContext) * 0.44F) + 1;
    } else {
      j = 1920;
    }
    localContext = this.jdField_a_of_type_AndroidContentContext;
    int i;
    if (localContext != null) {
      i = DisplayUtil.a(localContext, 2.0F) * 320 / j;
    } else {
      i = 5;
    }
    localContext = this.jdField_a_of_type_AndroidContentContext;
    if (localContext != null) {
      j = DisplayUtil.c(localContext, 23.0F) * 320 / j;
    } else {
      j = 19;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreator.a(paramMaterialWrapper.b, j, localSmartTextColor.jdField_a_of_type_JavaLangString, localSmartTextColor.b, i, this.b, 0.0F, f1, 1.0F, f2);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreator.a(paramMaterialWrapper.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreator.a(new PngsCreateWorkingQueue.2(this, paramMaterialWrapper, arrayOfString, localSemaphore));
    try
    {
      localSemaphore.acquire();
      if (this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreateWorkingQueue$Callback != null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreateWorkingQueue$Callback.a(paramMaterialWrapper.jdField_a_of_type_Int, arrayOfString[0]);
        return;
      }
    }
    catch (InterruptedException paramMaterialWrapper)
    {
      paramMaterialWrapper.printStackTrace();
    }
  }
  
  public PngCreateResult a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngCreateResult;
  }
  
  public void a(MaterialWrapper paramMaterialWrapper)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreateWorkingQueue.1(this, paramMaterialWrapper));
  }
  
  public void a(PngsCreateWorkingQueue.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoPngsCreateWorkingQueue$Callback = paramCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop, clearFiles = ");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 4, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreateWorkingQueue.3(this, paramBoolean));
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue
 * JD-Core Version:    0.7.0.1
 */