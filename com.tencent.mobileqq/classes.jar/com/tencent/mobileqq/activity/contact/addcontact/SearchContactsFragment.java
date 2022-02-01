package com.tencent.mobileqq.activity.contact.addcontact;

import agej;
import ajdx;
import ajek;
import ajep;
import ajeq;
import ajeu;
import ajev;
import ajew;
import ajex;
import ajey;
import ajez;
import ajfa;
import ajfb;
import ajfc;
import ajhj;
import ajho;
import ajnu;
import ajny;
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
import anzj;
import aobl;
import aoof;
import apcq;
import bcnd;
import bcni;
import bdll;
import bfpc;
import bguq;
import bhjx;
import bhmq;
import bhnv;
import bhyu;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
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
import ocd;
import txo;
import tyi;

public class SearchContactsFragment
  extends SearchBaseFragment
{
  private static int jdField_b_of_type_Int = -1;
  private double jdField_a_of_type_Double;
  public int a;
  public ajez a;
  private ajfb jdField_a_of_type_Ajfb;
  ajho jdField_a_of_type_Ajho = new ajev(this);
  private ajnu jdField_a_of_type_Ajnu;
  protected apcq a;
  private ViewFactory.GuideView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView;
  private GroupSearchRecommendView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView;
  ArrayList<ajfa> jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private double jdField_b_of_type_Double;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<ajfc> jdField_b_of_type_JavaUtilArrayList;
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
    this.jdField_a_of_type_Apcq = new ajeu(this, 0, true, false, 60000L, false, false, "SearchContacts");
    SosoInterface.a(this.jdField_a_of_type_Apcq);
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
  
  private ajfc a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ajfc localajfc = (ajfc)localIterator.next();
      if (localajfc.jdField_a_of_type_Int == paramInt) {
        return localajfc;
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
  
  private void a(ajep paramajep)
  {
    Object localObject = getActivity();
    Intent localIntent;
    if (localObject != null)
    {
      localIntent = new Intent((Context)localObject, PublicAccountBrowser.class);
      localIntent.putExtra("url", paramajep.jdField_a_of_type_JavaLangString);
      if (jdField_b_of_type_Int != 13) {
        break label181;
      }
      localIntent.putExtra("articalChannelId", 12);
      ((Activity)localObject).startActivity(localIntent);
      if (jdField_b_of_type_Int != 12) {
        break label262;
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "" + paramajep.jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + paramajep.jdField_a_of_type_Long);
      label134:
      localObject = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000003));
      if (localObject == null) {
        break label335;
      }
    }
    label181:
    label335:
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      bcni.a(80000003, i, paramajep.jdField_a_of_type_Int, true, null, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
      return;
      if (jdField_b_of_type_Int == 1)
      {
        localIntent.putExtra("articalChannelId", 10);
        if ((paramajep == null) || (paramajep.jdField_b_of_type_JavaLangString == null)) {
          break;
        }
        ocd.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, paramajep.jdField_b_of_type_JavaLangString, paramajep.jdField_c_of_type_JavaLangString, "1");
        break;
      }
      if (jdField_b_of_type_Int != 2) {
        break;
      }
      localIntent.putExtra("articalChannelId", 11);
      break;
      ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "" + paramajep.jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + paramajep.jdField_a_of_type_Long, false);
      break label134;
    }
  }
  
  private void a(ajeq paramajeq)
  {
    a(paramajeq.jdField_b_of_type_Int, paramajeq.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record, 2);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(paramajeq.jdField_b_of_type_Int), 0, "", "", "", "");
    Object localObject2 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramajeq.jdField_b_of_type_Int));
    AccountSearchPb.record localrecord = null;
    Object localObject1 = localrecord;
    if (paramajeq != null)
    {
      localObject1 = localrecord;
      if (paramajeq.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null)
      {
        localObject1 = localrecord;
        if (paramajeq.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin != null) {
          localObject1 = String.valueOf(paramajeq.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get());
        }
      }
    }
    int j = paramajeq.jdField_b_of_type_Int;
    int i;
    label244:
    String str;
    if (localObject2 != null)
    {
      i = ((Integer)localObject2).intValue();
      bcni.a(j, i, paramajeq.jdField_c_of_type_Int, true, (String)localObject1, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
      if (paramajeq.jdField_b_of_type_Int == 80000002)
      {
        localrecord = paramajeq.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
        localObject1 = getActivity();
        if ((localrecord != null) && (localObject1 != null) && ((localObject1 instanceof SearchBaseActivity)))
        {
          i = ((SearchBaseActivity)localObject1).a();
          localObject2 = txo.a();
          if (localrecord.uin == null) {
            break label373;
          }
          localObject1 = localrecord.uin.get() + "";
          ((txo)localObject2).a(2, (String)localObject1, paramajeq.jdField_c_of_type_Int, jdField_b_of_type_Int);
          if (jdField_b_of_type_Int != 12) {
            break label386;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject2 = paramajeq.jdField_c_of_type_Int + "";
          str = ajek.a(i);
          if (localrecord.uin == null) {
            break label380;
          }
        }
      }
    }
    label373:
    label380:
    for (paramajeq = localrecord.uin.get() + "";; paramajeq = "")
    {
      bdll.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, (String)localObject2, str, paramajeq, this.jdField_a_of_type_JavaLangString);
      return;
      i = 0;
      break;
      localObject1 = "";
      break label244;
    }
    label386:
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localrecord.uin != null) {}
    for (localObject1 = localrecord.uin.get() + "";; localObject1 = "")
    {
      ocd.a((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005D20", "0X8005D20", 0, 0, paramajeq.jdField_c_of_type_Int + "", ajek.a(i), this.jdField_a_of_type_JavaLangString, "", false);
      return;
    }
  }
  
  private void a(bfpc parambfpc)
  {
    int i = 30008;
    if (parambfpc.jdField_a_of_type_Boolean) {
      i = 30004;
    }
    Object localObject = TroopInfoActivity.a(parambfpc.jdField_a_of_type_JavaLangString, parambfpc.jdField_b_of_type_JavaLangString, i);
    ((Bundle)localObject).putInt("exposureSource", 3);
    ((Bundle)localObject).putInt("t_s_f", 1000);
    bguq.a(a(), (Bundle)localObject, 2);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(80000001), 0, "", "", "", "");
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_grpdate", 0, 0, parambfpc.jdField_a_of_type_JavaLangString, "", "", "");
    localObject = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000001));
    if (localObject != null) {}
    for (i = ((Integer)localObject).intValue();; i = 0)
    {
      bcni.a(80000001, i, parambfpc.jdField_a_of_type_Int, true, parambfpc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
      bcni.a("add_page", "all_result", "clk_grp", 0, this.g, new String[] { parambfpc.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_JavaLangString, "" });
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
        ajfa localajfa = (ajfa)localIterator.next();
        if ((localajfa != null) && (localajfa.jdField_b_of_type_Int == 80000002)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(ArrayList<ajfc> paramArrayList)
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
        localObject = (ajfc)paramArrayList.get(0);
        if (!((ajfc)localObject).jdField_b_of_type_Boolean) {
          break label214;
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
    label214:
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
                localObject = ((ajfc)localObject).jdField_b_of_type_JavaUtilList;
                if ((localObject == null) || (((List)localObject).size() != 1)) {
                  break;
                }
                localObject = (AccountSearchPb.record)((List)localObject).get(0);
                j = ((ajfc)paramArrayList.get(0)).jdField_a_of_type_Int;
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
      a(((ajfc)paramArrayList.get(0)).jdField_a_of_type_Int, false, i);
      return true;
      if (this.jdField_d_of_type_Int != 0) {
        i = 0;
      }
    }
  }
  
  public String a(ajeq paramajeq, ajfa paramajfa)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramajfa.jdField_b_of_type_Int;
    paramajeq.jdField_a_of_type_JavaLangString = (paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "");
    boolean bool;
    SpannableStringBuilder localSpannableStringBuilder;
    label132:
    Object localObject;
    if (paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() != 0L)
    {
      bool = true;
      paramajeq.jdField_a_of_type_Boolean = bool;
      paramajeq.jdField_b_of_type_JavaLangString = paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.mobile.get();
      paramajeq.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      localSpannableStringBuilder = new SpannableStringBuilder();
      switch (i)
      {
      default: 
        localObject = bhyu.a(paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uint32_richflag1_59.get(), paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uint32_richflag4_409.get(), false, localSpannableStringBuilder);
        paramajeq.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        if ((i == 80000000) && (!TextUtils.isEmpty(paramajeq.jdField_a_of_type_JavaLangString)) && (bhjx.b(paramajeq.jdField_a_of_type_JavaLangString)))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130841751);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          int j = agej.a(15.0F, BaseApplication.getContext().getResources());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          ((Drawable)localObject).setBounds(0, 0, j, agej.a(15.0F, BaseApplication.getContext().getResources()));
          paramajeq.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
          label277:
          bhyu.a(paramajeq.jdField_b_of_type_AndroidWidgetTextView, paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uint32_richflag1_59.get(), paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uint32_richflag4_409.get());
          localStringBuilder.append(paramajeq.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
          localStringBuilder.append(paramajeq.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
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
      localObject = this.jdField_a_of_type_Aoof.a(i, paramajeq.jdField_a_of_type_JavaLangString);
      paramajfa = (ajfa)localObject;
      if (localObject == null)
      {
        localObject = bhmq.a();
        paramajfa = (ajfa)localObject;
        if (!this.jdField_a_of_type_Aoof.a())
        {
          this.jdField_a_of_type_Aoof.a(paramajeq.jdField_a_of_type_JavaLangString, i, true, (byte)1);
          paramajfa = (ajfa)localObject;
        }
      }
      paramajeq.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramajfa);
      return localStringBuilder.toString();
      bool = false;
      break;
      paramajeq.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000000, paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get()));
      localSpannableStringBuilder.append("(");
      if (paramajeq.jdField_a_of_type_Boolean) {}
      for (localObject = paramajeq.jdField_a_of_type_JavaLangString;; localObject = paramajeq.jdField_b_of_type_JavaLangString)
      {
        localSpannableStringBuilder.append(a(80000000, (String)localObject));
        localSpannableStringBuilder.append(")");
        break;
      }
      paramajeq.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000002, String.valueOf(paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      break label132;
      paramajeq.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000001, String.valueOf(paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      localSpannableStringBuilder.append("(");
      localSpannableStringBuilder.append(a(80000001, String.valueOf(paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get())));
      localSpannableStringBuilder.append(")");
      break label132;
      paramajeq.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label277;
      localStringBuilder.append(a(paramajeq, paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
      continue;
      i = 4;
      paramajeq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramajeq.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramajeq.jdField_c_of_type_AndroidWidgetTextView.setText(paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get() + anzj.a(2131712495));
      paramajeq.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131167070));
      paramajeq.d.setText(paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get());
      paramajeq.jdField_a_of_type_JavaLangString = String.valueOf(paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
      localStringBuilder.append(paramajeq.jdField_c_of_type_AndroidWidgetTextView.getText()).append(paramajeq.d.getText());
      continue;
      localStringBuilder.append(b(paramajeq, paramajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
    }
  }
  
  ArrayList<ajfc> a(ArrayList<ajfc> paramArrayList)
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
        ajfc localajfc = (ajfc)localIterator.next();
        if (localajfc.jdField_a_of_type_Int == k) {
          localArrayList.add(localajfc);
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
        if (this.jdField_a_of_type_Ajfb == null)
        {
          this.jdField_a_of_type_Ajfb = new ajfb(this, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 4, true);
          this.jdField_a_of_type_Ajfb.a(this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ajfb);
          this.a = this.jdField_a_of_type_Ajfb;
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
        }
        this.jdField_a_of_type_Ajfb.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Ajfb.notifyDataSetChanged();
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
        }
      } while (!a());
      localObject1 = getActivity();
      if ((localObject1 != null) && ((localObject1 instanceof SearchContactsActivity)))
      {
        localObject1 = ajek.a(((SearchContactsActivity)localObject1).a());
        ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1F", "0X8005D1F", 0, 0, "", (String)localObject1, this.jdField_a_of_type_JavaLangString, "", false);
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList == null);
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      ajfa localajfa = (ajfa)((Iterator)localObject2).next();
      if ((localajfa != null) && (localajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) && (localajfa.jdField_b_of_type_Int == 80000002))
      {
        ((StringBuilder)localObject1).append(String.valueOf(localajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get())).append("#");
        i += 1;
      }
    }
    localObject2 = txo.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    txo.a().a((String)localObject2, this.jdField_a_of_type_JavaLangString, 2, false, i, ((StringBuilder)localObject1).toString());
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
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
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF1", "0X8004BF1", paramInt1, 0, "", "", "", "");
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
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_more", 0, 0, "", "", "", "");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_JavaLangString.matches("^\\d{5,11}$")) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        bdll.b((QQAppInterface)localObject2, "dc00899", "Grp_find", "", "inte_add", "inte_find_grp", 0, 0, (String)localObject1, this.jdField_a_of_type_JavaLangString, "", "");
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
      ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "0", ajek.a(paramInt1), this.jdField_a_of_type_JavaLangString, "", false);
      paramInt1 = 3;
      continue;
      ((Intent)localObject1).putExtra("from_key", 5);
      ((Intent)localObject1).putExtra("fromType", jdField_b_of_type_Int);
      ((Intent)localObject1).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject1, a(paramInt1));
      ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, "0", "", this.jdField_a_of_type_JavaLangString, "", false);
      paramInt1 = 1;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Intent localIntent = new Intent(a(), PublicAccountBrowser.class);
      localIntent.putExtra("url", paramString1);
      a().startActivity(localIntent);
      ocd.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, paramString2, paramString3, "2");
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsFragment", 2, "doSearch");
    }
    if (bhnv.d(BaseApplicationImpl.getContext()))
    {
      i();
      this.jdField_a_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_Ajdx == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "doSearch:should not be here | searchFacade = null");
        }
        j();
        return;
      }
      this.jdField_a_of_type_Ajdx.c();
      if (this.jdField_d_of_type_Int == 1)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Int = 80000001;
        if (this.jdField_d_of_type_Boolean) {
          ajhj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
        }
      }
      else
      {
        if (jdField_b_of_type_Int != 12) {
          break label225;
        }
        localajdx = this.jdField_a_of_type_Ajdx;
        if (!this.jdField_a_of_type_Boolean) {
          break label218;
        }
      }
      label218:
      for (int i = this.jdField_a_of_type_Int;; i = 80000006)
      {
        localajdx.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 1);
        this.jdField_c_of_type_Boolean = true;
        if (!this.jdField_a_of_type_Boolean) {
          break label270;
        }
        paramString = a(this.jdField_a_of_type_Int);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramString, paramString, this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
        return;
        this.jdField_d_of_type_Boolean = true;
        break;
      }
      label225:
      ajdx localajdx = this.jdField_a_of_type_Ajdx;
      if (this.jdField_a_of_type_Boolean) {}
      for (i = this.jdField_a_of_type_Int;; i = 80000005)
      {
        localajdx.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 0);
        break;
      }
      label270:
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BED", "0X8004BED", this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131693965, 0).b(b());
  }
  
  protected boolean a(ArrayList<ajfc> paramArrayList)
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
      this.g = bcnd.a(paramArrayList, this.e);
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
      a(((ajfc)paramArrayList.get(0)).jdField_a_of_type_Int, false, i);
      return false;
      if (this.jdField_d_of_type_Int == 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  ArrayList<ajfa> b(ArrayList<ajfc> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(12);
    int n = paramArrayList.size();
    int j = 0;
    ajfc localajfc;
    for (;;)
    {
      if (j < n)
      {
        localajfc = (ajfc)paramArrayList.get(j);
        if ((localajfc == null) || ((localajfc.jdField_b_of_type_JavaUtilList.size() <= 0) && (localajfc.jdField_c_of_type_JavaUtilList.size() <= 0)))
        {
          j += 1;
        }
        else
        {
          localObject = new ajfa();
          ((ajfa)localObject).jdField_a_of_type_Int = 0;
          ((ajfa)localObject).jdField_b_of_type_Int = localajfc.jdField_a_of_type_Int;
          ((ajfa)localObject).jdField_a_of_type_Boolean = localajfc.jdField_c_of_type_Boolean;
          if (ViewFactory.a(localajfc.jdField_a_of_type_Int) == 2131689658)
          {
            ((ajfa)localObject).jdField_a_of_type_JavaLangString = tyi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
            label137:
            localArrayList.add(localObject);
            if (TextUtils.isEmpty(localajfc.jdField_a_of_type_JavaLangString)) {
              break label833;
            }
          }
        }
      }
    }
    label822:
    label833:
    for (Object localObject = localajfc.jdField_a_of_type_JavaLangString;; localObject = null)
    {
      ajfa localajfa;
      int i;
      if ((localajfc.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) && (localajfc.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.has()))
      {
        localajfa = new ajfa();
        localajfa.jdField_a_of_type_Int = 2;
        localajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = localajfc.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
        localajfa.jdField_b_of_type_Int = localajfc.jdField_a_of_type_Int;
        localajfa.jdField_c_of_type_Int = localajfc.jdField_c_of_type_Int;
        localajfa.jdField_b_of_type_JavaLangString = ((String)localObject);
        localArrayList.add(localajfa);
        i = 2;
        ocd.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F75", "0X8006F75", 0, 0, this.jdField_a_of_type_JavaLangString, localajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
      }
      for (;;)
      {
        int m;
        int k;
        if (localajfc.jdField_a_of_type_Int == 80000004)
        {
          m = localajfc.jdField_c_of_type_JavaUtilList.size();
          k = 0;
          label322:
          if (k < i)
          {
            localObject = new ajfa();
            ((ajfa)localObject).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem = ((AccountSearchPb.ResultItem)localajfc.jdField_c_of_type_JavaUtilList.get(k));
            ((ajfa)localObject).jdField_a_of_type_Int = 2;
            ((ajfa)localObject).jdField_b_of_type_Int = localajfc.jdField_a_of_type_Int;
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
            localObject = new ajfa();
            ((ajfa)localObject).jdField_a_of_type_Int = 1;
            ((ajfa)localObject).jdField_b_of_type_Int = localajfc.jdField_a_of_type_Int;
            ((ajfa)localObject).jdField_c_of_type_Int = localajfc.jdField_c_of_type_Int;
            if (localajfc.jdField_a_of_type_Int == 80000004) {
              ((ajfa)localObject).jdField_c_of_type_JavaLangString = localajfc.jdField_a_of_type_JavaLangString;
            }
            localArrayList.add(localObject);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SearchContactsFragment", 2, "search reuslt : type = " + localajfc.jdField_a_of_type_Int + "count = " + localajfc.jdField_b_of_type_JavaUtilList.size());
          }
          localObject = "";
          switch (localajfc.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            bdll.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, String.valueOf(Math.min(i, 3)), "", "", "");
            break;
            ((ajfa)localObject).jdField_a_of_type_JavaLangString = a().getString(ViewFactory.a(localajfc.jdField_a_of_type_Int));
            break label137;
            k += 1;
            break label322;
            k = localajfc.jdField_b_of_type_JavaUtilList.size();
            m = 0;
            for (;;)
            {
              if (m >= i) {
                break label822;
              }
              localajfa = new ajfa();
              localajfa.jdField_a_of_type_Int = 2;
              localajfa.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)localajfc.jdField_b_of_type_JavaUtilList.get(m));
              localajfa.jdField_b_of_type_Int = localajfc.jdField_a_of_type_Int;
              localajfa.jdField_c_of_type_Int = localajfc.jdField_c_of_type_Int;
              localajfa.jdField_b_of_type_JavaLangString = ((String)localObject);
              localajfa.jdField_a_of_type_Boolean = localajfc.jdField_c_of_type_Boolean;
              localArrayList.add(localajfa);
              if (m >= k - 1)
              {
                i = k;
                break;
              }
              if (localajfc.jdField_a_of_type_Int == 80000001) {
                bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "exp", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView = new GroupSearchRecommendView(a(), this.jdField_a_of_type_Ajho, new ajew(this), new ajex(this));
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
    Object localObject = (aobl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    if ((80000001 == this.jdField_a_of_type_Int) && (((aobl)localObject).jdField_d_of_type_Boolean)) {
      if (this.jdField_a_of_type_Ajnu == null)
      {
        this.jdField_a_of_type_Ajnu = new ajny(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, null);
        localObject = this.jdField_a_of_type_Ajnu.a();
        TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localTextView.setGravity(17);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, agej.a(105.0F, getResources())));
        localTextView.setTextColor(getResources().getColor(2131167074));
        localTextView.setTextSize(1, 17.0F);
        localTextView.setText(anzj.a(2131712502));
        localTextView.setBackgroundResource(2130838779);
        ((ListView)localObject).addHeaderView(localTextView);
        localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localTextView.setTextColor(getResources().getColor(2131167074));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setGravity(16);
        localTextView.setPadding(agej.a(15.0F, getResources()), 0, 0, 0);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, agej.a(40.0F, getResources())));
        localTextView.setText(anzj.a(2131712493));
        localTextView.setBackgroundResource(2130838779);
        ((ListView)localObject).addHeaderView(localTextView);
        a(this.jdField_a_of_type_Ajnu.a());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_Ajnu.e();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView = ((ViewFactory.GuideView)ViewFactory.a().a(80000005, a(), true, this.jdField_a_of_type_Aoof, null));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {}
    }
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) == this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.setListener(new ajey(this));
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject != null) {
      if ((localObject instanceof ajeq)) {
        a((ajeq)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof bfpc))
      {
        a((bfpc)localObject);
      }
      else if ((localObject instanceof ajep))
      {
        a((ajep)localObject);
        continue;
        if ((paramView instanceof QzoneSearchResultView)) {
          ((QzoneSearchResultView)paramView).a(getActivity());
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Ajfb != null) {
      this.jdField_a_of_type_Ajfb.c();
    }
    if (this.jdField_a_of_type_Apcq != null) {
      SosoInterface.b(this.jdField_a_of_type_Apcq);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Ajnu != null) {
      this.jdField_a_of_type_Ajnu.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment
 * JD-Core Version:    0.7.0.1
 */