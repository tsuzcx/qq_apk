package com.tencent.biz.pubaccount.readinjoy.ugc.account;

import agej;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.MalformedURLException;
import java.net.URL;
import ocd;
import org.json.JSONException;
import org.json.JSONObject;
import ozc;
import ozs;
import rco;
import rcp;

public class RIJUGCAddAccountFragment
  extends ViolaLazyFragment
{
  static int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString = "RIJUGCAddAccountFragment";
  private static boolean jdField_a_of_type_Boolean;
  public static int b;
  private static boolean b;
  public static int c = 3;
  private rcp jdField_a_of_type_Rcp;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
  }
  
  static ReadInJoyUserInfo a(long paramLong)
  {
    return ReadInJoyUserInfoModule.a(paramLong, null);
  }
  
  public static String a()
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = a(ozs.a());
    String str = ReadInJoyUserInfoModule.a();
    if (localReadInJoyUserInfo == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "RIJUGCAddAccountFragment getNickName getReadInJoyUserInfoByUin is null! ");
      return ozs.e(str);
    }
    return ozs.e(localReadInJoyUserInfo.nick);
  }
  
  static void a()
  {
    try
    {
      JSONObject localJSONObject = ozs.a();
      localJSONObject.put("uin", ozs.a());
      ocd.a(null, "CliOper", "", "", "0X800AD87", "0X800AD87", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "RIJUGCAddAccountFragment ugcAddAccountExposureReport exception: " + localJSONException.getMessage());
    }
  }
  
  public static void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = ozs.a();
      localJSONObject.put("uin", ozs.a());
      localJSONObject.put("click_area", paramInt);
      ocd.a(null, "CliOper", "", "", "0X800AD89", "0X800AD89", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "RIJUGCAddAccountFragment ugcAddAccountClickReport exception: " + localJSONException.getMessage());
    }
  }
  
  public static void a(Context paramContext)
  {
    if (a(ozs.a()) != null) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      c(paramContext);
      return;
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    ViewGroup localViewGroup1 = (ViewGroup)paramViewGroup.findViewById(2131380345);
    ViewGroup localViewGroup2 = (ViewGroup)paramViewGroup.findViewById(2131380346);
    KandianUrlImageView localKandianUrlImageView = (KandianUrlImageView)paramViewGroup.findViewById(2131369428);
    paramViewGroup = (KandianUrlImageView)paramViewGroup.findViewById(2131369429);
    ViewGroup.LayoutParams localLayoutParams = paramViewGroup.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin = (ImmersiveUtils.getStatusBarHeight(getActivity()) + (getResources().getDimensionPixelSize(2131299011) - agej.a(19.5F, getResources())) / 2);
      paramViewGroup.setLayoutParams(localLayoutParams);
    }
    try
    {
      ozc.a(localKandianUrlImageView, new URL("https://pub.idqqimg.com/pc/misc/files/20200430/21b88f2ba3bd43919173a767982d649d.png"), getActivity());
      ozc.a(paramViewGroup, new URL("https://pub.idqqimg.com/pc/misc/files/20200430/eb40275894c9455f9ab438dd91081678.png"), getActivity());
      this.jdField_a_of_type_Rcp = new rcp(getActivity(), localViewGroup2);
      localViewGroup1.setOnClickListener(new rco(this));
      return;
    }
    catch (MalformedURLException paramViewGroup)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[initView] error, e = " + paramViewGroup);
      }
    }
  }
  
  public static void b()
  {
    ThreadManager.executeOnFileThread(new RIJUGCAddAccountFragment.2());
  }
  
  public static void b(Context paramContext)
  {
    if (TextUtils.isEmpty(ozs.a()))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "editUGCAccount , but uin is empty !");
      jdField_b_of_type_Boolean = false;
    }
    Intent localIntent;
    do
    {
      return;
      jdField_b_of_type_Boolean = true;
      Bundle localBundle = new Bundle();
      localBundle.putString("url", "https://kandian.qq.com/mqq/vue/mainProfile?_wv=3&_bid=3302&source=2");
      localBundle.putBoolean("hide_operation_bar", true);
      localBundle.putString("from", String.valueOf(53));
      localIntent = new Intent(paramContext, ReadInJoyArticleDetailActivity.class);
      localIntent.putExtras(localBundle);
    } while (!(paramContext instanceof Activity));
    ((Activity)paramContext).startActivityForResult(localIntent, 10000);
  }
  
  private void c()
  {
    a(jdField_a_of_type_Int);
    a(getActivity());
    getActivity().finish();
  }
  
  private static void c(@NonNull Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_ugc_account_create", jdField_a_of_type_Boolean);
    localIntent.putExtra("key_ugc_account_edit", jdField_b_of_type_Boolean);
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).setResult(-1, localIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    if (getActivity() != null) {
      c();
    }
  }
  
  public int getContentViewId()
  {
    return 2131560290;
  }
  
  public void initAfterVisible(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    hideTitleBar();
    setStatusBarImmersive();
    a(paramViewGroup);
    a();
  }
  
  public void initBeforeVisible(Bundle paramBundle) {}
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      c(getActivity());
      getActivity().finish();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Rcp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment
 * JD-Core Version:    0.7.0.1
 */