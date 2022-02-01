package com.tencent.mobileqq.activity.miniaio;

import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.activity.aio.helper.IHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;

public class MiniChatProvider
{
  private SparseArrayCompat<SparseArrayCompat<ILifeCycleHelper>> a = new SparseArrayCompat(18);
  private SparseArrayCompat<IHelper> b = new SparseArrayCompat();
  
  public MiniChatProvider(MiniPie paramMiniPie)
  {
    a(1, new MiniPieHelper(paramMiniPie));
    a(2, new MiniMultiForwardHelper(paramMiniPie));
    a(3, new MiniECommerceExposeDataReportHelper(paramMiniPie));
    a(4, new MiniPieBroadcastHelper(paramMiniPie));
  }
  
  private void a(int paramInt, ILifeCycleHelper paramILifeCycleHelper)
  {
    this.b.put(paramInt, paramILifeCycleHelper);
    int[] arrayOfInt = paramILifeCycleHelper.interestedIn();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.a.get(k);
      SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
      if (localSparseArrayCompat2 == null)
      {
        localSparseArrayCompat1 = new SparseArrayCompat();
        this.a.put(k, localSparseArrayCompat1);
      }
      localSparseArrayCompat1.put(paramInt, paramILifeCycleHelper);
      i += 1;
    }
  }
  
  public <T extends IHelper> T a(int paramInt)
  {
    return (IHelper)this.b.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.a.get(paramInt);
    if (localSparseArrayCompat == null) {}
    for (;;)
    {
      return;
      int j = localSparseArrayCompat.size();
      int i = 0;
      while (i < j)
      {
        ((ILifeCycleHelper)localSparseArrayCompat.valueAt(i)).onMoveToState(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatProvider
 * JD-Core Version:    0.7.0.1
 */