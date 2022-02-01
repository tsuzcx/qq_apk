package com.tencent.mobileqq.activity.qwallet;

import acvv;
import ahcp;
import ajuk;
import ajul;
import ajwl;
import ajwm;
import ajwn;
import ajwq;
import ajwr;
import akgd;
import amtj;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bcef;
import bevq;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import tencent.im.qqwallet.kua_kua_hb_srv.ClientAttr;
import tencent.im.qqwallet.kua_kua_hb_srv.TopicMatchRequest;

public class RedPacketKuaKuaFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 1L;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler = new ajwn(this);
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private MessageForQQWalletMsg jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RedPacketKuaKuaFragment.7(this);
  private String jdField_a_of_type_JavaLangString;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private long jdField_c_of_type_Long;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  
  private String a()
  {
    return "{\"v\":\"5.3.1\",\"fr\":25,\"ip\":0,\"op\":35,\"w\":270,\"h\":270,\"nm\":\"预合成 3\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":3,\"ty\":4,\"nm\":\"“图层 6”轮廓 4\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":17,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":20,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":41,\"s\":[100,100],\"e\":[104,104]},{\"t\":44}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":19,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":39,\"s\":[10],\"e\":[0]},{\"t\":41}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":17,\"op\":44,\"st\":19,\"bm\":0},{\"ddd\":0,\"ind\":4,\"ty\":4,\"nm\":\"“图层 6”轮廓 3\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-20,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-17,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":4,\"s\":[100,100],\"e\":[104,104]},{\"t\":7}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":-18,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":2,\"s\":[10],\"e\":[0]},{\"t\":4}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":-20,\"op\":7,\"st\":-18,\"bm\":0},{\"ddd\":0,\"ind\":5,\"ty\":4,\"nm\":\"“图层 6”轮廓 2\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":33,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":36,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":57,\"s\":[100,100],\"e\":[104,104]},{\"t\":60}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":35,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":55,\"s\":[10],\"e\":[0]},{\"t\":57}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":33,\"op\":60,\"st\":35,\"bm\":0},{\"ddd\":0,\"ind\":6,\"ty\":4,\"nm\":\"“图层 6”轮廓\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[135,136,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[135,135,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[-71.797,0],[0,71.797],[71.797,0],[0,-71.797]],\"o\":[[71.797,0],[0,-71.797],[-71.797,0],[0,71.797]],\"v\":[[0,130],[130,0],[0,-130],[-130,0]],\"c\":true},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"fl\",\"c\":{\"a\":0,\"k\":[1,0.949019670486,0.701960802078,1],\"ix\":4},\"o\":{\"a\":0,\"k\":100,\"ix\":5},\"r\":1,\"nm\":\"填充 1\",\"mn\":\"ADBE Vector Graphic - Fill\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[135,135],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":-2,\"s\":[69,69],\"e\":[75,75]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":1,\"s\":[75,75],\"e\":[100,100]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":22,\"s\":[100,100],\"e\":[104,104]},{\"t\":25}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":0,\"s\":[75],\"e\":[10]},{\"i\":{\"x\":[0.833],\"y\":[0.833]},\"o\":{\"x\":[0.167],\"y\":[0.167]},\"n\":[\"0p833_0p833_0p167_0p167\"],\"t\":20,\"s\":[10],\"e\":[0]},{\"t\":22}],\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":2,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":-2,\"op\":25,\"st\":0,\"bm\":0}],\"markers\":[]}";
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    ajuk localajuk;
    do
    {
      return;
      Object localObject = new StringBuilder(50);
      ((StringBuilder)localObject).append("msgType=19").append("&isOffline=").append(false);
      long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByEmoji", ((StringBuilder)localObject).toString(), 0, null, SystemClock.uptimeMillis());
      localObject = (ajul)getActivity().app.getManager(125);
      localajuk = ((ajul)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
      ((ajul)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop);
      akgd.a(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      Bundle localBundle = new Bundle();
      localBundle.putString("wishing", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title);
      localBundle.putString("answer", paramString);
      localBundle.putInt("channel", 1000002);
      localBundle.putString("matchToken", this.jdField_c_of_type_JavaLangString);
      ((ajul)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localajuk, l, 1000002, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.fromHBList, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localajuk.a + ",isPasswdRedBagFinish=" + localajuk.b + ",isPasswdRedBagOverDue=" + localajuk.c);
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
      localTopicMatchRequest.clientAttr.qqVer.set("8.4.8");
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
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 74	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg	Lcom/tencent/mobileqq/data/MessageForQQWalletMsg;
    //   6: getfield 148	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   9: getfield 314	com/tencent/mobileqq/data/QQWalletRedPacketMsg:body	Lcom/tencent/mobileqq/data/QQWalletAioBodyReserve;
    //   12: getfield 319	com/tencent/mobileqq/data/QQWalletAioBodyReserve:makeHbExtend	Ljava/lang/String;
    //   15: astore 4
    //   17: ldc 33
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload 4
    //   24: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifne +30 -> 57
    //   30: new 321	org/json/JSONObject
    //   33: dup
    //   34: aload 4
    //   36: invokespecial 323	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   39: astore 4
    //   41: aload_3
    //   42: astore_2
    //   43: aload 4
    //   45: ifnull +12 -> 57
    //   48: aload 4
    //   50: ldc_w 325
    //   53: invokevirtual 329	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_2
    //   57: bipush 15
    //   59: invokestatic 335	com/tencent/mobileqq/activity/qwallet/fragment/BaseHbFragment:getHbPannelConfig	(I)Lorg/json/JSONObject;
    //   62: astore_3
    //   63: aload_3
    //   64: ifnull +292 -> 356
    //   67: aload_0
    //   68: aload_3
    //   69: ldc_w 337
    //   72: invokevirtual 341	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   75: putfield 343	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   78: iload_1
    //   79: aload_0
    //   80: getfield 343	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   83: invokevirtual 349	org/json/JSONArray:length	()I
    //   86: if_icmpge +125 -> 211
    //   89: aload_0
    //   90: getfield 343	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   93: iload_1
    //   94: invokevirtual 352	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   97: astore 4
    //   99: aload 4
    //   101: ldc_w 354
    //   104: invokevirtual 329	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 5
    //   109: aload 5
    //   111: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifne +85 -> 199
    //   117: aload_2
    //   118: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   121: ifne +78 -> 199
    //   124: aload 5
    //   126: aload_2
    //   127: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: ifeq +69 -> 199
    //   133: aload_0
    //   134: aload 4
    //   136: ldc_w 362
    //   139: invokevirtual 329	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   142: putfield 364	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   145: aload_0
    //   146: getfield 364	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   149: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   152: ifne +14 -> 166
    //   155: aload_0
    //   156: getfield 366	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   159: aload_0
    //   160: getfield 364	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   163: invokevirtual 372	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   166: aload_0
    //   167: aload 4
    //   169: ldc_w 374
    //   172: invokevirtual 329	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   175: putfield 376	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   178: aload_0
    //   179: getfield 376	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   182: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifne +14 -> 199
    //   188: aload_0
    //   189: getfield 65	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   192: aload_0
    //   193: getfield 376	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   196: invokevirtual 379	android/widget/EditText:setHint	(Ljava/lang/CharSequence;)V
    //   199: iload_1
    //   200: iconst_1
    //   201: iadd
    //   202: istore_1
    //   203: goto -125 -> 78
    //   206: astore_2
    //   207: aload_2
    //   208: invokevirtual 382	java/lang/Throwable:printStackTrace	()V
    //   211: aload_0
    //   212: aload_3
    //   213: ldc_w 384
    //   216: invokevirtual 388	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   219: putfield 51	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_b_of_type_Int	I
    //   222: aload_0
    //   223: getfield 51	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_b_of_type_Int	I
    //   226: ifle +113 -> 339
    //   229: aload_0
    //   230: getfield 68	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   233: new 90	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 390
    //   243: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_0
    //   247: getfield 51	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_b_of_type_Int	I
    //   250: invokevirtual 393	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokevirtual 372	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   259: aload_0
    //   260: getfield 68	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   263: iconst_0
    //   264: invokevirtual 396	android/widget/TextView:setVisibility	(I)V
    //   267: aload_0
    //   268: getfield 65	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   271: iconst_1
    //   272: anewarray 398	android/text/InputFilter
    //   275: dup
    //   276: iconst_0
    //   277: new 400	android/text/InputFilter$LengthFilter
    //   280: dup
    //   281: aload_0
    //   282: getfield 51	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_b_of_type_Int	I
    //   285: invokespecial 401	android/text/InputFilter$LengthFilter:<init>	(I)V
    //   288: aastore
    //   289: invokevirtual 405	android/widget/EditText:setFilters	([Landroid/text/InputFilter;)V
    //   292: aload_0
    //   293: aload_3
    //   294: ldc_w 407
    //   297: invokevirtual 411	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   300: putfield 31	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_a_of_type_Long	J
    //   303: aload_0
    //   304: getfield 31	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_a_of_type_Long	J
    //   307: lconst_0
    //   308: lcmp
    //   309: ifgt +8 -> 317
    //   312: aload_0
    //   313: lconst_1
    //   314: putfield 31	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_a_of_type_Long	J
    //   317: aload_3
    //   318: ldc_w 413
    //   321: invokevirtual 417	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   324: ifeq +32 -> 356
    //   327: aload_0
    //   328: aload_3
    //   329: ldc_w 413
    //   332: invokevirtual 329	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   335: putfield 419	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   338: return
    //   339: aload_0
    //   340: getfield 68	com/tencent/mobileqq/activity/qwallet/RedPacketKuaKuaFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   343: bipush 8
    //   345: invokevirtual 396	android/widget/TextView:setVisibility	(I)V
    //   348: goto -56 -> 292
    //   351: astore_2
    //   352: aload_2
    //   353: invokevirtual 420	java/lang/Exception:printStackTrace	()V
    //   356: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	RedPacketKuaKuaFragment
    //   1	202	1	i	int
    //   21	106	2	localObject1	Object
    //   206	2	2	localThrowable	Throwable
    //   351	2	2	localException	Exception
    //   19	310	3	localObject2	Object
    //   15	153	4	localObject3	Object
    //   107	18	5	str	String
    // Exception table:
    //   from	to	target	type
    //   78	166	206	java/lang/Throwable
    //   166	199	206	java/lang/Throwable
    //   2	17	351	java/lang/Exception
    //   22	41	351	java/lang/Exception
    //   48	57	351	java/lang/Exception
    //   57	63	351	java/lang/Exception
    //   67	78	351	java/lang/Exception
    //   78	166	351	java/lang/Exception
    //   166	199	351	java/lang/Exception
    //   207	211	351	java/lang/Exception
    //   211	292	351	java/lang/Exception
    //   292	317	351	java/lang/Exception
    //   317	338	351	java/lang/Exception
    //   339	348	351	java/lang/Exception
  }
  
  protected void a(View paramView)
  {
    ((LinearLayout)getActivity().findViewById(2131366945)).setOnClickListener(new ajwl(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getActivity().findViewById(2131380013));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)getActivity().findViewById(2131380012));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)getActivity().findViewById(2131379961));
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)getActivity().findViewById(2131379962));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)getActivity().findViewById(2131380001));
    this.jdField_b_of_type_AndroidViewView = getActivity().findViewById(2131368563);
    this.jdField_a_of_type_AndroidViewView = getActivity().findViewById(2131363878);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)getActivity().findViewById(2131368558));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)getActivity().findViewById(2131376323));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363794));
    akgd.a(this.jdField_a_of_type_AndroidWidgetButton, 0.3F);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  protected void a(ImageView paramImageView)
  {
    String str = a();
    try
    {
      if ((!TextUtils.isEmpty(str)) && (paramImageView != null)) {
        LottieComposition.Factory.fromJsonString(str, new ajwq(this, paramImageView));
      }
      return;
    }
    catch (Throwable paramImageView)
    {
      paramImageView.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166594));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130847198);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.5F);
    this.jdField_b_of_type_AndroidViewView.setAlpha(0.5F);
    b(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
    d();
  }
  
  protected boolean a()
  {
    Object localObject = getArguments();
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)((Bundle)localObject).getParcelable("session"));
        long l = ((Bundle)localObject).getLong("uniseq", 0L);
        this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("fromHBList", 0);
        if (this.jdField_a_of_type_Int == 1)
        {
          localObject = ((Bundle)localObject).getString("redPacketId");
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = ((MessageForQQWalletMsg)ahcp.a.get(localObject));
          if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg == null)) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem == null) {
            break;
          }
        }
        else
        {
          localObject = getActivity().app.getMessageFacade().queryMsgItemByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, l);
          if (!(localObject instanceof MessageForQQWalletMsg)) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = ((MessageForQQWalletMsg)localObject);
          continue;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText("【" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + "】");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        ThreadManager.getSubThreadHandler().post(new RedPacketKuaKuaFragment.3(this));
        return true;
      }
      a();
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ajwm(this));
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166596));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(amtj.a(2131705097));
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130847193);
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    this.jdField_b_of_type_AndroidViewView.setAlpha(1.0F);
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidViewView.setClickable(true);
    c();
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
    }
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
    int i = DisplayUtil.dip2px(getActivity(), 75.0F);
    int j = DisplayUtil.dip2px(getActivity(), 75.0F);
    this.jdField_b_of_type_AndroidViewView.setPivotX(i / 2);
    this.jdField_b_of_type_AndroidViewView.setPivotY(j / 2 + DisplayUtil.dip2px(getActivity(), 15.0F));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "rotation", new float[] { -5.0F, 20.0F });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatMode(2);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new ajwr(this));
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
      bcef.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "kuakua.get.cancel", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title, "", "", "");
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
        str = ContactUtils.getBuddyNickName(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, true);
        if (this.jdField_d_of_type_JavaLangString != null) {
          break label375;
        }
        this.jdField_d_of_type_JavaLangString = (QQSysFaceUtil.getFaceString(36) + str + "，");
        str = this.jdField_d_of_type_JavaLangString + this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1) {
          break label523;
        }
        ArrayList localArrayList = new ArrayList();
        str = bevq.a(new SpannableString(str), localArrayList);
        acvv.a(getActivity().app, getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str, localArrayList);
        bcef.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "kuakua.get.open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title, "", "", "");
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
                  bool = QQSysFaceUtil.isValidFaceId(i);
                  if (!bool) {
                    i = 36;
                  }
                  this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.replace(this.jdField_d_of_type_JavaLangString.substring(k, m + 2), QQSysFaceUtil.getFaceString(i));
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
        acvv.a(getActivity().app, getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str, null);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = null;
    try
    {
      paramLayoutInflater = paramLayoutInflater.inflate(2131561940, paramViewGroup, false);
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
      paramBundle = getActivity();
      getActivity();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)paramBundle.getSystemService("input_method"));
      getActivity().getWindow().setSoftInputMode(5);
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