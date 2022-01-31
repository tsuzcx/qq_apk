import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class aprq
  extends bead
{
  aprq(apro paramapro, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    Object localObject = parambeae.a();
    int j = ((Bundle)localObject).getInt(parambeae.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "coverDownloadListener| onDone:epId=" + ((EmoticonPackage)localObject).epId + " task:" + parambeae + " localVersion=" + ((EmoticonPackage)localObject).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject).updateFlag);
    }
    int i = 0;
    if (parambeae.a() != 3)
    {
      i = apmq.a(parambeae.a);
      if (apro.a(j)) {
        apro.jdField_a_of_type_Aprn.a((EmoticonPackage)localObject, j, -1, i);
      }
      apro.jdField_a_of_type_Aprn.a((EmoticonPackage)localObject, i, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      long l1 = parambeae.h;
      long l2 = parambeae.g;
      this.a.a((EmoticonPackage)localObject, i, l1 - l2, parambeae.d);
      return;
      apro.jdField_a_of_type_Aprn.a((EmoticonPackage)localObject, j, 0, 0);
    }
  }
  
  public void onDoneFile(beae parambeae)
  {
    Object localObject = parambeae.a();
    int i = ((Bundle)localObject).getInt(parambeae.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "coverDownloadListener | onProgress:epId=" + ((EmoticonPackage)localObject).epId + parambeae);
    }
    if (apro.a(i)) {
      apro.jdField_a_of_type_Aprn.a((EmoticonPackage)localObject, i, 0, 0);
    }
  }
  
  public boolean onStart(beae parambeae)
  {
    return super.onStart(parambeae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aprq
 * JD-Core Version:    0.7.0.1
 */