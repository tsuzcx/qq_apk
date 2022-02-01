package com.tencent.biz.qqstory.utils.ffmpeg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import bfvo;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.widget.InteractContainerLayout;
import com.tencent.biz.qqstory.widget.PollContainerLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import vkm;
import vwg;
import vwh;
import wkp;
import xvv;
import yoy;
import ypi;

public class FFmpegUtils
{
  protected static final int DOWNLOAD_WATERMARK_WIDTH_IN_PIX = 30;
  public static final String UNI_TASK_DOWNLOAD_MYDAY = "download_myday_taskuni";
  public static final boolean USE_CLIENT_WATERMARK = false;
  public static final SimpleDateFormat sVidSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.CHINESE);
  
  private static void _combinBackgroundMusic(boolean paramBoolean1, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, boolean paramBoolean2, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = getAuidoType(paramString2);
    Object localObject2 = new File(vkm.f);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(vkm.f);
    ((StringBuffer)localObject2).append(paramString2.hashCode());
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(paramInt1);
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(paramInt2);
    ((StringBuffer)localObject2).append((String)localObject1);
    localObject2 = new String((StringBuffer)localObject2);
    localObject1 = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 3;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.6(paramString2, (String)localObject2, paramInt1, paramInt2);
    localFFmpegCommandUnit.callback = new FFmpegUtils.7(paramExecuteBinResponseCallback);
    ((ArrayList)localObject1).add(localFFmpegCommandUnit);
    paramString2 = new FFmpegCommandUnit();
    paramString2.cmdType = 4;
    paramString2.arguments = new FFmpegUtils.8(paramString1, (String)localObject2, paramString3, paramString4, paramBoolean2, paramInt2);
    paramString2.callback = new FFmpegUtils.9(paramExecuteBinResponseCallback, (String)localObject2, l);
    ((ArrayList)localObject1).add(paramString2);
    if (paramBoolean1) {}
    for (paramContext = FFmpeg.newInstance(paramContext, true); paramContext.isFFmpegCommandRunning(); paramContext = FFmpeg.getInstance(paramContext, true))
    {
      paramContext.insertFFmpegQueue((ArrayList)localObject1);
      return;
    }
    paramContext.cmdFFmpegQueue((ArrayList)localObject1);
  }
  
  public static void changeOrientationInVideo(Context paramContext, String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 12;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.1(paramString1, paramString2, paramString3);
    localFFmpegCommandUnit.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.getInstance(paramContext);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(localArrayList);
      return;
    }
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  private static void clipAudio(PublishVideoEntry paramPublishVideoEntry, ExecuteBinResponseCallback paramExecuteBinResponseCallback, String paramString1, int paramInt1, int paramInt2, String paramString2, ArrayList<FFmpegCommandUnit> paramArrayList)
  {
    if (ypi.b(paramString2)) {
      ypi.f(paramString2);
    }
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 3;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.12(paramString1, paramString2, paramInt1, paramInt2);
    localFFmpegCommandUnit.callback = new FFmpegUtils.13(paramExecuteBinResponseCallback, paramPublishVideoEntry);
    paramArrayList.add(localFFmpegCommandUnit);
  }
  
  public static void combinBackgroundMusic(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    combinBackgroundMusic(paramContext, paramString1, paramString2, paramInt1, paramInt2, paramString3, true, paramExecuteBinResponseCallback);
  }
  
  public static void combinBackgroundMusic(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    _combinBackgroundMusic(false, paramContext, paramString1, paramString2, "copy", paramInt1, paramInt2, paramString3, paramBoolean, paramExecuteBinResponseCallback);
  }
  
  public static void combinBackgroundMusic(boolean paramBoolean, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    _combinBackgroundMusic(paramBoolean, paramContext, paramString1, paramString2, "copy", paramInt1, paramInt2, paramString3, false, paramExecuteBinResponseCallback);
  }
  
  public static void combinBackgroundMusicWithVideCodecH264(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    _combinBackgroundMusic(false, paramContext, paramString1, paramString2, "h264", paramInt1, paramInt2, paramString3, false, paramExecuteBinResponseCallback);
  }
  
  public static void combineDoodle(Context paramContext, String paramString1, String paramString2, String paramString3, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 15;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.10(paramString1, paramString2, paramString3);
    localFFmpegCommandUnit.callback = new FFmpegUtils.11(paramExecuteBinResponseCallback);
    paramString1 = new ArrayList();
    paramString1.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.getInstance(paramContext, true);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(paramString1);
      return;
    }
    paramContext.cmdFFmpegQueue(paramString1);
  }
  
  public static Bitmap combineTwoImg(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 == null) && (paramBitmap2 == null))
    {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "FFmpegUtils combineTwoImg error");
      localBitmap = null;
    }
    do
    {
      return localBitmap;
      localBitmap = paramBitmap2;
    } while (paramBitmap1 == null);
    if (paramBitmap2 == null) {
      return paramBitmap1;
    }
    int i = paramBitmap1.getWidth();
    int j = paramBitmap1.getHeight();
    int k = paramBitmap2.getWidth();
    int m = paramBitmap2.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, null);
    if ((i != k) || (j != m))
    {
      float f1 = i / k;
      float f2 = j / m;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f1, f2);
      localCanvas.drawBitmap(paramBitmap2, localMatrix, null);
    }
    for (;;)
    {
      localCanvas.save();
      paramBitmap1.recycle();
      paramBitmap2.recycle();
      return localBitmap;
      localCanvas.drawBitmap(paramBitmap2, 0.0F, 0.0F, null);
    }
  }
  
  public static boolean combineTwoImg(Bitmap paramBitmap1, Bitmap paramBitmap2, String paramString)
  {
    if ((paramBitmap1 == null) || (paramBitmap2 == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "FFmpegUtils combineTwoImg error");
      return false;
    }
    int i = paramBitmap1.getWidth();
    int j = paramBitmap1.getHeight();
    int k = paramBitmap2.getWidth();
    int m = paramBitmap2.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, null);
    if ((i != k) || (j != m))
    {
      float f1 = i / k;
      float f2 = j / m;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f1, f2);
      localCanvas.drawBitmap(paramBitmap2, localMatrix, null);
    }
    for (;;)
    {
      localCanvas.save();
      try
      {
        bfvo.a(localBitmap, new File(paramString));
        return true;
      }
      catch (IOException paramString)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "FFmpegUtils combineTwoImg IOException " + paramString.getMessage());
        return false;
      }
      finally
      {
        paramBitmap1.recycle();
        paramBitmap2.recycle();
      }
      localCanvas.drawBitmap(paramBitmap2, 0.0F, 0.0F, null);
    }
  }
  
  public static boolean combineTwoImg(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    do
    {
      return false;
      paramString2 = SafeBitmapFactory.decodeFile(paramString2);
      paramString1 = SafeBitmapFactory.decodeFile(paramString1);
    } while ((paramString2 == null) || (paramString1 == null));
    return combineTwoImg(paramString1, paramString2, paramString3);
  }
  
  private static void combineVideoAndAudio(String paramString1, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean, ExecuteBinResponseCallback paramExecuteBinResponseCallback, int paramInt, long paramLong, String paramString2, ArrayList<FFmpegCommandUnit> paramArrayList, String paramString3, String paramString4, String paramString5)
  {
    if (ypi.b(paramString1)) {
      ypi.f(paramString1);
    }
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 4;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.14(paramString5, paramString4, paramString1, paramBoolean, paramInt);
    localFFmpegCommandUnit.callback = new FFmpegUtils.15(paramExecuteBinResponseCallback, paramPublishVideoEntry, paramString2, paramString4, paramString5, paramString3, paramLong);
    paramArrayList.add(localFFmpegCommandUnit);
  }
  
  public static void compressLocalVideo(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 11;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.3(paramString1, paramInt1, paramInt2, paramInt3, paramBoolean, paramString2);
    localFFmpegCommandUnit.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.getInstance(paramContext);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(localArrayList);
      return;
    }
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  public static void compressVideoWithBitrate(String paramString1, String paramString2, int paramInt, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-b:v");
    localArrayList.add("" + paramInt);
    localArrayList.add("-profile:v");
    localArrayList.add("baseline");
    localArrayList.add("-bufsize");
    localArrayList.add("800k");
    localArrayList.add("-r");
    localArrayList.add("25");
    localArrayList.add("-c:a");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    FFmpeg.getInstance(BaseApplicationImpl.getApplication()).execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public static void convertPicToVideo(Context paramContext, String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 9;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.4(paramString1, paramString2);
    localFFmpegCommandUnit.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.getInstance(paramContext);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(localArrayList);
      return;
    }
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  public static void convertPicToVideoWidthDuration(Context paramContext, String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 20;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.5(paramString1, paramString2, paramString3);
    localFFmpegCommandUnit.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.getInstance(paramContext);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(localArrayList);
      return;
    }
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  public static void convertVideoToMp3(boolean paramBoolean, Context paramContext, String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 16;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.25(paramString1, paramString2);
    localFFmpegCommandUnit.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    if (paramBoolean) {}
    for (paramContext = FFmpeg.newInstance(paramContext, false); paramContext.isFFmpegCommandRunning(); paramContext = FFmpeg.getInstance(paramContext))
    {
      paramContext.insertFFmpegQueue(localArrayList);
      return;
    }
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  public static void detectMediaVolume(Context paramContext, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 22;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.24(paramString);
    localFFmpegCommandUnit.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.getInstance(paramContext);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(localArrayList);
      return;
    }
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  public static void generateGifFromVideoWithPalette(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-ss");
    localArrayList.add("0");
    localArrayList.add("-t");
    localArrayList.add("4");
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-i");
    localArrayList.add(paramString2);
    localArrayList.add("-lavfi");
    localArrayList.add("fps=18,scale=280:-1:flags=lanczos,paletteuse=dither=floyd_steinberg");
    localArrayList.add("-y");
    localArrayList.add(paramString3);
    FFmpeg.getInstance(BaseApplicationImpl.getApplication()).execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public static Bitmap generateInteractBitmap(vwg paramvwg, int paramInt1, int paramInt2)
  {
    if (paramvwg == null)
    {
      xvv.b("FFmpegUtils", "generate interact image failed. it's not a interacted video.");
      return null;
    }
    xvv.a("FFmpegUtils", "generateInteractWidgetImage, layout=%s, containerWidth=%s, containerHeight=%s", paramvwg, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    Object localObject = BaseApplicationImpl.getContext();
    InteractContainerLayout localInteractContainerLayout = new InteractContainerLayout((Context)localObject);
    localInteractContainerLayout.a(paramvwg, 0);
    localObject = new FrameLayout((Context)localObject);
    ((ViewGroup)localObject).setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    ((ViewGroup)localObject).addView(localInteractContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    ((ViewGroup)localObject).layout(0, 0, paramInt1, paramInt2);
    localInteractContainerLayout.a(paramvwg, 0);
    paramvwg = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (paramvwg != null)
    {
      ((ViewGroup)localObject).draw(new Canvas(paramvwg));
      return paramvwg;
    }
    xvv.d("FFmpegUtils", "generateInteractWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static String generateInteractWidgetImage(vwg paramvwg, int paramInt1, int paramInt2)
  {
    if (paramvwg == null)
    {
      xvv.b("FFmpegUtils", "generate interact image failed. it's not a interacted video.");
      return null;
    }
    xvv.a("FFmpegUtils", "generateInteractWidgetImage, layout=%s, containerWidth=%s, containerHeight=%s", paramvwg, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject = new InteractContainerLayout(localBaseApplication);
    ((InteractContainerLayout)localObject).a(paramvwg, 0);
    FrameLayout localFrameLayout = new FrameLayout(localBaseApplication);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    localFrameLayout.layout(0, 0, paramInt1, paramInt2);
    ((InteractContainerLayout)localObject).a(paramvwg, 0);
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (localObject != null)
    {
      localFrameLayout.draw(new Canvas((Bitmap)localObject));
      paramvwg = localBaseApplication.getCacheDir().getAbsolutePath() + "/grade-" + System.currentTimeMillis() + ".png";
      boolean bool = yoy.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 80, paramvwg);
      ((Bitmap)localObject).recycle();
      xvv.d("FFmpegUtils", "generateInteractWidgetImage compress success = %s, path = %s", new Object[] { Boolean.valueOf(bool), paramvwg });
      if (bool) {}
      for (;;)
      {
        return paramvwg;
        paramvwg = null;
      }
    }
    xvv.d("FFmpegUtils", "generateInteractWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static void generatePalettePNG(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-ss");
    localArrayList.add("0");
    localArrayList.add("-t");
    localArrayList.add("1");
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-vf");
    localArrayList.add("fps=18,scale=280:-1:flags=lanczos,palettegen=stats_mode=diff");
    localArrayList.add("-y");
    localArrayList.add(paramString2);
    FFmpeg.getInstance(BaseApplicationImpl.getApplication()).execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public static String generateVideoVoteWidgetImage(vwh paramvwh, int paramInt1, int paramInt2)
  {
    if (paramvwh == null)
    {
      xvv.b("FFmpegUtils", "generateVideoVoteWidgetImage() layout is null!");
      return null;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject = new PollContainerLayout(localBaseApplication);
    ((PollContainerLayout)localObject).a(paramvwh, -1, null);
    FrameLayout localFrameLayout = new FrameLayout(localBaseApplication);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    localFrameLayout.layout(0, 0, paramInt1, paramInt2);
    ((PollContainerLayout)localObject).a(paramvwh, -1, null);
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (localObject != null)
    {
      localFrameLayout.draw(new Canvas((Bitmap)localObject));
      paramvwh = localBaseApplication.getCacheDir().getAbsolutePath() + "/vote-" + System.currentTimeMillis() + ".png";
      boolean bool = yoy.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 80, paramvwh);
      ((Bitmap)localObject).recycle();
      xvv.d("FFmpegUtils", "generateVideoVoteWidgetImage compress success = %s, path = %s", new Object[] { Boolean.valueOf(bool), paramvwh });
      if (bool) {}
      for (;;)
      {
        return paramvwh;
        paramvwh = null;
      }
    }
    xvv.d("FFmpegUtils", "generateVideoVoteWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static Bitmap generateVoteBitmap(vwh paramvwh, int paramInt1, int paramInt2)
  {
    if (paramvwh == null)
    {
      xvv.b("FFmpegUtils", "generateVideoVoteWidgetImage() layout is null!");
      return null;
    }
    Object localObject = BaseApplicationImpl.getContext();
    PollContainerLayout localPollContainerLayout = new PollContainerLayout((Context)localObject);
    localPollContainerLayout.a(paramvwh, -1, null);
    localObject = new FrameLayout((Context)localObject);
    ((ViewGroup)localObject).setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    ((ViewGroup)localObject).addView(localPollContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    ((ViewGroup)localObject).layout(0, 0, paramInt1, paramInt2);
    localPollContainerLayout.a(paramvwh, -1, null);
    paramvwh = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (paramvwh != null)
    {
      ((ViewGroup)localObject).draw(new Canvas(paramvwh));
      return paramvwh;
    }
    xvv.d("FFmpegUtils", "generateVideoVoteWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  private static void getAudioFromMp4(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, ExecuteBinResponseCallback paramExecuteBinResponseCallback, ArrayList<FFmpegCommandUnit> paramArrayList)
  {
    if (ypi.b(paramString2)) {
      ypi.f(paramString2);
    }
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 18;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.18(paramString1, paramString2);
    localFFmpegCommandUnit.callback = new FFmpegUtils.19(paramExecuteBinResponseCallback, paramPublishVideoEntry);
    paramArrayList.add(localFFmpegCommandUnit);
  }
  
  public static String getAuidoType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = paramString;
    if (paramString.startsWith("http"))
    {
      str = paramString;
      if (paramString.contains("?")) {
        str = paramString.substring(0, paramString.indexOf("?"));
      }
    }
    int i = str.lastIndexOf(".");
    if ((i > -1) && (i < str.length() - 1)) {
      return str.substring(i);
    }
    return "";
  }
  
  public static String getSavePublishVidFileName(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder().append("QQStoryMoment").append(System.currentTimeMillis()).append("_").append(paramString1);
    if (paramString2 != null) {}
    for (;;)
    {
      return paramString2;
      paramString2 = ".mp4";
    }
  }
  
  public static String getSavedConcatFileName(int paramInt)
  {
    return "QQStory" + sVidSimpleDateFormat.format(new Date()) + "_" + Math.abs(paramInt) + ".mp4";
  }
  
  public static String getSavedVidFileName(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder().append("QQStoryMoment").append(sVidSimpleDateFormat.format(new Date())).append("_").append(paramString1);
    if (paramString2 != null) {}
    for (;;)
    {
      return paramString2;
      paramString2 = ".mp4";
    }
  }
  
  public static final String getVideoDownloadWatermarkPath(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  public static final String getVideoDownloadWatermarkPath(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    int j = 1;
    int i = j;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString2 = wkp.a(paramString2, null);
      i = j;
      if (paramString2 != null)
      {
        i = j;
        if (paramString2.type == 1) {
          i = 2;
        }
      }
    }
    return getVideoDownloadWatermarkPath(paramContext, paramString1, paramInt1, paramInt2, i);
  }
  
  private static void getVideoFromMp4(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, ExecuteBinResponseCallback paramExecuteBinResponseCallback, ArrayList<FFmpegCommandUnit> paramArrayList)
  {
    if (ypi.b(paramString1)) {
      ypi.f(paramString1);
    }
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 19;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.16(paramString2, paramString1);
    localFFmpegCommandUnit.callback = new FFmpegUtils.17(paramExecuteBinResponseCallback, paramPublishVideoEntry);
    paramArrayList.add(localFFmpegCommandUnit);
  }
  
  public static String getVideoMaxMaskPath(StoryVideoItem paramStoryVideoItem)
  {
    switch (paramStoryVideoItem.getVideoMaskType())
    {
    }
    String str;
    do
    {
      return null;
      return paramStoryVideoItem.mLocalMaskPath;
      return paramStoryVideoItem.mAtImagePath;
      str = vkm.u;
      str = str + paramStoryVideoItem.mVid + "_max.png";
    } while ((!ypi.c(str)) && (!combineTwoImg(paramStoryVideoItem.mLocalMaskPath, paramStoryVideoItem.mAtImagePath, str)));
    return str;
  }
  
  public static String getVideoVoteWidgetPath(StoryVideoItem paramStoryVideoItem)
  {
    if ((paramStoryVideoItem == null) || (!paramStoryVideoItem.isPollVideo()))
    {
      xvv.b("FFmpegUtils", "getVideoVoteWidgetPath find not-poll-video");
      return null;
    }
    return generateVideoVoteWidgetImage(paramStoryVideoItem.getPollLayout(), paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight);
  }
  
  public static boolean isProcessCompleted(Process paramProcess)
  {
    return Util.isProcessCompleted(paramProcess);
  }
  
  public static void killRunningProcesses()
  {
    FFmpeg.getInstance(BaseApplicationImpl.getApplication()).killRunningProcessesForShortVideo(false);
  }
  
  private static void mixMusicAndOriginal(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, ExecuteBinResponseCallback paramExecuteBinResponseCallback, ArrayList<FFmpegCommandUnit> paramArrayList)
  {
    if (ypi.b(paramString3)) {
      ypi.f(paramString3);
    }
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 17;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.22(paramString1, paramString2, paramString3, paramFloat1, paramFloat2);
    localFFmpegCommandUnit.callback = new FFmpegUtils.23(paramExecuteBinResponseCallback, paramPublishVideoEntry);
    paramArrayList.add(localFFmpegCommandUnit);
  }
  
  public static void mixOriginalAndBackgroundMusic(Context paramContext, String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    String str2 = paramPublishVideoEntry.backgroundMusicPath;
    int j = paramPublishVideoEntry.backgroundMusicOffset;
    int k = paramPublishVideoEntry.backgroundMusicDuration;
    float f1 = Float.valueOf(paramPublishVideoEntry.getStringExtra("originalRecordVolume", String.valueOf(0.7F))).floatValue();
    float f2 = Float.valueOf(paramPublishVideoEntry.getStringExtra("backgroundVolume", String.valueOf(1.0F))).floatValue();
    long l = System.currentTimeMillis();
    Object localObject1 = getAuidoType(str2);
    int i;
    Object localObject2;
    String str1;
    ArrayList localArrayList;
    label250:
    Object localObject3;
    String str3;
    if ((((String)localObject1).equals(".mp4")) || (((String)localObject1).equals(".m4a")))
    {
      i = 1;
      localObject2 = new File(vkm.f);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append(vkm.f);
      ((StringBuffer)localObject2).append(str2.hashCode());
      ((StringBuffer)localObject2).append("_");
      ((StringBuffer)localObject2).append(j);
      ((StringBuffer)localObject2).append("_");
      ((StringBuffer)localObject2).append(k);
      ((StringBuffer)localObject2).append(".m4a");
      localObject2 = new String((StringBuffer)localObject2);
      str1 = paramPublishVideoEntry.videoUploadTempDir + "clipNoneMp4Temp" + (String)localObject1;
      localArrayList = new ArrayList();
      if (i == 0) {
        break label566;
      }
      localObject1 = localObject2;
      clipAudio(paramPublishVideoEntry, paramExecuteBinResponseCallback, str2, j, k, (String)localObject1, localArrayList);
      if (i == 0) {
        transcodeAudio(paramPublishVideoEntry, str1, (String)localObject2, paramExecuteBinResponseCallback, localArrayList);
      }
      localObject1 = paramPublishVideoEntry.videoUploadTempDir + "mc_audio.mp4";
      str2 = paramPublishVideoEntry.videoUploadTempDir + "local_video_audio.m4a";
      str1 = paramPublishVideoEntry.videoUploadTempDir + "transcode_local_video_audio.m4a";
      if (paramPublishVideoEntry.isLocalPublish)
      {
        getAudioFromMp4(paramPublishVideoEntry, paramString1, str2, paramExecuteBinResponseCallback, localArrayList);
        transcodeAudio(paramPublishVideoEntry, str2, str1, paramExecuteBinResponseCallback, localArrayList);
      }
      localObject3 = new StringBuffer();
      ((StringBuffer)localObject3).append(vkm.f);
      ((StringBuffer)localObject3).append(((String)localObject1).hashCode());
      ((StringBuffer)localObject3).append("_mix_with_music");
      ((StringBuffer)localObject3).append(".mp4");
      localObject3 = new String((StringBuffer)localObject3);
      str3 = vkm.f + paramString1.hashCode() + "_none_audio_video.mp4";
      if (!paramPublishVideoEntry.isLocalPublish) {
        break label573;
      }
      localObject1 = str1;
    }
    label566:
    label573:
    for (;;)
    {
      mixMusicAndOriginal(paramPublishVideoEntry, (String)localObject1, (String)localObject2, (String)localObject3, f1, f2, paramExecuteBinResponseCallback, localArrayList);
      getVideoFromMp4(paramPublishVideoEntry, str3, paramString1, paramExecuteBinResponseCallback, localArrayList);
      combineVideoAndAudio(paramString2, paramPublishVideoEntry, paramBoolean, paramExecuteBinResponseCallback, k, l, (String)localObject2, localArrayList, str2, (String)localObject3, str3);
      paramContext = FFmpeg.getInstance(paramContext, true);
      if (!paramContext.isFFmpegCommandRunning()) {
        break label576;
      }
      paramContext.insertFFmpegQueue(localArrayList);
      return;
      i = 0;
      break;
      localObject1 = str1;
      break label250;
    }
    label576:
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  public static void setTimestamp(Context paramContext, String paramString1, String paramString2, int paramInt, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 13;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.2(paramString1, paramString2, paramInt);
    localFFmpegCommandUnit.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.getInstance(paramContext);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(localArrayList);
      return;
    }
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  private static void transcodeAudio(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, ExecuteBinResponseCallback paramExecuteBinResponseCallback, ArrayList<FFmpegCommandUnit> paramArrayList)
  {
    if (ypi.b(paramString2)) {
      ypi.f(paramString2);
    }
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 21;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.20(paramString1, paramString2);
    localFFmpegCommandUnit.callback = new FFmpegUtils.21(paramExecuteBinResponseCallback, paramPublishVideoEntry);
    paramArrayList.add(localFFmpegCommandUnit);
  }
  
  public static void video2Gif(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-y");
    localArrayList.add(paramString2);
    FFmpeg.getInstance(BaseApplicationImpl.getApplication()).execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils
 * JD-Core Version:    0.7.0.1
 */