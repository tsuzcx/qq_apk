package com.tencent.mobileqq.activity.qwallet;

import adky;
import aipv;
import aipw;
import aira;
import airb;
import airc;
import aird;
import aitd;
import aivy;
import ajaf;
import alpo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import azmj;
import baul;
import bcvq;
import bdbt;
import bkik;
import bkwh;
import bkwi;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import dov.com.qq.im.ae.SessionWrap;
import java.util.LinkedList;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
import xlb;

public class RedPacketEmojiFragment
  extends RedPacketPopFragment
{
  public static final String[] a;
  public int a;
  public Bundle a;
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  public String a;
  public int b;
  public Button b;
  public ImageView b;
  public TextView b;
  public String b;
  public ImageView c;
  public TextView c;
  public String c;
  private int jdField_d_of_type_Int;
  public ImageView d;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { alpo.a(2131713681), alpo.a(2131713698), alpo.a(2131713688) };
  }
  
  public RedPacketEmojiFragment()
  {
    this.jdField_a_of_type_JavaLangString = "https://i.gtimg.cn/channel/imglib/201906/upload_9c25c90bf492d21e9796f96ddab01809.json";
    this.jdField_b_of_type_Int = -1;
    this.jdField_e_of_type_JavaLangString = "http://i.gtimg.cn/channel/static/expression/";
  }
  
  private static int a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    try
    {
      i = Integer.parseInt(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId);
      int j;
      if (i >= 0)
      {
        j = i;
        if (i < 200) {}
      }
      else
      {
        j = 0;
      }
      return j;
    }
    catch (Throwable paramMessageForQQWalletMsg)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  private Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10022);
    localBundle.putInt("key_ability_flag", 3);
    localBundle.putInt("emoji_capture_tag", hashCode());
    localBundle.putInt("emoji_feeds_id", this.jdField_a_of_type_Int);
    localBundle.putInt("emoji_combo_id", this.jdField_d_of_type_Int);
    if (this.jdField_b_of_type_Int != -1) {
      localBundle.putInt("emoji_threshold", this.jdField_b_of_type_Int);
    }
    localBundle.putString("emoji_face_config_path", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("emoji_hand_res_folder_path", this.jdField_c_of_type_JavaLangString);
    return localBundle;
  }
  
  public static String a()
  {
    return "{\"v\":\"5.3.1\",\"fr\":30,\"ip\":0,\"op\":30,\"w\":210,\"h\":210,\"nm\":\"“图层 2”轮廓 合成 1\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":1,\"ty\":4,\"nm\":\"“图层 2”轮廓\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[106,102,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[87.5,87.5,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[-65.455,80],[-80,80],[-79.868,65.454]],\"c\":false},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":1,\"ty\":\"sh\",\"ix\":2,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[-79.371,-65.455],[-80,-80],[-65.455,-80]],\"c\":false},\"ix\":2},\"nm\":\"路径 2\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":2,\"ty\":\"sh\",\"ix\":3,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[65.454,-80],[80,-80],[80,-65.455]],\"c\":false},\"ix\":2},\"nm\":\"路径 3\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":3,\"ty\":\"sh\",\"ix\":4,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[80,65.454],[80,80],[67.636,80]],\"c\":false},\"ix\":2},\"nm\":\"路径 4\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"mm\",\"mm\":1,\"nm\":\"合并路径 1\",\"mn\":\"ADBE Vector Filter - Merge\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[1,0.862999949736,0.675,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":3,\"ix\":5},\"lc\":2,\"lj\":2,\"nm\":\"描边 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[87.5,87.5],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":0,\"s\":[100,100],\"e\":[110,110]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":10,\"s\":[110,110],\"e\":[108,108]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":15,\"s\":[108,108],\"e\":[110,110]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":20,\"s\":[110,110],\"e\":[100,100]},{\"t\":30}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":6,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":2700,\"st\":0,\"bm\":0}],\"markers\":[]}";
  }
  
  public static void a(Context paramContext, BaseChatPie paramBaseChatPie, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if ((paramBaseChatPie == null) || (paramMessageForQQWalletMsg == null)) {
      return;
    }
    Intent localIntent = new Intent();
    SessionInfo localSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    localIntent.putExtra("session", localSessionInfo);
    localIntent.putExtra("uniseq", paramMessageForQQWalletMsg.uniseq);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("fromHBList", paramMessageForQQWalletMsg.fromHBList);
    localIntent.putExtra("redPacketId", paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramMessageForQQWalletMsg = null;
    if (localSessionInfo != null) {
      paramMessageForQQWalletMsg = new SessionWrap(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_d_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, localSessionInfo.jdField_b_of_type_JavaLangString);
    }
    localIntent.putExtra("KEY_CAMERA_BUNDLE", bkik.a(paramMessageForQQWalletMsg, paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getClass().getName(), 10000, 100));
    adky.a(paramContext, localIntent, PublicTransFragmentActivity.class, RedPacketEmojiFragment.class);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if ((paramQQAppInterface == null) || (paramMessageForQQWalletMsg == null)) {}
    for (;;)
    {
      return;
      try
      {
        if ((paramMessageForQQWalletMsg.messageType == 19) && (!TextUtils.isEmpty(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId))) {
          if (a(a(paramMessageForQQWalletMsg)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("RedPacketEmojiFragment", 2, "preload AE_RES_BASE_PACKAGE");
            }
            bkwi.a().a(bkwh.b, null, false);
            return;
          }
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("RedPacketEmojiFragment", 1, paramQQAppInterface, new Object[0]);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "preload AE_RES_ADDITIONAL_PACKAGE");
    }
    bkwi.a().a(bkwh.c, null, false);
  }
  
  private void a(String paramString)
  {
    paramString = new StringBuilder(50);
    paramString.append("msgType=19").append("&isOffline=").append(false);
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByEmoji", paramString.toString(), 0, null, SystemClock.uptimeMillis());
    paramString = (aipw)getActivity().app.getManager(125);
    aipv localaipv = paramString.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
    paramString.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop);
    ajaf.a(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    paramString.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaipv, l, 262144, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.fromHBList, null);
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localaipv.a + ",isPasswdRedBagFinish=" + localaipv.b + ",isPasswdRedBagOverDue=" + localaipv.c);
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt >= 100;
  }
  
  private void e()
  {
    Object localObject = ((aitd)getActivity().app.getManager(245)).a("redPackPanel", "", new String[] { "panelRedPkgList" });
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
        if ((localJSONObject != null) && (localJSONObject.optInt("type") == 8))
        {
          if (QLog.isColorLevel()) {
            QLog.i("RedPacketEmojiFragment", 2, "initConfig emoji id:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId + "emoji config jo:" + localJSONObject.toString());
          }
          localObject = localJSONObject.optJSONObject("params");
          if (localObject == null) {
            break;
          }
          this.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).optString("prefix", "http://i.gtimg.cn/channel/static/expression/");
          this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("aEConfig", "https://i.gtimg.cn/channel/imglib/201906/upload_9c25c90bf492d21e9796f96ddab01809.json");
          localObject = ((JSONObject)localObject).getJSONArray("heartList");
          if (localObject == null) {
            break;
          }
          i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            localJSONObject = ((JSONArray)localObject).optJSONObject(i);
            if ((localJSONObject != null) && (localJSONObject.optInt("rId") == Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId)))
            {
              this.jdField_d_of_type_JavaLangString = localJSONObject.optString("md5");
              JSONArray localJSONArray = localJSONObject.optJSONArray("eId");
              if (localJSONArray != null)
              {
                int j = localJSONArray.length();
                if (j > 0) {
                  this.jdField_d_of_type_Int = localJSONArray.optInt(new Random().nextInt(j + 0) + 0);
                }
              }
              this.jdField_b_of_type_Int = localJSONObject.optInt("aThreshold", -1);
            }
            i += 1;
          }
        }
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "doLoading");
    }
    int i = new Random().nextInt(3);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(jdField_a_of_type_ArrayOfJavaLangString[(i + 0)]);
    Object localObject = getResources().getDrawable(2130843040);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    ((Animatable)localObject).start();
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    if (!a(this.jdField_a_of_type_Int))
    {
      long l = System.currentTimeMillis();
      bkwi.a().a(bkwh.c, new airc(this, l), false);
      return;
    }
    localObject = new LinkedList();
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.url = this.jdField_a_of_type_JavaLangString;
    localDownloadParam.filePos = 1;
    ((LinkedList)localObject).add(localDownloadParam);
    PreloadManager.a().a(localDownloadParam, new aird(this));
  }
  
  private void g()
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      if ((getActivity() != null) && (!getActivity().isFinishing())) {
        xlb.a().a(getActivity(), a(this.jdField_a_of_type_AndroidOsBundle), 1);
      }
      return;
    }
    QQToast.a(getActivity(), "请使用高于4.3.0及以上的安卓版本体验哦~", 1).a();
  }
  
  private void h()
  {
    EmojiGifHelper.getInstance().trySendPicToAIO(hashCode());
  }
  
  public void a()
  {
    Object localObject = this.jdField_e_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId + ".png";
    Drawable localDrawable = baul.a;
    localObject = QWalletPicHelper.getNetDrawableForQWallet((String)localObject, localDrawable, localDrawable, this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    if (localObject != null)
    {
      ((URLDrawable)localObject).setURLDrawableListener(new airb(this));
      if (((URLDrawable)localObject).getStatus() == 1) {
        d();
      }
      while ((((URLDrawable)localObject).getStatus() == 1) || (((URLDrawable)localObject).getStatus() == 0)) {
        return;
      }
      ((URLDrawable)localObject).restartDownload();
      return;
    }
    b();
  }
  
  protected void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "initUI");
    }
    super.a(paramView);
    ((ViewStub)paramView.findViewById(2131377109)).inflate();
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363881));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368089));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368145));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379099));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379119));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379095));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363690));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369173);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368123));
    a(this.jdField_c_of_type_AndroidWidgetImageView);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368139));
    paramView = a();
    if (!TextUtils.isEmpty(paramView)) {
      LottieComposition.Factory.fromJsonString(paramView, new aira(this));
    }
  }
  
  protected boolean a()
  {
    if (!super.a()) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "initParams");
    }
    this.jdField_e_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130842978));
    String str = bdbt.b(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, true);
    str = ajaf.a(getActivity(), str, 135.0F, this.jdField_d_of_type_AndroidWidgetTextView.getPaint());
    this.jdField_d_of_type_AndroidWidgetTextView.setText(str + alpo.a(2131713708));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title);
    azmj.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.popup.show", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidOsBundle = getArguments().getBundle("KEY_CAMERA_BUNDLE");
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    ajaf.a(this.jdField_a_of_type_AndroidWidgetButton, 0.3F);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnTouchListener(ajaf.a(0.7F));
    EmojiGifHelper.getInstance().bind(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, hashCode());
    e();
    this.jdField_a_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    f();
    bcvq.a(this.jdField_a_of_type_AndroidWidgetButton, alpo.a(2131713702));
    return true;
  }
  
  public void b()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void c()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    f();
  }
  
  public void d()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131713674));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      a("sss");
      h();
      getActivity().finish();
    }
  }
  
  public boolean onBackEvent()
  {
    azmj.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.popup.back", 0, 0, "", "", "", "");
    EmojiGifHelper.getInstance().unbind(hashCode());
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363881: 
      azmj.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.popup.click", 0, 0, "", "", "", "");
      g();
      return;
    }
    c();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b(this.jdField_c_of_type_AndroidWidgetImageView);
    b(this.jdField_d_of_type_AndroidWidgetImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment
 * JD-Core Version:    0.7.0.1
 */