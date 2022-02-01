import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class aocd
  extends MqqHandler
{
  public aocd(FaceDownloader paramFaceDownloader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    while (paramMessage.what != 100) {
      return;
    }
    int i = 0;
    label16:
    if (i < this.a.b.size())
    {
      paramMessage = (aocg)this.a.b.get(i);
      if (paramMessage != null) {
        break label56;
      }
    }
    for (;;)
    {
      i += 1;
      break label16;
      break;
      label56:
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "handle download finish task.faceInfo=" + paramMessage.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo + ",bitmap=" + paramMessage.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      if ((paramMessage != null) && (paramMessage.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo != null) && (paramMessage.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.a.a.size() > 0))
      {
        int j = 0;
        while (j < this.a.a.size())
        {
          ((aoce)this.a.a.get(j)).a(true, paramMessage.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo, paramMessage.jdField_a_of_type_AndroidGraphicsBitmap);
          j += 1;
        }
      }
      this.a.b.remove(i);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aocd
 * JD-Core Version:    0.7.0.1
 */