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
    if (this.b != null)
    {
      MsgSerialize localMsgSerialize = (MsgSerialize)((SparseArray)this.b.get()).get(paramInt);
      if (localMsgSerialize != null) {
        return localMsgSerialize;
      }
    }
    if (this.d != null) {
      return (MsgSerialize)this.d.get();
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
    if (this.c == null) {
      return null;
    }
    Provider localProvider = (Provider)((SparseArray)this.c.get()).get(paramInt);
    if (localProvider != null) {
      return (RecentMsgProxy)localProvider.get();
    }
    return null;
  }
  
  public Object a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    Object localObject = a(paramInt);
    if (localObject != null) {
      ((RecentMsgProxy)localObject).a(paramArrayOfByte);
    }
    for (localObject = ((RecentMsgProxy)localObject).a();; localObject = null)
    {
      if ((localObject == null) && (this.jdField_a_of_type_ComTencentMobileqqDataEntitymanagerProvider != null))
      {
        MsgDeserialize localMsgDeserialize = (MsgDeserialize)((SparseArray)this.jdField_a_of_type_ComTencentMobileqqDataEntitymanagerProvider.get()).get(paramInt);
        if (localMsgDeserialize != null) {
          return localMsgDeserialize.a(paramArrayOfByte);
        }
      }
      return localObject;
    }
  }
  
  public byte[] a(int paramInt, Object paramObject)
  {
    if (paramObject == null) {}
    MsgSerialize localMsgSerialize;
    do
    {
      return null;
      localMsgSerialize = a(paramInt);
    } while (localMsgSerialize == null);
    return localMsgSerialize.a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.RecentUserMsgFactory
 * JD-Core Version:    0.7.0.1
 */