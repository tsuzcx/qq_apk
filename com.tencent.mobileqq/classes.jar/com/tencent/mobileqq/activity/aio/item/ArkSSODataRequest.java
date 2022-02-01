package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppSSO;
import java.lang.ref.WeakReference;

class ArkSSODataRequest
  extends ArkDataRequest
{
  private static int d = 0;
  private WeakReference<QQAppInterface> a;
  private int c;
  protected String c;
  
  ArkSSODataRequest(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  private void b(int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(this);
    ArkAppCenter.a().post(this.jdField_c_of_type_JavaLangString, new ArkSSODataRequest.2(this, localWeakReference, paramInt));
  }
  
  protected String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.length() < 6) || (!paramString.substring(0, 6).equalsIgnoreCase("sso://"))) {
      return null;
    }
    int i = paramString.indexOf('/', 6);
    if (i == -1) {
      return paramString.substring(6);
    }
    return paramString.substring(6, i);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = null;
    a(null);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 != this.jdField_c_of_type_Int) {
      ArkAppCenter.c("ArkApp.SSODataRequest", String.format("# onComplete, req canceled, cookie=%d-%d, ret=%d, rsp=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(paramInt2), paramString }));
    }
    do
    {
      return;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_c_of_type_Int = 0;
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest$IDataRequestCallback;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest$IDataRequestCallback = null;
    } while (paramString == null);
    paramString.a();
  }
  
  public boolean a(String paramString)
  {
    if (!super.a(paramString))
    {
      ArkAppCenter.c("ArkApp.SSODataRequest", String.format("# fail to open, url=%s", new Object[] { paramString }));
      return false;
    }
    return true;
  }
  
  protected boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      ArkAppCenter.c("ArkApp.SSODataRequest", String.format("# fail to send, app is null, url=%s, req=%s", new Object[] { this.jdField_a_of_type_JavaLangString, paramString2 }));
      return false;
    }
    localObject = ((ArkAppCenter)((QQAppInterface)localObject).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER)).a();
    WeakReference localWeakReference = new WeakReference(this);
    return ((ArkAppSSO)localObject).a(paramString1, paramString2, this.jdField_a_of_type_Int, paramInt2, new ArkSSODataRequest.1(this, localWeakReference));
  }
  
  public boolean b(String paramString)
  {
    boolean bool = true;
    if ((this.jdField_c_of_type_Int != 0) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      ArkAppCenter.c("ArkApp.SSODataRequest", String.format("# fail to send, cookie=%d, url=%s, req=%s", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), this.jdField_a_of_type_JavaLangString, paramString }));
      bool = false;
    }
    int i;
    String str;
    do
    {
      return bool;
      i = d + 1;
      d = i;
      this.jdField_c_of_type_Int = i;
      str = a(this.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(str))
      {
        ArkAppCenter.c("ArkApp.SSODataRequest", String.format("# fail to send, cmd is empty, cookie=%d, url=%s, reqData=%s", new Object[] { Integer.valueOf(i), this.jdField_a_of_type_JavaLangString, paramString }));
        b(i);
        return true;
      }
    } while (a(str, paramString, this.jdField_a_of_type_Int, i));
    ArkAppCenter.c("ArkApp.SSODataRequest", String.format("# fail to send, sso.sendAppMsg fail, cookie=%d, url=%s, reqData=%s", new Object[] { Integer.valueOf(i), this.jdField_a_of_type_JavaLangString, paramString }));
    b(i);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkSSODataRequest
 * JD-Core Version:    0.7.0.1
 */