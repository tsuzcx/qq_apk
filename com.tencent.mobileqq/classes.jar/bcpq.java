import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class bcpq
  implements View.OnClickListener
{
  final WeakReference<QQAppInterface> a;
  final WeakReference<auuy> b;
  
  public bcpq(QQAppInterface paramQQAppInterface, auuy paramauuy)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramauuy);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    auuy localauuy = (auuy)this.b.get();
    if ((localQQAppInterface == null) || (localauuy == null) || (localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {
      return;
    }
    if (((badj)localQQAppInterface.getManager(346)).b(localauuy.jdField_a_of_type_JavaLangString)) {}
    for (String str = balw.a().a(localauuy.jdField_a_of_type_JavaLangString, localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; str = balw.a().a(localauuy.jdField_a_of_type_JavaLangString, localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, auvy.a(localQQAppInterface, localauuy.jdField_a_of_type_JavaLangString, localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localauuy.jdField_a_of_type_ComTencentMobileqqDataCard), "3", "aio"))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      paramView.getContext().startActivity(localIntent);
      if (azrf.a().a(localauuy.jdField_a_of_type_JavaLangString, localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        paramView = paramView.findViewById(2131375030);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        azrf.a().a(localauuy.jdField_a_of_type_JavaLangString, localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      azrf.a("grp_data", "clk_medal");
      new axrc(localQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("title_clk").a(new String[] { localauuy.jdField_a_of_type_JavaLangString }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcpq
 * JD-Core Version:    0.7.0.1
 */