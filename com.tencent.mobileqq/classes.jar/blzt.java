import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import dov.com.qq.im.ae.gif.video.PngsCreateWorkingQueue.1;
import dov.com.qq.im.ae.gif.video.PngsCreateWorkingQueue.3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

public class blzt
{
  private static String jdField_a_of_type_JavaLangString = "PngsCreateWorkingQueue";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private blzr jdField_a_of_type_Blzr = new blzr();
  private blzv jdField_a_of_type_Blzv;
  private blzw jdField_a_of_type_Blzw;
  private String b;
  
  public blzt(String paramString1, List<List<List<PointF>>> paramList, List<List<float[]>> paramList1, double paramDouble, String paramString2, Context paramContext)
  {
    this.jdField_a_of_type_Blzw = new blzw(paramString1, paramList, paramList1, paramDouble);
    paramString1 = new HandlerThread("PngsCreateWorkingQueue");
    paramString1.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramString1.getLooper());
    this.b = paramString2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_Blzr.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      QLog.d(jdField_a_of_type_JavaLangString, 4, "clear frame files, dir = " + str);
      FileUtils.deleteDirectory(str);
    }
  }
  
  private void b(blzq paramblzq)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "";
    Semaphore localSemaphore = new Semaphore(0);
    blxe localblxe = (blxe)blxd.jdField_a_of_type_JavaUtilList.get(blxd.jdField_a_of_type_ArrayOfInt[(paramblzq.jdField_a_of_type_Int % blxd.jdField_a_of_type_ArrayOfInt.length)]);
    float f1 = 0.81F;
    float f2 = 0.16F;
    if (paramblzq.b.contains("\n"))
    {
      f1 = 0.67F;
      f2 = 0.3F;
    }
    int i;
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      j = (int)(DeviceUtils.getScreenWidth(this.jdField_a_of_type_AndroidContentContext) * 0.44F) + 1;
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label246;
      }
      i = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 2.0F) * 320 / j;
      label119:
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        break label252;
      }
    }
    label246:
    label252:
    for (int j = DisplayUtil.sp2px(this.jdField_a_of_type_AndroidContentContext, 23.0F) * 320 / j;; j = 19)
    {
      this.jdField_a_of_type_Blzw.a(paramblzq.b, j, localblxe.jdField_a_of_type_JavaLangString, localblxe.b, i, this.b, 0.0F, f1, 1.0F, f2);
      this.jdField_a_of_type_Blzw.a(paramblzq.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Blzw.a(new blzu(this, paramblzq, arrayOfString, localSemaphore));
      try
      {
        localSemaphore.acquire();
        if (this.jdField_a_of_type_Blzv != null) {
          this.jdField_a_of_type_Blzv.a(paramblzq.jdField_a_of_type_Int, arrayOfString[0]);
        }
        return;
      }
      catch (InterruptedException paramblzq)
      {
        paramblzq.printStackTrace();
      }
      j = 1920;
      break;
      i = 5;
      break label119;
    }
  }
  
  public blzr a()
  {
    return this.jdField_a_of_type_Blzr;
  }
  
  public void a(blzq paramblzq)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreateWorkingQueue.1(this, paramblzq));
  }
  
  public void a(blzv paramblzv)
  {
    this.jdField_a_of_type_Blzv = paramblzv;
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
 * Qualified Name:     blzt
 * JD-Core Version:    0.7.0.1
 */