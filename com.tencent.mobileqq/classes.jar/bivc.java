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

public class bivc
{
  private static String jdField_a_of_type_JavaLangString = "PngsCreateWorkingQueue";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private biva jdField_a_of_type_Biva = new biva();
  private bive jdField_a_of_type_Bive;
  private bivf jdField_a_of_type_Bivf;
  
  public bivc(String paramString, List<List<List<PointF>>> paramList, List<List<float[]>> paramList1, double paramDouble, Context paramContext)
  {
    this.jdField_a_of_type_Bivf = new bivf(paramString, paramList, paramList1, paramDouble);
    paramString = new HandlerThread("PngsCreateWorkingQueue");
    paramString.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramString.getLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_Biva.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      QLog.d(jdField_a_of_type_JavaLangString, 4, "clear frame files, dir = " + str);
      bbdj.a(str);
    }
  }
  
  private void b(biuz parambiuz)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "";
    Semaphore localSemaphore = new Semaphore(0);
    bism localbism = (bism)bisl.jdField_a_of_type_JavaUtilList.get(bisl.jdField_a_of_type_ArrayOfInt[(parambiuz.jdField_a_of_type_Int % bisl.jdField_a_of_type_ArrayOfInt.length)]);
    float f1 = 0.81F;
    float f2 = 0.16F;
    if (parambiuz.b.contains("\n"))
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
      i = bawz.a(this.jdField_a_of_type_AndroidContentContext, 2.0F) * 320 / j;
      label119:
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label248;
      }
    }
    label242:
    label248:
    for (int j = bawz.c(this.jdField_a_of_type_AndroidContentContext, 23.0F) * 320 / j;; j = 19)
    {
      this.jdField_a_of_type_Bivf.a(parambiuz.b, j, localbism.jdField_a_of_type_JavaLangString, localbism.b, i, 0.0F, f1, 1.0F, f2);
      this.jdField_a_of_type_Bivf.a(parambiuz.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Bivf.a(new bivd(this, parambiuz, arrayOfString, localSemaphore));
      try
      {
        localSemaphore.acquire();
        if (this.jdField_a_of_type_Bive != null) {
          this.jdField_a_of_type_Bive.a(parambiuz.jdField_a_of_type_Int, arrayOfString[0]);
        }
        return;
      }
      catch (InterruptedException parambiuz)
      {
        parambiuz.printStackTrace();
      }
      j = 1920;
      break;
      i = 5;
      break label119;
    }
  }
  
  public biva a()
  {
    return this.jdField_a_of_type_Biva;
  }
  
  public void a(biuz parambiuz)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreateWorkingQueue.1(this, parambiuz));
  }
  
  public void a(bive parambive)
  {
    this.jdField_a_of_type_Bive = parambive;
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
 * Qualified Name:     bivc
 * JD-Core Version:    0.7.0.1
 */