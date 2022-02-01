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
  private static int jdField_b_of_type_Int = -1;
  private double jdField_a_of_type_Double = 0.0D;
  int jdField_a_of_type_Int;
  SearchContactsFragment.JumpListener jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$JumpListener;
  private SearchContactsFragment.SearchResultAdapter jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$SearchResultAdapter;
  private ViewFactory.GuideView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView;
  GroupSearchRecommendView.IGroupSearchContext jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView$IGroupSearchContext = new SearchContactsFragment.2(this);
  private GroupSearchRecommendView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView;
  protected SosoInterfaceOnLocationListener a;
  private RecommendTroopListWrapper jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper;
  ArrayList<SearchContactsFragment.ListItemData> jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  private double jdField_b_of_type_Double = 0.0D;
  private String jdField_b_of_type_JavaLangString = null;
  private ArrayList<SearchResult> jdField_b_of_type_JavaUtilArrayList;
  private Map<Integer, Integer> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private String c;
  private String jdField_d_of_type_JavaLangString = "";
  boolean jdField_d_of_type_Boolean = true;
  private String e;
  private int g = 2;
  
  public SearchContactsFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener = null;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener = new SearchContactsFragment.1(this, 0, true, false, 60000L, false, false, "SearchContacts");
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
  }
  
  private int a(int paramInt)
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
  
  public static SearchContactsFragment a(int paramInt)
  {
    jdField_b_of_type_Int = paramInt;
    return new SearchContactsFragment();
  }
  
  private SearchResult a(int paramInt)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
    if (localObject == null) {
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SearchResult localSearchResult = (SearchResult)((Iterator)localObject).next();
      if (localSearchResult.jdField_a_of_type_Int == paramInt) {
        return localSearchResult;
      }
    }
    return null;
  }
  
  private String a(int paramInt)
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
  
  private void a(SearchBaseFragment.ArticleItemViewHolder paramArticleItemViewHolder)
  {
    if (paramArticleItemViewHolder == null) {
      return;
    }
    Object localObject2 = getBaseActivity();
    if (localObject2 != null)
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("url", paramArticleItemViewHolder.jdField_a_of_type_JavaLangString);
      int i = jdField_b_of_type_Int;
      if (i == 13)
      {
        ((Bundle)localObject1).putInt("articalChannelId", 12);
      }
      else if (i == 1)
      {
        ((Bundle)localObject1).putInt("articalChannelId", 10);
        if (paramArticleItemViewHolder.jdField_b_of_type_JavaLangString != null) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, paramArticleItemViewHolder.jdField_b_of_type_JavaLangString, paramArticleItemViewHolder.jdField_c_of_type_JavaLangString, "1");
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
      if (jdField_b_of_type_Int == 12)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramArticleItemViewHolder.jdField_a_of_type_Int);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = this.jdField_a_of_type_JavaLangString;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("");
        ((StringBuilder)localObject4).append(paramArticleItemViewHolder.jdField_a_of_type_Long);
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, (String)localObject2, "", (String)localObject3, ((StringBuilder)localObject4).toString());
      }
      else
      {
        localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramArticleItemViewHolder.jdField_a_of_type_Int);
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramArticleItemViewHolder.jdField_a_of_type_Long);
        ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEventForMigrate((AppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, (String)localObject3, "", (String)localObject4, localStringBuilder.toString(), false);
      }
      localObject1 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000003));
      if (localObject1 != null) {
        i = ((Integer)localObject1).intValue();
      } else {
        i = 0;
      }
      SearchUtils.a(80000003, i, paramArticleItemViewHolder.jdField_a_of_type_Int, true, null, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
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
    a(paramItemViewHolder.jdField_b_of_type_Int, paramItemViewHolder.jdField_a_of_type_AddcontactsAccountSearchPb$record, 2);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(paramItemViewHolder.jdField_b_of_type_Int), 0, "", "", "", "");
    Object localObject3 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramItemViewHolder.jdField_b_of_type_Int));
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramItemViewHolder.jdField_a_of_type_AddcontactsAccountSearchPb$record != null)
    {
      localObject1 = localObject2;
      if (paramItemViewHolder.jdField_a_of_type_AddcontactsAccountSearchPb$record.uin != null) {
        localObject1 = String.valueOf(paramItemViewHolder.jdField_a_of_type_AddcontactsAccountSearchPb$record.uin.get());
      }
    }
    int j = paramItemViewHolder.jdField_b_of_type_Int;
    int i;
    if (localObject3 != null) {
      i = ((Integer)localObject3).intValue();
    } else {
      i = 0;
    }
    SearchUtils.a(j, i, paramItemViewHolder.jdField_c_of_type_Int, true, (String)localObject1, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
    if (paramItemViewHolder.jdField_b_of_type_Int == 80000002)
    {
      localObject3 = paramItemViewHolder.jdField_a_of_type_AddcontactsAccountSearchPb$record;
      localObject1 = getBaseActivity();
      if ((localObject3 != null) && (localObject1 != null) && ((localObject1 instanceof SearchBaseActivity)))
      {
        i = ((SearchBaseActivity)localObject1).a();
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
        ((IPublicAccountDetailReportUtil)localObject4).setAttrSearchClick(2, (String)localObject1, paramItemViewHolder.jdField_c_of_type_Int, jdField_b_of_type_Int);
        if (jdField_b_of_type_Int == 12)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramItemViewHolder.jdField_c_of_type_Int);
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
          ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, (String)localObject4, str, paramItemViewHolder, this.jdField_a_of_type_JavaLangString);
          return;
        }
        localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
        ((StringBuilder)localObject3).append(paramItemViewHolder.jdField_c_of_type_Int);
        ((StringBuilder)localObject3).append("");
        ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate((AppInterface)localObject4, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005D20", "0X8005D20", 0, 0, ((StringBuilder)localObject3).toString(), SearchBaseActivity.JumpSrcConstants.a(i), this.jdField_a_of_type_JavaLangString, "", false);
      }
    }
  }
  
  private void a(NearbyTroops.CustomViewHolder paramCustomViewHolder)
  {
    int i;
    if (paramCustomViewHolder.jdField_a_of_type_Boolean) {
      i = 30004;
    } else {
      i = 30008;
    }
    Object localObject = TroopInfoUIUtil.a(paramCustomViewHolder.jdField_a_of_type_JavaLangString, paramCustomViewHolder.jdField_b_of_type_JavaLangString, i);
    ((Bundle)localObject).putInt("exposureSource", 3);
    ((Bundle)localObject).putInt("t_s_f", 1000);
    TroopUtils.a(a(), (Bundle)localObject, 2);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(80000001), 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_grpdate", 0, 0, paramCustomViewHolder.jdField_a_of_type_JavaLangString, "", "", "");
    localObject = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000001));
    if (localObject != null) {
      i = ((Integer)localObject).intValue();
    } else {
      i = 0;
    }
    SearchUtils.a(80000001, i, paramCustomViewHolder.jdField_a_of_type_Int, true, paramCustomViewHolder.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
    SearchUtils.a("add_page", "all_result", "clk_grp", 0, this.g, new String[] { paramCustomViewHolder.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_JavaLangString, "" });
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SearchContactsFragment.ListItemData localListItemData = (SearchContactsFragment.ListItemData)((Iterator)localObject).next();
        if ((localListItemData != null) && (localListItemData.jdField_b_of_type_Int == 80000002)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(ArrayList<SearchResult> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject1 = (SearchResult)paramArrayList.get(0);
      Object localObject2;
      if (((SearchResult)localObject1).jdField_b_of_type_Boolean)
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("https://sqimg.qq.com/qq_product_operations/tiqq/suicide/?keyword=");
        paramArrayList.append(URLEncoder.encode(this.jdField_a_of_type_JavaLangString));
        paramArrayList = paramArrayList.toString();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("is SuicideWord word = ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(" jump url is : ");
          ((StringBuilder)localObject1).append(paramArrayList);
          QLog.d("SearchContactsFragment", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = a();
        localObject2 = new Intent((Context)localObject1, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", paramArrayList);
        ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((Intent)localObject2).putExtra("portraitOnly", true);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("isShowAd", false);
        ((BaseActivity)localObject1).startActivity((Intent)localObject2);
        return true;
      }
      localObject1 = ((SearchResult)localObject1).jdField_b_of_type_JavaUtilList;
      int i;
      if ((localObject1 != null) && (((List)localObject1).size() == 1))
      {
        localObject1 = (AccountSearchPb.record)((List)localObject1).get(0);
        int j = ((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int;
        if (j == 80000003) {
          return false;
        }
        long l = ((AccountSearchPb.record)localObject1).code.get();
        if ((j == 80000001) && (!TextUtils.isEmpty(this.e)) && (!String.valueOf(l).equals(this.e))) {
          return false;
        }
        i = 30002;
        if (this.jdField_d_of_type_Int == 1) {
          i = 30010;
        }
        a(j, (AccountSearchPb.record)localObject1, i);
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
          return false;
        }
        if (((SearchBaseActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a() == 0) {
          a().finish();
        }
        return true;
      }
      if ((localObject1 != null) && (((List)localObject1).size() == 2))
      {
        localObject1 = SearchBaseActivity.c.matcher(this.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("needJump lastKeywords = ");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
          QLog.d("SearchContactsFragment", 2, ((StringBuilder)localObject2).toString());
        }
        if (((Matcher)localObject1).matches())
        {
          e();
          a(this.jdField_b_of_type_JavaUtilArrayList);
          if (this.jdField_d_of_type_Int == 1) {
            i = 3;
          } else if (this.jdField_d_of_type_Int == 0) {
            i = 2;
          } else {
            i = 0;
          }
          a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, false, i);
          return true;
        }
      }
    }
    return false;
  }
  
  String a(SearchBaseFragment.ItemViewHolder paramItemViewHolder, SearchContactsFragment.ListItemData paramListItemData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramListItemData.jdField_b_of_type_Int;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.uin.get());
    ((StringBuilder)localObject1).append("");
    paramItemViewHolder.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
    boolean bool;
    if (paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.uin.get() != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    paramItemViewHolder.jdField_a_of_type_Boolean = bool;
    paramItemViewHolder.jdField_b_of_type_JavaLangString = paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.mobile.get();
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    Object localObject2 = new SpannableStringBuilder();
    switch (i)
    {
    default: 
      break;
    case 80000002: 
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000002, String.valueOf(paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.name.get())));
      break;
    case 80000001: 
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000001, String.valueOf(paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.name.get())));
      ((SpannableStringBuilder)localObject2).append("(");
      ((SpannableStringBuilder)localObject2).append(a(80000001, String.valueOf(paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.code.get())));
      ((SpannableStringBuilder)localObject2).append(")");
      break;
    case 80000000: 
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000000, paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.name.get()));
      ((SpannableStringBuilder)localObject2).append("(");
      if (paramItemViewHolder.jdField_a_of_type_Boolean) {
        localObject1 = paramItemViewHolder.jdField_a_of_type_JavaLangString;
      } else {
        localObject1 = paramItemViewHolder.jdField_b_of_type_JavaLangString;
      }
      ((SpannableStringBuilder)localObject2).append(a(80000000, (String)localObject1));
      ((SpannableStringBuilder)localObject2).append(")");
    }
    localObject1 = PrettyAccountUtil.a(paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.uint32_richflag1_59.get(), paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.uint32_richflag4_409.get(), (CharSequence)localObject2, paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.accout.get());
    paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    if ((i == 80000000) && (!TextUtils.isEmpty(paramItemViewHolder.jdField_a_of_type_JavaLangString)) && (Utils.b(paramItemViewHolder.jdField_a_of_type_JavaLangString)))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130841838);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      int j = AIOUtils.b(15.0F, BaseApplication.getContext().getResources());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      ((Drawable)localObject1).setBounds(0, 0, j, AIOUtils.b(15.0F, BaseApplication.getContext().getResources()));
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject1, null);
    }
    else
    {
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
    PrettyAccountUtil.a(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView, paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.uint32_richflag1_59.get(), paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.uint32_richflag4_409.get(), 2131167139, 17);
    localStringBuilder.append(paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
    localStringBuilder.append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
    switch (i)
    {
    default: 
      break;
    case 80000002: 
      localStringBuilder.append(b(paramItemViewHolder, paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record));
      break;
    case 80000001: 
      i = 4;
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      localObject1 = paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.number.get());
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131713537));
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131167138));
      paramItemViewHolder.d.setText(paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.brief.get());
      paramItemViewHolder.jdField_a_of_type_JavaLangString = String.valueOf(paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.code.get());
      localStringBuilder.append(paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText());
      localStringBuilder.append(paramItemViewHolder.d.getText());
      break;
    case 80000000: 
      localStringBuilder.append(a(paramItemViewHolder, paramListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record));
    }
    i = 1;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(i, paramItemViewHolder.jdField_a_of_type_JavaLangString);
    paramListItemData = (SearchContactsFragment.ListItemData)localObject1;
    if (localObject1 == null)
    {
      localObject1 = ImageUtil.f();
      paramListItemData = (SearchContactsFragment.ListItemData)localObject1;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramItemViewHolder.jdField_a_of_type_JavaLangString, i, true, (byte)1);
        paramListItemData = (SearchContactsFragment.ListItemData)localObject1;
      }
    }
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramListItemData);
    return localStringBuilder.toString();
  }
  
  ArrayList<SearchResult> a(ArrayList<SearchResult> paramArrayList)
  {
    int[] arrayOfInt = ViewFactory.a(c());
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
        if (localSearchResult.jdField_a_of_type_Int == k) {
          localArrayList.add(localSearchResult);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      g();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$SearchResultAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$SearchResultAdapter = new SearchContactsFragment.SearchResultAdapter(this, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 4, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$SearchResultAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$SearchResultAdapter);
      this.a = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$SearchResultAdapter;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$SearchResultAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$SearchResultAdapter.notifyDataSetChanged();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    }
    if (a())
    {
      Object localObject1 = getBaseActivity();
      if ((localObject1 != null) && ((localObject1 instanceof SearchContactsActivity)))
      {
        localObject1 = SearchBaseActivity.JumpSrcConstants.a(((SearchContactsActivity)localObject1).a());
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1F", "0X8005D1F", 0, 0, "", (String)localObject1, this.jdField_a_of_type_JavaLangString, "", false);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = new StringBuilder();
        Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        int i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          SearchContactsFragment.ListItemData localListItemData = (SearchContactsFragment.ListItemData)((Iterator)localObject2).next();
          if ((localListItemData != null) && (localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record != null) && (localListItemData.jdField_b_of_type_Int == 80000002))
          {
            ((StringBuilder)localObject1).append(String.valueOf(localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record.uin.get()));
            ((StringBuilder)localObject1).append("#");
            i += 1;
          }
        }
        localObject2 = ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).buildSearchID(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
        ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).setAttrSearchPage((String)localObject2, this.jdField_a_of_type_JavaLangString, 2, false, i, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("last_key_words", this.jdField_a_of_type_JavaLangString);
    Object localObject2;
    switch (paramInt1)
    {
    default: 
      break;
    case 80000003: 
      ((Intent)localObject1).putExtra("from_key", 5);
      ((Intent)localObject1).putExtra("fromType", jdField_b_of_type_Int);
      ((Intent)localObject1).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject1, a(paramInt1));
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, "0", "", this.jdField_a_of_type_JavaLangString, "", false);
      break;
    case 80000002: 
      ((Intent)localObject1).putExtra("from_key", 2);
      localObject2 = getBaseActivity();
      if ((localObject2 != null) && ((localObject2 instanceof SearchContactsActivity))) {
        ((Intent)localObject1).putExtra("jump_src_key", ((SearchContactsActivity)localObject2).a());
      }
      ((Intent)localObject1).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject1, a(paramInt1));
      if ((localObject2 != null) && ((localObject2 instanceof SearchBaseActivity)))
      {
        paramInt1 = ((SearchBaseActivity)localObject2).a();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "0", SearchBaseActivity.JumpSrcConstants.a(paramInt1), this.jdField_a_of_type_JavaLangString, "", false);
      }
      paramInt1 = 3;
      break;
    case 80000001: 
      long l1 = Double.valueOf(this.jdField_a_of_type_Double * 1000000.0D).longValue();
      long l2 = Double.valueOf(this.jdField_b_of_type_Double * 1000000.0D).longValue();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://qqweb.qq.com/m/relativegroup/index.html?source=qun_rec&keyword=");
      ((StringBuilder)localObject1).append(URLEncoder.encode(this.jdField_a_of_type_JavaLangString));
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
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" jump url is : ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("SearchContactsFragment", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new Intent(a(), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject2).putExtra("portraitOnly", true);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("isShowAd", false);
      a().startActivity((Intent)localObject2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_more", 0, 0, "", "", "", "");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_JavaLangString.matches("^\\d{5,11}$")) {
        localObject1 = "2";
      } else {
        localObject1 = "1";
      }
      ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_find", "", "inte_add", "inte_find_grp", 0, 0, (String)localObject1, this.jdField_a_of_type_JavaLangString, "", "");
      paramInt1 = 2;
      break;
    case 80000000: 
      localObject2 = a();
      if (localObject2 != null)
      {
        ((Intent)localObject1).putExtra("from_key", 0);
        ((Intent)localObject1).setClass((Context)localObject2, ClassificationSearchActivity.class);
        ClassificationSearchActivity.a((Activity)localObject2, (Intent)localObject1, a(paramInt1));
      }
      break;
    }
    paramInt1 = 1;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF1", "0X8004BF1", paramInt1, 0, "", "", "", "");
  }
  
  void a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(a(), "/pubaccount/browser");
      localActivityURIRequest.extra().putString("url", paramString1);
      QRoute.startUri(localActivityURIRequest, null);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, paramString2, paramString3, "2");
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsFragment", 2, "doSearch");
    }
    if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      i();
      this.jdField_a_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "doSearch:should not be here | searchFacade = null");
        }
        j();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.c();
      if (this.jdField_d_of_type_Int == 1)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Int = 80000001;
        if (this.jdField_d_of_type_Boolean) {
          GroupSearchHistoryManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString);
        } else {
          this.jdField_d_of_type_Boolean = true;
        }
      }
      ContactSearchFacade localContactSearchFacade;
      int i;
      if (jdField_b_of_type_Int == 12)
      {
        localContactSearchFacade = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade;
        if (this.jdField_a_of_type_Boolean) {
          i = this.jdField_a_of_type_Int;
        } else {
          i = 80000006;
        }
        localContactSearchFacade.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 1);
      }
      else
      {
        localContactSearchFacade = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade;
        if (this.jdField_a_of_type_Boolean) {
          i = this.jdField_a_of_type_Int;
        } else {
          i = 80000005;
        }
        localContactSearchFacade.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 0);
      }
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_Boolean)
      {
        paramString = a(this.jdField_a_of_type_Int);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramString, paramString, this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BED", "0X8004BED", this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131694424, 0).b(b());
  }
  
  protected boolean a(ArrayList<SearchResult> paramArrayList)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    int i = 1;
    if (!bool)
    {
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
      this.g = ReportUtil.a(paramArrayList, this.e);
      if (!b(this.jdField_b_of_type_JavaUtilArrayList))
      {
        this.jdField_a_of_type_JavaUtilArrayList = b(a(paramArrayList));
        e();
        a(this.jdField_b_of_type_JavaUtilArrayList);
        return true;
      }
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    e();
    a(this.jdField_b_of_type_JavaUtilArrayList);
    if (!b(this.jdField_b_of_type_JavaUtilArrayList))
    {
      if (this.jdField_d_of_type_Int == 1) {
        i = 3;
      } else if (this.jdField_d_of_type_Int != 0) {
        i = 0;
      }
      a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, false, i);
    }
    return false;
  }
  
  ArrayList<SearchContactsFragment.ListItemData> b(ArrayList<SearchResult> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(12);
    int i1 = paramArrayList.size();
    int i = 0;
    while (i < i1)
    {
      SearchResult localSearchResult = (SearchResult)paramArrayList.get(i);
      if ((localSearchResult != null) && ((localSearchResult.jdField_b_of_type_JavaUtilList.size() > 0) || (localSearchResult.jdField_c_of_type_JavaUtilList.size() > 0)))
      {
        Object localObject = new SearchContactsFragment.ListItemData();
        ((SearchContactsFragment.ListItemData)localObject).jdField_a_of_type_Int = 0;
        ((SearchContactsFragment.ListItemData)localObject).jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
        ((SearchContactsFragment.ListItemData)localObject).jdField_a_of_type_Boolean = localSearchResult.jdField_c_of_type_Boolean;
        if (ViewFactory.a(localSearchResult.jdField_a_of_type_Int) == 2131689696) {
          ((SearchContactsFragment.ListItemData)localObject).jdField_a_of_type_JavaLangString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
        } else {
          ((SearchContactsFragment.ListItemData)localObject).jdField_a_of_type_JavaLangString = a().getString(ViewFactory.a(localSearchResult.jdField_a_of_type_Int));
        }
        localArrayList.add(localObject);
        localObject = null;
        if (!TextUtils.isEmpty(localSearchResult.jdField_a_of_type_JavaLangString)) {
          localObject = localSearchResult.jdField_a_of_type_JavaLangString;
        }
        SearchContactsFragment.ListItemData localListItemData;
        int j;
        if ((localSearchResult.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord != null) && (localSearchResult.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord.hotword.has()))
        {
          localListItemData = new SearchContactsFragment.ListItemData();
          localListItemData.jdField_a_of_type_Int = 2;
          localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord = localSearchResult.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord;
          localListItemData.jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
          localListItemData.jdField_c_of_type_Int = localSearchResult.jdField_c_of_type_Int;
          localListItemData.jdField_b_of_type_JavaLangString = ((String)localObject);
          localArrayList.add(localListItemData);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F75", "0X8006F75", 0, 0, this.jdField_a_of_type_JavaLangString, localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
          j = 2;
        }
        else
        {
          j = 3;
        }
        if (localSearchResult.jdField_a_of_type_Int == 80000004)
        {
          int n = localSearchResult.jdField_c_of_type_JavaUtilList.size();
          k = 0;
          for (;;)
          {
            m = n;
            if (k >= j) {
              break;
            }
            localObject = new SearchContactsFragment.ListItemData();
            ((SearchContactsFragment.ListItemData)localObject).jdField_a_of_type_AddcontactsAccountSearchPb$ResultItem = ((AccountSearchPb.ResultItem)localSearchResult.jdField_c_of_type_JavaUtilList.get(k));
            ((SearchContactsFragment.ListItemData)localObject).jdField_a_of_type_Int = 2;
            ((SearchContactsFragment.ListItemData)localObject).jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
            localArrayList.add(localObject);
            if (k >= n - 1)
            {
              m = n;
              break;
            }
            k += 1;
          }
        }
        int m = localSearchResult.jdField_b_of_type_JavaUtilList.size();
        int k = 0;
        while (k < j)
        {
          localListItemData = new SearchContactsFragment.ListItemData();
          localListItemData.jdField_a_of_type_Int = 2;
          localListItemData.jdField_a_of_type_AddcontactsAccountSearchPb$record = ((AccountSearchPb.record)localSearchResult.jdField_b_of_type_JavaUtilList.get(k));
          localListItemData.jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
          localListItemData.jdField_c_of_type_Int = localSearchResult.jdField_c_of_type_Int;
          localListItemData.jdField_b_of_type_JavaLangString = ((String)localObject);
          localListItemData.jdField_a_of_type_Boolean = localSearchResult.jdField_c_of_type_Boolean;
          localArrayList.add(localListItemData);
          if (k >= m - 1) {
            break;
          }
          if (localSearchResult.jdField_a_of_type_Int == 80000001) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "exp", 0, 0, "", "", "", "");
          }
          k += 1;
        }
        if (m > 3)
        {
          localObject = new SearchContactsFragment.ListItemData();
          ((SearchContactsFragment.ListItemData)localObject).jdField_a_of_type_Int = 1;
          ((SearchContactsFragment.ListItemData)localObject).jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
          ((SearchContactsFragment.ListItemData)localObject).jdField_c_of_type_Int = localSearchResult.jdField_c_of_type_Int;
          if (localSearchResult.jdField_a_of_type_Int == 80000004) {
            ((SearchContactsFragment.ListItemData)localObject).jdField_c_of_type_JavaLangString = localSearchResult.jdField_a_of_type_JavaLangString;
          }
          localArrayList.add(localObject);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("search reuslt : type = ");
          ((StringBuilder)localObject).append(localSearchResult.jdField_a_of_type_Int);
          ((StringBuilder)localObject).append("count = ");
          ((StringBuilder)localObject).append(localSearchResult.jdField_b_of_type_JavaUtilList.size());
          QLog.d("SearchContactsFragment", 2, ((StringBuilder)localObject).toString());
        }
        switch (localSearchResult.jdField_a_of_type_Int)
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
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SearchContactsFragment", 2, "show group search recommend view");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView = new GroupSearchRecommendView(a(), this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView$IGroupSearchContext, new SearchContactsFragment.3(this), new SearchContactsFragment.4(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView.a();
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView);
  }
  
  void b(String paramString)
  {
    ViewFactory.GuideView localGuideView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView;
    if (localGuideView != null) {
      localGuideView.a(c(), paramString);
    }
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      m();
      b(paramString);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
  }
  
  protected void g()
  {
    Object localObject = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    if ((80000001 == this.jdField_a_of_type_Int) && (((MayknowRecommendManager)localObject).jdField_d_of_type_Boolean))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper;
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper = new RecommendTroopListWrapperForSearchEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, null);
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper.a();
        TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localTextView.setGravity(17);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(105.0F, getResources())));
        localTextView.setTextColor(getResources().getColor(2131167142));
        localTextView.setTextSize(1, 17.0F);
        localTextView.setText(HardCodeUtil.a(2131713544));
        localTextView.setBackgroundResource(2130838740);
        ((ListView)localObject).addHeaderView(localTextView);
        localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localTextView.setTextColor(getResources().getColor(2131167142));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setGravity(16);
        localTextView.setPadding(AIOUtils.b(15.0F, getResources()), 0, 0, 0);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(40.0F, getResources())));
        localTextView.setText(HardCodeUtil.a(2131713535));
        localTextView.setBackgroundResource(2130838740);
        ((ListView)localObject).addHeaderView(localTextView);
      }
      else
      {
        ((RecommendTroopListWrapper)localObject).d();
      }
      a(this.jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper.a());
    }
    else
    {
      super.g();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void l()
  {
    super.l();
    e();
  }
  
  void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView = ((ViewFactory.GuideView)ViewFactory.a().a(80000005, a(), true, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, null));
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView;
      if (localObject == null) {
        return;
      }
      ((ViewFactory.GuideView)localObject).setListener(new SearchContactsFragment.5(this));
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
    ViewFactory.GuideView localGuideView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView;
    if (localObject != localGuideView) {
      a(localGuideView);
    }
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
    SearchContactsFragment.SearchResultAdapter localSearchResultAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$SearchResultAdapter;
    if (localSearchResultAdapter != null) {
      localSearchResultAdapter.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener != null) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    RecommendTroopListWrapper localRecommendTroopListWrapper = this.jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper;
    if (localRecommendTroopListWrapper != null) {
      localRecommendTroopListWrapper.c();
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
    if (this.jdField_d_of_type_Int == 1)
    {
      GroupSearchRecommendView localGroupSearchRecommendView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView;
      if (localGroupSearchRecommendView != null) {
        localGroupSearchRecommendView.b();
      }
    }
    ApngImage.playByTag(37);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (this.jdField_d_of_type_Int == 1) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment
 * JD-Core Version:    0.7.0.1
 */