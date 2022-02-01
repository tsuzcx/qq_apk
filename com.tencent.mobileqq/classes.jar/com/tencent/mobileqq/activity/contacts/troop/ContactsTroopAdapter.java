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
  protected QQAppInterface a;
  protected Context b;
  protected List<Integer> c = new ArrayList(4);
  protected List<Entity> d = new ArrayList();
  protected List<TroopListItemWithMask> e = new ArrayList();
  protected List<TroopListItemWithMask> f = new ArrayList();
  protected List<TroopListItemWithMask> g = new ArrayList();
  protected List<TroopListItemWithMask> h = new ArrayList();
  protected List<TroopListItemWithMask> i = new ArrayList();
  protected HashSet<Integer> j = new HashSet(5);
  protected SwipTextViewMenuBuilder k;
  public int l = -2;
  protected DiscussionManager m;
  protected int[] n = new int[6];
  protected int[] o = new int[6];
  protected int[] p = new int[6];
  TroopAvatarObserver q = new ContactsTroopAdapter.8(this);
  private int s = 0;
  private int t = 0;
  private boolean u = true;
  
  public ContactsTroopAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.a = paramQQAppInterface;
    this.b = paramContext;
    this.s = AIOUtils.b(56.0F, paramContext.getResources());
    this.t = AIOUtils.b(44.0F, paramContext.getResources());
    this.k = new ContactsTroopAdapter.1(this, 1, 1, new int[] { paramContext.getResources().getDimensionPixelSize(2131297140) }, -1, new int[] { 2131438137, 2131438137 }, new int[] { 2131890183, 2131890181 }, new int[] { 2130839699, 2130839699 });
    this.a.addObserver(this.q);
    this.m = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    this.r.setOnItemLongClickListener(this);
  }
  
  private View a(int paramInt)
  {
    View localView = LayoutInflater.from(this.b).inflate(2131629573, null);
    Object localObject1 = (TextView)localView.findViewById(2131433605);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131900705));
    ((StringBuilder)localObject2).append(this.p[paramInt]);
    ((StringBuilder)localObject2).append(")");
    localObject2 = ((StringBuilder)localObject2).toString();
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localView.setOnClickListener(new ContactsTroopAdapter.2(this, paramInt));
    localView.setOnTouchListener(new ContactsTroopAdapter.3(this, (TextView)localObject1));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131900678));
    localView.setContentDescription(((StringBuilder)localObject1).toString());
    return localView;
  }
  
  private Entity a(int paramInt1, int paramInt2)
  {
    paramInt1 = ((Integer)this.c.get(paramInt1)).intValue();
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
              return ((TroopListItemWithMask)this.i.get(paramInt2)).b;
            }
            return ((TroopListItemWithMask)this.h.get(paramInt2)).b;
          }
          return ((TroopListItemWithMask)this.f.get(paramInt2)).b;
        }
        return ((TroopListItemWithMask)this.e.get(paramInt2)).b;
      }
      return ((TroopListItemWithMask)this.g.get(paramInt2)).b;
    }
    return (Entity)this.d.get(paramInt2);
  }
  
  private void a(BuddyListTroop.TroopDisChildTag paramTroopDisChildTag)
  {
    if ((paramTroopDisChildTag.c instanceof DiscussionInfo))
    {
      a(paramTroopDisChildTag, (DiscussionInfo)paramTroopDisChildTag.c);
      return;
    }
    TroopInfo localTroopInfo = (TroopInfo)paramTroopDisChildTag.c;
    a(paramTroopDisChildTag, localTroopInfo);
    ThreadPriorityManager.a(true);
    paramTroopDisChildTag = AIOUtils.a(new Intent(this.b, SplashActivity.class), null);
    paramTroopDisChildTag.putExtra("uin", localTroopInfo.troopuin);
    if (localTroopInfo.troopcode != null) {
      paramTroopDisChildTag.putExtra("troop_uin", localTroopInfo.troopcode);
    }
    paramTroopDisChildTag.putExtra("uintype", 1);
    paramTroopDisChildTag.putExtra("uinname", localTroopInfo.getTroopDisplayName());
    paramTroopDisChildTag.putExtra("open_chatfragment_withanim", true);
    paramTroopDisChildTag.putExtra("isFromContactTab", true);
    this.b.startActivity(paramTroopDisChildTag);
  }
  
  private void a(BuddyListTroop.TroopDisChildTag paramTroopDisChildTag, DiscussionInfo paramDiscussionInfo)
  {
    ThreadPriorityManager.a(true);
    Intent localIntent = AIOUtils.a(new Intent(this.b, SplashActivity.class), null);
    localIntent.putExtra("uin", paramDiscussionInfo.uin);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramDiscussionInfo.discussionName);
    localIntent.putExtra("open_chatfragment_withanim", true);
    this.b.startActivity(localIntent);
    int i1 = ((Integer)this.c.get(paramTroopDisChildTag.d)).intValue();
    if (i1 != 0)
    {
      if (i1 == 2) {
        break label158;
      }
      if (i1 == 4) {
        break label153;
      }
      if (i1 == 6) {
        break label148;
      }
      if (i1 == 8) {
        break label143;
      }
      if (i1 == 10) {}
    }
    else
    {
      i1 = 0;
      break label160;
    }
    i1 = 4;
    break label160;
    label143:
    i1 = 5;
    break label160;
    label148:
    i1 = 2;
    break label160;
    label153:
    i1 = 1;
    break label160;
    label158:
    i1 = 3;
    label160:
    new ReportTask(this.a).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_grp").a(new String[] { paramDiscussionInfo.uin, String.valueOf(i1) }).a();
  }
  
  private void a(BuddyListTroop.TroopDisChildTag paramTroopDisChildTag, TroopInfo paramTroopInfo)
  {
    int i1 = ((Integer)this.c.get(paramTroopDisChildTag.d)).intValue();
    int i2 = 3;
    if (i1 != 0)
    {
      if (i1 == 2) {
        break label80;
      }
      if (i1 == 4) {
        break label75;
      }
      if (i1 == 6) {
        break label70;
      }
      if (i1 == 8) {
        break label65;
      }
      if (i1 == 10) {}
    }
    else
    {
      i1 = 0;
      break label82;
    }
    i1 = 4;
    break label82;
    label65:
    i1 = 5;
    break label82;
    label70:
    i1 = 2;
    break label82;
    label75:
    i1 = 1;
    break label82;
    label80:
    i1 = 3;
    label82:
    int i3 = this.a.getTroopMask(paramTroopInfo.troopuin);
    if (i3 != 1)
    {
      if (i3 == 2) {
        break label131;
      }
      if (i3 == 3) {
        break label134;
      }
      if (i3 == 4) {}
    }
    else
    {
      i2 = 0;
      break label134;
    }
    i2 = 1;
    break label134;
    label131:
    i2 = 2;
    label134:
    if (paramTroopDisChildTag.k) {
      new ReportTask(this.a).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_inactiveGrp").a(new String[] { paramTroopInfo.troopuin, String.valueOf(i1) }).a();
    }
    paramTroopDisChildTag = this.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramTroopInfo.troopuin);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i2);
    localStringBuilder.append("");
    ReportController.b(paramTroopDisChildTag, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, (String)localObject, String.valueOf(i1), localStringBuilder.toString(), "");
    new ReportTask(this.a).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_grp").a(new String[] { paramTroopInfo.troopuin, String.valueOf(i1) }).a();
    if (i1 == 5) {
      new ReportTask(this.a).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_unnamedGrp").a(new String[] { paramTroopInfo.troopuin }).a();
    }
  }
  
  private void a(DiscussionInfo paramDiscussionInfo)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.b, null);
    DiscussionHandler localDiscussionHandler = (DiscussionHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
    boolean bool = localDiscussionHandler.a(paramDiscussionInfo);
    int i1;
    if (bool) {
      i1 = 2131890181;
    } else {
      i1 = 2131890183;
    }
    localActionSheet.addButton(i1);
    localActionSheet.addCancelButton(2131887648);
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
    paramTroopDisChildTag.p = paramDiscussionInfo.uin;
    paramTroopDisChildTag.c = paramDiscussionInfo;
    paramTroopDisChildTag.q = 101;
    paramTroopDisChildTag.g.setVisibility(4);
    paramTroopDisChildTag.j.setVisibility(8);
    paramTroopDisChildTag.h.setVisibility(8);
    paramTroopDisChildTag.e.setText(paramDiscussionInfo.discussionName);
    int i1 = this.m.c(paramDiscussionInfo.uin);
    if ((!paramDiscussionInfo.hasRenamed()) && (i1 > 0))
    {
      paramTroopDisChildTag.f.setVisibility(0);
      paramTroopDisChildTag.f.setText(String.format("(%d)", new Object[] { Integer.valueOf(i1) }));
    }
    else
    {
      paramTroopDisChildTag.f.setVisibility(8);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DiscussionInfo hasRenamed:");
      localStringBuilder.append(paramDiscussionInfo.hasRenamed());
      localStringBuilder.append(" | memberNum:");
      localStringBuilder.append(i1);
      localStringBuilder.append(" | uin:");
      localStringBuilder.append(paramDiscussionInfo.uin);
      localStringBuilder.append("  discussionName:");
      localStringBuilder.append(paramDiscussionInfo.discussionName);
      QLog.d("ContactsTroopAdapter", 2, localStringBuilder.toString());
    }
    long l1 = paramDiscussionInfo.lastMsgTime;
    if (AppSetting.e) {
      paramTroopDisChildTag.leftView.setContentDescription(paramTroopDisChildTag.e.getText());
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
    paramTroopDisChildTag.p = paramTroopInfo.troopuin;
    paramTroopDisChildTag.c = paramTroopInfo;
    paramTroopDisChildTag.q = 4;
    paramTroopDisChildTag.k = b(paramInt1, paramInt2);
    int i1 = this.a.getTroopMask(paramTroopInfo.troopuin);
    if (i1 == 3)
    {
      paramTroopDisChildTag.g.setVisibility(0);
      paramTroopDisChildTag.g.setImageResource(2130852643);
    }
    else if (i1 == 1)
    {
      paramTroopDisChildTag.g.setVisibility(4);
    }
    else
    {
      paramTroopDisChildTag.g.setVisibility(0);
      paramTroopDisChildTag.g.setImageResource(2130839674);
    }
    TextView localTextView = paramTroopDisChildTag.e;
    Object localObject;
    if (!TextUtils.isEmpty(paramTroopInfo.getTroopDisplayName())) {
      localObject = paramTroopInfo.getTroopDisplayName();
    } else {
      localObject = paramTroopInfo.troopuin;
    }
    localTextView.setText((CharSequence)localObject);
    if ((!paramTroopInfo.hasSetTroopName()) && (paramTroopInfo.wMemberNumClient > 0))
    {
      paramTroopDisChildTag.f.setVisibility(0);
      paramTroopDisChildTag.f.setText(String.format("(%d)", new Object[] { Integer.valueOf(paramTroopInfo.wMemberNumClient) }));
    }
    else
    {
      paramTroopDisChildTag.f.setVisibility(8);
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
    long l1 = paramTroopInfo.lastMsgTime;
    if ((paramTroopInfo.dwGroupFlagExt & 0x800) != 0L)
    {
      if (paramTroopInfo.dwAuthGroupType == 2L)
      {
        paramTroopDisChildTag.j.setVisibility(0);
        paramTroopDisChildTag.j.setBackgroundResource(2130844940);
      }
      else if (paramTroopInfo.dwAuthGroupType == 1L)
      {
        paramTroopDisChildTag.j.setVisibility(0);
        paramTroopDisChildTag.j.setBackgroundResource(2130844940);
      }
      else
      {
        paramTroopDisChildTag.j.setVisibility(8);
      }
    }
    else {
      paramTroopDisChildTag.j.setVisibility(8);
    }
    if (paramTroopInfo.isTroopBlocked)
    {
      paramTroopDisChildTag.h.setVisibility(0);
      if (SimpleUIUtil.e()) {
        paramTroopDisChildTag.h.setBackgroundResource(2130843522);
      } else {
        paramTroopDisChildTag.h.setBackgroundResource(2130843521);
      }
      paramTroopDisChildTag.g.setVisibility(0);
      paramTroopDisChildTag.g.setImageResource(2130853326);
      localObject = (FrameLayout.LayoutParams)paramTroopDisChildTag.g.getLayoutParams();
      if (localObject != null)
      {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = (-ViewUtils.dpToPx(2.0F));
        ((FrameLayout.LayoutParams)localObject).rightMargin = (-ViewUtils.dpToPx(3.0F));
      }
    }
    else if (paramTroopInfo.troopCreditLevel == 2L)
    {
      paramTroopDisChildTag.h.setVisibility(0);
      if (SimpleUIUtil.e()) {
        paramTroopDisChildTag.h.setBackgroundResource(2130843522);
      } else {
        paramTroopDisChildTag.h.setBackgroundResource(2130843521);
      }
      paramTroopDisChildTag.g.setVisibility(0);
      paramTroopDisChildTag.g.setImageResource(2130852646);
    }
    else if (paramTroopInfo.troopCreditLevel == 1L)
    {
      paramTroopDisChildTag.h.setVisibility(0);
      if (SimpleUIUtil.e()) {
        paramTroopDisChildTag.h.setBackgroundResource(2130843522);
      } else {
        paramTroopDisChildTag.h.setBackgroundResource(2130843521);
      }
      paramTroopDisChildTag.g.setVisibility(0);
      paramTroopDisChildTag.g.setImageResource(2130852644);
    }
    else
    {
      paramTroopDisChildTag.h.setVisibility(4);
    }
    if (AppSetting.e) {
      paramTroopDisChildTag.leftView.setContentDescription(paramTroopDisChildTag.e.getText());
    }
    a(paramTroopDisChildTag, null);
    paramView.setOnClickListener(this);
    paramView.setOnLongClickListener(this);
    a(paramView, paramInt1 << 16 | paramInt2, paramTroopDisChildTag, this, paramTroopInfo);
  }
  
  private int b(int paramInt)
  {
    int i2 = 0;
    int i1 = i2;
    if (paramInt >= 0)
    {
      if (paramInt >= this.c.size()) {
        return 0;
      }
      paramInt = ((Integer)this.c.get(paramInt)).intValue();
      i1 = i2;
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
        i1 = 3;
      }
    }
    return i1;
  }
  
  private void b(TroopInfo paramTroopInfo)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.b, null);
    boolean bool = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).o(paramTroopInfo.troopuin);
    int i1;
    if (bool) {
      i1 = 2131890181;
    } else {
      i1 = 2131890183;
    }
    localActionSheet.addButton(i1);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new ContactsTroopAdapter.6(this, bool, paramTroopInfo, localActionSheet));
    try
    {
      localActionSheet.show();
      return;
    }
    catch (Exception paramTroopInfo) {}
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      int[] arrayOfInt = this.o;
      if ((paramInt1 < arrayOfInt.length) && (paramInt2 > arrayOfInt[paramInt1])) {
        return true;
      }
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    int i2 = 0;
    int i3 = 10;
    int i1 = i2;
    if (paramInt >= 0)
    {
      i1 = i2;
      if (paramInt < this.c.size())
      {
        i1 = ((Integer)this.c.get(paramInt)).intValue();
        if (i1 != 0)
        {
          if (i1 != 2)
          {
            if (i1 != 4)
            {
              if (i1 != 6)
              {
                if (i1 != 8)
                {
                  if (i1 != 10)
                  {
                    i1 = i2;
                  }
                  else
                  {
                    i1 = this.i.size();
                    i2 = a(this.i);
                    break label210;
                  }
                }
                else
                {
                  i1 = this.h.size();
                  i2 = a(this.h);
                  break label210;
                }
              }
              else
              {
                i1 = this.f.size();
                i2 = a(this.f);
                break label210;
              }
            }
            else
            {
              i1 = this.e.size();
              i2 = a(this.e);
              break label210;
            }
          }
          else
          {
            i1 = this.g.size();
            i2 = a(this.g);
            break label210;
          }
        }
        else
        {
          i1 = this.d.size();
          this.n[paramInt] = 3;
        }
      }
    }
    i2 = 0;
    label210:
    if (i1 <= 10)
    {
      this.n[paramInt] = 3;
    }
    else
    {
      int[] arrayOfInt = this.n;
      if (arrayOfInt[paramInt] == 0) {
        arrayOfInt[paramInt] = 1;
      }
    }
    if (i1 <= 10) {
      i2 = i1;
    } else if (i2 < 10) {
      i2 = i3;
    }
    this.o[paramInt] = i2;
    this.p[paramInt] = (i1 - i2);
  }
  
  private void h()
  {
    if (this.c.size() > 1)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      Object localObject = this.j.iterator();
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
      this.a.getApp().getSharedPreferences(this.a.getAccount(), 0).edit().putString("700_sp_key_last_troop_expanded", localStringBuffer.toString()).commit();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopAdapter", 2, "less than 1 group : don't saveExpanded");
    }
  }
  
  private void i()
  {
    ContactsTroopAdapter.LoadTroopDiscussInfoSubRunnable localLoadTroopDiscussInfoSubRunnable = new ContactsTroopAdapter.LoadTroopDiscussInfoSubRunnable(this, null);
    localLoadTroopDiscussInfoSubRunnable.a = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER));
    localLoadTroopDiscussInfoSubRunnable.b = this.a.getProxyManager().g();
    ThreadManager.post(localLoadTroopDiscussInfoSubRunnable, 8, null, true);
  }
  
  protected int a(List<TroopListItemWithMask> paramList)
  {
    paramList = paramList.iterator();
    int i1 = 0;
    while (paramList.hasNext())
    {
      TroopListItemWithMask localTroopListItemWithMask = (TroopListItemWithMask)paramList.next();
      if ((localTroopListItemWithMask.b != null) && ((localTroopListItemWithMask.b instanceof TroopInfo)) && (((TroopInfo)localTroopListItemWithMask.b).lastMsgTime > 0L)) {
        i1 += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("getActiveTroopCount activeTroopCount:");
      paramList.append(i1);
      QLog.d("ContactsTroopAdapter", 2, paramList.toString());
    }
    return i1;
  }
  
  protected void a()
  {
    if (this.c.size() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "only one group");
      }
      this.r.expandGroup(0);
      this.j.add(this.c.get(0));
      return;
    }
    Object localObject2 = this.a.getApp().getSharedPreferences(this.a.getAccount(), 0).getString("700_sp_key_last_troop_expanded", "700_sp_key_last_troop_expanded");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("readExpand=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("ContactsTroopAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new HashSet();
    int i2;
    int i1;
    if (((String)localObject2).equalsIgnoreCase("700_sp_key_last_troop_expanded"))
    {
      if (this.c.size() > 0) {
        ((Set)localObject1).add(this.c.get(0));
      } else {
        this.u = true;
      }
    }
    else if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = ((String)localObject2).split("_");
      i2 = localObject2.length;
      i1 = 0;
    }
    for (;;)
    {
      String str;
      if (i1 < i2) {
        str = localObject2[i1];
      }
      try
      {
        ((Set)localObject1).add(Integer.valueOf(Integer.parseInt(str)));
        label237:
        i1 += 1;
        continue;
        i1 = 0;
        while (i1 < this.c.size())
        {
          if (((Set)localObject1).contains(this.c.get(i1)))
          {
            this.j.add(this.c.get(i1));
            if (this.c.size() == 1) {
              i2 = 0;
            } else {
              i2 = i1;
            }
            if ((i1 > 0) && (i1 < this.n.length)) {
              c(i1);
            }
            this.r.expandGroup(i1);
            localObject2 = this.n;
            if ((i1 < localObject2.length) && (localObject2[i1] == 1) && (this.r.isGroupExpanded(i2)))
            {
              i2 = b(i1);
              new ReportTask(this.a).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp_inactive").a(new String[] { "", String.valueOf(i2) }).a();
            }
          }
          i1 += 1;
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
      int i1 = 1;
      if (paramInt > 0)
      {
        if ((paramObject instanceof TroopInfo))
        {
          paramObject = (TroopInfo)paramObject;
          if (this.d.contains(paramObject))
          {
            paramInt = 1;
            break label52;
          }
        }
        paramInt = 0;
        label52:
        paramArrayOfSwipRightMenuItem[0].menuId = paramInt;
        paramArrayOfSwipRightMenuItem[0].menuType = 0;
        paramInt = i1;
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
    SwipTextViewMenuBuilder localSwipTextViewMenuBuilder = this.k;
    int i1;
    if (localSwipTextViewMenuBuilder != null) {
      i1 = localSwipTextViewMenuBuilder.updateRightMenuView(this.b, paramView, paramInt, paramObject, paramViewTag, paramOnClickListener);
    } else {
      i1 = 0;
    }
    int i2 = this.l;
    if (i2 != -1)
    {
      if (paramInt != i2)
      {
        paramView.scrollTo(0, 0);
        return;
      }
      paramView.scrollTo(i1, 0);
    }
  }
  
  public void a(TroopInfo paramTroopInfo, RecentUserProxy paramRecentUserProxy)
  {
    if (this.a.getTroopMask(paramTroopInfo.troopuin) == 2)
    {
      paramTroopInfo.lastMsgTime = this.a.getMessageFacade().getLastMessage(paramTroopInfo.troopuin, 1).time;
      return;
    }
    paramTroopInfo.lastMsgTime = paramRecentUserProxy.b(paramTroopInfo.troopuin, 1).lastmsgtime;
  }
  
  protected void a(GroupTag paramGroupTag)
  {
    int i1 = this.c.size();
    int i3 = 0;
    if (i1 == 1) {
      i1 = 0;
    } else {
      i1 = paramGroupTag.a;
    }
    if (this.r.isGroupExpanded(i1))
    {
      this.r.collapseGroup(i1);
      this.j.remove(this.c.get(i1));
      i1 = i3;
    }
    else
    {
      int i2 = 0;
      while (i2 < this.c.size())
      {
        if (this.r.isGroupExpanded(i2))
        {
          this.r.collapseGroup(i2);
          this.j.remove(this.c.get(i2));
        }
        i2 += 1;
      }
      this.r.expandGroup(i1);
      this.j.add(this.c.get(i1));
      i1 = i3;
    }
    for (;;)
    {
      paramGroupTag = this.n;
      if (i1 >= paramGroupTag.length) {
        break;
      }
      if (paramGroupTag[i1] == 2) {
        paramGroupTag[i1] = 1;
      }
      i1 += 1;
    }
  }
  
  protected void a(GroupTag paramGroupTag, int paramInt, boolean paramBoolean)
  {
    if (paramGroupTag != null)
    {
      if ((paramInt >= 0) && (paramInt < this.c.size()))
      {
        i1 = ((Integer)this.c.get(paramInt)).intValue();
        if (i1 != 0)
        {
          if (i1 != 2)
          {
            if (i1 != 4)
            {
              if (i1 != 6)
              {
                if (i1 != 8)
                {
                  if (i1 == 10)
                  {
                    str = HardCodeUtil.a(2131900734);
                    i1 = this.i.size();
                    i2 = a(this.i);
                    break label280;
                  }
                }
                else
                {
                  str = HardCodeUtil.a(2131913074);
                  i1 = this.h.size();
                  i2 = a(this.h);
                  break label280;
                }
              }
              else
              {
                str = HardCodeUtil.a(2131913076);
                i1 = this.f.size();
                i2 = a(this.f);
                break label280;
              }
            }
            else
            {
              str = HardCodeUtil.a(2131913073);
              i1 = this.e.size();
              i2 = a(this.e);
              break label280;
            }
          }
          else
          {
            str = HardCodeUtil.a(2131913069);
            i1 = this.g.size();
            i2 = a(this.g);
            break label280;
          }
        }
        else
        {
          str = HardCodeUtil.a(2131900718);
          i1 = this.d.size();
          this.n[paramInt] = 3;
          break label277;
        }
      }
      String str = "";
      int i1 = 0;
      label277:
      int i2 = 0;
      label280:
      int i3;
      if (i1 <= 10)
      {
        i3 = i1;
      }
      else
      {
        i3 = i2;
        if (i2 < 10) {
          i3 = 10;
        }
      }
      if (i1 <= 10)
      {
        this.n[paramInt] = 3;
      }
      else
      {
        localObject1 = this.n;
        if (localObject1[paramInt] == 0)
        {
          localObject1[paramInt] = 1;
          notifyDataSetChanged();
        }
      }
      this.o[paramInt] = i3;
      this.p[paramInt] = (i1 - i3);
      Object localObject2;
      if (this.n[paramInt] == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(i3);
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append(i1);
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(i1);
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      StringBuilder localStringBuilder = paramGroupTag.g;
      Object localObject1 = localStringBuilder;
      if (AppSetting.e)
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
      paramGroupTag.a = paramInt;
      paramGroupTag.d.setText(str);
      paramGroupTag.e.setVisibility(8);
      paramGroupTag.c.setVisibility(8);
      paramGroupTag.b.setVisibility(0);
      paramGroupTag.f.setText((CharSequence)localObject2);
      if (AppSetting.e)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("共");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append("个");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      }
      paramGroupTag.b.setChecked(paramBoolean);
      if (AppSetting.e)
      {
        if (paramGroupTag.b.isChecked()) {
          ((StringBuilder)localObject1).append(" 已展开");
        } else {
          ((StringBuilder)localObject1).append(" 已折叠");
        }
        paramGroupTag.f.setContentDescription(((StringBuilder)localObject1).toString());
        AccessibilityUtil.a(paramGroupTag.b, false);
      }
    }
  }
  
  public void b()
  {
    super.b();
    this.a.removeObserver(this.q);
    if (this.r != null)
    {
      this.r.setOnItemLongClickListener(null);
      int i2 = this.r.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = this.r.getChildAt(i1);
        if (localView != null)
        {
          localView.setOnClickListener(null);
          localView.setOnLongClickListener(null);
        }
        i1 += 1;
      }
    }
  }
  
  protected void b(GroupTag paramGroupTag)
  {
    a(paramGroupTag);
    c(paramGroupTag.a);
    if ((paramGroupTag.a >= 0) && (paramGroupTag.a < this.n.length))
    {
      int i1;
      if (this.c.size() == 1) {
        i1 = 0;
      } else {
        i1 = paramGroupTag.a;
      }
      if ((this.n[paramGroupTag.a] == 1) && (this.r.isGroupExpanded(i1)))
      {
        i1 = b(paramGroupTag.a);
        new ReportTask(this.a).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp_inactive").a(new String[] { "", String.valueOf(i1) }).a();
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
    if (this.c.size() == 1) {
      return;
    }
    Object localObject;
    if (!(paramView.getTag() instanceof GroupTag))
    {
      localObject = new GroupTag();
      ((GroupTag)localObject).b = ((CheckBox)paramView.findViewById(2131436369));
      ((GroupTag)localObject).d = ((SingleLineTextView)paramView.findViewById(2131434435));
      ((GroupTag)localObject).d.setDefaultTextColor(-8355712);
      ((GroupTag)localObject).e = ((SingleLineTextView)paramView.findViewById(2131448697));
      ((GroupTag)localObject).f = ((SimpleTextView)paramView.findViewById(2131431254));
      ((GroupTag)localObject).f.setDefaultTextColor(1711276032);
      ((GroupTag)localObject).c = ((ProgressBar)paramView.findViewById(2131436506));
      paramView.setTag(localObject);
      paramView = (View)localObject;
    }
    else
    {
      paramView = (GroupTag)paramView.getTag();
    }
    if (ThemeUtil.isNowThemeIsDefaultCache(this.a, false))
    {
      paramView.f.setTextColor(-5196865);
    }
    else
    {
      localObject = this.b.getResources().getColorStateList(2131168122);
      paramView.f.setTextColor((ColorStateList)localObject);
    }
    a(paramView, paramInt, this.r.isGroupExpanded(paramInt));
  }
  
  public void d()
  {
    ThreadManager.getUIHandler().post(new ContactsTroopAdapter.5(this));
  }
  
  public void e()
  {
    this.u = true;
    this.j.clear();
    notifyDataSetChanged();
  }
  
  protected void f()
  {
    Object localObject = new TroopCompator();
    Collections.sort(this.e, (Comparator)localObject);
    Collections.sort(this.f, (Comparator)localObject);
    Collections.sort(this.g, (Comparator)localObject);
    Collections.sort(this.h, (Comparator)localObject);
    Collections.sort(this.i, (Comparator)localObject);
    boolean bool2 = this.d.isEmpty();
    boolean bool1 = true;
    if ((bool2 ^ true)) {
      this.c.add(Integer.valueOf(0));
    }
    if (this.h.size() > 0) {
      this.c.add(Integer.valueOf(8));
    }
    if (this.e.size() > 0) {
      this.c.add(Integer.valueOf(4));
    }
    if (this.f.size() > 0) {
      this.c.add(Integer.valueOf(6));
    }
    if (this.g.size() > 0) {
      this.c.add(Integer.valueOf(2));
    }
    if (this.i.size() > 0) {
      this.c.add(Integer.valueOf(10));
    }
    localObject = new HashSet(5);
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (this.c.contains(localInteger)) {
        ((HashSet)localObject).add(localInteger);
      }
    }
    this.j = ((HashSet)localObject);
    b(this);
    if (this.u)
    {
      this.u = false;
      a();
    }
    else if (this.c.size() == 1)
    {
      this.r.expandGroup(0);
      this.j.add(this.c.get(0));
    }
    else
    {
      int i1 = 0;
      while (i1 < this.c.size())
      {
        if (this.j.contains(this.c.get(i1))) {
          this.r.expandGroup(i1);
        } else {
          this.r.collapseGroup(i1);
        }
        i1 += 1;
      }
    }
    if ((this.r instanceof PinnedHeaderExpandableListView))
    {
      localObject = (PinnedHeaderExpandableListView)this.r;
      if (this.c.size() <= 1) {
        bool1 = false;
      }
      ((PinnedHeaderExpandableListView)localObject).setHeaderViewShouldShow(bool1);
    }
  }
  
  public void g()
  {
    if (this.c.size() <= 1) {
      return;
    }
    int i1 = 0;
    int i2 = this.c.size();
    while (i1 < i2)
    {
      this.r.collapseGroup(i1);
      i1 += 1;
    }
    this.j.clear();
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
    if ((paramInt2 == getChildrenCount(paramInt1) - 1) && (this.n[paramInt1] == 1)) {
      return a(paramInt1);
    }
    if ((paramView != null) && ((paramView.getTag() instanceof BuddyListTroop.TroopDisChildTag)))
    {
      paramViewGroup = (BuddyListTroop.TroopDisChildTag)paramView.getTag();
    }
    else
    {
      localObject = LayoutInflater.from(this.b).inflate(2131629574, null);
      ((View)localObject).setMinimumHeight(this.s);
      paramViewGroup = new BuddyListTroop.TroopDisChildTag();
      paramView = this.k.createView(this.b, (View)localObject, paramViewGroup, -1);
      paramViewGroup.leftView = ((View)localObject);
      paramViewGroup.e = ((TextView)paramView.findViewById(2131447063));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131447065));
      paramViewGroup.r = ((ImageView)paramView.findViewById(2131435219));
      if ((paramViewGroup.r instanceof ThemeImageView)) {
        ((ThemeImageView)paramViewGroup.r).setSupportMaskView(false);
      }
      paramViewGroup.h = ((ImageView)paramView.findViewById(2131437976));
      paramViewGroup.g = ((ImageView)paramView.findViewById(2131446321));
      paramViewGroup.i = ((TextView)paramView.findViewById(2131438948));
      paramViewGroup.j = ((ImageView)paramView.findViewById(2131447913));
      localObject = paramView.getResources().getColorStateList(2131168001);
      paramViewGroup.e.setTextColor((ColorStateList)localObject);
      paramView.setTag(paramViewGroup);
    }
    paramViewGroup.d = paramInt1;
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
    int i1 = 0;
    int i2 = 0;
    if (paramInt >= 0)
    {
      if (paramInt >= this.c.size()) {
        return 0;
      }
      i1 = ((Integer)this.c.get(paramInt)).intValue();
      if (i1 != 0)
      {
        if (i1 != 2)
        {
          if (i1 != 4)
          {
            if (i1 != 6)
            {
              if (i1 != 8)
              {
                if (i1 != 10) {
                  i1 = i2;
                } else {
                  i1 = this.i.size();
                }
              }
              else {
                i1 = this.h.size();
              }
            }
            else {
              i1 = this.f.size();
            }
          }
          else {
            i1 = this.e.size();
          }
        }
        else {
          i1 = this.g.size();
        }
      }
      else
      {
        i1 = this.d.size();
        this.n[paramInt] = 3;
      }
      i2 = i1;
      Object localObject;
      if (this.n[paramInt] == 1)
      {
        localObject = this.o;
        i2 = i1;
        if (localObject[paramInt] < i1) {
          i2 = localObject[paramInt] + 1;
        }
      }
      i1 = i2;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getChildrenCount count:");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append("  groupPosition:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("ContactsTroopAdapter", 2, ((StringBuilder)localObject).toString());
        i1 = i2;
      }
    }
    return i1;
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
      localStringBuilder.append(this.c.size());
      QLog.d("ContactsTroopAdapter", 2, localStringBuilder.toString());
    }
    return this.c.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2131624548, paramViewGroup, false);
      paramViewGroup = new GroupTag();
      paramViewGroup.d = ((SingleLineTextView)paramView.findViewById(2131434435));
      paramViewGroup.d.setDefaultTextColor(-8355712);
      paramViewGroup.b = ((CheckBox)paramView.findViewById(2131436369));
      paramViewGroup.f = ((SimpleTextView)paramView.findViewById(2131431254));
      paramViewGroup.f.setDefaultTextColor(1711276032);
      paramViewGroup.c = ((ProgressBar)paramView.findViewById(2131436506));
      paramViewGroup.e = ((SingleLineTextView)paramView.findViewById(2131448697));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (GroupTag)paramView.getTag();
    }
    if (this.c.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
    }
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.t));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.a, false))
    {
      paramViewGroup.f.setTextColor(-5196865);
    }
    else
    {
      ColorStateList localColorStateList = this.b.getResources().getColorStateList(2131168122);
      paramViewGroup.f.setTextColor(localColorStateList);
    }
    a(paramViewGroup, paramInt, paramBoolean);
    paramView.setOnClickListener(this);
    return paramView;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131624548;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean)
  {
    FrameHelperActivity.c(paramBoolean ^ true);
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
    if (((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getCommonlyUsedTroopCache() == null)
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
    if ((localHeaderScrollView != null) && (localHeaderScrollView.a)) {
      return false;
    }
    paramView = paramView.getTag();
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if ((paramView instanceof BuddyListItem.ViewTag))
      {
        paramView = ((BuddyListItem.ViewTag)paramView).c;
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
    int i2 = -1;
    int i1 = i2;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i1 = i2;
      if ((paramView instanceof Integer)) {
        i1 = ((Integer)paramView).intValue();
      }
    }
    this.l = i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter
 * JD-Core Version:    0.7.0.1
 */