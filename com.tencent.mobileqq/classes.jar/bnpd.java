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

public class bnpd
{
  private static String jdField_a_of_type_JavaLangString = "PngsCreateWorkingQueue";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bnpb jdField_a_of_type_Bnpb = new bnpb();
  private bnpf jdField_a_of_type_Bnpf;
  private bnpg jdField_a_of_type_Bnpg;
  private String b;
  
  public bnpd(String paramString1, List<List<List<PointF>>> paramList, List<List<float[]>> paramList1, double paramDouble, String paramString2, Context paramContext)
  {
    this.jdField_a_of_type_Bnpg = new bnpg(paramString1, paramList, paramList1, paramDouble);
    paramString1 = new HandlerThread("PngsCreateWorkingQueue");
    paramString1.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramString1.getLooper());
    this.b = paramString2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_Bnpb.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      QLog.d(jdField_a_of_type_JavaLangString, 4, "clear frame files, dir = " + str);
      FileUtils.deleteDirectory(str);
    }
  }
  
  private void b(bnpa parambnpa)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "";
    Semaphore localSemaphore = new Semaphore(0);
    bnmo localbnmo = (bnmo)bnmn.jdField_a_of_type_JavaUtilList.get(bnmn.jdField_a_of_type_ArrayOfInt[(parambnpa.jdField_a_of_type_Int % bnmn.jdField_a_of_type_ArrayOfInt.length)]);
    float f1 = 0.81F;
    float f2 = 0.16F;
    if (parambnpa.b.contains("\n"))
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
      this.jdField_a_of_type_Bnpg.a(parambnpa.b, j, localbnmo.jdField_a_of_type_JavaLangString, localbnmo.b, i, this.b, 0.0F, f1, 1.0F, f2);
      this.jdField_a_of_type_Bnpg.a(parambnpa.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Bnpg.a(new bnpe(this, parambnpa, arrayOfString, localSemaphore));
      try
      {
        localSemaphore.acquire();
        if (this.jdField_a_of_type_Bnpf != null) {
          this.jdField_a_of_type_Bnpf.a(parambnpa.jdField_a_of_type_Int, arrayOfString[0]);
        }
        return;
      }
      catch (InterruptedException parambnpa)
      {
        parambnpa.printStackTrace();
      }
      j = 1920;
      break;
      i = 5;
      break label119;
    }
  }
  
  public bnpb a()
  {
    return this.jdField_a_of_type_Bnpb;
  }
  
  public void a(bnpa parambnpa)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PngsCreateWorkingQueue.1(this, parambnpa));
  }
  
  public void a(bnpf parambnpf)
  {
    this.jdField_a_of_type_Bnpf = parambnpf;
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
 * Qualified Name:     bnpd
 * JD-Core Version:    0.7.0.1
 */