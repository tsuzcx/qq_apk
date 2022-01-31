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
  
  private void hotReloadByFilePath(Context paramContext, String paramString)
  {
    Object localObject = new JSONObject(this.this$0.getJsonStringFromFile(paramContext, paramString));
    if (((JSONObject)localObject).keys().hasNext()) {}
    for (localObject = (String)((JSONObject)localObject).keys().next();; localObject = "")
    {
      int i = 0;
      while (i < ProteusParserWithHotReload.access$600(this.this$0).size())
      {
        ((ProteusParserWithHotReload.IHotReloadChangedObserver)ProteusParserWithHotReload.access$600(this.this$0).get(i)).onHotReloadChanged(paramContext, (String)localObject, paramString);
        i += 1;
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!ProteusParserWithHotReload.access$200(this.this$0)) {}
    Object localObject;
    for (;;)
    {
      return;
      paramIntent = paramIntent.getStringExtra("file_path");
      localObject = paramIntent.replace("^#^", "/");
      ProteusParserWithHotReload.access$300(this.this$0).put(localObject, paramIntent);
      if (!((String)localObject).endsWith("style_map.geojson"))
      {
        if (!ProteusParserWithHotReload.access$400(this.this$0).containsKey(localObject)) {
          break;
        }
        localObject = ((ArrayList)ProteusParserWithHotReload.access$400(this.this$0).get(localObject)).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          try
          {
            hotReloadByFilePath(paramContext, str);
          }
          catch (JSONException localJSONException)
          {
            LogUtil.QLog.e("readinjoy.proteus", 2, " proteus hot-reload json error: " + localJSONException.toString());
          }
          catch (IOException localIOException)
          {
            LogUtil.QLog.e("readinjoy.proteus", 2, " proteus hot-reload file not found error: " + ProteusParserWithHotReload.access$500() + paramIntent);
          }
        }
      }
    }
    try
    {
      hotReloadByFilePath(paramContext, (String)localObject);
      return;
    }
    catch (JSONException paramContext)
    {
      LogUtil.QLog.e("readinjoy.proteus", 2, " proteus hot-reload json error: " + paramContext.toString());
      return;
    }
    catch (IOException paramContext)
    {
      LogUtil.QLog.e("readinjoy.proteus", 2, " proteus hot-reload file not found error: " + ProteusParserWithHotReload.access$500() + paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.ProteusBroadCastReceiver
 * JD-Core Version:    0.7.0.1
 */