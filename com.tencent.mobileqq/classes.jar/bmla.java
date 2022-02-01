import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;

class bmla
  implements View.OnClickListener
{
  bmla(bmkx parambmkx, String paramString) {}
  
  public void onClick(View paramView)
  {
    bmkx.a(this.jdField_a_of_type_Bmkx);
    if ((bmkx.a(this.jdField_a_of_type_Bmkx) != null) && (bmkx.a(this.jdField_a_of_type_Bmkx).a() != null) && (bmkx.a(this.jdField_a_of_type_Bmkx).a().app != null) && (bmkx.a(this.jdField_a_of_type_Bmkx) != null))
    {
      bmkw.a(bmkx.a(this.jdField_a_of_type_Bmkx).a().app, bmkx.a(this.jdField_a_of_type_Bmkx).a(), this.jdField_a_of_type_JavaLangString, 4005);
      bmkw.a(bmkx.a(this.jdField_a_of_type_Bmkx).a().app, 102, String.valueOf(bmkx.a(this.jdField_a_of_type_Bmkx).iAdId.get()), bmkx.a(this.jdField_a_of_type_Bmkx).traceinfo.get());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmla
 * JD-Core Version:    0.7.0.1
 */