package com.tencent.mobileqq.apollo.aio.item;

import com.tencent.mobileqq.apollo.aio.item.api.IApolloMessageTypeSupplier;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ApolloMessageTypeSupplierApi
{
  public static IApolloMessageTypeSupplier a()
  {
    try
    {
      IApolloMessageTypeSupplier localIApolloMessageTypeSupplier = (IApolloMessageTypeSupplier)QRoute.api(IApolloMessageTypeSupplier.class);
      return localIApolloMessageTypeSupplier;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloMessageTypeSupplier", 1, "[createApolloMessageTypeSupplier]", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloMessageTypeSupplierApi
 * JD-Core Version:    0.7.0.1
 */