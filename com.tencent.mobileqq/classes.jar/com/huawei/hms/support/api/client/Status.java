package com.huawei.hms.support.api.client;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Arrays;

public final class Status
  extends Result
  implements Parcelable
{
  public static final Parcelable.Creator<Status> CREATOR = new Status.a();
  public static final Status CoreException;
  public static final Status FAILURE;
  public static final Status MessageNotFound;
  @Deprecated
  public static final Status RESULT_CANCELED;
  @Deprecated
  public static final Status RESULT_DEAD_CLIENT;
  @Deprecated
  public static final Status RESULT_INTERNAL_ERROR;
  @Deprecated
  public static final Status RESULT_INTERRUPTED;
  @Deprecated
  public static final Status RESULT_TIMEOUT;
  public static final Status SUCCESS = new Status(0);
  @Packed
  private Intent intent;
  @Packed
  private PendingIntent pendingIntent;
  @Packed
  private int statusCode;
  @Packed
  private String statusMessage;
  
  static
  {
    FAILURE = new Status(1);
    RESULT_CANCELED = new Status(16);
    RESULT_DEAD_CLIENT = new Status(18);
    RESULT_INTERNAL_ERROR = new Status(8);
    RESULT_INTERRUPTED = new Status(14);
    RESULT_TIMEOUT = new Status(15);
    MessageNotFound = new Status(404);
    CoreException = new Status(500);
  }
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  public Status(int paramInt, String paramString)
  {
    this.statusCode = paramInt;
    this.statusMessage = paramString;
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this.statusCode = paramInt;
    this.statusMessage = paramString;
    this.pendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString, Intent paramIntent)
  {
    this.statusCode = paramInt;
    this.statusMessage = paramString;
    this.intent = paramIntent;
  }
  
  private static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof Status))
    {
      paramObject = (Status)paramObject;
      return (this.statusCode == paramObject.statusCode) && (equal(this.statusMessage, paramObject.statusMessage)) && (equal(this.pendingIntent, paramObject.pendingIntent)) && (equal(this.intent, paramObject.intent));
    }
    return false;
  }
  
  public String getErrorString()
  {
    return getStatusMessage();
  }
  
  public PendingIntent getResolution()
  {
    return this.pendingIntent;
  }
  
  public Intent getResolutionIntent()
  {
    return this.intent;
  }
  
  public Status getStatus()
  {
    return this;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public String getStatusMessage()
  {
    return this.statusMessage;
  }
  
  public boolean hasResolution()
  {
    return (this.pendingIntent != null) || (this.intent != null);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.statusCode), this.statusMessage, this.pendingIntent, this.intent });
  }
  
  public boolean isCanceled()
  {
    return false;
  }
  
  public boolean isInterrupted()
  {
    return false;
  }
  
  public boolean isSuccess()
  {
    return this.statusCode <= 0;
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.intent = paramIntent;
  }
  
  public void setPendingIntent(PendingIntent paramPendingIntent)
  {
    this.pendingIntent = paramPendingIntent;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
  {
    if (hasResolution())
    {
      PendingIntent localPendingIntent = this.pendingIntent;
      if (localPendingIntent != null)
      {
        paramActivity.startIntentSenderForResult(localPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
        return;
      }
      paramActivity.startActivityForResult(this.intent, paramInt);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{statusCode: ");
    localStringBuilder.append(this.statusCode);
    localStringBuilder.append(", statusMessage: ");
    localStringBuilder.append(this.statusMessage);
    localStringBuilder.append(", pendingIntent: ");
    localStringBuilder.append(this.pendingIntent);
    localStringBuilder.append(", intent: ");
    localStringBuilder.append(this.intent);
    localStringBuilder.append(",}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.statusCode);
    paramParcel.writeString(this.statusMessage);
    Object localObject = this.pendingIntent;
    if (localObject != null) {
      ((PendingIntent)localObject).writeToParcel(paramParcel, paramInt);
    }
    PendingIntent.writePendingIntentOrNullToParcel(this.pendingIntent, paramParcel);
    localObject = this.intent;
    if (localObject != null) {
      ((Intent)localObject).writeToParcel(paramParcel, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.client.Status
 * JD-Core Version:    0.7.0.1
 */