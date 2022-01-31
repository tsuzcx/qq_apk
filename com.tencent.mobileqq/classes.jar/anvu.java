import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class anvu
  extends bbwf
{
  anvu(anvs paramanvs, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    Object localObject = parambbwg.a();
    int j = ((Bundle)localObject).getInt(parambbwg.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "coverDownloadListener| onDone:epId=" + ((EmoticonPackage)localObject).epId + " task:" + parambbwg + " localVersion=" + ((EmoticonPackage)localObject).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject).updateFlag);
    }
    int i = 0;
    if (parambbwg.a() != 3)
    {
      i = anqu.a(parambbwg.a);
      if (anvs.a(j)) {
        anvs.jdField_a_of_type_Anvr.a((EmoticonPackage)localObject, j, -1, i);
      }
      anvs.jdField_a_of_type_Anvr.a((EmoticonPackage)localObject, i, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      long l1 = parambbwg.h;
      long l2 = parambbwg.g;
      this.a.a((EmoticonPackage)localObject, i, l1 - l2, parambbwg.d);
      return;
      anvs.jdField_a_of_type_Anvr.a((EmoticonPackage)localObject, j, 0, 0);
    }
  }
  
  public void onDoneFile(bbwg parambbwg)
  {
    Object localObject = parambbwg.a();
    int i = ((Bundle)localObject).getInt(parambbwg.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "coverDownloadListener | onProgress:epId=" + ((EmoticonPackage)localObject).epId + parambbwg);
    }
    if (anvs.a(i)) {
      anvs.jdField_a_of_type_Anvr.a((EmoticonPackage)localObject, i, 0, 0);
    }
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    return super.onStart(parambbwg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anvu
 * JD-Core Version:    0.7.0.1
 */