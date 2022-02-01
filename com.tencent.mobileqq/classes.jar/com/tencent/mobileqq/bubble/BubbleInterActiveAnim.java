package com.tencent.mobileqq.bubble;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.AIOAnimator;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@TargetApi(11)
public class BubbleInterActiveAnim
  extends AIOAnimationConatiner.AIOAnimator
{
  public BubbleManager d;
  public List<View> e = new ArrayList();
  public List<AnimatorSet> f = new ArrayList();
  public ConcurrentHashMap<Long, BubbleInterActiveAnim.AnimHolder> g = new ConcurrentHashMap();
  public int h;
  public int i = 0;
  public int j = 0;
  public ConcurrentHashMap<String, Bitmap> k = new ConcurrentHashMap();
  public Handler l = new BubbleInterActiveAnim.1(this, Looper.getMainLooper());
  
  public BubbleInterActiveAnim(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.h = AIOUtils.b(12.0F, paramListView.getContext().getResources());
    this.i = AIOUtils.b(50.0F, paramListView.getContext().getResources());
    this.j = AIOUtils.b(45.0F, paramListView.getContext().getResources());
  }
  
  private int a(Rect paramRect1, Rect paramRect2, String paramString, int paramInt)
  {
    int m = paramString.charAt(0);
    if (m != 66)
    {
      if (m != 67)
      {
        if (m == 84) {
          paramInt = paramRect1.top;
        }
      }
      else {
        paramInt = (paramRect1.bottom - paramRect1.top) / 2;
      }
    }
    else {
      paramInt = paramRect1.bottom;
    }
    return paramInt + paramRect2.top;
  }
  
  private int a(Rect paramRect1, Rect paramRect2, String paramString, boolean paramBoolean, int paramInt)
  {
    int m = paramString.charAt(1);
    if (paramBoolean)
    {
      if (m != 67)
      {
        if (m != 76)
        {
          if (m != 82) {
            break label169;
          }
          paramInt = paramRect1.right;
        }
        else
        {
          paramInt = paramRect1.left;
        }
      }
      else {
        paramInt = (paramRect1.right - paramRect1.left) / 2;
      }
    }
    else
    {
      int n = paramRect2.left + paramRect2.right;
      if (m != 67)
      {
        if (m != 76)
        {
          if (m != 82) {
            break label169;
          }
          paramInt = paramRect1.left - n;
          m = paramRect2.left;
        }
        else
        {
          paramInt = paramRect1.right - n;
          m = paramRect2.left;
        }
        paramInt -= m;
      }
      else
      {
        paramInt = (paramRect1.right - paramRect1.left) / 2 - n - paramRect2.left;
      }
    }
    label169:
    return paramInt + paramRect2.left;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    String str = a(paramMessageRecord, paramSessionInfo, null);
    BubbleManager localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    BubbleConfig localBubbleConfig = localBubbleManager.a((int)paramMessageRecord.vipBubbleID, false);
    if (a(localBubbleConfig)) {
      return -1L;
    }
    if (!TextUtils.isEmpty(str))
    {
      long l2;
      long l1;
      long l3;
      if (a(paramAIOAnimationConatiner))
      {
        paramQQAppInterface = paramAIOAnimationConatiner.getListView().getAdapter();
        int m = paramAIOAnimationConatiner.getListView().getFirstVisiblePosition();
        int n = paramAIOAnimationConatiner.getListView().getLastVisiblePosition();
        l2 = -1L;
        l1 = l2;
        boolean bool = false;
        while (n >= m)
        {
          Object localObject2 = new BubbleInterActiveAnim.DealChatMessage(paramMessageRecord, paramAIOAnimationConatiner, bool, n, paramQQAppInterface.getItem(n)).e();
          if (!((BubbleInterActiveAnim.DealChatMessage)localObject2).a())
          {
            Object localObject3 = ((BubbleInterActiveAnim.DealChatMessage)localObject2).b();
            Object localObject1 = ((BubbleInterActiveAnim.DealChatMessage)localObject2).c();
            bool = ((BubbleInterActiveAnim.DealChatMessage)localObject2).d().b();
            if (a((BaseBubbleBuilder.ViewHolder)localObject3))
            {
              localObject2 = a((MessageRecord)localObject1);
              localObject3 = localBubbleManager.a((int)((ChatMessage)localObject1).vipBubbleID, false);
              if (!a((ChatMessage)localObject1, (BubbleConfig)localObject3))
              {
                localObject1 = new BubbleInterActiveAnim.GetOtherSeq2(paramMessageRecord, paramSessionInfo, str, localBubbleConfig, l2, l1, (ChatMessage)localObject1, (String)localObject2, (BubbleConfig)localObject3).d();
                if (((BubbleInterActiveAnim.GetOtherSeq2)localObject1).a()) {
                  break;
                }
                l2 = ((BubbleInterActiveAnim.GetOtherSeq2)localObject1).b();
                l1 = ((BubbleInterActiveAnim.GetOtherSeq2)localObject1).c();
              }
            }
          }
          n -= 1;
        }
        l3 = l1;
      }
      else
      {
        l1 = -1L;
        l3 = l1;
        l2 = l1;
      }
      paramQQAppInterface = a(paramAIOAnimationConatiner, l2, l3);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.longValue();
      }
    }
    return -1L;
  }
  
  private static long a(MessageRecord paramMessageRecord, long paramLong1, long paramLong2, ChatMessage paramChatMessage, String paramString)
  {
    if ((paramMessageRecord.atInfoTempList != null) && (paramMessageRecord.atInfoTempList.size() > 0))
    {
      paramMessageRecord = paramMessageRecord.atInfoTempList.iterator();
      paramLong1 = paramLong2;
      for (;;)
      {
        l1 = paramLong1;
        if (!paramMessageRecord.hasNext()) {
          break;
        }
        if (paramString.equals(String.valueOf(((AtTroopMemberInfo)paramMessageRecord.next()).uin))) {
          paramLong1 = paramChatMessage.uniseq;
        }
      }
    }
    long l1 = paramLong1;
    if (paramMessageRecord.atInfoList != null)
    {
      l1 = paramLong1;
      if (paramMessageRecord.atInfoList.size() > 0)
      {
        paramMessageRecord = paramMessageRecord.atInfoList.iterator();
        paramLong1 = paramLong2;
        for (;;)
        {
          l1 = paramLong1;
          if (!paramMessageRecord.hasNext()) {
            break;
          }
          if (paramString.equals(String.valueOf(((AtTroopMemberInfo)paramMessageRecord.next()).uin))) {
            paramLong1 = paramChatMessage.uniseq;
          }
        }
      }
    }
    return l1;
  }
  
  @NotNull
  private AnimatorListenerAdapter a(BubbleInterActiveAnim.AnimHolder paramAnimHolder, ObjectAnimator paramObjectAnimator)
  {
    return new BubbleInterActiveAnim.6(this, paramObjectAnimator, paramAnimHolder);
  }
  
  private Pair<Integer, Integer> a(BubbleInterActiveAnim.AnimHolder paramAnimHolder, BubbleNewAnimConf.InterActiveAnimConf paramInterActiveAnimConf, Pair<Integer, Integer> paramPair)
  {
    if ((!TextUtils.isEmpty(paramInterActiveAnimConf.o)) && (paramInterActiveAnimConf.q != null)) {
      return a(paramAnimHolder.a, paramInterActiveAnimConf.q, paramInterActiveAnimConf.o, paramAnimHolder.c.isSend());
    }
    if (QLog.isColorLevel())
    {
      paramAnimHolder = new StringBuilder();
      paramAnimHolder.append("start align: ");
      paramAnimHolder.append(paramInterActiveAnimConf.o);
      paramAnimHolder.append(", startRect: ");
      paramAnimHolder.append(paramInterActiveAnimConf.q);
      QLog.i("BubbleInterActiveAnim", 2, paramAnimHolder.toString());
    }
    return paramPair;
  }
  
  @Nullable
  private static Long a(AIOAnimationConatiner paramAIOAnimationConatiner, long paramLong1, long paramLong2)
  {
    if ((paramLong2 != -1L) && (a(paramAIOAnimationConatiner, paramLong2))) {
      return Long.valueOf(paramLong2);
    }
    if ((paramLong1 != -1L) && (a(paramAIOAnimationConatiner, paramLong1))) {
      return Long.valueOf(paramLong1);
    }
    return null;
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isSend()) {
      return paramMessageRecord.selfuin;
    }
    if ((paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1020) && (paramMessageRecord.istroop != 1004)) {
      return paramMessageRecord.senderuin;
    }
    return paramMessageRecord.frienduin;
  }
  
  private static String a(MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramSessionInfo.a == 0) || (paramSessionInfo.a == 1) || (paramSessionInfo.a == 3000)) {
      paramString = a(paramMessageRecord);
    }
    return paramString;
  }
  
  private void a(BaseBubbleBuilder.ViewHolder paramViewHolder1, BaseBubbleBuilder.ViewHolder paramViewHolder2, long paramLong1, long paramLong2)
  {
    int m;
    if ((this.d.a(paramViewHolder1.i.a, 8)) && (this.d.a(paramViewHolder2.i.a, 8))) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      localObject1 = new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      Object localObject2 = this.l.obtainMessage(1);
      ((Message)localObject2).obj = localObject1;
      this.l.sendMessage((Message)localObject2);
      localObject2 = this.d.a(paramViewHolder1.i.a, false);
      localObject1 = this.d.a(paramViewHolder2.i.a, false);
      localObject2 = ((BubbleConfig)localObject2).y.values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        a((BubbleNewAnimConf)((Iterator)localObject2).next(), paramViewHolder1.i.a);
      }
      a((BubbleNewAnimConf)((BubbleConfig)localObject1).y.get("passive_animation"), paramViewHolder2.i.a);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("resource is not all ready, originalMsg: ");
    ((StringBuilder)localObject1).append(this.d.a(paramViewHolder1.i.a, 8));
    ((StringBuilder)localObject1).append(", target msg: ");
    ((StringBuilder)localObject1).append(this.d.a(paramViewHolder2.i.a, 8));
    QLog.e("BubbleInterActiveAnim", 1, ((StringBuilder)localObject1).toString());
  }
  
  private static void a(BubbleInterActiveAnim.AnimFrameData paramAnimFrameData, PathPoint paramPathPoint, double paramDouble1, double paramDouble2)
  {
    if ((paramDouble2 != 0.0D) && (paramDouble1 != 0.0D))
    {
      paramPathPoint.c = ((float)Math.toDegrees(Math.asin(paramDouble1 / paramDouble2)));
      if (!paramAnimFrameData.d) {
        paramPathPoint.c = (-paramPathPoint.c);
      }
    }
    if (Math.abs(paramPathPoint.c) > 90.0F)
    {
      if (QLog.isColorLevel())
      {
        paramAnimFrameData = new StringBuilder();
        paramAnimFrameData.append("too large rotate ");
        paramAnimFrameData.append(paramPathPoint.c);
        paramAnimFrameData.append(", reset to 0!");
        QLog.i("BubbleInterActiveAnim", 2, paramAnimFrameData.toString());
      }
      paramPathPoint.c = 0.0F;
    }
  }
  
  private void a(BubbleInterActiveAnim.AnimHolder paramAnimHolder, Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != null) && ((paramObject1 instanceof BaseBubbleBuilder.ViewHolder)))
    {
      paramObject1 = (BaseBubbleBuilder.ViewHolder)paramObject1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh seq ");
        localStringBuilder.append(paramAnimHolder.g);
        localStringBuilder.append(" 's bubbleView");
        QLog.i("BubbleInterActiveAnim", 2, localStringBuilder.toString());
      }
      paramAnimHolder.f = paramObject1.h;
      paramAnimHolder.c = paramObject1.q;
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramObject1 = new StringBuilder();
        paramObject1.append("stop current bubble animation! ");
        paramObject1.append(paramAnimHolder.g);
        QLog.w("BubbleInterActiveAnim", 2, paramObject1.toString());
      }
      paramAnimHolder.j.cancel();
    }
    if ((paramObject2 != null) && ((paramObject2 instanceof BaseBubbleBuilder.ViewHolder)))
    {
      paramObject1 = (BaseBubbleBuilder.ViewHolder)paramObject2;
      if (QLog.isColorLevel())
      {
        paramObject2 = new StringBuilder();
        paramObject2.append("refresh seq ");
        paramObject2.append(paramAnimHolder.h);
        paramObject2.append(" 's bubbleView");
        QLog.i("BubbleInterActiveAnim", 2, paramObject2.toString());
      }
      paramAnimHolder.d = paramObject1.q;
      return;
    }
    if (QLog.isColorLevel())
    {
      paramObject1 = new StringBuilder();
      paramObject1.append("stop current bubble animation! ");
      paramObject1.append(paramAnimHolder.h);
      QLog.i("BubbleInterActiveAnim", 2, paramObject1.toString());
    }
    paramAnimHolder.j.cancel();
  }
  
  private boolean a(long paramLong)
  {
    if ((this.b != null) && (this.b.getAdapter() != null) && (paramLong > 0L))
    {
      Object localObject2 = null;
      ListAdapter localListAdapter = this.b.getAdapter();
      int m = localListAdapter.getCount() - 1;
      Object localObject1;
      for (;;)
      {
        localObject1 = localObject2;
        if (m < 0) {
          break;
        }
        localObject1 = localListAdapter.getItem(m);
        if ((localObject1 instanceof ChatMessage))
        {
          localObject1 = (ChatMessage)localObject1;
          if (((ChatMessage)localObject1).uniseq == paramLong) {
            break;
          }
        }
        m -= 1;
      }
      if (a((ChatMessage)localObject1)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(long paramLong, ListAdapter paramListAdapter, int paramInt1, int paramInt2)
  {
    while (paramInt2 >= paramInt1)
    {
      Object localObject = paramListAdapter.getItem(paramInt2);
      if (((localObject instanceof MessageRecord)) && (((MessageRecord)localObject).uniseq == paramLong)) {
        return true;
      }
      paramInt2 -= 1;
    }
    return false;
  }
  
  private static boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return (paramViewHolder != null) && (paramViewHolder.i != null);
  }
  
  private boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder1, BaseBubbleBuilder.ViewHolder paramViewHolder2)
  {
    return (paramViewHolder1 == null) || (paramViewHolder2 == null) || (paramViewHolder1.i == null) || (paramViewHolder2.i == null);
  }
  
  private static boolean a(AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    return (paramAIOAnimationConatiner.getListView() != null) && (paramAIOAnimationConatiner.getListView().getAdapter() != null);
  }
  
  public static boolean a(AIOAnimationConatiner paramAIOAnimationConatiner, long paramLong)
  {
    ListAdapter localListAdapter = paramAIOAnimationConatiner.getListView().getAdapter();
    int n;
    int m;
    if (paramAIOAnimationConatiner.getListView().getChildCount() > 0)
    {
      if ((localListAdapter instanceof HeaderViewListAdapter))
      {
        n = paramAIOAnimationConatiner.getListView().getFirstVisiblePosition();
        m = paramAIOAnimationConatiner.getListView().getLastVisiblePosition();
      }
      else if ((localListAdapter instanceof ChatAdapter1))
      {
        n = paramAIOAnimationConatiner.getListView().getFirstVisiblePosition() - paramAIOAnimationConatiner.getListView().getHeaderViewsCount();
        m = paramAIOAnimationConatiner.getListView().getLastVisiblePosition() - paramAIOAnimationConatiner.getListView().getFooterViewsCount();
      }
      else
      {
        m = 0;
        n = 0;
      }
      if ((n < 0) || (n >= localListAdapter.getCount())) {
        n = 0;
      }
      if ((m < 0) || (m >= localListAdapter.getCount())) {
        m = 0;
      }
    }
    else
    {
      m = 0;
      n = 0;
    }
    return a(paramLong, localListAdapter, n, m);
  }
  
  private static boolean a(BubbleConfig paramBubbleConfig)
  {
    if ((paramBubbleConfig != null) && (paramBubbleConfig.y != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("bubble config mInterActivePackageID: ");
        localStringBuilder.append(paramBubbleConfig.v);
        localStringBuilder.append(", bubble mInterActiveType: ");
        localStringBuilder.append(paramBubbleConfig.w);
        QLog.i("BubbleInterActiveAnim", 2, localStringBuilder.toString());
      }
      return false;
    }
    return true;
  }
  
  private static boolean a(BubbleConfig paramBubbleConfig1, BubbleConfig paramBubbleConfig2, boolean paramBoolean)
  {
    if (paramBubbleConfig1.w == 3)
    {
      if (((paramBubbleConfig2.w != 2) || (paramBubbleConfig2.v == paramBubbleConfig1.v)) && (paramBubbleConfig2.w != 3)) {}
    }
    else {
      for (;;)
      {
        return true;
        if (paramBubbleConfig1.w == 1)
        {
          if ((paramBubbleConfig1.v == paramBubbleConfig2.v) && (paramBubbleConfig1.w == paramBubbleConfig2.w)) {}
        }
        else {
          do
          {
            return false;
            if ((paramBubbleConfig1.w != 2) || ((paramBubbleConfig2.w != 2) && (paramBubbleConfig2.w != 3))) {
              break;
            }
          } while (paramBubbleConfig2.v == paramBubbleConfig1.v);
        }
      }
    }
    return paramBoolean;
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      paramChatMessage = EmojiStickerManager.a().c(paramChatMessage);
      if ((paramChatMessage != null) && (!paramChatMessage.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, " contain sticker ,so stop bubble animation!");
        }
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(ChatMessage paramChatMessage, BubbleConfig paramBubbleConfig)
  {
    if ((paramBubbleConfig != null) && (paramBubbleConfig.y != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("record seq: ");
        localStringBuilder.append(paramChatMessage.uniseq);
        localStringBuilder.append(", other bubble config mInterActivePackageID: ");
        localStringBuilder.append(paramBubbleConfig.v);
        localStringBuilder.append(", other bubble config mInterActiveType: ");
        localStringBuilder.append(paramBubbleConfig.w);
        QLog.i("BubbleInterActiveAnim", 2, localStringBuilder.toString());
      }
      return false;
    }
    paramBubbleConfig = new StringBuilder();
    paramBubbleConfig.append("get bubbleConfig is null: ");
    paramBubbleConfig.append((int)paramChatMessage.vipBubbleID);
    QLog.e("BubbleInterActiveAnim", 1, paramBubbleConfig.toString());
    return true;
  }
  
  private static long b(MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, long paramLong1, long paramLong2, ChatMessage paramChatMessage, String paramString)
  {
    if (paramSessionInfo.a == 0) {
      return paramLong1;
    }
    return a(paramMessageRecord, paramLong1, paramLong2, paramChatMessage, paramString);
  }
  
  private static BubbleInterActiveAnim.AnimFrameData b(float paramFloat1, BubbleInterActiveAnim.AnimFrameData paramAnimFrameData1, BubbleInterActiveAnim.AnimFrameData paramAnimFrameData2, long paramLong, float paramFloat2, float paramFloat3, PathPoint paramPathPoint, BubbleInterActiveAnim.AnimFrameData paramAnimFrameData3)
  {
    if (paramAnimFrameData1.e)
    {
      double d1 = paramFloat1;
      int m;
      if (d1 >= 1.0D)
      {
        m = 100;
      }
      else
      {
        Double.isNaN(d1);
        m = (int)((d1 + 0.005D) * 100.0D);
      }
      paramAnimFrameData3.i = m;
      if ((paramAnimFrameData3.i - paramAnimFrameData2.i >= 5) || (paramAnimFrameData2.i == 0))
      {
        if ((paramAnimFrameData2.j == 0) || (paramAnimFrameData2.k == 0))
        {
          paramAnimFrameData2.j = ((int)paramAnimFrameData1.g.a);
          paramAnimFrameData2.k = ((int)paramAnimFrameData1.g.b);
        }
        d1 = Math.abs(paramFloat3 - paramAnimFrameData2.k);
        double d2 = Math.abs(paramFloat2 - paramAnimFrameData2.j);
        d2 = Math.sqrt(Math.pow(d1, 2.0D) + Math.pow(d2, 2.0D));
        a(paramAnimFrameData2, paramPathPoint, d1, d2);
        if (QLog.isColorLevel())
        {
          paramAnimFrameData1 = new StringBuilder();
          paramAnimFrameData1.append("rotate: ");
          paramAnimFrameData1.append(paramPathPoint.c);
          paramAnimFrameData1.append(" yDistance: ");
          paramAnimFrameData1.append(d1);
          paramAnimFrameData1.append(", distance: ");
          paramAnimFrameData1.append(d2);
          paramAnimFrameData1.append(", t: ");
          paramAnimFrameData1.append(paramFloat1);
          QLog.i("BubbleInterActiveAnim", 2, paramAnimFrameData1.toString());
          paramAnimFrameData1 = new StringBuilder();
          paramAnimFrameData1.append("evaluate_path_and_rotate, cost=");
          paramAnimFrameData1.append(System.currentTimeMillis() - paramLong);
          QLog.i("BubbleInterActiveAnim", 2, paramAnimFrameData1.toString());
        }
        paramAnimFrameData2.i = paramAnimFrameData3.i;
      }
      if (paramFloat1 == 1.0F) {
        paramPathPoint.c = 360.0F;
      }
    }
    paramAnimFrameData2.j = ((int)paramFloat2);
    paramAnimFrameData2.k = ((int)paramFloat3);
    return paramAnimFrameData3;
  }
  
  private static boolean b(SessionInfo paramSessionInfo, BubbleConfig paramBubbleConfig1, BubbleConfig paramBubbleConfig2)
  {
    int m = paramSessionInfo.a;
    boolean bool2 = false;
    if (m == 0) {
      return true;
    }
    boolean bool1 = bool2;
    if (paramBubbleConfig1.v != -1)
    {
      bool1 = bool2;
      if (paramBubbleConfig2.v != -1) {
        bool1 = a(paramBubbleConfig1, paramBubbleConfig2, false);
      }
    }
    return bool1;
  }
  
  @NotNull
  private Animator.AnimatorListener e(BubbleInterActiveAnim.AnimHolder paramAnimHolder)
  {
    return new BubbleInterActiveAnim.5(this, paramAnimHolder);
  }
  
  public ObjectAnimator a(BubbleInterActiveAnim.AnimHolder paramAnimHolder, Rect paramRect, BubbleNewAnimConf.InterActiveAnimConf paramInterActiveAnimConf)
  {
    File localFile = null;
    if (paramInterActiveAnimConf == null) {
      return null;
    }
    Object localObject1 = localFile;
    if (paramRect != null)
    {
      localObject1 = localFile;
      if (paramInterActiveAnimConf.m == -1)
      {
        if (paramRect == paramAnimHolder.a) {
          localObject1 = paramAnimHolder.c;
        } else {
          localObject1 = paramAnimHolder.d;
        }
        boolean bool = ((MessageRecord)localObject1).isSend();
        paramRect = a(paramRect, paramInterActiveAnimConf.i, paramInterActiveAnimConf.h, bool);
        localObject1 = new PathPoint(-1, ((Integer)paramRect.first).intValue(), ((Integer)paramRect.second).intValue());
      }
    }
    localFile = new File(this.d.d(paramInterActiveAnimConf.l, false), paramInterActiveAnimConf.k);
    paramRect = new ArrayList();
    int m = 0;
    while (m < paramInterActiveAnimConf.d)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
      ((StringBuilder)localObject2).append(File.separatorChar);
      ((StringBuilder)localObject2).append(paramInterActiveAnimConf.e);
      m += 1;
      ((StringBuilder)localObject2).append(String.format("%04d.png", new Object[] { Integer.valueOf(m) }));
      localObject2 = ((StringBuilder)localObject2).toString();
      BubbleInterActiveAnim.AnimFrameData localAnimFrameData = new BubbleInterActiveAnim.AnimFrameData();
      localAnimFrameData.b = ((String)localObject2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInterActiveAnimConf.a);
      localStringBuilder.append((String)localObject2);
      localAnimFrameData.a = localStringBuilder.toString();
      localAnimFrameData.l = paramAnimHolder;
      localAnimFrameData.h = paramInterActiveAnimConf.i;
      if (paramInterActiveAnimConf.f) {
        localAnimFrameData.c = Boolean.valueOf(paramAnimHolder.c.isSend() ^ true);
      }
      localAnimFrameData.d = paramAnimHolder.c.isSend();
      if (paramInterActiveAnimConf.m == -1) {
        localAnimFrameData.g = ((PathPoint)localObject1);
      }
      paramRect.add(localAnimFrameData);
    }
    paramAnimHolder = new Keyframe[paramRect.size() + 1];
    float f1 = 1.0F / paramRect.size();
    paramAnimHolder[0] = Keyframe.ofObject(0.0F, paramRect.get(0));
    m = 0;
    while (m < paramRect.size())
    {
      if (m != paramRect.size() - 1)
      {
        int n = m + 1;
        paramAnimHolder[n] = Keyframe.ofObject(n * f1, paramRect.get(m));
      }
      else
      {
        paramAnimHolder[(m + 1)] = Keyframe.ofObject(1.0F, paramRect.get(m));
      }
      m += 1;
    }
    paramAnimHolder = PropertyValuesHolder.ofKeyframe("bitmapData", paramAnimHolder);
    paramAnimHolder.setEvaluator(new BubbleInterActiveAnim.BimapEvaluator(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { paramAnimHolder }).setDuration(paramRect.size() * paramInterActiveAnimConf.b);
  }
  
  public ObjectAnimator a(BubbleInterActiveAnim.AnimHolder paramAnimHolder, BubbleNewAnimConf.InterActiveAnimConf paramInterActiveAnimConf)
  {
    Object localObject2 = a(paramAnimHolder, paramInterActiveAnimConf, null);
    Object localObject1;
    if ((!TextUtils.isEmpty(paramInterActiveAnimConf.p)) && (paramInterActiveAnimConf.r != null))
    {
      localObject1 = a(paramAnimHolder.b, paramInterActiveAnimConf.r, paramInterActiveAnimConf.p, paramAnimHolder.d.isSend());
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("end align ");
        ((StringBuilder)localObject1).append(paramInterActiveAnimConf.p);
        ((StringBuilder)localObject1).append(", endRect: ");
        ((StringBuilder)localObject1).append(paramInterActiveAnimConf.r);
        QLog.i("BubbleInterActiveAnim", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = null;
    }
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        return null;
      }
      int n = ((Integer)((Pair)localObject2).first).intValue();
      int i1 = ((Integer)((Pair)localObject2).second).intValue();
      int i2 = ((Integer)((Pair)localObject1).first).intValue();
      int i3 = ((Integer)((Pair)localObject1).second).intValue();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(PathPoint.b(n, i1));
      ((ArrayList)localObject1).add(PathPoint.a(i2, i3));
      localObject2 = new BubbleInterActiveAnim.PathEvaluator();
      BubbleInterActiveAnim.AnimFrameData[] arrayOfAnimFrameData = new BubbleInterActiveAnim.AnimFrameData[((ArrayList)localObject1).size()];
      int m = 0;
      while (m < arrayOfAnimFrameData.length)
      {
        BubbleInterActiveAnim.AnimFrameData localAnimFrameData = new BubbleInterActiveAnim.AnimFrameData();
        localAnimFrameData.l = paramAnimHolder;
        localAnimFrameData.g = ((PathPoint)((ArrayList)localObject1).get(m));
        if (paramInterActiveAnimConf.f) {
          localAnimFrameData.c = Boolean.valueOf(paramAnimHolder.c.isSend() ^ true);
        }
        localAnimFrameData.d = paramAnimHolder.c.isSend();
        localAnimFrameData.e = paramInterActiveAnimConf.n;
        localAnimFrameData.h = paramInterActiveAnimConf.i;
        arrayOfAnimFrameData[m] = localAnimFrameData;
        m += 1;
      }
      paramAnimHolder = ObjectAnimator.ofObject(this, "pathLocation", (TypeEvaluator)localObject2, arrayOfAnimFrameData);
      float f1 = (Math.abs(n - i2) + Math.abs(i1 - i3)) * 1.0F / this.i;
      paramAnimHolder.setDuration(((float)paramInterActiveAnimConf.b * f1));
      return paramAnimHolder;
    }
    return null;
  }
  
  public Rect a(BaseBubbleBuilder.ViewHolder paramViewHolder, long paramLong, ListView paramListView)
  {
    int m = paramViewHolder.i.a;
    paramListView = this.d.a(m, false);
    if (paramListView == null) {
      return null;
    }
    if ((BubbleNewAnimConf)paramListView.y.get("animation_start") == null)
    {
      paramListView = paramListView.y.values().iterator();
      while ((paramListView.hasNext()) && ((BubbleNewAnimConf)paramListView.next() == null)) {}
    }
    paramListView = paramViewHolder.h;
    int n = paramListView.getLeft();
    m = paramListView.getTop();
    paramViewHolder = (View)paramListView.getParent();
    while ((paramViewHolder != null) && (!(paramViewHolder instanceof BaseChatItemLayout)))
    {
      n += paramViewHolder.getLeft();
      m += paramViewHolder.getTop();
      paramViewHolder = paramViewHolder.getParent();
      if ((paramViewHolder instanceof View)) {
        paramViewHolder = (View)paramViewHolder;
      } else {
        paramViewHolder = null;
      }
    }
    paramViewHolder = new Rect();
    paramViewHolder.left = (BaseChatItemLayout.getBubblePaddingAlignHead() + n);
    paramViewHolder.right = (n + (paramListView.getRight() - paramListView.getLeft()) - BaseChatItemLayout.getBubblePaddingAlignHead());
    paramViewHolder.top = (BaseChatItemLayout.k + m);
    paramViewHolder.bottom = (m + (paramListView.getBottom() - paramListView.getTop()) - BaseChatItemLayout.l);
    return paramViewHolder;
  }
  
  public Pair<Integer, Integer> a(Rect paramRect1, Rect paramRect2, String paramString, boolean paramBoolean)
  {
    int m = a(paramRect1, paramRect2, paramString, 0);
    return new Pair(Integer.valueOf(a(paramRect1, paramRect2, paramString, paramBoolean, 0)), Integer.valueOf(m));
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext())
    {
      BubbleInterActiveAnim.AnimHolder localAnimHolder = (BubbleInterActiveAnim.AnimHolder)localIterator.next();
      if ((localAnimHolder != null) && (localAnimHolder.e != null))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("add delta ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" for seq: ");
          localStringBuilder.append(localAnimHolder.g);
          QLog.i("BubbleInterActiveAnim", 2, localStringBuilder.toString());
        }
        localAnimHolder.e.setTranslationY(localAnimHolder.e.getTranslationY() + paramInt);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ThreadManager.post(new BubbleInterActiveAnim.2(this, paramLong1, paramLong2), 5, null, true);
  }
  
  public void a(BubbleInterActiveAnim.AnimHolder paramAnimHolder)
  {
    paramAnimHolder.e.setVisibility(8);
    this.a.removeView(paramAnimHolder.e);
    this.g.remove(Long.valueOf(paramAnimHolder.g));
    if (this.g.size() == 0) {
      d();
    }
  }
  
  public void a(BubbleNewAnimConf paramBubbleNewAnimConf, int paramInt)
  {
    File localFile = new File(this.d.d(paramInt, false), paramBubbleNewAnimConf.k);
    paramInt = 0;
    while (paramInt < paramBubbleNewAnimConf.d)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localFile.getAbsolutePath());
      ((StringBuilder)localObject1).append(File.separatorChar);
      ((StringBuilder)localObject1).append(paramBubbleNewAnimConf.e);
      int m = paramInt + 1;
      ((StringBuilder)localObject1).append(String.format("%04d.png", new Object[] { Integer.valueOf(m) }));
      Object localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramBubbleNewAnimConf.a);
      ((StringBuilder)localObject1).append((String)localObject2);
      String str = ((StringBuilder)localObject1).toString();
      if (!this.k.containsKey(str))
      {
        Object localObject3 = GlobalImageCache.a.get(str);
        localObject1 = null;
        if ((localObject3 != null) && ((localObject3 instanceof Bitmap))) {
          localObject1 = (Bitmap)localObject3;
        } else {
          try
          {
            localObject2 = BubbleManager.a((String)localObject2, null);
            localObject1 = localObject2;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            QLog.e("BubbleNewAIOAnim", 1, "decode error!", localOutOfMemoryError);
          }
          catch (Exception localException)
          {
            QLog.e("BubbleNewAIOAnim", 1, "decode error!", localException);
          }
        }
      }
      else
      {
        localObject1 = (Bitmap)this.k.get(str);
      }
      paramInt = m;
      if (localObject1 != null)
      {
        GlobalImageCache.a.put(str, localObject1);
        this.k.put(str, localObject1);
        paramInt = m;
      }
    }
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext())
    {
      BubbleInterActiveAnim.AnimHolder localAnimHolder = (BubbleInterActiveAnim.AnimHolder)localIterator.next();
      if ((localAnimHolder != null) && (localAnimHolder.f != null))
      {
        paramInt1 = AIOUtils.a(localAnimHolder.g, this.b.getAdapter());
        paramInt2 = AIOUtils.a(localAnimHolder.h, this.b.getAdapter());
        a(localAnimHolder, AIOUtils.b(AIOUtils.a(this.b, paramInt1)), AIOUtils.b(AIOUtils.a(this.b, paramInt2)));
      }
    }
    return false;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if ((paramVarArgs[0] instanceof Integer))
    {
      if (((Integer)paramVarArgs[0]).intValue() != 8) {
        return false;
      }
      long l1 = ((Long)paramVarArgs[1]).longValue();
      if (a(l1)) {
        return false;
      }
      long l2 = ((Long)paramVarArgs[2]).longValue();
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("start InterActive Anim, originalSeq：");
        paramVarArgs.append(l1);
        paramVarArgs.append(", targetSeq: ");
        paramVarArgs.append(l2);
        QLog.d("BubbleInterActiveAnim", 1, paramVarArgs.toString());
      }
      if (this.d == null)
      {
        paramVarArgs = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramVarArgs instanceof QQAppInterface)) {
          paramVarArgs = (QQAppInterface)paramVarArgs;
        } else {
          paramVarArgs = null;
        }
        if (paramVarArgs == null) {
          return false;
        }
        this.d = ((BubbleManager)paramVarArgs.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER));
      }
      a(l1, l2);
      return true;
    }
    return false;
  }
  
  public ObjectAnimator b(BubbleInterActiveAnim.AnimHolder paramAnimHolder)
  {
    Object localObject1 = (BubbleNewAnimConf.InterActiveAnimConf)paramAnimHolder.i.get("animation_start");
    ObjectAnimator localObjectAnimator = a(paramAnimHolder, paramAnimHolder.a, (BubbleNewAnimConf.InterActiveAnimConf)localObject1);
    localObjectAnimator.setRepeatCount(((BubbleNewAnimConf.InterActiveAnimConf)localObject1).c - 1);
    if (((BubbleNewAnimConf.InterActiveAnimConf)paramAnimHolder.i.get("animation_running")).n)
    {
      Object localObject3 = (BubbleNewAnimConf.InterActiveAnimConf)paramAnimHolder.i.get("animation_end");
      Object localObject2 = a(paramAnimHolder.a, ((BubbleNewAnimConf.InterActiveAnimConf)localObject1).i, ((BubbleNewAnimConf.InterActiveAnimConf)localObject1).h, paramAnimHolder.c.isSend());
      localObject3 = a(paramAnimHolder.b, ((BubbleNewAnimConf.InterActiveAnimConf)localObject3).i, ((BubbleNewAnimConf.InterActiveAnimConf)localObject3).h, paramAnimHolder.d.isSend());
      int m = ((Integer)((Pair)localObject2).first).intValue();
      int n = ((Integer)((Pair)localObject2).second).intValue();
      int i1 = ((Integer)((Pair)localObject3).first).intValue();
      double d1 = Math.abs(((Integer)((Pair)localObject3).second).intValue() - n);
      double d2 = Math.abs(i1 - m);
      d2 = Math.sqrt(Math.pow(d1, 2.0D) + Math.pow(d2, 2.0D));
      float f1;
      if ((d2 != 0.0D) && (d1 != 0.0D))
      {
        Double.isNaN(d1);
        float f2 = (float)Math.toDegrees(Math.asin(d1 / d2));
        f1 = f2;
        if (!paramAnimHolder.c.isSend()) {
          f1 = -f2;
        }
      }
      else
      {
        f1 = 0.0F;
      }
      localObject2 = ObjectAnimator.ofFloat(paramAnimHolder.e, "rotation", new float[] { 0.0F, f1 });
      m = ((BubbleNewAnimConf.InterActiveAnimConf)localObject1).c - 1;
      long l1;
      if (m > 0) {
        l1 = m * localObjectAnimator.getDuration();
      } else {
        l1 = localObjectAnimator.getDuration();
      }
      ((ObjectAnimator)localObject2).setDuration(l1);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start animation, rotate view: ");
        ((StringBuilder)localObject1).append(f1);
        ((StringBuilder)localObject1).append(", duration: ");
        ((StringBuilder)localObject1).append(l1);
        QLog.i("BubbleInterActiveAnim", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    localObjectAnimator.addListener(a(paramAnimHolder, (ObjectAnimator)localObject1));
    return localObjectAnimator;
  }
  
  public ObjectAnimator b(BubbleInterActiveAnim.AnimHolder paramAnimHolder, BubbleNewAnimConf.InterActiveAnimConf paramInterActiveAnimConf)
  {
    Object localObject2 = a(paramAnimHolder, paramInterActiveAnimConf, null);
    Object localObject1;
    if ((!TextUtils.isEmpty(paramInterActiveAnimConf.p)) && (paramInterActiveAnimConf.r != null))
    {
      localObject1 = a(paramAnimHolder.b, paramInterActiveAnimConf.r, paramInterActiveAnimConf.p, paramAnimHolder.d.isSend());
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("end align ");
        ((StringBuilder)localObject1).append(paramInterActiveAnimConf.p);
        ((StringBuilder)localObject1).append(", endRect: ");
        ((StringBuilder)localObject1).append(paramInterActiveAnimConf.r);
        QLog.i("BubbleInterActiveAnim", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = null;
    }
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        return null;
      }
      int n = ((Integer)((Pair)localObject2).first).intValue();
      int i1 = ((Integer)((Pair)localObject2).second).intValue();
      int i2 = ((Integer)((Pair)localObject1).first).intValue();
      int i3 = ((Integer)((Pair)localObject1).second).intValue();
      float f3;
      float f2;
      float f5;
      float f4;
      if (paramInterActiveAnimConf.m == 1)
      {
        f1 = i2 - n;
        f3 = n;
        f2 = i3 - i1;
        f5 = i1;
        f4 = f2 * 1.0F + f5;
        f2 = 0.1F * f2 + f5;
        f1 = f1 * 0.25F + f3;
        f3 = f1;
      }
      else if (paramInterActiveAnimConf.m == 2)
      {
        f1 = i2 - n;
        f5 = n;
        f2 = i3 - i1;
        f4 = i1;
        f3 = f1 * 1.0F + f5;
        f2 = f2 * 0.25F + f4;
        f4 = f2;
        f1 = 0.1F * f1 + f5;
      }
      else
      {
        f1 = 0.0F;
        f2 = 0.0F;
        f3 = 0.0F;
        f4 = 0.0F;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(PathPoint.b(n, i1));
      ((ArrayList)localObject1).add(PathPoint.a(f1, f2, f3, f4, i2, i3));
      localObject2 = new BubbleInterActiveAnim.AnimFrameData[((ArrayList)localObject1).size()];
      int m = 0;
      while (m < localObject2.length)
      {
        BubbleInterActiveAnim.AnimFrameData localAnimFrameData = new BubbleInterActiveAnim.AnimFrameData();
        localAnimFrameData.l = paramAnimHolder;
        localAnimFrameData.g = ((PathPoint)((ArrayList)localObject1).get(m));
        if (paramInterActiveAnimConf.f) {
          localAnimFrameData.c = Boolean.valueOf(paramAnimHolder.c.isSend() ^ true);
        }
        localAnimFrameData.d = paramAnimHolder.c.isSend();
        localAnimFrameData.h = paramInterActiveAnimConf.i;
        localAnimFrameData.e = paramInterActiveAnimConf.n;
        localObject2[m] = localAnimFrameData;
        m += 1;
      }
      paramAnimHolder = ObjectAnimator.ofObject(this, "pathLocation", new BubbleInterActiveAnim.PathEvaluator(), (Object[])localObject2);
      float f1 = (Math.abs(n - i2) + Math.abs(i1 - i3)) * 1.0F / this.i;
      double d1 = (float)paramInterActiveAnimConf.b * f1;
      Double.isNaN(d1);
      paramAnimHolder.setDuration((d1 * 3.141592653589793D * 0.6000000238418579D));
      return paramAnimHolder;
    }
    return null;
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    BubbleInterActiveAnim.AnimHolder localAnimHolder = c(paramLong1, paramLong2);
    if (localAnimHolder != null)
    {
      Object localObject1 = b(localAnimHolder);
      if (localObject1 == null)
      {
        QLog.e("BubbleInterActiveAnim", 1, "startAnimator is null");
        return;
      }
      ObjectAnimator localObjectAnimator1 = c(localAnimHolder);
      if (localObjectAnimator1 == null)
      {
        QLog.e("BubbleInterActiveAnim", 1, "runningAnimator is null");
        return;
      }
      Object localObject2 = (BubbleNewAnimConf.InterActiveAnimConf)localAnimHolder.i.get("animation_end");
      ObjectAnimator localObjectAnimator2 = a(localAnimHolder, localAnimHolder.b, (BubbleNewAnimConf.InterActiveAnimConf)localObject2);
      if (localObjectAnimator2 == null)
      {
        QLog.e("BubbleInterActiveAnim", 1, "endAnimator is null");
        return;
      }
      localObjectAnimator2.setRepeatCount(((BubbleNewAnimConf.InterActiveAnimConf)localObject2).c - 1);
      localObject2 = d(localAnimHolder);
      if (localObject2 == null)
      {
        QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
        return;
      }
      localAnimHolder.j.playSequentially(new Animator[] { localObject1, localObjectAnimator1, localObjectAnimator2, localObject2 });
      localAnimHolder.j.addListener(new BubbleInterActiveAnim.3(this, localAnimHolder));
      localObject1 = e(localAnimHolder);
      localAnimHolder.j.addListener((Animator.AnimatorListener)localObject1);
      this.l.post(new BubbleInterActiveAnim.4(this, localAnimHolder));
      this.g.put(Long.valueOf(paramLong1), localAnimHolder);
    }
  }
  
  protected boolean b(int paramInt)
  {
    return true;
  }
  
  public ObjectAnimator c(BubbleInterActiveAnim.AnimHolder paramAnimHolder)
  {
    Object localObject1 = (BubbleNewAnimConf)paramAnimHolder.i.get("animation_running");
    if (!(localObject1 instanceof BubbleNewAnimConf.InterActiveAnimConf)) {
      return null;
    }
    Object localObject2 = (BubbleNewAnimConf.InterActiveAnimConf)localObject1;
    if (((BubbleNewAnimConf.InterActiveAnimConf)localObject2).m == -1) {
      return null;
    }
    if (((BubbleNewAnimConf.InterActiveAnimConf)localObject2).m == 0) {
      localObject1 = a(paramAnimHolder, (BubbleNewAnimConf.InterActiveAnimConf)localObject2);
    } else {
      localObject1 = b(paramAnimHolder, (BubbleNewAnimConf.InterActiveAnimConf)localObject2);
    }
    localObject2 = a(paramAnimHolder, paramAnimHolder.a, (BubbleNewAnimConf.InterActiveAnimConf)localObject2);
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        return null;
      }
      ((ObjectAnimator)localObject2).setDuration(((ObjectAnimator)localObject2).getDuration() / 2L);
      ((ObjectAnimator)localObject2).setRepeatCount(-1);
      ((ObjectAnimator)localObject1).addListener(new BubbleInterActiveAnim.7(this, paramAnimHolder, (ObjectAnimator)localObject2));
      return localObject1;
    }
    return null;
  }
  
  public BubbleInterActiveAnim.AnimHolder c(long paramLong1, long paramLong2)
  {
    Object localObject1 = AIOUtils.b(AIOUtils.a(this.b, AIOUtils.a(paramLong1, this.b.getAdapter())));
    boolean bool = localObject1 instanceof BaseBubbleBuilder.ViewHolder;
    BubbleNewAnimConf localBubbleNewAnimConf = null;
    if (bool) {
      localObject1 = (BaseBubbleBuilder.ViewHolder)localObject1;
    } else {
      localObject1 = null;
    }
    Object localObject2 = AIOUtils.b(AIOUtils.a(this.b, AIOUtils.a(paramLong2, this.b.getAdapter())));
    if ((localObject2 instanceof BaseBubbleBuilder.ViewHolder)) {
      localObject2 = (BaseBubbleBuilder.ViewHolder)localObject2;
    } else {
      localObject2 = null;
    }
    if (a((BaseBubbleBuilder.ViewHolder)localObject1, (BaseBubbleBuilder.ViewHolder)localObject2)) {
      return null;
    }
    int m = ((BaseBubbleBuilder.ViewHolder)localObject1).i.a;
    int n = ((BaseBubbleBuilder.ViewHolder)localObject2).i.a;
    BubbleConfig localBubbleConfig = this.d.a(m, false);
    Object localObject4 = this.d.a(n, false);
    Object localObject3 = localBubbleNewAnimConf;
    if (localBubbleConfig != null)
    {
      localObject3 = localBubbleNewAnimConf;
      if (localObject4 != null)
      {
        localObject3 = localBubbleNewAnimConf;
        if (localBubbleConfig.y != null)
        {
          if (((BubbleConfig)localObject4).y == null) {
            return null;
          }
          localBubbleNewAnimConf = (BubbleNewAnimConf)localBubbleConfig.y.get("animation_start");
          localObject4 = (BubbleNewAnimConf)((BubbleConfig)localObject4).y.get("passive_animation");
          if (localBubbleNewAnimConf == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("can't find mInterActiveAnims from bubbleId: ");
            ((StringBuilder)localObject1).append(m);
            QLog.e("BubbleInterActiveAnim", 1, ((StringBuilder)localObject1).toString());
            return null;
          }
          localObject3 = new BubbleInterActiveAnim.AnimHolder();
          ((BubbleInterActiveAnim.AnimHolder)localObject3).c = ((BaseBubbleBuilder.ViewHolder)localObject1).q;
          ((BubbleInterActiveAnim.AnimHolder)localObject3).d = ((BaseBubbleBuilder.ViewHolder)localObject2).q;
          ((BubbleInterActiveAnim.AnimHolder)localObject3).i = new HashMap(localBubbleConfig.y);
          ((BubbleInterActiveAnim.AnimHolder)localObject3).i.put("passive_animation", localObject4);
          ((BubbleInterActiveAnim.AnimHolder)localObject3).e = new ImageView(this.b.getContext());
          ((BubbleInterActiveAnim.AnimHolder)localObject3).e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          ((BubbleInterActiveAnim.AnimHolder)localObject3).e.layout(0, 0, localBubbleNewAnimConf.i.right, localBubbleNewAnimConf.i.bottom);
          ((BubbleInterActiveAnim.AnimHolder)localObject3).e.setVisibility(4);
          ((BubbleInterActiveAnim.AnimHolder)localObject3).a = a((BaseBubbleBuilder.ViewHolder)localObject1, paramLong1, this.b);
          ((BubbleInterActiveAnim.AnimHolder)localObject3).b = a((BaseBubbleBuilder.ViewHolder)localObject2, paramLong2, this.b);
          localObject2 = (View)((BaseBubbleBuilder.ViewHolder)localObject2).h.getParent();
          m = ((View)((BaseBubbleBuilder.ViewHolder)localObject1).h.getParent()).getTop() - ((View)localObject2).getTop();
          localObject2 = ((BubbleInterActiveAnim.AnimHolder)localObject3).b;
          ((Rect)localObject2).top -= m;
          localObject2 = ((BubbleInterActiveAnim.AnimHolder)localObject3).b;
          ((Rect)localObject2).bottom -= m;
          ((BubbleInterActiveAnim.AnimHolder)localObject3).f = ((BaseBubbleBuilder.ViewHolder)localObject1).h;
          this.g.put(Long.valueOf(paramLong1), localObject3);
          this.a.addView(((BubbleInterActiveAnim.AnimHolder)localObject3).e);
          ((BubbleInterActiveAnim.AnimHolder)localObject3).g = paramLong1;
          ((BubbleInterActiveAnim.AnimHolder)localObject3).h = paramLong2;
        }
      }
    }
    return localObject3;
  }
  
  protected void c()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext())
    {
      BubbleInterActiveAnim.AnimHolder localAnimHolder = (BubbleInterActiveAnim.AnimHolder)localIterator.next();
      if ((localAnimHolder != null) && (localAnimHolder.e != null)) {
        localAnimHolder.j.cancel();
      }
    }
  }
  
  public ObjectAnimator d(BubbleInterActiveAnim.AnimHolder paramAnimHolder)
  {
    BubbleNewAnimConf.InterActiveAnimConf localInterActiveAnimConf = (BubbleNewAnimConf.InterActiveAnimConf)paramAnimHolder.i.get("passive_animation");
    ObjectAnimator localObjectAnimator = a(paramAnimHolder, paramAnimHolder.b, localInterActiveAnimConf);
    if (localObjectAnimator == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
      return null;
    }
    localObjectAnimator.setRepeatCount(localInterActiveAnimConf.c - 1);
    localObjectAnimator.addListener(new BubbleInterActiveAnim.8(this, paramAnimHolder));
    return localObjectAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim
 * JD-Core Version:    0.7.0.1
 */