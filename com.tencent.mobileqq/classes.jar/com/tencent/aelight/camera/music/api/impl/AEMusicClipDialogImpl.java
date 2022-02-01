package com.tencent.aelight.camera.music.api.impl;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricPanelDialog;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricPanelDialog.OperationCallback;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricProgressCalculator;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicInfo;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper;
import com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.music.api.IAEMusicClipDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricPanelDialog;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricPanelDialog.WinkOperationCallback;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricProgressCalculator;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.IOException;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class AEMusicClipDialogImpl
  implements MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, AEEditorLyricPanelDialog.OperationCallback, IAEMusicClipDialog, WinkLyricPanelDialog.WinkOperationCallback
{
  public static final String TAG = "AEMusicClipDialogImpl";
  private Integer cachedStartTimeInMs = null;
  private int currentPosition = 0;
  private int currentStartPosition = 0;
  private AEEditorLyricPanelDialog dialog;
  private boolean isLoadingShow = false;
  private boolean isQCircle = true;
  private FrameLayout loadingContainer;
  private BroadcastReceiver loadingReceiver;
  private AEEditorLoadingView loadingView;
  private WeakReference<Context> mContext;
  private MediaPlayer mediaPlayer;
  private int musicClipDuration = 0;
  private JSONObject musicData;
  private Handler playHandler;
  private int recommStartPosition = 0;
  private Runnable runnable = new AEMusicClipDialogImpl.2(this);
  private int videoClipDuration = 0;
  private ViewGroup viewRoot;
  private int waveViewHeight;
  private WinkLyricPanelDialog winkDialog;
  
  private void bindPlayerWithDialogHandler()
  {
    if (this.mediaPlayer == null) {
      return;
    }
    this.playHandler = new Handler();
    this.playHandler.post(this.runnable);
  }
  
  private void clearAllMemberObject()
  {
    this.mContext = null;
    this.dialog = null;
    this.winkDialog = null;
    this.mediaPlayer = null;
    this.playHandler = null;
    this.viewRoot = null;
    this.loadingView = null;
    this.loadingContainer = null;
    this.musicData = null;
    this.cachedStartTimeInMs = null;
  }
  
  private void closeMusicClipDialog()
  {
    Object localObject = this.playHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacks(this.runnable);
      this.playHandler = null;
    }
    localObject = this.mediaPlayer;
    if (localObject != null)
    {
      ((MediaPlayer)localObject).pause();
      this.mediaPlayer.release();
      this.mediaPlayer = null;
    }
    localObject = this.dialog;
    if (localObject != null)
    {
      ((AEEditorLyricPanelDialog)localObject).dismiss();
      this.dialog = null;
    }
    localObject = this.winkDialog;
    if (localObject != null)
    {
      ((WinkLyricPanelDialog)localObject).dismiss();
      this.winkDialog = null;
    }
  }
  
  private void closeMusicWebViewActivity()
  {
    closeMusicClipDialog();
    if (this.loadingReceiver != null) {
      try
      {
        BaseApplicationImpl.getApplication().unregisterReceiver(this.loadingReceiver);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("closeMusicWebViewActivity, ");
        localStringBuilder.append(localException.toString());
        AEQLog.a("AEMusicClipDialogImpl", localStringBuilder.toString());
      }
    }
    this.loadingReceiver = null;
    clearAllMemberObject();
    Intent localIntent = new Intent("com.tencent.mobileqq.action.closewebview");
    localIntent.putExtra("event", "closeWebView");
    MobileQQ.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  private void destroyLoadingView()
  {
    if (this.mContext.get() == null) {
      return;
    }
    Object localObject = this.viewRoot;
    if (localObject != null)
    {
      ((ViewGroup)localObject).removeView(this.loadingContainer);
      this.viewRoot = null;
    }
    localObject = this.loadingContainer;
    if (localObject != null)
    {
      ((FrameLayout)localObject).removeAllViews();
      this.loadingContainer = null;
    }
    if (this.loadingView != null) {
      this.loadingView = null;
    }
  }
  
  private void hideLoadingView()
  {
    if (this.mContext.get() == null) {
      return;
    }
    Object localObject = this.loadingView;
    if (localObject != null) {
      ((AEEditorLoadingView)localObject).a();
    }
    localObject = this.viewRoot;
    if (localObject != null) {
      ((ViewGroup)localObject).removeView(this.loadingContainer);
    }
  }
  
  private void initExtras(Context paramContext)
  {
    if (!(paramContext instanceof Activity)) {
      return;
    }
    paramContext = ((Activity)paramContext).getIntent();
    if (paramContext != null) {
      try
      {
        this.videoClipDuration = Integer.parseInt(paramContext.getStringExtra("videoclipduration"));
        paramContext = paramContext.getStringExtra("videofrom");
        if ((paramContext != null) && (paramContext.equals("fromqqwink")))
        {
          this.isQCircle = false;
          return;
        }
      }
      catch (NumberFormatException paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[initExtras] exception = ");
        localStringBuilder.append(paramContext.toString());
        AEQLog.b("AEMusicClipDialogImpl", localStringBuilder.toString());
      }
    }
  }
  
  private void initLoadingView()
  {
    if (this.mContext.get() == null) {
      return;
    }
    if (this.loadingView == null)
    {
      this.loadingView = new AEEditorLoadingView((Context)this.mContext.get());
      this.loadingView.setFromQCircle(this.isQCircle);
      this.loadingView.a(4);
    }
    if (this.loadingContainer == null)
    {
      this.loadingContainer = new FrameLayout((Context)this.mContext.get());
      this.loadingContainer.addView(this.loadingView, -1, -1);
    }
    if (this.viewRoot == null) {
      this.viewRoot = ((ViewGroup)((Activity)this.mContext.get()).findViewById(16908290));
    }
  }
  
  private void initMusicInfo(com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (paramVsMusicItemInfo != null)
    {
      this.recommStartPosition = paramVsMusicItemInfo.musicStart;
      this.currentStartPosition = this.recommStartPosition;
    }
  }
  
  private void initMusicInfo(com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (paramVsMusicItemInfo != null)
    {
      this.recommStartPosition = paramVsMusicItemInfo.musicStart;
      this.currentStartPosition = this.recommStartPosition;
    }
  }
  
  private void pauseMusic()
  {
    MediaPlayer localMediaPlayer = this.mediaPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.pause();
    }
  }
  
  private void playMusic()
  {
    MediaPlayer localMediaPlayer = this.mediaPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.start();
    }
  }
  
  private void prepareClipMusic(com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo paramVsMusicItemInfo)
  {
    if ((this.mediaPlayer != null) && (paramVsMusicItemInfo != null) && (!TextUtils.isEmpty(paramVsMusicItemInfo.mUrl)))
    {
      this.mediaPlayer.setDataSource(paramVsMusicItemInfo.mUrl);
      this.mediaPlayer.setVolume(0.8F, 0.8F);
      this.mediaPlayer.setOnPreparedListener(this);
      this.mediaPlayer.setOnSeekCompleteListener(this);
      this.mediaPlayer.prepareAsync();
    }
  }
  
  private void prepareClipMusic(com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo paramVsMusicItemInfo)
  {
    if ((this.mediaPlayer != null) && (paramVsMusicItemInfo != null) && (!TextUtils.isEmpty(paramVsMusicItemInfo.mUrl)))
    {
      this.mediaPlayer.setDataSource(paramVsMusicItemInfo.mUrl);
      this.mediaPlayer.setVolume(0.8F, 0.8F);
      this.mediaPlayer.setOnPreparedListener(this);
      this.mediaPlayer.setOnSeekCompleteListener(this);
      this.mediaPlayer.prepareAsync();
    }
  }
  
  private void registerLoadingFilter()
  {
    if (this.loadingReceiver == null)
    {
      this.loadingReceiver = new AEMusicClipDialogImpl.1(this);
      IntentFilter localIntentFilter = new IntentFilter("action_dispatch_music_event");
      BaseApplicationImpl.getApplication().registerReceiver(this.loadingReceiver, localIntentFilter);
    }
  }
  
  private void requestDetailedMusicInfoForWeb(@NonNull com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) {
      return;
    }
    if (AEEditorMusicHelper.a(paramVsMusicItemInfo))
    {
      Object localObject = new AEEditorMusicAdapter.AEEditorMusicInfo(paramVsMusicItemInfo, false, 2);
      if (((AEEditorMusicAdapter.AEEditorMusicInfo)localObject).b() != null) {
        ((AEEditorMusicAdapter.AEEditorMusicInfo)localObject).b().musicStart = this.recommStartPosition;
      }
      this.musicClipDuration = ((AEEditorMusicAdapter.AEEditorMusicInfo)localObject).f();
      showClipDialog((AEEditorMusicAdapter.AEEditorMusicInfo)localObject);
      try
      {
        prepareClipMusic(paramVsMusicItemInfo);
        return;
      }
      catch (IOException paramVsMusicItemInfo)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[requestDetailedMusicInfo] exception = ");
        ((StringBuilder)localObject).append(paramVsMusicItemInfo.toString());
        AEQLog.b("AEMusicClipDialogImpl", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void requestDetailedMusicInfoForWeb(@NonNull com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) {
      return;
    }
    if (WinkEditorMusicHelper.a(paramVsMusicItemInfo))
    {
      Object localObject = new WinkEditorMusicInfo(paramVsMusicItemInfo, false, 2);
      if (((WinkEditorMusicInfo)localObject).b() != null) {
        ((WinkEditorMusicInfo)localObject).b().musicStart = this.recommStartPosition;
      }
      this.musicClipDuration = ((WinkEditorMusicInfo)localObject).h();
      showClipDialog((WinkEditorMusicInfo)localObject);
      try
      {
        prepareClipMusic(paramVsMusicItemInfo);
        return;
      }
      catch (IOException paramVsMusicItemInfo)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[requestDetailedMusicInfo] exception = ");
        ((StringBuilder)localObject).append(paramVsMusicItemInfo.toString());
        AEQLog.b("AEMusicClipDialogImpl", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void showClipDialog(AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    if (!this.dialog.isShowing())
    {
      this.dialog.a(paramAEEditorMusicInfo, this.currentStartPosition, this.videoClipDuration, ViewUtils.getScreenWidth(), this.waveViewHeight, false);
      paramAEEditorMusicInfo = this.dialog;
      int i = this.currentStartPosition;
      paramAEEditorMusicInfo.c(i, this.videoClipDuration + i);
      this.dialog.a(this);
      this.dialog.show();
    }
  }
  
  private void showClipDialog(WinkEditorMusicInfo paramWinkEditorMusicInfo)
  {
    if (!this.winkDialog.isShowing())
    {
      this.winkDialog.a(paramWinkEditorMusicInfo, this.currentStartPosition, this.videoClipDuration, ViewUtils.getScreenWidth(), this.waveViewHeight, false);
      paramWinkEditorMusicInfo = this.winkDialog;
      int i = this.currentStartPosition;
      paramWinkEditorMusicInfo.c(i, this.videoClipDuration + i);
      this.winkDialog.a(this);
      this.winkDialog.show();
    }
  }
  
  private void showLoadingView()
  {
    if (this.mContext.get() == null) {
      return;
    }
    this.viewRoot.addView(this.loadingContainer, -1, -1);
    ThreadManager.getUIHandler().postDelayed(new AEMusicClipDialogImpl.3(this), 10000L);
  }
  
  public void onClickCancelBtn()
  {
    this.cachedStartTimeInMs = null;
    closeMusicClipDialog();
  }
  
  public void onClickConfirmBtn()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_dispatch_music_event");
    localIntent.putExtra("data", this.musicData.toString());
    localIntent.putExtra("event", "kTribeClipsMusic");
    localIntent.putExtra("clipStartTime", this.currentStartPosition);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    this.cachedStartTimeInMs = null;
    pauseMusic();
    initLoadingView();
    showLoadingView();
  }
  
  public void onIndicatorDragged(int paramInt)
  {
    this.mediaPlayer.seekTo(this.currentStartPosition + paramInt);
    if (this.isQCircle)
    {
      this.dialog.b(paramInt, this.videoClipDuration);
      return;
    }
    this.winkDialog.b(paramInt, this.videoClipDuration);
  }
  
  public void onLyricPanelHide() {}
  
  public void onLyricPanelShow() {}
  
  public void onMusicWaveMoveEnd()
  {
    Integer localInteger = this.cachedStartTimeInMs;
    if (localInteger != null)
    {
      this.mediaPlayer.seekTo(localInteger.intValue());
      this.currentStartPosition = this.cachedStartTimeInMs.intValue();
      if (this.isQCircle)
      {
        this.dialog.b(0, this.videoClipDuration);
        AEEditorLyricProgressCalculator.a().b(this.cachedStartTimeInMs.intValue(), Math.min(this.cachedStartTimeInMs.intValue() + this.videoClipDuration, this.musicClipDuration));
      }
      else
      {
        this.winkDialog.b(0, this.videoClipDuration);
        WinkLyricProgressCalculator.a().b(this.cachedStartTimeInMs.intValue(), Math.min(this.cachedStartTimeInMs.intValue() + this.videoClipDuration, this.musicClipDuration));
      }
      this.cachedStartTimeInMs = null;
    }
  }
  
  public void onMusicWaveMoveEnd(boolean paramBoolean)
  {
    onMusicWaveMoveEnd();
  }
  
  public void onMusicWaveMoveStart() {}
  
  public void onMusicWaveMoving(int paramInt1, int paramInt2)
  {
    if (this.isQCircle) {
      this.dialog.c(paramInt1, paramInt2);
    } else {
      this.winkDialog.c(paramInt1, paramInt2);
    }
    this.cachedStartTimeInMs = Integer.valueOf(paramInt1);
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.seekTo(this.currentStartPosition);
      if (this.isQCircle) {
        this.dialog.b(0, this.videoClipDuration);
      } else {
        this.winkDialog.b(0, this.videoClipDuration);
      }
      paramMediaPlayer.start();
      paramMediaPlayer.setLooping(true);
      bindPlayerWithDialogHandler();
    }
  }
  
  public void onResetMusicRangeToRecommend(int paramInt)
  {
    this.currentStartPosition = paramInt;
    this.mediaPlayer.seekTo(this.currentStartPosition);
    if (this.isQCircle)
    {
      AEEditorLyricProgressCalculator.a().b(paramInt, Math.min(this.currentStartPosition + this.videoClipDuration, this.musicClipDuration));
      this.dialog.b(0, this.videoClipDuration);
      localObject = this.dialog;
      paramInt = this.currentStartPosition;
      ((AEEditorLyricPanelDialog)localObject).c(paramInt, this.videoClipDuration + paramInt);
      this.dialog.b(this.currentStartPosition);
      return;
    }
    WinkLyricProgressCalculator.a().b(paramInt, Math.min(this.currentStartPosition + this.videoClipDuration, this.musicClipDuration));
    this.winkDialog.b(0, this.videoClipDuration);
    Object localObject = this.winkDialog;
    paramInt = this.currentStartPosition;
    ((WinkLyricPanelDialog)localObject).c(paramInt, this.videoClipDuration + paramInt);
    this.winkDialog.b(this.currentStartPosition);
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer) {}
  
  public void setIsQCircle(boolean paramBoolean)
  {
    this.isQCircle = paramBoolean;
  }
  
  public void showMusicClipDialogOnWebView(JSONObject paramJSONObject, Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      if (paramJSONObject == null) {
        return;
      }
      initExtras(paramContext);
      this.musicData = paramJSONObject;
      this.waveViewHeight = paramContext.getResources().getDimensionPixelSize(2063859802);
      if (this.isQCircle) {
        this.dialog = new AEEditorLyricPanelDialog(paramContext);
      } else {
        this.winkDialog = new WinkLyricPanelDialog(paramContext);
      }
      this.mediaPlayer = new MediaPlayer();
      this.mediaPlayer.setAudioStreamType(3);
      if (this.isQCircle)
      {
        paramJSONObject = AEEditorMusicHelper.a(paramJSONObject);
        initMusicInfo(paramJSONObject);
        requestDetailedMusicInfoForWeb(paramJSONObject);
      }
      else
      {
        paramJSONObject = WinkEditorMusicHelper.a(paramJSONObject);
        initMusicInfo(paramJSONObject);
        requestDetailedMusicInfoForWeb(paramJSONObject);
      }
      this.mContext = new WeakReference(paramContext);
      registerLoadingFilter();
    }
  }
  
  public void showMusicSelectLoadingOnWebView(JSONObject paramJSONObject, Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      if (paramJSONObject == null) {
        return;
      }
      initExtras(paramContext);
      this.mContext = new WeakReference(paramContext);
      if ((this.mContext.get() instanceof QQBrowserActivity))
      {
        paramContext = ((QQBrowserActivity)this.mContext.get()).getCurrentUrl();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext);
        localStringBuilder.append(paramContext);
        localStringBuilder.toString();
      }
      registerLoadingFilter();
      initLoadingView();
      showLoadingView();
      paramContext = new Intent();
      paramContext.setAction("action_dispatch_music_event");
      paramContext.putExtra("event", "kTribeSelectMusic");
      paramContext.putExtra("data", paramJSONObject.toString());
      BaseApplicationImpl.getApplication().sendBroadcast(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.music.api.impl.AEMusicClipDialogImpl
 * JD-Core Version:    0.7.0.1
 */