package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.PicUploadThread;
import java.util.ArrayList;
import leu;
import lew;

public class ReadInJoyUploadAvatarActivity
  extends IphoneTitleBarActivity
{
  public static String a;
  public ProgressDialog a;
  protected Handler a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ReadInJoyUploadAvatarActivity.class.getSimpleName();
  }
  
  public ReadInJoyUploadAvatarActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(String paramString, Handler paramHandler)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    ThreadManager.post(new TroopBarPublishUtils.PicUploadThread(this, paramHandler, localArrayList, "https://upload.buluo.qq.com/cgi-bin/bar/upload/image", "1"), 8, null, true);
  }
  
  protected void a(String paramString)
  {
    a(paramString, new lew(this, Looper.getMainLooper(), paramString));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(new View(this));
    setTitle("移动和缩放", "移动和缩放");
    setLeftViewName(2131435689);
    this.jdField_a_of_type_AndroidOsHandler.post(new leu(this));
    paramBundle = getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramBundle == null) || (paramBundle.isEmpty()))
    {
      Intent localIntent = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putInt("retCode", 2);
      localBundle.putString("msg", "图像为空");
      localIntent.putExtra("Bundle", localBundle);
      setResult(-1, localIntent);
      finish();
    }
    if ((paramBundle != null) && (paramBundle.size() > 0)) {
      a((String)paramBundle.get(0));
    }
    return true;
  }
  
  protected void doOnDestroy()
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