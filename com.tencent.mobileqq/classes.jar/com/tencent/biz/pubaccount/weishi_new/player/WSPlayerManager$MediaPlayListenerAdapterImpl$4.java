package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;
import urk;
import urr;
import urt;
import uru;
import uss;
import uya;

public class WSPlayerManager$MediaPlayListenerAdapterImpl$4
  implements Runnable
{
  public WSPlayerManager$MediaPlayListenerAdapterImpl$4(urr paramurr, int paramInt1, int paramInt2, int paramInt3, urt paramurt) {}
  
  public void run()
  {
    String str = uss.a(this.jdField_a_of_type_Int, this.b, this.c);
    uya.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onError] 播放状态回调 errorContent:" + str);
    if ((this.jdField_a_of_type_Urt != null) && (this.jdField_a_of_type_Urt.a != null)) {
      this.jdField_a_of_type_Urt.a.a(this.jdField_a_of_type_Urt, this.jdField_a_of_type_Int, this.b, str);
    }
    if (WSPlayerManager.a(this.jdField_a_of_type_Urr.a) != null)
    {
      Iterator localIterator = WSPlayerManager.a(this.jdField_a_of_type_Urr.a).iterator();
      while (localIterator.hasNext()) {
        ((uru)localIterator.next()).a(this.jdField_a_of_type_Urt, this.jdField_a_of_type_Int, this.b, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.4
 * JD-Core Version:    0.7.0.1
 */