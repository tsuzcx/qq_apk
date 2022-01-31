package com.tencent.biz.pubaccount.readinjoy.activity;

import ajyc;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import nxi;
import nxk;
import onk;
import qin;
import qio;

public class ReadInJoyUploadAvatarActivity
  extends IphoneTitleBarActivity
{
  public static String a;
  protected ProgressDialog a;
  protected Handler a;
  qin a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ReadInJoyUploadAvatarActivity.class.getSimpleName();
  }
  
  public ReadInJoyUploadAvatarActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Qin = new nxk(this);
  }
  
  private void a(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)onk.a();
    new qio(getApplicationContext(), localQQAppInterface, this.jdField_a_of_type_Qin).a(paramString, true, 2);
  }
  
  private void a(String paramString, Handler paramHandler, int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyUploadAvatarActivity.3(this, paramInt, paramString, paramHandler));
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      a(paramString, new nxi(this, Looper.getMainLooper()), paramInt2);
    }
    for (;;)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "uploadFile: from:" + paramInt1 + " paths:" + paramString);
      return;
      a(paramString);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(new View(this));
    setTitle(ajyc.a(2131712883), ajyc.a(2131712883));
    setLeftViewName(2131695079);
    this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyUploadAvatarActivity.1(this));
    paramBundle = getIntent();
    ArrayList localArrayList = paramBundle.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    int i = paramBundle.getIntExtra("from", 0);
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      Intent localIntent = getIntent();
      Bundle localBundle = new Bundle();
      localBundle.putInt("retCode", 2);
      localBundle.putString("msg", ajyc.a(2131712864));
      localIntent.putExtra("Bundle", localBundle);
      setResult(-1, localIntent);
      finish();
    }
    int j = paramBundle.getIntExtra("type", 1);
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      a(i, (String)localArrayList.get(0), j);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity
 * JD-Core Version:    0.7.0.1
 */