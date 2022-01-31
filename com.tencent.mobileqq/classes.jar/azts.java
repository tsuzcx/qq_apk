import com.tencent.qapmsdk.base.reporter.proxy.QAPMUploadProxy;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.reporter.BaseJsonObject;
import com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class azts
  extends QAPMUploadProxy
{
  azts(aztr paramaztr) {}
  
  public boolean report(@NotNull BaseJsonObject paramBaseJsonObject, @Nullable IReporter.ReportResultCallback paramReportResultCallback)
  {
    if ((paramBaseJsonObject instanceof ResultObject)) {}
    return super.report(paramBaseJsonObject, paramReportResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azts
 * JD-Core Version:    0.7.0.1
 */