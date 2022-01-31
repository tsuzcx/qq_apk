import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.List;

public class biar
  implements SurfaceTexture.OnFrameAvailableListener
{
  public biar(biap parambiap) {}
  
  @TargetApi(19)
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    QLog.d(biap.a(), 4, "PngsCreator onFrameAvailable()");
    paramSurfaceTexture.updateTexImage();
    biap.a(this.a).RenderProcess(biap.a(this.a), 960, 480, -1, 0.0D, biap.a(this.a));
    biap.a(this.a).a(biap.a(this.a));
    bhrz localbhrz = biap.a(this.a);
    Frame localFrame = biap.a(this.a);
    Object localObject;
    if (biap.b(this.a) < biap.a(this.a).size())
    {
      paramSurfaceTexture = (List)biap.a(this.a).get(biap.b(this.a));
      if (biap.b(this.a) >= biap.b(this.a).size()) {
        break label305;
      }
      localObject = (List)biap.b(this.a).get(biap.b(this.a));
      label169:
      paramSurfaceTexture = RendererUtils.saveTexture(localbhrz.a(localFrame, 480, 480, paramSurfaceTexture, (List)localObject));
      paramSurfaceTexture.setPremultiplied(false);
      bhfb.a(String.format(biap.a(this.a) + "/frame_%03d.png", new Object[] { Integer.valueOf(biap.b(this.a)) }), paramSurfaceTexture);
      paramSurfaceTexture.recycle();
      biap.c(this.a);
      if (!this.a.a()) {
        break label316;
      }
      if (biap.b(this.a) == 1) {
        biap.a(this.a).a(biap.a(this.a));
      }
    }
    label305:
    label316:
    while (biap.a(this.a).a())
    {
      return;
      paramSurfaceTexture = new ArrayList();
      break;
      localObject = new ArrayList();
      break label169;
    }
    QLog.d(biap.a(), 4, "pngs create duration = " + (System.currentTimeMillis() - biap.a(this.a)));
    biap.a(this.a).a(biap.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biar
 * JD-Core Version:    0.7.0.1
 */