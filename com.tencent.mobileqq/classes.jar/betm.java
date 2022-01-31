import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.ProfileViewOnClickListener.1;
import java.lang.ref.WeakReference;

public class betm
  implements View.OnClickListener
{
  private final WeakReference<ProfileCardMoreInfoView> a;
  
  public betm(ProfileCardMoreInfoView paramProfileCardMoreInfoView)
  {
    this.a = new WeakReference(paramProfileCardMoreInfoView);
  }
  
  public void a()
  {
    Object localObject = (ProfileCardMoreInfoView)this.a.get();
    if (localObject == null) {}
    BaseActivity localBaseActivity;
    QQAppInterface localQQAppInterface;
    awqt localawqt;
    do
    {
      return;
      localBaseActivity = ((ProfileCardMoreInfoView)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      localQQAppInterface = ((ProfileCardMoreInfoView)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localawqt = ((ProfileCardMoreInfoView)localObject).jdField_a_of_type_Awqt;
    } while ((localBaseActivity == null) || (localQQAppInterface == null) || (localawqt == null));
    Intent localIntent = new Intent(localBaseActivity, QQBrowserActivity.class);
    boolean bool;
    label80:
    int j;
    int i;
    if (localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      bool = true;
      if (bool) {
        break label206;
      }
      localObject = localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      j = 2;
      i = MedalWallMng.b;
    }
    for (;;)
    {
      localIntent.putExtra("url", ((MedalWallMng)localQQAppInterface.getManager(250)).a(bool, (String)localObject, i));
      localBaseActivity.startActivityForResult(localIntent, 1027);
      azqs.b(localQQAppInterface, "dc00898", "", "", "0X800738D", "0X800738D", j, 0, "", "", "", "");
      if (!bool) {
        break;
      }
      localawqt.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount = 0;
      localawqt.jdField_a_of_type_ComTencentMobileqqDataCard.iUpgradeCount = 0;
      ThreadManager.excute(new ProfileViewOnClickListener.1(this, localQQAppInterface), 16, null, true);
      return;
      bool = false;
      break label80;
      label206:
      localObject = localQQAppInterface.getCurrentAccountUin();
      j = ((avsm)localQQAppInterface.getManager(160)).a();
      i = MedalWallMng.jdField_a_of_type_Int;
      if (localawqt.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount > 0)
      {
        j = 4;
        i = MedalWallMng.c;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int j = 2;
    Object localObject = (ProfileCardMoreInfoView)this.a.get();
    if (localObject == null) {}
    BaseActivity localBaseActivity;
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        localBaseActivity = ((ProfileCardMoreInfoView)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
        localQQAppInterface = ((ProfileCardMoreInfoView)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject = ((ProfileCardMoreInfoView)localObject).jdField_a_of_type_Awqt;
      } while ((localBaseActivity == null) || (localQQAppInterface == null) || (localObject == null));
      paramView = paramView.getTag();
    } while (!(paramView instanceof awor));
    switch (((awor)paramView).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 66: 
      bddf.a((awqt)localObject, localQQAppInterface, localBaseActivity);
      int i = j;
      if (((awqt)localObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
      {
        i = j;
        if (((awqt)localObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          i = 1;
        }
      }
      azqs.b(localQQAppInterface, "dc00898", "", "", "0X8009999", "0X8009999", i, 0, "", "", "", "");
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betm
 * JD-Core Version:    0.7.0.1
 */