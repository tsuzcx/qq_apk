import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;

class bgtd
  implements aofo
{
  public bgte a;
  
  private bgtd(bgtb parambgtb) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((this.jdField_a_of_type_Bgte != null) && (paramTroopMemberInfo != null) && (TextUtils.equals(this.jdField_a_of_type_Bgte.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = new begq(((TroopManager)this.jdField_a_of_type_Bgtb.a.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin), 13).a();
      this.jdField_a_of_type_Bgte.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopMemberInfo);
      if (AppSetting.c) {
        bgtb.a(this.jdField_a_of_type_Bgtb, this.jdField_a_of_type_Bgte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtd
 * JD-Core Version:    0.7.0.1
 */