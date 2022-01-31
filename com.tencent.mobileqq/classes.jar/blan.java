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

public class blan
{
  private static String jdField_a_of_type_JavaLangString = "PngsCreateWorkingQueue";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private blal jdField_a_of_type_Blal = new blal();
  private blap jdField_a_of_type_Blap;
  private blaq jdField_a_of_type_Blaq;
  
  public blan(String paramString, List<List<List<PointF>>> paramList, List<List<float[]>> paramList1, double paramDouble, Context paramContext)
  {
    this.jdField_a_of_type_Blaq = new blaq(paramString, paramList, paramList1, paramDouble);
    paramString = new HandlerThread("PngsCreateWorkingQueue");
    paramString.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramString.getLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_Blal.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      QLog.d(jdField_a_of_type_JavaLangString, 4, "clear frame files, dir = " + str);
      bdcs.a(str);
    }
  }
  
  private void b(blak paramblak)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "";
    Semaphore localSemaphore = new Semaphore(0);
    bkxw localbkxw = (bkxw)bkxv.jdField_a_of_type_JavaUtilList.get(bkxv.jdField_a_of_type_ArrayOfInt[(paramblak.jdField_a_of_type_Int % bkxv.jdField_a_of_type_ArrayOfInt.length)]);
    float f1 = 0.81F;
    float f2 = 0.16F;
    if (paramblak.b.contains("\n"))
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
      i = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 2.0F) * 320 / j;
      label119:
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label248;
      }
    }
    label242:
    label248:
    for (int j = bcwh.c(this.jdField_a_of_type_AndroidContentContext, 23.0F) * 320 / j;; j = 19)
    {
      this.jdField_a_of_type_Blaq.a(paramblak.b, j, localbkxw.jdField_a_of_type_JavaLangString, localbkxw.b, i, 0.0F, f1, 1.0F, f2);
      this.jdField_a_of_type_Blaq.a(paramblak.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Blaq.a(new blao(this, paramblak, arrayOfString, localSemaphore));
      try
      {
        localSemaphore.acquire();
        if (this.jdField_a_of_type_Blap != null) {
          this.jdField_a_of_type_Blap.a(paramblak.jdField_a_of_type_Int, arrayOfString[0]);
        }
        return;
      }
      catch (InterruptedException paramblak)
      {
        paramblak.printStackTrace();
      }
      j = 1920;
      break;
      i = 5;
      break label119;
    }
  }
  
  public blal a()
  {
    return this.jdField_a_of_type_Blal;
  }
  
  public void a(blak paramblak)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreateWorkingQueue.1(this, paramblak));
  }
  
  public void a(blap paramblap)
  {
    this.jdField_a_of_type_Blap = paramblap;
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 4, "stop, clearFiles = " + paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreateWorkingQueue.3(this, paramBoolean));
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blan
 * JD-Core Version:    0.7.0.1
 */