import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public abstract class bawa
  implements barg, baxw
{
  int b = 0;
  
  public static int a()
  {
    return a(baqx.a().a());
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
      String str = baqx.a().a();
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
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, alsj paramalsj, baxq parambaxq)
  {
    parambaxq.c = paramInt1;
    parambaxq.d = paramInt2;
    parambaxq.h = paramString1;
    parambaxq.g = paramString2;
    if (paramInt1 == 0)
    {
      parambaxq.e = 1;
      parambaxq.f = (paramalsj.c - 1);
      return;
    }
    parambaxq.e = 0;
    parambaxq.f = paramalsj.c;
    QLog.d("Q.richmedia.BaseHandler", 1, "result:" + paramInt1 + " errCode:" + paramInt2 + " reason:" + paramString1 + " errStr:" + paramString2);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, alsj paramalsj, List<baxq> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInt1, paramInt2, paramString1, paramString2, paramalsj, (baxq)paramList.next());
    }
  }
  
  void a(bawo parambawo, barh parambarh)
  {
    b(parambawo);
    parambawo.jdField_a_of_type_Barh = parambarh;
    if (parambawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null) {
      parambawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambarh);
    }
  }
  
  abstract void b(bawo parambawo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawa
 * JD-Core Version:    0.7.0.1
 */