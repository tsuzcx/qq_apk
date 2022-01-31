package com.tencent.mobileqq.bubble;

import abkv;
import abla;
import ablb;
import ablc;
import abld;
import able;
import ablf;
import ablg;
import ablh;
import abli;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
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

@TargetApi(11)
public class BubbleInterActiveAnim
  extends AIOAnimationConatiner.AIOAnimator
{
  public Handler a;
  public BubbleManager a;
  public String a;
  public List a;
  public ConcurrentHashMap a;
  public int b;
  public List b;
  public ConcurrentHashMap b;
  public int c;
  public int d;
  
  public BubbleInterActiveAnim(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidOsHandler = new abla(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = AIOUtils.a(12.0F, paramListView.getContext().getResources());
    this.c = AIOUtils.a(50.0F, paramListView.getContext().getResources());
    this.jdField_d_of_type_Int = AIOUtils.a(45.0F, paramListView.getContext().getResources());
  }
  
  public static long a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {}
    for (String str = a(paramMessageRecord);; str = null)
    {
      BubbleManager localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(43);
      BubbleConfig localBubbleConfig = localBubbleManager.a((int)paramMessageRecord.vipBubbleID, false);
      long l3;
      if ((localBubbleConfig == null) || (localBubbleConfig.b == null))
      {
        l3 = -1L;
        return l3;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "bubble config mInterActivePackageID: " + localBubbleConfig.f + ", bubble mInterActiveType: " + localBubbleConfig.g);
      }
      long l4 = -1L;
      long l2 = -1L;
      int j;
      Object localObject1;
      long l6;
      long l5;
      label272:
      int i;
      label308:
      label326:
      Object localObject2;
      label423:
      int m;
      if (!TextUtils.isEmpty(str))
      {
        j = 0;
        l1 = l4;
        l3 = l2;
        if (paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView == null) {
          break label1028;
        }
        l1 = l4;
        l3 = l2;
        if (paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView.getAdapter() == null) {
          break label1028;
        }
        ListAdapter localListAdapter = paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
        int n = paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
        int k = paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
        l1 = l4;
        l3 = l2;
        if (k < n) {
          break label1028;
        }
        localObject1 = localListAdapter.getItem(k);
        l6 = l4;
        l5 = l2;
        if (!(localObject1 instanceof ChatMessage)) {
          break label1006;
        }
        paramQQAppInterface = AIOUtils.a(AIOUtils.a(paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView, k));
        if ((paramQQAppInterface instanceof BaseBubbleBuilder.ViewHolder))
        {
          paramQQAppInterface = (BaseBubbleBuilder.ViewHolder)paramQQAppInterface;
          localObject1 = (ChatMessage)localObject1;
          if (j != 0) {
            break label326;
          }
          l6 = l4;
          l5 = l2;
          if (((ChatMessage)localObject1).uniseq != paramMessageRecord.uniseq) {
            break label1006;
          }
        }
        for (i = 1;; i = j)
        {
          k -= 1;
          j = i;
          break;
          paramQQAppInterface = null;
          break label272;
          l6 = l4;
          l5 = l2;
          if (paramQQAppInterface == null) {
            break label1006;
          }
          l6 = l4;
          l5 = l2;
          if (paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo == null) {
            break label1006;
          }
          paramQQAppInterface = a((MessageRecord)localObject1);
          localObject2 = localBubbleManager.a((int)((ChatMessage)localObject1).vipBubbleID, false);
          if ((localObject2 != null) && (((BubbleConfig)localObject2).b != null)) {
            break label423;
          }
          QLog.e("BubbleInterActiveAnim", 1, "get bubbleConfig is null: " + (int)((ChatMessage)localObject1).vipBubbleID);
        }
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "record seq: " + ((ChatMessage)localObject1).uniseq + ", other bubble config mInterActivePackageID: " + ((BubbleConfig)localObject2).f + ", other bubble config mInterActiveType: " + ((BubbleConfig)localObject2).g);
        }
        m = 0;
        if (paramSessionInfo.jdField_a_of_type_Int == 0)
        {
          i = 1;
          label497:
          l1 = l4;
          l3 = l2;
          if (!TextUtils.isEmpty(paramQQAppInterface))
          {
            l1 = l4;
            l3 = l2;
            if (!str.equals(paramQQAppInterface))
            {
              l1 = l4;
              l3 = l2;
              if (i != 0)
              {
                if (l4 != -1L) {
                  break label1021;
                }
                l1 = ((ChatMessage)localObject1).uniseq;
                label558:
                if (paramSessionInfo.jdField_a_of_type_Int != 0) {
                  break label843;
                }
                l3 = l1;
              }
            }
          }
          label569:
          l6 = l1;
          l5 = l3;
          if (l1 == -1L) {
            break label1006;
          }
          l6 = l1;
          l5 = l3;
          if (l3 == -1L) {
            break label1006;
          }
          l2 = l1;
        }
      }
      for (long l1 = l3;; l1 = l3)
      {
        if (l1 != -1L)
        {
          l3 = l1;
          if (a(paramAIOAnimationConatiner, l1)) {
            break;
          }
        }
        if ((l2 != -1L) && (a(paramAIOAnimationConatiner, l2)))
        {
          return l2;
          i = m;
          if (localBubbleConfig.f == -1) {
            break label497;
          }
          i = m;
          if (((BubbleConfig)localObject2).f == -1) {
            break label497;
          }
          if (localBubbleConfig.g == 3)
          {
            if ((((BubbleConfig)localObject2).g == 2) && (((BubbleConfig)localObject2).f != localBubbleConfig.f))
            {
              i = 1;
              break label497;
            }
            i = m;
            if (((BubbleConfig)localObject2).g != 3) {
              break label497;
            }
            i = 1;
            break label497;
          }
          if (localBubbleConfig.g == 1)
          {
            if ((localBubbleConfig.f == ((BubbleConfig)localObject2).f) && (localBubbleConfig.g == ((BubbleConfig)localObject2).g))
            {
              i = 1;
              break label497;
            }
            i = 0;
            break label497;
          }
          i = m;
          if (localBubbleConfig.g != 2) {
            break label497;
          }
          if (((BubbleConfig)localObject2).g != 2)
          {
            i = m;
            if (((BubbleConfig)localObject2).g != 3) {
              break label497;
            }
          }
          if (((BubbleConfig)localObject2).f != localBubbleConfig.f)
          {
            i = 1;
            break label497;
          }
          i = 0;
          break label497;
          label843:
          if ((paramMessageRecord.atInfoTempList != null) && (paramMessageRecord.atInfoTempList.size() > 0))
          {
            localObject2 = paramMessageRecord.atInfoTempList.iterator();
            while (((Iterator)localObject2).hasNext()) {
              if (paramQQAppInterface.equals(String.valueOf(((MessageForText.AtTroopMemberInfo)((Iterator)localObject2).next()).uin))) {
                l2 = ((ChatMessage)localObject1).uniseq;
              }
            }
            l3 = l2;
            break label569;
          }
          if ((paramMessageRecord.atInfoList != null) && (paramMessageRecord.atInfoList.size() > 0))
          {
            localObject2 = paramMessageRecord.atInfoList.iterator();
            while (((Iterator)localObject2).hasNext()) {
              if (paramQQAppInterface.equals(String.valueOf(((MessageForText.AtTroopMemberInfo)((Iterator)localObject2).next()).uin))) {
                l2 = ((ChatMessage)localObject1).uniseq;
              }
            }
            l3 = l2;
            break label569;
          }
          l3 = l1;
          break label569;
        }
        return -1L;
        label1006:
        i = j;
        l4 = l6;
        l2 = l5;
        break label308;
        label1021:
        l1 = l4;
        break label558;
        label1028:
        l2 = l1;
      }
    }
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isSend()) {
      return paramMessageRecord.selfuin;
    }
    if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020) || (paramMessageRecord.istroop == 1004)) {
      return paramMessageRecord.frienduin;
    }
    return paramMessageRecord.senderuin;
  }
  
  public static boolean a(AIOAnimationConatiner paramAIOAnimationConatiner, long paramLong)
  {
    boolean bool2 = false;
    ListAdapter localListAdapter = paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
    int j;
    int i;
    if (paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView.getChildCount() > 0) {
      if ((localListAdapter instanceof HeaderViewListAdapter))
      {
        j = paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
        i = paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
        if ((j < 0) || (j >= localListAdapter.getCount())) {
          break label167;
        }
        label64:
        if ((i < 0) || (i >= localListAdapter.getCount())) {
          break label173;
        }
      }
    }
    for (;;)
    {
      boolean bool1 = bool2;
      if (i >= j)
      {
        paramAIOAnimationConatiner = localListAdapter.getItem(i);
        if (((paramAIOAnimationConatiner instanceof MessageRecord)) && (((MessageRecord)paramAIOAnimationConatiner).uniseq == paramLong)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
        if (!(localListAdapter instanceof ChatAdapter1)) {
          break label185;
        }
        j = paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() - paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
        i = paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition() - paramAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView.getFooterViewsCount();
        break;
        label167:
        j = 0;
        break label64;
        label173:
        i = 0;
        continue;
      }
      i -= 1;
      continue;
      label185:
      i = 0;
      j = 0;
      break;
      i = 0;
      j = 0;
    }
  }
  
  public ObjectAnimator a(BubbleInterActiveAnim.AnimHolder paramAnimHolder)
  {
    BubbleNewAnimConf.InterActiveAnimConf localInterActiveAnimConf = (BubbleNewAnimConf.InterActiveAnimConf)paramAnimHolder.jdField_a_of_type_JavaUtilHashMap.get("animation_start");
    ObjectAnimator localObjectAnimator = a(paramAnimHolder, paramAnimHolder.jdField_a_of_type_AndroidGraphicsRect, localInterActiveAnimConf);
    localObjectAnimator.setRepeatCount(localInterActiveAnimConf.jdField_a_of_type_Int - 1);
    Object localObject1;
    long l;
    if (((BubbleNewAnimConf.InterActiveAnimConf)paramAnimHolder.jdField_a_of_type_JavaUtilHashMap.get("animation_running")).jdField_b_of_type_Boolean)
    {
      Object localObject2 = (BubbleNewAnimConf.InterActiveAnimConf)paramAnimHolder.jdField_a_of_type_JavaUtilHashMap.get("animation_end");
      localObject1 = a(paramAnimHolder.jdField_a_of_type_AndroidGraphicsRect, localInterActiveAnimConf.jdField_a_of_type_AndroidGraphicsRect, localInterActiveAnimConf.jdField_c_of_type_JavaLangString, paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      localObject2 = a(paramAnimHolder.jdField_b_of_type_AndroidGraphicsRect, ((BubbleNewAnimConf.InterActiveAnimConf)localObject2).jdField_a_of_type_AndroidGraphicsRect, ((BubbleNewAnimConf.InterActiveAnimConf)localObject2).jdField_c_of_type_JavaLangString, paramAnimHolder.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      int i = ((Integer)((Pair)localObject1).first).intValue();
      int j = ((Integer)((Pair)localObject1).second).intValue();
      int k = ((Integer)((Pair)localObject2).first).intValue();
      double d1 = Math.abs(((Integer)((Pair)localObject2).second).intValue() - j);
      double d2 = Math.abs(k - i);
      float f2 = 0.0F;
      double d3 = Math.pow(d1, 2.0D);
      d2 = Math.sqrt(Math.pow(d2, 2.0D) + d3);
      float f1 = f2;
      if (d2 != 0.0D)
      {
        f1 = f2;
        if (d1 != 0.0D)
        {
          f2 = (float)Math.toDegrees(Math.asin(d1 / d2));
          f1 = f2;
          if (!paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
            f1 = -f2;
          }
        }
      }
      localObject1 = ObjectAnimator.ofFloat(paramAnimHolder.jdField_a_of_type_AndroidWidgetImageView, "rotation", new float[] { 0.0F, f1 });
      i = localInterActiveAnimConf.jdField_a_of_type_Int - 1;
      if (i > 0)
      {
        l = i * localObjectAnimator.getDuration();
        ((ObjectAnimator)localObject1).setDuration(l);
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "start animation, rotate view: " + f1 + ", duration: " + l);
        }
      }
    }
    for (;;)
    {
      localObjectAnimator.addListener(new able(this, (ObjectAnimator)localObject1, paramAnimHolder));
      return localObjectAnimator;
      l = localObjectAnimator.getDuration();
      break;
      localObject1 = null;
    }
  }
  
  public ObjectAnimator a(BubbleInterActiveAnim.AnimHolder paramAnimHolder, Rect paramRect, BubbleNewAnimConf.InterActiveAnimConf paramInterActiveAnimConf)
  {
    File localFile = null;
    if (paramInterActiveAnimConf == null) {
      return null;
    }
    Object localObject = localFile;
    boolean bool;
    if (paramRect != null)
    {
      localObject = localFile;
      if (paramInterActiveAnimConf.jdField_e_of_type_Int == -1)
      {
        if (paramRect != paramAnimHolder.jdField_a_of_type_AndroidGraphicsRect) {
          break label326;
        }
        bool = paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        paramRect = a(paramRect, paramInterActiveAnimConf.jdField_a_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.jdField_c_of_type_JavaLangString, bool);
        localObject = new PathPoint(-1, ((Integer)paramRect.first).intValue(), ((Integer)paramRect.second).intValue());
      }
    }
    localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramInterActiveAnimConf.jdField_d_of_type_Int, false), paramInterActiveAnimConf.jdField_d_of_type_JavaLangString);
    paramRect = new ArrayList();
    int i = 0;
    label130:
    if (i < paramInterActiveAnimConf.jdField_b_of_type_Int)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramInterActiveAnimConf.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
      BubbleInterActiveAnim.AnimFrameData localAnimFrameData = new BubbleInterActiveAnim.AnimFrameData();
      localAnimFrameData.jdField_b_of_type_JavaLangString = str;
      localAnimFrameData.jdField_a_of_type_JavaLangString = (paramInterActiveAnimConf.jdField_a_of_type_JavaLangString + str);
      localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder = paramAnimHolder;
      localAnimFrameData.jdField_a_of_type_AndroidGraphicsRect = paramInterActiveAnimConf.jdField_a_of_type_AndroidGraphicsRect;
      if (paramInterActiveAnimConf.jdField_a_of_type_Boolean) {
        if (paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
          break label338;
        }
      }
      label326:
      label338:
      for (bool = true;; bool = false)
      {
        localAnimFrameData.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localAnimFrameData.jdField_a_of_type_Boolean = paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        if (paramInterActiveAnimConf.jdField_e_of_type_Int == -1) {
          localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint = ((PathPoint)localObject);
        }
        paramRect.add(localAnimFrameData);
        i += 1;
        break label130;
        bool = paramAnimHolder.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        break;
      }
    }
    paramAnimHolder = new Keyframe[paramRect.size() + 1];
    float f = 1.0F / paramRect.size();
    paramAnimHolder[0] = Keyframe.ofObject(0.0F, paramRect.get(0));
    i = 0;
    if (i < paramRect.size())
    {
      if (i != paramRect.size() - 1) {
        paramAnimHolder[(i + 1)] = Keyframe.ofObject((i + 1) * f, paramRect.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        paramAnimHolder[(i + 1)] = Keyframe.ofObject(1.0F, paramRect.get(i));
      }
    }
    paramAnimHolder = PropertyValuesHolder.ofKeyframe("bitmapData", paramAnimHolder);
    paramAnimHolder.setEvaluator(new BubbleInterActiveAnim.BimapEvaluator(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { paramAnimHolder }).setDuration(paramRect.size() * paramInterActiveAnimConf.jdField_a_of_type_Long);
  }
  
  public ObjectAnimator a(BubbleInterActiveAnim.AnimHolder paramAnimHolder, BubbleNewAnimConf.InterActiveAnimConf paramInterActiveAnimConf)
  {
    if ((!TextUtils.isEmpty(paramInterActiveAnimConf.jdField_e_of_type_JavaLangString)) && (paramInterActiveAnimConf.jdField_c_of_type_AndroidGraphicsRect != null))
    {
      localObject1 = a(paramAnimHolder.jdField_a_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.jdField_c_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.jdField_e_of_type_JavaLangString, paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      if ((TextUtils.isEmpty(paramInterActiveAnimConf.f)) || (paramInterActiveAnimConf.jdField_d_of_type_AndroidGraphicsRect == null)) {
        break label150;
      }
    }
    for (Object localObject2 = a(paramAnimHolder.jdField_b_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.jdField_d_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.f, paramAnimHolder.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());; localObject2 = null)
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        break label204;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "start align: " + paramInterActiveAnimConf.jdField_e_of_type_JavaLangString + ", startRect: " + paramInterActiveAnimConf.jdField_c_of_type_AndroidGraphicsRect);
      }
      localObject1 = null;
      break;
      label150:
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "end align " + paramInterActiveAnimConf.f + ", endRect: " + paramInterActiveAnimConf.jdField_d_of_type_AndroidGraphicsRect);
      }
    }
    label204:
    int j = ((Integer)((Pair)localObject1).first).intValue();
    int k = ((Integer)((Pair)localObject1).second).intValue();
    int m = ((Integer)((Pair)localObject2).first).intValue();
    int n = ((Integer)((Pair)localObject2).second).intValue();
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(PathPoint.b(j, k));
    ((ArrayList)localObject1).add(PathPoint.a(m, n));
    localObject2 = new BubbleInterActiveAnim.PathEvaluator();
    BubbleInterActiveAnim.AnimFrameData[] arrayOfAnimFrameData = new BubbleInterActiveAnim.AnimFrameData[((ArrayList)localObject1).size()];
    int i = 0;
    if (i < arrayOfAnimFrameData.length)
    {
      BubbleInterActiveAnim.AnimFrameData localAnimFrameData = new BubbleInterActiveAnim.AnimFrameData();
      localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder = paramAnimHolder;
      localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint = ((PathPoint)((ArrayList)localObject1).get(i));
      if (paramInterActiveAnimConf.jdField_a_of_type_Boolean) {
        if (paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
          break label425;
        }
      }
      label425:
      for (boolean bool = true;; bool = false)
      {
        localAnimFrameData.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localAnimFrameData.jdField_a_of_type_Boolean = paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        localAnimFrameData.jdField_b_of_type_Boolean = paramInterActiveAnimConf.jdField_b_of_type_Boolean;
        localAnimFrameData.jdField_a_of_type_AndroidGraphicsRect = paramInterActiveAnimConf.jdField_a_of_type_AndroidGraphicsRect;
        arrayOfAnimFrameData[i] = localAnimFrameData;
        i += 1;
        break;
      }
    }
    paramAnimHolder = ObjectAnimator.ofObject(this, "pathLocation", (TypeEvaluator)localObject2, arrayOfAnimFrameData);
    paramAnimHolder.setDuration(((Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.c * (float)paramInterActiveAnimConf.jdField_a_of_type_Long));
    return paramAnimHolder;
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
    for (;;)
    {
      if ((paramViewHolder == null) || ((paramViewHolder instanceof BaseChatItemLayout)))
      {
        paramViewHolder = new Rect();
        paramViewHolder.left = (BaseChatItemLayout.i + j);
        paramViewHolder.right = (paramListView.getRight() - paramListView.getLeft() + j - BaseChatItemLayout.i);
        paramViewHolder.top = (BaseChatItemLayout.g + i);
        paramViewHolder.bottom = (paramListView.getBottom() - paramListView.getTop() + i - BaseChatItemLayout.h);
        return paramViewHolder;
      }
      j += paramViewHolder.getLeft();
      i += paramViewHolder.getTop();
      paramViewHolder = paramViewHolder.getParent();
      if ((paramViewHolder instanceof View)) {
        paramViewHolder = (View)paramViewHolder;
      } else {
        paramViewHolder = null;
      }
    }
  }
  
  public Pair a(Rect paramRect1, Rect paramRect2, String paramString, boolean paramBoolean)
  {
    int i = 0;
    int j;
    int k;
    int m;
    switch (paramString.charAt(0))
    {
    default: 
      j = 0;
      k = paramRect2.top;
      m = paramString.charAt(1);
      if (paramBoolean) {
        switch (m)
        {
        }
      }
      break;
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(i + paramRect2.left), Integer.valueOf(j + k));
      j = paramRect1.top;
      break;
      j = (paramRect1.bottom - paramRect1.top) / 2;
      break;
      j = paramRect1.bottom;
      break;
      i = paramRect1.left;
      continue;
      i = (paramRect1.right - paramRect1.left) / 2;
      continue;
      i = paramRect1.right;
      continue;
      int n = paramRect2.left + paramRect2.right;
      switch (m)
      {
      default: 
        break;
      case 67: 
        i = (paramRect1.right - paramRect1.left) / 2 - n - paramRect2.left;
        break;
      case 76: 
        i = paramRect1.right - n - paramRect2.left;
        break;
      case 82: 
        i = paramRect1.left - n - paramRect2.left;
      }
    }
  }
  
  public BubbleInterActiveAnim.AnimHolder a(long paramLong1, long paramLong2)
  {
    Object localObject1 = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, AIOUtils.a(paramLong1, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter())));
    if ((localObject1 instanceof BaseBubbleBuilder.ViewHolder)) {}
    for (localObject1 = (BaseBubbleBuilder.ViewHolder)localObject1;; localObject1 = null)
    {
      Object localObject2 = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, AIOUtils.a(paramLong2, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter())));
      if ((localObject2 instanceof BaseBubbleBuilder.ViewHolder)) {}
      for (localObject2 = (BaseBubbleBuilder.ViewHolder)localObject2;; localObject2 = null)
      {
        if ((localObject1 == null) || (localObject2 == null) || (((BaseBubbleBuilder.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo == null) || (((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo == null)) {}
        BubbleConfig localBubbleConfig;
        do
        {
          return null;
          i = ((BaseBubbleBuilder.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Int;
          int j = ((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Int;
          localBubbleConfig = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(i, false);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(j, false);
        } while ((localBubbleConfig == null) || (localObject3 == null) || (localBubbleConfig.b == null) || (((BubbleConfig)localObject3).b == null));
        BubbleNewAnimConf localBubbleNewAnimConf1 = (BubbleNewAnimConf)localBubbleConfig.b.get("animation_start");
        BubbleNewAnimConf localBubbleNewAnimConf2 = (BubbleNewAnimConf)((BubbleConfig)localObject3).b.get("passive_animation");
        if (localBubbleNewAnimConf1 == null)
        {
          QLog.e("BubbleInterActiveAnim", 1, "can't find mInterActiveAnims from bubbleId: " + i);
          return null;
        }
        Object localObject3 = new BubbleInterActiveAnim.AnimHolder();
        ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((BaseBubbleBuilder.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_b_of_type_ComTencentMobileqqDataMessageRecord = ((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_JavaUtilHashMap = new HashMap(localBubbleConfig.b);
        ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_JavaUtilHashMap.put("passive_animation", localBubbleNewAnimConf2);
        ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
        ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView.layout(0, 0, localBubbleNewAnimConf1.jdField_a_of_type_AndroidGraphicsRect.right, localBubbleNewAnimConf1.jdField_a_of_type_AndroidGraphicsRect.bottom);
        ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_AndroidGraphicsRect = a((BaseBubbleBuilder.ViewHolder)localObject1, paramLong1, this.jdField_a_of_type_ComTencentWidgetListView);
        ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_b_of_type_AndroidGraphicsRect = a((BaseBubbleBuilder.ViewHolder)localObject2, paramLong2, this.jdField_a_of_type_ComTencentWidgetListView);
        localObject2 = (View)((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.getParent();
        int i = ((View)((BaseBubbleBuilder.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView.getParent()).getTop() - ((View)localObject2).getTop();
        localObject2 = ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_b_of_type_AndroidGraphicsRect;
        ((Rect)localObject2).top -= i;
        localObject2 = ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_b_of_type_AndroidGraphicsRect;
        ((Rect)localObject2).bottom -= i;
        ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_AndroidViewView = ((BaseBubbleBuilder.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localObject3);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView);
        ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_a_of_type_Long = paramLong1;
        ((BubbleInterActiveAnim.AnimHolder)localObject3).jdField_b_of_type_Long = paramLong2;
        return localObject3;
      }
    }
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      BubbleInterActiveAnim.AnimHolder localAnimHolder = (BubbleInterActiveAnim.AnimHolder)localIterator.next();
      if ((localAnimHolder != null) && (localAnimHolder.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "add delta " + paramInt + " for seq: " + localAnimHolder.jdField_a_of_type_Long);
        }
        localAnimHolder.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(localAnimHolder.jdField_a_of_type_AndroidWidgetImageView.getTranslationY() + paramInt);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ThreadManager.post(new ablb(this, paramLong1, paramLong2), 5, null, true);
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
    if (paramInt < paramBubbleNewAnimConf.jdField_b_of_type_Int)
    {
      Object localObject1 = localFile.getAbsolutePath() + File.separatorChar + paramBubbleNewAnimConf.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(paramInt + 1) });
      String str = paramBubbleNewAnimConf.jdField_a_of_type_JavaLangString + (String)localObject1;
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
      {
        Object localObject3 = BaseApplicationImpl.sImageCache.get(str);
        if ((localObject3 != null) && ((localObject3 instanceof Bitmap))) {
          localObject1 = (Bitmap)localObject3;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          BaseApplicationImpl.sImageCache.put(str, localObject1);
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject1);
        }
        paramInt += 1;
        break;
        try
        {
          localObject1 = BubbleManager.a((String)localObject1, null);
        }
        catch (Exception localException)
        {
          QLog.e("BubbleNewAIOAnim", 1, "decode error!", localException);
          Object localObject2 = null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          QLog.e("BubbleNewAIOAnim", 1, "decode error!", localOutOfMemoryError);
          localBitmap = null;
        }
        continue;
        Bitmap localBitmap = (Bitmap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
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
        Object localObject2 = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, paramInt1));
        Object localObject1 = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, paramInt2));
        if ((localObject2 != null) && ((localObject2 instanceof BaseBubbleBuilder.ViewHolder)))
        {
          localObject2 = (BaseBubbleBuilder.ViewHolder)localObject2;
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "refresh seq " + localAnimHolder.jdField_a_of_type_Long + " 's bubbleView");
          }
          localAnimHolder.jdField_a_of_type_AndroidViewView = ((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView;
          localAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        }
        for (;;)
        {
          if ((localObject1 == null) || (!(localObject1 instanceof BaseBubbleBuilder.ViewHolder))) {
            break label311;
          }
          localObject1 = (BaseBubbleBuilder.ViewHolder)localObject1;
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "refresh seq " + localAnimHolder.jdField_b_of_type_Long + " 's bubbleView");
          }
          localAnimHolder.jdField_b_of_type_ComTencentMobileqqDataMessageRecord = ((BaseBubbleBuilder.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          break;
          if (QLog.isColorLevel()) {
            QLog.w("BubbleInterActiveAnim", 2, "stop current bubble animation! " + localAnimHolder.jdField_a_of_type_Long);
          }
          localAnimHolder.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
        }
        label311:
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "stop current bubble animation! " + localAnimHolder.jdField_b_of_type_Long);
        }
        localAnimHolder.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
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
    }
    else {
      return false;
    }
    long l1 = ((Long)paramVarArgs[1]).longValue();
    int i;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getAdapter() != null) && (l1 > 0L))
    {
      ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
      i = localListAdapter.getCount() - 1;
      if (i < 0) {
        break label285;
      }
      localObject = localListAdapter.getItem(i);
      if ((localObject instanceof ChatMessage))
      {
        localObject = (ChatMessage)localObject;
        if (((ChatMessage)localObject).uniseq != l1) {}
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = EmojiStickerManager.a().a((MessageRecord)localObject);
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, " contain sticker ,so stop bubble animation!");
          }
          return false;
          i -= 1;
          break;
        }
      }
      long l2 = ((Long)paramVarArgs[2]).longValue();
      if (QLog.isColorLevel()) {
        QLog.d("BubbleInterActiveAnim", 1, "start InterActive Anim, originalSeq：" + l1 + ", targetSeq: " + l2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager == null)
      {
        paramVarArgs = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramVarArgs instanceof QQAppInterface)) {}
        for (paramVarArgs = (QQAppInterface)paramVarArgs; paramVarArgs == null; paramVarArgs = null) {
          return false;
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager = ((BubbleManager)paramVarArgs.getManager(43));
      }
      a(l1, l2);
      return true;
      label285:
      localObject = null;
    }
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
    if (((BubbleNewAnimConf.InterActiveAnimConf)localObject2).jdField_e_of_type_Int == 0) {}
    for (localObject1 = a(paramAnimHolder, (BubbleNewAnimConf.InterActiveAnimConf)localObject2);; localObject1 = b(paramAnimHolder, (BubbleNewAnimConf.InterActiveAnimConf)localObject2))
    {
      localObject2 = a(paramAnimHolder, paramAnimHolder.jdField_a_of_type_AndroidGraphicsRect, (BubbleNewAnimConf.InterActiveAnimConf)localObject2);
      if ((localObject1 != null) && (localObject2 != null)) {
        break;
      }
      return null;
    }
    ((ObjectAnimator)localObject2).setDuration(((ObjectAnimator)localObject2).getDuration() / 2L);
    ((ObjectAnimator)localObject2).setRepeatCount(-1);
    ((ObjectAnimator)localObject1).addListener(new ablf(this, paramAnimHolder, (ObjectAnimator)localObject2));
    return localObject1;
  }
  
  public ObjectAnimator b(BubbleInterActiveAnim.AnimHolder paramAnimHolder, BubbleNewAnimConf.InterActiveAnimConf paramInterActiveAnimConf)
  {
    float f4 = 0.0F;
    Object localObject1;
    if ((!TextUtils.isEmpty(paramInterActiveAnimConf.jdField_e_of_type_JavaLangString)) && (paramInterActiveAnimConf.jdField_c_of_type_AndroidGraphicsRect != null))
    {
      localObject1 = a(paramAnimHolder.jdField_a_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.jdField_c_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.jdField_e_of_type_JavaLangString, paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      if ((TextUtils.isEmpty(paramInterActiveAnimConf.f)) || (paramInterActiveAnimConf.jdField_d_of_type_AndroidGraphicsRect == null)) {
        break label153;
      }
    }
    for (Object localObject2 = a(paramAnimHolder.jdField_b_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.jdField_d_of_type_AndroidGraphicsRect, paramInterActiveAnimConf.f, paramAnimHolder.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());; localObject2 = null)
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        break label207;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "start align: " + paramInterActiveAnimConf.jdField_e_of_type_JavaLangString + ", startRect: " + paramInterActiveAnimConf.jdField_c_of_type_AndroidGraphicsRect);
      }
      localObject1 = null;
      break;
      label153:
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "end align " + paramInterActiveAnimConf.f + ", endRect: " + paramInterActiveAnimConf.jdField_d_of_type_AndroidGraphicsRect);
      }
    }
    label207:
    int j = ((Integer)((Pair)localObject1).first).intValue();
    int k = ((Integer)((Pair)localObject1).second).intValue();
    int m = ((Integer)((Pair)localObject2).first).intValue();
    int n = ((Integer)((Pair)localObject2).second).intValue();
    float f1;
    float f2;
    float f3;
    if (paramInterActiveAnimConf.jdField_e_of_type_Int == 1)
    {
      f1 = (m - j) * 0.25F + j;
      f2 = (n - k) * 0.1F + k;
      f3 = (m - j) * 0.25F + j;
      f4 = (n - k) * 1.0F + k;
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(PathPoint.b(j, k));
      ((ArrayList)localObject1).add(PathPoint.a(f1, f2, f3, f4, m, n));
      localObject2 = new BubbleInterActiveAnim.AnimFrameData[((ArrayList)localObject1).size()];
      int i = 0;
      label387:
      if (i < localObject2.length)
      {
        BubbleInterActiveAnim.AnimFrameData localAnimFrameData = new BubbleInterActiveAnim.AnimFrameData();
        localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder = paramAnimHolder;
        localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint = ((PathPoint)((ArrayList)localObject1).get(i));
        if (paramInterActiveAnimConf.jdField_a_of_type_Boolean) {
          if (paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
            break label573;
          }
        }
        label573:
        for (boolean bool = true;; bool = false)
        {
          localAnimFrameData.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
          localAnimFrameData.jdField_a_of_type_Boolean = paramAnimHolder.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
          localAnimFrameData.jdField_a_of_type_AndroidGraphicsRect = paramInterActiveAnimConf.jdField_a_of_type_AndroidGraphicsRect;
          localAnimFrameData.jdField_b_of_type_Boolean = paramInterActiveAnimConf.jdField_b_of_type_Boolean;
          localObject2[i] = localAnimFrameData;
          i += 1;
          break label387;
          if (paramInterActiveAnimConf.jdField_e_of_type_Int != 2) {
            break label645;
          }
          f1 = (m - j) * 0.1F + j;
          f2 = (n - k) * 0.25F + k;
          f3 = (m - j) * 1.0F + j;
          f4 = (n - k) * 0.25F + k;
          break;
        }
      }
      paramAnimHolder = ObjectAnimator.ofObject(this, "pathLocation", new BubbleInterActiveAnim.PathEvaluator(), (Object[])localObject2);
      paramAnimHolder.setDuration(((Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.c * (float)paramInterActiveAnimConf.jdField_a_of_type_Long * 3.141592653589793D * 0.6000000238418579D));
      return paramAnimHolder;
      label645:
      f3 = 0.0F;
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    BubbleInterActiveAnim.AnimHolder localAnimHolder = a(paramLong1, paramLong2);
    ObjectAnimator localObjectAnimator1;
    if (localAnimHolder != null)
    {
      localObjectAnimator1 = a(localAnimHolder);
      if (localObjectAnimator1 == null) {
        QLog.e("BubbleInterActiveAnim", 1, "startAnimator is null");
      }
    }
    else
    {
      return;
    }
    ObjectAnimator localObjectAnimator2 = b(localAnimHolder);
    if (localObjectAnimator2 == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "runningAnimator is null");
      return;
    }
    Object localObject = (BubbleNewAnimConf.InterActiveAnimConf)localAnimHolder.jdField_a_of_type_JavaUtilHashMap.get("animation_end");
    ObjectAnimator localObjectAnimator3 = a(localAnimHolder, localAnimHolder.jdField_b_of_type_AndroidGraphicsRect, (BubbleNewAnimConf.InterActiveAnimConf)localObject);
    if (localObjectAnimator3 == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "endAnimator is null");
      return;
    }
    localObjectAnimator3.setRepeatCount(((BubbleNewAnimConf.InterActiveAnimConf)localObject).jdField_a_of_type_Int - 1);
    localObject = c(localAnimHolder);
    if (localObject == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
      return;
    }
    localAnimHolder.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObject });
    localAnimHolder.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new ablc(this, localAnimHolder));
    this.jdField_a_of_type_AndroidOsHandler.post(new abld(this, localAnimHolder));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localAnimHolder);
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
    localObjectAnimator.addListener(new ablg(this, paramAnimHolder));
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
  
  public void setBitmapData(BubbleInterActiveAnim.AnimFrameData paramAnimFrameData)
  {
    if ((paramAnimFrameData == null) || (paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder == null)) {}
    do
    {
      do
      {
        return;
        if ((paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint != null) && (paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Int == -1)) {
          setPathLocation(paramAnimFrameData);
        }
        float f = paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.getTranslationY();
        if ((f < this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()) || (f > this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int))
        {
          QLog.w("BubbleInterActiveAnim", 1, String.format("setBitmapData: now scroll over screen, stop bubble animator set!, y: %d, up: %d, download: %d", new Object[] { Integer.valueOf((int)f), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int) }));
          this.jdField_a_of_type_AndroidOsHandler.post(new ablh(this, paramAnimFrameData));
          return;
        }
      } while (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramAnimFrameData.jdField_a_of_type_JavaLangString));
      if (paramAnimFrameData.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        localObject = new abkv(paramAnimFrameData.jdField_a_of_type_AndroidGraphicsBitmap);
        ((abkv)localObject).jdField_a_of_type_Boolean = paramAnimFrameData.jdField_a_of_type_JavaLangBoolean.booleanValue();
        paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
        this.jdField_a_of_type_JavaLangString = paramAnimFrameData.jdField_a_of_type_JavaLangString;
        paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.invalidate();
        return;
      }
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramAnimFrameData.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = (Bitmap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramAnimFrameData.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    Object localObject = new abkv((Bitmap)localObject);
    ((abkv)localObject).jdField_a_of_type_Boolean = paramAnimFrameData.jdField_a_of_type_JavaLangBoolean.booleanValue();
    paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_JavaLangString = paramAnimFrameData.jdField_a_of_type_JavaLangString;
    paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.invalidate();
    return;
    QLog.e("BubbleInterActiveAnim", 1, "can't find bitmap, path: " + paramAnimFrameData.jdField_a_of_type_JavaLangString);
  }
  
  public void setPathLocation(BubbleInterActiveAnim.AnimFrameData paramAnimFrameData)
  {
    if ((paramAnimFrameData == null) || (paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder == null) || (paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    if ((paramAnimFrameData.jdField_a_of_type_AndroidGraphicsRect != null) && (paramAnimFrameData.jdField_a_of_type_AndroidGraphicsRect.right != 0) && (paramAnimFrameData.jdField_a_of_type_AndroidGraphicsRect.bottom != 0) && ((paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.getWidth() != paramAnimFrameData.jdField_a_of_type_AndroidGraphicsRect.right) || (paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.getHeight() != paramAnimFrameData.jdField_a_of_type_AndroidGraphicsRect.bottom)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "change anim view size:  to " + paramAnimFrameData.jdField_a_of_type_AndroidGraphicsRect.right + "-" + paramAnimFrameData.jdField_a_of_type_AndroidGraphicsRect.bottom + ", view width-height: " + paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.getWidth() + "-" + paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.getHeight());
      }
      paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.layout(0, 0, paramAnimFrameData.jdField_a_of_type_AndroidGraphicsRect.right, paramAnimFrameData.jdField_a_of_type_AndroidGraphicsRect.bottom);
    }
    if (paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Int != -1)
    {
      if (paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.c != 360.0F) {
        break label456;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "reset animView rotate to 0!");
      }
      paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.setRotation(0.0F);
    }
    int i;
    int j;
    float f1;
    float f3;
    float f2;
    for (;;)
    {
      localObject = (View)paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidViewView.getParent();
      i = 0;
      j = 0;
      if ((localObject != null) && (((View)localObject).getParent() != this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getParent())) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
      f1 = paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Float;
      f3 = paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b;
      float f4 = this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
      f2 = i;
      f3 = j + (f3 - f4);
      if ((f3 >= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()) && (f3 <= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int)) {
        break label585;
      }
      QLog.w("BubbleInterActiveAnim", 1, String.format("setPathLocation: now scroll over screen, stop bubble animator set!, y: %d, up: %d, down: %d", new Object[] { Integer.valueOf((int)f3), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int) }));
      this.jdField_a_of_type_AndroidOsHandler.post(new abli(this, paramAnimFrameData));
      return;
      label456:
      if (paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.c != 0.0F)
      {
        paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.setRotation(paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.c);
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "set animView rotate to " + paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.c);
        }
      }
    }
    int k = ((View)localObject).getLeft();
    int m = ((View)localObject).getTop();
    Object localObject = ((View)localObject).getParent();
    if ((localObject instanceof View)) {}
    for (localObject = (View)localObject;; localObject = null)
    {
      j = m + j;
      i = k + i;
      break;
    }
    label585:
    paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(f2 + f1);
    paramAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(f3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim
 * JD-Core Version:    0.7.0.1
 */