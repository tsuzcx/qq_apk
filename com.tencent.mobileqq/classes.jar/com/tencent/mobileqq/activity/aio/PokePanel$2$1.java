package com.tencent.mobileqq.activity.aio;

import afug;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class PokePanel$2$1
  implements Runnable
{
  PokePanel$2$1(PokePanel.2 param2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.PokePanel", 2, "[pokepanel]update UI start");
    }
    ArrayList localArrayList = this.a.a;
    PokePanel.a(this.a.this$0).a(localArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.PokePanel", 2, "[pokepanel]update UI end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PokePanel.2.1
 * JD-Core Version:    0.7.0.1
 */