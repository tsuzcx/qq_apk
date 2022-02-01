import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class avvy
  implements bdvw
{
  avvy(avvw paramavvw) {}
  
  public void onResp(bdwt parambdwt)
  {
    boolean bool;
    Object localObject1;
    File localFile;
    int i;
    String str;
    label48:
    Object localObject2;
    if (parambdwt.jdField_a_of_type_Int == 0)
    {
      bool = true;
      localObject1 = (bdvs)parambdwt.jdField_a_of_type_Bdws;
      localFile = new File(((bdvs)localObject1).c);
      i = parambdwt.b;
      if (parambdwt.jdField_a_of_type_JavaLangString != null) {
        break label164;
      }
      str = "0";
      localObject2 = (Object[])((bdvs)localObject1).a();
      localObject1 = (MusicInfo)localObject2[0];
      localObject2 = (avwa)localObject2[1];
      if (!bool) {
        break label173;
      }
      ((avwa)localObject2).jdField_a_of_type_Int = 2;
      this.a.a(((MusicInfo)localObject1).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new ListenTogetherResDownloader.2.1(this, parambdwt, bool, (MusicInfo)localObject1));
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.downloader", 2, String.format("onResp, errCode: %s, errDesc: %s, musicReqInfo: %s", new Object[] { Integer.valueOf(i), str, localObject2 }));
      }
      return;
      bool = false;
      break;
      label164:
      str = parambdwt.jdField_a_of_type_JavaLangString;
      break label48;
      label173:
      if ((localFile != null) && (localFile.exists())) {
        localFile.delete();
      }
      ((avwa)localObject2).jdField_a_of_type_Int = 3;
      avvw.a(this.a, (MusicInfo)localObject1);
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvy
 * JD-Core Version:    0.7.0.1
 */