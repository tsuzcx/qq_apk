import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView;

public class bmkg
  extends bmiv
{
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  VipFrwrdLinkView jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView;
  private utg jdField_a_of_type_Utg;
  private boolean jdField_a_of_type_Boolean;
  
  public void a(int paramInt, @NonNull bmwn parambmwn)
  {
    super.a(paramInt, parambmwn);
    if (this.jdField_a_of_type_Utg != null) {
      parambmwn.a.setLinkInfo(this.jdField_a_of_type_Utg);
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_Bmix.a().d();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131365398));
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(12, -1);
        localLayoutParams.setMargins(0, 0, 0, a().getDimensionPixelSize(2131297923) + aekt.a(17.0F, a()));
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i).getId() == 2131365400)
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
    Looper.myQueue().addIdleHandler(new bmkh(this));
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkg
 * JD-Core Version:    0.7.0.1
 */