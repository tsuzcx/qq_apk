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
  private static String b;
  AdapterView.OnItemClickListener a = new IntimateInfoShareHelper.2(this);
  private IntimateInfo c;
  private List<ShareActionSheetBuilder.ActionSheetItem>[] d;
  private BaseActivity e;
  private QQAppInterface f;
  private QQProgressDialog g;
  private Bitmap h;
  private Bitmap i;
  private Bitmap j;
  private Bitmap k;
  private WXShareHelper.WXShareListener l;
  private ShareWithPictureActionSheetBuilder m = null;
  
  public IntimateInfoShareHelper(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, IntimateInfo paramIntimateInfo, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    this.e = paramBaseActivity;
    this.f = paramQQAppInterface;
    this.c = paramIntimateInfo;
    this.j = paramBitmap1;
    this.k = paramBitmap2;
    this.i = paramBitmap3;
    paramBaseActivity = this.j;
    if ((paramBaseActivity == null) || (paramBaseActivity.isRecycled())) {
      this.j = BitmapFactory.decodeResource(this.e.getResources(), 2130848187);
    }
    paramBaseActivity = this.k;
    if ((paramBaseActivity == null) || (paramBaseActivity.isRecycled())) {
      this.k = BitmapFactory.decodeResource(this.e.getResources(), 2130848187);
    }
    paramBaseActivity = new StringBuilder();
    paramBaseActivity.append(this.e.getResources().getString(2131891016));
    paramBaseActivity.append(this.e.getResources().getString(2131891017));
    paramBaseActivity.append(this.e.getResources().getString(2131891018));
    b = paramBaseActivity.toString();
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    int n = paramBitmap.getHeight();
    int i1 = paramBitmap.getWidth();
    float f1 = paramInt1 / i1;
    float f2 = paramInt2 / n;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i1, n, localMatrix, false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new IntimateInfoShareHelper.7(this, paramInt1, paramInt2));
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    if (this.l == null)
    {
      this.l = new IntimateInfoShareHelper.4(this);
      WXShareHelper.a().a(this.l);
    }
    String str = c(paramBitmap);
    f();
    if (TextUtils.isEmpty(str))
    {
      a(1, 2131891002);
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
  
  private void d()
  {
    this.m = new ShareWithPictureActionSheetBuilder(this.e);
    this.d = a(this.e);
    this.m.setActionSheetItems(this.d);
    this.m.setItemClickListener(this.a);
  }
  
  private void d(Bitmap paramBitmap)
  {
    paramBitmap = c(paramBitmap);
    f();
    if (TextUtils.isEmpty(paramBitmap))
    {
      a(1, 2131891002);
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = this.f.getAccount();
    BaseActivity localBaseActivity = this.e;
    QZoneHelper.forwardToPublishMood(localBaseActivity, localUserInfo, paramBitmap, localBaseActivity.getResources().getString(2131891020), "", 20001);
  }
  
  private void e()
  {
    if (this.g == null)
    {
      localObject = this.e;
      this.g = new QQProgressDialog((Context)localObject, ((BaseActivity)localObject).getTitleBarHeight());
      this.g.c(true);
    }
    this.g.c(2131891516);
    Object localObject = this.g;
    if ((localObject != null) && (!((QQProgressDialog)localObject).isShowing()) && (!this.e.isFinishing())) {
      this.g.show();
    }
  }
  
  private void e(Bitmap paramBitmap)
  {
    try
    {
      Object localObject = c(paramBitmap);
      f();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        a(1, 2131891002);
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
      ForwardBaseOption.a(this.e, (Intent)localObject, 21);
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      label100:
      break label100;
    }
    a(1, 2131891007);
  }
  
  private void f()
  {
    QQProgressDialog localQQProgressDialog = this.g;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        this.g.dismiss();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void f(Bitmap paramBitmap)
  {
    paramBitmap = c(paramBitmap);
    f();
    if (TextUtils.isEmpty(paramBitmap))
    {
      a(1, 2131891002);
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
      localIntent.putExtra("android.intent.extra.TEXT", b);
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramBitmap)));
      FileProvider7Helper.intentCompatForN(BaseApplicationImpl.getContext(), localIntent);
      localIntent.setPackage(((ApplicationInfo)localObject).packageName);
      this.e.startActivity(localIntent);
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
    a(0, 2131891012);
    label175:
  }
  
  private void g(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.e.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        this.e.requestPermissions(new IntimateInfoShareHelper.5(this, paramBitmap), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      b(paramBitmap);
      return;
    }
    b(paramBitmap);
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    Object localObject = Bitmap.createBitmap(a(this.i, 750, 1272), 0, 1100, 750, 172);
    Canvas localCanvas = new Canvas(paramBitmap);
    localCanvas.drawBitmap((Bitmap)localObject, 0.0F, 1100.0F, null);
    localObject = b();
    if (localObject != null) {
      localCanvas.drawBitmap((Bitmap)localObject, 40.0F, 1125.0F, null);
    }
    localObject = new TextPaint(1);
    ((TextPaint)localObject).setTextSize(24.0F);
    ((TextPaint)localObject).setTextAlign(Paint.Align.LEFT);
    ((TextPaint)localObject).setColor(Color.parseColor("#878B99"));
    localObject = new StaticLayout(b.replace("，", "，\r\n"), (TextPaint)localObject, 350, Layout.Alignment.ALIGN_NORMAL, 1.2F, 0.0F, true);
    localCanvas.save();
    localCanvas.translate(152.0F, 1125.0F);
    ((StaticLayout)localObject).draw(localCanvas);
    localCanvas.restore();
    localCanvas.drawBitmap(a(BitmapFactory.decodeResource(this.e.getResources(), 2130841302), 194, 40), 512.0F, 1185.0F, null);
    return paramBitmap;
  }
  
  public Bitmap a(IntimateInfo paramIntimateInfo)
  {
    Bitmap localBitmap = Bitmap.createBitmap(750, 1272, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(a(this.i, 750, 1272), 0.0F, 0.0F, null);
    Object localObject2 = a(this.j, 140, 140);
    Object localObject1 = a(this.k, 140, 140);
    localCanvas.drawBitmap((Bitmap)localObject2, 248.0F, 180.0F, null);
    localObject2 = new Paint(1);
    ((Paint)localObject2).setColor(-1);
    localCanvas.drawCircle(223.0F, 250.0F, 75.0F, (Paint)localObject2);
    localCanvas.drawBitmap((Bitmap)localObject1, 153.0F, 180.0F, null);
    int n = paramIntimateInfo.maskType;
    int i1;
    if (n != 1) {
      if (n != 2) {
        if (n != 3) {
          if (n != 26)
          {
            localObject1 = this.e.getResources().getString(2131891008);
            n = Color.parseColor("#03081A");
            i1 = Color.parseColor("#878B99");
            localObject2 = BitmapFactory.decodeResource(this.e.getResources(), 2130841298);
          }
        }
      }
    }
    for (;;)
    {
      break;
      localObject1 = this.e.getResources().getString(2131891015);
      n = Color.parseColor("#8173FF");
      i1 = Color.parseColor("#8173FF");
      localObject2 = BitmapFactory.decodeResource(this.e.getResources(), 2130841303);
      continue;
      localObject1 = this.e.getResources().getString(2131891010);
      n = Color.parseColor("#2493FF");
      i1 = Color.parseColor("#4DA7FF");
      localObject2 = BitmapFactory.decodeResource(this.e.getResources(), 2130841300);
      continue;
      localObject1 = this.e.getResources().getString(2131891009);
      n = Color.parseColor("#FF8A2D");
      i1 = Color.parseColor("#FF9F40");
      localObject2 = BitmapFactory.decodeResource(this.e.getResources(), 2130841299);
      continue;
      localObject1 = this.e.getResources().getString(2131891011);
      n = Color.parseColor("#FF6FA3");
      i1 = Color.parseColor("#FF8AB5");
      localObject2 = BitmapFactory.decodeResource(this.e.getResources(), 2130841301);
    }
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.setColor(n);
    localTextPaint.setTextSize(80.0F);
    localTextPaint.setTextAlign(Paint.Align.LEFT);
    a(localCanvas, localTextPaint, 146.0F, 364.0F, String.valueOf(this.c.beFriendDays));
    float f1 = Layout.getDesiredWidth(String.valueOf(this.c.beFriendDays), localTextPaint);
    localTextPaint.setTextSize(34.0F);
    Object localObject3 = this.e.getResources();
    int i3 = 0;
    a(localCanvas, localTextPaint, f1 + 146.0F + 8.0F, 410.0F, ((Resources)localObject3).getString(2131890950, new Object[] { "" }));
    a(localCanvas, localTextPaint, 152.0F, 468.0F, (String)localObject1);
    localObject1 = this.e.getResources();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131891003));
    ((StringBuilder)localObject3).append("\r\n");
    ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131891004));
    ((StringBuilder)localObject3).append("\r\n");
    if ((paramIntimateInfo.commonTroopInfoList != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0))
    {
      ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131890982));
      ((StringBuilder)localObject3).append(this.c.commonTroopInfoList.size());
      ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131890965));
      ((StringBuilder)localObject3).append("\r\n");
      n = 2;
    }
    else
    {
      n = 3;
    }
    int i2 = n;
    if (paramIntimateInfo.dnaInfoList != null)
    {
      i2 = n;
      if (paramIntimateInfo.dnaInfoList.size() > 0)
      {
        i2 = n;
        if (paramIntimateInfo.dnaInfoList.size() < n) {
          i2 = paramIntimateInfo.dnaInfoList.size();
        }
      }
    }
    if ((paramIntimateInfo.dnaInfoList != null) && (paramIntimateInfo.dnaInfoList.size() > 0))
    {
      n = i3;
      while (n < i2)
      {
        ((StringBuilder)localObject3).append(((IntimateInfo.DNAInfo)paramIntimateInfo.dnaInfoList.get(n)).wording.replaceAll("，", "，\r\n"));
        ((StringBuilder)localObject3).append("\r\n");
        n += 1;
      }
    }
    ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131891005));
    ((StringBuilder)localObject3).append("\r\n");
    ((StringBuilder)localObject3).append(((Resources)localObject1).getString(2131891006));
    localTextPaint.setColor(i1);
    localTextPaint.setTextSize(24.0F);
    paramIntimateInfo = new StaticLayout((CharSequence)localObject3, localTextPaint, 300, Layout.Alignment.ALIGN_NORMAL, 1.7F, 0.0F, true);
    localCanvas.save();
    localCanvas.translate(152.0F, 560.0F);
    paramIntimateInfo.draw(localCanvas);
    localCanvas.restore();
    localCanvas.drawBitmap(a((Bitmap)localObject2, 254, 40), 248.0F, 1163.0F, null);
    return localBitmap;
  }
  
  public void a()
  {
    if (this.m == null) {
      d();
    }
    Bitmap localBitmap = this.h;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.m.a(this.h);
      this.m.show();
      return;
    }
    ThreadManager.getFileThreadHandler().post(new IntimateInfoShareHelper.1(this));
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    if ((paramInt == 3) || (paramInt == 4))
    {
      BaseActivity localBaseActivity;
      if (!WXShareHelper.a().b())
      {
        localBaseActivity = this.e;
        QQToast.makeText(localBaseActivity, localBaseActivity.getString(2131891013), 0).show(this.e.getTitleBarHeight());
      }
      else if (!WXShareHelper.a().c())
      {
        localBaseActivity = this.e;
        QQToast.makeText(localBaseActivity, localBaseActivity.getString(2131891021), 0).show(this.e.getTitleBarHeight());
      }
    }
    e();
    ThreadManager.getFileThreadHandler().post(new IntimateInfoShareHelper.3(this, paramBitmap, paramInt));
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894171);
    localActionSheetItem.icon = 2130839221;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894185);
    localActionSheetItem.icon = 2130839222;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894192);
    localActionSheetItem.icon = 2130839225;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131894174);
    localActionSheetItem.icon = 2130839219;
    localActionSheetItem.action = 4;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131891023);
    localActionSheetItem.icon = 2130840475;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 0;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return new ArrayList[] { localArrayList };
  }
  
  public Bitmap b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://ti.qq.com/open_qq/newIndex.html?url=mqqapi%3A%2F%2Fuserprofile%2Ffriend_profile_card%3Fsrc_type%3Dweb%26version%3D1.0%26source%3D1%26uin%3D");
    ((StringBuilder)localObject1).append(this.f.getCurrentUin());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new Hashtable();
    ((Hashtable)localObject2).put(EncodeHintType.MARGIN, Integer.valueOf(0));
    ((Hashtable)localObject2).put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    int i3;
    int n;
    int i1;
    try
    {
      localObject2 = new QRCodeWriter().a((String)localObject1, 100, 100, (Map)localObject2);
      i2 = ((BitMatrix)localObject2).a();
      i3 = ((BitMatrix)localObject2).b();
      localObject1 = new int[i2 * i3];
      n = 0;
    }
    catch (WriterException localWriterException)
    {
      int i2;
      break label175;
    }
    if (i1 < i2) {
      if (((BitMatrix)localObject2).a(i1, n)) {
        localObject1[(n * i2 + i1)] = -16777216;
      }
    }
    label175:
    label221:
    for (;;)
    {
      localObject2 = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject2).setPixels((int[])localObject1, 0, i2, 0, 0, i2, i3);
      return localObject2;
      if (QLog.isColorLevel()) {
        QLog.d("IntimateInfoShareHelper", 2, "Create QRCode fail");
      }
      return null;
      for (;;)
      {
        if (n >= i3) {
          break label221;
        }
        i1 = 0;
        break;
        i1 += 1;
        break;
        n += 1;
      }
    }
  }
  
  public void b(Bitmap paramBitmap)
  {
    ThreadManager.executeOnFileThread(new IntimateInfoShareHelper.6(this, paramBitmap));
  }
  
  /* Error */
  public String c(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 75	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc_w 780
    //   12: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_2
    //   17: invokestatic 786	java/lang/System:currentTimeMillis	()J
    //   20: invokevirtual 789	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_2
    //   25: aload_0
    //   26: getfield 46	com/tencent/mobileqq/activity/aio/IntimateInfoShareHelper:f	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: invokevirtual 792	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   32: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: ldc_w 794
    //   40: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_2
    //   45: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore_2
    //   49: new 377	java/io/File
    //   52: dup
    //   53: new 377	java/io/File
    //   56: dup
    //   57: getstatic 799	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   60: ldc_w 801
    //   63: invokespecial 803	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: invokevirtual 806	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: invokestatic 812	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   72: invokespecial 378	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore_3
    //   76: aload_3
    //   77: invokevirtual 815	java/io/File:mkdirs	()Z
    //   80: pop
    //   81: aload_3
    //   82: ifnull +204 -> 286
    //   85: aload_3
    //   86: invokevirtual 818	java/io/File:canWrite	()Z
    //   89: ifeq +197 -> 286
    //   92: new 377	java/io/File
    //   95: dup
    //   96: aload_3
    //   97: invokevirtual 806	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   100: aload_2
    //   101: invokespecial 803	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: astore_2
    //   105: aload_2
    //   106: invokevirtual 806	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   109: astore 4
    //   111: aload_2
    //   112: invokevirtual 821	java/io/File:exists	()Z
    //   115: ifeq +8 -> 123
    //   118: aload_2
    //   119: invokevirtual 824	java/io/File:delete	()Z
    //   122: pop
    //   123: new 826	java/io/BufferedOutputStream
    //   126: dup
    //   127: new 828	java/io/FileOutputStream
    //   130: dup
    //   131: aload_2
    //   132: invokespecial 831	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   135: invokespecial 834	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   138: astore_3
    //   139: aload_3
    //   140: astore_2
    //   141: aload_1
    //   142: getstatic 840	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   145: bipush 100
    //   147: aload_3
    //   148: invokevirtual 844	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   151: pop
    //   152: aload_3
    //   153: astore_2
    //   154: aload_3
    //   155: invokevirtual 847	java/io/BufferedOutputStream:flush	()V
    //   158: aload_3
    //   159: invokevirtual 850	java/io/BufferedOutputStream:close	()V
    //   162: aload 4
    //   164: areturn
    //   165: astore_1
    //   166: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +14 -> 183
    //   172: ldc_w 346
    //   175: iconst_2
    //   176: aload_1
    //   177: invokevirtual 853	java/io/IOException:getMessage	()Ljava/lang/String;
    //   180: invokestatic 351	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   205: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +16 -> 224
    //   211: aload_1
    //   212: astore_2
    //   213: ldc_w 346
    //   216: iconst_2
    //   217: aload_3
    //   218: invokevirtual 854	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: invokestatic 351	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload_1
    //   225: ifnull +61 -> 286
    //   228: aload_1
    //   229: invokevirtual 850	java/io/BufferedOutputStream:close	()V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_1
    //   235: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +48 -> 286
    //   241: ldc_w 346
    //   244: iconst_2
    //   245: aload_1
    //   246: invokevirtual 853	java/io/IOException:getMessage	()Ljava/lang/String;
    //   249: invokestatic 351	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: aconst_null
    //   253: areturn
    //   254: astore_1
    //   255: aload_2
    //   256: ifnull +28 -> 284
    //   259: aload_2
    //   260: invokevirtual 850	java/io/BufferedOutputStream:close	()V
    //   263: goto +21 -> 284
    //   266: astore_2
    //   267: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +14 -> 284
    //   273: ldc_w 346
    //   276: iconst_2
    //   277: aload_2
    //   278: invokevirtual 853	java/io/IOException:getMessage	()Ljava/lang/String;
    //   281: invokestatic 351	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  public void c()
  {
    if (this.l != null)
    {
      WXShareHelper.a().b(this.l);
      this.l = null;
    }
    ShareWithPictureActionSheetBuilder localShareWithPictureActionSheetBuilder = this.m;
    if (localShareWithPictureActionSheetBuilder != null) {
      localShareWithPictureActionSheetBuilder.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper
 * JD-Core Version:    0.7.0.1
 */