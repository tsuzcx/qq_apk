package com.tencent.aelight.camera.aioeditor.capture.text;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class DynamicTextConfigManager$DynamicTextConfigBean
{
  public ArrayList<DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo> fontInfos = new ArrayList();
  public int iconDrawableId;
  public int predownload;
  public int text_id;
  
  /* Error */
  public static DynamicTextConfigBean convertFrom(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: new 2	com/tencent/aelight/camera/aioeditor/capture/text/DynamicTextConfigManager$DynamicTextConfigBean
    //   3: dup
    //   4: invokespecial 26	com/tencent/aelight/camera/aioeditor/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: ldc 27
    //   11: invokevirtual 33	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   14: ifeq +13 -> 27
    //   17: aload_3
    //   18: aload_0
    //   19: ldc 27
    //   21: invokevirtual 37	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   24: putfield 39	com/tencent/aelight/camera/aioeditor/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:text_id	I
    //   27: aload_0
    //   28: ldc 40
    //   30: invokevirtual 33	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   33: ifeq +13 -> 46
    //   36: aload_3
    //   37: aload_0
    //   38: ldc 40
    //   40: invokevirtual 37	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   43: putfield 42	com/tencent/aelight/camera/aioeditor/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:predownload	I
    //   46: aload_3
    //   47: astore 4
    //   49: aload_0
    //   50: ldc 44
    //   52: invokevirtual 33	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   55: ifeq +104 -> 159
    //   58: aload_0
    //   59: ldc 44
    //   61: invokevirtual 48	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   64: astore_0
    //   65: aload_0
    //   66: invokevirtual 54	org/json/JSONArray:length	()I
    //   69: istore_2
    //   70: iconst_0
    //   71: istore_1
    //   72: aload_3
    //   73: astore 4
    //   75: iload_1
    //   76: iload_2
    //   77: if_icmpge +82 -> 159
    //   80: aload_0
    //   81: iload_1
    //   82: invokevirtual 58	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   85: checkcast 29	org/json/JSONObject
    //   88: invokestatic 64	com/tencent/aelight/camera/aioeditor/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo:a	(Lorg/json/JSONObject;)Lcom/tencent/aelight/camera/aioeditor/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;
    //   91: astore 4
    //   93: aload 4
    //   95: aload_3
    //   96: getfield 39	com/tencent/aelight/camera/aioeditor/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:text_id	I
    //   99: putfield 67	com/tencent/aelight/camera/aioeditor/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo:d	I
    //   102: aload 4
    //   104: ifnull +13 -> 117
    //   107: aload_3
    //   108: getfield 20	com/tencent/aelight/camera/aioeditor/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   111: aload 4
    //   113: invokevirtual 71	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   116: pop
    //   117: iload_1
    //   118: iconst_1
    //   119: iadd
    //   120: istore_1
    //   121: goto -49 -> 72
    //   124: astore 4
    //   126: aload_3
    //   127: astore_0
    //   128: aload 4
    //   130: astore_3
    //   131: goto +6 -> 137
    //   134: astore_3
    //   135: aconst_null
    //   136: astore_0
    //   137: aload_0
    //   138: astore 4
    //   140: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +16 -> 159
    //   146: ldc 79
    //   148: iconst_2
    //   149: aload_3
    //   150: invokevirtual 83	org/json/JSONException:toString	()Ljava/lang/String;
    //   153: invokestatic 87	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_0
    //   157: astore 4
    //   159: aload 4
    //   161: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramJSONObject	org.json.JSONObject
    //   71	50	1	i	int
    //   69	9	2	j	int
    //   7	124	3	localObject1	Object
    //   134	16	3	localJSONException1	org.json.JSONException
    //   47	65	4	localObject2	Object
    //   124	5	4	localJSONException2	org.json.JSONException
    //   138	22	4	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   8	27	124	org/json/JSONException
    //   27	46	124	org/json/JSONException
    //   49	70	124	org/json/JSONException
    //   80	102	124	org/json/JSONException
    //   107	117	124	org/json/JSONException
    //   0	8	134	org/json/JSONException
  }
  
  public int getProgress()
  {
    Object localObject = this.fontInfos;
    if (localObject == null) {
      return 100;
    }
    int j = ((ArrayList)localObject).size();
    int i = 0;
    localObject = this.fontInfos.iterator();
    while (((Iterator)localObject).hasNext()) {
      i += ((DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)((Iterator)localObject).next()).e * 1 / j;
    }
    return i;
  }
  
  public boolean isContainsResUrl(String paramString)
  {
    if (this.fontInfos != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      Iterator localIterator = this.fontInfos.iterator();
      while (localIterator.hasNext())
      {
        DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo localDynamicTextFontInfo = (DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localIterator.next();
        if ((localDynamicTextFontInfo != null) && (paramString.equals(localDynamicTextFontInfo.a))) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextConfigBean
 * JD-Core Version:    0.7.0.1
 */