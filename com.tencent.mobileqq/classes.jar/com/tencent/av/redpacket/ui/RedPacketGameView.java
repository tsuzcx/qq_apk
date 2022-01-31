package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.content.res.Resources;
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
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.LocalFrameSyncInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalHitInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.redbag.RedBagReport;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import jnp;
import jnq;
import jns;
import jnt;

public class RedPacketGameView
  extends RelativeLayout
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, View.OnClickListener
{
  public int a;
  public long a;
  public Bitmap a;
  public Paint a;
  public View a;
  public RedPacketGameEmojiAnimation a;
  public RedPacketGameParticleLightning a;
  public RedPacketGameScore a;
  public RedPacketGameStartAnimation a;
  public boolean a;
  public RedPacketGameSprite[] a;
  public int b;
  public long b;
  public Bitmap b;
  public boolean b;
  public Bitmap c;
  
  public RedPacketGameView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleLightning = new RedPacketGameParticleLightning();
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite[10];
    this.jdField_a_of_type_Int = 0;
    a(paramContext);
  }
  
  public RedPacketGameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleLightning = new RedPacketGameParticleLightning();
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite[10];
    this.jdField_a_of_type_Int = 0;
    a(paramContext);
  }
  
  public RedPacketGameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleLightning = new RedPacketGameParticleLightning();
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite[10];
    this.jdField_a_of_type_Int = 0;
    a(paramContext);
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
        localObject = (VideoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366246);
        if (localObject != null) {
          ((VideoView)localObject).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
        }
      }
      Object localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).post(new jnt(this, (ViewGroup)localObject));
      }
    }
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(int paramInt, List paramList)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation != null) {}
    for (l = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation.a(l - 2333L);; l = 0L)
    {
      AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation.a(paramList);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameScore.c(paramInt);
      if (l > 0L)
      {
        postDelayed(new jnp(this, localAVRedPacketManager), l);
        return;
      }
      localAVRedPacketManager.a(1, false);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Int == 1) {
      if ((this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation != null) && (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation.a(paramLong)))
      {
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation.a();
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation = null;
        ((AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6)).g();
      }
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleLightning.a(paramLong);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation.b(paramLong);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameScore.a(paramLong);
  }
  
  public void a(Context paramContext)
  {
    setId(2131362541);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation = new RedPacketGameStartAnimation(paramContext);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation = new RedPacketGameEmojiAnimation(paramContext);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameScore = new RedPacketGameScore(this);
  }
  
  public void a(Canvas paramCanvas, long paramLong)
  {
    if (this.jdField_a_of_type_Int == 1) {
      if ((this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation != null) && (this.jdField_a_of_type_AndroidViewView == null)) {
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleLightning.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameScore.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
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
      if (localAVRedPacketManager.b(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation.a(paramLocalFrameSyncInfo.localHitInfo.emojiId))) {
        postDelayed(new jnq(this, localAVRedPacketManager), 50L);
      }
    }
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameView", 2, "preLoadRes start,avRedPacketManager = " + paramAVRedPacketManager);
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation.a(paramAVRedPacketManager);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation.b(paramAVRedPacketManager);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[i] = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_score_" + i + ".png"));
      i += 1;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleLightning.a(paramAVRedPacketManager);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation.a(paramAVRedPacketManager, this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameScore.a(paramAVRedPacketManager, this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite);
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameView", 2, "preLoadRes end");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6);
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation.a(localAVRedPacketManager);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation.a(paramBoolean, localAVRedPacketManager);
    long l = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation.a(l);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation.a(paramBoolean);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameScore.a(paramBoolean, localAVRedPacketManager);
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    QLog.d("RedPacketGameView", 2, "WL_DEBUG updateState localFrameSyncInfo = " + paramLocalFrameSyncInfo.toString());
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameScore.a(paramBoolean, paramLocalFrameSyncInfo);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation.b(paramBoolean, paramLocalFrameSyncInfo);
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
    AVActivity localAVActivity = (AVActivity)getContext();
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localAVActivity.a(localAVActivity.getText(2131429615), 10000, null);
        return;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localAVActivity.getText(2131429614));
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131493308)), 0, 7, 34);
      localAVActivity.a(localSpannableStringBuilder, 10000, new jns(this, localAVActivity));
      return;
    }
    localAVActivity.n();
  }
  
  public void c()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleLightning.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation.a(l);
    this.jdField_a_of_type_Int = 2;
  }
  
  public void c(boolean paramBoolean)
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    if (paramBoolean)
    {
      localAVActivity.a(localAVActivity.getText(2131429616), 3000, null);
      return;
    }
    localAVActivity.n();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation.b();
  }
  
  public void d(boolean paramBoolean)
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    if (paramBoolean)
    {
      localAVActivity.a(localAVActivity.getText(2131429617), 5000, null);
      if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation != null) {
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation.a(0L);
      }
      return;
    }
    localAVActivity.n();
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
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleLightning.b();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameScore.b();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation.a();
    RedPacketGameSprite[] arrayOfRedPacketGameSprite = this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite;
    int j = arrayOfRedPacketGameSprite.length;
    int i = 0;
    while (i < j)
    {
      RedPacketGameSprite localRedPacketGameSprite = arrayOfRedPacketGameSprite[i];
      if (localRedPacketGameSprite != null) {
        localRedPacketGameSprite.a();
      }
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation != null) {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation.a();
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleLightning = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameScore = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation = null;
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = null;
    this.jdField_a_of_type_AndroidGraphicsPaint = null;
    h();
  }
  
  public void e(boolean paramBoolean)
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    if (paramBoolean)
    {
      localAVActivity.a(localAVActivity.getText(2131429618), 5000, null);
      if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation != null) {
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation.a(0L);
      }
      return;
    }
    localAVActivity.n();
  }
  
  public void f()
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    Object localObject1 = localAVActivity.getLayoutInflater();
    Object localObject2 = (ViewGroup)getParent();
    AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6);
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)localObject2).findViewById(2131366245);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      ((LayoutInflater)localObject1).inflate(2130969346, (ViewGroup)localObject2);
      this.jdField_a_of_type_AndroidViewView = ((ViewGroup)localObject2).findViewById(2131366245);
    }
    localObject1 = (VideoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366246);
    String str = RedBagUtil.b() + "qav_redpacket_guide.mp4";
    ((VideoView)localObject1).setVideoPath(str);
    ((VideoView)localObject1).setOnErrorListener(this);
    ((VideoView)localObject1).setOnCompletionListener(this);
    ((VideoView)localObject1).setOnPreparedListener(this);
    ((VideoView)localObject1).setZOrderOnTop(true);
    ((VideoView)localObject1).setZOrderMediaOverlay(true);
    ((VideoView)localObject1).setOnInfoListener(this);
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
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131366247);
      if (this.c == null) {
        this.c = localAVRedPacketManager.a("qav_redpacket_receive_popup.png");
      }
      if (this.c != null) {
        ((View)localObject1).setBackgroundDrawable(new BitmapDrawable(this.c));
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131366248);
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_b_of_type_AndroidGraphicsBitmap = localAVRedPacketManager.a("qav_redpacket_result_close.png");
      }
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
        ((View)localObject1).setBackgroundDrawable(TintStateDrawable.a(localAVActivity.getResources(), this.jdField_b_of_type_AndroidGraphicsBitmap, 2131494077));
      }
      ((View)localObject1).setOnClickListener(this);
      RedBagReport.k();
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
    RedBagReport.l();
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
      paramMediaPlayer = (VideoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366246);
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
      paramMediaPlayer = (VideoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366246);
      if (paramMediaPlayer != null) {
        paramMediaPlayer.start();
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation != null) {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameStartAnimation.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleLightning.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameEmojiAnimation.a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameScore.a(paramInt1, paramInt2, paramInt3, paramInt4);
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
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameScore.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameView
 * JD-Core Version:    0.7.0.1
 */