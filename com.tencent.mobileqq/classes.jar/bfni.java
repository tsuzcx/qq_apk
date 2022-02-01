import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bfni
{
  private String jdField_a_of_type_JavaLangString = "";
  private HashMap<Integer, bfnk> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private TreeMap<Integer, Integer> jdField_a_of_type_JavaUtilTreeMap = new TreeMap();
  private String jdField_b_of_type_JavaLangString = "";
  private HashMap<Integer, bfnh> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private String c = "";
  
  public static bfni a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberLevelMapConfig", 2, "content : " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    TreeMap localTreeMap = new TreeMap();
    String str2 = "";
    String str1 = "";
    ArrayList localArrayList = new ArrayList();
    localObject3 = str1;
    localObject1 = str2;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localObject3 = str1;
      localObject1 = str2;
      paramString = localJSONObject.getJSONArray("grayTroopUins");
      int i;
      if (paramString != null)
      {
        localObject3 = str1;
        localObject1 = str2;
        if (paramString.length() > 0)
        {
          i = 0;
          for (;;)
          {
            localObject3 = str1;
            localObject1 = str2;
            if (i >= paramString.length()) {
              break;
            }
            localObject3 = str1;
            localObject1 = str2;
            localArrayList.add(Integer.valueOf(paramString.getInt(i)));
            i += 1;
          }
        }
      }
      localObject3 = str1;
      localObject1 = str2;
      paramString = localJSONObject.getJSONArray("troopMemberLevelMap");
      if (paramString != null)
      {
        localObject3 = str1;
        localObject1 = str2;
        if (paramString.length() > 0)
        {
          i = 0;
          for (;;)
          {
            localObject3 = str1;
            localObject1 = str2;
            if (i >= paramString.length()) {
              break;
            }
            localObject3 = str1;
            localObject1 = str2;
            localObject2 = paramString.getJSONObject(i);
            localObject3 = str1;
            localObject1 = str2;
            localObject4 = new bfnk(((JSONObject)localObject2).getInt("begin"), ((JSONObject)localObject2).getInt("end"), ((JSONObject)localObject2).getInt("rankid"), ((JSONObject)localObject2).getString("rankname"));
            localObject3 = str1;
            localObject1 = str2;
            localHashMap1.put(Integer.valueOf(((JSONObject)localObject2).getInt("rankid")), localObject4);
            i += 1;
          }
        }
      }
      localObject3 = str1;
      localObject1 = str2;
      paramString = localJSONObject.getJSONArray("titleBackgroundColor");
      if (paramString != null)
      {
        localObject3 = str1;
        localObject1 = str2;
        if (paramString.length() > 0)
        {
          i = 0;
          for (;;)
          {
            localObject3 = str1;
            localObject1 = str2;
            if (i >= paramString.length()) {
              break;
            }
            localObject3 = str1;
            localObject1 = str2;
            localObject2 = paramString.getJSONObject(i);
            localObject3 = str1;
            localObject1 = str2;
            localObject4 = new bfnh(((JSONObject)localObject2).getInt("titleId"), ((JSONObject)localObject2).getString("start"), ((JSONObject)localObject2).getString("end"));
            localObject3 = str1;
            localObject1 = str2;
            localHashMap2.put(Integer.valueOf(((JSONObject)localObject2).getInt("titleId")), localObject4);
            i += 1;
          }
        }
      }
      localObject3 = str1;
      localObject1 = str2;
      paramString = localJSONObject.getJSONArray("oldLevelToNewLevelMap");
      if (paramString != null)
      {
        localObject3 = str1;
        localObject1 = str2;
        if (paramString.length() > 0)
        {
          i = 0;
          for (;;)
          {
            localObject3 = str1;
            localObject1 = str2;
            if (i >= paramString.length()) {
              break;
            }
            localObject3 = str1;
            localObject1 = str2;
            localObject2 = paramString.getJSONObject(i);
            localObject3 = str1;
            localObject1 = str2;
            localTreeMap.put(Integer.valueOf(((JSONObject)localObject2).getInt("old")), Integer.valueOf(((JSONObject)localObject2).getInt("new")));
            i += 1;
          }
        }
      }
      localObject3 = str1;
      localObject1 = str2;
      Object localObject4 = localJSONObject.getJSONObject("onlyLevelBackgroundColor");
      localObject2 = str1;
      paramString = str2;
      if (localObject4 != null)
      {
        localObject3 = str1;
        localObject1 = str2;
        paramString = ((JSONObject)localObject4).getString("start");
        localObject3 = str1;
        localObject1 = paramString;
        localObject2 = ((JSONObject)localObject4).getString("end");
      }
      localObject3 = localObject2;
      localObject1 = paramString;
      str1 = localJSONObject.getString("newGroupMemberLevelJumpUrl");
      localObject1 = str1;
      if (localObject1 == null) {
        break label756;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        Object localObject2 = localObject3;
        paramString = "";
        localObject3 = localObject1;
        continue;
        localObject1 = "";
      }
    }
    localObject3 = paramString;
    paramString = (String)localObject1;
    localObject1 = new bfni();
    ((bfni)localObject1).jdField_a_of_type_JavaUtilHashMap = localHashMap1;
    ((bfni)localObject1).jdField_b_of_type_JavaUtilHashMap = localHashMap2;
    ((bfni)localObject1).jdField_a_of_type_JavaUtilList = localArrayList;
    ((bfni)localObject1).jdField_a_of_type_JavaUtilTreeMap = localTreeMap;
    ((bfni)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
    ((bfni)localObject1).jdField_b_of_type_JavaLangString = ((String)localObject2);
    ((bfni)localObject1).c = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberLevelMapConfig", 2, "levelMap.size : " + localHashMap1.size() + ",levelColorMap.size :" + localHashMap2.size() + ", tempGrayList.size :" + localArrayList.size());
    }
    return localObject1;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
      localObject = (bfnk)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    } while ((((bfnk)localObject).jdField_a_of_type_Int > paramInt) || (paramInt > ((bfnk)localObject).b));
    for (paramInt = ((bfnk)localObject).c;; paramInt = 0) {
      return paramInt;
    }
  }
  
  public String a()
  {
    return this.c;
  }
  
  public String a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelMapConfig", 2, "getRankNameByLevel levelMap is null");
      }
      return "";
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (Integer)((Iterator)localObject1).next();
      localObject2 = (bfnk)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
    } while ((localObject2 == null) || (((bfnk)localObject2).jdField_a_of_type_Int > paramInt) || (((bfnk)localObject2).b < paramInt));
    for (localObject1 = ((bfnk)localObject2).jdField_a_of_type_JavaLangString;; localObject1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelMapConfig", 2, "getRankNameByLevel strRankName = " + (String)localObject1);
      }
      return localObject1;
    }
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.c);
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberLevelMapConfig", 2, "isGrayTroop troopUin = " + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilList == null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("grayTroopUinList is null ? ");
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label96;
        }
      }
      for (;;)
      {
        QLog.d("TroopMemberLevelMapConfig", 2, bool1);
        bool2 = false;
        return bool2;
        label96:
        bool1 = false;
      }
    }
    paramString = paramString.substring(paramString.length() - 1);
    int i = 0;
    label114:
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (!String.valueOf(this.jdField_a_of_type_JavaUtilList.get(i)).equals(paramString)) {}
    }
    for (bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopMemberLevelMapConfig", 2, "isGrayTroop isGrayTroop = " + bool1);
      return bool1;
      i += 1;
      break label114;
    }
  }
  
  public int[] a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      return null;
    }
    return new int[] { Color.parseColor(this.jdField_a_of_type_JavaLangString), Color.parseColor(this.jdField_b_of_type_JavaLangString) };
  }
  
  public int[] a(int paramInt)
  {
    Object localObject = (bfnh)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      String str = ((bfnh)localObject).jdField_a_of_type_JavaLangString;
      localObject = ((bfnh)localObject).jdField_b_of_type_JavaLangString;
      return new int[] { Color.parseColor(str), Color.parseColor((String)localObject) };
    }
    return null;
  }
  
  public int b(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilTreeMap == null) || (this.jdField_a_of_type_JavaUtilTreeMap.size() == 0)) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int i = ((Integer)localEntry.getKey()).intValue();
      int j = ((Integer)localEntry.getValue()).intValue();
      if (paramInt == i) {
        return j;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfni
 * JD-Core Version:    0.7.0.1
 */