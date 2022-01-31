import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class aqyd
  implements axrt
{
  aqyd(aqyb paramaqyb) {}
  
  public void onResp(axsq paramaxsq)
  {
    boolean bool;
    Object localObject1;
    File localFile;
    int i;
    String str;
    label48:
    Object localObject2;
    if (paramaxsq.jdField_a_of_type_Int == 0)
    {
      bool = true;
      localObject1 = (axro)paramaxsq.jdField_a_of_type_Axsp;
      localFile = new File(((axro)localObject1).c);
      i = paramaxsq.b;
      if (paramaxsq.jdField_a_of_type_JavaLangString != null) {
        break label164;
      }
      str = "0";
      localObject2 = (Object[])((axro)localObject1).a();
      localObject1 = (MusicInfo)localObject2[0];
      localObject2 = (aqyf)localObject2[1];
      if (!bool) {
        break label173;
      }
      ((aqyf)localObject2).jdField_a_of_type_Int = 2;
      this.a.a(((MusicInfo)localObject1).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new ListenTogetherResDownloader.2.1(this, paramaxsq, bool, (MusicInfo)localObject1));
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.downloader", 2, String.format("onResp, errCode: %s, errDesc: %s, musicReqInfo: %s", new Object[] { Integer.valueOf(i), str, localObject2 }));
      }
      return;
      bool = false;
      break;
      label164:
      str = paramaxsq.jdField_a_of_type_JavaLangString;
      break label48;
      label173:
      if ((localFile != null) && (localFile.exists())) {
        localFile.delete();
      }
      ((aqyf)localObject2).jdField_a_of_type_Int = 3;
      aqyb.a(this.a, (MusicInfo)localObject1);
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqyd
 * JD-Core Version:    0.7.0.1
 */