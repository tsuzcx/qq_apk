package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class ProteusParserWithHotReload$ProteusBroadCastReceiver
  extends BroadcastReceiver
{
  ProteusParserWithHotReload$ProteusBroadCastReceiver(ProteusParserWithHotReload paramProteusParserWithHotReload) {}
  
  private void getNewPathAndHotReload(Context paramContext, String paramString, ArrayList<String> paramArrayList)
  {
    Object localObject1 = paramString.replace("^#^", "/");
    ProteusParserWithHotReload.access$300(this.this$0).put(localObject1, paramString);
    if (((String)localObject1).endsWith("style_map.geojson")) {
      return;
    }
    if (ProteusParserWithHotReload.access$400(this.this$0).containsKey(localObject1)) {
      localObject1 = ((ArrayList)ProteusParserWithHotReload.access$400(this.this$0).get(localObject1)).iterator();
    }
    for (;;)
    {
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (paramArrayList.contains(localObject2)) {
          continue;
        }
        paramArrayList.add(localObject2);
      }
      try
      {
        hotReloadByFilePath(paramContext, (String)localObject2);
        continue;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" proteus hot-reload file not found error: ");
        ((StringBuilder)localObject2).append(ProteusParserWithHotReload.access$500());
        ((StringBuilder)localObject2).append(paramString);
        LogUtil.QLog.e("readinjoy.proteus", 2, ((StringBuilder)localObject2).toString());
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" proteus hot-reload json error: ");
        localStringBuilder.append(localJSONException.toString());
        LogUtil.QLog.e("readinjoy.proteus", 2, localStringBuilder.toString());
        continue;
        if (paramArrayList.contains(localObject1)) {
          return;
        }
        paramArrayList.add(localObject1);
      }
      catch (IOException localIOException)
      {
        try
        {
          hotReloadByFilePath(paramContext, (String)localObject1);
          return;
          label237:
          paramContext = new StringBuilder();
          paramContext.append(" proteus hot-reload file not found error: ");
          paramContext.append(ProteusParserWithHotReload.access$500());
          paramContext.append(paramString);
          LogUtil.QLog.e("readinjoy.proteus", 2, paramContext.toString());
          return;
        }
        catch (JSONException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(" proteus hot-reload json error: ");
          paramString.append(paramContext.toString());
          LogUtil.QLog.e("readinjoy.proteus", 2, paramString.toString());
          return;
          localIOException = localIOException;
        }
        catch (IOException paramContext)
        {
          break label237;
        }
      }
    }
  }
  
  private void hotReloadByFilePath(Context paramContext, String paramString)
  {
    Object localObject = new JSONObject(this.this$0.getJsonStringFromFile(paramContext, paramString));
    if (((JSONObject)localObject).keys().hasNext()) {
      localObject = (String)((JSONObject)localObject).keys().next();
    } else {
      localObject = "";
    }
    int i = 0;
    while (i < ProteusParserWithHotReload.access$600(this.this$0).size())
    {
      ((ProteusParserWithHotReload.IHotReloadChangedObserver)ProteusParserWithHotReload.access$600(this.this$0).get(i)).onHotReloadChanged(paramContext, (String)localObject, paramString);
      i += 1;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!ProteusParserWithHotReload.access$200(this.this$0)) {
      return;
    }
    paramIntent = paramIntent.getStringExtra("file_path").split(";");
    ArrayList localArrayList = new ArrayList();
    int j = paramIntent.length;
    int i = 0;
    while (i < j)
    {
      getNewPathAndHotReload(paramContext, paramIntent[i], localArrayList);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.ProteusBroadCastReceiver
 * JD-Core Version:    0.7.0.1
 */