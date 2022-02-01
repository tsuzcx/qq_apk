import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence;
import dov.com.qq.im.aeeditor.lyric.common.TimerTaskManager;
import dov.com.qq.im.aeeditor.lyric.common.TimerTaskManager.TimerTaskRunnable;
import dov.com.qq.im.aeeditor.lyric.widget.LyricView;
import dov.com.qq.im.aeeditor.lyric.widget.LyricViewController.2;
import dov.com.qq.im.aeeditor.lyric.widget.LyricViewController.3;
import dov.com.qq.im.aeeditor.lyric.widget.LyricViewController.4;
import dov.com.qq.im.aeeditor.lyric.widget.LyricViewController.5;
import dov.com.qq.im.aeeditor.lyric.widget.LyricViewController.6;
import dov.com.qq.im.aeeditor.lyric.widget.LyricViewScroll;
import java.util.ArrayList;

public class bpcz
{
  protected static final String a;
  public int a;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new bpdb(this, Looper.getMainLooper());
  public bpcs a;
  protected bpct a;
  public bpdc a;
  private bpdh jdField_a_of_type_Bpdh = new bpda(this);
  public Lyric a;
  protected TimerTaskManager.TimerTaskRunnable a;
  protected TimerTaskManager a;
  public LyricViewScroll a;
  public volatile boolean a;
  protected int b;
  private boolean b;
  protected int c;
  private boolean c;
  private volatile int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  
  static
  {
    jdField_a_of_type_JavaLangString = "task_name_lyric_draw_" + Math.random();
  }
  
  public bpcz(LyricView paramLyricView)
  {
    this.jdField_c_of_type_Int = 100;
    this.jdField_a_of_type_DovComQqImAeeditorLyricCommonTimerTaskManager = bpco.a();
    this.jdField_a_of_type_Bpct = new bpct();
    this.jdField_a_of_type_DovComQqImAeeditorLyricCommonTimerTaskManager$TimerTaskRunnable = new LyricViewController.2(this);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll = paramLyricView.a();
    this.jdField_a_of_type_Bpcs = paramLyricView.a();
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.setScrollListener(this.jdField_a_of_type_Bpdh);
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      if (paramInt > 0) {
        this.f = paramInt;
      }
      b(this.f);
      return;
      if (this.jdField_a_of_type_Bpdc != null) {
        paramInt = this.jdField_a_of_type_Bpdc.a();
      } else {
        paramInt = (int)bpio.a().a(false);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void a()
  {
    Log.d("ModuleController", "stop");
    this.jdField_a_of_type_DovComQqImAeeditorLyricCommonTimerTaskManager.a(jdField_a_of_type_JavaLangString);
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
    bpco.a().post(new LyricViewController.5(this, paramInt));
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    bpco.a().post(new LyricViewController.6(this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bpco.a().post(new LyricViewController.4(this, paramInt, paramBoolean));
  }
  
  public void a(bpcu parambpcu)
  {
    this.jdField_a_of_type_Bpct.a(parambpcu);
  }
  
  public void a(bpdc parambpdc)
  {
    this.jdField_a_of_type_Bpdc = parambpdc;
  }
  
  public void a(Lyric paramLyric1, Lyric paramLyric2, Lyric paramLyric3)
  {
    Log.v("ModuleController", "setLyric begin");
    bpco.a().post(new LyricViewController.3(this, paramLyric3, paramLyric1, paramLyric2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bpcs != null) {
      this.jdField_a_of_type_Bpcs.setEffectEnable(paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = this.jdField_a_of_type_Bpcs.a();
    Lyric localLyric = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric;
    if ((localLyric == null) || (localLyric.isEmpty())) {
      return;
    }
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean)
    {
      i = paramInt;
      if (this.jdField_a_of_type_Int > 0) {
        i = paramInt + this.jdField_a_of_type_Int;
      }
    }
    paramInt = i;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = i;
      if (i >= this.jdField_b_of_type_Int) {
        paramInt = this.jdField_b_of_type_Int;
      }
    }
    this.jdField_d_of_type_Int = paramInt;
    a(localLyric.findLineNo(paramInt), paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  protected void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric != null) || (this.jdField_a_of_type_Bpcs != null))
    {
      paramInt = this.jdField_a_of_type_Bpcs.a(paramInt);
      if ((this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric != null) && (!this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.isEmpty())) {
        break label51;
      }
      Log.w("ModuleController", "onScrollStop -> scroll without measured lyric");
    }
    label51:
    int i;
    do
    {
      return;
      if (paramInt != this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.size() - 1) {
        break;
      }
      i = this.jdField_a_of_type_Bpcs.b();
      if (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll != null)
      {
        Log.d("ModuleController", "onScrollStop() endTop => " + i);
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.smoothScrollTo(0, i);
      }
    } while (this.jdField_a_of_type_Bpct == null);
    long l1 = ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(paramInt)).mStartTime;
    this.jdField_a_of_type_Bpct.a(l1, i);
    return;
    Log.d("ModuleController", "onScrollStop -> scroll to lineNo：" + paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.size()))
    {
      if (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(paramInt) == null)
      {
        Log.w("ModuleController", "onScrollStop -> current sentence is null");
        return;
      }
      long l2 = ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(paramInt)).mStartTime;
      Log.d("ModuleController", "onScrollStop -> start time of current sentence：" + l2);
      l1 = l2;
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_Int < 0) || (l2 >= this.jdField_a_of_type_Int)) {
          break label416;
        }
        l1 = this.jdField_a_of_type_Int;
      }
      for (;;)
      {
        Log.d("ModuleController", "onScrollStop -> correct start time：" + l1);
        l2 = l1;
        if (l1 < 0L) {
          l2 = 0L;
        }
        l1 = (l2 / 10L + 1L) * 10L;
        Log.d("ModuleController", "onScrollStop -> output time：" + l1);
        if (this.jdField_a_of_type_Bpct != null) {
          this.jdField_a_of_type_Bpct.a(l1);
        }
        if ((this.jdField_b_of_type_Boolean) || (!this.jdField_d_of_type_Boolean)) {
          break;
        }
        a((int)l1, false);
        return;
        label416:
        l1 = l2;
        if (this.jdField_b_of_type_Int >= 0)
        {
          l1 = l2;
          if (l2 > this.jdField_b_of_type_Int) {
            l1 = this.jdField_b_of_type_Int;
          }
        }
      }
    }
    Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
  }
  
  protected void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric != null) || (this.jdField_a_of_type_Bpcs != null))
    {
      paramInt = this.jdField_a_of_type_Bpcs.b(paramInt);
      if ((this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric == null) || (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.isEmpty())) {
        Log.w("ModuleController", "onScrolling -> scroll without measured lyric");
      }
    }
    else
    {
      return;
    }
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.size()))
    {
      if (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(paramInt) == null)
      {
        Log.w("ModuleController", "onScrollStop -> current sentence is null");
        return;
      }
      long l2 = ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(paramInt)).mStartTime;
      long l1 = l2;
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_Int < 0) || (l2 >= this.jdField_a_of_type_Int)) {
          break label235;
        }
        l1 = this.jdField_a_of_type_Int;
      }
      for (;;)
      {
        l2 = l1;
        if (l1 < 0L) {
          l2 = 0L;
        }
        l1 = (l2 / 10L + 1L) * 10L;
        int i = this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.getScrollY();
        bpam.a("ModuleController", "onScrolling() scrollY => " + i + ",position => " + l1 + ",lineNo:" + paramInt);
        this.jdField_a_of_type_Bpct.a(l1, i);
        return;
        label235:
        l1 = l2;
        if (this.jdField_b_of_type_Int >= 0)
        {
          l1 = l2;
          if (l2 > this.jdField_b_of_type_Int) {
            l1 = this.jdField_b_of_type_Int;
          }
        }
      }
    }
    Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpcz
 * JD-Core Version:    0.7.0.1
 */