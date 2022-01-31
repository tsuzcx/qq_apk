import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public abstract class ayyb
  implements aytj, ayzx
{
  int b = 0;
  
  public static int a()
  {
    return a(ayta.a().a());
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
      String str = ayta.a().a();
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
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, akau paramakau, ayzr paramayzr)
  {
    paramayzr.c = paramInt1;
    paramayzr.d = paramInt2;
    paramayzr.h = paramString1;
    paramayzr.g = paramString2;
    if (paramInt1 == 0)
    {
      paramayzr.e = 1;
      paramayzr.f = (paramakau.c - 1);
      return;
    }
    paramayzr.e = 0;
    paramayzr.f = paramakau.c;
    QLog.d("Q.richmedia.BaseHandler", 1, "result:" + paramInt1 + " errCode:" + paramInt2 + " reason:" + paramString1 + " errStr:" + paramString2);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, akau paramakau, List<ayzr> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInt1, paramInt2, paramString1, paramString2, paramakau, (ayzr)paramList.next());
    }
  }
  
  void a(ayyp paramayyp, aytk paramaytk)
  {
    b(paramayyp);
    paramayyp.jdField_a_of_type_Aytk = paramaytk;
    if (paramayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null) {
      paramayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaytk);
    }
  }
  
  abstract void b(ayyp paramayyp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyb
 * JD-Core Version:    0.7.0.1
 */