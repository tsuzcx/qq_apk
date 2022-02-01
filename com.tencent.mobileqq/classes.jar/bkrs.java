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

class bkrs
  implements bmqi
{
  bkrs(bkrr parambkrr) {}
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      localIterator = bkrr.d(this.a).entrySet().iterator();
      label78:
      while (localIterator.hasNext())
      {
        paramArrayList = (Map.Entry)localIterator.next();
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
      bkrr.d(this.a).clear();
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    label96:
    WadlResult localWadlResult;
    Object localObject;
    if (localIterator.hasNext())
    {
      localWadlResult = (WadlResult)localIterator.next();
      localObject = localWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams;
      if (localObject == null) {
        break label370;
      }
    }
    label370:
    for (paramArrayList = ((WadlParams)localObject).a;; paramArrayList = null)
    {
      for (;;)
      {
        if ((paramArrayList != null) && (localObject != null)) {
          bkrr.e(this.a).put(paramArrayList, localObject);
        }
        if ((paramArrayList == null) || (!bkrr.d(this.a).containsKey(paramArrayList))) {
          break;
        }
        localObject = (AsyncResult)bkrr.d(this.a).remove(paramArrayList);
        if (localObject == null) {
          break;
        }
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("appid", paramArrayList);
          localJSONObject.put("status", localWadlResult.jdField_b_of_type_Int);
          localJSONObject.put("downloadSize", localWadlResult.jdField_b_of_type_Long);
          localJSONObject.put("totalSize", localWadlResult.jdField_a_of_type_Long);
          localJSONObject.put("progress", localWadlResult.jdField_b_of_type_Long * 100L / localWadlResult.jdField_a_of_type_Long);
          if (localWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams != null) {
            localJSONObject.put("versionCode", localWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams.e);
          }
          if (localWadlResult.jdField_b_of_type_Int == 6)
          {
            paramArrayList = localWadlResult.jdField_b_of_type_JavaLangString;
            if ((TextUtils.isEmpty(paramArrayList)) || (!new File(paramArrayList).exists()))
            {
              localJSONObject.put("status", 0);
              localJSONObject.put("progress", 0);
            }
          }
          ((AsyncResult)localObject).onReceiveResult(true, localJSONObject);
        }
        catch (Throwable paramArrayList)
        {
          ((AsyncResult)localObject).onReceiveResult(false, null);
        }
      }
      break label96;
      break;
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList) {}
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams == null)) {
      bjqp.a("ThirdAppProxyImpl", "onWadlTaskStatusChanged error wadlResult is null");
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
            i = bjqz.a(paramWadlResult.jdField_b_of_type_Int);
            bjqu.b(localWadlParams.a);
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
              bkrr.a(this.a).remove(str);
              if ((bkrr.b(this.a) != null) && (bkrr.b(this.a).containsKey(str)) && (bkrr.b(this.a).get(str) != null)) {
                ((ThirdAppProxy.AppDownloadListener)bkrr.b(this.a).get(str)).onDownloadComplete();
              }
              bkrr.b(this.a).remove(str);
              return;
            }
          } while (!bkrr.c(this.a).containsKey(str));
          paramWadlResult = (AsyncResult)bkrr.c(this.a).remove(str);
        } while (paramWadlResult == null);
        paramWadlResult.onReceiveResult(true, null);
        return;
        i = bjqz.b(paramWadlResult.c);
        bjqz.a(i);
        bkrr.a(this.a).remove(str);
        if ((bkrr.b(this.a) != null) && (bkrr.b(this.a).containsKey(str)) && (bkrr.b(this.a).get(str) != null)) {
          ((ThirdAppProxy.AppDownloadListener)bkrr.b(this.a).get(str)).onDownloadFailed(i, i, "failed");
        }
        bkrr.b(this.a).remove(str);
        return;
      } while ((bkrr.b(this.a) == null) || (!bkrr.b(this.a).containsKey(str)) || (bkrr.b(this.a).get(str) == null));
      i = 0;
      if (bkrr.a(this.a).containsKey(str)) {
        i = ((Integer)bkrr.a(this.a).get(str)).intValue();
      }
      j = (int)(paramWadlResult.jdField_b_of_type_Long * 100L / paramWadlResult.jdField_a_of_type_Long);
    } while (j - i < 1);
    ((ThirdAppProxy.AppDownloadListener)bkrr.b(this.a).get(str)).onDownloadProgress(paramWadlResult.jdField_b_of_type_Long, paramWadlResult.jdField_a_of_type_Long, j);
    bkrr.a(this.a).put(str, Integer.valueOf(j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkrs
 * JD-Core Version:    0.7.0.1
 */