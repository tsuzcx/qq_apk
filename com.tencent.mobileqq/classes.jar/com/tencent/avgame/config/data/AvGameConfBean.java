package com.tencent.avgame.config.data;

import android.text.TextUtils;
import com.tencent.av.utils.machine.MachineLevelLine;
import com.tencent.avgame.util.AvGameMachineLevelUtils;
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
  private MachineLevelLine jdField_a_of_type_ComTencentAvUtilsMachineMachineLevelLine = new MachineLevelLine(AvGameMachineLevelUtils.jdField_a_of_type_ComTencentAvUtilsMachineMachineLevelLine);
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<AvGameConfBean.RecordParam> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private HashMap<Integer, List<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private MachineLevelLine jdField_b_of_type_ComTencentAvUtilsMachineMachineLevelLine = new MachineLevelLine(AvGameMachineLevelUtils.jdField_b_of_type_ComTencentAvUtilsMachineMachineLevelLine);
  private String jdField_b_of_type_JavaLangString = "";
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_c_of_type_Int = 0;
  private MachineLevelLine jdField_c_of_type_ComTencentAvUtilsMachineMachineLevelLine = new MachineLevelLine(AvGameMachineLevelUtils.jdField_c_of_type_ComTencentAvUtilsMachineMachineLevelLine);
  private String jdField_c_of_type_JavaLangString = "";
  private int d = -1;
  private int e = -1;
  private int f = 100;
  private int g = -1;
  
  public static AvGameConfBean a(QConfItem paramQConfItem)
  {
    AvGameConfBean localAvGameConfBean = new AvGameConfBean();
    if (paramQConfItem != null)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parse taskid->");
        ((StringBuilder)localObject1).append(paramQConfItem.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(" content->");
        ((StringBuilder)localObject1).append(paramQConfItem.jdField_a_of_type_JavaLangString);
        QLog.d("AvGameConfBean", 2, ((StringBuilder)localObject1).toString());
      }
      try
      {
        JSONObject localJSONObject = new JSONObject(paramQConfItem.jdField_a_of_type_JavaLangString);
        localAvGameConfBean.a(localJSONObject.optInt("ifShow", 0));
        localAvGameConfBean.a(localJSONObject.optString("resUrl", ""));
        localAvGameConfBean.b(localJSONObject.optString("resMd5", ""));
        localAvGameConfBean.b(localJSONObject.optInt("quitTime", 0));
        boolean bool = QLog.isDevelopLevel();
        if (bool)
        {
          paramQConfItem = new StringBuilder();
          paramQConfItem.append("mLoadingEnableExitTime[");
          paramQConfItem.append(localAvGameConfBean.jdField_c_of_type_Int);
          paramQConfItem.append("]");
          QLog.d("AvGameConfBean", 4, paramQConfItem.toString());
        }
        paramQConfItem = localJSONObject.optJSONObject("androidMachineLevels");
        if (paramQConfItem != null)
        {
          localAvGameConfBean.c(paramQConfItem.optString("high", ""));
          localAvGameConfBean.d(paramQConfItem.optString("middle", ""));
          localAvGameConfBean.e(paramQConfItem.optString("low", ""));
        }
        paramQConfItem = localJSONObject.getJSONArray("gameBgMusic");
        int i = 0;
        while (i < paramQConfItem.length())
        {
          localObject1 = paramQConfItem.getJSONObject(i);
          int k = ((JSONObject)localObject1).getInt("type");
          localObject1 = ((JSONObject)localObject1).getJSONArray("nameList");
          ArrayList localArrayList = new ArrayList();
          int j = 0;
          while (j < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).getJSONObject(j);
            String str = ((JSONObject)localObject2).optString("name", "");
            localObject2 = ((JSONObject)localObject2).optString("proportion", "");
            localArrayList.add(str);
            localAvGameConfBean.a(str, (String)localObject2);
            j += 1;
          }
          localAvGameConfBean.a(k, localArrayList);
          i += 1;
        }
        paramQConfItem = localJSONObject.optJSONObject("recordParam");
        if (paramQConfItem != null)
        {
          localObject1 = paramQConfItem.optJSONObject("gameAction");
          if (localObject1 != null) {
            localAvGameConfBean.a(new AvGameConfBean.RecordParam(1, ((JSONObject)localObject1).optInt("start", 10), ((JSONObject)localObject1).optInt("duration", 15)));
          }
          localObject1 = paramQConfItem.optJSONObject("gameMosaic");
          if (localObject1 != null) {
            localAvGameConfBean.a(new AvGameConfBean.RecordParam(2, ((JSONObject)localObject1).optInt("start", 10), ((JSONObject)localObject1).optInt("duration", 15)));
          }
          localObject1 = paramQConfItem.optJSONObject("gameVideo");
          if (localObject1 != null) {
            localAvGameConfBean.a(new AvGameConfBean.RecordParam(3, ((JSONObject)localObject1).optInt("start", 10), ((JSONObject)localObject1).optInt("duration", 15)));
          }
          paramQConfItem = paramQConfItem.optJSONObject("gameVideo");
          if (paramQConfItem != null) {
            localAvGameConfBean.a(new AvGameConfBean.RecordParam(4, paramQConfItem.optInt("start", 10), paramQConfItem.optInt("duration", 15)));
          }
        }
        if (localJSONObject.has("disableSmallPicFlag"))
        {
          localAvGameConfBean.jdField_b_of_type_Int = localJSONObject.optInt("disableSmallPicFlag");
          if (QLog.isDevelopLevel())
          {
            paramQConfItem = new StringBuilder();
            paramQConfItem.append("disableSmallPicFlag[");
            paramQConfItem.append(localAvGameConfBean.jdField_b_of_type_Int);
            paramQConfItem.append("]");
            QLog.i("AvGameConfBean", 4, paramQConfItem.toString());
          }
        }
        paramQConfItem = localJSONObject.optJSONArray("aioText");
        if ((paramQConfItem != null) && (paramQConfItem.length() > 0))
        {
          localObject1 = new ArrayList(paramQConfItem.length());
          i = 0;
          while (i < paramQConfItem.length())
          {
            ((ArrayList)localObject1).add(paramQConfItem.optString(i, ""));
            i += 1;
          }
          localAvGameConfBean.a((ArrayList)localObject1);
        }
        bool = false;
        if (localJSONObject.optInt("isShowMatch", 0) == 1) {
          bool = true;
        }
        localAvGameConfBean.jdField_a_of_type_Boolean = bool;
        if (localJSONObject.has("useLocalVoiceRecogUin"))
        {
          localAvGameConfBean.d = localJSONObject.optInt("useLocalVoiceRecogUin");
          if (QLog.isDevelopLevel())
          {
            paramQConfItem = new StringBuilder();
            paramQConfItem.append("mUseLocalVoiceRecogUin[");
            paramQConfItem.append(localAvGameConfBean.d);
            paramQConfItem.append("]");
            QLog.i("AvGameConfBean", 4, paramQConfItem.toString());
          }
        }
        if (localJSONObject.has("enableAINSUin"))
        {
          localAvGameConfBean.g = localJSONObject.optInt("enableAINSUin");
          if (QLog.isColorLevel())
          {
            paramQConfItem = new StringBuilder();
            paramQConfItem.append("mEnableAINSUin [");
            paramQConfItem.append(localAvGameConfBean.g);
            paramQConfItem.append("]");
            QLog.d("AvGameConfBean", 2, paramQConfItem.toString());
          }
        }
        if (localJSONObject.has("voiceRecogModelStrategy"))
        {
          paramQConfItem = localJSONObject.optJSONObject("voiceRecogModelStrategy");
          localAvGameConfBean.e = paramQConfItem.optInt("wxModelUin");
          double d1 = paramQConfItem.optDouble("ailabSceneWordsTh", -1.0D);
          if (d1 > 0.0D) {
            localAvGameConfBean.jdField_a_of_type_Double = d1;
          }
          if (QLog.isColorLevel())
          {
            paramQConfItem = new StringBuilder();
            paramQConfItem.append("mWXVoiceRecogUin [");
            paramQConfItem.append(localAvGameConfBean.e);
            paramQConfItem.append("] mAILabSceneWordsTh :");
            paramQConfItem.append(localAvGameConfBean.jdField_a_of_type_Double);
            QLog.i("AvGameConfBean", 2, paramQConfItem.toString());
          }
        }
        localAvGameConfBean.c(localJSONObject.optInt("questionTimeout", 100));
        localAvGameConfBean.f(localJSONObject.optString("conveneBottomTip", ""));
        localAvGameConfBean.a(localJSONObject.optDouble("pkBGMProportion", 0.5D));
        return localAvGameConfBean;
      }
      catch (Exception paramQConfItem)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("parse error->");
          ((StringBuilder)localObject1).append(paramQConfItem.toString());
          QLog.e("AvGameConfBean", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
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
  
  public int a(long paramLong)
  {
    int i = this.d;
    if ((i > -1) && (paramLong % 10L <= i))
    {
      if (paramLong % 100L > this.e) {
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  public MachineLevelLine a()
  {
    return this.jdField_a_of_type_ComTencentAvUtilsMachineMachineLevelLine;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    HashMap localHashMap = this.jdField_b_of_type_JavaUtilHashMap;
    if (localHashMap == null) {
      return null;
    }
    return (String)localHashMap.get(paramString);
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
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap == null) {
      return null;
    }
    return (List)localHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(double paramDouble)
  {
    Double localDouble = new Double(paramDouble);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mPkBGMProportion [");
      localStringBuilder.append(localDouble.floatValue());
      localStringBuilder.append("]");
      QLog.i("AvGameConfBean", 2, localStringBuilder.toString());
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
    int i = this.d;
    boolean bool = false;
    if ((i > -1) && (paramLong % 10L <= i)) {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isUseLocalVoiceRecog. mUseLocalVoiceRecogUin = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", useLocalVoiceRecog = ");
    localStringBuilder.append(bool);
    QLog.i("AvGameConfBean", 1, localStringBuilder.toString());
    return bool;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public MachineLevelLine b()
  {
    return this.jdField_b_of_type_ComTencentAvUtilsMachineMachineLevelLine;
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
    boolean bool = false;
    if (paramLong < 0L) {
      return false;
    }
    if (paramLong % 10L <= this.g) {
      bool = true;
    }
    return bool;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public MachineLevelLine c()
  {
    return this.jdField_c_of_type_ComTencentAvUtilsMachineMachineLevelLine;
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
    this.jdField_a_of_type_ComTencentAvUtilsMachineMachineLevelLine.a(paramString);
  }
  
  void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setMiddleMachineLevel str EMPTY");
      return;
    }
    this.jdField_b_of_type_ComTencentAvUtilsMachineMachineLevelLine.a(paramString);
  }
  
  void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setLowMachineLevel str EMPTY");
      return;
    }
    this.jdField_c_of_type_ComTencentAvUtilsMachineMachineLevelLine.a(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.config.data.AvGameConfBean
 * JD-Core Version:    0.7.0.1
 */