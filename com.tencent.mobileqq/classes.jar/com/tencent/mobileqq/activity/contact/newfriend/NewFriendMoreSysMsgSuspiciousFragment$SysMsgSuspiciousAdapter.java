package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener, AbsListView.OnScrollListener, SwipListView.RightIconMenuListener, SwipListView.SwipListListener
{
  private static final int[] a = { 2131888438 };
  private static final int[] b = { 2130839698 };
  private static final int[] c = { 2131438111 };
  private final Object d;
  private QQAppInterface e;
  private INewFriendService f;
  private Context g;
  private View h;
  private SwipRightMenuBuilder j;
  private List<SysSuspiciousMsg> k = new ArrayList(0);
  private TopGestureLayout l;
  private FriendListHandler m;
  private SparseArray<byte[]> n = new SparseArray(20);
  private int o;
  private int p = -1;
  private int q = -1;
  private FriendListObserver r = new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.1(this);
  private int s = -1;
  
  public NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter(Context paramContext, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView)
  {
    super(paramContext, paramQQAppInterface, paramSwipListView, 1, true);
    this.e = paramQQAppInterface;
    this.g = paramContext;
    this.j = a(this.g);
    this.h = paramView;
    this.d = new Object();
    paramSwipListView.setRightIconMenuListener(this);
    a(this);
    this.f = ((INewFriendService)paramQQAppInterface.getRuntimeService(INewFriendService.class));
    this.m = ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    e();
    this.m.sendReadReportSuspicious();
  }
  
  private SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131299607);
    int i1 = paramContext.getResources().getDimensionPixelSize(2131299608);
    paramContext = c;
    int[] arrayOfInt1 = a;
    int[] arrayOfInt2 = b;
    return new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.3(this, 1, 1, new int[] { i, i1 }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.k.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localSysSuspiciousMsg = (SysSuspiciousMsg)((Iterator)localObject).next();
      if (localSysSuspiciousMsg.uin == paramLong) {
        break label46;
      }
    }
    SysSuspiciousMsg localSysSuspiciousMsg = null;
    label46:
    if (localSysSuspiciousMsg != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("base_uin", String.valueOf(localSysSuspiciousMsg.uin));
      ((Bundle)localObject).putString("base_nick", localSysSuspiciousMsg.nick);
      ((Bundle)localObject).putInt("verfy_type", 0);
      ((Bundle)localObject).putString("verfy_msg", localSysSuspiciousMsg.msg);
      Activity localActivity = (Activity)this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localSysSuspiciousMsg.uin);
      localStringBuilder.append("");
      AutoRemarkActivity.a(localActivity, 0, localStringBuilder.toString(), 0L, (Bundle)localObject);
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.j;
    int i;
    if (localSwipRightMenuBuilder != null) {
      i = localSwipRightMenuBuilder.updateRightMenuView(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);
    } else {
      i = 0;
    }
    int i1 = this.s;
    if (i1 != -1)
    {
      if (paramInt != i1)
      {
        paramView.scrollTo(0, 0);
        return;
      }
      paramView.scrollTo(i, 0);
    }
  }
  
  private void a(NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder paramSuspiciousSysMsgHolder, SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    if (paramSysSuspiciousMsg == null)
    {
      paramSuspiciousSysMsgHolder.a.setVisibility(8);
      paramSuspiciousSysMsgHolder.b.setVisibility(8);
      paramSuspiciousSysMsgHolder.c.setVisibility(8);
      paramSuspiciousSysMsgHolder.d.setVisibility(8);
      paramSuspiciousSysMsgHolder.e.setVisibility(8);
      return;
    }
    paramSuspiciousSysMsgHolder.g = paramSysSuspiciousMsg;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramSysSuspiciousMsg.uin);
    String str = "";
    ((StringBuilder)localObject).append("");
    paramSuspiciousSysMsgHolder.y = ((StringBuilder)localObject).toString();
    paramSuspiciousSysMsgHolder.leftView.setOnClickListener(this);
    paramSuspiciousSysMsgHolder.A.setImageBitmap(a(paramSuspiciousSysMsgHolder.z, paramSuspiciousSysMsgHolder.y));
    paramSuspiciousSysMsgHolder.a.setVisibility(0);
    localObject = paramSuspiciousSysMsgHolder.a;
    if (paramSysSuspiciousMsg.nick != null) {
      str = paramSysSuspiciousMsg.nick;
    }
    ((TextView)localObject).setText(str);
    b(paramSuspiciousSysMsgHolder, paramSysSuspiciousMsg);
    if (paramSysSuspiciousMsg.msg == null)
    {
      paramSuspiciousSysMsgHolder.c.setVisibility(8);
    }
    else
    {
      paramSuspiciousSysMsgHolder.c.setVisibility(0);
      paramSuspiciousSysMsgHolder.c.setText(paramSysSuspiciousMsg.msg);
    }
    if (paramSysSuspiciousMsg.reason == null)
    {
      paramSuspiciousSysMsgHolder.d.setVisibility(8);
    }
    else
    {
      paramSuspiciousSysMsgHolder.d.setVisibility(0);
      paramSuspiciousSysMsgHolder.d.setText(paramSysSuspiciousMsg.reason);
      paramSysSuspiciousMsg = this.g.getResources().getDrawable(2130849705);
      paramSysSuspiciousMsg.setBounds(0, 0, ViewUtils.dip2px(16.0F), ViewUtils.dip2px(16.0F));
      paramSuspiciousSysMsgHolder.d.setCompoundDrawablePadding(ViewUtils.dip2px(5.0F));
      paramSuspiciousSysMsgHolder.d.setCompoundDrawables(paramSysSuspiciousMsg, null, null, null);
    }
    paramSuspiciousSysMsgHolder.e.setVisibility(0);
    paramSuspiciousSysMsgHolder.e.setText(HardCodeUtil.a(2131905342));
    paramSuspiciousSysMsgHolder.e.setOnClickListener(this);
    paramSuspiciousSysMsgHolder.e.setTag(paramSuspiciousSysMsgHolder);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.l == null)
    {
      ViewGroup localViewGroup = (ViewGroup)((Activity)this.g).getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.l = ((TopGestureLayout)localObject);
      }
    }
    Object localObject = this.l;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void b(NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder paramSuspiciousSysMsgHolder, SysSuspiciousMsg paramSysSuspiciousMsg)
  {
    int i = paramSysSuspiciousMsg.sex;
    int i1 = 1;
    if (i != 1)
    {
      if (i != 2)
      {
        paramSuspiciousSysMsgHolder.b.setBackgroundResource(2130847526);
        i = 0;
        i1 = 0;
      }
      else
      {
        i = 2130847523;
        paramSuspiciousSysMsgHolder.b.setBackgroundResource(2130847524);
      }
    }
    else
    {
      i = 2130847525;
      paramSuspiciousSysMsgHolder.b.setBackgroundResource(2130847526);
    }
    TextView localTextView = paramSuspiciousSysMsgHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramSysSuspiciousMsg.age);
    localStringBuilder.append("");
    localTextView.setText(localStringBuilder.toString());
    paramSuspiciousSysMsgHolder.b.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    if (i1 != 0)
    {
      paramSuspiciousSysMsgHolder.b.setVisibility(0);
      return;
    }
    paramSuspiciousSysMsgHolder.b.setVisibility(8);
  }
  
  private void e()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestSuspiciousMsgNextPage ");
      ((StringBuilder)localObject).append(this.q);
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!NetworkUtil.isNetworkAvailable(this.g)) {
      return;
    }
    Object localObject = (byte[])this.n.get(this.q);
    if ((this.q >= 0) && (localObject == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "requestSuspiciousMsgNextPage no cookie");
      }
      return;
    }
    this.q += 1;
    this.m.getSuspiciousMsgList(50, (byte[])localObject, Integer.valueOf(this.q));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "adapter onResume");
    }
    this.e.addObserver(this.r);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "adapter onPause");
    }
    this.e.removeObserver(this.r);
  }
  
  public void c()
  {
    this.e.removeObserver(this.r);
    super.c();
  }
  
  public void d()
  {
    ThreadManager.getSubThreadHandler().post(new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2(this));
  }
  
  public int getCount()
  {
    List localList = this.k;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.k;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.k.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SysSuspiciousMsg localSysSuspiciousMsg = null;
    View localView;
    if (paramView == null)
    {
      paramView = new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder();
      localObject = LayoutInflater.from(this.g).inflate(2131627870, null);
      localView = this.j.createView(this.g, (View)localObject, paramView, -1);
      paramView.A = ((ImageView)localView.findViewById(2131427337));
      paramView.a = ((TextView)localView.findViewById(2131439320));
      paramView.b = ((TextView)localView.findViewById(2131427898));
      paramView.c = ((TextView)localView.findViewById(2131444728));
      paramView.d = ((TextView)localView.findViewById(2131446184));
      paramView.e = ((Button)localView.findViewById(2131444718));
      paramView.f = ((TextView)localView.findViewById(2131444726));
      if ((paramView.A instanceof ThemeImageView)) {
        ((ThemeImageView)paramView.A).setSupportMaskView(true);
      }
      localView.setTag(paramView);
      if (ThemeUtil.isDefaultTheme()) {
        ((View)localObject).setBackgroundResource(2130839577);
      } else {
        ((View)localObject).setBackgroundResource(2130839574);
      }
    }
    else
    {
      localObject = (NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    a(this.g, localView, paramInt, this.d, paramView, this);
    Object localObject = getItem(paramInt);
    if ((localObject instanceof SysSuspiciousMsg)) {
      localSysSuspiciousMsg = (SysSuspiciousMsg)localObject;
    }
    a(paramView, localSysSuspiciousMsg);
    paramView.leftView.setTag(paramView);
    if (paramInt == 0) {
      localView.setPadding(0, ViewUtils.dip2px(12.0F), 0, 0);
    } else {
      localView.setPadding(0, 0, 0, 0);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    int i = paramView.getId();
    Object localObject2;
    if (i != 2131438111)
    {
      if (i != 2131444718)
      {
        if ((i == 2131444905) && ((localObject1 instanceof NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)))
        {
          ReportController.b(this.e, "dc00898", "", "", "0X800A32E", "0X800A32E", 0, 0, "", "", "", "");
          localObject1 = (NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject1;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("msg_extra", ((NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject1).g);
          PublicFragmentActivity.a(this.g, (Intent)localObject2, AddRequestSuspiciousMsgFragment.class);
        }
      }
      else if ((localObject1 instanceof NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder))
      {
        ReportController.b(this.e, "dc00898", "", "", "0X800A32C", "0X800A32C", 1, 0, "", "", "", "");
        localObject1 = (NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject1;
        if (!NetworkUtil.isNetworkAvailable(this.g))
        {
          QQToast.makeText(this.g, 2131892113, 0).show();
        }
        else if (((FriendsManager)this.e.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(((NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject1).y))
        {
          QQToast.makeText(this.g, HardCodeUtil.a(2131905339), 0).show();
        }
        else
        {
          localObject2 = this.m;
          if (localObject2 != null) {
            ((FriendListHandler)localObject2).agreeSuspiciousMsg(((NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.SuspiciousSysMsgHolder)localObject1).g.uin);
          }
        }
      }
    }
    else
    {
      localObject1 = paramView.getTag(-1);
      if ((localObject1 instanceof Integer))
      {
        ReportController.b(this.e, "dc00898", "", "", "0X800A32D", "0X800A32D", 0, 0, "", "", "", "");
        i = ((Integer)localObject1).intValue();
        if (!NetworkUtil.isNetworkAvailable(this.g))
        {
          QQToast.makeText(this.g, 2131892113, 0).show();
        }
        else
        {
          localObject1 = getItem(i);
          if ((localObject1 instanceof SysSuspiciousMsg))
          {
            localObject1 = (SysSuspiciousMsg)localObject1;
            localObject2 = this.m;
            if (localObject2 != null) {
              ((FriendListHandler)localObject2).deleteSuspiciousMsg(((SysSuspiciousMsg)localObject1).uin);
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    a(true);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    a(false);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.o = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel())
      {
        paramAbsListView = new StringBuilder();
        paramAbsListView.append("onScrollStateChanged ");
        paramAbsListView.append(this.o);
        paramAbsListView.append(" ");
        paramAbsListView.append(this.p);
        QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, paramAbsListView.toString());
      }
      if ((this.o == getCount() - 1) || (this.o >= this.p)) {
        e();
      }
    }
  }
  
  public void updateCurShowRightView(View paramView)
  {
    int i1 = -1;
    int i = i1;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i = i1;
      if ((paramView instanceof Integer)) {
        i = ((Integer)paramView).intValue();
      }
    }
    this.s = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter
 * JD-Core Version:    0.7.0.1
 */