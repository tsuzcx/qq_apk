import android.text.TextUtils;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Comparator;

public class anvp
{
  public static Comparator<Entity> a = new anvq();
  
  private static int a(char paramChar)
  {
    if (((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'))) {
      return 1;
    }
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return 10;
    }
    return 5;
  }
  
  public static int a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (paramInt1 > paramInt2) {
      return 1;
    }
    if (paramInt1 < paramInt2) {
      return -1;
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    return str.compareTo(paramString1);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int k = 1;
    int i;
    int j;
    if (paramString1 != null)
    {
      i = paramString1.length();
      if (paramString2 == null) {
        break label40;
      }
      j = paramString2.length();
      label21:
      if ((i != 0) && (j != 0)) {
        break label45;
      }
      i -= j;
    }
    label40:
    label45:
    char[] arrayOfChar1;
    char[] arrayOfChar2;
    label175:
    label180:
    label233:
    do
    {
      do
      {
        do
        {
          return i;
          i = 0;
          break;
          j = 0;
          break label21;
          arrayOfChar1 = ChnToSpell.a(paramString1, 1).toCharArray();
          arrayOfChar2 = ChnToSpell.a(paramString2, 1).toCharArray();
          j = a(arrayOfChar1[0]);
          m = a(arrayOfChar2[0]);
          i = k;
        } while (j > m);
        if (j < m) {
          return -1;
        }
        i = k;
      } while (arrayOfChar1[0] > arrayOfChar2[0]);
      if (arrayOfChar1[0] < arrayOfChar2[0]) {
        return -1;
      }
      if (paramString1.charAt(0) < 'ÿ')
      {
        i = 1;
        if (paramString2.charAt(0) >= 'ÿ') {
          break label175;
        }
      }
      for (j = 1;; j = 0)
      {
        if ((i ^ j) == 0) {
          break label180;
        }
        return paramString1.charAt(0) - paramString2.charAt(0);
        i = 0;
        break;
      }
      int m = Math.min(arrayOfChar1.length, arrayOfChar2.length);
      j = 1;
      for (;;)
      {
        if (j >= m) {
          break label233;
        }
        i = k;
        if (arrayOfChar1[j] > arrayOfChar2[j]) {
          break;
        }
        if (arrayOfChar1[j] < arrayOfChar2[j]) {
          return -1;
        }
        j += 1;
      }
      i = k;
    } while (arrayOfChar1.length > arrayOfChar2.length);
    if (arrayOfChar1.length < arrayOfChar2.length) {
      return -1;
    }
    return 0;
  }
  
  public static String a(DiscussionInfo paramDiscussionInfo)
  {
    return paramDiscussionInfo.discussionName + "-" + paramDiscussionInfo.uin;
  }
  
  public static String a(Friends paramFriends)
  {
    String str = paramFriends.getFriendNick();
    return str + "-" + paramFriends.uin;
  }
  
  public static String a(PublicAccountInfo paramPublicAccountInfo)
  {
    return paramPublicAccountInfo.name + "-" + paramPublicAccountInfo.uin;
  }
  
  public static String a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo.hasSetTroopName()) || (TextUtils.isEmpty(paramTroopInfo.newTroopName))) {
      return paramTroopInfo.troopname + "-" + paramTroopInfo.troopcode;
    }
    return paramTroopInfo.getTroopName() + "-" + paramTroopInfo.troopcode;
  }
  
  public static ArrayList<Entity> a(ArrayList<Entity> paramArrayList, Entity paramEntity)
  {
    if (paramArrayList == null) {
      return null;
    }
    paramArrayList = (ArrayList)paramArrayList.clone();
    if (paramArrayList.size() == 0)
    {
      paramArrayList.add(paramEntity);
      return paramArrayList;
    }
    Groups localGroups1 = (Groups)paramEntity;
    int j = 0;
    int i = paramArrayList.size() - 1;
    if (j <= i)
    {
      int k = (j + i) / 2;
      Groups localGroups2 = (Groups)paramArrayList.get(k);
      if (localGroups1.seqid > localGroups2.seqid) {
        j = k + 1;
      }
      for (;;)
      {
        break;
        i = k - 1;
      }
    }
    paramArrayList.add(i + 1, paramEntity);
    return paramArrayList;
  }
  
  public static void a(DiscussionInfo paramDiscussionInfo)
  {
    String str = a(paramDiscussionInfo);
    paramDiscussionInfo.mCompareSpell = ChnToSpell.a(str, 1);
    paramDiscussionInfo.mComparePartInt = b(str, paramDiscussionInfo.mCompareSpell);
  }
  
  public static void a(Friends paramFriends)
  {
    String str = a(paramFriends);
    paramFriends.mCompareSpell = ChnToSpell.a(str, 1);
    paramFriends.mComparePartInt = b(str, paramFriends.mCompareSpell);
  }
  
  public static void a(PublicAccountInfo paramPublicAccountInfo)
  {
    String str = a(paramPublicAccountInfo);
    paramPublicAccountInfo.mCompareSpell = ChnToSpell.a(str, 1);
    paramPublicAccountInfo.mComparePartInt = b(str, paramPublicAccountInfo.mCompareSpell);
  }
  
  public static void a(TroopInfo paramTroopInfo)
  {
    String str = a(paramTroopInfo);
    paramTroopInfo.mCompareSpell = ChnToSpell.a(str, 1);
    paramTroopInfo.mComparePartInt = b(str, paramTroopInfo.mCompareSpell);
  }
  
  public static int b(String paramString1, String paramString2)
  {
    int k = paramString2.charAt(0);
    int i;
    if (((k >= 65) && (k <= 90)) || ((k >= 97) && (k <= 122)))
    {
      i = 65536;
      if (paramString1.charAt(0) < 'ÿ') {
        break label89;
      }
    }
    label89:
    for (int j = 1;; j = 0)
    {
      return j | k << 8 | i | 0x0;
      if ((k >= 48) && (k <= 57))
      {
        i = 262144;
        break;
      }
      i = 131072;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvp
 * JD-Core Version:    0.7.0.1
 */