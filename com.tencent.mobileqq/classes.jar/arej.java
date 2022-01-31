import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class arej
  extends bbwj
  implements arep
{
  protected long a;
  protected boolean a;
  
  protected arej(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, bbwl parambbwl)
  {
    super(paramLong, paramItem, paramBundle, parambbwl);
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      return 0;
    case 1: 
    case 2: 
    case 3: 
    case 100: 
    case 101: 
    case 102: 
    case 302: 
    case 303: 
    case 304: 
    case 305: 
    case 309: 
    case 312: 
    case 313: 
      return 402;
    case 301: 
      return 401;
    case 300: 
      return 407;
    case 4: 
    case 306: 
    case 307: 
    case 308: 
      return 303;
    case 314: 
      return 304;
    case 315: 
      return 305;
    case 316: 
      return 306;
    case 317: 
      return 404;
    case 318: 
      return 408;
    case 319: 
      return 405;
    case 320: 
      return 406;
    case 5: 
    case 501: 
    case 502: 
    case 503: 
    case 504: 
    case 701: 
    case 702: 
      return 201;
    case 704: 
      return 504;
    case 708: 
      return 501;
    case 700: 
    case 707: 
    case 709: 
      return 502;
    case 703: 
    case 710: 
      return 506;
    case 8: 
      return 9037;
    }
    return 201;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      if (paramInt2 == 0) {
        break;
      }
    case 0: 
    case 101: 
    case 201: 
    case 300: 
    case 301: 
    case 302: 
    case 303: 
    case 400: 
    case 304: 
    case 305: 
    case 306: 
    case 307: 
    case 308: 
    case 401: 
    case 402: 
    case 403: 
    case 404: 
    case 408: 
    case 405: 
    case 406: 
    case 407: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return paramInt2;
                          return 0;
                          return 0;
                        } while (paramInt2 != 0);
                        return 0;
                        if (!bdin.g(BaseApplication.getContext())) {
                          return 306;
                        }
                      } while (paramInt2 != 0);
                      return 307;
                      if (!bdin.g(BaseApplication.getContext())) {
                        return 306;
                      }
                    } while (paramInt2 != 0);
                    if (paramInt1 == 305) {
                      return 315;
                    }
                    if (paramInt1 == 306) {
                      return 316;
                    }
                    return 314;
                    return 301;
                    if (!bdin.g(BaseApplication.getContext())) {
                      return 306;
                    }
                  } while (paramInt2 != 0);
                  return 309;
                  if (!bdin.g(BaseApplication.getContext())) {
                    return 306;
                  }
                } while (paramInt2 != 0);
                return 308;
              } while (paramInt2 != 0);
              return 317;
            } while (paramInt2 != 0);
            return 318;
          } while (paramInt2 != 0);
          return 319;
        } while (paramInt2 != 0);
        return 320;
      } while (paramInt2 != 0);
      return 300;
    case 501: 
      if (d()) {
        return 703;
      }
      return 708;
    case 502: 
      if (d()) {
        return 703;
      }
      return 709;
    case 503: 
      if (d()) {
        return 703;
      }
      return 705;
    case 504: 
      return 0;
    case 505: 
      if (d()) {
        return 703;
      }
      return 706;
    case 506: 
      return 703;
    }
    return paramInt1;
  }
  
  private arek a()
  {
    arek localarek = new arek(this);
    if ((this.jdField_a_of_type_Bbwd != null) && ((this.jdField_a_of_type_Bbwd instanceof areo)))
    {
      areo localareo = (areo)this.jdField_a_of_type_Bbwd;
      localarek.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = localareo.a();
      localarek.jdField_a_of_type_Int = localareo.a();
    }
    return localarek;
  }
  
  public static bbwj a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, bbwl parambbwl)
  {
    if (paramLong == 0L)
    {
      bbvl.a("ExcitingTransfer.ExtfGroupDownloadWorker", bbvl.jdField_a_of_type_Int, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      bbvl.a("ExcitingTransfer.ExtfGroupDownloadWorker", bbvl.jdField_a_of_type_Int, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      bbvl.a("ExcitingTransfer.ExtfGroupDownloadWorker", bbvl.jdField_a_of_type_Int, "getWoker. item.id=null");
      return null;
    }
    return new arej(paramLong, paramItem, paramBundle, parambbwl);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    Object localObject;
    arei localarei;
    if (paramInt1 == 0)
    {
      bool = true;
      localObject = a();
      localarei = new arei(bbvj.a());
      String str = arrr.f(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName);
      localarei.a(paramInt1, paramInt2, str, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin);
      if ((this.f <= 0L) || (this.g < this.f)) {
        break label146;
      }
      localarei.b(this.f);
      localarei.c(this.g);
      label100:
      if ((localObject == null) || (((arek)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo == null)) {
        break label161;
      }
      localarei.a(((arek)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo);
    }
    for (;;)
    {
      localarei.a(this.jdField_a_of_type_Long);
      localarei.a(bool);
      return;
      bool = false;
      break;
      label146:
      localarei.b(0L);
      localarei.c(0L);
      break label100;
      label161:
      localObject = new ExcitingTransferDownloadCompletedInfo();
      if (this.jdField_c_of_type_Long > 0L)
      {
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uStartTime = this.jdField_c_of_type_Long;
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uTotalTimes = (System.currentTimeMillis() - ((ExcitingTransferDownloadCompletedInfo)localObject).m_uStartTime);
      }
      if (this.jdField_a_of_type_Bbux.jdField_a_of_type_Long > 0L) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uStartSize = this.jdField_a_of_type_Bbux.jdField_a_of_type_Long;
      }
      if (this.jdField_a_of_type_Bbux.jdField_b_of_type_Long > 0L) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uDownloadedSize = this.jdField_a_of_type_Bbux.jdField_b_of_type_Long;
      }
      if (paramInt3 != 0) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_nSrvReturnCode = paramInt3;
      }
      localarei.a((ExcitingTransferDownloadCompletedInfo)localObject);
    }
  }
  
  private int b(int paramInt)
  {
    int i;
    if ((paramInt == 300) || (paramInt == 301) || (paramInt == 302) || (paramInt == 303) || (paramInt == 400) || (paramInt == 402) || (paramInt == 403))
    {
      i = paramInt;
      if (!bdin.g(BaseApplication.getContext())) {
        i = 3;
      }
    }
    do
    {
      return i;
      if ((paramInt == 501) || (paramInt == 502) || (paramInt == 503)) {
        break;
      }
      i = paramInt;
    } while (paramInt != 505);
    if (bdep.a()) {}
    for (long l1 = bdep.a() * 1024L;; l1 = bdep.b() * 1024L)
    {
      long l2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
      i = paramInt;
      if (l2 <= 0L) {
        break;
      }
      i = paramInt;
      if (l2 <= l1) {
        break;
      }
      return 506;
    }
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 201: 
    default: 
      return 9;
    case 0: 
      return 0;
    case 101: 
      return 8;
    case 300: 
    case 301: 
    case 302: 
    case 303: 
    case 304: 
    case 305: 
    case 306: 
    case 307: 
    case 308: 
    case 400: 
    case 401: 
    case 402: 
    case 403: 
    case 404: 
    case 405: 
    case 406: 
    case 407: 
    case 408: 
      return 3;
    case 501: 
    case 502: 
    case 503: 
    case 505: 
    case 506: 
      return 7;
    }
    return 6;
  }
  
  private int c(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 5: 
    default: 
      return 5;
    case 0: 
      return 0;
    case 1: 
    case 2: 
      return 2;
    case 3: 
    case 4: 
    case 6: 
      return 4;
    case 7: 
      return 3;
    }
    return 1;
  }
  
  private boolean d()
  {
    if (bdep.a()) {}
    for (long l1 = bdep.a() * 1024L;; l1 = bdep.b() * 1024L)
    {
      long l2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue;
      if ((l2 <= 0L) || (l2 <= l1)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void l()
  {
    int i = 2;
    if (this.jdField_c_of_type_Long != 0L) {
      i = 3;
    }
    arei localarei = new arei(bbvj.a());
    Object localObject = arrr.f(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName);
    localarei.a(1, i, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin);
    if ((this.f > 0L) && (this.g >= this.f))
    {
      localarei.b(this.f);
      localarei.c(this.g);
    }
    for (;;)
    {
      localObject = new ExcitingTransferDownloadCompletedInfo();
      if (this.jdField_c_of_type_Long > 0L)
      {
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uStartTime = this.jdField_c_of_type_Long;
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uTotalTimes = (System.currentTimeMillis() - ((ExcitingTransferDownloadCompletedInfo)localObject).m_uStartTime);
      }
      if (this.jdField_a_of_type_Bbux.jdField_a_of_type_Long > 0L) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uStartSize = this.jdField_a_of_type_Bbux.jdField_a_of_type_Long;
      }
      if (this.jdField_a_of_type_Bbux.jdField_b_of_type_Long > 0L) {
        ((ExcitingTransferDownloadCompletedInfo)localObject).m_uDownloadedSize = this.jdField_a_of_type_Bbux.jdField_b_of_type_Long;
      }
      localarei.a((ExcitingTransferDownloadCompletedInfo)localObject);
      localarei.a(this.jdField_a_of_type_Long);
      localarei.a(false);
      return;
      localarei.b(0L);
      localarei.c(0L);
    }
  }
  
  protected int a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    int i = 0;
    if (b())
    {
      paramInt2 = i;
      if (paramBundle != null) {
        paramInt2 = paramBundle.getInt("nSrvReturnCode", 0);
      }
      return a(paramInt1, paramInt2);
    }
    return super.a(paramInt1, paramInt2, paramBundle);
  }
  
  protected int a(int paramInt, Bundle paramBundle)
  {
    int i = 0;
    if (b())
    {
      if (paramBundle != null) {
        i = paramBundle.getInt("nSrvReturnCode", 0);
      }
      return b(paramInt, i);
    }
    return super.a(paramInt, paramBundle);
  }
  
  protected bbwd a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    QLog.i("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "^_^ nSessionID[" + paramLong + "] get ExtfFileDownloader. bIsHttps:" + paramBoolean + " strHttpsDomain:" + paramString3 + " urlParams:" + paramString2);
    this.jdField_a_of_type_Long = paramLong;
    if (arrr.b(paramString1)) {
      this.jdField_a_of_type_Boolean = true;
    }
    aren localaren = new aren();
    localaren.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal);
    localaren.b(paramString2);
    localaren.c(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue);
    int i = 80;
    localaren.a(paramBoolean);
    localaren.d(paramString3);
    if (paramBoolean) {
      i = 443;
    }
    paramString3 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName;
    paramString2 = paramString3;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave))
    {
      paramString2 = paramString3;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.SafeCheckRes == 2) {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave;
      }
    }
    paramString3 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString3 = a();
    }
    localaren.a(paramString3);
    paramString2 = new ArrayList();
    paramString2.add(new ExcitingTransferHostInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp, i));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS))
    {
      paramString3 = new ExcitingTransferHostInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS, i);
      if (!arsx.b(paramQQAppInterface)) {
        break label370;
      }
      QLog.i("ExcitingTransfer.ExtfGroupDownloadWorker<FileAssistant>", 1, "download support IPv6. domain[" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + "]");
      paramString2.add(0, paramString3);
    }
    for (;;)
    {
      localaren.a(paramString2);
      paramQQAppInterface = areo.a(paramQQAppInterface, paramLong, this.jdField_b_of_type_Long, paramString1, localaren);
      if (paramQQAppInterface == null) {
        break;
      }
      ((areo)paramQQAppInterface).a(this);
      return paramQQAppInterface;
      label370:
      paramString2.add(paramString3);
    }
    QLog.e("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "^_^ [" + this.jdField_a_of_type_JavaLangString + "] get ExtfFileDownloader fail.");
    return paramQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mExcitingSpeed = "";
    }
    super.a(paramInt);
  }
  
  public void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo) {}
  
  public void a(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    int j = 3;
    if (paramInt != 0) {
      if (paramExcitingTransferOneSlotComplete == null) {
        break label205;
      }
    }
    label205:
    for (int i = paramExcitingTransferOneSlotComplete.m_SrvRetCode;; i = 0)
    {
      a(b(paramInt, i), a(paramInt, i));
      this.jdField_a_of_type_Bbux.jdField_e_of_type_Int = 0;
      this.jdField_a_of_type_Bbux.f = 0;
      k();
      this.jdField_a_of_type_Bbux.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Bbux.d = 0;
      if (paramExcitingTransferOneSlotComplete != null)
      {
        arel localarel = new arel(bbvj.a());
        localarel.a(this.jdField_a_of_type_Long);
        String str = arrr.f(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName);
        i = b(paramInt);
        if (i == 3) {
          paramInt = 5;
        }
        for (;;)
        {
          localarel.a(paramInt, i, str, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.troopuin);
          localarel.a(paramExcitingTransferOneSlotComplete);
          localarel.a();
          return;
          paramInt = j;
          if (i != 506) {
            paramInt = 4;
          }
        }
      }
      QLog.e("ExcitingTransfer.ExtfGroupDownloadWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] onExtfSubUploaderResult DataReport fail. no rp");
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    if ((paramExcitingTransferDownloadSpeedInfo == null) || (paramExcitingTransferDownloadSpeedInfo.mTotalSpeed == 0)) {
      return;
    }
    long l = paramExcitingTransferDownloadSpeedInfo.mTotalSpeed;
    float f;
    if (l > 1048576L)
    {
      f = (float)l / 1048576.0F;
      paramExcitingTransferDownloadSpeedInfo = new DecimalFormat("0.00").format(f);
      paramExcitingTransferDownloadSpeedInfo = "加速下载 " + paramExcitingTransferDownloadSpeedInfo + "MB/s";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mExcitingSpeed = paramExcitingTransferDownloadSpeedInfo;
      return;
      if (l > 1024L)
      {
        f = (float)l / 1024.0F;
        paramExcitingTransferDownloadSpeedInfo = new DecimalFormat("0.00").format(f);
        paramExcitingTransferDownloadSpeedInfo = "加速下载 " + paramExcitingTransferDownloadSpeedInfo + "KB/s";
      }
      else
      {
        paramExcitingTransferDownloadSpeedInfo = "加速下载 " + l + "KB/s";
      }
    }
  }
  
  public void a(String paramString)
  {
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.mExcitingSpeed = "";
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal >= this.jdField_a_of_type_Bbux.jdField_a_of_type_Long) {
        this.d = (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal - this.jdField_a_of_type_Bbux.jdField_a_of_type_Long);
      }
      if (!bdhb.a(paramString))
      {
        bbvl.a("ExcitingTransfer.ExtfGroupDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "]  onDownloadSuccess but file is not exsited." + paramString);
        a(7, 706);
        a(true, bcps.b, bcps.o, 307);
      }
      do
      {
        return;
        long l = arrr.a(paramString);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal != 0L) && (l != this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal))
        {
          bbvl.a("ExcitingTransfer.ExtfGroupDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "]  file size check fail. filesize:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressTotal + " transSize:" + l);
          a(7, 704);
          a(true, bcps.b, bcps.q, 305);
          new File(paramString).delete();
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ProgressValue = 0L;
          return;
        }
        bbvl.c("ExcitingTransfer.ExtfGroupDownloadWorker", bbvl.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onDownlaodSuc  mFilePath:" + paramString);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile = paramString;
        int i = arrr.a(arso.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName));
        if (((i == 2) || (i == 0)) && (!arso.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_b_of_type_Long, 383)))) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.genThumb_Middle_OnGettedLargeOrOrigPic = true;
        }
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Bbuz = null;
        i();
        b(3);
        bbuv.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 11);
        paramString = HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5);
        String str = HexUtil.bytes2HexStr(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha);
        a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.jdField_b_of_type_Long), paramString, str, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Sha3);
        a(0, 0);
        c();
        j();
        bcpr.b(bcps.jdField_a_of_type_Int, 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.retryTimes = 0;
      } while (this.jdField_a_of_type_Bbwl == null);
      this.jdField_a_of_type_Bbwl.a(a(), true, 0, this);
      return;
    }
    super.a(paramString);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    return super.a();
  }
  
  protected void b()
  {
    int k = 1;
    int n = 0;
    super.b();
    if (b())
    {
      if ((this.jdField_a_of_type_Bbux.jdField_c_of_type_Int == 8) || (this.jdField_a_of_type_Bbux.jdField_c_of_type_Int == 11) || (this.jdField_a_of_type_Bbux.jdField_c_of_type_Int == 12)) {
        l();
      }
    }
    else {
      return;
    }
    arek localarek = a();
    int j;
    int i;
    if ((localarek != null) && (localarek.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo != null))
    {
      j = b(localarek.jdField_a_of_type_Int);
      i = 4;
    }
    for (;;)
    {
      int m = i;
      if (k != 0)
      {
        if (j != 3) {
          break label204;
        }
        m = 5;
      }
      for (;;)
      {
        a(m, j, n);
        return;
        j = this.jdField_a_of_type_Bbux.d;
        i = j;
        if (j == 0) {
          i = this.jdField_a_of_type_Bbux.jdField_c_of_type_Int;
        }
        if (this.jdField_c_of_type_Long == 0L)
        {
          k = c(this.jdField_a_of_type_Bbux.jdField_c_of_type_Int, this.jdField_a_of_type_Bbux.d);
          if (!this.jdField_c_of_type_Boolean) {
            break label220;
          }
          n = this.jdField_a_of_type_Bbux.d;
          i = 2;
          j = 7;
          k = 0;
          break;
        }
        j = b(a(i));
        i = 4;
        break;
        label204:
        m = i;
        if (j == 506) {
          m = 3;
        }
      }
      label220:
      j = i;
      i = k;
      k = 0;
    }
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected void c()
  {
    float f;
    if (b())
    {
      arek localarek = a();
      if ((localarek != null) && (localarek.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo != null))
      {
        this.jdField_a_of_type_Bbux.jdField_a_of_type_Long = localarek.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uStartSize;
        this.jdField_a_of_type_Bbux.jdField_b_of_type_Long = localarek.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uDownloadedSize;
        this.jdField_a_of_type_Bbux.jdField_c_of_type_Long = localarek.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uTotalTimes;
        if ((this.jdField_a_of_type_Bbux.jdField_b_of_type_Long <= 0L) || (this.jdField_a_of_type_Bbux.jdField_c_of_type_Long <= 0L)) {
          break label139;
        }
        f = (float)this.jdField_a_of_type_Bbux.jdField_c_of_type_Long / 1000.0F;
      }
    }
    label139:
    for (this.jdField_a_of_type_Bbux.jdField_e_of_type_Long = (((float)this.jdField_a_of_type_Bbux.jdField_b_of_type_Long / f));; this.jdField_a_of_type_Bbux.jdField_e_of_type_Long = 0L)
    {
      super.c();
      if (b()) {
        a(0, 0, 0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arej
 * JD-Core Version:    0.7.0.1
 */