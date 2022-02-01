package com.dataline.activities;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import java.util.ArrayList;

class LiteActivity$45
  implements FMDialogUtil.FMDialogInterface
{
  LiteActivity$45(LiteActivity paramLiteActivity, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a()
  {
    Bundle localBundle;
    if (!this.a.isEmpty())
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", this.a);
      new LiteActivity.SendPhotoAsyncTask(this.c).execute(new Bundle[] { localBundle });
    }
    if (!this.b.isEmpty())
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", this.b);
      new LiteActivity.SendVideoAsyncTask(this.c).execute(new Bundle[] { localBundle });
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.45
 * JD-Core Version:    0.7.0.1
 */