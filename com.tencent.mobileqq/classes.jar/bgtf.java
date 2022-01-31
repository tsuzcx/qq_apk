import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qqreader.QRPluginManagerClient.1;
import cooperation.qqreader.QRPluginManagerClient.2;
import cooperation.qqreader.proxy.ReaderInterfacePluginBuilder;
import cooperation.qqreader.proxy.ReaderInterfacePluginProxy;
import cooperation.qqreader.proxy.ReaderJsCallback;
import cooperation.qqreader.proxy.ReaderJsPluginBuilder;
import cooperation.qqreader.proxy.ReaderJsPluginProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class bgtf
{
  private static bgtf jdField_a_of_type_Bgtf;
  private long jdField_a_of_type_Long;
  private ReaderInterfacePluginBuilder jdField_a_of_type_CooperationQqreaderProxyReaderInterfacePluginBuilder;
  private ReaderJsPluginBuilder jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginBuilder;
  private List<WeakReference<bgtg>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static bgtf a()
  {
    
    if (jdField_a_of_type_Bgtf == null) {}
    try
    {
      if (jdField_a_of_type_Bgtf == null) {
        jdField_a_of_type_Bgtf = new bgtf();
      }
      return jdField_a_of_type_Bgtf;
    }
    finally {}
  }
  
  private void b()
  {
    bgvo.c("QRPluginManagerClient", "dispatchPluginReadyEvent");
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator2.hasNext())
      {
        bgtg localbgtg = (bgtg)((WeakReference)localIterator2.next()).get();
        if (localbgtg != null) {
          localArrayList.add(localbgtg);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    finally {}
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext()) {
      c((bgtg)localIterator1.next());
    }
  }
  
  private void b(bgtg parambgtg)
  {
    if (parambgtg == null) {
      return;
    }
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      bgtg localbgtg;
      do
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label68;
          }
          localbgtg = (bgtg)((WeakReference)localIterator.next()).get();
          if (localbgtg != null) {
            break;
          }
          localIterator.remove();
        }
      } while (localbgtg != parambgtg);
    }
    finally {}
    return;
    label68:
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(parambgtg));
  }
  
  private static void c()
  {
    if (BaseApplicationImpl.sProcessId != 7) {
      bgvo.a("QRPluginManagerClient", "checkToolProcess: QRPluginManagerClient的逻辑必须在Tool进程调用");
    }
  }
  
  private void c(bgtg parambgtg)
  {
    if (parambgtg == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new QRPluginManagerClient.2(this, parambgtg));
  }
  
  @Nullable
  public ReaderInterfacePluginProxy a()
  {
    if (this.jdField_a_of_type_CooperationQqreaderProxyReaderInterfacePluginBuilder == null) {
      return null;
    }
    return this.jdField_a_of_type_CooperationQqreaderProxyReaderInterfacePluginBuilder.create();
  }
  
  @Nullable
  public ReaderJsPluginProxy a(ReaderJsCallback paramReaderJsCallback)
  {
    if (this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginBuilder == null) {
      return null;
    }
    return this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginBuilder.create(paramReaderJsCallback);
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(Context paramContext, Intent paramIntent, String paramString)
  {
    if (!a())
    {
      bgvo.a("QRPluginManagerClient", "startPluginActivityWhenReady: plugin is not ready");
      return;
    }
    if (bguw.a())
    {
      bguw.a(paramContext, paramIntent, paramString);
      return;
    }
    bgsz.a(paramContext, paramIntent, paramString);
  }
  
  public void a(bgtg parambgtg)
  {
    if (a()) {
      c(parambgtg);
    }
    do
    {
      return;
      b(parambgtg);
    } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 3000L);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (bguw.a())
    {
      bguw.a(BaseApplicationImpl.getApplication());
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QRPluginManagerClient.1(this));
  }
  
  public void a(ReaderJsPluginBuilder paramReaderJsPluginBuilder, ReaderInterfacePluginBuilder paramReaderInterfacePluginBuilder)
  {
    this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginBuilder = paramReaderJsPluginBuilder;
    this.jdField_a_of_type_CooperationQqreaderProxyReaderInterfacePluginBuilder = paramReaderInterfacePluginBuilder;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtf
 * JD-Core Version:    0.7.0.1
 */