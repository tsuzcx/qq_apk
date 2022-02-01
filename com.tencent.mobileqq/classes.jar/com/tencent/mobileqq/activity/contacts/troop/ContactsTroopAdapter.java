package com.tencent.mobileqq.activity.contacts.troop;

import agej;
import ajsp;
import ajuk;
import ajxk;
import ajxl;
import ajxm;
import ajxn;
import ajxo;
import ajxp;
import ajxq;
import amqz;
import amrk;
import amrm;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import antz;
import anwo;
import anws;
import anzj;
import aojs;
import apaw;
import bdgb;
import bdll;
import bdlq;
import bhga;
import bhjs;
import bhtq;
import blir;
import blji;
import bljn;
import bllm;
import blpu;
import blpx;
import blpy;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
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
import java.util.Set;
import mqq.os.MqqHandler;

public class ContactsTroopAdapter
  extends amqz
  implements View.OnClickListener, View.OnLongClickListener, bljn, bllm, blpu
{
  public int a;
  public Context a;
  protected anws a;
  aojs jdField_a_of_type_Aojs = new ajxq(this);
  protected blpy a;
  public QQAppInterface a;
  protected HashSet<Integer> a;
  protected List<Integer> a;
  private boolean jdField_a_of_type_Boolean = true;
  public int[] a;
  private int b;
  protected List<Entity> b;
  protected int[] b;
  private int c;
  protected List<amrm> c;
  protected int[] c;
  protected List<amrm> d = new ArrayList();
  protected List<amrm> e = new ArrayList();
  protected List<amrm> f = new ArrayList();
  protected List<amrm> g = new ArrayList();
  
  public ContactsTroopAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
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
    this.jdField_b_of_type_Int = agej.a(56.0F, paramContext.getResources());
    this.jdField_c_of_type_Int = agej.a(44.0F, paramContext.getResources());
    this.jdField_a_of_type_Blpy = new ajxl(this, 1, 1, new int[] { paramContext.getResources().getDimensionPixelSize(2131296753) }, -1, new int[] { 2131370758, 2131370758 }, new int[] { 2131692807, 2131692805 }, new int[] { 2130839515, 2130839515 });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
    this.jdField_a_of_type_Anws = ((anws)paramQQAppInterface.getManager(53));
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.setOnItemLongClickListener(this);
  }
  
  private int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return 0;
    }
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return 0;
    case 0: 
      return 0;
    case 4: 
      return 1;
    case 6: 
      return 2;
    case 2: 
      return 3;
    case 10: 
      return 4;
    }
    return 5;
  }
  
  private int a(List<amrm> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      amrm localamrm = (amrm)paramList.next();
      if ((localamrm.a == null) || (!(localamrm.a instanceof TroopInfo)) || (((TroopInfo)localamrm.a).lastMsgTime <= 0L)) {
        break label100;
      }
      i += 1;
    }
    label100:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "getActiveTroopCount activeTroopCount:" + i);
      }
      return i;
    }
  }
  
  private View a(int paramInt)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563033, null);
    TextView localTextView = (TextView)localView.findViewById(2131367040);
    String str = anzj.a(2131701450) + this.jdField_c_of_type_ArrayOfInt[paramInt] + ")";
    localTextView.setText(str);
    localView.setOnClickListener(new ajxm(this, paramInt));
    localView.setOnTouchListener(new ajxn(this, localTextView));
    localView.setContentDescription(str + anzj.a(2131701423));
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
      return ((amrm)this.jdField_c_of_type_JavaUtilList.get(paramInt2)).a;
    case 6: 
      return ((amrm)this.d.get(paramInt2)).a;
    case 2: 
      return ((amrm)this.e.get(paramInt2)).a;
    case 8: 
      return ((amrm)this.f.get(paramInt2)).a;
    }
    return ((amrm)this.g.get(paramInt2)).a;
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
  
  private void a(ajuk paramajuk)
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
      i = paramajuk.jdField_a_of_type_Int;
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
  
  private void a(ajuk paramajuk, int paramInt, boolean paramBoolean)
  {
    int i;
    String str1;
    int j;
    int k;
    label118:
    String str2;
    label132:
    label189:
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (paramajuk != null)
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
          if (j > 10) {
            break label609;
          }
          this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
          this.jdField_b_of_type_ArrayOfInt[paramInt] = k;
          this.jdField_c_of_type_ArrayOfInt[paramInt] = (j - k);
          if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 1) {
            break label632;
          }
          str2 = k + "/" + j;
          localStringBuilder1 = paramajuk.jdField_a_of_type_JavaLangStringBuilder;
          localStringBuilder2 = localStringBuilder1;
          if (AppSetting.c)
          {
            if (localStringBuilder1 != null) {
              break label658;
            }
            localStringBuilder1 = new StringBuilder(24);
            label221:
            localStringBuilder1.append(str1 + " 分组");
            localStringBuilder2 = localStringBuilder1;
          }
          paramajuk.jdField_a_of_type_Int = paramInt;
          paramajuk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str1);
          paramajuk.b.setVisibility(8);
          paramajuk.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramajuk.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramajuk.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText(str2);
          if (AppSetting.c) {
            localStringBuilder2.append("共" + j + "个" + str1);
          }
          paramajuk.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
          if (AppSetting.c)
          {
            if (!paramajuk.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
              break label673;
            }
            localStringBuilder2.append(" 已展开");
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramajuk.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setContentDescription(localStringBuilder2.toString());
      bhga.a(paramajuk.jdField_a_of_type_AndroidWidgetCheckBox, false);
      return;
      str1 = anzj.a(2131701462);
      j = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      i = 0;
      break;
      str1 = anzj.a(2131714603);
      j = this.jdField_c_of_type_JavaUtilList.size();
      i = a(this.jdField_c_of_type_JavaUtilList);
      break;
      str1 = anzj.a(2131714606);
      j = this.d.size();
      i = a(this.d);
      break;
      str1 = anzj.a(2131714599);
      j = this.e.size();
      i = a(this.e);
      break;
      str1 = anzj.a(2131714604);
      j = this.f.size();
      i = a(this.f);
      break;
      str1 = anzj.a(2131701478);
      j = this.g.size();
      i = a(this.g);
      break;
      k = i;
      if (i >= 10) {
        break label118;
      }
      k = 10;
      break label118;
      label609:
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 0) {
        break label132;
      }
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 1;
      notifyDataSetChanged();
      break label132;
      label632:
      str2 = "" + j;
      break label189;
      label658:
      localStringBuilder1.delete(0, localStringBuilder1.length());
      break label221;
      label673:
      localStringBuilder2.append(" 已折叠");
    }
  }
  
  private void a(ajxk paramajxk)
  {
    if ((paramajxk.jdField_a_of_type_JavaLangObject instanceof DiscussionInfo))
    {
      a(paramajxk, (DiscussionInfo)paramajxk.jdField_a_of_type_JavaLangObject);
      return;
    }
    TroopInfo localTroopInfo = (TroopInfo)paramajxk.jdField_a_of_type_JavaLangObject;
    a(paramajxk, localTroopInfo);
    bhjs.a(true);
    paramajxk = agej.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
    paramajxk.putExtra("uin", localTroopInfo.troopuin);
    if (localTroopInfo.troopcode != null) {
      paramajxk.putExtra("troop_uin", localTroopInfo.troopcode);
    }
    paramajxk.putExtra("uintype", 1);
    paramajxk.putExtra("uinname", localTroopInfo.getTroopName());
    paramajxk.putExtra("open_chatfragment_withanim", true);
    paramajxk.putExtra("isFromContactTab", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramajxk);
  }
  
  private void a(ajxk paramajxk, DiscussionInfo paramDiscussionInfo)
  {
    bhjs.a(true);
    Intent localIntent = agej.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
    localIntent.putExtra("uin", paramDiscussionInfo.uin);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramDiscussionInfo.discussionName);
    localIntent.putExtra("open_chatfragment_withanim", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    int i;
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramajxk.jdField_a_of_type_Int)).intValue())
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
      new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_grp").a(new String[] { paramDiscussionInfo.uin, String.valueOf(i) }).a();
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
    }
  }
  
  private void a(ajxk paramajxk, TroopInfo paramTroopInfo)
  {
    int i;
    int j;
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramajxk.jdField_a_of_type_Int)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
      switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramTroopInfo.troopuin))
      {
      default: 
        j = 0;
      }
      break;
    }
    for (;;)
    {
      if (paramajxk.jdField_a_of_type_Boolean) {
        new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_inactiveGrp").a(new String[] { paramTroopInfo.troopuin, String.valueOf(i) }).a();
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(i), j + "", "");
      new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_grp").a(new String[] { paramTroopInfo.troopuin, String.valueOf(i) }).a();
      if (i == 5) {
        new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_unnamedGrp").a(new String[] { paramTroopInfo.troopuin }).a();
      }
      return;
      i = 0;
      break;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      i = 5;
      break;
      j = 0;
      continue;
      j = 2;
      continue;
      j = 3;
      continue;
      j = 1;
    }
  }
  
  private void a(DiscussionInfo paramDiscussionInfo)
  {
    blir localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
    anwo localanwo = (anwo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
    boolean bool = localanwo.a(paramDiscussionInfo);
    if (bool) {}
    for (int i = 2131692805;; i = 2131692807)
    {
      localblir.b(i);
      localblir.c(2131690580);
      localblir.a(new ajxp(this, localanwo, paramDiscussionInfo, bool, localblir));
      try
      {
        localblir.show();
        return;
      }
      catch (Exception paramDiscussionInfo) {}
    }
  }
  
  private void a(DiscussionInfo paramDiscussionInfo, ajxk paramajxk, int paramInt1, int paramInt2, View paramView)
  {
    paramajxk.jdField_a_of_type_JavaLangString = paramDiscussionInfo.uin;
    paramajxk.jdField_a_of_type_JavaLangObject = paramDiscussionInfo;
    paramajxk.jdField_b_of_type_Int = 101;
    paramajxk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    paramajxk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramajxk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramajxk.jdField_a_of_type_AndroidWidgetTextView.setText(paramDiscussionInfo.discussionName);
    int i = this.jdField_a_of_type_Anws.a(paramDiscussionInfo.uin);
    if ((!paramDiscussionInfo.hasRenamed()) && (i > 0))
    {
      paramajxk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramajxk.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "DiscussionInfo hasRenamed:" + paramDiscussionInfo.hasRenamed() + " | memberNum:" + i + " | uin:" + paramDiscussionInfo.uin + "  discussionName:" + paramDiscussionInfo.discussionName);
      }
      if ((paramDiscussionInfo.lastMsgTime != 0L) || (AppSetting.c)) {
        paramajxk.g.setContentDescription(paramajxk.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      a(paramajxk, null);
      paramView.setOnClickListener(this);
      paramView.setOnLongClickListener(this);
      a(paramView, paramInt1 << 16 | paramInt2, paramajxk, this, paramDiscussionInfo);
      return;
      paramajxk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    boolean bool = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramTroopInfo.troopuin);
    Object localObject1 = (antz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
    int i;
    label62:
    Object localObject2;
    if (bool)
    {
      i = 1;
      if (((antz)localObject1).a(paramTroopInfo.troopcode, i))
      {
        if (!bool) {
          break label191;
        }
        localObject1 = "Clk_uncommgrp";
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_contactlist", (String)localObject1, 0, 0, paramTroopInfo.troopuin, "", "", "");
        localObject2 = new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_set").c("Grp_contactlist");
        if (!bool) {
          break label199;
        }
        localObject1 = "Clk_unstick";
        label138:
        localObject1 = ((bdlq)localObject2).d((String)localObject1);
        localObject2 = paramTroopInfo.troopuin;
        if (!paramTroopInfo.hasSetTroopHead()) {
          break label207;
        }
      }
    }
    label191:
    label199:
    label207:
    for (paramTroopInfo = "1";; paramTroopInfo = "0")
    {
      ((bdlq)localObject1).a(new String[] { localObject2, paramTroopInfo }).a();
      return;
      i = 0;
      break;
      localObject1 = "Clk_setcommgrp";
      break label62;
      localObject1 = "Clk_stick";
      break label138;
    }
  }
  
  private void a(TroopInfo paramTroopInfo, ajxk paramajxk, int paramInt1, int paramInt2, View paramView)
  {
    paramajxk.jdField_a_of_type_JavaLangString = paramTroopInfo.troopuin;
    paramajxk.jdField_a_of_type_JavaLangObject = paramTroopInfo;
    paramajxk.jdField_b_of_type_Int = 4;
    paramajxk.jdField_a_of_type_Boolean = a(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramTroopInfo.troopuin);
    Object localObject;
    if (i == 3)
    {
      paramajxk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramajxk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850442);
      TextView localTextView = paramajxk.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(paramTroopInfo.getTroopName())) {
        break label424;
      }
      localObject = paramTroopInfo.getTroopName();
      label88:
      localTextView.setText((CharSequence)localObject);
      if ((paramTroopInfo.hasSetTroopName()) || (paramTroopInfo.wMemberNumClient <= 0)) {
        break label433;
      }
      paramajxk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramajxk.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(paramTroopInfo.wMemberNumClient) }));
      label144:
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "TroopInfo hasSetTroopName:" + paramTroopInfo.hasSetTroopName() + " | memberNum:" + paramTroopInfo.wMemberNumClient);
      }
      if ((paramTroopInfo.lastMsgTime == 0L) && ((paramTroopInfo.dwGroupFlagExt & 0x800) == 0L)) {
        break label487;
      }
      if (paramTroopInfo.dwAuthGroupType != 2L) {
        break label445;
      }
      paramajxk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramajxk.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843809);
      label243:
      if (!paramTroopInfo.isTroopBlocked) {
        break label512;
      }
      paramajxk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!bdgb.b()) {
        break label499;
      }
      paramajxk.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842448);
      label274:
      paramajxk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramajxk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850693);
      localObject = (FrameLayout.LayoutParams)paramajxk.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localObject != null)
      {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = (-bhtq.b(2.0F));
        ((FrameLayout.LayoutParams)localObject).rightMargin = (-bhtq.b(3.0F));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramajxk.g.setContentDescription(paramajxk.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      a(paramajxk, null);
      paramView.setOnClickListener(this);
      paramView.setOnLongClickListener(this);
      a(paramView, paramInt1 << 16 | paramInt2, paramajxk, this, paramTroopInfo);
      return;
      if (i == 1)
      {
        paramajxk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        break;
      }
      paramajxk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramajxk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839491);
      break;
      label424:
      localObject = paramTroopInfo.troopuin;
      break label88;
      label433:
      paramajxk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label144;
      label445:
      if (paramTroopInfo.dwAuthGroupType == 1L)
      {
        paramajxk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramajxk.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843809);
        break label243;
      }
      paramajxk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label243;
      label487:
      paramajxk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label243;
      label499:
      paramajxk.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842447);
      break label274;
      label512:
      if (paramTroopInfo.troopCreditLevel == 2L)
      {
        paramajxk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (bdgb.b()) {
          paramajxk.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842448);
        }
        for (;;)
        {
          paramajxk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramajxk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850445);
          break;
          paramajxk.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842447);
        }
      }
      if (paramTroopInfo.troopCreditLevel == 1L)
      {
        paramajxk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (bdgb.b()) {
          paramajxk.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842448);
        }
        for (;;)
        {
          paramajxk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramajxk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850443);
          break;
          paramajxk.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842447);
        }
      }
      paramajxk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 > 0) && (paramInt1 < this.jdField_b_of_type_ArrayOfInt.length) && (paramInt2 > this.jdField_b_of_type_ArrayOfInt[paramInt1]);
  }
  
  private void b(ajuk paramajuk)
  {
    a(paramajuk);
    a(paramajuk.jdField_a_of_type_Int);
    if ((paramajuk.jdField_a_of_type_Int >= 0) && (paramajuk.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfInt.length)) {
      if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label139;
      }
    }
    label139:
    for (int i = 0;; i = paramajuk.jdField_a_of_type_Int)
    {
      if ((this.jdField_a_of_type_ArrayOfInt[paramajuk.jdField_a_of_type_Int] == 1) && (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(i)))
      {
        i = a(paramajuk.jdField_a_of_type_Int);
        new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp_inactive").a(new String[] { "", String.valueOf(i) }).a();
      }
      return;
    }
  }
  
  private void b(TroopInfo paramTroopInfo)
  {
    blir localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
    boolean bool = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramTroopInfo.troopuin);
    if (bool) {}
    for (int i = 2131692805;; i = 2131692807)
    {
      localblir.b(i);
      localblir.c(2131690580);
      localblir.a(new ajxo(this, bool, paramTroopInfo, localblir));
      try
      {
        localblir.show();
        return;
      }
      catch (Exception paramTroopInfo) {}
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "only one group");
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(0);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(0));
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getString("700_sp_key_last_troop_expanded", "700_sp_key_last_troop_expanded");
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopAdapter", 2, "readExpand=" + (String)localObject);
    }
    HashSet localHashSet = new HashSet();
    label168:
    int i;
    label170:
    int j;
    if (((String)localObject).equalsIgnoreCase("700_sp_key_last_troop_expanded")) {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localHashSet.add(this.jdField_a_of_type_JavaUtilList.get(0));
        i = 0;
        if (i < this.jdField_a_of_type_JavaUtilList.size()) {
          if (localHashSet.contains(this.jdField_a_of_type_JavaUtilList.get(i)))
          {
            this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
            if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
              break label428;
            }
            j = 0;
          }
        }
      }
    }
    for (;;)
    {
      if ((i > 0) && (i < this.jdField_a_of_type_ArrayOfInt.length)) {
        a(i);
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
      if ((i < this.jdField_a_of_type_ArrayOfInt.length) && (this.jdField_a_of_type_ArrayOfInt[i] == 1) && (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(j)))
      {
        j = a(i);
        new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp_inactive").a(new String[] { "", String.valueOf(j) }).a();
      }
      i += 1;
      break label170;
      break;
      this.jdField_a_of_type_Boolean = true;
      break label168;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label168;
      }
      localObject = ((String)localObject).split("_");
      j = localObject.length;
      i = 0;
      label395:
      if (i >= j) {
        break label168;
      }
      String str = localObject[i];
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str)));
        label421:
        i += 1;
        break label395;
        label428:
        j = i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label421;
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      localStringBuffer = new StringBuffer();
      localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        localStringBuffer.append((Integer)localIterator.next());
        localStringBuffer.append("_");
      }
      if (localStringBuffer.length() > 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "saveExpanded=" + localStringBuffer.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putString("700_sp_key_last_troop_expanded", localStringBuffer.toString()).commit();
    }
    while (!QLog.isColorLevel())
    {
      StringBuffer localStringBuffer;
      Iterator localIterator;
      return;
    }
    QLog.d("ContactsTroopAdapter", 2, "less than 1 group : don't saveExpanded");
  }
  
  private void i()
  {
    ContactsTroopAdapter.LoadTroopDiscussInfoSubRunnable localLoadTroopDiscussInfoSubRunnable = new ContactsTroopAdapter.LoadTroopDiscussInfoSubRunnable(this, null);
    localLoadTroopDiscussInfoSubRunnable.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
    localLoadTroopDiscussInfoSubRunnable.jdField_a_of_type_Apaw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    ThreadManager.post(localLoadTroopDiscussInfoSubRunnable, 8, null, true);
  }
  
  private void j()
  {
    boolean bool = false;
    Object localObject = new amrk();
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
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      g();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetExpandableListView instanceof PinnedHeaderExpandableListView))
      {
        localObject = (PinnedHeaderExpandableListView)this.jdField_a_of_type_ComTencentWidgetExpandableListView;
        if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
          bool = true;
        }
        ((PinnedHeaderExpandableListView)localObject).setHeaderViewShouldShow(bool);
      }
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(0);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(0));
    }
    i = 0;
    label393:
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_a_of_type_JavaUtilList.get(i))) {
        break label442;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
    }
    for (;;)
    {
      i += 1;
      break label393;
      break;
      label442:
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(i);
    }
  }
  
  public void a()
  {
    h();
  }
  
  public void a(int paramInt, blpx[] paramArrayOfblpx, Object paramObject)
  {
    int i = 1;
    if ((paramArrayOfblpx == null) || (paramArrayOfblpx.length <= 0)) {}
    label97:
    for (;;)
    {
      return;
      if (paramArrayOfblpx.length < 0) {
        if ((paramObject instanceof TroopInfo))
        {
          paramObject = (TroopInfo)paramObject;
          if (this.jdField_b_of_type_JavaUtilList.contains(paramObject))
          {
            paramInt = 1;
            paramArrayOfblpx[0].jdField_b_of_type_Int = paramInt;
            paramArrayOfblpx[0].jdField_a_of_type_Int = 0;
            paramInt = i;
          }
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfblpx.length) {
          break label97;
        }
        paramArrayOfblpx[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfblpx[paramInt].jdField_a_of_type_Int = -1;
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
    if (!(paramView.getTag() instanceof ajuk))
    {
      localObject = new ajuk();
      ((ajuk)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369210));
      ((ajuk)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367726));
      ((ajuk)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      ((ajuk)localObject).b = ((SingleLineTextView)paramView.findViewById(2131380041));
      ((ajuk)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131364983));
      ((ajuk)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      ((ajuk)localObject).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369324));
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
      paramView = (ajuk)paramView.getTag();
      break;
      label180:
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167074);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor((ColorStateList)localObject);
    }
  }
  
  public void a(View paramView, int paramInt, ajsp paramajsp, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    if (this.jdField_a_of_type_Blpy != null) {}
    for (int i = this.jdField_a_of_type_Blpy.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, paramObject, paramajsp, paramOnClickListener);; i = 0)
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
  
  public void a(TroopInfo paramTroopInfo, apaw paramapaw)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramTroopInfo.troopuin) == 2)
    {
      paramTroopInfo.lastMsgTime = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramTroopInfo.troopuin, 1).time;
      return;
    }
    paramTroopInfo.lastMsgTime = ((RecentUser)paramapaw.findRecentUserByUin(paramTroopInfo.troopuin, 1)).lastmsgtime;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(View paramView)
  {
    return true;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return true;
  }
  
  public boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof ajuk)) {
      a((ajuk)paramExpandableListView);
    }
    return true;
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new ContactsTroopAdapter.5(this));
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.c(paramBoolean);
      return;
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
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
  
  public int c_()
  {
    return 2131558948;
  }
  
  public void d() {}
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    notifyDataSetChanged();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() <= 1) {
      return;
    }
    int i = 0;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(i);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
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
      if ((paramView == null) || (!(paramView.getTag() instanceof ajxk)))
      {
        localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563034, null);
        ((View)localObject).setMinimumHeight(this.jdField_b_of_type_Int);
        paramViewGroup = new ajxk();
        paramView = this.jdField_a_of_type_Blpy.a(this.jdField_a_of_type_AndroidContentContext, (View)localObject, paramViewGroup, -1);
        paramViewGroup.g = ((View)localObject);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378604));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378606));
        paramViewGroup.d = ((ImageView)paramView.findViewById(2131368212));
        if ((paramViewGroup.d instanceof ThemeImageView)) {
          ((ThemeImageView)paramViewGroup.d).setSupportMaskView(false);
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370633));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377963));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371492));
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379360));
        localObject = paramView.getResources().getColorStateList(2131166997);
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
        paramViewGroup = (ajxk)paramView.getTag();
      }
      if ((localObject != null) && ((localObject instanceof DiscussionInfo)))
      {
        a((DiscussionInfo)localObject, paramViewGroup, paramInt1, paramInt2, paramView);
        return paramView;
      }
      paramViewGroup = paramView;
    } while (!QLog.isColorLevel());
    QLog.d("ContactsTroopAdapter", 2, "getChildView data:" + localObject + " groupPosition:" + paramInt1 + " childPosition:" + paramInt2);
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
      QLog.d("ContactsTroopAdapter", 2, "getChildrenCount count:" + j + "  groupPosition:" + paramInt);
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
      QLog.d("ContactsTroopAdapter", 2, "getChildrenCount mGroups.size():" + this.jdField_a_of_type_JavaUtilList.size());
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558948, paramViewGroup, false);
      paramViewGroup = new ajuk();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367726));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369210));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131364983));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369324));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131380041));
      paramView.setTag(paramViewGroup);
    }
    while (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
      paramViewGroup = (ajuk)paramView.getTag();
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
      ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167074);
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
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b == null)
    {
      ThreadManager.postImmediately(new ContactsTroopAdapter.4(this), null, false);
      return;
    }
    i();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof ajuk)) {
      b((ajuk)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof ajxk)) {
        a((ajxk)localObject);
      } else if ((localObject instanceof TroopInfo)) {
        a((TroopInfo)localObject);
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    HeaderScrollView localHeaderScrollView = null;
    while ((localViewParent != null) && (localHeaderScrollView == null)) {
      if ((localViewParent instanceof HeaderScrollView)) {
        localHeaderScrollView = (HeaderScrollView)localViewParent;
      } else if ((localViewParent instanceof View)) {
        localViewParent = ((View)localViewParent).getParent();
      } else {
        localViewParent = null;
      }
    }
    if ((localHeaderScrollView != null) && (localHeaderScrollView.jdField_a_of_type_Boolean)) {
      return false;
    }
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof ajsp)))
    {
      paramView = ((ajsp)paramView).jdField_a_of_type_JavaLangObject;
      if (paramView != null) {
        if ((paramView instanceof TroopInfo)) {
          b((TroopInfo)paramView);
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (!(paramView instanceof DiscussionInfo)) {
        break;
      }
      a((DiscussionInfo)paramView);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter
 * JD-Core Version:    0.7.0.1
 */