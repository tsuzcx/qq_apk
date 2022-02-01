package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class CmGameTipsItemBuilder$2
  implements DialogInterface.OnClickListener
{
  CmGameTipsItemBuilder$2(CmGameTipsItemBuilder paramCmGameTipsItemBuilder, ApolloGameData paramApolloGameData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = String.format("https://m.gamecenter.qq.com/directout/detail/%s?_wv=2147484679&_wwv=4&ADTAG=limixiuteam&autodownload=1&pf=invite&appid=%s&notShowPub=1&asyncMode=3&appType=1&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0", new Object[] { this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.gameAppid, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.gameAppid });
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplCmGameTipsItemBuilder.a, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(this.jdField_a_of_type_ComTencentMobileqqApolloApiAioItemImplCmGameTipsItemBuilder.a, paramDialogInterface, -1L, localIntent, false, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.CmGameTipsItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */