package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search;

import ajsd;
import android.view.View;
import awke;
import awoi;
import awqw;
import awtu;
import awuu;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import qhy;
import qia;
import qib;
import qic;

public class HybridSearchFragment
  extends BaseSearchFragment
  implements awqw
{
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private qib jdField_a_of_type_Qib;
  
  public static HybridSearchFragment a()
  {
    return new HybridSearchFragment();
  }
  
  public awke a()
  {
    return new qia(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Baxy);
  }
  
  public awuu a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localHashSet.add(ajsd.aC);
    localArrayList.add(new awtu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 1, null, localHashSet));
    localArrayList.add(new qhy());
    return new qic(localArrayList);
  }
  
  public void a(View paramView)
  {
    paramView = (awoi)paramView.getTag(2131379213);
    if (this.jdField_a_of_type_Qib != null) {
      this.jdField_a_of_type_Qib.a(paramView);
    }
  }
  
  public void a(qib paramqib)
  {
    this.jdField_a_of_type_Qib = paramqib;
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