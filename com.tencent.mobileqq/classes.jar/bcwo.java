import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;

class bcwo
  implements amek
{
  public bcwp a;
  
  private bcwo(bcwm parambcwm) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((this.jdField_a_of_type_Bcwp != null) && (paramTroopMemberInfo != null) && (TextUtils.equals(this.jdField_a_of_type_Bcwp.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = new bamb(((TroopManager)this.jdField_a_of_type_Bcwm.a.getManager(52)).a(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin), 13).a();
      this.jdField_a_of_type_Bcwp.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopMemberInfo);
      if (AppSetting.c) {
        bcwm.a(this.jdField_a_of_type_Bcwm, this.jdField_a_of_type_Bcwp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwo
 * JD-Core Version:    0.7.0.1
 */