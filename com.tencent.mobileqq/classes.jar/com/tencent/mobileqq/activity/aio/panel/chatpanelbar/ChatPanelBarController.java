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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.mobileqq.pluspanel.PlusPanelUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.perf.AELaunchRecorder;
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
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a().getManager(QQManagerFactory.MGR_RED_TOUCH);
    if (paramInt == 8) {
      a(paramRedDotImageView);
    }
    do
    {
      return paramRedDotImageView;
      paramAIOPanelIconItem = localRedTouchManager.a(4, String.valueOf(paramAIOPanelIconItem.jdField_b_of_type_Int));
    } while (paramAIOPanelIconItem == null);
    paramRedDotImageView.a(paramAIOPanelIconItem);
    localRedTouchManager.b(paramAIOPanelIconItem, "");
    return paramRedDotImageView;
  }
  
  private List<AIOPanelIconItem> a(List<AIOPanelIconItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
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
    return localArrayList;
  }
  
  private void a(int paramInt, RedDotImageView paramRedDotImageView)
  {
    if (paramInt == 23)
    {
      if (ChatPanelBarBizUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), this.jdField_a_of_type_AndroidContentSharedPreferences))
      {
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850831));
        paramRedDotImageView.a(true);
      }
    }
    else
    {
      if (paramInt == 26)
      {
        if (!ChatPanelBarBizUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), this.jdField_a_of_type_AndroidContentSharedPreferences)) {
          break label247;
        }
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850831));
        paramRedDotImageView.a(true);
      }
      label112:
      if (paramInt == 3)
      {
        if (!ChatPanelBarBizUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a())) {
          break label255;
        }
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850831));
        paramRedDotImageView.a(true);
      }
      label163:
      if (paramInt != 2) {
        break label269;
      }
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a().getManager(QQManagerFactory.MGR_RED_TOUCH)).a("103100.103300");
      if ((localAppInfo == null) || (localAppInfo.iNewFlag.get() != 1)) {
        break label263;
      }
      paramRedDotImageView.setReddotXOffsetDp(15);
      paramRedDotImageView.setReddotYOffsetDp(11);
      paramRedDotImageView.setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850831));
      paramRedDotImageView.a(true);
    }
    label247:
    label255:
    do
    {
      return;
      paramRedDotImageView.a(false);
      break;
      paramRedDotImageView.a(false);
      break label112;
      paramRedDotImageView.a(false);
      break label163;
      paramRedDotImageView.a(false);
      return;
      if (paramInt == 6)
      {
        b(paramRedDotImageView);
        return;
      }
      if (paramInt == 10)
      {
        QWalletTools.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), paramRedDotImageView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a());
        return;
      }
      if (paramInt == 8)
      {
        if (b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a()))
        {
          paramRedDotImageView.setReddotXOffsetDp(15);
          paramRedDotImageView.setReddotYOffsetDp(11);
          paramRedDotImageView.setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850831));
          paramRedDotImageView.a(true);
          return;
        }
        paramRedDotImageView.a(false);
        return;
      }
    } while (paramInt != 24);
    label263:
    label269:
    a(paramRedDotImageView);
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
      QLog.e("PanelIconLinearLayout", 1, "PanelIconLinearLayout.onClick e=" + paramView.getMessage());
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
    if ((paramAIOPanelIconItem.jdField_a_of_type_ArrayOfInt != null) && (paramAIOPanelIconItem.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      if (ChatPanelBarBizUtil.a(paramAIOPanelIconItem, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a()))
      {
        QIMUserManager.QIMUserIcon localQIMUserIcon = new QIMUserManager.QIMUserIcon();
        localQIMUserIcon.jdField_a_of_type_Int = paramInt;
        localQIMUserIcon.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = localRedDotImageView;
        paramArrayList.add(localQIMUserIcon);
      }
    }
    else {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.d()) {
        break label265;
      }
    }
    label265:
    for (paramArrayList = paramAIOPanelIconItem.jdField_b_of_type_AndroidGraphicsDrawableDrawable;; paramArrayList = paramAIOPanelIconItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
    {
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
      if (!a(i)) {
        break label273;
      }
      paramAIOPanelIconItem = a(paramAIOPanelIconItem, i, localRedDotImageView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.addView(paramAIOPanelIconItem, (ViewGroup.LayoutParams)localObject);
      return;
      localRedDotImageView.setImageResource(paramAIOPanelIconItem.jdField_a_of_type_ArrayOfInt[2]);
      break;
    }
    label273:
    a(i, localRedDotImageView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.addView(localRedDotImageView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void a(RedTouch paramRedTouch)
  {
    RedTouchManager localRedTouchManager;
    int i;
    if (paramRedTouch != null)
    {
      localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a().getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.b()) {
        break label127;
      }
      i = 11;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a();
      if (localObject == null) {
        break label138;
      }
    }
    label133:
    label138:
    for (Object localObject = ((SessionInfo)localObject).jdField_b_of_type_JavaLangString;; localObject = null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider != null)
      {
        localObject = localRedTouchManager.a(i, (String)localObject, ((PlusRedPointHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(89)).a());
        paramRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
        if ((!this.jdField_a_of_type_Boolean) && (localObject != null)) {
          localRedTouchManager.b(i, 30);
        }
        if (localObject == null) {
          break label133;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        return;
        label127:
        i = 10;
        break;
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
      paramRedDotImageView.setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850831));
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
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData filterMode curType=" + paramInt);
    }
    if (a(paramBoolean)) {}
    while ((paramInt != 0) && (paramInt != 1) && (paramInt != 3000)) {
      return;
    }
    paramList.clear();
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
    return (10 != paramInt) || (paramSessionInfo == null) || (!Utils.b(paramSessionInfo.jdField_a_of_type_JavaLangString));
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
      paramRedDotImageView.setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850831));
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
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 3000) {}
    }
    else
    {
      bool1 = bool2;
      if (ScribbleResMgr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a().getCurrentAccountUin())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void c(List<AIOPanelIconItem> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().d();
    int i = 0;
    label29:
    AIOPanelIconItem localAIOPanelIconItem;
    if (i < paramList.size())
    {
      localAIOPanelIconItem = (AIOPanelIconItem)paramList.get(i);
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
        if (arrayOfInt == null) {
          break label160;
        }
        localAIOPanelIconItem.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(arrayOfInt[2]);
      }
    }
    for (;;)
    {
      i += 1;
      break label29;
      break;
      label160:
      if (localAIOPanelIconItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        localAIOPanelIconItem.jdField_b_of_type_AndroidGraphicsDrawableDrawable = localAIOPanelIconItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
    }
  }
  
  private void d(List<AIOPanelIconItem> paramList)
  {
    int k = 0;
    if ((paramList == null) || (paramList.size() == 0)) {}
    Object localObject;
    do
    {
      return;
      int i = 0;
      if (i < paramList.size())
      {
        localObject = (AIOPanelIconItem)paramList.get(i);
        int j;
        if (!a(((AIOPanelIconItem)localObject).jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a()))
        {
          paramList.remove(i);
          j = i - 1;
        }
        for (;;)
        {
          i = j + 1;
          break;
          localObject = a((AIOPanelIconItem)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getContext());
          j = i;
          if (localObject != null)
          {
            paramList.set(i, localObject);
            j = i;
          }
        }
      }
      localObject = new ArrayList();
      if (paramList.size() > 0)
      {
        i = k;
        while (i < paramList.size())
        {
          a((AIOPanelIconItem)paramList.get(i), (ArrayList)localObject, i);
          i += 1;
        }
      }
    } while (((ArrayList)localObject).size() <= 0);
    try
    {
      QIMUserManager.a().a((ArrayList)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a());
      return;
    }
    catch (Throwable paramList)
    {
      QLog.d("ChatPanelBarController", 1, "load data qim exception = " + paramList);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider == null) {}
    label128:
    for (;;)
    {
      return;
      Object localObject = (SimpleUIAIOHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(29);
      if (localObject != null) {
        ((SimpleUIAIOHelper)localObject).f();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getVisibility() == 0) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.b()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.c())))
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildCount() - 1;
        for (;;)
        {
          if (i < 0) {
            break label128;
          }
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
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i < this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildCount())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildAt(i);
        if (!((View)localObject).getTag().equals(Integer.valueOf(paramInt))) {
          break label131;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.c()) {
          break label91;
        }
        localObject = PlusPanelUtil.a(paramInt);
        if (localObject != null) {
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), 4, String.valueOf(((AIOPanelIconItem)localObject).jdField_b_of_type_Int), ((AIOPanelIconItem)localObject).jdField_a_of_type_Int);
        }
      }
      return;
      label91:
      ((RedDotImageView)localObject).setReddotXOffsetDp(15);
      ((RedDotImageView)localObject).setRedDotDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getResources().getDrawable(2130850831));
      ((RedDotImageView)localObject).a(paramBoolean);
      return;
      label131:
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
    paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), paramUpdateParams, paramBaseChatPie);
    ChatPanelDisplayManager.a();
    paramBaseChatPie = a(paramBaseChatPie);
    a(paramBaseChatPie, paramUpdateParams.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a());
    if (paramBaseChatPie.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
    }
    for (;;)
    {
      b(paramBaseChatPie);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(PanelIconLinearLayout.jdField_b_of_type_Int);
    }
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
      if (!bool) {
        break label116;
      }
      paramArrayOfInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(paramArrayOfInt);
      i = j;
      if (paramArrayOfInt != null) {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.b(paramQQAppInterface, paramSessionInfo, null).indexOf(paramArrayOfInt);
      }
    }
    if (i < 0) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatPanelBarController", 2, "updateIconNumbers error index =  " + i);
      }
    }
    label116:
    do
    {
      return;
      paramArrayOfInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.b(paramArrayOfInt);
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ChatPanelBarController", 2, "updateIconNumbers index =  " + i + ",num = " + paramInt);
      }
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildAt(i);
      if ((paramQQAppInterface instanceof RedDotImageView))
      {
        ((RedDotImageView)paramQQAppInterface).setUnreadNumber(paramInt);
        return;
      }
    } while ((!(paramQQAppInterface instanceof RedTouch)) || (!(((RedTouch)paramQQAppInterface).a() instanceof RedDotImageView)));
    ((RedDotImageView)((RedTouch)paramQQAppInterface).a()).setUnreadNumber(paramInt);
  }
  
  public void a(List<int[]> paramList)
  {
    b(BaseChatPanelBarLoader.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext.a().a(), paramList));
  }
  
  public void a(boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    int i = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a();
    boolean bool3 = ThemeUtil.isNowThemeIsDefault((AppRuntime)localObject, false, null);
    boolean bool4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.c();
    boolean bool1;
    if ((paramBoolean) && (bool3))
    {
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.d() == bool1) {
        break label325;
      }
    }
    label161:
    label310:
    label322:
    label325:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatPanelBarController", 2, new Object[] { "[refreshIconByTime] needNight: ", Boolean.valueOf(bool1), ", isThemeDefault: ", Boolean.valueOf(bool3), ", isC2C: ", Boolean.valueOf(bool4), ", changed: ", Boolean.valueOf(bool2) });
      }
      if (!bool2) {}
      int j;
      do
      {
        return;
        bool1 = false;
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(bool1);
        if (localObject == null) {
          break label276;
        }
        j = 1;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.b((QQAppInterface)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), paramBaseChatPie);
        if ((bool4) || (!bool3)) {
          break label310;
        }
      } while ((localObject == null) || (((List)localObject).size() <= 0));
      int m = ((List)localObject).size();
      int k = 0;
      label217:
      if (k < m)
      {
        paramBaseChatPie = (int[])((List)localObject).get(k);
        if (paramBoolean)
        {
          paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(paramBaseChatPie);
          label250:
          if (paramBaseChatPie == null) {
            break label322;
          }
          ((List)localObject).set(k, paramBaseChatPie);
          i = 1;
        }
      }
      for (;;)
      {
        k += 1;
        break label217;
        j = 0;
        break label161;
        paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.b(paramBaseChatPie);
        break label250;
        if ((i == 0) || (j == 0)) {
          break;
        }
        a((List)localObject);
        return;
        if (j == 0) {
          break;
        }
        a((List)localObject);
        return;
      }
    }
  }
  
  public boolean a(View paramView)
  {
    Object localObject = paramView.getTag();
    a(paramView);
    if (((Integer)localObject).intValue() == 6)
    {
      AELaunchRecorder.a().d();
      AELaunchRecorder.a().a("userClick");
    }
    paramView = PlusPanelUtil.a(((Integer)localObject).intValue());
    if (paramView != null) {
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.a(), 4, String.valueOf(paramView.jdField_b_of_type_Int), paramView.jdField_a_of_type_Int);
    }
    do
    {
      do
      {
        return false;
        paramView = PlusPanelUtil.a(((Integer)localObject).intValue(), true);
      } while (paramView == null);
      if ("web".equals(paramView.jdField_a_of_type_JavaLangString))
      {
        a(paramView.jdField_b_of_type_JavaLangString);
        return true;
      }
    } while (!"miniapp".equals(paramView.jdField_a_of_type_JavaLangString));
    b(paramView.jdField_b_of_type_JavaLangString);
    return true;
  }
  
  public void b(List<AIOPanelIconItem> paramList)
  {
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
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.d()) {
        break label94;
      }
      arrayOfInt = AIOPanelUtiles.p;
      localArrayList.add(arrayOfInt);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarModel.d()) {
        break label101;
      }
    }
    label94:
    label101:
    for (int[] arrayOfInt = AIOPanelUtiles.i;; arrayOfInt = AIOPanelUtiles.e)
    {
      localArrayList.add(arrayOfInt);
      if (localArrayList.size() <= 0) {
        break label108;
      }
      a(localArrayList);
      return;
      arrayOfInt = AIOPanelUtiles.l;
      break;
    }
    label108:
    a(paramBaseChatPie);
  }
  
  public boolean b(View paramView)
  {
    switch (((Integer)paramView.getTag()).intValue())
    {
    }
    do
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider == null);
      paramView = (PhotoListHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(7);
    } while (paramView == null);
    paramView.a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarController
 * JD-Core Version:    0.7.0.1
 */