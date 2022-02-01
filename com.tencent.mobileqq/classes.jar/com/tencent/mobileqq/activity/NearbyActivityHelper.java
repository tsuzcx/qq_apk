package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.nearby.home.INearbyTabInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;
import java.util.ArrayList;
import org.json.JSONObject;

public class NearbyActivityHelper
{
  public static RedTouch a(Context paramContext, TabBarView paramTabBarView, int paramInt1, int paramInt2)
  {
    paramInt1 = DisplayUtil.b(paramContext, paramContext.getResources().getDisplayMetrics().widthPixels / paramInt1);
    return new RedTouch(paramContext, paramTabBarView.c(paramInt2)).c(53).c(4.0F).b(paramInt1 / 2 - 8 - 20).a();
  }
  
  public static RedTouch a(Context paramContext, TabLayoutCompat paramTabLayoutCompat, int paramInt)
  {
    return new RedTouch(paramContext, paramTabLayoutCompat.b(paramInt).j()).c(53).c(4.0F).b(17.0F).a();
  }
  
  public static void a(Context paramContext, TabBarView paramTabBarView)
  {
    if (QQTheme.isNowSimpleUI())
    {
      paramTabBarView.setSelectColor(paramContext.getResources().getColor(2131168072));
      paramTabBarView.setUnselectColor(paramContext.getResources().getColor(2131168059));
      return;
    }
    paramTabBarView.setSelectColor(Color.parseColor("#00aced"));
    paramTabBarView.setUnselectColor(Color.parseColor("#777777"));
  }
  
  public static void a(Context paramContext, TabBarView paramTabBarView, ArrayList<INearbyTabInfo> paramArrayList)
  {
    paramTabBarView.setEnableRepeatedClick(true);
    paramTabBarView.setTabTextSize(16);
    a(paramContext, paramTabBarView);
    paramTabBarView.setUnderLineHeight(DisplayUtil.a(paramContext, 3.0F));
    paramTabBarView.setTabHeight(DisplayUtil.a(paramContext, 45.0F));
    int k = paramArrayList.size();
    int j = 0;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.gravity = 17;
    localLayoutParams.width = (paramContext.getResources().getDisplayMetrics().widthPixels / k);
    paramTabBarView.setTabLayoutParams(localLayoutParams);
    paramContext = new String[k];
    int i = 0;
    while (i < k)
    {
      paramContext[i] = ((INearbyTabInfo)paramArrayList.get(i)).getTabName();
      i += 1;
    }
    paramTabBarView.setTabTitleList(paramContext);
    i = j;
    while (i < paramArrayList.size())
    {
      paramContext = (INearbyTabInfo)paramArrayList.get(i);
      paramTabBarView.a(paramContext.getTabName());
      paramTabBarView.b(i).a(paramContext.isShowRedRot());
      i += 1;
    }
  }
  
  public static void a(RedTouch paramRedTouch, int paramInt)
  {
    paramRedTouch.setUseNewStyle(true);
    Object localObject1;
    Object localObject2;
    if (paramInt == 0)
    {
      localObject1 = null;
    }
    else if (paramInt == -1)
    {
      localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(0);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set("");
    }
    else
    {
      localObject1 = String.valueOf(paramInt);
      if (paramInt > 99) {
        localObject1 = "99+";
      }
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_content.set((String)localObject1);
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("cn", "#ff0000");
        localRedTypeInfo.red_desc.set(((JSONObject)localObject1).toString());
        localObject1 = localRedTypeInfo;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = localRedTypeInfo;
      }
    }
    paramRedTouch.a(localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivityHelper
 * JD-Core Version:    0.7.0.1
 */