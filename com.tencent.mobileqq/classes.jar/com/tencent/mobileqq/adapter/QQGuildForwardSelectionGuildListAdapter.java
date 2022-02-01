package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQGuildChannelEntry;
import com.tencent.mobileqq.data.QQGuildGuildEntry;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class QQGuildForwardSelectionGuildListAdapter
  extends BaseFacePreloadExpandableListAdapter
  implements View.OnClickListener
{
  private static final List<String> h = new ArrayList();
  private static final Comparator<IGProGuildInfo> j = -..Lambda.QQGuildForwardSelectionGuildListAdapter.DaRRH1wN4LzabM0wOauXRNxOeQg.INSTANCE;
  IGPSService a;
  private final List<Entity> b;
  private final HashMap<String, ArrayList<Entity>> c = new HashMap();
  private final QQAppInterface d;
  private final Context e;
  private boolean f;
  private final QQGuildForwardSelectionGuildListAdapter.IForwardGuildListAdapterCallback g;
  private final String i;
  private final View.OnClickListener k = new QQGuildForwardSelectionGuildListAdapter.1(this);
  
  public QQGuildForwardSelectionGuildListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, QQGuildForwardSelectionGuildListAdapter.IForwardGuildListAdapterCallback paramIForwardGuildListAdapterCallback, boolean paramBoolean, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.d = paramQQAppInterface;
    this.e = paramContext;
    this.g = paramIForwardGuildListAdapterCallback;
    this.f = paramBoolean;
    this.i = paramString;
    this.a = ((IGPSService)this.d.getRuntimeService(IGPSService.class, ""));
    this.b = a(d());
  }
  
  private List<Entity> a(int paramInt)
  {
    QQGuildGuildEntry localQQGuildGuildEntry = (QQGuildGuildEntry)getGroup(paramInt);
    return (List)this.c.get(localQQGuildGuildEntry.guildId);
  }
  
  private List<Entity> a(ICategoryInfo paramICategoryInfo, QQGuildGuildEntry paramQQGuildGuildEntry)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    if (paramQQGuildGuildEntry.userType == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Iterator localIterator = paramICategoryInfo.c().iterator();
    while (localIterator.hasNext())
    {
      IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)localIterator.next();
      if (a(localIGProChannelInfo, bool)) {
        localArrayList.add(QQGuildChannelEntry.ofGuildChannel(paramQQGuildGuildEntry.guildId, localIGProChannelInfo));
      }
    }
    if ((!localArrayList.isEmpty()) && (!TextUtils.isEmpty(paramICategoryInfo.a()))) {
      localArrayList.add(0, QQGuildChannelEntry.ofGuildGroup(paramQQGuildGuildEntry.guildId, paramICategoryInfo));
    }
    return localArrayList;
  }
  
  private List<Entity> a(List<Entity> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Entity localEntity = (Entity)paramList.next();
      QQGuildGuildEntry localQQGuildGuildEntry = (QQGuildGuildEntry)localEntity;
      Object localObject = this.a.getChannelCategoryList(localQQGuildGuildEntry.guildId);
      if (localObject != null)
      {
        ArrayList localArrayList2 = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList2.addAll(a((ICategoryInfo)((Iterator)localObject).next(), localQQGuildGuildEntry));
        }
        if (!localArrayList2.isEmpty())
        {
          localArrayList1.add(localEntity);
          this.c.put(localQQGuildGuildEntry.guildId, localArrayList2);
        }
      }
    }
    return localArrayList1;
  }
  
  private void a(QQGuildForwardSelectionGuildListAdapter.GroupViewHolder paramGroupViewHolder, @NonNull View paramView)
  {
    paramGroupViewHolder.a = ((TextView)paramView.findViewById(2131434435));
    paramGroupViewHolder.b = ((ImageView)paramView.findViewById(2131435219));
    paramGroupViewHolder.c = ((CheckBox)paramView.findViewById(2131436369));
    paramGroupViewHolder.c.setVisibility(0);
    paramView.setTag(paramGroupViewHolder);
  }
  
  private void a(QQGuildForwardSelectionGuildListAdapter.GroupViewHolder paramGroupViewHolder, QQGuildGuildEntry paramQQGuildGuildEntry)
  {
    Drawable localDrawable = ((IQQGuildAvatarApi)this.d.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramQQGuildGuildEntry.avatarUrl, 100, 100, null);
    paramGroupViewHolder.b.setImageDrawable(localDrawable);
    paramGroupViewHolder.a.setText(paramQQGuildGuildEntry.guildName);
  }
  
  private boolean a(IGProChannelInfo paramIGProChannelInfo, boolean paramBoolean)
  {
    if (paramIGProChannelInfo.getType() != 1) {
      return false;
    }
    if (paramIGProChannelInfo.getTalkPermission() == 0) {
      return false;
    }
    return (paramIGProChannelInfo.getTalkPermission() != 2) || (!paramBoolean);
  }
  
  public static void b()
  {
    h.clear();
  }
  
  private List<Entity> d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    if (!TextUtils.isEmpty(this.i)) {
      ((List)localObject).add(this.a.getGuildInfo(this.i));
    } else {
      ((List)localObject).addAll(this.a.getGuildList());
    }
    Collections.sort((List)localObject, j);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(QQGuildGuildEntry.fromGuildInfo((IGProGuildInfo)((Iterator)localObject).next()));
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = h.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int n = 0;
      int m = 0;
      while (m < getGroupCount())
      {
        if (TextUtils.equals(str, ((QQGuildGuildEntry)getGroup(m)).guildId))
        {
          this.n.expandGroup(m);
          m = n;
          break label83;
        }
        m += 1;
      }
      m = 1;
      label83:
      if (m != 0) {
        h.remove(str);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    QQGuildForwardSelectionGuildListAdapter.GroupViewHolder localGroupViewHolder2 = (QQGuildForwardSelectionGuildListAdapter.GroupViewHolder)paramView.getTag();
    QQGuildForwardSelectionGuildListAdapter.GroupViewHolder localGroupViewHolder1 = localGroupViewHolder2;
    if (localGroupViewHolder2 == null)
    {
      localGroupViewHolder1 = new QQGuildForwardSelectionGuildListAdapter.GroupViewHolder();
      a(localGroupViewHolder1, paramView);
    }
    a(localGroupViewHolder1, (QQGuildGuildEntry)getGroup(paramInt));
    ((CheckBox)paramView.findViewById(2131436369)).setChecked(this.n.isGroupExpanded(paramInt));
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return a(paramInt1).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new QQGuildChannelItemView(this.e);
      localObject = new QQGuildForwardSelectionGuildListAdapter.ChildViewHolder();
      paramViewGroup = new ResultRecord();
      paramView.setTag(localObject);
    }
    else
    {
      paramView = (QQGuildChannelItemView)paramView;
      localObject = (QQGuildForwardSelectionGuildListAdapter.ChildViewHolder)paramView.getTag();
      paramViewGroup = paramView.h;
    }
    QQGuildChannelEntry localQQGuildChannelEntry = (QQGuildChannelEntry)getChild(paramInt1, paramInt2);
    ((QQGuildForwardSelectionGuildListAdapter.ChildViewHolder)localObject).z = localQQGuildChannelEntry.type;
    ((QQGuildForwardSelectionGuildListAdapter.ChildViewHolder)localObject).y = localQQGuildChannelEntry.uin;
    ((QQGuildForwardSelectionGuildListAdapter.ChildViewHolder)localObject).a = localQQGuildChannelEntry;
    Object localObject = (QQGuildGuildEntry)getGroup(paramInt1);
    paramViewGroup.init(localQQGuildChannelEntry.uin, localQQGuildChannelEntry.guildId, ((QQGuildGuildEntry)localObject).avatarUrl, localQQGuildChannelEntry.type, localQQGuildChannelEntry.name);
    paramBoolean = this.g.a(localQQGuildChannelEntry.uin, localQQGuildChannelEntry.type);
    paramView.a(paramViewGroup, this.f, paramBoolean);
    if (localQQGuildChannelEntry.type == 10014) {
      paramView.setOnClickListener(this.k);
    } else {
      paramView.setClickable(false);
    }
    if (AppSetting.e) {
      paramView.setContentDescription(localQQGuildChannelEntry.name);
    }
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (a(paramInt) == null) {
      return 0;
    }
    return a(paramInt).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.b.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.e).inflate(2131625032, paramViewGroup, false);
      paramView = new QQGuildForwardSelectionGuildListAdapter.GroupViewHolder();
      a(paramView, paramViewGroup);
      paramViewGroup.setOnClickListener(this);
    }
    else
    {
      localObject = (QQGuildForwardSelectionGuildListAdapter.GroupViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (QQGuildGuildEntry)getGroup(paramInt);
    a(paramView, (QQGuildGuildEntry)localObject);
    paramView.d = paramInt;
    ((CheckBox)paramViewGroup.findViewById(2131436369)).setChecked(this.n.isGroupExpanded(paramInt));
    if (AppSetting.e) {
      paramViewGroup.setContentDescription(((QQGuildGuildEntry)localObject).guildName);
    }
    return paramViewGroup;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131625032;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public boolean isEmpty()
  {
    return this.b.isEmpty();
  }
  
  public void onClick(@NonNull View paramView)
  {
    QQGuildForwardSelectionGuildListAdapter.GroupViewHolder localGroupViewHolder = (QQGuildForwardSelectionGuildListAdapter.GroupViewHolder)paramView.getTag();
    if (this.n.isGroupExpanded(localGroupViewHolder.d))
    {
      this.n.collapseGroup(localGroupViewHolder.d);
      h.remove(((QQGuildGuildEntry)getGroup(localGroupViewHolder.d)).guildId);
    }
    else
    {
      this.n.expandGroup(localGroupViewHolder.d);
      h.add(((QQGuildGuildEntry)getGroup(localGroupViewHolder.d)).guildId);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.QQGuildForwardSelectionGuildListAdapter
 * JD-Core Version:    0.7.0.1
 */