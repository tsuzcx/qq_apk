package com.tencent.mobileqq.activity.aio.rebuild;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.imcore.message.ConversationProxy;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder;
import com.tencent.mobileqq.activity.aio.helper.GameMsgHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.GameMsgSayHiHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.tips.GameMsgTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.store.openbox.RoundRectLinearLayout;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.emoticonview.api.impl.AIOPanelInteractionListener;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgSayHelloRulesApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.data.GameMsgGrayTipsHandler;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.sso.GameCenterUnissoObserver;
import com.tencent.mobileqq.gamecenter.util.RoleIdUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class GameMsgChatPie
  extends StrangerChatPie
{
  public static String bi;
  private int bA = 0;
  private GameMsgTipsBar bB;
  private int bC;
  private boolean bD = false;
  private GameMsgChatPie.StrangerRecomInfo bE;
  private String bF;
  private String bG;
  private IGameMsgSayHelloRulesApi bH;
  private Dialog bI;
  private PopupWindow bJ;
  private int bK;
  private GameCenterUnissoObserver bL = new GameMsgChatPie.1(this, hashCode());
  private boolean bM = true;
  private View.OnClickListener bN = new GameMsgChatPie.6(this);
  private View.OnClickListener bO = new GameMsgChatPie.7(this);
  protected MessageObserver bj = new GameMsgChatPie.8(this);
  private IGameMsgManagerService bm = null;
  private GameDetailInfo bn;
  private GameDetailInfo bo;
  private GameMsgChatPie.GameUsrAvatarClickLis bp;
  private GameMsgChatPie.GameUsrAvatarClickLis bq;
  private QQCustomDialog br;
  private String bs;
  private String bt;
  private int bu;
  private List<GameMsgChatPie.GamePriorityInfo> bv = new ArrayList();
  private Dialog bw;
  private boolean bx;
  private boolean by;
  private boolean bz = false;
  
  public GameMsgChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramString1.hashCode())
    {
    default: 
      break;
    case 677978945: 
      if (paramString1.equals("1106838536")) {
        i = 3;
      }
      break;
    case 566198426: 
      if (paramString1.equals("1106467070")) {
        i = 4;
      }
      break;
    case 449633718: 
      if (paramString1.equals("1106040804")) {
        i = 0;
      }
      break;
    case -349185747: 
      if (paramString1.equals("1105371489")) {
        i = 2;
      }
      break;
    case -957280425: 
      if (paramString1.equals("1109807272")) {
        i = 1;
      }
      break;
    case -1208831194: 
      if (paramString1.equals("1104466820")) {
        i = 6;
      }
      break;
    case -1263386105: 
      if (paramString1.equals("1104294055")) {
        i = 5;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      break;
    case 6: 
      localStringBuilder.append("王者荣耀");
      break;
    case 5: 
      localStringBuilder.append("地下城与勇士");
      break;
    case 4: 
      localStringBuilder.append("和平精英");
      break;
    case 3: 
      localStringBuilder.append("使命召唤");
      break;
    case 2: 
      localStringBuilder.append("乱世王者");
      break;
    case 1: 
      localStringBuilder.append("梦想新大陆");
      break;
    case 0: 
      localStringBuilder.append("英雄联盟手游");
    }
    paramString1 = new StringBuilder();
    paramString1.append(localStringBuilder);
    paramString1.append(paramString2);
    return paramString1.toString();
  }
  
  private void a(GameMsgChatPie.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo == null)
    {
      QLog.i("GameCenterMsg.GameMsgChatPie", 1, "[doOnButtonClick] buttonInfo is null.");
      return;
    }
    if (paramButtonInfo.c == 1)
    {
      paramButtonInfo = paramButtonInfo.a;
      Intent localIntent = new Intent(aX(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramButtonInfo);
      aX().startActivity(localIntent);
    }
    else if ((paramButtonInfo.c == 3) && (this.f != null))
    {
      this.f.doOnBackPressed();
    }
    paramButtonInfo = this.br;
    if ((paramButtonInfo != null) && (paramButtonInfo.isShowing())) {
      this.br.dismiss();
    }
  }
  
  private void a(GameDetailInfo paramGameDetailInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterMsg.GameMsgChatPie", 2, "[setTitleInfo]");
    }
    if (paramGameDetailInfo != null) {}
    try
    {
      if (this.bE != null)
      {
        paramGameDetailInfo.a();
        if (!TextUtils.isEmpty(paramGameDetailInfo.g))
        {
          this.H.setVisibility(0);
          localObject1 = (LinearLayout.LayoutParams)this.H.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
          ((LinearLayout.LayoutParams)localObject1).width = AIOUtils.b(18.0F, BaseApplication.getContext().getResources());
          ((LinearLayout.LayoutParams)localObject1).height = AIOUtils.b(18.0F, BaseApplication.getContext().getResources());
          localObject1 = URLDrawable.getDrawable(paramGameDetailInfo.g);
          this.H.setImageDrawable((Drawable)localObject1);
        }
        Object localObject2;
        if (1 == this.bE.a)
        {
          localObject1 = new StringBuilder(100);
          ((StringBuilder)localObject1).append(paramGameDetailInfo.e);
          localObject2 = ContactUtils.f(this.d, this.bE.d);
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(((String)localObject2).trim()))) {
            ((StringBuilder)localObject1).append("(");
          }
          ((StringBuilder)localObject1).append((String)localObject2);
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(((String)localObject2).trim()))) {
            ((StringBuilder)localObject1).append(")");
          }
          this.C.setText(((StringBuilder)localObject1).toString());
        }
        else if ((2 == this.bE.a) || (this.bE.a == 0))
        {
          if (!TextUtils.isEmpty(paramGameDetailInfo.e)) {
            this.C.setText(paramGameDetailInfo.e);
          } else {
            this.C.setText(HardCodeUtil.a(2131889891));
          }
        }
        localObject1 = paramGameDetailInfo.b();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          b(true);
          localObject2 = this.i.b().getResources().getDrawable(2130838755);
          int i = ViewUtils.dip2px(9.0F);
          ((Drawable)localObject2).setBounds(0, 0, i, i);
          Drawable[] arrayOfDrawable = this.I.getCompoundDrawables();
          this.I.setCompoundDrawables(arrayOfDrawable[0], arrayOfDrawable[1], (Drawable)localObject2, arrayOfDrawable[3]);
          this.I.setText((CharSequence)localObject1);
          this.I.setOnClickListener(this);
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(paramGameDetailInfo.c, "1", "145", "920", "92005", "208983", "", "", "8", String.valueOf(paramGameDetailInfo.j));
        }
        this.q.setOnClickListener(this);
        this.z.setVisibility(0);
        if (TextUtils.isEmpty(paramGameDetailInfo.l)) {
          break label599;
        }
        paramGameDetailInfo = URLDrawable.getDrawable(paramGameDetailInfo.l);
        this.A.setImageDrawable(paramGameDetailInfo);
        this.A.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.A.setContentDescription("");
        this.A.setVisibility(0);
        this.A.setOnClickListener(this);
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("detail or strangerRecom info is null. detail:");
      ((StringBuilder)localObject1).append(paramGameDetailInfo);
      ((StringBuilder)localObject1).append(",strangerRecom:");
      ((StringBuilder)localObject1).append(this.bE);
      QLog.w("GameCenterMsg.GameMsgChatPie", 1, ((StringBuilder)localObject1).toString());
      this.z.setVisibility(4);
      this.C.setText(HardCodeUtil.a(2131889891));
      return;
    }
    catch (Throwable paramGameDetailInfo)
    {
      label589:
      label599:
      break label589;
    }
    QLog.e("GameCenterMsg.GameMsgChatPie", 1, paramGameDetailInfo.getMessage());
  }
  
  private void a(String paramString1, String paramString2, GameMsgChatPie.ButtonInfo paramButtonInfo1, GameMsgChatPie.ButtonInfo paramButtonInfo2)
  {
    if ((paramButtonInfo1 == null) && (paramButtonInfo2 == null)) {
      return;
    }
    QQCustomDialog localQQCustomDialog = this.br;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      return;
    }
    if ((paramButtonInfo1 != null) && (paramButtonInfo2 != null)) {
      this.br = DialogUtil.a(this.f, 230, paramString1, paramString2, paramButtonInfo1.b, paramButtonInfo2.b, new GameMsgChatPie.2(this, paramButtonInfo2), new GameMsgChatPie.3(this, paramButtonInfo1));
    } else if (paramButtonInfo1 != null) {
      this.br = DialogUtil.a(this.f, 230, paramString1, paramString2, paramButtonInfo1.b, "", null, new GameMsgChatPie.4(this, paramButtonInfo1));
    }
    paramString1 = this.br;
    if (paramString1 != null) {
      paramString1.show();
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      paramQQAppInterface = ((IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getPlayerInfoUrl();
      if ((!TextUtils.isEmpty(paramQQAppInterface)) && (paramContext != null) && (!TextUtils.isEmpty(paramString)))
      {
        boolean bool = paramQQAppInterface.contains("?");
        StringBuilder localStringBuilder;
        if (bool)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramQQAppInterface);
          localStringBuilder.append("&roleId=");
          localStringBuilder.append(URLEncoder.encode(paramString, "utf-8"));
          paramQQAppInterface = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramQQAppInterface);
          localStringBuilder.append("?roleId=");
          localStringBuilder.append(URLEncoder.encode(paramString, "utf-8"));
          paramQQAppInterface = localStringBuilder.toString();
        }
        paramString = new Intent(paramContext, QQBrowserActivity.class);
        paramString.putExtra("url", paramQQAppInterface);
        paramContext.startActivity(paramString);
        return true;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("GameCenterMsg.GameMsgChatPie", 1, paramQQAppInterface, new Object[0]);
    }
    return false;
  }
  
  private void bN()
  {
    this.P = false;
    ((IGameMsgManagerService)this.d.getRuntimeService(IGameMsgManagerService.class, "")).addUserInfoChangedObserver(this.bL);
    Object localObject = this.f.getIntent();
    String str1 = ((Intent)localObject).getStringExtra("game_msg_friend_role_id");
    String str2 = ((Intent)localObject).getStringExtra("game_msg_my_role_id");
    this.bC = ((Intent)localObject).getIntExtra("game_msg_open_aio_from", -1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("friRoleId:");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(",myRoleId:");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(", fromPage:");
    ((StringBuilder)localObject).append(this.bC);
    QLog.i("GameCenterMsg.GameMsgChatPie", 1, ((StringBuilder)localObject).toString());
    this.bp = new GameMsgChatPie.GameUsrAvatarClickLis(this.d, str2, true, this.f);
    this.bq = new GameMsgChatPie.GameUsrAvatarClickLis(this.d, str1, false, this.f);
    this.ah.a(str1);
    this.ah.b(str2);
    this.bn = this.bm.getSingleGameDetail(str1);
    if (this.bn == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mFriendGameInfo is null, friRoleId:");
      ((StringBuilder)localObject).append(str1);
      QLog.i("GameCenterMsg.GameMsgChatPie", 2, ((StringBuilder)localObject).toString());
    }
    this.bo = this.bm.getSingleGameDetail(str2);
    ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).getAioPopInfo(this.bK, str2, str1);
    if (this.bn != null)
    {
      ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).getGameStartPriority(this.bK, this.bn.c);
      bi = this.bn.c;
    }
    ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).getGameSwitch(this.bK);
    localObject = (GameMsgSayHiHelper)q(141);
    if (localObject != null) {
      ((GameMsgSayHiHelper)localObject).a(str2, str1);
    }
  }
  
  private void bO()
  {
    Object localObject = this.bn;
    if (localObject != null)
    {
      boolean bool = this.bm.isGameMsgSync(((GameDetailInfo)localObject).c);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isMsgSync:");
        ((StringBuilder)localObject).append(bool);
        QLog.d("GameCenterMsg.GameMsgChatPie", 2, ((StringBuilder)localObject).toString());
      }
      if (bool) {
        return;
      }
      if (((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).isShowMsg(this.d, this.ah.b))
      {
        ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).setGameSwitch(this.bK, this.bn.c, 1, 0);
        this.bz = true;
      }
    }
  }
  
  private String bP()
  {
    TinyInfo localTinyInfo = RoleIdUtil.a(this.d, this.ah.b);
    if (localTinyInfo != null) {
      return localTinyInfo.toOpenId;
    }
    return "";
  }
  
  private void bQ()
  {
    if (this.by)
    {
      if (this.p != null) {
        this.p.a(false);
      }
      if ((this.by) && (i() != null) && (this.bn != null))
      {
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i().getCurrentUin());
        ((StringBuilder)localObject).append("_game_msg_chatpie_reddot_click_");
        ((StringBuilder)localObject).append(this.bn.c);
        localObject = ((StringBuilder)localObject).toString();
        localSharedPreferences.edit().putBoolean((String)localObject, true).commit();
      }
      this.by = false;
    }
  }
  
  private void bR()
  {
    Dialog localDialog = this.bw;
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
  
  @TargetApi(14)
  private void bS()
  {
    aQ();
    if (this.bw == null)
    {
      Object localObject1 = new RelativeLayout(aX());
      Object localObject2 = new RoundRectLinearLayout(aX());
      ((RoundRectLinearLayout)localObject2).setRoundRect(AIOUtils.b(15.0F, aX().getResources()), -1, false);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, AIOUtils.b(30.0F, aX().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new View(aX());
      ((View)localObject2).setBackgroundColor(-1);
      localObject3 = new RelativeLayout.LayoutParams(-1, AIOUtils.b(450.0F, aX().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(10.0F, aX().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(aX());
      ((TextView)localObject2).setText("游戏中心启动专属特权");
      ((TextView)localObject2).setTextColor(-13421773);
      ((TextView)localObject2).setTextSize(20.0F);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(20.0F, aX().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.b(20.0F, aX().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new ImageView(aX());
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((ImageView)localObject2).setImageResource(2130853509);
      ((ImageView)localObject2).setOnClickListener(this.bN);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(11);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(5.0F, aX().getResources());
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = AIOUtils.b(10.0F, aX().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new ImageView(aX());
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.b(60.0F, aX().getResources()), AIOUtils.b(60.0F, aX().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(66.0F, aX().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.b(20.0F, aX().getResources());
      if (!TextUtils.isEmpty(this.bn.l))
      {
        new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/").mkdirs();
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = AIOUtils.b(60.0F, aX().getResources());
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = AIOUtils.b(60.0F, aX().getResources());
        ((ImageView)localObject2).setImageDrawable(((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(this.bn.l), (URLDrawable.URLDrawableOptions)localObject4, this.bn.l));
      }
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(aX());
      localObject3 = this.bn;
      if (localObject3 != null) {
        ((TextView)localObject2).setText(((GameDetailInfo)localObject3).k);
      }
      ((TextView)localObject2).setTextColor(-13421773);
      ((TextView)localObject2).setTextSize(15.0F);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(75.0F, aX().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.b(88.0F, aX().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(aX());
      ((TextView)localObject2).setText("启动特权生效中");
      ((TextView)localObject2).setClickable(false);
      ((TextView)localObject2).setTextColor(-32768);
      ((TextView)localObject2).setDuplicateParentStateEnabled(false);
      ((TextView)localObject2).setBackgroundDrawable(new RoundRectColorDrawable(385843200, AIOUtils.b(4.0F, aX().getResources()), AIOUtils.b(80.0F, aX().getResources()), AIOUtils.b(18.0F, aX().getResources())));
      ((TextView)localObject2).setTextSize(10.0F);
      ((TextView)localObject2).setGravity(17);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(101.0F, aX().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.b(88.0F, aX().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new View(aX());
      ((View)localObject2).setBackgroundColor(369098752);
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.b(335.0F, aX().getResources()), 1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(142.0F, aX().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      if (this.bv != null)
      {
        int i = 0;
        while ((i < this.bv.size()) && (i < 4))
        {
          localObject2 = (GameMsgChatPie.GamePriorityInfo)this.bv.get(i);
          localObject3 = new ImageView(aX());
          ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          localObject4 = new RelativeLayout.LayoutParams(AIOUtils.b(40.0F, aX().getResources()), AIOUtils.b(40.0F, aX().getResources()));
          ((RelativeLayout.LayoutParams)localObject4).addRule(10);
          ((RelativeLayout.LayoutParams)localObject4).addRule(9);
          ((RelativeLayout.LayoutParams)localObject4).topMargin = AIOUtils.b(158.0F, aX().getResources());
          float f2 = (float)((DeviceInfoUtil.D() - AIOUtils.b(40.0F, aX().getResources()) * this.bv.size()) / (this.bv.size() + 1));
          float f3 = AIOUtils.b(40.0F, aX().getResources());
          f1 = i;
          ((RelativeLayout.LayoutParams)localObject4).leftMargin = ((int)(f2 + (f3 + f2) * f1));
          if (!TextUtils.isEmpty(((GameMsgChatPie.GamePriorityInfo)localObject2).a)) {
            ((ImageView)localObject3).setImageDrawable(URLDrawable.getDrawable(((GameMsgChatPie.GamePriorityInfo)localObject2).a));
          }
          ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          localObject3 = new TextView(aX());
          ((TextView)localObject3).setText(((GameMsgChatPie.GamePriorityInfo)localObject2).b);
          ((TextView)localObject3).setTextColor(-2144128205);
          ((TextView)localObject3).setTextSize(12.0F);
          ((TextView)localObject3).setLines(3);
          ((TextView)localObject3).setGravity(3);
          localObject2 = new RelativeLayout.LayoutParams(AIOUtils.b(63.0F, aX().getResources()), -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          f2 = (float)((DeviceInfoUtil.D() - AIOUtils.b(63.0F, aX().getResources()) * this.bv.size()) / (this.bv.size() + 1));
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(f2 + (AIOUtils.b(63.0F, aX().getResources()) + f2) * f1));
          ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.b(208.0F, aX().getResources());
          ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
          i += 1;
        }
      }
      localObject2 = new RoundRectLinearLayout(aX());
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.b(335.0F, aX().getResources()), AIOUtils.b(40.0F, aX().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(12);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.b(32.0F, aX().getResources());
      ((RoundRectLinearLayout)localObject2).setGravity(17);
      float f1 = AIOUtils.b(20.0F, aX().getResources());
      Object localObject4 = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, null, null));
      LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, AIOUtils.b(335.0F, aX().getResources()), 0.0F, -16733441, -16751361, Shader.TileMode.CLAMP);
      ((ShapeDrawable)localObject4).getPaint().setShader(localLinearGradient);
      ((RoundRectLinearLayout)localObject2).setBackgroundDrawable((Drawable)localObject4);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(aX());
      ((TextView)localObject3).setText("立即启动");
      ((TextView)localObject3).setTextColor(-1);
      ((TextView)localObject3).setTextSize(16.0F);
      ((TextView)localObject3).getPaint().setFakeBoldText(true);
      ((TextView)localObject3).setGravity(17);
      ((RoundRectLinearLayout)localObject2).addView((View)localObject3);
      ((RoundRectLinearLayout)localObject2).setOnClickListener(this.bO);
      this.bw = new ReportDialog(aX(), 2131953338);
      this.bw.setContentView((View)localObject1);
      localObject1 = this.bw.getWindow();
      ((Window)localObject1).setGravity(80);
      if (Build.VERSION.SDK_INT >= 14) {
        ((Window)localObject1).setDimAmount(0.5F);
      }
      ((Window)localObject1).setWindowAnimations(2131953021);
      ((Window)localObject1).setLayout(-1, AIOUtils.b(460.0F, aX().getResources()));
    }
    if (this.bn != null) {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.bn.c, "1", "145", "920", "92005", "207564", "", "", "8", "0");
    }
    this.bw.show();
  }
  
  private boolean bT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterMsg.GameMsgChatPie", 2, "[showStartGame]");
    }
    if (bH() == null) {
      return false;
    }
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).startGame(this.f, bH());
    return true;
  }
  
  private void f(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.bB = new GameMsgTipsBar(this.d, aX());
      this.aX.b(this.bB);
      this.bB.a(paramString);
      this.aX.a(this.bB, new Object[0]);
    }
  }
  
  private void p(boolean paramBoolean)
  {
    Object localObject = this.bn;
    if (localObject != null) {
      localObject = ((GameDetailInfo)localObject).e;
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("你已屏蔽");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("的临时会话");
      localObject = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("你已允许接收");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("的临时会话");
      localObject = localStringBuilder.toString();
    }
    localObject = new UniteGrayTipParam(this.ah.b, this.d.getCurrentUin(), (String)localObject, 10007, -5020, 656397, MessageCache.c());
    GameMsgGrayTipsHandler.a(this.d, 0L, (UniteGrayTipParam)localObject);
  }
  
  private void s(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[createRules], relation:");
    localStringBuilder.append(paramInt);
    QLog.i("GameCenterMsg.GameMsgChatPie.strangerRecom", 1, localStringBuilder.toString());
    this.bH = ((IGameMsgSayHelloRulesApi)QRoute.api(IGameMsgSayHelloRulesApi.class));
    this.bH.doInit(this.bK, this.d, "game_msg_sp_key_say_hello_", 5, paramInt, this.ah.c(), this.ah.d(), aa());
  }
  
  protected void D()
  {
    super.D();
  }
  
  public void K()
  {
    super.K();
    Object localObject = this.bw;
    if (localObject != null) {
      ((Dialog)localObject).dismiss();
    }
    localObject = this.bI;
    if (localObject != null)
    {
      ((Dialog)localObject).dismiss();
      this.bI = null;
    }
    localObject = this.bJ;
    if (localObject != null)
    {
      ((PopupWindow)localObject).dismiss();
      this.bJ = null;
    }
    localObject = this.bB;
    if (localObject != null) {
      ((GameMsgTipsBar)localObject).d();
    }
    if (this.d != null) {
      ((IGameMsgManagerService)this.d.getRuntimeService(IGameMsgManagerService.class, "")).removeUserInfoChangedObserver(this.bL);
    }
  }
  
  public void P()
  {
    super.P();
  }
  
  public void S()
  {
    super.S();
    IGameMsgManagerService localIGameMsgManagerService = this.bm;
    if (localIGameMsgManagerService != null) {
      localIGameMsgManagerService.cleanSessionUnread(this.ah.b);
    }
  }
  
  public GameMsgChatPie.GameUsrAvatarClickLis a()
  {
    return this.bp;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.bm = ((IGameMsgManagerService)this.d.getRuntimeService(IGameMsgManagerService.class, ""));
    this.bK = hashCode();
    bN();
    QLog.i("GameCenterMsg.GameMsgChatPie", 1, "[doOnCreate]");
    return super.a(paramBoolean);
  }
  
  public void aC()
  {
    super.aC();
  }
  
  protected void au()
  {
    super.au();
    this.d.addObserver(this.bL);
    this.d.addDefaultObservers(this.bj);
  }
  
  protected void av()
  {
    super.av();
    this.d.removeObserver(this.bj);
    this.d.removeObserver(this.bL);
  }
  
  public View b(int paramInt)
  {
    if (paramInt == 3) {
      return bJ().getView();
    }
    return super.b(paramInt);
  }
  
  protected HelperProvider b()
  {
    return new GameMsgHelperProvider(this.f);
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    a(this.bn);
  }
  
  public AIOInput bA()
  {
    return this.l;
  }
  
  public GameDetailInfo bB()
  {
    return this.bn;
  }
  
  public GameDetailInfo bC()
  {
    return this.bo;
  }
  
  public void bD()
  {
    Intent localIntent = new Intent(this.e, ChatSettingActivity.class);
    String str3 = bP();
    Object localObject1 = this.bn;
    String str2 = "";
    String str1;
    if (localObject1 != null)
    {
      str1 = ((GameDetailInfo)localObject1).c;
      if (this.bn.e != null) {
        localObject1 = this.bn.e;
      } else {
        localObject1 = this.ah.e;
      }
      localIntent.putExtra("appid", this.bn.c);
      localIntent.putExtra("account", this.bn.b);
    }
    else
    {
      str1 = "";
      localObject1 = str1;
    }
    Object localObject2 = this.bo;
    if (localObject2 != null)
    {
      if (((GameDetailInfo)localObject2).e != null) {
        str2 = this.bo.e;
      } else {
        str2 = this.ah.e;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("我是");
      ((StringBuilder)localObject2).append(a(str1, str2));
      str2 = ((StringBuilder)localObject2).toString();
      localIntent.putExtra("game_msg", str2);
    }
    localObject1 = a(str1, (String)localObject1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onClick: ivTitleBtnRightImage mAppId = ");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(" uinName = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" \n message = ");
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append(" openId = ");
      ((StringBuilder)localObject2).append(str3);
      ((StringBuilder)localObject2).append(" mShieldValue = ");
      ((StringBuilder)localObject2).append(this.bA);
      QLog.d("GameCenterMsg.GameMsgChatPie", 2, ((StringBuilder)localObject2).toString());
    }
    localIntent.putExtra("openid", str3);
    localIntent.putExtra("uinname", (String)localObject1);
    localIntent.putExtra("uintype", this.ah.a);
    localIntent.putExtra("uin", this.ah.b);
    localIntent.putExtra("game_msg_friend_role_id", this.ah.c());
    localIntent.putExtra("game_msg_my_role_id", this.ah.d());
    localIntent.putExtra("game_chatpie_hashcode", hashCode());
    localIntent.putExtra("game_is_shiled", this.bA);
    this.f.startActivityForResult(localIntent, 2000);
    if (this.bn != null) {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.bn.c, "1", "145", "920", "92005", "208985", "", "", "20", "");
    }
  }
  
  public void bE()
  {
    Object localObject = this.bn;
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((GameDetailInfo)localObject).b)) {
        return;
      }
      boolean bool = ApkUtils.a(this.bs, BaseApplicationImpl.getApplication());
      localObject = bH();
      int i = 0;
      if ((localObject != null) && (this.bu == 1) && (bool) && (!this.bv.isEmpty())) {
        bool = true;
      } else {
        bool = false;
      }
      GameMsgChatPie.5 local5 = new GameMsgChatPie.5(this, bool);
      Bundle localBundle = new Bundle();
      localBundle.putInt("from", 1);
      if (bool) {
        localObject = "立即启动获得特权";
      } else {
        localObject = "立即下载";
      }
      localBundle.putString("startBtnText", (String)localObject);
      localBundle.putString("onlineText", this.bn.b());
      if (this.bv != null)
      {
        localObject = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        while (i < this.bv.size())
        {
          ((ArrayList)localObject).add(((GameMsgChatPie.GamePriorityInfo)this.bv.get(i)).a);
          localArrayList.add(((GameMsgChatPie.GamePriorityInfo)this.bv.get(i)).b);
          i += 1;
        }
        localBundle.putStringArrayList("priorityIconList", (ArrayList)localObject);
        localBundle.putStringArrayList("priorityDetailList", localArrayList);
      }
      this.bJ = ((IGameMsgManagerService)this.d.getRuntimeService(IGameMsgManagerService.class, "")).showGameAIOStatusPopupWindow(this.bn, this.i.b(), localBundle, local5);
    }
  }
  
  public boolean bF()
  {
    IGameMsgSayHelloRulesApi localIGameMsgSayHelloRulesApi = this.bH;
    if ((localIGameMsgSayHelloRulesApi != null) && (!localIGameMsgSayHelloRulesApi.isAbleToAction()))
    {
      QQToast.makeText(this.e, HardCodeUtil.a(2131889898), 1).show();
      if ((this.bn != null) && (this.bE != null)) {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.bn.c, "1", "145", "920", "92015", "207871", this.bE.d, this.d.getCurrentAccountUin(), "8", "");
      }
      return false;
    }
    return true;
  }
  
  protected void bG()
  {
    if ((this.bn != null) && (!TextUtils.isEmpty(this.bs)))
    {
      Object localObject = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=";
      QQAppInterface localQQAppInterface = i();
      if ((!TextUtils.isEmpty(this.bt)) && (localQQAppInterface != null))
      {
        if (!this.bt.startsWith("&"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=");
          ((StringBuilder)localObject).append("&");
          localObject = ((StringBuilder)localObject).toString();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(this.bt);
        localObject = localStringBuilder.toString();
        new AppLaucherHelper().a(localQQAppInterface, aX(), this.bn.c, (String)localObject, this.bs, 536870912);
        ((IApolloExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.bn.c, localQQAppInterface.getCurrentAccountUin(), 1);
      }
    }
    else
    {
      QLog.e("GameCenterMsg.GameMsgChatPie", 1, "gameinfo is null ");
    }
  }
  
  public GameDetailInfo bH()
  {
    return this.bn;
  }
  
  void bI()
  {
    a(this.bn);
  }
  
  public IEmoticonMainPanel bJ()
  {
    long l = System.currentTimeMillis();
    Object localObject2 = ((IEmoticonMainPanelService)this.d.getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(this.e, aE().a);
    Object localObject1 = (AIOEmoticonPanelHelper)q(104);
    if (localObject1 != null) {
      ((IEmoticonMainPanelService.PanelBuilder)localObject2).setCallBack((EmoticonCallback)localObject1);
    }
    ((IEmoticonMainPanelService.PanelBuilder)localObject2).setHideAllSettingTabs(true);
    ((IEmoticonMainPanelService.PanelBuilder)localObject2).setDisableMoreEmotionButton(true).setDisableGuide(true).setPanelInteractionListener(new AIOPanelInteractionListener(this)).setToastOffset(A()).setEmoticonListProvider(new GameMsgChatPie.9(this));
    localObject1 = (AIOEmoticonUIHelper)q(105);
    localObject2 = ((IEmoticonMainPanelService.PanelBuilder)localObject2).create();
    ((IEmoticonMainPanel)localObject2).setEmoSettingVisibility(8);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OpenEmoticonMainPanel:");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.d("OpenPanel", 2, localStringBuilder.toString());
    }
    ((AIOEmoticonUIHelper)localObject1).a((IEmoticonMainPanel)localObject2);
    return localObject2;
  }
  
  public boolean bK()
  {
    GameMsgSayHiHelper localGameMsgSayHiHelper = (GameMsgSayHiHelper)q(141);
    if (localGameMsgSayHiHelper == null) {
      return true;
    }
    return localGameMsgSayHiHelper.k();
  }
  
  public GameMsgChatPie.GameUsrAvatarClickLis bz()
  {
    return this.bq;
  }
  
  protected AIOInput c()
  {
    return new AIOInputBuilder().a(this.i).a(new GameMsgChatPie.GameMsgMessageSender(this, this.i)).a();
  }
  
  protected void c(Intent paramIntent) {}
  
  protected AIOContext d()
  {
    return new GameMsgContext();
  }
  
  public void d(int paramInt)
  {
    super.d(paramInt);
  }
  
  public boolean e(String paramString)
  {
    return false;
  }
  
  protected void f(Intent paramIntent)
  {
    super.f(paramIntent);
  }
  
  public void l(int paramInt)
  {
    super.l(paramInt);
    QLog.i("GameCenterMsg.GameMsgChatPie", 1, "[onShowFirst]");
  }
  
  public void onClick(View paramView)
  {
    boolean bool;
    StringBuilder localStringBuilder;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131447572: 
      bE();
      break;
    case 2131447534: 
      if ((this.bn != null) && (b(this.d, paramView.getContext(), this.ah.c()))) {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.bn.c, "1", "145", "920", "92005", "208403", Integer.toString(this.bn.j), null, "20", null);
      }
      break;
    case 2131444531: 
      if (this.bn != null) {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.bn.c, "1", "145", "920", "92005", "207563", "", "", "20", "0");
      }
      bQ();
      bool = ApkUtils.a(this.bs, BaseApplicationImpl.getApplication());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mGamePackageName:");
      localStringBuilder.append(this.bs);
      localStringBuilder.append(" isInstall:");
      localStringBuilder.append(bool);
      QLog.i("GameCenterMsg.GameMsgChatPie", 1, localStringBuilder.toString());
      if ((bH() != null) && (this.bu == 1) && (bool) && (!this.bv.isEmpty())) {
        bS();
      } else {
        if (!bT()) {
          break;
        }
      }
      break;
    case 2131436194: 
      bD();
      break;
    case 2131436189: 
      bQ();
      bool = ApkUtils.a(this.bs, BaseApplicationImpl.getApplication());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mGamePackageName:");
      localStringBuilder.append(this.bs);
      localStringBuilder.append(" isInstall:");
      localStringBuilder.append(bool);
      QLog.i("GameCenterMsg.GameMsgChatPie", 1, localStringBuilder.toString());
      if ((bH() != null) && (this.bu == 1) && (bool) && (!this.bv.isEmpty()))
      {
        if (this.bn != null)
        {
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.bn.c, "1", "145", "920", "92005", "206357", "1", "", "20", "0");
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.bn.c, "1", "145", "920", "92005", "207565", "", "", "20", "0");
        }
        bS();
      }
      else
      {
        if (this.bn != null) {
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.bn.c, "1", "145", "920", "92005", "206357", "0", "", "20", "0");
        }
        if (!bT()) {
          break;
        }
      }
      break;
    case 2131435808: 
      if (this.bn != null) {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.bn.c, "1", "145", "920", "92005", "206355", "", "", "20", "0");
      }
      break;
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected boolean p()
  {
    return (this.aL) || (super.p());
  }
  
  protected String s()
  {
    GameMsgChatPie.StrangerRecomInfo localStrangerRecomInfo = this.bE;
    if (localStrangerRecomInfo != null) {
      return localStrangerRecomInfo.d;
    }
    QLog.i("GameCenterMsg.GameMsgChatPie.strangerRecom", 1, "[getUin4AddAndShiledFriend], mStrangerRecomInfo is null.");
    return this.ah.b;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (paramObservable.istroop == 10007)
      {
        paramObject = this.bH;
        if (paramObject != null) {
          paramObject.onMsgUpdate(paramObservable);
        }
        int i = this.bC;
        if (((i == 3) || (i == 4)) && (!this.bD))
        {
          this.d.getProxyManager().h().b(this.ah.b, 10007, 0);
          this.bD = true;
          QLog.d("GameCenterMsg.GameMsgChatPie", 2, "[update], save conversation.");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie
 * JD-Core Version:    0.7.0.1
 */