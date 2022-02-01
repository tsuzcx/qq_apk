package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.util.ImageLoader;
import com.tencent.biz.ProtoUtils;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyContext;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.newnearby.INearbyCGIReporter;
import com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nearby.nearbyLivebarSvr.nearbyLivebarSvr.AnchorInfo;
import nearby.nearbyLivebarSvr.nearbyLivebarSvr.GetLiveBarStatusRequest;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyAddFriendHelper
  extends AddFriendHelper
{
  ShieldListObserver k = new NearbyAddFriendHelper.6(this);
  private boolean l = true;
  private TextView m;
  private TextView n;
  private ImageView o;
  private FrameAnimationView p;
  private View q;
  private TextView r;
  private String s;
  private String t;
  private AnchorInfo u;
  private Pair<String, String> v = new Pair("0", "0");
  
  public NearbyAddFriendHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  private void a(Integer paramInteger, String paramString)
  {
    int i = paramInteger.intValue();
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      ChatActivityUtils.a(this.b, this.c, this.e.a, paramString, this.e.f, false);
      if (this.e.a == 1010) {
        ReportController.b(this.b, "CliOper", "", this.e.b, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
      }
      localQQAppInterface = this.b;
      if (this.e.a == 1001) {
        paramInteger = "0";
      } else {
        paramInteger = "1";
      }
      if (((NearbyContext)this.a).R()) {
        paramString = "0";
      } else {
        paramString = "1";
      }
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "block_aio", 0, 0, paramInteger, "0", paramString, "");
      return;
    }
    ((INearbyCardManager)this.b.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).f().put(this.e.b, Integer.valueOf(1));
    if (((NearbyContext)this.a).R()) {
      paramInteger = "2";
    } else {
      paramInteger = "1";
    }
    NearbyChatPie.a(this.a.a(), paramString, Integer.valueOf(paramInteger).intValue(), new NearbyAddFriendHelper.5(this));
    paramString = (ShieldMsgManger)this.b.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    QQAppInterface localQQAppInterface = this.b;
    if (this.e.a == 1001) {
      paramInteger = "0";
    } else {
      paramInteger = "1";
    }
    if (paramString.a(this.e.b)) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "follow_aio", 0, 0, paramInteger, "0", paramString, "");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.b == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("opername", "now#nearby#news_c2c");
      localJSONObject.put("module", paramString1);
      localJSONObject.put("action", paramString2);
      paramString1 = String.valueOf(System.currentTimeMillis() / 1000L);
      localJSONObject.put("ts", paramString1);
      localJSONObject.put("timestr", paramString1);
      localJSONObject.put("fromuin", this.b.getCurrentAccountUin());
      localJSONObject.put("touin", this.e.b);
      localJSONObject.put("appid", "406");
      localJSONObject.put("roomid", this.t);
      if ((!"0".equals(this.v.first)) && (!"0".equals(this.v.second)))
      {
        localJSONObject.put("longitude", this.v.first);
        localJSONObject.put("latitude", this.v.second);
      }
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException paramString1) {}
  }
  
  private void a(GetLiveBarStatusRequest paramGetLiveBarStatusRequest)
  {
    ProtoUtils.a(this.b, new NearbyAddFriendHelper.3(this, paramGetLiveBarStatusRequest), paramGetLiveBarStatusRequest.toByteArray(), "trpc.nearby.nearby_livebar_svr.nearby_livebar_svr.GetLiveBarStatus");
  }
  
  private void i()
  {
    if (this.q != null)
    {
      this.p.b();
      this.q.setVisibility(8);
      this.r.setVisibility(8);
    }
    if (((NearbyContext)this.a).R())
    {
      if (this.g != null)
      {
        this.g.setVisibility(8);
        j();
      }
      return;
    }
    if (this.g == null) {
      c();
    }
    this.g.setVisibility(0);
    this.i.setText(2131899712);
    j();
  }
  
  private void j()
  {
    this.m.setText(2131906786);
    this.n.setText(2131906784);
    this.i.setVisibility(0);
  }
  
  private void k()
  {
    GetLiveBarStatusRequest localGetLiveBarStatusRequest = new GetLiveBarStatusRequest();
    try
    {
      long l1 = Long.parseLong(this.e.b);
      localGetLiveBarStatusRequest.anchor_id.set(l1);
      localGetLiveBarStatusRequest.need_anchorInfo.set(1);
      TencentLocationManager localTencentLocationManager = TencentLocationManager.getInstance(BaseApplication.getContext());
      TencentLocationRequest localTencentLocationRequest = TencentLocationRequest.create();
      localTencentLocationRequest.setRequestLevel(3);
      localTencentLocationRequest.setAllowGPS(true);
      localTencentLocationManager.requestLocationUpdates(localTencentLocationRequest, new NearbyAddFriendHelper.2(this, localGetLiveBarStatusRequest, localTencentLocationManager), Looper.getMainLooper());
      return;
    }
    catch (NumberFormatException localNumberFormatException) {}
  }
  
  private void l()
  {
    if (this.q != null) {
      return;
    }
    if (this.g == null) {
      c();
    }
    this.q = this.g.findViewById(2131439154);
    this.r = ((TextView)this.g.findViewById(2131441399));
    this.r.setOnClickListener(new NearbyAddFriendHelper.4(this));
    this.o = ((ImageView)this.q.findViewById(2131433497));
    this.p = ((FrameAnimationView)this.q.findViewById(2131433499));
    Object localObject = this.u;
    if (localObject == null) {
      return;
    }
    localObject = ((AnchorInfo)localObject).head_url.get();
    int i = DisplayHelper.dp2px(BaseApplication.getContext(), 37);
    ImageLoader.a().a(this.o, (String)localObject, i, i, true);
    localObject = this.u.jump_desc.get();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.r.setText((CharSequence)localObject);
    }
  }
  
  private void m()
  {
    a("airplane_button", "click");
    Object localObject2 = Uri.parse(this.s);
    if (this.s.contains("groupvideo"))
    {
      IGroupVideoManager localIGroupVideoManager = (IGroupVideoManager)this.b.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
      String str2 = ((Uri)localObject2).getQueryParameter("roomcode");
      localObject1 = ((Uri)localObject2).getQueryParameter("isgroupcode");
      int i;
      if (localObject1 != null) {
        i = Integer.parseInt((String)localObject1);
      } else {
        i = 0;
      }
      String str3 = ((Uri)localObject2).getQueryParameter("fromid");
      String str1 = ((Uri)localObject2).getQueryParameter("backtype");
      localObject1 = str1;
      if ("undefined".equals(str1)) {
        localObject1 = null;
      }
      str1 = ((Uri)localObject2).getQueryParameter("open_type");
      localObject2 = ((Uri)localObject2).getQueryParameter("extra");
      localIGroupVideoManager.a(this.r.getContext(), str2, this.b.getCurrentUin(), i, "download", str3, (String)localObject1, str1, (String)localObject2);
      return;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("roomid", this.t);
    ((Bundle)localObject1).putString("startsrc", "10009");
    ((Bundle)localObject1).putString("first_jump_mode", "h5");
    ((Bundle)localObject1).putString("can_ues_h5_first", "true");
    ((Bundle)localObject1).putString("mqqScheme", this.s);
    ((Bundle)localObject1).putString("big_brother_source_key", "biz_src_ads");
    ((Bundle)localObject1).putString("big_brother_ref_source_key", "biz_src_jc_aio");
    ((IDynamicNowManager)this.b.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a((Bundle)localObject1);
  }
  
  private void n()
  {
    a("airplane_column", "view");
    this.p.setAnimationRes(2130842337);
    this.p.a();
    this.q.setVisibility(0);
    this.r.setVisibility(0);
    this.i.setVisibility(8);
    this.g.setVisibility(0);
    Object localObject = this.u;
    if (localObject == null) {
      return;
    }
    this.m.setText(((AnchorInfo)localObject).desc.get());
    localObject = new StringBuilder();
    String str = this.u.distance.get();
    if (!TextUtils.isEmpty(str))
    {
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" | ");
    }
    ((StringBuilder)localObject).append(this.u.age.get());
    ((StringBuilder)localObject).append("岁 | ");
    ((StringBuilder)localObject).append(this.u.gender.get());
    ((StringBuilder)localObject).append(" | ");
    ((StringBuilder)localObject).append(this.u.sign.get());
    this.n.setText(((StringBuilder)localObject).toString());
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected void c()
  {
    this.l = false;
    if (QLog.isColorLevel()) {
      QLog.d("NearbyAddFriendHelper", 2, "showAddFriendAndShield() ==== called.");
    }
    if (this.g == null)
    {
      localObject1 = new NearbyAddFriendHelper.1(this);
      this.g = ((LinearLayout)LayoutInflater.from(this.d).inflate(2131625983, null));
      this.g.setId(2131428151);
      this.g.setVisibility(8);
      localObject2 = new RelativeLayout.LayoutParams(-1, (int)this.b.getApplication().getResources().getDimension(2131298253));
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131444897);
      if (!this.a.I()) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      }
      this.i = ((TextView)this.g.findViewById(2131441398));
      TextView localTextView = this.i;
      int i;
      if (((NearbyContext)this.a).R()) {
        i = 2131904988;
      } else {
        i = 2131899712;
      }
      localTextView.setText(HardCodeUtil.a(i));
      this.i.setTextSize(0, this.d.getResources().getDimensionPixelSize(2131296687));
      this.i.setContentDescription(this.i.getText());
      this.i.setGravity(17);
      this.i.setOnClickListener((View.OnClickListener)localObject1);
      this.i.setTag(Integer.valueOf(1));
      this.h = ((TextView)this.g.findViewById(2131441400));
      this.h.setText(HardCodeUtil.a(2131904990));
      this.h.setTag(Integer.valueOf(2));
      if ((this.e.a == 1006) && ((this.e.g == null) || (this.e.g.equals(""))))
      {
        this.h.setEnabled(false);
        this.h.setClickable(false);
      }
      else
      {
        this.h.setEnabled(true);
        this.h.setClickable(true);
      }
      this.h.setGravity(17);
      this.h.setTextSize(0, this.b.getApplication().getResources().getDimension(2131296687));
      this.h.setOnClickListener((View.OnClickListener)localObject1);
      this.m = ((TextView)this.g.findViewById(2131447441));
      this.n = ((TextView)this.g.findViewById(2131446538));
      if (this.e.a == 1001)
      {
        this.h.setVisibility(8);
        this.g.setVisibility(8);
      }
      else
      {
        this.g.setVisibility(0);
      }
      ((RelativeLayout.LayoutParams)this.a.e().b().x()).addRule(3, 2131428151);
      this.a.a(this.g, (RelativeLayout.LayoutParams)localObject2);
    }
    else
    {
      this.g.setVisibility(0);
    }
    Object localObject1 = this.a.d(2131442214);
    if (localObject1 != null)
    {
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)this.c.getResources().getDimension(2131298253) + (int)this.c.getResources().getDimension(2131299920));
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    Object localObject2 = this.b;
    if (this.e.a == 1001) {
      localObject1 = "0";
    } else {
      localObject1 = "1";
    }
    ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_float", 0, 0, (String)localObject1, "", "", "");
  }
  
  protected void f()
  {
    if (this.e.a == 1001)
    {
      View localView = this.q;
      if ((localView != null) && (localView.getVisibility() == 0)) {
        return;
      }
    }
    super.f();
  }
  
  protected boolean h()
  {
    ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.b.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    return (!((NearbyContext)this.a).R()) && (!localShieldMsgManger.a(this.e.b)) && (!((FullScreenInputHelper)this.a.a(24)).e());
  }
  
  public void onMoveToState(int paramInt)
  {
    super.onMoveToState(paramInt);
    if (paramInt != 4)
    {
      if (paramInt != 9)
      {
        if (paramInt != 15) {
          return;
        }
        this.b.removeObserver(this.k);
        this.l = true;
        this.u = null;
        if (this.q != null)
        {
          this.q = null;
          this.o = null;
          this.r = null;
          this.p.b();
          this.p = null;
          this.s = null;
          this.t = null;
        }
        this.m = null;
        this.n = null;
        return;
      }
      if (this.e.a == 1001)
      {
        a("overall_page", "view");
        k();
      }
    }
    else
    {
      this.b.addObserver(this.k);
      this.l = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearbyAddFriendHelper
 * JD-Core Version:    0.7.0.1
 */