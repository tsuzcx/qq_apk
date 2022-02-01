package com.tencent.aelight.camera.ae.report;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aekit.api.standard.GLCapabilities;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.ResolutionInfo;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.base.MD5;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONObject;

public class AEBaseReportParam
{
  public static final Long a;
  public static final Long b;
  public static final Long c;
  public static final Long d;
  public static final Long e;
  public static final Long f;
  public static final Long g;
  private static Long jdField_h_of_type_JavaLangLong;
  @AEBaseReportParam.EditPicFrom
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AEEditReportData jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData = new AEEditReportData();
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long = -1L;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long = 0L;
  private String jdField_d_of_type_JavaLangString = "none";
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long = 0L;
  private String jdField_e_of_type_JavaLangString = "none";
  private int jdField_f_of_type_Int = -1;
  private long jdField_f_of_type_Long = 0L;
  private String jdField_f_of_type_JavaLangString = "-1";
  private long jdField_g_of_type_Long = -1L;
  private String jdField_g_of_type_JavaLangString = "none";
  private long jdField_h_of_type_Long = -1L;
  private String jdField_h_of_type_JavaLangString = "none";
  private long jdField_i_of_type_Long = 0L;
  private String jdField_i_of_type_JavaLangString = null;
  private long jdField_j_of_type_Long = 1L;
  private String jdField_j_of_type_JavaLangString = null;
  private long jdField_k_of_type_Long = 1L;
  private String jdField_k_of_type_JavaLangString = "none";
  private String l = "none";
  private String m = "none";
  private String n = "#ffffff";
  private String o = "";
  private String p = "none";
  
  static
  {
    Long localLong = Long.valueOf(-1L);
    jdField_h_of_type_JavaLangLong = localLong;
    jdField_a_of_type_JavaLangLong = localLong;
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
  
  public static AEBaseReportParam a()
  {
    return AEBaseReportParam.SingletonHolder.a();
  }
  
  private HashMap<String, String> a(String paramString1, int paramInt, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    int i1 = this.jdField_f_of_type_Int;
    if ((i1 != 4) && (i1 != 5) && (i1 != 6) && (i1 != 7) && (i1 != 2)) {
      localHashMap.put("face_id", this.jdField_d_of_type_JavaLangString);
    } else {
      localHashMap.put("face_id", this.jdField_e_of_type_JavaLangString);
    }
    localHashMap.put("content_type", jdField_h_of_type_JavaLangLong.toString());
    localHashMap.put("MD5", paramString1);
    paramString1 = new DecimalFormat("0.00").format(this.jdField_c_of_type_Int / 100.0F);
    String str = new DecimalFormat("0.00").format(this.jdField_d_of_type_Int / 100.0F);
    localHashMap.put("beauty_value", paramString1);
    localHashMap.put("facial_value", str);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localHashMap.put("filter_id", this.jdField_b_of_type_JavaLangString);
    } else {
      localHashMap.put("filter_id", "none");
    }
    paramString1 = new StringBuilder();
    paramString1.append("");
    paramString1.append(this.jdField_a_of_type_Long);
    localHashMap.put("duration", paramString1.toString());
    localHashMap.put("cameraId", AEBaseDataUtil.a(FlowCameraConstant.jdField_a_of_type_Int));
    if (jdField_h_of_type_JavaLangLong.longValue() == 1L) {
      localHashMap.put("resolution", AEDashboardUtil.a.d());
    } else if (jdField_h_of_type_JavaLangLong.longValue() == 2L) {
      localHashMap.put("resolution", AEDashboardUtil.a.g());
    } else {
      localHashMap.put("resolution", "none");
    }
    paramString1 = new StringBuilder();
    paramString1.append(this.jdField_a_of_type_Int);
    paramString1.append("");
    localHashMap.put("pic_from", paramString1.toString());
    localHashMap.put("post_type", String.valueOf(paramInt));
    localHashMap.put("receive_type", paramString2);
    localHashMap.put("face_index", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("face_from", this.jdField_f_of_type_JavaLangString);
    localHashMap.put("face_tab", this.jdField_g_of_type_JavaLangString);
    paramString1 = new StringBuilder();
    paramString1.append(this.jdField_f_of_type_Int);
    paramString1.append("");
    localHashMap.put("face_type", paramString1.toString());
    paramInt = this.jdField_f_of_type_Int;
    if ((paramInt != 4) && (paramInt != 5) && (paramInt != 6) && (paramInt != 7))
    {
      paramString1 = new StringBuilder();
      paramString1.append(this.jdField_d_of_type_JavaLangString);
      paramString1.append(UserAction.getQIMEI());
      localHashMap.put("face_uin", paramString1.toString());
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append(this.jdField_e_of_type_JavaLangString);
      paramString1.append(UserAction.getQIMEI());
      localHashMap.put("face_uin", paramString1.toString());
    }
    paramString1 = new JSONObject(this.jdField_a_of_type_JavaUtilMap).toString();
    paramString2 = new StringBuilder();
    paramString2.append("getPostBtnParam---editJsonStr=");
    paramString2.append(paramString1);
    QLog.d("AEBaseReportParam", 1, paramString2.toString());
    localHashMap.put("edit_json", paramString1);
    return localHashMap;
  }
  
  private HashMap<String, String> a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap(6);
    localHashMap.put("face_id", paramString1);
    localHashMap.put("face_tab", this.jdField_g_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append("");
    localHashMap.put("face_type", localStringBuilder.toString());
    localHashMap.put("face_index", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("face_from", paramString2);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(UserAction.getQIMEI());
    localHashMap.put("face_uin", paramString2.toString());
    return localHashMap;
  }
  
  public HashMap<String, String> A()
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(this.p))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.p);
    return localHashMap;
  }
  
  public HashMap<String, String> B()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", AEBaseDataUtil.a(Long.valueOf(this.jdField_i_of_type_Long)));
    localHashMap.put("cutout_type", Long.toString(this.jdField_j_of_type_Long));
    localHashMap.put("countdown_type", Long.toString(this.jdField_k_of_type_Long));
    Object localObject = new DecimalFormat("0.00").format(this.jdField_c_of_type_Int / 100.0F);
    String str = new DecimalFormat("0.00").format(this.jdField_d_of_type_Int / 100.0F);
    localHashMap.put("beauty_value", localObject);
    localHashMap.put("facial_value", str);
    localHashMap.put("cameraId", AEBaseDataUtil.a(FlowCameraConstant.jdField_a_of_type_Int));
    localHashMap.put("emoticon_id", this.jdField_k_of_type_JavaLangString);
    localHashMap.put("text_content", this.m);
    if (this.m.equals("none")) {
      localHashMap.put("text_color", "none");
    } else {
      localHashMap.put("text_color", this.n);
    }
    localObject = VideoFilterTools.a().c(0);
    if (localObject != null) {
      this.l = ((QIMFilterCategoryItem)localObject).jdField_a_of_type_JavaLangString;
    } else {
      this.l = "none";
    }
    localHashMap.put("filter_id", this.l);
    if (this.o.equals("")) {
      l();
    }
    localHashMap.put("MD5", this.o);
    if (TextUtils.isEmpty(this.p))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.p);
    return localHashMap;
  }
  
  public HashMap<String, String> C()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", AEBaseDataUtil.a(Long.valueOf(this.jdField_i_of_type_Long)));
    localHashMap.put("cutout_type", Long.toString(this.jdField_j_of_type_Long));
    localHashMap.put("countdown_type", Long.toString(this.jdField_k_of_type_Long));
    Object localObject = new DecimalFormat("0.00").format(this.jdField_c_of_type_Int / 100.0F);
    String str = new DecimalFormat("0.00").format(this.jdField_d_of_type_Int / 100.0F);
    localHashMap.put("beauty_value", localObject);
    localHashMap.put("facial_value", str);
    localHashMap.put("cameraId", AEBaseDataUtil.a(FlowCameraConstant.jdField_a_of_type_Int));
    localHashMap.put("text_content", this.m);
    if (!localHashMap.containsKey("emoticon_id")) {
      localHashMap.put("emoticon_id", this.jdField_k_of_type_JavaLangString);
    }
    localObject = VideoFilterTools.a().c(0);
    if (localObject != null) {
      this.l = ((QIMFilterCategoryItem)localObject).jdField_a_of_type_JavaLangString;
    } else {
      this.l = "none";
    }
    localHashMap.put("filter_id", this.l);
    if (!localHashMap.containsKey("text_color")) {
      if (this.m.equals("none")) {
        localHashMap.put("text_color", "none");
      } else {
        localHashMap.put("text_color", this.n);
      }
    }
    if (this.o.equals("")) {
      l();
    }
    localHashMap.put("MD5", this.o);
    if (TextUtils.isEmpty(this.p))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.p);
    return localHashMap;
  }
  
  public HashMap<String, String> D()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", this.jdField_k_of_type_JavaLangString);
    return localHashMap;
  }
  
  public AEEditReportData a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData;
  }
  
  public String a()
  {
    return this.jdField_d_of_type_JavaLangString;
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
    localHashMap.put("content_type", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_b_of_type_Long));
    localHashMap.put("MD5", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_JavaLangString);
    Object localObject1 = (String)this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    String str = "none";
    if (bool) {
      localObject1 = "none";
    }
    localHashMap.put("filter_id", localObject1);
    localObject1 = (Float)this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localObject1 == null) {
      localObject1 = "none";
    } else {
      localObject1 = String.valueOf(((Float)localObject1).intValue());
    }
    localHashMap.put("filter_value", localObject1);
    Object localObject2 = (String)this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "none";
    }
    localHashMap.put("color_type", localObject1);
    localObject2 = (String)this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_c_of_type_AndroidUtilSparseArray.get(paramInt);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "none";
    }
    localHashMap.put("ai_color_frame_states", localObject1);
    localObject2 = (String)this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "none";
    }
    localHashMap.put("text_item_id", localObject1);
    localHashMap.put("music_id", "none");
    localHashMap.put("sound_type", "0");
    localHashMap.put("video_id", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_JavaLangString);
    localObject2 = (Integer)this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Integer.valueOf(-1);
    }
    localHashMap.put("text_count", String.valueOf(localObject1));
    localHashMap.put("face_id", this.jdField_d_of_type_JavaLangString);
    localObject1 = AEMaterialManager.b();
    if (localObject1 == null) {
      localObject1 = str;
    } else {
      localObject1 = ((AEMaterialMetaData)localObject1).jdField_k_of_type_JavaLangString;
    }
    localHashMap.put("watermark_id", localObject1);
    return localHashMap;
  }
  
  public HashMap<String, String> a(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", paramString);
    localHashMap.put("emo_num", String.valueOf(paramInt));
    if (TextUtils.isEmpty(this.p))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.p);
    return localHashMap;
  }
  
  public HashMap<String, String> a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt1);
    localHashMap.put("ret_code", localStringBuilder.toString());
    localHashMap.put("req_cost", paramString1);
    localHashMap.put("cmd_id", paramString2);
    localHashMap.put("res_code", String.valueOf(paramInt2));
    return localHashMap;
  }
  
  public HashMap<String, String> a(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    int i1 = this.jdField_f_of_type_Int;
    if ((i1 != 4) && (i1 != 5) && (i1 != 6) && (i1 != 7) && (i1 != 2)) {
      localHashMap.put("face_id", this.jdField_d_of_type_JavaLangString);
    } else {
      localHashMap.put("face_id", this.jdField_e_of_type_JavaLangString);
    }
    localHashMap.put("content_type", jdField_h_of_type_JavaLangLong.toString());
    String str1 = new DecimalFormat("0.00").format(this.jdField_c_of_type_Int / 100.0F);
    String str2 = new DecimalFormat("0.00").format(this.jdField_d_of_type_Int / 100.0F);
    localHashMap.put("beauty_value", str1);
    localHashMap.put("facial_value", str2);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localHashMap.put("filter_id", this.jdField_b_of_type_JavaLangString);
    } else {
      localHashMap.put("filter_id", "none");
    }
    localHashMap.put("duration", AEBaseDataUtil.a(Long.valueOf(System.currentTimeMillis() - paramLong)));
    localHashMap.put("cameraId", AEBaseDataUtil.a(FlowCameraConstant.jdField_a_of_type_Int));
    if (jdField_h_of_type_JavaLangLong.longValue() == 1L)
    {
      localHashMap.put("resolution", AEDashboardUtil.a.d());
      return localHashMap;
    }
    if (jdField_h_of_type_JavaLangLong.longValue() == 2L)
    {
      localHashMap.put("resolution", AEDashboardUtil.a.g());
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
    if ((paramLong.longValue() != -1L) && (paramLong.longValue() != 3L))
    {
      if ((paramLong.longValue() != 3000L) && (paramLong.longValue() != 1L)) {
        localHashMap.put("receive_type", "1");
      } else {
        localHashMap.put("receive_type", "2");
      }
    }
    else {
      localHashMap.put("receive_type", paramLong.toString());
    }
    localHashMap.put("content_type", jdField_h_of_type_JavaLangLong.toString());
    localHashMap.put("face_id", this.jdField_d_of_type_JavaLangString);
    return localHashMap;
  }
  
  public HashMap<String, String> a(String paramString)
  {
    return a(paramString, this.jdField_f_of_type_JavaLangString);
  }
  
  public HashMap<String, String> a(String paramString, int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = "2";
    } else if (paramInt == 0) {
      str = "1";
    } else {
      str = "3";
    }
    Object localObject = this.jdField_i_of_type_JavaLangString;
    if ((localObject == null) || (!((String)localObject).equals(paramString)))
    {
      this.jdField_i_of_type_JavaLangString = paramString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(QQStoryContext.a().getAccount());
      ((StringBuilder)localObject).append(AEBaseDataUtil.a());
      this.jdField_j_of_type_JavaLangString = MD5Utils.toMD5(((StringBuilder)localObject).toString());
    }
    return a(paramString, 2, str);
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
  
  public HashMap<String, String> a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {
      paramString2 = "1";
    } else {
      paramString2 = "2";
    }
    localHashMap.put("cameraId", paramString2);
    localHashMap.put("frame_rate", String.format("%.2f", new Object[] { Float.valueOf(paramFloat) }));
    localHashMap.put("face_id", paramString1);
    return localHashMap;
  }
  
  public HashMap<String, String> a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    String str;
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("base_res_ready", str);
    return localHashMap;
  }
  
  public HashMap<String, String> a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("packageId", String.valueOf(paramInt));
    String str2 = "0";
    String str1;
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("ret_code", str1);
    localHashMap.put("packageName", paramString1);
    localHashMap.put("packageSubName", paramString2);
    localHashMap.put("cost_time", String.valueOf(paramLong2));
    if (paramBoolean) {
      paramString1 = str2;
    } else {
      paramString1 = String.valueOf(paramLong1);
    }
    localHashMap.put("error_code", paramString1);
    return localHashMap;
  }
  
  public void a()
  {
    String str = AEBaseDataUtil.a();
    this.jdField_a_of_type_JavaUtilHashMap.put("operation_time", str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【operation_time】:");
    localStringBuilder.append(str);
    AEQLog.b("AEBaseReportParam", localStringBuilder.toString());
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
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i1);
    localHashMap.put("sex", localStringBuilder.toString());
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
  
  public void a(String paramString)
  {
    String str = this.jdField_c_of_type_JavaLangString;
    if ((str != null) && (!str.equals(paramString)))
    {
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_a_of_type_JavaUtilHashMap.put("activity_id", "none");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_c_of_type_JavaLangString = paramString1;
    if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2)))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("activity_id", paramString2);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("activity_id", "none");
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
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "none";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_JavaLangString);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    return MD5.a(localStringBuilder.toString());
  }
  
  public HashMap<String, String> b()
  {
    return a(this.jdField_e_of_type_JavaLangString, "3");
  }
  
  public HashMap<String, String> b(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    String str2 = (String)this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_d_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "none";
    }
    localHashMap.put("template_id", str1);
    str2 = (String)this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_e_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "none";
    }
    localHashMap.put("text_id", str1);
    return localHashMap;
  }
  
  public HashMap<String, String> b(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    int i1 = this.jdField_f_of_type_Int;
    if ((i1 != 4) && (i1 != 5) && (i1 != 6) && (i1 != 7) && (i1 != 2)) {
      localHashMap.put("face_id", this.jdField_d_of_type_JavaLangString);
    } else {
      localHashMap.put("face_id", this.jdField_e_of_type_JavaLangString);
    }
    localHashMap.put("content_type", jdField_h_of_type_JavaLangLong.toString());
    Object localObject = new DecimalFormat("0.00").format(this.jdField_c_of_type_Int / 100.0F);
    String str = new DecimalFormat("0.00").format(this.jdField_d_of_type_Int / 100.0F);
    localHashMap.put("beauty_value", localObject);
    localHashMap.put("facial_value", str);
    boolean bool = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
    str = "none";
    if (!bool) {
      localHashMap.put("filter_id", this.jdField_b_of_type_JavaLangString);
    } else {
      localHashMap.put("filter_id", "none");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    long l1 = -1L;
    if (paramLong == -1L) {
      paramLong = l1;
    } else {
      paramLong /= 1000L;
    }
    ((StringBuilder)localObject).append(paramLong);
    localHashMap.put("duration", ((StringBuilder)localObject).toString());
    localHashMap.put("cameraId", AEBaseDataUtil.a(FlowCameraConstant.jdField_a_of_type_Int));
    localHashMap.put("face_index", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("face_from", this.jdField_f_of_type_JavaLangString);
    localHashMap.put("face_tab", this.jdField_g_of_type_JavaLangString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_f_of_type_Int);
    ((StringBuilder)localObject).append("");
    localHashMap.put("face_type", ((StringBuilder)localObject).toString());
    if (this.jdField_f_of_type_Int == 7)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_e_of_type_JavaLangString);
      ((StringBuilder)localObject).append(UserAction.getQIMEI());
      localHashMap.put("face_uin", ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject).append(UserAction.getQIMEI());
      localHashMap.put("face_uin", ((StringBuilder)localObject).toString());
    }
    localHashMap.put("preview_view_size", AEDashboardUtil.a.a());
    localHashMap.put("configed_preview_resolution", AEDashboardUtil.a.b());
    localHashMap.put("configed_capture_resolution", AEDashboardUtil.a.c());
    localHashMap.put("render_resolution", AEDashboardUtil.a.e());
    if (jdField_h_of_type_JavaLangLong.longValue() == 1L) {
      localHashMap.put("resolution", AEDashboardUtil.a.d());
    } else if (jdField_h_of_type_JavaLangLong.longValue() == 2L) {
      localHashMap.put("resolution", AEDashboardUtil.a.g());
    } else {
      localHashMap.put("resolution", "none");
    }
    if (jdField_h_of_type_JavaLangLong.longValue() == 1L)
    {
      if (AEDashboardUtil.a.jdField_b_of_type_Boolean) {
        localObject = "screenshot";
      } else {
        localObject = "camera";
      }
      localHashMap.put("photo_capture_mode", localObject);
    }
    else
    {
      localHashMap.put("photo_capture_mode", "none");
    }
    localObject = AEMaterialManager.b();
    if (localObject == null) {
      localObject = str;
    } else {
      localObject = ((AEMaterialMetaData)localObject).jdField_k_of_type_JavaLangString;
    }
    localHashMap.put("watermark_id", localObject);
    return localHashMap;
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
    boolean bool = AppNetConnInfo.isWifiConn();
    int i2 = -1;
    int i1;
    if (bool)
    {
      i1 = 1;
    }
    else
    {
      int i3 = AppNetConnInfo.getMobileInfo();
      i1 = i2;
      if (i3 != 0) {
        if (i3 != 1)
        {
          if (i3 != 2)
          {
            if (i3 != 3)
            {
              if (i3 != 4) {
                i1 = i2;
              } else {
                i1 = 5;
              }
            }
            else {
              i1 = 4;
            }
          }
          else {
            i1 = 3;
          }
        }
        else {
          i1 = 2;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("network_type", String.valueOf(i1));
    UserAction.setLogAble(false, false);
  }
  
  public void b(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    jdField_h_of_type_JavaLangLong = Long.valueOf(paramLong);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("recom_reason", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" 【recom_reason】:");
    localStringBuilder.append(paramString);
    AEQLog.b("AEBaseReportParam", localStringBuilder.toString());
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
    return a(this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
  }
  
  public HashMap<String, String> c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_b_of_type_Long);
    localStringBuilder.append("");
    localHashMap.put("content_type", localStringBuilder.toString());
    localHashMap.put("MD5", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_JavaLangString);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("pic_count", localStringBuilder.toString());
    if (jdField_g_of_type_JavaLangLong.equals(Long.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_b_of_type_Long)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_f_of_type_Int);
      localStringBuilder.append("");
      localHashMap.put("video_num", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_c_of_type_Long);
      localStringBuilder.append("");
      localHashMap.put("video_duration", localStringBuilder.toString());
    }
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
    AEQLog.a("AEBaseReportParam", "EditJson--resetEditInfo");
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void c(@AEBaseReportParam.EditPicFrom int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void c(long paramLong)
  {
    g();
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_c_of_type_Boolean = this.jdField_d_of_type_Boolean;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void c(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaLangString = paramString;
    } else {
      this.jdField_a_of_type_JavaLangString = "none";
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("fromuin", this.jdField_a_of_type_JavaLangString);
  }
  
  public void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--HasCut=");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilMap.put("cut", "1");
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.remove("cut");
  }
  
  public boolean c()
  {
    long l1 = this.jdField_c_of_type_Long;
    if (l1 > 0L)
    {
      long l2 = this.jdField_d_of_type_Long;
      if (l2 > 0L)
      {
        long l3 = this.jdField_e_of_type_Long;
        if (l3 > 0L)
        {
          long l4 = this.jdField_f_of_type_Long;
          if (l4 <= 0L) {
            return false;
          }
          if (l2 - l1 > 120000L) {
            return false;
          }
          if (l3 - l1 > 120000L) {
            return false;
          }
          return l4 - l1 <= 120000L;
        }
      }
    }
    return false;
  }
  
  public HashMap<String, String> d()
  {
    return a(this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
  }
  
  public HashMap<String, String> d(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("pic_scale", String.valueOf(paramInt));
    return localHashMap;
  }
  
  public HashMap<String, String> d(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", AEBaseDataUtil.a(Long.valueOf(paramLong)));
    return localHashMap;
  }
  
  public HashMap<String, String> d(String paramString)
  {
    return a(paramString, "3");
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.jdField_i_of_type_Long = paramLong;
  }
  
  public void d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setExperimentID] experimentID = ");
    localStringBuilder.append(paramString);
    QLog.d("AEBaseReportParam", 4, localStringBuilder.toString());
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("expirement_id", paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("expirement_id", "none");
  }
  
  public void d(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--speedChanged=");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilMap.put("swipe", "1");
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.remove("swipe");
  }
  
  public HashMap<String, String> e()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("face_id", AECameraPrefsUtil.a().a("camera_ad_op_id", "", 4));
    return localHashMap;
  }
  
  public HashMap<String, String> e(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    String str;
    if ((paramInt >= 1) && (paramInt <= 2)) {
      str = String.valueOf(paramInt);
    } else {
      str = "none";
    }
    localHashMap.put("api_level", str);
    return localHashMap;
  }
  
  public HashMap<String, String> e(String paramString)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("face_id", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(UserAction.getQIMEI());
    localHashMap.put("face_uin", localStringBuilder.toString());
    return localHashMap;
  }
  
  public void e()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public void e(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void e(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void e(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--enhanced=");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilMap.put("is_enhance", "1");
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.remove("is_enhance");
  }
  
  public HashMap<String, String> f()
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("face_id", this.jdField_d_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("");
    localHashMap.put("is_sort_icon", localStringBuilder.toString());
    return localHashMap;
  }
  
  public HashMap<String, String> f(String paramString)
  {
    return AEBaseDataUtil.a(i(), a(paramString, "3"));
  }
  
  public void f()
  {
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_j_of_type_JavaLangString = null;
  }
  
  public void f(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void f(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_j_of_type_Long = 2L;
      return;
    }
    this.jdField_j_of_type_Long = 1L;
  }
  
  public HashMap<String, String> g()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("face_id", this.jdField_d_of_type_JavaLangString);
    return localHashMap;
  }
  
  public HashMap<String, String> g(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_b_of_type_Long));
    localHashMap.put("filter_id", paramString);
    return localHashMap;
  }
  
  public void g()
  {
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void g(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void g(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_k_of_type_Long = 2L;
      return;
    }
    this.jdField_k_of_type_Long = 1L;
  }
  
  public HashMap<String, String> h()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", AEBaseDataUtil.a(Long.valueOf(a())));
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
    if (this.jdField_d_of_type_Long == 0L) {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void h(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--sticker=");
    localStringBuilder.append(paramString);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaUtilMap.put("sticker", paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.remove("sticker");
  }
  
  public HashMap<String, String> i()
  {
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(QQStoryContext.a().getAccount());
      ((StringBuilder)localObject).append(AEBaseDataUtil.a());
      localObject = MD5Utils.toMD5(((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = this.jdField_j_of_type_JavaLangString;
    }
    return a((String)localObject, 1, "-1");
  }
  
  public HashMap<String, String> i(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("text_content", paramString);
    p(paramString);
    return localHashMap;
  }
  
  public void i()
  {
    if (this.jdField_e_of_type_Long == 0L) {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void i(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--text=");
    localStringBuilder.append(paramString);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaUtilMap.put("text", paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.remove("text");
  }
  
  public HashMap<String, String> j()
  {
    HashMap localHashMap = a().i();
    if (localHashMap != null) {
      localHashMap.remove("edit_json");
    }
    return localHashMap;
  }
  
  public HashMap<String, String> j(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", paramString);
    return localHashMap;
  }
  
  public void j()
  {
    if (this.jdField_f_of_type_Long == 0L) {
      this.jdField_f_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void j(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--mark=");
    localStringBuilder.append(paramString);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaUtilMap.put("mark", paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.remove("mark");
  }
  
  public HashMap<String, String> k()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("face_id", this.jdField_d_of_type_JavaLangString);
    localHashMap.put("face_tab", this.jdField_g_of_type_JavaLangString);
    localHashMap.put("face_index", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("face_uin", this.jdField_h_of_type_JavaLangString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("");
    localHashMap.put("pic_from", ((StringBuilder)localObject).toString());
    localObject = new JSONObject(this.jdField_a_of_type_JavaUtilMap).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDownloadBtnParam---editJsonStr=");
    localStringBuilder.append((String)localObject);
    QLog.d("AEBaseReportParam", 1, localStringBuilder.toString());
    localHashMap.put("edit_json", localObject);
    return localHashMap;
  }
  
  public HashMap<String, String> k(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", this.jdField_k_of_type_JavaLangString);
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
    this.jdField_h_of_type_Long = System.currentTimeMillis();
  }
  
  public void k(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--graffiti=");
    localStringBuilder.append(paramString);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaUtilMap.put("graffiti", paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.remove("graffiti");
  }
  
  public HashMap<String, String> l()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", jdField_h_of_type_JavaLangLong.toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("");
    localHashMap.put("pic_from", localStringBuilder.toString());
    return localHashMap;
  }
  
  public HashMap<String, String> l(@NonNull String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("watermark_id", paramString);
    return localHashMap;
  }
  
  public void l()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_JavaLangString);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    this.o = MD5.a(localStringBuilder.toString());
  }
  
  public void l(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditJson--music=");
    localStringBuilder.append(paramString);
    AEQLog.a("AEBaseReportParam", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaUtilMap.put("music", paramString);
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.remove("music");
  }
  
  public HashMap<String, String> m()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_Long));
    localHashMap.put("content_type", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_b_of_type_Long));
    localHashMap.put("MD5", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_d_of_type_JavaLangString;
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    String str1 = "none";
    if (bool) {
      localObject = "none";
    }
    localHashMap.put("filter_id", localObject);
    localHashMap.put("filter_value", String.valueOf((int)this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_Float));
    localHashMap.put("music_id", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_e_of_type_JavaLangString);
    String str2 = (String)this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_AndroidUtilSparseArray.get(0);
    localObject = str2;
    if (TextUtils.isEmpty(str2)) {
      localObject = "none";
    }
    localHashMap.put("color_type", localObject);
    str2 = (String)this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_b_of_type_AndroidUtilSparseArray.get(0);
    localObject = str2;
    if (TextUtils.isEmpty(str2)) {
      localObject = "none";
    }
    localHashMap.put("text_item_id", localObject);
    localHashMap.put("sound_type", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_Int));
    localHashMap.put("text_count", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_d_of_type_Int));
    localHashMap.put("music_list", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_g_of_type_JavaLangString);
    localHashMap.put("video_id", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_JavaLangString);
    localHashMap.put("music_common_info", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_f_of_type_JavaLangString);
    localHashMap.put("lyric_status", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_g_of_type_Int));
    if (this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_Boolean) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("is_recommend", localObject);
    localHashMap.put("recommend_index", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_b_of_type_Int));
    localHashMap.put("music_duration", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_c_of_type_Int));
    localHashMap.put("video_duration", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_Long));
    localHashMap.put("video_source", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_e_of_type_Int));
    localHashMap.put("face_id", this.jdField_d_of_type_JavaLangString);
    localHashMap.put("change_speed_type", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_Double));
    localObject = AEMaterialManager.b();
    if (localObject == null) {
      localObject = str1;
    } else {
      localObject = ((AEMaterialMetaData)localObject).jdField_k_of_type_JavaLangString;
    }
    localHashMap.put("watermark_id", localObject);
    return localHashMap;
  }
  
  public HashMap<String, String> m(@NonNull String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("gps", paramString);
    return localHashMap;
  }
  
  public void m()
  {
    this.jdField_j_of_type_Long = 1L;
    this.jdField_k_of_type_Long = 1L;
  }
  
  public void m(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public HashMap<String, String> n()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_b_of_type_Long));
    localHashMap.put("red_point", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_i_of_type_Int));
    return localHashMap;
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData = new AEEditReportData();
  }
  
  public void n(String paramString)
  {
    this.jdField_g_of_type_JavaLangString = paramString;
  }
  
  public HashMap<String, String> o()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("video_id", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_JavaLangString);
    return localHashMap;
  }
  
  public void o(String paramString)
  {
    this.l = paramString;
  }
  
  public HashMap<String, String> p()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("music_id", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_e_of_type_JavaLangString);
    localHashMap.put("music_list", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_g_of_type_JavaLangString);
    localHashMap.put("video_id", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_JavaLangString);
    String str;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_Boolean) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("is_recommend", str);
    localHashMap.put("recommend_index", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_b_of_type_Int));
    localHashMap.put("music_duration", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_c_of_type_Int));
    localHashMap.put("video_duration", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_Long));
    localHashMap.put("video_source", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_e_of_type_Int));
    return localHashMap;
  }
  
  public void p(String paramString)
  {
    this.m = paramString;
  }
  
  public HashMap<String, String> q()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("music_id", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_e_of_type_JavaLangString);
    localHashMap.put("video_id", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_JavaLangString);
    localHashMap.put("lyric_status", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_g_of_type_Int));
    return localHashMap;
  }
  
  public void q(String paramString)
  {
    this.n = paramString;
  }
  
  public HashMap<String, String> r()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_b_of_type_Long));
    localHashMap.put("video_id", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_JavaLangString);
    localHashMap.put("video_source", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_e_of_type_Int));
    localHashMap.put("video_duration", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_a_of_type_Long));
    return localHashMap;
  }
  
  public void r(String paramString)
  {
    this.jdField_k_of_type_JavaLangString = paramString;
  }
  
  public HashMap<String, String> s()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("color_type", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_h_of_type_JavaLangString);
    localHashMap.put("text_item_id", this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_i_of_type_JavaLangString);
    localHashMap.put("common_color_list", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_h_of_type_Int));
    return localHashMap;
  }
  
  public void s(String paramString)
  {
    this.p = paramString;
  }
  
  public HashMap<String, String> t()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeReportAEEditReportData.jdField_b_of_type_Long));
    return localHashMap;
  }
  
  public HashMap<String, String> u()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("content_type", jdField_h_of_type_JavaLangLong.toString());
    return localHashMap;
  }
  
  public HashMap<String, String> v()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration_first_frame", AEBaseDataUtil.a(Long.valueOf(this.jdField_d_of_type_Long - this.jdField_c_of_type_Long)));
    localHashMap.put("duration_bottom_bar", AEBaseDataUtil.a(Long.valueOf(this.jdField_e_of_type_Long - this.jdField_c_of_type_Long)));
    localHashMap.put("duration_photo_btn", AEBaseDataUtil.a(Long.valueOf(this.jdField_f_of_type_Long - this.jdField_c_of_type_Long)));
    String str;
    if (AEBaseDataUtil.b()) {
      str = "first_launch";
    } else if (this.jdField_c_of_type_Boolean) {
      str = "cold_launch";
    } else {
      str = "warm_launch";
    }
    localHashMap.put("launch_type", str);
    return localHashMap;
  }
  
  public HashMap<String, String> w()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("OpenGL", GLCapabilities.getGlesVersion());
    localHashMap.put("shader", String.valueOf(GLCapabilities.isFilamentShaderCompileSucceed()));
    return localHashMap;
  }
  
  public HashMap<String, String> x()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_h_of_type_Long;
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", AEBaseDataUtil.a(Long.valueOf(l1 - l2)));
    return localHashMap;
  }
  
  public HashMap<String, String> y()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", AEBaseDataUtil.a(Long.valueOf(this.jdField_i_of_type_Long)));
    localHashMap.put("cutout_type", Long.toString(this.jdField_j_of_type_Long));
    localHashMap.put("countdown_type", Long.toString(this.jdField_k_of_type_Long));
    Object localObject = new DecimalFormat("0.00").format(this.jdField_c_of_type_Int / 100.0F);
    String str = new DecimalFormat("0.00").format(this.jdField_d_of_type_Int / 100.0F);
    localHashMap.put("beauty_value", localObject);
    localHashMap.put("facial_value", str);
    localObject = VideoFilterTools.a().c(0);
    if (localObject != null) {
      this.l = ((QIMFilterCategoryItem)localObject).jdField_a_of_type_JavaLangString;
    } else {
      this.l = "none";
    }
    localHashMap.put("filter_id", this.l);
    localHashMap.put("cameraId", AEBaseDataUtil.a(FlowCameraConstant.jdField_a_of_type_Int));
    localHashMap.put("emoticon_id", this.jdField_k_of_type_JavaLangString);
    if (TextUtils.isEmpty(this.p))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.p);
    return localHashMap;
  }
  
  public HashMap<String, String> z()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("emoticon_id", this.jdField_k_of_type_JavaLangString);
    if (TextUtils.isEmpty(this.p))
    {
      localHashMap.put("emo_sort_id", "none");
      return localHashMap;
    }
    localHashMap.put("emo_sort_id", this.p);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.report.AEBaseReportParam
 * JD-Core Version:    0.7.0.1
 */