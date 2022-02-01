package com.tencent.mobileqq.activity.aio.item;

import ahaw;
import ahbg;
import ahbj;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import asih;
import awsw;
import awyr;
import bdla;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;

public class MarketFaceItemBuilder$7$2
  implements Runnable
{
  public MarketFaceItemBuilder$7$2(ahbg paramahbg, Emoticon paramEmoticon, String paramString, ahbj paramahbj) {}
  
  public void run()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 2) && (this.jdField_a_of_type_Ahbg.a.b != null) && ((this.jdField_a_of_type_Ahbg.a.b instanceof FragmentActivity)))
    {
      localObject1 = (FragmentActivity)this.jdField_a_of_type_Ahbg.a.b;
      if ((((FragmentActivity)localObject1).getChatFragment() != null) && (((FragmentActivity)localObject1).getChatFragment().a() != null) && (awsw.a())) {
        ((FragmentActivity)localObject1).getChatFragment().a().playMaigcface(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 1, this.jdField_a_of_type_JavaLangString, false);
      }
      bdla.b(this.jdField_a_of_type_Ahbg.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 4) && (this.jdField_a_of_type_Ahbg.a.jdField_a_of_type_Asih.a()))
    {
      if (!this.jdField_a_of_type_Ahbg.a.f) {
        break label432;
      }
      this.jdField_a_of_type_Ahbj.f.setVisibility(0);
      this.jdField_a_of_type_Ahbj.f.setImageResource(2130838053);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source download sucess and needplay epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
    }
    for (;;)
    {
      localObject1 = new Intent(this.jdField_a_of_type_Ahbg.a.b, H5MagicPlayerActivity.class);
      ((Intent)localObject1).putExtra("clickTime", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("autoPlay", "1");
      ((Intent)localObject1).putExtra("senderUin", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("selfUin", this.jdField_a_of_type_Ahbg.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("sessionInfo", this.jdField_a_of_type_Ahbg.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ((Intent)localObject1).putExtra("emoticon", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      Object localObject2 = (awyr)this.jdField_a_of_type_Ahbg.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
      EmoticonPackage localEmoticonPackage = ((awyr)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if (localEmoticonPackage != null)
      {
        localObject2 = ((awyr)localObject2).a(localEmoticonPackage.childEpId);
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          ((Intent)localObject1).putExtra("childEmoticon", (Serializable)((List)localObject2).get(0));
        }
      }
      this.jdField_a_of_type_Ahbg.a.b.startActivity((Intent)localObject1);
      return;
      label432:
      this.jdField_a_of_type_Ahbj.f.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.2
 * JD-Core Version:    0.7.0.1
 */