package com.tencent.mobileqq.activity.recent.msg;

import android.util.SparseArray;
import com.tencent.mobileqq.data.entitymanager.Provider;

public class RecentUserMsgFactory
{
  private static RecentUserMsgFactory jdField_a_of_type_ComTencentMobileqqActivityRecentMsgRecentUserMsgFactory;
  private Provider<SparseArray<MsgDeserialize>> jdField_a_of_type_ComTencentMobileqqDataEntitymanagerProvider;
  private Provider<SparseArray<MsgSerialize>> b;
  private Provider<SparseArray<Provider<RecentMsgProxy>>> c;
  private Provider<MsgSerialize> d;
  
  private RecentUserMsgFactory(RecentUserMsgFactory.Builder paramBuilder)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataEntitymanagerProvider = RecentUserMsgFactory.Builder.a(paramBuilder);
    this.b = RecentUserMsgFactory.Builder.b(paramBuilder);
    this.c = RecentUserMsgFactory.Builder.c(paramBuilder);
    this.d = RecentUserMsgFactory.Builder.d(paramBuilder);
  }
  
  private MsgSerialize a(int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = (MsgSerialize)((SparseArray)((Provider)localObject).get()).get(paramInt);
      if (localObject != null) {
        return localObject;
      }
    }
    localObject = this.d;
    if (localObject != null) {
      return (MsgSerialize)((Provider)localObject).get();
    }
    return null;
  }
  
  public static RecentUserMsgFactory a()
  {
    return jdField_a_of_type_ComTencentMobileqqActivityRecentMsgRecentUserMsgFactory;
  }
  
  public static void a(RecentUserMsgFactory paramRecentUserMsgFactory)
  {
    jdField_a_of_type_ComTencentMobileqqActivityRecentMsgRecentUserMsgFactory = paramRecentUserMsgFactory;
  }
  
  RecentMsgProxy a(int paramInt)
  {
    Provider localProvider = this.c;
    if (localProvider == null) {
      return null;
    }
    localProvider = (Provider)((SparseArray)localProvider.get()).get(paramInt);
    if (localProvider != null) {
      return (RecentMsgProxy)localProvider.get();
    }
    return null;
  }
  
  public Object a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return null;
      }
      localObject2 = a(paramInt);
      if (localObject2 != null)
      {
        ((RecentMsgProxy)localObject2).a(paramArrayOfByte);
        localObject1 = ((RecentMsgProxy)localObject2).a();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataEntitymanagerProvider;
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject3 = (MsgDeserialize)((SparseArray)((Provider)localObject3).get()).get(paramInt);
          localObject2 = localObject1;
          if (localObject3 != null) {
            localObject2 = ((MsgDeserialize)localObject3).a(paramArrayOfByte);
          }
        }
      }
    }
    return localObject2;
  }
  
  public byte[] a(int paramInt, Object paramObject)
  {
    byte[] arrayOfByte = null;
    if (paramObject == null) {
      return null;
    }
    MsgSerialize localMsgSerialize = a(paramInt);
    if (localMsgSerialize != null) {
      arrayOfByte = localMsgSerialize.a(paramObject);
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.RecentUserMsgFactory
 * JD-Core Version:    0.7.0.1
 */