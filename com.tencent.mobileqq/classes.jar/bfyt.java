import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;

public class bfyt
  extends nbn
{
  public bfyt(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void a(boolean paramBoolean, BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    this.a.a();
    if ((paramBoolean) && (paramBmqqUserSimpleInfo != null)) {
      if (paramBmqqUserSimpleInfo.mBmqqUin.equals(this.a.jdField_a_of_type_Awqt.a.a)) {
        if (!paramBmqqUserSimpleInfo.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo))
        {
          i = 1;
          if (i == 0) {
            break label80;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = paramBmqqUserSimpleInfo;
          this.a.c(0);
        }
      }
    }
    label80:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            int i = 0;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver not change");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver not current uin");
      return;
    }
    QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfyt
 * JD-Core Version:    0.7.0.1
 */