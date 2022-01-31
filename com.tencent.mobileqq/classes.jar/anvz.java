import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class anvz
  extends bbwt
{
  anvz(anvx paramanvx, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    Object localObject = parambbwu.a();
    int j = ((Bundle)localObject).getInt(parambbwu.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "coverDownloadListener| onDone:epId=" + ((EmoticonPackage)localObject).epId + " task:" + parambbwu + " localVersion=" + ((EmoticonPackage)localObject).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject).updateFlag);
    }
    int i = 0;
    if (parambbwu.a() != 3)
    {
      i = anqz.a(parambbwu.a);
      if (anvx.a(j)) {
        anvx.jdField_a_of_type_Anvw.a((EmoticonPackage)localObject, j, -1, i);
      }
      anvx.jdField_a_of_type_Anvw.a((EmoticonPackage)localObject, i, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      long l1 = parambbwu.h;
      long l2 = parambbwu.g;
      this.a.a((EmoticonPackage)localObject, i, l1 - l2, parambbwu.d);
      return;
      anvx.jdField_a_of_type_Anvw.a((EmoticonPackage)localObject, j, 0, 0);
    }
  }
  
  public void onDoneFile(bbwu parambbwu)
  {
    Object localObject = parambbwu.a();
    int i = ((Bundle)localObject).getInt(parambbwu.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "coverDownloadListener | onProgress:epId=" + ((EmoticonPackage)localObject).epId + parambbwu);
    }
    if (anvx.a(i)) {
      anvx.jdField_a_of_type_Anvw.a((EmoticonPackage)localObject, i, 0, 0);
    }
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    return super.onStart(parambbwu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anvz
 * JD-Core Version:    0.7.0.1
 */