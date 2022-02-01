package com.tencent.luggage.wxa.om;

class b$a$2
  implements f.a
{
  b$a$2(b.a parama) {}
  
  public void a(double paramDouble)
  {
    if (Math.round(b.a.a(this.a)) != Math.round(paramDouble))
    {
      b.a.a(this.a, paramDouble);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Math.round(b.a.a(this.a)));
      ((StringBuilder)localObject).append(" fps");
      localObject = ((StringBuilder)localObject).toString();
      b.a(this.a.a, 303, (String)localObject);
      c.a(this.a.b, "Hardware", "FPS", b.a.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.om.b.a.2
 * JD-Core Version:    0.7.0.1
 */