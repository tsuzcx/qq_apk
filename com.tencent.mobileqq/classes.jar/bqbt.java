import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage.DoAccumulativeRunnable;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.widget.FastAnimationDrawable;
import dov.com.tencent.biz.qqstory.takevideo.EditGifImage;

public class bqbt
  extends bqgi
  implements View.OnClickListener
{
  protected double a;
  protected final int a;
  protected LinearLayout a;
  protected SeekBar a;
  protected TextView a;
  protected boolean a;
  protected int b;
  protected TextView b;
  protected int c;
  protected int d = 50;
  protected int e = -1;
  protected int f;
  protected int g;
  
  public bqbt(@NonNull bqgk parambqgk)
  {
    super(parambqgk);
    this.jdField_a_of_type_Int = AbstractGifImage.DoAccumulativeRunnable.DELAY;
  }
  
  private void d()
  {
    this.f = bnlj.f;
    this.g = (this.c * bnlj.g);
    this.jdField_a_of_type_Double = ((this.f - this.g) / 100.0D);
    if (QLog.isColorLevel()) {
      QLog.d("EditGifSpeedControl", 2, "calculateSpeedChangeByLimit | defaultY:" + this.c + " maxSpeed:" + this.f + " minSpeed:" + this.g + " k1:" + this.jdField_a_of_type_Double);
    }
  }
  
  public void a()
  {
    super.a();
    AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    NativeGifImage.QZONE_DELAY = -1;
    this.jdField_b_of_type_Int = 50;
    if (QLog.isColorLevel()) {
      QLog.d("EditGifSpeedControl", 2, "onCreate | defaultX:" + this.jdField_b_of_type_Int + " defaultY:" + this.c + " delayTime:" + this.e);
    }
    d();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131377258));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131377253));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131377254));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)a(2131367555));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(100);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new bqbu(this));
  }
  
  public void a(@NonNull bqua parambqua)
  {
    if (this.e == -1) {
      if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_Boolean)
      {
        parambqua.a.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a());
        parambqua.a.d = this.jdField_a_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.d("EditGifSpeedControl", 2, "editVideoPrePublish | get defaultY:" + this.c + " isDelayTimeChange:" + this.jdField_a_of_type_Boolean);
        }
      }
    }
    do
    {
      return;
      bqug localbqug = parambqua.a;
      if (NativeGifImage.GIF_DEFAULT_DELAY != -1) {}
      for (int i = NativeGifImage.GIF_DEFAULT_DELAY;; i = bnlj.d)
      {
        localbqug.jdField_b_of_type_Int = i;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditGifSpeedControl", 2, "editVideoPrePublish | get delayTime:" + this.e + " isDelayTimeChange:" + this.jdField_a_of_type_Boolean);
      }
      parambqua.a.jdField_b_of_type_Int = this.e;
      parambqua.a.d = this.jdField_a_of_type_Boolean;
      if (this.e < this.c)
      {
        LpReportInfo_pf00064.allReport(628, 5, 3);
        return;
      }
    } while (this.e <= this.c);
    LpReportInfo_pf00064.allReport(628, 5, 2);
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Int == 21)
    {
      NativeGifImage.QZONE_DELAY = this.c;
      if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null) {
        this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a(NativeGifImage.QZONE_DELAY);
      }
      this.e = this.c;
      this.d = this.jdField_b_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("EditGifSpeedControl", 2, "onBackPressed | delayTime:" + this.e + " barPosition:" + this.d);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Bqgk.a(0);
      bool = true;
      LpReportInfo_pf00064.allReport(628, 5, 4);
    }
    return bool;
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    if (this.e == -1)
    {
      if (!this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_Boolean) {
        break label193;
      }
      paramInt = (int)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditGifImage.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a();
      this.e = paramInt;
      this.c = paramInt;
    }
    for (NativeGifImage.QZONE_DELAY = paramInt;; NativeGifImage.QZONE_DELAY = paramInt)
    {
      d();
      paramInt = (int)((this.c - this.g) / this.jdField_a_of_type_Double);
      this.d = paramInt;
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("EditGifSpeedControl", 2, "editVideoStateChanged | delayTime:" + this.e + " barPosition:" + this.d);
      }
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.d);
      this.c = this.e;
      this.jdField_b_of_type_Int = this.d;
      return;
      label193:
      paramInt = NativeGifImage.GIF_DEFAULT_DELAY;
      this.e = paramInt;
      this.c = paramInt;
    }
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("EditGifSpeedControl", 2, "onDestroy | DEFAULT_DELAY:" + this.jdField_a_of_type_Int);
    }
    AbstractGifImage.DoAccumulativeRunnable.DELAY = this.jdField_a_of_type_Int;
    NativeGifImage.QZONE_DELAY = -1;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Int == 21)
      {
        this.jdField_a_of_type_Bqgk.a(0);
        continue;
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqbt
 * JD-Core Version:    0.7.0.1
 */