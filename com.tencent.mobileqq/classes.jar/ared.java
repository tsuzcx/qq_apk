import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class ared
  extends bgod
{
  ared(areb paramareb, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    Object localObject = parambgoe.a();
    int j = ((Bundle)localObject).getInt(parambgoe.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(areb.a(), 2, "coverDownloadListener| onDone:epId=" + ((EmoticonPackage)localObject).epId + " task:" + parambgoe + " localVersion=" + ((EmoticonPackage)localObject).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject).updateFlag);
    }
    int i = 0;
    if (parambgoe.a() != 3)
    {
      i = aqyy.a(parambgoe.a);
      if (areb.a(j)) {
        areb.jdField_a_of_type_Area.a((EmoticonPackage)localObject, j, -1, i);
      }
      areb.jdField_a_of_type_Area.a((EmoticonPackage)localObject, i, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      long l1 = parambgoe.h;
      long l2 = parambgoe.g;
      this.a.a((EmoticonPackage)localObject, i, l1 - l2, parambgoe.d);
      return;
      areb.jdField_a_of_type_Area.a((EmoticonPackage)localObject, j, 0, 0);
    }
  }
  
  public void onDoneFile(bgoe parambgoe)
  {
    Object localObject = parambgoe.a();
    int i = ((Bundle)localObject).getInt(parambgoe.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(areb.a(), 2, "coverDownloadListener | onProgress:epId=" + ((EmoticonPackage)localObject).epId + parambgoe);
    }
    if (areb.a(i)) {
      areb.jdField_a_of_type_Area.a((EmoticonPackage)localObject, i, 0, 0);
    }
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    return super.onStart(parambgoe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ared
 * JD-Core Version:    0.7.0.1
 */