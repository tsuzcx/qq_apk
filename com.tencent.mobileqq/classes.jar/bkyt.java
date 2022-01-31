import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.GetWatermarkDictRequest;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.Map;

public class bkyt
{
  private static volatile bkyt jdField_a_of_type_Bkyt;
  private static final String jdField_a_of_type_JavaLangString = bkyt.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private blab jdField_a_of_type_Blab;
  private SosoInterface.SosoLocation jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation;
  
  public static bkyt a()
  {
    if (jdField_a_of_type_Bkyt == null) {}
    try
    {
      if (jdField_a_of_type_Bkyt == null) {
        jdField_a_of_type_Bkyt = new bkyt();
      }
      return jdField_a_of_type_Bkyt;
    }
    finally {}
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    long l = dr.a();
    GetWatermarkDictRequest localGetWatermarkDictRequest = new GetWatermarkDictRequest(new COMM.StCommonExt(), paramDouble1, paramDouble2, String.valueOf(l));
    VSNetworkHelper.a().a(localGetWatermarkDictRequest, new bkyv(this));
  }
  
  private void a(Map<String, String> paramMap)
  {
    LogicDataManager.getInstance().addWatermarkDict(paramMap);
    String str = (String)paramMap.get("City");
    if (str != null)
    {
      bljn.b(jdField_a_of_type_JavaLangString, "[prepareWMData]displayName : " + str);
      LogicDataManager.getInstance().setLocation(str);
    }
    str = (String)paramMap.get("Weather");
    if (str != null) {}
    try
    {
      i = Integer.parseInt(str);
      bljn.b(jdField_a_of_type_JavaLangString, "[prepareWMData]weatherType : " + i);
      LogicDataManager.getInstance().setWeather(i);
      LogicDataManager.getInstance().setWeatherType(i);
      paramMap = (String)paramMap.get("TempCurr");
      if (paramMap != null)
      {
        bljn.b(jdField_a_of_type_JavaLangString, "[prepareWMData]tempCurr : " + paramMap);
        LogicDataManager.getInstance().setTemperature(paramMap.replace(alud.a(2131717274), ""));
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
  
  public blab a()
  {
    return this.jdField_a_of_type_Blab;
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
    bljn.b(jdField_a_of_type_JavaLangString, "updateWMProps start");
    ampk.a(new bkyu(this, "qq_story_water_mark", false));
  }
  
  public void a(blab paramblab)
  {
    this.jdField_a_of_type_Blab = paramblab;
  }
  
  public void a(boolean paramBoolean)
  {
    yyw.a().a("WM_LIST_CONFIG_CHANGED", Boolean.valueOf(paramBoolean));
  }
  
  public void b()
  {
    try
    {
      jdField_a_of_type_Bkyt = null;
      this.jdField_a_of_type_Blab = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyt
 * JD-Core Version:    0.7.0.1
 */