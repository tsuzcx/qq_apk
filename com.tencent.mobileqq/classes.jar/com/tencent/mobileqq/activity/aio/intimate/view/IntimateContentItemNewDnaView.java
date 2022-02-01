package com.tencent.mobileqq.activity.aio.intimate.view;

import agll;
import agmf;
import agmg;
import agmr;
import agms;
import agmt;
import agmu;
import amfb;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import anvk;
import arau;
import arav;
import azch;
import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntimateContentItemNewDnaView
  extends IntimateContentItemBaseView
{
  private agmt jdField_a_of_type_Agmt;
  private agmu jdField_a_of_type_Agmu = new agmr(this);
  private RecyclerView jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  private boolean d;
  
  public IntimateContentItemNewDnaView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemNewDnaView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemNewDnaView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(agmf paramagmf)
  {
    bdla.b(null, "dc00898", "", "", "0X800B569", "0X800B569", paramagmf.jdField_a_of_type_Int, 0, "", "", "", "");
    MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidContentContext, paramagmf.d, 2064, null);
  }
  
  private void a(Friends paramFriends, List<agmf> paramList, agmf paramagmf)
  {
    agmg localagmg1 = new agmg();
    localagmg1.jdField_a_of_type_JavaLangString = (paramFriends.temper + "°" + paramFriends.weatherType);
    localagmg1.jdField_a_of_type_Int = 0;
    localagmg1.b = localagmg1.jdField_a_of_type_JavaLangString.getBytes().length;
    agmg localagmg2 = new agmg();
    localagmg2.jdField_a_of_type_JavaLangString = (paramFriends.city + paramFriends.area);
    localagmg2.jdField_a_of_type_Int = 0;
    localagmg2.b = localagmg2.jdField_a_of_type_JavaLangString.getBytes().length;
    paramFriends = new ArrayList();
    paramFriends.add(localagmg1);
    paramFriends.add(localagmg2);
    if (paramagmf.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramagmf.jdField_a_of_type_JavaUtilArrayList.clear();
      paramagmf.jdField_a_of_type_JavaUtilArrayList.addAll(paramFriends);
    }
    for (;;)
    {
      paramList.add(paramagmf);
      return;
      paramagmf.jdField_a_of_type_JavaUtilArrayList = paramFriends;
    }
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QQToast.a(getContext(), 1, paramString, 0).a();
    }
  }
  
  private void a(List<agmf> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      Friends localFriends = ((anvk)this.jdField_a_of_type_Agll.a().getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.jdField_a_of_type_Agll.a());
      ArrayList localArrayList = new ArrayList();
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        agmf localagmf = (agmf)paramList.next();
        if (localagmf.jdField_a_of_type_Int == 23)
        {
          String str1 = localSharedPreferences.getString("drawer_cur_temp", null);
          String str2 = localSharedPreferences.getString("drawer_cur_city", null);
          int i = localSharedPreferences.getInt("drawer_cur_adcode", 0);
          String str3 = localSharedPreferences.getString("drawer_cur_desc", null);
          if ((localFriends != null) && (azch.a(localFriends)) && (!TextUtils.isEmpty(localFriends.adCode)) && (!TextUtils.isEmpty(localFriends.area)) && (!TextUtils.isEmpty(localFriends.city)) && (!TextUtils.isEmpty(localFriends.temper)) && (!TextUtils.isEmpty(localFriends.weatherType))) {
            a(localFriends, localArrayList, localagmf);
          } else if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (i != 0) && (!TextUtils.isEmpty(str3))) {
            a(localArrayList, localagmf, str1, str2, str3);
          }
        }
        else
        {
          localArrayList.add(localagmf);
        }
      }
      this.jdField_a_of_type_Agmt.a(localArrayList);
    }
  }
  
  private void a(List<agmf> paramList, agmf paramagmf, String paramString1, String paramString2, String paramString3)
  {
    agmg localagmg = new agmg();
    localagmg.jdField_a_of_type_JavaLangString = (paramString1 + "°" + paramString3);
    localagmg.jdField_a_of_type_Int = 0;
    localagmg.b = localagmg.jdField_a_of_type_JavaLangString.getBytes().length;
    paramString1 = paramString2.split("-");
    if (paramString1.length == 2) {
      paramString2 = paramString1[0] + paramString1[1];
    }
    paramString1 = new agmg();
    paramString1.jdField_a_of_type_JavaLangString = paramString2;
    paramString1.jdField_a_of_type_Int = 0;
    paramString1.b = paramString1.jdField_a_of_type_JavaLangString.getBytes().length;
    paramString2 = new ArrayList();
    paramString2.add(localagmg);
    paramString2.add(paramString1);
    if (paramagmf.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramagmf.jdField_a_of_type_JavaUtilArrayList.clear();
      paramagmf.jdField_a_of_type_JavaUtilArrayList.addAll(paramString2);
    }
    for (;;)
    {
      paramList.add(paramagmf);
      return;
      paramagmf.jdField_a_of_type_JavaUtilArrayList = paramString2;
    }
  }
  
  private void b(agmf paramagmf)
  {
    if (QQBrowserActivity.a(1000L))
    {
      bdla.b(null, "dc00898", "", "", "0X800B569", "0X800B569", paramagmf.jdField_a_of_type_Int, 0, "", "", "", "");
      Friends localFriends = ((anvk)this.jdField_a_of_type_Agll.a().getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.jdField_a_of_type_Agll.a());
      int i = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getInt("drawer_cur_adcode", 0);
      paramagmf = "";
      if (i != 0) {
        paramagmf = String.valueOf(i);
      }
      if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.adCode))) {
        amfb.a(this.jdField_a_of_type_Agll.a(), this.jdField_a_of_type_Agll.a(), false, "", false, localFriends.adCode);
      }
    }
    else
    {
      return;
    }
    if (!TextUtils.isEmpty(paramagmf))
    {
      amfb.a(this.jdField_a_of_type_Agll.a(), this.jdField_a_of_type_Agll.a(), false, "", false, paramagmf);
      return;
    }
    a(this.jdField_a_of_type_AndroidContentContext.getString(2131693329));
  }
  
  private void c(agmf paramagmf)
  {
    if (QQBrowserActivity.a(1000L))
    {
      bdla.b(null, "dc00898", "", "", "0X800B569", "0X800B569", paramagmf.jdField_a_of_type_Int, 0, "", "", "", "");
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQTranslucentBrowserActivity.class);
      localIntent.putExtra("url", paramagmf.b);
      localIntent.putExtra("flag_show_loading_dialog", true);
      localIntent.putExtra("flag_hide_float_bar", true);
      localIntent.putExtra("hide_left_button", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559319, this, true).findViewById(2131367360));
    this.jdField_a_of_type_Agmt = new agmt(this, null);
    agms localagms = new agms(this, this.jdField_a_of_type_Agll.a(), 2);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager(localagms);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(this.jdField_a_of_type_Agmt);
    this.d = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  protected void a(View paramView) {}
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    if ((paramIntimateInfo != null) && (paramIntimateInfo.newDnaInfos != null) && (paramIntimateInfo.newDnaInfos.size() > 0))
    {
      setVisibility(0);
      a(paramIntimateInfo.newDnaInfos);
      return;
    }
    setVisibility(8);
  }
  
  protected boolean a()
  {
    boolean bool = arav.a().d;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.newDnaInfos != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.newDnaInfos.size() > 0)) {}
    for (int i = 1; (bool) && (i != 0); i = 0) {
      return true;
    }
    return false;
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView != null)
    {
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(null);
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = null;
    }
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView
 * JD-Core Version:    0.7.0.1
 */