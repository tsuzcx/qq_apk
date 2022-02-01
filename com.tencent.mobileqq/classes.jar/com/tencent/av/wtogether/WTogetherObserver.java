package com.tencent.av.wtogether;

import com.tencent.av.wtogether.data.ReqComResult;
import com.tencent.av.wtogether.data.WTReqUrlResult;
import com.tencent.mobileqq.app.BusinessObserver;

public class WTogetherObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString) {}
  
  protected void a(boolean paramBoolean, ReqComResult paramReqComResult) {}
  
  protected void a(boolean paramBoolean, WTReqUrlResult paramWTReqUrlResult) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void b(boolean paramBoolean, ReqComResult paramReqComResult) {}
  
  protected void c(boolean paramBoolean, ReqComResult paramReqComResult) {}
  
  protected void d(boolean paramBoolean, ReqComResult paramReqComResult) {}
  
  protected void e(boolean paramBoolean, ReqComResult paramReqComResult) {}
  
  protected void f(boolean paramBoolean, ReqComResult paramReqComResult) {}
  
  protected void g(boolean paramBoolean, ReqComResult paramReqComResult) {}
  
  protected void h(boolean paramBoolean, ReqComResult paramReqComResult) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 11: 
      a(paramBoolean, (String)paramObject);
      return;
    case 10: 
      paramObject = (ReqComResult)paramObject;
      a(paramBoolean, paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_Long, paramObject.jdField_a_of_type_JavaLangString);
      return;
    case 9: 
      h(paramBoolean, (ReqComResult)paramObject);
      return;
    case 8: 
      g(paramBoolean, (ReqComResult)paramObject);
      return;
    case 7: 
      f(paramBoolean, (ReqComResult)paramObject);
      return;
    case 6: 
      e(paramBoolean, (ReqComResult)paramObject);
      return;
    case 5: 
      d(paramBoolean, (ReqComResult)paramObject);
      return;
    case 4: 
      c(paramBoolean, (ReqComResult)paramObject);
      return;
    case 3: 
      b(paramBoolean, (ReqComResult)paramObject);
      return;
    case 2: 
      a(paramBoolean, (ReqComResult)paramObject);
      return;
    }
    a(paramBoolean, (WTReqUrlResult)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherObserver
 * JD-Core Version:    0.7.0.1
 */