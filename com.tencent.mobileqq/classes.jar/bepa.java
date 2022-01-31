import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class bepa
  implements View.OnClickListener
{
  final WeakReference<QQAppInterface> a;
  final WeakReference<awmk> b;
  
  public bepa(QQAppInterface paramQQAppInterface, awmk paramawmk)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramawmk);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    awmk localawmk = (awmk)this.b.get();
    if ((localQQAppInterface == null) || (localawmk == null) || (localawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {
      return;
    }
    if (((bcbt)localQQAppInterface.getManager(346)).b(localawmk.jdField_a_of_type_JavaLangString)) {}
    for (String str = bckj.a().a(localawmk.jdField_a_of_type_JavaLangString, localawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; str = bckj.a().a(localawmk.jdField_a_of_type_JavaLangString, localawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, awnk.a(localQQAppInterface, localawmk.jdField_a_of_type_JavaLangString, localawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localawmk.jdField_a_of_type_ComTencentMobileqqDataCard), "3", "aio"))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      paramView.getContext().startActivity(localIntent);
      if (bbpo.a().a(localawmk.jdField_a_of_type_JavaLangString, localawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        paramView = paramView.findViewById(2131375500);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        bbpo.a().a(localawmk.jdField_a_of_type_JavaLangString, localawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      bbpo.a("grp_data", "clk_medal");
      new azmo(localQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("title_clk").a(new String[] { localawmk.jdField_a_of_type_JavaLangString }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepa
 * JD-Core Version:    0.7.0.1
 */