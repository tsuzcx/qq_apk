package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.weseevideo.editor.sticker.music.LyricParseHelper;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;
import java.text.SimpleDateFormat;

public class LyricWithBuoyView
  extends FrameLayout
{
  public LyricViewDetail a;
  public LyricViewController b;
  private View c = null;
  private View d = null;
  private TextView e = null;
  private volatile boolean f = true;
  private LyricWithBuoyView.OnLyricWithBuoyViewOperationListener g;
  private Handler h = new LyricWithBuoyView.1(this, Looper.getMainLooper());
  
  public LyricWithBuoyView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public LyricWithBuoyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LyricWithBuoyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = LayoutInflater.from(paramContext).inflate(2064056447, this);
    this.a = ((LyricViewDetail)paramContext.findViewById(2063990921));
    this.e = ((TextView)paramContext.findViewById(2063991547));
    this.c = paramContext.findViewById(2063990922);
    this.c.setOnTouchListener(new LyricWithBuoyView.2(this));
    this.c.setOnClickListener(new LyricWithBuoyView.3(this));
    this.a.setIsDealTouchEvent(false);
    this.d = paramContext.findViewById(2063991275);
    this.b = new LyricViewController(this.a);
  }
  
  public static String a(int paramInt)
  {
    return new SimpleDateFormat("mm:ss").format(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    Object localObject = this.d;
    if (localObject == null) {
      AEQLog.c("LyricWithBuoyView", "handlerHideSelection() mMusicLyricLineView == null.");
    } else {
      ((View)localObject).setVisibility(4);
    }
    localObject = this.b;
    if (localObject != null) {
      ((LyricViewController)localObject).b(false);
    }
  }
  
  public void a(LyricScrollHelper.LyricScrollListener paramLyricScrollListener)
  {
    LyricViewController localLyricViewController = this.b;
    if (localLyricViewController == null)
    {
      AEQLog.c("LyricWithBuoyView", "registerScrollListener() mLyricViewController == null.");
      return;
    }
    localLyricViewController.a(paramLyricScrollListener);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, LyricViewController.OnObtainMusicPositionListener paramOnObtainMusicPositionListener)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject = this.b;
      if (localObject != null) {
        ((LyricViewController)localObject).a();
      }
      LyricViewController localLyricViewController;
      if (TextUtils.equals(paramString2.toUpperCase(), "LRC"))
      {
        localObject = LyricParseHelper.parseTextToLyric(paramString1, false);
        localLyricViewController = this.b;
        paramString1 = (String)localObject;
        if (localLyricViewController != null)
        {
          localLyricViewController.a(null, (Lyric)localObject, null);
          paramString1 = (String)localObject;
        }
      }
      else if (TextUtils.equals(paramString2.toUpperCase(), "QRC"))
      {
        localObject = LyricParseHelper.parseTextToLyric(paramString1, true);
        localLyricViewController = this.b;
        paramString1 = (String)localObject;
        if (localLyricViewController != null)
        {
          localLyricViewController.a((Lyric)localObject, null, null);
          paramString1 = (String)localObject;
        }
      }
      else
      {
        paramString1 = null;
      }
      if (paramString1 != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append("initLyricView() startTime => ");
        paramString1.append(paramInt);
        paramString1.append(",lyricFormat:");
        paramString1.append(paramString2);
        AEQLog.a("LyricWithBuoyView", paramString1.toString());
        paramString1 = this.b;
        if (paramString1 != null)
        {
          paramString1.a(false);
          this.b.a(paramInt, true);
          this.b.a(paramOnObtainMusicPositionListener);
        }
      }
      return;
    }
    AEQLog.a("LyricWithBuoyView", "initLyricView() lyric info is empty.");
  }
  
  public void b(int paramInt)
  {
    LyricViewController localLyricViewController = this.b;
    if (localLyricViewController != null) {
      localLyricViewController.a(paramInt);
    }
  }
  
  public TextView getMusicCurrentTime()
  {
    return this.e;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = (int)(getMeasuredHeight() * 0.3F);
    Object localObject = this.d;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((View)localObject).getLayoutParams();
    }
    if ((localObject instanceof FrameLayout.LayoutParams))
    {
      localObject = (FrameLayout.LayoutParams)localObject;
      ((FrameLayout.LayoutParams)localObject).setMargins(((FrameLayout.LayoutParams)localObject).leftMargin, paramInt1, ((FrameLayout.LayoutParams)localObject).rightMargin, ((FrameLayout.LayoutParams)localObject).bottomMargin);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.f) {
      return true;
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          Log.d("LyricWithBuoyView", "onTouchEvent -> ACTION_MOVE");
          localObject = a(this.b.b());
          this.e.setText((CharSequence)localObject);
          invalidate();
        }
      }
      else
      {
        Log.d("LyricWithBuoyView", "onTouchEvent -> ACTION_UP");
        this.h.sendEmptyMessageDelayed(1, 3000L);
      }
    }
    else
    {
      Log.d("LyricWithBuoyView", "onTouchEvent -> ACTION_DOWN");
      this.h.removeMessages(1);
      localObject = this.d;
      if ((localObject != null) && (((View)localObject).getVisibility() != 0)) {
        this.d.setVisibility(0);
      }
      localObject = this.b;
      if (localObject != null) {
        ((LyricViewController)localObject).b(true);
      }
    }
    this.a.a(paramMotionEvent);
    return true;
  }
  
  public void setLyric(Lyric paramLyric1, Lyric paramLyric2, Lyric paramLyric3)
  {
    LyricViewController localLyricViewController = this.b;
    if (localLyricViewController == null)
    {
      AEQLog.c("LyricWithBuoyView", "setLyric() mLyricViewController == null.");
      return;
    }
    localLyricViewController.a(paramLyric1, paramLyric2, paramLyric3);
  }
  
  public void setOnLyricWithBuoyViewOperationListener(LyricWithBuoyView.OnLyricWithBuoyViewOperationListener paramOnLyricWithBuoyViewOperationListener)
  {
    this.g = paramOnLyricWithBuoyViewOperationListener;
  }
  
  public void setSelectedFlag(int paramInt, boolean paramBoolean)
  {
    LyricViewController localLyricViewController = this.b;
    if (localLyricViewController != null)
    {
      localLyricViewController.a(paramInt, true);
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricWithBuoyView
 * JD-Core Version:    0.7.0.1
 */