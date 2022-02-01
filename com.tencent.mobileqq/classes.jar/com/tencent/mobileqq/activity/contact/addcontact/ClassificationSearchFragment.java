package com.tencent.mobileqq.activity.contact.addcontact;

import afur;
import aisj;
import aisl;
import aism;
import aiso;
import aitb;
import aitg;
import aith;
import aitt;
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
import anni;
import aobu;
import bbup;
import bcst;
import bgjw;
import bgmo;
import bgnt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.GridView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import oat;
import txm;
import tyg;

public class ClassificationSearchFragment
  extends SearchBaseFragment
{
  private static aitt jdField_a_of_type_Aitt;
  private static int h;
  public int a;
  private aisj jdField_a_of_type_Aisj;
  private aism jdField_a_of_type_Aism;
  private View jdField_a_of_type_AndroidViewView;
  private List<AccountSearchPb.record> jdField_a_of_type_JavaUtilList = new ArrayList(20);
  public boolean a;
  int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView;
  private boolean d;
  private int g;
  private int i;
  
  public ClassificationSearchFragment()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static ClassificationSearchFragment a(int paramInt)
  {
    h = paramInt;
    return new ClassificationSearchFragment();
  }
  
  public static ClassificationSearchFragment a(aitt paramaitt)
  {
    jdField_a_of_type_Aitt = paramaitt;
    return new ClassificationSearchFragment();
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Aism != null) {
      this.jdField_a_of_type_Aism.notifyDataSetChanged();
    }
  }
  
  private boolean b(ArrayList<aitt> paramArrayList)
  {
    if ((!this.jdField_b_of_type_Boolean) && (paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = ((aitt)paramArrayList.get(0)).jdField_b_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        a(((aitt)paramArrayList.get(0)).jdField_a_of_type_Int, (AccountSearchPb.record)localObject, 2);
        return true;
      }
    }
    return false;
  }
  
  private String c(aith paramaith, AccountSearchPb.record paramrecord)
  {
    int k = 11;
    StringBuilder localStringBuilder = new StringBuilder();
    paramaith.jdField_a_of_type_JavaLangString = (paramrecord.uin.get() + "");
    paramaith.jdField_b_of_type_JavaLangString = paramrecord.mobile.get();
    boolean bool;
    Object localObject2;
    Object localObject1;
    label148:
    label304:
    int j;
    if (paramrecord.uin.get() != 0L)
    {
      bool = true;
      paramaith.jdField_a_of_type_Boolean = bool;
      paramaith.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramaith.jdField_b_of_type_Int, paramrecord.name.get()));
      localStringBuilder.append(paramaith.jdField_a_of_type_AndroidWidgetTextView.getText());
      if (paramaith.jdField_b_of_type_Int == 80000000)
      {
        localObject2 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject2).append("(");
        if (!paramaith.jdField_a_of_type_Boolean) {
          break label426;
        }
        localObject1 = paramaith.jdField_a_of_type_JavaLangString;
        ((SpannableStringBuilder)localObject2).append(a(80000000, (String)localObject1));
        ((SpannableStringBuilder)localObject2).append(")");
        paramaith.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if ((TextUtils.isEmpty(paramaith.jdField_a_of_type_JavaLangString)) || (!bgjw.b(paramaith.jdField_a_of_type_JavaLangString))) {
          break label435;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources();
        localObject2 = ((Resources)localObject1).getDrawable(2130841741);
        ((Drawable)localObject2).setBounds(0, 0, afur.a(15.0F, (Resources)localObject1), afur.a(15.0F, (Resources)localObject1));
        ThemeUtil.setThemeFilter((Drawable)localObject2, ThemeUtil.curThemeId);
        paramaith.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
        label261:
        localStringBuilder.append(paramaith.jdField_b_of_type_AndroidWidgetTextView.getText());
      }
      switch (this.jdField_d_of_type_Int)
      {
      case 1: 
      default: 
        localObject1 = this.jdField_a_of_type_Aobu;
        if (paramaith.jdField_a_of_type_Boolean)
        {
          j = 1;
          label319:
          if (!paramaith.jdField_a_of_type_Boolean) {
            break label485;
          }
          paramrecord = paramaith.jdField_a_of_type_JavaLangString;
          label331:
          localObject1 = ((aobu)localObject1).a(j, paramrecord);
          paramrecord = (AccountSearchPb.record)localObject1;
          if (localObject1 == null)
          {
            localObject1 = bgmo.a();
            if (!this.jdField_a_of_type_Aobu.a())
            {
              localObject2 = this.jdField_a_of_type_Aobu;
              if (!paramaith.jdField_a_of_type_Boolean) {
                break label493;
              }
            }
          }
        }
        break;
      }
    }
    label426:
    label435:
    label485:
    label493:
    for (paramrecord = paramaith.jdField_a_of_type_JavaLangString;; paramrecord = paramaith.jdField_b_of_type_JavaLangString)
    {
      j = k;
      if (paramaith.jdField_a_of_type_Boolean) {
        j = 1;
      }
      ((aobu)localObject2).a(paramrecord, j, true, (byte)1);
      paramrecord = (AccountSearchPb.record)localObject1;
      paramaith.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramrecord);
      return localStringBuilder.toString();
      bool = false;
      break;
      localObject1 = paramaith.jdField_b_of_type_JavaLangString;
      break label148;
      paramaith.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label261;
      localStringBuilder.append(a(paramaith, paramrecord));
      break label304;
      localStringBuilder.append(b(paramaith, paramrecord));
      break label304;
      j = 11;
      break label319;
      paramrecord = paramaith.jdField_b_of_type_JavaLangString;
      break label331;
    }
  }
  
  protected void a()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("isGetMore = ").append(this.jdField_b_of_type_Boolean).append(" mListData is null = ");
      if (this.jdField_a_of_type_JavaUtilList != null) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ClassificationSearchFragment", 2, bool);
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList != null)) {
        break;
      }
      g();
      return;
    }
    if (this.jdField_a_of_type_Aism == null)
    {
      this.jdField_a_of_type_Aism = new aism(this, null);
      this.jdField_a_of_type_Aism.a(this.jdField_a_of_type_JavaUtilList);
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.jdField_d_of_type_Int == 0)
      {
        localObject1 = anni.a(2131700741);
        label141:
        ((View)localObject2).setContentDescription((String)localObject1 + anni.a(2131700743));
        this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aism);
        this.a = this.jdField_a_of_type_Aism;
      }
    }
    else
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label371;
      }
      this.jdField_a_of_type_Aism.a().addAll(this.jdField_a_of_type_JavaUtilList);
    }
    int j;
    for (;;)
    {
      this.jdField_a_of_type_Aism.notifyDataSetChanged();
      if (this.c)
      {
        this.c = false;
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      }
      if ((this.jdField_d_of_type_Int != 2) || (this.jdField_a_of_type_JavaUtilList == null)) {
        break;
      }
      localObject1 = new StringBuilder();
      localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append(String.valueOf(((AccountSearchPb.record)((Iterator)localObject2).next()).uin.get())).append("#");
        j += 1;
      }
      localObject1 = anni.a(2131700747);
      break label141;
      label371:
      this.jdField_a_of_type_Aism.a(this.jdField_a_of_type_JavaUtilList);
    }
    Object localObject2 = txm.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    txm.a().a((String)localObject2, this.jdField_a_of_type_JavaLangString, 3, true, j, ((StringBuilder)localObject1).toString());
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    b(3);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean) {
      if (UniteSearchActivity.jdField_d_of_type_Int == 12) {
        this.jdField_a_of_type_Aiso.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 1);
      }
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Int == 2)
      {
        paramString = getActivity();
        if ((paramString != null) && ((paramString instanceof SearchBaseActivity)))
        {
          int j = ((SearchBaseActivity)paramString).a();
          int k = this.jdField_a_of_type_Aiso.a();
          oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "" + (k + 1), aitb.a(j), this.jdField_a_of_type_JavaLangString, "", false);
        }
      }
      return;
      if (h == ClassificationSearchActivity.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Aiso.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 2);
      }
      else
      {
        this.jdField_a_of_type_Aiso.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 0);
        continue;
        if (bgnt.d(BaseApplicationImpl.getContext()))
        {
          i();
          this.jdField_a_of_type_JavaLangString = paramString;
          this.jdField_a_of_type_Aiso.c();
          if (UniteSearchActivity.jdField_d_of_type_Int == 12) {
            this.jdField_a_of_type_Aiso.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 1);
          }
          for (;;)
          {
            this.c = true;
            break;
            if (h == ClassificationSearchActivity.jdField_a_of_type_Int) {
              this.jdField_a_of_type_Aiso.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 2);
            } else {
              this.jdField_a_of_type_Aiso.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 0);
            }
          }
        }
        QQToast.a(BaseApplicationImpl.getContext(), 2131693948, 0).b(b());
        b(4);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  protected boolean a(ArrayList<aitt> paramArrayList)
  {
    aitt localaitt = (aitt)paramArrayList.get(0);
    if (b(paramArrayList))
    {
      this.jdField_d_of_type_Boolean = true;
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ClassificationSearchFragment.1(this, localaitt));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClassificationSearchFragment", 2, "is no more page  = " + localaitt.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_JavaUtilList = localaitt.jdField_b_of_type_JavaUtilList;
    if (!this.jdField_b_of_type_Boolean) {
      e();
    }
    a(paramArrayList);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      b(2);
      a(this.jdField_a_of_type_JavaLangString, true);
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Int == 2) {
      b(0);
    }
  }
  
  @TargetApi(9)
  public void d()
  {
    super.d();
    Object localObject;
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_d_of_type_Int == 2))
    {
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559631, null);
        localObject = (GridView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377035);
        if (Build.VERSION.SDK_INT > 8) {
          ((GridView)localObject).setOverScrollMode(2);
        }
        ((GridView)localObject).setNumColumns(4);
        ((GridView)localObject).setStretchMode(2);
        ((GridView)localObject).setVerticalSpacing(afur.a(20.0F, getResources()));
        ((GridView)localObject).setAdapter(this.jdField_a_of_type_Aisj);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      if ((this.jdField_a_of_type_Aisj == null) || (this.jdField_a_of_type_Aisj.getCount() <= 0)) {
        break label241;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      localObject = this.jdField_a_of_type_Aisj.a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label221;
      }
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377039)).setText(getString(2131694646));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Aisj != null) && (this.jdField_a_of_type_Aisj.a() != null) && (!aisj.a(this.jdField_a_of_type_Aisj))) {
        this.jdField_a_of_type_Aisj.a(false);
      }
      return;
      label221:
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377039)).setText((CharSequence)localObject);
      continue;
      label241:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject2;
    AccountSearchPb.record localrecord;
    String str;
    Object localObject3;
    if (localObject1 != null)
    {
      if (!(localObject1 instanceof aith)) {
        break label498;
      }
      localObject2 = (aith)localObject1;
      a(((aith)localObject2).jdField_b_of_type_Int, ((aith)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record, 2);
      int j = ((aith)localObject2).c;
      int k = ((aith)localObject2).jdField_b_of_type_Int;
      int m = ((aith)localObject2).c;
      if (((aith)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin == null) {
        break label373;
      }
      localObject1 = ((aith)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "";
      bbup.a(k, 0, m, false, (String)localObject1, this.jdField_a_of_type_JavaLangString, UniteSearchActivity.jdField_d_of_type_Int);
      if (((aith)localObject2).jdField_b_of_type_Int == 80000002)
      {
        localrecord = ((aith)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
        localObject1 = getActivity();
        if ((localObject1 != null) && ((localObject1 instanceof ClassificationSearchActivity)))
        {
          str = aitb.a(((SearchBaseActivity)localObject1).a());
          localObject1 = paramView.getTag(2131370498);
          if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
            ((aith)localObject2).c = (((Integer)localObject1).intValue() + 1);
          }
          localObject3 = txm.a();
          if (localrecord.uin == null) {
            break label379;
          }
          localObject1 = localrecord.uin.get() + "";
          label247:
          ((txm)localObject3).a(3, (String)localObject1, j, UniteSearchActivity.jdField_d_of_type_Int);
          if (UniteSearchActivity.jdField_d_of_type_Int != 12) {
            break label393;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject2 = ((aith)localObject2).c + "";
          if (localrecord.uin == null) {
            break label386;
          }
          localObject1 = localrecord.uin.get() + "";
          label334:
          bcst.b((QQAppInterface)localObject3, "CliOper", "", "", "0X800658B", "0X800658B", 0, 1, 0, (String)localObject2, str, (String)localObject1, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
    label386:
    label393:
    label812:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label373:
      localObject1 = null;
      break;
      label379:
      localObject1 = "";
      break label247;
      localObject1 = "";
      break label334;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localrecord.uin != null) {}
      for (localObject1 = localrecord.uin.get() + "";; localObject1 = "")
      {
        oat.a((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005D22", "0X8005D22", 0, 0, ((aith)localObject2).c + "", str, this.jdField_a_of_type_JavaLangString, "", false);
        break;
      }
      label498:
      if ((localObject1 instanceof aisl))
      {
        if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
          if (bgnt.d(BaseApplicationImpl.getContext()))
          {
            b(1);
          }
          else
          {
            QQToast.a(BaseApplicationImpl.getContext(), 2131693948, 0).b(b());
            b(4);
          }
        }
      }
      else if ((localObject1 instanceof aitg))
      {
        localObject1 = (aitg)localObject1;
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((aitg)localObject1).jdField_a_of_type_JavaLangString);
        if (UniteSearchActivity.jdField_d_of_type_Int == 1) {
          ((Intent)localObject2).putExtra("articalChannelId", 10);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          if (UniteSearchActivity.jdField_d_of_type_Int != 12) {
            break label812;
          }
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658C", "0X800658C", 0, 0, "" + ((aitg)localObject1).jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + ((aitg)localObject1).jdField_a_of_type_Long);
          break;
          if (UniteSearchActivity.jdField_d_of_type_Int == 2) {
            ((Intent)localObject2).putExtra("articalChannelId", 11);
          } else if (this.i == 14) {
            ((Intent)localObject2).putExtra("articalChannelId", 14);
          } else if (this.i == 13) {
            ((Intent)localObject2).putExtra("articalChannelId", 12);
          } else if (this.i == 15) {
            ((Intent)localObject2).putExtra("articalChannelId", 13);
          }
        }
        oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D97", "0X8005D97", 0, 0, "" + ((aitg)localObject1).jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + ((aitg)localObject1).jdField_a_of_type_Long, false);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(2131559248, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setFocusable(true);
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aisj != null) {
      this.jdField_a_of_type_Aisj.a();
    }
    txm.a().b();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (jdField_a_of_type_Aitt != null)
    {
      int j;
      if (!jdField_a_of_type_Aitt.jdField_a_of_type_Boolean)
      {
        j = 1;
        b(j);
        this.jdField_a_of_type_JavaUtilList.addAll(jdField_a_of_type_Aitt.jdField_b_of_type_JavaUtilList);
        this.jdField_a_of_type_Aiso.a(jdField_a_of_type_Aitt.jdField_b_of_type_Int);
        if (ViewFactory.a(jdField_a_of_type_Aitt.jdField_a_of_type_Int) != 2131689656) {
          break label192;
        }
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378776)).setText(tyg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()));
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_JavaUtilMap.size() == 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          paramView = new ArrayList();
          paramView.add(jdField_a_of_type_Aitt);
          a(paramView);
        }
        jdField_a_of_type_Aitt = null;
        a();
        this.g = c();
        if ((this.jdField_d_of_type_Int == 2) && (this.jdField_a_of_type_Aisj == null)) {
          this.jdField_a_of_type_Aisj = new aisj(this);
        }
        return;
        j = 0;
        break;
        label192:
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378776)).setText(ViewFactory.a(jdField_a_of_type_Aitt.jdField_a_of_type_Int));
      }
    }
    if ((h == ClassificationSearchActivity.jdField_a_of_type_Int) || (h == ClassificationSearchActivity.jdField_b_of_type_Int)) {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378776)).setText(ViewFactory.a(80000003));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassificationSearchFragment", 2, "searchResult is null");
      }
      g();
      break;
      if ((h == ClassificationSearchActivity.c) || (h == ClassificationSearchActivity.e)) {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378776)).setText(ViewFactory.a(80000002));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment
 * JD-Core Version:    0.7.0.1
 */