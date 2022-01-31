import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

public class bhar
{
  private static bhar jdField_a_of_type_Bhar;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private bhat jdField_a_of_type_Bhat;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader;
  private Vector<bhat> jdField_a_of_type_JavaUtilVector = new Vector();
  private boolean jdField_a_of_type_Boolean;
  
  public static bhar a()
  {
    if (jdField_a_of_type_Bhar == null) {}
    try
    {
      jdField_a_of_type_Bhar = new bhar();
      return jdField_a_of_type_Bhar;
    }
    finally {}
  }
  
  /* Error */
  private Downloader a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	bhar:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 39	bhar:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 24	bhar:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   24: invokestatic 45	com/tencent/component/network/DownloaderFactory:getInstance	(Landroid/content/Context;)Lcom/tencent/component/network/DownloaderFactory;
    //   27: invokevirtual 48	com/tencent/component/network/DownloaderFactory:getCommonDownloader	()Lcom/tencent/component/network/downloader/Downloader;
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: invokevirtual 53	com/tencent/component/network/downloader/Downloader:enableResumeTransfer	()V
    //   37: aload_2
    //   38: astore_1
    //   39: aload_0
    //   40: aload_1
    //   41: putfield 39	bhar:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   44: aload_0
    //   45: getfield 39	bhar:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   48: ifnonnull +26 -> 74
    //   51: new 55	java/lang/RuntimeException
    //   54: dup
    //   55: ldc 57
    //   57: invokespecial 60	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   60: athrow
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 63	java/lang/Throwable:printStackTrace	()V
    //   71: goto -32 -> 39
    //   74: aload_0
    //   75: getfield 39	bhar:jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader	Lcom/tencent/component/network/downloader/Downloader;
    //   78: astore_1
    //   79: goto -65 -> 14
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	bhar
    //   13	28	1	localObject1	Object
    //   61	4	1	localObject2	Object
    //   78	1	1	localDownloader1	Downloader
    //   30	8	2	localDownloader2	Downloader
    //   66	2	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	14	61	finally
    //   20	31	61	finally
    //   33	37	61	finally
    //   39	61	61	finally
    //   67	71	61	finally
    //   74	79	61	finally
    //   20	31	66	java/lang/Throwable
    //   33	37	66	java/lang/Throwable
  }
  
  private boolean a(bhat parambhat)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (parambhat.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_JavaUtilVector.add(0, parambhat);
            return bool;
          }
          this.jdField_a_of_type_JavaUtilVector.add(parambhat);
          continue;
        }
        if (parambhat.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadRequest == null) {
          break label86;
        }
      }
      finally {}
      if (a().download(parambhat.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadRequest, parambhat.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Bhat = parambhat;
        this.jdField_a_of_type_Boolean = true;
        continue;
        label86:
        if (a().download(parambhat.jdField_b_of_type_JavaLangString, parambhat.jdField_a_of_type_JavaLangString, parambhat.jdField_b_of_type_Boolean, parambhat.jdField_b_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener))
        {
          this.jdField_a_of_type_Bhat = parambhat;
          this.jdField_a_of_type_Boolean = true;
        }
        else
        {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public void a(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    a().cancel(paramString, paramDownloadListener);
    if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
    {
      paramString = (bhat)this.jdField_a_of_type_JavaUtilVector.get(0);
      this.jdField_a_of_type_JavaUtilVector.remove(0);
      this.jdField_a_of_type_Boolean = false;
      a(paramString);
    }
  }
  
  public final boolean a(DownloadRequest paramDownloadRequest, boolean paramBoolean)
  {
    return a(null, null, paramBoolean, false, paramDownloadRequest, paramDownloadRequest.getListener());
  }
  
  public final boolean a(String paramString1, String paramString2, Downloader.DownloadListener paramDownloadListener)
  {
    return a(paramString1, paramString2, false, false, paramDownloadListener);
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean, Downloader.DownloadListener paramDownloadListener)
  {
    return a(paramString1, paramString2, paramBoolean, false, paramDownloadListener);
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DownloadRequest paramDownloadRequest, Downloader.DownloadListener paramDownloadListener)
  {
    bhat localbhat = new bhat(this);
    localbhat.jdField_a_of_type_JavaLangString = paramString2;
    localbhat.jdField_b_of_type_JavaLangString = paramString1;
    localbhat.jdField_b_of_type_Boolean = paramBoolean1;
    localbhat.jdField_a_of_type_Boolean = paramBoolean2;
    localbhat.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = paramDownloadListener;
    localbhat.jdField_b_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = new bhas(this, localbhat);
    if (paramDownloadRequest != null)
    {
      paramDownloadRequest.setListener(localbhat.jdField_b_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
      localbhat.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadRequest = paramDownloadRequest;
    }
    return a(localbhat);
  }
  
  public final boolean a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, Downloader.DownloadListener paramDownloadListener)
  {
    return a(paramString1, paramString2, paramBoolean1, paramBoolean2, null, paramDownloadListener);
  }
  
  public void b(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    a().abort(paramString, paramDownloadListener);
    if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
    {
      paramString = (bhat)this.jdField_a_of_type_JavaUtilVector.get(0);
      this.jdField_a_of_type_JavaUtilVector.remove(0);
      this.jdField_a_of_type_Boolean = false;
      a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhar
 * JD-Core Version:    0.7.0.1
 */