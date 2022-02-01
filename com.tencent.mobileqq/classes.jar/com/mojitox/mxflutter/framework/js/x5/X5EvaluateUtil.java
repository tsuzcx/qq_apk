package com.mojitox.mxflutter.framework.js.x5;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.mojitox.mxflutter.framework.utils.MxLog;
import java.io.File;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class X5EvaluateUtil
{
  @Nullable
  public static Object a(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof Map)) {
      localObject = new JSONObject((Map)paramObject).toString();
    }
    return localObject;
  }
  
  @Nullable
  public static String b(Object paramObject)
  {
    for (;;)
    {
      try
      {
        if ((paramObject instanceof Map))
        {
          paramObject = new JSONObject((Map)paramObject);
        }
        else
        {
          if (!(paramObject instanceof String)) {
            break label78;
          }
          paramObject = new JSONObject((String)paramObject);
        }
        if ((paramObject != null) && (paramObject.has("method")))
        {
          paramObject = paramObject.getString("method");
          return paramObject;
        }
      }
      catch (JSONException paramObject)
      {
        MxLog.b("getJsonMethodName", paramObject.getMessage());
      }
      return null;
      label78:
      paramObject = null;
    }
  }
  
  @Nullable
  public static String c(Object paramObject)
  {
    for (;;)
    {
      try
      {
        if ((paramObject instanceof Map))
        {
          paramObject = new JSONObject((Map)paramObject);
        }
        else
        {
          if (!(paramObject instanceof String)) {
            break label204;
          }
          paramObject = new JSONObject((String)paramObject);
        }
        if ((paramObject != null) && (paramObject.has("arguments")))
        {
          paramObject = paramObject.getJSONObject("arguments");
          if (paramObject.has("widgetName"))
          {
            String str = paramObject.getString("widgetName");
            if (paramObject.has("bizPath")) {
              paramObject = paramObject.getString("bizPath");
            } else {
              paramObject = "";
            }
            Object localObject = paramObject;
            if (!TextUtils.isEmpty(paramObject))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramObject);
              ((StringBuilder)localObject).append(File.separator);
              localObject = ((StringBuilder)localObject).toString();
            }
            paramObject = new StringBuilder();
            paramObject.append("./");
            paramObject.append((String)localObject);
            paramObject.append(str);
            paramObject.append("/bundle-");
            paramObject.append(str);
            paramObject.append(".js");
            paramObject = paramObject.toString();
            return paramObject;
          }
        }
      }
      catch (JSONException paramObject)
      {
        MxLog.b("getRequirePath", paramObject.getMessage());
      }
      return null;
      label204:
      paramObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5EvaluateUtil
 * JD-Core Version:    0.7.0.1
 */