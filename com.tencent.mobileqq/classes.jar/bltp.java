import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.GetWatermarkDictRequest;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.Map;

public class bltp
{
  private static volatile bltp jdField_a_of_type_Bltp;
  private static final String jdField_a_of_type_JavaLangString = bltp.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private blvb jdField_a_of_type_Blvb;
  private SosoInterface.SosoLocation jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation;
  
  public static bltp a()
  {
    if (jdField_a_of_type_Bltp == null) {}
    try
    {
      if (jdField_a_of_type_Bltp == null) {
        jdField_a_of_type_Bltp = new bltp();
      }
      return jdField_a_of_type_Bltp;
    }
    finally {}
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    long l = dw.a();
    GetWatermarkDictRequest localGetWatermarkDictRequest = new GetWatermarkDictRequest(new COMM.StCommonExt(), paramDouble1, paramDouble2, String.valueOf(l));
    VSNetworkHelper.getInstance().sendRequest(localGetWatermarkDictRequest, new bltr(this));
  }
  
  private void a(Map<String, String> paramMap)
  {
    LogicDataManager.getInstance().addWatermarkDict(paramMap);
    String str = (String)paramMap.get("City");
    if (str != null)
    {
      bmbx.b(jdField_a_of_type_JavaLangString, "[prepareWMData]displayName : " + str);
      LogicDataManager.getInstance().setLocation(str);
    }
    str = (String)paramMap.get("Weather");
    if (str != null) {}
    try
    {
      i = Integer.parseInt(str);
      bmbx.b(jdField_a_of_type_JavaLangString, "[prepareWMData]weatherType : " + i);
      LogicDataManager.getInstance().setWeather(i);
      LogicDataManager.getInstance().setWeatherType(i);
      paramMap = (String)paramMap.get("TempCurr");
      if (paramMap != null)
      {
        bmbx.b(jdField_a_of_type_JavaLangString, "[prepareWMData]tempCurr : " + paramMap);
        LogicDataManager.getInstance().setTemperature(paramMap.replace(amtj.a(2131715894), ""));
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
  
  public blvb a()
  {
    return this.jdField_a_of_type_Blvb;
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
    bmbx.b(jdField_a_of_type_JavaLangString, "updateWMProps start");
    LbsManagerService.startLocation(new bltq(this, "qq_story_water_mark", false));
  }
  
  public void a(blvb paramblvb)
  {
    this.jdField_a_of_type_Blvb = paramblvb;
  }
  
  public void a(boolean paramBoolean)
  {
    VSConfigManager.getInstance().setValue("WM_LIST_CONFIG_CHANGED", Boolean.valueOf(paramBoolean));
  }
  
  public void b()
  {
    try
    {
      jdField_a_of_type_Bltp = null;
      this.jdField_a_of_type_Blvb = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltp
 * JD-Core Version:    0.7.0.1
 */