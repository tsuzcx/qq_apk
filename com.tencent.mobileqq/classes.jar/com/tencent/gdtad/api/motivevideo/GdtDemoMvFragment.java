package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.ad.tangram.AdSettings;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoParams;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpParam;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.Ext;

public class GdtDemoMvFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private List<qq_ad_get.QQAdGetRsp.AdInfo> a = new LinkedList();
  private HashMap<Integer, String> b = new HashMap();
  private GdtAdLoader.Listener c = new GdtDemoMvFragment.1(this);
  private CheckBox d;
  private CheckBox e;
  private CheckBox f;
  private EditText g;
  private EditText h;
  private EditText i;
  private EditText j;
  private TextView k;
  private long l = 0L;
  
  public static GdtHandler.Params a(boolean paramBoolean, WeakReference<Activity> paramWeakReference)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.q = 1;
    localParams.r = paramWeakReference;
    localParams.b = paramBoolean;
    return localParams;
  }
  
  private GdtMotiveVideoPageData a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, int paramInt, boolean paramBoolean)
  {
    if (paramAdInfo == null)
    {
      QLog.e("GdtDemoMvFragment", 4, "[mockPageData] error");
      return null;
    }
    paramAdInfo = GdtUtil.a(paramAdInfo, paramInt);
    if (this.d.isChecked()) {
      paramAdInfo.containerType = 1;
    }
    if (!paramBoolean) {
      a(paramAdInfo);
    }
    return paramAdInfo;
  }
  
  private String a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    paramAdInfo = GdtJsonPbUtil.a(paramAdInfo);
    if ((paramAdInfo != null) && (!JSONObject.NULL.equals(paramAdInfo))) {
      return paramAdInfo.toString();
    }
    return "";
  }
  
  @Nullable
  private qq_ad_get.QQAdGetRsp.AdInfo a(String paramString)
  {
    try
    {
      paramString = (qq_ad_get.QQAdGetRsp.AdInfo)GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      GdtLog.d("GdtDemoMvFragment", "setPageDataUIParams", paramString);
    }
    return null;
  }
  
  public static void a(Activity paramActivity, Class<? extends QPublicBaseFragment> paramClass)
  {
    a(paramActivity, paramClass, new Bundle());
  }
  
  public static void a(Activity paramActivity, Class<? extends QPublicBaseFragment> paramClass, Bundle paramBundle)
  {
    if ((paramActivity != null) && (paramBundle != null))
    {
      GdtLog.b("GdtDemoMvFragment", "start");
      Intent localIntent = new Intent();
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      localIntent.putExtras(paramBundle);
      QPublicFragmentActivity.start(paramActivity, localIntent, paramClass);
      return;
    }
    GdtLog.b("GdtDemoMvFragment", "start error");
  }
  
  private void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if (paramGdtMotiveVideoPageData == null) {
      return;
    }
    paramGdtMotiveVideoPageData.antiSpamParams = "{\"lt\":2,\"ig\":0}";
    if ((this.e.isChecked()) && (!TextUtils.isEmpty(this.g.getText()))) {
      this.b.put(Integer.valueOf(100329), this.g.getText().toString());
    }
    if (this.f.isChecked()) {
      this.b.put(Integer.valueOf(109756), "2");
    }
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = a(paramGdtMotiveVideoPageData.adsContent);
    b(localAdInfo);
    paramGdtMotiveVideoPageData.adsContent = a(localAdInfo);
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == -2147483648) {
      return 3;
    }
    int m = 6;
    if (paramInt1 != 200) {
      return 6;
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 == 1) {
        m = 4;
      }
      return m;
    }
    if (paramInt3 != 0)
    {
      if (paramInt3 == 102006) {
        m = 5;
      }
      return m;
    }
    return 0;
  }
  
  private void b()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      int m = ((Integer)localIterator.next()).intValue();
      localStringBuilder.append(String.format(Locale.ENGLISH, "%d : %s\n", new Object[] { Integer.valueOf(m), this.b.get(Integer.valueOf(m)) }));
    }
    this.k.setText(localStringBuilder.toString());
  }
  
  private void b(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if (paramAdInfo == null) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      int m = ((Integer)localIterator.next()).intValue();
      qq_ad_get.QQAdGetRsp.AdInfo.ExpParam localExpParam = new qq_ad_get.QQAdGetRsp.AdInfo.ExpParam();
      localExpParam.key.set(m);
      localExpParam.value.set((String)this.b.get(Integer.valueOf(m)));
      localLinkedList.add(localExpParam);
    }
    paramAdInfo.ext.exp_map.set(localLinkedList);
  }
  
  @NonNull
  private List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> c(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramAdInfo == null) {
      return localLinkedList;
    }
    if (paramAdInfo.ext.exp_map.get().size() > 0) {
      return paramAdInfo.ext.exp_map.get();
    }
    if (TextUtils.isEmpty(paramAdInfo.ext_json.get())) {
      return localLinkedList;
    }
    try
    {
      paramAdInfo = new JSONObject(paramAdInfo.ext_json.get());
      paramAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo.Ext)GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), paramAdInfo);
      if (paramAdInfo == null) {
        return localLinkedList;
      }
      paramAdInfo = paramAdInfo.exp_map.get();
      return paramAdInfo;
    }
    catch (Throwable paramAdInfo)
    {
      QLog.e("GdtDemoMvFragment", 4, "[mockHitExperiment] ", paramAdInfo);
    }
    return localLinkedList;
  }
  
  private void d(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    this.b.clear();
    if (paramAdInfo == null) {
      return;
    }
    paramAdInfo = c(paramAdInfo).iterator();
    while (paramAdInfo.hasNext())
    {
      qq_ad_get.QQAdGetRsp.AdInfo.ExpParam localExpParam = (qq_ad_get.QQAdGetRsp.AdInfo.ExpParam)paramAdInfo.next();
      this.b.put(Integer.valueOf(localExpParam.key.get()), localExpParam.value.get());
    }
  }
  
  public qq_ad_get.QQAdGet a(long paramLong, String paramString)
  {
    Object localObject = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject).deep_link_version.set(1);
    qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
    localPositionInfo.pos_id.set(paramString);
    localPositionInfo.ad_count.set(2);
    localPositionInfo.pos_ext.set((MessageMicro)localObject);
    paramString = new qq_ad_get.QQAdGet.UserInfo();
    paramString.qq.set(paramLong);
    localObject = new qq_ad_get.QQAdGet();
    ((qq_ad_get.QQAdGet)localObject).position_info.add(localPositionInfo);
    ((qq_ad_get.QQAdGet)localObject).user_info.set(paramString);
    return localObject;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtDemoMvFragment", 2, "[loadAdFromAms]");
    }
    Object localObject = new GdtMotiveVideoParams();
    AppInterface localAppInterface = ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface();
    if (localAppInterface == null) {
      return;
    }
    String str;
    if (TextUtils.isEmpty(this.j.getHint())) {
      str = "6020954314138204";
    } else {
      str = this.j.getHint().toString();
    }
    if (!TextUtils.isEmpty(this.j.getText())) {
      str = this.j.getText().toString();
    }
    ((GdtMotiveVideoParams)localObject).b = a(true, new WeakReference(getQBaseActivity()));
    localObject = new GdtAdLoader.Session();
    ((GdtAdLoader.Session)localObject).a = a(Long.parseLong(localAppInterface.getCurrentAccountUin()), str);
    ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).loadAd((GdtAdLoader.Session)localObject, new WeakReference(this.c), new WeakReference(getContext()));
    a("开始加载数据...");
  }
  
  public void a(CharSequence paramCharSequence)
  {
    getQBaseActivity().runOnUiThread(new GdtDemoMvFragment.2(this, paramCharSequence));
  }
  
  public void a(List<qq_ad_get.QQAdGetRsp.AdInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.a = paramList;
      d((qq_ad_get.QQAdGetRsp.AdInfo)paramList.get(0));
      b();
      a("数据加载成功!");
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setRequestedOrientation(1);
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramInt2 == -1) && (paramInt1 == 101) && (paramIntent.getExtras() == null))
    {
      GdtLog.d("GdtDemoMvFragment", "onActivityResult b==null ");
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    QLog.e("GdtDemoMvFragment", 4, "[onClick]");
    int m = paramView.getId();
    if (SystemClock.uptimeMillis() - this.l >= 600L)
    {
      this.l = SystemClock.uptimeMillis();
      Object localObject1 = this.a;
      if (((localObject1 == null) || (((List)localObject1).isEmpty())) && (m != 2131429926) && (m != 2131430042) && (m != 2131429927))
      {
        a("请先加载广告数据");
      }
      else
      {
        switch (m)
        {
        default: 
          a("cannot handle this click event");
          QLog.e("GdtDemoMvFragment", 4, "[onClick] cannot handle");
          break;
        case 2131430042: 
          AdSettings.setTestMode(AdSettings.isTestMode() ^ true);
          localObject1 = (Button)paramView;
          if (AdSettings.isTestMode()) {
            m = 2131889964;
          } else {
            m = 2131889963;
          }
          ((Button)localObject1).setText(m);
          break;
        case 2131430031: 
          m = 1;
          break;
        case 2131430030: 
          m = 1;
          break;
        case 2131430029: 
          m = 1;
          n = 0;
          break;
        case 2131430028: 
          m = 0;
          n = 1;
          bool = false;
          i1 = m;
          break;
        case 2131429993: 
          d((qq_ad_get.QQAdGetRsp.AdInfo)this.a.get(0));
          break;
        case 2131429989: 
          if (TextUtils.isEmpty(this.h.getText())) {
            m = -2147483648;
          } else {
            m = Integer.parseInt(this.h.getText().toString());
          }
          if (m == -2147483648) {
            break label457;
          }
          this.b.remove(Integer.valueOf(m));
          break;
        case 2131429927: 
          a("功能待完善");
          break;
        case 2131429926: 
          a();
          break;
        }
        if (TextUtils.isEmpty(this.h.getText())) {
          m = -2147483648;
        } else {
          m = Integer.parseInt(this.h.getText().toString());
        }
        if (TextUtils.isEmpty(this.i.getText())) {
          localObject1 = "";
        } else {
          localObject1 = this.i.getText().toString();
        }
        if ((m != -2147483648) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
          this.b.put(Integer.valueOf(m), localObject1);
        }
        label457:
        m = 0;
        int n = 1;
        boolean bool = true;
        int i1 = n;
        n = m;
        if (n != 0)
        {
          Object localObject2 = (qq_ad_get.QQAdGetRsp.AdInfo)this.a.get(0);
          if (this.a.size() > 1) {
            localObject1 = (qq_ad_get.QQAdGetRsp.AdInfo)this.a.get(1);
          } else {
            localObject1 = null;
          }
          localObject2 = a((qq_ad_get.QQAdGetRsp.AdInfo)localObject2, i1, bool);
          localObject1 = a((qq_ad_get.QQAdGetRsp.AdInfo)localObject1, i1, bool);
          if (localObject2 != null)
          {
            localObject2 = StartGdtMotiveVideoParams.a(getQBaseActivity(), (GdtMotiveVideoPageData)localObject2);
            ((StartGdtMotiveVideoParams)localObject2).c = ((GdtMotiveVideoPageData)localObject1);
            ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo((StartGdtMotiveVideoParams)localObject2);
          }
        }
        b();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131624948, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131429926).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131430042).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131430031).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131430029).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131430030).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131430028).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131429789).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131429989).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131429993).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131429927).setOnClickListener(this);
    this.d = ((CheckBox)paramLayoutInflater.findViewById(2131430419));
    this.e = ((CheckBox)paramLayoutInflater.findViewById(2131430418));
    this.g = ((EditText)paramLayoutInflater.findViewById(2131432615));
    this.h = ((EditText)paramLayoutInflater.findViewById(2131432621));
    this.i = ((EditText)paramLayoutInflater.findViewById(2131432622));
    this.j = ((EditText)paramLayoutInflater.findViewById(2131432611));
    this.f = ((CheckBox)paramLayoutInflater.findViewById(2131430410));
    this.k = ((TextView)paramLayoutInflater.findViewById(2131448435));
    AdSettings.setTestMode(true);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment
 * JD-Core Version:    0.7.0.1
 */