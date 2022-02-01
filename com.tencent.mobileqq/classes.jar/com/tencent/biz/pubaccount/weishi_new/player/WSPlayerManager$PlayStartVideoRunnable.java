package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import android.text.TextUtils;
import ukz;
import ulc;
import uld;
import uqf;

class WSPlayerManager$PlayStartVideoRunnable
  implements Runnable
{
  private ukz jdField_a_of_type_Ukz;
  private ulc jdField_a_of_type_Ulc;
  private boolean jdField_a_of_type_Boolean;
  
  WSPlayerManager$PlayStartVideoRunnable(WSPlayerManager paramWSPlayerManager, ukz paramukz, ulc paramulc, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ukz = paramukz;
    this.jdField_a_of_type_Ulc = paramulc;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] post thread");
    if ((!this.jdField_a_of_type_Boolean) && (!WSPlayerManager.a(this.this$0, this.jdField_a_of_type_Ulc))) {}
    long l;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Ukz == null) || (this.jdField_a_of_type_Ulc == null) || (WSPlayerManager.e(this.this$0)));
      if (!this.jdField_a_of_type_Boolean) {
        WSPlayerManager.a(this.this$0, true);
      }
      l = this.jdField_a_of_type_Ukz.jdField_a_of_type_Long;
      if (l > 0L) {
        WSPlayerManager.g(this.this$0, true);
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_Ukz.jdField_a_of_type_Uld.b));
    if ((WSPlayerManager.a(this.this$0) != null) && (WSPlayerManager.a(this.this$0).a(this.jdField_a_of_type_Ukz.jdField_a_of_type_Uld.b))) {}
    for (boolean bool = true;; bool = false)
    {
      uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] goto playerStartByUrl!! isPreDownload:" + bool + ", videoUrl:" + this.jdField_a_of_type_Ukz.jdField_a_of_type_Uld.b);
      this.jdField_a_of_type_Ulc.e(bool);
      if (this.jdField_a_of_type_Ulc.a("", this.jdField_a_of_type_Ukz.jdField_a_of_type_Uld.b, 2, l, 0L, this.jdField_a_of_type_Ukz.jdField_a_of_type_Uld.c, true, this.jdField_a_of_type_Ukz.jdField_a_of_type_Boolean)) {
        break;
      }
      uqf.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] playerStartByUrl failed, sendMsg retry.");
      WSPlayerManager.a(this.this$0).sendEmptyMessage(-4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */