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
  private static String a = "PngsCreateWorkingQueue";
  private Handler b;
  private PngsCreator c;
  private PngCreateResult d = new PngCreateResult();
  private PngsCreateWorkingQueue.Callback e;
  private Context f;
  private String g;
  
  public PngsCreateWorkingQueue(String paramString1, List<PTFaceAttr> paramList, String paramString2, Context paramContext)
  {
    this.c = new PngsCreator(paramString1, paramList);
    paramString1 = new HandlerThread("PngsCreateWorkingQueue");
    paramString1.start();
    this.b = new Handler(paramString1.getLooper());
    this.g = paramString2;
    this.f = paramContext;
  }
  
  private void b(MaterialWrapper paramMaterialWrapper)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "";
    Semaphore localSemaphore = new Semaphore(0);
    AEGIFTextColorConfig.SmartTextColor localSmartTextColor = (AEGIFTextColorConfig.SmartTextColor)AEGIFTextColorConfig.b.get(AEGIFTextColorConfig.a[(paramMaterialWrapper.a % AEGIFTextColorConfig.a.length)]);
    float f1;
    float f2;
    if (paramMaterialWrapper.c.contains("\n"))
    {
      f1 = 0.67F;
      f2 = 0.3F;
    }
    else
    {
      f1 = 0.81F;
      f2 = 0.16F;
    }
    Context localContext = this.f;
    int j;
    if (localContext != null) {
      j = (int)(LightDeviceUtils.getScreenWidth(localContext) * 0.44F) + 1;
    } else {
      j = 1920;
    }
    localContext = this.f;
    int i;
    if (localContext != null) {
      i = DisplayUtil.a(localContext, 2.0F) * 320 / j;
    } else {
      i = 5;
    }
    localContext = this.f;
    if (localContext != null) {
      j = DisplayUtil.c(localContext, 23.0F) * 320 / j;
    } else {
      j = 19;
    }
    this.c.a(paramMaterialWrapper.c, j, localSmartTextColor.a, localSmartTextColor.b, i, this.g, 0.0F, f1, 1.0F, f2);
    this.c.a(paramMaterialWrapper.b);
    this.c.a(new PngsCreateWorkingQueue.2(this, paramMaterialWrapper, arrayOfString, localSemaphore));
    try
    {
      localSemaphore.acquire();
      if (this.e != null)
      {
        this.e.a(paramMaterialWrapper.a, arrayOfString[0]);
        return;
      }
    }
    catch (InterruptedException paramMaterialWrapper)
    {
      paramMaterialWrapper.printStackTrace();
    }
  }
  
  private void c()
  {
    Iterator localIterator = this.d.a.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clear frame files, dir = ");
      localStringBuilder.append(str1);
      QLog.d(str2, 4, localStringBuilder.toString());
      FileUtils.deleteDirectory(str1);
    }
  }
  
  public PngCreateResult a()
  {
    return this.d;
  }
  
  public void a(MaterialWrapper paramMaterialWrapper)
  {
    this.b.post(new PngsCreateWorkingQueue.1(this, paramMaterialWrapper));
  }
  
  public void a(PngsCreateWorkingQueue.Callback paramCallback)
  {
    this.e = paramCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop, clearFiles = ");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 4, localStringBuilder.toString());
    this.b.removeCallbacksAndMessages(null);
    this.b.post(new PngsCreateWorkingQueue.3(this, paramBoolean));
    this.f = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue
 * JD-Core Version:    0.7.0.1
 */