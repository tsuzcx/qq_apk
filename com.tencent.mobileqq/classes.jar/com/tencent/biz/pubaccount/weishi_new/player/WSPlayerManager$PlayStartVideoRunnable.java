package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import android.text.TextUtils;
import vgb;
import vgh;
import vgi;
import vmp;

class WSPlayerManager$PlayStartVideoRunnable
  implements Runnable
{
  private vgb jdField_a_of_type_Vgb;
  private vgh jdField_a_of_type_Vgh;
  private boolean jdField_a_of_type_Boolean;
  
  WSPlayerManager$PlayStartVideoRunnable(WSPlayerManager paramWSPlayerManager, vgb paramvgb, vgh paramvgh, boolean paramBoolean)
  {
    this.jdField_a_of_type_Vgb = paramvgb;
    this.jdField_a_of_type_Vgh = paramvgh;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] post thread");
    if ((!this.jdField_a_of_type_Boolean) && (!WSPlayerManager.a(this.this$0, this.jdField_a_of_type_Vgh))) {}
    long l;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Vgb == null) || (this.jdField_a_of_type_Vgh == null) || (WSPlayerManager.f(this.this$0)));
      if (!this.jdField_a_of_type_Boolean) {
        WSPlayerManager.a(this.this$0, true);
      }
      l = this.jdField_a_of_type_Vgb.jdField_a_of_type_Long;
      if (l > 0L) {
        WSPlayerManager.g(this.this$0, true);
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_Vgb.jdField_a_of_type_Vgi.b));
    if ((WSPlayerManager.a(this.this$0) != null) && (WSPlayerManager.a(this.this$0).a(this.jdField_a_of_type_Vgb.jdField_a_of_type_Vgi.b))) {}
    for (boolean bool = true;; bool = false)
    {
      vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] goto playerStartByUrl!! isPreDownload:" + bool + ", videoUrl:" + this.jdField_a_of_type_Vgb.jdField_a_of_type_Vgi.b);
      this.jdField_a_of_type_Vgh.e(bool);
      if (this.jdField_a_of_type_Vgh.a("", this.jdField_a_of_type_Vgb.jdField_a_of_type_Vgi.b, 101, l, 0L, this.jdField_a_of_type_Vgb.jdField_a_of_type_Vgi.c, true, this.jdField_a_of_type_Vgb.jdField_a_of_type_Boolean)) {
        break;
      }
      vmp.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] playerStartByUrl failed, sendMsg retry.");
      WSPlayerManager.a(this.this$0).sendEmptyMessage(-4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */