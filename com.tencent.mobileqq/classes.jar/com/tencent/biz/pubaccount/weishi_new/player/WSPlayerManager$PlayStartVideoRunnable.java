package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import android.text.TextUtils;
import urt;
import urw;
import urx;
import uya;

class WSPlayerManager$PlayStartVideoRunnable
  implements Runnable
{
  private urt jdField_a_of_type_Urt;
  private urw jdField_a_of_type_Urw;
  private boolean jdField_a_of_type_Boolean;
  
  WSPlayerManager$PlayStartVideoRunnable(WSPlayerManager paramWSPlayerManager, urt paramurt, urw paramurw, boolean paramBoolean)
  {
    this.jdField_a_of_type_Urt = paramurt;
    this.jdField_a_of_type_Urw = paramurw;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] post thread");
    if ((!this.jdField_a_of_type_Boolean) && (!WSPlayerManager.a(this.this$0, this.jdField_a_of_type_Urw))) {}
    long l;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Urt == null) || (this.jdField_a_of_type_Urw == null) || (WSPlayerManager.f(this.this$0)));
      if (!this.jdField_a_of_type_Boolean) {
        WSPlayerManager.a(this.this$0, true);
      }
      l = this.jdField_a_of_type_Urt.jdField_a_of_type_Long;
      if (l > 0L) {
        WSPlayerManager.g(this.this$0, true);
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_Urt.jdField_a_of_type_Urx.b));
    if ((WSPlayerManager.a(this.this$0) != null) && (WSPlayerManager.a(this.this$0).a(this.jdField_a_of_type_Urt.jdField_a_of_type_Urx.b))) {}
    for (boolean bool = true;; bool = false)
    {
      uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] goto playerStartByUrl!! isPreDownload:" + bool + ", videoUrl:" + this.jdField_a_of_type_Urt.jdField_a_of_type_Urx.b);
      this.jdField_a_of_type_Urw.e(bool);
      if (this.jdField_a_of_type_Urw.a("", this.jdField_a_of_type_Urt.jdField_a_of_type_Urx.b, 101, l, 0L, this.jdField_a_of_type_Urt.jdField_a_of_type_Urx.c, true, this.jdField_a_of_type_Urt.jdField_a_of_type_Boolean)) {
        break;
      }
      uya.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] playerStartByUrl failed, sendMsg retry.");
      WSPlayerManager.a(this.this$0).sendEmptyMessage(-4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */