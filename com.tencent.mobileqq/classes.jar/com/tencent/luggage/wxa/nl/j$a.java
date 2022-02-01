package com.tencent.luggage.wxa.nl;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "OK", "FAILED", "LOCAL_FILE_NOT_FOUND", "PKG_INTEGRITY_FAILED", "PKG_INVALID", "SEVER_FILE_NOT_FOUND", "DISK_FULL", "PKG_RECORD_NULL", "PKG_RECORD_INVALID", "ENV_ERR", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public enum j$a
{
  private final int l;
  
  static
  {
    a locala1 = new a("OK", 0, 0);
    a = locala1;
    a locala2 = new a("FAILED", 1, 101);
    b = locala2;
    a locala3 = new a("LOCAL_FILE_NOT_FOUND", 2, 102);
    c = locala3;
    a locala4 = new a("PKG_INTEGRITY_FAILED", 3, 104);
    d = locala4;
    a locala5 = new a("PKG_INVALID", 4, 105);
    e = locala5;
    a locala6 = new a("SEVER_FILE_NOT_FOUND", 5, 106);
    f = locala6;
    a locala7 = new a("DISK_FULL", 6, 110);
    g = locala7;
    a locala8 = new a("PKG_RECORD_NULL", 7, 111);
    h = locala8;
    a locala9 = new a("PKG_RECORD_INVALID", 8, 112);
    i = locala9;
    a locala10 = new a("ENV_ERR", 9, 200);
    j = locala10;
    k = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10 };
  }
  
  private j$a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public final int a()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.j.a
 * JD-Core Version:    0.7.0.1
 */