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
      if (j < k)
      {
        int m = arrayOfInt[j];
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
        localActionSheetItem.action = a(m);
        localActionSheetItem.iconNeedBg = true;
        switch (m)
        {
        }
        for (;;)
        {
          localArrayList.add(localActionSheetItem);
          j += 1;
          break;
          localActionSheetItem.label = paramContext.getString(2131719045);
          localActionSheetItem.icon = 2130847265;
          StoryReportor.a("share", "exp_video", 0, 0, new String[0]);
          continue;
          localActionSheetItem.label = paramContext.getString(2131719044);
          localActionSheetItem.icon = 2130847158;
          continue;
          localActionSheetItem.label = paramContext.getString(2131696380);
          localActionSheetItem.icon = 2130847158;
          continue;
          localActionSheetItem.label = paramContext.getString(2131696394);
          localActionSheetItem.icon = 2130846785;
          continue;
          localActionSheetItem.label = paramContext.getString(2131696401);
          localActionSheetItem.icon = 2130847161;
          continue;
          localActionSheetItem.label = paramContext.getString(2131696383);
          localActionSheetItem.icon = 2130839212;
          continue;
          localActionSheetItem.label = paramContext.getString(2131696398);
          localActionSheetItem.icon = 2130847160;
          continue;
          localActionSheetItem.label = paramContext.getString(2131691371);
          localActionSheetItem.icon = 2130839210;
          continue;
          localActionSheetItem.label = HardCodeUtil.a(2131699843);
          localActionSheetItem.icon = 2130847024;
          continue;
          localActionSheetItem.label = HardCodeUtil.a(2131699845);
          localActionSheetItem.icon = 2130847022;
          continue;
          localActionSheetItem.label = HardCodeUtil.a(2131699846);
          localActionSheetItem.icon = 2130847023;
          continue;
          localActionSheetItem.label = HardCodeUtil.a(2131699844);
          localActionSheetItem.icon = 2130847030;
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
    case 6: 
      return 1;
    case 7: 
      return 39;
    case 8: 
      return 40;
    case 9: 
      return 11;
    case 10: 
      return 41;
    case 11: 
      return 22;
    }
    return 42;
  }
  
  public void a()
  {
    ActionSheetShareUI.1 local1;
    ActionSheetShareUI.2 local2;
    Activity localActivity;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      local1 = new ActionSheetShareUI.1(this);
      local2 = new ActionSheetShareUI.2(this);
      localActivity = a();
      if (localActivity == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(localActivity, true);
      if (!this.jdField_a_of_type_Boolean) {
        break label162;
      }
      ShareActionSheetBuilder localShareActionSheetBuilder = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label154;
      }
      str = localActivity.getString(2131719311);
      label82:
      localShareActionSheetBuilder.setActionSheetTitle(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(localActivity, this.jdField_a_of_type_JavaUtilList));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(local1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(local2);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new ActionSheetShareUI.3(this));
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      return;
      label154:
      str = this.jdField_a_of_type_JavaLangString;
      break label82;
      label162:
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.hideTitle();
    }
  }
  
  public int b(int paramInt)
  {
    switch (paramInt)
    {
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
    case 1: 
      return 6;
    case 39: 
      return 7;
    case 40: 
      return 8;
    case 11: 
      return 9;
    case 41: 
      return 10;
    case 22: 
      return 11;
    }
    return 12;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.ui.ActionSheetShareUI
 * JD-Core Version:    0.7.0.1
 */