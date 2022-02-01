import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.Map;

class bhya
  extends VasQuickUpdateManager.CallBacker
{
  bhya(bhxz parambhxz) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((16L != paramLong) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    label94:
    boolean bool;
    label118:
    int i;
    if ((QLog.isColorLevel()) || (paramInt1 != 0))
    {
      localObject1 = new StringBuilder().append("callBacker, from:").append(paramString3).append(",httpCode=").append(paramInt2).append(",errorCode:").append(paramInt1).append(", scid:").append(paramString1).append(", cfgScid:").append(paramString2);
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
    do
    {
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
        if ("iRedPacket_v3.char300.json".equals(paramString1))
        {
          if (bool)
          {
            paramVasQuickUpdateManager = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.char300.json";
            paramVasQuickUpdateManager = VasQuickUpdateManager.getFileFromLocal(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.char300.json", paramVasQuickUpdateManager, false, this.a.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
            this.a.a(true, false, paramString1, paramVasQuickUpdateManager);
          }
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          ??? = aoan.c;
          if (!bool) {
            break label1059;
          }
          paramVasQuickUpdateManager = "1";
          bdll.b((QQAppInterface)localObject1, "CliOper", "", "", "0X800612D", "0X800612D", 0, 0, (String)???, paramVasQuickUpdateManager, "1", "");
        }
        else if ("iRedPacket_v3.font.zip".equals(paramString1))
        {
          this.a.jdField_a_of_type_Bhye.e = i;
          if (bool)
          {
            paramVasQuickUpdateManager = new File(aoan.a(null, null, 21, 0, 0));
            this.a.a(true, false, paramString1, paramVasQuickUpdateManager);
          }
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          ??? = aoan.c;
          if (!bool) {
            break label1066;
          }
          paramVasQuickUpdateManager = "1";
          bdll.b((QQAppInterface)localObject1, "CliOper", "", "", "0X800612C", "0X800612C", 0, 0, (String)???, paramVasQuickUpdateManager, "1", "");
        }
        else
        {
          if (!"iRedPacket_v3.specialChar.zip".equals(paramString1)) {
            break label647;
          }
          this.a.b.e = i;
          if (bool)
          {
            paramVasQuickUpdateManager = new File(aoan.a(null, null, 25, 0, 0));
            this.a.a(true, false, paramString1, paramVasQuickUpdateManager);
          }
        }
      }
    } while (!paramString1.startsWith("luckyMoney.item."));
    label453:
    Object localObject1 = aoan.a(paramString1);
    label560:
    if (bool)
    {
      paramVasQuickUpdateManager = this.a.a((String)localObject1);
      if ((paramVasQuickUpdateManager != null) && (this.a.jdField_a_of_type_Aoan != null))
      {
        ??? = aoan.a((String)localObject1, null, paramVasQuickUpdateManager.jdField_a_of_type_Bhyc.f, paramVasQuickUpdateManager.jdField_a_of_type_Bhyc.d, 0);
        ??? = (String)??? + "_dir2";
        VasQuickUpdateEngine.safeDeleteFile(new File((String)???));
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "callBacker delete animateDir: " + (String)???);
        }
      }
    }
    for (;;)
    {
      label647:
      synchronized (this.a.jdField_a_of_type_JavaUtilMap)
      {
        if (!this.a.jdField_a_of_type_JavaUtilMap.containsKey(localObject1)) {
          break label998;
        }
        localObject3 = (List)this.a.jdField_a_of_type_JavaUtilMap.get(localObject1);
        i = 0;
        if (i < ((List)localObject3).size())
        {
          String str = (String)((List)localObject3).get(i);
          if (TextUtils.isEmpty(str)) {
            break label1073;
          }
          this.a.jdField_a_of_type_Aoan.a(str, paramVasQuickUpdateManager.jdField_a_of_type_Bhyc.f);
          this.a.jdField_a_of_type_Aoan.a(str + "_tp", paramVasQuickUpdateManager.b.f);
          this.a.jdField_a_of_type_Aoan.a(str + "_send", paramVasQuickUpdateManager.c.f);
        }
      }
      this.a.jdField_a_of_type_JavaUtilMap.remove(paramVasQuickUpdateManager.jdField_a_of_type_JavaLangString);
      label998:
      ??? = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Object localObject3 = aoan.c;
      if (bool) {}
      for (paramVasQuickUpdateManager = "1";; paramVasQuickUpdateManager = "0")
      {
        bdll.b((QQAppInterface)???, "CliOper", "", "", "0X800612E", "0X800612E", 0, 0, (String)localObject3, paramVasQuickUpdateManager, "1", (String)localObject1);
        break;
      }
      label1059:
      paramVasQuickUpdateManager = "0";
      break label453;
      label1066:
      paramVasQuickUpdateManager = "0";
      break label560;
      label1073:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhya
 * JD-Core Version:    0.7.0.1
 */