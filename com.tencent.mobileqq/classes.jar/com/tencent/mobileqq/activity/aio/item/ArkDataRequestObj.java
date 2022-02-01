package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.ark.ark.RuntimeClassCallbackWrapper;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class ArkDataRequestObj
  implements ark.RuntimeClassCallbackWrapper, ArkDataRequest.IDataRequestCallback
{
  private ark.VariantWrapper jdField_a_of_type_ComTencentArkArk$VariantWrapper;
  private ArkDataRequest jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ArkDataRequestObj(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  private void a(ark.VariantWrapper paramVariantWrapper)
  {
    ark.VariantWrapper localVariantWrapper = this.jdField_a_of_type_ComTencentArkArk$VariantWrapper;
    if (localVariantWrapper != null)
    {
      localVariantWrapper.Reset();
      this.jdField_a_of_type_ComTencentArkArk$VariantWrapper = null;
    }
    if (paramVariantWrapper != null) {
      this.jdField_a_of_type_ComTencentArkArk$VariantWrapper = paramVariantWrapper.Copy();
    }
  }
  
  private void b()
  {
    ArkDataRequest localArkDataRequest = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest;
    if (localArkDataRequest != null)
    {
      localArkDataRequest.a(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest = null;
    }
  }
  
  public boolean Destruct()
  {
    b();
    a(null);
    return true;
  }
  
  public boolean HasMethod(String paramString)
  {
    return (paramString.equals("Open")) || (paramString.equals("Abort")) || (paramString.equals("AttachEvent")) || (paramString.equals("DetachEvent")) || (paramString.equals("Send")) || (paramString.equals("SetTimeout")) || (paramString.equals("IsSuccess")) || (paramString.equals("GetData"));
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramString.equals("Open")) {
      return a(paramArrayOfVariantWrapper, paramVariantWrapper);
    }
    if (paramString.equals("Abort")) {
      return b(paramArrayOfVariantWrapper, paramVariantWrapper);
    }
    if (paramString.equals("AttachEvent")) {
      return c(paramArrayOfVariantWrapper, paramVariantWrapper);
    }
    if (paramString.equals("DetachEvent")) {
      return d(paramArrayOfVariantWrapper, paramVariantWrapper);
    }
    if (paramString.equals("Send")) {
      return e(paramArrayOfVariantWrapper, paramVariantWrapper);
    }
    if (paramString.equals("SetTimeout")) {
      return f(paramArrayOfVariantWrapper, paramVariantWrapper);
    }
    if (paramString.equals("IsSuccess")) {
      return g(paramArrayOfVariantWrapper, paramVariantWrapper);
    }
    if (paramString.equals("GetData")) {
      return h(paramArrayOfVariantWrapper, paramVariantWrapper);
    }
    return false;
  }
  
  public boolean IsModule()
  {
    return false;
  }
  
  protected String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramString.indexOf("://");
    if (i < 0) {
      return null;
    }
    return paramString.substring(0, i);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper = this.jdField_a_of_type_ComTencentArkArk$VariantWrapper;
    if (localVariantWrapper != null)
    {
      if (!localVariantWrapper.IsFunction()) {
        return;
      }
      this.jdField_a_of_type_ComTencentArkArk$VariantWrapper.InvokeDefault(null, null);
    }
  }
  
  protected boolean a(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    b();
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2))
    {
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1].GetString();
      if (!TextUtils.isEmpty(paramArrayOfVariantWrapper))
      {
        Object localObject = a(paramArrayOfVariantWrapper);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase("sso")))
        {
          localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest = new ArkSSODataRequest((AppRuntime)localObject, this.jdField_a_of_type_JavaLangString);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest = new ArkIPCSSODataRequest(this.jdField_a_of_type_JavaLangString);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest.a(paramArrayOfVariantWrapper))
          {
            paramVariantWrapper.SetBool(true);
            return true;
          }
        }
      }
    }
    paramVariantWrapper.SetBool(false);
    return true;
  }
  
  protected boolean b(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    b();
    paramVariantWrapper.SetBool(true);
    return true;
  }
  
  protected boolean c(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 3))
    {
      String str = paramArrayOfVariantWrapper[1].GetString();
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[2];
      if ((!TextUtils.isEmpty(str)) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.IsFunction()) && (str.equals("OnComplete")))
      {
        a(paramArrayOfVariantWrapper);
        paramVariantWrapper.SetBool(true);
        return true;
      }
    }
    paramVariantWrapper.SetBool(false);
    return true;
  }
  
  protected boolean d(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2))
    {
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1].GetString();
      if ((!TextUtils.isEmpty(paramArrayOfVariantWrapper)) && (paramArrayOfVariantWrapper.equals("OnComplete")))
      {
        a(null);
        paramVariantWrapper.SetBool(true);
        return true;
      }
    }
    paramVariantWrapper.SetBool(false);
    return true;
  }
  
  protected boolean e(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest != null) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2))
    {
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1];
      if (paramArrayOfVariantWrapper != null)
      {
        if (paramArrayOfVariantWrapper.GetType() == 1)
        {
          paramArrayOfVariantWrapper = null;
        }
        else if (paramArrayOfVariantWrapper.GetType() == 5)
        {
          paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.GetString();
        }
        else
        {
          if ((!paramArrayOfVariantWrapper.IsArray()) && (!paramArrayOfVariantWrapper.IsTable())) {
            break label106;
          }
          paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.GetTableAsJsonString();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest.a(this);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest.b(paramArrayOfVariantWrapper))
        {
          paramVariantWrapper.SetBool(true);
          return true;
        }
      }
    }
    label106:
    paramVariantWrapper.SetBool(false);
    return true;
  }
  
  protected boolean f(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest != null) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2))
    {
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1];
      if (paramArrayOfVariantWrapper == null) {}
      do
      {
        i = 0;
        break;
        if (paramArrayOfVariantWrapper.GetType() == 3)
        {
          i = paramArrayOfVariantWrapper.GetInt();
          break;
        }
      } while (paramArrayOfVariantWrapper.GetType() != 4);
      int i = (int)paramArrayOfVariantWrapper.GetDouble();
      int j = i;
      if (i < 0) {
        j = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest.a(j);
      paramVariantWrapper.SetBool(true);
      return true;
    }
    paramVariantWrapper.SetBool(false);
    return true;
  }
  
  protected boolean g(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    ArkDataRequest localArkDataRequest = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest;
    boolean bool = false;
    if ((localArkDataRequest != null) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
    {
      if (localArkDataRequest.a() == 0) {
        bool = true;
      }
      paramVariantWrapper.SetBool(bool);
      return true;
    }
    paramVariantWrapper.SetBool(false);
    return true;
  }
  
  protected boolean h(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest;
    if ((localObject != null) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (((ArkDataRequest)localObject).a() == 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkDataRequest.a();
      if (localObject != null)
      {
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1].GetString();
        if (!TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
          if (paramArrayOfVariantWrapper.equals("text"))
          {
            paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject;
            if (localObject == null) {
              paramArrayOfVariantWrapper = "";
            }
            if (paramVariantWrapper.SetString(paramArrayOfVariantWrapper)) {
              return true;
            }
          }
          else if ((paramArrayOfVariantWrapper.equals("json")) && (paramVariantWrapper.SetTableAsJsonString((String)localObject)))
          {
            return true;
          }
        }
      }
    }
    paramVariantWrapper.SetNull();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkDataRequestObj
 * JD-Core Version:    0.7.0.1
 */