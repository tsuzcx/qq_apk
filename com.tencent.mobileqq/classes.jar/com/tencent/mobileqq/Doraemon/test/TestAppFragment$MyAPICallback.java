package com.tencent.mobileqq.Doraemon.test;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

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
    if (this.a == null) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramString, bool);
      return;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    QLog.d("DoraemonOpenAPI.test", 2, paramString);
    if (this.a != null) {
      this.a.append(paramString);
    }
    if (paramBoolean) {
      QQToast.a(BaseApplicationImpl.getApplication(), paramString, 0).a();
    }
  }
  
  public void a()
  {
    a("onComplete\n");
  }
  
  public void a(int paramInt)
  {
    a("onPermission " + paramInt + "\n", true);
  }
  
  public void a(int paramInt, String paramString)
  {
    a("onFailure code=" + paramInt + " msg=" + paramString + "\n");
  }
  
  public void a(JSONObject paramJSONObject)
  {
    a("onSuccess " + paramJSONObject + "\n", true);
    if (this.a != null) {
      new AlertDialog.Builder(this.a.getContext()).setTitle("onSuccess").setMessage(paramJSONObject.toString()).setNegativeButton(HardCodeUtil.a(2131714725), null).create().show();
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    a("onTrigger\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment.MyAPICallback
 * JD-Core Version:    0.7.0.1
 */