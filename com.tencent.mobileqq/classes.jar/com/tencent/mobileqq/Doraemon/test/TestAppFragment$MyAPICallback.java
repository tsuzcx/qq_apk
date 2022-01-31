package com.tencent.mobileqq.Doraemon.test;

import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class TestAppFragment$MyAPICallback
  implements APICallback
{
  EditText a;
  
  public TestAppFragment$MyAPICallback() {}
  
  public TestAppFragment$MyAPICallback(EditText paramEditText)
  {
    this.a = paramEditText;
  }
  
  private void a(String paramString)
  {
    QLog.d("DoraemonOpenAPI.test", 2, paramString);
    if (this.a != null) {
      this.a.append(paramString);
    }
    QQToast.a(BaseApplicationImpl.getApplication(), paramString, 0).a();
  }
  
  public void a()
  {
    a("onComplete\n");
  }
  
  public void a(int paramInt)
  {
    a("onPermission " + paramInt + "\n");
  }
  
  public void a(int paramInt, String paramString)
  {
    a("onFailure code=" + paramInt + " msg=" + paramString + "\n");
  }
  
  public void a(APIParam paramAPIParam)
  {
    a("onSuccess " + paramAPIParam + "\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment.MyAPICallback
 * JD-Core Version:    0.7.0.1
 */