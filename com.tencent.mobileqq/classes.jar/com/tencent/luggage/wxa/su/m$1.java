package com.tencent.luggage.wxa.su;

import android.util.Pair;
import android.webkit.ValueCallback;
import org.xwalk.core.Log;

class m$1
  implements ValueCallback<Pair<Integer, String>>
{
  m$1(m paramm) {}
  
  public void a(Pair<Integer, String> paramPair)
  {
    int i = ((Integer)paramPair.first).intValue();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return;
            }
            Log.e(this.a.a(), (String)paramPair.second);
            return;
          }
          Log.w(this.a.a(), (String)paramPair.second);
          return;
        }
        Log.i(this.a.a(), (String)paramPair.second);
        return;
      }
      Log.d(this.a.a(), (String)paramPair.second);
      return;
    }
    Log.v(this.a.a(), (String)paramPair.second);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.su.m.1
 * JD-Core Version:    0.7.0.1
 */