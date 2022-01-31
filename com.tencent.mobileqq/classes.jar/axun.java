import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Log;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class axun
  extends axox
{
  private int A;
  protected int a;
  protected long a;
  ajmm jdField_a_of_type_Ajmm = new axuq(this);
  protected ajsb a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)this.a;
  MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
  protected String a;
  public boolean a;
  protected int b;
  private long jdField_b_of_type_Long;
  protected RandomAccessFile b;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  protected int c;
  protected byte[] d;
  private byte[] e;
  private byte[] f;
  boolean g = false;
  public boolean q;
  int x = -1;
  int y = 0;
  private int z;
  
  public axun(axvo paramaxvo, axvt paramaxvt)
  {
    super(paramaxvo, paramaxvt);
    if ((this.jdField_a_of_type_Axvt != null) && (this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
    {
      this.x = ((MessageForShortVideo)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;
      this.g = ((MessageForShortVideo)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isStoryVideo;
      if (this.g) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
    }
    String[] arrayOfString;
    for (;;)
    {
      paramaxvo = paramaxvt.i;
      arrayOfString = paramaxvo.split("QQ_&_MoblieQQ_&_QQ");
      if (4 == arrayOfString.length) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "path was not set correctlly------path = " + paramaxvo);
      }
      b(9304, "path =" + paramaxvo);
      d();
      this.o = true;
      return;
      this.x = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "init ShortVideoForwardProcessor=> " + Arrays.toString(arrayOfString));
    }
    paramaxvt.i = arrayOfString[0];
    this.jdField_a_of_type_JavaLangString = arrayOfString[1];
    this.jdField_c_of_type_Int = Integer.parseInt(arrayOfString[2]);
    this.jdField_d_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(arrayOfString[3]);
  }
  
  private axyt a()
  {
    axyt localaxyt = new axyt();
    localaxyt.jdField_g_of_type_Int = ((int)this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
    localaxyt.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_b_of_type_JavaLangString;
    localaxyt.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString;
    localaxyt.jdField_f_of_type_Int = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
    localaxyt.jdField_l_of_type_Int = 0;
    localaxyt.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString;
    localaxyt.jdField_e_of_type_Int = 2;
    if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject instanceof awel)))
    {
      localObject = (awel)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject;
      localaxyt.jdField_a_of_type_Int = ((awel)localObject).jdField_c_of_type_Int;
      localaxyt.jdField_b_of_type_Int = ((awel)localObject).jdField_d_of_type_Int;
      localaxyt.jdField_c_of_type_Int = ((awel)localObject).jdField_e_of_type_Int;
      localaxyt.jdField_d_of_type_Int = ((awel)localObject).jdField_f_of_type_Int;
      this.x = localaxyt.jdField_c_of_type_Int;
      int i = ((awel)localObject).j;
      this.jdField_c_of_type_Int = i;
      localaxyt.k = i;
      localaxyt.jdField_f_of_type_JavaLangString = ((awel)localObject).jdField_a_of_type_JavaLangString;
      localaxyt.jdField_a_of_type_JavaLangString = ((awel)localObject).jdField_k_of_type_JavaLangString;
      localaxyt.j = ((awel)localObject).jdField_l_of_type_Int;
      localaxyt.jdField_g_of_type_JavaLangString = ((awel)localObject).jdField_l_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileFormat", String.valueOf(localaxyt.j));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picResLength", String.valueOf(this.jdField_b_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picResWidth", String.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromChatType", String.valueOf(localaxyt.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toChatType", String.valueOf(localaxyt.jdField_b_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromBusiType", String.valueOf(localaxyt.jdField_c_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toBusiType", String.valueOf(localaxyt.jdField_d_of_type_Int));
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0)) {
        localaxyt.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      localaxyt.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      localaxyt.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localaxyt.i = this.jdField_a_of_type_Int;
      localaxyt.jdField_h_of_type_Int = this.jdField_b_of_type_Int;
      if (localaxyt.jdField_a_of_type_JavaLangString != null) {
        break label416;
      }
    }
    label416:
    for (Object localObject = "";; localObject = localaxyt.jdField_a_of_type_JavaLangString)
    {
      localaxyt.jdField_a_of_type_JavaLangString = ((String)localObject);
      localaxyt.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      localaxyt.jdField_b_of_type_ArrayOfByte = this.jdField_d_of_type_ArrayOfByte;
      return localaxyt;
      b("sendRequest", "Error => mUiRequest.mExtraObj not ShortVideoForwardInfo");
      return null;
    }
  }
  
  private im_msg_body.RichText a()
  {
    for (;;)
    {
      try
      {
        im_msg_body.RichText localRichText = new im_msg_body.RichText();
        im_msg_body.VideoFile localVideoFile = new im_msg_body.VideoFile();
        localVideoFile.setHasFlag(true);
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0)) {
          localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
        }
        if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.length() > 0)) {
          localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoForwardProcessor", 2, "constructRichText(): mResid uuid=" + this.jdField_f_of_type_JavaLangString);
        }
        if ((this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))
        {
          Object localObject1 = (MessageForShortVideo)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (localObject1 != null)
          {
            localVideoFile.uint32_file_format.set(((MessageForShortVideo)localObject1).videoFileFormat);
            localVideoFile.uint32_file_time.set(((MessageForShortVideo)localObject1).videoFileTime);
            if ((((MessageForShortVideo)localObject1).videoFileName != null) && (((MessageForShortVideo)localObject1).videoFileName.length() > 0)) {
              localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).videoFileName));
            }
            if ((((MessageForShortVideo)localObject1).fileSource != null) && (((MessageForShortVideo)localObject1).fileSource.length() > 0)) {
              localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
            }
            localVideoFile.uint32_busi_type.set(((MessageForShortVideo)localObject1).busiType);
            localVideoFile.uint32_from_chat_type.set(((MessageForShortVideo)localObject1).fromChatType);
            localVideoFile.uint32_to_chat_type.set(((MessageForShortVideo)localObject1).toChatType);
            localVideoFile.bool_support_progressive.set(((MessageForShortVideo)localObject1).supportProgressive);
            localVideoFile.uint32_file_width.set(((MessageForShortVideo)localObject1).fileWidth);
            localVideoFile.uint32_file_height.set(((MessageForShortVideo)localObject1).fileHeight);
          }
          if ((this.jdField_d_of_type_ArrayOfByte != null) && (this.jdField_d_of_type_ArrayOfByte.length > 0)) {
            localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.jdField_d_of_type_ArrayOfByte));
          }
          localVideoFile.uint32_thumb_file_size.set((int)this.jdField_a_of_type_Long);
          localVideoFile.uint32_file_size.set((int)this.jdField_b_of_type_Long);
          localVideoFile.uint32_thumb_width.set(this.jdField_a_of_type_Int);
          localVideoFile.uint32_thumb_height.set(this.jdField_b_of_type_Int);
          if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0)) {
            localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
          }
          Object localObject3 = new videoFile.ResvAttr();
          if ((localObject1 != null) && (((MessageForShortVideo)localObject1).CheckIsHotVideo()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoForwardProcessor", 2, "constructRichText MessageForHotVideo ");
            }
            if ((((MessageForShortVideo)localObject1).hotVideoIconUrl != null) && (((MessageForShortVideo)localObject1).hotVideoIconUrl.length() > 0)) {
              ((videoFile.ResvAttr)localObject3).bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoIconUrl));
            }
            if ((((MessageForShortVideo)localObject1).hotVideoTitle != null) && (((MessageForShortVideo)localObject1).hotVideoTitle.length() > 0)) {
              ((videoFile.ResvAttr)localObject3).bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoTitle));
            }
            if ((((MessageForShortVideo)localObject1).hotVideoUrl != null) && (((MessageForShortVideo)localObject1).hotVideoUrl.length() > 0)) {
              ((videoFile.ResvAttr)localObject3).bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoUrl));
            }
            if ((((MessageForShortVideo)localObject1).hotVideoSubIconUrl != null) && (((MessageForShortVideo)localObject1).hotVideoSubIconUrl.length() > 0)) {
              ((videoFile.ResvAttr)localObject3).bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoSubIconUrl));
            }
            ((videoFile.ResvAttr)localObject3).uint32_special_video_type.set(((MessageForShortVideo)localObject1).specialVideoType);
          }
          if (localObject1 != null)
          {
            ((videoFile.ResvAttr)localObject3).uint32_msg_tail_type.set(((MessageForShortVideo)localObject1).msgTailType);
            if (((MessageForShortVideo)localObject1).CheckIsDanceVideo()) {
              ((videoFile.ResvAttr)localObject3).uint32_special_video_type.set(((MessageForShortVideo)localObject1).specialVideoType);
            }
            if (!TextUtils.isEmpty(((MessageForShortVideo)localObject1).templateId)) {
              ((videoFile.ResvAttr)localObject3).bytes_camera_templateid.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).templateId));
            }
          }
          ((videoFile.ResvAttr)localObject3).uint32_long_video_kandian_type.set(this.A);
          if (this.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoForwardProcessor", 2, "videoSource report : 3 , from msg tab camera");
            }
            ((videoFile.ResvAttr)localObject3).uint32_source.set(3);
            localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((videoFile.ResvAttr)localObject3).toByteArray()));
            localVideoFile.uint32_video_attr.set(this.z);
            localObject3 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject3).setHasFlag(true);
            ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(ajjy.a(2131648271)));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
            localObject3 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject3).video_file.set(localVideoFile);
            localRichText.elems.add((MessageMicro)localObject1);
            localRichText.elems.add((MessageMicro)localObject3);
            return localRichText;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoForwardProcessor", 2, "videoSource report : 4 , from forward");
          }
          ((videoFile.ResvAttr)localObject3).uint32_source.set(4);
          continue;
        }
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        b("Construct richtext", "Construct richtext error");
        localException.printStackTrace();
        return null;
      }
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_Axqf.jdField_a_of_type_Axqg.a();
    this.jdField_a_of_type_Axqf.b.a();
    this.jdField_a_of_type_Axqf.jdField_a_of_type_Axqh.a();
    this.jdField_a_of_type_Axqf.c.a();
    axqf localaxqf = this.jdField_a_of_type_Axqf;
    long l = System.nanoTime();
    localaxqf.g = l;
    this.jdField_k_of_type_Long = l;
    this.jdField_a_of_type_Axqf.h = 0L;
  }
  
  /* Error */
  public void a(axyg paramaxyg, axyv paramaxyv)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 556	axun:jdField_a_of_type_Axyg	Laxyg;
    //   5: aload_2
    //   6: ifnull +398 -> 404
    //   9: iconst_0
    //   10: istore 4
    //   12: iload 4
    //   14: aload_2
    //   15: getfield 561	axyv:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   18: invokeinterface 566 1 0
    //   23: if_icmpge +381 -> 404
    //   26: aload_2
    //   27: getfield 561	axyv:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   30: iload 4
    //   32: invokeinterface 570 2 0
    //   37: checkcast 572	axzk
    //   40: astore 8
    //   42: aload_0
    //   43: ldc_w 574
    //   46: aload 8
    //   48: invokevirtual 575	axzk:toString	()Ljava/lang/String;
    //   51: invokevirtual 267	axun:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 578	axun:jdField_a_of_type_Axow	Laxow;
    //   59: aload 8
    //   61: invokevirtual 581	axun:a	(Laxow;Laxzi;)V
    //   64: aload_0
    //   65: aload 8
    //   67: getfield 582	axzk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   70: putfield 297	axun:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   73: aload 8
    //   75: getfield 583	axzk:jdField_c_of_type_Int	I
    //   78: ifne +918 -> 996
    //   81: aload_0
    //   82: aload 8
    //   84: getfield 584	axzk:jdField_a_of_type_Int	I
    //   87: putfield 472	axun:z	I
    //   90: aload_0
    //   91: aload 8
    //   93: getfield 585	axzk:jdField_b_of_type_Int	I
    //   96: putfield 453	axun:A	I
    //   99: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +47 -> 149
    //   105: ldc 99
    //   107: iconst_2
    //   108: new 101	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 587
    //   118: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 8
    //   123: getfield 584	axzk:jdField_a_of_type_Int	I
    //   126: invokevirtual 590	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: ldc_w 592
    //   132: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 8
    //   137: getfield 585	axzk:jdField_b_of_type_Int	I
    //   140: invokevirtual 590	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload 8
    //   151: getfield 593	axzk:jdField_a_of_type_Boolean	Z
    //   154: ifeq +44 -> 198
    //   157: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +12 -> 172
    //   163: ldc 99
    //   165: iconst_2
    //   166: ldc_w 595
    //   169: invokestatic 597	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: iconst_1
    //   174: putfield 39	axun:jdField_b_of_type_Boolean	Z
    //   177: aload_0
    //   178: sipush 1007
    //   181: invokevirtual 599	axun:d	(I)V
    //   184: aload_0
    //   185: iconst_1
    //   186: invokevirtual 601	axun:b	(Z)V
    //   189: iload 4
    //   191: iconst_1
    //   192: iadd
    //   193: istore 4
    //   195: goto -183 -> 12
    //   198: aload_0
    //   199: getfield 35	axun:x	I
    //   202: ifne +285 -> 487
    //   205: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +35 -> 243
    //   211: ldc 99
    //   213: iconst_2
    //   214: new 101	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 603
    //   224: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_0
    //   228: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   231: getfield 83	axvt:i	Ljava/lang/String;
    //   234: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 597	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: new 605	android/media/MediaPlayer
    //   246: dup
    //   247: invokespecial 606	android/media/MediaPlayer:<init>	()V
    //   250: astore 7
    //   252: new 608	java/io/FileInputStream
    //   255: dup
    //   256: aload_0
    //   257: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   260: getfield 83	axvt:i	Ljava/lang/String;
    //   263: invokespecial 611	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   266: astore_1
    //   267: aload 7
    //   269: aload_1
    //   270: invokevirtual 615	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   273: invokevirtual 619	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   276: aload 7
    //   278: invokevirtual 622	android/media/MediaPlayer:prepare	()V
    //   281: aload 7
    //   283: ifnull +8 -> 291
    //   286: aload 7
    //   288: invokevirtual 625	android/media/MediaPlayer:release	()V
    //   291: aload_1
    //   292: ifnull +7 -> 299
    //   295: aload_1
    //   296: invokevirtual 628	java/io/FileInputStream:close	()V
    //   299: iconst_0
    //   300: istore_3
    //   301: iload_3
    //   302: ifeq +185 -> 487
    //   305: invokestatic 632	com/tencent/mobileqq/shortvideo/ShortVideoUtils:d	()Z
    //   308: ifeq +179 -> 487
    //   311: aload_0
    //   312: sipush 9305
    //   315: ldc_w 634
    //   318: invokevirtual 120	axun:b	(ILjava/lang/String;)V
    //   321: aload_0
    //   322: invokevirtual 122	axun:d	()V
    //   325: new 220	java/util/HashMap
    //   328: dup
    //   329: invokespecial 635	java/util/HashMap:<init>	()V
    //   332: astore_1
    //   333: aload_1
    //   334: getstatic 640	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   337: ldc 255
    //   339: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   342: pop
    //   343: aload_1
    //   344: ldc_w 642
    //   347: aload_0
    //   348: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   351: getfield 83	axvt:i	Ljava/lang/String;
    //   354: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   357: pop
    //   358: aload_1
    //   359: ldc_w 644
    //   362: aload_0
    //   363: getfield 645	axun:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   366: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   369: pop
    //   370: aload_1
    //   371: ldc_w 647
    //   374: aload_0
    //   375: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   378: getfield 648	axvt:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   381: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   384: pop
    //   385: invokestatic 654	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   388: invokestatic 659	awrn:a	(Landroid/content/Context;)Lawrn;
    //   391: aconst_null
    //   392: ldc_w 661
    //   395: iconst_1
    //   396: lconst_0
    //   397: lconst_0
    //   398: aload_1
    //   399: ldc 255
    //   401: invokevirtual 664	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   404: return
    //   405: astore_1
    //   406: iconst_0
    //   407: istore_3
    //   408: goto -107 -> 301
    //   411: astore_1
    //   412: aconst_null
    //   413: astore 7
    //   415: aconst_null
    //   416: astore_1
    //   417: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   420: ifeq +12 -> 432
    //   423: ldc 99
    //   425: iconst_2
    //   426: ldc_w 666
    //   429: invokestatic 597	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload 7
    //   434: ifnull +8 -> 442
    //   437: aload 7
    //   439: invokevirtual 625	android/media/MediaPlayer:release	()V
    //   442: aload_1
    //   443: ifnull +7 -> 450
    //   446: aload_1
    //   447: invokevirtual 628	java/io/FileInputStream:close	()V
    //   450: iconst_1
    //   451: istore_3
    //   452: goto -151 -> 301
    //   455: astore_1
    //   456: iconst_1
    //   457: istore_3
    //   458: goto -157 -> 301
    //   461: astore_2
    //   462: aconst_null
    //   463: astore 7
    //   465: aconst_null
    //   466: astore_1
    //   467: aload 7
    //   469: ifnull +8 -> 477
    //   472: aload 7
    //   474: invokevirtual 625	android/media/MediaPlayer:release	()V
    //   477: aload_1
    //   478: ifnull +7 -> 485
    //   481: aload_1
    //   482: invokevirtual 628	java/io/FileInputStream:close	()V
    //   485: aload_2
    //   486: athrow
    //   487: aload_0
    //   488: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   491: getfield 83	axvt:i	Ljava/lang/String;
    //   494: ifnull +408 -> 902
    //   497: aload_0
    //   498: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   501: getfield 83	axvt:i	Ljava/lang/String;
    //   504: invokevirtual 243	java/lang/String:length	()I
    //   507: ifle +395 -> 902
    //   510: aload_0
    //   511: getfield 668	axun:e	[B
    //   514: ifnull +11 -> 525
    //   517: aload_0
    //   518: getfield 668	axun:e	[B
    //   521: arraylength
    //   522: ifne +20 -> 542
    //   525: aload_0
    //   526: aload_0
    //   527: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   530: getfield 83	axvt:i	Ljava/lang/String;
    //   533: invokestatic 673	bace:c	(Ljava/lang/String;)Ljava/lang/String;
    //   536: invokestatic 148	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   539: putfield 668	axun:e	[B
    //   542: new 675	java/io/File
    //   545: dup
    //   546: aload_0
    //   547: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   550: getfield 83	axvt:i	Ljava/lang/String;
    //   553: invokespecial 676	java/io/File:<init>	(Ljava/lang/String;)V
    //   556: astore_1
    //   557: aload_1
    //   558: invokevirtual 679	java/io/File:exists	()Z
    //   561: ifeq +326 -> 887
    //   564: aload_1
    //   565: invokevirtual 681	java/io/File:length	()J
    //   568: lconst_0
    //   569: lcmp
    //   570: ifle +317 -> 887
    //   573: aload_0
    //   574: aload_1
    //   575: invokevirtual 681	java/io/File:length	()J
    //   578: putfield 245	axun:jdField_b_of_type_Long	J
    //   581: aload_0
    //   582: aload_1
    //   583: invokevirtual 684	java/io/File:getName	()Ljava/lang/String;
    //   586: putfield 239	axun:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   589: aload_0
    //   590: getfield 134	axun:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   593: ifnull +339 -> 932
    //   596: aload_0
    //   597: getfield 134	axun:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   600: invokevirtual 243	java/lang/String:length	()I
    //   603: ifle +329 -> 932
    //   606: aload_0
    //   607: getfield 686	axun:jdField_f_of_type_ArrayOfByte	[B
    //   610: ifnull +11 -> 621
    //   613: aload_0
    //   614: getfield 686	axun:jdField_f_of_type_ArrayOfByte	[B
    //   617: arraylength
    //   618: ifne +17 -> 635
    //   621: aload_0
    //   622: aload_0
    //   623: getfield 134	axun:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   626: invokestatic 673	bace:c	(Ljava/lang/String;)Ljava/lang/String;
    //   629: invokestatic 148	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   632: putfield 686	axun:jdField_f_of_type_ArrayOfByte	[B
    //   635: new 675	java/io/File
    //   638: dup
    //   639: aload_0
    //   640: getfield 134	axun:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   643: invokespecial 676	java/io/File:<init>	(Ljava/lang/String;)V
    //   646: astore_1
    //   647: aload_1
    //   648: invokevirtual 679	java/io/File:exists	()Z
    //   651: ifeq +266 -> 917
    //   654: aload_1
    //   655: invokevirtual 681	java/io/File:length	()J
    //   658: lconst_0
    //   659: lcmp
    //   660: ifle +257 -> 917
    //   663: aload_0
    //   664: aload_1
    //   665: invokevirtual 681	java/io/File:length	()J
    //   668: putfield 247	axun:jdField_a_of_type_Long	J
    //   671: aload_0
    //   672: aload_0
    //   673: getfield 134	axun:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   676: invokevirtual 688	axun:b	(Ljava/lang/String;)V
    //   679: aload_0
    //   680: aload_0
    //   681: getfield 245	axun:jdField_b_of_type_Long	J
    //   684: aload_0
    //   685: getfield 247	axun:jdField_a_of_type_Long	J
    //   688: ladd
    //   689: putfield 690	axun:q	J
    //   692: aload_0
    //   693: getfield 257	axun:jdField_a_of_type_ArrayOfByte	[B
    //   696: ifnull +251 -> 947
    //   699: aload_0
    //   700: getfield 257	axun:jdField_a_of_type_ArrayOfByte	[B
    //   703: arraylength
    //   704: ifle +243 -> 947
    //   707: aload_0
    //   708: getfield 668	axun:e	[B
    //   711: ifnull +236 -> 947
    //   714: aload_0
    //   715: getfield 668	axun:e	[B
    //   718: arraylength
    //   719: ifle +228 -> 947
    //   722: aload_0
    //   723: getfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   726: ifnull +221 -> 947
    //   729: aload_0
    //   730: getfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   733: arraylength
    //   734: ifle +213 -> 947
    //   737: aload_0
    //   738: getfield 686	axun:jdField_f_of_type_ArrayOfByte	[B
    //   741: ifnull +206 -> 947
    //   744: aload_0
    //   745: getfield 686	axun:jdField_f_of_type_ArrayOfByte	[B
    //   748: arraylength
    //   749: ifle +198 -> 947
    //   752: aload_0
    //   753: getfield 257	axun:jdField_a_of_type_ArrayOfByte	[B
    //   756: aload_0
    //   757: getfield 668	axun:e	[B
    //   760: invokestatic 694	java/util/Arrays:equals	([B[B)Z
    //   763: ifeq +17 -> 780
    //   766: aload_0
    //   767: getfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   770: aload_0
    //   771: getfield 686	axun:jdField_f_of_type_ArrayOfByte	[B
    //   774: invokestatic 694	java/util/Arrays:equals	([B[B)Z
    //   777: ifne +170 -> 947
    //   780: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   783: ifeq +83 -> 866
    //   786: ldc 99
    //   788: iconst_2
    //   789: new 101	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   796: ldc_w 696
    //   799: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: aload_0
    //   803: getfield 257	axun:jdField_a_of_type_ArrayOfByte	[B
    //   806: invokestatic 700	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   809: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: ldc_w 702
    //   815: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: aload_0
    //   819: getfield 668	axun:e	[B
    //   822: invokestatic 700	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   825: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: ldc_w 704
    //   831: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: aload_0
    //   835: getfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   838: invokestatic 700	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   841: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: ldc_w 706
    //   847: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: aload_0
    //   851: getfield 686	axun:jdField_f_of_type_ArrayOfByte	[B
    //   854: invokestatic 700	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   857: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: aload_0
    //   867: aload_0
    //   868: getfield 668	axun:e	[B
    //   871: putfield 257	axun:jdField_a_of_type_ArrayOfByte	[B
    //   874: aload_0
    //   875: aload_0
    //   876: getfield 686	axun:jdField_f_of_type_ArrayOfByte	[B
    //   879: putfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   882: aload_0
    //   883: invokevirtual 708	axun:f	()V
    //   886: return
    //   887: aload_0
    //   888: sipush 9042
    //   891: ldc_w 710
    //   894: invokevirtual 120	axun:b	(ILjava/lang/String;)V
    //   897: aload_0
    //   898: invokevirtual 122	axun:d	()V
    //   901: return
    //   902: aload_0
    //   903: sipush 9302
    //   906: ldc_w 712
    //   909: invokevirtual 120	axun:b	(ILjava/lang/String;)V
    //   912: aload_0
    //   913: invokevirtual 122	axun:d	()V
    //   916: return
    //   917: aload_0
    //   918: sipush 9042
    //   921: ldc_w 714
    //   924: invokevirtual 120	axun:b	(ILjava/lang/String;)V
    //   927: aload_0
    //   928: invokevirtual 122	axun:d	()V
    //   931: return
    //   932: aload_0
    //   933: sipush 9302
    //   936: ldc_w 716
    //   939: invokevirtual 120	axun:b	(ILjava/lang/String;)V
    //   942: aload_0
    //   943: invokevirtual 122	axun:d	()V
    //   946: return
    //   947: aload_0
    //   948: getfield 521	axun:jdField_a_of_type_Axqf	Laxqf;
    //   951: astore_1
    //   952: aload_0
    //   953: getfield 245	axun:jdField_b_of_type_Long	J
    //   956: aload_0
    //   957: getfield 247	axun:jdField_a_of_type_Long	J
    //   960: ladd
    //   961: lstore 5
    //   963: aload_0
    //   964: lload 5
    //   966: putfield 690	axun:q	J
    //   969: aload_1
    //   970: lload 5
    //   972: putfield 717	axqf:jdField_a_of_type_Long	J
    //   975: aload_0
    //   976: aload 8
    //   978: getfield 718	axzk:jdField_a_of_type_Long	J
    //   981: putfield 720	axun:jdField_r_of_type_Long	J
    //   984: aload_0
    //   985: iconst_1
    //   986: putfield 723	axun:w	I
    //   989: aload_0
    //   990: invokevirtual 725	axun:h	()V
    //   993: goto -804 -> 189
    //   996: ldc_w 726
    //   999: aload_0
    //   1000: getfield 727	axun:j	I
    //   1003: if_icmpne +43 -> 1046
    //   1006: aload_0
    //   1007: ldc_w 726
    //   1010: new 101	java/lang/StringBuilder
    //   1013: dup
    //   1014: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1017: ldc_w 729
    //   1020: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: aload_0
    //   1024: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   1027: getfield 648	axvt:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1030: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1036: invokevirtual 120	axun:b	(ILjava/lang/String;)V
    //   1039: aload_0
    //   1040: invokevirtual 122	axun:d	()V
    //   1043: goto -854 -> 189
    //   1046: aload_0
    //   1047: sipush 9045
    //   1050: ldc_w 730
    //   1053: invokestatic 484	ajjy:a	(I)Ljava/lang/String;
    //   1056: invokevirtual 120	axun:b	(ILjava/lang/String;)V
    //   1059: goto -20 -> 1039
    //   1062: astore_1
    //   1063: goto -578 -> 485
    //   1066: astore_2
    //   1067: aconst_null
    //   1068: astore_1
    //   1069: goto -602 -> 467
    //   1072: astore_2
    //   1073: goto -606 -> 467
    //   1076: astore_2
    //   1077: goto -610 -> 467
    //   1080: astore_1
    //   1081: aconst_null
    //   1082: astore_1
    //   1083: goto -666 -> 417
    //   1086: astore 9
    //   1088: goto -671 -> 417
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1091	0	this	axun
    //   0	1091	1	paramaxyg	axyg
    //   0	1091	2	paramaxyv	axyv
    //   300	158	3	i	int
    //   10	184	4	j	int
    //   961	10	5	l	long
    //   250	223	7	localMediaPlayer	android.media.MediaPlayer
    //   40	937	8	localaxzk	axzk
    //   1086	1	9	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   286	291	405	java/lang/Exception
    //   295	299	405	java/lang/Exception
    //   243	252	411	java/lang/Exception
    //   437	442	455	java/lang/Exception
    //   446	450	455	java/lang/Exception
    //   243	252	461	finally
    //   472	477	1062	java/lang/Exception
    //   481	485	1062	java/lang/Exception
    //   252	267	1066	finally
    //   267	281	1072	finally
    //   417	432	1076	finally
    //   252	267	1080	java/lang/Exception
    //   267	281	1086	java/lang/Exception
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (axtt.b(this.j))) {}
    while ((this.h) || ((paramBoolean) && ((this.jdField_m_of_type_Int & 0x2) > 0)) || ((!paramBoolean) && ((this.jdField_m_of_type_Int & 0x1) > 0))) {
      return;
    }
    int j = this.jdField_m_of_type_Int;
    int i;
    long l;
    String str;
    if (paramBoolean)
    {
      i = 2;
      this.jdField_m_of_type_Int = (i | j);
      this.l = System.currentTimeMillis();
      l = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      str = this.jdField_a_of_type_Axow.a(1) + ";" + this.jdField_b_of_type_Axow.a(2) + ";" + this.jdField_c_of_type_Axow.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str);
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_f_of_type_JavaLangString != null) {
        break label495;
      }
      str = this.jdField_k_of_type_JavaLangString;
      label176:
      localHashMap.put("param_uuid", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.q));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busiType", this.x + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_thumbSize", String.valueOf(this.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.jdField_b_of_type_Boolean + "");
      if (!paramBoolean) {
        break label504;
      }
      awrn.a(BaseApplication.getContext()).a(null, b(), true, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      b(paramBoolean, l);
      l();
      Log.i("AutoMonitor", "ShortVideoForward, cost=" + (this.jdField_b_of_type_Axow.jdField_b_of_type_Long - this.jdField_b_of_type_Axow.jdField_a_of_type_Long) / 1000000L + ", getReportTAG = " + b());
      return;
      i = 1;
      break;
      label495:
      str = this.jdField_f_of_type_JavaLangString;
      break label176;
      label504:
      if (this.j != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.j));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.i);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Axvt.jdField_a_of_type_Int));
      awrn.a(BaseApplication.getContext()).a(null, b(), false, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (!paramBoolean)
    {
      if (this.jdField_b_of_type_JavaUtilArrayList.contains(paramString1)) {
        return;
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(paramString1);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_type", "1");
    localHashMap.put("business_type", this.x + "");
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("server_ip", paramString1);
    localHashMap.put("server_port", paramString2);
    localHashMap.put("md5", this.jdField_d_of_type_JavaLangString);
    if (this.jdField_f_of_type_JavaLangString == null) {}
    for (paramString1 = this.jdField_k_of_type_JavaLangString;; paramString1 = this.jdField_f_of_type_JavaLangString)
    {
      localHashMap.put("uuid", paramString1);
      localHashMap.put("chatType", this.jdField_a_of_type_Axvt.jdField_a_of_type_Int + "");
      localHashMap.put("chatUin", this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString + "");
      awrn.a(BaseApplication.getContext()).a(null, "actRichMediaNetMonitor_videoUp", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  /* Error */
  public void aU_()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 125	axun:o	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +12 -> 23
    //   14: ldc 99
    //   16: iconst_2
    //   17: ldc_w 853
    //   20: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: invokespecial 855	axox:aU_	()V
    //   27: aload_0
    //   28: sipush 1001
    //   31: invokevirtual 599	axun:d	(I)V
    //   34: aload_0
    //   35: getfield 521	axun:jdField_a_of_type_Axqf	Laxqf;
    //   38: invokevirtual 856	axqf:a	()V
    //   41: aload_0
    //   42: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   45: getfield 648	axvt:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   48: invokestatic 445	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne +40 -> 91
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   59: getfield 648	axvt:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   62: invokestatic 148	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   65: putfield 257	axun:jdField_a_of_type_ArrayOfByte	[B
    //   68: aload_0
    //   69: getfield 521	axun:jdField_a_of_type_Axqf	Laxqf;
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   77: getfield 648	axvt:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   80: astore_2
    //   81: aload_1
    //   82: aload_2
    //   83: putfield 857	axqf:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_2
    //   88: putfield 858	axun:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   95: getfield 179	axvt:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   98: ifnull +105 -> 203
    //   101: aload_0
    //   102: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   105: getfield 179	axvt:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   108: instanceof 181
    //   111: ifeq +92 -> 203
    //   114: aload_0
    //   115: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   118: getfield 179	axvt:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   121: checkcast 181	awel
    //   124: astore_1
    //   125: aload_0
    //   126: aload_1
    //   127: getfield 859	awel:i	I
    //   130: i2l
    //   131: putfield 245	axun:jdField_b_of_type_Long	J
    //   134: aload_0
    //   135: aload_1
    //   136: getfield 860	awel:jdField_m_of_type_Int	I
    //   139: i2l
    //   140: putfield 247	axun:jdField_a_of_type_Long	J
    //   143: aload_0
    //   144: aload_1
    //   145: getfield 861	awel:jdField_g_of_type_Int	I
    //   148: putfield 230	axun:jdField_a_of_type_Int	I
    //   151: aload_0
    //   152: aload_1
    //   153: getfield 862	awel:jdField_h_of_type_Int	I
    //   156: putfield 227	axun:jdField_b_of_type_Int	I
    //   159: aload_0
    //   160: aload_1
    //   161: getfield 864	awel:jdField_c_of_type_Boolean	Z
    //   164: putfield 455	axun:jdField_a_of_type_Boolean	Z
    //   167: aload_0
    //   168: getfield 257	axun:jdField_a_of_type_ArrayOfByte	[B
    //   171: ifnull +20 -> 191
    //   174: aload_0
    //   175: getfield 257	axun:jdField_a_of_type_ArrayOfByte	[B
    //   178: arraylength
    //   179: ifeq +12 -> 191
    //   182: aload_0
    //   183: getfield 245	axun:jdField_b_of_type_Long	J
    //   186: lconst_0
    //   187: lcmp
    //   188: ifgt +79 -> 267
    //   191: aload_0
    //   192: invokevirtual 866	axun:j	()Z
    //   195: ifne +33 -> 228
    //   198: aload_0
    //   199: invokevirtual 122	axun:d	()V
    //   202: return
    //   203: aload_0
    //   204: ldc_w 868
    //   207: ldc_w 264
    //   210: invokevirtual 267	axun:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: sipush 9302
    //   217: ldc_w 870
    //   220: invokevirtual 120	axun:b	(ILjava/lang/String;)V
    //   223: aload_0
    //   224: invokevirtual 122	axun:d	()V
    //   227: return
    //   228: aload_0
    //   229: aload_0
    //   230: getfield 257	axun:jdField_a_of_type_ArrayOfByte	[B
    //   233: putfield 668	axun:e	[B
    //   236: new 675	java/io/File
    //   239: dup
    //   240: aload_0
    //   241: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   244: getfield 83	axvt:i	Ljava/lang/String;
    //   247: invokespecial 676	java/io/File:<init>	(Ljava/lang/String;)V
    //   250: astore_1
    //   251: aload_0
    //   252: aload_1
    //   253: invokevirtual 681	java/io/File:length	()J
    //   256: putfield 245	axun:jdField_b_of_type_Long	J
    //   259: aload_0
    //   260: aload_1
    //   261: invokevirtual 684	java/io/File:getName	()Ljava/lang/String;
    //   264: putfield 239	axun:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   267: aload_0
    //   268: getfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   271: ifnull +34 -> 305
    //   274: aload_0
    //   275: getfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   278: arraylength
    //   279: ifeq +26 -> 305
    //   282: aload_0
    //   283: getfield 247	axun:jdField_a_of_type_Long	J
    //   286: lconst_0
    //   287: lcmp
    //   288: ifle +17 -> 305
    //   291: aload_0
    //   292: getfield 230	axun:jdField_a_of_type_Int	I
    //   295: ifle +10 -> 305
    //   298: aload_0
    //   299: getfield 227	axun:jdField_b_of_type_Int	I
    //   302: ifgt +132 -> 434
    //   305: new 608	java/io/FileInputStream
    //   308: dup
    //   309: aload_0
    //   310: getfield 134	axun:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   313: invokespecial 611	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   316: astore_2
    //   317: aload_2
    //   318: astore_1
    //   319: aload_0
    //   320: aload_2
    //   321: lconst_0
    //   322: invokestatic 876	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   325: putfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   328: aload_2
    //   329: astore_1
    //   330: aload_0
    //   331: getfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   334: ifnonnull +56 -> 390
    //   337: aload_2
    //   338: astore_1
    //   339: aload_0
    //   340: sipush 9041
    //   343: new 101	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   350: ldc_w 878
    //   353: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_0
    //   357: getfield 134	axun:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   360: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokevirtual 120	axun:b	(ILjava/lang/String;)V
    //   369: aload_2
    //   370: astore_1
    //   371: aload_0
    //   372: invokevirtual 122	axun:d	()V
    //   375: aload_2
    //   376: ifnull -369 -> 7
    //   379: aload_2
    //   380: invokevirtual 628	java/io/FileInputStream:close	()V
    //   383: return
    //   384: astore_1
    //   385: aload_1
    //   386: invokevirtual 879	java/io/IOException:printStackTrace	()V
    //   389: return
    //   390: aload_2
    //   391: astore_1
    //   392: aload_0
    //   393: aload_0
    //   394: getfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   397: putfield 686	axun:jdField_f_of_type_ArrayOfByte	[B
    //   400: aload_2
    //   401: ifnull +7 -> 408
    //   404: aload_2
    //   405: invokevirtual 628	java/io/FileInputStream:close	()V
    //   408: aload_0
    //   409: new 675	java/io/File
    //   412: dup
    //   413: aload_0
    //   414: getfield 134	axun:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   417: invokespecial 676	java/io/File:<init>	(Ljava/lang/String;)V
    //   420: invokevirtual 681	java/io/File:length	()J
    //   423: putfield 247	axun:jdField_a_of_type_Long	J
    //   426: aload_0
    //   427: aload_0
    //   428: getfield 134	axun:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   431: invokevirtual 688	axun:b	(Ljava/lang/String;)V
    //   434: aload_0
    //   435: invokevirtual 708	axun:f	()V
    //   438: return
    //   439: astore_1
    //   440: aload_1
    //   441: invokevirtual 879	java/io/IOException:printStackTrace	()V
    //   444: goto -36 -> 408
    //   447: astore_3
    //   448: aconst_null
    //   449: astore_2
    //   450: aload_2
    //   451: astore_1
    //   452: aload_0
    //   453: aconst_null
    //   454: putfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   457: aload_2
    //   458: astore_1
    //   459: aload_0
    //   460: aload_3
    //   461: invokevirtual 882	axun:a	(Ljava/io/IOException;)V
    //   464: aload_2
    //   465: astore_1
    //   466: aload_0
    //   467: invokevirtual 122	axun:d	()V
    //   470: aload_2
    //   471: ifnull -464 -> 7
    //   474: aload_2
    //   475: invokevirtual 628	java/io/FileInputStream:close	()V
    //   478: return
    //   479: astore_1
    //   480: aload_1
    //   481: invokevirtual 879	java/io/IOException:printStackTrace	()V
    //   484: return
    //   485: astore_2
    //   486: aconst_null
    //   487: astore_1
    //   488: aload_1
    //   489: ifnull +7 -> 496
    //   492: aload_1
    //   493: invokevirtual 628	java/io/FileInputStream:close	()V
    //   496: aload_2
    //   497: athrow
    //   498: astore_1
    //   499: aload_1
    //   500: invokevirtual 879	java/io/IOException:printStackTrace	()V
    //   503: goto -7 -> 496
    //   506: astore_2
    //   507: goto -19 -> 488
    //   510: astore_3
    //   511: goto -61 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	axun
    //   72	299	1	localObject1	Object
    //   384	2	1	localIOException1	java.io.IOException
    //   391	1	1	localObject2	Object
    //   439	2	1	localIOException2	java.io.IOException
    //   451	15	1	localObject3	Object
    //   479	2	1	localIOException3	java.io.IOException
    //   487	6	1	localObject4	Object
    //   498	2	1	localIOException4	java.io.IOException
    //   80	395	2	localObject5	Object
    //   485	12	2	localObject6	Object
    //   506	1	2	localObject7	Object
    //   447	14	3	localIOException5	java.io.IOException
    //   510	1	3	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   379	383	384	java/io/IOException
    //   404	408	439	java/io/IOException
    //   305	317	447	java/io/IOException
    //   474	478	479	java/io/IOException
    //   305	317	485	finally
    //   492	496	498	java/io/IOException
    //   319	328	506	finally
    //   330	337	506	finally
    //   339	369	506	finally
    //   371	375	506	finally
    //   392	400	506	finally
    //   452	457	506	finally
    //   459	464	506	finally
    //   466	470	506	finally
    //   319	328	510	java/io/IOException
    //   330	337	510	java/io/IOException
    //   339	369	510	java/io/IOException
    //   371	375	510	java/io/IOException
    //   392	400	510	java/io/IOException
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "resume()  + mIsPause : " + this.jdField_k_of_type_Boolean);
    }
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = false;
      this.o = false;
      d(1002);
      this.t = 0;
      this.jdField_s_of_type_Int = 0;
      this.jdField_r_of_type_Int = 0;
      this.j = 0;
      this.i = "";
      this.jdField_a_of_type_Bess.a();
      r();
      this.jdField_a_of_type_Axos.a.post(new ShortVideoForwardProcessor.1(this));
    }
    return 0;
  }
  
  protected String b()
  {
    if (this.w == 1) {
      return "actShortVideoForwardBDH";
    }
    return "actShortVideoForward";
  }
  
  protected void b(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    this.jdField_a_of_type_Int = localOptions.outWidth;
    this.jdField_b_of_type_Int = localOptions.outHeight;
  }
  
  void b(boolean paramBoolean)
  {
    int k = 2002;
    int i = 0;
    if (!f()) {
      d("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.w);
    }
    Object localObject1;
    label238:
    do
    {
      do
      {
        return;
      } while (!this.jdField_c_of_type_Boolean);
      this.jdField_c_of_type_Axow.a();
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_Axow);
        d();
        return;
      }
      if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq != null)
      {
        localObject1 = this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq.a((im_msg_body.RichText)localObject2);
        if ((localObject1 != null) && ((localObject1 instanceof MessageForShortVideo))) {
          break label266;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label238;
        }
      }
      for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Axow);
        d();
        return;
        if (this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
        {
          localObject1 = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          break;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
        break;
      }
      ((MessageForShortVideo)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if (!e())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_Axow);
        d();
        return;
      }
      if ((this.jdField_a_of_type_Axvt.jdField_e_of_type_Int == 1010) && (this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq != null))
      {
        super.e();
        localObject2 = new atqr();
        ((atqr)localObject2).jdField_a_of_type_Int = 0;
        ((atqr)localObject2).jdField_a_of_type_Long = this.jdField_b_of_type_Long;
        ((atqr)localObject2).jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (this.jdField_f_of_type_JavaLangString == null) {}
        for (localObject1 = this.jdField_k_of_type_JavaLangString;; localObject1 = this.jdField_f_of_type_JavaLangString)
        {
          ((atqr)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
          ((atqr)localObject2).jdField_c_of_type_Long = this.jdField_a_of_type_Long;
          ((atqr)localObject2).jdField_c_of_type_Int = this.z;
          ((atqr)localObject2).jdField_d_of_type_Int = this.A;
          this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq.a((atqr)localObject2);
          this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq.b((atqr)localObject2);
          return;
        }
      }
      ((avau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a((MessageRecord)localObject1, this.jdField_a_of_type_Ajmm);
    } while ((this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject instanceof awel)));
    label266:
    Object localObject2 = (awel)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject;
    auxb localauxb = new auxb(BaseApplication.getContext());
    int j;
    switch (((awel)localObject2).jdField_c_of_type_Int)
    {
    default: 
      i = 5;
    case 0: 
      j = k;
      switch (((awel)localObject2).jdField_f_of_type_Int)
      {
      default: 
        j = k;
      }
      break;
    }
    for (;;)
    {
      localauxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((awel)localObject2).jdField_h_of_type_JavaLangString, j, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).frienduin, true, paramBoolean, i, ((awel)localObject2).jdField_m_of_type_JavaLangString, ((awel)localObject2).j, ((awel)localObject2).jdField_e_of_type_JavaLangString);
      return;
      i = 1;
      break;
      i = 3000;
      break;
      i = 5;
      break;
      j = 2001;
      continue;
      j = 2003;
    }
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Axvt != null) && (this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageForShortVideo)this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0)) {
      this.jdField_m_of_type_Boolean = true;
    }
    return 0;
  }
  
  public void c()
  {
    if (!this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        b("pause", "");
      }
      d(1004);
      if (this.jdField_a_of_type_Axyg != null)
      {
        axzm.b(this.jdField_a_of_type_Axyg);
        this.jdField_a_of_type_Axyg = null;
      }
    }
    switch (this.w)
    {
    default: 
      return;
    case 0: 
      d("<BDH_LOG> pause() BUT current status is INIT");
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      d("<BDH_LOG> pause() pause BDH channel, transation id=" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().stopTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      return;
    }
    d("<BDH_LOG> pause() pause BDH channel, but trans == null");
  }
  
  void d()
  {
    super.d();
    if (-5100026 == this.j) {
      d(5001);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq != null)
      {
        atqr localatqr = new atqr();
        localatqr.jdField_a_of_type_Int = -1;
        localatqr.jdField_b_of_type_Int = this.j;
        localatqr.jdField_a_of_type_JavaLangString = this.i;
        this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq.b(localatqr);
      }
      return;
      if (9042 == this.j) {
        d(5002);
      } else {
        d(1005);
      }
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if (this.g) {
      bhrl.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, paramInt, f());
    }
    if ((this.jdField_k_of_type_Boolean) && (1004 != paramInt)) {
      return;
    }
    aweg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Axqf, this.jdField_a_of_type_Axvt);
  }
  
  public void d(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_Axvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageRecord != null) {
        break label78;
      }
      b("updateDb", "msg null");
    }
    label78:
    while (!(localMessageRecord instanceof MessageForShortVideo))
    {
      return;
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
      b("updateDb", "findmsgbyMsgId,need fix");
      break;
    }
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
    localMessageForShortVideo.videoFileSize = ((int)this.q);
    if (this.jdField_f_of_type_JavaLangString == null) {}
    for (String str = this.jdField_k_of_type_JavaLangString;; str = this.jdField_f_of_type_JavaLangString)
    {
      localMessageForShortVideo.uuid = str;
      localMessageForShortVideo.md5 = this.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.videoAttr = this.z;
      localMessageForShortVideo.videoKandianType = this.A;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Axvt.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
      return;
    }
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_Ajsb != null) {
      this.jdField_a_of_type_Ajsb.a(this.jdField_a_of_type_Axvt.jdField_f_of_type_JavaLangString + this.jdField_a_of_type_Axvt.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
    }
    String str;
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq != null)
    {
      atqr localatqr = new atqr();
      localatqr.jdField_a_of_type_Int = 0;
      localatqr.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      localatqr.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_f_of_type_JavaLangString == null)
      {
        str = this.jdField_k_of_type_JavaLangString;
        localatqr.jdField_c_of_type_JavaLangString = str;
        localatqr.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
        localatqr.jdField_c_of_type_Int = this.z;
        localatqr.jdField_d_of_type_Int = this.A;
        this.jdField_a_of_type_Axvt.jdField_a_of_type_Atqq.b(localatqr);
      }
    }
    for (;;)
    {
      d(1003);
      return;
      str = this.jdField_f_of_type_JavaLangString;
      break;
      d(true);
    }
  }
  
  void f()
  {
    this.jdField_a_of_type_Axow.a();
    axyg localaxyg = new axyg();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
    }
    axyt localaxyt = a();
    if (localaxyt == null) {}
    do
    {
      return;
      localaxyg.jdField_a_of_type_Axzn = this;
      localaxyg.jdField_a_of_type_JavaLangString = "short_video_fw";
      localaxyg.jdField_a_of_type_JavaUtilList.add(localaxyt);
      localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (!e())
      {
        a(9366, "illegal app", null, this.jdField_a_of_type_Axow);
        d();
        return;
      }
      b("requestStart", localaxyg.toString());
    } while (!f());
    this.jdField_a_of_type_Axyg = localaxyg;
    axzm.a(localaxyg);
  }
  
  public void g()
  {
    if (this.o) {
      return;
    }
    if (this.jdField_f_of_type_JavaLangString != null)
    {
      if (this.jdField_s_of_type_Long >= this.q)
      {
        b(false);
        return;
      }
      if ((this.w == 1) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().resumeTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        return;
      }
      aU_();
      return;
    }
    aU_();
  }
  
  /* Error */
  public void h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +29 -> 35
    //   9: ldc 99
    //   11: iconst_2
    //   12: new 101	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1165
    //   22: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 1168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 754	axun:jdField_b_of_type_Axow	Laxow;
    //   39: invokevirtual 949	axow:a	()V
    //   42: aload_0
    //   43: getfield 1053	axun:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   46: ifnull +4 -> 50
    //   49: return
    //   50: aload_0
    //   51: getfield 1170	axun:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   54: ifnonnull +61 -> 115
    //   57: aload_0
    //   58: new 1172	java/io/RandomAccessFile
    //   61: dup
    //   62: aload_0
    //   63: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   66: getfield 83	axvt:i	Ljava/lang/String;
    //   69: ldc_w 1173
    //   72: invokespecial 1175	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: putfield 1170	axun:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   78: aload_0
    //   79: getfield 1170	axun:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   82: ifnonnull +33 -> 115
    //   85: aload_0
    //   86: sipush 9303
    //   89: ldc_w 1177
    //   92: invokevirtual 120	axun:b	(ILjava/lang/String;)V
    //   95: aload_0
    //   96: invokevirtual 122	axun:d	()V
    //   99: return
    //   100: astore 9
    //   102: aload 9
    //   104: invokevirtual 1178	java/io/FileNotFoundException:printStackTrace	()V
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 1170	axun:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   112: goto -34 -> 78
    //   115: aload_0
    //   116: getfield 1180	axun:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   119: ifnonnull +58 -> 177
    //   122: aload_0
    //   123: new 1172	java/io/RandomAccessFile
    //   126: dup
    //   127: aload_0
    //   128: getfield 134	axun:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   131: ldc_w 1173
    //   134: invokespecial 1175	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: putfield 1180	axun:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   140: aload_0
    //   141: getfield 1180	axun:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   144: ifnonnull +33 -> 177
    //   147: aload_0
    //   148: sipush 9303
    //   151: ldc_w 1182
    //   154: invokevirtual 120	axun:b	(ILjava/lang/String;)V
    //   157: aload_0
    //   158: invokevirtual 122	axun:d	()V
    //   161: return
    //   162: astore 9
    //   164: aload 9
    //   166: invokevirtual 1178	java/io/FileNotFoundException:printStackTrace	()V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 1180	axun:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   174: goto -34 -> 140
    //   177: invokestatic 1187	android/os/SystemClock:uptimeMillis	()J
    //   180: lstore_2
    //   181: aload_0
    //   182: getfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   185: arraylength
    //   186: aload_0
    //   187: getfield 257	axun:jdField_a_of_type_ArrayOfByte	[B
    //   190: arraylength
    //   191: iadd
    //   192: newarray byte
    //   194: astore 9
    //   196: aload_0
    //   197: getfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   200: iconst_0
    //   201: aload 9
    //   203: iconst_0
    //   204: aload_0
    //   205: getfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   208: arraylength
    //   209: invokestatic 1191	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   212: aload_0
    //   213: getfield 257	axun:jdField_a_of_type_ArrayOfByte	[B
    //   216: iconst_0
    //   217: aload 9
    //   219: aload_0
    //   220: getfield 150	axun:jdField_d_of_type_ArrayOfByte	[B
    //   223: arraylength
    //   224: aload_0
    //   225: getfield 257	axun:jdField_a_of_type_ArrayOfByte	[B
    //   228: arraylength
    //   229: invokestatic 1191	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   232: new 101	java/lang/StringBuilder
    //   235: dup
    //   236: invokestatic 1193	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   239: invokespecial 1194	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   242: aload 9
    //   244: invokestatic 700	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   247: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 1196
    //   253: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: astore 15
    //   261: invokestatic 1187	android/os/SystemClock:uptimeMillis	()J
    //   264: lstore 4
    //   266: new 675	java/io/File
    //   269: dup
    //   270: aload 15
    //   272: invokespecial 676	java/io/File:<init>	(Ljava/lang/String;)V
    //   275: invokevirtual 1199	java/io/File:delete	()Z
    //   278: pop
    //   279: new 675	java/io/File
    //   282: dup
    //   283: aload 15
    //   285: invokespecial 676	java/io/File:<init>	(Ljava/lang/String;)V
    //   288: astore 9
    //   290: aload 9
    //   292: invokevirtual 679	java/io/File:exists	()Z
    //   295: istore 8
    //   297: iload 8
    //   299: ifne +9 -> 308
    //   302: aload 9
    //   304: invokevirtual 1202	java/io/File:createNewFile	()Z
    //   307: pop
    //   308: new 1204	java/io/FileOutputStream
    //   311: dup
    //   312: aload 9
    //   314: invokespecial 1207	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   317: astore 9
    //   319: new 1209	java/io/BufferedOutputStream
    //   322: dup
    //   323: aload 9
    //   325: invokespecial 1212	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   328: astore 10
    //   330: aload 9
    //   332: astore 12
    //   334: aload 10
    //   336: astore 11
    //   338: aload_0
    //   339: getfield 1180	axun:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   342: invokevirtual 1213	java/io/RandomAccessFile:length	()J
    //   345: l2i
    //   346: newarray byte
    //   348: astore 13
    //   350: aload 9
    //   352: astore 12
    //   354: aload 10
    //   356: astore 11
    //   358: aload_0
    //   359: getfield 1180	axun:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   362: aload 13
    //   364: invokevirtual 1217	java/io/RandomAccessFile:read	([B)I
    //   367: pop
    //   368: aload 9
    //   370: astore 12
    //   372: aload 10
    //   374: astore 11
    //   376: aload 10
    //   378: aload 13
    //   380: invokevirtual 1221	java/io/BufferedOutputStream:write	([B)V
    //   383: aload 9
    //   385: astore 12
    //   387: aload 10
    //   389: astore 11
    //   391: ldc_w 1222
    //   394: newarray byte
    //   396: astore 13
    //   398: aload 9
    //   400: astore 12
    //   402: aload 10
    //   404: astore 11
    //   406: aload_0
    //   407: getfield 1170	axun:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   410: aload 13
    //   412: invokevirtual 1217	java/io/RandomAccessFile:read	([B)I
    //   415: istore_1
    //   416: iload_1
    //   417: iconst_m1
    //   418: if_icmpeq +102 -> 520
    //   421: aload 9
    //   423: astore 12
    //   425: aload 10
    //   427: astore 11
    //   429: aload 10
    //   431: aload 13
    //   433: iconst_0
    //   434: iload_1
    //   435: invokevirtual 1225	java/io/BufferedOutputStream:write	([BII)V
    //   438: goto -40 -> 398
    //   441: astore 11
    //   443: aload 11
    //   445: invokevirtual 1178	java/io/FileNotFoundException:printStackTrace	()V
    //   448: aload 10
    //   450: ifnull +8 -> 458
    //   453: aload 10
    //   455: invokevirtual 1226	java/io/BufferedOutputStream:close	()V
    //   458: aload 9
    //   460: ifnull +8 -> 468
    //   463: aload 9
    //   465: invokevirtual 1227	java/io/FileOutputStream:close	()V
    //   468: aload_0
    //   469: invokespecial 1135	axun:a	()Laxyt;
    //   472: astore 10
    //   474: aload 10
    //   476: ifnonnull +262 -> 738
    //   479: aload_0
    //   480: sipush 9302
    //   483: ldc_w 1229
    //   486: invokevirtual 120	axun:b	(ILjava/lang/String;)V
    //   489: aload_0
    //   490: invokevirtual 122	axun:d	()V
    //   493: return
    //   494: astore 11
    //   496: aload 11
    //   498: invokevirtual 879	java/io/IOException:printStackTrace	()V
    //   501: goto -193 -> 308
    //   504: astore 11
    //   506: aconst_null
    //   507: astore 12
    //   509: aload 10
    //   511: astore 9
    //   513: aload 12
    //   515: astore 10
    //   517: goto -74 -> 443
    //   520: aload 9
    //   522: astore 12
    //   524: aload 10
    //   526: astore 11
    //   528: invokestatic 1187	android/os/SystemClock:uptimeMillis	()J
    //   531: lstore 6
    //   533: aload 9
    //   535: astore 12
    //   537: aload 10
    //   539: astore 11
    //   541: aload_0
    //   542: getfield 212	axun:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   545: ldc_w 1231
    //   548: lload 6
    //   550: lload 4
    //   552: lsub
    //   553: invokestatic 775	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   556: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   559: pop
    //   560: aload 10
    //   562: ifnull +8 -> 570
    //   565: aload 10
    //   567: invokevirtual 1226	java/io/BufferedOutputStream:close	()V
    //   570: aload 9
    //   572: ifnull -104 -> 468
    //   575: aload 9
    //   577: invokevirtual 1227	java/io/FileOutputStream:close	()V
    //   580: goto -112 -> 468
    //   583: astore 9
    //   585: aload 9
    //   587: invokevirtual 879	java/io/IOException:printStackTrace	()V
    //   590: goto -122 -> 468
    //   593: astore 10
    //   595: aload 10
    //   597: invokevirtual 879	java/io/IOException:printStackTrace	()V
    //   600: goto -30 -> 570
    //   603: astore 10
    //   605: aload 10
    //   607: invokevirtual 879	java/io/IOException:printStackTrace	()V
    //   610: goto -152 -> 458
    //   613: astore 9
    //   615: aload 9
    //   617: invokevirtual 879	java/io/IOException:printStackTrace	()V
    //   620: goto -152 -> 468
    //   623: astore 14
    //   625: aconst_null
    //   626: astore 13
    //   628: aconst_null
    //   629: astore 9
    //   631: aload 13
    //   633: astore 12
    //   635: aload 9
    //   637: astore 11
    //   639: aload 14
    //   641: invokevirtual 879	java/io/IOException:printStackTrace	()V
    //   644: aload 9
    //   646: ifnull +8 -> 654
    //   649: aload 9
    //   651: invokevirtual 1226	java/io/BufferedOutputStream:close	()V
    //   654: aload 13
    //   656: ifnull -188 -> 468
    //   659: aload 13
    //   661: invokevirtual 1227	java/io/FileOutputStream:close	()V
    //   664: goto -196 -> 468
    //   667: astore 9
    //   669: aload 9
    //   671: invokevirtual 879	java/io/IOException:printStackTrace	()V
    //   674: goto -206 -> 468
    //   677: astore 9
    //   679: aload 9
    //   681: invokevirtual 879	java/io/IOException:printStackTrace	()V
    //   684: goto -30 -> 654
    //   687: astore 10
    //   689: aconst_null
    //   690: astore 9
    //   692: aconst_null
    //   693: astore 11
    //   695: aload 11
    //   697: ifnull +8 -> 705
    //   700: aload 11
    //   702: invokevirtual 1226	java/io/BufferedOutputStream:close	()V
    //   705: aload 9
    //   707: ifnull +8 -> 715
    //   710: aload 9
    //   712: invokevirtual 1227	java/io/FileOutputStream:close	()V
    //   715: aload 10
    //   717: athrow
    //   718: astore 11
    //   720: aload 11
    //   722: invokevirtual 879	java/io/IOException:printStackTrace	()V
    //   725: goto -20 -> 705
    //   728: astore 9
    //   730: aload 9
    //   732: invokevirtual 879	java/io/IOException:printStackTrace	()V
    //   735: goto -20 -> 715
    //   738: new 1233	pttcenterservice/PttShortVideo$PttShortVideoUploadReq
    //   741: dup
    //   742: invokespecial 1234	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:<init>	()V
    //   745: astore 11
    //   747: aload 11
    //   749: iconst_1
    //   750: invokevirtual 1235	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:setHasFlag	(Z)V
    //   753: aload 11
    //   755: getfield 1239	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_fromuin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   758: aload_0
    //   759: getfield 64	axun:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   762: invokevirtual 1242	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   765: invokestatic 1248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   768: invokevirtual 1253	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   771: aload 11
    //   773: getfield 1256	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_touin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   776: aload 10
    //   778: getfield 166	axyt:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   781: invokestatic 1248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   784: invokevirtual 1253	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   787: aload 11
    //   789: getfield 1259	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_chat_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   792: aload 10
    //   794: getfield 187	axyt:jdField_b_of_type_Int	I
    //   797: invokevirtual 318	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   800: aload 11
    //   802: getfield 1262	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_client_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   805: aload 10
    //   807: getfield 176	axyt:jdField_e_of_type_Int	I
    //   810: invokevirtual 318	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   813: aload 10
    //   815: getfield 174	axyt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   818: ifnull +521 -> 1339
    //   821: aload 11
    //   823: getfield 1265	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   826: aload 10
    //   828: getfield 174	axyt:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   831: invokestatic 1248	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   834: invokevirtual 1253	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   837: aload 11
    //   839: getfield 1268	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_agent_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   842: aload 10
    //   844: getfield 173	axyt:jdField_l_of_type_Int	I
    //   847: invokevirtual 318	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   850: aload 11
    //   852: getfield 1271	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_business_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   855: aload 10
    //   857: getfield 191	axyt:jdField_d_of_type_Int	I
    //   860: invokevirtual 318	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   863: aload 11
    //   865: getfield 1274	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_flag_support_large_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   868: iconst_1
    //   869: invokevirtual 318	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   872: new 1276	pttcenterservice/PttShortVideo$PttShortVideoFileInfo
    //   875: dup
    //   876: invokespecial 1277	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:<init>	()V
    //   879: astore 12
    //   881: aload 12
    //   883: getfield 1281	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:str_file_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   886: astore 13
    //   888: aload 10
    //   890: getfield 203	axyt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   893: ifnonnull +458 -> 1351
    //   896: ldc 255
    //   898: astore 9
    //   900: aload 13
    //   902: aload 9
    //   904: invokevirtual 1285	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   907: aload 12
    //   909: getfield 1286	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   912: aload 10
    //   914: getfield 258	axyt:jdField_a_of_type_ArrayOfByte	[B
    //   917: invokestatic 290	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   920: invokevirtual 296	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   923: aload 12
    //   925: getfield 1287	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   928: aload 10
    //   930: getfield 260	axyt:jdField_b_of_type_ArrayOfByte	[B
    //   933: invokestatic 290	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   936: invokevirtual 296	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   939: aload 12
    //   941: getfield 1290	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   944: aload 10
    //   946: getfield 246	axyt:jdField_a_of_type_Long	J
    //   949: invokevirtual 1253	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   952: aload 12
    //   954: getfield 1293	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_length	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   957: aload 10
    //   959: getfield 253	axyt:jdField_h_of_type_Int	I
    //   962: invokevirtual 318	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   965: aload 12
    //   967: getfield 1296	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   970: aload 10
    //   972: getfield 250	axyt:i	I
    //   975: invokevirtual 318	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   978: aload 12
    //   980: getfield 1297	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   983: aload 10
    //   985: getfield 205	axyt:j	I
    //   988: invokevirtual 318	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   991: aload 12
    //   993: getfield 1298	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   996: aload 10
    //   998: getfield 197	axyt:k	I
    //   1001: invokevirtual 318	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1004: aload 12
    //   1006: getfield 1301	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_thumb_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1009: aload 10
    //   1011: getfield 248	axyt:jdField_b_of_type_Long	J
    //   1014: invokevirtual 1253	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1017: aload 11
    //   1019: getfield 1305	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:msg_PttShortVideoFileInfo	Lpttcenterservice/PttShortVideo$PttShortVideoFileInfo;
    //   1022: aload 12
    //   1024: invokevirtual 1306	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   1027: aload 11
    //   1029: invokevirtual 1307	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:toByteArray	()[B
    //   1032: astore 9
    //   1034: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1037: ifeq +69 -> 1106
    //   1040: ldc 99
    //   1042: iconst_2
    //   1043: new 101	java/lang/StringBuilder
    //   1046: dup
    //   1047: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1050: ldc_w 1309
    //   1053: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: aload 10
    //   1058: getfield 258	axyt:jdField_a_of_type_ArrayOfByte	[B
    //   1061: invokestatic 700	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   1064: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: ldc_w 1311
    //   1070: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: aload 10
    //   1075: getfield 260	axyt:jdField_b_of_type_ArrayOfByte	[B
    //   1078: invokestatic 700	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   1081: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: ldc_w 1313
    //   1087: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: aload_0
    //   1091: getfield 257	axun:jdField_a_of_type_ArrayOfByte	[B
    //   1094: invokestatic 700	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   1097: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1103: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1106: new 1315	axuo
    //   1109: dup
    //   1110: aload_0
    //   1111: lload_2
    //   1112: aload 15
    //   1114: invokespecial 1318	axuo:<init>	(Laxun;JLjava/lang/String;)V
    //   1117: astore 11
    //   1119: aload 10
    //   1121: getfield 189	axyt:jdField_c_of_type_Int	I
    //   1124: ifne +304 -> 1428
    //   1127: bipush 25
    //   1129: istore_1
    //   1130: aload_0
    //   1131: new 1057	com/tencent/mobileqq/highway/transaction/Transaction
    //   1134: dup
    //   1135: aload_0
    //   1136: getfield 64	axun:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1139: invokevirtual 1242	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1142: iload_1
    //   1143: aload 15
    //   1145: aload_0
    //   1146: getfield 720	axun:jdField_r_of_type_Long	J
    //   1149: l2i
    //   1150: aload_0
    //   1151: getfield 257	axun:jdField_a_of_type_ArrayOfByte	[B
    //   1154: aload 11
    //   1156: aload 9
    //   1158: iconst_1
    //   1159: invokespecial 1321	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[BZ)V
    //   1162: putfield 1053	axun:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1165: new 1323	axup
    //   1168: dup
    //   1169: aload_0
    //   1170: invokespecial 1324	axup:<init>	(Laxun;)V
    //   1173: astore 9
    //   1175: aload_0
    //   1176: getfield 1053	axun:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1179: aload 9
    //   1181: putfield 1328	com/tencent/mobileqq/highway/transaction/Transaction:cbForReport	Lcom/tencent/mobileqq/highway/api/ITransCallbackForReport;
    //   1184: aload_0
    //   1185: getfield 64	axun:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1188: invokevirtual 1064	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   1191: aload_0
    //   1192: getfield 1053	axun:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1195: invokevirtual 1332	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   1198: istore_1
    //   1199: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1202: ifeq +114 -> 1316
    //   1205: ldc 99
    //   1207: iconst_2
    //   1208: new 101	java/lang/StringBuilder
    //   1211: dup
    //   1212: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1215: ldc_w 1334
    //   1218: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: iload_1
    //   1222: invokevirtual 590	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1225: ldc_w 1336
    //   1228: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: aload_0
    //   1232: getfield 1053	axun:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1235: invokevirtual 1060	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   1238: invokevirtual 590	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1241: ldc_w 1338
    //   1244: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: aload_0
    //   1248: getfield 67	axun:jdField_a_of_type_Axvt	Laxvt;
    //   1251: getfield 157	axvt:jdField_a_of_type_Long	J
    //   1254: invokevirtual 804	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1257: ldc_w 1340
    //   1260: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: aload_0
    //   1264: getfield 858	axun:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1267: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: ldc_w 1342
    //   1273: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: aload_0
    //   1277: getfield 645	axun:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1280: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: ldc_w 1344
    //   1286: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: aload_0
    //   1290: getfield 1053	axun:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1293: getfield 1346	com/tencent/mobileqq/highway/transaction/Transaction:filePath	Ljava/lang/String;
    //   1296: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: ldc_w 1348
    //   1302: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: bipush 12
    //   1307: invokevirtual 590	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1310: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1313: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1316: iload_1
    //   1317: ifeq -1268 -> 49
    //   1320: aload_0
    //   1321: iload_1
    //   1322: ldc_w 1350
    //   1325: ldc 255
    //   1327: aload_0
    //   1328: getfield 754	axun:jdField_b_of_type_Axow	Laxow;
    //   1331: invokevirtual 956	axun:a	(ILjava/lang/String;Ljava/lang/String;Laxow;)V
    //   1334: aload_0
    //   1335: invokevirtual 122	axun:d	()V
    //   1338: return
    //   1339: aload 11
    //   1341: getfield 1265	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1344: lconst_0
    //   1345: invokevirtual 1253	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1348: goto -511 -> 837
    //   1351: aload 10
    //   1353: getfield 203	axyt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1356: astore 9
    //   1358: goto -458 -> 900
    //   1361: astore 10
    //   1363: aconst_null
    //   1364: astore 11
    //   1366: goto -671 -> 695
    //   1369: astore 10
    //   1371: aload 12
    //   1373: astore 9
    //   1375: goto -680 -> 695
    //   1378: astore 12
    //   1380: aload 10
    //   1382: astore 11
    //   1384: aload 12
    //   1386: astore 10
    //   1388: goto -693 -> 695
    //   1391: astore 14
    //   1393: aconst_null
    //   1394: astore 10
    //   1396: aload 9
    //   1398: astore 13
    //   1400: aload 10
    //   1402: astore 9
    //   1404: goto -773 -> 631
    //   1407: astore 14
    //   1409: aload 9
    //   1411: astore 13
    //   1413: aload 10
    //   1415: astore 9
    //   1417: goto -786 -> 631
    //   1420: astore 11
    //   1422: aconst_null
    //   1423: astore 10
    //   1425: goto -982 -> 443
    //   1428: bipush 12
    //   1430: istore_1
    //   1431: goto -301 -> 1130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1434	0	this	axun
    //   415	1016	1	i	int
    //   180	932	2	l1	long
    //   264	287	4	l2	long
    //   531	18	6	l3	long
    //   295	3	8	bool	boolean
    //   100	3	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   162	3	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   194	382	9	localObject1	Object
    //   583	3	9	localIOException1	java.io.IOException
    //   613	3	9	localIOException2	java.io.IOException
    //   629	21	9	localObject2	Object
    //   667	3	9	localIOException3	java.io.IOException
    //   677	3	9	localIOException4	java.io.IOException
    //   690	21	9	localObject3	Object
    //   728	3	9	localIOException5	java.io.IOException
    //   898	518	9	localObject4	Object
    //   1	565	10	localObject5	Object
    //   593	3	10	localIOException6	java.io.IOException
    //   603	3	10	localIOException7	java.io.IOException
    //   687	665	10	localObject6	Object
    //   1361	1	10	localObject7	Object
    //   1369	12	10	localObject8	Object
    //   1386	38	10	localObject9	Object
    //   336	92	11	localObject10	Object
    //   441	3	11	localFileNotFoundException3	java.io.FileNotFoundException
    //   494	3	11	localIOException8	java.io.IOException
    //   504	1	11	localFileNotFoundException4	java.io.FileNotFoundException
    //   526	175	11	localObject11	Object
    //   718	3	11	localIOException9	java.io.IOException
    //   745	638	11	localObject12	Object
    //   1420	1	11	localFileNotFoundException5	java.io.FileNotFoundException
    //   332	1040	12	localObject13	Object
    //   1378	7	12	localObject14	Object
    //   348	1064	13	localObject15	Object
    //   623	17	14	localIOException10	java.io.IOException
    //   1391	1	14	localIOException11	java.io.IOException
    //   1407	1	14	localIOException12	java.io.IOException
    //   259	885	15	str	String
    // Exception table:
    //   from	to	target	type
    //   57	78	100	java/io/FileNotFoundException
    //   122	140	162	java/io/FileNotFoundException
    //   338	350	441	java/io/FileNotFoundException
    //   358	368	441	java/io/FileNotFoundException
    //   376	383	441	java/io/FileNotFoundException
    //   391	398	441	java/io/FileNotFoundException
    //   406	416	441	java/io/FileNotFoundException
    //   429	438	441	java/io/FileNotFoundException
    //   528	533	441	java/io/FileNotFoundException
    //   541	560	441	java/io/FileNotFoundException
    //   302	308	494	java/io/IOException
    //   261	297	504	java/io/FileNotFoundException
    //   302	308	504	java/io/FileNotFoundException
    //   308	319	504	java/io/FileNotFoundException
    //   496	501	504	java/io/FileNotFoundException
    //   575	580	583	java/io/IOException
    //   565	570	593	java/io/IOException
    //   453	458	603	java/io/IOException
    //   463	468	613	java/io/IOException
    //   261	297	623	java/io/IOException
    //   308	319	623	java/io/IOException
    //   496	501	623	java/io/IOException
    //   659	664	667	java/io/IOException
    //   649	654	677	java/io/IOException
    //   261	297	687	finally
    //   302	308	687	finally
    //   308	319	687	finally
    //   496	501	687	finally
    //   700	705	718	java/io/IOException
    //   710	715	728	java/io/IOException
    //   319	330	1361	finally
    //   338	350	1369	finally
    //   358	368	1369	finally
    //   376	383	1369	finally
    //   391	398	1369	finally
    //   406	416	1369	finally
    //   429	438	1369	finally
    //   528	533	1369	finally
    //   541	560	1369	finally
    //   639	644	1369	finally
    //   443	448	1378	finally
    //   319	330	1391	java/io/IOException
    //   338	350	1407	java/io/IOException
    //   358	368	1407	java/io/IOException
    //   376	383	1407	java/io/IOException
    //   391	398	1407	java/io/IOException
    //   406	416	1407	java/io/IOException
    //   429	438	1407	java/io/IOException
    //   528	533	1407	java/io/IOException
    //   541	560	1407	java/io/IOException
    //   319	330	1420	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axun
 * JD-Core Version:    0.7.0.1
 */