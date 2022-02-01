package com.tencent.aelight.camera.ae.gif.video;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aelight.camera.ae.AEPath.GIF.CACHE;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextDrawer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PngsTextDrawer
{
  private static String a = "GIFCreator";
  private String b = AEPath.GIF.CACHE.b;
  private Handler c;
  private int d = 320;
  private int e = 320;
  private int f;
  private int g;
  private String h;
  private AEGIFTextDrawer i;
  private PngsTextDrawer.Callback j;
  
  public PngsTextDrawer(String paramString)
  {
    this.h = paramString;
    paramString = new StringBuilder();
    paramString.append("PngsTextDrawerHT");
    paramString.append(System.currentTimeMillis());
    paramString = new HandlerThread(paramString.toString());
    paramString.start();
    this.c = new Handler(paramString.getLooper());
  }
  
  private List<String> a(String paramString)
  {
    String[] arrayOfString = new File(paramString).list();
    Arrays.sort(arrayOfString);
    ArrayList localArrayList = new ArrayList();
    int m = arrayOfString.length;
    int k = 0;
    while (k < m)
    {
      String str = arrayOfString[k];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      localArrayList.add(localStringBuilder.toString());
      k += 1;
    }
    return localArrayList;
  }
  
  public void a(PngsTextDrawer.Callback paramCallback)
  {
    this.j = paramCallback;
    QLog.d(a, 4, "start add text to png");
    this.c.post(new PngsTextDrawer.2(this, paramCallback));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.c.post(new PngsTextDrawer.1(this, paramFloat3, paramFloat4, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramString4, paramFloat1, paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.PngsTextDrawer
 * JD-Core Version:    0.7.0.1
 */