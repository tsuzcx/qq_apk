package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.utils.UITools;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.qqstory.base.StoryHaloManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.statistics.QZoneReport;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class RecentEfficientItemBuilder
  extends RecentItemBaseBuilder
{
  private List a;
  
  private void a(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder, Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateStoryHalo: failed. Message: empty adapter. ");
      }
    }
    StoryHaloManager localStoryHaloManager;
    do
    {
      return;
      localStoryHaloManager = (StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a.getManager(196);
    } while (!localStoryHaloManager.a(paramRecentBaseData));
    paramRecentBaseData = (RecentItemChatMsgData)paramRecentBaseData;
    localStoryHaloManager.a(paramRecentBaseData);
    switch (paramRecentBaseData.o)
    {
    default: 
      return;
    case -3: 
      a(paramRecentEfficientItemBuilderHolder, paramContext);
      return;
    case -1: 
      a(paramRecentEfficientItemBuilderHolder, paramContext, paramRecentBaseData, 2130843494);
      return;
    }
    a(paramRecentEfficientItemBuilderHolder, paramContext, paramRecentBaseData, 2130843493);
  }
  
  private void a(RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder, Context paramContext)
  {
    if ((paramRecentEfficientItemBuilderHolder == null) || (paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateVanishHalo: failed.  exception: holder icon is null. ");
      }
    }
    do
    {
      RelativeLayout.LayoutParams localLayoutParams;
      do
      {
        return;
        localLayoutParams = (RelativeLayout.LayoutParams)paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
      } while (localLayoutParams == null);
      int i = (int)paramContext.getResources().getDimension(2131559507);
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localLayoutParams.setMargins((int)UITools.a(paramContext, 12.0F), localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      if (paramRecentEfficientItemBuilderHolder.jdField_b_of_type_AndroidWidgetImageView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentEfficientItemBuilder", 2, "decorateVanishHalo: failed.  exception: holder story halo is null. ");
    return;
    paramRecentEfficientItemBuilderHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder, Context paramContext, RecentItemChatMsgData paramRecentItemChatMsgData, int paramInt)
  {
    if ((paramRecentEfficientItemBuilderHolder == null) || (paramRecentItemChatMsgData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateHaloResource: failed.  exception:  holder: " + paramRecentEfficientItemBuilderHolder + " msgItem: " + paramRecentItemChatMsgData);
      }
      return;
    }
    StoryReportor.a("msg_tab", "circle_exp", 0, 0, new String[] { paramRecentItemChatMsgData.a() });
    if (QLog.isColorLevel()) {
      QLog.i("RecentEfficientItemBuilder", 2, "decorateHaloResource: invoked. Message:  msgItem.haloState : " + paramRecentItemChatMsgData.o + " msgItem.getRecentUserUin() : " + paramRecentItemChatMsgData.a());
    }
    paramRecentEfficientItemBuilderHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramRecentEfficientItemBuilderHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    paramRecentItemChatMsgData = (RelativeLayout.LayoutParams)paramRecentEfficientItemBuilderHolder.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    paramRecentItemChatMsgData.setMargins((int)paramContext.getResources().getDimension(2131559506), paramRecentItemChatMsgData.topMargin, paramRecentItemChatMsgData.rightMargin, paramRecentItemChatMsgData.bottomMargin);
    paramRecentEfficientItemBuilderHolder = (RelativeLayout.LayoutParams)paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
    paramInt = (int)paramContext.getResources().getDimension(2131559505);
    paramRecentEfficientItemBuilderHolder.height = paramInt;
    paramRecentEfficientItemBuilderHolder.width = paramInt;
    paramRecentEfficientItemBuilderHolder.setMargins((int)UITools.a(paramContext, 15.5F), paramRecentEfficientItemBuilderHolder.topMargin, paramRecentEfficientItemBuilderHolder.rightMargin, paramRecentEfficientItemBuilderHolder.bottomMargin);
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    Object localObject1;
    label79:
    Object localObject2;
    if ((paramView != null) && ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)))
    {
      paramOnDragModeChangedListener = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramOnDragModeChangedListener;
      localObject1 = paramContext.getResources();
      paramOnDragModeChangedListener = ((Resources)localObject1).getColorStateList(2131494267);
      localObject1 = ((Resources)localObject1).getColorStateList(2131494268);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label716;
      }
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject1, 0);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.b) {
        paramViewGroup.setContentDescription(null);
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break label730;
      }
      localObject2 = (RecentBaseData)paramObject;
      localObject1 = ((RecentBaseData)localObject2).a();
      paramOnDragModeChangedListener = null;
      if (paramRecentFaceDecoder != null) {
        paramOnDragModeChangedListener = paramRecentFaceDecoder.a((RecentBaseData)localObject2);
      }
      a(paramViewGroup, (RecentBaseData)localObject2, paramContext, paramOnDragModeChangedListener);
      if (((StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a.getManager(196)).b(paramObject))
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(-22, paramObject);
        paramView.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
      if ((paramObject instanceof RecentItemEcShop))
      {
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setOnClickListener(paramOnClickListener);
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.b) {
          paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setContentDescription(String.format("点击进入%1$s资料卡页面", new Object[] { ((RecentBaseData)localObject2).jdField_b_of_type_JavaLangString }));
        }
      }
    }
    for (paramRecentFaceDecoder = (RecentFaceDecoder)localObject1;; paramRecentFaceDecoder = "")
    {
      if ((PublicAccountConfigUtil.b) && ((paramObject instanceof RecentItemServiceAccountFolderData))) {
        paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(4, paramViewGroup);
      }
      a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      if ("2290230341".equals(paramRecentFaceDecoder)) {
        QZoneReport.a(1);
      }
      return paramViewGroup;
      paramOnDragModeChangedListener = new RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder();
      localObject1 = a(paramContext, 2130971486, paramOnDragModeChangedListener);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)((View)localObject1).findViewById(2131362719));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject1).findViewById(2131363207));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject1).findViewById(2131363378));
      paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131374901));
      paramOnDragModeChangedListener.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131374900));
      paramOnDragModeChangedListener.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject1).findViewById(2131365659));
      paramOnDragModeChangedListener.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setGravity(16);
      localObject2 = paramContext.getResources();
      float f = DeviceInfoUtil.a();
      paramView = ((Resources)localObject2).getColorStateList(2131494267);
      paramViewGroup = ((Resources)localObject2).getColorStateList(2131494219);
      localObject2 = ((Resources)localObject2).getColorStateList(2131494268);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramViewGroup);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject2, 0);
      }
      for (;;)
      {
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
        paramOnDragModeChangedListener.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramView);
        paramOnDragModeChangedListener.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 2.0F), 1);
        paramOnDragModeChangedListener.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
        ((View)localObject1).setTag(paramOnDragModeChangedListener);
        paramViewGroup = (ViewGroup)localObject1;
        paramView = paramOnDragModeChangedListener;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) {
          break;
        }
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
        paramViewGroup = (ViewGroup)localObject1;
        paramView = paramOnDragModeChangedListener;
        break;
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      label716:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramOnDragModeChangedListener, 0);
      break label79;
      label730:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText("");
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
    }
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int k = paramRecentBaseData.f;
    paramContext = paramContext.getResources();
    int m;
    int i;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      m = k & 0xF0;
      int j = 2;
      i = 3;
      if ((paramRecentBaseData.a() == 3000) || (paramRecentBaseData.a() == 1))
      {
        j = 8;
        i = 7;
      }
      if (m != 32) {
        break label149;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[j]));
    }
    for (;;)
    {
      if ((k & 0xF) == 1) {
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[0]));
      }
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      label149:
      if (m == 16) {
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[i]));
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    if ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)) {}
    for (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder localRecentEfficientItemBuilderHolder = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();; localRecentEfficientItemBuilderHolder = null)
    {
      if (localRecentEfficientItemBuilderHolder == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      Object localObject;
      int j;
      int i;
      RecentDynamicAvatarView localRecentDynamicAvatarView;
      String str;
      boolean bool1;
      if (a(paramRecentBaseData))
      {
        if (QLog.isColorLevel()) {
          QLog.i("RecentEfficientItemBuilder", 2, "bindview user:" + paramRecentBaseData.a());
        }
        localObject = ((BaseActivity)paramContext).app;
        j = ((Integer)RecentFaceDecoder.a((QQAppInterface)localObject, paramRecentBaseData.a(), paramRecentBaseData.a()).first).intValue();
        i = j;
        if (j == 103) {
          i = 1;
        }
        localRecentDynamicAvatarView = localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
        str = paramRecentBaseData.a();
        if (((QQAppInterface)localObject).a.a() == 1) {
          bool1 = true;
        }
      }
      for (;;)
      {
        localRecentDynamicAvatarView.setFaceDrawable((AppInterface)localObject, paramDrawable, i, str, 100, false, bool1, 0);
        label223:
        paramDrawable = null;
        if (paramRecentBaseData.jdField_d_of_type_Int != 0) {
          paramDrawable = paramContext.getResources().getDrawable(paramRecentBaseData.jdField_d_of_type_Int);
        }
        localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(null, paramDrawable);
        if (localRecentEfficientItemBuilderHolder.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          localRecentEfficientItemBuilderHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          if (((paramRecentBaseData instanceof RecentItemChatMsgData)) && (((RecentItemChatMsgData)paramRecentBaseData).j == 1))
          {
            localRecentEfficientItemBuilderHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(QIMUserManager.a().b(3));
            localRecentEfficientItemBuilderHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
        }
        paramDrawable = paramRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
        label337:
        boolean bool2;
        boolean bool3;
        boolean bool4;
        label512:
        int m;
        label516:
        label541:
        label566:
        int k;
        label647:
        label684:
        if (paramDrawable != null)
        {
          paramDrawable = paramDrawable.toString();
          localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 2);
          localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.jdField_c_of_type_JavaLangString, 0);
          localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.jdField_b_of_type_JavaLangString);
          if (!TextUtils.isEmpty(paramRecentBaseData.jdField_a_of_type_JavaLangCharSequence)) {
            localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.jdField_a_of_type_JavaLangCharSequence);
          }
          if ((paramRecentBaseData.a() != 0) || (!(paramRecentBaseData instanceof RecentItemChatMsgData))) {
            break label1119;
          }
          long l1 = ((RecentItemChatMsgData)paramRecentBaseData).b;
          long l2 = ((RecentItemChatMsgData)paramRecentBaseData).jdField_c_of_type_Long;
          long l3 = ((RecentItemChatMsgData)paramRecentBaseData).d;
          bool1 = HotReactiveHelper.a(HotReactiveHelper.b(), 1000L * l2);
          bool2 = HotReactiveHelper.a(HotReactiveHelper.b(), 1000L * l1);
          bool3 = HotReactiveHelper.a(HotReactiveHelper.b(), l3 * 1000L);
          i = ((RecentItemChatMsgData)paramRecentBaseData).m;
          bool4 = ((RecentItemChatMsgData)paramRecentBaseData).jdField_c_of_type_Boolean;
          if (i != 1) {
            break label959;
          }
          if (!bool4) {
            break label951;
          }
          i = 2130845922;
          m = i;
          i = ((RecentItemChatMsgData)paramRecentBaseData).l;
          if (i != 1) {
            break label1004;
          }
          if (!bool2) {
            break label996;
          }
          i = 2130845931;
          j = ((RecentItemChatMsgData)paramRecentBaseData).k;
          if (j != 1) {
            break label1045;
          }
          if (!bool1) {
            break label1037;
          }
          j = 2130845928;
          k = ((RecentItemChatMsgData)paramRecentBaseData).n;
          if (k != 1) {
            break label1086;
          }
          if (!bool3) {
            break label1078;
          }
          k = 2130845924;
          label591:
          localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(m, i, j, k);
          label607:
          switch (paramRecentBaseData.jdField_a_of_type_Int)
          {
          default: 
            i = 0;
            localRecentEfficientItemBuilderHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
            i = paramRecentBaseData.e;
            paramDrawable = paramRecentBaseData.jdField_d_of_type_JavaLangCharSequence;
            if (paramDrawable != null)
            {
              paramDrawable = paramDrawable.toString();
              localObject = paramDrawable;
              if (paramDrawable != null)
              {
                localObject = paramDrawable;
                if (paramDrawable.length() > 0)
                {
                  localObject = paramDrawable;
                  if (!paramDrawable.endsWith(" ")) {
                    localObject = paramDrawable + " ";
                  }
                }
              }
              if ((!TextUtils.isEmpty((CharSequence)localObject)) && (i != 0)) {
                localRecentEfficientItemBuilderHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
              }
              localRecentEfficientItemBuilderHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
            }
            break;
          }
        }
        try
        {
          localRecentEfficientItemBuilderHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.jdField_c_of_type_JavaLangCharSequence);
          m = paramRecentBaseData.jdField_c_of_type_Int;
          j = 0;
          i = paramRecentBaseData.jdField_b_of_type_Int;
          if (m > 0) {
            if (i == 0)
            {
              i = 0;
              j = 0;
              m = 0;
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              k = 99;
              CustomWidgetUtil.a(localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
              if ((paramRecentBaseData.f & 0xF0) != 32) {
                break label1348;
              }
            }
          }
        }
        catch (Exception paramDrawable)
        {
          for (;;)
          {
            try
            {
              localRecentEfficientItemBuilderHolder.f.setBackgroundResource(2130838588);
              if (AppSetting.b) {
                paramView.setContentDescription(paramRecentBaseData.jdField_d_of_type_JavaLangString);
              }
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.a(paramRecentBaseData.c());
              a(localRecentEfficientItemBuilderHolder, paramContext);
              a(paramRecentBaseData, localRecentEfficientItemBuilderHolder, paramContext);
              return;
              bool1 = false;
              break;
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
              break label223;
              paramDrawable = "";
              break label337;
              label951:
              i = 2130845929;
              break label512;
              label959:
              if (i == 2)
              {
                if (bool4)
                {
                  i = 2130845921;
                  m = i;
                  break label516;
                }
                i = 2130845915;
                continue;
              }
              m = 0;
              break label516;
              label996:
              i = 2130845930;
              break label541;
              label1004:
              if (i == 2)
              {
                if (bool2)
                {
                  i = 2130845917;
                  break label541;
                }
                i = 2130845916;
                break label541;
              }
              i = 0;
              break label541;
              label1037:
              j = 2130845927;
              break label566;
              label1045:
              if (j == 2)
              {
                if (bool1)
                {
                  j = 2130845914;
                  break label566;
                }
                j = 2130845913;
                break label566;
              }
              j = 0;
              break label566;
              label1078:
              k = 2130845923;
              break label591;
              label1086:
              if (k == 2)
              {
                if (bool3)
                {
                  k = 2130845926;
                  break label591;
                }
                k = 2130845925;
                break label591;
              }
              k = 0;
              break label591;
              label1119:
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              break label607;
              i = 2130840213;
              break label647;
              if (paramRecentBaseData.jdField_a_of_type_Boolean)
              {
                i = 2130840220;
                break label647;
              }
              i = 2130840213;
              break label647;
              if (paramRecentBaseData.jdField_a_of_type_Boolean)
              {
                i = 2130840220;
                break label647;
              }
              i = 2130840221;
              break label647;
              i = 2130840221;
              break label647;
              i = 2130838701;
              break label647;
              paramDrawable = "";
              break label684;
              paramDrawable = paramDrawable;
              paramDrawable.printStackTrace();
              localRecentEfficientItemBuilderHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.jdField_c_of_type_JavaLangCharSequence + " ");
              continue;
              if (i == 2)
              {
                i = 1;
                j = 0;
                m = 0;
                localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
                k = 99;
                continue;
              }
              if (i == 3)
              {
                i = 3;
                j = 2130846056;
                if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
                localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
                k = 99;
                continue;
              }
              i = 3;
              j = 2130846055;
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
              k = 99;
              continue;
              label1348:
              localRecentEfficientItemBuilderHolder.f.setBackgroundResource(2130838587);
              continue;
            }
            catch (Throwable paramDrawable)
            {
              continue;
            }
            m = 0;
            i = 0;
            k = 99;
          }
        }
      }
    }
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.a();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentEfficientItemBuilder
 * JD-Core Version:    0.7.0.1
 */