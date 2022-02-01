package com.tencent.mobileqq.activity.contact.connections;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.constant.INewFriendConstant.BaseBuilder;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ConnectsExplorationFriendAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener, SwipListView.SwipListListener
{
  protected Runnable a = new ConnectsExplorationFriendAdapter.2(this);
  int b = -1;
  protected Runnable c = new ConnectsExplorationFriendAdapter.9(this);
  private List<MayKnowRecommend> d = new ArrayList();
  private Context e;
  private QQAppInterface f;
  private MayknowRecommendManager g;
  private CTEntryMng h;
  private XListView j;
  private View k;
  private View l;
  private TextView m;
  private View n;
  private StatusManager o;
  private SwipRightMenuBuilder p;
  private boolean q = false;
  private int r;
  private int s;
  private int t;
  private boolean u = false;
  private IIconListener v = new ConnectsExplorationFriendAdapter.1(this);
  private FriendListObserver w = new ConnectsExplorationFriendAdapter.3(this);
  private CardObserver x = new ConnectsExplorationFriendAdapter.4(this);
  private Comparator<MayKnowRecommend> y = new ConnectsExplorationFriendAdapter.6(this);
  private AbsListView.OnScrollListener z = new ConnectsExplorationFriendAdapter.8(this);
  
  public ConnectsExplorationFriendAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, View paramView1, View paramView2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.e = paramContext;
    this.f = paramQQAppInterface;
    this.g = ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    paramXListView.setAdapter(this);
    this.j = paramXListView;
    this.k = paramView1;
    this.m = ((TextView)this.k.findViewById(2131432492));
    this.n = this.k.findViewById(2131434476);
    this.n.setOnClickListener(this);
    if (ThemeUtil.isNowThemeIsNight(this.f, false, null)) {
      this.n.setBackgroundResource(2130839482);
    }
    paramXListView = (ThemeImageView)this.k.findViewById(2131434471);
    paramXListView.setSupportMaskView(true);
    paramXListView.setMaskShape(ThemeImageWrapper.MODE_SQURE);
    this.l = paramView2;
    this.o = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.o.a(this.v);
    a(this.z);
    this.f.addObserver(this.w);
    this.f.addObserver(this.x);
    this.p = a(paramContext);
    this.q = paramBoolean;
    this.r = paramInt1;
    this.s = paramInt2;
    this.h = ((CTEntryMng)paramQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG));
    this.g = ((MayknowRecommendManager)this.f.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    if (this.s == 0) {
      a(true);
    }
    paramContext = this.j;
    if (paramContext != null)
    {
      paramContext.removeCallbacks(this.c);
      this.j.postDelayed(this.c, 1000L);
    }
  }
  
  private URLDrawable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    }
    if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
    }
    localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDrawable downLoadUrl ->");
      localStringBuilder.append(paramString);
      QLog.d("ConnectsExplorationFriendAdapter", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (paramView.findViewById(2131444905) == null) {
        return;
      }
      paramView = paramView.findViewById(2131444905);
      Object localObject = paramView.getTag(2131435571);
      if ((localObject == null) || (!(localObject instanceof Boolean)) || (((Boolean)localObject).booleanValue() != paramBoolean))
      {
        paramView.setTag(2131435571, Boolean.valueOf(paramBoolean));
        if (paramBoolean)
        {
          paramView.setBackgroundResource(2130839579);
          return;
        }
        if (ThemeUtil.isDefaultTheme())
        {
          paramView.setBackgroundResource(2130839577);
          return;
        }
        paramView.setBackgroundResource(2130839574);
      }
    }
  }
  
  private void a(ConnectsExplorationFriendAdapter.BannerViewHolder paramBannerViewHolder)
  {
    if (!ThemeUtil.isNowThemeIsNight(this.f, false, null))
    {
      paramBannerViewHolder.d.setBackgroundResource(2130839481);
      paramBannerViewHolder.a.setTextColor(Color.parseColor("#12B7F5"));
      paramBannerViewHolder.b.setTextColor(Color.parseColor("#7F12B7F5"));
      paramBannerViewHolder.c.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_DVTS7XhGQJ.png"));
      return;
    }
    paramBannerViewHolder.d.setBackgroundResource(2130839482);
    paramBannerViewHolder.a.setTextColor(Color.argb(102, 255, 255, 255));
    paramBannerViewHolder.b.setTextColor(Color.argb(102, 255, 255, 255));
    paramBannerViewHolder.c.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_9H32GY0LpT.png"));
  }
  
  protected View a(Context paramContext, int paramInt, ConnectsExplorationFriendAdapter.BannerViewHolder paramBannerViewHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.p.createView(paramContext, localView, paramBannerViewHolder, -1);
  }
  
  protected View a(Context paramContext, int paramInt, ConnectsExplorationFriendAdapter.RecFriendViewHolder paramRecFriendViewHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.p.createView(paramContext, localView, paramRecFriendViewHolder, -1);
  }
  
  protected SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131299607);
    int i1 = paramContext.getResources().getDimensionPixelSize(2131299608);
    paramContext = INewFriendConstant.BaseBuilder.c;
    int[] arrayOfInt1 = INewFriendConstant.BaseBuilder.a;
    int[] arrayOfInt2 = INewFriendConstant.BaseBuilder.b;
    return new ConnectsExplorationFriendAdapter.5(this, 1, 2, new int[] { i, i1 }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a()
  {
    if (this.s != 0) {
      a(true);
    }
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.p;
    int i;
    if (localSwipRightMenuBuilder != null) {
      i = localSwipRightMenuBuilder.updateRightMenuView(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);
    } else {
      i = 0;
    }
    int i1 = paramView.getScrollX();
    if ((paramInt >= 0) && (this.b == paramInt))
    {
      paramView.scrollTo(i, 0);
      return;
    }
    if (i1 != 0) {
      paramView.scrollTo(0, 0);
    }
  }
  
  public void a(TextView paramTextView, MayKnowRecommend paramMayKnowRecommend)
  {
    if (paramMayKnowRecommend == null) {
      return;
    }
    Object localObject = paramMayKnowRecommend.getDisplayName(this.g.m());
    if ((!TextUtils.isEmpty(paramMayKnowRecommend.mobile_name)) && (!((String)localObject).equals(paramMayKnowRecommend.mobile_name)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(paramMayKnowRecommend.mobile_name);
      ((StringBuilder)localObject).append(")");
      paramTextView.setText(((StringBuilder)localObject).toString());
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  public void a(List<MayKnowRecommend> paramList)
  {
    this.d = paramList;
    if (this.d == null) {
      this.d = new ArrayList();
    }
    if (this.q) {
      b(false);
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reloadRecommendData ");
      localStringBuilder.append(this.r);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ConnectsExplorationFriendAdapter", 2, localStringBuilder.toString());
    }
    if ((this.r != 23) && (this.h.e()))
    {
      this.l.setVisibility(8);
      this.k.setVisibility(0);
      this.m.setText(2131897064);
      this.n.setVisibility(0);
      ReportController.b(this.f, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "2", "", "", "");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ConnectsExplorationFriendAdapter.7(this, paramBoolean));
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume firstVisible: ");
      localStringBuilder.append(this.j.getFirstVisiblePosition());
      localStringBuilder.append(" lastvisible: ");
      localStringBuilder.append(this.j.getLastVisiblePosition());
      QLog.d("ConnectsExplorationFriendAdapter", 2, localStringBuilder.toString());
    }
    if (this.q) {
      b(true);
    }
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("userInfoState ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ConnectsExplorationFriendAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ((FriendsManager)this.f.getManager(QQManagerFactory.FRIENDS_MANAGER)).g(this.f.getCurrentAccountUin());
    ArrayList localArrayList = ((BusinessCardManager)this.f.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).b();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      if (((MayKnowRecommend)localIterator.next() instanceof ConnectsExplorationBanner)) {
        localIterator.remove();
      }
    }
    if ((TextUtils.isEmpty(((Card)localObject).strSchool)) && ((localArrayList == null) || (localArrayList.isEmpty())))
    {
      localObject = new ConnectsExplorationBanner();
      ((ConnectsExplorationBanner)localObject).setBanner(true);
      if (this.d.size() == 0) {
        return false;
      }
      if (this.d.size() <= 4) {
        this.d.add(localObject);
      } else {
        this.d.add(4, localObject);
      }
    }
    if (paramBoolean) {
      notifyDataSetChanged();
    }
    return true;
  }
  
  public void c()
  {
    this.o.b(this.v);
    if (this.i != null) {
      this.i.destory();
    }
    a(null);
    this.f.removeObserver(this.w);
    this.f.removeObserver(this.x);
    XListView localXListView = this.j;
    if (localXListView != null) {
      localXListView.removeCallbacks(this.a);
    }
  }
  
  public void d()
  {
    Object localObject = this.j;
    if ((localObject != null) && (((XListView)localObject).isShown()) && (!this.d.isEmpty()))
    {
      this.j.removeCallbacks(this.c);
      int i1 = this.j.getFirstVisiblePosition();
      int i2 = this.j.getLastVisiblePosition();
      localObject = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int i = i1;
      while (i <= i2)
      {
        if ((i >= 0) && (i < this.d.size()) && (this.d.get(i) != null) && (!(this.d.get(i) instanceof ConnectsExplorationBanner)))
        {
          ((ArrayList)localObject).add(((MayKnowRecommend)this.d.get(i)).uin);
          localArrayList1.add(((MayKnowRecommend)this.d.get(i)).recommendReason);
          localArrayList2.add(Integer.valueOf(i));
          localArrayList3.add(((MayKnowRecommend)this.d.get(i)).algBuffer);
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportRecommendFrdExpose firstVisibleItem: ");
        localStringBuilder.append(i1);
        localStringBuilder.append(" lastVisibleItem: ");
        localStringBuilder.append(i2);
        localStringBuilder.append(" exp_uins: ");
        localStringBuilder.append(localObject);
        localStringBuilder.append(" exp_reasons:");
        localStringBuilder.append(localArrayList1);
        localStringBuilder.append(" exp_positions:");
        localStringBuilder.append(localArrayList2);
        localStringBuilder.append(" algh_ids:");
        localStringBuilder.append(localArrayList3);
        QLog.d("ConnectsExplorationFriendAdapter", 2, localStringBuilder.toString());
      }
      if (!((ArrayList)localObject).isEmpty()) {
        ContactReportUtils.a(this.f, this.r, (ArrayList)localObject, localArrayList1, localArrayList2, localArrayList3, 0, "4");
      }
    }
  }
  
  public int getCount()
  {
    return this.d.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.d.size())) {
      return this.d.get(paramInt);
    }
    return new MayKnowRecommend();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(paramInt);
    Object localObject1;
    if ((localMayKnowRecommend instanceof ConnectsExplorationBanner))
    {
      localObject1 = new ConnectsExplorationFriendAdapter.BannerViewHolder();
      paramView = a(this.e, 2131627873, (ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1);
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).c = ((ImageView)paramView.findViewById(2131436281));
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).b = ((TextView)paramView.findViewById(2131448460));
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).a = ((TextView)paramView.findViewById(2131448814));
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).d = ((Button)paramView.findViewById(2131429812));
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).d.setOnClickListener(this);
      paramView.setTag(localObject1);
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).updateItemBgKeepPadding(((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).leftView, false);
      a((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.e, paramView, paramInt, localMayKnowRecommend, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject1, this);
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).leftView.setTag(localMayKnowRecommend);
      paramView.setOnClickListener(this);
      ((ConnectsExplorationFriendAdapter.BannerViewHolder)localObject1).leftView.setOnClickListener(this);
      ReportController.b(this.f, "dc00898", "", "", "frd_list", "info_add_exp", 2, 0, "", "", "", "");
      localObject1 = null;
    }
    for (;;)
    {
      break;
      if ((paramView != null) && ((paramView.getTag() instanceof ConnectsExplorationFriendAdapter.RecFriendViewHolder)))
      {
        localObject1 = (ConnectsExplorationFriendAdapter.RecFriendViewHolder)paramView.getTag();
      }
      else
      {
        localObject1 = new ConnectsExplorationFriendAdapter.RecFriendViewHolder();
        paramView = a(this.e, 2131627872, (ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).f = ((TextView)paramView.findViewById(2131438023));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).e = ((TroopLabelLayout)paramView.findViewById(2131448010));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).e.setLabelType(1);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).A = ((ImageView)paramView.findViewById(2131427337));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).a = ((TextView)paramView.findViewById(2131439320));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b = ((Button)paramView.findViewById(2131444718));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).c = ((TextView)paramView.findViewById(2131444726));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).g = ((TextView)paramView.findViewById(2131446568));
        paramView.setTag(localObject1);
        if ((((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).A instanceof ThemeImageView)) {
          ((ThemeImageView)((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).A).setSupportMaskView(true);
        }
        ((INewFriendApi)QRoute.api(INewFriendApi.class)).updateItemBgKeepPadding(((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).leftView, false);
      }
    }
    if (localObject1 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(512);
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).y = localMayKnowRecommend.uin;
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).d = localMayKnowRecommend;
      Object localObject2 = localMayKnowRecommend.getDisplayName(this.g.m());
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).a.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).a.setText((CharSequence)localObject2);
        if (AppSetting.e) {
          localStringBuilder.append((String)localObject2);
        }
      }
      else
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).a.setVisibility(8);
      }
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.e, paramView, paramInt, localMayKnowRecommend, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject1, this);
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).leftView.setTag(localMayKnowRecommend);
      localObject2 = new StringBuilder();
      if (!TextUtils.isEmpty(localMayKnowRecommend.category))
      {
        ((StringBuilder)localObject2).append(localMayKnowRecommend.category);
        ((StringBuilder)localObject2).append(" ");
      }
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        ((StringBuilder)localObject2).append(localMayKnowRecommend.recommendReason);
      }
      localObject2 = ((StringBuilder)localObject2).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).f.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).f.setText((CharSequence)localObject2);
        if (AppSetting.e)
        {
          localStringBuilder.append(",");
          localStringBuilder.append((String)localObject2);
        }
      }
      else
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).f.setVisibility(8);
      }
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).e.a(RecommendLabel.convertToRecommendLabel(localMayKnowRecommend.msgLabel), localMayKnowRecommend.gender, localMayKnowRecommend.age);
      if (localMayKnowRecommend.friendStatus == 0)
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setOnClickListener(this);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setTag(localMayKnowRecommend);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setText(HardCodeUtil.a(2131886199));
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).c.setVisibility(8);
        if (AppSetting.e)
        {
          localStringBuilder.append(",点击添加");
          ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setContentDescription(HardCodeUtil.a(2131886199));
        }
      }
      else if (localMayKnowRecommend.friendStatus == 1)
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setVisibility(8);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).c.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).c.setText(2131915704);
        if (AppSetting.e)
        {
          localStringBuilder.append(",等待验证");
          ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).c.setContentDescription(this.e.getResources().getString(2131915704));
        }
      }
      else
      {
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).b.setVisibility(8);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).c.setVisibility(0);
        ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).c.setText(2131886630);
        if (AppSetting.e)
        {
          localStringBuilder.append(",已添加");
          ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).c.setContentDescription(this.e.getResources().getString(2131886630));
        }
      }
      if (AppSetting.e) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      paramView.setOnClickListener(this);
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).leftView.setOnClickListener(this);
      ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).A.setImageBitmap(a(1, ((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).y));
      a(paramView, localMayKnowRecommend.bHighLight);
      a(((ConnectsExplorationFriendAdapter.RecFriendViewHolder)localObject1).g, localMayKnowRecommend);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    int i = 1;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    switch (i1)
    {
    default: 
      break;
    case 2131444905: 
      localObject1 = (MayKnowRecommend)paramView.getTag();
      if ((localObject1 instanceof ConnectsExplorationBanner))
      {
        ReportController.b(this.f, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
        localObject1 = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
        paramView.getContext().startActivity((Intent)localObject1);
      }
      else if (localObject1 != null)
      {
        localObject2 = (FriendsManager)this.f.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((localObject2 == null) || (!((FriendsManager)localObject2).n(((MayKnowRecommend)localObject1).uin))) {
          i = 110;
        }
        localObject2 = new AllInOne(((MayKnowRecommend)localObject1).uin, i);
        localObject3 = ((MayKnowRecommend)localObject1).getRecommendName(this.g.m());
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((AllInOne)localObject2).recommendName = ((String)localObject3);
        }
        if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
          ((AllInOne)localObject2).nickname = ((MayKnowRecommend)localObject1).nick;
        }
        ((AllInOne)localObject2).profileEntryType = 88;
        localObject3 = ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel);
        Bundle localBundle = new Bundle();
        localBundle.putString("recommend_entry_type", "4");
        localBundle.putInt("key_display_type", 0);
        localBundle.putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
        localBundle.putInt("recommend_pos", this.d.indexOf(localObject1));
        localBundle.putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
        localBundle.putString("recommend_label", (String)localObject3);
        localBundle.putInt("tabID", this.r);
        ProfileActivity.a(this.e, (AllInOne)localObject2, localBundle);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onClick_ open profile item uin = ");
          ((StringBuilder)localObject2).append(((MayKnowRecommend)localObject1).uin);
          QLog.d("ConnectsExplorationFriendAdapter", 2, ((StringBuilder)localObject2).toString());
        }
        ContactReportUtils.a(this.f, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", this.r, 0, ((MayKnowRecommend)localObject1).recommendReason, this.d.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, (String)localObject3, 0, "4");
      }
      break;
    case 2131444718: 
      localObject1 = (MayKnowRecommend)paramView.getTag();
      if (localObject1 != null)
      {
        localObject2 = (FriendsManager)this.f.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((!((FriendsManager)localObject2).n(((MayKnowRecommend)localObject1).uin)) && (!((FriendsManager)localObject2).v(((MayKnowRecommend)localObject1).uin)))
        {
          boolean bool = ((Activity)this.e).getIntent().getBooleanExtra("from_babyq", false);
          localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(this.g.m());
          i = this.r;
          localObject2 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.e, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, i, (String)localObject2, null, null, this.e.getString(2131886199), null);
          ((Intent)localObject2).putExtra("key_param_age_area", ProfileCardUtil.a(this.e, ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age, ((MayKnowRecommend)localObject1).country, ((MayKnowRecommend)localObject1).province, ((MayKnowRecommend)localObject1).city));
          ((Intent)localObject2).putExtra("from_babyq", bool);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend((BaseActivity)this.e, (Intent)localObject2);
        }
        else if (((FriendsManager)localObject2).n(((MayKnowRecommend)localObject1).uin))
        {
          ((MayKnowRecommend)localObject1).friendStatus = 2;
          notifyDataSetChanged();
        }
        else
        {
          ((MayKnowRecommend)localObject1).friendStatus = 1;
          notifyDataSetChanged();
        }
        ContactReportUtils.a(this.f, ((MayKnowRecommend)localObject1).uin, "frd_list_add", this.r, 1, ((MayKnowRecommend)localObject1).recommendReason, this.d.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0, "4");
      }
      break;
    case 2131438111: 
      if (!NetworkUtil.isNetworkAvailable(this.e))
      {
        localObject1 = this.e;
        QQToast.makeText((Context)localObject1, ((Context)localObject1).getResources().getString(2131889169), 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      }
      else
      {
        localObject1 = (MayKnowRecommend)paramView.getTag();
        if (localObject1 != null)
        {
          localObject2 = ((MayKnowRecommend)localObject1).uin;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("onClick_ delete item uin = ");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("ConnectsExplorationFriendAdapter", 2, ((StringBuilder)localObject3).toString());
          }
          ((FriendListHandler)this.f.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend((String)localObject2);
          this.d.remove(localObject1);
          notifyDataSetChanged();
          ContactReportUtils.a(this.f, (String)localObject2, "frd_list_dlt", this.r, 0, ((MayKnowRecommend)localObject1).recommendReason, this.d.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel), 0, "4");
        }
      }
      break;
    case 2131434476: 
      if (NetworkUtil.isNetSupport(this.e))
      {
        ReportController.b(this.f, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "2", "", "", "");
        this.h.b(true);
      }
      else
      {
        localObject1 = this.e;
        QQToast.makeText((Context)localObject1, ((Context)localObject1).getResources().getString(2131889169), 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      }
      break;
    case 2131429812: 
      ReportController.b(this.f, "dc00898", "", "", "frd_list", "info_add_clk", 2, 0, "", "", "", "");
      localObject1 = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
      paramView.getContext().startActivity((Intent)localObject1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    this.b = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter
 * JD-Core Version:    0.7.0.1
 */