import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.GetWatermarkDictRequest;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.Map;

public class bopi
{
  private static volatile bopi jdField_a_of_type_Bopi;
  private static final String jdField_a_of_type_JavaLangString = bopi.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private boqu jdField_a_of_type_Boqu;
  private SosoInterface.SosoLocation jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation;
  
  public static bopi a()
  {
    if (jdField_a_of_type_Bopi == null) {}
    try
    {
      if (jdField_a_of_type_Bopi == null) {
        jdField_a_of_type_Bopi = new bopi();
      }
      return jdField_a_of_type_Bopi;
    }
    finally {}
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    long l = dw.a();
    GetWatermarkDictRequest localGetWatermarkDictRequest = new GetWatermarkDictRequest(new COMM.StCommonExt(), paramDouble1, paramDouble2, String.valueOf(l));
    VSNetworkHelper.a().a(localGetWatermarkDictRequest, new bopk(this));
  }
  
  private void a(Map<String, String> paramMap)
  {
    LogicDataManager.getInstance().addWatermarkDict(paramMap);
    String str = (String)paramMap.get("City");
    if (str != null)
    {
      bpam.b(jdField_a_of_type_JavaLangString, "[prepareWMData]displayName : " + str);
      LogicDataManager.getInstance().setLocation(str);
    }
    str = (String)paramMap.get("Weather");
    if (str != null) {}
    try
    {
      i = Integer.parseInt(str);
      bpam.b(jdField_a_of_type_JavaLangString, "[prepareWMData]weatherType : " + i);
      LogicDataManager.getInstance().setWeather(i);
      LogicDataManager.getInstance().setWeatherType(i);
      paramMap = (String)paramMap.get("TempCurr");
      if (paramMap != null)
      {
        bpam.b(jdField_a_of_type_JavaLangString, "[prepareWMData]tempCurr : " + paramMap);
        LogicDataManager.getInstance().setTemperature(paramMap.replace(anzj.a(2131715660), ""));
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        LogUtils.e(localNumberFormatException);
        int i = 0;
      }
    }
  }
  
  public boqu a()
  {
    return this.jdField_a_of_type_Boqu;
  }
  
  public SosoInterface.SosoLocation a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = ((this.jdField_a_of_type_Int + 1) % 50);
    if (this.jdField_a_of_type_Int != 1) {
      return;
    }
    bpam.b(jdField_a_of_type_JavaLangString, "updateWMProps start");
    apch.a(new bopj(this, "qq_story_water_mark", false));
  }
  
  public void a(boqu paramboqu)
  {
    this.jdField_a_of_type_Boqu = paramboqu;
  }
  
  public void a(boolean paramBoolean)
  {
    abac.a().a("WM_LIST_CONFIG_CHANGED", Boolean.valueOf(paramBoolean));
  }
  
  public void b()
  {
    try
    {
      jdField_a_of_type_Bopi = null;
      this.jdField_a_of_type_Boqu = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bopi
 * JD-Core Version:    0.7.0.1
 */