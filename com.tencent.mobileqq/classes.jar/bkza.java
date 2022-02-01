import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;

class bkza
  implements View.OnClickListener
{
  bkza(bkyx parambkyx, String paramString) {}
  
  public void onClick(View paramView)
  {
    bkyx.a(this.jdField_a_of_type_Bkyx);
    if ((bkyx.a(this.jdField_a_of_type_Bkyx) != null) && (bkyx.a(this.jdField_a_of_type_Bkyx).a() != null) && (bkyx.a(this.jdField_a_of_type_Bkyx).a().app != null) && (bkyx.a(this.jdField_a_of_type_Bkyx) != null))
    {
      bkyw.a(bkyx.a(this.jdField_a_of_type_Bkyx).a().app, bkyx.a(this.jdField_a_of_type_Bkyx).a(), this.jdField_a_of_type_JavaLangString, 4005);
      bkyw.a(bkyx.a(this.jdField_a_of_type_Bkyx).a().app, 102, String.valueOf(bkyx.a(this.jdField_a_of_type_Bkyx).iAdId.get()), bkyx.a(this.jdField_a_of_type_Bkyx).traceinfo.get());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkza
 * JD-Core Version:    0.7.0.1
 */