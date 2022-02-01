package com.tencent.mobileqq.activity.aio.panel.chatpanelbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
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
  ChatPanelBarModel a;
  private PanelIconLinearLayout b;
  private ChatPanelBarContext c;
  private HelperProvider d;
  private IChatPanelReporter e;
  private boolean f = false;
  private SharedPreferences g;
  
  public ChatPanelBarController(PanelIconLinearLayout paramPanelIconLinearLayout)
  {
    this.b = paramPanelIconLinearLayout;
  }
  
  private AIOPanelIconItem a(AIOPanelIconItem paramAIOPanelIconItem, SessionInfo paramSessionInfo, Context paramContext)
  {
    if ((8 == paramAIOPanelIconItem.g) && (paramSessionInfo != null) && (Utils.c(paramSessionInfo.b)))
    {
      paramSessionInfo = new AIOPanelIconItem(paramAIOPanelIconItem);
      paramSessionInfo.m = paramContext.getResources().getDrawable(AIOPanelUtiles.U[2]);
      paramSessionInfo.n = paramAIOPanelIconItem.m;
      paramSessionInfo.g = AIOPanelUtiles.U[0];
      paramSessionInfo.o = AIOPanelUtiles.U[3];
      paramSessionInfo.h = paramContext.getResources().getString(AIOPanelUtiles.U[1]);
      return paramSessionInfo;
    }
    return null;
  }
  
  @NotNull
  private RedTouch a(AIOPanelIconItem paramAIOPanelIconItem, int paramInt, RedDotImageView paramRedDotImageView)
  {
    paramRedDotImageView = new RedTouch(this.b.getContext(), paramRedDotImageView).c(53).b(15.0F).c(0.0F).a(true).a();
    paramRedDotImageView.setTag(Integer.valueOf(paramInt));
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.a.e().getRuntimeService(IRedTouchManager.class, "");
    if (paramInt == 8)
    {
      a(paramRedDotImageView);
      return paramRedDotImageView;
    }
    paramAIOPanelIconItem = localIRedTouchManager.getAppInfo(4, String.valueOf(paramAIOPanelIconItem.b));
    if (paramAIOPanelIconItem != null)
    {
      paramRedDotImageView.a(paramAIOPanelIconItem);
      localIRedTouchManager.onRedTouchItemExposure(paramAIOPanelIconItem, "");
    }
    return paramRedDotImageView;
  }
  
  private void a(int paramInt, RedDotImageView paramRedDotImageView)
  {
    if (paramInt == 23) {
      if (ChatPanelBarBizUtil.b(this.a.e(), this.g))
      {
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(this.b.getResources().getDrawable(2130852589));
        paramRedDotImageView.a(true);
      }
      else
      {
        paramRedDotImageView.a(false);
      }
    }
    if (paramInt == 26) {
      if (ChatPanelBarBizUtil.a(this.a.e(), this.g))
      {
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(this.b.getResources().getDrawable(2130852589));
        paramRedDotImageView.a(true);
      }
      else
      {
        paramRedDotImageView.a(false);
      }
    }
    Object localObject;
    if (paramInt == 3)
    {
      boolean bool2 = ChatPanelBarBizUtil.a(this.a.e());
      localObject = this.a.h();
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((SessionInfo)localObject).a == 10007) {
          bool1 = false;
        }
      }
      if (bool1)
      {
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(this.b.getResources().getDrawable(2130852589));
        paramRedDotImageView.a(true);
      }
      else
      {
        paramRedDotImageView.a(false);
      }
    }
    if (paramInt == 2)
    {
      localObject = ((IRedTouchManager)this.a.e().getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("103100.103300");
      if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1))
      {
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(this.b.getResources().getDrawable(2130852589));
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
      ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).showAIOHongBaoRedPoint(paramRedDotImageView, this.a.g());
      return;
    }
    if (paramInt == 8)
    {
      if (b(this.a.g()))
      {
        paramRedDotImageView.setReddotXOffsetDp(15);
        paramRedDotImageView.setReddotYOffsetDp(11);
        paramRedDotImageView.setRedDotDrawable(this.b.getResources().getDrawable(2130852589));
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
  
  private void a(AIOPanelIconItem paramAIOPanelIconItem, int paramInt)
  {
    int i = paramAIOPanelIconItem.g;
    Object localObject = this.b.getContext();
    RedDotImageView localRedDotImageView = new RedDotImageView((Context)localObject);
    localRedDotImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localRedDotImageView.setShowBorder(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, DisplayUtil.a((Context)localObject, 28.0F));
    localLayoutParams.weight = 1.0F;
    localLayoutParams.gravity = 16;
    localRedDotImageView.setTag(Integer.valueOf(i));
    if ((paramAIOPanelIconItem.p != null) && (paramAIOPanelIconItem.p.length > 0)) {
      if (ChatPanelBarBizUtil.a(paramAIOPanelIconItem, this.a.h()))
      {
        localObject = new QIMUserManager.QIMUserIcon();
        ((QIMUserManager.QIMUserIcon)localObject).b = paramInt;
        ((QIMUserManager.QIMUserIcon)localObject).a = localRedDotImageView;
      }
      else
      {
        localRedDotImageView.setImageResource(paramAIOPanelIconItem.p[2]);
      }
    }
    if (this.a.i()) {
      localObject = paramAIOPanelIconItem.n;
    } else {
      localObject = paramAIOPanelIconItem.m;
    }
    localRedDotImageView.setImageDrawable((Drawable)localObject);
    if (AppSetting.e) {
      localRedDotImageView.setContentDescription(paramAIOPanelIconItem.h);
    }
    if (paramAIOPanelIconItem.o > 0) {
      localRedDotImageView.setId(paramAIOPanelIconItem.o);
    }
    localRedDotImageView.setLongClickable(true);
    localRedDotImageView.setOnLongClickListener(this.b);
    localRedDotImageView.setOnClickListener(this.b);
    localRedDotImageView.setSelected(false);
    if (a(i))
    {
      paramAIOPanelIconItem = a(paramAIOPanelIconItem, i, localRedDotImageView);
      this.b.addView(paramAIOPanelIconItem, localLayoutParams);
      return;
    }
    a(i, localRedDotImageView);
    this.b.addView(localRedDotImageView, localLayoutParams);
  }
  
  private void a(RedTouch paramRedTouch)
  {
    if (paramRedTouch != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.a.e().getRuntimeService(IRedTouchManager.class, "");
      int i;
      if (this.a.c()) {
        i = 11;
      } else {
        i = 10;
      }
      Object localObject1 = null;
      Object localObject2 = this.a.h();
      if (localObject2 != null) {
        localObject1 = ((SessionInfo)localObject2).c;
      }
      localObject2 = this.d;
      if (localObject2 != null)
      {
        localObject1 = localIRedTouchManager.getRedTouchInfoByAppSet(i, (String)localObject1, ((PlusRedPointHelper)((HelperProvider)localObject2).a(89)).a());
        paramRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
        if ((!this.f) && (localObject1 != null)) {
          localIRedTouchManager.reportLevelZeroRedInfo(i, 30);
        }
        boolean bool;
        if (localObject1 != null) {
          bool = true;
        } else {
          bool = false;
        }
        this.f = bool;
      }
    }
  }
  
  private void a(RedDotImageView paramRedDotImageView)
  {
    RedBagShowData localRedBagShowData = this.a.f();
    if (!ShortVideoUtils.isHotPicConfiginitied)
    {
      localRedBagShowData.b(ShortVideoUtils.getHotPicRedDotStatus(this.a.e().getCurrentUin()));
      ShortVideoUtils.isHotPicConfiginitied = true;
    }
    if (localRedBagShowData.b())
    {
      paramRedDotImageView.setReddotXOffsetDp(15);
      paramRedDotImageView.setReddotYOffsetDp(11);
      paramRedDotImageView.setRedDotDrawable(this.b.getResources().getDrawable(2130852589));
      paramRedDotImageView.a(true);
      ReportController.b(this.a.e(), "dc00898", "", "", "0X8009366", "0X8009366", 2, 0, "", "", "", "");
      return;
    }
    paramRedDotImageView.a(false);
  }
  
  private void a(String paramString)
  {
    if (((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http://"))) || (paramString.startsWith("https://")))
    {
      Intent localIntent = new Intent(this.a.j(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      this.a.j().startActivity(localIntent);
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
    return this.a.d();
  }
  
  private boolean a(int paramInt, SessionInfo paramSessionInfo)
  {
    if ((10 == paramInt) && (paramSessionInfo != null)) {
      return Utils.c(paramSessionInfo.b) ^ true;
    }
    return true;
  }
  
  private boolean a(AIOPanelIconItem paramAIOPanelIconItem)
  {
    if (this.c.a().d()) {
      return ChatPanelDisplayManager.a(paramAIOPanelIconItem);
    }
    if (this.c.a().c()) {
      return ChatPanelDisplayManager.b(paramAIOPanelIconItem);
    }
    return ChatPanelDisplayManager.c(paramAIOPanelIconItem);
  }
  
  private boolean a(boolean paramBoolean)
  {
    return (!SimpleUIUtil.e()) || ((paramBoolean) && ("2920".equals(ThemeUtil.curThemeId)));
  }
  
  private void b(RedDotImageView paramRedDotImageView)
  {
    RedBagShowData localRedBagShowData = this.a.f();
    if (!ShortVideoUtils.isPtvConfiginitied)
    {
      localRedBagShowData.a(ShortVideoUtils.getPtvRedDotStatus(this.a.e().getCurrentUin()));
      ShortVideoUtils.isPtvConfiginitied = true;
    }
    if (localRedBagShowData.a())
    {
      paramRedDotImageView.setReddotXOffsetDp(15);
      paramRedDotImageView.setReddotYOffsetDp(11);
      paramRedDotImageView.setRedDotDrawable(this.b.getResources().getDrawable(2130852589));
      paramRedDotImageView.a(true);
      ReportController.b(this.a.e(), "dc00898", "", "", "0X8009366", "0X8009366", 1, 0, "", "", "", "");
      return;
    }
    paramRedDotImageView.a(false);
  }
  
  private void b(String paramString)
  {
    IMiniAppService localIMiniAppService = (IMiniAppService)QRoute.api(IMiniAppService.class);
    if ((!TextUtils.isEmpty(paramString)) && (localIMiniAppService.isMiniAppUrl(paramString))) {
      localIMiniAppService.startMiniApp(this.a.j(), paramString, 2053, null);
    }
  }
  
  private boolean b(int paramInt)
  {
    return ((paramInt == 0) || (paramInt == 3000)) && (ScribbleResMgr.c(this.b.getContext(), this.a.e().getCurrentAccountUin()));
  }
  
  private List<AIOPanelIconItem> c(List<AIOPanelIconItem> paramList)
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
  
  private void c(View paramView)
  {
    try
    {
      int i = ((Integer)paramView.getTag()).intValue();
      if (this.e.a(paramView)) {
        return;
      }
      if (i == 8)
      {
        if (b(this.a.g()))
        {
          ScribbleResMgr.d(this.a.j(), this.a.e().getCurrentAccountUin());
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
  
  private void d(List<AIOPanelIconItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      boolean bool = this.c.a().i();
      int i = 0;
      while (i < paramList.size())
      {
        AIOPanelIconItem localAIOPanelIconItem = (AIOPanelIconItem)paramList.get(i);
        int[] arrayOfInt;
        if ((!bool) && (localAIOPanelIconItem != null) && (localAIOPanelIconItem.m == null))
        {
          arrayOfInt = PlusPanelUtil.a(localAIOPanelIconItem.a);
          if (arrayOfInt != null) {
            localAIOPanelIconItem.m = this.b.getResources().getDrawable(arrayOfInt[2]);
          }
        }
        if ((bool) && (localAIOPanelIconItem != null) && (localAIOPanelIconItem.n == null))
        {
          arrayOfInt = PlusPanelUtil.a(localAIOPanelIconItem.a);
          if (arrayOfInt != null) {
            localAIOPanelIconItem.n = this.b.getResources().getDrawable(arrayOfInt[2]);
          } else if (localAIOPanelIconItem.m != null) {
            localAIOPanelIconItem.n = localAIOPanelIconItem.m;
          }
        }
        i += 1;
      }
    }
  }
  
  private void e(List<AIOPanelIconItem> paramList)
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
        AIOPanelIconItem localAIOPanelIconItem = (AIOPanelIconItem)paramList.get(i);
        if (!a(localAIOPanelIconItem.g, this.a.h()))
        {
          paramList.remove(i);
          j = i - 1;
        }
        else
        {
          localAIOPanelIconItem = a(localAIOPanelIconItem, this.a.h(), this.b.getContext());
          j = i;
          if (localAIOPanelIconItem != null)
          {
            paramList.set(i, localAIOPanelIconItem);
            j = i;
          }
        }
      }
      if (paramList.size() > 0)
      {
        i = k;
        while (i < paramList.size())
        {
          a((AIOPanelIconItem)paramList.get(i), i);
          i += 1;
        }
      }
    }
  }
  
  private void f(List<AIOPanelIconItem> paramList)
  {
    this.e.a(paramList);
  }
  
  public void a()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    localObject = (SimpleUIAIOHelper)((HelperProvider)localObject).a(29);
    if (localObject != null) {
      ((SimpleUIAIOHelper)localObject).m();
    }
    if ((this.b.getVisibility() == 0) && ((this.a.c()) || (this.a.d())))
    {
      int i = this.b.getChildCount() - 1;
      while (i >= 0)
      {
        localObject = this.b.getChildAt(i);
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
    while (i < this.b.getChildCount())
    {
      Object localObject = this.b.getChildAt(i);
      if (((View)localObject).getTag().equals(Integer.valueOf(paramInt)))
      {
        if (this.a.d())
        {
          localObject = PlusPanelUtil.b(paramInt);
          if (localObject == null) {
            break;
          }
          AIOPanelUtiles.a(this.a.e(), this.a.h(), 4, String.valueOf(((AIOPanelIconItem)localObject).b), ((AIOPanelIconItem)localObject).a);
          return;
        }
        localObject = (RedDotImageView)localObject;
        ((RedDotImageView)localObject).setReddotXOffsetDp(15);
        ((RedDotImageView)localObject).setRedDotDrawable(this.b.getResources().getDrawable(2130852589));
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
    this.a.a(paramUpdateParams);
    paramUpdateParams = this.a.h();
    ChatPanelBarModel localChatPanelBarModel = this.a;
    paramBaseChatPie = localChatPanelBarModel.a(localChatPanelBarModel.e(), paramUpdateParams, paramBaseChatPie);
    ChatPanelDisplayManager.a();
    paramBaseChatPie = c(paramBaseChatPie);
    a(paramBaseChatPie, paramUpdateParams.a, this.a.a());
    if (paramBaseChatPie.size() == 0) {
      this.b.setCustomHeight(0);
    } else {
      this.b.setCustomHeight(PanelIconLinearLayout.b);
    }
    b(paramBaseChatPie);
  }
  
  public void a(HelperProvider paramHelperProvider)
  {
    this.d = paramHelperProvider;
  }
  
  public void a(IChatPanelReporter paramIChatPanelReporter)
  {
    this.e = paramIChatPanelReporter;
    this.e.a(this.a);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.a = new ChatPanelBarModel();
    this.c = new ChatPanelBarContext(this.a);
    if (paramBaseChatPie != null)
    {
      AIOIconChangeByTimeHelper localAIOIconChangeByTimeHelper = (AIOIconChangeByTimeHelper)paramBaseChatPie.q(21);
      this.a.a(localAIOIconChangeByTimeHelper.a());
    }
    this.a.a(this.c, paramQQAppInterface, paramSessionInfo, paramBaseChatPie, this.b.getContext());
    this.g = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    EmojiStickerManager.a().h = paramSessionInfo.a;
    ShortVideoUtils.sSupportShortVideo = ShortVideoUtils.canRecordShortVideo();
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int[] paramArrayOfInt, int paramInt)
  {
    boolean bool = this.a.i();
    int j = this.a.b(paramQQAppInterface, paramSessionInfo, null).indexOf(paramArrayOfInt);
    int i = j;
    if (j < 0)
    {
      if (bool) {
        paramArrayOfInt = this.a.a(paramArrayOfInt);
      } else {
        paramArrayOfInt = this.a.b(paramArrayOfInt);
      }
      i = j;
      if (paramArrayOfInt != null) {
        i = this.a.b(paramQQAppInterface, paramSessionInfo, null).indexOf(paramArrayOfInt);
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
      paramQQAppInterface = this.b.getChildAt(i);
      if ((paramQQAppInterface instanceof RedDotImageView))
      {
        ((RedDotImageView)paramQQAppInterface).setUnreadNumber(paramInt);
        return;
      }
      if ((paramQQAppInterface instanceof RedTouch))
      {
        paramQQAppInterface = (RedTouch)paramQQAppInterface;
        if ((paramQQAppInterface.getTarget() instanceof RedDotImageView)) {
          ((RedDotImageView)paramQQAppInterface.getTarget()).setUnreadNumber(paramInt);
        }
      }
    }
  }
  
  public void a(List<int[]> paramList)
  {
    b(BaseChatPanelBarLoader.a(this.c.a().j(), paramList));
  }
  
  public void a(boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    Object localObject = this.a.e();
    int j = 0;
    boolean bool3 = ThemeUtil.isNowThemeIsDefault((AppRuntime)localObject, false, null);
    boolean bool4 = this.a.d();
    boolean bool1;
    if ((paramBoolean) && (bool3)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (this.a.i() != bool1) {
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
    this.a.a(bool1);
    int i;
    if (localObject != null) {
      i = 1;
    } else {
      i = 0;
    }
    ChatPanelBarModel localChatPanelBarModel = this.a;
    localObject = localChatPanelBarModel.b((QQAppInterface)localObject, localChatPanelBarModel.h(), paramBaseChatPie);
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
            paramBaseChatPie = this.a.a(paramBaseChatPie);
          } else {
            paramBaseChatPie = this.a.b(paramBaseChatPie);
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
    c(paramView);
    paramView = (Integer)localObject;
    if (paramView.intValue() == 6)
    {
      ((IAELaunchRecorder)QRoute.api(IAELaunchRecorder.class)).beginSession();
      ((IAELaunchRecorder)QRoute.api(IAELaunchRecorder.class)).milestone("userClick");
    }
    localObject = PlusPanelUtil.b(paramView.intValue());
    if (localObject != null)
    {
      AIOPanelUtiles.a(this.a.e(), this.a.h(), 4, String.valueOf(((AIOPanelIconItem)localObject).b), ((AIOPanelIconItem)localObject).a);
    }
    else
    {
      paramView = PlusPanelUtil.a(paramView.intValue(), true);
      if (paramView != null)
      {
        if ("web".equals(paramView.c))
        {
          a(paramView.d);
          return true;
        }
        if ("miniapp".equals(paramView.c))
        {
          b(paramView.d);
          return true;
        }
      }
    }
    VideoReport.traverseExposure();
    return false;
  }
  
  public List<int[]> b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return this.a.b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  public void b(List<AIOPanelIconItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatPanelBarController", 2, new Object[] { "[loadView] items: ", Integer.valueOf(paramList.size()) });
    }
    this.b.removeAllViews();
    d(paramList);
    e(paramList);
    f(paramList);
  }
  
  public void b(boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.clear();
      localArrayList.add(AIOPanelUtiles.b);
      int[] arrayOfInt;
      if (this.a.i()) {
        arrayOfInt = AIOPanelUtiles.q;
      } else {
        arrayOfInt = AIOPanelUtiles.m;
      }
      localArrayList.add(arrayOfInt);
      if (this.a.i()) {
        arrayOfInt = AIOPanelUtiles.j;
      } else {
        arrayOfInt = AIOPanelUtiles.f;
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
      paramView = this.d;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarController
 * JD-Core Version:    0.7.0.1
 */