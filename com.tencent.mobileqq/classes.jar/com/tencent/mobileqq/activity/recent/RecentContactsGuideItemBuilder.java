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
  View.OnTouchListener a;
  protected String a;
  
  RecentContactsGuideItemBuilder()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new RecentContactsGuideItemBuilder.1(this);
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
      paramViewGroup = a(paramContext, 2131558939, paramView);
      paramView.a = ((ThemeImageView)paramViewGroup.findViewById(2131365174));
      paramViewGroup.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
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
        if (paramObject.a != null)
        {
          paramView.a.setImageDrawable(paramObject.a);
          paramObject.a.setURLDrawableListener(null);
        }
        LoginWelcomeManager.a += 1;
      }
    }
    this.jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
    if (AppSetting.d) {
      paramViewGroup.setContentDescription(HardCodeUtil.a(2131713082));
    }
    paramViewGroup.setOnClickListener(paramOnClickListener);
    paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
    paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentContactsGuideItemBuilder
 * JD-Core Version:    0.7.0.1
 */