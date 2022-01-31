import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public abstract class bbaj
  implements bavp, bbcf
{
  int b = 0;
  
  public static int a()
  {
    return a(bavg.a().a());
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
      String str = bavg.a().a();
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
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, alwy paramalwy, bbbz parambbbz)
  {
    parambbbz.c = paramInt1;
    parambbbz.d = paramInt2;
    parambbbz.h = paramString1;
    parambbbz.g = paramString2;
    if (paramInt1 == 0)
    {
      parambbbz.e = 1;
      parambbbz.f = (paramalwy.c - 1);
      return;
    }
    parambbbz.e = 0;
    parambbbz.f = paramalwy.c;
    QLog.d("Q.richmedia.BaseHandler", 1, "result:" + paramInt1 + " errCode:" + paramInt2 + " reason:" + paramString1 + " errStr:" + paramString2);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, alwy paramalwy, List<bbbz> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInt1, paramInt2, paramString1, paramString2, paramalwy, (bbbz)paramList.next());
    }
  }
  
  void a(bbax parambbax, bavq parambavq)
  {
    b(parambbax);
    parambbax.jdField_a_of_type_Bavq = parambavq;
    if (parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null) {
      parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambavq);
    }
  }
  
  abstract void b(bbax parambbax);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbaj
 * JD-Core Version:    0.7.0.1
 */