import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class benp
  implements View.OnClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new benq(this);
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  benm jdField_a_of_type_Benm;
  bepf jdField_a_of_type_Bepf = new benr(this);
  beph jdField_a_of_type_Beph;
  ArrayList<bepb> jdField_a_of_type_JavaUtilArrayList;
  View jdField_b_of_type_AndroidViewView;
  ArrayList<benn> jdField_b_of_type_JavaUtilArrayList;
  
  public benp(benm parambenm, View paramView)
  {
    this.jdField_a_of_type_Benm = parambenm;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369932));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365161);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    benn localbenn = new benn(paramView.findViewById(2131369933), 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbenn);
    localbenn = new benn(paramView.findViewById(2131369934), 1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbenn);
    localbenn = new benn(paramView.findViewById(2131369935), 2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbenn);
    paramView = new benn(paramView.findViewById(2131369936), 3);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    paramView = new bepb((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131369937), parambenm.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Bepf);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    parambenm = new bepb((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131369938), parambenm.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Bepf);
    this.jdField_a_of_type_JavaUtilArrayList.add(parambenm);
  }
  
  public void a(beph parambeph)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bepb)((Iterator)localObject).next()).a();
    }
    this.jdField_a_of_type_Beph = parambeph;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambeph.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(parambeph.jdField_b_of_type_JavaLangString);
    if (parambeph.jdField_b_of_type_JavaLangString.equals(benm.jdField_a_of_type_JavaLangString))
    {
      localObject = (TroopManager)this.jdField_a_of_type_Benm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
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
      while (i < parambeph.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((benn)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a(this.jdField_a_of_type_Benm.jdField_a_of_type_AndroidContentContext, (beph)parambeph.jdField_a_of_type_JavaUtilArrayList.get(i), this);
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    benn localbenn = (benn)paramView.getTag();
    if ((localbenn == null) || (localbenn.jdField_a_of_type_Beph == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      beph localbeph = localbenn.jdField_a_of_type_Beph;
      if (localbeph.jdField_a_of_type_JavaLangString == null) {}
      for (Object localObject = "";; localObject = localbeph.jdField_a_of_type_JavaLangString)
      {
        bcst.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, (String)localObject, "", "", "");
        if (!localbeph.jdField_a_of_type_Boolean) {
          break label118;
        }
        int i = localbenn.jdField_a_of_type_Int / 2;
        ((bepb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(localbenn, localbeph);
        break;
      }
      label118:
      if (localbeph.jdField_b_of_type_Int == 1)
      {
        if ((localbeph.jdField_a_of_type_JavaLangString.equals("20001")) || (localbeph.jdField_a_of_type_JavaLangString.equals("20002")))
        {
          localObject = (TroopManager)this.jdField_a_of_type_Benm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          if (((TroopManager)localObject).a.jdField_a_of_type_Boolean)
          {
            ((TroopManager)localObject).g();
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          }
          this.jdField_a_of_type_Benm.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbeph.jdField_a_of_type_JavaLangString);
          if (localbeph.jdField_a_of_type_JavaLangString.equals("20001")) {}
          for (localObject = "Clk_type_2";; localObject = "Clk_type_3")
          {
            bcst.b(this.jdField_a_of_type_Benm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_mobile", "", "chose_type", (String)localObject, 0, 0, "", "", "", "");
            break;
          }
        }
        if (localbeph.jdField_a_of_type_JavaLangString.equals("20003"))
        {
          QLog.e("vip_pretty.createNewTroop.CateListAdapter", 1, "click the create pretty troop icon");
          bgrl.a(aqxc.c().a("category"), this.jdField_a_of_type_Benm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), (Activity)this.jdField_a_of_type_Benm.jdField_a_of_type_AndroidContentContext);
          bcst.b(this.jdField_a_of_type_Benm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A582", 0, 0, "", "", "", "");
        }
        else
        {
          this.jdField_a_of_type_Benm.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbeph.jdField_a_of_type_JavaLangString, null);
        }
      }
      else
      {
        this.jdField_a_of_type_Benm.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbeph.d, localbeph.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benp
 * JD-Core Version:    0.7.0.1
 */