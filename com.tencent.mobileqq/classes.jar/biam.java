import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import dov.com.qq.im.video.PngsCreateWorkingQueue.1;
import dov.com.qq.im.video.PngsCreateWorkingQueue.3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

public class biam
{
  private static String jdField_a_of_type_JavaLangString = "PngsCreateWorkingQueue";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private biak jdField_a_of_type_Biak = new biak();
  private biao jdField_a_of_type_Biao;
  private biap jdField_a_of_type_Biap;
  
  public biam(String paramString, List<List<List<PointF>>> paramList, List<List<float[]>> paramList1, double paramDouble, boolean paramBoolean, Context paramContext)
  {
    this.jdField_a_of_type_Biap = new biap(paramString, paramList, paramList1, paramDouble, paramBoolean);
    paramString = new HandlerThread("PngsCreateWorkingQueue");
    paramString.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramString.getLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_Biak.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      QLog.d(jdField_a_of_type_JavaLangString, 4, "clear frame files, dir = " + str);
      bace.a(str);
    }
  }
  
  private void b(biaj parambiaj)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "";
    Semaphore localSemaphore = new Semaphore(0);
    bhsi localbhsi = (bhsi)bhsh.jdField_a_of_type_JavaUtilList.get(bhsh.jdField_a_of_type_ArrayOfInt[(parambiaj.jdField_a_of_type_Int % bhsh.jdField_a_of_type_ArrayOfInt.length)]);
    float f1 = 0.81F;
    float f2 = 0.16F;
    if (parambiaj.b.contains("\n"))
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
      i = azvv.a(this.jdField_a_of_type_AndroidContentContext, 2.0F) * 320 / j;
      label119:
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label248;
      }
    }
    label242:
    label248:
    for (int j = azvv.c(this.jdField_a_of_type_AndroidContentContext, 23.0F) * 320 / j;; j = 19)
    {
      this.jdField_a_of_type_Biap.a(parambiaj.b, j, localbhsi.jdField_a_of_type_JavaLangString, localbhsi.b, i, 0.0F, f1, 1.0F, f2);
      this.jdField_a_of_type_Biap.a(parambiaj.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Biap.a(new bian(this, parambiaj, arrayOfString, localSemaphore));
      try
      {
        localSemaphore.acquire();
        if (this.jdField_a_of_type_Biao != null) {
          this.jdField_a_of_type_Biao.a(parambiaj.jdField_a_of_type_Int, arrayOfString[0]);
        }
        return;
      }
      catch (InterruptedException parambiaj)
      {
        parambiaj.printStackTrace();
      }
      j = 1920;
      break;
      i = 5;
      break label119;
    }
  }
  
  public biak a()
  {
    return this.jdField_a_of_type_Biak;
  }
  
  public void a(biaj parambiaj)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreateWorkingQueue.1(this, parambiaj));
  }
  
  public void a(biao parambiao)
  {
    this.jdField_a_of_type_Biao = parambiao;
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
 * Qualified Name:     biam
 * JD-Core Version:    0.7.0.1
 */