package com.tencent.mobileqq.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.util.ImageWorker;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public class ForwardSelectionFriendListAdapter
  extends BaseFacePreloadExpandableListAdapter
  implements View.OnClickListener
{
  public static int i = 1003;
  protected List<Entity> a;
  protected HashMap<Integer, ArrayList<Entity>> b = new HashMap();
  protected HashMap<Integer, String> c = new HashMap();
  protected QQAppInterface d;
  protected Context e;
  protected ImageWorker f;
  protected float g;
  protected FriendsManager h;
  private boolean j;
  private ForwardSelectionFriendListAdapter.IForwardFriendListAdapterCallback k;
  private View.OnClickListener l = new ForwardSelectionFriendListAdapter.1(this);
  
  public ForwardSelectionFriendListAdapter(Context paramContext, ExpandableListView paramExpandableListView, QQAppInterface paramQQAppInterface, List<Entity> paramList, ForwardSelectionFriendListAdapter.IForwardFriendListAdapterCallback paramIForwardFriendListAdapterCallback, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.d = paramQQAppInterface;
    this.h = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.e = paramContext;
    this.k = paramIForwardFriendListAdapterCallback;
    this.j = paramBoolean;
    this.g = paramContext.getResources().getDisplayMetrics().density;
    this.f = new ImageWorker(paramContext);
    paramContext = this.f;
    float f1 = this.g;
    paramContext.a((int)(f1 * 100.0F), (int)(f1 * 100.0F));
    a(paramList, false);
    if (this.j) {
      b();
    }
  }
  
  public static int a()
  {
    return i;
  }
  
  private ArrayList<Entity> a(List<RecentUser> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if ((localRecentUser != null) && (!Utils.b(localRecentUser.uin)) && (localRecentUser.getType() == 0) && (!Utils.d(localRecentUser.uin)))
        {
          FriendsManager localFriendsManager = this.h;
          if ((localFriendsManager != null) && (localFriendsManager.n(localRecentUser.uin))) {
            localArrayList.add(this.h.m(localRecentUser.uin));
          }
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public static void a(int paramInt)
  {
    i = paramInt;
  }
  
  private void b()
  {
    Object localObject1 = (IPhoneContactService)this.d.getRuntimeService(IPhoneContactService.class, "");
    int m = ((IPhoneContactService)localObject1).getSelfBindState();
    if ((((IPhoneContactService)localObject1).isBindContactOk()) || (m == 8))
    {
      Object localObject2 = ((IPhoneContactService)localObject1).getBindNonfriendList();
      if (localObject2 != null)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll((Collection)localObject2);
        if (!((ArrayList)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1002;
          ((Groups)localObject2).group_name = this.e.getString(2131892489);
          ((Groups)localObject2).group_friend_count = 1;
          ((Groups)localObject2).seqid = 0;
          this.a.add(localObject2);
          this.b.put(Integer.valueOf(((Groups)localObject2).group_id), localObject1);
        }
      }
    }
  }
  
  private ArrayList<Entity> d()
  {
    return a(this.d.getProxyManager().g().a(true));
  }
  
  public void a(List<Entity> paramList, boolean paramBoolean)
  {
    this.a = paramList;
    paramList = this.a.iterator();
    Groups localGroups;
    ArrayList localArrayList;
    Object localObject1;
    if (paramList.hasNext())
    {
      localGroups = (Groups)paramList.next();
      int n = localGroups.group_id;
      int i1 = a();
      int m = 0;
      if ((n == i1) && (!this.b.containsKey(Integer.valueOf(a()))))
      {
        localArrayList = d();
        this.b.put(Integer.valueOf(a()), localArrayList);
        if (localArrayList != null) {
          m = localArrayList.size();
        }
        localGroups.group_friend_count = m;
      }
      else
      {
        localObject1 = ((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).t(String.valueOf(localGroups.group_id));
        localArrayList = new ArrayList();
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
        {
          localArrayList.addAll((Collection)localObject1);
          localObject1 = localArrayList.iterator();
          label183:
          if (!((Iterator)localObject1).hasNext()) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = (Friends)((Iterator)localObject1).next();
        if (Utils.c(((Friends)localObject2).uin))
        {
          ((Iterator)localObject1).remove();
          break label183;
        }
        if ((!TextUtils.equals(((Friends)localObject2).uin, this.d.getCurrentAccountUin())) || (this.e == null) || (!(this.e instanceof ForwardFriendListActivity))) {
          break label183;
        }
        localObject2 = ((ForwardFriendListActivity)this.e).getIntent();
        if (localObject2 == null) {
          break label368;
        }
        bool = ((Intent)localObject2).getBooleanExtra("choose_friend_isForConfess", false);
        if (!bool) {
          break label183;
        }
        ((Iterator)localObject1).remove();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      break label183;
      this.b.put(Integer.valueOf(localGroups.group_id), localArrayList);
      this.c.put(Integer.valueOf(localGroups.group_id), localGroups.group_name);
      break;
      if (paramBoolean) {
        super.notifyDataSetChanged();
      }
      return;
      label368:
      boolean bool = false;
    }
  }
  
  public List<Entity> b(int paramInt)
  {
    paramInt = ((Groups)getGroup(paramInt)).group_id;
    return (List)this.b.get(Integer.valueOf(paramInt));
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    Object localObject2 = (ForwardSelectionFriendListAdapter.GroupViewTag)paramView.getTag();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ForwardSelectionFriendListAdapter.GroupViewTag();
      ((ForwardSelectionFriendListAdapter.GroupViewTag)localObject1).a = ((TextView)paramView.findViewById(2131434435));
      ((ForwardSelectionFriendListAdapter.GroupViewTag)localObject1).b = ((TextView)paramView.findViewById(2131431254));
      paramView.findViewById(2131436369).setVisibility(0);
      paramView.setTag(localObject1);
    }
    localObject2 = (Groups)getGroup(paramInt);
    ((ForwardSelectionFriendListAdapter.GroupViewTag)localObject1).a.setText(((Groups)localObject2).group_name);
    ((ForwardSelectionFriendListAdapter.GroupViewTag)localObject1).b.setText(String.valueOf(((Groups)localObject2).group_friend_count));
    ((CheckBox)paramView.findViewById(2131436369)).setChecked(this.n.isGroupExpanded(paramInt));
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return b(paramInt1).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    ForwardSelectionFriendListAdapter.ViewTag localViewTag;
    if (paramView == null)
    {
      paramViewGroup = new ForwardRecentItemView(this.e);
      localViewTag = new ForwardSelectionFriendListAdapter.ViewTag();
      paramViewGroup.setTag(localViewTag);
    }
    else
    {
      paramViewGroup = (ForwardRecentItemView)paramView;
      localViewTag = (ForwardSelectionFriendListAdapter.ViewTag)paramViewGroup.getTag();
    }
    Object localObject2 = getChild(paramInt1, paramInt2);
    String str;
    if ((localObject2 instanceof PhoneContact))
    {
      paramView = (PhoneContact)localObject2;
      str = paramView.name;
      localObject1 = paramView.mobileCode;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramView = paramView.mobileNo;
      }
      else
      {
        paramInt1 = ((String)localObject1).indexOf("|");
        paramView = (View)localObject1;
        if (paramInt1 > -1) {
          paramView = ((String)localObject1).substring(0, paramInt1);
        }
      }
      localViewTag.z = 11;
      paramInt1 = 1006;
    }
    else
    {
      paramView = (Friends)localObject2;
      str = ContactUtils.a(paramView);
      paramView = paramView.uin;
      localViewTag.z = 1;
      paramInt1 = 0;
    }
    localViewTag.A = paramViewGroup.d;
    localViewTag.y = paramView;
    localViewTag.a = localObject2;
    paramBoolean = this.k.a(paramView, paramInt1);
    boolean bool = RobotUtils.a(this.d, paramView);
    localObject2 = paramViewGroup.k;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ResultRecord();
    }
    ((ResultRecord)localObject1).init(paramView, str, paramInt1, "", "");
    paramViewGroup.a(str, "", null, (ResultRecord)localObject1, this.j, paramBoolean, bool);
    a(localViewTag, null);
    paramViewGroup.setOnClickListener(this.l);
    if (AppSetting.e) {
      paramViewGroup.setContentDescription(str);
    }
    return paramViewGroup;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (b(paramInt) == null) {
      return 0;
    }
    return b(paramInt).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.a.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.e).inflate(2131624547, paramViewGroup, false);
      paramView = new ForwardSelectionFriendListAdapter.GroupViewTag();
      paramView.a = ((TextView)paramViewGroup.findViewById(2131434435));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131431254));
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(this);
    }
    else
    {
      localObject = (ForwardSelectionFriendListAdapter.GroupViewTag)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    Object localObject = (Groups)getGroup(paramInt);
    paramView.a.setText(((Groups)localObject).group_name);
    paramView.b.setText(String.valueOf(getChildrenCount(paramInt)));
    paramView.c = paramInt;
    if (AppSetting.e) {
      paramViewGroup.setContentDescription(((Groups)localObject).group_name);
    }
    return paramViewGroup;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131624547;
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
    return this.a == null;
  }
  
  public void onClick(View paramView)
  {
    ForwardSelectionFriendListAdapter.GroupViewTag localGroupViewTag = (ForwardSelectionFriendListAdapter.GroupViewTag)paramView.getTag();
    if (this.n.isGroupExpanded(localGroupViewTag.c)) {
      this.n.collapseGroup(localGroupViewTag.c);
    } else {
      this.n.expandGroup(localGroupViewTag.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter
 * JD-Core Version:    0.7.0.1
 */