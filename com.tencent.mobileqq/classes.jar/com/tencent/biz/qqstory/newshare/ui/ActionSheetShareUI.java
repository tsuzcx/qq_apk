package com.tencent.biz.qqstory.newshare.ui;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nhn;
import nho;
import nhp;

public class ActionSheetShareUI
  extends ShareUI
{
  private ShareActionSheetBuilder a;
  
  public ActionSheetShareUI(Activity paramActivity)
  {
    super(paramActivity);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList = Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6 } });
    }
  }
  
  private List[] a(Context paramContext, List paramList)
  {
    List[] arrayOfList = (List[])new ArrayList[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      int[] arrayOfInt = (int[])paramList.get(i);
      ArrayList localArrayList = new ArrayList();
      int k = arrayOfInt.length;
      int j = 0;
      if (j < k)
      {
        int m = arrayOfInt[j];
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        localActionSheetItem.c = a(m);
        localActionSheetItem.jdField_a_of_type_Boolean = true;
        switch (m)
        {
        }
        for (;;)
        {
          localArrayList.add(localActionSheetItem);
          j += 1;
          break;
          localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430108);
          localActionSheetItem.b = 2130838336;
          continue;
          localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430114);
          localActionSheetItem.b = 2130838337;
          continue;
          localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430126);
          localActionSheetItem.b = 2130838340;
          continue;
          localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430127);
          localActionSheetItem.b = 2130838334;
          continue;
          localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131430132);
          localActionSheetItem.b = 2130838339;
          continue;
          localActionSheetItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131437014);
          localActionSheetItem.b = 2130838332;
        }
      }
      arrayOfList[i] = localArrayList;
      i += 1;
    }
    return arrayOfList;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 9;
    case 4: 
      return 10;
    case 5: 
      return 12;
    }
    return 1;
  }
  
  public void a()
  {
    nhn localnhn;
    nho localnho;
    Activity localActivity;
    ShareActionSheetBuilder localShareActionSheetBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      localnhn = new nhn(this);
      localnho = new nho(this);
      localActivity = a();
      if (localActivity == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(localActivity);
      localShareActionSheetBuilder = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label146;
      }
    }
    label146:
    for (String str = localActivity.getString(2131433100);; str = this.jdField_a_of_type_JavaLangString)
    {
      localShareActionSheetBuilder.a(str);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(a(localActivity, this.jdField_a_of_type_JavaUtilList));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(localnhn);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(localnho);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(new nhp(this));
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a();
      return;
    }
  }
  
  public int b(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    default: 
      return -1;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 9: 
      return 3;
    case 10: 
      return 4;
    case 12: 
      return 5;
    }
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.ui.ActionSheetShareUI
 * JD-Core Version:    0.7.0.1
 */