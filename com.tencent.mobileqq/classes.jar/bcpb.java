import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class bcpb
  implements View.OnClickListener
{
  final WeakReference<QQAppInterface> a;
  final WeakReference<auuw> b;
  
  public bcpb(QQAppInterface paramQQAppInterface, auuw paramauuw)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramauuw);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    auuw localauuw = (auuw)this.b.get();
    if ((localQQAppInterface == null) || (localauuw == null) || (localauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {
      return;
    }
    if (((bacv)localQQAppInterface.getManager(346)).b(localauuw.jdField_a_of_type_JavaLangString)) {}
    for (String str = bali.a().a(localauuw.jdField_a_of_type_JavaLangString, localauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; str = bali.a().a(localauuw.jdField_a_of_type_JavaLangString, localauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, auvw.a(localQQAppInterface, localauuw.jdField_a_of_type_JavaLangString, localauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localauuw.jdField_a_of_type_ComTencentMobileqqDataCard), "3", "aio"))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      paramView.getContext().startActivity(localIntent);
      if (azrd.a().a(localauuw.jdField_a_of_type_JavaLangString, localauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        paramView = paramView.findViewById(2131375028);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        azrd.a().a(localauuw.jdField_a_of_type_JavaLangString, localauuw.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      azrd.a("grp_data", "clk_medal");
      new axra(localQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("title_clk").a(new String[] { localauuw.jdField_a_of_type_JavaLangString }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcpb
 * JD-Core Version:    0.7.0.1
 */