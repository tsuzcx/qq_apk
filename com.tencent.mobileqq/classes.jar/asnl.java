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

public class asnl
{
  public static final String a;
  public static Map<String, String> a;
  public static Queue<String> a;
  public static boolean a;
  public static final String b;
  public static final String c;
  
  static
  {
    jdField_a_of_type_JavaUtilQueue = new ArrayDeque(100);
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaLangString = alud.a(2131710679);
    b = alud.a(2131710678);
    c = alud.a(2131710680);
    jdField_a_of_type_Boolean = true;
  }
  
  public static ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { { 16842919 }, { 16842910 } }, new int[] { paramInt2, paramInt1 });
  }
  
  public static StateListDrawable a(Context paramContext)
  {
    Object localObject1 = new Drawable[3];
    float f1 = aepi.a(4.0F, paramContext.getResources());
    float f2 = aepi.a(4.0F, paramContext.getResources());
    float f3 = aepi.a(4.0F, paramContext.getResources());
    float f4 = aepi.a(4.0F, paramContext.getResources());
    int i = 0;
    while (i < 2)
    {
      localObject2 = new RoundRectShape(new float[] { f1, f1, f2, f2, f3, f3, f4, f4 }, null, null);
      localShapeDrawable = new ShapeDrawable();
      localShapeDrawable.setPadding(aepi.a(2.0F, paramContext.getResources()), aepi.a(0.0F, paramContext.getResources()), aepi.a(2.0F, paramContext.getResources()), aepi.a(2.0F, paramContext.getResources()));
      localShapeDrawable.setShape((Shape)localObject2);
      localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
      localShapeDrawable.getPaint().setColor(83886080);
      localObject1[i] = localShapeDrawable;
      i += 1;
    }
    Object localObject2 = new float[8];
    localObject2[0] = (f1 / 2.0F);
    localObject2[1] = (f1 / 2.0F);
    localObject2[2] = (f2 / 2.0F);
    localObject2[3] = (f2 / 2.0F);
    localObject2[4] = (f3 / 2.0F);
    localObject2[5] = (f3 / 2.0F);
    localObject2[6] = (f4 / 2.0F);
    localObject2[7] = (f4 / 2.0F);
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
    paramFloat1 = aepi.a(paramFloat1, paramContext.getResources());
    paramFloat2 = aepi.a(paramFloat2, paramContext.getResources());
    paramFloat3 = aepi.a(paramFloat3, paramContext.getResources());
    float f = aepi.a(paramFloat4, paramContext.getResources());
    int i = 0;
    if (i < 4)
    {
      localObject2 = new RoundRectShape(new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, f, f }, null, null);
      localShapeDrawable = new ShapeDrawable();
      if (paramFloat4 == 0.0F) {
        localShapeDrawable.setPadding(aepi.a(2.0F, paramContext.getResources()), aepi.a(0.0F, paramContext.getResources()), aepi.a(2.0F, paramContext.getResources()), 0);
      }
      for (;;)
      {
        localShapeDrawable.setShape((Shape)localObject2);
        localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        localShapeDrawable.getPaint().setColor(634178764);
        localObject1[i] = localShapeDrawable;
        i += 1;
        break;
        localShapeDrawable.setPadding(aepi.a(2.0F, paramContext.getResources()), aepi.a(0.0F, paramContext.getResources()), aepi.a(2.0F, paramContext.getResources()), aepi.a(2.0F, paramContext.getResources()));
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
    paramString1 = URLDrawable.getDrawable(paramString1, paramContext.getResources().getDrawable(2130849482), paramContext.getResources().getDrawable(2130849482));
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
      Object localObject = paramMessageRecord.extStr;
      paramMessageRecord = str2;
      str1 = str2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = str2;
        localObject = new JSONObject((String)localObject);
        str1 = str2;
        str2 = ((JSONObject)localObject).optString("public_account_msg_id", "");
        paramMessageRecord = str2;
        str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          str1 = str2;
          paramMessageRecord = ((JSONObject)localObject).optString("pa_msgId", "");
        }
      }
      return paramMessageRecord;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.e("QQGameConstant", 1, "getPAMsgId error =" + paramMessageRecord.toString());
    }
    return str1;
  }
  
  /* Error */
  public static String a(MessageRecord paramMessageRecord, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 251
    //   8: iconst_1
    //   9: new 173	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 267
    //   19: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: ifnonnull +10 -> 43
    //   36: ldc 187
    //   38: astore 7
    //   40: aload 7
    //   42: areturn
    //   43: ldc 187
    //   45: astore 8
    //   47: ldc 187
    //   49: astore 11
    //   51: ldc 187
    //   53: astore 9
    //   55: aload_0
    //   56: invokestatic 275	asnl:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   59: astore 12
    //   61: iload_1
    //   62: ifne +563 -> 625
    //   65: new 173	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   72: aload 12
    //   74: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc_w 277
    //   80: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore 7
    //   88: getstatic 29	asnl:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   91: aload 7
    //   93: invokeinterface 283 2 0
    //   98: ifeq +73 -> 171
    //   101: getstatic 29	asnl:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   104: aload 7
    //   106: invokeinterface 287 2 0
    //   111: checkcast 203	java/lang/String
    //   114: astore 10
    //   116: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +40 -> 159
    //   122: ldc 251
    //   124: iconst_1
    //   125: new 173	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 289
    //   135: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload_1
    //   139: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: ldc_w 291
    //   145: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 10
    //   150: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 10
    //   161: astore 7
    //   163: aload 10
    //   165: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   168: ifeq -128 -> 40
    //   171: aload_0
    //   172: getfield 237	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   175: astore 7
    //   177: aload 7
    //   179: astore 10
    //   181: aload 7
    //   183: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   186: ifeq +12 -> 198
    //   189: aload_0
    //   190: getfield 295	com/tencent/mobileqq/data/MessageRecord:mExJsonObject	Lorg/json/JSONObject;
    //   193: invokevirtual 296	org/json/JSONObject:toString	()Ljava/lang/String;
    //   196: astore 10
    //   198: aload 8
    //   200: astore 7
    //   202: aload 10
    //   204: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifne +699 -> 906
    //   210: aload 8
    //   212: astore 7
    //   214: new 239	org/json/JSONObject
    //   217: dup
    //   218: aload 10
    //   220: invokespecial 242	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   223: ldc_w 298
    //   226: ldc 187
    //   228: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   231: astore 10
    //   233: aload 8
    //   235: astore 7
    //   237: aload 10
    //   239: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: ifne +498 -> 740
    //   245: aload 8
    //   247: astore 7
    //   249: new 239	org/json/JSONObject
    //   252: dup
    //   253: aload 10
    //   255: invokespecial 242	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   258: ldc_w 300
    //   261: ldc 187
    //   263: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   266: astore 10
    //   268: aload 8
    //   270: astore 7
    //   272: aload 10
    //   274: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   277: ifne +944 -> 1221
    //   280: aload 8
    //   282: astore 7
    //   284: new 239	org/json/JSONObject
    //   287: dup
    //   288: aload 10
    //   290: invokespecial 242	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   293: astore 11
    //   295: aload 8
    //   297: astore 7
    //   299: aload 11
    //   301: ldc_w 302
    //   304: invokevirtual 306	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   307: astore 10
    //   309: aload 10
    //   311: ifnull +903 -> 1214
    //   314: aload 8
    //   316: astore 7
    //   318: aload 10
    //   320: invokevirtual 309	org/json/JSONArray:toString	()Ljava/lang/String;
    //   323: astore 9
    //   325: aload 8
    //   327: astore 7
    //   329: aload 10
    //   331: iconst_0
    //   332: invokevirtual 313	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   335: ldc_w 315
    //   338: ldc 187
    //   340: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   343: astore 8
    //   345: aload 8
    //   347: astore 7
    //   349: aload 10
    //   351: iconst_1
    //   352: invokevirtual 313	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   355: ldc_w 317
    //   358: ldc 187
    //   360: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   363: astore 10
    //   365: aload 8
    //   367: astore 7
    //   369: aload 11
    //   371: ldc_w 319
    //   374: ldc 187
    //   376: invokevirtual 247	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   379: astore 11
    //   381: aload 8
    //   383: astore 7
    //   385: getstatic 29	asnl:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   388: new 173	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   395: aload 12
    //   397: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc_w 277
    //   403: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: aload 8
    //   411: invokeinterface 323 3 0
    //   416: pop
    //   417: aload 8
    //   419: astore 7
    //   421: getstatic 29	asnl:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   424: new 173	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   431: aload 12
    //   433: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: ldc_w 325
    //   439: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: aload 10
    //   447: invokeinterface 323 3 0
    //   452: pop
    //   453: aload 8
    //   455: astore 7
    //   457: getstatic 29	asnl:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   460: new 173	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   467: aload 12
    //   469: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: ldc_w 327
    //   475: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: aload 11
    //   483: invokeinterface 323 3 0
    //   488: pop
    //   489: aload 8
    //   491: astore 7
    //   493: getstatic 29	asnl:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   496: new 173	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   503: aload 12
    //   505: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: ldc_w 329
    //   511: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: aload 9
    //   519: invokeinterface 323 3 0
    //   524: pop
    //   525: aload 8
    //   527: astore 7
    //   529: aload 10
    //   531: astore 8
    //   533: aload 11
    //   535: astore 10
    //   537: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq +73 -> 613
    //   543: ldc 251
    //   545: iconst_1
    //   546: new 173	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   553: ldc_w 331
    //   556: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: iload_1
    //   560: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: ldc_w 333
    //   566: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload 7
    //   571: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: ldc_w 335
    //   577: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: aload 8
    //   582: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: ldc_w 337
    //   588: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: aload 10
    //   593: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: ldc_w 339
    //   599: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload 9
    //   604: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: iload_1
    //   614: ifeq -574 -> 40
    //   617: iload_1
    //   618: iconst_1
    //   619: if_icmpne +102 -> 721
    //   622: aload 8
    //   624: areturn
    //   625: iload_1
    //   626: iconst_1
    //   627: if_icmpne +29 -> 656
    //   630: new 173	java/lang/StringBuilder
    //   633: dup
    //   634: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   637: aload 12
    //   639: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: ldc_w 325
    //   645: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: astore 7
    //   653: goto -565 -> 88
    //   656: iload_1
    //   657: iconst_2
    //   658: if_icmpne +29 -> 687
    //   661: new 173	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   668: aload 12
    //   670: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: ldc_w 327
    //   676: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: astore 7
    //   684: goto -596 -> 88
    //   687: iload_1
    //   688: iconst_4
    //   689: if_icmpne +29 -> 718
    //   692: new 173	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   699: aload 12
    //   701: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: ldc_w 329
    //   707: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   713: astore 7
    //   715: goto -627 -> 88
    //   718: ldc 187
    //   720: areturn
    //   721: iload_1
    //   722: iconst_2
    //   723: if_icmpne +6 -> 729
    //   726: aload 10
    //   728: areturn
    //   729: iload_1
    //   730: iconst_4
    //   731: if_icmpne +6 -> 737
    //   734: aload 9
    //   736: areturn
    //   737: ldc 187
    //   739: areturn
    //   740: ldc 187
    //   742: astore 7
    //   744: iload_1
    //   745: ifne +419 -> 1164
    //   748: aload_0
    //   749: instanceof 341
    //   752: ifeq +194 -> 946
    //   755: aload_0
    //   756: checkcast 341	com/tencent/mobileqq/data/MessageForArkApp
    //   759: astore_0
    //   760: aload_0
    //   761: getfield 345	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   764: getfield 350	com/tencent/mobileqq/data/ArkAppMessage:mSourceName	Ljava/lang/String;
    //   767: astore 8
    //   769: getstatic 29	asnl:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   772: new 173	java/lang/StringBuilder
    //   775: dup
    //   776: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   779: aload 12
    //   781: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: ldc_w 277
    //   787: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: aload 8
    //   795: invokeinterface 323 3 0
    //   800: pop
    //   801: aload 8
    //   803: astore 7
    //   805: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   808: ifeq -768 -> 40
    //   811: ldc 251
    //   813: iconst_1
    //   814: new 173	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   821: ldc_w 352
    //   824: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: iload_1
    //   828: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   831: ldc_w 333
    //   834: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: aload 8
    //   839: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   845: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   848: aload 8
    //   850: areturn
    //   851: astore 9
    //   853: aload 7
    //   855: astore 8
    //   857: aload 9
    //   859: invokevirtual 355	java/lang/Throwable:printStackTrace	()V
    //   862: aload 8
    //   864: astore 7
    //   866: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   869: ifeq +37 -> 906
    //   872: ldc 251
    //   874: iconst_1
    //   875: new 173	java/lang/StringBuilder
    //   878: dup
    //   879: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   882: ldc_w 357
    //   885: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: aload 9
    //   890: invokevirtual 360	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   893: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   899: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   902: aload 8
    //   904: astore 7
    //   906: goto -162 -> 744
    //   909: astore_0
    //   910: ldc 251
    //   912: iconst_1
    //   913: new 173	java/lang/StringBuilder
    //   916: dup
    //   917: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   920: ldc_w 362
    //   923: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: aload_0
    //   927: invokevirtual 254	java/lang/Throwable:toString	()Ljava/lang/String;
    //   930: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   936: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   939: aload 7
    //   941: astore 8
    //   943: goto -174 -> 769
    //   946: aload 7
    //   948: astore 8
    //   950: aload_0
    //   951: instanceof 364
    //   954: ifeq -185 -> 769
    //   957: aload_0
    //   958: checkcast 364	com/tencent/mobileqq/data/MessageForStructing
    //   961: getfield 368	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   964: checkcast 370	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   967: astore_0
    //   968: aload_0
    //   969: invokevirtual 374	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:getStructMsgItemLists	()Ljava/util/List;
    //   972: checkcast 376	java/util/ArrayList
    //   975: astore 7
    //   977: aload 7
    //   979: ifnonnull +257 -> 1236
    //   982: ldc 187
    //   984: areturn
    //   985: iload 5
    //   987: aload 7
    //   989: invokevirtual 380	java/util/ArrayList:size	()I
    //   992: if_icmpge +120 -> 1112
    //   995: aload 7
    //   997: iload 5
    //   999: invokevirtual 383	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1002: instanceof 385
    //   1005: ifeq +252 -> 1257
    //   1008: aload 7
    //   1010: iload 5
    //   1012: invokevirtual 383	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1015: checkcast 385	azut
    //   1018: checkcast 385	azut
    //   1021: getfield 388	azut:a	Ljava/util/ArrayList;
    //   1024: astore 8
    //   1026: iload_1
    //   1027: istore_3
    //   1028: iload_2
    //   1029: istore_1
    //   1030: iconst_0
    //   1031: istore 6
    //   1033: iload_3
    //   1034: istore_2
    //   1035: iload_2
    //   1036: istore_3
    //   1037: iload_1
    //   1038: istore 4
    //   1040: iload 6
    //   1042: aload 8
    //   1044: invokevirtual 380	java/util/ArrayList:size	()I
    //   1047: if_icmpge +215 -> 1262
    //   1050: aload 8
    //   1052: iload 6
    //   1054: invokevirtual 383	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1057: instanceof 390
    //   1060: ifeq +30 -> 1090
    //   1063: iconst_1
    //   1064: istore_3
    //   1065: iload_3
    //   1066: ifeq +180 -> 1246
    //   1069: iload_2
    //   1070: ifeq +176 -> 1246
    //   1073: aload 7
    //   1075: iload 5
    //   1077: invokevirtual 383	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1080: checkcast 392	azus
    //   1083: getfield 393	azus:b	Ljava/lang/String;
    //   1086: invokestatic 396	asnl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1089: areturn
    //   1090: iload_1
    //   1091: istore_3
    //   1092: aload 8
    //   1094: iload 6
    //   1096: invokevirtual 383	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1099: instanceof 398
    //   1102: ifeq -37 -> 1065
    //   1105: iconst_1
    //   1106: istore_2
    //   1107: iload_1
    //   1108: istore_3
    //   1109: goto -44 -> 1065
    //   1112: aload 7
    //   1114: invokevirtual 380	java/util/ArrayList:size	()I
    //   1117: iconst_2
    //   1118: if_icmpne +43 -> 1161
    //   1121: aload_0
    //   1122: getfield 401	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:mMsgUrl	Ljava/lang/String;
    //   1125: invokestatic 396	asnl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1128: astore_0
    //   1129: aload_0
    //   1130: areturn
    //   1131: astore_0
    //   1132: ldc 251
    //   1134: iconst_1
    //   1135: new 173	java/lang/StringBuilder
    //   1138: dup
    //   1139: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1142: ldc_w 403
    //   1145: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: aload_0
    //   1149: invokevirtual 254	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1152: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1158: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1161: ldc 187
    //   1163: areturn
    //   1164: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1167: ifeq +35 -> 1202
    //   1170: ldc 251
    //   1172: iconst_1
    //   1173: new 173	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   1180: ldc_w 352
    //   1183: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: iload_1
    //   1187: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1190: ldc_w 405
    //   1193: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1199: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1202: ldc 187
    //   1204: areturn
    //   1205: astore 9
    //   1207: aload 7
    //   1209: astore 8
    //   1211: goto -354 -> 857
    //   1214: ldc 187
    //   1216: astore 10
    //   1218: goto -853 -> 365
    //   1221: ldc 187
    //   1223: astore 7
    //   1225: ldc 187
    //   1227: astore 8
    //   1229: aload 11
    //   1231: astore 10
    //   1233: goto -696 -> 537
    //   1236: iconst_0
    //   1237: istore 5
    //   1239: iconst_0
    //   1240: istore_1
    //   1241: iconst_0
    //   1242: istore_2
    //   1243: goto -258 -> 985
    //   1246: iload 6
    //   1248: iconst_1
    //   1249: iadd
    //   1250: istore 6
    //   1252: iload_3
    //   1253: istore_1
    //   1254: goto -219 -> 1035
    //   1257: iload_2
    //   1258: istore 4
    //   1260: iload_1
    //   1261: istore_3
    //   1262: iload 5
    //   1264: iconst_1
    //   1265: iadd
    //   1266: istore 5
    //   1268: iload 4
    //   1270: istore_2
    //   1271: iload_3
    //   1272: istore_1
    //   1273: goto -288 -> 985
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1276	0	paramMessageRecord	MessageRecord
    //   0	1276	1	paramInt	int
    //   1028	243	2	i	int
    //   1027	245	3	j	int
    //   1038	231	4	k	int
    //   985	282	5	m	int
    //   1031	220	6	n	int
    //   38	1186	7	localObject1	Object
    //   45	1183	8	localObject2	Object
    //   53	682	9	str1	String
    //   851	38	9	localThrowable1	Throwable
    //   1205	1	9	localThrowable2	Throwable
    //   114	1118	10	localObject3	Object
    //   49	1181	11	localObject4	Object
    //   59	721	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   214	233	851	java/lang/Throwable
    //   237	245	851	java/lang/Throwable
    //   249	268	851	java/lang/Throwable
    //   272	280	851	java/lang/Throwable
    //   284	295	851	java/lang/Throwable
    //   299	309	851	java/lang/Throwable
    //   318	325	851	java/lang/Throwable
    //   329	345	851	java/lang/Throwable
    //   349	365	851	java/lang/Throwable
    //   369	381	851	java/lang/Throwable
    //   385	417	851	java/lang/Throwable
    //   421	453	851	java/lang/Throwable
    //   457	489	851	java/lang/Throwable
    //   493	525	851	java/lang/Throwable
    //   760	769	909	java/lang/Throwable
    //   957	977	1131	java/lang/Throwable
    //   985	1026	1131	java/lang/Throwable
    //   1040	1063	1131	java/lang/Throwable
    //   1073	1090	1131	java/lang/Throwable
    //   1092	1105	1131	java/lang/Throwable
    //   1112	1129	1131	java/lang/Throwable
    //   537	613	1205	java/lang/Throwable
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
    bcpx.a(paramContext, TroopInfoActivity.a(paramString, 3001), 2);
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
      QQToast.a(paramContext, 1, alud.a(2131710677), 0).b(0);
      return;
    }
    paramString3 = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=&" + paramString3;
    ayyy localayyy = new ayyy();
    AppInterface localAppInterface = akwd.a();
    localayyy.a(localAppInterface, paramContext, paramString1, paramString3, paramString2, 536870912);
    ((bdug)localAppInterface.getBusinessHandler(71)).a(paramString1, localAppInterface.getCurrentAccountUin(), 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnl
 * JD-Core Version:    0.7.0.1
 */