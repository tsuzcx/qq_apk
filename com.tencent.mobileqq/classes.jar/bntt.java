import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;

class bntt
  implements View.OnClickListener
{
  bntt(bntq parambntq, String paramString) {}
  
  public void onClick(View paramView)
  {
    bntq.a(this.jdField_a_of_type_Bntq);
    if ((bntq.a(this.jdField_a_of_type_Bntq) != null) && (bntq.a(this.jdField_a_of_type_Bntq).a() != null) && (bntq.a(this.jdField_a_of_type_Bntq).a().app != null) && (bntq.a(this.jdField_a_of_type_Bntq) != null))
    {
      bntp.a(bntq.a(this.jdField_a_of_type_Bntq).a().app, bntq.a(this.jdField_a_of_type_Bntq).a(), this.jdField_a_of_type_JavaLangString, 4005);
      bntp.a(bntq.a(this.jdField_a_of_type_Bntq).a().app, 102, String.valueOf(bntq.a(this.jdField_a_of_type_Bntq).iAdId.get()), bntq.a(this.jdField_a_of_type_Bntq).traceinfo.get());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntt
 * JD-Core Version:    0.7.0.1
 */