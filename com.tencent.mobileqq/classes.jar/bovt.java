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

public class bovt
  implements SurfaceTexture.OnFrameAvailableListener
{
  public bovt(bovr parambovr) {}
  
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
    QLog.d(bovr.a(), 4, "PngsCreator onFrameAvailable()");
    paramSurfaceTexture.updateTexImage();
    bovr.a(this.a).RenderProcess(bovr.a(this.a), 960, 480, -1, 0.0D, bovr.a(this.a));
    bovr.a(this.a).a(bovr.a(this.a));
    bost localbost = bovr.a(this.a);
    Frame localFrame = bovr.a(this.a);
    if (bovr.b(this.a) < bovr.a(this.a).size())
    {
      paramSurfaceTexture = a((List)bovr.a(this.a).get(bovr.b(this.a)));
      if (bovr.b(this.a) >= bovr.b(this.a).size()) {
        break label341;
      }
    }
    label341:
    for (Object localObject = b((List)bovr.b(this.a).get(bovr.b(this.a)));; localObject = new ArrayList())
    {
      paramSurfaceTexture = RendererUtils.saveTexture(localbost.a(localFrame, 480, 480, paramSurfaceTexture, (List)localObject));
      paramSurfaceTexture.setPremultiplied(false);
      boef.a(String.format(bovr.a(this.a) + "/frame_%03d.png", new Object[] { Integer.valueOf(bovr.b(this.a)) }), paramSurfaceTexture);
      paramSurfaceTexture.recycle();
      bovr.c(this.a);
      if (!bovr.a(this.a).a())
      {
        QLog.d(bovr.a(), 4, "pngs create duration = " + (System.currentTimeMillis() - bovr.a(this.a)));
        bovr.a(this.a).a(bovr.a(this.a));
      }
      return;
      paramSurfaceTexture = new ArrayList();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bovt
 * JD-Core Version:    0.7.0.1
 */