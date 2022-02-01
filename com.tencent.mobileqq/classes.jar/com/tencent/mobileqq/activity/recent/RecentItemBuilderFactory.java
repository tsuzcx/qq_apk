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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessItemBuilder;
import com.tencent.mobileqq.matchchat.MatchEmptyItemBuilder;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import org.jetbrains.annotations.Nullable;

public class RecentItemBuilderFactory
{
  protected static final int[] a;
  protected static final int[] b = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
  protected static final int[] c = { 0, 1, 2, 3 };
  protected static final int[] d = { 0, 1 };
  protected static final int[] e = { 0, 1, 2, 3 };
  protected static final int[] f = { 0, 1 };
  protected static final int[] g = { 0, 1, 2 };
  protected static final int[] h = { 0, 1, 2 };
  protected static final int[] i = { 0, 1, 2 };
  protected static final int[] j = { 0, 1, 2 };
  protected static final int[] k = { 0, 1, 2, 3 };
  protected static final int[] l = { 0, 1, 2, 3 };
  protected int a;
  protected RecentAdapter a;
  protected RecentItemBaseBuilder[] a;
  protected int[] m;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0 };
  }
  
  public RecentItemBuilderFactory(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt == 0) {
      this.m = b;
    } else if (paramInt == 1) {
      this.m = e;
    } else if (paramInt == 5) {
      this.m = i;
    } else if (paramInt == 6) {
      this.m = c;
    } else if (paramInt == 7) {
      this.m = d;
    } else if (paramInt == 9) {
      this.m = j;
    } else if (paramInt == 11) {
      this.m = k;
    } else if (paramInt == 12) {
      this.m = h;
    } else if (paramInt == 13) {
      this.m = l;
    } else if (paramInt == 14) {
      this.m = f;
    } else if (paramInt == 15) {
      this.m = g;
    } else {
      this.m = jdField_a_of_type_ArrayOfInt;
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder = new RecentItemBaseBuilder[this.m.length];
  }
  
  private int a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RecentBaseData)) {
      return this.m[1];
    }
    int n = paramInt;
    if ((paramObject instanceof Integer))
    {
      n = paramInt;
      if (((Integer)paramObject).intValue() == 23) {
        n = this.m[0];
      }
    }
    return n;
  }
  
  private RecentItemBaseBuilder a(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new RecentC2CItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new RecentC2CItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
    }
    return null;
  }
  
  private int b(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RecentMatchChatListItem)) {
      return this.m[1];
    }
    boolean bool = paramObject instanceof Integer;
    if ((bool) && (((Integer)paramObject).intValue() == 20)) {
      return this.m[2];
    }
    int n = paramInt;
    if (bool)
    {
      n = paramInt;
      if (((Integer)paramObject).intValue() == 21) {
        n = this.m[3];
      }
    }
    return n;
  }
  
  @Nullable
  private RecentItemBaseBuilder b(int paramInt)
  {
    if (paramInt > 0)
    {
      Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
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
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[paramInt] = localObject1;
        return localObject1;
      }
    }
    Object localObject2 = null;
    return localObject2;
  }
  
  private int c(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RecentItemConfessMsg)) {
      return this.m[1];
    }
    boolean bool = paramObject instanceof Integer;
    if ((bool) && (((Integer)paramObject).intValue() == 16)) {
      return this.m[2];
    }
    int n = paramInt;
    if (bool)
    {
      n = paramInt;
      if (((Integer)paramObject).intValue() == 17) {
        n = this.m[3];
      }
    }
    return n;
  }
  
  @Nullable
  private RecentItemBaseBuilder c(int paramInt)
  {
    if (paramInt > 0)
    {
      Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
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
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[paramInt] = localObject1;
        return localObject1;
      }
    }
    Object localObject2 = null;
    return localObject2;
  }
  
  private int d(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof String)) {
      return this.m[0];
    }
    if ((paramObject instanceof RecentSayHelloListItem)) {
      paramInt = this.m[1];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder d(int paramInt)
  {
    if (paramInt == 1)
    {
      RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new SayHelloListItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    return null;
  }
  
  private int e(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof String)) {
      return this.m[0];
    }
    if ((paramObject instanceof RecentSayHelloBoxItem)) {
      return this.m[2];
    }
    if ((paramObject instanceof RecentItemNearbyLiveTipData)) {
      return this.m[3];
    }
    if ((paramObject instanceof RecentMsgBoxItem)) {
      paramInt = this.m[1];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder e(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new SayHelloBoxItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
    }
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new RecentDefaultItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    if (paramInt == 3)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[3] == null) {
        arrayOfRecentItemBaseBuilder[3] = new RecentLiveTipItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3];
    }
    return null;
  }
  
  private int f(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer)) {
      return this.m[1];
    }
    if ((paramObject instanceof RecentBaseData)) {
      paramInt = this.m[2];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder f(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new RecentBlankItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
    }
    return null;
  }
  
  private int g(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 11) {}
      for (paramInt = this.m[1];; paramInt = this.m[1])
      {
        return paramInt;
        if (paramObject.intValue() != 12) {
          break;
        }
      }
    }
    if ((paramObject instanceof RecentBaseData)) {
      paramInt = this.m[2];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder g(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new TroopAssistantEmptyItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
    }
    return null;
  }
  
  private int h(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 18) {}
      for (paramInt = this.m[1];; paramInt = this.m[1])
      {
        return paramInt;
        if (paramObject.intValue() != 19) {
          break;
        }
      }
    }
    if ((paramObject instanceof RecentBaseData)) {
      paramInt = this.m[2];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder h(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new TroopAssistantEmptyItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
    }
    return null;
  }
  
  private int i(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 3) {
        paramInt = this.m[3];
      }
      for (;;)
      {
        return paramInt;
        if (paramObject.intValue() == 4)
        {
          paramInt = this.m[1];
        }
        else
        {
          if (paramObject.intValue() != 5) {
            break;
          }
          paramInt = this.m[1];
        }
      }
    }
    if ((paramObject instanceof RecentBaseData)) {
      paramInt = this.m[2];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder i(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new TroopAssistantEmptyItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
    }
    if (paramInt == 3)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[3] == null) {
        arrayOfRecentItemBaseBuilder[3] = new TroopAssistantEducationBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3];
    }
    return null;
  }
  
  private int j(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RecentBaseData)) {
      paramInt = this.m[1];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder j(int paramInt)
  {
    if (paramInt == 1)
    {
      RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new RecentC2CItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    return null;
  }
  
  private int k(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      if (((Integer)paramObject).intValue() == 0) {
        return this.m[1];
      }
    }
    else
    {
      if ((paramObject instanceof RecentUserBaseData))
      {
        if ((paramObject instanceof RecentItemPublicAccountADFolderData)) {
          return this.m[3];
        }
        if ((paramObject instanceof RecentItemImaxADData)) {
          return this.m[4];
        }
        if ((paramObject instanceof RecentItemChatMsgData)) {
          return this.m[5];
        }
        if ((paramObject instanceof RecentItemMayKnowFriendData)) {
          return this.m[6];
        }
        if ((paramObject instanceof RecentItemMayKnowFriendVerticalListData)) {
          return this.m[7];
        }
        if ((paramObject instanceof RecentItemAppletsFolderData)) {
          return this.m[8];
        }
        if ((paramObject instanceof RecentItemContactsGuideData)) {
          return this.m[9];
        }
        if ((paramObject instanceof RecentItemRecommendTroopData)) {
          return this.m[10];
        }
        return this.m[2];
      }
      if ((paramObject instanceof String)) {
        paramInt = this.m[0];
      }
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder k(int paramInt)
  {
    RecentItemBaseBuilder[] arrayOfRecentItemBaseBuilder;
    if (paramInt == 1)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[1] == null) {
        arrayOfRecentItemBaseBuilder[1] = new RecentEmptyItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    if (paramInt == 2)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[2] == null) {
        arrayOfRecentItemBaseBuilder[2] = new RecentEfficientItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
    }
    if (paramInt == 3)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[3] == null) {
        arrayOfRecentItemBaseBuilder[3] = new RecentPublicAccountAdItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3];
    }
    if (paramInt == 4)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[4] == null) {
        arrayOfRecentItemBaseBuilder[4] = new RecentImaxAdItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[4];
    }
    if (paramInt == 5)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[5] == null) {
        arrayOfRecentItemBaseBuilder[5] = new RecentC2CItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[5];
    }
    if (paramInt == 6)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[6] == null) {
        arrayOfRecentItemBaseBuilder[6] = new RecentMayKnowFriendItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6];
    }
    if (paramInt == 7)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[7] == null) {
        arrayOfRecentItemBaseBuilder[7] = new RecentMayKnowFriendVerticalListItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[7];
    }
    if (paramInt == 8)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[8] == null) {
        arrayOfRecentItemBaseBuilder[8] = new RecentAppletsItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[8];
    }
    if (paramInt == 9)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[9] == null) {
        arrayOfRecentItemBaseBuilder[9] = new RecentContactsGuideItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[9];
    }
    if (paramInt == 10)
    {
      arrayOfRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (arrayOfRecentItemBaseBuilder[10] == null) {
        arrayOfRecentItemBaseBuilder[10] = new RecentRecommendTroopItemBuilder();
      }
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[10];
    }
    return null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(Object paramObject)
  {
    int n = this.m[0];
    int i1 = this.jdField_a_of_type_Int;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 5)
        {
          if (i1 != 6)
          {
            if (i1 != 7)
            {
              if (i1 != 9)
              {
                switch (i1)
                {
                default: 
                  return n;
                case 15: 
                  return a(paramObject, n);
                case 14: 
                  return j(paramObject, n);
                case 13: 
                  return b(paramObject, n);
                case 12: 
                  return h(paramObject, n);
                }
                return c(paramObject, n);
              }
              return g(paramObject, n);
            }
            return d(paramObject, n);
          }
          return e(paramObject, n);
        }
        return f(paramObject, n);
      }
      return i(paramObject, n);
    }
    return k(paramObject, n);
  }
  
  public RecentItemBaseBuilder a(Object paramObject)
  {
    int n = a(paramObject);
    int i1 = this.jdField_a_of_type_Int;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 5)
        {
          if (i1 != 6)
          {
            if (i1 != 7)
            {
              if (i1 != 9) {
                switch (i1)
                {
                default: 
                  paramObject = null;
                  break;
                case 15: 
                  paramObject = a(n);
                  break;
                case 14: 
                  paramObject = j(n);
                  break;
                case 13: 
                  paramObject = b(n);
                  break;
                case 12: 
                  paramObject = h(n);
                  break;
                case 11: 
                  paramObject = c(n);
                  break;
                }
              } else {
                paramObject = g(n);
              }
            }
            else {
              paramObject = d(n);
            }
          }
          else {
            paramObject = e(n);
          }
        }
        else {
          paramObject = f(n);
        }
      }
      else {
        paramObject = i(n);
      }
    }
    else {
      paramObject = k(n);
    }
    Object localObject = paramObject;
    if (paramObject == null)
    {
      paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if (paramObject[0] == null) {
        paramObject[0] = new RecentBlankItemBuilder();
      }
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[0];
    }
    ((RecentItemBaseBuilder)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    return localObject;
  }
  
  public void a(RecentAdapter paramRecentAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = paramRecentAdapter;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      paramQQAppInterface = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 6) && ((paramQQAppInterface[6] instanceof RecentMayKnowFriendItemBuilder)))
      {
        ((RecentMayKnowFriendItemBuilder)paramQQAppInterface[6]).a();
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6] = null;
      }
    }
  }
  
  public int b()
  {
    return this.m.length;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      paramQQAppInterface = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 6) && ((paramQQAppInterface[6] instanceof RecentMayKnowFriendItemBuilder)))
      {
        ((RecentMayKnowFriendItemBuilder)paramQQAppInterface[6]).a();
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6] = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */