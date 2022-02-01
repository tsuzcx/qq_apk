import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy.AppDownloadListener;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

class blak
  implements bnym
{
  blak(blaj paramblaj) {}
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    Object localObject1;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      localObject1 = blaj.d(this.a).entrySet().iterator();
      label78:
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayList = (Map.Entry)((Iterator)localObject1).next();
        if (paramArrayList != null) {}
        for (paramArrayList = (AsyncResult)paramArrayList.getValue();; paramArrayList = null)
        {
          if (paramArrayList == null) {
            break label78;
          }
          paramArrayList.onReceiveResult(false, null);
          break;
        }
      }
      blaj.d(this.a).clear();
    }
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject2 = (WadlResult)paramArrayList.next();
        localObject1 = ((WadlResult)localObject2).jdField_a_of_type_CooperationWadlIpcWadlParams;
        String str = ((WadlParams)localObject1).a;
        if ((str != null) && (localObject1 != null)) {
          blaj.e(this.a).put(str, localObject1);
        }
        if ((str != null) && (blaj.d(this.a).containsKey(str)))
        {
          localObject1 = (AsyncResult)blaj.d(this.a).remove(str);
          if (localObject1 != null) {
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("appid", str);
              localJSONObject.put("status", ((WadlResult)localObject2).jdField_b_of_type_Int);
              localJSONObject.put("downloadSize", ((WadlResult)localObject2).jdField_b_of_type_Long);
              localJSONObject.put("totalSize", ((WadlResult)localObject2).jdField_a_of_type_Long);
              localJSONObject.put("progress", ((WadlResult)localObject2).jdField_b_of_type_Long * 100L / ((WadlResult)localObject2).jdField_a_of_type_Long);
              if (((WadlResult)localObject2).jdField_a_of_type_CooperationWadlIpcWadlParams != null) {
                localJSONObject.put("versionCode", ((WadlResult)localObject2).jdField_a_of_type_CooperationWadlIpcWadlParams.e);
              }
              if (((WadlResult)localObject2).jdField_b_of_type_Int == 6)
              {
                localObject2 = ((WadlResult)localObject2).jdField_b_of_type_JavaLangString;
                if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists()))
                {
                  localJSONObject.put("status", 0);
                  localJSONObject.put("progress", 0);
                }
              }
              ((AsyncResult)localObject1).onReceiveResult(true, localJSONObject);
            }
            catch (Throwable localThrowable)
            {
              ((AsyncResult)localObject1).onReceiveResult(false, null);
            }
          }
        }
      }
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList) {}
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams == null)) {
      bkad.a("ThirdAppProxyImpl", "onWadlTaskStatusChanged error wadlResult is null");
    }
    String str;
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            WadlParams localWadlParams = paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams;
            str = localWadlParams.a;
            i = bkan.a(paramWadlResult.jdField_b_of_type_Int);
            bkai.b(localWadlParams.a);
            QLog.i("ThirdAppProxyImpl", 1, "onWadlTaskStatusChanged:" + paramWadlResult + ",localStatus:" + i);
            switch (i)
            {
            case 3: 
            case 9: 
            case 10: 
            case 20: 
            default: 
              QLog.e("ThirdAppProxyImpl", 1, "download status not response!");
              return;
            case 4: 
              blaj.a(this.a).remove(str);
              if ((blaj.b(this.a) != null) && (blaj.b(this.a).containsKey(str)) && (blaj.b(this.a).get(str) != null)) {
                ((ThirdAppProxy.AppDownloadListener)blaj.b(this.a).get(str)).onDownloadComplete();
              }
              blaj.b(this.a).remove(str);
              return;
            }
          } while (!blaj.c(this.a).containsKey(str));
          paramWadlResult = (AsyncResult)blaj.c(this.a).remove(str);
        } while (paramWadlResult == null);
        paramWadlResult.onReceiveResult(true, null);
        return;
        i = bkan.b(paramWadlResult.c);
        bkan.a(i);
        blaj.a(this.a).remove(str);
        if ((blaj.b(this.a) != null) && (blaj.b(this.a).containsKey(str)) && (blaj.b(this.a).get(str) != null)) {
          ((ThirdAppProxy.AppDownloadListener)blaj.b(this.a).get(str)).onDownloadFailed(i, i, "failed");
        }
        blaj.b(this.a).remove(str);
        return;
      } while ((blaj.b(this.a) == null) || (!blaj.b(this.a).containsKey(str)) || (blaj.b(this.a).get(str) == null));
      i = 0;
      if (blaj.a(this.a).containsKey(str)) {
        i = ((Integer)blaj.a(this.a).get(str)).intValue();
      }
      j = (int)(paramWadlResult.jdField_b_of_type_Long * 100L / paramWadlResult.jdField_a_of_type_Long);
    } while (j - i < 1);
    ((ThirdAppProxy.AppDownloadListener)blaj.b(this.a).get(str)).onDownloadProgress(paramWadlResult.jdField_b_of_type_Long, paramWadlResult.jdField_a_of_type_Long, j);
    blaj.a(this.a).put(str, Integer.valueOf(j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blak
 * JD-Core Version:    0.7.0.1
 */