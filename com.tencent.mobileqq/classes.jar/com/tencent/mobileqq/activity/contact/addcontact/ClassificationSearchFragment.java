package com.tencent.mobileqq.activity.contact.addcontact;

import actj;
import affe;
import affg;
import affh;
import affj;
import afgd;
import afgi;
import afgj;
import afgv;
import ajya;
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
import awwa;
import axqy;
import baxy;
import bbbr;
import bbef;
import bbfj;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nol;
import sek;
import sfe;

public class ClassificationSearchFragment
  extends SearchBaseFragment
{
  private static afgv jdField_a_of_type_Afgv;
  private static int h;
  public int a;
  private affe jdField_a_of_type_Affe;
  private affh jdField_a_of_type_Affh;
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
  
  public static ClassificationSearchFragment a(afgv paramafgv)
  {
    jdField_a_of_type_Afgv = paramafgv;
    return new ClassificationSearchFragment();
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Affh != null) {
      this.jdField_a_of_type_Affh.notifyDataSetChanged();
    }
  }
  
  private boolean b(ArrayList<afgv> paramArrayList)
  {
    if ((!this.jdField_b_of_type_Boolean) && (paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = ((afgv)paramArrayList.get(0)).jdField_b_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        a(((afgv)paramArrayList.get(0)).jdField_a_of_type_Int, (AccountSearchPb.record)localObject);
        return true;
      }
    }
    return false;
  }
  
  private String c(afgj paramafgj, AccountSearchPb.record paramrecord)
  {
    int k = 11;
    StringBuilder localStringBuilder = new StringBuilder();
    paramafgj.jdField_a_of_type_JavaLangString = (paramrecord.uin.get() + "");
    paramafgj.jdField_b_of_type_JavaLangString = paramrecord.mobile.get();
    boolean bool;
    Object localObject2;
    Object localObject1;
    label148:
    label304:
    int j;
    if (paramrecord.uin.get() != 0L)
    {
      bool = true;
      paramafgj.jdField_a_of_type_Boolean = bool;
      paramafgj.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramafgj.jdField_b_of_type_Int, paramrecord.name.get()));
      localStringBuilder.append(paramafgj.jdField_a_of_type_AndroidWidgetTextView.getText());
      if (paramafgj.jdField_b_of_type_Int == 80000000)
      {
        localObject2 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject2).append("(");
        if (!paramafgj.jdField_a_of_type_Boolean) {
          break label426;
        }
        localObject1 = paramafgj.jdField_a_of_type_JavaLangString;
        ((SpannableStringBuilder)localObject2).append(a(80000000, (String)localObject1));
        ((SpannableStringBuilder)localObject2).append(")");
        paramafgj.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if ((TextUtils.isEmpty(paramafgj.jdField_a_of_type_JavaLangString)) || (!bbbr.b(paramafgj.jdField_a_of_type_JavaLangString))) {
          break label435;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources();
        localObject2 = ((Resources)localObject1).getDrawable(2130841310);
        ((Drawable)localObject2).setBounds(0, 0, actj.a(15.0F, (Resources)localObject1), actj.a(15.0F, (Resources)localObject1));
        ThemeUtil.setThemeFilter((Drawable)localObject2, ThemeUtil.curThemeId);
        paramafgj.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
        label261:
        localStringBuilder.append(paramafgj.jdField_b_of_type_AndroidWidgetTextView.getText());
      }
      switch (this.jdField_d_of_type_Int)
      {
      case 1: 
      default: 
        localObject1 = this.jdField_a_of_type_Baxy;
        if (paramafgj.jdField_a_of_type_Boolean)
        {
          j = 1;
          label319:
          if (!paramafgj.jdField_a_of_type_Boolean) {
            break label485;
          }
          paramrecord = paramafgj.jdField_a_of_type_JavaLangString;
          label331:
          localObject1 = ((baxy)localObject1).a(j, paramrecord);
          paramrecord = (AccountSearchPb.record)localObject1;
          if (localObject1 == null)
          {
            localObject1 = bbef.a();
            if (!this.jdField_a_of_type_Baxy.a())
            {
              localObject2 = this.jdField_a_of_type_Baxy;
              if (!paramafgj.jdField_a_of_type_Boolean) {
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
    for (paramrecord = paramafgj.jdField_a_of_type_JavaLangString;; paramrecord = paramafgj.jdField_b_of_type_JavaLangString)
    {
      j = k;
      if (paramafgj.jdField_a_of_type_Boolean) {
        j = 1;
      }
      ((baxy)localObject2).a(paramrecord, j, true, (byte)1);
      paramrecord = (AccountSearchPb.record)localObject1;
      paramafgj.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramrecord);
      return localStringBuilder.toString();
      bool = false;
      break;
      localObject1 = paramafgj.jdField_b_of_type_JavaLangString;
      break label148;
      paramafgj.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label261;
      localStringBuilder.append(a(paramafgj, paramrecord));
      break label304;
      localStringBuilder.append(b(paramafgj, paramrecord));
      break label304;
      j = 11;
      break label319;
      paramrecord = paramafgj.jdField_b_of_type_JavaLangString;
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
    if (this.jdField_a_of_type_Affh == null)
    {
      this.jdField_a_of_type_Affh = new affh(this, null);
      this.jdField_a_of_type_Affh.a(this.jdField_a_of_type_JavaUtilList);
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.jdField_d_of_type_Int == 0)
      {
        localObject1 = ajya.a(2131701937);
        label141:
        ((View)localObject2).setContentDescription((String)localObject1 + ajya.a(2131701939));
        this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Affh);
        this.a = this.jdField_a_of_type_Affh;
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
      this.jdField_a_of_type_Affh.a().addAll(this.jdField_a_of_type_JavaUtilList);
    }
    int j;
    for (;;)
    {
      this.jdField_a_of_type_Affh.notifyDataSetChanged();
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
      localObject1 = ajya.a(2131701943);
      break label141;
      label371:
      this.jdField_a_of_type_Affh.a(this.jdField_a_of_type_JavaUtilList);
    }
    Object localObject2 = sek.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    sek.a().a((String)localObject2, this.jdField_a_of_type_JavaLangString, 3, true, j, ((StringBuilder)localObject1).toString());
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
        this.jdField_a_of_type_Affj.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 1);
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
          int k = this.jdField_a_of_type_Affj.a();
          nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "" + (k + 1), afgd.a(j), this.jdField_a_of_type_JavaLangString, "", false);
        }
      }
      return;
      if (h == ClassificationSearchActivity.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Affj.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 2);
      }
      else
      {
        this.jdField_a_of_type_Affj.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 0);
        continue;
        if (bbfj.d(BaseApplicationImpl.getContext()))
        {
          h();
          this.jdField_a_of_type_JavaLangString = paramString;
          this.jdField_a_of_type_Affj.c();
          if (UniteSearchActivity.jdField_d_of_type_Int == 12) {
            this.jdField_a_of_type_Affj.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 1);
          }
          for (;;)
          {
            this.c = true;
            break;
            if (h == ClassificationSearchActivity.jdField_a_of_type_Int) {
              this.jdField_a_of_type_Affj.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 2);
            } else {
              this.jdField_a_of_type_Affj.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 0);
            }
          }
        }
        bcql.a(BaseApplicationImpl.getContext(), 2131694610, 0).b(b());
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
  
  protected boolean a(ArrayList<afgv> paramArrayList)
  {
    afgv localafgv = (afgv)paramArrayList.get(0);
    if (b(paramArrayList))
    {
      this.jdField_d_of_type_Boolean = true;
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ClassificationSearchFragment.1(this, localafgv));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClassificationSearchFragment", 2, "is no more page  = " + localafgv.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_JavaUtilList = localafgv.jdField_b_of_type_JavaUtilList;
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
        this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559448, null);
        localObject = (GridView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375711);
        if (Build.VERSION.SDK_INT > 8) {
          ((GridView)localObject).setOverScrollMode(2);
        }
        ((GridView)localObject).setNumColumns(4);
        ((GridView)localObject).setStretchMode(2);
        ((GridView)localObject).setVerticalSpacing(actj.a(20.0F, getResources()));
        ((GridView)localObject).setAdapter(this.jdField_a_of_type_Affe);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      if ((this.jdField_a_of_type_Affe == null) || (this.jdField_a_of_type_Affe.getCount() <= 0)) {
        break label241;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      localObject = this.jdField_a_of_type_Affe.a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label221;
      }
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375715)).setText(getString(2131695601));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Affe != null) && (this.jdField_a_of_type_Affe.a() != null) && (!affe.a(this.jdField_a_of_type_Affe))) {
        this.jdField_a_of_type_Affe.a(false);
      }
      return;
      label221:
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375715)).setText((CharSequence)localObject);
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
    Object localObject3;
    if (localObject1 != null)
    {
      if (!(localObject1 instanceof afgj)) {
        break label475;
      }
      localObject2 = (afgj)localObject1;
      a(((afgj)localObject2).jdField_b_of_type_Int, ((afgj)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
      int j = ((afgj)localObject2).c;
      int k = ((afgj)localObject2).jdField_b_of_type_Int;
      int m = ((afgj)localObject2).c;
      if (((afgj)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin == null) {
        break label357;
      }
      localObject1 = ((afgj)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "";
      awwa.a(k, 0, m, false, (String)localObject1, this.jdField_a_of_type_JavaLangString, UniteSearchActivity.jdField_d_of_type_Int);
      if (((afgj)localObject2).jdField_b_of_type_Int == 80000002)
      {
        localrecord = ((afgj)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
        localObject1 = getActivity();
        if ((localObject1 != null) && ((localObject1 instanceof ClassificationSearchActivity)))
        {
          localObject1 = afgd.a(((SearchBaseActivity)localObject1).a());
          paramView = paramView.getTag(2131369772);
          if ((paramView != null) && ((paramView instanceof Integer))) {
            ((afgj)localObject2).c = (((Integer)paramView).intValue() + 1);
          }
          localObject3 = sek.a();
          if (localrecord.uin == null) {
            break label363;
          }
          paramView = localrecord.uin.get() + "";
          label241:
          ((sek)localObject3).a(3, paramView, j, UniteSearchActivity.jdField_d_of_type_Int);
          if (UniteSearchActivity.jdField_d_of_type_Int != 12) {
            break label375;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject2 = ((afgj)localObject2).c + "";
          if (localrecord.uin == null) {
            break label369;
          }
          paramView = localrecord.uin.get() + "";
          label326:
          axqy.b((QQAppInterface)localObject3, "CliOper", "", "", "0X800658B", "0X800658B", 0, 1, 0, (String)localObject2, (String)localObject1, paramView, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
    label357:
    label363:
    label369:
    label375:
    do
    {
      do
      {
        return;
        localObject1 = null;
        break;
        paramView = "";
        break label241;
        paramView = "";
        break label326;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localrecord.uin != null) {}
        for (paramView = localrecord.uin.get() + "";; paramView = "")
        {
          nol.a((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", paramView, "0X8005D22", "0X8005D22", 0, 0, ((afgj)localObject2).c + "", (String)localObject1, this.jdField_a_of_type_JavaLangString, "", false);
          return;
        }
        if (!(localObject1 instanceof affg)) {
          break label538;
        }
      } while ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 4));
      if (bbfj.d(BaseApplicationImpl.getContext()))
      {
        b(1);
        return;
      }
      bcql.a(BaseApplicationImpl.getContext(), 2131694610, 0).b(b());
      b(4);
      return;
    } while (!(localObject1 instanceof afgi));
    label475:
    paramView = (afgi)localObject1;
    label538:
    localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", paramView.jdField_a_of_type_JavaLangString);
    if (UniteSearchActivity.jdField_d_of_type_Int == 1) {
      ((Intent)localObject1).putExtra("articalChannelId", 10);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
      if (UniteSearchActivity.jdField_d_of_type_Int != 12) {
        break;
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658C", "0X800658C", 0, 0, "" + paramView.jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + paramView.jdField_a_of_type_Long);
      return;
      if (UniteSearchActivity.jdField_d_of_type_Int == 2) {
        ((Intent)localObject1).putExtra("articalChannelId", 11);
      } else if (this.i == 14) {
        ((Intent)localObject1).putExtra("articalChannelId", 14);
      } else if (this.i == 13) {
        ((Intent)localObject1).putExtra("articalChannelId", 12);
      } else if (this.i == 15) {
        ((Intent)localObject1).putExtra("articalChannelId", 13);
      }
    }
    nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D97", "0X8005D97", 0, 0, "" + paramView.jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + paramView.jdField_a_of_type_Long, false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(2131559127, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setFocusable(true);
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Affe != null) {
      this.jdField_a_of_type_Affe.a();
    }
    sek.a().b();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (jdField_a_of_type_Afgv != null)
    {
      int j;
      if (!jdField_a_of_type_Afgv.jdField_a_of_type_Boolean)
      {
        j = 1;
        b(j);
        this.jdField_a_of_type_JavaUtilList.addAll(jdField_a_of_type_Afgv.jdField_b_of_type_JavaUtilList);
        this.jdField_a_of_type_Affj.a(jdField_a_of_type_Afgv.jdField_b_of_type_Int);
        if (ViewFactory.a(jdField_a_of_type_Afgv.jdField_a_of_type_Int) != 2131689766) {
          break label192;
        }
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377350)).setText(sfe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()));
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_JavaUtilMap.size() == 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          paramView = new ArrayList();
          paramView.add(jdField_a_of_type_Afgv);
          a(paramView);
        }
        jdField_a_of_type_Afgv = null;
        a();
        this.g = c();
        if ((this.jdField_d_of_type_Int == 2) && (this.jdField_a_of_type_Affe == null)) {
          this.jdField_a_of_type_Affe = new affe(this);
        }
        return;
        j = 0;
        break;
        label192:
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377350)).setText(ViewFactory.a(jdField_a_of_type_Afgv.jdField_a_of_type_Int));
      }
    }
    if ((h == ClassificationSearchActivity.jdField_a_of_type_Int) || (h == ClassificationSearchActivity.jdField_b_of_type_Int)) {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377350)).setText(ViewFactory.a(80000003));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassificationSearchFragment", 2, "searchResult is null");
      }
      g();
      break;
      if ((h == ClassificationSearchActivity.c) || (h == ClassificationSearchActivity.e)) {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377350)).setText(ViewFactory.a(80000002));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment
 * JD-Core Version:    0.7.0.1
 */