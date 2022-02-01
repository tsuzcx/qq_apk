package com.tencent.mobileqq.activity.selectmember;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.DataReport.ShareChat;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.activity.SelectedAndSearchBar.ISelectedAndSearchBarCallback;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.qwallet.IToPayManager;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.model.ContactSearchModelNewTroopMember;
import com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateCallback;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateResult;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.groupvideo.GroupVideoWrapper;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class SelectMemberActivity
  extends FragmentActivity
  implements View.OnClickListener, ISelectMemberActivityConstants, ContactSearchResultPresenter.OnActionListener, TroopCreateLogic.TroopCreateCallback
{
  public static boolean b;
  protected float a;
  public int a;
  protected long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  protected Intent a;
  protected Bitmap a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  final Handler jdField_a_of_type_AndroidOsHandler = new SelectMemberActivity.17(this, Looper.getMainLooper());
  protected View a;
  InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected ProgressBar a;
  protected TextView a;
  private QavWrapper jdField_a_of_type_ComTencentAvServiceQavWrapper = null;
  protected InnerFrameManager a;
  protected ChatActivityUtils.StartVideoListener a;
  private SelectedAndSearchBar.ISelectedAndSearchBarCallback jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$ISelectedAndSearchBarCallback = new SelectMemberActivity.9(this);
  protected SelectedAndSearchBar a;
  public BlessManager a;
  private IToPayManager jdField_a_of_type_ComTencentMobileqqActivityQwalletIToPayManager;
  SelectMemberActivity.IOnSelectStateChange jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver;
  ContactSearchFragment jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment;
  protected QQProgressDialog a;
  private GroupVideoWrapper jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper = null;
  protected List<String> a;
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  long jdField_b_of_type_Long = 0L;
  protected Dialog b;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  protected View b;
  private Button jdField_b_of_type_AndroidWidgetButton;
  protected TextView b;
  public ArrayList<String> b;
  protected int c;
  private long jdField_c_of_type_Long = 0L;
  protected View c;
  protected TextView c;
  String jdField_c_of_type_JavaLangString;
  public ArrayList<String> c;
  protected boolean c;
  public int d;
  protected View d;
  protected TextView d;
  String jdField_d_of_type_JavaLangString;
  public ArrayList<String> d;
  boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int;
  protected View e;
  protected TextView e;
  String jdField_e_of_type_JavaLangString;
  protected ArrayList<ResultRecord> e;
  boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int;
  View jdField_f_of_type_AndroidViewView;
  protected TextView f;
  String jdField_f_of_type_JavaLangString;
  public ArrayList<String> f;
  boolean jdField_f_of_type_Boolean;
  protected int g;
  private View jdField_g_of_type_AndroidViewView;
  String jdField_g_of_type_JavaLangString = HardCodeUtil.a(2131713710);
  ArrayList<Entity> jdField_g_of_type_JavaUtilArrayList;
  boolean jdField_g_of_type_Boolean;
  protected int h;
  String jdField_h_of_type_JavaLangString = "";
  boolean jdField_h_of_type_Boolean;
  protected int i;
  boolean i;
  public int j;
  boolean j;
  private int jdField_k_of_type_Int = 0;
  boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int = 0;
  boolean jdField_l_of_type_Boolean;
  boolean m;
  protected boolean n = true;
  protected boolean o = false;
  protected boolean p;
  protected boolean q = false;
  public boolean r = true;
  public boolean s = false;
  public boolean t = true;
  public boolean u = false;
  public boolean v = false;
  public boolean w = false;
  boolean x = false;
  boolean y = false;
  boolean z;
  
  static
  {
    jdField_b_of_type_Boolean = false;
  }
  
  public SelectMemberActivity()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 9223372036854775807L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_j_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener = new SelectMemberActivity.11(this);
  }
  
  public static ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.uin = paramString1;
    localResultRecord.name = paramString2;
    localResultRecord.type = paramInt;
    localResultRecord.groupUin = paramString3;
    return localResultRecord;
  }
  
  private void a(SelectMemberActivity paramSelectMemberActivity, String paramString, int paramInt)
  {
    if (QQGameTroopManager.b(paramSelectMemberActivity)) {
      ((QQGameTroopManager)this.app.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).a(paramSelectMemberActivity, this.jdField_e_of_type_JavaUtilArrayList, paramInt, paramString, getIntent().getStringExtra("group_uin"));
    }
  }
  
  private void a(String paramString)
  {
    if (System.currentTimeMillis() - this.jdField_c_of_type_Long > 2000)
    {
      QQToast.a(this, paramString, 2000).b(this.jdField_c_of_type_AndroidViewView.getHeight());
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectMemberActivity", 2, "afterCreateTroopSucc, troop[" + paramString + "], entrance[" + this.jdField_d_of_type_Int + "]");
    }
    Object localObject = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
    ArrayList localArrayList;
    Iterator localIterator;
    if (localObject == null)
    {
      localObject = "";
      localArrayList = new ArrayList();
      localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label218;
      }
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.type == 5)
      {
        if (localResultRecord.uin.startsWith("pstn")) {
          localResultRecord.uin = localResultRecord.uin.substring("pstn".length());
        }
        localArrayList.add(localResultRecord.uin);
        continue;
        localObject = ((TroopInfo)localObject).troopname;
        break;
      }
      if ((localResultRecord.type == 4) && (localResultRecord.uin.startsWith("+"))) {
        localArrayList.add(localResultRecord.uin);
      }
    }
    label218:
    this.jdField_a_of_type_AndroidContentIntent.putExtra("roomId", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("discussName", (String)localObject);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("qqPhoneUserList", localArrayList);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("audioType", 2);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("result_uin", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("result_uintype", 1);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("result_name", (String)localObject);
    if (this.jdField_d_of_type_Int == 12) {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("select_memeber_discussion_memeber_count", this.jdField_e_of_type_JavaUtilArrayList.size() + 1);
    }
    this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_e_of_type_JavaUtilArrayList);
    setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_d_of_type_Int == 27) {
      TroopUtils.a(this, paramString, true);
    }
    finish();
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("show_invite_entry", false)) {}
    label293:
    for (;;)
    {
      return;
      int i1 = this.jdField_e_of_type_JavaUtilArrayList.size();
      String str1;
      if (i1 <= 1) {
        if (this.jdField_b_of_type_Int == 3)
        {
          String str2 = this.jdField_e_of_type_JavaLangString;
          str1 = str2;
          if (i1 != 1)
          {
            paramBoolean = false;
            str1 = str2;
          }
          if (!paramBoolean) {
            break label248;
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(true);
          if (!"1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
            this.jdField_e_of_type_AndroidWidgetTextView.setAlpha(1.0F);
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setText(str1);
        }
      }
      for (;;)
      {
        if (!AppSetting.jdField_d_of_type_Boolean) {
          break label293;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_e_of_type_JavaLangString + HardCodeUtil.a(2131713703) + i1 + HardCodeUtil.a(2131713694));
        return;
        if (((this.jdField_d_of_type_Int == 25) && (i1 == 1)) || ((f()) && (i1 == 1)))
        {
          str1 = MessageFormat.format(this.jdField_f_of_type_JavaLangString, new Object[] { Integer.valueOf(i1) });
          break;
        }
        str1 = this.jdField_e_of_type_JavaLangString;
        break;
        if (this.jdField_b_of_type_Int == 3)
        {
          str1 = this.jdField_e_of_type_JavaLangString;
          break;
        }
        str1 = MessageFormat.format(this.jdField_f_of_type_JavaLangString, new Object[] { Integer.valueOf(i1) });
        break;
        label248:
        this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(false);
        if (!"1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
          this.jdField_e_of_type_AndroidWidgetTextView.setAlpha(0.5F);
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(str1);
      }
    }
  }
  
  private boolean a()
  {
    if ((!this.jdField_c_of_type_Boolean) && (b() >= 3)) {}
    return true;
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "sendIsResumeBroadcast isNeedSend = " + this.t + " ,isResume = " + paramBoolean);
    }
    if (this.t) {
      SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    int i1;
    if (this.jdField_b_of_type_Int == 1) {
      if (this.jdField_a_of_type_ComTencentAvServiceQavWrapper != null) {
        i1 = this.jdField_a_of_type_ComTencentAvServiceQavWrapper.a(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), this.jdField_a_of_type_Int) + 0;
      }
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
      label50:
      int i2;
      if (localIterator.hasNext()) {
        if (((ResultRecord)localIterator.next()).type == 5)
        {
          i2 = i1 + 1;
          i1 = i2;
          if (i2 < 8) {}
        }
      }
      for (;;)
      {
        if (i2 < 8) {
          bool = true;
        }
        return bool;
        if (this.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper == null) {
          break label141;
        }
        i1 = this.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper.a(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), this.jdField_a_of_type_Int) + 0;
        break;
        break label50;
        i2 = i1;
      }
      label141:
      i1 = 0;
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_AndroidAppDialog != null)
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    this.jdField_b_of_type_AndroidAppDialog = new ReportDialog(this, 2131755842);
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2131562946);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365807));
    this.jdField_f_of_type_AndroidWidgetTextView.setText(getString(2131719050));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131367330));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131380971));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new SelectMemberActivity.13(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new SelectMemberActivity.14(this);
    this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new SelectMemberActivity.15(this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
  }
  
  private void d(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      if ((this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 36)) {
        str = getString(2131695572);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, str).sendToTarget();
      QLog.w("SelectMemberActivity", 1, "handleTroopInviteGroupFailed, result[" + paramInt + "], errStr[" + str + "]");
      return;
      str = getString(2131693525);
      continue;
      str = getString(2131693524);
      continue;
      str = getString(2131693527);
      continue;
      str = getString(2131693526);
      continue;
      str = getString(2131693528);
    }
  }
  
  private boolean d(String paramString)
  {
    try
    {
      Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = TextUtils.equals(((ResultRecord)localIterator.next()).uin, paramString);
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private void e(int paramInt)
  {
    a(getString(paramInt));
  }
  
  private void e(boolean paramBoolean)
  {
    SelectMemberInnerFrame localSelectMemberInnerFrame;
    if ((this.jdField_d_of_type_Int == 38) || (this.jdField_d_of_type_Int == 29) || (this.jdField_d_of_type_Int == 39))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberActivity", 2, "isItemClick：" + paramBoolean);
      }
      localSelectMemberInnerFrame = (SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getChildAt(1);
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 0)) {
        break label87;
      }
    }
    label87:
    while (!(localSelectMemberInnerFrame instanceof FriendTeamListInnerFrame)) {
      return;
    }
    ResultRecord localResultRecord = null;
    if (this.jdField_e_of_type_JavaUtilArrayList.size() > 0) {
      localResultRecord = (ResultRecord)this.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_e_of_type_JavaUtilArrayList.size() - 1);
    }
    localSelectMemberInnerFrame.a(localResultRecord, this.jdField_d_of_type_Int);
  }
  
  int a(String paramString)
  {
    switch (PstnUtils.a(paramString.substring("pstn".length()), true))
    {
    case 0: 
    default: 
      return 0;
    case -1: 
      return 2131719010;
    case 1: 
      return 2131719004;
    case 2: 
      return 2131719005;
    case 3: 
      return 2131719006;
    case 4: 
      return 2131719007;
    case 5: 
      return 2131719008;
    }
    return 2131719009;
  }
  
  public ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.uin = paramString1;
    localResultRecord.name = paramString2;
    localResultRecord.type = paramInt;
    localResultRecord.groupUin = paramString3;
    localResultRecord.phone = paramString4;
    return localResultRecord;
  }
  
  public CharDividedFacePreloadBaseAdapter a()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager != null) && ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView() instanceof TroopMemberListInnerFrame))) {
      return ((TroopMemberListInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a();
    }
    return null;
  }
  
  protected String a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager != null)
    {
      paramString = localTroopManager.b(paramString);
      if (paramString != null) {
        return paramString.troopcode;
      }
    }
    return null;
  }
  
  ArrayList<ResultRecord> a()
  {
    if ((this.jdField_d_of_type_Int == 11) && (this.jdField_g_of_type_JavaUtilArrayList != null))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (!a(localResultRecord.uin)) {
          localArrayList.add(localResultRecord);
        }
      }
      return localArrayList;
    }
    return this.jdField_e_of_type_JavaUtilArrayList;
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_e_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((ResultRecord)this.jdField_e_of_type_JavaUtilArrayList.get(i1)).uin);
      i1 += 1;
    }
    return localArrayList;
  }
  
  public Map<String, List<TroopMemberInfo>> a()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager != null) && ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView() instanceof TroopMemberListInnerFrame))) {
      return ((TroopMemberListInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a();
    }
    return null;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Int == 3000) && (f()))
    {
      m();
      return;
    }
    Object localObject1;
    label180:
    Object localObject2;
    Object localObject3;
    int i1;
    int i2;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin");
      if ((localObject1 != null) && ((this.jdField_d_of_type_Int == 32) || (this.jdField_d_of_type_Int == 43)) && ((this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean)))
      {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("group_uin", (String)localObject1);
        if (!this.jdField_h_of_type_Boolean) {
          break label712;
        }
        localObject1 = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).c((String)localObject1);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("group_type", 4);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_AndroidContentIntent.putExtra("group_name", ((TroopInfo)localObject1).troopname);
          this.jdField_a_of_type_AndroidContentIntent.putExtra("group_member_type", ((TroopInfo)localObject1).wMemberNum);
        }
        if (QQGameTroopManager.b(this)) {
          QQGameTroopManager.a(this.jdField_e_of_type_JavaUtilArrayList);
        }
      }
      if ((this.jdField_d_of_type_Int == 42) || (this.jdField_d_of_type_Int == 41)) {
        a(this.jdField_e_of_type_JavaUtilArrayList, this.jdField_d_of_type_Int);
      }
      this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_e_of_type_JavaUtilArrayList);
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      finish();
      return;
    case 3000: 
      if (this.m)
      {
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!d((String)localObject2))
          {
            localObject3 = new ResultRecord();
            ((ResultRecord)localObject3).uin = ((String)localObject2);
            ((ResultRecord)localObject3).type = 0;
            ((ResultRecord)localObject3).groupUin = "-1";
            this.jdField_e_of_type_JavaUtilArrayList.add(localObject3);
          }
        }
      }
      localObject1 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      this.jdField_e_of_type_JavaUtilArrayList.size();
      localObject2 = this.jdField_e_of_type_JavaUtilArrayList.iterator();
      i1 = 0;
      i2 = 0;
      label400:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ResultRecord)((Iterator)localObject2).next();
        if (((ResultRecord)localObject3).type == 3) {
          i2 = 1;
        }
        if (((ResultRecord)localObject3).type != 5)
        {
          i1 = 1;
          label444:
          if ((i2 == 0) || (i1 == 0)) {
            break;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (i2 != 0)
      {
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "0", "", "", "");
        label487:
        if (this.jdField_b_of_type_Int != 0) {
          break label663;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8005446", "0X8005446", 0, 0, "", "", "", "");
        label524:
        if (this.jdField_b_of_type_Int != 0) {
          break label696;
        }
      }
      label663:
      label696:
      for (i2 = 2131691839;; i2 = 2131691836)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131299166));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(i2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        if ((this.jdField_b_of_type_Int == 0) || (i1 != 0))
        {
          localObject1 = new SelectMemberActivity.12(this, (FriendsManager)localObject1);
          ((Thread)localObject1).setName("SelectMemberActivity_addDiscussion");
          ThreadManager.postImmediately((Runnable)localObject1, null, false);
        }
        if (this.jdField_b_of_type_Int == 0) {
          break;
        }
        s();
        if (i1 != 0) {
          break;
        }
        finish();
        return;
        break label400;
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "1", "", "", "");
        break label487;
        ReportController.b(this.app, "CliOper", "", "", "0X800674C", "0X800674C", 0, 0, "", "", "", "");
        break label524;
      }
      a(this.jdField_e_of_type_JavaUtilArrayList);
      return;
      label712:
      if (!this.jdField_i_of_type_Boolean) {
        break label180;
      }
      localObject2 = (DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      localObject3 = ((DiscussionManager)localObject2).a((String)localObject1);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("group_type", 8);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("group_member_type", ((DiscussionManager)localObject2).a((String)localObject1));
      if (localObject3 == null) {
        break label180;
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("group_name", ((DiscussionInfo)localObject3).discussionName);
      break label180;
      break label444;
    }
  }
  
  void a(int paramInt)
  {
    long l1 = Utils.a();
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
    localEditor.putString("not_admin_invite_member_count", l1 + ":" + paramInt);
    localEditor.commit();
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString))) {
      ReportController.b(this.app, "dc00899", "Grp_create", "", "choose_cre", "cre_suc", 0, 0, paramString, "", "", "");
    }
    do
    {
      return;
      paramInt = TroopCreateLogic.TroopCreateResult.a(paramInt);
    } while (paramInt == 0);
    QQToast.a(this, 1, paramInt, 0).b(getTitleBarHeight());
  }
  
  public void a(View paramView)
  {
    Object localObject2 = (IContactSearchModel)paramView.getTag(2131381651);
    if (localObject2 == null) {}
    String str;
    Object localObject1;
    label228:
    do
    {
      return;
      if (this.jdField_d_of_type_Int == 33) {
        ReportController.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.searchclick", 0, 0, "", "", "", "");
      }
      paramView = ((IContactSearchModel)localObject2).b();
      str = ((IContactSearchModel)localObject2).a().toString();
      localObject1 = "-1";
      if ((localObject2 instanceof ContactSearchModelDiscussionMember))
      {
        localObject1 = ((ContactSearchModelDiscussionMember)localObject2).e();
        if ((localObject2 instanceof ContactSearchModelPhoneContact))
        {
          paramView = ((ContactSearchModelPhoneContact)localObject2).a;
          if (!TextUtils.isEmpty(paramView.uin)) {
            break label228;
          }
          paramView = "pstn" + paramView.mobileNo;
        }
      }
      for (;;)
      {
        if (!(localObject2 instanceof ContactSearchModelDiscussion)) {
          break label277;
        }
        paramView = new Bundle();
        paramView.putString("group_uin", ((ContactSearchModelDiscussion)localObject2).b());
        paramView.putString("group_name", ((ContactSearchModelDiscussion)localObject2).c());
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, paramView);
        p();
        return;
        if (!(localObject2 instanceof ContactSearchModelNewTroopMember)) {
          break;
        }
        localObject1 = ((ContactSearchModelNewTroopMember)localObject2).a;
        break;
        if (paramView.uin.equals("0")) {
          paramView = paramView.nationCode + paramView.mobileCode;
        } else {
          paramView = paramView.uin;
        }
      }
      if ((localObject2 instanceof ContactSearchModelNewTroop))
      {
        paramView = (ContactSearchModelNewTroop)localObject2;
        localObject1 = paramView.a();
        if ((!((TroopInfo)localObject1).isAllowCreateDiscuss()) && (!((TroopInfo)localObject1).isTroopOwner(this.app.getCurrentAccountUin())) && (!((TroopInfo)localObject1).isTroopAdmin(this.app.getCurrentAccountUin())))
        {
          QQToast.a(this, 0, getResources().getString(2131697620), 0).b(getResources().getDimensionPixelSize(2131299166));
          return;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("group_uin", paramView.b());
        ((Bundle)localObject1).putString("group_name", paramView.c());
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, (Bundle)localObject1);
        p();
        return;
      }
      if ((localObject2 instanceof ContactSearchModelTroop))
      {
        paramView = (ContactSearchModelTroop)localObject2;
        localObject1 = paramView.a();
        if ((!((TroopInfo)localObject1).isAllowCreateDiscuss()) && (!((TroopInfo)localObject1).isTroopOwner(this.app.getCurrentAccountUin())) && (!((TroopInfo)localObject1).isTroopAdmin(this.app.getCurrentAccountUin())))
        {
          QQToast.a(this, 0, getResources().getString(2131697620), 0).b(getResources().getDimensionPixelSize(2131299166));
          return;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("group_uin", paramView.b());
        ((Bundle)localObject1).putString("group_name", paramView.c());
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, (Bundle)localObject1);
        p();
        return;
      }
      if (c(paramView))
      {
        QQToast.a(this, 1, HardCodeUtil.a(2131713697), 0).b(getTitleBarHeight());
        ReportController.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, (String)localObject1, "", "", "");
        return;
      }
    } while (((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.contains(paramView))) || (b(paramView)) || (a("onAction", false, paramView, str, -1, (String)localObject1)) || (a(paramView, str)));
    label277:
    SelectMemberInnerFrame localSelectMemberInnerFrame = (SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView();
    int i1;
    if ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 5) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 4) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 3) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 8))
    {
      i1 = -1;
      if ((localObject2 instanceof ContactSearchModelDiscussionMember))
      {
        i1 = 2;
        if (i1 != -1) {
          this.jdField_e_of_type_JavaUtilArrayList.add(a(paramView, str, i1, (String)localObject1));
        }
        label746:
        r();
        k();
        localSelectMemberInnerFrame.f();
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(true);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a();
        if (this.jdField_a_of_type_Int == 9003) {
          if ((this.jdField_d_of_type_Int != 15) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(paramView))) {
            break label1149;
          }
        }
      }
    }
    for (this.jdField_k_of_type_Int += 1;; this.jdField_k_of_type_Int += 1) {
      label1149:
      do
      {
        e(false);
        a(this, paramView, 2);
        return;
        if ((localObject2 instanceof ContactSearchModelNewTroopMember))
        {
          i1 = 1;
          break;
        }
        if ((localObject2 instanceof ContactSearchModelFriend))
        {
          i1 = 0;
          break;
        }
        if (!(localObject2 instanceof ContactSearchModelPhoneContact)) {
          break;
        }
        if ((paramView.startsWith("pstn")) && (b(paramView, str, 5, (String)localObject1)))
        {
          i1 = 5;
          break;
        }
        if (paramView.startsWith("+"))
        {
          i1 = 4;
          break;
        }
        i1 = 0;
        break;
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 6)
        {
          this.jdField_e_of_type_JavaUtilArrayList.add(a(paramView, str, 1, localSelectMemberInnerFrame.a()));
          break label746;
        }
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 7)
        {
          this.jdField_e_of_type_JavaUtilArrayList.add(a(paramView, str, 2, localSelectMemberInnerFrame.a()));
          break label746;
        }
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 1)
        {
          if ((paramView.startsWith("pstn")) && (b(paramView, str, 5, localSelectMemberInnerFrame.a())))
          {
            this.jdField_e_of_type_JavaUtilArrayList.add(a(paramView, str, 5, localSelectMemberInnerFrame.a()));
            break label746;
          }
          if (paramView.startsWith("+"))
          {
            this.jdField_e_of_type_JavaUtilArrayList.add(a(paramView, str, 4, localSelectMemberInnerFrame.a()));
            break label746;
          }
          this.jdField_e_of_type_JavaUtilArrayList.add(a(paramView, str, 0, localSelectMemberInnerFrame.a()));
          break label746;
        }
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 9) {
          break label746;
        }
        localObject1 = a(paramView, str, 1, localSelectMemberInnerFrame.a());
        localObject2 = new ArrayList(1);
        ((List)localObject2).add(localObject1);
        a((List)localObject2, false);
        break label746;
      } while ((this.jdField_d_of_type_Int != 32) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(paramView)));
    }
  }
  
  public void a(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Int != 30) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange.a(paramResultRecord, paramBoolean);
    }
    if (this.jdField_e_of_type_JavaUtilArrayList.isEmpty())
    {
      paramResultRecord = getString(2131691164);
      label46:
      if (this.jdField_b_of_type_AndroidWidgetButton == null) {
        break label110;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(paramResultRecord);
      paramResultRecord = this.jdField_b_of_type_AndroidWidgetButton;
      if (this.jdField_e_of_type_JavaUtilArrayList.isEmpty()) {
        break label112;
      }
    }
    label110:
    label112:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramResultRecord.setEnabled(paramBoolean);
      return;
      paramResultRecord = getString(2131691165, new Object[] { Integer.valueOf(this.jdField_e_of_type_JavaUtilArrayList.size()) });
      break label46;
      break;
    }
  }
  
  public void a(SelectMemberActivity.IOnSelectStateChange paramIOnSelectStateChange)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange = paramIOnSelectStateChange;
  }
  
  protected void a(ArrayList<ResultRecord> paramArrayList)
  {
    if ((paramArrayList.size() > 0) && (this.jdField_c_of_type_JavaLangString.length() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member: troopCode: " + this.jdField_c_of_type_JavaLangString + " member count: " + paramArrayList.size());
      }
      if (!a())
      {
        QQToast.a(this, 2131694523, 0).b(getTitleBarHeight());
        return;
      }
      if (this.jdField_i_of_type_Int <= 0)
      {
        Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).b(this.jdField_c_of_type_JavaLangString);
          if (localObject != null) {
            this.jdField_i_of_type_Int = ((TroopInfo)localObject).wMemberNum;
          }
        }
      }
      if ((this.jdField_a_of_type_Long > 0L) && (paramArrayList.size() + this.jdField_i_of_type_Int > this.jdField_a_of_type_Long))
      {
        DialogUtil.a(this, HardCodeUtil.a(2131713704), 2131690800, 2131693522, new SelectMemberActivity.7(this, paramArrayList), new DialogUtil.DialogOnClickAdapter()).show();
        d("exp_msgbox");
        return;
      }
      ((TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_c_of_type_JavaLangString, paramArrayList, "");
      c();
      this.jdField_b_of_type_AndroidAppDialog.show();
      d("Clk_invite");
      return;
    }
    finish();
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, int paramInt)
  {
    Object localObject2;
    if (paramArrayList != null)
    {
      localObject1 = paramArrayList.iterator();
      paramArrayList = null;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResultRecord)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((ResultRecord)localObject2).uin))) {
          if (paramArrayList == null) {
            paramArrayList = new StringBuilder(((ResultRecord)localObject2).uin + "");
          }
        }
        for (;;)
        {
          break;
          paramArrayList.append("|" + ((ResultRecord)localObject2).uin);
        }
      }
      if (paramArrayList != null)
      {
        localObject2 = new HashMap();
        if (paramInt != 41) {
          break label188;
        }
      }
    }
    label188:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      ((HashMap)localObject2).put("ext1", localObject1);
      ((HashMap)localObject2).put("ext6", paramArrayList.toString());
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 41, 1, 2, (HashMap)localObject2, null, null);
      return;
    }
  }
  
  public void a(Map<String, List<TroopMemberInfo>> paramMap, int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager != null) && ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView() instanceof TroopMemberListInnerFrame)))
    {
      ((TroopMemberListInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a(paramMap, paramArrayOfInt, paramArrayOfString);
      d(true);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_b_of_type_Int == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377718));
      if ((paramBoolean) && (getIntent().getIntExtra("param_member_show_type", 1) == 2))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131697810, new Object[] { Integer.valueOf(Math.min(paramInt, this.jdField_g_of_type_Int)) }));
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131697812, new Object[] { Integer.valueOf(this.jdField_g_of_type_Int) }));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new SelectMemberActivity.2(this));
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130851150);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.jdField_c_of_type_AndroidWidgetTextView);
      if ((this.jdField_d_of_type_Int != 14) && (this.jdField_d_of_type_Int != 21) && (this.jdField_d_of_type_Int != 25) && (this.jdField_d_of_type_Int != 35)) {
        break label206;
      }
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break label195;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
      label118:
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText());
        paramString2 = this.jdField_c_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidWidgetTextView.getText())) {
          break label395;
        }
      }
    }
    label395:
    for (paramString1 = HardCodeUtil.a(2131713699);; paramString1 = this.jdField_c_of_type_AndroidWidgetTextView.getText())
    {
      paramString2.setContentDescription(paramString1);
      this.jdField_c_of_type_AndroidWidgetTextView.postDelayed(new SelectMemberActivity.4(this), 1000L);
      return;
      b();
      break;
      label195:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
      break label118;
      label206:
      if (this.jdField_b_of_type_Int == 3)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131697811));
        break label118;
      }
      if (this.jdField_c_of_type_Int == 30)
      {
        this.jdField_d_of_type_JavaLangString = getString(2131689577);
        if (!this.jdField_b_of_type_AndroidWidgetTextView.getText().equals(this.jdField_d_of_type_JavaLangString)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
        }
        if (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if (8 != this.jdField_d_of_type_AndroidWidgetTextView.getVisibility()) {
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new SelectMemberActivity.3(this));
        if (!AppSetting.jdField_d_of_type_Boolean) {
          break label118;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_d_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131718990));
        break label118;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
      break label118;
    }
  }
  
  boolean a(String paramString)
  {
    Iterator localIterator = this.jdField_g_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(((TroopMemberInfo)localIterator.next()).memberuin, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Int == 9003)
    {
      if ((this.jdField_d_of_type_Int == 15) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(paramString1)) && (this.jdField_k_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.d())) {
        a(String.format(getString(2131690758), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.c()) }));
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bool1;
        if (this.jdField_d_of_type_Int == 32)
        {
          bool2 = bool1;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(paramString1))
          {
            bool2 = bool1;
            if (this.jdField_k_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.j())
            {
              a(String.format(getString(2131720647), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.i()) }));
              bool2 = true;
            }
          }
        }
        return bool2;
      }
    }
    return false;
  }
  
  boolean a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool1;
    if (b(paramString1))
    {
      bool1 = false;
      e(paramString1);
    }
    for (;;)
    {
      if (c(paramString1))
      {
        e(paramString1);
        QQToast.a(this, 1, HardCodeUtil.a(2131713706), 0).b(getTitleBarHeight());
        ReportController.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, paramString3, "", "", "");
        bool1 = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(bool1);
      k();
      r();
      e(true);
      a(this, paramString1, 3);
      return bool1;
      if ((!a("onListViewItemClick1", false, paramString1, paramString2, paramInt, paramString3)) && (!a(paramString1, paramString2)) && (b(paramString1, paramString2, paramInt, paramString3)))
      {
        boolean bool2 = true;
        this.jdField_e_of_type_JavaUtilArrayList.add(a(paramString1, paramString2, paramInt, paramString3));
        bool1 = bool2;
        if (this.jdField_a_of_type_Int == 9003) {
          if ((this.jdField_d_of_type_Int == 15) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(paramString1)))
          {
            this.jdField_k_of_type_Int += 1;
            bool1 = bool2;
          }
          else
          {
            bool1 = bool2;
            if (this.jdField_d_of_type_Int == 32)
            {
              bool1 = bool2;
              if (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(paramString1))
              {
                this.jdField_k_of_type_Int += 1;
                bool1 = bool2;
              }
            }
          }
        }
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  boolean a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    boolean bool;
    if (b(paramString1))
    {
      bool = false;
      e(paramString1);
    }
    for (;;)
    {
      if (c(paramString1))
      {
        e(paramString1);
        QQToast.a(this, 1, HardCodeUtil.a(2131713671), 0).b(getTitleBarHeight());
        ReportController.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, paramString3, "", "", "");
        bool = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(bool);
      k();
      r();
      return bool;
      if ((!a("onListViewItemClick2", false, paramString1, paramString2, paramInt, paramString3)) && (b(paramString1, paramString2, paramInt, paramString3)))
      {
        bool = true;
        this.jdField_e_of_type_JavaUtilArrayList.add(a(paramString1, paramString2, paramInt, paramString3, paramString4));
      }
      else
      {
        bool = false;
      }
    }
  }
  
  boolean a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (((this.jdField_d_of_type_Int == 32) || (this.jdField_d_of_type_Int == 43)) && (paramBoolean) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_enable_all_select", false))) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (this.jdField_a_of_type_Int != 3000) {
            break;
          }
        } while (this.jdField_e_of_type_JavaUtilArrayList.size() < this.jdField_g_of_type_Int);
        if ((this.jdField_d_of_type_Int == 12) && (this.jdField_g_of_type_Int == 1)) {
          e(2131691871);
        }
        for (;;)
        {
          return true;
          e(2131691866);
        }
        if (this.jdField_a_of_type_Int != 1) {
          break label721;
        }
        if ((this.o) && (this.jdField_e_of_type_JavaUtilArrayList.size() >= this.jdField_g_of_type_Int))
        {
          a(HardCodeUtil.a(2131713686));
          return true;
        }
        if (this.jdField_b_of_type_Int != 0) {
          break;
        }
      } while (this.jdField_e_of_type_JavaUtilArrayList.size() < this.jdField_g_of_type_Int);
      a(getString(2131720325));
      return true;
      if (this.jdField_b_of_type_Int != 1) {
        break;
      }
      if (this.jdField_e_of_type_JavaUtilArrayList.size() >= this.jdField_g_of_type_Int)
      {
        e(2131720325);
        return true;
      }
    } while ((this.jdField_d_of_type_Int != 11) || (this.jdField_g_of_type_JavaUtilArrayList == null));
    int i3 = this.jdField_g_of_type_JavaUtilArrayList.size() + 1;
    TroopManager localTroopManager = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin");
    int i1 = localTroopManager.c(str).getMemNumForAutoInviteIntoGroup(this.app.getCurrentUin());
    if (i1 > i3)
    {
      i1 -= i3;
      label290:
      int i2 = a().size();
      int i4 = this.jdField_e_of_type_JavaUtilArrayList.size();
      paramBoolean = a(paramString2);
      if (AudioHelper.e()) {
        QLog.w("SelectMemberActivity", 1, "isMemberOverLoad[" + paramString1 + "], 可邀请的群外成员到达上限检查, 已经选择群内成员[" + (i4 - i2) + "], 当前群成员[" + i3 + "], 实际可邀请的群外成员[" + i1 + "], 已经选择的群外成员[" + i2 + "], 当前选择的是群成员[" + paramBoolean + "], uin[" + paramString2 + "], name[" + paramString3 + "], type[" + paramInt + "], fromGroupUin[" + paramString4 + "], mResultList[" + this.jdField_e_of_type_JavaUtilArrayList.size() + "], groupUin[" + str + "], mGroupCode[" + this.jdField_c_of_type_JavaLangString + "]");
      }
      paramInt = i2;
      if (!paramBoolean) {
        paramInt = i2 + 1;
      }
      if (paramInt <= i1) {
        break label938;
      }
      paramBoolean = true;
      e(2131720294);
    }
    for (;;)
    {
      return paramBoolean;
      i1 = 0;
      break label290;
      if (this.jdField_b_of_type_Int == 3)
      {
        if (this.jdField_e_of_type_JavaUtilArrayList.size() < this.jdField_g_of_type_Int) {
          break;
        }
        a(getString(2131720293));
        ReportController.b(null, "dc00899", "Grp_video", "", "invite", "toast_over", 0, 0, this.jdField_c_of_type_JavaLangString, TroopMemberUtil.a(this.app, this.app.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString) + "", "", "");
        return true;
      }
      if (this.jdField_b_of_type_Int == 4)
      {
        if (this.jdField_e_of_type_JavaUtilArrayList.size() < this.jdField_g_of_type_Int) {
          break;
        }
        a(getString(2131720066, new Object[] { Integer.valueOf(this.jdField_g_of_type_Int) }));
        return true;
      }
      if (this.jdField_e_of_type_JavaUtilArrayList.size() < this.jdField_g_of_type_Int) {
        break;
      }
      if (this.jdField_d_of_type_Int == 35) {
        e(2131720325);
      }
      for (;;)
      {
        return true;
        e(2131720293);
      }
      label721:
      if (this.jdField_a_of_type_Int == 9003)
      {
        if (this.jdField_d_of_type_Int == 15)
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.f();
          if (this.jdField_e_of_type_JavaUtilArrayList.size() < paramInt) {
            break;
          }
          a(String.format(getString(2131690757), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.e()) }));
          return true;
        }
        if (this.jdField_d_of_type_Int != 32) {
          break;
        }
        paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.k();
        if (this.jdField_e_of_type_JavaUtilArrayList.size() < paramInt) {
          break;
        }
        a(String.format(getString(2131690757), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.h()) }));
        return true;
      }
      if (this.jdField_e_of_type_JavaUtilArrayList.size() < this.jdField_g_of_type_Int) {
        break;
      }
      i1 = 0;
      paramInt = i1;
      if (this.jdField_l_of_type_Boolean)
      {
        paramInt = i1;
        if (this.jdField_b_of_type_JavaUtilArrayList != null) {
          paramInt = this.jdField_b_of_type_JavaUtilArrayList.size();
        }
      }
      a(String.format(getString(2131694698), new Object[] { Integer.valueOf(paramInt + this.jdField_g_of_type_Int) }));
      return true;
      label938:
      paramBoolean = false;
    }
  }
  
  public boolean a(List<ResultRecord> paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, false);
  }
  
  public boolean a(List<ResultRecord> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.jdField_e_of_type_JavaUtilArrayList.clear();
    }
    HashSet localHashSet = new HashSet(this.jdField_e_of_type_JavaUtilArrayList.size());
    Object localObject = this.jdField_e_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((ResultRecord)((Iterator)localObject).next()).uin);
    }
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashSet.add((String)((Iterator)localObject).next());
      }
    }
    paramList = paramList.iterator();
    do
    {
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label345;
        }
        localObject = (ResultRecord)paramList.next();
        if (!localHashSet.contains(((ResultRecord)localObject).uin))
        {
          if ((a("addFriendResults", paramBoolean2, ((ResultRecord)localObject).uin, ((ResultRecord)localObject).name, ((ResultRecord)localObject).type, ((ResultRecord)localObject).groupUin)) || (a(((ResultRecord)localObject).uin, ((ResultRecord)localObject).name)) || (!b(((ResultRecord)localObject).uin, ((ResultRecord)localObject).name, ((ResultRecord)localObject).type, ((ResultRecord)localObject).groupUin))) {
            break;
          }
          this.jdField_e_of_type_JavaUtilArrayList.add(localObject);
          a((ResultRecord)localObject, true);
          if (this.jdField_a_of_type_Int == 9003) {
            if ((this.jdField_d_of_type_Int == 15) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(((ResultRecord)localObject).uin))) {
              this.jdField_k_of_type_Int += 1;
            } else if ((this.jdField_d_of_type_Int == 32) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(((ResultRecord)localObject).uin))) {
              this.jdField_k_of_type_Int += 1;
            }
          }
        }
      }
    } while (this.jdField_a_of_type_Int == 9003);
    label345:
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(true);
    k();
    r();
    return true;
  }
  
  int b()
  {
    int i2 = 0;
    long l1 = Utils.a();
    Object localObject = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getString("not_admin_invite_member_count", null);
    int i1 = i2;
    if (localObject != null) {}
    try
    {
      localObject = ((String)localObject).split(":");
      i1 = i2;
      if (Long.parseLong(localObject[0]) == l1) {
        i1 = Integer.parseInt(localObject[1]);
      }
      return i1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  protected ArrayList<ResultRecord> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.type == 5)
      {
        if (localResultRecord.uin.startsWith("pstn")) {
          localResultRecord.uin = localResultRecord.uin.substring("pstn".length());
        }
        localArrayList.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  protected void b()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131718990);
    this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_d_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131718990));
    }
    if (c())
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      if (g())
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText("");
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130851150);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new SelectMemberActivity.5(this));
      k();
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("show_invite_entry", false))
      {
        if (this.jdField_d_of_type_Int != 35) {
          break label261;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131718988);
        DataReport.ShareChat.f();
      }
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      if (h())
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690800);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
        break;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130851150);
      break;
      label261:
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131718989);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_d_of_type_Int != 35) {
      return;
    }
    this.q = false;
    c(paramInt);
    t();
  }
  
  public void b(int paramInt, String paramString)
  {
    int i1 = 1;
    if ((QLog.isColorLevel()) || (paramInt != 0)) {
      QLog.w("SelectMemberActivity", 1, "onInviteComplete, retCode[" + paramInt + "], troopUin[" + paramString + "], mSubType[" + this.jdField_b_of_type_Int + "], mEntrance[" + this.jdField_d_of_type_Int + "]");
    }
    if (paramInt == 0) {}
    for (paramInt = i1; paramInt != 0; paramInt = 0)
    {
      a(paramString, false);
      return;
    }
    QQToast.a(this, getString(2131691837), 2000).b(this.jdField_c_of_type_AndroidViewView.getHeight());
  }
  
  public void b(ArrayList<Entity> paramArrayList)
  {
    this.jdField_g_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    boolean bool1;
    Object localObject;
    int i1;
    if (!paramBoolean2)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        bool1 = true;
        this.jdField_a_of_type_Boolean = bool1;
      }
    }
    else
    {
      localObject = this.jdField_f_of_type_AndroidViewView;
      if (!this.jdField_a_of_type_Boolean) {
        break label237;
      }
      i1 = 0;
      label38:
      ((View)localObject).setVisibility(i1);
      a(false, "", "");
      if (!this.jdField_a_of_type_Boolean) {
        break label272;
      }
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
      if (!this.jdField_e_of_type_JavaUtilArrayList.isEmpty()) {
        break label243;
      }
      localObject = getString(2131691164);
      label87:
      if (this.jdField_b_of_type_AndroidWidgetButton != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a();
      if (this.jdField_b_of_type_AndroidWidgetButton != null)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetButton;
        bool1 = bool2;
        if (!this.jdField_e_of_type_JavaUtilArrayList.isEmpty()) {
          bool1 = true;
        }
        ((Button)localObject).setEnabled(bool1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange != null) && (!paramBoolean2)) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange.a(true, paramBoolean2);
      }
      if (!paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(true);
        r();
      }
      p();
      paramBoolean1 = this.jdField_a_of_type_Boolean;
      localObject = getIntent().getStringExtra("group_uin");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ThreadManager.post(new SelectMemberActivity.21(this, paramBoolean1, (String)localObject), 5, null, true);
      }
      return;
      bool1 = false;
      break;
      label237:
      i1 = 8;
      break label38;
      label243:
      localObject = getString(2131691165, new Object[] { Integer.valueOf(this.jdField_e_of_type_JavaUtilArrayList.size()) });
      break label87;
      label272:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_e_of_type_JavaUtilArrayList.size())
      {
        if (((ResultRecord)this.jdField_e_of_type_JavaUtilArrayList.get(i1)).uin.equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  boolean b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool;
    int i1;
    if (paramInt == 5)
    {
      bool = b();
      if (!bool) {
        QQToast.a(this, 2131719011, 1).b(getTitleBarHeight());
      }
      i1 = a(paramString1);
      if (i1 != 0) {
        break label76;
      }
    }
    label76:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        QQToast.a(this, i1, 1).b(getTitleBarHeight());
      }
      if ((!bool) || (paramInt == 0)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ArrayList<ResultRecord> c()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_e_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(this.jdField_e_of_type_JavaUtilArrayList.get(i1));
      i1 += 1;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.uin = str;
        localResultRecord.type = 0;
        localResultRecord.groupUin = "-1";
        localResultRecord.name = ContactUtils.b(this.app, localResultRecord.uin, localResultRecord.type);
        localArrayList.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  void c(int paramInt)
  {
    int i2 = 0;
    int i1 = 0;
    if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_enable_all_select", false)) {}
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin");
    } while ((TextUtils.isEmpty((CharSequence)localObject)) || ((!this.jdField_i_of_type_Boolean) && (!this.jdField_h_of_type_Boolean)));
    if (paramInt != -1)
    {
      if (!this.p) {
        break label263;
      }
      i2 = paramInt - 1;
    }
    for (;;)
    {
      if (i2 <= this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_all_select_max_num", this.jdField_g_of_type_Int)) {
        this.q = true;
      }
      QLog.w("SelectMemberActivity", 1, "isEnableAllSelect, memCount[" + paramInt + "], memFromAPI[" + i1 + "], finalCount[" + i2 + "], mIsSelectAllMembers[" + this.q + "], mShowMyself[" + this.p + "]");
      return;
      if (this.jdField_i_of_type_Boolean)
      {
        DiscussionManager localDiscussionManager = (DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        if (localDiscussionManager == null) {
          break label258;
        }
        i1 = localDiscussionManager.a((String)localObject);
      }
      for (;;)
      {
        i2 = i1 - 1;
        break;
        i1 = i2;
        if (this.jdField_h_of_type_Boolean)
        {
          localObject = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).c((String)localObject);
          i1 = i2;
          if (localObject != null)
          {
            i1 = ((TroopInfo)localObject).wMemberNum;
            continue;
            label258:
            i1 = 0;
          }
        }
      }
      label263:
      i2 = paramInt;
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SelectMemberActivity", 1, "onReusedTroop,troopUin[" + paramString + "], mSubType[" + this.jdField_b_of_type_Int + "], mEntrance[" + this.jdField_d_of_type_Int + "]");
    }
    a(paramString, true);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(paramBoolean);
    }
  }
  
  boolean c()
  {
    if ((g()) || (h())) {}
    while ((this.jdField_d_of_type_Int == 35) || (this.jdField_d_of_type_Int == 40)) {
      return true;
    }
    return false;
  }
  
  public boolean c(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((String)this.jdField_a_of_type_JavaUtilList.get(i1)).equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public ArrayList<String> d()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_e_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((ResultRecord)this.jdField_e_of_type_JavaUtilArrayList.get(i1)).uin);
      i1 += 1;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    }
    return localArrayList;
  }
  
  public void d(String paramString)
  {
    ThreadManagerV2.excute(new SelectMemberActivity.8(this, paramString), 32, null, false);
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager != null) && ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView() instanceof TroopMemberListInnerFrame))) {
      ((TroopMemberListInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).f();
    }
    if (paramBoolean) {
      c(false);
    }
  }
  
  public boolean d()
  {
    this.jdField_e_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(false);
    k();
    r();
    return true;
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
    if (paramInt1 == 10001)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "qqstory create share group result:" + paramInt2);
      }
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    while (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131755155);
    super.doOnCreate(paramBundle);
    i();
    h();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletIToPayManager = ((IToPayManager)QRoute.api(IToPayManager.class));
    if ((this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 36)) {}
    ArrayList localArrayList;
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 1) {
        super.getWindow().addFlags(524288);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      j();
      b();
      l();
      o();
      d();
      g();
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int == 1))
      {
        paramBundle = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (paramBundle != null)
        {
          paramBundle = paramBundle.b(this.jdField_c_of_type_JavaLangString);
          if (paramBundle != null) {
            this.jdField_i_of_type_Int = paramBundle.wMemberNum;
          }
        }
        ThreadManager.post(new SelectMemberActivity.1(this), 8, null, true);
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
      this.jdField_b_of_type_AndroidGraphicsBitmap = ImageUtil.c();
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new SelectMemberActivity.VideoMsgReceiver(this);
        paramBundle = new IntentFilter();
        paramBundle.addAction("tencent.av.v2q.StopVideoChat");
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      }
      if (this.jdField_c_of_type_Int == 30) {
        b(true, true);
      }
      if ((this.jdField_a_of_type_Int != 9003) && (8998 != this.jdField_a_of_type_Int)) {
        break label442;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager = ((BlessManager)this.app.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER));
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a();
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
        break label442;
      }
      paramBundle = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Friends localFriends = paramBundle.e(str);
        if (localFriends != null) {
          localArrayList.add(a(str, localFriends.getFriendNick(), 0, "-1"));
        }
      }
    }
    a(localArrayList, false);
    label442:
    paramBundle = getIntent().getParcelableArrayListExtra("param_selected_records_for_create_discussion");
    if (paramBundle != null) {
      a(paramBundle, false);
    }
    if (this.jdField_c_of_type_Int == 1003) {
      ReportController.b(this.app, "dc00899", "Grp_create", "", "f2f", "clk_f2f_main", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Int == 33) {
        ReportController.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payershowfriendpay.askaio.payershowfriendpay.askaio.payerclickfriendpay.selectpage.show", 0, 0, "", "", "", "");
      }
      return true;
      if (this.jdField_c_of_type_Int == 1002) {
        ReportController.b(this.app, "dc00899", "Grp_create", "", "f2f", "clk_f2f_conta", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.d();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    TroopCreateLogic localTroopCreateLogic = (TroopCreateLogic)this.app.getManager(QQManagerFactory.MGR_TROOP_CREATE);
    if (localTroopCreateLogic != null) {
      localTroopCreateLogic.a(this);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "doOnNewIntent");
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.b();
    b(false);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a();
    b(true);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(48);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.c();
  }
  
  void e(String paramString)
  {
    int i1 = 0;
    if (i1 < this.jdField_e_of_type_JavaUtilArrayList.size())
    {
      if (((ResultRecord)this.jdField_e_of_type_JavaUtilArrayList.get(i1)).uin.equals(paramString))
      {
        this.jdField_e_of_type_JavaUtilArrayList.remove(i1);
        if (this.jdField_a_of_type_Int == 9003) {
          if ((this.jdField_d_of_type_Int != 15) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(paramString))) {
            break label90;
          }
        }
      }
      for (this.jdField_k_of_type_Int -= 1;; this.jdField_k_of_type_Int -= 1) {
        label90:
        do
        {
          i1 += 1;
          break;
        } while ((this.jdField_d_of_type_Int != 32) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(paramString)));
      }
    }
    r();
  }
  
  public boolean e()
  {
    return this.z;
  }
  
  public void f(String paramString)
  {
    if ((this.jdField_d_of_type_Int == 38) || (this.jdField_d_of_type_Int == 29) || (this.jdField_d_of_type_Int == 39))
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label51;
      }
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberActivity", 2, "onRelationTroopItemClick: empty");
      }
    }
    return;
    label51:
    if (QLog.isColorLevel()) {
      QLog.i("SelectMemberActivity", 2, "onRelationTroopItemClick: troopUin:" + paramString);
    }
    c(paramString);
  }
  
  boolean f()
  {
    boolean bool = g();
    int i2 = this.jdField_e_of_type_JavaUtilArrayList.size();
    if (this.jdField_b_of_type_JavaUtilArrayList != null) {}
    for (int i1 = this.jdField_b_of_type_JavaUtilArrayList.size(); (bool) && (this.jdField_b_of_type_Int == 0) && (i1 + i2 >= 1); i1 = 0) {
      return true;
    }
    return false;
  }
  
  public void finish()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("SelectMemberActivity", 1, "finish", new Throwable("打印调用栈"));
    }
    ForwardRecentActivity.a(this.jdField_a_of_type_AndroidContentIntent, this);
    super.finish();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      overridePendingTransition(0, 2130771980);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a()) {
        runOnUiThread(new SelectMemberActivity.16(this));
      }
      return;
      overridePendingTransition(2130771990, 2130771991);
      continue;
      overridePendingTransition(0, 2130772003);
      continue;
      overridePendingTransition(0, 0);
    }
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(this);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(this.app);
    if (this.jdField_c_of_type_Int == 30)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(9, this.jdField_a_of_type_AndroidContentIntent.getExtras());
      return;
    }
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, this.jdField_a_of_type_AndroidContentIntent.getExtras());
      return;
    }
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, this.jdField_a_of_type_AndroidContentIntent.getExtras());
      return;
    }
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
  }
  
  boolean g()
  {
    return (this.jdField_d_of_type_Int == 27) || (this.jdField_d_of_type_Int == 28) || (this.jdField_d_of_type_Int == 12) || (this.jdField_d_of_type_Int == 29) || (this.jdField_d_of_type_Int == 39);
  }
  
  protected void h()
  {
    try
    {
      setContentView(2131562999);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.e("SelectMemberActivity", 1, "setContentView IllegalStateException", localIllegalStateException);
    }
  }
  
  boolean h()
  {
    return (this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int == 1);
  }
  
  protected void i()
  {
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_type");
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_subtype");
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_from");
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_entrance", 0);
    this.w = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("filer_robot", false);
    this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_selected_default");
    this.jdField_c_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_selected_friends");
    this.jdField_d_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_hide");
    if (this.jdField_d_of_type_JavaUtilArrayList == null) {
      this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_d_of_type_JavaUtilArrayList.add(AppConstants.BABY_Q_UIN);
    Object localObject2 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((TroopManager)localObject2).a();
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject1).next();
        if (localTroopInfo.isQidianPrivateTroop()) {
          this.jdField_d_of_type_JavaUtilArrayList.add(localTroopInfo.troopuin);
        }
      }
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("param_groupcode");
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getExtras().getBoolean("param_is_troop_admin", true);
    this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_max", 2147483647);
    int i1;
    if ((localObject2 != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.equals("0", this.jdField_c_of_type_JavaLangString)))
    {
      localObject1 = ((TroopManager)localObject2).b(this.jdField_c_of_type_JavaLangString);
      if (localObject1 != null)
      {
        i1 = ((TroopInfo)localObject1).wMemberMax - ((TroopInfo)localObject1).wMemberNum;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mMaxSelectNumber:").append(this.jdField_g_of_type_Int).append(" remain:").append(i1).append("  wMemberMax:").append(((TroopInfo)localObject1).wMemberMax).append("  wMemberNum:").append(((TroopInfo)localObject1).wMemberNum).append("  real mMaxSelectNumber").append(Math.min(this.jdField_g_of_type_Int, i1));
          QLog.d("SelectMemberActivity", 2, ((StringBuilder)localObject2).toString());
        }
        if ((i1 > 0) && (this.jdField_g_of_type_Int > i1))
        {
          this.jdField_g_of_type_Int = i1;
          this.o = true;
        }
      }
    }
    this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_min", 1);
    this.p = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_show_myself", false);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_contacts", false);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_troop", false);
    this.jdField_f_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_discussion", false);
    this.jdField_g_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_friends", false);
    this.jdField_h_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_troop_member", false);
    this.jdField_i_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_discussion_member", false);
    this.jdField_k_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_troop_or_discussion_member", false);
    this.jdField_j_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_face_to_face_troop", false);
    this.jdField_l_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_overload_tips_include_default_count", false);
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_title");
    if (this.jdField_d_of_type_JavaLangString == null) {
      this.jdField_d_of_type_JavaLangString = getString(2131718985);
    }
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_done_button_wording");
    if (this.jdField_e_of_type_JavaLangString == null) {
      this.jdField_e_of_type_JavaLangString = getString(2131718997);
    }
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_done_button_highlight_wording");
    if (this.jdField_f_of_type_JavaLangString == null) {
      this.jdField_f_of_type_JavaLangString = (this.jdField_e_of_type_JavaLangString + "({0})");
    }
    this.m = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_add_passed_members_to_result_set", false);
    this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_exit_animation", 0);
    this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_back_button_side", 1);
    this.u = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_put_myself_first", false);
    this.v = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_forbid_only_choose_myself", false);
    if ((this.jdField_d_of_type_Int == 14) || (this.jdField_d_of_type_Int == 21))
    {
      localObject1 = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("param_default_selected_troop_members");
      if (localObject1 != null) {
        localObject1 = ((ArrayList)localObject1).iterator();
      }
    }
    else
    {
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResultRecord)((Iterator)localObject1).next();
        this.jdField_e_of_type_JavaUtilArrayList.add(localObject2);
        continue;
        if (((this.jdField_d_of_type_Int == 32) || (this.jdField_d_of_type_Int == 43) || (this.jdField_d_of_type_Int == 35)) && ((this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean)))
        {
          c(-1);
          localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!this.q) && (this.jdField_c_of_type_JavaUtilArrayList != null))
          {
            i1 = 0;
            if (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
            {
              if (!TextUtils.isEmpty((CharSequence)this.jdField_c_of_type_JavaUtilArrayList.get(i1)))
              {
                localObject2 = new ResultRecord();
                ((ResultRecord)localObject2).uin = ((String)this.jdField_c_of_type_JavaUtilArrayList.get(i1));
                if (!this.jdField_i_of_type_Boolean) {
                  break label1061;
                }
              }
              label1061:
              for (int i2 = 2;; i2 = 1)
              {
                ((ResultRecord)localObject2).type = i2;
                ((ResultRecord)localObject2).groupUin = ((String)localObject1);
                this.jdField_e_of_type_JavaUtilArrayList.add(localObject2);
                i1 += 1;
                break;
              }
            }
          }
        }
        else if ((this.jdField_d_of_type_Int == 17) && (this.jdField_c_of_type_JavaUtilArrayList != null))
        {
          i1 = 0;
          while (i1 < this.jdField_c_of_type_JavaUtilArrayList.size())
          {
            if (!TextUtils.isEmpty((CharSequence)this.jdField_c_of_type_JavaUtilArrayList.get(i1)))
            {
              localObject1 = new ResultRecord();
              ((ResultRecord)localObject1).uin = ((String)this.jdField_c_of_type_JavaUtilArrayList.get(i1));
              this.jdField_e_of_type_JavaUtilArrayList.add(localObject1);
            }
            i1 += 1;
          }
        }
      }
    }
    this.r = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_support_select_from_friend_groups", false);
    QLog.d("SelectMemberActivity", 1, String.format("getIntentExtras [%d,%d,%d,%d,%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int), this.jdField_c_of_type_JavaLangString }));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  @TargetApi(14)
  protected void j()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131377356);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        localRelativeLayout.setFitsSystemWindows(true);
      }
      localRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_c_of_type_AndroidViewView = findViewById(2131379451);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369534));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369487));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369489));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369518));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar = ((SelectedAndSearchBar)findViewById(2131377744));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370485));
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = ((InnerFrameManager)findViewById(2131381607));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376997);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131379637);
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    }
    this.jdField_e_of_type_AndroidViewView = findViewById(2131379638);
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365461);
    if (c())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365460));
      if (this.jdField_d_of_type_Int != 35) {
        break label476;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_e_of_type_JavaLangString);
    }
    label476:
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_d_of_type_Int == 40) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      NewTroopContactView.setCreateTroopButtonEnable(this.jdField_a_of_type_AndroidWidgetButton, bool);
      if (g())
      {
        int i1 = getIntent().getIntExtra("create_source", 0);
        ReportController.b(this.app, "dc00899", "Grp_create_new", "", "create_page", "exp_chose", 0, 0, "", "" + i1, "", "");
      }
      for (;;)
      {
        this.jdField_f_of_type_AndroidViewView = findViewById(2131377745);
        this.jdField_g_of_type_AndroidViewView = findViewById(2131367082);
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364053));
        if (this.jdField_b_of_type_AndroidWidgetButton != null) {
          this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        }
        return;
        if (h())
        {
          this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131713674));
          n();
        }
      }
    }
  }
  
  protected void k()
  {
    if (this.jdField_c_of_type_Int == 30) {
      return;
    }
    if (this.jdField_e_of_type_JavaUtilArrayList.size() >= this.jdField_h_of_type_Int)
    {
      a(true);
      return;
    }
    a(false);
  }
  
  @SuppressLint({"NewApi"})
  protected void l()
  {
    if (QQGameTroopManager.b(this)) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.setIsFrom(1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(this.jdField_e_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$ISelectedAndSearchBarCallback);
    if (((this.jdField_e_of_type_JavaUtilArrayList.size() != 0) && ((this.jdField_d_of_type_Int == 14) || (this.jdField_d_of_type_Int == 21) || (this.jdField_d_of_type_Int == 43))) || (this.jdField_d_of_type_Int == 32))
    {
      Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if ((this.jdField_d_of_type_Int == 32) || (this.jdField_d_of_type_Int == 43))
        {
          if (localResultRecord.type == 1) {
            localResultRecord.name = ContactUtils.g(this.app, localResultRecord.groupUin, localResultRecord.uin);
          } else if (localResultRecord.type == 2) {
            localResultRecord.name = ContactUtils.a(this.app, localResultRecord.groupUin, localResultRecord.uin);
          }
        }
        else {
          localResultRecord.name = ContactUtils.g(this.app, localResultRecord.groupUin, localResultRecord.uin);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(true);
      a(this, "", 1);
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new SelectMemberActivity.6(this));
  }
  
  protected void m()
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1500L) {}
    TroopCreateLogic localTroopCreateLogic;
    do
    {
      return;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      localTroopCreateLogic = (TroopCreateLogic)this.app.getManager(QQManagerFactory.MGR_TROOP_CREATE);
    } while (localTroopCreateLogic == null);
    Object localObject = new JSONObject();
    label529:
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("group_type", 1);
        ((JSONObject)localObject).put("name", ContactUtils.h(this.app, this.app.getCurrentAccountUin()) + HardCodeUtil.a(2131713693));
        ((JSONObject)localObject).put("classify", 10010);
        if ((this.jdField_d_of_type_Int != 12) && (this.jdField_d_of_type_Int != 36)) {
          ((JSONObject)localObject).put("isJumpAio", 1);
        }
        i1 = this.jdField_d_of_type_Int;
        if (i1 == 12) {
          i1 = 3;
        }
        ArrayList localArrayList;
        String str;
        ResultRecord localResultRecord;
        if (this.jdField_c_of_type_Int != 1002) {
          break;
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          ((JSONObject)localObject).put("create_source", i1);
          localTroopCreateLogic.a(((JSONObject)localObject).toString(), 5);
          ReportController.b(this.app, "dc00899", "Grp_create_new", "", "create_page", "clk_now", 0, 0, "", "" + i1, "", "");
          localArrayList = new ArrayList(this.jdField_e_of_type_JavaUtilArrayList.size());
          localArrayList.addAll(this.jdField_e_of_type_JavaUtilArrayList);
          if (this.jdField_b_of_type_JavaUtilArrayList == null) {
            continue;
          }
          localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject).hasNext()) {
            continue;
          }
          str = (String)((Iterator)localObject).next();
          localResultRecord = new ResultRecord();
          localResultRecord.uin = str;
          localResultRecord.type = 0;
          localResultRecord.groupUin = "-1";
          localResultRecord.name = ContactUtils.b(this.app, localResultRecord.uin, localResultRecord.type);
          localArrayList.add(localResultRecord);
          continue;
          if (this.jdField_d_of_type_Int == 28)
          {
            i1 = 5;
            continue;
          }
          if (this.jdField_d_of_type_Int == 39)
          {
            i1 = 8;
            continue;
          }
          if (this.jdField_d_of_type_Int == 29)
          {
            i1 = 2;
            continue;
          }
          if (this.jdField_d_of_type_Int != 27) {
            break label529;
          }
          i1 = getIntent().getIntExtra("create_source", 0);
          continue;
          localJSONException1 = localJSONException1;
          i1 = 0;
        }
        catch (JSONException localJSONException2)
        {
          continue;
          int i1 = 0;
        }
        QLog.e("SelectMemberActivity", 1, "createNewTypeDiscussion json error!", localJSONException1);
        continue;
        localTroopCreateLogic.a(this, this, localJSONException1);
        if (this.jdField_c_of_type_Int == 1003)
        {
          ReportController.b(this.app, "dc00899", "Grp_create", "", "choose_cre", "clk_cre_main", 0, 0, "", "", "", "");
          return;
        }
      }
      ReportController.b(this.app, "dc00899", "Grp_create", "", "choose_cre", "clk_cre_conta", 0, 0, "", "", "", "");
      return;
    }
  }
  
  protected void n()
  {
    Object localObject = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_c_of_type_JavaLangString);
    boolean bool1;
    if (localObject != null)
    {
      if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x6100000) != 0L) {
        break label231;
      }
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (bool1)
      {
        if (!((TroopInfo)localObject).isAdmin()) {
          bool2 = true;
        }
      }
      else
      {
        label55:
        if (((TroopInfo)localObject).maxInviteMemNum <= 0) {
          break label476;
        }
        if (((TroopInfo)localObject).wMemberNum + this.jdField_e_of_type_JavaUtilArrayList.size() <= ((TroopInfo)localObject).maxInviteMemNum) {
          break label340;
        }
        bool1 = true;
      }
      for (;;)
      {
        label83:
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "refreshInviteTipsBar needAdminCheck = " + bool2 + " needAgree = " + bool1);
        }
        if ((!bool2) && (!bool1))
        {
          this.x = false;
          if ((this.jdField_d_of_type_Int == 11) || (this.jdField_d_of_type_Int == 36)) {
            this.jdField_g_of_type_JavaLangString = getString(2131695573);
          }
        }
        for (;;)
        {
          if ((this.y) || (!this.x) || (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))) {
            break label466;
          }
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          localObject = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131379639);
          ((TextView)localObject).setText(this.jdField_h_of_type_JavaLangString);
          ((TextView)localObject).setContentDescription(this.jdField_h_of_type_JavaLangString);
          return;
          label231:
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x2000000) == 33554432L)
          {
            if (((TroopInfo)localObject).wMemberNum + this.jdField_e_of_type_JavaUtilArrayList.size() > 50)
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          }
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x4000000) == 67108864L)
          {
            if (((TroopInfo)localObject).wMemberNum + this.jdField_e_of_type_JavaUtilArrayList.size() > 100)
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          }
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x100000) != 1048576L) {
            break label481;
          }
          bool1 = false;
          break;
          bool2 = false;
          break label55;
          label340:
          bool1 = false;
          break label83;
          this.jdField_g_of_type_JavaLangString = HardCodeUtil.a(2131713701);
          continue;
          if ((!bool2) && (bool1))
          {
            this.x = true;
            this.jdField_h_of_type_JavaLangString = HardCodeUtil.a(2131713682);
            this.jdField_g_of_type_JavaLangString = HardCodeUtil.a(2131713711);
          }
          else if ((bool2) && (bool1))
          {
            this.x = true;
            this.jdField_h_of_type_JavaLangString = HardCodeUtil.a(2131713698);
            this.jdField_g_of_type_JavaLangString = HardCodeUtil.a(2131713687);
          }
          else if ((bool2) && (!bool1))
          {
            this.x = true;
            this.jdField_h_of_type_JavaLangString = HardCodeUtil.a(2131713678);
            this.jdField_g_of_type_JavaLangString = HardCodeUtil.a(2131713689);
          }
        }
        label466:
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        return;
        label476:
        bool1 = false;
      }
      label481:
      bool1 = false;
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    }
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new SelectMemberActivity.10(this));
  }
  
  public boolean onBackEvent()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a()))
    {
      p();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a()) {
      p();
    }
    switch (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())
    {
    }
    for (;;)
    {
      return super.onBackEvent();
      q();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      return true;
      if (this.jdField_k_of_type_Boolean)
      {
        if (this.jdField_d_of_type_Int == 27)
        {
          this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_e_of_type_JavaUtilArrayList);
          ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
          setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
        }
        finish();
      }
      for (;;)
      {
        return true;
        q();
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      }
      if (this.jdField_h_of_type_Boolean) {
        finish();
      }
      for (;;)
      {
        return true;
        q();
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
      }
      if (this.jdField_i_of_type_Boolean) {
        finish();
      }
      for (;;)
      {
        return true;
        q();
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
      }
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      return true;
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    label157:
    ResultRecord localResultRecord;
    Intent localIntent;
    int i1;
    switch (paramView.getId())
    {
    default: 
    case 2131379638: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.y = true;
        ReportController.b(this.app, "dc00899", "invite_friend", "", "friend_list", "Clk_close", 0, 0, this.jdField_c_of_type_JavaLangString, TroopMemberUtil.a(this.app, this.app.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString) + "", "", "");
      }
    case 2131365460: 
      if (this.jdField_d_of_type_Int == 35)
      {
        if (this.jdField_e_of_type_JavaUtilArrayList.size() >= 1)
        {
          localObject1 = "1";
          ReportController.b(this.app, "CliOper", "", "", "0X8009E2B", "0X8009E2B", 0, 0, (String)localObject1, "", "", "");
        }
      }
      else
      {
        if ((this.jdField_d_of_type_Int != 12) || (this.jdField_e_of_type_JavaUtilArrayList.size() != 1)) {
          break label460;
        }
        localResultRecord = (ResultRecord)this.jdField_e_of_type_JavaUtilArrayList.get(0);
        localIntent = new Intent();
        localIntent.putExtra("select_memeber_single_friend", true);
        localIntent.putExtra("select_memeber_single_friend_type", localResultRecord.type);
        if ((localResultRecord.type == 0) && (localResultRecord.type != 1)) {
          break label809;
        }
        i1 = 1000;
      }
      break;
    }
    for (Object localObject1 = a(localResultRecord.groupUin);; localObject1 = null)
    {
      if (localResultRecord.type == 2)
      {
        localObject1 = localResultRecord.groupUin;
        i1 = 1004;
      }
      for (;;)
      {
        if (localResultRecord.type == 3) {
          i1 = 1021;
        }
        for (;;)
        {
          Object localObject2 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(localResultRecord.uin);
          int i2 = i1;
          if (localObject2 != null)
          {
            i2 = i1;
            if (((Friends)localObject2).isFriend()) {
              i2 = 0;
            }
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("uin", localResultRecord.uin);
          ((Bundle)localObject2).putInt("uintype", i2);
          ((Bundle)localObject2).putString("uinname", localResultRecord.name);
          ((Bundle)localObject2).putString("troop_uin", (String)localObject1);
          localIntent.putExtras((Bundle)localObject2);
          setResult(-1, localIntent);
          finish();
          break;
          localObject1 = "2";
          break label157;
          if (localResultRecord.type == 4)
          {
            i1 = 1006;
            continue;
            label460:
            if (g())
            {
              m();
              break;
            }
            if (h())
            {
              if (this.jdField_d_of_type_Int == 11)
              {
                localObject1 = a();
                if (((ArrayList)localObject1).size() > 0)
                {
                  DialogUtil.a(this, 230, getString(2131695677), getString(2131695555), 2131695411, 2131695423, new SelectMemberActivity.18(this, (ArrayList)localObject1), new SelectMemberActivity.19(this)).show();
                  break;
                }
                a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin"), false);
                break;
              }
              if (this.jdField_d_of_type_Int == 37)
              {
                this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_e_of_type_JavaUtilArrayList);
                setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
                finish();
                break;
              }
              a(this.jdField_e_of_type_JavaUtilArrayList);
              break;
            }
            this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_e_of_type_JavaUtilArrayList);
            setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
            finish();
            break;
            p();
            if (a().size() == 1)
            {
              localObject1 = (String)a().get(0);
              if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange.b((String)localObject1);
              break;
            }
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("TROOP_UIN", this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin"));
            ((Intent)localObject1).putExtra("hide_title_left_arrow", true);
            PublicFragmentActivity.a(this, (Intent)localObject1, UnitedVerifyMsgEditFragment.class, 10);
            overridePendingTransition(2130771999, 2130771992);
            localObject1 = getIntent().getStringExtra("group_uin");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            ThreadManager.post(new SelectMemberActivity.20(this, (String)localObject1), 5, null, true);
            break;
          }
        }
      }
      label809:
      i1 = 0;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onRestart()
  {
    super.onRestart();
  }
  
  void p()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.b();
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.z = false;
  }
  
  public void q()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  protected void r()
  {
    boolean bool = false;
    String str = null;
    Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    ResultRecord localResultRecord;
    if (localIterator.hasNext())
    {
      localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.type != 5) {
        break label365;
      }
      if (i1 >= 3) {
        new StringBuilder().append(str).append("…").toString();
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.a(a(), this.jdField_b_of_type_JavaUtilArrayList);
      }
      if (c())
      {
        i1 = this.jdField_e_of_type_JavaUtilArrayList.size();
        if (i1 <= 0) {
          break label278;
        }
        if ((this.jdField_d_of_type_Int != 35) && (this.jdField_d_of_type_Int != 40)) {
          break label235;
        }
        str = MessageFormat.format(this.jdField_f_of_type_JavaLangString, new Object[] { Integer.valueOf(i1) });
        this.jdField_a_of_type_AndroidWidgetButton.setText(str);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(str);
        NewTroopContactView.setCreateTroopButtonEnable(this.jdField_a_of_type_AndroidWidgetButton, true);
      }
      if (h()) {
        n();
      }
      return;
    }
    if (str == null)
    {
      str = localResultRecord.name;
      label196:
      i1 += 1;
    }
    label235:
    label365:
    for (;;)
    {
      break;
      str = str + "、" + localResultRecord.name;
      break label196;
      if (g()) {}
      for (str = HardCodeUtil.a(2131713707);; str = HardCodeUtil.a(2131713684))
      {
        str = MessageFormat.format(str, new Object[] { Integer.valueOf(i1) });
        break;
      }
      if (this.jdField_d_of_type_Int == 35)
      {
        str = this.jdField_e_of_type_JavaLangString;
        bool = true;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(str);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(str);
        NewTroopContactView.setCreateTroopButtonEnable(this.jdField_a_of_type_AndroidWidgetButton, bool);
        break;
        if (this.jdField_d_of_type_Int == 40) {
          str = this.jdField_e_of_type_JavaLangString;
        } else if (g()) {
          str = HardCodeUtil.a(2131713675);
        } else {
          str = HardCodeUtil.a(2131713709);
        }
      }
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  protected void s()
  {
    if ((this.jdField_e_of_type_JavaUtilArrayList != null) && (this.jdField_e_of_type_JavaUtilArrayList.size() > 0))
    {
      Object localObject = b();
      Intent localIntent = new Intent("tencent.video.q2v.SelectMember");
      localIntent.setPackage(this.app.getApplication().getPackageName());
      if (((ArrayList)localObject).size() > 0) {
        localIntent.putParcelableArrayListExtra("SelectMemberList", (ArrayList)localObject);
      }
      int i1 = this.jdField_e_of_type_JavaUtilArrayList.size();
      localObject = ((ResultRecord)this.jdField_e_of_type_JavaUtilArrayList.get(0)).name;
      localIntent.putExtra("InviteCount", i1);
      localIntent.putExtra("FirstName", (String)localObject);
      this.app.getApp().sendBroadcast(localIntent);
    }
  }
  
  void t()
  {
    int i1 = 0;
    if (this.jdField_d_of_type_Int != 35) {}
    RelativeLayout localRelativeLayout;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_enable_all_select", false));
      localRelativeLayout = (RelativeLayout)findViewById(2131377278);
    } while (localRelativeLayout == null);
    if (this.q) {}
    for (;;)
    {
      localRelativeLayout.setVisibility(i1);
      return;
      i1 = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */