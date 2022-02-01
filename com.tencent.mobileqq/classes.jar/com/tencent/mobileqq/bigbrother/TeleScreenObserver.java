package com.tencent.mobileqq.bigbrother;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import mqq.observer.BusinessObserver;

public class TeleScreenObserver
  implements BusinessObserver
{
  private static TeleScreenObserver jdField_a_of_type_ComTencentMobileqqBigbrotherTeleScreenObserver;
  private int jdField_a_of_type_Int;
  private final SparseArray<TeleScreenListenerWrapper> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public static TeleScreenObserver a()
  {
    if (jdField_a_of_type_ComTencentMobileqqBigbrotherTeleScreenObserver == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqBigbrotherTeleScreenObserver == null) {
        jdField_a_of_type_ComTencentMobileqqBigbrotherTeleScreenObserver = new TeleScreenObserver();
      }
      return jdField_a_of_type_ComTencentMobileqqBigbrotherTeleScreenObserver;
    }
    finally {}
  }
  
  public int a(Context paramContext, DownloadListener paramDownloadListener)
  {
    return a(new TeleScreenListenerWrapper(paramContext, paramDownloadListener));
  }
  
  public int a(Context paramContext, JumpListener paramJumpListener)
  {
    return a(new TeleScreenListenerWrapper(paramContext, paramJumpListener));
  }
  
  public int a(TeleScreenListenerWrapper paramTeleScreenListenerWrapper)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      SparseArray localSparseArray2 = this.jdField_a_of_type_AndroidUtilSparseArray;
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localSparseArray2.append(i, paramTeleScreenListenerWrapper);
      i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramBundle.getInt("req_id");
    TeleScreenListenerWrapper localTeleScreenListenerWrapper = (TeleScreenListenerWrapper)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
      return;
      localTeleScreenListenerWrapper.b(paramBoolean, paramBundle.getBoolean("allow_download", true), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"), paramBundle.getString("jump_url"));
      continue;
      localTeleScreenListenerWrapper.b(paramBoolean, paramBundle.getInt("jump", 0), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.TeleScreenObserver
 * JD-Core Version:    0.7.0.1
 */