package com.tencent.mobileqq.activity.selectmember;

import QQService.AddDiscussMemberInfo;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.os.ResultReceiver;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.QCallFacade;
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
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.groupvideo.GroupVideoWrapper;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import xww;
import xwx;
import xwy;
import xwz;
import xxa;
import xxb;
import xxc;
import xxd;
import xxe;
import xxf;
import xxg;
import xxh;
import xxi;
import xxj;
import xxk;
import xxm;
import xxn;
import xxo;
import xxp;
import xxq;
import xxs;
import xxt;
import xxu;
import xxv;
import xxw;
import xxx;
import xya;

public class SelectMemberActivity
  extends FragmentActivity
  implements View.OnClickListener, ContactSearchResultPresenter.OnActionListener, TroopCreateLogic.TroopCreateCallback
{
  public static boolean f;
  boolean A = false;
  boolean B;
  protected float a;
  private int jdField_a_of_type_Int;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Intent a;
  protected Bitmap a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public final Handler a;
  protected View a;
  InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
  protected Button a;
  public EditText a;
  public GridView a;
  protected ImageView a;
  protected LinearLayout a;
  protected ProgressBar a;
  protected TextView a;
  private QavWrapper jdField_a_of_type_ComTencentAvServiceQavWrapper;
  public InnerFrameManager a;
  protected ChatActivityUtils.StartVideoListener a;
  public BlessManager a;
  public SelectMemberActivity.GridViewAdapter a;
  SelectMemberActivity.IOnSelectStateChange jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  public ContactSearchFragment a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public CustomHorizontalScrollView a;
  public QQProgressDialog a;
  private GroupVideoWrapper jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper;
  public List a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  public Dialog b;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  public View b;
  private Button jdField_b_of_type_AndroidWidgetButton;
  protected ImageView b;
  public TextView b;
  public int c;
  private long c;
  public View c;
  public TextView c;
  public String c;
  public int d;
  public View d;
  protected TextView d;
  String d;
  public int e;
  protected View e;
  public TextView e;
  String e;
  public int f;
  View jdField_f_of_type_AndroidViewView;
  protected TextView f;
  String jdField_f_of_type_JavaLangString;
  public ArrayList f;
  public int g;
  private View g;
  public String g;
  public ArrayList g;
  public boolean g;
  int jdField_h_of_type_Int;
  String jdField_h_of_type_JavaLangString = "";
  public ArrayList h;
  boolean jdField_h_of_type_Boolean;
  public int i;
  public ArrayList i;
  boolean i;
  protected int j;
  public ArrayList j;
  boolean j;
  public int k;
  public ArrayList k;
  boolean k;
  public int l;
  boolean l;
  boolean m;
  boolean n;
  boolean o;
  boolean p;
  boolean q;
  public boolean r = true;
  public boolean s;
  public boolean t;
  public boolean u = true;
  public boolean v;
  public boolean w = true;
  public boolean x;
  public boolean y;
  boolean z = false;
  
  public SelectMemberActivity()
  {
    this.jdField_i_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 9223372036854775807L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_JavaLangString = "加群邀请已发送";
    this.jdField_l_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener = new xxc(this);
    this.jdField_a_of_type_AndroidOsHandler = new xxk(this, Looper.getMainLooper());
  }
  
  public static ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.jdField_a_of_type_JavaLangString = paramString1;
    localResultRecord.b = paramString2;
    localResultRecord.jdField_a_of_type_Int = paramInt;
    localResultRecord.jdField_c_of_type_JavaLangString = paramString3;
    return localResultRecord;
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
    Object localObject = ((TroopManager)this.app.getManager(51)).b(paramString);
    ArrayList localArrayList;
    Iterator localIterator;
    if (localObject == null)
    {
      localObject = "";
      localArrayList = new ArrayList();
      localIterator = this.jdField_i_of_type_JavaUtilArrayList.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label162;
      }
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.jdField_a_of_type_Int == 5)
      {
        if (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("pstn")) {
          localResultRecord.jdField_a_of_type_JavaLangString = localResultRecord.jdField_a_of_type_JavaLangString.substring("pstn".length());
        }
        localArrayList.add(localResultRecord.jdField_a_of_type_JavaLangString);
        continue;
        localObject = ((TroopInfo)localObject).troopname;
        break;
      }
      if ((localResultRecord.jdField_a_of_type_Int == 4) && (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("+"))) {
        localArrayList.add(localResultRecord.jdField_a_of_type_JavaLangString);
      }
    }
    label162:
    this.jdField_a_of_type_AndroidContentIntent.putExtra("roomId", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("discussName", (String)localObject);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("qqPhoneUserList", localArrayList);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("audioType", 2);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("callType", 2);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("reportType", this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("result_uin", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("result_uintype", 1);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("result_name", (String)localObject);
    if (this.jdField_f_of_type_Int == 18) {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("from", 3);
    }
    for (;;)
    {
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false)) {
        b(true, Long.parseLong(paramString), localArrayList);
      }
      if (this.jdField_f_of_type_Int == 27) {
        TroopUtils.a(this, paramString);
      }
      finish();
      return;
      if (this.jdField_f_of_type_Int == 10) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("from", 6);
      } else if (this.jdField_f_of_type_Int == 12) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("select_memeber_discussion_memeber_count", this.jdField_i_of_type_JavaUtilArrayList.size() + 1);
      } else if (this.jdField_f_of_type_Int != 13) {}
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i1 = this.jdField_i_of_type_JavaUtilArrayList.size();
    String str1;
    if (i1 <= 1) {
      if (this.jdField_d_of_type_Int == 3)
      {
        String str2 = this.jdField_e_of_type_JavaLangString;
        str1 = str2;
        if (i1 != 1)
        {
          paramBoolean = false;
          str1 = str2;
        }
        if (!paramBoolean) {
          break label227;
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
      if (AppSetting.b) {
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_e_of_type_JavaLangString + ",已选择" + i1 + "人");
      }
      return;
      if (((this.jdField_f_of_type_Int == 25) && (i1 == 1)) || ((e()) && (i1 == 1)))
      {
        str1 = MessageFormat.format(this.jdField_f_of_type_JavaLangString, new Object[] { Integer.valueOf(i1) });
        break;
      }
      str1 = this.jdField_e_of_type_JavaLangString;
      break;
      if (this.jdField_d_of_type_Int == 3)
      {
        str1 = this.jdField_e_of_type_JavaLangString;
        break;
      }
      str1 = MessageFormat.format(this.jdField_f_of_type_JavaLangString, new Object[] { Integer.valueOf(i1) });
      break;
      label227:
      this.jdField_e_of_type_AndroidWidgetTextView.setEnabled(false);
      if (!"1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
        this.jdField_e_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setText(str1);
    }
  }
  
  private boolean a()
  {
    if ((!this.jdField_g_of_type_Boolean) && (b() >= 3)) {}
    return true;
  }
  
  private void b(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false))) {
        str = getString(2131429671);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, str).sendToTarget();
      return;
      str = getString(2131435976);
      continue;
      str = getString(2131435975);
      continue;
      str = getString(2131435977);
      continue;
      str = getString(2131435978);
      continue;
      str = getString(2131435983);
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    int i1;
    if (this.jdField_d_of_type_Int == 1) {
      if (this.jdField_a_of_type_ComTencentAvServiceQavWrapper != null) {
        i1 = this.jdField_a_of_type_ComTencentAvServiceQavWrapper.a(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), this.jdField_c_of_type_Int) + 0;
      }
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_i_of_type_JavaUtilArrayList.iterator();
      label50:
      int i2;
      if (localIterator.hasNext()) {
        if (((ResultRecord)localIterator.next()).jdField_a_of_type_Int == 5)
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
        i1 = this.jdField_a_of_type_CooperationGroupvideoGroupVideoWrapper.a(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), this.jdField_c_of_type_Int) + 0;
        break;
        break label50;
        i2 = i1;
      }
      label141:
      i1 = 0;
    }
  }
  
  private void c(int paramInt)
  {
    a(getString(paramInt));
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "sendIsResumeBroadcast isNeedSend = " + this.w + " ,isResume = " + paramBoolean);
    }
    if (this.w) {
      SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_AndroidAppDialog != null)
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    this.jdField_b_of_type_AndroidAppDialog = new Dialog(this, 2131624515);
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2130971460);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131362758));
    this.jdField_f_of_type_AndroidWidgetTextView.setText(getString(2131434436));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131362757));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131374062));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  private void t()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new xxg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new xxi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new xxj(this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public int a(String paramString)
  {
    switch (PstnUtils.a(paramString.substring("pstn".length()), true))
    {
    case 0: 
    default: 
      return 0;
    case -1: 
      return 2131435987;
    case 1: 
      return 2131435988;
    case 2: 
      return 2131435989;
    case 3: 
      return 2131435990;
    case 4: 
      return 2131435991;
    case 5: 
      return 2131435992;
    }
    return 2131435993;
  }
  
  public ResultRecord a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.jdField_a_of_type_JavaLangString = paramString1;
    localResultRecord.b = paramString2;
    localResultRecord.jdField_a_of_type_Int = paramInt;
    localResultRecord.jdField_c_of_type_JavaLangString = paramString3;
    localResultRecord.jdField_d_of_type_JavaLangString = paramString4;
    return localResultRecord;
  }
  
  public String a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(51);
    if (localTroopManager != null)
    {
      paramString = localTroopManager.a(paramString);
      if (paramString != null) {
        return paramString.troopcode;
      }
    }
    return null;
  }
  
  protected ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_i_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.jdField_a_of_type_Int == 5)
      {
        if (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("pstn")) {
          localResultRecord.jdField_a_of_type_JavaLangString = localResultRecord.jdField_a_of_type_JavaLangString.substring("pstn".length());
        }
        localArrayList.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_i_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString);
      i1 += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_c_of_type_Int == 3000) && (e()))
    {
      k();
      return;
    }
    Object localObject1;
    label180:
    Object localObject2;
    Object localObject3;
    int i3;
    int i2;
    int i1;
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin");
      if ((localObject1 != null) && (this.jdField_f_of_type_Int == 32) && ((this.jdField_l_of_type_Boolean) || (this.m)))
      {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("group_uin", (String)localObject1);
        if (!this.jdField_l_of_type_Boolean) {
          break label1585;
        }
        localObject1 = ((TroopManager)this.app.getManager(51)).b((String)localObject1);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("group_type", 4);
        if (localObject1 != null)
        {
          this.jdField_a_of_type_AndroidContentIntent.putExtra("group_name", ((TroopInfo)localObject1).troopname);
          this.jdField_a_of_type_AndroidContentIntent.putExtra("group_member_type", ((TroopInfo)localObject1).wMemberNum);
        }
      }
      this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_i_of_type_JavaUtilArrayList);
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      finish();
      return;
    case 3000: 
      if (this.q)
      {
        localObject1 = this.jdField_f_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject3 = new ResultRecord();
          ((ResultRecord)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
          ((ResultRecord)localObject3).jdField_a_of_type_Int = 0;
          ((ResultRecord)localObject3).jdField_c_of_type_JavaLangString = "-1";
          this.jdField_i_of_type_JavaUtilArrayList.add(localObject3);
        }
      }
      localObject1 = (FriendsManager)this.app.getManager(50);
      i3 = this.jdField_i_of_type_JavaUtilArrayList.size();
      localObject2 = this.jdField_i_of_type_JavaUtilArrayList.iterator();
      i2 = 0;
      i1 = 0;
      label350:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ResultRecord)((Iterator)localObject2).next();
        if (((ResultRecord)localObject3).jdField_a_of_type_Int == 3) {
          i2 = 1;
        }
        if (((ResultRecord)localObject3).jdField_a_of_type_Int != 5)
        {
          i1 = 1;
          if ((i2 == 0) || (i1 == 0)) {
            break;
          }
        }
      }
      label394:
      break;
    }
    for (;;)
    {
      if (i2 != 0)
      {
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "0", "", "", "");
        label437:
        if ((this.jdField_d_of_type_Int != 0) || (i3 != 1) || ((this.jdField_f_of_type_Int == 10) && (this.jdField_f_of_type_Int != 13)) || (i1 == 0)) {
          break label1082;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "start C2C conversation");
        }
        localObject2 = new Intent(this, SplashActivity.class);
        AIOUtils.a((Intent)localObject2, null);
        ((Intent)localObject2).putExtra("uin", ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject3 = ((FriendsManager)localObject1).c(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
          if (!((FriendsManager)localObject1).b(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString)) {
            break label875;
          }
          ((Intent)localObject2).putExtra("uintype", 0);
        }
      }
      for (;;)
      {
        if (localObject3 != null)
        {
          ((Intent)localObject2).putExtra("cSpecialFlag", ((Friends)localObject3).cSpecialFlag);
          if ((CrmUtils.a(((Friends)localObject3).cSpecialFlag)) || (QidianManager.b(((Friends)localObject3).cSpecialFlag)))
          {
            ((Intent)localObject2).setClass(this, SplashActivity.class);
            ((Intent)localObject2).putExtra("chat_subType", 1);
          }
        }
        ((Intent)localObject2).putExtra("uinname", ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).b);
        if (this.jdField_f_of_type_Int != 13) {
          break label1066;
        }
        localObject1 = null;
        localObject3 = ((Intent)localObject2).getStringExtra("troop_uin");
        i1 = ((Intent)localObject2).getIntExtra("uintype", -1);
        if (i1 == -1) {
          break;
        }
        PhoneContact localPhoneContact = ((PhoneContactManager)this.app.getManager(10)).a(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
        if (localPhoneContact != null) {
          localObject1 = localPhoneContact.nationCode + localPhoneContact.mobileCode;
        }
        localObject2 = new xxd(this, (Intent)localObject2);
        ChatActivityUtils.a(this.app, this, i1, ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString, ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).b, (String)localObject1, true, (String)localObject3, true, true, (ChatActivityUtils.StartVideoListener)localObject2, "from_internal");
        return;
        break label350;
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "1", "", "", "");
        break label437;
        label875:
        if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 1)
        {
          ((Intent)localObject2).putExtra("uintype", 1000);
          localObject1 = a(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_JavaLangString);
          if (localObject1 != null) {
            ((Intent)localObject2).putExtra("troop_uin", (String)localObject1);
          }
        }
        else if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 2)
        {
          ((Intent)localObject2).putExtra("uintype", 1004);
          ((Intent)localObject2).putExtra("troop_uin", ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_JavaLangString);
        }
        else if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 3)
        {
          ((Intent)localObject2).putExtra("uintype", 1021);
        }
        else if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 4)
        {
          ((Intent)localObject2).putExtra("uintype", 1006);
        }
      }
      label1066:
      startActivity((Intent)localObject2);
      this.jdField_g_of_type_Int = 2;
      finish();
      return;
      label1082:
      if ((this.jdField_d_of_type_Int == 0) && (i3 == 1) && (this.jdField_f_of_type_Int == 10) && (i1 != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "start C2C audio");
        }
        if ((((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 0) && (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int != 1)) {
          break label1673;
        }
        localObject1 = a(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_JavaLangString);
        i1 = 1000;
      }
      for (;;)
      {
        if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 2)
        {
          i1 = 1004;
          localObject1 = ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_JavaLangString;
        }
        for (;;)
        {
          if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 3) {
            i1 = 1021;
          }
          for (;;)
          {
            localObject2 = null;
            localObject3 = ((PhoneContactManager)this.app.getManager(10)).a(((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
            if (localObject3 != null) {
              localObject2 = ((PhoneContact)localObject3).nationCode + ((PhoneContact)localObject3).mobileCode;
            }
            localObject3 = new xxe(this);
            ChatActivityUtils.a(this.app, this, i1, ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString, ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).b, (String)localObject2, true, (String)localObject1, true, true, (ChatActivityUtils.StartVideoListener)localObject3, "from_internal");
            return;
            if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 4) {
              i1 = 1006;
            }
          }
          if (this.jdField_d_of_type_Int == 0)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X8005446", "0X8005446", 0, 0, "", "", "", "");
            label1434:
            if (this.jdField_d_of_type_Int != 0) {
              break label1573;
            }
          }
          label1573:
          for (i2 = 2131433967;; i2 = 2131433969)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131558448));
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(i2);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
            if ((this.jdField_d_of_type_Int == 0) || (i1 != 0))
            {
              localObject1 = new xxf(this, (FriendsManager)localObject1);
              ((Thread)localObject1).setName("SelectMemberActivity_addDiscussion");
              ThreadManager.postImmediately((Runnable)localObject1, null, false);
            }
            if (this.jdField_d_of_type_Int == 0) {
              break;
            }
            s();
            if (i1 != 0) {
              break;
            }
            finish();
            return;
            ReportController.b(this.app, "CliOper", "", "", "0X800674C", "0X800674C", 0, 0, "", "", "", "");
            break label1434;
          }
          m();
          return;
          label1585:
          if (!this.m) {
            break label180;
          }
          localObject2 = (DiscussionManager)this.app.getManager(52);
          localObject3 = ((DiscussionManager)localObject2).a((String)localObject1);
          this.jdField_a_of_type_AndroidContentIntent.putExtra("group_type", 8);
          this.jdField_a_of_type_AndroidContentIntent.putExtra("group_member_type", ((DiscussionManager)localObject2).a((String)localObject1));
          if (localObject3 == null) {
            break label180;
          }
          this.jdField_a_of_type_AndroidContentIntent.putExtra("group_name", ((DiscussionInfo)localObject3).discussionName);
          break label180;
        }
        label1673:
        i1 = 0;
        localObject1 = null;
      }
      break label394;
    }
  }
  
  public void a(int paramInt)
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
    Object localObject2 = (IContactSearchModel)paramView.getTag(2131362079);
    if (localObject2 == null) {}
    label228:
    do
    {
      String str;
      Object localObject1;
      do
      {
        return;
        if (this.jdField_f_of_type_Int == 33) {
          ReportController.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.searchclick", 0, 0, "", "", "", "");
        }
        paramView = ((IContactSearchModel)localObject2).a();
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
          paramView.putString("group_uin", ((ContactSearchModelDiscussion)localObject2).a());
          paramView.putString("group_name", ((ContactSearchModelDiscussion)localObject2).c());
          this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, paramView);
          p();
          return;
          if (!(localObject2 instanceof ContactSearchModelNewTroopMember)) {
            break;
          }
          localObject1 = ((ContactSearchModelNewTroopMember)localObject2).jdField_a_of_type_JavaLangString;
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
            QQToast.a(this, 0, getResources().getString(2131430278), 0).b(getResources().getDimensionPixelSize(2131558448));
            return;
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("group_uin", paramView.a());
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
            QQToast.a(this, 0, getResources().getString(2131430278), 0).b(getResources().getDimensionPixelSize(2131558448));
            return;
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("group_uin", paramView.a());
          ((Bundle)localObject1).putString("group_name", paramView.c());
          this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, (Bundle)localObject1);
          p();
          return;
        }
        if (b(paramView))
        {
          QQToast.a(this, 1, "该好友已同意邀请, 请等待管理员验证 ", 0).b(getTitleBarHeight());
          ReportController.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, (String)localObject1, "", "", "");
          return;
        }
      } while (((this.jdField_f_of_type_JavaUtilArrayList != null) && (this.jdField_f_of_type_JavaUtilArrayList.contains(paramView))) || (a(paramView)) || (a(false)) || (b(paramView, str)));
      SelectMemberInnerFrame localSelectMemberInnerFrame = (SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView();
      int i1;
      if ((this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 5) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 4) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 3) || (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 8))
      {
        i1 = -1;
        if ((localObject2 instanceof ContactSearchModelDiscussionMember))
        {
          i1 = 2;
          if (i1 != -1) {
            this.jdField_i_of_type_JavaUtilArrayList.add(a(paramView, str, i1, (String)localObject1));
          }
        }
      }
      for (;;)
      {
        r();
        j();
        localSelectMemberInnerFrame.f();
        b(true);
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        if (this.jdField_c_of_type_Int != 9003) {
          break;
        }
        if ((this.jdField_f_of_type_Int != 15) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(paramView))) {
          break label1123;
        }
        this.jdField_a_of_type_Int += 1;
        return;
        if ((localObject2 instanceof ContactSearchModelNewTroopMember))
        {
          i1 = 1;
          break label716;
        }
        if ((localObject2 instanceof ContactSearchModelFriend))
        {
          i1 = 0;
          break label716;
        }
        if (!(localObject2 instanceof ContactSearchModelPhoneContact)) {
          break label716;
        }
        if ((paramView.startsWith("pstn")) && (b(paramView, str, 5, (String)localObject1)))
        {
          i1 = 5;
          break label716;
        }
        if (paramView.startsWith("+"))
        {
          i1 = 4;
          break label716;
        }
        i1 = 0;
        break label716;
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 6)
        {
          this.jdField_i_of_type_JavaUtilArrayList.add(a(paramView, str, 1, localSelectMemberInnerFrame.a()));
        }
        else if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 7)
        {
          this.jdField_i_of_type_JavaUtilArrayList.add(a(paramView, str, 2, localSelectMemberInnerFrame.a()));
        }
        else if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 1)
        {
          if ((paramView.startsWith("pstn")) && (b(paramView, str, 5, localSelectMemberInnerFrame.a()))) {
            this.jdField_i_of_type_JavaUtilArrayList.add(a(paramView, str, 5, localSelectMemberInnerFrame.a()));
          } else if (paramView.startsWith("+")) {
            this.jdField_i_of_type_JavaUtilArrayList.add(a(paramView, str, 4, localSelectMemberInnerFrame.a()));
          } else {
            this.jdField_i_of_type_JavaUtilArrayList.add(a(paramView, str, 0, localSelectMemberInnerFrame.a()));
          }
        }
        else if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 9)
        {
          localObject1 = a(paramView, str, 1, localSelectMemberInnerFrame.a());
          localObject2 = new ArrayList(1);
          ((List)localObject2).add(localObject1);
          a((List)localObject2, false);
        }
      }
    } while ((this.jdField_f_of_type_Int != 32) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(paramView)));
    label277:
    label716:
    label1123:
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    if (this.jdField_f_of_type_Int != 30) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange.a(paramResultRecord, paramBoolean);
    }
    if (this.jdField_i_of_type_JavaUtilArrayList.isEmpty())
    {
      paramResultRecord = getString(2131433270);
      label46:
      if (this.jdField_b_of_type_AndroidWidgetButton == null) {
        break label110;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(paramResultRecord);
      paramResultRecord = this.jdField_b_of_type_AndroidWidgetButton;
      if (this.jdField_i_of_type_JavaUtilArrayList.isEmpty()) {
        break label112;
      }
    }
    label110:
    label112:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramResultRecord.setEnabled(paramBoolean);
      return;
      paramResultRecord = getString(2131433271, new Object[] { Integer.valueOf(this.jdField_i_of_type_JavaUtilArrayList.size()) });
      break label46;
      break;
    }
  }
  
  public void a(SelectMemberActivity.IOnSelectStateChange paramIOnSelectStateChange)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange = paramIOnSelectStateChange;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_d_of_type_Int == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368284));
      if ((paramBoolean) && (getIntent().getIntExtra("param_member_show_type", 1) == 2))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131430779, new Object[] { Integer.valueOf(Math.min(paramInt, this.jdField_i_of_type_Int)) }));
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131430778, new Object[] { Integer.valueOf(this.jdField_i_of_type_Int) }));
  }
  
  public void a(boolean paramBoolean, long paramLong, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "sendResultBroadcastToVideo");
    }
    Intent localIntent = new Intent("tencent.video.q2v.AddDiscussMember");
    localIntent.setPackage(this.app.getApplication().getPackageName());
    localIntent.putExtra("result", paramBoolean);
    localIntent.putExtra("roomId", paramLong);
    localIntent.putStringArrayListExtra("newMemberUin", paramArrayList);
    this.app.getApp().sendBroadcast(localIntent);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new xxq(this));
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130846136);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.jdField_c_of_type_AndroidWidgetTextView);
      if (this.jdField_f_of_type_Int != 13) {
        break label160;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131429500);
    }
    for (;;)
    {
      if (AppSetting.b)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText());
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_c_of_type_AndroidWidgetTextView.getText() + "按钮");
        this.jdField_c_of_type_AndroidWidgetTextView.postDelayed(new xxv(this), 1000L);
      }
      return;
      b();
      break;
      label160:
      if ((this.jdField_f_of_type_Int == 14) || (this.jdField_f_of_type_Int == 21) || (this.jdField_f_of_type_Int == 25))
      {
        if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
        } else {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
        }
      }
      else if (this.jdField_d_of_type_Int == 3)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131430777));
      }
      else
      {
        if (this.jdField_e_of_type_Int == 30)
        {
          this.jdField_d_of_type_JavaLangString = getString(2131433015);
          if (!this.jdField_b_of_type_AndroidWidgetTextView.getText().equals(this.jdField_d_of_type_JavaLangString)) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
          }
          if (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0) {
            this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          if (8 != this.jdField_d_of_type_AndroidWidgetTextView.getVisibility()) {
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131435973));
            this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new xxs(this));
            label379:
            if (!AppSetting.b) {
              break label487;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_d_of_type_JavaLangString);
            this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131435973));
            paramString2 = this.jdField_e_of_type_AndroidWidgetTextView;
            if (!this.jdField_a_of_type_Boolean) {
              break label489;
            }
          }
          label487:
          label489:
          for (paramString1 = getString(2131435973);; paramString1 = "多选")
          {
            paramString2.setContentDescription(paramString1);
            break;
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_e_of_type_AndroidWidgetTextView.setText("多选");
            this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new xxt(this));
            this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new xxu(this));
            break label379;
            break;
          }
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_i_of_type_JavaUtilArrayList.size())
      {
        if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool2 = false;
    boolean bool1;
    if (a(paramString1))
    {
      bool1 = false;
      d(paramString1);
    }
    for (;;)
    {
      if (b(paramString1))
      {
        d(paramString1);
        QQToast.a(this, 1, "该好友已同意邀请, 请等待管理员验证 ", 0).b(getTitleBarHeight());
        ReportController.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, paramString3, "", "", "");
        bool1 = false;
      }
      b(bool1);
      j();
      r();
      return bool1;
      bool1 = bool2;
      if (!a(false))
      {
        bool1 = bool2;
        if (!b(paramString1, paramString2))
        {
          bool1 = bool2;
          if (b(paramString1, paramString2, paramInt, paramString3))
          {
            bool2 = true;
            this.jdField_i_of_type_JavaUtilArrayList.add(a(paramString1, paramString2, paramInt, paramString3));
            bool1 = bool2;
            if (this.jdField_c_of_type_Int == 9003) {
              if ((this.jdField_f_of_type_Int == 15) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(paramString1)))
              {
                this.jdField_a_of_type_Int += 1;
                bool1 = bool2;
              }
              else
              {
                bool1 = bool2;
                if (this.jdField_f_of_type_Int == 32)
                {
                  bool1 = bool2;
                  if (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(paramString1))
                  {
                    this.jdField_a_of_type_Int += 1;
                    bool1 = bool2;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    boolean bool2 = false;
    boolean bool1;
    if (a(paramString1))
    {
      bool1 = false;
      d(paramString1);
    }
    for (;;)
    {
      if (b(paramString1))
      {
        d(paramString1);
        QQToast.a(this, 1, "该好友已同意邀请, 请等待管理员验证 ", 0).b(getTitleBarHeight());
        ReportController.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, paramString3, "", "", "");
        bool1 = false;
      }
      b(bool1);
      j();
      r();
      return bool1;
      bool1 = bool2;
      if (!a(false))
      {
        bool1 = bool2;
        if (b(paramString1, paramString2, paramInt, paramString3))
        {
          bool1 = true;
          this.jdField_i_of_type_JavaUtilArrayList.add(a(paramString1, paramString2, paramInt, paramString3, paramString4));
        }
      }
    }
  }
  
  public boolean a(List paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, false);
  }
  
  public boolean a(List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.jdField_i_of_type_JavaUtilArrayList.clear();
    }
    HashSet localHashSet = new HashSet(this.jdField_i_of_type_JavaUtilArrayList.size());
    Object localObject = this.jdField_i_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((ResultRecord)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_f_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_f_of_type_JavaUtilArrayList.iterator();
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
          break label338;
        }
        localObject = (ResultRecord)paramList.next();
        if (!localHashSet.contains(((ResultRecord)localObject).jdField_a_of_type_JavaLangString))
        {
          if ((a(paramBoolean2)) || (b(((ResultRecord)localObject).jdField_a_of_type_JavaLangString, ((ResultRecord)localObject).b)) || (!b(((ResultRecord)localObject).jdField_a_of_type_JavaLangString, ((ResultRecord)localObject).b, ((ResultRecord)localObject).jdField_a_of_type_Int, ((ResultRecord)localObject).jdField_c_of_type_JavaLangString))) {
            break;
          }
          this.jdField_i_of_type_JavaUtilArrayList.add(localObject);
          a((ResultRecord)localObject, true);
          if (this.jdField_c_of_type_Int == 9003) {
            if ((this.jdField_f_of_type_Int == 15) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(((ResultRecord)localObject).jdField_a_of_type_JavaLangString))) {
              this.jdField_a_of_type_Int += 1;
            } else if ((this.jdField_f_of_type_Int == 32) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(((ResultRecord)localObject).jdField_a_of_type_JavaLangString))) {
              this.jdField_a_of_type_Int += 1;
            }
          }
        }
      }
      if (9999 == this.jdField_c_of_type_Int) {
        DingdongPluginHelper.a("0X8005EA7");
      }
    } while (this.jdField_c_of_type_Int == 9003);
    label338:
    b(true);
    j();
    r();
    if (9999 == this.jdField_c_of_type_Int) {
      DingdongPluginHelper.a("0X8005EA6");
    }
    return true;
  }
  
  boolean a(boolean paramBoolean)
  {
    int i1 = 2131438457;
    if ((this.jdField_f_of_type_Int == 32) && (paramBoolean) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_enable_all_select", false))) {}
    label347:
    label479:
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
                        return false;
                        if (this.jdField_c_of_type_Int != 3000) {
                          break;
                        }
                      } while (this.jdField_i_of_type_JavaUtilArrayList.size() < this.jdField_i_of_type_Int);
                      if ((this.jdField_f_of_type_Int == 12) && (this.jdField_i_of_type_Int == 1)) {
                        c(2131433990);
                      }
                      for (;;)
                      {
                        return true;
                        c(2131433989);
                      }
                      if (this.jdField_c_of_type_Int != 1) {
                        break label347;
                      }
                      if (this.jdField_d_of_type_Int != 0) {
                        break;
                      }
                    } while (this.jdField_i_of_type_JavaUtilArrayList.size() < this.jdField_i_of_type_Int);
                    if (this.jdField_f_of_type_Int == 13) {}
                    for (;;)
                    {
                      c(i1);
                      return true;
                      i1 = 2131435533;
                    }
                    if (this.jdField_d_of_type_Int != 1) {
                      break;
                    }
                  } while (this.jdField_i_of_type_JavaUtilArrayList.size() < this.jdField_i_of_type_Int);
                  if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false)))
                  {
                    c(2131438457);
                    return true;
                  }
                } while (this.jdField_g_of_type_Boolean);
                c(2131435533);
                return true;
                if (this.jdField_d_of_type_Int != 3) {
                  break;
                }
              } while (this.jdField_i_of_type_JavaUtilArrayList.size() < this.jdField_i_of_type_Int);
              a(getString(2131438457));
              ReportController.b(null, "dc00899", "Grp_video", "", "invite", "toast_over", 0, 0, this.jdField_c_of_type_JavaLangString, TroopMemberUtil.a(this.app, this.app.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString) + "", "", "");
              return true;
            } while ((this.jdField_d_of_type_Int != 4) || (this.jdField_i_of_type_JavaUtilArrayList.size() < this.jdField_i_of_type_Int));
            a(getString(2131439159));
            return true;
            if (this.jdField_c_of_type_Int != 9003) {
              break label479;
            }
            if (this.jdField_f_of_type_Int != 15) {
              break;
            }
            i1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.f();
          } while (this.jdField_i_of_type_JavaUtilArrayList.size() < i1);
          a(String.format(getString(2131438238), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.e()) }));
          return true;
        } while (this.jdField_f_of_type_Int != 32);
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.k();
      } while (this.jdField_i_of_type_JavaUtilArrayList.size() < i1);
      a(String.format(getString(2131438238), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.h()) }));
      return true;
    } while (this.jdField_i_of_type_JavaUtilArrayList.size() < this.jdField_i_of_type_Int);
    if ((this.p) && (this.jdField_f_of_type_JavaUtilArrayList != null)) {}
    for (i1 = this.jdField_f_of_type_JavaUtilArrayList.size();; i1 = 0)
    {
      a(String.format(getString(2131435979), new Object[] { Integer.valueOf(i1 + this.jdField_i_of_type_Int) }));
      if (9999 == this.jdField_c_of_type_Int) {
        DingdongPluginHelper.a("0X8005EA5");
      }
      return true;
    }
  }
  
  public int b()
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
  
  public void b()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131435973);
    this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
    if (AppSetting.b)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_d_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131435973));
    }
    if ((f()) || (g()))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!f()) {
        break label175;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131435974);
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130846136);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new xxh(this));
      j();
      return;
      label175:
      if (g())
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131432998);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      }
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    int i1 = 1;
    if (QLog.isColorLevel()) {
      QLog.w("SelectMemberActivity", 1, "onInviteComplete, retCode[" + paramInt + "], troopUin[" + paramString + "], mSubType[" + this.jdField_d_of_type_Int + "], mEntrance[" + this.jdField_f_of_type_Int + "]");
    }
    if (paramInt == 0) {}
    for (paramInt = i1; paramInt != 0; paramInt = 0)
    {
      a(paramString, false);
      return;
    }
    QQToast.a(this, getString(2131433964), 2000).b(this.jdField_c_of_type_AndroidViewView.getHeight());
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(this.jdField_i_of_type_JavaUtilArrayList.size());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    localLayoutParams.width = ((int)((this.jdField_i_of_type_JavaUtilArrayList.size() * 40 + this.jdField_i_of_type_JavaUtilArrayList.size() * 10) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(localLayoutParams);
    n();
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 200L);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$GridViewAdapter.notifyDataSetChanged();
  }
  
  public void b(boolean paramBoolean, long paramLong, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "sendResultBroadcastToVideo");
    }
    Intent localIntent = new Intent("tencent.video.q2v.SwitchToDiscuss");
    localIntent.setPackage(this.app.getApplication().getPackageName());
    localIntent.putExtra("result", paramBoolean);
    localIntent.putExtra("roomId", paramLong);
    localIntent.putExtra("qqPhoneUserList", paramArrayList);
    paramArrayList = null;
    if (this.jdField_k_of_type_JavaUtilArrayList != null)
    {
      int i2 = this.jdField_k_of_type_JavaUtilArrayList.size();
      paramArrayList = new long[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        paramArrayList[i1] = ((AddDiscussMemberInfo)this.jdField_k_of_type_JavaUtilArrayList.get(i1)).Uin;
        i1 += 1;
      }
    }
    localIntent.putExtra("memberUin", paramArrayList);
    this.app.getApp().sendBroadcast(localIntent);
    if (paramBoolean) {
      ((QCallFacade)this.app.getManager(37)).a(1, paramLong, "", "");
    }
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
      if (!this.jdField_i_of_type_JavaUtilArrayList.isEmpty()) {
        break label243;
      }
      localObject = getString(2131433270);
      label87:
      if (this.jdField_b_of_type_AndroidWidgetButton != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      if (this.jdField_b_of_type_AndroidWidgetButton != null)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetButton;
        bool1 = bool2;
        if (!this.jdField_i_of_type_JavaUtilArrayList.isEmpty()) {
          bool1 = true;
        }
        ((Button)localObject).setEnabled(bool1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange != null) && (!paramBoolean2)) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange.a(true, paramBoolean2);
      }
      if (!paramBoolean1)
      {
        b(true);
        r();
      }
      p();
      paramBoolean1 = this.jdField_a_of_type_Boolean;
      localObject = getIntent().getStringExtra("group_uin");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ThreadManager.post(new xxp(this, paramBoolean1, (String)localObject), 5, null, true);
      }
      return;
      bool1 = false;
      break;
      label237:
      i1 = 8;
      break label38;
      label243:
      localObject = getString(2131433271, new Object[] { Integer.valueOf(this.jdField_i_of_type_JavaUtilArrayList.size()) });
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
  
  protected boolean b(String paramString1, String paramString2)
  {
    if (this.jdField_c_of_type_Int == 9003)
    {
      if ((this.jdField_f_of_type_Int == 15) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(paramString1)) && (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.d())) {
        a(String.format(getString(2131438237), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.c()) }));
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bool1;
        if (this.jdField_f_of_type_Int == 32)
        {
          bool2 = bool1;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(paramString1))
          {
            bool2 = bool1;
            if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.j())
            {
              a(String.format(getString(2131438230), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.i()) }));
              bool2 = true;
            }
          }
        }
        return bool2;
      }
    }
    return false;
  }
  
  public boolean b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool;
    int i1;
    if (paramInt == 5)
    {
      bool = b();
      if (!bool) {
        QQToast.a(this, 2131435986, 1).b(getTitleBarHeight());
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
    return this.jdField_c_of_type_Int;
  }
  
  protected void c()
  {
    setContentView(2130971513);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SelectMemberActivity", 1, "onReusedTroop,troopUin[" + paramString + "], mSubType[" + this.jdField_d_of_type_Int + "], mEntrance[" + this.jdField_f_of_type_Int + "]");
    }
    a(paramString, true);
  }
  
  public boolean c()
  {
    this.jdField_i_of_type_JavaUtilArrayList.clear();
    b(false);
    j();
    r();
    return true;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(this);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(this.app);
    if (this.jdField_e_of_type_Int == 30)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(9, this.jdField_a_of_type_AndroidContentIntent.getExtras());
      return;
    }
    if (this.jdField_l_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, this.jdField_a_of_type_AndroidContentIntent.getExtras());
      return;
    }
    if (this.m)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, this.jdField_a_of_type_AndroidContentIntent.getExtras());
      return;
    }
    if (this.o)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
  }
  
  public void d(String paramString)
  {
    int i1 = 0;
    if (i1 < this.jdField_i_of_type_JavaUtilArrayList.size())
    {
      if (((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString))
      {
        this.jdField_i_of_type_JavaUtilArrayList.remove(i1);
        if (this.jdField_c_of_type_Int == 9003) {
          if ((this.jdField_f_of_type_Int != 15) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(paramString))) {
            break label90;
          }
        }
      }
      for (this.jdField_a_of_type_Int -= 1;; this.jdField_a_of_type_Int -= 1) {
        label90:
        do
        {
          i1 += 1;
          break;
        } while ((this.jdField_f_of_type_Int != 32) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(paramString)));
      }
    }
    r();
  }
  
  public boolean d()
  {
    return this.B;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidWidgetEditText.getLocationOnScreen(arrayOfInt);
    int i1 = arrayOfInt[0];
    int i2 = arrayOfInt[1];
    if ((paramMotionEvent.getX() >= i1) && (paramMotionEvent.getX() <= i1 + this.jdField_a_of_type_AndroidWidgetEditText.getWidth()) && (paramMotionEvent.getY() >= i2) && (paramMotionEvent.getY() > i2 + this.jdField_a_of_type_AndroidWidgetEditText.getHeight())) {}
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
    setTheme(2131624736);
    super.doOnCreate(paramBundle);
    f();
    c();
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false) == true) {
      super.getWindow().addFlags(524288);
    }
    g();
    b();
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    h();
    o();
    t();
    d();
    if ((this.jdField_c_of_type_Int == 1) && (this.jdField_d_of_type_Int == 1))
    {
      paramBundle = (TroopManager)this.app.getManager(51);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.a(this.jdField_c_of_type_JavaLangString);
        if (paramBundle != null) {
          this.jdField_k_of_type_Int = paramBundle.wMemberNum;
        }
      }
      ThreadManager.post(new xww(this), 8, null, true);
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    this.jdField_b_of_type_AndroidGraphicsBitmap = ImageUtil.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$GridViewAdapter);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new xya(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.av.v2q.StopVideoChat");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    if (this.jdField_e_of_type_Int == 30) {
      b(true, true);
    }
    if ((this.jdField_c_of_type_Int == 9003) || (8998 == this.jdField_c_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager = ((BlessManager)this.app.getManager(137));
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a();
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        paramBundle = (FriendsManager)this.app.getManager(50);
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Friends localFriends = paramBundle.c(str);
          if (localFriends != null) {
            localArrayList.add(a(str, localFriends.getFriendNick(), 0, "-1"));
          }
        }
        a(localArrayList, false);
      }
    }
    paramBundle = getIntent().getParcelableArrayListExtra("param_selected_records_for_create_discussion");
    if (paramBundle != null) {
      a(paramBundle, false);
    }
    if (this.jdField_e_of_type_Int == 1003) {
      ReportController.b(this.app, "dc00899", "Grp_create", "", "f2f", "clk_f2f_main", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_f_of_type_Int == 33) {
        ReportController.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payershowfriendpay.askaio.payershowfriendpay.askaio.payerclickfriendpay.selectpage.show", 0, 0, "", "", "", "");
      }
      return true;
      if (this.jdField_e_of_type_Int == 1002) {
        ReportController.b(this.app, "dc00899", "Grp_create", "", "f2f", "clk_f2f_conta", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.d();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "doOnNewIntent");
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.b();
    c(false);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a();
    c(true);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(48);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.c();
  }
  
  boolean e()
  {
    boolean bool = f();
    int i2 = this.jdField_i_of_type_JavaUtilArrayList.size();
    if (this.jdField_f_of_type_JavaUtilArrayList != null) {}
    for (int i1 = this.jdField_f_of_type_JavaUtilArrayList.size(); (bool) && (this.jdField_d_of_type_Int == 0) && (i1 + i2 >= 1); i1 = 0) {
      return true;
    }
    return false;
  }
  
  protected void f()
  {
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_type");
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_subtype");
    this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_from");
    this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_entrance", 0);
    this.jdField_f_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_selected_default");
    this.jdField_g_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_selected_friends");
    this.jdField_h_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uins_hide");
    if (this.jdField_h_of_type_JavaUtilArrayList == null) {
      this.jdField_h_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_h_of_type_JavaUtilArrayList.add(AppConstants.au);
    Object localObject1 = (TroopManager)this.app.getManager(51);
    Object localObject2 = ((TroopManager)localObject1).a();
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject2).next();
        if (localTroopInfo.isQidianPrivateTroop()) {
          this.jdField_h_of_type_JavaUtilArrayList.add(localTroopInfo.troopuin);
        }
      }
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("param_groupcode");
    this.jdField_g_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getExtras().getBoolean("param_is_troop_admin", true);
    this.jdField_i_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_max", 2147483647);
    this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_min", 1);
    this.s = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_show_myself", false);
    this.jdField_h_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_contacts", false);
    this.jdField_i_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_troop", false);
    this.jdField_j_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_donot_need_discussion", false);
    this.jdField_k_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_friends", false);
    this.jdField_l_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_troop_member", false);
    this.m = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_discussion_member", false);
    this.o = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_only_troop_or_discussion_member", false);
    this.n = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_face_to_face_troop", false);
    this.p = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_overload_tips_include_default_count", false);
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_title");
    if (this.jdField_d_of_type_JavaLangString == null) {
      this.jdField_d_of_type_JavaLangString = getString(2131435941);
    }
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_done_button_wording");
    if (this.jdField_e_of_type_JavaLangString == null) {
      this.jdField_e_of_type_JavaLangString = getString(2131435945);
    }
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_done_button_highlight_wording");
    if (this.jdField_f_of_type_JavaLangString == null) {
      this.jdField_f_of_type_JavaLangString = (this.jdField_e_of_type_JavaLangString + "({0})");
    }
    this.q = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_add_passed_members_to_result_set", false);
    this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_exit_animation", 0);
    this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_back_button_side", 1);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_report_type", 0);
    this.x = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_put_myself_first", false);
    this.y = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_forbid_only_choose_myself", false);
    if ((this.jdField_f_of_type_Int == 14) || (this.jdField_f_of_type_Int == 21))
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
        this.jdField_i_of_type_JavaUtilArrayList.add(localObject2);
        continue;
        if ((this.jdField_f_of_type_Int == 32) && ((this.jdField_l_of_type_Boolean) || (this.m)))
        {
          localObject2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_enable_all_select", false);
            int i1;
            if ((bool) && (this.m))
            {
              localObject1 = (DiscussionManager)this.app.getManager(52);
              if ((localObject1 != null) && (((DiscussionManager)localObject1).a((String)localObject2) <= this.jdField_i_of_type_Int)) {
                this.t = true;
              }
              if ((this.t) || (this.jdField_g_of_type_JavaUtilArrayList == null) || (TextUtils.isEmpty((CharSequence)localObject2))) {
                break;
              }
              i1 = 0;
              label853:
              if (i1 >= this.jdField_g_of_type_JavaUtilArrayList.size()) {
                break;
              }
              if (!TextUtils.isEmpty((CharSequence)this.jdField_g_of_type_JavaUtilArrayList.get(i1)))
              {
                localObject1 = new ResultRecord();
                ((ResultRecord)localObject1).jdField_a_of_type_JavaLangString = ((String)this.jdField_g_of_type_JavaUtilArrayList.get(i1));
                if (!this.m) {
                  break label990;
                }
              }
            }
            label990:
            for (int i2 = 2;; i2 = 1)
            {
              ((ResultRecord)localObject1).jdField_a_of_type_Int = i2;
              ((ResultRecord)localObject1).jdField_c_of_type_JavaLangString = ((String)localObject2);
              this.jdField_i_of_type_JavaUtilArrayList.add(localObject1);
              i1 += 1;
              break label853;
              if ((!bool) || (!this.jdField_l_of_type_Boolean)) {
                break;
              }
              localObject1 = ((TroopManager)localObject1).b((String)localObject2);
              if ((localObject1 == null) || (((TroopInfo)localObject1).wMemberNum > this.jdField_i_of_type_Int)) {
                break;
              }
              this.t = true;
              break;
            }
          }
        }
      }
    }
    this.u = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_support_select_from_friend_groups", false);
  }
  
  boolean f()
  {
    return (this.jdField_f_of_type_Int == 27) || (this.jdField_f_of_type_Int == 28) || (this.jdField_f_of_type_Int == 12) || (this.jdField_f_of_type_Int == 29) || (this.jdField_f_of_type_Int == 13);
  }
  
  public void finish()
  {
    super.finish();
    ResultReceiver localResultReceiver;
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      localResultReceiver = (ResultReceiver)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("result_receiver");
      if (localResultReceiver == null) {}
    }
    try
    {
      Field localField = Activity.class.getDeclaredField("mResultCode");
      localField.setAccessible(true);
      i1 = ((Integer)localField.get(this)).intValue();
      localResultReceiver.send(i1, this.jdField_a_of_type_AndroidContentIntent.getExtras());
      switch (this.jdField_g_of_type_Int)
      {
      default: 
        overridePendingTransition(0, 2131034122);
      case 2: 
        if (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
          p();
        }
        return;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        QLog.w("SelectMemberActivity", 1, "finish, get mResultCode NoSuchFieldException", localNoSuchFieldException);
        i1 = 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("SelectMemberActivity", 1, "finish, get mResultCode fail", localException);
        int i1 = 0;
        continue;
        overridePendingTransition(2131034129, 2131034130);
        continue;
        overridePendingTransition(0, 0);
      }
    }
  }
  
  @TargetApi(14)
  protected void g()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131362822);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        localRelativeLayout.setFitsSystemWindows(true);
      }
      localRelativeLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_c_of_type_AndroidViewView = findViewById(2131362577);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363363));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363227));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363455));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363410));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365443));
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = ((InnerFrameManager)findViewById(2131365444));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView = ((CustomHorizontalScrollView)findViewById(2131363746));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131365439));
    AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365442));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131363900);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131364959));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131374881);
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    }
    this.jdField_e_of_type_AndroidViewView = findViewById(2131374882);
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131368285);
    if ((f()) || (g()))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131368286));
      if (this.jdField_f_of_type_Int == 13) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      NewTroopContactView.setCreateTroopButtonEnable(this.jdField_a_of_type_AndroidWidgetButton, false);
      if (!f()) {
        break label484;
      }
      int i1 = getIntent().getIntExtra("create_source", 0);
      ReportController.b(this.app, "dc00899", "Grp_create_new", "", "create_page", "exp_chose", 0, 0, "", "" + i1, "", "");
    }
    for (;;)
    {
      this.jdField_f_of_type_AndroidViewView = findViewById(2131368283);
      this.jdField_g_of_type_AndroidViewView = findViewById(2131369888);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131369889));
      if (this.jdField_b_of_type_AndroidWidgetButton != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      return;
      label484:
      this.jdField_a_of_type_AndroidWidgetButton.setText("立即邀请");
      l();
    }
  }
  
  boolean g()
  {
    return (this.jdField_c_of_type_Int == 1) && (this.jdField_d_of_type_Int == 1);
  }
  
  @SuppressLint({"NewApi"})
  protected void h()
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$GridViewAdapter = new SelectMemberActivity.GridViewAdapter(this, this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$GridViewAdapter);
    this.jdField_a_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
    if (((this.jdField_i_of_type_JavaUtilArrayList.size() != 0) && ((this.jdField_f_of_type_Int == 14) || (this.jdField_f_of_type_Int == 21))) || (this.jdField_f_of_type_Int == 32))
    {
      Iterator localIterator = this.jdField_i_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (this.jdField_f_of_type_Int == 32)
        {
          if (localResultRecord.jdField_a_of_type_Int == 1) {
            localResultRecord.b = ContactUtils.g(this.app, localResultRecord.jdField_c_of_type_JavaLangString, localResultRecord.jdField_a_of_type_JavaLangString);
          } else if (localResultRecord.jdField_a_of_type_Int == 2) {
            localResultRecord.b = ContactUtils.a(this.app, localResultRecord.jdField_c_of_type_JavaLangString, localResultRecord.jdField_a_of_type_JavaLangString);
          }
        }
        else {
          localResultRecord.b = ContactUtils.g(this.app, localResultRecord.jdField_c_of_type_JavaLangString, localResultRecord.jdField_a_of_type_JavaLangString);
        }
      }
      b(true);
    }
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(new xxw(this));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new xxx(this));
  }
  
  protected void i()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new xwy(this));
  }
  
  public void j()
  {
    if (this.jdField_e_of_type_Int == 30) {
      return;
    }
    if (this.jdField_i_of_type_JavaUtilArrayList.size() >= this.jdField_j_of_type_Int)
    {
      a(true);
      return;
    }
    a(false);
  }
  
  public void k()
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1500L) {}
    TroopCreateLogic localTroopCreateLogic;
    do
    {
      return;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      localTroopCreateLogic = (TroopCreateLogic)this.app.getManager(31);
    } while (localTroopCreateLogic == null);
    Object localObject = new JSONObject();
    label515:
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("group_type", 1);
        ((JSONObject)localObject).put("name", ContactUtils.j(this.app, this.app.getCurrentAccountUin()) + "创建的群");
        ((JSONObject)localObject).put("classify", 10010);
        if (this.jdField_f_of_type_Int != 12) {
          ((JSONObject)localObject).put("isJumpAio", 1);
        }
        i1 = this.jdField_f_of_type_Int;
        if (i1 == 12) {
          i1 = 3;
        }
        ArrayList localArrayList;
        String str;
        ResultRecord localResultRecord;
        if (this.jdField_e_of_type_Int != 1002) {
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
          localArrayList = new ArrayList(this.jdField_i_of_type_JavaUtilArrayList.size());
          localArrayList.addAll(this.jdField_i_of_type_JavaUtilArrayList);
          if (this.jdField_f_of_type_JavaUtilArrayList == null) {
            continue;
          }
          localObject = this.jdField_f_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject).hasNext()) {
            continue;
          }
          str = (String)((Iterator)localObject).next();
          localResultRecord = new ResultRecord();
          localResultRecord.jdField_a_of_type_JavaLangString = str;
          localResultRecord.jdField_a_of_type_Int = 0;
          localResultRecord.jdField_c_of_type_JavaLangString = "-1";
          localResultRecord.b = ContactUtils.b(this.app, localResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.jdField_a_of_type_Int);
          localArrayList.add(localResultRecord);
          continue;
          if (this.jdField_f_of_type_Int == 28)
          {
            i1 = 5;
            continue;
          }
          if (this.jdField_f_of_type_Int == 29)
          {
            i1 = 2;
            continue;
          }
          if (this.jdField_f_of_type_Int == 13)
          {
            i1 = 4;
            continue;
          }
          if (this.jdField_f_of_type_Int != 27) {
            break label515;
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
        localTroopCreateLogic.b(this, this, localJSONException1);
        if (this.jdField_e_of_type_Int == 1003)
        {
          ReportController.b(this.app, "dc00899", "Grp_create", "", "choose_cre", "clk_cre_main", 0, 0, "", "", "", "");
          return;
        }
      }
      ReportController.b(this.app, "dc00899", "Grp_create", "", "choose_cre", "clk_cre_conta", 0, 0, "", "", "", "");
      return;
    }
  }
  
  protected void l()
  {
    Object localObject = ((TroopManager)this.app.getManager(51)).b(this.jdField_c_of_type_JavaLangString);
    boolean bool1;
    if (localObject != null)
    {
      if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x6100000) != 0L) {
        break label233;
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
        label54:
        if (((TroopInfo)localObject).maxInviteMemNum <= 0) {
          break label455;
        }
        if (((TroopInfo)localObject).wMemberNum + this.jdField_i_of_type_JavaUtilArrayList.size() <= ((TroopInfo)localObject).maxInviteMemNum) {
          break label342;
        }
        bool1 = true;
      }
      for (;;)
      {
        label82:
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "refreshInviteTipsBar needAdminCheck = " + bool2 + " needAgree = " + bool1);
        }
        if ((!bool2) && (!bool1))
        {
          this.z = false;
          if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false))) {
            this.jdField_g_of_type_JavaLangString = getString(2131429670);
          }
        }
        for (;;)
        {
          if ((this.A) || (!this.z) || (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))) {
            break label445;
          }
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          localObject = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131374883);
          ((TextView)localObject).setText(this.jdField_h_of_type_JavaLangString);
          ((TextView)localObject).setContentDescription(this.jdField_h_of_type_JavaLangString);
          return;
          label233:
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x2000000) == 33554432L)
          {
            if (((TroopInfo)localObject).wMemberNum + this.jdField_i_of_type_JavaUtilArrayList.size() > 50)
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          }
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x4000000) == 67108864L)
          {
            if (((TroopInfo)localObject).wMemberNum + this.jdField_i_of_type_JavaUtilArrayList.size() > 100)
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          }
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x100000) != 1048576L) {
            break label460;
          }
          bool1 = false;
          break;
          bool2 = false;
          break label54;
          label342:
          bool1 = false;
          break label82;
          this.jdField_g_of_type_JavaLangString = "邀请成功";
          continue;
          if ((!bool2) && (bool1))
          {
            this.z = true;
            this.jdField_h_of_type_JavaLangString = "当前群聊人数较多。为减少打扰，对方同意邀请后才会进入群聊。";
            this.jdField_g_of_type_JavaLangString = "加群邀请已发送";
          }
          else if ((bool2) && (bool1))
          {
            this.z = true;
            this.jdField_h_of_type_JavaLangString = "当前群聊人数较多。为减少打扰，对方及本群管理员均同意后，被邀请人才会进入群聊。";
            this.jdField_g_of_type_JavaLangString = "加群邀请已发送";
          }
          else if ((bool2) && (!bool1))
          {
            this.z = true;
            this.jdField_h_of_type_JavaLangString = "当前群聊需要管理员审核同意后，被邀请人才会进入群聊。";
            this.jdField_g_of_type_JavaLangString = "邀请成功, 待管理员审核。";
          }
        }
        label445:
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        return;
        label455:
        bool1 = false;
      }
      label460:
      bool1 = false;
    }
  }
  
  public void m()
  {
    if ((this.jdField_i_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_c_of_type_JavaLangString.length() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member: troopCode: " + this.jdField_c_of_type_JavaLangString + " member count: " + this.jdField_i_of_type_JavaUtilArrayList.size());
      }
      if (!a())
      {
        QQToast.a(this, 2131435273, 0).b(getTitleBarHeight());
        return;
      }
      if (this.jdField_k_of_type_Int <= 0)
      {
        Object localObject = (TroopManager)this.app.getManager(51);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).a(this.jdField_c_of_type_JavaLangString);
          if (localObject != null) {
            this.jdField_k_of_type_Int = ((TroopInfo)localObject).wMemberNum;
          }
        }
      }
      if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_i_of_type_JavaUtilArrayList.size() + this.jdField_k_of_type_Int > this.jdField_a_of_type_Long))
      {
        DialogUtil.a(this, "本群人数较多, 为减少打扰, 对方同意邀请后才能加群。", 2131432998, 2131433975, new xwx(this, this.jdField_i_of_type_JavaUtilArrayList), new DialogUtil.DialogOnClickAdapter()).show();
        ReportController.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_msgbox", 0, 0, this.jdField_c_of_type_JavaLangString, TroopMemberUtil.a(this.app, this.app.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString) + "", "", "");
        return;
      }
      ((TroopHandler)this.app.a(20)).b(this.jdField_c_of_type_JavaLangString, this.jdField_i_of_type_JavaUtilArrayList, "");
      e();
      this.jdField_b_of_type_AndroidAppDialog.show();
      ReportController.b(this.app, "dc00899", "invite_friend", "", "friend_list", "Clk_invite", 0, 0, this.jdField_c_of_type_JavaLangString, TroopMemberUtil.a(this.app, this.app.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString) + "", "", "");
      return;
    }
    finish();
  }
  
  protected void n()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_Float * 40.0F));
    int i1 = (int)(this.jdField_a_of_type_Float * 40.0F);
    int i2 = (int)(this.jdField_a_of_type_Float * 10.0F);
    if (this.jdField_i_of_type_JavaUtilArrayList.size() > 0) {
      if (this.jdField_i_of_type_JavaUtilArrayList.size() < 5)
      {
        i1 = (int)((this.jdField_i_of_type_JavaUtilArrayList.size() * 40 + this.jdField_i_of_type_JavaUtilArrayList.size() * 10) * this.jdField_a_of_type_Float) + (int)(this.jdField_a_of_type_Float * 10.0F);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    for (;;)
    {
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(i1, 0, i2, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams(localLayoutParams);
      return;
      i1 = (int)(230.0F * this.jdField_a_of_type_Float);
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    }
    i();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new xwz(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new xxa(this));
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new xxb(this));
  }
  
  public boolean onBackEvent()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))
    {
      p();
      return true;
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
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
      if (this.o)
      {
        if (this.jdField_f_of_type_Int == 27)
        {
          this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_i_of_type_JavaUtilArrayList);
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
      if (this.jdField_l_of_type_Boolean) {
        finish();
      }
      for (;;)
      {
        return true;
        q();
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
      }
      if (this.m) {
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
    switch (paramView.getId())
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
            return;
            if (this.jdField_f_of_type_Int == 11)
            {
              ReportController.b(this.app, "CliOper", "", "", "0X8005529", "0X8005529", 0, 0, "", "", "", "");
              return;
            }
          } while (this.jdField_f_of_type_Int != 10);
          ReportController.b(this.app, "CliOper", "", "", "0X8005524", "0X8005524", 0, 0, "", "", "", "");
          return;
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          this.A = true;
          ReportController.b(this.app, "dc00899", "invite_friend", "", "friend_list", "Clk_close", 0, 0, this.jdField_c_of_type_JavaLangString, TroopMemberUtil.a(this.app, this.app.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString) + "", "", "");
          return;
          if ((this.jdField_f_of_type_Int == 13) && (this.jdField_a_of_type_AndroidContentIntent.hasExtra("isVideo")))
          {
            boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isVideo", false);
            QAVGroupConfig.Report.a(this.jdField_i_of_type_JavaUtilArrayList.size(), bool);
          }
          if (f())
          {
            k();
            return;
          }
        } while (!g());
        if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ShowJoinDiscTips", false)))
        {
          DialogUtil.b(this, 230, getString(2131429035), getString(2131429668), 2131429042, 2131429047, new xxm(this), new xxn(this)).show();
          return;
        }
        m();
        return;
        p();
        if (a().size() != 1) {
          break;
        }
        paramView = (String)a().get(0);
      } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange == null);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$IOnSelectStateChange.a(paramView);
      return;
      paramView = new Intent();
      paramView.putExtra("TROOP_UIN", this.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin"));
      paramView.putExtra("hide_title_left_arrow", true);
      PublicFragmentActivity.a(this, paramView, UnitedVerifyMsgEditFragment.class, 10);
      overridePendingTransition(2131034134, 2131034131);
      paramView = getIntent().getStringExtra("group_uin");
    } while (TextUtils.isEmpty(paramView));
    ThreadManager.post(new xxo(this, paramView), 5, null, true);
  }
  
  public void onRestart()
  {
    super.onRestart();
  }
  
  void p()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.B = false;
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
  
  public void r()
  {
    String str = null;
    Iterator localIterator = this.jdField_i_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    ResultRecord localResultRecord;
    if (localIterator.hasNext())
    {
      localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.jdField_a_of_type_Int != 5) {
        break label341;
      }
      if (i1 >= 3) {
        new StringBuilder().append(str).append("…").toString();
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.a(a(), this.jdField_f_of_type_JavaUtilArrayList);
      }
      if ((f()) || (g()))
      {
        i1 = this.jdField_i_of_type_JavaUtilArrayList.size();
        if (i1 <= 0) {
          break label265;
        }
        if (this.jdField_f_of_type_Int != 13) {
          break label228;
        }
        str = MessageFormat.format(this.jdField_f_of_type_JavaLangString, new Object[] { Integer.valueOf(i1) });
        this.jdField_a_of_type_AndroidWidgetButton.setText(str);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(str);
        NewTroopContactView.setCreateTroopButtonEnable(this.jdField_a_of_type_AndroidWidgetButton, true);
      }
      if (g()) {
        l();
      }
      return;
    }
    if (str == null)
    {
      str = localResultRecord.b;
      label189:
      i1 += 1;
    }
    label265:
    label341:
    for (;;)
    {
      break;
      str = str + "、" + localResultRecord.b;
      break label189;
      label228:
      if (f()) {}
      for (str = "立即创建({0})";; str = "立即邀请({0})")
      {
        str = MessageFormat.format(str, new Object[] { Integer.valueOf(i1) });
        break;
      }
      if (this.jdField_f_of_type_Int == 13) {
        str = MessageFormat.format(this.jdField_f_of_type_JavaLangString, new Object[] { Integer.valueOf(i1) });
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(str);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(str);
        NewTroopContactView.setCreateTroopButtonEnable(this.jdField_a_of_type_AndroidWidgetButton, false);
        break;
        if (f()) {
          str = "立即创建";
        } else {
          str = "立即邀请";
        }
      }
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  protected void s()
  {
    if ((this.jdField_i_of_type_JavaUtilArrayList != null) && (this.jdField_i_of_type_JavaUtilArrayList.size() > 0))
    {
      Object localObject = a();
      Intent localIntent = new Intent("tencent.video.q2v.SelectMember");
      localIntent.setPackage(this.app.getApplication().getPackageName());
      if (((ArrayList)localObject).size() > 0) {
        localIntent.putParcelableArrayListExtra("SelectMemberList", (ArrayList)localObject);
      }
      int i1 = this.jdField_i_of_type_JavaUtilArrayList.size();
      localObject = ((ResultRecord)this.jdField_i_of_type_JavaUtilArrayList.get(0)).b;
      localIntent.putExtra("InviteCount", i1);
      localIntent.putExtra("FirstName", (String)localObject);
      this.app.getApp().sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */