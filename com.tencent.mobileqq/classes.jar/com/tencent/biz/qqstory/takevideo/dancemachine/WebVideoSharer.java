package com.tencent.biz.qqstory.takevideo.dancemachine;

import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.io.File;

public class WebVideoSharer
  extends VideoSharer
{
  private EditVideoPartManager a;
  
  public void a()
  {
    super.a();
    if (jdField_b_of_type_Int != 2)
    {
      String str = new File(this.jdField_b_of_type_JavaLangString).getParent();
      if (str != null) {
        FileUtils.a(str);
      }
    }
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, AppInterface paramAppInterface, EditVideoPartManager paramEditVideoPartManager)
  {
    super.a(paramActivity, paramString1, paramString2, paramAppInterface);
    this.a = paramEditVideoPartManager;
  }
  
  protected boolean a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem.c == 2)
    {
      if (this.a != null) {
        this.a.a();
      }
      return true;
    }
    return super.a(paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.dancemachine.WebVideoSharer
 * JD-Core Version:    0.7.0.1
 */