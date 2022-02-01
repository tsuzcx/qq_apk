package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareWithPictureActionSheetBuilder;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class IntimateInfoShareHelper
{
  private static String jdField_a_of_type_JavaLangString;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new IntimateInfoShareHelper.2(this);
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  private ShareWithPictureActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareWithPictureActionSheetBuilder = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  private List<ShareActionSheetBuilder.ActionSheetItem>[] jdField_a_of_type_ArrayOfJavaUtilList;
  private Bitmap b;
  private Bitmap c;
  private Bitmap d;
  
  public IntimateInfoShareHelper(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, IntimateInfo paramIntimateInfo, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.c = paramBitmap1;
    this.d = paramBitmap2;
    this.b = paramBitmap3;
    paramBaseActivity = this.c;
    if ((paramBaseActivity == null) || (paramBaseActivity.isRecycled())) {
      this.c = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130846635);
    }
    paramBaseActivity = this.d;
    if ((paramBaseActivity == null) || (paramBaseActivity.isRecycled())) {
      this.d = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130846635);
    }
    paramBaseActivity = new StringBuilder();
    paramBaseActivity.append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693467));
    paramBaseActivity.append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693468));
    paramBaseActivity.append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693469));
    jdField_a_of_type_JavaLangString = paramBaseActivity.toString();
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    float f1 = paramInt1 / j;
    float f2 = paramInt2 / i;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, j, i, localMatrix, false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new IntimateInfoShareHelper.7(this, paramInt1, paramInt2));
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new IntimateInfoShareHelper.4(this);
      WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    }
    String str = a(paramBitmap);
    e();
    if (TextUtils.isEmpty(str))
    {
      a(1, 2131693453);
      return;
    }
    if (paramInt == 3)
    {
      WXShareHelper.a().a(str, paramBitmap, 0);
      return;
    }
    if (paramInt == 4) {
      WXShareHelper.a().a(str, paramBitmap, 1);
    }
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, String paramString)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2 - paramPaint.getFontMetrics().top, paramPaint);
  }
  
  private void b(Bitmap paramBitmap)
  {
    paramBitmap = a(paramBitmap);
    e();
    if (TextUtils.isEmpty(paramBitmap))
    {
      a(1, 2131693453);
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    QZoneHelper.forwardToPublishMood(localBaseActivity, localUserInfo, paramBitmap, localBaseActivity.getResources().getString(2131693471), "", 20001);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareWithPictureActionSheetBuilder = new ShareWithPictureActionSheetBuilder(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ArrayOfJavaUtilList = a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareWithPictureActionSheetBuilder.setActionSheetItems(this.jdField_a_of_type_ArrayOfJavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareWithPictureActionSheetBuilder.setItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
  }
  
  private void c(Bitmap paramBitmap)
  {
    try
    {
      Object localObject = a(paramBitmap);
      e();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        a(1, 2131693453);
        return;
      }
      paramBitmap = new Bundle();
      paramBitmap.putInt("forward_type", 1);
      paramBitmap.putString("forward_filepath", (String)localObject);
      paramBitmap.putString("forward_thumb", (String)localObject);
      paramBitmap.putString("forward_urldrawable_big_url", (String)localObject);
      paramBitmap.putString("forward_extra", "intimate_share");
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramBitmap);
      ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject, 21);
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      label96:
      break label96;
    }
    a(1, 2131693458);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog((Context)localObject, ((BaseActivity)localObject).getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693895);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (!((QQProgressDialog)localObject).isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void d(Bitmap paramBitmap)
  {
    paramBitmap = a(paramBitmap);
    e();
    if (TextUtils.isEmpty(paramBitmap))
    {
      a(1, 2131693453);
      return;
    }
    Object localObject = BaseApplicationImpl.getContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
      boolean bool = QLog.isColorLevel();
      if (bool) {
        QLog.d("IntimateInfoShareHelper", 2, "shareMsgToSina installSinaWeibo:true");
      }
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setFlags(268435456);
      localIntent.setType("image/*");
      localIntent.putExtra("android.intent.extra.TEXT", jdField_a_of_type_JavaLangString);
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramBitmap)));
      FileProvider7Helper.intentCompatForN(BaseApplicationImpl.getContext(), localIntent);
      localIntent.setPackage(((ApplicationInfo)localObject).packageName);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      if (!QLog.isColorLevel()) {
        break label175;
      }
      QLog.d("IntimateInfoShareHelper", 2, "shareMsgToSina start weibo!");
      return;
    }
    catch (PackageManager.NameNotFoundException paramBitmap)
    {
      label167:
      break label167;
    }
    a(0, 2131693463);
    label175:
  }
  
  private void e()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void e(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new IntimateInfoShareHelper.5(this, paramBitmap), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      a(paramBitmap);
      return;
    }
    a(paramBitmap);
  }
  
  public Bitmap a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://ti.qq.com/open_qq/newIndex.html?url=mqqapi%3A%2F%2Fuserprofile%2Ffriend_profile_card%3Fsrc_type%3Dweb%26version%3D1.0%26source%3D1%26uin%3D");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new Hashtable();
    ((Hashtable)localObject2).put(EncodeHintType.MARGIN, Integer.valueOf(0));
    ((Hashtable)localObject2).put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    int m;
    int i;
    int j;
    try
    {
      localObject2 = new QRCodeWriter().a((String)localObject1, 100, 100, (Map)localObject2);
      k = ((BitMatrix)localObject2).a();
      m = ((BitMatrix)localObject2).b();
      localObject1 = new int[k * m];
      i = 0;
    }
    catch (WriterException localWriterException)
    {
      int k;
      break label175;
    }
    if (j < k) {
      if (((BitMatrix)localObject2).a(j, i)) {
        localObject1[(i * k + j)] = -16777216;
      }
    }
    label175:
    label221:
    for (;;)
    {
      localObject2 = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject2).setPixels((int[])localObject1, 0, k, 0, 0, k, m);
      return localObject2;
      if (QLog.isColorLevel()) {
        QLog.d("IntimateInfoShareHelper", 2, "Create QRCode fail");
      }
      return null;
      for (;;)
      {
        if (i >= m) {
          break label221;
        }
        j = 0;
        break;
        j += 1;
        break;
        i += 1;
      }
    }
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    Object localObject = Bitmap.createBitmap(a(this.b, 750, 1272), 0, 1100, 750, 172);
    Canvas localCanvas = new Canvas(paramBitmap);
    localCanvas.drawBitmap((Bitmap)localObject, 0.0F, 1100.0F, null);
    localObject = a();
    if (localObject != null) {
      localCanvas.drawBitmap((Bitmap)localObject, 40.0F, 1125.0F, null);
    }
    localObject = new TextPaint(1);
    ((TextPaint)localObject).setTextSize(24.0F);
    ((TextPaint)localObject).setTextAlign(Paint.Align.LEFT);
    ((TextPaint)localObject).setColor(Color.parseColor("#878B99"));
    localObject = new StaticLayout(jdField_a_of_type_JavaLangString.replace("，", "，\r\n"), (TextPaint)localObject, 350, Layout.Alignment.ALIGN_NORMAL, 1.2F, 0.0F, true);
    localCanvas.save();
    localCanvas.translate(152.0F, 1125.0F);
    ((StaticLayout)localObject).draw(localCanvas);
    localCanvas.restore();
    localCanvas.drawBitmap(a(BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130840536), 194, 40), 512.0F, 1185.0F, null);
    return paramBitmap;
  }
  
  public Bitmap a(IntimateInfo paramIntimateInfo)
  {
    Bitmap localBitmap = Bitmap.createBitmap(750, 1272, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(a(this.b, 750, 1272), 0.0F, 0.0F, null);
    Object localObject2 = a(this.c, 140, 140);
    Object localObject1 = a(this.d, 140, 140);
    localCanvas.drawBitmap((Bitmap)localObject2, 248.0F, 180.0F, null);
    localObject2 = new Paint(1);
    ((Paint)localObject2).setColor(-1);
    localCanvas.drawCircle(223.0F, 250.0F, 75.0F, (Paint)localObject2);
    localCanvas.drawBitmap((Bitmap)localObject1, 153.0F, 180.0F, null);
    int i = paramIntimateInfo.maskType;
    int j;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 26)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693459);
            i = Color.parseColor("#03081A");
            j = Color.parseColor("#878B99");
            localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130840532);
          }
        }
      }
    }
    for (;;)
    {
      break;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693466);
      i = Color.parseColor("#8173FF");
      j = Color.parseColor("#8173FF");
      localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130840537);
      continue;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693461);
      i = Color.parseColor("#2493FF");
      j = Color.parseColor("#4DA7FF");
      localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130840534);
      continue;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693460);
      i = Color.parseColor("#FF8A2D");
      j = Color.parseColor("#FF9F40");
      localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130840533);
      continue;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693462);
      i = Color.parseColor("#FF6FA3");
      j = Color.parseColor("#FF8AB5");
      localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130840535);
    }
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.setColor(i);
    localTextPaint.setTextSize(80.0F);
    localTextPaint.setTextAlign(Paint.Align.LEFT);
    a(localCanvas, localTextPaint, 146.0F, 364.0F, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays));
    float f = Layout.getDesiredWidth(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays), localTextPaint);
    localTextPaint.setTextSize(34.0F);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int m = 0;
    a(localCanvas, localTextPaint, f + 146.0F + 8.0F, 410.0F, ((Resources)localObject3).getString(2131693401, new Object[] { "" }));
    a(localCanvas, localTextPaint, 152.0F, 468.0F, (String)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131693454));
    ((StringBuilder)localObject3).append("\r\n");
    ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131693455));
    ((StringBuilder)localObject3).append("\r\n");
    if ((paramIntimateInfo.commonTroopInfoList != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0))
    {
      ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131693433));
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList.size());
      ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131693416));
      ((StringBuilder)localObject3).append("\r\n");
      i = 2;
    }
    else
    {
      i = 3;
    }
    int k = i;
    if (paramIntimateInfo.dnaInfoList != null)
    {
      k = i;
      if (paramIntimateInfo.dnaInfoList.size() > 0)
      {
        k = i;
        if (paramIntimateInfo.dnaInfoList.size() < i) {
          k = paramIntimateInfo.dnaInfoList.size();
        }
      }
    }
    if ((paramIntimateInfo.dnaInfoList != null) && (paramIntimateInfo.dnaInfoList.size() > 0))
    {
      i = m;
      while (i < k)
      {
        ((StringBuilder)localObject3).append(((IntimateInfo.DNAInfo)paramIntimateInfo.dnaInfoList.get(i)).wording.replaceAll("，", "，\r\n"));
        ((StringBuilder)localObject3).append("\r\n");
        i += 1;
      }
    }
    ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131693456));
    ((StringBuilder)localObject3).append("\r\n");
    ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131693457));
    localTextPaint.setColor(j);
    localTextPaint.setTextSize(24.0F);
    paramIntimateInfo = new StaticLayout((CharSequence)localObject3, localTextPaint, 300, Layout.Alignment.ALIGN_NORMAL, 1.7F, 0.0F, true);
    localCanvas.save();
    localCanvas.translate(152.0F, 560.0F);
    paramIntimateInfo.draw(localCanvas);
    localCanvas.restore();
    localCanvas.drawBitmap(a((Bitmap)localObject2, 254, 40), 248.0F, 1163.0F, null);
    return localBitmap;
  }
  
  /* Error */
  public String a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 66	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc_w 690
    //   12: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_2
    //   17: invokestatic 696	java/lang/System:currentTimeMillis	()J
    //   20: invokevirtual 699	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_2
    //   25: aload_0
    //   26: getfield 37	com/tencent/mobileqq/activity/aio/IntimateInfoShareHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: invokevirtual 702	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   32: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: ldc_w 704
    //   40: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_2
    //   45: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore_2
    //   49: new 359	java/io/File
    //   52: dup
    //   53: new 359	java/io/File
    //   56: dup
    //   57: getstatic 709	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   60: ldc_w 711
    //   63: invokespecial 713	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: invokevirtual 716	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: invokestatic 722	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   72: invokespecial 360	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore_3
    //   76: aload_3
    //   77: invokevirtual 725	java/io/File:mkdirs	()Z
    //   80: pop
    //   81: aload_3
    //   82: ifnull +204 -> 286
    //   85: aload_3
    //   86: invokevirtual 728	java/io/File:canWrite	()Z
    //   89: ifeq +197 -> 286
    //   92: new 359	java/io/File
    //   95: dup
    //   96: aload_3
    //   97: invokevirtual 716	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   100: aload_2
    //   101: invokespecial 713	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: astore_2
    //   105: aload_2
    //   106: invokevirtual 716	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   109: astore 4
    //   111: aload_2
    //   112: invokevirtual 731	java/io/File:exists	()Z
    //   115: ifeq +8 -> 123
    //   118: aload_2
    //   119: invokevirtual 734	java/io/File:delete	()Z
    //   122: pop
    //   123: new 736	java/io/BufferedOutputStream
    //   126: dup
    //   127: new 738	java/io/FileOutputStream
    //   130: dup
    //   131: aload_2
    //   132: invokespecial 741	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   135: invokespecial 744	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   138: astore_3
    //   139: aload_3
    //   140: astore_2
    //   141: aload_1
    //   142: getstatic 750	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   145: bipush 100
    //   147: aload_3
    //   148: invokevirtual 754	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   151: pop
    //   152: aload_3
    //   153: astore_2
    //   154: aload_3
    //   155: invokevirtual 757	java/io/BufferedOutputStream:flush	()V
    //   158: aload_3
    //   159: invokevirtual 760	java/io/BufferedOutputStream:close	()V
    //   162: aload 4
    //   164: areturn
    //   165: astore_1
    //   166: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +14 -> 183
    //   172: ldc_w 328
    //   175: iconst_2
    //   176: aload_1
    //   177: invokevirtual 763	java/io/IOException:getMessage	()Ljava/lang/String;
    //   180: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: aload 4
    //   185: areturn
    //   186: astore_2
    //   187: aload_3
    //   188: astore_1
    //   189: aload_2
    //   190: astore_3
    //   191: goto +12 -> 203
    //   194: astore_1
    //   195: aconst_null
    //   196: astore_2
    //   197: goto +58 -> 255
    //   200: astore_3
    //   201: aconst_null
    //   202: astore_1
    //   203: aload_1
    //   204: astore_2
    //   205: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +16 -> 224
    //   211: aload_1
    //   212: astore_2
    //   213: ldc_w 328
    //   216: iconst_2
    //   217: aload_3
    //   218: invokevirtual 764	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload_1
    //   225: ifnull +61 -> 286
    //   228: aload_1
    //   229: invokevirtual 760	java/io/BufferedOutputStream:close	()V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_1
    //   235: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +48 -> 286
    //   241: ldc_w 328
    //   244: iconst_2
    //   245: aload_1
    //   246: invokevirtual 763	java/io/IOException:getMessage	()Ljava/lang/String;
    //   249: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: aconst_null
    //   253: areturn
    //   254: astore_1
    //   255: aload_2
    //   256: ifnull +28 -> 284
    //   259: aload_2
    //   260: invokevirtual 760	java/io/BufferedOutputStream:close	()V
    //   263: goto +21 -> 284
    //   266: astore_2
    //   267: invokestatic 326	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +14 -> 284
    //   273: ldc_w 328
    //   276: iconst_2
    //   277: aload_2
    //   278: invokevirtual 763	java/io/IOException:getMessage	()Ljava/lang/String;
    //   281: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload_1
    //   285: athrow
    //   286: aconst_null
    //   287: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	IntimateInfoShareHelper
    //   0	288	1	paramBitmap	Bitmap
    //   7	147	2	localObject1	Object
    //   186	4	2	localException1	Exception
    //   196	64	2	localBitmap	Bitmap
    //   266	12	2	localIOException	java.io.IOException
    //   75	116	3	localObject2	Object
    //   200	18	3	localException2	Exception
    //   109	75	4	str	String
    // Exception table:
    //   from	to	target	type
    //   158	162	165	java/io/IOException
    //   141	152	186	java/lang/Exception
    //   154	158	186	java/lang/Exception
    //   123	139	194	finally
    //   123	139	200	java/lang/Exception
    //   228	232	234	java/io/IOException
    //   141	152	254	finally
    //   154	158	254	finally
    //   205	211	254	finally
    //   213	224	254	finally
    //   259	263	266	java/io/IOException
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareWithPictureActionSheetBuilder == null) {
      c();
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareWithPictureActionSheetBuilder.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareWithPictureActionSheetBuilder.show();
      return;
    }
    ThreadManager.getFileThreadHandler().post(new IntimateInfoShareHelper.1(this));
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    if ((paramInt == 3) || (paramInt == 4))
    {
      BaseActivity localBaseActivity;
      if (!WXShareHelper.a().a())
      {
        localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
        QQToast.a(localBaseActivity, localBaseActivity.getString(2131693464), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      }
      else if (!WXShareHelper.a().b())
      {
        localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
        QQToast.a(localBaseActivity, localBaseActivity.getString(2131693472), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      }
    }
    d();
    ThreadManager.getFileThreadHandler().post(new IntimateInfoShareHelper.3(this, paramBitmap, paramInt));
  }
  
  public void a(Bitmap paramBitmap)
  {
    ThreadManager.executeOnFileThread(new IntimateInfoShareHelper.6(this, paramBitmap));
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696399);
    localActionSheetItem.icon = 2130839067;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696413);
    localActionSheetItem.icon = 2130839068;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696420);
    localActionSheetItem.icon = 2130839071;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696402);
    localActionSheetItem.icon = 2130839065;
    localActionSheetItem.action = 4;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131693474);
    localActionSheetItem.icon = 2130840170;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 0;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return new ArrayList[] { localArrayList };
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    }
    ShareWithPictureActionSheetBuilder localShareWithPictureActionSheetBuilder = this.jdField_a_of_type_ComTencentMobileqqUtilsShareWithPictureActionSheetBuilder;
    if (localShareWithPictureActionSheetBuilder != null) {
      localShareWithPictureActionSheetBuilder.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper
 * JD-Core Version:    0.7.0.1
 */