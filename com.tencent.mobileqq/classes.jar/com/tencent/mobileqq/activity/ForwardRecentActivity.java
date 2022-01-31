package com.tencent.mobileqq.activity;

import Wallet.PfaFriend;
import aagc;
import acxk;
import acxl;
import acxm;
import acxn;
import acxo;
import acxp;
import acxq;
import acxr;
import acxs;
import acxt;
import acxu;
import acxv;
import acxw;
import acxx;
import acxy;
import acxz;
import acya;
import acyb;
import acyc;
import acyd;
import adwr;
import aepi;
import aiwp;
import aiwv;
import ajzx;
import akiw;
import akiy;
import akiz;
import alof;
import alog;
import altm;
import alud;
import ambq;
import ameq;
import amnz;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
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
import aoye;
import aoyf;
import aryl;
import aryv;
import arzi;
import arzm;
import asad;
import asbd;
import asdb;
import asei;
import ayqi;
import ayvm;
import azqs;
import azqx;
import bcpx;
import bczz;
import bdbb;
import bdgm;
import bdhd;
import bdin;
import bdll;
import bdnn;
import bfhz;
import com.dataline.activities.LiteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.forward.ForwardBaseActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import ztp;

public class ForwardRecentActivity
  extends ForwardBaseActivity
  implements aiwv, arzm
{
  public static int f;
  public static int g;
  int jdField_a_of_type_Int;
  private adwr jdField_a_of_type_Adwr = new acxp(this);
  private akiw jdField_a_of_type_Akiw;
  private akiz jdField_a_of_type_Akiz = new acxo(this);
  private alog jdField_a_of_type_Alog = new acxn(this);
  private altm jdField_a_of_type_Altm = new acxl(this);
  private ameq jdField_a_of_type_Ameq = new acxm(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  public Uri a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new acxk(this);
  View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  public FrameLayout a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public aryv a;
  private ayqi jdField_a_of_type_Ayqi = new acxq(this);
  private bdbb jdField_a_of_type_Bdbb;
  SelectedAndSearchBar jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar;
  private ForwardRecentItemView jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView;
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
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new acxu(this);
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private ForwardRecentItemView jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView;
  FormItemRelativeLayout jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new acxv(this);
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
  private int jdField_h_of_type_Int;
  boolean jdField_h_of_type_Boolean = false;
  public boolean i = false;
  public boolean j = false;
  boolean k = false;
  private boolean l;
  private boolean m;
  
  static
  {
    jdField_f_of_type_Int = 1;
    jdField_g_of_type_Int = 2;
  }
  
  public ForwardRecentActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Aryv = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
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
      if (!(localObject instanceof akiy))
      {
        n += 1;
      }
      else
      {
        localObject = (akiy)localObject;
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.jdField_a_of_type_JavaLangString = ((akiy)localObject).jdField_b_of_type_JavaLangString;
        if (((akiy)localObject).jdField_a_of_type_ComTencentMobileqqDataRecentUser != null) {
          localResultRecord.jdField_a_of_type_Int = ((akiy)localObject).jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType();
        }
        if ((localResultRecord.jdField_a_of_type_Int == 1) && (!bcpx.a(localResultRecord.jdField_a_of_type_JavaLangString))) {}
        for (boolean bool = true;; bool = false)
        {
          localResultRecord.jdField_a_of_type_Boolean = bool;
          localResultRecord.jdField_b_of_type_JavaLangString = ((akiy)localObject).jdField_a_of_type_JavaLangString;
          localArrayList.add(localResultRecord);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private List<RecentUser> a(List<RecentUser> paramList)
  {
    return this.jdField_a_of_type_Aryv.a(paramList);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131376034));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131375987));
    super.findViewById(2131368624).setVisibility(8);
    super.findViewById(2131368638).setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368670));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Aryv.b());
    e();
    u();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131375722));
    if (AppSetting.jdField_c_of_type_Boolean) {
      bczz.b(this.jdField_a_of_type_AndroidWidgetTextView, Button.class.getName());
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131369527));
    if (AppSetting.jdField_c_of_type_Boolean) {
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_ComTencentWidgetXListView, 2);
    }
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562582, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363522).setVisibility(8);
    Object localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131365851);
    ((EditText)localObject).setFocusable(false);
    ((EditText)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((EditText)localObject).setCursorVisible(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
    f();
    if (this.jdField_a_of_type_Aryv.a(aryl.f)) {
      i();
    }
    if (this.jdField_a_of_type_Aryv.a(aryl.j)) {
      j();
    }
    if ((this.jdField_a_of_type_Aryv.a(aryl.e)) && (!this.l))
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
      azqs.b(this.app, "CliOper", "", "", "friendchoose", "0X800A2D6", a(), 0, "", "", "", a());
      if (getSharedPreferences(this.app.getCurrentAccountUin(), 0).getBoolean("forward_share_card", true)) {
        this.jdField_b_of_type_AndroidViewView.findViewById(2131368542).setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar != null)
      {
        if (!this.k) {
          break label506;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
        localObject = aoyf.a();
        if ((localObject != null) && (!TextUtils.isEmpty(((aoye)localObject).e))) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText(((aoye)localObject).e);
        }
      }
    }
    for (;;)
    {
      if ((jdField_f_of_type_Int == this.jdField_e_of_type_Int) || (jdField_g_of_type_Int == this.jdField_e_of_type_Int)) {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new acxs(this));
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
    if (this.jdField_a_of_type_Aryv.a(aryl.b)) {
      n = 33;
    }
    paramInt = n;
    if (this.jdField_a_of_type_Aryv.a(aryl.h)) {
      paramInt = n | 0x100;
    }
    n = paramInt;
    if (this.jdField_a_of_type_Aryv.a(aryl.i)) {
      n = paramInt | 0x4;
    }
    paramInt = n;
    if (this.jdField_a_of_type_Aryv.a(aryl.d)) {
      paramInt = n | 0x8;
    }
    if (this.jdField_a_of_type_Aryv.a(aryl.c)) {
      paramInt = paramInt | 0x10 | 0x200000 | 0x400000;
    }
    for (;;)
    {
      long l1 = -1L;
      if ((this.jdField_a_of_type_Aryv instanceof asei)) {
        l1 = 1L;
      }
      ContactSearchComponentActivity.a(this, null, 7, paramInt, 561243, l1);
      azqs.b(this.app, "CliOper", "", "", "0X8004049", "0X8004049", 0, 0, "", "", "", "");
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
      this.i = false;
      return;
    }
    if (n == 1)
    {
      this.i = true;
      return;
    }
    if (("SplashActivity".equals(str)) || ("ChatActivity".equals(str)) || ("LiteActivity".equals(str)) || ("ChatHistoryActivity".equals(str))) {
      this.jdField_g_of_type_Boolean = true;
    }
    boolean bool1;
    if ((!paramIntent.getBooleanExtra("only_single_selection", false)) && (this.jdField_a_of_type_Aryv.b()))
    {
      bool1 = bool2;
      if (!this.jdField_g_of_type_Boolean)
      {
        bool1 = bool2;
        if (!this.jdField_h_of_type_Boolean)
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_Aryv.i()) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    this.i = bool1;
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
        paramString.add(((ResultRecord)localIterator.next()).jdField_a_of_type_JavaLangString);
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
    return this.jdField_h_of_type_Int == 1;
  }
  
  private boolean a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord == null) {
      return false;
    }
    Object localObject = a(paramResultRecord.jdField_a_of_type_JavaLangString, paramResultRecord.a());
    ResultRecord localResultRecord = (ResultRecord)this.jdField_a_of_type_JavaUtilMap.get(localObject);
    if (localResultRecord != null)
    {
      localResultRecord.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      paramResultRecord = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(paramResultRecord, false);
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() == 9)
    {
      w();
      return false;
    }
    paramResultRecord = ResultRecord.a(paramResultRecord);
    paramResultRecord.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_JavaUtilMap.put(localObject, paramResultRecord);
    t();
    paramResultRecord = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(paramResultRecord, true);
    paramResultRecord = new ArrayList();
    localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      paramResultRecord.add(((ResultRecord)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new acxw(this);
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
    boolean bool = a(localResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.a());
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "onListViewItemClickedInMultiSelectStatus, isSelected = " + bool);
    }
    if (bool)
    {
      paramView.a(false);
      a(localResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.a());
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368655));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368626));
    if (!this.i)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131705174));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131705180));
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.rightMargin = aepi.a(10.0F, getResources());
      if (Build.VERSION.SDK_INT <= 18) {
        localLayoutParams.width = aepi.a(75.0F, getResources());
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(aepi.a(7.0F, getResources()), 0, aepi.a(7.0F, getResources()), 0);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      }
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131705179));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131559107, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_b_of_type_AndroidViewView.setOverScrollMode(2);
    }
    if (this.jdField_a_of_type_Int != 9501) {
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131369646));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131366744));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131366747));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131366751));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131366746));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout = ((FormItemRelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131366748));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131377474));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(1);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(2);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(3);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(2);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBackgroundResource(2130839212);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBackgroundResource(2130839212);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBackgroundResource(2130839212);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBackgroundResource(2130839212);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBackgroundResource(2130839212);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setBackgroundResource(2130839212);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setCloseListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    View localView = LayoutInflater.from(this).inflate(2131558876, null);
    localView.setFocusable(true);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378751));
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131692849);
      if (!this.i) {
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131692848);
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
    if ((!this.jdField_a_of_type_Aryv.a(aryl.b)) && (!this.jdField_a_of_type_Aryv.a(aryl.c)) && (!this.jdField_a_of_type_Aryv.a(aryl.d)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends, troop and discuss forward, remove mEntryHeader");
      }
      if ((!(this.jdField_a_of_type_Aryv instanceof arzi)) || (this.jdField_a_of_type_Aryv.a(aryl.l))) {
        this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(this.jdField_b_of_type_AndroidViewView);
      }
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Aryv.a(aryl.b))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends forward, set friendBtn gone");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
      }
      if (!this.jdField_a_of_type_Aryv.a(aryl.h))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support phone contacts forward, set contactBtn gone");
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131368542).setVisibility(8);
      }
      if ((!this.jdField_a_of_type_Aryv.a(aryl.c)) || (this.jdField_a_of_type_Aryv.a(aryl.l)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support discuss forward, set multiChatBtn gone");
        }
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
      }
      if ((!this.jdField_a_of_type_Aryv.a(aryl.c)) && (!this.jdField_a_of_type_Aryv.a(aryl.d)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support troop and discuss forward, set troopDiscussionBtn gone");
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
      }
      if ((this.jdField_a_of_type_Aryv instanceof asad))
      {
        if ((!this.jdField_a_of_type_Aryv.a(aryl.b)) && (!this.jdField_a_of_type_Aryv.a(aryl.c)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends and troop forward, set friendBtn gone");
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
        }
        if (!this.jdField_a_of_type_Aryv.a(aryl.b))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends");
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
        }
      }
    } while ((!(this.jdField_a_of_type_Aryv instanceof arzi)) || (this.jdField_a_of_type_Aryv.a(aryl.l)));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView = new ForwardRecentItemView(this);
    ResultRecord localResultRecord1 = new ResultRecord(alof.z, alud.a(2131694654), 6000, "", "");
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a(alud.a(2131694654), "", getResources().getDrawable(2130843834), localResultRecord1, false, false);
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.setOnClickListener(new acxx(this, localResultRecord1));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView);
    if (((ambq)this.app.a(10)).c() != 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView = new ForwardRecentItemView(this);
      ResultRecord localResultRecord2 = new ResultRecord(alof.A, "我的iPad", 6003, "", "");
      this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a("我的iPad", "", getResources().getDrawable(2130843832), localResultRecord2, false, false);
      this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView.setOnClickListener(new acxy(this, localResultRecord1));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView);
    }
  }
  
  private void j()
  {
    ztp localztp = (ztp)this.app.a(51);
    DeviceInfo[] arrayOfDeviceInfo;
    if (localztp.a())
    {
      arrayOfDeviceInfo = localztp.a();
      if ((arrayOfDeviceInfo != null) && (arrayOfDeviceInfo.length > 0)) {
        break label38;
      }
    }
    label38:
    do
    {
      return;
      arrayOfDeviceInfo = this.jdField_a_of_type_Aryv.a(arrayOfDeviceInfo);
    } while (arrayOfDeviceInfo == null);
    int i1 = arrayOfDeviceInfo.length;
    int n = 0;
    label60:
    DeviceInfo localDeviceInfo;
    if (n < i1)
    {
      localDeviceInfo = arrayOfDeviceInfo[n];
      if (localDeviceInfo.isAdmin != 2) {
        break label87;
      }
    }
    for (;;)
    {
      n += 1;
      break label60;
      break;
      label87:
      if ((!localztp.c(localDeviceInfo.din)) || (localztp.a(localDeviceInfo.din, 17)))
      {
        ForwardRecentItemView localForwardRecentItemView = new ForwardRecentItemView(this);
        String str = aagc.a(localDeviceInfo);
        ResultRecord localResultRecord = new ResultRecord(String.valueOf(localDeviceInfo.din), str, 9501, "", "");
        localForwardRecentItemView.a(str, "", new BitmapDrawable(DeviceHeadMgr.getInstance().getDeviceHeadByDin(String.valueOf(localDeviceInfo.din))), localResultRecord, false, false);
        localForwardRecentItemView.setOnClickListener(new acxz(this, localDeviceInfo, localForwardRecentItemView, localResultRecord, super.getResources(), str));
        this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localForwardRecentItemView);
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new acya(this);
      IntentFilter localIntentFilter = new IntentFilter("ShareToQZoneAndFinishTheLastActivity");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void l()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new acyb(this);
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, new IntentFilter("ForwardEntranceActivity"));
    }
  }
  
  private void m()
  {
    int i1 = 0;
    Object localObject;
    if (this.app.e())
    {
      this.jdField_a_of_type_JavaUtilList = a(this.app.a().a().a(true));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("refreshRecentList 01 forwardList size is: ");
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label382;
        }
      }
      label382:
      for (n = 0;; n = this.jdField_a_of_type_JavaUtilList.size())
      {
        QLog.i("ForwardOption.ForwardEntranceActivity", 2, n);
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label406;
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
          if ((TextUtils.equals(alof.ag, localRecentUser.uin)) || (localRecentUser.getType() == 8111) || (localRecentUser.getType() == 8112) || (localRecentUser.getType() == 8113)) {
            ((List)localObject).add(localRecentUser);
          }
          if (localRecentUser.getType() == 1)
          {
            TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).a(localRecentUser.uin, true);
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
      label406:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("refreshRecentList forwardList size is: ");
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label503;
        }
      }
    }
    label503:
    for (int n = i1;; n = this.jdField_a_of_type_JavaUtilList.size())
    {
      QLog.i("ForwardOption.ForwardEntranceActivity", 2, n);
      if (this.jdField_a_of_type_Akiw != null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
      {
        this.jdField_a_of_type_Akiw = new akiw(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Akiz);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Akiw);
      }
      return;
    }
    this.jdField_a_of_type_Akiw.a(this.jdField_a_of_type_JavaUtilList);
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
    Intent localIntent = aepi.a(new Intent(this, SplashActivity.class), null);
    Object localObject1 = new Bundle(this.jdField_a_of_type_Aryv.a());
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
    localObject2 = (ztp)this.app.a(51);
    try
    {
      bool = ((ztp)localObject2).a(Long.parseLong(localIntent.getStringExtra("uin")), 17);
      if (bool)
      {
        localIntent.putExtra("send_in_background", true);
        localIntent.putExtra("sIsCloudPrinter", true);
        PhotoUtils.a(this, localIntent, (ArrayList)localObject1, 0, true);
        if (bdin.a(BaseApplication.getContext()) != 0) {
          QQToast.a(this.app.getApp(), 2, 2131692840, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298914));
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
        PhotoUtils.a(this, localIntent, (ArrayList)localObject1, 0, false);
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
    Collections.sort(localArrayList, new ajzx());
    Bundle localBundle = new Bundle();
    localBundle.putInt("chooseFriendFrom", bdll.a.intValue());
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    localBundle.putBoolean("from_outside_share", this.jdField_e_of_type_Boolean);
    localBundle.putBoolean("from_dataline_aio", this.jdField_f_of_type_Boolean);
    this.jdField_a_of_type_Aryv.a(aryl.a.intValue(), localBundle);
    this.jdField_a_of_type_Aryv.f();
  }
  
  private void q()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  private void r()
  {
    this.jdField_h_of_type_Int = 1;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131705180));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131705177));
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = aepi.a(29.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130844804);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166920));
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBGType(3);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setBackgroundResource(2130839212);
    localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).topMargin = aepi.a(8.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new ForwardRecentActivity.15(this), 50L);
    if (this.jdField_a_of_type_Bdbb == null)
    {
      this.jdField_a_of_type_Bdbb = new bdbb(this.app);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(null, this.jdField_a_of_type_Bdbb, this.jdField_a_of_type_Adwr);
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
      ForwardUtils.a(this.app, "0X800A733", new String[0]);
    }
  }
  
  private void s()
  {
    this.jdField_h_of_type_Int = 0;
    v();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131705180));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131705178));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166900));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850069);
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = aepi.a(36.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(8);
    if ((this.jdField_a_of_type_Aryv.a(aryl.e)) && (!this.l)) {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormItemRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).topMargin = aepi.a(0.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      q();
      this.jdField_a_of_type_Aryv.a("forward_multi_target");
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131705176));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166920));
    }
    for (;;)
    {
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(alud.a(2131705166), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilMap.size()) }));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166919));
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar = ((SelectedAndSearchBar)super.findViewById(2131376369));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.b(0L);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(new acxr(this));
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
      this.jdField_a_of_type_AndroidAppDialog = bdgm.a(this, getString(2131699386), 0, 2131695097, null, new acxt(this));
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
        this.jdField_a_of_type_Aryv.a(aryl.a.intValue(), (Bundle)localObject);
        this.jdField_a_of_type_Aryv.f();
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
    switch (localResultRecord.a())
    {
    default: 
      if (localResultRecord != null)
      {
        localBundle = new Bundle();
        localBundle.putInt("uintype", localResultRecord.a());
        localBundle.putString("uin", localResultRecord.jdField_a_of_type_JavaLangString);
        localBundle.putString("troop_uin", localResultRecord.jdField_c_of_type_JavaLangString);
        if (localResultRecord.a() != 3000) {
          break label476;
        }
        localBundle.putString("uinname", ForwardUtils.a(this.app, paramView.jdField_a_of_type_JavaLangString, localResultRecord.jdField_a_of_type_JavaLangString));
      }
      break;
    }
    for (;;)
    {
      localBundle.putBoolean("forward_report_confirm", true);
      localBundle.putString("forward_report_confirm_action_name", "0X8005A13");
      localBundle.putString("forward_report_confirm_reverse2", "5");
      localBundle.putInt("chooseFriendFrom", bdll.a.intValue());
      localBundle.putString("caller_name", this.jdField_c_of_type_JavaLangString);
      if ((getIntent() != null) && (getIntent().getExtras() != null))
      {
        localBundle.putBoolean("needShareCallBack", getIntent().getExtras().getBoolean("needShareCallBack"));
        localBundle.putInt("miniAppShareFrom", getIntent().getExtras().getInt("miniAppShareFrom"));
      }
      this.jdField_a_of_type_Aryv.a(aryl.a.intValue(), localBundle);
      this.jdField_a_of_type_Aryv.f();
      if ((localResultRecord.a() == 3000) || (localResultRecord.a() == 1)) {
        new azqx(this.app).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "0" }).a();
      }
      azqs.b(this.app, "CliOper", "", "", "friendchoose", "0X8009D90", a(), 0, "", "", "", a());
      return;
      bfhz.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "30", "0", false);
      break;
      bfhz.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "31", "0", false);
      break;
      bfhz.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "32", "0", false);
      break;
      label476:
      localBundle.putString("uinname", paramView.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString)
  {
    if (getIntent().getBooleanExtra("forward_source_from_shoot_quick", false)) {
      azqs.b(this.app, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (isFinishing()) {}
    do
    {
      return;
      localObject1 = aiwp.a(this, paramBoolean, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    } while (localObject1 == null);
    Object localObject2 = ((HashMap)localObject1).get(aiwp.jdField_b_of_type_JavaLangString);
    if (localObject2 != null)
    {
      localObject2 = (ArrayList)localObject2;
      this.jdField_a_of_type_Aryv.a().putStringArrayList("choose_friend_feedbacks", (ArrayList)localObject2);
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = ((HashMap)localObject1).get(aiwp.jdField_a_of_type_JavaLangString);
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
              Collections.sort(this.jdField_a_of_type_JavaUtilList, new acyc(this));
            }
          }
        }
      }
      if (this.jdField_a_of_type_Akiw == null)
      {
        this.jdField_a_of_type_Akiw = new akiw(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Akiz);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Akiw);
        return;
      }
      this.jdField_a_of_type_Akiw.a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
  }
  
  protected boolean a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Aryv = asbd.a(getIntent(), this.app, this);
    if (this.jdField_a_of_type_Aryv != null)
    {
      this.jdField_a_of_type_Aryv.a();
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
    this.jdField_a_of_type_Aryv.A();
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
      acyd.a(this.app, this, paramBundle, (String)localObject, bool);
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
        this.jdField_a_of_type_Aryv.c();
        h();
        l1 = paramBundle.getLongExtra("forward_send_to_uin", 0L);
        if (l1 != 0L) {
          a(l1, paramBundle.getStringExtra("forward_send_to_uin_nickname"));
        }
        if ((jdField_f_of_type_Int == this.jdField_e_of_type_Int) || (jdField_g_of_type_Int == this.jdField_e_of_type_Int)) {
          b();
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
        azqs.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.payerselectpage.show", 0, 0, "", "", "", "");
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
        azqs.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerselectpage.show", 0, 0, "", "", "", "");
      }
      if (paramBundle.getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
        azqs.b(this.app, "dc00898", "", "", "0X8009F7A", "0X8009F7A", 0, 0, "", "", "", "");
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        localObject = new Intent();
        ((Intent)localObject).putExtra("call_by_forward", true);
        if (this.jdField_a_of_type_AndroidNetUri != null) {
          ((Intent)localObject).setData(this.jdField_a_of_type_AndroidNetUri);
        }
        ((Intent)localObject).putExtras(this.jdField_a_of_type_Aryv.a());
        ((Intent)localObject).putExtras(paramBundle.getExtras());
        ((Intent)localObject).putExtra("isForConfessDirectFriendsTitle", this.jdField_a_of_type_Aryv.b());
        ((Intent)localObject).setClass(this, ForwardFriendListActivity.class);
        ((Intent)localObject).putExtra("extra_choose_friend", 5);
        startActivityForResult((Intent)localObject, 20000);
      }
      correctStatusBarHeight();
      azqs.b(this.app, "CliOper", "", "", "friendchoose", "0X8009D8E", a(), 0, "", "", "", "");
      return true;
      m();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    a(false);
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
                  this.jdField_a_of_type_Aryv.a(aryl.b.intValue(), (Bundle)localObject1);
                  bfhz.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "30", "0", false);
                  return;
                }
                localObject1 = paramIntent.getStringExtra("roomId");
                Object localObject2;
                if (!bdnn.a((String)localObject1))
                {
                  m();
                  azqs.b(this.app, "CliOper", "", "", "0X80056B0", "0X80056B0", 0, 0, "", "", "", "");
                  paramInt1 = paramIntent.getIntExtra("select_memeber_discussion_memeber_count", 0);
                  localObject2 = new Bundle();
                  ((Bundle)localObject2).putBoolean("forward_report_confirm", true);
                  ((Bundle)localObject2).putString("forward_report_confirm_action_name", "0X8005A15");
                  ((Bundle)localObject2).putString("forward_report_confirm_reverse2", Integer.toString(paramInt1));
                  this.jdField_a_of_type_Aryv.a((String)localObject1, paramIntent.getStringExtra("discussName"), (Bundle)localObject2);
                }
                bfhz.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "32", "0", false);
                return;
                this.jdField_a_of_type_Aryv.a(paramInt1, paramInt2, paramIntent);
                return;
                paramIntent.putExtra("chooseFriendFrom", bdll.b);
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
                  ayvm.a(paramIntent, this.jdField_a_of_type_Aryv);
                  return;
                }
                this.jdField_a_of_type_Aryv.a(paramInt1, paramInt2, paramIntent);
                return;
              } while (paramIntent == null);
              paramIntent = paramIntent.getStringExtra("new_video_extra_info");
              ((asdb)this.jdField_a_of_type_Aryv).e(paramIntent);
              finish();
              overridePendingTransition(0, 0);
              return;
              this.jdField_a_of_type_Aryv.a(paramInt1, paramInt2, paramIntent);
              return;
              setResult(-1, paramIntent);
              finish();
            } while (this.m);
            acyd.a();
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
        this.jdField_a_of_type_Akiw.notifyDataSetChanged();
        t();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView != null) {
          this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a(a(alof.z, 6000));
        }
        if (this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView == null) {
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqAdapterForwardRecentItemView.a(a(alof.A, 6003));
        return;
        Collections.sort((List)localObject1, new ajzx());
        paramIntent = ((List)localObject1).iterator();
        while (paramIntent.hasNext()) {
          a((ResultRecord)paramIntent.next());
        }
        this.jdField_a_of_type_Akiw.notifyDataSetChanged();
      }
    } while ((paramInt2 != 0) || (!this.m) || (paramInt1 != 20005));
    finish();
  }
  
  public void doOnBackPressed()
  {
    if (!isFinishing())
    {
      this.jdField_a_of_type_Aryv.a(false);
      com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_f_of_type_Boolean = false;
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if ((jdField_f_of_type_Int != this.jdField_e_of_type_Int) && (jdField_g_of_type_Int != this.jdField_e_of_type_Int)) {
      setTheme(2131755151);
    }
    super.doOnCreate(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_Altm);
    this.app.addObserver(this.jdField_a_of_type_Ameq);
    this.app.addObserver(this.jdField_a_of_type_Alog);
    setContentViewNoTitle(2131559111);
    return a(paramBundle);
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Altm);
    this.app.removeObserver(this.jdField_a_of_type_Ameq);
    this.app.removeObserver(this.jdField_a_of_type_Alog);
    if (this.jdField_c_of_type_Boolean) {
      aiwp.a(this.app);
    }
    g();
    if (this.jdField_a_of_type_Akiw != null)
    {
      this.jdField_a_of_type_Akiw.c();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Aryv != null) {
      this.jdField_a_of_type_Aryv.w();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    }
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.d();
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
      Bundle localBundle = this.jdField_a_of_type_Aryv.a();
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
      if ((i1 == aryl.f.intValue()) || (i1 == aryl.k.intValue()))
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
        if (i1 == aryl.g.intValue())
        {
          this.jdField_a_of_type_Aryv.a().putString("forward_filepath", paramIntent);
          this.jdField_a_of_type_Aryv.a().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
          this.jdField_a_of_type_Aryv.u();
          bool = true;
          break;
        }
        bool = bdhd.a(this.app, paramIntent, str1, i2, str2, true, this);
        n = 0;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardEntranceActivity", 2, "failed to send pic from qzone");
        }
      }
    }
    if ((i1 == aryl.f.intValue()) || (i1 == aryl.k.intValue()))
    {
      this.jdField_a_of_type_Aryv.a().putString("forward_extra", paramIntent);
      this.jdField_a_of_type_Aryv.b(i1);
      return;
    }
    if (i1 == aryl.g.intValue())
    {
      this.jdField_a_of_type_Aryv.a().putString("forward_filepath", paramIntent);
      this.jdField_a_of_type_Aryv.a().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
      this.jdField_a_of_type_Aryv.u();
      return;
    }
    this.jdField_a_of_type_Aryv.a().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
    o();
    azqs.b(this.app, "CliOper", "", "", "0X800514C", "0X800514C", 0, 0, "", "", "", "");
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Aryv != null) {
      this.jdField_a_of_type_Aryv.j();
    }
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    if (this.jdField_a_of_type_Aryv != null) {
      this.jdField_a_of_type_Aryv.b(paramBundle);
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
    if (this.jdField_a_of_type_Aryv != null) {
      this.jdField_a_of_type_Aryv.k();
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if (this.jdField_a_of_type_Aryv != null) {
      this.jdField_a_of_type_Aryv.a(paramBundle);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity
 * JD-Core Version:    0.7.0.1
 */