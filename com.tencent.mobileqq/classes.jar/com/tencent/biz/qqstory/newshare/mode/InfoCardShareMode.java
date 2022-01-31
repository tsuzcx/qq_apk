package com.tencent.biz.qqstory.newshare.mode;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.newshare.mode.base.CardShareModeBase;
import com.tencent.biz.qqstory.newshare.model.ShareData;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;
import com.tencent.biz.qqstory.newshare.util.ShareUtils;

public class InfoCardShareMode
  extends CardShareModeBase
{
  public static final String a;
  public static final String b;
  public static final String c;
  private final int[] a;
  private int c;
  private String d;
  private String l;
  
  static
  {
    jdField_a_of_type_JavaLangString = "src_type=internal&version=1&uin=%s&usertype=%s&unionid=%s&fromId=%s&storysharefrom=%s" + StoryApi.a(2131432086);
    b = "mqqapi://qstory/infoCard?" + jdField_a_of_type_JavaLangString;
    jdField_c_of_type_JavaLangString = "http://story.now.qq.com/mobile/transfer.html?" + jdField_a_of_type_JavaLangString + "&actionnamekey=3&one_page=0";
  }
  
  public InfoCardShareMode(QQUserUIItem paramQQUserUIItem)
  {
    this.d = paramQQUserUIItem.qq;
    this.j = paramQQUserUIItem.headUrl;
    int i;
    if (paramQQUserUIItem.isVip)
    {
      i = 1;
      this.jdField_c_of_type_Int = i;
      this.l = paramQQUserUIItem.uid;
      this.e = (paramQQUserUIItem.nickName + "的" + "日迹");
      this.g = ("[日迹]分享" + paramQQUserUIItem.nickName + "的" + "日迹");
      this.h = (paramQQUserUIItem.nickName + "的" + "日迹" + "[来自" + "日迹" + "，请使用新版手机" + StoryApi.a(2131432085) + "查看]");
      if (paramQQUserUIItem.videoCount > 0) {
        break label284;
      }
    }
    label284:
    for (this.f = "0个小视频";; this.f = (paramQQUserUIItem.videoCount + "个小视频"))
    {
      this.k = ("#日迹# " + this.e + "（" + this.f + "）");
      this.jdField_a_of_type_Int = 102;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 13, 14, 15, 16, 17, 18 };
      return;
      i = 0;
      break;
    }
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return String.format(b, new Object[] { this.d, Integer.valueOf(this.jdField_c_of_type_Int), this.l, Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]), b(paramInt) });
    }
    return String.format(jdField_c_of_type_JavaLangString, new Object[] { this.d, Integer.valueOf(this.jdField_c_of_type_Int), this.l, Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]), b(paramInt) });
  }
  
  protected void a(ShareData paramShareData)
  {
    super.a(paramShareData);
    if ((paramShareData != null) && ((paramShareData instanceof ShareQQData))) {
      ((ShareQQData)paramShareData).jdField_a_of_type_JavaLangString = (ShareUtils.b(this.j) + "#private_share_cache");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.InfoCardShareMode
 * JD-Core Version:    0.7.0.1
 */