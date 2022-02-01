package com.tencent.biz.pubaccount.readinjoy.skin;

import rbi;
import rbj;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class ReadInjoySkinAndRefreshFacade$2$1
  implements Runnable
{
  public ReadInjoySkinAndRefreshFacade$2$1(rbj paramrbj, oidb_0x5bd.GuideInfo paramGuideInfo1, int paramInt, oidb_0x5bd.RefreshInfo paramRefreshInfo, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo2) {}
  
  public void run()
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    rbi.a(this.jdField_a_of_type_Rbj.a, i, this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$GuideInfo, this.jdField_a_of_type_Int);
    RefreshData localRefreshData = rbi.a(this.jdField_a_of_type_Rbj.a, i, this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$RefreshInfo, this.jdField_a_of_type_Int);
    rbi.a(this.jdField_a_of_type_Rbj.a, i, localRefreshData, this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$SkinInfo, this.b, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.2.1
 * JD-Core Version:    0.7.0.1
 */