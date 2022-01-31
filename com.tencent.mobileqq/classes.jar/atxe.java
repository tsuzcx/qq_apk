import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.lyric.common.TimerTaskManager.TimerTaskRunnable;
import com.tencent.mobileqq.lyric.widget.LyricView;
import com.tencent.mobileqq.lyric.widget.LyricViewController.10;
import com.tencent.mobileqq.lyric.widget.LyricViewController.2;
import com.tencent.mobileqq.lyric.widget.LyricViewController.3;
import com.tencent.mobileqq.lyric.widget.LyricViewController.4;
import com.tencent.mobileqq.lyric.widget.LyricViewController.5;
import com.tencent.mobileqq.lyric.widget.LyricViewController.9;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.lyric.widget.LyricViewScroll;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class atxe
{
  public int a;
  public long a;
  public atwl a;
  protected atxb a;
  private atxh jdField_a_of_type_Atxh = new atxf(this);
  protected TimerTaskManager.TimerTaskRunnable a;
  protected TimerTaskManager a;
  public LyricViewInternal a;
  private LyricViewScroll jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll;
  protected final String a;
  protected volatile boolean a;
  public int b;
  public volatile boolean b;
  private volatile int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public atxe(LyricView paramLyricView)
  {
    this.jdField_a_of_type_JavaLangString = ("task_name_lyric_draw_" + System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager = atwq.a();
    this.jdField_a_of_type_Atxb = new atxb();
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable = new LyricViewController.2(this);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.setScrollListener(this.jdField_a_of_type_Atxh);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Atwl = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.a();
    atwl localatwl = this.jdField_a_of_type_Atwl;
    if ((localatwl == null) || (localatwl.a()) || (this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Boolean) {
        Log.d("ModuleController", "onRefresh -> is scrolling");
      }
      return;
    }
    int j = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    int i = j;
    if (this.jdField_b_of_type_Boolean)
    {
      i = j;
      if (j >= this.jdField_b_of_type_Int) {
        i = this.jdField_b_of_type_Int;
      }
    }
    this.jdField_c_of_type_Int = i;
    a(localatwl.a(i), i);
  }
  
  public void a()
  {
    Log.d("ModuleController", "start");
    atwq.a().post(new LyricViewController.4(this));
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager.a(this.jdField_a_of_type_JavaLangString, 100L, 100L, this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    Log.d("ModuleController", "seek " + paramInt);
    atwq.a().post(new LyricViewController.5(this, paramInt));
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null) && (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.getWindowToken() != null)) {
      ThreadManager.getUIHandler().post(new LyricViewController.9(this, paramInt1, paramInt2));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll != null) && (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.getWindowToken() != null)) {
      ThreadManager.getUIHandler().post(new LyricViewController.10(this));
    }
  }
  
  public void a(atwl paramatwl1, atwl paramatwl2, atwl paramatwl3)
  {
    Log.v("ModuleController", "setLyric begin");
    atwq.a().post(new LyricViewController.3(this, paramatwl3, paramatwl1, paramatwl2));
  }
  
  public void a(LyricView paramLyricView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.setScrollListener(this.jdField_a_of_type_Atxh);
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    Log.d("ModuleController", "stop");
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected void b(int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Atwl != null) || (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null))
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.b(paramInt);
      if ((this.jdField_a_of_type_Atwl == null) || (this.jdField_a_of_type_Atwl.a())) {
        Log.w("ModuleController", "onScrollStop -> scroll without measured lyric");
      }
    }
    else
    {
      return;
    }
    Log.d("ModuleController", "onScrollStop -> scroll to lineNo：" + paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_Atwl.a.size()))
    {
      if (this.jdField_a_of_type_Atwl.a.get(paramInt) == null)
      {
        Log.w("ModuleController", "onScrollStop -> current sentence is null");
        return;
      }
      long l2 = ((atwn)this.jdField_a_of_type_Atwl.a.get(paramInt)).jdField_a_of_type_Long;
      Log.d("ModuleController", "onScrollStop -> start time of current sentence：" + l2);
      long l1 = l2;
      if (this.jdField_b_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_Int < 0) || (l2 >= this.jdField_a_of_type_Int)) {
          break label303;
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
        this.jdField_a_of_type_Atxb.a(l1);
        if ((this.jdField_c_of_type_Boolean) || (!this.d)) {
          break;
        }
        a((int)l1);
        return;
        label303:
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
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected void c(int paramInt)
  {
    if ((this.jdField_a_of_type_Atwl != null) || (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null))
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.a(paramInt);
      if ((this.jdField_a_of_type_Atwl == null) || (this.jdField_a_of_type_Atwl.a())) {
        Log.w("ModuleController", "onScrolling -> scroll without measured lyric");
      }
    }
    else
    {
      return;
    }
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_Atwl.a.size()))
    {
      if (this.jdField_a_of_type_Atwl.a.get(paramInt) == null)
      {
        Log.w("ModuleController", "onScrollStop -> current sentence is null");
        return;
      }
      long l2 = ((atwn)this.jdField_a_of_type_Atwl.a.get(paramInt)).jdField_a_of_type_Long;
      long l1 = l2;
      if (this.jdField_b_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_Int < 0) || (l2 >= this.jdField_a_of_type_Int)) {
          break label178;
        }
        l1 = this.jdField_a_of_type_Int;
      }
      for (;;)
      {
        l2 = l1;
        if (l1 < 0L) {
          l2 = 0L;
        }
        l1 = l2 / 10L;
        this.jdField_a_of_type_Atxb.b((l1 + 1L) * 10L);
        return;
        label178:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atxe
 * JD-Core Version:    0.7.0.1
 */