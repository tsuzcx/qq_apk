import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.now.ilive_new_anchor_follow_interface.FollowActionRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class ayes
  implements axxd
{
  ayes(ayek paramayek) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      localObject = new oidb_0xada.RspBody();
      try
      {
        ((oidb_0xada.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if (((oidb_0xada.RspBody)localObject).busi_buf.has())
        {
          paramBundle = new ilive_new_anchor_follow_interface.FollowActionRsp();
          paramBundle.mergeFrom(((oidb_0xada.RspBody)localObject).busi_buf.get().toByteArray());
          if (paramBundle.ret.has())
          {
            paramInt = paramBundle.ret.get();
            if (paramInt != 0) {}
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        boolean bool;
        label160:
        label478:
        paramArrayOfByte = "";
        paramInt = 0;
      }
    }
    try
    {
      ((axny)this.a.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(this.a.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      paramArrayOfByte = this.a;
      if (ayek.a(this.a)) {
        break label478;
      }
      bool = true;
      ayek.a(paramArrayOfByte, bool);
      ayek.a(this.a, 1, 60);
      paramArrayOfByte = "";
      paramInt = 1;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      for (;;)
      {
        paramArrayOfByte = "";
        paramInt = 1;
      }
      break label160;
    }
    if (paramInt != 0)
    {
      ((axny)this.a.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(this.a.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      this.a.a.a();
      paramBundle = this.a.a;
      if (ayek.a(this.a)) {}
      for (paramArrayOfByte = anvx.a(2131706847);; paramArrayOfByte = anvx.a(2131706784))
      {
        for (;;)
        {
          QQToast.a(paramBundle, 2, paramArrayOfByte, 1).a();
          if (!TextUtils.isEmpty(ayek.a(this.a).uin)) {
            ((axve)this.a.a.app.getBusinessHandler(BusinessHandlerFactory.NOW_SMALL_VIDEO_HANDLER)).notifyUI(1000, true, new Object[] { Boolean.valueOf(ayek.a(this.a)), ayek.a(this.a).uin });
          }
          if ((!ayek.a(this.a)) && (ayek.a(this.a).getChildAt(2).getVisibility() != 0))
          {
            paramArrayOfByte = (Button)ayek.a(this.a).getChildAt(1).findViewById(2131380283);
            paramArrayOfByte.setTextColor(this.a.a.getResources().getColor(2131167059));
            paramArrayOfByte.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130845497));
          }
          if (ayek.a(this.a))
          {
            paramArrayOfByte = (Button)ayek.a(this.a).getChildAt(1).findViewById(2131380283);
            paramArrayOfByte.setTextColor(this.a.a.getResources().getColor(2131167061));
            paramArrayOfByte.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130845498));
          }
          return;
          bool = false;
          break;
          paramArrayOfByte = paramBundle.msg.get();
          try
          {
            QLog.i("NearbyProfileDisplayPanel", 1, "follow, followRsp.ret=" + paramBundle.ret.get() + ",errMsg=" + paramArrayOfByte);
            paramInt = 0;
          }
          catch (InvalidProtocolBufferMicroException paramBundle)
          {
            for (;;)
            {
              paramInt = 0;
            }
            paramArrayOfByte = "";
            paramInt = 0;
          }
        }
        QLog.i("NearbyProfileDisplayPanel", 1, "follow, followRsp.ret not has ");
        break label663;
        QLog.i("NearbyProfileDisplayPanel", 1, "follow, rspBody.busi_buf not has ");
        break label663;
        paramBundle.printStackTrace();
        break label160;
        QLog.i("NearbyProfileDisplayPanel", 1, "follow, errorCode=" + paramInt);
        break label663;
      }
    }
    Object localObject = this.a.a;
    paramBundle = paramArrayOfByte;
    if (TextUtils.isEmpty(paramArrayOfByte)) {
      paramBundle = anvx.a(2131706832);
    }
    QQToast.a((Context)localObject, 1, paramBundle, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayes
 * JD-Core Version:    0.7.0.1
 */