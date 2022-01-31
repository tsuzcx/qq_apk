package com.tencent.mobileqq.adapter.contacts;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.activity.contact.FriendItemLayout;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AlphaDrawable;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;

public class BuddyListFriends
  extends BuddyListItem
{
  public static final int[] a;
  static final int[] b = { 2130838679, 2130838679 };
  static final int[] c = { 2131369932, 2131369932 };
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131433297, 2131433296 };
  }
  
  public BuddyListFriends(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager = ((OlympicManager)paramQQAppInterface.getManager(166));
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = ((Friends)paramEntity);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c();
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(this.jdField_a_of_type_AndroidContentContext);
    SpecialCareInfo localSpecialCareInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
    if ((localSpecialCareInfo == null) || (localSpecialCareInfo.globalSwitch == 0))
    {
      this.jdField_a_of_type_Int &= 0xFFFFFFFE;
      return;
    }
    this.jdField_a_of_type_Int |= 0x1;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    BuddyListFriends.BuddyChildTag localBuddyChildTag;
    if ((paramView == null) || (!(paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) || (((paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) && (!((BuddyListFriends.BuddyChildTag)paramView.getTag()).jdField_a_of_type_Boolean)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968814, null);
      localBuddyChildTag = ((FriendItemLayout)paramView).a();
    }
    label1450:
    label1465:
    for (;;)
    {
      int k;
      int m;
      int n;
      int i;
      long l1;
      boolean bool;
      try
      {
        localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845330);
        localBuddyChildTag.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130845331);
        localView = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, localBuddyChildTag, -1);
        localBuddyChildTag.jdField_a_of_type_Boolean = true;
        localView.setTag(localBuddyChildTag);
        a();
        localBuddyChildTag.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
        localBuddyChildTag.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
        ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
        int j = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, localExtensionInfo, 0, this.jdField_a_of_type_Boolean);
        k = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, localExtensionInfo, this.jdField_a_of_type_Boolean);
        m = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, localExtensionInfo, this.jdField_a_of_type_Boolean);
        n = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, localExtensionInfo, this.jdField_a_of_type_Boolean);
        i = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, localExtensionInfo, this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, localExtensionInfo, this.jdField_a_of_type_Boolean);
        l1 = -1L;
        long l2 = -1L;
        long l3 = -1L;
        if (localExtensionInfo != null)
        {
          l1 = localExtensionInfo.lastChatTime * 1000L;
          l2 = localExtensionInfo.lastpraiseTime * 1000L;
          l3 = localExtensionInfo.lastQzoneVisitTime * 1000L;
        }
        a(localBuddyChildTag, j, k, m, n, i, l1, l2, l3, localExtensionInfo);
        localBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
        i = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
        paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        switch (i)
        {
        case 5: 
        case 6: 
        default: 
          l1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getLastLoginType();
          if (((((PhoneContactManagerImp)localObject).e & 0x2) != 2L) || (l1 != 1L)) {
            break label1340;
          }
          paramViewGroup = "请留言";
          paramView = paramViewGroup;
          if (paramViewGroup == null) {
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131436009);
          }
          localBuddyChildTag.jdField_b_of_type_Boolean = false;
          if ((i != 0) && (i != 6)) {
            break label1351;
          }
          i = 1;
          if ((((PhoneContactManagerImp)localObject).e & 1L) != 1L)
          {
            paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842321);
            localObject = localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView;
            if (i == 0) {
              break label1357;
            }
            ((ImageView)localObject).setImageDrawable(paramViewGroup);
            if (i == 0) {
              break label1363;
            }
            bool = true;
            localBuddyChildTag.jdField_b_of_type_Boolean = bool;
          }
          if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
          {
            localBuddyChildTag.jdField_b_of_type_Boolean = false;
            localBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
          }
          localBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramView + "]");
          a(localBuddyChildTag);
          localBuddyChildTag.d.setVisibility(8);
          if ((i != 0) || ((!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
            break label1369;
          }
          localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131494297));
          if (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            break label1390;
          }
          localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
          localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843017);
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
          localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
          VipGrayConfigHelper.a().a(localBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP), this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingLoginTime, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingGameId, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDan, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDanDisplatSwitch, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
          a(localView, paramInt1 << 16 | paramInt2, localBuddyChildTag, paramOnClickListener);
          if (AppSetting.jdField_b_of_type_Boolean)
          {
            paramViewGroup = localBuddyChildTag.jdField_a_of_type_JavaLangStringBuilder;
            if (paramViewGroup != null) {
              break label1450;
            }
            paramViewGroup = new StringBuilder(24);
            paramViewGroup.append((String)localObject).append(".").append(paramView).append(".");
            if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
              paramViewGroup.append("QQ会员").append(".");
            }
            if (!TextUtils.isEmpty(null)) {
              paramViewGroup.append(null).append(".");
            }
            if (n != 1) {
              break label1465;
            }
            paramViewGroup.append(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 5));
            if (m != 1) {
              break label1489;
            }
            paramViewGroup.append(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 3));
            if (j <= 0) {
              break label1512;
            }
            paramViewGroup.append(String.format(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 19), new Object[] { Integer.valueOf(j) }));
            if ((localExtensionInfo == null) || (TextUtils.isEmpty(localExtensionInfo.feedContent))) {
              break label1558;
            }
            paramInt1 = 1;
            if (localExtensionInfo == null) {
              break label1587;
            }
            paramView = localExtensionInfo.getRichStatus(false);
            if ((paramView == null) || (paramView == RichStatus.getEmptyStatus()) || (paramView.isEmpty())) {
              break label1563;
            }
            paramInt2 = 1;
            if ((paramInt1 == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (paramInt2 != 0))) {
              break label1568;
            }
            paramView = new String(localExtensionInfo.feedContent);
            if (!TextUtils.isEmpty(paramView)) {
              paramViewGroup.append(".").append(paramView);
            }
            localView.setContentDescription(paramViewGroup);
          }
          return localView;
        }
      }
      catch (Exception paramViewGroup)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("BuddyListFriends", 2, paramViewGroup.toString());
        continue;
      }
      localBuddyChildTag = (BuddyListFriends.BuddyChildTag)paramView.getTag();
      localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      View localView = paramView;
      continue;
      label1340:
      label1351:
      label1357:
      label1489:
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 10)
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131436014);
      }
      else
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131436012);
        continue;
        label1363:
        label1369:
        label1512:
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 10)
        {
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131436015);
        }
        else
        {
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131436013);
          continue;
          paramView = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId);
          continue;
          paramViewGroup = paramView.a(l1);
          continue;
          i = 0;
          continue;
          paramViewGroup = null;
          continue;
          bool = false;
          continue;
          localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131494212));
          continue;
          label1390:
          if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
          {
            localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
            localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843025);
          }
          else
          {
            localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
            continue;
            paramViewGroup.delete(0, paramViewGroup.length());
            continue;
            if (n == 2)
            {
              paramViewGroup.append(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 6));
              continue;
              if (m == 2)
              {
                paramViewGroup.append(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 4));
                continue;
                if (k == 1)
                {
                  paramViewGroup.append(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 1));
                }
                else if (k == 2)
                {
                  paramViewGroup.append(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 2));
                  continue;
                  paramInt1 = 0;
                  continue;
                  paramInt2 = 0;
                  continue;
                  if (paramView != null)
                  {
                    paramView = paramView.getPlainText();
                  }
                  else
                  {
                    paramView = "";
                    continue;
                    paramView = null;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public String a(BuddyListItem.ViewTag paramViewTag)
  {
    int m = 0;
    BuddyListFriends.BuddyChildTag localBuddyChildTag = (BuddyListFriends.BuddyChildTag)paramViewTag;
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
    int i;
    int j;
    label65:
    boolean bool;
    if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent)))
    {
      i = 1;
      if (localExtensionInfo == null) {
        break label467;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListItem$BuddyListCallback == null) {
        break label462;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListItem$BuddyListCallback.b();
      if (j == 0) {
        break label276;
      }
      bool = true;
    }
    label72:
    label462:
    label467:
    for (paramViewTag = localExtensionInfo.getRichStatus(bool);; paramViewTag = null)
    {
      label100:
      int k;
      label117:
      Object localObject;
      if ((paramViewTag != null) && (paramViewTag != RichStatus.getEmptyStatus()) && (!paramViewTag.isEmpty()))
      {
        j = 1;
        if ((j == 0) || (TextUtils.isEmpty(paramViewTag.actionText))) {
          break label287;
        }
        k = 1;
        if ((i == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (j != 0))) {
          break label305;
        }
        paramViewTag = new String(localExtensionInfo.feedContent);
        localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView;
        if (localExtensionInfo.feedType != 1) {
          break label293;
        }
        i = 2130845332;
        ((ImageView)localObject).setBackgroundResource(i);
        localObject = localBuddyChildTag.jdField_c_of_type_AndroidWidgetImageView;
        if (!localExtensionInfo.feedHasPhoto) {
          break label299;
        }
      }
      for (i = m;; i = 8)
      {
        ((ImageView)localObject).setVisibility(i);
        localObject = null;
        if (localExtensionInfo == null)
        {
          localBuddyChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
        localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramViewTag);
        return paramViewTag;
        i = 0;
        break;
        bool = false;
        break label72;
        j = 0;
        break label100;
        k = 0;
        break label117;
        i = 2130845330;
        break label191;
      }
      if (k != 0)
      {
        paramViewTag.enableSummaryCached = this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend();
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramViewTag.actionId, 200);
        localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
        i = (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
        localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables((Drawable)localObject, null);
      }
      for (;;)
      {
        localObject = paramViewTag.getActionAndData();
        paramViewTag = paramViewTag.getPlainText();
        localBuddyChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        if (j == 0)
        {
          paramViewTag = RichStatus.getEmptyStatus();
          localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        }
      }
      j = 0;
      break label65;
    }
  }
  
  public void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2, ImageView paramImageView, AlphaDrawable paramAlphaDrawable, ExtensionInfo paramExtensionInfo)
  {
    if (HotReactiveHelper.a(paramInt1, paramLong)) {
      if (paramInt2 == 1) {
        if ((!paramBoolean) && (paramExtensionInfo != null)) {
          if ((paramExtensionInfo.praiseAnimStartTime != 0L) && (System.currentTimeMillis() - paramExtensionInfo.praiseAnimStartTime > 3500L))
          {
            paramExtensionInfo.hasRemindPraise = true;
            paramAlphaDrawable.a();
            HotReactiveHelper.a(paramExtensionInfo);
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          HotReactiveHelper.a(paramAlphaDrawable);
          paramExtensionInfo.praiseAnimStartTime = System.currentTimeMillis();
          return;
          paramAlphaDrawable.a();
          return;
          if (paramInt2 == 0)
          {
            if ((!paramBoolean) && (paramExtensionInfo != null))
            {
              if ((paramExtensionInfo.chatAnimStartTime != 0L) && (System.currentTimeMillis() - paramExtensionInfo.chatAnimStartTime > 3500L))
              {
                paramExtensionInfo.hasRemindChat = true;
                paramAlphaDrawable.a();
                HotReactiveHelper.a(paramExtensionInfo);
                return;
              }
              HotReactiveHelper.a(paramAlphaDrawable);
              paramExtensionInfo.chatAnimStartTime = System.currentTimeMillis();
              return;
            }
            paramAlphaDrawable.a();
            return;
          }
        } while (paramInt2 != 2);
        if ((!paramBoolean) && (paramExtensionInfo != null))
        {
          if ((paramExtensionInfo.qzoneVisitAnimStartTime != 0L) && (System.currentTimeMillis() - paramExtensionInfo.qzoneVisitAnimStartTime > 3500L))
          {
            paramExtensionInfo.hasRemindQzoneVisit = true;
            HotReactiveHelper.a(paramExtensionInfo);
            return;
          }
          paramAlphaDrawable.a(3500);
          paramExtensionInfo.qzoneVisitAnimStartTime = System.currentTimeMillis();
          return;
        }
        paramAlphaDrawable.a();
        return;
        paramAlphaDrawable.b();
      } while (paramExtensionInfo == null);
      if (paramInt2 == 1)
      {
        paramExtensionInfo.hasRemindPraise = false;
        return;
      }
      if (paramInt2 == 0)
      {
        paramExtensionInfo.hasRemindChat = false;
        return;
      }
    } while (paramInt2 != 2);
    paramExtensionInfo.hasRemindQzoneVisit = false;
  }
  
  protected void a(int paramInt, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    paramInt = 1;
    if ((paramArrayOfSwipRightMenuItem == null) || (paramArrayOfSwipRightMenuItem.length <= 0)) {}
    label91:
    for (;;)
    {
      return;
      if ((paramArrayOfSwipRightMenuItem.length < 0) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend())) {
        if ((this.jdField_a_of_type_Int & 0x1) == 1)
        {
          paramArrayOfSwipRightMenuItem[0].b = 0;
          paramArrayOfSwipRightMenuItem[0].jdField_a_of_type_Int = 0;
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfSwipRightMenuItem.length) {
          break label91;
        }
        paramArrayOfSwipRightMenuItem[paramInt].b = -1;
        paramArrayOfSwipRightMenuItem[paramInt].jdField_a_of_type_Int = -1;
        paramInt += 1;
        continue;
        paramArrayOfSwipRightMenuItem[0].b = 1;
        break;
        paramInt = 0;
      }
    }
  }
  
  public void a(BuddyListItem.ViewTag paramViewTag, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, long paramLong3, ExtensionInfo paramExtensionInfo)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool4;
    boolean bool3;
    if (paramExtensionInfo != null)
    {
      bool4 = paramExtensionInfo.hasRemindChat;
      bool2 = paramExtensionInfo.hasRemindPraise;
      bool3 = paramExtensionInfo.hasRemindQzoneVisit;
      bool1 = paramExtensionInfo.isQzoneLover;
    }
    for (;;)
    {
      paramViewTag = (BuddyListFriends.BuddyChildTag)paramViewTag;
      int i = HotReactiveHelper.b();
      ImageView localImageView;
      if (paramInt4 == 1)
      {
        paramViewTag.e.setVisibility(0);
        localImageView = paramViewTag.e;
        if (bool1)
        {
          paramInt4 = 2130845794;
          localImageView.setImageResource(paramInt4);
          label86:
          if (paramInt3 != 1) {
            break label371;
          }
          paramViewTag.f.setVisibility(0);
          paramViewTag.jdField_c_of_type_ComTencentWidgetAlphaDrawable.a(this.jdField_a_of_type_AndroidContentContext, 2130845802, 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          paramViewTag.f.setImageDrawable(paramViewTag.jdField_c_of_type_ComTencentWidgetAlphaDrawable);
          a(i, paramLong2, bool2, 1, paramViewTag.f, paramViewTag.jdField_c_of_type_ComTencentWidgetAlphaDrawable, paramExtensionInfo);
          label154:
          if (paramInt2 != 1) {
            break label472;
          }
          paramViewTag.g.setVisibility(0);
          paramViewTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable.a(this.jdField_a_of_type_AndroidContentContext, 2130845799, 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          paramViewTag.g.setImageDrawable(paramViewTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable);
          a(i, paramLong1, bool4, 0, paramViewTag.g, paramViewTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable, paramExtensionInfo);
          label221:
          if (paramInt2 != 0) {
            break label572;
          }
          paramViewTag.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          label234:
          if (paramInt5 != 1) {
            break label639;
          }
          paramViewTag.h.setVisibility(0);
          paramViewTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable.a(this.jdField_a_of_type_AndroidContentContext, 2130845795, 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          paramViewTag.h.setImageDrawable(paramViewTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable);
          a(i, paramLong3, bool3, 2, paramViewTag.h, paramViewTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable, paramExtensionInfo);
        }
      }
      label371:
      label639:
      do
      {
        return;
        paramInt4 = 2130845801;
        break;
        if (paramInt4 == 2)
        {
          paramViewTag.e.setVisibility(0);
          localImageView = paramViewTag.e;
          if (bool1) {}
          for (paramInt4 = 2130845793;; paramInt4 = 2130845787)
          {
            localImageView.setImageResource(paramInt4);
            break;
          }
        }
        paramViewTag.e.setVisibility(8);
        break label86;
        if (paramInt3 == 2)
        {
          paramViewTag.f.setVisibility(0);
          paramViewTag.jdField_c_of_type_ComTencentWidgetAlphaDrawable.a(this.jdField_a_of_type_AndroidContentContext, 2130845788, 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          paramViewTag.f.setImageDrawable(paramViewTag.jdField_c_of_type_ComTencentWidgetAlphaDrawable);
          a(i, paramLong2, bool2, 1, paramViewTag.f, paramViewTag.jdField_c_of_type_ComTencentWidgetAlphaDrawable, paramExtensionInfo);
          break label154;
        }
        paramViewTag.jdField_c_of_type_ComTencentWidgetAlphaDrawable.b();
        if (paramExtensionInfo != null) {
          paramExtensionInfo.hasRemindPraise = false;
        }
        paramViewTag.f.setVisibility(8);
        break label154;
        if (paramInt2 == 2)
        {
          paramViewTag.g.setVisibility(0);
          paramViewTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable.a(this.jdField_a_of_type_AndroidContentContext, 2130845785, 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          paramViewTag.g.setImageDrawable(paramViewTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable);
          a(i, paramLong1, bool4, 0, paramViewTag.g, paramViewTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable, paramExtensionInfo);
          break label221;
        }
        paramViewTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable.b();
        paramViewTag.g.setVisibility(8);
        if (paramExtensionInfo == null) {
          break label221;
        }
        paramExtensionInfo.hasRemindChat = false;
        break label221;
        if (paramInt1 <= 0)
        {
          paramViewTag.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label234;
        }
        paramInt2 = paramInt1;
        if (paramInt1 > 999) {
          paramInt2 = 999;
        }
        paramViewTag.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewTag.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt2 + "天");
        break label234;
        if (paramInt5 == 2)
        {
          paramViewTag.h.setVisibility(0);
          paramViewTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable.a(this.jdField_a_of_type_AndroidContentContext, 2130845797, 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          paramViewTag.h.setImageDrawable(paramViewTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable);
          a(i, paramLong3, bool3, 2, paramViewTag.h, paramViewTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable, paramExtensionInfo);
          return;
        }
        paramViewTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable.b();
        paramViewTag.h.setVisibility(8);
      } while (paramExtensionInfo == null);
      label472:
      paramExtensionInfo.hasRemindQzoneVisit = false;
      label572:
      return;
      bool3 = false;
      bool4 = false;
    }
  }
  
  protected int[] a()
  {
    return c;
  }
  
  protected int[] b()
  {
    return jdField_a_of_type_ArrayOfInt;
  }
  
  protected int[] c()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.contacts.BuddyListFriends
 * JD-Core Version:    0.7.0.1
 */