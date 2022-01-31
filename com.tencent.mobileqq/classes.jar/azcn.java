import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class azcn
  extends BaseShortVideoOprerator
{
  public azcn() {}
  
  public azcn(QQAppInterface paramQQAppInterface)
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
        long l = ayzl.a();
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
  
  public azdi a(Object paramObject, azdx paramazdx)
  {
    if (paramObject == null)
    {
      awiw.b("AioShortVideoOperator", this.jdField_f_of_type_JavaLangString, "createShortVideoForwardInfo", "input == null");
      return null;
    }
    if (paramazdx == null)
    {
      awiw.b("AioShortVideoOperator", this.jdField_f_of_type_JavaLangString, "createShortVideoForwardInfo", "ShortVideoReq == null");
      return null;
    }
    Object localObject19 = "0";
    Object localObject18 = "0";
    int i9 = 0;
    int i11 = 0;
    int i10 = 0;
    Object localObject17 = "";
    Object localObject16 = "";
    Object localObject15 = "";
    Object localObject14 = "";
    int i8 = 0;
    int i7 = 0;
    Object localObject13 = "";
    Object localObject11 = "";
    Object localObject10 = "";
    int i6 = 2;
    boolean bool3 = false;
    int i3 = 0;
    int i2 = 0;
    Object localObject5 = "";
    Object localObject4 = "";
    Object localObject2 = "";
    Object localObject3 = "";
    int i12 = 0;
    Object localObject6 = "";
    Object localObject1;
    Object localObject9;
    int i4;
    Object localObject12;
    int i5;
    Object localObject20;
    int i1;
    int n;
    long l;
    boolean bool2;
    boolean bool1;
    Object localObject7;
    int i;
    if ((paramObject instanceof Intent))
    {
      localObject1 = (Intent)paramObject;
      localObject19 = ((Intent)localObject1).getStringExtra("uin");
      localObject18 = ((Intent)localObject1).getStringExtra("troop_uin");
      i9 = ((Intent)localObject1).getIntExtra("uintype", -1);
      localObject9 = ((Intent)localObject1).getStringExtra("from_uin");
      i4 = ((Intent)localObject1).getIntExtra("from_uin_type", -1);
      localObject5 = ((Intent)localObject1).getStringExtra("from_session_uin");
      ((Intent)localObject1).getIntExtra("from_busi_type", -1);
      i11 = ((Intent)localObject1).getIntExtra("file_send_size", 0);
      i10 = ((Intent)localObject1).getIntExtra("file_send_duration", -1);
      localObject17 = ((Intent)localObject1).getStringExtra("file_send_path");
      localObject16 = ((Intent)localObject1).getStringExtra("thumbfile_send_path");
      localObject15 = ((Intent)localObject1).getStringExtra("file_shortvideo_md5");
      localObject14 = ((Intent)localObject1).getStringExtra("file_shortvideo_local_md5");
      i8 = ((Intent)localObject1).getIntExtra("thumbfile_send_width", 0);
      i7 = ((Intent)localObject1).getIntExtra("thumbfile_send_height", 0);
      localObject13 = ((Intent)localObject1).getStringExtra("thumbfile_md5");
      localObject12 = ((Intent)localObject1).getStringExtra("file_source");
      localObject11 = ((Intent)localObject1).getStringExtra("file_uuid");
      localObject10 = ((Intent)localObject1).getStringExtra("file_name");
      i6 = ((Intent)localObject1).getIntExtra("file_format", 2);
      i5 = ((Intent)localObject1).getIntExtra("file_thumb_Size", 0);
      bool3 = ((Intent)localObject1).getBooleanExtra("support_progressive", false);
      i3 = ((Intent)localObject1).getIntExtra("file_width", 0);
      i2 = ((Intent)localObject1).getIntExtra("file_height", 0);
      localObject4 = ((Intent)localObject1).getStringExtra("hot_video_icon");
      localObject3 = ((Intent)localObject1).getStringExtra("hot_video_title");
      localObject20 = ((Intent)localObject1).getStringExtra("hot_video_url");
      localObject2 = ((Intent)localObject1).getStringExtra("hot_video_icon_sub");
      i1 = ((Intent)localObject1).getIntExtra("special_video_type", 0);
      n = ((Intent)localObject1).getIntExtra("short_video_msg_tail_type", 0);
      l = ((Intent)localObject1).getLongExtra("from_msg_uniseq", 0L);
      bool2 = ((Intent)localObject1).getBooleanExtra("key_story_video_to_recent", false);
      if (((Intent)localObject1).getIntExtra("forward_source_business_type", -1) == 100200)
      {
        bool1 = true;
        localObject7 = ((Intent)localObject1).getStringExtra("widgetinfo");
        localObject6 = ((Intent)localObject1).getStringExtra("key_camera_material_name");
        i = ((Intent)localObject1).getIntExtra("param_key_redbag_type", 0);
        if (i != LocalMediaInfo.REDBAG_TYPE_GET) {
          break label2245;
        }
        if ((((String)localObject5).equals("0")) || (!((String)localObject5).equals(localObject19))) {
          break label567;
        }
        localObject1 = ((Intent)localObject1).getStringExtra("param_key_redbag_video_id");
      }
    }
    for (;;)
    {
      label519:
      Object localObject8 = localObject1;
      localObject1 = localObject20;
      int j = 0;
      int m = 0;
      int k = 0;
      for (;;)
      {
        label567:
        String str1;
        String str2;
        int i15;
        int i16;
        int i17;
        if (TextUtils.isEmpty((CharSequence)localObject15))
        {
          awiw.b(paramazdx.jdField_b_of_type_JavaLangString, paramazdx.jdField_a_of_type_JavaLangString, "createShortVideoForwardInfo", "md5 shouldn't be empty ");
          return null;
          bool1 = false;
          break;
          localObject1 = a((String)localObject19, i9);
          break label519;
          if (!(paramObject instanceof MessageForShortVideo)) {
            break label2174;
          }
          localObject15 = (MessageForShortVideo)paramObject;
          str1 = ((MessageForShortVideo)localObject15).frienduin;
          str2 = ((MessageForShortVideo)localObject15).frienduin;
          i15 = ((MessageForShortVideo)localObject15).istroop;
          i16 = ((MessageForShortVideo)localObject15).videoFileSize;
          i17 = ((MessageForShortVideo)localObject15).videoFileTime;
          localObject1 = ((MessageForShortVideo)localObject15).videoFileName;
          localObject7 = ShortVideoUtils.a(((MessageForShortVideo)localObject15).thumbMD5, "jpg");
          localObject8 = ((MessageForShortVideo)localObject15).md5;
          localObject9 = ((MessageForShortVideo)localObject15).mLocalMd5;
          i = ((MessageForShortVideo)localObject15).thumbWidth;
          j = ((MessageForShortVideo)localObject15).thumbHeight;
          localObject10 = ((MessageForShortVideo)localObject15).thumbMD5;
          localObject11 = ((MessageForShortVideo)localObject15).fileSource;
          localObject6 = ((MessageForShortVideo)localObject15).uuid;
          k = ((MessageForShortVideo)localObject15).videoFileFormat;
          m = ((MessageForShortVideo)localObject15).thumbFileSize;
          n = ((MessageForShortVideo)localObject15).fromChatType;
          i1 = ((MessageForShortVideo)localObject15).toChatType;
          i2 = ((MessageForShortVideo)localObject15).busiType;
          localObject12 = ShortVideoUtils.d((MessageForShortVideo)localObject15);
          bool1 = ((MessageForShortVideo)localObject15).supportProgressive;
          i3 = ((MessageForShortVideo)localObject15).fileWidth;
          i4 = ((MessageForShortVideo)localObject15).fileHeight;
          i5 = ((MessageForShortVideo)localObject15).specialVideoType;
          i7 = ((MessageForShortVideo)localObject15).msgTailType;
          l = ((MessageForShortVideo)localObject15).uniseq;
          bool2 = ((MessageForShortVideo)localObject15).isStoryVideo;
          if (((MessageForShortVideo)localObject15).CheckIsHotVideo())
          {
            localObject5 = ((MessageForShortVideo)localObject15).hotVideoIconUrl;
            localObject2 = ((MessageForShortVideo)localObject15).hotVideoTitle;
            localObject3 = ((MessageForShortVideo)localObject15).hotVideoUrl;
            localObject4 = ((MessageForShortVideo)localObject15).hotVideoSubIconUrl;
          }
          localObject13 = ((MessageForShortVideo)localObject15).templateId;
          localObject14 = ((MessageForShortVideo)localObject15).templateName;
          i8 = i12;
          if (paramazdx.jdField_b_of_type_Int == 5) {
            break label1967;
          }
          i6 = ((MessageForShortVideo)localObject15).redBagType;
          i8 = i6;
          if (i6 != LocalMediaInfo.REDBAG_TYPE_GET) {
            break label1967;
          }
          if ((!"0".equals("0")) && ("0".equals(str1)))
          {
            localObject19 = ((MessageForShortVideo)localObject15).shortVideoId;
            localObject21 = localObject14;
            bool4 = false;
            i14 = i6;
            localObject22 = localObject13;
            bool3 = bool1;
            str3 = "0";
            localObject20 = localObject12;
            i6 = i2;
            i10 = i1;
            i11 = n;
            i12 = m;
            i13 = k;
            localObject18 = localObject1;
            i18 = -1;
            localObject12 = localObject11;
            localObject13 = localObject10;
            i8 = j;
            i9 = i;
            localObject14 = localObject9;
            localObject15 = localObject8;
            localObject16 = localObject7;
            localObject17 = localObject1;
            localObject11 = localObject6;
            localObject6 = localObject21;
            localObject7 = localObject22;
            bool1 = bool4;
            localObject8 = localObject19;
            i = i14;
            n = i7;
            i1 = i5;
            localObject1 = localObject3;
            localObject3 = localObject2;
            localObject2 = localObject4;
            localObject4 = localObject5;
            i2 = i4;
            localObject5 = str3;
            localObject9 = localObject20;
            j = i6;
            m = i10;
            k = i11;
            i5 = i12;
            i6 = i13;
            localObject10 = localObject18;
            i4 = i18;
            i7 = i8;
            i8 = i9;
            i10 = i17;
            i11 = i16;
            i9 = i15;
            localObject18 = str2;
            localObject19 = str1;
            continue;
          }
          localObject19 = a(str1, i15);
          localObject21 = localObject14;
          bool4 = false;
          i14 = i6;
          localObject22 = localObject13;
          bool3 = bool1;
          str3 = "0";
          localObject20 = localObject12;
          i6 = i2;
          i10 = i1;
          i11 = n;
          i12 = m;
          i13 = k;
          localObject18 = localObject1;
          i18 = -1;
          localObject12 = localObject11;
          localObject13 = localObject10;
          i8 = j;
          i9 = i;
          localObject14 = localObject9;
          localObject15 = localObject8;
          localObject16 = localObject7;
          localObject17 = localObject1;
          localObject11 = localObject6;
          localObject6 = localObject21;
          localObject7 = localObject22;
          bool1 = bool4;
          localObject8 = localObject19;
          i = i14;
          n = i7;
          i1 = i5;
          localObject1 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject4;
          localObject4 = localObject5;
          i2 = i4;
          localObject5 = str3;
          localObject9 = localObject20;
          j = i6;
          m = i10;
          k = i11;
          i5 = i12;
          i6 = i13;
          localObject10 = localObject18;
          i4 = i18;
          i7 = i8;
          i8 = i9;
          i10 = i17;
          i11 = i16;
          i9 = i15;
          localObject18 = str2;
          localObject19 = str1;
          continue;
        }
        localObject20 = new azdi();
        ((azdi)localObject20).jdField_c_of_type_JavaLangString = ((String)localObject19);
        ((azdi)localObject20).jdField_h_of_type_JavaLangString = ((String)localObject17);
        ((azdi)localObject20).jdField_i_of_type_JavaLangString = ((String)localObject16);
        ((azdi)localObject20).jdField_b_of_type_Int = i9;
        ((azdi)localObject20).jdField_d_of_type_JavaLangString = ((String)localObject18);
        ((azdi)localObject20).jdField_i_of_type_Int = i11;
        ((azdi)localObject20).jdField_j_of_type_Int = i10;
        ((azdi)localObject20).jdField_e_of_type_JavaLangString = ((String)localObject15);
        ((azdi)localObject20).jdField_f_of_type_JavaLangString = ((String)localObject14);
        ((azdi)localObject20).jdField_g_of_type_Int = i8;
        ((azdi)localObject20).jdField_h_of_type_Int = i7;
        ((azdi)localObject20).jdField_k_of_type_Int = paramazdx.jdField_a_of_type_Int;
        ((azdi)localObject20).jdField_a_of_type_JavaLangObject = paramObject;
        ((azdi)localObject20).jdField_g_of_type_JavaLangString = ((String)localObject13);
        ((azdi)localObject20).jdField_j_of_type_JavaLangString = ((String)localObject12);
        ((azdi)localObject20).jdField_a_of_type_JavaLangString = ((String)localObject11);
        ((azdi)localObject20).jdField_k_of_type_JavaLangString = ((String)localObject10);
        ((azdi)localObject20).jdField_l_of_type_Int = i6;
        ((azdi)localObject20).jdField_m_of_type_Int = i5;
        ((azdi)localObject20).jdField_a_of_type_Boolean = bool3;
        ((azdi)localObject20).jdField_n_of_type_Int = i3;
        ((azdi)localObject20).jdField_o_of_type_Int = i2;
        ((azdi)localObject20).jdField_l_of_type_JavaLangString = ((String)localObject9);
        if (localObject5 != null)
        {
          ((azdi)localObject20).jdField_m_of_type_JavaLangString = ((String)localObject5);
          ((azdi)localObject20).jdField_b_of_type_Long = l;
          ((azdi)localObject20).jdField_b_of_type_Boolean = bool2;
          localObject5 = localObject4;
          if (localObject4 == null) {
            localObject5 = "";
          }
          ((azdi)localObject20).jdField_n_of_type_JavaLangString = ((String)localObject5);
          localObject4 = localObject3;
          if (localObject3 == null) {
            localObject4 = "";
          }
          ((azdi)localObject20).p = ((String)localObject4);
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = "";
          }
          ((azdi)localObject20).jdField_q_of_type_JavaLangString = ((String)localObject3);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((azdi)localObject20).jdField_o_of_type_JavaLangString = ((String)localObject1);
          ((azdi)localObject20).jdField_q_of_type_Int = i1;
          ((azdi)localObject20).jdField_r_of_type_Int = n;
          if (2 == paramazdx.jdField_b_of_type_Int)
          {
            ((azdi)localObject20).jdField_s_of_type_Int = i;
            ((azdi)localObject20).jdField_r_of_type_JavaLangString = ((String)localObject8);
          }
          ((azdi)localObject20).jdField_c_of_type_Boolean = bool1;
          ((azdi)localObject20).jdField_s_of_type_JavaLangString = ((String)localObject7);
          ((azdi)localObject20).t = ((String)localObject6);
          if (!(paramObject instanceof Intent)) {
            break label1827;
          }
          if (i4 != 0) {
            break label1754;
          }
          k = 0;
          label1657:
          if (i9 != 0) {
            break label1786;
          }
          i = 0;
          n = k;
          label1668:
          if (i4 != 1008) {
            break label1909;
          }
          k = 1007;
        }
        for (;;)
        {
          ((azdi)localObject20).jdField_c_of_type_Int = n;
          ((azdi)localObject20).jdField_d_of_type_Int = i;
          ((azdi)localObject20).jdField_e_of_type_Int = k;
          ((azdi)localObject20).jdField_f_of_type_Int = j;
          awiw.a(paramazdx.jdField_b_of_type_JavaLangString, paramazdx.jdField_a_of_type_JavaLangString, "createShortVideoForwardInfo", "" + ((azdi)localObject20).a());
          return localObject20;
          localObject5 = "0";
          break;
          label1754:
          if (i4 == 1)
          {
            k = 1;
            break label1657;
          }
          if (i4 == 3000)
          {
            k = 2;
            break label1657;
          }
          k = 3;
          break label1657;
          label1786:
          if (i9 == 1)
          {
            i = 1;
            n = k;
            break label1668;
          }
          if (i9 == 3000)
          {
            i = 2;
            n = k;
            break label1668;
          }
          i = 3;
          n = k;
          break label1668;
          label1827:
          i = m;
          n = k;
          if (!(paramObject instanceof MessageForShortVideo)) {
            break label1668;
          }
          i = m;
          n = k;
          if (m != -1) {
            break label1668;
          }
          if (i9 == 0)
          {
            i = 0;
            n = k;
            break label1668;
          }
          if (i9 == 1)
          {
            i = 1;
            n = k;
            break label1668;
          }
          if (i9 == 3000)
          {
            i = 2;
            n = k;
            break label1668;
          }
          i = 3;
          n = k;
          break label1668;
          label1909:
          if (2 == paramazdx.jdField_b_of_type_Int)
          {
            j = 1;
            k = 1;
          }
          else if (3 == paramazdx.jdField_b_of_type_Int)
          {
            j = 2;
            k = 2;
          }
          else if (5 == paramazdx.jdField_b_of_type_Int)
          {
            k = j;
          }
          else
          {
            j = 0;
            k = 0;
          }
        }
        label1967:
        localObject20 = localObject14;
        Object localObject22 = "";
        boolean bool4 = false;
        int i14 = i8;
        Object localObject21 = localObject13;
        bool3 = bool1;
        String str3 = "0";
        localObject19 = localObject12;
        i6 = i2;
        i10 = i1;
        i11 = n;
        i12 = m;
        int i13 = k;
        localObject18 = localObject1;
        int i18 = -1;
        localObject12 = localObject11;
        localObject13 = localObject10;
        i8 = j;
        i9 = i;
        localObject14 = localObject9;
        localObject15 = localObject8;
        localObject16 = localObject7;
        localObject17 = localObject1;
        localObject11 = localObject6;
        localObject6 = localObject20;
        localObject7 = localObject21;
        bool1 = bool4;
        localObject8 = localObject22;
        i = i14;
        n = i7;
        i1 = i5;
        localObject1 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject4;
        localObject4 = localObject5;
        i2 = i4;
        localObject5 = str3;
        localObject9 = localObject19;
        j = i6;
        m = i10;
        k = i11;
        i5 = i12;
        i6 = i13;
        localObject10 = localObject18;
        i4 = i18;
        i7 = i8;
        i8 = i9;
        i10 = i17;
        i11 = i16;
        i9 = i15;
        localObject18 = str2;
        localObject19 = str1;
        continue;
        label2174:
        localObject8 = "";
        bool1 = false;
        n = 0;
        i1 = 0;
        localObject4 = "";
        localObject2 = "";
        l = 0L;
        localObject1 = "";
        localObject3 = "";
        bool2 = false;
        localObject7 = "";
        i = 0;
        localObject9 = "0";
        localObject5 = "0";
        m = 0;
        k = 0;
        i5 = 0;
        j = 0;
        localObject12 = "";
        i4 = -1;
      }
      label2245:
      localObject1 = "";
    }
  }
  
  public azen a(Object paramObject, azdx paramazdx)
  {
    if (paramObject == null)
    {
      awiw.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    String str7 = "0";
    String str6 = "0";
    int i5 = 0;
    long l2 = 0L;
    int i4 = 0;
    int i3 = 0;
    String str5 = "";
    String str4 = "";
    String str3 = "";
    String str2 = "";
    int i2 = 0;
    int i1 = 0;
    Object localObject10 = "";
    Object localObject9 = "";
    boolean bool4 = false;
    int n = 0;
    int m = 0;
    boolean bool3 = false;
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject3;
    boolean bool2;
    Object localObject8;
    Object localObject6;
    Object localObject5;
    Object localObject7;
    Object localObject4;
    long l1;
    int k;
    String str1;
    int j;
    int i;
    boolean bool1;
    Object localObject11;
    if ((paramObject instanceof Intent))
    {
      localObject3 = (Intent)paramObject;
      str7 = ((Intent)localObject3).getStringExtra("uin");
      str6 = ((Intent)localObject3).getStringExtra("troop_uin");
      i5 = ((Intent)localObject3).getIntExtra("uintype", 1003);
      l2 = ((Intent)localObject3).getLongExtra("file_send_size", 0L);
      i4 = ((Intent)localObject3).getIntExtra("file_send_business_type", 0);
      i3 = ((Intent)localObject3).getIntExtra("file_send_duration", -1);
      str5 = ((Intent)localObject3).getStringExtra("file_send_path");
      str4 = ((Intent)localObject3).getStringExtra("thumbfile_send_path");
      str2 = ((Intent)localObject3).getStringExtra("file_shortvideo_md5");
      i2 = ((Intent)localObject3).getIntExtra("thumbfile_send_width", 0);
      i1 = ((Intent)localObject3).getIntExtra("thumbfile_send_height", 0);
      localObject10 = ((Intent)localObject3).getStringExtra("thumbfile_md5");
      localObject9 = ((Intent)localObject3).getStringExtra("file_source");
      str3 = ((Intent)localObject3).getStringExtra("file_video_source_dir");
      bool4 = ((Intent)localObject3).getBooleanExtra("support_progressive", false);
      n = ((Intent)localObject3).getIntExtra("file_width", 0);
      m = ((Intent)localObject3).getIntExtra("file_height", 0);
      bool3 = ((Intent)localObject3).getBooleanExtra("video_sync_to_story", false);
      bool2 = ((Intent)localObject3).getBooleanExtra("mediacodec_encode_enable", false);
      localObject8 = ((Intent)localObject3).getStringExtra("hot_video_icon");
      localObject6 = ((Intent)localObject3).getStringExtra("hot_video_title");
      localObject5 = ((Intent)localObject3).getStringExtra("hot_video_url");
      localObject7 = ((Intent)localObject3).getStringExtra("hot_video_icon_sub");
      localObject4 = ((Intent)localObject3).getStringExtra("file_uuid");
      l1 = ((Intent)localObject3).getLongExtra("file_thumb_Size", 0L);
      k = ((Intent)localObject3).getIntExtra("special_video_type", 0);
      str1 = ((Intent)localObject3).getStringExtra("hot_video_name");
      j = ((Intent)localObject3).getIntExtra("short_video_msg_tail_type", 0);
      i = ((Intent)localObject3).getIntExtra("param_key_redbag_type", 0);
      if (i == LocalMediaInfo.REDBAG_TYPE_GET) {
        localObject1 = a(str7, i5);
      }
      bool1 = ((Intent)localObject3).getBooleanExtra("file_raw_size", false);
      localObject2 = ((Intent)localObject3).getStringExtra("widgetinfo");
      localObject11 = ((Intent)localObject3).getStringExtra("key_camera_material_name");
      localObject3 = localObject1;
      localObject1 = localObject11;
    }
    for (;;)
    {
      localObject11 = new azen();
      ((azen)localObject11).jdField_c_of_type_JavaLangString = str7;
      ((azen)localObject11).jdField_h_of_type_JavaLangString = str5;
      ((azen)localObject11).jdField_j_of_type_JavaLangString = str4;
      ((azen)localObject11).jdField_b_of_type_Int = i5;
      ((azen)localObject11).jdField_d_of_type_JavaLangString = str6;
      ((azen)localObject11).jdField_e_of_type_Int = ((int)l2);
      ((azen)localObject11).jdField_f_of_type_Int = i3;
      ((azen)localObject11).jdField_e_of_type_JavaLangString = str2;
      ((azen)localObject11).jdField_c_of_type_Int = i2;
      ((azen)localObject11).jdField_d_of_type_Int = i1;
      ((azen)localObject11).jdField_g_of_type_Int = paramazdx.jdField_a_of_type_Int;
      ((azen)localObject11).jdField_a_of_type_JavaLangObject = paramObject;
      ((azen)localObject11).jdField_g_of_type_JavaLangString = ((String)localObject10);
      ((azen)localObject11).jdField_l_of_type_JavaLangString = ((String)localObject9);
      ((azen)localObject11).jdField_k_of_type_JavaLangString = str3;
      ((azen)localObject11).jdField_a_of_type_Int = i4;
      ((azen)localObject11).jdField_b_of_type_Boolean = bool4;
      ((azen)localObject11).jdField_h_of_type_Int = n;
      ((azen)localObject11).jdField_i_of_type_Int = m;
      ((azen)localObject11).jdField_g_of_type_Boolean = bool3;
      ((azen)localObject11).jdField_c_of_type_Boolean = bool2;
      ((azen)localObject11).jdField_m_of_type_JavaLangString = ((String)localObject8);
      ((azen)localObject11).jdField_o_of_type_JavaLangString = ((String)localObject6);
      ((azen)localObject11).p = ((String)localObject5);
      ((azen)localObject11).jdField_n_of_type_JavaLangString = ((String)localObject7);
      ((azen)localObject11).jdField_a_of_type_JavaLangString = ((String)localObject4);
      ((azen)localObject11).jdField_b_of_type_Long = l1;
      ((azen)localObject11).jdField_j_of_type_Int = k;
      ((azen)localObject11).jdField_q_of_type_JavaLangString = str1;
      ((azen)localObject11).jdField_k_of_type_Int = j;
      ((azen)localObject11).jdField_l_of_type_Int = i;
      ((azen)localObject11).jdField_r_of_type_JavaLangString = ((String)localObject3);
      ((azen)localObject11).jdField_h_of_type_Boolean = bool1;
      ((azen)localObject11).jdField_s_of_type_JavaLangString = ((String)localObject2);
      ((azen)localObject11).t = ((String)localObject1);
      awiw.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "createShortVideoUploadInfo", "");
      return localObject11;
      if ((paramObject instanceof MessageForShortVideo))
      {
        localObject6 = (MessageForShortVideo)paramObject;
        str7 = ((MessageForShortVideo)localObject6).frienduin;
        str6 = ((MessageForShortVideo)localObject6).frienduin;
        i5 = ((MessageForShortVideo)localObject6).istroop;
        l2 = ((MessageForShortVideo)localObject6).videoFileSize;
        i4 = paramazdx.jdField_b_of_type_Int;
        i3 = ((MessageForShortVideo)localObject6).videoFileTime;
        str5 = ((MessageForShortVideo)localObject6).videoFileName;
        str4 = ShortVideoUtils.a(((MessageForShortVideo)localObject6).thumbMD5, "jpg");
        str2 = ((MessageForShortVideo)localObject6).md5;
        i2 = ((MessageForShortVideo)localObject6).thumbWidth;
        i1 = ((MessageForShortVideo)localObject6).thumbHeight;
        localObject11 = ((MessageForShortVideo)localObject6).thumbMD5;
        String str8 = ((MessageForShortVideo)localObject6).fileSource;
        str3 = ((MessageForShortVideo)localObject6).mVideoFileSourceDir;
        bool4 = ((MessageForShortVideo)localObject6).supportProgressive;
        n = ((MessageForShortVideo)localObject6).fileWidth;
        m = ((MessageForShortVideo)localObject6).fileHeight;
        bool3 = ((MessageForShortVideo)localObject6).syncToStory;
        bool2 = ((MessageForShortVideo)localObject6).mediacodecEncode;
        if (((MessageForShortVideo)localObject6).CheckIsHotVideo())
        {
          localObject4 = ((MessageForShortVideo)localObject6).hotVideoIconUrl;
          localObject2 = ((MessageForShortVideo)localObject6).hotVideoTitle;
          localObject1 = ((MessageForShortVideo)localObject6).hotVideoUrl;
          localObject3 = ((MessageForShortVideo)localObject6).hotVideoSubIconUrl;
          str1 = ((MessageForShortVideo)localObject6).videoFileName;
          localObject5 = ((MessageForShortVideo)localObject6).uuid;
        }
        for (;;)
        {
          k = ((MessageForShortVideo)localObject6).specialVideoType;
          j = ((MessageForShortVideo)localObject6).msgTailType;
          i = ((MessageForShortVideo)localObject6).redBagType;
          String str9 = ((MessageForShortVideo)localObject6).shortVideoId;
          bool1 = ((MessageForShortVideo)localObject6).sendRawVideo;
          localObject9 = ((MessageForShortVideo)localObject6).templateId;
          String str10 = ((MessageForShortVideo)localObject6).templateName;
          l1 = -1L;
          localObject8 = localObject4;
          localObject7 = localObject3;
          localObject6 = localObject2;
          localObject10 = localObject1;
          localObject3 = str9;
          localObject1 = str10;
          localObject2 = localObject9;
          localObject4 = localObject5;
          localObject5 = localObject10;
          localObject9 = str8;
          localObject10 = localObject11;
          break;
          localObject5 = null;
          str1 = "";
          localObject1 = "";
          localObject2 = "";
          localObject3 = "";
          localObject4 = "";
        }
      }
      l1 = -1L;
      localObject8 = "";
      bool2 = false;
      localObject4 = null;
      localObject7 = "";
      k = 0;
      bool1 = false;
      localObject6 = "";
      j = 0;
      localObject5 = "";
      i = 0;
      str1 = "";
      localObject3 = "";
      localObject11 = "";
      localObject1 = localObject2;
      localObject2 = localObject11;
    }
  }
  
  public MessageRecord a(azdi paramazdi)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = azaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazdi.jdField_c_of_type_JavaLangString, paramazdi.jdField_d_of_type_JavaLangString, paramazdi.jdField_b_of_type_Int);
    localMessageForShortVideo.videoFileName = paramazdi.jdField_h_of_type_JavaLangString;
    if (paramazdi.jdField_a_of_type_JavaLangString == null) {
      paramazdi.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.uuid = paramazdi.jdField_a_of_type_JavaLangString;
    if (paramazdi.jdField_e_of_type_JavaLangString == null) {
      paramazdi.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.md5 = paramazdi.jdField_e_of_type_JavaLangString;
    localMessageForShortVideo.mLocalMd5 = paramazdi.jdField_f_of_type_JavaLangString;
    localMessageForShortVideo.videoFileName = paramazdi.jdField_k_of_type_JavaLangString;
    localMessageForShortVideo.videoFileFormat = paramazdi.jdField_l_of_type_Int;
    localMessageForShortVideo.videoFileSize = paramazdi.jdField_i_of_type_Int;
    localMessageForShortVideo.videoFileTime = paramazdi.jdField_j_of_type_Int;
    localMessageForShortVideo.thumbWidth = paramazdi.jdField_g_of_type_Int;
    localMessageForShortVideo.thumbHeight = paramazdi.jdField_h_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    label284:
    label341:
    String str;
    if (paramazdi.jdField_b_of_type_Int == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = paramazdi.jdField_g_of_type_JavaLangString;
      if (paramazdi.jdField_j_of_type_JavaLangString == null) {
        paramazdi.jdField_j_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = paramazdi.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = paramazdi.jdField_m_of_type_Int;
      localMessageForShortVideo.busiType = paramazdi.jdField_f_of_type_Int;
      localMessageForShortVideo.fromChatType = paramazdi.jdField_c_of_type_Int;
      localMessageForShortVideo.toChatType = paramazdi.jdField_d_of_type_Int;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = paramazdi.jdField_a_of_type_Boolean;
      localMessageForShortVideo.fileWidth = paramazdi.jdField_n_of_type_Int;
      localMessageForShortVideo.fileHeight = paramazdi.jdField_o_of_type_Int;
      if (paramazdi.jdField_a_of_type_Azdj == null) {
        break label647;
      }
      i = 1;
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramazdi.jdField_a_of_type_Azdj.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = paramazdi.jdField_a_of_type_Azdj.jdField_b_of_type_Long;
        localMessageForShortVideo.msgUid = paramazdi.jdField_a_of_type_Azdj.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label652;
      }
      localMessageForShortVideo.msg = azdf.jdField_b_of_type_JavaLangString;
      if (paramazdi.jdField_n_of_type_JavaLangString != null) {
        break label663;
      }
      str = "";
      label352:
      localMessageForShortVideo.hotVideoIconUrl = str;
      if (paramazdi.p != null) {
        break label672;
      }
      str = "";
      label370:
      localMessageForShortVideo.hotVideoTitle = str;
      if (paramazdi.jdField_q_of_type_JavaLangString != null) {
        break label681;
      }
      str = "";
      label388:
      localMessageForShortVideo.hotVideoUrl = str;
      if (paramazdi.jdField_o_of_type_JavaLangString != null) {
        break label690;
      }
      str = "";
      label406:
      localMessageForShortVideo.hotVideoSubIconUrl = str;
      localMessageForShortVideo.specialVideoType = paramazdi.jdField_q_of_type_Int;
      localMessageForShortVideo.msgTailType = paramazdi.jdField_r_of_type_Int;
      localMessageForShortVideo.redBagType = paramazdi.jdField_s_of_type_Int;
      localMessageForShortVideo.shortVideoId = paramazdi.jdField_r_of_type_JavaLangString;
      localMessageForShortVideo.isStoryVideo = paramazdi.jdField_b_of_type_Boolean;
      if (localMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
        if (!VideoRedbagData.queryRewardStat(localMessageForShortVideo.shortVideoId)) {
          break label699;
        }
      }
    }
    label647:
    label652:
    label663:
    label672:
    label681:
    label690:
    label699:
    for (int i = 1;; i = 0)
    {
      localMessageForShortVideo.redBagStat = i;
      if (!TextUtils.isEmpty(paramazdi.jdField_s_of_type_JavaLangString))
      {
        localMessageForShortVideo.templateId = paramazdi.jdField_s_of_type_JavaLangString;
        localMessageForShortVideo.templateName = paramazdi.t;
      }
      localMessageForShortVideo.serial();
      paramazdi.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      awiw.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      awiw.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (paramazdi.jdField_b_of_type_Int == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (paramazdi.jdField_b_of_type_Int != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      i = 0;
      break label284;
      localMessageForShortVideo.msg = azdf.jdField_a_of_type_JavaLangString;
      break label341;
      str = paramazdi.jdField_n_of_type_JavaLangString;
      break label352;
      str = paramazdi.p;
      break label370;
      str = paramazdi.jdField_q_of_type_JavaLangString;
      break label388;
      str = paramazdi.jdField_o_of_type_JavaLangString;
      break label406;
    }
  }
  
  public MessageRecord a(azen paramazen)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    if (paramazen.jdField_d_of_type_Boolean)
    {
      localMessageForShortVideo = azaf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazen.jdField_c_of_type_JavaLangString, paramazen.jdField_d_of_type_JavaLangString, paramazen.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = paramazen.jdField_h_of_type_JavaLangString;
    }
    label281:
    label299:
    label319:
    label970:
    label994:
    label1001:
    label1006:
    label1017:
    for (;;)
    {
      localMessageForShortVideo.specialVideoType = paramazen.jdField_j_of_type_Int;
      localMessageForShortVideo.msgTailType = paramazen.jdField_k_of_type_Int;
      localMessageForShortVideo.redBagType = paramazen.jdField_l_of_type_Int;
      localMessageForShortVideo.shortVideoId = paramazen.jdField_r_of_type_JavaLangString;
      if (paramazen.jdField_a_of_type_JavaLangString == null) {
        paramazen.jdField_a_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.uuid = paramazen.jdField_a_of_type_JavaLangString;
      if (paramazen.jdField_e_of_type_JavaLangString == null) {
        paramazen.jdField_e_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.md5 = paramazen.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoFileFormat = 2;
      localMessageForShortVideo.videoFileSize = paramazen.jdField_e_of_type_Int;
      localMessageForShortVideo.videoFileTime = paramazen.jdField_f_of_type_Int;
      localMessageForShortVideo.thumbWidth = paramazen.jdField_c_of_type_Int;
      localMessageForShortVideo.thumbHeight = paramazen.jdField_d_of_type_Int;
      localMessageForShortVideo.mThumbFilePath = paramazen.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.mVideoFileSourceDir = paramazen.jdField_k_of_type_JavaLangString;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = paramazen.jdField_g_of_type_JavaLangString;
      if ((paramazen.jdField_l_of_type_JavaLangString == null) || (paramazen.jdField_l_of_type_JavaLangString.length() == 0)) {
        paramazen.jdField_l_of_type_JavaLangString = "camera";
      }
      localMessageForShortVideo.fileSource = paramazen.jdField_l_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.mediacodecEncode = paramazen.jdField_c_of_type_Boolean;
      Object localObject;
      String str;
      int i;
      if (localMessageForShortVideo.istroop == 0)
      {
        localMessageForShortVideo.fileType = 6;
        if (paramazen.jdField_b_of_type_Int != 1008) {
          break label927;
        }
        localMessageForShortVideo.busiType = 1007;
        if (paramazen.jdField_b_of_type_Int != 0) {
          break label970;
        }
        aoiy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo, paramazen.jdField_c_of_type_JavaLangString);
        localMessageForShortVideo.fromChatType = -1;
        localMessageForShortVideo.toChatType = -1;
        localMessageForShortVideo.uiOperatorFlag = 1;
        localMessageForShortVideo.supportProgressive = paramazen.jdField_b_of_type_Boolean;
        localMessageForShortVideo.fileWidth = paramazen.jdField_h_of_type_Int;
        localMessageForShortVideo.fileHeight = paramazen.jdField_i_of_type_Int;
        localMessageForShortVideo.syncToStory = paramazen.jdField_g_of_type_Boolean;
        localObject = ayzs.jdField_n_of_type_JavaLangString;
        if (!localMessageForShortVideo.syncToStory) {
          break label994;
        }
        str = "1";
        localMessageForShortVideo.saveExtInfoToExtStr((String)localObject, str);
        localMessageForShortVideo.sendRawVideo = paramazen.jdField_h_of_type_Boolean;
        if (paramazen.jdField_h_of_type_Boolean) {
          localMessageForShortVideo.saveExtInfoToExtStr(ayzs.z, "1");
        }
        if (paramazen.jdField_a_of_type_Azeo == null) {
          break label1001;
        }
        i = 1;
        if (i != 0)
        {
          localMessageForShortVideo.msgseq = paramazen.jdField_a_of_type_Azeo.jdField_a_of_type_Long;
          localMessageForShortVideo.shmsgseq = paramazen.jdField_a_of_type_Azeo.jdField_b_of_type_Long;
          localMessageForShortVideo.msgUid = paramazen.jdField_a_of_type_Azeo.jdField_c_of_type_Long;
        }
        if (localMessageForShortVideo.busiType != 2) {
          break label1006;
        }
      }
      for (localMessageForShortVideo.msg = azdf.jdField_b_of_type_JavaLangString;; localMessageForShortVideo.msg = azdf.jdField_a_of_type_JavaLangString)
      {
        if (!TextUtils.isEmpty(paramazen.jdField_s_of_type_JavaLangString))
        {
          localMessageForShortVideo.templateId = paramazen.jdField_s_of_type_JavaLangString;
          localMessageForShortVideo.templateName = paramazen.t;
        }
        localMessageForShortVideo.serial();
        paramazen.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
        awiw.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        awiw.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
        return localMessageForShortVideo;
        if (paramazen.jdField_e_of_type_Boolean)
        {
          localMessageForShortVideo = azaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazen.jdField_c_of_type_JavaLangString, paramazen.jdField_d_of_type_JavaLangString, paramazen.jdField_b_of_type_Int);
          localMessageForShortVideo.subBusiType = 0;
          localMessageForShortVideo.hotVideoIconUrl = paramazen.jdField_m_of_type_JavaLangString;
          localMessageForShortVideo.hotVideoTitle = paramazen.jdField_o_of_type_JavaLangString;
          localMessageForShortVideo.hotVideoUrl = paramazen.p;
          localMessageForShortVideo.hotVideoSubIconUrl = paramazen.jdField_n_of_type_JavaLangString;
          localMessageForShortVideo.videoFileName = paramazen.jdField_q_of_type_JavaLangString;
          localMessageForShortVideo.videoAttr = 0;
          localMessageForShortVideo.videoKandianType = 0;
          if ((localMessageForShortVideo.videoFileName != null) && (localMessageForShortVideo.videoFileName.length() != 0)) {
            break label1017;
          }
          localObject = new StringBuilder();
          if ((paramazen.jdField_e_of_type_JavaLangString == null) || (paramazen.jdField_e_of_type_JavaLangString.length() == 0)) {}
          for (str = "HotVideo";; str = paramazen.jdField_e_of_type_JavaLangString)
          {
            localMessageForShortVideo.videoFileName = (str + ".mp4");
            break;
          }
        }
        if (paramazen.jdField_f_of_type_Boolean)
        {
          localMessageForShortVideo = azaf.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazen.jdField_c_of_type_JavaLangString, paramazen.jdField_d_of_type_JavaLangString, paramazen.jdField_b_of_type_Int);
          localMessageForShortVideo.subBusiType = 2;
          localMessageForShortVideo.videoFileName = paramazen.jdField_h_of_type_JavaLangString;
          break;
        }
        localMessageForShortVideo = azaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazen.jdField_c_of_type_JavaLangString, paramazen.jdField_d_of_type_JavaLangString, paramazen.jdField_b_of_type_Int);
        localMessageForShortVideo.subBusiType = 0;
        localMessageForShortVideo.videoFileName = paramazen.jdField_h_of_type_JavaLangString;
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
        if (2 == paramazen.jdField_a_of_type_Int)
        {
          localMessageForShortVideo.busiType = 1;
          break label299;
        }
        if (3 == paramazen.jdField_a_of_type_Int)
        {
          localMessageForShortVideo.busiType = 2;
          break label299;
        }
        localMessageForShortVideo.busiType = 0;
        break label299;
        if (paramazen.jdField_b_of_type_Int != 1) {
          break label319;
        }
        aoiy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo, paramazen.jdField_c_of_type_JavaLangString);
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
    awiw.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void a(awki paramawki)
  {
    awiw.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "updateMsg", "resut:" + paramawki);
    if (paramawki != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramawki.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramawki.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramawki.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.thumbFileSize = ((int)paramawki.jdField_c_of_type_Long);
      localMessageForShortVideo.videoAttr = paramawki.jdField_c_of_type_Int;
      localMessageForShortVideo.videoKandianType = paramawki.jdField_d_of_type_Int;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azcn
 * JD-Core Version:    0.7.0.1
 */