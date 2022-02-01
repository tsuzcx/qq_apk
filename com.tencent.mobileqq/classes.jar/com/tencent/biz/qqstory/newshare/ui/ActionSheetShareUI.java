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
  private ShareActionSheetBuilder g;
  
  public ActionSheetShareUI(Activity paramActivity)
  {
    super(paramActivity);
    if ((this.d == null) || (this.d.isEmpty())) {
      this.d = Arrays.asList(new int[][] { { 1, 2, 3, 4, 5 }, { 6 } });
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
          localActionSheetItem.label = paramContext.getString(2131916267);
          localActionSheetItem.icon = 2130848685;
          StoryReportor.a("share", "exp_video", 0, 0, new String[0]);
          break;
        case 11: 
          localActionSheetItem.label = HardCodeUtil.a(2131898031);
          localActionSheetItem.icon = 2130848460;
          break;
        case 10: 
          localActionSheetItem.label = paramContext.getString(2131916266);
          localActionSheetItem.icon = 2130848585;
          break;
        case 9: 
          localActionSheetItem.label = HardCodeUtil.a(2131898033);
          localActionSheetItem.icon = 2130848453;
          break;
        case 8: 
          localActionSheetItem.label = HardCodeUtil.a(2131898032);
          localActionSheetItem.icon = 2130848452;
          break;
        case 7: 
          localActionSheetItem.label = HardCodeUtil.a(2131898030);
          localActionSheetItem.icon = 2130848454;
          break;
        case 6: 
          localActionSheetItem.label = paramContext.getString(2131888243);
          localActionSheetItem.icon = 2130839217;
          break;
        case 5: 
          localActionSheetItem.label = paramContext.getString(2131894189);
          localActionSheetItem.icon = 2130848587;
          break;
        case 4: 
          localActionSheetItem.label = paramContext.getString(2131894174);
          localActionSheetItem.icon = 2130839219;
          break;
        case 3: 
          localActionSheetItem.label = paramContext.getString(2131894192);
          localActionSheetItem.icon = 2130848588;
          break;
        case 2: 
          localActionSheetItem.label = paramContext.getString(2131894185);
          localActionSheetItem.icon = 2130848217;
          break;
        case 1: 
          localActionSheetItem.label = paramContext.getString(2131894171);
          localActionSheetItem.icon = 2130848585;
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
    if (this.g == null)
    {
      ActionSheetShareUI.1 local1 = new ActionSheetShareUI.1(this);
      ActionSheetShareUI.2 local2 = new ActionSheetShareUI.2(this);
      Activity localActivity = g();
      if (localActivity == null) {
        return;
      }
      this.g = new ShareActionSheetBuilder(localActivity, true);
      if (this.c)
      {
        ShareActionSheetBuilder localShareActionSheetBuilder = this.g;
        String str;
        if (TextUtils.isEmpty(this.b)) {
          str = localActivity.getString(2131916565);
        } else {
          str = this.b;
        }
        localShareActionSheetBuilder.setActionSheetTitle(str);
      }
      else
      {
        this.g.hideTitle();
      }
      this.g.setActionSheetItems(a(localActivity, this.d));
      this.g.setItemClickListener(local1);
      this.g.setOnDismissListener(local2);
      this.g.setCancelListener(new ActionSheetShareUI.3(this));
    }
    if (!this.g.isShowing()) {
      this.g.show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.ui.ActionSheetShareUI
 * JD-Core Version:    0.7.0.1
 */