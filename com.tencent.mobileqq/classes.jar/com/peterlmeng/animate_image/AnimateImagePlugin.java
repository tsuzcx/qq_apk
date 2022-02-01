package com.peterlmeng.animate_image;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.LongSparseArray;
import com.peterlmeng.animate_image.renderer.IRenderWorkerFactory;
import com.peterlmeng.animate_image.renderer.OpenGlRenderer2;
import com.peterlmeng.animate_image.renderer.RenderWorker;
import com.peterlmeng.animate_image.renderer.RenderWorkerFactory;
import com.peterlmeng.animate_image.support.log.ILog;
import com.peterlmeng.animate_image.support.log.LogUtils;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.EventChannel.StreamHandler;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.view.TextureRegistry;
import java.util.HashMap;
import java.util.Map;

public class AnimateImagePlugin
  implements FlutterPlugin, EventChannel.StreamHandler, MethodChannel.MethodCallHandler
{
  private static final String TAG = "ImgStPlugin";
  private Context context;
  EventChannel.EventSink eventSink;
  final Handler mUIHandler = new Handler(Looper.getMainLooper());
  private BinaryMessenger messenger;
  private PluginRegistry.Registrar registrar;
  private LongSparseArray<OpenGlRenderer2> renders = new LongSparseArray();
  private Map<String, Size> resourceInfoMap = new HashMap();
  private TextureRegistry textures;
  private LongSparseArray<RenderWorker> workers = new LongSparseArray();
  
  public AnimateImagePlugin() {}
  
  public AnimateImagePlugin(PluginRegistry.Registrar paramRegistrar) {}
  
  public static void registerRenderFactory(String paramString, IRenderWorkerFactory paramIRenderWorkerFactory)
  {
    RenderWorkerFactory.registerRenderFactory(paramString, paramIRenderWorkerFactory);
  }
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    new AnimateImagePlugin(paramRegistrar);
  }
  
  public static void setLog(ILog paramILog)
  {
    LogUtils.a(paramILog);
  }
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.textures = paramFlutterPluginBinding.getTextureRegistry();
    this.messenger = paramFlutterPluginBinding.getBinaryMessenger();
    this.context = paramFlutterPluginBinding.getApplicationContext();
    LogUtils.b("ImgStPlugin", "onAttachedToEngine()");
    paramFlutterPluginBinding = paramFlutterPluginBinding.getBinaryMessenger();
    new MethodChannel(paramFlutterPluginBinding, "animate_image").setMethodCallHandler(this);
    new EventChannel(paramFlutterPluginBinding, "animate_image_event").setStreamHandler(this);
  }
  
  public void onCancel(Object paramObject) {}
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    LogUtils.b("ImgStPlugin", "onDetachedFromEngine()");
    int j = this.workers.size();
    int i = 0;
    while (i < j)
    {
      long l = this.workers.keyAt(i);
      paramFlutterPluginBinding = (RenderWorker)this.workers.get(l);
      if (paramFlutterPluginBinding != null) {
        paramFlutterPluginBinding.dispose();
      }
      i += 1;
    }
    this.workers.clear();
  }
  
  public void onListen(Object paramObject, EventChannel.EventSink paramEventSink)
  {
    this.eventSink = paramEventSink;
    if (!(paramObject instanceof String)) {
      return;
    }
    paramObject = (String)paramObject;
    int i = -1;
    if ((paramObject.hashCode() == 942712596) && (paramObject.equals("loadResource"))) {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    this.eventSink = paramEventSink;
  }
  
  /* Error */
  @androidx.annotation.RequiresApi(api=26)
  public void onMethodCall(io.flutter.plugin.common.MethodCall paramMethodCall, io.flutter.plugin.common.MethodChannel.Result paramResult)
  {
    // Byte code:
    //   0: ldc 179
    //   2: aload_1
    //   3: getfield 184	io/flutter/plugin/common/MethodCall:method	Ljava/lang/String;
    //   6: invokestatic 186	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_1
    //   10: getfield 184	io/flutter/plugin/common/MethodCall:method	Ljava/lang/String;
    //   13: ldc 188
    //   15: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +37 -> 55
    //   21: new 190	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   28: astore_1
    //   29: aload_1
    //   30: ldc 193
    //   32: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_1
    //   37: getstatic 202	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   40: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_2
    //   45: aload_1
    //   46: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokeinterface 211 2 0
    //   54: return
    //   55: aload_1
    //   56: getfield 184	io/flutter/plugin/common/MethodCall:method	Ljava/lang/String;
    //   59: ldc 213
    //   61: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   64: ifeq +11 -> 75
    //   67: ldc 179
    //   69: ldc 215
    //   71: invokestatic 186	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: return
    //   75: aload_1
    //   76: getfield 184	io/flutter/plugin/common/MethodCall:method	Ljava/lang/String;
    //   79: ldc 217
    //   81: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: istore 9
    //   86: iconst_0
    //   87: istore_3
    //   88: iload 9
    //   90: ifeq +801 -> 891
    //   93: aload_1
    //   94: getfield 221	io/flutter/plugin/common/MethodCall:arguments	Ljava/lang/Object;
    //   97: checkcast 223	java/util/Map
    //   100: astore 18
    //   102: aload_0
    //   103: getfield 91	com/peterlmeng/animate_image/AnimateImagePlugin:textures	Lio/flutter/view/TextureRegistry;
    //   106: invokeinterface 229 1 0
    //   111: astore 15
    //   113: aload 15
    //   115: invokeinterface 235 1 0
    //   120: pop
    //   121: aload 18
    //   123: ldc 237
    //   125: invokeinterface 240 2 0
    //   130: checkcast 242	java/lang/Double
    //   133: invokevirtual 245	java/lang/Double:intValue	()I
    //   136: istore 6
    //   138: aload 18
    //   140: ldc 247
    //   142: invokeinterface 240 2 0
    //   147: checkcast 242	java/lang/Double
    //   150: invokevirtual 245	java/lang/Double:intValue	()I
    //   153: istore 7
    //   155: new 249	com/peterlmeng/animate_image/Size
    //   158: dup
    //   159: iload 6
    //   161: iload 7
    //   163: invokespecial 252	com/peterlmeng/animate_image/Size:<init>	(II)V
    //   166: astore 16
    //   168: aload 18
    //   170: ldc 254
    //   172: invokeinterface 240 2 0
    //   177: checkcast 160	java/lang/String
    //   180: astore 17
    //   182: aload 18
    //   184: ldc_w 256
    //   187: invokeinterface 259 2 0
    //   192: ifeq +23 -> 215
    //   195: aload 18
    //   197: ldc_w 256
    //   200: invokeinterface 240 2 0
    //   205: checkcast 261	java/lang/Integer
    //   208: invokevirtual 262	java/lang/Integer:intValue	()I
    //   211: istore_3
    //   212: goto +5 -> 217
    //   215: iconst_m1
    //   216: istore_3
    //   217: aload 18
    //   219: ldc_w 264
    //   222: invokeinterface 259 2 0
    //   227: ifeq +24 -> 251
    //   230: aload 18
    //   232: ldc_w 264
    //   235: invokeinterface 240 2 0
    //   240: checkcast 261	java/lang/Integer
    //   243: invokevirtual 262	java/lang/Integer:intValue	()I
    //   246: istore 4
    //   248: goto +6 -> 254
    //   251: iconst_0
    //   252: istore 4
    //   254: aload 18
    //   256: ldc_w 266
    //   259: invokeinterface 259 2 0
    //   264: ifeq +24 -> 288
    //   267: aload 18
    //   269: ldc_w 266
    //   272: invokeinterface 240 2 0
    //   277: checkcast 261	java/lang/Integer
    //   280: invokevirtual 262	java/lang/Integer:intValue	()I
    //   283: istore 5
    //   285: goto +6 -> 291
    //   288: iconst_0
    //   289: istore 5
    //   291: aload 18
    //   293: ldc_w 268
    //   296: invokeinterface 259 2 0
    //   301: istore 9
    //   303: ldc_w 270
    //   306: astore_1
    //   307: iload 9
    //   309: ifeq +21 -> 330
    //   312: aload 18
    //   314: ldc_w 268
    //   317: invokeinterface 240 2 0
    //   322: checkcast 160	java/lang/String
    //   325: astore 13
    //   327: goto +8 -> 335
    //   330: ldc_w 270
    //   333: astore 13
    //   335: aload 18
    //   337: ldc_w 272
    //   340: invokeinterface 259 2 0
    //   345: istore 9
    //   347: aconst_null
    //   348: astore 14
    //   350: aconst_null
    //   351: astore 12
    //   353: iload 9
    //   355: ifeq +242 -> 597
    //   358: aload 18
    //   360: ldc_w 272
    //   363: invokeinterface 240 2 0
    //   368: checkcast 223	java/util/Map
    //   371: astore 18
    //   373: aload 18
    //   375: ifnull +222 -> 597
    //   378: aload 18
    //   380: ldc_w 268
    //   383: invokeinterface 240 2 0
    //   388: ifnull +17 -> 405
    //   391: aload 18
    //   393: ldc_w 268
    //   396: invokeinterface 240 2 0
    //   401: checkcast 160	java/lang/String
    //   404: astore_1
    //   405: aload 18
    //   407: ldc_w 274
    //   410: invokeinterface 240 2 0
    //   415: checkcast 261	java/lang/Integer
    //   418: invokevirtual 262	java/lang/Integer:intValue	()I
    //   421: istore 8
    //   423: aload 18
    //   425: ldc_w 276
    //   428: invokeinterface 240 2 0
    //   433: astore 14
    //   435: new 278	com/peterlmeng/animate_image/model/ReplaceImageModel
    //   438: dup
    //   439: iload 8
    //   441: aload 14
    //   443: checkcast 160	java/lang/String
    //   446: aload_1
    //   447: invokespecial 281	com/peterlmeng/animate_image/model/ReplaceImageModel:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   450: astore_1
    //   451: new 190	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   458: astore 12
    //   460: aload 12
    //   462: ldc_w 283
    //   465: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 12
    //   471: aload 18
    //   473: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 12
    //   479: ldc_w 288
    //   482: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload 12
    //   488: aload 18
    //   490: ldc_w 274
    //   493: invokeinterface 240 2 0
    //   498: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload 12
    //   504: ldc_w 290
    //   507: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 12
    //   513: aload 18
    //   515: ldc_w 276
    //   518: invokeinterface 240 2 0
    //   523: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: ldc 14
    //   529: aload 12
    //   531: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: invokestatic 186	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: goto +67 -> 604
    //   540: astore 14
    //   542: aload_1
    //   543: astore 12
    //   545: aload 14
    //   547: astore_1
    //   548: goto +8 -> 556
    //   551: astore_1
    //   552: goto +4 -> 556
    //   555: astore_1
    //   556: new 190	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   563: astore 14
    //   565: aload 14
    //   567: ldc_w 292
    //   570: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 14
    //   576: aload_1
    //   577: invokevirtual 295	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   580: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: ldc 14
    //   586: aload 14
    //   588: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokestatic 109	com/peterlmeng/animate_image/support/log/LogUtils:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: goto +7 -> 601
    //   597: aload 14
    //   599: astore 12
    //   601: aload 12
    //   603: astore_1
    //   604: aload_0
    //   605: getfield 97	com/peterlmeng/animate_image/AnimateImagePlugin:messenger	Lio/flutter/plugin/common/BinaryMessenger;
    //   608: astore 12
    //   610: new 190	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   617: astore 14
    //   619: aload 14
    //   621: ldc_w 297
    //   624: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 14
    //   630: aload 15
    //   632: invokeinterface 301 1 0
    //   637: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: new 122	io/flutter/plugin/common/EventChannel
    //   644: dup
    //   645: aload 12
    //   647: aload 14
    //   649: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: invokespecial 125	io/flutter/plugin/common/EventChannel:<init>	(Lio/flutter/plugin/common/BinaryMessenger;Ljava/lang/String;)V
    //   655: astore 12
    //   657: new 190	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   664: astore 14
    //   666: aload 14
    //   668: ldc_w 306
    //   671: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: aload 14
    //   677: iload 6
    //   679: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload 14
    //   685: ldc_w 311
    //   688: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload 14
    //   694: iload 7
    //   696: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   699: pop
    //   700: aload 14
    //   702: ldc_w 313
    //   705: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: aload 14
    //   711: aload 17
    //   713: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: pop
    //   717: aload 14
    //   719: ldc_w 315
    //   722: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload 14
    //   728: aload 15
    //   730: invokeinterface 301 1 0
    //   735: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload 14
    //   741: ldc_w 317
    //   744: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload 14
    //   750: iload 4
    //   752: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload 14
    //   758: ldc_w 319
    //   761: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: pop
    //   765: aload 14
    //   767: iload_3
    //   768: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   771: pop
    //   772: ldc 14
    //   774: aload 14
    //   776: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 186	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   782: aload 15
    //   784: aload_0
    //   785: getfield 103	com/peterlmeng/animate_image/AnimateImagePlugin:context	Landroid/content/Context;
    //   788: aload 17
    //   790: iload_3
    //   791: iload 4
    //   793: iload 5
    //   795: aload 16
    //   797: aload 12
    //   799: aload 13
    //   801: invokestatic 323	com/peterlmeng/animate_image/renderer/RenderWorkerFactory:createRenderWorker	(Lio/flutter/view/TextureRegistry$SurfaceTextureEntry;Landroid/content/Context;Ljava/lang/String;IIILcom/peterlmeng/animate_image/Size;Lio/flutter/plugin/common/EventChannel;Ljava/lang/String;)Lcom/peterlmeng/animate_image/renderer/RenderWorker;
    //   804: astore 12
    //   806: aload_1
    //   807: ifnull +18 -> 825
    //   810: aload 12
    //   812: aload_1
    //   813: getfield 326	com/peterlmeng/animate_image/model/ReplaceImageModel:index	I
    //   816: aload_1
    //   817: getfield 328	com/peterlmeng/animate_image/model/ReplaceImageModel:path	Ljava/lang/String;
    //   820: invokeinterface 331 3 0
    //   825: aload 12
    //   827: ifnull +782 -> 1609
    //   830: aload 12
    //   832: new 333	com/peterlmeng/animate_image/AnimateImagePlugin$1
    //   835: dup
    //   836: aload_0
    //   837: aload 15
    //   839: aload_2
    //   840: invokespecial 336	com/peterlmeng/animate_image/AnimateImagePlugin$1:<init>	(Lcom/peterlmeng/animate_image/AnimateImagePlugin;Lio/flutter/view/TextureRegistry$SurfaceTextureEntry;Lio/flutter/plugin/common/MethodChannel$Result;)V
    //   843: invokeinterface 340 2 0
    //   848: aload 12
    //   850: instanceof 342
    //   853: ifeq +14 -> 867
    //   856: aload 12
    //   858: checkcast 342	com/peterlmeng/animate_image/renderer/PagRenderWorker
    //   861: invokevirtual 346	com/peterlmeng/animate_image/renderer/PagRenderWorker:isPagSoReady	()Z
    //   864: ifeq +10 -> 874
    //   867: aload 12
    //   869: invokeinterface 349 1 0
    //   874: aload_0
    //   875: getfield 45	com/peterlmeng/animate_image/AnimateImagePlugin:workers	Landroid/util/LongSparseArray;
    //   878: aload 15
    //   880: invokeinterface 301 1 0
    //   885: aload 12
    //   887: invokevirtual 353	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   890: return
    //   891: aload_1
    //   892: getfield 184	io/flutter/plugin/common/MethodCall:method	Ljava/lang/String;
    //   895: ldc_w 355
    //   898: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   901: ifeq +50 -> 951
    //   904: aload_1
    //   905: getfield 221	io/flutter/plugin/common/MethodCall:arguments	Ljava/lang/Object;
    //   908: checkcast 223	java/util/Map
    //   911: ldc_w 357
    //   914: invokeinterface 240 2 0
    //   919: checkcast 359	java/lang/Number
    //   922: invokevirtual 362	java/lang/Number:longValue	()J
    //   925: lstore 10
    //   927: aload_0
    //   928: getfield 45	com/peterlmeng/animate_image/AnimateImagePlugin:workers	Landroid/util/LongSparseArray;
    //   931: lload 10
    //   933: invokevirtual 146	android/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   936: checkcast 148	com/peterlmeng/animate_image/renderer/RenderWorker
    //   939: astore_1
    //   940: aload_1
    //   941: ifnull +668 -> 1609
    //   944: aload_1
    //   945: invokeinterface 364 1 0
    //   950: return
    //   951: aload_1
    //   952: getfield 184	io/flutter/plugin/common/MethodCall:method	Ljava/lang/String;
    //   955: ldc_w 365
    //   958: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   961: ifeq +251 -> 1212
    //   964: aload_1
    //   965: getfield 221	io/flutter/plugin/common/MethodCall:arguments	Ljava/lang/Object;
    //   968: checkcast 223	java/util/Map
    //   971: astore_1
    //   972: aload_1
    //   973: ldc_w 357
    //   976: invokeinterface 240 2 0
    //   981: checkcast 261	java/lang/Integer
    //   984: invokevirtual 262	java/lang/Integer:intValue	()I
    //   987: i2l
    //   988: lstore 10
    //   990: aload_1
    //   991: ldc 254
    //   993: invokeinterface 240 2 0
    //   998: checkcast 160	java/lang/String
    //   1001: astore_1
    //   1002: new 190	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1009: astore_2
    //   1010: aload_2
    //   1011: ldc_w 367
    //   1014: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: pop
    //   1018: aload_2
    //   1019: lload 10
    //   1021: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1024: pop
    //   1025: aload_2
    //   1026: ldc_w 369
    //   1029: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: pop
    //   1033: aload_2
    //   1034: aload_1
    //   1035: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: pop
    //   1039: ldc 14
    //   1041: aload_2
    //   1042: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: invokestatic 186	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1048: lload 10
    //   1050: ldc2_w 370
    //   1053: lcmp
    //   1054: ifne +125 -> 1179
    //   1057: iload_3
    //   1058: aload_0
    //   1059: getfield 45	com/peterlmeng/animate_image/AnimateImagePlugin:workers	Landroid/util/LongSparseArray;
    //   1062: invokevirtual 138	android/util/LongSparseArray:size	()I
    //   1065: if_icmpge +544 -> 1609
    //   1068: aload_0
    //   1069: getfield 45	com/peterlmeng/animate_image/AnimateImagePlugin:workers	Landroid/util/LongSparseArray;
    //   1072: iload_3
    //   1073: invokevirtual 142	android/util/LongSparseArray:keyAt	(I)J
    //   1076: lstore 10
    //   1078: aload_0
    //   1079: getfield 45	com/peterlmeng/animate_image/AnimateImagePlugin:workers	Landroid/util/LongSparseArray;
    //   1082: lload 10
    //   1084: invokevirtual 146	android/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   1087: checkcast 148	com/peterlmeng/animate_image/renderer/RenderWorker
    //   1090: astore_2
    //   1091: aload_2
    //   1092: invokeinterface 374 1 0
    //   1097: aload_1
    //   1098: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1101: ifeq +71 -> 1172
    //   1104: aload_2
    //   1105: invokeinterface 377 1 0
    //   1110: ifne +62 -> 1172
    //   1113: new 190	java/lang/StringBuilder
    //   1116: dup
    //   1117: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1120: astore 12
    //   1122: aload 12
    //   1124: ldc_w 379
    //   1127: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: pop
    //   1131: aload 12
    //   1133: aload_1
    //   1134: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: aload 12
    //   1140: ldc_w 381
    //   1143: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: pop
    //   1147: ldc 14
    //   1149: aload 12
    //   1151: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1154: invokestatic 186	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1157: aload_2
    //   1158: invokeinterface 151 1 0
    //   1163: aload_0
    //   1164: getfield 45	com/peterlmeng/animate_image/AnimateImagePlugin:workers	Landroid/util/LongSparseArray;
    //   1167: lload 10
    //   1169: invokevirtual 385	android/util/LongSparseArray:delete	(J)V
    //   1172: iload_3
    //   1173: iconst_1
    //   1174: iadd
    //   1175: istore_3
    //   1176: goto -119 -> 1057
    //   1179: aload_0
    //   1180: getfield 45	com/peterlmeng/animate_image/AnimateImagePlugin:workers	Landroid/util/LongSparseArray;
    //   1183: lload 10
    //   1185: invokevirtual 146	android/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   1188: checkcast 148	com/peterlmeng/animate_image/renderer/RenderWorker
    //   1191: astore_1
    //   1192: aload_1
    //   1193: ifnull +416 -> 1609
    //   1196: aload_1
    //   1197: invokeinterface 151 1 0
    //   1202: aload_0
    //   1203: getfield 45	com/peterlmeng/animate_image/AnimateImagePlugin:workers	Landroid/util/LongSparseArray;
    //   1206: lload 10
    //   1208: invokevirtual 385	android/util/LongSparseArray:delete	(J)V
    //   1211: return
    //   1212: aload_1
    //   1213: getfield 184	io/flutter/plugin/common/MethodCall:method	Ljava/lang/String;
    //   1216: ldc_w 387
    //   1219: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1222: ifeq +82 -> 1304
    //   1225: aload_1
    //   1226: getfield 221	io/flutter/plugin/common/MethodCall:arguments	Ljava/lang/Object;
    //   1229: checkcast 223	java/util/Map
    //   1232: ldc_w 357
    //   1235: invokeinterface 240 2 0
    //   1240: checkcast 359	java/lang/Number
    //   1243: invokevirtual 362	java/lang/Number:longValue	()J
    //   1246: lstore 10
    //   1248: aload_0
    //   1249: getfield 45	com/peterlmeng/animate_image/AnimateImagePlugin:workers	Landroid/util/LongSparseArray;
    //   1252: lload 10
    //   1254: invokevirtual 146	android/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   1257: checkcast 148	com/peterlmeng/animate_image/renderer/RenderWorker
    //   1260: astore_1
    //   1261: new 190	java/lang/StringBuilder
    //   1264: dup
    //   1265: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1268: astore_2
    //   1269: aload_2
    //   1270: ldc_w 389
    //   1273: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: pop
    //   1277: aload_2
    //   1278: lload 10
    //   1280: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1283: pop
    //   1284: ldc 14
    //   1286: aload_2
    //   1287: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1290: invokestatic 186	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1293: aload_1
    //   1294: ifnull +315 -> 1609
    //   1297: aload_1
    //   1298: invokeinterface 392 1 0
    //   1303: return
    //   1304: aload_1
    //   1305: getfield 184	io/flutter/plugin/common/MethodCall:method	Ljava/lang/String;
    //   1308: ldc_w 394
    //   1311: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1314: ifeq +89 -> 1403
    //   1317: aload_1
    //   1318: getfield 221	io/flutter/plugin/common/MethodCall:arguments	Ljava/lang/Object;
    //   1321: checkcast 223	java/util/Map
    //   1324: ldc_w 357
    //   1327: invokeinterface 240 2 0
    //   1332: checkcast 359	java/lang/Number
    //   1335: invokevirtual 362	java/lang/Number:longValue	()J
    //   1338: lstore 10
    //   1340: new 190	java/lang/StringBuilder
    //   1343: dup
    //   1344: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1347: astore_1
    //   1348: aload_1
    //   1349: ldc_w 396
    //   1352: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: pop
    //   1356: aload_1
    //   1357: lload 10
    //   1359: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1362: pop
    //   1363: ldc 14
    //   1365: aload_1
    //   1366: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1369: invokestatic 186	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1372: aload_0
    //   1373: getfield 45	com/peterlmeng/animate_image/AnimateImagePlugin:workers	Landroid/util/LongSparseArray;
    //   1376: lload 10
    //   1378: invokevirtual 146	android/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   1381: checkcast 148	com/peterlmeng/animate_image/renderer/RenderWorker
    //   1384: astore_1
    //   1385: aload_1
    //   1386: ifnull +10 -> 1396
    //   1389: aload_1
    //   1390: invokeinterface 398 1 0
    //   1395: return
    //   1396: aload_2
    //   1397: invokeinterface 401 1 0
    //   1402: return
    //   1403: aload_1
    //   1404: getfield 184	io/flutter/plugin/common/MethodCall:method	Ljava/lang/String;
    //   1407: ldc_w 403
    //   1410: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1413: ifeq +82 -> 1495
    //   1416: aload_1
    //   1417: getfield 221	io/flutter/plugin/common/MethodCall:arguments	Ljava/lang/Object;
    //   1420: checkcast 223	java/util/Map
    //   1423: ldc_w 357
    //   1426: invokeinterface 240 2 0
    //   1431: checkcast 359	java/lang/Number
    //   1434: invokevirtual 362	java/lang/Number:longValue	()J
    //   1437: lstore 10
    //   1439: new 190	java/lang/StringBuilder
    //   1442: dup
    //   1443: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1446: astore_1
    //   1447: aload_1
    //   1448: ldc_w 405
    //   1451: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: pop
    //   1455: aload_1
    //   1456: lload 10
    //   1458: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1461: pop
    //   1462: ldc 14
    //   1464: aload_1
    //   1465: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1468: invokestatic 186	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1471: aload_0
    //   1472: getfield 45	com/peterlmeng/animate_image/AnimateImagePlugin:workers	Landroid/util/LongSparseArray;
    //   1475: lload 10
    //   1477: invokevirtual 146	android/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   1480: checkcast 148	com/peterlmeng/animate_image/renderer/RenderWorker
    //   1483: astore_1
    //   1484: aload_1
    //   1485: ifnull -89 -> 1396
    //   1488: aload_1
    //   1489: invokeinterface 407 1 0
    //   1494: return
    //   1495: aload_1
    //   1496: getfield 184	io/flutter/plugin/common/MethodCall:method	Ljava/lang/String;
    //   1499: ldc_w 409
    //   1502: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1505: ifeq +104 -> 1609
    //   1508: aload_1
    //   1509: getfield 221	io/flutter/plugin/common/MethodCall:arguments	Ljava/lang/Object;
    //   1512: checkcast 223	java/util/Map
    //   1515: astore_1
    //   1516: aload_1
    //   1517: ldc_w 357
    //   1520: invokeinterface 240 2 0
    //   1525: checkcast 261	java/lang/Integer
    //   1528: invokevirtual 262	java/lang/Integer:intValue	()I
    //   1531: i2l
    //   1532: lstore 10
    //   1534: aload_1
    //   1535: ldc 254
    //   1537: invokeinterface 240 2 0
    //   1542: checkcast 160	java/lang/String
    //   1545: astore_1
    //   1546: new 190	java/lang/StringBuilder
    //   1549: dup
    //   1550: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1553: astore 12
    //   1555: aload 12
    //   1557: ldc_w 411
    //   1560: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: pop
    //   1564: aload 12
    //   1566: lload 10
    //   1568: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1571: pop
    //   1572: ldc 14
    //   1574: aload 12
    //   1576: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1579: invokestatic 186	com/peterlmeng/animate_image/support/log/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1582: aload_0
    //   1583: getfield 45	com/peterlmeng/animate_image/AnimateImagePlugin:workers	Landroid/util/LongSparseArray;
    //   1586: lload 10
    //   1588: invokevirtual 146	android/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   1591: checkcast 148	com/peterlmeng/animate_image/renderer/RenderWorker
    //   1594: astore 12
    //   1596: aload 12
    //   1598: ifnull -202 -> 1396
    //   1601: aload 12
    //   1603: aload_1
    //   1604: invokeinterface 414 2 0
    //   1609: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1610	0	this	AnimateImagePlugin
    //   0	1610	1	paramMethodCall	io.flutter.plugin.common.MethodCall
    //   0	1610	2	paramResult	io.flutter.plugin.common.MethodChannel.Result
    //   87	1089	3	i	int
    //   246	546	4	j	int
    //   283	511	5	k	int
    //   136	542	6	m	int
    //   153	542	7	n	int
    //   421	19	8	i1	int
    //   84	270	9	bool	boolean
    //   925	662	10	l	long
    //   351	1251	12	localObject1	Object
    //   325	475	13	str1	String
    //   348	94	14	localObject2	Object
    //   540	6	14	localException	java.lang.Exception
    //   563	212	14	localStringBuilder	java.lang.StringBuilder
    //   111	768	15	localSurfaceTextureEntry	io.flutter.view.TextureRegistry.SurfaceTextureEntry
    //   166	630	16	localSize	Size
    //   180	609	17	str2	String
    //   100	414	18	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   451	537	540	java/lang/Exception
    //   435	451	551	java/lang/Exception
    //   378	405	555	java/lang/Exception
    //   405	435	555	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.AnimateImagePlugin
 * JD-Core Version:    0.7.0.1
 */