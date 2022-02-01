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
import com.tencent.mobileqq.vip.IGameCardManager.GameCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.ThemeImageWrapper;

public class BuddyListFriends
  extends BuddyListItem
{
  public static final int[] n = { 2131888035, 2131888036 };
  static final int[] o = { 2130839699, 2130839699 };
  static final int[] p = { 2131438137, 2131438137 };
  FriendsManager k;
  StatusManager l;
  public Friends m;
  private int q = 0;
  
  public BuddyListFriends(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.k = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.l = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.m = ((Friends)paramEntity);
    h();
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.excute(new BuddyListFriends.1(this), 16, null, true);
      return;
    }
    this.k.x(this.m.uin);
  }
  
  private String a(int paramInt, IPhoneContactService paramIPhoneContactService)
  {
    Object localObject = (FriendListHandler)this.d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    long l1;
    switch (paramInt)
    {
    case 5: 
    default: 
      l1 = this.m.getLastLoginType();
      if (((paramIPhoneContactService.getUIBits() & 0x2) == 2L) && (l1 == 1L)) {
        paramIPhoneContactService = HardCodeUtil.a(2131899461);
      }
      break;
    case 7: 
      return this.e.getString(2131916777);
    case 6: 
      return "";
    case 4: 
    case 8: 
      return ContactUtils.a(this.m.netTypeIconId);
    case 3: 
      return this.e.getString(2131916783);
    case 2: 
      return this.e.getString(2131916773);
    case 1: 
      return this.e.getString(2131916771);
    }
    paramIPhoneContactService = ((FriendListHandler)localObject).getOfflineTipsConfig(l1);
    localObject = paramIPhoneContactService;
    if (paramIPhoneContactService == null) {
      localObject = this.e.getString(2131916781);
    }
    return localObject;
  }
  
  private void a(BuddyListFriends.BuddyChildTag paramBuddyChildTag, String paramString)
  {
    paramBuddyChildTag.d.setVisibility(0);
    if (Utils.c(this.m.uin))
    {
      paramBuddyChildTag.n = false;
      paramBuddyChildTag.d.setVisibility(8);
    }
    if (((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).bindOnlineStatusView(this.d, this.m, paramBuddyChildTag.o))
    {
      paramBuddyChildTag.o.setVisibility(0);
      paramString = "";
    }
    else
    {
      paramBuddyChildTag.o.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      SimpleTextView localSimpleTextView = paramBuddyChildTag.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      localSimpleTextView.setText(localStringBuilder.toString());
      paramBuddyChildTag.d.setVisibility(0);
      return;
    }
    paramBuddyChildTag.d.setText("");
    paramBuddyChildTag.d.setVisibility(8);
  }
  
  private void a(BuddyListFriends.BuddyChildTag paramBuddyChildTag, String paramString1, String paramString2, String paramString3, View paramView)
  {
    if (AppSetting.e)
    {
      StringBuilder localStringBuilder = paramBuddyChildTag.l;
      if (localStringBuilder == null) {
        localStringBuilder = new StringBuilder(24);
      } else {
        localStringBuilder.delete(0, localStringBuilder.length());
      }
      String str = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        str = paramBuddyChildTag.o.getDescText().toString();
      }
      localStringBuilder.append(paramString2);
      localStringBuilder.append(".");
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      if ((this.m.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.m.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))
      {
        localStringBuilder.append("QQ会员");
        localStringBuilder.append(".");
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        localStringBuilder.append(paramString3);
        localStringBuilder.append(".");
      }
      if (!TextUtils.isEmpty(paramBuddyChildTag.k.h)) {
        localStringBuilder.append(paramBuddyChildTag.k.h.toString());
      }
      paramBuddyChildTag = null;
      paramString1 = this.k.d(this.m.uin, false);
      int j = 1;
      int i;
      if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.feedContent))) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramString1 != null) {
        paramBuddyChildTag = ExtensionRichStatus.c(paramString1);
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
  
  private void h()
  {
    this.a = a(this.e);
    SpecialCareInfo localSpecialCareInfo = this.k.y(this.m.uin);
    if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0))
    {
      this.b |= 0x1;
      return;
    }
    this.b &= 0xFFFFFFFE;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject3 = (IPhoneContactService)this.d.getRuntimeService(IPhoneContactService.class, "");
    Object localObject1 = null;
    boolean bool2 = true;
    if ((paramView != null) && ((paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) && ((!(paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) || (((BuddyListFriends.BuddyChildTag)paramView.getTag()).m)))
    {
      localObject2 = (BuddyListFriends.BuddyChildTag)paramView.getTag();
      ((BuddyListFriends.BuddyChildTag)localObject2).b.setCompoundDrawables(null, null);
      paramViewGroup = paramView;
      paramView = (View)localObject2;
    }
    else
    {
      if (this.q == 1) {
        i = 2131624554;
      } else {
        i = 2131624553;
      }
      localObject2 = LayoutInflater.from(this.e).inflate(i, null);
      paramView = ((FriendItemLayout)localObject2).a();
      try
      {
        paramView.f.setBackgroundResource(2130851611);
        paramView.g.setImageDrawable(this.e.getResources().getDrawable(2130851612));
      }
      catch (Exception paramViewGroup)
      {
        QLog.e("BuddyListFriends", 1, paramViewGroup.toString());
      }
      catch (OutOfMemoryError paramViewGroup)
      {
        QLog.e("BuddyListFriends oom", 1, paramViewGroup.toString());
      }
      paramViewGroup = this.a.createView(this.e, (View)localObject2, paramView, -1);
      paramView.m = true;
      paramViewGroup.setTag(paramView);
      a(((View)localObject2).findViewById(2131435219));
    }
    h();
    Object localObject2 = this.m;
    paramView.c = localObject2;
    paramView.p = ((Friends)localObject2).uin;
    paramView.k.a(this.d, this.m.uin, 3);
    int i = OnlineStatusUtils.a(this.m.detalStatusFlag, this.m.iTermType);
    paramView.n = false;
    boolean bool1 = bool2;
    if (i != 0) {
      if (i == 6) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    if ((((IPhoneContactService)localObject3).getUIBits() & 1L) != 1L)
    {
      localObject2 = g();
      ImageView localImageView = paramView.r;
      if (bool1) {
        localObject1 = localObject2;
      }
      localImageView.setImageDrawable((Drawable)localObject1);
      paramView.n = bool1;
    }
    localObject1 = a(i, (IPhoneContactService)localObject3);
    a(paramView, (String)localObject1);
    a(paramView);
    paramView.h.setVisibility(8);
    bool2 = SimpleUIUtil.e();
    if ((!bool1) && (!bool2) && ((this.m.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) || (this.m.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.m.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
      paramView.a.setTextColor(a(this.e, 2131168187));
    } else {
      paramView.a.setTextColor(a(this.e, 2131168001));
    }
    if (!bool2) {
      VipUtils.a(paramView.a, this.m, this.d, this.e);
    } else {
      paramView.a.setCompoundDrawablesWithIntrinsicBounds(0, 0);
    }
    localObject2 = this.m.getFriendNickWithAlias();
    paramView.a.setText((CharSequence)localObject2);
    if (!bool2)
    {
      localObject3 = new IGameCardManager.GameCardInfo(this.m.uin, this.m.namePlateOfKingGameId, this.m.namePlateOfKingDan, this.m.namePlateOfKingDanDisplatSwitch, this.m.gameCardId);
      ((IGameCardManager.GameCardInfo)localObject3).a = "list";
      VipGrayConfigHelper.a().a(paramView.j, this.m.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP), this.m.namePlateOfKingLoginTime, (IGameCardManager.GameCardInfo)localObject3);
    }
    else if (paramView.j.getVisibility() != 8)
    {
      paramView.j.setVisibility(8);
    }
    RobotChatUtil.a(paramView.a.getContext(), paramView.a, this.m.uin);
    paramView.b.setVisibility(0);
    a(paramViewGroup, paramInt1 << 16 | paramInt2, paramView, paramOnClickListener);
    a(paramView, (String)localObject1, (String)localObject2, null, paramViewGroup);
    return paramViewGroup;
  }
  
  public String a(BuddyListItem.ViewTag paramViewTag)
  {
    BuddyListFriends.BuddyChildTag localBuddyChildTag = (BuddyListFriends.BuddyChildTag)paramViewTag;
    paramViewTag = this.k;
    Object localObject = this.m.uin;
    int i2 = 0;
    ExtensionInfo localExtensionInfo = paramViewTag.d((String)localObject, false);
    int i;
    if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent))) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (localExtensionInfo != null)
    {
      if (this.h != null) {
        j = this.h.g();
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
    int i1;
    if ((j != 0) && (!TextUtils.isEmpty(paramViewTag.actionText))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i != 0) && ((localExtensionInfo.feedTime > localExtensionInfo.richTime) || (j == 0)))
    {
      localObject = new String(localExtensionInfo.feedContent);
      localBuddyChildTag.b.setCompoundDrawables(null, null);
      if (localExtensionInfo.feedType == 2)
      {
        localBuddyChildTag.e.setVisibility(0);
        if (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl)) {
          QQStoryCoverImageViewHelper.a(localBuddyChildTag.e, localExtensionInfo.feedPhotoUrl, this.e.getResources().getDrawable(2130852411));
        } else {
          localBuddyChildTag.e.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852411));
        }
        localBuddyChildTag.f.setVisibility(8);
        localBuddyChildTag.g.setVisibility(8);
      }
      else
      {
        localBuddyChildTag.f.setVisibility(0);
        paramViewTag = localBuddyChildTag.f;
        if (localExtensionInfo.feedType == 1) {
          i = 2130851613;
        } else {
          i = 2130851611;
        }
        paramViewTag.setBackgroundResource(i);
        paramViewTag = localBuddyChildTag.g;
        if (localExtensionInfo.feedHasPhoto) {
          i = i2;
        } else {
          i = 8;
        }
        paramViewTag.setVisibility(i);
        if ((localExtensionInfo.feedHasPhoto) && (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl))) {
          a(localBuddyChildTag.g, localExtensionInfo.feedPhotoUrl);
        }
        localBuddyChildTag.e.setVisibility(8);
        localBuddyChildTag.e.setImageDrawable(null);
      }
      paramViewTag = null;
    }
    else
    {
      if (i1 != 0)
      {
        paramViewTag.enableSummaryCached = this.m.isFriend();
        localObject = this.l.a(paramViewTag.actionId, 200);
        localObject = new BitmapDrawable(this.e.getResources(), (Bitmap)localObject);
        i = (int)DisplayUtils.a(this.e, 12.0F);
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
        localBuddyChildTag.b.setCompoundDrawables((Drawable)localObject, null);
      }
      else if (j == 0)
      {
        paramViewTag = RichStatus.getEmptyStatus();
        localBuddyChildTag.b.setCompoundDrawables(null, null);
      }
      String str = paramViewTag.getActionAndData();
      localObject = paramViewTag.getPlainText();
      localBuddyChildTag.g.setVisibility(8);
      localBuddyChildTag.f.setVisibility(8);
      localBuddyChildTag.e.setVisibility(8);
      localBuddyChildTag.e.setImageDrawable(null);
      paramViewTag = str;
    }
    if (localExtensionInfo == null)
    {
      localBuddyChildTag.g.setVisibility(8);
      localBuddyChildTag.f.setVisibility(8);
    }
    localBuddyChildTag.b.setExtendText(paramViewTag, 1);
    localBuddyChildTag.b.setText((CharSequence)localObject);
    return localObject;
  }
  
  public void a(int paramInt)
  {
    this.q = paramInt;
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
        if (this.m.isFriend())
        {
          if ((this.b & 0x1) == 1) {
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
      if (paramView.g == null) {
        paramView.g = new ThemeImageWrapper();
      }
      paramView.g.setSupportMaskView(true);
    }
  }
  
  public void a(URLImageView paramURLImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramURLImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramURLImageView.getHeight();
    Drawable localDrawable = this.e.getResources().getDrawable(2130851612);
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(URLDrawableDecodeHandler.b(paramURLImageView.getWidth(), paramURLImageView.getHeight(), ViewUtils.dip2px(2.0F)));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.j);
    paramURLImageView.setImageDrawable(paramString);
  }
  
  protected int[] c()
  {
    return p;
  }
  
  protected int[] d()
  {
    return n;
  }
  
  protected int[] e()
  {
    return o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends
 * JD-Core Version:    0.7.0.1
 */