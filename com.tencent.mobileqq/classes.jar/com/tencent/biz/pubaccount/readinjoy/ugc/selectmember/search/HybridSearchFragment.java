package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search;

import alof;
import android.view.View;
import ayjn;
import aynu;
import ayqi;
import aytg;
import ayug;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import qwd;
import qwf;
import qwg;
import qwh;

public class HybridSearchFragment
  extends BaseSearchFragment
  implements ayqi
{
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private qwg jdField_a_of_type_Qwg;
  
  public static HybridSearchFragment a()
  {
    return new HybridSearchFragment();
  }
  
  public ayjn a()
  {
    return new qwf(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Bdbb);
  }
  
  public ayug a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localHashSet.add(alof.aC);
    localArrayList.add(new aytg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 1, null, localHashSet));
    localArrayList.add(new qwd());
    return new qwh(localArrayList);
  }
  
  public void a(View paramView)
  {
    paramView = (aynu)paramView.getTag(2131379971);
    if (this.jdField_a_of_type_Qwg != null) {
      this.jdField_a_of_type_Qwg.a(paramView);
    }
  }
  
  public void a(qwg paramqwg)
  {
    this.jdField_a_of_type_Qwg = paramqwg;
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