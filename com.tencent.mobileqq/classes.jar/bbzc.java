import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.qphone.base.util.QLog;

public abstract class bbzc
  implements bbzd
{
  public static long A = SearchConfigManager.typeDiscussionConversationMatchTitle << SearchConfigManager.contactSearchTypeBaseBit;
  public static long B = SearchConfigManager.typeDiscussionConversation << SearchConfigManager.contactSearchTypeBaseBit;
  public static long C = SearchConfigManager.typeTroopConversation << SearchConfigManager.contactSearchTypeBaseBit;
  public static long D = SearchConfigManager.typeFriendSpecialCare << SearchConfigManager.contactSearchTypeBaseBit;
  public static long E = SearchConfigManager.typeFriend << SearchConfigManager.contactSearchTypeBaseBit;
  public static long F = SearchConfigManager.typeFriendNotOftenContact << SearchConfigManager.contactSearchTypeBaseBit;
  public static long G = SearchConfigManager.typeNewTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
  public static long H = SearchConfigManager.typeDiscussionMember << SearchConfigManager.contactSearchTypeBaseBit;
  public static long I = SearchConfigManager.typePhoneContact << SearchConfigManager.contactSearchTypeBaseBit;
  public static long J = SearchConfigManager.typeDiscussionConversationMatchMember << SearchConfigManager.contactSearchTypeBaseBit;
  public static long K = SearchConfigManager.typeNewTroop << SearchConfigManager.contactSearchTypeBaseBit;
  public static long L = SearchConfigManager.typeDiscussion << SearchConfigManager.contactSearchTypeBaseBit;
  public static long M = SearchConfigManager.typeTroop << SearchConfigManager.contactSearchTypeBaseBit;
  public static long N = SearchConfigManager.typeTool << SearchConfigManager.contactSearchTypeBaseBit;
  public static long O = SearchConfigManager.typePublicAccountConversation << SearchConfigManager.contactSearchTypeBaseBit;
  public static long P = SearchConfigManager.typePublicAccount << SearchConfigManager.contactSearchTypeBaseBit;
  public static long Q = SearchConfigManager.typeUnbindPhoneContact << SearchConfigManager.contactSearchTypeBaseBit;
  public static long R = SearchConfigManager.typeCircleContact << SearchConfigManager.contactSearchTypeBaseBit;
  public static long S = SearchConfigManager.typeTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
  public static long T = SearchConfigManager.typeGlobalTroop << SearchConfigManager.contactSearchTypeBaseBit;
  public static long U = SearchConfigManager.typeGlobalTroopConversation << SearchConfigManager.contactSearchTypeBaseBit;
  public static long V = SearchConfigManager.typeGlobalTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
  public static long W = SearchConfigManager.typeQidianMaster << SearchConfigManager.contactSearchTypeBaseBit;
  public static long a = SearchConfigManager.fieldPublicAccountName << SearchConfigManager.contactSearchFieldBaseBit;
  public static long b = SearchConfigManager.fieldPublicAccountMark << SearchConfigManager.contactSearchFieldBaseBit;
  public static long c = SearchConfigManager.fieldPublicAccountSummary << SearchConfigManager.contactSearchFieldBaseBit;
  public static long d = SearchConfigManager.fieldPublicAccountDisplayName << SearchConfigManager.contactSearchFieldBaseBit;
  public static long e = SearchConfigManager.filedDiscussionName << SearchConfigManager.contactSearchFieldBaseBit;
  public static long f = SearchConfigManager.fieldTroopName << SearchConfigManager.contactSearchFieldBaseBit;
  public static long g = SearchConfigManager.fieldRemark << SearchConfigManager.contactSearchFieldBaseBit;
  public static long h = SearchConfigManager.fieldNewTroopNickName << SearchConfigManager.contactSearchFieldBaseBit;
  public static long i = SearchConfigManager.fieldNewTroopCard << SearchConfigManager.contactSearchFieldBaseBit;
  public static long j = SearchConfigManager.fieldDiscussionMemberRemark << SearchConfigManager.contactSearchFieldBaseBit;
  public static long k = SearchConfigManager.fieldInteRemark << SearchConfigManager.contactSearchFieldBaseBit;
  public static long l = SearchConfigManager.fieldNickName << SearchConfigManager.contactSearchFieldBaseBit;
  public static long m = SearchConfigManager.fieldPhoneContactName << SearchConfigManager.contactSearchFieldBaseBit;
  public static long n = SearchConfigManager.fieldAlias << SearchConfigManager.contactSearchFieldBaseBit;
  public static long o = SearchConfigManager.fieldUin << SearchConfigManager.contactSearchFieldBaseBit;
  public static long p = SearchConfigManager.fieldMobileNo << SearchConfigManager.contactSearchFieldBaseBit;
  public static long q = SearchConfigManager.fieldTroopCard << SearchConfigManager.contactSearchFieldBaseBit;
  public static long r = SearchConfigManager.stringOrigin << SearchConfigManager.contactSearchPinyinBaseBit;
  public static long s = SearchConfigManager.stringPinyin << SearchConfigManager.contactSearchPinyinBaseBit;
  public static long t = SearchConfigManager.recentTrue << SearchConfigManager.contactSearchRecentBaseBit;
  public static long u = SearchConfigManager.indexEqual << SearchConfigManager.contactSearchIndexBaseBit;
  public static long v = SearchConfigManager.indexStart << SearchConfigManager.contactSearchIndexBaseBit;
  public static long w = SearchConfigManager.indexMiddle << SearchConfigManager.contactSearchIndexBaseBit;
  public static long x = 72057594037927936L;
  public static long y = SearchConfigManager.typeDiscussionMatchMemberFull << SearchConfigManager.contactSearchTypeBaseBit;
  public static long z = SearchConfigManager.typeFriendConversation << SearchConfigManager.contactSearchTypeBaseBit;
  protected long X;
  protected long Y = -1L;
  protected long Z;
  protected long aa;
  
  public static void a()
  {
    a = SearchConfigManager.fieldPublicAccountName << SearchConfigManager.contactSearchFieldBaseBit;
    b = SearchConfigManager.fieldPublicAccountMark << SearchConfigManager.contactSearchFieldBaseBit;
    c = SearchConfigManager.fieldPublicAccountSummary << SearchConfigManager.contactSearchFieldBaseBit;
    d = SearchConfigManager.fieldPublicAccountDisplayName << SearchConfigManager.contactSearchFieldBaseBit;
    e = SearchConfigManager.filedDiscussionName << SearchConfigManager.contactSearchFieldBaseBit;
    f = SearchConfigManager.fieldTroopName << SearchConfigManager.contactSearchFieldBaseBit;
    g = SearchConfigManager.fieldRemark << SearchConfigManager.contactSearchFieldBaseBit;
    h = SearchConfigManager.fieldNewTroopNickName << SearchConfigManager.contactSearchFieldBaseBit;
    i = SearchConfigManager.fieldNewTroopCard << SearchConfigManager.contactSearchFieldBaseBit;
    j = SearchConfigManager.fieldDiscussionMemberRemark << SearchConfigManager.contactSearchFieldBaseBit;
    k = SearchConfigManager.fieldInteRemark << SearchConfigManager.contactSearchFieldBaseBit;
    l = SearchConfigManager.fieldNickName << SearchConfigManager.contactSearchFieldBaseBit;
    m = SearchConfigManager.fieldPhoneContactName << SearchConfigManager.contactSearchFieldBaseBit;
    n = SearchConfigManager.fieldAlias << SearchConfigManager.contactSearchFieldBaseBit;
    o = SearchConfigManager.fieldUin << SearchConfigManager.contactSearchFieldBaseBit;
    p = SearchConfigManager.fieldMobileNo << SearchConfigManager.contactSearchFieldBaseBit;
    q = SearchConfigManager.fieldTroopCard << SearchConfigManager.contactSearchFieldBaseBit;
    r = SearchConfigManager.stringOrigin << SearchConfigManager.contactSearchPinyinBaseBit;
    s = SearchConfigManager.stringPinyin << SearchConfigManager.contactSearchPinyinBaseBit;
    t = SearchConfigManager.recentTrue << SearchConfigManager.contactSearchRecentBaseBit;
    u = SearchConfigManager.indexEqual << SearchConfigManager.contactSearchIndexBaseBit;
    v = SearchConfigManager.indexStart << SearchConfigManager.contactSearchIndexBaseBit;
    w = SearchConfigManager.indexMiddle << SearchConfigManager.contactSearchIndexBaseBit;
    x = 72057594037927936L;
    y = SearchConfigManager.typeDiscussionMatchMemberFull << SearchConfigManager.contactSearchTypeBaseBit;
    z = SearchConfigManager.typeFriendConversation << SearchConfigManager.contactSearchTypeBaseBit;
    A = SearchConfigManager.typeDiscussionConversationMatchTitle << SearchConfigManager.contactSearchTypeBaseBit;
    B = SearchConfigManager.typeDiscussionConversation << SearchConfigManager.contactSearchTypeBaseBit;
    C = SearchConfigManager.typeTroopConversation << SearchConfigManager.contactSearchTypeBaseBit;
    D = SearchConfigManager.typeFriendSpecialCare << SearchConfigManager.contactSearchTypeBaseBit;
    E = SearchConfigManager.typeFriend << SearchConfigManager.contactSearchTypeBaseBit;
    F = SearchConfigManager.typeFriendNotOftenContact << SearchConfigManager.contactSearchTypeBaseBit;
    G = SearchConfigManager.typeNewTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
    H = SearchConfigManager.typeDiscussionMember << SearchConfigManager.contactSearchTypeBaseBit;
    I = SearchConfigManager.typePhoneContact << SearchConfigManager.contactSearchTypeBaseBit;
    J = SearchConfigManager.typeDiscussionConversationMatchMember << SearchConfigManager.contactSearchTypeBaseBit;
    K = SearchConfigManager.typeNewTroop << SearchConfigManager.contactSearchTypeBaseBit;
    L = SearchConfigManager.typeDiscussion << SearchConfigManager.contactSearchTypeBaseBit;
    M = SearchConfigManager.typeTroop << SearchConfigManager.contactSearchTypeBaseBit;
    N = SearchConfigManager.typeTool << SearchConfigManager.contactSearchTypeBaseBit;
    O = SearchConfigManager.typePublicAccountConversation << SearchConfigManager.contactSearchTypeBaseBit;
    P = SearchConfigManager.typePublicAccount << SearchConfigManager.contactSearchTypeBaseBit;
    Q = SearchConfigManager.typeUnbindPhoneContact << SearchConfigManager.contactSearchTypeBaseBit;
    R = SearchConfigManager.typeCircleContact << SearchConfigManager.contactSearchTypeBaseBit;
    S = SearchConfigManager.typeTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
    T = SearchConfigManager.typeGlobalTroop << SearchConfigManager.contactSearchTypeBaseBit;
    U = SearchConfigManager.typeGlobalTroopConversation << SearchConfigManager.contactSearchTypeBaseBit;
    V = SearchConfigManager.typeGlobalTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
    W = SearchConfigManager.typeQidianMaster << SearchConfigManager.contactSearchTypeBaseBit;
  }
  
  protected long a()
  {
    return 0L;
  }
  
  public abstract Drawable a();
  
  public abstract Object a();
  
  public abstract String a();
  
  public void a(long paramLong)
  {
    this.Z = paramLong;
  }
  
  public abstract int b();
  
  public long b()
  {
    return d();
  }
  
  public abstract String b();
  
  protected void b()
  {
    for (;;)
    {
      int i1;
      try
      {
        String str = d();
        StringBuilder localStringBuilder = new StringBuilder();
        i1 = 0;
        if (i1 < str.length())
        {
          char c1 = str.charAt(i1);
          if ((c1 >= '0') && (c1 <= '9')) {
            localStringBuilder.append(c1);
          }
        }
        else
        {
          str = localStringBuilder.toString();
          if (!TextUtils.isEmpty(str))
          {
            this.X = Long.parseLong(str);
            return;
          }
          this.X = hashCode();
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        this.X = hashCode();
        return;
      }
      i1 += 1;
    }
  }
  
  public abstract int c();
  
  public long c()
  {
    return this.Z;
  }
  
  public abstract String c();
  
  public long d()
  {
    if (this.Y == -1L) {
      this.Y = a();
    }
    return this.Y;
  }
  
  public abstract String d();
  
  public boolean equals(Object paramObject)
  {
    return this.X == ((bbzc)paramObject).X;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzc
 * JD-Core Version:    0.7.0.1
 */