import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class apnh
  extends bdvu
{
  apnh(apnf paramapnf, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    Object localObject = parambdvv.a();
    int j = ((Bundle)localObject).getInt(parambdvv.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "coverDownloadListener| onDone:epId=" + ((EmoticonPackage)localObject).epId + " task:" + parambdvv + " localVersion=" + ((EmoticonPackage)localObject).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject).updateFlag);
    }
    int i = 0;
    if (parambdvv.a() != 3)
    {
      i = apih.a(parambdvv.a);
      if (apnf.a(j)) {
        apnf.jdField_a_of_type_Apne.a((EmoticonPackage)localObject, j, -1, i);
      }
      apnf.jdField_a_of_type_Apne.a((EmoticonPackage)localObject, i, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      long l1 = parambdvv.h;
      long l2 = parambdvv.g;
      this.a.a((EmoticonPackage)localObject, i, l1 - l2, parambdvv.d);
      return;
      apnf.jdField_a_of_type_Apne.a((EmoticonPackage)localObject, j, 0, 0);
    }
  }
  
  public void onDoneFile(bdvv parambdvv)
  {
    Object localObject = parambdvv.a();
    int i = ((Bundle)localObject).getInt(parambdvv.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "coverDownloadListener | onProgress:epId=" + ((EmoticonPackage)localObject).epId + parambdvv);
    }
    if (apnf.a(i)) {
      apnf.jdField_a_of_type_Apne.a((EmoticonPackage)localObject, i, 0, 0);
    }
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    return super.onStart(parambdvv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnh
 * JD-Core Version:    0.7.0.1
 */