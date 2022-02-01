package com.tencent.biz.pubaccount.readinjoy.video.videourl;

import com.tencent.image.AbsThirdDataSourceAdapter.OnPreparedCallback;

class ThirdDataSourceAdapter$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  ThirdDataSourceAdapter$1(ThirdDataSourceAdapter paramThirdDataSourceAdapter) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    ThirdDataSourceAdapter.a(this.a, 2);
    ThirdDataSourceAdapter localThirdDataSourceAdapter = this.a;
    String str;
    if (paramVideoUrlInfo.jdField_a_of_type_JavaLangString == null)
    {
      str = "";
      ThirdDataSourceAdapter.a(localThirdDataSourceAdapter, str);
      if (paramVideoUrlInfo.jdField_a_of_type_Int != 1) {
        break label78;
      }
      ThirdDataSourceAdapter.b(this.a, 1);
    }
    for (;;)
    {
      if (ThirdDataSourceAdapter.a(this.a) != null) {
        ThirdDataSourceAdapter.a(this.a).onPrepared();
      }
      return;
      str = paramVideoUrlInfo.jdField_a_of_type_JavaLangString;
      break;
      label78:
      ThirdDataSourceAdapter.b(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdDataSourceAdapter.1
 * JD-Core Version:    0.7.0.1
 */