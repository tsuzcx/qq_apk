import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class artv
  implements aysc
{
  artv(artt paramartt) {}
  
  public void onResp(aysz paramaysz)
  {
    boolean bool;
    Object localObject1;
    File localFile;
    int i;
    String str;
    label48:
    Object localObject2;
    if (paramaysz.jdField_a_of_type_Int == 0)
    {
      bool = true;
      localObject1 = (ayrx)paramaysz.jdField_a_of_type_Aysy;
      localFile = new File(((ayrx)localObject1).c);
      i = paramaysz.b;
      if (paramaysz.jdField_a_of_type_JavaLangString != null) {
        break label164;
      }
      str = "0";
      localObject2 = (Object[])((ayrx)localObject1).a();
      localObject1 = (MusicInfo)localObject2[0];
      localObject2 = (artx)localObject2[1];
      if (!bool) {
        break label173;
      }
      ((artx)localObject2).jdField_a_of_type_Int = 2;
      this.a.a(((MusicInfo)localObject1).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new ListenTogetherResDownloader.2.1(this, paramaysz, bool, (MusicInfo)localObject1));
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.downloader", 2, String.format("onResp, errCode: %s, errDesc: %s, musicReqInfo: %s", new Object[] { Integer.valueOf(i), str, localObject2 }));
      }
      return;
      bool = false;
      break;
      label164:
      str = paramaysz.jdField_a_of_type_JavaLangString;
      break label48;
      label173:
      if ((localFile != null) && (localFile.exists())) {
        localFile.delete();
      }
      ((artx)localObject2).jdField_a_of_type_Int = 3;
      artt.a(this.a, (MusicInfo)localObject1);
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     artv
 * JD-Core Version:    0.7.0.1
 */