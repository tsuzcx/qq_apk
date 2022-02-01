import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class bhhe
  implements View.OnClickListener
{
  final WeakReference<QQAppInterface> a;
  final WeakReference<aymg> b;
  
  public bhhe(QQAppInterface paramQQAppInterface, aymg paramaymg)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramaymg);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    aymg localaymg = (aymg)this.b.get();
    if ((localQQAppInterface == null) || (localaymg == null) || (localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (((bepr)localQQAppInterface.getManager(346)).b(localaymg.jdField_a_of_type_JavaLangString)) {}
    for (Object localObject = bfcx.a().a(localaymg.jdField_a_of_type_JavaLangString, localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; localObject = bfcx.a().a(localaymg.jdField_a_of_type_JavaLangString, localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, aynd.a(localQQAppInterface, localaymg.jdField_a_of_type_JavaLangString, localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localaymg.jdField_a_of_type_ComTencentMobileqqDataCard), "3", "aio"))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      paramView.getContext().startActivity(localIntent);
      if (beda.a().a(localaymg.jdField_a_of_type_JavaLangString, localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        localObject = paramView.findViewById(2131376186);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        beda.a().a(localaymg.jdField_a_of_type_JavaLangString, localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      beda.a("grp_data", "clk_medal");
      new bcek(localQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("title_clk").a(new String[] { localaymg.jdField_a_of_type_JavaLangString }).a();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhhe
 * JD-Core Version:    0.7.0.1
 */