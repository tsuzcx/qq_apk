package com.tencent.mobileqq.apollo.game.process.chanel;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class CmGameNativeMethodHandler
  implements IRequestHandler
{
  public static int a = -2147483648;
  private SparseArray<CmGameNativeMethodHandler.NativeObject> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public WeakReference<CmGameLauncher> a;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  public int b;
  
  public CmGameNativeMethodHandler(CmGameLauncher paramCmGameLauncher)
  {
    a(new CmGameAudioHandler());
    if (paramCmGameLauncher != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCmGameLauncher);
      this.b = paramCmGameLauncher.a();
    }
  }
  
  private JSONObject a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("message", paramString);
    }
    catch (Throwable paramString)
    {
      QLog.e("[cmshow]CmGameNetiveMethodHandler", 1, paramString, new Object[0]);
    }
    return this.jdField_a_of_type_OrgJsonJSONObject;
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (paramString2 != null)) {
      ApolloCmdChannel.getInstance().callbackFromRequest(paramLong, 0, paramString1, paramString2);
    }
  }
  
  private void a(String paramString)
  {
    a(0L, "cs.native_method_state.local", a(paramString).toString());
  }
  
  public int a()
  {
    return 0;
  }
  
  public HandleResult a(long paramLong, String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
          return null;
        }
        Object localObject = (CmGameLauncher)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject == null)
        {
          QLog.e("[cmshow]CmGameNetiveMethodHandler", 1, "launcher is null");
          return null;
        }
        localObject = ((CmGameLauncher)localObject).a();
        if ((localObject != null) && (((ApolloSurfaceView)localObject).getLuaState() == paramLong))
        {
          paramString2 = new JSONObject(paramString2);
          i = paramString2.optInt("N_R_OBJ");
          if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
            return null;
          }
          localObject = (CmGameNativeMethodHandler.NativeObject)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
          paramString2.put("N_R_CMD", paramString1);
          paramString2.put("N_R_STATE", paramLong);
          if (localObject != null)
          {
            paramString1 = ((CmGameNativeMethodHandler.NativeObject)localObject).b(this, paramString2);
            if (paramString2.optBoolean("N_R_SYNC"))
            {
              if (paramString1 != null) {
                paramString1.put("code", 0);
              }
              localObject = new HandleResult();
              ((HandleResult)localObject).b = true;
              if (paramString1 == null) {
                paramString1 = paramString2.toString();
              } else {
                paramString1 = paramString1.toString();
              }
              ((HandleResult)localObject).a = paramString1;
              return localObject;
            }
            a(paramString1);
            return null;
          }
          int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
          i = 0;
          if (i < j)
          {
            int k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
            paramString1 = (CmGameNativeMethodHandler.NativeObject)this.jdField_a_of_type_AndroidUtilSparseArray.get(k);
            if (paramString1 == null) {
              break label338;
            }
            paramString1 = paramString1.b(this, paramString2);
            if (paramString1 == null) {
              break label338;
            }
            a(paramString1);
            break label338;
          }
        }
        else
        {
          QLog.e("[cmshow]CmGameNetiveMethodHandler", 1, "view is null");
          return null;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("[cmshow]CmGameNetiveMethodHandler", 1, paramString1, new Object[0]);
        paramString2 = new StringBuilder();
        paramString2.append("handleCmd ");
        paramString2.append(paramString1.getMessage());
        a(paramString2.toString());
      }
      return null;
      label338:
      i += 1;
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidUtilSparseArray;
    if (localObject != null)
    {
      int j = ((SparseArray)localObject).size();
      int i = 0;
      while (i < j)
      {
        int k = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
        localObject = (CmGameNativeMethodHandler.NativeObject)this.jdField_a_of_type_AndroidUtilSparseArray.get(k);
        if (localObject != null) {
          ((CmGameNativeMethodHandler.NativeObject)localObject).a();
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      this.jdField_a_of_type_AndroidUtilSparseArray = null;
    }
    localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      ((WeakReference)localObject).clear();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    this.jdField_a_of_type_OrgJsonJSONObject = null;
  }
  
  public void a(CmGameNativeMethodHandler.NativeObject paramNativeObject)
  {
    if (paramNativeObject != null)
    {
      int i = paramNativeObject.c();
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
      }
      if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramNativeObject);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        int i = paramJSONObject.optInt("N_R_SE", -1);
        int j = paramJSONObject.optInt("N_R_OBJ", -1);
        long l = paramJSONObject.optLong("N_R_STATE");
        String str = paramJSONObject.optString("N_R_CMD", null);
        if ((i != -1) && (j != -1) && (!TextUtils.isEmpty(str)))
        {
          ApolloCmdChannel.getInstance().callbackFromRequest(l, 0, str, paramJSONObject.toString());
          return;
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("response invalid ");
        paramJSONObject.append(str);
        QLog.e("[cmshow]CmGameNetiveMethodHandler", 1, paramJSONObject.toString());
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("invalid response ");
        paramJSONObject.append(i);
        paramJSONObject.append(" # ");
        paramJSONObject.append(j);
        paramJSONObject.append(" # ");
        paramJSONObject.append(str);
        a(paramJSONObject.toString());
        return;
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("[cmshow]CmGameNetiveMethodHandler", 1, paramJSONObject, new Object[0]);
      }
    }
  }
  
  public void b(CmGameNativeMethodHandler.NativeObject paramNativeObject)
  {
    if (paramNativeObject != null)
    {
      int i = paramNativeObject.c();
      paramNativeObject.a();
      paramNativeObject = this.jdField_a_of_type_AndroidUtilSparseArray;
      if (paramNativeObject != null) {
        paramNativeObject.remove(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameNativeMethodHandler
 * JD-Core Version:    0.7.0.1
 */