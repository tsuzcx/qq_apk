import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class bncg
  extends AsyncTask<Void, Void, Void>
{
  double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<PeakActivity> jdField_a_of_type_JavaLangRefWeakReference;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<AppInterface> jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  
  public bncg(PeakActivity paramPeakActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPeakActivity);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
  }
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  private String a(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("mini_launch_ae_tag", 0).getString("mini_launch_ae_app_id", "");
    }
    return "";
  }
  
  private String a(PublishVideoEntry paramPublishVideoEntry, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return null;
    }
    Object localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    for (;;)
    {
      try
      {
        str = dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils.a(paramPublishVideoEntry.mLocalRawVideoDir);
        File localFile = new File(str);
        localFile.getParentFile().mkdirs();
        localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2130845526);
        if ((TextUtils.isEmpty(paramPublishVideoEntry.doodlePath)) || (!paramBoolean)) {
          break label422;
        }
        i = 1;
        if (i != 0)
        {
          paramPublishVideoEntry = BitmapFactory.decodeFile(paramPublishVideoEntry.doodlePath);
          localObject2 = Bitmap.createScaledBitmap(paramPublishVideoEntry, paramInt1, paramInt2, true);
          if (paramPublishVideoEntry != localObject2) {
            paramPublishVideoEntry.recycle();
          }
          localBitmap = Bitmap.createBitmap(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, null);
          if (paramInt1 == 576) {
            break label428;
          }
          f = paramInt1 / 576.0F;
          paramPublishVideoEntry = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(((Bitmap)localObject1).getWidth() * f), (int)(f * ((Bitmap)localObject1).getHeight()), true);
          localCanvas.drawBitmap(paramPublishVideoEntry, 20.0F, ((Bitmap)localObject2).getHeight() - 20 - paramPublishVideoEntry.getHeight(), null);
          paramPublishVideoEntry.recycle();
          paramPublishVideoEntry = localBitmap;
          if (xmn.a(paramPublishVideoEntry, Bitmap.CompressFormat.PNG, 100, localFile.getAbsolutePath())) {
            continue;
          }
          xmn.a(paramPublishVideoEntry);
          if (((Bitmap)localObject1).isRecycled()) {
            break label420;
          }
          xmn.a((Bitmap)localObject1);
          break label420;
        }
        localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        localObject2 = new Canvas(localBitmap);
        if (paramInt1 == 576) {
          continue;
        }
        float f = paramInt1 / 576.0F;
        paramPublishVideoEntry = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(((Bitmap)localObject1).getWidth() * f), (int)(f * ((Bitmap)localObject1).getHeight()), true);
      }
      catch (OutOfMemoryError paramPublishVideoEntry)
      {
        String str;
        Object localObject2;
        Bitmap localBitmap;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SaveVideoActivity", 2, paramPublishVideoEntry, new Object[0]);
        return null;
        paramPublishVideoEntry = (PublishVideoEntry)localObject1;
        continue;
        xmn.a(paramPublishVideoEntry);
        if (((Bitmap)localObject1).isRecycled()) {
          continue;
        }
        xmn.a((Bitmap)localObject1);
        return str;
      }
      catch (Exception paramPublishVideoEntry)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SaveVideoActivity", 2, paramPublishVideoEntry, new Object[0]);
        continue;
      }
      ((Canvas)localObject2).drawBitmap(paramPublishVideoEntry, 20.0F, paramInt2 - 20 - paramPublishVideoEntry.getHeight(), null);
      paramPublishVideoEntry.recycle();
      paramPublishVideoEntry = localBitmap;
      continue;
      label420:
      return null;
      label422:
      int i = 0;
      continue;
      label428:
      paramPublishVideoEntry = (PublishVideoEntry)localObject1;
    }
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {}
    PeakActivity localPeakActivity;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
        } while (a());
        localPeakActivity = (PeakActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        localObject1 = (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        localObject2 = localPeakActivity.getIntent();
      } while (localObject2 == null);
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject2).getStringExtra("fakeId");
      localObject2 = SaveVideoActivity.a((AppInterface)localObject1, this.jdField_a_of_type_JavaLangString);
      if (localObject2 == null)
      {
        localPeakActivity.setResult(1, localPeakActivity.getIntent());
        localPeakActivity.finish();
        return;
      }
    } while (a());
    Object localObject1 = ((PublishVideoEntry)localObject2).mLocalRawVideoDir;
    Object localObject3 = new File(((PublishVideoEntry)localObject2).mLocalRawVideoDir);
    if (((File)localObject3).isFile()) {
      localObject1 = ((File)localObject3).getParent();
    }
    localObject1 = dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils.a(new File((String)localObject1));
    if (localObject1 != null)
    {
      localObject3 = new File((String)localObject1).getParent();
      if (localObject3 != null) {
        xmx.a((String)localObject3);
      }
    }
    new uku().a((PublishVideoEntry)localObject2, (String)localObject1, false, true, new bnch(this, localPeakActivity, (String)localObject1, null, (PublishVideoEntry)localObject2));
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {}
    while (new File(this.jdField_b_of_type_JavaLangString).exists()) {
      return;
    }
  }
  
  private void a(int paramInt, PublishVideoEntry paramPublishVideoEntry)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (!((PeakActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isFinishing()))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      SaveVideoActivity.a((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), paramPublishVideoEntry);
      localActivity.setResult(a(paramInt), localActivity.getIntent());
      localActivity.finish();
      if (a(paramInt) == -1) {
        a(this.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(PeakActivity paramPeakActivity, String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry)
  {
    this.jdField_b_of_type_JavaLangString = com.tencent.mobileqq.shortvideo.ShortVideoUtils.c();
    if (SaveVideoActivity.a() == null) {
      SaveVideoActivity.a(xot.a(paramPeakActivity.getApplicationContext()));
    }
    if (SaveVideoActivity.a().a()) {
      if (QLog.isColorLevel()) {
        QLog.d("SaveVideoActivity", 2, "generate files mFFmpeg is running!");
      }
    }
    do
    {
      return;
      try
      {
        if (bkwm.e(paramPeakActivity.getIntent()))
        {
          this.jdField_b_of_type_JavaLangString = MiniAppFileManager.getInstance().getTmpPathFromOut(paramString1, a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()));
          paramPeakActivity = MiniAppFileManager.getInstance().getTmpPathFromOut(paramPublishVideoEntry.thumbPath, a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()));
          paramPublishVideoEntry.miniThumbPath = paramPeakActivity;
          bdcs.d(paramPublishVideoEntry.thumbPath, paramPeakActivity);
        }
        paramPeakActivity = new bncj(this, paramPublishVideoEntry, paramString1, this.jdField_b_of_type_JavaLangString);
        SaveVideoActivity.a().a(this.jdField_b_of_type_JavaLangString);
        SaveVideoActivity.a().a(paramString2, paramString1, this.jdField_b_of_type_JavaLangString, paramPublishVideoEntry.videoWidth, paramPublishVideoEntry.videoHeight, paramPeakActivity);
        return;
      }
      catch (Exception paramPeakActivity) {}
    } while (!QLog.isColorLevel());
    QLog.d("SaveVideoActivity", 2, "generate files save alum:" + paramPeakActivity);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)) {
        a(0, SaveVideoActivity.a((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaLangString));
      }
      return true;
    }
    return false;
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	bncg:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 73	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: ifnull +13 -> 20
    //   10: aload_0
    //   11: getfield 38	bncg:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   14: invokevirtual 73	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: aload_0
    //   22: invokespecial 193	bncg:a	()Z
    //   25: ifne -5 -> 20
    //   28: aload_0
    //   29: getfield 36	bncg:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   32: invokevirtual 73	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   35: checkcast 195	com/tencent/mobileqq/activity/aio/photo/PeakActivity
    //   38: astore 13
    //   40: aload_0
    //   41: getfield 38	bncg:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   44: invokevirtual 73	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   47: checkcast 197	com/tencent/common/app/AppInterface
    //   50: astore 12
    //   52: aload 13
    //   54: invokevirtual 201	com/tencent/mobileqq/activity/aio/photo/PeakActivity:getIntent	()Landroid/content/Intent;
    //   57: astore 11
    //   59: aload 11
    //   61: ifnull -41 -> 20
    //   64: aload_0
    //   65: aload 11
    //   67: ldc 203
    //   69: invokevirtual 208	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   72: putfield 210	bncg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   75: aload 12
    //   77: aload_0
    //   78: getfield 210	bncg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   81: invokestatic 215	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   84: astore 14
    //   86: aload 14
    //   88: ifnonnull +20 -> 108
    //   91: aload 13
    //   93: iconst_1
    //   94: aload 13
    //   96: invokevirtual 201	com/tencent/mobileqq/activity/aio/photo/PeakActivity:getIntent	()Landroid/content/Intent;
    //   99: invokevirtual 219	com/tencent/mobileqq/activity/aio/photo/PeakActivity:setResult	(ILandroid/content/Intent;)V
    //   102: aload 13
    //   104: invokevirtual 222	com/tencent/mobileqq/activity/aio/photo/PeakActivity:finish	()V
    //   107: return
    //   108: aload 11
    //   110: ldc_w 370
    //   113: iconst_m1
    //   114: invokevirtual 374	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   117: bipush 22
    //   119: if_icmpne +63 -> 182
    //   122: iconst_1
    //   123: istore_1
    //   124: aconst_null
    //   125: astore 11
    //   127: aload_0
    //   128: getfield 376	bncg:jdField_b_of_type_Boolean	Z
    //   131: ifeq +62 -> 193
    //   134: aload 14
    //   136: getfield 340	com/tencent/biz/qqstory/database/PublishVideoEntry:videoWidth	I
    //   139: istore_2
    //   140: aload 14
    //   142: getfield 343	com/tencent/biz/qqstory/database/PublishVideoEntry:videoHeight	I
    //   145: istore_3
    //   146: iload_1
    //   147: ifne +40 -> 187
    //   150: iconst_1
    //   151: istore 4
    //   153: aload_0
    //   154: aload 14
    //   156: iload_2
    //   157: iload_3
    //   158: iload 4
    //   160: invokespecial 378	bncg:a	(Lcom/tencent/biz/qqstory/database/PublishVideoEntry;IIZ)Ljava/lang/String;
    //   163: astore 12
    //   165: aload 12
    //   167: astore 11
    //   169: aload 12
    //   171: ifnonnull +22 -> 193
    //   174: aload_0
    //   175: iconst_1
    //   176: aload 14
    //   178: invokespecial 273	bncg:a	(ILcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   181: return
    //   182: iconst_0
    //   183: istore_1
    //   184: goto -60 -> 124
    //   187: iconst_0
    //   188: istore 4
    //   190: goto -37 -> 153
    //   193: aload_0
    //   194: invokespecial 193	bncg:a	()Z
    //   197: ifne -177 -> 20
    //   200: invokestatic 383	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   203: astore 12
    //   205: invokestatic 388	bnmw:a	()Lbnmw;
    //   208: invokevirtual 391	bnmw:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   211: invokevirtual 396	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   214: pop
    //   215: ldc 183
    //   217: ldc_w 398
    //   220: invokestatic 403	wsv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_0
    //   224: invokespecial 193	bncg:a	()Z
    //   227: ifne -207 -> 20
    //   230: invokestatic 407	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   233: ifeq +176 -> 409
    //   236: lconst_0
    //   237: lstore 7
    //   239: aload 12
    //   241: getfield 408	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   244: astore 15
    //   246: aload 15
    //   248: monitorenter
    //   249: aload 12
    //   251: getfield 408	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   254: invokevirtual 44	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   257: istore 4
    //   259: lload 7
    //   261: lstore 5
    //   263: iload 4
    //   265: ifne +85 -> 350
    //   268: lload 7
    //   270: lstore 5
    //   272: ldc 183
    //   274: ldc_w 410
    //   277: invokestatic 403	wsv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: lload 7
    //   282: lstore 5
    //   284: invokestatic 416	android/os/SystemClock:elapsedRealtime	()J
    //   287: lstore 9
    //   289: lload 7
    //   291: lstore 5
    //   293: aload 12
    //   295: getfield 408	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   298: ldc2_w 417
    //   301: invokevirtual 422	java/lang/Object:wait	(J)V
    //   304: lload 7
    //   306: lstore 5
    //   308: invokestatic 416	android/os/SystemClock:elapsedRealtime	()J
    //   311: lload 9
    //   313: lsub
    //   314: lstore 7
    //   316: lload 7
    //   318: lstore 5
    //   320: ldc 183
    //   322: new 348	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 349	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 424
    //   332: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: lload 7
    //   337: invokevirtual 427	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   340: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 403	wsv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: lload 7
    //   348: lstore 5
    //   350: aload 15
    //   352: monitorexit
    //   353: ldc 183
    //   355: ldc_w 429
    //   358: invokestatic 403	wsv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: lload 5
    //   363: ldc2_w 430
    //   366: lcmp
    //   367: ifge +42 -> 409
    //   370: bipush 20
    //   372: lload 5
    //   374: l2i
    //   375: isub
    //   376: istore_2
    //   377: iload_2
    //   378: istore_1
    //   379: iload_2
    //   380: bipush 10
    //   382: if_icmpge +6 -> 388
    //   385: bipush 10
    //   387: istore_1
    //   388: ldc 183
    //   390: ldc_w 433
    //   393: iload_1
    //   394: invokestatic 439	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: invokestatic 442	wsv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   400: iload_1
    //   401: i2l
    //   402: lstore 5
    //   404: lload 5
    //   406: invokestatic 447	java/lang/Thread:sleep	(J)V
    //   409: aload_0
    //   410: invokespecial 193	bncg:a	()Z
    //   413: ifne -393 -> 20
    //   416: aload 14
    //   418: getfield 450	com/tencent/biz/qqstory/database/PublishVideoEntry:saveMode	I
    //   421: ifeq +11 -> 432
    //   424: aload 14
    //   426: getfield 450	com/tencent/biz/qqstory/database/PublishVideoEntry:saveMode	I
    //   429: putstatic 455	azds:J	I
    //   432: aload 14
    //   434: getfield 458	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicPath	Ljava/lang/String;
    //   437: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   440: ifne +347 -> 787
    //   443: aload 14
    //   445: getfield 458	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicPath	Ljava/lang/String;
    //   448: invokestatic 459	bdcs:a	(Ljava/lang/String;)Z
    //   451: ifeq +336 -> 787
    //   454: iconst_1
    //   455: istore_1
    //   456: new 85	java/io/File
    //   459: dup
    //   460: aload 14
    //   462: getfield 78	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   465: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   468: astore 15
    //   470: aload 15
    //   472: invokestatic 231	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/io/File;)Ljava/lang/String;
    //   475: astore 12
    //   477: aload 12
    //   479: ifnull +28 -> 507
    //   482: new 85	java/io/File
    //   485: dup
    //   486: aload 12
    //   488: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   491: invokevirtual 228	java/io/File:getParent	()Ljava/lang/String;
    //   494: astore 16
    //   496: aload 16
    //   498: ifnull +9 -> 507
    //   501: aload 16
    //   503: invokestatic 236	xmx:a	(Ljava/lang/String;)Z
    //   506: pop
    //   507: invokestatic 464	java/lang/System:currentTimeMillis	()J
    //   510: lstore 5
    //   512: new 466	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread
    //   515: dup
    //   516: aconst_null
    //   517: aconst_null
    //   518: aload 14
    //   520: getfield 78	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   523: aload 12
    //   525: aconst_null
    //   526: invokespecial 469	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:<init>	(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   529: astore 16
    //   531: aload 16
    //   533: iconst_0
    //   534: invokevirtual 471	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	(Z)V
    //   537: aload 16
    //   539: iconst_0
    //   540: invokevirtual 473	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:b	(Z)V
    //   543: aload 16
    //   545: aload 14
    //   547: getfield 476	com/tencent/biz/qqstory/database/PublishVideoEntry:isMuteRecordVoice	Z
    //   550: invokevirtual 478	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:c	(Z)V
    //   553: aload 14
    //   555: getfield 482	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicMask	[B
    //   558: ifnull +18 -> 576
    //   561: aload 16
    //   563: aload 14
    //   565: getfield 482	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicMask	[B
    //   568: aload 14
    //   570: getfield 485	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicSize	I
    //   573: invokevirtual 488	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	([BI)V
    //   576: aload 16
    //   578: invokevirtual 491	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:run	()V
    //   581: aload 16
    //   583: getfield 492	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:jdField_a_of_type_Int	I
    //   586: istore_2
    //   587: aload_0
    //   588: invokestatic 464	java/lang/System:currentTimeMillis	()J
    //   591: lload 5
    //   593: lsub
    //   594: l2d
    //   595: ldc2_w 493
    //   598: ddiv
    //   599: putfield 496	bncg:jdField_a_of_type_Double	D
    //   602: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   605: ifeq +49 -> 654
    //   608: ldc 183
    //   610: iconst_2
    //   611: new 348	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 349	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 498
    //   621: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokestatic 464	java/lang/System:currentTimeMillis	()J
    //   627: lload 5
    //   629: lsub
    //   630: l2d
    //   631: ldc2_w 493
    //   634: ddiv
    //   635: invokevirtual 501	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   638: ldc_w 503
    //   641: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: iload_2
    //   645: invokevirtual 506	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   648: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 303	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   654: aload_0
    //   655: invokespecial 193	bncg:a	()Z
    //   658: ifne -638 -> 20
    //   661: iload_2
    //   662: ifeq +130 -> 792
    //   665: aload 13
    //   667: invokevirtual 201	com/tencent/mobileqq/activity/aio/photo/PeakActivity:getIntent	()Landroid/content/Intent;
    //   670: ldc_w 508
    //   673: iload_2
    //   674: invokevirtual 512	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   677: pop
    //   678: aload_0
    //   679: iconst_1
    //   680: aload 14
    //   682: invokespecial 273	bncg:a	(ILcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   685: return
    //   686: astore 15
    //   688: ldc 183
    //   690: ldc_w 514
    //   693: aload 15
    //   695: invokestatic 517	wsv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   698: invokestatic 407	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   701: ifeq -478 -> 223
    //   704: aload 12
    //   706: getfield 408	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   709: astore 15
    //   711: aload 15
    //   713: monitorenter
    //   714: aload 12
    //   716: getfield 408	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   719: iconst_1
    //   720: invokevirtual 520	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   723: aload 12
    //   725: getfield 408	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   728: invokevirtual 523	java/lang/Object:notifyAll	()V
    //   731: aload 15
    //   733: monitorexit
    //   734: goto -511 -> 223
    //   737: astore 11
    //   739: aload 15
    //   741: monitorexit
    //   742: aload 11
    //   744: athrow
    //   745: astore 12
    //   747: ldc 183
    //   749: new 348	java/lang/StringBuilder
    //   752: dup
    //   753: invokespecial 349	java/lang/StringBuilder:<init>	()V
    //   756: ldc_w 525
    //   759: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload 12
    //   764: invokevirtual 528	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   767: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: invokestatic 403	wsv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   776: goto -426 -> 350
    //   779: astore 11
    //   781: aload 15
    //   783: monitorexit
    //   784: aload 11
    //   786: athrow
    //   787: iconst_0
    //   788: istore_1
    //   789: goto -333 -> 456
    //   792: iload_1
    //   793: ifeq +74 -> 867
    //   796: aload 15
    //   798: invokestatic 530	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:b	(Ljava/io/File;)Ljava/lang/String;
    //   801: astore 15
    //   803: aload 12
    //   805: invokestatic 533	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:b	(Ljava/lang/String;)J
    //   808: lstore 5
    //   810: iconst_1
    //   811: aload 13
    //   813: aload 12
    //   815: aload 14
    //   817: getfield 458	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicPath	Ljava/lang/String;
    //   820: aload 14
    //   822: getfield 536	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicOffset	I
    //   825: lload 5
    //   827: l2i
    //   828: aload 15
    //   830: new 538	bnci
    //   833: dup
    //   834: aload_0
    //   835: aload 12
    //   837: aload 13
    //   839: aload 15
    //   841: aload 11
    //   843: aload 14
    //   845: invokespecial 541	bnci:<init>	(Lbncg;Ljava/lang/String;Lcom/tencent/mobileqq/activity/aio/photo/PeakActivity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   848: invokestatic 546	xpc:a	(ZLandroid/content/Context;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lxos;)V
    //   851: return
    //   852: astore 11
    //   854: aload 11
    //   856: invokevirtual 549	java/lang/Exception:printStackTrace	()V
    //   859: aload_0
    //   860: iconst_1
    //   861: aload 14
    //   863: invokespecial 273	bncg:a	(ILcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   866: return
    //   867: aload_0
    //   868: aload 13
    //   870: aload 12
    //   872: aload 11
    //   874: aload 14
    //   876: invokespecial 276	bncg:a	(Lcom/tencent/mobileqq/activity/aio/photo/PeakActivity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   879: return
    //   880: astore 12
    //   882: goto -473 -> 409
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	885	0	this	bncg
    //   123	670	1	i	int
    //   139	535	2	j	int
    //   145	13	3	k	int
    //   151	113	4	bool	boolean
    //   261	565	5	l1	long
    //   237	110	7	l2	long
    //   287	25	9	l3	long
    //   57	111	11	localObject1	Object
    //   737	6	11	localObject2	Object
    //   779	63	11	str	String
    //   852	21	11	localException	Exception
    //   50	674	12	localObject3	Object
    //   745	126	12	localInterruptedException1	java.lang.InterruptedException
    //   880	1	12	localInterruptedException2	java.lang.InterruptedException
    //   38	831	13	localPeakActivity	PeakActivity
    //   84	791	14	localPublishVideoEntry	PublishVideoEntry
    //   244	227	15	localObject4	Object
    //   686	8	15	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   494	88	16	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   205	223	686	java/lang/UnsatisfiedLinkError
    //   714	734	737	finally
    //   739	742	737	finally
    //   272	280	745	java/lang/InterruptedException
    //   284	289	745	java/lang/InterruptedException
    //   293	304	745	java/lang/InterruptedException
    //   308	316	745	java/lang/InterruptedException
    //   320	346	745	java/lang/InterruptedException
    //   249	259	779	finally
    //   272	280	779	finally
    //   284	289	779	finally
    //   293	304	779	finally
    //   308	316	779	finally
    //   320	346	779	finally
    //   350	353	779	finally
    //   747	776	779	finally
    //   781	784	779	finally
    //   796	851	852	java/lang/Exception
    //   404	409	880	java/lang/InterruptedException
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
    for (;;)
    {
      return null;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncg
 * JD-Core Version:    0.7.0.1
 */