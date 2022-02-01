package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search;

import android.view.View;
import anhk;
import bbio;
import bbmy;
import bbpl;
import bbsj;
import bbtj;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rri;
import rrk;
import rrl;
import rrm;

public class HybridSearchFragment
  extends BaseSearchFragment
  implements bbpl
{
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private rrl jdField_a_of_type_Rrl;
  
  public static HybridSearchFragment a()
  {
    return new HybridSearchFragment();
  }
  
  public bbio a()
  {
    return new rrk(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Aobu);
  }
  
  public bbtj a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localHashSet.add(anhk.aC);
    localArrayList.add(new bbsj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 1, null, localHashSet));
    localArrayList.add(new rri());
    return new rrm(localArrayList);
  }
  
  public void a(View paramView)
  {
    paramView = (bbmy)paramView.getTag(2131380929);
    if (this.jdField_a_of_type_Rrl != null) {
      this.jdField_a_of_type_Rrl.a(paramView);
    }
  }
  
  public void a(rrl paramrrl)
  {
    this.jdField_a_of_type_Rrl = paramrrl;
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