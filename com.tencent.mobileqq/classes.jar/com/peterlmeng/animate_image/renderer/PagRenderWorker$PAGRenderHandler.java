package com.peterlmeng.animate_image.renderer;

import android.os.Handler.Callback;
import android.os.Message;
import com.peterlmeng.animate_image.ThreadManager;
import com.peterlmeng.animate_image.support.log.LogUtils;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.HashMap;
import java.util.Map;
import org.libpag.PAGPlayer;

class PagRenderWorker$PAGRenderHandler
  implements Handler.Callback
{
  public static final int MSG_DISPOSE = 1;
  public static final int MSG_DRAW = 0;
  
  public boolean handleMessage(Message paramMessage)
  {
    PagRenderWorker localPagRenderWorker = (PagRenderWorker)paramMessage.obj;
    if (paramMessage.what == 0)
    {
      if ((localPagRenderWorker != null) && (localPagRenderWorker.pagPlayer != null))
      {
        float f = paramMessage.arg1 / 1.0E+008F;
        localPagRenderWorker.pagPlayer.setProgress(f);
        try
        {
          localPagRenderWorker.pagPlayer.flush();
        }
        catch (Exception paramMessage)
        {
          LogUtils.b("PagRenderWorker", paramMessage.getMessage());
        }
        if (!localPagRenderWorker.firstFrame)
        {
          if (localPagRenderWorker.entry != null)
          {
            paramMessage = new StringBuilder();
            paramMessage.append("first frame ");
            paramMessage.append(localPagRenderWorker.entry.id());
            paramMessage.append(", url:");
            paramMessage.append(localPagRenderWorker.url);
            LogUtils.c("PagRenderWorker", paramMessage.toString());
          }
          if (localPagRenderWorker.onResourceLoadListener != null)
          {
            localPagRenderWorker.onResourceLoadListener.onResourceLoaded(null);
            localPagRenderWorker.resourceLoaded = true;
          }
          if (PagRenderWorker.access$100(localPagRenderWorker) != 1) {
            localPagRenderWorker.stop();
          }
          localPagRenderWorker.firstFrame = true;
          paramMessage = new HashMap();
          paramMessage.put("event", "on_first_frame");
          if (PagRenderWorker.access$500(localPagRenderWorker) != null) {
            ThreadManager.getsInstance().execute(3, new PagRenderWorker.PAGRenderHandler.1(this, localPagRenderWorker, paramMessage));
          }
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.PAGRenderHandler
 * JD-Core Version:    0.7.0.1
 */