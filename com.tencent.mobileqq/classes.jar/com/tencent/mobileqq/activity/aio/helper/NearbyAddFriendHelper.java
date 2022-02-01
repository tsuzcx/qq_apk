package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mobileqq.dating.NearbyCGIReporter;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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
  private Pair<String, String> jdField_a_of_type_AndroidUtilPair = new Pair("0", "0");
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new NearbyAddFriendHelper.6(this);
  private FrameAnimationView jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView;
  private String jdField_a_of_type_JavaLangString;
  private AnchorInfo jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrAnchorInfo;
  private boolean jdField_a_of_type_Boolean = true;
  private String b;
  private TextView c;
  private TextView d;
  private TextView e;
  
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
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
      }
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {
        paramInteger = "0";
      } else {
        paramInteger = "1";
      }
      if (((NearbyContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).l()) {
        paramString = "0";
      } else {
        paramString = "1";
      }
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "block_aio", 0, 0, paramInteger, "0", paramString, "");
      return;
    }
    ((INearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a().put(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(1));
    if (((NearbyContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).l()) {
      paramInteger = "2";
    } else {
      paramInteger = "1";
    }
    NearbyChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), paramString, Integer.valueOf(paramInteger).intValue(), new NearbyAddFriendHelper.5(this));
    paramString = (ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {
      paramInteger = "0";
    } else {
      paramInteger = "1";
    }
    if (paramString.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "follow_aio", 0, 0, paramInteger, "0", paramString, "");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    NearbyCGIReporter localNearbyCGIReporter = new NearbyCGIReporter();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("opername", "now#nearby#news_c2c");
      localJSONObject.put("module", paramString1);
      localJSONObject.put("action", paramString2);
      paramString1 = String.valueOf(System.currentTimeMillis() / 1000L);
      localJSONObject.put("ts", paramString1);
      localJSONObject.put("timestr", paramString1);
      localJSONObject.put("fromuin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localJSONObject.put("touin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("appid", "406");
      localJSONObject.put("roomid", this.jdField_b_of_type_JavaLangString);
      if ((!"0".equals(this.jdField_a_of_type_AndroidUtilPair.first)) && (!"0".equals(this.jdField_a_of_type_AndroidUtilPair.second)))
      {
        localJSONObject.put("longitude", this.jdField_a_of_type_AndroidUtilPair.first);
        localJSONObject.put("latitude", this.jdField_a_of_type_AndroidUtilPair.second);
      }
      localNearbyCGIReporter.a(localJSONObject);
      return;
    }
    catch (JSONException paramString1) {}
  }
  
  private void a(GetLiveBarStatusRequest paramGetLiveBarStatusRequest)
  {
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new NearbyAddFriendHelper.3(this, paramGetLiveBarStatusRequest), paramGetLiveBarStatusRequest.toByteArray(), "trpc.nearby.nearby_livebar_svr.nearby_livebar_svr.GetLiveBarStatus");
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.b();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.e.setVisibility(8);
    }
    if (((NearbyContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).l())
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        g();
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      a();
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131709021);
    g();
  }
  
  private void g()
  {
    this.c.setText(2131709022);
    this.d.setText(2131709019);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void h()
  {
    GetLiveBarStatusRequest localGetLiveBarStatusRequest = new GetLiveBarStatusRequest();
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localGetLiveBarStatusRequest.anchor_id.set(l);
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
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      a();
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371726);
    this.e = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373725));
    this.e.setOnClickListener(new NearbyAddFriendHelper.4(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367048));
    this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView = ((FrameAnimationView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367050));
    Object localObject = this.jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrAnchorInfo;
    if (localObject == null) {
      return;
    }
    localObject = ((AnchorInfo)localObject).head_url.get();
    int i = DisplayHelper.dp2px(BaseApplication.getContext(), 37);
    ImageLoader.a().a(this.jdField_a_of_type_AndroidWidgetImageView, (String)localObject, i, i, true);
    localObject = this.jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrAnchorInfo.jump_desc.get();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.e.setText((CharSequence)localObject);
    }
  }
  
  private void j()
  {
    a("airplane_column", "view");
    this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.setAnimationRes(2130841495);
    this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.a();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.e.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    Object localObject = this.jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrAnchorInfo;
    if (localObject == null) {
      return;
    }
    this.c.setText(((AnchorInfo)localObject).desc.get());
    localObject = new StringBuilder();
    String str = this.jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrAnchorInfo.distance.get();
    if (!TextUtils.isEmpty(str))
    {
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" | ");
    }
    ((StringBuilder)localObject).append(this.jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrAnchorInfo.age.get());
    ((StringBuilder)localObject).append("岁 | ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrAnchorInfo.gender.get());
    ((StringBuilder)localObject).append(" | ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrAnchorInfo.sign.get());
    this.d.setText(((StringBuilder)localObject).toString());
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("NearbyAddFriendHelper", 2, "showAddFriendAndShield() ==== called.");
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      localObject1 = new NearbyAddFriendHelper.1(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559940, null));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131362540);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject2 = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131297589));
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131376636);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.j()) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373724));
      TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      int i;
      if (((NearbyContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).l()) {
        i = 2131707155;
      } else {
        i = 2131707154;
      }
      localTextView.setText(HardCodeUtil.a(i));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296453));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(1));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373726));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707157));
      this.jdField_a_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(2));
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f.equals(""))))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131296453));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject1);
      this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378766));
      this.d = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378038));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a()).addRule(3, 2131362540);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, (RelativeLayout.LayoutParams)localObject2);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(2131374119);
    if (localObject1 != null)
    {
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131297589) + (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131299168));
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {
      localObject1 = "0";
    } else {
      localObject1 = "1";
    }
    ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_float", 0, 0, (String)localObject1, "", "", "");
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected boolean b()
  {
    ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    return (!((NearbyContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).l()) && (!localShieldMsgManger.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(24)).c());
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if ((localView != null) && (localView.getVisibility() == 0)) {
        return;
      }
    }
    super.d();
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrAnchorInfo = null;
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidViewView = null;
          this.jdField_a_of_type_AndroidWidgetImageView = null;
          this.e = null;
          this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView.b();
          this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorCommonwidgetFrameAnimationView = null;
          this.jdField_a_of_type_JavaLangString = null;
          this.jdField_b_of_type_JavaLangString = null;
        }
        this.c = null;
        this.d = null;
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
      {
        a("overall_page", "view");
        h();
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearbyAddFriendHelper
 * JD-Core Version:    0.7.0.1
 */