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

public class bleu
{
  private static String jdField_a_of_type_JavaLangString = "PngsCreateWorkingQueue";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bles jdField_a_of_type_Bles = new bles();
  private blew jdField_a_of_type_Blew;
  private blex jdField_a_of_type_Blex;
  
  public bleu(String paramString, List<List<List<PointF>>> paramList, List<List<float[]>> paramList1, double paramDouble, Context paramContext)
  {
    this.jdField_a_of_type_Blex = new blex(paramString, paramList, paramList1, paramDouble);
    paramString = new HandlerThread("PngsCreateWorkingQueue");
    paramString.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramString.getLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_Bles.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      QLog.d(jdField_a_of_type_JavaLangString, 4, "clear frame files, dir = " + str);
      bdhb.a(str);
    }
  }
  
  private void b(bler parambler)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "";
    Semaphore localSemaphore = new Semaphore(0);
    blcd localblcd = (blcd)blcc.jdField_a_of_type_JavaUtilList.get(blcc.jdField_a_of_type_ArrayOfInt[(parambler.jdField_a_of_type_Int % blcc.jdField_a_of_type_ArrayOfInt.length)]);
    float f1 = 0.81F;
    float f2 = 0.16F;
    if (parambler.b.contains("\n"))
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
      i = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 2.0F) * 320 / j;
      label119:
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label248;
      }
    }
    label242:
    label248:
    for (int j = bdaq.c(this.jdField_a_of_type_AndroidContentContext, 23.0F) * 320 / j;; j = 19)
    {
      this.jdField_a_of_type_Blex.a(parambler.b, j, localblcd.jdField_a_of_type_JavaLangString, localblcd.b, i, 0.0F, f1, 1.0F, f2);
      this.jdField_a_of_type_Blex.a(parambler.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Blex.a(new blev(this, parambler, arrayOfString, localSemaphore));
      try
      {
        localSemaphore.acquire();
        if (this.jdField_a_of_type_Blew != null) {
          this.jdField_a_of_type_Blew.a(parambler.jdField_a_of_type_Int, arrayOfString[0]);
        }
        return;
      }
      catch (InterruptedException parambler)
      {
        parambler.printStackTrace();
      }
      j = 1920;
      break;
      i = 5;
      break label119;
    }
  }
  
  public bles a()
  {
    return this.jdField_a_of_type_Bles;
  }
  
  public void a(bler parambler)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreateWorkingQueue.1(this, parambler));
  }
  
  public void a(blew paramblew)
  {
    this.jdField_a_of_type_Blew = paramblew;
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
 * Qualified Name:     bleu
 * JD-Core Version:    0.7.0.1
 */