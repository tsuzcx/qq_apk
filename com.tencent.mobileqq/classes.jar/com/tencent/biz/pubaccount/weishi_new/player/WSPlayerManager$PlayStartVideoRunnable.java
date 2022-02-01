package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import android.text.TextUtils;
import ukb;
import uke;
import ukf;
import upe;

class WSPlayerManager$PlayStartVideoRunnable
  implements Runnable
{
  private ukb jdField_a_of_type_Ukb;
  private uke jdField_a_of_type_Uke;
  private boolean jdField_a_of_type_Boolean;
  
  WSPlayerManager$PlayStartVideoRunnable(WSPlayerManager paramWSPlayerManager, ukb paramukb, uke paramuke, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ukb = paramukb;
    this.jdField_a_of_type_Uke = paramuke;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] post thread");
    if ((!this.jdField_a_of_type_Boolean) && (!WSPlayerManager.a(this.this$0, this.jdField_a_of_type_Uke))) {}
    long l;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Ukb == null) || (this.jdField_a_of_type_Uke == null) || (WSPlayerManager.e(this.this$0)));
      if (!this.jdField_a_of_type_Boolean) {
        WSPlayerManager.a(this.this$0, true);
      }
      l = this.jdField_a_of_type_Ukb.jdField_a_of_type_Long;
      if (l > 0L) {
        WSPlayerManager.g(this.this$0, true);
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_Ukb.jdField_a_of_type_Ukf.b));
    if ((WSPlayerManager.a(this.this$0) != null) && (WSPlayerManager.a(this.this$0).a(this.jdField_a_of_type_Ukb.jdField_a_of_type_Ukf.b))) {}
    for (boolean bool = true;; bool = false)
    {
      upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] goto playerStartByUrl!! isPreDownload:" + bool + ", videoUrl:" + this.jdField_a_of_type_Ukb.jdField_a_of_type_Ukf.b);
      this.jdField_a_of_type_Uke.e(bool);
      if (this.jdField_a_of_type_Uke.a("", this.jdField_a_of_type_Ukb.jdField_a_of_type_Ukf.b, 2, l, 0L, this.jdField_a_of_type_Ukb.jdField_a_of_type_Ukf.c, true, this.jdField_a_of_type_Ukb.jdField_a_of_type_Boolean)) {
        break;
      }
      upe.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] playerStartByUrl failed, sendMsg retry.");
      WSPlayerManager.a(this.this$0).sendEmptyMessage(-4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */