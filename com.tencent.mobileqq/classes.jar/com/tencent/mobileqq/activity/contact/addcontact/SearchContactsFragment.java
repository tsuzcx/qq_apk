package com.tencent.mobileqq.activity.contact.addcontact;

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
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchHistoryManager;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView.IGroupSearchContext;
import com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopListWrapper;
import com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopListWrapperForSearchEmpty;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.search.util.ReportUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.PrettyAccountUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.ResultItem;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import cooperation.qzone.widget.QzoneSearchResultView;
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
  private RecommendTroopListWrapper jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopRecommendTroopListWrapper;
  protected SosoInterfaceOnLocationListener a;
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
    case 80000000: 
    default: 
      return 1;
    case 80000001: 
      return 2;
    }
    return 3;
  }
  
  public static SearchContactsFragment a(int paramInt)
  {
    jdField_b_of_type_Int = paramInt;
    return new SearchContactsFragment();
  }
  
  private SearchResult a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      SearchResult localSearchResult = (SearchResult)localIterator.next();
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
    case 80000000: 
      return "0X8004BEE";
    case 80000001: 
      return "0X8004BEF";
    }
    return "0X8004BF0";
  }
  
  private void a(SearchBaseFragment.ArticleItemViewHolder paramArticleItemViewHolder)
  {
    if (paramArticleItemViewHolder == null) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = getActivity();
    } while (localObject2 == null);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("url", paramArticleItemViewHolder.jdField_a_of_type_JavaLangString);
    if (jdField_b_of_type_Int == 13)
    {
      ((Bundle)localObject1).putInt("articalChannelId", 12);
      localObject2 = new ActivityURIRequest((Context)localObject2, "/pubaccount/browser");
      ((ActivityURIRequest)localObject2).extra().putAll((Bundle)localObject1);
      QRoute.startUri((URIRequest)localObject2, null);
      if (jdField_b_of_type_Int != 12) {
        break label285;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "" + paramArticleItemViewHolder.jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + paramArticleItemViewHolder.jdField_a_of_type_Long);
      label155:
      localObject1 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000003));
      if (localObject1 == null) {
        break label368;
      }
    }
    label285:
    label368:
    for (int i = ((Integer)localObject1).intValue();; i = 0)
    {
      SearchUtils.a(80000003, i, paramArticleItemViewHolder.jdField_a_of_type_Int, true, null, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
      return;
      if (jdField_b_of_type_Int == 1)
      {
        ((Bundle)localObject1).putInt("articalChannelId", 10);
        if (paramArticleItemViewHolder.jdField_b_of_type_JavaLangString == null) {
          break;
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, paramArticleItemViewHolder.jdField_b_of_type_JavaLangString, paramArticleItemViewHolder.jdField_c_of_type_JavaLangString, "1");
        break;
      }
      if (jdField_b_of_type_Int != 2) {
        break;
      }
      ((Bundle)localObject1).putInt("articalChannelId", 11);
      break;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "" + paramArticleItemViewHolder.jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + paramArticleItemViewHolder.jdField_a_of_type_Long, false);
      break label155;
    }
  }
  
  private void a(SearchBaseFragment.ItemViewHolder paramItemViewHolder)
  {
    if (paramItemViewHolder == null) {}
    AccountSearchPb.record localrecord;
    do
    {
      do
      {
        do
        {
          return;
          if (paramItemViewHolder != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("SearchContactsFragment", 2, "onClickItemViewHolder return for null holder");
        return;
        a(paramItemViewHolder.jdField_b_of_type_Int, paramItemViewHolder.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record, 2);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(paramItemViewHolder.jdField_b_of_type_Int), 0, "", "", "", "");
        localObject2 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramItemViewHolder.jdField_b_of_type_Int));
        localrecord = null;
        localObject1 = localrecord;
        if (paramItemViewHolder.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null)
        {
          localObject1 = localrecord;
          if (paramItemViewHolder.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin != null) {
            localObject1 = String.valueOf(paramItemViewHolder.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get());
          }
        }
        int j = paramItemViewHolder.jdField_b_of_type_Int;
        if (localObject2 == null) {
          break;
        }
        i = ((Integer)localObject2).intValue();
        SearchUtils.a(j, i, paramItemViewHolder.jdField_c_of_type_Int, true, (String)localObject1, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
      } while (paramItemViewHolder.jdField_b_of_type_Int != 80000002);
      localrecord = paramItemViewHolder.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
      localObject1 = getActivity();
    } while ((localrecord == null) || (localObject1 == null) || (!(localObject1 instanceof SearchBaseActivity)));
    int i = ((SearchBaseActivity)localObject1).a();
    Object localObject2 = PADetailReportUtil.a();
    if (localrecord.uin != null)
    {
      localObject1 = localrecord.uin.get() + "";
      label262:
      ((PADetailReportUtil)localObject2).a(2, (String)localObject1, paramItemViewHolder.jdField_c_of_type_Int, jdField_b_of_type_Int);
      if (jdField_b_of_type_Int != 12) {
        break label404;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = paramItemViewHolder.jdField_c_of_type_Int + "";
      localObject3 = SearchBaseActivity.JumpSrcConstants.a(i);
      if (localrecord.uin == null) {
        break label398;
      }
    }
    label398:
    for (paramItemViewHolder = localrecord.uin.get() + "";; paramItemViewHolder = "")
    {
      ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, (String)localObject2, (String)localObject3, paramItemViewHolder, this.jdField_a_of_type_JavaLangString);
      return;
      i = 0;
      break;
      localObject1 = "";
      break label262;
    }
    label404:
    localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localrecord.uin != null) {}
    for (Object localObject1 = localrecord.uin.get() + "";; localObject1 = "")
    {
      ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate((AppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005D20", "0X8005D20", 0, 0, paramItemViewHolder.jdField_c_of_type_Int + "", SearchBaseActivity.JumpSrcConstants.a(i), this.jdField_a_of_type_JavaLangString, "", false);
      return;
    }
  }
  
  private void a(NearbyTroops.CustomViewHolder paramCustomViewHolder)
  {
    int i = 30008;
    if (paramCustomViewHolder.jdField_a_of_type_Boolean) {
      i = 30004;
    }
    Object localObject = TroopInfoActivity.a(paramCustomViewHolder.jdField_a_of_type_JavaLangString, paramCustomViewHolder.jdField_b_of_type_JavaLangString, i);
    ((Bundle)localObject).putInt("exposureSource", 3);
    ((Bundle)localObject).putInt("t_s_f", 1000);
    TroopUtils.a(a(), (Bundle)localObject, 2);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(80000001), 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_grpdate", 0, 0, paramCustomViewHolder.jdField_a_of_type_JavaLangString, "", "", "");
    localObject = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000001));
    if (localObject != null) {}
    for (i = ((Integer)localObject).intValue();; i = 0)
    {
      SearchUtils.a(80000001, i, paramCustomViewHolder.jdField_a_of_type_Int, true, paramCustomViewHolder.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
      SearchUtils.a("add_page", "all_result", "clk_grp", 0, this.g, new String[] { paramCustomViewHolder.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_JavaLangString, "" });
      return;
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        SearchContactsFragment.ListItemData localListItemData = (SearchContactsFragment.ListItemData)localIterator.next();
        if ((localListItemData != null) && (localListItemData.jdField_b_of_type_Int == 80000002)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(ArrayList<SearchResult> paramArrayList)
  {
    int i = 2;
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (paramArrayList != null)
    {
      bool1 = bool2;
      if (paramArrayList.size() == 1)
      {
        localObject = (SearchResult)paramArrayList.get(0);
        if (!((SearchResult)localObject).jdField_b_of_type_Boolean) {
          break label213;
        }
        paramArrayList = "https://sqimg.qq.com/qq_product_operations/tiqq/suicide/?keyword=" + URLEncoder.encode(this.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "is SuicideWord word = " + this.jdField_a_of_type_JavaLangString + " jump url is : " + paramArrayList);
        }
        localObject = a();
        Intent localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
        localIntent.putExtra("url", paramArrayList);
        localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localIntent.putExtra("portraitOnly", true);
        localIntent.putExtra("hide_more_button", true);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("isShowAd", false);
        ((BaseActivity)localObject).startActivity(localIntent);
        bool1 = true;
      }
    }
    label213:
    do
    {
      do
      {
        do
        {
          do
          {
            int j;
            long l;
            do
            {
              do
              {
                return bool1;
                localObject = ((SearchResult)localObject).jdField_b_of_type_JavaUtilList;
                if ((localObject == null) || (((List)localObject).size() != 1)) {
                  break;
                }
                localObject = (AccountSearchPb.record)((List)localObject).get(0);
                j = ((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int;
                bool1 = bool2;
              } while (j == 80000003);
              l = ((AccountSearchPb.record)localObject).code.get();
              if ((j != 80000001) || (TextUtils.isEmpty(this.e))) {
                break;
              }
              bool1 = bool2;
            } while (!String.valueOf(l).equals(this.e));
            i = 30002;
            if (this.jdField_d_of_type_Int == 1) {
              i = 30010;
            }
            a(j, (AccountSearchPb.record)localObject, i);
            bool1 = bool2;
          } while (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null);
          if (((SearchBaseActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a() == 0) {
            a().finish();
          }
          return true;
          bool1 = bool2;
        } while (localObject == null);
        bool1 = bool2;
      } while (((List)localObject).size() != 2);
      localObject = SearchBaseActivity.c.matcher(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("SearchContactsFragment", 2, "needJump lastKeywords = " + this.jdField_a_of_type_JavaLangString);
      }
      bool1 = bool2;
    } while (!((Matcher)localObject).matches());
    e();
    a(this.jdField_b_of_type_JavaUtilArrayList);
    if (this.jdField_d_of_type_Int == 1) {
      i = 3;
    }
    for (;;)
    {
      a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, false, i);
      return true;
      if (this.jdField_d_of_type_Int != 0) {
        i = 0;
      }
    }
  }
  
  String a(SearchBaseFragment.ItemViewHolder paramItemViewHolder, SearchContactsFragment.ListItemData paramListItemData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramListItemData.jdField_b_of_type_Int;
    paramItemViewHolder.jdField_a_of_type_JavaLangString = (paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "");
    boolean bool;
    SpannableStringBuilder localSpannableStringBuilder;
    label132:
    Object localObject;
    if (paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() != 0L)
    {
      bool = true;
      paramItemViewHolder.jdField_a_of_type_Boolean = bool;
      paramItemViewHolder.jdField_b_of_type_JavaLangString = paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.mobile.get();
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      localSpannableStringBuilder = new SpannableStringBuilder();
      switch (i)
      {
      default: 
        localObject = PrettyAccountUtil.a(paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uint32_richflag1_59.get(), paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uint32_richflag4_409.get(), localSpannableStringBuilder, paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.accout.get());
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        if ((i == 80000000) && (!TextUtils.isEmpty(paramItemViewHolder.jdField_a_of_type_JavaLangString)) && (Utils.b(paramItemViewHolder.jdField_a_of_type_JavaLangString)))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130841947);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          int j = AIOUtils.a(15.0F, BaseApplication.getContext().getResources());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          ((Drawable)localObject).setBounds(0, 0, j, AIOUtils.a(15.0F, BaseApplication.getContext().getResources()));
          paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
          label286:
          PrettyAccountUtil.a(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView, paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uint32_richflag1_59.get(), paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uint32_richflag4_409.get(), 2131167114, 17);
          localStringBuilder.append(paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
          localStringBuilder.append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
          switch (i)
          {
          default: 
            i = 1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(i, paramItemViewHolder.jdField_a_of_type_JavaLangString);
      paramListItemData = (SearchContactsFragment.ListItemData)localObject;
      if (localObject == null)
      {
        localObject = ImageUtil.c();
        paramListItemData = (SearchContactsFragment.ListItemData)localObject;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramItemViewHolder.jdField_a_of_type_JavaLangString, i, true, (byte)1);
          paramListItemData = (SearchContactsFragment.ListItemData)localObject;
        }
      }
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramListItemData);
      return localStringBuilder.toString();
      bool = false;
      break;
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000000, paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get()));
      localSpannableStringBuilder.append("(");
      if (paramItemViewHolder.jdField_a_of_type_Boolean) {}
      for (localObject = paramItemViewHolder.jdField_a_of_type_JavaLangString;; localObject = paramItemViewHolder.jdField_b_of_type_JavaLangString)
      {
        localSpannableStringBuilder.append(a(80000000, (String)localObject));
        localSpannableStringBuilder.append(")");
        break;
      }
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000002, String.valueOf(paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      break label132;
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000001, String.valueOf(paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      localSpannableStringBuilder.append("(");
      localSpannableStringBuilder.append(a(80000001, String.valueOf(paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get())));
      localSpannableStringBuilder.append(")");
      break label132;
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label286;
      localStringBuilder.append(a(paramItemViewHolder, paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
      continue;
      i = 4;
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get() + HardCodeUtil.a(2131713570));
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131167113));
      paramItemViewHolder.d.setText(paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get());
      paramItemViewHolder.jdField_a_of_type_JavaLangString = String.valueOf(paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
      localStringBuilder.append(paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText()).append(paramItemViewHolder.d.getText());
      continue;
      localStringBuilder.append(b(paramItemViewHolder, paramListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
    }
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
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      g();
    }
    do
    {
      do
      {
        return;
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
      } while (!a());
      localObject1 = getActivity();
      if ((localObject1 != null) && ((localObject1 instanceof SearchContactsActivity)))
      {
        localObject1 = SearchBaseActivity.JumpSrcConstants.a(((SearchContactsActivity)localObject1).a());
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1F", "0X8005D1F", 0, 0, "", (String)localObject1, this.jdField_a_of_type_JavaLangString, "", false);
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList == null);
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      SearchContactsFragment.ListItemData localListItemData = (SearchContactsFragment.ListItemData)((Iterator)localObject2).next();
      if ((localListItemData != null) && (localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) && (localListItemData.jdField_b_of_type_Int == 80000002))
      {
        ((StringBuilder)localObject1).append(String.valueOf(localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get())).append("#");
        i += 1;
      }
    }
    localObject2 = PADetailReportUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    PADetailReportUtil.a().a((String)localObject2, this.jdField_a_of_type_JavaLangString, 2, false, i, ((StringBuilder)localObject1).toString());
  }
  
  void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("last_key_words", this.jdField_a_of_type_JavaLangString);
    int i = 1;
    switch (paramInt1)
    {
    default: 
      paramInt2 = i;
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF1", "0X8004BF1", paramInt1, 0, "", "", "", "");
      return;
      Object localObject2 = a();
      paramInt2 = i;
      if (localObject2 == null) {
        break;
      }
      ((Intent)localObject1).putExtra("from_key", 0);
      ((Intent)localObject1).setClass((Context)localObject2, ClassificationSearchActivity.class);
      ClassificationSearchActivity.a((Activity)localObject2, (Intent)localObject1, a(paramInt1));
      paramInt1 = 1;
      continue;
      long l1 = Double.valueOf(this.jdField_a_of_type_Double * 1000000.0D).longValue();
      long l2 = Double.valueOf(this.jdField_b_of_type_Double * 1000000.0D).longValue();
      localObject2 = "https://qqweb.qq.com/m/relativegroup/index.html?source=qun_rec&keyword=" + URLEncoder.encode(this.jdField_a_of_type_JavaLangString) + "&gpstype=1&sid=AWSAPtjyiVRg92WelXNMAqd0&_bid=165&lon=" + Long.valueOf(l2) + "&lat=" + Long.valueOf(l1) + "&sourceext=" + paramInt2;
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = (String)localObject2 + "&show_tab=hot";
      }
      localObject1 = (String)localObject1 + "&_wv=17039363&_wwv=1293&_cwv=8";
      if (QLog.isColorLevel()) {
        QLog.d("SearchContactsFragment", 2, "call jump ,lastKeywords = " + this.jdField_a_of_type_JavaLangString + " jump url is : " + (String)localObject1);
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
      if (this.jdField_a_of_type_JavaLangString.matches("^\\d{5,11}$")) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_find", "", "inte_add", "inte_find_grp", 0, 0, (String)localObject1, this.jdField_a_of_type_JavaLangString, "", "");
        paramInt1 = 2;
        break;
      }
      ((Intent)localObject1).putExtra("from_key", 2);
      localObject2 = getActivity();
      if ((localObject2 != null) && ((localObject2 instanceof SearchContactsActivity))) {
        ((Intent)localObject1).putExtra("jump_src_key", ((SearchContactsActivity)localObject2).a());
      }
      ((Intent)localObject1).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject1, a(paramInt1));
      paramInt1 = 3;
      paramInt2 = paramInt1;
      if (localObject2 == null) {
        break;
      }
      paramInt2 = paramInt1;
      if (!(localObject2 instanceof SearchBaseActivity)) {
        break;
      }
      paramInt1 = ((SearchBaseActivity)localObject2).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "0", SearchBaseActivity.JumpSrcConstants.a(paramInt1), this.jdField_a_of_type_JavaLangString, "", false);
      paramInt1 = 3;
      continue;
      ((Intent)localObject1).putExtra("from_key", 5);
      ((Intent)localObject1).putExtra("fromType", jdField_b_of_type_Int);
      ((Intent)localObject1).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject1, a(paramInt1));
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, "0", "", this.jdField_a_of_type_JavaLangString, "", false);
      paramInt1 = 1;
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(a(), "/pubaccount/browser");
      localActivityURIRequest.extra().putString("url", paramString1);
      QRoute.startUri(localActivityURIRequest, null);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, paramString2, paramString3, "2");
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsFragment", 2, "doSearch");
    }
    if (NetworkUtil.d(BaseApplicationImpl.getContext()))
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
        }
      }
      else
      {
        if (jdField_b_of_type_Int != 12) {
          break label223;
        }
        localContactSearchFacade = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade;
        if (!this.jdField_a_of_type_Boolean) {
          break label216;
        }
      }
      label216:
      for (int i = this.jdField_a_of_type_Int;; i = 80000006)
      {
        localContactSearchFacade.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 1);
        this.jdField_c_of_type_Boolean = true;
        if (!this.jdField_a_of_type_Boolean) {
          break label268;
        }
        paramString = a(this.jdField_a_of_type_Int);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramString, paramString, this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
        return;
        this.jdField_d_of_type_Boolean = true;
        break;
      }
      label223:
      ContactSearchFacade localContactSearchFacade = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade;
      if (this.jdField_a_of_type_Boolean) {}
      for (i = this.jdField_a_of_type_Int;; i = 80000005)
      {
        localContactSearchFacade.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 0);
        break;
      }
      label268:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BED", "0X8004BED", this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131694459, 0).b(b());
  }
  
  protected boolean a(ArrayList<SearchResult> paramArrayList)
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
      this.g = ReportUtil.a(paramArrayList, this.e);
      if (!b(this.jdField_b_of_type_JavaUtilArrayList))
      {
        this.jdField_a_of_type_JavaUtilArrayList = b(a(paramArrayList));
        e();
        a(this.jdField_b_of_type_JavaUtilArrayList);
        bool = true;
      }
    }
    do
    {
      return bool;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
      e();
      a(this.jdField_b_of_type_JavaUtilArrayList);
    } while (b(this.jdField_b_of_type_JavaUtilArrayList));
    int i;
    if (this.jdField_d_of_type_Int == 1) {
      i = 3;
    }
    for (;;)
    {
      a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, false, i);
      return false;
      if (this.jdField_d_of_type_Int == 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  ArrayList<SearchContactsFragment.ListItemData> b(ArrayList<SearchResult> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(12);
    int n = paramArrayList.size();
    int j = 0;
    SearchResult localSearchResult;
    for (;;)
    {
      if (j < n)
      {
        localSearchResult = (SearchResult)paramArrayList.get(j);
        if ((localSearchResult == null) || ((localSearchResult.jdField_b_of_type_JavaUtilList.size() <= 0) && (localSearchResult.jdField_c_of_type_JavaUtilList.size() <= 0)))
        {
          j += 1;
        }
        else
        {
          localObject = new SearchContactsFragment.ListItemData();
          ((SearchContactsFragment.ListItemData)localObject).jdField_a_of_type_Int = 0;
          ((SearchContactsFragment.ListItemData)localObject).jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
          ((SearchContactsFragment.ListItemData)localObject).jdField_a_of_type_Boolean = localSearchResult.jdField_c_of_type_Boolean;
          if (ViewFactory.a(localSearchResult.jdField_a_of_type_Int) == 2131689664)
          {
            ((SearchContactsFragment.ListItemData)localObject).jdField_a_of_type_JavaLangString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
            label148:
            localArrayList.add(localObject);
            if (TextUtils.isEmpty(localSearchResult.jdField_a_of_type_JavaLangString)) {
              break label853;
            }
          }
        }
      }
    }
    label842:
    label853:
    for (Object localObject = localSearchResult.jdField_a_of_type_JavaLangString;; localObject = null)
    {
      SearchContactsFragment.ListItemData localListItemData;
      if ((localSearchResult.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) && (localSearchResult.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.has()))
      {
        localListItemData = new SearchContactsFragment.ListItemData();
        localListItemData.jdField_a_of_type_Int = 2;
        localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = localSearchResult.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
        localListItemData.jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
        localListItemData.jdField_c_of_type_Int = localSearchResult.jdField_c_of_type_Int;
        localListItemData.jdField_b_of_type_JavaLangString = ((String)localObject);
        localArrayList.add(localListItemData);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F75", "0X8006F75", 0, 0, this.jdField_a_of_type_JavaLangString, localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
      }
      for (int i = 2;; i = 3)
      {
        int m;
        int k;
        if (localSearchResult.jdField_a_of_type_Int == 80000004)
        {
          m = localSearchResult.jdField_c_of_type_JavaUtilList.size();
          k = 0;
          label343:
          if (k < i)
          {
            localObject = new SearchContactsFragment.ListItemData();
            ((SearchContactsFragment.ListItemData)localObject).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem = ((AccountSearchPb.ResultItem)localSearchResult.jdField_c_of_type_JavaUtilList.get(k));
            ((SearchContactsFragment.ListItemData)localObject).jdField_a_of_type_Int = 2;
            ((SearchContactsFragment.ListItemData)localObject).jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
            localArrayList.add(localObject);
            if (k < m - 1) {}
          }
          else
          {
            i = m;
          }
        }
        for (;;)
        {
          if (i > 3)
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
          if (QLog.isColorLevel()) {
            QLog.d("SearchContactsFragment", 2, "search reuslt : type = " + localSearchResult.jdField_a_of_type_Int + "count = " + localSearchResult.jdField_b_of_type_JavaUtilList.size());
          }
          localObject = "";
          switch (localSearchResult.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            ReportController.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, String.valueOf(Math.min(i, 3)), "", "", "");
            break;
            ((SearchContactsFragment.ListItemData)localObject).jdField_a_of_type_JavaLangString = a().getString(ViewFactory.a(localSearchResult.jdField_a_of_type_Int));
            break label148;
            k += 1;
            break label343;
            k = localSearchResult.jdField_b_of_type_JavaUtilList.size();
            m = 0;
            for (;;)
            {
              if (m >= i) {
                break label842;
              }
              localListItemData = new SearchContactsFragment.ListItemData();
              localListItemData.jdField_a_of_type_Int = 2;
              localListItemData.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)localSearchResult.jdField_b_of_type_JavaUtilList.get(m));
              localListItemData.jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
              localListItemData.jdField_c_of_type_Int = localSearchResult.jdField_c_of_type_Int;
              localListItemData.jdField_b_of_type_JavaLangString = ((String)localObject);
              localListItemData.jdField_a_of_type_Boolean = localSearchResult.jdField_c_of_type_Boolean;
              localArrayList.add(localListItemData);
              if (m >= k - 1)
              {
                i = k;
                break;
              }
              if (localSearchResult.jdField_a_of_type_Int == 80000001) {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "exp", 0, 0, "", "", "", "");
              }
              m += 1;
            }
            localObject = "0X80061B8";
            continue;
            localObject = "0X80061BB";
            continue;
            localObject = "0X80061BE";
            continue;
            localObject = "0X80061C1";
          }
          return localArrayList;
          i = k;
        }
      }
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.a(c(), paramString);
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
    if ((80000001 == this.jdField_a_of_type_Int) && (((MayknowRecommendManager)localObject).jdField_d_of_type_Boolean)) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopRecommendTroopListWrapper == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopRecommendTroopListWrapper = new RecommendTroopListWrapperForSearchEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, null);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopRecommendTroopListWrapper.a();
        TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localTextView.setGravity(17);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.a(105.0F, getResources())));
        localTextView.setTextColor(getResources().getColor(2131167117));
        localTextView.setTextSize(1, 17.0F);
        localTextView.setText(HardCodeUtil.a(2131713577));
        localTextView.setBackgroundResource(2130838980);
        ((ListView)localObject).addHeaderView(localTextView);
        localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localTextView.setTextColor(getResources().getColor(2131167117));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setGravity(16);
        localTextView.setPadding(AIOUtils.a(15.0F, getResources()), 0, 0, 0);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.a(40.0F, getResources())));
        localTextView.setText(HardCodeUtil.a(2131713568));
        localTextView.setBackgroundResource(2130838980);
        ((ListView)localObject).addHeaderView(localTextView);
        a(this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopRecommendTroopListWrapper.a());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopRecommendTroopListWrapper.e();
      break;
      super.g();
    }
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {}
    }
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) == this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.setListener(new SearchContactsFragment.5(this));
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject != null) {
      if ((localObject instanceof SearchBaseFragment.ItemViewHolder)) {
        a((SearchBaseFragment.ItemViewHolder)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof NearbyTroops.CustomViewHolder))
      {
        a((NearbyTroops.CustomViewHolder)localObject);
      }
      else if ((localObject instanceof SearchBaseFragment.ArticleItemViewHolder))
      {
        a((SearchBaseFragment.ArticleItemViewHolder)localObject);
        continue;
        if ((paramView instanceof QzoneSearchResultView)) {
          ((QzoneSearchResultView)paramView).doClick(getActivity());
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$SearchResultAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$SearchResultAdapter.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener != null) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopRecommendTroopListWrapper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopRecommendTroopListWrapper.c();
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
    if ((this.jdField_d_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment
 * JD-Core Version:    0.7.0.1
 */