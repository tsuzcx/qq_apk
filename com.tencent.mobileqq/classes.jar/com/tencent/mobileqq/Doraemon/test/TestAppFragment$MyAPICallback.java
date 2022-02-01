package com.tencent.mobileqq.Doraemon.test;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.widget.EditText;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TestAppFragment$MyAPICallback
  implements APICallback
{
  EditText c;
  
  public TestAppFragment$MyAPICallback() {}
  
  public TestAppFragment$MyAPICallback(EditText paramEditText)
  {
    this.c = paramEditText;
  }
  
  private void a(String paramString)
  {
    boolean bool;
    if (this.c == null) {
      bool = true;
    } else {
      bool = false;
    }
    a(paramString, bool);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    QLog.d("DoraemonOpenAPI.test", 2, paramString);
    EditText localEditText = this.c;
    if (localEditText != null) {
      localEditText.append(paramString);
    }
    if (paramBoolean) {
      QQToast.makeText(BaseApplication.getContext(), paramString, 0).show();
    }
  }
  
  public void a()
  {
    a("onComplete\n");
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPermission ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("\n");
    a(localStringBuilder.toString(), true);
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFailure code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg=");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\n");
    a(localStringBuilder.toString());
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSuccess ");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append("\n");
    a(((StringBuilder)localObject).toString(), true);
    localObject = this.c;
    if (localObject != null) {
      new AlertDialog.Builder(((EditText)localObject).getContext()).setTitle("onSuccess").setMessage(paramJSONObject.toString()).setNegativeButton(HardCodeUtil.a(2131912165), null).create().show();
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    a("onTrigger\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment.MyAPICallback
 * JD-Core Version:    0.7.0.1
 */