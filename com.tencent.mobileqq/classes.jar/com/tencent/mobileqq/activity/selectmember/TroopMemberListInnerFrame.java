package com.tencent.mobileqq.activity.selectmember;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopRankConfig.TroopRankItem;
import com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class TroopMemberListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  protected static double b;
  private static int d;
  protected double a;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  Handler jdField_a_of_type_AndroidOsHandler = new TroopMemberListInnerFrame.1(this);
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  protected ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TroopMemberListInnerFrame.TroopMemberListAdapter jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopMemberListInnerFrame.8(this);
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopMemberListInnerFrame.7(this);
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new TroopMemberListInnerFrame.9(this);
  String jdField_a_of_type_JavaLangString = "";
  List<TroopMemberInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  Map<String, List<TroopMemberInfo>> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
  boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt = new int[0];
  String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  int jdField_b_of_type_Int = 1;
  protected RelativeLayout b;
  protected TextView b;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  protected TextView c;
  private String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  protected TextView d;
  
  static
  {
    jdField_b_of_type_Double = 10.0D;
    jdField_d_of_type_Int = 1000;
  }
  
  public TroopMemberListInnerFrame(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public TroopMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public TroopMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  private int a(Map<String, List<TroopMemberInfo>> paramMap)
  {
    Object localObject1 = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    Object localObject2 = (QidianManager)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(QQManagerFactory.QIDIAN_MANAGER);
    boolean bool = TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getCurrentAccountUin());
    int k;
    Object localObject3;
    if ((!TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getCurrentAccountUin())) && (!bool))
    {
      k = 1;
      localObject3 = paramMap.values().iterator();
    }
    List localList;
    for (int m = 0;; m = localList.size() + m)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label285;
      }
      localList = (List)((Iterator)localObject3).next();
      int j = 0;
      label137:
      if (j < localList.size())
      {
        int i;
        if (localList.get(j) == null)
        {
          localList.remove(j);
          i = j - 1;
        }
        for (;;)
        {
          j = i + 1;
          break label137;
          k = 0;
          break;
          if (((QidianManager)localObject2).f(((TroopMemberInfo)localList.get(j)).memberuin))
          {
            localList.remove(j);
            i = j - 1;
          }
          else
          {
            i = j;
            if (k != 0)
            {
              i = j;
              if (((TroopRobotManager)localObject1).b(((TroopMemberInfo)localList.get(j)).memberuin))
              {
                localList.remove(j);
                i = j - 1;
              }
            }
          }
        }
      }
    }
    label285:
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
    return m;
  }
  
  /* Error */
  private Bitmap a(View paramView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 255	android/view/View:getWidth	()I
    //   4: istore_2
    //   5: aload_1
    //   6: invokevirtual 258	android/view/View:getHeight	()I
    //   9: istore_3
    //   10: iload_2
    //   11: ifeq +43 -> 54
    //   14: iload_3
    //   15: ifeq +39 -> 54
    //   18: iload_2
    //   19: iload_3
    //   20: getstatic 264	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   23: invokestatic 270	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   26: astore 4
    //   28: aload_1
    //   29: new 272	android/graphics/Canvas
    //   32: dup
    //   33: aload 4
    //   35: invokespecial 275	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   38: invokevirtual 279	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   41: aload 4
    //   43: areturn
    //   44: astore_1
    //   45: aconst_null
    //   46: areturn
    //   47: astore_1
    //   48: aconst_null
    //   49: areturn
    //   50: astore_1
    //   51: aload 4
    //   53: areturn
    //   54: aconst_null
    //   55: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	TroopMemberListInnerFrame
    //   0	56	1	paramView	View
    //   4	15	2	i	int
    //   9	11	3	j	int
    //   26	26	4	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   0	10	44	java/lang/Exception
    //   18	28	44	java/lang/Exception
    //   28	41	44	java/lang/Exception
    //   0	10	47	java/lang/OutOfMemoryError
    //   18	28	47	java/lang/OutOfMemoryError
    //   28	41	50	java/lang/OutOfMemoryError
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (Object[])paramMessage.obj;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if (paramMessage.length == 3)
    {
      this.jdField_a_of_type_JavaUtilMap = ((Map)paramMessage[0]);
      this.jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[1]);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[2]);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QQGameTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity))
      {
        paramMessage = (QQGameTroopManager)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(QQManagerFactory.GAME_TROOP_MANAGER);
        paramMessage.b();
        paramMessage.a("member");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.notifyDataSetChanged();
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity;
      if (this.jdField_b_of_type_Int != 2) {
        break label181;
      }
    }
    label181:
    for (boolean bool = true;; bool = false)
    {
      paramMessage.a(bool, this.jdField_c_of_type_Int);
      return;
      this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
      this.jdField_a_of_type_ArrayOfInt = new int[0];
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
    }
  }
  
  private void a(String paramString, List<TroopMemberInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      try
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        paramList = ((EntityManager)localObject).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
        ((EntityManager)localObject).close();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("getTroopMemberFromDB, troopMemberInfoList==null, queryDB, troopUin=").append(paramString).append(",");
          TroopInfo localTroopInfo;
          String str;
          if (paramList == null)
          {
            i = 0;
            QLog.d("TroopMemberListInnerFrame.thread", 2, i);
            break label419;
            localObject = Collections.synchronizedMap(new LinkedHashMap());
            localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_b_of_type_JavaLangString);
            str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            if (paramList == null)
            {
              paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
              this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
            }
          }
          else
          {
            i = paramList.size();
            continue;
            if (!QLog.isColorLevel()) {
              break label422;
            }
            localObject = new StringBuilder().append("getTroopMemberFromDB, troopuin=").append(paramString).append(",");
            if (paramList == null)
            {
              i = 0;
              QLog.d("TroopMemberListInnerFrame.thread", 2, i);
              break label422;
            }
            i = paramList.size();
            continue;
          }
          int j = paramList.size();
          this.jdField_a_of_type_Int = (j - 1);
          if (j > 0)
          {
            int k = j / jdField_d_of_type_Int;
            if (j % jdField_d_of_type_Int != 0) {
              break label430;
            }
            i = 0;
            AtomicInteger localAtomicInteger = new AtomicInteger(i + k);
            if (!QLog.isColorLevel()) {
              break label425;
            }
            QLog.d("TroopMemberListInnerFrame.thread", 2, "parallel process mJobCount: " + localAtomicInteger.get());
            break label425;
            if (i < j)
            {
              ThreadManager.post(new TroopMemberListInnerFrame.5(this, paramList, i, Math.min(jdField_d_of_type_Int + i - 1, j), paramString, str, localTroopInfo, (Map)localObject, localAtomicInteger), 8, null, false);
              i += jdField_d_of_type_Int;
              continue;
            }
            continue;
          }
          paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
          continue;
        }
        continue;
      }
      finally {}
      label419:
      label422:
      continue;
      label425:
      int i = 0;
      continue;
      label430:
      i = 1;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
    {
      if ((paramString == null) || (paramBoolean) || (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {
        break label46;
      }
      paramBoolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      return;
      label46:
      int j = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.getCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label105;
        }
        paramString = (TroopMemberInfo)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.getItem(i);
        if ((paramString != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(paramString.memberuin)))
        {
          paramBoolean = false;
          break;
        }
        i += 1;
      }
      label105:
      paramBoolean = true;
    }
  }
  
  private Object[] a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      Collections.sort((List)this.jdField_a_of_type_JavaUtilMap.get(localObject2), new TroopMemberListInnerFrame.MyComparator(this, null));
    }
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.p) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.u) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo != null))
    {
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
      this.jdField_a_of_type_JavaUtilMap.put(HardCodeUtil.a(2131715450), localObject2);
    }
    for (char c1 = 'A'; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
      if (((Map)localObject1).get(String.valueOf(c1)) != null) {
        this.jdField_a_of_type_JavaUtilMap.put(String.valueOf(c1), ((Map)localObject1).get(String.valueOf(c1)));
      }
    }
    if (((Map)localObject1).get("#") != null) {
      this.jdField_a_of_type_JavaUtilMap.put("#", ((Map)localObject1).get("#"));
    }
    ((Map)localObject1).clear();
    localObject1 = new int[this.jdField_a_of_type_JavaUtilMap.keySet().size()];
    Object localObject2 = new String[this.jdField_a_of_type_JavaUtilMap.keySet().size()];
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    if (localObject1.length == 0) {
      return new Object[0];
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
    localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      localObject2[i] = ((String)localIterator.next());
      i += 1;
    }
    return new Object[] { this.jdField_a_of_type_JavaUtilMap, localObject1, localObject2 };
  }
  
  private void b(String paramString)
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
        if (NetworkUtil.d(BaseApplication.getContext())) {
          break label93;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.q();
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131692257), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c.getHeight());
      }
    }
    return;
    label93:
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListInnerFrame", 2, "get troop members from server, troopUin: " + paramString + " troopCode: " + str);
    }
    Object localObject = (TroopMemberInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ((TroopMemberInfoHandler)localObject).a(true, paramString, str, true, 7, this.jdField_a_of_type_Long, 0);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364583));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131369039));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167305);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380483));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377278));
    Object localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370665);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364487));
    ((LinearLayout)localObject1).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379955));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131368512));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370760));
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 21)
    {
      localObject1 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getWindow().getDecorView();
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      Object localObject2 = new LinearLayout.LayoutParams(-2, (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 17.0F));
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      int i = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 4.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167093));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715403));
      localObject2 = TroopRankConfig.a().a(301, false, false, true);
      if (localObject2 != null) {
        TroopRankConfig.a(this.jdField_b_of_type_AndroidWidgetTextView, ((TroopRankConfig.TroopRankItem)localObject2).jdField_b_of_type_Int);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      ((ViewGroup)localObject1).addView(this.jdField_b_of_type_AndroidWidgetTextView);
      this.jdField_c_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      localObject2 = new LinearLayout.LayoutParams(-2, (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 17.0F));
      this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167093));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715447));
      localObject2 = TroopRankConfig.a().a(300, false, true, false);
      if (localObject2 != null) {
        TroopRankConfig.a(this.jdField_c_of_type_AndroidWidgetTextView, ((TroopRankConfig.TroopRankItem)localObject2).jdField_b_of_type_Int);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      ((ViewGroup)localObject1).addView(this.jdField_c_of_type_AndroidWidgetTextView);
      this.jdField_b_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new TroopMemberListInnerFrame.2(this, (ViewGroup)localObject1));
      this.jdField_c_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new TroopMemberListInnerFrame.3(this, (ViewGroup)localObject1));
    }
  }
  
  private void h()
  {
    long l1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getSharedPreferences("last_update_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).getLong("key_last_update_time" + this.jdField_b_of_type_JavaLangString, 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListInnerFrame", 2, "getTroopMembers, lastUpdateTime=" + l1 + ", curTime=" + l2 + ", diff=" + l3 + ", " + hashCode());
    }
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_b_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int != 21) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null))
    {
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum - 1);
      if (this.jdField_a_of_type_Int > 0)
      {
        this.jdField_a_of_type_Double = 0.0D;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4));
      }
    }
    if ((l1 == 0L) || ((l1 > 0L) && (l3 > 300000L)))
    {
      b(this.jdField_b_of_type_JavaLangString);
      return;
    }
    TroopMemberListInnerFrame.4 local4 = new TroopMemberListInnerFrame.4(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(local4);
  }
  
  public CharDividedFacePreloadBaseAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter;
  }
  
  public ContactSearchFragment a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int != 21) {
      return ContactSearchFragment.a(-1, 8192, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
    }
    return ContactSearchFragment.a(-1, 262144, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected Map<String, List<TroopMemberInfo>> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131562988);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    g();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter = new TroopMemberListInnerFrame.TroopMemberListAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e()) && (!QQGameTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
  }
  
  public void a(String paramString)
  {
    if (QQGameTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity)) {}
    int i;
    do
    {
      return;
      if ("$".equals(paramString))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
        return;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  protected void a(Map<String, List<TroopMemberInfo>> paramMap, int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.b();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("group_uin");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("group_name");
    this.jdField_b_of_type_Int = paramBundle.getInt("param_member_show_type", 1);
    boolean bool = paramBundle.getBoolean("param_enable_all_select", false);
    paramBundle = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    int i;
    if (bool)
    {
      i = 0;
      paramBundle.setVisibility(i);
      if (((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.length() == 0)) && (this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null))
      {
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_b_of_type_JavaLangString);
        if (paramBundle != null) {
          this.jdField_c_of_type_JavaLangString = paramBundle.getTroopDisplayName();
        }
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.h) {
        break label362;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, "", this.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0))
      {
        if (this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) {
          break label379;
        }
        this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
        this.jdField_a_of_type_ArrayOfInt = new int[0];
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_Boolean = false;
        h();
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        if (QQGameTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity))
        {
          paramBundle = (QQGameTroopManager)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(QQManagerFactory.GAME_TROOP_MANAGER);
          paramBundle.a();
          paramBundle.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
          paramBundle.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
        }
      }
      return;
      i = 8;
      break;
      label362:
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, "", this.jdField_c_of_type_JavaLangString);
    }
    label379:
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.notifyDataSetChanged();
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.c();
    }
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getTag() != null))
    {
      ((Bitmap)this.jdField_b_of_type_AndroidWidgetTextView.getTag()).recycle();
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(null);
    }
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getTag() != null))
    {
      ((Bitmap)this.jdField_c_of_type_AndroidWidgetTextView.getTag()).recycle();
      this.jdField_c_of_type_AndroidWidgetTextView.setTag(null);
    }
    if (QQGameTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity)) {
      ((QQGameTroopManager)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(QQManagerFactory.GAME_TROOP_MANAGER)).onDestroy();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.notifyDataSetChanged();
    a(null, false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (2131364487 == paramCompoundButton.getId())
    {
      if (!paramBoolean) {
        break label217;
      }
      ArrayList localArrayList = new ArrayList();
      int j = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.getCount();
      int i = 0;
      while (i < j)
      {
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.getItem(i);
        if (localTroopMemberInfo != null)
        {
          SelectMemberActivity localSelectMemberActivity = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity;
          localArrayList.add(SelectMemberActivity.a(localTroopMemberInfo.memberuin, this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(localTroopMemberInfo), 1, this.jdField_b_of_type_JavaLangString));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 31) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, "dc00898", "", "", "0X8007CFB", "0X8007CFB", 0, 0, "", "", "", "");
        }
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localArrayList, false, true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 35) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, "CliOper", "", "", "0X8009E2C", "0X8009E2C", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.notifyDataSetChanged();
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      label217:
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d();
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 35) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, "CliOper", "", "", "0X8009E2D", "0X8009E2D", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    boolean bool;
    if (2131370665 != paramView.getId())
    {
      localObject1 = (TroopMemberListInnerFrame.ViewHolder)paramView.getTag();
      if ((localObject1 != null) && (((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox != null) && (((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView != null) && (((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_JavaLangString, ((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.getText().toString(), 1, this.jdField_b_of_type_JavaLangString);
        ((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        a(((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_JavaLangString, bool);
        if (AppSetting.d)
        {
          if (!((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label177;
          }
          paramView.setContentDescription(((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.getText().toString() + HardCodeUtil.a(2131715479));
          if (!((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label218;
          }
          localObject1 = HardCodeUtil.a(2131715445);
          label163:
          AccessibilityUtils.a(paramView, (String)localObject1);
        }
      }
    }
    label177:
    label218:
    label365:
    label382:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        paramView.setContentDescription(((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.getText().toString() + HardCodeUtil.a(2131715463));
        break;
        localObject1 = HardCodeUtil.a(2131715430);
        break label163;
        if (((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int != 32) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int != 43)) || (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) || (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g >= this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.b())) {
          break label365;
        }
        localObject1 = new TroopMemberListInnerFrame.6(this);
        String str = MessageFormat.format(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719001), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g) });
        localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 232, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getString(2131719900), str, 2131690800, 2131698867, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject1);
        try
        {
          ((Dialog)localObject1).show();
        }
        catch (Throwable localThrowable) {}
      }
      localObject2 = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label436;
      }
      bool = true;
      ((CheckBox)localObject2).setChecked(bool);
      onCheckedChanged(this.jdField_a_of_type_AndroidWidgetCheckBox, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
    } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int != 32);
    if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (Object localObject2 = "friendsfinder.all.confirm";; localObject2 = "friendsfinder.all.cancel")
    {
      QWalletTools.a(0, (String)localObject2);
      break;
      label436:
      bool = false;
      break label382;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame
 * JD-Core Version:    0.7.0.1
 */