import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class askf
  extends biht
{
  askf(askd paramaskd, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    Object localObject = parambihu.a();
    int j = ((Bundle)localObject).getInt(parambihu.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(askd.a(), 2, "coverDownloadListener| onDone:epId=" + ((EmoticonPackage)localObject).epId + " task:" + parambihu + " localVersion=" + ((EmoticonPackage)localObject).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject).updateFlag);
    }
    int i = 0;
    if (parambihu.a() != 3)
    {
      i = asfa.a(parambihu.a);
      if (askd.a(j)) {
        askd.jdField_a_of_type_Askc.a((EmoticonPackage)localObject, j, -1, i);
      }
      askd.jdField_a_of_type_Askc.a((EmoticonPackage)localObject, i, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      long l1 = parambihu.h;
      long l2 = parambihu.g;
      this.a.a((EmoticonPackage)localObject, i, l1 - l2, parambihu.d);
      return;
      askd.jdField_a_of_type_Askc.a((EmoticonPackage)localObject, j, 0, 0);
    }
  }
  
  public void onDoneFile(bihu parambihu)
  {
    Object localObject = parambihu.a();
    int i = ((Bundle)localObject).getInt(parambihu.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(askd.a(), 2, "coverDownloadListener | onProgress:epId=" + ((EmoticonPackage)localObject).epId + parambihu);
    }
    if (askd.a(i)) {
      askd.jdField_a_of_type_Askc.a((EmoticonPackage)localObject, i, 0, 0);
    }
  }
  
  public boolean onStart(bihu parambihu)
  {
    return super.onStart(parambihu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askf
 * JD-Core Version:    0.7.0.1
 */