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
  public Handler a;
  public BubbleManager a;
  public List<View> a;
  public ConcurrentHashMap<Long, BubbleInterActiveAnim.AnimHolder> a;
  public int b;
  public List<AnimatorSet> b;
  public ConcurrentHashMap<String, Bitmap> b;
  public int c = 0;
  public int d;
  
  public BubbleInterActiveAnim(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidOsHandler = new BubbleInterActiveAnim.1(this, Looper.getMainLooper());
    this.jdField_b_of_type_Int = AIOUtils.b(12.0F, paramListView.getContext().getResources());
    this.c = AIOUtils.b(50.0F, paramListView.getContext().getResources());
    this.jdField_d_of_type_Int = AIOUtils.b(45.0F, paramListView.getContext().getResources());
  }
  
  private int a(Rect paramRect1, Rect paramRect2, String paramString, int paramInt)
  {
    int i = paramString.charAt(0);
    if (i != 66)
    {
      if (i != 67)
      {
        if (i == 84) {
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
    int i = paramString.charAt(1);
    if (paramBoolean)
    {
      if (i != 67)
      {
        if (i != 76)
        {
          if (i != 82) {
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
      int j = paramRect2.left + paramRect2.right;
      if (i != 67)
      {
        if (i != 76)
        {
          if (i != 82) {
            break label169;
          }
          paramInt = paramRect1.left - j;
          i = paramRect2.left;
        }
        else
        {
          paramInt = paramRect1.right - j;
          i = paramRect2.left;
        }
        paramInt -= i;
      }
      else
      {
        paramInt = (paramRect1.right - paramRect1.left) / 2 - j - paramRect2.left;
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
        paramQQAppInterface = paramAIOAnimationConatiner.a().getAdapter();
        int i = paramAIOAnimationConatiner.a().getFirstVisiblePosition();
        int j = paramAIOAnimationConatiner.a().getLastVisiblePosition();
        l2 = -1L;
        l1 = l2;
        boolean bool = false;
        while (j >= i)
        {
          Object localObject2 = new BubbleInterActiveAnim.DealChatMessage(paramMessageRecord, paramAIOAnimationConatiner, bool, j, paramQQAppInterface.getItem(j)).a();
          if (!((BubbleInterActiveAnim.DealChatMessage)localObject2).a())
          {
            Object localObject3 = ((BubbleInterActiveAnim.DealChatMessage)localObject2).a();
            Object localObject1 = ((BubbleInterActiveAnim.DealChatMessage)localObject2).a();
            bool = ((BubbleInterActiveAnim.DealChatMessage)localObject2).a().b();
            if (a((BaseBubbleBuilder.ViewHolder)localObject3))
            {
              localObject2 = a((MessageRecord)localObject1);
              localObject3 = localBubbleManager.a((int)((ChatMessage)localObject1).vipBubbleID, false);
              if (!a((ChatMessage)localObject1, (BubbleConfig)localObject3))
              {
                localObject1 = new BubbleInterActiveAnim.GetOtherSeq2(paramMessageRecord, paramSessionInfo, str, localBubbleConfig, l2, l1, (ChatMessage)localObject1, (String)localObject2, (BubbleConfig)localObject3).a();
                if (((BubbleInterActiveAnim.GetOtherSeq2)localObject1).a()) {
                  break;
                }
                l2 = ((BubbleInterActiveAnim.GetOtherSeq2)localObject1).a();
                l1 = ((BubbleInterActiveAnim.GetOtherSeq2)localObject1).b();
              }
            }
          }
          j -= 1;
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
        l = paramLong1;
        if (!paramMessageRecord.hasNext()) {
          break;
        }
        if (paramString.equals(String.valueOf(((AtTroopMemberInfo)paramMessageRecord.next()).uin))) {
          paramLong1 = paramChatMessage.uniseq;
        }
      }
    }
    long l = paramLong1;
    if (paramMessageRecord.atInfoList != null)
    {
      l = paramLong1;
      if (paramMessageRecord.atInfoList.size() > 0)
      {
        paramMessageRecord = paramMessageRecord.atInfoList.iterator();
        paramLong1 = paramLong2;
        for (;;)
        {
          l = paramLong1;
          if (!paramMessageRecord.hasNext()) {
            break;
          }
          if (paramString.equals(String.valueOf(((AtTroopMemberInfo)paramMessageRecord.next()).uin))) {
            paramLong1 = paramChatMessage.uniseq;
          }
        }
      }
    }
    return l;
  }
  
  @NotNull
  private Animator.AnimatorListener a(BubbleInterActiveAnim.AnimHolder paramAnimHolder)
  {
    return new BubbleInterActiveAnim.5(this, paramAnimHolder);
  }
  
  @NotNull
  private AnimatorListenerAdapter a(BubbleInterActiveAnim.AnimHolder paramAnimHolder, ObjectAnimator paramObjectAnimator)
  {
    return new BubbleInterActiveAnim.6(this, paramObjectAnimator, paramAnimHolder);
  }
  
  private Pair<Integer, Integer> a(BubbleInterActiveAnim.AnimHolder paramAnimHolder, BubbleNewAnimConf.InterActiveAnimConf paramInterActiveAnimConf, Pair<Integer, Integer> paramPair)
  {
    if ((!TextUtils.isEmpty(paramInterActiveAnimConf.jdField_e_of_type_JavaLangString)) && (paramInterActiveAnimConf.jdField_c_of_type_AndroidGraphicsRect != null)) {
      return a(paramAnimHolder.jdField_a_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.jdField_c_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.jdField_e_of_type_JavaLangString, paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
    }
    if (QLog.isColorLevel())
    {
      paramAnimHolder = new StringBuilder();
      paramAnimHolder.append("start align: ");
      paramAnimHolder.append(paramInterActiveAnimConf.jdField_e_of_type_JavaLangString);
      paramAnimHolder.append(", startRect: ");
      paramAnimHolder.append(paramInterActiveAnimConf.jdField_c_of_type_AndroidGraphicsRect);
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
    if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
      paramString = a(paramMessageRecord);
    }
    return paramString;
  }
  
  private void a(BaseBubbleBuilder.ViewHolder paramViewHolder1, BaseBubbleBuilder.ViewHolder paramViewHolder2, long paramLong1, long paramLong2)
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramViewHolder1.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Int, 8)) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramViewHolder2.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Int, 8))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject1 = new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      Object localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      ((Message)localObject2).obj = localObject1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramViewHolder1.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Int, false);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramViewHolder2.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Int, false);
      localObject2 = ((BubbleConfig)localObject2).b.values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        a((BubbleNewAnimConf)((Iterator)localObject2).next(), paramViewHolder1.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Int);
      }
      a((BubbleNewAnimConf)((BubbleConfig)localObject1).b.get("passive_animation"), paramViewHolder2.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Int);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("resource is not all ready, originalMsg: ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramViewHolder1.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Int, 8));
    ((StringBuilder)localObject1).append(", target msg: ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramViewHolder2.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Int, 8));
    QLog.e("BubbleInterActiveAnim", 1, ((StringBuilder)localObject1).toString());
  }
  
  private static void a(BubbleInterActiveAnim.AnimFrameData paramAnimFrameData, PathPoint paramPathPoint, double paramDouble1, double paramDouble2)
  {
    if ((paramDouble2 != 0.0D) && (paramDouble1 != 0.0D))
    {
      paramPathPoint.c = ((float)Math.toDegrees(Math.asin(paramDouble1 / paramDouble2)));
      if (!paramAnimFrameData.jdField_a_of_type_Boolean) {
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
        localStringBuilder.append(paramAnimHolder.jdField_a_of_type_Long);
        localStringBuilder.append(" 's bubbleView");
        QLog.i("BubbleInterActiveAnim", 2, localStringBuilder.toString());
      }
      paramAnimHolder.jdField_a_of_type_AndroidViewView = paramObject1.jdField_a_of_type_AndroidViewView;
      paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramObject1.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramObject1 = new StringBuilder();
        paramObject1.append("stop current bubble animation! ");
        paramObject1.append(paramAnimHolder.jdField_a_of_type_Long);
        QLog.w("BubbleInterActiveAnim", 2, paramObject1.toString());
      }
      paramAnimHolder.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    if ((paramObject2 != null) && ((paramObject2 instanceof BaseBubbleBuilder.ViewHolder)))
    {
      paramObject1 = (BaseBubbleBuilder.ViewHolder)paramObject2;
      if (QLog.isColorLevel())
      {
        paramObject2 = new StringBuilder();
        paramObject2.append("refresh seq ");
        paramObject2.append(paramAnimHolder.jdField_b_of_type_Long);
        paramObject2.append(" 's bubbleView");
        QLog.i("BubbleInterActiveAnim", 2, paramObject2.toString());
      }
      paramAnimHolder.jdField_b_of_type_ComTencentMobileqqDataMessageRecord = paramObject1.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      return;
    }
    if (QLog.isColorLevel())
    {
      paramObject1 = new StringBuilder();
      paramObject1.append("stop current bubble animation! ");
      paramObject1.append(paramAnimHolder.jdField_b_of_type_Long);
      QLog.i("BubbleInterActiveAnim", 2, paramObject1.toString());
    }
    paramAnimHolder.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
  }
  
  private boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getAdapter() != null) && (paramLong > 0L))
    {
      Object localObject2 = null;
      ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
      int i = localListAdapter.getCount() - 1;
      Object localObject1;
      for (;;)
      {
        localObject1 = localObject2;
        if (i < 0) {
          break;
        }
        localObject1 = localListAdapter.getItem(i);
        if ((localObject1 instanceof ChatMessage))
        {
          localObject1 = (ChatMessage)localObject1;
          if (((ChatMessage)localObject1).uniseq == paramLong) {
            break;
          }
        }
        i -= 1;
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
    return (paramViewHolder != null) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null);
  }
  
  private boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder1, BaseBubbleBuilder.ViewHolder paramViewHolder2)
  {
    return (paramViewHolder1 == null) || (paramViewHolder2 == null) || (paramViewHolder1.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo == null) || (paramViewHolder2.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo == null);
  }
  
  private static boolean a(AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    return (paramAIOAnimationConatiner.a() != null) && (paramAIOAnimationConatiner.a().getAdapter() != null);
  }
  
  public static boolean a(AIOAnimationConatiner paramAIOAnimationConatiner, long paramLong)
  {
    ListAdapter localListAdapter = paramAIOAnimationConatiner.a().getAdapter();
    int j;
    int i;
    if (paramAIOAnimationConatiner.a().getChildCount() > 0)
    {
      if ((localListAdapter instanceof HeaderViewListAdapter))
      {
        j = paramAIOAnimationConatiner.a().getFirstVisiblePosition();
        i = paramAIOAnimationConatiner.a().getLastVisiblePosition();
      }
      else if ((localListAdapter instanceof ChatAdapter1))
      {
        j = paramAIOAnimationConatiner.a().getFirstVisiblePosition() - paramAIOAnimationConatiner.a().getHeaderViewsCount();
        i = paramAIOAnimationConatiner.a().getLastVisiblePosition() - paramAIOAnimationConatiner.a().getFooterViewsCount();
      }
      else
      {
        i = 0;
        j = 0;
      }
      if ((j < 0) || (j >= localListAdapter.getCount())) {
        j = 0;
      }
      if ((i < 0) || (i >= localListAdapter.getCount())) {
        i = 0;
      }
    }
    else
    {
      i = 0;
      j = 0;
    }
    return a(paramLong, localListAdapter, j, i);
  }
  
  private static boolean a(BubbleConfig paramBubbleConfig)
  {
    if ((paramBubbleConfig != null) && (paramBubbleConfig.b != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("bubble config mInterActivePackageID: ");
        localStringBuilder.append(paramBubbleConfig.f);
        localStringBuilder.append(", bubble mInterActiveType: ");
        localStringBuilder.append(paramBubbleConfig.g);
        QLog.i("BubbleInterActiveAnim", 2, localStringBuilder.toString());
      }
      return false;
    }
    return true;
  }
  
  private static boolean a(BubbleConfig paramBubbleConfig1, BubbleConfig paramBubbleConfig2, boolean paramBoolean)
  {
    if (paramBubbleConfig1.g == 3)
    {
      if (((paramBubbleConfig2.g != 2) || (paramBubbleConfig2.f == paramBubbleConfig1.f)) && (paramBubbleConfig2.g != 3)) {}
    }
    else {
      for (;;)
      {
        return true;
        if (paramBubbleConfig1.g == 1)
        {
          if ((paramBubbleConfig1.f == paramBubbleConfig2.f) && (paramBubbleConfig1.g == paramBubbleConfig2.g)) {}
        }
        else {
          do
          {
            return false;
            if ((paramBubbleConfig1.g != 2) || ((paramBubbleConfig2.g != 2) && (paramBubbleConfig2.g != 3))) {
              break;
            }
          } while (paramBubbleConfig2.f == paramBubbleConfig1.f);
        }
      }
    }
    return paramBoolean;
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      paramChatMessage = EmojiStickerManager.a().a(paramChatMessage);
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
    if ((paramBubbleConfig != null) && (paramBubbleConfig.b != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("record seq: ");
        localStringBuilder.append(paramChatMessage.uniseq);
        localStringBuilder.append(", other bubble config mInterActivePackageID: ");
        localStringBuilder.append(paramBubbleConfig.f);
        localStringBuilder.append(", other bubble config mInterActiveType: ");
        localStringBuilder.append(paramBubbleConfig.g);
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
    if (paramSessionInfo.jdField_a_of_type_Int == 0) {
      return paramLong1;
    }
    return a(paramMessageRecord, paramLong1, paramLong2, paramChatMessage, paramString);
  }
  
  private static BubbleInterActiveAnim.AnimFrameData b(float paramFloat1, BubbleInterActiveAnim.AnimFrameData paramAnimFrameData1, BubbleInterActiveAnim.AnimFrameData paramAnimFrameData2, long paramLong, float paramFloat2, float paramFloat3, PathPoint paramPathPoint, BubbleInterActiveAnim.AnimFrameData paramAnimFrameData3)
  {
    if (paramAnimFrameData1.jdField_b_of_type_Boolean)
    {
      double d1 = paramFloat1;
      int i;
      if (d1 >= 1.0D)
      {
        i = 100;
      }
      else
      {
        Double.isNaN(d1);
        i = (int)((d1 + 0.005D) * 100.0D);
      }
      paramAnimFrameData3.jdField_a_of_type_Int = i;
      if ((paramAnimFrameData3.jdField_a_of_type_Int - paramAnimFrameData2.jdField_a_of_type_Int >= 5) || (paramAnimFrameData2.jdField_a_of_type_Int == 0))
      {
        if ((paramAnimFrameData2.jdField_b_of_type_Int == 0) || (paramAnimFrameData2.c == 0))
        {
          paramAnimFrameData2.jdField_b_of_type_Int = ((int)paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.a);
          paramAnimFrameData2.c = ((int)paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b);
        }
        d1 = Math.abs(paramFloat3 - paramAnimFrameData2.c);
        double d2 = Math.abs(paramFloat2 - paramAnimFrameData2.jdField_b_of_type_Int);
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
        paramAnimFrameData2.jdField_a_of_type_Int = paramAnimFrameData3.jdField_a_of_type_Int;
      }
      if (paramFloat1 == 1.0F) {
        paramPathPoint.c = 360.0F;
      }
    }
    paramAnimFrameData2.jdField_b_of_type_Int = ((int)paramFloat2);
    paramAnimFrameData2.c = ((int)paramFloat3);
    return paramAnimFrameData3;
  }
  
  private static boolean b(SessionInfo paramSessionInfo, BubbleConfig paramBubbleConfig1, BubbleConfig paramBubbleConfig2)
  {
    int i = paramSessionInfo.jdField_a_of_type_Int;
    boolean bool2 = false;
    if (i == 0) {
      return true;
    }
    boolean bool1 = bool2;
    if (paramBubbleConfig1.f != -1)
    {
      bool1 = bool2;
      if (paramBubbleConfig2.f != -1) {
        bool1 = a(paramBubbleConfig1, paramBubbleConfig2, false);
      }
    }
    return bool1;
  }
  
  public ObjectAnimator a(BubbleInterActiveAnim.AnimHolder paramAnimHolder)
  {
    Object localObject1 = (BubbleNewAnimConf.InterActiveAnimConf)paramAnimHolder.jdField_a_of_type_JavaUtilHashMap.get("animation_start");
    ObjectAnimator localObjectAnimator = a(paramAnimHolder, paramAnimHolder.jdField_a_of_type_AndroidGraphicsRect, (BubbleNewAnimConf.InterActiveAnimConf)localObject1);
    localObjectAnimator.setRepeatCount(((BubbleNewAnimConf.InterActiveAnimConf)localObject1).jdField_a_of_type_Int - 1);
    if (((BubbleNewAnimConf.InterActiveAnimConf)paramAnimHolder.jdField_a_of_type_JavaUtilHashMap.get("animation_running")).jdField_b_of_type_Boolean)
    {
      Object localObject3 = (BubbleNewAnimConf.InterActiveAnimConf)paramAnimHolder.jdField_a_of_type_JavaUtilHashMap.get("animation_end");
      Object localObject2 = a(paramAnimHolder.jdField_a_of_type_AndroidGraphicsRect, ((BubbleNewAnimConf.InterActiveAnimConf)localObject1).jdField_a_of_type_AndroidGraphicsRect, ((BubbleNewAnimConf.InterActiveAnimConf)localObject1).jdField_c_of_type_JavaLangString, paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      localObject3 = a(paramAnimHolder.jdField_b_of_type_AndroidGraphicsRect, ((BubbleNewAnimConf.InterActiveAnimConf)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((BubbleNewAnimConf.InterActiveAnimConf)localObject3).jdField_c_of_type_JavaLangString, paramAnimHolder.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      int i = ((Integer)((Pair)localObject2).first).intValue();
      int j = ((Integer)((Pair)localObject2).second).intValue();
      int k = ((Integer)((Pair)localObject3).first).intValue();
      double d1 = Math.abs(((Integer)((Pair)localObject3).second).intValue() - j);
      double d2 = Math.abs(k - i);
      d2 = Math.sqrt(Math.pow(d1, 2.0D) + Math.pow(d2, 2.0D));
      float f1;
      if ((d2 != 0.0D) && (d1 != 0.0D))
      {
        Double.isNaN(d1);
        float f2 = (float)Math.toDegrees(Math.asin(d1 / d2));
        f1 = f2;
        if (!paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
          f1 = -f2;
        }
      }
      else
      {
        f1 = 0.0F;
      }
      localObject2 = ObjectAnimator.ofFloat(paramAnimHolder.jdField_a_of_type_AndroidWidgetImageView, "rotation", new float[] { 0.0F, f1 });
      i = ((BubbleNewAnimConf.InterActiveAnimConf)localObject1).jdField_a_of_type_Int - 1;
      long l;
      if (i > 0) {
        l = i * localObjectAnimator.getDuration();
      } else {
        l = localObjectAnimator.getDuration();
      }
      ((ObjectAnimator)localObject2).setDuration(l);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start animation, rotate view: ");
        ((StringBuilder)localObject1).append(f1);
        ((StringBuilder)localObject1).append(", duration: ");
        ((StringBuilder)localObject1).append(l);
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
      if (paramInterActiveAnimConf.jdField_e_of_type_Int == -1)
      {
        if (paramRect == paramAnimHolder.jdField_a_of_type_AndroidGraphicsRect) {
          localObject1 = paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        } else {
          localObject1 = paramAnimHolder.jdField_b_of_type_ComTencentMobileqqDataMessageRecord;
        }
        boolean bool = ((MessageRecord)localObject1).isSend();
        paramRect = a(paramRect, paramInterActiveAnimConf.jdField_a_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.jdField_c_of_type_JavaLangString, bool);
        localObject1 = new PathPoint(-1, ((Integer)paramRect.first).intValue(), ((Integer)paramRect.second).intValue());
      }
    }
    localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramInterActiveAnimConf.jdField_d_of_type_Int, false), paramInterActiveAnimConf.jdField_d_of_type_JavaLangString);
    paramRect = new ArrayList();
    int i = 0;
    while (i < paramInterActiveAnimConf.jdField_b_of_type_Int)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
      ((StringBuilder)localObject2).append(File.separatorChar);
      ((StringBuilder)localObject2).append(paramInterActiveAnimConf.jdField_b_of_type_JavaLangString);
      i += 1;
      ((StringBuilder)localObject2).append(String.format("%04d.png", new Object[] { Integer.valueOf(i) }));
      localObject2 = ((StringBuilder)localObject2).toString();
      BubbleInterActiveAnim.AnimFrameData localAnimFrameData = new BubbleInterActiveAnim.AnimFrameData();
      localAnimFrameData.jdField_b_of_type_JavaLangString = ((String)localObject2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInterActiveAnimConf.jdField_a_of_type_JavaLangString);
      localStringBuilder.append((String)localObject2);
      localAnimFrameData.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder = paramAnimHolder;
      localAnimFrameData.jdField_a_of_type_AndroidGraphicsRect = paramInterActiveAnimConf.jdField_a_of_type_AndroidGraphicsRect;
      if (paramInterActiveAnimConf.jdField_a_of_type_Boolean) {
        localAnimFrameData.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend() ^ true);
      }
      localAnimFrameData.jdField_a_of_type_Boolean = paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
      if (paramInterActiveAnimConf.jdField_e_of_type_Int == -1) {
        localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint = ((PathPoint)localObject1);
      }
      paramRect.add(localAnimFrameData);
    }
    paramAnimHolder = new Keyframe[paramRect.size() + 1];
    float f = 1.0F / paramRect.size();
    paramAnimHolder[0] = Keyframe.ofObject(0.0F, paramRect.get(0));
    i = 0;
    while (i < paramRect.size())
    {
      if (i != paramRect.size() - 1)
      {
        int j = i + 1;
        paramAnimHolder[j] = Keyframe.ofObject(j * f, paramRect.get(i));
      }
      else
      {
        paramAnimHolder[(i + 1)] = Keyframe.ofObject(1.0F, paramRect.get(i));
      }
      i += 1;
    }
    paramAnimHolder = PropertyValuesHolder.ofKeyframe("bitmapData", paramAnimHolder);
    paramAnimHolder.setEvaluator(new BubbleInterActiveAnim.BimapEvaluator(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { paramAnimHolder }).setDuration(paramRect.size() * paramInterActiveAnimConf.jdField_a_of_type_Long);
  }
  
  public ObjectAnimator a(BubbleInterActiveAnim.AnimHolder paramAnimHolder, BubbleNewAnimConf.InterActiveAnimConf paramInterActiveAnimConf)
  {
    Object localObject2 = a(paramAnimHolder, paramInterActiveAnimConf, null);
    Object localObject1;
    if ((!TextUtils.isEmpty(paramInterActiveAnimConf.f)) && (paramInterActiveAnimConf.jdField_d_of_type_AndroidGraphicsRect != null))
    {
      localObject1 = a(paramAnimHolder.jdField_b_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.jdField_d_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.f, paramAnimHolder.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("end align ");
        ((StringBuilder)localObject1).append(paramInterActiveAnimConf.f);
        ((StringBuilder)localObject1).append(", endRect: ");
        ((StringBuilder)localObject1).append(paramInterActiveAnimConf.jdField_d_of_type_AndroidGraphicsRect);
        QLog.i("BubbleInterActiveAnim", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = null;
    }
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        return null;
      }
      int j = ((Integer)((Pair)localObject2).first).intValue();
      int k = ((Integer)((Pair)localObject2).second).intValue();
      int m = ((Integer)((Pair)localObject1).first).intValue();
      int n = ((Integer)((Pair)localObject1).second).intValue();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(PathPoint.b(j, k));
      ((ArrayList)localObject1).add(PathPoint.a(m, n));
      localObject2 = new BubbleInterActiveAnim.PathEvaluator();
      BubbleInterActiveAnim.AnimFrameData[] arrayOfAnimFrameData = new BubbleInterActiveAnim.AnimFrameData[((ArrayList)localObject1).size()];
      int i = 0;
      while (i < arrayOfAnimFrameData.length)
      {
        BubbleInterActiveAnim.AnimFrameData localAnimFrameData = new BubbleInterActiveAnim.AnimFrameData();
        localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder = paramAnimHolder;
        localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint = ((PathPoint)((ArrayList)localObject1).get(i));
        if (paramInterActiveAnimConf.jdField_a_of_type_Boolean) {
          localAnimFrameData.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend() ^ true);
        }
        localAnimFrameData.jdField_a_of_type_Boolean = paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        localAnimFrameData.jdField_b_of_type_Boolean = paramInterActiveAnimConf.jdField_b_of_type_Boolean;
        localAnimFrameData.jdField_a_of_type_AndroidGraphicsRect = paramInterActiveAnimConf.jdField_a_of_type_AndroidGraphicsRect;
        arrayOfAnimFrameData[i] = localAnimFrameData;
        i += 1;
      }
      paramAnimHolder = ObjectAnimator.ofObject(this, "pathLocation", (TypeEvaluator)localObject2, arrayOfAnimFrameData);
      float f = (Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.c;
      paramAnimHolder.setDuration(((float)paramInterActiveAnimConf.jdField_a_of_type_Long * f));
      return paramAnimHolder;
    }
    return null;
  }
  
  public Rect a(BaseBubbleBuilder.ViewHolder paramViewHolder, long paramLong, ListView paramListView)
  {
    int i = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Int;
    paramListView = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(i, false);
    if (paramListView == null) {
      return null;
    }
    if ((BubbleNewAnimConf)paramListView.b.get("animation_start") == null)
    {
      paramListView = paramListView.b.values().iterator();
      while ((paramListView.hasNext()) && ((BubbleNewAnimConf)paramListView.next() == null)) {}
    }
    paramListView = paramViewHolder.jdField_a_of_type_AndroidViewView;
    int j = paramListView.getLeft();
    i = paramListView.getTop();
    paramViewHolder = (View)paramListView.getParent();
    while ((paramViewHolder != null) && (!(paramViewHolder instanceof BaseChatItemLayout)))
    {
      j += paramViewHolder.getLeft();
      i += paramViewHolder.getTop();
      paramViewHolder = paramViewHolder.getParent();
      if ((paramViewHolder instanceof View)) {
        paramViewHolder = (View)paramViewHolder;
      } else {
        paramViewHolder = null;
      }
    }
    paramViewHolder = new Rect();
    paramViewHolder.left = (BaseChatItemLayout.j + j);
    paramViewHolder.right = (j + (paramListView.getRight() - paramListView.getLeft()) - BaseChatItemLayout.j);
    paramViewHolder.top = (BaseChatItemLayout.h + i);
    paramViewHolder.bottom = (i + (paramListView.getBottom() - paramListView.getTop()) - BaseChatItemLayout.i);
    return paramViewHolder;
  }
  
  public Pair<Integer, Integer> a(Rect paramRect1, Rect paramRect2, String paramString, boolean paramBoolean)
  {
    int i = a(paramRect1, paramRect2, paramString, 0);
    return new Pair(Integer.valueOf(a(paramRect1, paramRect2, paramString, paramBoolean, 0)), Integer.valueOf(i));
  }
  
  public BubbleInterActiveAnim.AnimHolder a(long paramLong1, long paramLong2)
  {
    Object localObject1 = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, AIOUtils.a(paramLong1, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter())));
    boolean bool = localObject1 instanceof BaseBubbleBuilder.ViewHolder;
    BubbleNewAnimConf localBubbleNewAnimConf = null;
    if (bool) {
      localObject1 = (BaseBubbleBuilder.ViewHolder)localObject1;
    } else {
      localObject1 = null;
    }
    Object localObject2 = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, AIOUtils.a(paramLong2, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter())));
    if ((localObject2 instanceof BaseBubbleBuilder.ViewHolder)) {
      localObject2 = (BaseBubbleBuilder.ViewHolder)localObject2;
    } else {
      localObject2 = null;
    }
    if (a((BaseBubbleBuilder.ViewHolder)localObject1, (BaseBubbleBuilder.ViewHolder)localObject2)) {
      return null;
    }
    int i = ((BaseBubbleBuilder.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Int;
    int j = ((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Int;
    BubbleConfig localBubbleConfig = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(i, false);
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(j, false);
    Object localObject3 = localBubbleNewAnimConf;
    if (localBubbleConfig != null)
    {
      localObject3 = localBubbleNewAnimConf;
      if (localObject4 != null)
      {
        localObject3 = localBubbleNewAnimConf;
        if (localBubbleConfig.b != null)
        {
          if (((BubbleConfig)localObject4).b == null) {
            return null;
          }
          localBubbleNewAnimConf = (BubbleNewAnimConf)localBubbleConfig.b.get("animation_start");
          localObject4 = (BubbleNewAnimConf)((BubbleConfig)localObject4).b.get("passive_animation");
          if (localBubbleNewAnimConf == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("can't find mInterActiveAnims from bubbleId: ");
            ((StringBuilder)localObject1).append(i);
            QLog.e("BubbleInterActiveAnim", 1, ((StringBuilder)localObject1).toString());
            return null;
          }
          localObject3 = new BubbleInterActiveAnim.AnimHolder();
          ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((BaseBubbleBuilder.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_b_of_type_ComTencentMobileqqDataMessageRecord = ((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_JavaUtilHashMap = new HashMap(localBubbleConfig.b);
          ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_JavaUtilHashMap.put("passive_animation", localObject4);
          ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
          ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView.layout(0, 0, localBubbleNewAnimConf.jdField_a_of_type_AndroidGraphicsRect.right, localBubbleNewAnimConf.jdField_a_of_type_AndroidGraphicsRect.bottom);
          ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_AndroidGraphicsRect = a((BaseBubbleBuilder.ViewHolder)localObject1, paramLong1, this.jdField_a_of_type_ComTencentWidgetListView);
          ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_b_of_type_AndroidGraphicsRect = a((BaseBubbleBuilder.ViewHolder)localObject2, paramLong2, this.jdField_a_of_type_ComTencentWidgetListView);
          localObject2 = (View)((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.getParent();
          i = ((View)((BaseBubbleBuilder.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView.getParent()).getTop() - ((View)localObject2).getTop();
          localObject2 = ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_b_of_type_AndroidGraphicsRect;
          ((Rect)localObject2).top -= i;
          localObject2 = ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_b_of_type_AndroidGraphicsRect;
          ((Rect)localObject2).bottom -= i;
          ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_AndroidViewView = ((BaseBubbleBuilder.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView;
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localObject3);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView);
          ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_Long = paramLong1;
          ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_b_of_type_Long = paramLong2;
        }
      }
    }
    return localObject3;
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      BubbleInterActiveAnim.AnimHolder localAnimHolder = (BubbleInterActiveAnim.AnimHolder)localIterator.next();
      if ((localAnimHolder != null) && (localAnimHolder.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("add delta ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" for seq: ");
          localStringBuilder.append(localAnimHolder.jdField_a_of_type_Long);
          QLog.i("BubbleInterActiveAnim", 2, localStringBuilder.toString());
        }
        localAnimHolder.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(localAnimHolder.jdField_a_of_type_AndroidWidgetImageView.getTranslationY() + paramInt);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ThreadManager.post(new BubbleInterActiveAnim.2(this, paramLong1, paramLong2), 5, null, true);
  }
  
  public void a(BubbleInterActiveAnim.AnimHolder paramAnimHolder)
  {
    paramAnimHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeView(paramAnimHolder.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramAnimHolder.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
      d();
    }
  }
  
  public void a(BubbleNewAnimConf paramBubbleNewAnimConf, int paramInt)
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramInt, false), paramBubbleNewAnimConf.jdField_d_of_type_JavaLangString);
    paramInt = 0;
    while (paramInt < paramBubbleNewAnimConf.jdField_b_of_type_Int)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localFile.getAbsolutePath());
      ((StringBuilder)localObject1).append(File.separatorChar);
      ((StringBuilder)localObject1).append(paramBubbleNewAnimConf.jdField_b_of_type_JavaLangString);
      int i = paramInt + 1;
      ((StringBuilder)localObject1).append(String.format("%04d.png", new Object[] { Integer.valueOf(i) }));
      Object localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramBubbleNewAnimConf.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append((String)localObject2);
      String str = ((StringBuilder)localObject1).toString();
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
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
        localObject1 = (Bitmap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      paramInt = i;
      if (localObject1 != null)
      {
        GlobalImageCache.a.put(str, localObject1);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject1);
        paramInt = i;
      }
    }
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      BubbleInterActiveAnim.AnimHolder localAnimHolder = (BubbleInterActiveAnim.AnimHolder)localIterator.next();
      if ((localAnimHolder != null) && (localAnimHolder.jdField_a_of_type_AndroidViewView != null))
      {
        paramInt1 = AIOUtils.a(localAnimHolder.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
        paramInt2 = AIOUtils.a(localAnimHolder.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
        a(localAnimHolder, AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, paramInt1)), AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, paramInt2)));
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
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager == null)
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
        this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager = ((BubbleManager)paramVarArgs.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER));
      }
      a(l1, l2);
      return true;
    }
    return false;
  }
  
  public ObjectAnimator b(BubbleInterActiveAnim.AnimHolder paramAnimHolder)
  {
    Object localObject1 = (BubbleNewAnimConf)paramAnimHolder.jdField_a_of_type_JavaUtilHashMap.get("animation_running");
    if (!(localObject1 instanceof BubbleNewAnimConf.InterActiveAnimConf)) {
      return null;
    }
    Object localObject2 = (BubbleNewAnimConf.InterActiveAnimConf)localObject1;
    if (((BubbleNewAnimConf.InterActiveAnimConf)localObject2).jdField_e_of_type_Int == -1) {
      return null;
    }
    if (((BubbleNewAnimConf.InterActiveAnimConf)localObject2).jdField_e_of_type_Int == 0) {
      localObject1 = a(paramAnimHolder, (BubbleNewAnimConf.InterActiveAnimConf)localObject2);
    } else {
      localObject1 = b(paramAnimHolder, (BubbleNewAnimConf.InterActiveAnimConf)localObject2);
    }
    localObject2 = a(paramAnimHolder, paramAnimHolder.jdField_a_of_type_AndroidGraphicsRect, (BubbleNewAnimConf.InterActiveAnimConf)localObject2);
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
  
  public ObjectAnimator b(BubbleInterActiveAnim.AnimHolder paramAnimHolder, BubbleNewAnimConf.InterActiveAnimConf paramInterActiveAnimConf)
  {
    Object localObject2 = a(paramAnimHolder, paramInterActiveAnimConf, null);
    Object localObject1;
    if ((!TextUtils.isEmpty(paramInterActiveAnimConf.f)) && (paramInterActiveAnimConf.jdField_d_of_type_AndroidGraphicsRect != null))
    {
      localObject1 = a(paramAnimHolder.jdField_b_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.jdField_d_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.f, paramAnimHolder.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("end align ");
        ((StringBuilder)localObject1).append(paramInterActiveAnimConf.f);
        ((StringBuilder)localObject1).append(", endRect: ");
        ((StringBuilder)localObject1).append(paramInterActiveAnimConf.jdField_d_of_type_AndroidGraphicsRect);
        QLog.i("BubbleInterActiveAnim", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = null;
    }
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        return null;
      }
      int j = ((Integer)((Pair)localObject2).first).intValue();
      int k = ((Integer)((Pair)localObject2).second).intValue();
      int m = ((Integer)((Pair)localObject1).first).intValue();
      int n = ((Integer)((Pair)localObject1).second).intValue();
      float f3;
      float f2;
      float f5;
      float f4;
      if (paramInterActiveAnimConf.jdField_e_of_type_Int == 1)
      {
        f1 = m - j;
        f3 = j;
        f2 = n - k;
        f5 = k;
        f4 = f2 * 1.0F + f5;
        f2 = 0.1F * f2 + f5;
        f1 = f1 * 0.25F + f3;
        f3 = f1;
      }
      else if (paramInterActiveAnimConf.jdField_e_of_type_Int == 2)
      {
        f1 = m - j;
        f5 = j;
        f2 = n - k;
        f4 = k;
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
      ((ArrayList)localObject1).add(PathPoint.b(j, k));
      ((ArrayList)localObject1).add(PathPoint.a(f1, f2, f3, f4, m, n));
      localObject2 = new BubbleInterActiveAnim.AnimFrameData[((ArrayList)localObject1).size()];
      int i = 0;
      while (i < localObject2.length)
      {
        BubbleInterActiveAnim.AnimFrameData localAnimFrameData = new BubbleInterActiveAnim.AnimFrameData();
        localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder = paramAnimHolder;
        localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint = ((PathPoint)((ArrayList)localObject1).get(i));
        if (paramInterActiveAnimConf.jdField_a_of_type_Boolean) {
          localAnimFrameData.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend() ^ true);
        }
        localAnimFrameData.jdField_a_of_type_Boolean = paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        localAnimFrameData.jdField_a_of_type_AndroidGraphicsRect = paramInterActiveAnimConf.jdField_a_of_type_AndroidGraphicsRect;
        localAnimFrameData.jdField_b_of_type_Boolean = paramInterActiveAnimConf.jdField_b_of_type_Boolean;
        localObject2[i] = localAnimFrameData;
        i += 1;
      }
      paramAnimHolder = ObjectAnimator.ofObject(this, "pathLocation", new BubbleInterActiveAnim.PathEvaluator(), (Object[])localObject2);
      float f1 = (Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.c;
      double d1 = (float)paramInterActiveAnimConf.jdField_a_of_type_Long * f1;
      Double.isNaN(d1);
      paramAnimHolder.setDuration((d1 * 3.141592653589793D * 0.6000000238418579D));
      return paramAnimHolder;
    }
    return null;
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    BubbleInterActiveAnim.AnimHolder localAnimHolder = a(paramLong1, paramLong2);
    if (localAnimHolder != null)
    {
      Object localObject1 = a(localAnimHolder);
      if (localObject1 == null)
      {
        QLog.e("BubbleInterActiveAnim", 1, "startAnimator is null");
        return;
      }
      ObjectAnimator localObjectAnimator1 = b(localAnimHolder);
      if (localObjectAnimator1 == null)
      {
        QLog.e("BubbleInterActiveAnim", 1, "runningAnimator is null");
        return;
      }
      Object localObject2 = (BubbleNewAnimConf.InterActiveAnimConf)localAnimHolder.jdField_a_of_type_JavaUtilHashMap.get("animation_end");
      ObjectAnimator localObjectAnimator2 = a(localAnimHolder, localAnimHolder.jdField_b_of_type_AndroidGraphicsRect, (BubbleNewAnimConf.InterActiveAnimConf)localObject2);
      if (localObjectAnimator2 == null)
      {
        QLog.e("BubbleInterActiveAnim", 1, "endAnimator is null");
        return;
      }
      localObjectAnimator2.setRepeatCount(((BubbleNewAnimConf.InterActiveAnimConf)localObject2).jdField_a_of_type_Int - 1);
      localObject2 = c(localAnimHolder);
      if (localObject2 == null)
      {
        QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
        return;
      }
      localAnimHolder.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(new Animator[] { localObject1, localObjectAnimator1, localObjectAnimator2, localObject2 });
      localAnimHolder.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new BubbleInterActiveAnim.3(this, localAnimHolder));
      localObject1 = a(localAnimHolder);
      localAnimHolder.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener((Animator.AnimatorListener)localObject1);
      this.jdField_a_of_type_AndroidOsHandler.post(new BubbleInterActiveAnim.4(this, localAnimHolder));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localAnimHolder);
    }
  }
  
  public ObjectAnimator c(BubbleInterActiveAnim.AnimHolder paramAnimHolder)
  {
    BubbleNewAnimConf.InterActiveAnimConf localInterActiveAnimConf = (BubbleNewAnimConf.InterActiveAnimConf)paramAnimHolder.jdField_a_of_type_JavaUtilHashMap.get("passive_animation");
    ObjectAnimator localObjectAnimator = a(paramAnimHolder, paramAnimHolder.jdField_b_of_type_AndroidGraphicsRect, localInterActiveAnimConf);
    if (localObjectAnimator == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
      return null;
    }
    localObjectAnimator.setRepeatCount(localInterActiveAnimConf.jdField_a_of_type_Int - 1);
    localObjectAnimator.addListener(new BubbleInterActiveAnim.8(this, paramAnimHolder));
    return localObjectAnimator;
  }
  
  protected void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      BubbleInterActiveAnim.AnimHolder localAnimHolder = (BubbleInterActiveAnim.AnimHolder)localIterator.next();
      if ((localAnimHolder != null) && (localAnimHolder.jdField_a_of_type_AndroidWidgetImageView != null)) {
        localAnimHolder.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim
 * JD-Core Version:    0.7.0.1
 */