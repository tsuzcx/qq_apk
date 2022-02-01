package com.immersion.stickersampleapp;

import android.text.TextUtils;
import com.immersion.touchsensesdk.AsyncConnectionProxy;
import com.immersion.touchsensesdk.IConnection;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ImmerIConnectionProxy
  extends AsyncConnectionProxy
{
  private WeakReference<QQAppInterface> a;
  
  public ImmerIConnectionProxy()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      this.a = new WeakReference((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    }
  }
  
  public void connect(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ImmersionHandler localImmersionHandler = (ImmersionHandler)((QQAppInterface)this.a.get()).getBusinessHandler(BusinessHandlerFactory.IMMERSION_HANDLER);
    localImmersionHandler.a(this);
    localImmersionHandler.a(paramString);
  }
  
  public void setConnection(IConnection paramIConnection)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HapticMediaPlayer connection == NULL -->");
      boolean bool;
      if (paramIConnection == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.i("ImmerIConnectionProxy", 2, localStringBuilder.toString());
    }
    super.setConnection(paramIConnection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.immersion.stickersampleapp.ImmerIConnectionProxy
 * JD-Core Version:    0.7.0.1
 */