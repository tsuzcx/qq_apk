import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
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

class awyn
  implements awrb
{
  awyn(awyf paramawyf) {}
  
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
        label159:
        label475:
        paramArrayOfByte = "";
        paramInt = 0;
      }
    }
    try
    {
      ((awhw)this.a.a.app.getManager(106)).d.put(this.a.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      paramArrayOfByte = this.a;
      if (awyf.a(this.a)) {
        break label475;
      }
      bool = true;
      awyf.a(paramArrayOfByte, bool);
      awyf.a(this.a, 1, 60);
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
      break label159;
    }
    if (paramInt != 0)
    {
      ((awhw)this.a.a.app.getManager(106)).d.put(this.a.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      this.a.a.a();
      paramBundle = this.a.a;
      if (awyf.a(this.a)) {}
      for (paramArrayOfByte = amtj.a(2131706495);; paramArrayOfByte = amtj.a(2131706432))
      {
        for (;;)
        {
          QQToast.a(paramBundle, 2, paramArrayOfByte, 1).a();
          if (!TextUtils.isEmpty(awyf.a(this.a).uin)) {
            ((awpc)this.a.a.app.getBusinessHandler(119)).notifyUI(1000, true, new Object[] { Boolean.valueOf(awyf.a(this.a)), awyf.a(this.a).uin });
          }
          if ((!awyf.a(this.a)) && (awyf.a(this.a).getChildAt(2).getVisibility() != 0))
          {
            paramArrayOfByte = (Button)awyf.a(this.a).getChildAt(1).findViewById(2131379944);
            paramArrayOfByte.setTextColor(this.a.a.getResources().getColor(2131167045));
            paramArrayOfByte.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130845412));
          }
          if (awyf.a(this.a))
          {
            paramArrayOfByte = (Button)awyf.a(this.a).getChildAt(1).findViewById(2131379944);
            paramArrayOfByte.setTextColor(this.a.a.getResources().getColor(2131167047));
            paramArrayOfByte.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130845413));
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
        break label658;
        QLog.i("NearbyProfileDisplayPanel", 1, "follow, rspBody.busi_buf not has ");
        break label658;
        paramBundle.printStackTrace();
        break label159;
        QLog.i("NearbyProfileDisplayPanel", 1, "follow, errorCode=" + paramInt);
        break label658;
      }
    }
    Object localObject = this.a.a;
    paramBundle = paramArrayOfByte;
    if (TextUtils.isEmpty(paramArrayOfByte)) {
      paramBundle = amtj.a(2131706480);
    }
    QQToast.a((Context)localObject, 1, paramBundle, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awyn
 * JD-Core Version:    0.7.0.1
 */