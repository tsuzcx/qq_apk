package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Vibrator;
import com.tencent.av.doodle.MathUtils;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.LocalEmojiInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalFrameSyncInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalHitInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import jlm;

public class RedPacketGameEmojiAnimation
{
  public int a;
  public Vibrator a;
  public AVRedPacketManager a;
  public RedPacketGameParticleAddScore a;
  public RedPacketGameParticleEmoji a;
  public RedPacketGameParticleEmojiDetected a;
  public RedPacketGameParticleExcellent a;
  public RedPacketGameParticleFocus a;
  public RedPacketGameParticleFocusDetected a;
  public RedPacketGameParticleGold a;
  public RedPacketGameParticleTopWordTip a;
  public RedPacketGameParticleTopWordTipBackground a;
  public RedPacketGameSprite a;
  public List a;
  public boolean a;
  public RedPacketGameSprite[] a;
  public int b;
  private boolean b;
  public RedPacketGameSprite[] b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public RedPacketGameEmojiAnimation(Context paramContext)
  {
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite[10];
    this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite[4];
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji = new RedPacketGameParticleEmoji();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocus = new RedPacketGameParticleFocus(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected = new RedPacketGameParticleEmojiDetected();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocusDetected = new RedPacketGameParticleFocusDetected(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTip = new RedPacketGameParticleTopWordTip();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground = new RedPacketGameParticleTopWordTipBackground();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleAddScore = new RedPacketGameParticleAddScore(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleExcellent = new RedPacketGameParticleExcellent();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleGold = new RedPacketGameParticleGold(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.a(paramContext.getString(2131429613));
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localLocalEmojiInfo != null) {
        return localLocalEmojiInfo.emojiType;
      }
    }
    return -1;
  }
  
  public long a(AVRedPacketManager.LocalEmojiInfo paramLocalEmojiInfo)
  {
    long l2 = 3000L;
    long l1;
    if ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.d())) {
      l1 = 5000L;
    }
    do
    {
      do
      {
        return l1;
        l1 = l2;
      } while (paramLocalEmojiInfo == null);
      if (paramLocalEmojiInfo.fallDownDuration > 0) {
        return paramLocalEmojiInfo.fallDownDuration;
      }
      l1 = l2;
    } while (paramLocalEmojiInfo.emojiId < 3);
    return 2000L;
  }
  
  public void a()
  {
    int j = 0;
    RedPacketGameSprite[] arrayOfRedPacketGameSprite = this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite;
    int k = arrayOfRedPacketGameSprite.length;
    int i = 0;
    RedPacketGameSprite localRedPacketGameSprite;
    while (i < k)
    {
      localRedPacketGameSprite = arrayOfRedPacketGameSprite[i];
      if (localRedPacketGameSprite != null) {
        localRedPacketGameSprite.a();
      }
      i += 1;
    }
    arrayOfRedPacketGameSprite = this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite;
    k = arrayOfRedPacketGameSprite.length;
    i = j;
    while (i < k)
    {
      localRedPacketGameSprite = arrayOfRedPacketGameSprite[i];
      if (localRedPacketGameSprite != null) {
        localRedPacketGameSprite.a();
      }
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite != null) {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite.a();
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocus != null) {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocus.b();
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocusDetected != null) {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocusDetected.b();
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleAddScore != null) {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleAddScore.b();
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleExcellent != null) {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleExcellent.b();
    }
    if (this.jdField_a_of_type_AndroidOsVibrator != null) {
      this.jdField_a_of_type_AndroidOsVibrator.cancel();
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleGold != null) {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleGold.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameEmojiAnimation", 2, "recycle mAVRedPacketManager set to null");
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = null;
    this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = null;
    this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocus = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocusDetected = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTip = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleAddScore = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleExcellent = null;
    this.jdField_a_of_type_AndroidOsVibrator = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleGold = null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 3;
    if (paramInt1 == 1) {
      paramInt1 = i;
    }
    for (;;)
    {
      if ((paramInt1 != -1) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null)) {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(paramInt1, false);
      }
      if ((paramInt2 > 0) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null)) {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(6, false);
      }
      return;
      if (paramInt1 == 2) {
        paramInt1 = 2;
      } else if (paramInt1 == 3) {
        paramInt1 = 4;
      } else if (paramInt1 == 4) {
        paramInt1 = 5;
      } else {
        paramInt1 = -1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = (paramInt1 * 40 / 750);
    this.d = (paramInt1 * 600 / 750);
    this.e = (paramInt1 * 534 / 750);
    this.f = (paramInt1 * 260 / 750);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocus.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocusDetected.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTip.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleAddScore.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleExcellent.b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleGold.b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_Int = 0;
      AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.b(a(localLocalEmojiInfo));
      int i = this.jdField_a_of_type_Int % 3;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.b(i);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji$OnShowListener = new jlm(this);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[localLocalEmojiInfo.emojiType];
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_Long, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, 0L);
      }
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocus.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocus.a(localLocalEmojiInfo.isBigEmoji);
    }
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.a(paramCanvas, paramPaint);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocus.a(paramCanvas, paramPaint);
    int k;
    int m;
    int j;
    if (this.jdField_b_of_type_Boolean)
    {
      Rect localRect = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected.a();
      k = localRect.left;
      m = localRect.top;
      if (!MathUtils.a()) {
        break label155;
      }
      j = this.c;
    }
    for (int i = this.d;; i = this.f)
    {
      paramCanvas.translate(j - k, i - m);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocusDetected.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleGold.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleAddScore.a(paramCanvas, paramPaint);
      if (this.jdField_b_of_type_Boolean) {
        paramCanvas.restore();
      }
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleExcellent.a(paramCanvas, paramPaint);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTip.a(paramCanvas, paramPaint);
      return;
      label155:
      j = this.e;
    }
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketGameEmojiAnimation", 2, "setAVRedPacketManager1 avRedPacketManager = " + paramAVRedPacketManager);
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = paramAVRedPacketManager;
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager, RedPacketGameSprite[] paramArrayOfRedPacketGameSprite)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[i] = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_emoji_" + (i + 1) + ".png"));
      i += 1;
    }
    this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[0] = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_perfect.png"));
    this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[1] = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_cool.png"));
    this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[2] = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_miss.png"));
    this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[3] = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_excellent.png"));
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = new RedPacketGameSprite(paramAVRedPacketManager.a("qav_redpacket_miss_background.png"));
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleAddScore.a(paramAVRedPacketManager, paramArrayOfRedPacketGameSprite);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleExcellent.a(paramAVRedPacketManager);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    if ((paramLocalFrameSyncInfo.localHitInfo.topWordTipType == 3) || (paramLocalFrameSyncInfo.localHitInfo.topWordTipType == 0)) {
      break label21;
    }
    label21:
    while ((paramBoolean) && (this.jdField_b_of_type_Int == paramLocalFrameSyncInfo.localHitInfo.emojiId)) {
      return;
    }
    if (this.jdField_b_of_type_Int != paramLocalFrameSyncInfo.localHitInfo.emojiId)
    {
      this.jdField_b_of_type_Int = paramLocalFrameSyncInfo.localHitInfo.emojiId;
      this.jdField_a_of_type_AndroidOsVibrator.vibrate(200L);
    }
    if (paramBoolean) {
      a(paramLocalFrameSyncInfo.localHitInfo.topWordTipType, paramLocalFrameSyncInfo.localHitInfo.comboCnt);
    }
    long l;
    label105:
    AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo;
    if (paramBoolean)
    {
      l = NetConnInfoCenter.getServerTimeMillis();
      if (paramLocalFrameSyncInfo.localEmojiInfos.size() <= 0) {
        break label413;
      }
      localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)paramLocalFrameSyncInfo.localEmojiInfos.get(0);
    }
    for (;;)
    {
      label132:
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected.jdField_a_of_type_Long = l;
      Rect localRect = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.a();
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected.a(localRect.left, localRect.top, localRect.right, localRect.bottom);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocusDetected.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocusDetected.c();
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = null;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.b(-12375);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleAddScore.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleAddScore.c();
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleAddScore.a(paramLocalFrameSyncInfo.localHitInfo.comboCnt, paramLocalFrameSyncInfo.localHitInfo.newAddScore);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleGold.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleGold.c();
      if ((localLocalEmojiInfo != null) && (localLocalEmojiInfo.emojiId == paramLocalFrameSyncInfo.localHitInfo.emojiId))
      {
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[localLocalEmojiInfo.emojiType];
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected.a(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleAddScore.a(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocusDetected.a(localLocalEmojiInfo.isBigEmoji);
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTip.a(localLocalEmojiInfo.isBigEmoji);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTip.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTip.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[(paramLocalFrameSyncInfo.localHitInfo.topWordTipType - 1)];
        if (paramLocalFrameSyncInfo.localHitInfo.topWordTipType != 4) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleExcellent.jdField_a_of_type_Long = l;
        return;
        l = paramLocalFrameSyncInfo.localHitInfo.hitStartTime;
        break label105;
        label413:
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label473;
        }
        localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(paramLocalFrameSyncInfo.localHitInfo.emojiId);
        break label132;
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite;
      }
      label473:
      localLocalEmojiInfo = null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.a(true);
  }
  
  public void b(long paramLong)
  {
    long l1 = paramLong - this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_Boolean) {
      if ((l1 > this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.a()) && (this.jdField_b_of_type_Int != this.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite;
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.b(-9942110);
        l1 = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_Long + this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.a();
        if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.jdField_a_of_type_Long != l1)
        {
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.jdField_a_of_type_Long = l1;
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTip.jdField_a_of_type_Long = l1;
          a(3, 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketGameEmojiAnimation", 2, "send show miss mCurEmojiItemId = " + this.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTip.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[2];
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.a(paramLong);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocus.a(paramLong);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmojiDetected.a(paramLong);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocusDetected.a(paramLong);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.a(paramLong);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTip.a(paramLong);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleAddScore.a(paramLong);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleExcellent.a(paramLong);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleGold.a(paramLong);
      return;
      if ((l1 > this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.a()) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo;
        if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.d(localLocalEmojiInfo.emojiId);
          }
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite;
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.b(-9942110);
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTip.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTip.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[2];
          this.jdField_a_of_type_Int += 1;
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.a(false);
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
          RedPacketGameParticleEmoji localRedPacketGameParticleEmoji = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji;
          localRedPacketGameParticleEmoji.jdField_a_of_type_Long += this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.a() + 500L;
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.b(a(localLocalEmojiInfo));
          int i = this.jdField_a_of_type_Int % 3;
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.b(i);
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[localLocalEmojiInfo.emojiType];
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocus.a(localLocalEmojiInfo.isBigEmoji);
          long l2 = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_Long - NetConnInfoCenter.getServerTimeMillis();
          l1 = l2;
          if (l2 < 0L) {
            l1 = 0L;
          }
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_Long, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, l1);
          }
        }
        else if (this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.d(localLocalEmojiInfo.emojiId);
          }
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite;
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.b(-9942110);
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTipBackground.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTip.jdField_a_of_type_Long = paramLong;
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleTopWordTip.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = this.jdField_b_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[2];
          this.jdField_a_of_type_Int += 1;
        }
      }
    }
  }
  
  public void b(AVRedPacketManager paramAVRedPacketManager)
  {
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocus.a(paramAVRedPacketManager);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocusDetected.a(paramAVRedPacketManager);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleGold.a(paramAVRedPacketManager);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean, AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    long l1 = 0L;
    a(paramBoolean, paramLocalFrameSyncInfo);
    if (paramBoolean)
    {
      if (paramLocalFrameSyncInfo.localEmojiInfos.size() > 0)
      {
        paramLocalFrameSyncInfo = (AVRedPacketManager.LocalEmojiInfo)paramLocalFrameSyncInfo.localEmojiInfos.get(0);
        QLog.d("RedPacketGameEmojiAnimation", 2, "WL_DEBUG updateState isSend = " + paramBoolean + ", localEmojiInfo = " + paramLocalFrameSyncInfo.toString() + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
        if (this.jdField_a_of_type_Int != paramLocalFrameSyncInfo.emojiId)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RedPacketGameEmojiAnimation", 2, "WL_DEBUG updateState,new emoji, isSend = " + paramBoolean + ", localEmojiInfo = " + paramLocalFrameSyncInfo.toString() + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
          }
          this.jdField_a_of_type_Int = paramLocalFrameSyncInfo.emojiId;
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.b(a(paramLocalFrameSyncInfo));
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.b(paramLocalFrameSyncInfo.trackNum);
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[paramLocalFrameSyncInfo.emojiType];
          this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocus.a(paramLocalFrameSyncInfo.isBigEmoji);
          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(paramLocalFrameSyncInfo.emojiId, paramLocalFrameSyncInfo.emojiType);
          }
        }
      }
      if (this.jdField_a_of_type_Int == this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = null;
      }
    }
    while ((paramLocalFrameSyncInfo.localHitInfo.topWordTipType == 3) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    if ((this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null)) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.d(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.a(false);
    AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo;
    int i;
    long l2;
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size())
    {
      localLocalEmojiInfo = (AVRedPacketManager.LocalEmojiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      QLog.d("RedPacketGameEmojiAnimation", 2, "WL_DEBUG updateState isSend = " + paramBoolean + ", localEmojiInfo = " + localLocalEmojiInfo.toString() + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_Long = (paramLocalFrameSyncInfo.localHitInfo.hitStartTime + 500L);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.b(a(localLocalEmojiInfo));
      i = this.jdField_a_of_type_Int % 3;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.b(i);
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = this.jdField_a_of_type_ArrayOfComTencentAvRedpacketUiRedPacketGameSprite[localLocalEmojiInfo.emojiType];
      l2 = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_Long - NetConnInfoCenter.getServerTimeMillis();
      if (l2 >= 0L) {
        break label577;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(localLocalEmojiInfo.emojiId, this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_Long, 1, i, localLocalEmojiInfo.emojiType, localLocalEmojiInfo.isBigEmoji, l1);
      }
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleFocus.a(localLocalEmojiInfo.isBigEmoji);
      return;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameParticleEmoji.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameSprite = null;
      return;
      label577:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameEmojiAnimation
 * JD-Core Version:    0.7.0.1
 */