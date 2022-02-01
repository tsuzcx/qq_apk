package com.tencent.mm.plugin.appbrand.debugger;

import com.eclipsesource.mmv8.V8Inspector.JsInspectorChannelServer;

class i$1
  implements V8Inspector.JsInspectorChannelServer
{
  i$1(i parami) {}
  
  public int notify(long paramLong1, long paramLong2, String paramString)
  {
    return 0;
  }
  
  public int sendData(long paramLong, String paramString)
  {
    i.a(this.a, paramLong, paramString);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.i.1
 * JD-Core Version:    0.7.0.1
 */