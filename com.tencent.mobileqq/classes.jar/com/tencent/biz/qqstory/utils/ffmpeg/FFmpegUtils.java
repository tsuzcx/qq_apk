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
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.widget.InteractContainerLayout;
import com.tencent.biz.qqstory.widget.PollContainerLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import ots;
import ott;
import otu;

public class FFmpegUtils
{
  public static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd", Locale.CHINESE);
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2)
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
      localCanvas.save(31);
      paramBitmap1.recycle();
      paramBitmap2.recycle();
      return localBitmap;
      localCanvas.drawBitmap(paramBitmap2, 0.0F, 0.0F, null);
    }
  }
  
  public static Bitmap a(StoryVideoItem.InteractPasterLayout paramInteractPasterLayout, int paramInt1, int paramInt2)
  {
    if (paramInteractPasterLayout == null)
    {
      SLog.b("FFmpegUtils", "generate interact image failed. it's not a interacted video.");
      return null;
    }
    SLog.a("FFmpegUtils", "generateInteractWidgetImage, layout=%s, containerWidth=%s, containerHeight=%s", paramInteractPasterLayout, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    Object localObject = BaseApplicationImpl.getContext();
    InteractContainerLayout localInteractContainerLayout = new InteractContainerLayout((Context)localObject);
    localInteractContainerLayout.a(paramInteractPasterLayout, 0);
    localObject = new FrameLayout((Context)localObject);
    ((ViewGroup)localObject).setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    ((ViewGroup)localObject).addView(localInteractContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    ((ViewGroup)localObject).layout(0, 0, paramInt1, paramInt2);
    localInteractContainerLayout.a(paramInteractPasterLayout, 0);
    paramInteractPasterLayout = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (paramInteractPasterLayout != null)
    {
      ((ViewGroup)localObject).draw(new Canvas(paramInteractPasterLayout));
      return paramInteractPasterLayout;
    }
    SLog.d("FFmpegUtils", "generateInteractWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static Bitmap a(StoryVideoItem.PollLayout paramPollLayout, int paramInt1, int paramInt2)
  {
    if (paramPollLayout == null)
    {
      SLog.b("FFmpegUtils", "generateVideoVoteWidgetImage() layout is null!");
      return null;
    }
    Object localObject = BaseApplicationImpl.getContext();
    PollContainerLayout localPollContainerLayout = new PollContainerLayout((Context)localObject);
    localPollContainerLayout.a(paramPollLayout, -1, null);
    localObject = new FrameLayout((Context)localObject);
    ((ViewGroup)localObject).setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    ((ViewGroup)localObject).addView(localPollContainerLayout, new FrameLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    ((ViewGroup)localObject).layout(0, 0, paramInt1, paramInt2);
    localPollContainerLayout.a(paramPollLayout, -1, null);
    paramPollLayout = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (paramPollLayout != null)
    {
      ((ViewGroup)localObject).draw(new Canvas(paramPollLayout));
      return paramPollLayout;
    }
    SLog.d("FFmpegUtils", "generateVideoVoteWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static final String a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  public static String a(StoryVideoItem.InteractPasterLayout paramInteractPasterLayout, int paramInt1, int paramInt2)
  {
    if (paramInteractPasterLayout == null)
    {
      SLog.b("FFmpegUtils", "generate interact image failed. it's not a interacted video.");
      return null;
    }
    SLog.a("FFmpegUtils", "generateInteractWidgetImage, layout=%s, containerWidth=%s, containerHeight=%s", paramInteractPasterLayout, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject = new InteractContainerLayout(localBaseApplication);
    ((InteractContainerLayout)localObject).a(paramInteractPasterLayout, 0);
    FrameLayout localFrameLayout = new FrameLayout(localBaseApplication);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    localFrameLayout.layout(0, 0, paramInt1, paramInt2);
    ((InteractContainerLayout)localObject).a(paramInteractPasterLayout, 0);
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (localObject != null)
    {
      localFrameLayout.draw(new Canvas((Bitmap)localObject));
      paramInteractPasterLayout = localBaseApplication.getCacheDir().getAbsolutePath() + "/grade-" + System.currentTimeMillis() + ".png";
      boolean bool = BitmapUtils.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 80, paramInteractPasterLayout);
      ((Bitmap)localObject).recycle();
      SLog.d("FFmpegUtils", "generateInteractWidgetImage compress success = %s, path = %s", new Object[] { Boolean.valueOf(bool), paramInteractPasterLayout });
      if (bool) {}
      for (;;)
      {
        return paramInteractPasterLayout;
        paramInteractPasterLayout = null;
      }
    }
    SLog.d("FFmpegUtils", "generateInteractWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static String a(StoryVideoItem.PollLayout paramPollLayout, int paramInt1, int paramInt2)
  {
    if (paramPollLayout == null)
    {
      SLog.b("FFmpegUtils", "generateVideoVoteWidgetImage() layout is null!");
      return null;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject = new PollContainerLayout(localBaseApplication);
    ((PollContainerLayout)localObject).a(paramPollLayout, -1, null);
    FrameLayout localFrameLayout = new FrameLayout(localBaseApplication);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    localFrameLayout.layout(0, 0, paramInt1, paramInt2);
    ((PollContainerLayout)localObject).a(paramPollLayout, -1, null);
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (localObject != null)
    {
      localFrameLayout.draw(new Canvas((Bitmap)localObject));
      paramPollLayout = localBaseApplication.getCacheDir().getAbsolutePath() + "/vote-" + System.currentTimeMillis() + ".png";
      boolean bool = BitmapUtils.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 80, paramPollLayout);
      ((Bitmap)localObject).recycle();
      SLog.d("FFmpegUtils", "generateVideoVoteWidgetImage compress success = %s, path = %s", new Object[] { Boolean.valueOf(bool), paramPollLayout });
      if (bool) {}
      for (;;)
      {
        return paramPollLayout;
        paramPollLayout = null;
      }
    }
    SLog.d("FFmpegUtils", "generateVideoVoteWidgetImage create bitmap failed, w=%d, h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    return null;
  }
  
  public static String a(StoryVideoItem paramStoryVideoItem)
  {
    if ((paramStoryVideoItem == null) || (!paramStoryVideoItem.isPollVideo()))
    {
      SLog.b("FFmpegUtils", "getVideoVoteWidgetPath find not-poll-video");
      return null;
    }
    return a(paramStoryVideoItem.getPollLayout(), paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if ((i > -1) && (i < paramString.length() - 1)) {
      return paramString.substring(i);
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder().append("QQStoryMoment").append(System.currentTimeMillis()).append("_").append(paramString1);
    if (paramString2 != null) {}
    for (;;)
    {
      return paramString2;
      paramString2 = ".mp4";
    }
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.jdField_a_of_type_Int = 11;
    localFFmpegCommandUnit.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.3(paramString1, paramInt1, paramInt2, paramInt3, paramBoolean, paramString2);
    localFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    a(false, paramContext, paramString1, paramString2, "h264", paramInt1, paramInt2, paramString3, false, paramExecuteBinResponseCallback);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    a(false, paramContext, paramString1, paramString2, "copy", paramInt1, paramInt2, paramString3, paramBoolean, paramExecuteBinResponseCallback);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.jdField_a_of_type_Int = 13;
    localFFmpegCommandUnit.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.2(paramString1, paramString2);
    localFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.jdField_a_of_type_Int = 15;
    localFFmpegCommandUnit.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.9(paramString1, paramString2, paramString3);
    localFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new ots(paramExecuteBinResponseCallback);
    paramString1 = new ArrayList();
    paramString1.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.a(paramContext, true);
    if (paramContext.a())
    {
      paramContext.b(paramString1);
      return;
    }
    paramContext.a(paramString1);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.jdField_a_of_type_Int = 12;
    localFFmpegCommandUnit.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.1(paramString1, paramString2, paramString3);
    localFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
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
    FFmpeg.a(BaseApplicationImpl.getApplication()).a((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    a(paramBoolean, paramContext, paramString1, paramString2, "copy", paramInt1, paramInt2, paramString3, false, paramExecuteBinResponseCallback);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.jdField_a_of_type_Int = 16;
    localFFmpegCommandUnit.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.11(paramString1, paramString2);
    localFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    if (paramBoolean) {}
    for (paramContext = FFmpeg.b(paramContext, false); paramContext.a(); paramContext = FFmpeg.a(paramContext))
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
  
  private static void a(boolean paramBoolean1, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, boolean paramBoolean2, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    Object localObject1 = a(paramString2);
    Object localObject2 = new File(QQStoryConstant.d);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(QQStoryConstant.d);
    ((StringBuffer)localObject2).append(paramString2.hashCode());
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(paramInt1);
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(paramInt2);
    ((StringBuffer)localObject2).append((String)localObject1);
    localObject2 = new String((StringBuffer)localObject2);
    localObject1 = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.jdField_a_of_type_Int = 3;
    localFFmpegCommandUnit.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.5(paramString2, (String)localObject2, paramInt1, paramInt2);
    localFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new ott(paramExecuteBinResponseCallback);
    ((ArrayList)localObject1).add(localFFmpegCommandUnit);
    paramString2 = new FFmpegCommandUnit();
    paramString2.jdField_a_of_type_Int = 4;
    paramString2.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.7(paramString1, (String)localObject2, paramString3, paramString4, paramBoolean2, paramInt2);
    paramString2.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new otu(paramExecuteBinResponseCallback, (String)localObject2);
    ((ArrayList)localObject1).add(paramString2);
    if (paramBoolean1) {}
    for (paramContext = FFmpeg.b(paramContext, true); paramContext.a(); paramContext = FFmpeg.a(paramContext, true))
    {
      paramContext.b((ArrayList)localObject1);
      return;
    }
    paramContext.a((ArrayList)localObject1);
  }
  
  public static boolean a(Bitmap paramBitmap1, Bitmap paramBitmap2, String paramString)
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
      localCanvas.save(31);
      try
      {
        ImageUtil.a(localBitmap, new File(paramString));
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
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    do
    {
      return false;
      paramString2 = SafeBitmapFactory.decodeFile(paramString2);
      paramString1 = SafeBitmapFactory.decodeFile(paramString1);
    } while ((paramString2 == null) || (paramString1 == null));
    return a(paramString1, paramString2, paramString3);
  }
  
  public static String b(StoryVideoItem paramStoryVideoItem)
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
      str = QQStoryConstant.q;
      str = str + paramStoryVideoItem.mVid + "_max.png";
    } while ((!FileUtils.c(str)) && (!a(paramStoryVideoItem.mLocalMaskPath, paramStoryVideoItem.mAtImagePath, str)));
    return str;
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    a(paramContext, paramString1, paramString2, paramInt1, paramInt2, paramString3, true, paramExecuteBinResponseCallback);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.jdField_a_of_type_Int = 9;
    localFFmpegCommandUnit.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.4(paramString1, paramString2);
    localFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b(localArrayList);
      return;
    }
    paramContext.a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils
 * JD-Core Version:    0.7.0.1
 */