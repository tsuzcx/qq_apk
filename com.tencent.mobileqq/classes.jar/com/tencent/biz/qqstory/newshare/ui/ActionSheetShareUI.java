package com.tencent.biz.qqstory.newshare.ui;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext, List<int[]> paramList)
  {
    List[] arrayOfList = (List[])new ArrayList[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      int[] arrayOfInt = (int[])paramList.get(i);
      ArrayList localArrayList = new ArrayList();
      int k = arrayOfInt.length;
      int j = 0;
      while (j < k)
      {
        int m = arrayOfInt[j];
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        localActionSheetItem.action = a(m);
        localActionSheetItem.iconNeedBg = true;
        switch (m)
        {
        default: 
          break;
        case 12: 
          localActionSheetItem.label = paramContext.getString(2131718761);
          localActionSheetItem.icon = 2130847133;
          StoryReportor.a("share", "exp_video", 0, 0, new String[0]);
          break;
        case 11: 
          localActionSheetItem.label = HardCodeUtil.a(2131699985);
          localActionSheetItem.icon = 2130846908;
          break;
        case 10: 
          localActionSheetItem.label = paramContext.getString(2131718760);
          localActionSheetItem.icon = 2130847033;
          break;
        case 9: 
          localActionSheetItem.label = HardCodeUtil.a(2131699987);
          localActionSheetItem.icon = 2130846901;
          break;
        case 8: 
          localActionSheetItem.label = HardCodeUtil.a(2131699986);
          localActionSheetItem.icon = 2130846900;
          break;
        case 7: 
          localActionSheetItem.label = HardCodeUtil.a(2131699984);
          localActionSheetItem.icon = 2130846902;
          break;
        case 6: 
          localActionSheetItem.label = paramContext.getString(2131691293);
          localActionSheetItem.icon = 2130839063;
          break;
        case 5: 
          localActionSheetItem.label = paramContext.getString(2131696417);
          localActionSheetItem.icon = 2130847035;
          break;
        case 4: 
          localActionSheetItem.label = paramContext.getString(2131696402);
          localActionSheetItem.icon = 2130839065;
          break;
        case 3: 
          localActionSheetItem.label = paramContext.getString(2131696420);
          localActionSheetItem.icon = 2130847036;
          break;
        case 2: 
          localActionSheetItem.label = paramContext.getString(2131696413);
          localActionSheetItem.icon = 2130846665;
          break;
        case 1: 
          localActionSheetItem.label = paramContext.getString(2131696399);
          localActionSheetItem.icon = 2130847033;
        }
        localArrayList.add(localActionSheetItem);
        j += 1;
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
    case 12: 
      return 42;
    case 11: 
      return 22;
    case 10: 
      return 41;
    case 9: 
      return 11;
    case 8: 
      return 40;
    case 7: 
      return 39;
    case 6: 
      return 1;
    case 5: 
      return 12;
    case 4: 
      return 10;
    case 3: 
      return 9;
    case 2: 
      return 3;
    }
    return 2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      ActionSheetShareUI.1 local1 = new ActionSheetShareUI.1(this);
      ActionSheetShareUI.2 local2 = new ActionSheetShareUI.2(this);
      Activity localActivity = a();
      if (localActivity == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(localActivity, true);
      if (this.jdField_a_of_type_Boolean)
      {
        ShareActionSheetBuilder localShareActionSheetBuilder = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
        String str;
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          str = localActivity.getString(2131719029);
        } else {
          str = this.jdField_a_of_type_JavaLangString;
        }
        localShareActionSheetBuilder.setActionSheetTitle(str);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.hideTitle();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(localActivity, this.jdField_a_of_type_JavaUtilList));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(local1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(local2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new ActionSheetShareUI.3(this));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
    }
  }
  
  public int b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 22)
          {
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                return -1;
              case 42: 
                return 12;
              case 41: 
                return 10;
              case 40: 
                return 8;
              }
              return 7;
            case 12: 
              return 5;
            case 11: 
              return 9;
            case 10: 
              return 4;
            }
            return 3;
          }
          return 11;
        }
        return 2;
      }
      return 1;
    }
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.ui.ActionSheetShareUI
 * JD-Core Version:    0.7.0.1
 */