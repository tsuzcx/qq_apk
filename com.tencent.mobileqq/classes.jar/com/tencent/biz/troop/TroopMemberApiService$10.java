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
    localBundle.putLong("ProgressTotal", paramObject.i);
    localBundle.putLong("ProgressValue", paramObject.j);
    localBundle.putString("FileName", paramObject.t);
    localBundle.putString("FilePath", paramObject.r);
    localBundle.putString("LocalFile", paramObject.k);
    localBundle.putString("ThumbnailFile_Middle", paramObject.n);
    localBundle.putString("ThumbnailFile_Large", paramObject.m);
    localBundle.putInt("Status", paramObject.e);
    if ((paramObject.e != 8) && ((paramObject.e != 11) || (!FileUtils.fileExists(paramObject.r))))
    {
      if (!TextUtils.isEmpty(paramObject.m))
      {
        localBundle.putInt("size", 640);
        this.a.a(58, localBundle);
        return;
      }
      if (!TextUtils.isEmpty(paramObject.n))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.10
 * JD-Core Version:    0.7.0.1
 */