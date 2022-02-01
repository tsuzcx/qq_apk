package com.tencent.avgame.util;

import android.text.TextUtils;
import com.tencent.avgame.localvoicerecog.engine.VoiceRecogEngineFactory.VoiceRecogEngineType;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AvGameConfBean
{
  private double jdField_a_of_type_Double = 0.0D;
  private float jdField_a_of_type_Float = 0.5F;
  private int jdField_a_of_type_Int = 0;
  private AvGameMachineLevelUtils.MachineLevelLine jdField_a_of_type_ComTencentAvgameUtilAvGameMachineLevelUtils$MachineLevelLine = new AvGameMachineLevelUtils.MachineLevelLine(AvGameMachineLevelUtils.jdField_a_of_type_ComTencentAvgameUtilAvGameMachineLevelUtils$MachineLevelLine);
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<AvGameConfBean.RecordParam> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private HashMap<Integer, List<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private AvGameMachineLevelUtils.MachineLevelLine jdField_b_of_type_ComTencentAvgameUtilAvGameMachineLevelUtils$MachineLevelLine = new AvGameMachineLevelUtils.MachineLevelLine(AvGameMachineLevelUtils.jdField_b_of_type_ComTencentAvgameUtilAvGameMachineLevelUtils$MachineLevelLine);
  private String jdField_b_of_type_JavaLangString = "";
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_c_of_type_Int = 0;
  private AvGameMachineLevelUtils.MachineLevelLine jdField_c_of_type_ComTencentAvgameUtilAvGameMachineLevelUtils$MachineLevelLine = new AvGameMachineLevelUtils.MachineLevelLine(AvGameMachineLevelUtils.jdField_c_of_type_ComTencentAvgameUtilAvGameMachineLevelUtils$MachineLevelLine);
  private String jdField_c_of_type_JavaLangString = "";
  private int d = -1;
  private int e = -1;
  private int f = 100;
  private int g = -1;
  
  public static AvGameConfBean a(QConfItem paramQConfItem)
  {
    boolean bool = false;
    AvGameConfBean localAvGameConfBean = new AvGameConfBean();
    if (paramQConfItem != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameConfBean", 2, "parse taskid->" + paramQConfItem.jdField_a_of_type_Int + " content->" + paramQConfItem.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramQConfItem = new JSONObject(paramQConfItem.jdField_a_of_type_JavaLangString);
      localAvGameConfBean.a(paramQConfItem.optInt("ifShow", 0));
      localAvGameConfBean.a(paramQConfItem.optString("resUrl", ""));
      localAvGameConfBean.b(paramQConfItem.optString("resMd5", ""));
      localAvGameConfBean.b(paramQConfItem.optInt("quitTime", 0));
      if (QLog.isDevelopLevel()) {
        QLog.d("AvGameConfBean", 4, "mLoadingEnableExitTime[" + localAvGameConfBean.jdField_c_of_type_Int + "]");
      }
      Object localObject1 = paramQConfItem.optJSONObject("androidMachineLevels");
      if (localObject1 != null)
      {
        localAvGameConfBean.c(((JSONObject)localObject1).optString("high", ""));
        localAvGameConfBean.d(((JSONObject)localObject1).optString("middle", ""));
        localAvGameConfBean.e(((JSONObject)localObject1).optString("low", ""));
      }
      localObject1 = paramQConfItem.getJSONArray("gameBgMusic");
      int i = 0;
      Object localObject2;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        int k = ((JSONObject)localObject2).getInt("type");
        localObject2 = ((JSONObject)localObject2).getJSONArray("nameList");
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (j < ((JSONArray)localObject2).length())
        {
          Object localObject3 = ((JSONArray)localObject2).getJSONObject(j);
          String str = ((JSONObject)localObject3).optString("name", "");
          localObject3 = ((JSONObject)localObject3).optString("proportion", "");
          localArrayList.add(str);
          localAvGameConfBean.a(str, (String)localObject3);
          j += 1;
        }
        localAvGameConfBean.a(k, localArrayList);
        i += 1;
      }
      localObject1 = paramQConfItem.optJSONObject("recordParam");
      if (localObject1 != null)
      {
        localObject2 = ((JSONObject)localObject1).optJSONObject("gameAction");
        if (localObject2 != null) {
          localAvGameConfBean.a(new AvGameConfBean.RecordParam(1, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
        }
        localObject2 = ((JSONObject)localObject1).optJSONObject("gameMosaic");
        if (localObject2 != null) {
          localAvGameConfBean.a(new AvGameConfBean.RecordParam(2, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
        }
        localObject2 = ((JSONObject)localObject1).optJSONObject("gameVideo");
        if (localObject2 != null) {
          localAvGameConfBean.a(new AvGameConfBean.RecordParam(3, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("gameVideo");
        if (localObject1 != null) {
          localAvGameConfBean.a(new AvGameConfBean.RecordParam(4, ((JSONObject)localObject1).optInt("start", 10), ((JSONObject)localObject1).optInt("duration", 15)));
        }
      }
      if (paramQConfItem.has("disableSmallPicFlag"))
      {
        localAvGameConfBean.jdField_b_of_type_Int = paramQConfItem.optInt("disableSmallPicFlag");
        if (QLog.isDevelopLevel()) {
          QLog.i("AvGameConfBean", 4, "disableSmallPicFlag[" + localAvGameConfBean.jdField_b_of_type_Int + "]");
        }
      }
      localObject1 = paramQConfItem.optJSONArray("aioText");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        localObject2 = new ArrayList(((JSONArray)localObject1).length());
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          ((ArrayList)localObject2).add(((JSONArray)localObject1).optString(i, ""));
          i += 1;
        }
        localAvGameConfBean.a((ArrayList)localObject2);
      }
      if (paramQConfItem.optInt("isShowMatch", 0) == 1) {
        bool = true;
      }
      localAvGameConfBean.jdField_a_of_type_Boolean = bool;
      if (paramQConfItem.has("useLocalVoiceRecogUin"))
      {
        localAvGameConfBean.d = paramQConfItem.optInt("useLocalVoiceRecogUin");
        if (QLog.isDevelopLevel()) {
          QLog.i("AvGameConfBean", 4, "mUseLocalVoiceRecogUin[" + localAvGameConfBean.d + "]");
        }
      }
      if (paramQConfItem.has("enableAINSUin"))
      {
        localAvGameConfBean.g = paramQConfItem.optInt("enableAINSUin");
        if (QLog.isColorLevel()) {
          QLog.d("AvGameConfBean", 2, "mEnableAINSUin [" + localAvGameConfBean.g + "]");
        }
      }
      if (paramQConfItem.has("voiceRecogModelStrategy"))
      {
        localObject1 = paramQConfItem.optJSONObject("voiceRecogModelStrategy");
        localAvGameConfBean.e = ((JSONObject)localObject1).optInt("wxModelUin");
        double d1 = ((JSONObject)localObject1).optDouble("ailabSceneWordsTh", -1.0D);
        if (d1 > 0.0D) {
          localAvGameConfBean.jdField_a_of_type_Double = d1;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AvGameConfBean", 2, "mWXVoiceRecogUin [" + localAvGameConfBean.e + "] mAILabSceneWordsTh :" + localAvGameConfBean.jdField_a_of_type_Double);
        }
      }
      localAvGameConfBean.c(paramQConfItem.optInt("questionTimeout", 100));
      localAvGameConfBean.f(paramQConfItem.optString("conveneBottomTip", ""));
      localAvGameConfBean.a(paramQConfItem.optDouble("pkBGMProportion", 0.5D));
    }
    catch (Exception paramQConfItem)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AvGameConfBean", 2, "parse error->" + paramQConfItem.toString());
    }
    return localAvGameConfBean;
    return localAvGameConfBean;
  }
  
  public float a()
  {
    return (float)this.jdField_a_of_type_Double;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public VoiceRecogEngineFactory.VoiceRecogEngineType a(long paramLong)
  {
    if ((this.d <= -1) || (paramLong % 10L > this.d)) {
      return VoiceRecogEngineFactory.VoiceRecogEngineType.REMOTE_ENGINE_TYPE;
    }
    if (paramLong % 100L > this.e) {
      return VoiceRecogEngineFactory.VoiceRecogEngineType.AILAB_ENGINE_TYPE;
    }
    return VoiceRecogEngineFactory.VoiceRecogEngineType.WX_ENGINE_TYPE;
  }
  
  public AvGameMachineLevelUtils.MachineLevelLine a()
  {
    return this.jdField_a_of_type_ComTencentAvgameUtilAvGameMachineLevelUtils$MachineLevelLine;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (String)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public ArrayList<String> a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public List<AvGameConfBean.RecordParam> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public List<String> a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(double paramDouble)
  {
    Double localDouble = new Double(paramDouble);
    if (QLog.isColorLevel()) {
      QLog.i("AvGameConfBean", 2, "mPkBGMProportion [" + localDouble.floatValue() + "]");
    }
    this.jdField_a_of_type_Float = localDouble.floatValue();
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a(int paramInt, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramList);
  }
  
  public void a(AvGameConfBean.RecordParam paramRecordParam)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramRecordParam);
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  void a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  void a(ArrayList<String> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = false;
    if (this.d <= -1) {}
    for (;;)
    {
      QLog.i("AvGameConfBean", 1, "isUseLocalVoiceRecog. mUseLocalVoiceRecogUin = " + this.d + ", useLocalVoiceRecog = " + bool);
      return bool;
      if (paramLong % 10L <= this.d) {
        bool = true;
      }
    }
  }
  
  public float b()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public AvGameMachineLevelUtils.MachineLevelLine b()
  {
    return this.jdField_b_of_type_ComTencentAvgameUtilAvGameMachineLevelUtils$MachineLevelLine;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b(long paramLong)
  {
    if (paramLong < 0L) {}
    while (paramLong % 10L > this.g) {
      return false;
    }
    return true;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public AvGameMachineLevelUtils.MachineLevelLine c()
  {
    return this.jdField_c_of_type_ComTencentAvgameUtilAvGameMachineLevelUtils$MachineLevelLine;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.f = paramInt;
  }
  
  void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setHighMachineLevel str EMPTY");
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameUtilAvGameMachineLevelUtils$MachineLevelLine.a(paramString);
  }
  
  void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setMiddleMachineLevel str EMPTY");
      return;
    }
    this.jdField_b_of_type_ComTencentAvgameUtilAvGameMachineLevelUtils$MachineLevelLine.a(paramString);
  }
  
  void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setLowMachineLevel str EMPTY");
      return;
    }
    this.jdField_c_of_type_ComTencentAvgameUtilAvGameMachineLevelUtils$MachineLevelLine.a(paramString);
  }
  
  public void f(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return String.format("mAvGameShowInPlus:%d ", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.util.AvGameConfBean
 * JD-Core Version:    0.7.0.1
 */