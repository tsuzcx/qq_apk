package com.tencent.mobileqq.activity.aio.item;

class ArkSSODataRequest$Request
{
  String a;
  String b;
  long c = System.currentTimeMillis();
  
  ArkSSODataRequest$Request(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  int a()
  {
    return (int)(System.currentTimeMillis() - this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkSSODataRequest.Request
 * JD-Core Version:    0.7.0.1
 */