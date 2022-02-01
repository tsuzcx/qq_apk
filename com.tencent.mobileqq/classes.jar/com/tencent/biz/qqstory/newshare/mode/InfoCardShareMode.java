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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("src_type=internal&version=1&uin=%s&usertype=%s&unionid=%s&fromId=%s&storysharefrom=%s");
    localStringBuilder.append(StoryApi.a(2131699903));
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://qstory/infoCard?");
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://story.now.qq.com/mobile/transfer.html?");
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&actionnamekey=3&one_page=0");
    jdField_c_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public InfoCardShareMode(QQUserUIItem paramQQUserUIItem) {}
  
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
    if ((paramShareData != null) && ((paramShareData instanceof ShareQQData)))
    {
      paramShareData = (ShareQQData)paramShareData;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ShareUtils.b(this.j));
      localStringBuilder.append("#private_share_cache");
      paramShareData.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.InfoCardShareMode
 * JD-Core Version:    0.7.0.1
 */