import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

class apsu
  implements aufy<Emoticon>
{
  apsu(apss paramapss, int paramInt, String paramString) {}
  
  public void a(Emoticon paramEmoticon)
  {
    if ((paramEmoticon == null) || (!paramEmoticon.hasEncryptKey()))
    {
      this.jdField_a_of_type_Apss.a(Integer.toString(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, true);
      if (QLog.isColorLevel()) {
        QLog.d("SogouEmoji", 2, "func trySend ends, emotion has invalid key. Call func pullSingleEmojiKey");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Apss.a(paramEmoticon);
    } while (!QLog.isColorLevel());
    QLog.d("SogouEmoji", 2, "func trySend ends, everything is ok.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsu
 * JD-Core Version:    0.7.0.1
 */