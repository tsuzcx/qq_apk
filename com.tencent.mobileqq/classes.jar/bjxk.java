import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.QLog;

public class bjxk
  extends CardObserver
{
  public bjxk(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    this.a.a();
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Card)))
    {
      this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)paramObject);
      if (QidianProfileCardActivity.b(this.a)) {
        this.a.a(this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard.vQzoneCoverInfo);
      }
    }
  }
  
  public void onGetAccountType(boolean paramBoolean, BmqqAccountType paramBmqqAccountType)
  {
    super.onGetAccountType(paramBoolean, paramBmqqAccountType);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "onGetAccountType isSuccess: " + paramBoolean + " | type: " + paramBmqqAccountType + " | cardInfo.allinone.uin: " + this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
    }
    if ((paramBmqqAccountType != null) && (paramBmqqAccountType.getUin() != null) && (this.a.jdField_a_of_type_Azrb != null) && (this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramBmqqAccountType.getUin().equals(this.a.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)))
    {
      this.a.c = paramBmqqAccountType.getAccountType();
      this.a.b();
      if (this.a.c == 1) {
        this.a.jdField_a_of_type_Bjxa.b(this.a, paramBmqqAccountType);
      }
    }
    else
    {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxk
 * JD-Core Version:    0.7.0.1
 */