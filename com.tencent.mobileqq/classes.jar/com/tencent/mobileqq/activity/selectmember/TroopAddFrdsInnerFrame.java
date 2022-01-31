package com.tencent.mobileqq.activity.selectmember;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
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
import yic;
import yie;
import yig;
import yih;
import yii;
import yij;
import yik;
import yil;

public class TroopAddFrdsInnerFrame
  extends SelectMemberInnerFrame
  implements Handler.Callback, View.OnClickListener, SelectMemberActivity.IOnSelectStateChange, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, AbsListView.OnScrollListener
{
  protected static double b;
  public static int d;
  public static int e = 1;
  private static int h = 1000;
  protected double a;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  protected ProgressBar a;
  protected RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new yic(this);
  public FriendsManager a;
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new yie(this);
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  public Long a;
  String jdField_a_of_type_JavaLangString = "";
  public Map a;
  Set jdField_a_of_type_JavaUtilSet = new HashSet();
  yik jdField_a_of_type_Yik;
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
  public int f = e;
  private int g;
  
  static
  {
    jdField_b_of_type_Double = 10.0D;
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
  
  public static void a(Context paramContext, TroopMemberInfo paramTroopMemberInfo, String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    String str = ContactUtils.g(localQQAppInterface, paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin);
    paramString = AddFriendLogicActivity.a(paramContext, 1, paramTroopMemberInfo.memberuin, paramString, 3004, 5, str, null, null, null, null);
    paramString.putExtra("need_result_uin", true);
    paramString.putExtra("select_multi_mode", paramBoolean);
    paramString.putExtra("troop_uin", paramTroopMemberInfo.troopuin);
    ((Activity)paramContext).startActivityForResult(paramString, 11);
    ThreadManager.post(new yij(paramBoolean, localQQAppInterface, paramTroopMemberInfo), 5, null, true);
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
  
  private void a(String paramString, List paramList)
  {
    Object localObject;
    label116:
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
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        paramList = ((EntityManager)localObject).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
        ((EntityManager)localObject).a();
        if (!QLog.isColorLevel()) {
          break label439;
        }
        localObject = new StringBuilder().append("getTroopMemberFromDB, troopMemberInfoList==null, queryDB, troopUin=").append(paramString).append(",");
        if (paramList != null) {
          break label196;
        }
        i = 0;
        QLog.d("TroopMemberListInnerFrame.thread", 2, i);
      }
      finally {}
      localObject = Collections.synchronizedMap(new LinkedHashMap());
      localArrayList = new ArrayList();
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_b_of_type_JavaLangString);
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (paramList != null) {
        break label272;
      }
      paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
      continue;
      label196:
      i = paramList.size();
    }
    label272:
    int j;
    int k;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getTroopMemberFromDB, troopuin=").append(paramString).append(",");
      if (paramList == null) {}
      for (i = 0;; i = paramList.size())
      {
        QLog.d("TroopMemberListInnerFrame.thread", 2, i);
        break;
      }
      j = paramList.size();
      this.jdField_a_of_type_Int = (j - 1);
      if (j > 0)
      {
        k = j / h;
        if (j % h != 0) {
          break label450;
        }
      }
    }
    label439:
    label448:
    label450:
    for (int i = 0;; i = 1)
    {
      AtomicInteger localAtomicInteger = new AtomicInteger(i + k);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListInnerFrame.thread", 2, "parallel process mJobCount: " + localAtomicInteger.get());
      }
      for (;;)
      {
        if (i >= j) {
          break label448;
        }
        ThreadManager.post(new yih(this, paramList, i, Math.min(h + i - 1, j), paramString, str, (Map)localObject, localArrayList, localAtomicInteger), 8, null, false);
        i += h;
        continue;
        paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3);
        this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
        break;
        break label116;
        break label116;
        i = 0;
      }
      break;
    }
  }
  
  private void a(Map paramMap)
  {
    Object localObject1 = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(202);
    Object localObject2 = (QidianManager)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(164);
    Object localObject3 = paramMap.values().iterator();
    if (((Iterator)localObject3).hasNext())
    {
      List localList = (List)((Iterator)localObject3).next();
      int i = 0;
      label73:
      int j;
      if (i < localList.size())
      {
        if (localList.get(i) != null) {
          break label115;
        }
        localList.remove(i);
        j = i - 1;
      }
      for (;;)
      {
        i = j + 1;
        break label73;
        break;
        label115:
        if (!((TroopRobotManager)localObject1).b(((TroopMemberInfo)localList.get(i)).memberuin))
        {
          j = i;
          if (!((QidianManager)localObject2).f(((TroopMemberInfo)localList.get(i)).memberuin)) {}
        }
        else
        {
          localList.remove(i);
          j = i - 1;
        }
      }
    }
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
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      Collections.sort((List)this.jdField_a_of_type_JavaUtilMap.get(localObject2), new yil(this, null));
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
      if (this.f == e)
      {
        i = 1;
        while (i < 4)
        {
          if (((Map)localObject1).get(String.valueOf(i)) != null) {
            this.jdField_a_of_type_JavaUtilMap.put(String.valueOf(i), ((Map)localObject1).get(String.valueOf(i)));
          }
          i += 1;
        }
        ((Map)localObject1).clear();
      }
    }
    localObject1[0] = 0;
    int i = 1;
    while (i < localObject1.length)
    {
      int j = localObject1[i];
      int k = localObject1[(i - 1)];
      localObject1[i] = (((List)this.jdField_a_of_type_JavaUtilMap.get(localIterator.next())).size() + k + 1 + j);
      i += 1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      localObject2[i] = ((String)localIterator.next());
      i += 1;
    }
    return new Object[] { this.jdField_a_of_type_JavaUtilMap, localObject1, localObject2 };
  }
  
  private void c(String paramString)
  {
    String str;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString);
      str = "0";
      if (localObject != null) {
        str = ((TroopInfo)localObject).troopcode;
      }
      if ((str != null) && (str.length() > 0))
      {
        if (NetworkUtil.d(BaseApplication.getContext())) {
          break label93;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.q();
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131433023), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c.getHeight());
      }
    }
    return;
    label93:
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("TroopAddFrdsInnerFrame", 2, "get troop members from server, troopUin: " + paramString + " troopCode: " + str);
    }
    Object localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ((TroopHandler)localObject).a(true, paramString, str, true, 7, this.jdField_a_of_type_Long);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131375092));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131363854));
    if (this.f == jdField_d_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131492924);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375093));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375095));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131375096));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375097));
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity).inflate(2130971543, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368323).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131368324));
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
    long l = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag", this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString }), 0L);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_b_of_type_JavaLangString);
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
    yig localyig = new yig(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localyig);
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(24, 1048576, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.h, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
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
          ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.a(1)).a(this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, (String)localObject, paramIntent, true, 3093, 1);
          localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
          ((Message)localObject).obj = paramIntent;
          ((Message)localObject).sendToTarget();
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(true, false);
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
          this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_b_of_type_AndroidOsHandler.obtainMessage(8), 120L);
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131434477), 0).a();
          f();
          localObject = this.jdField_b_of_type_JavaLangString;
        } while (TextUtils.isEmpty((CharSequence)localObject));
        ThreadManager.post(new yii(this, (String)localObject, paramIntent), 5, null, true);
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
    setContentView(2130971576);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    g();
    this.jdField_a_of_type_Yik = new yik(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Yik);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    if (paramResultRecord != null) {
      this.jdField_a_of_type_Yik.a(paramResultRecord, paramBoolean);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getWindowToken(), 0);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString)
  {
    TroopMemberInfo localTroopMemberInfo = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    int i;
    if (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      i = 0;
      label58:
      if (i >= ((List)localObject).size()) {
        break label130;
      }
      if (paramString.equals(((TroopMemberInfo)((List)localObject).get(i)).memberuin)) {
        localTroopMemberInfo = (TroopMemberInfo)((List)localObject).get(i);
      }
    }
    label130:
    for (;;)
    {
      break;
      i += 1;
      break label58;
      if (localTroopMemberInfo != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, localTroopMemberInfo, this.jdField_d_of_type_JavaLangString, true);
      }
      return;
    }
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
        this.jdField_a_of_type_Yik.a.clear();
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c();
      }
      this.jdField_a_of_type_Yik.a(this.jdField_b_of_type_Boolean);
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
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("group_uin");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("group_name");
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("param_groupcode");
    if (((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.length() == 0)) && (this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null))
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_b_of_type_JavaLangString);
      if (paramBundle != null) {
        this.jdField_c_of_type_JavaLangString = paramBundle.getTroopName();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.l) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, "", this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        break label268;
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
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, "群", this.jdField_c_of_type_JavaLangString);
    }
    f();
    return;
    label268:
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.finish();
  }
  
  public void b(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Yik.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Yik != null) {
      this.jdField_a_of_type_Yik.c();
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Yik.notifyDataSetChanged();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    Object localObject2;
    int i;
    label556:
    int j;
    label774:
    String str;
    int k;
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
              boolean bool1 = false;
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (String)((Iterator)localObject1).next();
                boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b((String)localObject2);
                if (!bool2) {
                  bool1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c((String)localObject2);
                }
                if (bool2) {
                  i = 3;
                }
                for (;;)
                {
                  paramMessage.put(localObject2, Integer.valueOf(i));
                  break;
                  if (bool1) {
                    i = 2;
                  } else {
                    i = 1;
                  }
                }
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
            this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("加载中...(%d/%d)", new Object[] { Integer.valueOf(Math.min((int)(this.jdField_a_of_type_Int * this.jdField_a_of_type_Double / 100.0D), this.jdField_a_of_type_Int)), Integer.valueOf(this.jdField_a_of_type_Int) }));
            this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_b_of_type_AndroidOsHandler.obtainMessage(4), 800L);
            return false;
            this.g = paramMessage.arg1;
            this.jdField_b_of_type_AndroidOsHandler.removeMessages(4);
            if (!(paramMessage.obj instanceof Object[])) {
              break label556;
            }
            localObject1 = (Object[])paramMessage.obj;
            if (localObject1.length <= 0) {
              break label556;
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
        localObject1 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.a(20);
        this.jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
        ((TroopHandler)localObject1).a(this.jdField_b_of_type_JavaLangString, paramMessage, this.jdField_a_of_type_JavaLangLong.longValue());
        return false;
      } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof HashMap)));
      paramMessage = (HashMap)paramMessage.obj;
      localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      i = 0;
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label871;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        j = 0;
        if (j >= ((List)localObject2).size()) {
          break label1078;
        }
        str = ((TroopMemberInfo)((List)localObject2).get(j)).memberuin;
        k = i;
        if (!paramMessage.containsKey(str)) {
          break;
        }
        i += 1;
        k = ((Integer)paramMessage.get(str)).intValue();
        ((TroopMemberInfo)((List)localObject2).get(j)).commonFrdCnt = k;
        k = i;
      } while (i >= paramMessage.size());
    }
    label1075:
    label1078:
    for (;;)
    {
      j += 1;
      i = k;
      break label774;
      label871:
      f();
      return false;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelectionFromTop(0, 0);
      return false;
      if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof HashMap))) {
        break;
      }
      paramMessage = (HashMap)paramMessage.obj;
      localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        k = 0;
        label972:
        if (k >= ((List)localObject2).size()) {
          break label1075;
        }
        str = ((TroopMemberInfo)((List)localObject2).get(k)).memberuin;
        j = i;
        if (paramMessage.containsKey(str))
        {
          j = i + 1;
          i = ((Integer)paramMessage.get(str)).intValue();
          ((TroopMemberInfo)((List)localObject2).get(k)).addState = i;
        }
        if (j >= paramMessage.size()) {
          i = j;
        }
      }
      for (;;)
      {
        break;
        k += 1;
        i = j;
        break label972;
        f();
        return false;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    ContactSearchComponentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, null, this.jdField_b_of_type_JavaLangString, 23, 1048576, 561243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame
 * JD-Core Version:    0.7.0.1
 */