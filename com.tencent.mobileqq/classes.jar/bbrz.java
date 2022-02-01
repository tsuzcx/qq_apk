import android.content.Context;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressTask.1;
import com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer.ProcessCallBack;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class bbrz
  extends AsyncTask<Void, Void, Integer>
{
  private long jdField_a_of_type_Long;
  private bbsc jdField_a_of_type_Bbsc;
  public MessageForShortVideo a;
  private VideoConverter jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter;
  public Process a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<Context> jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  
  public bbrz(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, bbsc parambbsc)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Bbsc = parambbsc;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
    paramMessageForShortVideo.videoFileStatus = 998;
    try
    {
      paramMessageForShortVideo.serial();
      paramQQAppInterface.getMessageFacade().updateMsgContentByUniseq(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: messageForShortVideo info uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ", OriPath:" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("VideoCompressProcessor", 1, "CompressTask Init", paramQQAppInterface);
      }
    }
  }
  
  private int a(String paramString1, String paramString2)
  {
    long l3 = System.currentTimeMillis();
    Object localObject1 = bbru.a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    bbrx localbbrx = bbru.a(paramString1);
    bbry.a(localbbrx);
    boolean bool = bbru.a(localbbrx, (bbrw)localObject1);
    this.jdField_b_of_type_Boolean = bool;
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 1, "CompressTask, isNeedCompress = " + bool);
    }
    if (this.jdField_a_of_type_Bbsc != null) {
      bjne.a(new VideoCompressProcessor.CompressTask.1(this, bool));
    }
    if (!bool) {
      return -1;
    }
    localObject1 = bbru.a(localbbrx, (bbrw)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.sendRawVideo);
    int i = ShortVideoCodec.checkSupportMediaCodecFeature((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get());
    Object localObject2;
    label290:
    label380:
    long l1;
    label430:
    long l2;
    if ((Build.VERSION.SDK_INT >= 18) && ((i & 0x1) > 0) && ((i & 0x2) > 0))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: isHWCodecSupported = " + bool);
      }
      if (!bool) {
        break label586;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Try to compress by MediaCodec");
      }
      localObject2 = new bbsd(this.jdField_a_of_type_JavaLangRefWeakReference, paramString1, paramString2, (bbrv)localObject1, new bbsa(this));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter = new VideoConverter();
      if ((!this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter.start(new File(paramString1), (VideoConverter.Processor)localObject2, true)) || (((bbsd)localObject2).a != null)) {
        break label567;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: compress completed by MediaCodec");
      }
      i = 0;
      if (i == 0) {
        break label773;
      }
      if (!ShortVideoTrimmer.initVideoTrim((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get(), 0, 0)) {
        break label709;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Try to compress by ShortVideoTrimmer.compressVideo");
      }
      localObject2 = new bbsb(this);
      i = ShortVideoTrimmer.compressVideoNew((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get(), paramString1, paramString2, (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (ShortVideoTrimmer.ProcessCallBack)localObject2, (bbrv)localObject1, localbbrx);
      if (i != 0) {
        break label627;
      }
      QLog.d("VideoCompressProcessor", 1, "CompressTask, step:compress completed by ShortVideoTrimmer.compressVideo");
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask，step: ShortVideoTrimmer compress retCode=" + i + ", uni=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
      if (i != 0) {
        break label776;
      }
      this.c = paramString2;
      l1 = new File(paramString1).length();
      l2 = new File(this.c).length();
      l3 = System.currentTimeMillis() - l3;
      if (i != 0) {
        break label787;
      }
    }
    label773:
    label776:
    label787:
    for (bool = true;; bool = false)
    {
      bbry.a(bool, l3, localbbrx, (bbrv)localObject1, l2);
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask，step: ShortVideoTrimmer compress, cost:" + l3 + "ms, fileSourceSize=" + l1 + ", fileTargetSize=" + l2 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
      return i;
      bool = false;
      break;
      label567:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: compress failed by MediaCodec");
      }
      i = -1;
      break label290;
      label586:
      if (this.jdField_a_of_type_Bbsc != null) {
        this.jdField_a_of_type_Bbsc.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1.0F);
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "不支持硬件压缩，不管软件压缩成功或失败，均默认展示完整呼吸圈");
      }
      i = -1;
      break label290;
      try
      {
        label627:
        localObject2 = new File(paramString2);
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
        if (this.jdField_a_of_type_JavaLangProcess != null)
        {
          this.jdField_a_of_type_JavaLangProcess.destroy();
          this.jdField_a_of_type_JavaLangProcess = null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      QLog.d("VideoCompressProcessor", 1, "CompressTask, step:compress failed using ShortVideoTrimmer.compressVideo, ret = " + i);
      break label380;
      label709:
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
      QLog.e("VideoCompressProcessor", 2, "CompressTask，step: ShortVideoTrimmer init failure, ignore compress, uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "initVideoTrimError", true, 0L, 0L, null, "", false);
      break label380;
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
      break label430;
    }
  }
  
  private String b()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
      str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    return "uniseq = " + str;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    boolean bool2 = false;
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
      return Integer.valueOf(7);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Md5 not null, Compressed has been done, uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
      return Integer.valueOf(5);
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName)) || (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoCompressProcessor", 2, "CompressTask, step: before compress, msg.videoFileName file not exists!! videoFileName=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName);
      }
      return Integer.valueOf(3);
    }
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
    paramVarArgs = ShortVideoUtils.getShortVideoCompressPath(str, "mp4");
    if (TextUtils.isEmpty(paramVarArgs)) {
      return Integer.valueOf(5);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.sendRawVideo)
    {
      paramVarArgs = ShortVideoUtils.getShortVideoRawCompressPath(str, "mp4");
      l1 = new File(str).length();
      if (l1 < 104345600L) {
        break label368;
      }
    }
    label368:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 16) {
        bool1 = ShortVideoUtils.isH265FormatShortVideo(this.jdField_a_of_type_JavaLangString);
      }
      if (bool1) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Compressed sendRawVideo, uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ", mRawCompress:" + this.jdField_a_of_type_Boolean + ", output:" + paramVarArgs + ", isH265:" + bool1 + ", size:" + l1);
      }
      if (!TextUtils.isEmpty(paramVarArgs)) {
        break;
      }
      return Integer.valueOf(5);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.sendRawVideo) && (!this.jdField_a_of_type_Boolean))
    {
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Compressed sendRawVideo, uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
      if (this.jdField_a_of_type_Bbsc != null) {
        this.jdField_a_of_type_Bbsc.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1.0F);
      }
    }
    while (isCancelled())
    {
      return Integer.valueOf(11);
      if (FileUtils.fileExistsAndNotEmpty(paramVarArgs))
      {
        this.c = paramVarArgs;
        QLog.d("VideoCompressProcessor", 1, "CompressTask, step: Compressed file has exists, videoPath:" + paramVarArgs + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        if (this.jdField_a_of_type_Bbsc != null) {
          this.jdField_a_of_type_Bbsc.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1.0F);
        }
      }
      else
      {
        if (a(str, paramVarArgs) == 0) {}
        for (;;)
        {
          this.c = paramVarArgs;
          break;
          paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
        }
      }
    }
    if (TextUtils.isEmpty(this.c)) {
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
    }
    long l1 = new File(str).length();
    long l2 = new File(this.c).length();
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask，step: ShortVideoTrimmer Over fileSourceSize=" + l1 + ", fileTargetSize=" + l2 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ", videoInput=" + str + ", mVideoPath=" + this.c);
    }
    if (l2 > l1) {
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: after compress, mVideoPath = " + this.c + ", videoInput = " + str + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if ((TextUtils.isEmpty(this.c)) || (!FileUtils.fileExistsAndNotEmpty(this.c)))
    {
      QLog.e("VideoCompressProcessor", 2, "CompressTask, step: after compress, mVideoPath not exists!!, path = " + this.c + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      return Integer.valueOf(3);
    }
    paramVarArgs = new File(this.c);
    if (ShortVideoUtils.isSupportProgressive(paramVarArgs))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: supportProgressive, uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.supportProgressive = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = paramVarArgs.length();
      try
      {
        this.jdField_b_of_type_JavaLangString = HexUtil.bytes2HexStr(MD5.toMD5Byte(new FileInputStream(paramVarArgs), this.jdField_a_of_type_Long));
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoCompressProcessor", 1, "CompressTask, step: after compress, mVideoMd5 is empty!!, uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
          }
          return Integer.valueOf(5);
          bool1 = alce.a.get();
          bool2 = ShortVideoUtils.moveMoovAtom(this.c);
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressProcessor", 2, "CompressTask, step: not supportProgressive => moveMoovAtom, result = " + bool2 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ", enableProgressive = " + bool1);
          }
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.supportProgressive = bool2;
        }
      }
      catch (FileNotFoundException paramVarArgs)
      {
        for (;;)
        {
          paramVarArgs.printStackTrace();
        }
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoCompressProcessor", 2, "", paramVarArgs);
          }
        }
        if (this.jdField_a_of_type_Long < 104345600L)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5 = this.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize = ((int)this.jdField_a_of_type_Long);
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName = this.c;
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
          FileUtils.copyFile(new File(this.c), new File(ShortVideoUtils.getShortVideoSavePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4")));
        }
      }
    }
    return Integer.valueOf(1);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(bbsc parambbsc)
  {
    if (parambbsc == null) {}
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Bbsc = parambbsc;
          if (AsyncTask.Status.FINISHED != getStatus()) {
            break;
          }
        } while (this.jdField_a_of_type_Bbsc == null);
        this.jdField_a_of_type_Bbsc.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1);
        return;
        if (!isCancelled()) {
          break;
        }
      } while (this.jdField_a_of_type_Bbsc == null);
      this.jdField_a_of_type_Bbsc.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 3);
      return;
    } while (this.jdField_a_of_type_Bbsc == null);
    this.jdField_a_of_type_Bbsc.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_b_of_type_Boolean);
  }
  
  protected void a(Integer paramInteger)
  {
    int i = 2;
    super.onPostExecute(paramInteger);
    QLog.d("VideoCompressProcessor", 1, "CompressTask onPostExecute(): result = " + paramInteger + ", " + b());
    if (this.jdField_a_of_type_Bbsc != null)
    {
      bbsc localbbsc = this.jdField_a_of_type_Bbsc;
      MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      if (paramInteger.intValue() == 1) {
        i = 1;
      }
      localbbsc.a(localMessageForShortVideo, i);
    }
    while (paramInteger.intValue() == 1)
    {
      agnj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (Context)this.jdField_b_of_type_JavaLangRefWeakReference.get());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "onPostExecute, mListener is null ," + b());
      }
    }
    agnj.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (Context)this.jdField_b_of_type_JavaLangRefWeakReference.get());
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter != null) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilVideoconverterVideoConverter.cancel();; bool = false) {
      try
      {
        if (this.jdField_a_of_type_JavaLangProcess != null) {
          this.jdField_a_of_type_JavaLangProcess.destroy();
        }
        return bool;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
    }
  }
  
  protected void onCancelled()
  {
    String str;
    MessageForShortVideo localMessageForShortVideo;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5;
      localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      localMessageForShortVideo.videoFileStatus = 1004;
      if (!TextUtils.isEmpty(localMessageForShortVideo.md5)) {
        FileUtils.deleteFile(ShortVideoUtils.getShortVideoSavePath(localMessageForShortVideo, "mp4"));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localMessageForShortVideo.videoFileName = this.jdField_a_of_type_JavaLangString;
      }
      localMessageForShortVideo.md5 = null;
      localMessageForShortVideo.serial();
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getMessageFacade().updateMsgContentByUniseq(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
      bahm.a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
      if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof FragmentActivity)))
      {
        localObject = ((FragmentActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).a();
          if (localObject != null) {
            ((BaseChatPie)localObject).instantUpdate(false, false);
          }
        }
      }
      if (!localMessageForShortVideo.sendRawVideo) {
        break label320;
      }
    }
    label320:
    for (Object localObject = ShortVideoUtils.getShortVideoRawCompressPath(this.jdField_a_of_type_JavaLangString, "mp4");; localObject = ShortVideoUtils.getShortVideoCompressPath(this.jdField_a_of_type_JavaLangString, "mp4"))
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        FileUtils.deleteFile((String)localObject);
      }
      bbry.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      if (QLog.isColorLevel()) {
        QLog.i("VideoCompressProcessor", 2, "CompressTask onCancelled id:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ", videoFileName:" + localMessageForShortVideo.videoFileName + ", md5:" + str);
      }
      if (this.jdField_a_of_type_Bbsc != null) {
        this.jdField_a_of_type_Bbsc.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 3);
      }
      return;
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrz
 * JD-Core Version:    0.7.0.1
 */