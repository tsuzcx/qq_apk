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
  private int jdField_a_of_type_Int;
  private Uri jdField_a_of_type_AndroidNetUri;
  private ValueCallback<Uri> jdField_a_of_type_ComTencentSmttSdkValueCallback;
  private ValueCallback<Uri[]> b;
  
  private void a()
  {
    ValueCallback localValueCallback = this.jdField_a_of_type_ComTencentSmttSdkValueCallback;
    if (localValueCallback != null)
    {
      localValueCallback.onReceiveValue(Uri.EMPTY);
      this.jdField_a_of_type_Int = -2147483648;
      this.jdField_a_of_type_ComTencentSmttSdkValueCallback = null;
      this.jdField_a_of_type_AndroidNetUri = null;
    }
    localValueCallback = this.b;
    if (localValueCallback != null)
    {
      localValueCallback.onReceiveValue(null);
      this.b = null;
      this.jdField_a_of_type_AndroidNetUri = null;
      this.jdField_a_of_type_Int = -2147483648;
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
      QQToast.a(paramActivity, 1, paramActivity.getString(2131690738), 0).a();
      return;
    }
    Intent localIntent = new Intent();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IMG_");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".jpg");
    this.jdField_a_of_type_AndroidNetUri = FileProvider7Helper.setSystemCapture(paramActivity, new File((File)localObject, localStringBuilder.toString()), localIntent);
    a(paramActivity, localIntent, 2131690723);
  }
  
  private void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramActivity != null) && (paramIntent != null) && (paramInt > 0))
    {
      Object localObject = paramActivity.getPackageManager().queryIntentActivities(paramIntent, 0);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        try
        {
          paramActivity.startActivityForResult(paramIntent, this.jdField_a_of_type_Int);
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
      QQToast.a(paramActivity, 1, paramInt, 0).a();
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
    a(paramActivity, localIntent, 2131690739);
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
      QQToast.a(paramActivity, 1, paramActivity.getString(2131690738), 0).a();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VID_");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".mp4");
    this.jdField_a_of_type_AndroidNetUri = Uri.fromFile(new File((File)localObject, localStringBuilder.toString()));
    localObject = new Intent("android.media.action.VIDEO_CAPTURE");
    ((Intent)localObject).putExtra("output", this.jdField_a_of_type_AndroidNetUri);
    ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 1);
    a(paramActivity, (Intent)localObject, 2131690723);
  }
  
  private void c(Activity paramActivity)
  {
    a(paramActivity, new Intent("android.provider.MediaStore.RECORD_SOUND"), 2131690740);
  }
  
  public void a(Activity paramActivity, int paramInt, ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (paramActivity != null)
    {
      if ((paramValueCallback == null) && (this.b == null)) {
        return;
      }
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentSmttSdkValueCallback != null)) {
        QLog.w("FileChooserHelper", 2, "Caution: mFilePathCallback not null, Plz call doOnActivityResult in the onActivityResult method of caller");
      }
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentSmttSdkValueCallback = paramValueCallback;
      this.jdField_a_of_type_AndroidNetUri = null;
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
          paramString2.addButton(paramActivity.getString(2131719455), 0);
          paramString2.addButton(paramActivity.getString(2131692392), 0);
          paramString2.setOnButtonClickListener(new FileChooserHelper.3(this, paramActivity, paramString1, paramString2));
        }
        else if (paramValueCallback.equals("camcorder"))
        {
          paramString2.addButton(paramActivity.getString(2131718763), 0);
          paramString2.addButton(paramActivity.getString(2131692392), 0);
          paramString2.setOnButtonClickListener(new FileChooserHelper.4(this, paramActivity, paramString1, paramString2));
        }
        else if (paramValueCallback.equals("microphone"))
        {
          paramString2.addButton(paramActivity.getString(2131718155), 0);
          paramString2.addButton(paramActivity.getString(2131692392), 0);
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
    if (this.jdField_a_of_type_Int == paramInt1)
    {
      Object localObject2;
      Object localObject1;
      if (this.jdField_a_of_type_ComTencentSmttSdkValueCallback != null)
      {
        if (-1 == paramInt2)
        {
          localObject2 = this.jdField_a_of_type_AndroidNetUri;
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
        this.jdField_a_of_type_ComTencentSmttSdkValueCallback.onReceiveValue(localObject1);
      }
      else if (this.b != null)
      {
        if (-1 == paramInt2)
        {
          localObject2 = this.jdField_a_of_type_AndroidNetUri;
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
        localObject2 = this.b;
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
      this.jdField_a_of_type_Int = -2147483648;
      this.jdField_a_of_type_ComTencentSmttSdkValueCallback = null;
      this.jdField_a_of_type_AndroidNetUri = null;
      this.b = null;
      return true;
    }
    return false;
  }
  
  @TargetApi(21)
  public boolean a(Activity paramActivity, int paramInt, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    if ((paramActivity != null) && (paramValueCallback != null))
    {
      this.b = paramValueCallback;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.util.FileChooserHelper
 * JD-Core Version:    0.7.0.1
 */