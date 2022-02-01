import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.StringTokenizer;

public abstract class bedf
{
  public int a;
  protected bedl a;
  public QQAppInterface a;
  public DataLineMsgRecord a;
  public String a;
  
  public bedf(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord, bedl parambedl)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord = paramDataLineMsgRecord;
    this.jdField_a_of_type_JavaLangString = paramDataLineMsgRecord.frienduin;
    this.jdField_a_of_type_Int = paramDataLineMsgRecord.istroop;
    this.jdField_a_of_type_Bedl = parambedl;
  }
  
  public abstract String a();
  
  public boolean a()
  {
    Object localObject = arqb.a().a();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      if (QLog.isColorLevel()) {
        QLog.i("BaseTimDataLineTipsProcessor", 1, "config filetype is null, or maybe has not recv");
      }
    }
    String str;
    do
    {
      while (!((StringTokenizer)localObject).hasMoreTokens())
      {
        do
        {
          return false;
          str = auog.a(a());
          localObject = new StringTokenizer((String)localObject, "|");
          if (((StringTokenizer)localObject).hasMoreTokens()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("BaseTimDataLineTipsProcessor", 1, "config filetype is null");
        return false;
      }
    } while (!str.equalsIgnoreCase(((StringTokenizer)localObject).nextToken()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedf
 * JD-Core Version:    0.7.0.1
 */