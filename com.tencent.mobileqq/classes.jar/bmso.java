import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;

class bmso
  implements View.OnClickListener
{
  bmso(bmsl parambmsl, String paramString) {}
  
  public void onClick(View paramView)
  {
    bmsl.a(this.jdField_a_of_type_Bmsl);
    if ((bmsl.a(this.jdField_a_of_type_Bmsl) != null) && (bmsl.a(this.jdField_a_of_type_Bmsl).a() != null) && (bmsl.a(this.jdField_a_of_type_Bmsl).a().app != null) && (bmsl.a(this.jdField_a_of_type_Bmsl) != null))
    {
      bmsk.a(bmsl.a(this.jdField_a_of_type_Bmsl).a().app, bmsl.a(this.jdField_a_of_type_Bmsl).a(), this.jdField_a_of_type_JavaLangString, 4005);
      bmsk.a(bmsl.a(this.jdField_a_of_type_Bmsl).a().app, 102, String.valueOf(bmsl.a(this.jdField_a_of_type_Bmsl).iAdId.get()), bmsl.a(this.jdField_a_of_type_Bmsl).traceinfo.get());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmso
 * JD-Core Version:    0.7.0.1
 */