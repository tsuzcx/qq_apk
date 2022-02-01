package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.adapter.CommonAdapter;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopWithCommonFriendsFragment
  extends IphoneTitleBarFragment
  implements DecodeTaskCompletionListener
{
  protected static String g = "";
  static int i;
  protected IFaceDecoder a;
  protected TroopInfoManager b;
  protected int c = 0;
  protected BaseActivity d;
  protected TroopList e = new TroopList();
  protected int f = 0;
  public View h;
  protected List<CommonTroopData> j = new ArrayList();
  View.OnClickListener k = new TroopWithCommonFriendsFragment.3(this);
  View.OnClickListener l = new TroopWithCommonFriendsFragment.4(this);
  View.OnClickListener m = new TroopWithCommonFriendsFragment.5(this);
  MqqHandler n = new TroopWithCommonFriendsFragment.8(this);
  private QQAppInterface o;
  private OverScrollRecyclerView p;
  private CommonAdapter q;
  private QQProgressDialog r;
  private IntimateInfoObserver s = new TroopWithCommonFriendsFragment.6(this);
  private TroopMngObserver t = new TroopWithCommonFriendsFragment.7(this);
  
  public static void a(Context paramContext, int paramInt)
  {
    i = paramInt;
    if (paramInt == 1) {
      ReportController.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 1, 0, "0", "0", "", "");
    } else if (paramInt == 2) {
      ReportController.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 2, 0, "0", "0", "", "");
    }
    ReportController.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 0, 0, "0", "0", "", "");
    PublicFragmentActivity.a(paramContext, new Intent(), TroopWithCommonFriendsFragment.class);
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    if (this.c == 0)
    {
      int i2 = paramRecyclerView.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = paramRecyclerView.findViewHolderForAdapterPosition(i1);
        if ((localObject != null) && ((localObject instanceof TroopCommonHolder)))
        {
          localObject = (TroopCommonHolder)localObject;
          String str = ((TroopCommonHolder)localObject).j;
          if ((localObject != null) && (paramString.equals(str)))
          {
            ((TroopCommonHolder)localObject).d.setImageBitmap(paramBitmap);
            return;
          }
        }
        i1 += 1;
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.r = new QQProgressDialog(this.d, a());
    this.p = ((OverScrollRecyclerView)paramView.findViewById(2131431146));
    this.p.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.p.addOnScrollListener(new TroopWithCommonFriendsFragment.1(this));
    this.a = ((IQQAvatarService)this.o.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.o);
    this.a.setDecodeTaskCompletionListener(this);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    this.h = LayoutInflater.from(getActivity()).inflate(2131625910, paramViewGroup, false);
    paramViewGroup = (ImageView)this.h.findViewById(2131435494);
    URLDrawable localURLDrawable = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20191206115411_QbbYvjs7gs.png", null);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus())) {
      localURLDrawable.restartDownload();
    }
    paramViewGroup.setImageDrawable(localURLDrawable);
  }
  
  private void a(TroopCommonHolder paramTroopCommonHolder)
  {
    if (paramTroopCommonHolder == null) {
      return;
    }
    Object localObject = paramTroopCommonHolder.j;
    if (localObject != null)
    {
      localObject = TroopNotificationUtils.a(this.a, (String)localObject, 4);
      paramTroopCommonHolder.d.setImageDrawable((Drawable)localObject);
    }
  }
  
  private void a(ViewHolder paramViewHolder, CommonTroopData paramCommonTroopData, int paramInt)
  {
    TroopCommonHolder localTroopCommonHolder = (TroopCommonHolder)paramViewHolder;
    if ((paramCommonTroopData != null) && (!paramCommonTroopData.a.isEmpty()))
    {
      if (paramCommonTroopData.c == null) {
        return;
      }
      localTroopCommonHolder.a = paramInt;
      localTroopCommonHolder.b = paramCommonTroopData.c.troopname;
      localTroopCommonHolder.i = paramCommonTroopData.b;
      localTroopCommonHolder.j = paramCommonTroopData.a;
      if (localTroopCommonHolder.b.isEmpty()) {
        localTroopCommonHolder.b = localTroopCommonHolder.j;
      }
      paramInt = localTroopCommonHolder.i;
      paramCommonTroopData = getString(2131897503);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramCommonTroopData);
      ((StringBuilder)localObject).append(String.valueOf(paramInt));
      ((StringBuilder)localObject).append(getString(2131897502));
      paramCommonTroopData = ((StringBuilder)localObject).toString();
      localObject = getString(2131897500);
      String str = getString(2131897501);
      if (TroopWithCommonFriendsHelper.a(g, localTroopCommonHolder.j))
      {
        localTroopCommonHolder.h.setText((CharSequence)localObject);
        localTroopCommonHolder.h.setTextAppearance(this.d, 2131952365);
        localTroopCommonHolder.h.setBackgroundResource(2130839494);
        localTroopCommonHolder.h.setOnClickListener(this.m);
      }
      else
      {
        localTroopCommonHolder.h.setBackgroundDrawable(null);
        localTroopCommonHolder.h.setText(str);
        localTroopCommonHolder.h.setClickable(false);
        localTroopCommonHolder.h.setTextAppearance(this.d, 2131953504);
      }
      localTroopCommonHolder.f.setText(localTroopCommonHolder.b);
      localTroopCommonHolder.g.setText(paramCommonTroopData);
      localTroopCommonHolder.h.setTag(paramViewHolder);
      localTroopCommonHolder.f.setTag(paramViewHolder);
      localTroopCommonHolder.c.setTag(paramViewHolder);
      localTroopCommonHolder.d.setTag(paramViewHolder);
      localTroopCommonHolder.f.setOnClickListener(this.l);
      localTroopCommonHolder.d.setOnClickListener(this.k);
      a(localTroopCommonHolder);
    }
  }
  
  public static void a(String paramString)
  {
    g = paramString;
  }
  
  private void b()
  {
    this.q = new TroopWithCommonFriendsFragment.2(this, getActivity(), 2131625911);
    this.q.a(this.h);
    this.q.e(2131627871);
  }
  
  private void c()
  {
    QQAppInterface localQQAppInterface = this.o;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.addObserver(this.s);
      this.o.addObserver(this.t);
    }
  }
  
  private void d()
  {
    QQAppInterface localQQAppInterface = this.o;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.removeObserver(this.s);
      this.o.removeObserver(this.t);
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299920);
  }
  
  public String a(long paramLong)
  {
    Friends localFriends = ((FriendsManager)this.o.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(String.valueOf(paramLong));
    if (localFriends != null) {
      return localFriends.getFriendNickWithAlias();
    }
    return String.valueOf(paramLong);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.o.setHandler(getClass(), this.n);
    this.b = ((TroopInfoManager)this.o.getManager(QQManagerFactory.TROOPINFO_MANAGER));
    this.d = getBaseActivity();
    this.j = TroopWithCommonFriendsHelper.a((ArrayList)TroopWithCommonFriendsHelper.f(g), this.o);
    a(this.mContentView);
    a(paramViewGroup);
    b();
    c();
    this.p.setAdapter(this.q);
    this.q.a(this.j);
    if (i == 1)
    {
      this.r.show();
      TroopWithCommonFriendsHelper.a(Long.parseLong(g), 2, this.o);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131627884;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = getBaseActivity();
    this.o = ((QQAppInterface)this.d.getAppInterface());
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    String str1 = getString(2131897504);
    if (!g.isEmpty())
    {
      str1 = a(Long.parseLong(g));
      String str2 = getString(2131897506);
      String str3 = getString(2131897505);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append(str1);
      localStringBuilder.append(str3);
      str1 = localStringBuilder.toString();
    }
    setTitle(str1);
    return localView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      a(this.p, paramString, paramBitmap);
    }
  }
  
  public void onDestroy()
  {
    d();
    super.onDestroy();
    Object localObject = this.a;
    if (localObject != null) {
      ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(null);
    }
    localObject = this.j;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.o;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeHandler(getClass());
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.pause();
    this.a.cancelPendingRequests();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment
 * JD-Core Version:    0.7.0.1
 */