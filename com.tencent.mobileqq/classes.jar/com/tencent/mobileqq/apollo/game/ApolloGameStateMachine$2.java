package com.tencent.mobileqq.apollo.game;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

class ApolloGameStateMachine$2
  implements Observer
{
  ApolloGameStateMachine$2(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Bundle)))
    {
      paramObservable = (Bundle)paramObject;
      long l1 = paramObservable.getLong("START_TIME_KEY");
      long l2 = paramObservable.getLong("END_TIME_KEY");
      paramObject = paramObservable.getString("MESSAGE");
      int i = paramObservable.getInt("FROM");
      int j = paramObservable.getInt("TO");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameStateMachine", 2, new Object[] { "[pipLineObserver] cost:[", Long.valueOf(l2 - l1), "ms] message:[", paramObject, "] from:[", Integer.valueOf(i), "] to:[", Integer.valueOf(j), "] start:[", Long.valueOf(l1), "] end:[", Long.valueOf(l2), "]" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.2
 * JD-Core Version:    0.7.0.1
 */