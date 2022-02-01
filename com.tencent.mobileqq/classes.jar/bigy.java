import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.1;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.7;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult.ImageAnchorData;
import com.tencent.smtt.sdk.CookieManager;

public class bigy
  extends bign
{
  public int a;
  public final Activity a;
  public bisl a;
  public bkzi a;
  public ScannerResult a;
  public CookieManager a;
  public Object a;
  String a;
  public int b;
  public String b;
  public String c;
  
  public bigy(Activity paramActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity)) {
      this.jdField_a_of_type_Int = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight();
    }
    ThreadManager.postImmediately(new SwiftBrowserLongClickHandler.1(this, paramActivity), null, true);
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    ThreadManager.excute(new SwiftBrowserLongClickHandler.4(this, paramString), 64, null, true);
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 70	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 8
    //   13: new 74	java/io/FileInputStream
    //   16: dup
    //   17: aload 8
    //   19: invokespecial 77	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 5
    //   24: aload 5
    //   26: invokevirtual 82	java/io/InputStream:read	()I
    //   29: istore_2
    //   30: aload 5
    //   32: invokevirtual 82	java/io/InputStream:read	()I
    //   35: istore_3
    //   36: aload 5
    //   38: invokevirtual 82	java/io/InputStream:read	()I
    //   41: istore 4
    //   43: iload_2
    //   44: bipush 66
    //   46: if_icmpne +177 -> 223
    //   49: iload_3
    //   50: bipush 77
    //   52: if_icmpne +171 -> 223
    //   55: ldc 84
    //   57: astore_1
    //   58: aload 5
    //   60: ifnull +331 -> 391
    //   63: aload 5
    //   65: invokevirtual 87	java/io/InputStream:close	()V
    //   68: aload_1
    //   69: ifnull +288 -> 357
    //   72: aload_0
    //   73: getfield 89	bigy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   76: invokestatic 95	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   79: invokevirtual 99	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   82: astore 6
    //   84: aload 6
    //   86: invokestatic 105	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: ifeq +206 -> 295
    //   92: ldc 107
    //   94: astore 5
    //   96: new 70	java/io/File
    //   99: dup
    //   100: getstatic 112	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   103: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: invokevirtual 115	java/io/File:mkdirs	()Z
    //   109: pop
    //   110: new 117	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   117: getstatic 112	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   120: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 5
    //   125: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_1
    //   129: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore 7
    //   137: new 70	java/io/File
    //   140: dup
    //   141: aload 7
    //   143: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   146: astore 6
    //   148: iconst_2
    //   149: istore_2
    //   150: aload 6
    //   152: invokevirtual 128	java/io/File:exists	()Z
    //   155: ifeq +174 -> 329
    //   158: iload_2
    //   159: ldc 129
    //   161: if_icmpge +168 -> 329
    //   164: new 117	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   171: getstatic 112	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   174: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload 5
    //   179: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: ldc 131
    //   184: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: iload_2
    //   188: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: ldc 136
    //   193: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_1
    //   197: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: astore 7
    //   205: new 70	java/io/File
    //   208: dup
    //   209: aload 7
    //   211: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   214: astore 6
    //   216: iload_2
    //   217: iconst_1
    //   218: iadd
    //   219: istore_2
    //   220: goto -70 -> 150
    //   223: iload_2
    //   224: sipush 137
    //   227: if_icmpne +167 -> 394
    //   230: iload_3
    //   231: bipush 80
    //   233: if_icmpne +161 -> 394
    //   236: ldc 138
    //   238: astore_1
    //   239: goto -181 -> 58
    //   242: ldc 140
    //   244: astore_1
    //   245: goto -187 -> 58
    //   248: astore 5
    //   250: goto -182 -> 68
    //   253: astore_1
    //   254: aconst_null
    //   255: astore 5
    //   257: aload 5
    //   259: ifnull +127 -> 386
    //   262: aload 5
    //   264: invokevirtual 87	java/io/InputStream:close	()V
    //   267: aconst_null
    //   268: astore_1
    //   269: goto -201 -> 68
    //   272: astore_1
    //   273: aconst_null
    //   274: astore_1
    //   275: goto -207 -> 68
    //   278: astore_1
    //   279: aload 6
    //   281: astore 5
    //   283: aload 5
    //   285: ifnull +8 -> 293
    //   288: aload 5
    //   290: invokevirtual 87	java/io/InputStream:close	()V
    //   293: aload_1
    //   294: athrow
    //   295: aload 6
    //   297: astore 5
    //   299: aload 6
    //   301: aload_1
    //   302: invokevirtual 146	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   305: ifeq -209 -> 96
    //   308: aload 6
    //   310: iconst_0
    //   311: aload 6
    //   313: invokevirtual 149	java/lang/String:length	()I
    //   316: aload_1
    //   317: invokevirtual 149	java/lang/String:length	()I
    //   320: isub
    //   321: invokevirtual 153	java/lang/String:substring	(II)Ljava/lang/String;
    //   324: astore 5
    //   326: goto -230 -> 96
    //   329: aload 8
    //   331: aload 6
    //   333: invokevirtual 157	java/io/File:renameTo	(Ljava/io/File;)Z
    //   336: ifeq +21 -> 357
    //   339: aload_0
    //   340: getfield 31	bigy:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   343: new 159	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler$5
    //   346: dup
    //   347: aload_0
    //   348: aload 7
    //   350: invokespecial 160	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler$5:<init>	(Lbigy;Ljava/lang/String;)V
    //   353: invokevirtual 164	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   356: return
    //   357: aload_0
    //   358: getfield 31	bigy:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   361: new 166	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler$6
    //   364: dup
    //   365: aload_0
    //   366: invokespecial 169	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler$6:<init>	(Lbigy;)V
    //   369: invokevirtual 164	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   372: return
    //   373: astore 5
    //   375: goto -82 -> 293
    //   378: astore_1
    //   379: goto -96 -> 283
    //   382: astore_1
    //   383: goto -126 -> 257
    //   386: aconst_null
    //   387: astore_1
    //   388: goto -320 -> 68
    //   391: goto -323 -> 68
    //   394: iload_2
    //   395: bipush 71
    //   397: if_icmpne +15 -> 412
    //   400: iload_3
    //   401: bipush 73
    //   403: if_icmpne +9 -> 412
    //   406: ldc 171
    //   408: astore_1
    //   409: goto -351 -> 58
    //   412: iload_2
    //   413: sipush 255
    //   416: if_icmpne +16 -> 432
    //   419: iload_3
    //   420: sipush 216
    //   423: if_icmpne +9 -> 432
    //   426: ldc 173
    //   428: astore_1
    //   429: goto -371 -> 58
    //   432: bipush 82
    //   434: iload_2
    //   435: if_icmpne -193 -> 242
    //   438: bipush 73
    //   440: iload_3
    //   441: if_icmpne -199 -> 242
    //   444: bipush 70
    //   446: iload 4
    //   448: if_icmpne -206 -> 242
    //   451: ldc 175
    //   453: astore_1
    //   454: goto -396 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	this	bigy
    //   0	457	1	paramString	String
    //   29	407	2	i	int
    //   35	407	3	j	int
    //   41	408	4	k	int
    //   22	156	5	localObject1	Object
    //   248	1	5	localIOException1	java.io.IOException
    //   255	70	5	localObject2	Object
    //   373	1	5	localIOException2	java.io.IOException
    //   1	331	6	localObject3	Object
    //   135	214	7	str	String
    //   11	319	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   63	68	248	java/io/IOException
    //   13	24	253	java/io/IOException
    //   262	267	272	java/io/IOException
    //   13	24	278	finally
    //   288	293	373	java/io/IOException
    //   24	43	378	finally
    //   24	43	382	java/io/IOException
  }
  
  void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("detectType", paramInt);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString);
    localIntent.putExtra("preScanResult", this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult);
    String str = this.jdField_a_of_type_JavaLangString;
    paramString = str;
    if (!TextUtils.isEmpty(str))
    {
      paramString = str;
      if (str.startsWith("data:")) {
        paramString = "";
      }
    }
    localIntent.putExtra("report_params", zmk.a(null, paramString, null, null, null, 5));
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((TextUtils.isEmpty(this.c)) || (!this.c.equals(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult == null)) {
          break label142;
        }
        bool2 = this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.d();
        bool1 = this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.c();
        if (bool2)
        {
          a(this.jdField_b_of_type_JavaLangString, 1);
          return true;
        }
      }
      if (bool1)
      {
        a(this.jdField_b_of_type_JavaLangString, 2);
        return true;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, 2131690143, 1).b(this.jdField_a_of_type_Int);
      return false;
      label142:
      boolean bool1 = false;
      boolean bool2 = false;
    }
  }
  
  public boolean a(View paramView)
  {
    int k = 0;
    boolean bool1 = false;
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      bool1 = true;
      return bool1;
    }
    Object localObject;
    int i;
    if ((this.mComponentContext != null) && (this.mComponentContext.a() != null))
    {
      localObject = this.mComponentContext.a();
      paramView = ((com.tencent.smtt.sdk.WebView)localObject).getX5HitTestResult();
      if (paramView != null)
      {
        i = paramView.getType();
        if (i == 8)
        {
          if (!(paramView.getData() instanceof IX5WebViewBase.HitTestResult.ImageAnchorData)) {
            break label531;
          }
          paramView = ((IX5WebViewBase.HitTestResult.ImageAnchorData)paramView.getData()).mPicUrl;
        }
      }
    }
    for (;;)
    {
      label101:
      localObject = ((com.tencent.smtt.sdk.WebView)localObject).getX5WebViewExtension();
      boolean bool2;
      label150:
      int j;
      if (localObject != null)
      {
        localObject = (Boolean)((IX5WebViewExtension)localObject).invokeMiscMethod("supportImageQuery", new Bundle());
        if (localObject != null)
        {
          bool2 = ((Boolean)localObject).booleanValue();
          bool1 = bool2;
          localObject = paramView;
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.d("SwiftBrowserLongClickHandler", 2, "isSupportImageQuery:" + bool2);
            j = i;
            localObject = paramView;
            bool1 = bool2;
          }
        }
      }
      for (;;)
      {
        if ((j != 8) && (j != 5))
        {
          QLog.e("SwiftBrowserLongClickHandler", 1, "the type of HitTestResult is not image type.");
          return false;
          paramView = paramView.getExtra();
          break label101;
          paramView = ((com.tencent.smtt.sdk.WebView)localObject).getHitTestResult();
          if (paramView == null) {
            break;
          }
          i = paramView.getType();
          paramView = paramView.getExtra();
          break label101;
          QLog.e("SwiftBrowserLongClickHandler", 1, "X5WebView supportImageQuery invoke result is null.");
          bool2 = false;
          break label150;
          QLog.e("SwiftBrowserLongClickHandler", 1, "X5WebView extension is null. can't get ability of supportImageQuery");
          bool1 = false;
          localObject = paramView;
          j = i;
          continue;
          if (!(paramView instanceof android.webkit.WebView)) {
            break label519;
          }
          paramView = ((android.webkit.WebView)paramView).getHitTestResult();
          if (paramView == null) {
            break;
          }
          j = paramView.getType();
          localObject = paramView.getExtra();
          bool1 = false;
          continue;
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.e("SwiftBrowserLongClickHandler", 1, "the image url of HitTestResult is empty.");
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserLongClickHandler", 2, "showActionSheet");
        }
        this.jdField_a_of_type_JavaLangString = ((String)localObject);
        i = k;
        if ((this.jdField_a_of_type_AndroidAppActivity instanceof TeamWorkDocEditBrowserActivity)) {
          i = 1;
        }
        this.jdField_a_of_type_Bkzi = bkzi.c(this.jdField_a_of_type_AndroidAppActivity);
        if (bool1) {
          this.jdField_a_of_type_Bkzi.b(2131690672);
        }
        this.jdField_a_of_type_Bkzi.b(2131690671);
        this.jdField_a_of_type_Bkzi.b(2131690670);
        if (i != 0) {
          this.jdField_a_of_type_Bkzi.b(2131693151);
        }
        this.jdField_a_of_type_Bkzi.c(2131690697);
        d(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Bkzi.a(new bigz(this));
        this.jdField_a_of_type_Bkzi.setOnDismissListener(new biha(this));
        this.jdField_a_of_type_Bkzi.setCanceledOnTouchOutside(true);
        try
        {
          this.jdField_a_of_type_Bkzi.show();
          return true;
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            paramView.printStackTrace();
          }
        }
        label519:
        localObject = "";
        j = 0;
        bool1 = false;
      }
      label531:
      paramView = "";
    }
  }
  
  public void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", paramString);
    localBundle.putString("forward_extra", paramString);
    localBundle.putBoolean("not_forward", true);
    localBundle.putString("forward_thumb", paramString);
    localBundle.putBoolean("isFromShare", true);
    localBundle.putBoolean("isJumpAIO", true);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    aupt.a(this.jdField_a_of_type_AndroidAppActivity, paramString, 21);
  }
  
  public void c(String paramString)
  {
    if (this.mComponentContext == null)
    {
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. mComponentContext is null");
      return;
    }
    Object localObject = this.mComponentContext.a();
    if (localObject == null)
    {
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. x5WebView is null");
      return;
    }
    localObject = ((com.tencent.smtt.sdk.WebView)localObject).getX5WebViewExtension();
    if (localObject == null)
    {
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. extension is null");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. filePath is null");
      return;
    }
    ThreadManager.excute(new SwiftBrowserLongClickHandler.7(this, paramString, (IX5WebViewExtension)localObject), 64, null, true);
  }
  
  public void onLifeCycleStateChanged(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((this.jdField_a_of_type_Bkzi != null) && (this.jdField_a_of_type_Bkzi.isShowing())) {
      this.jdField_a_of_type_Bkzi.dismiss();
    }
    apnc.a().a(hashCode(), "SwiftBrowserLongClickHandler");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bigy
 * JD-Core Version:    0.7.0.1
 */