package com.huawei.hms.adapter;

import android.app.PendingIntent;
import android.content.Intent;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class CoreBaseResponse
  implements IMessageEntity
{
  @Packed
  public Intent intent;
  @Packed
  private String jsonBody;
  @Packed
  private String jsonHeader;
  @Packed
  public PendingIntent pendingIntent;
  
  public Intent getIntent()
  {
    return this.intent;
  }
  
  public String getJsonBody()
  {
    return this.jsonBody;
  }
  
  public String getJsonHeader()
  {
    return this.jsonHeader;
  }
  
  public PendingIntent getPendingIntent()
  {
    return this.pendingIntent;
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.intent = paramIntent;
  }
  
  public void setJsonBody(String paramString)
  {
    this.jsonBody = paramString;
  }
  
  public void setJsonHeader(String paramString)
  {
    this.jsonHeader = paramString;
  }
  
  public void setPendingIntent(PendingIntent paramPendingIntent)
  {
    this.pendingIntent = paramPendingIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.adapter.CoreBaseResponse
 * JD-Core Version:    0.7.0.1
 */