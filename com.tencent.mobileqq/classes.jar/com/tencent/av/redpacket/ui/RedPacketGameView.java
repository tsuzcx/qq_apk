package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.LocalEmojiInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalFrameSyncInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalHitInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import lwr;
import lxn;
import lxs;
import lxt;
import lxu;
import lxv;
import mdd;
import mso;
import msp;
import mwj;

public class RedPacketGameView
  extends RelativeLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, View.OnClickListener
{
  public int a;
  public long a;
  public Bitmap a;
  public Paint a;
  public View a;
  public lwr a;
  public lxn a;
  public lxs a;
  public lxu a;
  public boolean a;
  public lxt[] a;
  public int b;
  public long b;
  public Bitmap b;
  public boolean b;
  public Bitmap c;
  
  public RedPacketGameView(Context paramContext, AVActivity paramAVActivity)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_Lxn = new lxn();
    this.jdField_a_of_type_ArrayOfLxt = new lxt[10];
    this.jdField_a_of_type_Int = 0;
    a(paramContext, paramAVActivity);
  }
  
  private Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    Object localObject = null;
    if (paramBitmap != null)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramFloat);
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
      localObject = localBitmap;
      if (!localBitmap.equals(paramBitmap))
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
    }
    return localObject;
  }
  
  private void g()
  {
    h();
    ((AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6)).f();
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        localObject = (VideoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372812);
        if (localObject != null) {
          ((VideoView)localObject).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
        }
      }
      Object localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).post(new RedPacketGameView.4(this, (ViewGroup)localObject));
      }
    }
  }
  
  public AVActivity a()
  {
    Context localContext = getContext();
    if ((localContext instanceof AVActivity)) {
      return (AVActivity)localContext;
    }
    return null;
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(int paramInt, List<AVRedPacketManager.LocalEmojiInfo> paramList)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (this.jdField_a_of_type_Lxu != null) {}
    for (l = this.jdField_a_of_type_Lxu.a(l - 2333L);; l = 0L)
    {
      AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6);
      this.jdField_a_of_type_Lwr.a(paramList);
      this.jdField_a_of_type_Lxs.c(paramInt);
      if (l > 0L)
      {
        postDelayed(new RedPacketGameView.1(this, localAVRedPacketManager), l);
        return;
      }
      localAVRedPacketManager.a(1, false);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Int == 1) {
      if ((this.jdField_a_of_type_Lxu != null) && (this.jdField_a_of_type_Lxu.a(paramLong)))
      {
        this.jdField_a_of_type_Lxu.a();
        this.jdField_a_of_type_Lxu = null;
        ((AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6)).g();
      }
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    this.jdField_a_of_type_Lxn.a(paramLong);
    this.jdField_a_of_type_Lwr.b(paramLong);
    this.jdField_a_of_type_Lxs.a(paramLong);
  }
  
  public void a(Context paramContext, AVActivity paramAVActivity)
  {
    setId(2131372806);
    this.jdField_a_of_type_Lxu = new lxu(paramContext);
    this.jdField_a_of_type_Lwr = new lwr(paramContext);
    this.jdField_a_of_type_Lxs = new lxs(this, paramAVActivity);
  }
  
  public void a(Canvas paramCanvas, long paramLong)
  {
    if (this.jdField_a_of_type_Int == 1) {
      if ((this.jdField_a_of_type_Lxu != null) && (this.jdField_a_of_type_AndroidViewView == null)) {
        this.jdField_a_of_type_Lxu.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    this.jdField_a_of_type_Lwr.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_Lxn.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_Lxs.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a(AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    int j = 0;
    a(false, paramLocalFrameSyncInfo);
    int i = j;
    if (paramLocalFrameSyncInfo.localHitInfo.topWordTipType != 3)
    {
      i = j;
      if (paramLocalFrameSyncInfo.localHitInfo.topWordTipType != 0) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6);
      if (localAVRedPacketManager.b(this.jdField_a_of_type_Lwr.a(paramLocalFrameSyncInfo.localHitInfo.emojiId))) {
        postDelayed(new RedPacketGameView.2(this, localAVRedPacketManager), 50L);
      }
    }
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameView", 2, "preLoadRes start,avRedPacketManager = " + paramAVRedPacketManager);
    }
    this.jdField_a_of_type_Lxu.a(paramAVRedPacketManager);
    this.jdField_a_of_type_Lwr.b(paramAVRedPacketManager);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfLxt.length)
    {
      this.jdField_a_of_type_ArrayOfLxt[i] = new lxt(paramAVRedPacketManager.a("qav_redpacket_score_" + i + ".png"));
      i += 1;
    }
    this.jdField_a_of_type_Lxn.a(paramAVRedPacketManager);
    this.jdField_a_of_type_Lwr.a(paramAVRedPacketManager, this.jdField_a_of_type_ArrayOfLxt);
    this.jdField_a_of_type_Lxs.a(paramAVRedPacketManager, this.jdField_a_of_type_ArrayOfLxt);
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameView", 2, "preLoadRes end");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6);
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Lwr.a(localAVRedPacketManager);
    this.jdField_a_of_type_Lxu.a(paramBoolean, localAVRedPacketManager);
    long l = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_Lxu.a(l);
    this.jdField_a_of_type_Lwr.a(paramBoolean);
    this.jdField_a_of_type_Lxs.a(paramBoolean, localAVRedPacketManager);
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    QLog.d("RedPacketGameView", 2, "WL_DEBUG updateState localFrameSyncInfo = " + paramLocalFrameSyncInfo.toString());
    this.jdField_a_of_type_Lxs.a(paramBoolean, paramLocalFrameSyncInfo);
    this.jdField_a_of_type_Lwr.b(paramBoolean, paramLocalFrameSyncInfo);
  }
  
  public void b()
  {
    a(false);
  }
  
  public void b(AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    if ((this.jdField_a_of_type_Int != 2) && (paramLocalFrameSyncInfo.localEmojiInfos.size() > 0)) {
      this.jdField_a_of_type_Int = 2;
    }
    a(true, paramLocalFrameSyncInfo);
  }
  
  public void b(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        mdd.a(localVideoAppInterface, 1045, 2131696271);
        return;
      }
      QLog.w("RedPacketGameView", 1, "showCameraOpenTip, isShow[" + paramBoolean + "], seq[" + l + "]");
      mdd.a(localVideoAppInterface, 1046, null, new lxv(this, l));
      return;
    }
    mdd.a(localVideoAppInterface, 1045);
  }
  
  public void c()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_Lxn.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_Lwr.a(l);
    this.jdField_a_of_type_Int = 2;
  }
  
  public void c(boolean paramBoolean)
  {
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      mdd.a(localVideoAppInterface, 1045, 2131696282);
      return;
    }
    mdd.a(localVideoAppInterface, 1045);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Lwr.b();
  }
  
  public void d(boolean paramBoolean)
  {
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      mdd.a(localVideoAppInterface, 1045, 2131696283);
      if (this.jdField_a_of_type_Lxu != null) {
        this.jdField_a_of_type_Lxu.a(0L);
      }
      return;
    }
    mdd.a(localVideoAppInterface, 1045);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    a(this.jdField_b_of_type_Long);
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    a(paramCanvas, this.jdField_b_of_type_Long);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    QLog.d("RedPacketGameView", 2, "WL_DEBUG update cost = " + (l1 - this.jdField_b_of_type_Long) + ", doDraw cost = " + (l2 - l1));
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean) {
      invalidate();
    }
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
    }
    this.jdField_b_of_type_Int += 1;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Lxn.b();
    this.jdField_a_of_type_Lxs.b();
    this.jdField_a_of_type_Lwr.a();
    lxt[] arrayOflxt = this.jdField_a_of_type_ArrayOfLxt;
    int j = arrayOflxt.length;
    int i = 0;
    while (i < j)
    {
      lxt locallxt = arrayOflxt[i];
      if (locallxt != null) {
        locallxt.a();
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Lxu != null) {
      this.jdField_a_of_type_Lxu.a();
    }
    this.jdField_a_of_type_Lxu = null;
    this.jdField_a_of_type_Lxn = null;
    this.jdField_a_of_type_Lxs = null;
    this.jdField_a_of_type_Lwr = null;
    this.jdField_a_of_type_ArrayOfLxt = null;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    h();
  }
  
  public void e(boolean paramBoolean)
  {
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      mdd.a(localVideoAppInterface, 1045, 2131696284);
      if (this.jdField_a_of_type_Lxu != null) {
        this.jdField_a_of_type_Lxu.a(0L);
      }
      return;
    }
    mdd.a(localVideoAppInterface, 1045);
  }
  
  public void f()
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    Object localObject1 = localAVActivity.getLayoutInflater();
    Object localObject2 = (ViewGroup)getParent();
    AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6);
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)localObject2).findViewById(2131372811);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      ((LayoutInflater)localObject1).inflate(2131559625, (ViewGroup)localObject2);
      this.jdField_a_of_type_AndroidViewView = ((ViewGroup)localObject2).findViewById(2131372811);
    }
    localObject1 = (VideoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372812);
    String str = msp.c() + "qav_redpacket_guide.mp4";
    ((VideoView)localObject1).setVideoPath(str);
    ((VideoView)localObject1).setOnErrorListener(this);
    ((VideoView)localObject1).setOnCompletionListener(this);
    ((VideoView)localObject1).setOnPreparedListener(this);
    ((VideoView)localObject1).setZOrderOnTop(true);
    ((VideoView)localObject1).setZOrderMediaOverlay(true);
    if (Build.VERSION.SDK_INT >= 17) {
      ((VideoView)localObject1).setOnInfoListener(this);
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      localObject2 = new MediaMetadataRetriever();
    }
    try
    {
      ((MediaMetadataRetriever)localObject2).setDataSource(str);
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((MediaMetadataRetriever)localObject2).getFrameAtTime(0L);
      ((MediaMetadataRetriever)localObject2).release();
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        ((VideoView)localObject1).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131372810);
      if (this.c == null) {
        this.c = localAVRedPacketManager.a("qav_redpacket_receive_popup.png");
      }
      if (this.c != null) {
        ((View)localObject1).setBackgroundDrawable(new BitmapDrawable(this.c));
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131372809);
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_b_of_type_AndroidGraphicsBitmap = localAVRedPacketManager.a("qav_redpacket_result_close.png");
      }
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
        ((View)localObject1).setBackgroundDrawable(mwj.a(localAVActivity.getResources(), this.jdField_b_of_type_AndroidGraphicsBitmap, 2131165958));
      }
      ((View)localObject1).setOnClickListener(this);
      mso.k();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketGameView", 2, "showReceiverUserGuide e = " + localException);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    g();
    mso.l();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    g();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    g();
    return false;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt1 == 3))
    {
      paramMediaPlayer = (VideoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372812);
      if (paramMediaPlayer != null) {
        paramMediaPlayer.setBackgroundDrawable(null);
      }
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      paramMediaPlayer = (VideoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372812);
      if (paramMediaPlayer != null) {
        paramMediaPlayer.start();
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Lxu != null) {
      this.jdField_a_of_type_Lxu.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.jdField_a_of_type_Lxn.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lwr.a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lxs.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setIsRunning(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    invalidate();
  }
  
  public void setScoreMarginTop(int paramInt)
  {
    this.jdField_a_of_type_Lxs.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameView
 * JD-Core Version:    0.7.0.1
 */