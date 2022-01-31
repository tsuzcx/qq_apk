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

public class ayjr
  implements View.OnClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ayjs(this);
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ayjo jdField_a_of_type_Ayjo;
  aylh jdField_a_of_type_Aylh = new ayjt(this);
  aylj jdField_a_of_type_Aylj;
  ArrayList<ayld> jdField_a_of_type_JavaUtilArrayList;
  View jdField_b_of_type_AndroidViewView;
  ArrayList<ayjp> jdField_b_of_type_JavaUtilArrayList;
  
  public ayjr(ayjo paramayjo, View paramView)
  {
    this.jdField_a_of_type_Ayjo = paramayjo;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303614));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131299276);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    ayjp localayjp = new ayjp(paramView.findViewById(2131303615), 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localayjp);
    localayjp = new ayjp(paramView.findViewById(2131303616), 1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localayjp);
    localayjp = new ayjp(paramView.findViewById(2131303617), 2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localayjp);
    paramView = new ayjp(paramView.findViewById(2131303618), 3);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    paramView = new ayld((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131303619), paramayjo.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Aylh);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    paramayjo = new ayld((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131303620), paramayjo.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Aylh);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramayjo);
  }
  
  public void a(aylj paramaylj)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ayld)((Iterator)localObject).next()).a();
    }
    this.jdField_a_of_type_Aylj = paramaylj;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramaylj.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramaylj.jdField_b_of_type_JavaLangString);
    if (paramaylj.jdField_b_of_type_JavaLangString.equals(ayjo.jdField_a_of_type_JavaLangString))
    {
      localObject = (TroopManager)this.jdField_a_of_type_Ayjo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
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
      while (i < paramaylj.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((ayjp)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a(this.jdField_a_of_type_Ayjo.jdField_a_of_type_AndroidContentContext, (aylj)paramaylj.jdField_a_of_type_JavaUtilArrayList.get(i), this);
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    ayjp localayjp = (ayjp)paramView.getTag();
    if ((localayjp == null) || (localayjp.jdField_a_of_type_Aylj == null)) {
      return;
    }
    aylj localaylj = localayjp.jdField_a_of_type_Aylj;
    if (localaylj.jdField_a_of_type_JavaLangString == null) {}
    for (paramView = "";; paramView = localaylj.jdField_a_of_type_JavaLangString)
    {
      awqx.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, paramView, "", "", "");
      if (!localaylj.jdField_a_of_type_Boolean) {
        break;
      }
      int i = localayjp.jdField_a_of_type_Int / 2;
      ((ayld)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(localayjp, localaylj);
      return;
    }
    if (localaylj.jdField_b_of_type_Int == 1)
    {
      if ((localaylj.jdField_a_of_type_JavaLangString.equals("20001")) || (localaylj.jdField_a_of_type_JavaLangString.equals("20002")))
      {
        paramView = (TroopManager)this.jdField_a_of_type_Ayjo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (paramView.a.jdField_a_of_type_Boolean)
        {
          paramView.g();
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_Ayjo.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localaylj.jdField_a_of_type_JavaLangString);
        if (localaylj.jdField_a_of_type_JavaLangString.equals("20001")) {}
        for (paramView = "Clk_type_2";; paramView = "Clk_type_3")
        {
          awqx.b(this.jdField_a_of_type_Ayjo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_mobile", "", "chose_type", paramView, 0, 0, "", "", "", "");
          return;
        }
      }
      if (localaylj.jdField_a_of_type_JavaLangString.equals("20003"))
      {
        QLog.e("vip_pretty.createNewTroop.CateListAdapter", 1, "click the create pretty troop icon");
        bahl.a(amip.c().a("category"), this.jdField_a_of_type_Ayjo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), (Activity)this.jdField_a_of_type_Ayjo.jdField_a_of_type_AndroidContentContext);
        awqx.b(this.jdField_a_of_type_Ayjo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A582", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_Ayjo.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localaylj.jdField_a_of_type_JavaLangString, null);
      return;
    }
    this.jdField_a_of_type_Ayjo.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localaylj.d, localaylj.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayjr
 * JD-Core Version:    0.7.0.1
 */