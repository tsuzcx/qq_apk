import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class betj
  implements View.OnClickListener
{
  final WeakReference<QQAppInterface> a;
  final WeakReference<awqt> b;
  
  public betj(QQAppInterface paramQQAppInterface, awqt paramawqt)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramawqt);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    awqt localawqt = (awqt)this.b.get();
    if ((localQQAppInterface == null) || (localawqt == null) || (localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {
      return;
    }
    if (((bcgc)localQQAppInterface.getManager(346)).b(localawqt.jdField_a_of_type_JavaLangString)) {}
    for (String str = bcos.a().a(localawqt.jdField_a_of_type_JavaLangString, localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; str = bcos.a().a(localawqt.jdField_a_of_type_JavaLangString, localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, awrt.a(localQQAppInterface, localawqt.jdField_a_of_type_JavaLangString, localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localawqt.jdField_a_of_type_ComTencentMobileqqDataCard), "3", "aio"))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      paramView.getContext().startActivity(localIntent);
      if (bbtx.a().a(localawqt.jdField_a_of_type_JavaLangString, localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        paramView = paramView.findViewById(2131375551);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        bbtx.a().a(localawqt.jdField_a_of_type_JavaLangString, localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      bbtx.a("grp_data", "clk_medal");
      new azqx(localQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("title_clk").a(new String[] { localawqt.jdField_a_of_type_JavaLangString }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betj
 * JD-Core Version:    0.7.0.1
 */