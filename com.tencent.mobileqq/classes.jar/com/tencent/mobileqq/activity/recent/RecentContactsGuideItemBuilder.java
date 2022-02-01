package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqstory.takevideo.TakeVideoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentItemContactsGuideData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.ContactsGuideRecenUserObj;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

public class RecentContactsGuideItemBuilder
  extends RecentItemBaseBuilder
{
  protected String a;
  View.OnTouchListener b = new RecentContactsGuideItemBuilder.1(this);
  
  RecentContactsGuideItemBuilder()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentContactsGuideItemBuilder", 0, "RecentContactsGuideItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof RecentContactsGuideItemBuilder.RecentContactsGuideItemHolder))) {
      paramRecentFaceDecoder = (RecentContactsGuideItemBuilder.RecentContactsGuideItemHolder)paramView.getTag();
    } else {
      paramRecentFaceDecoder = null;
    }
    paramViewGroup = paramView;
    paramView = paramRecentFaceDecoder;
    if (paramRecentFaceDecoder == null)
    {
      paramView = new RecentContactsGuideItemBuilder.RecentContactsGuideItemHolder();
      paramViewGroup = a(paramContext, 2131624570, paramView);
      paramView.a = ((ThemeImageView)paramViewGroup.findViewById(2131431327));
      paramViewGroup.setOnTouchListener(this.b);
      paramRecentFaceDecoder = paramView.a.getLayoutParams();
      int i = TakeVideoUtils.a(BaseApplicationImpl.getApplication().getResources());
      double d = i;
      Double.isNaN(d);
      int j = (int)(d * 0.5D + 0.5D);
      paramRecentFaceDecoder.width = i;
      paramRecentFaceDecoder.height = j;
      paramView.a.setLayoutParams(paramRecentFaceDecoder);
      paramView.a.setMaskShape(ThemeImageWrapper.MODE_SQURE);
      paramViewGroup.setTag(paramView);
    }
    if ((paramObject instanceof RecentItemContactsGuideData))
    {
      paramObject = (RecentItemContactsGuideData)paramObject;
      if ((paramObject.mUser != null) && ((paramObject.mUser.extraInfo instanceof LoginWelcomeManager.ContactsGuideRecenUserObj)))
      {
        paramObject = (LoginWelcomeManager.ContactsGuideRecenUserObj)paramObject.mUser.extraInfo;
        if (paramObject.b != null)
        {
          paramView.a.setImageDrawable(paramObject.b);
          paramObject.b.setURLDrawableListener(null);
        }
        LoginWelcomeManager.j += 1;
      }
    }
    this.a = ThemeUtil.curThemeId;
    if (AppSetting.e) {
      paramViewGroup.setContentDescription(HardCodeUtil.a(2131910641));
    }
    paramViewGroup.setOnClickListener(paramOnClickListener);
    paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
    paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentContactsGuideItemBuilder
 * JD-Core Version:    0.7.0.1
 */