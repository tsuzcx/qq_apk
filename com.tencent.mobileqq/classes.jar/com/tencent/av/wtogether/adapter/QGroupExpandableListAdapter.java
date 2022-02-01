package com.tencent.av.wtogether.adapter;

import ajjb;
import ajkw;
import ajnw;
import amju;
import amkf;
import amkh;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import antp;
import anvx;
import aofu;
import aoxz;
import bdfk;
import blbu;
import blfj;
import blfm;
import blfn;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mxr;
import mxs;
import mxt;
import mxu;
import mxv;

public class QGroupExpandableListAdapter
  extends amju
  implements View.OnClickListener, blbu, blfj, AdapterView.OnItemLongClickListener
{
  public int a;
  protected Context a;
  protected antp a;
  aofu jdField_a_of_type_Aofu = new mxu(this);
  protected blfn a;
  public QQAppInterface a;
  protected HashSet<Integer> a;
  protected List<Integer> a;
  private mxv jdField_a_of_type_Mxv;
  public int[] a;
  private int b;
  protected List<Entity> b;
  protected int[] b;
  private int c;
  protected List<amkh> c;
  protected int[] c;
  protected List<amkh> d = new ArrayList();
  protected List<amkh> e = new ArrayList();
  protected List<amkh> f = new ArrayList();
  protected List<amkh> g = new ArrayList();
  
  public QGroupExpandableListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, mxv parammxv)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(4);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(5);
    this.jdField_a_of_type_Int = -2;
    this.jdField_a_of_type_ArrayOfInt = new int[6];
    this.jdField_b_of_type_ArrayOfInt = new int[6];
    this.jdField_c_of_type_ArrayOfInt = new int[6];
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Mxv = parammxv;
    this.jdField_b_of_type_Int = AIOUtils.dp2px(56.0F, paramContext.getResources());
    this.jdField_c_of_type_Int = AIOUtils.dp2px(44.0F, paramContext.getResources());
    this.jdField_a_of_type_Blfn = new mxr(this, 1, 1, new int[] { paramContext.getResources().getDimensionPixelSize(2131296809) }, -1, new int[] { 2131370911, 2131370911 }, new int[] { 2131692964, 2131692962 }, new int[] { 2130839571, 2130839571 });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
    this.jdField_a_of_type_Antp = ((antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.setOnItemLongClickListener(this);
  }
  
  private int a(List<amkh> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      amkh localamkh = (amkh)paramList.next();
      if ((localamkh.a == null) || (!(localamkh.a instanceof TroopInfo)) || (((TroopInfo)localamkh.a).lastMsgTime <= 0L)) {
        break label100;
      }
      i += 1;
    }
    label100:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("QGroupListAdapter", 2, "getActiveTroopCount activeTroopCount:" + i);
      }
      return i;
    }
  }
  
  private View a(int paramInt)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562988, null);
    TextView localTextView = (TextView)localView.findViewById(2131367176);
    String str = anvx.a(2131702036) + this.jdField_c_of_type_ArrayOfInt[paramInt] + ")";
    localTextView.setText(str);
    localView.setOnClickListener(new mxs(this, paramInt));
    localView.setOnTouchListener(new mxt(this, localTextView));
    localView.setContentDescription(str + anvx.a(2131702009));
    return localView;
  }
  
  private Entity a(int paramInt1, int paramInt2)
  {
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return null;
    case 0: 
      return (Entity)this.jdField_b_of_type_JavaUtilList.get(paramInt2);
    case 4: 
      return ((amkh)this.jdField_c_of_type_JavaUtilList.get(paramInt2)).a;
    case 6: 
      return ((amkh)this.d.get(paramInt2)).a;
    case 2: 
      return ((amkh)this.e.get(paramInt2)).a;
    case 8: 
      return ((amkh)this.f.get(paramInt2)).a;
    }
    return ((amkh)this.g.get(paramInt2)).a;
  }
  
  private void a(int paramInt)
  {
    int j = 0;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {}
    int i;
    label107:
    int k;
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
      if (j <= 10)
      {
        this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
        if (j > 10) {
          break label286;
        }
        k = j;
      }
      break;
    }
    for (;;)
    {
      this.jdField_b_of_type_ArrayOfInt[paramInt] = k;
      this.jdField_c_of_type_ArrayOfInt[paramInt] = (j - k);
      return;
      j = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      i = 0;
      break;
      j = this.jdField_c_of_type_JavaUtilList.size();
      i = a(this.jdField_c_of_type_JavaUtilList);
      break;
      j = this.d.size();
      i = a(this.d);
      break;
      j = this.e.size();
      i = a(this.e);
      break;
      j = this.f.size();
      i = a(this.f);
      break;
      j = this.g.size();
      i = a(this.g);
      break;
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 0) {
        break label107;
      }
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 1;
      break label107;
      label286:
      k = i;
      if (i < 10) {
        k = 10;
      }
    }
  }
  
  private void a(ajkw paramajkw)
  {
    int k = 0;
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      i = 0;
      if (!this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(i)) {
        break label100;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(i);
      this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(i));
      i = k;
    }
    for (;;)
    {
      if (i >= this.jdField_a_of_type_ArrayOfInt.length) {
        return;
      }
      if (this.jdField_a_of_type_ArrayOfInt[i] == 2) {
        this.jdField_a_of_type_ArrayOfInt[i] = 1;
      }
      i += 1;
      continue;
      i = paramajkw.jdField_a_of_type_Int;
      break;
      label100:
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(j))
        {
          this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(j);
          this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(j));
        }
        j += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
      i = k;
    }
  }
  
  private void a(ajkw paramajkw, int paramInt, boolean paramBoolean)
  {
    int i;
    String str1;
    int j;
    int k;
    if (paramajkw != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {}
      switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
      {
      case 1: 
      case 3: 
      case 5: 
      case 7: 
      case 9: 
      default: 
        i = 0;
        str1 = "";
        j = 0;
        if (j <= 10)
        {
          k = j;
          label118:
          if (j > 10) {
            break label457;
          }
          this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
          label132:
          this.jdField_b_of_type_ArrayOfInt[paramInt] = k;
          this.jdField_c_of_type_ArrayOfInt[paramInt] = (j - k);
          if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 1) {
            break label480;
          }
        }
        break;
      }
    }
    label457:
    label480:
    for (String str2 = k + "/" + j;; str2 = "" + j)
    {
      paramajkw.jdField_a_of_type_Int = paramInt;
      paramajkw.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str1);
      paramajkw.b.setVisibility(8);
      paramajkw.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramajkw.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramajkw.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText(str2);
      paramajkw.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      return;
      str1 = anvx.a(2131702048);
      j = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      i = 0;
      break;
      str1 = anvx.a(2131715183);
      j = this.jdField_c_of_type_JavaUtilList.size();
      i = a(this.jdField_c_of_type_JavaUtilList);
      break;
      str1 = anvx.a(2131715186);
      j = this.d.size();
      i = a(this.d);
      break;
      str1 = anvx.a(2131715179);
      j = this.e.size();
      i = a(this.e);
      break;
      str1 = anvx.a(2131715184);
      j = this.f.size();
      i = a(this.f);
      break;
      str1 = anvx.a(2131702064);
      j = this.g.size();
      i = a(this.g);
      break;
      k = i;
      if (i >= 10) {
        break label118;
      }
      k = 10;
      break label118;
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 0) {
        break label132;
      }
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 1;
      notifyDataSetChanged();
      break label132;
    }
  }
  
  private void a(ajnw paramajnw)
  {
    String str;
    if ((paramajnw.jdField_a_of_type_JavaLangObject instanceof DiscussionInfo))
    {
      paramajnw = (DiscussionInfo)paramajnw.jdField_a_of_type_JavaLangObject;
      str = paramajnw.uin;
    }
    for (paramajnw = paramajnw.discussionName;; paramajnw = paramajnw.getTroopName())
    {
      this.jdField_a_of_type_Mxv.a(str, paramajnw);
      return;
      paramajnw = (TroopInfo)paramajnw.jdField_a_of_type_JavaLangObject;
      str = paramajnw.getTroopUin();
    }
  }
  
  private void a(DiscussionInfo paramDiscussionInfo, ajnw paramajnw, int paramInt1, int paramInt2, View paramView)
  {
    paramajnw.jdField_a_of_type_JavaLangString = paramDiscussionInfo.uin;
    paramajnw.jdField_a_of_type_JavaLangObject = paramDiscussionInfo;
    paramajnw.jdField_b_of_type_Int = 101;
    paramajnw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    paramajnw.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramajnw.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramajnw.jdField_a_of_type_AndroidWidgetTextView.setText(paramDiscussionInfo.discussionName);
    int i = this.jdField_a_of_type_Antp.a(paramDiscussionInfo.uin);
    if ((!paramDiscussionInfo.hasRenamed()) && (i > 0))
    {
      paramajnw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramajnw.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QGroupListAdapter", 2, "DiscussionInfo hasRenamed:" + paramDiscussionInfo.hasRenamed() + " | memberNum:" + i + " | uin:" + paramDiscussionInfo.uin + "  discussionName:" + paramDiscussionInfo.discussionName);
      }
      if ((paramDiscussionInfo.lastMsgTime != 0L) || (AppSetting.c)) {
        paramajnw.g.setContentDescription(paramajnw.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      a(paramajnw, null);
      paramView.setOnClickListener(this);
      a(paramView, paramInt1 << 16 | paramInt2, paramajnw, this, paramDiscussionInfo);
      return;
      paramajnw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void a(TroopInfo paramTroopInfo, ajnw paramajnw, int paramInt1, int paramInt2, View paramView)
  {
    paramajnw.jdField_a_of_type_JavaLangString = paramTroopInfo.troopuin;
    paramajnw.jdField_a_of_type_JavaLangObject = paramTroopInfo;
    paramajnw.jdField_b_of_type_Int = 4;
    paramajnw.jdField_a_of_type_Boolean = a(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramTroopInfo.troopuin);
    Object localObject;
    if (i == 3)
    {
      paramajnw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramajnw.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850473);
      TextView localTextView = paramajnw.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(paramTroopInfo.getTroopName())) {
        break label418;
      }
      localObject = paramTroopInfo.getTroopName();
      label88:
      localTextView.setText((CharSequence)localObject);
      if ((paramTroopInfo.hasSetTroopName()) || (paramTroopInfo.wMemberNumClient <= 0)) {
        break label427;
      }
      paramajnw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramajnw.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(paramTroopInfo.wMemberNumClient) }));
      label144:
      if (QLog.isColorLevel()) {
        QLog.d("QGroupListAdapter", 2, "TroopInfo hasSetTroopName:" + paramTroopInfo.hasSetTroopName() + " | memberNum:" + paramTroopInfo.wMemberNumClient);
      }
      if ((paramTroopInfo.lastMsgTime == 0L) && ((paramTroopInfo.dwGroupFlagExt & 0x800) == 0L)) {
        break label481;
      }
      if (paramTroopInfo.dwAuthGroupType != 2L) {
        break label439;
      }
      paramajnw.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramajnw.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843910);
      label243:
      if (!paramTroopInfo.isTroopBlocked) {
        break label506;
      }
      paramajnw.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!bdfk.b()) {
        break label493;
      }
      paramajnw.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842524);
      label274:
      paramajnw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramajnw.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850749);
      localObject = (FrameLayout.LayoutParams)paramajnw.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localObject != null)
      {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = (-ViewUtils.dpToPx(2.0F));
        ((FrameLayout.LayoutParams)localObject).rightMargin = (-ViewUtils.dpToPx(3.0F));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramajnw.g.setContentDescription(paramajnw.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      a(paramajnw, null);
      paramView.setOnClickListener(this);
      a(paramView, paramInt1 << 16 | paramInt2, paramajnw, this, paramTroopInfo);
      return;
      if (i == 1)
      {
        paramajnw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        break;
      }
      paramajnw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramajnw.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839547);
      break;
      label418:
      localObject = paramTroopInfo.troopuin;
      break label88;
      label427:
      paramajnw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label144;
      label439:
      if (paramTroopInfo.dwAuthGroupType == 1L)
      {
        paramajnw.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramajnw.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843910);
        break label243;
      }
      paramajnw.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label243;
      label481:
      paramajnw.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label243;
      label493:
      paramajnw.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842523);
      break label274;
      label506:
      if (paramTroopInfo.troopCreditLevel == 2L)
      {
        paramajnw.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (bdfk.b()) {
          paramajnw.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842524);
        }
        for (;;)
        {
          paramajnw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramajnw.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850476);
          break;
          paramajnw.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842523);
        }
      }
      if (paramTroopInfo.troopCreditLevel == 1L)
      {
        paramajnw.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (bdfk.b()) {
          paramajnw.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842524);
        }
        for (;;)
        {
          paramajnw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramajnw.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850474);
          break;
          paramajnw.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842523);
        }
      }
      paramajnw.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 > 0) && (paramInt1 < this.jdField_b_of_type_ArrayOfInt.length) && (paramInt2 > this.jdField_b_of_type_ArrayOfInt[paramInt1]);
  }
  
  private void b(ajkw paramajkw)
  {
    a(paramajkw);
    a(paramajkw.jdField_a_of_type_Int);
  }
  
  private void d()
  {
    QGroupExpandableListAdapter.LoadTroopDiscussInfoSubRunnable localLoadTroopDiscussInfoSubRunnable = new QGroupExpandableListAdapter.LoadTroopDiscussInfoSubRunnable(this, null);
    localLoadTroopDiscussInfoSubRunnable.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    localLoadTroopDiscussInfoSubRunnable.jdField_a_of_type_Aoxz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    ThreadManager.post(localLoadTroopDiscussInfoSubRunnable, 8, null, true);
  }
  
  private void e()
  {
    boolean bool = false;
    Object localObject = new amkf();
    Collections.sort(this.jdField_c_of_type_JavaUtilList, (Comparator)localObject);
    Collections.sort(this.d, (Comparator)localObject);
    Collections.sort(this.e, (Comparator)localObject);
    Collections.sort(this.f, (Comparator)localObject);
    Collections.sort(this.g, (Comparator)localObject);
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
      }
      if (this.f.size() > 0) {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
      }
      if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(4));
      }
      if (this.d.size() > 0) {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(6));
      }
      if (this.e.size() > 0) {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
      }
      if (this.g.size() > 0) {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(10));
      }
      localObject = new HashSet(5);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (this.jdField_a_of_type_JavaUtilList.contains(localInteger)) {
          ((HashSet)localObject).add(localInteger);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject);
    c(this);
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(0);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(0));
      if ((this.jdField_a_of_type_ComTencentWidgetExpandableListView instanceof PinnedHeaderExpandableListView))
      {
        localObject = (PinnedHeaderExpandableListView)this.jdField_a_of_type_ComTencentWidgetExpandableListView;
        if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
          bool = true;
        }
        ((PinnedHeaderExpandableListView)localObject).setHeaderViewShouldShow(bool);
      }
      return;
    }
    i = 0;
    label374:
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_a_of_type_JavaUtilList.get(i))) {
        break label423;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
    }
    for (;;)
    {
      i += 1;
      break label374;
      break;
      label423:
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(i);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    notifyDataSetChanged();
  }
  
  public void a(int paramInt, blfm[] paramArrayOfblfm, Object paramObject)
  {
    int i = 1;
    if ((paramArrayOfblfm == null) || (paramArrayOfblfm.length <= 0)) {}
    label97:
    for (;;)
    {
      return;
      if (paramArrayOfblfm.length < 0) {
        if ((paramObject instanceof TroopInfo))
        {
          paramObject = (TroopInfo)paramObject;
          if (this.jdField_b_of_type_JavaUtilList.contains(paramObject))
          {
            paramInt = 1;
            paramArrayOfblfm[0].jdField_b_of_type_Int = paramInt;
            paramArrayOfblfm[0].jdField_a_of_type_Int = 0;
            paramInt = i;
          }
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfblfm.length) {
          break label97;
        }
        paramArrayOfblfm[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfblfm[paramInt].jdField_a_of_type_Int = -1;
        paramInt += 1;
        continue;
        paramInt = 0;
        break;
        paramInt = 0;
      }
    }
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      return;
    }
    Object localObject;
    if (!(paramView.getTag() instanceof ajkw))
    {
      localObject = new ajkw();
      ((ajkw)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369395));
      ((ajkw)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367894));
      ((ajkw)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      ((ajkw)localObject).b = ((SingleLineTextView)paramView.findViewById(2131380118));
      ((ajkw)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131365094));
      ((ajkw)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      ((ajkw)localObject).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369501));
      paramView.setTag(localObject);
      paramView = (View)localObject;
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
        break label180;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramView, paramInt, this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramInt));
      return;
      paramView = (ajkw)paramView.getTag();
      break;
      label180:
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167110);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor((ColorStateList)localObject);
    }
  }
  
  public void a(View paramView, int paramInt, ajjb paramajjb, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    if (this.jdField_a_of_type_Blfn != null) {}
    for (int i = this.jdField_a_of_type_Blfn.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, paramObject, paramajjb, paramOnClickListener);; i = 0)
    {
      if (this.jdField_a_of_type_Int != -1)
      {
        if (paramInt != this.jdField_a_of_type_Int) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
    }
  }
  
  public void a(TroopInfo paramTroopInfo, aoxz paramaoxz)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramTroopInfo.troopuin) == 2)
    {
      paramTroopInfo.lastMsgTime = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramTroopInfo.troopuin, 1).time;
      return;
    }
    paramTroopInfo.lastMsgTime = ((RecentUser)paramaoxz.findRecentUserByUin(paramTroopInfo.troopuin, 1)).lastmsgtime;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.c(paramBoolean);
      return;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(View paramView)
  {
    return true;
  }
  
  public boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof ajkw)) {
      a((ajkw)paramExpandableListView);
    }
    return true;
  }
  
  public int a_()
  {
    return 2131558983;
  }
  
  public void b() {}
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.setOnItemLongClickListener(null);
      int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i);
        if (localView != null)
        {
          localView.setOnClickListener(null);
          localView.setOnLongClickListener(null);
        }
        i += 1;
      }
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return Integer.valueOf(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt2 == getChildrenCount(paramInt1) - 1) && (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1)) {
      paramViewGroup = a(paramInt1);
    }
    Object localObject;
    do
    {
      return paramViewGroup;
      if ((paramView == null) || (!(paramView.getTag() instanceof ajnw)))
      {
        localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562989, null);
        ((View)localObject).setMinimumHeight(this.jdField_b_of_type_Int);
        paramViewGroup = new ajnw();
        paramView = this.jdField_a_of_type_Blfn.a(this.jdField_a_of_type_AndroidContentContext, (View)localObject, paramViewGroup, -1);
        paramViewGroup.g = ((View)localObject);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378659));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378661));
        paramViewGroup.d = ((ImageView)paramView.findViewById(2131368381));
        if ((paramViewGroup.d instanceof ThemeImageView)) {
          ((ThemeImageView)paramViewGroup.d).setSupportMaskView(false);
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370784));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378013));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371646));
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379425));
        localObject = paramView.getResources().getColorStateList(2131167033);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_Int = paramInt1;
        localObject = a(paramInt1, paramInt2);
        if ((localObject == null) || (!(localObject instanceof TroopInfo))) {
          break;
        }
        a((TroopInfo)localObject, paramViewGroup, paramInt1, paramInt2, paramView);
        return paramView;
        paramViewGroup = (ajnw)paramView.getTag();
      }
      if ((localObject != null) && ((localObject instanceof DiscussionInfo)))
      {
        a((DiscussionInfo)localObject, paramViewGroup, paramInt1, paramInt2, paramView);
        return paramView;
      }
      paramViewGroup = paramView;
    } while (!QLog.isColorLevel());
    QLog.d("QGroupListAdapter", 2, "getChildView data:" + localObject + " groupPosition:" + paramInt1 + " childPosition:" + paramInt2);
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i;
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      i = 0;
      return i;
    }
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
    }
    for (;;)
    {
      int j = i;
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] == 1)
      {
        j = i;
        if (this.jdField_b_of_type_ArrayOfInt[paramInt] < i) {
          j = this.jdField_b_of_type_ArrayOfInt[paramInt] + 1;
        }
      }
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QGroupListAdapter", 2, "getChildrenCount count:" + j + "  groupPosition:" + paramInt);
      return j;
      i = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      continue;
      i = this.jdField_c_of_type_JavaUtilList.size();
      continue;
      i = this.d.size();
      continue;
      i = this.e.size();
      continue;
      i = this.f.size();
      continue;
      i = this.g.size();
    }
  }
  
  public Object getGroup(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public int getGroupCount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QGroupListAdapter", 2, "getChildrenCount mGroups.size():" + this.jdField_a_of_type_JavaUtilList.size());
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558983, paramViewGroup, false);
      paramViewGroup = new ajkw();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367894));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369395));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131365094));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369501));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131380118));
      paramView.setTag(paramViewGroup);
    }
    while (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
      paramViewGroup = (ajkw)paramView.getTag();
    }
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_c_of_type_Int));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramViewGroup, paramInt, paramBoolean);
      paramView.setOnClickListener(this);
      return paramView;
      ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167110);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(localColorStateList);
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b == null)
    {
      ThreadManager.postImmediately(new QGroupExpandableListAdapter.4(this), null, false);
      return;
    }
    d();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof ajkw)) {
      b((ajkw)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof ajnw)) {
        a((ajnw)localObject);
      }
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */