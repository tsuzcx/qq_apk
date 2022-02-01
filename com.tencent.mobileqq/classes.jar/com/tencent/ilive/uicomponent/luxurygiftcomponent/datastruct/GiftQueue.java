package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftData;
import java.util.LinkedList;

public class GiftQueue
{
  private static final String TAG = "GiftQueue|GiftAnimation";
  private boolean isPrevEventSelfEvent;
  private LinkedList<LuxuryGiftData> mComboGiftQuene = new LinkedList();
  private LuxuryGiftAdapter mLuxuryGiftAdapter;
  private LinkedList<LuxuryGiftData> mRichGiftQuene = new LinkedList();
  private LinkedList<LuxuryGiftData> mSelfGiftQuene = new LinkedList();
  
  public GiftQueue(LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    this.mLuxuryGiftAdapter = paramLuxuryGiftAdapter;
  }
  
  private boolean controlOffer(LinkedList<LuxuryGiftData> paramLinkedList, LuxuryGiftData paramLuxuryGiftData)
  {
    if (paramLuxuryGiftData.consumerUin == this.mLuxuryGiftAdapter.getAccountUin()) {
      return paramLinkedList.offerFirst(paramLuxuryGiftData);
    }
    return paramLinkedList.offer(paramLuxuryGiftData);
  }
  
  private LuxuryGiftData controlPeek(LinkedList<LuxuryGiftData> paramLinkedList)
  {
    LuxuryGiftData localLuxuryGiftData = (LuxuryGiftData)paramLinkedList.peek();
    if ((localLuxuryGiftData != null) && (localLuxuryGiftData.consumerUin != this.mLuxuryGiftAdapter.getAccountUin()))
    {
      if (paramLinkedList.size() >= 4) {
        return (LuxuryGiftData)paramLinkedList.peekLast();
      }
      return (LuxuryGiftData)paramLinkedList.peek();
    }
    return (LuxuryGiftData)paramLinkedList.peek();
  }
  
  private LuxuryGiftData controlPoll(LinkedList<LuxuryGiftData> paramLinkedList)
  {
    LuxuryGiftData localLuxuryGiftData = (LuxuryGiftData)paramLinkedList.peek();
    if ((localLuxuryGiftData != null) && (localLuxuryGiftData.consumerUin != this.mLuxuryGiftAdapter.getAccountUin()))
    {
      if (paramLinkedList.size() >= 4) {
        return (LuxuryGiftData)paramLinkedList.pollLast();
      }
      return (LuxuryGiftData)paramLinkedList.poll();
    }
    return (LuxuryGiftData)paramLinkedList.poll();
  }
  
  public void clearQueue()
  {
    this.mSelfGiftQuene.clear();
    this.mRichGiftQuene.clear();
    this.mComboGiftQuene.clear();
  }
  
  public boolean isPrevEventSelfEvent()
  {
    return this.isPrevEventSelfEvent;
  }
  
  public boolean offer(LuxuryGiftData paramLuxuryGiftData)
  {
    if (paramLuxuryGiftData == null) {
      return false;
    }
    this.mLuxuryGiftAdapter.getLogger().i("RichGiftLog", "Add gift to list, Type=%d, Id=%d, Name=%s, uName=%s", new Object[] { Integer.valueOf(paramLuxuryGiftData.giftType), Integer.valueOf(paramLuxuryGiftData.giftId), paramLuxuryGiftData.giftName, paramLuxuryGiftData.consumerName });
    if (paramLuxuryGiftData.consumerUin == this.mLuxuryGiftAdapter.getAccountUin()) {
      return controlOffer(this.mSelfGiftQuene, paramLuxuryGiftData);
    }
    int i = paramLuxuryGiftData.giftType;
    if (i != 101)
    {
      if (i != 104) {
        return false;
      }
      return controlOffer(this.mRichGiftQuene, paramLuxuryGiftData);
    }
    return controlOffer(this.mComboGiftQuene, paramLuxuryGiftData);
  }
  
  public LuxuryGiftData peek()
  {
    Object localObject2 = controlPeek(this.mSelfGiftQuene);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = controlPeek(this.mRichGiftQuene);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = controlPeek(this.mComboGiftQuene);
    }
    return localObject2;
  }
  
  public LuxuryGiftData poll()
  {
    Object localObject2 = controlPoll(this.mSelfGiftQuene);
    boolean bool;
    if (localObject2 != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.isPrevEventSelfEvent = bool;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = controlPoll(this.mRichGiftQuene);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = controlPoll(this.mComboGiftQuene);
    }
    return localObject2;
  }
  
  public int selfSize()
  {
    return this.mSelfGiftQuene.size();
  }
  
  public int size()
  {
    LogInterface localLogInterface = this.mLuxuryGiftAdapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" SQ=");
    localStringBuilder.append(this.mSelfGiftQuene.size());
    localStringBuilder.append(" rq=");
    localStringBuilder.append(this.mRichGiftQuene.size());
    localStringBuilder.append(" mcq=");
    localStringBuilder.append(this.mComboGiftQuene.size());
    localLogInterface.e("GiftQueue|GiftAnimation", localStringBuilder.toString(), new Object[0]);
    return this.mSelfGiftQuene.size() + this.mRichGiftQuene.size() + this.mComboGiftQuene.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.GiftQueue
 * JD-Core Version:    0.7.0.1
 */