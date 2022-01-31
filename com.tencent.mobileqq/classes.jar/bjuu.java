import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class bjuu
  extends bjts
  implements bjmq
{
  private byte jdField_a_of_type_Byte = 115;
  public int a;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private Map<Integer, bjuv> b;
  
  public bjuu()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 4;
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(bjuv parambjuv)
  {
    int i = 0;
    if (TextUtils.isEmpty(parambjuv.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (TextUtils.isEmpty(parambjuv.jdField_a_of_type_JavaLangString)) {
      i = 101;
    }
    while (i != 0)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "call qzone upload ret:" + i);
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("status", 2);
        localJSONObject1.put("code", i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("id", parambjuv.jdField_a_of_type_Int);
        localJSONObject2.put("url", "");
        localJSONObject1.put("data", localJSONObject2);
        localJSONObject1.put("msg", "");
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(parambjuv.c, new String[] { localJSONObject1.toString() });
        return;
      }
      catch (JSONException parambjuv)
      {
        QLog.w("js-upload: QzoneUploadPlugin", 1, "JSONException error !", parambjuv);
        return;
        parambjuv.d = bjut.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), parambjuv.jdField_a_of_type_JavaLangString);
        if ((!TextUtils.isEmpty(parambjuv.d)) && (new File(parambjuv.d).exists()))
        {
          this.jdField_a_of_type_JavaUtilMap.put(parambjuv.d, Integer.valueOf(parambjuv.jdField_a_of_type_Int));
          if (!bjut.a(parambjuv.d, parambjuv.b)) {
            i = 102;
          }
        }
        else
        {
          i = 103;
        }
      }
      catch (Exception parambjuv)
      {
        QLog.w("js-upload: QzoneUploadPlugin", 1, "parentPlugin.callJs error !", parambjuv);
      }
    }
  }
  
  private void b()
  {
    bjmn.a().a(this);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(String... paramVarArgs)
  {
    QLog.i("js-upload: QzoneUploadPlugin", 1, "notify client receive upload task.");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", 1);
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      QLog.d("js-upload: QzoneUploadPlugin", 1, "callback invoke ... task.jsCallback:" + paramVarArgs.getString("callback"));
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramVarArgs.getString("callback"), new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramVarArgs)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "JSONException error !", paramVarArgs);
      return;
    }
    catch (Exception paramVarArgs)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "parentPlugin.callJs error !", paramVarArgs);
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.a(paramIntent, paramByte, paramInt);
    if (paramByte == this.jdField_a_of_type_Byte) {}
  }
  
  /* Error */
  protected void a(String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 50
    //   2: iconst_1
    //   3: ldc 195
    //   5: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: new 74	org/json/JSONObject
    //   11: dup
    //   12: aload_1
    //   13: iconst_0
    //   14: aaload
    //   15: invokespecial 180	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   18: astore_2
    //   19: new 39	bjuv
    //   22: dup
    //   23: aload_0
    //   24: aload_2
    //   25: ldc 85
    //   27: invokevirtual 199	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   30: invokespecial 202	bjuv:<init>	(Lbjuu;I)V
    //   33: astore_1
    //   34: aload_1
    //   35: aload_2
    //   36: ldc 204
    //   38: invokevirtual 188	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: putfield 42	bjuv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   44: aload_1
    //   45: aload_2
    //   46: ldc 206
    //   48: invokevirtual 188	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: putfield 156	bjuv:b	Ljava/lang/String;
    //   54: aload_1
    //   55: aload_2
    //   56: ldc 184
    //   58: invokevirtual 188	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield 103	bjuv:c	Ljava/lang/String;
    //   64: aload_1
    //   65: ifnull +26 -> 91
    //   68: aload_0
    //   69: getfield 31	bjuu:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   72: aload_1
    //   73: getfield 86	bjuv:jdField_a_of_type_Int	I
    //   76: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aload_1
    //   80: invokeinterface 154 3 0
    //   85: pop
    //   86: aload_0
    //   87: aload_1
    //   88: invokespecial 208	bjuu:a	(Lbjuv;)V
    //   91: return
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_1
    //   95: ldc 50
    //   97: iconst_1
    //   98: ldc 114
    //   100: aload_2
    //   101: invokestatic 117	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   104: goto -40 -> 64
    //   107: astore_2
    //   108: aconst_null
    //   109: astore_1
    //   110: ldc 50
    //   112: iconst_1
    //   113: ldc 210
    //   115: aload_2
    //   116: invokestatic 117	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   119: goto -55 -> 64
    //   122: astore_2
    //   123: goto -13 -> 110
    //   126: astore_2
    //   127: goto -32 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	bjuu
    //   0	130	1	paramVarArgs	String[]
    //   18	38	2	localJSONObject	JSONObject
    //   92	9	2	localJSONException1	JSONException
    //   107	9	2	localException1	Exception
    //   122	1	2	localException2	Exception
    //   126	1	2	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   8	34	92	org/json/JSONException
    //   8	34	107	java/lang/Exception
    //   34	64	122	java/lang/Exception
    //   34	64	126	org/json/JSONException
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("QzoneUpload")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {}
    while (!paramString3.equals("ups")) {
      return false;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      if (!this.jdField_a_of_type_Boolean) {
        b();
      }
      b(paramVarArgs);
      a(paramVarArgs);
    }
    return true;
  }
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934600L) && (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.jdField_a_of_type_Byte))
    {
      int i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      paramString = (Intent)paramMap.get("data");
      int j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if ((i == this.jdField_a_of_type_Byte) && (j == -1)) {}
      return true;
    }
    return super.a(paramString, paramLong, paramMap);
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        QLog.e("js-upload: QzoneUploadPlugin", 1, "call js function, bundle is empty");
        return;
      }
    } while (!"cmd.qzoneUploadUps".equals(paramString));
    int j = paramBundle.getInt("param.uploadStatus", -1);
    int i = paramBundle.getInt("param.uploadResult", -1);
    paramString = paramBundle.getString("param.tmpLocalFile");
    Object localObject = paramBundle.getString("param.uploadResultUrl");
    QLog.w("js-upload: QzoneUploadPlugin", 1, "onWebEvent status:" + j + " code:" + i + " url:" + (String)localObject);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "localTmpPath == null !!");
      return;
    }
    paramBundle = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramBundle == null)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "ITaskId == null");
      return;
    }
    j = paramBundle.intValue();
    paramBundle = (bjuv)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(j));
    if (paramBundle == null)
    {
      QLog.w("js-upload: QzoneUploadPlugin", 1, "task == null, id:" + j);
      return;
    }
    paramBundle.e = ((String)localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("status", 4);
      ((JSONObject)localObject).put("code", i);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramBundle.jdField_a_of_type_Int);
      localJSONObject.put("url", paramBundle.e);
      ((JSONObject)localObject).put("data", localJSONObject);
      ((JSONObject)localObject).put("msg", "");
      QLog.d("js-upload: QzoneUploadPlugin", 1, "callback invoke ... task.jsCallback:" + paramBundle.c + " result:" + ((JSONObject)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramBundle.c, new String[] { ((JSONObject)localObject).toString() });
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new File(paramString);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
      this.jdField_b_of_type_JavaUtilMap.remove(Integer.valueOf(j));
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      paramBundle.d = null;
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.w("js-upload: QzoneUploadPlugin", 1, "JSONException error !", localJSONException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("js-upload: QzoneUploadPlugin", 1, "parentPlugin.callJs error !", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjuu
 * JD-Core Version:    0.7.0.1
 */