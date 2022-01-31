package com.tencent.mobileqq.activity.aio.item;

import afqr;
import afrd;
import afrf;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import apnf;
import atva;
import aube;
import azmj;
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
  public MarketFaceItemBuilder$9$2(afrd paramafrd, Emoticon paramEmoticon, String paramString, afrf paramafrf) {}
  
  public void run()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 2) && (this.jdField_a_of_type_Afrd.a.b != null) && ((this.jdField_a_of_type_Afrd.a.b instanceof FragmentActivity)))
    {
      localObject1 = (FragmentActivity)this.jdField_a_of_type_Afrd.a.b;
      if ((((FragmentActivity)localObject1).getChatFragment() != null) && (((FragmentActivity)localObject1).getChatFragment().a() != null) && (atva.a())) {
        ((FragmentActivity)localObject1).getChatFragment().a().a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 1, this.jdField_a_of_type_JavaLangString, false);
      }
      azmj.b(this.jdField_a_of_type_Afrd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 4) && (this.jdField_a_of_type_Afrd.a.jdField_a_of_type_Apnf.a()))
    {
      if (!this.jdField_a_of_type_Afrd.a.f) {
        break label431;
      }
      this.jdField_a_of_type_Afrf.f.setVisibility(0);
      this.jdField_a_of_type_Afrf.f.setImageResource(2130837910);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source download sucess and needplay epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
    }
    for (;;)
    {
      localObject1 = new Intent(this.jdField_a_of_type_Afrd.a.b, H5MagicPlayerActivity.class);
      ((Intent)localObject1).putExtra("clickTime", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("autoPlay", "1");
      ((Intent)localObject1).putExtra("senderUin", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("selfUin", this.jdField_a_of_type_Afrd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("sessionInfo", this.jdField_a_of_type_Afrd.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ((Intent)localObject1).putExtra("emoticon", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      Object localObject2 = (aube)this.jdField_a_of_type_Afrd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      EmoticonPackage localEmoticonPackage = ((aube)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if (localEmoticonPackage != null)
      {
        localObject2 = ((aube)localObject2).a(localEmoticonPackage.childEpId);
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          ((Intent)localObject1).putExtra("childEmoticon", (Serializable)((List)localObject2).get(0));
        }
      }
      this.jdField_a_of_type_Afrd.a.b.startActivity((Intent)localObject1);
      return;
      label431:
      this.jdField_a_of_type_Afrf.f.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.9.2
 * JD-Core Version:    0.7.0.1
 */