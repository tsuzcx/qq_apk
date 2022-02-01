package com.tencent.biz.troop;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegCommandUnit;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class VideoCombineHelper$CombineTask
  extends VideoCombineHelper.Task
{
  List<String> a;
  String b;
  String c;
  int d = 0;
  
  public VideoCombineHelper$CombineTask(VideoCombineHelper.TaskListener paramTaskListener, String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    super(paramTaskListener, paramString1, paramList);
    this.b = paramString3;
    Object localObject;
    this.c = localObject;
    this.a = paramString2;
    this.h = new VideoCombineHelper.SendingTask(paramTaskListener, paramString1, paramList);
  }
  
  public File a(File paramFile, String paramString, VideoCombineHelper.Callback paramCallback)
  {
    Object localObject1 = new MediaMetadataRetriever();
    ((MediaMetadataRetriever)localObject1).setDataSource(paramFile.getAbsolutePath());
    String str1 = ((MediaMetadataRetriever)localObject1).extractMetadata(18);
    String str2 = ((MediaMetadataRetriever)localObject1).extractMetadata(19);
    ((MediaMetadataRetriever)localObject1).release();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramFile.getParent());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("wording.png");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramFile.getParent());
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("vmw.mp4");
    localObject2 = ((StringBuilder)localObject2).toString();
    try
    {
      int i = Integer.parseInt(str1);
      int j = Integer.parseInt(str2);
      long l = System.currentTimeMillis();
      a(i, j, paramString, (String)localObject1);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("createWatermarkPng time = ");
        paramString.append(System.currentTimeMillis() - l);
        QLog.d(".troop.trace_video_combine", 2, paramString.toString());
      }
      c().k.add(new File((String)localObject1));
      this.e.c.watermark((String)localObject1, paramFile.getAbsolutePath(), (String)localObject2, i, j, new VideoCombineHelper.CombineTask.6(this, paramCallback, (String)localObject2));
    }
    catch (Exception paramFile)
    {
      QLog.e(".troop.VideoCombineHelper", 2, "combineWording failed!", paramFile);
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(d());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("v.ts");
      localObject = ((StringBuilder)localObject).toString();
      VideoCombineHelper.CombineParams localCombineParams = c();
      if (localCombineParams.b)
      {
        this.f.b(this);
        return;
      }
      a(this.a, (String)localObject, new VideoCombineHelper.CombineTask.1(this, localCombineParams));
    }
  }
  
  public void a(List<String> paramList, String paramString, VideoCombineHelper.Callback paramCallback)
  {
    if ((paramList != null) && (this.a.size() != 0))
    {
      if (paramList.size() == 1)
      {
        paramCallback.a((String)this.a.get(0), true, "combineVideos Success size = 1");
        return;
      }
      try
      {
        long l = System.currentTimeMillis();
        paramList = new File(paramString);
        a(this.a, paramList.getAbsolutePath(), new VideoCombineHelper.CombineTask.2(this, l, paramCallback, paramList));
        return;
      }
      catch (Exception paramList)
      {
        QLog.e(".troop.VideoCombineHelper", 2, "combineVideos failed", paramList);
        return;
      }
    }
    paramCallback.a("", false, "videoFiles empty!");
  }
  
  public void a(List<String> paramList, String paramString, VideoCombineHelper.FFmpegCallback paramFFmpegCallback)
  {
    Object localObject1 = new File(paramString);
    if ((((File)localObject1).exists()) && (((File)localObject1).length() > 0L))
    {
      paramFFmpegCallback.a(true);
      return;
    }
    localObject1 = new ArrayList();
    this.e.b = System.currentTimeMillis();
    StringBuffer localStringBuffer = new StringBuffer("concat:");
    int i = 0;
    while (i < paramList.size())
    {
      localObject2 = (String)paramList.get(i);
      Object localObject3 = new File((String)localObject2);
      Object localObject4 = ((File)localObject3).getName().split("\\.");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject3).getAbsoluteFile().getParent());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(localObject4[0]);
      localStringBuilder.append(".ts");
      localObject3 = localStringBuilder.toString();
      localStringBuffer.append((String)localObject3);
      if (i != paramList.size() - 1) {
        localStringBuffer.append("|");
      }
      localObject4 = new File((String)localObject3);
      if ((!((File)localObject4).exists()) || (((File)localObject4).length() <= 0L))
      {
        if (!((File)localObject4).getParentFile().exists()) {
          ((File)localObject4).getParentFile().mkdirs();
        }
        localObject4 = new FFmpegCommandUnit();
        ((FFmpegCommandUnit)localObject4).cmdType = 5;
        ((FFmpegCommandUnit)localObject4).arguments = new VideoCombineHelper.CombineTask.3(this, (String)localObject2, (String)localObject3);
        ((FFmpegCommandUnit)localObject4).callback = new VideoCombineHelper.CombineTask.4(this, paramFFmpegCallback);
        ((ArrayList)localObject1).add(localObject4);
      }
      i += 1;
    }
    paramList = new File(paramString);
    paramString = paramList.getName().split("\\.");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramList.getParent());
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append(paramString[0]);
    ((StringBuilder)localObject2).append(".ts");
    paramList = ((StringBuilder)localObject2).toString();
    paramString = new FFmpegCommandUnit();
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add("-y");
    ((ArrayList)localObject2).add("-i");
    ((ArrayList)localObject2).add(localStringBuffer.toString());
    ((ArrayList)localObject2).add("-c");
    ((ArrayList)localObject2).add("copy");
    ((ArrayList)localObject2).add(paramList);
    paramString.cmd = ((String[])((ArrayList)localObject2).toArray(new String[0]));
    paramString.callback = paramFFmpegCallback;
    ((ArrayList)localObject1).add(paramString);
    if (this.e.c.isFFmpegCommandRunning()) {
      try
      {
        this.e.c.insertFFmpegQueue((ArrayList)localObject1);
        return;
      }
      catch (IOException paramList)
      {
        paramList.printStackTrace();
        return;
      }
      catch (FFmpegCommandAlreadyRunningException paramList)
      {
        paramList.printStackTrace();
        return;
      }
    }
    try
    {
      this.e.c.cmdFFmpegQueue((ArrayList)localObject1);
      return;
    }
    catch (IOException paramList)
    {
      paramList.printStackTrace();
      return;
    }
    catch (FFmpegCommandAlreadyRunningException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint1 = new Paint();
      localPaint1.setColor(-1);
      localPaint1.setTextSize(30.0F);
      localPaint1.setTextAlign(Paint.Align.CENTER);
      Rect localRect = new Rect();
      localPaint1.getTextBounds(paramString1, 0, paramString1.length(), localRect);
      Paint localPaint2 = new Paint();
      localPaint2.setColor(-16777216);
      RectF localRectF = new RectF();
      localRectF.top = (paramInt2 - localRect.height() - 15 - 15);
      localRectF.left = ((paramInt1 - localRect.width()) / 2 - 15);
      localRectF.bottom = (localRectF.top + localRect.height() + 15);
      localRectF.right = (localRectF.left + localRect.width() + 30);
      localCanvas.drawRoundRect(localRectF, 8.0F, 8.0F, localPaint2);
      localCanvas.drawText(paramString1, paramInt1 / 2, paramInt2 - 15 - localRect.height() / 2, localPaint1);
      BitmapUtils.a(localBitmap, Bitmap.CompressFormat.PNG, 100, paramString2);
      BitmapUtils.a(localBitmap);
      return true;
    }
    catch (Throwable paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.VideoCombineHelper", 2, "createWatermarkByWording", paramString1);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.CombineTask
 * JD-Core Version:    0.7.0.1
 */