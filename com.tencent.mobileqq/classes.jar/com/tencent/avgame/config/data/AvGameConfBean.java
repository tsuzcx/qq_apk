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
  private int a = 0;
  private String b = "";
  private String c = "";
  private HashMap<Integer, List<String>> d = new HashMap();
  private HashMap<String, String> e = new HashMap();
  private ArrayList<AvGameConfBean.RecordParam> f = new ArrayList(5);
  private ArrayList<String> g = new ArrayList();
  private MachineLevelLine h = new MachineLevelLine(AvGameMachineLevelUtils.a);
  private MachineLevelLine i = new MachineLevelLine(AvGameMachineLevelUtils.b);
  private MachineLevelLine j = new MachineLevelLine(AvGameMachineLevelUtils.c);
  private int k = 0;
  private int l = 0;
  private boolean m = false;
  private int n = -1;
  private int o = -1;
  private double p = 0.0D;
  private int q = 100;
  private int r = -1;
  private String s = "";
  private float t = 0.5F;
  
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
        ((StringBuilder)localObject1).append(paramQConfItem.a);
        ((StringBuilder)localObject1).append(" content->");
        ((StringBuilder)localObject1).append(paramQConfItem.b);
        QLog.d("AvGameConfBean", 2, ((StringBuilder)localObject1).toString());
      }
      try
      {
        JSONObject localJSONObject = new JSONObject(paramQConfItem.b);
        localAvGameConfBean.a(localJSONObject.optInt("ifShow", 0));
        localAvGameConfBean.a(localJSONObject.optString("resUrl", ""));
        localAvGameConfBean.b(localJSONObject.optString("resMd5", ""));
        localAvGameConfBean.b(localJSONObject.optInt("quitTime", 0));
        boolean bool = QLog.isDevelopLevel();
        if (bool)
        {
          paramQConfItem = new StringBuilder();
          paramQConfItem.append("mLoadingEnableExitTime[");
          paramQConfItem.append(localAvGameConfBean.l);
          paramQConfItem.append("]");
          QLog.d("AvGameConfBean", 4, paramQConfItem.toString());
        }
        paramQConfItem = localJSONObject.optJSONObject("androidMachineLevels");
        if (paramQConfItem != null)
        {
          localAvGameConfBean.d(paramQConfItem.optString("high", ""));
          localAvGameConfBean.e(paramQConfItem.optString("middle", ""));
          localAvGameConfBean.f(paramQConfItem.optString("low", ""));
        }
        paramQConfItem = localJSONObject.getJSONArray("gameBgMusic");
        int i1 = 0;
        while (i1 < paramQConfItem.length())
        {
          localObject1 = paramQConfItem.getJSONObject(i1);
          int i3 = ((JSONObject)localObject1).getInt("type");
          localObject1 = ((JSONObject)localObject1).getJSONArray("nameList");
          ArrayList localArrayList = new ArrayList();
          int i2 = 0;
          while (i2 < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).getJSONObject(i2);
            String str = ((JSONObject)localObject2).optString("name", "");
            localObject2 = ((JSONObject)localObject2).optString("proportion", "");
            localArrayList.add(str);
            localAvGameConfBean.a(str, (String)localObject2);
            i2 += 1;
          }
          localAvGameConfBean.a(i3, localArrayList);
          i1 += 1;
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
          localAvGameConfBean.k = localJSONObject.optInt("disableSmallPicFlag");
          if (QLog.isDevelopLevel())
          {
            paramQConfItem = new StringBuilder();
            paramQConfItem.append("disableSmallPicFlag[");
            paramQConfItem.append(localAvGameConfBean.k);
            paramQConfItem.append("]");
            QLog.i("AvGameConfBean", 4, paramQConfItem.toString());
          }
        }
        paramQConfItem = localJSONObject.optJSONArray("aioText");
        if ((paramQConfItem != null) && (paramQConfItem.length() > 0))
        {
          localObject1 = new ArrayList(paramQConfItem.length());
          i1 = 0;
          while (i1 < paramQConfItem.length())
          {
            ((ArrayList)localObject1).add(paramQConfItem.optString(i1, ""));
            i1 += 1;
          }
          localAvGameConfBean.a((ArrayList)localObject1);
        }
        bool = false;
        if (localJSONObject.optInt("isShowMatch", 0) == 1) {
          bool = true;
        }
        localAvGameConfBean.m = bool;
        if (localJSONObject.has("useLocalVoiceRecogUin"))
        {
          localAvGameConfBean.n = localJSONObject.optInt("useLocalVoiceRecogUin");
          if (QLog.isDevelopLevel())
          {
            paramQConfItem = new StringBuilder();
            paramQConfItem.append("mUseLocalVoiceRecogUin[");
            paramQConfItem.append(localAvGameConfBean.n);
            paramQConfItem.append("]");
            QLog.i("AvGameConfBean", 4, paramQConfItem.toString());
          }
        }
        if (localJSONObject.has("enableAINSUin"))
        {
          localAvGameConfBean.r = localJSONObject.optInt("enableAINSUin");
          if (QLog.isColorLevel())
          {
            paramQConfItem = new StringBuilder();
            paramQConfItem.append("mEnableAINSUin [");
            paramQConfItem.append(localAvGameConfBean.r);
            paramQConfItem.append("]");
            QLog.d("AvGameConfBean", 2, paramQConfItem.toString());
          }
        }
        if (localJSONObject.has("voiceRecogModelStrategy"))
        {
          paramQConfItem = localJSONObject.optJSONObject("voiceRecogModelStrategy");
          localAvGameConfBean.o = paramQConfItem.optInt("wxModelUin");
          double d1 = paramQConfItem.optDouble("ailabSceneWordsTh", -1.0D);
          if (d1 > 0.0D) {
            localAvGameConfBean.p = d1;
          }
          if (QLog.isColorLevel())
          {
            paramQConfItem = new StringBuilder();
            paramQConfItem.append("mWXVoiceRecogUin [");
            paramQConfItem.append(localAvGameConfBean.o);
            paramQConfItem.append("] mAILabSceneWordsTh :");
            paramQConfItem.append(localAvGameConfBean.p);
            QLog.i("AvGameConfBean", 2, paramQConfItem.toString());
          }
        }
        localAvGameConfBean.d(localJSONObject.optInt("questionTimeout", 100));
        localAvGameConfBean.g(localJSONObject.optString("conveneBottomTip", ""));
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
    this.t = localDouble.floatValue();
  }
  
  void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  void a(int paramInt, List<String> paramList)
  {
    this.d.put(Integer.valueOf(paramInt), paramList);
  }
  
  public void a(AvGameConfBean.RecordParam paramRecordParam)
  {
    this.f.add(paramRecordParam);
  }
  
  void a(String paramString)
  {
    this.b = paramString;
  }
  
  void a(String paramString1, String paramString2)
  {
    this.e.put(paramString1, paramString2);
  }
  
  void a(ArrayList<String> paramArrayList)
  {
    this.g = paramArrayList;
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
  
  public boolean a(long paramLong)
  {
    int i1 = this.n;
    boolean bool = false;
    if ((i1 > -1) && (paramLong % 10L <= i1)) {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isUseLocalVoiceRecog. mUseLocalVoiceRecogUin = ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", useLocalVoiceRecog = ");
    localStringBuilder.append(bool);
    QLog.i("AvGameConfBean", 1, localStringBuilder.toString());
    return bool;
  }
  
  public int b(long paramLong)
  {
    int i1 = this.n;
    if ((i1 > -1) && (paramLong % 10L <= i1))
    {
      if (paramLong % 100L > this.o) {
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  public String b()
  {
    return this.b;
  }
  
  void b(int paramInt)
  {
    this.l = paramInt;
  }
  
  void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String c(String paramString)
  {
    HashMap localHashMap = this.e;
    if (localHashMap == null) {
      return null;
    }
    return (String)localHashMap.get(paramString);
  }
  
  public List<String> c(int paramInt)
  {
    HashMap localHashMap = this.d;
    if (localHashMap == null) {
      return null;
    }
    return (List)localHashMap.get(Integer.valueOf(paramInt));
  }
  
  public boolean c(long paramLong)
  {
    boolean bool = false;
    if (paramLong < 0L) {
      return false;
    }
    if (paramLong % 10L <= this.r) {
      bool = true;
    }
    return bool;
  }
  
  public ArrayList<String> d()
  {
    return this.g;
  }
  
  public void d(int paramInt)
  {
    this.q = paramInt;
  }
  
  void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setHighMachineLevel str EMPTY");
      return;
    }
    this.h.a(paramString);
  }
  
  public MachineLevelLine e()
  {
    return this.h;
  }
  
  void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setMiddleMachineLevel str EMPTY");
      return;
    }
    this.i.a(paramString);
  }
  
  public int f()
  {
    return this.k;
  }
  
  void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setLowMachineLevel str EMPTY");
      return;
    }
    this.j.a(paramString);
  }
  
  public int g()
  {
    return this.l;
  }
  
  public void g(String paramString)
  {
    this.s = paramString;
  }
  
  public MachineLevelLine h()
  {
    return this.i;
  }
  
  public MachineLevelLine i()
  {
    return this.j;
  }
  
  public List<AvGameConfBean.RecordParam> j()
  {
    return this.f;
  }
  
  public boolean k()
  {
    return this.m;
  }
  
  public float l()
  {
    return (float)this.p;
  }
  
  public int m()
  {
    return this.q;
  }
  
  public String n()
  {
    return this.s;
  }
  
  public float o()
  {
    return this.t;
  }
  
  public String toString()
  {
    return String.format("mAvGameShowInPlus:%d ", new Object[] { Integer.valueOf(this.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.config.data.AvGameConfBean
 * JD-Core Version:    0.7.0.1
 */