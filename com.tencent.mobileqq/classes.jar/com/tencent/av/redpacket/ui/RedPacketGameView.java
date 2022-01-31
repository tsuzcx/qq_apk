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
import lup;
import lvl;
import lvq;
import lvr;
import lvs;
import lvt;
import mat;
import mpx;
import mpy;
import mts;

public class RedPacketGameView
  extends RelativeLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, View.OnClickListener
{
  public int a;
  public long a;
  public Bitmap a;
  public Paint a;
  public View a;
  public lup a;
  public lvl a;
  public lvq a;
  public lvs a;
  public boolean a;
  public lvr[] a;
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
    this.jdField_a_of_type_Lvl = new lvl();
    this.jdField_a_of_type_ArrayOfLvr = new lvr[10];
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
        localObject = (VideoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372454);
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
    if (this.jdField_a_of_type_Lvs != null) {}
    for (l = this.jdField_a_of_type_Lvs.a(l - 2333L);; l = 0L)
    {
      AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6);
      this.jdField_a_of_type_Lup.a(paramList);
      this.jdField_a_of_type_Lvq.c(paramInt);
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
      if ((this.jdField_a_of_type_Lvs != null) && (this.jdField_a_of_type_Lvs.a(paramLong)))
      {
        this.jdField_a_of_type_Lvs.a();
        this.jdField_a_of_type_Lvs = null;
        ((AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6)).g();
      }
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    this.jdField_a_of_type_Lvl.a(paramLong);
    this.jdField_a_of_type_Lup.b(paramLong);
    this.jdField_a_of_type_Lvq.a(paramLong);
  }
  
  public void a(Context paramContext, AVActivity paramAVActivity)
  {
    setId(2131372448);
    this.jdField_a_of_type_Lvs = new lvs(paramContext);
    this.jdField_a_of_type_Lup = new lup(paramContext);
    this.jdField_a_of_type_Lvq = new lvq(this, paramAVActivity);
  }
  
  public void a(Canvas paramCanvas, long paramLong)
  {
    if (this.jdField_a_of_type_Int == 1) {
      if ((this.jdField_a_of_type_Lvs != null) && (this.jdField_a_of_type_AndroidViewView == null)) {
        this.jdField_a_of_type_Lvs.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    this.jdField_a_of_type_Lup.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_Lvl.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_Lvq.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
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
      if (localAVRedPacketManager.b(this.jdField_a_of_type_Lup.a(paramLocalFrameSyncInfo.localHitInfo.emojiId))) {
        postDelayed(new RedPacketGameView.2(this, localAVRedPacketManager), 50L);
      }
    }
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameView", 2, "preLoadRes start,avRedPacketManager = " + paramAVRedPacketManager);
    }
    this.jdField_a_of_type_Lvs.a(paramAVRedPacketManager);
    this.jdField_a_of_type_Lup.b(paramAVRedPacketManager);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfLvr.length)
    {
      this.jdField_a_of_type_ArrayOfLvr[i] = new lvr(paramAVRedPacketManager.a("qav_redpacket_score_" + i + ".png"));
      i += 1;
    }
    this.jdField_a_of_type_Lvl.a(paramAVRedPacketManager);
    this.jdField_a_of_type_Lup.a(paramAVRedPacketManager, this.jdField_a_of_type_ArrayOfLvr);
    this.jdField_a_of_type_Lvq.a(paramAVRedPacketManager, this.jdField_a_of_type_ArrayOfLvr);
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameView", 2, "preLoadRes end");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6);
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Lup.a(localAVRedPacketManager);
    this.jdField_a_of_type_Lvs.a(paramBoolean, localAVRedPacketManager);
    long l = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_Lvs.a(l);
    this.jdField_a_of_type_Lup.a(paramBoolean);
    this.jdField_a_of_type_Lvq.a(paramBoolean, localAVRedPacketManager);
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    QLog.d("RedPacketGameView", 2, "WL_DEBUG updateState localFrameSyncInfo = " + paramLocalFrameSyncInfo.toString());
    this.jdField_a_of_type_Lvq.a(paramBoolean, paramLocalFrameSyncInfo);
    this.jdField_a_of_type_Lup.b(paramBoolean, paramLocalFrameSyncInfo);
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
        mat.a(localVideoAppInterface, 1045, 2131696108);
        return;
      }
      QLog.w("RedPacketGameView", 1, "showCameraOpenTip, isShow[" + paramBoolean + "], seq[" + l + "]");
      mat.a(localVideoAppInterface, 1046, null, new lvt(this, l));
      return;
    }
    mat.a(localVideoAppInterface, 1045);
  }
  
  public void c()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_Lvl.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_Lup.a(l);
    this.jdField_a_of_type_Int = 2;
  }
  
  public void c(boolean paramBoolean)
  {
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      mat.a(localVideoAppInterface, 1045, 2131696119);
      return;
    }
    mat.a(localVideoAppInterface, 1045);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Lup.b();
  }
  
  public void d(boolean paramBoolean)
  {
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      mat.a(localVideoAppInterface, 1045, 2131696120);
      if (this.jdField_a_of_type_Lvs != null) {
        this.jdField_a_of_type_Lvs.a(0L);
      }
      return;
    }
    mat.a(localVideoAppInterface, 1045);
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
    this.jdField_a_of_type_Lvl.b();
    this.jdField_a_of_type_Lvq.b();
    this.jdField_a_of_type_Lup.a();
    lvr[] arrayOflvr = this.jdField_a_of_type_ArrayOfLvr;
    int j = arrayOflvr.length;
    int i = 0;
    while (i < j)
    {
      lvr locallvr = arrayOflvr[i];
      if (locallvr != null) {
        locallvr.a();
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Lvs != null) {
      this.jdField_a_of_type_Lvs.a();
    }
    this.jdField_a_of_type_Lvs = null;
    this.jdField_a_of_type_Lvl = null;
    this.jdField_a_of_type_Lvq = null;
    this.jdField_a_of_type_Lup = null;
    this.jdField_a_of_type_ArrayOfLvr = null;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    h();
  }
  
  public void e(boolean paramBoolean)
  {
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      mat.a(localVideoAppInterface, 1045, 2131696121);
      if (this.jdField_a_of_type_Lvs != null) {
        this.jdField_a_of_type_Lvs.a(0L);
      }
      return;
    }
    mat.a(localVideoAppInterface, 1045);
  }
  
  public void f()
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    Object localObject1 = localAVActivity.getLayoutInflater();
    Object localObject2 = (ViewGroup)getParent();
    AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6);
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)localObject2).findViewById(2131372453);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      ((LayoutInflater)localObject1).inflate(2131559573, (ViewGroup)localObject2);
      this.jdField_a_of_type_AndroidViewView = ((ViewGroup)localObject2).findViewById(2131372453);
    }
    localObject1 = (VideoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372454);
    String str = mpy.c() + "qav_redpacket_guide.mp4";
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
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131372452);
      if (this.c == null) {
        this.c = localAVRedPacketManager.a("qav_redpacket_receive_popup.png");
      }
      if (this.c != null) {
        ((View)localObject1).setBackgroundDrawable(new BitmapDrawable(this.c));
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131372451);
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_b_of_type_AndroidGraphicsBitmap = localAVRedPacketManager.a("qav_redpacket_result_close.png");
      }
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
        ((View)localObject1).setBackgroundDrawable(mts.a(localAVActivity.getResources(), this.jdField_b_of_type_AndroidGraphicsBitmap, 2131165919));
      }
      ((View)localObject1).setOnClickListener(this);
      mpx.k();
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
    mpx.l();
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
      paramMediaPlayer = (VideoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372454);
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
      paramMediaPlayer = (VideoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372454);
      if (paramMediaPlayer != null) {
        paramMediaPlayer.start();
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Lvs != null) {
      this.jdField_a_of_type_Lvs.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.jdField_a_of_type_Lvl.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lup.a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Lvq.a(paramInt1, paramInt2, paramInt3, paramInt4);
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
    this.jdField_a_of_type_Lvq.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameView
 * JD-Core Version:    0.7.0.1
 */