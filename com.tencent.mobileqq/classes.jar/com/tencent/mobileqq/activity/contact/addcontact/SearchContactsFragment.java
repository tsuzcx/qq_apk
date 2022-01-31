package com.tencent.mobileqq.activity.contact.addcontact;

import aciy;
import aesj;
import aesn;
import aeup;
import aevj;
import aevo;
import aevp;
import aevt;
import aevu;
import aevv;
import aevw;
import aevx;
import aevy;
import aevz;
import aewa;
import aewb;
import aeww;
import aexb;
import ajjy;
import ajls;
import akgd;
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
import avwa;
import avwf;
import awqx;
import aylx;
import azlj;
import azwg;
import azzz;
import bacm;
import badq;
import bbmy;
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
import ndn;
import rrv;
import rsp;

public class SearchContactsFragment
  extends SearchBaseFragment
{
  private static int jdField_b_of_type_Int = -1;
  private double jdField_a_of_type_Double;
  public int a;
  private aesj jdField_a_of_type_Aesj;
  public aevy a;
  private aewa jdField_a_of_type_Aewa;
  aexb jdField_a_of_type_Aexb = new aevu(this);
  protected akgd a;
  private ViewFactory.GuideView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView;
  private GroupSearchRecommendView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView;
  ArrayList<aevz> jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private double jdField_b_of_type_Double;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<aewb> jdField_b_of_type_JavaUtilArrayList;
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
    this.jdField_a_of_type_Akgd = new aevt(this, 0, true, false, 60000L, false, false, "SearchContacts");
    SosoInterface.a(this.jdField_a_of_type_Akgd);
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
  
  private aewb a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aewb localaewb = (aewb)localIterator.next();
      if (localaewb.jdField_a_of_type_Int == paramInt) {
        return localaewb;
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
        aevz localaevz = (aevz)localIterator.next();
        if ((localaevz != null) && (localaevz.jdField_b_of_type_Int == 80000002)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(ArrayList<aewb> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = (aewb)paramArrayList.get(0);
      if (((aewb)localObject).jdField_b_of_type_Boolean)
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
      localObject = ((aewb)localObject).jdField_b_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        int i = ((aewb)paramArrayList.get(0)).jdField_a_of_type_Int;
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
          a(((aewb)paramArrayList.get(0)).jdField_a_of_type_Int, false);
          return true;
        }
      }
    }
    return false;
  }
  
  public String a(aevp paramaevp, aevz paramaevz)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramaevz.jdField_b_of_type_Int;
    paramaevp.jdField_a_of_type_JavaLangString = (paramaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "");
    boolean bool;
    SpannableStringBuilder localSpannableStringBuilder;
    label132:
    Object localObject;
    if (paramaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() != 0L)
    {
      bool = true;
      paramaevp.jdField_a_of_type_Boolean = bool;
      paramaevp.jdField_b_of_type_JavaLangString = paramaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.mobile.get();
      paramaevp.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      localSpannableStringBuilder = new SpannableStringBuilder();
      switch (i)
      {
      default: 
        paramaevp.jdField_b_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
        if ((i == 80000000) && (!TextUtils.isEmpty(paramaevp.jdField_a_of_type_JavaLangString)) && (azzz.b(paramaevp.jdField_a_of_type_JavaLangString)))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130841234);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          int j = aciy.a(15.0F, BaseApplication.getContext().getResources());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          ((Drawable)localObject).setBounds(0, 0, j, aciy.a(15.0F, BaseApplication.getContext().getResources()));
          paramaevp.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
          label249:
          localStringBuilder.append(paramaevp.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
          localStringBuilder.append(paramaevp.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
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
      localObject = this.jdField_a_of_type_Azwg.a(i, paramaevp.jdField_a_of_type_JavaLangString);
      paramaevz = (aevz)localObject;
      if (localObject == null)
      {
        localObject = bacm.a();
        paramaevz = (aevz)localObject;
        if (!this.jdField_a_of_type_Azwg.a())
        {
          this.jdField_a_of_type_Azwg.a(paramaevp.jdField_a_of_type_JavaLangString, i, true, (byte)1);
          paramaevz = (aevz)localObject;
        }
      }
      paramaevp.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramaevz);
      return localStringBuilder.toString();
      bool = false;
      break;
      paramaevp.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000000, paramaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get()));
      localSpannableStringBuilder.append("(");
      if (paramaevp.jdField_a_of_type_Boolean) {}
      for (localObject = paramaevp.jdField_a_of_type_JavaLangString;; localObject = paramaevp.jdField_b_of_type_JavaLangString)
      {
        localSpannableStringBuilder.append(a(80000000, (String)localObject));
        localSpannableStringBuilder.append(")");
        break;
      }
      paramaevp.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000002, String.valueOf(paramaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      break label132;
      paramaevp.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000001, String.valueOf(paramaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      localSpannableStringBuilder.append("(");
      localSpannableStringBuilder.append(a(80000001, String.valueOf(paramaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get())));
      localSpannableStringBuilder.append(")");
      break label132;
      paramaevp.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label249;
      localStringBuilder.append(a(paramaevp, paramaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
      continue;
      i = 4;
      paramaevp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramaevp.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramaevp.jdField_c_of_type_AndroidWidgetTextView.setText(paramaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get() + ajjy.a(2131647825));
      paramaevp.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131101333));
      paramaevp.d.setText(paramaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get());
      paramaevp.jdField_a_of_type_JavaLangString = String.valueOf(paramaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
      localStringBuilder.append(paramaevp.jdField_c_of_type_AndroidWidgetTextView.getText()).append(paramaevp.d.getText());
      continue;
      localStringBuilder.append(b(paramaevp, paramaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
    }
  }
  
  ArrayList<aewb> a(ArrayList<aewb> paramArrayList)
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
        aewb localaewb = (aewb)localIterator.next();
        if (localaewb.jdField_a_of_type_Int == k) {
          localArrayList.add(localaewb);
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
        if (this.jdField_a_of_type_Aewa == null)
        {
          this.jdField_a_of_type_Aewa = new aewa(this, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 4, true);
          this.jdField_a_of_type_Aewa.a(this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aewa);
          this.a = this.jdField_a_of_type_Aewa;
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
        }
        this.jdField_a_of_type_Aewa.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Aewa.notifyDataSetChanged();
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
        }
      } while (!a());
      localObject1 = getActivity();
      if ((localObject1 != null) && ((localObject1 instanceof SearchContactsActivity)))
      {
        localObject1 = aevj.a(((SearchContactsActivity)localObject1).a());
        ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1F", "0X8005D1F", 0, 0, "", (String)localObject1, this.jdField_a_of_type_JavaLangString, "", false);
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList == null);
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      aevz localaevz = (aevz)((Iterator)localObject2).next();
      if ((localaevz != null) && (localaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) && (localaevz.jdField_b_of_type_Int == 80000002))
      {
        ((StringBuilder)localObject1).append(String.valueOf(localaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get())).append("#");
        i += 1;
      }
    }
    localObject2 = rrv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    rrv.a().a((String)localObject2, this.jdField_a_of_type_JavaLangString, 2, false, i, ((StringBuilder)localObject1).toString());
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF1", "0X8004BF1", paramInt, 0, "", "", "", "");
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_more", 0, 0, "", "", "", "");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_JavaLangString.matches("^\\d{5,11}$")) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        awqx.b((QQAppInterface)localObject2, "dc00899", "Grp_find", "", "inte_add", "inte_find_grp", 0, 0, (String)localObject1, this.jdField_a_of_type_JavaLangString, "", "");
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
      ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "0", aevj.a(paramInt), this.jdField_a_of_type_JavaLangString, "", false);
      paramInt = 3;
      continue;
      ((Intent)localObject1).putExtra("from_key", 5);
      ((Intent)localObject1).putExtra("fromType", jdField_b_of_type_Int);
      ((Intent)localObject1).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject1, a(paramInt));
      ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, "0", "", this.jdField_a_of_type_JavaLangString, "", false);
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
      ndn.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, paramString2, paramString3, "2");
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsFragment", 2, "doSearch");
    }
    if (badq.d(BaseApplicationImpl.getContext()))
    {
      h();
      this.jdField_a_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_Aeup == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "doSearch:should not be here | searchFacade = null");
        }
        i();
        return;
      }
      this.jdField_a_of_type_Aeup.c();
      if (this.jdField_d_of_type_Int == 1)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Int = 80000001;
        if (this.jdField_d_of_type_Boolean) {
          aeww.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
        }
      }
      else
      {
        if (jdField_b_of_type_Int != 12) {
          break label223;
        }
        localaeup = this.jdField_a_of_type_Aeup;
        if (!this.jdField_a_of_type_Boolean) {
          break label216;
        }
      }
      label216:
      for (int i = this.jdField_a_of_type_Int;; i = 80000006)
      {
        localaeup.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 1);
        this.jdField_c_of_type_Boolean = true;
        if (!this.jdField_a_of_type_Boolean) {
          break label268;
        }
        paramString = a(this.jdField_a_of_type_Int);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramString, paramString, this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
        return;
        this.jdField_d_of_type_Boolean = true;
        break;
      }
      label223:
      aeup localaeup = this.jdField_a_of_type_Aeup;
      if (this.jdField_a_of_type_Boolean) {}
      for (i = this.jdField_a_of_type_Int;; i = 80000005)
      {
        localaeup.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 0);
        break;
      }
      label268:
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BED", "0X8004BED", this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
      return;
    }
    bbmy.a(BaseApplicationImpl.getContext(), 2131628948, 0).b(b());
  }
  
  protected boolean a(ArrayList<aewb> paramArrayList)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
      this.g = avwa.a(paramArrayList, this.e);
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
      a(((aewb)paramArrayList.get(0)).jdField_a_of_type_Int, false);
    }
    return false;
  }
  
  ArrayList<aevz> b(ArrayList<aewb> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(12);
    int n = paramArrayList.size();
    int j = 0;
    aewb localaewb;
    for (;;)
    {
      if (j < n)
      {
        localaewb = (aewb)paramArrayList.get(j);
        if ((localaewb == null) || ((localaewb.jdField_b_of_type_JavaUtilList.size() <= 0) && (localaewb.jdField_c_of_type_JavaUtilList.size() <= 0)))
        {
          j += 1;
        }
        else
        {
          localObject = new aevz();
          ((aevz)localObject).jdField_a_of_type_Int = 0;
          ((aevz)localObject).jdField_b_of_type_Int = localaewb.jdField_a_of_type_Int;
          if (ViewFactory.a(localaewb.jdField_a_of_type_Int) == 2131624226)
          {
            ((aevz)localObject).jdField_a_of_type_JavaLangString = rsp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
            label127:
            localArrayList.add(localObject);
            if (TextUtils.isEmpty(localaewb.jdField_a_of_type_JavaLangString)) {
              break label816;
            }
          }
        }
      }
    }
    label805:
    label816:
    for (Object localObject = localaewb.jdField_a_of_type_JavaLangString;; localObject = null)
    {
      aevz localaevz;
      int i;
      if ((localaewb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) && (localaewb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.has()))
      {
        localaevz = new aevz();
        localaevz.jdField_a_of_type_Int = 2;
        localaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = localaewb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
        localaevz.jdField_b_of_type_Int = localaewb.jdField_a_of_type_Int;
        localaevz.jdField_c_of_type_Int = localaewb.jdField_c_of_type_Int;
        localaevz.jdField_b_of_type_JavaLangString = ((String)localObject);
        localArrayList.add(localaevz);
        i = 2;
        ndn.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F75", "0X8006F75", 0, 0, this.jdField_a_of_type_JavaLangString, localaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
      }
      for (;;)
      {
        int m;
        int k;
        if (localaewb.jdField_a_of_type_Int == 80000004)
        {
          m = localaewb.jdField_c_of_type_JavaUtilList.size();
          k = 0;
          label314:
          if (k < i)
          {
            localObject = new aevz();
            ((aevz)localObject).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem = ((AccountSearchPb.ResultItem)localaewb.jdField_c_of_type_JavaUtilList.get(k));
            ((aevz)localObject).jdField_a_of_type_Int = 2;
            ((aevz)localObject).jdField_b_of_type_Int = localaewb.jdField_a_of_type_Int;
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
            localObject = new aevz();
            ((aevz)localObject).jdField_a_of_type_Int = 1;
            ((aevz)localObject).jdField_b_of_type_Int = localaewb.jdField_a_of_type_Int;
            ((aevz)localObject).jdField_c_of_type_Int = localaewb.jdField_c_of_type_Int;
            if (localaewb.jdField_a_of_type_Int == 80000004) {
              ((aevz)localObject).jdField_c_of_type_JavaLangString = localaewb.jdField_a_of_type_JavaLangString;
            }
            localArrayList.add(localObject);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SearchContactsFragment", 2, "search reuslt : type = " + localaewb.jdField_a_of_type_Int + "count = " + localaewb.jdField_b_of_type_JavaUtilList.size());
          }
          localObject = "";
          switch (localaewb.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            awqx.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, String.valueOf(Math.min(i, 3)), "", "", "");
            break;
            ((aevz)localObject).jdField_a_of_type_JavaLangString = a().getString(ViewFactory.a(localaewb.jdField_a_of_type_Int));
            break label127;
            k += 1;
            break label314;
            k = localaewb.jdField_b_of_type_JavaUtilList.size();
            m = 0;
            for (;;)
            {
              if (m >= i) {
                break label805;
              }
              localaevz = new aevz();
              localaevz.jdField_a_of_type_Int = 2;
              localaevz.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)localaewb.jdField_b_of_type_JavaUtilList.get(m));
              localaevz.jdField_b_of_type_Int = localaewb.jdField_a_of_type_Int;
              localaevz.jdField_c_of_type_Int = localaewb.jdField_c_of_type_Int;
              localaevz.jdField_b_of_type_JavaLangString = ((String)localObject);
              localArrayList.add(localaevz);
              if (m >= k - 1)
              {
                i = k;
                break;
              }
              if (localaewb.jdField_a_of_type_Int == 80000001) {
                awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "exp", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView = new GroupSearchRecommendView(a(), this.jdField_a_of_type_Aexb, new aevv(this), new aevw(this));
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
    Object localObject = (ajls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    if ((80000001 == this.jdField_a_of_type_Int) && (((ajls)localObject).jdField_d_of_type_Boolean)) {
      if (this.jdField_a_of_type_Aesj == null)
      {
        this.jdField_a_of_type_Aesj = new aesn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, null);
        localObject = this.jdField_a_of_type_Aesj.a();
        TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localTextView.setGravity(17);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, aciy.a(105.0F, getResources())));
        localTextView.setTextColor(getResources().getColor(2131101336));
        localTextView.setTextSize(1, 17.0F);
        localTextView.setText(ajjy.a(2131647832));
        localTextView.setBackgroundResource(2130838504);
        ((ListView)localObject).addHeaderView(localTextView);
        localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localTextView.setTextColor(getResources().getColor(2131101336));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setGravity(16);
        localTextView.setPadding(aciy.a(15.0F, getResources()), 0, 0, 0);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, aciy.a(40.0F, getResources())));
        localTextView.setText(ajjy.a(2131647823));
        localTextView.setBackgroundResource(2130838504);
        ((ListView)localObject).addHeaderView(localTextView);
        a(this.jdField_a_of_type_Aesj.a());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_Aesj.b();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.setListener(new aevx(this));
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null) {
      if ((localObject1 instanceof aevp))
      {
        localObject2 = (aevp)localObject1;
        a(((aevp)localObject2).jdField_b_of_type_Int, ((aevp)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(((aevp)localObject2).jdField_b_of_type_Int), 0, "", "", "", "");
        localObject3 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(((aevp)localObject2).jdField_b_of_type_Int));
        localObject1 = null;
        paramView = (View)localObject1;
        if (localObject2 != null)
        {
          paramView = (View)localObject1;
          if (((aevp)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null)
          {
            paramView = (View)localObject1;
            if (((aevp)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin != null) {
              paramView = String.valueOf(((aevp)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get());
            }
          }
        }
        j = ((aevp)localObject2).jdField_b_of_type_Int;
        if (localObject3 != null)
        {
          i = ((Integer)localObject3).intValue();
          avwf.a(j, i, ((aevp)localObject2).jdField_c_of_type_Int, true, paramView, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
          if (((aevp)localObject2).jdField_b_of_type_Int == 80000002)
          {
            localObject1 = ((aevp)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
            paramView = getActivity();
            if ((localObject1 != null) && (paramView != null) && ((paramView instanceof SearchBaseActivity)))
            {
              i = ((SearchBaseActivity)paramView).a();
              localObject3 = rrv.a();
              if (((AccountSearchPb.record)localObject1).uin == null) {
                break label404;
              }
              paramView = ((AccountSearchPb.record)localObject1).uin.get() + "";
              ((rrv)localObject3).a(2, paramView, ((aevp)localObject2).jdField_c_of_type_Int, jdField_b_of_type_Int);
              if (jdField_b_of_type_Int != 12) {
                break label416;
              }
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject2 = ((aevp)localObject2).jdField_c_of_type_Int + "";
              str = aevj.a(i);
              if (((AccountSearchPb.record)localObject1).uin == null) {
                break label410;
              }
              paramView = ((AccountSearchPb.record)localObject1).uin.get() + "";
              awqx.b((QQAppInterface)localObject3, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, (String)localObject2, str, paramView, this.jdField_a_of_type_JavaLangString);
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
            ndn.a((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", paramView, "0X8005D20", "0X8005D20", 0, 0, ((aevp)localObject2).jdField_c_of_type_Int + "", aevj.a(i), this.jdField_a_of_type_JavaLangString, "", false);
            return;
          }
          if ((localObject1 instanceof aylx))
          {
            paramView = (aylx)localObject1;
            localObject1 = TroopInfoActivity.a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_b_of_type_JavaLangString, 101);
            ((Bundle)localObject1).putInt("exposureSource", 3);
            ((Bundle)localObject1).putInt("t_s_f", 1000);
            azlj.a(a(), (Bundle)localObject1, 2);
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(80000001), 0, "", "", "", "");
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_grpdate", 0, 0, paramView.jdField_a_of_type_JavaLangString, "", "", "");
            localObject1 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000001));
            if (localObject1 != null) {}
            for (i = ((Integer)localObject1).intValue();; i = 0)
            {
              avwf.a(80000001, i, paramView.jdField_a_of_type_Int, true, paramView.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
              avwf.a("add_page", "all_result", "clk_grp", 0, this.g, new String[] { paramView.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_JavaLangString, "" });
              return;
            }
          }
        } while (!(localObject1 instanceof aevo));
        paramView = getActivity();
      } while (paramView == null);
      localObject1 = (aevo)localObject1;
      Object localObject2 = new Intent(paramView, PublicAccountBrowser.class);
      ((Intent)localObject2).putExtra("url", ((aevo)localObject1).jdField_a_of_type_JavaLangString);
      if (jdField_b_of_type_Int == 13)
      {
        ((Intent)localObject2).putExtra("articalChannelId", 12);
        paramView.startActivity((Intent)localObject2);
        if (jdField_b_of_type_Int != 12) {
          break label1045;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "" + ((aevo)localObject1).jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + ((aevo)localObject1).jdField_a_of_type_Long);
        paramView = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000003));
        if (paramView == null) {
          break label1125;
        }
      }
      for (int i = paramView.intValue();; i = 0)
      {
        avwf.a(80000003, i, ((aevo)localObject1).jdField_a_of_type_Int, true, null, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
        return;
        if (jdField_b_of_type_Int == 1)
        {
          ((Intent)localObject2).putExtra("articalChannelId", 10);
          if ((localObject1 == null) || (((aevo)localObject1).jdField_b_of_type_JavaLangString == null)) {
            break;
          }
          ndn.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, ((aevo)localObject1).jdField_b_of_type_JavaLangString, ((aevo)localObject1).jdField_c_of_type_JavaLangString, "1");
          break;
        }
        if (jdField_b_of_type_Int != 2) {
          break;
        }
        ((Intent)localObject2).putExtra("articalChannelId", 11);
        break;
        ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "" + ((aevo)localObject1).jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + ((aevo)localObject1).jdField_a_of_type_Long, false);
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
    if (this.jdField_a_of_type_Aewa != null) {
      this.jdField_a_of_type_Aewa.c();
    }
    if (this.jdField_a_of_type_Akgd != null) {
      SosoInterface.b(this.jdField_a_of_type_Akgd);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Aesj != null) {
      this.jdField_a_of_type_Aesj.e();
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