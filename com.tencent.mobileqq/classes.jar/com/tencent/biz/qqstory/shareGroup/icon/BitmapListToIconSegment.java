package com.tencent.biz.qqstory.shareGroup.icon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.util.PuzzleAvatarUtil;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class BitmapListToIconSegment
  extends JobSegment
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString = "story.icon.BitmapListToIconSegment";
  
  public BitmapListToIconSegment(Context paramContext, String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "[" + paramString + "]");
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      notifyError(new ErrorMessage(-1, "bitmap list should not be empty"));
      return;
    }
    paramJobContext = (Bitmap[])paramList.toArray(new Bitmap[paramList.size()]);
    paramList = PuzzleAvatarUtil.a(this.jdField_a_of_type_Int, Bitmap.Config.ARGB_8888, paramJobContext);
    IconLog.b(this.jdField_a_of_type_JavaLangString, "result bitmap = %s, child count = %d", paramList, Integer.valueOf(paramJobContext.length));
    notifyResult(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.BitmapListToIconSegment
 * JD-Core Version:    0.7.0.1
 */