package com.tencent.mobileqq.activity.contact.addcontact;

import addcontacts.AccountSearchPb.ResultItem;
import addcontacts.AccountSearchPb.hotwordrecord;
import addcontacts.AccountSearchPb.record;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
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
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchHistoryManager;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView.IGroupSearchContext;
import com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopListWrapperForSearchEmpty;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.search.util.ReportUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.mobileqq.troop.recommend.RecommendTroopListWrapper;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class SearchContactsFragment
  extends SearchBaseFragment
{
  private static int E = -1;
  SearchContactsFragment.JumpListener A;
  private double B = 0.0D;
  private double C = 0.0D;
  private ArrayList<SearchResult> D;
  private String F = null;
  private String G = "";
  private String H = "";
  private Map<Integer, Integer> I = new ConcurrentHashMap();
  private String J;
  private int K = 2;
  private RecommendTroopListWrapper L;
  private GroupSearchRecommendView M;
  private ViewFactory.GuideView N;
  private SearchContactsFragment.SearchResultAdapter O;
  boolean a;
  int b;
  boolean c = true;
  protected SosoInterfaceOnLocationListener x = null;
  GroupSearchRecommendView.IGroupSearchContext y = new SearchContactsFragment.2(this);
  ArrayList<SearchContactsFragment.ListItemData> z;
  
  public SearchContactsFragment()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.x);
  }
  
  public static SearchContactsFragment a(int paramInt)
  {
    E = paramInt;
    return new SearchContactsFragment();
  }
  
  private void a(SearchBaseFragment.ArticleItemViewHolder paramArticleItemViewHolder)
  {
    if (paramArticleItemViewHolder == null) {
      return;
    }
    Object localObject2 = getBaseActivity();
    if (localObject2 != null)
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("url", paramArticleItemViewHolder.f);
      int i = E;
      if (i == 13)
      {
        ((Bundle)localObject1).putInt("articalChannelId", 12);
      }
      else if (i == 1)
      {
        ((Bundle)localObject1).putInt("articalChannelId", 10);
        if (paramArticleItemViewHolder.i != null) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.e, paramArticleItemViewHolder.i, paramArticleItemViewHolder.j, "1");
        }
      }
      else if (i == 2)
      {
        ((Bundle)localObject1).putInt("articalChannelId", 11);
      }
      localObject2 = new ActivityURIRequest((Context)localObject2, "/pubaccount/browser");
      ((ActivityURIRequest)localObject2).extra().putAll((Bundle)localObject1);
      QRoute.startUri((URIRequest)localObject2, null);
      Object localObject3;
      Object localObject4;
      if (E == 12)
      {
        localObject1 = this.r;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramArticleItemViewHolder.g);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = this.e;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("");
        ((StringBuilder)localObject4).append(paramArticleItemViewHolder.h);
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, (String)localObject2, "", (String)localObject3, ((StringBuilder)localObject4).toString());
      }
      else
      {
        localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localObject2 = this.r;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramArticleItemViewHolder.g);
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramArticleItemViewHolder.h);
        ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEventForMigrate((AppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, (String)localObject3, "", (String)localObject4, localStringBuilder.toString(), false);
      }
      localObject1 = (Integer)this.I.get(Integer.valueOf(80000003));
      if (localObject1 != null) {
        i = ((Integer)localObject1).intValue();
      } else {
        i = 0;
      }
      SearchUtils.a(80000003, i, paramArticleItemViewHolder.g, true, null, this.e, E);
    }
  }
  
  private void a(SearchBaseFragment.ItemViewHolder paramItemViewHolder)
  {
    if (paramItemViewHolder == null) {
      return;
    }
    if (paramItemViewHolder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchContactsFragment", 2, "onClickItemViewHolder return for null holder");
      }
      return;
    }
    a(paramItemViewHolder.j, paramItemViewHolder.k, 2);
    ReportController.b(this.r, "CliOper", "", "", "0X8004BF2", "0X8004BF2", d(paramItemViewHolder.j), 0, "", "", "", "");
    Object localObject3 = (Integer)this.I.get(Integer.valueOf(paramItemViewHolder.j));
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramItemViewHolder.k != null)
    {
      localObject1 = localObject2;
      if (paramItemViewHolder.k.uin != null) {
        localObject1 = String.valueOf(paramItemViewHolder.k.uin.get());
      }
    }
    int j = paramItemViewHolder.j;
    int i;
    if (localObject3 != null) {
      i = ((Integer)localObject3).intValue();
    } else {
      i = 0;
    }
    SearchUtils.a(j, i, paramItemViewHolder.m, true, (String)localObject1, this.e, E);
    if (paramItemViewHolder.j == 80000002)
    {
      localObject3 = paramItemViewHolder.k;
      localObject1 = getBaseActivity();
      if ((localObject3 != null) && (localObject1 != null) && ((localObject1 instanceof SearchBaseActivity)))
      {
        i = ((SearchBaseActivity)localObject1).f();
        Object localObject4 = (IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class);
        localObject1 = ((AccountSearchPb.record)localObject3).uin;
        localObject2 = "";
        if (localObject1 != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((AccountSearchPb.record)localObject3).uin.get());
          ((StringBuilder)localObject1).append("");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = "";
        }
        ((IPublicAccountDetailReportUtil)localObject4).setAttrSearchClick(2, (String)localObject1, paramItemViewHolder.m, E);
        if (E == 12)
        {
          localObject1 = this.r;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramItemViewHolder.m);
          ((StringBuilder)localObject4).append("");
          localObject4 = ((StringBuilder)localObject4).toString();
          String str = SearchBaseActivity.JumpSrcConstants.a(i);
          paramItemViewHolder = (SearchBaseFragment.ItemViewHolder)localObject2;
          if (((AccountSearchPb.record)localObject3).uin != null)
          {
            paramItemViewHolder = new StringBuilder();
            paramItemViewHolder.append(((AccountSearchPb.record)localObject3).uin.get());
            paramItemViewHolder.append("");
            paramItemViewHolder = paramItemViewHolder.toString();
          }
          ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, (String)localObject4, str, paramItemViewHolder, this.e);
          return;
        }
        localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localObject4 = this.r;
        if (((AccountSearchPb.record)localObject3).uin != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((AccountSearchPb.record)localObject3).uin.get());
          ((StringBuilder)localObject1).append("");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = "";
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramItemViewHolder.m);
        ((StringBuilder)localObject3).append("");
        ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate((AppInterface)localObject4, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005D20", "0X8005D20", 0, 0, ((StringBuilder)localObject3).toString(), SearchBaseActivity.JumpSrcConstants.a(i), this.e, "", false);
      }
    }
  }
  
  private void a(NearbyTroops.CustomViewHolder paramCustomViewHolder)
  {
    int i;
    if (paramCustomViewHolder.k) {
      i = 30004;
    } else {
      i = 30008;
    }
    Object localObject = TroopInfoUIUtil.a(paramCustomViewHolder.y, paramCustomViewHolder.j, i);
    ((Bundle)localObject).putInt("exposureSource", 3);
    ((Bundle)localObject).putInt("t_s_f", 1000);
    TroopUtils.a(o(), (Bundle)localObject, 2);
    ReportController.b(this.r, "CliOper", "", "", "0X8004BF2", "0X8004BF2", d(80000001), 0, "", "", "", "");
    ReportController.b(this.r, "P_CliOper", "Grp_find", "", "result", "Clk_grpdate", 0, 0, paramCustomViewHolder.y, "", "", "");
    localObject = (Integer)this.I.get(Integer.valueOf(80000001));
    if (localObject != null) {
      i = ((Integer)localObject).intValue();
    } else {
      i = 0;
    }
    SearchUtils.a(80000001, i, paramCustomViewHolder.h, true, paramCustomViewHolder.y, this.e, E);
    SearchUtils.a("add_page", "all_result", "clk_grp", 0, this.K, new String[] { paramCustomViewHolder.y, "", this.e, "" });
  }
  
  private SearchResult b(int paramInt)
  {
    Object localObject = this.D;
    if (localObject == null) {
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SearchResult localSearchResult = (SearchResult)((Iterator)localObject).next();
      if (localSearchResult.a == paramInt) {
        return localSearchResult;
      }
    }
    return null;
  }
  
  private String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 80000002: 
      return "0X8004BF0";
    case 80000001: 
      return "0X8004BEF";
    }
    return "0X8004BEE";
  }
  
  private int d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 80000002: 
      return 3;
    case 80000001: 
      return 2;
    }
    return 1;
  }
  
  private boolean e(ArrayList<SearchResult> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject1 = (SearchResult)paramArrayList.get(0);
      Object localObject2;
      if (((SearchResult)localObject1).j)
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("https://sqimg.qq.com/qq_product_operations/tiqq/suicide/?keyword=");
        paramArrayList.append(URLEncoder.encode(this.e));
        paramArrayList = paramArrayList.toString();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("is SuicideWord word = ");
          ((StringBuilder)localObject1).append(this.e);
          ((StringBuilder)localObject1).append(" jump url is : ");
          ((StringBuilder)localObject1).append(paramArrayList);
          QLog.d("SearchContactsFragment", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = o();
        localObject2 = new Intent((Context)localObject1, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", paramArrayList);
        ((Intent)localObject2).putExtra("uin", this.r.getCurrentAccountUin());
        ((Intent)localObject2).putExtra("portraitOnly", true);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("isShowAd", false);
        ((BaseActivity)localObject1).startActivity((Intent)localObject2);
        return true;
      }
      localObject1 = ((SearchResult)localObject1).e;
      int i;
      if ((localObject1 != null) && (((List)localObject1).size() == 1))
      {
        localObject1 = (AccountSearchPb.record)((List)localObject1).get(0);
        int j = ((SearchResult)paramArrayList.get(0)).a;
        if (j == 80000003) {
          return false;
        }
        long l = ((AccountSearchPb.record)localObject1).code.get();
        if ((j == 80000001) && (!TextUtils.isEmpty(this.J)) && (!String.valueOf(l).equals(this.J))) {
          return false;
        }
        i = 30002;
        if (this.f == 1) {
          i = 30010;
        }
        a(j, (AccountSearchPb.record)localObject1, i);
        if (this.s == null) {
          return false;
        }
        if (((SearchBaseActivity)this.s).f() == 0) {
          o().finish();
        }
        return true;
      }
      if ((localObject1 != null) && (((List)localObject1).size() == 2))
      {
        localObject1 = SearchBaseActivity.E.matcher(this.e);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("needJump lastKeywords = ");
          ((StringBuilder)localObject2).append(this.e);
          QLog.d("SearchContactsFragment", 2, ((StringBuilder)localObject2).toString());
        }
        if (((Matcher)localObject1).matches())
        {
          g();
          b(this.D);
          if (this.f == 1) {
            i = 3;
          } else if (this.f == 0) {
            i = 2;
          } else {
            i = 0;
          }
          a(((SearchResult)paramArrayList.get(0)).a, false, i);
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean t()
  {
    Object localObject = this.z;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SearchContactsFragment.ListItemData localListItemData = (SearchContactsFragment.ListItemData)((Iterator)localObject).next();
        if ((localListItemData != null) && (localListItemData.d == 80000002)) {
          return true;
        }
      }
    }
    return false;
  }
  
  String a(SearchBaseFragment.ItemViewHolder paramItemViewHolder, SearchContactsFragment.ListItemData paramListItemData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramListItemData.d;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramListItemData.a.uin.get());
    ((StringBuilder)localObject1).append("");
    paramItemViewHolder.f = ((StringBuilder)localObject1).toString();
    boolean bool;
    if (paramListItemData.a.uin.get() != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    paramItemViewHolder.h = bool;
    paramItemViewHolder.g = paramListItemData.a.mobile.get();
    paramItemViewHolder.b.setCompoundDrawables(null, null, null, null);
    Object localObject2 = new SpannableStringBuilder();
    switch (i)
    {
    default: 
      break;
    case 80000002: 
      paramItemViewHolder.b.setText(a(80000002, String.valueOf(paramListItemData.a.name.get())));
      break;
    case 80000001: 
      paramItemViewHolder.b.setText(a(80000001, String.valueOf(paramListItemData.a.name.get())));
      ((SpannableStringBuilder)localObject2).append("(");
      ((SpannableStringBuilder)localObject2).append(a(80000001, String.valueOf(paramListItemData.a.code.get())));
      ((SpannableStringBuilder)localObject2).append(")");
      break;
    case 80000000: 
      paramItemViewHolder.b.setText(a(80000000, paramListItemData.a.name.get()));
      ((SpannableStringBuilder)localObject2).append("(");
      if (paramItemViewHolder.h) {
        localObject1 = paramItemViewHolder.f;
      } else {
        localObject1 = paramItemViewHolder.g;
      }
      ((SpannableStringBuilder)localObject2).append(a(80000000, (String)localObject1));
      ((SpannableStringBuilder)localObject2).append(")");
    }
    localObject1 = PrettyAccountUtil.a(paramListItemData.a.uint32_richflag1_59.get(), paramListItemData.a.uint32_richflag4_409.get(), (CharSequence)localObject2, paramListItemData.a.accout.get());
    paramItemViewHolder.c.setText((CharSequence)localObject1);
    if ((i == 80000000) && (!TextUtils.isEmpty(paramItemViewHolder.f)) && (Utils.c(paramItemViewHolder.f)))
    {
      localObject1 = this.r.getApp().getResources().getDrawable(2130842755);
      this.r.getApp();
      int j = AIOUtils.b(15.0F, BaseApplication.getContext().getResources());
      this.r.getApp();
      ((Drawable)localObject1).setBounds(0, 0, j, AIOUtils.b(15.0F, BaseApplication.getContext().getResources()));
      paramItemViewHolder.c.setCompoundDrawables(null, null, (Drawable)localObject1, null);
    }
    else
    {
      paramItemViewHolder.c.setCompoundDrawables(null, null, null, null);
    }
    PrettyAccountUtil.a(paramItemViewHolder.c, paramListItemData.a.uint32_richflag1_59.get(), paramListItemData.a.uint32_richflag4_409.get(), 2131168119, 17);
    localStringBuilder.append(paramItemViewHolder.b.getText().toString());
    localStringBuilder.append(paramItemViewHolder.c.getText().toString());
    switch (i)
    {
    default: 
      break;
    case 80000002: 
      localStringBuilder.append(b(paramItemViewHolder, paramListItemData.a));
      break;
    case 80000001: 
      i = 4;
      paramItemViewHolder.d.setVisibility(0);
      paramItemViewHolder.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      localObject1 = paramItemViewHolder.d;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramListItemData.a.number.get());
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131911083));
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      paramItemViewHolder.d.setTextColor(o().getResources().getColor(2131168118));
      paramItemViewHolder.e.setText(paramListItemData.a.brief.get());
      paramItemViewHolder.f = String.valueOf(paramListItemData.a.code.get());
      localStringBuilder.append(paramItemViewHolder.d.getText());
      localStringBuilder.append(paramItemViewHolder.e.getText());
      break;
    case 80000000: 
      localStringBuilder.append(a(paramItemViewHolder, paramListItemData.a));
    }
    i = 1;
    localObject1 = this.m.getBitmapFromCache(i, paramItemViewHolder.f);
    paramListItemData = (SearchContactsFragment.ListItemData)localObject1;
    if (localObject1 == null)
    {
      localObject1 = ImageUtil.k();
      paramListItemData = (SearchContactsFragment.ListItemData)localObject1;
      if (!this.m.isPausing())
      {
        this.m.requestDecodeFace(paramItemViewHolder.f, i, true, (byte)1);
        paramListItemData = (SearchContactsFragment.ListItemData)localObject1;
      }
    }
    paramItemViewHolder.a.setImageBitmap(paramListItemData);
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    if (this.z == null)
    {
      j();
      return;
    }
    if (this.O == null)
    {
      this.O = new SearchContactsFragment.SearchResultAdapter(this, BaseApplicationImpl.getContext(), this.r, this.k, 4, true);
      this.O.a(this.z);
      this.k.setAdapter(this.O);
      this.i = this.O;
    }
    if (this.j.getChildAt(0) != this.k)
    {
      this.j.removeAllViews();
      this.j.addView(this.k);
    }
    this.O.a(this.z);
    this.O.notifyDataSetChanged();
    if (this.h)
    {
      this.h = false;
      this.k.setSelection(0);
    }
    if (t())
    {
      Object localObject1 = getBaseActivity();
      if ((localObject1 != null) && ((localObject1 instanceof SearchContactsActivity)))
      {
        localObject1 = SearchBaseActivity.JumpSrcConstants.a(((SearchContactsActivity)localObject1).f());
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.r, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1F", "0X8005D1F", 0, 0, "", (String)localObject1, this.e, "", false);
      }
      if (this.z != null)
      {
        localObject1 = new StringBuilder();
        Object localObject2 = this.z.iterator();
        int i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          SearchContactsFragment.ListItemData localListItemData = (SearchContactsFragment.ListItemData)((Iterator)localObject2).next();
          if ((localListItemData != null) && (localListItemData.a != null) && (localListItemData.d == 80000002))
          {
            ((StringBuilder)localObject1).append(String.valueOf(localListItemData.a.uin.get()));
            ((StringBuilder)localObject1).append("#");
            i += 1;
          }
        }
        localObject2 = ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).buildSearchID(this.r.getCurrentAccountUin(), this.e);
        ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).setAttrSearchPage((String)localObject2, this.e, 2, false, i, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("last_key_words", this.e);
    Object localObject2;
    switch (paramInt1)
    {
    default: 
      break;
    case 80000003: 
      ((Intent)localObject1).putExtra("from_key", 5);
      ((Intent)localObject1).putExtra("fromType", E);
      ((Intent)localObject1).setClass(o(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(o(), (Intent)localObject1, b(paramInt1));
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.r, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, "0", "", this.e, "", false);
      break;
    case 80000002: 
      ((Intent)localObject1).putExtra("from_key", 2);
      localObject2 = getBaseActivity();
      if ((localObject2 != null) && ((localObject2 instanceof SearchContactsActivity))) {
        ((Intent)localObject1).putExtra("jump_src_key", ((SearchContactsActivity)localObject2).f());
      }
      ((Intent)localObject1).setClass(o(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(o(), (Intent)localObject1, b(paramInt1));
      if ((localObject2 != null) && ((localObject2 instanceof SearchBaseActivity)))
      {
        paramInt1 = ((SearchBaseActivity)localObject2).f();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.r, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "0", SearchBaseActivity.JumpSrcConstants.a(paramInt1), this.e, "", false);
      }
      paramInt1 = 3;
      break;
    case 80000001: 
      long l1 = Double.valueOf(this.B * 1000000.0D).longValue();
      long l2 = Double.valueOf(this.C * 1000000.0D).longValue();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://qqweb.qq.com/m/relativegroup/index.html?source=qun_rec&keyword=");
      ((StringBuilder)localObject1).append(URLEncoder.encode(this.e));
      ((StringBuilder)localObject1).append("&gpstype=1&sid=AWSAPtjyiVRg92WelXNMAqd0&_bid=165&lon=");
      ((StringBuilder)localObject1).append(Long.valueOf(l2));
      ((StringBuilder)localObject1).append("&lat=");
      ((StringBuilder)localObject1).append(Long.valueOf(l1));
      ((StringBuilder)localObject1).append("&sourceext=");
      ((StringBuilder)localObject1).append(paramInt2);
      localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = localObject2;
      if (paramBoolean)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("&show_tab=hot");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&_wv=17039363&_wwv=1293&_cwv=8");
      localObject1 = ((StringBuilder)localObject2).toString();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("call jump ,lastKeywords = ");
        ((StringBuilder)localObject2).append(this.e);
        ((StringBuilder)localObject2).append(" jump url is : ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("SearchContactsFragment", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new Intent(o(), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("uin", this.r.getCurrentAccountUin());
      ((Intent)localObject2).putExtra("portraitOnly", true);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("isShowAd", false);
      o().startActivity((Intent)localObject2);
      ReportController.b(this.r, "P_CliOper", "Grp_find", "", "result", "Clk_more", 0, 0, "", "", "", "");
      localObject2 = this.r;
      if (this.e.matches("^\\d{5,11}$")) {
        localObject1 = "2";
      } else {
        localObject1 = "1";
      }
      ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_find", "", "inte_add", "inte_find_grp", 0, 0, (String)localObject1, this.e, "", "");
      paramInt1 = 2;
      break;
    case 80000000: 
      localObject2 = o();
      if (localObject2 != null)
      {
        ((Intent)localObject1).putExtra("from_key", 0);
        ((Intent)localObject1).setClass((Context)localObject2, ClassificationSearchActivity.class);
        ClassificationSearchActivity.a((Activity)localObject2, (Intent)localObject1, b(paramInt1));
      }
      break;
    }
    paramInt1 = 1;
    ReportController.b(this.r, "CliOper", "", "", "0X8004BF1", "0X8004BF1", paramInt1, 0, "", "", "", "");
  }
  
  void a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(o(), "/pubaccount/browser");
      localActivityURIRequest.extra().putString("url", paramString1);
      QRoute.startUri(localActivityURIRequest, null);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.e, paramString2, paramString3, "2");
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsFragment", 2, "doSearch");
    }
    if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      l();
      this.e = paramString;
      if (this.t == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "doSearch:should not be here | searchFacade = null");
        }
        m();
        return;
      }
      this.t.c();
      if (this.f == 1)
      {
        this.a = true;
        this.b = 80000001;
        if (this.c) {
          GroupSearchHistoryManager.a().a(this.r.getCurrentUin(), paramString);
        } else {
          this.c = true;
        }
      }
      ContactSearchFacade localContactSearchFacade;
      int i;
      if (E == 12)
      {
        localContactSearchFacade = this.t;
        if (this.a) {
          i = this.b;
        } else {
          i = 80000006;
        }
        localContactSearchFacade.a(paramString, i, this.C, this.B, 1);
      }
      else
      {
        localContactSearchFacade = this.t;
        if (this.a) {
          i = this.b;
        } else {
          i = 80000005;
        }
        localContactSearchFacade.a(paramString, i, this.C, this.B, 0);
      }
      this.h = true;
      if (this.a)
      {
        paramString = c(this.b);
        ReportController.b(this.r, "CliOper", "", "", paramString, paramString, this.f + 1, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.r, "CliOper", "", "", "0X8004BED", "0X8004BED", this.f + 1, 0, "", "", "", "");
      return;
    }
    QQToast.makeText(BaseApplicationImpl.getContext(), 2131892104, 0).show(i());
  }
  
  protected boolean a(ArrayList<SearchResult> paramArrayList)
  {
    boolean bool = this.a;
    int i = 1;
    if (!bool)
    {
      this.D = paramArrayList;
      this.K = ReportUtil.a(paramArrayList, this.J);
      if (!e(this.D))
      {
        this.z = d(c(paramArrayList));
        g();
        b(this.D);
        return true;
      }
      return false;
    }
    this.a = false;
    this.D = paramArrayList;
    g();
    b(this.D);
    if (!e(this.D))
    {
      if (this.f == 1) {
        i = 3;
      } else if (this.f != 0) {
        i = 0;
      }
      a(((SearchResult)paramArrayList.get(0)).a, false, i);
    }
    return false;
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SearchContactsFragment", 2, "show group search recommend view");
    }
    this.M = new GroupSearchRecommendView(o(), this.y, new SearchContactsFragment.3(this), new SearchContactsFragment.4(this));
    this.M.a();
    a(this.M);
  }
  
  ArrayList<SearchResult> c(ArrayList<SearchResult> paramArrayList)
  {
    int[] arrayOfInt = ViewFactory.a(n());
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        SearchResult localSearchResult = (SearchResult)localIterator.next();
        if (localSearchResult.a == k) {
          localArrayList.add(localSearchResult);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  void c(String paramString)
  {
    ViewFactory.GuideView localGuideView = this.N;
    if (localGuideView != null) {
      localGuideView.a(n(), paramString);
    }
  }
  
  ArrayList<SearchContactsFragment.ListItemData> d(ArrayList<SearchResult> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(12);
    int i1 = paramArrayList.size();
    int i = 0;
    while (i < i1)
    {
      SearchResult localSearchResult = (SearchResult)paramArrayList.get(i);
      if ((localSearchResult != null) && ((localSearchResult.e.size() > 0) || (localSearchResult.i.size() > 0)))
      {
        Object localObject = new SearchContactsFragment.ListItemData();
        ((SearchContactsFragment.ListItemData)localObject).c = 0;
        ((SearchContactsFragment.ListItemData)localObject).d = localSearchResult.a;
        ((SearchContactsFragment.ListItemData)localObject).j = localSearchResult.k;
        if (ViewFactory.b(localSearchResult.a) == 2131886308) {
          ((SearchContactsFragment.ListItemData)localObject).e = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.r, BaseApplicationImpl.getContext());
        } else {
          ((SearchContactsFragment.ListItemData)localObject).e = o().getString(ViewFactory.b(localSearchResult.a));
        }
        localArrayList.add(localObject);
        localObject = null;
        if (!TextUtils.isEmpty(localSearchResult.g)) {
          localObject = localSearchResult.g;
        }
        SearchContactsFragment.ListItemData localListItemData;
        int j;
        if ((localSearchResult.f != null) && (localSearchResult.f.hotword.has()))
        {
          localListItemData = new SearchContactsFragment.ListItemData();
          localListItemData.c = 2;
          localListItemData.b = localSearchResult.f;
          localListItemData.d = localSearchResult.a;
          localListItemData.f = localSearchResult.h;
          localListItemData.g = ((String)localObject);
          localArrayList.add(localListItemData);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F75", "0X8006F75", 0, 0, this.e, localListItemData.b.hotword.get(), String.valueOf(localListItemData.b.hotword_type.get()), "");
          j = 2;
        }
        else
        {
          j = 3;
        }
        if (localSearchResult.a == 80000004)
        {
          int n = localSearchResult.i.size();
          k = 0;
          for (;;)
          {
            m = n;
            if (k >= j) {
              break;
            }
            localObject = new SearchContactsFragment.ListItemData();
            ((SearchContactsFragment.ListItemData)localObject).h = ((AccountSearchPb.ResultItem)localSearchResult.i.get(k));
            ((SearchContactsFragment.ListItemData)localObject).c = 2;
            ((SearchContactsFragment.ListItemData)localObject).d = localSearchResult.a;
            localArrayList.add(localObject);
            if (k >= n - 1)
            {
              m = n;
              break;
            }
            k += 1;
          }
        }
        int m = localSearchResult.e.size();
        int k = 0;
        while (k < j)
        {
          localListItemData = new SearchContactsFragment.ListItemData();
          localListItemData.c = 2;
          localListItemData.a = ((AccountSearchPb.record)localSearchResult.e.get(k));
          localListItemData.d = localSearchResult.a;
          localListItemData.f = localSearchResult.h;
          localListItemData.g = ((String)localObject);
          localListItemData.j = localSearchResult.k;
          localArrayList.add(localListItemData);
          if (k >= m - 1) {
            break;
          }
          if (localSearchResult.a == 80000001) {
            ReportController.b(this.r, "P_CliOper", "Grp_find", "", "result", "exp", 0, 0, "", "", "", "");
          }
          k += 1;
        }
        if (m > 3)
        {
          localObject = new SearchContactsFragment.ListItemData();
          ((SearchContactsFragment.ListItemData)localObject).c = 1;
          ((SearchContactsFragment.ListItemData)localObject).d = localSearchResult.a;
          ((SearchContactsFragment.ListItemData)localObject).f = localSearchResult.h;
          if (localSearchResult.a == 80000004) {
            ((SearchContactsFragment.ListItemData)localObject).i = localSearchResult.g;
          }
          localArrayList.add(localObject);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("search reuslt : type = ");
          ((StringBuilder)localObject).append(localSearchResult.a);
          ((StringBuilder)localObject).append("count = ");
          ((StringBuilder)localObject).append(localSearchResult.e.size());
          QLog.d("SearchContactsFragment", 2, ((StringBuilder)localObject).toString());
        }
        switch (localSearchResult.a)
        {
        default: 
          localObject = "";
        }
        for (;;)
        {
          break;
          localObject = "0X80061C1";
          continue;
          localObject = "0X80061BE";
          continue;
          localObject = "0X80061BB";
          continue;
          localObject = "0X80061B8";
        }
        ReportController.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, String.valueOf(Math.min(m, 3)), "", "", "");
      }
      i += 1;
    }
    return localArrayList;
  }
  
  void d()
  {
    if (this.N == null)
    {
      this.N = ((ViewFactory.GuideView)ViewFactory.a().a(80000005, o(), true, this.m, null));
      localObject = this.N;
      if (localObject == null) {
        return;
      }
      ((ViewFactory.GuideView)localObject).setListener(new SearchContactsFragment.5(this));
      a(this.N);
      return;
    }
    Object localObject = this.j.getChildAt(0);
    ViewFactory.GuideView localGuideView = this.N;
    if (localObject != localGuideView) {
      a(localGuideView);
    }
  }
  
  public void d(String paramString)
  {
    this.J = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      d();
      c(paramString);
      return;
    }
    this.j.removeAllViews();
  }
  
  protected void j()
  {
    Object localObject = (MayknowRecommendManager)this.r.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    if ((80000001 == this.b) && (((MayknowRecommendManager)localObject).j))
    {
      localObject = this.L;
      if (localObject == null)
      {
        this.L = new RecommendTroopListWrapperForSearchEmpty(this.r, this.s, null, null);
        localObject = this.L.g();
        TextView localTextView = new TextView(this.s);
        localTextView.setGravity(17);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(105.0F, getResources())));
        localTextView.setTextColor(getResources().getColor(2131168122));
        localTextView.setTextSize(1, 17.0F);
        localTextView.setText(HardCodeUtil.a(2131911090));
        localTextView.setBackgroundResource(2130838959);
        ((ListView)localObject).addHeaderView(localTextView);
        localTextView = new TextView(this.s);
        localTextView.setTextColor(getResources().getColor(2131168122));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setGravity(16);
        localTextView.setPadding(AIOUtils.b(15.0F, getResources()), 0, 0, 0);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(40.0F, getResources())));
        localTextView.setText(HardCodeUtil.a(2131911081));
        localTextView.setBackgroundResource(2130838959);
        ((ListView)localObject).addHeaderView(localTextView);
      }
      else
      {
        ((RecommendTroopListWrapper)localObject).f();
      }
      a(this.L.g());
    }
    else
    {
      super.j();
    }
    this.a = false;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject != null)
    {
      if ((localObject instanceof SearchBaseFragment.ItemViewHolder)) {
        a((SearchBaseFragment.ItemViewHolder)localObject);
      } else if ((localObject instanceof NearbyTroops.CustomViewHolder)) {
        a((NearbyTroops.CustomViewHolder)localObject);
      } else if ((localObject instanceof SearchBaseFragment.ArticleItemViewHolder)) {
        a((SearchBaseFragment.ArticleItemViewHolder)localObject);
      }
    }
    else if ((paramView instanceof QzoneSearchResultView)) {
      ((QzoneSearchResultView)paramView).a(getBaseActivity());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    SearchContactsFragment.SearchResultAdapter localSearchResultAdapter = this.O;
    if (localSearchResultAdapter != null) {
      localSearchResultAdapter.c();
    }
    if (this.x != null) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.x);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    RecommendTroopListWrapper localRecommendTroopListWrapper = this.L;
    if (localRecommendTroopListWrapper != null) {
      localRecommendTroopListWrapper.e();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseByTag(37);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.f == 1)
    {
      GroupSearchRecommendView localGroupSearchRecommendView = this.M;
      if (localGroupSearchRecommendView != null) {
        localGroupSearchRecommendView.b();
      }
    }
    ApngImage.playByTag(37);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (this.f == 1) {
      b();
    }
  }
  
  public void q()
  {
    super.q();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment
 * JD-Core Version:    0.7.0.1
 */