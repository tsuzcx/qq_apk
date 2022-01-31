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

class avlb
  implements avdq
{
  avlb(avkt paramavkt) {}
  
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
        label465:
        paramArrayOfByte = "";
        paramInt = 0;
      }
    }
    try
    {
      ((auul)this.a.a.app.getManager(106)).d.put(this.a.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      paramArrayOfByte = this.a;
      if (avkt.a(this.a)) {
        break label465;
      }
      bool = true;
      avkt.a(paramArrayOfByte, bool);
      avkt.a(this.a, 1, 60);
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
      ((auul)this.a.a.app.getManager(106)).d.put(this.a.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      paramBundle = this.a.a;
      if (avkt.a(this.a)) {}
      for (paramArrayOfByte = alud.a(2131707767);; paramArrayOfByte = alud.a(2131707704))
      {
        for (;;)
        {
          QQToast.a(paramBundle, 2, paramArrayOfByte, 1).a();
          if (!TextUtils.isEmpty(avkt.a(this.a).uin)) {
            ((avbr)this.a.a.app.a(119)).notifyUI(1000, true, new Object[] { Boolean.valueOf(avkt.a(this.a)), avkt.a(this.a).uin });
          }
          if ((!avkt.a(this.a)) && (avkt.a(this.a).getChildAt(2).getVisibility() != 0))
          {
            paramArrayOfByte = (Button)avkt.a(this.a).getChildAt(1).findViewById(2131379107);
            paramArrayOfByte.setTextColor(this.a.a.getResources().getColor(2131166934));
            paramArrayOfByte.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130845122));
          }
          if (avkt.a(this.a))
          {
            paramArrayOfByte = (Button)avkt.a(this.a).getChildAt(1).findViewById(2131379107);
            paramArrayOfByte.setTextColor(this.a.a.getResources().getColor(2131166936));
            paramArrayOfByte.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130845123));
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
        break label648;
        QLog.i("NearbyProfileDisplayPanel", 1, "follow, rspBody.busi_buf not has ");
        break label648;
        paramBundle.printStackTrace();
        break label159;
        QLog.i("NearbyProfileDisplayPanel", 1, "follow, errorCode=" + paramInt);
        break label648;
      }
    }
    Object localObject = this.a.a;
    paramBundle = paramArrayOfByte;
    if (TextUtils.isEmpty(paramArrayOfByte)) {
      paramBundle = alud.a(2131707752);
    }
    QQToast.a((Context)localObject, 1, paramBundle, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avlb
 * JD-Core Version:    0.7.0.1
 */