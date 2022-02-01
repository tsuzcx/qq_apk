package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.aelight.camera.aeeditor.lyric.common.TimerTaskManager;
import com.tencent.aelight.camera.aeeditor.lyric.common.TimerTaskManager.TimerTaskRunnable;
import com.tencent.aelight.camera.aeeditor.lyric.util.LyricContext;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricProgressCalculator;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence;
import java.util.ArrayList;

public class LyricViewController
{
  protected static final String a;
  protected int a;
  protected long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new LyricViewController.7(this, Looper.getMainLooper());
  protected TimerTaskManager.TimerTaskRunnable a;
  protected TimerTaskManager a;
  protected LyricBaseInternalViewInterface a;
  protected LyricScrollHelper a;
  public LyricViewController.OnObtainMusicPositionListener a;
  private LyricViewScroll.LyricViewScrollListener jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll$LyricViewScrollListener = new LyricViewController.1(this);
  protected LyricViewScroll a;
  protected Lyric a;
  protected volatile boolean a;
  protected int b;
  private boolean b;
  protected int c;
  private boolean c;
  private volatile int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private int f = 0;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("task_name_lyric_draw_");
    localStringBuilder.append(Math.random());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public LyricViewController(LyricView paramLyricView)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 100;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricCommonTimerTaskManager = LyricContext.a();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricScrollHelper = new LyricScrollHelper();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricCommonTimerTaskManager$TimerTaskRunnable = new LyricViewController.2(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll = paramLyricView.a();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricBaseInternalViewInterface = paramLyricView.a();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll.setScrollListener(this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll$LyricViewScrollListener);
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      LyricViewController.OnObtainMusicPositionListener localOnObtainMusicPositionListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewController$OnObtainMusicPositionListener;
      if (localOnObtainMusicPositionListener != null) {
        paramInt = localOnObtainMusicPositionListener.a();
      } else {
        paramInt = (int)AEEditorLyricProgressCalculator.a().a(false);
      }
    }
    if (paramInt > 0) {
      this.f = paramInt;
    }
    b(this.f);
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void a()
  {
    Log.d("ModuleController", "stop");
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricCommonTimerTaskManager.a(jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if (Thread.currentThread().equals(Looper.getMainLooper().getThread()))
    {
      b(paramInt);
      return;
    }
    LyricContext.a().post(new LyricViewController.5(this, paramInt));
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    LyricContext.a().post(new LyricViewController.6(this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    LyricContext.a().post(new LyricViewController.4(this, paramInt, paramBoolean));
  }
  
  public void a(LyricScrollHelper.LyricScrollListener paramLyricScrollListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricScrollHelper.a(paramLyricScrollListener);
  }
  
  public void a(LyricViewController.OnObtainMusicPositionListener paramOnObtainMusicPositionListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewController$OnObtainMusicPositionListener = paramOnObtainMusicPositionListener;
  }
  
  public void a(Lyric paramLyric1, Lyric paramLyric2, Lyric paramLyric3)
  {
    Log.v("ModuleController", "setLyric begin");
    LyricContext.a().post(new LyricViewController.3(this, paramLyric3, paramLyric1, paramLyric2));
  }
  
  public void a(boolean paramBoolean)
  {
    LyricBaseInternalViewInterface localLyricBaseInternalViewInterface = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricBaseInternalViewInterface;
    if (localLyricBaseInternalViewInterface != null) {
      localLyricBaseInternalViewInterface.setEffectEnable(paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricBaseInternalViewInterface.a();
    Lyric localLyric = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric;
    if (localLyric != null)
    {
      if (localLyric.isEmpty()) {
        return;
      }
      int i = paramInt;
      int j;
      if (this.jdField_a_of_type_Boolean)
      {
        j = this.jdField_a_of_type_Int;
        i = paramInt;
        if (j > 0) {
          i = paramInt + j;
        }
      }
      paramInt = i;
      if (this.jdField_a_of_type_Boolean)
      {
        j = this.jdField_b_of_type_Int;
        paramInt = i;
        if (i >= j) {
          paramInt = j;
        }
      }
      this.jdField_d_of_type_Int = paramInt;
      a(localLyric.findLineNo(paramInt), paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  protected void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric != null) || (this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricBaseInternalViewInterface != null))
    {
      paramInt = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricBaseInternalViewInterface.a(paramInt);
      Object localObject = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric;
      if ((localObject == null) || (((Lyric)localObject).isEmpty())) {
        break label499;
      }
      long l1;
      if (paramInt == this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.size() - 1)
      {
        int i = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricBaseInternalViewInterface.b();
        if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onScrollStop() endTop => ");
          ((StringBuilder)localObject).append(i);
          Log.d("ModuleController", ((StringBuilder)localObject).toString());
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll.smoothScrollTo(0, i);
        }
        if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricScrollHelper != null)
        {
          l1 = ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(paramInt)).mStartTime;
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricScrollHelper.a(l1, i);
        }
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScrollStop -> scroll to lineNo：");
      ((StringBuilder)localObject).append(paramInt);
      Log.d("ModuleController", ((StringBuilder)localObject).toString());
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.size()))
      {
        if (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(paramInt) == null)
        {
          Log.w("ModuleController", "onScrollStop -> current sentence is null");
          return;
        }
        long l2 = ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(paramInt)).mStartTime;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onScrollStop -> start time of current sentence：");
        ((StringBuilder)localObject).append(l2);
        Log.d("ModuleController", ((StringBuilder)localObject).toString());
        l1 = l2;
        if (this.jdField_a_of_type_Boolean)
        {
          paramInt = this.jdField_a_of_type_Int;
          if ((paramInt >= 0) && (l2 < paramInt)) {}
          do
          {
            l1 = paramInt;
            break;
            paramInt = this.jdField_b_of_type_Int;
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
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricScrollHelper;
        if (localObject != null) {
          ((LyricScrollHelper)localObject).a(l1);
        }
        if ((!this.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
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
    if ((this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric != null) || (this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricBaseInternalViewInterface != null))
    {
      int i = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricBaseInternalViewInterface.b(paramInt);
      Object localObject = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric;
      if ((localObject != null) && (!((Lyric)localObject).isEmpty()))
      {
        if ((i >= 0) && (i < this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.size()))
        {
          if (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(i) == null)
          {
            Log.w("ModuleController", "onScrollStop -> current sentence is null");
            return;
          }
          long l2 = ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(i)).mStartTime;
          long l1 = l2;
          if (this.jdField_a_of_type_Boolean)
          {
            paramInt = this.jdField_a_of_type_Int;
            if ((paramInt >= 0) && (l2 < paramInt)) {}
            do
            {
              l1 = paramInt;
              break;
              paramInt = this.jdField_b_of_type_Int;
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
          paramInt = this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll.getScrollY();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onScrolling() scrollY => ");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(",position => ");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(",lineNo:");
          ((StringBuilder)localObject).append(i);
          AEQLog.a("ModuleController", ((StringBuilder)localObject).toString());
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricScrollHelper.a(l1, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewController
 * JD-Core Version:    0.7.0.1
 */