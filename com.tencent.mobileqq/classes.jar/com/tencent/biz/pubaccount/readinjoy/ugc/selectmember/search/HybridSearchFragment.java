package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search;

import ajed;
import android.view.View;
import avkj;
import avon;
import avrb;
import avtz;
import avuz;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pwd;
import pwf;
import pwg;
import pwh;

public class HybridSearchFragment
  extends BaseSearchFragment
  implements avrb
{
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private pwg jdField_a_of_type_Pwg;
  
  public static HybridSearchFragment a()
  {
    return new HybridSearchFragment();
  }
  
  public avkj a()
  {
    return new pwf(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_Azwg);
  }
  
  public avuz a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localHashSet.add(ajed.aB);
    localArrayList.add(new avtz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 1, null, localHashSet));
    localArrayList.add(new pwd());
    return new pwh(localArrayList);
  }
  
  public void a(View paramView)
  {
    paramView = (avon)paramView.getTag(2131313373);
    if (this.jdField_a_of_type_Pwg != null) {
      this.jdField_a_of_type_Pwg.a(paramView);
    }
  }
  
  public void a(pwg parampwg)
  {
    this.jdField_a_of_type_Pwg = parampwg;
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