import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;

class bfkm
  implements ancx
{
  public bfkn a;
  
  private bfkm(bfkk parambfkk) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((this.jdField_a_of_type_Bfkn != null) && (paramTroopMemberInfo != null) && (TextUtils.equals(this.jdField_a_of_type_Bfkn.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = new bczs(((TroopManager)this.jdField_a_of_type_Bfkk.a.getManager(52)).a(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin), 13).a();
      this.jdField_a_of_type_Bfkn.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopMemberInfo);
      if (AppSetting.c) {
        bfkk.a(this.jdField_a_of_type_Bfkk, this.jdField_a_of_type_Bfkn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfkm
 * JD-Core Version:    0.7.0.1
 */