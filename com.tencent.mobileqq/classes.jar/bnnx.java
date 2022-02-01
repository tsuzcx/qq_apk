import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.GetWatermarkDictRequest;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.Map;

public class bnnx
{
  private static volatile bnnx jdField_a_of_type_Bnnx;
  private static final String jdField_a_of_type_JavaLangString = bnnx.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private bnpf jdField_a_of_type_Bnpf;
  private SosoInterface.SosoLocation jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation;
  
  public static bnnx a()
  {
    if (jdField_a_of_type_Bnnx == null) {}
    try
    {
      if (jdField_a_of_type_Bnnx == null) {
        jdField_a_of_type_Bnnx = new bnnx();
      }
      return jdField_a_of_type_Bnnx;
    }
    finally {}
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    long l = dw.a();
    GetWatermarkDictRequest localGetWatermarkDictRequest = new GetWatermarkDictRequest(new COMM.StCommonExt(), paramDouble1, paramDouble2, String.valueOf(l));
    VSNetworkHelper.a().a(localGetWatermarkDictRequest, new bnnz(this));
  }
  
  private void a(Map<String, String> paramMap)
  {
    LogicDataManager.getInstance().addWatermarkDict(paramMap);
    String str = (String)paramMap.get("City");
    if (str != null)
    {
      bnzb.b(jdField_a_of_type_JavaLangString, "[prepareWMData]displayName : " + str);
      LogicDataManager.getInstance().setLocation(str);
    }
    str = (String)paramMap.get("Weather");
    if (str != null) {}
    try
    {
      i = Integer.parseInt(str);
      bnzb.b(jdField_a_of_type_JavaLangString, "[prepareWMData]weatherType : " + i);
      LogicDataManager.getInstance().setWeather(i);
      LogicDataManager.getInstance().setWeatherType(i);
      paramMap = (String)paramMap.get("TempCurr");
      if (paramMap != null)
      {
        bnzb.b(jdField_a_of_type_JavaLangString, "[prepareWMData]tempCurr : " + paramMap);
        LogicDataManager.getInstance().setTemperature(paramMap.replace(anni.a(2131715551), ""));
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
  
  public bnpf a()
  {
    return this.jdField_a_of_type_Bnpf;
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
    bnzb.b(jdField_a_of_type_JavaLangString, "updateWMProps start");
    aoor.a(new bnny(this, "qq_story_water_mark", false));
  }
  
  public void a(bnpf parambnpf)
  {
    this.jdField_a_of_type_Bnpf = parambnpf;
  }
  
  public void a(boolean paramBoolean)
  {
    aavz.a().a("WM_LIST_CONFIG_CHANGED", Boolean.valueOf(paramBoolean));
  }
  
  public void b()
  {
    try
    {
      jdField_a_of_type_Bnnx = null;
      this.jdField_a_of_type_Bnpf = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnx
 * JD-Core Version:    0.7.0.1
 */