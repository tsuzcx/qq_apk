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

public class bgtw
{
  private static bgtw jdField_a_of_type_Bgtw;
  private long jdField_a_of_type_Long;
  private ReaderInterfacePluginBuilder jdField_a_of_type_CooperationQqreaderProxyReaderInterfacePluginBuilder;
  private ReaderJsPluginBuilder jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginBuilder;
  private List<WeakReference<bgtx>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static bgtw a()
  {
    
    if (jdField_a_of_type_Bgtw == null) {}
    try
    {
      if (jdField_a_of_type_Bgtw == null) {
        jdField_a_of_type_Bgtw = new bgtw();
      }
      return jdField_a_of_type_Bgtw;
    }
    finally {}
  }
  
  private void b()
  {
    bgwf.c("QRPluginManagerClient", "dispatchPluginReadyEvent");
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator2.hasNext())
      {
        bgtx localbgtx = (bgtx)((WeakReference)localIterator2.next()).get();
        if (localbgtx != null) {
          localArrayList.add(localbgtx);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    finally {}
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext()) {
      c((bgtx)localIterator1.next());
    }
  }
  
  private void b(bgtx parambgtx)
  {
    if (parambgtx == null) {
      return;
    }
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      bgtx localbgtx;
      do
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label68;
          }
          localbgtx = (bgtx)((WeakReference)localIterator.next()).get();
          if (localbgtx != null) {
            break;
          }
          localIterator.remove();
        }
      } while (localbgtx != parambgtx);
    }
    finally {}
    return;
    label68:
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(parambgtx));
  }
  
  private static void c()
  {
    if (BaseApplicationImpl.sProcessId != 7) {
      bgwf.a("QRPluginManagerClient", "checkToolProcess: QRPluginManagerClient的逻辑必须在Tool进程调用");
    }
  }
  
  private void c(bgtx parambgtx)
  {
    if (parambgtx == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new QRPluginManagerClient.2(this, parambgtx));
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
      bgwf.a("QRPluginManagerClient", "startPluginActivityWhenReady: plugin is not ready");
      return;
    }
    if (bgvn.a())
    {
      bgvn.a(paramContext, paramIntent, paramString);
      return;
    }
    bgtq.a(paramContext, paramIntent, paramString);
  }
  
  public void a(bgtx parambgtx)
  {
    if (a()) {
      c(parambgtx);
    }
    do
    {
      return;
      b(parambgtx);
    } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 3000L);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (bgvn.a())
    {
      bgvn.a(BaseApplicationImpl.getApplication());
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
 * Qualified Name:     bgtw
 * JD-Core Version:    0.7.0.1
 */