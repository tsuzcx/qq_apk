import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bimf
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  public bimf(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      long l = System.currentTimeMillis();
      if (Math.abs(l - this.jdField_a_of_type_Long) >= 1000L)
      {
        this.jdField_a_of_type_Long = l;
        Object localObject1 = (aykg)paramView.getTag();
        Object localObject2;
        switch (((aykg)localObject1).jdField_a_of_type_Int)
        {
        default: 
          break;
        case 4: 
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.b(String.valueOf(((aykg)localObject1).jdField_a_of_type_JavaLangObject));
          break;
        case 7: 
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.f();
          break;
        case 20: 
          bcef.b(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.app, "dc00899", "Qidian", "", "0X8008FEB", "qidianMasterVideo", 1, 1, 0, "1", "1", "", "");
          if (this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.c == 6) {
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.app, this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, 1024, this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.nickname, null, true, null, true, true, null, "from_internal");
          } else {
            FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.app, this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_Aymg);
          }
          break;
        case 55: 
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.e();
          break;
        case 8: 
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.d(((Integer)((aykg)localObject1).jdField_a_of_type_JavaLangObject).intValue());
          break;
        case 52: 
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.a(String.valueOf(((aykg)localObject1).jdField_a_of_type_JavaLangObject));
          break;
        case 47: 
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.e(String.valueOf(((aykg)localObject1).jdField_a_of_type_JavaLangObject));
          break;
        case 48: 
          localObject2 = (String[])((aykg)localObject1).jdField_a_of_type_JavaLangObject;
          localObject1 = localObject2[0];
          localObject2 = localObject2[1];
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.a((String)localObject1, (String)localObject2);
          break;
        case 49: 
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.c(String.valueOf(((aykg)localObject1).jdField_a_of_type_JavaLangObject));
          break;
        case 50: 
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.a((binl)((aykg)localObject1).jdField_a_of_type_JavaLangObject);
          break;
        case 51: 
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.d(String.valueOf(((aykg)localObject1).jdField_a_of_type_JavaLangObject));
          break;
        case 53: 
          this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.d();
          break;
        case 54: 
          localObject1 = bfwg.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.app, this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, String.valueOf(((aykg)localObject1).jdField_a_of_type_JavaLangObject));
          if (localObject1 != null) {
            ((bfvp)localObject1).a();
          }
          break;
        case 75: 
          QidianProfileCardActivity.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, String.valueOf(((aykg)localObject1).jdField_a_of_type_JavaLangObject));
          break;
        case 76: 
          localObject1 = String.valueOf(((aykg)localObject1).jdField_a_of_type_JavaLangObject);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("|")))
          {
            localObject1 = ((String)localObject1).split("\\|");
            if ((localObject1 != null) && (localObject1.length == 2)) {
              QidianProfileCardActivity.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, localObject1[0], localObject1[1]);
            }
          }
          break;
        case 82: 
          if (!QidianProfileCardActivity.b(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity))
          {
            QidianProfileCardActivity.b(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, true);
            if ((this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_Aymg != null) && (this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqDataCard != null))
            {
              this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqDataCard.vQzoneCoverInfo);
            }
            else
            {
              this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.a(2131694821);
              localObject1 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_Amov;
              localObject2 = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.app.getCurrentAccountUin();
              String str = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a;
              l = ProfileActivity.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, false);
              ((amov)localObject1).a((String)localObject2, str, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", l, 10004, new byte[] { 0 }, (byte)0);
            }
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bimf
 * JD-Core Version:    0.7.0.1
 */