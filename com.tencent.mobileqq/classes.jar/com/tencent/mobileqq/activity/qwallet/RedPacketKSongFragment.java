package com.tencent.mobileqq.activity.qwallet;

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
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView.StatusListener;
import com.tencent.mobileqq.activity.qwallet.voice.KSongVolumeView;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.OnVoiceRedPacketListener;
import com.tencent.mobileqq.activity.qwallet.widget.ksong.KSHelper.Config;
import com.tencent.mobileqq.activity.qwallet.widget.ksong.KSHelper.KListener;
import com.tencent.mobileqq.activity.qwallet.widget.ksong.KSongProsBar;
import com.tencent.mobileqq.activity.qwallet.widget.ksong.KSongView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class RedPacketKSongFragment
  extends RedPacketPopFragment
  implements KSongMicView.StatusListener, VoiceRedPacketHelper.OnVoiceRedPacketListener
{
  public static final String a;
  public static final String[] a;
  public static final String b;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new RedPacketKSongFragment.8(this);
  MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new RedPacketKSongFragment.1(this);
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  private RedPacketKSongFragment.SongInfo jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKSongFragment$SongInfo;
  KSongMicView jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView;
  KSongVolumeView jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView;
  VoiceRedPacketHelper jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper;
  KSongProsBar jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongProsBar;
  KSongView jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongView;
  AnimationView jdField_a_of_type_ComTencentMobileqqWidgetAnimationView;
  public boolean a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new RedPacketKSongFragment.2(this);
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  TextView c;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  private boolean f = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713248);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131713270);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { HardCodeUtil.a(2131713265), HardCodeUtil.a(2131713257), HardCodeUtil.a(2131713275) };
  }
  
  public RedPacketKSongFragment()
  {
    this.jdField_c_of_type_JavaLangString = "https://i.gtimg.cn/channel/imglib/201806/upload_8f5d7c5994fc2ceb1e92f11436db039d.zip";
    this.jdField_d_of_type_JavaLangString = "https://imgcache.qq.com/channel/static/socialpay/music/song_54.zip";
    this.jdField_e_of_type_JavaLangString = "https://imgcache.qq.com/channel/static/socialpay/music/";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
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
    PasswdRedBagManager localPasswdRedBagManager = (PasswdRedBagManager)getActivity().app.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
    PasswdRedBagInfo localPasswdRedBagInfo = localPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
    localPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop);
    localObject = (QWalletConfigManager)getActivity().app.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    int i;
    Bundle localBundle;
    SessionInfo localSessionInfo;
    if (localObject != null)
    {
      i = ((QWalletConfigManager)localObject).a("voice_pwd", 1, new String[] { "scoreSwitch" });
      localBundle = new Bundle();
      localBundle.putString("feedsid", a());
      VoiceRedPacketHelper.a(a(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      QWalletTools.a(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (i != 1) {
        break label340;
      }
    }
    label340:
    for (localObject = paramString;; localObject = "")
    {
      localPasswdRedBagManager.a(localSessionInfo, localPasswdRedBagInfo, l, 131072, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.fromHBList, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localPasswdRedBagInfo.jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + localPasswdRedBagInfo.jdField_b_of_type_Boolean + ",isPasswdRedBagOverDue=" + localPasswdRedBagInfo.jdField_c_of_type_Boolean + "|scoreSwitch:" + i + "|scoreId" + paramString);
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
    Object localObject = ((QWalletConfigManager)getActivity().app.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER)).a("redPackPanel", "", new String[] { "panelRedPkgList" });
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
      ((IPreloadService)getActivity().app.getRuntimeService(IPreloadService.class, "")).getResPath(this.jdField_c_of_type_JavaLangString, new RedPacketKSongFragment.9(this));
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
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongView.getConfig().ksongId;
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
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847680));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(jdField_b_of_type_JavaLangString);
        d();
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      if (this.f) {
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongView.pause();
          this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847678));
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
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongView.play(true);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847680));
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
    ((ViewStub)paramView.findViewById(2131378608)).inflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379418));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView = ((KSongMicView)paramView.findViewById(2131376777));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = ((AnimationView)paramView.findViewById(2131370020));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370759));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370886);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373246));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373263));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongView = ((KSongView)paramView.findViewById(2131370022));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongProsBar = ((KSongProsBar)paramView.findViewById(2131370021));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView = ((KSongVolumeView)paramView.findViewById(2131369043));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131377017);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370019));
    a(this.jdField_b_of_type_AndroidWidgetImageView);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(String paramString, KSHelper.KListener paramKListener, boolean paramBoolean)
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
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new RedPacketKSongFragment.5(this, paramBoolean));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new RedPacketKSongFragment.6(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongView.setKListener(new RedPacketKSongFragment.7(this, paramKListener));
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
    this.jdField_e_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130847652));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(QWalletTools.a(0.7F));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    Object localObject = ContactUtils.c(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, true);
    localObject = QWalletTools.a(getActivity(), (String)localObject, 135.0F, this.jdField_d_of_type_AndroidWidgetTextView.getPaint());
    this.jdField_d_of_type_AndroidWidgetTextView.setText((String)localObject + "的K歌红包");
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView.setStatusListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper = VoiceRedPacketHelper.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.a(this);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("tencent.av.v2q.StartVideoChat");
    ((IntentFilter)localObject).addAction("android.intent.action.PHONE_STATE");
    getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(jdField_a_of_type_JavaLangString);
    AccessibilityUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongView, false);
    p();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = MediaPlayerManager.a(getActivity().app);
    ReportController.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.show", 0, 0, "", "", "", "");
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847678));
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
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongView.reset();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongView.setVisibility(8);
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.b();
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
    a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKSongFragment$SongInfo.jdField_b_of_type_JavaLangString, new RedPacketKSongFragment.3(this), false);
  }
  
  public boolean c()
  {
    return super.c();
  }
  
  public void d()
  {
    ReportController.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.play", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847680));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKSongFragment$SongInfo.jdField_a_of_type_JavaLangString, new RedPacketKSongFragment.4(this), true);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713280));
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void f()
  {
    this.jdField_d_of_type_JavaLangString = (this.jdField_e_of_type_JavaLangString + "song_" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.songId + ".zip");
    ((IPreloadService)getActivity().app.getRuntimeService(IPreloadService.class, "")).getResPath(this.jdField_d_of_type_JavaLangString, new RedPacketKSongFragment.10(this));
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
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongView.reset();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketKSongFragment$SongInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, "", false);
      this.jdField_d_of_type_Boolean = true;
    }
    ReportController.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.start", 0, 0, "", "", "", "");
  }
  
  public void n() {}
  
  public void o()
  {
    super.o();
    VoiceRedPacketHelper.a().c();
  }
  
  public boolean onBackEvent()
  {
    ReportController.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "210", "ksong.sing.close", 0, 0, "", "", "", "");
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQAudioUtils.a(getActivity(), false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.b();
    }
    r();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetKsongKSongView.release();
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
      b(HardCodeUtil.a(2131713261));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment
 * JD-Core Version:    0.7.0.1
 */