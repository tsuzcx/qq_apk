package com.tencent.luggage.wxa.ra;

class c$c$c
{
  b a;
  c b;
  boolean c;
  
  private c$c$c(c.c paramc) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state=");
    localStringBuilder.append(this.a.c());
    localStringBuilder.append(",active=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",parent=");
    Object localObject = this.b;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((c)localObject).a.c();
    }
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ra.c.c.c
 * JD-Core Version:    0.7.0.1
 */