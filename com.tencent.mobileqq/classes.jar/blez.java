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

public class blez
  implements SurfaceTexture.OnFrameAvailableListener
{
  public blez(blex paramblex) {}
  
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
    QLog.d(blex.a(), 4, "PngsCreator onFrameAvailable()");
    paramSurfaceTexture.updateTexImage();
    blex.a(this.a).RenderProcess(blex.a(this.a), 960, 480, -1, 0.0D, blex.a(this.a));
    blex.a(this.a).a(blex.a(this.a));
    blbx localblbx = blex.a(this.a);
    Frame localFrame = blex.a(this.a);
    if (blex.b(this.a) < blex.a(this.a).size())
    {
      paramSurfaceTexture = a((List)blex.a(this.a).get(blex.b(this.a)));
      if (blex.b(this.a) >= blex.b(this.a).size()) {
        break label341;
      }
    }
    label341:
    for (Object localObject = b((List)blex.b(this.a).get(blex.b(this.a)));; localObject = new ArrayList())
    {
      paramSurfaceTexture = RendererUtils.saveTexture(localblbx.a(localFrame, 480, 480, paramSurfaceTexture, (List)localObject));
      paramSurfaceTexture.setPremultiplied(false);
      bkok.a(String.format(blex.a(this.a) + "/frame_%03d.png", new Object[] { Integer.valueOf(blex.b(this.a)) }), paramSurfaceTexture);
      paramSurfaceTexture.recycle();
      blex.c(this.a);
      if (!blex.a(this.a).a())
      {
        QLog.d(blex.a(), 4, "pngs create duration = " + (System.currentTimeMillis() - blex.a(this.a)));
        blex.a(this.a).a(blex.a(this.a));
      }
      return;
      paramSurfaceTexture = new ArrayList();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blez
 * JD-Core Version:    0.7.0.1
 */