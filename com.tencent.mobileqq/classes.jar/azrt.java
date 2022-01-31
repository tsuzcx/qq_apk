import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;

class azrt
  implements ajtw
{
  public azru a;
  
  private azrt(azrr paramazrr) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((this.jdField_a_of_type_Azru != null) && (paramTroopMemberInfo != null) && (TextUtils.equals(this.jdField_a_of_type_Azru.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = new axjq(((TroopManager)this.jdField_a_of_type_Azrr.a.getManager(52)).a(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin), 13).a();
      this.jdField_a_of_type_Azru.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopMemberInfo);
      if (AppSetting.c) {
        azrr.a(this.jdField_a_of_type_Azrr, this.jdField_a_of_type_Azru);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azrt
 * JD-Core Version:    0.7.0.1
 */