import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import java.util.ArrayList;
import java.util.Iterator;

public class bbis
  implements View.OnClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bbit(this);
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bbip jdField_a_of_type_Bbip;
  bbki jdField_a_of_type_Bbki = new bbiu(this);
  bbkk jdField_a_of_type_Bbkk;
  ArrayList<bbke> jdField_a_of_type_JavaUtilArrayList;
  View jdField_b_of_type_AndroidViewView;
  ArrayList<bbiq> jdField_b_of_type_JavaUtilArrayList;
  
  public bbis(bbip parambbip, View paramView)
  {
    this.jdField_a_of_type_Bbip = parambbip;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369519));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364924);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    bbiq localbbiq = new bbiq(paramView.findViewById(2131369520), 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbbiq);
    localbbiq = new bbiq(paramView.findViewById(2131369521), 1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbbiq);
    localbbiq = new bbiq(paramView.findViewById(2131369522), 2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbbiq);
    paramView = new bbiq(paramView.findViewById(2131369523), 3);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    paramView = new bbke((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131369524), parambbip.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Bbki);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    parambbip = new bbke((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131369525), parambbip.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Bbki);
    this.jdField_a_of_type_JavaUtilArrayList.add(parambbip);
  }
  
  public void a(bbkk parambbkk)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bbke)((Iterator)localObject).next()).a();
    }
    this.jdField_a_of_type_Bbkk = parambbkk;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambbkk.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(parambbkk.jdField_b_of_type_JavaLangString);
    if (parambbkk.jdField_b_of_type_JavaLangString.equals(bbip.jdField_a_of_type_JavaLangString))
    {
      localObject = (TroopManager)this.jdField_a_of_type_Bbip.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      boolean bool = ((TroopManager)localObject).c();
      if (((TroopManager)localObject).a.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_b_of_type_AndroidViewView;
        if (!bool) {
          break label181;
        }
      }
    }
    label181:
    for (int i = 8;; i = 0)
    {
      ((View)localObject).setVisibility(i);
      i = 0;
      while (i < parambbkk.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((bbiq)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a(this.jdField_a_of_type_Bbip.jdField_a_of_type_AndroidContentContext, (bbkk)parambbkk.jdField_a_of_type_JavaUtilArrayList.get(i), this);
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    bbiq localbbiq = (bbiq)paramView.getTag();
    if ((localbbiq == null) || (localbbiq.jdField_a_of_type_Bbkk == null)) {
      return;
    }
    bbkk localbbkk = localbbiq.jdField_a_of_type_Bbkk;
    if (localbbkk.jdField_a_of_type_JavaLangString == null) {}
    for (paramView = "";; paramView = localbbkk.jdField_a_of_type_JavaLangString)
    {
      azmj.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, paramView, "", "", "");
      if (!localbbkk.jdField_a_of_type_Boolean) {
        break;
      }
      int i = localbbiq.jdField_a_of_type_Int / 2;
      ((bbke)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(localbbiq, localbbkk);
      return;
    }
    if (localbbkk.jdField_b_of_type_Int == 1)
    {
      if ((localbbkk.jdField_a_of_type_JavaLangString.equals("20001")) || (localbbkk.jdField_a_of_type_JavaLangString.equals("20002")))
      {
        paramView = (TroopManager)this.jdField_a_of_type_Bbip.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (paramView.a.jdField_a_of_type_Boolean)
        {
          paramView.g();
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_Bbip.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbbkk.jdField_a_of_type_JavaLangString);
        if (localbbkk.jdField_a_of_type_JavaLangString.equals("20001")) {}
        for (paramView = "Clk_type_2";; paramView = "Clk_type_3")
        {
          azmj.b(this.jdField_a_of_type_Bbip.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_mobile", "", "chose_type", paramView, 0, 0, "", "", "", "");
          return;
        }
      }
      if (localbbkk.jdField_a_of_type_JavaLangString.equals("20003"))
      {
        QLog.e("vip_pretty.createNewTroop.CateListAdapter", 1, "click the create pretty troop icon");
        bdia.a(aoqh.c().a("category"), this.jdField_a_of_type_Bbip.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), (Activity)this.jdField_a_of_type_Bbip.jdField_a_of_type_AndroidContentContext);
        azmj.b(this.jdField_a_of_type_Bbip.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A582", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_Bbip.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbbkk.jdField_a_of_type_JavaLangString, null);
      return;
    }
    this.jdField_a_of_type_Bbip.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbbkk.d, localbbkk.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbis
 * JD-Core Version:    0.7.0.1
 */