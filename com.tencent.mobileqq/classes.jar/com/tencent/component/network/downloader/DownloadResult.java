package com.tencent.component.network.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.component.network.utils.AssertUtil;

public final class DownloadResult
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadResult> CREATOR = new DownloadResult.1();
  private DownloadResult.Content mContent = new DownloadResult.Content();
  private String mDescInfo;
  private String mDetailDownloadInfo;
  private String mPath;
  private DownloadResult.Process mProcess = new DownloadResult.Process();
  private DownloadReport mReport;
  private DownloadResult.Status mStatus = new DownloadResult.Status();
  private String mUrl;
  
  public DownloadResult(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.mUrl = paramParcel.readString();
    this.mPath = paramParcel.readString();
    this.mStatus = ((DownloadResult.Status)paramParcel.readParcelable(DownloadResult.Status.class.getClassLoader()));
    this.mProcess = ((DownloadResult.Process)paramParcel.readParcelable(DownloadResult.Process.class.getClassLoader()));
    this.mContent = ((DownloadResult.Content)paramParcel.readParcelable(DownloadResult.Content.class.getClassLoader()));
    this.mDescInfo = paramParcel.readString();
    this.mDetailDownloadInfo = paramParcel.readString();
  }
  
  public DownloadResult(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      this.mUrl = paramString;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DownloadResult.Content getContent()
  {
    return this.mContent;
  }
  
  public String getDescInfo()
  {
    return this.mDescInfo;
  }
  
  public String getDetailDownloadInfo()
  {
    return this.mDetailDownloadInfo;
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public DownloadResult.Process getProcess()
  {
    return this.mProcess;
  }
  
  public DownloadReport getReport()
  {
    return this.mReport;
  }
  
  public DownloadResult.Status getStatus()
  {
    return this.mStatus;
  }
  
  public final String getUrl()
  {
    return this.mUrl;
  }
  
  public void reset()
  {
    this.mStatus.reset();
    this.mProcess.reset();
    this.mContent.reset();
  }
  
  public final void setDescInfo(String paramString)
  {
    this.mDescInfo = paramString;
  }
  
  public final void setDetailDownloadInfo(String paramString)
  {
    this.mDetailDownloadInfo = paramString;
  }
  
  public final void setPath(String paramString)
  {
    this.mPath = paramString;
  }
  
  public final void setReport(DownloadReport paramDownloadReport)
  {
    this.mReport = paramDownloadReport;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.mUrl);
    paramParcel.writeString(this.mPath);
    paramParcel.writeParcelable(this.mStatus, 0);
    paramParcel.writeParcelable(this.mProcess, 0);
    paramParcel.writeParcelable(this.mContent, 0);
    paramParcel.writeString(this.mDescInfo);
    paramParcel.writeString(this.mDetailDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadResult
 * JD-Core Version:    0.7.0.1
 */