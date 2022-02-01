package com.tencent.mobileqq.activity.contact.addcontact;

import aitb;
import aitd;
import aite;
import aitg;
import aits;
import aitx;
import aity;
import aiuk;
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
import anvx;
import bcnc;
import bdla;
import bhbx;
import bheg;
import bhnz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
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
import olh;
import usa;
import usu;

public class ClassificationSearchFragment
  extends SearchBaseFragment
{
  private static aiuk jdField_a_of_type_Aiuk;
  private static int h;
  public int a;
  private aitb jdField_a_of_type_Aitb;
  private aite jdField_a_of_type_Aite;
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
  
  public static ClassificationSearchFragment a(aiuk paramaiuk)
  {
    jdField_a_of_type_Aiuk = paramaiuk;
    return new ClassificationSearchFragment();
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Aite != null) {
      this.jdField_a_of_type_Aite.notifyDataSetChanged();
    }
  }
  
  private boolean b(ArrayList<aiuk> paramArrayList)
  {
    if ((!this.jdField_b_of_type_Boolean) && (paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = ((aiuk)paramArrayList.get(0)).jdField_b_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        a(((aiuk)paramArrayList.get(0)).jdField_a_of_type_Int, (AccountSearchPb.record)localObject, 2);
        return true;
      }
    }
    return false;
  }
  
  private String c(aity paramaity, AccountSearchPb.record paramrecord)
  {
    int k = 11;
    StringBuilder localStringBuilder = new StringBuilder();
    paramaity.jdField_a_of_type_JavaLangString = (paramrecord.uin.get() + "");
    paramaity.jdField_b_of_type_JavaLangString = paramrecord.mobile.get();
    boolean bool;
    Object localObject2;
    Object localObject1;
    label148:
    int j;
    if (paramrecord.uin.get() != 0L)
    {
      bool = true;
      paramaity.jdField_a_of_type_Boolean = bool;
      paramaity.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramaity.jdField_b_of_type_Int, paramrecord.name.get()));
      localStringBuilder.append(paramaity.jdField_a_of_type_AndroidWidgetTextView.getText());
      if (paramaity.jdField_b_of_type_Int == 80000000)
      {
        localObject2 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject2).append("(");
        if (!paramaity.jdField_a_of_type_Boolean) {
          break label490;
        }
        localObject1 = paramaity.jdField_a_of_type_JavaLangString;
        ((SpannableStringBuilder)localObject2).append(a(80000000, (String)localObject1));
        ((SpannableStringBuilder)localObject2).append(")");
        paramaity.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if ((TextUtils.isEmpty(paramaity.jdField_a_of_type_JavaLangString)) || (!bhbx.b(paramaity.jdField_a_of_type_JavaLangString))) {
          break label499;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources();
        Drawable localDrawable = ((Resources)localObject1).getDrawable(2130841803);
        localDrawable.setBounds(0, 0, AIOUtils.dp2px(15.0F, (Resources)localObject1), AIOUtils.dp2px(15.0F, (Resources)localObject1));
        ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
        paramaity.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, localDrawable, null);
        label261:
        j = paramrecord.uint32_richflag1_59.get();
        int m = paramrecord.uint32_richflag4_409.get();
        bhnz.a("0X800B238", j, m);
        localObject1 = bhnz.a(j, m, (CharSequence)localObject2, paramaity.jdField_a_of_type_JavaLangString);
        paramaity.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        bhnz.a(paramaity.jdField_b_of_type_AndroidWidgetTextView, j, m, 2131167107, 17);
        localStringBuilder.append(paramaity.jdField_b_of_type_AndroidWidgetTextView.getText());
      }
      switch (this.jdField_d_of_type_Int)
      {
      case 1: 
      default: 
        label368:
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
        if (paramaity.jdField_a_of_type_Boolean)
        {
          j = 1;
          label383:
          if (!paramaity.jdField_a_of_type_Boolean) {
            break label549;
          }
          paramrecord = paramaity.jdField_a_of_type_JavaLangString;
          label395:
          localObject1 = ((FaceDecoder)localObject1).getBitmapFromCache(j, paramrecord);
          paramrecord = (AccountSearchPb.record)localObject1;
          if (localObject1 == null)
          {
            localObject1 = bheg.a();
            if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
              if (!paramaity.jdField_a_of_type_Boolean) {
                break label557;
              }
            }
          }
        }
        break;
      }
    }
    label549:
    label557:
    for (paramrecord = paramaity.jdField_a_of_type_JavaLangString;; paramrecord = paramaity.jdField_b_of_type_JavaLangString)
    {
      j = k;
      if (paramaity.jdField_a_of_type_Boolean) {
        j = 1;
      }
      ((FaceDecoder)localObject2).requestDecodeFace(paramrecord, j, true, (byte)1);
      paramrecord = (AccountSearchPb.record)localObject1;
      paramaity.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramrecord);
      return localStringBuilder.toString();
      bool = false;
      break;
      label490:
      localObject1 = paramaity.jdField_b_of_type_JavaLangString;
      break label148;
      label499:
      paramaity.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label261;
      localStringBuilder.append(a(paramaity, paramrecord));
      break label368;
      localStringBuilder.append(b(paramaity, paramrecord));
      break label368;
      j = 11;
      break label383;
      paramrecord = paramaity.jdField_b_of_type_JavaLangString;
      break label395;
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
    if (this.jdField_a_of_type_Aite == null)
    {
      this.jdField_a_of_type_Aite = new aite(this, null);
      this.jdField_a_of_type_Aite.a(this.jdField_a_of_type_JavaUtilList);
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.jdField_d_of_type_Int == 0)
      {
        localObject1 = anvx.a(2131701434);
        label141:
        ((View)localObject2).setContentDescription((String)localObject1 + anvx.a(2131701436));
        this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aite);
        this.a = this.jdField_a_of_type_Aite;
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
      this.jdField_a_of_type_Aite.a().addAll(this.jdField_a_of_type_JavaUtilList);
    }
    int j;
    for (;;)
    {
      this.jdField_a_of_type_Aite.notifyDataSetChanged();
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
      localObject1 = anvx.a(2131701440);
      break label141;
      label371:
      this.jdField_a_of_type_Aite.a(this.jdField_a_of_type_JavaUtilList);
    }
    Object localObject2 = usa.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString);
    usa.a().a((String)localObject2, this.jdField_a_of_type_JavaLangString, 3, true, j, ((StringBuilder)localObject1).toString());
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
        this.jdField_a_of_type_Aitg.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 1);
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
          int k = this.jdField_a_of_type_Aitg.a();
          olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "" + (k + 1), aits.a(j), this.jdField_a_of_type_JavaLangString, "", false);
        }
      }
      return;
      if (h == ClassificationSearchActivity.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Aitg.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 2);
      }
      else
      {
        this.jdField_a_of_type_Aitg.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 0);
        continue;
        if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
        {
          i();
          this.jdField_a_of_type_JavaLangString = paramString;
          this.jdField_a_of_type_Aitg.c();
          if (UniteSearchActivity.jdField_d_of_type_Int == 12) {
            this.jdField_a_of_type_Aitg.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 1);
          }
          for (;;)
          {
            this.c = true;
            break;
            if (h == ClassificationSearchActivity.jdField_a_of_type_Int) {
              this.jdField_a_of_type_Aitg.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 2);
            } else {
              this.jdField_a_of_type_Aitg.a(this.jdField_a_of_type_JavaLangString, this.g, 0.0D, 0.0D, 0);
            }
          }
        }
        QQToast.a(BaseApplicationImpl.getContext(), 2131694255, 0).b(b());
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
  
  protected boolean a(ArrayList<aiuk> paramArrayList)
  {
    aiuk localaiuk = (aiuk)paramArrayList.get(0);
    if (b(paramArrayList))
    {
      this.jdField_d_of_type_Boolean = true;
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ClassificationSearchFragment.1(this, localaiuk));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClassificationSearchFragment", 2, "is no more page  = " + localaiuk.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_JavaUtilList = localaiuk.jdField_b_of_type_JavaUtilList;
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
        this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559673, null);
        localObject = (GridView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377196);
        if (Build.VERSION.SDK_INT > 8) {
          ((GridView)localObject).setOverScrollMode(2);
        }
        ((GridView)localObject).setNumColumns(4);
        ((GridView)localObject).setStretchMode(2);
        ((GridView)localObject).setVerticalSpacing(AIOUtils.dp2px(20.0F, getResources()));
        ((GridView)localObject).setAdapter(this.jdField_a_of_type_Aitb);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      if ((this.jdField_a_of_type_Aitb == null) || (this.jdField_a_of_type_Aitb.getCount() <= 0)) {
        break label241;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      localObject = this.jdField_a_of_type_Aitb.a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label221;
      }
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377200)).setText(getString(2131695012));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Aitb != null) && (this.jdField_a_of_type_Aitb.a() != null) && (!aitb.a(this.jdField_a_of_type_Aitb))) {
        this.jdField_a_of_type_Aitb.a(false);
      }
      return;
      label221:
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377200)).setText((CharSequence)localObject);
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
      if (!(localObject1 instanceof aity)) {
        break label498;
      }
      localObject2 = (aity)localObject1;
      a(((aity)localObject2).jdField_b_of_type_Int, ((aity)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record, 2);
      int j = ((aity)localObject2).c;
      int k = ((aity)localObject2).jdField_b_of_type_Int;
      int m = ((aity)localObject2).c;
      if (((aity)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin == null) {
        break label373;
      }
      localObject1 = ((aity)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "";
      bcnc.a(k, 0, m, false, (String)localObject1, this.jdField_a_of_type_JavaLangString, UniteSearchActivity.jdField_d_of_type_Int);
      if (((aity)localObject2).jdField_b_of_type_Int == 80000002)
      {
        localrecord = ((aity)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
        localObject1 = getActivity();
        if ((localObject1 != null) && ((localObject1 instanceof ClassificationSearchActivity)))
        {
          str = aits.a(((SearchBaseActivity)localObject1).a());
          localObject1 = paramView.getTag(2131370751);
          if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
            ((aity)localObject2).c = (((Integer)localObject1).intValue() + 1);
          }
          localObject3 = usa.a();
          if (localrecord.uin == null) {
            break label379;
          }
          localObject1 = localrecord.uin.get() + "";
          label247:
          ((usa)localObject3).a(3, (String)localObject1, j, UniteSearchActivity.jdField_d_of_type_Int);
          if (UniteSearchActivity.jdField_d_of_type_Int != 12) {
            break label393;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject2 = ((aity)localObject2).c + "";
          if (localrecord.uin == null) {
            break label386;
          }
          localObject1 = localrecord.uin.get() + "";
          label334:
          bdla.b((QQAppInterface)localObject3, "CliOper", "", "", "0X800658B", "0X800658B", 0, 1, 0, (String)localObject2, str, (String)localObject1, this.jdField_a_of_type_JavaLangString);
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
        olh.a((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005D22", "0X8005D22", 0, 0, ((aity)localObject2).c + "", str, this.jdField_a_of_type_JavaLangString, "", false);
        break;
      }
      label498:
      if ((localObject1 instanceof aitd))
      {
        if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
          if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
          {
            b(1);
          }
          else
          {
            QQToast.a(BaseApplicationImpl.getContext(), 2131694255, 0).b(b());
            b(4);
          }
        }
      }
      else if ((localObject1 instanceof aitx))
      {
        localObject1 = (aitx)localObject1;
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((aitx)localObject1).jdField_a_of_type_JavaLangString);
        if (UniteSearchActivity.jdField_d_of_type_Int == 1) {
          ((Intent)localObject2).putExtra("articalChannelId", 10);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          if (UniteSearchActivity.jdField_d_of_type_Int != 12) {
            break label812;
          }
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658C", "0X800658C", 0, 0, "" + ((aitx)localObject1).jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + ((aitx)localObject1).jdField_a_of_type_Long);
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
        olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D97", "0X8005D97", 0, 0, "" + ((aitx)localObject1).jdField_a_of_type_Int, "", this.jdField_a_of_type_JavaLangString, "" + ((aitx)localObject1).jdField_a_of_type_Long, false);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(2131559294, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setFocusable(true);
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aitb != null) {
      this.jdField_a_of_type_Aitb.a();
    }
    usa.a().b();
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseByTag(36);
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(36);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (jdField_a_of_type_Aiuk != null)
    {
      int j;
      if (!jdField_a_of_type_Aiuk.jdField_a_of_type_Boolean)
      {
        j = 1;
        b(j);
        this.jdField_a_of_type_JavaUtilList.addAll(jdField_a_of_type_Aiuk.jdField_b_of_type_JavaUtilList);
        this.jdField_a_of_type_Aitg.a(jdField_a_of_type_Aiuk.jdField_b_of_type_Int);
        if (ViewFactory.a(jdField_a_of_type_Aiuk.jdField_a_of_type_Int) != 2131689657) {
          break label192;
        }
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379001)).setText(usu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()));
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_JavaUtilMap.size() == 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          paramView = new ArrayList();
          paramView.add(jdField_a_of_type_Aiuk);
          a(paramView);
        }
        jdField_a_of_type_Aiuk = null;
        a();
        this.g = c();
        if ((this.jdField_d_of_type_Int == 2) && (this.jdField_a_of_type_Aitb == null)) {
          this.jdField_a_of_type_Aitb = new aitb(this);
        }
        return;
        j = 0;
        break;
        label192:
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379001)).setText(ViewFactory.a(jdField_a_of_type_Aiuk.jdField_a_of_type_Int));
      }
    }
    if ((h == ClassificationSearchActivity.jdField_a_of_type_Int) || (h == ClassificationSearchActivity.jdField_b_of_type_Int)) {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379001)).setText(ViewFactory.a(80000003));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassificationSearchFragment", 2, "searchResult is null");
      }
      g();
      break;
      if ((h == ClassificationSearchActivity.c) || (h == ClassificationSearchActivity.e)) {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379001)).setText(ViewFactory.a(80000002));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment
 * JD-Core Version:    0.7.0.1
 */