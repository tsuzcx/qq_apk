package com.tencent.biz.qqstory.newshare.mode.base;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.newshare.model.ShareCopyLinkData;
import com.tencent.biz.qqstory.newshare.model.ShareData;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;
import com.tencent.biz.qqstory.newshare.model.ShareQZoneData;
import com.tencent.biz.qqstory.newshare.model.ShareSinaData;
import com.tencent.biz.qqstory.newshare.model.ShareWeChatData;
import com.tencent.biz.qqstory.newshare.util.ShareUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class VideoShareModeBase
  extends ShareModeBase
{
  public StoryVideoItem a;
  public int b;
  protected int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public VideoShareModeBase()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 1;
  }
  
  public String a()
  {
    if (this.a.isPollVideo()) {
      return this.jdField_c_of_type_JavaLangString + "的投票" + "小视频";
    }
    if (this.a.isInteractVideo()) {
      return this.jdField_c_of_type_JavaLangString + "的评分" + "小视频";
    }
    return this.jdField_c_of_type_JavaLangString + "的" + "小视频";
  }
  
  public final void a(ShareCopyLinkData paramShareCopyLinkData)
  {
    super.a(paramShareCopyLinkData);
    paramShareCopyLinkData.a = a(6);
    f(paramShareCopyLinkData);
  }
  
  public final void a(ShareQQData paramShareQQData)
  {
    super.a(paramShareQQData);
    paramShareQQData.b = 0;
    paramShareQQData.jdField_d_of_type_JavaLangString = this.k;
    paramShareQQData.a = this.a.mVideoThumbnailUrl;
    paramShareQQData.jdField_e_of_type_JavaLangString = this.a.mVid;
    paramShareQQData.j = this.l;
    paramShareQQData.h = a(1);
    if (this.jdField_c_of_type_Int != -1) {
      paramShareQQData.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (this.jdField_d_of_type_Int != -1) {
      paramShareQQData.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
    }
    f(paramShareQQData);
  }
  
  public final void a(ShareQZoneData paramShareQZoneData)
  {
    super.a(paramShareQZoneData);
    paramShareQZoneData.a = this.a.mVideoThumbnailUrl;
    paramShareQZoneData.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    paramShareQZoneData.jdField_d_of_type_JavaLangString = this.i;
    paramShareQZoneData.jdField_e_of_type_JavaLangString = a(2);
    f(paramShareQZoneData);
  }
  
  public final void a(ShareSinaData paramShareSinaData)
  {
    super.a(paramShareSinaData);
    paramShareSinaData.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramShareSinaData.jdField_d_of_type_JavaLangString = this.a.mVideoLocalThumbnailPath;
    if (TextUtils.isEmpty(paramShareSinaData.jdField_d_of_type_JavaLangString)) {
      paramShareSinaData.jdField_d_of_type_JavaLangString = ShareUtils.a(paramShareSinaData.jdField_e_of_type_JavaLangString);
    }
    paramShareSinaData.jdField_c_of_type_JavaLangString = a(5);
    paramShareSinaData.a = this.j;
    f(paramShareSinaData);
  }
  
  public void a(ShareWeChatData paramShareWeChatData)
  {
    super.a(paramShareWeChatData);
    paramShareWeChatData.jdField_c_of_type_JavaLangString = this.i;
    paramShareWeChatData.a = this.jdField_d_of_type_JavaLangString;
    paramShareWeChatData.jdField_d_of_type_JavaLangString = a(3);
    paramShareWeChatData.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramShareWeChatData.jdField_c_of_type_Boolean = true;
    f(paramShareWeChatData);
  }
  
  protected void a_(ShareData paramShareData)
  {
    SLog.b("VideoShareModeBase", "prepareCommonShareData");
    super.a_(paramShareData);
    if (this.a.isPollVideo()) {
      paramShareData.a("vote", "1");
    }
    for (;;)
    {
      paramShareData.a = this.a;
      return;
      if (this.a.isInteractVideo()) {
        paramShareData.a("grade", "1");
      }
    }
  }
  
  public String b()
  {
    Object localObject1 = this.a.getPollLayout();
    Object localObject2 = this.a.getInteractLayout();
    if ((localObject1 != null) && (((StoryVideoItem.PollLayout)localObject1).a != null) && (((StoryVideoItem.PollLayout)localObject1).a.length > 0))
    {
      localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject2 + " · " + localObject1.a[0];
    }
    if ((localObject2 != null) && (((StoryVideoItem.InteractPasterLayout)localObject2).a != null) && (((StoryVideoItem.InteractPasterLayout)localObject2).a.length > 0))
    {
      localObject1 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
      return (String)localObject1 + " · " + localObject2.a[0];
    }
    localObject2 = new SimpleDateFormat("M月d日").format(Long.valueOf(new Date().getTime()));
    if (TextUtils.isEmpty(this.g)) {}
    for (localObject1 = "1个小视频";; localObject1 = this.g) {
      return (String)localObject2 + " · " + (String)localObject1;
    }
  }
  
  public void b(ShareWeChatData paramShareWeChatData)
  {
    super.b(paramShareWeChatData);
    paramShareWeChatData.jdField_c_of_type_JavaLangString = this.i;
    paramShareWeChatData.a = this.jdField_d_of_type_JavaLangString;
    paramShareWeChatData.jdField_e_of_type_JavaLangString = this.a.mVideoThumbnailUrl;
    paramShareWeChatData.jdField_d_of_type_JavaLangString = a(4);
    paramShareWeChatData.jdField_c_of_type_Boolean = true;
    f(paramShareWeChatData);
  }
  
  protected void f(ShareData paramShareData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.VideoShareModeBase
 * JD-Core Version:    0.7.0.1
 */