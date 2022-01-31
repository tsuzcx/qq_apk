import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public abstract class axxs
  implements axta, axzo
{
  int b = 0;
  
  public static int a()
  {
    return a(axsr.a().a());
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
      String str = axsr.a().a();
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
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, ajmn paramajmn, axzi paramaxzi)
  {
    paramaxzi.c = paramInt1;
    paramaxzi.d = paramInt2;
    paramaxzi.h = paramString1;
    paramaxzi.g = paramString2;
    if (paramInt1 == 0)
    {
      paramaxzi.e = 1;
      paramaxzi.f = (paramajmn.c - 1);
      return;
    }
    paramaxzi.e = 0;
    paramaxzi.f = paramajmn.c;
    QLog.d("Q.richmedia.BaseHandler", 1, "result:" + paramInt1 + " errCode:" + paramInt2 + " reason:" + paramString1 + " errStr:" + paramString2);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, ajmn paramajmn, List<axzi> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInt1, paramInt2, paramString1, paramString2, paramajmn, (axzi)paramList.next());
    }
  }
  
  void a(axyg paramaxyg, axtb paramaxtb)
  {
    b(paramaxyg);
    paramaxyg.jdField_a_of_type_Axtb = paramaxtb;
    if (paramaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null) {
      paramaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaxtb);
    }
  }
  
  abstract void b(axyg paramaxyg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxs
 * JD-Core Version:    0.7.0.1
 */