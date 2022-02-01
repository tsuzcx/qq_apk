import com.tencent.qg.sdk.QGReporter.QGReporterImpl;

public class bjep
  implements QGReporter.QGReporterImpl
{
  public void reportEvent(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (yqp.a()) {
      yqp.b("QGReporter", "[tag]%s;[mainAction]%s;[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString5, paramString6, paramString7, paramString8 });
    }
    bcst.b(null, paramString1, paramString2, "", paramString3, paramString4, paramInt1, paramInt2, paramString5, paramString6, paramString7, paramString8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjep
 * JD-Core Version:    0.7.0.1
 */