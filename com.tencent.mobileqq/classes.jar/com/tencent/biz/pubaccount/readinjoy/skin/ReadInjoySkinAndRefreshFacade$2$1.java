package com.tencent.biz.pubaccount.readinjoy.skin;

import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

class ReadInjoySkinAndRefreshFacade$2$1
  implements Runnable
{
  ReadInjoySkinAndRefreshFacade$2$1(ReadInjoySkinAndRefreshFacade.2 param2, oidb_0x5bd.GuideInfo paramGuideInfo1, int paramInt, oidb_0x5bd.RefreshInfo paramRefreshInfo, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo2) {}
  
  public void run()
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    ReadInjoySkinAndRefreshFacade.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInjoySkinAndRefreshFacade$2.a, i, this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$GuideInfo, this.jdField_a_of_type_Int);
    RefreshData localRefreshData = ReadInjoySkinAndRefreshFacade.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInjoySkinAndRefreshFacade$2.a, i, this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$RefreshInfo, this.jdField_a_of_type_Int);
    ReadInjoySkinAndRefreshFacade.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInjoySkinAndRefreshFacade$2.a, i, localRefreshData, this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$SkinInfo, this.b, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.2.1
 * JD-Core Version:    0.7.0.1
 */