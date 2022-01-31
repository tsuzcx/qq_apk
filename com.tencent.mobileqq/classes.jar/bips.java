import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.GetWatermarkDictRequest;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.Map;

public class bips
{
  private static volatile bips jdField_a_of_type_Bips;
  private static final String jdField_a_of_type_JavaLangString = bips.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private bire jdField_a_of_type_Bire;
  private SosoInterface.SosoLocation jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation;
  
  public static bips a()
  {
    if (jdField_a_of_type_Bips == null) {}
    try
    {
      if (jdField_a_of_type_Bips == null) {
        jdField_a_of_type_Bips = new bips();
      }
      return jdField_a_of_type_Bips;
    }
    finally {}
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    long l = fi.a();
    GetWatermarkDictRequest localGetWatermarkDictRequest = new GetWatermarkDictRequest(new COMM.StCommonExt(), paramDouble1, paramDouble2, String.valueOf(l));
    VSNetworkHelper.a().a(localGetWatermarkDictRequest, new bipu(this));
  }
  
  private void a(Map<String, String> paramMap)
  {
    LogicDataManager.getInstance().addWatermarkDict(paramMap);
    String str = (String)paramMap.get("City");
    if (str != null) {
      LogicDataManager.getInstance().setLocation(str);
    }
    str = (String)paramMap.get("Weather");
    if (str != null) {}
    try
    {
      i = Integer.parseInt(str);
      LogicDataManager.getInstance().setWeather(i);
      LogicDataManager.getInstance().setWeatherType(i);
      paramMap = (String)paramMap.get("TempCurr");
      if (paramMap != null) {
        LogicDataManager.getInstance().setTemperature(paramMap.replace(ajya.a(2131716890), ""));
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
  
  public bire a()
  {
    return this.jdField_a_of_type_Bire;
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
    akuf.a(new bipt(this, "qq_story_water_mark", false));
  }
  
  public void a(bire parambire)
  {
    this.jdField_a_of_type_Bire = parambire;
  }
  
  public void a(boolean paramBoolean)
  {
    xfo.a().a("WM_LIST_CONFIG_CHANGED", Boolean.valueOf(paramBoolean));
  }
  
  public void b()
  {
    try
    {
      jdField_a_of_type_Bips = null;
      this.jdField_a_of_type_Bire = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bips
 * JD-Core Version:    0.7.0.1
 */