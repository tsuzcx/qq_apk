package com.tencent.biz.pubaccount.readinjoy.engine;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;

public abstract interface KandianMergeManager$MessageObserver
{
  public abstract void a(MessageRecord paramMessageRecord);
  
  public abstract void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle);
  
  public abstract void b(MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.MessageObserver
 * JD-Core Version:    0.7.0.1
 */