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

public class bcgg
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static bcgg jdField_a_of_type_Bcgg;
  static WeakReference<BrowserAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private static final ArrayList<bcgj> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  final MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new bcgh(this);
  boolean jdField_a_of_type_Boolean = false;
  
  public static bcgg a()
  {
    if (jdField_a_of_type_Bcgg == null) {}
    try
    {
      if (jdField_a_of_type_Bcgg == null) {
        jdField_a_of_type_Bcgg = new bcgg();
      }
      return jdField_a_of_type_Bcgg;
    }
    finally {}
  }
  
  static void a()
  {
    try
    {
      nau.a("downloadX5KernelIfNeeded");
      BrowserAppInterface localBrowserAppInterface = (BrowserAppInterface)jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localBrowserAppInterface != null)
      {
        String str = WebAccelerateHelper.getInstance().getTBSDpcParam();
        if ((str == null) || (str.charAt(0) != '1') || (!"CN".equals(Locale.getDefault().getCountry()))) {
          break label91;
        }
        if (TbsDownloader.needDownload(BaseApplication.getContext(), false, false, new bcgi()))
        {
          localBrowserAppInterface.a(false);
          QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on idle:download tbs.");
        }
      }
      for (;;)
      {
        nau.b("downloadX5KernelIfNeeded");
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
      nau.b("downloadX5KernelIfNeeded");
    }
  }
  
  public static void a(BrowserAppInterface paramBrowserAppInterface)
  {
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBrowserAppInterface);
  }
  
  public void a(bcgj parambcgj)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((bcgj)localIterator.next()).jdField_a_of_type_Int != parambcgj.jdField_a_of_type_Int);
    }
    do
    {
      return;
      jdField_a_of_type_JavaUtilArrayList.add(parambcgj);
    } while ((jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_Boolean = true;
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  public boolean a(int paramInt)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bcgj localbcgj = (bcgj)localIterator.next();
      if (localbcgj.jdField_a_of_type_Int == paramInt)
      {
        jdField_a_of_type_JavaUtilArrayList.remove(localbcgj);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcgg
 * JD-Core Version:    0.7.0.1
 */