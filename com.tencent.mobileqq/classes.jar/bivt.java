import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import dov.com.qq.im.ae.gif.video.PngsCreateWorkingQueue.1;
import dov.com.qq.im.ae.gif.video.PngsCreateWorkingQueue.3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

public class bivt
{
  private static String jdField_a_of_type_JavaLangString = "PngsCreateWorkingQueue";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bivr jdField_a_of_type_Bivr = new bivr();
  private bivv jdField_a_of_type_Bivv;
  private bivw jdField_a_of_type_Bivw;
  
  public bivt(String paramString, List<List<List<PointF>>> paramList, List<List<float[]>> paramList1, double paramDouble, Context paramContext)
  {
    this.jdField_a_of_type_Bivw = new bivw(paramString, paramList, paramList1, paramDouble);
    paramString = new HandlerThread("PngsCreateWorkingQueue");
    paramString.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramString.getLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_Bivr.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      QLog.d(jdField_a_of_type_JavaLangString, 4, "clear frame files, dir = " + str);
      bbdx.a(str);
    }
  }
  
  private void b(bivq parambivq)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "";
    Semaphore localSemaphore = new Semaphore(0);
    bitd localbitd = (bitd)bitc.jdField_a_of_type_JavaUtilList.get(bitc.jdField_a_of_type_ArrayOfInt[(parambivq.jdField_a_of_type_Int % bitc.jdField_a_of_type_ArrayOfInt.length)]);
    float f1 = 0.81F;
    float f2 = 0.16F;
    if (parambivq.b.contains("\n"))
    {
      f1 = 0.67F;
      f2 = 0.3F;
    }
    int i;
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      j = (int)(DeviceUtils.getScreenWidth(this.jdField_a_of_type_AndroidContentContext) * 0.44F) + 1;
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label242;
      }
      i = baxn.a(this.jdField_a_of_type_AndroidContentContext, 2.0F) * 320 / j;
      label119:
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label248;
      }
    }
    label242:
    label248:
    for (int j = baxn.c(this.jdField_a_of_type_AndroidContentContext, 23.0F) * 320 / j;; j = 19)
    {
      this.jdField_a_of_type_Bivw.a(parambivq.b, j, localbitd.jdField_a_of_type_JavaLangString, localbitd.b, i, 0.0F, f1, 1.0F, f2);
      this.jdField_a_of_type_Bivw.a(parambivq.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Bivw.a(new bivu(this, parambivq, arrayOfString, localSemaphore));
      try
      {
        localSemaphore.acquire();
        if (this.jdField_a_of_type_Bivv != null) {
          this.jdField_a_of_type_Bivv.a(parambivq.jdField_a_of_type_Int, arrayOfString[0]);
        }
        return;
      }
      catch (InterruptedException parambivq)
      {
        parambivq.printStackTrace();
      }
      j = 1920;
      break;
      i = 5;
      break label119;
    }
  }
  
  public bivr a()
  {
    return this.jdField_a_of_type_Bivr;
  }
  
  public void a(bivq parambivq)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreateWorkingQueue.1(this, parambivq));
  }
  
  public void a(bivv parambivv)
  {
    this.jdField_a_of_type_Bivv = parambivv;
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "stop, clearFiles = " + paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreateWorkingQueue.3(this, paramBoolean));
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bivt
 * JD-Core Version:    0.7.0.1
 */