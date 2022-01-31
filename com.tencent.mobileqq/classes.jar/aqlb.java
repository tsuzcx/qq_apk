import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.Callable;

class aqlb
  implements Callable<aqkc>
{
  aqlb(aqkz paramaqkz) {}
  
  public aqkc a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    return aqkl.b(aqkz.a(this.a).getApplication(), "GVideo", localQQAppInterface.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqlb
 * JD-Core Version:    0.7.0.1
 */