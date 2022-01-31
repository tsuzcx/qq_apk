package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomHelper;
import cooperation.liveroom.LiveRoomPluginInstaller;
import cooperation.liveroom.LiveRoomPluginLoader;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import oxb;
import pbe;
import pbf;
import pbg;
import pbh;
import snl;
import sno;
import spw;
import srj;

public class ReadInJoyViolaChannelFragment
  extends ReadInJoyBaseFragment
{
  private static pbh jdField_a_of_type_Pbh;
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected ViewGroup a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ViolaBaseView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView;
  protected String a;
  private sno jdField_a_of_type_Sno;
  protected String b;
  private String c;
  
  public ReadInJoyViolaChannelFragment()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "viola";
  }
  
  public static ReadInJoyViolaChannelFragment a(int paramInt, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("channel_id", paramInt);
    localBundle.putString("channel_name", paramString1);
    localBundle.putString("channel_version", paramString2);
    paramString1 = new ReadInJoyViolaChannelFragment();
    paramString1.setArguments(localBundle);
    return paramString1;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = new ViolaBaseView(getActivity());
    ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380006)).addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
    if (this.jdField_a_of_type_Sno.a()) {
      this.jdField_a_of_type_Sno.d();
    }
    b();
    this.jdField_a_of_type_Sno.a(this.jdField_a_of_type_AndroidViewViewGroup, new pbe(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setListener(new pbf(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setPageStartTime(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(this.c, this, new srj(this.c, new JSONObject(), snl.a(this.c), 1));
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (jdField_a_of_type_Pbh == null) {
        jdField_a_of_type_Pbh = new pbh(null);
      }
      jdField_a_of_type_Pbh.jdField_a_of_type_Int = paramInt;
      jdField_a_of_type_Pbh.jdField_a_of_type_JavaLangString = new String(Base64.decode(paramString, 0));
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyViolaChannelFragment", 2, "saveGuidingJumpPendingInfo, channelId: " + paramInt + ", url: " + jdField_a_of_type_Pbh.jdField_a_of_type_JavaLangString);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
  }
  
  private void b(int paramInt)
  {
    if (jdField_a_of_type_Pbh == null) {
      return;
    }
    if (paramInt == jdField_a_of_type_Pbh.jdField_a_of_type_Int)
    {
      this.c = jdField_a_of_type_Pbh.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyViolaChannelFragment", 2, "replaceViolaUrl, channelId: " + paramInt + ", url: " + jdField_a_of_type_Pbh.jdField_a_of_type_JavaLangString);
      }
    }
    jdField_a_of_type_Pbh.jdField_a_of_type_Int = -1;
    jdField_a_of_type_Pbh.jdField_a_of_type_JavaLangString = null;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "reload viola Page mChannelName :" + this.jdField_a_of_type_JavaLangString + "; mChannelId :" + this.jdField_a_of_type_Int);
    }
    b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(new pbg(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if ((paramInt == 5) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.b())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(spw.a(2).toString());
    }
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "notifyShowSelf mChannelName :" + this.jdField_a_of_type_JavaLangString + "; mChannelId :" + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.c()) && (c()) && (ReadinjoyTabFrame.c_())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(true);
    }
    for (;;)
    {
      oxb.a().a(3, null);
      return;
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        a();
      }
    }
  }
  
  public String b()
  {
    return this.b;
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void e() {}
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "notifyClickSelf mChannelName :" + this.jdField_a_of_type_JavaLangString + "; mChannelId :" + this.jdField_a_of_type_Int);
    }
    String str = "ViolaChanel_" + this.c;
    ArrayList localArrayList;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.b())) {
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("url", this.c);
        if ((localArrayList.size() == 0) && (!TextUtils.isEmpty(this.c)))
        {
          localObject = Uri.parse(this.c);
          if (((Uri)localObject).isHierarchical()) {
            localArrayList.add(((Uri)localObject).getHost());
          }
        }
        Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        localIntent.putExtra("broadcast", true);
        localIntent.putExtra("unique", String.valueOf(System.currentTimeMillis()) + String.valueOf((int)(Math.random() * 1000000.0D)));
        localIntent.putExtra("event", str);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("eventName", "tabClick");
        if (localObject != null) {
          localIntent.putExtra("data", ((JSONObject)localObject).toString());
        }
        localIntent.putStringArrayListExtra("domains", localArrayList);
        localIntent.putExtra("source", localJSONObject.toString());
        if (QLog.isColorLevel())
        {
          if (localObject == null) {
            continue;
          }
          localObject = ((JSONObject)localObject).toString();
          QLog.d("ReadInJoyViolaChannelFragment", 2, String.format("send event broadcast, event: %s, data: %s, domains: %s, source: %s", new Object[] { str, localObject, TextUtils.join(",", localArrayList), localJSONObject }));
        }
        BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
        if (1 == 0) {}
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        continue;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(spw.a(1).toString());
      return;
      localObject = "NULL";
    }
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "notifyHideSelf mChannelName :" + this.jdField_a_of_type_JavaLangString + "; mChannelId :" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.b();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.c()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(false);
      }
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "notifyTabDoubleClick mChannelName :" + this.jdField_a_of_type_JavaLangString + "; mChannelId :" + this.jdField_a_of_type_Int);
    }
    super.k();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.jdField_a_of_type_Int = localBundle.getInt("channel_id");
      this.jdField_a_of_type_JavaLangString = localBundle.getString("channel_name");
      this.b = localBundle.getString("channel_version");
      if ((this.jdField_a_of_type_Int == 41660) || (this.jdField_a_of_type_Int == 8))
      {
        if (!LiveRoomHelper.isPluginInstalledInQQ()) {
          break label81;
        }
        LiveRoomPluginLoader.preLoadPlugin();
      }
    }
    for (;;)
    {
      b(this.jdField_a_of_type_Int);
      super.onCreate(paramBundle);
      return;
      label81:
      LiveRoomPluginInstaller.getInstance().installFromQQ(null, "Readinjoy pre");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "onCreateView mChannelName :" + this.jdField_a_of_type_JavaLangString + "; mChannelId :" + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558457, paramViewGroup, false));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372977));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    this.jdField_a_of_type_Sno = new sno(this);
    if ((!getUserVisibleHint()) && (ors.l())) {}
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewViewGroup;
      a();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "onDestroy mChannelName :" + this.jdField_a_of_type_JavaLangString + "; mChannelId :" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityDestroy();
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "onPause mChannelName :" + this.jdField_a_of_type_JavaLangString + "; mChannelId :" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityPause();
      if (bool) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(false);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityResume();
      if ((bool) && (ReadinjoyTabFrame.c_()) && (c())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(true);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "onStart mChannelName :" + this.jdField_a_of_type_JavaLangString + "; mChannelId :" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityStart();
    }
    oxb.a().a(3, null);
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "onStop mChannelName :" + this.jdField_a_of_type_JavaLangString + "; mChannelId :" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityStop();
      if (bool) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment
 * JD-Core Version:    0.7.0.1
 */