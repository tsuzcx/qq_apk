package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.activity.recent.data.RecentItemAppletsFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemContactsGuideData;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxItemBuilder;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.RecentGameMsgBoxItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessItemBuilder;
import com.tencent.mobileqq.matchchat.MatchEmptyItemBuilder;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import org.jetbrains.annotations.Nullable;

public class RecentItemBuilderFactory
{
  protected static final int[] a = { 0 };
  protected static final int[] b = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
  protected static final int[] c = { 0, 1, 2, 3 };
  protected static final int[] d = { 0, 1 };
  protected static final int[] e = { 0, 1, 2, 3 };
  protected static final int[] f = { 0, 1 };
  protected static final int[] g = { 0, 1, 2 };
  protected static final int[] h = { 0, 1, 2 };
  protected static final int[] i = { 0, 1, 2 };
  protected static final int[] j = { 0, 1, 2 };
  protected static final int[] k = { 0, 1, 2 };
  protected static final int[] l = { 0, 1, 2, 3 };
  protected static final int[] m = { 0, 1, 2, 3 };
  protected static final int[] n = { 0, 1, 2 };
  protected int o;
  protected int[] p;
  protected RecentAdapter q;
  protected RecentItemBaseBuilder[] r;
  
  public RecentItemBuilderFactory(int paramInt)
  {
    this.o = paramInt;
    paramInt = this.o;
    if (paramInt == 0) {
      this.p = b;
    } else if (paramInt == 1) {
      this.p = e;
    } else if (paramInt == 5) {
      this.p = j;
    } else if (paramInt == 6) {
      this.p = c;
    } else if (paramInt == 7) {
      this.p = d;
    } else if (paramInt == 9) {
      this.p = k;
    } else if (paramInt == 11) {
      this.p = l;
    } else if (paramInt == 12) {
      this.p = i;
    } else if (paramInt == 13) {
      this.p = m;
    } else if (paramInt == 14) {
      this.p = f;
    } else if (paramInt == 15) {
      this.p = g;
    } else if (paramInt == 16) {
      this.p = n;
    } else if (paramInt == 17) {
      this.p = h;
    } else {
      this.p = a;
    }
    this.r = new RecentItemBaseBuilder[this.p.length];
  }
  
  private int a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RecentBaseData)) {
      return this.p[1];
    }
    int i1 = paramInt;
    if ((paramObject instanceof Integer))
    {
      i1 = paramInt;
      if (((Integer)paramObject).intValue() == 24) {
        i1 = this.p[0];
      }
    }
    return i1;
  }
  
  private RecentItemBaseBuilder a(int paramInt)
  {
    if (paramInt == 1)
    {
      RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new RecentRIJPrivateChatItemBuilder();
      }
      return this.r[1];
    }
    return null;
  }
  
  private int b(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RecentBaseData)) {
      return this.p[1];
    }
    int i1 = paramInt;
    if ((paramObject instanceof Integer))
    {
      i1 = paramInt;
      if (((Integer)paramObject).intValue() == 23) {
        i1 = this.p[0];
      }
    }
    return i1;
  }
  
  private RecentItemBaseBuilder b(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new RecentC2CItemBuilder();
      }
      return this.r[1];
    }
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new RecentC2CItemBuilder();
      }
      return this.r[2];
    }
    return null;
  }
  
  private int c(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RecentGameMsgBoxItem)) {
      return this.p[2];
    }
    int i1 = paramInt;
    if ((paramObject instanceof Integer))
    {
      i1 = paramInt;
      if (((Integer)paramObject).intValue() == 0) {
        i1 = this.p[1];
      }
    }
    return i1;
  }
  
  private RecentItemBaseBuilder c(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new GameMsgBoxItemBuilder();
      }
      return this.r[2];
    }
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new RecentEmptyItemBuilder();
      }
      return this.r[1];
    }
    return null;
  }
  
  private int d(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RecentMatchChatListItem)) {
      return this.p[1];
    }
    boolean bool = paramObject instanceof Integer;
    if ((bool) && (((Integer)paramObject).intValue() == 20)) {
      return this.p[2];
    }
    int i1 = paramInt;
    if (bool)
    {
      i1 = paramInt;
      if (((Integer)paramObject).intValue() == 21) {
        i1 = this.p[3];
      }
    }
    return i1;
  }
  
  @Nullable
  private RecentItemBaseBuilder d(int paramInt)
  {
    if (paramInt > 0)
    {
      Object localObject1 = this.r;
      if (paramInt < localObject1.length)
      {
        localObject1 = localObject1[paramInt];
        localObject2 = localObject1;
        if (localObject1 != null) {
          return localObject2;
        }
        if (paramInt != 1)
        {
          if ((paramInt == 2) || (paramInt == 3)) {
            localObject1 = new MatchEmptyItemBuilder();
          }
        }
        else {
          localObject1 = new RecentEfficientItemBuilder();
        }
        this.r[paramInt] = localObject1;
        return localObject1;
      }
    }
    Object localObject2 = null;
    return localObject2;
  }
  
  private int e(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RecentItemConfessMsg)) {
      return this.p[1];
    }
    boolean bool = paramObject instanceof Integer;
    if ((bool) && (((Integer)paramObject).intValue() == 16)) {
      return this.p[2];
    }
    int i1 = paramInt;
    if (bool)
    {
      i1 = paramInt;
      if (((Integer)paramObject).intValue() == 17) {
        i1 = this.p[3];
      }
    }
    return i1;
  }
  
  @Nullable
  private RecentItemBaseBuilder e(int paramInt)
  {
    if (paramInt > 0)
    {
      Object localObject1 = this.r;
      if (paramInt < localObject1.length)
      {
        localObject1 = localObject1[paramInt];
        localObject2 = localObject1;
        if (localObject1 != null) {
          return localObject2;
        }
        if (paramInt != 1)
        {
          if ((paramInt == 2) || (paramInt == 3)) {
            localObject1 = new ConfessItemBuilder();
          }
        }
        else {
          localObject1 = new RecentConfessItemBuilder();
        }
        this.r[paramInt] = localObject1;
        return localObject1;
      }
    }
    Object localObject2 = null;
    return localObject2;
  }
  
  private int f(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof String)) {
      return this.p[0];
    }
    if ((paramObject instanceof RecentSayHelloListItem)) {
      paramInt = this.p[1];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder f(int paramInt)
  {
    if (paramInt == 1)
    {
      RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new SayHelloListItemBuilder();
      }
      return this.r[1];
    }
    return null;
  }
  
  private int g(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof String)) {
      return this.p[0];
    }
    if ((paramObject instanceof RecentSayHelloBoxItem)) {
      return this.p[2];
    }
    if ((paramObject instanceof RecentItemNearbyLiveTipData)) {
      return this.p[3];
    }
    if ((paramObject instanceof RecentMsgBoxItem)) {
      paramInt = this.p[1];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder g(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new SayHelloBoxItemBuilder();
      }
      return this.r[2];
    }
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new RecentDefaultItemBuilder();
      }
      return this.r[1];
    }
    if (paramInt == 3)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[3] == null) {
        arrayOfRecentItemBaseBuilder[3] = new RecentLiveTipItemBuilder();
      }
      return this.r[3];
    }
    return null;
  }
  
  private int h(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer)) {
      return this.p[1];
    }
    if ((paramObject instanceof RecentBaseData)) {
      paramInt = this.p[2];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder h(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new RecentBlankItemBuilder();
      }
      return this.r[1];
    }
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
      }
      return this.r[2];
    }
    return null;
  }
  
  private int i(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 11) {}
      for (paramInt = this.p[1];; paramInt = this.p[1])
      {
        return paramInt;
        if (paramObject.intValue() != 12) {
          break;
        }
      }
    }
    if ((paramObject instanceof RecentBaseData)) {
      paramInt = this.p[2];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder i(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new TroopAssistantEmptyItemBuilder();
      }
      return this.r[1];
    }
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
      }
      return this.r[2];
    }
    return null;
  }
  
  private int j(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 18) {}
      for (paramInt = this.p[1];; paramInt = this.p[1])
      {
        return paramInt;
        if (paramObject.intValue() != 19) {
          break;
        }
      }
    }
    if ((paramObject instanceof RecentBaseData)) {
      paramInt = this.p[2];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder j(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new TroopAssistantEmptyItemBuilder();
      }
      return this.r[1];
    }
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
      }
      return this.r[2];
    }
    return null;
  }
  
  private int k(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 3) {
        paramInt = this.p[3];
      }
      for (;;)
      {
        return paramInt;
        if (paramObject.intValue() == 4)
        {
          paramInt = this.p[1];
        }
        else
        {
          if (paramObject.intValue() != 5) {
            break;
          }
          paramInt = this.p[1];
        }
      }
    }
    if ((paramObject instanceof RecentBaseData)) {
      paramInt = this.p[2];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder k(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new TroopAssistantEmptyItemBuilder();
      }
      return this.r[1];
    }
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
      }
      return this.r[2];
    }
    if (paramInt == 3)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[3] == null) {
        arrayOfRecentItemBaseBuilder[3] = new TroopAssistantEducationBuilder();
      }
      return this.r[3];
    }
    return null;
  }
  
  private int l(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RecentBaseData)) {
      paramInt = this.p[1];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder l(int paramInt)
  {
    if (paramInt == 1)
    {
      RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new RecentC2CItemBuilder();
      }
      return this.r[1];
    }
    return null;
  }
  
  private int m(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      if (((Integer)paramObject).intValue() == 0) {
        return this.p[1];
      }
    }
    else
    {
      if ((paramObject instanceof RecentUserBaseData))
      {
        if ((paramObject instanceof RecentItemPublicAccountADFolderData)) {
          return this.p[3];
        }
        if ((paramObject instanceof RecentItemImaxADData)) {
          return this.p[4];
        }
        if ((paramObject instanceof RecentItemChatMsgData)) {
          return this.p[5];
        }
        if ((paramObject instanceof RecentItemMayKnowFriendData)) {
          return this.p[6];
        }
        if ((paramObject instanceof RecentItemMayKnowFriendVerticalListData)) {
          return this.p[7];
        }
        if ((paramObject instanceof RecentItemAppletsFolderData)) {
          return this.p[8];
        }
        if ((paramObject instanceof RecentItemContactsGuideData)) {
          return this.p[9];
        }
        if ((paramObject instanceof RecentItemRecommendTroopData)) {
          return this.p[10];
        }
        return this.p[2];
      }
      if ((paramObject instanceof String)) {
        paramInt = this.p[0];
      }
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder m(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new RecentEmptyItemBuilder();
      }
      return this.r[1];
    }
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new RecentEfficientItemBuilder();
      }
      return this.r[2];
    }
    if (paramInt == 3)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[3] == null) {
        arrayOfRecentItemBaseBuilder[3] = new RecentPublicAccountAdItemBuilder();
      }
      return this.r[3];
    }
    if (paramInt == 4)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[4] == null) {
        arrayOfRecentItemBaseBuilder[4] = new RecentImaxAdItemBuilder();
      }
      return this.r[4];
    }
    if (paramInt == 5)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[5] == null) {
        arrayOfRecentItemBaseBuilder[5] = new RecentC2CItemBuilder();
      }
      return this.r[5];
    }
    if (paramInt == 6)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[6] == null) {
        arrayOfRecentItemBaseBuilder[6] = new RecentMayKnowFriendItemBuilder();
      }
      return this.r[6];
    }
    if (paramInt == 7)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[7] == null) {
        arrayOfRecentItemBaseBuilder[7] = new RecentMayKnowFriendVerticalListItemBuilder();
      }
      return this.r[7];
    }
    if (paramInt == 8)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[8] == null) {
        arrayOfRecentItemBaseBuilder[8] = new RecentAppletsItemBuilder();
      }
      return this.r[8];
    }
    if (paramInt == 9)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[9] == null) {
        arrayOfRecentItemBaseBuilder[9] = new RecentContactsGuideItemBuilder();
      }
      return this.r[9];
    }
    if (paramInt == 10)
    {
      arrayOfRecentItemBaseBuilder = this.r;
      if (arrayOfRecentItemBaseBuilder[10] == null) {
        arrayOfRecentItemBaseBuilder[10] = new RecentRecommendTroopItemBuilder();
      }
      return this.r[10];
    }
    return null;
  }
  
  public int a()
  {
    return this.o;
  }
  
  public int a(Object paramObject)
  {
    int i1 = this.p[0];
    int i2 = this.o;
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 != 5)
        {
          if (i2 != 6)
          {
            if (i2 != 7)
            {
              if (i2 != 9)
              {
                switch (i2)
                {
                default: 
                  return i1;
                case 17: 
                  return c(paramObject, i1);
                case 16: 
                  return a(paramObject, i1);
                case 15: 
                  return b(paramObject, i1);
                case 14: 
                  return l(paramObject, i1);
                case 13: 
                  return d(paramObject, i1);
                case 12: 
                  return j(paramObject, i1);
                }
                return e(paramObject, i1);
              }
              return i(paramObject, i1);
            }
            return f(paramObject, i1);
          }
          return g(paramObject, i1);
        }
        return h(paramObject, i1);
      }
      return k(paramObject, i1);
    }
    return m(paramObject, i1);
  }
  
  public void a(RecentAdapter paramRecentAdapter)
  {
    this.q = paramRecentAdapter;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.o == 0)
    {
      paramQQAppInterface = this.r;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 6) && ((paramQQAppInterface[6] instanceof RecentMayKnowFriendItemBuilder)))
      {
        ((RecentMayKnowFriendItemBuilder)paramQQAppInterface[6]).b();
        this.r[6] = null;
      }
    }
  }
  
  public int b()
  {
    return this.p.length;
  }
  
  public RecentItemBaseBuilder b(Object paramObject)
  {
    int i1 = a(paramObject);
    int i2 = this.o;
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 != 5)
        {
          if (i2 != 6)
          {
            if (i2 != 7)
            {
              if (i2 != 9) {
                switch (i2)
                {
                default: 
                  paramObject = null;
                  break;
                case 17: 
                  paramObject = c(i1);
                  break;
                case 16: 
                  paramObject = a(i1);
                  break;
                case 15: 
                  paramObject = b(i1);
                  break;
                case 14: 
                  paramObject = l(i1);
                  break;
                case 13: 
                  paramObject = d(i1);
                  break;
                case 12: 
                  paramObject = j(i1);
                  break;
                case 11: 
                  paramObject = e(i1);
                  break;
                }
              } else {
                paramObject = i(i1);
              }
            }
            else {
              paramObject = f(i1);
            }
          }
          else {
            paramObject = g(i1);
          }
        }
        else {
          paramObject = h(i1);
        }
      }
      else {
        paramObject = k(i1);
      }
    }
    else {
      paramObject = m(i1);
    }
    Object localObject = paramObject;
    if (paramObject == null)
    {
      paramObject = this.r;
      if (paramObject[0] == null) {
        paramObject[0] = new RecentBlankItemBuilder();
      }
      localObject = this.r[0];
    }
    ((RecentItemBaseBuilder)localObject).a(this.q);
    return localObject;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (this.o == 0)
    {
      paramQQAppInterface = this.r;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 6) && ((paramQQAppInterface[6] instanceof RecentMayKnowFriendItemBuilder)))
      {
        ((RecentMayKnowFriendItemBuilder)paramQQAppInterface[6]).b();
        this.r[6] = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */