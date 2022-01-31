import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class anwy
  extends anwl
{
  anwy(anwx paramanwx) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    super.a(paramEmoticonPackage, paramInt, paramBundle);
    if ((paramEmoticonPackage != null) && (paramInt == 0))
    {
      paramBundle = paramBundle.getBundle("jsonReqParams");
      if (paramBundle != null)
      {
        paramInt = paramBundle.getInt(anwx.jdField_a_of_type_JavaLangString);
        paramBundle = paramBundle.getString(anwx.b);
        if (QLog.isColorLevel()) {
          QLog.d("SogouEmoji", 2, "func onEmojiJsonBack begins, taskId:" + paramInt + ",packId:" + paramEmoticonPackage.epId);
        }
        boolean bool = this.a.jdField_a_of_type_Anxc.a(paramInt);
        if (bool) {
          this.a.a(paramEmoticonPackage.epId, paramBundle, false);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SogouEmoji", 2, "func onEmojiJsonBack ends, isTaskExist:" + bool);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anwy
 * JD-Core Version:    0.7.0.1
 */