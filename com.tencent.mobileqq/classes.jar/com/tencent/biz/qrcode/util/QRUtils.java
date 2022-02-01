package com.tencent.biz.qrcode.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.config.bean.ArkPlatformConfigBean;
import com.tencent.mobileqq.ark.config.config.ArkPlatformConfig;
import com.tencent.mobileqq.config.business.QrCodeConfBean;
import com.tencent.mobileqq.config.business.QrCodeConfBean.QrCodeList;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.QRActionEntity;
import com.tencent.mobileqq.qrscan.QRCodeEncodeCallback;
import com.tencent.mobileqq.qrscan.api.IQRDataApi;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BaseQRUtil;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.tools.util;

public class QRUtils
  extends BaseQRUtil
{
  protected static String a = "^https?://qm\\.qq\\.com/cgi-bin/qm/qr\\?.+";
  protected static String b = ".*(\\+86|086)?\\d{5,12}.*";
  protected static String c = "58.250.135.158";
  protected static String d = "120.198.189.104";
  protected static String e = "182.254.1.144";
  private static String h = "^https?://qm\\.qq\\.com/cgi-bin/dc/ft\\?.+";
  private static String i = "^https?://url\\.cn/.+#flyticket";
  
  protected static int a(int paramInt)
  {
    if (paramInt < 21) {
      return 1;
    }
    if (paramInt > 177) {
      return 39;
    }
    return (paramInt - 21) / 4 + 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int j = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("my_qr_code_cfg_sp_index", -1);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getMyQrBgIndexFromSp().settingValue:");
      paramQQAppInterface.append(j);
      QLog.i("QRUtils", 2, paramQQAppInterface.toString());
    }
    return j;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return 1;
    }
    if (!QVipQidProcessor.e().b) {
      return 1;
    }
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("sp_vip_qid_info", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("user_qr_card_type");
    localStringBuilder.append(paramString);
    return paramQQAppInterface.getInt(localStringBuilder.toString(), 1);
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    int j = Math.min(750, ScreenUtil.getRealWidth(paramContext));
    int k = Math.min(1344, ScreenUtil.getRealHeight(paramContext));
    try
    {
      paramContext = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
      if (paramContext == null)
      {
        QLog.d("QRUtils", 1, "QID_QR,getQidQrCard() myCode == null || myShare == null");
        return paramContext;
      }
      Canvas localCanvas = new Canvas(paramContext);
      a(paramBitmap1, j, k, localCanvas);
      a(paramBitmap2, j, localCanvas);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.w("QRUtils", 1, paramContext.getMessage());
    }
    return null;
  }
  
  public static final Bitmap a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, String paramString1, Bitmap paramBitmap3, Bitmap paramBitmap4, int paramInt2, int paramInt3, String paramString2, Rect paramRect, ArrayList<Rect> paramArrayList, int paramInt4)
  {
    Object localObject1 = paramString1;
    Bitmap localBitmap1 = paramBitmap4;
    try
    {
      localBitmap2 = Bitmap.createBitmap(540, 740, Bitmap.Config.ARGB_8888);
      if (paramInt4 != 0) {
        localObject2 = BitmapFactory.decodeResource(paramContext.getResources(), paramInt4);
      } else {
        localObject2 = null;
      }
      if (localBitmap2 == null) {
        return null;
      }
      localCanvas = new Canvas(localBitmap2);
      Paint localPaint;
      if (paramBitmap1 != null)
      {
        localPaint = new Paint();
        Rect localRect = new Rect(0, 0, 540, 740);
        localPaint.setAntiAlias(true);
        localCanvas.drawBitmap(paramBitmap1, null, localRect, localPaint);
      }
      else
      {
        localPaint = new Paint();
        localPaint.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, 600.0F, -657931, -1513240, Shader.TileMode.REPEAT));
        paramBitmap1 = localCanvas;
        localCanvas.drawRect(0.0F, 0.0F, 540.0F, 600.0F, localPaint);
        localPaint.setShader(null);
        localPaint.setColor(-2565928);
        paramBitmap1.drawLine(0.0F, 600.0F, 540.0F, 600.0F, localPaint);
        localPaint.setColor(-986896);
        paramBitmap1.drawRect(0.0F, 601.0F, 540.0F, 740.0F, localPaint);
      }
      if (paramBitmap2 != null)
      {
        paramBitmap1 = new Paint();
        paramBitmap1.setAntiAlias(true);
        localCanvas.drawBitmap(paramBitmap2, null, new Rect(20, 621, 120, 721), paramBitmap1);
      }
      int j = 140;
      if (localObject2 != null)
      {
        paramBitmap1 = new Paint();
        paramBitmap1.setAntiAlias(true);
        paramBitmap1.setFilterBitmap(true);
        localCanvas.drawBitmap((Bitmap)localObject2, null, new Rect(140, 633, 176, 669), paramBitmap1);
        paramInt4 = 1;
      }
      else
      {
        paramInt4 = 0;
      }
      Object localObject2 = new Paint();
      ((Paint)localObject2).setTextAlign(Paint.Align.LEFT);
      ((Paint)localObject2).setAntiAlias(true);
      ((Paint)localObject2).setColor(paramInt1);
      ((Paint)localObject2).setTextSize(32.0F);
      ((Paint)localObject2).setFlags(1);
      ((Paint)localObject2).setTypeface(Typeface.SANS_SERIF);
      if (paramInt4 != 0) {
        paramInt1 = 342;
      } else {
        paramInt1 = 380;
      }
      if (localObject1 != null)
      {
        int k = Math.max(2, paramString1.length());
        float f1 = ((Paint)localObject2).measureText((String)localObject1);
        float f2 = paramInt1;
        paramString1 = (String)localObject1;
        if (f1 > f2)
        {
          paramInt1 = k;
          do
          {
            paramInt1 -= 2;
            paramBitmap1 = new StringBuilder();
            paramBitmap1.append(((String)localObject1).substring(0, paramInt1));
            paramBitmap1.append("…");
            paramBitmap1 = paramBitmap1.toString();
            paramString1 = paramBitmap1;
            if (paramInt1 <= 0) {
              break;
            }
            localObject1 = paramBitmap1;
          } while (((Paint)localObject2).measureText(paramBitmap1) > f2);
          paramString1 = paramBitmap1;
        }
        paramInt1 = j;
        if (paramInt4 != 0) {
          paramInt1 = 182;
        }
        localCanvas.drawText(paramString1, paramInt1, 665.0F, (Paint)localObject2);
      }
      if (paramBitmap3 != null) {
        localCanvas.drawBitmap(paramBitmap3, null, new Rect(0, 0, 540, 600), null);
      }
      if (paramRect != null) {
        paramBitmap1 = paramRect;
      } else {
        paramBitmap1 = new Rect(70, 100, 470, 500);
      }
      paramString1 = localBitmap1;
      if (a())
      {
        paramString1 = localBitmap1;
        if (paramBitmap1.width() > 350)
        {
          paramString1 = localBitmap1;
          if (paramBitmap1.height() > 350)
          {
            paramString1 = localBitmap1;
            if (localBitmap1 != null) {
              try
              {
                paramBitmap3 = Bitmap.createScaledBitmap(localBitmap1, paramBitmap1.width() / 2, paramBitmap1.height() / 2, false);
                paramString1 = localBitmap1;
                if (paramBitmap3 != null)
                {
                  if (QLog.isColorLevel())
                  {
                    paramString1 = new StringBuilder();
                    paramString1.append("createScaledBitmap tmp success: w=");
                    paramString1.append(paramBitmap3.getWidth());
                    paramString1.append(",h=");
                    paramString1.append(paramBitmap3.getHeight());
                    paramString1.append("org w=");
                    paramString1.append(paramBitmap4.getWidth());
                    paramString1.append(",org h=");
                    paramString1.append(paramBitmap4.getHeight());
                    QLog.w("QRUtils", 2, paramString1.toString());
                  }
                  paramString1 = paramBitmap3;
                }
              }
              catch (Throwable paramString1)
              {
                paramBitmap3 = new StringBuilder();
                paramBitmap3.append("getQRCard error : ");
                paramBitmap3.append(paramString1.getMessage());
                QLog.i("QRUtils", 2, paramBitmap3.toString());
                paramString1 = localBitmap1;
              }
            }
          }
        }
      }
      if (paramArrayList != null)
      {
        if ((QLog.isColorLevel()) && (paramString1 != null))
        {
          paramBitmap3 = new StringBuilder();
          paramBitmap3.append("size: w=");
          paramBitmap3.append(paramString1.getWidth());
          paramBitmap3.append(",h=");
          paramBitmap3.append(paramString1.getHeight());
          QLog.w("QRUtils", 2, paramBitmap3.toString());
        }
        try
        {
          paramInt4 = paramBitmap1.width();
          j = paramBitmap1.height();
          paramInt1 = 0;
          paramString1 = Bitmap.createScaledBitmap(paramString1, paramInt4, j, false);
          paramBitmap3 = new Canvas(paramString1);
          paramBitmap4 = new Paint();
          paramBitmap4.setAlpha(0);
          paramBitmap4.setAntiAlias(true);
          paramBitmap4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
          while (paramInt1 < paramArrayList.size())
          {
            paramBitmap3.drawRect(new Rect((Rect)paramArrayList.get(paramInt1)), paramBitmap4);
            paramInt1 += 1;
          }
          localCanvas.drawBitmap(paramString1, null, paramBitmap1, null);
          paramString1.recycle();
        }
        catch (OutOfMemoryError paramContext)
        {
          paramContext.printStackTrace();
          return null;
        }
      }
      else if (paramString1 != null)
      {
        localCanvas.drawBitmap(paramString1, null, paramBitmap1, null);
      }
      if (paramInt2 != 1) {}
    }
    catch (OutOfMemoryError paramContext)
    {
      Bitmap localBitmap2;
      Canvas localCanvas;
      label1288:
      label1294:
      if (QLog.isColorLevel()) {
        QLog.w("QRUtils", 2, paramContext.getMessage());
      }
      return null;
    }
    try
    {
      paramBitmap1 = new Paint();
      paramBitmap1.setAntiAlias(true);
      paramBitmap2 = new Rect(217, 247, 323, 353);
      paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130840141);
      localCanvas.drawBitmap(paramContext, null, paramBitmap2, paramBitmap1);
      paramContext.recycle();
    }
    catch (OutOfMemoryError paramContext)
    {
      break label1288;
    }
    if ((paramInt2 == 2) && (paramBitmap2 != null))
    {
      paramContext = new Paint();
      paramContext.setAntiAlias(true);
      localCanvas.drawBitmap(paramBitmap2, null, new Rect(217, 247, 323, 353), paramContext);
    }
    else if (paramInt2 == 3)
    {
      paramBitmap1 = new Paint();
      paramBitmap1.setAntiAlias(true);
      paramBitmap2 = new Rect(217, 247, 323, 353);
      paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130840141);
      localCanvas.drawBitmap(paramContext, null, paramBitmap2, paramBitmap1);
      paramContext.recycle();
    }
    else if (paramInt2 == 4)
    {
      paramBitmap1 = new Paint();
      paramBitmap1.setAntiAlias(true);
      paramBitmap2 = new Rect(217, 247, 323, 353);
      paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130840141);
      localCanvas.drawBitmap(paramContext, null, paramBitmap2, paramBitmap1);
      paramContext.recycle();
      break label1294;
      paramContext.printStackTrace();
      return null;
    }
    paramContext = new Paint();
    paramContext.setTextAlign(Paint.Align.LEFT);
    paramContext.setAntiAlias(true);
    paramContext.setColor(paramInt3);
    paramContext.setTextSize(24.0F);
    paramContext.setTypeface(Typeface.SANS_SERIF);
    localCanvas.drawText(paramString2, 140.0F, 706.0F, paramContext);
    return localBitmap2;
  }
  
  public static Bitmap a(View paramView)
  {
    Bitmap localBitmap2 = null;
    if (paramView == null) {
      return null;
    }
    paramView.clearFocus();
    paramView.setPressed(false);
    Bitmap localBitmap1 = localBitmap2;
    try
    {
      paramView.layout(0, 0, paramView.getWidth(), paramView.getHeight());
      localBitmap1 = localBitmap2;
      paramView.setDrawingCacheEnabled(true);
      localBitmap1 = localBitmap2;
      paramView.buildDrawingCache();
      localBitmap1 = localBitmap2;
      localBitmap2 = Bitmap.createBitmap(paramView.getDrawingCache());
      localBitmap1 = localBitmap2;
      paramView.destroyDrawingCache();
      return localBitmap2;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    return localBitmap1;
  }
  
  public static BitMatrix a(String paramString, int paramInt)
  {
    Object localObject1 = new EnumMap(EncodeHintType.class);
    ((Map)localObject1).put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    Object localObject2 = a(paramString);
    if (localObject2 != null) {
      ((Map)localObject1).put(EncodeHintType.CHARACTER_SET, localObject2);
    }
    if (paramInt != -1) {
      ((Map)localObject1).put(EncodeHintType.QRCODE_VERSION, Integer.valueOf(a(paramInt)));
    }
    ((Map)localObject1).put(EncodeHintType.MARGIN, Integer.valueOf(0));
    localObject2 = new QRCodeWriter();
    try
    {
      paramString = ((QRCodeWriter)localObject2).a(paramString, 0, 0, (Map)localObject1);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("encode error:");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      QLog.e("QRUtils", 1, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  public static QrCodeConfBean.QrCodeList a(QQAppInterface paramQQAppInterface, QrCodeConfBean paramQrCodeConfBean, int paramInt)
  {
    if ((paramQrCodeConfBean != null) && (paramQrCodeConfBean.a != null) && (paramQrCodeConfBean.a.size() > 0))
    {
      int j = 0;
      double d1 = Math.random();
      double d2 = paramQrCodeConfBean.a.size();
      Double.isNaN(d2);
      int k;
      for (;;)
      {
        k = (int)(d1 * d2);
        if ((paramInt == -1) || (k != paramInt) || (j >= 50)) {
          break;
        }
        j += 1;
        d1 = Math.random();
        d2 = paramQrCodeConfBean.a.size();
        Double.isNaN(d2);
      }
      return (QrCodeConfBean.QrCodeList)paramQrCodeConfBean.a.get(k);
    }
    return null;
  }
  
  /* Error */
  @android.annotation.TargetApi(8)
  public static String a(Context paramContext, String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 473	java/io/File
    //   9: dup
    //   10: ldc_w 475
    //   13: invokestatic 481	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokespecial 484	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 487	java/io/File:mkdirs	()Z
    //   24: pop
    //   25: aload_0
    //   26: ifnull +280 -> 306
    //   29: aload_0
    //   30: invokevirtual 490	java/io/File:canWrite	()Z
    //   33: ifeq +273 -> 306
    //   36: new 473	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: invokevirtual 493	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   44: aload_1
    //   45: invokespecial 496	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 493	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: astore 5
    //   55: aload_0
    //   56: invokevirtual 499	java/io/File:exists	()Z
    //   59: ifeq +8 -> 67
    //   62: aload_0
    //   63: invokevirtual 502	java/io/File:delete	()Z
    //   66: pop
    //   67: new 504	java/io/FileOutputStream
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 507	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   75: astore_1
    //   76: new 509	java/io/BufferedOutputStream
    //   79: dup
    //   80: aload_1
    //   81: invokespecial 512	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   84: astore 4
    //   86: aload_1
    //   87: astore_0
    //   88: aload 4
    //   90: astore_3
    //   91: aload_2
    //   92: getstatic 518	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   95: bipush 100
    //   97: aload 4
    //   99: invokevirtual 522	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   102: pop
    //   103: aload_1
    //   104: astore_0
    //   105: aload 4
    //   107: astore_3
    //   108: aload 4
    //   110: invokevirtual 525	java/io/BufferedOutputStream:flush	()V
    //   113: aload 4
    //   115: invokevirtual 528	java/io/BufferedOutputStream:close	()V
    //   118: aload_1
    //   119: invokevirtual 529	java/io/FileOutputStream:close	()V
    //   122: aload 5
    //   124: areturn
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 530	java/io/IOException:printStackTrace	()V
    //   130: aload 5
    //   132: areturn
    //   133: astore_0
    //   134: aload_1
    //   135: astore_2
    //   136: aload 4
    //   138: astore_1
    //   139: aload_0
    //   140: astore 4
    //   142: goto +61 -> 203
    //   145: astore_0
    //   146: aload_1
    //   147: astore_2
    //   148: aload 4
    //   150: astore_1
    //   151: aload_0
    //   152: astore 4
    //   154: goto +85 -> 239
    //   157: astore_0
    //   158: goto +28 -> 186
    //   161: astore 4
    //   163: aconst_null
    //   164: astore_0
    //   165: aload_1
    //   166: astore_2
    //   167: aload_0
    //   168: astore_1
    //   169: goto +34 -> 203
    //   172: astore 4
    //   174: aconst_null
    //   175: astore_0
    //   176: aload_1
    //   177: astore_2
    //   178: aload_0
    //   179: astore_1
    //   180: goto +59 -> 239
    //   183: astore_0
    //   184: aconst_null
    //   185: astore_1
    //   186: aconst_null
    //   187: astore_3
    //   188: aload_0
    //   189: astore_2
    //   190: aload_1
    //   191: astore_0
    //   192: aload_2
    //   193: astore_1
    //   194: goto +83 -> 277
    //   197: astore 4
    //   199: aconst_null
    //   200: astore_2
    //   201: aload_2
    //   202: astore_1
    //   203: aload_2
    //   204: astore_0
    //   205: aload_1
    //   206: astore_3
    //   207: aload 4
    //   209: invokevirtual 530	java/io/IOException:printStackTrace	()V
    //   212: aload_1
    //   213: ifnull +10 -> 223
    //   216: aload_1
    //   217: invokevirtual 528	java/io/BufferedOutputStream:close	()V
    //   220: goto +3 -> 223
    //   223: aload_2
    //   224: ifnull +82 -> 306
    //   227: aload_2
    //   228: invokevirtual 529	java/io/FileOutputStream:close	()V
    //   231: aconst_null
    //   232: areturn
    //   233: astore 4
    //   235: aconst_null
    //   236: astore_2
    //   237: aload_2
    //   238: astore_1
    //   239: aload_2
    //   240: astore_0
    //   241: aload_1
    //   242: astore_3
    //   243: aload 4
    //   245: invokevirtual 531	java/io/FileNotFoundException:printStackTrace	()V
    //   248: aload_1
    //   249: ifnull +10 -> 259
    //   252: aload_1
    //   253: invokevirtual 528	java/io/BufferedOutputStream:close	()V
    //   256: goto +3 -> 259
    //   259: aload_2
    //   260: ifnull +46 -> 306
    //   263: aload_2
    //   264: invokevirtual 529	java/io/FileOutputStream:close	()V
    //   267: aconst_null
    //   268: areturn
    //   269: astore_0
    //   270: aload_0
    //   271: invokevirtual 530	java/io/IOException:printStackTrace	()V
    //   274: aconst_null
    //   275: areturn
    //   276: astore_1
    //   277: aload_3
    //   278: ifnull +10 -> 288
    //   281: aload_3
    //   282: invokevirtual 528	java/io/BufferedOutputStream:close	()V
    //   285: goto +3 -> 288
    //   288: aload_0
    //   289: ifnull +15 -> 304
    //   292: aload_0
    //   293: invokevirtual 529	java/io/FileOutputStream:close	()V
    //   296: goto +8 -> 304
    //   299: astore_0
    //   300: aload_0
    //   301: invokevirtual 530	java/io/IOException:printStackTrace	()V
    //   304: aload_1
    //   305: athrow
    //   306: aconst_null
    //   307: areturn
    //   308: astore_0
    //   309: goto -191 -> 118
    //   312: astore_0
    //   313: goto -90 -> 223
    //   316: astore_0
    //   317: goto -58 -> 259
    //   320: astore_2
    //   321: goto -33 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramContext	Context
    //   0	324	1	paramString	String
    //   0	324	2	paramBitmap	Bitmap
    //   90	192	3	localObject1	Object
    //   84	69	4	localObject2	Object
    //   161	1	4	localIOException1	java.io.IOException
    //   172	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   197	11	4	localIOException2	java.io.IOException
    //   233	11	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   53	78	5	str	String
    // Exception table:
    //   from	to	target	type
    //   118	122	125	java/io/IOException
    //   91	103	133	java/io/IOException
    //   108	113	133	java/io/IOException
    //   91	103	145	java/io/FileNotFoundException
    //   108	113	145	java/io/FileNotFoundException
    //   76	86	157	finally
    //   76	86	161	java/io/IOException
    //   76	86	172	java/io/FileNotFoundException
    //   67	76	183	finally
    //   67	76	197	java/io/IOException
    //   67	76	233	java/io/FileNotFoundException
    //   227	231	269	java/io/IOException
    //   263	267	269	java/io/IOException
    //   91	103	276	finally
    //   108	113	276	finally
    //   207	212	276	finally
    //   243	248	276	finally
    //   292	296	299	java/io/IOException
    //   113	118	308	java/io/IOException
    //   216	220	312	java/io/IOException
    //   252	256	316	java/io/IOException
    //   281	285	320	java/io/IOException
  }
  
  protected static String a(CharSequence paramCharSequence)
  {
    int j = 0;
    while (j < paramCharSequence.length())
    {
      if (paramCharSequence.charAt(j) > 'ÿ') {
        return "UTF-8";
      }
      j += 1;
    }
    return null;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    QQToast.makeText(localBaseApplication, paramInt1, paramInt2, 1).show(localBaseApplication.getResources().getDimensionPixelSize(2131299920));
  }
  
  private static void a(int paramInt1, Canvas paramCanvas, int paramInt2)
  {
    Paint localPaint = new Paint();
    paramInt1 = paramInt1 / 2 - 70;
    float f = paramInt1;
    paramInt2 -= 66;
    RectF localRectF = new RectF(f, paramInt2, paramInt1 + 140, paramInt2 + 140);
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(16.0F);
    localPaint.setColor(Color.parseColor("#E6FFFFFF"));
    paramCanvas.drawArc(localRectF, 182.0F, 176.0F, false, localPaint);
  }
  
  private static void a(int paramInt1, String paramString, int paramInt2, Canvas paramCanvas, int paramInt3, int paramInt4)
  {
    Paint localPaint = new Paint();
    localPaint.setTextAlign(Paint.Align.LEFT);
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt1);
    localPaint.setTextSize(28.0F);
    localPaint.setTypeface(Typeface.SANS_SERIF);
    if (paramString != null)
    {
      int j = (int)localPaint.measureText(paramString);
      paramInt1 = paramInt2 / 2;
      paramInt2 = j / 2;
      paramInt3 = paramInt3 + 228 + 440;
      paramInt4 = (paramInt4 - paramInt3) / 2;
      paramCanvas.drawText(paramString, paramInt1 - paramInt2, paramInt3 + (paramInt4 + 14), localPaint);
    }
  }
  
  private static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, Canvas paramCanvas, int paramInt3)
  {
    Paint localPaint = new Paint();
    localPaint.setTextAlign(Paint.Align.LEFT);
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt1);
    localPaint.setTextSize(48.0F);
    localPaint.setFlags(1);
    localPaint.setTypeface(Typeface.SANS_SERIF);
    if (paramString2 != null)
    {
      paramInt1 = Math.max(2, paramString1.length());
      float f1 = localPaint.measureText(paramString1);
      float f2 = 500;
      String str = paramString1;
      if (f1 > f2)
      {
        do
        {
          paramInt1 -= 2;
          paramString2 = new StringBuilder();
          paramString2.append(paramString1.substring(0, paramInt1));
          paramString2.append("…");
          paramString2 = paramString2.toString();
          str = paramString2;
          if (paramInt1 <= 0) {
            break;
          }
          paramString1 = paramString2;
        } while (localPaint.measureText(paramString2) > f2);
        str = paramString2;
      }
      paramInt1 = (int)localPaint.measureText(str);
      paramCanvas.drawText(str, paramInt2 / 2 - paramInt1 / 2, paramInt3 - 66 + 140 + 72, localPaint);
    }
  }
  
  private static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, Canvas paramCanvas, int paramInt3)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    int j = paramInt1 / 2 - 68;
    paramInt2 = paramInt3 + 74;
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    Rect localRect = new Rect(j, paramInt1, j + 136, paramInt1 + 67);
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localPaint.setColorFilter(new PorterDuffColorFilter(Color.parseColor(paramString), PorterDuff.Mode.SRC_ATOP));
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label89:
      StringBuilder localStringBuilder;
      break label89;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("logoColor is illegal please check manage info logoColor = ");
    localStringBuilder.append(paramString);
    QLog.d("QRUtils", 1, localStringBuilder.toString());
    paramCanvas.drawBitmap(BitmapFactory.decodeResource(paramContext.getResources(), 2130848761), null, localRect, localPaint);
  }
  
  private static void a(Bitmap paramBitmap, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
      localPaint.setAntiAlias(true);
      paramCanvas.drawBitmap(paramBitmap, null, localRect, localPaint);
    }
  }
  
  private static void a(Bitmap paramBitmap, int paramInt, Canvas paramCanvas)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      paramCanvas.drawBitmap(paramBitmap, null, new Rect(0, 0, paramInt, paramInt * 550 / 375), localPaint);
    }
  }
  
  private static void a(Bitmap paramBitmap, int paramInt1, Canvas paramCanvas, int paramInt2)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      paramInt1 = (paramInt1 - 440) / 2;
      paramInt2 += 228;
      Rect localRect = new Rect(paramInt1, paramInt2, paramInt1 + 440, paramInt2 + 440);
      localPaint.setAntiAlias(true);
      paramCanvas.drawBitmap(paramBitmap, null, localRect, localPaint);
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, Canvas paramCanvas, int paramInt3)
  {
    Paint localPaint = new Paint();
    localPaint.setTextAlign(Paint.Align.LEFT);
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt1);
    localPaint.setTextSize(28.0F);
    localPaint.setFlags(1);
    localPaint.setTypeface(Typeface.SANS_SERIF);
    if (paramString != null)
    {
      paramInt1 = (int)localPaint.measureText(paramString);
      paramCanvas.drawText(paramString, paramInt2 / 2 - paramInt1 / 2, paramInt3 - 66 + 140 + 72 + 42, localPaint);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, QRCodeEncodeCallback paramQRCodeEncodeCallback)
  {
    paramContext = QRActionEntity.a(paramInt1, paramString1);
    if (paramContext == null)
    {
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("entity is null in getCardQRCode, type=");
        paramAppRuntime.append(paramInt1);
        QLog.w("QRUtils", 2, paramAppRuntime.toString());
      }
      return;
    }
    paramContext = paramContext.a();
    paramString1 = new QRUtils.1(paramQRCodeEncodeCallback);
    paramString2 = new Bundle();
    paramString2.putString("skey", paramString3);
    if (paramInt1 == 2) {
      paramString2.putInt("no_verify_token", paramInt2);
    }
    ((IQRDataApi)QRoute.api(IQRDataApi.class)).requestUrlEncode(paramAppRuntime, paramContext, paramString2, paramString1);
  }
  
  public static boolean a()
  {
    String str1 = Build.MANUFACTURER.toLowerCase();
    String str2 = Build.MODEL.toLowerCase();
    boolean bool;
    if (("meizu".equals(str1)) && (!TextUtils.isEmpty(str2)) && (str2.contains("pro 6 plus"))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isMeizuRubbishDevices device: ");
      localStringBuilder.append(str1);
      localStringBuilder.append("   model:");
      localStringBuilder.append(str2);
      localStringBuilder.append("  return:");
      localStringBuilder.append(bool);
      QLog.i("QRUtils", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private static boolean a(Bitmap paramBitmap, ArrayList<Rect> paramArrayList, Canvas paramCanvas, Rect paramRect)
  {
    Object localObject1 = paramBitmap;
    Object localObject3;
    Object localObject2;
    if (a())
    {
      localObject1 = paramBitmap;
      if (paramRect.width() > 350)
      {
        localObject1 = paramBitmap;
        if (paramRect.height() > 350)
        {
          localObject1 = paramBitmap;
          if (paramBitmap != null) {
            try
            {
              localObject3 = Bitmap.createScaledBitmap(paramBitmap, paramRect.width() / 2, paramRect.height() / 2, false);
              localObject1 = paramBitmap;
              if (localObject3 != null)
              {
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("createScaledBitmap tmp success: w=");
                  ((StringBuilder)localObject1).append(((Bitmap)localObject3).getWidth());
                  ((StringBuilder)localObject1).append(",h=");
                  ((StringBuilder)localObject1).append(((Bitmap)localObject3).getHeight());
                  ((StringBuilder)localObject1).append("org w=");
                  ((StringBuilder)localObject1).append(paramBitmap.getWidth());
                  ((StringBuilder)localObject1).append(",org h=");
                  ((StringBuilder)localObject1).append(paramBitmap.getHeight());
                  QLog.w("QRUtils", 2, ((StringBuilder)localObject1).toString());
                }
                localObject1 = localObject3;
              }
            }
            catch (Throwable localThrowable)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("getQRCard error : ");
              ((StringBuilder)localObject3).append(localThrowable.getMessage());
              QLog.i("QRUtils", 1, ((StringBuilder)localObject3).toString());
              localObject2 = paramBitmap;
            }
          }
        }
      }
    }
    if (paramArrayList != null)
    {
      if ((QLog.isColorLevel()) && (localObject2 != null))
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("size: w=");
        paramBitmap.append(((Bitmap)localObject2).getWidth());
        paramBitmap.append(",h=");
        paramBitmap.append(((Bitmap)localObject2).getHeight());
        QLog.w("QRUtils", 2, paramBitmap.toString());
      }
      try
      {
        paramBitmap = Bitmap.createScaledBitmap((Bitmap)localObject2, paramRect.width(), paramRect.height(), false);
        localObject2 = new Canvas(paramBitmap);
        localObject3 = new Paint();
        ((Paint)localObject3).setAlpha(0);
        ((Paint)localObject3).setAntiAlias(true);
        ((Paint)localObject3).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        int j = 0;
        while (j < paramArrayList.size())
        {
          ((Canvas)localObject2).drawRect(new Rect((Rect)paramArrayList.get(j)), (Paint)localObject3);
          j += 1;
        }
        paramCanvas.drawBitmap(paramBitmap, null, paramRect, null);
        paramBitmap.recycle();
        return false;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        paramBitmap.printStackTrace();
        return true;
      }
    }
    if (localObject2 != null) {
      paramCanvas.drawBitmap((Bitmap)localObject2, null, paramRect, null);
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putInt("my_qr_code_cfg_sp_index", paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveMyQrBgIndex2Sp().index:");
      localStringBuilder.append(paramInt);
      QLog.i("QRUtils", 2, localStringBuilder.toString());
    }
    return paramQQAppInterface.commit();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!QVipQidProcessor.e().b) {
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("sp_vip_qid_info", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("user_qr_card_type");
    localStringBuilder.append(paramString);
    paramQQAppInterface.putInt(localStringBuilder.toString(), paramInt);
    return paramQQAppInterface.commit();
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(a, paramString);
  }
  
  public static byte[] a(long paramLong)
  {
    return new byte[] { (byte)(int)(paramLong >>> 56), (byte)(int)(paramLong >>> 48), (byte)(int)(paramLong >>> 40), (byte)(int)(paramLong >>> 32), (byte)(int)(paramLong >>> 24), (byte)(int)(paramLong >>> 16), (byte)(int)(paramLong >>> 8), (byte)(int)paramLong };
  }
  
  public static final Bitmap[] a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, ArrayList<Rect> paramArrayList, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2)
  {
    Bitmap[] arrayOfBitmap = new Bitmap[2];
    int n = Math.min(750, ScreenUtil.getRealWidth(paramContext));
    int i1 = Math.min(1344, ScreenUtil.getRealHeight(paramContext));
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMyQRCard() shareWidth=");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(",shareHeight=");
      ((StringBuilder)localObject).append(i1);
      QLog.w("QRUtils", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = Bitmap.createBitmap(440, 440, Bitmap.Config.ARGB_8888);
      Bitmap localBitmap = Bitmap.createBitmap(n, i1, Bitmap.Config.ARGB_8888);
      if ((localObject != null) && (localBitmap != null))
      {
        if (a(paramBitmap3, paramArrayList, new Canvas((Bitmap)localObject), new Rect(0, 0, 440, 440))) {
          return null;
        }
        arrayOfBitmap[0] = localObject;
        paramBitmap3 = new Canvas(localBitmap);
        if (QLog.isColorLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append(" shareWidth = ");
          paramArrayList.append(n);
          paramArrayList.append(" shareHeight = ");
          paramArrayList.append(i1);
          QLog.d("QRUtils", 2, paramArrayList.toString());
        }
        a(paramBitmap1, n, i1, paramBitmap3);
        paramBitmap1 = new Paint();
        int i2 = (n - 550) / 2;
        int k = (i1 - 982) / 2;
        int j = 78;
        if (k > 0) {
          j = k + 78;
        }
        int m = j + 772;
        k = m;
        if (paramBoolean2) {
          k = m - 42;
        }
        paramArrayList = new RectF(i2, j, i2 + 550, k);
        paramBitmap1.setAntiAlias(true);
        paramBitmap1.setColor(Color.parseColor("#E6FFFFFF"));
        paramBitmap3.drawRoundRect(paramArrayList, 32.0F, 32.0F, paramBitmap1);
        a(n, paramBitmap3, j);
        b(paramBitmap2, n, paramBitmap3, j);
        a(paramInt1, paramString1, paramString2, n, paramBitmap3, j);
        if (!paramBoolean2)
        {
          paramInt2 = j - 42;
          a((Bitmap)localObject, n, paramBitmap3, paramInt2);
          a(paramInt1, paramString3, n, paramBitmap3, paramInt2, k);
        }
        else
        {
          a(paramString2, paramInt2, n, paramBitmap3, j);
          a((Bitmap)localObject, n, paramBitmap3, j);
          a(paramInt1, paramString3, n, paramBitmap3, j, k);
        }
        if (paramBoolean1) {
          a(paramContext, paramString4, n, i1, paramBitmap3, k);
        }
        arrayOfBitmap[1] = localBitmap;
        return arrayOfBitmap;
      }
      QLog.d("QRUtils", 1, "getMyQRCard() myCode == null || myShare == null");
      return arrayOfBitmap;
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.w("QRUtils", 1, paramContext.getMessage());
    }
    return arrayOfBitmap;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    int j = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("troop_qr_code_cfg_sp_index", -1);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getTroopQrBgIndexFromSp().settingValue:");
      paramQQAppInterface.append(j);
      QLog.i("QRUtils", 2, paramQQAppInterface.toString());
    }
    return j;
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new QRUtils.2(paramInt1, paramInt2));
  }
  
  private static void b(Bitmap paramBitmap, int paramInt1, Canvas paramCanvas, int paramInt2)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      paramInt1 = paramInt1 / 2 - 70;
      paramInt2 -= 66;
      paramCanvas.drawBitmap(paramBitmap, null, new Rect(paramInt1, paramInt2, paramInt1 + 140, paramInt2 + 140), localPaint);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putInt("troop_qr_code_cfg_sp_index", paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveTroopQrBgIndex2Sp().index:");
      localStringBuilder.append(paramInt);
      QLog.i("QRUtils", 2, localStringBuilder.toString());
    }
    return paramQQAppInterface.commit();
  }
  
  public static boolean b(String paramString)
  {
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    if ((Pattern.matches(h, paramString)) || (Pattern.matches(i, paramString))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(i, paramString);
  }
  
  public static boolean d(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.startsWith("http://vac.qq.com/wallet/qrcode.htm")) || (paramString.startsWith("https://vac.qq.com/wallet/qrcode.htm")) || (paramString.startsWith("https://i.qianbao.qq.com/wallet/sqrcode.htm"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean e(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.startsWith("http://qpay.qq.com/qr/")) || (paramString.startsWith("https://qpay.qq.com/qr/"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean f(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.startsWith("http://mqq.tenpay.com/qrhb")) || (paramString.startsWith("https://mqq.tenpay.com/qrhb"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean g(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return URLUtil.isValidUrl(paramString);
  }
  
  public static boolean h(String paramString)
  {
    return (g(paramString)) && ((paramString.startsWith("http:")) || (paramString.startsWith("https:")) || (paramString.startsWith("www.")));
  }
  
  public static boolean i(String paramString)
  {
    return Pattern.matches(b, paramString);
  }
  
  public static boolean j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    ArkPlatformConfigBean localArkPlatformConfigBean = (ArkPlatformConfigBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkPlatformConfigBean.class);
    boolean bool;
    if ((localArkPlatformConfigBean != null) && (localArkPlatformConfigBean.b() != null)) {
      bool = localArkPlatformConfigBean.b().g;
    } else {
      bool = true;
    }
    QLog.d("ScannerUtils", 1, new Object[] { "useNewRule : ", Boolean.valueOf(bool) });
    if (bool) {
      return util.isWtLoginUrlV2(paramString);
    }
    return util.isWtLoginUrlV1(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.util.QRUtils
 * JD-Core Version:    0.7.0.1
 */