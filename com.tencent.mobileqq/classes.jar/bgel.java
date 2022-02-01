import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bgel
  extends VasQuickUpdateManager.CallBacker
{
  bgel(bgek parambgek) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((16L != paramLong) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Object localObject;
    label94:
    boolean bool;
    label118:
    int i;
    if ((QLog.isColorLevel()) || (paramInt1 != 0))
    {
      localObject = new StringBuilder().append("callBacker, from:").append(paramString3).append(",httpCode=").append(paramInt2).append(",errorCode:").append(paramInt1).append(", scid:").append(paramString1).append(", cfgScid:").append(paramString2);
      if (paramInt1 != 0)
      {
        paramVasQuickUpdateManager = ", Error ";
        QLog.d("IndividualRedPacketResDownloader", 2, paramVasQuickUpdateManager);
      }
    }
    else
    {
      if (paramInt1 != 0) {
        break label328;
      }
      bool = true;
      if (!bool) {
        break label334;
      }
      i = 2;
    }
    label328:
    label334:
    label340:
    String str;
    for (;;)
    {
      try
      {
        if (!"iRedPacket_v3.json".equals(paramString1)) {
          break label340;
        }
        this.a.a(true, false);
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "callBacker, from:" + paramString3 + ",httpCode=" + paramInt2 + ",errorCode:" + paramInt1 + ", scid:" + paramString1 + ", cfgScid:" + paramString2 + ", downloadOK=" + bool);
        }
        if ((TextUtils.isEmpty(paramString3)) || (!paramString3.startsWith("silent_download.redbag"))) {
          break;
        }
        this.a.a();
        return;
      }
      catch (Exception paramVasQuickUpdateManager)
      {
        QLog.d("IndividualRedPacketResDownloader", 2, "callBacker, from:" + paramString3 + ",httpCode=" + paramInt2 + ",errorCode:" + paramInt1 + ", scid:" + paramString1 + ", cfgScid:" + paramString2, paramVasQuickUpdateManager);
        return;
      }
      paramVasQuickUpdateManager = ", ok ";
      break label94;
      bool = false;
      break label118;
      i = -1;
      continue;
      if (!"iRedPacket_v3.char300.json".equals(paramString1)) {
        break label481;
      }
      if (bool)
      {
        paramVasQuickUpdateManager = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.char300.json";
        paramVasQuickUpdateManager = VasQuickUpdateManager.getFileFromLocal(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.char300.json", paramVasQuickUpdateManager, false, this.a.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        this.a.a(true, false, paramString1, paramVasQuickUpdateManager);
      }
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str = amuo.c;
      if (!bool) {
        break label669;
      }
      paramVasQuickUpdateManager = "1";
      label453:
      bcef.b((QQAppInterface)localObject, "CliOper", "", "", "0X800612D", "0X800612D", 0, 0, str, paramVasQuickUpdateManager, "1", "");
    }
    label481:
    if ("iRedPacket_v3.font.zip".equals(paramString1))
    {
      this.a.jdField_a_of_type_Bgep.e = i;
      if (bool)
      {
        paramVasQuickUpdateManager = new File(amuo.a(null, null, 21, 0, 0));
        this.a.a(true, false, paramString1, paramVasQuickUpdateManager);
      }
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str = amuo.c;
      if (!bool) {
        break label676;
      }
    }
    label669:
    label676:
    for (paramVasQuickUpdateManager = "1";; paramVasQuickUpdateManager = "0")
    {
      bcef.b((QQAppInterface)localObject, "CliOper", "", "", "0X800612C", "0X800612C", 0, 0, str, paramVasQuickUpdateManager, "1", "");
      break;
      if ("iRedPacket_v3.specialChar.zip".equals(paramString1))
      {
        this.a.b.e = i;
        if (!bool) {
          break;
        }
        paramVasQuickUpdateManager = new File(amuo.a(null, null, 25, 0, 0));
        this.a.a(true, false, paramString1, paramVasQuickUpdateManager);
        break;
      }
      if (!paramString1.startsWith("luckyMoney.item.")) {
        break;
      }
      bgek.a(this.a, paramString1, bool);
      break;
      paramVasQuickUpdateManager = "0";
      break label453;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgel
 * JD-Core Version:    0.7.0.1
 */