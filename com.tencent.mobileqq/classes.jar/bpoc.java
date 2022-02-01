import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.mode.CaptureModeController;

@TargetApi(18)
public class bpoc
  extends bpny
{
  protected ImageView a;
  protected LinearLayout a;
  protected bhpc a;
  private boolean b;
  
  public bpoc(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhpc == null) {
      this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(), 230).setMessage(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131697607)).setPositiveButton(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131694098), new bpoe(this)).setNegativeButton(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131717827), new bpod(this));
    }
    try
    {
      if ((this.jdField_a_of_type_Bhpc != null) && (!this.jdField_a_of_type_Bhpc.isShowing())) {
        this.jdField_a_of_type_Bhpc.show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SegmentMode", 2, "segment back dialog error:" + localThrowable);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364193));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364192));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SegmentMode", 2, new Object[] { "handleSelectMode", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bpof(this));
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if (paramBoolean)
    {
      ((PressDarkImageButton)this.jdField_a_of_type_AndroidWidgetImageView).setEnableDark(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageAlpha(255);
      this.jdField_a_of_type_AndroidWidgetImageView.postInvalidate();
      return;
    }
    ((PressDarkImageButton)this.jdField_a_of_type_AndroidWidgetImageView).setEnableDark(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageAlpha(127);
    this.jdField_a_of_type_AndroidWidgetImageView.postInvalidate();
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
      if (this.jdField_a_of_type_Bocn.c())
      {
        this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Bocn.y();
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("SegmentMode", 2, "segment video error: jump to edit with no videos");
        continue;
        this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Bocn.A();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpoc
 * JD-Core Version:    0.7.0.1
 */