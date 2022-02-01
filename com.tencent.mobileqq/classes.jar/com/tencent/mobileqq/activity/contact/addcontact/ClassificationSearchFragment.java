package com.tencent.mobileqq.activity.contact.addcontact;

import addcontacts.AccountSearchPb.record;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.GridView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class ClassificationSearchFragment
  extends SearchBaseFragment
{
  private static SearchResult A;
  private static boolean D = false;
  private static int E;
  private int B;
  private boolean C;
  private int F;
  private ClassificationSearchFragment.HistoryGridAdapter G;
  private ClassificationSearchFragment.SearchResultAdapter H;
  int a = 0;
  int b = 0;
  boolean c;
  private View x;
  private View y;
  private List<AccountSearchPb.record> z = new ArrayList(20);
  
  public static ClassificationSearchFragment a(int paramInt)
  {
    E = paramInt;
    return new ClassificationSearchFragment();
  }
  
  public static ClassificationSearchFragment a(SearchResult paramSearchResult)
  {
    A = paramSearchResult;
    return new ClassificationSearchFragment();
  }
  
  private String c(SearchBaseFragment.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramrecord.uin.get());
    ((StringBuilder)localObject1).append("");
    paramItemViewHolder.f = ((StringBuilder)localObject1).toString();
    paramItemViewHolder.g = paramrecord.mobile.get();
    if (paramrecord.uin.get() != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    paramItemViewHolder.h = bool;
    paramItemViewHolder.b.setText(a(paramItemViewHolder.j, paramrecord.name.get()));
    localStringBuilder.append(paramItemViewHolder.b.getText());
    Object localObject2;
    if (paramItemViewHolder.j == 80000000)
    {
      localObject2 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject2).append("(");
      if (paramItemViewHolder.h) {
        localObject1 = paramItemViewHolder.f;
      } else {
        localObject1 = paramItemViewHolder.g;
      }
      ((SpannableStringBuilder)localObject2).append(a(80000000, (String)localObject1));
      ((SpannableStringBuilder)localObject2).append(")");
      paramItemViewHolder.c.setText((CharSequence)localObject2);
      if ((!TextUtils.isEmpty(paramItemViewHolder.f)) && (Utils.c(paramItemViewHolder.f)))
      {
        localObject1 = this.r.getApp().getResources();
        Drawable localDrawable = ((Resources)localObject1).getDrawable(2130842755);
        localDrawable.setBounds(0, 0, AIOUtils.b(15.0F, (Resources)localObject1), AIOUtils.b(15.0F, (Resources)localObject1));
        ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
        paramItemViewHolder.c.setCompoundDrawables(null, null, localDrawable, null);
      }
      else
      {
        paramItemViewHolder.c.setCompoundDrawables(null, null, null, null);
      }
      i = paramrecord.uint32_richflag1_59.get();
      j = paramrecord.uint32_richflag4_409.get();
      PrettyAccountUtil.a("0X800B238", i, j);
      localObject1 = PrettyAccountUtil.a(i, j, (CharSequence)localObject2, paramItemViewHolder.f);
      paramItemViewHolder.c.setText((CharSequence)localObject1);
      PrettyAccountUtil.a(paramItemViewHolder.c, i, j, 2131168119, 17);
      localStringBuilder.append(paramItemViewHolder.c.getText());
    }
    int i = this.f;
    if (i != 0)
    {
      if (i == 2) {
        localStringBuilder.append(b(paramItemViewHolder, paramrecord));
      }
    }
    else {
      localStringBuilder.append(a(paramItemViewHolder, paramrecord));
    }
    localObject1 = this.m;
    boolean bool = paramItemViewHolder.h;
    int j = 11;
    if (bool) {
      i = 1;
    } else {
      i = 11;
    }
    if (paramItemViewHolder.h) {
      paramrecord = paramItemViewHolder.f;
    } else {
      paramrecord = paramItemViewHolder.g;
    }
    localObject1 = ((IFaceDecoder)localObject1).getBitmapFromCache(i, paramrecord);
    paramrecord = (AccountSearchPb.record)localObject1;
    if (localObject1 == null)
    {
      localObject1 = ImageUtil.k();
      paramrecord = (AccountSearchPb.record)localObject1;
      if (!this.m.isPausing())
      {
        localObject2 = this.m;
        if (paramItemViewHolder.h) {
          paramrecord = paramItemViewHolder.f;
        } else {
          paramrecord = paramItemViewHolder.g;
        }
        i = j;
        if (paramItemViewHolder.h) {
          i = 1;
        }
        ((IFaceDecoder)localObject2).requestDecodeFace(paramrecord, i, true, (byte)1);
        paramrecord = (AccountSearchPb.record)localObject1;
      }
    }
    paramItemViewHolder.a.setImageBitmap(paramrecord);
    return localStringBuilder.toString();
  }
  
  private void c(int paramInt)
  {
    this.a = paramInt;
    ClassificationSearchFragment.SearchResultAdapter localSearchResultAdapter = this.H;
    if (localSearchResultAdapter != null) {
      localSearchResultAdapter.notifyDataSetChanged();
    }
  }
  
  private boolean c(ArrayList<SearchResult> paramArrayList)
  {
    if ((!this.g) && (paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = ((SearchResult)paramArrayList.get(0)).e;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        a(((SearchResult)paramArrayList.get(0)).a, (AccountSearchPb.record)localObject, 2);
        return true;
      }
    }
    return false;
  }
  
  protected void a()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isGetMore = ");
      ((StringBuilder)localObject1).append(this.g);
      ((StringBuilder)localObject1).append(" mListData is null = ");
      boolean bool;
      if (this.z == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      QLog.d("ClassificationSearchFragment", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!this.g) && (this.z == null))
    {
      j();
      return;
    }
    Object localObject2;
    int i;
    if (this.H == null)
    {
      this.H = new ClassificationSearchFragment.SearchResultAdapter(this, null);
      this.H.a(this.z);
      localObject1 = this.x;
      localObject2 = new StringBuilder();
      if (this.f == 0) {
        i = 2131900137;
      } else {
        i = 2131900143;
      }
      ((StringBuilder)localObject2).append(HardCodeUtil.a(i));
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131900139));
      ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      this.k.addHeaderView(this.x);
      this.k.setAdapter(this.H);
      this.i = this.H;
    }
    if (this.j.getChildAt(0) != this.k)
    {
      this.j.removeAllViews();
      this.j.addView(this.k);
    }
    if (this.g) {
      this.H.a().addAll(this.z);
    } else {
      this.H.a(this.z);
    }
    this.H.notifyDataSetChanged();
    if (this.h)
    {
      this.h = false;
      this.k.setSelection(0);
    }
    if ((this.f == 2) && (this.z != null))
    {
      localObject1 = new StringBuilder();
      localObject2 = this.z.iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append(String.valueOf(((AccountSearchPb.record)((Iterator)localObject2).next()).uin.get()));
        ((StringBuilder)localObject1).append("#");
        i += 1;
      }
      localObject2 = ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).buildSearchID(this.r.getCurrentAccountUin(), this.e);
      ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).setAttrSearchPage((String)localObject2, this.e, 3, true, i, ((StringBuilder)localObject1).toString());
    }
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    c(3);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (this.g)
    {
      if (UniteSearchActivity.f == 12) {
        this.t.a(this.e, this.B, 0.0D, 0.0D, 1);
      } else if (E == ClassificationSearchActivity.k) {
        this.t.a(this.e, this.B, 0.0D, 0.0D, 2);
      } else {
        this.t.a(this.e, this.B, 0.0D, 0.0D, 0);
      }
    }
    else if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      l();
      this.e = paramString;
      this.t.c();
      if (UniteSearchActivity.f == 12) {
        this.t.a(this.e, this.B, 0.0D, 0.0D, 1);
      } else if (E == ClassificationSearchActivity.k) {
        this.t.a(this.e, this.B, 0.0D, 0.0D, 2);
      } else {
        this.t.a(this.e, this.B, 0.0D, 0.0D, 0);
      }
      this.h = true;
    }
    else
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 2131892104, 0).show(i());
      c(4);
    }
    if (this.f == 2)
    {
      paramString = getBaseActivity();
      if ((paramString != null) && ((paramString instanceof SearchBaseActivity)))
      {
        int i = ((SearchBaseActivity)paramString).f();
        int j = this.t.d();
        paramString = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        QQAppInterface localQQAppInterface = this.r;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(j + 1);
        paramString.publicAccountReportClickEventForMigrate(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, localStringBuilder.toString(), SearchBaseActivity.JumpSrcConstants.a(i), this.e, "", false);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  protected boolean a(ArrayList<SearchResult> paramArrayList)
  {
    SearchResult localSearchResult = (SearchResult)paramArrayList.get(0);
    if (c(paramArrayList))
    {
      this.C = true;
      return false;
    }
    if (this.v != null) {
      this.v.post(new ClassificationSearchFragment.1(this, localSearchResult));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("is no more page  = ");
      localStringBuilder.append(localSearchResult.c);
      QLog.d("ClassificationSearchFragment", 2, localStringBuilder.toString());
    }
    this.z = localSearchResult.e;
    if (!this.g) {
      g();
    }
    b(paramArrayList);
    return true;
  }
  
  void b()
  {
    if (this.a == 1)
    {
      c(2);
      a(this.e, true);
    }
  }
  
  public void b(int paramInt)
  {
    this.F = paramInt;
  }
  
  protected void c()
  {
    if (this.a == 2) {
      c(0);
    }
  }
  
  public boolean d()
  {
    return this.C;
  }
  
  @TargetApi(9)
  public void e()
  {
    super.e();
    if ((this.j != null) && (this.f == 2))
    {
      if (this.y == null)
      {
        this.y = LayoutInflater.from(getBaseActivity()).inflate(2131625654, null);
        localObject = (GridView)this.y.findViewById(2131445427);
        if (Build.VERSION.SDK_INT > 8) {
          ((GridView)localObject).setOverScrollMode(2);
        }
        ((GridView)localObject).setNumColumns(4);
        ((GridView)localObject).setStretchMode(2);
        ((GridView)localObject).setVerticalSpacing(AIOUtils.b(20.0F, getResources()));
        ((GridView)localObject).setAdapter(this.G);
      }
      this.j.addView(this.y);
      this.j.setClickable(false);
      Object localObject = this.G;
      if ((localObject != null) && (((ClassificationSearchFragment.HistoryGridAdapter)localObject).getCount() > 0))
      {
        this.y.setVisibility(0);
        localObject = this.G.b();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          ((TextView)this.y.findViewById(2131445430)).setText(getString(2131892981));
        } else {
          ((TextView)this.y.findViewById(2131445430)).setText((CharSequence)localObject);
        }
      }
      else
      {
        this.y.setVisibility(8);
      }
      localObject = this.G;
      if ((localObject != null) && (((ClassificationSearchFragment.HistoryGridAdapter)localObject).c() != null) && (!ClassificationSearchFragment.HistoryGridAdapter.a(this.G))) {
        this.G.a(false);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null)
    {
      boolean bool = localObject1 instanceof SearchBaseFragment.ItemViewHolder;
      Object localObject2 = "";
      Object localObject3;
      int i;
      Object localObject5;
      Object localObject4;
      Object localObject6;
      if (bool)
      {
        localObject3 = (SearchBaseFragment.ItemViewHolder)localObject1;
        a(((SearchBaseFragment.ItemViewHolder)localObject3).j, ((SearchBaseFragment.ItemViewHolder)localObject3).k, 2);
        i = ((SearchBaseFragment.ItemViewHolder)localObject3).m;
        int j = ((SearchBaseFragment.ItemViewHolder)localObject3).j;
        int k = ((SearchBaseFragment.ItemViewHolder)localObject3).m;
        if (((SearchBaseFragment.ItemViewHolder)localObject3).k.uin != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((SearchBaseFragment.ItemViewHolder)localObject3).k.uin.get());
          ((StringBuilder)localObject1).append("");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = null;
        }
        SearchUtils.a(j, 0, k, false, (String)localObject1, this.e, UniteSearchActivity.f);
        if (((SearchBaseFragment.ItemViewHolder)localObject3).j == 80000002)
        {
          localObject5 = ((SearchBaseFragment.ItemViewHolder)localObject3).k;
          localObject1 = getBaseActivity();
          if ((localObject1 != null) && ((localObject1 instanceof ClassificationSearchActivity)))
          {
            localObject4 = SearchBaseActivity.JumpSrcConstants.a(((SearchBaseActivity)localObject1).f());
            localObject1 = paramView.getTag(2131437943);
            if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
              ((SearchBaseFragment.ItemViewHolder)localObject3).m = (((Integer)localObject1).intValue() + 1);
            }
            localObject6 = (IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class);
            if (((AccountSearchPb.record)localObject5).uin != null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((AccountSearchPb.record)localObject5).uin.get());
              ((StringBuilder)localObject1).append("");
              localObject1 = ((StringBuilder)localObject1).toString();
            }
            else
            {
              localObject1 = "";
            }
            ((IPublicAccountDetailReportUtil)localObject6).setAttrSearchClick(3, (String)localObject1, i, UniteSearchActivity.f);
            if (UniteSearchActivity.f == 12)
            {
              localObject6 = this.r;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((SearchBaseFragment.ItemViewHolder)localObject3).m);
              ((StringBuilder)localObject1).append("");
              localObject3 = ((StringBuilder)localObject1).toString();
              localObject1 = localObject2;
              if (((AccountSearchPb.record)localObject5).uin != null)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(((AccountSearchPb.record)localObject5).uin.get());
                ((StringBuilder)localObject1).append("");
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              ReportController.b((AppRuntime)localObject6, "CliOper", "", "", "0X800658B", "0X800658B", 0, 1, 0, (String)localObject3, (String)localObject4, (String)localObject1, this.e);
            }
            else
            {
              localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
              localObject6 = this.r;
              if (((AccountSearchPb.record)localObject5).uin != null)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(((AccountSearchPb.record)localObject5).uin.get());
                ((StringBuilder)localObject1).append("");
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              else
              {
                localObject1 = "";
              }
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append(((SearchBaseFragment.ItemViewHolder)localObject3).m);
              ((StringBuilder)localObject5).append("");
              ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate((AppInterface)localObject6, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005D22", "0X8005D22", 0, 0, ((StringBuilder)localObject5).toString(), (String)localObject4, this.e, "", false);
            }
          }
        }
      }
      else if ((localObject1 instanceof ClassificationSearchFragment.MoreViewHolder))
      {
        i = this.a;
        if ((i == 3) || (i == 4)) {
          if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
          {
            c(1);
          }
          else
          {
            QQToast.makeText(BaseApplicationImpl.getContext(), 2131892104, 0).show(i());
            c(4);
          }
        }
      }
      else if ((localObject1 instanceof SearchBaseFragment.ArticleItemViewHolder))
      {
        localObject1 = (SearchBaseFragment.ArticleItemViewHolder)localObject1;
        localObject2 = new Intent(this.s, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((SearchBaseFragment.ArticleItemViewHolder)localObject1).f);
        if (UniteSearchActivity.f == 1)
        {
          ((Intent)localObject2).putExtra("articalChannelId", 10);
        }
        else if (UniteSearchActivity.f == 2)
        {
          ((Intent)localObject2).putExtra("articalChannelId", 11);
        }
        else
        {
          i = this.F;
          if (i == 14) {
            ((Intent)localObject2).putExtra("articalChannelId", 14);
          } else if (i == 13) {
            ((Intent)localObject2).putExtra("articalChannelId", 12);
          } else if (i == 15) {
            ((Intent)localObject2).putExtra("articalChannelId", 13);
          }
        }
        this.s.startActivity((Intent)localObject2);
        if (UniteSearchActivity.f == 12)
        {
          localObject2 = this.r;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(((SearchBaseFragment.ArticleItemViewHolder)localObject1).g);
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject4 = this.e;
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("");
          ((StringBuilder)localObject5).append(((SearchBaseFragment.ArticleItemViewHolder)localObject1).h);
          ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X800658C", "0X800658C", 0, 0, (String)localObject3, "", (String)localObject4, ((StringBuilder)localObject5).toString());
        }
        else
        {
          localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          localObject3 = this.r;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("");
          ((StringBuilder)localObject4).append(((SearchBaseFragment.ArticleItemViewHolder)localObject1).g);
          localObject4 = ((StringBuilder)localObject4).toString();
          localObject5 = this.e;
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("");
          ((StringBuilder)localObject6).append(((SearchBaseFragment.ArticleItemViewHolder)localObject1).h);
          ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate((AppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D97", "0X8005D97", 0, 0, (String)localObject4, "", (String)localObject5, ((StringBuilder)localObject6).toString(), false);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.x == null)
    {
      this.x = o().getLayoutInflater().inflate(2131624969, this.k, false);
      this.x.setClickable(false);
      this.x.setFocusable(true);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ClassificationSearchFragment.HistoryGridAdapter localHistoryGridAdapter = this.G;
    if (localHistoryGridAdapter != null) {
      localHistoryGridAdapter.a();
    }
    ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).backPage();
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseByTag(36);
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(36);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = A;
    if (paramView != null)
    {
      c(paramView.c ^ true);
      this.z.addAll(A.e);
      this.t.a(A.b);
      if (ViewFactory.b(A.a) == 2131886308) {
        ((TextView)this.x.findViewById(2131447463)).setText(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.r, BaseApplicationImpl.getContext()));
      } else {
        ((TextView)this.x.findViewById(2131447463)).setText(ViewFactory.b(A.a));
      }
      if ((this.q.size() == 0) && (this.z.size() > 0))
      {
        paramView = new ArrayList();
        paramView.add(A);
        b(paramView);
      }
      A = null;
      a();
    }
    else
    {
      if ((E != ClassificationSearchActivity.k) && (E != ClassificationSearchActivity.l))
      {
        if ((E == ClassificationSearchActivity.m) || (E == ClassificationSearchActivity.o)) {
          ((TextView)this.x.findViewById(2131447463)).setText(ViewFactory.b(80000002));
        }
      }
      else {
        ((TextView)this.x.findViewById(2131447463)).setText(ViewFactory.b(80000003));
      }
      if (QLog.isColorLevel()) {
        QLog.d("ClassificationSearchFragment", 2, "searchResult is null");
      }
      j();
    }
    this.B = n();
    if ((this.f == 2) && (this.G == null)) {
      this.G = new ClassificationSearchFragment.HistoryGridAdapter(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment
 * JD-Core Version:    0.7.0.1
 */