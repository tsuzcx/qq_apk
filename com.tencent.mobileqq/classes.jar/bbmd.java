import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class bbmd
  implements View.OnClickListener
{
  final WeakReference<QQAppInterface> a;
  final WeakReference<atwx> b;
  
  public bbmd(QQAppInterface paramQQAppInterface, atwx paramatwx)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramatwx);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    atwx localatwx = (atwx)this.b.get();
    if ((localQQAppInterface == null) || (localatwx == null) || (localatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {
      return;
    }
    if (((azcd)localQQAppInterface.getManager(346)).a(localatwx.jdField_a_of_type_JavaLangString, false)) {}
    for (String str = azkf.a().a(localatwx.jdField_a_of_type_JavaLangString, localatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; str = azkf.a().a(localatwx.jdField_a_of_type_JavaLangString, localatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, atxx.a(localQQAppInterface, localatwx.jdField_a_of_type_JavaLangString, localatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localatwx.jdField_a_of_type_ComTencentMobileqqDataCard), "3", "aio"))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      paramView.getContext().startActivity(localIntent);
      if (ayqn.a().a(localatwx.jdField_a_of_type_JavaLangString, localatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        paramView = paramView.findViewById(2131309284);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        ayqn.a().a(localatwx.jdField_a_of_type_JavaLangString, localatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      ayqn.a("grp_data", "clk_medal");
      new awrb(localQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("title_clk").a(new String[] { localatwx.jdField_a_of_type_JavaLangString }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbmd
 * JD-Core Version:    0.7.0.1
 */