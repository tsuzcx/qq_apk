import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class arur
  extends bhhe
{
  arur(arup paramarup, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    Object localObject = parambhhf.a();
    int j = ((Bundle)localObject).getInt(parambhhf.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "coverDownloadListener| onDone:epId=" + ((EmoticonPackage)localObject).epId + " task:" + parambhhf + " localVersion=" + ((EmoticonPackage)localObject).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject).updateFlag);
    }
    int i = 0;
    if (parambhhf.a() != 3)
    {
      i = arpm.a(parambhhf.a);
      if (arup.a(j)) {
        arup.jdField_a_of_type_Aruo.a((EmoticonPackage)localObject, j, -1, i);
      }
      arup.jdField_a_of_type_Aruo.a((EmoticonPackage)localObject, i, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      long l1 = parambhhf.h;
      long l2 = parambhhf.g;
      this.a.a((EmoticonPackage)localObject, i, l1 - l2, parambhhf.d);
      return;
      arup.jdField_a_of_type_Aruo.a((EmoticonPackage)localObject, j, 0, 0);
    }
  }
  
  public void onDoneFile(bhhf parambhhf)
  {
    Object localObject = parambhhf.a();
    int i = ((Bundle)localObject).getInt(parambhhf.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "coverDownloadListener | onProgress:epId=" + ((EmoticonPackage)localObject).epId + parambhhf);
    }
    if (arup.a(i)) {
      arup.jdField_a_of_type_Aruo.a((EmoticonPackage)localObject, i, 0, 0);
    }
  }
  
  public boolean onStart(bhhf parambhhf)
  {
    return super.onStart(parambhhf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arur
 * JD-Core Version:    0.7.0.1
 */