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
  extends JobSegment<List<Bitmap>, Bitmap>
{
  private String a = "story.icon.BitmapListToIconSegment";
  private Context b;
  private int c;
  
  public BitmapListToIconSegment(Context paramContext, String paramString, int paramInt)
  {
    this.b = paramContext;
    paramContext = new StringBuilder();
    paramContext.append(this.a);
    paramContext.append("[");
    paramContext.append(paramString);
    paramContext.append("]");
    this.a = paramContext.toString();
    this.c = paramInt;
  }
  
  protected void a(JobContext paramJobContext, List<Bitmap> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramJobContext = (Bitmap[])paramList.toArray(new Bitmap[paramList.size()]);
      paramList = PuzzleAvatarUtil.a(this.c, Bitmap.Config.ARGB_8888, paramJobContext);
      IconLog.b(this.a, "result bitmap = %s, child count = %d", paramList, Integer.valueOf(paramJobContext.length));
      notifyResult(paramList);
      return;
    }
    notifyError(new ErrorMessage(-1, "bitmap list should not be empty"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.BitmapListToIconSegment
 * JD-Core Version:    0.7.0.1
 */