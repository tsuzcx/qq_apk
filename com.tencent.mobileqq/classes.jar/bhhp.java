import com.tencent.mobileqq.vip.KCWraperV2.1;
import com.tencent.qphone.base.util.QLog;
import dualsim.common.ILogPrint;

public class bhhp
  implements ILogPrint
{
  public bhhp(KCWraperV2.1 param1) {}
  
  public void print(String paramString)
  {
    String str2 = this.a.this$0.a();
    String str1 = paramString;
    if (paramString == null) {
      str1 = "\n";
    }
    QLog.e(str2, 1, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhhp
 * JD-Core Version:    0.7.0.1
 */