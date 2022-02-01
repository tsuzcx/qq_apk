import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;

class bgaz
  implements anwz
{
  public bgba a;
  
  private bgaz(bgax parambgax) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((this.jdField_a_of_type_Bgba != null) && (paramTroopMemberInfo != null) && (TextUtils.equals(this.jdField_a_of_type_Bgba.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = new bdnf(((TroopManager)this.jdField_a_of_type_Bgax.a.getManager(52)).a(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin), 13).a();
      this.jdField_a_of_type_Bgba.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopMemberInfo);
      if (AppSetting.c) {
        bgax.a(this.jdField_a_of_type_Bgax, this.jdField_a_of_type_Bgba);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgaz
 * JD-Core Version:    0.7.0.1
 */