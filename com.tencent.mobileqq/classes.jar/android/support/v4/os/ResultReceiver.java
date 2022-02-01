package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ResultReceiver
  implements Parcelable
{
  public static final Parcelable.Creator<ResultReceiver> CREATOR = new ResultReceiver.1();
  final Handler mHandler;
  final boolean mLocal;
  IResultReceiver mReceiver;
  
  public ResultReceiver(Handler paramHandler)
  {
    this.mLocal = true;
    this.mHandler = paramHandler;
  }
  
  ResultReceiver(Parcel paramParcel)
  {
    this.mLocal = false;
    this.mHandler = null;
    this.mReceiver = IResultReceiver.Stub.asInterface(paramParcel.readStrongBinder());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle) {}
  
  public void send(int paramInt, Bundle paramBundle)
  {
    if (this.mLocal)
    {
      localObject = this.mHandler;
      if (localObject != null)
      {
        ((Handler)localObject).post(new ResultReceiver.MyRunnable(this, paramInt, paramBundle));
        return;
      }
      onReceiveResult(paramInt, paramBundle);
      return;
    }
    Object localObject = this.mReceiver;
    if (localObject != null) {}
    try
    {
      ((IResultReceiver)localObject).send(paramInt, paramBundle);
      return;
    }
    catch (RemoteException paramBundle) {}
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      if (this.mReceiver == null) {
        this.mReceiver = new ResultReceiver.MyResultReceiver(this);
      }
      paramParcel.writeStrongBinder(this.mReceiver.asBinder());
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.os.ResultReceiver
 * JD-Core Version:    0.7.0.1
 */