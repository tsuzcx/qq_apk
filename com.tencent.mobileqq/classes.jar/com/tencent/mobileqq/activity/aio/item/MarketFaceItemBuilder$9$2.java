package com.tencent.mobileqq.activity.aio.item;

import adue;
import aduq;
import adus;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import anvx;
import asea;
import askf;
import axqy;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;

public class MarketFaceItemBuilder$9$2
  implements Runnable
{
  public MarketFaceItemBuilder$9$2(aduq paramaduq, Emoticon paramEmoticon, String paramString, adus paramadus) {}
  
  public void run()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 2) && (this.jdField_a_of_type_Aduq.a.b != null) && ((this.jdField_a_of_type_Aduq.a.b instanceof FragmentActivity)))
    {
      localObject1 = (FragmentActivity)this.jdField_a_of_type_Aduq.a.b;
      if ((((FragmentActivity)localObject1).getChatFragment() != null) && (((FragmentActivity)localObject1).getChatFragment().a() != null) && (asea.a())) {
        ((FragmentActivity)localObject1).getChatFragment().a().a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 1, this.jdField_a_of_type_JavaLangString, false);
      }
      axqy.b(this.jdField_a_of_type_Aduq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 4) && (this.jdField_a_of_type_Aduq.a.jdField_a_of_type_Anvx.a()))
    {
      if (!this.jdField_a_of_type_Aduq.a.f) {
        break label431;
      }
      this.jdField_a_of_type_Adus.f.setVisibility(0);
      this.jdField_a_of_type_Adus.f.setImageResource(2130837714);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source download sucess and needplay epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
    }
    for (;;)
    {
      localObject1 = new Intent(this.jdField_a_of_type_Aduq.a.b, H5MagicPlayerActivity.class);
      ((Intent)localObject1).putExtra("clickTime", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("autoPlay", "1");
      ((Intent)localObject1).putExtra("senderUin", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("selfUin", this.jdField_a_of_type_Aduq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("sessionInfo", this.jdField_a_of_type_Aduq.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ((Intent)localObject1).putExtra("emoticon", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      Object localObject2 = (askf)this.jdField_a_of_type_Aduq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      EmoticonPackage localEmoticonPackage = ((askf)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if (localEmoticonPackage != null)
      {
        localObject2 = ((askf)localObject2).a(localEmoticonPackage.childEpId);
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          ((Intent)localObject1).putExtra("childEmoticon", (Serializable)((List)localObject2).get(0));
        }
      }
      this.jdField_a_of_type_Aduq.a.b.startActivity((Intent)localObject1);
      return;
      label431:
      this.jdField_a_of_type_Adus.f.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.9.2
 * JD-Core Version:    0.7.0.1
 */