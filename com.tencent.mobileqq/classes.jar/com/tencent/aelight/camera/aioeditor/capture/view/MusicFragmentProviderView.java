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
  private int G = 10000;
  private AtomicInteger H = new AtomicInteger(-1);
  private Timer I = null;
  private boolean J = false;
  private AtomicBoolean K = new AtomicBoolean(false);
  private MusicFragmentProviderView.MusicPlayTask L = null;
  private long M = 400L;
  private QimMusicPlayer N;
  private MusicDownloadListener O = new MusicFragmentProviderView.1(this);
  private MusicPlayerSceneListener P = new MusicFragmentProviderView.2(this);
  WeakReferenceHandler a;
  private QimMusicSeekView b;
  private View c;
  private View d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private ProgressBar m;
  private ImageView n;
  private MusicItemInfo o;
  private int p = 0;
  private int q = 0;
  
  public MusicFragmentProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(boolean paramBoolean)
  {
    this.p = this.o.musicStart;
    this.q = this.o.musicEnd;
    this.c.setVisibility(8);
    Object localObject = this.o;
    ((MusicItemInfo)localObject).musicStart = 0;
    ((MusicItemInfo)localObject).musicEnd = this.G;
    ((MusicItemInfo)localObject).musicDuration = ((int)ShortVideoUtils.a(((MusicItemInfo)localObject).getLocalPath()));
    if (this.o.musicDuration < this.o.musicEnd)
    {
      localObject = this.o;
      ((MusicItemInfo)localObject).musicEnd = ((MusicItemInfo)localObject).musicDuration;
    }
    this.J = true;
    this.b.setDurations((getDisplayedVideoLength() + 500) / 1000, (Math.max(this.o.musicDuration, this.G) + 500) / 1000);
    this.b.a(0);
    b(this.o.musicStart, this.o.musicEnd);
    this.d.setVisibility(0);
    this.i.setEnabled(true);
    if ((this.D == 0) && (!paramBoolean)) {
      this.N.a(this.o, this.D);
    } else {
      this.N.a(this.o);
    }
    if (this.F != null) {
      this.F.c(paramBoolean ^ true);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("prepareStartMusic musicName");
      ((StringBuilder)localObject).append(this.o.mMusicName);
      QLog.d("MusicFragmentProviderView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i3 = paramInt2 - paramInt1;
    int i2 = i3 / 1000;
    int i1;
    if (i2 < 0)
    {
      i1 = 1;
    }
    else
    {
      i1 = i2;
      if (i3 % 1000 > 500) {
        i1 = i2 + 1;
      }
    }
    String str1 = TimeFormatterUtils.a(paramInt1, false);
    String str2 = TimeFormatterUtils.a(i1 * 1000 + paramInt1, false);
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
    this.e.setText(localStringBuilder.toString());
    this.j.setText(str1);
    this.k.setText(str2);
  }
  
  private int getDisplayedVideoLength()
  {
    int i1 = this.G;
    if (i1 < 5000) {
      return 5000;
    }
    if (i1 > CodecParam.RECORD_MAX_TIME) {
      return CodecParam.RECORD_MAX_TIME;
    }
    return this.G;
  }
  
  private void m()
  {
    Object localObject = this.o;
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
    if (!NetworkUtil.isNetSupport(this.r))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MusicFragmentProviderView", 2, "Net not Support");
      }
      b(-104);
      return;
    }
    if (NetworkUtil.isMobileNetWork(this.r)) {
      c(1);
    }
    ((QIMMusicConfigManager)QIMManager.a(2)).a((String)localObject, this.o instanceof VsMusicItemInfo, new MusicFragmentProviderView.3(this));
  }
  
  void a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((WeakReferenceHandler)localObject).obtainMessage();
      ((Message)localObject).what = 5;
      ((Message)localObject).arg1 = paramInt;
      this.a.sendMessage((Message)localObject);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = (int)(this.j.getPaint().measureText("00:00") / 2.0F);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.j.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt1 - i1);
    this.j.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.k.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt2 - i1 * 2);
    this.k.setLayoutParams(localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QimMusicPlayer localQimMusicPlayer = this.N;
    if (localQimMusicPlayer != null) {
      localQimMusicPlayer.b();
    }
    if (this.F != null) {
      this.F.c(false);
    }
    b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.w == null) {
      this.w = LayoutInflater.from(getContext()).inflate(2131627198, this, false);
    }
    a(this.w);
    this.w.setOnClickListener(this);
    this.b = ((QimMusicSeekView)this.w.findViewById(2131439028));
    this.b.setOnSeekListener(this);
    this.c = this.w.findViewById(2131437643);
    this.n = ((ImageView)this.w.findViewById(2131432087));
    this.g = ((TextView)this.w.findViewById(2131432112));
    this.g.setOnClickListener(this);
    this.m = ((ProgressBar)this.w.findViewById(2131439042));
    this.f = ((TextView)this.w.findViewById(2131432102));
    this.d = this.w.findViewById(2131445548);
    this.l = ((TextView)this.w.findViewById(2131446163));
    this.j = ((TextView)this.w.findViewById(2131445501));
    this.k = ((TextView)this.w.findViewById(2131445500));
    this.e = ((TextView)this.w.findViewById(2131439069));
    this.h = ((TextView)this.w.findViewById(2131430135));
    this.i = ((TextView)this.w.findViewById(2131430159));
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
  }
  
  void a(String paramString, int paramInt)
  {
    MusicItemInfo localMusicItemInfo = this.o;
    if ((localMusicItemInfo != null) && (localMusicItemInfo.getLocalPath().equals(paramString)))
    {
      paramString = this.a;
      if (paramString != null)
      {
        paramString = paramString.obtainMessage();
        paramString.what = 1;
        paramString.arg1 = paramInt;
        this.a.sendMessage(paramString);
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getY();
    float f2 = ViewUtils.getScreenHeight() - this.C;
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
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((WeakReferenceHandler)localObject).obtainMessage();
      ((Message)localObject).what = 8;
      ((Message)localObject).arg1 = paramInt;
      this.a.sendMessage((Message)localObject);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    MusicItemInfo localMusicItemInfo = this.o;
    if (localMusicItemInfo != null)
    {
      paramInt2 = localMusicItemInfo.musicDuration;
      paramInt1 = (int)(paramInt2 * (paramInt3 / paramInt1));
      paramInt3 = this.G;
      if ((paramInt1 < paramInt2) && (paramInt1 + paramInt3 > paramInt2))
      {
        localMusicItemInfo = this.o;
        localMusicItemInfo.musicStart = (paramInt2 - paramInt3);
        localMusicItemInfo.musicEnd = paramInt2;
      }
      else
      {
        localMusicItemInfo = this.o;
        localMusicItemInfo.musicStart = paramInt1;
        localMusicItemInfo.musicEnd = (paramInt1 + this.G);
      }
      b(this.o.musicStart, this.o.musicEnd);
    }
  }
  
  void c(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((WeakReferenceHandler)localObject).obtainMessage();
      ((Message)localObject).what = 4;
      ((Message)localObject).arg1 = paramInt;
      this.a.sendMessage((Message)localObject);
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3);
    if (this.F != null) {
      this.F.c(true);
    }
    if (this.N != null)
    {
      if (this.D == 0)
      {
        this.N.a(this.o, true, this.D);
        return;
      }
      this.N.a(this.o);
    }
  }
  
  public void g()
  {
    if (this.K.compareAndSet(true, false))
    {
      this.N.c(this.o);
      this.o.mProgress = -1;
    }
    Object localObject = this.o;
    if ((localObject != null) && (this.J))
    {
      ((MusicItemInfo)localObject).musicStart = this.p;
      ((MusicItemInfo)localObject).musicEnd = this.q;
      this.N.e();
      this.N.a(this.D);
      if (((QIMMusicConfigManager)QIMManager.a(2)).a(this.o.mItemId) == null)
      {
        FileUtils.c(new File(this.o.getLocalPath()));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("delete file=");
          ((StringBuilder)localObject).append(this.o.mMusicName);
          QLog.d("MusicFragmentProviderView", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("cancel musicStart=");
        ((StringBuilder)localObject).append(this.o.musicStart);
        ((StringBuilder)localObject).append(" musicEnd=");
        ((StringBuilder)localObject).append(this.o.musicEnd);
        ((StringBuilder)localObject).append(" musicDuration");
        ((StringBuilder)localObject).append(this.o.musicDuration);
        ((StringBuilder)localObject).append(" premusicStart");
        ((StringBuilder)localObject).append(this.p);
        ((StringBuilder)localObject).append(" premusicEnd");
        ((StringBuilder)localObject).append(this.q);
        ((StringBuilder)localObject).append(" musicName");
        ((StringBuilder)localObject).append(this.o.mMusicName);
        QLog.d("MusicFragmentProviderView", 2, ((StringBuilder)localObject).toString());
      }
      this.o = null;
      i();
    }
    if (this.F != null) {
      this.F.a(1);
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
      this.a = null;
    }
    this.N.b(this.P);
    this.N = null;
  }
  
  protected int getInflateLayout()
  {
    return 2131627198;
  }
  
  public void h()
  {
    if ((this.o != null) && (this.J))
    {
      if (this.D == 0) {
        this.N.a(this.o, true, this.D);
      } else {
        this.N.a(this.o);
      }
      if (this.F != null) {
        this.F.c(true);
      }
      ((QIMMusicConfigManager)QIMManager.a(2)).a(this.o, true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("complete musicStart=");
        ((StringBuilder)localObject).append(this.o.musicStart);
        ((StringBuilder)localObject).append(" musicEnd=");
        ((StringBuilder)localObject).append(this.o.musicEnd);
        ((StringBuilder)localObject).append(" musicDuration");
        ((StringBuilder)localObject).append(this.o.musicDuration);
        ((StringBuilder)localObject).append(" premusicStart");
        ((StringBuilder)localObject).append(this.p);
        ((StringBuilder)localObject).append(" premusicEnd");
        ((StringBuilder)localObject).append(this.q);
        ((StringBuilder)localObject).append(" musicName");
        ((StringBuilder)localObject).append(this.o.mMusicName);
        QLog.d("MusicFragmentProviderView", 2, ((StringBuilder)localObject).toString());
      }
      this.o = null;
      i();
    }
    if (this.F != null) {
      this.F.a(1);
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
      this.a = null;
    }
    localObject = this.N;
    if (localObject != null)
    {
      ((QimMusicPlayer)localObject).b(this.P);
      this.N = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    boolean bool = true;
    Object localObject;
    switch (i1)
    {
    default: 
      return false;
    case 8: 
      i1 = paramMessage.arg1;
      if (i1 == 0)
      {
        this.c.setVisibility(8);
      }
      else if (i1 == -104)
      {
        this.n.setVisibility(0);
        this.g.setVisibility(8);
        this.f.setText(this.r.getResources().getString(2131896298));
      }
      else
      {
        this.n.setVisibility(0);
        this.g.setVisibility(8);
        this.f.setText(this.r.getResources().getString(2131896293));
      }
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("MSG_UPDATE_DOWNLOAD_FINISH_STATE finishState=");
        paramMessage.append(i1);
        QLog.d("MusicFragmentProviderView", 2, paramMessage.toString());
        return false;
      }
      break;
    case 7: 
      String str = this.r.getResources().getString(2131896293);
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
        this.o.mUrl = paramMessage.url;
        this.o.fileSize = paramMessage.size;
        this.o.mAlbumUrl = paramMessage.albumUrl;
        if ((paramMessage.playable == 1) && (!TextUtils.isEmpty(paramMessage.url)))
        {
          this.N.a(this.o, this.O);
          return false;
        }
        localObject = str;
        if (paramMessage.playable != 1) {
          localObject = this.r.getResources().getString(2131896294);
        }
      }
      this.n.setVisibility(0);
      this.f.setText((CharSequence)localObject);
      this.g.setVisibility(8);
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
      this.l.setText(paramMessage);
      this.l.setVisibility(0);
      return false;
    case 5: 
      if (this.o == null) {
        return false;
      }
      i1 = paramMessage.arg1;
      this.b.a(i1);
      b(this.o.musicStart, this.o.musicEnd);
      return false;
    case 4: 
      i1 = paramMessage.arg1;
      if (i1 == 1) {
        this.f.setText(this.r.getResources().getString(2131896297));
      }
      this.n.setVisibility(8);
      this.g.setVisibility(8);
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("MSG_UPDATE_NET_CHANGE state=");
        paramMessage.append(i1);
        QLog.d("MusicFragmentProviderView", 2, paramMessage.toString());
        return false;
      }
      break;
    case 3: 
      this.f.setText(this.r.getResources().getString(2131896299));
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
      paramMessage = this.o;
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
      i1 = paramMessage.arg1;
      this.c.setVisibility(0);
      this.d.setVisibility(8);
      if (i1 >= 100)
      {
        this.c.setVisibility(8);
        return false;
      }
      this.n.setVisibility(8);
      this.m.setProgress(i1);
      this.g.setVisibility(8);
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("MSG_UPDATE_PROGRESS percent=");
        paramMessage.append(i1);
        QLog.d("MusicFragmentProviderView", 2, paramMessage.toString());
        return false;
      }
      break;
    case 0: 
      this.b.setPlayedPosition(this.H.get());
    }
    return false;
  }
  
  protected void i()
  {
    Object localObject = this.I;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.I = null;
    }
    localObject = this.L;
    if (localObject != null)
    {
      ((MusicFragmentProviderView.MusicPlayTask)localObject).cancel();
      this.L = null;
    }
  }
  
  void j()
  {
    i();
    this.I = new Timer();
    this.L = new MusicFragmentProviderView.MusicPlayTask(this);
    this.M = 400L;
    if (this.G > CodecParam.RECORD_MAX_TIME)
    {
      this.M = ((this.G * 400.0F / CodecParam.RECORD_MAX_TIME));
    }
    else
    {
      int i1 = this.G;
      if (i1 < 5000) {
        this.M = ((i1 * 400.0F / 5000));
      }
    }
    this.I.schedule(this.L, 0L, this.M);
  }
  
  public boolean k()
  {
    g();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131430135)
    {
      if (i1 != 2131430159)
      {
        if (i1 != 2131432112) {
          return;
        }
        if (!this.N.b(this.o)) {
          m();
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
    this.a = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.o = paramMusicItemInfo;
    ((QIMMusicConfigManager)localObject).f = paramMusicItemInfo;
    this.H.set(-1);
    this.J = false;
    this.K.set(false);
    this.N = ((QimMusicPlayer)QIMManager.a().d(8));
    if (this.F != null)
    {
      this.G = this.F.b();
      if (this.G < 1000) {
        this.G = 1000;
      }
    }
    else
    {
      this.G = 10000;
    }
    if (this.G == CodecParam.SEGMENT_RECORD_MAX_TIME)
    {
      this.M = ((int)(this.G * 1.0F / (getDisplayedVideoLength() + 1) * 400.0F));
    }
    else
    {
      int i1 = this.G;
      double d1 = i1 / 6;
      Double.isNaN(d1);
      int i2 = (int)(d1 * 0.4D);
      long l1;
      if (i1 < 5000) {
        l1 = i2;
      } else {
        l1 = 400L;
      }
      this.M = l1;
    }
    this.N.e();
    if (this.N.b(paramMusicItemInfo))
    {
      this.c.setVisibility(8);
      this.a.sendEmptyMessage(2);
    }
    else
    {
      this.m.setProgress(1);
      this.f.setText(this.r.getResources().getString(2131892665));
      this.n.setVisibility(8);
      this.g.setVisibility(8);
      this.f.setVisibility(0);
      this.c.setVisibility(0);
      this.d.setVisibility(8);
      this.i.setEnabled(false);
      m();
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
    this.N.a(this.P);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.MusicFragmentProviderView
 * JD-Core Version:    0.7.0.1
 */