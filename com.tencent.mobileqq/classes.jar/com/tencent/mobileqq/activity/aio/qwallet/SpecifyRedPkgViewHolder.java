package com.tencent.mobileqq.activity.aio.qwallet;

import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.List;

public class SpecifyRedPkgViewHolder
  extends VipRedPkgViewHolder
{
  private IFaceDecoder a;
  
  public SpecifyRedPkgViewHolder(QQAppInterface paramQQAppInterface, QWalletMsgHolder paramQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, CustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramQQAppInterface, paramQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
  }
  
  public void a(IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setTextColor(-8947849);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.b.setText(IFBaseViewHolder.d);
    return false;
  }
  
  public void c()
  {
    int j = 0;
    super.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.f == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.f.getVisibility() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.f.setVisibility(0);
      }
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioQwalletQWalletMsgHolder.f.addView(localLinearLayout);
      Object localObject = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 25.0F);
      int k = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() <= 1) {
        i = 0;
      }
      while ((j < 5) && (j < this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size()))
      {
        long l = ((Long)this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.get(j)).longValue();
        localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        localLinearLayout.addView((View)localObject);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
        localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 33.0F);
        localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 33.0F);
        ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
        if (j > 0) {
          localLayoutParams.leftMargin = i;
        }
        ((ImageView)localObject).setImageDrawable(FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), (byte)4));
        ((ImageView)localObject).setBackgroundResource(2130847721);
        ((ImageView)localObject).setPadding(k, k, k, k);
        j += 1;
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() == 3)) {
          i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        } else if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() == 4) {
          i = 0;
        } else if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size() >= 5) {
          i = -DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F);
        } else {
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qwallet.SpecifyRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */