package com.tencent.av.wtogether.adapter;

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
import com.tencent.av.wtogether.callback.GroupClickListener;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.activity.contacts.troop.BuddyListTroop.TroopDisChildTag;
import com.tencent.mobileqq.adapter.SwipFacePreloadExpandableAdapter;
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
import com.tencent.mobileqq.troop.adapter.contact.GroupTag;
import com.tencent.mobileqq.troop.adapter.contact.TroopCompator;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItemWithMask;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
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

public class QGroupExpandableListAdapter
  extends SwipFacePreloadExpandableAdapter
  implements View.OnClickListener, AdapterView.OnItemLongClickListener, ExpandableListView.OnGroupClickListener, SwipPinnedHeaderExpandableListView.SwipListListener
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
  TroopAvatarObserver q = new QGroupExpandableListAdapter.6(this);
  private int s = 0;
  private int t = 0;
  private GroupClickListener u;
  
  public QGroupExpandableListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, GroupClickListener paramGroupClickListener)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.a = paramQQAppInterface;
    this.b = paramContext;
    this.u = paramGroupClickListener;
    this.s = AIOUtils.b(56.0F, paramContext.getResources());
    this.t = AIOUtils.b(44.0F, paramContext.getResources());
    this.k = new QGroupExpandableListAdapter.1(this, 1, 1, new int[] { paramContext.getResources().getDimensionPixelSize(2131297140) }, -1, new int[] { 2131438137, 2131438137 }, new int[] { 2131890183, 2131890181 }, new int[] { 2130839699, 2130839699 });
    this.a.addObserver(this.q);
    this.m = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    this.r.setOnItemLongClickListener(this);
  }
  
  private int a(List<TroopListItemWithMask> paramList)
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
      QLog.d("QGroupListAdapter", 2, paramList.toString());
    }
    return i1;
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
    localView.setOnClickListener(new QGroupExpandableListAdapter.2(this, paramInt));
    localView.setOnTouchListener(new QGroupExpandableListAdapter.3(this, (TextView)localObject1));
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
    Object localObject;
    if ((paramTroopDisChildTag.c instanceof DiscussionInfo))
    {
      localObject = (DiscussionInfo)paramTroopDisChildTag.c;
      paramTroopDisChildTag = ((DiscussionInfo)localObject).uin;
      localObject = ((DiscussionInfo)localObject).discussionName;
    }
    else
    {
      localObject = (TroopInfo)paramTroopDisChildTag.c;
      paramTroopDisChildTag = ((TroopInfo)localObject).getTroopUin();
      localObject = ((TroopInfo)localObject).getTroopDisplayName();
    }
    this.u.a(paramTroopDisChildTag, (String)localObject);
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
      QLog.d("QGroupListAdapter", 2, localStringBuilder.toString());
    }
    long l1 = paramDiscussionInfo.lastMsgTime;
    if (AppSetting.e) {
      paramTroopDisChildTag.leftView.setContentDescription(paramTroopDisChildTag.e.getText());
    }
    a(paramTroopDisChildTag, null);
    paramView.setOnClickListener(this);
    a(paramView, paramInt1 << 16 | paramInt2, paramTroopDisChildTag, this, paramDiscussionInfo);
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
      QLog.d("QGroupListAdapter", 2, ((StringBuilder)localObject).toString());
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
    a(paramView, paramInt1 << 16 | paramInt2, paramTroopDisChildTag, this, paramTroopInfo);
  }
  
  private void a(GroupTag paramGroupTag)
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
  
  private void a(GroupTag paramGroupTag, int paramInt, boolean paramBoolean)
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
      Object localObject;
      if (i1 <= 10)
      {
        this.n[paramInt] = 3;
      }
      else
      {
        localObject = this.n;
        if (localObject[paramInt] == 0)
        {
          localObject[paramInt] = 1;
          notifyDataSetChanged();
        }
      }
      this.o[paramInt] = i3;
      this.p[paramInt] = (i1 - i3);
      if (this.n[paramInt] == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i3);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(i1);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i1);
        localObject = ((StringBuilder)localObject).toString();
      }
      paramGroupTag.a = paramInt;
      paramGroupTag.d.setText(str);
      paramGroupTag.e.setVisibility(8);
      paramGroupTag.c.setVisibility(8);
      paramGroupTag.b.setVisibility(0);
      paramGroupTag.f.setText((CharSequence)localObject);
      paramGroupTag.b.setChecked(paramBoolean);
    }
  }
  
  private void b(int paramInt)
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
  
  private void b(GroupTag paramGroupTag)
  {
    a(paramGroupTag);
    b(paramGroupTag.a);
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
  
  private void c()
  {
    QGroupExpandableListAdapter.LoadTroopDiscussInfoSubRunnable localLoadTroopDiscussInfoSubRunnable = new QGroupExpandableListAdapter.LoadTroopDiscussInfoSubRunnable(this, null);
    localLoadTroopDiscussInfoSubRunnable.a = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER));
    localLoadTroopDiscussInfoSubRunnable.b = this.a.getProxyManager().g();
    ThreadManager.post(localLoadTroopDiscussInfoSubRunnable, 8, null, true);
  }
  
  private void d()
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
    c(this);
    if (this.c.size() == 1)
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
  
  public void a()
  {
    this.j.clear();
    notifyDataSetChanged();
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
      QLog.d("QGroupListAdapter", 2, paramViewGroup.toString());
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
        QLog.d("QGroupListAdapter", 2, ((StringBuilder)localObject).toString());
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
      QLog.d("QGroupListAdapter", 2, localStringBuilder.toString());
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
      ThreadManager.postImmediately(new QGroupExpandableListAdapter.4(this), null, false);
      return;
    }
    c();
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof GroupTag))
    {
      b((GroupTag)paramView);
      return;
    }
    if ((paramView instanceof BuddyListTroop.TroopDisChildTag)) {
      a((BuddyListTroop.TroopDisChildTag)paramView);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */