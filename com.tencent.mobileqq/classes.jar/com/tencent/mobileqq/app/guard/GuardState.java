package com.tencent.mobileqq.app.guard;

import com.tencent.qphone.base.util.QLog;

public class GuardState
{
  protected static final String[] a;
  private static final String[] b = { "MSG", "RESUME", "TICK", "FG", "BG", "ENTER", "MAIN" };
  protected int a;
  protected GuardManager a;
  protected long c;
  protected long d;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "EMPTY", "BG_FETCH", "FG_MAIN", "FG_OTHER", "BG_GUARD", "BG_UNGUARD", "LITE_GUARD", "LITE_UNGUARD", "DEAD" };
  }
  
  public GuardState()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void a()
  {
    this.c += 1L;
    this.d += 1L;
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Int]);
      localStringBuilder.append(" onEvent ");
      localStringBuilder.append(b[paramInt]);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.d);
      QLog.d("GuardManager", 2, localStringBuilder.toString());
    }
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardManager.a(2, null);
      return;
    case 5: 
      b((String)paramObject);
      return;
    case 4: 
      d((String)paramObject);
      return;
    case 3: 
      a((String)paramObject);
      return;
    case 2: 
      a();
      return;
    case 1: 
      c((String)paramObject);
      return;
    }
    b();
  }
  
  protected void a(String paramString) {}
  
  protected void b() {}
  
  protected void b(String paramString)
  {
    this.d = 0L;
    this.c = 0L;
  }
  
  protected void c(String paramString) {}
  
  protected void d(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.guard.GuardState
 * JD-Core Version:    0.7.0.1
 */