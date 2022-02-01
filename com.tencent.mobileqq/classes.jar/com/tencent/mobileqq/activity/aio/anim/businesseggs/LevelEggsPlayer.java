package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule.JumpImage;
import com.tencent.mobileqq.activity.aio.anim.egg.IEggBizPlayer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForTofuAioMiniProfile;
import com.tencent.mobileqq.data.MessageForTofuBaseProfile;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.RandomUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LevelEggsPlayer
  implements IEggBizPlayer
{
  private int jdField_a_of_type_Int;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private AioAnimationRule jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private AIOAnimationConatiner b;
  
  private List<LevelEggsPlayer.AnimAck> a(List<ChatMessage> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      if (!a(paramList))
      {
        LevelEggsPlayer.AnimAck localAnimAck = new LevelEggsPlayer.AnimAck(null);
        localAnimAck.jdField_a_of_type_Long = paramList.uniseq;
        paramList = AioAnimationDetector.a().a(paramList);
        if ((paramList != null) && (paramList.size() != 0)) {
          localAnimAck.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule = ((AioAnimationRule)paramList.get(0));
        } else {
          localAnimAck.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule = null;
        }
        if (QLog.isColorLevel())
        {
          if (paramList != null) {
            paramList = paramList.get(0);
          } else {
            paramList = "null";
          }
          QLog.d("LevelEggsPlayer", 1, new Object[] { "[buildAckQueue] match: ", paramList });
        }
        localLinkedList.add(localAnimAck);
      }
    }
    return localLinkedList;
  }
  
  private void a(AIOAnimationConatiner paramAIOAnimationConatiner, List<AioAnimationRule.JumpImage> paramList, int paramInt, AioAnimationRule paramAioAnimationRule)
  {
    AioAnimationRule.JumpImage localJumpImage = (AioAnimationRule.JumpImage)paramList.get(paramInt);
    paramList = paramAIOAnimationConatiner;
    if ("true".equals(localJumpImage.c))
    {
      paramList = (RelativeLayout)paramAIOAnimationConatiner.getParent();
      if (this.b == null)
      {
        this.b = new AIOAnimationConatiner(paramAIOAnimationConatiner.getContext());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(6, 2131370119);
        paramList.addView(this.b, 0, localLayoutParams);
      }
      paramList = this.b;
      paramList.a(paramAIOAnimationConatiner.a());
    }
    paramList.a(9, 400, new Object[] { localJumpImage, paramAioAnimationRule });
  }
  
  private boolean a(AioAnimationRule paramAioAnimationRule, long paramLong)
  {
    long l = paramAioAnimationRule.jdField_a_of_type_Long;
    boolean bool = true;
    if ((l != 0L) && (paramAioAnimationRule.jdField_b_of_type_Long != 0L))
    {
      if (paramLong >= paramAioAnimationRule.jdField_a_of_type_Long)
      {
        if (paramLong > paramAioAnimationRule.jdField_b_of_type_Long) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    if (paramAioAnimationRule.jdField_a_of_type_Long != 0L) {
      return paramLong > paramAioAnimationRule.jdField_b_of_type_Long;
    }
    if (paramAioAnimationRule.jdField_b_of_type_Long != 0L) {
      return paramLong < paramAioAnimationRule.jdField_a_of_type_Long;
    }
    return false;
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    if ((!(paramChatMessage instanceof MessageForGrayTips)) && (!(paramChatMessage instanceof MessageForUniteGrayTip)) && (!(paramChatMessage instanceof MessageForTofuBaseProfile)) && (!(paramChatMessage instanceof MessageForTofuAioMiniProfile)) && (!(paramChatMessage instanceof MessageForRichState))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LevelEggsPlayer", 1, new Object[] { "[buildAckQueue] message filtered. ", paramChatMessage });
    }
    return true;
  }
  
  private void b(List<LevelEggsPlayer.AnimAck> paramList)
  {
    try
    {
      int i = paramList.size();
      if (i != 0)
      {
        int j = i - 1;
        if (((LevelEggsPlayer.AnimAck)paramList.get(j)).jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule = ((LevelEggsPlayer.AnimAck)paramList.get(j)).jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule == null)
          {
            this.jdField_a_of_type_Int = 0;
            return;
          }
          this.jdField_a_of_type_Int = 1;
          i -= 2;
          while (i >= 0)
          {
            AioAnimationRule localAioAnimationRule = ((LevelEggsPlayer.AnimAck)paramList.get(i)).jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule;
            if ((localAioAnimationRule == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule.jdField_b_of_type_Int != localAioAnimationRule.jdField_b_of_type_Int)) {
              break;
            }
            this.jdField_a_of_type_Int += 1;
            i -= 1;
          }
          return;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule = null;
      this.jdField_a_of_type_Int = 0;
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public int a()
  {
    return 9;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule = null;
    AIOAnimationConatiner localAIOAnimationConatiner = this.b;
    if (localAIOAnimationConatiner != null)
    {
      localAIOAnimationConatiner.b();
      this.b.removeAllViews();
      this.b.e();
      this.b = null;
    }
    localAIOAnimationConatiner = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
    if (localAIOAnimationConatiner != null)
    {
      localAIOAnimationConatiner.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = null;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Handler paramHandler, ChatMessage paramChatMessage, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, AioAnimationRule paramAioAnimationRule)
  {
    long l = System.currentTimeMillis();
    QLog.d("LevelEggsPlayer", 1, new Object[] { "[play] start: ", Long.valueOf(paramAioAnimationRule.jdField_a_of_type_Long), ", end: ", Long.valueOf(paramAioAnimationRule.jdField_b_of_type_Long), ", cur: ", Long.valueOf(l) });
    if (a(paramAioAnimationRule, l)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    paramQQAppInterface = paramAioAnimationRule.jdField_b_of_type_JavaUtilArrayList;
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator = paramQQAppInterface.iterator();
    while (localIterator.hasNext())
    {
      AioAnimationRule.JumpImage localJumpImage = (AioAnimationRule.JumpImage)localIterator.next();
      paramInt = Integer.parseInt(localJumpImage.jdField_a_of_type_JavaLangString);
      paramChatMessage = (List)localTreeMap.get(Integer.valueOf(paramInt));
      paramQQAppInterface = paramChatMessage;
      if (paramChatMessage == null) {
        paramQQAppInterface = new ArrayList();
      }
      paramQQAppInterface.add(localJumpImage);
      localTreeMap.put(Integer.valueOf(paramInt), paramQQAppInterface);
    }
    paramQQAppInterface = localTreeMap.keySet().iterator();
    for (paramInt = 0; paramQQAppInterface.hasNext(); paramInt = Math.max(paramInt, ((Integer)paramQQAppInterface.next()).intValue())) {}
    int i = this.jdField_a_of_type_Int;
    if (i < paramInt) {
      paramInt = i;
    }
    paramQQAppInterface = (List)localTreeMap.get(Integer.valueOf(paramInt));
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() != 0))
    {
      paramInt = paramQQAppInterface.size();
      i = RandomUtils.a(0, paramInt);
      QLog.d("LevelEggsPlayer", 1, new Object[] { "[play] size: ", Integer.valueOf(paramInt), "index: ", Integer.valueOf(i) });
      paramHandler.post(new LevelEggsPlayer.1(this, paramAIOAnimationConatiner, paramQQAppInterface, i, paramAioAnimationRule));
      return;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("[play] image invalid. id: ");
    paramQQAppInterface.append(paramAioAnimationRule.jdField_b_of_type_Int);
    paramQQAppInterface.append(", freq: ");
    paramQQAppInterface.append(this.jdField_a_of_type_Int);
    QLog.i("LevelEggsPlayer", 1, paramQQAppInterface.toString());
  }
  
  public void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo)
  {
    paramChatMessage = a(paramQQAppInterface.getMessageFacade().a(paramBaseSessionInfo.jdField_a_of_type_JavaLangString, paramBaseSessionInfo.jdField_a_of_type_Int, -1L, true));
    while (paramChatMessage.size() > 10) {
      paramChatMessage.remove(0);
    }
    b(paramChatMessage);
  }
  
  public void a(List<ChatMessage> paramList)
  {
    b(a(paramList));
  }
  
  public int b()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.LevelEggsPlayer
 * JD-Core Version:    0.7.0.1
 */