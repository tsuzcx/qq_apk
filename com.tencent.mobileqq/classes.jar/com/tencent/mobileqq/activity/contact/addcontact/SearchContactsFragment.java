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
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.ResultItem;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import wok;
import wol;
import wom;
import won;
import woo;

public class SearchContactsFragment
  extends SearchBaseFragment
{
  private static int jdField_b_of_type_Int = -1;
  private double jdField_a_of_type_Double;
  public int a;
  private ViewFactory.GuideView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView;
  protected SosoInterface.OnLocationListener a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public wom a;
  private woo jdField_a_of_type_Woo;
  public boolean a;
  private double jdField_b_of_type_Double;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private Map jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private String c;
  private String d;
  private String e;
  
  public SearchContactsFragment()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new wok(this, 0, true, false, 60000L, false, false, "SearchContacts");
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
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
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        won localwon = (won)localIterator.next();
        if ((localwon != null) && (localwon.jdField_b_of_type_Int == 80000002)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = ((SearchResult)paramArrayList.get(0)).b;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        int i = ((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int;
        if (i == 80000003) {
          return false;
        }
        long l = ((AccountSearchPb.record)localObject).code.get();
        if ((i == 80000001) && (!TextUtils.isEmpty(this.e)) && (!String.valueOf(l).equals(this.e))) {
          return false;
        }
        a(i, (AccountSearchPb.record)localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
          return false;
        }
        if (((SearchBaseActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a() == 0) {
          a().finish();
        }
        return true;
      }
      if ((localObject != null) && (((List)localObject).size() == 2))
      {
        localObject = SearchBaseActivity.c.matcher(this.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "needJump lastKeywords = " + this.jdField_a_of_type_JavaLangString);
        }
        if (((Matcher)localObject).matches())
        {
          e();
          a(this.jdField_b_of_type_JavaUtilArrayList);
          a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, false);
          return true;
        }
      }
    }
    return false;
  }
  
  public String a(SearchBaseFragment.ItemViewHolder paramItemViewHolder, won paramwon)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramwon.jdField_b_of_type_Int;
    paramItemViewHolder.jdField_a_of_type_JavaLangString = (paramwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "");
    boolean bool;
    SpannableStringBuilder localSpannableStringBuilder;
    label132:
    Object localObject;
    if (paramwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() != 0L)
    {
      bool = true;
      paramItemViewHolder.jdField_a_of_type_Boolean = bool;
      paramItemViewHolder.jdField_b_of_type_JavaLangString = paramwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.mobile.get();
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      localSpannableStringBuilder = new SpannableStringBuilder();
      switch (i)
      {
      default: 
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
        if ((i == 80000000) && (!TextUtils.isEmpty(paramItemViewHolder.jdField_a_of_type_JavaLangString)) && (Utils.b(paramItemViewHolder.jdField_a_of_type_JavaLangString)))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839766);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          int j = AIOUtils.a(15.0F, BaseApplication.getContext().getResources());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          ((Drawable)localObject).setBounds(0, 0, j, AIOUtils.a(15.0F, BaseApplication.getContext().getResources()));
          paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
          label249:
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i, paramItemViewHolder.jdField_a_of_type_JavaLangString);
      paramwon = (won)localObject;
      if (localObject == null)
      {
        localObject = ImageUtil.a();
        paramwon = (won)localObject;
        if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramItemViewHolder.jdField_a_of_type_JavaLangString, i, true, (byte)1);
          paramwon = (won)localObject;
        }
      }
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramwon);
      return localStringBuilder.toString();
      bool = false;
      break;
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000000, paramwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get()));
      localSpannableStringBuilder.append("(");
      if (paramItemViewHolder.jdField_a_of_type_Boolean) {}
      for (localObject = paramItemViewHolder.jdField_a_of_type_JavaLangString;; localObject = paramItemViewHolder.jdField_b_of_type_JavaLangString)
      {
        localSpannableStringBuilder.append(a(80000000, (String)localObject));
        localSpannableStringBuilder.append(")");
        break;
      }
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000002, String.valueOf(paramwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      break label132;
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000001, String.valueOf(paramwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      localSpannableStringBuilder.append("(");
      localSpannableStringBuilder.append(a(80000001, String.valueOf(paramwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get())));
      localSpannableStringBuilder.append(")");
      break label132;
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label249;
      localStringBuilder.append(a(paramItemViewHolder, paramwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
      continue;
      i = 4;
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get() + "人");
      paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131494270));
      paramItemViewHolder.d.setText(paramwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get());
      paramItemViewHolder.jdField_a_of_type_JavaLangString = String.valueOf(paramwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
      localStringBuilder.append(paramItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText()).append(paramItemViewHolder.d.getText());
      continue;
      localStringBuilder.append(b(paramItemViewHolder, paramwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
    }
  }
  
  ArrayList a(ArrayList paramArrayList)
  {
    int[] arrayOfInt = ViewFactory.a(b());
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
        if (this.jdField_a_of_type_Woo == null)
        {
          this.jdField_a_of_type_Woo = new woo(this, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 4, true);
          this.jdField_a_of_type_Woo.a(this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Woo);
          this.a = this.jdField_a_of_type_Woo;
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
        }
        this.jdField_a_of_type_Woo.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Woo.notifyDataSetChanged();
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
        PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1F", "0X8005D1F", 0, 0, "", (String)localObject1, this.jdField_a_of_type_JavaLangString, "", false);
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList == null);
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      won localwon = (won)((Iterator)localObject2).next();
      if ((localwon != null) && (localwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) && (localwon.jdField_b_of_type_Int == 80000002))
      {
        ((StringBuilder)localObject1).append(String.valueOf(localwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get())).append("#");
        i += 1;
      }
    }
    localObject2 = PADetailReportUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    PADetailReportUtil.a().a((String)localObject2, this.jdField_a_of_type_JavaLangString, 2, false, i, ((StringBuilder)localObject1).toString());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("last_key_words", this.jdField_a_of_type_JavaLangString);
    int i = 1;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF1", "0X8004BF1", paramInt, 0, "", "", "", "");
      return;
      Object localObject2 = a();
      if (localObject2 == null) {
        break;
      }
      ((Intent)localObject1).putExtra("from_key", 0);
      ((Intent)localObject1).setClass((Context)localObject2, ClassificationSearchActivity.class);
      ClassificationSearchActivity.a((Activity)localObject2, (Intent)localObject1, a(paramInt));
      paramInt = 1;
      continue;
      long l1 = Double.valueOf(this.jdField_a_of_type_Double * 1000000.0D).longValue();
      long l2 = Double.valueOf(this.jdField_b_of_type_Double * 1000000.0D).longValue();
      localObject2 = "http://qqweb.qq.com/m/relativegroup/index.html?source=qun_rec&keyword=" + URLEncoder.encode(this.jdField_a_of_type_JavaLangString) + "&gpstype=1&sid=AWSAPtjyiVRg92WelXNMAqd0&_bid=165&lon=" + Long.valueOf(l2) + "&lat=" + Long.valueOf(l1);
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = (String)localObject2 + "&show_tab=hot";
      }
      if (QLog.isColorLevel()) {
        QLog.d("SearchContactsFragment", 2, "lastKeywords = " + this.jdField_a_of_type_JavaLangString + " jump url is : " + (String)localObject1);
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
        ReportController.b((QQAppInterface)localObject2, "dc00899", "Grp_find", "", "inte_add", "inte_find_grp", 0, 0, (String)localObject1, this.jdField_a_of_type_JavaLangString, "", "");
        paramInt = 2;
        break;
      }
      ((Intent)localObject1).putExtra("from_key", 2);
      localObject2 = getActivity();
      if ((localObject2 != null) && ((localObject2 instanceof SearchContactsActivity))) {
        ((Intent)localObject1).putExtra("jump_src_key", ((SearchContactsActivity)localObject2).a());
      }
      ((Intent)localObject1).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject1, a(paramInt));
      paramInt = 3;
      i = paramInt;
      if (localObject2 == null) {
        break;
      }
      i = paramInt;
      if (!(localObject2 instanceof SearchBaseActivity)) {
        break;
      }
      paramInt = ((SearchBaseActivity)localObject2).a();
      PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "0", SearchBaseActivity.JumpSrcConstants.a(paramInt), this.jdField_a_of_type_JavaLangString, "", false);
      paramInt = 3;
      continue;
      ((Intent)localObject1).putExtra("from_key", 5);
      ((Intent)localObject1).putExtra("fromType", jdField_b_of_type_Int);
      ((Intent)localObject1).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject1, a(paramInt));
      PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, "0", "", this.jdField_a_of_type_JavaLangString, "", false);
      paramInt = 1;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Intent localIntent = new Intent(a(), PublicAccountBrowser.class);
      localIntent.putExtra("url", paramString1);
      a().startActivity(localIntent);
      PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, paramString2, paramString3, "2");
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
      h();
      this.jdField_a_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "doSearch:should not be here | searchFacade = null");
        }
        i();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.c();
      if (jdField_b_of_type_Int == 12)
      {
        localContactSearchFacade = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade;
        if (this.jdField_a_of_type_Boolean) {}
        for (i = this.jdField_a_of_type_Int;; i = 80000006)
        {
          localContactSearchFacade.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 1);
          this.jdField_c_of_type_Boolean = true;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          paramString = a(this.jdField_a_of_type_Int);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramString, paramString, this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
          return;
        }
      }
      ContactSearchFacade localContactSearchFacade = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade;
      if (this.jdField_a_of_type_Boolean) {}
      for (int i = this.jdField_a_of_type_Int;; i = 80000005)
      {
        localContactSearchFacade.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 0);
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BED", "0X8004BED", this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131434827, 0).b(a());
  }
  
  protected boolean a(ArrayList paramArrayList)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
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
    if (!b(this.jdField_b_of_type_JavaUtilArrayList)) {
      a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, false);
    }
    return false;
  }
  
  ArrayList b(ArrayList paramArrayList)
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
        if ((localSearchResult == null) || ((localSearchResult.b.size() <= 0) && (localSearchResult.jdField_c_of_type_JavaUtilList.size() <= 0)))
        {
          j += 1;
        }
        else
        {
          localObject = new won();
          ((won)localObject).jdField_a_of_type_Int = 0;
          ((won)localObject).jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
          if (ViewFactory.a(localSearchResult.jdField_a_of_type_Int) == 2131435525)
          {
            ((won)localObject).jdField_a_of_type_JavaLangString = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
            label127:
            localArrayList.add(localObject);
            if (TextUtils.isEmpty(localSearchResult.jdField_a_of_type_JavaLangString)) {
              break label816;
            }
          }
        }
      }
    }
    label805:
    label816:
    for (Object localObject = localSearchResult.jdField_a_of_type_JavaLangString;; localObject = null)
    {
      won localwon;
      int i;
      if ((localSearchResult.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) && (localSearchResult.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.has()))
      {
        localwon = new won();
        localwon.jdField_a_of_type_Int = 2;
        localwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = localSearchResult.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
        localwon.jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
        localwon.jdField_c_of_type_Int = localSearchResult.jdField_c_of_type_Int;
        localwon.jdField_b_of_type_JavaLangString = ((String)localObject);
        localArrayList.add(localwon);
        i = 2;
        PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F75", "0X8006F75", 0, 0, this.jdField_a_of_type_JavaLangString, localwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
      }
      for (;;)
      {
        int m;
        int k;
        if (localSearchResult.jdField_a_of_type_Int == 80000004)
        {
          m = localSearchResult.jdField_c_of_type_JavaUtilList.size();
          k = 0;
          label314:
          if (k < i)
          {
            localObject = new won();
            ((won)localObject).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem = ((AccountSearchPb.ResultItem)localSearchResult.jdField_c_of_type_JavaUtilList.get(k));
            ((won)localObject).jdField_a_of_type_Int = 2;
            ((won)localObject).jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
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
            localObject = new won();
            ((won)localObject).jdField_a_of_type_Int = 1;
            ((won)localObject).jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
            ((won)localObject).jdField_c_of_type_Int = localSearchResult.jdField_c_of_type_Int;
            if (localSearchResult.jdField_a_of_type_Int == 80000004) {
              ((won)localObject).jdField_c_of_type_JavaLangString = localSearchResult.jdField_a_of_type_JavaLangString;
            }
            localArrayList.add(localObject);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SearchContactsFragment", 2, "search reuslt : type = " + localSearchResult.jdField_a_of_type_Int + "count = " + localSearchResult.b.size());
          }
          localObject = "";
          switch (localSearchResult.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            ReportController.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, String.valueOf(Math.min(i, 3)), "", "", "");
            break;
            ((won)localObject).jdField_a_of_type_JavaLangString = a().getString(ViewFactory.a(localSearchResult.jdField_a_of_type_Int));
            break label127;
            k += 1;
            break label314;
            k = localSearchResult.b.size();
            m = 0;
            for (;;)
            {
              if (m >= i) {
                break label805;
              }
              localwon = new won();
              localwon.jdField_a_of_type_Int = 2;
              localwon.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)localSearchResult.b.get(m));
              localwon.jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
              localwon.jdField_c_of_type_Int = localSearchResult.jdField_c_of_type_Int;
              localwon.jdField_b_of_type_JavaLangString = ((String)localObject);
              localArrayList.add(localwon);
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
        i = 3;
      }
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView = ((ViewFactory.GuideView)ViewFactory.a().a(80000005, a(), true));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {}
    }
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) == this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.setListener(new wol(this));
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
  }
  
  void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.a(b(), paramString);
    }
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      b();
      b(paramString);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void k()
  {
    super.k();
    e();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null) {
      if ((localObject1 instanceof SearchBaseFragment.ItemViewHolder))
      {
        localObject2 = (SearchBaseFragment.ItemViewHolder)localObject1;
        a(((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_Int, ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_Int), 0, "", "", "", "");
        localObject3 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_Int));
        localObject1 = null;
        paramView = (View)localObject1;
        if (localObject2 != null)
        {
          paramView = (View)localObject1;
          if (((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null)
          {
            paramView = (View)localObject1;
            if (((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin != null) {
              paramView = String.valueOf(((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get());
            }
          }
        }
        j = ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_Int;
        if (localObject3 != null)
        {
          i = ((Integer)localObject3).intValue();
          SearchUtils.a(j, i, ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_c_of_type_Int, true, paramView, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
          if (((SearchBaseFragment.ItemViewHolder)localObject2).jdField_b_of_type_Int == 80000002)
          {
            localObject1 = ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
            paramView = getActivity();
            if ((localObject1 != null) && (paramView != null) && ((paramView instanceof SearchBaseActivity)))
            {
              i = ((SearchBaseActivity)paramView).a();
              localObject3 = PADetailReportUtil.a();
              if (((AccountSearchPb.record)localObject1).uin == null) {
                break label404;
              }
              paramView = ((AccountSearchPb.record)localObject1).uin.get() + "";
              ((PADetailReportUtil)localObject3).a(2, paramView, ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_c_of_type_Int, jdField_b_of_type_Int);
              if (jdField_b_of_type_Int != 12) {
                break label416;
              }
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject2 = ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_c_of_type_Int + "";
              str = SearchBaseActivity.JumpSrcConstants.a(i);
              if (((AccountSearchPb.record)localObject1).uin == null) {
                break label410;
              }
              paramView = ((AccountSearchPb.record)localObject1).uin.get() + "";
              ReportController.b((QQAppInterface)localObject3, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, (String)localObject2, str, paramView, this.jdField_a_of_type_JavaLangString);
            }
          }
        }
      }
    }
    label404:
    label410:
    label416:
    label856:
    label996:
    while (!(paramView instanceof QzoneSearchResultView))
    {
      do
      {
        do
        {
          for (;;)
          {
            int j;
            String str;
            return;
            i = 0;
            continue;
            paramView = "";
            continue;
            paramView = "";
          }
          Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (((AccountSearchPb.record)localObject1).uin != null) {}
          for (paramView = ((AccountSearchPb.record)localObject1).uin.get() + "";; paramView = "")
          {
            PublicAccountReportUtils.a((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", paramView, "0X8005D20", "0X8005D20", 0, 0, ((SearchBaseFragment.ItemViewHolder)localObject2).jdField_c_of_type_Int + "", SearchBaseActivity.JumpSrcConstants.a(i), this.jdField_a_of_type_JavaLangString, "", false);
            return;
          }
          if ((localObject1 instanceof NearbyTroops.CustomViewHolder))
          {
            paramView = (NearbyTroops.CustomViewHolder)localObject1;
            localObject1 = TroopInfoActivity.a(paramView.jdField_a_of_type_JavaLangString, 2);
            ((Bundle)localObject1).putInt("exposureSource", 3);
            ((Bundle)localObject1).putInt("t_s_f", 1000);
            ChatSettingForTroop.a(a(), (Bundle)localObject1, 2);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(80000001), 0, "", "", "", "");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_grpdate", 0, 0, paramView.jdField_a_of_type_JavaLangString, "", "", "");
            localObject1 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000001));
            if (localObject1 != null) {}
            for (i = ((Integer)localObject1).intValue();; i = 0)
            {
              SearchUtils.a(80000001, i, paramView.jdField_a_of_type_Int, true, paramView.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
              return;
            }
          }
        } while (!(localObject1 instanceof SearchBaseFragment.ArticleItemViewHolder));
        paramView = getActivity();
      } while (paramView == null);
      localObject1 = (SearchBaseFragment.ArticleItemViewHolder)localObject1;
      Object localObject2 = new Intent(paramView, PublicAccountBrowser.class);
      ((Intent)localObject2).putExtra("url", ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_JavaLangString);
      if (jdField_b_of_type_Int == 13)
      {
        ((Intent)localObject2).putExtra("articalChannelId", 12);
        paramView.startActivity((Intent)localObject2);
        if (jdField_b_of_type_Int != 12) {
          break label996;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "" + ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_Long);
        paramView = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000003));
        if (paramView == null) {
          break label1076;
        }
      }
      for (int i = paramView.intValue();; i = 0)
      {
        SearchUtils.a(80000003, i, ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_Int, true, null, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
        return;
        if (jdField_b_of_type_Int == 1)
        {
          ((Intent)localObject2).putExtra("articalChannelId", 10);
          if ((localObject1 == null) || (((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_b_of_type_JavaLangString == null)) {
            break;
          }
          PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_b_of_type_JavaLangString, ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_c_of_type_JavaLangString, "1");
          break;
        }
        if (jdField_b_of_type_Int != 2) {
          break;
        }
        ((Intent)localObject2).putExtra("articalChannelId", 11);
        break;
        PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "" + ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + ((SearchBaseFragment.ArticleItemViewHolder)localObject1).jdField_a_of_type_Long, false);
        break label856;
      }
    }
    label1076:
    ((QzoneSearchResultView)paramView).a(getActivity());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Woo != null) {
      this.jdField_a_of_type_Woo.Z_();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null) {
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment
 * JD-Core Version:    0.7.0.1
 */