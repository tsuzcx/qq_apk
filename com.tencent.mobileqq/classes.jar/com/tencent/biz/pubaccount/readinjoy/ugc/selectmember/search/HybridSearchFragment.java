package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search;

import ajsf;
import android.view.View;
import awkc;
import awog;
import awqu;
import awts;
import awus;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import qib;
import qid;
import qie;
import qif;

public class HybridSearchFragment
  extends BaseSearchFragment
  implements awqu
{
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private qie jdField_a_of_type_Qie;
  
  public static HybridSearchFragment a()
  {
    return new HybridSearchFragment();
  }
  
  public awkc a()
  {
    return new qid(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Baxk);
  }
  
  public awus a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localHashSet.add(ajsf.aC);
    localArrayList.add(new awts(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 1, null, localHashSet));
    localArrayList.add(new qib());
    return new qif(localArrayList);
  }
  
  public void a(View paramView)
  {
    paramView = (awog)paramView.getTag(2131379208);
    if (this.jdField_a_of_type_Qie != null) {
      this.jdField_a_of_type_Qie.a(paramView);
    }
  }
  
  public void a(qie paramqie)
  {
    this.jdField_a_of_type_Qie = paramqie;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b_(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilSet.addAll(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.HybridSearchFragment
 * JD-Core Version:    0.7.0.1
 */