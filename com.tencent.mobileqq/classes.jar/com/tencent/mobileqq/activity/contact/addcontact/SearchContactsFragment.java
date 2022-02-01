package com.tencent.mobileqq.activity.contact.addcontact;

import aitg;
import aits;
import aitx;
import aity;
import aiuc;
import aiud;
import aiue;
import aiuf;
import aiug;
import aiuh;
import aiui;
import aiuj;
import aiuk;
import aiwr;
import aiww;
import ajdc;
import ajdg;
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
import anvx;
import anyb;
import bcmx;
import bcnc;
import bdla;
import bffp;
import bhbx;
import bheg;
import bhnz;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
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
import olh;
import usa;
import usu;

public class SearchContactsFragment
  extends SearchBaseFragment
{
  private static int jdField_b_of_type_Int = -1;
  private double jdField_a_of_type_Double;
  public int a;
  public aiuh a;
  private aiuj jdField_a_of_type_Aiuj;
  aiww jdField_a_of_type_Aiww = new aiud(this);
  private ajdc jdField_a_of_type_Ajdc;
  private ViewFactory.GuideView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView;
  private GroupSearchRecommendView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView;
  protected SosoInterface.OnLocationListener a;
  ArrayList<aiui> jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private double jdField_b_of_type_Double;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<aiuk> jdField_b_of_type_JavaUtilArrayList;
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
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new aiuc(this, 0, true, false, 60000L, false, false, "SearchContacts");
    SosoInterface.startLocation(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
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
  
  private aiuk a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aiuk localaiuk = (aiuk)localIterator.next();
      if (localaiuk.jdField_a_of_type_Int == paramInt) {
        return localaiuk;
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
  
  private void a(aitx paramaitx)
  {
    if (paramaitx == null) {}
    Object localObject;
    do
    {
      return;
      localObject = getActivity();
    } while (localObject == null);
    Intent localIntent = new Intent((Context)localObject, PublicAccountBrowser.class);
    localIntent.putExtra("url", paramaitx.jdField_a_of_type_JavaLangString);
    if (jdField_b_of_type_Int == 13)
    {
      localIntent.putExtra("articalChannelId", 12);
      ((Activity)localObject).startActivity(localIntent);
      if (jdField_b_of_type_Int != 12) {
        break label263;
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "" + paramaitx.jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + paramaitx.jdField_a_of_type_Long);
      label139:
      localObject = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000003));
      if (localObject == null) {
        break label336;
      }
    }
    label263:
    label336:
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      bcnc.a(80000003, i, paramaitx.jdField_a_of_type_Int, true, null, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
      return;
      if (jdField_b_of_type_Int == 1)
      {
        localIntent.putExtra("articalChannelId", 10);
        if (paramaitx.jdField_b_of_type_JavaLangString == null) {
          break;
        }
        olh.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, paramaitx.jdField_b_of_type_JavaLangString, paramaitx.jdField_c_of_type_JavaLangString, "1");
        break;
      }
      if (jdField_b_of_type_Int != 2) {
        break;
      }
      localIntent.putExtra("articalChannelId", 11);
      break;
      olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "" + paramaitx.jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + paramaitx.jdField_a_of_type_Long, false);
      break label139;
    }
  }
  
  private void a(aity paramaity)
  {
    if (paramaity == null) {}
    AccountSearchPb.record localrecord;
    do
    {
      do
      {
        do
        {
          return;
          if (paramaity != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("SearchContactsFragment", 2, "onClickItemViewHolder return for null holder");
        return;
        a(paramaity.jdField_b_of_type_Int, paramaity.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record, 2);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(paramaity.jdField_b_of_type_Int), 0, "", "", "", "");
        localObject2 = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramaity.jdField_b_of_type_Int));
        localrecord = null;
        localObject1 = localrecord;
        if (paramaity.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null)
        {
          localObject1 = localrecord;
          if (paramaity.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin != null) {
            localObject1 = String.valueOf(paramaity.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get());
          }
        }
        int j = paramaity.jdField_b_of_type_Int;
        if (localObject2 == null) {
          break;
        }
        i = ((Integer)localObject2).intValue();
        bcnc.a(j, i, paramaity.jdField_c_of_type_Int, true, (String)localObject1, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
      } while (paramaity.jdField_b_of_type_Int != 80000002);
      localrecord = paramaity.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
      localObject1 = getActivity();
    } while ((localrecord == null) || (localObject1 == null) || (!(localObject1 instanceof SearchBaseActivity)));
    int i = ((SearchBaseActivity)localObject1).a();
    Object localObject2 = usa.a();
    label260:
    String str;
    if (localrecord.uin != null)
    {
      localObject1 = localrecord.uin.get() + "";
      ((usa)localObject2).a(2, (String)localObject1, paramaity.jdField_c_of_type_Int, jdField_b_of_type_Int);
      if (jdField_b_of_type_Int != 12) {
        break label402;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = paramaity.jdField_c_of_type_Int + "";
      str = aits.a(i);
      if (localrecord.uin == null) {
        break label396;
      }
    }
    label396:
    for (paramaity = localrecord.uin.get() + "";; paramaity = "")
    {
      bdla.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, (String)localObject2, str, paramaity, this.jdField_a_of_type_JavaLangString);
      return;
      i = 0;
      break;
      localObject1 = "";
      break label260;
    }
    label402:
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localrecord.uin != null) {}
    for (Object localObject1 = localrecord.uin.get() + "";; localObject1 = "")
    {
      olh.a((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005D20", "0X8005D20", 0, 0, paramaity.jdField_c_of_type_Int + "", aits.a(i), this.jdField_a_of_type_JavaLangString, "", false);
      return;
    }
  }
  
  private void a(bffp parambffp)
  {
    int i = 30008;
    if (parambffp.jdField_a_of_type_Boolean) {
      i = 30004;
    }
    Object localObject = TroopInfoActivity.a(parambffp.jdField_a_of_type_JavaLangString, parambffp.jdField_b_of_type_JavaLangString, i);
    ((Bundle)localObject).putInt("exposureSource", 3);
    ((Bundle)localObject).putInt("t_s_f", 1000);
    TroopUtils.openTroopInfoActivity(a(), (Bundle)localObject, 2);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(80000001), 0, "", "", "", "");
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_grpdate", 0, 0, parambffp.jdField_a_of_type_JavaLangString, "", "", "");
    localObject = (Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(80000001));
    if (localObject != null) {}
    for (i = ((Integer)localObject).intValue();; i = 0)
    {
      bcnc.a(80000001, i, parambffp.jdField_a_of_type_Int, true, parambffp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
      bcnc.a("add_page", "all_result", "clk_grp", 0, this.g, new String[] { parambffp.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_JavaLangString, "" });
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
        aiui localaiui = (aiui)localIterator.next();
        if ((localaiui != null) && (localaiui.jdField_b_of_type_Int == 80000002)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b(ArrayList<aiuk> paramArrayList)
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
        localObject = (aiuk)paramArrayList.get(0);
        if (!((aiuk)localObject).jdField_b_of_type_Boolean) {
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
                localObject = ((aiuk)localObject).jdField_b_of_type_JavaUtilList;
                if ((localObject == null) || (((List)localObject).size() != 1)) {
                  break;
                }
                localObject = (AccountSearchPb.record)((List)localObject).get(0);
                j = ((aiuk)paramArrayList.get(0)).jdField_a_of_type_Int;
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
      a(((aiuk)paramArrayList.get(0)).jdField_a_of_type_Int, false, i);
      return true;
      if (this.jdField_d_of_type_Int != 0) {
        i = 0;
      }
    }
  }
  
  public String a(aity paramaity, aiui paramaiui)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramaiui.jdField_b_of_type_Int;
    paramaity.jdField_a_of_type_JavaLangString = (paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "");
    boolean bool;
    SpannableStringBuilder localSpannableStringBuilder;
    label132:
    Object localObject;
    if (paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() != 0L)
    {
      bool = true;
      paramaity.jdField_a_of_type_Boolean = bool;
      paramaity.jdField_b_of_type_JavaLangString = paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.mobile.get();
      paramaity.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      localSpannableStringBuilder = new SpannableStringBuilder();
      switch (i)
      {
      default: 
        localObject = bhnz.a(paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uint32_richflag1_59.get(), paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uint32_richflag4_409.get(), localSpannableStringBuilder, paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.accout.get());
        paramaity.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        if ((i == 80000000) && (!TextUtils.isEmpty(paramaity.jdField_a_of_type_JavaLangString)) && (bhbx.b(paramaity.jdField_a_of_type_JavaLangString)))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130841803);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          int j = AIOUtils.dp2px(15.0F, BaseApplication.getContext().getResources());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          ((Drawable)localObject).setBounds(0, 0, j, AIOUtils.dp2px(15.0F, BaseApplication.getContext().getResources()));
          paramaity.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
          label286:
          bhnz.a(paramaity.jdField_b_of_type_AndroidWidgetTextView, paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uint32_richflag1_59.get(), paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uint32_richflag4_409.get(), 2131167107, 17);
          localStringBuilder.append(paramaity.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
          localStringBuilder.append(paramaity.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(i, paramaity.jdField_a_of_type_JavaLangString);
      paramaiui = (aiui)localObject;
      if (localObject == null)
      {
        localObject = bheg.a();
        paramaiui = (aiui)localObject;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramaity.jdField_a_of_type_JavaLangString, i, true, (byte)1);
          paramaiui = (aiui)localObject;
        }
      }
      paramaity.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramaiui);
      return localStringBuilder.toString();
      bool = false;
      break;
      paramaity.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000000, paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get()));
      localSpannableStringBuilder.append("(");
      if (paramaity.jdField_a_of_type_Boolean) {}
      for (localObject = paramaity.jdField_a_of_type_JavaLangString;; localObject = paramaity.jdField_b_of_type_JavaLangString)
      {
        localSpannableStringBuilder.append(a(80000000, (String)localObject));
        localSpannableStringBuilder.append(")");
        break;
      }
      paramaity.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000002, String.valueOf(paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      break label132;
      paramaity.jdField_a_of_type_AndroidWidgetTextView.setText(a(80000001, String.valueOf(paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get())));
      localSpannableStringBuilder.append("(");
      localSpannableStringBuilder.append(a(80000001, String.valueOf(paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get())));
      localSpannableStringBuilder.append(")");
      break label132;
      paramaity.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label286;
      localStringBuilder.append(a(paramaity, paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
      continue;
      i = 4;
      paramaity.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramaity.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramaity.jdField_c_of_type_AndroidWidgetTextView.setText(paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get() + anvx.a(2131713074));
      paramaity.jdField_c_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131167106));
      paramaity.d.setText(paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get());
      paramaity.jdField_a_of_type_JavaLangString = String.valueOf(paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
      localStringBuilder.append(paramaity.jdField_c_of_type_AndroidWidgetTextView.getText()).append(paramaity.d.getText());
      continue;
      localStringBuilder.append(b(paramaity, paramaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
    }
  }
  
  ArrayList<aiuk> a(ArrayList<aiuk> paramArrayList)
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
        aiuk localaiuk = (aiuk)localIterator.next();
        if (localaiuk.jdField_a_of_type_Int == k) {
          localArrayList.add(localaiuk);
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
        if (this.jdField_a_of_type_Aiuj == null)
        {
          this.jdField_a_of_type_Aiuj = new aiuj(this, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 4, true);
          this.jdField_a_of_type_Aiuj.a(this.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aiuj);
          this.a = this.jdField_a_of_type_Aiuj;
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
        }
        this.jdField_a_of_type_Aiuj.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Aiuj.notifyDataSetChanged();
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
        }
      } while (!a());
      localObject1 = getActivity();
      if ((localObject1 != null) && ((localObject1 instanceof SearchContactsActivity)))
      {
        localObject1 = aits.a(((SearchContactsActivity)localObject1).a());
        olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1F", "0X8005D1F", 0, 0, "", (String)localObject1, this.jdField_a_of_type_JavaLangString, "", false);
      }
    } while (this.jdField_a_of_type_JavaUtilArrayList == null);
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      aiui localaiui = (aiui)((Iterator)localObject2).next();
      if ((localaiui != null) && (localaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) && (localaiui.jdField_b_of_type_Int == 80000002))
      {
        ((StringBuilder)localObject1).append(String.valueOf(localaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get())).append("#");
        i += 1;
      }
    }
    localObject2 = usa.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    usa.a().a((String)localObject2, this.jdField_a_of_type_JavaLangString, 2, false, i, ((StringBuilder)localObject1).toString());
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
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF1", "0X8004BF1", paramInt1, 0, "", "", "", "");
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
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "Clk_more", 0, 0, "", "", "", "");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_JavaLangString.matches("^\\d{5,11}$")) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        bdla.b((QQAppInterface)localObject2, "dc00899", "Grp_find", "", "inte_add", "inte_find_grp", 0, 0, (String)localObject1, this.jdField_a_of_type_JavaLangString, "", "");
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
      olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "0", aits.a(paramInt1), this.jdField_a_of_type_JavaLangString, "", false);
      paramInt1 = 3;
      continue;
      ((Intent)localObject1).putExtra("from_key", 5);
      ((Intent)localObject1).putExtra("fromType", jdField_b_of_type_Int);
      ((Intent)localObject1).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject1, a(paramInt1));
      olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, "0", "", this.jdField_a_of_type_JavaLangString, "", false);
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
      olh.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.jdField_a_of_type_JavaLangString, paramString2, paramString3, "2");
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
      if (this.jdField_a_of_type_Aitg == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "doSearch:should not be here | searchFacade = null");
        }
        j();
        return;
      }
      this.jdField_a_of_type_Aitg.c();
      if (this.jdField_d_of_type_Int == 1)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Int = 80000001;
        if (this.jdField_d_of_type_Boolean) {
          aiwr.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString);
        }
      }
      else
      {
        if (jdField_b_of_type_Int != 12) {
          break label223;
        }
        localaitg = this.jdField_a_of_type_Aitg;
        if (!this.jdField_a_of_type_Boolean) {
          break label216;
        }
      }
      label216:
      for (int i = this.jdField_a_of_type_Int;; i = 80000006)
      {
        localaitg.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 1);
        this.jdField_c_of_type_Boolean = true;
        if (!this.jdField_a_of_type_Boolean) {
          break label268;
        }
        paramString = a(this.jdField_a_of_type_Int);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramString, paramString, this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
        return;
        this.jdField_d_of_type_Boolean = true;
        break;
      }
      label223:
      aitg localaitg = this.jdField_a_of_type_Aitg;
      if (this.jdField_a_of_type_Boolean) {}
      for (i = this.jdField_a_of_type_Int;; i = 80000005)
      {
        localaitg.a(paramString, i, this.jdField_b_of_type_Double, this.jdField_a_of_type_Double, 0);
        break;
      }
      label268:
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BED", "0X8004BED", this.jdField_d_of_type_Int + 1, 0, "", "", "", "");
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131694255, 0).b(b());
  }
  
  protected boolean a(ArrayList<aiuk> paramArrayList)
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
      this.g = bcmx.a(paramArrayList, this.e);
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
      a(((aiuk)paramArrayList.get(0)).jdField_a_of_type_Int, false, i);
      return false;
      if (this.jdField_d_of_type_Int == 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  ArrayList<aiui> b(ArrayList<aiuk> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(12);
    int n = paramArrayList.size();
    int j = 0;
    aiuk localaiuk;
    for (;;)
    {
      if (j < n)
      {
        localaiuk = (aiuk)paramArrayList.get(j);
        if ((localaiuk == null) || ((localaiuk.jdField_b_of_type_JavaUtilList.size() <= 0) && (localaiuk.jdField_c_of_type_JavaUtilList.size() <= 0)))
        {
          j += 1;
        }
        else
        {
          localObject = new aiui();
          ((aiui)localObject).jdField_a_of_type_Int = 0;
          ((aiui)localObject).jdField_b_of_type_Int = localaiuk.jdField_a_of_type_Int;
          ((aiui)localObject).jdField_a_of_type_Boolean = localaiuk.jdField_c_of_type_Boolean;
          if (ViewFactory.a(localaiuk.jdField_a_of_type_Int) == 2131689657)
          {
            ((aiui)localObject).jdField_a_of_type_JavaLangString = usu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
            label137:
            localArrayList.add(localObject);
            if (TextUtils.isEmpty(localaiuk.jdField_a_of_type_JavaLangString)) {
              break label833;
            }
          }
        }
      }
    }
    label822:
    label833:
    for (Object localObject = localaiuk.jdField_a_of_type_JavaLangString;; localObject = null)
    {
      aiui localaiui;
      int i;
      if ((localaiuk.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) && (localaiuk.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.has()))
      {
        localaiui = new aiui();
        localaiui.jdField_a_of_type_Int = 2;
        localaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = localaiuk.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord;
        localaiui.jdField_b_of_type_Int = localaiuk.jdField_a_of_type_Int;
        localaiui.jdField_c_of_type_Int = localaiuk.jdField_c_of_type_Int;
        localaiui.jdField_b_of_type_JavaLangString = ((String)localObject);
        localArrayList.add(localaiui);
        i = 2;
        olh.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F75", "0X8006F75", 0, 0, this.jdField_a_of_type_JavaLangString, localaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
      }
      for (;;)
      {
        int m;
        int k;
        if (localaiuk.jdField_a_of_type_Int == 80000004)
        {
          m = localaiuk.jdField_c_of_type_JavaUtilList.size();
          k = 0;
          label322:
          if (k < i)
          {
            localObject = new aiui();
            ((aiui)localObject).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem = ((AccountSearchPb.ResultItem)localaiuk.jdField_c_of_type_JavaUtilList.get(k));
            ((aiui)localObject).jdField_a_of_type_Int = 2;
            ((aiui)localObject).jdField_b_of_type_Int = localaiuk.jdField_a_of_type_Int;
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
            localObject = new aiui();
            ((aiui)localObject).jdField_a_of_type_Int = 1;
            ((aiui)localObject).jdField_b_of_type_Int = localaiuk.jdField_a_of_type_Int;
            ((aiui)localObject).jdField_c_of_type_Int = localaiuk.jdField_c_of_type_Int;
            if (localaiuk.jdField_a_of_type_Int == 80000004) {
              ((aiui)localObject).jdField_c_of_type_JavaLangString = localaiuk.jdField_a_of_type_JavaLangString;
            }
            localArrayList.add(localObject);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SearchContactsFragment", 2, "search reuslt : type = " + localaiuk.jdField_a_of_type_Int + "count = " + localaiuk.jdField_b_of_type_JavaUtilList.size());
          }
          localObject = "";
          switch (localaiuk.jdField_a_of_type_Int)
          {
          }
          for (;;)
          {
            bdla.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, String.valueOf(Math.min(i, 3)), "", "", "");
            break;
            ((aiui)localObject).jdField_a_of_type_JavaLangString = a().getString(ViewFactory.a(localaiuk.jdField_a_of_type_Int));
            break label137;
            k += 1;
            break label322;
            k = localaiuk.jdField_b_of_type_JavaUtilList.size();
            m = 0;
            for (;;)
            {
              if (m >= i) {
                break label822;
              }
              localaiui = new aiui();
              localaiui.jdField_a_of_type_Int = 2;
              localaiui.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)localaiuk.jdField_b_of_type_JavaUtilList.get(m));
              localaiui.jdField_b_of_type_Int = localaiuk.jdField_a_of_type_Int;
              localaiui.jdField_c_of_type_Int = localaiuk.jdField_c_of_type_Int;
              localaiui.jdField_b_of_type_JavaLangString = ((String)localObject);
              localaiui.jdField_a_of_type_Boolean = localaiuk.jdField_c_of_type_Boolean;
              localArrayList.add(localaiui);
              if (m >= k - 1)
              {
                i = k;
                break;
              }
              if (localaiuk.jdField_a_of_type_Int == 80000001) {
                bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "result", "exp", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView = new GroupSearchRecommendView(a(), this.jdField_a_of_type_Aiww, new aiue(this), new aiuf(this));
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
    Object localObject = (anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    if ((80000001 == this.jdField_a_of_type_Int) && (((anyb)localObject).jdField_d_of_type_Boolean)) {
      if (this.jdField_a_of_type_Ajdc == null)
      {
        this.jdField_a_of_type_Ajdc = new ajdg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, null);
        localObject = this.jdField_a_of_type_Ajdc.a();
        TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localTextView.setGravity(17);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.dp2px(105.0F, getResources())));
        localTextView.setTextColor(getResources().getColor(2131167110));
        localTextView.setTextSize(1, 17.0F);
        localTextView.setText(anvx.a(2131713081));
        localTextView.setBackgroundResource(2130838912);
        ((ListView)localObject).addHeaderView(localTextView);
        localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localTextView.setTextColor(getResources().getColor(2131167110));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setGravity(16);
        localTextView.setPadding(AIOUtils.dp2px(15.0F, getResources()), 0, 0, 0);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.dp2px(40.0F, getResources())));
        localTextView.setText(anvx.a(2131713072));
        localTextView.setBackgroundResource(2130838912);
        ((ListView)localObject).addHeaderView(localTextView);
        a(this.jdField_a_of_type_Ajdc.a());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_Ajdc.e();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView = ((ViewFactory.GuideView)ViewFactory.a().a(80000005, a(), true, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, null));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {}
    }
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) == this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.setListener(new aiug(this));
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject != null) {
      if ((localObject instanceof aity)) {
        a((aity)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof bffp))
      {
        a((bffp)localObject);
      }
      else if ((localObject instanceof aitx))
      {
        a((aitx)localObject);
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
    if (this.jdField_a_of_type_Aiuj != null) {
      this.jdField_a_of_type_Aiuj.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null) {
      SosoInterface.removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Ajdc != null) {
      this.jdField_a_of_type_Ajdc.c();
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