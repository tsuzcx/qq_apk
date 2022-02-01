import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class bfdj
  implements View.OnClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bfdk(this);
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bfdg jdField_a_of_type_Bfdg;
  bfez jdField_a_of_type_Bfez = new bfdl(this);
  bffb jdField_a_of_type_Bffb;
  ArrayList<bfev> jdField_a_of_type_JavaUtilArrayList;
  View jdField_b_of_type_AndroidViewView;
  ArrayList<bfdh> jdField_b_of_type_JavaUtilArrayList;
  
  public bfdj(bfdg parambfdg, View paramView)
  {
    this.jdField_a_of_type_Bfdg = parambfdg;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370199));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365321);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    bfdh localbfdh = new bfdh(paramView.findViewById(2131370200), 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbfdh);
    localbfdh = new bfdh(paramView.findViewById(2131370201), 1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbfdh);
    localbfdh = new bfdh(paramView.findViewById(2131370202), 2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbfdh);
    paramView = new bfdh(paramView.findViewById(2131370203), 3);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    paramView = new bfev((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131370204), parambfdg.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Bfez);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    parambfdg = new bfev((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131370205), parambfdg.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Bfez);
    this.jdField_a_of_type_JavaUtilArrayList.add(parambfdg);
  }
  
  public void a(bffb parambffb)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bfev)((Iterator)localObject).next()).a();
    }
    this.jdField_a_of_type_Bffb = parambffb;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambffb.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(parambffb.jdField_b_of_type_JavaLangString);
    if (parambffb.jdField_b_of_type_JavaLangString.equals(bfdg.jdField_a_of_type_JavaLangString))
    {
      localObject = (TroopManager)this.jdField_a_of_type_Bfdg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      boolean bool = ((TroopManager)localObject).c();
      if (((TroopManager)localObject).a.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_b_of_type_AndroidViewView;
        if (!bool) {
          break label182;
        }
      }
    }
    label182:
    for (int i = 8;; i = 0)
    {
      ((View)localObject).setVisibility(i);
      i = 0;
      while (i < parambffb.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((bfdh)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a(this.jdField_a_of_type_Bfdg.jdField_a_of_type_AndroidContentContext, (bffb)parambffb.jdField_a_of_type_JavaUtilArrayList.get(i), this);
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    bfdh localbfdh = (bfdh)paramView.getTag();
    if ((localbfdh == null) || (localbfdh.jdField_a_of_type_Bffb == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bffb localbffb = localbfdh.jdField_a_of_type_Bffb;
      if (localbffb.jdField_a_of_type_JavaLangString == null) {}
      for (Object localObject = "";; localObject = localbffb.jdField_a_of_type_JavaLangString)
      {
        bdla.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, (String)localObject, "", "", "");
        if (!localbffb.jdField_a_of_type_Boolean) {
          break label118;
        }
        int i = localbfdh.jdField_a_of_type_Int / 2;
        ((bfev)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(localbfdh, localbffb);
        break;
      }
      label118:
      if (localbffb.jdField_b_of_type_Int == 1)
      {
        if ((localbffb.jdField_a_of_type_JavaLangString.equals("20001")) || (localbffb.jdField_a_of_type_JavaLangString.equals("20002")))
        {
          localObject = (TroopManager)this.jdField_a_of_type_Bfdg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          if (((TroopManager)localObject).a.jdField_a_of_type_Boolean)
          {
            ((TroopManager)localObject).g();
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          }
          this.jdField_a_of_type_Bfdg.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbffb.jdField_a_of_type_JavaLangString);
          if (localbffb.jdField_a_of_type_JavaLangString.equals("20001")) {}
          for (localObject = "Clk_type_2";; localObject = "Clk_type_3")
          {
            bdla.b(this.jdField_a_of_type_Bfdg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_mobile", "", "chose_type", (String)localObject, 0, 0, "", "", "", "");
            break;
          }
        }
        if (localbffb.jdField_a_of_type_JavaLangString.equals("20003"))
        {
          QLog.e("vip_pretty.createNewTroop.CateListAdapter", 1, "click the create pretty troop icon");
          bhha.a(arju.c().a("category"), this.jdField_a_of_type_Bfdg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), (Activity)this.jdField_a_of_type_Bfdg.jdField_a_of_type_AndroidContentContext);
          bdla.b(this.jdField_a_of_type_Bfdg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A582", 0, 0, "", "", "", "");
        }
        else
        {
          this.jdField_a_of_type_Bfdg.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbffb.jdField_a_of_type_JavaLangString, null);
        }
      }
      else
      {
        this.jdField_a_of_type_Bfdg.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbffb.d, localbffb.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfdj
 * JD-Core Version:    0.7.0.1
 */