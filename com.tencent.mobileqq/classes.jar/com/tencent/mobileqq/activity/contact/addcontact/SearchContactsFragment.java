package com.tencent.mobileqq.activity.contact.addcontact;

import actn;
import afdf;
import afdj;
import affl;
import afgf;
import afgk;
import afgl;
import afgp;
import afgq;
import afgr;
import afgs;
import afgt;
import afgu;
import afgv;
import afgw;
import afgx;
import afim;
import afir;
import ajyc;
import akac;
import akup;
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
import awvt;
import awvy;
import axqw;
import azmn;
import bamn;
import baxk;
import bbbd;
import bbdr;
import bbev;
import bcpw;
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
import noo;
import sen;
import sfh;

public class SearchContactsFragment
  extends SearchBaseFragment
{
  private static int jdField_b_of_type_Int = -1;
  private double jdField_a_of_type_Double;
  public int a;
  private afdf jdField_a_of_type_Afdf;
  public afgu a;
  private afgw jdField_a_of_type_Afgw;
  afir jdField_a_of_type_Afir = new afgq(this);
  protected akup a;
  private ViewFactory.GuideView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView;
  private GroupSearchRecommendView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView;
  ArrayList<afgv> jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private double jdField_b_of_type_Double;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<afgx> jdField_b_of_type_JavaUtilArrayList;
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
    this.jdField_a_of_type_Akup = new afgp(this, 0, true, false, 60000L, false, false, "SearchContacts");
    SosoInterface.a(this.jdField_a_of_type_Akup);
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
  
  private afgx a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      afgx localafgx = (afgx)localIterator.next();
      if (localafgx.jdField_a_of_type_Int == paramInt) {
        return localafgx;
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
        afgv localafgv = (afgv)localIterator.next();
        if ((localafgv != null) && (localafgv.jdField_b_of_type_Int == 80000002)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(ArrayList<afgx> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = (afgx)paramArrayList.get(0);
      if (((afgx)localObject).jdField_b_of_type_Boolean)
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
      localObject = ((afgx)localObject).jdField_b_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        int i = ((afgx)paramArrayList.get(0)).jdField_a_of_type_Int;
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
          a(((afgx)paramArrayList.get(0)).jdField_a_of_type_Int, false);
          return true;
        }
      }
    }
    return false;
  }
  
  public String a(afgl paramafgl, afgv paramafgv)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramafgv.jdField_b_of_type_Int;
    paramafgl.jdField_a_of_type_JavaLangString = (paramafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "");
    boolean bool;
    SpannableStringBuilder localSpannableStringBuilder;
    label132:
    Object localObject;
    if (paramafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() != 0L)
    {
      bool = true;
      paramafgl.jdField_a_of_type_Boolean = bool;
      paramafgl.jdField_b_of_type_JavaLangString = paramafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.mobile.get();
      paramafgl.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      localSpannableStringBuilder = new SpannableStringBuilder();
      switch (i)
      {
      default: 
        paramafgl.jdField_b_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
        if ((i == 80000000) && (!TextUtils.isEmpty(paramafgl.jdField_a_of_type_JavaLangString)) && (bbbd.b(paramafgl.jdField_a_of_type_JavaLangString)))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130841313);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          int j = actn.a(15.0F, BaseApplication.getContext().getResources());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          ((Drawable)localObject).setBounds(0, 0, j, actn.a(15.0F, BaseApplication.getContext().getResources()));
          paramafgl.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
          label249:
          localStringBuilder.append(paramafgl.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
          localStringBuilder.append(paramafgl.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
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
      localObject = this.jdField_a_of_type_Baxk.a(i, paramafgl.jdField_a_of_type_JavaLangString);
      paramafgv = (afgv)localObject;
      if (localObject == null)
      {
        localObject = bbdr.a();
        paramafgv = (afgv)localObject;
        if (!this.jdField_a_of_type_Baxk.a())
        {
          this.jdField_a_of_type_Baxk.a(paramafgl.jdField_a_of_type_JavaLangString, i, true, (byte)1);
          paramafgv = (afgv)localObject;
        }
      }
      paramafgl.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramafgv);
      return localStringBuilder.toString();
      bool = false;
      break;
      paramafgl.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000000, paramafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get()));
      localSpannableStringBuilder.append("(");
      if (paramafgl.jdField_a_of_type_Boolean) {}
      for (localObject = paramafgl.jdField_a_of_type_JavaLangString;; localObject = paramafgl.jdField_b_of_type_JavaLangString)
      {
        localSpannableStringBuilder.append(a(80000000, (String)localObject));
        localSpannableStringBuilder.append(")");
        break;
      }
      paramafgl.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000002, String.valueOf(paramafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      break label132;
      paramafgl.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000001, String.valueOf(paramafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      localSpannableStringBuilder.append("(");
      localSpannableStringBuilder.append(a(80000001, String.valueOf(paramafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get())));
      localSpannableStringBuilder.append(")");
      break label132;
      paramafgl.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label249;
      localStringBuilder.append(a(paramafgl, paramafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
      continue;
      i = 4;
      paramafgl.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramafgl.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramafgl.jdField_c_of_type_AndroidWidgetTextView.setText(paramafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get() + ajyc.a(2131713612));
      paramafgl.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131166928));
      paramafgl.d.setText(paramafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get());
      paramafgl.jdField_a_of_type_JavaLangString = String.valueOf(paramafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
      localStringBuilder.append(paramafgl.jdField_c_of_type_AndroidWidgetTextView.getText()).append(paramafgl.d.getText());
      continue;
      localStringBuilder.append(b(paramafgl, paramafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
    }
  }
  
  ArrayList<afgx> a(ArrayList<afgx> paramArrayList)
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
        afgx localafgx = (afgx)localIterator.next();
        if (localafgx.jdField_a_of_type_Int == k) {
          localArrayList.add(localafgx);
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
        if (this.jdField_a_of_type_Afgw == null)
        {
          this.jdField_a_of_type_Afgw = new afgw(this, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 4, true);
          this.jdField_a_of_type_Afgw.a(this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afgw);
          this.a = this.jdField_a_of_type_Afgw;
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
        }
        this.jdField_a_of_type_Afgw.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Afgw.notifyDataSetChanged();
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
        }
      } while (!a());
      localObject1 = getActivity();
      if ((localObject1 != null) && ((localObject1 instanceof SearchContactsActivity)))
      {
        localObject1 = afgf.a(((SearchContactsActivity)localObject1).a());
        noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1F", "0X8005D1F", 0, 0, "", (String)localObject1, this.jdField_a_of_type_JavaLangString, "", false);
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList == null);
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      afgv localafgv = (afgv)((Iterator)localObject2).next();
      if ((localafgv != null) && (localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) && (localafgv.jdField_b_of_type_Int == 80000002))
      {
        ((StringBuilder)localObject1).append(String.valueOf(localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get())).append("#");
        i += 1;
      }
    }
    localObject2 = sen.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    sen.a().a((String)localObject2, this.jdField_a_of_type_JavaLangString, 2, false, i, ((StringBuilder)localObject1).toString());
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
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF1", "0X8004BF1", paramInt, 0, "", "", "", "");
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
      localObject1 = (String)localObject1 + "&_wv=16777216&_cwv=8";
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
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_more", 0, 0, "", "", "", "");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_JavaLangString.matches("^\\d{5,11}$")) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        axqw.b((QQAppInterface)localObject2, "dc00899", "Grp_find", "", "inte_add", "inte_find_grp", 0, 0, (String)localObject1, this.jdField_a_of_type_JavaLangString, "", "");
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
      noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "0", afgf.a(paramInt), this.jdField_a_of_type_JavaLangString, "", false);
      paramInt = 3;
      continue;
      ((Intent)localObject1).putExtra("from_key", 5);
      ((Intent)localObject1).putExtra("fromType", jdField_b_of_type_Int);
      ((Intent)localObject1).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject1, a(paramInt));
      noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, "0", "", this.jdField_a_of_type_JavaLangString, "", false);
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
      noo.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, paramString2, paramString3, "2");
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsFragment", 2, "doSearch");
    }
    if (bbev.d(BaseApplicationImpl.getContext()))
    {
      h();
      this.jdField_a_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_Affl == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "doSearch:should not be here | searchFacade = null");
        }
        i();
        return;
      }
      this.jdField_a_of_type_Affl.c();
      if (this.jdField_d_of_type_Int == 1)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Int = 80000001;
        if (this.jdField_d_of_type_Boolean) {
          afim.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
        }
      }
      else
      {
        if (jdField_b_of_type_Int != 12) {
          break label223;
        }
        localaffl = this.jdField_a_of_type_Affl;
        if (!this.jdField_a_of_type_Boolean) {
          break label216;
        }
      }
      label216:
      for (int i = this.jdField_a_of_type_Int;; i = 80000006)
      {
        localaffl.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 1);
        this.jdField_c_of_type_Boolean = true;
        if (!this.jdField_a_of_type_Boolean) {
          break label268;
        }
        paramString = a(this.jdField_a_of_type_Int);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramString, paramString, this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
        return;
        this.jdField_d_of_type_Boolean = true;
        break;
      }
      label223:
      affl localaffl = this.jdField_a_of_type_Affl;
      if (this.jdField_a_of_type_Boolean) {}
      for (i = this.jdField_a_of_type_Int;; i = 80000005)
      {
        localaffl.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 0);
        break;
      }
      label268:
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BED", "0X8004BED", this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
      return;
    }
    bcpw.a(BaseApplicationImpl.getContext(), 2131694609, 0).b(b());
  }
  
  protected boolean a(ArrayList<afgx> paramArrayList)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
      this.g = awvt.a(paramArrayList, this.e);
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
      a(((afgx)paramArrayList.get(0)).jdField_a_of_type_Int, false);
    }
    return false;
  }
  
  ArrayList<afgv> b(ArrayList<afgx> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(12);
    int n = paramArrayList.size();
    int j = 0;
    afgx localafgx;
    for (;;)
    {
      if (j < n)
      {
        localafgx = (afgx)paramArrayList.get(j);
        if ((localafgx == null) || ((localafgx.jdField_b_of_type_JavaUtilList.size() <= 0) && (localafgx.jdField_c_of_type_JavaUtilList.size() <= 0)))
        {
          j += 1;
        }
        else
        {
          localObject = new afgv();
          ((afgv)localObject).jdField_a_of_type_Int = 0;
          ((afgv)localObject).jdField_b_of_type_Int = localafgx.jdField_a_of_type_Int;
          if (ViewFactory.a(localafgx.jdField_a_of_type_Int) == 2131689766)
          {
            ((afgv)localObject).jdField_a_of_type_JavaLangString = sfh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
            label127:
            localArrayList.add(localObject);
            if (TextUtils.isEmpty(localafgx.jdField_a_of_type_JavaLangString)) {
              break label816;
            }
          }
        }
      }
    }
    label805:
    label816:
    for (Object localObject = localafgx.jdField_a_of_type_JavaLangString;; localObject = null)
    {
      afgv localafgv;
      int i;
      if ((localafgx.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) && (localafgx.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.has()))
      {
        localafgv = new afgv();
        localafgv.jdField_a_of_type_Int = 2;
        localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = localafgx.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
        localafgv.jdField_b_of_type_Int = localafgx.jdField_a_of_type_Int;
        localafgv.jdField_c_of_type_Int = localafgx.jdField_c_of_type_Int;
        localafgv.jdField_b_of_type_JavaLangString = ((String)localObject);
        localArrayList.add(localafgv);
        i = 2;
        noo.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F75", "0X8006F75", 0, 0, this.jdField_a_of_type_JavaLangString, localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
      }
      for (;;)
      {
        int m;
        int k;
        if (localafgx.jdField_a_of_type_Int == 80000004)
        {
          m = localafgx.jdField_c_of_type_JavaUtilList.size();
          k = 0;
          label314:
          if (k < i)
          {
            localObject = new afgv();
            ((afgv)localObject).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem = ((AccountSearchPb.ResultItem)localafgx.jdField_c_of_type_JavaUtilList.get(k));
            ((afgv)localObject).jdField_a_of_type_Int = 2;
            ((afgv)localObject).jdField_b_of_type_Int = localafgx.jdField_a_of_type_Int;
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
            localObject = new afgv();
            ((afgv)localObject).jdField_a_of_type_Int = 1;
            ((afgv)localObject).jdField_b_of_type_Int = localafgx.jdField_a_of_type_Int;
            ((afgv)localObject).jdField_c_of_type_Int = localafgx.jdField_c_of_type_Int;
            if (localafgx.jdField_a_of_type_Int == 80000004) {
              ((afgv)localObject).jdField_c_of_type_JavaLangString = localafgx.jdField_a_of_type_JavaLangString;
            }
            localArrayList.add(localObject);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SearchContactsFragment", 2, "search reuslt : type = " + localafgx.jdField_a_of_type_Int + "count = " + localafgx.jdField_b_of_type_JavaUtilList.size());
          }
          localObject = "";
          switch (localafgx.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            axqw.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, String.valueOf(Math.min(i, 3)), "", "", "");
            break;
            ((afgv)localObject).jdField_a_of_type_JavaLangString = a().getString(ViewFactory.a(localafgx.jdField_a_of_type_Int));
            break label127;
            k += 1;
            break label314;
            k = localafgx.jdField_b_of_type_JavaUtilList.size();
            m = 0;
            for (;;)
            {
              if (m >= i) {
                break label805;
              }
              localafgv = new afgv();
              localafgv.jdField_a_of_type_Int = 2;
              localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)localafgx.jdField_b_of_type_JavaUtilList.get(m));
              localafgv.jdField_b_of_type_Int = localafgx.jdField_a_of_type_Int;
              localafgv.jdField_c_of_type_Int = localafgx.jdField_c_of_type_Int;
              localafgv.jdField_b_of_type_JavaLangString = ((String)localObject);
              localArrayList.add(localafgv);
              if (m >= k - 1)
              {
                i = k;
                break;
              }
              if (localafgx.jdField_a_of_type_Int == 80000001) {
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "exp", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView = new GroupSearchRecommendView(a(), this.jdField_a_of_type_Afir, new afgr(this), new afgs(this));
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
    Object localObject = (akac)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    if ((80000001 == this.jdField_a_of_type_Int) && (((akac)localObject).jdField_d_of_type_Boolean)) {
      if (this.jdField_a_of_type_Afdf == null)
      {
        this.jdField_a_of_type_Afdf = new afdj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, null);
        localObject = this.jdField_a_of_type_Afdf.a();
        TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localTextView.setGravity(17);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, actn.a(105.0F, getResources())));
        localTextView.setTextColor(getResources().getColor(2131166931));
        localTextView.setTextSize(1, 17.0F);
        localTextView.setText(ajyc.a(2131713619));
        localTextView.setBackgroundResource(2130838515);
        ((ListView)localObject).addHeaderView(localTextView);
        localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localTextView.setTextColor(getResources().getColor(2131166931));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setGravity(16);
        localTextView.setPadding(actn.a(15.0F, getResources()), 0, 0, 0);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, actn.a(40.0F, getResources())));
        localTextView.setText(ajyc.a(2131713610));
        localTextView.setBackgroundResource(2130838515);
        ((ListView)localObject).addHeaderView(localTextView);
        a(this.jdField_a_of_type_Afdf.a());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_Afdf.b();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.setListener(new afgt(this));
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null) {
      if ((localObject1 instanceof afgl))
      {
        localObject2 = (afgl)localObject1;
        a(((afgl)localObject2).jdField_b_of_type_Int, ((afgl)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(((afgl)localObject2).jdField_b_of_type_Int), 0, "", "", "", "");
        localObject3 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(((afgl)localObject2).jdField_b_of_type_Int));
        localObject1 = null;
        paramView = (View)localObject1;
        if (localObject2 != null)
        {
          paramView = (View)localObject1;
          if (((afgl)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null)
          {
            paramView = (View)localObject1;
            if (((afgl)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin != null) {
              paramView = String.valueOf(((afgl)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get());
            }
          }
        }
        j = ((afgl)localObject2).jdField_b_of_type_Int;
        if (localObject3 != null)
        {
          i = ((Integer)localObject3).intValue();
          awvy.a(j, i, ((afgl)localObject2).jdField_c_of_type_Int, true, paramView, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
          if (((afgl)localObject2).jdField_b_of_type_Int == 80000002)
          {
            localObject1 = ((afgl)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
            paramView = getActivity();
            if ((localObject1 != null) && (paramView != null) && ((paramView instanceof SearchBaseActivity)))
            {
              i = ((SearchBaseActivity)paramView).a();
              localObject3 = sen.a();
              if (((AccountSearchPb.record)localObject1).uin == null) {
                break label404;
              }
              paramView = ((AccountSearchPb.record)localObject1).uin.get() + "";
              ((sen)localObject3).a(2, paramView, ((afgl)localObject2).jdField_c_of_type_Int, jdField_b_of_type_Int);
              if (jdField_b_of_type_Int != 12) {
                break label416;
              }
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject2 = ((afgl)localObject2).jdField_c_of_type_Int + "";
              str = afgf.a(i);
              if (((AccountSearchPb.record)localObject1).uin == null) {
                break label410;
              }
              paramView = ((AccountSearchPb.record)localObject1).uin.get() + "";
              axqw.b((QQAppInterface)localObject3, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, (String)localObject2, str, paramView, this.jdField_a_of_type_JavaLangString);
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
            noo.a((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", paramView, "0X8005D20", "0X8005D20", 0, 0, ((afgl)localObject2).jdField_c_of_type_Int + "", afgf.a(i), this.jdField_a_of_type_JavaLangString, "", false);
            return;
          }
          if ((localObject1 instanceof azmn))
          {
            paramView = (azmn)localObject1;
            localObject1 = TroopInfoActivity.a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_b_of_type_JavaLangString, 101);
            ((Bundle)localObject1).putInt("exposureSource", 3);
            ((Bundle)localObject1).putInt("t_s_f", 1000);
            bamn.a(a(), (Bundle)localObject1, 2);
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(80000001), 0, "", "", "", "");
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_grpdate", 0, 0, paramView.jdField_a_of_type_JavaLangString, "", "", "");
            localObject1 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000001));
            if (localObject1 != null) {}
            for (i = ((Integer)localObject1).intValue();; i = 0)
            {
              awvy.a(80000001, i, paramView.jdField_a_of_type_Int, true, paramView.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
              awvy.a("add_page", "all_result", "clk_grp", 0, this.g, new String[] { paramView.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_JavaLangString, "" });
              return;
            }
          }
        } while (!(localObject1 instanceof afgk));
        paramView = getActivity();
      } while (paramView == null);
      localObject1 = (afgk)localObject1;
      Object localObject2 = new Intent(paramView, PublicAccountBrowser.class);
      ((Intent)localObject2).putExtra("url", ((afgk)localObject1).jdField_a_of_type_JavaLangString);
      if (jdField_b_of_type_Int == 13)
      {
        ((Intent)localObject2).putExtra("articalChannelId", 12);
        paramView.startActivity((Intent)localObject2);
        if (jdField_b_of_type_Int != 12) {
          break label1045;
        }
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "" + ((afgk)localObject1).jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + ((afgk)localObject1).jdField_a_of_type_Long);
        paramView = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000003));
        if (paramView == null) {
          break label1125;
        }
      }
      for (int i = paramView.intValue();; i = 0)
      {
        awvy.a(80000003, i, ((afgk)localObject1).jdField_a_of_type_Int, true, null, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
        return;
        if (jdField_b_of_type_Int == 1)
        {
          ((Intent)localObject2).putExtra("articalChannelId", 10);
          if ((localObject1 == null) || (((afgk)localObject1).jdField_b_of_type_JavaLangString == null)) {
            break;
          }
          noo.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, ((afgk)localObject1).jdField_b_of_type_JavaLangString, ((afgk)localObject1).jdField_c_of_type_JavaLangString, "1");
          break;
        }
        if (jdField_b_of_type_Int != 2) {
          break;
        }
        ((Intent)localObject2).putExtra("articalChannelId", 11);
        break;
        noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "" + ((afgk)localObject1).jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + ((afgk)localObject1).jdField_a_of_type_Long, false);
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
    if (this.jdField_a_of_type_Afgw != null) {
      this.jdField_a_of_type_Afgw.c();
    }
    if (this.jdField_a_of_type_Akup != null) {
      SosoInterface.b(this.jdField_a_of_type_Akup);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Afdf != null) {
      this.jdField_a_of_type_Afdf.e();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment
 * JD-Core Version:    0.7.0.1
 */