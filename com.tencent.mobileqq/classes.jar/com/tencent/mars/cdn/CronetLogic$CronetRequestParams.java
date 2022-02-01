package com.tencent.mars.cdn;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CronetLogic$CronetRequestParams
{
  public byte[] bodyData = null;
  public boolean cachePerformance = false;
  public CronetLogic.DefaultHttpTaskParams defaultHttpTaskParams = null;
  public boolean followRedirect = false;
  public String header = "";
  public CronetLogic.HeaderMap[] headers = null;
  public CronetLogic.HostIPHint hostIPHint = null;
  public int maxRedirectCount = 2;
  public String method = "";
  public boolean needGenerateId = true;
  public boolean needWirteCache = false;
  public String savePath = "";
  public String taskId = "";
  public int taskType = 0;
  public String url = "";
  public boolean useHttp2 = false;
  public boolean useMemoryCache = false;
  public boolean useNewdns = false;
  public boolean useQuic = false;
  
  public void makeRequestHeader(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.isEmpty())) {
      return;
    }
    int k = paramMap.size();
    int i = 0;
    this.headers = new CronetLogic.HeaderMap[k];
    paramMap = paramMap.entrySet().iterator();
    int j;
    do
    {
      if (!paramMap.hasNext()) {
        break;
      }
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      CronetLogic.HeaderMap localHeaderMap = new CronetLogic.HeaderMap();
      localHeaderMap.key = ((String)localEntry.getKey());
      localHeaderMap.value = ((String)localEntry.getValue());
      this.headers[i] = localHeaderMap;
      j = i + 1;
      i = j;
    } while (j <= k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.cdn.CronetLogic.CronetRequestParams
 * JD-Core Version:    0.7.0.1
 */