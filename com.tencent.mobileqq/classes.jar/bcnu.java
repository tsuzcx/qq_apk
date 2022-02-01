import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.LoadOptions;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.SoLoadInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;

public class bcnu
  extends bcnl
{
  public bcnu(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    super(paramLoadParam, paramLoadItem);
  }
  
  private SoLoadInfo b(int paramInt)
  {
    return a(paramInt);
  }
  
  @NonNull
  public SoLoadInfo a()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskSync", 2, "not main process get loadInfo sync by IPC");
      }
      return akwm.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem);
    }
    Object localObject1 = bcoj.a().a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, null, true);
    long l = this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq;
    Object localObject2 = new StringBuilder().append("is64bit=");
    if (bcoe.a()) {}
    for (int i = 1;; i = 0)
    {
      VACDReportUtil.a(l, null, "load.item.getconfig.end", i + "&v=" + a() + "&f=" + this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType, SoConfig.SoInfo.getReportCode((SoConfig.SoInfo)localObject1), null);
      if (a((SoConfig.SoInfo)localObject1)) {
        break;
      }
      return b(2);
    }
    localObject1 = bcod.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.ver);
    boolean bool2;
    boolean bool3;
    if (localObject1 != null)
    {
      if (((bcoc)localObject1).c())
      {
        if (QLog.isColorLevel()) {
          QLog.i("SoLoadWidget.GetSoTaskSync", 2, "[handleConfig] InLoadCrashProtectMode, crashInfo=" + localObject1);
        }
        this.c = "loadcrash";
        return b(8);
      }
      if (((bcoc)localObject1).a())
      {
        if (((bcoc)localObject1).b())
        {
          if (QLog.isColorLevel()) {
            QLog.i("SoLoadWidget.GetSoTaskSync", 2, "[handleConfig] InRunCrashProtectMode, crashInfo=" + localObject1);
          }
          this.c = "runcrash";
          return b(8);
        }
        bcod.b(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name);
      }
    }
    else
    {
      localObject1 = bcod.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo);
      bool2 = a((bcoq)localObject1);
      bool3 = a((bcoq)localObject1, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo);
      if ((this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.lops.flag & 0x4) == 0) {
        break label434;
      }
    }
    label434:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskSync", 2, "[handleConfigSync] isSoExist=" + bool2 + ",isRFReady=" + bool3 + ",isWeak:" + bool1);
      }
      if (bool2) {
        break label440;
      }
      return b(3);
      if (!((bcoc)localObject1).e()) {
        break;
      }
      bcoj.a().a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, (bcoc)localObject1, null);
      break;
    }
    label440:
    if ((!bool3) && (!bool1)) {
      return b(11);
    }
    this.jdField_b_of_type_Boolean = false;
    localObject2 = ((bcoq)localObject1).c;
    if (a((String)localObject2, ((bcoq)localObject1).a, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo, 1))
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (bool3) {
        this.jdField_b_of_type_JavaLangString = ((bcoq)localObject1).f;
      }
      return b(0);
    }
    return b(10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnu
 * JD-Core Version:    0.7.0.1
 */