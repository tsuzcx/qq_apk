package com.tencent.imsdk.message;

public class SoundElement
  extends MessageBaseElement
{
  private int soundBusinessID;
  private int soundDownloadFlag;
  private String soundDownloadUrl;
  private int soundDuration;
  private String soundFilePath;
  private int soundFileSize;
  private String soundUUID;
  
  public SoundElement()
  {
    setElementType(4);
  }
  
  public int getSoundBusinessID()
  {
    return this.soundBusinessID;
  }
  
  public int getSoundDownloadFlag()
  {
    return this.soundDownloadFlag;
  }
  
  public String getSoundDownloadUrl()
  {
    return this.soundDownloadUrl;
  }
  
  public int getSoundDuration()
  {
    return this.soundDuration;
  }
  
  public String getSoundFilePath()
  {
    return this.soundFilePath;
  }
  
  public int getSoundFileSize()
  {
    return this.soundFileSize;
  }
  
  public String getSoundUUID()
  {
    return this.soundUUID;
  }
  
  public void setSoundDuration(int paramInt)
  {
    this.soundDuration = paramInt;
  }
  
  public void setSoundFilePath(String paramString)
  {
    this.soundFilePath = paramString;
  }
  
  public void setSoundFileSize(int paramInt)
  {
    this.soundFileSize = paramInt;
  }
  
  public boolean update(MessageBaseElement paramMessageBaseElement)
  {
    if (this.elementType == paramMessageBaseElement.elementType)
    {
      paramMessageBaseElement = (SoundElement)paramMessageBaseElement;
      if (this.soundFilePath.equals(paramMessageBaseElement.soundFilePath))
      {
        this.soundUUID = paramMessageBaseElement.soundUUID;
        this.soundFileSize = paramMessageBaseElement.soundFileSize;
        this.soundDuration = paramMessageBaseElement.soundDuration;
        this.soundDownloadFlag = paramMessageBaseElement.soundDownloadFlag;
        this.soundDownloadUrl = paramMessageBaseElement.soundDownloadUrl;
        this.soundBusinessID = paramMessageBaseElement.soundBusinessID;
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.SoundElement
 * JD-Core Version:    0.7.0.1
 */