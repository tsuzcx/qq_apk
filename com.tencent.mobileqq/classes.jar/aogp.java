import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;
import dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo;
import dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import dov.com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class aogp
  extends AsyncTask
{
  double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  private String e;
  
  public aogp(PeakActivity paramPeakActivity, AppInterface paramAppInterface)
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
  
  private int a(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry)
  {
    long l = System.currentTimeMillis();
    int i = new MergeEditVideo().a(paramString1, paramString2, new MergeEditVideo.EditParam(CodecParam.r, paramPublishVideoEntry));
    a("[videoSynthesis]generate files|first step cost:" + (System.currentTimeMillis() - l) / 1000.0D, null);
    return i;
  }
  
  private String a(PublishVideoEntry paramPublishVideoEntry, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return null;
    }
    Object localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    for (;;)
    {
      try
      {
        str = ShortVideoUtils.b(paramPublishVideoEntry.mLocalRawVideoDir);
        File localFile = new File(str);
        localFile.getParentFile().mkdirs();
        localObject1 = BitmapFactory.decodeResource(((Context)localObject1).getResources(), 2130843253);
        if (TextUtils.isEmpty(paramPublishVideoEntry.doodlePath)) {
          break label417;
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
            break label423;
          }
          f = paramInt1 / 576.0F;
          paramPublishVideoEntry = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(((Bitmap)localObject1).getWidth() * f), (int)(f * ((Bitmap)localObject1).getHeight()), true);
          localCanvas.drawBitmap(paramPublishVideoEntry, 20.0F, ((Bitmap)localObject2).getHeight() - 20 - paramPublishVideoEntry.getHeight(), null);
          paramPublishVideoEntry.recycle();
          paramPublishVideoEntry = localBitmap;
          if (BitmapUtils.a(paramPublishVideoEntry, Bitmap.CompressFormat.PNG, 100, localFile.getAbsolutePath())) {
            continue;
          }
          BitmapUtils.a(paramPublishVideoEntry);
          if (((Bitmap)localObject1).isRecycled()) {
            break label415;
          }
          BitmapUtils.a((Bitmap)localObject1);
          break label415;
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
        BitmapUtils.a(paramPublishVideoEntry);
        if (((Bitmap)localObject1).isRecycled()) {
          continue;
        }
        BitmapUtils.a((Bitmap)localObject1);
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
      label415:
      return null;
      label417:
      int i = 0;
      continue;
      label423:
      paramPublishVideoEntry = (PublishVideoEntry)localObject1;
    }
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {}
    PeakActivity localPeakActivity;
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
    PublishVideoEntry localPublishVideoEntry = SaveVideoActivity.a((AppInterface)localObject1, this.jdField_a_of_type_JavaLangString);
    if (localPublishVideoEntry == null)
    {
      localPeakActivity.setResult(1, localPeakActivity.getIntent());
      localPeakActivity.finish();
      return;
    }
    Object localObject2 = null;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject1 = a(localPublishVideoEntry, localPublishVideoEntry.videoWidth, localPublishVideoEntry.videoHeight);
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        a(1, localPublishVideoEntry);
        return;
      }
    }
    if (a())
    {
      a(null, null, (String)localObject2);
      return;
    }
    Object localObject3 = localPublishVideoEntry.mLocalRawVideoDir;
    Object localObject1 = new File(localPublishVideoEntry.mLocalRawVideoDir);
    if (((File)localObject1).isFile()) {
      localObject3 = ((File)localObject1).getParent();
    }
    String str = ShortVideoUtils.a((String)localObject3);
    new File(str).mkdirs();
    localObject1 = str + "mc_audio.mp4";
    int i;
    Object localObject4;
    int j;
    if (localPublishVideoEntry.saveMode <= 5)
    {
      i = localPublishVideoEntry.saveMode;
      localObject4 = AudioEncoder.a(null, null, i);
      ((AudioEncoder.AudioData)localObject4).jdField_b_of_type_JavaLangString = ((String)localObject1);
      ((AudioEncoder.AudioData)localObject4).jdField_a_of_type_JavaLangString = this.c;
      j = AudioEncoder.a(this.c);
      if (j == 0) {
        break label620;
      }
      a("checkSourceAudioIsOK: errcode=" + j, null);
      localObject1 = null;
    }
    label779:
    label784:
    label791:
    label929:
    for (;;)
    {
      localObject4 = this.jdField_b_of_type_JavaLangString;
      if (i == 5) {
        localObject4 = this.d;
      }
      for (;;)
      {
        long l1 = System.currentTimeMillis();
        str = str + "mc_video.mp4";
        i = a((String)localObject4, str, localPublishVideoEntry);
        File localFile;
        label448:
        long l2;
        if (i != 0)
        {
          if (i == -1)
          {
            localFile = new File(str);
            if (localFile.exists()) {
              localFile.delete();
            }
            FileUtils.d((String)localObject4, str);
          }
        }
        else
        {
          if ((TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath)) || (!FileUtils.a(localPublishVideoEntry.backgroundMusicPath))) {
            break label779;
          }
          i = 1;
          localFile = new File((String)localObject3);
          localObject4 = ShortVideoUtils.c(localFile);
          l2 = System.currentTimeMillis();
          if ((!localPublishVideoEntry.isMuteRecordVoice) && (i == 0)) {
            break label784;
          }
        }
        for (localObject3 = null;; localObject3 = localObject1)
        {
          j = HwVideoMerge.a(str, (String)localObject3, (String)localObject4, 0);
          a("[HwVideoMerge.merge]cost:" + (System.currentTimeMillis() - l2) / 1000.0D, null);
          this.jdField_a_of_type_Double = ((System.currentTimeMillis() - l1) / 1000.0D);
          if (QLog.isColorLevel()) {
            QLog.d("SaveVideoActivity", 2, "generate files|first step cost:" + (System.currentTimeMillis() - l1) / 1000.0D + " errorCode= " + j);
          }
          if (!a()) {
            break label791;
          }
          a((String)localObject1, str, (String)localObject2);
          return;
          i = 0;
          break;
          label620:
          l1 = System.currentTimeMillis();
          j = AudioEncoder.a((AudioEncoder.AudioData)localObject4);
          a("AudioEncoder.encodeSafely:time=" + (System.currentTimeMillis() - l1) / 1000.0D, null);
          if (j == 0) {
            break label929;
          }
          a("AudioEncoder.encodeSafely: errcode=" + j, null);
          a((String)localObject1, null, (String)localObject2);
          localPeakActivity.getIntent().putExtra("error", j);
          a(1, localPublishVideoEntry);
          return;
          a("videoSynthesis[RESULT_FAIL_VIDEO_MERGE]: errcode=" + i, null);
          a((String)localObject1, str, (String)localObject2);
          localPeakActivity.getIntent().putExtra("error", i);
          a(1, localPublishVideoEntry);
          return;
          i = 0;
          break label448;
        }
        if (j != 0)
        {
          a((String)localObject1, str, (String)localObject2);
          localPeakActivity.getIntent().putExtra("error", j);
          a(1, localPublishVideoEntry);
          return;
        }
        if (i != 0) {}
        for (;;)
        {
          try
          {
            localObject3 = ShortVideoUtils.d(localFile);
            l1 = ShortVideoUtils.b((String)localObject4);
            FFmpegUtils.a(true, localPeakActivity, (String)localObject4, localPublishVideoEntry.backgroundMusicPath, localPublishVideoEntry.backgroundMusicOffset, (int)l1, (String)localObject3, new aogq(this, (String)localObject4, localPeakActivity, (String)localObject3, (String)localObject2, localPublishVideoEntry));
            a((String)localObject1, str, (String)localObject2);
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            a(1, localPublishVideoEntry);
            continue;
          }
          a(localPeakActivity, (String)localObject4, (String)localObject2, localPublishVideoEntry);
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (TextUtils.isEmpty(this.e))) {}
    while (new File(this.e).exists()) {
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
    this.e = ShortVideoUtils.b();
    if (SaveVideoActivity.a() == null) {
      SaveVideoActivity.a(FFmpeg.a(paramPeakActivity.getApplicationContext()));
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
        paramPeakActivity = new aogs(this, paramPublishVideoEntry, paramString1, this.e);
        SaveVideoActivity.a().a(this.e);
        SaveVideoActivity.a().a(paramString2, paramString1, this.e, paramPublishVideoEntry.videoWidth, paramPublishVideoEntry.videoHeight, paramPeakActivity);
        return;
      }
      catch (Exception paramPeakActivity) {}
    } while (!QLog.isColorLevel());
    QLog.d("SaveVideoActivity", 2, "generate files save alum:" + paramPeakActivity);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (!"".equals(paramString1)))
    {
      paramString1 = new File(paramString1);
      if (paramString1.exists()) {
        paramString1.delete();
      }
    }
    if ((paramString2 != null) && (!"".equals(paramString2)))
    {
      paramString1 = new File(paramString2);
      if (paramString1.exists()) {
        paramString1.delete();
      }
    }
    if ((paramString3 != null) && (!"".equals(paramString3))) {}
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d("SavehwVideoActivity", 2, "[@] " + paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("SavehwVideoActivity", 2, "[@] " + paramString);
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
    //   1: getfield 36	aogp:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 104	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: ifnull +13 -> 20
    //   10: aload_0
    //   11: getfield 38	aogp:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   14: invokevirtual 104	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: aload_0
    //   22: invokespecial 224	aogp:a	()Z
    //   25: ifne -5 -> 20
    //   28: aload_0
    //   29: getfield 36	aogp:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   32: invokevirtual 104	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   35: checkcast 226	com/tencent/mobileqq/activity/aio/photo/PeakActivity
    //   38: astore 12
    //   40: aload_0
    //   41: getfield 38	aogp:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   44: invokevirtual 104	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   47: checkcast 228	com/tencent/common/app/AppInterface
    //   50: astore 10
    //   52: aload 12
    //   54: invokevirtual 232	com/tencent/mobileqq/activity/aio/photo/PeakActivity:getIntent	()Landroid/content/Intent;
    //   57: astore 11
    //   59: aload 11
    //   61: ifnull -41 -> 20
    //   64: aload_0
    //   65: aload 11
    //   67: ldc 234
    //   69: invokevirtual 239	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   72: putfield 241	aogp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   75: aload 10
    //   77: aload_0
    //   78: getfield 241	aogp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   81: invokestatic 246	dov/com/tencent/mobileqq/activity/richmedia/SaveVideoActivity:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   84: astore 13
    //   86: aload 13
    //   88: ifnonnull +20 -> 108
    //   91: aload 12
    //   93: iconst_1
    //   94: aload 12
    //   96: invokevirtual 232	com/tencent/mobileqq/activity/aio/photo/PeakActivity:getIntent	()Landroid/content/Intent;
    //   99: invokevirtual 250	com/tencent/mobileqq/activity/aio/photo/PeakActivity:setResult	(ILandroid/content/Intent;)V
    //   102: aload 12
    //   104: invokevirtual 253	com/tencent/mobileqq/activity/aio/photo/PeakActivity:finish	()V
    //   107: return
    //   108: aconst_null
    //   109: astore 10
    //   111: aload_0
    //   112: getfield 255	aogp:jdField_b_of_type_Boolean	Z
    //   115: ifeq +38 -> 153
    //   118: aload_0
    //   119: aload 13
    //   121: aload 13
    //   123: getfield 258	com/tencent/biz/qqstory/database/PublishVideoEntry:videoWidth	I
    //   126: aload 13
    //   128: getfield 261	com/tencent/biz/qqstory/database/PublishVideoEntry:videoHeight	I
    //   131: invokespecial 263	aogp:a	(Lcom/tencent/biz/qqstory/database/PublishVideoEntry;II)Ljava/lang/String;
    //   134: astore 11
    //   136: aload 11
    //   138: astore 10
    //   140: aload 11
    //   142: ifnonnull +11 -> 153
    //   145: aload_0
    //   146: iconst_1
    //   147: aload 13
    //   149: invokespecial 265	aogp:a	(ILcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   152: return
    //   153: aload_0
    //   154: invokespecial 224	aogp:a	()Z
    //   157: ifne -137 -> 20
    //   160: invokestatic 465	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   163: astore 11
    //   165: invokestatic 470	dov/com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Ldov/com/tencent/mobileqq/shortvideo/mediadevice/RecordManager;
    //   168: invokevirtual 473	dov/com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   171: invokevirtual 478	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   174: pop
    //   175: ldc 215
    //   177: ldc_w 480
    //   180: invokestatic 485	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload_0
    //   184: invokespecial 224	aogp:a	()Z
    //   187: ifne -167 -> 20
    //   190: invokestatic 489	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   193: ifeq +165 -> 358
    //   196: lconst_0
    //   197: lstore 5
    //   199: aload 11
    //   201: getfield 490	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   204: astore 14
    //   206: aload 14
    //   208: monitorenter
    //   209: aload 11
    //   211: getfield 490	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   214: invokevirtual 44	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   217: istore 9
    //   219: lload 5
    //   221: lstore_3
    //   222: iload 9
    //   224: ifne +79 -> 303
    //   227: lload 5
    //   229: lstore_3
    //   230: ldc 215
    //   232: ldc_w 492
    //   235: invokestatic 485	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: lload 5
    //   240: lstore_3
    //   241: invokestatic 497	android/os/SystemClock:elapsedRealtime	()J
    //   244: lstore 7
    //   246: lload 5
    //   248: lstore_3
    //   249: aload 11
    //   251: getfield 490	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   254: ldc2_w 498
    //   257: invokevirtual 503	java/lang/Object:wait	(J)V
    //   260: lload 5
    //   262: lstore_3
    //   263: invokestatic 497	android/os/SystemClock:elapsedRealtime	()J
    //   266: lload 7
    //   268: lsub
    //   269: lstore 5
    //   271: lload 5
    //   273: lstore_3
    //   274: ldc 215
    //   276: new 71	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 505
    //   286: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: lload 5
    //   291: invokevirtual 508	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   294: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 485	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: lload 5
    //   302: lstore_3
    //   303: aload 14
    //   305: monitorexit
    //   306: ldc 215
    //   308: ldc_w 510
    //   311: invokestatic 485	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: lload_3
    //   315: ldc2_w 511
    //   318: lcmp
    //   319: ifge +39 -> 358
    //   322: bipush 20
    //   324: lload_3
    //   325: l2i
    //   326: isub
    //   327: istore_2
    //   328: iload_2
    //   329: istore_1
    //   330: iload_2
    //   331: bipush 10
    //   333: if_icmpge +6 -> 339
    //   336: bipush 10
    //   338: istore_1
    //   339: ldc 215
    //   341: ldc_w 514
    //   344: iload_1
    //   345: invokestatic 520	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: invokestatic 523	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   351: iload_1
    //   352: i2l
    //   353: lstore_3
    //   354: lload_3
    //   355: invokestatic 528	java/lang/Thread:sleep	(J)V
    //   358: aload_0
    //   359: invokespecial 224	aogp:a	()Z
    //   362: ifne -342 -> 20
    //   365: aload 13
    //   367: getfield 281	com/tencent/biz/qqstory/database/PublishVideoEntry:saveMode	I
    //   370: ifeq +11 -> 381
    //   373: aload 13
    //   375: getfield 281	com/tencent/biz/qqstory/database/PublishVideoEntry:saveMode	I
    //   378: putstatic 531	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:J	I
    //   381: aload 13
    //   383: getfield 320	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicPath	Ljava/lang/String;
    //   386: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   389: ifne +314 -> 703
    //   392: aload 13
    //   394: getfield 320	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicPath	Ljava/lang/String;
    //   397: invokestatic 323	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   400: ifeq +303 -> 703
    //   403: iconst_1
    //   404: istore_1
    //   405: new 118	java/io/File
    //   408: dup
    //   409: aload 13
    //   411: getfield 111	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   414: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   417: astore 14
    //   419: aload 14
    //   421: invokestatic 326	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:c	(Ljava/io/File;)Ljava/lang/String;
    //   424: astore 11
    //   426: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   429: lstore_3
    //   430: new 533	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread
    //   433: dup
    //   434: aconst_null
    //   435: aconst_null
    //   436: aload 13
    //   438: getfield 111	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   441: aload 11
    //   443: aconst_null
    //   444: invokespecial 536	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:<init>	(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   447: astore 15
    //   449: aload 15
    //   451: iconst_0
    //   452: invokevirtual 538	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	(Z)V
    //   455: aload 15
    //   457: iconst_0
    //   458: invokevirtual 540	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:b	(Z)V
    //   461: aload 15
    //   463: aload 13
    //   465: getfield 329	com/tencent/biz/qqstory/database/PublishVideoEntry:isMuteRecordVoice	Z
    //   468: invokevirtual 542	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:c	(Z)V
    //   471: aload 13
    //   473: getfield 546	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicMask	[B
    //   476: ifnull +18 -> 494
    //   479: aload 15
    //   481: aload 13
    //   483: getfield 546	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicMask	[B
    //   486: aload 13
    //   488: getfield 549	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicSize	I
    //   491: invokevirtual 552	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:a	([BI)V
    //   494: aload 15
    //   496: invokevirtual 555	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:run	()V
    //   499: aload 15
    //   501: getfield 556	dov/com/tencent/mobileqq/shortvideo/mediadevice/EncodeThread:jdField_a_of_type_Int	I
    //   504: istore_2
    //   505: aload_0
    //   506: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   509: lload_3
    //   510: lsub
    //   511: l2d
    //   512: ldc2_w 79
    //   515: ddiv
    //   516: putfield 338	aogp:jdField_a_of_type_Double	D
    //   519: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +48 -> 570
    //   525: ldc 215
    //   527: iconst_2
    //   528: new 71	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   535: ldc_w 340
    //   538: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   544: lload_3
    //   545: lsub
    //   546: l2d
    //   547: ldc2_w 79
    //   550: ddiv
    //   551: invokevirtual 83	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   554: ldc_w 342
    //   557: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: iload_2
    //   561: invokevirtual 300	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   564: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 345	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: aload_0
    //   571: invokespecial 224	aogp:a	()Z
    //   574: ifne -554 -> 20
    //   577: iload_2
    //   578: ifeq +130 -> 708
    //   581: aload 12
    //   583: invokevirtual 232	com/tencent/mobileqq/activity/aio/photo/PeakActivity:getIntent	()Landroid/content/Intent;
    //   586: ldc_w 354
    //   589: iload_2
    //   590: invokevirtual 358	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   593: pop
    //   594: aload_0
    //   595: iconst_1
    //   596: aload 13
    //   598: invokespecial 265	aogp:a	(ILcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   601: return
    //   602: astore 14
    //   604: ldc 215
    //   606: ldc_w 558
    //   609: aload 14
    //   611: invokestatic 561	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   614: invokestatic 489	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   617: ifeq -434 -> 183
    //   620: aload 11
    //   622: getfield 490	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   625: astore 14
    //   627: aload 14
    //   629: monitorenter
    //   630: aload 11
    //   632: getfield 490	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   635: iconst_1
    //   636: invokevirtual 564	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   639: aload 11
    //   641: getfield 490	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   644: invokevirtual 567	java/lang/Object:notifyAll	()V
    //   647: aload 14
    //   649: monitorexit
    //   650: goto -467 -> 183
    //   653: astore 10
    //   655: aload 14
    //   657: monitorexit
    //   658: aload 10
    //   660: athrow
    //   661: astore 11
    //   663: ldc 215
    //   665: new 71	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   672: ldc_w 569
    //   675: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload 11
    //   680: invokevirtual 572	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   683: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 485	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   692: goto -389 -> 303
    //   695: astore 10
    //   697: aload 14
    //   699: monitorexit
    //   700: aload 10
    //   702: athrow
    //   703: iconst_0
    //   704: istore_1
    //   705: goto -300 -> 405
    //   708: iload_1
    //   709: ifeq +72 -> 781
    //   712: aload 14
    //   714: invokestatic 362	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:d	(Ljava/io/File;)Ljava/lang/String;
    //   717: astore 14
    //   719: aload 11
    //   721: invokestatic 365	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:b	(Ljava/lang/String;)J
    //   724: lstore_3
    //   725: iconst_1
    //   726: aload 12
    //   728: aload 11
    //   730: aload 13
    //   732: getfield 320	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicPath	Ljava/lang/String;
    //   735: aload 13
    //   737: getfield 368	com/tencent/biz/qqstory/database/PublishVideoEntry:backgroundMusicOffset	I
    //   740: lload_3
    //   741: l2i
    //   742: aload 14
    //   744: new 574	aogr
    //   747: dup
    //   748: aload_0
    //   749: aload 11
    //   751: aload 12
    //   753: aload 14
    //   755: aload 10
    //   757: aload 13
    //   759: invokespecial 575	aogr:<init>	(Laogp;Ljava/lang/String;Lcom/tencent/mobileqq/activity/aio/photo/PeakActivity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   762: invokestatic 378	com/tencent/biz/qqstory/utils/ffmpeg/FFmpegUtils:a	(ZLandroid/content/Context;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lcom/tencent/biz/qqstory/utils/ffmpeg/ExecuteBinResponseCallback;)V
    //   765: return
    //   766: astore 10
    //   768: aload 10
    //   770: invokevirtual 381	java/lang/Exception:printStackTrace	()V
    //   773: aload_0
    //   774: iconst_1
    //   775: aload 13
    //   777: invokespecial 265	aogp:a	(ILcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   780: return
    //   781: aload_0
    //   782: aload 12
    //   784: aload 11
    //   786: aload 10
    //   788: aload 13
    //   790: invokespecial 384	aogp:a	(Lcom/tencent/mobileqq/activity/aio/photo/PeakActivity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/qqstory/database/PublishVideoEntry;)V
    //   793: return
    //   794: astore 11
    //   796: goto -438 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	799	0	this	aogp
    //   329	380	1	i	int
    //   327	263	2	j	int
    //   221	520	3	l1	long
    //   197	104	5	l2	long
    //   244	23	7	l3	long
    //   217	6	9	bool	boolean
    //   50	89	10	localObject1	Object
    //   653	6	10	localObject2	Object
    //   695	61	10	str	String
    //   766	21	10	localException	Exception
    //   57	583	11	localObject3	Object
    //   661	124	11	localInterruptedException1	java.lang.InterruptedException
    //   794	1	11	localInterruptedException2	java.lang.InterruptedException
    //   38	745	12	localPeakActivity	PeakActivity
    //   84	705	13	localPublishVideoEntry	PublishVideoEntry
    //   204	216	14	localObject4	Object
    //   602	8	14	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   447	53	15	localEncodeThread	dov.com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread
    // Exception table:
    //   from	to	target	type
    //   165	183	602	java/lang/UnsatisfiedLinkError
    //   630	650	653	finally
    //   655	658	653	finally
    //   230	238	661	java/lang/InterruptedException
    //   241	246	661	java/lang/InterruptedException
    //   249	260	661	java/lang/InterruptedException
    //   263	271	661	java/lang/InterruptedException
    //   274	300	661	java/lang/InterruptedException
    //   209	219	695	finally
    //   230	238	695	finally
    //   241	246	695	finally
    //   249	260	695	finally
    //   263	271	695	finally
    //   274	300	695	finally
    //   303	306	695	finally
    //   663	692	695	finally
    //   697	700	695	finally
    //   712	765	766	java/lang/Exception
    //   354	358	794	java/lang/InterruptedException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aogp
 * JD-Core Version:    0.7.0.1
 */