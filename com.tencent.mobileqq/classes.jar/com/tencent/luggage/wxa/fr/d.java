package com.tencent.luggage.wxa.fr;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/crash/WxaCrashType;", "", "(Ljava/lang/String;I)V", "JVM_CRASH", "ANR", "NATIVE", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public enum d
{
  static
  {
    d locald1 = new d("JVM_CRASH", 0);
    a = locald1;
    d locald2 = new d("ANR", 1);
    b = locald2;
    d locald3 = new d("NATIVE", 2);
    c = locald3;
    d = new d[] { locald1, locald2, locald3 };
  }
  
  private d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fr.d
 * JD-Core Version:    0.7.0.1
 */