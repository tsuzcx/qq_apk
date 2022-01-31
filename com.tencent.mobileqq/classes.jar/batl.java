import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;

class batl
  implements akif
{
  public batm a;
  
  private batl(batj parambatj) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((this.jdField_a_of_type_Batm != null) && (paramTroopMemberInfo != null) && (TextUtils.equals(this.jdField_a_of_type_Batm.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = new ayjw(((TroopManager)this.jdField_a_of_type_Batj.a.getManager(52)).a(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin), 13).a();
      this.jdField_a_of_type_Batm.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopMemberInfo);
      if (AppSetting.d) {
        batj.a(this.jdField_a_of_type_Batj, this.jdField_a_of_type_Batm);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     batl
 * JD-Core Version:    0.7.0.1
 */