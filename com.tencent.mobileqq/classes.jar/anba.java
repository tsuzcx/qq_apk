import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/request/ApolloRequestCallbackManager;", "", "()V", "mApolloRspCallbackMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/apollo/request/ApolloRequestCallbackManager$ApolloRspCallback;", "Lkotlin/collections/HashMap;", "requestIndex", "Ljava/util/concurrent/atomic/AtomicLong;", "handleRspCallBack", "", "callbackIndex", "success", "", "retCode", "errMsg", "", "recordApolloRspCallback", "callback", "intent", "Lmqq/app/NewIntent;", "ApolloRspCallback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class anba
{
  public static final anba a;
  private static final HashMap<Long, WeakReference<anbb>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  
  static
  {
    jdField_a_of_type_Anba = new anba();
  }
  
  public final void a(@Nullable anbb paramanbb, @NotNull NewIntent paramNewIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramNewIntent, "intent");
    if (paramanbb != null)
    {
      long l = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.incrementAndGet();
      paramNewIntent.putExtra("index", l);
      ((Map)jdField_a_of_type_JavaUtilHashMap).put(Long.valueOf(l), new WeakReference(paramanbb));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anba
 * JD-Core Version:    0.7.0.1
 */