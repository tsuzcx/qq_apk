package com.example.tissue;

import android.os.Looper;
import android.util.Log;
import com.tencent.tissue.miniapp.IJsService;
import com.tencent.tissue.miniapp.hdasync.HdAsyncAction;
import com.tencent.tissue.miniapp.hdasync.HdAsyncResult;
import com.tencent.tissue.v8rt.engine.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ApiBridge$1$4
  extends HdAsyncAction
{
  ApiBridge$1$4(ApiBridge.1 param1, Looper paramLooper, List paramList, String paramString1, String paramString2)
  {
    super(paramLooper);
  }
  
  public HdAsyncResult call(Object paramObject)
  {
    paramObject = "(";
    int i = 0;
    Object localObject1;
    if (i < this.val$methodArguments.size()) {
      if ((this.val$methodArguments.get(i) instanceof Integer))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramObject);
        ((StringBuilder)localObject1).append(this.val$methodArguments.get(i).toString());
        paramObject = ((StringBuilder)localObject1).toString();
      }
    }
    for (;;)
    {
      localObject1 = paramObject;
      if (i < this.val$methodArguments.size() - 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramObject);
        ((StringBuilder)localObject1).append(",");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      i += 1;
      paramObject = localObject1;
      break;
      if ((this.val$methodArguments.get(i) instanceof String))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramObject);
        ((StringBuilder)localObject1).append('"');
        ((StringBuilder)localObject1).append(this.val$methodArguments.get(i).toString());
        ((StringBuilder)localObject1).append('"');
        paramObject = ((StringBuilder)localObject1).toString();
      }
      else
      {
        Object localObject2;
        if ((this.val$methodArguments.get(i) instanceof Map))
        {
          localObject1 = new JSONObject((Map)this.val$methodArguments.get(i));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramObject);
          ((StringBuilder)localObject2).append(' ');
          ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
          ((StringBuilder)localObject2).append(' ');
          paramObject = ((StringBuilder)localObject2).toString();
        }
        else if ((this.val$methodArguments.get(i) instanceof List))
        {
          localObject1 = new JSONArray((List)this.val$methodArguments.get(i));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramObject);
          ((StringBuilder)localObject2).append(' ');
          ((StringBuilder)localObject2).append(((JSONArray)localObject1).toString());
          ((StringBuilder)localObject2).append(' ');
          paramObject = ((StringBuilder)localObject2).toString();
          continue;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramObject);
          ((StringBuilder)localObject1).append(")");
          paramObject = ((StringBuilder)localObject1).toString();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("JSON.stringify(");
          ((StringBuilder)localObject1).append(this.val$module);
          ((StringBuilder)localObject1).append(".exports.");
          ((StringBuilder)localObject1).append(this.val$method);
          ((StringBuilder)localObject1).append(paramObject);
          ((StringBuilder)localObject1).append(")");
          localObject1 = ((StringBuilder)localObject1).toString();
          paramObject = ApiBridge.access$000(this.this$1.this$0).executeScriptWithReturn(ApiBridge.access$100(this.this$1.this$0), (String)localObject1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("loadWXSScriptAndReturn runJS: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          Log.w("ApiBridge", ((StringBuilder)localObject2).toString());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("loadWXSScriptAndReturn return: ");
          ((StringBuilder)localObject1).append(paramObject);
          Log.w("ApiBridge", ((StringBuilder)localObject1).toString());
          HashMap localHashMap;
          try
          {
            if ((paramObject instanceof String))
            {
              localObject1 = (String)paramObject;
              if ((((String)localObject1).startsWith("\"")) && (((String)localObject1).endsWith("\""))) {
                return doNext(true, ((String)localObject1).substring(1, ((String)localObject1).length() - 1));
              }
              if ((((String)localObject1).startsWith("{")) && (((String)localObject1).endsWith("}")))
              {
                localObject1 = new JSONObject((String)localObject1);
                localObject2 = ((JSONObject)localObject1).keys();
                localHashMap = new HashMap();
                while (((Iterator)localObject2).hasNext())
                {
                  String str = (String)((Iterator)localObject2).next();
                  localHashMap.put(str, ((JSONObject)localObject1).getString(str));
                }
              }
            }
            else
            {
              return doNext(true, paramObject);
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          for (;;)
          {
            return doNext(true, localHashMap);
            if ((localJSONException.startsWith("[")) && (localJSONException.endsWith("]"))) {
              Logger.w("ApiBridge", "javascript array not handled");
            } else if ((localJSONException.equals("true")) || (localJSONException.equals("false"))) {
              Logger.w("ApiBridge", "javascript boolean not handled");
            } else if (localJSONException.equals("null")) {
              Logger.w("ApiBridge", "javascript null not handled");
            } else if (localJSONException.matches("^-?\\d+")) {
              Logger.w("ApiBridge", "javascript number not handled");
            } else {
              Logger.w("ApiBridge", "unknown return data types");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.ApiBridge.1.4
 * JD-Core Version:    0.7.0.1
 */