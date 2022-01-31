package com.tencent.mobileqq.activity.contact.addcontact;

import aepi;
import ahgy;
import ahha;
import ahhb;
import ahhd;
import ahhx;
import ahic;
import ahid;
import ahip;
import alud;
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
import ayvm;
import azqs;
import bdbb;
import bdeu;
import bdhj;
import bdin;
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
import com.tencent.widget.GridView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nrt;
import swe;
import swy;

public class ClassificationSearchFragment
  extends SearchBaseFragment
{
  private static ahip jdField_a_of_type_Ahip;
  private static int h;
  public int a;
  private ahgy jdField_a_of_type_Ahgy;
  private ahhb jdField_a_of_type_Ahhb;
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
  
  public static ClassificationSearchFragment a(ahip paramahip)
  {
    jdField_a_of_type_Ahip = paramahip;
    return new ClassificationSearchFragment();
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Ahhb != null) {
      this.jdField_a_of_type_Ahhb.notifyDataSetChanged();
    }
  }
  
  private boolean b(ArrayList<ahip> paramArrayList)
  {
    if ((!this.jdField_b_of_type_Boolean) && (paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = ((ahip)paramArrayList.get(0)).jdField_b_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        a(((ahip)paramArrayList.get(0)).jdField_a_of_type_Int, (AccountSearchPb.record)localObject);
        return true;
      }
    }
    return false;
  }
  
  private String c(ahid paramahid, AccountSearchPb.record paramrecord)
  {
    int k = 11;
    StringBuilder localStringBuilder = new StringBuilder();
    paramahid.jdField_a_of_type_JavaLangString = (paramrecord.uin.get() + "");
    paramahid.jdField_b_of_type_JavaLangString = paramrecord.mobile.get();
    boolean bool;
    Object localObject2;
    Object localObject1;
    label148:
    label304:
    int j;
    if (paramrecord.uin.get() != 0L)
    {
      bool = true;
      paramahid.jdField_a_of_type_Boolean = bool;
      paramahid.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramahid.jdField_b_of_type_Int, paramrecord.name.get()));
      localStringBuilder.append(paramahid.jdField_a_of_type_AndroidWidgetTextView.getText());
      if (paramahid.jdField_b_of_type_Int == 80000000)
      {
        localObject2 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject2).append("(");
        if (!paramahid.jdField_a_of_type_Boolean) {
          break label426;
        }
        localObject1 = paramahid.jdField_a_of_type_JavaLangString;
        ((SpannableStringBuilder)localObject2).append(a(80000000, (String)localObject1));
        ((SpannableStringBuilder)localObject2).append(")");
        paramahid.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if ((TextUtils.isEmpty(paramahid.jdField_a_of_type_JavaLangString)) || (!bdeu.b(paramahid.jdField_a_of_type_JavaLangString))) {
          break label435;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources();
        localObject2 = ((Resources)localObject1).getDrawable(2130841432);
        ((Drawable)localObject2).setBounds(0, 0, aepi.a(15.0F, (Resources)localObject1), aepi.a(15.0F, (Resources)localObject1));
        ThemeUtil.setThemeFilter((Drawable)localObject2, ThemeUtil.curThemeId);
        paramahid.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
        label261:
        localStringBuilder.append(paramahid.jdField_b_of_type_AndroidWidgetTextView.getText());
      }
      switch (this.jdField_d_of_type_Int)
      {
      case 1: 
      default: 
        localObject1 = this.jdField_a_of_type_Bdbb;
        if (paramahid.jdField_a_of_type_Boolean)
        {
          j = 1;
          label319:
          if (!paramahid.jdField_a_of_type_Boolean) {
            break label485;
          }
          paramrecord = paramahid.jdField_a_of_type_JavaLangString;
          label331:
          localObject1 = ((bdbb)localObject1).a(j, paramrecord);
          paramrecord = (AccountSearchPb.record)localObject1;
          if (localObject1 == null)
          {
            localObject1 = bdhj.a();
            if (!this.jdField_a_of_type_Bdbb.a())
            {
              localObject2 = this.jdField_a_of_type_Bdbb;
              if (!paramahid.jdField_a_of_type_Boolean) {
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
    for (paramrecord = paramahid.jdField_a_of_type_JavaLangString;; paramrecord = paramahid.jdField_b_of_type_JavaLangString)
    {
      j = k;
      if (paramahid.jdField_a_of_type_Boolean) {
        j = 1;
      }
      ((bdbb)localObject2).a(paramrecord, j, true, (byte)1);
      paramrecord = (AccountSearchPb.record)localObject1;
      paramahid.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramrecord);
      return localStringBuilder.toString();
      bool = false;
      break;
      localObject1 = paramahid.jdField_b_of_type_JavaLangString;
      break label148;
      paramahid.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label261;
      localStringBuilder.append(a(paramahid, paramrecord));
      break label304;
      localStringBuilder.append(b(paramahid, paramrecord));
      break label304;
      j = 11;
      break label319;
      paramrecord = paramahid.jdField_b_of_type_JavaLangString;
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
    if (this.jdField_a_of_type_Ahhb == null)
    {
      this.jdField_a_of_type_Ahhb = new ahhb(this, null);
      this.jdField_a_of_type_Ahhb.a(this.jdField_a_of_type_JavaUtilList);
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.jdField_d_of_type_Int == 0)
      {
        localObject1 = alud.a(2131702321);
        label141:
        ((View)localObject2).setContentDescription((String)localObject1 + alud.a(2131702323));
        this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahhb);
        this.a = this.jdField_a_of_type_Ahhb;
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
      this.jdField_a_of_type_Ahhb.a().addAll(this.jdField_a_of_type_JavaUtilList);
    }
    int j;
    for (;;)
    {
      this.jdField_a_of_type_Ahhb.notifyDataSetChanged();
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
      localObject1 = alud.a(2131702327);
      break label141;
      label371:
      this.jdField_a_of_type_Ahhb.a(this.jdField_a_of_type_JavaUtilList);
    }
    Object localObject2 = swe.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    swe.a().a((String)localObject2, this.jdField_a_of_type_JavaLangString, 3, true, j, ((StringBuilder)localObject1).toString());
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
        this.jdField_a_of_type_Ahhd.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 1);
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
          int k = this.jdField_a_of_type_Ahhd.a();
          nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "" + (k + 1), ahhx.a(j), this.jdField_a_of_type_JavaLangString, "", false);
        }
      }
      return;
      if (h == ClassificationSearchActivity.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Ahhd.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 2);
      }
      else
      {
        this.jdField_a_of_type_Ahhd.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 0);
        continue;
        if (bdin.d(BaseApplicationImpl.getContext()))
        {
          h();
          this.jdField_a_of_type_JavaLangString = paramString;
          this.jdField_a_of_type_Ahhd.c();
          if (UniteSearchActivity.jdField_d_of_type_Int == 12) {
            this.jdField_a_of_type_Ahhd.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 1);
          }
          for (;;)
          {
            this.c = true;
            break;
            if (h == ClassificationSearchActivity.jdField_a_of_type_Int) {
              this.jdField_a_of_type_Ahhd.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 2);
            } else {
              this.jdField_a_of_type_Ahhd.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 0);
            }
          }
        }
        QQToast.a(BaseApplicationImpl.getContext(), 2131694768, 0).b(b());
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
  
  protected boolean a(ArrayList<ahip> paramArrayList)
  {
    ahip localahip = (ahip)paramArrayList.get(0);
    if (b(paramArrayList))
    {
      this.jdField_d_of_type_Boolean = true;
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ClassificationSearchFragment.1(this, localahip));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClassificationSearchFragment", 2, "is no more page  = " + localahip.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_JavaUtilList = localahip.jdField_b_of_type_JavaUtilList;
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
        this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559499, null);
        localObject = (GridView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376259);
        if (Build.VERSION.SDK_INT > 8) {
          ((GridView)localObject).setOverScrollMode(2);
        }
        ((GridView)localObject).setNumColumns(4);
        ((GridView)localObject).setStretchMode(2);
        ((GridView)localObject).setVerticalSpacing(aepi.a(20.0F, getResources()));
        ((GridView)localObject).setAdapter(this.jdField_a_of_type_Ahgy);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      if ((this.jdField_a_of_type_Ahgy == null) || (this.jdField_a_of_type_Ahgy.getCount() <= 0)) {
        break label241;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      localObject = this.jdField_a_of_type_Ahgy.a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label221;
      }
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376263)).setText(getString(2131695761));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Ahgy != null) && (this.jdField_a_of_type_Ahgy.a() != null) && (!ahgy.a(this.jdField_a_of_type_Ahgy))) {
        this.jdField_a_of_type_Ahgy.a(false);
      }
      return;
      label221:
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376263)).setText((CharSequence)localObject);
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
      if (!(localObject1 instanceof ahid)) {
        break label475;
      }
      localObject2 = (ahid)localObject1;
      a(((ahid)localObject2).jdField_b_of_type_Int, ((ahid)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
      int j = ((ahid)localObject2).c;
      int k = ((ahid)localObject2).jdField_b_of_type_Int;
      int m = ((ahid)localObject2).c;
      if (((ahid)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin == null) {
        break label357;
      }
      localObject1 = ((ahid)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "";
      ayvm.a(k, 0, m, false, (String)localObject1, this.jdField_a_of_type_JavaLangString, UniteSearchActivity.jdField_d_of_type_Int);
      if (((ahid)localObject2).jdField_b_of_type_Int == 80000002)
      {
        localrecord = ((ahid)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
        localObject1 = getActivity();
        if ((localObject1 != null) && ((localObject1 instanceof ClassificationSearchActivity)))
        {
          localObject1 = ahhx.a(((SearchBaseActivity)localObject1).a());
          paramView = paramView.getTag(2131370055);
          if ((paramView != null) && ((paramView instanceof Integer))) {
            ((ahid)localObject2).c = (((Integer)paramView).intValue() + 1);
          }
          localObject3 = swe.a();
          if (localrecord.uin == null) {
            break label363;
          }
          paramView = localrecord.uin.get() + "";
          label241:
          ((swe)localObject3).a(3, paramView, j, UniteSearchActivity.jdField_d_of_type_Int);
          if (UniteSearchActivity.jdField_d_of_type_Int != 12) {
            break label375;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject2 = ((ahid)localObject2).c + "";
          if (localrecord.uin == null) {
            break label369;
          }
          paramView = localrecord.uin.get() + "";
          label326:
          azqs.b((QQAppInterface)localObject3, "CliOper", "", "", "0X800658B", "0X800658B", 0, 1, 0, (String)localObject2, (String)localObject1, paramView, this.jdField_a_of_type_JavaLangString);
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
          nrt.a((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", paramView, "0X8005D22", "0X8005D22", 0, 0, ((ahid)localObject2).c + "", (String)localObject1, this.jdField_a_of_type_JavaLangString, "", false);
          return;
        }
        if (!(localObject1 instanceof ahha)) {
          break label538;
        }
      } while ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 4));
      if (bdin.d(BaseApplicationImpl.getContext()))
      {
        b(1);
        return;
      }
      QQToast.a(BaseApplicationImpl.getContext(), 2131694768, 0).b(b());
      b(4);
      return;
    } while (!(localObject1 instanceof ahic));
    label475:
    paramView = (ahic)localObject1;
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
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658C", "0X800658C", 0, 0, "" + paramView.jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + paramView.jdField_a_of_type_Long);
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
    nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D97", "0X8005D97", 0, 0, "" + paramView.jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + paramView.jdField_a_of_type_Long, false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(2131559169, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setFocusable(true);
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Ahgy != null) {
      this.jdField_a_of_type_Ahgy.a();
    }
    swe.a().b();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (jdField_a_of_type_Ahip != null)
    {
      int j;
      if (!jdField_a_of_type_Ahip.jdField_a_of_type_Boolean)
      {
        j = 1;
        b(j);
        this.jdField_a_of_type_JavaUtilList.addAll(jdField_a_of_type_Ahip.jdField_b_of_type_JavaUtilList);
        this.jdField_a_of_type_Ahhd.a(jdField_a_of_type_Ahip.jdField_b_of_type_Int);
        if (ViewFactory.a(jdField_a_of_type_Ahip.jdField_a_of_type_Int) != 2131689767) {
          break label192;
        }
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377938)).setText(swy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()));
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_JavaUtilMap.size() == 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          paramView = new ArrayList();
          paramView.add(jdField_a_of_type_Ahip);
          a(paramView);
        }
        jdField_a_of_type_Ahip = null;
        a();
        this.g = c();
        if ((this.jdField_d_of_type_Int == 2) && (this.jdField_a_of_type_Ahgy == null)) {
          this.jdField_a_of_type_Ahgy = new ahgy(this);
        }
        return;
        j = 0;
        break;
        label192:
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377938)).setText(ViewFactory.a(jdField_a_of_type_Ahip.jdField_a_of_type_Int));
      }
    }
    if ((h == ClassificationSearchActivity.jdField_a_of_type_Int) || (h == ClassificationSearchActivity.jdField_b_of_type_Int)) {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377938)).setText(ViewFactory.a(80000003));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassificationSearchFragment", 2, "searchResult is null");
      }
      g();
      break;
      if ((h == ClassificationSearchActivity.c) || (h == ClassificationSearchActivity.e)) {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377938)).setText(ViewFactory.a(80000002));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment
 * JD-Core Version:    0.7.0.1
 */