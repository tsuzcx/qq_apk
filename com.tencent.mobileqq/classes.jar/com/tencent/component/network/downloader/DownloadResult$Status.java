package com.tencent.component.network.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.component.network.module.report.ImageDownloadReporter;

public final class DownloadResult$Status
  implements Parcelable
{
  public static final Parcelable.Creator<Status> CREATOR = new DownloadResult.Status.1();
  public static final int REASON_FAIL_CONTENT = 5;
  public static final int REASON_FAIL_EXCEPTION = 4;
  public static final int REASON_FAIL_META = 7;
  public static final int REASON_FAIL_NETWORK = 3;
  public static final int REASON_FAIL_NETWORK_UNAVAILABLE = 6;
  public static final int REASON_FAIL_NONE = 0;
  public static final int REASON_FAIL_STORAGE = 2;
  public static final int REASON_FAIL_UNKNOWN = 1;
  public static final int STATE_CANCELED = 4;
  public static final int STATE_FAILED = 2;
  public static final int STATE_RETRYING = 3;
  public static final int STATE_SUCCEED = 1;
  public String detailDownloadInfo = "";
  public int exception2Code = 0;
  public Throwable failException = null;
  public int failReason = 1;
  public int httpStatus;
  public int state = 2;
  
  public DownloadResult$Status() {}
  
  public DownloadResult$Status(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.state = paramParcel.readInt();
    this.failReason = paramParcel.readInt();
    this.httpStatus = paramParcel.readInt();
    this.exception2Code = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getErrorMessage()
  {
    int i = this.failReason;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 5)
          {
            if (i != 6) {
              return "";
            }
            return "network unavailable";
          }
          return "content type error";
        }
        return "download exception";
      }
      return "response error";
    }
    return "storage limit";
  }
  
  public Throwable getFailException()
  {
    if (isFailed()) {
      return this.failException;
    }
    return null;
  }
  
  public int getFailReason()
  {
    if (isFailed()) {
      return this.failReason;
    }
    return 0;
  }
  
  public boolean isFailed()
  {
    return this.state == 2;
  }
  
  public final boolean isRetrying()
  {
    return this.state == 3;
  }
  
  public boolean isSucceed()
  {
    return this.state == 1;
  }
  
  public final void reset()
  {
    this.state = 2;
    this.failReason = 1;
    this.failException = null;
    this.exception2Code = 0;
    this.httpStatus = 0;
  }
  
  public final void setFailed(int paramInt)
  {
    this.state = 2;
    this.failReason = paramInt;
  }
  
  public final void setFailed(Throwable paramThrowable)
  {
    this.state = 2;
    this.failReason = 4;
    this.failException = paramThrowable;
    this.exception2Code = ImageDownloadReporter.getRetCodeFrom(this.failException, 0);
  }
  
  final void setRetrying()
  {
    this.state = 3;
  }
  
  public final void setSucceed()
  {
    this.state = 1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeInt(this.state);
    paramParcel.writeInt(this.failReason);
    paramParcel.writeInt(this.httpStatus);
    paramParcel.writeInt(this.exception2Code);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadResult.Status
 * JD-Core Version:    0.7.0.1
 */