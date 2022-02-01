package com.tencent.mobileqq.activity.selectmember;

import amex;
import amfm;
import amfn;
import amfp;
import amfq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anyu;
import anyw;
import anzj;
import aoip;
import aojs;
import bgty;
import bguq;
import bgyq;
import bhlg;
import bhnv;
import biyw;
import bjaj;
import bkgt;
import blih;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class TroopAddFrdsInnerFrame
  extends SelectMemberInnerFrame
  implements amex, Handler.Callback, View.OnClickListener, biyw, bjaj, blih
{
  protected static double b;
  public static int d;
  public static int e;
  private static int i = 1000;
  protected double a;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  amfp jdField_a_of_type_Amfp;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  protected ProgressBar a;
  protected RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  anyu jdField_a_of_type_Anyu = new amfm(this);
  anyw jdField_a_of_type_Anyw;
  aojs jdField_a_of_type_Aojs = new amfn(this);
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  public Long a;
  String jdField_a_of_type_JavaLangString = "";
  public Map<String, List<TroopMemberInfo>> a;
  Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  boolean jdField_a_of_type_Boolean = false;
  public int[] a;
  public String[] a;
  public int b;
  public Handler b;
  protected TextView b;
  public String b;
  boolean b;
  public int c;
  private String c;
  private String d;
  private String e;
  public int f = jdField_e_of_type_Int;
  private int g;
  private int h;
  
  static
  {
    jdField_b_of_type_Double = 10.0D;
    jdField_e_of_type_Int = 1;
  }
  
  public TroopAddFrdsInnerFrame(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public TroopAddFrdsInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public TroopAddFrdsInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private int a(String paramString)
  {
    boolean bool2 = this.jdField_a_of_type_Anyw.b(paramString);
    boolean bool1 = false;
    if (!bool2) {
      bool1 = this.jdField_a_of_type_Anyw.d(paramString);
    }
    if (bool2) {
      return 4;
    }
    if (bool1) {
      return 3;
    }
    return 2;
  }
  
  public static void a(Context paramContext, TroopMemberInfo paramTroopMemberInfo, String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    String str = bhlg.h(localQQAppInterface, paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin);
    int k = 16;
    int j = k;
    if ((paramContext instanceof Activity))
    {
      int m = ((Activity)paramContext).getIntent().getIntExtra("batch_addfrd_scene_type", 0);
      j = k;
      if (m != 0) {
        j = bgyq.d(m);
      }
    }
    paramString = AddFriendLogicActivity.a(paramContext, 1, paramTroopMemberInfo.memberuin, paramString, 3004, j, str, null, null, null, null);
    paramString.putExtra("need_result_uin", true);
    paramString.putExtra("select_multi_mode", paramBoolean);
    paramString.putExtra("troop_uin", paramTroopMemberInfo.troopuin);
    ((Activity)paramContext).startActivityForResult(paramString, 11);
    ThreadManager.post(new TroopAddFrdsInnerFrame.6(paramBoolean, localQQAppInterface, paramTroopMemberInfo), 5, null, true);
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (Object[])paramMessage.obj;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if (paramMessage.length == 3)
    {
      this.jdField_a_of_type_JavaUtilMap = ((Map)paramMessage[0]);
      this.jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[1]);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[2]);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      f();
      return;
      this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
      this.jdField_a_of_type_ArrayOfInt = new int[0];
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private void a(String paramString, List<TroopMemberInfo> paramList)
  {
    Object localObject;
    label117:
    ArrayList localArrayList;
    String str;
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        if (paramList != null) {
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        paramList = ((EntityManager)localObject).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
        ((EntityManager)localObject).close();
        if (!QLog.isColorLevel()) {
          break label440;
        }
        localObject = new StringBuilder().append("getTroopMemberFromDB, troopMemberInfoList==null, queryDB, troopUin=").append(paramString).append(",");
        if (paramList != null) {
          break label197;
        }
        j = 0;
        QLog.d("TroopMemberListInnerFrame.thread", 2, j);
      }
      finally {}
      localObject = Collections.synchronizedMap(new LinkedHashMap());
      localArrayList = new ArrayList();
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_b_of_type_JavaLangString);
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (paramList != null) {
        break label273;
      }
      paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
      continue;
      label197:
      j = paramList.size();
    }
    label273:
    int k;
    int m;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getTroopMemberFromDB, troopuin=").append(paramString).append(",");
      if (paramList == null) {}
      for (j = 0;; j = paramList.size())
      {
        QLog.d("TroopMemberListInnerFrame.thread", 2, j);
        break;
      }
      k = paramList.size();
      this.jdField_a_of_type_Int = (k - 1);
      if (k > 0)
      {
        m = k / i;
        if (k % i != 0) {
          break label451;
        }
      }
    }
    label440:
    label449:
    label451:
    for (int j = 0;; j = 1)
    {
      AtomicInteger localAtomicInteger = new AtomicInteger(j + m);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListInnerFrame.thread", 2, "parallel process mJobCount: " + localAtomicInteger.get());
      }
      for (;;)
      {
        if (j >= k) {
          break label449;
        }
        ThreadManager.post(new TroopAddFrdsInnerFrame.4(this, paramList, j, Math.min(i + j - 1, k), paramString, str, (Map)localObject, localArrayList, localAtomicInteger), 8, null, false);
        j += i;
        continue;
        paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3);
        this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
        break;
        break label117;
        break label117;
        j = 0;
      }
      break;
    }
  }
  
  private void a(Map<String, List<TroopMemberInfo>> paramMap)
  {
    Object localObject1 = (bgty)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(203);
    Object localObject2 = (bkgt)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(165);
    boolean bool = bguq.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getCurrentAccountUin());
    int m;
    Object localObject3;
    label110:
    List localList;
    int k;
    label134:
    int j;
    if ((!bguq.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getCurrentAccountUin())) && (!bool))
    {
      m = 1;
      localObject3 = paramMap.values().iterator();
      if (!((Iterator)localObject3).hasNext()) {
        break label267;
      }
      localList = (List)((Iterator)localObject3).next();
      k = 0;
      if (k < localList.size())
      {
        if (localList.get(k) != null) {
          break label182;
        }
        localList.remove(k);
        j = k - 1;
      }
    }
    for (;;)
    {
      k = j + 1;
      break label134;
      break label110;
      m = 0;
      break;
      label182:
      if (((bkgt)localObject2).f(((TroopMemberInfo)localList.get(k)).memberuin))
      {
        localList.remove(k);
        j = k - 1;
      }
      else
      {
        j = k;
        if (m != 0)
        {
          j = k;
          if (((bgty)localObject1).b(((TroopMemberInfo)localList.get(k)).memberuin))
          {
            localList.remove(k);
            j = k - 1;
          }
        }
      }
    }
    label267:
    localObject1 = new HashMap();
    localObject2 = paramMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (((List)paramMap.get(localObject3)).size() == 0) {
        ((Map)localObject1).put(localObject3, Integer.valueOf(1));
      }
    }
    localObject1 = ((Map)localObject1).keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramMap.remove((String)((Iterator)localObject1).next());
    }
  }
  
  private Object[] a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) && (QLog.isColorLevel())) {
      QLog.d("TroopAddFrdsInnerFrame", 2, "sortMembers: mTroopInfo not exist");
    }
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      Collections.sort((List)this.jdField_a_of_type_JavaUtilMap.get(localObject2), new amfq(this, null));
    }
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
    if (this.f == jdField_d_of_type_Int)
    {
      for (char c1 = 'A'; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
        if (((Map)localObject1).get(String.valueOf(c1)) != null) {
          this.jdField_a_of_type_JavaUtilMap.put(String.valueOf(c1), ((Map)localObject1).get(String.valueOf(c1)));
        }
      }
      if (((Map)localObject1).get("#") != null) {
        this.jdField_a_of_type_JavaUtilMap.put("#", ((Map)localObject1).get("#"));
      }
      ((Map)localObject1).clear();
    }
    for (;;)
    {
      localObject1 = new int[this.jdField_a_of_type_JavaUtilMap.keySet().size()];
      localObject2 = new String[this.jdField_a_of_type_JavaUtilMap.keySet().size()];
      localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      if (localObject1.length != 0) {
        break;
      }
      return new Object[0];
      if (this.f == jdField_e_of_type_Int)
      {
        j = 1;
        while (j < 5)
        {
          if (((Map)localObject1).get(String.valueOf(j)) != null) {
            this.jdField_a_of_type_JavaUtilMap.put(String.valueOf(j), ((Map)localObject1).get(String.valueOf(j)));
          }
          j += 1;
        }
        ((Map)localObject1).clear();
      }
    }
    localObject1[0] = 0;
    int j = 1;
    while (j < localObject1.length)
    {
      int k = localObject1[j];
      int m = localObject1[(j - 1)];
      localObject1[j] = (((List)this.jdField_a_of_type_JavaUtilMap.get(localIterator.next())).size() + m + 1 + k);
      j += 1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    j = 0;
    while (localIterator.hasNext())
    {
      localObject2[j] = ((String)localIterator.next());
      j += 1;
    }
    return new Object[] { this.jdField_a_of_type_JavaUtilMap, localObject1, localObject2 };
  }
  
  private void c(String paramString)
  {
    String str;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString);
      str = "0";
      if (localObject != null) {
        str = ((TroopInfo)localObject).troopcode;
      }
      if ((str != null) && (str.length() > 0))
      {
        if (bhnv.d(BaseApplication.getContext())) {
          break label93;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.q();
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131691989), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c.getHeight());
      }
    }
    return;
    label93:
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("TroopAddFrdsInnerFrame", 2, "get troop members from server, troopUin: " + paramString + " troopCode: " + str);
    }
    Object localObject = (aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ((aoip)localObject).a(true, paramString, str, true, 7, this.jdField_a_of_type_Long, 0);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364374));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368624));
    if (this.f == jdField_d_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167247);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379967));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379458));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131368123));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370330));
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity).inflate(2131562854, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131363745).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366151));
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
    }
  }
  
  private void h()
  {
    long l = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString }), 0L);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
    {
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum - 1);
      if (this.jdField_a_of_type_Int > 0)
      {
        this.jdField_a_of_type_Double = 0.0D;
        this.jdField_b_of_type_AndroidOsHandler.sendMessage(this.jdField_b_of_type_AndroidOsHandler.obtainMessage(4));
      }
    }
    if (l == 0L)
    {
      c(this.jdField_b_of_type_JavaLangString);
      return;
    }
    TroopAddFrdsInnerFrame.3 local3 = new TroopAddFrdsInnerFrame.3(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(local3);
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(24, 1048576, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 10) && (paramIntent != null) && (paramInt2 == -1))
    {
      localObject = paramIntent.getStringExtra("VERIFY_MSG");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a();
          FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.a(1);
          paramInt1 = bgyq.c(this.g);
          localFriendListHandler.a(this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, (String)localObject, paramIntent, true, 3093, paramInt1);
          localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
          ((Message)localObject).obj = paramIntent;
          ((Message)localObject).sendToTarget();
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(true, false);
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
          this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_b_of_type_AndroidOsHandler.obtainMessage(8), 120L);
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131717892), 0).a();
          f();
          localObject = this.jdField_b_of_type_JavaLangString;
        } while (TextUtils.isEmpty((CharSequence)localObject));
        ThreadManager.post(new TroopAddFrdsInnerFrame.5(this, (String)localObject, paramIntent), 5, null, true);
        return;
      } while ((paramInt1 != 11) || (paramIntent == null) || (paramInt2 != -1));
      localObject = paramIntent.getStringExtra("uin");
    } while (TextUtils.isEmpty((CharSequence)localObject));
    paramIntent = new ArrayList(1);
    paramIntent.add(localObject);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(true, false);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
      this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_b_of_type_AndroidOsHandler.obtainMessage(8), 120L);
    }
    Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
    ((Message)localObject).obj = paramIntent;
    ((Message)localObject).sendToTarget();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131562891);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
    this.jdField_a_of_type_Anyw = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.g = paramBundle.getInt("batch_addfrd_scene_type", 0);
    g();
    this.jdField_a_of_type_Amfp = new amfp(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Amfp);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_Aojs);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_Anyu);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    if (paramResultRecord != null) {
      this.jdField_a_of_type_Amfp.a(paramResultRecord, paramBoolean);
    }
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int j;
    do
    {
      return;
      j = this.jdField_a_of_type_Amfp.a(paramString);
    } while (j == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(j + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        paramBoolean2 = true;
        this.jdField_b_of_type_Boolean = paramBoolean2;
      }
    }
    else
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label78;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.removeHeaderView(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        this.jdField_a_of_type_Amfp.a.clear();
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d();
      }
      this.jdField_a_of_type_Amfp.a(this.jdField_b_of_type_Boolean);
      return;
      paramBoolean2 = false;
      break;
      label78:
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.b();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("group_uin");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("group_name");
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("param_groupcode");
    this.jdField_e_of_type_JavaLangString = paramBundle.getString("batch_addfrd_recommand_uin");
    if (((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.length() == 0)) && (this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null))
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_b_of_type_JavaLangString);
      if (paramBundle != null) {
        this.jdField_c_of_type_JavaLangString = paramBundle.getTroopName();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.h) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, "", this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label282;
      }
      if (this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
      this.jdField_a_of_type_ArrayOfInt = new int[0];
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
      f();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      h();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, anzj.a(2131713937), this.jdField_c_of_type_JavaLangString);
    }
    f();
    return;
    label282:
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.finish();
  }
  
  public void b(String paramString)
  {
    TroopMemberInfo localTroopMemberInfo = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    int j;
    if (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      j = 0;
      label58:
      if (j >= ((List)localObject).size()) {
        break label130;
      }
      if (paramString.equals(((TroopMemberInfo)((List)localObject).get(j)).memberuin)) {
        localTroopMemberInfo = (TroopMemberInfo)((List)localObject).get(j);
      }
    }
    label130:
    for (;;)
    {
      break;
      j += 1;
      break label58;
      if (localTroopMemberInfo != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, localTroopMemberInfo, this.jdField_d_of_type_JavaLangString, true);
      }
      return;
    }
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Amfp != null) {
      this.jdField_a_of_type_Amfp.c();
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_Aojs);
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Amfp.notifyDataSetChanged();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    Object localObject2;
    label512:
    int j;
    int k;
    label730:
    String str;
    int m;
    switch (paramMessage.what)
    {
    default: 
    case 9: 
    case 10: 
    case 1: 
    case 2: 
    case 4: 
    case 3: 
    case 5: 
    case 6: 
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
                  } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof List)));
                  paramMessage = (List)paramMessage.obj;
                  this.jdField_a_of_type_JavaUtilSet.addAll(paramMessage);
                } while (this.jdField_a_of_type_AndroidOsHandler.hasMessages(10));
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 300L);
                return false;
              } while (this.jdField_a_of_type_JavaUtilSet.size() <= 0);
              paramMessage = new HashMap(this.jdField_a_of_type_JavaUtilSet.size());
              localObject1 = this.jdField_a_of_type_JavaUtilSet.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (String)((Iterator)localObject1).next();
                paramMessage.put(localObject2, Integer.valueOf(a((String)localObject2)));
              }
              this.jdField_a_of_type_JavaUtilSet.clear();
              localObject1 = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(7);
              ((Message)localObject1).obj = paramMessage;
              ((Message)localObject1).sendToTarget();
              return false;
              a(paramMessage);
              return false;
              this.jdField_a_of_type_Double += jdField_b_of_type_Double;
            } while ((this.jdField_a_of_type_Double >= 90.0D) || (this.jdField_a_of_type_Int <= 0));
            if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            }
            this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)this.jdField_a_of_type_Double);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format(anzj.a(2131713935), new Object[] { Integer.valueOf(Math.min((int)(this.jdField_a_of_type_Int * this.jdField_a_of_type_Double / 100.0D), this.jdField_a_of_type_Int)), Integer.valueOf(this.jdField_a_of_type_Int) }));
            this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_b_of_type_AndroidOsHandler.obtainMessage(4), 800L);
            return false;
            this.h = paramMessage.arg1;
            this.jdField_b_of_type_AndroidOsHandler.removeMessages(4);
            if (!(paramMessage.obj instanceof Object[])) {
              break label512;
            }
            localObject1 = (Object[])paramMessage.obj;
            if (localObject1.length <= 0) {
              break label512;
            }
            localObject2 = (String)localObject1[1];
            if (((String)localObject2).equals(this.jdField_b_of_type_JavaLangString)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, troopUin != mTroopUin, break:" + (String)localObject2 + "," + this.jdField_b_of_type_JavaLangString);
          return false;
          this.jdField_a_of_type_JavaUtilMap = ((Map)localObject1[0]);
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, mIndexedFriends.size=" + this.jdField_a_of_type_JavaUtilMap.size());
          }
          a(this.jdField_a_of_type_JavaUtilMap);
          paramMessage.obj = a();
          a(paramMessage);
          return false;
        } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof List)));
        paramMessage = (List)paramMessage.obj;
        localObject1 = (aoip)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.a(20);
        this.jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
        ((aoip)localObject1).a(this.jdField_b_of_type_JavaLangString, paramMessage, 0, this.jdField_a_of_type_JavaLangLong, 0, false);
        return false;
      } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof HashMap)));
      paramMessage = (HashMap)paramMessage.obj;
      localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      j = 0;
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label827;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        k = 0;
        if (k >= ((List)localObject2).size()) {
          break label1034;
        }
        str = ((TroopMemberInfo)((List)localObject2).get(k)).memberuin;
        m = j;
        if (!paramMessage.containsKey(str)) {
          break;
        }
        j += 1;
        m = ((Integer)paramMessage.get(str)).intValue();
        ((TroopMemberInfo)((List)localObject2).get(k)).commonFrdCnt = m;
        m = j;
      } while (j >= paramMessage.size());
    }
    label1031:
    label1034:
    for (;;)
    {
      k += 1;
      j = m;
      break label730;
      label827:
      f();
      return false;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelectionFromTop(0, 0);
      return false;
      if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof HashMap))) {
        break;
      }
      paramMessage = (HashMap)paramMessage.obj;
      localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      j = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        m = 0;
        label928:
        if (m >= ((List)localObject2).size()) {
          break label1031;
        }
        str = ((TroopMemberInfo)((List)localObject2).get(m)).memberuin;
        k = j;
        if (paramMessage.containsKey(str))
        {
          k = j + 1;
          j = ((Integer)paramMessage.get(str)).intValue();
          ((TroopMemberInfo)((List)localObject2).get(m)).addState = j;
        }
        if (k >= paramMessage.size()) {
          j = k;
        }
      }
      for (;;)
      {
        break;
        m += 1;
        j = k;
        break label928;
        f();
        return false;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("batch_addfrd_scene_type", this.g);
      ContactSearchComponentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, null, this.jdField_b_of_type_JavaLangString, 23, 1048576, 561243, localBundle);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getWindowToken(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame
 * JD-Core Version:    0.7.0.1
 */