package com.tencent.mobileqq.activity;

import MQQ.GetRoamToastRsp;
import QQService.EVIPSPEC;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.aio.helper.KanDianPrivateChatAddFriendHelper;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentRIJPrivateChatItemBuilder;
import com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxObserver;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxObserver;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.activity.specialcare.SpecialCareUtils;
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarManager;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarObserver;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarSwitcher;
import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.SingTogetherConfigBean;
import com.tencent.mobileqq.config.business.SingTogetherConfigBean.GeneralTogetherItem;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.message.TinyIdCache;
import com.tencent.mobileqq.kandian.biz.privatechat.api.IRIJPrivateChatService;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils;
import com.tencent.mobileqq.nearby.profilecard.IMiniCardManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qqexpand.chat.IAioColdPalaceHelper;
import com.tencent.mobileqq.qqexpand.chat.IColdPalaceBanish;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.IColdPalaceUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils.NamePlateVipTpye;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils.VipIconTouchListener;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.DeleteRecordDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowReq;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ChatSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, IColdPalaceBanish
{
  private static final boolean N = AppSetting.e;
  TextView A;
  IQvipSpecialSoundManager B;
  C2CShortcutBarObserver C = new ChatSettingActivity.1(this);
  ExpandObserver D = new ChatSettingActivity.2(this);
  TextView E;
  RichStatus F;
  MqqHandler G = new ChatSettingActivity.18(this);
  AvatarObserver H = new ChatSettingActivity.19(this);
  FriendListObserver I = new ChatSettingActivity.20(this);
  CardObserver J = new ChatSettingActivity.21(this);
  ProfileCardObserver K = new ChatSettingActivity.22(this);
  MessageObserver L = new ChatSettingActivity.24(this);
  private String M = ChatSettingActivity.class.getSimpleName();
  private FriendListHandler O;
  private Intent P;
  private View Q;
  private XListView R;
  private XSimpleListAdapter S;
  private QQProgressDialog T;
  private View U;
  private int V;
  private String W;
  private String X;
  private String Y;
  private String Z;
  protected String a = "ChatSettingActivity.nearby";
  private TextView aA;
  private View aB;
  private boolean aC = false;
  private boolean aD = false;
  private boolean aE = false;
  private boolean aF = true;
  private String aG = "";
  private boolean aH = false;
  private String aI = "";
  private String aJ = "";
  private QQProgressDialog aK;
  private boolean aL = false;
  private int aM;
  private WeakReference<FaceDrawable> aN;
  private WeakReference<FaceDrawable> aO;
  private boolean aP = false;
  private TextView aQ;
  private Dialog aR;
  private FilterMsgBoxObserver aS = new ChatSettingActivity.8(this);
  private TempMsgBoxObserver aT = new ChatSettingActivity.9(this);
  private QvipSpecialCareObserver aU = new ChatSettingActivity.14(this);
  private SVIPObserver aV = new ChatSettingActivity.15(this);
  private Dialog aW;
  private ShieldListObserver aX = new ChatSettingActivity.23(this);
  private IIconListener aY = new ChatSettingActivity.26(this);
  private String aa;
  private String ab;
  private int ac;
  private String ad;
  private boolean ae = false;
  private final int af = 1;
  private final int ag = 2;
  private final int ah = 3;
  private boolean ai = false;
  private boolean aj = false;
  private float ak;
  private String al;
  private String am;
  private String an;
  private int ao = 0;
  private boolean ap = false;
  private FormSimpleItem aq;
  private RelativeLayout ar;
  private ImageView as;
  private TextView at;
  private FormSwitchItem au;
  private FormSwitchItem av;
  private FormSimpleItem aw;
  private TextView ax;
  private Button ay;
  private Button az;
  protected boolean b = false;
  RelativeLayout c;
  ImageView d;
  TextView e;
  ImageView f;
  MutualMarkIconsView g;
  RelativeLayout h;
  FormSimpleItem i;
  FormSimpleItem j;
  FormSimpleItem k;
  FormSimpleItem l;
  FormSimpleItem m;
  FormSwitchItem n;
  FormSimpleItem o;
  FormSwitchItem p;
  FormSwitchItem q;
  FormSwitchItem r;
  FormSwitchItem s;
  FormSwitchItem t;
  TextView u;
  TextView v;
  ViewGroup w;
  TextView x;
  TextView y;
  TextView z;
  
  private void A()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.W);
    localIntent.putExtra("uinname", this.X);
    localIntent.putExtra("uintype", this.V);
    localIntent.putExtra("isNeedUpdate", this.ai);
    startActivity(localIntent);
  }
  
  private void B()
  {
    Object localObject = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    if ((((SharedPreferences)localObject).getBoolean("special_care_chat_setting", true)) && (!QvipSpecialCareUtil.d(this.W, this.app)))
    {
      localObject = getResources().getDrawable(2130852591);
      this.j.setRightIcon((Drawable)localObject);
      return;
    }
    boolean bool = ((SharedPreferences)localObject).getBoolean("special_care_red_point_one", false);
    ((SharedPreferences)localObject).getBoolean("special_care_red_point_two", false);
    if (bool)
    {
      localObject = getResources().getDrawable(2130852588);
      getResources().getDrawable(2130839446);
      this.j.setRightIcon((Drawable)localObject);
    }
  }
  
  private void C()
  {
    ChatSettingActivity.16 local16 = new ChatSettingActivity.16(this, new StringBuilder());
    if (!this.aP)
    {
      ThreadManager.post(local16, 8, null, true);
      a(2, getString(2131886634));
    }
  }
  
  private void D()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131889169, 1);
      this.q.setChecked(this.ap);
      return;
    }
    E();
    if (this.V == 0) {
      if (this.O == null)
      {
        g();
        return;
      }
    }
    try
    {
      l1 = Long.parseLong(this.W);
    }
    catch (Exception localException)
    {
      long l1;
      label63:
      break label63;
    }
    l1 = 0L;
    if (l1 > 0L)
    {
      this.O.changeFriendShieldFlag(l1, true ^ this.ap);
      return;
    }
    a(1, HardCodeUtil.a(2131899942));
  }
  
  private void E()
  {
    Object localObject = this.j;
    boolean bool = this.q.a();
    int i2 = 0;
    int i1;
    if (!bool) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((FormSimpleItem)localObject).setVisibility(i1);
    localObject = this.n;
    if ((!this.p.a()) && (!this.q.a())) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    ((FormSwitchItem)localObject).setVisibility(i1);
    a();
  }
  
  private void F()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131889169, 1);
      this.au.setChecked(this.aD);
      return;
    }
    Object localObject1 = (ShieldMsgManger)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    if (localObject1 != null) {}
    try
    {
      l1 = Long.parseLong(this.aG);
    }
    catch (Exception localException)
    {
      long l1;
      label60:
      Object localObject2;
      Object localObject3;
      Object localObject4;
      int i1;
      boolean bool;
      break label60;
    }
    l1 = 0L;
    if (l1 > 0L)
    {
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(Long.valueOf(l1));
      if (QLog.isColorLevel())
      {
        localObject3 = this.a;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("startStangerShield, tuin=");
        ((StringBuilder)localObject4).append(l1);
        ((StringBuilder)localObject4).append(", mIsShield=");
        ((StringBuilder)localObject4).append(this.aD);
        ((StringBuilder)localObject4).append(", mIsFollowed=");
        ((StringBuilder)localObject4).append(this.b);
        QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      }
      if (this.aD)
      {
        ((ShieldMsgManger)localObject1).b(this.V, (List)localObject2);
      }
      else
      {
        if (this.b)
        {
          if (ChatActivityUtils.b.size() > 5) {
            ChatActivityUtils.b.poll();
          }
          localObject3 = ChatActivityUtils.b;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(l1);
          ((StringBuilder)localObject4).append("");
          ((Queue)localObject3).offer(((StringBuilder)localObject4).toString());
        }
        ((ShieldMsgManger)localObject1).a(this.V, (List)localObject2);
      }
      this.aH = true;
    }
    else
    {
      a(1, HardCodeUtil.a(2131899983));
    }
    localObject4 = this.app;
    if (this.aD) {
      localObject2 = "cancel_aio";
    } else {
      localObject2 = "block_aio";
    }
    if (this.V == 1001) {
      localObject3 = "0";
    } else {
      localObject3 = "1";
    }
    if (this.aD) {
      localObject1 = "";
    } else if (this.b) {
      localObject1 = "0";
    } else {
      localObject1 = "1";
    }
    ReportController.b((AppRuntime)localObject4, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject2, 0, 0, (String)localObject3, "1", (String)localObject1, "");
    i1 = this.V;
    if ((i1 == 1001) || (i1 == 10002) || (i1 == 1003))
    {
      if (this.aD)
      {
        localObject1 = this.W;
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          this.app.getMsgHandler().g(this.W);
          this.aH = true;
        }
      }
      else
      {
        localObject1 = this.W;
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          this.app.getMsgHandler().f(this.W);
          this.aH = true;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startStangerShield, mCurUin=");
        ((StringBuilder)localObject2).append(this.W);
        ((StringBuilder)localObject2).append(", mIsShield=");
        ((StringBuilder)localObject2).append(this.aD);
        ((StringBuilder)localObject2).append(", mShieldByThis=");
        ((StringBuilder)localObject2).append(this.aH);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
    bool = this.aH;
    if (this.V == 10007)
    {
      if (this.aD) {
        i1 = 4;
      } else {
        i1 = 2;
      }
      ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).addOrShieldFriend(this.ac, i1, this.Z, this.aa, "");
    }
    if (this.V == 1010)
    {
      if (this.aD)
      {
        ReportController.b(this.app, "CliOper", "", this.aG, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.app, "CliOper", "", this.aG, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
    }
  }
  
  private void G()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshShieldButton, mCurType=");
      localStringBuilder.append(this.V);
      localStringBuilder.append(", mIsShield=");
      localStringBuilder.append(this.aD);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.au;
    if (localObject != null)
    {
      ((FormSwitchItem)localObject).setChecked(this.aD);
      if (AppSetting.e) {
        this.au.setContentDescription(getString(2131887780));
      }
    }
    if ((this.V != 1003) && (this.aF))
    {
      if ((this.au != null) && (this.aB != null))
      {
        if (!p()) {
          this.au.setVisibility(0);
        }
        this.aB.setVisibility(0);
      }
    }
    else
    {
      localObject = this.au;
      if ((localObject != null) && (this.aB != null))
      {
        ((FormSwitchItem)localObject).setVisibility(8);
        this.aB.setVisibility(8);
      }
    }
  }
  
  private void H()
  {
    int i1 = this.V;
    if ((1001 != i1) && (10002 != i1)) {
      i1 = 2131887778;
    } else if (this.b) {
      i1 = 2131894141;
    } else {
      i1 = 2131894139;
    }
    String str = getString(i1);
    if (this.V == 10007) {
      str = getString(2131889886);
    }
    this.ay.setText(str);
    this.ay.setContentDescription(str);
  }
  
  private void I()
  {
    if (this.q == null) {
      return;
    }
    Object localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((localObject != null) && (!TextUtils.isEmpty(this.W))) {
      this.ap = ((FriendsManager)localObject).w(this.W);
    }
    this.q.setChecked(this.ap);
    if (AppSetting.e) {
      this.q.setContentDescription(getString(2131887780));
    }
    if (this.j == null) {
      return;
    }
    E();
    boolean bool = this.ap;
    int i2 = 0;
    int i1 = 0;
    if (bool)
    {
      this.j.setVisibility(8);
      localObject = this.n;
      if ((this.p.a()) || (this.q.a())) {
        i1 = 8;
      }
      ((FormSwitchItem)localObject).setVisibility(i1);
    }
    else if (!this.app.getCurrentUin().equals(this.W))
    {
      this.j.setVisibility(0);
      localObject = this.n;
      if ((!this.p.a()) && (!this.q.a())) {
        i1 = i2;
      } else {
        i1 = 8;
      }
      ((FormSwitchItem)localObject).setVisibility(i1);
    }
    bool = N;
  }
  
  private void J()
  {
    if (this.app != null)
    {
      MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1009);
      }
      localMqqHandler = this.app.getHandler(TroopAssistantActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1);
      }
    }
  }
  
  private void K()
  {
    AllInOne localAllInOne = new AllInOne(this.W, 46);
    localAllInOne.pa = 19;
    localAllInOne.nickname = ContactUtils.a(this.app, this.W);
    if ((TextUtils.isEmpty(localAllInOne.nickname)) || (localAllInOne.nickname.equals(this.W))) {
      localAllInOne.nickname = this.X;
    }
    localAllInOne.preWinUin = this.W;
    int i1 = this.V;
    localAllInOne.preWinType = i1;
    localAllInOne.lastActivity = 5;
    localAllInOne.profileEntryType = 61;
    if (i1 != 1000)
    {
      if (i1 != 1001)
      {
        if (i1 != 1009)
        {
          if (i1 != 1010)
          {
            if ((i1 != 1044) && (i1 != 1045))
            {
              if (i1 != 4000)
              {
                if (i1 != 10002) {
                  if (i1 != 10008) {
                    if (i1 == 10010) {}
                  }
                }
                switch (i1)
                {
                default: 
                  switch (i1)
                  {
                  default: 
                    break;
                  case 1023: 
                    localAllInOne.pa = 74;
                    break;
                  case 1022: 
                    localAllInOne.pa = 27;
                    break;
                  case 1021: 
                    localAllInOne.pa = 72;
                    break;
                  case 1020: 
                    localAllInOne.pa = 58;
                  }
                  break;
                case 1005: 
                  localAllInOne.pa = 2;
                  break;
                case 1004: 
                  localAllInOne.pa = 47;
                  localAllInOne.discussUin = this.aI;
                  break;
                case 1003: 
                  localAllInOne.pa = 70;
                  break;
                  localAllInOne.pa = 117;
                  break;
                  localAllInOne.pa = 115;
                  break;
                  localAllInOne.pa = 86;
                  break;
                }
              }
              else
              {
                localAllInOne.pa = 34;
              }
            }
            else {
              localAllInOne.pa = 96;
            }
          }
          else {
            localAllInOne.pa = 76;
          }
        }
        else {
          localAllInOne.pa = 57;
        }
      }
      else {
        localAllInOne.pa = 42;
      }
    }
    else
    {
      localAllInOne.pa = 22;
      localAllInOne.troopUin = this.aI;
    }
    localAllInOne.reportExtra = NewReportPlugin.a(this.W, this.V);
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("start-profile: %s", new Object[] { localAllInOne.reportExtra }));
    }
    i1 = this.V;
    if ((i1 != 1001) && (i1 != 10002) && (i1 != 10004) && (i1 != 1010)) {
      if (i1 == 1022)
      {
        i1 = this.aM;
        if ((i1 == 3007) || (i1 == 2007) || (i1 == 4007) || (i1 == 3019) || (i1 == 2019)) {}
      }
      else
      {
        i1 = this.V;
        if ((i1 != 1044) && (i1 != 1045))
        {
          if (i1 == 10013)
          {
            ((IRIJPrivateChatService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IRIJPrivateChatService.class, "")).jumpKanDianProfilePage(this, this.W);
            return;
          }
          if (this.P.hasExtra("param_wzry_data"))
          {
            localObject = this.P.getSerializableExtra("param_wzry_data");
            if (localObject != null) {
              localAllInOne.extras.putSerializable("param_wzry_data", (Serializable)localObject);
            }
          }
          ProfileUtils.openProfileCardForResult(this, localAllInOne, 3);
          return;
        }
        ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).startExtendFriendCardOnClickAvatar(this, this.W, 22);
        return;
      }
    }
    Object localObject = new Intent();
    i1 = this.V;
    if (i1 == 1001)
    {
      localAllInOne.profileEntryType = 12;
      if (((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(this.W)) {
        ((Intent)localObject).putExtra("param_tiny_id", Long.valueOf(this.W));
      }
      ((Intent)localObject).putExtra("frome_where", 21);
    }
    else if (i1 == 10002)
    {
      ((Intent)localObject).putExtra("frome_where", 22);
    }
    else if (i1 == 1010)
    {
      localAllInOne.profileEntryType = 13;
    }
    else
    {
      localAllInOne.profileEntryType = 30;
    }
    ((Intent)localObject).putExtra("AllInOne", localAllInOne);
    if (Utils.a(this.W, this.app.getCurrentAccountUin())) {
      ((Intent)localObject).putExtra("param_mode", 2);
    } else {
      ((Intent)localObject).putExtra("param_mode", 3);
    }
    RouteUtils.a(this, (Intent)localObject, "/nearby/people/profile", 3);
  }
  
  private void L()
  {
    int i1 = this.V;
    Object localObject = null;
    int i2;
    if (i1 != 1009)
    {
      if (i1 != 1010)
      {
        if (i1 != 1036)
        {
          if (i1 != 10004)
          {
            if (i1 != 10010)
            {
              if (i1 != 10013) {
                if ((i1 != 1044) && (i1 != 1045))
                {
                  if (i1 != 10007)
                  {
                    if (i1 != 10008)
                    {
                      switch (i1)
                      {
                      default: 
                        switch (i1)
                        {
                        default: 
                          localObject = null;
                          i1 = 0;
                          i2 = 3999;
                          break;
                        case 1024: 
                          localObject = null;
                          i1 = 2;
                          i2 = 3072;
                          break;
                        case 1023: 
                          i1 = 11;
                          break;
                        case 1022: 
                          localObject = null;
                          i1 = 11;
                          i2 = 3041;
                          break;
                        case 1021: 
                          i1 = 2;
                        }
                        break;
                      case 1006: 
                        localObject = null;
                        i1 = 12;
                        i2 = 3006;
                        break;
                      case 1005: 
                        i1 = 12;
                        localObject = null;
                        i2 = 3008;
                        break;
                      case 1004: 
                        localObject = getIntent().getStringExtra("troop_uin");
                        i1 = 3;
                        i2 = 3005;
                        break;
                      case 1003: 
                        localObject = null;
                        i1 = 1;
                        i2 = 3071;
                        break;
                      case 1002: 
                        i1 = 0;
                        localObject = null;
                        i2 = 3003;
                        break;
                      case 1001: 
                        localObject = null;
                        i1 = 3;
                        i2 = 3007;
                        break;
                      }
                      localObject = getIntent().getStringExtra("troop_uin");
                      i1 = 3;
                      i2 = 3004;
                      break label434;
                    }
                    localObject = null;
                    i1 = 3;
                    i2 = 3080;
                    break label434;
                  }
                  localObject = getIntent().getStringExtra("appid");
                  this.Y = getIntent().getStringExtra("openid");
                }
                else
                {
                  i1 = this.P.getIntExtra("subId", 0);
                  localObject = null;
                  i2 = 3094;
                  break label434;
                }
              }
              i1 = 3;
              i2 = 3096;
            }
            else
            {
              localObject = null;
              i1 = 6;
              i2 = 3076;
            }
          }
          else
          {
            localObject = null;
            i1 = 3;
            i2 = 3043;
          }
        }
        else
        {
          localObject = null;
          i1 = 1;
          i2 = 3099;
        }
      }
      else
      {
        localObject = null;
        i1 = 0;
        i2 = 3019;
      }
    }
    else
    {
      localObject = null;
      i1 = 0;
      i2 = 3013;
    }
    label434:
    if (i2 == 3007)
    {
      if (!LBSHandler.a(this.app, this.W)) {
        b();
      }
    }
    else if ((i2 == 3019) && (!DatingUtil.a(this.app, this.W)))
    {
      b();
      return;
    }
    int i3 = this.V;
    if ((i3 != 3) && (i3 != 4000) && (i3 != 1006))
    {
      if (i3 == 10007) {
        localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this, 3, this.Y, (String)localObject, i2, i1, this.X, this.ab, null, setLastActivityName(), null);
      } else {
        localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this, 1, this.W, (String)localObject, i2, i1, this.X, null, null, setLastActivityName(), null);
      }
    }
    else {
      localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this, 2, this.aJ, null, i2, i1, this.X, null, null, setLastActivityName(), null);
    }
    if (i2 == 3094) {
      ((Intent)localObject).putExtra("entrance", 3);
    }
    if (localObject != null)
    {
      Serializable localSerializable = StrangerChatPie.a(this, this.V, false, false);
      if (localSerializable != null) {
        ((Intent)localObject).putExtra("param_wzry_data", localSerializable);
      }
    }
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this, (Intent)localObject);
  }
  
  private void M()
  {
    AllInOne localAllInOne = new AllInOne(this.W, 1);
    localAllInOne.nickname = ContactUtils.a(this.app, this.W);
    int i1 = this.V;
    if (3000 != i1)
    {
      localAllInOne.preWinUin = this.W;
      localAllInOne.preWinType = i1;
    }
    localAllInOne.lastActivity = 5;
    localAllInOne.profileEntryType = 61;
    localAllInOne.reportExtra = NewReportPlugin.a(this.W, this.V);
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("start-profile: %s", new Object[] { localAllInOne.reportExtra }));
    }
    ProfileUtils.openProfileCardForResult(this, localAllInOne, 3);
  }
  
  private void N()
  {
    QQProgressDialog localQQProgressDialog = this.aK;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        this.aK.cancel();
        this.aK = null;
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void O()
  {
    ChatSettingActivity.25 local25 = new ChatSettingActivity.25(this);
    if (!this.aP) {
      ThreadManager.post(local25, 8, null, true);
    }
  }
  
  private void P()
  {
    MutualMarkIconsView localMutualMarkIconsView;
    if (this.V == 0)
    {
      localMutualMarkIconsView = this.g;
      if (localMutualMarkIconsView != null) {
        localMutualMarkIconsView.a(this.app, this.W, 2);
      }
    }
    else
    {
      localMutualMarkIconsView = this.g;
      if (localMutualMarkIconsView != null) {
        localMutualMarkIconsView.setVisibility(8);
      }
    }
  }
  
  private void Q()
  {
    boolean bool = FriendsStatusUtil.a(this.W, this.app);
    FormSwitchItem localFormSwitchItem = this.n;
    if (localFormSwitchItem != null)
    {
      localFormSwitchItem.setOnCheckedChangeListener(null);
      this.n.setChecked(bool);
      a();
      this.n.setOnCheckedChangeListener(this);
      if (AppSetting.e) {
        this.n.setContentDescription(getString(2131891959));
      }
    }
  }
  
  private void R()
  {
    boolean bool = HiddenChatHelper.a(this.W, this.app);
    FormSwitchItem localFormSwitchItem = this.p;
    if (localFormSwitchItem != null)
    {
      localFormSwitchItem.setOnCheckedChangeListener(null);
      this.p.setChecked(bool);
      a();
      localFormSwitchItem = this.n;
      int i1;
      if ((!this.p.a()) && (!this.q.a())) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localFormSwitchItem.setVisibility(i1);
      this.p.setOnCheckedChangeListener(this);
    }
  }
  
  private int a(String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    SQLiteDatabase localSQLiteDatabase = this.app.getReadableDatabase();
    if (localSQLiteDatabase == null) {
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder(" where msgtype != ");
    localStringBuilder.append(-2006);
    paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString());
    if (paramString == null) {
      return 0;
    }
    paramString = localSQLiteDatabase.rawQuery(paramString.toString(), null);
    if (paramString == null) {
      return 0;
    }
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      long l1;
      if (paramInt == 3000) {
        l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else if (paramInt == 0) {
        l1 = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l1 = 0L;
      }
      if (l1 > 0L) {
        paramStringBuilder.append(String.valueOf(l1));
      }
    }
    paramInt = paramString.getCount();
    paramString.close();
    return paramInt;
  }
  
  private TextView a(View paramView1, View paramView2)
  {
    if ((paramView1 != null) && (paramView2 != null))
    {
      if (!(paramView2 instanceof ViewGroup)) {
        return null;
      }
      TextView localTextView = (TextView)paramView1.findViewById(2131446424);
      if (localTextView == null) {
        return null;
      }
      ((ViewGroup)paramView1).removeView(localTextView);
      paramView1 = localTextView.getLayoutParams();
      if ((paramView1 instanceof LinearLayout.LayoutParams)) {
        ((LinearLayout.LayoutParams)paramView1).setMargins(0, AIOUtils.b(5.0F, getResources()), 0, 0);
      }
      ((ViewGroup)paramView2).addView(localTextView);
      return localTextView;
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.makeText(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(getTitleBarHeight());
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.aj) {
      return;
    }
    if (paramInt == -1)
    {
      QQToast.makeText(this, paramString, 0).show(getTitleBarHeight());
      return;
    }
    QQToast.makeText(this, paramInt, paramString, 0).show(getTitleBarHeight());
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("result");
    } else {
      paramIntent = null;
    }
    Object localObject = paramIntent;
    if (paramIntent == null) {
      localObject = "";
    }
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (!((String)localObject).equals(this.am))
      {
        paramIntent = this.O;
        if (paramIntent != null)
        {
          paramIntent.setFriendComment(this.W, (String)localObject, false);
          this.ao |= 0x1;
          d((String)localObject);
          k(getString(2131887706));
          this.T.show();
          return;
        }
        a(2131890911, 1);
        return;
      }
      a(2131890897, 0);
      return;
    }
    a(2131892155, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, ChatSettingActivity.DeleteHistoryListener paramDeleteHistoryListener, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "startDelAllMsg......");
    }
    DeleteRecordDialog localDeleteRecordDialog = new DeleteRecordDialog(paramActivity, paramQQAppInterface, true);
    localDeleteRecordDialog.a(new ChatSettingActivity.29(paramDeleteHistoryListener, paramQQAppInterface, paramString, paramInt1, paramActivity));
    localDeleteRecordDialog.a(paramInt2);
  }
  
  private void a(RichStatus paramRichStatus, TextView paramTextView)
  {
    this.F = paramRichStatus;
    this.E = paramTextView;
    if (paramRichStatus != null)
    {
      if (paramTextView == null) {
        return;
      }
      Object localObject = paramRichStatus.toSpannableString(null);
      if (!TextUtils.isEmpty(paramRichStatus.actionText))
      {
        localObject = new SpannableStringBuilder((CharSequence)localObject);
        ((SpannableStringBuilder)localObject).insert(0, "[S] ");
        StatusManager localStatusManager = (StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER);
        if (localStatusManager != null) {
          paramRichStatus = localStatusManager.a(paramRichStatus.actionId, 200);
        } else {
          paramRichStatus = BitmapManager.a(getResources(), 2130851609);
        }
        paramRichStatus = new StatableBitmapDrawable(getResources(), paramRichStatus, false, false);
        int i1 = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramRichStatus.setBounds(0, 0, i1, i1);
        paramRichStatus = new OffsetableImageSpan(paramRichStatus, 0);
        paramRichStatus.setOffset(-0.1F);
        ((SpannableStringBuilder)localObject).setSpan(paramRichStatus, 0, 3, 17);
        paramTextView.setVisibility(0);
        paramTextView.setText((CharSequence)localObject);
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramTextView.setVisibility(0);
        paramTextView.setText((CharSequence)localObject);
        return;
      }
      paramTextView.setVisibility(8);
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.as.setImageDrawable(RecentRIJPrivateChatItemBuilder.j);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = RecentRIJPrivateChatItemBuilder.j;
    localURLDrawableOptions.mFailedDrawable = RecentRIJPrivateChatItemBuilder.j;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(URLDrawableDecodeHandler.a(ViewUtils.dip2px(50.0F), ViewUtils.dip2px(50.0F)));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.c);
    this.as.setImageDrawable(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    QQToast.makeText(BaseApplication.getContext(), paramInt, paramString, 0).show(getTitleBarHeight());
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt != 1009) && (paramInt != 1036) && (paramInt != 10002) && (paramInt != 10004) && (paramInt != 10010) && (paramInt != 10013) && (paramInt != 1044) && (paramInt != 1045) && (paramInt != 10007) && (paramInt != 10008)) {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return false;
        }
        break;
      }
    }
    return true;
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    int i1 = paramIntent.getByteExtra("result", (byte)0);
    paramIntent = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).u(String.valueOf(i1));
    if (paramIntent != null) {
      e(paramIntent.group_name);
    }
  }
  
  private void b(String paramString)
  {
    NowSummaryCard.NearbyUserFollowReq localNearbyUserFollowReq = new NowSummaryCard.NearbyUserFollowReq();
    localNearbyUserFollowReq.from.set(0);
    localNearbyUserFollowReq.id_type.set(0);
    localNearbyUserFollowReq.target_id.set(Long.valueOf(this.W).longValue());
    localNearbyUserFollowReq.operation.set(Integer.valueOf(paramString).intValue());
    ProtoUtils.a(this.app, new ChatSettingActivity.6(this, paramString), localNearbyUserFollowReq.toByteArray(), "NowSummaryCard.NearbyUserFollow");
  }
  
  private void c(String paramString)
  {
    QQAppInterface localQQAppInterface = this.app;
    String str2 = this.W;
    String str1;
    if (this.V == 1001) {
      str1 = "2";
    } else {
      str1 = "1";
    }
    int i1 = this.V;
    NearbyHandler.a(localQQAppInterface, str2, str1, paramString, 3, new ChatSettingActivity.7(this, paramString));
  }
  
  private void d(String paramString)
  {
    if (this.e != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.e.setText(paramString);
        return;
      }
      paramString = ContactUtils.a(this.app, this.W);
      this.e.setText(paramString);
    }
  }
  
  private void e(String paramString)
  {
    TextView localTextView = this.A;
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(paramString);
    }
  }
  
  private RichStatus f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(paramString);
    if (paramString != null) {
      return ExtensionRichStatus.c(paramString);
    }
    return null;
  }
  
  private String g(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject3 = null;
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Object localObject4 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = localObject3;
    if (localObject4 != null)
    {
      localObject4 = ((FriendsManager)localObject4).m(paramString);
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        paramString = localObject2;
        if (((Friends)localObject4).remark != null) {
          paramString = ((Friends)localObject4).remark;
        }
        localObject1 = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          localObject1 = paramString;
          if (!TextUtils.isEmpty(((Friends)localObject4).name)) {
            localObject1 = ((Friends)localObject4).name;
          }
        }
      }
    }
    return localObject1;
  }
  
  private void g()
  {
    this.O = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
  }
  
  private String h(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    Object localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Friends localFriends = ((FriendsManager)localObject2).m(paramString);
    paramString = localObject1;
    if (localFriends != null)
    {
      paramString = new StringBuilder();
      paramString.append(localFriends.groupid);
      paramString.append("");
      localObject2 = ((FriendsManager)localObject2).u(paramString.toString());
      paramString = localObject1;
      if (localObject2 != null) {
        paramString = ((Groups)localObject2).group_name;
      }
    }
    return paramString;
  }
  
  private void h()
  {
    addObserver(this.H);
    addObserver(this.I);
    addObserver(this.L);
    addObserver(this.aX);
    addObserver(this.J);
    addObserver(this.K);
    addObserver(this.aU);
    addObserver(this.aV);
    addObserver(this.C);
    addObserver(this.D);
    addObserver(this.aS);
    this.app.registObserver(this.aT);
    this.app.setHandler(ChatSettingActivity.class, this.G);
    StatusManager localStatusManager = (StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null) {
      localStatusManager.a(this.aY);
    }
  }
  
  private void i()
  {
    removeObserver(this.I);
    removeObserver(this.H);
    removeObserver(this.L);
    removeObserver(this.aX);
    removeObserver(this.J);
    removeObserver(this.K);
    removeObserver(this.aU);
    removeObserver(this.aV);
    removeObserver(this.C);
    removeObserver(this.D);
    removeObserver(this.aS);
    this.app.unRegistObserver(this.aT);
    this.app.removeHandler(ChatSettingActivity.class);
    StatusManager localStatusManager = (StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null)
    {
      localStatusManager.b(this.aY);
      return;
    }
    this.aY = null;
  }
  
  private void i(String paramString)
  {
    Object localObject = this.app.getMessageFacade().h(this.W, this.V);
    long l1;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).isSendFromLocal()) {
        l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time + 2L;
      } else {
        l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time;
      }
    }
    else {
      l1 = 0L;
    }
    this.app.getMessageFacade().c(this.W, this.V);
    this.app.getMessageFacade().g(this.W, this.V);
    this.app.getFileManagerDataCenter().a(this.W, this.V);
    if (paramString != null)
    {
      long l2;
      try
      {
        l2 = Long.parseLong(paramString);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        l2 = 0L;
      }
      l1 = Math.max(l2, l1);
      if (l1 > 0L) {
        this.app.getMsgCache().a(this.W, this.V, l1);
      }
    }
    paramString = this.app.getHandler(Conversation.class);
    localObject = paramString.obtainMessage(1017);
    ((Message)localObject).obj = this.W;
    ((Message)localObject).arg1 = this.V;
    paramString.sendMessage((Message)localObject);
  }
  
  private void j()
  {
    this.W = this.P.getStringExtra("uin");
    this.X = this.P.getStringExtra("uinname");
    if (this.X == null) {
      this.X = this.W;
    }
    this.V = this.P.getIntExtra("uintype", -1);
    this.b = this.P.getBooleanExtra("follow_flag", false);
    if ((this.V == 0) && (!l(this.W))) {
      this.V = 1003;
    }
    int i1 = this.V;
    if ((1 == i1) || (1000 == i1) || (1004 == i1)) {
      this.ad = this.P.getStringExtra("troop_uin");
    }
    this.aM = this.P.getIntExtra("add_friend_source_id", 3999);
    this.al = this.P.getStringExtra("real_troop_uin");
    this.B = VasUtil.a().getSpecialSoundManager();
  }
  
  private void j(String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(this);
    if (Utils.c(paramString)) {
      localActionSheet.setMainTitle(2131887543);
    } else if (MutualMarkDataCenter.b(this.app, this.W, true)) {
      localActionSheet.setMainTitle(2131887545);
    } else {
      localActionSheet.setMainTitle(2131887544);
    }
    localActionSheet.addButton(2131888447, 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new ChatSettingActivity.17(this, paramString, localActionSheet));
    localActionSheet.show();
  }
  
  private void k()
  {
    this.ak = getResources().getDisplayMetrics().density;
    int i1 = this.V;
    if (i1 != 0)
    {
      if ((i1 != 1) && (i1 != 2) && (i1 != 3000)) {
        q();
      }
    }
    else {
      m();
    }
    setTitle(2131887747);
    setLeftViewName(2131887440);
    setContentBackgroundResource(2130838958);
  }
  
  private void k(String paramString)
  {
    this.T = new QQProgressDialog(this, getTitleBarHeight());
    this.T.setContentView(2131629210);
    if ((paramString != null) && (!"".equals(paramString.trim())))
    {
      this.T.a(paramString);
      return;
    }
    this.T.a(getString(2131916272));
  }
  
  private void l()
  {
    IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)QQStoryContext.k().getRuntimeService(IWebProcessManagerService.class, "multi");
    if ((localIWebProcessManagerService != null) && (localIWebProcessManagerService.isNeedPreloadWebProcess()))
    {
      localIWebProcessManagerService.startWebProcess(-1, null);
      if (QLog.isColorLevel()) {
        QLog.d(this.M, 2, "start preloadWebProcess");
      }
    }
  }
  
  private boolean l(String paramString)
  {
    return ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramString);
  }
  
  private void m()
  {
    this.R = ((XListView)View.inflate(this, 2131625212, null));
    try
    {
      this.R.setBackgroundResource(2130838958);
    }
    catch (Throwable localThrowable)
    {
      QLog.i(this.M, 1, localThrowable.toString());
    }
    this.R.setDivider(null);
    this.R.setVerticalScrollBarEnabled(false);
    try
    {
      this.Q = View.inflate(this, 2131624464, null);
      this.R.setPadding(0, 0, 0, 0);
      this.S = new XSimpleListAdapter(this.Q);
      this.R.setAdapter(this.S);
      super.setContentView(this.R);
      this.c = ((RelativeLayout)this.Q.findViewById(2131433695));
      this.d = ((ImageView)this.Q.findViewById(2131433694));
      this.e = ((TextView)this.Q.findViewById(2131433696));
      this.f = ((ImageView)this.Q.findViewById(2131449926));
      this.g = ((MutualMarkIconsView)this.Q.findViewById(2131439085));
      this.h = ((RelativeLayout)this.Q.findViewById(2131431513));
      this.i = ((FormSimpleItem)this.Q.findViewById(2131446027));
      this.l = ((FormSimpleItem)this.Q.findViewById(2131430551));
      this.m = ((FormSimpleItem)this.Q.findViewById(2131445673));
      this.t = ((FormSwitchItem)this.Q.findViewById(2131430218));
      this.u = ((TextView)this.Q.findViewById(2131430232));
      this.k = ((FormSimpleItem)this.Q.findViewById(2131427774));
      this.z = ((TextView)this.Q.findViewById(2131431710));
      this.y = ((TextView)this.Q.findViewById(2131444617));
      this.j = ((FormSimpleItem)this.Q.findViewById(2131446207));
      this.s = ((FormSwitchItem)this.Q.findViewById(2131445679));
      this.n = ((FormSwitchItem)this.Q.findViewById(2131445674));
      this.o = ((FormSimpleItem)this.Q.findViewById(2131445676));
      this.p = ((FormSwitchItem)this.Q.findViewById(2131445675));
      this.q = ((FormSwitchItem)this.Q.findViewById(2131445677));
      this.r = ((FormSwitchItem)this.Q.findViewById(2131445672));
      this.v = ((TextView)this.Q.findViewById(2131430217));
      this.w = ((ViewGroup)this.Q.findViewById(2131445087));
      this.x = ((TextView)this.Q.findViewById(2131445088));
      this.Q.findViewById(2131431717).setOnClickListener(this);
      this.z.setBackgroundResource(2130839622);
      this.Q.findViewById(2131445081).setOnClickListener(this);
      this.w.setOnClickListener(this);
      this.c.setOnClickListener(this);
      this.f.setOnClickListener(this);
      this.h.setOnClickListener(this);
      this.j.setOnClickListener(this);
      this.o.setOnClickListener(this);
      this.n.setOnCheckedChangeListener(this);
      this.p.setOnCheckedChangeListener(this);
      this.q.setOnCheckedChangeListener(this);
      boolean bool = C2CShortcutBarSwitcher.b(this.app);
      Object localObject1 = this.t;
      if (bool) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((FormSwitchItem)localObject1).setVisibility(i1);
      localObject1 = this.u;
      if (bool) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((TextView)localObject1).setVisibility(i1);
      if (bool)
      {
        this.t.setChecked(C2CShortcutBarSwitcher.a(this.app, this.W));
        this.t.setOnCheckedChangeListener(this);
        ReportController.b(this.app, "dc00898", "", "", "0X800B330", "0X800B330", C2CShortcutBarManager.a(this.app).a(this.W), 0, "", "", "", "");
      }
      this.s.setChecked(FriendsStatusUtil.a(this.app, this.W, this.V));
      this.s.setOnCheckedChangeListener(this);
      this.z.setOnClickListener(this);
      this.y.setOnClickListener(this);
      this.l.setOnClickListener(this);
      this.m.setOnClickListener(this);
      this.v.setOnClickListener(this);
      this.i.setOnClickListener(this);
      if (Build.VERSION.SDK_INT <= 25)
      {
        this.k.setVisibility(0);
        this.k.setOnClickListener(this);
      }
      else
      {
        this.k.setVisibility(8);
      }
      if (AppSetting.e)
      {
        this.c.setContentDescription(getString(2131890915));
        this.h.setContentDescription(getString(2131886276));
        this.l.setContentDescription(getString(2131887726));
        this.m.setContentDescription(getString(2131916289));
        this.j.setContentDescription(getString(2131914364));
        localObject1 = this.o;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(getString(2131892201));
        ((StringBuilder)localObject2).append(getString(2131916309));
        ((FormSimpleItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
        this.n.setContentDescription(getString(2131891959));
        this.p.setContentDescription(getString(2131894125));
        this.q.setContentDescription(getString(2131887781));
        this.s.setContentDescription(getString(2131892883));
        this.r.setContentDescription(getString(2131892877));
        this.k.setContentDescription(getString(2131886242));
        this.z.setContentDescription(getString(2131888447));
        this.y.setContentDescription("从过滤消息移出");
        this.v.setContentDescription(getString(2131886147));
        this.i.setContentDescription(HardCodeUtil.a(2131916687));
      }
      this.am = g(this.W);
      if (this.am == null) {
        this.am = "";
      }
      d(this.am);
      localObject1 = this.am;
      if (localObject1 != null) {
        this.e.setText((CharSequence)localObject1);
      }
      Object localObject2 = VipUtils.VipIconUtils.a(this.app, this.W);
      bool = VipUtils.VipIconUtils.a(localObject2[0]);
      if (bool)
      {
        localObject1 = VipUtils.VipIconUtils.NamePlateVipTpye.a(localObject2[0]);
        if ((!VipUtils.VipIconUtils.b(localObject2[1])) && (!((VipUtils.VipIconUtils.NamePlateVipTpye)localObject1).a()))
        {
          localObject2 = VipUtils.VipIconUtils.a(this.app, this.W, (VipUtils.VipIconUtils.NamePlateVipTpye)localObject1, false);
          VipUtils.a(getResources(), this.f, (String)localObject2, getResources().getDrawable(VipUtils.VipIconUtils.a((VipUtils.VipIconUtils.NamePlateVipTpye)localObject1)));
        }
      }
      VipUtils.VipIconUtils.VipIconTouchListener.a(this.app, this.W, "VIA_AIO_CHATSETTINGS").a();
      int i1 = VipUtils.b(this.app, this.W);
      if (QLog.isColorLevel())
      {
        localObject1 = this.M;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("bindView: vip=");
        ((StringBuilder)localObject2).append(i1);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      int i2 = i1 >> 8;
      if ((i2 == 3) && (!SimpleUIUtil.e()))
      {
        localObject1 = VipUtils.VipIconUtils.a(this.app, this.W, EVIPSPEC.E_SP_BIGCLUB);
        if ((i1 & 0xF) == 1)
        {
          this.e.setTextColor(getResources().getColor(2131168187));
          if (!bool) {
            VipUtils.a(getResources(), this.f, (String)localObject1, getResources().getDrawable(2130848951));
          }
        }
        else
        {
          this.e.setTextColor(getResources().getColor(2131168187));
          if (!bool) {
            VipUtils.a(getResources(), this.f, (String)localObject1, getResources().getDrawable(2130848949));
          }
        }
        NamePlateCfgInfo.vipNamePlateExposeReport(this.app, this.W);
        this.e.setMaxWidth(VipUtils.e(1));
        this.f.setVisibility(0);
      }
      else if ((i2 == 1) && (!SimpleUIUtil.e()))
      {
        this.e.setTextColor(getResources().getColor(2131168187));
        this.e.setMaxWidth(VipUtils.e(0));
        this.f.setVisibility(8);
      }
      else if ((i2 == 2) && (!SimpleUIUtil.e()))
      {
        localObject1 = VipUtils.VipIconUtils.a(this.app, this.W, EVIPSPEC.E_SP_SUPERVIP);
        if ((i1 & 0xF) == 1)
        {
          this.e.setTextColor(getResources().getColor(2131168187));
          if (!bool) {
            VipUtils.a(getResources(), this.f, (String)localObject1, getResources().getDrawable(2130848951));
          }
        }
        else
        {
          this.e.setTextColor(getResources().getColor(2131168187));
          if (!bool) {
            VipUtils.a(getResources(), this.f, (String)localObject1, getResources().getDrawable(2130848949));
          }
        }
        this.e.setMaxWidth(VipUtils.e(1));
        this.f.setVisibility(0);
      }
      else
      {
        this.e.setMaxWidth(VipUtils.e(0));
        this.f.setVisibility(8);
      }
      if (this.W != null)
      {
        localObject1 = FaceDrawable.getUserFaceDrawable(this.app, this.W, (byte)3);
        this.d.setImageDrawable((Drawable)localObject1);
      }
      this.an = h(this.W);
      if (this.an == null) {
        this.an = "";
      }
      e(this.an);
      B();
      if (!n()) {
        this.y.setVisibility(8);
      }
      if (Utils.c(this.W))
      {
        this.h.setVisibility(8);
        this.l.setVisibility(8);
        this.j.setVisibility(8);
        this.q.setVisibility(8);
        this.n.setVisibility(8);
        this.p.setVisibility(8);
        this.k.setVisibility(8);
        this.v.setVisibility(8);
        this.i.setVisibility(8);
        localObject1 = (LinearLayout.LayoutParams)this.m.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this, 20.0F);
        this.m.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.r.setVisibility(0);
        localObject1 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).g(AppConstants.BABY_Q_UIN);
        this.r.setChecked(((Card)localObject1).babyQSwitch);
        this.r.setOnCheckedChangeListener(this);
        localObject1 = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.app, TempGetProfileDetailProcessor.class);
        if (localObject1 != null) {
          ((TempGetProfileDetailProcessor)localObject1).getBabyQSwitch();
        }
      }
      else
      {
        this.r.setVisibility(8);
      }
      if (QidianManager.a(this.app, this.W)) {
        this.h.setVisibility(8);
      }
      if (this.app != null)
      {
        I();
        P();
        Q();
      }
      R();
      if (this.app.getCurrentUin().equals(this.W))
      {
        this.j.setVisibility(8);
        this.n.setVisibility(8);
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        this.z.setVisibility(8);
        this.v.setVisibility(8);
        this.i.setVisibility(8);
        this.o.setVisibility(8);
      }
      if (!l(this.W)) {
        this.i.setVisibility(8);
      }
      o();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private boolean n()
  {
    if (TextUtils.isEmpty(this.app.getAccount()))
    {
      QLog.e(this.M, 1, "isNeedShowFilterMsgView() called, getAccount() is null");
      return false;
    }
    ITempMsgBoxManager localITempMsgBoxManager = (ITempMsgBoxManager)this.app.getRuntimeService(ITempMsgBoxManager.class, "");
    return (localITempMsgBoxManager != null) && (localITempMsgBoxManager.isBelongToFilterBox(this.W, 0));
  }
  
  private void o()
  {
    Object localObject = this.i;
    if (localObject == null) {
      return;
    }
    if (((FormSimpleItem)localObject).getVisibility() != 0) {
      return;
    }
    localObject = ((SingTogetherConfigBean)QConfigManager.b().b(551)).a(4);
    if ((localObject != null) && (((SingTogetherConfigBean.GeneralTogetherItem)localObject).a))
    {
      this.i.setVisibility(0);
      boolean bool = ((TogetherControlManager)this.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).b(4, 2, this.W);
      FormSimpleItem localFormSimpleItem = this.i;
      if (bool) {
        localObject = "已开启";
      } else {
        localObject = "未开启";
      }
      localFormSimpleItem.setRightText((CharSequence)localObject);
      if (TogetherUtils.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_RED_DOT_SHOW", true, false))
      {
        this.i.setRightIcon(getResources().getDrawable(2130842281));
        return;
      }
      this.i.setRightIcon(null);
      return;
    }
    this.i.setVisibility(8);
  }
  
  private boolean p()
  {
    return this.V == 1001;
  }
  
  private void q()
  {
    Object localObject1 = View.inflate(this, 2131624466, null);
    this.R = ((XListView)((View)localObject1).findViewById(2131431170));
    this.R.setPadding(0, 0, 0, 0);
    this.R.setDivider(null);
    this.R.setVerticalScrollBarEnabled(false);
    this.Q = View.inflate(this, 2131624465, null);
    this.S = new XSimpleListAdapter(this.Q);
    this.R.setAdapter(this.S);
    super.setContentView((View)localObject1);
    this.U = this.Q.findViewById(2131446421);
    this.ar = ((RelativeLayout)this.Q.findViewById(2131446423));
    this.aq = ((FormSimpleItem)this.Q.findViewById(2131430770));
    this.as = ((ImageView)this.Q.findViewById(2131446422));
    this.at = ((TextView)this.Q.findViewById(2131446419));
    this.au = ((FormSwitchItem)this.Q.findViewById(2131445678));
    this.av = ((FormSwitchItem)this.Q.findViewById(2131445687));
    this.aw = ((FormSimpleItem)this.Q.findViewById(2131447314));
    this.ax = ((TextView)this.Q.findViewById(2131447315));
    this.aQ = ((TextView)this.Q.findViewById(2131444618));
    this.ay = ((Button)this.Q.findViewById(2131446420));
    this.az = ((Button)this.Q.findViewById(2131430039));
    this.az.setBackgroundResource(2130839622);
    this.av.setVisibility(8);
    if (p()) {
      this.au.setVisibility(8);
    }
    if (this.V == 1036)
    {
      if (l(this.W))
      {
        this.ay.setVisibility(8);
        this.az.setVisibility(0);
        this.az.setOnClickListener(this);
        this.au.setVisibility(8);
      }
      this.aq.setVisibility(8);
    }
    else
    {
      this.aq.setVisibility(0);
      this.ay.setVisibility(0);
      this.az.setVisibility(8);
    }
    int i1 = this.V;
    if ((1001 == i1) || (10002 == i1)) {
      H();
    }
    i1 = this.V;
    if ((i1 == 1044) || (i1 == 1045))
    {
      this.aA = a((View)localObject1, this.Q);
      r();
    }
    if (!n()) {
      this.aQ.setVisibility(8);
    }
    this.aQ.setOnClickListener(this);
    if (this.aA == null) {
      this.aA = ((TextView)((View)localObject1).findViewById(2131446424));
    }
    if (AppSetting.e)
    {
      this.ar.setContentDescription(getString(2131890915));
      this.aq.setContentDescription(getString(2131887779));
      this.au.setContentDescription(getString(2131887781));
      this.av.setContentDescription(getString(2131887781));
      localObject2 = this.ay;
      i1 = this.V;
      if ((1001 != i1) && (10002 != i1)) {
        i1 = 2131887778;
      } else if (this.b) {
        i1 = 2131894141;
      } else {
        i1 = 2131894139;
      }
      ((Button)localObject2).setContentDescription(getString(i1));
      this.aA.setContentDescription(getString(2131886148));
      this.aQ.setContentDescription("从过滤消息移出");
    }
    if (this.V == 10004)
    {
      this.ar.setContentDescription("");
      this.U.setVisibility(8);
    }
    else
    {
      this.ar.setOnClickListener(this);
    }
    this.aq.setOnClickListener(this);
    this.aA.setOnClickListener(this);
    if (this.V == 1006)
    {
      localObject2 = this.P;
      if ((localObject2 != null) && (((Intent)localObject2).getBooleanExtra("isShieldMsgSwitchUnClickable", false)))
      {
        this.au.setClickable(false);
        this.au.setEnabled(false);
        localObject2 = this.au.getSwitch();
        if (localObject2 == null) {
          break label825;
        }
        ((Switch)localObject2).setEnabled(false);
        break label825;
      }
    }
    this.au.setClickable(true);
    this.au.setEnabled(true);
    this.au.setOnCheckedChangeListener(this);
    label825:
    this.ay.setOnClickListener(this);
    this.aA.setOnClickListener(this);
    i1 = this.V;
    if ((i1 != 1010) && (i1 != 1001) && (i1 != 10002)) {
      if (i1 == 1022)
      {
        i1 = this.aM;
        if ((i1 == 3007) || (i1 == 2007) || (i1 == 4007) || (i1 == 3019) || (i1 == 2019)) {}
      }
      else
      {
        i1 = this.V;
        if (i1 == 1006)
        {
          localObject2 = FaceDrawable.getMobileFaceDrawable(this.app, this.W, (byte)3);
          this.as.setImageDrawable((Drawable)localObject2);
          break label1091;
        }
        if (i1 == 10013)
        {
          t();
          break label1091;
        }
        localObject2 = FaceDrawable.getFaceDrawable(this.app, 1, this.W);
        this.aN = new WeakReference(localObject2);
        this.as.setImageDrawable((Drawable)localObject2);
        break label1091;
      }
    }
    if (((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(this.W)) {
      i1 = 202;
    } else {
      i1 = 200;
    }
    Object localObject2 = FaceDrawable.getStrangerFaceDrawable(this.app, i1, this.W, true);
    this.aN = new WeakReference(localObject2);
    this.as.setImageDrawable((Drawable)localObject2);
    if (this.V == 1001) {
      s();
    }
    label1091:
    this.aG = this.W;
    boolean bool;
    if (this.V == 10007)
    {
      this.aA = a((View)localObject1, this.Q);
      this.at.setVisibility(8);
      this.as.setVisibility(8);
      this.as.setVisibility(8);
      this.ar.setVisibility(8);
      this.aq.setVisibility(8);
      this.au.setVisibility(8);
      this.av.setVisibility(0);
      this.av.setOnCheckedChangeListener(this);
      this.aG = this.P.getStringExtra("account");
      this.Y = this.P.getStringExtra("openid");
      this.Z = this.P.getStringExtra("game_msg_friend_role_id");
      this.aa = this.P.getStringExtra("game_msg_my_role_id");
      this.ac = this.P.getIntExtra("game_chatpie_hashcode", 0);
      if (this.P.getIntExtra("game_is_shiled", 0) == 2) {
        bool = true;
      } else {
        bool = false;
      }
      this.aE = bool;
      this.av.setChecked(this.aE);
      this.ab = this.P.getStringExtra("game_msg");
      this.ay.setText(2131889886);
      if (l(this.aG)) {
        this.ay.setVisibility(8);
      }
    }
    i1 = this.V;
    if ((i1 == 1000) || (i1 == 1004)) {
      this.aI = this.P.getStringExtra("troop_uin");
    }
    i1 = this.V;
    Object localObject3;
    if ((i1 != 1001) && (i1 != 10002))
    {
      if (i1 == 1006)
      {
        this.aJ = this.W;
        if (TextUtils.isEmpty(this.aJ))
        {
          this.aF = false;
        }
        else
        {
          localObject1 = ContactUtils.b(this.app, this.aJ);
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            this.aF = false;
          }
          else
          {
            this.aF = true;
            this.aG = ((String)localObject1);
          }
        }
      }
      localObject1 = (ShieldMsgManger)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if ((localObject1 != null) && (!TextUtils.isEmpty(this.aG))) {
        this.aD = ((ShieldMsgManger)localObject1).a(this.aG);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = this.a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("initStrangerView, shieldMsgManger=");
        if (localObject1 == null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject3).append(bool);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
    else
    {
      localObject1 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(this.aG);
      if (QLog.isColorLevel())
      {
        localObject2 = this.a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("initStrangerView, f=");
        if (localObject1 == null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject3).append(bool);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      if ((localObject1 != null) && (((Friends)localObject1).groupid == -1002)) {
        this.aD = true;
      } else {
        this.aD = false;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initStrangerView, curType=");
      ((StringBuilder)localObject2).append(this.V);
      ((StringBuilder)localObject2).append(", mShieldUin=");
      ((StringBuilder)localObject2).append(this.aG);
      ((StringBuilder)localObject2).append(", mIsShield=");
      ((StringBuilder)localObject2).append(this.aD);
      ((StringBuilder)localObject2).append(", mShieldEnable=");
      ((StringBuilder)localObject2).append(this.aF);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (a(this.V)) {
      this.aA.setVisibility(0);
    } else {
      this.aA.setVisibility(8);
    }
    this.at.setText(this.X);
    this.aL = true;
    G();
    localObject1 = new String[1];
    localObject1[0] = this.W;
    if (this.O == null) {
      g();
    }
    i1 = this.V;
    if ((i1 != 1010) && (i1 != 1001) && (i1 != 10002) && (i1 != 10004)) {
      if (i1 == 1022)
      {
        i1 = this.aM;
        if ((i1 == 3007) || (i1 == 2007) || (i1 == 4007) || (i1 == 3019) || (i1 == 2019)) {}
      }
      else
      {
        this.O.getStrangerRichStatus((String[])localObject1, false);
        break label1960;
      }
    }
    this.O.getStrangerRichStatus((String[])localObject1, true);
    label1960:
    i1 = this.V;
    if ((i1 == 1001) || (i1 == 10002))
    {
      QQAppInterface localQQAppInterface = this.app;
      if (this.V == 1001) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      if (this.b) {
        localObject2 = "0";
      } else {
        localObject2 = "1";
      }
      if (this.aD) {
        localObject3 = "0";
      } else {
        localObject3 = "1";
      }
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_set", 0, 0, (String)localObject1, (String)localObject2, (String)localObject3, "");
    }
    i1 = this.V;
    if ((i1 == 1044) || (i1 == 1045)) {
      this.aq.setVisibility(8);
    }
  }
  
  private void r()
  {
    int i1 = ((IExpandManager)this.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).Q();
    int i3 = 1;
    int i4 = 0;
    if ((i1 > 0) && (((IColdPalaceUtils)QRoute.api(IColdPalaceUtils.class)).getSvrShowGrayTipEntry(this.app))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject = this.aw;
    int i5 = 8;
    if (i1 != 0) {
      i2 = 0;
    } else {
      i2 = 8;
    }
    ((FormSimpleItem)localObject).setVisibility(i2);
    localObject = this.ax;
    int i2 = i5;
    if (i1 != 0) {
      i2 = 0;
    }
    ((TextView)localObject).setVisibility(i2);
    FormSimpleItem localFormSimpleItem = this.aw;
    if (i1 != 0) {
      localObject = this;
    } else {
      localObject = null;
    }
    localFormSimpleItem.setOnClickListener((View.OnClickListener)localObject);
    localObject = (ViewGroup.MarginLayoutParams)this.au.getLayoutParams();
    i5 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
    i2 = i4;
    if (i1 != 0) {
      i2 = AIOUtils.b(12.0F, getResources());
    }
    ((ViewGroup.MarginLayoutParams)localObject).setMargins(i5, i2, ((ViewGroup.MarginLayoutParams)localObject).rightMargin, ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
    localObject = this.au;
    if (i1 != 0) {
      i1 = i3;
    } else {
      i1 = 3;
    }
    ((FormSwitchItem)localObject).setBgType(i1);
  }
  
  private void s()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(this.W));
    boolean bool = ((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(this.W);
    ((IMiniCardManager)this.app.getManager(QQManagerFactory.MINI_CARD_MANAGER)).a(localArrayList, bool ^ true, new ChatSettingActivity.3(this));
  }
  
  private void t()
  {
    long l1;
    try
    {
      l1 = Long.parseLong(this.W);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      String str = this.M;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateRIJAvatar] mCurUin = ");
      localStringBuilder.append(this.W);
      localStringBuilder.append("e = ");
      localStringBuilder.append(localNumberFormatException);
      QLog.i(str, 1, localStringBuilder.toString());
      l1 = 0L;
    }
    if (l1 == 0L) {
      return;
    }
    ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getSingleKDUserInfo(l1, new ChatSettingActivity.4(this));
  }
  
  private void u()
  {
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("message_roam_flag");
    localStringBuilder.append(this.app.getCurrentAccountUin());
    int i1 = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              return;
            }
            getResources().getString(2131914223);
            return;
          }
          getResources().getString(2131914221);
          return;
        }
        getResources().getString(2131914222);
        return;
      }
      getResources().getString(2131914224);
      return;
    }
    getResources().getString(2131914231);
  }
  
  private void v()
  {
    ReportController.b(this.app, "dc00898", "", "", "0X800B6B9", "0X800B6B9", 0, 0, "", "", "", "");
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQToast.makeText(getActivity(), 1, 2131889466, 0).show();
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setMessage(getResources().getString(2131896910)).setPositiveButton(getResources().getString(2131896909), new ChatSettingActivity.11(this)).setNegativeButton(getResources().getString(2131896908), new ChatSettingActivity.10(this));
    localQQCustomDialog.show();
    ((TextView)localQQCustomDialog.findViewById(2131431876)).setGravity(17);
  }
  
  private void w()
  {
    DialogUtil.a(this, 230).setMessage(HardCodeUtil.a(2131899947)).setPositiveButton(17039370, new ChatSettingActivity.13(this)).setNegativeButton(17039360, new ChatSettingActivity.12(this)).show();
  }
  
  private void x()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1001);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.W);
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_entrance", 29);
    localIntent.putExtra("param_add_passed_members_to_result_set", true);
    localIntent.putExtra("param_max", 100 - localArrayList.size() - 1);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, localIntent, 2);
  }
  
  private void y()
  {
    ChatHistoryActivity.a(this, this.W, this.V, 3011);
  }
  
  private void z()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("chatbg_intent_frinedUin", this.W);
    localIntent.putExtra("uintype", this.V);
    localIntent.putExtra("bg_replace_entrance", 62);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    VasWebviewUtil.b(this, VasWebviewUtil.b(IndividuationUrlHelper.a(this, "background", ""), 46), 33554432L, localIntent, true, 1);
  }
  
  void a()
  {
    FormSimpleItem localFormSimpleItem = this.o;
    int i1;
    if ((!this.p.a()) && (!this.n.a()) && (!this.q.a())) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localFormSimpleItem.setVisibility(i1);
  }
  
  public void a(Dialog paramDialog)
  {
    this.aR = paramDialog;
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, int paramInt, String paramString)
  {
    ((IAioColdPalaceHelper)QRoute.api(IAioColdPalaceHelper.class)).doOnBanishColdPalaceClick(paramBaseQQAppInterface, paramContext, paramInt, paramString, this);
  }
  
  public void b()
  {
    if (this.aW == null) {
      this.aW = LBSHandler.a(this, getString(2131892080), new ChatSettingActivity.27(this), new ChatSettingActivity.28(this));
    }
    Dialog localDialog = this.aW;
    if ((localDialog != null) && (!localDialog.isShowing())) {
      this.aW.show();
    }
  }
  
  public Dialog c()
  {
    return this.aR;
  }
  
  public void d()
  {
    ((IAioColdPalaceHelper)QRoute.api(IAioColdPalaceHelper.class)).doOnColdPalaceLimitConfirm(this.app, this, this.V, this.W, this);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.aj = false;
    if (-1 == paramInt2)
    {
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 3)
            {
              if (paramInt1 != 1003) {
                return;
              }
              a(paramIntent);
              return;
            }
            if (paramIntent != null)
            {
              this.b = paramIntent.getBooleanExtra("follow_flag", false);
              H();
            }
          }
          else
          {
            paramInt1 = paramIntent.getIntExtra("param_subtype", -1);
            if (paramInt1 != 0)
            {
              if (paramInt1 != 1) {
                return;
              }
              Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
              paramIntent = paramIntent.getStringExtra("roomId");
              localIntent.putExtra("uin", paramIntent);
              localIntent.putExtra("uintype", 3000);
              localIntent.putExtra("uinname", ContactUtils.a(this.app, getApplicationContext(), paramIntent));
              localIntent.putExtra("isBack2Root", true);
              startActivity(localIntent);
              finish();
              return;
            }
            ReportController.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
            TroopUtils.a(this, paramIntent.getStringExtra("roomId"), true);
          }
        }
        else
        {
          A();
          finish();
        }
      }
      else {
        b(paramIntent);
      }
    }
    else if ((paramInt2 == 0) && (3 == paramInt1) && (paramIntent != null) && (paramIntent.getBooleanExtra("finchat", false))) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.P = getIntent();
    g();
    h();
    j();
    k();
    l();
    ReportController.b(this.app, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_exp", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.aP = true;
    MqqHandler localMqqHandler = this.G;
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
    try
    {
      if ((this.T != null) && (this.T.isShowing()) && (!isFinishing()))
      {
        this.T.dismiss();
        this.T = null;
      }
      if ((this.aW != null) && (this.aW.isShowing()))
      {
        this.aW.dismiss();
        this.aW = null;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    Object localObject = this.aN;
    if (localObject != null)
    {
      localObject = (FaceDrawable)((WeakReference)localObject).get();
      if (localObject != null) {
        ((FaceDrawable)localObject).cancel();
      }
    }
    localObject = this.aO;
    if (localObject != null)
    {
      localObject = (FaceDrawable)((WeakReference)localObject).get();
      if (localObject != null) {
        ((FaceDrawable)localObject).cancel();
      }
    }
    i();
    this.aL = false;
  }
  
  protected void doOnPause()
  {
    this.aj = true;
    J();
    ApngImage.pauseAll();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    this.aj = false;
    Object localObject1 = this.G;
    if (localObject1 != null)
    {
      if (this.aL)
      {
        ((MqqHandler)localObject1).removeMessages(32);
        this.G.sendEmptyMessageDelayed(32, 200L);
      }
      if (this.V == 0)
      {
        this.G.removeMessages(33);
        this.G.sendEmptyMessageDelayed(33, 200L);
      }
    }
    super.doOnResume();
    ApngImage.playByTag(27);
    if (this.j != null)
    {
      localObject1 = getString(2131914364);
      Object localObject2 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).y(this.W);
      if ((localObject2 != null) && (((SpecialCareInfo)localObject2).globalSwitch != 0))
      {
        this.j.setRightText(getString(2131916161));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(getString(2131916161));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        this.j.setRightText(getString(2131916160));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(getString(2131916160));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      this.j.setContentDescription((CharSequence)localObject1);
    }
    if (this.V == 0)
    {
      localObject1 = this.G;
      if ((localObject1 != null) && (!((MqqHandler)localObject1).hasMessages(34)))
      {
        int i1 = HotReactiveHelper.a();
        this.G.sendEmptyMessageDelayed(34, i1 * 1000);
      }
    }
    localObject1 = this.w;
    if (localObject1 != null)
    {
      ((ViewGroup)localObject1).setVisibility(8);
      ((ISVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).m();
    }
    o();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if ((this.V == 0) && (this.l != null))
    {
      u();
      ((IApolloExtensionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(new String[] { this.app.getCurrentAccountUin() }, new int[] { 42255 });
    }
  }
  
  public void e()
  {
    ((IAioColdPalaceHelper)QRoute.api(IAioColdPalaceHelper.class)).doOnColdPalaceLimitCancel(this);
  }
  
  public int f()
  {
    return 2;
  }
  
  public void finish()
  {
    int i1 = this.V;
    if ((1001 == i1) || (10002 == i1))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("follow_flag", this.b);
      setResult(-1, localIntent);
    }
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onClick(View paramView)
  {
    int i1;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131449926: 
      VipUtils.VipIconUtils.VipIconTouchListener.a(this.app, this.W, "VIA_AIO_CHATSETTINGS").onTouch(paramView, null);
      break;
    case 2131447314: 
      a(this.app, this, this.V, this.W);
      break;
    case 2131446424: 
      ReportController.b(this.app, "CliOper", "", "", "0X80040F3", "0X80040F3", 0, 0, "", "", "", "");
      if (a(this.V))
      {
        i1 = this.V;
        if (i1 == 10007)
        {
          localObject2 = ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().b(this.W);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("from=");
          ((StringBuilder)localObject1).append((String)((Pair)localObject2).first);
          ((StringBuilder)localObject1).append(", to=");
          ((StringBuilder)localObject1).append((String)((Pair)localObject2).second);
          QLog.e("tinyPairForGame", 1, ((StringBuilder)localObject1).toString());
          i1 = this.V;
          localObject1 = (String)((Pair)localObject2).first;
          localObject2 = (String)((Pair)localObject2).second;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.W);
          ((StringBuilder)localObject3).append("_");
          ((StringBuilder)localObject3).append(this.Z);
          ((StringBuilder)localObject3).append("&");
          ((StringBuilder)localObject3).append(this.aa);
          NewReportPlugin.a(this, i1, (String)localObject1, (String)localObject2, ((StringBuilder)localObject3).toString());
        }
        else
        {
          NewReportPlugin.a(this, i1, this.W, this.app.getCurrentAccountUin(), this.al);
        }
      }
      i1 = this.V;
      if ((i1 == 1044) || (i1 == 1045))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("to_uid", this.W);
        ((HashMap)localObject1).put("frompage", String.valueOf(f()));
        ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#complaint_page#complaint", true, -1L, -1L, (Map)localObject1, true, true);
      }
      break;
    case 2131446423: 
      K();
      break;
    case 2131446420: 
      i1 = this.V;
      if ((1001 != i1) && (10002 != i1))
      {
        if ((1036 == i1) && (this.aD))
        {
          w();
        }
        else
        {
          i1 = this.V;
          if ((1044 != i1) && (1045 != i1))
          {
            if (i1 == 10013)
            {
              if (KanDianPrivateChatAddFriendHelper.a(KanDianPrivateChatAddFriendHelper.l, this.app.getCurrentAccountUin(), this.W, this)) {
                L();
              }
            }
            else
            {
              L();
              ReportController.b(this.app, "CliOper", "", "", "0X80040F2", "0X80040F2", 0, 0, "", "", "", "");
            }
          }
          else
          {
            i1 = this.P.getIntExtra("subId", 0);
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("frompage", String.valueOf(i1));
            ((HashMap)localObject1).put("to_uid", this.W);
            ((HashMap)localObject1).put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.app.getCurrentAccountUin(), this.W));
            ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_setting_page#add_friends_all", true, -1L, -1L, (Map)localObject1, true, true);
            L();
          }
        }
      }
      else
      {
        if (this.b) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        if (1001 == this.V) {
          b((String)localObject1);
        } else {
          c((String)localObject1);
        }
        ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
        QQAppInterface localQQAppInterface = this.app;
        if ("1".equals(localObject1)) {
          localObject2 = "follow_aio";
        } else {
          localObject2 = "unfollow_aio";
        }
        if (this.V == 1001) {
          localObject3 = "0";
        } else {
          localObject3 = "1";
        }
        if ("1".equals(localObject1))
        {
          if (localShieldMsgManger.a(this.W)) {
            localObject1 = "1";
          } else {
            localObject1 = "0";
          }
        }
        else {
          localObject1 = "";
        }
        ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject2, 0, 0, (String)localObject3, "1", (String)localObject1, "");
      }
      break;
    case 2131446207: 
      localObject1 = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
      ((SharedPreferences)localObject1).edit().putBoolean("special_care_chat_setting", false).commit();
      if (((SharedPreferences)localObject1).getBoolean("special_care_red_point_one", false)) {
        ((SharedPreferences)localObject1).edit().putBoolean("special_care_red_point_one", false).commit();
      }
      this.j.setRightIcon(null);
      SpecialCareUtils.a(this, this.W, 2);
      ReportController.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "0", "", "", "");
      break;
    case 2131446027: 
      ReportController.b(this.app, "dc00899", "c2c_AIO", "", "sing_tab", "clk_setsing", 0, 1, this.W, "", "", "");
      localObject1 = (TogetherControlManager)this.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      boolean bool = ((TogetherControlManager)localObject1).b(4, 2, this.W);
      localObject2 = TogetherUtils.a(bool, 5);
      if (bool) {
        ((TogetherControlManager)localObject1).b(this, this.W, 2, 4, 5, (Bundle)localObject2);
      } else {
        ((TogetherControlManager)localObject1).a(this, this.W, 2, 4, 5, (Bundle)localObject2);
      }
      TogetherUtils.b(this.app, "SP_KEY_SING_TOGETHER_FRIEND_RED_DOT_SHOW", false, false);
      o();
      break;
    case 2131445676: 
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("uin", this.W);
      ((Intent)localObject1).putExtra("uintype", this.V);
      MessageNotificationSettingFragment.a(this, (Intent)localObject1);
      break;
    case 2131445673: 
      z();
      ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
      break;
    case 2131445087: 
      localObject1 = (GetRoamToastRsp)this.w.getTag();
      if (localObject1 != null)
      {
        ReportController.b(this.app, "dc00898", "", "", "0X8009E32", "0X8009E32", 0, 0, "", "", "", "");
        localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((GetRoamToastRsp)localObject1).sUrl);
        ((Intent)localObject2).putExtra("isShowAd", false);
        startActivity((Intent)localObject2);
      }
      break;
    case 2131445081: 
      localObject1 = (GetRoamToastRsp)this.w.getTag();
      if (localObject1 != null)
      {
        ReportController.b(this.app, "dc00898", "", "", "0X8009E77", "0X8009E77", 0, 0, "", "", "", "");
        ((ISVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a((GetRoamToastRsp)localObject1);
      }
      this.w.setVisibility(8);
      break;
    case 2131444617: 
    case 2131444618: 
      v();
      break;
    case 2131433695: 
      M();
      break;
    case 2131431717: 
      ReportController.b(this.app, "dc00898", "", "", "0X800A17C", "0X800A17C", 1, 0, "", "", "", "");
      a(this.app, this, this.W, this.V, new ChatSettingActivity.5(this), 2);
      break;
    case 2131431513: 
      x();
      ReportController.b(this.app, "CliOper", "", "", "0X80040EB", "0X80040EB", 0, 0, "", "", "", "");
      ReportController.b(this.app, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_clk", 0, 0, "", "", "", "");
      break;
    case 2131430770: 
      C();
      ReportController.b(this.app, "CliOper", "", "", "0X80040F1", "0X80040F1", 0, 0, "", "", "", "");
      break;
    case 2131430551: 
      y();
      ReportController.b(this.app, "dc00898", "", "", "0X800A0AC", "0X800A0AC", 0, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "0", "", "", "");
      break;
    case 2131430217: 
      if (this.V == 10008) {
        ReportController.b(this.app, "dc00898", "", "", "0X800ADC7", "0X800ADC7", 0, 0, "", "", "", "");
      }
      NewReportPlugin.a(this, this.V, this.W, this.app.getCurrentAccountUin());
      break;
    case 2131430039: 
    case 2131431710: 
      j(this.W);
      if (Utils.c(this.W)) {
        ReportController.b(this.app, "dc00898", "", "", "0X8007FDE", "0X8007FDE", 0, 0, "", "", "", "");
      }
      ReportController.b(this.app, "CliOper", "", "", "0X80040F0", "0X80040F0", 0, 0, "", "", "", "");
      break;
    case 2131427774: 
      O();
      ReportController.b(this.app, "CliOper", "", "", "0X80040EF", "0X80040EF", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity
 * JD-Core Version:    0.7.0.1
 */