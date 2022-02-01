package com.tencent.mobileqq.apollo.statistics.trace.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class TraceData
  extends Entity
  implements Serializable
{
  @notColumn
  public int endJavaHeap;
  @notColumn
  public int endNativeHeap;
  public int extra1;
  public int extra2;
  public int extra3;
  public int featureId;
  @notColumn
  public String featureKey;
  @notColumn
  public int initJavaHeap;
  @notColumn
  public int initNativeHeap;
  @notColumn
  public boolean isSampleFocus;
  @notColumn
  public BlockingQueue<SpanData> mSpanQueue;
  public String packData;
  @notColumn
  public ResultData result;
  public long serverTime;
  @notColumn
  public long startTime;
  public String tUid;
  public long timestamp;
  @unique
  public long traceId;
  public String uid;
  public String version;
  
  private ResultData getResultData(JSONObject paramJSONObject)
  {
    ResultData localResultData = new ResultData();
    localResultData.jdField_a_of_type_Int = paramJSONObject.optInt("errCode");
    localResultData.b = paramJSONObject.optInt("cost");
    localResultData.d = paramJSONObject.optInt("cpu");
    localResultData.c = paramJSONObject.optInt("memory");
    localResultData.e = paramJSONObject.optInt("netType");
    localResultData.f = paramJSONObject.optInt("javaHeap");
    localResultData.g = paramJSONObject.optInt("nativeHeap");
    return localResultData;
  }
  
  private JSONObject getResultObject(ResultData paramResultData)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("errCode", paramResultData.jdField_a_of_type_Int);
    localJSONObject.put("cost", paramResultData.b);
    localJSONObject.put("memory", paramResultData.c);
    localJSONObject.put("cpu", paramResultData.d);
    localJSONObject.put("netType", paramResultData.e);
    localJSONObject.put("javaHeap", paramResultData.f);
    localJSONObject.put("nativeHeap", paramResultData.g);
    return localJSONObject;
  }
  
  protected void postRead()
  {
    try
    {
      super.postRead();
      Object localObject1 = new JSONObject(this.packData);
      Object localObject2 = ((JSONObject)localObject1).optJSONObject("resultObject");
      if (localObject2 != null) {
        this.result = getResultData((JSONObject)localObject2);
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("spanArray");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        this.mSpanQueue = new LinkedBlockingQueue();
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject3 = ((JSONArray)localObject1).optJSONObject(i);
          localObject2 = new SpanData(((JSONObject)localObject3).optInt("spanId"));
          ((SpanData)localObject2).jdField_a_of_type_Long = ((JSONObject)localObject3).optLong("timestamp");
          ((SpanData)localObject2).b = ((JSONObject)localObject3).optLong("serverTime");
          ((SpanData)localObject2).jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataResultData = getResultData(((JSONObject)localObject3).optJSONObject("resultObject"));
          Object localObject4 = ((JSONObject)localObject3).optJSONArray("annoArray");
          int j;
          Object localObject5;
          if ((localObject4 != null) && (((JSONArray)localObject4).length() > 0))
          {
            ((SpanData)localObject2).jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
            j = 0;
            while (j < ((JSONArray)localObject4).length())
            {
              localObject5 = ((JSONArray)localObject4).optJSONObject(j);
              localObject5 = new AnnotationData(((JSONObject)localObject5).optString("msg"), ((JSONObject)localObject5).optLong("timestamp"), ((JSONObject)localObject5).optLong("serverTime"));
              ((SpanData)localObject2).jdField_a_of_type_JavaUtilConcurrentBlockingQueue.offer(localObject5);
              j += 1;
            }
          }
          localObject3 = ((JSONObject)localObject3).optJSONArray("extArray");
          if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
          {
            ((SpanData)localObject2).jdField_a_of_type_JavaUtilMap = new HashMap();
            j = 0;
            while (j < ((JSONArray)localObject3).length())
            {
              localObject4 = ((JSONArray)localObject3).optJSONObject(j);
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("extKey");
              ((StringBuilder)localObject5).append(j);
              int k = ((JSONObject)localObject4).optInt(((StringBuilder)localObject5).toString());
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("extKey");
              ((StringBuilder)localObject5).append(j);
              long l = ((JSONObject)localObject4).optLong(((StringBuilder)localObject5).toString());
              ((SpanData)localObject2).jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(k), Long.valueOf(l));
              j += 1;
            }
          }
          this.mSpanQueue.add(localObject2);
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow][TraceReport]", 1, "Exception:", localException);
    }
  }
  
  protected void prewrite()
  {
    try
    {
      super.prewrite();
      JSONObject localJSONObject1 = new JSONObject();
      Object localObject1 = this.result;
      if (localObject1 != null) {
        localJSONObject1.put("resultObject", getResultObject(this.result));
      }
      if ((this.mSpanQueue != null) && (this.mSpanQueue.size() > 0))
      {
        localObject1 = new JSONArray();
        JSONObject localJSONObject2 = new JSONObject();
        Iterator localIterator = this.mSpanQueue.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (SpanData)localIterator.next();
          localJSONObject2.put("spanId", ((SpanData)localObject2).jdField_a_of_type_Int);
          localJSONObject2.put("timestamp", ((SpanData)localObject2).jdField_a_of_type_Long);
          localJSONObject2.put("serverTime", ((SpanData)localObject2).b);
          localJSONObject2.put("resultObject", getResultObject(((SpanData)localObject2).jdField_a_of_type_ComTencentMobileqqApolloStatisticsTraceDataResultData));
          JSONArray localJSONArray;
          Object localObject3;
          Object localObject4;
          Object localObject5;
          if ((((SpanData)localObject2).jdField_a_of_type_JavaUtilConcurrentBlockingQueue != null) && (((SpanData)localObject2).jdField_a_of_type_JavaUtilConcurrentBlockingQueue.size() > 0))
          {
            localJSONArray = new JSONArray();
            localObject3 = ((SpanData)localObject2).jdField_a_of_type_JavaUtilConcurrentBlockingQueue.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (AnnotationData)((Iterator)localObject3).next();
              localObject5 = new JSONObject();
              ((JSONObject)localObject5).put("timestamp", ((AnnotationData)localObject4).jdField_a_of_type_Long);
              ((JSONObject)localObject5).put("serverTime", ((AnnotationData)localObject4).b);
              ((JSONObject)localObject5).put("msg", ((AnnotationData)localObject4).jdField_a_of_type_JavaLangString);
              localJSONArray.put(localObject5);
            }
            localJSONObject2.put("annoArray", localJSONArray);
          }
          if ((((SpanData)localObject2).jdField_a_of_type_JavaUtilMap != null) && (((SpanData)localObject2).jdField_a_of_type_JavaUtilMap.size() > 0))
          {
            localJSONArray = new JSONArray();
            int i = 0;
            localObject2 = ((SpanData)localObject2).jdField_a_of_type_JavaUtilMap.entrySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject2).next();
              localObject4 = new JSONObject();
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("extKey");
              ((StringBuilder)localObject5).append(i);
              ((JSONObject)localObject4).put(((StringBuilder)localObject5).toString(), ((Map.Entry)localObject3).getKey());
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("extValue");
              ((StringBuilder)localObject5).append(i);
              ((JSONObject)localObject4).put(((StringBuilder)localObject5).toString(), ((Map.Entry)localObject3).getValue());
              localJSONArray.put(localObject4);
              i += 1;
            }
            localJSONObject2.put("extArray", localJSONArray);
          }
          ((JSONArray)localObject1).put(localJSONObject2);
        }
        localJSONObject1.put("spanArray", localObject1);
      }
      this.packData = localJSONObject1.toString();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow][TraceReport]", 1, "Exception:", localException);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("feature:");
    localStringBuilder.append(this.featureId);
    localStringBuilder.append(",traceId:");
    localStringBuilder.append(this.traceId);
    localStringBuilder.append(",result:");
    localStringBuilder.append(this.result.toString());
    if (this.extra1 > 0)
    {
      localStringBuilder.append(",extra1:");
      localStringBuilder.append(this.extra1);
    }
    if (this.extra2 > 0)
    {
      localStringBuilder.append(",extra2:");
      localStringBuilder.append(this.extra2);
    }
    if (this.extra3 > 0)
    {
      localStringBuilder.append(",extra3:");
      localStringBuilder.append(this.extra3);
    }
    Object localObject = this.mSpanQueue;
    if (localObject != null)
    {
      localObject = ((BlockingQueue)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SpanData localSpanData = (SpanData)((Iterator)localObject).next();
        localStringBuilder.append("\n");
        localStringBuilder.append(localSpanData.toString());
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.trace.data.TraceData
 * JD-Core Version:    0.7.0.1
 */