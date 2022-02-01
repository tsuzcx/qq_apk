package com.tencent.biz.troop;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.FileUtils;

class TroopMemberApiService$10
  extends BizTroopObserver
{
  TroopMemberApiService$10(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(Object paramObject)
  {
    paramObject = (TroopFileStatusInfo)paramObject;
    Bundle localBundle = new Bundle();
    localBundle.putLong("ProgressTotal", paramObject.jdField_c_of_type_Long);
    localBundle.putLong("ProgressValue", paramObject.jdField_d_of_type_Long);
    localBundle.putString("FileName", paramObject.g);
    localBundle.putString("FilePath", paramObject.e);
    localBundle.putString("LocalFile", paramObject.a);
    localBundle.putString("ThumbnailFile_Middle", paramObject.jdField_d_of_type_JavaLangString);
    localBundle.putString("ThumbnailFile_Large", paramObject.jdField_c_of_type_JavaLangString);
    localBundle.putInt("Status", paramObject.b);
    if ((paramObject.b != 8) && ((paramObject.b != 11) || (!FileUtils.fileExists(paramObject.e))))
    {
      if (!TextUtils.isEmpty(paramObject.jdField_c_of_type_JavaLangString))
      {
        localBundle.putInt("size", 640);
        this.a.a(58, localBundle);
        return;
      }
      if (!TextUtils.isEmpty(paramObject.jdField_d_of_type_JavaLangString))
      {
        localBundle.putInt("size", 383);
        this.a.a(58, localBundle);
      }
    }
    else
    {
      this.a.a(57, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.10
 * JD-Core Version:    0.7.0.1
 */