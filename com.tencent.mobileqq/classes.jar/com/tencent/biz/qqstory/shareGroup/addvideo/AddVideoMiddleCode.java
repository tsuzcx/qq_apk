package com.tencent.biz.qqstory.shareGroup.addvideo;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tencent.biz.qqstory.storyHome.proxy.BaseTransitionCode;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.json.JSONArray;

public class AddVideoMiddleCode
  extends BaseTransitionCode
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 1000)
    {
      SLog.d("AddVideoMiddleCode", "unknown request code %d", new Object[] { Integer.valueOf(paramInt1) });
      a(paramInt2, paramIntent);
      e();
      return;
    }
    if (paramInt2 == -1)
    {
      Object localObject = null;
      try
      {
        LinkedHashSet localLinkedHashSet = (LinkedHashSet)paramIntent.getSerializableExtra("extra_checked_vidset");
        localObject = localLinkedHashSet;
      }
      catch (ClassCastException localClassCastException)
      {
        SLog.c("AddVideoMiddleCode", "StoryPickerFragment return illegal value", localClassCastException);
      }
      if ((localObject != null) && (localObject.size() > 0))
      {
        SLog.d("AddVideoMiddleCode", "let's add video to group, count = %d, collection = %s", new Object[] { Integer.valueOf(localObject.size()), new JSONArray(localObject).toString() });
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(localObject);
        StoryVideoUploadManager.a(this.jdField_a_of_type_JavaLangString, localArrayList, this.jdField_a_of_type_Int);
        paramIntent.putExtra("totalPublishVideoCount", localObject.size());
        paramIntent.putExtra("isAddFromExist", true);
      }
      else
      {
        SLog.d("AddVideoMiddleCode", "do not add video to group, exit ! result=%s, retValue=%s", new Object[] { Integer.valueOf(paramInt2), localObject });
        paramInt2 = 0;
      }
    }
    else
    {
      SLog.d("AddVideoMiddleCode", "add video to group cancel by user");
    }
    a(paramInt2, paramIntent);
    e();
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_Int = 0;
    SLog.a("AddVideoMiddleCode", "shareGroupId = %s, shareGroupName = %s, source=%d", this.jdField_a_of_type_JavaLangString, this.b, Integer.valueOf(this.jdField_a_of_type_Int));
    StoryPickerFragment.a(a(), null, this.b, 1000, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.addvideo.AddVideoMiddleCode
 * JD-Core Version:    0.7.0.1
 */