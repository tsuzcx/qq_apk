package com.tencent.mobileqq.activity;

import Override;
import Wallet.PfaFriend;
import abgm;
import absz;
import adyh;
import adyi;
import adyj;
import adyk;
import adyl;
import adym;
import adyn;
import adyo;
import adyp;
import adyq;
import adyr;
import adys;
import adyt;
import adyu;
import adyv;
import adyw;
import adyx;
import adyy;
import adyz;
import adza;
import aewf;
import aksv;
import aktb;
import amhc;
import amhe;
import amhf;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anqj;
import anvi;
import anvx;
import aocn;
import aofu;
import aoxz;
import aroc;
import arod;
import aupp;
import aupt;
import auqk;
import ausc;
import bchy;
import bcnc;
import bdla;
import bdlf;
import bgyd;
import bhdj;
import bheb;
import bjgx;
import com.dataline.activities.LiteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.ResultRecord.DefaultComparator;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.forward.ForwardBaseActivity;
import com.tencent.mobileqq.forward.ForwardChooseFriendOption;
import com.tencent.mobileqq.forward.ForwardH5PTVOption;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.forward.ForwardStructingMsgOption;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCClient;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ForwardRecentActivity
  extends ForwardBaseActivity
  implements aktb, auqk
{
  public static int f;
  public static int g;
  public static int h;
  int jdField_a_of_type_Int;
  private aewf jdField_a_of_type_Aewf = new adym(this);
  private amhc jdField_a_of_type_Amhc;
  private amhf jdField_a_of_type_Amhf = new adyl(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  public Uri a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adyh(this);
  View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  public FrameLayout a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private anqj jdField_a_of_type_Anqj = new adyk(this);
  private anvi jdField_a_of_type_Anvi = new adyi(this);
  private aofu jdField_a_of_type_Aofu = new adyj(this);
  public aupt a;
  private bchy jdField_a_of_type_Bchy = new adyn(this);
  SelectedAndSearchBar jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar;
  private ForwardRecentItemView jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private ContactSearchFragment jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment;
  FormItemRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  public TipsBar a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  protected List<RecentUser> a;
  private Map<String, ResultRecord> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  public boolean a;
  public int b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new adyr(this);
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private ForwardRecentItemView jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView;
  FormItemRelativeLayout jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new adys(this);
  TextView jdField_c_of_type_AndroidWidgetTextView;
  FormItemRelativeLayout jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  public String c;
  public boolean c;
  int jdField_d_of_type_Int = -1;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  FormItemRelativeLayout jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  private String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  public int e;
  FormItemRelativeLayout e;
  public boolean e;
  boolean f;
  boolean g;
  boolean h;
  private int i;
  public boolean i;
  public boolean j = false;
  boolean k = false;
  private boolean l;
  private boolean m;
  
  static
  {
    jdField_f_of_type_Int = 1;
    jdField_g_of_type_Int = 2;
    jdField_h_of_type_Int = 3;
  }
  
  public ForwardRecentActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Aupt = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_e_of_type_Int = -1;
  }
  
  private int a()
  {
    if (this.jdField_e_of_type_Boolean) {
      return 2;
    }
    if (this.jdField_h_of_type_Boolean) {
      return 3;
    }
    return 1;
  }
  
  private String a()
  {
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("key_forward_business_id");
    }
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_d_of_type_JavaLangString = "other";
    }
    return this.jdField_d_of_type_JavaLangString;
  }
  
  private String a(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  private ArrayList<ResultRecord> a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "getResultRecord() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    ArrayList localArrayList = new ArrayList();
    ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    int i1 = localListAdapter.getCount();
    int n = 0;
    while (n < i1)
    {
      Object localObject = localListAdapter.getItem(n);
      if (!(localObject instanceof amhe))
      {
        n += 1;
      }
      else
      {
        localObject = (amhe)localObject;
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.uin = ((amhe)localObject).jdField_b_of_type_JavaLangString;
        if (((amhe)localObject).jdField_a_of_type_ComTencentMobileqqDataRecentUser != null) {
          localResultRecord.type = ((amhe)localObject).jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType();
        }
        if ((localResultRecord.type == 1) && (!TroopUtils.hasSetTroopHead(localResultRecord.uin))) {}
        for (boolean bool = true;; bool = false)
        {
          localResultRecord.isNewTroop = bool;
          localResultRecord.name = ((amhe)localObject).jdField_a_of_type_JavaLangString;
          localArrayList.add(localResultRecord);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private List<RecentUser> a(List<RecentUser> paramList)
  {
    return this.jdField_a_of_type_Aupt.a(paramList);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131376947));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376890));
    super.findViewById(2131369231).setVisibility(8);
    super.findViewById(2131369245).setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369278));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Aupt.b());
    e();
    u();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131376602));
    if (AppSetting.jdField_c_of_type_Boolean) {
      bgyd.b(this.jdField_a_of_type_AndroidWidgetTextView, Button.class.getName());
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131370188));
    if (AppSetting.jdField_c_of_type_Boolean) {
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_ComTencentWidgetXListView, 2);
    }
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562804, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363845).setVisibility(8);
    Object localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366280);
    ((EditText)localObject).setFocusable(false);
    ((EditText)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((EditText)localObject).setCursorVisible(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
    f();
    if (this.jdField_a_of_type_Aupt.a(aupp.f)) {
      i();
    }
    if (this.jdField_a_of_type_Aupt.a(aupp.j)) {
      j();
    }
    if ((this.jdField_a_of_type_Aupt.a(aupp.e)) && (!this.l))
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
      bdla.b(this.app, "CliOper", "", "", "friendchoose", "0X800A2D6", a(), 0, "", "", "", a());
      if (getSharedPreferences(this.app.getCurrentAccountUin(), 0).getBoolean("forward_share_card", true)) {
        this.jdField_b_of_type_AndroidViewView.findViewById(2131369131).setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar != null)
      {
        if (!this.k) {
          break label506;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
        localObject = arod.a();
        if ((localObject != null) && (!TextUtils.isEmpty(((aroc)localObject).e))) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText(((aroc)localObject).e);
        }
      }
    }
    for (;;)
    {
      if ((jdField_f_of_type_Int == this.jdField_e_of_type_Int) || (jdField_g_of_type_Int == this.jdField_e_of_type_Int)) {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new adyp(this));
      }
      return;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
      break;
      label506:
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
    }
  }
  
  private void a(int paramInt)
  {
    int n = 32;
    if (this.jdField_a_of_type_Aupt.a(aupp.b)) {
      n = 33;
    }
    paramInt = n;
    if (this.jdField_a_of_type_Aupt.a(aupp.h)) {
      paramInt = n | 0x100;
    }
    n = paramInt;
    if (this.jdField_a_of_type_Aupt.a(aupp.i)) {
      n = paramInt | 0x4;
    }
    paramInt = n;
    if (this.jdField_a_of_type_Aupt.a(aupp.d)) {
      paramInt = n | 0x8;
    }
    if (this.jdField_a_of_type_Aupt.a(aupp.c)) {
      paramInt = paramInt | 0x10 | 0x200000 | 0x400000;
    }
    for (;;)
    {
      long l1 = -1L;
      if ((this.jdField_a_of_type_Aupt instanceof ForwardStructingMsgOption)) {
        l1 = 1L;
      }
      ContactSearchComponentActivity.a(this, null, 7, paramInt, 561243, l1);
      bdla.b(this.app, "CliOper", "", "", "0X8004049", "0X8004049", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(Intent paramIntent)
  {
    boolean bool2 = false;
    String str = paramIntent.getStringExtra("caller_name");
    int n = paramIntent.getIntExtra("selection_mode", 0);
    if (n == 2)
    {
      this.jdField_i_of_type_Boolean = false;
      return;
    }
    if (n == 1)
    {
      this.jdField_i_of_type_Boolean = true;
      return;
    }
    if (("SplashActivity".equals(str)) || ("ChatActivity".equals(str)) || ("LiteActivity".equals(str)) || ("ChatHistoryActivity".equals(str))) {
      this.jdField_g_of_type_Boolean = true;
    }
    boolean bool1;
    if ((!paramIntent.getBooleanExtra("only_single_selection", false)) && (this.jdField_a_of_type_Aupt.b()))
    {
      bool1 = bool2;
      if (!this.jdField_g_of_type_Boolean)
      {
        bool1 = bool2;
        if (!this.jdField_h_of_type_Boolean)
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_Aupt.m()) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    this.jdField_i_of_type_Boolean = bool1;
  }
  
  public static void a(Intent paramIntent, Object paramObject)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramObject != null)) {
      if (!(paramObject instanceof Activity)) {
        break label173;
      }
    }
    label173:
    for (boolean bool = ((Activity)paramObject).isFinishing();; bool = false)
    {
      ResultReceiver localResultReceiver;
      if (!bool)
      {
        localResultReceiver = (ResultReceiver)paramIntent.getParcelableExtra("PARAM_ActivityResultReceiver");
        if (localResultReceiver == null) {}
      }
      try
      {
        Field localField = Activity.class.getDeclaredField("mResultCode");
        localField.setAccessible(true);
        n = ((Integer)localField.get(paramObject)).intValue();
        if (QLog.isDevelopLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 1, "notifyResultReceiver, resultReceiver[" + localResultReceiver + "]", new Throwable("打印调用栈"));
        }
        localResultReceiver.send(n, paramIntent.getExtras());
        return;
      }
      catch (NoSuchFieldException paramObject)
      {
        for (;;)
        {
          QLog.w("ForwardOption.ForwardEntranceActivity", 1, "finish, get mResultCode NoSuchFieldException", paramObject);
          n = 0;
        }
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          QLog.w("ForwardOption.ForwardEntranceActivity", 1, "finish, get mResultCode fail", paramObject);
          int n = 0;
        }
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = a(paramString, paramInt);
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      t();
      paramString = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(paramString, true);
      paramString = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        paramString.add(((ResultRecord)localIterator.next()).uin);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment == null);
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.a(paramString, paramString);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key_mini_report_event_action_type", paramString1);
    localBundle.putString("key_mini_report_event_sub_action_type", paramString2);
    localBundle.putString("key_mini_report_event_reserves", paramString3);
    localBundle.putString("key_mini_report_event_reserves2", paramString4);
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
  }
  
  private boolean a()
  {
    return this.jdField_i_of_type_Int == 1;
  }
  
  private boolean a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord == null) {
      return false;
    }
    Object localObject = a(paramResultRecord.uin, paramResultRecord.getUinType());
    ResultRecord localResultRecord = (ResultRecord)this.jdField_a_of_type_JavaUtilMap.get(localObject);
    if (localResultRecord != null)
    {
      localResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
      paramResultRecord = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(paramResultRecord, false);
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() == 9)
    {
      w();
      return false;
    }
    paramResultRecord = ResultRecord.copyResultRecord(paramResultRecord);
    paramResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_JavaUtilMap.put(localObject, paramResultRecord);
    t();
    paramResultRecord = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(paramResultRecord, true);
    paramResultRecord = new ArrayList();
    localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      paramResultRecord.add(((ResultRecord)((Iterator)localObject).next()).uin);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.a(paramResultRecord, paramResultRecord);
    }
    return true;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(a(paramString, paramInt));
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "registerListViewDataSetChangedObserver() called #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    if (this.jdField_a_of_type_AndroidDatabaseDataSetObserver == null) {
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new adyt(this);
    }
    ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    if (localListAdapter != null) {
      localListAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ForwardOption.ForwardEntranceActivity", 2, "registerListViewDataSetChangedObserver() adapter is null");
  }
  
  private void b(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      l();
      paramIntent.putExtra("param_bind_finish", true);
    }
  }
  
  private void b(View paramView)
  {
    paramView = (ForwardRecentItemView)paramView;
    ResultRecord localResultRecord = paramView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord;
    boolean bool = a(localResultRecord.uin, localResultRecord.getUinType());
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "onListViewItemClickedInMultiSelectStatus, isSelected = " + bool);
    }
    if (bool)
    {
      paramView.a(false);
      a(localResultRecord.uin, localResultRecord.getUinType());
    }
    while (!a(localResultRecord)) {
      return;
    }
    paramView.a(true);
  }
  
  private void c()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    localViewGroup.setAlpha(0.0F);
    localViewGroup.setBackgroundDrawable(null);
    getWindow().setBackgroundDrawable(null);
    localViewGroup.removeAllViews();
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView != null)
    {
      if (!paramBoolean) {
        break label45;
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView != null)
      {
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView);
      }
      return;
      label45:
      this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView);
  }
  
  private void d() {}
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369262));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369233));
    if (!this.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131704258));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131704264));
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.rightMargin = AIOUtils.dp2px(10.0F, getResources());
      if (Build.VERSION.SDK_INT <= 18) {
        localLayoutParams.width = AIOUtils.dp2px(75.0F, getResources());
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(7.0F, getResources()), 0, AIOUtils.dp2px(7.0F, getResources()), 0);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      }
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131704263));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131559213, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_b_of_type_AndroidViewView.setOverScrollMode(2);
    }
    if (this.jdField_a_of_type_Int != 9501) {
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370332));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131367197));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131367200));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131367204));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131367199));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131367201));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131378524));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(2);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(3);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(2);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBackgroundResource(2130839453);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBackgroundResource(2130839453);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBackgroundResource(2130839453);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBackgroundResource(2130839453);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBackgroundResource(2130839453);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setBackgroundResource(2130839453);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setCloseListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    View localView = LayoutInflater.from(this).inflate(2131558981, null);
    localView.setFocusable(true);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379886));
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131692558);
      if (!this.jdField_i_of_type_Boolean) {
        break label450;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131692557);
      break;
      label450:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidDatabaseDataSetObserver == null) {}
    ListAdapter localListAdapter;
    do
    {
      return;
      localListAdapter = this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    } while (localListAdapter == null);
    localListAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
  }
  
  private void h()
  {
    if ((!this.jdField_a_of_type_Aupt.a(aupp.b)) && (!this.jdField_a_of_type_Aupt.a(aupp.c)) && (!this.jdField_a_of_type_Aupt.a(aupp.d)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends, troop and discuss forward, remove mEntryHeader");
      }
      if ((!(this.jdField_a_of_type_Aupt instanceof ForwardChooseFriendOption)) || (this.jdField_a_of_type_Aupt.a(aupp.l))) {
        this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(this.jdField_b_of_type_AndroidViewView);
      }
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Aupt.a(aupp.b))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends forward, set friendBtn gone");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
      }
      if (!this.jdField_a_of_type_Aupt.a(aupp.h))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support phone contacts forward, set contactBtn gone");
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131369131).setVisibility(8);
      }
      if ((!this.jdField_a_of_type_Aupt.a(aupp.c)) || (this.jdField_a_of_type_Aupt.a(aupp.l)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support discuss forward, set multiChatBtn gone");
        }
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
      }
      if ((!this.jdField_a_of_type_Aupt.a(aupp.c)) && (!this.jdField_a_of_type_Aupt.a(aupp.d)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support troop and discuss forward, set troopDiscussionBtn gone");
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
      }
      if ((this.jdField_a_of_type_Aupt instanceof ForwardH5PTVOption))
      {
        if ((!this.jdField_a_of_type_Aupt.a(aupp.b)) && (!this.jdField_a_of_type_Aupt.a(aupp.c)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends and troop forward, set friendBtn gone");
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
        }
        if (!this.jdField_a_of_type_Aupt.a(aupp.b))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends");
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
        }
      }
    } while ((!(this.jdField_a_of_type_Aupt instanceof ForwardChooseFriendOption)) || (this.jdField_a_of_type_Aupt.a(aupp.l)));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView = new ForwardRecentItemView(this);
    ResultRecord localResultRecord1 = new ResultRecord(AppConstants.DATALINE_PC_UIN, anvx.a(2131694211), 6000, "", "");
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a(anvx.a(2131694211), "", getResources().getDrawable(2130844186), localResultRecord1, false, false);
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.setOnClickListener(new adyu(this, localResultRecord1));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView);
    if (((aocn)this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).c() != 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView = new ForwardRecentItemView(this);
      ResultRecord localResultRecord2 = new ResultRecord(AppConstants.DATALINE_IPAD_UIN, "我的iPad", 6003, "", "");
      this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a("我的iPad", "", getResources().getDrawable(2130844184), localResultRecord2, false, false);
      this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView.setOnClickListener(new adyv(this, localResultRecord1));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView);
    }
  }
  
  private void j()
  {
    abgm localabgm = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo[] arrayOfDeviceInfo;
    if (localabgm.a())
    {
      arrayOfDeviceInfo = localabgm.a();
      if ((arrayOfDeviceInfo != null) && (arrayOfDeviceInfo.length > 0)) {
        break label39;
      }
    }
    label39:
    do
    {
      return;
      arrayOfDeviceInfo = this.jdField_a_of_type_Aupt.a(arrayOfDeviceInfo);
    } while (arrayOfDeviceInfo == null);
    int i1 = arrayOfDeviceInfo.length;
    int n = 0;
    label61:
    DeviceInfo localDeviceInfo;
    if (n < i1)
    {
      localDeviceInfo = arrayOfDeviceInfo[n];
      if (localDeviceInfo.isAdmin != 2) {
        break label88;
      }
    }
    for (;;)
    {
      n += 1;
      break label61;
      break;
      label88:
      if ((!localabgm.c(localDeviceInfo.din)) || (localabgm.a(localDeviceInfo.din, 17)))
      {
        ForwardRecentItemView localForwardRecentItemView = new ForwardRecentItemView(this);
        String str = absz.a(localDeviceInfo);
        ResultRecord localResultRecord = new ResultRecord(String.valueOf(localDeviceInfo.din), str, 9501, "", "");
        localForwardRecentItemView.a(str, "", new BitmapDrawable(DeviceHeadMgr.getInstance().getDeviceHeadByDin(String.valueOf(localDeviceInfo.din))), localResultRecord, false, false);
        localForwardRecentItemView.setOnClickListener(new adyw(this, localDeviceInfo, localForwardRecentItemView, localResultRecord, super.getResources(), str));
        this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localForwardRecentItemView);
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new adyx(this);
      IntentFilter localIntentFilter = new IntentFilter("ShareToQZoneAndFinishTheLastActivity");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void l()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new adyy(this);
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, new IntentFilter("ForwardEntranceActivity"));
    }
  }
  
  private void m()
  {
    int i1 = 0;
    Object localObject;
    if (this.app.isAccLoginSuccess())
    {
      this.jdField_a_of_type_JavaUtilList = a(this.app.getProxyManager().a().getRecentList(true));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("refreshRecentList 01 forwardList size is: ");
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label383;
        }
      }
      label383:
      for (n = 0;; n = this.jdField_a_of_type_JavaUtilList.size())
      {
        QLog.i("ForwardOption.ForwardEntranceActivity", 2, n);
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label407;
        }
        localObject = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          RecentUser localRecentUser = (RecentUser)localIterator.next();
          if ((localRecentUser.lFlag == 16L) || (localRecentUser.getType() == 10005)) {
            ((List)localObject).add(localRecentUser);
          }
          if (localRecentUser.getType() == 1038) {
            ((List)localObject).add(localRecentUser);
          }
          if ((this.jdField_d_of_type_Boolean) && (TextUtils.equals(localRecentUser.uin, this.app.getCurrentAccountUin()))) {
            ((List)localObject).add(localRecentUser);
          }
          if ((TextUtils.equals(AppConstants.CONVERSATION_MAY_KNOW_FRIEND_UIN, localRecentUser.uin)) || (localRecentUser.getType() == 8111) || (localRecentUser.getType() == 8112) || (localRecentUser.getType() == 8113)) {
            ((List)localObject).add(localRecentUser);
          }
          if (localRecentUser.getType() == 1)
          {
            TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).a(localRecentUser.uin, true);
            if ((localTroopInfo != null) && ((localTroopInfo.isKicked()) || (localTroopInfo.isDisband())))
            {
              if (QLog.isColorLevel()) {
                QLog.i("ForwardOption.ForwardEntranceActivity", 2, "refreshRecentList, filter troop, recentUser.troopUin =" + localRecentUser.troopUin + ",recentUser.uin = " + localRecentUser.uin);
              }
              ((List)localObject).add(localRecentUser);
            }
          }
        }
      }
      this.jdField_a_of_type_JavaUtilList.removeAll((Collection)localObject);
      label407:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("refreshRecentList forwardList size is: ");
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label504;
        }
      }
    }
    label504:
    for (int n = i1;; n = this.jdField_a_of_type_JavaUtilList.size())
    {
      QLog.i("ForwardOption.ForwardEntranceActivity", 2, n);
      if (this.jdField_a_of_type_Amhc != null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
      {
        this.jdField_a_of_type_Amhc = new amhc(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Amhf);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Amhc);
      }
      return;
    }
    this.jdField_a_of_type_Amhc.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void n()
  {
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      return;
    case 10: 
      a("user_click", "more_about", "share", "fail");
      return;
    case 11: 
      a("user_click", "custom_button", "share_QQ", "fail");
      return;
    }
    a("user_click", "more_button", "share_QQ", "fail");
  }
  
  private void o()
  {
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
    Object localObject1 = new Bundle(this.jdField_a_of_type_Aupt.a());
    ((Bundle)localObject1).putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Bundle)localObject1).putBoolean("PhotoConst.IS_FORWARD", true);
    ((Bundle)localObject1).putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    ((Bundle)localObject1).putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    localIntent.putExtra("isBack2Root", false);
    localIntent.putExtras((Bundle)localObject1);
    Object localObject2 = ((Bundle)localObject1).getString("GALLERY.FORWORD_LOCAL_PATH");
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(localObject2);
    localObject2 = (abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    try
    {
      bool = ((abgm)localObject2).a(Long.parseLong(localIntent.getStringExtra("uin")), 17);
      if (bool)
      {
        localIntent.putExtra("send_in_background", true);
        localIntent.putExtra("sIsCloudPrinter", true);
        PhotoUtils.sendPhoto(this, localIntent, (ArrayList)localObject1, 0, true);
        if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) != 0) {
          QQToast.a(this.app.getApp(), 2, 2131692551, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299080));
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool = false;
        continue;
        PhotoUtils.sendPhoto(this, localIntent, (ArrayList)localObject1, 0, false);
      }
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardEntranceActivity", 2, "forward2MultiTargets no forward target !");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    Collections.sort(localArrayList, new ResultRecord.DefaultComparator());
    Bundle localBundle = new Bundle();
    localBundle.putInt("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.QQCUSTOM_DIALOG_FROM_RECOMMEND.intValue());
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    localBundle.putBoolean("from_outside_share", this.jdField_e_of_type_Boolean);
    localBundle.putBoolean("from_dataline_aio", this.jdField_f_of_type_Boolean);
    this.jdField_a_of_type_Aupt.a(aupp.a.intValue(), localBundle);
    this.jdField_a_of_type_Aupt.f();
  }
  
  private void q()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  private void r()
  {
    this.jdField_i_of_type_Int = 1;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131704264));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131704261));
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.dp2px(29.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130845177);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167043));
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(3);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBackgroundResource(2130839453);
    localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).topMargin = AIOUtils.dp2px(8.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new ForwardRecentActivity.15(this), 50L);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.app);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(null, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, this.jdField_a_of_type_Aewf);
    }
    localObject = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a((List)localObject, true);
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      c(false);
      ForwardUtils.report(this.app, "0X800A733", new String[0]);
    }
  }
  
  private void s()
  {
    this.jdField_i_of_type_Int = 0;
    v();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131704264));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131704262));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167023));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850733);
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.dp2px(36.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
    if ((this.jdField_a_of_type_Aupt.a(aupp.e)) && (!this.l)) {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).topMargin = AIOUtils.dp2px(0.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      q();
      this.jdField_a_of_type_Aupt.a("forward_multi_target");
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new ForwardRecentActivity.16(this), 1L);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText());
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      if (this.jdField_a_of_type_Boolean) {
        c(true);
      }
      return;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(2147483647);
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131704260));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167043));
    }
    for (;;)
    {
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(anvx.a(2131704250), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilMap.size()) }));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167042));
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar = ((SelectedAndSearchBar)super.findViewById(2131377323));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.b(0L);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(new adyo(this));
  }
  
  private void v()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.b();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, getString(2131698565), 0, 2131694482, null, new adyq(this));
    }
    if (!isFinishing()) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    Object localObject = getIntent();
    if (localObject != null) {}
    for (localObject = ((Intent)localObject).getExtras();; localObject = null)
    {
      if (localObject != null) {}
      for (localObject = new Bundle((Bundle)localObject);; localObject = new Bundle())
      {
        ((Bundle)localObject).putInt("uintype", 0);
        ((Bundle)localObject).putString("uin", paramLong + "");
        if (paramString != null) {
          ((Bundle)localObject).putString("uinname", paramString);
        }
        this.jdField_a_of_type_Aupt.a(aupp.a.intValue(), (Bundle)localObject);
        this.jdField_a_of_type_Aupt.f();
        return;
      }
    }
  }
  
  public void a(View paramView)
  {
    a("0X8007827");
    paramView = (ForwardRecentItemView)paramView;
    ResultRecord localResultRecord = paramView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberResultRecord;
    if ((this.jdField_a_of_type_Boolean) && (localResultRecord != null)) {}
    Bundle localBundle;
    switch (localResultRecord.getUinType())
    {
    default: 
      if (localResultRecord != null)
      {
        localBundle = new Bundle();
        localBundle.putInt("uintype", localResultRecord.getUinType());
        localBundle.putString("uin", localResultRecord.uin);
        localBundle.putString("troop_uin", localResultRecord.groupUin);
        if (localResultRecord.getUinType() != 3000) {
          break label488;
        }
        localBundle.putString("uinname", ForwardUtils.handleFordwardDiscName(this.app, paramView.jdField_a_of_type_JavaLangString, localResultRecord.uin));
      }
      break;
    }
    for (;;)
    {
      localBundle.putBoolean("forward_report_confirm", true);
      localBundle.putString("forward_report_confirm_action_name", "0X8005A13");
      localBundle.putString("forward_report_confirm_reverse2", "5");
      localBundle.putInt("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.QQCUSTOM_DIALOG_FROM_RECOMMEND.intValue());
      localBundle.putString("caller_name", this.jdField_c_of_type_JavaLangString);
      if ((getIntent() != null) && (getIntent().getExtras() != null))
      {
        localBundle.putBoolean("needShareCallBack", getIntent().getExtras().getBoolean("needShareCallBack"));
        localBundle.putInt("miniAppShareFrom", getIntent().getExtras().getInt("miniAppShareFrom"));
      }
      this.jdField_a_of_type_Aupt.a(aupp.a.intValue(), localBundle);
      this.jdField_a_of_type_Aupt.f();
      if ((localResultRecord.getUinType() == 3000) || (localResultRecord.getUinType() == 1)) {
        new bdlf(this.app).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "0" }).a();
      }
      bdla.b(this.app, "CliOper", "", "", "friendchoose", "0X8009D90", a(), 0, "", "", "", a());
      return;
      bjgx.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "30", "0", false, this.jdField_a_of_type_Boolean);
      break;
      bjgx.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "31", "0", false, this.jdField_a_of_type_Boolean);
      break;
      bjgx.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "32", "0", false, this.jdField_a_of_type_Boolean);
      break;
      label488:
      localBundle.putString("uinname", paramView.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString)
  {
    if (getIntent().getBooleanExtra("forward_source_from_shoot_quick", false)) {
      bdla.b(this.app, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (isFinishing()) {}
    do
    {
      return;
      localObject1 = aksv.a(this, paramBoolean, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    } while (localObject1 == null);
    Object localObject2 = ((HashMap)localObject1).get(aksv.jdField_b_of_type_JavaLangString);
    if (localObject2 != null)
    {
      localObject2 = (ArrayList)localObject2;
      this.jdField_a_of_type_Aupt.a().putStringArrayList("choose_friend_feedbacks", (ArrayList)localObject2);
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = ((HashMap)localObject1).get(aksv.jdField_a_of_type_JavaLangString);
    if (localObject1 != null) {}
    for (localObject1 = (ArrayList)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        int n = 0;
        if (n < ((ArrayList)localObject1).size())
        {
          localObject2 = (PfaFriend)((ArrayList)localObject1).get(n);
          if ((localObject2 == null) || (TextUtils.isEmpty(((PfaFriend)localObject2).uin))) {}
          for (;;)
          {
            n += 1;
            break;
            if ((!this.jdField_d_of_type_Boolean) || (this.app == null) || (!TextUtils.equals(((PfaFriend)localObject2).uin, this.app.getCurrentAccountUin())))
            {
              localObject2 = new RecentUser(((PfaFriend)localObject2).uin, 0);
              this.jdField_a_of_type_JavaUtilList.add(localObject2);
              Collections.sort(this.jdField_a_of_type_JavaUtilList, new adyz(this));
            }
          }
        }
      }
      if (this.jdField_a_of_type_Amhc == null)
      {
        this.jdField_a_of_type_Amhc = new amhc(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Amhf);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Amhc);
        return;
      }
      this.jdField_a_of_type_Amhc.a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
  }
  
  protected boolean a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Aupt = ausc.a(getIntent(), this.app, this);
    if (this.jdField_a_of_type_Aupt != null)
    {
      this.jdField_a_of_type_Aupt.a();
      if (isFinishing())
      {
        QLog.d("ForwardOption.ForwardEntranceActivity", 1, "-->doOnCreate_init--isFinishing");
        return false;
      }
    }
    else
    {
      QLog.d("ForwardOption.ForwardEntranceActivity", 1, "-->doOnCreate_init--mForwardOption == null");
      finish();
      return false;
    }
    this.jdField_a_of_type_Aupt.C();
    paramBundle = getIntent();
    this.l = paramBundle.getBooleanExtra("forward_ability_entrence_show_in_share", false);
    this.jdField_h_of_type_Boolean = paramBundle.getBooleanExtra("isWebCompShare", false);
    this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("choose_friend_isForConfess", false);
    this.j = paramBundle.getBooleanExtra("needShareCallBack", false);
    this.jdField_d_of_type_Int = paramBundle.getIntExtra("miniAppShareFrom", -1);
    this.k = paramBundle.getBooleanExtra("k_forward_show_direct_share_tips", false);
    this.m = paramBundle.getBooleanExtra("key_direct_jump_qzone_shuoshuo", false);
    Object localObject;
    if (this.m)
    {
      localObject = paramBundle.getStringExtra("key_forward_business_id");
      boolean bool = paramBundle.hasExtra("file_send_path");
      adza.a(this.app, this, paramBundle, (String)localObject, bool);
      QLog.d("ForwardOption.ForwardEntranceActivity", 1, "-->doOnCreate_init--mJumpQzoneShuoshuoDirect==true");
      return true;
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Int = paramBundle.getIntExtra("forward_source_uin_type", 0);
        this.jdField_a_of_type_AndroidNetUri = paramBundle.getData();
        if (paramBundle.getIntExtra("forward_type", -1) == 11) {
          this.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("pkg_name");
        long l1 = paramBundle.getLongExtra("req_share_id", 0L);
        this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("caller_name");
        this.jdField_e_of_type_Boolean = getIntent().getBooleanExtra("isFromShare", false);
        this.jdField_f_of_type_Boolean = getIntent().getBooleanExtra("isFromDataLineAIO", false);
        if (l1 > 0L) {
          this.jdField_b_of_type_JavaLangString = String.valueOf(l1);
        }
        if ((!this.jdField_e_of_type_Boolean) && ((l1 > 0L) || (this.jdField_a_of_type_Boolean) || ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals("com.tencent.mobileqq"))))) {
          this.jdField_e_of_type_Boolean = true;
        }
        QLog.d("ForwardOption.ForwardEntranceActivity", 1, new Object[] { "-->doOnCreate_init--isSdkShare=", Boolean.valueOf(this.jdField_a_of_type_Boolean), ", pkgName=", this.jdField_a_of_type_JavaLangString, ", appid=", this.jdField_b_of_type_JavaLangString, ", isFromWeb=" + this.jdField_h_of_type_Boolean + ", isFromShare=" + this.jdField_e_of_type_Boolean + ", isFromDatalineAIO=" + this.jdField_f_of_type_Boolean });
        a(paramBundle);
        this.jdField_b_of_type_Int = paramBundle.getIntExtra("choose_friend_businessType", 0);
        this.jdField_c_of_type_Int = paramBundle.getIntExtra("choose_friend_businessSubType", 0);
        if ((this.jdField_b_of_type_Int == 1) && (this.jdField_c_of_type_Int > 0) && (this.jdField_c_of_type_Int < 3)) {
          this.jdField_c_of_type_Boolean = true;
        }
        d();
        a();
        if (this.app.getCurrentAccountUin() == null) {
          finish();
        }
        if (!this.jdField_c_of_type_Boolean) {
          continue;
        }
        a(true);
        this.jdField_a_of_type_Aupt.c();
        h();
        l1 = paramBundle.getLongExtra("forward_send_to_uin", 0L);
        if (l1 != 0L) {
          a(l1, paramBundle.getStringExtra("forward_send_to_uin_nickname"));
        }
        if ((jdField_f_of_type_Int == this.jdField_e_of_type_Int) || (jdField_g_of_type_Int == this.jdField_e_of_type_Int)) {
          b();
        }
        if (jdField_h_of_type_Int == this.jdField_e_of_type_Int) {
          this.jdField_a_of_type_Aupt.q();
        }
      }
      catch (Exception localException)
      {
        QLog.d("ForwardOption.ForwardEntranceActivity", 1, "exception in ForwardRecentActivity", localException);
        finish();
        continue;
        if ((this.jdField_b_of_type_Int != 1) || (this.jdField_c_of_type_Int != 2)) {
          continue;
        }
        bdla.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.payerselectpage.show", 0, 0, "", "", "", "");
        continue;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("StructingMsgItemBuildertime", 4, "zhuanfa end:" + System.currentTimeMillis());
      }
      if (this.jdField_c_of_type_Boolean)
      {
        if ((this.jdField_b_of_type_Int != 1) || (this.jdField_c_of_type_Int != 1)) {
          continue;
        }
        bdla.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerselectpage.show", 0, 0, "", "", "", "");
      }
      if (paramBundle.getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
        bdla.b(this.app, "dc00898", "", "", "0X8009F7A", "0X8009F7A", 0, 0, "", "", "", "");
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        localObject = new Intent();
        ((Intent)localObject).putExtra("call_by_forward", true);
        if (this.jdField_a_of_type_AndroidNetUri != null) {
          ((Intent)localObject).setData(this.jdField_a_of_type_AndroidNetUri);
        }
        ((Intent)localObject).putExtras(this.jdField_a_of_type_Aupt.a());
        ((Intent)localObject).putExtras(paramBundle.getExtras());
        ((Intent)localObject).putExtra("isForConfessDirectFriendsTitle", this.jdField_a_of_type_Aupt.b());
        ((Intent)localObject).setClass(this, ForwardFriendListActivity.class);
        ((Intent)localObject).putExtra("extra_choose_friend", 5);
        startActivityForResult((Intent)localObject, 20000);
      }
      correctStatusBarHeight();
      bdla.b(this.app, "CliOper", "", "", "friendchoose", "0X8009D8E", a(), 0, "", "", "", "");
      return true;
      m();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    a(false);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      Object localObject1;
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
                if (getIntent().getExtras().getBoolean("jump_to_mobileqq_share", false)) {
                  setResult(10, paramIntent);
                }
                for (;;)
                {
                  finish();
                  overridePendingTransition(0, 0);
                  return;
                  setResult(-1, paramIntent);
                }
                setResult(-1, paramIntent);
                finish();
                return;
                if (paramIntent.getBooleanExtra("select_memeber_single_friend", false))
                {
                  localObject1 = paramIntent.getExtras();
                  paramInt2 = paramIntent.getIntExtra("select_memeber_single_friend_type", 2);
                  paramInt1 = paramInt2;
                  if (paramInt2 == 4) {
                    paramInt1 = 1;
                  }
                  paramInt2 = paramInt1;
                  if (paramInt1 == 0) {
                    paramInt2 = 2;
                  }
                  ((Bundle)localObject1).putBoolean("forward_report_confirm", true);
                  ((Bundle)localObject1).putString("forward_report_confirm_action_name", "0X8005A14");
                  ((Bundle)localObject1).putString("forward_report_confirm_reverse2", Integer.toString(paramInt2));
                  this.jdField_a_of_type_Aupt.a(aupp.b.intValue(), (Bundle)localObject1);
                  bjgx.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "30", "0", false, this.jdField_a_of_type_Boolean);
                  return;
                }
                localObject1 = paramIntent.getStringExtra("roomId");
                Object localObject2;
                if (!StringUtil.isEmpty((String)localObject1))
                {
                  m();
                  bdla.b(this.app, "CliOper", "", "", "0X80056B0", "0X80056B0", 0, 0, "", "", "", "");
                  paramInt1 = paramIntent.getIntExtra("select_memeber_discussion_memeber_count", 0);
                  localObject2 = new Bundle();
                  ((Bundle)localObject2).putBoolean("forward_report_confirm", true);
                  ((Bundle)localObject2).putString("forward_report_confirm_action_name", "0X8005A15");
                  ((Bundle)localObject2).putString("forward_report_confirm_reverse2", Integer.toString(paramInt1));
                  this.jdField_a_of_type_Aupt.a((String)localObject1, paramIntent.getStringExtra("discussName"), (Bundle)localObject2);
                }
                bjgx.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "32", "0", false, this.jdField_a_of_type_Boolean);
                return;
                this.jdField_a_of_type_Aupt.a(paramInt1, paramInt2, paramIntent);
                return;
                paramIntent.putExtra("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.QQCUSTOM_DIALOG_FROM_NOT_RECOMMEND);
                if (getIntent() != null) {}
                for (boolean bool = getIntent().getBooleanExtra("choose_friend_needConfirm", false);; bool = false)
                {
                  if (bool)
                  {
                    localObject1 = getIntent().getStringExtra("choose_friend_confirmTitle");
                    localObject2 = getIntent().getStringExtra("choose_friend_confirmContent");
                    paramIntent.putExtra("choose_friend_needConfirm", bool);
                    paramIntent.putExtra("choose_friend_confirmTitle", (String)localObject1);
                    paramIntent.putExtra("choose_friend_confirmContent", (String)localObject2);
                  }
                  bcnc.a(paramIntent, this.jdField_a_of_type_Aupt);
                  return;
                }
                this.jdField_a_of_type_Aupt.a(paramInt1, paramInt2, paramIntent);
                return;
              } while (paramIntent == null);
              paramIntent = paramIntent.getStringExtra("new_video_extra_info");
              ((ForwardSdkShareOption)this.jdField_a_of_type_Aupt).e(paramIntent);
              finish();
              overridePendingTransition(0, 0);
              return;
              this.jdField_a_of_type_Aupt.a(paramInt1, paramInt2, paramIntent);
              return;
              setResult(-1, paramIntent);
              finish();
            } while (this.m);
            adza.a();
            return;
            if (paramInt2 != 1) {
              break;
            }
          } while (20000 != paramInt1);
          finish();
          return;
          if ((20000 != paramInt1) || (paramInt2 == -1)) {
            break;
          }
          if (this.jdField_b_of_type_Boolean)
          {
            finish();
            return;
          }
        } while (paramInt2 != 0);
        localObject1 = null;
        if (paramIntent != null) {
          localObject1 = paramIntent.getParcelableArrayListExtra("selected_target_list");
        }
      } while (localObject1 == null);
      this.jdField_a_of_type_JavaUtilMap.clear();
      if (((List)localObject1).isEmpty())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a((List)localObject1, false);
        this.jdField_a_of_type_Amhc.notifyDataSetChanged();
        t();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView != null) {
          this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a(a(AppConstants.DATALINE_PC_UIN, 6000));
        }
        if (this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView == null) {
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a(a(AppConstants.DATALINE_IPAD_UIN, 6003));
        return;
        Collections.sort((List)localObject1, new ResultRecord.DefaultComparator());
        paramIntent = ((List)localObject1).iterator();
        while (paramIntent.hasNext()) {
          a((ResultRecord)paramIntent.next());
        }
        this.jdField_a_of_type_Amhc.notifyDataSetChanged();
      }
    } while ((paramInt2 != 0) || (!this.m) || (paramInt1 != 20005));
    finish();
  }
  
  public void doOnBackPressed()
  {
    if (!isFinishing())
    {
      this.jdField_a_of_type_Aupt.a(false);
      com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = false;
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if ((jdField_f_of_type_Int != this.jdField_e_of_type_Int) && (jdField_g_of_type_Int != this.jdField_e_of_type_Int)) {
      setTheme(2131755153);
    }
    super.doOnCreate(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_Anvi);
    this.app.addObserver(this.jdField_a_of_type_Aofu);
    this.app.addObserver(this.jdField_a_of_type_Anqj);
    setContentViewNoTitle(2131559216);
    return a(paramBundle);
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Anvi);
    this.app.removeObserver(this.jdField_a_of_type_Aofu);
    this.app.removeObserver(this.jdField_a_of_type_Anqj);
    if (this.jdField_c_of_type_Boolean) {
      aksv.a(this.app);
    }
    g();
    if (this.jdField_a_of_type_Amhc != null)
    {
      this.jdField_a_of_type_Amhc.c();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Aupt != null) {
      this.jdField_a_of_type_Aupt.y();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    int n = 1;
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "ForwardOption.ForwardEntranceActivity onNewIntent()");
    }
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (!paramIntent.isEmpty())) {
        break label53;
      }
    }
    label53:
    int i1;
    label272:
    label288:
    for (;;)
    {
      return;
      paramIntent = (String)paramIntent.get(0);
      Bundle localBundle = this.jdField_a_of_type_Aupt.a();
      i1 = localBundle.getInt("key_forward_ability_type", 0);
      String str1 = localBundle.getString("uin");
      int i2 = localBundle.getInt("uintype", -1);
      String str2 = localBundle.getString("troop_uin");
      localBundle.getString("uinname");
      boolean bool = localBundle.getBoolean("FORWARD_IS_QZONE_SHARE");
      localBundle.putBoolean("FORWARD_IS_EDITED", true);
      if (!bool) {
        break;
      }
      if ((i1 == aupp.f.intValue()) || (i1 == aupp.k.intValue()))
      {
        LiteActivity.a(this.app, paramIntent, this);
        bool = true;
        n = 0;
        if (!bool) {
          break label272;
        }
        setResult(-1);
      }
      for (;;)
      {
        if (n != 0) {
          break label288;
        }
        finish();
        return;
        if (i1 == aupp.g.intValue())
        {
          this.jdField_a_of_type_Aupt.a().putString("forward_filepath", paramIntent);
          this.jdField_a_of_type_Aupt.a().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
          this.jdField_a_of_type_Aupt.w();
          bool = true;
          break;
        }
        bool = bheb.a(this.app, paramIntent, str1, i2, str2, true, this);
        n = 0;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardEntranceActivity", 2, "failed to send pic from qzone");
        }
      }
    }
    if ((i1 == aupp.f.intValue()) || (i1 == aupp.k.intValue()))
    {
      this.jdField_a_of_type_Aupt.a().putString("forward_extra", paramIntent);
      this.jdField_a_of_type_Aupt.b(i1);
      return;
    }
    if (i1 == aupp.g.intValue())
    {
      this.jdField_a_of_type_Aupt.a().putString("forward_filepath", paramIntent);
      this.jdField_a_of_type_Aupt.a().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
      this.jdField_a_of_type_Aupt.w();
      return;
    }
    this.jdField_a_of_type_Aupt.a().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
    o();
    bdla.b(this.app, "CliOper", "", "", "0X800514C", "0X800514C", 0, 0, "", "", "", "");
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Aupt != null) {
      this.jdField_a_of_type_Aupt.k();
    }
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    if (this.jdField_a_of_type_Aupt != null) {
      this.jdField_a_of_type_Aupt.b(paramBundle);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(new ForwardRecentActivity.1(this), 1000L);
    }
    if (BaseApplicationImpl.appStartTime > 0L) {
      Log.d("AutoMonitor", "actStartSel, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime));
    }
    if (this.jdField_a_of_type_Aupt != null) {
      this.jdField_a_of_type_Aupt.l();
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if (this.jdField_a_of_type_Aupt != null) {
      this.jdField_a_of_type_Aupt.a(paramBundle);
    }
  }
  
  public void finish()
  {
    a(getIntent(), this);
    super.finish();
    overridePendingTransition(0, 2130771978);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 20002) {
      finish();
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 8)
    {
      v();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a()) {
      v();
    }
    if (this.j) {
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_fail", null, null);
    }
    n();
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity
 * JD-Core Version:    0.7.0.1
 */