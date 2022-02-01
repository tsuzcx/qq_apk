package com.tencent.biz.qqcircle.widgets;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.utils.FileUtils;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qcircle.application.QCircleApplication;

public class FrameAnimationView
  extends ImageView
{
  public static int a;
  private boolean b;
  private Handler c = new Handler(Looper.getMainLooper());
  
  public FrameAnimationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FrameAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FrameAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private BitmapDrawable a(int paramInt)
  {
    if (paramInt == a) {
      return null;
    }
    try
    {
      Object localObject = SafeBitmapFactory.decodeStream(QCircleApplication.APP.getResources().openRawResource(paramInt));
      if (localObject != null)
      {
        localObject = new BitmapDrawable((Bitmap)localObject);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      setBackgroundDrawable(paramDrawable);
      return;
    }
    paramString = RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).getContentFilePath(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = AnimationDrawableFactory.a(paramString);
      if ((paramString != null) && (paramString.length > 0) && (FileUtils.d(paramString[0])))
      {
        paramString = SafeBitmapFactory.decodeFile(paramString[0]);
        if (paramString != null) {
          setBackgroundDrawable(new BitmapDrawable(paramString));
        }
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.b = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.b = false;
    this.c.removeCallbacksAndMessages(null);
    QQAnimationDrawable localQQAnimationDrawable;
    if ((getBackground() instanceof QQAnimationDrawable))
    {
      localQQAnimationDrawable = (QQAnimationDrawable)getBackground();
      if (localQQAnimationDrawable.isRunning()) {
        localQQAnimationDrawable.stop();
      }
    }
    if ((getDrawable() instanceof QQAnimationDrawable))
    {
      localQQAnimationDrawable = (QQAnimationDrawable)getDrawable();
      if (localQQAnimationDrawable.isRunning()) {
        localQQAnimationDrawable.run();
      }
    }
  }
  
  public void setAnimationFile(String paramString, int paramInt, boolean paramBoolean)
  {
    paramString = AnimationDrawableFactory.a(paramString);
    if ((paramString != null) && (paramString.length > 0))
    {
      Handler localHandler = this.c;
      if (localHandler != null) {
        localHandler.post(new FrameAnimationView.1(this, paramString, paramInt, paramBoolean));
      }
    }
  }
  
  public void setDownloadZipFilePath(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramString, a(paramInt2));
    RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).downloadOrUpdateFile(paramString, new FrameAnimationView.2(this, paramInt1, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.FrameAnimationView
 * JD-Core Version:    0.7.0.1
 */