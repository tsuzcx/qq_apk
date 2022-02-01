package com.tencent.mobileqq.activity.aio.panel.chatpanelbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper;
import com.tencent.mobileqq.activity.aio.helper.PlusRedPointHelper;
import com.tencent.mobileqq.activity.aio.helper.SimpleUIAIOHelper;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.bizstatus.ChatPanelBarBizUtil;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.bizstatus.RedBagShowData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.ChatPanelDisplayManager;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.UpdateParams;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter.IChatPanelReporter;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager.QIMUserIcon;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.mobileqq.pluspanel.PlusPanelUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class ChatPanelBarController
  implements IChatPanelBarController
{
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private HelperProvider jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider;
  private PanelIconLinearLayout jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  private ChatPanelBarContext jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext;
  ChatPanelBarModel jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel;
  private IChatPanelReporter jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarReporterIChatPanelReporter;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ChatPanelBarController(PanelIconLinearLayout paramPanelIconLinearLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = paramPanelIconLinearLayout;
  }
  
  private AIOPanelIconItem a(AIOPanelIconItem paramAIOPanelIconItem, SessionInfo paramSessionInfo, Context paramContext)
  {
    if ((8 == paramAIOPanelIconItem.jdField_d_of_type_Int) && (paramSessionInfo != null) && (Utils.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramSessionInfo = new AIOPanelIconItem(paramAIOPanelIconItem);
      paramSessionInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(AIOPanelUtiles.T[2]);
      paramSessionInfo.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramAIOPanelIconItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      paramSessionInfo.jdField_d_of_type_Int = AIOPanelUtiles.T[0];
      paramSessionInfo.e = AIOPanelUtiles.T[3];
      paramSessionInfo.jdField_d_of_type_JavaLangString = paramContext.getResources().getString(AIOPanelUtiles.T[1]);
      return paramSessionInfo;
    }
    return null;
  }
  
  @NotNull
  private RedTouch a(AIOPanelIconItem paramAIOPanelIconItem, int paramInt, RedDotImageView paramRedDotImageView)
  {
    paramRedDotImageView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getContext(), paramRedDotImageView).b(53).d(15).e(0).a(true).a();
    paramRedDotImageView.setTag(Integer.valueOf(paramInt));
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a().getRuntimeService(IRedTouchManager.class, "");
    if (paramInt == 8)
    {
      a(paramRedDotImageView);
      return paramRedDotImageView;
    }
    paramAIOPanelIconItem = localIRedTouchManager.getAppInfo(4, String.valueOf(paramAIOPanelIconItem.jdField_b_of_type_Int));
    if (paramAIOPanelIconItem != null)
    {
      paramRedDotImageView.a(paramAIOPanelIconItem);
      localIRedTouchManager.onRedTouchItemExposure(paramAIOPanelIconItem, "");
    }
    return paramRedDotImageView;
  }
  
  private List<AIOPanelIconItem> a(List<AIOPanelIconItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return localArrayList;
      }
      int i = 0;
      while (i < paramList.size())
      {
        AIOPanelIconItem localAIOPanelIconItem = (AIOPanelIconItem)paramList.get(i);
        if (a(localAIOPanelIconItem)) {
          localArrayList.add(localAIOPanelIconItem);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt, RedDotImageView paramRedDotImageView)
  {
    if (paramInt == 23) {
      if (ChatPanelBarBizUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), this.jdField_a_of_type_AndroidContentSharedPreferences))
      {
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850767));
        paramRedDotImageView.a(true);
      }
      else
      {
        paramRedDotImageView.a(false);
      }
    }
    if (paramInt == 26) {
      if (ChatPanelBarBizUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), this.jdField_a_of_type_AndroidContentSharedPreferences))
      {
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850767));
        paramRedDotImageView.a(true);
      }
      else
      {
        paramRedDotImageView.a(false);
      }
    }
    if (paramInt == 3) {
      if (ChatPanelBarBizUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a()))
      {
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850767));
        paramRedDotImageView.a(true);
      }
      else
      {
        paramRedDotImageView.a(false);
      }
    }
    if (paramInt == 2)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a().getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("103100.103300");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1))
      {
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850767));
        paramRedDotImageView.a(true);
        return;
      }
      paramRedDotImageView.a(false);
      return;
    }
    if (paramInt == 6)
    {
      b(paramRedDotImageView);
      return;
    }
    if (paramInt == 10)
    {
      ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).showAIOHongBaoRedPoint(paramRedDotImageView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a());
      return;
    }
    if (paramInt == 8)
    {
      if (b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a()))
      {
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850767));
        paramRedDotImageView.a(true);
        return;
      }
      paramRedDotImageView.a(false);
      return;
    }
    if (paramInt == 24) {
      a(paramRedDotImageView);
    }
  }
  
  private void a(View paramView)
  {
    try
    {
      int i = ((Integer)paramView.getTag()).intValue();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarReporterIChatPanelReporter.a(paramView)) {
        return;
      }
      if (i == 8)
      {
        if (b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a()))
        {
          ScribbleResMgr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a().getCurrentAccountUin());
          a(8, false);
        }
        if ((paramView instanceof RedTouch))
        {
          a((RedTouch)paramView);
          return;
        }
      }
    }
    catch (Exception paramView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PanelIconLinearLayout.onClick e=");
      localStringBuilder.append(paramView.getMessage());
      QLog.e("PanelIconLinearLayout", 1, localStringBuilder.toString());
    }
  }
  
  private void a(AIOPanelIconItem paramAIOPanelIconItem, ArrayList<QIMUserManager.QIMUserIcon> paramArrayList, int paramInt)
  {
    int i = paramAIOPanelIconItem.jdField_d_of_type_Int;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getContext();
    RedDotImageView localRedDotImageView = new RedDotImageView((Context)localObject);
    localRedDotImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localRedDotImageView.setShowBorder(true);
    localObject = new LinearLayout.LayoutParams(0, DisplayUtil.a((Context)localObject, 28.0F));
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    localRedDotImageView.setTag(Integer.valueOf(i));
    if ((paramAIOPanelIconItem.jdField_a_of_type_ArrayOfInt != null) && (paramAIOPanelIconItem.jdField_a_of_type_ArrayOfInt.length > 0)) {
      if (ChatPanelBarBizUtil.a(paramAIOPanelIconItem, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a()))
      {
        QIMUserManager.QIMUserIcon localQIMUserIcon = new QIMUserManager.QIMUserIcon();
        localQIMUserIcon.jdField_a_of_type_Int = paramInt;
        localQIMUserIcon.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = localRedDotImageView;
        paramArrayList.add(localQIMUserIcon);
      }
      else
      {
        localRedDotImageView.setImageResource(paramAIOPanelIconItem.jdField_a_of_type_ArrayOfInt[2]);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.d()) {
      paramArrayList = paramAIOPanelIconItem.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    } else {
      paramArrayList = paramAIOPanelIconItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    localRedDotImageView.setImageDrawable(paramArrayList);
    if (AppSetting.d) {
      localRedDotImageView.setContentDescription(paramAIOPanelIconItem.jdField_d_of_type_JavaLangString);
    }
    if (paramAIOPanelIconItem.e > 0) {
      localRedDotImageView.setId(paramAIOPanelIconItem.e);
    }
    localRedDotImageView.setLongClickable(true);
    localRedDotImageView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
    localRedDotImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
    localRedDotImageView.setSelected(false);
    if (a(i))
    {
      paramAIOPanelIconItem = a(paramAIOPanelIconItem, i, localRedDotImageView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.addView(paramAIOPanelIconItem, (ViewGroup.LayoutParams)localObject);
      return;
    }
    a(i, localRedDotImageView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.addView(localRedDotImageView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void a(RedTouch paramRedTouch)
  {
    if (paramRedTouch != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a().getRuntimeService(IRedTouchManager.class, "");
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.b()) {
        i = 11;
      } else {
        i = 10;
      }
      Object localObject1 = null;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a();
      if (localObject2 != null) {
        localObject1 = ((SessionInfo)localObject2).jdField_b_of_type_JavaLangString;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider;
      if (localObject2 != null)
      {
        localObject1 = localIRedTouchManager.getRedTouchInfoByAppSet(i, (String)localObject1, ((PlusRedPointHelper)((HelperProvider)localObject2).a(89)).a());
        paramRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
        if ((!this.jdField_a_of_type_Boolean) && (localObject1 != null)) {
          localIRedTouchManager.reportLevelZeroRedInfo(i, 30);
        }
        boolean bool;
        if (localObject1 != null) {
          bool = true;
        } else {
          bool = false;
        }
        this.jdField_a_of_type_Boolean = bool;
      }
    }
  }
  
  private void a(RedDotImageView paramRedDotImageView)
  {
    RedBagShowData localRedBagShowData = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a();
    if (!ShortVideoUtils.isHotPicConfiginitied)
    {
      localRedBagShowData.b(ShortVideoUtils.getHotPicRedDotStatus(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a().getCurrentUin()));
      ShortVideoUtils.isHotPicConfiginitied = true;
    }
    if (localRedBagShowData.b())
    {
      paramRedDotImageView.setReddotXOffsetDp(15);
      paramRedDotImageView.setReddotYOffsetDp(11);
      paramRedDotImageView.setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850767));
      paramRedDotImageView.a(true);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), "dc00898", "", "", "0X8009366", "0X8009366", 2, 0, "", "", "", "");
      return;
    }
    paramRedDotImageView.a(false);
  }
  
  private void a(String paramString)
  {
    if (((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http://"))) || (paramString.startsWith("https://")))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a().startActivity(localIntent);
    }
  }
  
  private void a(List<AIOPanelIconItem> paramList, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadData filterMode curType=");
      localStringBuilder.append(paramInt);
      QLog.d("PanelIcon", 2, localStringBuilder.toString());
    }
    if (a(paramBoolean)) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 3000)) {
      paramList.clear();
    }
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt == 10) {
      return false;
    }
    if (paramInt == 8) {
      return true;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.c();
  }
  
  private boolean a(int paramInt, SessionInfo paramSessionInfo)
  {
    if ((10 == paramInt) && (paramSessionInfo != null)) {
      return Utils.b(paramSessionInfo.jdField_a_of_type_JavaLangString) ^ true;
    }
    return true;
  }
  
  private boolean a(AIOPanelIconItem paramAIOPanelIconItem)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().c()) {
      return ChatPanelDisplayManager.a(paramAIOPanelIconItem);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().b()) {
      return ChatPanelDisplayManager.b(paramAIOPanelIconItem);
    }
    return ChatPanelDisplayManager.c(paramAIOPanelIconItem);
  }
  
  private boolean a(boolean paramBoolean)
  {
    return (!SimpleUIUtil.a()) || ((paramBoolean) && ("2920".equals(ThemeUtil.curThemeId)));
  }
  
  private void b(RedDotImageView paramRedDotImageView)
  {
    RedBagShowData localRedBagShowData = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a();
    if (!ShortVideoUtils.isPtvConfiginitied)
    {
      localRedBagShowData.a(ShortVideoUtils.getPtvRedDotStatus(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a().getCurrentUin()));
      ShortVideoUtils.isPtvConfiginitied = true;
    }
    if (localRedBagShowData.a())
    {
      paramRedDotImageView.setReddotXOffsetDp(15);
      paramRedDotImageView.setReddotYOffsetDp(11);
      paramRedDotImageView.setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850767));
      paramRedDotImageView.a(true);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), "dc00898", "", "", "0X8009366", "0X8009366", 1, 0, "", "", "", "");
      return;
    }
    paramRedDotImageView.a(false);
  }
  
  private void b(String paramString)
  {
    IMiniAppService localIMiniAppService = (IMiniAppService)QRoute.api(IMiniAppService.class);
    if ((!TextUtils.isEmpty(paramString)) && (localIMiniAppService.isMiniAppUrl(paramString))) {
      localIMiniAppService.startMiniApp(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), paramString, 2053, null);
    }
  }
  
  private boolean b(int paramInt)
  {
    return ((paramInt == 0) || (paramInt == 3000)) && (ScribbleResMgr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a().getCurrentAccountUin()));
  }
  
  private void c(List<AIOPanelIconItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d();
      int i = 0;
      while (i < paramList.size())
      {
        AIOPanelIconItem localAIOPanelIconItem = (AIOPanelIconItem)paramList.get(i);
        int[] arrayOfInt;
        if ((!bool) && (localAIOPanelIconItem != null) && (localAIOPanelIconItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          arrayOfInt = PlusPanelUtil.a(localAIOPanelIconItem.jdField_a_of_type_Int);
          if (arrayOfInt != null) {
            localAIOPanelIconItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(arrayOfInt[2]);
          }
        }
        if ((bool) && (localAIOPanelIconItem != null) && (localAIOPanelIconItem.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null))
        {
          arrayOfInt = PlusPanelUtil.a(localAIOPanelIconItem.jdField_a_of_type_Int);
          if (arrayOfInt != null) {
            localAIOPanelIconItem.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(arrayOfInt[2]);
          } else if (localAIOPanelIconItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            localAIOPanelIconItem.jdField_b_of_type_AndroidGraphicsDrawableDrawable = localAIOPanelIconItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          }
        }
        i += 1;
      }
    }
  }
  
  private void d(List<AIOPanelIconItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      int k = 0;
      int j;
      for (int i = 0; i < paramList.size(); i = j + 1)
      {
        localObject = (AIOPanelIconItem)paramList.get(i);
        if (!a(((AIOPanelIconItem)localObject).jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a()))
        {
          paramList.remove(i);
          j = i - 1;
        }
        else
        {
          localObject = a((AIOPanelIconItem)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getContext());
          j = i;
          if (localObject != null)
          {
            paramList.set(i, localObject);
            j = i;
          }
        }
      }
      Object localObject = new ArrayList();
      if (paramList.size() > 0)
      {
        i = k;
        while (i < paramList.size())
        {
          a((AIOPanelIconItem)paramList.get(i), (ArrayList)localObject, i);
          i += 1;
        }
      }
      if (((ArrayList)localObject).size() > 0) {
        try
        {
          QIMUserManager.a().a((ArrayList)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a());
          return;
        }
        catch (Throwable paramList)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("load data qim exception = ");
          ((StringBuilder)localObject).append(paramList);
          QLog.d("ChatPanelBarController", 1, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void e(List<AIOPanelIconItem> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarReporterIChatPanelReporter.a(paramList);
  }
  
  public List<int[]> a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider;
    if (localObject == null) {
      return;
    }
    localObject = (SimpleUIAIOHelper)((HelperProvider)localObject).a(29);
    if (localObject != null) {
      ((SimpleUIAIOHelper)localObject).f();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getVisibility() == 0) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.b()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.c())))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildCount() - 1;
      while (i >= 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildAt(i);
        if (((((View)localObject).getTag() instanceof Integer)) && (((Integer)((View)localObject).getTag()).intValue() == 8))
        {
          if (!(localObject instanceof RedTouch)) {
            break;
          }
          a((RedTouch)localObject);
          return;
        }
        i -= 1;
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildAt(i);
      if (((View)localObject).getTag().equals(Integer.valueOf(paramInt)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.c())
        {
          localObject = PlusPanelUtil.a(paramInt);
          if (localObject == null) {
            break;
          }
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), 4, String.valueOf(((AIOPanelIconItem)localObject).jdField_b_of_type_Int), ((AIOPanelIconItem)localObject).jdField_a_of_type_Int);
          return;
        }
        localObject = (RedDotImageView)localObject;
        ((RedDotImageView)localObject).setReddotXOffsetDp(15);
        ((RedDotImageView)localObject).setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850767));
        ((RedDotImageView)localObject).a(paramBoolean);
        return;
      }
      i += 1;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    a(paramBaseChatPie, null);
  }
  
  public void a(BaseChatPie paramBaseChatPie, UpdateParams paramUpdateParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(paramUpdateParams);
    paramUpdateParams = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a();
    ChatPanelBarModel localChatPanelBarModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel;
    paramBaseChatPie = localChatPanelBarModel.a(localChatPanelBarModel.a(), paramUpdateParams, paramBaseChatPie);
    ChatPanelDisplayManager.a();
    paramBaseChatPie = a(paramBaseChatPie);
    a(paramBaseChatPie, paramUpdateParams.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a());
    if (paramBaseChatPie.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(PanelIconLinearLayout.jdField_b_of_type_Int);
    }
    b(paramBaseChatPie);
  }
  
  public void a(HelperProvider paramHelperProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider = paramHelperProvider;
  }
  
  public void a(IChatPanelReporter paramIChatPanelReporter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarReporterIChatPanelReporter = paramIChatPanelReporter;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarReporterIChatPanelReporter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel = new ChatPanelBarModel();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext = new ChatPanelBarContext(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel);
    if (paramBaseChatPie != null)
    {
      AIOIconChangeByTimeHelper localAIOIconChangeByTimeHelper = (AIOIconChangeByTimeHelper)paramBaseChatPie.a(21);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(localAIOIconChangeByTimeHelper.a());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext, paramQQAppInterface, paramSessionInfo, paramBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getContext());
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    EmojiStickerManager.a().jdField_a_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
    ShortVideoUtils.sSupportShortVideo = ShortVideoUtils.canRecordShortVideo();
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int[] paramArrayOfInt, int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.d();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.b(paramQQAppInterface, paramSessionInfo, null).indexOf(paramArrayOfInt);
    int i = j;
    if (j < 0)
    {
      if (bool) {
        paramArrayOfInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(paramArrayOfInt);
      } else {
        paramArrayOfInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.b(paramArrayOfInt);
      }
      i = j;
      if (paramArrayOfInt != null) {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.b(paramQQAppInterface, paramSessionInfo, null).indexOf(paramArrayOfInt);
      }
    }
    if (i < 0)
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("updateIconNumbers error index =  ");
        paramQQAppInterface.append(i);
        QLog.d("ChatPanelBarController", 2, paramQQAppInterface.toString());
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("updateIconNumbers index =  ");
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(",num = ");
        paramQQAppInterface.append(paramInt);
        QLog.d("ChatPanelBarController", 2, paramQQAppInterface.toString());
      }
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildAt(i);
      if ((paramQQAppInterface instanceof RedDotImageView))
      {
        ((RedDotImageView)paramQQAppInterface).setUnreadNumber(paramInt);
        return;
      }
      if ((paramQQAppInterface instanceof RedTouch))
      {
        paramQQAppInterface = (RedTouch)paramQQAppInterface;
        if ((paramQQAppInterface.a() instanceof RedDotImageView)) {
          ((RedDotImageView)paramQQAppInterface.a()).setUnreadNumber(paramInt);
        }
      }
    }
  }
  
  public void a(List<int[]> paramList)
  {
    b(BaseChatPanelBarLoader.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().a(), paramList));
  }
  
  public void a(boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a();
    int j = 0;
    boolean bool3 = ThemeUtil.isNowThemeIsDefault((AppRuntime)localObject, false, null);
    boolean bool4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.c();
    boolean bool1;
    if ((paramBoolean) && (bool3)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.d() != bool1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatPanelBarController", 2, new Object[] { "[refreshIconByTime] needNight: ", Boolean.valueOf(bool1), ", isThemeDefault: ", Boolean.valueOf(bool3), ", isC2C: ", Boolean.valueOf(bool4), ", changed: ", Boolean.valueOf(bool2) });
    }
    if (!bool2) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(bool1);
    int i;
    if (localObject != null) {
      i = 1;
    } else {
      i = 0;
    }
    ChatPanelBarModel localChatPanelBarModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel;
    localObject = localChatPanelBarModel.b((QQAppInterface)localObject, localChatPanelBarModel.a(), paramBaseChatPie);
    if ((!bool4) && (bool3))
    {
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int m = ((List)localObject).size();
        int k = 0;
        while (j < m)
        {
          paramBaseChatPie = (int[])((List)localObject).get(j);
          if (paramBoolean) {
            paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(paramBaseChatPie);
          } else {
            paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.b(paramBaseChatPie);
          }
          if (paramBaseChatPie != null)
          {
            ((List)localObject).set(j, paramBaseChatPie);
            k = 1;
          }
          j += 1;
        }
        if ((k != 0) && (i != 0)) {
          a((List)localObject);
        }
      }
    }
    else if (i != 0) {
      a((List)localObject);
    }
  }
  
  public boolean a(View paramView)
  {
    Object localObject = paramView.getTag();
    a(paramView);
    paramView = (Integer)localObject;
    if (paramView.intValue() == 6)
    {
      ((IAELaunchRecorder)QRoute.api(IAELaunchRecorder.class)).beginSession();
      ((IAELaunchRecorder)QRoute.api(IAELaunchRecorder.class)).milestone("userClick");
    }
    localObject = PlusPanelUtil.a(paramView.intValue());
    if (localObject != null)
    {
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), 4, String.valueOf(((AIOPanelIconItem)localObject).jdField_b_of_type_Int), ((AIOPanelIconItem)localObject).jdField_a_of_type_Int);
    }
    else
    {
      paramView = PlusPanelUtil.a(paramView.intValue(), true);
      if (paramView != null)
      {
        if ("web".equals(paramView.jdField_a_of_type_JavaLangString))
        {
          a(paramView.jdField_b_of_type_JavaLangString);
          return true;
        }
        if ("miniapp".equals(paramView.jdField_a_of_type_JavaLangString))
        {
          b(paramView.jdField_b_of_type_JavaLangString);
          return true;
        }
      }
    }
    VideoReport.traverseExposure();
    return false;
  }
  
  public void b(List<AIOPanelIconItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatPanelBarController", 2, new Object[] { "[loadView] items: ", Integer.valueOf(paramList.size()) });
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.removeAllViews();
    c(paramList);
    d(paramList);
    e(paramList);
  }
  
  public void b(boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.clear();
      localArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
      int[] arrayOfInt;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.d()) {
        arrayOfInt = AIOPanelUtiles.p;
      } else {
        arrayOfInt = AIOPanelUtiles.l;
      }
      localArrayList.add(arrayOfInt);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.d()) {
        arrayOfInt = AIOPanelUtiles.i;
      } else {
        arrayOfInt = AIOPanelUtiles.e;
      }
      localArrayList.add(arrayOfInt);
    }
    if (localArrayList.size() > 0)
    {
      a(localArrayList);
      return;
    }
    a(paramBaseChatPie);
  }
  
  public boolean b(View paramView)
  {
    if (((Integer)paramView.getTag()).intValue() == 4)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider;
      if (paramView != null)
      {
        paramView = (PhotoListHelper)paramView.a(7);
        if (paramView != null)
        {
          paramView.a();
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarController
 * JD-Core Version:    0.7.0.1
 */