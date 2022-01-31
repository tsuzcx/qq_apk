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
  static final int[] b = { 2130838691, 2130838691 };
  static final int[] c = { 2131370018, 2131370018 };
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131433328, 2131433327 };
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968818, null);
      localBuddyChildTag = ((FriendItemLayout)paramView).a();
    }
    for (;;)
    {
      int k;
      int i;
      int m;
      int n;
      long l1;
      boolean bool;
      try
      {
        localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130845539);
        localBuddyChildTag.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130845540);
        localView = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, localBuddyChildTag, -1);
        localBuddyChildTag.jdField_a_of_type_Boolean = true;
        localView.setTag(localBuddyChildTag);
        a();
        localBuddyChildTag.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
        localBuddyChildTag.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
        ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
        int j = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, localExtensionInfo, 0, this.jdField_a_of_type_Boolean);
        k = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, localExtensionInfo, this.jdField_a_of_type_Boolean);
        i = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, localExtensionInfo, this.jdField_a_of_type_Boolean);
        m = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, localExtensionInfo, this.jdField_a_of_type_Boolean);
        n = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, localExtensionInfo, this.jdField_a_of_type_Boolean);
        int i1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, localExtensionInfo, this.jdField_a_of_type_Boolean);
        l1 = -1L;
        long l4 = -1L;
        long l2 = -1L;
        long l3 = -1L;
        if (localExtensionInfo != null)
        {
          l4 = localExtensionInfo.loverLastChatTime * 1000L;
          l1 = localExtensionInfo.lastChatTime * 1000L;
          l2 = localExtensionInfo.lastpraiseTime * 1000L;
          l3 = localExtensionInfo.lastQzoneVisitTime * 1000L;
        }
        a(localBuddyChildTag, j, k, m, n, i1, i, l1, l2, l3, l4, localExtensionInfo);
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
            break label1361;
          }
          paramViewGroup = "请留言";
          paramView = paramViewGroup;
          if (paramViewGroup == null) {
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131436044);
          }
          localBuddyChildTag.jdField_b_of_type_Boolean = false;
          if ((i != 0) && (i != 6)) {
            break label1372;
          }
          i = 1;
          if ((((PhoneContactManagerImp)localObject).e & 1L) != 1L)
          {
            paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842403);
            localObject = localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView;
            if (i == 0) {
              break label1378;
            }
            ((ImageView)localObject).setImageDrawable(paramViewGroup);
            if (i == 0) {
              break label1384;
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
          localBuddyChildTag.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          if ((i != 0) || ((!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
            break label1390;
          }
          localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131494310));
          if (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            break label1411;
          }
          localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
          localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843148);
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
          localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
          VipGrayConfigHelper.a().a(localBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP), this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingLoginTime, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingGameId, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDan, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDanDisplatSwitch, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
          a(localView, paramInt1 << 16 | paramInt2, localBuddyChildTag, paramOnClickListener);
          if (AppSetting.jdField_b_of_type_Boolean)
          {
            paramViewGroup = localBuddyChildTag.jdField_a_of_type_JavaLangStringBuilder;
            if (paramViewGroup != null) {
              break label1471;
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
              break label1486;
            }
            paramViewGroup.append(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 5));
            if (m != 1) {
              break label1510;
            }
            paramViewGroup.append(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 3));
            if (j <= 0) {
              break label1533;
            }
            paramViewGroup.append(String.format(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 19), new Object[] { Integer.valueOf(j) }));
            if ((localExtensionInfo == null) || (TextUtils.isEmpty(localExtensionInfo.feedContent))) {
              break label1579;
            }
            paramInt1 = 1;
            if (localExtensionInfo == null) {
              break label1608;
            }
            paramView = localExtensionInfo.getRichStatus(false);
            if ((paramView == null) || (paramView == RichStatus.getEmptyStatus()) || (paramView.isEmpty())) {
              break label1584;
            }
            paramInt2 = 1;
            if ((paramInt1 == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (paramInt2 != 0))) {
              break label1589;
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
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 10)
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131436049);
      }
      else
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131436047);
        continue;
        label1411:
        label1579:
        label1584:
        label1589:
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId == 10)
        {
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131436050);
        }
        else
        {
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131436048);
          continue;
          paramView = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId);
          continue;
          label1361:
          paramViewGroup = paramView.a(l1);
          continue;
          label1372:
          i = 0;
          continue;
          label1378:
          paramViewGroup = null;
          continue;
          label1384:
          bool = false;
          continue;
          label1390:
          localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131494225));
          continue;
          label1471:
          label1608:
          if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
          {
            localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
            localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843156);
          }
          else
          {
            localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
            continue;
            paramViewGroup.delete(0, paramViewGroup.length());
            continue;
            label1486:
            if (n == 2)
            {
              paramViewGroup.append(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 6));
              continue;
              label1510:
              if (m == 2)
              {
                paramViewGroup.append(HotReactiveHelper.a(this.jdField_a_of_type_AndroidContentContext, 4));
                continue;
                label1533:
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
        i = 2130845541;
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
        i = 2130845539;
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
  
  public void a(BuddyListItem.ViewTag paramViewTag, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, long paramLong3, long paramLong4, ExtensionInfo paramExtensionInfo)
  {
    boolean bool1 = false;
    boolean bool3;
    boolean bool2;
    if (paramExtensionInfo != null)
    {
      bool3 = paramExtensionInfo.hasRemindChat;
      boolean bool4 = paramExtensionInfo.hasRemindPraise;
      bool1 = paramExtensionInfo.hasRemindQzoneVisit;
      bool2 = paramExtensionInfo.hasRemindLoverChat;
      bool2 = bool1;
      bool1 = bool4;
    }
    for (;;)
    {
      paramViewTag = (BuddyListFriends.BuddyChildTag)paramViewTag;
      int i = HotReactiveHelper.b();
      AlphaDrawable localAlphaDrawable;
      Context localContext;
      if (paramInt4 == 1)
      {
        paramViewTag.e.setVisibility(0);
        paramViewTag.e.setImageResource(2130846011);
        if (paramInt6 != 1) {
          break label409;
        }
        paramViewTag.f.setVisibility(0);
        localAlphaDrawable = paramViewTag.jdField_c_of_type_ComTencentWidgetAlphaDrawable;
        localContext = this.jdField_a_of_type_AndroidContentContext;
        if (!paramExtensionInfo.loverTransFlag) {
          break label401;
        }
        paramInt4 = 2130846004;
        label117:
        localAlphaDrawable.a(localContext, paramInt4, 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
        paramViewTag.f.setImageDrawable(paramViewTag.jdField_c_of_type_ComTencentWidgetAlphaDrawable);
        label145:
        if (paramInt3 != 1) {
          break label517;
        }
        paramViewTag.g.setVisibility(0);
        paramViewTag.jdField_d_of_type_ComTencentWidgetAlphaDrawable.a(this.jdField_a_of_type_AndroidContentContext, 2130846012, 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
        paramViewTag.g.setImageDrawable(paramViewTag.jdField_d_of_type_ComTencentWidgetAlphaDrawable);
        a(i, paramLong2, bool1, 1, paramViewTag.g, paramViewTag.jdField_d_of_type_ComTencentWidgetAlphaDrawable, paramExtensionInfo);
        label213:
        if (paramInt2 != 1) {
          break label618;
        }
        paramViewTag.h.setVisibility(0);
        paramViewTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable.a(this.jdField_a_of_type_AndroidContentContext, 2130846009, 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
        paramViewTag.h.setImageDrawable(paramViewTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable);
        a(i, paramLong1, bool3, 0, paramViewTag.h, paramViewTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable, paramExtensionInfo);
        label280:
        if (paramInt2 != 0) {
          break label718;
        }
        paramViewTag.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        label293:
        if (paramInt5 != 1) {
          break label785;
        }
        paramViewTag.i.setVisibility(0);
        paramViewTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable.a(this.jdField_a_of_type_AndroidContentContext, 2130846005, 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
        paramViewTag.i.setImageDrawable(paramViewTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable);
        a(i, paramLong3, bool2, 2, paramViewTag.i, paramViewTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable, paramExtensionInfo);
      }
      label401:
      label409:
      label618:
      do
      {
        return;
        if (paramInt4 == 2)
        {
          paramViewTag.e.setVisibility(0);
          paramViewTag.e.setImageResource(2130845995);
          break;
        }
        paramViewTag.e.setVisibility(8);
        break;
        paramInt4 = 2130846003;
        break label117;
        if (paramInt6 == 2)
        {
          paramViewTag.f.setVisibility(0);
          localAlphaDrawable = paramViewTag.jdField_c_of_type_ComTencentWidgetAlphaDrawable;
          localContext = this.jdField_a_of_type_AndroidContentContext;
          if (paramExtensionInfo.loverTransFlag) {}
          for (paramInt4 = 2130846002;; paramInt4 = 2130846001)
          {
            localAlphaDrawable.a(localContext, paramInt4, 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
            paramViewTag.f.setImageDrawable(paramViewTag.jdField_c_of_type_ComTencentWidgetAlphaDrawable);
            break;
          }
        }
        paramViewTag.jdField_c_of_type_ComTencentWidgetAlphaDrawable.b();
        if (paramExtensionInfo != null) {
          paramExtensionInfo.hasRemindLoverChat = false;
        }
        paramViewTag.f.setVisibility(8);
        break label145;
        if (paramInt3 == 2)
        {
          paramViewTag.g.setVisibility(0);
          paramViewTag.jdField_d_of_type_ComTencentWidgetAlphaDrawable.a(this.jdField_a_of_type_AndroidContentContext, 2130845996, 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          paramViewTag.g.setImageDrawable(paramViewTag.jdField_d_of_type_ComTencentWidgetAlphaDrawable);
          a(i, paramLong2, bool1, 1, paramViewTag.g, paramViewTag.jdField_d_of_type_ComTencentWidgetAlphaDrawable, paramExtensionInfo);
          break label213;
        }
        paramViewTag.jdField_d_of_type_ComTencentWidgetAlphaDrawable.b();
        if (paramExtensionInfo != null) {
          paramExtensionInfo.hasRemindPraise = false;
        }
        paramViewTag.g.setVisibility(8);
        break label213;
        if (paramInt2 == 2)
        {
          paramViewTag.h.setVisibility(0);
          paramViewTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable.a(this.jdField_a_of_type_AndroidContentContext, 2130845993, 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          paramViewTag.h.setImageDrawable(paramViewTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable);
          a(i, paramLong1, bool3, 0, paramViewTag.h, paramViewTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable, paramExtensionInfo);
          break label280;
        }
        paramViewTag.jdField_b_of_type_ComTencentWidgetAlphaDrawable.b();
        paramViewTag.h.setVisibility(8);
        if (paramExtensionInfo == null) {
          break label280;
        }
        paramExtensionInfo.hasRemindChat = false;
        break label280;
        if (paramInt1 <= 0)
        {
          paramViewTag.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label293;
        }
        paramInt2 = paramInt1;
        if (paramInt1 > 999) {
          paramInt2 = 999;
        }
        paramViewTag.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewTag.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt2 + "天");
        break label293;
        if (paramInt5 == 2)
        {
          paramViewTag.i.setVisibility(0);
          paramViewTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable.a(this.jdField_a_of_type_AndroidContentContext, 2130846007, 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          paramViewTag.i.setImageDrawable(paramViewTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable);
          a(i, paramLong3, bool2, 2, paramViewTag.i, paramViewTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable, paramExtensionInfo);
          return;
        }
        paramViewTag.jdField_a_of_type_ComTencentWidgetAlphaDrawable.b();
        paramViewTag.i.setVisibility(8);
      } while (paramExtensionInfo == null);
      label517:
      label718:
      paramExtensionInfo.hasRemindQzoneVisit = false;
      label785:
      return;
      bool2 = false;
      bool3 = false;
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