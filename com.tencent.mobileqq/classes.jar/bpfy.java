import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView;

public class bpfy
  extends bpen
{
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  VipFrwrdLinkView jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView;
  private wrb jdField_a_of_type_Wrb;
  private boolean jdField_a_of_type_Boolean;
  
  public void a(int paramInt, @NonNull bpsf parambpsf)
  {
    super.a(paramInt, parambpsf);
    if (this.jdField_a_of_type_Wrb != null) {
      parambpsf.a.setLinkInfo(this.jdField_a_of_type_Wrb);
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_Bpep.a().d();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131365635));
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(12, -1);
        localLayoutParams.setMargins(0, 0, 0, a().getDimensionPixelSize(2131298004) + afur.a(17.0F, a()));
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i).getId() == 2131365637)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView = new VipFrwrdLinkView(a());
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView, i, localLayoutParams);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Looper.myQueue().addIdleHandler(new bpfz(this));
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfy
 * JD-Core Version:    0.7.0.1
 */