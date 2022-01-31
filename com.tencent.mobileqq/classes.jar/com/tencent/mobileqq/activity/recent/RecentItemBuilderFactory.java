package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.apollo.activity.RecentHotchatItem;
import com.tencent.mobileqq.confess.ConfessItemBuilder;

public class RecentItemBuilderFactory
{
  protected static final int[] a;
  protected static final int[] b = { 0, 1, 2, 3, 4 };
  protected static final int[] c = { 0, 1, 2, 3 };
  protected static final int[] d = { 0, 1 };
  protected static final int[] e = { 0, 1, 2, 3 };
  protected static final int[] f = { 0, 1, 2 };
  protected static final int[] g = { 0, 1, 2 };
  protected static final int[] h = { 0, 1, 2, 3, 4 };
  protected static final int[] i = { 0, 1, 2, 3 };
  protected int a;
  protected RecentAdapter a;
  protected RecentItemBaseBuilder[] a;
  protected int[] j;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0 };
  }
  
  public RecentItemBuilderFactory(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0) {
      this.j = b;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder = new RecentItemBaseBuilder[this.j.length];
      return;
      if (this.jdField_a_of_type_Int == 1) {
        this.j = e;
      } else if (this.jdField_a_of_type_Int == 5) {
        this.j = f;
      } else if (this.jdField_a_of_type_Int == 6) {
        this.j = c;
      } else if (this.jdField_a_of_type_Int == 7) {
        this.j = d;
      } else if (this.jdField_a_of_type_Int == 9) {
        this.j = g;
      } else if (this.jdField_a_of_type_Int == 10) {
        this.j = h;
      } else if (this.jdField_a_of_type_Int == 11) {
        this.j = i;
      } else {
        this.j = jdField_a_of_type_ArrayOfInt;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(Object paramObject)
  {
    int k = this.j[0];
    switch (this.jdField_a_of_type_Int)
    {
    case 2: 
    case 3: 
    case 4: 
    case 8: 
    default: 
      return k;
    case 0: 
      if ((paramObject instanceof Integer))
      {
        if (((Integer)paramObject).intValue() != 0) {
          break label580;
        }
        k = this.j[1];
      }
      break;
    }
    label580:
    for (;;)
    {
      return k;
      if ((paramObject instanceof RecentUserBaseData))
      {
        if ((paramObject instanceof RecentItemPublicAccountADFolderData)) {
          return this.j[3];
        }
        if ((paramObject instanceof RecentItemImaxADData)) {
          return this.j[4];
        }
        return this.j[2];
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      return this.j[0];
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        if (paramObject.intValue() == 3) {
          return this.j[3];
        }
        if (paramObject.intValue() == 4) {
          return this.j[1];
        }
        if (paramObject.intValue() != 5) {
          break;
        }
        return this.j[1];
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break;
      }
      return this.j[2];
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        if (paramObject.intValue() == 11) {
          return this.j[1];
        }
        if (paramObject.intValue() != 12) {
          break;
        }
        return this.j[1];
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break;
      }
      return this.j[2];
      if ((paramObject instanceof Integer)) {
        return this.j[1];
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break;
      }
      return this.j[2];
      if ((paramObject instanceof String)) {
        return this.j[0];
      }
      if ((paramObject instanceof RecentSayHelloBoxItem)) {
        return this.j[2];
      }
      if ((paramObject instanceof RecentItemNearbyLiveTipData)) {
        return this.j[3];
      }
      if (!(paramObject instanceof RecentMsgBoxItem)) {
        break;
      }
      return this.j[1];
      if ((paramObject instanceof String)) {
        return this.j[0];
      }
      if (!(paramObject instanceof RecentSayHelloListItem)) {
        break;
      }
      return this.j[1];
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        if (paramObject.intValue() == 13) {
          return this.j[2];
        }
        if (paramObject.intValue() != 4) {
          break;
        }
        return this.j[1];
      }
      if (!(paramObject instanceof RecentHotchatItem)) {
        break;
      }
      switch (((RecentHotchatItem)paramObject).j)
      {
      default: 
        return k;
      case 1: 
        return this.j[3];
      case 4: 
        return this.j[4];
      case 2: 
        return this.j[2];
      }
      return this.j[1];
      if ((paramObject instanceof RecentItemConfessMsg)) {
        return this.j[1];
      }
      if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 16)) {
        return this.j[2];
      }
      if ((!(paramObject instanceof Integer)) || (((Integer)paramObject).intValue() != 17)) {
        break;
      }
      return this.j[3];
    }
  }
  
  public RecentItemBaseBuilder a(Object paramObject)
  {
    Object localObject = null;
    int k = a(paramObject);
    if (this.jdField_a_of_type_Int == 0) {
      if (k == 1)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new RecentEmptyItemBuilder();
        }
        paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
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
                    if (k == 2)
                    {
                      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
                        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentEfficientItemBuilder();
                      }
                      paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
                    }
                    else if (k == 3)
                    {
                      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] == null) {
                        this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] = new RecentPublicAccountAdItemBuilder();
                      }
                      paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3];
                    }
                    else
                    {
                      paramObject = localObject;
                      if (k == 4)
                      {
                        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[4] == null) {
                          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[4] = new RecentImaxAdItemBuilder();
                        }
                        paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[4];
                        continue;
                        if (this.jdField_a_of_type_Int == 1)
                        {
                          if (k == 1)
                          {
                            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
                              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new TroopAssistantEmptyItemBuilder();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
                          }
                          else if (k == 2)
                          {
                            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
                              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
                          }
                          else
                          {
                            paramObject = localObject;
                            if (k == 3)
                            {
                              if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] == null) {
                                this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] = new TroopAssistantEducationBuilder();
                              }
                              paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3];
                            }
                          }
                        }
                        else if (this.jdField_a_of_type_Int == 9)
                        {
                          if (k == 1)
                          {
                            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
                              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new TroopAssistantEmptyItemBuilder();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
                          }
                          else
                          {
                            paramObject = localObject;
                            if (k == 2)
                            {
                              if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
                                this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
                              }
                              paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
                            }
                          }
                        }
                        else if (this.jdField_a_of_type_Int == 5)
                        {
                          if (k == 1)
                          {
                            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
                              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new RecentBlankItemBuilder();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
                          }
                          else
                          {
                            paramObject = localObject;
                            if (k == 2)
                            {
                              if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
                                this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new RecentDefaultItemBuilder();
                              }
                              paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
                            }
                          }
                        }
                        else if (this.jdField_a_of_type_Int == 6)
                        {
                          if (k == 2)
                          {
                            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] == null) {
                              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2] = new SayHelloBoxItemBuilder();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[2];
                          }
                          else if (k == 1)
                          {
                            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
                              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new RecentDefaultItemBuilder();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
                          }
                          else
                          {
                            paramObject = localObject;
                            if (k == 3)
                            {
                              if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] == null) {
                                this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3] = new RecentLiveTipItemBuilder();
                              }
                              paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[3];
                            }
                          }
                        }
                        else
                        {
                          if (this.jdField_a_of_type_Int != 7) {
                            break;
                          }
                          paramObject = localObject;
                          if (k == 1)
                          {
                            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] == null) {
                              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1] = new SayHelloListItemBuilder();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[1];
                          }
                        }
                      }
                    }
                  }
                  if (this.jdField_a_of_type_Int != 10) {
                    break;
                  }
                  paramObject = localObject;
                } while (k <= 0);
                paramObject = localObject;
              } while (k >= this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder.length);
              localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[k];
              paramObject = localObject;
            } while (localObject != null);
            switch (k)
            {
            default: 
              paramObject = localObject;
            }
            for (;;)
            {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[k] = paramObject;
              break;
              paramObject = new RecentDefaultItemBuilder();
              continue;
              paramObject = new TroopAssistantEmptyItemBuilder();
              continue;
              paramObject = new HotChatCenterItemBuilder();
              continue;
              paramObject = new HotChatCenterDividerItemBuilder();
            }
            paramObject = localObject;
          } while (this.jdField_a_of_type_Int != 11);
          paramObject = localObject;
        } while (k <= 0);
        paramObject = localObject;
      } while (k >= this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder.length);
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[k];
      paramObject = localObject;
    } while (localObject != null);
    switch (k)
    {
    default: 
      paramObject = localObject;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentRecentItemBaseBuilder[k] = paramObject;
      break;
      paramObject = new RecentEfficientItemBuilder();
      continue;
      paramObject = new ConfessItemBuilder();
    }
  }
  
  public void a(RecentAdapter paramRecentAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = paramRecentAdapter;
  }
  
  public int b()
  {
    return this.j.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */