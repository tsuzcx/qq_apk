package com.tencent.luggage.wxa.hd;

import android.os.Process;
import android.widget.Toast;
import com.tencent.luggage.wxa.qz.r;

class e$3
  implements Runnable
{
  e$3(e parame) {}
  
  public void run()
  {
    Toast.makeText(r.a(), String.format("MediaCodecProxy dequeueOutputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) }), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.e.3
 * JD-Core Version:    0.7.0.1
 */