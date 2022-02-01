import android.support.annotation.NonNull;
import com.tencent.mobileqq.soload.LoadOptions;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.SoLoadInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;

public class bbza
  extends bbyr
{
  public bbza(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
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
      return akfu.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem);
    }
    Object localObject1 = bbzq.a().a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, null, true);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam;
    long l = this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq;
    StringBuilder localStringBuilder = new StringBuilder().append("is64bit=");
    if (bbzl.a()) {}
    for (int i = 1;; i = 0)
    {
      bbzi.a((LoadParam)localObject2, l, null, "load.item.getconfig.end", i + "&v=" + a() + "&f=" + this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType, SoConfig.SoInfo.getReportCode((SoConfig.SoInfo)localObject1), null);
      if (a((SoConfig.SoInfo)localObject1)) {
        break;
      }
      return b(2);
    }
    localObject1 = bbzk.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.ver);
    boolean bool2;
    boolean bool3;
    if (localObject1 != null)
    {
      if (((bbzj)localObject1).c())
      {
        if (QLog.isColorLevel()) {
          QLog.i("SoLoadWidget.GetSoTaskSync", 2, "[handleConfig] InLoadCrashProtectMode, crashInfo=" + localObject1);
        }
        this.c = "loadcrash";
        return b(8);
      }
      if (((bbzj)localObject1).a())
      {
        if (((bbzj)localObject1).b())
        {
          if (QLog.isColorLevel()) {
            QLog.i("SoLoadWidget.GetSoTaskSync", 2, "[handleConfig] InRunCrashProtectMode, crashInfo=" + localObject1);
          }
          this.c = "runcrash";
          return b(8);
        }
        bbzk.b(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name);
      }
    }
    else
    {
      localObject1 = bbzk.b(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo);
      bool2 = a((bbzx)localObject1);
      bool3 = a((bbzx)localObject1, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo);
      if ((this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.lops.flag & 0x4) == 0) {
        break label442;
      }
    }
    label442:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskSync", 2, "[handleConfigSync] isSoExist=" + bool2 + ",isRFReady=" + bool3 + ",isWeak:" + bool1);
      }
      if (bool2) {
        break label448;
      }
      return b(3);
      if (!((bbzj)localObject1).e()) {
        break;
      }
      bbzq.a().a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, (bbzj)localObject1, null);
      break;
    }
    label448:
    if ((!bool3) && (!bool1)) {
      return b(11);
    }
    this.jdField_b_of_type_Boolean = false;
    localObject2 = ((bbzx)localObject1).c;
    if (a((String)localObject2, ((bbzx)localObject1).a, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo, 1))
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (bool3) {
        this.jdField_b_of_type_JavaLangString = ((bbzx)localObject1).f;
      }
      return b(0);
    }
    return b(10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbza
 * JD-Core Version:    0.7.0.1
 */