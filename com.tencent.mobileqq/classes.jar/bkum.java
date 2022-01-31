import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.GetWatermarkDictRequest;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.Map;

public class bkum
{
  private static volatile bkum jdField_a_of_type_Bkum;
  private static final String jdField_a_of_type_JavaLangString = bkum.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private bkvu jdField_a_of_type_Bkvu;
  private SosoInterface.SosoLocation jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation;
  
  public static bkum a()
  {
    if (jdField_a_of_type_Bkum == null) {}
    try
    {
      if (jdField_a_of_type_Bkum == null) {
        jdField_a_of_type_Bkum = new bkum();
      }
      return jdField_a_of_type_Bkum;
    }
    finally {}
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    long l = dr.a();
    GetWatermarkDictRequest localGetWatermarkDictRequest = new GetWatermarkDictRequest(new COMM.StCommonExt(), paramDouble1, paramDouble2, String.valueOf(l));
    VSNetworkHelper.a().a(localGetWatermarkDictRequest, new bkuo(this));
  }
  
  private void a(Map<String, String> paramMap)
  {
    LogicDataManager.getInstance().addWatermarkDict(paramMap);
    String str = (String)paramMap.get("City");
    if (str != null)
    {
      blfg.b(jdField_a_of_type_JavaLangString, "[prepareWMData]displayName : " + str);
      LogicDataManager.getInstance().setLocation(str);
    }
    str = (String)paramMap.get("Weather");
    if (str != null) {}
    try
    {
      i = Integer.parseInt(str);
      blfg.b(jdField_a_of_type_JavaLangString, "[prepareWMData]weatherType : " + i);
      LogicDataManager.getInstance().setWeather(i);
      LogicDataManager.getInstance().setWeatherType(i);
      paramMap = (String)paramMap.get("TempCurr");
      if (paramMap != null)
      {
        blfg.b(jdField_a_of_type_JavaLangString, "[prepareWMData]tempCurr : " + paramMap);
        LogicDataManager.getInstance().setTemperature(paramMap.replace(alpo.a(2131717262), ""));
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
  
  public bkvu a()
  {
    return this.jdField_a_of_type_Bkvu;
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
    blfg.b(jdField_a_of_type_JavaLangString, "updateWMProps start");
    amkv.a(new bkun(this, "qq_story_water_mark", false));
  }
  
  public void a(bkvu parambkvu)
  {
    this.jdField_a_of_type_Bkvu = parambkvu;
  }
  
  public void a(boolean paramBoolean)
  {
    yuh.a().a("WM_LIST_CONFIG_CHANGED", Boolean.valueOf(paramBoolean));
  }
  
  public void b()
  {
    try
    {
      jdField_a_of_type_Bkum = null;
      this.jdField_a_of_type_Bkvu = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkum
 * JD-Core Version:    0.7.0.1
 */