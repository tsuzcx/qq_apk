package com.tencent.mobileqq.activity.contacts.publicaccount;

import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.CharSpelling;
import java.util.Comparator;

class PublicAccountFragment$6
  implements Comparator<PublicAccountFragment.InnerPAInfo>
{
  PublicAccountFragment$6(PublicAccountFragment paramPublicAccountFragment) {}
  
  public int a(PublicAccountFragment.InnerPAInfo paramInnerPAInfo1, PublicAccountFragment.InnerPAInfo paramInnerPAInfo2)
  {
    paramInnerPAInfo1 = paramInnerPAInfo1.a.name;
    paramInnerPAInfo2 = paramInnerPAInfo2.a.name;
    if ((paramInnerPAInfo1 == null) && (paramInnerPAInfo2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramInnerPAInfo1 == null) && (paramInnerPAInfo2 != null)) {
        return -1;
      }
      if ((paramInnerPAInfo1 != null) && (paramInnerPAInfo2 == null)) {
        return 1;
      }
      j = paramInnerPAInfo1.length();
      k = paramInnerPAInfo2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramInnerPAInfo1.charAt(i);
        char c2 = paramInnerPAInfo2.charAt(i);
        if (c1 != c2)
        {
          paramInnerPAInfo1 = ChnToSpell.a(c1, i);
          paramInnerPAInfo2 = ChnToSpell.a(c2, i);
          if (paramInnerPAInfo1.jdField_a_of_type_Int == paramInnerPAInfo2.jdField_a_of_type_Int) {
            return paramInnerPAInfo1.jdField_a_of_type_JavaLangString.compareTo(paramInnerPAInfo2.jdField_a_of_type_JavaLangString);
          }
          return paramInnerPAInfo1.jdField_a_of_type_Int - paramInnerPAInfo2.jdField_a_of_type_Int;
        }
        i += 1;
      }
      if (j < k) {
        return -1;
      }
    } while (j <= k);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.6
 * JD-Core Version:    0.7.0.1
 */