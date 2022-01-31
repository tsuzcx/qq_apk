package com.tencent.ark.open;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

class ArkAppCGIMgr$QueryTask
{
  public final ArrayList<ArkAppCGIMgr.ArkAppCGICallback> callback = new ArrayList();
  public String cookie;
  public long lastModifiedTime = -1L;
  ArkAppCGIMgr.ITaskHttpResult onParseReply;
  public byte[] postData;
  public String referer;
  public File rspFile;
  public ByteArrayOutputStream rspStream;
  public String url;
  public final ArrayList<Object> userdata = new ArrayList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCGIMgr.QueryTask
 * JD-Core Version:    0.7.0.1
 */