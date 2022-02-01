import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;

public class bchb
  extends bcen
{
  TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo;
  String jdField_a_of_type_JavaLangString;
  
  public bchb(QQAppInterface paramQQAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo, String paramString)
  {
    super(paramQQAppInterface, paramInt, paramTroopMemberInfo);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo = paramTroopMemberInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    if ((paramView.getId() == 2131376575) && (this.b == 23)) {
      TroopAddFrdsInnerFrame.a(localContext, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo, this.jdField_a_of_type_JavaLangString, false);
    }
    while (this.b != 23) {
      return;
    }
    Intent localIntent = new Intent(localContext, FriendProfileCardActivity.class);
    localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopuin);
    localIntent.putExtra("memberUin", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin);
    localIntent.putExtra("fromFlag", 1);
    localIntent.putExtra("selfSet_leftViewText", paramView.getContext().getString(2131718960));
    localIntent.putExtra("custom_leftbackbutton_name", paramView.getContext().getString(2131690559));
    azyo.a(localContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localIntent, 9);
  }
  
  public CharSequence c()
  {
    anyw localanyw = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localanyw.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin)) {
      return anzj.a(2131714037);
    }
    if (localanyw.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin, false)) {
      return anzj.a(2131714038);
    }
    return null;
  }
  
  public String c()
  {
    return bhlg.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin);
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
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.commonFrdCnt + anzj.a(2131714039);
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
 * Qualified Name:     bchb
 * JD-Core Version:    0.7.0.1
 */