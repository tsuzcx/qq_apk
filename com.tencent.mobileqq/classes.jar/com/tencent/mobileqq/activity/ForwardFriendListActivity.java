package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.widgets.InputDialog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter.IForwardFriendListAdapterCallback;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter.ViewTag;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.ResultRecord.DefaultComparator;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar.ISelectedAndSearchBarCallback;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ForwardFriendListActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener
{
  private ForwardSelectionFriendListAdapter.IForwardFriendListAdapterCallback A = new ForwardFriendListActivity.8(this);
  private IFaceDecoder B;
  private IQQGuildService C;
  private InputMethodManager D;
  private Dialog E;
  LinearLayout e;
  RelativeLayout f;
  private TextView g;
  private TextView h;
  private TextView i;
  private ImageView j;
  private TextView k;
  private PinnedHeaderExpandableListView l;
  private ForwardSelectionFriendListAdapter m;
  private InputDialog n;
  private Handler o = new Handler();
  private FriendsManager p;
  private int q;
  private int r;
  private boolean s;
  private SelectedAndSearchBar t;
  private FrameLayout u;
  private View v;
  private Map<String, ResultRecord> w = new LinkedHashMap();
  private ContactSearchFragment x;
  private SelectedAndSearchBar.ISelectedAndSearchBarCallback y = new ForwardFriendListActivity.6(this);
  private ContactSearchResultPresenter.OnActionListener z = new ForwardFriendListActivity.7(this);
  
  private String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt)
  {
    int i1;
    if (paramInt == 11) {
      i1 = 21003;
    } else if (paramInt == 6) {
      i1 = 21002;
    } else if (paramInt == 16) {
      i1 = 21009;
    } else if (paramInt == 18) {
      i1 = 21010;
    } else {
      i1 = 21001;
    }
    ContactSearchComponentActivity.a(this, null, paramInt, 1, i1);
  }
  
  private void a(View paramView)
  {
    Object localObject = (ForwardSelectionFriendListAdapter.ViewTag)paramView.getTag();
    if (localObject != null)
    {
      localObject = ((ForwardSelectionFriendListAdapter.ViewTag)localObject).a;
      if ((localObject != null) && ((localObject instanceof Friends)))
      {
        localObject = (Friends)localObject;
        int i1 = this.q;
        boolean bool = false;
        if (((i1 == 1) || (i1 == 4) || (i1 == 3) || (i1 == 6) || (i1 == 7)) && (localObject != null))
        {
          if (this.r == 2)
          {
            if (this.p.y(((Friends)localObject).uin) != null)
            {
              QQToast.makeText(this, getString(2131897332), 0).show(getTitleBarHeight());
              return;
            }
            if (this.app.getCurrentUin().equals(((Friends)localObject).uin))
            {
              QQToast.makeText(this, getString(2131887657), 0).show(getTitleBarHeight());
              return;
            }
            paramView = new Intent(this, QQSpecialFriendSettingActivity.class);
            paramView.putExtra("key_friend_uin", ((Friends)localObject).uin);
            paramView.putExtra("key_is_from_friendsforward_activity", true);
            startActivity(paramView);
            return;
          }
          paramView = new Intent();
          paramView.putExtras(getIntent().getExtras());
          paramView.putExtra("extra_choose_friend_uin", ((Friends)localObject).uin);
          paramView.putExtra("extra_choose_friend_name", ((Friends)localObject).name);
          paramView.putExtra("extraChooseFriendRemark", ((Friends)localObject).remark);
          setResult(-1, paramView);
          finish();
          return;
        }
        paramView = (TextView)paramView.findViewById(2131447063);
        if (paramView != null)
        {
          if (paramView.getText() != null) {
            paramView = paramView.getText().toString();
          } else {
            paramView = null;
          }
        }
        else {
          paramView = "Ta";
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", ((Friends)localObject).uin);
        localBundle.putInt("uintype", 0);
        localBundle.putString("uinname", paramView);
        localBundle.putInt("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.q.intValue());
        if (getIntent() != null) {
          bool = getIntent().getBooleanExtra("choose_friend_needConfirm", false);
        }
        if (bool)
        {
          paramView = getIntent().getStringExtra("choose_friend_confirmTitle");
          localObject = getIntent().getStringExtra("choose_friend_confirmContent");
          localBundle.putBoolean("choose_friend_needConfirm", bool);
          localBundle.putString("choose_friend_confirmTitle", paramView);
          localBundle.putString("choose_friend_confirmContent", (String)localObject);
        }
        this.a.a(ForwardAbility.ForwardAbilityType.c.intValue(), localBundle);
      }
    }
  }
  
  private void a(List<ResultRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((ResultRecord)paramList.next());
      }
    }
  }
  
  private boolean a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord == null) {
      return false;
    }
    String str = a(paramResultRecord.uin, paramResultRecord.getUinType());
    ResultRecord localResultRecord = (ResultRecord)this.w.get(str);
    if (localResultRecord != null)
    {
      localResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
      paramResultRecord = new ArrayList(this.w.values());
      this.t.a(paramResultRecord, false);
      return false;
    }
    if (this.w.size() == 9)
    {
      k();
      return false;
    }
    ResultRecord.copyResultRecord(paramResultRecord).lastChooseTime = SystemClock.elapsedRealtime();
    this.w.put(str, ResultRecord.copyResultRecord(paramResultRecord));
    g();
    paramResultRecord = new ArrayList(this.w.values());
    this.t.a(paramResultRecord, true);
    return true;
  }
  
  private void b()
  {
    d();
    this.l = ((PinnedHeaderExpandableListView)findViewById(2131433791));
    Object localObject = LayoutInflater.from(this);
    this.u = ((FrameLayout)findViewById(2131444724));
    i();
    if (this.s)
    {
      h();
    }
    else
    {
      this.v = ((LayoutInflater)localObject).inflate(2131629215, this.l, false);
      this.v.findViewById(2131429816).setVisibility(8);
      localObject = (EditText)this.v.findViewById(2131432634);
      ((EditText)localObject).setFocusable(false);
      ((EditText)localObject).setOnClickListener(this);
      ((EditText)localObject).setCursorVisible(false);
      this.l.addHeaderView(this.v);
      localObject = new View(this);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(12.0F, getResources())));
      this.l.addHeaderView((View)localObject);
    }
    int i1 = this.q;
    if ((i1 == 6) || (i1 == 7)) {
      c();
    }
  }
  
  private void b(View paramView)
  {
    this.o.post(new ForwardFriendListActivity.4(this, paramView));
  }
  
  private boolean b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.w.containsKey(a(paramString, paramInt));
  }
  
  private void c()
  {
    if (this.app != null)
    {
      Object localObject = this.app.getAccount();
      String str = this.app.getCurrentNickname();
      View localView = LayoutInflater.from(getActivity()).inflate(2131629164, this.l, false);
      ImageView localImageView = (ImageView)localView.findViewById(2131435219);
      TextView localTextView = (TextView)localView.findViewById(2131447063);
      if (localImageView != null) {
        localImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.app, 3, (String)localObject));
      }
      if (localTextView != null) {
        localTextView.setText(str);
      }
      localView.setOnClickListener(new ForwardFriendListActivity.1(this));
      localObject = this.l;
      if (localObject != null) {
        ((PinnedHeaderExpandableListView)localObject).addHeaderView(localView);
      }
    }
  }
  
  private void c(View paramView)
  {
    this.o.post(new ForwardFriendListActivity.5(this, paramView));
  }
  
  private void c(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = a(paramString, paramInt);
    this.w.remove(paramString);
    g();
    paramString = new ArrayList(this.w.values());
    this.t.a(paramString, true);
  }
  
  @TargetApi(14)
  private void d()
  {
    this.e = ((LinearLayout)findViewById(2131445137));
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.mNeedStatusTrans))
    {
      this.e.setFitsSystemWindows(true);
      this.e.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.f = ((RelativeLayout)findViewById(2131445043));
    this.g = ((TextView)findViewById(2131436227));
    this.g.setText(HardCodeUtil.a(2131902754));
    if (getIntent() != null)
    {
      String str = getIntent().getStringExtra("isForConfessDirectFriendsTitle");
      if (!TextUtils.isEmpty(str)) {
        this.g.setText(str);
      }
    }
    this.i = ((TextView)findViewById(2131436180));
    if (this.r == 2)
    {
      this.i.setVisibility(8);
    }
    else
    {
      this.i.setVisibility(0);
      this.i.setOnClickListener(this);
      if (getIntent().getIntExtra("forward_type", 2147483647) == 23)
      {
        this.i.setText(HardCodeUtil.a(2131902756));
        this.i.setMaxWidth(AIOUtils.b(120.0F, getResources()));
      }
      else if (this.q == 4)
      {
        this.i.setText(HardCodeUtil.a(2131898212));
        this.i.setBackgroundResource(0);
      }
      else
      {
        this.i.setText(2131887625);
      }
    }
    this.h = ((TextView)findViewById(2131436182));
    this.h.setVisibility(8);
    this.k = ((TextView)findViewById(2131436211));
    int i1 = this.q;
    if (i1 == 6)
    {
      this.k.setVisibility(0);
      this.k.setText(HardCodeUtil.a(2131902753));
      this.k.setContentDescription(HardCodeUtil.a(2131902755));
      this.k.setOnClickListener(this);
    }
    else if ((i1 != 4) && (i1 != 5))
    {
      this.k.setVisibility(0);
      this.k.setText(2131887648);
      this.k.setContentDescription(HardCodeUtil.a(2131898212));
      this.k.setOnClickListener(this);
    }
    this.k.setMaxWidth(AIOUtils.b(260.0F, getResources()));
    this.j = ((ImageView)findViewById(2131436194));
    this.j.setVisibility(8);
    IphoneTitleBarActivity.setLayerType(this.j);
    IphoneTitleBarActivity.setLayerType(this.h);
    if (AppSetting.e) {
      this.i.setContentDescription(HardCodeUtil.a(2131901576));
    }
  }
  
  private void d(View paramView)
  {
    paramView = ((ForwardRecentItemView)paramView).k;
    if (b(paramView.uin, paramView.getUinType())) {
      c(paramView.uin, paramView.getUinType());
    } else {
      a(paramView);
    }
    this.m.notifyDataSetChanged();
  }
  
  private void e()
  {
    a();
    if (this.s) {
      a(getIntent().getParcelableArrayListExtra("selected_target_list"));
    }
  }
  
  private void f()
  {
    if (this.n == null) {
      this.n = InputDialog.a(this, HardCodeUtil.a(2131902746), "", 2131887648, 2131892267, new ForwardFriendListActivity.2(this), new ForwardFriendListActivity.3(this));
    }
    if (!this.n.isShowing())
    {
      this.n.show();
      b(this.n.getEditText());
    }
  }
  
  private void g()
  {
    if (this.w.isEmpty())
    {
      this.k.setText(HardCodeUtil.a(2131902757));
      this.k.setClickable(false);
      this.k.setTextColor(855836698);
    }
    else
    {
      this.k.setText(String.format(HardCodeUtil.a(2131902751), new Object[] { Integer.valueOf(this.w.size()) }));
      this.k.setClickable(true);
      this.k.setTextColor(getResources().getColor(2131168001));
    }
    if (AppSetting.e)
    {
      TextView localTextView = this.k;
      localTextView.setContentDescription(localTextView.getText());
    }
  }
  
  private void h()
  {
    this.t.setVisibility(0);
    this.i.setVisibility(0);
    this.i.setText("");
    this.B = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.C = ((IQQGuildService)this.app.getRuntimeService(IQQGuildService.class, ""));
    this.t.a(null, this.B, this.y, this.C);
    Object localObject = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(29.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(10.0F, getResources());
    if (Build.VERSION.SDK_INT <= 18) {
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(75.0F, getResources());
    }
    this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.k.setPadding(AIOUtils.b(7.0F, getResources()), 0, AIOUtils.b(7.0F, getResources()), 0);
    this.k.setBackgroundResource(2130846654);
    this.k.setTextSize(1, 14.0F);
    this.k.setVisibility(0);
    this.k.setOnClickListener(this);
    g();
    if (AppSetting.e)
    {
      localObject = this.k;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
  }
  
  private void i()
  {
    this.D = ((InputMethodManager)getSystemService("input_method"));
    this.t = ((SelectedAndSearchBar)super.findViewById(2131445550));
    this.t.setVisibility(8);
  }
  
  private void j()
  {
    this.D.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.t.b();
    this.t.c();
    this.u.setVisibility(8);
  }
  
  private void k()
  {
    if (this.E == null) {
      this.E = DialogUtil.a(this, getString(2131896914), 0, 2131892366, null, new ForwardFriendListActivity.9(this));
    }
    if (!isFinishing()) {
      this.E.show();
    }
  }
  
  private void l()
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ForwardFriendListActivity", 2, "forwardOption is null, return.");
      }
      return;
    }
    if (this.w.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ForwardFriendListActivity", 2, "forward2MultiTargets map is empty !");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList(this.w.values());
    Collections.sort(localArrayList, new ResultRecord.DefaultComparator());
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    this.a.a(ForwardAbility.ForwardAbilityType.b.intValue(), localBundle);
    this.a.v();
  }
  
  protected boolean a()
  {
    if (this.p == null) {
      this.p = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    }
    if (!this.p.l()) {
      return false;
    }
    Object localObject = this.p.k();
    ArrayList localArrayList = new ArrayList();
    Groups localGroups = new Groups();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      ForwardSelectionFriendListAdapter.a(1003);
      localGroups.group_id = ForwardSelectionFriendListAdapter.a();
    }
    else
    {
      ForwardSelectionFriendListAdapter.a(0);
      localGroups.group_id = ForwardSelectionFriendListAdapter.a();
    }
    localGroups.group_name = HardCodeUtil.a(2131902750);
    localArrayList.add(0, localGroups);
    localArrayList.addAll((Collection)localObject);
    localObject = this.m;
    if (localObject == null)
    {
      this.m = new ForwardSelectionFriendListAdapter(this, this.l, this.app, localArrayList, this.A, this.s);
      this.l.setAdapter(this.m);
      this.l.expandGroup(0);
      return true;
    }
    ((ForwardSelectionFriendListAdapter)localObject).a(localArrayList, true);
    return true;
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      Object localObject;
      if (paramInt1 != 21002)
      {
        if (paramInt1 != 21003)
        {
          if (paramInt1 != 21009)
          {
            if (paramInt1 != 21010) {
              return;
            }
            if (paramIntent != null)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtras(getIntent().getExtras());
              ((Intent)localObject).putExtra("extra_choose_friend_uin", paramIntent.getStringExtra("contactSearchResultUin"));
              ((Intent)localObject).putExtra("extraChooseFriendRemark", paramIntent.getStringExtra("contactSearchResultName"));
              ((Intent)localObject).putExtra("extra_choose_friend_name", paramIntent.getStringExtra("contactSearchResultNick"));
              setResult(-1, (Intent)localObject);
              finish();
            }
          }
          else if (paramIntent != null)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtras(getIntent().getExtras());
            ((Intent)localObject).putExtra("extra_choose_friend_uin", paramIntent.getStringExtra("contactSearchResultUin"));
            ((Intent)localObject).putExtra("extra_choose_friend_name", paramIntent.getStringExtra("contactSearchResultName"));
            setResult(-1, (Intent)localObject);
            finish();
          }
        }
        else if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("contactSearchResultUin");
          localObject = new Intent(this, QQSpecialFriendSettingActivity.class);
          ((Intent)localObject).putExtra("key_friend_uin", paramIntent);
          ((Intent)localObject).putExtra("key_is_from_friendsforward_activity", true);
          startActivity((Intent)localObject);
        }
      }
      else
      {
        localObject = getIntent();
        boolean bool = false;
        if (localObject != null) {
          bool = getIntent().getBooleanExtra("choose_friend_needConfirm", false);
        }
        if (bool)
        {
          localObject = getIntent().getStringExtra("choose_friend_confirmTitle");
          String str = getIntent().getStringExtra("choose_friend_confirmContent");
          paramIntent.putExtra("choose_friend_needConfirm", bool);
          paramIntent.putExtra("choose_friend_confirmTitle", (String)localObject);
          paramIntent.putExtra("choose_friend_confirmContent", str);
        }
        SearchUtil.a(paramIntent, this.a);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131952010);
    this.r = getIntent().getIntExtra("extra_add_special_friend", 0);
    this.q = getIntent().getIntExtra("extra_choose_friend", 0);
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    super.setContentView(2131624868);
    this.s = (getIntent().getBooleanExtra("only_single_selection", true) ^ true);
    b();
    e();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.m;
    if (localObject != null)
    {
      ((ForwardSelectionFriendListAdapter)localObject).c();
      this.l.setAdapter((PinnedHeaderExpandableListView.ExpandableListAdapter)null);
    }
    localObject = this.n;
    if (localObject != null) {
      ((InputDialog)localObject).dismiss();
    }
    localObject = this.B;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((this.r != 2) && (this.q != 4))
    {
      overridePendingTransition(0, 2130771995);
      return;
    }
    overridePendingTransition(2130771994, 2130771995);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (this.u.getVisibility() != 8)
    {
      j();
      return true;
    }
    if (this.t.a()) {
      j();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131432634)
    {
      if (i1 != 2131436180)
      {
        if (i1 == 2131436211) {
          if (this.q == 6)
          {
            f();
          }
          else if (this.s)
          {
            l();
          }
          else
          {
            if (this.a != null)
            {
              this.a.b(false);
              com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.a = false;
            }
            setResult(1);
            finish();
          }
        }
      }
      else
      {
        if (this.s)
        {
          Intent localIntent = new Intent();
          localIntent.putParcelableArrayListExtra("selected_target_list", new ArrayList(this.w.values()));
          setResult(0, localIntent);
        }
        finish();
      }
    }
    else
    {
      i1 = this.q;
      if (i1 == 1) {
        a(11);
      } else if ((i1 != 3) && (i1 != 6) && (i1 != 7))
      {
        if (i1 == 4) {
          a(18);
        } else {
          a(6);
        }
      }
      else {
        a(16);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity
 * JD-Core Version:    0.7.0.1
 */