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
public class apeg
  extends afdk
{
  public Handler a;
  public BubbleManager a;
  public String a;
  public List<View> a;
  public ConcurrentHashMap<Long, apen> a;
  public int b;
  public List<AnimatorSet> b;
  public ConcurrentHashMap<String, Bitmap> b;
  public int c;
  public int d;
  
  public apeg(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidOsHandler = new apeh(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = AIOUtils.dp2px(12.0F, paramListView.getContext().getResources());
    this.c = AIOUtils.dp2px(50.0F, paramListView.getContext().getResources());
    this.jdField_d_of_type_Int = AIOUtils.dp2px(45.0F, paramListView.getContext().getResources());
  }
  
  public static long a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    String str = a(paramMessageRecord, paramSessionInfo, null);
    BubbleManager localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(44);
    apeb localapeb1 = localBubbleManager.a((int)paramMessageRecord.vipBubbleID, false);
    if (a(localapeb1)) {
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
              break label447;
            }
            paramQQAppInterface = AIOUtils.getHolder(AIOUtils.getViewByPostion(paramAIOAnimationConatiner.a(), j));
            if ((paramQQAppInterface instanceof aezf))
            {
              paramQQAppInterface = (aezf)paramQQAppInterface;
              label192:
              localObject = (ChatMessage)localObject;
              if (i != 0) {
                break label242;
              }
              l6 = l1;
              l5 = l2;
              if (((ChatMessage)localObject).uniseq != paramMessageRecord.uniseq) {
                break label447;
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
      break label192;
      label242:
      l6 = l1;
      l5 = l2;
      if (paramQQAppInterface != null)
      {
        l6 = l1;
        l5 = l2;
        if (paramQQAppInterface.jdField_a_of_type_Apee != null)
        {
          paramQQAppInterface = a((MessageRecord)localObject);
          apeb localapeb2 = localBubbleManager.a((int)((ChatMessage)localObject).vipBubbleID, false);
          if (a((ChatMessage)localObject, localapeb2)) {
            continue;
          }
          boolean bool = a(paramSessionInfo, localapeb1, localapeb2);
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
      label447:
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
  
  private static boolean a(apeb paramapeb)
  {
    if ((paramapeb == null) || (paramapeb.b == null)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "bubble config mInterActivePackageID: " + paramapeb.f + ", bubble mInterActiveType: " + paramapeb.g);
    }
    return false;
  }
  
  private static boolean a(apeb paramapeb1, apeb paramapeb2, boolean paramBoolean)
  {
    if (paramapeb1.g == 3) {
      if ((paramapeb2.g != 2) || (paramapeb2.f == paramapeb1.f)) {}
    }
    do
    {
      do
      {
        return true;
      } while (paramapeb2.g == 3);
      do
      {
        return paramBoolean;
        if (paramapeb1.g == 1)
        {
          if ((paramapeb1.f == paramapeb2.f) && (paramapeb1.g == paramapeb2.g)) {
            break;
          }
          return false;
        }
      } while ((paramapeb1.g != 2) || ((paramapeb2.g != 2) && (paramapeb2.g != 3)));
    } while (paramapeb2.f != paramapeb1.f);
    return false;
  }
  
  private static boolean a(SessionInfo paramSessionInfo, apeb paramapeb1, apeb paramapeb2)
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
      } while (paramapeb1.f == -1);
      bool1 = bool2;
    } while (paramapeb2.f == -1);
    return a(paramapeb1, paramapeb2, false);
  }
  
  public static boolean a(AIOAnimationConatiner paramAIOAnimationConatiner, long paramLong)
  {
    boolean bool2 = false;
    ListAdapter localListAdapter = paramAIOAnimationConatiner.a().getAdapter();
    int j;
    int i;
    if (paramAIOAnimationConatiner.a().getChildCount() > 0) {
      if ((localListAdapter instanceof bjqx))
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
        if (!(localListAdapter instanceof aezn)) {
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
  
  private static boolean a(ChatMessage paramChatMessage, apeb paramapeb)
  {
    if ((paramapeb == null) || (paramapeb.b == null))
    {
      QLog.e("BubbleInterActiveAnim", 1, "get bubbleConfig is null: " + (int)paramChatMessage.vipBubbleID);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "record seq: " + paramChatMessage.uniseq + ", other bubble config mInterActivePackageID: " + paramapeb.f + ", other bubble config mInterActiveType: " + paramapeb.g);
    }
    return false;
  }
  
  public ObjectAnimator a(apen paramapen)
  {
    apfb localapfb = (apfb)paramapen.jdField_a_of_type_JavaUtilHashMap.get("animation_start");
    ObjectAnimator localObjectAnimator = a(paramapen, paramapen.jdField_a_of_type_AndroidGraphicsRect, localapfb);
    localObjectAnimator.setRepeatCount(localapfb.jdField_a_of_type_Int - 1);
    Object localObject1;
    long l;
    if (((apfb)paramapen.jdField_a_of_type_JavaUtilHashMap.get("animation_running")).jdField_b_of_type_Boolean)
    {
      Object localObject2 = (apfb)paramapen.jdField_a_of_type_JavaUtilHashMap.get("animation_end");
      localObject1 = a(paramapen.jdField_a_of_type_AndroidGraphicsRect, localapfb.jdField_a_of_type_AndroidGraphicsRect, localapfb.jdField_c_of_type_JavaLangString, paramapen.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      localObject2 = a(paramapen.jdField_b_of_type_AndroidGraphicsRect, ((apfb)localObject2).jdField_a_of_type_AndroidGraphicsRect, ((apfb)localObject2).jdField_c_of_type_JavaLangString, paramapen.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());
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
          if (!paramapen.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
            f1 = -f2;
          }
        }
      }
      localObject1 = ObjectAnimator.ofFloat(paramapen.jdField_a_of_type_AndroidWidgetImageView, "rotation", new float[] { 0.0F, f1 });
      i = localapfb.jdField_a_of_type_Int - 1;
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
      localObjectAnimator.addListener(new apej(this, (ObjectAnimator)localObject1, paramapen));
      return localObjectAnimator;
      l = localObjectAnimator.getDuration();
      break;
      localObject1 = null;
    }
  }
  
  public ObjectAnimator a(apen paramapen, Rect paramRect, apfb paramapfb)
  {
    File localFile = null;
    if (paramapfb == null) {
      return null;
    }
    Object localObject = localFile;
    boolean bool;
    if (paramRect != null)
    {
      localObject = localFile;
      if (paramapfb.jdField_e_of_type_Int == -1)
      {
        if (paramRect != paramapen.jdField_a_of_type_AndroidGraphicsRect) {
          break label326;
        }
        bool = paramapen.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        paramRect = a(paramRect, paramapfb.jdField_a_of_type_AndroidGraphicsRect, paramapfb.jdField_c_of_type_JavaLangString, bool);
        localObject = new apfq(-1, ((Integer)paramRect.first).intValue(), ((Integer)paramRect.second).intValue());
      }
    }
    localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramapfb.jdField_d_of_type_Int, false), paramapfb.jdField_d_of_type_JavaLangString);
    paramRect = new ArrayList();
    int i = 0;
    label130:
    if (i < paramapfb.jdField_b_of_type_Int)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramapfb.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
      apem localapem = new apem();
      localapem.jdField_b_of_type_JavaLangString = str;
      localapem.jdField_a_of_type_JavaLangString = (paramapfb.jdField_a_of_type_JavaLangString + str);
      localapem.jdField_a_of_type_Apen = paramapen;
      localapem.jdField_a_of_type_AndroidGraphicsRect = paramapfb.jdField_a_of_type_AndroidGraphicsRect;
      if (paramapfb.jdField_a_of_type_Boolean) {
        if (paramapen.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
          break label338;
        }
      }
      label326:
      label338:
      for (bool = true;; bool = false)
      {
        localapem.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localapem.jdField_a_of_type_Boolean = paramapen.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        if (paramapfb.jdField_e_of_type_Int == -1) {
          localapem.jdField_a_of_type_Apfq = ((apfq)localObject);
        }
        paramRect.add(localapem);
        i += 1;
        break label130;
        bool = paramapen.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        break;
      }
    }
    paramapen = new Keyframe[paramRect.size() + 1];
    float f = 1.0F / paramRect.size();
    paramapen[0] = Keyframe.ofObject(0.0F, paramRect.get(0));
    i = 0;
    if (i < paramRect.size())
    {
      if (i != paramRect.size() - 1) {
        paramapen[(i + 1)] = Keyframe.ofObject((i + 1) * f, paramRect.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        paramapen[(i + 1)] = Keyframe.ofObject(1.0F, paramRect.get(i));
      }
    }
    paramapen = PropertyValuesHolder.ofKeyframe("bitmapData", paramapen);
    paramapen.setEvaluator(new apeo(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { paramapen }).setDuration(paramRect.size() * paramapfb.jdField_a_of_type_Long);
  }
  
  public ObjectAnimator a(apen paramapen, apfb paramapfb)
  {
    if ((!TextUtils.isEmpty(paramapfb.jdField_e_of_type_JavaLangString)) && (paramapfb.jdField_c_of_type_AndroidGraphicsRect != null))
    {
      localObject1 = a(paramapen.jdField_a_of_type_AndroidGraphicsRect, paramapfb.jdField_c_of_type_AndroidGraphicsRect, paramapfb.jdField_e_of_type_JavaLangString, paramapen.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      if ((TextUtils.isEmpty(paramapfb.f)) || (paramapfb.jdField_d_of_type_AndroidGraphicsRect == null)) {
        break label151;
      }
    }
    for (Object localObject2 = a(paramapen.jdField_b_of_type_AndroidGraphicsRect, paramapfb.jdField_d_of_type_AndroidGraphicsRect, paramapfb.f, paramapen.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());; localObject2 = null)
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        break label206;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "start align: " + paramapfb.jdField_e_of_type_JavaLangString + ", startRect: " + paramapfb.jdField_c_of_type_AndroidGraphicsRect);
      }
      localObject1 = null;
      break;
      label151:
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "end align " + paramapfb.f + ", endRect: " + paramapfb.jdField_d_of_type_AndroidGraphicsRect);
      }
    }
    label206:
    int j = ((Integer)((Pair)localObject1).first).intValue();
    int k = ((Integer)((Pair)localObject1).second).intValue();
    int m = ((Integer)((Pair)localObject2).first).intValue();
    int n = ((Integer)((Pair)localObject2).second).intValue();
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(apfq.b(j, k));
    ((ArrayList)localObject1).add(apfq.a(m, n));
    localObject2 = new apep();
    apem[] arrayOfapem = new apem[((ArrayList)localObject1).size()];
    int i = 0;
    if (i < arrayOfapem.length)
    {
      apem localapem = new apem();
      localapem.jdField_a_of_type_Apen = paramapen;
      localapem.jdField_a_of_type_Apfq = ((apfq)((ArrayList)localObject1).get(i));
      if (paramapfb.jdField_a_of_type_Boolean) {
        if (paramapen.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
          break label427;
        }
      }
      label427:
      for (boolean bool = true;; bool = false)
      {
        localapem.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localapem.jdField_a_of_type_Boolean = paramapen.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        localapem.jdField_b_of_type_Boolean = paramapfb.jdField_b_of_type_Boolean;
        localapem.jdField_a_of_type_AndroidGraphicsRect = paramapfb.jdField_a_of_type_AndroidGraphicsRect;
        arrayOfapem[i] = localapem;
        i += 1;
        break;
      }
    }
    paramapen = ObjectAnimator.ofObject(this, "pathLocation", (TypeEvaluator)localObject2, arrayOfapem);
    paramapen.setDuration(((Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.c * (float)paramapfb.jdField_a_of_type_Long));
    return paramapen;
  }
  
  public Rect a(aezf paramaezf, long paramLong, ListView paramListView)
  {
    int i = paramaezf.jdField_a_of_type_Apee.jdField_a_of_type_Int;
    paramListView = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(i, false);
    if (paramListView == null) {
      return null;
    }
    if ((apfa)paramListView.b.get("animation_start") == null)
    {
      paramListView = paramListView.b.values().iterator();
      while ((paramListView.hasNext()) && ((apfa)paramListView.next() == null)) {}
    }
    paramListView = paramaezf.jdField_a_of_type_AndroidViewView;
    int j = paramListView.getLeft();
    i = paramListView.getTop();
    paramaezf = (View)paramListView.getParent();
    for (;;)
    {
      if ((paramaezf == null) || ((paramaezf instanceof BaseChatItemLayout)))
      {
        paramaezf = new Rect();
        paramaezf.left = (BaseChatItemLayout.j + j);
        paramaezf.right = (paramListView.getRight() - paramListView.getLeft() + j - BaseChatItemLayout.j);
        paramaezf.top = (BaseChatItemLayout.h + i);
        paramaezf.bottom = (paramListView.getBottom() - paramListView.getTop() + i - BaseChatItemLayout.i);
        return paramaezf;
      }
      j += paramaezf.getLeft();
      i += paramaezf.getTop();
      paramaezf = paramaezf.getParent();
      if ((paramaezf instanceof View)) {
        paramaezf = (View)paramaezf;
      } else {
        paramaezf = null;
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
  
  public apen a(long paramLong1, long paramLong2)
  {
    Object localObject1 = AIOUtils.getHolder(AIOUtils.getViewByPostion(this.jdField_a_of_type_ComTencentWidgetListView, AIOUtils.findMessagePosition(paramLong1, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter())));
    if ((localObject1 instanceof aezf)) {}
    for (localObject1 = (aezf)localObject1;; localObject1 = null)
    {
      Object localObject2 = AIOUtils.getHolder(AIOUtils.getViewByPostion(this.jdField_a_of_type_ComTencentWidgetListView, AIOUtils.findMessagePosition(paramLong2, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter())));
      if ((localObject2 instanceof aezf)) {}
      for (localObject2 = (aezf)localObject2;; localObject2 = null)
      {
        if ((localObject1 == null) || (localObject2 == null) || (((aezf)localObject1).jdField_a_of_type_Apee == null) || (((aezf)localObject2).jdField_a_of_type_Apee == null)) {}
        apeb localapeb;
        do
        {
          return null;
          i = ((aezf)localObject1).jdField_a_of_type_Apee.jdField_a_of_type_Int;
          int j = ((aezf)localObject2).jdField_a_of_type_Apee.jdField_a_of_type_Int;
          localapeb = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(i, false);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(j, false);
        } while ((localapeb == null) || (localObject3 == null) || (localapeb.b == null) || (((apeb)localObject3).b == null));
        apfa localapfa1 = (apfa)localapeb.b.get("animation_start");
        apfa localapfa2 = (apfa)((apeb)localObject3).b.get("passive_animation");
        if (localapfa1 == null)
        {
          QLog.e("BubbleInterActiveAnim", 1, "can't find mInterActiveAnims from bubbleId: " + i);
          return null;
        }
        Object localObject3 = new apen();
        ((apen)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((aezf)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        ((apen)localObject3).jdField_b_of_type_ComTencentMobileqqDataMessageRecord = ((aezf)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        ((apen)localObject3).jdField_a_of_type_JavaUtilHashMap = new HashMap(localapeb.b);
        ((apen)localObject3).jdField_a_of_type_JavaUtilHashMap.put("passive_animation", localapfa2);
        ((apen)localObject3).jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
        ((apen)localObject3).jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ((apen)localObject3).jdField_a_of_type_AndroidWidgetImageView.layout(0, 0, localapfa1.jdField_a_of_type_AndroidGraphicsRect.right, localapfa1.jdField_a_of_type_AndroidGraphicsRect.bottom);
        ((apen)localObject3).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        ((apen)localObject3).jdField_a_of_type_AndroidGraphicsRect = a((aezf)localObject1, paramLong1, this.jdField_a_of_type_ComTencentWidgetListView);
        ((apen)localObject3).jdField_b_of_type_AndroidGraphicsRect = a((aezf)localObject2, paramLong2, this.jdField_a_of_type_ComTencentWidgetListView);
        localObject2 = (View)((aezf)localObject2).jdField_a_of_type_AndroidViewView.getParent();
        int i = ((View)((aezf)localObject1).jdField_a_of_type_AndroidViewView.getParent()).getTop() - ((View)localObject2).getTop();
        localObject2 = ((apen)localObject3).jdField_b_of_type_AndroidGraphicsRect;
        ((Rect)localObject2).top -= i;
        localObject2 = ((apen)localObject3).jdField_b_of_type_AndroidGraphicsRect;
        ((Rect)localObject2).bottom -= i;
        ((apen)localObject3).jdField_a_of_type_AndroidViewView = ((aezf)localObject1).jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localObject3);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(((apen)localObject3).jdField_a_of_type_AndroidWidgetImageView);
        ((apen)localObject3).jdField_a_of_type_Long = paramLong1;
        ((apen)localObject3).jdField_b_of_type_Long = paramLong2;
        return localObject3;
      }
    }
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      apen localapen = (apen)localIterator.next();
      if ((localapen != null) && (localapen.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "add delta " + paramInt + " for seq: " + localapen.jdField_a_of_type_Long);
        }
        localapen.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(localapen.jdField_a_of_type_AndroidWidgetImageView.getTranslationY() + paramInt);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ThreadManager.post(new BubbleInterActiveAnim.2(this, paramLong1, paramLong2), 5, null, true);
  }
  
  public void a(apen paramapen)
  {
    paramapen.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeView(paramapen.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramapen.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
      d();
    }
  }
  
  public void a(apfa paramapfa, int paramInt)
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramInt, false), paramapfa.jdField_d_of_type_JavaLangString);
    paramInt = 0;
    if (paramInt < paramapfa.jdField_b_of_type_Int)
    {
      Object localObject1 = localFile.getAbsolutePath() + File.separatorChar + paramapfa.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(paramInt + 1) });
      String str = paramapfa.jdField_a_of_type_JavaLangString + (String)localObject1;
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
      apen localapen = (apen)localIterator.next();
      if ((localapen != null) && (localapen.jdField_a_of_type_AndroidViewView != null))
      {
        paramInt1 = AIOUtils.findMessagePosition(localapen.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
        paramInt2 = AIOUtils.findMessagePosition(localapen.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
        Object localObject2 = AIOUtils.getHolder(AIOUtils.getViewByPostion(this.jdField_a_of_type_ComTencentWidgetListView, paramInt1));
        Object localObject1 = AIOUtils.getHolder(AIOUtils.getViewByPostion(this.jdField_a_of_type_ComTencentWidgetListView, paramInt2));
        if ((localObject2 != null) && ((localObject2 instanceof aezf)))
        {
          localObject2 = (aezf)localObject2;
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "refresh seq " + localapen.jdField_a_of_type_Long + " 's bubbleView");
          }
          localapen.jdField_a_of_type_AndroidViewView = ((aezf)localObject2).jdField_a_of_type_AndroidViewView;
          localapen.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((aezf)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        }
        for (;;)
        {
          if ((localObject1 == null) || (!(localObject1 instanceof aezf))) {
            break label314;
          }
          localObject1 = (aezf)localObject1;
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "refresh seq " + localapen.jdField_b_of_type_Long + " 's bubbleView");
          }
          localapen.jdField_b_of_type_ComTencentMobileqqDataMessageRecord = ((aezf)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          break;
          if (QLog.isColorLevel()) {
            QLog.w("BubbleInterActiveAnim", 2, "stop current bubble animation! " + localapen.jdField_a_of_type_Long);
          }
          localapen.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
        }
        label314:
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "stop current bubble animation! " + localapen.jdField_b_of_type_Long);
        }
        localapen.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
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
        break label287;
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
      label287:
      localObject = null;
    }
  }
  
  public ObjectAnimator b(apen paramapen)
  {
    Object localObject1 = (apfa)paramapen.jdField_a_of_type_JavaUtilHashMap.get("animation_running");
    if (!(localObject1 instanceof apfb)) {
      return null;
    }
    Object localObject2 = (apfb)localObject1;
    if (((apfb)localObject2).jdField_e_of_type_Int == -1) {
      return null;
    }
    if (((apfb)localObject2).jdField_e_of_type_Int == 0) {}
    for (localObject1 = a(paramapen, (apfb)localObject2);; localObject1 = b(paramapen, (apfb)localObject2))
    {
      localObject2 = a(paramapen, paramapen.jdField_a_of_type_AndroidGraphicsRect, (apfb)localObject2);
      if ((localObject1 != null) && (localObject2 != null)) {
        break;
      }
      return null;
    }
    ((ObjectAnimator)localObject2).setDuration(((ObjectAnimator)localObject2).getDuration() / 2L);
    ((ObjectAnimator)localObject2).setRepeatCount(-1);
    ((ObjectAnimator)localObject1).addListener(new apek(this, paramapen, (ObjectAnimator)localObject2));
    return localObject1;
  }
  
  public ObjectAnimator b(apen paramapen, apfb paramapfb)
  {
    float f4 = 0.0F;
    Object localObject1;
    if ((!TextUtils.isEmpty(paramapfb.jdField_e_of_type_JavaLangString)) && (paramapfb.jdField_c_of_type_AndroidGraphicsRect != null))
    {
      localObject1 = a(paramapen.jdField_a_of_type_AndroidGraphicsRect, paramapfb.jdField_c_of_type_AndroidGraphicsRect, paramapfb.jdField_e_of_type_JavaLangString, paramapen.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      if ((TextUtils.isEmpty(paramapfb.f)) || (paramapfb.jdField_d_of_type_AndroidGraphicsRect == null)) {
        break label154;
      }
    }
    for (Object localObject2 = a(paramapen.jdField_b_of_type_AndroidGraphicsRect, paramapfb.jdField_d_of_type_AndroidGraphicsRect, paramapfb.f, paramapen.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());; localObject2 = null)
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        break label209;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "start align: " + paramapfb.jdField_e_of_type_JavaLangString + ", startRect: " + paramapfb.jdField_c_of_type_AndroidGraphicsRect);
      }
      localObject1 = null;
      break;
      label154:
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "end align " + paramapfb.f + ", endRect: " + paramapfb.jdField_d_of_type_AndroidGraphicsRect);
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
    if (paramapfb.jdField_e_of_type_Int == 1)
    {
      f1 = (m - j) * 0.25F + j;
      f2 = (n - k) * 0.1F + k;
      f3 = (m - j) * 0.25F + j;
      f4 = (n - k) * 1.0F + k;
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(apfq.b(j, k));
      ((ArrayList)localObject1).add(apfq.a(f1, f2, f3, f4, m, n));
      localObject2 = new apem[((ArrayList)localObject1).size()];
      int i = 0;
      label389:
      if (i < localObject2.length)
      {
        apem localapem = new apem();
        localapem.jdField_a_of_type_Apen = paramapen;
        localapem.jdField_a_of_type_Apfq = ((apfq)((ArrayList)localObject1).get(i));
        if (paramapfb.jdField_a_of_type_Boolean) {
          if (paramapen.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
            break label575;
          }
        }
        label575:
        for (boolean bool = true;; bool = false)
        {
          localapem.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
          localapem.jdField_a_of_type_Boolean = paramapen.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
          localapem.jdField_a_of_type_AndroidGraphicsRect = paramapfb.jdField_a_of_type_AndroidGraphicsRect;
          localapem.jdField_b_of_type_Boolean = paramapfb.jdField_b_of_type_Boolean;
          localObject2[i] = localapem;
          i += 1;
          break label389;
          if (paramapfb.jdField_e_of_type_Int != 2) {
            break label647;
          }
          f1 = (m - j) * 0.1F + j;
          f2 = (n - k) * 0.25F + k;
          f3 = (m - j) * 1.0F + j;
          f4 = (n - k) * 0.25F + k;
          break;
        }
      }
      paramapen = ObjectAnimator.ofObject(this, "pathLocation", new apep(), (Object[])localObject2);
      paramapen.setDuration(((Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.c * (float)paramapfb.jdField_a_of_type_Long * 3.141592653589793D * 0.6000000238418579D));
      return paramapen;
      label647:
      f3 = 0.0F;
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    apen localapen = a(paramLong1, paramLong2);
    ObjectAnimator localObjectAnimator1;
    if (localapen != null)
    {
      localObjectAnimator1 = a(localapen);
      if (localObjectAnimator1 == null) {
        QLog.e("BubbleInterActiveAnim", 1, "startAnimator is null");
      }
    }
    else
    {
      return;
    }
    ObjectAnimator localObjectAnimator2 = b(localapen);
    if (localObjectAnimator2 == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "runningAnimator is null");
      return;
    }
    Object localObject = (apfb)localapen.jdField_a_of_type_JavaUtilHashMap.get("animation_end");
    ObjectAnimator localObjectAnimator3 = a(localapen, localapen.jdField_b_of_type_AndroidGraphicsRect, (apfb)localObject);
    if (localObjectAnimator3 == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "endAnimator is null");
      return;
    }
    localObjectAnimator3.setRepeatCount(((apfb)localObject).jdField_a_of_type_Int - 1);
    localObject = c(localapen);
    if (localObject == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
      return;
    }
    localapen.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObject });
    localapen.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new apei(this, localapen));
    this.jdField_a_of_type_AndroidOsHandler.post(new BubbleInterActiveAnim.4(this, localapen));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localapen);
  }
  
  public ObjectAnimator c(apen paramapen)
  {
    apfb localapfb = (apfb)paramapen.jdField_a_of_type_JavaUtilHashMap.get("passive_animation");
    ObjectAnimator localObjectAnimator = a(paramapen, paramapen.jdField_b_of_type_AndroidGraphicsRect, localapfb);
    if (localObjectAnimator == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
      return null;
    }
    localObjectAnimator.setRepeatCount(localapfb.jdField_a_of_type_Int - 1);
    localObjectAnimator.addListener(new apel(this, paramapen));
    return localObjectAnimator;
  }
  
  protected void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      apen localapen = (apen)localIterator.next();
      if ((localapen != null) && (localapen.jdField_a_of_type_AndroidWidgetImageView != null)) {
        localapen.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      }
    }
  }
  
  public void setBitmapData(apem paramapem)
  {
    if ((paramapem == null) || (paramapem.jdField_a_of_type_Apen == null)) {}
    do
    {
      do
      {
        return;
        if ((paramapem.jdField_a_of_type_Apfq != null) && (paramapem.jdField_a_of_type_Apfq.jdField_a_of_type_Int == -1)) {
          setPathLocation(paramapem);
        }
        float f = paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView.getTranslationY();
        if ((f < this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()) || (f > this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int))
        {
          QLog.w("BubbleInterActiveAnim", 1, String.format("setBitmapData: now scroll over screen, stop bubble animator set!, y: %d, up: %d, download: %d", new Object[] { Integer.valueOf((int)f), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int) }));
          this.jdField_a_of_type_AndroidOsHandler.post(new BubbleInterActiveAnim.8(this, paramapem));
          return;
        }
      } while (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramapem.jdField_a_of_type_JavaLangString));
      if (paramapem.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        localObject = new apea(paramapem.jdField_a_of_type_AndroidGraphicsBitmap);
        ((apea)localObject).jdField_a_of_type_Boolean = paramapem.jdField_a_of_type_JavaLangBoolean.booleanValue();
        paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
        this.jdField_a_of_type_JavaLangString = paramapem.jdField_a_of_type_JavaLangString;
        paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView.invalidate();
        return;
      }
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramapem.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = (Bitmap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramapem.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    Object localObject = new apea((Bitmap)localObject);
    ((apea)localObject).jdField_a_of_type_Boolean = paramapem.jdField_a_of_type_JavaLangBoolean.booleanValue();
    paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_JavaLangString = paramapem.jdField_a_of_type_JavaLangString;
    paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView.invalidate();
    return;
    QLog.e("BubbleInterActiveAnim", 1, "can't find bitmap, path: " + paramapem.jdField_a_of_type_JavaLangString);
  }
  
  public void setPathLocation(apem paramapem)
  {
    if ((paramapem == null) || (paramapem.jdField_a_of_type_Apen == null) || (paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    if ((paramapem.jdField_a_of_type_AndroidGraphicsRect != null) && (paramapem.jdField_a_of_type_AndroidGraphicsRect.right != 0) && (paramapem.jdField_a_of_type_AndroidGraphicsRect.bottom != 0) && ((paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView.getWidth() != paramapem.jdField_a_of_type_AndroidGraphicsRect.right) || (paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView.getHeight() != paramapem.jdField_a_of_type_AndroidGraphicsRect.bottom)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "change anim view size:  to " + paramapem.jdField_a_of_type_AndroidGraphicsRect.right + "-" + paramapem.jdField_a_of_type_AndroidGraphicsRect.bottom + ", view width-height: " + paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView.getWidth() + "-" + paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView.getHeight());
      }
      paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView.layout(0, 0, paramapem.jdField_a_of_type_AndroidGraphicsRect.right, paramapem.jdField_a_of_type_AndroidGraphicsRect.bottom);
    }
    if (paramapem.jdField_a_of_type_Apfq.jdField_a_of_type_Int != -1)
    {
      if (paramapem.jdField_a_of_type_Apfq.c != 360.0F) {
        break label459;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "reset animView rotate to 0!");
      }
      paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView.setRotation(0.0F);
    }
    int i;
    int j;
    float f1;
    float f3;
    float f2;
    for (;;)
    {
      localObject = (View)paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidViewView.getParent();
      i = 0;
      j = 0;
      if ((localObject != null) && (((View)localObject).getParent() != this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getParent())) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
      f1 = paramapem.jdField_a_of_type_Apfq.jdField_a_of_type_Float;
      f3 = paramapem.jdField_a_of_type_Apfq.b;
      float f4 = this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
      f2 = i;
      f3 = j + (f3 - f4);
      if ((f3 >= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()) && (f3 <= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int)) {
        break label589;
      }
      QLog.w("BubbleInterActiveAnim", 1, String.format("setPathLocation: now scroll over screen, stop bubble animator set!, y: %d, up: %d, down: %d", new Object[] { Integer.valueOf((int)f3), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int) }));
      this.jdField_a_of_type_AndroidOsHandler.post(new BubbleInterActiveAnim.9(this, paramapem));
      return;
      label459:
      if (paramapem.jdField_a_of_type_Apfq.c != 0.0F)
      {
        paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView.setRotation(paramapem.jdField_a_of_type_Apfq.c);
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "set animView rotate to " + paramapem.jdField_a_of_type_Apfq.c);
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
    paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(f2 + f1);
    paramapem.jdField_a_of_type_Apen.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(f3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apeg
 * JD-Core Version:    0.7.0.1
 */