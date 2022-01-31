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
public class anwq
  extends aeun
{
  public Handler a;
  public BubbleManager a;
  public String a;
  public List<View> a;
  public ConcurrentHashMap<Long, anwx> a;
  public int b;
  public List<AnimatorSet> b;
  public ConcurrentHashMap<String, Bitmap> b;
  public int c;
  public int d;
  
  public anwq(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidOsHandler = new anwr(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = aepi.a(12.0F, paramListView.getContext().getResources());
    this.c = aepi.a(50.0F, paramListView.getContext().getResources());
    this.jdField_d_of_type_Int = aepi.a(45.0F, paramListView.getContext().getResources());
  }
  
  public static long a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {}
    for (String str = a(paramMessageRecord);; str = null)
    {
      BubbleManager localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(44);
      anwl localanwl = localBubbleManager.a((int)paramMessageRecord.vipBubbleID, false);
      long l3;
      if ((localanwl == null) || (localanwl.b == null))
      {
        l3 = -1L;
        return l3;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "bubble config mInterActivePackageID: " + localanwl.f + ", bubble mInterActiveType: " + localanwl.g);
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
        paramQQAppInterface = aepi.a(aepi.a(paramAIOAnimationConatiner.a(), k));
        if ((paramQQAppInterface instanceof aeqi))
        {
          paramQQAppInterface = (aeqi)paramQQAppInterface;
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
          if (paramQQAppInterface.jdField_a_of_type_Anwo == null) {
            break label1006;
          }
          paramQQAppInterface = a((MessageRecord)localObject1);
          localObject2 = localBubbleManager.a((int)((ChatMessage)localObject1).vipBubbleID, false);
          if ((localObject2 != null) && (((anwl)localObject2).b != null)) {
            break label423;
          }
          QLog.e("BubbleInterActiveAnim", 1, "get bubbleConfig is null: " + (int)((ChatMessage)localObject1).vipBubbleID);
        }
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "record seq: " + ((ChatMessage)localObject1).uniseq + ", other bubble config mInterActivePackageID: " + ((anwl)localObject2).f + ", other bubble config mInterActiveType: " + ((anwl)localObject2).g);
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
          if (localanwl.f == -1) {
            break label497;
          }
          i = m;
          if (((anwl)localObject2).f == -1) {
            break label497;
          }
          if (localanwl.g == 3)
          {
            if ((((anwl)localObject2).g == 2) && (((anwl)localObject2).f != localanwl.f))
            {
              i = 1;
              break label497;
            }
            i = m;
            if (((anwl)localObject2).g != 3) {
              break label497;
            }
            i = 1;
            break label497;
          }
          if (localanwl.g == 1)
          {
            if ((localanwl.f == ((anwl)localObject2).f) && (localanwl.g == ((anwl)localObject2).g))
            {
              i = 1;
              break label497;
            }
            i = 0;
            break label497;
          }
          i = m;
          if (localanwl.g != 2) {
            break label497;
          }
          if (((anwl)localObject2).g != 2)
          {
            i = m;
            if (((anwl)localObject2).g != 3) {
              break label497;
            }
          }
          if (((anwl)localObject2).f != localanwl.f)
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
      if ((localListAdapter instanceof bhxm))
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
        if (!(localListAdapter instanceof aeqo)) {
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
  
  public ObjectAnimator a(anwx paramanwx)
  {
    anxl localanxl = (anxl)paramanwx.jdField_a_of_type_JavaUtilHashMap.get("animation_start");
    ObjectAnimator localObjectAnimator = a(paramanwx, paramanwx.jdField_a_of_type_AndroidGraphicsRect, localanxl);
    localObjectAnimator.setRepeatCount(localanxl.jdField_a_of_type_Int - 1);
    Object localObject1;
    long l;
    if (((anxl)paramanwx.jdField_a_of_type_JavaUtilHashMap.get("animation_running")).jdField_b_of_type_Boolean)
    {
      Object localObject2 = (anxl)paramanwx.jdField_a_of_type_JavaUtilHashMap.get("animation_end");
      localObject1 = a(paramanwx.jdField_a_of_type_AndroidGraphicsRect, localanxl.jdField_a_of_type_AndroidGraphicsRect, localanxl.jdField_c_of_type_JavaLangString, paramanwx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      localObject2 = a(paramanwx.jdField_b_of_type_AndroidGraphicsRect, ((anxl)localObject2).jdField_a_of_type_AndroidGraphicsRect, ((anxl)localObject2).jdField_c_of_type_JavaLangString, paramanwx.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());
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
          if (!paramanwx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
            f1 = -f2;
          }
        }
      }
      localObject1 = ObjectAnimator.ofFloat(paramanwx.jdField_a_of_type_AndroidWidgetImageView, "rotation", new float[] { 0.0F, f1 });
      i = localanxl.jdField_a_of_type_Int - 1;
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
      localObjectAnimator.addListener(new anwt(this, (ObjectAnimator)localObject1, paramanwx));
      return localObjectAnimator;
      l = localObjectAnimator.getDuration();
      break;
      localObject1 = null;
    }
  }
  
  public ObjectAnimator a(anwx paramanwx, Rect paramRect, anxl paramanxl)
  {
    File localFile = null;
    if (paramanxl == null) {
      return null;
    }
    Object localObject = localFile;
    boolean bool;
    if (paramRect != null)
    {
      localObject = localFile;
      if (paramanxl.jdField_e_of_type_Int == -1)
      {
        if (paramRect != paramanwx.jdField_a_of_type_AndroidGraphicsRect) {
          break label326;
        }
        bool = paramanwx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        paramRect = a(paramRect, paramanxl.jdField_a_of_type_AndroidGraphicsRect, paramanxl.jdField_c_of_type_JavaLangString, bool);
        localObject = new anya(-1, ((Integer)paramRect.first).intValue(), ((Integer)paramRect.second).intValue());
      }
    }
    localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramanxl.jdField_d_of_type_Int, false), paramanxl.jdField_d_of_type_JavaLangString);
    paramRect = new ArrayList();
    int i = 0;
    label130:
    if (i < paramanxl.jdField_b_of_type_Int)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramanxl.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
      anww localanww = new anww();
      localanww.jdField_b_of_type_JavaLangString = str;
      localanww.jdField_a_of_type_JavaLangString = (paramanxl.jdField_a_of_type_JavaLangString + str);
      localanww.jdField_a_of_type_Anwx = paramanwx;
      localanww.jdField_a_of_type_AndroidGraphicsRect = paramanxl.jdField_a_of_type_AndroidGraphicsRect;
      if (paramanxl.jdField_a_of_type_Boolean) {
        if (paramanwx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
          break label338;
        }
      }
      label326:
      label338:
      for (bool = true;; bool = false)
      {
        localanww.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localanww.jdField_a_of_type_Boolean = paramanwx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        if (paramanxl.jdField_e_of_type_Int == -1) {
          localanww.jdField_a_of_type_Anya = ((anya)localObject);
        }
        paramRect.add(localanww);
        i += 1;
        break label130;
        bool = paramanwx.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        break;
      }
    }
    paramanwx = new Keyframe[paramRect.size() + 1];
    float f = 1.0F / paramRect.size();
    paramanwx[0] = Keyframe.ofObject(0.0F, paramRect.get(0));
    i = 0;
    if (i < paramRect.size())
    {
      if (i != paramRect.size() - 1) {
        paramanwx[(i + 1)] = Keyframe.ofObject((i + 1) * f, paramRect.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        paramanwx[(i + 1)] = Keyframe.ofObject(1.0F, paramRect.get(i));
      }
    }
    paramanwx = PropertyValuesHolder.ofKeyframe("bitmapData", paramanwx);
    paramanwx.setEvaluator(new anwy(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { paramanwx }).setDuration(paramRect.size() * paramanxl.jdField_a_of_type_Long);
  }
  
  public ObjectAnimator a(anwx paramanwx, anxl paramanxl)
  {
    if ((!TextUtils.isEmpty(paramanxl.jdField_e_of_type_JavaLangString)) && (paramanxl.jdField_c_of_type_AndroidGraphicsRect != null))
    {
      localObject1 = a(paramanwx.jdField_a_of_type_AndroidGraphicsRect, paramanxl.jdField_c_of_type_AndroidGraphicsRect, paramanxl.jdField_e_of_type_JavaLangString, paramanwx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      if ((TextUtils.isEmpty(paramanxl.f)) || (paramanxl.jdField_d_of_type_AndroidGraphicsRect == null)) {
        break label150;
      }
    }
    for (Object localObject2 = a(paramanwx.jdField_b_of_type_AndroidGraphicsRect, paramanxl.jdField_d_of_type_AndroidGraphicsRect, paramanxl.f, paramanwx.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());; localObject2 = null)
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        break label204;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "start align: " + paramanxl.jdField_e_of_type_JavaLangString + ", startRect: " + paramanxl.jdField_c_of_type_AndroidGraphicsRect);
      }
      localObject1 = null;
      break;
      label150:
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "end align " + paramanxl.f + ", endRect: " + paramanxl.jdField_d_of_type_AndroidGraphicsRect);
      }
    }
    label204:
    int j = ((Integer)((Pair)localObject1).first).intValue();
    int k = ((Integer)((Pair)localObject1).second).intValue();
    int m = ((Integer)((Pair)localObject2).first).intValue();
    int n = ((Integer)((Pair)localObject2).second).intValue();
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(anya.b(j, k));
    ((ArrayList)localObject1).add(anya.a(m, n));
    localObject2 = new anwz();
    anww[] arrayOfanww = new anww[((ArrayList)localObject1).size()];
    int i = 0;
    if (i < arrayOfanww.length)
    {
      anww localanww = new anww();
      localanww.jdField_a_of_type_Anwx = paramanwx;
      localanww.jdField_a_of_type_Anya = ((anya)((ArrayList)localObject1).get(i));
      if (paramanxl.jdField_a_of_type_Boolean) {
        if (paramanwx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
          break label425;
        }
      }
      label425:
      for (boolean bool = true;; bool = false)
      {
        localanww.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localanww.jdField_a_of_type_Boolean = paramanwx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
        localanww.jdField_b_of_type_Boolean = paramanxl.jdField_b_of_type_Boolean;
        localanww.jdField_a_of_type_AndroidGraphicsRect = paramanxl.jdField_a_of_type_AndroidGraphicsRect;
        arrayOfanww[i] = localanww;
        i += 1;
        break;
      }
    }
    paramanwx = ObjectAnimator.ofObject(this, "pathLocation", (TypeEvaluator)localObject2, arrayOfanww);
    paramanwx.setDuration(((Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.c * (float)paramanxl.jdField_a_of_type_Long));
    return paramanwx;
  }
  
  public Rect a(aeqi paramaeqi, long paramLong, ListView paramListView)
  {
    int i = paramaeqi.jdField_a_of_type_Anwo.jdField_a_of_type_Int;
    paramListView = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(i, false);
    if (paramListView == null) {
      return null;
    }
    if ((anxk)paramListView.b.get("animation_start") == null)
    {
      paramListView = paramListView.b.values().iterator();
      while ((paramListView.hasNext()) && ((anxk)paramListView.next() == null)) {}
    }
    paramListView = paramaeqi.jdField_a_of_type_AndroidViewView;
    int j = paramListView.getLeft();
    i = paramListView.getTop();
    paramaeqi = (View)paramListView.getParent();
    for (;;)
    {
      if ((paramaeqi == null) || ((paramaeqi instanceof BaseChatItemLayout)))
      {
        paramaeqi = new Rect();
        paramaeqi.left = (BaseChatItemLayout.i + j);
        paramaeqi.right = (paramListView.getRight() - paramListView.getLeft() + j - BaseChatItemLayout.i);
        paramaeqi.top = (BaseChatItemLayout.g + i);
        paramaeqi.bottom = (paramListView.getBottom() - paramListView.getTop() + i - BaseChatItemLayout.h);
        return paramaeqi;
      }
      j += paramaeqi.getLeft();
      i += paramaeqi.getTop();
      paramaeqi = paramaeqi.getParent();
      if ((paramaeqi instanceof View)) {
        paramaeqi = (View)paramaeqi;
      } else {
        paramaeqi = null;
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
  
  public anwx a(long paramLong1, long paramLong2)
  {
    Object localObject1 = aepi.a(aepi.a(this.jdField_a_of_type_ComTencentWidgetListView, aepi.a(paramLong1, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter())));
    if ((localObject1 instanceof aeqi)) {}
    for (localObject1 = (aeqi)localObject1;; localObject1 = null)
    {
      Object localObject2 = aepi.a(aepi.a(this.jdField_a_of_type_ComTencentWidgetListView, aepi.a(paramLong2, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter())));
      if ((localObject2 instanceof aeqi)) {}
      for (localObject2 = (aeqi)localObject2;; localObject2 = null)
      {
        if ((localObject1 == null) || (localObject2 == null) || (((aeqi)localObject1).jdField_a_of_type_Anwo == null) || (((aeqi)localObject2).jdField_a_of_type_Anwo == null)) {}
        anwl localanwl;
        do
        {
          return null;
          i = ((aeqi)localObject1).jdField_a_of_type_Anwo.jdField_a_of_type_Int;
          int j = ((aeqi)localObject2).jdField_a_of_type_Anwo.jdField_a_of_type_Int;
          localanwl = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(i, false);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(j, false);
        } while ((localanwl == null) || (localObject3 == null) || (localanwl.b == null) || (((anwl)localObject3).b == null));
        anxk localanxk1 = (anxk)localanwl.b.get("animation_start");
        anxk localanxk2 = (anxk)((anwl)localObject3).b.get("passive_animation");
        if (localanxk1 == null)
        {
          QLog.e("BubbleInterActiveAnim", 1, "can't find mInterActiveAnims from bubbleId: " + i);
          return null;
        }
        Object localObject3 = new anwx();
        ((anwx)localObject3).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((aeqi)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        ((anwx)localObject3).jdField_b_of_type_ComTencentMobileqqDataMessageRecord = ((aeqi)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        ((anwx)localObject3).jdField_a_of_type_JavaUtilHashMap = new HashMap(localanwl.b);
        ((anwx)localObject3).jdField_a_of_type_JavaUtilHashMap.put("passive_animation", localanxk2);
        ((anwx)localObject3).jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
        ((anwx)localObject3).jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ((anwx)localObject3).jdField_a_of_type_AndroidWidgetImageView.layout(0, 0, localanxk1.jdField_a_of_type_AndroidGraphicsRect.right, localanxk1.jdField_a_of_type_AndroidGraphicsRect.bottom);
        ((anwx)localObject3).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        ((anwx)localObject3).jdField_a_of_type_AndroidGraphicsRect = a((aeqi)localObject1, paramLong1, this.jdField_a_of_type_ComTencentWidgetListView);
        ((anwx)localObject3).jdField_b_of_type_AndroidGraphicsRect = a((aeqi)localObject2, paramLong2, this.jdField_a_of_type_ComTencentWidgetListView);
        localObject2 = (View)((aeqi)localObject2).jdField_a_of_type_AndroidViewView.getParent();
        int i = ((View)((aeqi)localObject1).jdField_a_of_type_AndroidViewView.getParent()).getTop() - ((View)localObject2).getTop();
        localObject2 = ((anwx)localObject3).jdField_b_of_type_AndroidGraphicsRect;
        ((Rect)localObject2).top -= i;
        localObject2 = ((anwx)localObject3).jdField_b_of_type_AndroidGraphicsRect;
        ((Rect)localObject2).bottom -= i;
        ((anwx)localObject3).jdField_a_of_type_AndroidViewView = ((aeqi)localObject1).jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localObject3);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(((anwx)localObject3).jdField_a_of_type_AndroidWidgetImageView);
        ((anwx)localObject3).jdField_a_of_type_Long = paramLong1;
        ((anwx)localObject3).jdField_b_of_type_Long = paramLong2;
        return localObject3;
      }
    }
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      anwx localanwx = (anwx)localIterator.next();
      if ((localanwx != null) && (localanwx.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "add delta " + paramInt + " for seq: " + localanwx.jdField_a_of_type_Long);
        }
        localanwx.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(localanwx.jdField_a_of_type_AndroidWidgetImageView.getTranslationY() + paramInt);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ThreadManager.post(new BubbleInterActiveAnim.2(this, paramLong1, paramLong2), 5, null, true);
  }
  
  public void a(anwx paramanwx)
  {
    paramanwx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeView(paramanwx.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramanwx.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
      d();
    }
  }
  
  public void a(anxk paramanxk, int paramInt)
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramInt, false), paramanxk.jdField_d_of_type_JavaLangString);
    paramInt = 0;
    if (paramInt < paramanxk.jdField_b_of_type_Int)
    {
      Object localObject1 = localFile.getAbsolutePath() + File.separatorChar + paramanxk.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(paramInt + 1) });
      String str = paramanxk.jdField_a_of_type_JavaLangString + (String)localObject1;
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
      anwx localanwx = (anwx)localIterator.next();
      if ((localanwx != null) && (localanwx.jdField_a_of_type_AndroidViewView != null))
      {
        paramInt1 = aepi.a(localanwx.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
        paramInt2 = aepi.a(localanwx.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
        Object localObject2 = aepi.a(aepi.a(this.jdField_a_of_type_ComTencentWidgetListView, paramInt1));
        Object localObject1 = aepi.a(aepi.a(this.jdField_a_of_type_ComTencentWidgetListView, paramInt2));
        if ((localObject2 != null) && ((localObject2 instanceof aeqi)))
        {
          localObject2 = (aeqi)localObject2;
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "refresh seq " + localanwx.jdField_a_of_type_Long + " 's bubbleView");
          }
          localanwx.jdField_a_of_type_AndroidViewView = ((aeqi)localObject2).jdField_a_of_type_AndroidViewView;
          localanwx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((aeqi)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        }
        for (;;)
        {
          if ((localObject1 == null) || (!(localObject1 instanceof aeqi))) {
            break label311;
          }
          localObject1 = (aeqi)localObject1;
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "refresh seq " + localanwx.jdField_b_of_type_Long + " 's bubbleView");
          }
          localanwx.jdField_b_of_type_ComTencentMobileqqDataMessageRecord = ((aeqi)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          break;
          if (QLog.isColorLevel()) {
            QLog.w("BubbleInterActiveAnim", 2, "stop current bubble animation! " + localanwx.jdField_a_of_type_Long);
          }
          localanwx.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
        }
        label311:
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "stop current bubble animation! " + localanwx.jdField_b_of_type_Long);
        }
        localanwx.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
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
  
  public ObjectAnimator b(anwx paramanwx)
  {
    Object localObject1 = (anxk)paramanwx.jdField_a_of_type_JavaUtilHashMap.get("animation_running");
    if (!(localObject1 instanceof anxl)) {
      return null;
    }
    Object localObject2 = (anxl)localObject1;
    if (((anxl)localObject2).jdField_e_of_type_Int == -1) {
      return null;
    }
    if (((anxl)localObject2).jdField_e_of_type_Int == 0) {}
    for (localObject1 = a(paramanwx, (anxl)localObject2);; localObject1 = b(paramanwx, (anxl)localObject2))
    {
      localObject2 = a(paramanwx, paramanwx.jdField_a_of_type_AndroidGraphicsRect, (anxl)localObject2);
      if ((localObject1 != null) && (localObject2 != null)) {
        break;
      }
      return null;
    }
    ((ObjectAnimator)localObject2).setDuration(((ObjectAnimator)localObject2).getDuration() / 2L);
    ((ObjectAnimator)localObject2).setRepeatCount(-1);
    ((ObjectAnimator)localObject1).addListener(new anwu(this, paramanwx, (ObjectAnimator)localObject2));
    return localObject1;
  }
  
  public ObjectAnimator b(anwx paramanwx, anxl paramanxl)
  {
    float f4 = 0.0F;
    Object localObject1;
    if ((!TextUtils.isEmpty(paramanxl.jdField_e_of_type_JavaLangString)) && (paramanxl.jdField_c_of_type_AndroidGraphicsRect != null))
    {
      localObject1 = a(paramanwx.jdField_a_of_type_AndroidGraphicsRect, paramanxl.jdField_c_of_type_AndroidGraphicsRect, paramanxl.jdField_e_of_type_JavaLangString, paramanwx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
      if ((TextUtils.isEmpty(paramanxl.f)) || (paramanxl.jdField_d_of_type_AndroidGraphicsRect == null)) {
        break label153;
      }
    }
    for (Object localObject2 = a(paramanwx.jdField_b_of_type_AndroidGraphicsRect, paramanxl.jdField_d_of_type_AndroidGraphicsRect, paramanxl.f, paramanwx.jdField_b_of_type_ComTencentMobileqqDataMessageRecord.isSend());; localObject2 = null)
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        break label207;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "start align: " + paramanxl.jdField_e_of_type_JavaLangString + ", startRect: " + paramanxl.jdField_c_of_type_AndroidGraphicsRect);
      }
      localObject1 = null;
      break;
      label153:
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "end align " + paramanxl.f + ", endRect: " + paramanxl.jdField_d_of_type_AndroidGraphicsRect);
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
    if (paramanxl.jdField_e_of_type_Int == 1)
    {
      f1 = (m - j) * 0.25F + j;
      f2 = (n - k) * 0.1F + k;
      f3 = (m - j) * 0.25F + j;
      f4 = (n - k) * 1.0F + k;
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(anya.b(j, k));
      ((ArrayList)localObject1).add(anya.a(f1, f2, f3, f4, m, n));
      localObject2 = new anww[((ArrayList)localObject1).size()];
      int i = 0;
      label387:
      if (i < localObject2.length)
      {
        anww localanww = new anww();
        localanww.jdField_a_of_type_Anwx = paramanwx;
        localanww.jdField_a_of_type_Anya = ((anya)((ArrayList)localObject1).get(i));
        if (paramanxl.jdField_a_of_type_Boolean) {
          if (paramanwx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
            break label573;
          }
        }
        label573:
        for (boolean bool = true;; bool = false)
        {
          localanww.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
          localanww.jdField_a_of_type_Boolean = paramanwx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend();
          localanww.jdField_a_of_type_AndroidGraphicsRect = paramanxl.jdField_a_of_type_AndroidGraphicsRect;
          localanww.jdField_b_of_type_Boolean = paramanxl.jdField_b_of_type_Boolean;
          localObject2[i] = localanww;
          i += 1;
          break label387;
          if (paramanxl.jdField_e_of_type_Int != 2) {
            break label645;
          }
          f1 = (m - j) * 0.1F + j;
          f2 = (n - k) * 0.25F + k;
          f3 = (m - j) * 1.0F + j;
          f4 = (n - k) * 0.25F + k;
          break;
        }
      }
      paramanwx = ObjectAnimator.ofObject(this, "pathLocation", new anwz(), (Object[])localObject2);
      paramanwx.setDuration(((Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.c * (float)paramanxl.jdField_a_of_type_Long * 3.141592653589793D * 0.6000000238418579D));
      return paramanwx;
      label645:
      f3 = 0.0F;
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    anwx localanwx = a(paramLong1, paramLong2);
    ObjectAnimator localObjectAnimator1;
    if (localanwx != null)
    {
      localObjectAnimator1 = a(localanwx);
      if (localObjectAnimator1 == null) {
        QLog.e("BubbleInterActiveAnim", 1, "startAnimator is null");
      }
    }
    else
    {
      return;
    }
    ObjectAnimator localObjectAnimator2 = b(localanwx);
    if (localObjectAnimator2 == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "runningAnimator is null");
      return;
    }
    Object localObject = (anxl)localanwx.jdField_a_of_type_JavaUtilHashMap.get("animation_end");
    ObjectAnimator localObjectAnimator3 = a(localanwx, localanwx.jdField_b_of_type_AndroidGraphicsRect, (anxl)localObject);
    if (localObjectAnimator3 == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "endAnimator is null");
      return;
    }
    localObjectAnimator3.setRepeatCount(((anxl)localObject).jdField_a_of_type_Int - 1);
    localObject = c(localanwx);
    if (localObject == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
      return;
    }
    localanwx.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObject });
    localanwx.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new anws(this, localanwx));
    this.jdField_a_of_type_AndroidOsHandler.post(new BubbleInterActiveAnim.4(this, localanwx));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), localanwx);
  }
  
  public ObjectAnimator c(anwx paramanwx)
  {
    anxl localanxl = (anxl)paramanwx.jdField_a_of_type_JavaUtilHashMap.get("passive_animation");
    ObjectAnimator localObjectAnimator = a(paramanwx, paramanwx.jdField_b_of_type_AndroidGraphicsRect, localanxl);
    if (localObjectAnimator == null)
    {
      QLog.e("BubbleInterActiveAnim", 1, "passiveAnimator is null");
      return null;
    }
    localObjectAnimator.setRepeatCount(localanxl.jdField_a_of_type_Int - 1);
    localObjectAnimator.addListener(new anwv(this, paramanwx));
    return localObjectAnimator;
  }
  
  protected void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      anwx localanwx = (anwx)localIterator.next();
      if ((localanwx != null) && (localanwx.jdField_a_of_type_AndroidWidgetImageView != null)) {
        localanwx.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      }
    }
  }
  
  public void setBitmapData(anww paramanww)
  {
    if ((paramanww == null) || (paramanww.jdField_a_of_type_Anwx == null)) {}
    do
    {
      do
      {
        return;
        if ((paramanww.jdField_a_of_type_Anya != null) && (paramanww.jdField_a_of_type_Anya.jdField_a_of_type_Int == -1)) {
          setPathLocation(paramanww);
        }
        float f = paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView.getTranslationY();
        if ((f < this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()) || (f > this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int))
        {
          QLog.w("BubbleInterActiveAnim", 1, String.format("setBitmapData: now scroll over screen, stop bubble animator set!, y: %d, up: %d, download: %d", new Object[] { Integer.valueOf((int)f), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int) }));
          this.jdField_a_of_type_AndroidOsHandler.post(new BubbleInterActiveAnim.8(this, paramanww));
          return;
        }
      } while (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramanww.jdField_a_of_type_JavaLangString));
      if (paramanww.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        localObject = new anwk(paramanww.jdField_a_of_type_AndroidGraphicsBitmap);
        ((anwk)localObject).jdField_a_of_type_Boolean = paramanww.jdField_a_of_type_JavaLangBoolean.booleanValue();
        paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
        this.jdField_a_of_type_JavaLangString = paramanww.jdField_a_of_type_JavaLangString;
        paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView.invalidate();
        return;
      }
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramanww.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = (Bitmap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramanww.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    Object localObject = new anwk((Bitmap)localObject);
    ((anwk)localObject).jdField_a_of_type_Boolean = paramanww.jdField_a_of_type_JavaLangBoolean.booleanValue();
    paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_JavaLangString = paramanww.jdField_a_of_type_JavaLangString;
    paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView.invalidate();
    return;
    QLog.e("BubbleInterActiveAnim", 1, "can't find bitmap, path: " + paramanww.jdField_a_of_type_JavaLangString);
  }
  
  public void setPathLocation(anww paramanww)
  {
    if ((paramanww == null) || (paramanww.jdField_a_of_type_Anwx == null) || (paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    if ((paramanww.jdField_a_of_type_AndroidGraphicsRect != null) && (paramanww.jdField_a_of_type_AndroidGraphicsRect.right != 0) && (paramanww.jdField_a_of_type_AndroidGraphicsRect.bottom != 0) && ((paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView.getWidth() != paramanww.jdField_a_of_type_AndroidGraphicsRect.right) || (paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView.getHeight() != paramanww.jdField_a_of_type_AndroidGraphicsRect.bottom)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "change anim view size:  to " + paramanww.jdField_a_of_type_AndroidGraphicsRect.right + "-" + paramanww.jdField_a_of_type_AndroidGraphicsRect.bottom + ", view width-height: " + paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView.getWidth() + "-" + paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView.getHeight());
      }
      paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView.layout(0, 0, paramanww.jdField_a_of_type_AndroidGraphicsRect.right, paramanww.jdField_a_of_type_AndroidGraphicsRect.bottom);
    }
    if (paramanww.jdField_a_of_type_Anya.jdField_a_of_type_Int != -1)
    {
      if (paramanww.jdField_a_of_type_Anya.c != 360.0F) {
        break label456;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleInterActiveAnim", 2, "reset animView rotate to 0!");
      }
      paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView.setRotation(0.0F);
    }
    int i;
    int j;
    float f1;
    float f3;
    float f2;
    for (;;)
    {
      localObject = (View)paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidViewView.getParent();
      i = 0;
      j = 0;
      if ((localObject != null) && (((View)localObject).getParent() != this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getParent())) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
      f1 = paramanww.jdField_a_of_type_Anya.jdField_a_of_type_Float;
      f3 = paramanww.jdField_a_of_type_Anya.b;
      float f4 = this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
      f2 = i;
      f3 = j + (f3 - f4);
      if ((f3 >= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()) && (f3 <= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int)) {
        break label585;
      }
      QLog.w("BubbleInterActiveAnim", 1, String.format("setPathLocation: now scroll over screen, stop bubble animator set!, y: %d, up: %d, down: %d", new Object[] { Integer.valueOf((int)f3), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getTop()), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getBottom() + this.jdField_d_of_type_Int) }));
      this.jdField_a_of_type_AndroidOsHandler.post(new BubbleInterActiveAnim.9(this, paramanww));
      return;
      label456:
      if (paramanww.jdField_a_of_type_Anya.c != 0.0F)
      {
        paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView.setRotation(paramanww.jdField_a_of_type_Anya.c);
        if (QLog.isColorLevel()) {
          QLog.i("BubbleInterActiveAnim", 2, "set animView rotate to " + paramanww.jdField_a_of_type_Anya.c);
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
    paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(f2 + f1);
    paramanww.jdField_a_of_type_Anwx.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(f3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwq
 * JD-Core Version:    0.7.0.1
 */