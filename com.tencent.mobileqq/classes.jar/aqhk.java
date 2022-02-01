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
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import org.jetbrains.annotations.Nullable;

@TargetApi(11)
public class aqhk
  extends afup
{
  public Handler a;
  public BubbleManager a;
  public String a;
  public List<View> a;
  public ConcurrentHashMap<Long, aqhr> a;
  public int b;
  public List<AnimatorSet> b;
  public ConcurrentHashMap<String, Bitmap> b;
  public int c;
  public int d;
  
  public aqhk(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidOsHandler = new aqhl(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = AIOUtils.dp2px(12.0F, paramListView.getContext().getResources());
    this.c = AIOUtils.dp2px(50.0F, paramListView.getContext().getResources());
    this.jdField_d_of_type_Int = AIOUtils.dp2px(45.0F, paramListView.getContext().getResources());
  }
  
  public static long a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    String str = a(paramMessageRecord, paramSessionInfo, null);
    BubbleManager localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    aqhf localaqhf1 = localBubbleManager.a((int)paramMessageRecord.vipBubbleID, false);
    if (a(localaqhf1)) {
      return -1L;
    }
    long l1 = -1L;
    long l2 = -1L;
    long l3;
    long l4;
    int j;
    Object localObject;
    long l6;
    long l5;
    if (!TextUtils.isEmpty(str))
    {
      int i = 0;
      l3 = l1;
      l4 = l2;
      if (paramAIOAnimationConatiner.a() != null)
      {
        l3 = l1;
        l4 = l2;
        if (paramAIOAnimationConatiner.a().getAdapter() != null)
        {
          ListAdapter localListAdapter = paramAIOAnimationConatiner.a().getAdapter();
          int k = paramAIOAnimationConatiner.a().getFirstVisiblePosition();
          j = paramAIOAnimationConatiner.a().getLastVisiblePosition();
          l3 = l1;
          l4 = l2;
          if (j >= k)
          {
            localObject = localListAdapter.getItem(j);
            l6 = l1;
            l5 = l2;
            if (!(localObject instanceof ChatMessage)) {
              break label448;
            }
            paramQQAppInterface = AIOUtils.getHolder(AIOUtils.getViewByPostion(paramAIOAnimationConatiner.a(), j));
            if ((paramQQAppInterface instanceof afqr))
            {
              paramQQAppInterface = (afqr)paramQQAppInterface;
              label193:
              localObject = (ChatMessage)localObject;
              if (i != 0) {
                break label243;
              }
              l6 = l1;
              l5 = l2;
              if (((ChatMessage)localObject).uniseq != paramMessageRecord.uniseq) {
                break label448;
              }
              i = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      paramQQAppInterface = null;
      break label193;
      label243:
      l6 = l1;
      l5 = l2;
      if (paramQQAppInterface != null)
      {
        l6 = l1;
        l5 = l2;
        if (paramQQAppInterface.jdField_a_of_type_Aqhi != null)
        {
          paramQQAppInterface = a((MessageRecord)localObject);
          aqhf localaqhf2 = localBubbleManager.a((int)((ChatMessage)localObject).vipBubbleID, false);
          if (a((ChatMessage)localObject, localaqhf2)) {
            continue;
          }
          boolean bool = a(paramSessionInfo, localaqhf1, localaqhf2);
          l3 = l1;
          l4 = l2;
          if (!TextUtils.isEmpty(paramQQAppInterface))
          {
            l3 = l1;
            l4 = l2;
            if (!str.equals(paramQQAppInterface))
            {
              l3 = l1;
              l4 = l2;
              if (bool)
              {
                l3 = l1;
                if (l1 == -1L) {
                  l3 = ((ChatMessage)localObject).uniseq;
                }
                l4 = a(paramMessageRecord, paramSessionInfo, l3, l2, (ChatMessage)localObject, paramQQAppInterface);
              }
            }
          }
          l6 = l3;
          l5 = l4;
          if (l3 != -1L)
          {
            l6 = l3;
            l5 = l4;
            if (l4 != -1L)
            {
              paramQQAppInterface = a(paramAIOAnimationConatiner, l3, l4);
              if (paramQQAppInterface != null) {
                return paramQQAppInterface.longValue();
              }
              return -1L;
            }
          }
        }
      }
      label448:
      l1 = l6;
      l2 = l5;
    }
  }
  
  private static long a(MessageRecord paramMessageRecord, long paramLong1, long paramLong2, ChatMessage paramChatMessage, String paramString)
  {
    if ((paramMessageRecord.atInfoTempList != null) && (paramMessageRecord.atInfoTempList.size() > 0))
    {
      paramMessageRecord = paramMessageRecord.atInfoTempList.iterator();
      for (;;)
      {
        paramLong1 = paramLong2;
        if (!paramMessageRecord.hasNext()) {
          break;
        }
        if (paramString.equals(String.valueOf(((MessageForText.AtTroopMemberInfo)paramMessageRecord.next()).uin))) {
          paramLong2 = paramChatMessage.uniseq;
        }
      }
    }
    if ((paramMessageRecord.atInfoList != null) && (paramMessageRecord.atInfoList.size() > 0))
    {
      paramMessageRecord = paramMessageRecord.atInfoList.iterator();
      for (;;)
      {
        paramLong1 = paramLong2;
        if (!paramMessageRecord.hasNext()) {
          break;
        }
        if (paramString.equals(String.valueOf(((MessageForText.AtTroopMemberInfo)paramMessageRecord.next()).uin))) {
          paramLong2 = paramChatMessage.uniseq;
        }
      }
    }
    return paramLong1;
  }
  
  private static long a(MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, long paramLong1, long paramLong2, ChatMessage paramChatMessage, String paramString)
  {
    if (paramSessionInfo.curType == 0) {
      return paramLong1;
    }
    return a(paramMessageRecord, paramLong1, paramLong2, paramChatMessage, paramString);
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
    if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020) || (paramMessageRecord.istroop == 1004)) {
      return paramMessageRecord.frienduin;
    }
    return paramMessageRecord.senderuin;
  }
  
  private static String a(MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramSessionInfo.curType == 0) || (paramSessionInfo.curType == 1) || (paramSessionInfo.curType == 3000)) {
      paramString = a(paramMessageRecord);
    }
    return paramString;
  }
  
  private static boolean a(aqhf paramaqhf)
  {
    if ((paramaqhf == null) || (paramaqhf.b == null)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "bubble config mInterActivePackageID: " + paramaqhf.f + ", bubble mInterActiveType: " + paramaqhf.g);
    }
    return false;
  }
  
  private static boolean a(aqhf paramaqhf1, aqhf paramaqhf2, boolean paramBoolean)
  {
    if (paramaqhf1.g == 3) {
      if ((paramaqhf2.g != 2) || (paramaqhf2.f == paramaqhf1.f)) {}
    }
    do
    {
      do
      {
        return true;
      } while (paramaqhf2.g == 3);
      do
      {
        return paramBoolean;
        if (paramaqhf1.g == 1)
        {
          if ((paramaqhf1.f == paramaqhf2.f) && (paramaqhf1.g == paramaqhf2.g)) {
            break;
          }
          return false;
        }
      } while ((paramaqhf1.g != 2) || ((paramaqhf2.g != 2) && (paramaqhf2.g != 3)));
    } while (paramaqhf2.f != paramaqhf1.f);
    return false;
  }
  
  private static boolean a(SessionInfo paramSessionInfo, aqhf paramaqhf1, aqhf paramaqhf2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramSessionInfo.curType == 0) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramaqhf1.f == -1);
      bool1 = bool2;
    } while (paramaqhf2.f == -1);
    return a(paramaqhf1, paramaqhf2, false);
  }
  
  public static boolean a(AIOAnimationConatiner paramAIOAnimationConatiner, long paramLong)
  {
    boolean bool2 = false;
    ListAdapter localListAdapter = paramAIOAnimationConatiner.a().getAdapter();
    int j;
    int i;
    if (paramAIOAnimationConatiner.a().getChildCount() > 0) {
      if ((localListAdapter instanceof blcj))
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
        if (!(localListAdapter instanceof afqz)) {
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
  
  private static boolean a(ChatMessage paramChatMessage, aqhf paramaqhf)
  {
    if ((paramaqhf == null) || (paramaqhf.b == null))
    {
      QLog.e("BubbleInterActiveAnim", 1, "get bubbleConfig is null: " + (int)paramChatMessage.vipBubbleID);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "record seq: " + paramChatMessage.uniseq + ", other bubble config mInterActivePackageID: " + paramaqhf.f + ", other bubble config mInterActiveType: " + paramaqhf.g);
    }
    return false;
  }
  
  public ObjectAnimator a(aqhr paramaqhr)
  {
    aqif localaqif = (aqif)paramaqhr.jdField_a_of_type_JavaUtilHashMap.get("animation_start");
    ObjectAnimator localObjectAnimator = a(paramaqhr, paramaqhr.jdField_a_of_type_AndroidGraphicsRect, localaqif);
    localObjectAnimator.setRepeatCount(localaqif.jdField_a_of_type_Int - 1);
    Object localObject1;
    long l;
    if (((aqif)paramaqhr.jdField_a_of_type_JavaUtilHashMap.get("animation_running")).jdField_b_of_type_Boolean)
    {
      Object localObject2 = (aqif)paramaqhr.jdField_a_of_type_JavaUtilHashMap.get("animation_end");
      localObject1 = a(paramaqhr.jdField_a_of_type_AndroidGraphicsRect, localaqif.jdField_a_of_type_AndroidGraphicsRect, localaqif.jdField_c_of_type_JavaLangString, paramaqhr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      localObject2 = a(paramaqhr.jdField_b_of_type_AndroidGraphicsRect, ((aqif)localObject2).jdField_a_of_type_AndroidGraphicsRect, ((aqif)localObject2).jdField_c_of_type_JavaLangString, paramaqhr.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());
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
          if (!paramaqhr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
            f1 = -f2;
          }
        }
      }
      localObject1 = ObjectAnimator.ofFloat(paramaqhr.jdField_a_of_type_AndroidWidgetImageView, "rotation", new float[] { 0.0F, f1 });
      i = localaqif.jdField_a_of_type_Int - 1;
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
      localObjectAnimator.addListener(new aqhn(this, (ObjectAnimator)localObject1, paramaqhr));
      return localObjectAnimator;
      l = localObjectAnimator.getDuration();
      break;
      localObject1 = null;
    }
  }
  
  public ObjectAnimator a(aqhr paramaqhr, Rect paramRect, aqif paramaqif)
  {
    File localFile = null;
    if (paramaqif == null) {
      return null;
    }
    Object localObject = localFile;
    boolean bool;
    if (paramRect != null)
    {
      localObject = localFile;
      if (paramaqif.jdField_e_of_type_Int == -1)
      {
        if (paramRect != paramaqhr.jdField_a_of_type_AndroidGraphicsRect) {
          break label326;
        }
        bool = paramaqhr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        paramRect = a(paramRect, paramaqif.jdField_a_of_type_AndroidGraphicsRect, paramaqif.jdField_c_of_type_JavaLangString, bool);
        localObject = new aqiu(-1, ((Integer)paramRect.first).intValue(), ((Integer)paramRect.second).intValue());
      }
    }
    localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramaqif.jdField_d_of_type_Int, false), paramaqif.jdField_d_of_type_JavaLangString);
    paramRect = new ArrayList();
    int i = 0;
    label130:
    if (i < paramaqif.jdField_b_of_type_Int)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramaqif.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
      aqhq localaqhq = new aqhq();
      localaqhq.jdField_b_of_type_JavaLangString = str;
      localaqhq.jdField_a_of_type_JavaLangString = (paramaqif.jdField_a_of_type_JavaLangString + str);
      localaqhq.jdField_a_of_type_Aqhr = paramaqhr;
      localaqhq.jdField_a_of_type_AndroidGraphicsRect = paramaqif.jdField_a_of_type_AndroidGraphicsRect;
      if (paramaqif.jdField_a_of_type_Boolean) {
        if (paramaqhr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
          break label338;
        }
      }
      label326:
      label338:
      for (bool = true;; bool = false)
      {
        localaqhq.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localaqhq.jdField_a_of_type_Boolean = paramaqhr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        if (paramaqif.jdField_e_of_type_Int == -1) {
          localaqhq.jdField_a_of_type_Aqiu = ((aqiu)localObject);
        }
        paramRect.add(localaqhq);
        i += 1;
        break label130;
        bool = paramaqhr.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        break;
      }
    }
    paramaqhr = new Keyframe[paramRect.size() + 1];
    float f = 1.0F / paramRect.size();
    paramaqhr[0] = Keyframe.ofObject(0.0F, paramRect.get(0));
    i = 0;
    if (i < paramRect.size())
    {
      if (i != paramRect.size() - 1) {
        paramaqhr[(i + 1)] = Keyframe.ofObject((i + 1) * f, paramRect.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        paramaqhr[(i + 1)] = Keyframe.ofObject(1.0F, paramRect.get(i));
      }
    }
    paramaqhr = PropertyValuesHolder.ofKeyframe("bitmapData", paramaqhr);
    paramaqhr.setEvaluator(new aqhs(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { paramaqhr }).setDuration(paramRect.size() * paramaqif.jdField_a_of_type_Long);
  }
  
  public ObjectAnimator a(aqhr paramaqhr, aqif paramaqif)
  {
    if ((!TextUtils.isEmpty(paramaqif.jdField_e_of_type_JavaLangString)) && (paramaqif.jdField_c_of_type_AndroidGraphicsRect != null))
    {
      localObject1 = a(paramaqhr.jdField_a_of_type_AndroidGraphicsRect, paramaqif.jdField_c_of_type_AndroidGraphicsRect, paramaqif.jdField_e_of_type_JavaLangString, paramaqhr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      if ((TextUtils.isEmpty(paramaqif.f)) || (paramaqif.jdField_d_of_type_AndroidGraphicsRect == null)) {
        break label151;
      }
    }
    for (Object localObject2 = a(paramaqhr.jdField_b_of_type_AndroidGraphicsRect, paramaqif.jdField_d_of_type_AndroidGraphicsRect, paramaqif.f, paramaqhr.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());; localObject2 = null)
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        break label206;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "start align: " + paramaqif.jdField_e_of_type_JavaLangString + ", startRect: " + paramaqif.jdField_c_of_type_AndroidGraphicsRect);
      }
      localObject1 = null;
      break;
      label151:
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "end align " + paramaqif.f + ", endRect: " + paramaqif.jdField_d_of_type_AndroidGraphicsRect);
      }
    }
    label206:
    int j = ((Integer)((Pair)localObject1).first).intValue();
    int k = ((Integer)((Pair)localObject1).second).intValue();
    int m = ((Integer)((Pair)localObject2).first).intValue();
    int n = ((Integer)((Pair)localObject2).second).intValue();
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(aqiu.b(j, k));
    ((ArrayList)localObject1).add(aqiu.a(m, n));
    localObject2 = new aqht();
    aqhq[] arrayOfaqhq = new aqhq[((ArrayList)localObject1).size()];
    int i = 0;
    if (i < arrayOfaqhq.length)
    {
      aqhq localaqhq = new aqhq();
      localaqhq.jdField_a_of_type_Aqhr = paramaqhr;
      localaqhq.jdField_a_of_type_Aqiu = ((aqiu)((ArrayList)localObject1).get(i));
      if (paramaqif.jdField_a_of_type_Boolean) {
        if (paramaqhr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
          break label427;
        }
      }
      label427:
      for (boolean bool = true;; bool = false)
      {
        localaqhq.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localaqhq.jdField_a_of_type_Boolean = paramaqhr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        localaqhq.jdField_b_of_type_Boolean = paramaqif.jdField_b_of_type_Boolean;
        localaqhq.jdField_a_of_type_AndroidGraphicsRect = paramaqif.jdField_a_of_type_AndroidGraphicsRect;
        arrayOfaqhq[i] = localaqhq;
        i += 1;
        break;
      }
    }
    paramaqhr = ObjectAnimator.ofObject(this, "pathLocation", (TypeEvaluator)localObject2, arrayOfaqhq);
    paramaqhr.setDuration(((Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.c * (float)paramaqif.jdField_a_of_type_Long));
    return paramaqhr;
  }
  
  public Rect a(afqr paramafqr, long paramLong, ListView paramListView)
  {
    int i = paramafqr.jdField_a_of_type_Aqhi.jdField_a_of_type_Int;
    paramListView = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(i, false);
    if (paramListView == null) {
      return null;
    }
    if ((aqie)paramListView.b.get("animation_start") == null)
    {
      paramListView = paramListView.b.values().iterator();
      while ((paramListView.hasNext()) && ((aqie)paramListView.next() == null)) {}
    }
    paramListView = paramafqr.jdField_a_of_type_AndroidViewView;
    int j = paramListView.getLeft();
    i = paramListView.getTop();
    paramafqr = (View)paramListView.getParent();
    for (;;)
    {
      if ((paramafqr == null) || ((paramafqr instanceof BaseChatItemLayout)))
      {
        paramafqr = new Rect();
        paramafqr.left = (BaseChatItemLayout.j + j);
        paramafqr.right = (paramListView.getRight() - paramListView.getLeft() + j - BaseChatItemLayout.j);
        paramafqr.top = (BaseChatItemLayout.h + i);
        paramafqr.bottom = (paramListView.getBottom() - paramListView.getTop() + i - BaseChatItemLayout.i);
        return paramafqr;
      }
      j += paramafqr.getLeft();
      i += paramafqr.getTop();
      paramafqr = paramafqr.getParent();
      if ((paramafqr instanceof View)) {
        paramafqr = (View)paramafqr;
      } else {
        paramafqr = null;
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
  
  public aqhr a(long paramLong1, long paramLong2)
  {
    Object localObject1 = AIOUtils.getHolder(AIOUtils.getViewByPostion(this.jdField_a_of_type_ComTencentWidgetListView, AIOUtils.findMessagePosition(paramLong1, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter())));
    if ((localObject1 instanceof afqr)) {}
    for (localObject1 = (afqr)localObject1;; localObject1 = null)
    {
      Object localObject2 = AIOUtils.getHolder(AIOUtils.getViewByPostion(this.jdField_a_of_type_ComTencentWidgetListView, AIOUtils.findMessagePosition(paramLong2, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter())));
      if ((localObject2 instanceof afqr)) {}
      for (localObject2 = (afqr)localObject2;; localObject2 = null)
      {
        if ((localObject1 == null) || (localObject2 == null) || (((afqr)localObject1).jdField_a_of_type_Aqhi == null) || (((afqr)localObject2).jdField_a_of_type_Aqhi == null)) {}
        aqhf localaqhf;
        do
        {
          return null;
          i = ((afqr)localObject1).jdField_a_of_type_Aqhi.jdField_a_of_type_Int;
          int j = ((afqr)localObject2).jdField_a_of_type_Aqhi.jdField_a_of_type_Int;
          localaqhf = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(i, false);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(j, false);
        } while ((localaqhf == null) || (localObject3 == null) || (localaqhf.b == null) || (((aqhf)localObject3).b == null));
        aqie localaqie1 = (aqie)localaqhf.b.get("animation_start");
        aqie localaqie2 = (aqie)((aqhf)localObject3).b.get("passive_animation");
        if (localaqie1 == null)
        {
          QLog.e("BubbleInterActiveAnim", 1, "can't find mInterActiveAnims from bubbleId: " + i);
          return null;
        }
        Object localObject3 = new aqhr();
        ((aqhr)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((afqr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        ((aqhr)localObject3).jdField_b_of_type_ComTencentMobileqqDataMessageRecord = ((afqr)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        ((aqhr)localObject3).jdField_a_of_type_JavaUtilHashMap = new HashMap(localaqhf.b);
        ((aqhr)localObject3).jdField_a_of_type_JavaUtilHashMap.put("passive_animation", localaqie2);
        ((aqhr)localObject3).jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
        ((aqhr)localObject3).jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ((aqhr)localObject3).jdField_a_of_type_AndroidWidgetImageView.layout(0, 0, localaqie1.jdField_a_of_type_AndroidGraphicsRect.right, localaqie1.jdField_a_of_type_AndroidGraphicsRect.bottom);
        ((aqhr)localObject3).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        ((aqhr)localObject3).jdField_a_of_type_AndroidGraphicsRect = a((afqr)localObject1, paramLong1, this.jdField_a_of_type_ComTencentWidgetListView);
        ((aqhr)localObject3).jdField_b_of_type_AndroidGraphicsRect = a((afqr)localObject2, paramLong2, this.jdField_a_of_type_ComTencentWidgetListView);
        localObject2 = (View)((afqr)localObject2).jdField_a_of_type_AndroidViewView.getParent();
        int i = ((View)((afqr)localObject1).jdField_a_of_type_AndroidViewView.getParent()).getTop() - ((View)localObject2).getTop();
        localObject2 = ((aqhr)localObject3).jdField_b_of_type_AndroidGraphicsRect;
        ((Rect)localObject2).top -= i;
        localObject2 = ((aqhr)localObject3).jdField_b_of_type_AndroidGraphicsRect;
        ((Rect)localObject2).bottom -= i;
        ((aqhr)localObject3).jdField_a_of_type_AndroidViewView = ((afqr)localObject1).jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localObject3);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(((aqhr)localObject3).jdField_a_of_type_AndroidWidgetImageView);
        ((aqhr)localObject3).jdField_a_of_type_Long = paramLong1;
        ((aqhr)localObject3).jdField_b_of_type_Long = paramLong2;
        return localObject3;
      }
    }
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      aqhr localaqhr = (aqhr)localIterator.next();
      if ((localaqhr != null) && (localaqhr.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "add delta " + paramInt + " for seq: " + localaqhr.jdField_a_of_type_Long);
        }
        localaqhr.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(localaqhr.jdField_a_of_type_AndroidWidgetImageView.getTranslationY() + paramInt);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ThreadManager.post(new BubbleInterActiveAnim.2(this, paramLong1, paramLong2), 5, null, true);
  }
  
  public void a(aqhr paramaqhr)
  {
    paramaqhr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeView(paramaqhr.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramaqhr.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
      d();
    }
  }
  
  public void a(aqie paramaqie, int paramInt)
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramInt, false), paramaqie.jdField_d_of_type_JavaLangString);
    paramInt = 0;
    if (paramInt < paramaqie.jdField_b_of_type_Int)
    {
      Object localObject1 = localFile.getAbsolutePath() + File.separatorChar + paramaqie.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(paramInt + 1) });
      String str = paramaqie.jdField_a_of_type_JavaLangString + (String)localObject1;
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
      aqhr localaqhr = (aqhr)localIterator.next();
      if ((localaqhr != null) && (localaqhr.jdField_a_of_type_AndroidViewView != null))
      {
        paramInt1 = AIOUtils.findMessagePosition(localaqhr.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
        paramInt2 = AIOUtils.findMessagePosition(localaqhr.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
        Object localObject2 = AIOUtils.getHolder(AIOUtils.getViewByPostion(this.jdField_a_of_type_ComTencentWidgetListView, paramInt1));
        Object localObject1 = AIOUtils.getHolder(AIOUtils.getViewByPostion(this.jdField_a_of_type_ComTencentWidgetListView, paramInt2));
        if ((localObject2 != null) && ((localObject2 instanceof afqr)))
        {
          localObject2 = (afqr)localObject2;
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "refresh seq " + localaqhr.jdField_a_of_type_Long + " 's bubbleView");
          }
          localaqhr.jdField_a_of_type_AndroidViewView = ((afqr)localObject2).jdField_a_of_type_AndroidViewView;
          localaqhr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((afqr)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        }
        for (;;)
        {
          if ((localObject1 == null) || (!(localObject1 instanceof afqr))) {
            break label314;
          }
          localObject1 = (afqr)localObject1;
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "refresh seq " + localaqhr.jdField_b_of_type_Long + " 's bubbleView");
          }
          localaqhr.jdField_b_of_type_ComTencentMobileqqDataMessageRecord = ((afqr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          break;
          if (QLog.isColorLevel()) {
            QLog.w("BubbleInterActiveAnim", 2, "stop current bubble animation! " + localaqhr.jdField_a_of_type_Long);
          }
          localaqhr.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
        }
        label314:
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "stop current bubble animation! " + localaqhr.jdField_b_of_type_Long);
        }
        localaqhr.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
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
        break label288;
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
        this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager = ((BubbleManager)paramVarArgs.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER));
      }
      a(l1, l2);
      return true;
      label288:
      localObject = null;
    }
  }
  
  public ObjectAnimator b(aqhr paramaqhr)
  {
    Object localObject1 = (aqie)paramaqhr.jdField_a_of_type_JavaUtilHashMap.get("animation_running");
    if (!(localObject1 instanceof aqif)) {
      return null;
    }
    Object localObject2 = (aqif)localObject1;
    if (((aqif)localObject2).jdField_e_of_type_Int == -1) {
      return null;
    }
    if (((aqif)localObject2).jdField_e_of_type_Int == 0) {}
    for (localObject1 = a(paramaqhr, (aqif)localObject2);; localObject1 = b(paramaqhr, (aqif)localObject2))
    {
      localObject2 = a(paramaqhr, paramaqhr.jdField_a_of_type_AndroidGraphicsRect, (aqif)localObject2);
      if ((localObject1 != null) && (localObject2 != null)) {
        break;
      }
      return null;
    }
    ((ObjectAnimator)localObject2).setDuration(((ObjectAnimator)localObject2).getDuration() / 2L);
    ((ObjectAnimator)localObject2).setRepeatCount(-1);
    ((ObjectAnimator)localObject1).addListener(new aqho(this, paramaqhr, (ObjectAnimator)localObject2));
    return localObject1;
  }
  
  public ObjectAnimator b(aqhr paramaqhr, aqif paramaqif)
  {
    float f4 = 0.0F;
    Object localObject1;
    if ((!TextUtils.isEmpty(paramaqif.jdField_e_of_type_JavaLangString)) && (paramaqif.jdField_c_of_type_AndroidGraphicsRect != null))
    {
      localObject1 = a(paramaqhr.jdField_a_of_type_AndroidGraphicsRect, paramaqif.jdField_c_of_type_AndroidGraphicsRect, paramaqif.jdField_e_of_type_JavaLangString, paramaqhr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      if ((TextUtils.isEmpty(paramaqif.f)) || (paramaqif.jdField_d_of_type_AndroidGraphicsRect == null)) {
        break label154;
      }
    }
    for (Object localObject2 = a(paramaqhr.jdField_b_of_type_AndroidGraphicsRect, paramaqif.jdField_d_of_type_AndroidGraphicsRect, paramaqif.f, paramaqhr.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());; localObject2 = null)
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        break label209;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "start align: " + paramaqif.jdField_e_of_type_JavaLangString + ", startRect: " + paramaqif.jdField_c_of_type_AndroidGraphicsRect);
      }
      localObject1 = null;
      break;
      label154:
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "end align " + paramaqif.f + ", endRect: " + paramaqif.jdField_d_of_type_AndroidGraphicsRect);
      }
    }
    label209:
    int j = ((Integer)((Pair)localObject1).first).intValue();
    int k = ((Integer)((Pair)localObject1).second).intValue();
    int m = ((Integer)((Pair)localObject2).first).intValue();
    int n = ((Integer)((Pair)localObject2).second).intValue();
    float f1;
    float f2;
    float f3;
    if (paramaqif.jdField_e_of_type_Int == 1)
    {
      f1 = (m - j) * 0.25F + j;
      f2 = (n - k) * 0.1F + k;
      f3 = (m - j) * 0.25F + j;
      f4 = (n - k) * 1.0F + k;
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(aqiu.b(j, k));
      ((ArrayList)localObject1).add(aqiu.a(f1, f2, f3, f4, m, n));
      localObject2 = new aqhq[((ArrayList)localObject1).size()];
      int i = 0;
      label389:
      if (i < localObject2.length)
      {
        aqhq localaqhq = new aqhq();
        localaqhq.jdField_a_of_type_Aqhr = paramaqhr;
        localaqhq.jdField_a_of_type_Aqiu = ((aqiu)((ArrayList)localObject1).get(i));
        if (paramaqif.jdField_a_of_type_Boolean) {
          if (paramaqhr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
            break label575;
          }
        }
        label575:
        for (boolean bool = true;; bool = false)
        {
          localaqhq.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
          localaqhq.jdField_a_of_type_Boolean = paramaqhr.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
          localaqhq.jdField_a_of_type_AndroidGraphicsRect = paramaqif.jdField_a_of_type_AndroidGraphicsRect;
          localaqhq.jdField_b_of_type_Boolean = paramaqif.jdField_b_of_type_Boolean;
          localObject2[i] = localaqhq;
          i += 1;
          break label389;
          if (paramaqif.jdField_e_of_type_Int != 2) {
            break label647;
          }
          f1 = (m - j) * 0.1F + j;
          f2 = (n - k) * 0.25F + k;
          f3 = (m - j) * 1.0F + j;
          f4 = (n - k) * 0.25F + k;
          break;
        }
      }
      paramaqhr = ObjectAnimator.ofObject(this, "pathLocation", new aqht(), (Object[])localObject2);
      paramaqhr.setDuration(((Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.c * (float)paramaqif.jdField_a_of_type_Long * 3.141592653589793D * 0.6000000238418579D));
      return paramaqhr;
      label647:
      f3 = 0.0F;
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    aqhr localaqhr = a(paramLong1, paramLong2);
    ObjectAnimator localObjectAnimator1;
    if (localaqhr != null)
    {
      localObjectAnimator1 = a(localaqhr);
      if (localObjectAnimator1 == null) {
        QLog.e("BubbleInterActiveAnim", 1, "startAnimator is null");
      }
    }
    else
    {
      return;
    }
    ObjectAnimator localObjectAnimator2 = b(localaqhr);
    if (localObjectAnimator2 == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "runningAnimator is null");
      return;
    }
    Object localObject = (aqif)localaqhr.jdField_a_of_type_JavaUtilHashMap.get("animation_end");
    ObjectAnimator localObjectAnimator3 = a(localaqhr, localaqhr.jdField_b_of_type_AndroidGraphicsRect, (aqif)localObject);
    if (localObjectAnimator3 == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "endAnimator is null");
      return;
    }
    localObjectAnimator3.setRepeatCount(((aqif)localObject).jdField_a_of_type_Int - 1);
    localObject = c(localaqhr);
    if (localObject == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
      return;
    }
    localaqhr.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObject });
    localaqhr.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new aqhm(this, localaqhr));
    this.jdField_a_of_type_AndroidOsHandler.post(new BubbleInterActiveAnim.4(this, localaqhr));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localaqhr);
  }
  
  public ObjectAnimator c(aqhr paramaqhr)
  {
    aqif localaqif = (aqif)paramaqhr.jdField_a_of_type_JavaUtilHashMap.get("passive_animation");
    ObjectAnimator localObjectAnimator = a(paramaqhr, paramaqhr.jdField_b_of_type_AndroidGraphicsRect, localaqif);
    if (localObjectAnimator == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
      return null;
    }
    localObjectAnimator.setRepeatCount(localaqif.jdField_a_of_type_Int - 1);
    localObjectAnimator.addListener(new aqhp(this, paramaqhr));
    return localObjectAnimator;
  }
  
  protected void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      aqhr localaqhr = (aqhr)localIterator.next();
      if ((localaqhr != null) && (localaqhr.jdField_a_of_type_AndroidWidgetImageView != null)) {
        localaqhr.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      }
    }
  }
  
  public void setBitmapData(aqhq paramaqhq)
  {
    if ((paramaqhq == null) || (paramaqhq.jdField_a_of_type_Aqhr == null)) {}
    do
    {
      do
      {
        return;
        if ((paramaqhq.jdField_a_of_type_Aqiu != null) && (paramaqhq.jdField_a_of_type_Aqiu.jdField_a_of_type_Int == -1)) {
          setPathLocation(paramaqhq);
        }
        float f = paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.getTranslationY();
        if ((f < this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()) || (f > this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int))
        {
          QLog.w("BubbleInterActiveAnim", 1, String.format("setBitmapData: now scroll over screen, stop bubble animator set!, y: %d, up: %d, download: %d", new Object[] { Integer.valueOf((int)f), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int) }));
          this.jdField_a_of_type_AndroidOsHandler.post(new BubbleInterActiveAnim.8(this, paramaqhq));
          return;
        }
      } while (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramaqhq.jdField_a_of_type_JavaLangString));
      if (paramaqhq.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        localObject = new aqhe(paramaqhq.jdField_a_of_type_AndroidGraphicsBitmap);
        ((aqhe)localObject).jdField_a_of_type_Boolean = paramaqhq.jdField_a_of_type_JavaLangBoolean.booleanValue();
        paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
        this.jdField_a_of_type_JavaLangString = paramaqhq.jdField_a_of_type_JavaLangString;
        paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.invalidate();
        return;
      }
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramaqhq.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = (Bitmap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramaqhq.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    Object localObject = new aqhe((Bitmap)localObject);
    ((aqhe)localObject).jdField_a_of_type_Boolean = paramaqhq.jdField_a_of_type_JavaLangBoolean.booleanValue();
    paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_JavaLangString = paramaqhq.jdField_a_of_type_JavaLangString;
    paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.invalidate();
    return;
    QLog.e("BubbleInterActiveAnim", 1, "can't find bitmap, path: " + paramaqhq.jdField_a_of_type_JavaLangString);
  }
  
  public void setPathLocation(aqhq paramaqhq)
  {
    if ((paramaqhq == null) || (paramaqhq.jdField_a_of_type_Aqhr == null) || (paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    if ((paramaqhq.jdField_a_of_type_AndroidGraphicsRect != null) && (paramaqhq.jdField_a_of_type_AndroidGraphicsRect.right != 0) && (paramaqhq.jdField_a_of_type_AndroidGraphicsRect.bottom != 0) && ((paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.getWidth() != paramaqhq.jdField_a_of_type_AndroidGraphicsRect.right) || (paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.getHeight() != paramaqhq.jdField_a_of_type_AndroidGraphicsRect.bottom)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "change anim view size:  to " + paramaqhq.jdField_a_of_type_AndroidGraphicsRect.right + "-" + paramaqhq.jdField_a_of_type_AndroidGraphicsRect.bottom + ", view width-height: " + paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.getWidth() + "-" + paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.getHeight());
      }
      paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.layout(0, 0, paramaqhq.jdField_a_of_type_AndroidGraphicsRect.right, paramaqhq.jdField_a_of_type_AndroidGraphicsRect.bottom);
    }
    if (paramaqhq.jdField_a_of_type_Aqiu.jdField_a_of_type_Int != -1)
    {
      if (paramaqhq.jdField_a_of_type_Aqiu.c != 360.0F) {
        break label459;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "reset animView rotate to 0!");
      }
      paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.setRotation(0.0F);
    }
    int i;
    int j;
    float f1;
    float f3;
    float f2;
    for (;;)
    {
      localObject = (View)paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidViewView.getParent();
      i = 0;
      j = 0;
      if ((localObject != null) && (((View)localObject).getParent() != this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getParent())) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
      f1 = paramaqhq.jdField_a_of_type_Aqiu.jdField_a_of_type_Float;
      f3 = paramaqhq.jdField_a_of_type_Aqiu.b;
      float f4 = this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
      f2 = i;
      f3 = j + (f3 - f4);
      if ((f3 >= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()) && (f3 <= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int)) {
        break label589;
      }
      QLog.w("BubbleInterActiveAnim", 1, String.format("setPathLocation: now scroll over screen, stop bubble animator set!, y: %d, up: %d, down: %d", new Object[] { Integer.valueOf((int)f3), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int) }));
      this.jdField_a_of_type_AndroidOsHandler.post(new BubbleInterActiveAnim.9(this, paramaqhq));
      return;
      label459:
      if (paramaqhq.jdField_a_of_type_Aqiu.c != 0.0F)
      {
        paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.setRotation(paramaqhq.jdField_a_of_type_Aqiu.c);
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "set animView rotate to " + paramaqhq.jdField_a_of_type_Aqiu.c);
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
    label589:
    paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(f2 + f1);
    paramaqhq.jdField_a_of_type_Aqhr.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(f3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhk
 * JD-Core Version:    0.7.0.1
 */