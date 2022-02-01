package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectMutexManager;
import com.tencent.qphone.base.util.QLog;

public class VirtualBgMng
  extends EffectPendantBase
{
  public static final String[] b = { "params.dat" };
  
  public VirtualBgMng(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.c = b;
  }
  
  public int a()
  {
    return 623;
  }
  
  public EffectPendantBase.Pendant a(int paramInt1, int paramInt2)
  {
    return super.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MuteByOthers, fromMuteKey[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], data[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
    if (paramInt == b()) {
      return;
    }
    a(0L, null);
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt != 2) && (paramInt != 3)) {
      return;
    }
    paramString1 = (PendantItem)a();
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.getId()))) {
      a(paramLong, null);
    }
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    if ((bool) && (paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())) && (!TextUtils.equals("0", paramPendantItem.getId())))
    {
      EffectMutexManager localEffectMutexManager = (EffectMutexManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
      if (localEffectMutexManager != null) {
        localEffectMutexManager.a(3005, paramPendantItem.getId());
      }
    }
    return bool;
  }
  
  public int b()
  {
    return 3005;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.VirtualBgMng
 * JD-Core Version:    0.7.0.1
 */