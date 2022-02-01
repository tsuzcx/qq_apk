package com.tencent.mobileqq.activity.qwallet;

import akqd;
import akqe;
import akrs;
import akrt;
import akrv;
import akrw;
import akrx;
import akry;
import akrz;
import aksa;
import aksb;
import aksc;
import aksd;
import aktz;
import albw;
import alch;
import alcm;
import alcu;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import anvx;
import bdla;
import bgyd;
import bhcl;
import bivo;
import bivq;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import com.tencent.mobileqq.activity.qwallet.voice.KSongVolumeView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.mobileqq.widget.ksong.KSongProsBar;
import com.tencent.mobileqq.widget.ksong.KSongView;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class RedPacketKSongFragment
  extends RedPacketPopFragment
  implements alch, alcu
{
  public static final String a;
  public static final String[] a;
  public static final String b;
  public long a;
  private aksd jdField_a_of_type_Aksd;
  public alcm a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aksb(this);
  public MediaPlayer a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new akrs(this);
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public TextView a;
  public MediaPlayerManager a;
  public KSongMicView a;
  KSongVolumeView jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView;
  public AnimationView a;
  KSongProsBar jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongProsBar;
  public KSongView a;
  public boolean a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new akrv(this);
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  public TextView c;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  private boolean f;
  
  static
  {
    jdField_a_of_type_JavaLangString = anvx.a(2131712752);
    jdField_b_of_type_JavaLangString = anvx.a(2131712774);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { anvx.a(2131712769), anvx.a(2131712761), anvx.a(2131712779) };
  }
  
  public RedPacketKSongFragment()
  {
    this.jdField_c_of_type_JavaLangString = "https://i.gtimg.cn/channel/imglib/201806/upload_8f5d7c5994fc2ceb1e92f11436db039d.zip";
    this.jdField_d_of_type_JavaLangString = "https://imgcache.qq.com/channel/static/socialpay/music/song_54.zip";
    this.jdField_e_of_type_JavaLangString = "https://imgcache.qq.com/channel/static/socialpay/music/";
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void b(int paramInt)
  {
    paramInt /= 1180;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView.a(paramInt);
  }
  
  private void c(String paramString)
  {
    Object localObject = new StringBuilder(50);
    ((StringBuilder)localObject).append("msgType=18").append("&isOffline=").append(false);
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByKSong", ((StringBuilder)localObject).toString(), 0, null, SystemClock.uptimeMillis());
    akqe localakqe = (akqe)getActivity().app.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
    akqd localakqd = localakqe.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
    localakqe.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop);
    localObject = (aktz)getActivity().app.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    int i;
    Bundle localBundle;
    SessionInfo localSessionInfo;
    if (localObject != null)
    {
      i = ((aktz)localObject).a("voice_pwd", 1, new String[] { "scoreSwitch" });
      localBundle = new Bundle();
      localBundle.putString("feedsid", a());
      alcm.a(a(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      albw.a(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (i != 1) {
        break label340;
      }
    }
    label340:
    for (localObject = paramString;; localObject = "")
    {
      localakqe.a(localSessionInfo, localakqd, l, 131072, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.fromHBList, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localakqd.jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + localakqd.jdField_b_of_type_Boolean + ",isPasswdRedBagOverDue=" + localakqd.jdField_c_of_type_Boolean + "|scoreSwitch:" + i + "|scoreId" + paramString);
      }
      return;
      i = 1;
      break;
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_Boolean = false;
    q();
    f();
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    int i = new Random().nextInt(3);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(jdField_a_of_type_ArrayOfJavaLangString[(i + 0)]);
    Object localObject = ((aktz)getActivity().app.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER)).a("redPackPanel", "", new String[] { "panelRedPkgList" });
    for (;;)
    {
      try
      {
        localObject = new JSONArray((String)localObject);
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          if ((localJSONObject == null) || (localJSONObject.optInt("type") != 7)) {
            continue;
          }
          this.jdField_e_of_type_JavaLangString = localJSONObject.optJSONObject("params").optString("prefix", "https://imgcache.qq.com/channel/static/socialpay/music/");
        }
      }
      catch (Throwable localThrowable)
      {
        continue;
      }
      ((PreloadManager)getActivity().app.getManager(QQManagerFactory.PRELOAD_MANAGER)).c(this.jdField_c_of_type_JavaLangString, new aksc(this));
      return;
      i += 1;
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.stop();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setVisibility(8);
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public int a()
  {
    return 30000;
  }
  
  public String a()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.a().jdField_b_of_type_JavaLangString;
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "onPlayBtnClick:" + this.jdField_b_of_type_Boolean + "|" + this.jdField_c_of_type_Boolean);
    }
    try
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847323));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(jdField_b_of_type_JavaLangString);
        d();
        this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      if (this.f) {
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.b();
          this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847321));
          this.jdField_c_of_type_AndroidWidgetTextView.setText(jdField_a_of_type_JavaLangString);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("RedPacketKSongFragment", 2, "onPlayBtnClick throwable:" + localThrowable.getMessage());
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.a(true);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847323));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public void a(int paramInt)
  {
    getActivity().runOnUiThread(new RedPacketKSongFragment.14(this, paramInt));
  }
  
  public void a(int paramInt, String paramString)
  {
    getActivity().runOnUiThread(new RedPacketKSongFragment.13(this, paramInt, paramString));
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    ((ViewStub)paramView.findViewById(2131378186)).inflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378987));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView = ((KSongMicView)paramView.findViewById(2131376382));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = ((AnimationView)paramView.findViewById(2131369751));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370476));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370598);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372919));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372940));
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView = ((KSongView)paramView.findViewById(2131369753));
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongProsBar = ((KSongProsBar)paramView.findViewById(2131369752));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView = ((KSongVolumeView)paramView.findViewById(2131368811));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131376621);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369750));
    a(this.jdField_b_of_type_AndroidWidgetImageView);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(String paramString, bivq parambivq, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "playSong:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      this.f = false;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new akry(this, paramBoolean));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new akrz(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.setKListener(new aksa(this, parambivq));
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    getActivity().runOnUiThread(new RedPacketKSongFragment.12(this, paramBoolean, paramString));
  }
  
  protected boolean a()
  {
    if (!super.a()) {
      return false;
    }
    this.jdField_e_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130847295));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(albw.a(0.7F));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    Object localObject = ContactUtils.getBuddyName(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, true);
    localObject = albw.a(getActivity(), (String)localObject, 135.0F, this.jdField_d_of_type_AndroidWidgetTextView.getPaint());
    this.jdField_d_of_type_AndroidWidgetTextView.setText((String)localObject + "的K歌红包");
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView.setStatusListener(this);
    this.jdField_a_of_type_Alcm = alcm.a();
    this.jdField_a_of_type_Alcm.a(this);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
    ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
    getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(jdField_a_of_type_JavaLangString);
    bgyd.b(this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView, false);
    p();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = MediaPlayerManager.a(getActivity().app);
    bdla.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.show", 0, 0, "", "", "", "");
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847321));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView.setVisibility(8);
    b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.setVisibility(8);
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    a(paramString);
    this.jdField_a_of_type_Alcm.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView.b();
    this.jdField_d_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    while (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long >= 75L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    a(this.jdField_a_of_type_Aksd.jdField_b_of_type_JavaLangString, new akrw(this), false);
  }
  
  public boolean c()
  {
    return super.c();
  }
  
  public void d()
  {
    bdla.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.play", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847323));
    a(this.jdField_a_of_type_Aksd.jdField_a_of_type_JavaLangString, new akrx(this), true);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131712784));
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void f()
  {
    this.jdField_d_of_type_JavaLangString = (this.jdField_e_of_type_JavaLangString + "song_" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.songId + ".zip");
    ((PreloadManager)getActivity().app.getManager(QQManagerFactory.PRELOAD_MANAGER)).c(this.jdField_d_of_type_JavaLangString, new akrt(this));
  }
  
  public void g()
  {
    getActivity().runOnUiThread(new RedPacketKSongFragment.11(this));
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void i()
  {
    c();
  }
  
  public void j()
  {
    this.jdField_d_of_type_Boolean = false;
    k();
  }
  
  public void k()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RedPacketKSongFragment.15(this), 20000L);
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "onBegin() is called");
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "onEnd() is called");
    }
    if (AudioHelper.b(1)) {
      ChatActivityUtils.a(getActivity());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.a();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    if ((this.jdField_a_of_type_Alcm != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg != null))
    {
      this.jdField_a_of_type_Alcm.a(this.jdField_a_of_type_Aksd.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Alcm.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, "", false);
      this.jdField_d_of_type_Boolean = true;
    }
    bdla.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.start", 0, 0, "", "", "", "");
  }
  
  public void n() {}
  
  public void o()
  {
    super.o();
    alcm.a().c();
  }
  
  public boolean onBackEvent()
  {
    bdla.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.close", 0, 0, "", "", "", "");
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bhcl.a(getActivity(), false);
    if (this.jdField_a_of_type_Alcm != null) {
      this.jdField_a_of_type_Alcm.b();
    }
    r();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView.c();
    AnimationView.AnimationInfo localAnimationInfo = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.getAnimationFromInfo();
    if (localAnimationInfo != null) {
      localAnimationInfo.destoryBitmaps();
    }
    try
    {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label79:
      s();
      b(this.jdField_b_of_type_AndroidWidgetImageView);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label79;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketKSongFragment", 2, "onPause() is called :" + this.jdField_d_of_type_Boolean);
    }
    if (this.jdField_d_of_type_Boolean) {
      b(anvx.a(2131712765));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment
 * JD-Core Version:    0.7.0.1
 */