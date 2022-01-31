import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView;

public class bihk
  extends bifz
{
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  VipFrwrdLinkView jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView;
  private srv jdField_a_of_type_Srv;
  private boolean jdField_a_of_type_Boolean;
  
  public srv a()
  {
    return this.jdField_a_of_type_Srv;
  }
  
  public void a(int paramInt, @NonNull bitz parambitz)
  {
    super.a(paramInt, parambitz);
    if (this.jdField_a_of_type_Srv != null) {
      parambitz.a.setLinkInfo(this.jdField_a_of_type_Srv);
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_Bigb.a().d();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131299746));
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(12, -1);
        localLayoutParams.setMargins(0, 0, 0, a().getDimensionPixelSize(2131166812) + aciy.a(17.0F, a()));
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
      {
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i).getId() == 2131299748)
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
    Looper.myQueue().addIdleHandler(new bihl(this));
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerVipFrwrdLinkView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bihk
 * JD-Core Version:    0.7.0.1
 */