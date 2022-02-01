package com.dataline.activities;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import java.util.ArrayList;

class LiteActivity$43
  implements FMDialogUtil.FMDialogInterface
{
  LiteActivity$43(LiteActivity paramLiteActivity, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a()
  {
    Bundle localBundle;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
      new LiteActivity.SendPhotoAsyncTask(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).execute(new Bundle[] { localBundle });
    }
    if (!this.b.isEmpty())
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", this.b);
      new LiteActivity.SendVideoAsyncTask(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).execute(new Bundle[] { localBundle });
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.43
 * JD-Core Version:    0.7.0.1
 */