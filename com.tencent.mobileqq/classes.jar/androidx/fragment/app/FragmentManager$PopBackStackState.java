package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

class FragmentManager$PopBackStackState
  implements FragmentManager.OpGenerator
{
  final int mFlags;
  final int mId;
  final String mName;
  
  FragmentManager$PopBackStackState(FragmentManager paramFragmentManager, @Nullable String paramString, int paramInt1, int paramInt2)
  {
    this.mName = paramString;
    this.mId = paramInt1;
    this.mFlags = paramInt2;
  }
  
  public boolean generateOps(@NonNull ArrayList<BackStackRecord> paramArrayList, @NonNull ArrayList<Boolean> paramArrayList1)
  {
    if ((this.this$0.mPrimaryNav != null) && (this.mId < 0) && (this.mName == null) && (this.this$0.mPrimaryNav.getChildFragmentManager().popBackStackImmediate())) {
      return false;
    }
    return this.this$0.popBackStackState(paramArrayList, paramArrayList1, this.mName, this.mId, this.mFlags);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentManager.PopBackStackState
 * JD-Core Version:    0.7.0.1
 */