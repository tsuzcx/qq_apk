import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class artt
  implements aysa
{
  artt(artr paramartr) {}
  
  public void onResp(aysx paramaysx)
  {
    boolean bool;
    Object localObject1;
    File localFile;
    int i;
    String str;
    label48:
    Object localObject2;
    if (paramaysx.jdField_a_of_type_Int == 0)
    {
      bool = true;
      localObject1 = (ayrv)paramaysx.jdField_a_of_type_Aysw;
      localFile = new File(((ayrv)localObject1).c);
      i = paramaysx.b;
      if (paramaysx.jdField_a_of_type_JavaLangString != null) {
        break label164;
      }
      str = "0";
      localObject2 = (Object[])((ayrv)localObject1).a();
      localObject1 = (MusicInfo)localObject2[0];
      localObject2 = (artv)localObject2[1];
      if (!bool) {
        break label173;
      }
      ((artv)localObject2).jdField_a_of_type_Int = 2;
      this.a.a(((MusicInfo)localObject1).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new ListenTogetherResDownloader.2.1(this, paramaysx, bool, (MusicInfo)localObject1));
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.downloader", 2, String.format("onResp, errCode: %s, errDesc: %s, musicReqInfo: %s", new Object[] { Integer.valueOf(i), str, localObject2 }));
      }
      return;
      bool = false;
      break;
      label164:
      str = paramaysx.jdField_a_of_type_JavaLangString;
      break label48;
      label173:
      if ((localFile != null) && (localFile.exists())) {
        localFile.delete();
      }
      ((artv)localObject2).jdField_a_of_type_Int = 3;
      artr.a(this.a, (MusicInfo)localObject1);
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     artt
 * JD-Core Version:    0.7.0.1
 */