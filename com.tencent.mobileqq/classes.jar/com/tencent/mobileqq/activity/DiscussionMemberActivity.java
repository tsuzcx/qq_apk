package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.troop.memberlist.TroopMemberList.ViewHolder;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DiscussionMemberActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, AdapterView.OnItemClickListener
{
  PinnedDividerListView a;
  List<DiscussionMemberActivity.DiscussionMember> b = new ArrayList();
  View c;
  View d;
  EditText e;
  XListView f;
  DiscussionMemberActivity.SearchResultAdapter g;
  private final int h = 1;
  private String i;
  private DiscussionMemberActivity.DiscussionMemberListAdapter j;
  private IndexView k;
  private List<DiscussionMemberActivity.DiscussionMember> l = new ArrayList();
  private EditText m;
  private View n;
  private ImageButton o;
  private View p;
  private RelativeLayout q;
  private View r;
  private String s;
  
  private void a()
  {
    this.a = ((PinnedDividerListView)findViewById(2131430527));
    this.k = ((IndexView)findViewById(2131435678));
    this.a.setSelector(2131168376);
    this.a.setOnItemClickListener(this);
    this.a.setOnLayoutListener(this);
    this.k.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.k.setOnIndexChangedListener(this);
    this.n = findViewById(2131444897);
    this.c = ((View)this.n.getParent());
    this.d = findViewById(2131445534);
    this.d.setBackgroundResource(2130838958);
    setTitle(HardCodeUtil.a(2131901466));
    Object localObject = (RelativeLayout)getLayoutInflater().inflate(2131629215, this.a, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 40, 0);
    this.m = ((EditText)((RelativeLayout)localObject).findViewById(2131432634));
    this.m.setFocusable(false);
    this.m.setOnTouchListener(this);
    ((Button)((RelativeLayout)localObject).findViewById(2131429816)).setVisibility(8);
    this.a.addHeaderView((View)localObject);
    this.r = getLayoutInflater().inflate(2131624729, this.a, false);
    TroopMemberList.ViewHolder localViewHolder = new TroopMemberList.ViewHolder();
    localViewHolder.y = this.app.getCurrentAccountUin();
    localViewHolder.A = ((ImageView)this.r.findViewById(2131436404));
    localViewHolder.A.setBackgroundDrawable(FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)3));
    localViewHolder.i = ((TextView)this.r.findViewById(2131448598));
    localObject = this.app.getCurrentNickname();
    TextView localTextView = localViewHolder.i;
    if ((localObject == null) || (((String)localObject).trim().length() <= 0)) {
      localObject = this.app.getCurrentAccountUin();
    }
    localTextView.setText((CharSequence)localObject);
    this.r.setTag(localViewHolder);
    this.r.setOnClickListener(this);
    this.a.addHeaderView(this.r);
  }
  
  private void b()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject = (DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (localFriendsManager != null)
    {
      localObject = ((DiscussionManager)localObject).a(this.i);
      if (localObject != null)
      {
        this.b.clear();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
          if (localDiscussionMemberInfo.memberUin.equals(this.app.getCurrentAccountUin()))
          {
            this.s = ContactUtils.a(this.app, localDiscussionMemberInfo);
          }
          else
          {
            DiscussionMemberActivity.DiscussionMember localDiscussionMember = new DiscussionMemberActivity.DiscussionMember(this, null);
            localDiscussionMember.a = localDiscussionMemberInfo.memberUin;
            localDiscussionMember.b = ContactUtils.a(localDiscussionMemberInfo, this.app);
            localFriendsManager.m(localDiscussionMember.a);
            localDiscussionMember.d = ChnToSpell.b(localDiscussionMember.b, 1);
            localDiscussionMember.c = ChnToSpell.b(localDiscussionMember.b, 2);
            this.b.add(localDiscussionMember);
          }
        }
      }
    }
  }
  
  private void c()
  {
    ReportDialog localReportDialog = new ReportDialog(this);
    localReportDialog.setCanceledOnTouchOutside(true);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setSoftInputMode(36);
    localReportDialog.setContentView(2131629224);
    Object localObject1 = localReportDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject1).x = 0;
    ((WindowManager.LayoutParams)localObject1).y = 0;
    ((WindowManager.LayoutParams)localObject1).width = -1;
    ((WindowManager.LayoutParams)localObject1).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject1).gravity = 51;
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    int i1 = this.n.getHeight();
    float f1 = -i1;
    Object localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, f1);
    ((TranslateAnimation)localObject3).setDuration(300L);
    ((TranslateAnimation)localObject3).setFillAfter(true);
    Object localObject2 = new TranslateAnimation(0.0F, 0.0F, f1, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    localObject1 = (InputMethodManager)getSystemService("input_method");
    DiscussionMemberActivity.1 local1 = new DiscussionMemberActivity.1(this, (TranslateAnimation)localObject3, localReportDialog, (TranslateAnimation)localObject2, i1);
    ((TranslateAnimation)localObject3).setAnimationListener(local1);
    ((TranslateAnimation)localObject2).setAnimationListener(local1);
    this.c.startAnimation((Animation)localObject3);
    localObject3 = new DiscussionMemberActivity.2(this);
    addObserver((BusinessObserver)localObject3);
    localReportDialog.setOnDismissListener(new DiscussionMemberActivity.3(this, i1, (TranslateAnimation)localObject2, (InputMethodManager)localObject1, (AvatarObserver)localObject3));
    this.e = ((EditText)localReportDialog.findViewById(2131432634));
    this.e.addTextChangedListener(new DiscussionMemberActivity.SearchTextWatcher(this, null));
    this.e.setSelection(0);
    this.e.requestFocus();
    this.o = ((ImageButton)localReportDialog.findViewById(2131435215));
    this.o.setOnClickListener(new DiscussionMemberActivity.4(this));
    localObject2 = (Button)localReportDialog.findViewById(2131429816);
    ((Button)localObject2).setVisibility(0);
    ((Button)localObject2).setOnClickListener(new DiscussionMemberActivity.5(this, localReportDialog));
    this.p = localReportDialog.findViewById(2131439366);
    this.q = ((RelativeLayout)localReportDialog.findViewById(2131444724));
    this.q.setOnClickListener(new DiscussionMemberActivity.6(this, localReportDialog));
    this.f = ((XListView)localReportDialog.findViewById(2131445380));
    this.f.setBackgroundDrawable(getResources().getDrawable(2130838958));
    this.f.setDividerHeight(0);
    this.l.clear();
    this.g = new DiscussionMemberActivity.SearchResultAdapter(this, this.l);
    this.f.setAdapter(this.g);
    this.f.setOnTouchListener(new DiscussionMemberActivity.7(this, (InputMethodManager)localObject1));
    this.f.setOnItemClickListener(new DiscussionMemberActivity.8(this, localReportDialog));
  }
  
  void a(View paramView)
  {
    paramView = (TroopMemberList.ViewHolder)paramView.getTag();
    if ((paramView != null) && (paramView.y != null))
    {
      paramView = paramView.y;
      if (paramView.equals(this.app.getCurrentAccountUin()))
      {
        paramView = new AllInOne(paramView, 0);
        paramView.lastActivity = 5;
        ProfileUtils.openProfileCardForResult(this, paramView, 1);
        return;
      }
      if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramView))
      {
        localAllInOne = new AllInOne(paramView, 1);
        localAllInOne.nickname = ContactUtils.a(this.app, paramView, 0);
        localAllInOne.lastActivity = 5;
        ProfileUtils.openProfileCardForResult(this, localAllInOne, 1);
        return;
      }
      AllInOne localAllInOne = new AllInOne(paramView, 46);
      localAllInOne.nickname = ContactUtils.a(this.app, paramView, 0);
      localAllInOne.preWinUin = paramView;
      localAllInOne.preWinType = 3000;
      localAllInOne.discussUin = this.i;
      localAllInOne.lastActivity = 5;
      ProfileUtils.openProfileCardForResult(this, localAllInOne, 1);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.a.getFirstVisiblePosition() > 0) || ((this.a.getFirstVisiblePosition() == 0) && (this.a.getChildCount() < this.j.getCount() + this.a.getHeaderViewsCount()))) {
      this.k.setVisibility(0);
    }
  }
  
  void a(String paramString)
  {
    this.l.clear();
    if ((!paramString.equals("")) && (paramString.trim().length() != 0))
    {
      this.o.setVisibility(0);
      this.f.setVisibility(0);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        DiscussionMemberActivity.DiscussionMember localDiscussionMember = (DiscussionMemberActivity.DiscussionMember)localIterator.next();
        if (localDiscussionMember != null) {
          if ((!localDiscussionMember.b.equals(paramString)) && (!localDiscussionMember.a.equals(paramString)) && (!localDiscussionMember.d.equals(paramString.toLowerCase())) && (!localDiscussionMember.c.equals(paramString.toLowerCase())))
          {
            if ((localDiscussionMember.b.indexOf(paramString) != 0) && (localDiscussionMember.a.indexOf(paramString) != 0) && (localDiscussionMember.c.indexOf(paramString.toLowerCase()) != 0) && (localDiscussionMember.d.indexOf(paramString.toLowerCase()) != 0))
            {
              if ((localDiscussionMember.b.indexOf(paramString) > 0) || (localDiscussionMember.a.indexOf(paramString) > 0) || (localDiscussionMember.c.indexOf(paramString.toLowerCase()) > 0) || (localDiscussionMember.d.indexOf(paramString.toLowerCase()) > 0)) {
                localArrayList3.add(localDiscussionMember);
              }
            }
            else {
              localArrayList2.add(localDiscussionMember);
            }
          }
          else {
            localArrayList1.add(localDiscussionMember);
          }
        }
      }
      Collections.sort(localArrayList2, new DiscussionMemberActivity.MyComparator(this, null));
      this.l.addAll(localArrayList1);
      this.l.addAll(localArrayList2);
      this.l.addAll(localArrayList3);
      if (this.l.isEmpty()) {
        this.p.setVisibility(0);
      } else {
        this.p.setVisibility(8);
      }
    }
    else
    {
      this.o.setVisibility(8);
      this.f.setVisibility(8);
      this.p.setVisibility(8);
    }
    this.g.notifyDataSetChanged();
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
    if ((-1 == paramInt2) && (paramInt2 == 1)) {
      this.j.notifyDataSetChanged();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131629255);
    this.i = getIntent().getStringExtra("uin");
    a();
    b();
    ((TroopMemberList.ViewHolder)this.r.getTag()).i.setText(this.s);
    this.j = new DiscussionMemberActivity.DiscussionMemberListAdapter(this);
    this.a.setAdapter(this.j);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.j.d();
    super.doOnDestroy();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(48);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.r) {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.a.setSelection(0);
      return;
    }
    int i1 = this.j.e_(paramString);
    if (i1 != -1)
    {
      paramString = this.a;
      paramString.setSelection(i1 + paramString.getHeaderViewsCount());
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      c();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity
 * JD-Core Version:    0.7.0.1
 */