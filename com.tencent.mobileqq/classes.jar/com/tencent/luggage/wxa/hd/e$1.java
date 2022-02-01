package com.tencent.luggage.wxa.hd;

import android.os.Process;
import android.widget.Toast;
import com.tencent.luggage.wxa.qz.r;

class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public void run()
  {
    Toast.makeText(r.a(), String.format("MediaCodecProxy queueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) }), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.e.1
 * JD-Core Version:    0.7.0.1
 */