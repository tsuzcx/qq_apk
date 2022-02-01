package com.tencent.mobileqq.activity.qwallet.red;

import aktk;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class QWRedConfig$PathInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String path;
  public List<QWRedConfig.RedInfo> redInfos = new LinkedList();
  
  public static PathInfo parseToPathInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        String str = paramJSONObject.optString("path");
        if (!TextUtils.isEmpty(str))
        {
          PathInfo localPathInfo = new PathInfo();
          localPathInfo.path = str;
          paramJSONObject = paramJSONObject.optJSONArray("infos");
          if (paramJSONObject != null)
          {
            int i = 0;
            while (i < paramJSONObject.length())
            {
              QWRedConfig.RedInfo localRedInfo = QWRedConfig.RedInfo.parseToRedInfo(paramJSONObject.optJSONObject(i), str);
              if (localRedInfo != null) {
                localPathInfo.redInfos.add(localRedInfo);
              }
              i += 1;
            }
          }
          return localPathInfo;
        }
      }
      catch (Throwable paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return null;
  }
  
  public List<QWRedConfig.RedInfo> getCurShowRedInfos()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.redInfos.iterator();
    int j = 0;
    int i = 0;
    QWRedConfig.RedInfo localRedInfo;
    if (localIterator.hasNext())
    {
      localRedInfo = (QWRedConfig.RedInfo)localIterator.next();
      if (!localRedInfo.isShow()) {
        break label132;
      }
      if ((localRedInfo.showPos != 2) || (i != 0)) {
        break label92;
      }
      localLinkedList.add(localRedInfo);
      i = j;
      j = 1;
    }
    for (;;)
    {
      if ((j != 0) && (i != 0))
      {
        return localLinkedList;
        label92:
        if ((localRedInfo.showPos == 0) && (j == 0))
        {
          localLinkedList.add(localRedInfo);
          k = 1;
          j = i;
          i = k;
        }
      }
      else
      {
        k = j;
        j = i;
        i = k;
        break;
      }
      label132:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public aktk getShowInfo()
  {
    Iterator localIterator = this.redInfos.iterator();
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject3 = (QWRedConfig.RedInfo)localIterator.next();
      if (((QWRedConfig.RedInfo)localObject3).isShow()) {
        if (((QWRedConfig.RedInfo)localObject3).type == 0)
        {
          if (bool1) {
            break label162;
          }
          localObject3 = ((QWRedConfig.RedInfo)localObject3).buffer;
          bool1 = bool2;
          bool2 = true;
          localObject2 = localObject1;
          localObject1 = localObject3;
          label84:
          if ((!bool2) || (!bool1)) {
            break label141;
          }
        }
      }
    }
    for (;;)
    {
      return new aktk(bool2, bool1, (String)localObject2, (String)localObject1);
      if ((((QWRedConfig.RedInfo)localObject3).type == 3) && (!bool2))
      {
        localObject3 = ((QWRedConfig.RedInfo)localObject3).content;
        localObject1 = localObject2;
        bool2 = bool1;
        localObject2 = localObject3;
        bool1 = true;
        break label84;
        label141:
        bool3 = bool2;
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        bool2 = bool1;
        bool1 = bool3;
        break;
      }
      label162:
      localObject3 = localObject1;
      boolean bool3 = bool1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      bool1 = bool2;
      bool2 = bool3;
      break label84;
      localObject3 = localObject1;
      bool3 = bool1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      bool1 = bool2;
      bool2 = bool3;
    }
  }
  
  public boolean isMatchPath(String paramString)
  {
    return (this.path.equals(paramString)) || (this.path.endsWith("." + paramString));
  }
  
  public boolean isShow()
  {
    Iterator localIterator = this.redInfos.iterator();
    while (localIterator.hasNext()) {
      if (((QWRedConfig.RedInfo)localIterator.next()).isShow()) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return "PathInfo{path='" + this.path + '\'' + ", redInfos=" + this.redInfos + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWRedConfig.PathInfo
 * JD-Core Version:    0.7.0.1
 */