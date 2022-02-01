package com.tencent.mfsdk.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import aqkz;
import aqlg;
import com.google.gson.Gson;
import com.tencent.qphone.base.util.QLog;

public class QConfigAPMProcessor
  extends aqkz<APMConfRoot>
{
  public static final int CONFIG_ID = 255;
  public static final String TAG = "QAPM.Processor";
  
  public Class<APMConfRoot> clazz()
  {
    return APMConfRoot.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  @NonNull
  public APMConfRoot migrateOldOrDefaultContent(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAPM.Processor", 2, "migrateOldOrDefaultContent ");
    }
    return new APMConfRoot();
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public APMConfRoot onParsed(aqlg[] paramArrayOfaqlg)
  {
    APMConfRoot localAPMConfRoot = null;
    if (paramArrayOfaqlg.length > 0) {
      localAPMConfRoot = (APMConfRoot)new Gson().fromJson(paramArrayOfaqlg[0].a, APMConfRoot.class);
    }
    paramArrayOfaqlg = localAPMConfRoot;
    if (localAPMConfRoot == null) {
      paramArrayOfaqlg = new APMConfRoot();
    }
    return paramArrayOfaqlg;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public void onUpdate(APMConfRoot paramAPMConfRoot) {}
  
  public int type()
  {
    return 255;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.config.QConfigAPMProcessor
 * JD-Core Version:    0.7.0.1
 */