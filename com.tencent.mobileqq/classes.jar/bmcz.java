import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;
import protocol.KQQConfig.GetResourceReqInfo;

public class bmcz
  implements bmcy
{
  public boolean a(int paramInt, Bundle paramBundle)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        String str1;
        String str2;
        do
        {
          return true;
          anrv.a((QQAppInterface)localObject);
          return true;
          paramBundle = (aoge)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.UNI_PAY_HANDLER);
          paramBundle.a(new bmda(this));
          paramBundle.a("");
          return true;
          paramBundle = (ansg)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
          paramBundle.a(null, new GetResourceReqInfo[] { paramBundle.d() });
          return true;
          ((QQAppInterface)localObject).addObserver(new bmdb(this));
          return true;
          boolean bool = paramBundle.getBoolean("visible");
          ((anxi)((QQAppInterface)localObject).getBusinessHandler(3)).a(bool);
          return true;
          paramInt = paramBundle.getInt("iFaceType");
          str1 = paramBundle.getString("uinOrMobileNum");
          byte b = paramBundle.getByte("faceFileType");
          int i = paramBundle.getInt("idType");
          paramBundle = (FriendListHandler)((QQAppInterface)localObject).getBusinessHandler(1);
          switch (paramInt)
          {
          default: 
            return true;
          case 1: 
            paramBundle.getCustomHead(str1, (byte)0, b);
            return true;
          case 11: 
            paramBundle.getMobileQQHead(str1, b);
            return true;
          case 4: 
            paramBundle.getTroopHead(str1, b);
            return true;
          case 32: 
            paramBundle.getStrangerHead(str1, i, (byte)1, b);
            return true;
          }
          paramBundle.getQCallHead(str1, i, (byte)1, b);
          return true;
          str1 = paramBundle.getString("mUin");
          str2 = paramBundle.getString("feedsId");
          paramInt = paramBundle.getInt("action");
          paramBundle = (SignatureHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
        } while (paramBundle == null);
        paramBundle.a(str1, str2, 255, paramInt);
        return true;
        ((QQAppInterface)localObject).addObserver(new bmdc(this));
        return true;
        ((QQAppInterface)localObject).registObserver(new bmdd(this, null));
        return true;
        paramBundle = (SignatureHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
      } while (paramBundle == null);
      paramBundle.a();
      return true;
      ((SignatureHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER)).a(paramBundle.getString("uin"), paramBundle.getString("feedsId"), 255, true);
      return true;
      paramBundle = ContactUtils.getFriendDisplayName((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentAccountUin());
      localObject = new Bundle();
      ((Bundle)localObject).putString("name", paramBundle);
      QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 6, (Bundle)localObject);
      return true;
    } while (paramBundle == null);
    ((QQAppInterface)localObject).sendToService((ToServiceMsg)paramBundle.getParcelable("msg"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcz
 * JD-Core Version:    0.7.0.1
 */