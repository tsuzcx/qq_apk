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

public class bivh
  implements SurfaceTexture.OnFrameAvailableListener
{
  public bivh(bivf parambivf) {}
  
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
    QLog.d(bivf.a(), 4, "PngsCreator onFrameAvailable()");
    paramSurfaceTexture.updateTexImage();
    bivf.a(this.a).RenderProcess(bivf.a(this.a), 960, 480, -1, 0.0D, bivf.a(this.a));
    bivf.a(this.a).a(bivf.a(this.a));
    bisg localbisg = bivf.a(this.a);
    Frame localFrame = bivf.a(this.a);
    if (bivf.b(this.a) < bivf.a(this.a).size())
    {
      paramSurfaceTexture = a((List)bivf.a(this.a).get(bivf.b(this.a)));
      if (bivf.b(this.a) >= bivf.b(this.a).size()) {
        break label341;
      }
    }
    label341:
    for (Object localObject = b((List)bivf.b(this.a).get(bivf.b(this.a)));; localObject = new ArrayList())
    {
      paramSurfaceTexture = RendererUtils.saveTexture(localbisg.a(localFrame, 480, 480, paramSurfaceTexture, (List)localObject));
      paramSurfaceTexture.setPremultiplied(false);
      bihr.a(String.format(bivf.a(this.a) + "/frame_%03d.png", new Object[] { Integer.valueOf(bivf.b(this.a)) }), paramSurfaceTexture);
      paramSurfaceTexture.recycle();
      bivf.c(this.a);
      if (!bivf.a(this.a).a())
      {
        QLog.d(bivf.a(), 4, "pngs create duration = " + (System.currentTimeMillis() - bivf.a(this.a)));
        bivf.a(this.a).a(bivf.a(this.a));
      }
      return;
      paramSurfaceTexture = new ArrayList();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bivh
 * JD-Core Version:    0.7.0.1
 */