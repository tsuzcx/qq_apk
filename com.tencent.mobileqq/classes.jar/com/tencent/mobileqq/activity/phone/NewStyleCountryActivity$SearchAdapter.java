package com.tencent.mobileqq.activity.phone;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.PhoneCodeUtils.CountryCode;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

class NewStyleCountryActivity$SearchAdapter
  extends BaseAdapter
{
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<PhoneCodeUtils.CountryCode> jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.jdField_a_of_type_JavaUtilArrayList;
  
  private NewStyleCountryActivity$SearchAdapter(NewStyleCountryActivity paramNewStyleCountryActivity) {}
  
  private int a(PhoneCodeUtils.CountryCode paramCountryCode)
  {
    if (paramCountryCode.a) {
      return 0;
    }
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.equals(""))) {
      return 0;
    }
    String str2 = paramCountryCode.c;
    String str3 = paramCountryCode.b;
    String str1 = paramCountryCode.d;
    paramCountryCode = str1;
    if (str1 != null) {
      paramCountryCode = str1.toLowerCase();
    }
    str1 = ChnToSpell.a(str3, 1);
    String str4 = ChnToSpell.a(str3, 2);
    if ((str2.equals(this.jdField_a_of_type_JavaLangString)) || (str3.equals(this.jdField_a_of_type_JavaLangString)) || (str1.equals(this.jdField_a_of_type_JavaLangString)) || (str4.equals(this.jdField_a_of_type_JavaLangString)) || ((paramCountryCode != null) && (paramCountryCode.equals(this.jdField_a_of_type_JavaLangString)))) {
      return 3;
    }
    if ((str2.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (str3.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (str1.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || (str4.indexOf(this.jdField_a_of_type_JavaLangString) == 0) || ((paramCountryCode != null) && (paramCountryCode.indexOf(this.jdField_a_of_type_JavaLangString) == 0))) {
      return 2;
    }
    if ((str2.indexOf(this.jdField_a_of_type_JavaLangString) > 0) || (str3.indexOf(this.jdField_a_of_type_JavaLangString) > 0) || (str1.indexOf(this.jdField_a_of_type_JavaLangString) > 0) || (str4.indexOf(this.jdField_a_of_type_JavaLangString) > 0)) {
      return 1;
    }
    return 0;
  }
  
  public void a(String paramString)
  {
    int j = 0;
    Object localObject = paramString.toLowerCase();
    paramString = (String)localObject;
    if (((String)localObject).equals("hk")) {
      paramString = "xianggang";
    }
    localObject = paramString;
    if (paramString.equals("uk")) {
      localObject = "united kingdom";
    }
    int i;
    label81:
    PhoneCodeUtils.CountryCode localCountryCode;
    int k;
    if (((String)localObject).startsWith(this.jdField_a_of_type_JavaLangString))
    {
      paramString = this.jdField_a_of_type_JavaUtilArrayList;
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      localObject = new ArrayList(8);
      paramString = paramString.iterator();
      i = 0;
      if (!paramString.hasNext()) {
        break label181;
      }
      localCountryCode = (PhoneCodeUtils.CountryCode)paramString.next();
      k = a(localCountryCode);
      if (k != 3) {
        break label141;
      }
      ((ArrayList)localObject).add(j, localCountryCode);
      j += 1;
    }
    for (;;)
    {
      break label81;
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.jdField_a_of_type_JavaUtilArrayList;
      break;
      label141:
      if (k == 2)
      {
        ((ArrayList)localObject).add(i + j, localCountryCode);
        i += 1;
      }
      else if (k == 1)
      {
        ((ArrayList)localObject).add(localCountryCode);
      }
    }
    label181:
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
    if (paramView == null)
    {
      paramView = NewStyleCountryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.getLayoutInflater(), true);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneNewStyleCountryActivity.a(paramView, (PhoneCodeUtils.CountryCode)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.NewStyleCountryActivity.SearchAdapter
 * JD-Core Version:    0.7.0.1
 */