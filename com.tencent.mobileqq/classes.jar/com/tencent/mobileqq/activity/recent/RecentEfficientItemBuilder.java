package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.utils.UITools;
import com.tencent.biz.officialaccount.OfficialAccountReporter;
import com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqstory.base.StoryHaloManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUnRead;
import com.tencent.mobileqq.bubble.BubbleUnRead.BubbleUnreadBundle;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.robotchat.RobotChatUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.QZoneReport;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.RecentTroopIconUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class RecentEfficientItemBuilder
  extends RecentItemBaseBuilder
{
  protected int a;
  private List<String> a;
  protected boolean a;
  
  public RecentEfficientItemBuilder()
  {
    this.jdField_a_of_type_Int = 2131562911;
    this.jdField_a_of_type_Boolean = false;
  }
  
  @Nullable
  private RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder a(View paramView, RecentBaseData paramRecentBaseData)
  {
    Object localObject;
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      localObject = null;
      return localObject;
    }
    if ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)) {}
    for (paramRecentBaseData = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();; paramRecentBaseData = null)
    {
      localObject = paramRecentBaseData;
      if (paramRecentBaseData != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
      }
      return null;
    }
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    int i1 = paramRecentBaseData.mUnreadNum;
    int i = paramRecentBaseData.mUnreadFlag;
    if (((paramRecentBaseData instanceof RecentItemTroopNotification)) && (((RecentItemTroopNotification)paramRecentBaseData).unDealMsgCountNumFlag)) {
      i = 2;
    }
    for (;;)
    {
      int m;
      int k;
      int j;
      int n;
      if (i1 > 0) {
        if (i == 0)
        {
          paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
          m = 0;
          k = 99;
          j = 0;
          n = 0;
          i = 0;
        }
      }
      for (;;)
      {
        CustomWidgetUtil.a(paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, n, k, null);
        if (m != 0)
        {
          paramView = ThemeUtil.getCurrentThemeId();
          if ((!ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a, false, paramView)) && ((paramRecentBaseData instanceof RecentItemChatMsgData)))
          {
            i = ((RecentItemChatMsgData)paramRecentBaseData).mBubbleID;
            if (i > 0)
            {
              paramRecentBaseData = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
              if (paramRecentBaseData != null)
              {
                paramView = paramRecentBaseData.a.a(paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, i1, paramView);
                if (paramView != null)
                {
                  if (Build.VERSION.SDK_INT < 16) {
                    break label386;
                  }
                  paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackground(paramView.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
                  label193:
                  paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramView.jdField_a_of_type_Int);
                  paramView = paramView.jdField_a_of_type_AndroidGraphicsRect;
                  paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setPadding(paramView.left, paramView.top, paramView.right, paramView.bottom);
                }
              }
            }
          }
        }
        return;
        if (i == 2)
        {
          paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
          m = 0;
          k = 99;
          n = 0;
          i = 1;
          j = 0;
        }
        else
        {
          if (i == 3)
          {
            n = 2130850838;
            if (!(paramRecentBaseData instanceof RecentTroopAssistantItem)) {
              break label418;
            }
          }
          label386:
          label418:
          for (;;)
          {
            paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
            paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167163));
            m = 0;
            j = i1;
            i = 3;
            k = 99;
            break;
            n = 2130850834;
            paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
            paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167164));
            if (this.jdField_a_of_type_Boolean)
            {
              m = 1;
              j = i1;
              i = 3;
              k = 99;
              break;
              paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackgroundDrawable(paramView.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
              break label193;
            }
            m = 0;
            j = i1;
            i = 3;
            k = 99;
            break;
          }
          m = 0;
          k = 99;
          j = 0;
          n = 0;
          i = 0;
        }
      }
    }
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder, float paramFloat)
  {
    if (paramRecentBaseData.mAuthenIconId != 0)
    {
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167040));
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * paramFloat));
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
      if (QLog.isColorLevel()) {
        QLog.d("RecentEfficientItemBuilder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
      }
      return;
    }
    if ((paramRecentBaseData.getRecentUserType() == 0) && (!SimpleUIUtil.a()))
    {
      if (QFileAssistantUtils.a(paramRecentBaseData.getRecentUserUin()))
      {
        paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167040));
        paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        return;
      }
      VipUtils.a(paramView, paramContext, paramRecentBaseData.getRecentUserUin(), paramRecentEfficientItemBuilderHolder);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentEfficientItemBuilder", 2, "bindView: drawable is null");
    }
    paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167040));
    paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
  }
  
  private void a(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    if (paramRecentEfficientItemBuilderHolder.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (((paramRecentBaseData instanceof RecentItemChatMsgData)) && (((RecentItemChatMsgData)paramRecentBaseData).mQimOnline == 1))
      {
        paramRecentEfficientItemBuilderHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(QIMUserManager.a().b(3));
        paramRecentEfficientItemBuilderHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
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
      localStoryHaloManager = (StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a.getManager(QQManagerFactory.STORY_HALO_MANAGER);
    } while (!localStoryHaloManager.a(paramRecentBaseData));
    paramRecentBaseData = (RecentItemChatMsgData)paramRecentBaseData;
    localStoryHaloManager.a(paramRecentBaseData);
    switch (paramRecentBaseData.haloState)
    {
    default: 
      return;
    case -3: 
      a(paramRecentEfficientItemBuilderHolder, paramContext);
      return;
    case -1: 
      a(paramRecentEfficientItemBuilderHolder, paramContext, paramRecentBaseData, 2130846898);
      return;
    }
    a(paramRecentEfficientItemBuilderHolder, paramContext, paramRecentBaseData, 2130846897);
  }
  
  private void a(RecentBaseData paramRecentBaseData, BaseActivity paramBaseActivity, Drawable paramDrawable, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    if (a(paramRecentBaseData))
    {
      if (QLog.isColorLevel()) {
        QLog.i("RecentEfficientItemBuilder", 2, "bindview user:" + paramRecentBaseData.getRecentUserUin());
      }
      paramBaseActivity = paramBaseActivity.app;
      int j = ((Integer)RecentFaceDecoder.a(paramBaseActivity, paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin()).first).intValue();
      int i = j;
      if (j == 103) {
        i = 1;
      }
      paramRecentEfficientItemBuilderHolder = paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
      paramRecentBaseData = paramRecentBaseData.getRecentUserUin();
      if (paramBaseActivity.mAutomator.a() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramRecentEfficientItemBuilderHolder.setFaceDrawable(paramBaseActivity, paramDrawable, i, paramRecentBaseData, 100, false, bool, 0);
        return;
      }
    }
    paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
  }
  
  private void a(RecentBaseData paramRecentBaseData, BaseActivity paramBaseActivity, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder, float paramFloat)
  {
    if ((paramRecentBaseData.getRecentUserType() == 0) && ((paramRecentBaseData instanceof RecentItemChatMsgData)) && (!RobotChatUtil.a(paramRecentBaseData.getRecentUserUin())))
    {
      paramRecentBaseData = (RecentItemChatMsgData)paramRecentBaseData;
      paramBaseActivity = paramBaseActivity.app;
      ArrayList localArrayList = MutualMarkDataCenter.a(paramBaseActivity, paramRecentBaseData.mUser.uin, false, 5);
      paramRecentBaseData = MutualMarkDataCenter.a(paramBaseActivity, paramRecentBaseData.mUser.uin, localArrayList);
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramRecentBaseData);
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(paramFloat * 1.0F));
      return;
    }
    if ((paramRecentBaseData.getRecentUserType() == 1) && ((paramRecentBaseData instanceof RecentItemTroopMsgData)))
    {
      paramRecentBaseData = (RecentItemTroopMsgData)paramRecentBaseData;
      paramRecentBaseData = RecentTroopIconUtil.a(paramBaseActivity.app, paramRecentBaseData);
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(paramRecentBaseData);
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding(0, (int)(paramFloat * 1.0F));
      return;
    }
    paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablesWithIntrinsicBounds(null);
    paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setIconDrawablePadding((int)(2.0F * paramFloat), (int)(paramFloat * 1.0F));
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
      int i = (int)paramContext.getResources().getDimension(2131297502);
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localLayoutParams.setMargins((int)UITools.a(paramContext, 16.0F), localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
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
    if (QLog.isColorLevel()) {
      QLog.i("RecentEfficientItemBuilder", 2, "decorateHaloResource: invoked. Message:  msgItem.haloState : " + paramRecentItemChatMsgData.haloState + " msgItem.getRecentUserUin() : " + paramRecentItemChatMsgData.getRecentUserUin());
    }
    paramRecentEfficientItemBuilderHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramRecentEfficientItemBuilderHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    paramRecentItemChatMsgData = (RelativeLayout.LayoutParams)paramRecentEfficientItemBuilderHolder.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    paramRecentItemChatMsgData.setMargins((int)paramContext.getResources().getDimension(2131297206), paramRecentItemChatMsgData.topMargin, paramRecentItemChatMsgData.rightMargin, paramRecentItemChatMsgData.bottomMargin);
    paramRecentEfficientItemBuilderHolder = (RelativeLayout.LayoutParams)paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
    paramInt = (int)paramContext.getResources().getDimension(2131298944);
    paramRecentEfficientItemBuilderHolder.height = paramInt;
    paramRecentEfficientItemBuilderHolder.width = paramInt;
    paramRecentEfficientItemBuilderHolder.setMargins((int)UITools.a(paramContext, 15.5F), paramRecentEfficientItemBuilderHolder.topMargin, paramRecentEfficientItemBuilderHolder.rightMargin, paramRecentEfficientItemBuilderHolder.bottomMargin);
  }
  
  private void b(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    if ((paramRecentBaseData instanceof RecentMatchChatListItem)) {
      if (!((RecentMatchChatListItem)paramRecentBaseData).mExtendFriendOnline) {
        break label31;
      }
    }
    label31:
    for (int i = 2130845279;; i = 0)
    {
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, i);
      return;
    }
  }
  
  private void c(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    int i = paramRecentBaseData.mExtraInfoColor;
    paramRecentBaseData = paramRecentBaseData.mMsgExtroInfo;
    if (paramRecentBaseData != null) {}
    for (paramRecentBaseData = paramRecentBaseData.toString();; paramRecentBaseData = "")
    {
      Object localObject = paramRecentBaseData;
      if (paramRecentBaseData != null)
      {
        localObject = paramRecentBaseData;
        if (paramRecentBaseData.length() > 0)
        {
          localObject = paramRecentBaseData;
          if (!paramRecentBaseData.endsWith(" ")) {
            localObject = paramRecentBaseData + " ";
          }
        }
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (i != 0)) {
        paramRecentEfficientItemBuilderHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
      }
      paramRecentEfficientItemBuilderHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
      return;
    }
  }
  
  private void d(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    try
    {
      paramRecentEfficientItemBuilderHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mLastMsg);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramRecentEfficientItemBuilderHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mLastMsg + " ");
    }
  }
  
  private void e(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    int i = paramRecentBaseData.mMenuFlag & 0xF0;
    if (i == 32) {}
    try
    {
      paramRecentEfficientItemBuilderHolder.g.setBackgroundResource(2130839538);
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("RecentEfficientItemBuilder", 2, new Object[] { "bindView: leftView set top color, uin=", paramRecentBaseData.getRecentUserUin() });
      return;
    }
    catch (Throwable paramRecentBaseData)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("RecentEfficientItemBuilder", 2, "bindView setBackground error with flag: " + i, paramRecentBaseData);
    }
    paramRecentEfficientItemBuilderHolder.g.setBackgroundResource(2130839537);
    if (QLog.isColorLevel())
    {
      QLog.d("RecentEfficientItemBuilder", 2, new Object[] { "bindView: leftView set normal color,uin=", paramRecentBaseData.getRecentUserUin() });
      return;
    }
  }
  
  private void f(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    int j = 2130842291;
    int i = j;
    switch (paramRecentBaseData.mStatus)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      paramRecentEfficientItemBuilderHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
      return;
      i = j;
      if (paramRecentBaseData.mIsGroupVideo)
      {
        i = 2130842301;
        continue;
        if (paramRecentBaseData.mIsGroupVideo)
        {
          i = 2130842301;
        }
        else
        {
          i = 2130842302;
          continue;
          i = 2130842302;
          continue;
          i = 2130839676;
          continue;
          i = 2130839646;
          continue;
          i = 2130839677;
          continue;
          i = 2130841480;
          continue;
          i = 2130839673;
          continue;
          i = 2130839641;
          continue;
          i = 2130839651;
        }
      }
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    label67:
    Object localObject;
    int i;
    if ((paramView != null) && ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)))
    {
      paramOnDragModeChangedListener = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramOnDragModeChangedListener;
      paramOnDragModeChangedListener = paramContext.getResources().getColorStateList(2131167117);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label811;
      }
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramOnDragModeChangedListener, 0);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.d) {
        paramViewGroup.setContentDescription(null);
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break label825;
      }
      RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
      localObject = localRecentBaseData.getRecentUserUin();
      i = localRecentBaseData.getRecentUserType();
      paramOnDragModeChangedListener = null;
      if (paramRecentFaceDecoder != null) {
        paramOnDragModeChangedListener = paramRecentFaceDecoder.a(localRecentBaseData);
      }
      a(paramViewGroup, localRecentBaseData, paramContext, paramOnDragModeChangedListener);
      if (((StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a.getManager(QQManagerFactory.STORY_HALO_MANAGER)).b(paramObject))
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(-22, paramObject);
        paramView.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
      if ((paramObject instanceof RecentItemEcShop))
      {
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setOnClickListener(paramOnClickListener);
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.d) {
          paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setContentDescription(String.format(HardCodeUtil.a(2131713109), new Object[] { localRecentBaseData.mTitleName }));
        }
      }
      if (String.valueOf(9970L).equals(localRecentBaseData.getRecentUserUin())) {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportEshopExpo("message", String.valueOf(localRecentBaseData.mUnreadNum));
      }
      OfficialAccountReporter.a.a(localRecentBaseData);
    }
    for (paramRecentFaceDecoder = (RecentFaceDecoder)localObject;; paramRecentFaceDecoder = "")
    {
      if ((((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isServiceFolderRedspots()) && ((paramObject instanceof RecentItemServiceAccountFolderData))) {
        paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(4, paramViewGroup);
      }
      a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      if ("2290230341".equals(paramRecentFaceDecoder)) {
        QZoneReport.a(1);
      }
      if (1008 == i) {
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportForPublicAccountExposure(paramRecentFaceDecoder);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
        TempMsgBoxUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a, paramContext, paramObject);
      }
      return paramViewGroup;
      paramOnDragModeChangedListener = new RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder();
      localObject = a(paramContext, this.jdField_a_of_type_Int, paramOnDragModeChangedListener);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)((View)localObject).findViewById(2131368603));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131380944));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131379432));
      paramOnDragModeChangedListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131374462));
      paramOnDragModeChangedListener.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131369827));
      paramOnDragModeChangedListener.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131365699));
      paramOnDragModeChangedListener.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setGravity(16);
      paramViewGroup = paramContext.getResources();
      float f = DeviceInfoUtil.a();
      paramView = paramViewGroup.getColorStateList(2131167117);
      paramViewGroup = paramViewGroup.getColorStateList(2131167040);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramViewGroup);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
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
        ((View)localObject).setTag(paramOnDragModeChangedListener);
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramOnDragModeChangedListener;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) {
          break;
        }
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramOnDragModeChangedListener;
        break;
        paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      }
      label811:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramOnDragModeChangedListener, 0);
      break label67;
      label825:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText("");
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
      i = 0;
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int k = paramRecentBaseData.mMenuFlag;
    paramContext = paramContext.getResources();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    while ((paramRecentBaseData.getRecentUserType() == 1008) || (paramRecentBaseData.getRecentUserType() == 7220))
    {
      if ((RecentPubAccHelper.a(paramRecentBaseData.getRecentUserUin())) && (RecentPubAccManager.a().a()) && (!RecentPubAccManager.a().a(paramRecentBaseData.getRecentUserUin()))) {
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[6]));
      }
      this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[0]));
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    int m = k & 0xF0;
    int j = 2;
    int i = 3;
    if ((paramRecentBaseData.getRecentUserType() == 3000) || (paramRecentBaseData.getRecentUserType() == 1))
    {
      j = 8;
      i = 7;
    }
    if (m == 32) {
      this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[j]));
    }
    for (;;)
    {
      if ((0xF000000 & k) == 16777216) {
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[9]));
      }
      if ((k & 0xF) != 1) {
        break;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[0]));
      break;
      if (m == 16) {
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[i]));
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder localRecentEfficientItemBuilderHolder = a(paramView, paramRecentBaseData);
    if (localRecentEfficientItemBuilderHolder == null) {
      return;
    }
    a(paramRecentBaseData, (BaseActivity)paramContext, paramDrawable, localRecentEfficientItemBuilderHolder);
    a(localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
    VipUtils.a(paramView);
    float f = DeviceInfoUtil.a();
    a(paramView, paramRecentBaseData, paramContext, localRecentEfficientItemBuilderHolder, f);
    a(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
    paramDrawable = paramRecentBaseData.mExtraInfo;
    if (paramDrawable != null) {}
    for (paramDrawable = paramDrawable.toString();; paramDrawable = "")
    {
      localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 2);
      localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
      localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
      if (!TextUtils.isEmpty(paramRecentBaseData.mTitleNameCs)) {
        localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleNameCs);
      }
      a(paramRecentBaseData, (BaseActivity)paramContext, localRecentEfficientItemBuilderHolder, f);
      b(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
      f(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
      c(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
      d(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
      a(paramView, paramRecentBaseData, paramContext, localRecentEfficientItemBuilderHolder);
      e(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
      if (AppSetting.d) {
        paramView.setContentDescription(paramRecentBaseData.mContentDesc);
      }
      localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.a(paramRecentBaseData.getFaceExtraFlag());
      a(localRecentEfficientItemBuilderHolder, paramContext);
      a(paramRecentBaseData, localRecentEfficientItemBuilderHolder, paramContext);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecentEfficientItemBuilder", 2, "bindView end");
      return;
    }
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.getRecentUserType();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentEfficientItemBuilder
 * JD-Core Version:    0.7.0.1
 */