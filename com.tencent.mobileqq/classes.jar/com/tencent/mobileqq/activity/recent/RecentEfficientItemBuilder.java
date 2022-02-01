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
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
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
import com.tencent.mobileqq.troop.utils.RecentTroopIconUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
    this.jdField_a_of_type_Int = 2131562726;
    this.jdField_a_of_type_Boolean = false;
  }
  
  @Nullable
  private RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder a(View paramView, RecentBaseData paramRecentBaseData)
  {
    if ((paramView != null) && (paramRecentBaseData != null))
    {
      if ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)) {
        paramRecentBaseData = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();
      } else {
        paramRecentBaseData = null;
      }
      if (paramRecentBaseData == null)
      {
        if (QLog.isColorLevel())
        {
          paramRecentBaseData = new StringBuilder();
          paramRecentBaseData.append("bindView|holder is null, tag = ");
          paramRecentBaseData.append(paramView.getTag());
          QLog.i("Q.recent", 2, paramRecentBaseData.toString());
        }
        return null;
      }
      return paramRecentBaseData;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "bindView|param invalidate");
    }
    return null;
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    int n = paramRecentBaseData.mUnreadNum;
    int j = paramRecentBaseData.mUnreadFlag;
    int i = j;
    if ((paramRecentBaseData instanceof RecentItemTroopNotification))
    {
      i = j;
      if (((RecentItemTroopNotification)paramRecentBaseData).unDealMsgCountNumFlag) {
        i = 2;
      }
    }
    j = 1;
    if (n > 0) {
      if (i == 0)
      {
        paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
      }
      else
      {
        if (i == 2)
        {
          paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
          j = 1;
          break label258;
        }
        if (i == 3)
        {
          ExpEntityInfo localExpEntityInfo = ABTestController.a().a("exp_qq_message_reminder_dnd");
          localExpEntityInfo.a();
          if (localExpEntityInfo.a())
          {
            k = 11;
            j = 2130850775;
            i = 0;
          }
          else
          {
            boolean bool = paramRecentBaseData instanceof RecentTroopAssistantItem;
            paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167188));
            i = n;
            k = 3;
            j = 2130850774;
          }
          paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
          m = j;
          int i1 = i;
          i = 0;
          j = k;
          k = i1;
          break label267;
        }
        paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
        paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167189));
        if (this.jdField_a_of_type_Boolean) {
          i = j;
        } else {
          i = 0;
        }
        k = n;
        j = 3;
        m = 2130850770;
        break label267;
      }
    }
    j = 0;
    label258:
    i = 0;
    int k = 0;
    int m = 0;
    label267:
    CustomWidgetUtil.a(paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, j, k, m, 99, null);
    if (i != 0)
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
            paramView = paramRecentBaseData.a.a(paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, n, paramView);
            if (paramView != null)
            {
              if (Build.VERSION.SDK_INT >= 16) {
                paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackground(paramView.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
              } else {
                paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setBackgroundDrawable(paramView.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
              }
              paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramView.jdField_a_of_type_Int);
              paramView = paramView.jdField_a_of_type_AndroidGraphicsRect;
              paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setPadding(paramView.left, paramView.top, paramView.right, paramView.bottom);
            }
          }
        }
      }
    }
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder, float paramFloat)
  {
    if (paramRecentBaseData.mAuthenIconId != 0)
    {
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167063));
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(paramFloat * 3.0F));
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("bindView: item.authId=");
        paramView.append(paramRecentBaseData.mAuthenIconId);
        QLog.d("RecentEfficientItemBuilder", 2, paramView.toString());
      }
    }
    else
    {
      if ((paramRecentBaseData.getRecentUserType() == 0) && (!SimpleUIUtil.a()))
      {
        if (QFileAssistantUtils.a(paramRecentBaseData.getRecentUserUin()))
        {
          paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167063));
          paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
          return;
        }
        VipUtils.a(paramView, paramContext, paramRecentBaseData.getRecentUserUin(), paramRecentEfficientItemBuilderHolder);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentEfficientItemBuilder", 2, "bindView: drawable is null");
      }
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131167063));
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
    }
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a != null))
    {
      StoryHaloManager localStoryHaloManager = (StoryHaloManager)this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a.getManager(QQManagerFactory.STORY_HALO_MANAGER);
      if (localStoryHaloManager.a(paramRecentBaseData))
      {
        paramRecentBaseData = (RecentItemChatMsgData)paramRecentBaseData;
        localStoryHaloManager.a(paramRecentBaseData);
        int i = paramRecentBaseData.haloState;
        if (i != -3)
        {
          if (i != -2)
          {
            if (i != -1) {
              return;
            }
            a(paramRecentEfficientItemBuilderHolder, paramContext, paramRecentBaseData, 2130846776);
            return;
          }
          a(paramRecentEfficientItemBuilderHolder, paramContext, paramRecentBaseData, 2130846775);
          return;
        }
        a(paramRecentEfficientItemBuilderHolder, paramContext);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RecentEfficientItemBuilder", 2, "decorateStoryHalo: failed. Message: empty adapter. ");
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, BaseActivity paramBaseActivity, Drawable paramDrawable, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    if (a(paramRecentBaseData))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("bindview user:");
        localStringBuilder.append(paramRecentBaseData.getRecentUserUin());
        QLog.i("RecentEfficientItemBuilder", 2, localStringBuilder.toString());
      }
      paramBaseActivity = paramBaseActivity.app;
      int i = ((Integer)RecentFaceDecoder.a(paramBaseActivity, paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin()).first).intValue();
      if (i == 103) {
        i = 1;
      }
      paramRecentEfficientItemBuilderHolder = paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
      paramRecentBaseData = paramRecentBaseData.getRecentUserUin();
      boolean bool;
      if (paramBaseActivity.mAutomator.a() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramRecentEfficientItemBuilderHolder.setFaceDrawable(paramBaseActivity, paramDrawable, i, paramRecentBaseData, 100, false, bool, 0);
      return;
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
    if ((paramRecentEfficientItemBuilderHolder != null) && (paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView != null))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
      if (localLayoutParams == null) {
        return;
      }
      int i = (int)paramContext.getResources().getDimension(2131297491);
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localLayoutParams.setMargins((int)UITools.a(paramContext, 16.0F), localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      if (paramRecentEfficientItemBuilderHolder.jdField_b_of_type_AndroidWidgetImageView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RecentEfficientItemBuilder", 2, "decorateVanishHalo: failed.  exception: holder story halo is null. ");
        }
        return;
      }
      paramRecentEfficientItemBuilderHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RecentEfficientItemBuilder", 2, "decorateVanishHalo: failed.  exception: holder icon is null. ");
    }
  }
  
  private void a(RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder, Context paramContext, RecentItemChatMsgData paramRecentItemChatMsgData, int paramInt)
  {
    if ((paramRecentEfficientItemBuilderHolder != null) && (paramRecentItemChatMsgData != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decorateHaloResource: invoked. Message:  msgItem.haloState : ");
        localStringBuilder.append(paramRecentItemChatMsgData.haloState);
        localStringBuilder.append(" msgItem.getRecentUserUin() : ");
        localStringBuilder.append(paramRecentItemChatMsgData.getRecentUserUin());
        QLog.i("RecentEfficientItemBuilder", 2, localStringBuilder.toString());
      }
      paramRecentEfficientItemBuilderHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramRecentEfficientItemBuilderHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      paramRecentItemChatMsgData = (RelativeLayout.LayoutParams)paramRecentEfficientItemBuilderHolder.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      paramRecentItemChatMsgData.setMargins((int)paramContext.getResources().getDimension(2131297188), paramRecentItemChatMsgData.topMargin, paramRecentItemChatMsgData.rightMargin, paramRecentItemChatMsgData.bottomMargin);
      paramRecentEfficientItemBuilderHolder = (RelativeLayout.LayoutParams)paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.getLayoutParams();
      paramInt = (int)paramContext.getResources().getDimension(2131298949);
      paramRecentEfficientItemBuilderHolder.height = paramInt;
      paramRecentEfficientItemBuilderHolder.width = paramInt;
      paramRecentEfficientItemBuilderHolder.setMargins((int)UITools.a(paramContext, 15.5F), paramRecentEfficientItemBuilderHolder.topMargin, paramRecentEfficientItemBuilderHolder.rightMargin, paramRecentEfficientItemBuilderHolder.bottomMargin);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("decorateHaloResource: failed.  exception:  holder: ");
      paramContext.append(paramRecentEfficientItemBuilderHolder);
      paramContext.append(" msgItem: ");
      paramContext.append(paramRecentItemChatMsgData);
      QLog.e("RecentEfficientItemBuilder", 2, paramContext.toString());
    }
  }
  
  private void b(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    if ((paramRecentBaseData instanceof RecentMatchChatListItem))
    {
      int i;
      if (((RecentMatchChatListItem)paramRecentBaseData).mExtendFriendOnline) {
        i = 2130845171;
      } else {
        i = 0;
      }
      paramRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, i);
    }
  }
  
  private void c(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    int i = paramRecentBaseData.mExtraInfoColor;
    paramRecentBaseData = paramRecentBaseData.mMsgExtroInfo;
    if (paramRecentBaseData != null) {
      paramRecentBaseData = paramRecentBaseData.toString();
    } else {
      paramRecentBaseData = "";
    }
    Object localObject = paramRecentBaseData;
    if (paramRecentBaseData != null)
    {
      localObject = paramRecentBaseData;
      if (paramRecentBaseData.length() > 0)
      {
        localObject = paramRecentBaseData;
        if (!paramRecentBaseData.endsWith(" "))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramRecentBaseData);
          ((StringBuilder)localObject).append(" ");
          localObject = ((StringBuilder)localObject).toString();
        }
      }
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (i != 0)) {
      paramRecentEfficientItemBuilderHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
    }
    paramRecentEfficientItemBuilderHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
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
      paramRecentEfficientItemBuilderHolder = paramRecentEfficientItemBuilderHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRecentBaseData.mLastMsg);
      localStringBuilder.append(" ");
      paramRecentEfficientItemBuilderHolder.setText(localStringBuilder.toString());
    }
  }
  
  private void e(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    int i = paramRecentBaseData.mMenuFlag & 0xF0;
    if (i == 32) {}
    try
    {
      paramRecentEfficientItemBuilderHolder.leftView.setBackgroundResource(2130839394);
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
      paramRecentEfficientItemBuilderHolder = new StringBuilder();
      paramRecentEfficientItemBuilderHolder.append("bindView setBackground error with flag: ");
      paramRecentEfficientItemBuilderHolder.append(i);
      QLog.d("RecentEfficientItemBuilder", 2, paramRecentEfficientItemBuilderHolder.toString(), paramRecentBaseData);
    }
    paramRecentEfficientItemBuilderHolder.leftView.setBackgroundResource(2130839393);
    if (QLog.isColorLevel())
    {
      QLog.d("RecentEfficientItemBuilder", 2, new Object[] { "bindView: leftView set normal color,uin=", paramRecentBaseData.getRecentUserUin() });
      return;
    }
  }
  
  private void f(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    int j = paramRecentBaseData.mStatus;
    int i = 2130842199;
    switch (j)
    {
    default: 
      i = 0;
      break;
    case 11: 
      i = 2130839509;
      break;
    case 10: 
      i = 2130839499;
      break;
    case 9: 
      i = 2130839531;
      break;
    case 8: 
      i = 2130841361;
      break;
    case 7: 
      i = 2130839535;
      break;
    case 6: 
      i = 2130839504;
      break;
    case 5: 
    case 4: 
    case 3: 
      do
      {
        i = 2130842200;
        break;
        i = 2130839534;
        break;
      } while (!paramRecentBaseData.mIsGroupVideo);
    case 2: 
      if ((goto 157) || (paramRecentBaseData.mIsGroupVideo)) {
        break;
      }
    case 1: 
      i = 2130842189;
    }
    paramRecentEfficientItemBuilderHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnDragModeChangedListener = null;
    Object localObject2;
    int i;
    if ((paramView != null) && ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)))
    {
      localObject1 = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    else
    {
      paramView = new RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder();
      paramViewGroup = a(paramContext, this.jdField_a_of_type_Int, paramView);
      paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramViewGroup.findViewById(2131368343));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramViewGroup.findViewById(2131380210));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131378784));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131374007));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369511));
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131365536));
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setGravity(16);
      localObject2 = paramContext.getResources();
      float f = DeviceInfoUtil.a();
      localObject1 = ((Resources)localObject2).getColorStateList(2131167142);
      localObject2 = ((Resources)localObject2).getColorStateList(2131167063);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject2);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject1, 0);
      } else {
        paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject1, 0);
      }
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
      localObject2 = paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView;
      i = (int)(2.0F * f);
      ((SingleLineTextView)localObject2).setIconDrawablePadding(i, (int)(1.0F * f));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 5.0F), 2);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject1, 2);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject1);
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding(i, 1);
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
      paramViewGroup.setTag(paramView);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
        paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
      }
    }
    Object localObject1 = paramContext.getResources().getColorStateList(2131167142);
    if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject1, 0);
    } else {
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject1, 0);
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    if (AppSetting.d) {
      paramViewGroup.setContentDescription(null);
    }
    boolean bool = paramObject instanceof RecentBaseData;
    localObject1 = "";
    if (bool)
    {
      localObject2 = (RecentBaseData)paramObject;
      localObject1 = ((RecentBaseData)localObject2).getRecentUserUin();
      i = ((RecentBaseData)localObject2).getRecentUserType();
      if (paramRecentFaceDecoder != null) {
        paramOnDragModeChangedListener = paramRecentFaceDecoder.a((RecentBaseData)localObject2);
      }
      a(paramViewGroup, (RecentBaseData)localObject2, paramContext, paramOnDragModeChangedListener);
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
          paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setContentDescription(String.format(HardCodeUtil.a(2131713084), new Object[] { ((RecentBaseData)localObject2).mTitleName }));
        }
      }
      if (String.valueOf(9970L).equals(((RecentBaseData)localObject2).getRecentUserUin())) {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportEshopExpo("message", String.valueOf(((RecentBaseData)localObject2).mUnreadNum));
      }
      OfficialAccountReporter.a.a((RecentBaseData)localObject2);
      paramRecentFaceDecoder = (RecentFaceDecoder)localObject1;
    }
    else
    {
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText("");
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
      i = 0;
      paramRecentFaceDecoder = (RecentFaceDecoder)localObject1;
    }
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
      ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).reportTempMsgBoxExposure(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a, paramObject);
    }
    return paramViewGroup;
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData != null) && (paramContext != null))
    {
      int k = paramRecentBaseData.mMenuFlag;
      paramContext = paramContext.getResources();
      List localList = this.jdField_a_of_type_JavaUtilList;
      if (localList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      } else {
        localList.clear();
      }
      if ((paramRecentBaseData.getRecentUserType() != 1008) && (paramRecentBaseData.getRecentUserType() != 7220))
      {
        int m = k & 0xF0;
        int i = 2;
        int j = 3;
        if ((paramRecentBaseData.getRecentUserType() == 3000) || (paramRecentBaseData.getRecentUserType() == 1))
        {
          i = 8;
          j = 7;
        }
        if (m == 32) {
          this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[i]));
        } else if (m == 16) {
          this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[j]));
        }
        if ((0xF000000 & k) == 16777216) {
          this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[9]));
        }
        if ((k & 0xF) == 1) {
          this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[0]));
        }
      }
      else
      {
        if ((RecentPubAccHelper.a(paramRecentBaseData.getRecentUserUin())) && (RecentPubAccManager.a().a()) && (!RecentPubAccManager.a().a(paramRecentBaseData.getRecentUserUin()))) {
          this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[6]));
        }
        this.jdField_a_of_type_JavaUtilList.add(paramContext.getString(jdField_a_of_type_ArrayOfInt[0]));
      }
      return this.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder localRecentEfficientItemBuilderHolder = a(paramView, paramRecentBaseData);
    if (localRecentEfficientItemBuilderHolder == null) {
      return;
    }
    BaseActivity localBaseActivity = (BaseActivity)paramContext;
    a(paramRecentBaseData, localBaseActivity, paramDrawable, localRecentEfficientItemBuilderHolder);
    a(localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView);
    VipUtils.a(paramView);
    float f = DeviceInfoUtil.a();
    a(paramView, paramRecentBaseData, paramContext, localRecentEfficientItemBuilderHolder, f);
    a(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
    paramDrawable = paramRecentBaseData.mExtraInfo;
    if (paramDrawable != null) {
      paramDrawable = paramDrawable.toString();
    } else {
      paramDrawable = "";
    }
    localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 2);
    localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.mShowTime, 0);
    localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleName);
    if (!TextUtils.isEmpty(paramRecentBaseData.mTitleNameCs)) {
      localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.mTitleNameCs);
    }
    a(paramRecentBaseData, localBaseActivity, localRecentEfficientItemBuilderHolder, f);
    b(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
    f(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
    c(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
    d(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
    a(paramView, paramRecentBaseData, paramContext, localRecentEfficientItemBuilderHolder);
    e(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
    if (AppSetting.d) {
      paramView.setContentDescription(paramRecentBaseData.mContentDesc);
    }
    localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.showTroopCreditStatus(paramRecentBaseData.getFaceExtraFlag());
    a(localRecentEfficientItemBuilderHolder, paramContext);
    a(paramRecentBaseData, localRecentEfficientItemBuilderHolder, paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("RecentEfficientItemBuilder", 2, "bindView end");
    }
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.getRecentUserType();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentEfficientItemBuilder
 * JD-Core Version:    0.7.0.1
 */