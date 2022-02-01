package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.aelight.camera.aeeditor.lyric.common.TimerTaskManager;
import com.tencent.aelight.camera.aeeditor.lyric.common.TimerTaskManager.TimerTaskRunnable;
import com.tencent.aelight.camera.aeeditor.lyric.util.LyricContext;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricProgressCalculator;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Sentence;
import java.util.ArrayList;

public class LyricViewController
{
  protected static final String a;
  protected LyricViewScroll b;
  protected LyricBaseInternalViewInterface c;
  protected Lyric d;
  protected long e;
  protected volatile boolean f;
  protected int g;
  protected int h;
  protected int i = 100;
  protected TimerTaskManager j = LyricContext.a();
  protected LyricScrollHelper k = new LyricScrollHelper();
  protected TimerTaskManager.TimerTaskRunnable l = new LyricViewController.2(this);
  public LyricViewController.OnObtainMusicPositionListener m;
  private volatile int n = 0;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private LyricViewScroll.LyricViewScrollListener r = new LyricViewController.1(this);
  private int s = 0;
  private int t = 0;
  private Handler u = new LyricViewController.7(this, Looper.getMainLooper());
  private boolean v = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("task_name_lyric_draw_");
    localStringBuilder.append(Math.random());
    a = localStringBuilder.toString();
  }
  
  public LyricViewController(LyricView paramLyricView)
  {
    this.b = paramLyricView.getScrollView();
    this.c = paramLyricView.getLyricViewInternal();
    this.b.setScrollListener(this.r);
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      LyricViewController.OnObtainMusicPositionListener localOnObtainMusicPositionListener = this.m;
      if (localOnObtainMusicPositionListener != null) {
        paramInt = localOnObtainMusicPositionListener.a();
      } else {
        paramInt = (int)AEEditorLyricProgressCalculator.a().a(false);
      }
    }
    if (paramInt > 0) {
      this.t = paramInt;
    }
    b(this.t);
  }
  
  public void a()
  {
    Log.d("ModuleController", "stop");
    this.j.a(a);
    this.e = 0L;
    this.o = false;
  }
  
  public void a(int paramInt)
  {
    if (Thread.currentThread().equals(Looper.getMainLooper().getThread()))
    {
      b(paramInt);
      return;
    }
    LyricContext.b().post(new LyricViewController.5(this, paramInt));
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    LyricContext.b().post(new LyricViewController.6(this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    LyricContext.b().post(new LyricViewController.4(this, paramInt, paramBoolean));
  }
  
  public void a(LyricScrollHelper.LyricScrollListener paramLyricScrollListener)
  {
    this.k.a(paramLyricScrollListener);
  }
  
  public void a(LyricViewController.OnObtainMusicPositionListener paramOnObtainMusicPositionListener)
  {
    this.m = paramOnObtainMusicPositionListener;
  }
  
  public void a(Lyric paramLyric1, Lyric paramLyric2, Lyric paramLyric3)
  {
    Log.v("ModuleController", "setLyric begin");
    LyricContext.b().post(new LyricViewController.3(this, paramLyric3, paramLyric1, paramLyric2));
  }
  
  public void a(boolean paramBoolean)
  {
    LyricBaseInternalViewInterface localLyricBaseInternalViewInterface = this.c;
    if (localLyricBaseInternalViewInterface != null) {
      localLyricBaseInternalViewInterface.setEffectEnable(paramBoolean);
    }
  }
  
  public int b()
  {
    return this.n;
  }
  
  public void b(int paramInt)
  {
    this.d = this.c.getMeasuredLyric();
    Lyric localLyric = this.d;
    if (localLyric != null)
    {
      if (localLyric.isEmpty()) {
        return;
      }
      int i1 = paramInt;
      int i2;
      if (this.f)
      {
        i2 = this.g;
        i1 = paramInt;
        if (i2 > 0) {
          i1 = paramInt + i2;
        }
      }
      paramInt = i1;
      if (this.f)
      {
        i2 = this.h;
        paramInt = i1;
        if (i1 >= i2) {
          paramInt = i2;
        }
      }
      this.n = paramInt;
      a(localLyric.findLineNo(paramInt), paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  protected void c(int paramInt)
  {
    if ((this.d != null) || (this.c != null))
    {
      paramInt = this.c.a(paramInt);
      Object localObject = this.d;
      if ((localObject == null) || (((Lyric)localObject).isEmpty())) {
        break label499;
      }
      long l1;
      if (paramInt == this.d.mSentences.size() - 1)
      {
        int i1 = this.c.getEndScrollY();
        if (this.b != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onScrollStop() endTop => ");
          ((StringBuilder)localObject).append(i1);
          Log.d("ModuleController", ((StringBuilder)localObject).toString());
          this.b.smoothScrollTo(0, i1);
        }
        if (this.k != null)
        {
          l1 = ((Sentence)this.d.mSentences.get(paramInt)).mStartTime;
          this.k.a(l1, i1);
        }
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScrollStop -> scroll to lineNo：");
      ((StringBuilder)localObject).append(paramInt);
      Log.d("ModuleController", ((StringBuilder)localObject).toString());
      if ((paramInt >= 0) && (paramInt < this.d.mSentences.size()))
      {
        if (this.d.mSentences.get(paramInt) == null)
        {
          Log.w("ModuleController", "onScrollStop -> current sentence is null");
          return;
        }
        long l2 = ((Sentence)this.d.mSentences.get(paramInt)).mStartTime;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onScrollStop -> start time of current sentence：");
        ((StringBuilder)localObject).append(l2);
        Log.d("ModuleController", ((StringBuilder)localObject).toString());
        l1 = l2;
        if (this.f)
        {
          paramInt = this.g;
          if ((paramInt >= 0) && (l2 < paramInt)) {}
          do
          {
            l1 = paramInt;
            break;
            paramInt = this.h;
            l1 = l2;
            if (paramInt < 0) {
              break;
            }
            l1 = l2;
          } while (l2 > paramInt);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onScrollStop -> correct start time：");
        ((StringBuilder)localObject).append(l1);
        Log.d("ModuleController", ((StringBuilder)localObject).toString());
        l2 = l1;
        if (l1 < 0L) {
          l2 = 0L;
        }
        l1 = (l2 / 10L + 1L) * 10L;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onScrollStop -> output time：");
        ((StringBuilder)localObject).append(l1);
        Log.d("ModuleController", ((StringBuilder)localObject).toString());
        localObject = this.k;
        if (localObject != null) {
          ((LyricScrollHelper)localObject).a(l1);
        }
        if ((!this.o) && (this.q)) {
          a((int)l1, false);
        }
      }
      else
      {
        Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
      }
    }
    return;
    label499:
    Log.w("ModuleController", "onScrollStop -> scroll without measured lyric");
  }
  
  protected void d(int paramInt)
  {
    if ((this.d != null) || (this.c != null))
    {
      int i1 = this.c.b(paramInt);
      Object localObject = this.d;
      if ((localObject != null) && (!((Lyric)localObject).isEmpty()))
      {
        if ((i1 >= 0) && (i1 < this.d.mSentences.size()))
        {
          if (this.d.mSentences.get(i1) == null)
          {
            Log.w("ModuleController", "onScrollStop -> current sentence is null");
            return;
          }
          long l2 = ((Sentence)this.d.mSentences.get(i1)).mStartTime;
          long l1 = l2;
          if (this.f)
          {
            paramInt = this.g;
            if ((paramInt >= 0) && (l2 < paramInt)) {}
            do
            {
              l1 = paramInt;
              break;
              paramInt = this.h;
              l1 = l2;
              if (paramInt < 0) {
                break;
              }
              l1 = l2;
            } while (l2 > paramInt);
          }
          l2 = l1;
          if (l1 < 0L) {
            l2 = 0L;
          }
          l1 = (l2 / 10L + 1L) * 10L;
          paramInt = this.b.getScrollY();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onScrolling() scrollY => ");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(",position => ");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(",lineNo:");
          ((StringBuilder)localObject).append(i1);
          AEQLog.a("ModuleController", ((StringBuilder)localObject).toString());
          this.k.a(l1, paramInt);
          return;
        }
        Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
      }
    }
    else
    {
      return;
    }
    Log.w("ModuleController", "onScrolling -> scroll without measured lyric");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewController
 * JD-Core Version:    0.7.0.1
 */