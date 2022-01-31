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

public class bbnb
  implements View.OnClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bbnc(this);
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bbmy jdField_a_of_type_Bbmy;
  bbor jdField_a_of_type_Bbor = new bbnd(this);
  bbot jdField_a_of_type_Bbot;
  ArrayList<bbon> jdField_a_of_type_JavaUtilArrayList;
  View jdField_b_of_type_AndroidViewView;
  ArrayList<bbmz> jdField_b_of_type_JavaUtilArrayList;
  
  public bbnb(bbmy parambbmy, View paramView)
  {
    this.jdField_a_of_type_Bbmy = parambbmy;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369537));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364926);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    bbmz localbbmz = new bbmz(paramView.findViewById(2131369538), 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbbmz);
    localbbmz = new bbmz(paramView.findViewById(2131369539), 1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbbmz);
    localbbmz = new bbmz(paramView.findViewById(2131369540), 2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbbmz);
    paramView = new bbmz(paramView.findViewById(2131369541), 3);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    paramView = new bbon((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131369542), parambbmy.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Bbor);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    parambbmy = new bbon((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131369543), parambbmy.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Bbor);
    this.jdField_a_of_type_JavaUtilArrayList.add(parambbmy);
  }
  
  public void a(bbot parambbot)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bbon)((Iterator)localObject).next()).a();
    }
    this.jdField_a_of_type_Bbot = parambbot;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambbot.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(parambbot.jdField_b_of_type_JavaLangString);
    if (parambbot.jdField_b_of_type_JavaLangString.equals(bbmy.jdField_a_of_type_JavaLangString))
    {
      localObject = (TroopManager)this.jdField_a_of_type_Bbmy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
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
      while (i < parambbot.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((bbmz)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a(this.jdField_a_of_type_Bbmy.jdField_a_of_type_AndroidContentContext, (bbot)parambbot.jdField_a_of_type_JavaUtilArrayList.get(i), this);
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    bbmz localbbmz = (bbmz)paramView.getTag();
    if ((localbbmz == null) || (localbbmz.jdField_a_of_type_Bbot == null)) {
      return;
    }
    bbot localbbot = localbbmz.jdField_a_of_type_Bbot;
    if (localbbot.jdField_a_of_type_JavaLangString == null) {}
    for (paramView = "";; paramView = localbbot.jdField_a_of_type_JavaLangString)
    {
      azqs.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, paramView, "", "", "");
      if (!localbbot.jdField_a_of_type_Boolean) {
        break;
      }
      int i = localbbmz.jdField_a_of_type_Int / 2;
      ((bbon)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(localbbmz, localbbot);
      return;
    }
    if (localbbot.jdField_b_of_type_Int == 1)
    {
      if ((localbbot.jdField_a_of_type_JavaLangString.equals("20001")) || (localbbot.jdField_a_of_type_JavaLangString.equals("20002")))
      {
        paramView = (TroopManager)this.jdField_a_of_type_Bbmy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (paramView.a.jdField_a_of_type_Boolean)
        {
          paramView.g();
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_Bbmy.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbbot.jdField_a_of_type_JavaLangString);
        if (localbbot.jdField_a_of_type_JavaLangString.equals("20001")) {}
        for (paramView = "Clk_type_2";; paramView = "Clk_type_3")
        {
          azqs.b(this.jdField_a_of_type_Bbmy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_mobile", "", "chose_type", paramView, 0, 0, "", "", "", "");
          return;
        }
      }
      if (localbbot.jdField_a_of_type_JavaLangString.equals("20003"))
      {
        QLog.e("vip_pretty.createNewTroop.CateListAdapter", 1, "click the create pretty troop icon");
        bdmj.a(aouq.c().a("category"), this.jdField_a_of_type_Bbmy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), (Activity)this.jdField_a_of_type_Bbmy.jdField_a_of_type_AndroidContentContext);
        azqs.b(this.jdField_a_of_type_Bbmy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A582", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_Bbmy.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbbot.jdField_a_of_type_JavaLangString, null);
      return;
    }
    this.jdField_a_of_type_Bbmy.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbbot.d, localbbot.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbnb
 * JD-Core Version:    0.7.0.1
 */