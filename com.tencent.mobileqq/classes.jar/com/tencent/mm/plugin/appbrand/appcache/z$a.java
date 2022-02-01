package com.tencent.mm.plugin.appbrand.appcache;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgIntegrityChecker$ErrCode;", "", "(Ljava/lang/String;I)V", "code", "", "APP_READY", "APP_MANIFEST_NULL", "PKG_EXPIRED", "APP_NOT_INSTALLED", "APP_BROKEN", "ENV_ERR", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public enum z$a
{
  static
  {
    a locala1 = new a("APP_READY", 0);
    a = locala1;
    a locala2 = new a("APP_MANIFEST_NULL", 1);
    b = locala2;
    a locala3 = new a("PKG_EXPIRED", 2);
    c = locala3;
    a locala4 = new a("APP_NOT_INSTALLED", 3);
    d = locala4;
    a locala5 = new a("APP_BROKEN", 4);
    e = locala5;
    a locala6 = new a("ENV_ERR", 5);
    f = locala6;
    g = new a[] { locala1, locala2, locala3, locala4, locala5, locala6 };
  }
  
  private z$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.z.a
 * JD-Core Version:    0.7.0.1
 */