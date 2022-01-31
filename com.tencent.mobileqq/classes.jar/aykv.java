import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;

public class aykv
  extends ayih
{
  TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo;
  String jdField_a_of_type_JavaLangString;
  
  public aykv(QQAppInterface paramQQAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo, String paramString)
  {
    super(paramQQAppInterface, paramInt, paramTroopMemberInfo);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo = paramTroopMemberInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    if ((paramView.getId() == 2131375665) && (this.b == 23)) {
      TroopAddFrdsInnerFrame.a(localContext, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo, this.jdField_a_of_type_JavaLangString, false);
    }
    while (this.b != 23) {
      return;
    }
    Intent localIntent = new Intent(localContext, FriendProfileCardActivity.class);
    localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopuin);
    localIntent.putExtra("memberUin", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin);
    localIntent.putExtra("fromFlag", 1);
    localIntent.putExtra("selfSet_leftViewText", paramView.getContext().getString(2131721064));
    localIntent.putExtra("custom_leftbackbutton_name", paramView.getContext().getString(2131690623));
    awnk.a(localContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localIntent, 9);
  }
  
  public CharSequence c()
  {
    aloz localaloz = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localaloz.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin)) {
      return alpo.a(2131715635);
    }
    if (localaloz.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin, false)) {
      return alpo.a(2131715636);
    }
    return null;
  }
  
  public String c()
  {
    return bdbt.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin);
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.commonFrdCnt <= 0) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.commonFrdCnt + alpo.a(2131715637);
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.commonFrdCnt < 0) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.commonFrdCnt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aykv
 * JD-Core Version:    0.7.0.1
 */