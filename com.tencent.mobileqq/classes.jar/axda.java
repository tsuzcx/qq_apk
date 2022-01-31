import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.AppRuntime;
import tencent.im.msg.im_msg_body.RichText;

public class axda
  extends BaseShortVideoOprerator
{
  public axda() {}
  
  public axda(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str1 = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    int j;
    int i;
    if (str1 != null)
    {
      j = str1.length();
      if (j < 10)
      {
        i = 0;
        while (i < 10 - j)
        {
          str1 = "0".concat(str1);
          i += 1;
        }
      }
    }
    label265:
    for (;;)
    {
      String str2 = paramString;
      if (paramString != null)
      {
        j = paramString.length();
        if (j < 10)
        {
          i = 0;
          for (;;)
          {
            str2 = paramString;
            if (i >= 10 - j) {
              break;
            }
            paramString = "0".concat(paramString);
            i += 1;
          }
          if (j <= 10) {
            break label265;
          }
          str1 = str1.substring(j - 10, j);
          continue;
        }
        str2 = paramString;
        if (j > 10) {
          str2 = paramString.substring(j - 10, j);
        }
      }
      if (paramInt == 0) {
        paramInt = 0;
      }
      for (;;)
      {
        long l = awzy.a();
        paramString = new SimpleDateFormat("yyyyMMdd").format(new Date(1000L * l));
        paramString = paramString + str1 + l + paramInt + str2;
        if (QLog.isColorLevel()) {
          QLog.d("AioShortVideoOperator", 2, new Object[] { "VideoRedbag, createRedbagVideoId, videoid = ", paramString });
        }
        return paramString;
        if (paramInt == 3000) {
          paramInt = 2;
        } else if (paramInt == 1) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
    }
  }
  
  public axdv a(Object paramObject, axei paramaxei)
  {
    if (paramObject == null)
    {
      aung.b("AioShortVideoOperator", this.jdField_f_of_type_JavaLangString, "createShortVideoForwardInfo", "input == null");
      return null;
    }
    if (paramaxei == null)
    {
      aung.b("AioShortVideoOperator", this.jdField_f_of_type_JavaLangString, "createShortVideoForwardInfo", "ShortVideoReq == null");
      return null;
    }
    Object localObject18 = "0";
    Object localObject17 = "0";
    int i10 = 0;
    int i11 = 0;
    int i9 = 0;
    Object localObject16 = "";
    Object localObject15 = "";
    Object localObject14 = "";
    Object localObject13 = "";
    int i8 = 0;
    int i7 = 0;
    Object localObject10 = "";
    Object localObject9 = "";
    int i6 = 2;
    boolean bool3 = false;
    int i3 = 0;
    int i2 = 0;
    Object localObject5 = "";
    Object localObject2 = "";
    Object localObject3 = "";
    Object localObject4 = "";
    Object localObject6 = "";
    Object localObject1;
    Object localObject8;
    int i4;
    Object localObject12;
    Object localObject11;
    int i5;
    Object localObject19;
    int i1;
    int n;
    long l;
    boolean bool2;
    boolean bool1;
    int i;
    if ((paramObject instanceof Intent))
    {
      localObject1 = (Intent)paramObject;
      localObject18 = ((Intent)localObject1).getStringExtra("uin");
      localObject17 = ((Intent)localObject1).getStringExtra("troop_uin");
      i10 = ((Intent)localObject1).getIntExtra("uintype", -1);
      localObject8 = ((Intent)localObject1).getStringExtra("from_uin");
      i4 = ((Intent)localObject1).getIntExtra("from_uin_type", -1);
      localObject5 = ((Intent)localObject1).getStringExtra("from_session_uin");
      ((Intent)localObject1).getIntExtra("from_busi_type", -1);
      i11 = ((Intent)localObject1).getIntExtra("file_send_size", 0);
      i9 = ((Intent)localObject1).getIntExtra("file_send_duration", -1);
      localObject16 = ((Intent)localObject1).getStringExtra("file_send_path");
      localObject15 = ((Intent)localObject1).getStringExtra("thumbfile_send_path");
      localObject14 = ((Intent)localObject1).getStringExtra("file_shortvideo_md5");
      localObject13 = ((Intent)localObject1).getStringExtra("file_shortvideo_local_md5");
      i8 = ((Intent)localObject1).getIntExtra("thumbfile_send_width", 0);
      i7 = ((Intent)localObject1).getIntExtra("thumbfile_send_height", 0);
      localObject12 = ((Intent)localObject1).getStringExtra("thumbfile_md5");
      localObject11 = ((Intent)localObject1).getStringExtra("file_source");
      localObject10 = ((Intent)localObject1).getStringExtra("file_uuid");
      localObject9 = ((Intent)localObject1).getStringExtra("file_name");
      i6 = ((Intent)localObject1).getIntExtra("file_format", 2);
      i5 = ((Intent)localObject1).getIntExtra("file_thumb_Size", 0);
      bool3 = ((Intent)localObject1).getBooleanExtra("support_progressive", false);
      i3 = ((Intent)localObject1).getIntExtra("file_width", 0);
      i2 = ((Intent)localObject1).getIntExtra("file_height", 0);
      localObject4 = ((Intent)localObject1).getStringExtra("hot_video_icon");
      localObject2 = ((Intent)localObject1).getStringExtra("hot_video_title");
      localObject19 = ((Intent)localObject1).getStringExtra("hot_video_url");
      localObject3 = ((Intent)localObject1).getStringExtra("hot_video_icon_sub");
      i1 = ((Intent)localObject1).getIntExtra("special_video_type", 0);
      n = ((Intent)localObject1).getIntExtra("short_video_msg_tail_type", 0);
      l = ((Intent)localObject1).getLongExtra("from_msg_uniseq", 0L);
      bool2 = ((Intent)localObject1).getBooleanExtra("key_story_video_to_recent", false);
      if (((Intent)localObject1).getIntExtra("forward_source_business_type", -1) == 100200)
      {
        bool1 = true;
        localObject6 = ((Intent)localObject1).getStringExtra("widgetinfo");
        i = ((Intent)localObject1).getIntExtra("param_key_redbag_type", 0);
        if (i != LocalMediaInfo.REDBAG_TYPE_GET) {
          break label2505;
        }
        if ((((String)localObject5).equals("0")) || (!((String)localObject5).equals(localObject18))) {
          break label551;
        }
        localObject1 = ((Intent)localObject1).getStringExtra("param_key_redbag_video_id");
      }
    }
    for (;;)
    {
      label503:
      Object localObject7 = localObject1;
      localObject1 = localObject19;
      int j = 0;
      int k = 0;
      int m = 0;
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject14))
        {
          aung.b(paramaxei.jdField_b_of_type_JavaLangString, paramaxei.jdField_a_of_type_JavaLangString, "createShortVideoForwardInfo", "md5 shouldn't be empty ");
          return null;
          bool1 = false;
          break;
          label551:
          localObject1 = a((String)localObject18, i10);
          break label503;
          if (!(paramObject instanceof MessageForShortVideo)) {
            break label2434;
          }
          localObject16 = (MessageForShortVideo)paramObject;
          localObject8 = ((MessageForShortVideo)localObject16).frienduin;
          localObject9 = ((MessageForShortVideo)localObject16).frienduin;
          j = ((MessageForShortVideo)localObject16).istroop;
          k = ((MessageForShortVideo)localObject16).videoFileSize;
          m = ((MessageForShortVideo)localObject16).videoFileTime;
          localObject1 = ((MessageForShortVideo)localObject16).videoFileName;
          localObject10 = ShortVideoUtils.a(((MessageForShortVideo)localObject16).thumbMD5, "jpg");
          localObject7 = ((MessageForShortVideo)localObject16).md5;
          localObject11 = ((MessageForShortVideo)localObject16).mLocalMd5;
          i = ((MessageForShortVideo)localObject16).thumbWidth;
          n = ((MessageForShortVideo)localObject16).thumbHeight;
          localObject6 = ((MessageForShortVideo)localObject16).thumbMD5;
          localObject12 = ((MessageForShortVideo)localObject16).fileSource;
          localObject13 = ((MessageForShortVideo)localObject16).uuid;
          i1 = ((MessageForShortVideo)localObject16).videoFileFormat;
          i6 = ((MessageForShortVideo)localObject16).thumbFileSize;
          i2 = ((MessageForShortVideo)localObject16).fromChatType;
          i7 = ((MessageForShortVideo)localObject16).toChatType;
          i3 = ((MessageForShortVideo)localObject16).busiType;
          localObject14 = ShortVideoUtils.d((MessageForShortVideo)localObject16);
          bool2 = ((MessageForShortVideo)localObject16).supportProgressive;
          i4 = ((MessageForShortVideo)localObject16).fileWidth;
          i8 = ((MessageForShortVideo)localObject16).fileHeight;
          i5 = ((MessageForShortVideo)localObject16).specialVideoType;
          i9 = ((MessageForShortVideo)localObject16).msgTailType;
          l = ((MessageForShortVideo)localObject16).uniseq;
          bool1 = ((MessageForShortVideo)localObject16).isStoryVideo;
          if (((MessageForShortVideo)localObject16).CheckIsHotVideo())
          {
            localObject5 = ((MessageForShortVideo)localObject16).hotVideoIconUrl;
            localObject3 = ((MessageForShortVideo)localObject16).hotVideoTitle;
            localObject4 = ((MessageForShortVideo)localObject16).hotVideoUrl;
            localObject2 = ((MessageForShortVideo)localObject16).hotVideoSubIconUrl;
          }
          localObject15 = ((MessageForShortVideo)localObject16).templateId;
          if (paramaxei.jdField_b_of_type_Int == 5) {
            break label2204;
          }
          i10 = ((MessageForShortVideo)localObject16).redBagType;
          if (i10 != LocalMediaInfo.REDBAG_TYPE_GET) {
            break label1977;
          }
          if ((!"0".equals("0")) && ("0".equals(localObject8)))
          {
            str = ((MessageForShortVideo)localObject16).shortVideoId;
            localObject22 = localObject15;
            i13 = i10;
            bool4 = false;
            i14 = i9;
            bool3 = bool2;
            localObject19 = localObject14;
            localObject14 = localObject1;
            i18 = i5;
            i15 = i4;
            localObject24 = "0";
            i16 = i3;
            i5 = i2;
            i4 = i1;
            localObject16 = localObject13;
            i12 = n;
            localObject13 = localObject11;
            localObject15 = localObject10;
            i9 = m;
            i11 = k;
            i10 = j;
            localObject17 = localObject9;
            localObject18 = localObject8;
            localObject21 = localObject7;
            localObject20 = localObject1;
            i19 = -1;
            localObject23 = localObject6;
            i17 = i;
            localObject7 = str;
            bool2 = bool1;
            localObject8 = localObject2;
            localObject6 = localObject22;
            bool1 = bool4;
            i = i13;
            n = i14;
            i1 = i18;
            localObject1 = localObject4;
            localObject2 = localObject3;
            localObject3 = localObject8;
            localObject4 = localObject5;
            i2 = i8;
            i3 = i15;
            localObject5 = localObject24;
            localObject8 = localObject19;
            j = i16;
            k = i7;
            m = i5;
            i5 = i6;
            i6 = i4;
            localObject9 = localObject14;
            localObject10 = localObject16;
            i4 = i19;
            localObject11 = localObject12;
            localObject12 = localObject23;
            i7 = i12;
            i8 = i17;
            localObject14 = localObject21;
            localObject16 = localObject20;
            continue;
          }
          str = a((String)localObject8, j);
          localObject22 = localObject15;
          i13 = i10;
          bool4 = false;
          i14 = i9;
          bool3 = bool2;
          localObject19 = localObject14;
          localObject14 = localObject1;
          i18 = i5;
          i15 = i4;
          localObject24 = "0";
          i16 = i3;
          i5 = i2;
          i4 = i1;
          localObject16 = localObject13;
          i12 = n;
          localObject13 = localObject11;
          localObject15 = localObject10;
          i9 = m;
          i11 = k;
          i10 = j;
          localObject17 = localObject9;
          localObject18 = localObject8;
          localObject21 = localObject7;
          localObject20 = localObject1;
          i19 = -1;
          localObject23 = localObject6;
          i17 = i;
          localObject7 = str;
          bool2 = bool1;
          localObject8 = localObject2;
          localObject6 = localObject22;
          bool1 = bool4;
          i = i13;
          n = i14;
          i1 = i18;
          localObject1 = localObject4;
          localObject2 = localObject3;
          localObject3 = localObject8;
          localObject4 = localObject5;
          i2 = i8;
          i3 = i15;
          localObject5 = localObject24;
          localObject8 = localObject19;
          j = i16;
          k = i7;
          m = i5;
          i5 = i6;
          i6 = i4;
          localObject9 = localObject14;
          localObject10 = localObject16;
          i4 = i19;
          localObject11 = localObject12;
          localObject12 = localObject23;
          i7 = i12;
          i8 = i17;
          localObject14 = localObject21;
          localObject16 = localObject20;
          continue;
        }
        localObject19 = new axdv();
        ((axdv)localObject19).jdField_c_of_type_JavaLangString = ((String)localObject18);
        ((axdv)localObject19).jdField_h_of_type_JavaLangString = ((String)localObject16);
        ((axdv)localObject19).jdField_i_of_type_JavaLangString = ((String)localObject15);
        ((axdv)localObject19).jdField_b_of_type_Int = i10;
        ((axdv)localObject19).jdField_d_of_type_JavaLangString = ((String)localObject17);
        ((axdv)localObject19).jdField_i_of_type_Int = i11;
        ((axdv)localObject19).jdField_j_of_type_Int = i9;
        ((axdv)localObject19).jdField_e_of_type_JavaLangString = ((String)localObject14);
        ((axdv)localObject19).jdField_f_of_type_JavaLangString = ((String)localObject13);
        ((axdv)localObject19).jdField_g_of_type_Int = i8;
        ((axdv)localObject19).jdField_h_of_type_Int = i7;
        ((axdv)localObject19).jdField_k_of_type_Int = paramaxei.jdField_a_of_type_Int;
        ((axdv)localObject19).jdField_a_of_type_JavaLangObject = paramObject;
        ((axdv)localObject19).jdField_g_of_type_JavaLangString = ((String)localObject12);
        ((axdv)localObject19).jdField_j_of_type_JavaLangString = ((String)localObject11);
        ((axdv)localObject19).jdField_a_of_type_JavaLangString = ((String)localObject10);
        ((axdv)localObject19).jdField_k_of_type_JavaLangString = ((String)localObject9);
        ((axdv)localObject19).jdField_l_of_type_Int = i6;
        ((axdv)localObject19).jdField_m_of_type_Int = i5;
        ((axdv)localObject19).jdField_a_of_type_Boolean = bool3;
        ((axdv)localObject19).jdField_n_of_type_Int = i3;
        ((axdv)localObject19).jdField_o_of_type_Int = i2;
        ((axdv)localObject19).jdField_l_of_type_JavaLangString = ((String)localObject8);
        if (localObject5 != null)
        {
          ((axdv)localObject19).jdField_m_of_type_JavaLangString = ((String)localObject5);
          ((axdv)localObject19).jdField_b_of_type_Long = l;
          ((axdv)localObject19).jdField_b_of_type_Boolean = bool2;
          localObject5 = localObject4;
          if (localObject4 == null) {
            localObject5 = "";
          }
          ((axdv)localObject19).jdField_n_of_type_JavaLangString = ((String)localObject5);
          localObject4 = localObject2;
          if (localObject2 == null) {
            localObject4 = "";
          }
          ((axdv)localObject19).p = ((String)localObject4);
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          ((axdv)localObject19).jdField_q_of_type_JavaLangString = ((String)localObject2);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          ((axdv)localObject19).jdField_o_of_type_JavaLangString = ((String)localObject1);
          ((axdv)localObject19).jdField_q_of_type_Int = i1;
          ((axdv)localObject19).jdField_r_of_type_Int = n;
          if (2 == paramaxei.jdField_b_of_type_Int)
          {
            ((axdv)localObject19).jdField_s_of_type_Int = i;
            ((axdv)localObject19).jdField_r_of_type_JavaLangString = ((String)localObject7);
          }
          ((axdv)localObject19).jdField_c_of_type_Boolean = bool1;
          ((axdv)localObject19).jdField_s_of_type_JavaLangString = ((String)localObject6);
          if (!(paramObject instanceof Intent)) {
            break label1837;
          }
          if (i4 != 0) {
            break label1764;
          }
          k = 0;
          label1667:
          if (i10 != 0) {
            break label1796;
          }
          i = 0;
          n = k;
          label1678:
          if (i4 != 1008) {
            break label1919;
          }
          k = 1007;
        }
        for (;;)
        {
          ((axdv)localObject19).jdField_c_of_type_Int = n;
          ((axdv)localObject19).jdField_d_of_type_Int = i;
          ((axdv)localObject19).jdField_e_of_type_Int = k;
          ((axdv)localObject19).jdField_f_of_type_Int = j;
          aung.a(paramaxei.jdField_b_of_type_JavaLangString, paramaxei.jdField_a_of_type_JavaLangString, "createShortVideoForwardInfo", "" + ((axdv)localObject19).a());
          return localObject19;
          localObject5 = "0";
          break;
          label1764:
          if (i4 == 1)
          {
            k = 1;
            break label1667;
          }
          if (i4 == 3000)
          {
            k = 2;
            break label1667;
          }
          k = 3;
          break label1667;
          label1796:
          if (i10 == 1)
          {
            i = 1;
            n = k;
            break label1678;
          }
          if (i10 == 3000)
          {
            i = 2;
            n = k;
            break label1678;
          }
          i = 3;
          n = k;
          break label1678;
          label1837:
          i = k;
          n = m;
          if (!(paramObject instanceof MessageForShortVideo)) {
            break label1678;
          }
          i = k;
          n = m;
          if (k != -1) {
            break label1678;
          }
          if (i10 == 0)
          {
            i = 0;
            n = m;
            break label1678;
          }
          if (i10 == 1)
          {
            i = 1;
            n = m;
            break label1678;
          }
          if (i10 == 3000)
          {
            i = 2;
            n = m;
            break label1678;
          }
          i = 3;
          n = m;
          break label1678;
          label1919:
          if (2 == paramaxei.jdField_b_of_type_Int)
          {
            j = 1;
            k = 1;
          }
          else if (3 == paramaxei.jdField_b_of_type_Int)
          {
            j = 2;
            k = 2;
          }
          else if (5 == paramaxei.jdField_b_of_type_Int)
          {
            k = j;
          }
          else
          {
            j = 0;
            k = 0;
          }
        }
        label1977:
        Object localObject22 = localObject15;
        int i13 = i10;
        boolean bool4 = false;
        int i14 = i9;
        bool3 = bool2;
        localObject19 = localObject14;
        localObject14 = localObject1;
        int i18 = i5;
        int i15 = i4;
        Object localObject24 = "0";
        int i16 = i3;
        i5 = i2;
        i4 = i1;
        localObject16 = localObject13;
        int i12 = n;
        localObject13 = localObject11;
        localObject15 = localObject10;
        i9 = m;
        i11 = k;
        i10 = j;
        localObject17 = localObject9;
        localObject18 = localObject8;
        Object localObject21 = localObject7;
        Object localObject20 = localObject1;
        int i19 = -1;
        Object localObject23 = localObject6;
        int i17 = i;
        localObject7 = "";
        bool2 = bool1;
        localObject8 = localObject2;
        localObject6 = localObject22;
        bool1 = bool4;
        i = i13;
        n = i14;
        i1 = i18;
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject3 = localObject8;
        localObject4 = localObject5;
        i2 = i8;
        i3 = i15;
        localObject5 = localObject24;
        localObject8 = localObject19;
        j = i16;
        k = i7;
        m = i5;
        i5 = i6;
        i6 = i4;
        localObject9 = localObject14;
        localObject10 = localObject16;
        i4 = i19;
        localObject11 = localObject12;
        localObject12 = localObject23;
        i7 = i12;
        i8 = i17;
        localObject14 = localObject21;
        localObject16 = localObject20;
        continue;
        label2204:
        localObject23 = localObject15;
        localObject21 = localObject4;
        i18 = 0;
        bool4 = false;
        i13 = i9;
        localObject4 = localObject5;
        bool3 = bool2;
        localObject20 = localObject14;
        localObject14 = localObject1;
        bool2 = bool1;
        i17 = i5;
        i14 = i4;
        String str = "0";
        i15 = i3;
        i5 = i2;
        i4 = i1;
        localObject16 = localObject13;
        i12 = n;
        localObject13 = localObject11;
        localObject15 = localObject10;
        i9 = m;
        i11 = k;
        i10 = j;
        localObject17 = localObject9;
        localObject18 = localObject8;
        localObject19 = localObject1;
        i19 = -1;
        localObject24 = localObject6;
        i16 = i;
        localObject22 = localObject7;
        localObject5 = localObject2;
        localObject2 = localObject3;
        localObject7 = "";
        localObject6 = localObject23;
        bool1 = bool4;
        i = i18;
        n = i13;
        i1 = i17;
        localObject1 = localObject21;
        localObject3 = localObject5;
        i2 = i8;
        i3 = i14;
        localObject5 = str;
        localObject8 = localObject20;
        j = i15;
        k = i7;
        m = i5;
        i5 = i6;
        i6 = i4;
        localObject9 = localObject14;
        localObject10 = localObject16;
        i4 = i19;
        localObject11 = localObject12;
        localObject12 = localObject24;
        i7 = i12;
        i8 = i16;
        localObject14 = localObject22;
        localObject16 = localObject19;
        continue;
        label2434:
        n = 0;
        localObject2 = "";
        localObject7 = "";
        bool2 = false;
        i = 0;
        localObject4 = "";
        localObject3 = "";
        l = 0L;
        localObject1 = "";
        i1 = 0;
        bool1 = false;
        j = 0;
        k = 0;
        m = 0;
        i5 = 0;
        localObject8 = "0";
        localObject5 = "0";
        localObject12 = "";
        localObject11 = "";
        i4 = -1;
      }
      label2505:
      localObject1 = "";
    }
  }
  
  public axey a(Object paramObject, axei paramaxei)
  {
    if (paramObject == null)
    {
      aung.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    String str5 = "0";
    String str4 = "0";
    int i5 = 0;
    long l2 = 0L;
    int i4 = 0;
    int i3 = 0;
    String str3 = "";
    String str2 = "";
    String str1 = "";
    Object localObject11 = "";
    int i2 = 0;
    int i1 = 0;
    Object localObject10 = "";
    Object localObject9 = "";
    boolean bool4 = false;
    int n = 0;
    int m = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject8;
    Object localObject6;
    Object localObject5;
    Object localObject7;
    Object localObject3;
    long l1;
    int k;
    Object localObject4;
    int j;
    int i;
    boolean bool1;
    Object localObject12;
    if ((paramObject instanceof Intent))
    {
      localObject2 = (Intent)paramObject;
      str5 = ((Intent)localObject2).getStringExtra("uin");
      str4 = ((Intent)localObject2).getStringExtra("troop_uin");
      i5 = ((Intent)localObject2).getIntExtra("uintype", 1003);
      l2 = ((Intent)localObject2).getLongExtra("file_send_size", 0L);
      i4 = ((Intent)localObject2).getIntExtra("file_send_business_type", 0);
      i3 = ((Intent)localObject2).getIntExtra("file_send_duration", -1);
      str3 = ((Intent)localObject2).getStringExtra("file_send_path");
      str2 = ((Intent)localObject2).getStringExtra("thumbfile_send_path");
      localObject11 = ((Intent)localObject2).getStringExtra("file_shortvideo_md5");
      i2 = ((Intent)localObject2).getIntExtra("thumbfile_send_width", 0);
      i1 = ((Intent)localObject2).getIntExtra("thumbfile_send_height", 0);
      localObject10 = ((Intent)localObject2).getStringExtra("thumbfile_md5");
      localObject9 = ((Intent)localObject2).getStringExtra("file_source");
      str1 = ((Intent)localObject2).getStringExtra("file_video_source_dir");
      bool4 = ((Intent)localObject2).getBooleanExtra("support_progressive", false);
      n = ((Intent)localObject2).getIntExtra("file_width", 0);
      m = ((Intent)localObject2).getIntExtra("file_height", 0);
      bool3 = ((Intent)localObject2).getBooleanExtra("video_sync_to_story", false);
      bool2 = ((Intent)localObject2).getBooleanExtra("mediacodec_encode_enable", false);
      localObject8 = ((Intent)localObject2).getStringExtra("hot_video_icon");
      localObject6 = ((Intent)localObject2).getStringExtra("hot_video_title");
      localObject5 = ((Intent)localObject2).getStringExtra("hot_video_url");
      localObject7 = ((Intent)localObject2).getStringExtra("hot_video_icon_sub");
      localObject3 = ((Intent)localObject2).getStringExtra("file_uuid");
      l1 = ((Intent)localObject2).getLongExtra("file_thumb_Size", 0L);
      k = ((Intent)localObject2).getIntExtra("special_video_type", 0);
      localObject4 = ((Intent)localObject2).getStringExtra("hot_video_name");
      j = ((Intent)localObject2).getIntExtra("short_video_msg_tail_type", 0);
      i = ((Intent)localObject2).getIntExtra("param_key_redbag_type", 0);
      if (i == LocalMediaInfo.REDBAG_TYPE_GET) {
        localObject1 = a(str5, i5);
      }
      bool1 = ((Intent)localObject2).getBooleanExtra("file_raw_size", false);
      localObject12 = ((Intent)localObject2).getStringExtra("widgetinfo");
      localObject2 = localObject1;
      localObject1 = localObject12;
    }
    for (;;)
    {
      localObject12 = new axey();
      ((axey)localObject12).jdField_c_of_type_JavaLangString = str5;
      ((axey)localObject12).jdField_h_of_type_JavaLangString = str3;
      ((axey)localObject12).jdField_j_of_type_JavaLangString = str2;
      ((axey)localObject12).jdField_b_of_type_Int = i5;
      ((axey)localObject12).jdField_d_of_type_JavaLangString = str4;
      ((axey)localObject12).jdField_e_of_type_Int = ((int)l2);
      ((axey)localObject12).jdField_f_of_type_Int = i3;
      ((axey)localObject12).jdField_e_of_type_JavaLangString = ((String)localObject11);
      ((axey)localObject12).jdField_c_of_type_Int = i2;
      ((axey)localObject12).jdField_d_of_type_Int = i1;
      ((axey)localObject12).jdField_g_of_type_Int = paramaxei.jdField_a_of_type_Int;
      ((axey)localObject12).jdField_a_of_type_JavaLangObject = paramObject;
      ((axey)localObject12).jdField_g_of_type_JavaLangString = ((String)localObject10);
      ((axey)localObject12).jdField_l_of_type_JavaLangString = ((String)localObject9);
      ((axey)localObject12).jdField_k_of_type_JavaLangString = str1;
      ((axey)localObject12).jdField_a_of_type_Int = i4;
      ((axey)localObject12).jdField_b_of_type_Boolean = bool4;
      ((axey)localObject12).jdField_h_of_type_Int = n;
      ((axey)localObject12).jdField_i_of_type_Int = m;
      ((axey)localObject12).jdField_g_of_type_Boolean = bool3;
      ((axey)localObject12).jdField_c_of_type_Boolean = bool2;
      ((axey)localObject12).jdField_m_of_type_JavaLangString = ((String)localObject8);
      ((axey)localObject12).jdField_o_of_type_JavaLangString = ((String)localObject6);
      ((axey)localObject12).p = ((String)localObject5);
      ((axey)localObject12).jdField_n_of_type_JavaLangString = ((String)localObject7);
      ((axey)localObject12).jdField_a_of_type_JavaLangString = ((String)localObject3);
      ((axey)localObject12).jdField_b_of_type_Long = l1;
      ((axey)localObject12).jdField_j_of_type_Int = k;
      ((axey)localObject12).jdField_q_of_type_JavaLangString = ((String)localObject4);
      ((axey)localObject12).jdField_k_of_type_Int = j;
      ((axey)localObject12).jdField_l_of_type_Int = i;
      ((axey)localObject12).jdField_r_of_type_JavaLangString = ((String)localObject2);
      ((axey)localObject12).jdField_h_of_type_Boolean = bool1;
      ((axey)localObject12).jdField_s_of_type_JavaLangString = ((String)localObject1);
      aung.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "createShortVideoUploadInfo", "");
      return localObject12;
      if ((paramObject instanceof MessageForShortVideo))
      {
        localObject7 = (MessageForShortVideo)paramObject;
        str5 = ((MessageForShortVideo)localObject7).frienduin;
        str4 = ((MessageForShortVideo)localObject7).frienduin;
        i5 = ((MessageForShortVideo)localObject7).istroop;
        l2 = ((MessageForShortVideo)localObject7).videoFileSize;
        i4 = paramaxei.jdField_b_of_type_Int;
        i3 = ((MessageForShortVideo)localObject7).videoFileTime;
        str3 = ((MessageForShortVideo)localObject7).videoFileName;
        str2 = ShortVideoUtils.a(((MessageForShortVideo)localObject7).thumbMD5, "jpg");
        localObject12 = ((MessageForShortVideo)localObject7).md5;
        i2 = ((MessageForShortVideo)localObject7).thumbWidth;
        i1 = ((MessageForShortVideo)localObject7).thumbHeight;
        String str6 = ((MessageForShortVideo)localObject7).thumbMD5;
        String str7 = ((MessageForShortVideo)localObject7).fileSource;
        str1 = ((MessageForShortVideo)localObject7).mVideoFileSourceDir;
        bool4 = ((MessageForShortVideo)localObject7).supportProgressive;
        n = ((MessageForShortVideo)localObject7).fileWidth;
        m = ((MessageForShortVideo)localObject7).fileHeight;
        bool3 = ((MessageForShortVideo)localObject7).syncToStory;
        bool2 = ((MessageForShortVideo)localObject7).mediacodecEncode;
        if (((MessageForShortVideo)localObject7).CheckIsHotVideo())
        {
          localObject1 = ((MessageForShortVideo)localObject7).hotVideoIconUrl;
          localObject4 = ((MessageForShortVideo)localObject7).hotVideoTitle;
          localObject3 = ((MessageForShortVideo)localObject7).hotVideoUrl;
          localObject2 = ((MessageForShortVideo)localObject7).hotVideoSubIconUrl;
          localObject5 = ((MessageForShortVideo)localObject7).videoFileName;
          localObject6 = ((MessageForShortVideo)localObject7).uuid;
        }
        for (;;)
        {
          k = ((MessageForShortVideo)localObject7).specialVideoType;
          j = ((MessageForShortVideo)localObject7).msgTailType;
          i = ((MessageForShortVideo)localObject7).redBagType;
          localObject11 = ((MessageForShortVideo)localObject7).shortVideoId;
          bool1 = ((MessageForShortVideo)localObject7).sendRawVideo;
          String str8 = ((MessageForShortVideo)localObject7).templateId;
          localObject7 = localObject4;
          localObject10 = localObject3;
          localObject8 = localObject2;
          localObject9 = localObject1;
          l1 = -1L;
          localObject1 = str8;
          localObject2 = localObject11;
          localObject3 = localObject6;
          localObject4 = localObject5;
          localObject5 = localObject10;
          localObject6 = localObject7;
          localObject7 = localObject8;
          localObject8 = localObject9;
          localObject9 = str7;
          localObject10 = str6;
          localObject11 = localObject12;
          break;
          localObject6 = null;
          localObject5 = "";
          localObject3 = "";
          localObject4 = "";
          localObject2 = "";
          localObject1 = "";
        }
      }
      localObject3 = null;
      localObject12 = "";
      bool1 = false;
      localObject5 = "";
      j = 0;
      localObject7 = "";
      localObject8 = "";
      l1 = -1L;
      localObject6 = "";
      k = 0;
      i = 0;
      localObject4 = "";
      localObject1 = localObject2;
      localObject2 = localObject12;
    }
  }
  
  public MessageRecord a(axdv paramaxdv)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = axas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaxdv.jdField_c_of_type_JavaLangString, paramaxdv.jdField_d_of_type_JavaLangString, paramaxdv.jdField_b_of_type_Int);
    localMessageForShortVideo.videoFileName = paramaxdv.jdField_h_of_type_JavaLangString;
    if (paramaxdv.jdField_a_of_type_JavaLangString == null) {
      paramaxdv.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.uuid = paramaxdv.jdField_a_of_type_JavaLangString;
    if (paramaxdv.jdField_e_of_type_JavaLangString == null) {
      paramaxdv.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.md5 = paramaxdv.jdField_e_of_type_JavaLangString;
    localMessageForShortVideo.mLocalMd5 = paramaxdv.jdField_f_of_type_JavaLangString;
    localMessageForShortVideo.videoFileName = paramaxdv.jdField_k_of_type_JavaLangString;
    localMessageForShortVideo.videoFileFormat = paramaxdv.jdField_l_of_type_Int;
    localMessageForShortVideo.videoFileSize = paramaxdv.jdField_i_of_type_Int;
    localMessageForShortVideo.videoFileTime = paramaxdv.jdField_j_of_type_Int;
    localMessageForShortVideo.thumbWidth = paramaxdv.jdField_g_of_type_Int;
    localMessageForShortVideo.thumbHeight = paramaxdv.jdField_h_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    label284:
    label341:
    String str;
    if (paramaxdv.jdField_b_of_type_Int == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = paramaxdv.jdField_g_of_type_JavaLangString;
      if (paramaxdv.jdField_j_of_type_JavaLangString == null) {
        paramaxdv.jdField_j_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = paramaxdv.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = paramaxdv.jdField_m_of_type_Int;
      localMessageForShortVideo.busiType = paramaxdv.jdField_f_of_type_Int;
      localMessageForShortVideo.fromChatType = paramaxdv.jdField_c_of_type_Int;
      localMessageForShortVideo.toChatType = paramaxdv.jdField_d_of_type_Int;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = paramaxdv.jdField_a_of_type_Boolean;
      localMessageForShortVideo.fileWidth = paramaxdv.jdField_n_of_type_Int;
      localMessageForShortVideo.fileHeight = paramaxdv.jdField_o_of_type_Int;
      if (paramaxdv.jdField_a_of_type_Axdw == null) {
        break label638;
      }
      i = 1;
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramaxdv.jdField_a_of_type_Axdw.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = paramaxdv.jdField_a_of_type_Axdw.jdField_b_of_type_Long;
        localMessageForShortVideo.msgUid = paramaxdv.jdField_a_of_type_Axdw.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label643;
      }
      localMessageForShortVideo.msg = axds.jdField_b_of_type_JavaLangString;
      if (paramaxdv.jdField_n_of_type_JavaLangString != null) {
        break label654;
      }
      str = "";
      label352:
      localMessageForShortVideo.hotVideoIconUrl = str;
      if (paramaxdv.p != null) {
        break label663;
      }
      str = "";
      label370:
      localMessageForShortVideo.hotVideoTitle = str;
      if (paramaxdv.jdField_q_of_type_JavaLangString != null) {
        break label672;
      }
      str = "";
      label388:
      localMessageForShortVideo.hotVideoUrl = str;
      if (paramaxdv.jdField_o_of_type_JavaLangString != null) {
        break label681;
      }
      str = "";
      label406:
      localMessageForShortVideo.hotVideoSubIconUrl = str;
      localMessageForShortVideo.specialVideoType = paramaxdv.jdField_q_of_type_Int;
      localMessageForShortVideo.msgTailType = paramaxdv.jdField_r_of_type_Int;
      localMessageForShortVideo.redBagType = paramaxdv.jdField_s_of_type_Int;
      localMessageForShortVideo.shortVideoId = paramaxdv.jdField_r_of_type_JavaLangString;
      localMessageForShortVideo.isStoryVideo = paramaxdv.jdField_b_of_type_Boolean;
      if (localMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
        if (!VideoRedbagData.queryRewardStat(localMessageForShortVideo.shortVideoId)) {
          break label690;
        }
      }
    }
    label643:
    label654:
    label663:
    label672:
    label681:
    label690:
    for (int i = 1;; i = 0)
    {
      localMessageForShortVideo.redBagStat = i;
      if (!TextUtils.isEmpty(paramaxdv.jdField_s_of_type_JavaLangString)) {
        localMessageForShortVideo.templateId = paramaxdv.jdField_s_of_type_JavaLangString;
      }
      localMessageForShortVideo.serial();
      paramaxdv.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      aung.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      aung.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (paramaxdv.jdField_b_of_type_Int == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (paramaxdv.jdField_b_of_type_Int != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      label638:
      i = 0;
      break label284;
      localMessageForShortVideo.msg = axds.jdField_a_of_type_JavaLangString;
      break label341;
      str = paramaxdv.jdField_n_of_type_JavaLangString;
      break label352;
      str = paramaxdv.p;
      break label370;
      str = paramaxdv.jdField_q_of_type_JavaLangString;
      break label388;
      str = paramaxdv.jdField_o_of_type_JavaLangString;
      break label406;
    }
  }
  
  public MessageRecord a(axey paramaxey)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    if (paramaxey.jdField_d_of_type_Boolean)
    {
      localMessageForShortVideo = axas.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaxey.jdField_c_of_type_JavaLangString, paramaxey.jdField_d_of_type_JavaLangString, paramaxey.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = paramaxey.jdField_h_of_type_JavaLangString;
    }
    label281:
    label299:
    label319:
    label961:
    label985:
    label992:
    label997:
    label1008:
    for (;;)
    {
      localMessageForShortVideo.specialVideoType = paramaxey.jdField_j_of_type_Int;
      localMessageForShortVideo.msgTailType = paramaxey.jdField_k_of_type_Int;
      localMessageForShortVideo.redBagType = paramaxey.jdField_l_of_type_Int;
      localMessageForShortVideo.shortVideoId = paramaxey.jdField_r_of_type_JavaLangString;
      if (paramaxey.jdField_a_of_type_JavaLangString == null) {
        paramaxey.jdField_a_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.uuid = paramaxey.jdField_a_of_type_JavaLangString;
      if (paramaxey.jdField_e_of_type_JavaLangString == null) {
        paramaxey.jdField_e_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.md5 = paramaxey.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoFileFormat = 2;
      localMessageForShortVideo.videoFileSize = paramaxey.jdField_e_of_type_Int;
      localMessageForShortVideo.videoFileTime = paramaxey.jdField_f_of_type_Int;
      localMessageForShortVideo.thumbWidth = paramaxey.jdField_c_of_type_Int;
      localMessageForShortVideo.thumbHeight = paramaxey.jdField_d_of_type_Int;
      localMessageForShortVideo.mThumbFilePath = paramaxey.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.mVideoFileSourceDir = paramaxey.jdField_k_of_type_JavaLangString;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = paramaxey.jdField_g_of_type_JavaLangString;
      if ((paramaxey.jdField_l_of_type_JavaLangString == null) || (paramaxey.jdField_l_of_type_JavaLangString.length() == 0)) {
        paramaxey.jdField_l_of_type_JavaLangString = "camera";
      }
      localMessageForShortVideo.fileSource = paramaxey.jdField_l_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.mediacodecEncode = paramaxey.jdField_c_of_type_Boolean;
      Object localObject;
      String str;
      int i;
      if (localMessageForShortVideo.istroop == 0)
      {
        localMessageForShortVideo.fileType = 6;
        if (paramaxey.jdField_b_of_type_Int != 1008) {
          break label918;
        }
        localMessageForShortVideo.busiType = 1007;
        if (paramaxey.jdField_b_of_type_Int != 0) {
          break label961;
        }
        amnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo, paramaxey.jdField_c_of_type_JavaLangString);
        localMessageForShortVideo.fromChatType = -1;
        localMessageForShortVideo.toChatType = -1;
        localMessageForShortVideo.uiOperatorFlag = 1;
        localMessageForShortVideo.supportProgressive = paramaxey.jdField_b_of_type_Boolean;
        localMessageForShortVideo.fileWidth = paramaxey.jdField_h_of_type_Int;
        localMessageForShortVideo.fileHeight = paramaxey.jdField_i_of_type_Int;
        localMessageForShortVideo.syncToStory = paramaxey.jdField_g_of_type_Boolean;
        localObject = axaf.jdField_n_of_type_JavaLangString;
        if (!localMessageForShortVideo.syncToStory) {
          break label985;
        }
        str = "1";
        localMessageForShortVideo.saveExtInfoToExtStr((String)localObject, str);
        localMessageForShortVideo.sendRawVideo = paramaxey.jdField_h_of_type_Boolean;
        if (paramaxey.jdField_h_of_type_Boolean) {
          localMessageForShortVideo.saveExtInfoToExtStr(axaf.z, "1");
        }
        if (paramaxey.jdField_a_of_type_Axez == null) {
          break label992;
        }
        i = 1;
        if (i != 0)
        {
          localMessageForShortVideo.msgseq = paramaxey.jdField_a_of_type_Axez.jdField_a_of_type_Long;
          localMessageForShortVideo.shmsgseq = paramaxey.jdField_a_of_type_Axez.jdField_b_of_type_Long;
          localMessageForShortVideo.msgUid = paramaxey.jdField_a_of_type_Axez.jdField_c_of_type_Long;
        }
        if (localMessageForShortVideo.busiType != 2) {
          break label997;
        }
      }
      for (localMessageForShortVideo.msg = axds.jdField_b_of_type_JavaLangString;; localMessageForShortVideo.msg = axds.jdField_a_of_type_JavaLangString)
      {
        if (!TextUtils.isEmpty(paramaxey.jdField_s_of_type_JavaLangString)) {
          localMessageForShortVideo.templateId = paramaxey.jdField_s_of_type_JavaLangString;
        }
        localMessageForShortVideo.serial();
        paramaxey.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
        aung.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        aung.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
        return localMessageForShortVideo;
        if (paramaxey.jdField_e_of_type_Boolean)
        {
          localMessageForShortVideo = axas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaxey.jdField_c_of_type_JavaLangString, paramaxey.jdField_d_of_type_JavaLangString, paramaxey.jdField_b_of_type_Int);
          localMessageForShortVideo.subBusiType = 0;
          localMessageForShortVideo.hotVideoIconUrl = paramaxey.jdField_m_of_type_JavaLangString;
          localMessageForShortVideo.hotVideoTitle = paramaxey.jdField_o_of_type_JavaLangString;
          localMessageForShortVideo.hotVideoUrl = paramaxey.p;
          localMessageForShortVideo.hotVideoSubIconUrl = paramaxey.jdField_n_of_type_JavaLangString;
          localMessageForShortVideo.videoFileName = paramaxey.jdField_q_of_type_JavaLangString;
          localMessageForShortVideo.videoAttr = 0;
          localMessageForShortVideo.videoKandianType = 0;
          if ((localMessageForShortVideo.videoFileName != null) && (localMessageForShortVideo.videoFileName.length() != 0)) {
            break label1008;
          }
          localObject = new StringBuilder();
          if ((paramaxey.jdField_e_of_type_JavaLangString == null) || (paramaxey.jdField_e_of_type_JavaLangString.length() == 0)) {}
          for (str = "HotVideo";; str = paramaxey.jdField_e_of_type_JavaLangString)
          {
            localMessageForShortVideo.videoFileName = (str + ".mp4");
            break;
          }
        }
        if (paramaxey.jdField_f_of_type_Boolean)
        {
          localMessageForShortVideo = axas.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaxey.jdField_c_of_type_JavaLangString, paramaxey.jdField_d_of_type_JavaLangString, paramaxey.jdField_b_of_type_Int);
          localMessageForShortVideo.subBusiType = 2;
          localMessageForShortVideo.videoFileName = paramaxey.jdField_h_of_type_JavaLangString;
          break;
        }
        localMessageForShortVideo = axas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaxey.jdField_c_of_type_JavaLangString, paramaxey.jdField_d_of_type_JavaLangString, paramaxey.jdField_b_of_type_Int);
        localMessageForShortVideo.subBusiType = 0;
        localMessageForShortVideo.videoFileName = paramaxey.jdField_h_of_type_JavaLangString;
        break;
        if (localMessageForShortVideo.istroop == 3000)
        {
          localMessageForShortVideo.fileType = 17;
          break label281;
        }
        if (localMessageForShortVideo.istroop != 1) {
          break label281;
        }
        localMessageForShortVideo.fileType = 9;
        break label281;
        if (2 == paramaxey.jdField_a_of_type_Int)
        {
          localMessageForShortVideo.busiType = 1;
          break label299;
        }
        if (3 == paramaxey.jdField_a_of_type_Int)
        {
          localMessageForShortVideo.busiType = 2;
          break label299;
        }
        localMessageForShortVideo.busiType = 0;
        break label299;
        if (paramaxey.jdField_b_of_type_Int != 1) {
          break label319;
        }
        amnr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo, paramaxey.jdField_c_of_type_JavaLangString);
        break label319;
        str = "0";
        break label391;
        i = 0;
        break label436;
      }
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    aung.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void a(auor paramauor)
  {
    aung.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "updateMsg", "resut:" + paramauor);
    if (paramauor != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramauor.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramauor.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramauor.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.thumbFileSize = ((int)paramauor.jdField_c_of_type_Long);
      localMessageForShortVideo.videoAttr = paramauor.jdField_c_of_type_Int;
      localMessageForShortVideo.videoKandianType = paramauor.jdField_d_of_type_Int;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axda
 * JD-Core Version:    0.7.0.1
 */