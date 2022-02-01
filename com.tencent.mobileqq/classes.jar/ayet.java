import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowRsp;
import com.tencent.qphone.base.util.QLog;

class ayet
  extends ntf
{
  ayet(ayek paramayek) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProfileDisplayPanel", 2, "errorCode = [" + paramInt + "], bundle = [" + paramBundle + "]");
    }
    if (paramInt != 0) {
      QQToast.a(this.a.a, 1, anvx.a(2131706820), 1).a();
    }
    for (;;)
    {
      return;
      paramBundle = new NowSummaryCard.NearbyUserFollowRsp();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        QLog.i("NearbyProfileDisplayPanel", 1, "ret_code: " + paramBundle.ret_code.get() + ", err_msg: " + paramBundle.err_msg.get().toStringUtf8());
        paramInt = paramBundle.ret_code.get();
        paramArrayOfByte = paramBundle.err_msg.get().toStringUtf8();
        if (paramInt != 0) {
          if (!TextUtils.isEmpty(paramArrayOfByte))
          {
            QQToast.a(this.a.a, 1, "" + paramArrayOfByte, 1).a();
            if ((!ayek.a(this.a)) && (ayek.a(this.a).getChildAt(2).getVisibility() != 0))
            {
              paramArrayOfByte = (Button)ayek.a(this.a).getChildAt(1).findViewById(2131380283);
              paramArrayOfByte.setTextColor(this.a.a.getResources().getColor(2131167059));
              paramArrayOfByte.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130845497));
            }
            if (!ayek.a(this.a)) {
              continue;
            }
            paramArrayOfByte = (Button)ayek.a(this.a).getChildAt(1).findViewById(2131380283);
            paramArrayOfByte.setTextColor(this.a.a.getResources().getColor(2131167061));
            paramArrayOfByte.setBackgroundDrawable(this.a.a.getResources().getDrawable(2130845498));
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          continue;
          QQToast.a(this.a.a, 1, anvx.a(2131706728), 1).a();
        }
        this.a.a.a();
        paramArrayOfByte = this.a;
        if (ayek.a(this.a)) {
          break label524;
        }
      }
    }
    boolean bool = true;
    label413:
    ayek.a(paramArrayOfByte, bool);
    paramBundle = this.a.a;
    if (ayek.a(this.a)) {}
    for (paramArrayOfByte = anvx.a(2131706837);; paramArrayOfByte = anvx.a(2131706737))
    {
      QQToast.a(paramBundle, 2, paramArrayOfByte, 1).a();
      ((axve)this.a.a.app.getBusinessHandler(BusinessHandlerFactory.NOW_SMALL_VIDEO_HANDLER)).notifyUI(1000, true, new Object[] { Boolean.valueOf(ayek.a(this.a)), ayek.a(this.a).uin });
      ayek.a(this.a, 1, 60);
      break;
      label524:
      bool = false;
      break label413;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayet
 * JD-Core Version:    0.7.0.1
 */