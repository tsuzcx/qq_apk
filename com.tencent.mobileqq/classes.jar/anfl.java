import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class anfl
  extends batl
{
  anfl(anfj paramanfj, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    Object localObject = parambatm.a();
    int j = ((Bundle)localObject).getInt(parambatm.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "coverDownloadListener| onDone:epId=" + ((EmoticonPackage)localObject).epId + " task:" + parambatm + " localVersion=" + ((EmoticonPackage)localObject).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject).updateFlag);
    }
    int i = 0;
    if (parambatm.a() != 3)
    {
      i = anam.a(parambatm.a);
      if (anfj.a(j)) {
        anfj.jdField_a_of_type_Anfi.a((EmoticonPackage)localObject, j, -1, i);
      }
      anfj.jdField_a_of_type_Anfi.a((EmoticonPackage)localObject, i, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      long l1 = parambatm.h;
      long l2 = parambatm.g;
      this.a.a((EmoticonPackage)localObject, i, l1 - l2, parambatm.d);
      return;
      anfj.jdField_a_of_type_Anfi.a((EmoticonPackage)localObject, j, 0, 0);
    }
  }
  
  public void onDoneFile(batm parambatm)
  {
    Object localObject = parambatm.a();
    int i = ((Bundle)localObject).getInt(parambatm.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "coverDownloadListener | onProgress:epId=" + ((EmoticonPackage)localObject).epId + parambatm);
    }
    if (anfj.a(i)) {
      anfj.jdField_a_of_type_Anfi.a((EmoticonPackage)localObject, i, 0, 0);
    }
  }
  
  public boolean onStart(batm parambatm)
  {
    return super.onStart(parambatm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anfl
 * JD-Core Version:    0.7.0.1
 */