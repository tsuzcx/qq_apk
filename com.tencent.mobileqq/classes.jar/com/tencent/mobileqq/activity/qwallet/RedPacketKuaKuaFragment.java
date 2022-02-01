package com.tencent.mobileqq.activity.qwallet;

import aean;
import agej;
import aifz;
import akwt;
import akwu;
import akyu;
import akyv;
import akyy;
import akyz;
import alil;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anzj;
import asle;
import bdll;
import bgme;
import bhgr;
import bhlg;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.qqwallet.kua_kua_hb_srv.ClientAttr;
import tencent.im.qqwallet.kua_kua_hb_srv.TopicMatchRequest;

public class RedPacketKuaKuaFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  public long a;
  protected ObjectAnimator a;
  private Handler jdField_a_of_type_AndroidOsHandler = new akyv(this);
  protected View a;
  protected Button a;
  public EditText a;
  protected ImageView a;
  protected TextView a;
  public SessionInfo a;
  public MessageForQQWalletMsg a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RedPacketKuaKuaFragment.6(this);
  protected String a;
  protected int b;
  public long b;
  public View b;
  protected Button b;
  protected TextView b;
  protected String b;
  public int c;
  public long c;
  public TextView c;
  public String c;
  protected TextView d;
  protected String d;
  
  public RedPacketKuaKuaFragment()
  {
    this.jdField_a_of_type_Long = 1L;
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  private String a()
  {
    return "{\"v\":\"5.3.1\",\"fr\":25,\"ip\":0,\"op\":35,\"w\":270,\"h\":270,\"nm\":\"预合成 3\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":3,\"ty\":4,\"nm\":\"“图层 6”轮廓 4\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":17,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":20,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":41,\"s\":[100,100],\"e\":[104,104]},{\"t\":44}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":19,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":39,\"s\":[10],\"e\":[0]},{\"t\":41}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":17,\"op\":44,\"st\":19,\"bm\":0},{\"ddd\":0,\"ind\":4,\"ty\":4,\"nm\":\"“图层 6”轮廓 3\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-20,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-17,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":4,\"s\":[100,100],\"e\":[104,104]},{\"t\":7}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":-18,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":2,\"s\":[10],\"e\":[0]},{\"t\":4}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":-20,\"op\":7,\"st\":-18,\"bm\":0},{\"ddd\":0,\"ind\":5,\"ty\":4,\"nm\":\"“图层 6”轮廓 2\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":33,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":36,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":57,\"s\":[100,100],\"e\":[104,104]},{\"t\":60}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":35,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":55,\"s\":[10],\"e\":[0]},{\"t\":57}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":33,\"op\":60,\"st\":35,\"bm\":0},{\"ddd\":0,\"ind\":6,\"ty\":4,\"nm\":\"“图层 6”轮廓\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-2,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":1,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":22,\"s\":[100,100],\"e\":[104,104]},{\"t\":25}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":0,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":20,\"s\":[10],\"e\":[0]},{\"t\":22}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":-2,\"op\":25,\"st\":0,\"bm\":0}],\"markers\":[]}";
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    akwt localakwt;
    do
    {
      return;
      Object localObject = new StringBuilder(50);
      ((StringBuilder)localObject).append("msgType=19").append("&isOffline=").append(false);
      long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByEmoji", ((StringBuilder)localObject).toString(), 0, null, SystemClock.uptimeMillis());
      localObject = (akwu)getActivity().app.getManager(125);
      localakwt = ((akwu)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
      ((akwu)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop);
      alil.a(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      Bundle localBundle = new Bundle();
      localBundle.putString("wishing", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title);
      localBundle.putString("answer", paramString);
      localBundle.putInt("channel", 1000002);
      localBundle.putString("matchToken", this.jdField_c_of_type_JavaLangString);
      ((akwu)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localakwt, l, 1000002, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.fromHBList, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localakwt.a + ",isPasswdRedBagFinish=" + localakwt.b + ",isPasswdRedBagOverDue=" + localakwt.c);
  }
  
  public kua_kua_hb_srv.TopicMatchRequest a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg == null)) {
      paramString1 = null;
    }
    kua_kua_hb_srv.TopicMatchRequest localTopicMatchRequest;
    do
    {
      return paramString1;
      localTopicMatchRequest = new kua_kua_hb_srv.TopicMatchRequest();
      localTopicMatchRequest.clientAttr.osType.set(0L);
      localTopicMatchRequest.clientAttr.qqVer.set("8.4.5");
      localTopicMatchRequest.clientAttr.skeyType.set(2L);
      if (!TextUtils.isEmpty(paramString1)) {
        localTopicMatchRequest.clientAttr.skey.set(paramString1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title))) {
        localTopicMatchRequest.hbTopic.set(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title);
      }
      if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()))) {
        localTopicMatchRequest.userAnswer.set(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)) {
        localTopicMatchRequest.hbListId.set(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localTopicMatchRequest.grapUin.set(paramString2);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin)) {
        localTopicMatchRequest.sendUin.set(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin);
      }
      localTopicMatchRequest.fromType.set(paramInt);
      paramString1 = localTopicMatchRequest;
    } while (TextUtils.isEmpty(paramString3));
    localTopicMatchRequest.groupId.set(paramString3);
    return localTopicMatchRequest;
  }
  
  public void a()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.makeHbExtend;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject((String)localObject);
        if (localObject != null) {
          this.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("kua_show");
        }
      }
      localObject = BaseHbFragment.getHbPannelConfig(15);
      if (localObject != null)
      {
        this.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("wordLimit");
        this.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("matchDelay");
        if (this.jdField_a_of_type_Long <= 0L) {
          this.jdField_a_of_type_Long = 1L;
        }
        if (this.jdField_b_of_type_Int == 0) {
          this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("downHint");
        }
        while (((JSONObject)localObject).has("kuaPrefix"))
        {
          this.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("kuaPrefix");
          return;
          if (this.jdField_b_of_type_Int == 1) {
            this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("upHint");
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)View.inflate(getActivity(), 2131562065, null));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)View.inflate(getActivity(), 2131562064, null));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)getActivity().findViewById(2131380233));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)getActivity().findViewById(2131380234));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)getActivity().findViewById(2131380274));
    this.jdField_b_of_type_AndroidViewView = getActivity().findViewById(2131368538);
    this.jdField_a_of_type_AndroidViewView = getActivity().findViewById(2131363852);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)getActivity().findViewById(2131368533));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)getActivity().findViewById(2131376557));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363765));
    alil.a(this.jdField_a_of_type_AndroidWidgetButton, 0.3F);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  protected void a(ImageView paramImageView)
  {
    String str = a();
    try
    {
      if ((!TextUtils.isEmpty(str)) && (paramImageView != null)) {
        LottieComposition.Factory.fromJsonString(str, new akyy(this, paramImageView));
      }
      return;
    }
    catch (Throwable paramImageView)
    {
      paramImageView.printStackTrace();
    }
  }
  
  public void a(TextView paramTextView1, LinearLayout.LayoutParams paramLayoutParams1, TextView paramTextView2, LinearLayout.LayoutParams paramLayoutParams2)
  {
    if ((b()) || (paramTextView1 == null) || (paramTextView2 == null)) {}
    LinearLayout localLinearLayout;
    do
    {
      return;
      localLinearLayout = (LinearLayout)getActivity().findViewById(2131379035);
    } while (localLinearLayout == null);
    localLinearLayout.addView(paramTextView1, paramLayoutParams1);
    localLinearLayout.addView(paramTextView2, paramLayoutParams2);
  }
  
  public void a(TextView paramTextView1, TextView paramTextView2, EditText paramEditText)
  {
    if ((paramTextView1 == null) || (paramTextView2 == null) || (paramEditText == null)) {}
    LinearLayout.LayoutParams localLayoutParams;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title)));
      paramTextView1.setText("【" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + "】");
      paramEditText = new LinearLayout.LayoutParams(-2, -2);
      paramEditText.gravity = 1;
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = agej.a(8.0F, getResources());
      localLayoutParams.gravity = 1;
      if (this.jdField_b_of_type_Int == 0)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          paramTextView2.setText(this.jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          a(paramTextView2, paramEditText, paramTextView1, localLayoutParams);
          return;
          paramTextView2.setText(getResources().getString(2131704871));
        }
      }
    } while (this.jdField_b_of_type_Int != 1);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      paramTextView2.setText(this.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      a(paramTextView1, paramEditText, paramTextView2, localLayoutParams);
      return;
      paramTextView2.setText(getResources().getString(2131704870));
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166575));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130847290);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.5F);
    this.jdField_b_of_type_AndroidViewView.setAlpha(0.5F);
    b(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
    d();
  }
  
  protected boolean a()
  {
    Object localObject = getArguments();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)((Bundle)localObject).getParcelable("session"));
      long l = ((Bundle)localObject).getLong("uniseq", 0L);
      this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("fromHBList", 0);
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject = ((Bundle)localObject).getString("redPacketId");
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = ((MessageForQQWalletMsg)aifz.a.get(localObject));
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg == null)) {
          break label294;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
          break;
        }
        break label294;
        localObject = getActivity().app.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
        if ((localObject instanceof MessageForQQWalletMsg)) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = ((MessageForQQWalletMsg)localObject);
        }
      }
      a();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      ThreadManager.getSubThreadHandler().post(new RedPacketKuaKuaFragment.2(this));
      return true;
    }
    a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetEditText);
    if (this.jdField_c_of_type_Int > 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText("0/" + this.jdField_c_of_type_Int);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jdField_c_of_type_Int) });
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new akyu(this));
      break;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label294:
    return false;
  }
  
  public void b()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166577));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(anzj.a(2131704867));
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130847285);
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    this.jdField_b_of_type_AndroidViewView.setAlpha(1.0F);
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidViewView.setClickable(true);
    c();
  }
  
  protected void b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof LottieDrawable)) {
        ((LottieDrawable)paramImageView).stop();
      }
    }
  }
  
  public boolean b()
  {
    return (getActivity() == null) || (getActivity().isFinishing());
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    int i = bhgr.a(getActivity(), 75.0F);
    int j = bhgr.a(getActivity(), 75.0F);
    this.jdField_b_of_type_AndroidViewView.setPivotX(i / 2);
    this.jdField_b_of_type_AndroidViewView.setPivotY(j / 2 + bhgr.a(getActivity(), 15.0F));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "rotation", new float[] { -5.0F, 20.0F });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatMode(2);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new akyz(this));
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) && (this.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
    }
  }
  
  public void e()
  {
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      e();
      continue;
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      bdll.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "kuakua.get.cancel", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title, "", "", "");
      continue;
      if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())))
      {
        if (!b()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("RedPacketKuaKuaFragment", 2, "getActivity() == null || getActivity().isFinishing()");
        }
      }
    }
    b(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
    label523:
    for (;;)
    {
      String str;
      try
      {
        str = bhlg.c(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, true);
        if (this.jdField_d_of_type_JavaLangString != null) {
          break label375;
        }
        this.jdField_d_of_type_JavaLangString = (asle.b(36) + str + "，");
        str = this.jdField_d_of_type_JavaLangString + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label523;
        }
        ArrayList localArrayList = new ArrayList();
        str = bgme.a(new SpannableString(str), localArrayList);
        aean.a(getActivity().app, getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str, localArrayList);
        bdll.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "kuakua.get.open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title, "", "", "");
        e();
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
      break;
      label375:
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        if (j < 100)
        {
          int k = this.jdField_d_of_type_JavaLangString.indexOf("%[");
          int m = this.jdField_d_of_type_JavaLangString.indexOf("]%");
          if ((k >= 0) && (m > k)) {
            for (;;)
            {
              for (;;)
              {
                try
                {
                  i = Integer.valueOf(this.jdField_d_of_type_JavaLangString.substring(k + 2, m)).intValue();
                }
                catch (Throwable localThrowable3)
                {
                  boolean bool;
                  int i = 36;
                  continue;
                }
                try
                {
                  bool = asle.c(i);
                  if (!bool) {
                    i = 36;
                  }
                  this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.replace(this.jdField_d_of_type_JavaLangString.substring(k, m + 2), asle.b(i));
                  j += 1;
                }
                catch (Throwable localThrowable2) {}
              }
              localThrowable1.printStackTrace();
            }
          }
        }
        this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.replace("%s", str);
        continue;
        aean.a(getActivity().app, getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str, null);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = null;
    try
    {
      paramLayoutInflater = paramLayoutInflater.inflate(2131562063, paramViewGroup, false);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
    catch (Throwable paramLayoutInflater)
    {
      for (;;)
      {
        paramLayoutInflater.printStackTrace();
        e();
        paramLayoutInflater = paramBundle;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      if ((localDrawable instanceof LottieDrawable)) {
        ((LottieDrawable)localDrawable).recycleBitmaps();
      }
    }
    d();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    try
    {
      a(paramView);
      if (!a()) {
        e();
      }
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("RedPacketKuaKuaFragment", 1, paramView, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKuaKuaFragment
 * JD-Core Version:    0.7.0.1
 */