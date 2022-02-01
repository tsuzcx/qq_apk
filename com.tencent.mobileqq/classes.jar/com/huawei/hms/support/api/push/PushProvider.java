package com.huawei.hms.support.api.push;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.FileNotFoundException;

public class PushProvider
  extends ContentProvider
{
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    if (paramUri.toString().endsWith(".xml")) {
      return "xml";
    }
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return false;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    HMSLog.i("PushProvider", "use sdk PushProvider openFile");
    if ("xml".equals(getType(paramUri)))
    {
      Object localObject;
      if (Build.VERSION.SDK_INT >= 24)
      {
        paramString = new StringBuilder();
        localObject = getContext();
        localObject.getClass();
        paramString.append(((Context)localObject).createDeviceProtectedStorageContext().getDataDir());
        paramString.append("/shared_prefs/push_notify_flag.xml");
        paramString = new File(paramString.toString());
        if (paramString.exists()) {
          return ParcelFileDescriptor.open(paramString, 268435456);
        }
        paramString = new StringBuilder();
        paramString.append(getContext().getDataDir());
        paramString.append("/shared_prefs/push_notify_flag.xml");
        paramString = new File(paramString.toString());
        if (paramString.exists()) {
          return ParcelFileDescriptor.open(paramString, 268435456);
        }
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(getContext().getFilesDir());
        paramString.append("");
        paramString = paramString.toString();
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString.substring(0, paramString.length() - 6));
          ((StringBuilder)localObject).append("/shared_prefs/push_notify_flag.xml");
          paramString = new File(((StringBuilder)localObject).toString());
          if (paramString.exists()) {
            return ParcelFileDescriptor.open(paramString, 268435456);
          }
        }
      }
      throw new FileNotFoundException(paramUri.getPath());
    }
    HMSLog.w("PushProvider", "Incorrect file uri");
    throw new FileNotFoundException(paramUri.getPath());
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.push.PushProvider
 * JD-Core Version:    0.7.0.1
 */