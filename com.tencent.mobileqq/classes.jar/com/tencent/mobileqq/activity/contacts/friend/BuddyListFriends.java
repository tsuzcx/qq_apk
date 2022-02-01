package com.tencent.mobileqq.activity.contacts.friend;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.BuddyListCallback;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.robotchat.RobotChatUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.QQStoryCoverImageViewHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.ThemeImageWrapper;

public class BuddyListFriends
  extends BuddyListItem
{
  public static final int[] a;
  static final int[] jdField_b_of_type_ArrayOfInt = { 2130839650, 2130839650 };
  static final int[] c = { 2131371189, 2131371189 };
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  public Friends a;
  OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private int jdField_b_of_type_Int = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691169, 2131691170 };
  }
  
  public BuddyListFriends(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager = ((OlympicManager)paramQQAppInterface.getManager(QQManagerFactory.OLYMPIC_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = ((Friends)paramEntity);
    a();
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.excute(new BuddyListFriends.1(this), 16, null, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
  }
  
  private String a(int paramInt, PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    Object localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    long l;
    switch (paramInt)
    {
    case 5: 
    default: 
      l = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getLastLoginType();
      if (((paramPhoneContactManagerImp.f & 0x2) != 2L) || (l != 1L)) {
        break;
      }
    }
    for (paramPhoneContactManagerImp = HardCodeUtil.a(2131701296);; paramPhoneContactManagerImp = ((FriendListHandler)localObject).getOfflineTipsConfig(l))
    {
      localObject = paramPhoneContactManagerImp;
      if (paramPhoneContactManagerImp == null) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131719511);
      }
      return localObject;
      return this.jdField_a_of_type_AndroidContentContext.getString(2131719501);
      return this.jdField_a_of_type_AndroidContentContext.getString(2131719503);
      return this.jdField_a_of_type_AndroidContentContext.getString(2131719507);
      return this.jdField_a_of_type_AndroidContentContext.getString(2131719513);
      return "";
      return ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId);
    }
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
  
  private void a(BuddyListFriends.BuddyChildTag paramBuddyChildTag, String paramString)
  {
    paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
    {
      paramBuddyChildTag.jdField_b_of_type_Boolean = false;
      paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(8);
    }
    if (paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends))
    {
      paramString = "";
      paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(0);
    }
    while (!TextUtils.isEmpty(paramString))
    {
      paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("[" + paramString + "]");
      paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
      return;
      paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(8);
    }
    paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("");
    paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(8);
  }
  
  private void a(BuddyListFriends.BuddyChildTag paramBuddyChildTag, String paramString1, String paramString2, String paramString3, View paramView)
  {
    int j = 1;
    StringBuilder localStringBuilder;
    int i;
    if (AppSetting.d)
    {
      localStringBuilder = paramBuddyChildTag.jdField_a_of_type_JavaLangStringBuilder;
      if (localStringBuilder != null) {
        break label290;
      }
      localStringBuilder = new StringBuilder(24);
      String str = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        str = paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a().toString();
      }
      localStringBuilder.append(paramString2).append(".").append(str).append(".");
      if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
        localStringBuilder.append("QQ会员").append(".");
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localStringBuilder.append(paramString3).append(".");
      }
      if (!TextUtils.isEmpty(paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.jdField_a_of_type_JavaLangStringBuilder)) {
        localStringBuilder.append(paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
      paramBuddyChildTag = null;
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
      if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.feedContent))) {
        break label305;
      }
      i = 1;
      label202:
      if (paramString1 != null) {
        paramBuddyChildTag = ExtensionRichStatus.a(paramString1);
      }
      if ((paramBuddyChildTag == null) || (paramBuddyChildTag == RichStatus.getEmptyStatus()) || (paramBuddyChildTag.isEmpty())) {
        break label311;
      }
      label229:
      if ((i == 0) || ((paramString1.feedTime <= paramString1.richTime) && (j != 0))) {
        break label317;
      }
      paramBuddyChildTag = new String(paramString1.feedContent);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramBuddyChildTag)) {
        localStringBuilder.append(".").append(paramBuddyChildTag);
      }
      paramView.setContentDescription(localStringBuilder);
      return;
      label290:
      localStringBuilder.delete(0, localStringBuilder.length());
      break;
      label305:
      i = 0;
      break label202;
      label311:
      j = 0;
      break label229;
      label317:
      if (paramBuddyChildTag != null) {
        paramBuddyChildTag = paramBuddyChildTag.getPlainText();
      } else {
        paramBuddyChildTag = "";
      }
    }
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject2 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    int i;
    Object localObject1;
    if ((paramView == null) || (!(paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) || (((paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) && (!((BuddyListFriends.BuddyChildTag)paramView.getTag()).jdField_a_of_type_Boolean))) {
      if (this.jdField_b_of_type_Int == 1)
      {
        i = 2131559030;
        localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, null);
        paramViewGroup = ((FriendItemLayout)localObject1).a();
      }
    }
    for (;;)
    {
      try
      {
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130849985);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849986));
        paramView = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, (View)localObject1, paramViewGroup, -1);
        paramViewGroup.jdField_a_of_type_Boolean = true;
        paramView.setTag(paramViewGroup);
        a(((View)localObject1).findViewById(2131368603));
        a();
        paramViewGroup.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
        paramViewGroup.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3);
        int j = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
        paramViewGroup.jdField_b_of_type_Boolean = false;
        if ((j != 0) && (j != 6)) {
          break label633;
        }
        i = 1;
        if ((((PhoneContactManagerImp)localObject2).f & 1L) != 1L)
        {
          localObject1 = a();
          ImageView localImageView = paramViewGroup.d;
          if (i == 0) {
            break label639;
          }
          localImageView.setImageDrawable((Drawable)localObject1);
          if (i == 0) {
            break label645;
          }
          bool = true;
          paramViewGroup.jdField_b_of_type_Boolean = bool;
        }
        localObject1 = a(j, (PhoneContactManagerImp)localObject2);
        a(paramViewGroup, (String)localObject1);
        a(paramViewGroup);
        paramViewGroup.c.setVisibility(8);
        bool = SimpleUIUtil.a();
        if ((i != 0) || (bool) || ((!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
          break label651;
        }
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167177));
        if (bool) {
          break label672;
        }
        VipUtils.a(paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDataFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject2);
        if (bool) {
          break label685;
        }
        VipGrayConfigHelper.a().a(paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP), this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingLoginTime, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingGameId, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDan, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDanDisplatSwitch, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
        RobotChatUtil.a(paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getContext(), paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
        paramViewGroup.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        a(paramView, paramInt1 << 16 | paramInt2, paramViewGroup, paramOnClickListener);
        a(paramViewGroup, (String)localObject1, (String)localObject2, null, paramView);
        return paramView;
        i = 2131559029;
      }
      catch (OutOfMemoryError paramView)
      {
        QLog.e("BuddyListFriends oom", 1, paramView.toString());
        continue;
      }
      catch (Exception paramView)
      {
        QLog.e("BuddyListFriends", 1, paramView.toString());
        continue;
      }
      paramViewGroup = (BuddyListFriends.BuddyChildTag)paramView.getTag();
      paramViewGroup.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      continue;
      label633:
      i = 0;
      continue;
      label639:
      localObject1 = null;
      continue;
      label645:
      boolean bool = false;
      continue;
      label651:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167040));
      continue;
      label672:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      continue;
      label685:
      if (paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView.getVisibility() != 8) {
        paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
    }
  }
  
  public String a(BuddyListItem.ViewTag paramViewTag)
  {
    int m = 0;
    BuddyListFriends.BuddyChildTag localBuddyChildTag = (BuddyListFriends.BuddyChildTag)paramViewTag;
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
    int i;
    int j;
    label66:
    boolean bool;
    if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent)))
    {
      i = 1;
      if (localExtensionInfo == null) {
        break label642;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseBuddyListItem$BuddyListCallback == null) {
        break label637;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseBuddyListItem$BuddyListCallback.c();
      if (j == 0) {
        break label294;
      }
      bool = true;
    }
    label73:
    for (paramViewTag = ExtensionRichStatus.a(localExtensionInfo, bool);; paramViewTag = null)
    {
      label101:
      int k;
      if ((paramViewTag != null) && (paramViewTag != RichStatus.getEmptyStatus()) && (!paramViewTag.isEmpty()))
      {
        j = 1;
        if ((j == 0) || (TextUtils.isEmpty(paramViewTag.actionText))) {
          break label305;
        }
        k = 1;
        label118:
        if ((i == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (j != 0))) {
          break label461;
        }
        paramViewTag = new String(localExtensionInfo.feedContent);
        localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        if (localExtensionInfo.feedType != 2) {
          break label331;
        }
        localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl)) {
          break label311;
        }
        QQStoryCoverImageViewHelper.a(localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView, localExtensionInfo.feedPhotoUrl, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850687));
      }
      for (;;)
      {
        localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        localObject = null;
        if (localExtensionInfo == null)
        {
          localBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
        localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramViewTag);
        return paramViewTag;
        i = 0;
        break;
        bool = false;
        break label73;
        j = 0;
        break label101;
        k = 0;
        break label118;
        localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850687));
      }
      label331:
      localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      Object localObject = localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView;
      if (localExtensionInfo.feedType == 1)
      {
        i = 2130849987;
        label360:
        ((ImageView)localObject).setBackgroundResource(i);
        localObject = localBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView;
        if (!localExtensionInfo.feedHasPhoto) {
          break label455;
        }
      }
      for (i = m;; i = 8)
      {
        ((URLImageView)localObject).setVisibility(i);
        if ((localExtensionInfo.feedHasPhoto) && (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl))) {
          a(localBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView, localExtensionInfo.feedPhotoUrl);
        }
        localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        localObject = null;
        break;
        i = 2130849985;
        break label360;
      }
      label461:
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
        localBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        break;
        if (j == 0)
        {
          paramViewTag = RichStatus.getEmptyStatus();
          localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        }
      }
      label637:
      j = 0;
      break label66;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
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
          paramArrayOfSwipRightMenuItem[0].jdField_b_of_type_Int = 0;
          paramArrayOfSwipRightMenuItem[0].jdField_a_of_type_Int = 0;
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfSwipRightMenuItem.length) {
          break label91;
        }
        paramArrayOfSwipRightMenuItem[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfSwipRightMenuItem[paramInt].jdField_a_of_type_Int = -1;
        paramInt += 1;
        continue;
        paramArrayOfSwipRightMenuItem[0].jdField_b_of_type_Int = 1;
        break;
        paramInt = 0;
      }
    }
  }
  
  protected void a(View paramView)
  {
    if ((paramView instanceof DynamicAvatarView))
    {
      paramView = (DynamicAvatarView)paramView;
      if (paramView.a == null) {
        paramView.a = new ThemeImageWrapper();
      }
      paramView.a.setSupportMaskView(true);
    }
  }
  
  public void a(URLImageView paramURLImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramURLImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramURLImageView.getHeight();
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849986);
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(URLDrawableDecodeHandler.b(paramURLImageView.getWidth(), paramURLImageView.getHeight(), ViewUtils.a(2.0F)));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.j);
    paramURLImageView.setImageDrawable(paramString);
  }
  
  public int[] a()
  {
    return c;
  }
  
  public int[] b()
  {
    return jdField_a_of_type_ArrayOfInt;
  }
  
  public int[] c()
  {
    return jdField_b_of_type_ArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends
 * JD-Core Version:    0.7.0.1
 */