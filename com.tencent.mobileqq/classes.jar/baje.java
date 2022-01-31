import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.StringTokenizer;

public abstract class baje
{
  public int a;
  public bajk a;
  public QQAppInterface a;
  public ChatMessage a;
  public String a;
  
  public baje(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, bajk parambajk)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
    this.jdField_a_of_type_Int = paramChatMessage.istroop;
    this.jdField_a_of_type_Bajk = parambajk;
  }
  
  public abstract String a();
  
  public abstract void a(bajf parambajf);
  
  public boolean a()
  {
    Object localObject = aoyr.a().c();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      if (QLog.isColorLevel()) {
        QLog.i("BaseTimAIOTipsProcessor", 1, "config filetype is null, or maybe has not recv");
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
          str = arso.a(a());
          localObject = new StringTokenizer((String)localObject, "|");
          if (((StringTokenizer)localObject).hasMoreTokens()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("BaseTimAIOTipsProcessor", 1, "config filetype is null");
        return false;
      }
    } while (!str.equalsIgnoreCase(((StringTokenizer)localObject).nextToken()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baje
 * JD-Core Version:    0.7.0.1
 */