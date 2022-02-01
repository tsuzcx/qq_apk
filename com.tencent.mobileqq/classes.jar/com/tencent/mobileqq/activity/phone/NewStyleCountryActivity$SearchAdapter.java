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
  private ArrayList<PhoneCodeUtils.CountryCode> b = this.a.b;
  private String c = "";
  
  private NewStyleCountryActivity$SearchAdapter(NewStyleCountryActivity paramNewStyleCountryActivity) {}
  
  private int a(PhoneCodeUtils.CountryCode paramCountryCode)
  {
    if (paramCountryCode.b) {
      return 0;
    }
    String str1 = this.c;
    if (str1 != null)
    {
      if (str1.equals("")) {
        return 0;
      }
      String str2 = paramCountryCode.d;
      String str3 = paramCountryCode.c;
      str1 = paramCountryCode.e;
      paramCountryCode = str1;
      if (str1 != null) {
        paramCountryCode = str1.toLowerCase();
      }
      str1 = ChnToSpell.b(str3, 1);
      String str4 = ChnToSpell.b(str3, 2);
      if ((!str2.equals(this.c)) && (!str3.equals(this.c)) && (!str1.equals(this.c)) && (!str4.equals(this.c)) && ((paramCountryCode == null) || (!paramCountryCode.equals(this.c))))
      {
        if ((str2.indexOf(this.c) != 0) && (str3.indexOf(this.c) != 0) && (str1.indexOf(this.c) != 0) && (str4.indexOf(this.c) != 0))
        {
          if ((paramCountryCode != null) && (paramCountryCode.indexOf(this.c) == 0)) {
            return 2;
          }
          if ((str2.indexOf(this.c) <= 0) && (str3.indexOf(this.c) <= 0) && (str1.indexOf(this.c) <= 0))
          {
            if (str4.indexOf(this.c) > 0) {
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
    if (((String)localObject).startsWith(this.c)) {
      paramString = this.b;
    } else {
      paramString = this.a.b;
    }
    this.c = ((String)localObject);
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
    this.b = ((ArrayList)localObject);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.b.size();
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
      paramView = this.a;
      localView = NewStyleCountryActivity.a(paramView, paramViewGroup, paramView.getLayoutInflater(), true);
      localView.setOnClickListener(this.a);
    }
    this.a.a(localView, (PhoneCodeUtils.CountryCode)this.b.get(paramInt));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.NewStyleCountryActivity.SearchAdapter
 * JD-Core Version:    0.7.0.1
 */