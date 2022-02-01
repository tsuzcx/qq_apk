package com.tencent.mobileqq.activity.contacts.friend;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.contacts.base.BuddyItemBuilder;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.BuddyListCallback;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag;
import com.tencent.mobileqq.adapter.SwipFacePreloadExpandableAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.troop.adapter.contact.GroupTag;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.QQStoryCoverImageViewHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class BuddyListAdapter
  extends SwipFacePreloadExpandableAdapter
  implements View.OnClickListener, View.OnLongClickListener, BuddyListItem.BuddyListCallback, SwipPinnedHeaderExpandableListView.SwipListListener
{
  private static final BuddyListAdapter.MyComparator o = new BuddyListAdapter.MyComparator(null);
  final BaseActivity a;
  public int b;
  private final QQAppInterface c;
  private ArrayList<Object> d = new ArrayList();
  private SparseArray<List<BuddyListItem>> e = new SparseArray();
  private SparseIntArray f = new SparseIntArray();
  private final StatusManager g;
  private final FriendsManager h;
  private int i;
  private AbsListView.OnScrollListener j;
  private final View.OnClickListener k;
  private boolean l;
  private IPhoneContactService m;
  private final boolean n;
  private final int p;
  private boolean q;
  private BuddyListAdapter.ItemClickListener s;
  private BuddyListAdapter.ItemLongClickListener t;
  private SimpleTextView u;
  private SimpleTextView v;
  private int w;
  private final View.OnClickListener x;
  
  public BuddyListAdapter(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, SwipPinnedHeaderExpandableListView paramSwipPinnedHeaderExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramBaseActivity, paramQQAppInterface, paramSwipPinnedHeaderExpandableListView);
    boolean bool2 = false;
    this.i = 0;
    this.l = true;
    this.m = null;
    this.q = true;
    this.w = -1;
    this.x = new BuddyListAdapter.3(this);
    this.s = new BuddyListAdapter.ItemClickListener(this);
    this.t = new BuddyListAdapter.ItemLongClickListener(this);
    this.a = paramBaseActivity;
    this.c = paramQQAppInterface;
    this.g = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.h = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.m = ((IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, ""));
    this.k = paramOnClickListener;
    this.p = ((int)DisplayUtils.a(this.a, 12.0F));
    notifyDataSetChanged();
    boolean bool1 = bool2;
    if (Build.MODEL.equals("Lenovo A366t"))
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT == 10) {
        bool1 = true;
      }
    }
    this.n = bool1;
  }
  
  private void a(GroupTag paramGroupTag, Groups paramGroups, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramGroupTag == null) {
      return;
    }
    boolean bool2 = paramGroupTag.b.isChecked();
    boolean bool1 = true;
    if (!bool2) {
      paramGroupTag.b.setChecked(true);
    }
    Object localObject2 = paramGroupTag.g;
    Object localObject1 = localObject2;
    if (AppSetting.e)
    {
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder(24);
      }
      else
      {
        ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
        localObject1 = localObject2;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramGroups.group_name);
      ((StringBuilder)localObject2).append(" 分组");
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
    }
    paramGroupTag.a = paramInt1;
    paramGroupTag.d.setText(paramGroups.group_name);
    paramGroupTag.e.setVisibility(8);
    paramGroupTag.c.setVisibility(8);
    paramGroupTag.b.setVisibility(0);
    int i1 = this.f.get(paramGroups.group_id);
    paramInt1 = getChildrenCount(paramInt1);
    Object localObject3;
    if (paramGroups.group_id == 1005)
    {
      localObject2 = paramGroupTag.f;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramInt1);
      ((StringBuilder)localObject3).append("");
      ((SimpleTextView)localObject2).setText(((StringBuilder)localObject3).toString());
      if (AppSetting.e)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("共");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append("个常用群聊");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      localObject3 = paramGroupTag.f;
      if (this.n) {
        localObject2 = "%d / %d";
      } else {
        localObject2 = "%d/%d";
      }
      ((SimpleTextView)localObject3).setText(String.format((String)localObject2, new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt1) }));
      if (AppSetting.e)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("在线");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append("人，共");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append("人");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      }
    }
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      if (this.r.isGroupExpanded(paramGroupTag.a)) {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      }
    }
    localObject2 = paramGroupTag.b;
    if (paramInt1 != 2) {
      bool1 = false;
    }
    ((CheckBox)localObject2).setChecked(bool1);
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
    if ((paramGroups.group_id == 1002) && (this.m.getSelfBindState() == this.m.getSelfBindState()))
    {
      if (paramBoolean)
      {
        this.v = paramGroupTag.f;
        return;
      }
      this.u = paramGroupTag.f;
      return;
    }
    if (this.v == paramGroupTag.f) {
      this.v = null;
    }
    if (this.u == paramGroupTag.f) {
      this.u = null;
    }
  }
  
  private void a(ArrayList<Object> paramArrayList, SparseArray<List<BuddyListItem>> paramSparseArray, SparseIntArray paramSparseIntArray)
  {
    Object localObject4 = paramArrayList;
    Groups localGroups1 = new Groups();
    localGroups1.group_id = 1004;
    localGroups1.group_name = this.a.getString(2131914364);
    localGroups1.group_friend_count = 1;
    localGroups1.seqid = 0;
    ((ArrayList)localObject4).add(localGroups1);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3 = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject3 != null)
    {
      localObject1 = ((FriendsManager)localObject3).i();
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("BuddyListAdapter", 2, "FriendManager is null");
      }
      localObject1 = null;
    }
    Object localObject5;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((List)localObject1).size() != 0) {}
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("group list is ");
        if (localObject1 == null) {
          localObject2 = "null";
        } else {
          localObject2 = "empty";
        }
        ((StringBuilder)localObject5).append((String)localObject2);
        QLog.d("BuddyListAdapter", 2, ((StringBuilder)localObject5).toString());
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
      ((ArrayList)localObject4).remove(localGroups1);
    }
    Object localObject1 = ((List)localObject2).iterator();
    int i1 = 0;
    Object localObject2 = localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      Groups localGroups2 = (Groups)((Iterator)localObject1).next();
      paramArrayList.add(localGroups2);
      localObject3 = ((FriendsManager)localObject2).t(String.valueOf(localGroups2.group_id));
      if (localObject3 == null) {
        localObject4 = new ArrayList();
      } else {
        localObject4 = new ArrayList((Collection)localObject3);
      }
      ArrayList localArrayList2 = new ArrayList(((List)localObject4).size());
      localObject3 = ((List)localObject4).iterator();
      int i3 = 0;
      localObject5 = null;
      int i2 = i1;
      i1 = i3;
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject6 = (Entity)((Iterator)localObject3).next();
        Friends localFriends = (Friends)localObject6;
        int i4 = OnlineStatusUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
        Object localObject7 = this.h.y(localFriends.uin);
        if ((localObject7 != null) && (((SpecialCareInfo)localObject7).globalSwitch != 0))
        {
          localArrayList1.add(BuddyItemBuilder.a(4, (Entity)localObject6, this.c, this.a));
          i3 = i2;
          if (i4 != 0)
          {
            i3 = i2;
            if (i4 != 6) {
              i3 = i2 + 1;
            }
          }
        }
        else
        {
          i3 = i2;
        }
        if (localFriends.gathtertype == 1)
        {
          i2 = i3;
        }
        else
        {
          i2 = i1;
          if (i4 != 0)
          {
            i2 = i1;
            if (i4 != 6) {
              i2 = i1 + 1;
            }
          }
          localObject6 = BuddyItemBuilder.a(0, (Entity)localObject6, this.c, this.a);
          ((BuddyListItem)localObject6).a(this);
          try
          {
            localObject7 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            boolean bool = localFriends.uin.equals(localObject7);
            if (bool) {
              localObject5 = localObject6;
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            localArrayList2.add(localObject6);
          }
          i1 = i2;
          i2 = i3;
        }
      }
      a(localArrayList2);
      if (localObject5 != null) {
        localArrayList2.add(0, localObject5);
      }
      paramSparseIntArray.put(localGroups2.group_id, i1);
      paramSparseArray.put(localGroups2.group_id, localArrayList2);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("groupId: ");
        ((StringBuilder)localObject3).append(localGroups2.group_id);
        ((StringBuilder)localObject3).append(" num: ");
        ((StringBuilder)localObject3).append(((List)localObject4).size());
        QLog.d("BuddyListAdapter", 2, ((StringBuilder)localObject3).toString());
      }
      i1 = i2;
    }
    a(localArrayList1);
    paramSparseIntArray.put(1004, i1);
    paramSparseArray.put(1004, localArrayList1);
    localGroups1.group_friend_count = localArrayList1.size();
  }
  
  private void a(List<BuddyListItem> paramList)
  {
    try
    {
      Collections.sort(paramList, o);
      return;
    }
    catch (Exception paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BuddyListAdapter", 2, "", paramList);
      }
    }
  }
  
  private void d()
  {
    int i2 = this.r.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = this.r.getChildAt(i1).getTag();
      if ((localObject != null) && ((localObject instanceof BuddyListFriends.BuddyChildTag)))
      {
        localObject = (BuddyListFriends.BuddyChildTag)localObject;
        if ((TextUtils.isEmpty(((BuddyListFriends.BuddyChildTag)localObject).b.getText().toString())) && ((((BuddyListFriends.BuddyChildTag)localObject).c instanceof Friends))) {
          a((Friends)((BuddyListFriends.BuddyChildTag)localObject).c, (BuddyListFriends.BuddyChildTag)localObject);
        }
      }
      i1 += 1;
    }
  }
  
  private void e()
  {
    Object localObject1 = this.c.getApp();
    Object localObject2 = this.c.getAccount();
    int i3 = 0;
    localObject2 = ((BaseApplication)localObject1).getSharedPreferences((String)localObject2, 0).getString("700_sp_key_last_expanded", "700_sp_key_last_expanded");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("readExpand=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("BuddyListAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new HashSet();
    int i1;
    int i2;
    int i4;
    if (((String)localObject2).equalsIgnoreCase("700_sp_key_last_expanded"))
    {
      i1 = 0;
      while (i1 < this.d.size())
      {
        if (getGroupType(i1) == 0)
        {
          localObject2 = (Groups)this.d.get(i1);
          if (((Groups)localObject2).group_friend_count > 0)
          {
            ((Set)localObject1).add(Integer.valueOf(((Groups)localObject2).group_id));
            break;
          }
        }
        i1 += 1;
      }
      i2 = i3;
      if (((Set)localObject1).size() == 0)
      {
        this.q = true;
        i2 = i3;
      }
    }
    else
    {
      i2 = i3;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = ((String)localObject2).split("_");
        i4 = localObject2.length;
        i1 = 0;
      }
    }
    for (;;)
    {
      i2 = i3;
      String str;
      if (i1 < i4) {
        str = localObject2[i1];
      }
      try
      {
        ((Set)localObject1).add(Integer.valueOf(Integer.parseInt(str)));
        label252:
        i1 += 1;
        continue;
        while (i2 < this.d.size())
        {
          if ((getGroupType(i2) == 0) && (((Set)localObject1).contains(Integer.valueOf(((Groups)this.d.get(i2)).group_id)))) {
            this.r.expandGroup(i2);
          }
          i2 += 1;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label252;
      }
    }
  }
  
  private void f()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i2 = getGroupCount();
    if (i2 <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BuddyListAdapter", 2, "no data. don't save group");
      }
      return;
    }
    int i1 = 0;
    Object localObject;
    while (i1 < i2)
    {
      if (getGroupType(i1) == 0)
      {
        localObject = (Groups)getGroup(i1);
        if (this.r.isGroupExpanded(i1))
        {
          localStringBuffer.append(((Groups)localObject).group_id);
          localStringBuffer.append("_");
        }
      }
      i1 += 1;
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveExpanded=");
      ((StringBuilder)localObject).append(localStringBuffer.toString());
      QLog.d("BuddyListAdapter", 2, ((StringBuilder)localObject).toString());
    }
    this.c.getApp().getSharedPreferences(this.c.getAccount(), 0).edit().putString("700_sp_key_last_expanded", localStringBuffer.toString()).commit();
  }
  
  String a(Friends paramFriends, BuddyListFriends.BuddyChildTag paramBuddyChildTag)
  {
    if (this.g != null)
    {
      Object localObject = this.h;
      if (localObject == null) {
        return null;
      }
      ExtensionInfo localExtensionInfo = ((FriendsManager)localObject).x(paramFriends.uin);
      int i4 = 0;
      int i1;
      if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (localExtensionInfo != null)
      {
        boolean bool;
        if (this.i != 0) {
          bool = true;
        } else {
          bool = false;
        }
        localObject = ExtensionRichStatus.a(localExtensionInfo, bool);
      }
      else
      {
        localObject = null;
      }
      int i2;
      if ((localObject != null) && (localObject != RichStatus.getEmptyStatus()) && (!((RichStatus)localObject).isEmpty())) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      int i3;
      if ((i2 != 0) && (!TextUtils.isEmpty(((RichStatus)localObject).actionText))) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      if ((i1 != 0) && ((localExtensionInfo.feedTime > localExtensionInfo.richTime) || (i2 == 0)))
      {
        paramFriends = new String(localExtensionInfo.feedContent);
        paramBuddyChildTag.b.setCompoundDrawables(null, null);
        if (localExtensionInfo.feedType == 2)
        {
          paramBuddyChildTag.e.setVisibility(0);
          if (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl)) {
            QQStoryCoverImageViewHelper.a(paramBuddyChildTag.e, localExtensionInfo.feedPhotoUrl, this.a.getResources().getDrawable(2130852411));
          } else {
            paramBuddyChildTag.e.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852411));
          }
          paramBuddyChildTag.f.setVisibility(8);
          paramBuddyChildTag.g.setVisibility(8);
        }
        else
        {
          paramBuddyChildTag.f.setVisibility(0);
          localObject = paramBuddyChildTag.f;
          if (localExtensionInfo.feedType == 1) {
            i1 = 2130851613;
          } else {
            i1 = 2130851611;
          }
          ((ImageView)localObject).setBackgroundResource(i1);
          localObject = paramBuddyChildTag.g;
          if (localExtensionInfo.feedHasPhoto) {
            i1 = i4;
          } else {
            i1 = 8;
          }
          ((URLImageView)localObject).setVisibility(i1);
          paramBuddyChildTag.e.setVisibility(8);
          paramBuddyChildTag.e.setImageDrawable(null);
        }
        localObject = null;
      }
      else
      {
        if (i3 != 0)
        {
          ((RichStatus)localObject).enableSummaryCached = paramFriends.isFriend();
          paramFriends = this.g.a(((RichStatus)localObject).actionId, 200);
          paramFriends = new BitmapDrawable(this.a.getResources(), paramFriends);
          i1 = this.p;
          paramFriends.setBounds(0, 0, Math.round(paramFriends.getIntrinsicWidth() * 1.0F / paramFriends.getIntrinsicHeight() * i1), i1);
          paramBuddyChildTag.b.setCompoundDrawables(paramFriends, null);
        }
        else if (i2 == 0)
        {
          localObject = RichStatus.getEmptyStatus();
          paramBuddyChildTag.b.setCompoundDrawables(null, null);
        }
        paramFriends = ((RichStatus)localObject).getActionAndData();
        String str = ((RichStatus)localObject).getPlainText();
        paramBuddyChildTag.g.setVisibility(8);
        paramBuddyChildTag.f.setVisibility(8);
        paramBuddyChildTag.e.setVisibility(8);
        paramBuddyChildTag.e.setImageDrawable(null);
        localObject = paramFriends;
        paramFriends = str;
      }
      if (localExtensionInfo == null)
      {
        paramBuddyChildTag.g.setVisibility(8);
        paramBuddyChildTag.f.setVisibility(8);
      }
      paramBuddyChildTag.b.setExtendText((String)localObject, 1);
      paramBuddyChildTag.b.setText(paramFriends);
      return paramFriends;
    }
    return null;
  }
  
  public void a()
  {
    super.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void b()
  {
    f();
    OldMutualMarkLogicHelper.a(this.c);
    super.b();
  }
  
  public void c()
  {
    f();
    OldMutualMarkLogicHelper.a(this.c);
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    Groups localGroups = (Groups)getGroup(paramInt);
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
    a(paramView, localGroups, paramInt, true, 0);
    paramView.d.setTypeface(Typeface.SANS_SERIF);
    if (ThemeUtil.isNowThemeIsDefaultCache(this.c, false))
    {
      paramView.f.setTextColor(-5196865);
      return;
    }
    Object localObject = this.a.getResources().getColorStateList(2131168122);
    paramView.f.setTextColor((ColorStateList)localObject);
  }
  
  public int g()
  {
    return this.i;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    if (getGroupType(paramInt1) == 0)
    {
      Groups localGroups = (Groups)this.d.get(paramInt1);
      return ((List)this.e.get(localGroups.group_id)).get(paramInt2);
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    long l1;
    if ((localObject instanceof Friends))
    {
      localObject = (Friends)localObject;
      try
      {
        l1 = Long.parseLong(((Friends)localObject).uin);
        return l1;
      }
      catch (Throwable localThrowable1)
      {
        if (!QLog.isColorLevel()) {
          break label119;
        }
      }
      QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(localThrowable1));
      return 0L;
    }
    else
    {
      if ((localThrowable1 instanceof PublicAccountInfo)) {
        return ((PublicAccountInfo)localThrowable1).uin;
      }
      if ((localThrowable1 instanceof PhoneContact))
      {
        PhoneContact localPhoneContact = (PhoneContact)localThrowable1;
        try
        {
          l1 = Long.parseLong(localPhoneContact.mobileNo);
          return l1;
        }
        catch (Throwable localThrowable2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(localThrowable2));
          }
        }
      }
    }
    label119:
    return 0L;
  }
  
  public int getChildType(int paramInt1, int paramInt2)
  {
    if (getGroupType(paramInt1) == 0)
    {
      if (((Groups)this.d.get(paramInt1)).group_id == 1002) {
        return 1;
      }
      return 0;
    }
    return 99;
  }
  
  public int getChildTypeCount()
  {
    return 6;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    TraceUtils.traceBegin("getChildView");
    BuddyListItem localBuddyListItem = (BuddyListItem)getChild(paramInt1, paramInt2);
    if (localBuddyListItem == null) {
      paramView = null;
    } else {
      paramView = localBuddyListItem.a(paramInt1, paramInt2, paramView, paramViewGroup, this.k);
    }
    if (paramView != null)
    {
      a((BuddyListItem.ViewTag)paramView.getTag(), null);
      paramViewGroup = this.k;
      if (paramViewGroup != null) {
        paramView.setOnClickListener(paramViewGroup);
      }
      paramView.setOnLongClickListener(this.t);
    }
    TraceUtils.traceEnd();
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (getGroupType(paramInt) == 1) {
      return 0;
    }
    paramInt = ((Groups)this.d.get(paramInt)).group_id;
    List localList = (List)this.e.get(paramInt);
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.d.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.d.size();
  }
  
  public long getGroupId(int paramInt)
  {
    if (getGroupType(paramInt) == 0) {
      return ((Groups)getGroup(paramInt)).group_id;
    }
    return 1000L;
  }
  
  public int getGroupType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.d.size()))
    {
      if ((this.d.get(paramInt) instanceof String)) {
        return 1;
      }
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGroupType illegal, groupPosition =");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.d.size());
    QLog.e("BuddyListAdapter", 1, localStringBuilder.toString());
    return 1;
  }
  
  public int getGroupTypeCount()
  {
    return 2;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (getGroupType(paramInt) == 1)
    {
      if (paramView == null)
      {
        paramViewGroup = LayoutInflater.from(this.a).inflate(2131624545, paramViewGroup, false);
        paramView = (SingleLineTextView)paramViewGroup.findViewById(2131448393);
        paramView.setDefaultTextColor(-8355712);
        paramViewGroup.setTag(paramView);
      }
      else
      {
        localObject = (SingleLineTextView)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject;
      }
      localObject = (String)getGroup(paramInt);
      paramView.setText("");
      return paramViewGroup;
    }
    Object localObject = (Groups)getGroup(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2131624548, paramViewGroup, false);
      paramViewGroup = new GroupTag();
      paramViewGroup.d = ((SingleLineTextView)paramView.findViewById(2131434435));
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
    if (ThemeUtil.isNowThemeIsDefaultCache(this.c, false))
    {
      paramViewGroup.f.setTextColor(-5196865);
    }
    else
    {
      ColorStateList localColorStateList = this.a.getResources().getColorStateList(2131168122);
      paramViewGroup.f.setTextColor(localColorStateList);
    }
    paramView.setOnClickListener(this.s);
    paramView.setOnLongClickListener(this.t);
    int i1;
    if (paramBoolean) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    a(paramViewGroup, (Groups)localObject, paramInt, false, i1);
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
    return true;
  }
  
  public boolean needHideBackgroundGroup()
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "notifyDataSetChanged");
    }
    ThreadManager.postImmediately(new BuddyListAdapter.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    GroupTag localGroupTag = (GroupTag)paramView.getTag();
    if (this.r.isGroupExpanded(localGroupTag.a))
    {
      this.r.collapseGroup(localGroupTag.a);
    }
    else
    {
      this.r.expandGroup(localGroupTag.a);
      ((QzoneContactsFeedManager)this.c.getManager(QQManagerFactory.QZONE_CONTACTS_FEED_MANAGER)).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool1 = this.l;
    boolean bool3 = true;
    boolean bool2 = false;
    if (bool1)
    {
      Object localObject1 = paramView.getTag();
      if (localObject1 != null)
      {
        if ((localObject1 instanceof GroupTag))
        {
          localObject1 = new QQCustomMenu();
          ((QQCustomMenu)localObject1).a(0, this.a.getResources().getString(2131890205));
          BubbleContextMenu.a(paramView, (QQCustomMenu)localObject1, this.x, null);
          return true;
        }
        bool1 = bool3;
        if (!(localObject1 instanceof BuddyListItem.ViewTag)) {
          break label257;
        }
        Object localObject2 = ((BuddyListItem.ViewTag)localObject1).c;
        bool1 = bool3;
        if (localObject2 == null) {
          break label257;
        }
        bool1 = bool3;
        if (!(localObject2 instanceof Friends)) {
          break label257;
        }
        paramView = (ActionSheet)ActionSheetHelper.b(this.a, null);
        localObject1 = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
        localObject2 = (Friends)localObject2;
        localObject1 = ((FriendsManager)localObject1).y(((Friends)localObject2).uin);
        if (this.c.getCurrentUin().equals(((Friends)localObject2).uin)) {
          return false;
        }
        bool1 = bool2;
        if (localObject1 != null) {
          if (((SpecialCareInfo)localObject1).globalSwitch == 0) {
            bool1 = bool2;
          } else {
            bool1 = true;
          }
        }
        int i1;
        if (bool1) {
          i1 = 2131888035;
        } else {
          i1 = 2131888036;
        }
        paramView.addButton(i1);
        paramView.addCancelButton(2131887648);
        paramView.setOnButtonClickListener(new BuddyListAdapter.2(this, bool1, (Friends)localObject2, paramView));
      }
    }
    try
    {
      paramView.show();
      return true;
    }
    catch (Exception paramView) {}
    bool1 = false;
    label257:
    return bool1;
    return true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    AbsListView.OnScrollListener localOnScrollListener = this.j;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.i = paramInt;
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      d();
      DropFrameMonitor.b().a("list_g_contacts", false);
    }
    else
    {
      DropFrameMonitor.b().a("list_g_contacts");
    }
    AbsListView.OnScrollListener localOnScrollListener = this.j;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
  }
  
  public boolean supportSwip(View paramView)
  {
    if (!this.l) {
      return false;
    }
    if ((paramView.getTag() instanceof BuddyListFriends.BuddyChildTag))
    {
      paramView = (BuddyListFriends.BuddyChildTag)paramView.getTag();
      if ((paramView.c instanceof Friends))
      {
        paramView = (Friends)paramView.c;
        if ((paramView.uin.equals(this.c.getCurrentAccountUin())) || (Utils.c(paramView.uin))) {
          return false;
        }
      }
    }
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
    this.b = i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter
 * JD-Core Version:    0.7.0.1
 */