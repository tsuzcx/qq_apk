package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search;

import android.view.View;
import baum;
import bayt;
import bbbg;
import bbee;
import bbfe;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rpe;
import rpg;
import rph;
import rpi;

public class HybridSearchFragment
  extends BaseSearchFragment
  implements bbbg
{
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private rph jdField_a_of_type_Rph;
  
  public static HybridSearchFragment a()
  {
    return new HybridSearchFragment();
  }
  
  public baum a()
  {
    return new rpg(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
  }
  
  public bbfe a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localHashSet.add(AppConstants.BABY_Q_UIN);
    localArrayList.add(new bbee(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 1, null, localHashSet));
    localArrayList.add(new rpe());
    return new rpi(localArrayList);
  }
  
  public void a(rph paramrph)
  {
    this.jdField_a_of_type_Rph = paramrph;
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
  
  public void onAction(View paramView)
  {
    paramView = (bayt)paramView.getTag(2131380831);
    if (this.jdField_a_of_type_Rph != null) {
      this.jdField_a_of_type_Rph.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.HybridSearchFragment
 * JD-Core Version:    0.7.0.1
 */