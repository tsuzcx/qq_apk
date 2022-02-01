import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class awot
  implements beuq
{
  awot(awor paramawor) {}
  
  public void onResp(bevm parambevm)
  {
    boolean bool;
    Object localObject1;
    File localFile;
    int i;
    String str;
    label48:
    Object localObject2;
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      bool = true;
      localObject1 = (beum)parambevm.jdField_a_of_type_Bevl;
      localFile = new File(((beum)localObject1).c);
      i = parambevm.b;
      if (parambevm.jdField_a_of_type_JavaLangString != null) {
        break label164;
      }
      str = "0";
      localObject2 = (Object[])((beum)localObject1).a();
      localObject1 = (MusicInfo)localObject2[0];
      localObject2 = (awov)localObject2[1];
      if (!bool) {
        break label173;
      }
      ((awov)localObject2).jdField_a_of_type_Int = 2;
      this.a.a(((MusicInfo)localObject1).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new ListenTogetherResDownloader.2.1(this, parambevm, bool, (MusicInfo)localObject1));
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.downloader", 2, String.format("onResp, errCode: %s, errDesc: %s, musicReqInfo: %s", new Object[] { Integer.valueOf(i), str, localObject2 }));
      }
      return;
      bool = false;
      break;
      label164:
      str = parambevm.jdField_a_of_type_JavaLangString;
      break label48;
      label173:
      if ((localFile != null) && (localFile.exists())) {
        localFile.delete();
      }
      ((awov)localObject2).jdField_a_of_type_Int = 3;
      awor.a(this.a, (MusicInfo)localObject1);
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awot
 * JD-Core Version:    0.7.0.1
 */