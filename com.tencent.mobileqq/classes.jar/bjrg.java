import NS_MOBILE_CLIENT_REPORT.CLIENT_NBP_REPORT_REQ;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Map;

public class bjrg
  extends bjdo
{
  public JceStruct a;
  
  public bjrg(String paramString, ArrayList<String> paramArrayList, Map<String, String> paramMap)
  {
    CLIENT_NBP_REPORT_REQ localCLIENT_NBP_REPORT_REQ = new CLIENT_NBP_REPORT_REQ();
    localCLIENT_NBP_REPORT_REQ.strABTestId = paramString;
    localCLIENT_NBP_REPORT_REQ.report_info = paramArrayList;
    localCLIENT_NBP_REPORT_REQ.extra_info = paramMap;
    this.a = localCLIENT_NBP_REPORT_REQ;
  }
  
  public int a()
  {
    return 0;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.nbpClientReport";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "nbpClientReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjrg
 * JD-Core Version:    0.7.0.1
 */