package com.tencent.biz.common.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.util.List;

public class FileChooserHelper
{
  private int a;
  private ValueCallback<Uri> b;
  private ValueCallback<Uri[]> c;
  private Uri d;
  
  private void a()
  {
    ValueCallback localValueCallback = this.b;
    if (localValueCallback != null)
    {
      localValueCallback.onReceiveValue(Uri.EMPTY);
      this.a = -2147483648;
      this.b = null;
      this.d = null;
    }
    localValueCallback = this.c;
    if (localValueCallback != null)
    {
      localValueCallback.onReceiveValue(null);
      this.c = null;
      this.d = null;
      this.a = -2147483648;
    }
  }
  
  private void a(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("photo/");
    localObject = new File(((StringBuilder)localObject).toString());
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      a();
      QQToast.makeText(paramActivity, 1, paramActivity.getString(2131887658), 0).show();
      return;
    }
    Intent localIntent = new Intent();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IMG_");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".jpg");
    this.d = FileProvider7Helper.setSystemCapture(paramActivity, new File((File)localObject, localStringBuilder.toString()), localIntent);
    a(paramActivity, localIntent, 2131887643);
  }
  
  private void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramActivity != null) && (paramIntent != null) && (paramInt > 0))
    {
      Object localObject = paramActivity.getPackageManager().queryIntentActivities(paramIntent, 0);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        try
        {
          paramActivity.startActivityForResult(paramIntent, this.a);
          return;
        }
        catch (Exception paramIntent)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Caution: activity for intent was queried but can't started because ");
            ((StringBuilder)localObject).append(paramIntent.getMessage());
            QLog.w("FileChooserHelper", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      a();
      QQToast.makeText(paramActivity, 1, paramInt, 0).show();
    }
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "*/*";
    }
    localIntent.setType(str);
    a(paramActivity, localIntent, 2131887659);
  }
  
  private void b(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("photo/");
    localObject = new File(((StringBuilder)localObject).toString());
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      a();
      QQToast.makeText(paramActivity, 1, paramActivity.getString(2131887658), 0).show();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VID_");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".mp4");
    this.d = Uri.fromFile(new File((File)localObject, localStringBuilder.toString()));
    localObject = new Intent("android.media.action.VIDEO_CAPTURE");
    ((Intent)localObject).putExtra("output", this.d);
    ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 1);
    a(paramActivity, (Intent)localObject, 2131887643);
  }
  
  private void c(Activity paramActivity)
  {
    a(paramActivity, new Intent("android.provider.MediaStore.RECORD_SOUND"), 2131887660);
  }
  
  public void a(Activity paramActivity, int paramInt, ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (paramActivity != null)
    {
      if ((paramValueCallback == null) && (this.c == null)) {
        return;
      }
      if ((QLog.isColorLevel()) && (this.b != null)) {
        QLog.w("FileChooserHelper", 2, "Caution: mFilePathCallback not null, Plz call doOnActivityResult in the onActivityResult method of caller");
      }
      this.a = paramInt;
      this.b = paramValueCallback;
      this.d = null;
      paramValueCallback = "";
      if (paramString1 != null) {
        paramString1 = paramString1.toLowerCase();
      } else {
        paramString1 = "";
      }
      if (paramString2 != null) {
        paramValueCallback = paramString2.toLowerCase();
      }
      if (TextUtils.isEmpty(paramValueCallback))
      {
        a(paramActivity, paramString1);
        return;
      }
      boolean bool = "camera".equals(paramValueCallback);
      int i = 1;
      if ((!bool) && (!"camcorder".equals(paramValueCallback)) && (!"microphone".equals(paramValueCallback))) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      if (paramInt == 0) {
        if (paramString1.contains("image/"))
        {
          paramValueCallback = "camera";
          paramInt = i;
        }
        else if (paramString1.contains("video/"))
        {
          paramValueCallback = "camcorder";
          paramInt = i;
        }
        else if (paramString1.contains("audio/"))
        {
          paramValueCallback = "microphone";
          paramInt = i;
        }
      }
      if (paramInt != 0)
      {
        paramString2 = ActionSheet.create(paramActivity);
        paramString2.setOnDismissListener(new FileChooserHelper.1(this));
        paramString2.setOnCancelListener(new FileChooserHelper.2(this));
        if (paramValueCallback.equals("camera"))
        {
          paramString2.addButton(paramActivity.getString(2131917015), 0);
          paramString2.addButton(paramActivity.getString(2131889380), 0);
          paramString2.setOnButtonClickListener(new FileChooserHelper.3(this, paramActivity, paramString1, paramString2));
        }
        else if (paramValueCallback.equals("camcorder"))
        {
          paramString2.addButton(paramActivity.getString(2131916269), 0);
          paramString2.addButton(paramActivity.getString(2131889380), 0);
          paramString2.setOnButtonClickListener(new FileChooserHelper.4(this, paramActivity, paramString1, paramString2));
        }
        else if (paramValueCallback.equals("microphone"))
        {
          paramString2.addButton(paramActivity.getString(2131915633), 0);
          paramString2.addButton(paramActivity.getString(2131889380), 0);
          paramString2.setOnButtonClickListener(new FileChooserHelper.5(this, paramActivity, paramString1, paramString2));
        }
        paramString2.show();
        return;
      }
      a(paramActivity, paramString1);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.a == paramInt1)
    {
      Object localObject2;
      Object localObject1;
      if (this.b != null)
      {
        if (-1 == paramInt2)
        {
          localObject2 = this.d;
          localObject1 = localObject2;
          if (localObject2 == null) {
            if (paramIntent != null) {
              localObject1 = paramIntent.getData();
            } else {
              localObject1 = Uri.EMPTY;
            }
          }
        }
        else
        {
          localObject1 = null;
        }
        this.b.onReceiveValue(localObject1);
      }
      else if (this.c != null)
      {
        if (-1 == paramInt2)
        {
          localObject2 = this.d;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label116;
          }
          if (paramIntent != null)
          {
            localObject1 = paramIntent.getData();
            break label116;
          }
        }
        localObject1 = null;
        label116:
        localObject2 = this.c;
        if (localObject1 != null)
        {
          paramIntent = new Uri[1];
          paramIntent[0] = localObject1;
        }
        else
        {
          paramIntent = null;
        }
        ((ValueCallback)localObject2).onReceiveValue(paramIntent);
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("FileChooserHelper", 2, "Caution: mFilePathCallback should not be null!");
      }
      this.a = -2147483648;
      this.b = null;
      this.d = null;
      this.c = null;
      return true;
    }
    return false;
  }
  
  @TargetApi(21)
  public boolean a(Activity paramActivity, int paramInt, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    if ((paramActivity != null) && (paramValueCallback != null))
    {
      this.c = paramValueCallback;
      paramValueCallback = paramFileChooserParams.getAcceptTypes();
      String str = "";
      if (paramValueCallback != null) {
        paramValueCallback = paramValueCallback[0];
      } else {
        paramValueCallback = "";
      }
      if (paramFileChooserParams.isCaptureEnabled()) {
        str = "*";
      }
      a(paramActivity, paramInt, null, paramValueCallback, str);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.FileChooserHelper
 * JD-Core Version:    0.7.0.1
 */