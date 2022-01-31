package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.biz.helper.TroopCardAppInfoHelper;
import com.tencent.biz.helper.TroopCardAppInfoHelper.IGetAppInfoCB;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryForTroopFragment;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig.EffectInfo;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig.EffectInfoData;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import com.tencent.mobileqq.troop.fragment.TroopMoreDetailFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.EntryDebugFragment;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPager;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.troop.widget.FollowImageTextView;
import com.tencent.mobileqq.troop.widget.GameRankFormItem;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopFileProxyActivity;
import cooperation.troop.TroopManageCmd;
import cooperation.troop.TroopManageProxyActivity;
import cooperation.troop.TroopPluginManager;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;
import rzj;
import rzk;
import rzl;
import rzm;
import rzn;
import rzo;
import rzp;
import rzr;
import rzs;
import rzt;
import rzu;
import rzv;
import rzw;
import rzy;
import rzz;
import sab;
import sac;
import sad;
import sae;
import saf;
import sag;
import sah;
import sai;
import sal;
import sam;
import saq;
import sar;
import sas;
import sat;
import saz;
import sba;
import sbb;
import sbd;
import sbf;
import sbh;
import sbi;
import sbk;
import sbl;
import sbm;
import sbn;
import sbo;
import sbp;
import sbq;
import sbr;
import sbs;
import sbt;
import sbu;
import sbv;
import sbx;
import sbz;
import sca;
import scb;
import scc;
import scd;
import scf;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.ReqBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.AppInfo;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.ExtraInfo;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.TabInfo;
import tencent.im.troop.activity.troopactivity.ActSSOReq;
import tencent.im.troop.activity.troopactivity.Activity;
import tencent.im.troop.activity.troopactivity.GroupInfoCardResp;

public class ChatSettingForTroop
  extends BaseActivity
  implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener, HttpWebCgiAsyncTask.Callback, FaceDecoder.DecodeTaskCompletionListener
{
  public static final ArrayList a;
  public static String k;
  protected final int a;
  long jdField_a_of_type_Long = 0L;
  protected BroadcastReceiver a;
  public Intent a;
  public Drawable a;
  public Handler a;
  protected DisplayMetrics a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new sbs(this);
  protected View a;
  public AlphaAnimation a;
  protected Animation.AnimationListener a;
  protected Button a;
  public ImageView a;
  protected LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  protected OpenIdObserver a;
  protected TroopCardAppInfoHelper.IGetAppInfoCB a;
  protected TroopCardAppInfoHelper a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new sbi(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new sas(this);
  public TroopManager a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new sal(this);
  public TroopInfo a;
  protected AvatarWallViewPager a;
  public AvatarWallViewPagerAdapter a;
  TroopMoreDetailView jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView;
  public GroupCatalogBean a;
  public TroopInfoData a;
  public TroopShareUtility a;
  protected FaceDecoder a;
  public QQCustomDialog a;
  public RoamSettingController a;
  VasExtensionObserver jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = new sbz(this);
  protected MyGridView a;
  protected QQProgressDialog a;
  public QQProgressNotifier a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public ImmersiveTitleBar2 a;
  protected Runnable a;
  protected String a;
  public List a;
  Observer jdField_a_of_type_JavaUtilObserver = new sat(this);
  protected BusinessObserver a;
  protected scf a;
  protected boolean a;
  public View[] a;
  protected final int b;
  public Handler b;
  protected View.OnClickListener b;
  protected View b;
  public AlphaAnimation b;
  public ImageView b;
  public TextView b;
  TroopObserver jdField_b_of_type_ComTencentMobileqqAppTroopObserver = new sam(this);
  protected Runnable b;
  public String b;
  protected ArrayList b;
  public List b;
  private BusinessObserver jdField_b_of_type_MqqObserverBusinessObserver = new sbp(this);
  public volatile boolean b;
  public int c;
  protected View c;
  public TextView c;
  TroopObserver c;
  public String c;
  protected ArrayList c;
  protected List c;
  public boolean c;
  public int d;
  TroopObserver d;
  public String d;
  public List d;
  public boolean d;
  protected int e;
  private TroopObserver jdField_e_of_type_ComTencentMobileqqAppTroopObserver = new rzj(this);
  String jdField_e_of_type_JavaLangString;
  public List e;
  public boolean e;
  protected int f;
  String f;
  public boolean f;
  protected int g;
  String g;
  protected boolean g;
  protected int h;
  String h;
  protected boolean h;
  protected int i;
  String i;
  protected boolean i;
  protected int j;
  String j;
  public boolean j;
  protected int k;
  public boolean k;
  public int l;
  protected String l;
  public boolean l;
  public int m;
  protected boolean m;
  public int n;
  public boolean n;
  protected int o;
  private boolean o;
  protected int p;
  private int q = 2;
  private int r = 1;
  private int s = 2;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131371432));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131371433));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131371434));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131371435));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131371436));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131371437));
    jdField_k_of_type_JavaLangString = "http://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi";
  }
  
  public ChatSettingForTroop()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_JavaLangString = "http://app.qun.qq.com/mobileapp/index.html?_bid=136";
    this.jdField_d_of_type_Int = 1;
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_i_of_type_Int = 5;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_k_of_type_Int = 6;
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new sai(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new sba(this);
    this.jdField_a_of_type_JavaLangRunnable = new rzm(this);
    this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB = new rzt(this);
    this.jdField_b_of_type_JavaLangRunnable = new rzz(this);
    this.jdField_o_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new sah(this);
    this.jdField_c_of_type_ComTencentMobileqqAppTroopObserver = new saq(this);
    this.jdField_d_of_type_ComTencentMobileqqAppTroopObserver = new sar(this);
    this.jdField_a_of_type_MqqObserverBusinessObserver = new sbm(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new sbo(this);
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new sbu(this);
  }
  
  private void D()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(12);
    if (localWebProcessManager == null) {}
    do
    {
      do
      {
        return;
      } while (!localWebProcessManager.d());
      localWebProcessManager.e();
    } while (!QLog.isColorLevel());
    QLog.d("Q.chatopttroop", 2, "start preloadWebProcess");
  }
  
  private void E()
  {
    int i2 = getResources().getDisplayMetrics().widthPixels;
    float f1 = getResources().getDisplayMetrics().density;
    int i3 = (int)(24.0F * f1);
    int i1 = (int)(20.0F * f1);
    int i4 = (int)(66.0F * f1);
    int i5 = (int)(50.0F * f1);
    i1 = (i2 - i3) / (i1 + i5);
    i2 = (i2 - i3 - i1 * i4 - (i4 - i5)) / (i1 + 1);
    i2 = (int)(12.0F * f1);
    this.jdField_e_of_type_Int = i2;
    this.jdField_f_of_type_Int = i2;
    this.jdField_g_of_type_Int = ((int)(5.0F * f1));
    this.jdField_h_of_type_Int = ((int)(17.0F * f1));
    this.jdField_i_of_type_Int = i1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(this.jdField_e_of_type_Int, this.jdField_g_of_type_Int, this.jdField_f_of_type_Int, this.jdField_h_of_type_Int);
  }
  
  private void F()
  {
    byte[] arrayOfByte;
    if ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
    {
      arrayOfByte = ((TroopManager)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (arrayOfByte == null) {
        break label83;
      }
    }
    label83:
    while (!QLog.isColorLevel()) {
      try
      {
        oidb_0xaf4.RspBody localRspBody = new oidb_0xaf4.RspBody();
        localRspBody.mergeFrom(arrayOfByte);
        a(localRspBody);
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData exception");
        return;
      }
    }
    QLog.d("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData==null");
  }
  
  private void G()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    if (!this.jdField_d_of_type_Boolean) {
      localActionSheet.a(new ActionMenuItem(getString(2131430414), 38, 0), 5);
    }
    localActionSheet.a(new ActionMenuItem(ActionSheetHelper.a(this, 2131435099), 22, 0), 5);
    if ((this.jdField_d_of_type_Int == 1) || ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))) {
      localActionSheet.a(new ActionMenuItem(getString(2131430415), 21, 0), 3);
    }
    localActionSheet.c(2131432998);
    localActionSheet.a(new rzp(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void H()
  {
    Object localObject1;
    label66:
    Object localObject2;
    label91:
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject1 = (TroopManager)this.app.getManager(51);
      if (localObject1 == null)
      {
        localObject1 = null;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject1);
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label271;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname == null)) {
        break label249;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode == null)) {
        break label260;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      localObject3 = new Intent(this, TroopDisbandActivity.class);
      ((Intent)localObject3).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((Intent)localObject3).putExtra("TROOP_INFO_FLAG_EXT", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt);
      ((Intent)localObject3).putExtra("troop_auth_submit_time", this.jdField_l_of_type_Int);
      ((Intent)localObject3).putExtra("uinname", (String)localObject1);
      ((Intent)localObject3).putExtra("troop_code", (String)localObject2);
      ((Intent)localObject3).putExtra("leftViewText", 2131435260);
      startActivityForResult((Intent)localObject3, 4);
      localObject1 = "2";
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label521;
      }
      localObject1 = "0";
    }
    for (;;)
    {
      ReportController.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Clk_quitgrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject1, "", "");
      return;
      localObject1 = ((TroopManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      break;
      label249:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
      break label66;
      label260:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode;
      break label91;
      label271:
      localObject3 = getString(2131434507);
      label347:
      label372:
      String str;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName() != null))
      {
        localObject1 = (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName() + "(" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + ")").replace("\n", "");
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName() == null)) {
          break label510;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
        ((String)localObject2).replaceAll("\n", "");
        str = getString(2131434502);
        if (!this.jdField_d_of_type_Boolean) {
          break label516;
        }
      }
      for (;;)
      {
        localObject1 = String.format(str, new Object[] { localObject2 });
        localObject1 = DialogUtil.a(this, 230).setTitle((String)localObject3).setMessage((CharSequence)localObject1);
        ((QQCustomDialog)localObject1).setPositiveButton(getString(2131433502), new rzr(this, (QQCustomDialog)localObject1));
        ((QQCustomDialog)localObject1).setPositiveButtonContentDescription(getString(2131427392));
        ((QQCustomDialog)localObject1).setNegativeButton(getString(2131432998), new rzs(this, (QQCustomDialog)localObject1));
        ((QQCustomDialog)localObject1).setNegativeButtonContentDescription(getString(2131427393));
        ((QQCustomDialog)localObject1).show();
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        break label347;
        label510:
        localObject2 = "";
        break label372;
        label516:
        localObject2 = localObject1;
      }
      label521:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        localObject1 = "1";
      }
    }
  }
  
  private void I()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
    if (localTroopHandler != null)
    {
      if ((this.jdField_d_of_type_Int != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
        break label70;
      }
      localTroopHandler.a(BizTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB);
      return;
      label70:
      localTroopHandler.a(BizTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), false);
    }
  }
  
  private void J()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum <= 100) {
      localTroopHandler.a(BizTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 0L, 5, 100, 0);
    }
  }
  
  private void K()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    PublicFragmentActivity.a(this, localIntent, ChatHistoryForTroopFragment.class, 5);
  }
  
  private void L()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {}
    do
    {
      return;
      localObject = (Boolean)this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.get(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
    } while ((localObject != null) && (((Boolean)localObject).booleanValue()));
    ReportController.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "0", "");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
    }
    for (;;)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      localActionSheet.a(getString(2131435693, new Object[] { localObject }));
      localActionSheet.a(getString(2131430230), false);
      localActionSheet.a(getString(2131430231), false);
      localActionSheet.a(getString(2131430232), false);
      int i1 = this.app.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
      switch (i1)
      {
      }
      for (;;)
      {
        localActionSheet.c(2131432998);
        localActionSheet.a(new sab(this, i1, localActionSheet));
        localActionSheet.show();
        return;
        localActionSheet.d(0);
        continue;
        localActionSheet.d(1);
        continue;
        localActionSheet.d(2);
      }
    }
  }
  
  private void M()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[34];
    if ((localView != null) && ((localView instanceof ExpandableTextView)))
    {
      String str2 = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
      String str1 = str2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        str1 = str2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      }
      ((ExpandableTextView)localView).setText(new QQText(str1, 11, 16));
    }
  }
  
  private void N()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 3)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 30) {}
    for (Intent localIntent = new Intent(this, ChatActivity.class);; localIntent = new Intent(this, SplashActivity.class))
    {
      localIntent = AIOUtils.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
      startActivity(localIntent);
      return;
    }
  }
  
  private void O()
  {
    r();
    ((TroopHandler)this.app.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_b_of_type_JavaLangString, null, null);
  }
  
  private void P()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[27];
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
    {
      i1 = getResources().getDimensionPixelSize(2131558786);
      if (localLayoutParams != null) {
        break label87;
      }
      localLayoutParams = new LinearLayout.LayoutParams(-1, i1);
    }
    for (;;)
    {
      localView.setLayoutParams(localLayoutParams);
      return;
      if (this.r == 1)
      {
        i1 = UIUtils.a(this, 128.0F);
        break;
      }
      i1 = UIUtils.a(this, 151.0F);
      break;
      label87:
      localLayoutParams.width = -1;
      localLayoutParams.height = i1;
    }
  }
  
  private void Q()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) && (getIntent().getBooleanExtra("from_newer_guide", false)))
    {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
  }
  
  private void R()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("chatbg_intent_frinedUin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("bg_replace_entrance", 62);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "background", ""), 33554432L, localIntent, true, 6);
    ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
  }
  
  private void S()
  {
    boolean bool = ((TroopManager)this.app.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[9];
    if (localObject != null)
    {
      localObject = ((FormSwitchItem)localObject).a();
      ((Switch)localObject).setOnCheckedChangeListener(null);
      ((Switch)localObject).setChecked(bool);
      ((Switch)localObject).setOnCheckedChangeListener(this);
    }
  }
  
  private void T()
  {
    boolean bool = ((TroopManager)this.app.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[19];
    if (localFormSwitchItem != null)
    {
      Switch localSwitch = localFormSwitchItem.a();
      localSwitch.setOnCheckedChangeListener(null);
      localSwitch.setChecked(bool);
      localSwitch.setOnCheckedChangeListener(this);
      localFormSwitchItem.setContentDescription(getString(2131430369));
    }
  }
  
  private void U()
  {
    StringBuilder localStringBuilder = null;
    int i3 = 8;
    int i2 = 0;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    FollowImageTextView localFollowImageTextView = (FollowImageTextView)this.jdField_a_of_type_ArrayOfAndroidViewView[15];
    int i1;
    if (localFollowImageTextView != null)
    {
      if (!bool) {
        break label209;
      }
      i1 = 0;
      localFollowImageTextView.setFollowImageVisibility(i1);
      if (!bool) {
        break label215;
      }
      localObject = this.jdField_a_of_type_AndroidViewView$OnTouchListener;
      label58:
      localFollowImageTextView.setOnTouchListener((View.OnTouchListener)localObject);
      localObject = localStringBuilder;
      if (bool) {
        localObject = this;
      }
      localFollowImageTextView.setOnClickListener((View.OnClickListener)localObject);
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        localObject = localFollowImageTextView.a();
        localStringBuilder = new StringBuilder().append("群聊名称 ").append(localObject);
        if (!bool) {
          break label221;
        }
      }
    }
    label209:
    label215:
    label221:
    for (Object localObject = "， 编辑群聊名称 按钮";; localObject = "")
    {
      localFollowImageTextView.setContentDescription((String)localObject);
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[5];
      i1 = i3;
      if (bool)
      {
        i1 = i3;
        if (this.jdField_b_of_type_Boolean) {
          i1 = 0;
        }
      }
      if (localObject != null) {
        ((View)localObject).setVisibility(i1);
      }
      localObject = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[6];
      if (localObject != null)
      {
        if (i1 == 0) {
          i2 = 3;
        }
        ((FormSimpleItem)localObject).setBgType(i2);
      }
      return;
      i1 = 8;
      break;
      localObject = null;
      break label58;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        do
        {
          return 0;
          paramQQAppInterface = paramQQAppInterface.b();
        } while (paramQQAppInterface == null);
        StringBuilder localStringBuilder = new StringBuilder(" where msgtype ");
        localStringBuilder.append(MsgProxyUtils.b());
        localStringBuilder.append(" and isValid=1 ");
        paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), paramQQAppInterface, localStringBuilder.toString());
      } while (paramString == null);
      paramQQAppInterface = paramQQAppInterface.a(paramString.toString(), null);
    } while (paramQQAppInterface == null);
    if ((paramQQAppInterface.getCount() > 0) && (paramStringBuilder != null))
    {
      paramQQAppInterface.moveToLast();
      long l1 = paramQQAppInterface.getLong(paramQQAppInterface.getColumnIndex("shmsgseq"));
      if (l1 > 0L) {
        paramStringBuilder.append(String.valueOf(l1));
      }
    }
    paramInt = paramQQAppInterface.getCount();
    paramQQAppInterface.close();
    return paramInt;
  }
  
  private String a(String paramString, long paramLong, int paramInt)
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
    {
      str = "0";
      str = paramString.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).replace("$CLIENTVER$", "android7.6.0").replace("$UIN$", this.app.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str);
      if (this.jdField_d_of_type_Int != 1) {
        break label187;
      }
    }
    label187:
    for (paramString = "1";; paramString = "2")
    {
      str = str.replace("$ENTERSOURCE$", paramString).replace("$GUIN$", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).replace("$UNREADNUM$", String.valueOf(paramInt));
      paramString = str;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName)) {
        paramString = str.replace("$GNAME$", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
      }
      return paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin)
      {
        str = "1";
        break;
      }
      str = "2";
      break;
    }
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131433645);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131433647);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131433650);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 4;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131433651);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 5;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131433652);
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean, ArrayList paramArrayList)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_groupcode", paramString);
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_subtype", 1);
    localIntent.putExtra("param_is_troop_admin", paramBoolean);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131434517));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", paramActivity.getString(2131430183));
    if (!paramBoolean) {
      localIntent.putExtra("param_max", 10);
    }
    paramActivity.startActivityForResult(localIntent, 1);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, ChatSettingForTroop.class);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("vistor_type", paramInt);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, paramContext.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    if (DBUtils.a(paramQQAppInterface.getCurrentAccountUin(), "troop_file_new", paramString) != 0) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        DBUtils.a(paramQQAppInterface.getCurrentAccountUin(), "troop_file_new", paramString, 0);
      }
      Intent localIntent = new Intent();
      localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, paramString);
      localIntent.putExtra("param_from", 3000);
      TroopFileProxyActivity.a(paramActivity, localIntent, 16, paramQQAppInterface.getCurrentAccountUin());
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp", "Clk_grpinfo_files", 0, 0, paramString, "0", "", "");
      if (QLog.isDevelopLevel()) {
        QLog.d("Clk_grpinfo_files", 4, "troopUin :" + paramString);
      }
      BnrReport.a(paramQQAppInterface, 67);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    boolean bool;
    QZoneHelper.UserInfo localUserInfo;
    if (paramInt != 0)
    {
      bool = true;
      localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      localUserInfo.jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentNickname();
      TroopHandler localTroopHandler = (TroopHandler)paramQQAppInterface.a(20);
      if (!TextUtils.isEmpty(paramString1)) {
        localTroopHandler.e(paramString1, true);
      }
      if (DBUtils.a(paramQQAppInterface.getCurrentAccountUin(), "troop_photo_message", paramString1) <= 0) {
        break label119;
      }
      QZoneHelper.c(paramActivity, localUserInfo, paramString1, 7);
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_album", 0, 0, paramString1, "", "", "");
      BnrReport.a(paramQQAppInterface, 66);
      return;
      bool = false;
      break;
      label119:
      QZoneHelper.a(paramActivity, localUserInfo, paramString1, paramString2, bool, 7);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      troop_member_distribute.ReqBody localReqBody = new troop_member_distribute.ReqBody();
      localReqBody.uint64_group_code.set(Long.parseLong(paramString));
      paramString = new NewIntent(paramQQAppInterface.getApp(), ProtoServlet.class);
      paramString.putExtra("cmd", "group_member_statistic.get_group_member_statistic");
      paramString.putExtra("data", localReqBody.toByteArray());
      paramString.setObserver(paramBusinessObserver);
      paramQQAppInterface.startServlet(paramString);
      return;
    }
    catch (NumberFormatException paramQQAppInterface) {}
  }
  
  private void a(troopactivity.GroupInfoCardResp paramGroupInfoCardResp)
  {
    if (paramGroupInfoCardResp == null) {}
    int i1;
    Object localObject1;
    do
    {
      return;
      i1 = paramGroupInfoCardResp.activitys.size();
      localObject1 = paramGroupInfoCardResp.group_act_url.get();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.jdField_l_of_type_JavaLangString = a((String)localObject1, 0L, 0);
      }
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[35];
    } while (localObject1 == null);
    View localView = ((View)localObject1).findViewById(2131368551);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131368552);
    if (i1 > 0)
    {
      Object localObject2 = (troopactivity.Activity)paramGroupInfoCardResp.activitys.get(0);
      String str = ((troopactivity.Activity)localObject2).str_name.get();
      localObject2 = ((troopactivity.Activity)localObject2).str_start_time.get();
      paramGroupInfoCardResp.being_act_num.get();
      a(35, 0, localView, getString(2131430359), getString(2131430493), true);
      localTextView.setText(str + "\n" + (String)localObject2);
      localTextView.setVisibility(0);
      ((View)localObject1).setVisibility(0);
      this.s = 1;
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Exp_activity", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.p + "", "1", "");
      return;
    }
    if (paramGroupInfoCardResp.history_act_num.get() > 0)
    {
      i1 = paramGroupInfoCardResp.history_act_num.get();
      paramGroupInfoCardResp = String.format(getString(2131430494), new Object[] { Integer.valueOf(i1) });
      a(35, 0, localView, getString(2131430359), paramGroupInfoCardResp, true);
      ((View)localObject1).setVisibility(0);
      localTextView.setVisibility(8);
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Exp_activity", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.p + "", "0", "");
      this.s = 0;
      return;
    }
    ((View)localObject1).setVisibility(8);
    localTextView.setVisibility(8);
    this.s = 2;
  }
  
  private void b(int paramInt)
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131434794, 1500);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(18);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.b.clear();
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, Integer.valueOf(paramInt));
    this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.put(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, Boolean.valueOf(true));
    if (!this.jdField_o_of_type_Boolean)
    {
      SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      if (!localSharedPreferences.getBoolean("Change_Msg_Notify_Tips_Value", false))
      {
        this.jdField_o_of_type_Boolean = true;
        localSharedPreferences.edit().putBoolean("Change_Msg_Notify_Tips_Value", true).commit();
        DialogUtil.a(this, getString(2131430241), 2131435252, 2131435252, new DialogUtil.DialogOnClickAdapter(), null).show();
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(18);
    ReportController.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, String.valueOf(paramInt - 1), "", "");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    troopactivity.ActSSOReq localActSSOReq = new troopactivity.ActSSOReq();
    localActSSOReq.cmd.set(1);
    localActSSOReq.group_code.set(Long.parseLong(paramString));
    paramString = new NewIntent(paramQQAppInterface.getApp(), ProtoServlet.class);
    paramString.putExtra("cmd", "qqact.actvitylist");
    paramString.putExtra("data", localActSSOReq.toByteArray());
    paramString.setObserver(paramBusinessObserver);
    paramQQAppInterface.startServlet(paramString);
  }
  
  private boolean b()
  {
    if ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
    {
      byte[] arrayOfByte = ((TroopInfoManager)this.app.getManager(36)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (arrayOfByte != null) {
        try
        {
          oidb_0xaf4.RspBody localRspBody = new oidb_0xaf4.RspBody();
          localRspBody.mergeFrom(arrayOfByte);
          a(localRspBody);
          return true;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData exception");
          }
          return false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData==null");
      }
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(51);
      if (localObject != null) {
        break label56;
      }
    }
    label56:
    for (Object localObject = null;; localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && ((paramInt & 0x1) > 0)) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption);
      }
      return;
    }
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      TroopInfoManager localTroopInfoManager = (TroopInfoManager)this.app.getManager(36);
      this.jdField_c_of_type_JavaUtilArrayList = localTroopInfoManager.a(localTroopInfoManager.a(paramString));
      if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)) {
        this.jdField_k_of_type_Boolean = true;
      }
    }
    else
    {
      return;
    }
    this.jdField_k_of_type_Boolean = false;
  }
  
  private void c(List paramList)
  {
    this.jdField_e_of_type_JavaUtilList = paramList;
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
    ArrayList localArrayList = new ArrayList();
    TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.app.getManager(202);
    Iterator localIterator = paramList.iterator();
    Object localObject = null;
    paramList = null;
    while (localIterator.hasNext())
    {
      oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)localIterator.next();
      String str = String.valueOf(localmemberlist.uint64_member_uin.get());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))) {
        paramList = localmemberlist;
      } else if (localTroopRobotManager.b(str)) {
        localObject = localmemberlist;
      } else {
        localArrayList.add(str);
      }
    }
    if (localObject != null) {
      this.jdField_e_of_type_JavaUtilList.remove(localObject);
    }
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        this.jdField_e_of_type_JavaUtilList.remove(paramList);
        localArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
        this.jdField_e_of_type_JavaUtilList.add(0, paramList);
      }
      catch (NumberFormatException paramList)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.chatopttroop", 2, paramList.toString());
        continue;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, localArrayList);
      localTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, localArrayList, true, null);
      return;
      paramList = new oidb_0x899.memberlist();
      paramList.uint64_member_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin));
    }
  }
  
  private void c(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[13].findViewById(2131364607);
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localTextView.setVisibility(i1);
      return;
    }
  }
  
  private void d(int paramInt)
  {
    this.q = paramInt;
    HWTroopUtils.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)
    {
      O();
      return;
    }
    e(paramString);
  }
  
  private void d(boolean paramBoolean)
  {
    BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.app.a(22);
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode != null))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      if (!paramBoolean) {
        break label145;
      }
      i1 = 0;
      label45:
      if (!localBizTroopHandler.a(str, i1)) {
        break label157;
      }
      if (!paramBoolean) {
        break label150;
      }
    }
    label145:
    label150:
    for (String str = "open_stick";; str = "close_stick")
    {
      ReportController.b(this.app, "dc00899", "Grp_set", "", "Grp_data", str, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      TroopReportor.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode;
      break;
      i1 = 1;
      break label45;
    }
    label157:
    S();
  }
  
  private void e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
      if ((this.jdField_j_of_type_Int == 1) || (this.jdField_j_of_type_Int == 2)) {
        i1 = 18;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark))
      {
        startActivity(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), this.jdField_b_of_type_JavaLangString, paramString));
        return;
      }
      paramString = AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), this.jdField_b_of_type_JavaLangString, paramString);
      paramString.putExtra("from_newer_guide", getIntent().getBooleanExtra("from_newer_guide", false));
      paramString.putExtra("from_babyq", getIntent().getBooleanExtra("from_babyq", false));
      startActivityForResult(paramString, 10);
      return;
    }
    b(2131434414, 0);
  }
  
  private void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "switchTroopShowExternal");
    }
    if (NetworkUtil.a(this) == 0)
    {
      QQToast.a(this, 2131430373, 0).b(getTitleBarHeight());
      T();
      return;
    }
    ((TroopHandler)this.app.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramBoolean, false);
    if (paramBoolean)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      if (!paramBoolean) {
        break label199;
      }
    }
    label199:
    for (String str = "showGrp_open";; str = "showGrp_close")
    {
      TroopReportor.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      break;
    }
  }
  
  private void f(String paramString)
  {
    runOnUiThread(new sbv(this, paramString));
  }
  
  private void f(boolean paramBoolean)
  {
    if (NetworkUtil.a(this) == 0)
    {
      QQToast.a(this, 2131429828, 0).b(getTitleBarHeight());
      B();
      return;
    }
    BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.app.a(22);
    if (paramBoolean) {}
    for (String str = "open_stick";; str = "close_stick")
    {
      TroopReportor.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      if (paramBoolean) {
        break;
      }
      DialogUtil.a(this, 230).setTitle(getString(2131433248)).setMessage(getString(2131430400)).setNegativeButton(getString(2131430401), new sbr(this, localBizTroopHandler)).setPositiveButton(getString(2131430402), new sbq(this)).show();
      return;
    }
    localBizTroopHandler.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, paramBoolean);
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "share_set_open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    TroopReportor.a("Grp_set_new", "grpData_admin", "share_set_open", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
  }
  
  public void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
      } while (localObject == null);
      localObject = (TextView)((View)localObject).findViewById(2131368430);
    } while (localObject == null);
    ((TextView)localObject).setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 1) {
      ((TextView)localObject).setVisibility(8);
    }
    while (this.jdField_d_of_type_Boolean)
    {
      ((TextView)localObject).setVisibility(8);
      ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[13].findViewById(2131368431)).setVisibility(8);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 0)
      {
        ((TextView)localObject).setVisibility(8);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
      {
        ((TextView)localObject).setText(getString(2131429837));
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 3) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4))
      {
        ((TextView)localObject).setText(getString(2131429837));
      }
      else
      {
        ((TextView)localObject).setVisibility(8);
        return;
      }
    }
    int i1;
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512)))
    {
      i1 = 1;
      if ((i1 == 0) || (this.jdField_d_of_type_Boolean)) {
        break label355;
      }
      ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[13].findViewById(2131368431)).setVisibility(0);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) || (i1 == 0)) {
        break label382;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131435744, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(48));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      return;
      i1 = 0;
      break;
      label355:
      ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[13].findViewById(2131368431)).setVisibility(8);
    }
    label382:
    this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
  }
  
  public void B()
  {
    boolean bool = ((TroopInfoManager)this.app.getManager(36)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[20];
    if (localFormSwitchItem != null)
    {
      Switch localSwitch = localFormSwitchItem.a();
      localSwitch.setOnCheckedChangeListener(null);
      localSwitch.setChecked(bool);
      localSwitch.setOnCheckedChangeListener(this);
      localFormSwitchItem.setContentDescription(getString(2131430399));
    }
  }
  
  public void C()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131430008);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131430142);
    sbt localsbt = new sbt(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131432998, localsbt);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131430009, localsbt);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public String a(long paramLong)
  {
    Object localObject = "";
    if (paramLong > 0L)
    {
      localObject = new SimpleDateFormat("yyyy年MM月dd日");
      localObject = getResources().getString(2131430410) + ((SimpleDateFormat)localObject).format(Long.valueOf(1000L * paramLong));
    }
    return localObject;
  }
  
  @SuppressLint({"NewApi"})
  protected void a()
  {
    long l1 = System.currentTimeMillis();
    int i1;
    int i2;
    Object localObject3;
    label3616:
    label3656:
    label3692:
    label3823:
    do
    {
      for (;;)
      {
        Object localObject5;
        ImageView localImageView;
        try
        {
          View localView = View.inflate(this, 2130971618, null);
          this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131363710));
          this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)localView.findViewById(2131363361));
          this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
          this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
          this.jdField_a_of_type_ArrayOfAndroidViewView = new View[42];
          this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
          Object localObject1 = new AbsListView.LayoutParams(-1, -2);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130838210);
          localObject1 = new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout);
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
          if ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
          {
            this.jdField_d_of_type_Boolean = TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder().append("mIsQidianPrivateTroop : ").append(this.jdField_d_of_type_Boolean).append(", troopUin = ").append(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin).append(", isHost = ");
              if ((this.jdField_d_of_type_Int != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
                break label3767;
              }
              bool = true;
              QLog.d("Q.chatopttroop", 2, bool);
            }
            if (this.jdField_d_of_type_Int == 2)
            {
              i1 = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
              i2 = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
              int i3 = getResources().getDimensionPixelOffset(2131558669);
              this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(i1, 0, i2, i3);
            }
            super.setContentView(localView);
            this.jdField_c_of_type_AndroidViewView = localView;
            this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838210);
            this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363227));
            this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363456));
            this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362577));
            this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363363));
            this.jdField_a_of_type_AndroidWidgetTextView.setText(2131435257);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName + " " + getResources().getString(2131435257));
            this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131435584) + getString(2131437109));
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841265);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131427477));
          }
          TextView localTextView1;
          TextView localTextView2;
          Object localObject4;
          this.jdField_d_of_type_Boolean = true;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          try
          {
            localObject1 = View.inflate(this, 2130969428, null);
            this.jdField_a_of_type_ArrayOfAndroidViewView[27] = localObject1;
            ((View)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131558786)));
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager = ((AvatarWallViewPager)((View)localObject1).findViewById(2131363096));
            this.jdField_a_of_type_ArrayOfAndroidViewView[24] = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager;
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setTag(Integer.valueOf(24));
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnClickListener(this);
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter = new AvatarWallViewPagerAdapter(new WeakReference(this), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager, getResources().getDisplayMetrics().widthPixels, UIUtils.a(this, 212.0F), this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, this.jdField_a_of_type_AndroidOsHandler, "Grp_Admin_data");
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter);
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnPageChangeListener(new sbn(this));
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            localObject1 = ((View)localObject1).findViewById(2131366440);
            this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localObject1;
            localObject5 = (FollowImageTextView)((View)localObject1).findViewById(2131363667);
            localTextView1 = (TextView)((View)localObject1).findViewById(2131364607);
            localTextView2 = (TextView)((View)localObject1).findViewById(2131368430);
            localObject3 = (TextView)((View)localObject1).findViewById(2131368429);
            localObject4 = (TextView)((View)localObject1).findViewById(2131368431);
            localImageView = (ImageView)((View)localObject1).findViewById(2131363668);
            localImageView.setTag(Integer.valueOf(49));
            localImageView.setOnClickListener(this);
            localImageView.setOnTouchListener(new sca(this, localImageView));
            localImageView.setContentDescription(getResources().getString(2131433483));
            if (((this.jdField_d_of_type_Int != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) || (this.jdField_d_of_type_Boolean)) {
              break label3823;
            }
            localImageView.setVisibility(0);
            ((FollowImageTextView)localObject5).setMaxWidth((int)DeviceInfoUtil.j() - UIUtils.a(this, 88.5F));
            this.jdField_a_of_type_ArrayOfAndroidViewView[15] = localObject5;
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
              break label3850;
            }
            i1 = 2130841416;
            ((FollowImageTextView)localObject5).setFollowImageResource(i1);
            ((FollowImageTextView)localObject5).setFollowImageWH(UIUtils.a(this, 14.0F), UIUtils.a(this, 15.0F));
            ((FollowImageTextView)localObject5).setTag(Integer.valueOf(15));
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
            {
              ((FollowImageTextView)localObject5).setFollowImageResource(0);
              ((FollowImageTextView)localObject5).setOnClickListener(this);
              ((FollowImageTextView)localObject5).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
            }
            ((FollowImageTextView)localObject5).setOnTextLineChangeListener(new scb(this));
            ((FollowImageTextView)localObject5).setTextColor(getResources().getColor(2131492968));
            ((FollowImageTextView)localObject5).setTextSize(1, 23.0F);
            ((FollowImageTextView)localObject5).setMaxLines(2);
            b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
            localTextView1.setTag(Integer.valueOf(2));
            localTextView1.setOnLongClickListener(this);
            localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            localTextView1.setVisibility(8);
            localTextView2.setTag(Integer.valueOf(2));
            localTextView2.setOnLongClickListener(this);
            A();
            i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
              i1 = 0;
            }
            if (i1 <= 0) {
              break label3857;
            }
            localObject5 = String.format(getResources().getString(2131433491), new Object[] { Integer.valueOf(i1) });
            ((TextView)localObject3).setText((CharSequence)localObject5);
            ((TextView)localObject3).setContentDescription((CharSequence)localObject5);
            ((TextView)localObject3).setVisibility(0);
            ((TextView)localObject3).setTag(Integer.valueOf(2));
            ((TextView)localObject3).setOnClickListener(this);
            if (this.jdField_d_of_type_Boolean) {
              ((TextView)localObject3).setVisibility(8);
            }
            ((TextView)localObject4).setText(getResources().getString(2131433492));
            ((TextView)localObject4).setContentDescription(getResources().getString(2131433492));
            ((TextView)localObject4).setVisibility(8);
            ((View)localObject1).setBackgroundResource(2130838621);
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
              v();
            }
            y();
            if ((this.jdField_d_of_type_Int != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
              break;
            }
            localObject1 = View.inflate(this, 2130970619, null);
            if (AppSetting.jdField_b_of_type_Boolean) {
              ViewCompat.setImportantForAccessibility((View)localObject1, 2);
            }
            this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject1;
            ((View)localObject1).setTag(Integer.valueOf(0));
            ((View)localObject1).setBackgroundResource(2130838619);
            ((View)localObject1).setOnClickListener(this);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131371419));
            this.jdField_c_of_type_AndroidWidgetTextView.setText("共" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "人");
            if (AppSetting.jdField_b_of_type_Boolean) {
              this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, AIOUtils.a(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), AIOUtils.a(3.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), AIOUtils.a(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()));
            }
            a((View)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)((View)localObject1).findViewById(2131365857));
            this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setFadingEdgeLength(0);
            E();
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
            localObject1 = View.inflate(this, 2130970624, null);
            ((View)localObject1).setBackgroundResource(2130846313);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131558785);
            localObject1 = new LinearLayout(this);
            ((LinearLayout)localObject1).setOrientation(1);
            ((LinearLayout)localObject1).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            this.jdField_a_of_type_ArrayOfAndroidViewView[29] = localObject1;
            localObject1 = View.inflate(this, 2130969424, null);
            this.jdField_a_of_type_ArrayOfAndroidViewView[14] = localObject1;
            ((View)localObject1).getBackground().setAlpha(255);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).setVisibility(8);
            this.jdField_b_of_type_AndroidViewView = View.inflate(this, 2130970624, null);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
            this.jdField_b_of_type_AndroidViewView.getLayoutParams().height = getResources().getDimensionPixelSize(2131558785);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            localObject1 = new FormSimpleItem(this);
            a(5, 1, (FormSimpleItem)localObject1, getString(2131433661), "设置群聊资料、加群方式等", true);
            this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject1;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (!this.jdField_b_of_type_Boolean)) {
              break label3867;
            }
            i1 = 0;
            ((FormSimpleItem)localObject1).setVisibility(i1);
            localObject3 = new FormSimpleItem(this);
            this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject3;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
            if (i1 != 0) {
              break label3873;
            }
            i1 = 3;
            localObject4 = getString(2131433637);
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard)) {
              break label3878;
            }
            localObject1 = getString(2131430580);
            a(6, i1, (FormSimpleItem)localObject3, (String)localObject4, (CharSequence)localObject1, true);
            localObject1 = (TroopPluginManager)this.app.getManager(118);
            if (localObject1 != null) {
              this.jdField_b_of_type_Boolean = ((TroopPluginManager)localObject1).a("troop_manage_plugin.apk", new scc(this));
            }
            localObject1 = View.inflate(this, 2130970624, null);
            ((View)localObject1).setBackgroundResource(2130846313);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131558785);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop()))
            {
              localObject1 = new FormSimpleItem(this);
              a(51, 1, (FormSimpleItem)localObject1, "查看老师和管理员聊天内容", "", true);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
              TroopReportor.a("Grp_edu", "Grp_data", "teachermsg_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
            }
            localObject1 = new FormSimpleItem(this);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop())) {
              break label3890;
            }
            i1 = 2;
            a(42, i1, (FormSimpleItem)localObject1, getString(2131430416), "图片、视频、文件等", true);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            localObject1 = new FormSwitchItem(this, null);
            ((FormSwitchItem)localObject1).setBackgroundResource(2130838629);
            ((FormSwitchItem)localObject1).setText(getString(2131435373));
            ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColor(2131494210));
            ((FormSwitchItem)localObject1).setFocusable(true);
            ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
            ((FormSwitchItem)localObject1).setContentDescription(getString(2131435373));
            this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject1;
            localObject3 = ((FormSwitchItem)localObject1).a();
            ((Switch)localObject3).setTrackResource(2130840544);
            ((Switch)localObject3).setThumbResource(2130840543);
            ((Switch)localObject3).setTag(Boolean.FALSE);
            i1 = this.app.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
              this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopmask = i1;
            }
            if (i1 == 1) {
              break label3895;
            }
            bool = true;
            ((Switch)localObject3).setChecked(bool);
            ((Switch)localObject3).setOnCheckedChangeListener(new scd(this));
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            localObject1 = View.inflate(this, 2130970614, null);
            localObject3 = (FormSimpleItem)((View)localObject1).findViewById(2131371414);
            a(11, 2, (FormSimpleItem)localObject3, getString(2131433629), "", true);
            this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
            localObject4 = new RelativeLayout.LayoutParams(AIOUtils.a(17.0F, getResources()), AIOUtils.a(17.0F, getResources()));
            ((RelativeLayout.LayoutParams)localObject4).rightMargin = AIOUtils.a(30.0F, getResources());
            ((RelativeLayout.LayoutParams)localObject4).addRule(11);
            ((RelativeLayout.LayoutParams)localObject4).addRule(15);
            ((FormSimpleItem)localObject3).addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject4);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838592));
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_a_of_type_ArrayOfAndroidViewView[11] = localObject1;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            localObject1 = View.inflate(this, 2130970624, null);
            ((View)localObject1).setBackgroundResource(2130846313);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131558785);
            localObject1 = new FormSwitchItem(this, null);
            ((FormSwitchItem)localObject1).setBgType(1);
            ((FormSwitchItem)localObject1).setText(getString(2131435371));
            ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColor(2131494210));
            ((FormSwitchItem)localObject1).setFocusable(true);
            ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
            ((FormSwitchItem)localObject1).setContentDescription(getString(2131435371));
            this.jdField_a_of_type_ArrayOfAndroidViewView[9] = localObject1;
            localObject3 = ((FormSwitchItem)localObject1).a();
            ((Switch)localObject3).setTrackResource(2130840544);
            ((Switch)localObject3).setThumbResource(2130840543);
            if (!((TroopManager)this.app.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
              break label3901;
            }
            ((Switch)localObject3).setChecked(true);
            ((Switch)localObject3).setTag(Integer.valueOf(9));
            ((Switch)localObject3).setOnCheckedChangeListener(this);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            if (!this.jdField_d_of_type_Boolean)
            {
              localObject1 = new FormSwitchItem(this, null);
              ((FormSwitchItem)localObject1).setBgType(2);
              ((FormSwitchItem)localObject1).setText(getResources().getString(2131430399));
              ((FormSwitchItem)localObject1).setFocusable(true);
              ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColor(2131494210));
              localObject3 = ((FormSwitchItem)localObject1).a();
              ((Switch)localObject3).setTrackResource(2130840544);
              ((Switch)localObject3).setThumbResource(2130840543);
              ((Switch)localObject3).setTag(Boolean.FALSE);
              this.jdField_a_of_type_ArrayOfAndroidViewView[20] = localObject1;
              localObject3 = ((FormSwitchItem)localObject1).a();
              ((Switch)localObject3).setTag(Integer.valueOf(20));
              ((Switch)localObject3).setOnCheckedChangeListener(null);
              bool = ((TroopInfoManager)this.app.getManager(36)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              ((Switch)localObject3).setChecked(bool);
              ((Switch)localObject3).setOnCheckedChangeListener(this);
              ((FormSwitchItem)localObject1).setContentDescription(getString(2131430399));
              if (bool) {
                ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "share_save_open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
              }
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
              localObject1 = new FormSwitchItem(this, null);
              ((FormSwitchItem)localObject1).setBgType(2);
              ((FormSwitchItem)localObject1).setText(getResources().getString(2131430369));
              ((FormSwitchItem)localObject1).setFocusable(true);
              ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColor(2131494210));
              localObject3 = ((FormSwitchItem)localObject1).a();
              ((Switch)localObject3).setTrackResource(2130840544);
              ((Switch)localObject3).setThumbResource(2130840543);
              ((Switch)localObject3).setTag(Boolean.FALSE);
              this.jdField_a_of_type_ArrayOfAndroidViewView[19] = localObject1;
              localObject3 = ((FormSwitchItem)localObject1).a();
              ((Switch)localObject3).setTag(Integer.valueOf(19));
              bool = ((TroopManager)this.app.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              ((Switch)localObject3).setOnCheckedChangeListener(null);
              ((Switch)localObject3).setChecked(bool);
              ((Switch)localObject3).setOnCheckedChangeListener(this);
              ((FormSwitchItem)localObject1).setContentDescription(getString(2131430369));
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            }
            localObject1 = new FormSimpleItem(this);
            this.jdField_a_of_type_ArrayOfAndroidViewView[16] = localObject1;
            a(16, 3, (FormSimpleItem)localObject1, "聊天背景", "", true);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            if (!this.jdField_d_of_type_Boolean)
            {
              localObject1 = new FormSimpleItem(this);
              this.jdField_a_of_type_ArrayOfAndroidViewView[17] = localObject1;
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
              a(17, 3, (FormSimpleItem)localObject1, getString(2131434971), "", true);
              ((FormSimpleItem)localObject1).setVisibility(8);
              if (((TroopEnterEffectManager)this.app.getManager(230)).b()) {
                a(true);
              }
            }
            localObject1 = View.inflate(this, 2130970624, null);
            ((View)localObject1).setBackgroundResource(2130846313);
            this.jdField_a_of_type_ArrayOfAndroidViewView[26] = localObject1;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131558785);
            ((View)localObject1).setVisibility(8);
            localObject1 = new FormSimpleItem(this);
            this.jdField_a_of_type_ArrayOfAndroidViewView[25] = localObject1;
            a(25, 0, (FormSimpleItem)localObject1, "更多资料", "", true);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((FormSimpleItem)localObject1).setVisibility(8);
            localObject1 = View.inflate(this, 2130970624, null);
            ((View)localObject1).setBackgroundResource(2130846313);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131558785);
            localObject1 = View.inflate(this, 2130970610, null);
            this.jdField_a_of_type_ArrayOfAndroidViewView[28] = localObject1;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            a(28, 0, (View)localObject1, getString(2131430413), null, false);
            ((View)localObject1).setTag(Integer.valueOf(28));
            ((View)localObject1).setOnClickListener(this);
            localObject3 = (TextView)((View)localObject1).findViewById(2131363360);
            if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
              ((TextView)localObject3).setAlpha(0.5F);
            }
            ((TextView)localObject3).setTextColor(Color.parseColor("#00b6f9"));
            localObject1 = (TextView)((View)localObject1).findViewById(2131364095);
            if (localObject1 != null) {
              ((TextView)localObject1).setVisibility(8);
            }
            localObject1 = View.inflate(this, 2130970624, null);
            ((View)localObject1).setBackgroundResource(2130846313);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131558785);
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "initUI: time = " + (System.currentTimeMillis() - l1));
            }
            this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365740);
            this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131365783));
            this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new rzl(this));
            if (this.jdField_d_of_type_Int == 2)
            {
              this.jdField_a_of_type_AndroidViewView.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
              if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
                break label4208;
              }
              i1 = 1;
              if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
                break label4213;
              }
              this.jdField_a_of_type_AndroidWidgetButton.setText(2131435743);
              this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(45));
              this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
            }
            if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
              break label4506;
            }
            i1 = 1;
            if ((i1 == 0) || (this.jdField_d_of_type_Boolean)) {
              break label4511;
            }
            ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[13].findViewById(2131368431)).setVisibility(0);
            b(false);
            if (this.jdField_d_of_type_Int == 1) {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(18);
            }
            return;
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            if (!QLog.isColorLevel()) {
              break label3793;
            }
            QLog.d("Q.chatopttroop", 2, localOutOfMemoryError2.getMessage());
            finish();
            return;
          }
          catch (InflateException localInflateException)
          {
            if (!QLog.isColorLevel()) {
              break label3818;
            }
            QLog.d("Q.chatopttroop", 2, localInflateException.getMessage());
            finish();
            return;
          }
          localOutOfMemoryError1 = localOutOfMemoryError1;
          finish();
          localOutOfMemoryError1.printStackTrace();
          return;
        }
        continue;
        boolean bool = false;
        continue;
        localImageView.setVisibility(8);
        ((FollowImageTextView)localObject5).setMaxWidth((int)DeviceInfoUtil.j() - UIUtils.a(this, 60.0F));
        continue;
        i1 = 2130841415;
        continue;
        ((TextView)localObject3).setVisibility(8);
        continue;
        i1 = 8;
        continue;
        i1 = 0;
        continue;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard;
        continue;
        i1 = 1;
        continue;
        bool = false;
        continue;
        ((Switch)localObject3).setChecked(false);
      }
    } while (this.jdField_d_of_type_Int != 2);
    label3723:
    label3767:
    label3793:
    label3818:
    Object localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
    label3850:
    label3857:
    label3867:
    label3873:
    label3878:
    label3890:
    label3895:
    label3901:
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      localObject2 = (String)localObject2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
    }
    for (;;)
    {
      localObject3 = (ExpandableTextView)View.inflate(this, 2130969921, null);
      ((ExpandableTextView)localObject3).setText(new QQText((CharSequence)localObject2, 11, 16));
      ((ExpandableTextView)localObject3).a().setEditableFactory(QQTextBuilder.a);
      ((ExpandableTextView)localObject3).a().setMovementMethod(LinkMovementMethod.getInstance());
      i1 = AIOUtils.a(12.0F, getResources());
      i2 = AIOUtils.a(15.0F, getResources());
      ((ExpandableTextView)localObject3).setBackgroundResource(2130838619);
      ((ExpandableTextView)localObject3).setOnExpandStateChangeListener(new rzk(this));
      this.jdField_a_of_type_ArrayOfAndroidViewView[34] = localObject3;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
      ((ExpandableTextView)localObject3).setPadding(i1, i2, i1, i2);
      localObject2 = View.inflate(this, 2130970624, null);
      ((View)localObject2).setBackgroundResource(2130846313);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView = new TroopMoreDetailView(this);
      localObject2 = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setGuestVisitor(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView);
      localObject2 = View.inflate(this, 2130970624, null);
      ((View)localObject2).setBackgroundResource(2130846313);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      break;
      label4208:
      i1 = 0;
      break label3616;
      label4213:
      if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) && (i1 != 0))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131435744, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
        this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(48));
        this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        break label3656;
      }
      if ("true".equals(this.jdField_f_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131433034);
        this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(50));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
        break label3656;
      }
      if (this.jdField_j_of_type_Int == 2) {
        ReportController.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_objgrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131433033);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(46));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
      if (!QSecFramework.a().a(1001).booleanValue()) {
        break label3656;
      }
      localObject2 = this.jdField_a_of_type_AndroidWidgetButton;
      QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(2), localObject2 }, null);
      break label3656;
      label4506:
      i1 = 0;
      break label3692;
      label4511:
      ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[13].findViewById(2131368431)).setVisibility(8);
      break label3723;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[41];
    if (localObject == null) {}
    String str;
    do
    {
      return;
      str = String.format(getString(2131435213), new Object[] { String.valueOf(paramInt1) });
      localObject = (TextView)((View)localObject).findViewById(2131364095);
    } while (localObject == null);
    ((TextView)localObject).setText(str);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramString = (TextView)paramView.findViewById(2131364095);
    if (paramString != null)
    {
      paramString.setEditableFactory(QQTextBuilder.a);
      if (!TextUtils.isEmpty(paramCharSequence)) {
        break label54;
      }
    }
    label54:
    for (paramView = "";; paramView = new QQText(paramCharSequence, 3))
    {
      paramString.setText(paramView);
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, boolean paramBoolean)
  {
    label52:
    TextView localTextView;
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
      switch (paramInt2)
      {
      default: 
        paramView.getBackground().setAlpha(255);
        localTextView = (TextView)paramView.findViewById(2131363360);
        if (localTextView != null)
        {
          if (!TextUtils.isEmpty(paramString)) {
            break label176;
          }
          localTextView.setText("");
          localTextView.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      a(paramInt1, paramView, paramBoolean);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130838619);
      break label52;
      paramView.setBackgroundResource(2130838631);
      break label52;
      paramView.setBackgroundResource(2130838629);
      break label52;
      paramView.setBackgroundResource(2130838626);
      break label52;
      paramView.setBackgroundColor(Color.parseColor("#00000000"));
      break label52;
      label176:
      localTextView.setText(paramString);
      localTextView.setVisibility(0);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, FormSimpleItem paramFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramFormSimpleItem.setOnClickListener(this);
      paramFormSimpleItem.a(true);
      switch (paramInt2)
      {
      default: 
        label60:
        paramFormSimpleItem.getBackground().setAlpha(255);
        String str = paramString;
        if (paramString == null) {
          str = "";
        }
        paramFormSimpleItem.setLeftText(str);
        paramFormSimpleItem.a().setTextColor(getResources().getColor(2131494210));
        paramString = paramFormSimpleItem.a();
        paramString.setTextColor(getResources().getColor(2131492970));
        paramString.setEditableFactory(QQTextBuilder.a);
        if (paramCharSequence != null) {
          break;
        }
      }
    }
    for (paramString = "";; paramString = new QQText(paramCharSequence, 3))
    {
      paramFormSimpleItem.setRightText(paramString);
      return;
      paramFormSimpleItem.setTag(null);
      paramFormSimpleItem.setOnClickListener(null);
      paramFormSimpleItem.a(false);
      break;
      paramFormSimpleItem.setBgType(0);
      break label60;
      paramFormSimpleItem.setBgType(1);
      break label60;
      paramFormSimpleItem.setBgType(2);
      break label60;
      paramFormSimpleItem.setBgType(3);
      break label60;
      paramFormSimpleItem.setBackgroundColor(Color.parseColor("#00000000"));
      break label60;
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {
      return;
    }
    J();
    a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_MqqObserverBusinessObserver);
  }
  
  public void a(int paramInt, View paramView, List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    LinearLayout localLinearLayout;
    if (paramView != null)
    {
      localLinearLayout = (LinearLayout)paramView.findViewById(2131371412);
      localLinearLayout.removeAllViews();
      if (paramList != null) {}
    }
    else
    {
      return;
    }
    int i1 = 0;
    if ((i1 < paramList.size()) && (i1 < 3))
    {
      if (TextUtils.isEmpty((CharSequence)paramList.get(i1))) {}
      for (;;)
      {
        i1 += 1;
        break;
        TextView localTextView = new TextView(this);
        localTextView.setId(2131362056);
        localTextView.setBackgroundResource(2130841391);
        localTextView.setTextSize(1, 12.0F);
        if (paramBoolean2) {
          localTextView.setMaxWidth(AIOUtils.a(77.0F, getResources()));
        }
        localTextView.setSingleLine();
        localTextView.setTextColor(-1);
        localTextView.setPadding(AIOUtils.a(4.0F, getResources()), AIOUtils.a(0.0F, getResources()), AIOUtils.a(4.0F, getResources()), AIOUtils.a(0.0F, getResources()));
        localTextView.setGravity(17);
        localTextView.setText((CharSequence)paramList.get(i1));
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localTextView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, AIOUtils.a(17.0F, getResources()));
        localLayoutParams.leftMargin = AIOUtils.a(5.0F, getResources());
        localLinearLayout.addView(localTextView, localLayoutParams);
      }
    }
    paramList = paramView.findViewById(2131363425);
    if (paramBoolean1)
    {
      paramView.setTag(Integer.valueOf(paramInt));
      paramView.setOnClickListener(this);
      paramList.setVisibility(0);
      return;
    }
    paramView.setTag(null);
    paramView.setOnClickListener(null);
    paramList.setVisibility(8);
  }
  
  protected void a(int paramInt, View paramView, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramView == null) {}
    boolean bool;
    do
    {
      return;
      bool = paramBoolean;
      if (this.jdField_d_of_type_Int == 2)
      {
        bool = paramBoolean;
        if (34 == paramInt) {
          bool = false;
        }
      }
      paramView = paramView.findViewById(2131363425);
    } while (paramView == null);
    if (bool) {}
    for (paramInt = i1;; paramInt = 8)
    {
      paramView.setVisibility(paramInt);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    ThreadManager.post(new rzw(this, paramLong), 8, null, true);
  }
  
  /* Error */
  public void a(KQQ.BatchResponse paramBatchResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 2225	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 2227	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 2228	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 10
    //   21: aload 10
    //   23: aload_1
    //   24: getfield 2232	KQQ/BatchResponse:buffer	[B
    //   27: checkcast 2233	[B
    //   30: invokevirtual 2234	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 2237	KQQ/BatchResponse:seq	I
    //   38: ifne +811 -> 849
    //   41: aload 10
    //   43: ifnull +806 -> 849
    //   46: aload 10
    //   48: getfield 2241	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 2246	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   54: ifeq +795 -> 849
    //   57: aload 10
    //   59: getfield 2241	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 2249	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 2252	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   68: astore 8
    //   70: new 2254	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   73: dup
    //   74: invokespecial 2255	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   77: astore 9
    //   79: aload 9
    //   81: aload 8
    //   83: invokevirtual 2256	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   86: pop
    //   87: aconst_null
    //   88: astore 8
    //   90: aload 9
    //   92: getfield 2259	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: invokevirtual 2262	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   98: astore 11
    //   100: aload 11
    //   102: ifnonnull +53 -> 155
    //   105: iconst_0
    //   106: istore_3
    //   107: goto +1400 -> 1507
    //   110: aload 8
    //   112: ifnonnull +737 -> 849
    //   115: iload 4
    //   117: iload_3
    //   118: if_icmpge +731 -> 849
    //   121: aload 11
    //   123: iload 4
    //   125: invokeinterface 2171 2 0
    //   130: checkcast 2264	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   133: astore 9
    //   135: aload 9
    //   137: ifnonnull +29 -> 166
    //   140: iload 4
    //   142: iconst_1
    //   143: iadd
    //   144: istore 4
    //   146: goto -36 -> 110
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 2265	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   154: return
    //   155: aload 11
    //   157: invokeinterface 2168 1 0
    //   162: istore_3
    //   163: goto +1344 -> 1507
    //   166: aload 9
    //   168: getfield 2268	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   171: invokevirtual 1219	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   174: istore_2
    //   175: iload_2
    //   176: bipush 72
    //   178: if_icmpne +173 -> 351
    //   181: iload 4
    //   183: ifne +168 -> 351
    //   186: aload_0
    //   187: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Int	I
    //   190: iconst_1
    //   191: if_icmpeq +13 -> 204
    //   194: aload_0
    //   195: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   198: getfield 337	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   201: ifeq +123 -> 324
    //   204: aload_0
    //   205: ldc_w 2269
    //   208: iconst_1
    //   209: invokestatic 1480	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   212: aload_0
    //   213: invokevirtual 1483	com/tencent/mobileqq/activity/ChatSettingForTroop:getTitleBarHeight	()I
    //   216: invokevirtual 1486	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   219: pop
    //   220: aload_0
    //   221: getfield 264	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   224: bipush 51
    //   226: invokevirtual 270	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   229: checkcast 339	com/tencent/mobileqq/app/TroopManager
    //   232: astore 9
    //   234: aload 9
    //   236: ifnull +15 -> 251
    //   239: aload 9
    //   241: aload_0
    //   242: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   245: getfield 342	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   248: invokevirtual 2270	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)V
    //   251: aload_0
    //   252: aconst_null
    //   253: putfield 412	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   256: aload_0
    //   257: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   260: iconst_0
    //   261: putfield 337	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   264: aload_0
    //   265: invokevirtual 782	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   268: astore 9
    //   270: aload 9
    //   272: ldc_w 2272
    //   275: iconst_0
    //   276: invokevirtual 703	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   279: pop
    //   280: aload 9
    //   282: ldc_w 1032
    //   285: iconst_2
    //   286: invokevirtual 451	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   289: pop
    //   290: aload 9
    //   292: ldc_w 2273
    //   295: invokevirtual 1037	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   298: pop
    //   299: aload_0
    //   300: invokevirtual 710	com/tencent/mobileqq/activity/ChatSettingForTroop:finish	()V
    //   303: aload_0
    //   304: iconst_0
    //   305: iconst_0
    //   306: invokevirtual 2276	com/tencent/mobileqq/activity/ChatSettingForTroop:overridePendingTransition	(II)V
    //   309: aload_0
    //   310: aload 9
    //   312: invokevirtual 724	com/tencent/mobileqq/activity/ChatSettingForTroop:startActivity	(Landroid/content/Intent;)V
    //   315: aload_0
    //   316: iconst_0
    //   317: iconst_0
    //   318: invokevirtual 2276	com/tencent/mobileqq/activity/ChatSettingForTroop:overridePendingTransition	(II)V
    //   321: goto -181 -> 140
    //   324: aload_0
    //   325: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Int	I
    //   328: iconst_2
    //   329: if_icmpne +1175 -> 1504
    //   332: aload_0
    //   333: ldc_w 2277
    //   336: iconst_1
    //   337: invokestatic 1480	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   340: aload_0
    //   341: invokevirtual 1483	com/tencent/mobileqq/activity/ChatSettingForTroop:getTitleBarHeight	()I
    //   344: invokevirtual 1486	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   347: pop
    //   348: goto -208 -> 140
    //   351: iload_2
    //   352: ifne +1152 -> 1504
    //   355: aload 9
    //   357: getfield 2281	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   360: invokevirtual 2284	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   363: ifeq +1141 -> 1504
    //   366: aload 9
    //   368: getfield 2281	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   371: invokevirtual 2287	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   374: checkcast 2283	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   377: astore 9
    //   379: aload 9
    //   381: astore 8
    //   383: aload 9
    //   385: ifnull -245 -> 140
    //   388: aload 9
    //   390: astore 8
    //   392: aload_0
    //   393: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   396: ifnull -256 -> 140
    //   399: aload_0
    //   400: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   403: aload 9
    //   405: invokevirtual 2291	com/tencent/mobileqq/troopinfo/TroopInfoData:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   408: aload_0
    //   409: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   412: getfield 720	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   415: invokestatic 647	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   418: ifne +14 -> 432
    //   421: aload_0
    //   422: aload_0
    //   423: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   426: getfield 720	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   429: invokevirtual 1825	com/tencent/mobileqq/activity/ChatSettingForTroop:b	(Ljava/lang/String;)V
    //   432: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq +79 -> 514
    //   438: aload 9
    //   440: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   443: invokevirtual 1219	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   446: istore_2
    //   447: new 495	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 496	java/lang/StringBuilder:<init>	()V
    //   454: ldc_w 2296
    //   457: invokevirtual 500	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: astore 12
    //   462: aload_0
    //   463: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   466: ifnonnull +903 -> 1369
    //   469: ldc 240
    //   471: astore 8
    //   473: ldc_w 2298
    //   476: iconst_2
    //   477: aload 12
    //   479: aload 8
    //   481: invokevirtual 500	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: ldc_w 2300
    //   487: invokevirtual 500	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: iload_2
    //   491: invokevirtual 1233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: ldc_w 2302
    //   497: invokevirtual 500	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: iload_2
    //   501: i2l
    //   502: invokestatic 2305	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(J)Z
    //   505: invokevirtual 1686	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   508: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 289	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: aload_0
    //   515: getfield 412	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   518: ifnull +26 -> 544
    //   521: aload_0
    //   522: getfield 412	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   525: aload 9
    //   527: invokevirtual 2306	com/tencent/mobileqq/data/TroopInfo:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   530: aload_0
    //   531: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   534: aload_0
    //   535: getfield 412	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   538: invokevirtual 493	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   541: putfield 720	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   544: aload_0
    //   545: aload 9
    //   547: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   550: invokevirtual 1219	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   553: i2l
    //   554: invokestatic 2305	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(J)Z
    //   557: putfield 374	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   560: aload_0
    //   561: getfield 374	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   564: ifeq +77 -> 641
    //   567: aload_0
    //   568: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   571: getfield 415	com/tencent/mobileqq/troopinfo/TroopInfoData:bOwner	Z
    //   574: ifeq +807 -> 1381
    //   577: iconst_1
    //   578: istore_2
    //   579: new 2308	com/tencent/mobileqq/statistics/ReportTask
    //   582: dup
    //   583: aload_0
    //   584: getfield 264	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   587: invokespecial 2311	com/tencent/mobileqq/statistics/ReportTask:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   590: ldc_w 468
    //   593: invokevirtual 2314	com/tencent/mobileqq/statistics/ReportTask:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   596: ldc_w 2316
    //   599: invokevirtual 2318	com/tencent/mobileqq/statistics/ReportTask:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   602: ldc_w 472
    //   605: invokevirtual 2320	com/tencent/mobileqq/statistics/ReportTask:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   608: ldc_w 2322
    //   611: invokevirtual 2324	com/tencent/mobileqq/statistics/ReportTask:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   614: iconst_2
    //   615: anewarray 511	java/lang/String
    //   618: dup
    //   619: iconst_0
    //   620: aload_0
    //   621: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   624: getfield 342	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   627: aastore
    //   628: dup
    //   629: iconst_1
    //   630: iload_2
    //   631: invokestatic 980	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   634: aastore
    //   635: invokevirtual 2327	com/tencent/mobileqq/statistics/ReportTask:a	([Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   638: invokevirtual 2329	com/tencent/mobileqq/statistics/ReportTask:a	()V
    //   641: aload_0
    //   642: getfield 374	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   645: ifne +783 -> 1428
    //   648: aload_0
    //   649: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   652: getfield 2332	com/tencent/mobileqq/troopinfo/TroopInfoData:isNewTroop	Z
    //   655: ifne +773 -> 1428
    //   658: iconst_1
    //   659: istore 5
    //   661: aload_0
    //   662: iload 5
    //   664: invokespecial 1062	com/tencent/mobileqq/activity/ChatSettingForTroop:c	(Z)V
    //   667: aload_0
    //   668: invokevirtual 1832	com/tencent/mobileqq/activity/ChatSettingForTroop:A	()V
    //   671: aload_0
    //   672: invokevirtual 2334	com/tencent/mobileqq/activity/ChatSettingForTroop:n	()V
    //   675: aload_0
    //   676: getfield 264	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   679: aload_0
    //   680: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   683: getfield 2337	com/tencent/mobileqq/troopinfo/TroopInfoData:publicAccountUin	J
    //   686: new 2339	sav
    //   689: dup
    //   690: aload_0
    //   691: invokespecial 2340	sav:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   694: invokestatic 2345	com/tencent/mobileqq/troop/utils/TroopBindPubAccountProtocol:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLcom/tencent/biz/ProtoUtils$TroopProtocolObserver;)V
    //   697: new 2347	saw
    //   700: dup
    //   701: aload_0
    //   702: invokespecial 2348	saw:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   705: bipush 8
    //   707: aconst_null
    //   708: iconst_1
    //   709: invokestatic 2219	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   712: aload_0
    //   713: invokevirtual 2350	com/tencent/mobileqq/activity/ChatSettingForTroop:m	()V
    //   716: aload_0
    //   717: invokespecial 2352	com/tencent/mobileqq/activity/ChatSettingForTroop:M	()V
    //   720: aload_0
    //   721: invokevirtual 2353	com/tencent/mobileqq/activity/ChatSettingForTroop:e	()V
    //   724: aload_0
    //   725: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   728: getfield 595	com/tencent/mobileqq/troopinfo/TroopInfoData:wMemberNum	I
    //   731: ifle +31 -> 762
    //   734: aload_0
    //   735: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   738: getfield 2356	com/tencent/mobileqq/troopinfo/TroopInfoData:troopMemberMaxNum	I
    //   741: ifle +21 -> 762
    //   744: aload_0
    //   745: aload_0
    //   746: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   749: getfield 595	com/tencent/mobileqq/troopinfo/TroopInfoData:wMemberNum	I
    //   752: aload_0
    //   753: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   756: getfield 2356	com/tencent/mobileqq/troopinfo/TroopInfoData:troopMemberMaxNum	I
    //   759: invokevirtual 2358	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(II)V
    //   762: aload_0
    //   763: invokevirtual 2361	com/tencent/mobileqq/activity/ChatSettingForTroop:x	()V
    //   766: aload_0
    //   767: invokevirtual 1848	com/tencent/mobileqq/activity/ChatSettingForTroop:y	()V
    //   770: aload_0
    //   771: invokevirtual 1845	com/tencent/mobileqq/activity/ChatSettingForTroop:v	()V
    //   774: aload_0
    //   775: invokevirtual 2363	com/tencent/mobileqq/activity/ChatSettingForTroop:w	()V
    //   778: aload_0
    //   779: getfield 412	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   782: ifnull +7 -> 789
    //   785: aload_0
    //   786: invokevirtual 2366	com/tencent/mobileqq/activity/ChatSettingForTroop:u	()V
    //   789: aload_0
    //   790: invokevirtual 2368	com/tencent/mobileqq/activity/ChatSettingForTroop:g	()V
    //   793: aload 9
    //   795: astore 8
    //   797: aload_0
    //   798: getfield 2097	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   801: ifnull -661 -> 140
    //   804: aload_0
    //   805: getfield 2097	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   808: aload_0
    //   809: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   812: invokevirtual 2372	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:setTroopInfoData	(Lcom/tencent/mobileqq/troopinfo/TroopInfoData;)V
    //   815: aload_0
    //   816: getfield 2097	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   819: invokevirtual 2373	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:a	()V
    //   822: aload 9
    //   824: astore 8
    //   826: goto -686 -> 140
    //   829: astore 8
    //   831: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   834: ifeq +15 -> 849
    //   837: ldc_w 2375
    //   840: iconst_2
    //   841: aload 8
    //   843: invokevirtual 1041	java/lang/Exception:toString	()Ljava/lang/String;
    //   846: invokestatic 1043	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   849: aload_1
    //   850: getfield 2237	KQQ/BatchResponse:seq	I
    //   853: iconst_1
    //   854: if_icmpne +100 -> 954
    //   857: aload 10
    //   859: ifnull +95 -> 954
    //   862: aload 10
    //   864: getfield 2241	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   867: invokevirtual 2246	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   870: ifeq +84 -> 954
    //   873: aload 10
    //   875: getfield 2241	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   878: invokevirtual 2249	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   881: invokevirtual 2252	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   884: astore 8
    //   886: new 2377	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   889: dup
    //   890: invokespecial 2378	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   893: astore 9
    //   895: aload 9
    //   897: aload 8
    //   899: invokevirtual 2379	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   902: pop
    //   903: aload 9
    //   905: getfield 2382	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   908: invokevirtual 2383	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   911: ifeq +43 -> 954
    //   914: aload_0
    //   915: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Int	I
    //   918: iconst_2
    //   919: if_icmpne +515 -> 1434
    //   922: aload_0
    //   923: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   926: getfield 337	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   929: ifne +505 -> 1434
    //   932: aload_0
    //   933: getfield 2097	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   936: ifnull +18 -> 954
    //   939: aload_0
    //   940: getfield 2097	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   943: aload 9
    //   945: getfield 2382	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   948: invokevirtual 2262	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   951: invokevirtual 2385	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:a	(Ljava/util/List;)V
    //   954: aload_1
    //   955: getfield 2237	KQQ/BatchResponse:seq	I
    //   958: iconst_2
    //   959: if_icmpne -948 -> 11
    //   962: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   965: ifeq +13 -> 978
    //   968: ldc_w 2387
    //   971: iconst_2
    //   972: ldc_w 2389
    //   975: invokestatic 289	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   978: aload 10
    //   980: ifnull -969 -> 11
    //   983: aload 10
    //   985: getfield 2241	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   988: invokevirtual 2246	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   991: ifeq -980 -> 11
    //   994: aload 10
    //   996: getfield 2241	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   999: invokevirtual 2249	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1002: invokevirtual 2252	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1005: astore_1
    //   1006: new 2391	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   1009: dup
    //   1010: invokespecial 2392	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   1013: astore 8
    //   1015: aload 8
    //   1017: aload_1
    //   1018: invokevirtual 2393	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1021: pop
    //   1022: aload 8
    //   1024: getfield 2394	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1027: invokevirtual 2395	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1030: ifeq -1019 -> 11
    //   1033: aload 8
    //   1035: getfield 2398	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1038: invokevirtual 2400	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   1041: ifne +458 -> 1499
    //   1044: aload 8
    //   1046: getfield 2398	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1049: invokevirtual 2262	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1052: astore_1
    //   1053: aload_0
    //   1054: getfield 264	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1057: bipush 51
    //   1059: invokevirtual 270	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1062: checkcast 339	com/tencent/mobileqq/app/TroopManager
    //   1065: astore 9
    //   1067: aload 8
    //   1069: getfield 2394	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1072: invokevirtual 1381	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1075: lstore 6
    //   1077: aload 9
    //   1079: lload 6
    //   1081: invokestatic 942	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1084: invokevirtual 482	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   1087: astore 10
    //   1089: aload 10
    //   1091: ifnull -1080 -> 11
    //   1094: aload_1
    //   1095: ifnull +69 -> 1164
    //   1098: aload 10
    //   1100: aload_1
    //   1101: invokevirtual 2403	com/tencent/mobileqq/data/TroopInfo:setTroopLevelMap787	(Ljava/util/List;)V
    //   1104: aload 8
    //   1106: getfield 2406	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1109: invokevirtual 2407	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1112: ifeq +360 -> 1472
    //   1115: aload 8
    //   1117: getfield 2406	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1120: invokevirtual 1219	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1123: istore_2
    //   1124: aload 10
    //   1126: iload_2
    //   1127: i2l
    //   1128: putfield 2410	com/tencent/mobileqq/data/TroopInfo:dwGroupLevelSeq	J
    //   1131: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1134: ifeq +30 -> 1164
    //   1137: ldc_w 2387
    //   1140: iconst_2
    //   1141: new 495	java/lang/StringBuilder
    //   1144: dup
    //   1145: invokespecial 496	java/lang/StringBuilder:<init>	()V
    //   1148: ldc_w 2412
    //   1151: invokevirtual 500	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: iload_2
    //   1155: invokevirtual 1233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1158: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1161: invokestatic 289	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1164: aload 8
    //   1166: getfield 2415	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1169: astore_1
    //   1170: aload_1
    //   1171: ifnull +19 -> 1190
    //   1174: aload 10
    //   1176: aload 8
    //   1178: getfield 2415	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1181: invokevirtual 2249	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1184: invokevirtual 2418	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1187: putfield 2421	com/tencent/mobileqq/data/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   1190: aload 8
    //   1192: getfield 2424	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1195: astore_1
    //   1196: aload_1
    //   1197: ifnull +19 -> 1216
    //   1200: aload 10
    //   1202: aload 8
    //   1204: getfield 2424	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1207: invokevirtual 2249	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1210: invokevirtual 2418	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1213: putfield 2427	com/tencent/mobileqq/data/TroopInfo:adminNameShow	Ljava/lang/String;
    //   1216: iconst_m1
    //   1217: istore_2
    //   1218: iconst_m1
    //   1219: istore_3
    //   1220: aload 8
    //   1222: getfield 2430	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1225: invokevirtual 2407	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1228: ifeq +23 -> 1251
    //   1231: aload 10
    //   1233: aload 8
    //   1235: getfield 2430	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1238: invokevirtual 1219	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1241: i2b
    //   1242: putfield 2433	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   1245: aload 10
    //   1247: getfield 2433	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   1250: istore_2
    //   1251: aload 8
    //   1253: getfield 2436	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1256: invokevirtual 2407	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1259: ifeq +23 -> 1282
    //   1262: aload 10
    //   1264: aload 8
    //   1266: getfield 2436	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1269: invokevirtual 1219	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1272: i2b
    //   1273: putfield 2439	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1276: aload 10
    //   1278: getfield 2439	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1281: istore_3
    //   1282: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1285: ifeq +45 -> 1330
    //   1288: ldc_w 2387
    //   1291: iconst_2
    //   1292: new 495	java/lang/StringBuilder
    //   1295: dup
    //   1296: invokespecial 496	java/lang/StringBuilder:<init>	()V
    //   1299: lload 6
    //   1301: invokevirtual 2040	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1304: ldc_w 2441
    //   1307: invokevirtual 500	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: iload_2
    //   1311: invokevirtual 1233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1314: ldc_w 2443
    //   1317: invokevirtual 500	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: iload_3
    //   1321: invokevirtual 1233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1324: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1327: invokestatic 289	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1330: new 2445	say
    //   1333: dup
    //   1334: aload_0
    //   1335: aload 9
    //   1337: aload 10
    //   1339: invokespecial 2448	say:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;Lcom/tencent/mobileqq/app/TroopManager;Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1342: bipush 8
    //   1344: aconst_null
    //   1345: iconst_0
    //   1346: invokestatic 2219	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1349: return
    //   1350: astore_1
    //   1351: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1354: ifeq -1343 -> 11
    //   1357: ldc_w 2387
    //   1360: iconst_2
    //   1361: aload_1
    //   1362: invokevirtual 1041	java/lang/Exception:toString	()Ljava/lang/String;
    //   1365: invokestatic 1405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1368: return
    //   1369: aload_0
    //   1370: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1373: getfield 342	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   1376: astore 8
    //   1378: goto -905 -> 473
    //   1381: aload_0
    //   1382: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1385: getfield 570	com/tencent/mobileqq/troopinfo/TroopInfoData:bAdmin	Z
    //   1388: ifeq +8 -> 1396
    //   1391: iconst_2
    //   1392: istore_2
    //   1393: goto -814 -> 579
    //   1396: aload_0
    //   1397: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Int	I
    //   1400: iconst_1
    //   1401: if_icmpeq +17 -> 1418
    //   1404: aload_0
    //   1405: getfield 124	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1408: getfield 337	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   1411: istore 5
    //   1413: iload 5
    //   1415: ifeq +8 -> 1423
    //   1418: iconst_3
    //   1419: istore_2
    //   1420: goto -841 -> 579
    //   1423: iconst_4
    //   1424: istore_2
    //   1425: goto -846 -> 579
    //   1428: iconst_0
    //   1429: istore 5
    //   1431: goto -770 -> 661
    //   1434: aload_0
    //   1435: aload 9
    //   1437: getfield 2382	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1440: invokevirtual 2262	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1443: invokespecial 1055	com/tencent/mobileqq/activity/ChatSettingForTroop:c	(Ljava/util/List;)V
    //   1446: goto -492 -> 954
    //   1449: astore 8
    //   1451: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1454: ifeq -500 -> 954
    //   1457: ldc_w 2375
    //   1460: iconst_2
    //   1461: aload 8
    //   1463: invokevirtual 1041	java/lang/Exception:toString	()Ljava/lang/String;
    //   1466: invokestatic 1043	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1469: goto -515 -> 954
    //   1472: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1475: ifeq -311 -> 1164
    //   1478: ldc_w 2387
    //   1481: iconst_2
    //   1482: ldc_w 2450
    //   1485: invokestatic 289	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1488: goto -324 -> 1164
    //   1491: astore_1
    //   1492: goto -276 -> 1216
    //   1495: astore_1
    //   1496: goto -306 -> 1190
    //   1499: aconst_null
    //   1500: astore_1
    //   1501: goto -448 -> 1053
    //   1504: goto -1364 -> 140
    //   1507: iconst_0
    //   1508: istore 4
    //   1510: goto -1400 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1513	0	this	ChatSettingForTroop
    //   0	1513	1	paramBatchResponse	KQQ.BatchResponse
    //   174	1251	2	i1	int
    //   106	1215	3	i2	int
    //   115	1394	4	i3	int
    //   659	771	5	bool	boolean
    //   1075	225	6	l1	long
    //   68	757	8	localObject1	Object
    //   829	13	8	localException1	Exception
    //   884	493	8	localObject2	Object
    //   1449	13	8	localException2	Exception
    //   77	1359	9	localObject3	Object
    //   19	1319	10	localObject4	Object
    //   98	58	11	localList	List
    //   460	18	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   21	34	149	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   70	87	829	java/lang/Exception
    //   90	100	829	java/lang/Exception
    //   121	135	829	java/lang/Exception
    //   155	163	829	java/lang/Exception
    //   166	175	829	java/lang/Exception
    //   186	204	829	java/lang/Exception
    //   204	234	829	java/lang/Exception
    //   239	251	829	java/lang/Exception
    //   251	321	829	java/lang/Exception
    //   324	348	829	java/lang/Exception
    //   355	379	829	java/lang/Exception
    //   392	432	829	java/lang/Exception
    //   432	469	829	java/lang/Exception
    //   473	514	829	java/lang/Exception
    //   514	544	829	java/lang/Exception
    //   544	577	829	java/lang/Exception
    //   579	641	829	java/lang/Exception
    //   641	658	829	java/lang/Exception
    //   661	762	829	java/lang/Exception
    //   762	789	829	java/lang/Exception
    //   789	793	829	java/lang/Exception
    //   797	822	829	java/lang/Exception
    //   1369	1378	829	java/lang/Exception
    //   1381	1391	829	java/lang/Exception
    //   1396	1413	829	java/lang/Exception
    //   1006	1053	1350	java/lang/Exception
    //   1053	1089	1350	java/lang/Exception
    //   1098	1164	1350	java/lang/Exception
    //   1164	1170	1350	java/lang/Exception
    //   1190	1196	1350	java/lang/Exception
    //   1220	1251	1350	java/lang/Exception
    //   1251	1282	1350	java/lang/Exception
    //   1282	1330	1350	java/lang/Exception
    //   1330	1349	1350	java/lang/Exception
    //   1472	1488	1350	java/lang/Exception
    //   886	954	1449	java/lang/Exception
    //   1434	1446	1449	java/lang/Exception
    //   1200	1216	1491	java/lang/Exception
    //   1174	1190	1495	java/lang/Exception
  }
  
  protected void a(Bundle paramBundle)
  {
    paramBundle = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_k_of_type_JavaLangString);
    Object localObject1 = this.app.getCurrentAccountUin();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("o");
    if (((String)localObject1).length() < 10)
    {
      int i1 = 0;
      while (i1 < 10 - ((String)localObject1).length())
      {
        ((StringBuilder)localObject2).append("0");
        i1 += 1;
      }
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    for (;;)
    {
      TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
      paramBundle.putString("Cookie", "uin=" + localObject2 + "; skey=" + localTicketManager.getSkey((String)localObject1));
      paramBundle.putString("Host", "info.gamecenter.qq.com");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("appid", this.jdField_c_of_type_JavaLangString);
      ((Bundle)localObject1).putString("guild_id", this.jdField_g_of_type_JavaLangString);
      ((Bundle)localObject1).putString("zone_id", this.jdField_h_of_type_JavaLangString);
      ((Bundle)localObject1).putString("gc", this.jdField_j_of_type_JavaLangString);
      ((Bundle)localObject1).putString("platid", "2");
      ((Bundle)localObject1).putString("roleid", this.jdField_i_of_type_JavaLangString);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("module", "gc_bind_group_svr");
      ((Bundle)localObject2).putString("method", "join_group");
      localObject1 = TroopUtils.a((Bundle)localObject1, (Bundle)localObject2);
      paramBundle.putString("param", (String)localObject1);
      paramBundle.putString("signature", TroopUtils.a((String)localObject1 + "ea779693bfa42c986ad85cda9bdfce45").toUpperCase());
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("BUNDLE", paramBundle);
      ((HashMap)localObject1).put("CONTEXT", getApplicationContext());
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "joinGroupOneStep params = " + paramBundle);
      }
      new HttpWebCgiAsyncTask2(localStringBuilder.toString(), "GET", this, 1, null).a((HashMap)localObject1);
      return;
      ((StringBuilder)localObject2).append("0");
      ((StringBuilder)localObject2).append((String)localObject1);
    }
  }
  
  protected void a(View paramView)
  {
    int[] arrayOfInt = new int[6];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 2131371420;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131371421;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131371422;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131371423;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131371424;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131371425;
    tmp38_32;
    this.jdField_b_of_type_JavaUtilList = new ArrayList(6);
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = arrayOfInt[i1];
      this.jdField_b_of_type_JavaUtilList.add((ImageView)paramView.findViewById(i3));
      i1 += 1;
    }
  }
  
  public void a(DiscussionInfoCardActivity.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b(paramViewHolder.jdField_a_of_type_Int, paramViewHolder.jdField_a_of_type_JavaLangString, 5);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = ImageUtil.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
      return;
    }
  }
  
  protected void a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo != null) && ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)))
    {
      this.jdField_d_of_type_JavaUtilList = paramTroopInfo.parseTroopMemeberList();
      g();
    }
  }
  
  protected void a(TroopInfo paramTroopInfo, ArrayList paramArrayList)
  {
    if (paramTroopInfo != null)
    {
      paramArrayList = TroopInfo.convertMemberUinListToString(paramArrayList, 10);
      if (!TextUtils.equals(paramTroopInfo.memberListToShow, paramArrayList))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.memberListToShow = paramArrayList;
        u();
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramString;
    b(paramString);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopName = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop;
      u();
    }
    x();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString3, "", "");
  }
  
  public void a(List paramList)
  {
    if (((this.jdField_d_of_type_Int != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) || (paramList == null)) {
      return;
    }
    this.jdField_c_of_type_JavaUtilList = paramList;
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilList.size())
    {
      localArrayList.add(Long.valueOf(((oidb_0x899.memberlist)paramList.get(i1)).uint64_member_uin.get()));
      i1 += 1;
    }
    this.jdField_d_of_type_JavaUtilList = localArrayList;
    this.jdField_a_of_type_AndroidOsHandler.post(new rzu(this));
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    label314:
    label863:
    do
    {
      for (;;)
      {
        return;
        if (paramJSONObject != null)
        {
          try
          {
            paramInt = ((Integer)paramJSONObject.get("retcode")).intValue();
            paramJSONObject = (JSONObject)paramJSONObject.get("result");
            if ((paramInt != 0) || (paramJSONObject == null)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "checkApiState onResult. retCode = " + paramInt + "\n");
            }
            paramBundle = (JSONObject)paramJSONObject.get("basics");
            Object localObject2;
            String str;
            int i1;
            Object localObject1;
            if (paramBundle != null)
            {
              paramBundle = (JSONArray)paramBundle.get("datas");
              if (paramBundle != null)
              {
                paramInt = 0;
                if (paramInt < paramBundle.length())
                {
                  localObject2 = (JSONObject)paramBundle.get(paramInt);
                  str = (String)((JSONObject)localObject2).get("name");
                  i1 = ((Integer)((JSONObject)localObject2).get("state")).intValue();
                  localObject1 = (String)((JSONObject)localObject2).get("api");
                  localObject2 = (String)((JSONObject)localObject2).get("msg");
                  if (!QLog.isColorLevel()) {
                    break label1046;
                  }
                  QLog.i("Q.chatopttroop", 2, "checkApiState onResult, basics name = " + str + " state = " + i1 + " api = " + (String)localObject1 + " msg = " + (String)localObject2 + "\n");
                  break label1046;
                }
              }
            }
            paramBundle = (JSONObject)paramJSONObject.get("friendlink");
            if (paramBundle != null)
            {
              paramBundle = (JSONArray)paramBundle.get("datas");
              if (paramBundle != null)
              {
                paramInt = 0;
                if (paramInt < paramBundle.length())
                {
                  localObject2 = (JSONObject)paramBundle.get(paramInt);
                  str = (String)((JSONObject)localObject2).get("name");
                  i1 = ((Integer)((JSONObject)localObject2).get("state")).intValue();
                  localObject1 = (String)((JSONObject)localObject2).get("api");
                  localObject2 = (String)((JSONObject)localObject2).get("msg");
                  if (("add_group".equals(localObject1)) && (i1 != 1)) {
                    runOnUiThread(new sbx(this));
                  }
                  if (!QLog.isColorLevel()) {
                    break label1053;
                  }
                  QLog.i("Q.chatopttroop", 2, "checkApiState onResult, friendlink name = " + str + " state = " + i1 + " api = " + (String)localObject1 + " msg= " + (String)localObject2 + "\n");
                  break label1053;
                }
              }
            }
            paramInt = ((Integer)paramJSONObject.get("appid")).intValue();
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "checkApiState onResult, appid =" + paramInt + "\n");
            }
            paramJSONObject = (JSONObject)paramJSONObject.get("qqpay");
            if (paramJSONObject == null) {
              continue;
            }
            paramJSONObject = (JSONArray)paramJSONObject.get("datas");
            if (paramJSONObject == null) {
              continue;
            }
            paramInt = 0;
            while (paramInt < paramJSONObject.length())
            {
              localObject1 = (JSONObject)paramJSONObject.get(paramInt);
              paramBundle = (String)((JSONObject)localObject1).get("name");
              i1 = ((Integer)((JSONObject)localObject1).get("state")).intValue();
              str = (String)((JSONObject)localObject1).get("api");
              localObject1 = (String)((JSONObject)localObject1).get("msg");
              if (QLog.isColorLevel()) {
                QLog.i("Q.chatopttroop", 2, "checkApiState onResult, qqpay name = " + paramBundle + " state = " + i1 + " api = " + str + " msg= " + (String)localObject1 + "\n");
              }
              paramInt += 1;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
          }
          catch (Exception paramJSONObject) {}
          QLog.d("Q.chatopttroop", 2, "checkApiState onResult " + paramJSONObject.toString());
          return;
          if (paramJSONObject != null) {
            try
            {
              paramJSONObject = (JSONObject)paramJSONObject.get("data");
              if (paramJSONObject != null)
              {
                paramJSONObject = (JSONObject)paramJSONObject.get("key");
                if (paramJSONObject != null)
                {
                  paramInt = ((Integer)paramJSONObject.get("retCode")).intValue();
                  paramBundle = (String)paramJSONObject.get("retMsg");
                  if (paramInt != 0) {
                    break label962;
                  }
                  N();
                  ReportController.b(this.app, "CliOper", "", "", "0x80084B5", "0x80084B5", 0, 0, "", "", "", "");
                  if (QLog.isColorLevel())
                  {
                    QLog.i("Q.chatopttroop", 2, "joinGroup onResult retCode = " + paramInt + " retMsg = " + paramBundle);
                    return;
                  }
                }
              }
            }
            catch (Exception paramJSONObject)
            {
              f(getActivity().getResources().getString(2131433672));
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.chatopttroop", 2, "joinGroup onResult " + paramJSONObject.toString());
    return;
    label962:
    paramJSONObject = getActivity().getResources().getString(2131433672);
    switch (paramInt)
    {
    }
    for (;;)
    {
      f(paramJSONObject);
      break label863;
      paramJSONObject = getActivity().getResources().getString(2131433673);
      continue;
      paramJSONObject = getActivity().getResources().getString(2131433676);
      continue;
      label1046:
      paramInt += 1;
      break;
      label1053:
      paramInt += 1;
      break label314;
    }
  }
  
  public void a(oidb_0xaf4.RspBody paramRspBody)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("showGetAppListResult: respBody isNull=");
      if (paramRspBody != null) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.chatopttroop", 2, bool);
      if (paramRspBody != null) {
        break;
      }
      return;
    }
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[14];
    List localList;
    if (localView != null)
    {
      localList = paramRspBody.infos.get();
      if ((localList != null) && (localList.size() != 0)) {
        break label181;
      }
      localView.setVisibility(8);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "showGetAppListResult: appList == null || appList.size() == 0");
      }
    }
    label181:
    int i4;
    int i1;
    label258:
    int i2;
    label260:
    do
    {
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[29];
      if (localObject1 == null) {
        break;
      }
      if (paramRspBody.extra_info.tab_infos.size() <= 0) {
        break label906;
      }
      ((View)localObject1).setVisibility(0);
      b(paramRspBody.extra_info.tab_infos.get());
      return;
      localView.setVisibility(0);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      i4 = localList.size();
      localObject1 = localView.findViewById(2131366432);
      if (i4 > 4) {
        break label319;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "showGetAppListResult: appList.size() <= 4");
      }
      ((View)localObject1).setVisibility(8);
      if (i4 > 4) {
        break label328;
      }
      i1 = 3;
      i2 = 0;
    } while (i2 > i1);
    switch (i2)
    {
    }
    for (;;)
    {
      i2 += 1;
      break label260;
      label319:
      ((View)localObject1).setVisibility(0);
      break;
      label328:
      i1 = 7;
      break label258;
      localObject1 = localView.findViewById(2131366428);
      label344:
      Object localObject2;
      Object localObject3;
      Object localObject4;
      oidb_0xaf4.AppInfo localAppInfo;
      int i3;
      if ((i2 <= i1) && (i2 < i4))
      {
        ((View)localObject1).setVisibility(0);
        localObject2 = (ImageView)((View)localObject1).findViewById(2131366708);
        localObject3 = (TextView)((View)localObject1).findViewById(2131368427);
        localObject4 = (TextView)((View)localObject1).findViewById(2131368426);
        localAppInfo = (oidb_0xaf4.AppInfo)localList.get(i2);
        String str = localAppInfo.name.get();
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        ((TextView)localObject3).setText(str);
        localObject3 = new StringBuffer(str);
        i3 = localAppInfo.push_red_point.get();
        if (i3 != -1) {
          break label762;
        }
        ((TextView)localObject4).setVisibility(0);
        ((TextView)localObject4).setText("");
        ((TextView)localObject4).setBackgroundResource(0);
        ((TextView)localObject4).setCompoundDrawablesWithIntrinsicBounds(2130845923, 0, 0, 0);
        ((StringBuffer)localObject3).append("，新");
        label504:
        localObject4 = localAppInfo.icon.get();
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          break label824;
        }
        ((ImageView)localObject2).setImageResource(2130841276);
      }
      for (;;)
      {
        ((View)localObject1).setTag(localAppInfo);
        ((View)localObject1).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        if ((this.jdField_d_of_type_Int != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
          break label893;
        }
        i3 = 0;
        while (i3 < i4)
        {
          localObject2 = (oidb_0xaf4.AppInfo)localList.get(i3);
          if ((localObject2 != null) && (((oidb_0xaf4.AppInfo)localObject2).appid != null)) {
            TroopReportor.a("Grp_app_new", "grpData_admin", "app_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), String.valueOf(((oidb_0xaf4.AppInfo)localObject2).appid.get()) });
          }
          i3 += 1;
        }
        localObject1 = localView.findViewById(2131366429);
        break label344;
        localObject1 = localView.findViewById(2131366430);
        break label344;
        localObject1 = localView.findViewById(2131366431);
        break label344;
        localObject1 = localView.findViewById(2131366433);
        break label344;
        localObject1 = localView.findViewById(2131366434);
        break label344;
        localObject1 = localView.findViewById(2131366435);
        break label344;
        localObject1 = localView.findViewById(2131366436);
        break label344;
        ((View)localObject1).setVisibility(4);
        break;
        label762:
        if (i3 > 0)
        {
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText(String.valueOf(i3));
          ((TextView)localObject4).setBackgroundResource(2130845927);
          ((StringBuffer)localObject3).append("，").append(i3).append("未读");
          break label504;
        }
        ((TextView)localObject4).setVisibility(8);
        break label504;
        try
        {
          label824:
          i3 = AIOUtils.a(40.0F, getResources());
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable((String)localObject4, i3, i3, getResources().getDrawable(2130841276), getResources().getDrawable(2130841276)));
        }
        catch (Exception localException)
        {
          ((ImageView)localObject2).setImageDrawable(getResources().getDrawable(2130841276));
        }
      }
      label893:
      ((View)localObject1).setContentDescription(((StringBuffer)localObject3).toString());
    }
    label906:
    ((View)localObject1).setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[17];
    if (localFormSimpleItem == null) {}
    TroopEnterEffectConfig.EffectInfo localEffectInfo;
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      localFormSimpleItem.setVisibility(0);
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[16];
      if ((localObject != null) && ((localObject instanceof FormSimpleItem))) {
        ((FormSimpleItem)localObject).setBgType(2);
      }
      localObject = (TroopEnterEffectManager)this.app.getManager(230);
      localEffectInfo = ((TroopEnterEffectManager)localObject).a();
    } while (localEffectInfo == null);
    if (localEffectInfo.jdField_b_of_type_Int > 0)
    {
      localFormSimpleItem.setRightText(localEffectInfo.jdField_a_of_type_JavaLangString);
      return;
      localFormSimpleItem.setVisibility(8);
      return;
    }
    Object localObject = ((TroopEnterEffectManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (localObject != null)
    {
      if (((TroopEnterEffectConfig.EffectInfoData)localObject).jdField_a_of_type_Int == 0)
      {
        localFormSimpleItem.setRightText("未设置");
        return;
      }
      localFormSimpleItem.setRightText(((TroopEnterEffectConfig.EffectInfoData)localObject).jdField_a_of_type_JavaLangString);
      return;
    }
    localFormSimpleItem.setRightText("未设置");
  }
  
  protected boolean a()
  {
    bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "checkParams");
    }
    if (this.app == null) {}
    for (;;)
    {
      return false;
      try
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_Boolean = false;
        Object localObject = getIntent().getExtras();
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = ((Bundle)localObject).getString("troop_uin");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode = ((Bundle)localObject).getString("troop_code");
        this.jdField_d_of_type_Int = ((Bundle)localObject).getInt("vistor_type", 1);
        this.jdField_j_of_type_Int = ((Bundle)localObject).getInt("D2GType");
        this.jdField_o_of_type_Int = ((Bundle)localObject).getInt("filter_id", -1);
        this.p = ((Bundle)localObject).getInt("exposureSource", 99);
        this.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("authKey");
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "mVistorType = " + this.jdField_d_of_type_Int);
        }
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (l1 > 0L) {
          if (!QLog.isColorLevel()) {
            break label643;
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa = ((Bundle)localObject).getInt("troop_info_from");
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption = ((Bundle)localObject).getInt("troop_info_from_ex");
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark = ((Bundle)localObject).getString("param_return_addr");
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember = ((Bundle)localObject).getBoolean("troop_info_is_member");
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopface = ((Bundle)localObject).getShort("troop_info_faceid");
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = ((Bundle)localObject).getString("troop_info_name");
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin = ((Bundle)localObject).getString("troop_info_owner");
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = ((Bundle)localObject).getLong("troop_info_classext");
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation = ((Bundle)localObject).getString("troop_info_loca");
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = ((Bundle)localObject).getString("troop_info_fingermemo");
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo))
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = HttpUtil.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = HttpUtil.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)((Bundle)localObject).getByte("troop_info_opt"));
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = TroopSystemMsgUtil.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade = ((Bundle)localObject).getInt("TROOP_INFO_TROOP_GRADE");
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = TroopSystemMsgUtil.c(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt = ((Bundle)localObject).getLong("TROOP_INFO_FLAG_EXT");
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwAuthGroupType = ((Bundle)localObject).getLong("TROOP_INFO_AUTH_TYPE");
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(((Bundle)localObject).getString("TROOP_INFO_TAGS_EXT"));
          localObject = (TroopManager)this.app.getManager(51);
          if (localObject != null)
          {
            localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            if (localObject != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember = true;
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting((TroopInfo)localObject, getResources(), this.app.getCurrentAccountUin());
            }
          }
          if (this.jdField_d_of_type_Int == -1)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
            {
              this.jdField_d_of_type_Int = 1;
              return true;
            }
            this.jdField_d_of_type_Int = 2;
          }
          return true;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            bool = true;
          }
        }
        localException1 = localException1;
      }
    }
    QLog.i("Q.chatopttroop", 2, localException1.toString());
    label643:
    BnrReport.a(this.app, 69);
    return bool;
  }
  
  protected void b()
  {
    Object localObject1 = ((TroopManager)this.app.getManager(51)).a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      Object localObject2 = ((TroopInfo)localObject1).mTroopPicList;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
          if (str != null)
          {
            localAvatarInfo.jdField_c_of_type_JavaLangString = str;
            if (localAvatarInfo.jdField_c_of_type_JavaLangString.equals(AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString)) {}
            for (localAvatarInfo.jdField_d_of_type_JavaLangString = "SYSTEM_PHOTO";; localAvatarInfo.jdField_d_of_type_JavaLangString = "AVATAR_URL_STR")
            {
              Set localSet = ((TroopInfo)localObject1).mTroopVerifyingPics;
              if (localSet != null) {
                localAvatarInfo.jdField_b_of_type_Boolean = localSet.contains(str);
              }
              localArrayList.add(localAvatarInfo);
              break;
            }
          }
        }
      }
    }
    if (localArrayList.size() == 0)
    {
      localObject1 = new AvatarWallAdapter.AvatarInfo();
      ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_c_of_type_JavaLangString = AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString;
      ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_d_of_type_JavaLangString = "SYSTEM_PHOTO";
      localArrayList.add(localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a(localArrayList, false);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void b(int paramInt, Intent paramIntent)
  {
    String str1;
    String str2;
    if ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      str2 = TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      if (paramInt != -1) {
        break label83;
      }
    }
    label83:
    for (Object localObject = "0";; localObject = "1")
    {
      TroopReportor.a("Grp_share", "grpData_admin", "share_qq", 0, 0, new String[] { str1, str2, localObject });
      if (paramInt == -1) {
        break;
      }
      return;
    }
    localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.a((Intent)localObject);
    ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
  }
  
  public void b(long paramLong)
  {
    if (paramLong == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.publicAccountUin)
    {
      ImageView localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[36].findViewById(2131365543);
      Drawable localDrawable = ImageUtil.a();
      localImageView.setBackgroundDrawable(FaceDrawable.a(this.app, 105, String.valueOf(paramLong), 3, localDrawable, localDrawable));
    }
  }
  
  public void b(String paramString)
  {
    if (paramString == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[27];
        } while (localObject == null);
        localObject = (FollowImageTextView)((View)localObject).findViewById(2131363667);
      } while (localObject == null);
      ((FollowImageTextView)localObject).setText(paramString);
    } while (!AppSetting.jdField_b_of_type_Boolean);
    StringBuilder localStringBuilder = new StringBuilder().append("群聊名称 ").append(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {}
    for (paramString = "， 编辑群聊名称 按钮";; paramString = "")
    {
      ((FollowImageTextView)localObject).setContentDescription(paramString);
      return;
    }
  }
  
  public void b(List paramList)
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ArrayOfAndroidViewView[29];
    localViewGroup.removeAllViews();
    int i1 = 0;
    Iterator localIterator = paramList.iterator();
    int i4 = 1;
    int i2 = 0;
    if (localIterator.hasNext())
    {
      paramList = (oidb_0xaf4.TabInfo)localIterator.next();
      String str1 = paramList.name.get();
      String str2 = paramList.desc.get();
      String str3 = paramList.url.get();
      int i6 = paramList.num.get();
      int i5;
      int i3;
      if ((i1 == 0) && (paramList.type.get() == 1))
      {
        localView = this.jdField_a_of_type_ArrayOfAndroidViewView[31];
        paramList = localView;
        if (localView == null)
        {
          paramList = new GameRankFormItem(this);
          this.jdField_a_of_type_ArrayOfAndroidViewView[31] = paramList;
        }
        i5 = 1;
        ((GameRankFormItem)paramList).jdField_a_of_type_Int = i6;
        i1 = i2;
        i3 = 31;
        i2 = i5;
        label159:
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "game info tag=" + i3 + ", name=" + str1 + ", desc=" + str2 + ", num=" + i6);
        }
        if (i4 == 0) {
          break label368;
        }
      }
      label368:
      for (i4 = 1;; i4 = 2)
      {
        a(i3, i4, (FormSimpleItem)paramList, str1, str2, true);
        paramList.setTag(2131362360, str3);
        localViewGroup.addView(paramList);
        i3 = i1;
        i1 = i2;
        i4 = 0;
        i2 = i3;
        break;
        if ((i2 == 0) && (paramList.type.get() == 2))
        {
          localView = this.jdField_a_of_type_ArrayOfAndroidViewView[32];
          paramList = localView;
          if (localView == null)
          {
            paramList = new FormSimpleItem(this);
            this.jdField_a_of_type_ArrayOfAndroidViewView[32] = paramList;
          }
          i5 = 1;
          i2 = i1;
          i3 = 32;
          i1 = i5;
          break label159;
        }
        paramList = new FormSimpleItem(this);
        i5 = i1;
        i3 = 52;
        i1 = i2;
        i2 = i5;
        break label159;
      }
    }
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[30];
    paramList = localView;
    if (localView == null)
    {
      paramList = LayoutInflater.from(this).inflate(2130970624, localViewGroup, false);
      paramList.setBackgroundResource(2130846313);
      paramList.getLayoutParams().height = getResources().getDimensionPixelSize(2131558785);
      this.jdField_a_of_type_ArrayOfAndroidViewView[30] = paramList;
    }
    localViewGroup.addView(paramList);
    if (i2 != 0) {
      ThreadManager.post(new rzy(this), 5, null, true);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i2 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "mTroopInfoData is null!");
      }
    }
    while ((this.jdField_d_of_type_Int != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[5];
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (this.jdField_b_of_type_Boolean)) {}
    for (int i1 = 0;; i1 = 8)
    {
      if (localObject != null) {
        ((View)localObject).setVisibility(i1);
      }
      localObject = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[6];
      if (localObject == null) {
        break;
      }
      if (i1 == 0) {
        i2 = 3;
      }
      ((FormSimpleItem)localObject).setBgType(i2);
      return;
    }
  }
  
  public void c()
  {
    if (!NetworkUtil.g(getApplicationContext())) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "initNetworkRequests");
      }
      TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
      ArrayList localArrayList;
      if (localTroopHandler != null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(this.app.getCurrentAccountUin());
        localTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, localArrayList);
      }
      if (localTroopHandler != null)
      {
        o();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
        {
          localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
          localTroopHandler.a(localArrayList);
          localTroopHandler.h(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper = new TroopCardAppInfoHelper(this.app);
      I();
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
        if (localTroopHandler != null) {
          localTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false, this.jdField_m_of_type_Int, 1);
        }
      }
      while (this.jdField_d_of_type_Int == 2)
      {
        b(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_MqqObserverBusinessObserver);
        return;
        a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_MqqObserverBusinessObserver);
      }
    }
  }
  
  protected void c(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("ken_qun_photo_data_has_changed", true);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "resultForRequestQzonePhoto|needRereshed = " + bool);
      }
      if (bool) {
        o();
      }
    }
    ThreadManager.post(new saz(this), 8, null, true);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "init(), isInitialized = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838592);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131558792));
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
    if (!NetworkUtil.g(getApplicationContext())) {
      QQToast.a(getApplicationContext(), 1, getString(2131434794), 1).b(getTitleBarHeight());
    }
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
    this.n = 30;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new rzn(this));
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new rzo(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  protected void d(int paramInt, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      if (paramIntent.getExtras().getBoolean("isNeedFinish"))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("isNeedFinish", true);
        setResult(-1, paramIntent);
        finish();
        return;
      }
      if (paramIntent.getExtras().getBoolean("finish_chat_setting"))
      {
        finish();
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null)
    {
      paramIntent = null;
      label79:
      if ((paramIntent != null) && (paramIntent.wMemberNum != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramIntent.Administrator, paramIntent.wMemberNum, this.app.getCurrentAccountUin(), getResources());
        if (this.jdField_c_of_type_AndroidWidgetTextView != null)
        {
          if ((this.jdField_d_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
            break label253;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "人");
        }
      }
    }
    for (;;)
    {
      if (this.jdField_e_of_type_JavaUtilList != null) {
        a(this.jdField_e_of_type_JavaUtilList);
      }
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager;
      if ((this.jdField_a_of_type_ArrayOfAndroidViewView[6] == null) || (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null)) {
        break;
      }
      ThreadManager.post(new sbb(this, paramIntent), 8, null, true);
      return;
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      break label79;
      label253:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "名成员");
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                        } while ((this.jdField_d_of_type_Int != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember));
                        String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                        String str2 = TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
                        if (paramInt2 == -1) {}
                        for (paramIntent = "0";; paramIntent = "1")
                        {
                          TroopReportor.a("Grp_share", "grpData_admin", "share_qzone", 0, 0, new String[] { str1, str2, paramIntent });
                          return;
                        }
                        a(paramInt2, paramIntent);
                        return;
                        if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
                        {
                          paramIntent = new Intent();
                          paramIntent.putExtra("isNeedFinish", true);
                          setResult(-1, paramIntent);
                          finish();
                          return;
                        }
                      } while (this.jdField_a_of_type_ArrayOfAndroidViewView[6] == null);
                      ThreadManager.post(new sbh(this), 8, null, true);
                      return;
                      b(paramInt2, paramIntent);
                      return;
                    } while (paramInt2 != -1);
                    setResult(-1);
                    this.jdField_m_of_type_Boolean = true;
                    return;
                    c(paramInt2, paramIntent);
                    return;
                    d(paramInt2, paramIntent);
                    return;
                    ((TroopHandler)this.app.a(20)).f(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                    return;
                  } while ((paramInt2 != -1) || (AvatarWallAdapter.a == null));
                  paramIntent = ImageUtil.b(this, AvatarWallAdapter.a);
                  paramInt1 = ProfileCardUtil.a(this);
                  PhotoUtils.a(new Intent(), this, ChatSettingForTroop.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.a());
                  return;
                  e(paramInt2, paramIntent);
                  f(paramInt2, paramIntent);
                  return;
                } while ((paramIntent == null) || (paramIntent.getExtras() == null) || (paramInt2 != -1));
                paramIntent = paramIntent.getExtras();
                this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation = paramIntent.getString("location");
                this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat = paramIntent.getInt("lat", 0);
                this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon = paramIntent.getInt("lon", 0);
                m();
                return;
              } while (paramInt2 != -1);
              if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
              {
                paramIntent = new Intent();
                paramIntent.putExtra("isNeedFinish", true);
                setResult(-1, paramIntent);
              }
              finish();
              return;
            } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("has_operation", false)));
            this.jdField_a_of_type_AndroidContentIntent = paramIntent;
            return;
          } while (paramInt2 != -1);
          paramIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
          paramIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          paramIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName());
          paramIntent.putExtra("uintype", 1);
          startActivity(paramIntent);
          setResult(-1);
          finish();
          return;
          f(paramInt2, paramIntent);
          return;
        } while (!((TroopEnterEffectManager)this.app.getManager(230)).b());
        a(true);
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      if (!NetworkUtil.g(this))
      {
        QQToast.a(this, 1, 2131434826, 0).b(getTitleBarHeight());
        return;
      }
      paramIntent = paramIntent.getStringExtra("result");
    } while ((TextUtils.isEmpty(paramIntent)) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (paramIntent.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname)));
    ((BizTroopHandler)this.app.a(22)).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramIntent);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetTroopHead())) {
      this.jdField_e_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
    b(paramIntent);
  }
  
  public void doOnBackPressed()
  {
    Q();
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("appid");
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("openid");
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("share_uin");
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("is_from_game");
    if (("true".equals(this.jdField_f_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      TroopUtils.a(this.app, getApplicationContext(), this.jdField_c_of_type_JavaLangString, this, 0, null);
      this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("guild_id");
      this.jdField_h_of_type_JavaLangString = getIntent().getStringExtra("zone_id");
      this.jdField_i_of_type_JavaLangString = getIntent().getStringExtra("role_id");
      this.jdField_j_of_type_JavaLangString = getIntent().getStringExtra("gc");
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "joinGroup appid = " + this.jdField_c_of_type_JavaLangString + " openid = " + this.jdField_d_of_type_JavaLangString + " guild id = " + this.jdField_g_of_type_JavaLangString + "zone_id = " + this.jdField_h_of_type_JavaLangString + " role id = " + this.jdField_i_of_type_JavaLangString + "  group code= " + this.jdField_j_of_type_JavaLangString);
      }
      paramBundle = String.valueOf(this.jdField_c_of_type_JavaLangString);
      if ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (this.jdField_e_of_type_JavaLangString.equals(this.app.getAccount()))) {
        break label385;
      }
      C();
      label304:
      if (!QLog.isColorLevel()) {
        break label1013;
      }
    }
    label385:
    label971:
    label1013:
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      if (!a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        finish();
        return false;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.chatopttroop", 2, " joinGroup is from game = false");
        break;
        if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          break label304;
        }
        OpenID localOpenID = this.app.a().a(paramBundle);
        if (localOpenID == null)
        {
          r();
          this.jdField_b_of_type_AndroidOsHandler = new Handler();
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(new rzv(this), 3000L);
          this.app.addObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
          this.app.a().d(paramBundle);
          break label304;
        }
        if (this.jdField_d_of_type_JavaLangString.equals(localOpenID.openID)) {
          break label304;
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.chatopttroop", 2, "-->preForward--openid doesn't equal current local openid");
        }
        C();
        break label304;
      }
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
            c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController = ((RoamSettingController)this.app.getManager(30));
          a();
          a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
          if (!b()) {
            F();
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "onCreate(), time = " + (System.currentTimeMillis() - l1));
          }
          QZoneHelper.b(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (this.jdField_d_of_type_Int != 1) {
            break label971;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
          {
            a("Grp_Admin_data", "Clk_data", "0");
            BnrReport.a(this.app, 65);
            paramBundle = new IntentFilter();
            paramBundle.addAction("start_recomend_page");
            paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
            addObserver(this.jdField_d_of_type_ComTencentMobileqqAppTroopObserver);
            addObserver(this.jdField_e_of_type_ComTencentMobileqqAppTroopObserver);
            addObserver(this.jdField_c_of_type_ComTencentMobileqqAppTroopObserver);
            if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter != null) {
              this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a.a(this.jdField_a_of_type_JavaUtilObserver);
            }
            D();
            this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(51));
            paramBundle = (TroopManager)this.app.getManager(51);
            if (paramBundle != null)
            {
              paramBundle = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              if ((paramBundle != null) && (paramBundle.isGameBind())) {
                TroopReportor.a("Grp_game", "Grp_data", "data_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
              }
            }
            this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
            return true;
          }
        }
        catch (OutOfMemoryError paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.chatopttroop", 2, "initUI got OOM, e:" + paramBundle.getMessage());
          }
          System.gc();
          finish();
          return false;
        }
        catch (InflateException paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.chatopttroop", 2, "init UI got InflateException, e:" + paramBundle.getMessage());
          }
          System.gc();
          finish();
          return false;
        }
        a("Grp_Admin_data", "Clk_data", "1");
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
          a("Grp_Visdata", "Clk_data", "0");
        } else {
          a("Grp_Visdata", "Clk_data", "1");
        }
      }
    }
  }
  
  /* Error */
  public void doOnDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 3347	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_f_of_type_Boolean	Z
    //   5: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +389 -> 397
    //   11: invokestatic 1628	java/lang/System:currentTimeMillis	()J
    //   14: lstore_1
    //   15: ldc 2
    //   17: monitorenter
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 2793	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Boolean	Z
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: getfield 1886	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder	Lcom/tencent/mobileqq/util/FaceDecoder;
    //   30: ifnull +10 -> 40
    //   33: aload_0
    //   34: getfield 1886	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder	Lcom/tencent/mobileqq/util/FaceDecoder;
    //   37: invokevirtual 3349	com/tencent/mobileqq/util/FaceDecoder:d	()V
    //   40: aload_0
    //   41: aload_0
    //   42: getfield 254	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver	Lcom/tencent/biz/common/util/OpenIdObserver;
    //   45: invokevirtual 3352	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   48: aload_0
    //   49: aload_0
    //   50: getfield 211	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppFriendListObserver	Lcom/tencent/mobileqq/app/FriendListObserver;
    //   53: invokevirtual 3352	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 221	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver	Lcom/tencent/mobileqq/app/BizTroopObserver;
    //   61: invokevirtual 3352	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 196	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppTroopObserver	Lcom/tencent/mobileqq/app/TroopObserver;
    //   69: invokevirtual 3352	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 191	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppTroopObserver	Lcom/tencent/mobileqq/app/TroopObserver;
    //   77: invokevirtual 3352	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 206	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_ComTencentMobileqqAppTroopObserver	Lcom/tencent/mobileqq/app/TroopObserver;
    //   85: invokevirtual 3352	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 148	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_e_of_type_ComTencentMobileqqAppTroopObserver	Lcom/tencent/mobileqq/app/TroopObserver;
    //   93: invokevirtual 3352	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 201	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_ComTencentMobileqqAppTroopObserver	Lcom/tencent/mobileqq/app/TroopObserver;
    //   101: invokevirtual 3352	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   104: aload_0
    //   105: getfield 264	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   108: aload_0
    //   109: getfield 259	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver	Lcom/tencent/mobileqq/vas/VasExtensionObserver;
    //   112: invokevirtual 3353	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   115: aload_0
    //   116: getfield 1756	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter	Lcom/tencent/mobileqq/troop/widget/AvatarWallViewPagerAdapter;
    //   119: ifnull +24 -> 143
    //   122: aload_0
    //   123: getfield 1756	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter	Lcom/tencent/mobileqq/troop/widget/AvatarWallViewPagerAdapter;
    //   126: getfield 3320	com/tencent/mobileqq/troop/widget/AvatarWallViewPagerAdapter:a	Lcom/tencent/mobileqq/troop/utils/TroopAvatarManger;
    //   129: aload_0
    //   130: getfield 216	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_JavaUtilObserver	Ljava/util/Observer;
    //   133: invokevirtual 3355	com/tencent/mobileqq/troop/utils/TroopAvatarManger:b	(Ljava/util/Observer;)V
    //   136: aload_0
    //   137: getfield 1756	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter	Lcom/tencent/mobileqq/troop/widget/AvatarWallViewPagerAdapter;
    //   140: invokevirtual 3356	com/tencent/mobileqq/troop/widget/AvatarWallViewPagerAdapter:a	()V
    //   143: aload_0
    //   144: getfield 186	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   147: ifnull +11 -> 158
    //   150: aload_0
    //   151: getfield 186	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   154: aconst_null
    //   155: invokevirtual 3359	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   158: aload_0
    //   159: getfield 3034	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   162: ifnull +30 -> 192
    //   165: aload_0
    //   166: getfield 3034	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   169: checkcast 3043	android/graphics/drawable/Animatable
    //   172: invokeinterface 3362 1 0
    //   177: ifeq +15 -> 192
    //   180: aload_0
    //   181: getfield 3034	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   184: checkcast 3043	android/graphics/drawable/Animatable
    //   187: invokeinterface 3365 1 0
    //   192: aload_0
    //   193: getfield 3367	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility	Lcom/tencent/mobileqq/troopshare/TroopShareUtility;
    //   196: ifnull +10 -> 206
    //   199: aload_0
    //   200: getfield 3367	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility	Lcom/tencent/mobileqq/troopshare/TroopShareUtility;
    //   203: invokevirtual 3371	com/tencent/mobileqq/troopshare/TroopShareUtility:f	()V
    //   206: aload_0
    //   207: invokestatic 3376	com/tencent/mobileqq/troopinfo/GroupCatalogTool:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/troopinfo/GroupCatalogTool;
    //   210: invokevirtual 3377	com/tencent/mobileqq/troopinfo/GroupCatalogTool:a	()V
    //   213: aload_0
    //   214: getfield 3379	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   217: ifnull +10 -> 227
    //   220: aload_0
    //   221: getfield 3379	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   224: invokevirtual 3384	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   227: aload_0
    //   228: getfield 587	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper	Lcom/tencent/biz/helper/TroopCardAppInfoHelper;
    //   231: ifnull +10 -> 241
    //   234: aload_0
    //   235: getfield 587	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper	Lcom/tencent/biz/helper/TroopCardAppInfoHelper;
    //   238: invokevirtual 3385	com/tencent/biz/helper/TroopCardAppInfoHelper:a	()V
    //   241: aload_0
    //   242: aload_0
    //   243: getfield 157	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   246: invokevirtual 3389	com/tencent/mobileqq/activity/ChatSettingForTroop:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   249: aload_0
    //   250: getfield 3245	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   253: ifnull +11 -> 264
    //   256: aload_0
    //   257: getfield 3245	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   260: aconst_null
    //   261: invokevirtual 3359	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   264: aload_0
    //   265: aconst_null
    //   266: putfield 1584	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   269: aload_0
    //   270: invokespecial 3391	com/tencent/mobileqq/app/BaseActivity:doOnDestroy	()V
    //   273: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +34 -> 310
    //   279: ldc_w 284
    //   282: iconst_2
    //   283: new 495	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 496	java/lang/StringBuilder:<init>	()V
    //   290: ldc_w 3393
    //   293: invokevirtual 500	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokestatic 1628	java/lang/System:currentTimeMillis	()J
    //   299: lload_1
    //   300: lsub
    //   301: invokevirtual 2040	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   304: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 1043	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   310: return
    //   311: astore_3
    //   312: ldc 2
    //   314: monitorexit
    //   315: aload_3
    //   316: athrow
    //   317: astore_3
    //   318: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq -72 -> 249
    //   324: ldc_w 284
    //   327: iconst_2
    //   328: new 495	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 496	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 3395
    //   338: invokevirtual 500	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_3
    //   342: invokevirtual 3396	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   345: invokevirtual 500	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 1405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: goto -105 -> 249
    //   357: astore_3
    //   358: invokestatic 282	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq -112 -> 249
    //   364: ldc_w 284
    //   367: iconst_2
    //   368: new 495	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 496	java/lang/StringBuilder:<init>	()V
    //   375: ldc_w 3395
    //   378: invokevirtual 500	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_3
    //   382: invokevirtual 3397	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   385: invokevirtual 500	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 1405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: goto -145 -> 249
    //   397: lconst_0
    //   398: lstore_1
    //   399: goto -384 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	ChatSettingForTroop
    //   14	385	1	l1	long
    //   311	5	3	localObject	Object
    //   317	25	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   357	25	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   18	26	311	finally
    //   312	315	311	finally
    //   241	249	317	java/lang/IllegalArgumentException
    //   241	249	357	java/lang/Exception
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    URLDrawable.resume();
    String str1;
    Object localObject;
    if (this.jdField_l_of_type_Boolean)
    {
      this.jdField_l_of_type_Boolean = false;
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
      {
        str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        String str2 = TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
        {
          localObject = "1";
          TroopReportor.a("Grp_set_new", "grpData_admin", "exp", 0, 0, new String[] { str1, str2, localObject });
        }
      }
    }
    for (;;)
    {
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_h_of_type_Boolean = false;
      }
      try
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode);
        TroopNotificationHelper.a(this.app, 0, l2, l1, 0L, "", 0, "OidbSvc.0x852_48", (short)23, false, false);
        return;
      }
      catch (Exception localException) {}
      localObject = "0";
      break;
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
      for (localObject = "1";; localObject = "0")
      {
        TroopReportor.a("Grp_set_new", "grpData_visitor", "exp", 0, 0, new String[] { str1, localObject });
        break;
      }
      localObject = (TroopAppMgr)this.app.getManager(108);
      if ((localObject != null) && (((TroopAppMgr)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
      {
        localObject = (TroopHandler)this.app.a(20);
        if (localObject != null) {
          ((TroopHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, true, this.jdField_m_of_type_Int, 1);
        }
      }
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (!this.jdField_g_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStart add observer");
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      addObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      addObserver(this.jdField_c_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_g_of_type_Boolean = true;
    }
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = false;
      return;
    }
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.b();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_g_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStop remove observer");
      }
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_g_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.c();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  protected void e()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
      i1 = 0;
    }
    for (;;)
    {
      localObject = (TextView)((View)localObject).findViewById(2131368429);
      if (i1 > 0)
      {
        String str = String.format(getResources().getString(2131433491), new Object[] { Integer.valueOf(i1) });
        ((TextView)localObject).setText(str);
        ((TextView)localObject).setContentDescription(str);
        ((TextView)localObject).setVisibility(0);
      }
      while (this.jdField_d_of_type_Boolean)
      {
        ((TextView)localObject).setVisibility(8);
        return;
        ((TextView)localObject).setVisibility(8);
      }
      break;
    }
  }
  
  protected void e(int paramInt, Intent paramIntent)
  {
    p();
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      ThreadManager.post(new sbf(this, paramIntent), 8, null, true);
    }
  }
  
  public void f()
  {
    if (this.jdField_d_of_type_Int == 2) {
      a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopMemberMaxNum);
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    FollowImageTextView localFollowImageTextView = (FollowImageTextView)this.jdField_a_of_type_ArrayOfAndroidViewView[15];
    int i1;
    label72:
    label84:
    StringBuilder localStringBuilder;
    if (localFollowImageTextView != null)
    {
      if (!bool) {
        break label144;
      }
      i1 = 0;
      localFollowImageTextView.setFollowImageVisibility(i1);
      if (!bool) {
        break label150;
      }
      localObject = this.jdField_a_of_type_AndroidViewView$OnTouchListener;
      localFollowImageTextView.setOnTouchListener((View.OnTouchListener)localObject);
      if (!bool) {
        break label155;
      }
      localObject = this;
      localFollowImageTextView.setOnClickListener((View.OnClickListener)localObject);
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        localObject = localFollowImageTextView.a();
        localStringBuilder = new StringBuilder().append("群聊名称 ").append(localObject);
        if (!bool) {
          break label160;
        }
      }
    }
    label144:
    label150:
    label155:
    label160:
    for (Object localObject = "， 编辑群聊名称 按钮";; localObject = "")
    {
      localFollowImageTextView.setContentDescription((String)localObject);
      return;
      i1 = 8;
      break;
      localObject = null;
      break label72;
      localObject = null;
      break label84;
    }
  }
  
  protected void f(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      String str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.", 2, "ChatSettingActivity|onActivityResult|REQUEST_FOR_TROOP_DISBAND|isNeedFinish = " + bool + ", strTip = " + str);
      }
      if ((!TextUtils.isEmpty(str)) && (bool))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(5, str, 1000);
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if (!TextUtils.isEmpty(paramIntent)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopOwner(paramIntent, this.app.getCurrentAccountUin());
        }
        U();
        J();
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, str, 1000);
        return;
      }
    } while (!bool);
    paramIntent = new Intent();
    paramIntent.putExtra("isNeedFinish", true);
    setResult(-1, paramIntent);
    finish();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(this.jdField_e_of_type_Int, this.jdField_g_of_type_Int, this.jdField_f_of_type_Int, this.jdField_h_of_type_Int);
      if (this.jdField_a_of_type_Scf == null)
      {
        this.jdField_a_of_type_Scf = new scf(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_Scf);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Scf.notifyDataSetChanged();
  }
  
  protected void h()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.canInviteMember()) {
      return;
    }
    SharedPreferences localSharedPreferences = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 0);
    long l1 = localSharedPreferences.getLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "TroopMemberList lastUpdateTime:" + l1);
    }
    if (l1 == 0L)
    {
      TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
      if (localTroopHandler != null) {
        localTroopHandler.a(true, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, 6);
      }
      localSharedPreferences.edit().putLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, System.currentTimeMillis()).commit();
    }
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 5, null, false);
  }
  
  protected void i()
  {
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop()))
    {
      i1 = 1;
      if (i1 == 0) {
        break label160;
      }
      HWTroopUtils.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "troopProfile");
      ReportController.b(this.app, "P_CliOper", "Grp_edu", "", "Grp_data", "mbercard_Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    }
    for (;;)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_modifydata", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      TroopReportor.a("Grp_set_new", "grpData_admin", "clk_modifydata", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      i1 = 0;
      break;
      label160:
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard;
      Intent localIntent = new Intent(this, EditInfoActivity.class);
      localIntent.putExtra("edit_type", 0);
      localIntent.putExtra("title", getString(2131430578));
      localIntent.putExtra("default_text", str);
      localIntent.putExtra("isTroopNick", true);
      localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uin", this.app.getAccount());
      localIntent.putExtra("max_num", 60);
      localIntent.putExtra("from", 0);
      startActivityForResult(localIntent, 2);
    }
  }
  
  protected void j()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject = TroopMemberListActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
    ((Intent)localObject).putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum);
    startActivityForResult((Intent)localObject, 9);
    localObject = "2";
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        localObject = "0";
      }
      for (;;)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", (String)localObject, "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          localObject = "1";
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  void k()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(new ActionMenuItem("清空聊天记录", 0, 0), 3);
    localActionSheet.c(2131432998);
    localActionSheet.a(new sae(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 15) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 10) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 11)) {
      ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "nearbygrp_data", "Clk_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon != 0))
    {
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", String.format("https://nearby.qq.com/hot_chat/qun_class.html?_wv=1031&latitude=%1$s&longitude=%2$s", new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat / 1000000.0D), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon / 1000000.0D) }));
      startActivity(localIntent);
      a("Grp", "Clk_grp_map", "0");
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
    {
      Intent localIntent;
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    TroopLocationModifyActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, 14);
  }
  
  public void m()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    if (localView != null)
    {
      if ((!(localView instanceof FormSimpleItem)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation))) {
        break label88;
      }
      localView.setVisibility(0);
      a(12, 3, (FormSimpleItem)localView, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, null, true);
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[33] != null) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[33].setBackgroundResource(2130841400);
      }
    }
    label88:
    do
    {
      return;
      localView.setVisibility(8);
    } while (this.jdField_a_of_type_ArrayOfAndroidViewView[33] == null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[33].setBackgroundResource(2130841399);
  }
  
  public void n()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[23];
    if (localView != null)
    {
      if (((localView instanceof FormSimpleItem)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo)))
      {
        localView.setVisibility(0);
        a(23, 1, (FormSimpleItem)localView, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, null, true);
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  protected void o()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
    if (localTroopHandler == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          }
          if ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
              break label122;
            }
            localTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, (byte)1, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwTimeStamp, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
            return;
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.chatopttroop", 2, localException.toString());
    return;
    label122:
    localException.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (byte)1, 0L, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = paramCompoundButton.getTag();
    if (!(paramCompoundButton instanceof Integer)) {
      return;
    }
    switch (((Integer)paramCompoundButton).intValue())
    {
    default: 
      return;
    case 9: 
      d(paramBoolean);
      return;
    case 19: 
      e(paramBoolean);
      return;
    }
    f(paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    int i1;
    if (paramView == null)
    {
      localObject1 = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && ((localObject1 instanceof Integer)))
      {
        i1 = ((Integer)localObject1).intValue();
        switch (i1)
        {
        }
      }
    }
    label2058:
    label2070:
    label2340:
    label2601:
    label3195:
    do
    {
      Object localObject2;
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              localObject1 = paramView.getTag();
              break;
              i();
              return;
              j();
              a("Grp_Admin_data", "Clk_mber", "");
              if ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
              {
                TroopReportor.a("Grp_set_new", "grpData_admin", "clk_mber", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                return;
                h();
                if ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
                {
                  TroopReportor.a("Grp_set_new", "grpData_admin", "clk_invite_new", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                  return;
                  paramView = paramView.getTag(2131362362);
                  if ((paramView instanceof String))
                  {
                    paramView = (String)paramView;
                    localObject1 = new Bundle();
                    ((Bundle)localObject1).putString("selfSet_leftViewText", getString(2131433092));
                    ((Bundle)localObject1).putString("custom_leftbackbutton_name", getTitle().toString());
                    TroopMemberCardUtils.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramView, 1, -1, (Bundle)localObject1);
                    return;
                    paramView = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
                    localObject1 = new Intent(this, QQBrowserActivity.class);
                    ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
                    ((Intent)localObject1).putExtra("url", paramView);
                    startActivity((Intent)localObject1);
                    ReportController.b(this.app, "dc00899", "Grp_certified", "", "data", "clk_data", 2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
                    return;
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum > this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum) {
                      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum;
                    }
                    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {}
                    for (i1 = 0;; i1 = 1)
                    {
                      paramView = new Intent(this, PublicAccountBrowser.class);
                      paramView.putExtra("hide_operation_bar", true);
                      paramView.putExtra("hideRightButton", true);
                      paramView.putExtra("isScreenOrientationPortrait", true);
                      paramView.putExtra("uin", this.app.getCurrentAccountUin());
                      paramView.putExtra("url", "http://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&role=1&group_level=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade + "&group_mem_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "&group_active_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum + "&show_level=" + i1);
                      startActivity(paramView);
                      ReportController.b(this.app, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
                      BnrReport.a(this.app, 72);
                      return;
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility == null) {
                      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = new TroopShareUtility(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
                    }
                    this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.g();
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                      i1 = 0;
                    }
                    for (;;)
                    {
                      ReportController.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "clk_qrcode", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(i1), "", "");
                      if ((this.jdField_d_of_type_Int != 1) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
                        break;
                      }
                      TroopReportor.a("Grp_set_new", "grpData_admin", "clk_qrcode", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                      return;
                      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
                        i1 = 1;
                      } else {
                        i1 = 2;
                      }
                    }
                    L();
                    TroopReportor.a("Grp_msg", "grpData_admin", "Clk_msgSet", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                    return;
                    K();
                    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_chatrecord", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
                    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_chatRecord", 1, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                    return;
                    paramView = TroopMemberListActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 19);
                    paramView.putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum);
                    startActivityForResult(paramView, 9);
                    paramView = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin());
                    TroopReportor.a("Grp_edu", "Grp_data", "teachermsg_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(paramView) });
                    return;
                    QQToast.a(this, "仅供调试", 0).a();
                    paramView = new Bundle();
                    paramView.putString("extra.GROUP_UIN", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
                    EntryDebugFragment.a(this, paramView);
                    return;
                    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
                    {
                      paramView = new Intent(this, EditInfoActivity.class);
                      paramView.putExtra("edit_type", 0);
                      paramView.putExtra("title", "编辑群聊名称");
                      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopName) {
                        paramView.putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName());
                      }
                      paramView.putExtra("max_num", 30);
                      paramView.putExtra("canPostNull", false);
                      startActivityForResult(paramView, 20);
                    }
                    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_editInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                    return;
                    N();
                    if (this.jdField_j_of_type_Int == 2) {
                      ReportController.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
                    }
                    i1 = getIntent().getIntExtra("extra_share_group_from", 0);
                    if (i1 != 0) {
                      StoryReportor.a("story_grp", "clk_msg", i1, 0, new String[0]);
                    }
                    if (this.jdField_d_of_type_Int == 2)
                    {
                      TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_sendMsg", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
                      return;
                      q();
                      return;
                      paramView = new Intent();
                      paramView.putExtra("uin", this.app.getCurrentAccountUin());
                      paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                      paramView.putExtra("forward_location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
                      paramView.putExtra("forward_latitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat);
                      paramView.putExtra("forward_longitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon);
                      paramView.putExtra("forward_cityid", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId);
                      paramView.putExtra("troop_auth_submit_time", this.jdField_l_of_type_Int);
                      paramView.putExtra("leftViewText", getResources().getString(2131435257));
                      paramView.putExtra("key_qidian_private_troop", this.jdField_d_of_type_Boolean);
                      localObject1 = TroopBaseProxyActivity.a(this);
                      localObject2 = new TroopManageCmd(this.app);
                      localObject3 = PluginCommunicationHandler.getInstance();
                      if (localObject3 != null) {
                        ((PluginCommunicationHandler)localObject3).register((RemoteCommand)localObject2);
                      }
                      TroopManageProxyActivity.a("troop_manage_plugin.apk", "管理群", TroopManageProxyActivity.class, this, paramView, (Dialog)localObject1, "com.tencent.mobileqq.activity.TroopManageActivity", this.app.getCurrentAccountUin(), 8);
                      localObject1 = this.app;
                      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
                      for (paramView = "0";; paramView = "1")
                      {
                        ReportController.b((QQAppInterface)localObject1, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrp", 0, 0, (String)localObject2, paramView, "", "");
                        TroopReportor.a("Grp_set_new", "grpData_admin", "clk_manageGrp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                        return;
                      }
                      ReportController.b(this.app, "P_CliOper", "Grp_payjoin", "", "join_grp", "Clk_data", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
                      TroopNotificationUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                      return;
                      a(null);
                      ReportController.b(this.app, "CliOper", "", "", "0x80084B4", "0x80084B4", 0, 0, "", "", "", "");
                      return;
                      if (QSecFramework.a().a(1001).booleanValue()) {
                        QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(6), "joingroup", null }, null);
                      }
                      if (this.jdField_d_of_type_Int == 2)
                      {
                        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
                          break label2058;
                        }
                      }
                      for (paramView = "1";; paramView = "0")
                      {
                        TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_join", 0, 0, new String[] { localObject1, paramView });
                        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 1) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
                          break label2070;
                        }
                        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) {
                          break;
                        }
                        d(1);
                        return;
                      }
                      O();
                      return;
                      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 19) {
                        ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "recom", "Clk_joingrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
                      }
                      while (!NetworkUtil.d(this))
                      {
                        b(2131433196, 1);
                        return;
                        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 18)
                        {
                          ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_join", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
                        }
                        else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 24)
                        {
                          ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "search", "Clk_joingrp", 0, 0, "", "", "", "");
                        }
                        else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 17)
                        {
                          ReportController.b(this.app, "CliOper", "", "", "Grp_recommend", "viewinfor_joingrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
                        }
                        else
                        {
                          i1 = -1;
                          int i2;
                          switch (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa)
                          {
                          default: 
                            i2 = i1;
                            if (i1 == -1)
                            {
                              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption != 7) {
                                break label2601;
                              }
                              i2 = 3;
                            }
                            break;
                          }
                          for (;;)
                          {
                            i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
                            if (QLog.isDevelopLevel()) {
                              QLog.d("Q.chatopttroop", 4, "statOption=" + i1);
                            }
                            ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", i2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.p + "", "" + i1, this.jdField_o_of_type_Int + "");
                            ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp1", i2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.p + "", this.s + "", "");
                            break;
                            i1 = 0;
                            break label2340;
                            i1 = 1;
                            break label2340;
                            i1 = 2;
                            break label2340;
                            i1 = 6;
                            break label2340;
                            i1 = 7;
                            break label2340;
                            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption == 8)
                            {
                              i2 = 4;
                            }
                            else
                            {
                              i2 = i1;
                              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption == 36) {
                                i2 = 10;
                              }
                            }
                          }
                        }
                      }
                      paramView = (TroopHandler)this.app.a(20);
                      if (paramView != null) {}
                      try
                      {
                        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                        r();
                        paramView.a(l1, 8390784);
                        if (super.getIntent().getBooleanExtra("from_babyq", false))
                        {
                          ReportController.b(this.app, "dc00898", "", "", "0X8007246", "0X8007246", 0, 0, "", "", "", "");
                          return;
                        }
                      }
                      catch (Exception paramView)
                      {
                        for (;;)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.i("Q.chatopttroop", 2, paramView.toString());
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            ThreadManager.post(new sac(this, Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)), 8, null, true);
            a("Grp_Visdata", "nonmber_Clk_tag", "");
            BnrReport.a(this.app, 71);
            return;
            t();
            return;
            l();
            return;
            paramView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a(0);
          } while (paramView == null);
          localObject1 = new Intent();
          ((Intent)localObject1).setClass(this, TroopAvatarWallEditActivity.class);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt("index", 0);
          localObject3 = new ArrayList();
          if (((paramView.jdField_d_of_type_JavaLangString.equals("AVATAR_URL_STR")) || (paramView.jdField_d_of_type_JavaLangString.equals("SYSTEM_PHOTO"))) && (paramView.jdField_b_of_type_JavaLangString == null)) {
            ((ArrayList)localObject3).add(paramView.jdField_c_of_type_JavaLangString);
          }
          for (;;)
          {
            ((Bundle)localObject2).putBoolean("IS_EDIT", false);
            ((Bundle)localObject2).putStringArrayList("seqNum", (ArrayList)localObject3);
            ((Bundle)localObject2).putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            ((Bundle)localObject2).putLong("troop_flag_ext", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt);
            ((Bundle)localObject2).putInt("troop_auth_submit_time", this.jdField_l_of_type_Int);
            ((Bundle)localObject2).putBoolean("troop_info_is_member", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
            ((Intent)localObject1).putExtras((Bundle)localObject2);
            startActivityForResult((Intent)localObject1, 12);
            return;
            ((ArrayList)localObject3).add(paramView.jdField_b_of_type_JavaLangString);
          }
          R();
          ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
          ReportController.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Set_chatBG", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
          TroopReportor.a("Grp_set_new", "grpData_admin", "set_chatBG", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
          return;
          paramView = new Intent();
          localObject1 = new Bundle();
          paramView.setClass(this, TroopAvatarWallEditActivity.class);
          ((Bundle)localObject1).putInt("index", 0);
          localObject2 = new ArrayList();
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a();
          if (localObject3 != null) {
            break label3195;
          }
        } while (!QLog.isColorLevel());
        QLog.i("Q.troop_avatar_wall", 2, "avatarInfos == null on click");
        return;
        i1 = ((List)localObject3).size();
        if (QLog.isColorLevel()) {
          QLog.i("Q.troop_avatar_wall", 2, "avatarInfos.size=" + i1 + " on click");
        }
        Object localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          AvatarWallAdapter.AvatarInfo localAvatarInfo = (AvatarWallAdapter.AvatarInfo)((Iterator)localObject3).next();
          if (localAvatarInfo != null) {
            if (((localAvatarInfo.jdField_d_of_type_JavaLangString.equals("AVATAR_URL_STR")) || (localAvatarInfo.jdField_d_of_type_JavaLangString.equals("SYSTEM_PHOTO"))) && (localAvatarInfo.jdField_b_of_type_JavaLangString == null) && (localAvatarInfo.jdField_c_of_type_JavaLangString != null)) {
              ((ArrayList)localObject2).add(localAvatarInfo.jdField_c_of_type_JavaLangString);
            } else if (localAvatarInfo.jdField_b_of_type_JavaLangString != null) {
              ((ArrayList)localObject2).add(localAvatarInfo.jdField_b_of_type_JavaLangString);
            }
          }
        }
      } while (((ArrayList)localObject2).size() == 0);
      ((Bundle)localObject1).putBoolean("IS_EDIT", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      ((Bundle)localObject1).putStringArrayList("seqNum", (ArrayList)localObject2);
      ((Bundle)localObject1).putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((Bundle)localObject1).putLong("troop_flag_ext", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt);
      ((Bundle)localObject1).putInt("troop_auth_submit_time", this.jdField_l_of_type_Int);
      ((Bundle)localObject1).putBoolean("troop_info_is_member", true);
      paramView.putExtras((Bundle)localObject1);
      startActivityForResult(paramView, 12);
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
        for (paramView = "1";; paramView = "0")
        {
          TroopReportor.a("Grp_set_new", "grpData_admin", "clk_head", 0, 0, new String[] { localObject1, paramView });
          return;
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
      for (paramView = "1";; paramView = "0")
      {
        TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_head", 0, 0, new String[] { localObject1, paramView });
        return;
      }
      paramView = new Intent(this, QQBrowserActivity.class);
      localObject1 = IndividuationUrlHelper.a("troopEnterEffect");
      paramView.putExtra("url", (String)localObject1 + "&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      startActivityForResult(paramView, 19);
      TroopEnterEffectManager.a("grp_data", "entry_clk", new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      i1 = ((TroopEnterEffectManager)this.app.getManager(230)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      VasWebviewUtil.reportCommercialDrainage(this.app.c(), "style", "0X8008E62", "", 1, 0, 0, "", Integer.toString(i1), "");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin != null)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin != null) {
        TroopMoreDetailFragment.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.jdField_d_of_type_Boolean);
      }
      TroopReportor.a("Grp_set_new", "grpData_admin", "clk_moreData", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      k();
      TroopReportor.a("Grp_set_new", "grpData_admin", "clk_delRecord", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      TroopNotificationHelper.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1106611799);
      this.jdField_m_of_type_Int = ((int)NetConnInfoCenter.getServerTime());
      ThreadManager.post(new sad(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 5, null, false);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(20);
      TroopReportor.a("Grp_game", "Grp_data", "feeds_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      if (i1 == 31) {
        TroopReportor.a("Grp_game", "Grp_data", "rank_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
      localObject1 = paramView.getTag(2131362360);
      if (((localObject1 instanceof String)) && (!TextUtils.isEmpty((String)localObject1)))
      {
        localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        startActivity((Intent)localObject2);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.chatopttroop", 2, "game item click type=" + paramView.getId() + ", url=" + localObject1);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof DiscussionInfoCardActivity.ViewHolder)))
        {
          localObject = (DiscussionInfoCardActivity.ViewHolder)localObject;
          if (paramString != null) {
            break label72;
          }
          a((DiscussionInfoCardActivity.ViewHolder)localObject, null, false);
        }
        label72:
        while (!paramString.equals(((DiscussionInfoCardActivity.ViewHolder)localObject).jdField_a_of_type_JavaLangString))
        {
          paramInt1 += 1;
          break;
        }
        ((DiscussionInfoCardActivity.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap));
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof Integer)) {
      switch (((Integer)localObject).intValue())
      {
      }
    }
    for (;;)
    {
      return false;
      try
      {
        localObject = new QQCustomMenu();
        ((QQCustomMenu)localObject).a(2131375342, getString(2131435076), 2130838301);
        BubbleContextMenu.a(paramView, (QQCustomMenu)localObject, new saf(this), new sag(this));
      }
      catch (WindowManager.BadTokenException paramView) {}
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, paramView.getMessage());
      }
    }
  }
  
  protected void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, getResources(), this.app.getCurrentAccountUin());
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop = false;
        u();
      }
    }
    b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
    x();
    A();
    ThreadManager.post(new sbd(this), 8, null, true);
    y();
    v();
    M();
    w();
  }
  
  protected void q()
  {
    Intent localIntent = new Intent(this, PublicAccountBrowser.class);
    localIntent.putExtra("url", "http://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    super.startActivity(localIntent);
  }
  
  public void r()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435053);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void s()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  protected void t()
  {
    if (this.jdField_e_of_type_JavaUtilList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i2 = this.jdField_e_of_type_JavaUtilList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      localObject = (oidb_0x899.memberlist)this.jdField_e_of_type_JavaUtilList.get(i1);
      if ((localObject == null) || (!((oidb_0x899.memberlist)localObject).uint64_member_uin.has())) {}
      for (;;)
      {
        i1 += 1;
        break;
        localArrayList.add(String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get()));
      }
    }
    Object localObject = new Intent(this, TroopAdminList.class);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
    ((Intent)localObject).putStringArrayListExtra("troop_info_memo", localArrayList);
    ((Intent)localObject).putExtra("t_s_f", getIntent().getIntExtra("t_s_f", -1));
    startActivity((Intent)localObject);
  }
  
  public void u()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "updateTroopInfoToDB");
      }
      ThreadManager.post(new sbk(this), 5, null, false);
    }
  }
  
  public void v()
  {
    View localView1;
    View localView2;
    FollowImageTextView localFollowImageTextView;
    ImageView localImageView;
    TextView localTextView;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      localView1 = this.jdField_a_of_type_ArrayOfAndroidViewView[27];
      P();
      localView2 = localView1.findViewById(2131368428);
      localFollowImageTextView = (FollowImageTextView)this.jdField_a_of_type_ArrayOfAndroidViewView[15];
      localImageView = (ImageView)localView1.findViewById(2131363668);
      localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[13].findViewById(2131364607);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        break label174;
      }
      localView1.setBackgroundDrawable(null);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130841264);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841265);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setVisibility(0);
      localView2.setVisibility(0);
      localFollowImageTextView.setTextColor(getResources().getColor(2131492968));
      localImageView.setImageResource(2130841394);
      localFollowImageTextView.setFollowImageResource(2130841416);
      if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (!this.jdField_d_of_type_Boolean)) {
        break label283;
      }
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      f();
      return;
      label174:
      localView1.setBackgroundResource(2130838621);
      if ("1103".equals(ThemeUtil.getCurrentThemeId()))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130841264);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841265);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setVisibility(8);
        localView2.setVisibility(8);
        localFollowImageTextView.setTextColor(getResources().getColor(2131494210));
        localImageView.setImageResource(2130841395);
        localFollowImageTextView.setFollowImageResource(2130841415);
        break;
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130841417);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841402);
      }
      label283:
      localTextView.setVisibility(0);
    }
  }
  
  protected void w()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[19];
    if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mCanSearchByKeywords) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mCanSearchByTroopUin)) {
        localView.setVisibility(0);
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  protected void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName) {}
    for (int i1 = 0;; i1 = 8)
    {
      View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[26];
      if (localView != null) {
        localView.setVisibility(i1);
      }
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[25];
      if (localView != null) {
        localView.setVisibility(i1);
      }
      return;
    }
  }
  
  public void y()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    do
    {
      return;
      localObject = (ImageView)((View)localObject).findViewById(2131366563);
    } while ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwAuthGroupType == 2L) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwAuthGroupType == 1L))
    {
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setOnClickListener(new sbl(this));
      return;
    }
    ((ImageView)localObject).setVisibility(8);
  }
  
  public void z()
  {
    Context localContext = getApplicationContext();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      String str = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
      GroupCatalogTool.a(localContext).a(str, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop
 * JD-Core Version:    0.7.0.1
 */