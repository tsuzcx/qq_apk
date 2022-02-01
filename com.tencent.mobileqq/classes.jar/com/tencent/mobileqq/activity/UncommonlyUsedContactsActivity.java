package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UncommonlyUsedContactsActivity
  extends BaseActivity
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  ArrayList<UncommonlyUsedContactsActivity.ListItem> a = new ArrayList();
  UncommonlyUsedContactsActivity.GatheredGrpListAdapter b;
  TextView c = null;
  int d;
  RelativeLayout e;
  InputMethodManager f = null;
  View g;
  ContactBindObserver h = new UncommonlyUsedContactsActivity.2(this);
  ProfileCardObserver i = new UncommonlyUsedContactsActivity.3(this);
  FriendListObserver j = new UncommonlyUsedContactsActivity.4(this);
  private SlideDetectListView k;
  private TextView l;
  private TextView m;
  private TextView n;
  
  @TargetApi(14)
  private void a()
  {
    super.setContentView(2131627373);
    getWindow().setBackgroundDrawable(null);
    c();
    b();
    this.e = ((RelativeLayout)findViewById(2131445137));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.e.setFitsSystemWindows(true);
      this.e.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.d = getResources().getDimensionPixelSize(2131299976);
    this.c = ((TextView)findViewById(2131448101));
    this.k = ((SlideDetectListView)findViewById(2131450345));
    LayoutInflater.from(getActivity());
    this.b = new UncommonlyUsedContactsActivity.GatheredGrpListAdapter(this, this, this.app, this.k, 1, true);
    this.k.setAdapter(this.b);
    this.k.setOnScrollGroupFloatingListener(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.c.setVisibility(4);
      return;
    }
    paramInt -= 1;
    this.c.setVisibility(0);
    if ((paramInt == 0) && (this.k.getChildAt(0) != null) && (this.k.getChildAt(0).getBottom() == this.d))
    {
      this.c.setVisibility(4);
      return;
    }
    Object localObject1 = this.b.getItem(paramInt);
    if (!(localObject1 instanceof UncommonlyUsedContactsActivity.ListItem)) {
      return;
    }
    localObject1 = ((UncommonlyUsedContactsActivity.ListItem)localObject1).c;
    paramInt += 1;
    if (paramInt < this.b.getCount())
    {
      Object localObject2 = (UncommonlyUsedContactsActivity.ListItem)this.b.getItem(paramInt);
      if ((localObject2 != null) && (((UncommonlyUsedContactsActivity.ListItem)localObject2).a == 0))
      {
        localObject2 = this.k.getChildAt(0);
        if (localObject2 != null)
        {
          paramInt = ((View)localObject2).getBottom();
          localObject2 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
          int i1 = this.d;
          if (paramInt < i1) {
            ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - i1);
          } else {
            ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
          }
          this.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.c.requestLayout();
        }
      }
      else
      {
        localObject2 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
        if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
        {
          ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
          this.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.c.requestLayout();
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.c.setVisibility(0);
      this.c.setText((CharSequence)localObject1);
      return;
    }
    this.c.setVisibility(4);
  }
  
  private void b()
  {
    this.g = findViewById(2131447484);
    this.l = ((TextView)findViewById(2131436227));
    this.l.setText(getString(2131896941));
    this.m = ((TextView)findViewById(2131436180));
    this.n = ((TextView)findViewById(2131436211));
    this.m.setOnClickListener(this);
    this.n.setVisibility(0);
    this.n.setText(2131916361);
    if (AppSetting.e)
    {
      this.l.setContentDescription(getString(2131896941));
      TextView localTextView = this.n;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131916361));
      localStringBuilder.append(HardCodeUtil.a(2131913124));
      localTextView.setContentDescription(localStringBuilder.toString());
      localTextView = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131887625));
      localStringBuilder.append(HardCodeUtil.a(2131913119));
      localTextView.setContentDescription(localStringBuilder.toString());
    }
    this.n.setOnClickListener(this);
  }
  
  private void c()
  {
    Object localObject3 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2;
    if (localObject3 != null)
    {
      ConcurrentHashMap localConcurrentHashMap = ((FriendsManager)localObject3).t();
      Set localSet = localConcurrentHashMap.keySet();
      if ((localSet != null) && (localSet.size() > 0))
      {
        Iterator localIterator = localSet.iterator();
        while (localIterator.hasNext())
        {
          ArrayList localArrayList2 = (ArrayList)localConcurrentHashMap.get((String)localIterator.next());
          if ((localArrayList2 != null) && (localArrayList2.size() > 0))
          {
            try
            {
              Collections.sort(localArrayList2, ContactSorter.a);
            }
            catch (Throwable localThrowable)
            {
              QLog.d("qqBaseActivity", 1, "", localThrowable);
            }
            localObject1 = "";
            i1 = 0;
            while (i1 < localArrayList2.size())
            {
              Friends localFriends = (Friends)localArrayList2.get(i1);
              localObject2 = localObject1;
              if (i1 == 0)
              {
                Object localObject4 = ((FriendsManager)localObject3).h();
                localObject2 = localObject1;
                if (localObject4 != null)
                {
                  localObject2 = localObject1;
                  if (((List)localObject4).size() > 0)
                  {
                    localObject4 = ((List)localObject4).iterator();
                    for (;;)
                    {
                      localObject2 = localObject1;
                      if (!((Iterator)localObject4).hasNext()) {
                        break;
                      }
                      localObject2 = (Groups)((Iterator)localObject4).next();
                      if (((Groups)localObject2).group_id == localFriends.groupid)
                      {
                        localObject1 = new StringBuilder();
                        ((StringBuilder)localObject1).append(((Groups)localObject2).group_name);
                        ((StringBuilder)localObject1).append("(");
                        ((StringBuilder)localObject1).append(localArrayList2.size());
                        ((StringBuilder)localObject1).append(")");
                        localObject1 = ((StringBuilder)localObject1).toString();
                      }
                    }
                  }
                }
                localObject1 = new UncommonlyUsedContactsActivity.ListItem(this, 0, null);
                ((UncommonlyUsedContactsActivity.ListItem)localObject1).a((String)localObject2);
                localArrayList1.add(localObject1);
              }
              localObject1 = new UncommonlyUsedContactsActivity.ListItem(this, 1, localFriends);
              ((UncommonlyUsedContactsActivity.ListItem)localObject1).a((String)localObject2);
              localArrayList1.add(localObject1);
              i1 += 1;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    Object localObject1 = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
    int i1 = ((IPhoneContactService)localObject1).getSelfBindState();
    if ((((IPhoneContactService)localObject1).isBindContactOk()) || (i1 == 8))
    {
      localObject2 = ((IPhoneContactService)localObject1).getBindHideNoneFriendList(true);
      if (((List)localObject2).size() > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getString(2131892489));
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(((List)localObject2).size());
        ((StringBuilder)localObject1).append(")");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject3 = new UncommonlyUsedContactsActivity.ListItem(this, 0, null);
        ((UncommonlyUsedContactsActivity.ListItem)localObject3).a((String)localObject1);
        localArrayList1.add(localObject3);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = new UncommonlyUsedContactsActivity.ListItem(this, 1, (PhoneContact)((Iterator)localObject2).next());
          ((UncommonlyUsedContactsActivity.ListItem)localObject3).a((String)localObject1);
          localArrayList1.add(localObject3);
        }
      }
    }
    this.a = localArrayList1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(getActivity()).notifyUser(paramInt1, this.g.getHeight(), 0, paramInt2);
  }
  
  void a(UncommonlyUsedContactsActivity.ListItem paramListItem)
  {
    if (paramListItem.b == null) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.addButton(getString(2131916257), 0);
    localActionSheet.addButton(getString(2131896936), 0);
    if ((paramListItem.b instanceof Friends))
    {
      localActionSheet.addButton(getString(2131896938), 0);
      localActionSheet.addButton(getString(2131896934), 3);
    }
    else
    {
      if (!(paramListItem.b instanceof PhoneContact)) {
        return;
      }
      localActionSheet.addButton(getString(2131896939), 0);
    }
    localActionSheet.setOnButtonClickListener(new UncommonlyUsedContactsActivity.1(this, paramListItem, localActionSheet));
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.show();
  }
  
  void a(String paramString)
  {
    DialogUtil.a(getActivity(), 230).setTitle(getString(2131888447)).setMessage(getString(2131887544)).setPositiveButton(2131889653, new UncommonlyUsedContactsActivity.6(this, paramString)).setNegativeButton(2131887626, new UncommonlyUsedContactsActivity.5(this)).show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21001) {
        return;
      }
      if (paramIntent != null)
      {
        paramIntent = new AllInOne(paramIntent.getStringExtra("contactSearchResultUin"), 1);
        paramIntent.profileEntryType = 60;
        ProfileUtils.openProfileCard(getActivity(), paramIntent);
        ReportController.b(this.app, "CliOper", "", "", "0X8004C58", "0X8004C58", 3, 0, "", "", "", "");
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    addObserver(this.j);
    addObserver(this.i);
    this.app.registObserver(this.h);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.j);
    removeObserver(this.i);
    this.app.unRegistObserver(this.h);
    UncommonlyUsedContactsActivity.GatheredGrpListAdapter localGatheredGrpListAdapter = this.b;
    if (localGatheredGrpListAdapter != null) {
      localGatheredGrpListAdapter.c();
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772005, 2130772006);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131436180) {
      if (i1 != 2131436211) {
        localObject = (UncommonlyUsedContactsActivity.GatheredViewHolder)paramView.getTag();
      }
    }
    try
    {
      localObject = (UncommonlyUsedContactsActivity.ListItem)this.a.get(((UncommonlyUsedContactsActivity.GatheredViewHolder)localObject).f);
    }
    catch (Exception localException)
    {
      label43:
      break label43;
    }
    Object localObject = null;
    if (localObject != null)
    {
      a((UncommonlyUsedContactsActivity.ListItem)localObject);
      ReportController.b(this.app, "CliOper", "", "", "0X8004C50", "0X8004C50", 0, 0, "", "", "", "");
      break label154;
      startActivity(new Intent(this, SettingUncommUsedContactsActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "0X8004C55", "0X8004C55", 0, 0, "", "", "", "");
      break label154;
      finish();
    }
    label154:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.b != null) {
      a(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity
 * JD-Core Version:    0.7.0.1
 */