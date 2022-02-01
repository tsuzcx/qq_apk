package com.tencent.mobileqq.activity.phone;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.PhoneCodeUtils.CountryCode;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

class CountryActivity$SearchAdapter
  extends BaseAdapter
{
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<PhoneCodeUtils.CountryCode> jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity.jdField_a_of_type_JavaUtilArrayList;
  
  private CountryActivity$SearchAdapter(CountryActivity paramCountryActivity) {}
  
  private int a(PhoneCodeUtils.CountryCode paramCountryCode)
  {
    if (paramCountryCode.a) {
      return 0;
    }
    String str1 = this.jdField_a_of_type_JavaLangString;
    if (str1 != null)
    {
      if (str1.equals("")) {
        return 0;
      }
      String str2 = paramCountryCode.c;
      String str3 = paramCountryCode.b;
      str1 = paramCountryCode.d;
      paramCountryCode = str1;
      if (str1 != null) {
        paramCountryCode = str1.toLowerCase();
      }
      str1 = ChnToSpell.a(str3, 1);
      String str4 = ChnToSpell.a(str3, 2);
      if ((!str2.equals(this.jdField_a_of_type_JavaLangString)) && (!str3.equals(this.jdField_a_of_type_JavaLangString)) && (!str1.equals(this.jdField_a_of_type_JavaLangString)) && (!str4.equals(this.jdField_a_of_type_JavaLangString)) && ((paramCountryCode == null) || (!paramCountryCode.equals(this.jdField_a_of_type_JavaLangString))))
      {
        if ((str2.indexOf(this.jdField_a_of_type_JavaLangString) != 0) && (str3.indexOf(this.jdField_a_of_type_JavaLangString) != 0) && (str1.indexOf(this.jdField_a_of_type_JavaLangString) != 0) && (str4.indexOf(this.jdField_a_of_type_JavaLangString) != 0))
        {
          if ((paramCountryCode != null) && (paramCountryCode.indexOf(this.jdField_a_of_type_JavaLangString) == 0)) {
            return 2;
          }
          if ((str2.indexOf(this.jdField_a_of_type_JavaLangString) <= 0) && (str3.indexOf(this.jdField_a_of_type_JavaLangString) <= 0) && (str1.indexOf(this.jdField_a_of_type_JavaLangString) <= 0))
          {
            if (str4.indexOf(this.jdField_a_of_type_JavaLangString) > 0) {
              return 1;
            }
            return 0;
          }
          return 1;
        }
        return 2;
      }
      return 3;
    }
    return 0;
  }
  
  public void a(String paramString)
  {
    Object localObject = paramString.toLowerCase();
    paramString = (String)localObject;
    if (((String)localObject).equals("hk")) {
      paramString = "xianggang";
    }
    localObject = paramString;
    if (paramString.equals("uk")) {
      localObject = "united kingdom";
    }
    if (((String)localObject).startsWith(this.jdField_a_of_type_JavaLangString)) {
      paramString = this.jdField_a_of_type_JavaUtilArrayList;
    } else {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_JavaLangString = ((String)localObject);
    localObject = new ArrayList(8);
    paramString = paramString.iterator();
    int j = 0;
    int i = 0;
    while (paramString.hasNext())
    {
      PhoneCodeUtils.CountryCode localCountryCode = (PhoneCodeUtils.CountryCode)paramString.next();
      int k = a(localCountryCode);
      if (k == 3)
      {
        ((ArrayList)localObject).add(j, localCountryCode);
        j += 1;
      }
      else if (k == 2)
      {
        ((ArrayList)localObject).add(i + j, localCountryCode);
        i += 1;
      }
      else if (k == 1)
      {
        ((ArrayList)localObject).add(localCountryCode);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = CountryActivity.a(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity.getLayoutInflater(), true);
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity);
    }
    CountryActivity.a(localView, (PhoneCodeUtils.CountryCode)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.CountryActivity.SearchAdapter
 * JD-Core Version:    0.7.0.1
 */