package com.tencent.biz.richframework.download;

public class RFWDefaultDownloadStrategy
  extends RFWDownloadStrategy
{
  public String getBusinessKey()
  {
    return "RichFrameWorkStrategy";
  }
  
  public String getDownloadRootPath()
  {
    return RFWDownloadConstants.RFW_FILE_PRIVATE_ROOT_PATH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDefaultDownloadStrategy
 * JD-Core Version:    0.7.0.1
 */