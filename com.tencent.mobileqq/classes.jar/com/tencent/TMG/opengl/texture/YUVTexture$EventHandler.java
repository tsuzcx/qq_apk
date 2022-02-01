package com.tencent.TMG.opengl.texture;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.TMG.opengl.GlStringParser;

class YUVTexture$EventHandler
  extends Handler
{
  public YUVTexture$EventHandler(YUVTexture paramYUVTexture, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          if (YUVTexture.access$000(this.this$0) != null)
          {
            if (YUVTexture.access$100(this.this$0) == null) {
              YUVTexture.access$102(this.this$0, new GlStringParser('=', ';'));
            }
            paramMessage = (String)paramMessage.obj;
            YUVTexture.access$100(this.this$0).unflatten(paramMessage);
            i = YUVTexture.access$100(this.this$0).getInt("width");
            int j = YUVTexture.access$100(this.this$0).getInt("height");
            int k = YUVTexture.access$100(this.this$0).getInt("angle");
            YUVTexture.access$000(this.this$0).onRenderInfoNotify(i, j, k);
          }
        }
        else if (YUVTexture.access$000(this.this$0) != null)
        {
          YUVTexture.access$000(this.this$0).onRenderReset();
        }
      }
      else if (YUVTexture.access$000(this.this$0) != null) {
        YUVTexture.access$000(this.this$0).onRenderFlush();
      }
    }
    else if (YUVTexture.access$000(this.this$0) != null) {
      YUVTexture.access$000(this.this$0).onRenderFrame();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.texture.YUVTexture.EventHandler
 * JD-Core Version:    0.7.0.1
 */