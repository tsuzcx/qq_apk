import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class asij
  extends bhyn
{
  asij(asih paramasih, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    Object localObject = parambhyo.a();
    int j = ((Bundle)localObject).getInt(parambhyo.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(asih.a(), 2, "coverDownloadListener| onDone:epId=" + ((EmoticonPackage)localObject).epId + " task:" + parambhyo + " localVersion=" + ((EmoticonPackage)localObject).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject).updateFlag);
    }
    int i = 0;
    if (parambhyo.a() != 3)
    {
      i = asdi.a(parambhyo.a);
      if (asih.a(j)) {
        asih.jdField_a_of_type_Asig.a((EmoticonPackage)localObject, j, -1, i);
      }
      asih.jdField_a_of_type_Asig.a((EmoticonPackage)localObject, i, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      long l1 = parambhyo.h;
      long l2 = parambhyo.g;
      this.a.a((EmoticonPackage)localObject, i, l1 - l2, parambhyo.d);
      return;
      asih.jdField_a_of_type_Asig.a((EmoticonPackage)localObject, j, 0, 0);
    }
  }
  
  public void onDoneFile(bhyo parambhyo)
  {
    Object localObject = parambhyo.a();
    int i = ((Bundle)localObject).getInt(parambhyo.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(asih.a(), 2, "coverDownloadListener | onProgress:epId=" + ((EmoticonPackage)localObject).epId + parambhyo);
    }
    if (asih.a(i)) {
      asih.jdField_a_of_type_Asig.a((EmoticonPackage)localObject, i, 0, 0);
    }
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    return super.onStart(parambhyo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asij
 * JD-Core Version:    0.7.0.1
 */