package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;

final class QBackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<QBackStackState> CREATOR = new QBackStackState.1();
  final int mBreadCrumbShortTitleRes;
  final CharSequence mBreadCrumbShortTitleText;
  final int mBreadCrumbTitleRes;
  final CharSequence mBreadCrumbTitleText;
  final int mIndex;
  final String mName;
  final int[] mOps;
  final int mTransition;
  final int mTransitionStyle;
  
  public QBackStackState(Parcel paramParcel)
  {
    this.mOps = paramParcel.createIntArray();
    this.mTransition = paramParcel.readInt();
    this.mTransitionStyle = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.mBreadCrumbTitleRes = paramParcel.readInt();
    this.mBreadCrumbTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mBreadCrumbShortTitleRes = paramParcel.readInt();
    this.mBreadCrumbShortTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
  }
  
  public QBackStackState(QFragmentManagerImpl paramQFragmentManagerImpl, QBackStackRecord paramQBackStackRecord)
  {
    paramQFragmentManagerImpl = paramQBackStackRecord.mHead;
    int j;
    for (int i = 0; paramQFragmentManagerImpl != null; i = j)
    {
      j = i;
      if (paramQFragmentManagerImpl.removed != null) {
        j = i + paramQFragmentManagerImpl.removed.size();
      }
      paramQFragmentManagerImpl = paramQFragmentManagerImpl.next;
    }
    this.mOps = new int[i + paramQBackStackRecord.mNumOp * 7];
    if (!paramQBackStackRecord.mAddToBackStack) {
      throw new IllegalStateException("Not on back stack");
    }
    paramQFragmentManagerImpl = paramQBackStackRecord.mHead;
    i = 0;
    if (paramQFragmentManagerImpl != null)
    {
      int[] arrayOfInt = this.mOps;
      j = i + 1;
      arrayOfInt[i] = paramQFragmentManagerImpl.cmd;
      arrayOfInt = this.mOps;
      int k = j + 1;
      if (paramQFragmentManagerImpl.fragment != null) {}
      for (i = paramQFragmentManagerImpl.fragment.mIndex;; i = -1)
      {
        arrayOfInt[j] = i;
        arrayOfInt = this.mOps;
        i = k + 1;
        arrayOfInt[k] = paramQFragmentManagerImpl.enterAnim;
        arrayOfInt = this.mOps;
        j = i + 1;
        arrayOfInt[i] = paramQFragmentManagerImpl.exitAnim;
        arrayOfInt = this.mOps;
        i = j + 1;
        arrayOfInt[j] = paramQFragmentManagerImpl.popEnterAnim;
        arrayOfInt = this.mOps;
        j = i + 1;
        arrayOfInt[i] = paramQFragmentManagerImpl.popExitAnim;
        if (paramQFragmentManagerImpl.removed == null) {
          break label311;
        }
        k = paramQFragmentManagerImpl.removed.size();
        arrayOfInt = this.mOps;
        i = j + 1;
        arrayOfInt[j] = k;
        j = 0;
        while (j < k)
        {
          this.mOps[i] = ((QFragment)paramQFragmentManagerImpl.removed.get(j)).mIndex;
          j += 1;
          i += 1;
        }
      }
      for (;;)
      {
        paramQFragmentManagerImpl = paramQFragmentManagerImpl.next;
        break;
        label311:
        arrayOfInt = this.mOps;
        i = j + 1;
        arrayOfInt[j] = 0;
      }
    }
    this.mTransition = paramQBackStackRecord.mTransition;
    this.mTransitionStyle = paramQBackStackRecord.mTransitionStyle;
    this.mName = paramQBackStackRecord.mName;
    this.mIndex = paramQBackStackRecord.mIndex;
    this.mBreadCrumbTitleRes = paramQBackStackRecord.mBreadCrumbTitleRes;
    this.mBreadCrumbTitleText = paramQBackStackRecord.mBreadCrumbTitleText;
    this.mBreadCrumbShortTitleRes = paramQBackStackRecord.mBreadCrumbShortTitleRes;
    this.mBreadCrumbShortTitleText = paramQBackStackRecord.mBreadCrumbShortTitleText;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public QBackStackRecord instantiate(QFragmentManagerImpl paramQFragmentManagerImpl)
  {
    QBackStackRecord localQBackStackRecord = new QBackStackRecord(paramQFragmentManagerImpl);
    int k = 0;
    int i = 0;
    while (i < this.mOps.length)
    {
      QBackStackRecord.Op localOp = new QBackStackRecord.Op();
      Object localObject = this.mOps;
      int j = i + 1;
      localOp.cmd = localObject[i];
      localObject = this.mOps;
      i = j + 1;
      j = localObject[j];
      if (j >= 0) {}
      for (localOp.fragment = ((QFragment)paramQFragmentManagerImpl.mActive.get(j));; localOp.fragment = null)
      {
        localObject = this.mOps;
        j = i + 1;
        localOp.enterAnim = localObject[i];
        localObject = this.mOps;
        i = j + 1;
        localOp.exitAnim = localObject[j];
        localObject = this.mOps;
        j = i + 1;
        localOp.popEnterAnim = localObject[i];
        localObject = this.mOps;
        i = j + 1;
        localOp.popExitAnim = localObject[j];
        localObject = this.mOps;
        j = i + 1;
        int n = localObject[i];
        i = j;
        if (n <= 0) {
          break;
        }
        localOp.removed = new ArrayList(n);
        int m = 0;
        for (;;)
        {
          i = j;
          if (m >= n) {
            break;
          }
          localObject = (QFragment)paramQFragmentManagerImpl.mActive.get(this.mOps[j]);
          localOp.removed.add(localObject);
          m += 1;
          j += 1;
        }
      }
      localQBackStackRecord.addOp(localOp);
      k += 1;
    }
    localQBackStackRecord.mTransition = this.mTransition;
    localQBackStackRecord.mTransitionStyle = this.mTransitionStyle;
    localQBackStackRecord.mName = this.mName;
    localQBackStackRecord.mIndex = this.mIndex;
    localQBackStackRecord.mAddToBackStack = true;
    localQBackStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
    localQBackStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
    localQBackStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
    localQBackStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
    localQBackStackRecord.bumpBackStackNesting(1);
    return localQBackStackRecord;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.mOps);
    paramParcel.writeInt(this.mTransition);
    paramParcel.writeInt(this.mTransitionStyle);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.mBreadCrumbTitleRes);
    TextUtils.writeToParcel(this.mBreadCrumbTitleText, paramParcel, 0);
    paramParcel.writeInt(this.mBreadCrumbShortTitleRes);
    TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, paramParcel, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v4.app.QBackStackState
 * JD-Core Version:    0.7.0.1
 */