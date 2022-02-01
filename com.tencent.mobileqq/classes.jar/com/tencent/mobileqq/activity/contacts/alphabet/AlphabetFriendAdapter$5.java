package com.tencent.mobileqq.activity.contacts.alphabet;

import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.CharSpelling;
import java.util.Comparator;

class AlphabetFriendAdapter$5
  implements Comparator<AlphabetFriendAdapter.AlphabetFriend>
{
  AlphabetFriendAdapter$5(AlphabetFriendAdapter paramAlphabetFriendAdapter) {}
  
  public int a(AlphabetFriendAdapter.AlphabetFriend paramAlphabetFriend1, AlphabetFriendAdapter.AlphabetFriend paramAlphabetFriend2)
  {
    if ((paramAlphabetFriend1 == null) && (paramAlphabetFriend2 == null)) {
      return 0;
    }
    if ((paramAlphabetFriend1 == null) && (paramAlphabetFriend2 != null)) {
      return -1;
    }
    if ((paramAlphabetFriend1 != null) && (paramAlphabetFriend2 == null)) {
      return 1;
    }
    paramAlphabetFriend1 = paramAlphabetFriend1.b;
    paramAlphabetFriend2 = paramAlphabetFriend2.b;
    if ((paramAlphabetFriend1 == null) && (paramAlphabetFriend2 == null)) {
      return 0;
    }
    if ((paramAlphabetFriend1 == null) && (paramAlphabetFriend2 != null)) {
      return -1;
    }
    if ((paramAlphabetFriend1 != null) && (paramAlphabetFriend2 == null)) {
      return 1;
    }
    int j = paramAlphabetFriend1.length();
    int k = paramAlphabetFriend2.length();
    int m = Math.min(j, k);
    int i = 0;
    while (i < m)
    {
      char c1 = paramAlphabetFriend1.charAt(i);
      char c2 = paramAlphabetFriend2.charAt(i);
      if (c1 != c2)
      {
        paramAlphabetFriend1 = ChnToSpell.a(c1);
        paramAlphabetFriend2 = ChnToSpell.a(c2);
        if (paramAlphabetFriend1.a == paramAlphabetFriend2.a) {
          return paramAlphabetFriend1.b.compareTo(paramAlphabetFriend2.b);
        }
        return paramAlphabetFriend1.a - paramAlphabetFriend2.a;
      }
      i += 1;
    }
    if (j < k) {
      return -1;
    }
    if (j > k) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter.5
 * JD-Core Version:    0.7.0.1
 */