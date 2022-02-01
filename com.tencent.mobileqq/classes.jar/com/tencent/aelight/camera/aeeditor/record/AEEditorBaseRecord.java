package com.tencent.aelight.camera.aeeditor.record;

import android.text.TextUtils;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerViewModel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.tavcut.bean.TextItem;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AEEditorBaseRecord
{
  public static final String a = AEEditorBaseRecord.class.toString();
  private AEEditorTextViewModel b;
  private AEEditorStickerViewModel c;
  
  /* Error */
  public static <T> T a(JSONObject paramJSONObject, String paramString, Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 35	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_0
    //   6: aload_0
    //   7: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +124 -> 134
    //   13: new 43	java/io/ByteArrayInputStream
    //   16: dup
    //   17: aload_0
    //   18: iconst_0
    //   19: invokestatic 49	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   22: invokespecial 52	java/io/ByteArrayInputStream:<init>	([B)V
    //   25: astore_3
    //   26: new 54	java/io/ObjectInputStream
    //   29: dup
    //   30: aload_3
    //   31: invokespecial 57	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: invokevirtual 61	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   41: astore_2
    //   42: aload_3
    //   43: invokevirtual 64	java/io/ByteArrayInputStream:close	()V
    //   46: aload_1
    //   47: invokevirtual 65	java/io/ObjectInputStream:close	()V
    //   50: aload_2
    //   51: areturn
    //   52: astore_0
    //   53: getstatic 20	com/tencent/aelight/camera/aeeditor/record/AEEditorBaseRecord:a	Ljava/lang/String;
    //   56: aload_0
    //   57: invokestatic 70	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: aload_2
    //   61: areturn
    //   62: astore_2
    //   63: goto +12 -> 75
    //   66: astore_1
    //   67: aconst_null
    //   68: astore_0
    //   69: goto +40 -> 109
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: astore_0
    //   77: getstatic 20	com/tencent/aelight/camera/aeeditor/record/AEEditorBaseRecord:a	Ljava/lang/String;
    //   80: aload_2
    //   81: invokestatic 70	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   84: aload_3
    //   85: invokevirtual 64	java/io/ByteArrayInputStream:close	()V
    //   88: aload_1
    //   89: ifnull +45 -> 134
    //   92: aload_1
    //   93: invokevirtual 65	java/io/ObjectInputStream:close	()V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_0
    //   99: getstatic 20	com/tencent/aelight/camera/aeeditor/record/AEEditorBaseRecord:a	Ljava/lang/String;
    //   102: aload_0
    //   103: invokestatic 70	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_1
    //   109: aload_3
    //   110: invokevirtual 64	java/io/ByteArrayInputStream:close	()V
    //   113: aload_0
    //   114: ifnull +18 -> 132
    //   117: aload_0
    //   118: invokevirtual 65	java/io/ObjectInputStream:close	()V
    //   121: goto +11 -> 132
    //   124: astore_0
    //   125: getstatic 20	com/tencent/aelight/camera/aeeditor/record/AEEditorBaseRecord:a	Ljava/lang/String;
    //   128: aload_0
    //   129: invokestatic 70	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload_1
    //   133: athrow
    //   134: aconst_null
    //   135: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramJSONObject	JSONObject
    //   0	136	1	paramString	String
    //   0	136	2	paramClass	Class<T>
    //   25	85	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   42	50	52	java/io/IOException
    //   37	42	62	java/lang/Exception
    //   26	35	66	finally
    //   26	35	72	java/lang/Exception
    //   84	88	98	java/io/IOException
    //   92	96	98	java/io/IOException
    //   37	42	108	finally
    //   77	84	108	finally
    //   109	113	124	java/io/IOException
    //   117	121	124	java/io/IOException
  }
  
  /* Error */
  public static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 75	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 76	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore 6
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore_3
    //   19: new 78	java/io/ObjectOutputStream
    //   22: dup
    //   23: aload 6
    //   25: invokespecial 81	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore 4
    //   30: aload 4
    //   32: aload_2
    //   33: invokevirtual 85	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   36: aload_0
    //   37: aload_1
    //   38: new 87	java/lang/String
    //   41: dup
    //   42: aload 6
    //   44: invokevirtual 91	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   47: iconst_0
    //   48: invokestatic 95	android/util/Base64:encode	([BI)[B
    //   51: invokespecial 96	java/lang/String:<init>	([B)V
    //   54: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload 6
    //   60: invokevirtual 101	java/io/ByteArrayOutputStream:close	()V
    //   63: aload 4
    //   65: invokevirtual 102	java/io/ObjectOutputStream:close	()V
    //   68: return
    //   69: astore_0
    //   70: goto +53 -> 123
    //   73: astore_1
    //   74: aload 4
    //   76: astore_0
    //   77: goto +14 -> 91
    //   80: astore_0
    //   81: aload_3
    //   82: astore 4
    //   84: goto +39 -> 123
    //   87: astore_1
    //   88: aload 5
    //   90: astore_0
    //   91: aload_0
    //   92: astore_3
    //   93: getstatic 20	com/tencent/aelight/camera/aeeditor/record/AEEditorBaseRecord:a	Ljava/lang/String;
    //   96: aload_1
    //   97: invokestatic 70	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   100: aload 6
    //   102: invokevirtual 101	java/io/ByteArrayOutputStream:close	()V
    //   105: aload_0
    //   106: ifnull +16 -> 122
    //   109: aload_0
    //   110: invokevirtual 102	java/io/ObjectOutputStream:close	()V
    //   113: return
    //   114: astore_0
    //   115: getstatic 20	com/tencent/aelight/camera/aeeditor/record/AEEditorBaseRecord:a	Ljava/lang/String;
    //   118: aload_0
    //   119: invokestatic 70	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   122: return
    //   123: aload 6
    //   125: invokevirtual 101	java/io/ByteArrayOutputStream:close	()V
    //   128: aload 4
    //   130: ifnull +19 -> 149
    //   133: aload 4
    //   135: invokevirtual 102	java/io/ObjectOutputStream:close	()V
    //   138: goto +11 -> 149
    //   141: astore_1
    //   142: getstatic 20	com/tencent/aelight/camera/aeeditor/record/AEEditorBaseRecord:a	Ljava/lang/String;
    //   145: aload_1
    //   146: invokestatic 70	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   149: aload_0
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramJSONObject	JSONObject
    //   0	151	1	paramString	String
    //   0	151	2	paramObject	Object
    //   18	75	3	localJSONObject	JSONObject
    //   28	106	4	localObject1	Object
    //   15	74	5	localObject2	Object
    //   12	112	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   30	58	69	finally
    //   30	58	73	java/lang/Exception
    //   19	30	80	finally
    //   93	100	80	finally
    //   19	30	87	java/lang/Exception
    //   58	68	114	java/io/IOException
    //   100	105	114	java/io/IOException
    //   109	113	114	java/io/IOException
    //   123	128	141	java/io/IOException
    //   133	138	141	java/io/IOException
  }
  
  public List<StickerModel> a(JSONArray paramJSONArray)
  {
    String str1 = "scale";
    String str2 = "offset";
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    label449:
    label458:
    label465:
    label471:
    for (;;)
    {
      try
      {
        if (i < paramJSONArray.length())
        {
          Object localObject1 = paramJSONArray.optJSONObject(i);
          if (localObject1 != null)
          {
            String str3 = ((JSONObject)localObject1).optString("id");
            if (!TextUtils.isEmpty(str3))
            {
              Object localObject2 = ((JSONObject)localObject1).optString("dir");
              if (new File((String)localObject2).exists())
              {
                if (((JSONObject)localObject1).optJSONObject(str2) == null) {
                  break label449;
                }
                f1 = (float)((JSONObject)localObject1).getJSONObject(str2).getDouble("x");
                f2 = (float)((JSONObject)localObject1).getJSONObject(str2).getDouble("y");
                if (Double.compare(((JSONObject)localObject1).optDouble(str1), (0.0D / 0.0D)) == 0) {
                  break label458;
                }
                f3 = (float)((JSONObject)localObject1).optDouble(str1);
                if (Double.compare(((JSONObject)localObject1).optDouble("rotation"), (0.0D / 0.0D)) == 0) {
                  break label465;
                }
                f4 = (float)((JSONObject)localObject1).optDouble("rotation");
                StickerModel localStickerModel = new StickerModel();
                localStickerModel.setMaterialId(str3);
                localStickerModel.setFilePath((String)localObject2);
                localStickerModel.setCenterX(f1);
                localStickerModel.setCenterY(f2);
                localStickerModel.setScale(f3);
                localStickerModel.setRotate(f4);
                localStickerModel.setStartTime(0.0F);
                localStickerModel.setDuration(2.0F);
                localStickerModel.setMaxScale(2.0F);
                localStickerModel.setMinScale(0.05F);
                if (((JSONObject)localObject1).optJSONObject("textItem") != null)
                {
                  localObject2 = ((JSONObject)localObject1).optJSONObject("textItem");
                  localObject1 = new TextItem();
                  ((TextItem)localObject1).setAssetFontPath(((JSONObject)localObject2).optString("assetFontPath"));
                  ((TextItem)localObject1).setFontPath(((JSONObject)localObject2).optString("fontPath"));
                  ((TextItem)localObject1).setText(((JSONObject)localObject2).optString("text"));
                  ((TextItem)localObject1).setTextColor(((JSONObject)localObject2).optInt("textColor"));
                  localObject2 = new ArrayList();
                  ((ArrayList)localObject2).add(localObject1);
                  localStickerModel.setTextItems((List)localObject2);
                  if (this.b == null) {
                    break label471;
                  }
                  this.b.b(Arrays.asList(new String[] { str3 }));
                  break label471;
                }
                if (this.c == null) {
                  break label471;
                }
                this.c.b(Arrays.asList(new String[] { str3 }));
                localArrayList.add(localStickerModel);
              }
            }
          }
          i += 1;
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Exception paramJSONArray)
      {
        AEQLog.a(a, paramJSONArray);
      }
      float f1 = 0.5F;
      float f2 = 0.5F;
      continue;
      float f3 = 0.5F;
      continue;
      float f4 = 0.0F;
    }
  }
  
  public JSONArray a(List<StickerModel> paramList)
  {
    localJSONArray = new JSONArray();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      try
      {
        while (i < paramList.size())
        {
          Object localObject1 = (StickerModel)paramList.get(i);
          Object localObject3 = ((StickerModel)localObject1).getMaterialId();
          float f1 = ((StickerModel)localObject1).getCenterX();
          float f2 = ((StickerModel)localObject1).getCenterY();
          float f3 = ((StickerModel)localObject1).getScale();
          float f4 = ((StickerModel)localObject1).getRotate();
          Object localObject2 = ((StickerModel)localObject1).getFilePath();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("id", localObject3);
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("x", f1);
          ((JSONObject)localObject3).put("y", f2);
          localJSONObject.put("offset", localObject3);
          localJSONObject.put("scale", f3);
          localJSONObject.put("rotation", f4);
          localJSONObject.put("dir", localObject2);
          if (((StickerModel)localObject1).getTextItems().size() > 0)
          {
            localObject1 = (TextItem)((StickerModel)localObject1).getTextItems().get(0);
            if (localObject1 != null)
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("assetFontPath", ((TextItem)localObject1).getAssetFontPath());
              ((JSONObject)localObject2).put("fontPath", ((TextItem)localObject1).getFontPath());
              ((JSONObject)localObject2).put("textColor", ((TextItem)localObject1).getTextColor());
              ((JSONObject)localObject2).put("text", ((TextItem)localObject1).getText());
              localJSONObject.put("textItem", localObject2);
            }
          }
          localJSONArray.put(localJSONObject);
          i += 1;
        }
        return localJSONArray;
      }
      catch (Exception paramList)
      {
        AEQLog.a(a, paramList);
      }
    }
  }
  
  public void a(AEEditorTextViewModel paramAEEditorTextViewModel, AEEditorStickerViewModel paramAEEditorStickerViewModel)
  {
    this.b = paramAEEditorTextViewModel;
    this.c = paramAEEditorStickerViewModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.record.AEEditorBaseRecord
 * JD-Core Version:    0.7.0.1
 */