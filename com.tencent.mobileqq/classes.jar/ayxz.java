import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public abstract class ayxz
  implements ayth, ayzv
{
  int b = 0;
  
  public static int a()
  {
    return a(aysy.a().a());
  }
  
  public static int a(int paramInt)
  {
    int j = 6;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      String str = aysy.a().a();
      paramInt = i;
      if (str != null)
      {
        paramInt = i;
        if (str.contains("wap")) {
          paramInt = 5;
        }
      }
      return paramInt;
      i = 3;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, akaw paramakaw, ayzp paramayzp)
  {
    paramayzp.c = paramInt1;
    paramayzp.d = paramInt2;
    paramayzp.h = paramString1;
    paramayzp.g = paramString2;
    if (paramInt1 == 0)
    {
      paramayzp.e = 1;
      paramayzp.f = (paramakaw.c - 1);
      return;
    }
    paramayzp.e = 0;
    paramayzp.f = paramakaw.c;
    QLog.d("Q.richmedia.BaseHandler", 1, "result:" + paramInt1 + " errCode:" + paramInt2 + " reason:" + paramString1 + " errStr:" + paramString2);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, akaw paramakaw, List<ayzp> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInt1, paramInt2, paramString1, paramString2, paramakaw, (ayzp)paramList.next());
    }
  }
  
  void a(ayyn paramayyn, ayti paramayti)
  {
    b(paramayyn);
    paramayyn.jdField_a_of_type_Ayti = paramayti;
    if (paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null) {
      paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramayti);
    }
  }
  
  abstract void b(ayyn paramayyn);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayxz
 * JD-Core Version:    0.7.0.1
 */