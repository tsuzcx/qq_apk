package com.tencent.biz.qqstory.newshare.mode;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.newshare.job.ShareGroupAvatarSaveFileJob;
import com.tencent.biz.qqstory.newshare.mode.base.CardShareModeBase;
import com.tencent.biz.qqstory.newshare.model.JobExecutor;
import com.tencent.biz.qqstory.newshare.model.JobExecutor.OnDataInitBeforePrepareCallBack;
import com.tencent.mobileqq.app.AppConstants;
import ngh;

public class ShareGroupCardShareMode
  extends CardShareModeBase
{
  public static final String a;
  public static final String b = "mqqapi://qstory/sharegroupcard?" + jdField_a_of_type_JavaLangString;
  public static final String c = "http://story.now.qq.com/mobile/transfer.html?" + jdField_a_of_type_JavaLangString + "&actionnamekey=4";
  private final int[] a;
  public String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "src_type=app&version=1&unionid=%s&fromId=%s&storysharefrom=%s&fromuid=%s&one_page=0" + StoryApi.a(2131432086);
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return String.format(b, new Object[] { this.d, Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]), b(paramInt), this.i });
    }
    return String.format(c, new Object[] { this.d, Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]), b(paramInt), this.i });
  }
  
  protected void a()
  {
    if (TextUtils.isEmpty(this.j))
    {
      String str = AppConstants.aX + ".storytmp/" + this.d + ".png";
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ShareGroupAvatarSaveFileJob(this.d, str)).a(new ngh(this, str)).a(new JobExecutor.OnDataInitBeforePrepareCallBack(this));
      return;
    }
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.ShareGroupCardShareMode
 * JD-Core Version:    0.7.0.1
 */