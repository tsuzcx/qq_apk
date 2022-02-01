package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search;

import android.view.View;
import bcbc;
import bcfj;
import bchy;
import bckw;
import bclw;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import sbt;
import sbv;
import sbw;
import sbx;

public class HybridSearchFragment
  extends BaseSearchFragment
  implements bchy
{
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private sbw jdField_a_of_type_Sbw;
  
  public static HybridSearchFragment a()
  {
    return new HybridSearchFragment();
  }
  
  public bcbc a()
  {
    return new sbv(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
  }
  
  public bclw a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localHashSet.add(AppConstants.BABY_Q_UIN);
    localArrayList.add(new bckw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 1, null, localHashSet));
    localArrayList.add(new sbt());
    return new sbx(localArrayList);
  }
  
  public void a(sbw paramsbw)
  {
    this.jdField_a_of_type_Sbw = paramsbw;
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
    paramView = (bcfj)paramView.getTag(2131381183);
    if (this.jdField_a_of_type_Sbw != null) {
      this.jdField_a_of_type_Sbw.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.HybridSearchFragment
 * JD-Core Version:    0.7.0.1
 */