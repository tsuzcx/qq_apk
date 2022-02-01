package com.tencent.luggage.wxa.ea;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/KillType;", "", "(Ljava/lang/String;I)V", "KILL_TYPE_SILENT", "KILL_TYPE_NOTIFY_ACCOUNT_RELEASE", "KILL_TYPE_SILENT_IF_INACTIVE", "KILL_TYPE_SILENT_ACCOUNT_LOGOUT", "KILL_TYPE_API_FORCE_KILL_ALL", "KILL_PROCESS_DIRECTLY", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public enum a
{
  static
  {
    a locala1 = new a("KILL_TYPE_SILENT", 0);
    a = locala1;
    a locala2 = new a("KILL_TYPE_NOTIFY_ACCOUNT_RELEASE", 1);
    b = locala2;
    a locala3 = new a("KILL_TYPE_SILENT_IF_INACTIVE", 2);
    c = locala3;
    a locala4 = new a("KILL_TYPE_SILENT_ACCOUNT_LOGOUT", 3);
    d = locala4;
    a locala5 = new a("KILL_TYPE_API_FORCE_KILL_ALL", 4);
    e = locala5;
    a locala6 = new a("KILL_PROCESS_DIRECTLY", 5);
    f = locala6;
    g = new a[] { locala1, locala2, locala3, locala4, locala5, locala6 };
  }
  
  private a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ea.a
 * JD-Core Version:    0.7.0.1
 */