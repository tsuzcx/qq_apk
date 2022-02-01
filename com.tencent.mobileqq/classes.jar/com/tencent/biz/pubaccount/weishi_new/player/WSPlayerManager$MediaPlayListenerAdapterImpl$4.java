package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.ArrayList;
import java.util.Iterator;
import vfs;
import vfz;
import vgb;
import vgc;
import vhd;
import vmp;

public class WSPlayerManager$MediaPlayListenerAdapterImpl$4
  implements Runnable
{
  public WSPlayerManager$MediaPlayListenerAdapterImpl$4(vfz paramvfz, int paramInt1, int paramInt2, int paramInt3, vgb paramvgb) {}
  
  public void run()
  {
    String str = vhd.a(this.jdField_a_of_type_Int, this.b, this.c);
    vmp.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][onError] 播放状态回调 errorContent:" + str);
    if ((this.jdField_a_of_type_Vgb != null) && (this.jdField_a_of_type_Vgb.a != null)) {
      this.jdField_a_of_type_Vgb.a.a(this.jdField_a_of_type_Vgb, this.jdField_a_of_type_Int, this.b, str);
    }
    if (WSPlayerManager.a(this.jdField_a_of_type_Vfz.a) != null)
    {
      Iterator localIterator = WSPlayerManager.a(this.jdField_a_of_type_Vfz.a).iterator();
      while (localIterator.hasNext()) {
        ((vgc)localIterator.next()).a(this.jdField_a_of_type_Vgb, this.jdField_a_of_type_Int, this.b, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.MediaPlayListenerAdapterImpl.4
 * JD-Core Version:    0.7.0.1
 */