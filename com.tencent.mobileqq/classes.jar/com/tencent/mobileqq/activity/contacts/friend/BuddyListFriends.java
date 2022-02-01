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
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
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
  static final int[] jdField_b_of_type_ArrayOfInt = { 2130839508, 2130839508 };
  static final int[] c = { 2131370814, 2131370814 };
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  public Friends a;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private int jdField_b_of_type_Int = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691089, 2131691090 };
  }
  
  public BuddyListFriends(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = ((Friends)paramEntity);
    a();
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.excute(new BuddyListFriends.1(this), 16, null, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
  }
  
  private String a(int paramInt, IPhoneContactService paramIPhoneContactService)
  {
    Object localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    long l;
    switch (paramInt)
    {
    case 5: 
    default: 
      l = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getLastLoginType();
      if (((paramIPhoneContactService.getUIBits() & 0x2) == 2L) && (l == 1L)) {
        paramIPhoneContactService = HardCodeUtil.a(2131701436);
      }
      break;
    case 7: 
      return this.jdField_a_of_type_AndroidContentContext.getString(2131719225);
    case 6: 
      return "";
    case 4: 
    case 8: 
      return ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId);
    case 3: 
      return this.jdField_a_of_type_AndroidContentContext.getString(2131719231);
    case 2: 
      return this.jdField_a_of_type_AndroidContentContext.getString(2131719221);
    case 1: 
      return this.jdField_a_of_type_AndroidContentContext.getString(2131719219);
    }
    paramIPhoneContactService = ((FriendListHandler)localObject).getOfflineTipsConfig(l);
    localObject = paramIPhoneContactService;
    if (paramIPhoneContactService == null) {
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131719229);
    }
    return localObject;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(this.jdField_a_of_type_AndroidContentContext);
    SpecialCareInfo localSpecialCareInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
    if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0))
    {
      this.jdField_a_of_type_Int |= 0x1;
      return;
    }
    this.jdField_a_of_type_Int &= 0xFFFFFFFE;
  }
  
  private void a(BuddyListFriends.BuddyChildTag paramBuddyChildTag, String paramString)
  {
    paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
    {
      paramBuddyChildTag.jdField_b_of_type_Boolean = false;
      paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(8);
    }
    if (((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).bindOnlineStatusView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends, paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView))
    {
      paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(0);
      paramString = "";
    }
    else
    {
      paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      SimpleTextView localSimpleTextView = paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      localSimpleTextView.setText(localStringBuilder.toString());
      paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(0);
      return;
    }
    paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText("");
    paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setVisibility(8);
  }
  
  private void a(BuddyListFriends.BuddyChildTag paramBuddyChildTag, String paramString1, String paramString2, String paramString3, View paramView)
  {
    if (AppSetting.d)
    {
      StringBuilder localStringBuilder = paramBuddyChildTag.jdField_a_of_type_JavaLangStringBuilder;
      if (localStringBuilder == null) {
        localStringBuilder = new StringBuilder(24);
      } else {
        localStringBuilder.delete(0, localStringBuilder.length());
      }
      String str = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        str = paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a().toString();
      }
      localStringBuilder.append(paramString2);
      localStringBuilder.append(".");
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))
      {
        localStringBuilder.append("QQ会员");
        localStringBuilder.append(".");
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        localStringBuilder.append(paramString3);
        localStringBuilder.append(".");
      }
      if (!TextUtils.isEmpty(paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.jdField_a_of_type_JavaLangStringBuilder)) {
        localStringBuilder.append(paramBuddyChildTag.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
      paramBuddyChildTag = null;
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
      int j = 1;
      int i;
      if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.feedContent))) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramString1 != null) {
        paramBuddyChildTag = ExtensionRichStatus.a(paramString1);
      }
      if ((paramBuddyChildTag == null) || (paramBuddyChildTag == RichStatus.getEmptyStatus()) || (paramBuddyChildTag.isEmpty())) {
        j = 0;
      }
      if ((i != 0) && ((paramString1.feedTime > paramString1.richTime) || (j == 0))) {
        paramBuddyChildTag = new String(paramString1.feedContent);
      } else if (paramBuddyChildTag != null) {
        paramBuddyChildTag = paramBuddyChildTag.getPlainText();
      } else {
        paramBuddyChildTag = "";
      }
      if (!TextUtils.isEmpty(paramBuddyChildTag))
      {
        localStringBuilder.append(".");
        localStringBuilder.append(paramBuddyChildTag);
      }
      paramView.setContentDescription(localStringBuilder);
    }
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    Object localObject1 = null;
    boolean bool2 = true;
    if ((paramView != null) && ((paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) && ((!(paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) || (((BuddyListFriends.BuddyChildTag)paramView.getTag()).jdField_a_of_type_Boolean)))
    {
      localObject2 = (BuddyListFriends.BuddyChildTag)paramView.getTag();
      ((BuddyListFriends.BuddyChildTag)localObject2).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      paramViewGroup = paramView;
      paramView = (View)localObject2;
    }
    else
    {
      if (this.jdField_b_of_type_Int == 1) {
        i = 2131558924;
      } else {
        i = 2131558923;
      }
      localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(i, null);
      paramView = ((FriendItemLayout)localObject2).a();
      try
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130849883);
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849884));
      }
      catch (Exception paramViewGroup)
      {
        QLog.e("BuddyListFriends", 1, paramViewGroup.toString());
      }
      catch (OutOfMemoryError paramViewGroup)
      {
        QLog.e("BuddyListFriends oom", 1, paramViewGroup.toString());
      }
      paramViewGroup = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.createView(this.jdField_a_of_type_AndroidContentContext, (View)localObject2, paramView, -1);
      paramView.jdField_a_of_type_Boolean = true;
      paramViewGroup.setTag(paramView);
      a(((View)localObject2).findViewById(2131368343));
    }
    a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
    paramView.jdField_a_of_type_JavaLangObject = localObject2;
    paramView.jdField_a_of_type_JavaLangString = ((Friends)localObject2).uin;
    paramView.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3);
    int i = OnlineStatusUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
    paramView.jdField_b_of_type_Boolean = false;
    boolean bool1 = bool2;
    if (i != 0) {
      if (i == 6) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    if ((localIPhoneContactService.getUIBits() & 1L) != 1L)
    {
      localObject2 = a();
      ImageView localImageView = paramView.d;
      if (bool1) {
        localObject1 = localObject2;
      }
      localImageView.setImageDrawable((Drawable)localObject1);
      paramView.jdField_b_of_type_Boolean = bool1;
    }
    localObject1 = a(i, localIPhoneContactService);
    a(paramView, (String)localObject1);
    a(paramView);
    paramView.c.setVisibility(8);
    bool2 = SimpleUIUtil.a();
    if ((!bool1) && (!bool2) && ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167202));
    } else {
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131167063));
    }
    if (!bool2) {
      VipUtils.a(paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDataFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
    } else {
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
    paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject2);
    if (!bool2) {
      VipGrayConfigHelper.a().a(paramView.jdField_b_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP), this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingLoginTime, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingGameId, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDan, this.jdField_a_of_type_ComTencentMobileqqDataFriends.namePlateOfKingDanDisplatSwitch, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
    } else if (paramView.jdField_b_of_type_ComTencentImageURLImageView.getVisibility() != 8) {
      paramView.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    RobotChatUtil.a(paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getContext(), paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
    paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
    a(paramViewGroup, paramInt1 << 16 | paramInt2, paramView, paramOnClickListener);
    a(paramView, (String)localObject1, (String)localObject2, null, paramViewGroup);
    return paramViewGroup;
  }
  
  public String a(BuddyListItem.ViewTag paramViewTag)
  {
    BuddyListFriends.BuddyChildTag localBuddyChildTag = (BuddyListFriends.BuddyChildTag)paramViewTag;
    paramViewTag = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
    int m = 0;
    ExtensionInfo localExtensionInfo = paramViewTag.a((String)localObject, false);
    int i;
    if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent))) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (localExtensionInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseBuddyListItem$BuddyListCallback != null) {
        j = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseBuddyListItem$BuddyListCallback.c();
      } else {
        j = 0;
      }
      boolean bool;
      if (j != 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramViewTag = ExtensionRichStatus.a(localExtensionInfo, bool);
    }
    else
    {
      paramViewTag = null;
    }
    if ((paramViewTag != null) && (paramViewTag != RichStatus.getEmptyStatus()) && (!paramViewTag.isEmpty())) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((j != 0) && (!TextUtils.isEmpty(paramViewTag.actionText))) {
      k = 1;
    } else {
      k = 0;
    }
    if ((i != 0) && ((localExtensionInfo.feedTime > localExtensionInfo.richTime) || (j == 0)))
    {
      localObject = new String(localExtensionInfo.feedContent);
      localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      if (localExtensionInfo.feedType == 2)
      {
        localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl)) {
          QQStoryCoverImageViewHelper.a(localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView, localExtensionInfo.feedPhotoUrl, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850613));
        } else {
          localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850613));
        }
        localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      else
      {
        localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewTag = localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView;
        if (localExtensionInfo.feedType == 1) {
          i = 2130849885;
        } else {
          i = 2130849883;
        }
        paramViewTag.setBackgroundResource(i);
        paramViewTag = localBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView;
        if (localExtensionInfo.feedHasPhoto) {
          i = m;
        } else {
          i = 8;
        }
        paramViewTag.setVisibility(i);
        if ((localExtensionInfo.feedHasPhoto) && (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl))) {
          a(localBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView, localExtensionInfo.feedPhotoUrl);
        }
        localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
      paramViewTag = null;
    }
    else
    {
      if (k != 0)
      {
        paramViewTag.enableSummaryCached = this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend();
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramViewTag.actionId, 200);
        localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
        i = (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
        localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables((Drawable)localObject, null);
      }
      else if (j == 0)
      {
        paramViewTag = RichStatus.getEmptyStatus();
        localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      }
      String str = paramViewTag.getActionAndData();
      localObject = paramViewTag.getPlainText();
      localBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramViewTag = str;
    }
    if (localExtensionInfo == null)
    {
      localBuddyChildTag.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramViewTag, 1);
    localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
    return localObject;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected void a(int paramInt, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    if (paramArrayOfSwipRightMenuItem != null)
    {
      if (paramArrayOfSwipRightMenuItem.length <= 0) {
        return;
      }
      int j = paramArrayOfSwipRightMenuItem.length;
      int i = 0;
      paramInt = i;
      if (j > 0)
      {
        paramInt = i;
        if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend())
        {
          if ((this.jdField_a_of_type_Int & 0x1) == 1) {
            paramArrayOfSwipRightMenuItem[0].menuId = 0;
          } else {
            paramArrayOfSwipRightMenuItem[0].menuId = 1;
          }
          paramArrayOfSwipRightMenuItem[0].menuType = 0;
          paramInt = 1;
        }
      }
      while (paramInt < paramArrayOfSwipRightMenuItem.length)
      {
        paramArrayOfSwipRightMenuItem[paramInt].menuId = -1;
        paramArrayOfSwipRightMenuItem[paramInt].menuType = -1;
        paramInt += 1;
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
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849884);
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(URLDrawableDecodeHandler.b(paramURLImageView.getWidth(), paramURLImageView.getHeight(), ViewUtils.a(2.0F)));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.i);
    paramURLImageView.setImageDrawable(paramString);
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
    return jdField_b_of_type_ArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends
 * JD-Core Version:    0.7.0.1
 */