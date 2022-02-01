package com.tencent.biz.pubaccount;

import Override;
import aahr;
import aaht;
import aatx;
import aebd;
import aeou;
import ahcf;
import alik;
import amfb;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anvx;
import aoan;
import aoav;
import aoks;
import aooy;
import aoxz;
import apar;
import apaw;
import aveq;
import aves;
import ayoq;
import ayos;
import bcmv;
import bdla;
import bdof;
import bdpo;
import bdzy;
import bhcu;
import bhfm;
import bhsf;
import bhxi;
import bisl;
import bjxa;
import bkzi;
import bkzz;
import bmar;
import com.tencent.biz.pubaccount.AccountDetail.activity.PubAccountMoreInfoActivity;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import nwu;
import nzg;
import nzh;
import nzu;
import oaz;
import obb;
import ocx;
import ocz;
import oda;
import odb;
import odc;
import odd;
import ode;
import odf;
import odg;
import odh;
import odi;
import odj;
import odk;
import odl;
import odm;
import odn;
import odo;
import odp;
import odr;
import ods;
import odv;
import oji;
import olh;
import oln;
import olp;
import ook;
import opg;
import oph;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import pin;
import pkh;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import uot;
import usa;
import uuc;
import uvs;
import uyt;

public class AccountDetailActivity
  extends BaseActivity
  implements View.OnClickListener, ocx
{
  public static int i;
  public static int j;
  public static int k = 1;
  protected float a;
  long jdField_a_of_type_Long;
  protected aahr a;
  aatx jdField_a_of_type_Aatx;
  public Intent a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new odk(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  protected ImageView a;
  public RelativeLayout a;
  final aoav jdField_a_of_type_Aoav = new ocz(this);
  bisl jdField_a_of_type_Bisl;
  bkzi jdField_a_of_type_Bkzi = null;
  protected AccountDetailTopGestureLayout a;
  public AccountDetailXListView a;
  public ProfileParams a;
  public PublicAccountHandler a;
  public QQAppInterface a;
  public AccountDetail a;
  public mobileqq_mp.GetPublicAccountDetailInfoResponse a;
  public ShareActionSheetBuilder a;
  protected BusinessObserver a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public nzu a;
  odr jdField_a_of_type_Odr;
  ods jdField_a_of_type_Ods;
  private odv jdField_a_of_type_Odv;
  public JSONObject a;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  public int b;
  long jdField_b_of_type_Long;
  public View b;
  protected Button b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  apar jdField_b_of_type_Apar;
  public bkzi b;
  public String b;
  protected BusinessObserver b;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  View jdField_c_of_type_AndroidViewView;
  protected Button c;
  public ImageView c;
  apar jdField_c_of_type_Apar;
  public String c;
  protected NewIntent c;
  BusinessObserver jdField_c_of_type_MqqObserverBusinessObserver;
  public boolean c;
  int d;
  protected View d;
  public Button d;
  public ImageView d;
  public String d;
  protected NewIntent d;
  protected boolean d;
  int jdField_e_of_type_Int = 0;
  protected View e;
  public ImageView e;
  public String e;
  NewIntent jdField_e_of_type_MqqAppNewIntent;
  public boolean e;
  int f;
  protected View f;
  public String f;
  public boolean f;
  public int g;
  private View g;
  public String g;
  public boolean g;
  public int h;
  protected String h;
  public boolean h;
  public String i;
  public boolean i;
  public boolean j;
  public boolean k;
  public int l;
  boolean l;
  boolean m = false;
  boolean n = false;
  public boolean o;
  boolean p = false;
  public boolean q = false;
  boolean r = false;
  private boolean s;
  private boolean t;
  
  static
  {
    jdField_j_of_type_Int = -1;
  }
  
  public AccountDetailActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = null;
    this.jdField_b_of_type_Bkzi = null;
    this.jdField_d_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_l_of_type_Int = jdField_i_of_type_Int;
    this.jdField_a_of_type_AndroidOsHandler = new ode(this);
  }
  
  private void T()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new AccountDetailActivity.16(this));
      return;
    }
    j();
  }
  
  @NotNull
  private String a(int paramInt1, aaht paramaaht, String paramString1, int paramInt2, String paramString2, BaseActivity paramBaseActivity)
  {
    aahr.a(paramBaseActivity, paramaaht, paramInt2, paramString2, paramInt1);
    if (paramInt1 == 9) {
      paramString2 = "03";
    }
    for (paramaaht = "share_wechat";; paramaaht = "share_circle")
    {
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, "Grp_tribe", "interest_data", paramaaht);
      olh.a(null, "P_CliOper", "Pb_account_lifeservice", paramString1, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
      return paramString2;
      paramString2 = "04";
    }
  }
  
  @NotNull
  private String a(aaht paramaaht, String paramString1, int paramInt, String paramString2, BaseActivity paramBaseActivity)
  {
    aahr.b(paramBaseActivity, paramaaht, paramInt, paramString2);
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, "Grp_tribe", "interest_data", "share_qq");
    return "01";
  }
  
  @NotNull
  private String a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, aaht paramaaht, String paramString1, int paramInt, String paramString2, Activity paramActivity)
  {
    aahr.a(paramActivity, paramaaht, paramInt, paramString2, paramActionSheetItem);
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, "Grp_tribe", "interest_data", "share_qq");
    return "01";
  }
  
  public static String a(String paramString)
  {
    if (paramString != null) {
      try
      {
        int i1 = paramString.indexOf("article_id=");
        if (i1 > 0)
        {
          String str = paramString.substring(i1 + 11);
          i1 = str.indexOf("&");
          paramString = str;
          if (i1 >= 0) {
            paramString = str.substring(0, i1);
          }
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return "";
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.hasExtra("source"))) {
      return;
    }
    switch (paramIntent.getIntExtra("source", 0))
    {
    default: 
      return;
    case 1: 
      olh.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574C", "0X800574C", 0, 0, paramString, "", "", "", false);
      return;
    case 2: 
      olh.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574D", "0X800574D", 0, 0, paramString, "", "", "", false);
      return;
    case 3: 
      olh.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574E", "0X800574E", 0, 0, paramString, "", "", "", false);
      return;
    }
    olh.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800589D", "0X800589D", 0, 0, paramString, "", "", "", false);
  }
  
  private void a(ShareActionSheet paramShareActionSheet, Activity paramActivity)
  {
    paramShareActionSheet.setItemClickListenerV2(new odh(this, paramActivity));
  }
  
  public static void a(Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("target_qq", paramString2);
      localHashMap.put("area", "2");
      localHashMap.put("dt_appkey", "0P000B1E6X38P6V3");
      VideoReport.setElementParams(paramObject, localHashMap);
      VideoReport.setElementId(paramObject, paramString1);
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
      QLog.e("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "setDatatongElement", paramObject);
    }
  }
  
  private void a(String paramString)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "ActionSheet setOrCancelSetTop");
    }
    int i1 = uuc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString);
    if (i1 == 1024) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "setOrCancelTop pUin = " + paramString + " userType = " + i1 + " is UIN_TYPE_BUSINESS_CMR_TMP");
    }
    aoxz localaoxz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    RecentUser localRecentUser = (RecentUser)localaoxz.findRecentUser(paramString, i1);
    Object localObject = localRecentUser;
    if (localRecentUser == null)
    {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "setOrCancelTop pUin = " + paramString + " userType = " + i1 + " not in the msglist");
      localObject = new RecentUser(this.jdField_e_of_type_JavaLangString, i1);
    }
    boolean bool3 = a(paramString);
    if (bool3)
    {
      ((RecentUser)localObject).showUpTime = 0L;
      localaoxz.saveRecentUser((BaseRecentUser)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
      if (bool3) {
        break label265;
      }
      bool1 = true;
      label229:
      uvs.a(i1, paramString, bool1);
      if (bool3) {
        break label270;
      }
    }
    label265:
    label270:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      opg.a(i1, paramString, bool1);
      return;
      ((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);
      break;
      bool1 = false;
      break label229;
    }
  }
  
  private void a(String paramString, aaht paramaaht)
  {
    QQAppInterface localQQAppInterface;
    String str2;
    if ((!TextUtils.isEmpty(paramString)) && (paramaaht.jdField_c_of_type_Int == aaht.jdField_b_of_type_Int))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str2 = paramaaht.a();
      if (!paramaaht.jdField_a_of_type_Boolean) {
        break label72;
      }
    }
    label72:
    for (String str1 = "02";; str1 = "01")
    {
      bdla.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str2, "0X8007CA6", "0X8007CA6", 0, 0, str1, paramString, String.valueOf(paramaaht.jdField_d_of_type_Int), "");
      return;
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = bdzy.a().b();
    localObject = bdzy.a().a((String)localObject);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      int i1 = ((structmsg.StructMsg)localObject).msg_type.get();
      long l1 = ((structmsg.StructMsg)localObject).msg_seq.get();
      long l2 = ((structmsg.StructMsg)localObject).req_uin.get();
      int i2 = ((structmsg.StructMsg)localObject).msg.sub_type.get();
      int i3 = ((structmsg.StructMsg)localObject).msg.src_id.get();
      int i4 = ((structmsg.StructMsg)localObject).msg.sub_src_id.get();
      int i5 = ((structmsg.StructMsg)localObject).msg.group_msg_type.get();
      localObject = ((structmsg.StructMsg)localObject).msg.actions.get();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (paramInt < ((List)localObject).size())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get(), paramInt);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected static boolean a(AccountDetail paramAccountDetail)
  {
    boolean bool2 = true;
    if (paramAccountDetail == null) {
      return false;
    }
    int i1 = uuc.a(paramAccountDetail.accountFlag);
    boolean bool1 = bool2;
    if (i1 != -2)
    {
      bool1 = bool2;
      if (i1 != -3)
      {
        if (i1 != -4) {
          break label42;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      label42:
      bool1 = bool2;
      if (uuc.a(paramAccountDetail.accountFlag2) != -8L) {
        bool1 = false;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    int i1 = uuc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString);
    RecentUser localRecentUser = (RecentUser)((aoxz)localObject).findRecentUser(paramString, i1);
    localObject = localRecentUser;
    if (localRecentUser == null)
    {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "isPublicAccoutMsgTabSetTop pUin = " + paramString + " userType = " + i1 + " not in the msglist");
      localObject = new RecentUser(this.jdField_e_of_type_JavaLangString, i1);
    }
    return ((RecentUser)localObject).showUpTime != 0L;
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131696130);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839146;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).iconNeedBg = true;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 2;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131696143);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839147;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).iconNeedBg = true;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 3;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131696150);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839150;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 9;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    localObject = new ShareActionSheetBuilder.ActionSheetItem();
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).label = super.getString(2131696133);
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).icon = 2130839144;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).action = 10;
    ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus = "";
    localArrayList.add(localObject);
    bjxa.a(this, localArrayList);
    localObject = new ArrayList();
    if (d())
    {
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = super.getString(2131694963);
      localActionSheetItem.icon = 2130842697;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 30;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = super.getString(2131695016);
    localActionSheetItem.icon = 2130842689;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 31;
    localActionSheetItem.argus = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = super.getString(2131695003);
    localActionSheetItem.icon = 2130842681;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 11;
    localActionSheetItem.argus = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    if (d())
    {
      localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.label = super.getString(2131695029);
      localActionSheetItem.icon = 2130842707;
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.action = 32;
      localActionSheetItem.argus = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  @NotNull
  private String b(aaht paramaaht, String paramString1, int paramInt, String paramString2, BaseActivity paramBaseActivity)
  {
    aahr.a(paramBaseActivity, paramaaht, paramInt, paramString2);
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, "Grp_tribe", "interest_data", "share_qzone");
    return "02";
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem> b()
  {
    return new ArrayList();
  }
  
  private void b()
  {
    try
    {
      VideoReport.addToDetectionWhitelist(this);
      VideoReport.setPageId(this, "gzh_pg_profile");
      HashMap localHashMap = new HashMap();
      localHashMap.put("page_type", "2");
      localHashMap.put("target_qq", this.jdField_e_of_type_JavaLangString);
      localHashMap.put("dt_appkey", "0P000B1E6X38P6V3");
      VideoReport.setPageParams(this, new PageParams(localHashMap));
      a(this.jdField_b_of_type_AndroidWidgetButton, "gzh_ele_enter_aio", this.jdField_e_of_type_JavaLangString);
      a(this.jdField_b_of_type_AndroidViewView, "gzh_ele_follow", this.jdField_e_of_type_JavaLangString);
      a(this.jdField_c_of_type_AndroidWidgetButton, "gzh_ele_unfollow", this.jdField_e_of_type_JavaLangString);
      a(this.jdField_a_of_type_AndroidWidgetImageView, "gzh_ele_three_dot", this.jdField_e_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "setDatongParam", localException);
    }
  }
  
  private void c()
  {
    if (this.s)
    {
      uyt.a(this, "from_account_detail", 3, true);
      this.s = false;
    }
  }
  
  private void e()
  {
    MiniGamePublicAccountHelper.launchMiniGamePublicAccount(this);
  }
  
  private boolean f()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  private void m()
  {
    ayos.a(this, this.jdField_e_of_type_JavaLangString, 2);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "ActionSheet toSettingFragment");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {}
    Integer localInteger;
    do
    {
      return;
      localInteger = uuc.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    } while (localInteger == null);
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("name", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    localIntent.putExtra("push_type", localInteger);
    PublicFragmentActivity.a(getActivity(), localIntent, AccountSettingFragment.class);
  }
  
  protected void A()
  {
    if (this.jdField_h_of_type_Int == 119)
    {
      doOnBackPressed();
      return;
    }
    uyt.a(this, "from_account_detail", 3, true);
  }
  
  protected void B()
  {
    aves.b(this);
  }
  
  protected void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "ActionSheet showActionSheet");
    }
    odp localodp = new odp(this, (bkzi)bkzz.a(this, null));
    localodp.a();
    localodp.b();
    if ((this.jdField_e_of_type_JavaLangString.equals("1770946116")) || (nwu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString))) {
      localodp.c();
    }
    for (;;)
    {
      localodp.f();
      this.jdField_a_of_type_Bkzi = localodp.a();
      if (!this.jdField_a_of_type_Bkzi.isShowing()) {
        this.jdField_a_of_type_Bkzi.show();
      }
      return;
      if ((uot.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString)) || (uot.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString)))
      {
        localodp.e();
      }
      else if (uot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString))
      {
        localodp.d();
        localodp.e();
      }
      else
      {
        localodp.c();
        localodp.e();
      }
    }
  }
  
  protected void D()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(getString(2131718786));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
        return;
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      }
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  public void E()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "ActionSheet gotoMoreInfoActivity");
    }
    Intent localIntent = new Intent(getActivity(), PubAccountMoreInfoActivity.class);
    localIntent.putExtra("uin", this.jdField_e_of_type_JavaLangString);
    startActivity(localIntent);
  }
  
  public void F()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "ActionSheet report");
    }
    ThreadManager.getSubThreadHandler().post(new AccountDetailActivity.11(this));
  }
  
  public void G()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "initData hasCache");
      }
      this.jdField_c_of_type_Boolean = false;
      T();
      d();
      return;
    }
    ThreadManager.getSubThreadHandler().post(new AccountDetailActivity.12(this));
  }
  
  public void H()
  {
    this.jdField_b_of_type_Bkzi = bkzi.a(this);
    String str = getString(2131695031, new Object[] { a() });
    this.jdField_b_of_type_Bkzi.a(str);
    this.jdField_b_of_type_Bkzi.a(2131696176, 3);
    this.jdField_b_of_type_Bkzi.c(2131690697);
    this.jdField_b_of_type_Bkzi.setOnDismissListener(new odb(this));
    this.jdField_b_of_type_Bkzi.a(new odc(this));
    if (!this.jdField_b_of_type_Bkzi.isShowing())
    {
      this.o = false;
      this.jdField_b_of_type_Bkzi.show();
    }
  }
  
  public void I()
  {
    if (c())
    {
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  void J()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setVisibility(8);
  }
  
  @TargetApi(16)
  void K()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (!this.jdField_l_of_type_Boolean)) {}
    while (!c()) {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
    this.jdField_d_of_type_AndroidWidgetButton.setText(2131695027);
    this.jdField_d_of_type_AndroidWidgetButton.setAlpha(0.5F);
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.17(this), 0L);
  }
  
  void L()
  {
    this.jdField_a_of_type_Nzu.a(a());
    this.jdField_a_of_type_Nzu.b(b());
    this.jdField_a_of_type_Nzu.c(c());
    this.jdField_a_of_type_Nzu.a(this.jdField_l_of_type_Boolean);
    this.jdField_a_of_type_Nzu.a(b());
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.jdField_a_of_type_Nzu.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    }
  }
  
  public void M()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
  
  void N()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "firstFetch");
    }
    d();
    T();
  }
  
  public void O()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "send839PublicAccountDetailInfoRequest");
    }
    olp.a(Long.valueOf(Long.parseLong(this.jdField_e_of_type_JavaLangString)), "", new odf(this));
  }
  
  void P()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest");
    }
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), oln.class);
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.4.10,3,4875");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localGetPublicAccountDetailInfoRequest.seqno.set(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno);
    }
    try
    {
      for (;;)
      {
        localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.jdField_e_of_type_JavaLangString));
        label125:
        this.jdField_c_of_type_MqqAppNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
        this.jdField_a_of_type_MqqObserverBusinessObserver = new odg(this);
        this.jdField_c_of_type_MqqAppNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_c_of_type_MqqAppNewIntent);
        this.jdField_c_of_type_Int += 1;
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest exit");
        }
        return;
        localGetPublicAccountDetailInfoRequest.seqno.set(0);
      }
    }
    catch (Exception localException)
    {
      break label125;
    }
  }
  
  protected void Q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "ActionSheet showNewShareActionSheet");
    }
    Object localObject = new ShareActionSheetV2.Param();
    ((ShareActionSheetV2.Param)localObject).context = this;
    ((ShareActionSheetV2.Param)localObject).fullScreen = false;
    localObject = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    ((ShareActionSheet)localObject).setIntentForStartForwardRecentActivity(getIntent());
    ((ShareActionSheet)localObject).setActionSheetItems(a(), b());
    ((ShareActionSheet)localObject).setRowVisibility(0, 0, 0);
    a((ShareActionSheet)localObject, this);
    getIntent().putExtra("big_brother_source_key", "biz_src_jc_gzh");
    ((ShareActionSheet)localObject).show();
    ((ShareActionSheet)localObject).refresh();
  }
  
  protected void R()
  {
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateHDFace uin is null");
      }
    }
    do
    {
      return;
      if (NetworkUtil.isWifiConnected(this)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateHDFace not wifi, so need't update");
    return;
    this.jdField_a_of_type_Ods = new ods(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Ods.a();
  }
  
  public void S()
  {
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "setHDFace uin is null");
      }
    }
    while (this.jdField_a_of_type_Nzu == null) {
      return;
    }
    Drawable localDrawable = c();
    this.jdField_a_of_type_Nzu.c(localDrawable);
    this.jdField_a_of_type_Nzu.notifyDataSetChanged();
  }
  
  public int a()
  {
    return 1;
  }
  
  public aaht a()
  {
    aaht localaaht = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
    {
      localaaht = new aaht(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
      localaaht.jdField_c_of_type_Int = aaht.jdField_b_of_type_Int;
      localaaht.jdField_a_of_type_Boolean = c();
      localaaht.jdField_d_of_type_Int = olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    }
    return localaaht;
  }
  
  Bitmap a(Bitmap paramBitmap)
  {
    int i3 = 0;
    int i4 = getWindowManager().getDefaultDisplay().getWidth();
    int i5 = (int)(140.0F * this.jdField_a_of_type_Float);
    int i1 = paramBitmap.getHeight();
    int i2 = paramBitmap.getWidth();
    if (i2 * i5 > i1 * i4)
    {
      i5 = i4 * i1 / i5;
      i4 = (i2 - i5) / 2;
      i2 = i5;
    }
    for (;;)
    {
      return Bitmap.createBitmap(paramBitmap, i4, i3, i2, i1);
      i4 = i5 * i2 / i4;
      i3 = (i1 - i4) / 2;
      i1 = i4;
      i4 = 0;
    }
  }
  
  Drawable a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return null;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundImg)) {
      return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundImg);
    }
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.19(this), 10L);
    return null;
  }
  
  Drawable a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      paramBitmap = a(paramBitmap);
      StackBlur.fastblur(paramBitmap, 1);
      paramBitmap = new BitmapDrawable(paramBitmap);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public aoav a()
  {
    return this.jdField_a_of_type_Aoav;
  }
  
  protected String a()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    }
    return str;
  }
  
  String a(Intent paramIntent)
  {
    Object localObject = null;
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("uin");
    }
    do
    {
      return paramIntent;
      paramIntent = localObject;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams == null);
    return this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.a().jdField_b_of_type_JavaLangString;
  }
  
  protected List<oji> a(List<oji> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(2);
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      oji localoji = (oji)paramList.get(i1);
      if ((localoji.a == 3) && ((localoji.jdField_c_of_type_Int == 7) || (localoji.jdField_c_of_type_Int == 8))) {
        localArrayList.add(localoji);
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public JSONObject a(BaseActivity paramBaseActivity, String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = paramBaseActivity.app.getMessageFacade().getAllMessages(paramString, 0, new int[] { -1000, -2000, -2002, -2011, -2022 }, 40);
        paramBaseActivity = new ArrayList();
        if (localObject1 != null)
        {
          i1 = ((List)localObject1).size();
          if (i1 > 0)
          {
            if (((MessageRecord)((List)localObject1).get(i1 - 1)).issend != 0) {
              break label712;
            }
            paramBaseActivity.add(((List)localObject1).get(i1 - 1));
            if (paramBaseActivity.size() <= 4) {
              break label712;
            }
          }
        }
        localObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        localJSONObject2.put("qq", localObject2);
        Object localObject3 = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        String str = String.valueOf(NetConnInfoCenter.getServerTime());
        localJSONObject2.put("skey", localObject3);
        localJSONObject2.put("mpUin", paramString);
        localJSONObject2.put("timestamp", "" + str);
        localJSONObject2.put("scene", "201");
        localJSONObject2.put("subAppname", "profile");
        localJSONObject2.put("sign", MD5Utils.encodeHexStr((String)localObject2 + paramString + 201 + str + "jubao@article@123").toLowerCase());
        if (paramBaseActivity != null)
        {
          int i2 = 0;
          if (i2 < paramBaseActivity.size())
          {
            paramString = new JSONObject();
            localObject2 = new JSONObject();
            localObject3 = (MessageRecord)paramBaseActivity.get(i2);
            if ((localObject3 instanceof MessageForText))
            {
              ((JSONObject)localObject2).put("text", ((MessageRecord)localObject3).msg);
              i1 = 1;
              paramString.put("content", localObject2);
              paramString.put("messageType", "" + i1);
              localJSONArray.put(i2, paramString);
              i2 += 1;
              continue;
            }
            if ((localObject3 instanceof MessageForPic))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForPic)localObject3).uuid);
              i1 = 2;
              continue;
            }
            if ((localObject3 instanceof MessageForPtt))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForPtt)localObject3).urlAtServer);
              ((JSONObject)localObject2).put("fileType", ((MessageForPtt)localObject3).busiType);
              i1 = 3;
              continue;
            }
            if ((localObject3 instanceof MessageForShortVideo))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForShortVideo)localObject3).uuid.substring(1));
              i1 = 4;
              continue;
            }
            if ((localObject3 instanceof MessageForStructing))
            {
              ((JSONObject)localObject2).put("text", new String(bdpo.a(bmar.a(bdof.a(((MessageRecord)localObject3).msgData).getXmlBytes()), 0), "utf-8"));
              i1 = 5;
              continue;
            }
          }
          else
          {
            ((JSONObject)localObject1).put("msgNum", "" + paramBaseActivity.size());
            ((JSONObject)localObject1).put("messageList", bhcu.encodeToString(localJSONArray.toString().getBytes("utf-8"), 0));
          }
        }
        else
        {
          localJSONObject1.put("Verify", localJSONObject2);
          localJSONObject1.put("reportData", localObject1);
          return localJSONObject1;
        }
      }
      catch (Exception paramBaseActivity)
      {
        return null;
      }
      int i1 = 0;
      continue;
      label712:
      i1 -= 1;
    }
  }
  
  @TargetApi(9)
  protected void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView = ((AccountDetailXListView)super.findViewById(2131361860));
    this.jdField_d_of_type_Int = getWindowManager().getDefaultDisplay().getHeight();
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setDividerHeight(0);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setRefreshCallback(this);
    l();
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.mShowMsgFlag = paramInt;
    }
  }
  
  public void a(aebd paramaebd)
  {
    if (paramaebd == null) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateCurrentImage currentImage is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateCurrentImage uin=" + paramaebd.jdField_d_of_type_JavaLangString + ", state=" + paramaebd.a);
      }
    } while (paramaebd.a != 6);
    f(paramaebd.jdField_c_of_type_JavaLangString);
  }
  
  void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Aatx == null) {
      this.jdField_a_of_type_Aatx = new aatx(paramActivity);
    }
    this.jdField_a_of_type_Aatx.a(anvx.a(2131699249));
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131718624);
    str = str + anvx.a(2131699250);
    paramActivity = new oda(this, paramActivity);
    this.jdField_a_of_type_Aatx.a(str, paramActivity);
    this.jdField_a_of_type_Aatx.a(paramActivity);
    this.jdField_a_of_type_Aatx.show();
  }
  
  void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    Object localObject = paramIntent.getExtras();
    if (localObject != null)
    {
      localObject = (ProfileParams)((Bundle)localObject).getParcelable("profile_params");
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams = ((ProfileParams)localObject);
      }
    }
    this.jdField_e_of_type_JavaLangString = a(paramIntent);
    this.t = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_use_style_839", true);
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("report_src_param_type");
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("report_src_param_name");
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("weather_share_url");
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("weather_outside_follow_state", 0);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "[sopType]:" + this.jdField_b_of_type_JavaLangString + ",[sopName]:" + this.jdField_c_of_type_JavaLangString + ",[weatherShareUrl]:" + this.jdField_d_of_type_JavaLangString + ",[weatherOutsideFollowState]:" + this.jdField_b_of_type_Int);
    }
    this.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("extvalue");
    this.jdField_h_of_type_JavaLangString = paramIntent.getStringExtra("exttype");
    if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))
    {
      if (!"2".equals(this.jdField_h_of_type_JavaLangString)) {
        break label249;
      }
      this.jdField_e_of_type_Boolean = true;
    }
    while ((this.jdField_e_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      return;
      label249:
      if ("1".equals(this.jdField_h_of_type_JavaLangString)) {
        this.jdField_f_of_type_Boolean = true;
      }
    }
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT));
    r();
    R();
    b(paramIntent);
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
  }
  
  void a(AccountDetail paramAccountDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "saveAccountDetailToDBAndCache");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, paramAccountDetail.name);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.clone(paramAccountDetail);
      if (!((EntityManager)localObject).update(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
        ((EntityManager)localObject).drop(AccountDetail.class);
      }
    }
    for (;;)
    {
      ((EntityManager)localObject).close();
      localObject = (aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if ((localObject != null) && (paramAccountDetail != null))
      {
        ((aoan)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
        if (paramAccountDetail.followType == 1) {
          ((aoan)localObject).a(PublicAccountInfo.createPublicAccount(paramAccountDetail, 0L));
        }
      }
      T();
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
      ((EntityManager)localObject).persist(paramAccountDetail);
    }
  }
  
  public void a(AccountDetail paramAccountDetail, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.21(this, paramAccountDetail, paramBoolean), 10L);
  }
  
  public void a(ListView paramListView)
  {
    if (this.q)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "startLoadMore: uin=" + this.jdField_e_of_type_JavaLangString);
      }
      oaz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_e_of_type_JavaLangString), this.jdField_a_of_type_Aoav);
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, Class<? extends Activity> paramClass)
  {
    a(paramString1, paramInt, paramString2, paramClass, false);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, Class<? extends Activity> paramClass, boolean paramBoolean)
  {
    if ((TextUtils.equals("2290230341", paramString1)) && (QZoneMsgActivity.open(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      return;
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if ((getIntent().hasExtra("qidian_chat")) && (getIntent().getBooleanExtra("qidian_chat", false)))
    {
      localIntent.setComponent(new ComponentName(this, SplashActivity.class));
      localBundle.putBoolean("open_chatfragment", true);
    }
    for (;;)
    {
      localBundle.putString("uin", paramString1);
      localBundle.putInt("uintype", paramInt);
      localBundle.putString("uinname", paramString2);
      localIntent.putExtras(localBundle);
      localIntent.setFlags(67108864);
      boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("need_finish", false);
      if (this.jdField_e_of_type_Boolean)
      {
        localIntent.putExtra("forward_type", -1);
        localIntent.putExtra("forward_text", this.jdField_g_of_type_JavaLangString);
        this.jdField_e_of_type_Boolean = false;
      }
      if (bool) {
        super.finish();
      }
      localIntent.putExtra("isforceRequestDetail", paramBoolean);
      localIntent.putExtra("jump_from", 2);
      super.startActivity(localIntent);
      return;
      localIntent.setComponent(new ComponentName(this, paramClass));
    }
  }
  
  protected boolean a()
  {
    aoan localaoan = (aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localaoan != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = localaoan.b(this.jdField_e_of_type_JavaLangString);
      T();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "loadCache = null");
      }
      return false;
    }
    x();
    return true;
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[2];
    Display localDisplay = getWindowManager().getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    try
    {
      Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[] { DisplayMetrics.class }).invoke(localDisplay, new Object[] { localDisplayMetrics });
      arrayOfInt[0] = localDisplayMetrics.widthPixels;
      arrayOfInt[1] = localDisplayMetrics.heightPixels;
      return arrayOfInt;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return arrayOfInt;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int - this.jdField_e_of_type_Int - this.jdField_f_of_type_Int - 1;
  }
  
  Drawable b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {}
    do
    {
      return null;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor)) {
        this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor = "3d7fe3";
      }
      try
      {
        ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#E6" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor.substring(0, 6)));
        return localColorDrawable;
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException) {}
    } while (!QLog.isColorLevel());
    QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "configBackgroundColor length is not 6!");
    return null;
  }
  
  public String b()
  {
    if (this.jdField_i_of_type_JavaLangString == null)
    {
      int i1 = uuc.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
      if ((i1 != -2) && (i1 != -5)) {
        break label84;
      }
    }
    label84:
    for (this.jdField_i_of_type_JavaLangString = ("https://share.mp.qq.com/cgi/share.php?uin=" + this.jdField_e_of_type_JavaLangString + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account");; this.jdField_i_of_type_JavaLangString = ("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_e_of_type_JavaLangString)) {
      return this.jdField_i_of_type_JavaLangString;
    }
  }
  
  protected void b(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView.postDelayed(new AccountDetailActivity.2(this, paramInt), 500L);
  }
  
  void b(Intent paramIntent)
  {
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("fromBrowser", false);
    this.jdField_h_of_type_Int = paramIntent.getIntExtra("source", 0);
    switch (this.jdField_h_of_type_Int)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "[fromwhere]:" + this.jdField_g_of_type_Int);
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_e_of_type_JavaLangString, "0X8005A24", "0X8005A24", this.jdField_g_of_type_Int, 0, "", "", "", "");
      return;
      this.jdField_g_of_type_Int = 2;
      continue;
      this.jdField_g_of_type_Int = 1;
      continue;
      this.jdField_g_of_type_Int = 0;
      continue;
      this.jdField_g_of_type_Int = 3;
      continue;
      this.jdField_g_of_type_Int = 4;
      continue;
      this.jdField_g_of_type_Int = 5;
      continue;
      this.jdField_g_of_type_Int = 6;
      continue;
      this.jdField_g_of_type_Int = 8;
      continue;
      this.jdField_g_of_type_Int = 9;
      continue;
      this.jdField_g_of_type_Int = 11;
      continue;
      this.jdField_g_of_type_Int = 50;
      continue;
      this.jdField_g_of_type_Int = 12;
      continue;
      this.jdField_g_of_type_Int = 13;
    }
  }
  
  void b(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "deleteAccount");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localEntityManager.remove(paramAccountDetail);
    localEntityManager.close();
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent(this, PublicAccountBrowser.class);
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
    paramString = paramString.replace("${puin}", this.jdField_e_of_type_JavaLangString).replace("${uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("url", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "jumpWebView url=" + paramString);
    }
    localIntent.putExtra("puin", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("big_brother_source_key", uuc.b(this.jdField_e_of_type_JavaLangString));
    paramString = a();
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    super.startActivity(localIntent);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public boolean b(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {}
    while (this.jdField_b_of_type_Int != 3) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (ahcf.a(this.jdField_e_of_type_JavaLangString)) && (paramAccountDetail.followType == 1))
    {
      QLog.i("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "handleIfWeatherShare" + this.jdField_d_of_type_JavaLangString);
      this.jdField_b_of_type_Int = 1;
      runOnUiThread(new AccountDetailActivity.30(this));
      return true;
    }
    this.jdField_b_of_type_Int = 2;
    return false;
  }
  
  protected Drawable c()
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    FaceDrawable localFaceDrawable;
    do
    {
      return localObject;
      localObject = new File(aoks.a(this.jdField_e_of_type_JavaLangString));
      if (((File)localObject).isFile())
      {
        f(((File)localObject).getAbsolutePath());
        return FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 115, this.jdField_e_of_type_JavaLangString);
      }
      localFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 115, this.jdField_e_of_type_JavaLangString);
      localObject = localFaceDrawable;
    } while (this.jdField_a_of_type_Odr != null);
    this.jdField_a_of_type_Odr = new odr(this);
    addObserver(this.jdField_a_of_type_Odr);
    return localFaceDrawable;
  }
  
  void c(int paramInt)
  {
    if (this.jdField_a_of_type_Bisl != null)
    {
      this.jdField_a_of_type_Bisl.c(paramInt);
      if (!this.jdField_a_of_type_Bisl.isShowing()) {
        this.jdField_a_of_type_Bisl.show();
      }
    }
  }
  
  public void c(Intent paramIntent)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("fromBrowser", false);
    this.jdField_h_of_type_Int = paramIntent.getIntExtra("source", 0);
    QQAppInterface localQQAppInterface;
    String str;
    int i1;
    switch (this.jdField_h_of_type_Int)
    {
    default: 
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_g_of_type_Int = 20;
      }
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "[fromwhere]:" + this.jdField_g_of_type_Int);
      }
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str = this.jdField_e_of_type_JavaLangString;
      i1 = this.jdField_g_of_type_Int;
      if (!c()) {
        break;
      }
    }
    for (paramIntent = "02";; paramIntent = "01")
    {
      bdla.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str, "0X8007CA0", "0X8007CA0", i1, 0, paramIntent, String.valueOf(this.jdField_g_of_type_Int), String.valueOf(olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), "");
      return;
      this.jdField_g_of_type_Int = 11;
      break;
      this.jdField_g_of_type_Int = 12;
      break;
      this.jdField_g_of_type_Int = 13;
      break;
      this.jdField_g_of_type_Int = 14;
      break;
      this.jdField_g_of_type_Int = 15;
      break;
      this.jdField_g_of_type_Int = 16;
      break;
      this.jdField_g_of_type_Int = 17;
      break;
      this.jdField_g_of_type_Int = 18;
      break;
      this.jdField_g_of_type_Int = 19;
      break;
      this.jdField_g_of_type_Int = 21;
      break;
    }
  }
  
  void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams != null) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.c();
        Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.a();
        Object localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.b();
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "";
        }
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = "";
        }
        localObject3 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject3 = "";
        }
        long l1 = System.currentTimeMillis();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject1).append(",").append("app").append(",").append((String)localObject2).append(",").append((String)localObject3).append(",").append(l1);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", paramString, paramString, 0, 1, 0, ((StringBuilder)localObject4).toString(), "", "", "");
      }
      return;
    }
  }
  
  protected boolean c()
  {
    int i1 = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType;
    }
    return i1 == 1;
  }
  
  public boolean c(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {}
    while ((this.jdField_b_of_type_Int != 2) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (!ahcf.a(this.jdField_e_of_type_JavaLangString)) || (paramAccountDetail.followType != 1)) {
      return false;
    }
    QLog.i("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "handleIfWeatherShare" + this.jdField_d_of_type_JavaLangString);
    runOnUiThread(new AccountDetailActivity.31(this));
    return true;
  }
  
  protected void d()
  {
    P();
  }
  
  public void d(int paramInt)
  {
    Toast.makeText(getApplicationContext(), paramInt, 0).show();
  }
  
  protected void d(String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131755829);
    localReportDialog.setContentView(2131561082);
    ((TextView)localReportDialog.findViewById(2131365682)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365669);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365667);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365673);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690697);
    localTextView3.setText(2131691565);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new odi(this, localReportDialog));
    localTextView3.setOnClickListener(new odj(this, paramString));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public boolean d()
  {
    return (c()) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isShowFollowButton);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
      return bool;
      if (!this.jdField_g_of_type_Boolean) {
        break;
      }
      this.p = true;
      continue;
      if (!this.p) {
        break;
      }
      this.p = false;
    }
  }
  
  public void doOnBackPressed()
  {
    int i1;
    int i2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams != null)
    {
      i1 = 1;
      if (this.jdField_i_of_type_Boolean) {
        break label138;
      }
      i2 = 1;
      label18:
      if ((i1 == 0) || (!this.jdField_i_of_type_Boolean)) {
        break label143;
      }
      moveTaskToBack(true);
    }
    for (;;)
    {
      if (!c()) {
        c("0X8005B6E");
      }
      if (getIntent().getBooleanExtra("from_newer_guide", false))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("has_operation", c());
        localIntent.putExtra("uin", this.jdField_e_of_type_JavaLangString);
        setResult(-1, localIntent);
      }
      if ((this.jdField_a_of_type_Nzu != null) && (this.jdField_a_of_type_Nzu.a() != null)) {
        this.jdField_a_of_type_Nzu.a().b();
      }
      super.doOnBackPressed();
      return;
      i1 = 0;
      break;
      label138:
      i2 = 0;
      break label18;
      label143:
      if ((i1 != 0) && (i2 != 0) && (super.isTaskRoot())) {
        super.startActivity(new Intent(this, SplashActivity.class));
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new AccountDetailTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
    }
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    a(this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_e_of_type_JavaLangString != null)
    {
      if ((getClass().equals(AccountDetailActivity.class)) && ((nwu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString)) || (bjxa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString))))
      {
        nwu.a(this, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"), this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("need_finish", false), this.jdField_a_of_type_AndroidContentIntent.getIntExtra("source", -1), true, -1);
        finish();
        return true;
      }
      G();
    }
    c(this.jdField_a_of_type_AndroidContentIntent);
    super.addObserver(this.jdField_a_of_type_Aoav);
    this.n = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("from_js", false);
    if (this.n)
    {
      E();
      finish();
    }
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_a_of_type_Aoav);
    super.removeObserver(this.jdField_b_of_type_Apar);
    super.removeObserver(this.jdField_c_of_type_Apar);
    super.removeObserver(this.jdField_a_of_type_Odr);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    long l1 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
    String str2 = this.jdField_e_of_type_JavaLangString;
    String str3 = l1 + "";
    if (c()) {}
    for (String str1 = "02";; str1 = "01")
    {
      olh.a(null, str2, "0X8007800", "0X8007800", 0, 0, str3, "", str1, String.valueOf(olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), false);
      if ((this.jdField_a_of_type_Nzu != null) && (this.jdField_a_of_type_Nzu.a() != null)) {
        this.jdField_a_of_type_Nzu.a().b();
      }
      return;
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    a(this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_e_of_type_JavaLangString != null) {
      G();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_i_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bisl != null) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
    this.jdField_a_of_type_Bisl = null;
    if ((this.jdField_a_of_type_Nzu != null) && (this.jdField_a_of_type_Nzu.a() != null)) {
      this.jdField_a_of_type_Nzu.a().a();
    }
    AbstractGifImage.pauseAll();
  }
  
  public void e(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_e_of_type_JavaLangString, "0X8005A27", "0X8005A27", 0, 0, paramString, "", "", "", false);
      return;
    }
  }
  
  protected boolean e()
  {
    aoan localaoan = (aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localaoan != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = localaoan.a(this.jdField_e_of_type_JavaLangString);
      T();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "loadDatabase = null");
      }
      return false;
    }
    x();
    return true;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      a(this.jdField_e_of_type_JavaLangString, 1008, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, ChatActivity.class);
    }
  }
  
  void f(String paramString)
  {
    if ((this.r) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
      return;
    }
    this.r = true;
    ThreadManager.getSubThreadHandler().post(new AccountDetailActivity.28(this, paramString));
  }
  
  protected void g()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.13(this), 10L);
  }
  
  public void h()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.3(this), 10L);
  }
  
  public void i()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.6(this), 10L);
  }
  
  protected void j()
  {
    int i1 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateView");
    }
    this.t = uuc.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    if (this.t)
    {
      this.mActNeedImmersive = true;
      setImmersiveStatus();
      if (!this.mActNeedImmersive)
      {
        int i2 = getResources().getColor(2131167084);
        if (this.mSystemBarComp == null)
        {
          this.mSystemBarComp = new SystemBarCompact(this, true, i2);
          if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
            break label245;
          }
          this.mSystemBarComp.setStatusDrawable(getResources().getDrawable(2130846157));
        }
      }
      label108:
      this.jdField_l_of_type_Boolean = a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "isSubscriptAccount = " + this.jdField_l_of_type_Boolean);
      }
      if ((this.jdField_l_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))) {
        oaz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_e_of_type_JavaLangString), this.jdField_a_of_type_Aoav);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse == null) || (!this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.show_flag.has()) || (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.show_flag.get() != 2)) {
        break label256;
      }
    }
    for (;;)
    {
      t();
      if (i1 == 0) {
        break label261;
      }
      J();
      return;
      this.mActNeedImmersive = false;
      break;
      label245:
      this.mSystemBarComp.setStatusDrawable(null);
      break label108;
      label256:
      i1 = 0;
    }
    label261:
    K();
    k();
    l();
  }
  
  protected void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (this.jdField_l_of_type_Boolean)) {}
    label272:
    for (;;)
    {
      return;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isShowFollowButton;
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) {
        if ((this.jdField_e_of_type_JavaLangString.equals("1770946116")) || (nwu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString)))
        {
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          if (!b()) {
            break label253;
          }
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
          this.jdField_f_of_type_AndroidViewView.setVisibility(0);
          this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
        }
      }
      for (;;)
      {
        if ((this.jdField_b_of_type_AndroidWidgetButton.getVisibility() != 8) || (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8)) {
          break label272;
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        return;
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
        if (bool)
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        }
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
        label253:
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  protected void l()
  {
    if ((this.jdField_a_of_type_Nzu == null) || (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter() == null) || ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_Nzu.a() == null)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter() != null)
      {
        ((nzu)this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter()).a();
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(null);
      }
      this.jdField_a_of_type_Nzu = new nzu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail, this.jdField_e_of_type_JavaLangString, this.jdField_l_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
      this.jdField_a_of_type_Nzu.a(this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_d_of_type_AndroidWidgetButton);
      L();
      if (!this.jdField_l_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a(false);
      }
      this.jdField_a_of_type_Nzu.a(new odd(this));
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this.jdField_a_of_type_Nzu);
      return;
    }
    L();
    this.jdField_a_of_type_Nzu.notifyDataSetChanged();
  }
  
  protected void o()
  {
    bhfm.a(null, "pubAcc_follow_confirm", this.jdField_e_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "follow uin=" + this.jdField_e_of_type_JavaLangString);
    }
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidViewView.postDelayed(new AccountDetailActivity.7(this), 3000L);
    b(2131694959);
    if (uuc.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag) == -4)
    {
      this.jdField_d_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), oln.class);
      this.jdField_d_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
      mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
      localFollowRequest.ext.set("1");
      localFollowRequest.uin.set((int)Long.parseLong(this.jdField_e_of_type_JavaLangString));
      localFollowRequest.account_type.set(a());
      this.jdField_d_of_type_MqqAppNewIntent.putExtra("data", localFollowRequest.toByteArray());
      this.jdField_d_of_type_MqqAppNewIntent.putExtra("source", 1);
      this.jdField_b_of_type_MqqObserverBusinessObserver = new odn(this);
      this.jdField_d_of_type_MqqAppNewIntent.setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_d_of_type_MqqAppNewIntent);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int += 1;
      olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString, 1);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "follow exit");
      }
      return;
      this.s = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Apar);
      this.jdField_b_of_type_Apar = new apar(new odo(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_Apar);
      apaw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, 1);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 8)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      w();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str;
      Object localObject;
      if ((paramView == this.jdField_b_of_type_AndroidViewView) || ((this.jdField_a_of_type_Nzu != null) && (paramView == this.jdField_a_of_type_Nzu.jdField_a_of_type_AndroidWidgetButton) && (!c())) || ((paramView == this.jdField_d_of_type_AndroidWidgetButton) && (!c())))
      {
        c("0X8005B6D");
        this.jdField_j_of_type_Boolean = false;
        o();
        I();
        this.jdField_b_of_type_AndroidViewView.setEnabled(false);
        this.jdField_b_of_type_AndroidViewView.postDelayed(new AccountDetailActivity.24(this), 1000L);
        if (uot.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString)) {
          ((ook)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(134243868, this.jdField_e_of_type_JavaLangString, null, null, null, 1L, false);
        }
        olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_e_of_type_JavaLangString, "0X8005A25", "0X8005A25", this.jdField_g_of_type_Int, 0, "", "", "", "", false);
        usa.a().a(4, this.jdField_e_of_type_JavaLangString, 0, UniteSearchActivity.jdField_d_of_type_Int, bcmv.a().a(this.jdField_e_of_type_JavaLangString));
        QQAppInterface localQQAppInterface1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_e_of_type_JavaLangString;
        if (c())
        {
          localObject = "02";
          bdla.b(localQQAppInterface1, "dc01160", "Pb_account_lifeservice", str, "0X8007CA1", "0X8007CA1", 0, 0, (String)localObject, String.valueOf(this.jdField_g_of_type_Int), String.valueOf(olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), "");
          if (AppConstants.KANDIAN_DAILY_UIN.equals(this.jdField_e_of_type_JavaLangString)) {
            localObject = new JSONObject();
          }
        }
        try
        {
          ((JSONObject)localObject).put("channel_id", pin.b());
          olh.a(null, "", "0X8009946", "0X8009946", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
          nzg.a.d(this.jdField_e_of_type_JavaLangString);
          continue;
          localObject = "01";
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, localException.getMessage());
          }
        }
      }
      else
      {
        if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
        {
          int i2 = getIntent().getIntExtra("source", 0);
          int i1;
          if ((ahcf.a(this.jdField_e_of_type_JavaLangString)) && (amfb.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
          {
            i1 = 1;
            label430:
            if (i1 == 0)
            {
              if (!pkh.a(this.jdField_e_of_type_JavaLangString)) {
                break label531;
              }
              A();
            }
          }
          for (;;)
          {
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_e_of_type_JavaLangString, "0X8004E44", "0X8004E44", 0, 0, this.jdField_e_of_type_JavaLangString, "", "", "");
            olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_e_of_type_JavaLangString, "0X8005A26", "0X8005A26", 0, 0, "", "", "", "", false);
            nzg.a.h(this.jdField_e_of_type_JavaLangString);
            break;
            i1 = 0;
            break label430;
            label531:
            if (AppConstants.TIM_TEAM_UIN.equals(this.jdField_e_of_type_JavaLangString))
            {
              uuc.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            else if (i2 == 120)
            {
              doOnBackPressed();
            }
            else if (TextUtils.equals(AppConstants.KANDIAN_DAILY_UIN, this.jdField_e_of_type_JavaLangString))
            {
              KandianDailyManager.a(this, true, null, 5);
              if (AppConstants.KANDIAN_DAILY_UIN.equals(this.jdField_e_of_type_JavaLangString)) {
                olh.a(null, "", "0X8009945", "0X8009945", 0, 0, "", "", "", "", false);
              }
            }
            else if ((TextUtils.equals("2747277822", this.jdField_e_of_type_JavaLangString)) && (aveq.a()))
            {
              if ((getIntent() != null) && (getIntent().getBooleanExtra("fromQGamePub", false))) {
                doOnBackPressed();
              } else {
                B();
              }
            }
            else if (TextUtils.equals(ayoq.a, this.jdField_e_of_type_JavaLangString))
            {
              if (!ayos.a(this, this.jdField_e_of_type_JavaLangString, 2)) {
                f();
              }
            }
            else if (TextUtils.equals("3046055438", this.jdField_e_of_type_JavaLangString))
            {
              if (this.jdField_h_of_type_Int == 5) {
                doOnBackPressed();
              } else {
                oph.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
              }
            }
            else if (MiniGamePublicAccountHelper.shouldOpenWebFragment(this.jdField_e_of_type_JavaLangString))
            {
              if ((getIntent() != null) && (getIntent().getBooleanExtra("fromMiniGamePub", false))) {
                doOnBackPressed();
              } else {
                e();
              }
            }
            else if ((TextUtils.equals(AppConstants.QQ_VIP_UIN, this.jdField_e_of_type_JavaLangString)) && (bhsf.b(getApplicationContext())))
            {
              bhsf.b(getApplicationContext());
            }
            else if (bhxi.a(this.jdField_e_of_type_JavaLangString))
            {
              if (!bhxi.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), 162)) {
                f();
              }
            }
            else
            {
              f();
            }
          }
        }
        if (paramView == this.jdField_f_of_type_AndroidViewView)
        {
          nwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, a(), this.jdField_e_of_type_JavaLangString, "IvrEnterpriseDetailEngineFalse");
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004653", "0X8004653", 0, 0, "", "", "", "");
        }
        else if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
        {
          doOnBackPressed();
        }
        else
        {
          if ((paramView == this.jdField_a_of_type_AndroidWidgetImageView) || ((paramView != null) && (paramView.getId() == 2131369245)))
          {
            label980:
            QQAppInterface localQQAppInterface2;
            if (this.jdField_l_of_type_Boolean)
            {
              D();
              localQQAppInterface2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              str = this.jdField_e_of_type_JavaLangString;
              if (!c()) {
                break label1068;
              }
            }
            label1068:
            for (localObject = "02";; localObject = "01")
            {
              bdla.b(localQQAppInterface2, "dc01160", "Pb_account_lifeservice", str, "0X8007CA5", "0X8007CA5", 0, 0, (String)localObject, String.valueOf(olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), "", "");
              nzg.a.g(this.jdField_e_of_type_JavaLangString);
              break;
              C();
              break label980;
            }
          }
          if (paramView == this.jdField_c_of_type_AndroidWidgetButton)
          {
            H();
            nzg.a.e(this.jdField_e_of_type_JavaLangString);
          }
          else if ((paramView != null) && (paramView.getId() == 2131378301))
          {
            this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
            this.jdField_a_of_type_Odv.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
            nzg.a.f(this.jdField_e_of_type_JavaLangString);
          }
          else if ((paramView != null) && (paramView.getId() == 2131368229))
          {
            localObject = uuc.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
            if (localObject != null) {
              b(((oji)localObject).jdField_c_of_type_JavaLangString);
            }
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add("menu");
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_h_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bisl != null) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
    this.jdField_a_of_type_Bisl = null;
    if (this.jdField_a_of_type_Odr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Odr);
      this.jdField_a_of_type_Odr = null;
    }
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_e_of_type_MqqAppNewIntent != null) {
      this.jdField_e_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_d_of_type_MqqAppNewIntent != null) {
      this.jdField_d_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_a_of_type_Ods != null) {
      this.jdField_a_of_type_Ods.b();
    }
    if (this.jdField_a_of_type_Aatx != null) {
      this.jdField_a_of_type_Aatx.dismiss();
    }
    if (this.jdField_a_of_type_Nzu != null) {
      this.jdField_a_of_type_Nzu.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a();
    }
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
    if (isInMultiWindow())
    {
      QQToast.a(this, getString(2131694988), 0).a();
      finish();
      return;
    }
    if ((this.jdField_a_of_type_Nzu != null) && (this.jdField_a_of_type_Nzu.a() != null)) {
      this.jdField_a_of_type_Nzu.a().a(true);
    }
    AbstractGifImage.resumeAll();
    nzg.a.c(this.jdField_e_of_type_JavaLangString);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      bhfm.a("pubAcc_profile_display", null, this.jdField_e_of_type_JavaLangString);
      this.m = true;
      return;
    }
    this.m = false;
  }
  
  protected void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountData = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.toByteArray();
    }
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "share");
    }
    if ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)) {
      return;
    }
    Q();
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_10", "pbshare_click");
  }
  
  void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "initView");
    }
    super.setContentView(2131558401);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    View localView = super.findViewById(2131361886);
    if (this.t)
    {
      localView.setBackgroundColor(-657926);
      s();
      u();
      a();
      this.jdField_g_of_type_AndroidViewView = super.findViewById(2131374175);
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label161;
      }
      if (this.jdField_g_of_type_AndroidViewView != null) {
        this.jdField_g_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131366240));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131361890));
      this.jdField_a_of_type_Odv = new odv(this, this, this.jdField_a_of_type_AndroidViewViewGroup);
      return;
      localView.setBackgroundColor(-1);
      break;
      label161:
      if (this.jdField_g_of_type_AndroidViewView != null) {
        this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
  
  void s()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131370073));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
    int i2;
    if (f()) {
      i2 = (int)(64.0F * this.jdField_a_of_type_Float);
    }
    for (int i1 = (int)(4.0F * this.jdField_a_of_type_Float);; i1 = (int)(25.0F * this.jdField_a_of_type_Float))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i2);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, i1, 0, 0);
      this.jdField_e_of_type_Int = i2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.setTitleHeight(this.jdField_e_of_type_Int);
      }
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131370072));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369262));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369245));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843770);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697263));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368423));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368394));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364435));
      this.jdField_d_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131361891));
      this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
      t();
      return;
      i2 = (int)(75.0F * this.jdField_a_of_type_Float);
    }
  }
  
  void t()
  {
    if (this.t)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850116);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842506);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850725);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843770);
  }
  
  void u()
  {
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131361917);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_Int = this.jdField_d_of_type_AndroidViewView.getLayoutParams().height;
    this.jdField_e_of_type_AndroidViewView = super.findViewById(2131361874);
    this.jdField_f_of_type_AndroidViewView = super.findViewById(2131364216);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131367086);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131361875);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    super.setTitle(2131694951);
    this.jdField_a_of_type_Bisl = new bisl(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bisl.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131377179));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131377371));
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131693509);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131380457));
    this.jdField_c_of_type_AndroidWidgetButton.setText(2131693510);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131361876);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_Nzu.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this.jdField_a_of_type_Nzu);
    }
    this.jdField_a_of_type_Nzu.jdField_d_of_type_Boolean = false;
  }
  
  void w()
  {
    super.finish();
    aeou.a(this, "");
  }
  
  protected void x()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.mergeFrom(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountData);
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.newGroupInfoList = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.config_group_info_new.get();
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.unified_account_descrpition.has())
      {
        this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.unifiedDesrpition = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.unified_account_descrpition.get();
        this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.parser();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno = 0;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void y()
  {
    Object localObject;
    if (AppConstants.KANDIAN_DAILY_UIN.equals(this.jdField_e_of_type_JavaLangString)) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("channel_id", pin.b());
      olh.a(null, "", "0X8009944", "0X8009944", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
      bhfm.a(null, " pubAcc_follow_cancel", this.jdField_e_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unfollow");
      }
      b(2131695030);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (uuc.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag) == -4))
      {
        if (this.jdField_e_of_type_MqqAppNewIntent != null) {
          this.jdField_e_of_type_MqqAppNewIntent.setObserver(null);
        }
        this.jdField_e_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), oln.class);
        this.jdField_e_of_type_MqqAppNewIntent.putExtra("cmd", "unfollow");
        localObject = new mobileqq_mp.UnFollowRequest();
        ((mobileqq_mp.UnFollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_e_of_type_JavaLangString));
        ((mobileqq_mp.UnFollowRequest)localObject).account_type.set(a());
        this.jdField_e_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.UnFollowRequest)localObject).toByteArray());
        this.jdField_e_of_type_MqqAppNewIntent.putExtra("source", 1);
        this.jdField_c_of_type_MqqObserverBusinessObserver = new odl(this);
        this.jdField_e_of_type_MqqAppNewIntent.setObserver(this.jdField_c_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_e_of_type_MqqAppNewIntent);
        this.jdField_c_of_type_Int += 1;
        uuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString);
        if (uot.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString))
        {
          int i1 = uuc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_JavaLangString);
          alik.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_e_of_type_JavaLangString), i1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unfollow exit");
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, localException.getMessage());
        continue;
        if (this.jdField_c_of_type_Apar != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_c_of_type_Apar);
        }
        this.jdField_c_of_type_Apar = new apar(new odm(this));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_c_of_type_Apar);
        apaw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, 1);
        this.jdField_c_of_type_Int += 1;
      }
    }
  }
  
  public void z()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams != null) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        a(this);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity
 * JD-Core Version:    0.7.0.1
 */