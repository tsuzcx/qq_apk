package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.adapter.CommonAdapter;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;
import com.tencent.mobileqq.troop.recommend.api.ITroopRecommendHandler;
import com.tencent.mobileqq.troop.recommend.api.TroopRecommendObserver;
import com.tencent.mobileqq.troop.recommend.data.RecommendMember;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopRecommendFriendFragment
  extends IphoneTitleBarFragment
{
  private QQAppInterface a;
  private BaseActivity b;
  private OverScrollRecyclerView c;
  private CommonAdapter<RecommendMember> d;
  private ITroopRecommendHandler e;
  private int f = 0;
  private View g;
  private String h;
  private int i;
  private int j;
  private byte[] k;
  private ArrayList<Long> l;
  private final TroopRecommendObserver m = new TroopRecommendFriendFragment.5(this);
  
  private String a(String paramString)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager.n(paramString)) {
      return this.b.getString(2131889682);
    }
    if (localFriendsManager.b(paramString, false)) {
      return this.b.getString(2131897520);
    }
    return null;
  }
  
  private void a()
  {
    this.d = new TroopRecommendFriendFragment.2(this, this.b, 2131625965);
    this.d.e(2131627871);
    this.d.a(new TroopRecommendFriendFragment.3(this));
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    PublicFragmentActivity.Launcher.a(paramContext, paramIntent, PublicFragmentActivity.class, TroopRecommendFriendFragment.class);
  }
  
  private void a(View paramView)
  {
    this.g = paramView.findViewById(2131444429);
    this.c = ((OverScrollRecyclerView)paramView.findViewById(2131448086));
    this.c.setLayoutManager(new LinearLayoutManager(getBaseActivity(), 1, false));
    this.c.addOnScrollListener(new TroopRecommendFriendFragment.1(this));
  }
  
  private void a(ViewHolder paramViewHolder, RecommendMember paramRecommendMember, int paramInt)
  {
    if (paramViewHolder != null)
    {
      if (paramRecommendMember == null) {
        return;
      }
      ((MemberViewHolder)paramViewHolder).a = paramRecommendMember;
      Object localObject = (ImageView)paramViewHolder.a(2131427337);
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(FaceDrawable.getFaceDrawable(this.a, 1, paramRecommendMember.a));
      }
      localObject = (TextView)paramViewHolder.a(2131439320);
      if (localObject != null) {
        ((TextView)localObject).setText(paramRecommendMember.b);
      }
      localObject = (TextView)paramViewHolder.a(2131438023);
      if (localObject != null) {
        ((TextView)localObject).setText(paramRecommendMember.f);
      }
      localObject = (TroopLabelLayout)paramViewHolder.a(2131448010);
      if (localObject != null) {
        ((TroopLabelLayout)localObject).a(paramRecommendMember.e, paramRecommendMember.c, paramRecommendMember.d, 1);
      }
      localObject = (Button)paramViewHolder.a(2131444718);
      paramViewHolder = (TextView)paramViewHolder.a(2131444726);
      if ((localObject != null) && (paramViewHolder != null))
      {
        String str = a(paramRecommendMember.a);
        if (TextUtils.isEmpty(str))
        {
          paramViewHolder.setVisibility(8);
          ((Button)localObject).setVisibility(0);
          ((Button)localObject).setText(2131886199);
          ((Button)localObject).setOnClickListener(new TroopRecommendFriendFragment.4(this, paramRecommendMember));
          return;
        }
        paramViewHolder.setVisibility(0);
        paramViewHolder.setText(str);
        ((Button)localObject).setVisibility(8);
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addFriend troopUin = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", memberUin =");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", troopCode =");
      ((StringBuilder)localObject).append(paramString3);
      QLog.i("TroopRecommendFriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      localObject = ContactUtils.b(this.a, paramString1, paramString2);
      int n = this.i;
      paramString2 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.b, 1, paramString2, paramString3, 3004, n, (String)localObject, null, null, null, null);
      paramString2.putExtra("need_result_uin", true);
      paramString2.putExtra("troop_uin", paramString1);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this.b, paramString2, 11);
    }
  }
  
  private void b()
  {
    this.c.setAdapter(this.d);
    if (!NetworkUtil.isNetSupport(this.b))
    {
      this.g.setVisibility(8);
      BaseActivity localBaseActivity = this.b;
      QQToast.makeText(localBaseActivity, 1, localBaseActivity.getString(2131892104), 0).show();
      return;
    }
    c();
  }
  
  private void c()
  {
    String str = this.h;
    if (str != null)
    {
      ITroopRecommendHandler localITroopRecommendHandler = this.e;
      int n = this.j;
      byte[] arrayOfByte = this.k;
      ArrayList localArrayList;
      if (arrayOfByte == null) {
        localArrayList = this.l;
      } else {
        localArrayList = null;
      }
      localITroopRecommendHandler.a(str, 2, n, arrayOfByte, 50, localArrayList);
    }
  }
  
  private void d()
  {
    if (this.k != null) {
      c();
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a.addObserver(this.m);
    a(this.mContentView);
    a();
    b();
  }
  
  protected int getContentLayoutId()
  {
    return 2131625939;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getBaseActivity();
    this.a = ((QQAppInterface)this.b.getAppInterface());
    this.e = ((ITroopRecommendHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_RECOMMEND_HANDLER));
    paramBundle = this.b.getIntent();
    this.h = paramBundle.getStringExtra("troopUin");
    this.j = paramBundle.getIntExtra("grayType", 0);
    this.i = paramBundle.getIntExtra("grayTypeSubId", 0);
    paramBundle = paramBundle.getSerializableExtra("grayUinList");
    if ((paramBundle instanceof ArrayList)) {
      this.l = ((ArrayList)paramBundle);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate mSubId ");
      paramBundle.append(this.i);
      paramBundle.append(" mTroopUin =");
      paramBundle.append(this.h);
      paramBundle.append(" mGrayTipType =");
      paramBundle.append(this.j);
      QLog.i("TroopRecommendFriendFragment", 2, paramBundle.toString());
    }
    ReportController.b(this.a, "dc00898", "", "", "0X800AD50", "0X800AD50", 0, 0, "", "", "", "");
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getBaseActivity().getString(2131886219));
    return localView;
  }
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.m);
    }
    this.a = null;
    super.onDestroy();
  }
  
  public void onStart()
  {
    super.onStart();
    CommonAdapter localCommonAdapter = this.d;
    if (localCommonAdapter != null) {
      localCommonAdapter.notifyDataSetChanged();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment
 * JD-Core Version:    0.7.0.1
 */