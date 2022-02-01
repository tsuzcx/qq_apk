import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.RedInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import org.json.JSONObject;

public class auud
{
  public static final String a;
  public static Map<String, String> a;
  public static Queue<String> a;
  public static boolean a;
  public static final String b;
  public static final String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = anni.a(2131709055);
    b = anni.a(2131709054);
    c = anni.a(2131709056);
    jdField_a_of_type_JavaUtilQueue = new ArrayDeque(100);
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_Boolean = true;
  }
  
  public static ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { { 16842919 }, { 16842910 } }, new int[] { paramInt2, paramInt1 });
  }
  
  public static StateListDrawable a(Context paramContext)
  {
    Object localObject1 = new Drawable[3];
    float f1 = afur.a(4.0F, paramContext.getResources());
    float f2 = afur.a(4.0F, paramContext.getResources());
    float f3 = afur.a(4.0F, paramContext.getResources());
    float f4 = afur.a(4.0F, paramContext.getResources());
    int i = 0;
    while (i < 2)
    {
      localObject2 = new RoundRectShape(new float[] { f1, f1, f2, f2, f3, f3, f4, f4 }, null, null);
      localShapeDrawable = new ShapeDrawable();
      localShapeDrawable.setPadding(afur.a(2.0F, paramContext.getResources()), afur.a(0.0F, paramContext.getResources()), afur.a(2.0F, paramContext.getResources()), afur.a(2.0F, paramContext.getResources()));
      localShapeDrawable.setShape((Shape)localObject2);
      localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
      localShapeDrawable.getPaint().setColor(83886080);
      localObject1[i] = localShapeDrawable;
      i += 1;
    }
    Object localObject2 = new float[8];
    localObject2[0] = f1;
    localObject2[1] = f1;
    localObject2[2] = f2;
    localObject2[3] = f2;
    localObject2[4] = f3;
    localObject2[5] = f3;
    localObject2[6] = f4;
    localObject2[7] = f4;
    paramContext = new RoundRectShape((float[])localObject2, null, null);
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape(paramContext);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    localShapeDrawable.getPaint().setColor(-1);
    localObject1[2] = localShapeDrawable;
    paramContext = new LayerDrawable((Drawable[])localObject1);
    localObject2 = new RoundRectShape((float[])localObject2, null, null);
    localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape((Shape)localObject2);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    localShapeDrawable.getPaint().setColor(-526345);
    localObject1[2] = localShapeDrawable;
    localObject1 = new LayerDrawable((Drawable[])localObject1);
    localObject2 = new StateListDrawable();
    ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
    ((StateListDrawable)localObject2).addState(new int[] { 16842910 }, paramContext);
    return localObject2;
  }
  
  public static StateListDrawable a(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Object localObject1 = new Drawable[5];
    paramFloat1 = afur.a(paramFloat1, paramContext.getResources());
    paramFloat2 = afur.a(paramFloat2, paramContext.getResources());
    paramFloat3 = afur.a(paramFloat3, paramContext.getResources());
    float f = afur.a(paramFloat4, paramContext.getResources());
    int i = 0;
    if (i < 4)
    {
      localObject2 = new RoundRectShape(new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, f, f }, null, null);
      localShapeDrawable = new ShapeDrawable();
      if (paramFloat4 == 0.0F) {
        localShapeDrawable.setPadding(afur.a(2.0F, paramContext.getResources()), afur.a(0.0F, paramContext.getResources()), afur.a(2.0F, paramContext.getResources()), 0);
      }
      for (;;)
      {
        localShapeDrawable.setShape((Shape)localObject2);
        localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        localShapeDrawable.getPaint().setColor(634178764);
        localObject1[i] = localShapeDrawable;
        i += 1;
        break;
        localShapeDrawable.setPadding(afur.a(2.0F, paramContext.getResources()), afur.a(0.0F, paramContext.getResources()), afur.a(2.0F, paramContext.getResources()), afur.a(2.0F, paramContext.getResources()));
      }
    }
    Object localObject2 = new float[8];
    localObject2[0] = (paramFloat1 / 2.0F);
    localObject2[1] = (paramFloat1 / 2.0F);
    localObject2[2] = (paramFloat2 / 2.0F);
    localObject2[3] = (paramFloat2 / 2.0F);
    localObject2[4] = (paramFloat3 / 2.0F);
    localObject2[5] = (paramFloat3 / 2.0F);
    localObject2[6] = (f / 2.0F);
    localObject2[7] = (f / 2.0F);
    paramContext = new RoundRectShape((float[])localObject2, null, null);
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape(paramContext);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    localShapeDrawable.getPaint().setColor(-1);
    localObject1[4] = localShapeDrawable;
    paramContext = new LayerDrawable((Drawable[])localObject1);
    localObject2 = new RoundRectShape((float[])localObject2, null, null);
    localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape((Shape)localObject2);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    localShapeDrawable.getPaint().setColor(-526345);
    localObject1[4] = localShapeDrawable;
    localObject1 = new LayerDrawable((Drawable[])localObject1);
    localObject2 = new StateListDrawable();
    ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
    ((StateListDrawable)localObject2).addState(new int[] { 16842910 }, paramContext);
    return localObject2;
  }
  
  public static StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2, String paramString1, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    localURLDrawableOptions.mFailedDrawable = paramDrawable1;
    paramDrawable1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
    paramString1 = URLDrawable.URLDrawableOptions.obtain();
    paramString1.mLoadingDrawable = paramDrawable2;
    paramString1.mFailedDrawable = paramDrawable2;
    paramDrawable2 = URLDrawable.getDrawable(paramString2, paramString1);
    paramString1 = new StateListDrawable();
    paramString1.addState(new int[] { 16842919 }, paramDrawable2);
    paramString1.addState(new int[] { 16842910 }, paramDrawable1);
    return paramString1;
  }
  
  public static StateListDrawable a(String paramString1, String paramString2, Context paramContext)
  {
    paramString1 = URLDrawable.getDrawable(paramString1, paramContext.getResources().getDrawable(2130850033), paramContext.getResources().getDrawable(2130850033));
    paramString2 = URLDrawable.getDrawable(paramString2);
    paramContext = new StateListDrawable();
    paramContext.addState(new int[] { 16842919 }, paramString1);
    paramContext.addState(new int[] { 16842908 }, paramString2);
    paramContext.addState(new int[] { 16842910 }, paramString2);
    paramContext.addState(new int[0], paramString2);
    return paramContext;
  }
  
  public static Object a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("game_center_sp", 0).getString(paramString + paramQQAppInterface.getCurrentAccountUin(), "");
    if (TextUtils.isEmpty(paramQQAppInterface)) {
      return null;
    }
    paramQQAppInterface = new ByteArrayInputStream(Base64.decode(paramQQAppInterface.getBytes(), 0));
    paramString = new ObjectInputStream(paramQQAppInterface);
    Object localObject = paramString.readObject();
    paramQQAppInterface.close();
    paramString.close();
    return localObject;
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      String str3 = paramMessageRecord.extStr;
      Object localObject = str3;
      str1 = str2;
      if (TextUtils.isEmpty(str3))
      {
        str1 = str2;
        localObject = paramMessageRecord.mExJsonObject.toString();
      }
      str1 = str2;
      paramMessageRecord = str2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = str2;
        localObject = new JSONObject((String)localObject);
        str1 = str2;
        paramMessageRecord = aoqq.a(((JSONObject)localObject).optString("report_key_bytes_oac_msg_extend", ""));
        str1 = str2;
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          return paramMessageRecord;
        }
        str1 = str2;
        str2 = ((JSONObject)localObject).optString("public_account_msg_id", "");
        str1 = str2;
        paramMessageRecord = str2;
        if (TextUtils.isEmpty(str2))
        {
          str1 = str2;
          paramMessageRecord = ((JSONObject)localObject).optString("pa_msgId", "");
          return paramMessageRecord;
        }
      }
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.e("QQGameConstant", 1, "getPAMsgId error =" + paramMessageRecord.toString());
      paramMessageRecord = str1;
    }
    return paramMessageRecord;
  }
  
  /* Error */
  public static String a(MessageRecord paramMessageRecord, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc_w 263
    //   9: iconst_1
    //   10: new 173	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 279
    //   20: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 285	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: ifnonnull +10 -> 44
    //   37: ldc 187
    //   39: astore 7
    //   41: aload 7
    //   43: areturn
    //   44: ldc 187
    //   46: astore 8
    //   48: ldc 187
    //   50: astore 11
    //   52: ldc 187
    //   54: astore 9
    //   56: aload_0
    //   57: invokestatic 287	auud:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   60: astore 12
    //   62: iload_1
    //   63: ifne +564 -> 627
    //   66: new 173	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   73: aload 12
    //   75: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc_w 289
    //   81: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 7
    //   89: getstatic 43	auud:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   92: aload 7
    //   94: invokeinterface 295 2 0
    //   99: ifeq +74 -> 173
    //   102: getstatic 43	auud:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   105: aload 7
    //   107: invokeinterface 299 2 0
    //   112: checkcast 203	java/lang/String
    //   115: astore 10
    //   117: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +41 -> 161
    //   123: ldc_w 263
    //   126: iconst_1
    //   127: new 173	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 301
    //   137: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload_1
    //   141: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: ldc_w 303
    //   147: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 10
    //   152: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 285	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aload 10
    //   163: astore 7
    //   165: aload 10
    //   167: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifeq -129 -> 41
    //   173: aload_0
    //   174: getfield 237	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   177: astore 7
    //   179: aload 7
    //   181: astore 10
    //   183: aload 7
    //   185: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifeq +12 -> 200
    //   191: aload_0
    //   192: getfield 241	com/tencent/mobileqq/data/MessageRecord:mExJsonObject	Lorg/json/JSONObject;
    //   195: invokevirtual 244	org/json/JSONObject:toString	()Ljava/lang/String;
    //   198: astore 10
    //   200: aload 8
    //   202: astore 7
    //   204: aload 10
    //   206: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   209: ifne +701 -> 910
    //   212: aload 8
    //   214: astore 7
    //   216: new 243	org/json/JSONObject
    //   219: dup
    //   220: aload 10
    //   222: invokespecial 247	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   225: ldc 249
    //   227: ldc 187
    //   229: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   232: astore 10
    //   234: aload 8
    //   236: astore 7
    //   238: aload 10
    //   240: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   243: ifne +499 -> 742
    //   246: aload 8
    //   248: astore 7
    //   250: new 243	org/json/JSONObject
    //   253: dup
    //   254: aload 10
    //   256: invokespecial 247	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   259: ldc_w 305
    //   262: ldc 187
    //   264: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   267: astore 10
    //   269: aload 8
    //   271: astore 7
    //   273: aload 10
    //   275: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   278: ifne +950 -> 1228
    //   281: aload 8
    //   283: astore 7
    //   285: new 243	org/json/JSONObject
    //   288: dup
    //   289: aload 10
    //   291: invokespecial 247	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   294: astore 11
    //   296: aload 8
    //   298: astore 7
    //   300: aload 11
    //   302: ldc_w 307
    //   305: invokevirtual 311	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   308: astore 10
    //   310: aload 10
    //   312: ifnull +909 -> 1221
    //   315: aload 8
    //   317: astore 7
    //   319: aload 10
    //   321: invokevirtual 314	org/json/JSONArray:toString	()Ljava/lang/String;
    //   324: astore 9
    //   326: aload 8
    //   328: astore 7
    //   330: aload 10
    //   332: iconst_0
    //   333: invokevirtual 318	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   336: ldc_w 320
    //   339: ldc 187
    //   341: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   344: astore 8
    //   346: aload 8
    //   348: astore 7
    //   350: aload 10
    //   352: iconst_1
    //   353: invokevirtual 318	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   356: ldc_w 322
    //   359: ldc 187
    //   361: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   364: astore 10
    //   366: aload 8
    //   368: astore 7
    //   370: aload 11
    //   372: ldc_w 324
    //   375: ldc 187
    //   377: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   380: astore 11
    //   382: aload 8
    //   384: astore 7
    //   386: getstatic 43	auud:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   389: new 173	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   396: aload 12
    //   398: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: ldc_w 289
    //   404: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: aload 8
    //   412: invokeinterface 328 3 0
    //   417: pop
    //   418: aload 8
    //   420: astore 7
    //   422: getstatic 43	auud:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   425: new 173	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   432: aload 12
    //   434: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: ldc_w 330
    //   440: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: aload 10
    //   448: invokeinterface 328 3 0
    //   453: pop
    //   454: aload 8
    //   456: astore 7
    //   458: getstatic 43	auud:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   461: new 173	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   468: aload 12
    //   470: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: ldc_w 332
    //   476: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: aload 11
    //   484: invokeinterface 328 3 0
    //   489: pop
    //   490: aload 8
    //   492: astore 7
    //   494: getstatic 43	auud:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   497: new 173	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   504: aload 12
    //   506: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc_w 334
    //   512: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: aload 9
    //   520: invokeinterface 328 3 0
    //   525: pop
    //   526: aload 8
    //   528: astore 7
    //   530: aload 10
    //   532: astore 8
    //   534: aload 11
    //   536: astore 10
    //   538: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   541: ifeq +74 -> 615
    //   544: ldc_w 263
    //   547: iconst_1
    //   548: new 173	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   555: ldc_w 336
    //   558: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: iload_1
    //   562: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   565: ldc_w 338
    //   568: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: aload 7
    //   573: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: ldc_w 340
    //   579: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload 8
    //   584: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: ldc_w 342
    //   590: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload 10
    //   595: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: ldc_w 344
    //   601: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: aload 9
    //   606: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 285	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: iload_1
    //   616: ifeq -575 -> 41
    //   619: iload_1
    //   620: iconst_1
    //   621: if_icmpne +102 -> 723
    //   624: aload 8
    //   626: areturn
    //   627: iload_1
    //   628: iconst_1
    //   629: if_icmpne +29 -> 658
    //   632: new 173	java/lang/StringBuilder
    //   635: dup
    //   636: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   639: aload 12
    //   641: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: ldc_w 330
    //   647: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   653: astore 7
    //   655: goto -566 -> 89
    //   658: iload_1
    //   659: iconst_2
    //   660: if_icmpne +29 -> 689
    //   663: new 173	java/lang/StringBuilder
    //   666: dup
    //   667: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   670: aload 12
    //   672: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: ldc_w 332
    //   678: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: astore 7
    //   686: goto -597 -> 89
    //   689: iload_1
    //   690: iconst_4
    //   691: if_icmpne +29 -> 720
    //   694: new 173	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   701: aload 12
    //   703: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: ldc_w 334
    //   709: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: astore 7
    //   717: goto -628 -> 89
    //   720: ldc 187
    //   722: areturn
    //   723: iload_1
    //   724: iconst_2
    //   725: if_icmpne +6 -> 731
    //   728: aload 10
    //   730: areturn
    //   731: iload_1
    //   732: iconst_4
    //   733: if_icmpne +6 -> 739
    //   736: aload 9
    //   738: areturn
    //   739: ldc 187
    //   741: areturn
    //   742: ldc 187
    //   744: astore 7
    //   746: iload_1
    //   747: ifne +423 -> 1170
    //   750: aload_0
    //   751: instanceof 346
    //   754: ifeq +197 -> 951
    //   757: aload_0
    //   758: checkcast 346	com/tencent/mobileqq/data/MessageForArkApp
    //   761: astore_0
    //   762: aload_0
    //   763: getfield 350	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   766: getfield 355	com/tencent/mobileqq/data/ArkAppMessage:mSourceName	Ljava/lang/String;
    //   769: astore 8
    //   771: getstatic 43	auud:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   774: new 173	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   781: aload 12
    //   783: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: ldc_w 289
    //   789: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: aload 8
    //   797: invokeinterface 328 3 0
    //   802: pop
    //   803: aload 8
    //   805: astore 7
    //   807: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   810: ifeq -769 -> 41
    //   813: ldc_w 263
    //   816: iconst_1
    //   817: new 173	java/lang/StringBuilder
    //   820: dup
    //   821: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   824: ldc_w 357
    //   827: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: iload_1
    //   831: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   834: ldc_w 338
    //   837: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: aload 8
    //   842: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   848: invokestatic 285	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   851: aload 8
    //   853: areturn
    //   854: astore 9
    //   856: aload 7
    //   858: astore 8
    //   860: aload 9
    //   862: invokevirtual 360	java/lang/Throwable:printStackTrace	()V
    //   865: aload 8
    //   867: astore 7
    //   869: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   872: ifeq +38 -> 910
    //   875: ldc_w 263
    //   878: iconst_1
    //   879: new 173	java/lang/StringBuilder
    //   882: dup
    //   883: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   886: ldc_w 362
    //   889: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: aload 9
    //   894: invokevirtual 365	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   897: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokestatic 285	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   906: aload 8
    //   908: astore 7
    //   910: goto -164 -> 746
    //   913: astore_0
    //   914: ldc_w 263
    //   917: iconst_1
    //   918: new 173	java/lang/StringBuilder
    //   921: dup
    //   922: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   925: ldc_w 367
    //   928: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: aload_0
    //   932: invokevirtual 266	java/lang/Throwable:toString	()Ljava/lang/String;
    //   935: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   944: aload 7
    //   946: astore 8
    //   948: goto -177 -> 771
    //   951: aload 7
    //   953: astore 8
    //   955: aload_0
    //   956: instanceof 369
    //   959: ifeq -188 -> 771
    //   962: aload_0
    //   963: checkcast 369	com/tencent/mobileqq/data/MessageForStructing
    //   966: getfield 373	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   969: checkcast 375	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   972: astore_0
    //   973: aload_0
    //   974: invokevirtual 379	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:getStructMsgItemLists	()Ljava/util/List;
    //   977: checkcast 381	java/util/ArrayList
    //   980: astore 7
    //   982: aload 7
    //   984: ifnonnull +259 -> 1243
    //   987: ldc 187
    //   989: areturn
    //   990: iload 5
    //   992: aload 7
    //   994: invokevirtual 385	java/util/ArrayList:size	()I
    //   997: if_icmpge +120 -> 1117
    //   1000: aload 7
    //   1002: iload 5
    //   1004: invokevirtual 388	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1007: instanceof 390
    //   1010: ifeq +254 -> 1264
    //   1013: aload 7
    //   1015: iload 5
    //   1017: invokevirtual 388	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1020: checkcast 390	bcvt
    //   1023: checkcast 390	bcvt
    //   1026: getfield 393	bcvt:a	Ljava/util/ArrayList;
    //   1029: astore 8
    //   1031: iload_1
    //   1032: istore_3
    //   1033: iload_2
    //   1034: istore_1
    //   1035: iconst_0
    //   1036: istore 6
    //   1038: iload_3
    //   1039: istore_2
    //   1040: iload_2
    //   1041: istore_3
    //   1042: iload_1
    //   1043: istore 4
    //   1045: iload 6
    //   1047: aload 8
    //   1049: invokevirtual 385	java/util/ArrayList:size	()I
    //   1052: if_icmpge +217 -> 1269
    //   1055: aload 8
    //   1057: iload 6
    //   1059: invokevirtual 388	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1062: instanceof 395
    //   1065: ifeq +30 -> 1095
    //   1068: iconst_1
    //   1069: istore_3
    //   1070: iload_3
    //   1071: ifeq +182 -> 1253
    //   1074: iload_2
    //   1075: ifeq +178 -> 1253
    //   1078: aload 7
    //   1080: iload 5
    //   1082: invokevirtual 388	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1085: checkcast 397	bcvs
    //   1088: getfield 398	bcvs:b	Ljava/lang/String;
    //   1091: invokestatic 399	auud:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1094: areturn
    //   1095: iload_1
    //   1096: istore_3
    //   1097: aload 8
    //   1099: iload 6
    //   1101: invokevirtual 388	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1104: instanceof 401
    //   1107: ifeq -37 -> 1070
    //   1110: iconst_1
    //   1111: istore_2
    //   1112: iload_1
    //   1113: istore_3
    //   1114: goto -44 -> 1070
    //   1117: aload 7
    //   1119: invokevirtual 385	java/util/ArrayList:size	()I
    //   1122: iconst_2
    //   1123: if_icmpne +44 -> 1167
    //   1126: aload_0
    //   1127: getfield 404	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:mMsgUrl	Ljava/lang/String;
    //   1130: invokestatic 399	auud:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1133: astore_0
    //   1134: aload_0
    //   1135: areturn
    //   1136: astore_0
    //   1137: ldc_w 263
    //   1140: iconst_1
    //   1141: new 173	java/lang/StringBuilder
    //   1144: dup
    //   1145: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1148: ldc_w 406
    //   1151: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload_0
    //   1155: invokevirtual 266	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1158: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1161: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1164: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1167: ldc 187
    //   1169: areturn
    //   1170: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1173: ifeq +36 -> 1209
    //   1176: ldc_w 263
    //   1179: iconst_1
    //   1180: new 173	java/lang/StringBuilder
    //   1183: dup
    //   1184: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1187: ldc_w 357
    //   1190: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: iload_1
    //   1194: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1197: ldc_w 408
    //   1200: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1206: invokestatic 285	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1209: ldc 187
    //   1211: areturn
    //   1212: astore 9
    //   1214: aload 7
    //   1216: astore 8
    //   1218: goto -358 -> 860
    //   1221: ldc 187
    //   1223: astore 10
    //   1225: goto -859 -> 366
    //   1228: ldc 187
    //   1230: astore 7
    //   1232: ldc 187
    //   1234: astore 8
    //   1236: aload 11
    //   1238: astore 10
    //   1240: goto -702 -> 538
    //   1243: iconst_0
    //   1244: istore 5
    //   1246: iconst_0
    //   1247: istore_1
    //   1248: iconst_0
    //   1249: istore_2
    //   1250: goto -260 -> 990
    //   1253: iload 6
    //   1255: iconst_1
    //   1256: iadd
    //   1257: istore 6
    //   1259: iload_3
    //   1260: istore_1
    //   1261: goto -221 -> 1040
    //   1264: iload_2
    //   1265: istore 4
    //   1267: iload_1
    //   1268: istore_3
    //   1269: iload 5
    //   1271: iconst_1
    //   1272: iadd
    //   1273: istore 5
    //   1275: iload 4
    //   1277: istore_2
    //   1278: iload_3
    //   1279: istore_1
    //   1280: goto -290 -> 990
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1283	0	paramMessageRecord	MessageRecord
    //   0	1283	1	paramInt	int
    //   1033	245	2	i	int
    //   1032	247	3	j	int
    //   1043	233	4	k	int
    //   990	284	5	m	int
    //   1036	222	6	n	int
    //   39	1192	7	localObject1	Object
    //   46	1189	8	localObject2	Object
    //   54	683	9	str1	String
    //   854	39	9	localThrowable1	Throwable
    //   1212	1	9	localThrowable2	Throwable
    //   115	1124	10	localObject3	Object
    //   50	1187	11	localObject4	Object
    //   60	722	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   216	234	854	java/lang/Throwable
    //   238	246	854	java/lang/Throwable
    //   250	269	854	java/lang/Throwable
    //   273	281	854	java/lang/Throwable
    //   285	296	854	java/lang/Throwable
    //   300	310	854	java/lang/Throwable
    //   319	326	854	java/lang/Throwable
    //   330	346	854	java/lang/Throwable
    //   350	366	854	java/lang/Throwable
    //   370	382	854	java/lang/Throwable
    //   386	418	854	java/lang/Throwable
    //   422	454	854	java/lang/Throwable
    //   458	490	854	java/lang/Throwable
    //   494	526	854	java/lang/Throwable
    //   762	771	913	java/lang/Throwable
    //   962	982	1136	java/lang/Throwable
    //   990	1031	1136	java/lang/Throwable
    //   1045	1068	1136	java/lang/Throwable
    //   1078	1095	1136	java/lang/Throwable
    //   1097	1110	1136	java/lang/Throwable
    //   1117	1134	1136	java/lang/Throwable
    //   538	615	1212	java/lang/Throwable
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (!paramString.contains("pubAccountAppid")) {}
    }
    try
    {
      localObject1 = Uri.parse(paramString).getQueryParameter("pubAccountAppid");
      return localObject1;
    }
    catch (Exception paramString)
    {
      QLog.e("QQGameConstant", 1, "getappid error=" + paramString.toString());
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    bfup.a(paramContext, TroopInfoActivity.a(paramString, 3001), 2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    Object localObject = new ByteArrayOutputStream();
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
    localObjectOutputStream.writeObject(paramObject);
    paramObject = new String(Base64.encode(((ByteArrayOutputStream)localObject).toByteArray(), 0));
    ((ByteArrayOutputStream)localObject).close();
    localObjectOutputStream.close();
    localObject = paramQQAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    paramQQAppInterface = paramString + paramQQAppInterface.getCurrentAccountUin();
    ((SharedPreferences)localObject).edit().putString(paramQQAppInterface, paramObject).commit();
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (jdField_a_of_type_JavaUtilQueue == null) {
      jdField_a_of_type_JavaUtilQueue = new ArrayDeque(100);
    }
    if (jdField_a_of_type_JavaUtilQueue.size() >= 100) {
      jdField_a_of_type_JavaUtilQueue.poll();
    }
    jdField_a_of_type_JavaUtilQueue.add(paramString);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      QLog.e("QQGameConstant", 1, "[launchAppWithTokens] ticket is null");
      QQToast.a(paramContext, 1, anni.a(2131709053), 0).b(0);
      return;
    }
    paramString3 = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=&" + paramString3;
    bbyc localbbyc = new bbyc();
    AppInterface localAppInterface = ampj.a();
    localbbyc.a(localAppInterface, paramContext, paramString1, paramString3, paramString2, 536870912);
    ((VasExtensionHandler)localAppInterface.getBusinessHandler(71)).a(paramString1, localAppInterface.getCurrentAccountUin(), 1);
  }
  
  public static boolean a(FeedsItemData.RedInfo paramRedInfo)
  {
    if ((paramRedInfo == null) || (TextUtils.isEmpty(paramRedInfo.redPointId))) {}
    long l;
    do
    {
      return false;
      if (jdField_a_of_type_JavaUtilQueue == null) {
        jdField_a_of_type_JavaUtilQueue = new ArrayDeque(100);
      }
      l = System.currentTimeMillis() / 1000L;
    } while ((paramRedInfo.redPointStartTime >= l) || (paramRedInfo.redPointEndTime <= l) || (jdField_a_of_type_JavaUtilQueue.contains(paramRedInfo.redPointId)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auud
 * JD-Core Version:    0.7.0.1
 */