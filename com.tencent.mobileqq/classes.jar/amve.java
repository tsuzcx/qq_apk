import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.CMSHelper.runOnAsyncHandler.1;
import com.tencent.mobileqq.apollo.player.CMSHelper.runOnAsyncThread.1;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/CMSHelper;", "", "()V", "ASYNC_POOL_MIN_COUNT", "", "asyncHandler", "Landroid/os/Handler;", "asyncThreadPool", "Ljava/util/concurrent/Executor;", "uiHandler", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "debug", "", "action", "Lkotlin/Function0;", "runOnAsyncHandler", "runOnAsyncThread", "runOnUiThread", "toast", "message", "", "iconType", "toActionStatus", "Lcom/tencent/mobileqq/apollo/player/CMSActionStatus;", "TF", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amve
{
  public static final amve a;
  private static final Handler jdField_a_of_type_AndroidOsHandler;
  private static final Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private static final Handler b;
  
  static
  {
    jdField_a_of_type_Amve = new amve();
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    int i = RangesKt.coerceAtLeast(Runtime.getRuntime().availableProcessors(), 4);
    Object localObject = new ThreadPoolExecutor(i, i, 1L, TimeUnit.MINUTES, (BlockingQueue)new LinkedBlockingQueue(), (ThreadFactory)new amvf("CMS_AsyncThread", 9));
    ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    jdField_a_of_type_JavaUtilConcurrentExecutor = (Executor)localObject;
    localObject = new HandlerThread("CMS_AsyncHandler");
    ((HandlerThread)localObject).start();
    b = new Handler(((HandlerThread)localObject).getLooper());
  }
  
  @NotNull
  public final CMSActionStatus a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return CMSActionStatus.UNKNOWN;
    case 1: 
      return CMSActionStatus.START;
    case 2: 
      return CMSActionStatus.COMPLETE;
    }
    return CMSActionStatus.INTERRUPT;
  }
  
  @Nullable
  public final QQAppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "action");
    jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)new CMSHelper.runOnAsyncThread.1(paramFunction0));
  }
  
  public final void b(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "action");
    b.post((Runnable)new CMSHelper.runOnAsyncHandler.1(paramFunction0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amve
 * JD-Core Version:    0.7.0.1
 */