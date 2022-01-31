import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsDownloader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class bejq
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static bejq jdField_a_of_type_Bejq;
  static WeakReference<BrowserAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private static final ArrayList<bejt> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  final MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new bejr(this);
  boolean jdField_a_of_type_Boolean = false;
  
  public static bejq a()
  {
    if (jdField_a_of_type_Bejq == null) {}
    try
    {
      if (jdField_a_of_type_Bejq == null) {
        jdField_a_of_type_Bejq = new bejq();
      }
      return jdField_a_of_type_Bejq;
    }
    finally {}
  }
  
  static void a()
  {
    try
    {
      ndq.a("downloadX5KernelIfNeeded");
      BrowserAppInterface localBrowserAppInterface = (BrowserAppInterface)jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localBrowserAppInterface != null)
      {
        String str = WebAccelerateHelper.getInstance().getTBSDpcParam();
        if ((str == null) || (str.charAt(0) != '1') || (!"CN".equals(Locale.getDefault().getCountry()))) {
          break label91;
        }
        if (TbsDownloader.needDownload(BaseApplication.getContext(), false, false, new bejs()))
        {
          localBrowserAppInterface.a(false);
          QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on idle:download tbs.");
        }
      }
      for (;;)
      {
        ndq.b("downloadX5KernelIfNeeded");
        return;
        label91:
        jdField_a_of_type_Int = 5;
        QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on idle: no need download tbs.");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SwiftBrowserIdleTaskHelper", 1, "downloadX5Kernel error:" + localThrowable.getMessage());
      ndq.b("downloadX5KernelIfNeeded");
    }
  }
  
  public static void a(BrowserAppInterface paramBrowserAppInterface)
  {
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBrowserAppInterface);
  }
  
  public void a(bejt parambejt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((bejt)localIterator.next()).jdField_a_of_type_Int != parambejt.jdField_a_of_type_Int);
    }
    do
    {
      return;
      jdField_a_of_type_JavaUtilArrayList.add(parambejt);
    } while ((jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_Boolean = true;
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  public boolean a(int paramInt)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bejt localbejt = (bejt)localIterator.next();
      if (localbejt.jdField_a_of_type_Int == paramInt)
      {
        jdField_a_of_type_JavaUtilArrayList.remove(localbejt);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejq
 * JD-Core Version:    0.7.0.1
 */