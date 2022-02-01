import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azop
  implements View.OnClickListener
{
  azop(azol paramazol, String paramString, int paramInt, View paramView) {}
  
  public void onClick(View paramView)
  {
    if ((bbdu.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int >= 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_sign_topic_name", this.jdField_a_of_type_JavaLangString);
      localBundle.putInt("key_sign_topic_id", this.jdField_a_of_type_Int);
      localBundle.putInt("from_type", 2);
      if (azol.e(this.jdField_a_of_type_Azol) != null) {
        SignTextEditFragment.a(azol.f(this.jdField_a_of_type_Azol), null, null, localBundle, -1);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      azfy.a().c(azol.j(this.jdField_a_of_type_Azol));
      bcst.b(null, "dc00898", "", "", "0X800A4D5", "0X800A4D5", 0, 0, "2", "0", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azop
 * JD-Core Version:    0.7.0.1
 */