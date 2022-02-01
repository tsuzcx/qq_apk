package com.tencent.imsdk.message;

public class FileElement
  extends MessageBaseElement
{
  private int fileBusinessID;
  private int fileDownloadFlag;
  private String fileDownloadUrl;
  private String fileName;
  private String filePath;
  private int fileSize;
  private String fileUUID;
  
  public FileElement()
  {
    setElementType(6);
  }
  
  public int getFileBusinessID()
  {
    return this.fileBusinessID;
  }
  
  public int getFileDownloadFlag()
  {
    return this.fileDownloadFlag;
  }
  
  public String getFileDownloadUrl()
  {
    return this.fileDownloadUrl;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public int getFileSize()
  {
    return this.fileSize;
  }
  
  public String getFileUUID()
  {
    return this.fileUUID;
  }
  
  public void setFileName(String paramString)
  {
    this.fileName = paramString;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public boolean update(MessageBaseElement paramMessageBaseElement)
  {
    if (this.elementType == paramMessageBaseElement.elementType)
    {
      paramMessageBaseElement = (FileElement)paramMessageBaseElement;
      if (this.filePath.equals(paramMessageBaseElement.filePath))
      {
        this.fileUUID = paramMessageBaseElement.fileUUID;
        this.fileName = paramMessageBaseElement.fileName;
        this.fileSize = paramMessageBaseElement.fileSize;
        this.fileDownloadFlag = paramMessageBaseElement.fileDownloadFlag;
        this.fileDownloadUrl = paramMessageBaseElement.fileDownloadUrl;
        this.fileBusinessID = paramMessageBaseElement.fileBusinessID;
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.FileElement
 * JD-Core Version:    0.7.0.1
 */