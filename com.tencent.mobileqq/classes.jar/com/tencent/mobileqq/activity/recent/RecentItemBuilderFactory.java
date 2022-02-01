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
import com.tencent.mobileqq.apollo.activity.RecentHotchatItem;
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
  protected static final int[] k = { 0, 1, 2, 3, 4 };
  protected static final int[] l = { 0, 1, 2, 3 };
  protected static final int[] m = { 0, 1, 2, 3 };
  protected int a;
  protected RecentAdapter a;
  protected RecentItemBaseBuilder[] a;
  protected int[] n;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0 };
  }
  
  public RecentItemBuilderFactory(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0) {
      this.n = b;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder = new RecentItemBaseBuilder[this.n.length];
      return;
      if (this.jdField_a_of_type_Int == 1) {
        this.n = e;
      } else if (this.jdField_a_of_type_Int == 5) {
        this.n = i;
      } else if (this.jdField_a_of_type_Int == 6) {
        this.n = c;
      } else if (this.jdField_a_of_type_Int == 7) {
        this.n = d;
      } else if (this.jdField_a_of_type_Int == 9) {
        this.n = j;
      } else if (this.jdField_a_of_type_Int == 10) {
        this.n = k;
      } else if (this.jdField_a_of_type_Int == 11) {
        this.n = l;
      } else if (this.jdField_a_of_type_Int == 12) {
        this.n = h;
      } else if (this.jdField_a_of_type_Int == 13) {
        this.n = m;
      } else if (this.jdField_a_of_type_Int == 14) {
        this.n = f;
      } else if (this.jdField_a_of_type_Int == 15) {
        this.n = g;
      } else {
        this.n = jdField_a_of_type_ArrayOfInt;
      }
    }
  }
  
  private int a(Object paramObject, int paramInt)
  {
    int i1;
    if ((paramObject instanceof RecentBaseData)) {
      i1 = this.n[1];
    }
    do
    {
      do
      {
        return i1;
        i1 = paramInt;
      } while (!(paramObject instanceof Integer));
      i1 = paramInt;
    } while (((Integer)paramObject).intValue() != 23);
    return this.n[0];
  }
  
  private RecentItemBaseBuilder a(int paramInt)
  {
    RecentItemBaseBuilder localRecentItemBaseBuilder = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new RecentC2CItemBuilder();
      }
      localRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    while (paramInt != 2) {
      return localRecentItemBaseBuilder;
    }
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentC2CItemBuilder();
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
  }
  
  private int b(Object paramObject, int paramInt)
  {
    int i1;
    if ((paramObject instanceof RecentMatchChatListItem)) {
      i1 = this.n[1];
    }
    do
    {
      do
      {
        return i1;
        if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 20)) {
          return this.n[2];
        }
        i1 = paramInt;
      } while (!(paramObject instanceof Integer));
      i1 = paramInt;
    } while (((Integer)paramObject).intValue() != 21);
    return this.n[3];
  }
  
  @Nullable
  private RecentItemBaseBuilder b(int paramInt)
  {
    RecentItemBaseBuilder localRecentItemBaseBuilder = null;
    Object localObject = localRecentItemBaseBuilder;
    if (paramInt > 0)
    {
      localObject = localRecentItemBaseBuilder;
      if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder.length)
      {
        localRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[paramInt];
        localObject = localRecentItemBaseBuilder;
        if (localRecentItemBaseBuilder == null) {
          switch (paramInt)
          {
          default: 
            localObject = localRecentItemBaseBuilder;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[paramInt] = localObject;
      return localObject;
      localObject = new RecentEfficientItemBuilder();
      continue;
      localObject = new MatchEmptyItemBuilder();
    }
  }
  
  private int c(Object paramObject, int paramInt)
  {
    int i1;
    if ((paramObject instanceof RecentItemConfessMsg)) {
      i1 = this.n[1];
    }
    do
    {
      do
      {
        return i1;
        if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 16)) {
          return this.n[2];
        }
        i1 = paramInt;
      } while (!(paramObject instanceof Integer));
      i1 = paramInt;
    } while (((Integer)paramObject).intValue() != 17);
    return this.n[3];
  }
  
  @Nullable
  private RecentItemBaseBuilder c(int paramInt)
  {
    RecentItemBaseBuilder localRecentItemBaseBuilder = null;
    Object localObject = localRecentItemBaseBuilder;
    if (paramInt > 0)
    {
      localObject = localRecentItemBaseBuilder;
      if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder.length)
      {
        localRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[paramInt];
        localObject = localRecentItemBaseBuilder;
        if (localRecentItemBaseBuilder == null) {
          switch (paramInt)
          {
          default: 
            localObject = localRecentItemBaseBuilder;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[paramInt] = localObject;
      return localObject;
      localObject = new RecentConfessItemBuilder();
      continue;
      localObject = new ConfessItemBuilder();
    }
  }
  
  private int d(Object paramObject, int paramInt)
  {
    int i1;
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 13) {
        i1 = this.n[2];
      }
    }
    do
    {
      do
      {
        return i1;
        i1 = paramInt;
      } while (paramObject.intValue() != 4);
      return this.n[1];
      i1 = paramInt;
    } while (!(paramObject instanceof RecentHotchatItem));
    switch (((RecentHotchatItem)paramObject).mType)
    {
    default: 
      return paramInt;
    case 1: 
      return this.n[3];
    case 4: 
      return this.n[4];
    case 2: 
      return this.n[2];
    }
    return this.n[1];
  }
  
  @Nullable
  private RecentItemBaseBuilder d(int paramInt)
  {
    RecentItemBaseBuilder localRecentItemBaseBuilder = null;
    Object localObject = localRecentItemBaseBuilder;
    if (paramInt > 0)
    {
      localObject = localRecentItemBaseBuilder;
      if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder.length)
      {
        localRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[paramInt];
        localObject = localRecentItemBaseBuilder;
        if (localRecentItemBaseBuilder == null) {
          switch (paramInt)
          {
          default: 
            localObject = localRecentItemBaseBuilder;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[paramInt] = localObject;
      return localObject;
      localObject = new RecentDefaultItemBuilder();
      continue;
      localObject = new TroopAssistantEmptyItemBuilder();
      continue;
      localObject = new HotChatCenterItemBuilder();
      continue;
      localObject = new HotChatCenterDividerItemBuilder();
    }
  }
  
  private int e(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof String)) {
      paramInt = this.n[0];
    }
    while (!(paramObject instanceof RecentSayHelloListItem)) {
      return paramInt;
    }
    return this.n[1];
  }
  
  private RecentItemBaseBuilder e(int paramInt)
  {
    RecentItemBaseBuilder localRecentItemBaseBuilder = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new SayHelloListItemBuilder();
      }
      localRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    return localRecentItemBaseBuilder;
  }
  
  private int f(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof String)) {
      paramInt = this.n[0];
    }
    do
    {
      return paramInt;
      if ((paramObject instanceof RecentSayHelloBoxItem)) {
        return this.n[2];
      }
      if ((paramObject instanceof RecentItemNearbyLiveTipData)) {
        return this.n[3];
      }
    } while (!(paramObject instanceof RecentMsgBoxItem));
    return this.n[1];
  }
  
  private RecentItemBaseBuilder f(int paramInt)
  {
    RecentItemBaseBuilder localRecentItemBaseBuilder = null;
    if (paramInt == 2)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new SayHelloBoxItemBuilder();
      }
      localRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
    }
    do
    {
      return localRecentItemBaseBuilder;
      if (paramInt == 1)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new RecentDefaultItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
      }
    } while (paramInt != 3);
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] = new RecentLiveTipItemBuilder();
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3];
  }
  
  private int g(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer)) {
      paramInt = this.n[1];
    }
    while (!(paramObject instanceof RecentBaseData)) {
      return paramInt;
    }
    return this.n[2];
  }
  
  private RecentItemBaseBuilder g(int paramInt)
  {
    RecentItemBaseBuilder localRecentItemBaseBuilder = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new RecentBlankItemBuilder();
      }
      localRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    while (paramInt != 2) {
      return localRecentItemBaseBuilder;
    }
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
  }
  
  private int h(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 11) {
        paramInt = this.n[1];
      }
    }
    while (!(paramObject instanceof RecentBaseData))
    {
      do
      {
        return paramInt;
      } while (paramObject.intValue() != 12);
      return this.n[1];
    }
    return this.n[2];
  }
  
  private RecentItemBaseBuilder h(int paramInt)
  {
    RecentItemBaseBuilder localRecentItemBaseBuilder = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new TroopAssistantEmptyItemBuilder();
      }
      localRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    while (paramInt != 2) {
      return localRecentItemBaseBuilder;
    }
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
  }
  
  private int i(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 18) {
        paramInt = this.n[1];
      }
    }
    while (!(paramObject instanceof RecentBaseData))
    {
      do
      {
        return paramInt;
      } while (paramObject.intValue() != 19);
      return this.n[1];
    }
    return this.n[2];
  }
  
  private RecentItemBaseBuilder i(int paramInt)
  {
    RecentItemBaseBuilder localRecentItemBaseBuilder = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new TroopAssistantEmptyItemBuilder();
      }
      localRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    while (paramInt != 2) {
      return localRecentItemBaseBuilder;
    }
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
  }
  
  private int j(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 3) {
        paramInt = this.n[3];
      }
    }
    while (!(paramObject instanceof RecentBaseData))
    {
      do
      {
        return paramInt;
        if (paramObject.intValue() == 4) {
          return this.n[1];
        }
      } while (paramObject.intValue() != 5);
      return this.n[1];
    }
    return this.n[2];
  }
  
  private RecentItemBaseBuilder j(int paramInt)
  {
    RecentItemBaseBuilder localRecentItemBaseBuilder = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new TroopAssistantEmptyItemBuilder();
      }
      localRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    do
    {
      return localRecentItemBaseBuilder;
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
      }
    } while (paramInt != 3);
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] = new TroopAssistantEducationBuilder();
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3];
  }
  
  private int k(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RecentBaseData)) {
      paramInt = this.n[1];
    }
    return paramInt;
  }
  
  private RecentItemBaseBuilder k(int paramInt)
  {
    RecentItemBaseBuilder localRecentItemBaseBuilder = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new RecentC2CItemBuilder();
      }
      localRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    return localRecentItemBaseBuilder;
  }
  
  private int l(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer)) {
      if (((Integer)paramObject).intValue() == 0) {
        paramInt = this.n[1];
      }
    }
    do
    {
      return paramInt;
      if ((paramObject instanceof RecentUserBaseData))
      {
        if ((paramObject instanceof RecentItemPublicAccountADFolderData)) {
          return this.n[3];
        }
        if ((paramObject instanceof RecentItemImaxADData)) {
          return this.n[4];
        }
        if ((paramObject instanceof RecentItemChatMsgData)) {
          return this.n[5];
        }
        if ((paramObject instanceof RecentItemMayKnowFriendData)) {
          return this.n[6];
        }
        if ((paramObject instanceof RecentItemMayKnowFriendVerticalListData)) {
          return this.n[7];
        }
        if ((paramObject instanceof RecentItemAppletsFolderData)) {
          return this.n[8];
        }
        if ((paramObject instanceof RecentItemContactsGuideData)) {
          return this.n[9];
        }
        if ((paramObject instanceof RecentItemRecommendTroopData)) {
          return this.n[10];
        }
        return this.n[2];
      }
    } while (!(paramObject instanceof String));
    return this.n[0];
  }
  
  private RecentItemBaseBuilder l(int paramInt)
  {
    RecentItemBaseBuilder localRecentItemBaseBuilder = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new RecentEmptyItemBuilder();
      }
      localRecentItemBaseBuilder = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
    }
    do
    {
      return localRecentItemBaseBuilder;
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentEfficientItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
      }
      if (paramInt == 3)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] = new RecentPublicAccountAdItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3];
      }
      if (paramInt == 4)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[4] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[4] = new RecentImaxAdItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[4];
      }
      if (paramInt == 5)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[5] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[5] = new RecentC2CItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[5];
      }
      if (paramInt == 6)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6] = new RecentMayKnowFriendItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6];
      }
      if (paramInt == 7)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[7] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[7] = new RecentMayKnowFriendVerticalListItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[7];
      }
      if (paramInt == 8)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[8] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[8] = new RecentAppletsItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[8];
      }
      if (paramInt == 9)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[9] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[9] = new RecentContactsGuideItemBuilder();
        }
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[9];
      }
    } while (paramInt != 10);
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[10] == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[10] = new RecentRecommendTroopItemBuilder();
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[10];
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(Object paramObject)
  {
    int i1 = this.n[0];
    switch (this.jdField_a_of_type_Int)
    {
    case 2: 
    case 3: 
    case 4: 
    case 8: 
    default: 
      return i1;
    case 0: 
      return l(paramObject, i1);
    case 1: 
      return j(paramObject, i1);
    case 12: 
      return i(paramObject, i1);
    case 9: 
      return h(paramObject, i1);
    case 5: 
      return g(paramObject, i1);
    case 6: 
      return f(paramObject, i1);
    case 7: 
      return e(paramObject, i1);
    case 10: 
      return d(paramObject, i1);
    case 11: 
      return c(paramObject, i1);
    case 13: 
      return b(paramObject, i1);
    case 14: 
      return k(paramObject, i1);
    }
    return a(paramObject, i1);
  }
  
  public RecentItemBaseBuilder a(Object paramObject)
  {
    Object localObject = null;
    int i1 = a(paramObject);
    paramObject = localObject;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      paramObject = localObject;
    }
    for (;;)
    {
      localObject = paramObject;
      if (paramObject == null)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[0] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[0] = new RecentBlankItemBuilder();
        }
        localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[0];
      }
      ((RecentItemBaseBuilder)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      return localObject;
      paramObject = l(i1);
      continue;
      paramObject = j(i1);
      continue;
      paramObject = i(i1);
      continue;
      paramObject = h(i1);
      continue;
      paramObject = g(i1);
      continue;
      paramObject = f(i1);
      continue;
      paramObject = e(i1);
      continue;
      paramObject = d(i1);
      continue;
      paramObject = c(i1);
      continue;
      paramObject = b(i1);
      continue;
      paramObject = k(i1);
      continue;
      paramObject = a(i1);
    }
  }
  
  public void a(RecentAdapter paramRecentAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = paramRecentAdapter;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder.length > 6) && ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6] instanceof RecentMayKnowFriendItemBuilder)))
    {
      ((RecentMayKnowFriendItemBuilder)this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6]).a();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6] = null;
    }
  }
  
  public int b()
  {
    return this.n.length;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder.length > 6) && ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6] instanceof RecentMayKnowFriendItemBuilder)))
    {
      ((RecentMayKnowFriendItemBuilder)this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6]).a();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[6] = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */