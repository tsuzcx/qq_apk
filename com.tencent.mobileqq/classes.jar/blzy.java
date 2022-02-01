import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class blzy
  implements SurfaceTexture.OnFrameAvailableListener
{
  public blzy(blzw paramblzw) {}
  
  private List<List<PointF>> a(List<List<PointF>> paramList)
  {
    LinkedList localLinkedList1 = new LinkedList();
    int k = paramList.size();
    int i = 0;
    while (i < k)
    {
      List localList = (List)paramList.get(i);
      LinkedList localLinkedList2 = new LinkedList();
      int m = localList.size();
      int j = 0;
      while (j < m)
      {
        PointF localPointF = (PointF)localList.get(j);
        localLinkedList2.add(new PointF(localPointF.x, localPointF.y));
        j += 1;
      }
      localLinkedList1.add(localLinkedList2);
      i += 1;
    }
    return localLinkedList1;
  }
  
  private List<float[]> b(List<float[]> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    int k = paramList.size();
    int i = 0;
    while (i < k)
    {
      float[] arrayOfFloat1 = (float[])paramList.get(i);
      float[] arrayOfFloat2 = new float[arrayOfFloat1.length];
      int j = 0;
      while (j < arrayOfFloat1.length)
      {
        arrayOfFloat2[j] = arrayOfFloat1[j];
        j += 1;
      }
      localLinkedList.add(arrayOfFloat2);
      i += 1;
    }
    return localLinkedList;
  }
  
  @TargetApi(19)
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    QLog.d(blzw.a(), 4, "PngsCreator onFrameAvailable()");
    paramSurfaceTexture.updateTexImage();
    blzw.a(this.a).RenderProcess(blzw.a(this.a), 960, 480, -1, 0.0D, blzw.a(this.a));
    blzw.a(this.a).a(blzw.a(this.a));
    blwy localblwy = blzw.a(this.a);
    Frame localFrame = blzw.a(this.a);
    if (blzw.b(this.a) < blzw.a(this.a).size())
    {
      paramSurfaceTexture = a((List)blzw.a(this.a).get(blzw.b(this.a)));
      if (blzw.b(this.a) >= blzw.b(this.a).size()) {
        break label341;
      }
    }
    label341:
    for (Object localObject = b((List)blzw.b(this.a).get(blzw.b(this.a)));; localObject = new ArrayList())
    {
      paramSurfaceTexture = RendererUtils.saveTexture(localblwy.a(localFrame, 480, 480, paramSurfaceTexture, (List)localObject));
      paramSurfaceTexture.setPremultiplied(false);
      blin.a(String.format(blzw.a(this.a) + "/frame_%03d.png", new Object[] { Integer.valueOf(blzw.b(this.a)) }), paramSurfaceTexture);
      paramSurfaceTexture.recycle();
      blzw.c(this.a);
      if (!blzw.a(this.a).a())
      {
        QLog.d(blzw.a(), 4, "pngs create duration = " + (System.currentTimeMillis() - blzw.a(this.a)));
        blzw.a(this.a).a(blzw.a(this.a));
      }
      return;
      paramSurfaceTexture = new ArrayList();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzy
 * JD-Core Version:    0.7.0.1
 */