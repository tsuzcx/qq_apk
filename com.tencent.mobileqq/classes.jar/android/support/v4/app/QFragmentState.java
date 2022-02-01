package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class QFragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<QFragmentState> CREATOR = new QFragmentState.1();
  final Bundle mArguments;
  final String mClassName;
  final int mContainerId;
  final boolean mDetached;
  final int mFragmentId;
  final boolean mFromLayout;
  final int mIndex;
  QFragment mInstance;
  final boolean mRetainInstance;
  Bundle mSavedFragmentState;
  final String mTag;
  
  public QFragmentState(Parcel paramParcel)
  {
    this.mClassName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      this.mFromLayout = bool1;
      this.mFragmentId = paramParcel.readInt();
      this.mContainerId = paramParcel.readInt();
      this.mTag = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label110;
      }
      bool1 = true;
      label69:
      this.mRetainInstance = bool1;
      if (paramParcel.readInt() == 0) {
        break label115;
      }
    }
    label110:
    label115:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mDetached = bool1;
      this.mArguments = paramParcel.readBundle();
      this.mSavedFragmentState = paramParcel.readBundle();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label69;
    }
  }
  
  public QFragmentState(QFragment paramQFragment)
  {
    this.mClassName = paramQFragment.getClass().getName();
    this.mIndex = paramQFragment.mIndex;
    this.mFromLayout = paramQFragment.mFromLayout;
    this.mFragmentId = paramQFragment.mFragmentId;
    this.mContainerId = paramQFragment.mContainerId;
    this.mTag = paramQFragment.mTag;
    this.mRetainInstance = paramQFragment.mRetainInstance;
    this.mDetached = paramQFragment.mDetached;
    this.mArguments = paramQFragment.mArguments;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public QFragment instantiate(QFragmentActivity paramQFragmentActivity, QFragment paramQFragment)
  {
    if (this.mInstance != null) {
      return this.mInstance;
    }
    if (this.mArguments != null) {
      this.mArguments.setClassLoader(paramQFragmentActivity.getClassLoader());
    }
    this.mInstance = QFragment.instantiate(paramQFragmentActivity, this.mClassName, this.mArguments);
    if (this.mSavedFragmentState != null)
    {
      this.mSavedFragmentState.setClassLoader(paramQFragmentActivity.getClassLoader());
      this.mInstance.mSavedFragmentState = this.mSavedFragmentState;
    }
    this.mInstance.setIndex(this.mIndex, paramQFragment);
    this.mInstance.mFromLayout = this.mFromLayout;
    this.mInstance.mRestored = true;
    this.mInstance.mFragmentId = this.mFragmentId;
    this.mInstance.mContainerId = this.mContainerId;
    this.mInstance.mTag = this.mTag;
    this.mInstance.mRetainInstance = this.mRetainInstance;
    this.mInstance.mDetached = this.mDetached;
    this.mInstance.mFragmentManager = paramQFragmentActivity.mFragments;
    return this.mInstance;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.mClassName);
    paramParcel.writeInt(this.mIndex);
    if (this.mFromLayout)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.mFragmentId);
      paramParcel.writeInt(this.mContainerId);
      paramParcel.writeString(this.mTag);
      if (!this.mRetainInstance) {
        break label106;
      }
      paramInt = 1;
      label65:
      paramParcel.writeInt(paramInt);
      if (!this.mDetached) {
        break label111;
      }
    }
    label106:
    label111:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.mArguments);
      paramParcel.writeBundle(this.mSavedFragmentState);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label65;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v4.app.QFragmentState
 * JD-Core Version:    0.7.0.1
 */