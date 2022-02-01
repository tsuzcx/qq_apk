package com.tencent.mobileqq.activity.contacts.guild;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.activity.contacts.troop.BuddyListTroop.TroopDisChildTag;
import com.tencent.mobileqq.adapter.SwipFacePreloadExpandableAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.adapter.contact.GroupTag;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ContactsGuildAdapter
  extends SwipFacePreloadExpandableAdapter
  implements Handler.Callback, View.OnClickListener, ExpandableListView.OnGroupClickListener
{
  protected HashSet<Integer> a;
  protected int[] b;
  protected int[] c;
  protected int[] d;
  private final List<GuildContactsDataItem> e;
  private final List<GuildContactsDataItem> f;
  private final List<GuildContactsDataItem> g;
  private final List<GuildContactsDataItem> h;
  private final WeakReferenceHandler i;
  private final List<GuildContactsDataItem>[] j;
  private QQAppInterface k;
  private Context l;
  private int m;
  private int n;
  private GPServiceObserver o;
  
  private View a(int paramInt)
  {
    View localView = LayoutInflater.from(this.l).inflate(2131629573, null);
    Object localObject1 = (TextView)localView.findViewById(2131433605);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131900705));
    ((StringBuilder)localObject2).append(this.d[paramInt]);
    ((StringBuilder)localObject2).append(")");
    localObject2 = ((StringBuilder)localObject2).toString();
    ((TextView)localObject1).setText((CharSequence)localObject2);
    localView.setOnClickListener(new ContactsGuildAdapter.4(this, paramInt));
    localView.setOnTouchListener(new ContactsGuildAdapter.5(this, (TextView)localObject1));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131900678));
    localView.setContentDescription(((StringBuilder)localObject1).toString());
    return localView;
  }
  
  private void a(IGProGuildInfo paramIGProGuildInfo)
  {
    if (paramIGProGuildInfo == null)
    {
      QLog.e("ContactsGuildAdapter", 1, "onClickForGuildInfo guildInfo is null");
      return;
    }
    if (this.k == null)
    {
      QLog.e("ContactsGuildAdapter", 1, "onClickForGuildInfo app is null");
      return;
    }
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuild(this.k, this.l, false, null, paramIGProGuildInfo.getGuildID());
    int i1 = 3;
    if (paramIGProGuildInfo.getUserType() == 2) {
      i1 = 1;
    } else if (paramIGProGuildInfo.getUserType() == 1) {
      i1 = 2;
    }
    new ReportTask(this.k).a("dc00899").b("Sgrp_mber").c("mber_list_page").d("clk").a(new String[] { paramIGProGuildInfo.getShowNumber(), String.valueOf(i1) }).a();
  }
  
  private void a(IGProGuildInfo paramIGProGuildInfo, BuddyListTroop.TroopDisChildTag paramTroopDisChildTag, int paramInt1, int paramInt2, View paramView)
  {
    if (paramIGProGuildInfo == null) {
      return;
    }
    paramTroopDisChildTag.p = paramIGProGuildInfo.getGuildID();
    paramTroopDisChildTag.c = paramIGProGuildInfo;
    paramTroopDisChildTag.q = 4;
    paramTroopDisChildTag.k = b(paramInt1, paramInt2);
    paramTroopDisChildTag.g.setVisibility(8);
    paramTroopDisChildTag.e.setText(paramIGProGuildInfo.getGuildName());
    if (AppSetting.e) {
      paramTroopDisChildTag.leftView.setContentDescription(paramTroopDisChildTag.e.getText());
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    paramIGProGuildInfo = URLDrawable.getDrawable(paramIGProGuildInfo.getAvatarUrl(0), localURLDrawableOptions);
    paramInt1 = AIOUtils.b(56.0F, paramTroopDisChildTag.r.getResources());
    paramIGProGuildInfo.setTag(new int[] { paramInt1, paramInt1 });
    paramIGProGuildInfo.setDecodeHandler(URLDrawableDecodeHandler.c);
    paramTroopDisChildTag.r.setImageDrawable(paramIGProGuildInfo);
    paramView.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    int i2 = 0;
    Object localObject;
    if (paramInt >= 0)
    {
      localObject = this.j;
      if (paramInt < localObject.length)
      {
        i1 = localObject[paramInt].size();
        if (paramInt != 0)
        {
          if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
            break label77;
          }
          i2 = a(this.j[paramInt]);
          break label77;
        }
        this.b[paramInt] = 3;
        break label77;
      }
    }
    int i1 = 0;
    label77:
    if (i1 <= 10)
    {
      this.b[paramInt] = 3;
    }
    else
    {
      localObject = this.b;
      if (localObject[paramInt] == 0) {
        localObject[paramInt] = 1;
      }
    }
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
    this.c[paramInt] = i3;
    this.d[paramInt] = (i1 - i3);
  }
  
  private void b(List<IGProGuildInfo> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        IGProGuildInfo localIGProGuildInfo = (IGProGuildInfo)paramList.next();
        if (QLog.isColorLevel()) {
          QLog.d("ContactsGuildAdapter", 2, new Object[] { "guildInfo:", localIGProGuildInfo });
        }
        GuildContactsDataItem localGuildContactsDataItem = new GuildContactsDataItem(localIGProGuildInfo);
        if (localIGProGuildInfo.isTop()) {
          localArrayList1.add(localGuildContactsDataItem);
        }
        if (localIGProGuildInfo.getUserType() == 2) {
          localArrayList4.add(localGuildContactsDataItem);
        } else if (localIGProGuildInfo.getUserType() == 1) {
          localArrayList3.add(localGuildContactsDataItem);
        } else if (localIGProGuildInfo.getUserType() == 0) {
          localArrayList2.add(localGuildContactsDataItem);
        }
        RecentUser localRecentUser = this.k.getRecentUserProxy().b(localIGProGuildInfo.getGuildID(), 10014);
        if ((localRecentUser != null) && (localRecentUser.lastmsgtime > 0L)) {
          localGuildContactsDataItem.b = localRecentUser.lastmsgtime;
        }
        localGuildContactsDataItem.c = ChnToSpell.b(localIGProGuildInfo.getGuildName(), 2);
      }
      paramList = new GuildContactsComparator();
      Collections.sort(localArrayList1, paramList);
      Collections.sort(localArrayList2, paramList);
      Collections.sort(localArrayList4, paramList);
      Collections.sort(localArrayList3, paramList);
    }
    paramList = new ContactsGuildAdapter.3(this, localArrayList1, localArrayList2, localArrayList3, localArrayList4);
    this.i.post(paramList);
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      int[] arrayOfInt = this.c;
      if ((paramInt1 < arrayOfInt.length) && (paramInt2 > arrayOfInt[paramInt1])) {
        return true;
      }
    }
    return false;
  }
  
  protected int a(List<GuildContactsDataItem> paramList)
  {
    Object localObject = this.k;
    int i1 = 0;
    if (localObject == null) {
      return 0;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (GuildContactsDataItem)paramList.next();
      if ((localObject != null) && (((GuildContactsDataItem)localObject).b > 0L)) {
        i1 += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("getActiveTroopCount activeTroopCount:");
      paramList.append(i1);
      QLog.d("ContactsGuildAdapter", 2, paramList.toString());
    }
    return i1;
  }
  
  public GuildContactsDataItem a(int paramInt1, int paramInt2)
  {
    Object localObject = this.j;
    if (paramInt1 < localObject.length)
    {
      localObject = localObject[paramInt1];
      if ((localObject != null) && (((List)localObject).size() > paramInt2)) {
        return (GuildContactsDataItem)((List)localObject).get(paramInt2);
      }
    }
    return null;
  }
  
  public void a()
  {
    ThreadManagerV2.excute(new ContactsGuildAdapter.2(this), 16, null, false);
  }
  
  protected void a(GroupTag paramGroupTag)
  {
    b(paramGroupTag);
    b(paramGroupTag.a);
  }
  
  protected void a(GroupTag paramGroupTag, int paramInt, boolean paramBoolean)
  {
    if (paramGroupTag != null)
    {
      int i3 = this.j[paramInt].size();
      if ((paramInt >= 0) && (paramInt < this.j.length)) {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt == 3)
              {
                str = this.l.getResources().getString(2131890361);
                i1 = a(this.j[paramInt]);
                break label175;
              }
            }
            else
            {
              str = this.l.getResources().getString(2131890362);
              i1 = a(this.j[paramInt]);
              break label175;
            }
          }
          else
          {
            str = this.l.getResources().getString(2131890360);
            i1 = a(this.j[paramInt]);
            break label175;
          }
        }
        else
        {
          str = this.l.getResources().getString(2131890363);
          this.b[paramInt] = 3;
          break label172;
        }
      }
      String str = "";
      label172:
      int i1 = 0;
      label175:
      int i2;
      if (i3 <= 10) {
        i2 = i3;
      } else if (i1 < 10) {
        i2 = 10;
      } else {
        i2 = i1;
      }
      if (i3 <= 10)
      {
        this.b[paramInt] = 3;
      }
      else
      {
        localObject1 = this.b;
        if (localObject1[paramInt] == 0)
        {
          localObject1[paramInt] = 1;
          notifyDataSetChanged();
        }
      }
      if (i3 == i1) {
        this.b[paramInt] = 2;
      }
      this.c[paramInt] = i2;
      this.d[paramInt] = (i3 - i2);
      Object localObject2;
      if (this.b[paramInt] == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(i2);
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append(i3);
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(i3);
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
        ((StringBuilder)localObject2).append(i3);
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
    QQAppInterface localQQAppInterface = this.k;
    if (localQQAppInterface != null)
    {
      ((IGPSService)localQQAppInterface.getRuntimeService(IGPSService.class, "")).deleteObserver(this.o);
      this.k = null;
    }
    this.i.removeCallbacksAndMessages(null);
  }
  
  protected void b(GroupTag paramGroupTag)
  {
    int i1 = this.j.length;
    int i3 = 0;
    if (i1 == 1) {
      i1 = 0;
    } else {
      i1 = paramGroupTag.a;
    }
    if (this.r.isGroupExpanded(i1))
    {
      this.r.collapseGroup(i1);
      this.a.remove(Integer.valueOf(i1));
      i1 = i3;
    }
    else
    {
      int i2 = 0;
      while (i2 < this.j.length)
      {
        if (this.r.isGroupExpanded(i2))
        {
          this.r.collapseGroup(i2);
          this.a.remove(Integer.valueOf(i2));
        }
        i2 += 1;
      }
      this.r.expandGroup(i1);
      this.a.add(Integer.valueOf(i1));
      i1 = i3;
    }
    for (;;)
    {
      paramGroupTag = this.b;
      if (i1 >= paramGroupTag.length) {
        break;
      }
      if (paramGroupTag[i1] == 2) {
        paramGroupTag[i1] = 1;
      }
      i1 += 1;
    }
  }
  
  public void configHeaderView(View paramView, int paramInt) {}
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt2 == getChildrenCount(paramInt1) - 1) && (this.b[paramInt1] == 1)) {
      return a(paramInt1);
    }
    if ((paramView != null) && ((paramView.getTag() instanceof BuddyListTroop.TroopDisChildTag)))
    {
      paramViewGroup = (BuddyListTroop.TroopDisChildTag)paramView.getTag();
    }
    else
    {
      paramView = LayoutInflater.from(this.l).inflate(2131629574, null);
      paramView.setMinimumHeight(this.m);
      paramViewGroup = new BuddyListTroop.TroopDisChildTag();
      paramViewGroup.leftView = paramView;
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
    if (localObject != null) {
      a(((GuildContactsDataItem)localObject).a, paramViewGroup, paramInt1, paramInt2, paramView);
    }
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (paramInt >= 0)
    {
      Object localObject = this.j;
      if (paramInt < localObject.length)
      {
        int i1 = localObject[paramInt].size();
        if (paramInt == 0)
        {
          i1 = this.j[paramInt].size();
          this.b[paramInt] = 3;
        }
        int i2 = i1;
        if (this.b[paramInt] == 1)
        {
          localObject = this.c;
          i2 = i1;
          if (localObject[paramInt] < i1) {
            i2 = localObject[paramInt] + 1;
          }
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getChildrenCount count:");
          ((StringBuilder)localObject).append(i2);
          ((StringBuilder)localObject).append("  groupPosition:");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("ContactsGuildAdapter", 2, ((StringBuilder)localObject).toString());
        }
        return i2;
      }
    }
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    List[] arrayOfList = this.j;
    if (paramInt < arrayOfList.length) {
      return arrayOfList[paramInt];
    }
    return null;
  }
  
  public int getGroupCount()
  {
    return 4;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.l).inflate(2131624548, paramViewGroup, false);
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
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.n));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.k, false))
    {
      paramViewGroup.f.setTextColor(-5196865);
    }
    else
    {
      ColorStateList localColorStateList = this.l.getResources().getColorStateList(2131168122);
      paramViewGroup.f.setTextColor(localColorStateList);
    }
    a(paramViewGroup, paramInt, paramBoolean);
    paramView.setOnClickListener(this);
    return paramView;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 255) {
      notifyDataSetChanged();
    }
    return false;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean needHideBackgroundGroup()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof GroupTag)) {
      a((GroupTag)localObject);
    } else if ((localObject instanceof BuddyListTroop.TroopDisChildTag)) {
      a((IGProGuildInfo)((BuddyListTroop.TroopDisChildTag)localObject).c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onGroupClick(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof GroupTag)) {
      b((GroupTag)paramExpandableListView);
    } else if ((paramExpandableListView instanceof BuddyListTroop.TroopDisChildTag)) {
      a((IGProGuildInfo)((BuddyListTroop.TroopDisChildTag)paramExpandableListView).c);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.guild.ContactsGuildAdapter
 * JD-Core Version:    0.7.0.1
 */