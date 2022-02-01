package com.tencent.ilive.uicomponent.custom;

import android.view.View;
import com.tencent.ilive.uicomponent.custom.ability.BaseUICustom;
import com.tencent.ilive.uicomponent.custom.behavior.ViewBehaviorSetter;
import java.util.Iterator;
import java.util.List;

public class UICustomUtils
{
  public static void customAllViews(View paramView, List<BaseUICustom> paramList)
  {
    if ((paramView != null) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseUICustom localBaseUICustom = (BaseUICustom)paramList.next();
        if (localBaseUICustom != null)
        {
          View localView = paramView.findViewWithTag(localBaseUICustom.getTag());
          if (localView != null) {
            localBaseUICustom.getViewBehaviorSetter().apply(localView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.custom.UICustomUtils
 * JD-Core Version:    0.7.0.1
 */