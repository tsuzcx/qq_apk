package com.tencent.mobileqq.activity.contact.addcontact;

import aepi;
import ahex;
import ahfb;
import ahhd;
import ahhx;
import ahic;
import ahid;
import ahih;
import ahii;
import ahij;
import ahik;
import ahil;
import ahim;
import ahin;
import ahio;
import ahip;
import ahke;
import ahkj;
import alud;
import alwd;
import ampt;
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
import ayvh;
import ayvm;
import azqs;
import bbph;
import bcpx;
import bdbb;
import bdeu;
import bdhj;
import bdin;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.ResultItem;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import nrt;
import swe;
import swy;

public class SearchContactsFragment
  extends SearchBaseFragment
{
  private static int jdField_b_of_type_Int = -1;
  private double jdField_a_of_type_Double;
  public int a;
  private ahex jdField_a_of_type_Ahex;
  public ahim a;
  private ahio jdField_a_of_type_Ahio;
  ahkj jdField_a_of_type_Ahkj = new ahii(this);
  protected ampt a;
  private ViewFactory.GuideView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView;
  private GroupSearchRecommendView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView;
  ArrayList<ahin> jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private double jdField_b_of_type_Double;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<ahip> jdField_b_of_type_JavaUtilArrayList;
  private Map<Integer, Integer> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private String c;
  private String d;
  public boolean d;
  private String e;
  private int g = 2;
  
  public SearchContactsFragment()
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Ampt = new ahih(this, 0, true, false, 60000L, false, false, "SearchContacts");
    SosoInterface.a(this.jdField_a_of_type_Ampt);
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
  
  private ahip a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ahip localahip = (ahip)localIterator.next();
      if (localahip.jdField_a_of_type_Int == paramInt) {
        return localahip;
      }
    }
    return null;
  }
  
  public static SearchContactsFragment a(int paramInt)
  {
    jdField_b_of_type_Int = paramInt;
    return new SearchContactsFragment();
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
        ahin localahin = (ahin)localIterator.next();
        if ((localahin != null) && (localahin.jdField_b_of_type_Int == 80000002)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(ArrayList<ahip> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = (ahip)paramArrayList.get(0);
      if (((ahip)localObject).jdField_b_of_type_Boolean)
      {
        paramArrayList = "http://sqimg.qq.com/qq_product_operations/tiqq/suicide/?keyword=" + URLEncoder.encode(this.jdField_a_of_type_JavaLangString);
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
        return true;
      }
      localObject = ((ahip)localObject).jdField_b_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        int i = ((ahip)paramArrayList.get(0)).jdField_a_of_type_Int;
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
          a(((ahip)paramArrayList.get(0)).jdField_a_of_type_Int, false);
          return true;
        }
      }
    }
    return false;
  }
  
  public String a(ahid paramahid, ahin paramahin)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramahin.jdField_b_of_type_Int;
    paramahid.jdField_a_of_type_JavaLangString = (paramahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "");
    boolean bool;
    SpannableStringBuilder localSpannableStringBuilder;
    label132:
    Object localObject;
    if (paramahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() != 0L)
    {
      bool = true;
      paramahid.jdField_a_of_type_Boolean = bool;
      paramahid.jdField_b_of_type_JavaLangString = paramahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.mobile.get();
      paramahid.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      localSpannableStringBuilder = new SpannableStringBuilder();
      switch (i)
      {
      default: 
        paramahid.jdField_b_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
        if ((i == 80000000) && (!TextUtils.isEmpty(paramahid.jdField_a_of_type_JavaLangString)) && (bdeu.b(paramahid.jdField_a_of_type_JavaLangString)))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130841432);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          int j = aepi.a(15.0F, BaseApplication.getContext().getResources());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          ((Drawable)localObject).setBounds(0, 0, j, aepi.a(15.0F, BaseApplication.getContext().getResources()));
          paramahid.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
          label249:
          localStringBuilder.append(paramahid.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
          localStringBuilder.append(paramahid.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
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
      localObject = this.jdField_a_of_type_Bdbb.a(i, paramahid.jdField_a_of_type_JavaLangString);
      paramahin = (ahin)localObject;
      if (localObject == null)
      {
        localObject = bdhj.a();
        paramahin = (ahin)localObject;
        if (!this.jdField_a_of_type_Bdbb.a())
        {
          this.jdField_a_of_type_Bdbb.a(paramahid.jdField_a_of_type_JavaLangString, i, true, (byte)1);
          paramahin = (ahin)localObject;
        }
      }
      paramahid.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramahin);
      return localStringBuilder.toString();
      bool = false;
      break;
      paramahid.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000000, paramahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get()));
      localSpannableStringBuilder.append("(");
      if (paramahid.jdField_a_of_type_Boolean) {}
      for (localObject = paramahid.jdField_a_of_type_JavaLangString;; localObject = paramahid.jdField_b_of_type_JavaLangString)
      {
        localSpannableStringBuilder.append(a(80000000, (String)localObject));
        localSpannableStringBuilder.append(")");
        break;
      }
      paramahid.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000002, String.valueOf(paramahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      break label132;
      paramahid.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000001, String.valueOf(paramahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      localSpannableStringBuilder.append("(");
      localSpannableStringBuilder.append(a(80000001, String.valueOf(paramahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get())));
      localSpannableStringBuilder.append(")");
      break label132;
      paramahid.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label249;
      localStringBuilder.append(a(paramahid, paramahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
      continue;
      i = 4;
      paramahid.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramahid.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramahid.jdField_c_of_type_AndroidWidgetTextView.setText(paramahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get() + alud.a(2131714007));
      paramahid.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166977));
      paramahid.d.setText(paramahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get());
      paramahid.jdField_a_of_type_JavaLangString = String.valueOf(paramahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
      localStringBuilder.append(paramahid.jdField_c_of_type_AndroidWidgetTextView.getText()).append(paramahid.d.getText());
      continue;
      localStringBuilder.append(b(paramahid, paramahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
    }
  }
  
  ArrayList<ahip> a(ArrayList<ahip> paramArrayList)
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
        ahip localahip = (ahip)localIterator.next();
        if (localahip.jdField_a_of_type_Int == k) {
          localArrayList.add(localahip);
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
        if (this.jdField_a_of_type_Ahio == null)
        {
          this.jdField_a_of_type_Ahio = new ahio(this, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 4, true);
          this.jdField_a_of_type_Ahio.a(this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahio);
          this.a = this.jdField_a_of_type_Ahio;
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
        }
        this.jdField_a_of_type_Ahio.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Ahio.notifyDataSetChanged();
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
        }
      } while (!a());
      localObject1 = getActivity();
      if ((localObject1 != null) && ((localObject1 instanceof SearchContactsActivity)))
      {
        localObject1 = ahhx.a(((SearchContactsActivity)localObject1).a());
        nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1F", "0X8005D1F", 0, 0, "", (String)localObject1, this.jdField_a_of_type_JavaLangString, "", false);
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList == null);
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      ahin localahin = (ahin)((Iterator)localObject2).next();
      if ((localahin != null) && (localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) && (localahin.jdField_b_of_type_Int == 80000002))
      {
        ((StringBuilder)localObject1).append(String.valueOf(localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get())).append("#");
        i += 1;
      }
    }
    localObject2 = swe.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    swe.a().a((String)localObject2, this.jdField_a_of_type_JavaLangString, 2, false, i, ((StringBuilder)localObject1).toString());
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
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF1", "0X8004BF1", paramInt, 0, "", "", "", "");
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
      localObject2 = "https://qqweb.qq.com/m/relativegroup/index.html?source=qun_rec&keyword=" + URLEncoder.encode(this.jdField_a_of_type_JavaLangString) + "&gpstype=1&sid=AWSAPtjyiVRg92WelXNMAqd0&_bid=165&lon=" + Long.valueOf(l2) + "&lat=" + Long.valueOf(l1);
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
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_more", 0, 0, "", "", "", "");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_JavaLangString.matches("^\\d{5,11}$")) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        azqs.b((QQAppInterface)localObject2, "dc00899", "Grp_find", "", "inte_add", "inte_find_grp", 0, 0, (String)localObject1, this.jdField_a_of_type_JavaLangString, "", "");
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
      nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "0", ahhx.a(paramInt), this.jdField_a_of_type_JavaLangString, "", false);
      paramInt = 3;
      continue;
      ((Intent)localObject1).putExtra("from_key", 5);
      ((Intent)localObject1).putExtra("fromType", jdField_b_of_type_Int);
      ((Intent)localObject1).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject1, a(paramInt));
      nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, "0", "", this.jdField_a_of_type_JavaLangString, "", false);
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
      nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, paramString2, paramString3, "2");
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsFragment", 2, "doSearch");
    }
    if (bdin.d(BaseApplicationImpl.getContext()))
    {
      h();
      this.jdField_a_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_Ahhd == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "doSearch:should not be here | searchFacade = null");
        }
        i();
        return;
      }
      this.jdField_a_of_type_Ahhd.c();
      if (this.jdField_d_of_type_Int == 1)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Int = 80000001;
        if (this.jdField_d_of_type_Boolean) {
          ahke.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
        }
      }
      else
      {
        if (jdField_b_of_type_Int != 12) {
          break label223;
        }
        localahhd = this.jdField_a_of_type_Ahhd;
        if (!this.jdField_a_of_type_Boolean) {
          break label216;
        }
      }
      label216:
      for (int i = this.jdField_a_of_type_Int;; i = 80000006)
      {
        localahhd.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 1);
        this.jdField_c_of_type_Boolean = true;
        if (!this.jdField_a_of_type_Boolean) {
          break label268;
        }
        paramString = a(this.jdField_a_of_type_Int);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramString, paramString, this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
        return;
        this.jdField_d_of_type_Boolean = true;
        break;
      }
      label223:
      ahhd localahhd = this.jdField_a_of_type_Ahhd;
      if (this.jdField_a_of_type_Boolean) {}
      for (i = this.jdField_a_of_type_Int;; i = 80000005)
      {
        localahhd.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 0);
        break;
      }
      label268:
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BED", "0X8004BED", this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131694768, 0).b(b());
  }
  
  protected boolean a(ArrayList<ahip> paramArrayList)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
      this.g = ayvh.a(paramArrayList, this.e);
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
      a(((ahip)paramArrayList.get(0)).jdField_a_of_type_Int, false);
    }
    return false;
  }
  
  ArrayList<ahin> b(ArrayList<ahip> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(12);
    int n = paramArrayList.size();
    int j = 0;
    ahip localahip;
    for (;;)
    {
      if (j < n)
      {
        localahip = (ahip)paramArrayList.get(j);
        if ((localahip == null) || ((localahip.jdField_b_of_type_JavaUtilList.size() <= 0) && (localahip.jdField_c_of_type_JavaUtilList.size() <= 0)))
        {
          j += 1;
        }
        else
        {
          localObject = new ahin();
          ((ahin)localObject).jdField_a_of_type_Int = 0;
          ((ahin)localObject).jdField_b_of_type_Int = localahip.jdField_a_of_type_Int;
          if (ViewFactory.a(localahip.jdField_a_of_type_Int) == 2131689767)
          {
            ((ahin)localObject).jdField_a_of_type_JavaLangString = swy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
            label127:
            localArrayList.add(localObject);
            if (TextUtils.isEmpty(localahip.jdField_a_of_type_JavaLangString)) {
              break label816;
            }
          }
        }
      }
    }
    label805:
    label816:
    for (Object localObject = localahip.jdField_a_of_type_JavaLangString;; localObject = null)
    {
      ahin localahin;
      int i;
      if ((localahip.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) && (localahip.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.has()))
      {
        localahin = new ahin();
        localahin.jdField_a_of_type_Int = 2;
        localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = localahip.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
        localahin.jdField_b_of_type_Int = localahip.jdField_a_of_type_Int;
        localahin.jdField_c_of_type_Int = localahip.jdField_c_of_type_Int;
        localahin.jdField_b_of_type_JavaLangString = ((String)localObject);
        localArrayList.add(localahin);
        i = 2;
        nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F75", "0X8006F75", 0, 0, this.jdField_a_of_type_JavaLangString, localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
      }
      for (;;)
      {
        int m;
        int k;
        if (localahip.jdField_a_of_type_Int == 80000004)
        {
          m = localahip.jdField_c_of_type_JavaUtilList.size();
          k = 0;
          label314:
          if (k < i)
          {
            localObject = new ahin();
            ((ahin)localObject).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem = ((AccountSearchPb.ResultItem)localahip.jdField_c_of_type_JavaUtilList.get(k));
            ((ahin)localObject).jdField_a_of_type_Int = 2;
            ((ahin)localObject).jdField_b_of_type_Int = localahip.jdField_a_of_type_Int;
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
            localObject = new ahin();
            ((ahin)localObject).jdField_a_of_type_Int = 1;
            ((ahin)localObject).jdField_b_of_type_Int = localahip.jdField_a_of_type_Int;
            ((ahin)localObject).jdField_c_of_type_Int = localahip.jdField_c_of_type_Int;
            if (localahip.jdField_a_of_type_Int == 80000004) {
              ((ahin)localObject).jdField_c_of_type_JavaLangString = localahip.jdField_a_of_type_JavaLangString;
            }
            localArrayList.add(localObject);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SearchContactsFragment", 2, "search reuslt : type = " + localahip.jdField_a_of_type_Int + "count = " + localahip.jdField_b_of_type_JavaUtilList.size());
          }
          localObject = "";
          switch (localahip.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            azqs.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, String.valueOf(Math.min(i, 3)), "", "", "");
            break;
            ((ahin)localObject).jdField_a_of_type_JavaLangString = a().getString(ViewFactory.a(localahip.jdField_a_of_type_Int));
            break label127;
            k += 1;
            break label314;
            k = localahip.jdField_b_of_type_JavaUtilList.size();
            m = 0;
            for (;;)
            {
              if (m >= i) {
                break label805;
              }
              localahin = new ahin();
              localahin.jdField_a_of_type_Int = 2;
              localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)localahip.jdField_b_of_type_JavaUtilList.get(m));
              localahin.jdField_b_of_type_Int = localahip.jdField_a_of_type_Int;
              localahin.jdField_c_of_type_Int = localahip.jdField_c_of_type_Int;
              localahin.jdField_b_of_type_JavaLangString = ((String)localObject);
              localArrayList.add(localahin);
              if (m >= k - 1)
              {
                i = k;
                break;
              }
              if (localahip.jdField_a_of_type_Int == 80000001) {
                azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "exp", 0, 0, "", "", "", "");
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
    if (QLog.isColorLevel()) {
      QLog.i("SearchContactsFragment", 2, "show group search recommend view");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView = new GroupSearchRecommendView(a(), this.jdField_a_of_type_Ahkj, new ahij(this), new ahik(this));
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
      l();
      b(paramString);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
  }
  
  protected void g()
  {
    Object localObject = (alwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    if ((80000001 == this.jdField_a_of_type_Int) && (((alwd)localObject).jdField_d_of_type_Boolean)) {
      if (this.jdField_a_of_type_Ahex == null)
      {
        this.jdField_a_of_type_Ahex = new ahfb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, null);
        localObject = this.jdField_a_of_type_Ahex.a();
        TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localTextView.setGravity(17);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, aepi.a(105.0F, getResources())));
        localTextView.setTextColor(getResources().getColor(2131166981));
        localTextView.setTextSize(1, 17.0F);
        localTextView.setText(alud.a(2131714014));
        localTextView.setBackgroundResource(2130838593);
        ((ListView)localObject).addHeaderView(localTextView);
        localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localTextView.setTextColor(getResources().getColor(2131166981));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setGravity(16);
        localTextView.setPadding(aepi.a(15.0F, getResources()), 0, 0, 0);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, aepi.a(40.0F, getResources())));
        localTextView.setText(alud.a(2131714005));
        localTextView.setBackgroundResource(2130838593);
        ((ListView)localObject).addHeaderView(localTextView);
        a(this.jdField_a_of_type_Ahex.a());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_Ahex.b();
      break;
      super.g();
    }
  }
  
  public void k()
  {
    super.k();
    e();
  }
  
  void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView = ((ViewFactory.GuideView)ViewFactory.a().a(80000005, a(), true));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {}
    }
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) == this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.setListener(new ahil(this));
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null) {
      if ((localObject1 instanceof ahid))
      {
        localObject2 = (ahid)localObject1;
        a(((ahid)localObject2).jdField_b_of_type_Int, ((ahid)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(((ahid)localObject2).jdField_b_of_type_Int), 0, "", "", "", "");
        localObject3 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(((ahid)localObject2).jdField_b_of_type_Int));
        localObject1 = null;
        paramView = (View)localObject1;
        if (localObject2 != null)
        {
          paramView = (View)localObject1;
          if (((ahid)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null)
          {
            paramView = (View)localObject1;
            if (((ahid)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin != null) {
              paramView = String.valueOf(((ahid)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get());
            }
          }
        }
        j = ((ahid)localObject2).jdField_b_of_type_Int;
        if (localObject3 != null)
        {
          i = ((Integer)localObject3).intValue();
          ayvm.a(j, i, ((ahid)localObject2).jdField_c_of_type_Int, true, paramView, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
          if (((ahid)localObject2).jdField_b_of_type_Int == 80000002)
          {
            localObject1 = ((ahid)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
            paramView = getActivity();
            if ((localObject1 != null) && (paramView != null) && ((paramView instanceof SearchBaseActivity)))
            {
              i = ((SearchBaseActivity)paramView).a();
              localObject3 = swe.a();
              if (((AccountSearchPb.record)localObject1).uin == null) {
                break label404;
              }
              paramView = ((AccountSearchPb.record)localObject1).uin.get() + "";
              ((swe)localObject3).a(2, paramView, ((ahid)localObject2).jdField_c_of_type_Int, jdField_b_of_type_Int);
              if (jdField_b_of_type_Int != 12) {
                break label416;
              }
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject2 = ((ahid)localObject2).jdField_c_of_type_Int + "";
              str = ahhx.a(i);
              if (((AccountSearchPb.record)localObject1).uin == null) {
                break label410;
              }
              paramView = ((AccountSearchPb.record)localObject1).uin.get() + "";
              azqs.b((QQAppInterface)localObject3, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, (String)localObject2, str, paramView, this.jdField_a_of_type_JavaLangString);
            }
          }
        }
      }
    }
    label404:
    label410:
    label416:
    label1125:
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
            nrt.a((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", paramView, "0X8005D20", "0X8005D20", 0, 0, ((ahid)localObject2).jdField_c_of_type_Int + "", ahhx.a(i), this.jdField_a_of_type_JavaLangString, "", false);
            return;
          }
          if ((localObject1 instanceof bbph))
          {
            paramView = (bbph)localObject1;
            localObject1 = TroopInfoActivity.a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_b_of_type_JavaLangString, 101);
            ((Bundle)localObject1).putInt("exposureSource", 3);
            ((Bundle)localObject1).putInt("t_s_f", 1000);
            bcpx.a(a(), (Bundle)localObject1, 2);
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(80000001), 0, "", "", "", "");
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_grpdate", 0, 0, paramView.jdField_a_of_type_JavaLangString, "", "", "");
            localObject1 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000001));
            if (localObject1 != null) {}
            for (i = ((Integer)localObject1).intValue();; i = 0)
            {
              ayvm.a(80000001, i, paramView.jdField_a_of_type_Int, true, paramView.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
              ayvm.a("add_page", "all_result", "clk_grp", 0, this.g, new String[] { paramView.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_JavaLangString, "" });
              return;
            }
          }
        } while (!(localObject1 instanceof ahic));
        paramView = getActivity();
      } while (paramView == null);
      localObject1 = (ahic)localObject1;
      Object localObject2 = new Intent(paramView, PublicAccountBrowser.class);
      ((Intent)localObject2).putExtra("url", ((ahic)localObject1).jdField_a_of_type_JavaLangString);
      if (jdField_b_of_type_Int == 13)
      {
        ((Intent)localObject2).putExtra("articalChannelId", 12);
        paramView.startActivity((Intent)localObject2);
        if (jdField_b_of_type_Int != 12) {
          break label1045;
        }
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "" + ((ahic)localObject1).jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + ((ahic)localObject1).jdField_a_of_type_Long);
        paramView = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000003));
        if (paramView == null) {
          break label1125;
        }
      }
      for (int i = paramView.intValue();; i = 0)
      {
        ayvm.a(80000003, i, ((ahic)localObject1).jdField_a_of_type_Int, true, null, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
        return;
        if (jdField_b_of_type_Int == 1)
        {
          ((Intent)localObject2).putExtra("articalChannelId", 10);
          if ((localObject1 == null) || (((ahic)localObject1).jdField_b_of_type_JavaLangString == null)) {
            break;
          }
          nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, ((ahic)localObject1).jdField_b_of_type_JavaLangString, ((ahic)localObject1).jdField_c_of_type_JavaLangString, "1");
          break;
        }
        if (jdField_b_of_type_Int != 2) {
          break;
        }
        ((Intent)localObject2).putExtra("articalChannelId", 11);
        break;
        nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "" + ((ahic)localObject1).jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + ((ahic)localObject1).jdField_a_of_type_Long, false);
        break label905;
      }
    }
    label905:
    label1045:
    ((QzoneSearchResultView)paramView).a(getActivity());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Ahio != null) {
      this.jdField_a_of_type_Ahio.c();
    }
    if (this.jdField_a_of_type_Ampt != null) {
      SosoInterface.b(this.jdField_a_of_type_Ampt);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Ahex != null) {
      this.jdField_a_of_type_Ahex.e();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_d_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView.b();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (this.jdField_d_of_type_Int == 1) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment
 * JD-Core Version:    0.7.0.1
 */