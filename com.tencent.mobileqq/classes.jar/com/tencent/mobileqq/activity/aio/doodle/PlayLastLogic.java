package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.doodle.IDoodleMsgLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PlayLastLogic
{
  private static PlayLastLogic jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePlayLastLogic;
  private static String jdField_a_of_type_JavaLangString = "PlayLastLogic";
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private WeakReference<BaseDoodleMsgLayout> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<Integer, MsgInfo> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long = -1L;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = -1L;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g;
  private int h;
  
  private PlayLastLogic()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    Object localObject2;
    if (bool)
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkPlayable: bRealPlay:");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = (MsgInfo)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localObject1 != null)
    {
      localObject2 = ((MsgInfo)localObject1).jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject2 != null)
      {
        localObject2 = (BaseDoodleMsgLayout)((WeakReference)localObject2).get();
        if (localObject2 != null)
        {
          Object localObject3 = new Rect();
          if (((BaseDoodleMsgLayout)localObject2).getGlobalVisibleRect((Rect)localObject3))
          {
            double d1 = ((Rect)localObject3).height();
            double d2 = ((BaseDoodleMsgLayout)localObject2).getHeight();
            Double.isNaN(d2);
            if (d1 > d2 * 0.9D)
            {
              if ((!((BaseDoodleMsgLayout)localObject2).b()) && (this.jdField_a_of_type_Long != ((MsgInfo)localObject1).jdField_b_of_type_Long) && (((BaseDoodleMsgLayout)localObject2).a()))
              {
                if (paramBoolean)
                {
                  a((BaseDoodleMsgLayout)localObject2, false);
                  if (((MsgInfo)localObject1).jdField_b_of_type_Long == this.jdField_c_of_type_Long) {
                    this.jdField_a_of_type_Boolean = true;
                  }
                }
                if (QLog.isColorLevel())
                {
                  localObject1 = jdField_a_of_type_JavaLangString;
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("checkPlayable: lastID:");
                  ((StringBuilder)localObject2).append(this.jdField_b_of_type_Long);
                  ((StringBuilder)localObject2).append("lasUniID");
                  ((StringBuilder)localObject2).append(this.jdField_c_of_type_Long);
                  ((StringBuilder)localObject2).append(" lastMsgPlayed:");
                  ((StringBuilder)localObject2).append(this.jdField_a_of_type_Boolean);
                  ((StringBuilder)localObject2).append(" playedID:");
                  ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
                  QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
                }
                return 1;
              }
              if (QLog.isColorLevel())
              {
                localObject3 = jdField_a_of_type_JavaLangString;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("checkPlayable: can not play:");
                localStringBuilder.append(((MsgInfo)localObject1).jdField_a_of_type_Long);
                localStringBuilder.append("uniID:");
                localStringBuilder.append(((MsgInfo)localObject1).jdField_b_of_type_Long);
                localStringBuilder.append(" mPlayedID:");
                localStringBuilder.append(this.jdField_a_of_type_Long);
                QLog.d((String)localObject3, 2, localStringBuilder.toString());
              }
              paramInt = i;
              if (!((BaseDoodleMsgLayout)localObject2).b()) {
                return paramInt;
              }
              return 3;
            }
          }
          if (QLog.isColorLevel())
          {
            localObject2 = jdField_a_of_type_JavaLangString;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("checkPlayable: invisible MsgID:");
            ((StringBuilder)localObject3).append(((MsgInfo)localObject1).jdField_a_of_type_Long);
            ((StringBuilder)localObject3).append("uniID:");
            ((StringBuilder)localObject3).append(((MsgInfo)localObject1).jdField_b_of_type_Long);
            QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
          }
        }
      }
    }
    paramInt = 0;
    return paramInt;
  }
  
  public static long a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage.istroop != 1) && (paramChatMessage.istroop != 3000)) {
      return paramChatMessage.time;
    }
    return paramChatMessage.shmsgseq;
  }
  
  public static PlayLastLogic a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePlayLastLogic == null) {
        jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePlayLastLogic = new PlayLastLogic();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePlayLastLogic;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      MsgInfo localMsgInfo = (MsgInfo)((Map.Entry)localIterator.next()).getValue();
      if ((localMsgInfo == null) || (localMsgInfo.jdField_a_of_type_Int < paramInt1) || (localMsgInfo.jdField_a_of_type_Int > paramInt2)) {
        localIterator.remove();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (MsgInfo)localIterator.next();
      if ((localObject != null) && (((MsgInfo)localObject).jdField_a_of_type_Int >= this.d) && (((MsgInfo)localObject).jdField_a_of_type_Int <= this.e))
      {
        localObject = ((MsgInfo)localObject).jdField_a_of_type_JavaLangRefWeakReference;
        if (localObject != null)
        {
          localObject = (IDoodleMsgLayout)((WeakReference)localObject).get();
          if (localObject != null) {
            ((IDoodleMsgLayout)localObject).b(paramBoolean);
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_b_of_type_Long < 0L) {
          return;
        }
        this.jdField_a_of_type_Boolean = true;
        localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
        MsgInfo localMsgInfo;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localMsgInfo = (MsgInfo)((Iterator)localObject).next();
        } while (localMsgInfo.jdField_b_of_type_Long != this.jdField_c_of_type_Long);
        localObject = localMsgInfo.jdField_a_of_type_JavaLangRefWeakReference;
        if (localObject == null) {
          return;
        }
        localObject = (IDoodleMsgLayout)((WeakReference)localObject).get();
        if (localObject == null) {
          return;
        }
        ((IDoodleMsgLayout)localObject).d();
      }
    }
    else
    {
      int i = this.e;
      while (i >= this.d)
      {
        if (i != paramInt)
        {
          localObject = (MsgInfo)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
          if ((localObject != null) && ((((MsgInfo)localObject).jdField_a_of_type_Long > this.jdField_b_of_type_Long) || (((MsgInfo)localObject).jdField_b_of_type_Long == this.jdField_c_of_type_Long)))
          {
            localObject = ((MsgInfo)localObject).jdField_a_of_type_JavaLangRefWeakReference;
            if (localObject != null)
            {
              localObject = (IDoodleMsgLayout)((WeakReference)localObject).get();
              if (localObject != null) {
                ((IDoodleMsgLayout)localObject).d();
              }
            }
          }
        }
        i -= 1;
      }
    }
  }
  
  public static long b(ChatMessage paramChatMessage)
  {
    return paramChatMessage.uniseq;
  }
  
  public static void b()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePlayLastLogic != null)
      {
        jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePlayLastLogic.a();
        jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePlayLastLogic = null;
      }
      return;
    }
    finally {}
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("restartPlayTimer:");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (paramInt < 0) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new PlayLastLogic.1(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("strategy2 :");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" StartPos:");
      localStringBuilder.append(this.d);
      localStringBuilder.append("EndPos:");
      localStringBuilder.append(this.e);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    int i = this.f;
    int k = -1;
    int m;
    if (i == 0)
    {
      j = this.e;
      for (;;)
      {
        i = k;
        if (j < this.d) {
          break;
        }
        m = a(j, paramBoolean);
        if (m > 0)
        {
          i = j;
          if (m == 1) {
            break;
          }
          i = k;
          if (m != 3) {
            break;
          }
          i = j;
          break;
        }
        j -= 1;
      }
    }
    int j = this.d;
    for (;;)
    {
      i = k;
      if (j > this.e) {
        break;
      }
      m = a(j, paramBoolean);
      if (m > 0)
      {
        i = j;
        if (m != 1)
        {
          i = k;
          if (m != 3) {
            break;
          }
          i = j;
        }
        break;
      }
      j += 1;
    }
    a(false, i);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      new Handler(Looper.getMainLooper()).removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0)
    {
      b(1000);
      a(this.d, this.e);
      a(false);
      b(false);
      return;
    }
    b(-1);
    a(true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i = paramInt2;
    if (paramInt1 == 0)
    {
      i = paramInt2;
      if (paramInt3 > 0) {
        i = paramInt2 - 1;
      }
    }
    paramInt2 = i;
    if (paramInt1 + i == paramInt5)
    {
      paramInt2 = i;
      if (paramInt4 > 0) {
        paramInt2 = i - 1;
      }
    }
    paramInt1 -= paramInt3;
    if ((this.h == paramInt8) && (this.g == paramInt7))
    {
      paramInt3 = this.jdField_b_of_type_Int;
      if (paramInt1 > paramInt3)
      {
        this.f = 0;
      }
      else if (paramInt1 < paramInt3)
      {
        this.f = 1;
      }
      else
      {
        paramInt3 = this.jdField_c_of_type_Int;
        if (paramInt6 < paramInt3) {
          this.f = 0;
        } else if (paramInt6 > paramInt3) {
          this.f = 1;
        }
      }
      this.jdField_c_of_type_Int = paramInt6;
      this.jdField_b_of_type_Int = paramInt1;
      paramInt3 = paramInt1;
      if (paramInt1 < 0) {
        paramInt3 = 0;
      }
      this.d = paramInt3;
      paramInt1 = this.d;
      this.e = (paramInt2 + paramInt1 - 1);
      if (this.e < paramInt1) {
        this.e = paramInt1;
      }
      return;
    }
    this.h = paramInt8;
    this.g = paramInt7;
    this.f = 0;
    this.jdField_c_of_type_Int = paramInt6;
    this.jdField_b_of_type_Int = paramInt1;
    paramInt3 = paramInt1;
    if (paramInt1 < 0) {
      paramInt3 = 0;
    }
    this.d = paramInt3;
    paramInt1 = this.d;
    this.e = (paramInt2 + paramInt1 - 1);
    if (this.e < paramInt1) {
      this.e = paramInt1;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, BaseDoodleMsgLayout paramBaseDoodleMsgLayout)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registLayout:");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" pos:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" uniid:");
      localStringBuilder.append(paramLong1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), new MsgInfo(paramLong1, paramLong2, paramInt, paramBaseDoodleMsgLayout));
    boolean bool;
    if (this.jdField_a_of_type_Int != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramBaseDoodleMsgLayout.b(bool);
    if (a(paramLong1, paramLong2))
    {
      if (QLog.isColorLevel())
      {
        paramBaseDoodleMsgLayout = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("registLayout: is new msg, lastID:");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
        ((StringBuilder)localObject).append(" uniID:");
        ((StringBuilder)localObject).append(paramLong1);
        QLog.d(paramBaseDoodleMsgLayout, 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        b(1000);
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (QLog.isColorLevel())
    {
      paramBaseDoodleMsgLayout = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("registLayout: is old msg, lastID:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject).append(" uniID:");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" lastMsgPlayed:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(" playedID:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      QLog.d(paramBaseDoodleMsgLayout, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(BaseDoodleMsgLayout paramBaseDoodleMsgLayout, boolean paramBoolean)
  {
    if (paramBaseDoodleMsgLayout == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (BaseDoodleMsgLayout)((WeakReference)localObject).get();
      if ((localObject != null) && (((BaseDoodleMsgLayout)localObject).b()))
      {
        if ((paramBoolean) && (localObject == paramBaseDoodleMsgLayout))
        {
          ((BaseDoodleMsgLayout)localObject).d();
          return;
        }
        if ((!paramBoolean) && (localObject == paramBaseDoodleMsgLayout))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "playLayout: same layout, ans is playing, return:");
          }
          return;
        }
        ((BaseDoodleMsgLayout)localObject).d();
      }
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseDoodleMsgLayout);
    paramBaseDoodleMsgLayout.c();
    localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgInfo localMsgInfo = (MsgInfo)((Iterator)localObject).next();
      if ((localMsgInfo.jdField_a_of_type_JavaLangRefWeakReference != null) && (localMsgInfo.jdField_a_of_type_JavaLangRefWeakReference.get() == paramBaseDoodleMsgLayout))
      {
        this.jdField_a_of_type_Long = localMsgInfo.jdField_b_of_type_Long;
        if (QLog.isColorLevel())
        {
          paramBaseDoodleMsgLayout = jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("playLayout: lastPlayedID:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
          QLog.d(paramBaseDoodleMsgLayout, 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    if (paramBoolean) {
      b(-1);
    }
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      long l1 = a((ChatMessage)paramList.get(paramList.size() - 1));
      long l2 = b((ChatMessage)paramList.get(paramList.size() - 1));
      if ((l1 > this.jdField_b_of_type_Long) && (this.jdField_c_of_type_Long != l2))
      {
        a(true, -1);
        if (this.jdField_b_of_type_Long < 0L) {
          this.jdField_a_of_type_Boolean = ((ChatMessage)paramList.get(paramList.size() - 1)).isread;
        } else {
          this.jdField_a_of_type_Boolean = false;
        }
        this.jdField_b_of_type_Long = l1;
        this.jdField_c_of_type_Long = l2;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "setLastMsgID: a new msg");
        }
      }
      if (QLog.isColorLevel())
      {
        paramList = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setLastMsgID:");
        localStringBuilder.append(this.jdField_b_of_type_Long);
        localStringBuilder.append(" :");
        localStringBuilder.append(this.jdField_c_of_type_Long);
        QLog.d(paramList, 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    if ((paramLong2 > this.jdField_b_of_type_Long) && (paramLong1 != this.jdField_c_of_type_Long)) {
      return true;
    }
    return (this.jdField_c_of_type_Long == paramLong1) && (!this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PlayLastLogic
 * JD-Core Version:    0.7.0.1
 */