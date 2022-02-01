import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;

class bhba
  implements aojm
{
  public bhbb a;
  
  private bhba(bhay parambhay) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((this.jdField_a_of_type_Bhbb != null) && (paramTroopMemberInfo != null) && (TextUtils.equals(this.jdField_a_of_type_Bhbb.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = new begb(((TroopManager)this.jdField_a_of_type_Bhay.a.getManager(52)).a(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin), 13).a();
      this.jdField_a_of_type_Bhbb.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopMemberInfo);
      if (AppSetting.c) {
        bhay.a(this.jdField_a_of_type_Bhay, this.jdField_a_of_type_Bhbb);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhba
 * JD-Core Version:    0.7.0.1
 */