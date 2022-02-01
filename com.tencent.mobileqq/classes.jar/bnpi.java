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

public class bnpi
  implements SurfaceTexture.OnFrameAvailableListener
{
  public bnpi(bnpg parambnpg) {}
  
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
    QLog.d(bnpg.a(), 4, "PngsCreator onFrameAvailable()");
    paramSurfaceTexture.updateTexImage();
    bnpg.a(this.a).RenderProcess(bnpg.a(this.a), 960, 480, -1, 0.0D, bnpg.a(this.a));
    bnpg.a(this.a).a(bnpg.a(this.a));
    bnmi localbnmi = bnpg.a(this.a);
    Frame localFrame = bnpg.a(this.a);
    if (bnpg.b(this.a) < bnpg.a(this.a).size())
    {
      paramSurfaceTexture = a((List)bnpg.a(this.a).get(bnpg.b(this.a)));
      if (bnpg.b(this.a) >= bnpg.b(this.a).size()) {
        break label341;
      }
    }
    label341:
    for (Object localObject = b((List)bnpg.b(this.a).get(bnpg.b(this.a)));; localObject = new ArrayList())
    {
      paramSurfaceTexture = RendererUtils.saveTexture(localbnmi.a(localFrame, 480, 480, paramSurfaceTexture, (List)localObject));
      paramSurfaceTexture.setPremultiplied(false);
      bmve.a(String.format(bnpg.a(this.a) + "/frame_%03d.png", new Object[] { Integer.valueOf(bnpg.b(this.a)) }), paramSurfaceTexture);
      paramSurfaceTexture.recycle();
      bnpg.c(this.a);
      if (!bnpg.a(this.a).a())
      {
        QLog.d(bnpg.a(), 4, "pngs create duration = " + (System.currentTimeMillis() - bnpg.a(this.a)));
        bnpg.a(this.a).a(bnpg.a(this.a));
      }
      return;
      paramSurfaceTexture = new ArrayList();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpi
 * JD-Core Version:    0.7.0.1
 */