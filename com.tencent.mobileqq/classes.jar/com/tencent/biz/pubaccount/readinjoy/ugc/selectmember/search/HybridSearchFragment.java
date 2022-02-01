package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search;

import android.view.View;
import antf;
import bcbi;
import bcfr;
import bcie;
import bclc;
import bcmc;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rie;
import rig;
import rih;
import rii;

public class HybridSearchFragment
  extends BaseSearchFragment
  implements bcie
{
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private rih jdField_a_of_type_Rih;
  
  public static HybridSearchFragment a()
  {
    return new HybridSearchFragment();
  }
  
  public bcbi a()
  {
    return new rig(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Aoof);
  }
  
  public bcmc a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localHashSet.add(antf.aC);
    localArrayList.add(new bclc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 1, null, localHashSet));
    localArrayList.add(new rie());
    return new rii(localArrayList);
  }
  
  public void a(View paramView)
  {
    paramView = (bcfr)paramView.getTag(2131381109);
    if (this.jdField_a_of_type_Rih != null) {
      this.jdField_a_of_type_Rih.a(paramView);
    }
  }
  
  public void a(rih paramrih)
  {
    this.jdField_a_of_type_Rih = paramrih;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.HybridSearchFragment
 * JD-Core Version:    0.7.0.1
 */