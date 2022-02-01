package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.MusicPlayerSceneListener;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.aelight.camera.aioeditor.shortvideo.ShortVideoUtils;
import com.tencent.aelight.camera.struct.editor.FlowMusic;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;

public class MusicFragmentProviderView
  extends ProviderView
  implements Handler.Callback, View.OnClickListener, QimMusicSeekView.SeekListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 400L;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MusicPlayerSceneListener jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerSceneListener = new MusicFragmentProviderView.2(this);
  private QimMusicPlayer jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
  private MusicFragmentProviderView.MusicPlayTask jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewMusicFragmentProviderView$MusicPlayTask = null;
  private QimMusicSeekView jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQimMusicSeekView;
  private MusicDownloadListener jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener = new MusicFragmentProviderView.1(this);
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private Timer jdField_a_of_type_JavaUtilTimer = null;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = 10000;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  
  public MusicFragmentProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd;
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    ((MusicItemInfo)localObject).musicStart = 0;
    ((MusicItemInfo)localObject).musicEnd = this.jdField_c_of_type_Int;
    ((MusicItemInfo)localObject).musicDuration = ((int)ShortVideoUtils.a(((MusicItemInfo)localObject).getLocalPath()));
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration < this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
      ((MusicItemInfo)localObject).musicEnd = ((MusicItemInfo)localObject).musicDuration;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQimMusicSeekView.setDurations((b() + 500) / 1000, (Math.max(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration, this.jdField_c_of_type_Int) + 500) / 1000);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQimMusicSeekView.a(0);
    b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.e.setEnabled(true);
    if ((this.jdField_g_of_type_Int == 0) && (!paramBoolean)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_g_of_type_Int);
    } else {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.c(paramBoolean ^ true);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("prepareStartMusic musicName");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName);
      QLog.d("MusicFragmentProviderView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private int b()
  {
    int i = this.jdField_c_of_type_Int;
    if (i < 5000) {
      return 5000;
    }
    if (i > CodecParam.RECORD_MAX_TIME) {
      return CodecParam.RECORD_MAX_TIME;
    }
    return this.jdField_c_of_type_Int;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int k = paramInt2 - paramInt1;
    int j = k / 1000;
    int i;
    if (j < 0)
    {
      i = 1;
    }
    else
    {
      i = j;
      if (k % 1000 > 500) {
        i = j + 1;
      }
    }
    String str1 = TimeFormatterUtils.a(paramInt1, false);
    String str2 = TimeFormatterUtils.a(i * 1000 + paramInt1, false);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("start = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", end = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", displayStart = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", displayEnd = ");
      localStringBuilder.append(str2);
      QLog.d("MusicFragmentProviderView", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder(str1);
    localStringBuilder.append("-");
    localStringBuilder.append(str2);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
    this.jdField_f_of_type_AndroidWidgetTextView.setText(str1);
    this.jdField_g_of_type_AndroidWidgetTextView.setText(str2);
  }
  
  private void k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    if (localObject == null)
    {
      QLog.i("MusicFragmentProviderView", 1, "startDownload mCurMusicItemInfo is null");
      return;
    }
    localObject = ((MusicItemInfo)localObject).mSongMid;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "songMid not exist");
      }
      b(-115);
      return;
    }
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "Net not Support");
      }
      b(-104);
      return;
    }
    if (NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidContentContext)) {
      c(1);
    }
    ((QIMMusicConfigManager)QIMManager.a(2)).a((String)localObject, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo instanceof VsMusicItemInfo, new MusicFragmentProviderView.3(this));
  }
  
  protected int a()
  {
    return 2131560876;
  }
  
  void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localObject != null)
    {
      localObject = ((WeakReferenceHandler)localObject).obtainMessage();
      ((Message)localObject).what = 5;
      ((Message)localObject).arg1 = paramInt;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = (int)(this.jdField_f_of_type_AndroidWidgetTextView.getPaint().measureText("00:00") / 2.0F);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_f_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt1 - i);
    this.jdField_f_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt2 - i * 2);
    this.jdField_g_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QimMusicPlayer localQimMusicPlayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
    if (localQimMusicPlayer != null) {
      localQimMusicPlayer.d();
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.c(false);
    }
    b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560876, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQimMusicSeekView = ((QimMusicSeekView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371614));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQimMusicSeekView.setOnSeekListener(this);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370377);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365829));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365853));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131371623));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365844));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377170);
    this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377707));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377128));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377127));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371648));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364166));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364177));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  void a(String paramString, int paramInt)
  {
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    if ((localMusicItemInfo != null) && (localMusicItemInfo.getLocalPath().equals(paramString)))
    {
      paramString = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
      if (paramString != null)
      {
        paramString = paramString.obtainMessage();
        paramString.what = 1;
        paramString.arg1 = paramInt;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramString);
      }
    }
  }
  
  public boolean a()
  {
    g();
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getY();
    float f2 = ViewUtils.b() - this.jdField_f_of_type_Int;
    if (QLog.isColorLevel())
    {
      paramMotionEvent = new StringBuilder();
      paramMotionEvent.append("checkToInterceptTouchArea, touchY=");
      paramMotionEvent.append(f1);
      paramMotionEvent.append(", minTouchingY=");
      paramMotionEvent.append(f2);
      QLog.d("MusicFragmentProviderView", 2, paramMotionEvent.toString());
    }
    return f1 < f2;
  }
  
  void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localObject != null)
    {
      localObject = ((WeakReferenceHandler)localObject).obtainMessage();
      ((Message)localObject).what = 8;
      ((Message)localObject).arg1 = paramInt;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    if (localMusicItemInfo != null)
    {
      paramInt2 = localMusicItemInfo.musicDuration;
      paramInt1 = (int)(paramInt2 * (paramInt3 / paramInt1));
      paramInt3 = this.jdField_c_of_type_Int;
      if ((paramInt1 < paramInt2) && (paramInt1 + paramInt3 > paramInt2))
      {
        localMusicItemInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
        localMusicItemInfo.musicStart = (paramInt2 - paramInt3);
        localMusicItemInfo.musicEnd = paramInt2;
      }
      else
      {
        localMusicItemInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
        localMusicItemInfo.musicStart = paramInt1;
        localMusicItemInfo.musicEnd = (paramInt1 + this.jdField_c_of_type_Int);
      }
      b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
    }
  }
  
  void c(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localObject != null)
    {
      localObject = ((WeakReferenceHandler)localObject).obtainMessage();
      ((Message)localObject).what = 4;
      ((Message)localObject).arg1 = paramInt;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.c(true);
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer != null)
    {
      if (this.jdField_g_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, true, this.jdField_g_of_type_Int);
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress = -1;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    if ((localObject != null) && (this.jdField_a_of_type_Boolean))
    {
      ((MusicItemInfo)localObject).musicStart = this.jdField_a_of_type_Int;
      ((MusicItemInfo)localObject).musicEnd = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.e();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(this.jdField_g_of_type_Int);
      if (((QIMMusicConfigManager)QIMManager.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mItemId) == null)
      {
        FileUtils.a(new File(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath()));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("delete file=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName);
          QLog.d("MusicFragmentProviderView", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("cancel musicStart=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart);
        ((StringBuilder)localObject).append(" musicEnd=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
        ((StringBuilder)localObject).append(" musicDuration");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration);
        ((StringBuilder)localObject).append(" premusicStart");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" premusicEnd");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(" musicName");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName);
        QLog.d("MusicFragmentProviderView", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
      i();
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.a(1);
    }
    localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localObject != null)
    {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = null;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerSceneListener);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer = null;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_g_of_type_Int == 0) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, true, this.jdField_g_of_type_Int);
      } else {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.c(true);
      }
      ((QIMMusicConfigManager)QIMManager.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("complete musicStart=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart);
        ((StringBuilder)localObject).append(" musicEnd=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
        ((StringBuilder)localObject).append(" musicDuration");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicDuration);
        ((StringBuilder)localObject).append(" premusicStart");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" premusicEnd");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(" musicName");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mMusicName);
        QLog.d("MusicFragmentProviderView", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
      i();
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.a(1);
    }
    Object localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localObject != null)
    {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
    if (localObject != null)
    {
      ((QimMusicPlayer)localObject).b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerSceneListener);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool = true;
    Object localObject;
    switch (i)
    {
    default: 
      return false;
    case 8: 
      i = paramMessage.arg1;
      if (i == 0)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      else if (i == -104)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698374));
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698369));
      }
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("MSG_UPDATE_DOWNLOAD_FINISH_STATE finishState=");
        paramMessage.append(i);
        QLog.d("MusicFragmentProviderView", 2, paramMessage.toString());
        return false;
      }
      break;
    case 7: 
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698369);
      localObject = str;
      if (paramMessage.arg1 == 1)
      {
        paramMessage = (FlowMusic)paramMessage.obj;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onGetSingleMusicInfo flowMusic:");
          ((StringBuilder)localObject).append(paramMessage.toString());
          QLog.d("MusicFragmentProviderView", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mUrl = paramMessage.url;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.fileSize = paramMessage.size;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mAlbumUrl = paramMessage.albumUrl;
        if ((paramMessage.playable == 1) && (!TextUtils.isEmpty(paramMessage.url)))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo, this.jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener);
          return false;
        }
        localObject = str;
        if (paramMessage.playable != 1) {
          localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698370);
        }
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel())
      {
        QLog.d("MusicFragmentProviderView", 2, "MSG_GET_SINGLE_MUSIC failed");
        return false;
      }
      break;
    case 6: 
      if (paramMessage.obj == null) {
        return false;
      }
      paramMessage = (String)paramMessage.obj;
      this.h.setText(paramMessage);
      this.h.setVisibility(0);
      return false;
    case 5: 
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {
        return false;
      }
      i = paramMessage.arg1;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQimMusicSeekView.a(i);
      b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicStart, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.musicEnd);
      return false;
    case 4: 
      i = paramMessage.arg1;
      if (i == 1) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698373));
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("MSG_UPDATE_NET_CHANGE state=");
        paramMessage.append(i);
        QLog.d("MusicFragmentProviderView", 2, paramMessage.toString());
        return false;
      }
      break;
    case 3: 
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698375));
      return false;
    case 2: 
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_REPLAY ");
      }
      if ((getContext() instanceof AppActivity))
      {
        paramMessage = (AppActivity)getContext();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("MSG_UPDATE_REPLAY isResume");
          ((StringBuilder)localObject).append(paramMessage.isResume());
          QLog.d("MusicFragmentProviderView", 2, ((StringBuilder)localObject).toString());
        }
        bool = true ^ paramMessage.isResume();
      }
      else if ((getContext() instanceof BaseActivity))
      {
        paramMessage = (BaseActivity)getContext();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("MSG_UPDATE_REPLAY isResume");
          ((StringBuilder)localObject).append(paramMessage.isResume());
          QLog.d("MusicFragmentProviderView", 2, ((StringBuilder)localObject).toString());
        }
        if (!paramMessage.isResume()) {}
      }
      else
      {
        bool = false;
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
      if ((paramMessage != null) && (!TextUtils.isEmpty(paramMessage.getLocalPath())))
      {
        a(bool);
        return false;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("MusicFragmentProviderView", 2, "curretInfo ==null or path not exsist");
        return false;
      }
      break;
    case 1: 
      i = paramMessage.arg1;
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      if (i >= 100)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return false;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("MSG_UPDATE_PROGRESS percent=");
        paramMessage.append(i);
        QLog.d("MusicFragmentProviderView", 2, paramMessage.toString());
        return false;
      }
      break;
    case 0: 
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQimMusicSeekView.setPlayedPosition(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    }
    return false;
  }
  
  protected void i()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilTimer;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewMusicFragmentProviderView$MusicPlayTask;
    if (localObject != null)
    {
      ((MusicFragmentProviderView.MusicPlayTask)localObject).cancel();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewMusicFragmentProviderView$MusicPlayTask = null;
    }
  }
  
  void j()
  {
    i();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewMusicFragmentProviderView$MusicPlayTask = new MusicFragmentProviderView.MusicPlayTask(this);
    this.jdField_a_of_type_Long = 400L;
    if (this.jdField_c_of_type_Int > CodecParam.RECORD_MAX_TIME)
    {
      this.jdField_a_of_type_Long = ((this.jdField_c_of_type_Int * 400.0F / CodecParam.RECORD_MAX_TIME));
    }
    else
    {
      int i = this.jdField_c_of_type_Int;
      if (i < 5000) {
        this.jdField_a_of_type_Long = ((i * 400.0F / 5000));
      }
    }
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewMusicFragmentProviderView$MusicPlayTask, 0L, this.jdField_a_of_type_Long);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364166)
    {
      if (i != 2131364177)
      {
        if (i != 2131365853) {
          return;
        }
        if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo)) {
          k();
        }
        if (QLog.isColorLevel()) {
          QLog.d("MusicFragmentProviderView", 2, "download_try_again");
        }
      }
      else
      {
        h();
      }
    }
    else {
      g();
    }
  }
  
  public void setMusicProviderView(MusicItemInfo paramMusicItemInfo)
  {
    Object localObject = (QIMMusicConfigManager)QIMManager.a(2);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    ((QIMMusicConfigManager)localObject).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer = ((QimMusicPlayer)QIMManager.a().c(8));
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener != null)
    {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView$ProviderViewListener.a();
      if (this.jdField_c_of_type_Int < 1000) {
        this.jdField_c_of_type_Int = 1000;
      }
    }
    else
    {
      this.jdField_c_of_type_Int = 10000;
    }
    if (this.jdField_c_of_type_Int == CodecParam.SEGMENT_RECORD_MAX_TIME)
    {
      this.jdField_a_of_type_Long = ((int)(this.jdField_c_of_type_Int * 1.0F / (b() + 1) * 400.0F));
    }
    else
    {
      int i = this.jdField_c_of_type_Int;
      double d1 = i / 6;
      Double.isNaN(d1);
      int j = (int)(d1 * 0.4D);
      long l;
      if (i < 5000) {
        l = j;
      } else {
        l = 400L;
      }
      this.jdField_a_of_type_Long = l;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.e();
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.b(paramMusicItemInfo))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(1);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694938));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.e.setEnabled(false);
      k();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setMusicProviderView file not exist fileName=");
      ((StringBuilder)localObject).append(paramMusicItemInfo.mMusicName);
      ((StringBuilder)localObject).append(" mid=");
      ((StringBuilder)localObject).append(paramMusicItemInfo.mSongMid);
      QLog.d("MusicFragmentProviderView", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicMusicPlayerSceneListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.MusicFragmentProviderView
 * JD-Core Version:    0.7.0.1
 */