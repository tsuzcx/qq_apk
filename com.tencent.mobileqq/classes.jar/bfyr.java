import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.QLog;

public class bfyr
  extends alpq
{
  public bfyr(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    this.a.a();
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Card)))
    {
      this.a.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)paramObject);
      if (QidianProfileCardActivity.b(this.a)) {
        this.a.a(this.a.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqDataCard.vQzoneCoverInfo);
      }
    }
  }
  
  protected void onGetAccountType(boolean paramBoolean, BmqqAccountType paramBmqqAccountType)
  {
    super.onGetAccountType(paramBoolean, paramBmqqAccountType);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "onGetAccountType isSuccess: " + paramBoolean + " | type: " + paramBmqqAccountType + " | cardInfo.allinone.uin: " + this.a.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
    }
    if ((paramBmqqAccountType != null) && (paramBmqqAccountType.getUin() != null) && (this.a.jdField_a_of_type_Awqt != null) && (this.a.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramBmqqAccountType.getUin().equals(this.a.jdField_a_of_type_Awqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)))
    {
      this.a.c = paramBmqqAccountType.getAccountType();
      this.a.b();
      if (this.a.c == 1) {
        this.a.jdField_a_of_type_Bfyh.b(this.a, paramBmqqAccountType);
      }
    }
    else
    {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfyr
 * JD-Core Version:    0.7.0.1
 */