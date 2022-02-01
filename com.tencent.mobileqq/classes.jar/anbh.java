import com.tencent.mobileqq.apollo.screenshot.ApolloApngEncoder;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resCode", "", "<anonymous parameter 1>", "Lcom/tencent/mobileqq/soload/LoadExtResult;", "kotlin.jvm.PlatformType", "onLoadResult"}, k=3, mv={1, 1, 16})
final class anbh
  implements bdgc
{
  public static final anbh a = new anbh();
  
  public final void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0)
    {
      QLog.d(ApolloApngEncoder.a.a(), 1, "loadLibIfNeed Success");
      ApolloApngEncoder.a.a(true);
      return;
    }
    QLog.e(ApolloApngEncoder.a.a(), 1, "loadLibIfNeed Error: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbh
 * JD-Core Version:    0.7.0.1
 */