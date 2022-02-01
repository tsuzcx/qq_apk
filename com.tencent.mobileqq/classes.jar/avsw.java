import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class avsw
  implements msq
{
  avsw(avsv paramavsv, String paramString) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoManager", 2, "start slientDownloadPlugin onResult:" + paramInt);
    }
    msj.a().a();
    if (paramInt == 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("roomCodeType", 1);
      localBundle.putLong("roomid", Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue());
      avsv.a(this.jdField_a_of_type_Avsv, localBundle, 1001L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsw
 * JD-Core Version:    0.7.0.1
 */