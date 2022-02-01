package com.tencent.biz.qqstory.newshare.mode;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.newshare.job.ShareGroupAvatarSaveFileJob;
import com.tencent.biz.qqstory.newshare.mode.base.CardShareModeBase;
import com.tencent.biz.qqstory.newshare.model.JobExecutor;
import com.tencent.biz.qqstory.newshare.model.JobExecutor.OnDataInitBeforePrepareCallBack;
import com.tencent.mobileqq.app.AppConstants;

public class ShareGroupCardShareMode
  extends CardShareModeBase
{
  public static final String a;
  public static final String b;
  public static final String c;
  private final int[] a;
  protected String d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("src_type=app&version=1&unionid=%s&fromId=%s&storysharefrom=%s&fromuid=%s&one_page=0");
    localStringBuilder.append(StoryApi.a(2131699903));
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://qstory/sharegroupcard?");
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://story.now.qq.com/mobile/transfer.html?");
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&actionnamekey=4");
    c = localStringBuilder.toString();
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AppConstants.SDCARD_FILE_SAVE_PATH);
      ((StringBuilder)localObject).append(".storytmp/");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelJobExecutor.a(new ShareGroupAvatarSaveFileJob(this.d, (String)localObject)).a(new ShareGroupCardShareMode.1(this, (String)localObject)).a(new JobExecutor.OnDataInitBeforePrepareCallBack(this));
      return;
    }
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.ShareGroupCardShareMode
 * JD-Core Version:    0.7.0.1
 */