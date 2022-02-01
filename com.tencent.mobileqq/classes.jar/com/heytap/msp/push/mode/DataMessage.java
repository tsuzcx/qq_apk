package com.heytap.msp.push.mode;

public class DataMessage
  extends BaseMode
{
  private String mAppPackage;
  private String mContent;
  private String mDescription;
  private String mMessageID;
  private int mNotifyID;
  private String mTaskID = "";
  private String mTitle;
  
  public String getAppPackage()
  {
    return this.mAppPackage;
  }
  
  public String getContent()
  {
    return this.mContent;
  }
  
  public String getDescription()
  {
    return this.mDescription;
  }
  
  public String getMessageID()
  {
    return this.mMessageID;
  }
  
  public int getNotifyID()
  {
    return this.mNotifyID;
  }
  
  public String getTaskID()
  {
    return this.mTaskID;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public int getType()
  {
    return 4103;
  }
  
  public void setAppPackage(String paramString)
  {
    this.mAppPackage = paramString;
  }
  
  public void setContent(String paramString)
  {
    this.mContent = paramString;
  }
  
  public void setDescription(String paramString)
  {
    this.mDescription = paramString;
  }
  
  public void setMessageID(String paramString)
  {
    this.mMessageID = paramString;
  }
  
  public void setNotifyID(int paramInt)
  {
    this.mNotifyID = paramInt;
  }
  
  public void setTaskID(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    this.mTaskID = localStringBuilder.toString();
  }
  
  public void setTaskID(String paramString)
  {
    this.mTaskID = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.mTitle = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataMessage{mMessageID='");
    localStringBuilder.append(this.mMessageID);
    localStringBuilder.append('\'');
    localStringBuilder.append("mAppPackage='");
    localStringBuilder.append(this.mAppPackage);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mTaskID='");
    localStringBuilder.append(this.mTaskID);
    localStringBuilder.append('\'');
    localStringBuilder.append("mTitle='");
    localStringBuilder.append(this.mTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append("mNotifyID='");
    localStringBuilder.append(this.mNotifyID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mContent='");
    localStringBuilder.append(this.mContent);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mDescription='");
    localStringBuilder.append(this.mDescription);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.msp.push.mode.DataMessage
 * JD-Core Version:    0.7.0.1
 */