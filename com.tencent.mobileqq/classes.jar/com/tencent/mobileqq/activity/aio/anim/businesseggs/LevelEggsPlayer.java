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
  private AioAnimationRule a;
  private int b;
  private AIOAnimationConatiner c;
  private AIOAnimationConatiner d;
  
  private void a(AIOAnimationConatiner paramAIOAnimationConatiner, List<AioAnimationRule.JumpImage> paramList, int paramInt, AioAnimationRule paramAioAnimationRule)
  {
    AioAnimationRule.JumpImage localJumpImage = (AioAnimationRule.JumpImage)paramList.get(paramInt);
    paramList = paramAIOAnimationConatiner;
    if ("true".equals(localJumpImage.e))
    {
      paramList = (RelativeLayout)paramAIOAnimationConatiner.getParent();
      if (this.d == null)
      {
        this.d = new AIOAnimationConatiner(paramAIOAnimationConatiner.getContext());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(6, 2131437281);
        paramList.addView(this.d, 0, localLayoutParams);
      }
      paramList = this.d;
      paramList.a(paramAIOAnimationConatiner.getListView());
    }
    paramList.a(9, 400, new Object[] { localJumpImage, paramAioAnimationRule });
  }
  
  private boolean a(AioAnimationRule paramAioAnimationRule, long paramLong)
  {
    long l = paramAioAnimationRule.d;
    boolean bool = true;
    if ((l != 0L) && (paramAioAnimationRule.e != 0L))
    {
      if (paramLong >= paramAioAnimationRule.d)
      {
        if (paramLong > paramAioAnimationRule.e) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    if (paramAioAnimationRule.d != 0L) {
      return paramLong > paramAioAnimationRule.e;
    }
    if (paramAioAnimationRule.e != 0L) {
      return paramLong < paramAioAnimationRule.d;
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
  
  private List<LevelEggsPlayer.AnimAck> b(List<ChatMessage> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      if (!a(paramList))
      {
        LevelEggsPlayer.AnimAck localAnimAck = new LevelEggsPlayer.AnimAck(null);
        localAnimAck.b = paramList.uniseq;
        paramList = AioAnimationDetector.a().c(paramList);
        if ((paramList != null) && (paramList.size() != 0)) {
          localAnimAck.a = ((AioAnimationRule)paramList.get(0));
        } else {
          localAnimAck.a = null;
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
  
  private void c(List<LevelEggsPlayer.AnimAck> paramList)
  {
    try
    {
      int i = paramList.size();
      if (i != 0)
      {
        int j = i - 1;
        if (((LevelEggsPlayer.AnimAck)paramList.get(j)).a != null)
        {
          this.a = ((LevelEggsPlayer.AnimAck)paramList.get(j)).a;
          if (this.a == null)
          {
            this.b = 0;
            return;
          }
          this.b = 1;
          i -= 2;
          while (i >= 0)
          {
            AioAnimationRule localAioAnimationRule = ((LevelEggsPlayer.AnimAck)paramList.get(i)).a;
            if ((localAioAnimationRule == null) || (this.a == null) || (this.a.b != localAioAnimationRule.b)) {
              break;
            }
            this.b += 1;
            i -= 1;
          }
          return;
        }
      }
      this.a = null;
      this.b = 0;
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
  
  public void a(QQAppInterface paramQQAppInterface, Handler paramHandler, ChatMessage paramChatMessage, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt1, AioAnimationRule paramAioAnimationRule, boolean paramBoolean, ArrayList<AioAnimationRule> paramArrayList, int paramInt2)
  {
    if ((!paramBoolean) && (paramInt2 != paramArrayList.size() - 1))
    {
      QLog.d("LevelEggsPlayer", 1, "[play] process unread, not the last one, continue.");
      return;
    }
    long l = System.currentTimeMillis();
    QLog.d("LevelEggsPlayer", 1, new Object[] { "[play] start: ", Long.valueOf(paramAioAnimationRule.d), ", end: ", Long.valueOf(paramAioAnimationRule.e), ", cur: ", Long.valueOf(l) });
    if (a(paramAioAnimationRule, l)) {
      return;
    }
    this.c = paramAIOAnimationConatiner;
    paramQQAppInterface = paramAioAnimationRule.j;
    paramArrayList = new TreeMap();
    Iterator localIterator = paramQQAppInterface.iterator();
    while (localIterator.hasNext())
    {
      AioAnimationRule.JumpImage localJumpImage = (AioAnimationRule.JumpImage)localIterator.next();
      paramInt1 = Integer.parseInt(localJumpImage.c);
      paramChatMessage = (List)paramArrayList.get(Integer.valueOf(paramInt1));
      paramQQAppInterface = paramChatMessage;
      if (paramChatMessage == null) {
        paramQQAppInterface = new ArrayList();
      }
      paramQQAppInterface.add(localJumpImage);
      paramArrayList.put(Integer.valueOf(paramInt1), paramQQAppInterface);
    }
    paramQQAppInterface = paramArrayList.keySet().iterator();
    for (paramInt1 = 0; paramQQAppInterface.hasNext(); paramInt1 = Math.max(paramInt1, ((Integer)paramQQAppInterface.next()).intValue())) {}
    paramInt2 = this.b;
    if (paramInt2 < paramInt1) {
      paramInt1 = paramInt2;
    }
    paramQQAppInterface = (List)paramArrayList.get(Integer.valueOf(paramInt1));
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() != 0))
    {
      paramInt1 = paramQQAppInterface.size();
      paramInt2 = RandomUtils.a(0, paramInt1);
      QLog.d("LevelEggsPlayer", 1, new Object[] { "[play] size: ", Integer.valueOf(paramInt1), "index: ", Integer.valueOf(paramInt2) });
      paramHandler.post(new LevelEggsPlayer.1(this, paramAIOAnimationConatiner, paramQQAppInterface, paramInt2, paramAioAnimationRule));
      return;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("[play] image invalid. id: ");
    paramQQAppInterface.append(paramAioAnimationRule.b);
    paramQQAppInterface.append(", freq: ");
    paramQQAppInterface.append(this.b);
    QLog.i("LevelEggsPlayer", 1, paramQQAppInterface.toString());
  }
  
  public void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo)
  {
    paramChatMessage = b(paramQQAppInterface.getMessageFacade().c(paramBaseSessionInfo.b, paramBaseSessionInfo.a, -1L, true));
    while (paramChatMessage.size() > 10) {
      paramChatMessage.remove(0);
    }
    c(paramChatMessage);
  }
  
  public void a(List<ChatMessage> paramList)
  {
    c(b(paramList));
  }
  
  public int b()
  {
    return 3;
  }
  
  public void c()
  {
    this.b = 0;
    this.a = null;
    AIOAnimationConatiner localAIOAnimationConatiner = this.d;
    if (localAIOAnimationConatiner != null)
    {
      localAIOAnimationConatiner.b();
      this.d.removeAllViews();
      this.d.f();
      this.d = null;
    }
    localAIOAnimationConatiner = this.c;
    if (localAIOAnimationConatiner != null)
    {
      localAIOAnimationConatiner.b();
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.LevelEggsPlayer
 * JD-Core Version:    0.7.0.1
 */