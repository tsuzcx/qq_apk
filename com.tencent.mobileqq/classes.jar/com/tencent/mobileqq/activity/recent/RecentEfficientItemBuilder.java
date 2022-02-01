package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.RecentItemGameMsgBoxData;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.troop.utils.RecentTroopIconUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.OnlineStatusCircleView;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class RecentEfficientItemBuilder
  extends RecentItemBaseBuilder
{
  protected int a = 2131629160;
  protected boolean b = false;
  private List<String> h;
  
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
        paramRecentEfficientItemBuilderHolder.e.setDragViewType(-1, paramView);
      }
      else
      {
        if (i == 2)
        {
          paramRecentEfficientItemBuilderHolder.e.setDragViewType(-1, paramView);
          j = 1;
          break label270;
        }
        if (i == 3)
        {
          ExpEntityInfo localExpEntityInfo = ABTestController.a().a("message_reminder_layer2_1505_20210618");
          localExpEntityInfo.h();
          if (localExpEntityInfo.f())
          {
            k = 11;
            j = 2130852597;
            i = 0;
          }
          else
          {
            boolean bool = paramRecentBaseData instanceof RecentTroopAssistantItem;
            paramRecentEfficientItemBuilderHolder.e.setTextColor(paramContext.getResources().getColor(2131168173));
            i = n;
            k = 3;
            j = 2130852596;
          }
          paramRecentEfficientItemBuilderHolder.e.setDragViewType(1, paramView);
          m = j;
          int i1 = i;
          i = 0;
          j = k;
          k = i1;
          break label279;
        }
        paramRecentEfficientItemBuilderHolder.e.setPadding(0, 0, 0, 0);
        paramRecentEfficientItemBuilderHolder.e.setDragViewType(0, paramView);
        paramRecentEfficientItemBuilderHolder.e.setTextColor(paramContext.getResources().getColor(2131168174));
        if (this.b) {
          i = j;
        } else {
          i = 0;
        }
        k = n;
        j = 3;
        m = 2130852592;
        break label279;
      }
    }
    j = 0;
    label270:
    i = 0;
    int k = 0;
    int m = 0;
    label279:
    CustomWidgetUtil.a(paramRecentEfficientItemBuilderHolder.e, j, k, m, 99, null);
    if (i != 0)
    {
      paramView = ThemeUtil.getCurrentThemeId();
      if ((!ThemeUtil.isNowThemeIsSimple(this.f.d, false, paramView)) && ((paramRecentBaseData instanceof RecentItemChatMsgData)))
      {
        i = ((RecentItemChatMsgData)paramRecentBaseData).mBubbleID;
        if (i > 0)
        {
          paramRecentBaseData = (BubbleManager)this.f.d.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
          if (paramRecentBaseData != null)
          {
            paramView = paramRecentBaseData.m.a(paramRecentEfficientItemBuilderHolder.e, i, n, paramView);
            if (paramView != null)
            {
              if (Build.VERSION.SDK_INT >= 16) {
                paramRecentEfficientItemBuilderHolder.e.setBackground(paramView.a);
              } else {
                paramRecentEfficientItemBuilderHolder.e.setBackgroundDrawable(paramView.a);
              }
              paramRecentEfficientItemBuilderHolder.e.setTextColor(paramView.b);
              paramView = paramView.c;
              paramRecentEfficientItemBuilderHolder.e.setPadding(paramView.left, paramView.top, paramView.right, paramView.bottom);
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
      paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168001));
      paramRecentEfficientItemBuilderHolder.d.setCompoundDrawablePadding((int)(paramFloat * 3.0F));
      paramRecentEfficientItemBuilderHolder.d.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
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
      if ((paramRecentBaseData.getRecentUserType() == 0) && (!SimpleUIUtil.e()))
      {
        if (QFileAssistantUtils.a(paramRecentBaseData.getRecentUserUin()))
        {
          paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168001));
          paramRecentEfficientItemBuilderHolder.d.setCompoundDrawablesWithIntrinsicBounds(0, 0);
          return;
        }
        VipUtils.a(paramView, paramContext, paramRecentBaseData.getRecentUserUin(), paramRecentEfficientItemBuilderHolder);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentEfficientItemBuilder", 2, "bindView: drawable is null");
      }
      paramRecentEfficientItemBuilderHolder.d.setTextColor(paramContext.getResources().getColor(2131168001));
      paramRecentEfficientItemBuilderHolder.d.setCompoundDrawablesWithIntrinsicBounds(0, 0);
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    if (paramRecentEfficientItemBuilderHolder.f != null)
    {
      paramRecentEfficientItemBuilderHolder.f.setVisibility(8);
      if (((paramRecentBaseData instanceof RecentItemChatMsgData)) && (((RecentItemChatMsgData)paramRecentBaseData).mQimOnline == 1))
      {
        paramRecentEfficientItemBuilderHolder.f.setBackgroundDrawable(QIMUserManager.b().b(3));
        paramRecentEfficientItemBuilderHolder.f.setVisibility(0);
      }
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder, Context paramContext)
  {
    if ((this.f != null) && (this.f.d != null))
    {
      StoryHaloManager localStoryHaloManager = (StoryHaloManager)this.f.d.getManager(QQManagerFactory.STORY_HALO_MANAGER);
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
            a(paramRecentEfficientItemBuilderHolder, paramContext, paramRecentBaseData, 2130848328);
            return;
          }
          a(paramRecentEfficientItemBuilderHolder, paramContext, paramRecentBaseData, 2130848327);
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
  
  private void a(RecentBaseData paramRecentBaseData, BaseActivity paramBaseActivity, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder, float paramFloat)
  {
    if ((paramRecentBaseData.getRecentUserType() == 0) && ((paramRecentBaseData instanceof RecentItemChatMsgData)) && (!RobotChatUtil.a(paramRecentBaseData.getRecentUserUin())))
    {
      paramRecentBaseData = (RecentItemChatMsgData)paramRecentBaseData;
      paramBaseActivity = paramBaseActivity.app;
      ArrayList localArrayList = MutualMarkDataCenter.a(paramBaseActivity, paramRecentBaseData.mUser.uin, false, 5);
      paramRecentBaseData = MutualMarkDataCenter.a(paramBaseActivity, paramRecentBaseData.mUser.uin, localArrayList);
      paramRecentEfficientItemBuilderHolder.d.setIconDrawablesWithIntrinsicBounds(paramRecentBaseData);
      paramRecentEfficientItemBuilderHolder.d.setIconDrawablePadding(0, (int)(paramFloat * 1.0F));
      return;
    }
    if ((paramRecentBaseData.getRecentUserType() == 1) && ((paramRecentBaseData instanceof RecentItemTroopMsgData)))
    {
      paramRecentBaseData = (RecentItemTroopMsgData)paramRecentBaseData;
      paramRecentBaseData = RecentTroopIconUtil.a(paramBaseActivity.app, paramRecentBaseData);
      paramRecentEfficientItemBuilderHolder.d.setIconDrawablesWithIntrinsicBounds(paramRecentBaseData);
      paramRecentEfficientItemBuilderHolder.d.setIconDrawablePadding(0, (int)(paramFloat * 1.0F));
      return;
    }
    paramRecentEfficientItemBuilderHolder.d.setIconDrawablesWithIntrinsicBounds(null);
    paramRecentEfficientItemBuilderHolder.d.setIconDrawablePadding((int)(2.0F * paramFloat), (int)(paramFloat * 1.0F));
  }
  
  private void a(RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder, Context paramContext)
  {
    if ((paramRecentEfficientItemBuilderHolder != null) && (paramRecentEfficientItemBuilderHolder.a != null))
    {
      SimpleModeHelper.a(paramRecentEfficientItemBuilderHolder);
      if (paramRecentEfficientItemBuilderHolder.h == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RecentEfficientItemBuilder", 2, "decorateVanishHalo: failed.  exception: holder story halo is null. ");
        }
        return;
      }
      paramRecentEfficientItemBuilderHolder.h.setVisibility(8);
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
      paramRecentEfficientItemBuilderHolder.h.setVisibility(0);
      paramRecentEfficientItemBuilderHolder.h.setImageResource(paramInt);
      paramRecentItemChatMsgData = (RelativeLayout.LayoutParams)paramRecentEfficientItemBuilderHolder.h.getLayoutParams();
      paramRecentItemChatMsgData.setMargins((int)paramContext.getResources().getDimension(2131297618), paramRecentItemChatMsgData.topMargin, paramRecentItemChatMsgData.rightMargin, paramRecentItemChatMsgData.bottomMargin);
      paramRecentItemChatMsgData = (RelativeLayout.LayoutParams)paramRecentEfficientItemBuilderHolder.a.getLayoutParams();
      paramInt = (int)paramContext.getResources().getDimension(2131299671);
      paramRecentItemChatMsgData.height = paramInt;
      paramRecentItemChatMsgData.width = paramInt;
      if (paramRecentEfficientItemBuilderHolder.c != null)
      {
        paramRecentItemChatMsgData = (RelativeLayout.LayoutParams)paramRecentEfficientItemBuilderHolder.c.getLayoutParams();
        paramRecentItemChatMsgData.height = paramInt;
        paramRecentItemChatMsgData.width = paramInt;
      }
      paramRecentItemChatMsgData.setMargins((int)UITools.a(paramContext, 15.5F), paramRecentItemChatMsgData.topMargin, paramRecentItemChatMsgData.rightMargin, paramRecentItemChatMsgData.bottomMargin);
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
  
  private void a(boolean paramBoolean)
  {
    if (this.f != null)
    {
      if (!paramBoolean) {
        return;
      }
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).reportSubAccountBoxExposure(this.f.d);
    }
  }
  
  private void b(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    if ((paramRecentBaseData instanceof RecentMatchChatListItem))
    {
      int i;
      if (((RecentMatchChatListItem)paramRecentBaseData).mExtendFriendOnline) {
        i = 2130846612;
      } else {
        i = 0;
      }
      paramRecentEfficientItemBuilderHolder.d.setCompoundDrawablesWithIntrinsicBounds(0, i);
    }
  }
  
  private void b(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder, Context paramContext)
  {
    int i = paramRecentBaseData.mMenuFlag & 0xF0;
    if (!QQTheme.isNowThemeIsNight())
    {
      if (i == 32) {
        paramRecentBaseData = "#F5F6F5";
      } else {
        paramRecentBaseData = "#FFFFFF";
      }
    }
    else if (i == 32) {
      paramRecentBaseData = "#0F0F0F";
    } else {
      paramRecentBaseData = "#000000";
    }
    paramRecentEfficientItemBuilderHolder.b.setBackgroundColor(Color.parseColor(paramRecentBaseData));
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
      paramRecentEfficientItemBuilderHolder.g.setExtendTextColor(ColorStateList.valueOf(i), 1);
    }
    paramRecentEfficientItemBuilderHolder.g.setExtendText((String)localObject, 1);
  }
  
  private void d(RecentBaseData paramRecentBaseData, RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder paramRecentEfficientItemBuilderHolder)
  {
    try
    {
      paramRecentEfficientItemBuilderHolder.g.setText(paramRecentBaseData.mLastMsg);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramRecentEfficientItemBuilderHolder = paramRecentEfficientItemBuilderHolder.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRecentBaseData.mLastMsg);
      localStringBuilder.append(" ");
      paramRecentEfficientItemBuilderHolder.setText(localStringBuilder.toString());
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    int i;
    if ((paramView != null) && ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)))
    {
      paramOnDragModeChangedListener = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramOnDragModeChangedListener;
    }
    else
    {
      paramView = new RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder();
      paramViewGroup = a(paramContext, this.a, paramView);
      paramView.a = ((RecentDynamicAvatarView)paramViewGroup.findViewById(2131435219));
      paramView.b = ((OnlineStatusCircleView)paramViewGroup.findViewById(2131436485));
      paramView.c = ((RelativeLayout)paramViewGroup.findViewById(2131435268));
      paramView.e = ((DragTextView)paramViewGroup.findViewById(2131449128));
      paramView.d = ((SingleLineTextView)paramViewGroup.findViewById(2131447463));
      paramView.f = ((ImageView)paramViewGroup.findViewById(2131442073));
      paramView.h = ((ImageView)paramViewGroup.findViewById(2131436598));
      paramView.g = ((SingleLineTextView)paramViewGroup.findViewById(2131431757));
      paramView.g.setGravity(16);
      paramOnDragModeChangedListener = paramContext.getResources();
      float f = DeviceInfoUtil.A();
      SimpleModeHelper.a(paramView, paramOnDragModeChangedListener);
      paramView.d.setExtendTextSize(12.0F, 0);
      paramView.d.setCompoundDrawablePadding((int)(3.0F * f));
      paramOnDragModeChangedListener = paramView.d;
      i = (int)(2.0F * f);
      paramOnDragModeChangedListener.setIconDrawablePadding(i, (int)(1.0F * f));
      paramView.d.setExtendTextPadding((int)(f * 5.0F), 2);
      paramView.d.setExtendTextSize(17.0F, 2);
      paramView.g.setExtendTextPadding(i, 1);
      paramView.g.setExtendTextSize(14.0F, 1);
      paramViewGroup.setTag(paramView);
      if (this.f != null) {
        paramView.e.setOnModeChangeListener(this.f.b());
      }
    }
    paramOnDragModeChangedListener = paramContext.getResources();
    Object localObject = paramOnDragModeChangedListener.getColorStateList(2131168122);
    SimpleModeHelper.a(paramView, paramOnDragModeChangedListener, (ColorStateList)localObject, (ColorStateList)localObject);
    paramView.e.setTag(Integer.valueOf(paramInt));
    boolean bool = AppSetting.e;
    paramOnDragModeChangedListener = null;
    if (bool) {
      paramViewGroup.setContentDescription(null);
    }
    if ((paramObject instanceof RecentBaseData))
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
      localObject = localRecentBaseData.getRecentUserUin();
      i = localRecentBaseData.getRecentUserType();
      if (paramRecentFaceDecoder != null) {
        paramOnDragModeChangedListener = paramRecentFaceDecoder.a(localRecentBaseData);
      }
      a(paramViewGroup, localRecentBaseData, paramContext, paramOnDragModeChangedListener);
      if (((StoryHaloManager)this.f.d.getManager(QQManagerFactory.STORY_HALO_MANAGER)).b(paramObject))
      {
        paramView.h.setTag(-22, paramObject);
        paramView.h.setOnClickListener(paramOnClickListener);
      }
      if ((paramObject instanceof RecentItemEcShop))
      {
        paramView.a.setOnClickListener(paramOnClickListener);
        paramView.a.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.e) {
          paramView.a.setContentDescription(String.format(HardCodeUtil.a(2131910643), new Object[] { localRecentBaseData.mTitleName }));
        }
      }
      if (String.valueOf(9970L).equals(localRecentBaseData.getRecentUserUin())) {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportEshopExpo("message", String.valueOf(localRecentBaseData.mUnreadNum));
      }
      OfficialAccountReporter.a.a(localRecentBaseData);
      paramRecentFaceDecoder = (RecentFaceDecoder)localObject;
    }
    else
    {
      paramView.d.setText("");
      paramView.g.setText("");
      paramView.e.setVisibility(4);
      paramRecentFaceDecoder = "";
      i = 0;
    }
    if ((((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).isServiceFolderRedspots()) && ((paramObject instanceof RecentItemServiceAccountFolderData))) {
      paramView.e.setDragViewType(4, paramViewGroup);
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
    if (this.f != null) {
      ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).reportTempMsgBoxExposure(this.f.d, paramObject);
    }
    if ((this.f != null) && ((paramObject instanceof RecentItemGameMsgBoxData))) {
      ((IGameMsgBoxRuntimeService)this.f.d.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).reportItemExp(this.f.d, paramViewGroup, paramView, paramObject, new int[] { 2, 3, 0 });
    }
    a(paramObject instanceof RecentItemSubAccount);
    return paramViewGroup;
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData != null) && (paramContext != null))
    {
      int k = paramRecentBaseData.mMenuFlag;
      paramContext = paramContext.getResources();
      List localList = this.h;
      if (localList == null) {
        this.h = new ArrayList();
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
          this.h.add(paramContext.getString(c[i]));
        } else if (m == 16) {
          this.h.add(paramContext.getString(c[j]));
        }
        if ((0xF000000 & k) == 16777216) {
          this.h.add(paramContext.getString(c[9]));
        }
        if ((k & 0xF) == 1) {
          this.h.add(paramContext.getString(c[0]));
        }
      }
      else
      {
        if ((RecentPubAccHelper.a(paramRecentBaseData.getRecentUserUin())) && (RecentPubAccManager.a().b()) && (!RecentPubAccManager.a().a(paramRecentBaseData.getRecentUserUin()))) {
          this.h.add(paramContext.getString(c[6]));
        }
        this.h.add(paramContext.getString(c[0]));
      }
      return this.h;
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
    RecentUtil.a(paramRecentBaseData, localBaseActivity, paramDrawable, localRecentEfficientItemBuilderHolder.a);
    a(localRecentEfficientItemBuilderHolder.a);
    VipUtils.a(paramView);
    float f = DeviceInfoUtil.A();
    a(paramView, paramRecentBaseData, paramContext, localRecentEfficientItemBuilderHolder, f);
    a(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
    paramDrawable = paramRecentBaseData.mExtraInfo;
    if (paramDrawable != null) {
      paramDrawable = paramDrawable.toString();
    } else {
      paramDrawable = "";
    }
    localRecentEfficientItemBuilderHolder.d.setExtendText(paramDrawable, 2);
    localRecentEfficientItemBuilderHolder.d.setExtendText(paramRecentBaseData.mShowTime, 0);
    localRecentEfficientItemBuilderHolder.d.setText(paramRecentBaseData.mTitleName);
    if (!TextUtils.isEmpty(paramRecentBaseData.mTitleNameCs)) {
      localRecentEfficientItemBuilderHolder.d.setText(paramRecentBaseData.mTitleNameCs);
    }
    a(paramRecentBaseData, localBaseActivity, localRecentEfficientItemBuilderHolder, f);
    b(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
    RecentUtil.a(paramRecentBaseData, localRecentEfficientItemBuilderHolder.g);
    c(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
    d(paramRecentBaseData, localRecentEfficientItemBuilderHolder);
    a(paramView, paramRecentBaseData, paramContext, localRecentEfficientItemBuilderHolder);
    RecentUtil.a(paramRecentBaseData, localRecentEfficientItemBuilderHolder.leftView);
    if (AppSetting.e) {
      paramView.setContentDescription(paramRecentBaseData.mContentDesc);
    }
    localRecentEfficientItemBuilderHolder.a.showTroopCreditStatus(paramRecentBaseData.getFaceExtraFlag());
    a(localRecentEfficientItemBuilderHolder, paramContext);
    a(paramRecentBaseData, localRecentEfficientItemBuilderHolder, paramContext);
    b(paramRecentBaseData, localRecentEfficientItemBuilderHolder, paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("RecentEfficientItemBuilder", 2, "bindView end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentEfficientItemBuilder
 * JD-Core Version:    0.7.0.1
 */