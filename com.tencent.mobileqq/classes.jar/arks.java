import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public final class arks
  implements Handler.Callback
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final View jdField_a_of_type_AndroidViewView;
  private final arkl jdField_a_of_type_Arkl;
  private bepp jdField_a_of_type_Bepp;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private volatile boolean jdField_a_of_type_Boolean;
  private final MqqHandler b;
  
  public arks(arkl paramarkl, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Arkl = paramarkl;
    this.jdField_a_of_type_AndroidViewView = paramarkl.a().getLayoutInflater().inflate(2131560658, paramViewGroup, false);
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.jdField_a_of_type_AndroidViewView.measure(i, i);
    TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373866);
    TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373864);
    paramViewGroup = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373865);
    String str = paramarkl.a();
    i = paramarkl.a();
    localTextView1.setText(arni.a(str, true, localTextView1.getMeasuredWidth(), localTextView1.getPaint(), 1));
    localTextView2.setText(arof.a(paramarkl.a()));
    paramViewGroup.setImageResource(arni.b(str));
    if ((i == 5) || (i == 0))
    {
      paramarkl = paramarkl.b();
      if (arof.b(paramarkl))
      {
        if (i != 5) {
          break label255;
        }
        paramViewGroup.setApkIconAsyncImage(paramarkl);
      }
    }
    for (;;)
    {
      paramViewGroup.setSupportMaskView(false);
      ((AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373855)).setSupportMaskView(false);
      this.jdField_a_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_a_of_type_MqqOsMqqHandler = new bhoe(Looper.getMainLooper(), this, true);
      this.b = new bhoe(ThreadManagerV2.getFileThreadLooper(), this, false);
      return;
      label255:
      paramViewGroup.setAsyncImage(paramarkl);
    }
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    if (paramBitmap == null) {
      return null;
    }
    localAsyncImageView = (AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373855);
    localAsyncImageView.setImageBitmap(paramBitmap);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373868);
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    if (TextUtils.isEmpty(paramString))
    {
      paramBitmap = new StringBuilder().append(BaseApplicationImpl.sApplication.getString(2131698526)).append(":");
      paramString = BaseApplicationImpl.sApplication;
      if (paramInt == 1) {
        paramInt = 2131698524;
      }
    }
    for (paramBitmap = paramString.getString(paramInt);; paramBitmap = BaseApplicationImpl.sApplication.getString(2131698527) + ":" + paramString)
    {
      localTextView.setText(localBaseApplicationImpl.getString(2131698517, new Object[] { paramBitmap }));
      try
      {
        paramBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.jdField_a_of_type_AndroidViewView.draw(new Canvas(paramBitmap));
        return paramBitmap;
      }
      catch (Throwable paramBitmap)
      {
        QLog.e("WeiyunShareQrController<FileAssistant>", 2, "mergeQrPanel error", paramBitmap);
        return null;
      }
      finally
      {
        localAsyncImageView.setImageDrawable(null);
      }
      if (paramInt == 2)
      {
        paramInt = 2131698523;
        break;
      }
      paramInt = 2131698525;
      break;
    }
  }
  
  private static String a(Bitmap paramBitmap)
  {
    String str = "qfile_qrcode_share_" + System.currentTimeMillis() + ".png";
    try
    {
      paramBitmap = xxb.a(BaseApplicationImpl.sApplication, str, paramBitmap);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      QLog.w("WeiyunShareQrController<FileAssistant>", 2, "saveTemp error", paramBitmap);
    }
    return "";
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, Bitmap paramBitmap, String paramString)
  {
    if (paramActionSheetItem == null) {}
    int i;
    Object localObject;
    do
    {
      return;
      i = paramActionSheetItem.action;
      localObject = this.jdField_a_of_type_Arkl.a();
    } while ((localObject == null) || (((BaseActivity)localObject).isFinishing()));
    if (this.jdField_a_of_type_Bepp != null) {
      this.jdField_a_of_type_Bepp.dismiss();
    }
    if ("".equals(paramString))
    {
      arkn.a(1, 2131696945, true);
      return;
    }
    if (paramString == null)
    {
      if (i == 39) {}
      for (i = 2131717618;; i = 2131696944)
      {
        arkn.a(1, i, true);
        return;
      }
    }
    switch (i)
    {
    default: 
      return;
    case 2: 
      paramActionSheetItem = new Intent();
      paramActionSheetItem.putExtra("isFromShare", true);
      paramActionSheetItem.putExtra("forward_type", 1);
      paramActionSheetItem.putExtra("forward_filepath", paramString);
      paramActionSheetItem.putExtra("forward_thumb", paramString);
      paramActionSheetItem.putExtra("forward_urldrawable_big_url", paramString);
      paramActionSheetItem.putExtra("forward_extra", paramString);
      arum.a((Activity)localObject, paramActionSheetItem, 1, -1);
      return;
    case 3: 
      paramActionSheetItem = bizt.a();
      paramBitmap = ((BaseActivity)localObject).getAppInterface();
      paramActionSheetItem.a = paramBitmap.getAccount();
      paramActionSheetItem.b = paramBitmap.getDisplayName(0, paramBitmap.getCurrentAccountUin(), null);
      bizm.a((Activity)localObject, paramActionSheetItem, paramString, ((BaseActivity)localObject).getString(2131692302), ((BaseActivity)localObject).getString(2131698517, new Object[] { "" }), 2);
      return;
    case 9: 
    case 10: 
      paramActionSheetItem = this.jdField_a_of_type_Arkl.c();
      localObject = WXShareHelper.a();
      if (i == 9) {}
      for (i = 0;; i = 1)
      {
        ((WXShareHelper)localObject).a(paramString, paramBitmap, i, true, paramActionSheetItem);
        return;
      }
    case 39: 
      paramActionSheetItem = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      paramActionSheetItem.setData(Uri.parse("file://" + paramString));
      ((BaseActivity)localObject).sendBroadcast(paramActionSheetItem);
      arkn.a(2, ((BaseActivity)localObject).getString(2131717619, new Object[] { paramString }), true);
      return;
    }
    paramBitmap = new Bundle();
    paramBitmap.putInt("key_req", ForwardRecentActivity.f);
    paramBitmap.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
    paramBitmap.putString("key_direct_show_uin", paramActionSheetItem.uin);
    paramActionSheetItem = new Intent();
    paramActionSheetItem.putExtra("isFromShare", true);
    paramActionSheetItem.putExtra("forward_type", 1);
    paramActionSheetItem.putExtra("forward_filepath", paramString);
    paramActionSheetItem.putExtra("forward_thumb", paramString);
    paramActionSheetItem.putExtra("forward_urldrawable_big_url", paramString);
    paramActionSheetItem.putExtra("forward_extra", paramString);
    paramActionSheetItem.putExtras(paramBitmap);
    arum.a((Activity)localObject, paramActionSheetItem, ForwardRecentTranslucentActivity.class, 1, -1, "");
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3)) {
      throw new IllegalArgumentException("handleSaveBitmap: args are invalid");
    }
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)paramArrayOfObject[0];
    Bitmap localBitmap = (Bitmap)paramArrayOfObject[1];
    if (((Boolean)paramArrayOfObject[2]).booleanValue()) {}
    for (paramArrayOfObject = a(localBitmap);; paramArrayOfObject = b(localBitmap))
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = new Object[] { localActionSheetItem, localBitmap, paramArrayOfObject };
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
  }
  
  /* Error */
  private static String b(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_2
    //   7: istore_1
    //   8: aload_0
    //   9: ifnull +365 -> 374
    //   12: aload_0
    //   13: invokevirtual 455	android/graphics/Bitmap:isRecycled	()Z
    //   16: ifne +358 -> 374
    //   19: new 457	com/tencent/mm/vfs/VFSFile
    //   22: dup
    //   23: getstatic 462	aljq:bd	Ljava/lang/String;
    //   26: invokespecial 463	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: aload_3
    //   31: invokevirtual 466	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   34: pop
    //   35: aload_3
    //   36: invokevirtual 469	com/tencent/mm/vfs/VFSFile:canWrite	()Z
    //   39: ifeq +335 -> 374
    //   42: invokestatic 236	java/lang/System:currentTimeMillis	()J
    //   45: invokestatic 473	java/lang/Long:toString	(J)Ljava/lang/String;
    //   48: astore_3
    //   49: new 457	com/tencent/mm/vfs/VFSFile
    //   52: dup
    //   53: new 169	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   60: getstatic 462	aljq:bd	Ljava/lang/String;
    //   63: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 475
    //   69: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokestatic 236	java/lang/System:currentTimeMillis	()J
    //   75: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   78: ldc_w 477
    //   81: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 463	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   90: astore 5
    //   92: aload 5
    //   94: invokevirtual 480	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   97: ifeq +68 -> 165
    //   100: iload_1
    //   101: ldc_w 481
    //   104: if_icmpge +61 -> 165
    //   107: new 457	com/tencent/mm/vfs/VFSFile
    //   110: dup
    //   111: new 169	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   118: getstatic 462	aljq:bd	Ljava/lang/String;
    //   121: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc_w 475
    //   127: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc_w 483
    //   137: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload_1
    //   141: invokevirtual 486	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: ldc_w 488
    //   147: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokespecial 463	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   156: astore 5
    //   158: iload_1
    //   159: iconst_1
    //   160: iadd
    //   161: istore_1
    //   162: goto -70 -> 92
    //   165: new 490	java/io/BufferedOutputStream
    //   168: dup
    //   169: new 492	com/tencent/mm/vfs/VFSFileOutputStream
    //   172: dup
    //   173: aload 5
    //   175: invokespecial 495	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   178: invokespecial 498	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   181: astore_3
    //   182: aload_3
    //   183: astore 4
    //   185: aload_0
    //   186: getstatic 504	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   189: bipush 100
    //   191: aload_3
    //   192: invokevirtual 508	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   195: istore_2
    //   196: aload_3
    //   197: ifnull +172 -> 369
    //   200: aload_3
    //   201: invokevirtual 511	java/io/BufferedOutputStream:close	()V
    //   204: aconst_null
    //   205: astore_0
    //   206: iload_2
    //   207: ifne +120 -> 327
    //   210: aload 5
    //   212: invokevirtual 480	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   215: ifeq +112 -> 327
    //   218: aload 5
    //   220: invokevirtual 514	com/tencent/mm/vfs/VFSFile:delete	()Z
    //   223: pop
    //   224: aload_0
    //   225: areturn
    //   226: astore_0
    //   227: aconst_null
    //   228: astore_0
    //   229: goto -23 -> 206
    //   232: astore_3
    //   233: aload 6
    //   235: astore_0
    //   236: aload_0
    //   237: astore 4
    //   239: ldc 218
    //   241: iconst_2
    //   242: ldc_w 516
    //   245: aload_3
    //   246: invokestatic 251	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   249: ldc 253
    //   251: astore_3
    //   252: aload_0
    //   253: ifnull +109 -> 362
    //   256: aload_0
    //   257: invokevirtual 511	java/io/BufferedOutputStream:close	()V
    //   260: iconst_0
    //   261: istore_2
    //   262: aload_3
    //   263: astore_0
    //   264: goto -58 -> 206
    //   267: astore_0
    //   268: iconst_0
    //   269: istore_2
    //   270: aload_3
    //   271: astore_0
    //   272: goto -66 -> 206
    //   275: astore_0
    //   276: aconst_null
    //   277: astore_3
    //   278: aload_3
    //   279: astore 4
    //   281: ldc 218
    //   283: iconst_2
    //   284: ldc_w 516
    //   287: aload_0
    //   288: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   291: aload_3
    //   292: ifnull +63 -> 355
    //   295: aload_3
    //   296: invokevirtual 511	java/io/BufferedOutputStream:close	()V
    //   299: aconst_null
    //   300: astore_0
    //   301: iconst_0
    //   302: istore_2
    //   303: goto -97 -> 206
    //   306: astore_0
    //   307: aconst_null
    //   308: astore_0
    //   309: iconst_0
    //   310: istore_2
    //   311: goto -105 -> 206
    //   314: astore_0
    //   315: aload 4
    //   317: ifnull +8 -> 325
    //   320: aload 4
    //   322: invokevirtual 511	java/io/BufferedOutputStream:close	()V
    //   325: aload_0
    //   326: athrow
    //   327: aload 5
    //   329: invokevirtual 519	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   332: areturn
    //   333: astore_3
    //   334: goto -9 -> 325
    //   337: astore_0
    //   338: goto -23 -> 315
    //   341: astore_0
    //   342: goto -64 -> 278
    //   345: astore 4
    //   347: aload_3
    //   348: astore_0
    //   349: aload 4
    //   351: astore_3
    //   352: goto -116 -> 236
    //   355: aconst_null
    //   356: astore_0
    //   357: iconst_0
    //   358: istore_2
    //   359: goto -153 -> 206
    //   362: iconst_0
    //   363: istore_2
    //   364: aload_3
    //   365: astore_0
    //   366: goto -160 -> 206
    //   369: aconst_null
    //   370: astore_0
    //   371: goto -165 -> 206
    //   374: aconst_null
    //   375: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	paramBitmap	Bitmap
    //   7	155	1	i	int
    //   195	169	2	bool	boolean
    //   29	172	3	localObject1	Object
    //   232	14	3	localOutOfMemoryError1	OutOfMemoryError
    //   251	45	3	str	String
    //   333	15	3	localThrowable	Throwable
    //   351	14	3	localOutOfMemoryError2	OutOfMemoryError
    //   1	320	4	localObject2	Object
    //   345	5	4	localOutOfMemoryError3	OutOfMemoryError
    //   90	238	5	localVFSFile	com.tencent.mm.vfs.VFSFile
    //   4	230	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   200	204	226	java/lang/Throwable
    //   165	182	232	java/lang/OutOfMemoryError
    //   256	260	267	java/lang/Throwable
    //   165	182	275	java/lang/Throwable
    //   295	299	306	java/lang/Throwable
    //   165	182	314	finally
    //   239	249	314	finally
    //   320	325	333	java/lang/Throwable
    //   185	196	337	finally
    //   281	291	337	finally
    //   185	196	341	java/lang/Throwable
    //   185	196	345	java/lang/OutOfMemoryError
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3)) {
      throw new IllegalArgumentException("handleShareRelay: args are invalid");
    }
    a((ShareActionSheetBuilder.ActionSheetItem)paramArrayOfObject[0], (Bitmap)paramArrayOfObject[1], (String)paramArrayOfObject[2]);
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem> a(Context paramContext)
  {
    paramContext = new ArrayList();
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    b();
    if (this.jdField_a_of_type_Bepp != null)
    {
      this.jdField_a_of_type_Bepp.dismiss();
      this.jdField_a_of_type_Bepp = null;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.b.removeCallbacksAndMessages(null);
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    boolean bool = true;
    if (paramActionSheetItem == null) {}
    int i;
    do
    {
      do
      {
        return;
        i = paramActionSheetItem.action;
        if ((i == 39) || (bdee.d(this.jdField_a_of_type_Arkl.a()))) {
          break;
        }
        arkn.a(0, 2131692397, false);
      } while (!QLog.isColorLevel());
      QLog.i("WeiyunShareQrController<FileAssistant>", 2, "toShare: net is not supported");
      return;
    } while ((i != 2) && (i != 3) && (i != 9) && (i != 10) && (i != 72) && (i != 39));
    if (this.jdField_a_of_type_Bepp == null)
    {
      this.jdField_a_of_type_Bepp = new bepp(this.jdField_a_of_type_Arkl.a());
      this.jdField_a_of_type_Bepp.c(2131695088);
    }
    if (!this.jdField_a_of_type_Bepp.isShowing()) {
      this.jdField_a_of_type_Bepp.show();
    }
    Message localMessage = new Message();
    localMessage.what = 1;
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (i != 39) {}
    for (;;)
    {
      localMessage.obj = new Object[] { paramActionSheetItem, localBitmap, Boolean.valueOf(bool) };
      this.b.sendMessage(localMessage);
      return;
      bool = false;
    }
  }
  
  public boolean a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    paramBitmap = a(paramBitmap, paramInt, paramString);
    if (paramBitmap == null)
    {
      arkn.a(1, BaseApplicationImpl.sApplication.getResources().getString(2131698511, new Object[] { Integer.valueOf(-2) }), true);
      return false;
    }
    this.jdField_a_of_type_Arkl.a(paramBitmap);
    if (paramBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap) {
      b();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    return true;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem> b(Context paramContext)
  {
    paramContext = new ArrayList();
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
    return paramContext;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      a((Object[])paramMessage.obj);
      continue;
      b((Object[])paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arks
 * JD-Core Version:    0.7.0.1
 */