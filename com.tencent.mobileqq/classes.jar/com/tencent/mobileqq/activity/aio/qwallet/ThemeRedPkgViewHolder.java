package com.tencent.mobileqq.activity.aio.qwallet;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.ThemeRedPkgConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class ThemeRedPkgViewHolder
  extends BaseViewHolder
{
  ThemeRedPkgConfig a;
  int l = 0;
  int m = 0;
  
  public ThemeRedPkgViewHolder(QQAppInterface paramQQAppInterface, QWalletMsgHolder paramQWalletMsgHolder, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, CustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletTransferMsgElem, paramInt, paramOnCustomizeListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig = null;
    this.h = 0;
    this.m = paramQQWalletTransferMsgElem.themeId;
  }
  
  public void a()
  {
    super.a();
    String str;
    int i;
    if ((this.m > 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig = ((RedPacketManager)RedPacketManager.getInstance()).getThemeRedPkgConfById(this.m);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.c)))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.c;
        CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
        localRedPacketInfo.a = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
        if (this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.resourceType != 1) {
          break label171;
        }
        i = 4;
        label93:
        localRedPacketInfo.type = i;
        localRedPacketInfo.templateId = str;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo = CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedPacketInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$OnCustomizeListener);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.animInfo == null) {
        break label176;
      }
      this.l = 2;
    }
    label171:
    label176:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.background == null)
    {
      return;
      str = "http://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_" + this.m;
      break;
      i = 1;
      break label93;
    }
    this.l = 1;
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setTextColor(-8947849);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.e)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.d)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.f))) {}
    try
    {
      int i = Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.e);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setTextColor(i);
      label91:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.d);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setTag(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketThemeRedPkgConfig.f);
      for (;;)
      {
        return true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setText("QQ主题红包");
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label91;
    }
  }
  
  public void d()
  {
    if (this.l == 1)
    {
      c();
      return;
    }
    super.d();
  }
  
  public void e()
  {
    if (this.l > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.a.setVisibility(8);
      return;
    }
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.ThemeRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */