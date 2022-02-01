package com.tencent.mobileqq.activity.contacts.troop;

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
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.adapter.SwipFacePreloadExpandableAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.adapter.contact.GroupTag;
import com.tencent.mobileqq.troop.adapter.contact.TroopCompator;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItemWithMask;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;
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
  extends SwipFacePreloadExpandableAdapter
  implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemLongClickListener, ExpandableListView.OnGroupClickListener, SwipPinnedHeaderExpandableListView.SwipListListener
{
  public int a;
  protected Context a;
  protected DiscussionManager a;
  protected QQAppInterface a;
  TroopAvatarObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver = new ContactsTroopAdapter.8(this);
  protected SwipTextViewMenuBuilder a;
  protected HashSet<Integer> a;
  protected List<Integer> a;
  private boolean jdField_a_of_type_Boolean = true;
  protected int[] a;
  private int b;
  protected List<Entity> b;
  protected int[] b;
  private int c;
  protected List<TroopListItemWithMask> c;
  protected int[] c;
  protected List<TroopListItemWithMask> d = new ArrayList();
  protected List<TroopListItemWithMask> e = new ArrayList();
  protected List<TroopListItemWithMask> f = new ArrayList();
  protected List<TroopListItemWithMask> g = new ArrayList();
  
  public ContactsTroopAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(4);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(5);
    this.jdField_a_of_type_Int = -2;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfInt = new int[6];
    this.jdField_b_of_type_ArrayOfInt = new int[6];
    this.jdField_c_of_type_ArrayOfInt = new int[6];
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = AIOUtils.b(56.0F, paramContext.getResources());
    this.jdField_c_of_type_Int = AIOUtils.b(44.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder = new ContactsTroopAdapter.1(this, 1, 1, new int[] { paramContext.getResources().getDimensionPixelSize(2131296809) }, -1, new int[] { 2131370814, 2131370814 }, new int[] { 2131693069, 2131693067 }, new int[] { 2130839508, 2130839508 });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.setOnItemLongClickListener(this);
  }
  
  private int a(int paramInt)
  {
    int j = 0;
    int i = j;
    if (paramInt >= 0)
    {
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        return 0;
      }
      paramInt = ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
      i = j;
      if (paramInt != 0)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4)
          {
            if (paramInt != 6)
            {
              if (paramInt != 8)
              {
                if (paramInt != 10) {
                  return 0;
                }
                return 4;
              }
              return 5;
            }
            return 2;
          }
          return 1;
        }
        i = 3;
      }
    }
    return i;
  }
  
  private View a(int paramInt)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562965, null);
    Object localObject1 = (TextView)localView.findViewById(2131367151);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131702715));
    ((StringBuilder)localObject2).append(this.jdField_c_of_type_ArrayOfInt[paramInt]);
    ((StringBuilder)localObject2).append(")");
    localObject2 = ((StringBuilder)localObject2).toString();
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localView.setOnClickListener(new ContactsTroopAdapter.2(this, paramInt));
    localView.setOnTouchListener(new ContactsTroopAdapter.3(this, (TextView)localObject1));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131702688));
    localView.setContentDescription(((StringBuilder)localObject1).toString());
    return localView;
  }
  
  private Entity a(int paramInt1, int paramInt2)
  {
    paramInt1 = ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).intValue();
    if (paramInt1 != 0)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 4)
        {
          if (paramInt1 != 6)
          {
            if (paramInt1 != 8)
            {
              if (paramInt1 != 10) {
                return null;
              }
              return ((TroopListItemWithMask)this.g.get(paramInt2)).a;
            }
            return ((TroopListItemWithMask)this.f.get(paramInt2)).a;
          }
          return ((TroopListItemWithMask)this.d.get(paramInt2)).a;
        }
        return ((TroopListItemWithMask)this.jdField_c_of_type_JavaUtilList.get(paramInt2)).a;
      }
      return ((TroopListItemWithMask)this.e.get(paramInt2)).a;
    }
    return (Entity)this.jdField_b_of_type_JavaUtilList.get(paramInt2);
  }
  
  private void a(int paramInt)
  {
    int j = 0;
    int k = 10;
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        i = ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
        if (i != 0)
        {
          if (i != 2)
          {
            if (i != 4)
            {
              if (i != 6)
              {
                if (i != 8)
                {
                  if (i != 10)
                  {
                    i = j;
                  }
                  else
                  {
                    i = this.g.size();
                    j = a(this.g);
                    break label210;
                  }
                }
                else
                {
                  i = this.f.size();
                  j = a(this.f);
                  break label210;
                }
              }
              else
              {
                i = this.d.size();
                j = a(this.d);
                break label210;
              }
            }
            else
            {
              i = this.jdField_c_of_type_JavaUtilList.size();
              j = a(this.jdField_c_of_type_JavaUtilList);
              break label210;
            }
          }
          else
          {
            i = this.e.size();
            j = a(this.e);
            break label210;
          }
        }
        else
        {
          i = this.jdField_b_of_type_JavaUtilList.size();
          this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
        }
      }
    }
    j = 0;
    label210:
    if (i <= 10)
    {
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
    }
    else
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if (arrayOfInt[paramInt] == 0) {
        arrayOfInt[paramInt] = 1;
      }
    }
    if (i <= 10) {
      j = i;
    } else if (j < 10) {
      j = k;
    }
    this.jdField_b_of_type_ArrayOfInt[paramInt] = j;
    this.jdField_c_of_type_ArrayOfInt[paramInt] = (i - j);
  }
  
  private void a(BuddyListTroop.TroopDisChildTag paramTroopDisChildTag)
  {
    if ((paramTroopDisChildTag.jdField_a_of_type_JavaLangObject instanceof DiscussionInfo))
    {
      a(paramTroopDisChildTag, (DiscussionInfo)paramTroopDisChildTag.jdField_a_of_type_JavaLangObject);
      return;
    }
    TroopInfo localTroopInfo = (TroopInfo)paramTroopDisChildTag.jdField_a_of_type_JavaLangObject;
    a(paramTroopDisChildTag, localTroopInfo);
    ThreadPriorityManager.a(true);
    paramTroopDisChildTag = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
    paramTroopDisChildTag.putExtra("uin", localTroopInfo.troopuin);
    if (localTroopInfo.troopcode != null) {
      paramTroopDisChildTag.putExtra("troop_uin", localTroopInfo.troopcode);
    }
    paramTroopDisChildTag.putExtra("uintype", 1);
    paramTroopDisChildTag.putExtra("uinname", localTroopInfo.getTroopDisplayName());
    paramTroopDisChildTag.putExtra("open_chatfragment_withanim", true);
    paramTroopDisChildTag.putExtra("isFromContactTab", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramTroopDisChildTag);
  }
  
  private void a(BuddyListTroop.TroopDisChildTag paramTroopDisChildTag, DiscussionInfo paramDiscussionInfo)
  {
    ThreadPriorityManager.a(true);
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
    localIntent.putExtra("uin", paramDiscussionInfo.uin);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramDiscussionInfo.discussionName);
    localIntent.putExtra("open_chatfragment_withanim", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    int i = ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramTroopDisChildTag.jdField_a_of_type_Int)).intValue();
    if (i != 0)
    {
      if (i == 2) {
        break label158;
      }
      if (i == 4) {
        break label153;
      }
      if (i == 6) {
        break label148;
      }
      if (i == 8) {
        break label143;
      }
      if (i == 10) {}
    }
    else
    {
      i = 0;
      break label160;
    }
    i = 4;
    break label160;
    label143:
    i = 5;
    break label160;
    label148:
    i = 2;
    break label160;
    label153:
    i = 1;
    break label160;
    label158:
    i = 3;
    label160:
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_grp").a(new String[] { paramDiscussionInfo.uin, String.valueOf(i) }).a();
  }
  
  private void a(BuddyListTroop.TroopDisChildTag paramTroopDisChildTag, TroopInfo paramTroopInfo)
  {
    int i = ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramTroopDisChildTag.jdField_a_of_type_Int)).intValue();
    int j = 3;
    if (i != 0)
    {
      if (i == 2) {
        break label80;
      }
      if (i == 4) {
        break label75;
      }
      if (i == 6) {
        break label70;
      }
      if (i == 8) {
        break label65;
      }
      if (i == 10) {}
    }
    else
    {
      i = 0;
      break label82;
    }
    i = 4;
    break label82;
    label65:
    i = 5;
    break label82;
    label70:
    i = 2;
    break label82;
    label75:
    i = 1;
    break label82;
    label80:
    i = 3;
    label82:
    int k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramTroopInfo.troopuin);
    if (k != 1)
    {
      if (k == 2) {
        break label131;
      }
      if (k == 3) {
        break label134;
      }
      if (k == 4) {}
    }
    else
    {
      j = 0;
      break label134;
    }
    j = 1;
    break label134;
    label131:
    j = 2;
    label134:
    if (paramTroopDisChildTag.jdField_a_of_type_Boolean) {
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_inactiveGrp").a(new String[] { paramTroopInfo.troopuin, String.valueOf(i) }).a();
    }
    paramTroopDisChildTag = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramTroopInfo.troopuin);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append("");
    ReportController.b(paramTroopDisChildTag, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, (String)localObject, String.valueOf(i), localStringBuilder.toString(), "");
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_grp").a(new String[] { paramTroopInfo.troopuin, String.valueOf(i) }).a();
    if (i == 5) {
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_unnamedGrp").a(new String[] { paramTroopInfo.troopuin }).a();
    }
  }
  
  private void a(DiscussionInfo paramDiscussionInfo)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    DiscussionHandler localDiscussionHandler = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
    boolean bool = localDiscussionHandler.a(paramDiscussionInfo);
    int i;
    if (bool) {
      i = 2131693067;
    } else {
      i = 2131693069;
    }
    localActionSheet.addButton(i);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new ContactsTroopAdapter.7(this, localDiscussionHandler, paramDiscussionInfo, bool, localActionSheet));
    try
    {
      localActionSheet.show();
      return;
    }
    catch (Exception paramDiscussionInfo) {}
  }
  
  private void a(DiscussionInfo paramDiscussionInfo, BuddyListTroop.TroopDisChildTag paramTroopDisChildTag, int paramInt1, int paramInt2, View paramView)
  {
    paramTroopDisChildTag.jdField_a_of_type_JavaLangString = paramDiscussionInfo.uin;
    paramTroopDisChildTag.jdField_a_of_type_JavaLangObject = paramDiscussionInfo;
    paramTroopDisChildTag.jdField_b_of_type_Int = 101;
    paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetTextView.setText(paramDiscussionInfo.discussionName);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(paramDiscussionInfo.uin);
    if ((!paramDiscussionInfo.hasRenamed()) && (i > 0))
    {
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(i) }));
    }
    else
    {
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DiscussionInfo hasRenamed:");
      localStringBuilder.append(paramDiscussionInfo.hasRenamed());
      localStringBuilder.append(" | memberNum:");
      localStringBuilder.append(i);
      localStringBuilder.append(" | uin:");
      localStringBuilder.append(paramDiscussionInfo.uin);
      localStringBuilder.append("  discussionName:");
      localStringBuilder.append(paramDiscussionInfo.discussionName);
      QLog.d("ContactsTroopAdapter", 2, localStringBuilder.toString());
    }
    long l = paramDiscussionInfo.lastMsgTime;
    if (AppSetting.d) {
      paramTroopDisChildTag.leftView.setContentDescription(paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetTextView.getText());
    }
    a(paramTroopDisChildTag, null);
    paramView.setOnClickListener(this);
    paramView.setOnLongClickListener(this);
    a(paramView, paramInt1 << 16 | paramInt2, paramTroopDisChildTag, this, paramDiscussionInfo);
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(TroopInfo paramTroopInfo, BuddyListTroop.TroopDisChildTag paramTroopDisChildTag, int paramInt1, int paramInt2, View paramView)
  {
    paramTroopDisChildTag.jdField_a_of_type_JavaLangString = paramTroopInfo.troopuin;
    paramTroopDisChildTag.jdField_a_of_type_JavaLangObject = paramTroopInfo;
    paramTroopDisChildTag.jdField_b_of_type_Int = 4;
    paramTroopDisChildTag.jdField_a_of_type_Boolean = a(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramTroopInfo.troopuin);
    if (i == 3)
    {
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850813);
    }
    else if (i == 1)
    {
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    else
    {
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839484);
    }
    TextView localTextView = paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetTextView;
    Object localObject;
    if (!TextUtils.isEmpty(paramTroopInfo.getTroopDisplayName())) {
      localObject = paramTroopInfo.getTroopDisplayName();
    } else {
      localObject = paramTroopInfo.troopuin;
    }
    localTextView.setText((CharSequence)localObject);
    if ((!paramTroopInfo.hasSetTroopName()) && (paramTroopInfo.wMemberNumClient > 0))
    {
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(paramTroopInfo.wMemberNumClient) }));
    }
    else
    {
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TroopInfo hasSetTroopName:");
      ((StringBuilder)localObject).append(paramTroopInfo.hasSetTroopName());
      ((StringBuilder)localObject).append(" | memberNum:");
      ((StringBuilder)localObject).append(paramTroopInfo.wMemberNumClient);
      QLog.d("ContactsTroopAdapter", 2, ((StringBuilder)localObject).toString());
    }
    long l = paramTroopInfo.lastMsgTime;
    if ((paramTroopInfo.dwGroupFlagExt & 0x800) != 0L)
    {
      if (paramTroopInfo.dwAuthGroupType == 2L)
      {
        paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843985);
      }
      else if (paramTroopInfo.dwAuthGroupType == 1L)
      {
        paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130843985);
      }
      else
      {
        paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else {
      paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (paramTroopInfo.isTroopBlocked)
    {
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (SimpleUIUtil.a()) {
        paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842569);
      } else {
        paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842568);
      }
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130851091);
      localObject = (FrameLayout.LayoutParams)paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localObject != null)
      {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = (-ViewUtils.b(2.0F));
        ((FrameLayout.LayoutParams)localObject).rightMargin = (-ViewUtils.b(3.0F));
      }
    }
    else if (paramTroopInfo.troopCreditLevel == 2L)
    {
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (SimpleUIUtil.a()) {
        paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842569);
      } else {
        paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842568);
      }
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850816);
    }
    else if (paramTroopInfo.troopCreditLevel == 1L)
    {
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (SimpleUIUtil.a()) {
        paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842569);
      } else {
        paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842568);
      }
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850814);
    }
    else
    {
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    if (AppSetting.d) {
      paramTroopDisChildTag.leftView.setContentDescription(paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetTextView.getText());
    }
    a(paramTroopDisChildTag, null);
    paramView.setOnClickListener(this);
    paramView.setOnLongClickListener(this);
    a(paramView, paramInt1 << 16 | paramInt2, paramTroopDisChildTag, this, paramTroopInfo);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      int[] arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
      if ((paramInt1 < arrayOfInt.length) && (paramInt2 > arrayOfInt[paramInt1])) {
        return true;
      }
    }
    return false;
  }
  
  private void b(TroopInfo paramTroopInfo)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    boolean bool = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramTroopInfo.troopuin);
    int i;
    if (bool) {
      i = 2131693067;
    } else {
      i = 2131693069;
    }
    localActionSheet.addButton(i);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new ContactsTroopAdapter.6(this, bool, paramTroopInfo, localActionSheet));
    try
    {
      localActionSheet.show();
      return;
    }
    catch (Exception paramTroopInfo) {}
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      Object localObject = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuffer.append((Integer)((Iterator)localObject).next());
        localStringBuffer.append("_");
      }
      if (localStringBuffer.length() > 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveExpanded=");
        ((StringBuilder)localObject).append(localStringBuffer.toString());
        QLog.d("ContactsTroopAdapter", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putString("700_sp_key_last_troop_expanded", localStringBuffer.toString()).commit();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopAdapter", 2, "less than 1 group : don't saveExpanded");
    }
  }
  
  private void i()
  {
    ContactsTroopAdapter.LoadTroopDiscussInfoSubRunnable localLoadTroopDiscussInfoSubRunnable = new ContactsTroopAdapter.LoadTroopDiscussInfoSubRunnable(this, null);
    localLoadTroopDiscussInfoSubRunnable.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    localLoadTroopDiscussInfoSubRunnable.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    ThreadManager.post(localLoadTroopDiscussInfoSubRunnable, 8, null, true);
  }
  
  protected int a(List<TroopListItemWithMask> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      TroopListItemWithMask localTroopListItemWithMask = (TroopListItemWithMask)paramList.next();
      if ((localTroopListItemWithMask.a != null) && ((localTroopListItemWithMask.a instanceof TroopInfo)) && (((TroopInfo)localTroopListItemWithMask.a).lastMsgTime > 0L)) {
        i += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("getActiveTroopCount activeTroopCount:");
      paramList.append(i);
      QLog.d("ContactsTroopAdapter", 2, paramList.toString());
    }
    return i;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "only one group");
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(0);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(0));
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getString("700_sp_key_last_troop_expanded", "700_sp_key_last_troop_expanded");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("readExpand=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("ContactsTroopAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new HashSet();
    int j;
    int i;
    if (((String)localObject2).equalsIgnoreCase("700_sp_key_last_troop_expanded"))
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        ((Set)localObject1).add(this.jdField_a_of_type_JavaUtilList.get(0));
      } else {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = ((String)localObject2).split("_");
      j = localObject2.length;
      i = 0;
    }
    for (;;)
    {
      String str;
      if (i < j) {
        str = localObject2[i];
      }
      try
      {
        ((Set)localObject1).add(Integer.valueOf(Integer.parseInt(str)));
        label237:
        i += 1;
        continue;
        i = 0;
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((Set)localObject1).contains(this.jdField_a_of_type_JavaUtilList.get(i)))
          {
            this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
            if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
              j = 0;
            } else {
              j = i;
            }
            if ((i > 0) && (i < this.jdField_a_of_type_ArrayOfInt.length)) {
              a(i);
            }
            this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
            localObject2 = this.jdField_a_of_type_ArrayOfInt;
            if ((i < localObject2.length) && (localObject2[i] == 1) && (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(j)))
            {
              j = a(i);
              new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp_inactive").a(new String[] { "", String.valueOf(j) }).a();
            }
          }
          i += 1;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label237;
      }
    }
  }
  
  protected void a(int paramInt, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem, Object paramObject)
  {
    if (paramArrayOfSwipRightMenuItem != null)
    {
      if (paramArrayOfSwipRightMenuItem.length <= 0) {
        return;
      }
      paramInt = paramArrayOfSwipRightMenuItem.length;
      int i = 1;
      if (paramInt > 0)
      {
        if ((paramObject instanceof TroopInfo))
        {
          paramObject = (TroopInfo)paramObject;
          if (this.jdField_b_of_type_JavaUtilList.contains(paramObject))
          {
            paramInt = 1;
            break label52;
          }
        }
        paramInt = 0;
        label52:
        paramArrayOfSwipRightMenuItem[0].menuId = paramInt;
        paramArrayOfSwipRightMenuItem[0].menuType = 0;
        paramInt = i;
      }
      else
      {
        paramInt = 0;
      }
      while (paramInt < paramArrayOfSwipRightMenuItem.length)
      {
        paramArrayOfSwipRightMenuItem[paramInt].menuId = -1;
        paramArrayOfSwipRightMenuItem[paramInt].menuType = -1;
        paramInt += 1;
      }
    }
  }
  
  public void a(View paramView, int paramInt, BuddyListItem.ViewTag paramViewTag, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    SwipTextViewMenuBuilder localSwipTextViewMenuBuilder = this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder;
    int i;
    if (localSwipTextViewMenuBuilder != null) {
      i = localSwipTextViewMenuBuilder.updateRightMenuView(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, paramObject, paramViewTag, paramOnClickListener);
    } else {
      i = 0;
    }
    int j = this.jdField_a_of_type_Int;
    if (j != -1)
    {
      if (paramInt != j)
      {
        paramView.scrollTo(0, 0);
        return;
      }
      paramView.scrollTo(i, 0);
    }
  }
  
  public void a(TroopInfo paramTroopInfo, RecentUserProxy paramRecentUserProxy)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramTroopInfo.troopuin) == 2)
    {
      paramTroopInfo.lastMsgTime = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramTroopInfo.troopuin, 1).time;
      return;
    }
    paramTroopInfo.lastMsgTime = paramRecentUserProxy.a(paramTroopInfo.troopuin, 1).lastmsgtime;
  }
  
  protected void a(GroupTag paramGroupTag)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    int k = 0;
    if (i == 1) {
      i = 0;
    } else {
      i = paramGroupTag.jdField_a_of_type_Int;
    }
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(i);
      this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(i));
      i = k;
    }
    else
    {
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(j))
        {
          this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(j);
          this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(j));
        }
        j += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
      i = k;
    }
    for (;;)
    {
      paramGroupTag = this.jdField_a_of_type_ArrayOfInt;
      if (i >= paramGroupTag.length) {
        break;
      }
      if (paramGroupTag[i] == 2) {
        paramGroupTag[i] = 1;
      }
      i += 1;
    }
  }
  
  protected void a(GroupTag paramGroupTag, int paramInt, boolean paramBoolean)
  {
    if (paramGroupTag != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
      {
        i = ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
        if (i != 0)
        {
          if (i != 2)
          {
            if (i != 4)
            {
              if (i != 6)
              {
                if (i != 8)
                {
                  if (i == 10)
                  {
                    str = HardCodeUtil.a(2131702744);
                    i = this.g.size();
                    j = a(this.g);
                    break label280;
                  }
                }
                else
                {
                  str = HardCodeUtil.a(2131715602);
                  i = this.f.size();
                  j = a(this.f);
                  break label280;
                }
              }
              else
              {
                str = HardCodeUtil.a(2131715604);
                i = this.d.size();
                j = a(this.d);
                break label280;
              }
            }
            else
            {
              str = HardCodeUtil.a(2131715601);
              i = this.jdField_c_of_type_JavaUtilList.size();
              j = a(this.jdField_c_of_type_JavaUtilList);
              break label280;
            }
          }
          else
          {
            str = HardCodeUtil.a(2131715597);
            i = this.e.size();
            j = a(this.e);
            break label280;
          }
        }
        else
        {
          str = HardCodeUtil.a(2131702728);
          i = this.jdField_b_of_type_JavaUtilList.size();
          this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
          break label277;
        }
      }
      String str = "";
      int i = 0;
      label277:
      int j = 0;
      label280:
      int k;
      if (i <= 10)
      {
        k = i;
      }
      else
      {
        k = j;
        if (j < 10) {
          k = 10;
        }
      }
      if (i <= 10)
      {
        this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ArrayOfInt;
        if (localObject1[paramInt] == 0)
        {
          localObject1[paramInt] = 1;
          notifyDataSetChanged();
        }
      }
      this.jdField_b_of_type_ArrayOfInt[paramInt] = k;
      this.jdField_c_of_type_ArrayOfInt[paramInt] = (i - k);
      Object localObject2;
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append(i);
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(i);
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      StringBuilder localStringBuilder = paramGroupTag.jdField_a_of_type_JavaLangStringBuilder;
      Object localObject1 = localStringBuilder;
      if (AppSetting.d)
      {
        if (localStringBuilder == null)
        {
          localObject1 = new StringBuilder(24);
        }
        else
        {
          localStringBuilder.delete(0, localStringBuilder.length());
          localObject1 = localStringBuilder;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" 分组");
        ((StringBuilder)localObject1).append(localStringBuilder.toString());
      }
      paramGroupTag.jdField_a_of_type_Int = paramInt;
      paramGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str);
      paramGroupTag.b.setVisibility(8);
      paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText((CharSequence)localObject2);
      if (AppSetting.d)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("共");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("个");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      }
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      if (AppSetting.d)
      {
        if (paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          ((StringBuilder)localObject1).append(" 已展开");
        } else {
          ((StringBuilder)localObject1).append(" 已折叠");
        }
        paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setContentDescription(((StringBuilder)localObject1).toString());
        AccessibilityUtil.a(paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox, false);
      }
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver);
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
  
  protected void b(GroupTag paramGroupTag)
  {
    a(paramGroupTag);
    a(paramGroupTag.jdField_a_of_type_Int);
    if ((paramGroupTag.jdField_a_of_type_Int >= 0) && (paramGroupTag.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfInt.length))
    {
      int i;
      if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
        i = 0;
      } else {
        i = paramGroupTag.jdField_a_of_type_Int;
      }
      if ((this.jdField_a_of_type_ArrayOfInt[paramGroupTag.jdField_a_of_type_Int] == 1) && (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i)))
      {
        i = a(paramGroupTag.jdField_a_of_type_Int);
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp_inactive").a(new String[] { "", String.valueOf(i) }).a();
      }
    }
  }
  
  public void c()
  {
    h();
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      return;
    }
    Object localObject;
    if (!(paramView.getTag() instanceof GroupTag))
    {
      localObject = new GroupTag();
      ((GroupTag)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369353));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367855));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      ((GroupTag)localObject).b = ((SingleLineTextView)paramView.findViewById(2131379843));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131365107));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      ((GroupTag)localObject).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369450));
      paramView.setTag(localObject);
      paramView = (View)localObject;
    }
    else
    {
      paramView = (GroupTag)paramView.getTag();
    }
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false))
    {
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167142);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor((ColorStateList)localObject);
    }
    a(paramView, paramInt, this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
  }
  
  public void d()
  {
    ThreadManager.getUIHandler().post(new ContactsTroopAdapter.5(this));
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    notifyDataSetChanged();
  }
  
  protected void f()
  {
    Object localObject = new TroopCompator();
    Collections.sort(this.jdField_c_of_type_JavaUtilList, (Comparator)localObject);
    Collections.sort(this.d, (Comparator)localObject);
    Collections.sort(this.e, (Comparator)localObject);
    Collections.sort(this.f, (Comparator)localObject);
    Collections.sort(this.g, (Comparator)localObject);
    boolean bool2 = this.jdField_b_of_type_JavaUtilList.isEmpty();
    boolean bool1 = true;
    if ((bool2 ^ true)) {
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
    this.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject);
    b(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      a();
    }
    else if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(0);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(0));
    }
    else
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (this.jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_a_of_type_JavaUtilList.get(i))) {
          this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
        } else {
          this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(i);
        }
        i += 1;
      }
    }
    if ((this.jdField_a_of_type_ComTencentWidgetExpandableListView instanceof PinnedHeaderExpandableListView))
    {
      localObject = (PinnedHeaderExpandableListView)this.jdField_a_of_type_ComTencentWidgetExpandableListView;
      if (this.jdField_a_of_type_JavaUtilList.size() <= 1) {
        bool1 = false;
      }
      ((PinnedHeaderExpandableListView)localObject).setHeaderViewShouldShow(bool1);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() <= 1) {
      return;
    }
    int i = 0;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(i);
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
      return a(paramInt1);
    }
    if ((paramView != null) && ((paramView.getTag() instanceof BuddyListTroop.TroopDisChildTag)))
    {
      paramViewGroup = (BuddyListTroop.TroopDisChildTag)paramView.getTag();
    }
    else
    {
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562966, null);
      ((View)localObject).setMinimumHeight(this.jdField_b_of_type_Int);
      paramViewGroup = new BuddyListTroop.TroopDisChildTag();
      paramView = this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder.createView(this.jdField_a_of_type_AndroidContentContext, (View)localObject, paramViewGroup, -1);
      paramViewGroup.leftView = ((View)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378461));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378463));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131368343));
      if ((paramViewGroup.d instanceof ThemeImageView)) {
        ((ThemeImageView)paramViewGroup.d).setSupportMaskView(false);
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370699));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377847));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371567));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379177));
      localObject = paramView.getResources().getColorStateList(2131167063);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
      paramView.setTag(paramViewGroup);
    }
    paramViewGroup.jdField_a_of_type_Int = paramInt1;
    Object localObject = a(paramInt1, paramInt2);
    if ((localObject != null) && ((localObject instanceof TroopInfo)))
    {
      a((TroopInfo)localObject, paramViewGroup, paramInt1, paramInt2, paramView);
      return paramView;
    }
    if ((localObject != null) && ((localObject instanceof DiscussionInfo)))
    {
      a((DiscussionInfo)localObject, paramViewGroup, paramInt1, paramInt2, paramView);
      return paramView;
    }
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("getChildView data:");
      paramViewGroup.append(localObject);
      paramViewGroup.append(" groupPosition:");
      paramViewGroup.append(paramInt1);
      paramViewGroup.append(" childPosition:");
      paramViewGroup.append(paramInt2);
      QLog.d("ContactsTroopAdapter", 2, paramViewGroup.toString());
    }
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i = 0;
    int j = 0;
    if (paramInt >= 0)
    {
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        return 0;
      }
      i = ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
      if (i != 0)
      {
        if (i != 2)
        {
          if (i != 4)
          {
            if (i != 6)
            {
              if (i != 8)
              {
                if (i != 10) {
                  i = j;
                } else {
                  i = this.g.size();
                }
              }
              else {
                i = this.f.size();
              }
            }
            else {
              i = this.d.size();
            }
          }
          else {
            i = this.jdField_c_of_type_JavaUtilList.size();
          }
        }
        else {
          i = this.e.size();
        }
      }
      else
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      }
      j = i;
      Object localObject;
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] == 1)
      {
        localObject = this.jdField_b_of_type_ArrayOfInt;
        j = i;
        if (localObject[paramInt] < i) {
          j = localObject[paramInt] + 1;
        }
      }
      i = j;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getChildrenCount count:");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("  groupPosition:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("ContactsTroopAdapter", 2, ((StringBuilder)localObject).toString());
        i = j;
      }
    }
    return i;
  }
  
  public Object getGroup(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public int getGroupCount()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getChildrenCount mGroups.size():");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("ContactsTroopAdapter", 2, localStringBuilder.toString());
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558918, paramViewGroup, false);
      paramViewGroup = new GroupTag();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367855));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369353));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131365107));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369450));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131379843));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (GroupTag)paramView.getTag();
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
    }
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_c_of_type_Int));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false))
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    else
    {
      ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167142);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(localColorStateList);
    }
    a(paramViewGroup, paramInt, paramBoolean);
    paramView.setOnClickListener(this);
    return paramView;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131558918;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean)
  {
    FrameHelperActivity.b(paramBoolean ^ true);
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean needHideBackgroundGroup()
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    if (((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getCommonlyUsedTroopCache() == null)
    {
      ThreadManager.postImmediately(new ContactsTroopAdapter.4(this), null, false);
      return;
    }
    i();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof GroupTag)) {
      b((GroupTag)localObject);
    } else if ((localObject instanceof BuddyListTroop.TroopDisChildTag)) {
      a((BuddyListTroop.TroopDisChildTag)localObject);
    } else if ((localObject instanceof TroopInfo)) {
      a((TroopInfo)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onGroupClick(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof GroupTag)) {
      a((GroupTag)paramExpandableListView);
    }
    return true;
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return true;
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
    boolean bool2 = false;
    if ((localHeaderScrollView != null) && (localHeaderScrollView.jdField_a_of_type_Boolean)) {
      return false;
    }
    paramView = paramView.getTag();
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if ((paramView instanceof BuddyListItem.ViewTag))
      {
        paramView = ((BuddyListItem.ViewTag)paramView).jdField_a_of_type_JavaLangObject;
        bool1 = bool2;
        if (paramView != null)
        {
          if ((paramView instanceof TroopInfo)) {
            b((TroopInfo)paramView);
          } else if ((paramView instanceof DiscussionInfo)) {
            a((DiscussionInfo)paramView);
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean supportSwip(View paramView)
  {
    return true;
  }
  
  public void updateCurShowRightView(View paramView)
  {
    int j = -1;
    int i = j;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i = j;
      if ((paramView instanceof Integer)) {
        i = ((Integer)paramView).intValue();
      }
    }
    this.jdField_a_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter
 * JD-Core Version:    0.7.0.1
 */