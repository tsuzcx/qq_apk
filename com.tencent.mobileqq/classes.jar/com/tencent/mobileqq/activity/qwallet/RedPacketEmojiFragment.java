package com.tencent.mobileqq.activity.qwallet;

import akqd;
import akqe;
import akro;
import akrp;
import akrq;
import akrr;
import aktz;
import akxe;
import albw;
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
import anvx;
import bdla;
import bgyd;
import bnkt;
import bnku;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.LinkedList;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
import zcf;

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
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { anvx.a(2131712760), anvx.a(2131712777), anvx.a(2131712767) };
  }
  
  public RedPacketEmojiFragment()
  {
    this.jdField_a_of_type_JavaLangString = "https://i.gtimg.cn/channel/imglib/201906/upload_9c25c90bf492d21e9796f96ddab01809.json";
    this.jdField_b_of_type_Int = -1;
    this.jdField_e_of_type_JavaLangString = "https://i.gtimg.cn/channel/static/expression/";
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
    if (this.jdField_b_of_type_Int != -1) {}
    return localBundle;
  }
  
  public static String a()
  {
    return "{\"v\":\"5.3.1\",\"fr\":30,\"ip\":0,\"op\":30,\"w\":210,\"h\":210,\"nm\":\"“图层 2”轮廓 合成 1\",\"ddd\":0,\"assets\":[],\"layers\":[{\"ddd\":0,\"ind\":1,\"ty\":4,\"nm\":\"“图层 2”轮廓\",\"sr\":1,\"ks\":{\"o\":{\"a\":0,\"k\":100,\"ix\":11},\"r\":{\"a\":0,\"k\":0,\"ix\":10},\"p\":{\"a\":0,\"k\":[106,102,0],\"ix\":2},\"a\":{\"a\":0,\"k\":[87.5,87.5,0],\"ix\":1},\"s\":{\"a\":0,\"k\":[100,100,100],\"ix\":6}},\"ao\":0,\"shapes\":[{\"ty\":\"gr\",\"it\":[{\"ind\":0,\"ty\":\"sh\",\"ix\":1,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[-65.455,80],[-80,80],[-79.868,65.454]],\"c\":false},\"ix\":2},\"nm\":\"路径 1\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":1,\"ty\":\"sh\",\"ix\":2,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[-79.371,-65.455],[-80,-80],[-65.455,-80]],\"c\":false},\"ix\":2},\"nm\":\"路径 2\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":2,\"ty\":\"sh\",\"ix\":3,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[65.454,-80],[80,-80],[80,-65.455]],\"c\":false},\"ix\":2},\"nm\":\"路径 3\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ind\":3,\"ty\":\"sh\",\"ix\":4,\"ks\":{\"a\":0,\"k\":{\"i\":[[0,0],[0,0],[0,0]],\"o\":[[0,0],[0,0],[0,0]],\"v\":[[80,65.454],[80,80],[67.636,80]],\"c\":false},\"ix\":2},\"nm\":\"路径 4\",\"mn\":\"ADBE Vector Shape - Group\",\"hd\":false},{\"ty\":\"mm\",\"mm\":1,\"nm\":\"合并路径 1\",\"mn\":\"ADBE Vector Filter - Merge\",\"hd\":false},{\"ty\":\"st\",\"c\":{\"a\":0,\"k\":[1,0.862999949736,0.675,1],\"ix\":3},\"o\":{\"a\":0,\"k\":100,\"ix\":4},\"w\":{\"a\":0,\"k\":3,\"ix\":5},\"lc\":2,\"lj\":2,\"nm\":\"描边 1\",\"mn\":\"ADBE Vector Graphic - Stroke\",\"hd\":false},{\"ty\":\"tr\",\"p\":{\"a\":0,\"k\":[87.5,87.5],\"ix\":2},\"a\":{\"a\":0,\"k\":[0,0],\"ix\":1},\"s\":{\"a\":1,\"k\":[{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":0,\"s\":[100,100],\"e\":[110,110]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":10,\"s\":[110,110],\"e\":[108,108]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":15,\"s\":[108,108],\"e\":[110,110]},{\"i\":{\"x\":[0.833,0.833],\"y\":[0.833,0.833]},\"o\":{\"x\":[0.167,0.167],\"y\":[0.167,0.167]},\"n\":[\"0p833_0p833_0p167_0p167\",\"0p833_0p833_0p167_0p167\"],\"t\":20,\"s\":[110,110],\"e\":[100,100]},{\"t\":30}],\"ix\":3},\"r\":{\"a\":0,\"k\":0,\"ix\":6},\"o\":{\"a\":0,\"k\":100,\"ix\":7},\"sk\":{\"a\":0,\"k\":0,\"ix\":4},\"sa\":{\"a\":0,\"k\":0,\"ix\":5},\"nm\":\"变换\"}],\"nm\":\"组 1\",\"np\":6,\"cix\":2,\"ix\":1,\"mn\":\"ADBE Vector Group\",\"hd\":false}],\"ip\":0,\"op\":2700,\"st\":0,\"bm\":0}],\"markers\":[]}";
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
            bnku.a().a(bnkt.b, null, false);
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
    bnku.a().a(bnkt.c, null, false);
  }
  
  private void a(String paramString)
  {
    paramString = new StringBuilder(50);
    paramString.append("msgType=19").append("&isOffline=").append(false);
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByEmoji", paramString.toString(), 0, null, SystemClock.uptimeMillis());
    paramString = (akqe)getActivity().app.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
    akqd localakqd = paramString.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
    paramString.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop);
    albw.a(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    paramString.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localakqd, l, 262144, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.fromHBList, null);
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localakqd.a + ",isPasswdRedBagFinish=" + localakqd.b + ",isPasswdRedBagOverDue=" + localakqd.c);
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt >= 100;
  }
  
  private void e()
  {
    Object localObject = ((aktz)getActivity().app.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER)).a("redPackPanel", "", new String[] { "panelRedPkgList" });
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
          this.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).optString("prefix", "https://i.gtimg.cn/channel/static/expression/");
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
    Object localObject = getResources().getDrawable(2130843517);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    ((Animatable)localObject).start();
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    if (!a(this.jdField_a_of_type_Int))
    {
      long l = System.currentTimeMillis();
      bnku.a().a(bnkt.c, new akrq(this, l), false);
      return;
    }
    localObject = new LinkedList();
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.url = this.jdField_a_of_type_JavaLangString;
    localDownloadParam.filePos = 1;
    ((LinkedList)localObject).add(localDownloadParam);
    PreloadManager.a().a(localDownloadParam, new akrr(this));
  }
  
  private void g()
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      if ((getActivity() != null) && (!getActivity().isFinishing())) {
        zcf.a().a(getActivity(), a(this.jdField_a_of_type_AndroidOsBundle), 1);
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
    Drawable localDrawable = URLDrawableHelper.TRANSPARENT;
    localObject = QWalletPicHelper.getNetDrawableForQWallet((String)localObject, localDrawable, localDrawable, this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    if (localObject != null)
    {
      ((URLDrawable)localObject).setURLDrawableListener(new akrp(this));
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
    ((ViewStub)paramView.findViewById(2131378182)).inflate();
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131364224));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368682));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368739));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380331));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380347));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380329));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131364019));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369834);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368716));
    a(this.jdField_c_of_type_AndroidWidgetImageView);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368733));
    paramView = a();
    if (!TextUtils.isEmpty(paramView)) {
      LottieComposition.Factory.fromJsonString(paramView, new akro(this));
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
    this.jdField_e_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130843456));
    String str = ContactUtils.getBuddyName(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, true);
    str = albw.a(getActivity(), str, 135.0F, this.jdField_d_of_type_AndroidWidgetTextView.getPaint());
    this.jdField_d_of_type_AndroidWidgetTextView.setText(str + anvx.a(2131712787));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title);
    bdla.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.popup.show", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidOsBundle = getArguments().getBundle("KEY_CAMERA_BUNDLE");
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    albw.a(this.jdField_a_of_type_AndroidWidgetButton, 0.3F);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnTouchListener(albw.a(0.7F));
    EmojiGifHelper.getInstance().bind(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, hashCode());
    e();
    this.jdField_a_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    f();
    bgyd.a(this.jdField_a_of_type_AndroidWidgetButton, anvx.a(2131712781));
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
    this.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131712753));
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
    bdla.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.popup.back", 0, 0, "", "", "", "");
    EmojiGifHelper.getInstance().unbind(hashCode());
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdla.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.popup.click", 0, 0, "", "", "", "");
      g();
      continue;
      c();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b(this.jdField_c_of_type_AndroidWidgetImageView);
    b(this.jdField_d_of_type_AndroidWidgetImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment
 * JD-Core Version:    0.7.0.1
 */