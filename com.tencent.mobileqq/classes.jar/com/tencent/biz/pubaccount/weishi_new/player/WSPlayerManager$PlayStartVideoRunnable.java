package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import android.text.TextUtils;
import thl;
import tho;
import thp;
import tlo;

class WSPlayerManager$PlayStartVideoRunnable
  implements Runnable
{
  private thl jdField_a_of_type_Thl;
  private tho jdField_a_of_type_Tho;
  private boolean jdField_a_of_type_Boolean;
  
  WSPlayerManager$PlayStartVideoRunnable(WSPlayerManager paramWSPlayerManager, thl paramthl, tho paramtho, boolean paramBoolean)
  {
    this.jdField_a_of_type_Thl = paramthl;
    this.jdField_a_of_type_Tho = paramtho;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] post thread");
    if ((!this.jdField_a_of_type_Boolean) && (!WSPlayerManager.a(this.this$0, this.jdField_a_of_type_Tho))) {}
    long l;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Thl == null) || (this.jdField_a_of_type_Tho == null) || (WSPlayerManager.e(this.this$0)));
      if (!this.jdField_a_of_type_Boolean) {
        WSPlayerManager.a(this.this$0, true);
      }
      l = this.jdField_a_of_type_Thl.jdField_a_of_type_Long;
      if (l > 0L) {
        WSPlayerManager.g(this.this$0, true);
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_Thl.jdField_a_of_type_Thp.b));
    if ((WSPlayerManager.a(this.this$0) != null) && (WSPlayerManager.a(this.this$0).a(this.jdField_a_of_type_Thl.jdField_a_of_type_Thp.b))) {}
    for (boolean bool = true;; bool = false)
    {
      tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] goto playerStartByUrl!! isPreDownload:" + bool + ", videoUrl:" + this.jdField_a_of_type_Thl.jdField_a_of_type_Thp.b);
      if (this.jdField_a_of_type_Tho.a("", this.jdField_a_of_type_Thl.jdField_a_of_type_Thp.b, 2, l, 0L, this.jdField_a_of_type_Thl.jdField_a_of_type_Thp.c, true, this.jdField_a_of_type_Thl.jdField_a_of_type_Boolean)) {
        break;
      }
      tlo.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] playerStartByUrl failed, sendMsg retry.");
      WSPlayerManager.a(this.this$0).sendEmptyMessage(-4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */