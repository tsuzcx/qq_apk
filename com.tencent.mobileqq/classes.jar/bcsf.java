import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;

class bcsf
  implements alzv
{
  public bcsg a;
  
  private bcsf(bcsd parambcsd) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((this.jdField_a_of_type_Bcsg != null) && (paramTroopMemberInfo != null) && (TextUtils.equals(this.jdField_a_of_type_Bcsg.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = new bahs(((TroopManager)this.jdField_a_of_type_Bcsd.a.getManager(52)).a(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin), 13).a();
      this.jdField_a_of_type_Bcsg.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopMemberInfo);
      if (AppSetting.c) {
        bcsd.a(this.jdField_a_of_type_Bcsd, this.jdField_a_of_type_Bcsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsf
 * JD-Core Version:    0.7.0.1
 */