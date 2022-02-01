import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.VideoCoverPickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.HashSet;

public class bpcq
  extends bpen
  implements View.OnClickListener
{
  public long a;
  private View jdField_a_of_type_AndroidViewView;
  private bovc jdField_a_of_type_Bovc;
  private boolean jdField_a_of_type_Boolean;
  public long b;
  private boolean b;
  public long c;
  private long e;
  private long f;
  
  public bpcq(@NonNull bpep parambpep, long paramLong)
  {
    super(parambpep);
    this.e = paramLong;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bovc == null) {
      this.jdField_a_of_type_Bovc = new bpcr(this);
    }
  }
  
  public int a()
  {
    int i = 1;
    int j = this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1);
    if (this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) {
      i = 4;
    }
    do
    {
      return i;
      if (j == 1) {
        return 0;
      }
    } while (j == 2);
    return 2;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewView = a(2131380536);
    if ((this.e & 0x0) != 0L)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    this.c = this.jdField_a_of_type_Bpep.b();
    if ((this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditLocalVideoSource)) {
      this.f = ((EditLocalVideoSource)this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a).jdField_a_of_type_Int;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    Object localObject = (bpal)a(bpal.class);
    if (localObject != null) {
      ((bpal)localObject).a(this.f, false);
    }
    localObject = (bpam)a(bpam.class);
    if (localObject != null) {
      ((bpam)localObject).b();
    }
    this.jdField_a_of_type_Bpep.a(0);
    if (paramBoolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      QQToast.a(a(), 2, anni.a(2131702697), 0).a();
      if (paramLong != 0L) {
        bcst.b(null, "dc00899", "grp_story", "", "video_edit_cover", "done_cover", a(), 1, "", "", "", "");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoCover", 2, new Object[] { "SegmentPickerFinish, coverTime: ", Long.valueOf(this.jdField_a_of_type_Long) });
      }
      return;
      this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Bpep.jdField_a_of_type_Int == 42)
    {
      a(0L, false);
      bool = true;
    }
    return bool;
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      if ((this.jdField_a_of_type_Bpep.jdField_a_of_type_Int == 42) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Long = ((Long[])(Long[])paramMessage.obj)[1].longValue();
      }
    }
  }
  
  public void aT_()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      bcst.b(null, "dc00899", "grp_story", "", "video_edit_cover", "pub_cover", a(), 1, "", "", "", "");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setEnabled(paramBoolean);
    }
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
      if (this.jdField_a_of_type_Bpep.a() != null) {
        this.jdField_a_of_type_Bpep.a().a.add(Integer.valueOf(9));
      }
      QLog.d("EditVideoCover", 1, new Object[] { "Click, current covertime, ", Long.valueOf(this.jdField_a_of_type_Long) });
      this.jdField_a_of_type_Bpep.a(42);
      d();
      ProviderViewEditContainer localProviderViewEditContainer = this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpaz.a;
      VideoCoverPickerProviderView localVideoCoverPickerProviderView = (VideoCoverPickerProviderView)localProviderViewEditContainer.a(113);
      if (localVideoCoverPickerProviderView != null)
      {
        bpal localbpal = (bpal)a(bpal.class);
        if (localbpal != null)
        {
          localVideoCoverPickerProviderView.setPlayMode(localbpal.a());
          localVideoCoverPickerProviderView.setUseIFrameVideo(localbpal.m_());
          localbpal.b();
          if ((!this.jdField_b_of_type_Boolean) && (localbpal.a() == 1)) {
            this.jdField_a_of_type_Long = (this.c * 1000000L);
          }
          localbpal.a(this.jdField_a_of_type_Long / 1000000L, true);
        }
      }
      localProviderViewEditContainer.setVideoCoverPickerListener(this.jdField_a_of_type_Bovc);
      localProviderViewEditContainer.a(113, new Object[] { Long.valueOf(this.jdField_a_of_type_Long / 1000000L) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpcq
 * JD-Core Version:    0.7.0.1
 */