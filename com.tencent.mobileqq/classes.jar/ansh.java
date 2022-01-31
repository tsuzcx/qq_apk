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
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim.2;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim.4;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim.8;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim.9;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(11)
public class ansh
  extends aepy
{
  public Handler a;
  public BubbleManager a;
  public String a;
  public List<View> a;
  public ConcurrentHashMap<Long, anso> a;
  public int b;
  public List<AnimatorSet> b;
  public ConcurrentHashMap<String, Bitmap> b;
  public int c;
  public int d;
  
  public ansh(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidOsHandler = new ansi(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = aekt.a(12.0F, paramListView.getContext().getResources());
    this.c = aekt.a(50.0F, paramListView.getContext().getResources());
    this.jdField_d_of_type_Int = aekt.a(45.0F, paramListView.getContext().getResources());
  }
  
  public static long a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {}
    for (String str = a(paramMessageRecord);; str = null)
    {
      BubbleManager localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(44);
      ansc localansc = localBubbleManager.a((int)paramMessageRecord.vipBubbleID, false);
      long l3;
      if ((localansc == null) || (localansc.b == null))
      {
        l3 = -1L;
        return l3;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "bubble config mInterActivePackageID: " + localansc.f + ", bubble mInterActiveType: " + localansc.g);
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
        if (paramAIOAnimationConatiner.a() == null) {
          break label1028;
        }
        l1 = l4;
        l3 = l2;
        if (paramAIOAnimationConatiner.a().getAdapter() == null) {
          break label1028;
        }
        ListAdapter localListAdapter = paramAIOAnimationConatiner.a().getAdapter();
        int n = paramAIOAnimationConatiner.a().getFirstVisiblePosition();
        int k = paramAIOAnimationConatiner.a().getLastVisiblePosition();
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
        paramQQAppInterface = aekt.a(aekt.a(paramAIOAnimationConatiner.a(), k));
        if ((paramQQAppInterface instanceof aelt))
        {
          paramQQAppInterface = (aelt)paramQQAppInterface;
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
          if (paramQQAppInterface.jdField_a_of_type_Ansf == null) {
            break label1006;
          }
          paramQQAppInterface = a((MessageRecord)localObject1);
          localObject2 = localBubbleManager.a((int)((ChatMessage)localObject1).vipBubbleID, false);
          if ((localObject2 != null) && (((ansc)localObject2).b != null)) {
            break label423;
          }
          QLog.e("BubbleInterActiveAnim", 1, "get bubbleConfig is null: " + (int)((ChatMessage)localObject1).vipBubbleID);
        }
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "record seq: " + ((ChatMessage)localObject1).uniseq + ", other bubble config mInterActivePackageID: " + ((ansc)localObject2).f + ", other bubble config mInterActiveType: " + ((ansc)localObject2).g);
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
          if (localansc.f == -1) {
            break label497;
          }
          i = m;
          if (((ansc)localObject2).f == -1) {
            break label497;
          }
          if (localansc.g == 3)
          {
            if ((((ansc)localObject2).g == 2) && (((ansc)localObject2).f != localansc.f))
            {
              i = 1;
              break label497;
            }
            i = m;
            if (((ansc)localObject2).g != 3) {
              break label497;
            }
            i = 1;
            break label497;
          }
          if (localansc.g == 1)
          {
            if ((localansc.f == ((ansc)localObject2).f) && (localansc.g == ((ansc)localObject2).g))
            {
              i = 1;
              break label497;
            }
            i = 0;
            break label497;
          }
          i = m;
          if (localansc.g != 2) {
            break label497;
          }
          if (((ansc)localObject2).g != 2)
          {
            i = m;
            if (((ansc)localObject2).g != 3) {
              break label497;
            }
          }
          if (((ansc)localObject2).f != localansc.f)
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
    ListAdapter localListAdapter = paramAIOAnimationConatiner.a().getAdapter();
    int j;
    int i;
    if (paramAIOAnimationConatiner.a().getChildCount() > 0) {
      if ((localListAdapter instanceof bhtf))
      {
        j = paramAIOAnimationConatiner.a().getFirstVisiblePosition();
        i = paramAIOAnimationConatiner.a().getLastVisiblePosition();
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
        if (!(localListAdapter instanceof aelz)) {
          break label185;
        }
        j = paramAIOAnimationConatiner.a().getFirstVisiblePosition() - paramAIOAnimationConatiner.a().getHeaderViewsCount();
        i = paramAIOAnimationConatiner.a().getLastVisiblePosition() - paramAIOAnimationConatiner.a().getFooterViewsCount();
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
  
  public ObjectAnimator a(anso paramanso)
  {
    antc localantc = (antc)paramanso.jdField_a_of_type_JavaUtilHashMap.get("animation_start");
    ObjectAnimator localObjectAnimator = a(paramanso, paramanso.jdField_a_of_type_AndroidGraphicsRect, localantc);
    localObjectAnimator.setRepeatCount(localantc.jdField_a_of_type_Int - 1);
    Object localObject1;
    long l;
    if (((antc)paramanso.jdField_a_of_type_JavaUtilHashMap.get("animation_running")).jdField_b_of_type_Boolean)
    {
      Object localObject2 = (antc)paramanso.jdField_a_of_type_JavaUtilHashMap.get("animation_end");
      localObject1 = a(paramanso.jdField_a_of_type_AndroidGraphicsRect, localantc.jdField_a_of_type_AndroidGraphicsRect, localantc.jdField_c_of_type_JavaLangString, paramanso.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      localObject2 = a(paramanso.jdField_b_of_type_AndroidGraphicsRect, ((antc)localObject2).jdField_a_of_type_AndroidGraphicsRect, ((antc)localObject2).jdField_c_of_type_JavaLangString, paramanso.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());
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
          if (!paramanso.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
            f1 = -f2;
          }
        }
      }
      localObject1 = ObjectAnimator.ofFloat(paramanso.jdField_a_of_type_AndroidWidgetImageView, "rotation", new float[] { 0.0F, f1 });
      i = localantc.jdField_a_of_type_Int - 1;
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
      localObjectAnimator.addListener(new ansk(this, (ObjectAnimator)localObject1, paramanso));
      return localObjectAnimator;
      l = localObjectAnimator.getDuration();
      break;
      localObject1 = null;
    }
  }
  
  public ObjectAnimator a(anso paramanso, Rect paramRect, antc paramantc)
  {
    File localFile = null;
    if (paramantc == null) {
      return null;
    }
    Object localObject = localFile;
    boolean bool;
    if (paramRect != null)
    {
      localObject = localFile;
      if (paramantc.jdField_e_of_type_Int == -1)
      {
        if (paramRect != paramanso.jdField_a_of_type_AndroidGraphicsRect) {
          break label326;
        }
        bool = paramanso.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        paramRect = a(paramRect, paramantc.jdField_a_of_type_AndroidGraphicsRect, paramantc.jdField_c_of_type_JavaLangString, bool);
        localObject = new antr(-1, ((Integer)paramRect.first).intValue(), ((Integer)paramRect.second).intValue());
      }
    }
    localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramantc.jdField_d_of_type_Int, false), paramantc.jdField_d_of_type_JavaLangString);
    paramRect = new ArrayList();
    int i = 0;
    label130:
    if (i < paramantc.jdField_b_of_type_Int)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramantc.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
      ansn localansn = new ansn();
      localansn.jdField_b_of_type_JavaLangString = str;
      localansn.jdField_a_of_type_JavaLangString = (paramantc.jdField_a_of_type_JavaLangString + str);
      localansn.jdField_a_of_type_Anso = paramanso;
      localansn.jdField_a_of_type_AndroidGraphicsRect = paramantc.jdField_a_of_type_AndroidGraphicsRect;
      if (paramantc.jdField_a_of_type_Boolean) {
        if (paramanso.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
          break label338;
        }
      }
      label326:
      label338:
      for (bool = true;; bool = false)
      {
        localansn.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localansn.jdField_a_of_type_Boolean = paramanso.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        if (paramantc.jdField_e_of_type_Int == -1) {
          localansn.jdField_a_of_type_Antr = ((antr)localObject);
        }
        paramRect.add(localansn);
        i += 1;
        break label130;
        bool = paramanso.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        break;
      }
    }
    paramanso = new Keyframe[paramRect.size() + 1];
    float f = 1.0F / paramRect.size();
    paramanso[0] = Keyframe.ofObject(0.0F, paramRect.get(0));
    i = 0;
    if (i < paramRect.size())
    {
      if (i != paramRect.size() - 1) {
        paramanso[(i + 1)] = Keyframe.ofObject((i + 1) * f, paramRect.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        paramanso[(i + 1)] = Keyframe.ofObject(1.0F, paramRect.get(i));
      }
    }
    paramanso = PropertyValuesHolder.ofKeyframe("bitmapData", paramanso);
    paramanso.setEvaluator(new ansp(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { paramanso }).setDuration(paramRect.size() * paramantc.jdField_a_of_type_Long);
  }
  
  public ObjectAnimator a(anso paramanso, antc paramantc)
  {
    if ((!TextUtils.isEmpty(paramantc.jdField_e_of_type_JavaLangString)) && (paramantc.jdField_c_of_type_AndroidGraphicsRect != null))
    {
      localObject1 = a(paramanso.jdField_a_of_type_AndroidGraphicsRect, paramantc.jdField_c_of_type_AndroidGraphicsRect, paramantc.jdField_e_of_type_JavaLangString, paramanso.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      if ((TextUtils.isEmpty(paramantc.f)) || (paramantc.jdField_d_of_type_AndroidGraphicsRect == null)) {
        break label150;
      }
    }
    for (Object localObject2 = a(paramanso.jdField_b_of_type_AndroidGraphicsRect, paramantc.jdField_d_of_type_AndroidGraphicsRect, paramantc.f, paramanso.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());; localObject2 = null)
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        break label204;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "start align: " + paramantc.jdField_e_of_type_JavaLangString + ", startRect: " + paramantc.jdField_c_of_type_AndroidGraphicsRect);
      }
      localObject1 = null;
      break;
      label150:
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "end align " + paramantc.f + ", endRect: " + paramantc.jdField_d_of_type_AndroidGraphicsRect);
      }
    }
    label204:
    int j = ((Integer)((Pair)localObject1).first).intValue();
    int k = ((Integer)((Pair)localObject1).second).intValue();
    int m = ((Integer)((Pair)localObject2).first).intValue();
    int n = ((Integer)((Pair)localObject2).second).intValue();
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(antr.b(j, k));
    ((ArrayList)localObject1).add(antr.a(m, n));
    localObject2 = new ansq();
    ansn[] arrayOfansn = new ansn[((ArrayList)localObject1).size()];
    int i = 0;
    if (i < arrayOfansn.length)
    {
      ansn localansn = new ansn();
      localansn.jdField_a_of_type_Anso = paramanso;
      localansn.jdField_a_of_type_Antr = ((antr)((ArrayList)localObject1).get(i));
      if (paramantc.jdField_a_of_type_Boolean) {
        if (paramanso.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
          break label425;
        }
      }
      label425:
      for (boolean bool = true;; bool = false)
      {
        localansn.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localansn.jdField_a_of_type_Boolean = paramanso.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        localansn.jdField_b_of_type_Boolean = paramantc.jdField_b_of_type_Boolean;
        localansn.jdField_a_of_type_AndroidGraphicsRect = paramantc.jdField_a_of_type_AndroidGraphicsRect;
        arrayOfansn[i] = localansn;
        i += 1;
        break;
      }
    }
    paramanso = ObjectAnimator.ofObject(this, "pathLocation", (TypeEvaluator)localObject2, arrayOfansn);
    paramanso.setDuration(((Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.c * (float)paramantc.jdField_a_of_type_Long));
    return paramanso;
  }
  
  public Rect a(aelt paramaelt, long paramLong, ListView paramListView)
  {
    int i = paramaelt.jdField_a_of_type_Ansf.jdField_a_of_type_Int;
    paramListView = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(i, false);
    if (paramListView == null) {
      return null;
    }
    if ((antb)paramListView.b.get("animation_start") == null)
    {
      paramListView = paramListView.b.values().iterator();
      while ((paramListView.hasNext()) && ((antb)paramListView.next() == null)) {}
    }
    paramListView = paramaelt.jdField_a_of_type_AndroidViewView;
    int j = paramListView.getLeft();
    i = paramListView.getTop();
    paramaelt = (View)paramListView.getParent();
    for (;;)
    {
      if ((paramaelt == null) || ((paramaelt instanceof BaseChatItemLayout)))
      {
        paramaelt = new Rect();
        paramaelt.left = (BaseChatItemLayout.i + j);
        paramaelt.right = (paramListView.getRight() - paramListView.getLeft() + j - BaseChatItemLayout.i);
        paramaelt.top = (BaseChatItemLayout.g + i);
        paramaelt.bottom = (paramListView.getBottom() - paramListView.getTop() + i - BaseChatItemLayout.h);
        return paramaelt;
      }
      j += paramaelt.getLeft();
      i += paramaelt.getTop();
      paramaelt = paramaelt.getParent();
      if ((paramaelt instanceof View)) {
        paramaelt = (View)paramaelt;
      } else {
        paramaelt = null;
      }
    }
  }
  
  public Pair<Integer, Integer> a(Rect paramRect1, Rect paramRect2, String paramString, boolean paramBoolean)
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
  
  public anso a(long paramLong1, long paramLong2)
  {
    Object localObject1 = aekt.a(aekt.a(this.jdField_a_of_type_ComTencentWidgetListView, aekt.a(paramLong1, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter())));
    if ((localObject1 instanceof aelt)) {}
    for (localObject1 = (aelt)localObject1;; localObject1 = null)
    {
      Object localObject2 = aekt.a(aekt.a(this.jdField_a_of_type_ComTencentWidgetListView, aekt.a(paramLong2, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter())));
      if ((localObject2 instanceof aelt)) {}
      for (localObject2 = (aelt)localObject2;; localObject2 = null)
      {
        if ((localObject1 == null) || (localObject2 == null) || (((aelt)localObject1).jdField_a_of_type_Ansf == null) || (((aelt)localObject2).jdField_a_of_type_Ansf == null)) {}
        ansc localansc;
        do
        {
          return null;
          i = ((aelt)localObject1).jdField_a_of_type_Ansf.jdField_a_of_type_Int;
          int j = ((aelt)localObject2).jdField_a_of_type_Ansf.jdField_a_of_type_Int;
          localansc = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(i, false);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(j, false);
        } while ((localansc == null) || (localObject3 == null) || (localansc.b == null) || (((ansc)localObject3).b == null));
        antb localantb1 = (antb)localansc.b.get("animation_start");
        antb localantb2 = (antb)((ansc)localObject3).b.get("passive_animation");
        if (localantb1 == null)
        {
          QLog.e("BubbleInterActiveAnim", 1, "can't find mInterActiveAnims from bubbleId: " + i);
          return null;
        }
        Object localObject3 = new anso();
        ((anso)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((aelt)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        ((anso)localObject3).jdField_b_of_type_ComTencentMobileqqDataMessageRecord = ((aelt)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        ((anso)localObject3).jdField_a_of_type_JavaUtilHashMap = new HashMap(localansc.b);
        ((anso)localObject3).jdField_a_of_type_JavaUtilHashMap.put("passive_animation", localantb2);
        ((anso)localObject3).jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
        ((anso)localObject3).jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ((anso)localObject3).jdField_a_of_type_AndroidWidgetImageView.layout(0, 0, localantb1.jdField_a_of_type_AndroidGraphicsRect.right, localantb1.jdField_a_of_type_AndroidGraphicsRect.bottom);
        ((anso)localObject3).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        ((anso)localObject3).jdField_a_of_type_AndroidGraphicsRect = a((aelt)localObject1, paramLong1, this.jdField_a_of_type_ComTencentWidgetListView);
        ((anso)localObject3).jdField_b_of_type_AndroidGraphicsRect = a((aelt)localObject2, paramLong2, this.jdField_a_of_type_ComTencentWidgetListView);
        localObject2 = (View)((aelt)localObject2).jdField_a_of_type_AndroidViewView.getParent();
        int i = ((View)((aelt)localObject1).jdField_a_of_type_AndroidViewView.getParent()).getTop() - ((View)localObject2).getTop();
        localObject2 = ((anso)localObject3).jdField_b_of_type_AndroidGraphicsRect;
        ((Rect)localObject2).top -= i;
        localObject2 = ((anso)localObject3).jdField_b_of_type_AndroidGraphicsRect;
        ((Rect)localObject2).bottom -= i;
        ((anso)localObject3).jdField_a_of_type_AndroidViewView = ((aelt)localObject1).jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localObject3);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(((anso)localObject3).jdField_a_of_type_AndroidWidgetImageView);
        ((anso)localObject3).jdField_a_of_type_Long = paramLong1;
        ((anso)localObject3).jdField_b_of_type_Long = paramLong2;
        return localObject3;
      }
    }
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      anso localanso = (anso)localIterator.next();
      if ((localanso != null) && (localanso.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "add delta " + paramInt + " for seq: " + localanso.jdField_a_of_type_Long);
        }
        localanso.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(localanso.jdField_a_of_type_AndroidWidgetImageView.getTranslationY() + paramInt);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ThreadManager.post(new BubbleInterActiveAnim.2(this, paramLong1, paramLong2), 5, null, true);
  }
  
  public void a(anso paramanso)
  {
    paramanso.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeView(paramanso.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramanso.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
      d();
    }
  }
  
  public void a(antb paramantb, int paramInt)
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramInt, false), paramantb.jdField_d_of_type_JavaLangString);
    paramInt = 0;
    if (paramInt < paramantb.jdField_b_of_type_Int)
    {
      Object localObject1 = localFile.getAbsolutePath() + File.separatorChar + paramantb.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(paramInt + 1) });
      String str = paramantb.jdField_a_of_type_JavaLangString + (String)localObject1;
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
      anso localanso = (anso)localIterator.next();
      if ((localanso != null) && (localanso.jdField_a_of_type_AndroidViewView != null))
      {
        paramInt1 = aekt.a(localanso.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
        paramInt2 = aekt.a(localanso.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
        Object localObject2 = aekt.a(aekt.a(this.jdField_a_of_type_ComTencentWidgetListView, paramInt1));
        Object localObject1 = aekt.a(aekt.a(this.jdField_a_of_type_ComTencentWidgetListView, paramInt2));
        if ((localObject2 != null) && ((localObject2 instanceof aelt)))
        {
          localObject2 = (aelt)localObject2;
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "refresh seq " + localanso.jdField_a_of_type_Long + " 's bubbleView");
          }
          localanso.jdField_a_of_type_AndroidViewView = ((aelt)localObject2).jdField_a_of_type_AndroidViewView;
          localanso.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((aelt)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        }
        for (;;)
        {
          if ((localObject1 == null) || (!(localObject1 instanceof aelt))) {
            break label311;
          }
          localObject1 = (aelt)localObject1;
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "refresh seq " + localanso.jdField_b_of_type_Long + " 's bubbleView");
          }
          localanso.jdField_b_of_type_ComTencentMobileqqDataMessageRecord = ((aelt)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          break;
          if (QLog.isColorLevel()) {
            QLog.w("BubbleInterActiveAnim", 2, "stop current bubble animation! " + localanso.jdField_a_of_type_Long);
          }
          localanso.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
        }
        label311:
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "stop current bubble animation! " + localanso.jdField_b_of_type_Long);
        }
        localanso.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
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
        this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager = ((BubbleManager)paramVarArgs.getManager(44));
      }
      a(l1, l2);
      return true;
      label285:
      localObject = null;
    }
  }
  
  public ObjectAnimator b(anso paramanso)
  {
    Object localObject1 = (antb)paramanso.jdField_a_of_type_JavaUtilHashMap.get("animation_running");
    if (!(localObject1 instanceof antc)) {
      return null;
    }
    Object localObject2 = (antc)localObject1;
    if (((antc)localObject2).jdField_e_of_type_Int == -1) {
      return null;
    }
    if (((antc)localObject2).jdField_e_of_type_Int == 0) {}
    for (localObject1 = a(paramanso, (antc)localObject2);; localObject1 = b(paramanso, (antc)localObject2))
    {
      localObject2 = a(paramanso, paramanso.jdField_a_of_type_AndroidGraphicsRect, (antc)localObject2);
      if ((localObject1 != null) && (localObject2 != null)) {
        break;
      }
      return null;
    }
    ((ObjectAnimator)localObject2).setDuration(((ObjectAnimator)localObject2).getDuration() / 2L);
    ((ObjectAnimator)localObject2).setRepeatCount(-1);
    ((ObjectAnimator)localObject1).addListener(new ansl(this, paramanso, (ObjectAnimator)localObject2));
    return localObject1;
  }
  
  public ObjectAnimator b(anso paramanso, antc paramantc)
  {
    float f4 = 0.0F;
    Object localObject1;
    if ((!TextUtils.isEmpty(paramantc.jdField_e_of_type_JavaLangString)) && (paramantc.jdField_c_of_type_AndroidGraphicsRect != null))
    {
      localObject1 = a(paramanso.jdField_a_of_type_AndroidGraphicsRect, paramantc.jdField_c_of_type_AndroidGraphicsRect, paramantc.jdField_e_of_type_JavaLangString, paramanso.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      if ((TextUtils.isEmpty(paramantc.f)) || (paramantc.jdField_d_of_type_AndroidGraphicsRect == null)) {
        break label153;
      }
    }
    for (Object localObject2 = a(paramanso.jdField_b_of_type_AndroidGraphicsRect, paramantc.jdField_d_of_type_AndroidGraphicsRect, paramantc.f, paramanso.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());; localObject2 = null)
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        break label207;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "start align: " + paramantc.jdField_e_of_type_JavaLangString + ", startRect: " + paramantc.jdField_c_of_type_AndroidGraphicsRect);
      }
      localObject1 = null;
      break;
      label153:
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "end align " + paramantc.f + ", endRect: " + paramantc.jdField_d_of_type_AndroidGraphicsRect);
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
    if (paramantc.jdField_e_of_type_Int == 1)
    {
      f1 = (m - j) * 0.25F + j;
      f2 = (n - k) * 0.1F + k;
      f3 = (m - j) * 0.25F + j;
      f4 = (n - k) * 1.0F + k;
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(antr.b(j, k));
      ((ArrayList)localObject1).add(antr.a(f1, f2, f3, f4, m, n));
      localObject2 = new ansn[((ArrayList)localObject1).size()];
      int i = 0;
      label387:
      if (i < localObject2.length)
      {
        ansn localansn = new ansn();
        localansn.jdField_a_of_type_Anso = paramanso;
        localansn.jdField_a_of_type_Antr = ((antr)((ArrayList)localObject1).get(i));
        if (paramantc.jdField_a_of_type_Boolean) {
          if (paramanso.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
            break label573;
          }
        }
        label573:
        for (boolean bool = true;; bool = false)
        {
          localansn.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
          localansn.jdField_a_of_type_Boolean = paramanso.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
          localansn.jdField_a_of_type_AndroidGraphicsRect = paramantc.jdField_a_of_type_AndroidGraphicsRect;
          localansn.jdField_b_of_type_Boolean = paramantc.jdField_b_of_type_Boolean;
          localObject2[i] = localansn;
          i += 1;
          break label387;
          if (paramantc.jdField_e_of_type_Int != 2) {
            break label645;
          }
          f1 = (m - j) * 0.1F + j;
          f2 = (n - k) * 0.25F + k;
          f3 = (m - j) * 1.0F + j;
          f4 = (n - k) * 0.25F + k;
          break;
        }
      }
      paramanso = ObjectAnimator.ofObject(this, "pathLocation", new ansq(), (Object[])localObject2);
      paramanso.setDuration(((Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.c * (float)paramantc.jdField_a_of_type_Long * 3.141592653589793D * 0.6000000238418579D));
      return paramanso;
      label645:
      f3 = 0.0F;
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    anso localanso = a(paramLong1, paramLong2);
    ObjectAnimator localObjectAnimator1;
    if (localanso != null)
    {
      localObjectAnimator1 = a(localanso);
      if (localObjectAnimator1 == null) {
        QLog.e("BubbleInterActiveAnim", 1, "startAnimator is null");
      }
    }
    else
    {
      return;
    }
    ObjectAnimator localObjectAnimator2 = b(localanso);
    if (localObjectAnimator2 == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "runningAnimator is null");
      return;
    }
    Object localObject = (antc)localanso.jdField_a_of_type_JavaUtilHashMap.get("animation_end");
    ObjectAnimator localObjectAnimator3 = a(localanso, localanso.jdField_b_of_type_AndroidGraphicsRect, (antc)localObject);
    if (localObjectAnimator3 == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "endAnimator is null");
      return;
    }
    localObjectAnimator3.setRepeatCount(((antc)localObject).jdField_a_of_type_Int - 1);
    localObject = c(localanso);
    if (localObject == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
      return;
    }
    localanso.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObject });
    localanso.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new ansj(this, localanso));
    this.jdField_a_of_type_AndroidOsHandler.post(new BubbleInterActiveAnim.4(this, localanso));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localanso);
  }
  
  public ObjectAnimator c(anso paramanso)
  {
    antc localantc = (antc)paramanso.jdField_a_of_type_JavaUtilHashMap.get("passive_animation");
    ObjectAnimator localObjectAnimator = a(paramanso, paramanso.jdField_b_of_type_AndroidGraphicsRect, localantc);
    if (localObjectAnimator == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
      return null;
    }
    localObjectAnimator.setRepeatCount(localantc.jdField_a_of_type_Int - 1);
    localObjectAnimator.addListener(new ansm(this, paramanso));
    return localObjectAnimator;
  }
  
  protected void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      anso localanso = (anso)localIterator.next();
      if ((localanso != null) && (localanso.jdField_a_of_type_AndroidWidgetImageView != null)) {
        localanso.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      }
    }
  }
  
  public void setBitmapData(ansn paramansn)
  {
    if ((paramansn == null) || (paramansn.jdField_a_of_type_Anso == null)) {}
    do
    {
      do
      {
        return;
        if ((paramansn.jdField_a_of_type_Antr != null) && (paramansn.jdField_a_of_type_Antr.jdField_a_of_type_Int == -1)) {
          setPathLocation(paramansn);
        }
        float f = paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView.getTranslationY();
        if ((f < this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()) || (f > this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int))
        {
          QLog.w("BubbleInterActiveAnim", 1, String.format("setBitmapData: now scroll over screen, stop bubble animator set!, y: %d, up: %d, download: %d", new Object[] { Integer.valueOf((int)f), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int) }));
          this.jdField_a_of_type_AndroidOsHandler.post(new BubbleInterActiveAnim.8(this, paramansn));
          return;
        }
      } while (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramansn.jdField_a_of_type_JavaLangString));
      if (paramansn.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        localObject = new ansb(paramansn.jdField_a_of_type_AndroidGraphicsBitmap);
        ((ansb)localObject).jdField_a_of_type_Boolean = paramansn.jdField_a_of_type_JavaLangBoolean.booleanValue();
        paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
        this.jdField_a_of_type_JavaLangString = paramansn.jdField_a_of_type_JavaLangString;
        paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView.invalidate();
        return;
      }
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramansn.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = (Bitmap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramansn.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    Object localObject = new ansb((Bitmap)localObject);
    ((ansb)localObject).jdField_a_of_type_Boolean = paramansn.jdField_a_of_type_JavaLangBoolean.booleanValue();
    paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_JavaLangString = paramansn.jdField_a_of_type_JavaLangString;
    paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView.invalidate();
    return;
    QLog.e("BubbleInterActiveAnim", 1, "can't find bitmap, path: " + paramansn.jdField_a_of_type_JavaLangString);
  }
  
  public void setPathLocation(ansn paramansn)
  {
    if ((paramansn == null) || (paramansn.jdField_a_of_type_Anso == null) || (paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    if ((paramansn.jdField_a_of_type_AndroidGraphicsRect != null) && (paramansn.jdField_a_of_type_AndroidGraphicsRect.right != 0) && (paramansn.jdField_a_of_type_AndroidGraphicsRect.bottom != 0) && ((paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView.getWidth() != paramansn.jdField_a_of_type_AndroidGraphicsRect.right) || (paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView.getHeight() != paramansn.jdField_a_of_type_AndroidGraphicsRect.bottom)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "change anim view size:  to " + paramansn.jdField_a_of_type_AndroidGraphicsRect.right + "-" + paramansn.jdField_a_of_type_AndroidGraphicsRect.bottom + ", view width-height: " + paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView.getWidth() + "-" + paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView.getHeight());
      }
      paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView.layout(0, 0, paramansn.jdField_a_of_type_AndroidGraphicsRect.right, paramansn.jdField_a_of_type_AndroidGraphicsRect.bottom);
    }
    if (paramansn.jdField_a_of_type_Antr.jdField_a_of_type_Int != -1)
    {
      if (paramansn.jdField_a_of_type_Antr.c != 360.0F) {
        break label456;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "reset animView rotate to 0!");
      }
      paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView.setRotation(0.0F);
    }
    int i;
    int j;
    float f1;
    float f3;
    float f2;
    for (;;)
    {
      localObject = (View)paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidViewView.getParent();
      i = 0;
      j = 0;
      if ((localObject != null) && (((View)localObject).getParent() != this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getParent())) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
      f1 = paramansn.jdField_a_of_type_Antr.jdField_a_of_type_Float;
      f3 = paramansn.jdField_a_of_type_Antr.b;
      float f4 = this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
      f2 = i;
      f3 = j + (f3 - f4);
      if ((f3 >= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()) && (f3 <= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int)) {
        break label585;
      }
      QLog.w("BubbleInterActiveAnim", 1, String.format("setPathLocation: now scroll over screen, stop bubble animator set!, y: %d, up: %d, down: %d", new Object[] { Integer.valueOf((int)f3), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int) }));
      this.jdField_a_of_type_AndroidOsHandler.post(new BubbleInterActiveAnim.9(this, paramansn));
      return;
      label456:
      if (paramansn.jdField_a_of_type_Antr.c != 0.0F)
      {
        paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView.setRotation(paramansn.jdField_a_of_type_Antr.c);
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "set animView rotate to " + paramansn.jdField_a_of_type_Antr.c);
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
    paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(f2 + f1);
    paramansn.jdField_a_of_type_Anso.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(f3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansh
 * JD-Core Version:    0.7.0.1
 */