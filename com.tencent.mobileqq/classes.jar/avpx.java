import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;

public class avpx
  extends avnj
{
  TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo;
  String jdField_a_of_type_JavaLangString;
  
  public avpx(QQAppInterface paramQQAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo, String paramString)
  {
    super(paramQQAppInterface, paramInt, paramTroopMemberInfo);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo = paramTroopMemberInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    if ((paramView.getId() == 2131309433) && (this.b == 23)) {
      TroopAddFrdsInnerFrame.a(localContext, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo, this.jdField_a_of_type_JavaLangString, false);
    }
    while (this.b != 23) {
      return;
    }
    Intent localIntent = new Intent(localContext, FriendProfileCardActivity.class);
    localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopuin);
    localIntent.putExtra("memberUin", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin);
    localIntent.putExtra("fromFlag", 1);
    localIntent.putExtra("selfSet_leftViewText", paramView.getContext().getString(2131654617));
    localIntent.putExtra("custom_leftbackbutton_name", paramView.getContext().getString(2131625011));
    atxx.a(localContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localIntent, 9);
  }
  
  public CharSequence c()
  {
    ajjj localajjj = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localajjj.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin)) {
      return ajjy.a(2131649462);
    }
    if (localajjj.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin, false)) {
      return ajjy.a(2131649463);
    }
    return null;
  }
  
  public String c()
  {
    return babh.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin);
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
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.commonFrdCnt + ajjy.a(2131649464);
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
 * Qualified Name:     avpx
 * JD-Core Version:    0.7.0.1
 */