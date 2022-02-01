package com.tencent.biz.pubaccount.readinjoy.share.watchword;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getNext", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJWatchWordShareManager$getAppearCount$1
  extends Lambda
  implements Function0<Unit>
{
  RIJWatchWordShareManager$getAppearCount$1(int[] paramArrayOfInt, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.$next[0] = -1;
    int j = 0;
    int i = -1;
    while (j < this.$pattern.length()) {
      if ((i == -1) || (this.$pattern.charAt(j) == this.$pattern.charAt(i)))
      {
        int[] arrayOfInt = this.$next;
        j += 1;
        i += 1;
        arrayOfInt[j] = i;
      }
      else
      {
        i = this.$next[i];
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager.getAppearCount.1
 * JD-Core Version:    0.7.0.1
 */