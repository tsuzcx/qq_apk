package com.tencent.biz.qqstory.newshare.mode;

import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.newshare.mode.base.CardShareModeBase;
import com.tencent.biz.qqstory.newshare.model.ShareData;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;
import com.tencent.biz.qqstory.newshare.util.ShareUtils;
import com.tencent.mobileqq.app.HardCodeUtil;

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
    jdField_a_of_type_JavaLangString = "src_type=internal&version=1&uin=%s&usertype=%s&unionid=%s&fromId=%s&storysharefrom=%s" + StoryApi.a(2131699762);
    b = "mqqapi://qstory/infoCard?" + jdField_a_of_type_JavaLangString;
    jdField_c_of_type_JavaLangString = "https://story.now.qq.com/mobile/transfer.html?" + jdField_a_of_type_JavaLangString + "&actionnamekey=3&one_page=0";
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
      this.e = (paramQQUserUIItem.nickName + HardCodeUtil.a(2131705776) + QQStoryConstant.jdField_a_of_type_JavaLangString);
      this.g = ("[" + QQStoryConstant.jdField_a_of_type_JavaLangString + HardCodeUtil.a(2131705779) + paramQQUserUIItem.nickName + HardCodeUtil.a(2131705782) + QQStoryConstant.jdField_a_of_type_JavaLangString);
      this.h = (paramQQUserUIItem.nickName + HardCodeUtil.a(2131705781) + QQStoryConstant.jdField_a_of_type_JavaLangString + HardCodeUtil.a(2131705775) + QQStoryConstant.jdField_a_of_type_JavaLangString + HardCodeUtil.a(2131705778) + StoryApi.a(2131699759) + HardCodeUtil.a(2131705777));
      if (paramQQUserUIItem.videoCount > 0) {
        break label331;
      }
    }
    label331:
    for (this.f = "0个小视频";; this.f = (paramQQUserUIItem.videoCount + HardCodeUtil.a(2131705780)))
    {
      this.k = ("#" + QQStoryConstant.jdField_a_of_type_JavaLangString + "# " + this.e + "（" + this.f + "）");
      this.jdField_a_of_type_Int = 102;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 13, 14, 15, 16, 17, 18 };
      return;
      i = 0;
      break;
    }
  }
  
  public String a(int paramInt)
  {
    if (paramInt == 1) {
      return String.format(b, new Object[] { this.d, Integer.valueOf(this.jdField_c_of_type_Int), this.l, Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]), b(paramInt) });
    }
    return String.format(jdField_c_of_type_JavaLangString, new Object[] { this.d, Integer.valueOf(this.jdField_c_of_type_Int), this.l, Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]), b(paramInt) });
  }
  
  public void a(ShareData paramShareData)
  {
    super.a(paramShareData);
    if ((paramShareData != null) && ((paramShareData instanceof ShareQQData))) {
      ((ShareQQData)paramShareData).jdField_a_of_type_JavaLangString = (ShareUtils.b(this.j) + "#private_share_cache");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.InfoCardShareMode
 * JD-Core Version:    0.7.0.1
 */