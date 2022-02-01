import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aekit.api.standard.GLCapabilities;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import javax.annotation.Nullable;

public class bnqq
{
  public static final Long a;
  public static final Long b;
  public static final Long c;
  public static final Long d;
  public static final Long e;
  public static final Long f;
  public static final Long g;
  private static Long jdField_h_of_type_JavaLangLong = Long.valueOf(-1L);
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private bnqt jdField_a_of_type_Bnqt = new bnqt();
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString = "none";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString = "none";
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = -1;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString = "-1";
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString = "none";
  private long jdField_g_of_type_Long = -1L;
  private String jdField_g_of_type_JavaLangString = "none";
  private long jdField_h_of_type_Long = -1L;
  private String jdField_h_of_type_JavaLangString;
  private long jdField_i_of_type_Long;
  private String jdField_i_of_type_JavaLangString;
  private long jdField_j_of_type_Long = 1L;
  private String jdField_j_of_type_JavaLangString = "none";
  private long jdField_k_of_type_Long = 1L;
  private String jdField_k_of_type_JavaLangString = "none";
  private String l = "none";
  private String m = "#ffffff";
  private String n = "";
  private String o = "none";
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(-1L);
    jdField_b_of_type_JavaLangLong = Long.valueOf(1L);
    jdField_c_of_type_JavaLangLong = Long.valueOf(2L);
    jdField_d_of_type_JavaLangLong = Long.valueOf(3L);
    jdField_e_of_type_JavaLangLong = Long.valueOf(4L);
    jdField_f_of_type_JavaLangLong = Long.valueOf(5L);
    jdField_g_of_type_JavaLangLong = Long.valueOf(6L);
  }
  
  private long a()
  {
    return System.currentTimeMillis() - this.jdField_b_of_type_Long;
  }
  
  public static bnqq a()
  {
    return bnqs.a();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "off";
    }
    if ("#FFFFFF".equals(paramString)) {
      return "white";
    }
    return "ai_color";
  }
  
  private HashMap<String, String> a(String paramString1, int paramInt, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    if ((this.jdField_e_of_type_Int == 4) || (this.jdField_e_of_type_Int == 5) || (this.jdField_e_of_type_Int == 6) || (this.jdField_e_of_type_Int == 7) || (this.jdField_e_of_type_Int == 2))
    {
      localHashMap.put("face_id", this.jdField_d_of_type_JavaLangString);
      localHashMap.put("content_type", jdField_h_of_type_JavaLangLong.toString());
      localHashMap.put("MD5", paramString1);
      paramString1 = new DecimalFormat("0.00").format(this.jdField_b_of_type_Int / 100.0F);
      String str = new DecimalFormat("0.00").format(this.jdField_c_of_type_Int / 100.0F);
      localHashMap.put("beauty_value", paramString1);
      localHashMap.put("facial_value", str);
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label414;
      }
      localHashMap.put("filter_id", this.jdField_b_of_type_JavaLangString);
      label172:
      localHashMap.put("duration", "" + this.jdField_a_of_type_Long);
      localHashMap.put("cameraId", bnqp.a(alps.jdField_a_of_type_Int));
      if (jdField_h_of_type_JavaLangLong.longValue() != 1L) {
        break label427;
      }
      localHashMap.put("resolution", bnep.a.d());
    }
    for (;;)
    {
      localHashMap.put("post_type", String.valueOf(paramInt));
      localHashMap.put("receive_type", paramString2);
      localHashMap.put("face_index", String.valueOf(this.jdField_a_of_type_Int));
      localHashMap.put("face_from", this.jdField_e_of_type_JavaLangString);
      localHashMap.put("face_tab", this.jdField_f_of_type_JavaLangString);
      localHashMap.put("face_type", this.jdField_e_of_type_Int + "");
      if ((this.jdField_e_of_type_Int != 4) && (this.jdField_e_of_type_Int != 5) && (this.jdField_e_of_type_Int != 6) && (this.jdField_e_of_type_Int != 7)) {
        break label470;
      }
      localHashMap.put("face_uin", this.jdField_d_of_type_JavaLangString + UserAction.getQIMEI());
      return localHashMap;
      localHashMap.put("face_id", this.jdField_c_of_type_JavaLangString);
      break;
      label414:
      localHashMap.put("filter_id", "none");
      break label172;
      label427:
      if (jdField_h_of_type_JavaLangLong.longValue() == 2L) {
        localHashMap.put("resolution", bnep.a.g());
      } else {
        localHashMap.put("resolution", "none");
      }
    }
    label470:
    localHashMap.put("face_uin", this.jdField_c_of_type_JavaLangString + UserAction.getQIMEI());
    return localHashMap;
  }
  
  private HashMap<String, String> a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap(6);
    localHashMap.put("face_id", paramString1);
    localHashMap.put("face_tab", this.jdField_f_of_type_JavaLangString);
    localHashMap.put("face_type", this.jdField_e_of_type_Int + "");
    localHashMap.put("face_index", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("face_from", paramString2);
    localHashMap.put("face_uin", paramString1 + UserAction.getQIMEI());
    return localHashMap;
  }
  
  public HashMap<String, String> A()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", bnqp.a(Long.valueOf(this.jdField_i_of_type_Long)));
    localHashMap.put("cutout_type", Long.toString(this.jdField_j_of_type_Long));
    localHashMap.put("countdown_type", Long.toString(this.jdField_k_of_type_Long));
    Object localObject = new DecimalFormat("0.00").format(this.jdField_b_of_type_Int / 100.0F);
    String str = new DecimalFormat("0.00").format(this.jdField_c_of_type_Int / 100.0F);
    localHashMap.put("beauty_value", localObject);
    localHashMap.put("facial_value", str);
    localHashMap.put("cameraId", bnqp.a(alps.jdField_a_of_type_Int));
    localHashMap.put("text_content", this.l);
    if (!localHashMap.containsKey("emoticon_id")) {
      localHashMap.put("emoticon_id", this.jdField_j_of_type_JavaLangString);
    }
    localObject = bpjt.a().c(0);
    if (localObject != null)
    {
      this.jdField_k_of_type_JavaLangString = ((QIMFilterCategoryItem)localObject).jdField_a_of_type_JavaLangString;
      localHashMap.put("filter_id", this.jdField_k_of_type_JavaLangString);
      if (!localHashMap.containsKey("text_color"))
      {
        if (!this.l.equals("none")) {
          break label283;
        }
        localHashMap.put("text_color", "none");
      }
    }
    for (;;)
    {
      if (this.n.equals("")) {
        j();
      }
      localHashMap.put("MD5", this.n);
      if (!TextUtils.isEmpty(this.o)) {
        break label298;
      }
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
      this.jdField_k_of_type_JavaLangString = "none";
      break;
      label283:
      localHashMap.put("text_color", this.m);
    }
    label298:
    localHashMap.put("emo_sort_id", this.o);
    return localHashMap;
  }
  
  public HashMap<String, String> B()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", this.jdField_j_of_type_JavaLangString);
    return localHashMap;
  }
  
  public bnqt a()
  {
    return this.jdField_a_of_type_Bnqt;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public HashMap<String, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public HashMap<String, String> a(float paramFloat, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("change_speed_type", String.valueOf(paramFloat));
    localHashMap.put("change_speed_opin", paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", "-1");
    localHashMap.put("content_type", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_b_of_type_Long));
    localHashMap.put("MD5", this.jdField_a_of_type_Bnqt.jdField_a_of_type_JavaLangString);
    Object localObject2 = (String)this.jdField_a_of_type_Bnqt.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "none";
    }
    localHashMap.put("filter_id", localObject1);
    localObject1 = (Float)this.jdField_a_of_type_Bnqt.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localObject1 == null)
    {
      localObject1 = "none";
      localHashMap.put("filter_value", localObject1);
      localObject2 = (String)this.jdField_a_of_type_Bnqt.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "none";
      }
      localHashMap.put("color_type", localObject1);
      localObject2 = (String)this.jdField_a_of_type_Bnqt.jdField_c_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "none";
      }
      localHashMap.put("ai_color_frame_states", localObject1);
      localObject2 = (String)this.jdField_a_of_type_Bnqt.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "none";
      }
      localHashMap.put("text_item_id", localObject1);
      localHashMap.put("music_id", "none");
      localHashMap.put("sound_type", "0");
      localHashMap.put("video_id", this.jdField_a_of_type_Bnqt.jdField_a_of_type_JavaLangString);
      localObject2 = (Integer)this.jdField_a_of_type_Bnqt.jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Integer.valueOf(-1);
      }
      localHashMap.put("text_count", String.valueOf(localObject1));
      localHashMap.put("face_id", this.jdField_c_of_type_JavaLangString);
      localObject1 = bnkb.b();
      if (localObject1 != null) {
        break label365;
      }
    }
    label365:
    for (localObject1 = "none";; localObject1 = ((bnke)localObject1).jdField_a_of_type_JavaLangString)
    {
      localHashMap.put("watermark_id", localObject1);
      return localHashMap;
      localObject1 = String.valueOf(((Float)localObject1).intValue());
      break;
    }
  }
  
  public HashMap<String, String> a(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", paramString);
    localHashMap.put("emo_num", String.valueOf(paramInt));
    if (TextUtils.isEmpty(this.o))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.o);
    return localHashMap;
  }
  
  public HashMap<String, String> a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ret_code", "" + paramInt1);
    localHashMap.put("req_cost", paramString1);
    localHashMap.put("cmd_id", paramString2);
    localHashMap.put("res_code", String.valueOf(paramInt2));
    return localHashMap;
  }
  
  public HashMap<String, String> a(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    if ((this.jdField_e_of_type_Int == 4) || (this.jdField_e_of_type_Int == 5) || (this.jdField_e_of_type_Int == 6) || (this.jdField_e_of_type_Int == 7) || (this.jdField_e_of_type_Int == 2))
    {
      localHashMap.put("face_id", this.jdField_d_of_type_JavaLangString);
      localHashMap.put("content_type", jdField_h_of_type_JavaLangLong.toString());
      String str1 = new DecimalFormat("0.00").format(this.jdField_b_of_type_Int / 100.0F);
      String str2 = new DecimalFormat("0.00").format(this.jdField_c_of_type_Int / 100.0F);
      localHashMap.put("beauty_value", str1);
      localHashMap.put("facial_value", str2);
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label230;
      }
      localHashMap.put("filter_id", this.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      localHashMap.put("duration", bnqp.a(Long.valueOf(System.currentTimeMillis() - paramLong)));
      localHashMap.put("cameraId", bnqp.a(alps.jdField_a_of_type_Int));
      if (jdField_h_of_type_JavaLangLong.longValue() != 1L) {
        break label242;
      }
      localHashMap.put("resolution", bnep.a.d());
      return localHashMap;
      localHashMap.put("face_id", this.jdField_c_of_type_JavaLangString);
      break;
      label230:
      localHashMap.put("filter_id", "none");
    }
    label242:
    if (jdField_h_of_type_JavaLangLong.longValue() == 2L)
    {
      localHashMap.put("resolution", bnep.a.g());
      return localHashMap;
    }
    localHashMap.put("resolution", "none");
    return localHashMap;
  }
  
  public HashMap<String, String> a(long paramLong, int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("video_duration", String.valueOf(paramLong));
    localHashMap.put("video_num", String.valueOf(paramInt));
    localHashMap.put("change_speed_type", paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> a(long paramLong1, long paramLong2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("part_one_cost", String.valueOf(paramLong1));
    localHashMap.put("part_two_cost", String.valueOf(paramLong2));
    return localHashMap;
  }
  
  public HashMap<String, String> a(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("originVideoWidth", String.valueOf(paramLocalMediaInfo.mediaOriginWidth));
    localHashMap.put("originVideoHeight", String.valueOf(paramLocalMediaInfo.mediaOriginHeight));
    localHashMap.put("originVideoBitRate", String.valueOf(paramLocalMediaInfo.mediaOriginBitrate));
    localHashMap.put("originVideoSize", String.valueOf(paramLocalMediaInfo.mediaOriginSize));
    localHashMap.put("exportVideoWidth", String.valueOf(paramLocalMediaInfo.mediaWidth));
    localHashMap.put("exportVideoHeight", String.valueOf(paramLocalMediaInfo.mediaHeight));
    localHashMap.put("exportVideoBitRate", String.valueOf(paramLocalMediaInfo.mediaBitrate));
    localHashMap.put("exportVideoDuration", String.valueOf(paramLocalMediaInfo.mDuration));
    return localHashMap;
  }
  
  public HashMap<String, String> a(Long paramLong)
  {
    HashMap localHashMap = new HashMap();
    if ((paramLong.longValue() == -1L) || (paramLong.longValue() == 3L)) {
      localHashMap.put("receive_type", paramLong.toString());
    }
    for (;;)
    {
      localHashMap.put("content_type", jdField_h_of_type_JavaLangLong.toString());
      return localHashMap;
      if ((paramLong.longValue() == 3000L) || (paramLong.longValue() == 1L)) {
        localHashMap.put("receive_type", "2");
      } else {
        localHashMap.put("receive_type", "1");
      }
    }
  }
  
  public HashMap<String, String> a(String paramString)
  {
    return a(paramString, this.jdField_e_of_type_JavaLangString);
  }
  
  public HashMap<String, String> a(String paramString, int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = "2";
    }
    for (;;)
    {
      if ((this.jdField_h_of_type_JavaLangString == null) || (!this.jdField_h_of_type_JavaLangString.equals(paramString)))
      {
        this.jdField_h_of_type_JavaLangString = paramString;
        this.jdField_i_of_type_JavaLangString = MD5Utils.toMD5(QQStoryContext.a().getAccount() + bnqp.a());
      }
      return a(paramString, 2, str);
      if (paramInt == 0) {
        str = "1";
      } else {
        str = "3";
      }
    }
  }
  
  public HashMap<String, String> a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("material_id", paramString1);
    localHashMap.put("ret", String.valueOf(paramInt));
    localHashMap.put("duration", String.valueOf(paramLong1));
    localHashMap.put("zip_size", String.valueOf(paramLong2));
    localHashMap.put("MD5", paramString2);
    return localHashMap;
  }
  
  public HashMap<String, String> a(String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("face_id", paramString);
    localHashMap.put("cost_time", String.valueOf(paramLong));
    return localHashMap;
  }
  
  public HashMap<String, String> a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (paramString2 = "1";; paramString2 = "2")
    {
      localHashMap.put("cameraId", paramString2);
      localHashMap.put("frame_rate", String.format("%.2f", new Object[] { Float.valueOf(paramFloat) }));
      localHashMap.put("face_id", paramString1);
      return localHashMap;
    }
  }
  
  public HashMap<String, String> a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("base_res_ready", str);
      return localHashMap;
    }
  }
  
  public HashMap<String, String> a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("packageId", String.valueOf(paramInt));
    String str;
    if (paramBoolean)
    {
      str = "1";
      localHashMap.put("ret_code", str);
      localHashMap.put("packageName", paramString1);
      localHashMap.put("packageSubName", paramString2);
      localHashMap.put("cost_time", String.valueOf(paramLong2));
      if (!paramBoolean) {
        break label106;
      }
    }
    label106:
    for (paramString1 = "0";; paramString1 = String.valueOf(paramLong1))
    {
      localHashMap.put("error_code", paramString1);
      return localHashMap;
      str = "0";
      break;
    }
  }
  
  public void a()
  {
    String str = bnqp.a();
    this.jdField_a_of_type_JavaUtilHashMap.put("operation_time", str);
    bnrh.b("AEBaseReportParam", "【operation_time】:" + str);
  }
  
  public void a(int paramInt)
  {
    int i1;
    if (paramInt <= 3)
    {
      i1 = paramInt;
      if (paramInt >= -1) {}
    }
    else
    {
      i1 = -1;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("sex", "" + i1);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("op_in", String.valueOf(paramInt));
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("activity_id", paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("activity_id", "none");
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (this.jdField_a_of_type_JavaLangString = paramString;; this.jdField_a_of_type_JavaLangString = "none")
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("fromuin", this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_JavaLangString);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    return bjkp.a(localStringBuilder.toString());
  }
  
  public HashMap<String, String> b()
  {
    return a(this.jdField_d_of_type_JavaLangString, "3");
  }
  
  public HashMap<String, String> b(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", this.jdField_a_of_type_Bnqt.jdField_b_of_type_Long + "");
    localHashMap.put("MD5", this.jdField_a_of_type_Bnqt.jdField_a_of_type_JavaLangString);
    localHashMap.put("pic_count", paramInt + "");
    if (jdField_g_of_type_JavaLangLong.equals(Long.valueOf(this.jdField_a_of_type_Bnqt.jdField_b_of_type_Long)))
    {
      localHashMap.put("video_num", this.jdField_a_of_type_Bnqt.jdField_f_of_type_Int + "");
      localHashMap.put("video_duration", this.jdField_a_of_type_Bnqt.jdField_c_of_type_Long + "");
    }
    return localHashMap;
  }
  
  public HashMap<String, String> b(long paramLong)
  {
    long l1 = -1L;
    HashMap localHashMap = new HashMap();
    if ((this.jdField_e_of_type_Int == 4) || (this.jdField_e_of_type_Int == 5) || (this.jdField_e_of_type_Int == 6) || (this.jdField_e_of_type_Int == 7) || (this.jdField_e_of_type_Int == 2))
    {
      localHashMap.put("face_id", this.jdField_d_of_type_JavaLangString);
      localHashMap.put("content_type", jdField_h_of_type_JavaLangLong.toString());
      localObject = new DecimalFormat("0.00").format(this.jdField_b_of_type_Int / 100.0F);
      String str = new DecimalFormat("0.00").format(this.jdField_c_of_type_Int / 100.0F);
      localHashMap.put("beauty_value", localObject);
      localHashMap.put("facial_value", str);
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label497;
      }
      localHashMap.put("filter_id", this.jdField_b_of_type_JavaLangString);
      label169:
      localObject = new StringBuilder().append("");
      if (paramLong != -1L) {
        break label510;
      }
      paramLong = l1;
      label193:
      localHashMap.put("duration", paramLong);
      localHashMap.put("cameraId", bnqp.a(alps.jdField_a_of_type_Int));
      localHashMap.put("face_index", String.valueOf(this.jdField_a_of_type_Int));
      localHashMap.put("face_from", this.jdField_e_of_type_JavaLangString);
      localHashMap.put("face_tab", this.jdField_f_of_type_JavaLangString);
      localHashMap.put("face_type", this.jdField_e_of_type_Int + "");
      if (this.jdField_e_of_type_Int != 7) {
        break label519;
      }
      localHashMap.put("face_uin", this.jdField_d_of_type_JavaLangString + UserAction.getQIMEI());
      label333:
      localHashMap.put("preview_view_size", bnep.a.a());
      localHashMap.put("configed_preview_resolution", bnep.a.b());
      localHashMap.put("configed_capture_resolution", bnep.a.c());
      localHashMap.put("render_resolution", bnep.a.e());
      if (jdField_h_of_type_JavaLangLong.longValue() != 1L) {
        break label553;
      }
      localHashMap.put("resolution", bnep.a.d());
      label418:
      if (jdField_h_of_type_JavaLangLong.longValue() != 1L) {
        break label604;
      }
      if (!bnep.a.jdField_b_of_type_Boolean) {
        break label596;
      }
      localObject = "screenshot";
      label443:
      localHashMap.put("photo_capture_mode", localObject);
      label454:
      localObject = bnkb.b();
      if (localObject != null) {
        break label618;
      }
    }
    label519:
    label553:
    label596:
    label604:
    label618:
    for (Object localObject = "none";; localObject = ((bnke)localObject).jdField_a_of_type_JavaLangString)
    {
      localHashMap.put("watermark_id", localObject);
      return localHashMap;
      localHashMap.put("face_id", this.jdField_c_of_type_JavaLangString);
      break;
      label497:
      localHashMap.put("filter_id", "none");
      break label169;
      label510:
      paramLong /= 1000L;
      break label193;
      localHashMap.put("face_uin", this.jdField_c_of_type_JavaLangString + UserAction.getQIMEI());
      break label333;
      if (jdField_h_of_type_JavaLangLong.longValue() == 2L)
      {
        localHashMap.put("resolution", bnep.a.g());
        break label418;
      }
      localHashMap.put("resolution", "none");
      break label418;
      localObject = "camera";
      break label443;
      localHashMap.put("photo_capture_mode", "none");
      break label454;
    }
  }
  
  public HashMap<String, String> b(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("originImageWidth", String.valueOf(paramLocalMediaInfo.mediaOriginWidth));
    localHashMap.put("originImageHeight", String.valueOf(paramLocalMediaInfo.mediaOriginHeight));
    localHashMap.put("originImageSize", String.valueOf(paramLocalMediaInfo.mediaOriginSize));
    localHashMap.put("exportImageWidth", String.valueOf(paramLocalMediaInfo.mediaWidth));
    localHashMap.put("exportImageHeight", String.valueOf(paramLocalMediaInfo.mediaHeight));
    return localHashMap;
  }
  
  public HashMap<String, String> b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString))
    {
      localHashMap.put("filter_id", "none");
      return localHashMap;
    }
    localHashMap.put("filter_id", paramString);
    return localHashMap;
  }
  
  public void b()
  {
    int i2 = -1;
    int i1;
    if (AppNetConnInfo.isWifiConn()) {
      i1 = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("network_type", String.valueOf(i1));
      UserAction.setLogAble(false, false);
      return;
      i1 = i2;
      switch (AppNetConnInfo.getMobileInfo())
      {
      case 0: 
      default: 
        i1 = i2;
        break;
      case 1: 
        i1 = 2;
        break;
      case 2: 
        i1 = 3;
        break;
      case 3: 
        i1 = 4;
        break;
      case 4: 
        i1 = 5;
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    jdField_h_of_type_JavaLangLong = Long.valueOf(paramLong);
  }
  
  public void b(String paramString)
  {
    QLog.d("AEBaseReportParam", 4, "[setExperimentID] experimentID = " + paramString);
    if ((paramString == null) || (TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("expirement_id", "none");
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("expirement_id", paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public HashMap<String, String> c()
  {
    return a(this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
  }
  
  public HashMap<String, String> c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("video_id", this.jdField_a_of_type_Bnqt.jdField_a_of_type_JavaLangString);
    localHashMap.put("music_value", String.valueOf(paramInt));
    return localHashMap;
  }
  
  public HashMap<String, String> c(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("video_duration", String.valueOf(paramLong / 1000L));
    return localHashMap;
  }
  
  public HashMap<String, String> c(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("filter_id", paramString);
    return localHashMap;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void c(long paramLong)
  {
    e();
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_c_of_type_Boolean = this.jdField_d_of_type_Boolean;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_j_of_type_Long = 2L;
      return;
    }
    this.jdField_j_of_type_Long = 1L;
  }
  
  public boolean c()
  {
    if ((this.jdField_c_of_type_Long <= 0L) || (this.jdField_d_of_type_Long <= 0L) || (this.jdField_e_of_type_Long <= 0L) || (this.jdField_f_of_type_Long <= 0L)) {}
    while ((this.jdField_d_of_type_Long - this.jdField_c_of_type_Long > 120000L) || (this.jdField_e_of_type_Long - this.jdField_c_of_type_Long > 120000L) || (this.jdField_f_of_type_Long - this.jdField_c_of_type_Long > 120000L)) {
      return false;
    }
    return true;
  }
  
  public HashMap<String, String> d()
  {
    return a(this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
  }
  
  public HashMap<String, String> d(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("music_id", this.jdField_a_of_type_Bnqt.jdField_c_of_type_JavaLangString);
    localHashMap.put("video_id", this.jdField_a_of_type_Bnqt.jdField_a_of_type_JavaLangString);
    localHashMap.put("music_value", String.valueOf(paramInt));
    return localHashMap;
  }
  
  public HashMap<String, String> d(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", bnqp.a(Long.valueOf(paramLong)));
    return localHashMap;
  }
  
  public HashMap<String, String> d(String paramString)
  {
    return a(paramString, "3");
  }
  
  public void d()
  {
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_i_of_type_JavaLangString = null;
  }
  
  public void d(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.jdField_i_of_type_Long = paramLong;
  }
  
  public void d(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_k_of_type_Long = 2L;
      return;
    }
    this.jdField_k_of_type_Long = 1L;
  }
  
  public HashMap<String, String> e()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("face_id", bnqu.a().a("camera_ad_op_id", "", 4));
    return localHashMap;
  }
  
  public HashMap<String, String> e(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("pic_scale", String.valueOf(paramInt));
    return localHashMap;
  }
  
  public HashMap<String, String> e(String paramString)
  {
    return bnqp.a(i(), a(paramString, "3"));
  }
  
  public void e()
  {
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void e(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void e(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public HashMap<String, String> f()
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("face_id", this.jdField_c_of_type_JavaLangString);
    localHashMap.put("is_sort_icon", this.jdField_d_of_type_Int + "");
    return localHashMap;
  }
  
  public HashMap<String, String> f(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if ((paramInt < 1) || (paramInt > 2)) {}
    for (String str = "none";; str = String.valueOf(paramInt))
    {
      localHashMap.put("api_level", str);
      return localHashMap;
    }
  }
  
  public HashMap<String, String> f(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_b_of_type_Long));
    localHashMap.put("filter_id", paramString);
    return localHashMap;
  }
  
  public void f()
  {
    if (this.jdField_d_of_type_Long == 0L) {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void f(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void f(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public HashMap<String, String> g()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("face_id", this.jdField_c_of_type_JavaLangString);
    return localHashMap;
  }
  
  public HashMap<String, String> g(String paramString)
  {
    paramString = a(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ai_color_frame_states", paramString);
    return localHashMap;
  }
  
  public void g()
  {
    if (this.jdField_e_of_type_Long == 0L) {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void g(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public HashMap<String, String> h()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", bnqp.a(Long.valueOf(a())));
    return localHashMap;
  }
  
  public HashMap<String, String> h(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("filter_id", paramString);
    return localHashMap;
  }
  
  public void h()
  {
    if (this.jdField_f_of_type_Long == 0L) {
      this.jdField_f_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void h(String paramString)
  {
    this.jdField_k_of_type_JavaLangString = paramString;
  }
  
  public HashMap<String, String> i()
  {
    if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {}
    for (String str = MD5Utils.toMD5(QQStoryContext.a().getAccount() + bnqp.a());; str = this.jdField_i_of_type_JavaLangString) {
      return a(str, 1, "-1");
    }
  }
  
  public HashMap<String, String> i(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("text_content", paramString);
    i(paramString);
    return localHashMap;
  }
  
  public void i()
  {
    this.jdField_h_of_type_Long = System.currentTimeMillis();
  }
  
  public void i(String paramString)
  {
    this.l = paramString;
  }
  
  public HashMap<String, String> j()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_a_of_type_Long));
    localHashMap.put("content_type", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_b_of_type_Long));
    localHashMap.put("MD5", this.jdField_a_of_type_Bnqt.jdField_a_of_type_JavaLangString);
    String str = this.jdField_a_of_type_Bnqt.jdField_b_of_type_JavaLangString;
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "none";
    }
    localHashMap.put("filter_id", localObject);
    localHashMap.put("filter_value", String.valueOf((int)this.jdField_a_of_type_Bnqt.jdField_a_of_type_Float));
    localHashMap.put("music_id", this.jdField_a_of_type_Bnqt.jdField_c_of_type_JavaLangString);
    str = (String)this.jdField_a_of_type_Bnqt.jdField_a_of_type_AndroidUtilSparseArray.get(0);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "none";
    }
    localHashMap.put("color_type", localObject);
    str = (String)this.jdField_a_of_type_Bnqt.jdField_b_of_type_AndroidUtilSparseArray.get(0);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "none";
    }
    localHashMap.put("text_item_id", localObject);
    localHashMap.put("sound_type", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_a_of_type_Int));
    localHashMap.put("text_count", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_d_of_type_Int));
    localHashMap.put("music_list", this.jdField_a_of_type_Bnqt.jdField_e_of_type_JavaLangString);
    localHashMap.put("video_id", this.jdField_a_of_type_Bnqt.jdField_a_of_type_JavaLangString);
    localHashMap.put("music_common_info", this.jdField_a_of_type_Bnqt.jdField_d_of_type_JavaLangString);
    localHashMap.put("lyric_status", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_g_of_type_Int));
    if (this.jdField_a_of_type_Bnqt.jdField_a_of_type_Boolean)
    {
      localObject = "1";
      localHashMap.put("is_recommend", localObject);
      localHashMap.put("recommend_index", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_b_of_type_Int));
      localHashMap.put("music_duration", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_c_of_type_Int));
      localHashMap.put("video_duration", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_a_of_type_Long));
      localHashMap.put("video_source", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_e_of_type_Int));
      localHashMap.put("face_id", this.jdField_c_of_type_JavaLangString);
      localHashMap.put("change_speed_type", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_a_of_type_Double));
      localObject = bnkb.b();
      if (localObject != null) {
        break label442;
      }
    }
    label442:
    for (localObject = "none";; localObject = ((bnke)localObject).jdField_a_of_type_JavaLangString)
    {
      localHashMap.put("watermark_id", localObject);
      return localHashMap;
      localObject = "0";
      break;
    }
  }
  
  public HashMap<String, String> j(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", paramString);
    return localHashMap;
  }
  
  public void j()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_JavaLangString);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    this.n = bjkp.a(localStringBuilder.toString());
  }
  
  public void j(String paramString)
  {
    this.m = paramString;
  }
  
  public HashMap<String, String> k()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_b_of_type_Long));
    localHashMap.put("red_point", String.valueOf(this.jdField_a_of_type_Bnqt.i));
    return localHashMap;
  }
  
  public HashMap<String, String> k(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", this.jdField_j_of_type_JavaLangString);
    if (TextUtils.isEmpty(paramString))
    {
      localHashMap.put("word_source", "none");
      return localHashMap;
    }
    localHashMap.put("word_source", paramString);
    return localHashMap;
  }
  
  public void k()
  {
    this.jdField_j_of_type_Long = 1L;
    this.jdField_k_of_type_Long = 1L;
  }
  
  public void k(String paramString)
  {
    this.jdField_j_of_type_JavaLangString = paramString;
  }
  
  public HashMap<String, String> l()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("video_id", this.jdField_a_of_type_Bnqt.jdField_a_of_type_JavaLangString);
    return localHashMap;
  }
  
  public HashMap<String, String> l(@NonNull String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("watermark_id", paramString);
    return localHashMap;
  }
  
  public void l(String paramString)
  {
    this.o = paramString;
  }
  
  public HashMap<String, String> m()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("music_id", this.jdField_a_of_type_Bnqt.jdField_c_of_type_JavaLangString);
    localHashMap.put("music_list", this.jdField_a_of_type_Bnqt.jdField_e_of_type_JavaLangString);
    localHashMap.put("video_id", this.jdField_a_of_type_Bnqt.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bnqt.jdField_a_of_type_Boolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("is_recommend", str);
      localHashMap.put("recommend_index", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_b_of_type_Int));
      localHashMap.put("music_duration", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_c_of_type_Int));
      localHashMap.put("video_duration", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_a_of_type_Long));
      localHashMap.put("video_source", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_e_of_type_Int));
      return localHashMap;
    }
  }
  
  public HashMap<String, String> m(@NonNull String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("gps", paramString);
    return localHashMap;
  }
  
  public HashMap<String, String> n()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("music_id", this.jdField_a_of_type_Bnqt.jdField_c_of_type_JavaLangString);
    localHashMap.put("video_id", this.jdField_a_of_type_Bnqt.jdField_a_of_type_JavaLangString);
    localHashMap.put("lyric_status", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_g_of_type_Int));
    return localHashMap;
  }
  
  public HashMap<String, String> o()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_b_of_type_Long));
    localHashMap.put("video_id", this.jdField_a_of_type_Bnqt.jdField_a_of_type_JavaLangString);
    localHashMap.put("video_source", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_e_of_type_Int));
    localHashMap.put("video_duration", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_a_of_type_Long));
    return localHashMap;
  }
  
  public HashMap<String, String> p()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("color_type", this.jdField_a_of_type_Bnqt.jdField_f_of_type_JavaLangString);
    localHashMap.put("text_item_id", this.jdField_a_of_type_Bnqt.jdField_g_of_type_JavaLangString);
    localHashMap.put("common_color_list", String.valueOf(this.jdField_a_of_type_Bnqt.h));
    return localHashMap;
  }
  
  public HashMap<String, String> q()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("text_item_id", this.jdField_a_of_type_Bnqt.jdField_g_of_type_JavaLangString);
    return localHashMap;
  }
  
  public HashMap<String, String> r()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", String.valueOf(this.jdField_a_of_type_Bnqt.jdField_b_of_type_Long));
    return localHashMap;
  }
  
  public HashMap<String, String> s()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", jdField_h_of_type_JavaLangLong.toString());
    return localHashMap;
  }
  
  public HashMap<String, String> t()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration_first_frame", bnqp.a(Long.valueOf(this.jdField_d_of_type_Long - this.jdField_c_of_type_Long)));
    localHashMap.put("duration_bottom_bar", bnqp.a(Long.valueOf(this.jdField_e_of_type_Long - this.jdField_c_of_type_Long)));
    localHashMap.put("duration_photo_btn", bnqp.a(Long.valueOf(this.jdField_f_of_type_Long - this.jdField_c_of_type_Long)));
    String str;
    if (bnqp.b()) {
      str = "first_launch";
    }
    for (;;)
    {
      localHashMap.put("launch_type", str);
      return localHashMap;
      if (this.jdField_c_of_type_Boolean) {
        str = "cold_launch";
      } else {
        str = "warm_launch";
      }
    }
  }
  
  public HashMap<String, String> u()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("OpenGL", GLCapabilities.getGlesVersion());
    localHashMap.put("shader", String.valueOf(GLCapabilities.isFilamentShaderCompileSucceed()));
    return localHashMap;
  }
  
  public HashMap<String, String> v()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_h_of_type_Long;
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", bnqp.a(Long.valueOf(l1 - l2)));
    return localHashMap;
  }
  
  public HashMap<String, String> w()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", bnqp.a(Long.valueOf(this.jdField_i_of_type_Long)));
    localHashMap.put("cutout_type", Long.toString(this.jdField_j_of_type_Long));
    localHashMap.put("countdown_type", Long.toString(this.jdField_k_of_type_Long));
    Object localObject = new DecimalFormat("0.00").format(this.jdField_b_of_type_Int / 100.0F);
    String str = new DecimalFormat("0.00").format(this.jdField_c_of_type_Int / 100.0F);
    localHashMap.put("beauty_value", localObject);
    localHashMap.put("facial_value", str);
    localObject = bpjt.a().c(0);
    if (localObject != null) {}
    for (this.jdField_k_of_type_JavaLangString = ((QIMFilterCategoryItem)localObject).jdField_a_of_type_JavaLangString;; this.jdField_k_of_type_JavaLangString = "none")
    {
      localHashMap.put("filter_id", this.jdField_k_of_type_JavaLangString);
      localHashMap.put("cameraId", bnqp.a(alps.jdField_a_of_type_Int));
      localHashMap.put("emoticon_id", this.jdField_j_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.o)) {
        break;
      }
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.o);
    return localHashMap;
  }
  
  public HashMap<String, String> x()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", this.jdField_j_of_type_JavaLangString);
    if (TextUtils.isEmpty(this.o))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.o);
    return localHashMap;
  }
  
  public HashMap<String, String> y()
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(this.o))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.o);
    return localHashMap;
  }
  
  public HashMap<String, String> z()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", bnqp.a(Long.valueOf(this.jdField_i_of_type_Long)));
    localHashMap.put("cutout_type", Long.toString(this.jdField_j_of_type_Long));
    localHashMap.put("countdown_type", Long.toString(this.jdField_k_of_type_Long));
    Object localObject = new DecimalFormat("0.00").format(this.jdField_b_of_type_Int / 100.0F);
    String str = new DecimalFormat("0.00").format(this.jdField_c_of_type_Int / 100.0F);
    localHashMap.put("beauty_value", localObject);
    localHashMap.put("facial_value", str);
    localHashMap.put("cameraId", bnqp.a(alps.jdField_a_of_type_Int));
    localHashMap.put("emoticon_id", this.jdField_j_of_type_JavaLangString);
    localHashMap.put("text_content", this.l);
    if (this.l.equals("none"))
    {
      localHashMap.put("text_color", "none");
      localObject = bpjt.a().c(0);
      if (localObject == null) {
        break label269;
      }
    }
    label269:
    for (this.jdField_k_of_type_JavaLangString = ((QIMFilterCategoryItem)localObject).jdField_a_of_type_JavaLangString;; this.jdField_k_of_type_JavaLangString = "none")
    {
      localHashMap.put("filter_id", this.jdField_k_of_type_JavaLangString);
      if (this.n.equals("")) {
        j();
      }
      localHashMap.put("MD5", this.n);
      if (!TextUtils.isEmpty(this.o)) {
        break label278;
      }
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
      localHashMap.put("text_color", this.m);
      break;
    }
    label278:
    localHashMap.put("emo_sort_id", this.o);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqq
 * JD-Core Version:    0.7.0.1
 */