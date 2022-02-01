package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle.State;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new BackStackState.1();
  private static final String TAG = "FragmentManager";
  final int mBreadCrumbShortTitleRes;
  final CharSequence mBreadCrumbShortTitleText;
  final int mBreadCrumbTitleRes;
  final CharSequence mBreadCrumbTitleText;
  final int[] mCurrentMaxLifecycleStates;
  final ArrayList<String> mFragmentWhos;
  final int mIndex;
  final String mName;
  final int[] mOldMaxLifecycleStates;
  final int[] mOps;
  final boolean mReorderingAllowed;
  final ArrayList<String> mSharedElementSourceNames;
  final ArrayList<String> mSharedElementTargetNames;
  final int mTransition;
  
  public BackStackState(Parcel paramParcel)
  {
    this.mOps = paramParcel.createIntArray();
    this.mFragmentWhos = paramParcel.createStringArrayList();
    this.mOldMaxLifecycleStates = paramParcel.createIntArray();
    this.mCurrentMaxLifecycleStates = paramParcel.createIntArray();
    this.mTransition = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.mBreadCrumbTitleRes = paramParcel.readInt();
    this.mBreadCrumbTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mBreadCrumbShortTitleRes = paramParcel.readInt();
    this.mBreadCrumbShortTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mSharedElementSourceNames = paramParcel.createStringArrayList();
    this.mSharedElementTargetNames = paramParcel.createStringArrayList();
    boolean bool;
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.mReorderingAllowed = bool;
  }
  
  public BackStackState(BackStackRecord paramBackStackRecord)
  {
    int k = paramBackStackRecord.mOps.size();
    this.mOps = new int[k * 5];
    if (paramBackStackRecord.mAddToBackStack)
    {
      this.mFragmentWhos = new ArrayList(k);
      this.mOldMaxLifecycleStates = new int[k];
      this.mCurrentMaxLifecycleStates = new int[k];
      int i = 0;
      int j = 0;
      while (i < k)
      {
        FragmentTransaction.Op localOp = (FragmentTransaction.Op)paramBackStackRecord.mOps.get(i);
        Object localObject = this.mOps;
        int m = j + 1;
        localObject[j] = localOp.mCmd;
        ArrayList localArrayList = this.mFragmentWhos;
        if (localOp.mFragment != null) {
          localObject = localOp.mFragment.mWho;
        } else {
          localObject = null;
        }
        localArrayList.add(localObject);
        localObject = this.mOps;
        j = m + 1;
        localObject[m] = localOp.mEnterAnim;
        localObject = this.mOps;
        m = j + 1;
        localObject[j] = localOp.mExitAnim;
        localObject = this.mOps;
        j = m + 1;
        localObject[m] = localOp.mPopEnterAnim;
        this.mOps[j] = localOp.mPopExitAnim;
        this.mOldMaxLifecycleStates[i] = localOp.mOldMaxState.ordinal();
        this.mCurrentMaxLifecycleStates[i] = localOp.mCurrentMaxState.ordinal();
        i += 1;
        j += 1;
      }
      this.mTransition = paramBackStackRecord.mTransition;
      this.mName = paramBackStackRecord.mName;
      this.mIndex = paramBackStackRecord.mIndex;
      this.mBreadCrumbTitleRes = paramBackStackRecord.mBreadCrumbTitleRes;
      this.mBreadCrumbTitleText = paramBackStackRecord.mBreadCrumbTitleText;
      this.mBreadCrumbShortTitleRes = paramBackStackRecord.mBreadCrumbShortTitleRes;
      this.mBreadCrumbShortTitleText = paramBackStackRecord.mBreadCrumbShortTitleText;
      this.mSharedElementSourceNames = paramBackStackRecord.mSharedElementSourceNames;
      this.mSharedElementTargetNames = paramBackStackRecord.mSharedElementTargetNames;
      this.mReorderingAllowed = paramBackStackRecord.mReorderingAllowed;
      return;
    }
    paramBackStackRecord = new IllegalStateException("Not on back stack");
    for (;;)
    {
      throw paramBackStackRecord;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public BackStackRecord instantiate(FragmentManager paramFragmentManager)
  {
    BackStackRecord localBackStackRecord = new BackStackRecord(paramFragmentManager);
    int j = 0;
    int i = 0;
    while (j < this.mOps.length)
    {
      FragmentTransaction.Op localOp = new FragmentTransaction.Op();
      Object localObject = this.mOps;
      int k = j + 1;
      localOp.mCmd = localObject[j];
      if (FragmentManager.isLoggingEnabled(2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Instantiate ");
        ((StringBuilder)localObject).append(localBackStackRecord);
        ((StringBuilder)localObject).append(" op #");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" base fragment #");
        ((StringBuilder)localObject).append(this.mOps[k]);
        Log.v("FragmentManager", ((StringBuilder)localObject).toString());
      }
      localObject = (String)this.mFragmentWhos.get(i);
      if (localObject != null) {
        localOp.mFragment = paramFragmentManager.findActiveFragment((String)localObject);
      } else {
        localOp.mFragment = null;
      }
      localOp.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[i]];
      localOp.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[i]];
      localObject = this.mOps;
      j = k + 1;
      localOp.mEnterAnim = localObject[k];
      k = j + 1;
      localOp.mExitAnim = localObject[j];
      j = k + 1;
      localOp.mPopEnterAnim = localObject[k];
      localOp.mPopExitAnim = localObject[j];
      localBackStackRecord.mEnterAnim = localOp.mEnterAnim;
      localBackStackRecord.mExitAnim = localOp.mExitAnim;
      localBackStackRecord.mPopEnterAnim = localOp.mPopEnterAnim;
      localBackStackRecord.mPopExitAnim = localOp.mPopExitAnim;
      localBackStackRecord.addOp(localOp);
      i += 1;
      j += 1;
    }
    localBackStackRecord.mTransition = this.mTransition;
    localBackStackRecord.mName = this.mName;
    localBackStackRecord.mIndex = this.mIndex;
    localBackStackRecord.mAddToBackStack = true;
    localBackStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
    localBackStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
    localBackStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
    localBackStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
    localBackStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
    localBackStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
    localBackStackRecord.mReorderingAllowed = this.mReorderingAllowed;
    localBackStackRecord.bumpBackStackNesting(1);
    return localBackStackRecord;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */