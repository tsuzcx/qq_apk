package com.tencent.ilink.tdi;

public class y
{
  public static z a(String paramString)
  {
    return new aa(TdiInterfaceAdapter.create(paramString));
  }
  
  public static void a(z paramz)
  {
    if ((paramz != null) && ((paramz instanceof aa)))
    {
      long l = ((aa)paramz).f();
      TdiCallbackAdapter.removeCallback(l);
      TdiInterfaceAdapter.destroy(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.y
 * JD-Core Version:    0.7.0.1
 */